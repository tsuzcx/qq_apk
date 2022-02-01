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

public class bdko
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private arbo jdField_a_of_type_Arbo;
  public QQAppInterface a;
  
  public bdko(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  private arbo a()
  {
    if (this.jdField_a_of_type_Arbo == null) {
      this.jdField_a_of_type_Arbo = arbr.a();
    }
    return this.jdField_a_of_type_Arbo;
  }
  
  private void a()
  {
    ThreadManager.executeOnSubThread(new ConfigSetting.1(this));
  }
  
  private void b(arbo paramarbo)
  {
    if (paramarbo == null) {
      return;
    }
    try
    {
      paramarbo.a(((bdiq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(122)).a());
      return;
    }
    catch (Exception paramarbo)
    {
      QLog.e("ConfigSetting", 2, " getTemplateListFromCgi failed :" + paramarbo.toString());
      paramarbo.printStackTrace();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public arbq a(String paramString)
  {
    Iterator localIterator = a().a().iterator();
    while (localIterator.hasNext())
    {
      arbq localarbq = (arbq)localIterator.next();
      if (localarbq.jdField_a_of_type_JavaLangString.contains(paramString)) {
        return localarbq;
      }
    }
    return null;
  }
  
  public String a(bdki parambdki)
  {
    Object localObject1;
    Object localObject2;
    if (((parambdki instanceof bdkm)) || ((parambdki instanceof bdku)))
    {
      localObject1 = a().a();
      parambdki = atwl.a(parambdki.a());
      localObject2 = ((Map)localObject1).keySet().iterator();
    }
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (arbp)((Map)localObject1).get((String)((Iterator)localObject2).next());
      String[] arrayOfString = ((arbp)localObject3).jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(parambdki)) {
          return ((arbp)localObject3).jdField_a_of_type_JavaLangString;
        }
        i += 1;
      }
      continue;
      if ((parambdki instanceof bdkt))
      {
        localObject2 = a().a();
        localObject1 = a().a();
        parambdki = parambdki.a();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (arbq)((Iterator)localObject2).next();
          if ((parambdki.contains(((arbq)localObject3).jdField_a_of_type_JavaLangString)) && (((SparseArray)localObject1).valueAt(((arbq)localObject3).b) != null)) {
            return ((arbp)((SparseArray)localObject1).valueAt(((arbq)localObject3).b)).jdField_a_of_type_JavaLangString;
          }
        }
      }
    }
    return "";
  }
  
  public void a(arbo paramarbo)
  {
    if (paramarbo == null) {
      return;
    }
    this.jdField_a_of_type_Arbo = paramarbo;
    TicketManager localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
    if (TextUtils.isEmpty(localTicketManager.getPskey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "docs.qq.com")))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      paramarbo = new bdkp(this, paramarbo);
      localTicketManager.GetPskey(str, 16L, new String[] { "docs.qq.com" }, paramarbo);
      return;
    }
    ThreadManager.excute(new ConfigSetting.2(this, paramarbo), 128, null, false);
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
  
  public String[] a(bdki parambdki)
  {
    int i = 0;
    Map localMap = a().a();
    Object localObject = a().a();
    if (((parambdki instanceof bdkm)) || ((parambdki instanceof bdku)))
    {
      parambdki = atwl.a(parambdki.a());
      localObject = localMap.keySet().iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      arbp localarbp = (arbp)localMap.get((String)((Iterator)localObject).next());
      String[] arrayOfString = localarbp.jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(parambdki)) {
          return localarbp.jdField_a_of_type_ArrayOfJavaLangString;
        }
        i += 1;
      }
      continue;
      parambdki = new String[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        parambdki[i] = ((arbq)((List)localObject).get(i)).jdField_a_of_type_JavaLangString;
        i += 1;
      }
      return parambdki;
    }
    return new String[0];
  }
  
  public String b(bdki parambdki)
  {
    Object localObject1;
    Object localObject2;
    if (((parambdki instanceof bdkm)) || ((parambdki instanceof bdku)))
    {
      localObject1 = a().a();
      parambdki = atwl.a(parambdki.a());
      localObject2 = ((Map)localObject1).keySet().iterator();
    }
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (arbp)((Map)localObject1).get((String)((Iterator)localObject2).next());
      String[] arrayOfString = ((arbp)localObject3).jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(parambdki)) {
          return ((arbp)localObject3).jdField_b_of_type_JavaLangString;
        }
        i += 1;
      }
      continue;
      if ((parambdki instanceof bdkt))
      {
        localObject2 = a().a();
        localObject1 = a().a();
        parambdki = parambdki.a();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (arbq)((Iterator)localObject2).next();
          if ((parambdki.contains(((arbq)localObject3).jdField_a_of_type_JavaLangString)) && (((SparseArray)localObject1).valueAt(((arbq)localObject3).b) != null)) {
            return ((arbp)((SparseArray)localObject1).valueAt(((arbq)localObject3).b)).jdField_b_of_type_JavaLangString;
          }
        }
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdko
 * JD-Core Version:    0.7.0.1
 */