import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.teamwork.spread.ConfigSettingForDataLine.1;
import com.tencent.mobileqq.teamwork.spread.ConfigSettingForDataLine.2;
import com.tencent.mobileqq.teamwork.spread.ConfigSettingForDataLine.3;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class ayhf
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private anbm jdField_a_of_type_Anbm;
  public QQAppInterface a;
  
  public ayhf(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  private anbm a()
  {
    if (this.jdField_a_of_type_Anbm == null) {
      this.jdField_a_of_type_Anbm = anbp.a();
    }
    return this.jdField_a_of_type_Anbm;
  }
  
  private void a()
  {
    ThreadManager.executeOnSubThread(new ConfigSettingForDataLine.2(this));
  }
  
  private void b(anbm paramanbm)
  {
    if (paramanbm == null) {
      return;
    }
    try
    {
      paramanbm.a(((ayfe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(122)).a());
      return;
    }
    catch (Exception paramanbm)
    {
      QLog.e("ConfigSettingForDataLine", 2, " getTemplateListFromCgi failed :" + paramanbm.toString());
      paramanbm.printStackTrace();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a(aygz paramaygz)
  {
    if ((paramaygz instanceof ayhc))
    {
      Map localMap = a().a();
      paramaygz = apvb.a(paramaygz.a());
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        anbn localanbn = (anbn)localMap.get((String)localIterator.next());
        String[] arrayOfString = localanbn.jdField_b_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(paramaygz)) {
            return localanbn.jdField_a_of_type_JavaLangString;
          }
          i += 1;
        }
      }
    }
    return "";
  }
  
  public void a(anbm paramanbm)
  {
    if (paramanbm == null) {
      return;
    }
    this.jdField_a_of_type_Anbm = paramanbm;
    TicketManager localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
    if (TextUtils.isEmpty(localTicketManager.getPskey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "docs.qq.com")))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      paramanbm = new ayhg(this, paramanbm);
      localTicketManager.GetPskey(str, 16L, new String[] { "docs.qq.com" }, paramanbm);
      return;
    }
    ThreadManager.excute(new ConfigSettingForDataLine.1(this, paramanbm), 128, null, false);
  }
  
  public void a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Int += 1;
    ThreadManager.executeOnSubThread(new ConfigSettingForDataLine.3(this));
  }
  
  public boolean a()
  {
    boolean bool = false;
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_m_str_teamwork_dataline_tips_sp", 0).getLong("file_str_lstat_show_time_local", 0L);
    if (l - this.jdField_a_of_type_Long > a().b() * 1000) {
      bool = true;
    }
    return bool;
  }
  
  public String[] a(aygz paramaygz)
  {
    int i = 0;
    Map localMap = a().a();
    Object localObject = a().a();
    if ((paramaygz instanceof ayhc))
    {
      paramaygz = apvb.a(paramaygz.a());
      localObject = localMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        anbn localanbn = (anbn)localMap.get((String)((Iterator)localObject).next());
        String[] arrayOfString = localanbn.jdField_b_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(paramaygz)) {
            return localanbn.jdField_a_of_type_ArrayOfJavaLangString;
          }
          i += 1;
        }
      }
    }
    paramaygz = new String[((List)localObject).size()];
    while (i < ((List)localObject).size())
    {
      paramaygz[i] = ((anbo)((List)localObject).get(i)).jdField_a_of_type_JavaLangString;
      i += 1;
    }
    return paramaygz;
    return new String[0];
  }
  
  public String b(aygz paramaygz)
  {
    if ((paramaygz instanceof ayhc))
    {
      Map localMap = a().a();
      paramaygz = apvb.a(paramaygz.a());
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        anbn localanbn = (anbn)localMap.get((String)localIterator.next());
        String[] arrayOfString = localanbn.jdField_b_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(paramaygz)) {
            return localanbn.jdField_b_of_type_JavaLangString;
          }
          i += 1;
        }
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayhf
 * JD-Core Version:    0.7.0.1
 */