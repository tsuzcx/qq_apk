import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.pannel.ApolloLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

public class annm
  extends annl
{
  public Drawable a;
  public Drawable b;
  
  public annm(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null)) {
      try
      {
        paramString = BaseApplication.getContext().getResources();
        if (paramString != null)
        {
          Bitmap localBitmap1 = (Bitmap)BaseApplicationImpl.sImageHashMap.get("apolloMainInfoDef");
          Bitmap localBitmap2 = (Bitmap)BaseApplicationImpl.sImageHashMap.get("apolloMainInfoFail");
          if (localBitmap1 != null) {
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(localBitmap1);
          }
          while (localBitmap2 != null)
          {
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(localBitmap2);
            return;
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramString.getDrawable(2130838049);
            BaseApplicationImpl.sImageHashMap.put("apolloMainInfoDef", BitmapFactory.decodeResource(paramString, 2130838049));
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
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramString.getDrawable(2130843819);
          BaseApplicationImpl.sImageHashMap.put("apolloMainInfoFail", BitmapFactory.decodeResource(paramString, 2130843819));
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
  
  private Drawable a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
      localURLDrawableOptions.mFailedDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      localURLDrawableOptions.mRequestHeight = ApolloLinearLayout.e;
      localURLDrawableOptions.mRequestWidth = ApolloLinearLayout.e;
      localURLDrawableOptions.mPlayGifImage = false;
      localURLDrawableOptions.mUseMemoryCache = true;
      return URLDrawable.getFileDrawable(paramString, localURLDrawableOptions);
    }
    return this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    Object localObject1 = null;
    paramContext = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData == null) {}
    Object localObject2;
    do
    {
      do
      {
        return paramContext;
        localObject2 = Integer.toString(1);
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          break;
        }
        paramContext = URLDrawable.URLDrawableOptions.obtain();
        localObject1 = new anew();
        ((anew)localObject1).jdField_a_of_type_JavaLangString = ("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/" + this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId + File.separator + "txtImg.png");
        ((anew)localObject1).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.textImg;
        paramContext.mExtraInfo = localObject1;
        paramContext.mRequestHeight = ApolloLinearLayout.e;
        paramContext.mRequestWidth = ApolloLinearLayout.e;
        localObject1 = anev.a(true, ((anew)localObject1).jdField_a_of_type_JavaLangString, paramContext, this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.textImg);
        paramContext = (Context)localObject1;
      } while (!QLog.isColorLevel());
      QLog.d("ApolloMainInfo", 2, "decode panel action name =" + this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionName + " mActionText:" + this.jdField_b_of_type_JavaLangString);
      return localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.isForPlayerAction == 1)
      {
        paramContext = ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData, 10);
        localObject1 = ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData, 0);
        if ((!TextUtils.isEmpty(paramContext)) && (new File(paramContext).exists()))
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = a((String)localObject1);
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = ApolloLinearLayout.e;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = ApolloLinearLayout.e;
          ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = false;
          ((URLDrawable.URLDrawableOptions)localObject2).mUseMemoryCache = false;
          localObject1 = URLDrawable.getFileDrawable(paramContext, (URLDrawable.URLDrawableOptions)localObject2);
          QLog.i("ApolloMainInfo", 4, "path exists get drawable " + paramContext + "; b : " + localObject1);
          return localObject1;
        }
        QLog.i("ApolloMainInfo", 4, "path not exists " + paramContext);
        return a((String)localObject1);
      }
      try
      {
        paramContext = new URL("apollo_pic", null, a(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData));
        if (paramContext == null) {
          return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
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
          QLog.d("ApolloMainInfo", 2, "decode panel action name =" + this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionName);
        }
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = ApolloLinearLayout.e;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = ApolloLinearLayout.e;
        ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = false;
        if (this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.isForPlayerAction == 1)
        {
          ((URLDrawable.URLDrawableOptions)localObject1).mUseMemoryCache = false;
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = new ColorDrawable(0);
        }
        localObject1 = URLDrawable.getDrawable(paramContext, (URLDrawable.URLDrawableOptions)localObject1);
        paramContext = (Context)localObject1;
      }
    } while (((URLDrawable)localObject1).getStatus() == 1);
    ((URLDrawable)localObject1).setTag(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData);
    ((URLDrawable)localObject1).addHeader("apollo_uin", this.jdField_a_of_type_JavaLangString);
    ((URLDrawable)localObject1).addHeader("apollo_tasks", (String)localObject2);
    return localObject1;
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
    if ((this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData == null) || (paramQQAppInterface == null) || (paramSessionInfo == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloMainInfo", 2, "send apolloInfo actionid=" + this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId + " input =" + paramEditText.getText().toString());
    }
    admh.a(paramQQAppInterface, paramContext, paramSessionInfo, this);
    paramContext = "";
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText))
    {
      paramEditText = "2";
      paramContext = paramEditText;
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        break label756;
      }
      if (this.d == 0) {
        paramContext = "6";
      }
    }
    label211:
    label754:
    label756:
    for (;;)
    {
      String str1;
      int i;
      String str2;
      String str3;
      if (paramSessionInfo.curType == 0)
      {
        str1 = paramSessionInfo.curFriendUin;
        i = Integer.parseInt(paramContext);
        str2 = "" + this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId;
        str3 = "655_" + this.jdField_a_of_type_Int;
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
        {
          paramEditText = "0";
          VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "action_sent", str1, i, 0, new String[] { str2, str3, paramEditText, String.valueOf(System.currentTimeMillis() / 1000L) });
          if (this.jdField_a_of_type_Int == 9)
          {
            if (this.h != 3) {
              break label696;
            }
            VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "y_gjcbq_success", paramSessionInfo.curFriendUin, ApolloUtil.b(paramSessionInfo.curType), 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId), this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionName });
          }
        }
      }
      for (;;)
      {
        if (anhm.a(paramQQAppInterface.getCurrentUin(), paramQQAppInterface) != 0) {
          break label754;
        }
        VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "exp_panelnewuser_send_action", paramSessionInfo.curFriendUin, Integer.parseInt(paramContext), ApolloUtil.b(paramSessionInfo.curType), new String[] { "" + this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId, "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
        return;
        paramContext = paramEditText;
        if (this.d != 1) {
          break label756;
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
          break label756;
        }
        paramContext = "5";
        break;
        paramEditText = this.jdField_b_of_type_JavaLangString;
        break label211;
        if (((paramSessionInfo.curType != 1) && (paramSessionInfo.curType != 3000)) || (this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum != 0)) {
          break label260;
        }
        str1 = paramSessionInfo.curFriendUin;
        i = Integer.parseInt(paramContext);
        int j = ApolloUtil.b(paramSessionInfo.curType);
        str2 = "" + this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId;
        str3 = "655_" + this.jdField_a_of_type_Int;
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
        for (paramEditText = "0";; paramEditText = this.jdField_b_of_type_JavaLangString)
        {
          VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "g_action_single_sent", str1, i, j, new String[] { str2, str3, paramEditText, String.valueOf(System.currentTimeMillis() / 1000L) });
          break;
        }
        VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "y_bqsuccess", paramSessionInfo.curFriendUin, ApolloUtil.b(paramSessionInfo.curType), 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId) });
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     annm
 * JD-Core Version:    0.7.0.1
 */