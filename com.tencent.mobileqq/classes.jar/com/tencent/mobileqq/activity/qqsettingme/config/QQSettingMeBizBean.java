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
  private String a;
  private QQSettingMeBizBean.Title b;
  private String c;
  private String d;
  private String e;
  private String f;
  private QQSettingMeBizBean.Action g;
  private int h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private QQSettingMeItemData m;
  
  public QQSettingMeBizBean() {}
  
  public QQSettingMeBizBean(String paramString1, int paramInt, QQSettingMeBizBean.Title paramTitle, String paramString2, String paramString3, QQSettingMeBizBean.Action paramAction, String paramString4, String paramString5, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.a = paramString1;
    this.h = paramInt;
    this.b = paramTitle;
    this.c = paramString2;
    this.d = paramString3;
    this.g = paramAction;
    this.e = paramString4;
    this.f = paramString5;
    this.i = paramBoolean1;
    this.j = paramBoolean2;
    this.k = paramBoolean3;
    this.l = paramBoolean4;
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
        n = 4;
      }
      break;
    case 1991551892: 
      if (str.equals("d_qqwallet")) {
        n = 1;
      }
      break;
    case 945870491: 
      if (str.equals("d_vip_identity")) {
        n = 0;
      }
      break;
    case 300984171: 
      if (str.equals("d_decoration")) {
        n = 2;
      }
      break;
    case -891922579: 
      if (str.equals("d_vip_card")) {
        n = 3;
      }
      break;
    case -1727290544: 
      if (str.equals("d_tencent_document")) {
        n = 6;
      }
      break;
    case -2074746548: 
      if (str.equals("d_qq_shopping")) {
        n = 5;
      }
      break;
    }
    int n = -1;
    switch (n)
    {
    default: 
      paramJSONObject = paramJSONObject.getJSONObject("default");
      localTitle.a = paramJSONObject.getString("zh");
      localTitle.b = paramJSONObject.getString("en");
      paramJSONObject = localTitle;
      break;
    case 6: 
      paramJSONObject = paramJSONObject.getJSONObject("myTXDocs");
      localTitle.a = paramJSONObject.getString("zh");
      localTitle.b = paramJSONObject.getString("en");
      paramJSONObject = localTitle;
      break;
    case 5: 
      paramJSONObject = paramJSONObject.getJSONObject("myshopping");
      localTitle.a = paramJSONObject.getString("zh");
      localTitle.b = paramJSONObject.getString("en");
      paramJSONObject = localTitle;
      break;
    case 4: 
      paramJSONObject = paramJSONObject.getJSONObject("lovespace");
      localTitle.a = paramJSONObject.getString("zh");
      localTitle.b = paramJSONObject.getString("en");
      paramJSONObject = localTitle;
      break;
    case 3: 
      paramJSONObject = paramJSONObject.getJSONObject("freetraffic");
      localTitle.a = paramJSONObject.getString("zh");
      localTitle.b = paramJSONObject.getString("en");
      paramJSONObject = localTitle;
      break;
    case 2: 
      paramJSONObject = paramJSONObject.getJSONObject("decoration");
      localTitle.a = paramJSONObject.getString("zh");
      localTitle.b = paramJSONObject.getString("en");
      paramJSONObject = localTitle;
      break;
    case 1: 
      paramJSONObject = paramJSONObject.getJSONObject("wallet");
      localTitle.a = paramJSONObject.getString("zh");
      localTitle.b = paramJSONObject.getString("en");
      paramJSONObject = localTitle;
      break;
    case 0: 
      paramJSONObject = ((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).getBusinessEntryText(paramJSONObject, "d_vip_identity");
    }
    paramQQSettingMeBizBean.a(paramJSONObject);
  }
  
  private static void b(QQSettingMeBizBean paramQQSettingMeBizBean, JSONObject paramJSONObject)
  {
    paramQQSettingMeBizBean.a(new QQSettingMeBizBean.Action(f(paramJSONObject.getString("actionType")), paramJSONObject.optString("actionUrl")));
  }
  
  private static QQSettingMeBizBean.ActionType f(String paramString)
  {
    int n = paramString.hashCode();
    if (n != -1052618729)
    {
      if (n != 117588)
      {
        if ((n == 1064526442) && (paramString.equals("miniapp")))
        {
          n = 2;
          break label70;
        }
      }
      else if (paramString.equals("web"))
      {
        n = 1;
        break label70;
      }
    }
    else if (paramString.equals("native"))
    {
      n = 0;
      break label70;
    }
    n = -1;
    label70:
    if (n != 0)
    {
      if (n != 1)
      {
        if (n != 2) {
          return QQSettingMeBizBean.ActionType.DEFAULT;
        }
        return QQSettingMeBizBean.ActionType.MINIAPP;
      }
      return QQSettingMeBizBean.ActionType.WEB;
    }
    return QQSettingMeBizBean.ActionType.SCHEMA;
  }
  
  public int a(QQSettingMeBizBean paramQQSettingMeBizBean)
  {
    int n = this.h;
    int i1 = paramQQSettingMeBizBean.h;
    if (n < i1) {
      return -1;
    }
    if (n > i1) {
      return 1;
    }
    return 0;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(QQSettingMeItemData paramQQSettingMeItemData)
  {
    this.m = paramQQSettingMeItemData;
  }
  
  public void a(QQSettingMeBizBean.Action paramAction)
  {
    this.g = paramAction;
  }
  
  public void a(QQSettingMeBizBean.Title paramTitle)
  {
    this.b = paramTitle;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public QQSettingMeBizBean.Title b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public String c()
  {
    return this.f;
  }
  
  public void c(String paramString)
  {
    this.c = paramString;
  }
  
  public void c(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
  
  public void d(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public String e()
  {
    return this.d;
  }
  
  public void e(String paramString)
  {
    this.e = paramString;
  }
  
  public String f()
  {
    return this.e;
  }
  
  public QQSettingMeBizBean.Action g()
  {
    return this.g;
  }
  
  public boolean h()
  {
    return this.i;
  }
  
  public boolean i()
  {
    return this.j;
  }
  
  public boolean j()
  {
    return this.k;
  }
  
  public QQSettingMeItemData k()
  {
    return this.m;
  }
  
  public View l()
  {
    return this.m.a();
  }
  
  public RedTouch m()
  {
    return this.m.b();
  }
  
  public RedTouchTextView n()
  {
    return this.m.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean
 * JD-Core Version:    0.7.0.1
 */