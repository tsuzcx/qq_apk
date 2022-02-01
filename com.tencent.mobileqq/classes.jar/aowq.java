import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aowq
  extends aoxg
{
  public aowq(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean C()
  {
    if (QLog.isColorLevel()) {
      axxb.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyActivity.class);
    localIntent.putExtra("TAB_TYPE", 1);
    String str1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("src_type")) {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    }
    for (;;)
    {
      String str2;
      label98:
      String str3;
      label124:
      String str4;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("web_url"))
      {
        str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("web_url");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
          break label354;
        }
        str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) {
          break label361;
        }
        str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
        localIntent.putExtra("ENTER_TIME", System.currentTimeMillis());
        localIntent.putExtra("fromWhere", str1);
        localIntent.putExtra("webUrl", str2);
        localIntent.putExtra("fromType", str4);
        localIntent.putExtra("FROM_WHERE", 1);
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("neighbor_list_source")) {}
      }
      try
      {
        i = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("neighbor_list_source"));
        localIntent.putExtra("neighbor_list_source", i);
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
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        if ("100".equals(str4)) {
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007244", "0X8007244", 0, 0, "", "", "", "");
        }
        return true;
        str1 = "";
        continue;
        str2 = "";
        break label98;
        label354:
        str3 = "";
        break label124;
        label361:
        str4 = "";
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          int i = 0;
        }
      }
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter")) {}
    for (String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter"); !"1".equals(str1); str1 = "") {
      return;
    }
    String str2;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_gender")) {
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_gender");
    }
    for (;;)
    {
      String str3;
      label96:
      String str4;
      label122:
      String str5;
      label148:
      String str6;
      label174:
      String str7;
      label200:
      String str8;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_time"))
      {
        str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_time");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_age")) {
          break label369;
        }
        str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_age");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_xingzuo")) {
          break label376;
        }
        str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_xingzuo");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_interest")) {
          break label383;
        }
        str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_interest");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_career")) {
          break label390;
        }
        str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_career");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_location")) {
          break label397;
        }
        str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_location");
      }
      try
      {
        i = Integer.valueOf(str2).intValue();
      }
      catch (Exception localException5)
      {
        try
        {
          j = Integer.valueOf(str3).intValue();
        }
        catch (Exception localException5)
        {
          try
          {
            k = Integer.valueOf(str4).intValue();
          }
          catch (Exception localException5)
          {
            try
            {
              m = Integer.valueOf(str5).intValue();
            }
            catch (Exception localException5)
            {
              try
              {
                n = Integer.valueOf(str7).intValue();
              }
              catch (Exception localException5)
              {
                try
                {
                  for (;;)
                  {
                    i1 = Integer.valueOf(str6).intValue();
                    paramIntent.putExtra("filter", str1);
                    paramIntent.putExtra("filterGender", i);
                    paramIntent.putExtra("filter_time", j);
                    paramIntent.putExtra("filter_age", k);
                    paramIntent.putExtra("filter_xingzuo", m);
                    paramIntent.putExtra("filter_interest", i1);
                    paramIntent.putExtra("filter_career", n);
                    paramIntent.putExtra("filter_location", str8);
                    return;
                    str2 = "";
                    break;
                    str3 = "";
                    break label96;
                    label369:
                    str4 = "";
                    break label122;
                    label376:
                    str5 = "";
                    break label148;
                    label383:
                    str6 = "";
                    break label174;
                    label390:
                    str7 = "";
                    break label200;
                    label397:
                    str8 = "";
                    continue;
                    localException1 = localException1;
                    int i = 0;
                    continue;
                    localException2 = localException2;
                    int j = 3;
                    continue;
                    localException3 = localException3;
                    int k = 0;
                    continue;
                    localException4 = localException4;
                    int m = 0;
                    continue;
                    localException5 = localException5;
                    int n = 0;
                  }
                }
                catch (Exception localException6)
                {
                  for (;;)
                  {
                    int i1 = 0;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = C();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("GotoNearbyAction", 1, "doAction error: " + localException.getMessage());
      a("GotoNearbyAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aowq
 * JD-Core Version:    0.7.0.1
 */