package com.tencent.biz.pubaccount.util;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.LebaIconDownloader.IDownloadListener;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class PublicAccountConfigUtil$PublicAccountDownloadListener
  implements LebaIconDownloader.IDownloadListener
{
  PublicAccountConfigUtil.PublicAccountConfigFolder jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountConfigUtil$PublicAccountConfigFolder = null;
  String jdField_a_of_type_JavaLangString = "";
  WeakReference jdField_a_of_type_JavaLangRefWeakReference = null;
  
  public PublicAccountConfigUtil$PublicAccountDownloadListener(PublicAccountConfigUtil.PublicAccountConfigFolder paramPublicAccountConfigFolder, QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountConfigUtil$PublicAccountConfigFolder = paramPublicAccountConfigFolder;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(int paramInt, String paramString, Drawable paramDrawable, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfigUtil", 2, "PublicAccountConfigFolder IDownloadListener fail, status: " + paramInt + " | icon: " + paramDrawable + " | mFolder: " + this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountConfigUtil$PublicAccountConfigFolder);
    }
    if ((paramInt == 2) && (paramDrawable != null) && (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountConfigUtil$PublicAccountConfigFolder != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountConfigUtil$PublicAccountConfigFolder.a = paramDrawable;
    }
    try
    {
      ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(1).a(4, true, new Object[] { this.jdField_a_of_type_JavaLangString });
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PublicAccountConfigUtil", 2, "PublicAccountConfigFolder IDownloadListener fail", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountConfigUtil.PublicAccountDownloadListener
 * JD-Core Version:    0.7.0.1
 */