package com.tencent.mobileqq.activity.qqsettingme.config;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeItemData;
import com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchTextView;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import org.json.JSONObject;

public class QQSettingMeBizBean
  implements Comparable<QQSettingMeBizBean>
{
  private int jdField_a_of_type_Int;
  private QQSettingMeItemData jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeItemData;
  private QQSettingMeBizBean.Action jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeConfigQQSettingMeBizBean$Action;
  private QQSettingMeBizBean.Title jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeConfigQQSettingMeBizBean$Title;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String e;
  
  public QQSettingMeBizBean() {}
  
  public QQSettingMeBizBean(String paramString1, int paramInt, QQSettingMeBizBean.Title paramTitle, String paramString2, String paramString3, QQSettingMeBizBean.Action paramAction, String paramString4, String paramString5, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeConfigQQSettingMeBizBean$Title = paramTitle;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeConfigQQSettingMeBizBean$Action = paramAction;
    this.jdField_d_of_type_JavaLangString = paramString4;
    this.e = paramString5;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_c_of_type_Boolean = paramBoolean3;
    this.jdField_d_of_type_Boolean = paramBoolean4;
  }
  
  private static QQSettingMeBizBean.ActionType a(String paramString)
  {
    int i = paramString.hashCode();
    if (i != -1052618729)
    {
      if (i != 117588)
      {
        if ((i == 1064526442) && (paramString.equals("miniapp")))
        {
          i = 2;
          break label70;
        }
      }
      else if (paramString.equals("web"))
      {
        i = 1;
        break label70;
      }
    }
    else if (paramString.equals("native"))
    {
      i = 0;
      break label70;
    }
    i = -1;
    label70:
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return QQSettingMeBizBean.ActionType.DEFAULT;
        }
        return QQSettingMeBizBean.ActionType.MINIAPP;
      }
      return QQSettingMeBizBean.ActionType.WEB;
    }
    return QQSettingMeBizBean.ActionType.SCHEMA;
  }
  
  public static QQSettingMeBizBean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    QQSettingMeBizBean localQQSettingMeBizBean = new QQSettingMeBizBean();
    localQQSettingMeBizBean.a(paramJSONObject.getString("pluginID"));
    a(localQQSettingMeBizBean, paramJSONObject.getJSONObject("title"));
    localQQSettingMeBizBean.c(paramJSONObject.getString("iconNormal"));
    String str2 = paramJSONObject.optString("iconConcise");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramJSONObject.getString("iconConcise_Black");
    }
    localQQSettingMeBizBean.d(str1);
    localQQSettingMeBizBean.e(paramJSONObject.optString("redDotID"));
    localQQSettingMeBizBean.b(paramJSONObject.optString("DTElementID"));
    b(localQQSettingMeBizBean, paramJSONObject.getJSONObject("action"));
    localQQSettingMeBizBean.a(paramJSONObject.getInt("order"));
    localQQSettingMeBizBean.a(paramJSONObject.optBoolean("enableNormal", true));
    localQQSettingMeBizBean.b(paramJSONObject.optBoolean("enableConcise", true));
    localQQSettingMeBizBean.c(paramJSONObject.optBoolean("enableStudy", true));
    localQQSettingMeBizBean.d(paramJSONObject.optBoolean("enableGooglePlay", true));
    return localQQSettingMeBizBean;
  }
  
  private static void a(QQSettingMeBizBean paramQQSettingMeBizBean, JSONObject paramJSONObject)
  {
    QQSettingMeBizBean.Title localTitle = new QQSettingMeBizBean.Title();
    String str = paramQQSettingMeBizBean.a();
    switch (str.hashCode())
    {
    default: 
      break;
    case 2098843321: 
      if (str.equals("d_lovespace")) {
        i = 4;
      }
      break;
    case 1991551892: 
      if (str.equals("d_qqwallet")) {
        i = 1;
      }
      break;
    case 945870491: 
      if (str.equals("d_vip_identity")) {
        i = 0;
      }
      break;
    case 300984171: 
      if (str.equals("d_decoration")) {
        i = 2;
      }
      break;
    case -891922579: 
      if (str.equals("d_vip_card")) {
        i = 3;
      }
      break;
    case -1727290544: 
      if (str.equals("d_tencent_document")) {
        i = 6;
      }
      break;
    case -2074746548: 
      if (str.equals("d_qq_shopping")) {
        i = 5;
      }
      break;
    }
    int i = -1;
    switch (i)
    {
    default: 
      paramJSONObject = paramJSONObject.getJSONObject("default");
      localTitle.jdField_a_of_type_JavaLangString = paramJSONObject.getString("zh");
      localTitle.jdField_b_of_type_JavaLangString = paramJSONObject.getString("en");
      paramJSONObject = localTitle;
      break;
    case 6: 
      paramJSONObject = paramJSONObject.getJSONObject("myTXDocs");
      localTitle.jdField_a_of_type_JavaLangString = paramJSONObject.getString("zh");
      localTitle.jdField_b_of_type_JavaLangString = paramJSONObject.getString("en");
      paramJSONObject = localTitle;
      break;
    case 5: 
      paramJSONObject = paramJSONObject.getJSONObject("myshopping");
      localTitle.jdField_a_of_type_JavaLangString = paramJSONObject.getString("zh");
      localTitle.jdField_b_of_type_JavaLangString = paramJSONObject.getString("en");
      paramJSONObject = localTitle;
      break;
    case 4: 
      paramJSONObject = paramJSONObject.getJSONObject("lovespace");
      localTitle.jdField_a_of_type_JavaLangString = paramJSONObject.getString("zh");
      localTitle.jdField_b_of_type_JavaLangString = paramJSONObject.getString("en");
      paramJSONObject = localTitle;
      break;
    case 3: 
      paramJSONObject = paramJSONObject.getJSONObject("freetraffic");
      localTitle.jdField_a_of_type_JavaLangString = paramJSONObject.getString("zh");
      localTitle.jdField_b_of_type_JavaLangString = paramJSONObject.getString("en");
      paramJSONObject = localTitle;
      break;
    case 2: 
      paramJSONObject = paramJSONObject.getJSONObject("decoration");
      localTitle.jdField_a_of_type_JavaLangString = paramJSONObject.getString("zh");
      localTitle.jdField_b_of_type_JavaLangString = paramJSONObject.getString("en");
      paramJSONObject = localTitle;
      break;
    case 1: 
      paramJSONObject = paramJSONObject.getJSONObject("wallet");
      localTitle.jdField_a_of_type_JavaLangString = paramJSONObject.getString("zh");
      localTitle.jdField_b_of_type_JavaLangString = paramJSONObject.getString("en");
      paramJSONObject = localTitle;
      break;
    case 0: 
      paramJSONObject = ((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).getBusinessEntryText(paramJSONObject, "d_vip_identity");
    }
    paramQQSettingMeBizBean.a(paramJSONObject);
  }
  
  private static void b(QQSettingMeBizBean paramQQSettingMeBizBean, JSONObject paramJSONObject)
  {
    paramQQSettingMeBizBean.a(new QQSettingMeBizBean.Action(a(paramJSONObject.getString("actionType")), paramJSONObject.optString("actionUrl")));
  }
  
  public int a(QQSettingMeBizBean paramQQSettingMeBizBean)
  {
    int i = this.jdField_a_of_type_Int;
    int j = paramQQSettingMeBizBean.jdField_a_of_type_Int;
    if (i < j) {
      return -1;
    }
    if (i > j) {
      return 1;
    }
    return 0;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeItemData.a();
  }
  
  public QQSettingMeItemData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeItemData;
  }
  
  public QQSettingMeBizBean.Action a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeConfigQQSettingMeBizBean$Action;
  }
  
  public QQSettingMeBizBean.Title a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeConfigQQSettingMeBizBean$Title;
  }
  
  public RedTouchTextView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeItemData.a();
  }
  
  public RedTouch a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeItemData.a();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(QQSettingMeItemData paramQQSettingMeItemData)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeItemData = paramQQSettingMeItemData;
  }
  
  public void a(QQSettingMeBizBean.Action paramAction)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeConfigQQSettingMeBizBean$Action = paramAction;
  }
  
  public void a(QQSettingMeBizBean.Title paramTitle)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeConfigQQSettingMeBizBean$Title = paramTitle;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return this.e;
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public String c()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void c(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public String d()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void d(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public String e()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void e(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean
 * JD-Core Version:    0.7.0.1
 */