import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.teamwork.spread.ConfigSetting.1;
import com.tencent.mobileqq.teamwork.spread.ConfigSetting.2;
import com.tencent.mobileqq.teamwork.spread.ConfigSetting.3;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class bafb
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private aouf jdField_a_of_type_Aouf;
  public QQAppInterface a;
  
  public bafb(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  private aouf a()
  {
    if (this.jdField_a_of_type_Aouf == null) {
      this.jdField_a_of_type_Aouf = aoui.a();
    }
    return this.jdField_a_of_type_Aouf;
  }
  
  private void a()
  {
    ThreadManager.executeOnSubThread(new ConfigSetting.1(this));
  }
  
  private void b(aouf paramaouf)
  {
    if (paramaouf == null) {
      return;
    }
    try
    {
      paramaouf.a(((badd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(122)).a());
      return;
    }
    catch (Exception paramaouf)
    {
      QLog.e("ConfigSetting", 2, " getTemplateListFromCgi failed :" + paramaouf.toString());
      paramaouf.printStackTrace();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public aouh a(String paramString)
  {
    Iterator localIterator = a().a().iterator();
    while (localIterator.hasNext())
    {
      aouh localaouh = (aouh)localIterator.next();
      if (localaouh.jdField_a_of_type_JavaLangString.contains(paramString)) {
        return localaouh;
      }
    }
    return null;
  }
  
  public String a(baev parambaev)
  {
    Object localObject1;
    Object localObject2;
    if (((parambaev instanceof baez)) || ((parambaev instanceof bafh)))
    {
      localObject1 = a().a();
      parambaev = arof.a(parambaev.a());
      localObject2 = ((Map)localObject1).keySet().iterator();
    }
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (aoug)((Map)localObject1).get((String)((Iterator)localObject2).next());
      String[] arrayOfString = ((aoug)localObject3).jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(parambaev)) {
          return ((aoug)localObject3).jdField_a_of_type_JavaLangString;
        }
        i += 1;
      }
      continue;
      if ((parambaev instanceof bafg))
      {
        localObject2 = a().a();
        localObject1 = a().a();
        parambaev = parambaev.a();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (aouh)((Iterator)localObject2).next();
          if ((parambaev.contains(((aouh)localObject3).jdField_a_of_type_JavaLangString)) && (((SparseArray)localObject1).valueAt(((aouh)localObject3).b) != null)) {
            return ((aoug)((SparseArray)localObject1).valueAt(((aouh)localObject3).b)).jdField_a_of_type_JavaLangString;
          }
        }
      }
    }
    return "";
  }
  
  public void a(aouf paramaouf)
  {
    if (paramaouf == null) {
      return;
    }
    this.jdField_a_of_type_Aouf = paramaouf;
    TicketManager localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
    if (TextUtils.isEmpty(localTicketManager.getPskey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "docs.qq.com")))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      paramaouf = new bafc(this, paramaouf);
      localTicketManager.GetPskey(str, 16L, new String[] { "docs.qq.com" }, paramaouf);
      return;
    }
    ThreadManager.excute(new ConfigSetting.2(this, paramaouf), 128, null, false);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForText)) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    this.jdField_a_of_type_Int += 1;
    ThreadManager.executeOnSubThread(new ConfigSetting.3(this));
  }
  
  public boolean a()
  {
    return System.currentTimeMillis() - this.jdField_a_of_type_Long > a().b() * 1000;
  }
  
  public String[] a(baev parambaev)
  {
    int i = 0;
    Map localMap = a().a();
    Object localObject = a().a();
    if (((parambaev instanceof baez)) || ((parambaev instanceof bafh)))
    {
      parambaev = arof.a(parambaev.a());
      localObject = localMap.keySet().iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      aoug localaoug = (aoug)localMap.get((String)((Iterator)localObject).next());
      String[] arrayOfString = localaoug.jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(parambaev)) {
          return localaoug.jdField_a_of_type_ArrayOfJavaLangString;
        }
        i += 1;
      }
      continue;
      parambaev = new String[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        parambaev[i] = ((aouh)((List)localObject).get(i)).jdField_a_of_type_JavaLangString;
        i += 1;
      }
      return parambaev;
    }
    return new String[0];
  }
  
  public String b(baev parambaev)
  {
    Object localObject1;
    Object localObject2;
    if (((parambaev instanceof baez)) || ((parambaev instanceof bafh)))
    {
      localObject1 = a().a();
      parambaev = arof.a(parambaev.a());
      localObject2 = ((Map)localObject1).keySet().iterator();
    }
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (aoug)((Map)localObject1).get((String)((Iterator)localObject2).next());
      String[] arrayOfString = ((aoug)localObject3).jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(parambaev)) {
          return ((aoug)localObject3).jdField_b_of_type_JavaLangString;
        }
        i += 1;
      }
      continue;
      if ((parambaev instanceof bafg))
      {
        localObject2 = a().a();
        localObject1 = a().a();
        parambaev = parambaev.a();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (aouh)((Iterator)localObject2).next();
          if ((parambaev.contains(((aouh)localObject3).jdField_a_of_type_JavaLangString)) && (((SparseArray)localObject1).valueAt(((aouh)localObject3).b) != null)) {
            return ((aoug)((SparseArray)localObject1).valueAt(((aouh)localObject3).b)).jdField_b_of_type_JavaLangString;
          }
        }
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafb
 * JD-Core Version:    0.7.0.1
 */