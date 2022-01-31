package com.tencent.biz.pubaccount.readinjoy.capture;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVideoManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.OldHttpEngine;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorFlowCount;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.io.IOException;
import lif;
import lig;
import lih;

public class ReadInJoyVideoDownloadManager
{
  private ReadInJoyVideoDownloadManager.VideoDownloadCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyVideoDownloadManager$VideoDownloadCallback;
  private HttpNetReq jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = new HttpNetReq();
  private OldHttpEngine jdField_a_of_type_ComTencentMobileqqTransfileOldHttpEngine;
  private IHttpCommunicatorFlowCount jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorFlowCount = new lif(this);
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  private String d;
  
  public ReadInJoyVideoDownloadManager(String paramString, ReadInJoyVideoDownloadManager.VideoDownloadCallback paramVideoDownloadCallback)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyVideoDownloadManager$VideoDownloadCallback = paramVideoDownloadCallback;
    this.b = AppConstants.ck;
    this.c = (this.b + this.jdField_a_of_type_JavaLangString);
    paramString = new HttpCommunicator(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorFlowCount, 128);
    paramString.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileOldHttpEngine = new OldHttpEngine(paramString, true);
    paramString = new File(this.b);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = new HttpNetReq();
    this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new lih(this);
    this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.c = this.c;
    this.jdField_a_of_type_ComTencentMobileqqTransfileOldHttpEngine.a(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq != null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileOldHttpEngine.b(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
    }
    if ((!TextUtils.isEmpty(this.d)) && (new File(this.d).exists()))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyVideoDownloadManager$VideoDownloadCallback != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyVideoDownloadManager$VideoDownloadCallback.a(this.jdField_a_of_type_JavaLangString, this.d, true);
      }
      return;
    }
    ThirdVideoManager.a().a(this.jdField_a_of_type_JavaLangString, "PubAccountArticleCenter.GetUrlByVid", new lig(this));
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    for (;;)
    {
      return false;
      File localFile = new File(this.b);
      if ((localFile.exists()) && (localFile.isDirectory()))
      {
        Object localObject = localFile.listFiles();
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localFile = localObject[i];
          if (localFile.getName().contains(this.jdField_a_of_type_JavaLangString))
          {
            localObject = localFile.getName().split("_");
            if ((localObject != null) && (localObject.length == 2)) {
              try
              {
                String str = MD5FileUtil.a(localFile);
                if ((!TextUtils.isEmpty(str)) && (str.equals(localObject[1])))
                {
                  this.d = localFile.getAbsolutePath();
                  return true;
                }
              }
              catch (IOException localIOException)
              {
                localIOException.printStackTrace();
              }
            }
            localFile.delete();
            return false;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyVideoDownloadManager
 * JD-Core Version:    0.7.0.1
 */