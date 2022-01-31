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

public class bafd
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private aosy jdField_a_of_type_Aosy;
  public QQAppInterface a;
  
  public bafd(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  private aosy a()
  {
    if (this.jdField_a_of_type_Aosy == null) {
      this.jdField_a_of_type_Aosy = aotb.a();
    }
    return this.jdField_a_of_type_Aosy;
  }
  
  private void a()
  {
    ThreadManager.executeOnSubThread(new ConfigSettingForDataLine.2(this));
  }
  
  private void b(aosy paramaosy)
  {
    if (paramaosy == null) {
      return;
    }
    try
    {
      paramaosy.a(((badd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(122)).a());
      return;
    }
    catch (Exception paramaosy)
    {
      QLog.e("ConfigSettingForDataLine", 2, " getTemplateListFromCgi failed :" + paramaosy.toString());
      paramaosy.printStackTrace();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a(baex parambaex)
  {
    if ((parambaex instanceof bafa))
    {
      Map localMap = a().a();
      parambaex = arof.a(parambaex.a());
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        aosz localaosz = (aosz)localMap.get((String)localIterator.next());
        String[] arrayOfString = localaosz.jdField_b_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(parambaex)) {
            return localaosz.jdField_a_of_type_JavaLangString;
          }
          i += 1;
        }
      }
    }
    return "";
  }
  
  public void a(aosy paramaosy)
  {
    if (paramaosy == null) {
      return;
    }
    this.jdField_a_of_type_Aosy = paramaosy;
    TicketManager localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
    if (TextUtils.isEmpty(localTicketManager.getPskey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "docs.qq.com")))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      paramaosy = new bafe(this, paramaosy);
      localTicketManager.GetPskey(str, 16L, new String[] { "docs.qq.com" }, paramaosy);
      return;
    }
    ThreadManager.excute(new ConfigSettingForDataLine.1(this, paramaosy), 128, null, false);
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
  
  public String[] a(baex parambaex)
  {
    int i = 0;
    Map localMap = a().a();
    Object localObject = a().a();
    if ((parambaex instanceof bafa))
    {
      parambaex = arof.a(parambaex.a());
      localObject = localMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        aosz localaosz = (aosz)localMap.get((String)((Iterator)localObject).next());
        String[] arrayOfString = localaosz.jdField_b_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(parambaex)) {
            return localaosz.jdField_a_of_type_ArrayOfJavaLangString;
          }
          i += 1;
        }
      }
    }
    parambaex = new String[((List)localObject).size()];
    while (i < ((List)localObject).size())
    {
      parambaex[i] = ((aota)((List)localObject).get(i)).jdField_a_of_type_JavaLangString;
      i += 1;
    }
    return parambaex;
    return new String[0];
  }
  
  public String b(baex parambaex)
  {
    if ((parambaex instanceof bafa))
    {
      Map localMap = a().a();
      parambaex = arof.a(parambaex.a());
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        aosz localaosz = (aosz)localMap.get((String)localIterator.next());
        String[] arrayOfString = localaosz.jdField_b_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(parambaex)) {
            return localaosz.jdField_b_of_type_JavaLangString;
          }
          i += 1;
        }
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafd
 * JD-Core Version:    0.7.0.1
 */