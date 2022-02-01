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
  IPublicAccountConfigUtil.PublicAccountConfigFolder a = null;
  WeakReference<AppInterface> b = null;
  String c = "";
  
  public PublicAccountConfigUtilImpl$PublicAccountDownloadListener(IPublicAccountConfigUtil.PublicAccountConfigFolder paramPublicAccountConfigFolder, AppInterface paramAppInterface, String paramString)
  {
    this.a = paramPublicAccountConfigFolder;
    this.b = new WeakReference(paramAppInterface);
    this.c = paramString;
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
      paramString.append(this.a);
      QLog.d("PublicAccountConfigUtil", 2, paramString.toString());
    }
    if ((paramInt == 2) && (paramDrawable != null))
    {
      paramString = this.a;
      if (paramString != null)
      {
        paramString.a(paramDrawable);
        try
        {
          ((AppInterface)this.b.get()).getBusinessHandler(BusinessHandlerFactory.AVATAR_HANDLER).notifyUI(1, true, new Object[] { this.c });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl.PublicAccountDownloadListener
 * JD-Core Version:    0.7.0.1
 */