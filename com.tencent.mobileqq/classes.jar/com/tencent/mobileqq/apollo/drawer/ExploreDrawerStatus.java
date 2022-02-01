package com.tencent.mobileqq.apollo.drawer;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeApolloProcessor;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeViewModel;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class ExploreDrawerStatus
  extends ApolloDrawerStatus
{
  public long a;
  public String a;
  public WeakReference<QQSettingMe> a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public int f;
  private int g = 0;
  private int h = 0;
  private int i;
  
  public ExploreDrawerStatus(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject, QQSettingMe paramQQSettingMe)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 98;
    this.jdField_b_of_type_Int = paramJSONObject.optInt("entry_id", 1);
    this.jdField_a_of_type_Long = paramJSONObject.optLong("seq", 0L);
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("wording");
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("jump_url");
    this.jdField_c_of_type_Int = paramJSONObject.optInt("is_red", 0);
    this.jdField_c_of_type_JavaLangString = paramJSONObject.optString("icon_url");
    this.jdField_d_of_type_Int = paramJSONObject.optInt("action_id", 0);
    this.e = paramJSONObject.optInt("bubble_id", 0);
    this.jdField_d_of_type_JavaLangString = paramJSONObject.optString("scheme");
    this.f = paramJSONObject.optInt("show_sum", 1);
    this.h = paramJSONObject.optInt("msg_id", 0);
    this.i = paramJSONObject.optInt("cmshow_module", 1);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQSettingMe);
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    paramSpriteDrawerInfoManager = new StringBuilder();
    paramSpriteDrawerInfoManager.append("[onBubbleClick] ");
    paramSpriteDrawerInfoManager.append(this.jdField_d_of_type_JavaLangString);
    paramSpriteDrawerInfoManager.append("|");
    paramSpriteDrawerInfoManager.append(this.jdField_b_of_type_JavaLangString);
    QLog.d("[cmshow]ExploreDrawerStatus", 1, paramSpriteDrawerInfoManager.toString());
    int j;
    if (2 == this.i) {
      j = 1;
    } else {
      j = 0;
    }
    paramSpriteDrawerInfoManager = new StringBuilder();
    paramSpriteDrawerInfoManager.append(this.e);
    paramSpriteDrawerInfoManager.append("");
    VipUtils.a(null, "cmshow", "Apollo", "DrawerBubble_clk", 0, j, new String[] { paramSpriteDrawerInfoManager.toString(), String.valueOf(this.h) });
    ApolloUtilImpl.openStoreByTabScheme(paramQQAppInterface, paramContext, this.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, "drawer");
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramContext = new StringBuilder();
    paramContext.append("[onBubbleShow] showCount： ");
    paramContext.append(this.g);
    paramContext.append(", showSum: ");
    paramContext.append(this.f);
    paramContext.append(", content: ");
    paramContext.append(this.jdField_a_of_type_JavaLangString);
    QLog.d("[cmshow]ExploreDrawerStatus", 1, paramContext.toString());
    paramInt = this.g;
    if (paramInt >= this.f) {
      return;
    }
    this.g = (paramInt + 1);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      SpriteUtil.a(paramSpriteDrawerInfoManager, this.jdField_a_of_type_JavaLangString, 9, this.e);
      if (2 == this.i) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      paramSpriteDrawerInfoManager = new StringBuilder();
      paramSpriteDrawerInfoManager.append(this.e);
      paramSpriteDrawerInfoManager.append("");
      VipUtils.a(null, "cmshow", "Apollo", "DrawerBubble_show", 0, paramInt, new String[] { paramSpriteDrawerInfoManager.toString(), String.valueOf(this.h) });
    }
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      paramSpriteDrawerInfoManager = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (paramSpriteDrawerInfoManager != null)
      {
        paramSpriteDrawerInfoManager = (QQSettingMe)paramSpriteDrawerInfoManager.get();
        if (paramSpriteDrawerInfoManager != null)
        {
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("[showExploreBox] url:");
            paramContext.append(this.jdField_c_of_type_JavaLangString);
            QLog.d("QQSettingRedesign", 2, paramContext.toString());
          }
          ((QQSettingMeApolloProcessor)paramSpriteDrawerInfoManager.a().a("d_apollo")).b(this.jdField_c_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.ExploreDrawerStatus
 * JD-Core Version:    0.7.0.1
 */