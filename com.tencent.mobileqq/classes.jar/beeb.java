import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.util.FileUtil;
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

public class beeb
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private arnh jdField_a_of_type_Arnh;
  public QQAppInterface a;
  
  public beeb(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  private arnh a()
  {
    if (this.jdField_a_of_type_Arnh == null) {
      this.jdField_a_of_type_Arnh = arnk.a();
    }
    return this.jdField_a_of_type_Arnh;
  }
  
  private void a()
  {
    ThreadManager.executeOnSubThread(new ConfigSettingForDataLine.2(this));
  }
  
  private void b(arnh paramarnh)
  {
    if (paramarnh == null) {
      return;
    }
    try
    {
      paramarnh.a(((becb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER)).a());
      return;
    }
    catch (Exception paramarnh)
    {
      QLog.e("ConfigSettingForDataLine", 2, " getTemplateListFromCgi failed :" + paramarnh.toString());
      paramarnh.printStackTrace();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a(bedv parambedv)
  {
    if ((parambedv instanceof bedy))
    {
      Map localMap = a().a();
      parambedv = FileUtil.getExtension(parambedv.a());
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        arni localarni = (arni)localMap.get((String)localIterator.next());
        String[] arrayOfString = localarni.jdField_b_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(parambedv)) {
            return localarni.jdField_a_of_type_JavaLangString;
          }
          i += 1;
        }
      }
    }
    return "";
  }
  
  public void a(arnh paramarnh)
  {
    if (paramarnh == null) {
      return;
    }
    this.jdField_a_of_type_Arnh = paramarnh;
    TicketManager localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
    if (TextUtils.isEmpty(localTicketManager.getPskey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "docs.qq.com")))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      paramarnh = new beec(this, paramarnh);
      localTicketManager.getPskey(str, 16L, new String[] { "docs.qq.com" }, paramarnh);
      return;
    }
    ThreadManager.excute(new ConfigSettingForDataLine.1(this, paramarnh), 128, null, false);
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
  
  public String[] a(bedv parambedv)
  {
    int i = 0;
    Map localMap = a().a();
    Object localObject = a().a();
    if ((parambedv instanceof bedy))
    {
      parambedv = FileUtil.getExtension(parambedv.a());
      localObject = localMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        arni localarni = (arni)localMap.get((String)((Iterator)localObject).next());
        String[] arrayOfString = localarni.jdField_b_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(parambedv)) {
            return localarni.jdField_a_of_type_ArrayOfJavaLangString;
          }
          i += 1;
        }
      }
    }
    parambedv = new String[((List)localObject).size()];
    while (i < ((List)localObject).size())
    {
      parambedv[i] = ((arnj)((List)localObject).get(i)).jdField_a_of_type_JavaLangString;
      i += 1;
    }
    return parambedv;
    return new String[0];
  }
  
  public String b(bedv parambedv)
  {
    if ((parambedv instanceof bedy))
    {
      Map localMap = a().a();
      parambedv = FileUtil.getExtension(parambedv.a());
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        arni localarni = (arni)localMap.get((String)localIterator.next());
        String[] arrayOfString = localarni.jdField_b_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(parambedv)) {
            return localarni.jdField_b_of_type_JavaLangString;
          }
          i += 1;
        }
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beeb
 * JD-Core Version:    0.7.0.1
 */