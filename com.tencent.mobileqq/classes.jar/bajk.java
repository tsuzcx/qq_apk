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

public class bajk
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private aoyo jdField_a_of_type_Aoyo;
  public QQAppInterface a;
  
  public bajk(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  private aoyo a()
  {
    if (this.jdField_a_of_type_Aoyo == null) {
      this.jdField_a_of_type_Aoyo = aoyr.a();
    }
    return this.jdField_a_of_type_Aoyo;
  }
  
  private void a()
  {
    ThreadManager.executeOnSubThread(new ConfigSetting.1(this));
  }
  
  private void b(aoyo paramaoyo)
  {
    if (paramaoyo == null) {
      return;
    }
    try
    {
      paramaoyo.a(((bahm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(122)).a());
      return;
    }
    catch (Exception paramaoyo)
    {
      QLog.e("ConfigSetting", 2, " getTemplateListFromCgi failed :" + paramaoyo.toString());
      paramaoyo.printStackTrace();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public aoyq a(String paramString)
  {
    Iterator localIterator = a().a().iterator();
    while (localIterator.hasNext())
    {
      aoyq localaoyq = (aoyq)localIterator.next();
      if (localaoyq.jdField_a_of_type_JavaLangString.contains(paramString)) {
        return localaoyq;
      }
    }
    return null;
  }
  
  public String a(baje parambaje)
  {
    Object localObject1;
    Object localObject2;
    if (((parambaje instanceof baji)) || ((parambaje instanceof bajq)))
    {
      localObject1 = a().a();
      parambaje = arso.a(parambaje.a());
      localObject2 = ((Map)localObject1).keySet().iterator();
    }
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (aoyp)((Map)localObject1).get((String)((Iterator)localObject2).next());
      String[] arrayOfString = ((aoyp)localObject3).jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(parambaje)) {
          return ((aoyp)localObject3).jdField_a_of_type_JavaLangString;
        }
        i += 1;
      }
      continue;
      if ((parambaje instanceof bajp))
      {
        localObject2 = a().a();
        localObject1 = a().a();
        parambaje = parambaje.a();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (aoyq)((Iterator)localObject2).next();
          if ((parambaje.contains(((aoyq)localObject3).jdField_a_of_type_JavaLangString)) && (((SparseArray)localObject1).valueAt(((aoyq)localObject3).b) != null)) {
            return ((aoyp)((SparseArray)localObject1).valueAt(((aoyq)localObject3).b)).jdField_a_of_type_JavaLangString;
          }
        }
      }
    }
    return "";
  }
  
  public void a(aoyo paramaoyo)
  {
    if (paramaoyo == null) {
      return;
    }
    this.jdField_a_of_type_Aoyo = paramaoyo;
    TicketManager localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
    if (TextUtils.isEmpty(localTicketManager.getPskey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "docs.qq.com")))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      paramaoyo = new bajl(this, paramaoyo);
      localTicketManager.GetPskey(str, 16L, new String[] { "docs.qq.com" }, paramaoyo);
      return;
    }
    ThreadManager.excute(new ConfigSetting.2(this, paramaoyo), 128, null, false);
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
  
  public String[] a(baje parambaje)
  {
    int i = 0;
    Map localMap = a().a();
    Object localObject = a().a();
    if (((parambaje instanceof baji)) || ((parambaje instanceof bajq)))
    {
      parambaje = arso.a(parambaje.a());
      localObject = localMap.keySet().iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      aoyp localaoyp = (aoyp)localMap.get((String)((Iterator)localObject).next());
      String[] arrayOfString = localaoyp.jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(parambaje)) {
          return localaoyp.jdField_a_of_type_ArrayOfJavaLangString;
        }
        i += 1;
      }
      continue;
      parambaje = new String[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        parambaje[i] = ((aoyq)((List)localObject).get(i)).jdField_a_of_type_JavaLangString;
        i += 1;
      }
      return parambaje;
    }
    return new String[0];
  }
  
  public String b(baje parambaje)
  {
    Object localObject1;
    Object localObject2;
    if (((parambaje instanceof baji)) || ((parambaje instanceof bajq)))
    {
      localObject1 = a().a();
      parambaje = arso.a(parambaje.a());
      localObject2 = ((Map)localObject1).keySet().iterator();
    }
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (aoyp)((Map)localObject1).get((String)((Iterator)localObject2).next());
      String[] arrayOfString = ((aoyp)localObject3).jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(parambaje)) {
          return ((aoyp)localObject3).jdField_b_of_type_JavaLangString;
        }
        i += 1;
      }
      continue;
      if ((parambaje instanceof bajp))
      {
        localObject2 = a().a();
        localObject1 = a().a();
        parambaje = parambaje.a();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (aoyq)((Iterator)localObject2).next();
          if ((parambaje.contains(((aoyq)localObject3).jdField_a_of_type_JavaLangString)) && (((SparseArray)localObject1).valueAt(((aoyq)localObject3).b) != null)) {
            return ((aoyp)((SparseArray)localObject1).valueAt(((aoyq)localObject3).b)).jdField_b_of_type_JavaLangString;
          }
        }
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajk
 * JD-Core Version:    0.7.0.1
 */