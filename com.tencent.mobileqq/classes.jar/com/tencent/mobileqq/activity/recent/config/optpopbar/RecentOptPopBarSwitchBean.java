package com.tencent.mobileqq.activity.recent.config.optpopbar;

import com.tencent.mobileqq.activity.recent.RecentOptPopBar;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class RecentOptPopBarSwitchBean
{
  private static final String jdField_a_of_type_JavaLangString = RecentOptPopBar.class.getSimpleName();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  
  public static RecentOptPopBarSwitchBean a()
  {
    RecentOptPopBarSwitchBean localRecentOptPopBarSwitchBean = new RecentOptPopBarSwitchBean();
    localRecentOptPopBarSwitchBean.a(true);
    localRecentOptPopBarSwitchBean.b(true);
    localRecentOptPopBarSwitchBean.e(true);
    localRecentOptPopBarSwitchBean.f(true);
    return localRecentOptPopBarSwitchBean;
  }
  
  public static RecentOptPopBarSwitchBean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, paramString);
    }
    RecentOptPopBarSwitchBean localRecentOptPopBarSwitchBean = new RecentOptPopBarSwitchBean();
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("switch");
      localRecentOptPopBarSwitchBean.a(a(paramString, "create_groupchat"));
      localRecentOptPopBarSwitchBean.b(a(paramString, "add_friends_group"));
      localRecentOptPopBarSwitchBean.c(a(paramString, "match_chat"));
      localRecentOptPopBarSwitchBean.d(a(paramString, "letsparty"));
      localRecentOptPopBarSwitchBean.e(a(paramString, "scan"));
      localRecentOptPopBarSwitchBean.f(a(paramString, "fastpass"));
      localRecentOptPopBarSwitchBean.g(a(paramString, "send_receive_money"));
      localRecentOptPopBarSwitchBean.h(a(paramString, "add_miniprogram"));
      localRecentOptPopBarSwitchBean.i(a(paramString, "face_to_face_redpacket"));
      localRecentOptPopBarSwitchBean.j(a(paramString, "tencent_shopping_live"));
      return localRecentOptPopBarSwitchBean;
    }
    catch (Exception paramString)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "RecentOptPopBarSwitchBean#parce exception: ", paramString);
    }
    return a();
  }
  
  public static boolean a(RecentOptPopBarSwitchBean paramRecentOptPopBarSwitchBean)
  {
    return (!paramRecentOptPopBarSwitchBean.a()) && (!paramRecentOptPopBarSwitchBean.b()) && (!paramRecentOptPopBarSwitchBean.c()) && (!paramRecentOptPopBarSwitchBean.d()) && (!paramRecentOptPopBarSwitchBean.e()) && (!paramRecentOptPopBarSwitchBean.f()) && (!paramRecentOptPopBarSwitchBean.g()) && (!paramRecentOptPopBarSwitchBean.h()) && (!paramRecentOptPopBarSwitchBean.i()) && (!paramRecentOptPopBarSwitchBean.j());
  }
  
  private static boolean a(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = paramJSONObject.opt(paramString);
    return ((paramJSONObject instanceof Integer)) && (((Integer)paramJSONObject).intValue() == 1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public void c(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public void d(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public void e(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean e()
  {
    return this.e;
  }
  
  public void f(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean f()
  {
    return this.f;
  }
  
  public void g(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean g()
  {
    return this.g;
  }
  
  public void h(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean h()
  {
    return this.h;
  }
  
  public void i(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public boolean i()
  {
    return this.i;
  }
  
  public void j(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public boolean j()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.optpopbar.RecentOptPopBarSwitchBean
 * JD-Core Version:    0.7.0.1
 */