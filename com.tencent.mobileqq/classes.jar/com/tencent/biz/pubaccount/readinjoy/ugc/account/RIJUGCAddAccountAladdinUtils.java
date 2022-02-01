package com.tencent.biz.pubaccount.readinjoy.ugc.account;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.app.HardCodeUtil;

public class RIJUGCAddAccountAladdinUtils
{
  private static final String a = HardCodeUtil.a(2131720352);
  private static final String b = HardCodeUtil.a(2131720355);
  private static final String c = HardCodeUtil.a(2131720353);
  private static final String d = HardCodeUtil.a(2131720351);
  private static final String e = HardCodeUtil.a(2131720354);
  
  public static int a()
  {
    return a().getIntegerFromString("ugc_add_account_tips_show_time", 2);
  }
  
  private static AladdinConfig a()
  {
    return Aladdin.getConfig(303);
  }
  
  public static String a()
  {
    return a().getString("ugc_add_account_description", a);
  }
  
  public static String b()
  {
    return a().getString("ugc_add_account_use_original_account_button_description", b);
  }
  
  public static String c()
  {
    return a().getString("ugc_add_account_edit_account_button_description", c);
  }
  
  public static String d()
  {
    return a().getString("ugc_add_account_complete_toast_wording", d);
  }
  
  public static String e()
  {
    return a().getString("ugc_add_account_tips_wording", e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.account.RIJUGCAddAccountAladdinUtils
 * JD-Core Version:    0.7.0.1
 */