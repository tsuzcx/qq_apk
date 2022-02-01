package com.tencent.mobileqq.apollo.api.model;

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
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.api.aio.CmShowAioMatcher;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloActionHelper;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.view.pannel.ApolloLinearLayout;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

public class ApolloMainInfo
  extends ApolloInfo
{
  public Drawable mDefault;
  public Drawable mFailed;
  
  public ApolloMainInfo(String paramString)
  {
    this.mUin = paramString;
    if ((this.mDefault == null) || (this.mFailed == null)) {
      try
      {
        paramString = BaseApplication.getContext().getResources();
        if (paramString != null)
        {
          Bitmap localBitmap1 = (Bitmap)GlobalImageCache.a.get("apolloMainInfoDef");
          Bitmap localBitmap2 = (Bitmap)GlobalImageCache.a.get("apolloMainInfoFail");
          if (localBitmap1 != null) {
            this.mDefault = new BitmapDrawable(localBitmap1);
          }
          while (localBitmap2 != null)
          {
            this.mFailed = new BitmapDrawable(localBitmap2);
            return;
            this.mDefault = paramString.getDrawable(2130838121);
            GlobalImageCache.a.put("apolloMainInfoDef", BitmapFactory.decodeResource(paramString, 2130838121));
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("ApolloMainInfo", 2, paramString.getMessage());
          return;
          this.mFailed = paramString.getDrawable(2130843990);
          GlobalImageCache.a.put("apolloMainInfoFail", BitmapFactory.decodeResource(paramString, 2130843990));
          return;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ApolloMainInfo", 2, paramString.getMessage());
        }
      }
    }
  }
  
  private Drawable getpanelPngDrawable(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
      localURLDrawableOptions.mFailedDrawable = this.mFailed;
      localURLDrawableOptions.mRequestHeight = ApolloLinearLayout.c;
      localURLDrawableOptions.mRequestWidth = ApolloLinearLayout.c;
      localURLDrawableOptions.mPlayGifImage = false;
      localURLDrawableOptions.mUseMemoryCache = true;
      return URLDrawable.getFileDrawable(paramString, localURLDrawableOptions);
    }
    return this.mFailed;
  }
  
  public String getFictionPath(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData == null) {
      return "action";
    }
    return paramApolloActionData.actionId + "_" + paramApolloActionData.actionName;
  }
  
  public Drawable getPanelDrawable(Context paramContext, float paramFloat)
  {
    Object localObject1 = null;
    paramContext = null;
    if (this.mAction == null) {}
    Object localObject2;
    do
    {
      do
      {
        return paramContext;
        localObject2 = Integer.toString(1);
        if (TextUtils.isEmpty(this.mActionText)) {
          break;
        }
        paramContext = URLDrawable.URLDrawableOptions.obtain();
        localObject1 = new ApolloDrawableExtraInfo();
        ((ApolloDrawableExtraInfo)localObject1).mLocalPath = ("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/" + this.mAction.actionId + File.separator + "txtImg.png");
        ((ApolloDrawableExtraInfo)localObject1).mDownloadUrl = this.mAction.textImg;
        paramContext.mExtraInfo = localObject1;
        paramContext.mRequestHeight = ApolloLinearLayout.c;
        paramContext.mRequestWidth = ApolloLinearLayout.c;
        localObject1 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(true, ((ApolloDrawableExtraInfo)localObject1).mLocalPath, paramContext, this.mAction.textImg);
        paramContext = (Context)localObject1;
      } while (!QLog.isColorLevel());
      QLog.d("ApolloMainInfo", 2, "decode panel action name =" + this.mAction.actionName + " mActionText:" + this.mActionText);
      return localObject1;
      if (this.mAction.isForPlayerAction == 1)
      {
        paramContext = ApolloUtilImpl.getApolloResPath(this.mAction, 10);
        localObject1 = ApolloUtilImpl.getApolloResPath(this.mAction, 0);
        if ((!TextUtils.isEmpty(paramContext)) && (new File(paramContext).exists()))
        {
          long l = new File(paramContext).lastModified();
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = getpanelPngDrawable((String)localObject1);
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = ApolloLinearLayout.c;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = ApolloLinearLayout.c;
          ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = false;
          ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = String.valueOf(l);
          localObject1 = URLDrawable.getFileDrawable(paramContext, (URLDrawable.URLDrawableOptions)localObject2);
          QLog.i("ApolloMainInfo", 4, "path exists get drawable " + paramContext + "; b : " + localObject1);
          return localObject1;
        }
        QLog.i("ApolloMainInfo", 4, "path not exists " + paramContext);
        return getpanelPngDrawable((String)localObject1);
      }
      try
      {
        paramContext = new URL("apollo_pic", null, getFictionPath(this.mAction));
        if (paramContext == null) {
          return this.mDefault;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          paramContext = (Context)localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloMainInfo", 2, "getDrawable ,", localMalformedURLException);
            paramContext = (Context)localObject1;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloMainInfo", 2, "decode panel action name =" + this.mAction.actionName);
        }
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.mFailed;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.mDefault;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = ApolloLinearLayout.c;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = ApolloLinearLayout.c;
        ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = false;
        if (this.mAction.isForPlayerAction == 1)
        {
          ((URLDrawable.URLDrawableOptions)localObject1).mUseMemoryCache = false;
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = new ColorDrawable(0);
        }
        localObject1 = URLDrawable.getDrawable(paramContext, (URLDrawable.URLDrawableOptions)localObject1);
        paramContext = (Context)localObject1;
      }
    } while (((URLDrawable)localObject1).getStatus() == 1);
    ((URLDrawable)localObject1).setTag(this.mAction);
    ((URLDrawable)localObject1).addHeader("apollo_uin", this.mUin);
    ((URLDrawable)localObject1).addHeader("apollo_tasks", (String)localObject2);
    return localObject1;
  }
  
  public void send(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    if ((this.mAction == null) || (paramQQAppInterface == null) || (paramSessionInfo == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloMainInfo", 2, "send apolloInfo actionid=" + this.mAction.actionId + " input =" + paramEditText.getText().toString());
    }
    ChatActivityFacade.a(paramQQAppInterface, paramContext, paramSessionInfo, this);
    paramContext = "";
    if (TextUtils.isEmpty(this.mAction.inputText))
    {
      paramEditText = "2";
      paramContext = paramEditText;
      if (TextUtils.isEmpty(this.mActionText)) {
        break label886;
      }
      if (this.mTextType == 0) {
        paramContext = "6";
      }
    }
    label215:
    label358:
    label878:
    label880:
    label886:
    for (;;)
    {
      label123:
      String str1;
      String str2;
      String str3;
      if (CmShowAioMatcher.a(paramSessionInfo.jdField_a_of_type_Int, 1))
      {
        str1 = paramSessionInfo.jdField_a_of_type_JavaLangString;
        i = Integer.parseInt(paramContext);
        str2 = "" + this.mAction.actionId;
        str3 = "655_" + this.mPackageId;
        if (TextUtils.isEmpty(this.mActionText))
        {
          paramEditText = "0";
          VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "action_sent", str1, i, 0, new String[] { str2, str3, paramEditText, String.valueOf(System.currentTimeMillis() / 1000L) });
          if (this.mPackageId == 9)
          {
            if (this.mSendSrc != 3) {
              break label810;
            }
            VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "y_gjcbq_success", paramSessionInfo.jdField_a_of_type_JavaLangString, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(paramSessionInfo.jdField_a_of_type_Int), 0, new String[] { String.valueOf(this.mAction.personNum), String.valueOf(this.mAction.actionId), this.mAction.actionName });
          }
          if (((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(paramQQAppInterface.getCurrentUin(), paramQQAppInterface) != 0) {
            break label878;
          }
          VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "exp_panelnewuser_send_action", paramSessionInfo.jdField_a_of_type_JavaLangString, Integer.parseInt(paramContext), ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(paramSessionInfo.jdField_a_of_type_Int), new String[] { "" + this.mAction.actionId, "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
          paramQQAppInterface = new ApolloDtReportUtil.DtReportParamsBuilder();
          if (this.mAction.actionId <= ApolloConstant.b) {
            break label880;
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        ApolloDtReportUtil.a("panel", "new_user_panel", "click", paramQQAppInterface.a(i).b(ApolloDtReportUtil.a(paramSessionInfo.jdField_a_of_type_Int)).c(String.valueOf(this.mAction.actionId)).b(paramSessionInfo.jdField_a_of_type_JavaLangString).a());
        return;
        paramContext = paramEditText;
        if (this.mTextType != 1) {
          break label886;
        }
        paramContext = "7";
        break label123;
        if (TextUtils.isEmpty(this.mActionText))
        {
          paramContext = "3";
          break label123;
        }
        if (this.mTextType == 0)
        {
          paramContext = "4";
          break label123;
        }
        if (this.mTextType != 1) {
          break label886;
        }
        paramContext = "5";
        break label123;
        paramEditText = this.mActionText;
        break label215;
        if ((!CmShowAioMatcher.a(paramSessionInfo.jdField_a_of_type_Int, 2)) || (this.mAction.personNum != 0)) {
          break label264;
        }
        str1 = paramSessionInfo.jdField_a_of_type_JavaLangString;
        i = Integer.parseInt(paramContext);
        int j = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(paramSessionInfo.jdField_a_of_type_Int);
        str2 = "" + this.mAction.actionId;
        str3 = "655_" + this.mPackageId;
        if (TextUtils.isEmpty(this.mActionText)) {}
        for (paramEditText = "0";; paramEditText = this.mActionText)
        {
          VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "g_action_single_sent", str1, i, j, new String[] { str2, str3, paramEditText, String.valueOf(System.currentTimeMillis() / 1000L) });
          break;
        }
        VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "y_bqsuccess", paramSessionInfo.jdField_a_of_type_JavaLangString, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(paramSessionInfo.jdField_a_of_type_Int), 0, new String[] { String.valueOf(this.mAction.personNum), String.valueOf(this.mAction.actionId) });
        break label358;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.model.ApolloMainInfo
 * JD-Core Version:    0.7.0.1
 */