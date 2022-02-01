package com.tencent.biz.pubaccount.readinjoy.logic;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0xbe0.cmd0xbe0.MoreGallery;
import tencent.im.oidb.cmd0xbe0.cmd0xbe0.NextGallery;
import tencent.im.oidb.cmd0xbe0.cmd0xbe0.RspBody;
import tencent.im.oidb.gallery.gallery.GalleryInfo;

class ReadInJoyAtlasManager$4
  extends ProtoUtils.AppProtocolObserver
{
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReadInJoyAtlasManager.jdField_a_of_type_JavaLangString, 2, "fetchAtlas0xbe0 onResult, errorCode=" + paramInt);
    }
    if ((paramInt != -1) && (paramArrayOfByte != null))
    {
      try
      {
        cmd0xbe0.RspBody localRspBody = new cmd0xbe0.RspBody();
        localRspBody.mergeFrom(paramArrayOfByte);
        paramBundle = null;
        paramArrayOfByte = paramBundle;
        if (localRspBody.msg_more_gallery.has())
        {
          paramArrayOfByte = paramBundle;
          if (localRspBody.msg_more_gallery.rpt_msg_gallery_info.has()) {
            paramArrayOfByte = localRspBody.msg_more_gallery.rpt_msg_gallery_info.get();
          }
        }
        Object localObject1 = null;
        paramBundle = (Bundle)localObject1;
        if (localRspBody.msg_next_gallery.has())
        {
          paramBundle = (Bundle)localObject1;
          if (localRspBody.msg_next_gallery.msg_gallery_info.has()) {
            paramBundle = (gallery.GalleryInfo)localRspBody.msg_next_gallery.msg_gallery_info.get();
          }
        }
        Object localObject2 = null;
        localObject1 = localObject2;
        if (localRspBody.msg_next_gallery.has())
        {
          localObject1 = localObject2;
          if (localRspBody.msg_next_gallery.rpt_msg_gallery_info.has()) {
            localObject1 = localRspBody.msg_next_gallery.rpt_msg_gallery_info.get();
          }
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallbackImpl != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallbackImpl.a(true, this.jdField_a_of_type_JavaLangString, paramArrayOfByte, paramBundle, (List)localObject1, paramInt);
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallbackImpl != null) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallbackImpl.a(false, this.jdField_a_of_type_JavaLangString, null, null, null, paramInt);
          }
          QLog.e(ReadInJoyAtlasManager.jdField_a_of_type_JavaLangString, 1, "fetchAtlas0xbe0 onResult(), exception=" + paramArrayOfByte.toString());
        }
      }
      paramArrayOfByte = GalleryReportedUtils.a(BaseApplication.getContext(), paramInt, "0xbe0");
      paramBundle = StatisticCollector.getInstance(BaseApplication.getContext());
      if (paramInt != 0) {
        break label348;
      }
    }
    label348:
    for (boolean bool = true;; bool = false)
    {
      paramBundle.collectPerformance(null, "ReadinjoyAtlasRequest", bool, -1L, -1L, paramArrayOfByte, "", true);
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallbackImpl == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallbackImpl.a(false, this.jdField_a_of_type_JavaLangString, null, null, null, paramInt);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager.4
 * JD-Core Version:    0.7.0.1
 */