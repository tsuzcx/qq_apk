package com.tencent.biz.pubaccount.readinjoy.viola.view;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerHelper;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.utils.ViolaBizUtils;
import com.tencent.biz.pubaccount.util.RIJBlackWhiteModeHelper;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class ViolaBaseView$ViolaCreactPageObject
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int = 1;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString = "120";
  private int jdField_e_of_type_Int = 0;
  private String jdField_e_of_type_JavaLangString = "0";
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString;
  
  public ViolaBaseView$ViolaCreactPageObject(@NonNull String paramString1, @NonNull JSONObject paramJSONObject, String paramString2, int paramInt, String paramString3)
  {
    this(paramString1, paramJSONObject, paramString2, paramString3);
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = RIJBlackWhiteModeHelper.a.b();
  }
  
  public ViolaBaseView$ViolaCreactPageObject(@NonNull String paramString1, @NonNull JSONObject paramJSONObject, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_f_of_type_JavaLangString = paramString3;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && ((this.jdField_a_of_type_JavaLangString.contains("v_present=1")) || (this.jdField_a_of_type_JavaLangString.contains("v_present=2")))) {
      this.jdField_a_of_type_Int = 1;
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.contains("v_present_auto_top=0"))) {
      this.jdField_c_of_type_Int = 0;
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.contains("v_present_top"))) {
      this.jdField_d_of_type_JavaLangString = Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("v_present_top");
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.contains("is_last_index=1"))) {
      this.jdField_f_of_type_Int = 1;
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.contains("channelId"))) {
      this.jdField_e_of_type_JavaLangString = Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("channelId");
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.contains("unreadMessageCount"))) {}
    try
    {
      paramString1 = Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("unreadMessageCount");
      if (paramString1 != null) {
        this.jdField_e_of_type_Int = Integer.valueOf(paramString1).intValue();
      }
    }
    catch (NumberFormatException paramString1)
    {
      for (;;)
      {
        QLog.e(ViolaBaseView.a(), 1, paramString1.toString());
      }
    }
    paramString1 = (QQAppInterface)ReadInJoyUtils.a();
    if (paramString1 != null) {
      this.jdField_c_of_type_JavaLangString = paramString1.getAccount();
    }
    this.jdField_d_of_type_Int = ViewUtils.c(CommonSuspensionGestureLayout.a(BaseActivity.sTopActivity));
  }
  
  private int a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getResources();
    if (localObject == null) {}
    do
    {
      return 1;
      localObject = ((Resources)localObject).getConfiguration();
    } while (localObject == null);
    return ((Configuration)localObject).orientation;
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if ((BaseActivity.sTopActivity != null) && (BaseActivity.sTopActivity.getResources() != null)) {}
    for (float f1 = ViewUtils.c(BaseActivity.sTopActivity.getResources().getDimensionPixelSize(2131297347));; f1 = 54.0F)
    {
      paramJSONObject.put("qqTabBarHeight", f1);
      return;
    }
  }
  
  private boolean b()
  {
    return this.jdField_b_of_type_Int == 1;
  }
  
  public String a()
  {
    return a().toString();
  }
  
  public JSONObject a()
  {
    int j = 0;
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_OrgJsonJSONObject.put("unreadMessageCount", this.jdField_e_of_type_Int);
      localJSONObject.put("param", this.jdField_a_of_type_OrgJsonJSONObject);
      localJSONObject.put("cache", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("uin", this.jdField_c_of_type_JavaLangString);
      localJSONObject.put("isPresent", this.jdField_a_of_type_Int);
      localJSONObject.put("isChannel", this.jdField_b_of_type_Int);
      if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
      {
        i = 1;
        localJSONObject.put("isNightMode", i);
        localJSONObject.put("isAutoTop", this.jdField_c_of_type_Int);
        localJSONObject.put("presentMarginTop", this.jdField_d_of_type_JavaLangString);
        localJSONObject.put("nowNavBarHeight", this.jdField_d_of_type_Int);
        localJSONObject.put("orientation", a());
        localJSONObject.put("screenWidth", FlexConvertUtils.getScreenWidth(BaseApplicationImpl.getApplication()));
        localJSONObject.put("screenHeight", FlexConvertUtils.getScreenHeight(BaseApplicationImpl.getApplication()));
        if (CUKingCardHelper.a() != 1) {
          break label398;
        }
        i = 1;
        label193:
        localJSONObject.put("isKindCard", i);
        localJSONObject.put("channel_id", this.jdField_e_of_type_JavaLangString);
        if (!PlayerHelper.a.a()) {
          break label403;
        }
      }
      label398:
      label403:
      for (int i = 1;; i = 0)
      {
        localJSONObject.put("supportRate", i);
        localJSONObject.put("netType", HttpUtil.getNetWorkType());
        float[] arrayOfFloat = ViolaBizUtils.a();
        localJSONObject.put("topActivityWidth", arrayOfFloat[0]);
        localJSONObject.put("topActivityHeight", arrayOfFloat[1]);
        if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
          localJSONObject.put("colorBallData", new JSONObject(this.jdField_f_of_type_JavaLangString));
        }
        if (b())
        {
          i = j;
          if (this.jdField_a_of_type_Boolean) {
            i = 1;
          }
          localJSONObject.put("isBlackWhiteMode", i);
        }
        if (String.valueOf(41726).equals(this.jdField_e_of_type_JavaLangString)) {
          a(localJSONObject);
        }
        localJSONObject.put("wifiMac", NetworkUtils.a(BaseApplicationImpl.getApplication()));
        localJSONObject.put("wifiSsid", NetworkUtils.b(BaseApplicationImpl.getApplication()));
        localJSONObject.put("is_last_index", this.jdField_f_of_type_Int);
        return localJSONObject;
        i = 0;
        break;
        i = 0;
        break label193;
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e(ViolaBaseView.a(), 1, "ViolaCreactPageObject toJSON error = " + localJSONException.getMessage());
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_Int = 1;
  }
  
  public boolean a()
  {
    return (b()) && (this.jdField_a_of_type_Boolean);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ViolaCreactPageObject : url:");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      str = "null";
      localStringBuilder.append(str);
      localStringBuilder.append("; ");
      if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
        break label107;
      }
      str = "null";
      label55:
      localStringBuilder.append(str);
      localStringBuilder.append("; ");
      if (this.jdField_b_of_type_JavaLangString != null) {
        break label118;
      }
    }
    label107:
    label118:
    for (String str = "null";; str = this.jdField_b_of_type_JavaLangString)
    {
      localStringBuilder.append(str);
      localStringBuilder.append("; ");
      return localStringBuilder.toString();
      str = this.jdField_a_of_type_JavaLangString;
      break;
      str = this.jdField_a_of_type_OrgJsonJSONObject.toString();
      break label55;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.ViolaCreactPageObject
 * JD-Core Version:    0.7.0.1
 */