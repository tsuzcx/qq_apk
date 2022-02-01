package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class GotoNearbyAction
  extends JumpAction
{
  public GotoNearbyAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private void a(Intent paramIntent)
  {
    String str1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter")) {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter");
    } else {
      str1 = "";
    }
    if (!"1".equals(str1)) {
      return;
    }
    String str2;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_gender")) {
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_gender");
    } else {
      str2 = "";
    }
    String str3;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_time")) {
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_time");
    } else {
      str3 = "";
    }
    String str4;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_age")) {
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_age");
    } else {
      str4 = "";
    }
    String str5;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_xingzuo")) {
      str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_xingzuo");
    } else {
      str5 = "";
    }
    String str6;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_interest")) {
      str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_interest");
    } else {
      str6 = "";
    }
    String str7;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_career")) {
      str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_career");
    } else {
      str7 = "";
    }
    String str8;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_location")) {
      str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_location");
    } else {
      str8 = "";
    }
    try
    {
      i = Integer.valueOf(str2).intValue();
    }
    catch (Exception localException1)
    {
      int i;
      label287:
      break label287;
    }
    i = 0;
    try
    {
      j = Integer.valueOf(str3).intValue();
    }
    catch (Exception localException2)
    {
      int j;
      label301:
      break label301;
    }
    j = 3;
    try
    {
      k = Integer.valueOf(str4).intValue();
    }
    catch (Exception localException3)
    {
      int k;
      label316:
      break label316;
    }
    k = 0;
    try
    {
      m = Integer.valueOf(str5).intValue();
    }
    catch (Exception localException4)
    {
      int m;
      label332:
      label348:
      label364:
      break label332;
    }
    m = 0;
    try
    {
      n = Integer.valueOf(str7).intValue();
    }
    catch (Exception localException5)
    {
      int n;
      break label348;
    }
    n = 0;
    try
    {
      i1 = Integer.valueOf(str6).intValue();
    }
    catch (Exception localException6)
    {
      int i1;
      break label364;
    }
    i1 = 0;
    paramIntent.putExtra("filter", str1);
    paramIntent.putExtra("filterGender", i);
    paramIntent.putExtra("filter_time", j);
    paramIntent.putExtra("filter_age", k);
    paramIntent.putExtra("filter_xingzuo", m);
    paramIntent.putExtra("filter_interest", i1);
    paramIntent.putExtra("filter_career", n);
    paramIntent.putExtra("filter_location", str8);
  }
  
  private boolean c()
  {
    boolean bool = QLog.isColorLevel();
    int i = 0;
    if (bool) {
      NearbyUtils.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("TAB_TYPE", 1);
    bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey("src_type");
    String str4 = "";
    String str1;
    if (bool) {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    } else {
      str1 = "";
    }
    String str2;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("web_url")) {
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("web_url");
    } else {
      str2 = "";
    }
    String str3;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
    } else {
      str3 = "";
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) {
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
    }
    localIntent.putExtra("ENTER_TIME", System.currentTimeMillis());
    localIntent.putExtra("fromWhere", str1);
    localIntent.putExtra("webUrl", str2);
    localIntent.putExtra("fromType", str4);
    localIntent.putExtra("FROM_WHERE", 1);
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("neighbor_list_source"))
    {
      try
      {
        int j = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("neighbor_list_source"));
        i = j;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      localIntent.putExtra("neighbor_list_source", i);
    }
    if ("10002".equals(str3))
    {
      localIntent.putExtra("abp_flag", true);
      localIntent.addFlags(268435456);
    }
    a(localIntent);
    localIntent.addFlags(67108864);
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    RouteUtils.a(this.jdField_a_of_type_AndroidContentContext, localIntent, "/nearby/activity");
    if ("100".equals(str4)) {
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", "0X8007244", "0X8007244", 0, 0, "", "", "", "");
    }
    return true;
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = c();
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("GotoNearbyAction", 1, localStringBuilder.toString());
      b_("GotoNearbyAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.GotoNearbyAction
 * JD-Core Version:    0.7.0.1
 */