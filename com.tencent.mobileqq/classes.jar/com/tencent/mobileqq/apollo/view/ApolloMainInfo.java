package com.tencent.mobileqq.apollo.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.store.ApolloImageDownloader;
import com.tencent.mobileqq.apollo.store.ApolloImageDownloader.ApolloDrawableExtraInfo;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class ApolloMainInfo
  extends ApolloInfo
{
  public static Drawable a;
  public static Drawable b;
  
  public ApolloMainInfo(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if ((jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (jdField_b_of_type_AndroidGraphicsDrawableDrawable == null)) {}
    try
    {
      paramString = BaseApplication.getContext().getResources();
      if (paramString != null)
      {
        jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramString.getDrawable(2130837571);
        jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramString.getDrawable(2130841377);
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ApolloMainInfo", 2, paramString.getMessage());
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ApolloMainInfo", 2, paramString.getMessage());
    }
  }
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    Object localObject = null;
    paramContext = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData == null) {}
    String str;
    do
    {
      do
      {
        return paramContext;
        if (this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.status == 0) {
          return jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        }
        str = Integer.toString(1);
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          break;
        }
        paramContext = URLDrawable.URLDrawableOptions.obtain();
        localObject = new ApolloImageDownloader.ApolloDrawableExtraInfo();
        ((ApolloImageDownloader.ApolloDrawableExtraInfo)localObject).jdField_a_of_type_JavaLangString = (ApolloConstant.c + this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId + File.separator + "txtImg.png");
        ((ApolloImageDownloader.ApolloDrawableExtraInfo)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.textImg;
        paramContext.mExtraInfo = localObject;
        paramContext.mRequestHeight = ApolloLinearLayout.e;
        paramContext.mRequestWidth = ApolloLinearLayout.e;
        localObject = ApolloImageDownloader.a(true, ((ApolloImageDownloader.ApolloDrawableExtraInfo)localObject).jdField_a_of_type_JavaLangString, paramContext, this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.textImg);
        paramContext = (Context)localObject;
      } while (!QLog.isColorLevel());
      QLog.d("ApolloMainInfo", 2, "decode panel action name =" + this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionName + " mActionText:" + this.jdField_b_of_type_JavaLangString);
      return localObject;
      try
      {
        paramContext = new URL("apollo_pic", null, a(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData));
        if (paramContext == null) {
          return jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          paramContext = (Context)localObject;
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloMainInfo", 2, "getDrawable ,", localMalformedURLException);
            paramContext = (Context)localObject;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloMainInfo", 2, "decode panel action name =" + this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionName);
        }
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ApolloLinearLayout.e;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ApolloLinearLayout.e;
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = false;
        localObject = URLDrawable.getDrawable(paramContext, (URLDrawable.URLDrawableOptions)localObject);
        paramContext = (Context)localObject;
      }
    } while (((URLDrawable)localObject).getStatus() == 1);
    ((URLDrawable)localObject).setTag(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData);
    ((URLDrawable)localObject).addHeader("apollo_uin", this.jdField_a_of_type_JavaLangString);
    ((URLDrawable)localObject).addHeader("apollo_tasks", str);
    return localObject;
  }
  
  public String a(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData == null) {
      return "action";
    }
    return paramApolloActionData.actionId + "_" + paramApolloActionData.actionName;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData == null) || (paramQQAppInterface == null) || (paramSessionInfo == null)) {}
    label311:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloMainInfo", 2, "send apolloInfo actionid=" + this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId + " input =" + paramEditText.getText().toString());
      }
      ChatActivityFacade.a(paramQQAppInterface, paramContext, paramSessionInfo, this);
      paramContext = "";
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText))
      {
        paramEditText = "2";
        paramContext = paramEditText;
        if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
        {
          if (this.d == 0) {
            paramContext = "6";
          }
        }
        else
        {
          if (paramSessionInfo.jdField_a_of_type_Int != 0) {
            continue;
          }
          paramEditText = paramSessionInfo.jdField_a_of_type_JavaLangString;
          i = Integer.parseInt(paramContext);
          paramSessionInfo = "" + this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId;
          str = "655_" + this.jdField_a_of_type_Int;
          if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
            break label311;
          }
        }
      }
      for (paramContext = "0";; paramContext = this.jdField_b_of_type_JavaLangString)
      {
        VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "action_sent", paramEditText, i, 0, new String[] { paramSessionInfo, str, paramContext, String.valueOf(System.currentTimeMillis() / 1000L) });
        return;
        paramContext = paramEditText;
        if (this.d != 1) {
          break;
        }
        paramContext = "7";
        break;
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
        {
          paramContext = "3";
          break;
        }
        if (this.d == 0)
        {
          paramContext = "4";
          break;
        }
        if (this.d != 1) {
          break;
        }
        paramContext = "5";
        break;
      }
    } while (((paramSessionInfo.jdField_a_of_type_Int != 1) && (paramSessionInfo.jdField_a_of_type_Int != 3000)) || (this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum != 0));
    paramEditText = paramSessionInfo.jdField_a_of_type_JavaLangString;
    int i = Integer.parseInt(paramContext);
    int j = ApolloUtil.b(paramSessionInfo.jdField_a_of_type_Int);
    paramSessionInfo = "" + this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId;
    String str = "655_" + this.jdField_a_of_type_Int;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    for (paramContext = "0";; paramContext = this.jdField_b_of_type_JavaLangString)
    {
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "g_action_single_sent", paramEditText, i, j, new String[] { paramSessionInfo, str, paramContext, String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloMainInfo
 * JD-Core Version:    0.7.0.1
 */