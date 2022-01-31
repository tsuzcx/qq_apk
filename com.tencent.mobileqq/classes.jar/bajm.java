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

public class bajm
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private aoxh jdField_a_of_type_Aoxh;
  public QQAppInterface a;
  
  public bajm(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  private aoxh a()
  {
    if (this.jdField_a_of_type_Aoxh == null) {
      this.jdField_a_of_type_Aoxh = aoxk.a();
    }
    return this.jdField_a_of_type_Aoxh;
  }
  
  private void a()
  {
    ThreadManager.executeOnSubThread(new ConfigSettingForDataLine.2(this));
  }
  
  private void b(aoxh paramaoxh)
  {
    if (paramaoxh == null) {
      return;
    }
    try
    {
      paramaoxh.a(((bahm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(122)).a());
      return;
    }
    catch (Exception paramaoxh)
    {
      QLog.e("ConfigSettingForDataLine", 2, " getTemplateListFromCgi failed :" + paramaoxh.toString());
      paramaoxh.printStackTrace();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a(bajg parambajg)
  {
    if ((parambajg instanceof bajj))
    {
      Map localMap = a().a();
      parambajg = arso.a(parambajg.a());
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        aoxi localaoxi = (aoxi)localMap.get((String)localIterator.next());
        String[] arrayOfString = localaoxi.jdField_b_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(parambajg)) {
            return localaoxi.jdField_a_of_type_JavaLangString;
          }
          i += 1;
        }
      }
    }
    return "";
  }
  
  public void a(aoxh paramaoxh)
  {
    if (paramaoxh == null) {
      return;
    }
    this.jdField_a_of_type_Aoxh = paramaoxh;
    TicketManager localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
    if (TextUtils.isEmpty(localTicketManager.getPskey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "docs.qq.com")))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      paramaoxh = new bajn(this, paramaoxh);
      localTicketManager.GetPskey(str, 16L, new String[] { "docs.qq.com" }, paramaoxh);
      return;
    }
    ThreadManager.excute(new ConfigSettingForDataLine.1(this, paramaoxh), 128, null, false);
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
  
  public String[] a(bajg parambajg)
  {
    int i = 0;
    Map localMap = a().a();
    Object localObject = a().a();
    if ((parambajg instanceof bajj))
    {
      parambajg = arso.a(parambajg.a());
      localObject = localMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        aoxi localaoxi = (aoxi)localMap.get((String)((Iterator)localObject).next());
        String[] arrayOfString = localaoxi.jdField_b_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(parambajg)) {
            return localaoxi.jdField_a_of_type_ArrayOfJavaLangString;
          }
          i += 1;
        }
      }
    }
    parambajg = new String[((List)localObject).size()];
    while (i < ((List)localObject).size())
    {
      parambajg[i] = ((aoxj)((List)localObject).get(i)).jdField_a_of_type_JavaLangString;
      i += 1;
    }
    return parambajg;
    return new String[0];
  }
  
  public String b(bajg parambajg)
  {
    if ((parambajg instanceof bajj))
    {
      Map localMap = a().a();
      parambajg = arso.a(parambajg.a());
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        aoxi localaoxi = (aoxi)localMap.get((String)localIterator.next());
        String[] arrayOfString = localaoxi.jdField_b_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(parambajg)) {
            return localaoxi.jdField_b_of_type_JavaLangString;
          }
          i += 1;
        }
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajm
 * JD-Core Version:    0.7.0.1
 */