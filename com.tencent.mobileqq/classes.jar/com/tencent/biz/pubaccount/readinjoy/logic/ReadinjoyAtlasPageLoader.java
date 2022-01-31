package com.tencent.biz.pubaccount.readinjoy.logic;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xb2d.cmd0xb2d.PageReq;
import tencent.im.oidb.cmd0xb2d.cmd0xb2d.ReqBody;
import tencent.im.oidb.cmd0xb2d.cmd0xb2d.RspBody;
import tencent.im.oidb.gallery.gallery.GalleryInfo;

public class ReadinjoyAtlasPageLoader
  extends ProtoUtils.AppProtocolObserver
{
  public static int a;
  private static int c = 50;
  private ReadInJoyAtlasManager.AtlasCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback;
  private ByteStringMicro jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = ByteStringMicro.EMPTY;
  private String jdField_a_of_type_JavaLangString;
  private boolean b;
  private int d;
  
  static
  {
    jdField_a_of_type_Int = -1000;
  }
  
  public ReadinjoyAtlasPageLoader(String paramString, ReadInJoyAtlasManager.AtlasCallback paramAtlasCallback)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new RuntimeException("ReadinjoyAtlasPageLoader(). rowKey can not be null.");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback = paramAtlasCallback;
  }
  
  public static boolean a(gallery.GalleryInfo paramGalleryInfo)
  {
    if (!paramGalleryInfo.uint32_end_flag.has()) {}
    while (paramGalleryInfo.uint32_end_flag.get() == 1) {
      return true;
    }
    return false;
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.atlas._ReadinjoyAtlasPageLoader", 2, "start fetchAtlasList pageIndex:" + this.d);
    }
    cmd0xb2d.ReqBody localReqBody = new cmd0xb2d.ReqBody();
    localReqBody.bytes_gallery_rowkey.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    localReqBody.int32_source.set(6);
    Object localObject = new cmd0xb2d.PageReq();
    ((cmd0xb2d.PageReq)localObject).uint32_size.set(c);
    ((cmd0xb2d.PageReq)localObject).bytes_cookies.set(this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro);
    localReqBody.msg_page_req.set((MessageMicro)localObject);
    localReqBody.msg_page_req.setHasFlag(true);
    localObject = BaseApplicationImpl.getApplication().getRuntime();
    Bundle localBundle = new Bundle();
    localBundle.putInt("pageIndex", this.d);
    ProtoUtils.a((AppInterface)localObject, this, localReqBody.toByteArray(), "OidbSvc.0xb2d", 2861, 1, localBundle, 0L);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = ByteStringMicro.EMPTY;
    this.b = false;
    this.d = 1;
    c();
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    int i = paramBundle.getInt("pageIndex");
    if ((paramInt != -1) && (paramArrayOfByte != null))
    {
      if (paramInt == 0) {
        try
        {
          paramBundle = new cmd0xb2d.RspBody();
          paramBundle.mergeFrom(paramArrayOfByte);
          if (paramBundle.msg_gallery_info.has())
          {
            paramArrayOfByte = (gallery.GalleryInfo)paramBundle.msg_gallery_info.get();
            this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = paramArrayOfByte.bytes_cookies.get();
            this.b = a(paramArrayOfByte);
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback == null) {
              return;
            }
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback.a(true, i, paramArrayOfByte);
            return;
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback == null) {
            return;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback.a(false, i, new ReadinjoyAtlasPageLoader.Result(jdField_a_of_type_Int, "proto error"));
          return;
        }
        catch (Exception paramArrayOfByte)
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback != null) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback.a(false, i, new ReadinjoyAtlasPageLoader.Result(jdField_a_of_type_Int, "proto error"));
          }
          QLog.e("Q.readinjoy.atlas._ReadinjoyAtlasPageLoader", 1, "fetchAtlasList onResult(), exception=" + paramArrayOfByte.toString());
          return;
        }
      }
      paramArrayOfByte = null;
      switch (paramInt)
      {
      }
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback.a(false, i, new ReadinjoyAtlasPageLoader.Result(paramInt, paramArrayOfByte));
      return;
      paramArrayOfByte = "阿嘞，内容被外星人带走啦~";
      continue;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback.a(false, i, new ReadinjoyAtlasPageLoader.Result(paramInt, "当前网络不可用，请检查你的网络设置\n点击屏幕刷新"));
      }
    }
  }
  
  public void b()
  {
    this.d += 1;
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.logic.ReadinjoyAtlasPageLoader
 * JD-Core Version:    0.7.0.1
 */