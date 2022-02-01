import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
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

public class bcxc
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private aqjw jdField_a_of_type_Aqjw;
  public QQAppInterface a;
  
  public bcxc(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  private aqjw a()
  {
    if (this.jdField_a_of_type_Aqjw == null) {
      this.jdField_a_of_type_Aqjw = aqjz.a();
    }
    return this.jdField_a_of_type_Aqjw;
  }
  
  private void a()
  {
    ThreadManager.executeOnSubThread(new ConfigSettingForDataLine.2(this));
  }
  
  private void b(aqjw paramaqjw)
  {
    if (paramaqjw == null) {
      return;
    }
    try
    {
      paramaqjw.a(((bcvc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(122)).a());
      return;
    }
    catch (Exception paramaqjw)
    {
      QLog.e("ConfigSettingForDataLine", 2, " getTemplateListFromCgi failed :" + paramaqjw.toString());
      paramaqjw.printStackTrace();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a(bcww parambcww)
  {
    if ((parambcww instanceof bcwz))
    {
      Map localMap = a().a();
      parambcww = FileUtil.getExtension(parambcww.a());
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        aqjx localaqjx = (aqjx)localMap.get((String)localIterator.next());
        String[] arrayOfString = localaqjx.jdField_b_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(parambcww)) {
            return localaqjx.jdField_a_of_type_JavaLangString;
          }
          i += 1;
        }
      }
    }
    return "";
  }
  
  public void a(aqjw paramaqjw)
  {
    if (paramaqjw == null) {
      return;
    }
    this.jdField_a_of_type_Aqjw = paramaqjw;
    TicketManager localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
    if (TextUtils.isEmpty(localTicketManager.getPskey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "docs.qq.com")))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      paramaqjw = new bcxd(this, paramaqjw);
      localTicketManager.getPskey(str, 16L, new String[] { "docs.qq.com" }, paramaqjw);
      return;
    }
    ThreadManager.excute(new ConfigSettingForDataLine.1(this, paramaqjw), 128, null, false);
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
  
  public String[] a(bcww parambcww)
  {
    int i = 0;
    Map localMap = a().a();
    Object localObject = a().a();
    if ((parambcww instanceof bcwz))
    {
      parambcww = FileUtil.getExtension(parambcww.a());
      localObject = localMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        aqjx localaqjx = (aqjx)localMap.get((String)((Iterator)localObject).next());
        String[] arrayOfString = localaqjx.jdField_b_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(parambcww)) {
            return localaqjx.jdField_a_of_type_ArrayOfJavaLangString;
          }
          i += 1;
        }
      }
    }
    parambcww = new String[((List)localObject).size()];
    while (i < ((List)localObject).size())
    {
      parambcww[i] = ((aqjy)((List)localObject).get(i)).jdField_a_of_type_JavaLangString;
      i += 1;
    }
    return parambcww;
    return new String[0];
  }
  
  public String b(bcww parambcww)
  {
    if ((parambcww instanceof bcwz))
    {
      Map localMap = a().a();
      parambcww = FileUtil.getExtension(parambcww.a());
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        aqjx localaqjx = (aqjx)localMap.get((String)localIterator.next());
        String[] arrayOfString = localaqjx.jdField_b_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(parambcww)) {
            return localaqjx.jdField_b_of_type_JavaLangString;
          }
          i += 1;
        }
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxc
 * JD-Core Version:    0.7.0.1
 */