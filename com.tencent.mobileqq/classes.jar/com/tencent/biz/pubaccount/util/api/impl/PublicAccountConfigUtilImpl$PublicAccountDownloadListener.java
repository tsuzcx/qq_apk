package com.tencent.biz.pubaccount.util.api.impl;

import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil.PublicAccountConfigFolder;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.LebaIconDownloader.IDownloadListener;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class PublicAccountConfigUtilImpl$PublicAccountDownloadListener
  implements LebaIconDownloader.IDownloadListener
{
  IPublicAccountConfigUtil.PublicAccountConfigFolder jdField_a_of_type_ComTencentBizPubaccountUtilApiIPublicAccountConfigUtil$PublicAccountConfigFolder = null;
  String jdField_a_of_type_JavaLangString = "";
  WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference = null;
  
  public PublicAccountConfigUtilImpl$PublicAccountDownloadListener(IPublicAccountConfigUtil.PublicAccountConfigFolder paramPublicAccountConfigFolder, AppInterface paramAppInterface, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountUtilApiIPublicAccountConfigUtil$PublicAccountConfigFolder = paramPublicAccountConfigFolder;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(int paramInt, String paramString, Drawable paramDrawable, Object... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("PublicAccountConfigFolder IDownloadListener fail, status: ");
      paramString.append(paramInt);
      paramString.append(" | icon: ");
      paramString.append(paramDrawable);
      paramString.append(" | mFolder: ");
      paramString.append(this.jdField_a_of_type_ComTencentBizPubaccountUtilApiIPublicAccountConfigUtil$PublicAccountConfigFolder);
      QLog.d("PublicAccountConfigUtil", 2, paramString.toString());
    }
    if ((paramInt == 2) && (paramDrawable != null))
    {
      paramString = this.jdField_a_of_type_ComTencentBizPubaccountUtilApiIPublicAccountConfigUtil$PublicAccountConfigFolder;
      if (paramString != null)
      {
        paramString.a(paramDrawable);
        try
        {
          ((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getBusinessHandler(BusinessHandlerFactory.AVATAR_HANDLER).notifyUI(1, true, new Object[] { this.jdField_a_of_type_JavaLangString });
          return;
        }
        catch (Exception paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PublicAccountConfigUtil", 2, "PublicAccountConfigFolder IDownloadListener fail", paramString);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl.PublicAccountDownloadListener
 * JD-Core Version:    0.7.0.1
 */