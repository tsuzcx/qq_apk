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

public class bedj
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private arrd jdField_a_of_type_Arrd;
  public QQAppInterface a;
  
  public bedj(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  private arrd a()
  {
    if (this.jdField_a_of_type_Arrd == null) {
      this.jdField_a_of_type_Arrd = arrg.a();
    }
    return this.jdField_a_of_type_Arrd;
  }
  
  private void a()
  {
    ThreadManager.executeOnSubThread(new ConfigSetting.1(this));
  }
  
  private void b(arrd paramarrd)
  {
    if (paramarrd == null) {
      return;
    }
    try
    {
      paramarrd.a(((bebl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(122)).a());
      return;
    }
    catch (Exception paramarrd)
    {
      QLog.e("ConfigSetting", 2, " getTemplateListFromCgi failed :" + paramarrd.toString());
      paramarrd.printStackTrace();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public arrf a(String paramString)
  {
    Iterator localIterator = a().a().iterator();
    while (localIterator.hasNext())
    {
      arrf localarrf = (arrf)localIterator.next();
      if (localarrf.jdField_a_of_type_JavaLangString.contains(paramString)) {
        return localarrf;
      }
    }
    return null;
  }
  
  public String a(bedd parambedd)
  {
    Object localObject1;
    Object localObject2;
    if (((parambedd instanceof bedh)) || ((parambedd instanceof bedp)))
    {
      localObject1 = a().a();
      parambedd = auog.a(parambedd.a());
      localObject2 = ((Map)localObject1).keySet().iterator();
    }
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (arre)((Map)localObject1).get((String)((Iterator)localObject2).next());
      String[] arrayOfString = ((arre)localObject3).jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(parambedd)) {
          return ((arre)localObject3).jdField_a_of_type_JavaLangString;
        }
        i += 1;
      }
      continue;
      if ((parambedd instanceof bedo))
      {
        localObject2 = a().a();
        localObject1 = a().a();
        parambedd = parambedd.a();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (arrf)((Iterator)localObject2).next();
          if ((parambedd.contains(((arrf)localObject3).jdField_a_of_type_JavaLangString)) && (((SparseArray)localObject1).valueAt(((arrf)localObject3).b) != null)) {
            return ((arre)((SparseArray)localObject1).valueAt(((arrf)localObject3).b)).jdField_a_of_type_JavaLangString;
          }
        }
      }
    }
    return "";
  }
  
  public void a(arrd paramarrd)
  {
    if (paramarrd == null) {
      return;
    }
    this.jdField_a_of_type_Arrd = paramarrd;
    TicketManager localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
    if (TextUtils.isEmpty(localTicketManager.getPskey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "docs.qq.com")))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      paramarrd = new bedk(this, paramarrd);
      localTicketManager.getPskey(str, 16L, new String[] { "docs.qq.com" }, paramarrd);
      return;
    }
    ThreadManager.excute(new ConfigSetting.2(this, paramarrd), 128, null, false);
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
  
  public String[] a(bedd parambedd)
  {
    int i = 0;
    Map localMap = a().a();
    Object localObject = a().a();
    if (((parambedd instanceof bedh)) || ((parambedd instanceof bedp)))
    {
      parambedd = auog.a(parambedd.a());
      localObject = localMap.keySet().iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      arre localarre = (arre)localMap.get((String)((Iterator)localObject).next());
      String[] arrayOfString = localarre.jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(parambedd)) {
          return localarre.jdField_a_of_type_ArrayOfJavaLangString;
        }
        i += 1;
      }
      continue;
      parambedd = new String[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        parambedd[i] = ((arrf)((List)localObject).get(i)).jdField_a_of_type_JavaLangString;
        i += 1;
      }
      return parambedd;
    }
    return new String[0];
  }
  
  public String b(bedd parambedd)
  {
    Object localObject1;
    Object localObject2;
    if (((parambedd instanceof bedh)) || ((parambedd instanceof bedp)))
    {
      localObject1 = a().a();
      parambedd = auog.a(parambedd.a());
      localObject2 = ((Map)localObject1).keySet().iterator();
    }
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (arre)((Map)localObject1).get((String)((Iterator)localObject2).next());
      String[] arrayOfString = ((arre)localObject3).jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(parambedd)) {
          return ((arre)localObject3).jdField_b_of_type_JavaLangString;
        }
        i += 1;
      }
      continue;
      if ((parambedd instanceof bedo))
      {
        localObject2 = a().a();
        localObject1 = a().a();
        parambedd = parambedd.a();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (arrf)((Iterator)localObject2).next();
          if ((parambedd.contains(((arrf)localObject3).jdField_a_of_type_JavaLangString)) && (((SparseArray)localObject1).valueAt(((arrf)localObject3).b) != null)) {
            return ((arre)((SparseArray)localObject1).valueAt(((arrf)localObject3).b)).jdField_b_of_type_JavaLangString;
          }
        }
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bedj
 * JD-Core Version:    0.7.0.1
 */