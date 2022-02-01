package com.tencent.mobileqq.apollo.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.apollo.aio.api.ICmShowAioMatcher;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloDrawableExtraInfo;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloActionHelper;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloMessageUtilImpl;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class ApolloMainInfo
  extends ApolloInfo
{
  public Drawable a;
  public Drawable b;
  
  public ApolloMainInfo(String paramString)
  {
    this.mUin = paramString;
    if ((this.a == null) || (this.b == null)) {
      try
      {
        paramString = BaseApplication.getContext().getResources();
        if (paramString != null)
        {
          Bitmap localBitmap1 = (Bitmap)GlobalImageCache.b.get("apolloMainInfoDef");
          Bitmap localBitmap2 = (Bitmap)GlobalImageCache.b.get("apolloMainInfoFail");
          if (localBitmap1 != null)
          {
            this.a = new BitmapDrawable(localBitmap1);
          }
          else
          {
            this.a = paramString.getDrawable(2130837994);
            GlobalImageCache.b.put("apolloMainInfoDef", BitmapFactory.decodeResource(paramString, 2130837994));
          }
          if (localBitmap2 != null)
          {
            this.b = new BitmapDrawable(localBitmap2);
            return;
          }
          this.b = paramString.getDrawable(2130844865);
          GlobalImageCache.b.put("apolloMainInfoFail", BitmapFactory.decodeResource(paramString, 2130844865));
          return;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("[cmshow]ApolloMainInfo", 2, paramString.getMessage());
          return;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("[cmshow]ApolloMainInfo", 2, paramString.getMessage());
        }
      }
    }
  }
  
  private Drawable a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
      localURLDrawableOptions.mFailedDrawable = this.b;
      localURLDrawableOptions.mRequestHeight = ApolloLinearLayout.a;
      localURLDrawableOptions.mRequestWidth = ApolloLinearLayout.a;
      localURLDrawableOptions.mPlayGifImage = false;
      localURLDrawableOptions.mUseMemoryCache = true;
      return URLDrawable.getFileDrawable(paramString, localURLDrawableOptions);
    }
    return this.b;
  }
  
  public String a(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData == null) {
      return "action";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramApolloActionData.actionId);
    localStringBuilder.append("_");
    localStringBuilder.append(paramApolloActionData.actionName);
    return localStringBuilder.toString();
  }
  
  public Drawable getPanelDrawable(Context paramContext, float paramFloat)
  {
    paramContext = this.mAction;
    Object localObject1 = null;
    if (paramContext == null) {
      return null;
    }
    Object localObject2 = Integer.toString(1);
    if (!TextUtils.isEmpty(this.mActionText))
    {
      paramContext = URLDrawable.URLDrawableOptions.obtain();
      localObject1 = new ApolloDrawableExtraInfo();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/");
      ((StringBuilder)localObject2).append(this.mAction.actionId);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("txtImg.png");
      ((ApolloDrawableExtraInfo)localObject1).mLocalPath = ((StringBuilder)localObject2).toString();
      ((ApolloDrawableExtraInfo)localObject1).mDownloadUrl = this.mAction.textImg;
      paramContext.mExtraInfo = localObject1;
      paramContext.mRequestHeight = ApolloLinearLayout.a;
      paramContext.mRequestWidth = ApolloLinearLayout.a;
      localObject1 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(true, ((ApolloDrawableExtraInfo)localObject1).mLocalPath, paramContext, this.mAction.textImg);
      paramContext = (Context)localObject1;
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("decode panel action name =");
        paramContext.append(this.mAction.actionName);
        paramContext.append(" mActionText:");
        paramContext.append(this.mActionText);
        QLog.d("[cmshow]ApolloMainInfo", 2, paramContext.toString());
        return localObject1;
      }
    }
    else
    {
      if (this.mAction.isForPlayerAction == 1)
      {
        localObject1 = ApolloResManagerFacade.a.a(Scene.AIO);
        paramContext = ((IApolloResManager)localObject1).a(this.mAction, 10);
        localObject1 = ((IApolloResManager)localObject1).a(this.mAction, 0);
        if ((!TextUtils.isEmpty(paramContext)) && (new File(paramContext).exists()))
        {
          long l = new File(paramContext).lastModified();
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = a((String)localObject1);
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = ApolloLinearLayout.a;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = ApolloLinearLayout.a;
          ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = false;
          ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = String.valueOf(l);
          localObject1 = URLDrawable.getFileDrawable(paramContext, (URLDrawable.URLDrawableOptions)localObject2);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("path exists get drawable ");
          ((StringBuilder)localObject2).append(paramContext);
          ((StringBuilder)localObject2).append("; b : ");
          ((StringBuilder)localObject2).append(localObject1);
          QLog.i("[cmshow]ApolloMainInfo", 4, ((StringBuilder)localObject2).toString());
          return localObject1;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("path not exists ");
        ((StringBuilder)localObject2).append(paramContext);
        QLog.i("[cmshow]ApolloMainInfo", 4, ((StringBuilder)localObject2).toString());
        return a((String)localObject1);
      }
      try
      {
        paramContext = new URL("apollo_pic", null, a(this.mAction));
      }
      catch (MalformedURLException localMalformedURLException)
      {
        paramContext = (Context)localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d("[cmshow]ApolloMainInfo", 2, "getDrawable ,", localMalformedURLException);
          paramContext = (Context)localObject1;
        }
      }
      if (paramContext == null) {
        return this.a;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("decode panel action name =");
        ((StringBuilder)localObject1).append(this.mAction.actionName);
        QLog.d("[cmshow]ApolloMainInfo", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.b;
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.a;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = ApolloLinearLayout.a;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = ApolloLinearLayout.a;
      ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = false;
      if (this.mAction.isForPlayerAction == 1)
      {
        ((URLDrawable.URLDrawableOptions)localObject1).mUseMemoryCache = false;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = new ColorDrawable(0);
      }
      paramContext = URLDrawable.getDrawable(paramContext, (URLDrawable.URLDrawableOptions)localObject1);
      if (paramContext.getStatus() != 1)
      {
        paramContext.setTag(this.mAction);
        paramContext.addHeader("apollo_uin", this.mUin);
        paramContext.addHeader("apollo_tasks", (String)localObject2);
      }
    }
    return paramContext;
  }
  
  public void send(AppRuntime paramAppRuntime, EditText paramEditText, int paramInt, String paramString1, String paramString2)
  {
    if (this.mAction != null)
    {
      if (!(paramAppRuntime instanceof QQAppInterface)) {
        return;
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)paramAppRuntime;
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("send apolloInfo actionid=");
        paramAppRuntime.append(this.mAction.actionId);
        paramAppRuntime.append(" input =");
        paramAppRuntime.append(paramEditText.getText().toString());
        QLog.d("[cmshow]ApolloMainInfo", 2, paramAppRuntime.toString());
      }
      ApolloMessageUtilImpl.sendApolloMsg(localQQAppInterface, paramInt, paramString1, paramString2, this);
      if (TextUtils.isEmpty(this.mAction.inputText))
      {
        if (!TextUtils.isEmpty(this.mActionText))
        {
          if (this.mTextType == 0)
          {
            paramAppRuntime = "6";
            break label152;
          }
          if (this.mTextType == 1)
          {
            paramAppRuntime = "7";
            break label152;
          }
        }
        paramAppRuntime = "2";
      }
      for (;;)
      {
        label152:
        break;
        if (TextUtils.isEmpty(this.mActionText)) {
          paramAppRuntime = "3";
        } else if (this.mTextType == 0) {
          paramAppRuntime = "4";
        } else if (this.mTextType == 1) {
          paramAppRuntime = "5";
        } else {
          paramAppRuntime = "";
        }
      }
      paramString2 = (ICmShowAioMatcher)QRoute.api(ICmShowAioMatcher.class);
      boolean bool = paramString2.isSupported(paramInt, 1);
      paramEditText = "0";
      int i;
      Object localObject;
      int j;
      if (bool)
      {
        i = Integer.parseInt(paramAppRuntime);
        paramString2 = new StringBuilder();
        paramString2.append("");
        paramString2.append(this.mAction.actionId);
        paramString2 = paramString2.toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("655_");
        ((StringBuilder)localObject).append(this.mPackageId);
        localObject = ((StringBuilder)localObject).toString();
        if (!TextUtils.isEmpty(this.mActionText)) {
          paramEditText = this.mActionText;
        }
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "action_sent", paramString1, i, 0, new String[] { paramString2, localObject, paramEditText, String.valueOf(System.currentTimeMillis() / 1000L) });
      }
      else if ((paramString2.isSupported(paramInt, 2)) && (this.mAction.personNum == 0))
      {
        i = Integer.parseInt(paramAppRuntime);
        j = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(paramInt);
        paramString2 = new StringBuilder();
        paramString2.append("");
        paramString2.append(this.mAction.actionId);
        paramString2 = paramString2.toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("655_");
        ((StringBuilder)localObject).append(this.mPackageId);
        localObject = ((StringBuilder)localObject).toString();
        if (!TextUtils.isEmpty(this.mActionText)) {
          paramEditText = this.mActionText;
        }
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "g_action_single_sent", paramString1, i, j, new String[] { paramString2, localObject, paramEditText, String.valueOf(System.currentTimeMillis() / 1000L) });
      }
      if (this.mPackageId == 9) {
        if (this.mSendSrc == 3) {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "y_gjcbq_success", paramString1, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(paramInt), 0, new String[] { String.valueOf(this.mAction.personNum), String.valueOf(this.mAction.actionId), this.mAction.actionName });
        } else {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "y_bqsuccess", paramString1, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(paramInt), 0, new String[] { String.valueOf(this.mAction.personNum), String.valueOf(this.mAction.actionId) });
        }
      }
      if (((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(localQQAppInterface.getCurrentUin(), localQQAppInterface) == 0)
      {
        j = Integer.parseInt(paramAppRuntime);
        int k = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(paramInt);
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("");
        paramAppRuntime.append(this.mAction.actionId);
        paramAppRuntime = paramAppRuntime.toString();
        i = 1;
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "exp_panelnewuser_send_action", paramString1, j, k, new String[] { paramAppRuntime, "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
        paramAppRuntime = new DtReportParamsBuilder();
        if (this.mAction.actionId <= ApolloConstant.f) {
          i = 0;
        }
        ApolloDtReportUtil.a("panel", "new_user_panel", "click", paramAppRuntime.a(i).b(ApolloDtReportUtil.a(paramInt)).f(String.valueOf(this.mAction.actionId)).c(paramString1).a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloMainInfo
 * JD-Core Version:    0.7.0.1
 */