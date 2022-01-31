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

public class ayhd
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private anct jdField_a_of_type_Anct;
  public QQAppInterface a;
  
  public ayhd(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  private anct a()
  {
    if (this.jdField_a_of_type_Anct == null) {
      this.jdField_a_of_type_Anct = ancw.a();
    }
    return this.jdField_a_of_type_Anct;
  }
  
  private void a()
  {
    ThreadManager.executeOnSubThread(new ConfigSetting.1(this));
  }
  
  private void b(anct paramanct)
  {
    if (paramanct == null) {
      return;
    }
    try
    {
      paramanct.a(((ayfe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(122)).a());
      return;
    }
    catch (Exception paramanct)
    {
      QLog.e("ConfigSetting", 2, " getTemplateListFromCgi failed :" + paramanct.toString());
      paramanct.printStackTrace();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ancv a(String paramString)
  {
    Iterator localIterator = a().a().iterator();
    while (localIterator.hasNext())
    {
      ancv localancv = (ancv)localIterator.next();
      if (localancv.jdField_a_of_type_JavaLangString.contains(paramString)) {
        return localancv;
      }
    }
    return null;
  }
  
  public String a(aygx paramaygx)
  {
    Object localObject1;
    Object localObject2;
    if (((paramaygx instanceof ayhb)) || ((paramaygx instanceof ayhj)))
    {
      localObject1 = a().a();
      paramaygx = apvb.a(paramaygx.a());
      localObject2 = ((Map)localObject1).keySet().iterator();
    }
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (ancu)((Map)localObject1).get((String)((Iterator)localObject2).next());
      String[] arrayOfString = ((ancu)localObject3).jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramaygx)) {
          return ((ancu)localObject3).jdField_a_of_type_JavaLangString;
        }
        i += 1;
      }
      continue;
      if ((paramaygx instanceof ayhi))
      {
        localObject2 = a().a();
        localObject1 = a().a();
        paramaygx = paramaygx.a();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ancv)((Iterator)localObject2).next();
          if ((paramaygx.contains(((ancv)localObject3).jdField_a_of_type_JavaLangString)) && (((SparseArray)localObject1).valueAt(((ancv)localObject3).b) != null)) {
            return ((ancu)((SparseArray)localObject1).valueAt(((ancv)localObject3).b)).jdField_a_of_type_JavaLangString;
          }
        }
      }
    }
    return "";
  }
  
  public void a(anct paramanct)
  {
    if (paramanct == null) {
      return;
    }
    this.jdField_a_of_type_Anct = paramanct;
    TicketManager localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
    if (TextUtils.isEmpty(localTicketManager.getPskey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "docs.qq.com")))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      paramanct = new ayhe(this, paramanct);
      localTicketManager.GetPskey(str, 16L, new String[] { "docs.qq.com" }, paramanct);
      return;
    }
    ThreadManager.excute(new ConfigSetting.2(this, paramanct), 128, null, false);
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
  
  public String[] a(aygx paramaygx)
  {
    int i = 0;
    Map localMap = a().a();
    Object localObject = a().a();
    if (((paramaygx instanceof ayhb)) || ((paramaygx instanceof ayhj)))
    {
      paramaygx = apvb.a(paramaygx.a());
      localObject = localMap.keySet().iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      ancu localancu = (ancu)localMap.get((String)((Iterator)localObject).next());
      String[] arrayOfString = localancu.jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramaygx)) {
          return localancu.jdField_a_of_type_ArrayOfJavaLangString;
        }
        i += 1;
      }
      continue;
      paramaygx = new String[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        paramaygx[i] = ((ancv)((List)localObject).get(i)).jdField_a_of_type_JavaLangString;
        i += 1;
      }
      return paramaygx;
    }
    return new String[0];
  }
  
  public String b(aygx paramaygx)
  {
    Object localObject1;
    Object localObject2;
    if (((paramaygx instanceof ayhb)) || ((paramaygx instanceof ayhj)))
    {
      localObject1 = a().a();
      paramaygx = apvb.a(paramaygx.a());
      localObject2 = ((Map)localObject1).keySet().iterator();
    }
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (ancu)((Map)localObject1).get((String)((Iterator)localObject2).next());
      String[] arrayOfString = ((ancu)localObject3).jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramaygx)) {
          return ((ancu)localObject3).jdField_b_of_type_JavaLangString;
        }
        i += 1;
      }
      continue;
      if ((paramaygx instanceof ayhi))
      {
        localObject2 = a().a();
        localObject1 = a().a();
        paramaygx = paramaygx.a();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ancv)((Iterator)localObject2).next();
          if ((paramaygx.contains(((ancv)localObject3).jdField_a_of_type_JavaLangString)) && (((SparseArray)localObject1).valueAt(((ancv)localObject3).b) != null)) {
            return ((ancu)((SparseArray)localObject1).valueAt(((ancv)localObject3).b)).jdField_b_of_type_JavaLangString;
          }
        }
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayhd
 * JD-Core Version:    0.7.0.1
 */