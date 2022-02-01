package com.tencent.biz.pubaccount.readinjoy.capture;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceStatus.ISVConfig;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResManager;
import dov.com.qq.im.ae.download.AEResManager.AEDownloadCallBack;
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.ArrayList;

public class ReadInJoyCameraCaptureSoManager
  implements ShortVideoResourceManager.INet_ShortVideoResource, ShortVideoResourceStatus.ISVConfig, AEResManager.AEDownloadCallBack
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ReadInJoyCameraCaptureSoManager.Callback jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraCaptureSoManager$Callback;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b = false;
  private boolean c = false;
  
  public ReadInJoyCameraCaptureSoManager(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (AEResUtil.a(AEResInfo.jdField_b_of_type_DovComQqImAeDownloadAEResInfo) != 0) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
      bool = false;
    }
  }
  
  private void a(int paramInt)
  {
    b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraCaptureSoManager$Callback != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraCaptureSoManager$Callback.a(paramInt);
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      AEResManager.a().a(this);
    }
  }
  
  private void c()
  {
    if ((this.b) && ((this.c) || (!this.jdField_a_of_type_Boolean))) {
      a(1);
    }
  }
  
  public void a()
  {
    ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
  }
  
  public void a(ReadInJoyCameraCaptureSoManager.Callback paramCallback)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraCaptureSoManager$Callback = paramCallback;
  }
  
  public void onAEDownloadFinish(AEResInfo paramAEResInfo, String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramAEResInfo.jdField_b_of_type_JavaLangString.equals(AEResInfo.jdField_b_of_type_DovComQqImAeDownloadAEResInfo.jdField_b_of_type_JavaLangString))
    {
      if (paramInt != 0)
      {
        AEQLog.d("ReadInJoyCameraCaptureSoManager", "[onAEDownloadFinish] error :" + paramInt);
        a(3);
      }
    }
    else {
      return;
    }
    AEQLog.d("ReadInJoyCameraCaptureSoManager", "[onAEDownloadFinish] success");
    this.c = true;
    c();
  }
  
  public void onAEProgressUpdate(AEResInfo paramAEResInfo, long paramLong1, long paramLong2) {}
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    int j = 0;
    int k = 1;
    VideoEnvironment.LogDownLoad("ReadInJoyCameraCaptureSoManager", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    int i;
    if (paramInt1 != 1)
    {
      i = k;
      if (paramInt1 != 0) {}
    }
    else
    {
      if (paramInt2 == 0) {
        break label69;
      }
      i = k;
    }
    if (i != 0) {
      a(3);
    }
    return;
    label69:
    ArrayList localArrayList = new ArrayList(1);
    if (ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList) == 0)
    {
      ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
      if ((AEResUtil.a(AEResInfo.jdField_b_of_type_DovComQqImAeDownloadAEResInfo) == 2) || (AEResUtil.a(AEResInfo.c) == 2))
      {
        if (AEResUtil.a(AEResInfo.jdField_b_of_type_DovComQqImAeDownloadAEResInfo) == 2) {
          AEResManager.a().a(AEResInfo.jdField_b_of_type_DovComQqImAeDownloadAEResInfo, this, false);
        }
        paramInt1 = j;
        if (AEResUtil.a(AEResInfo.c) == 2)
        {
          AEResManager.a().a(AEResInfo.c, this, false);
          paramInt1 = j;
        }
      }
    }
    for (;;)
    {
      i = paramInt1;
      break;
      this.c = true;
      VideoEnvironment.LogDownLoad("ReadInJoyCameraCaptureSoManager", "onConfigResult| getFilterSoState != 2", null);
      paramInt1 = j;
      continue;
      paramInt1 = 1;
    }
  }
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt == 0) {
        break label62;
      }
      a(3);
    }
    for (;;)
    {
      VideoEnvironment.LogDownLoad("ReadInJoyCameraCaptureSoManager", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      return;
      label62:
      this.b = true;
      c();
    }
  }
  
  public void onNetWorkNone()
  {
    VideoEnvironment.LogDownLoad("ReadInJoyCameraCaptureSoManager", "onNetWorkNone", null);
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureSoManager
 * JD-Core Version:    0.7.0.1
 */