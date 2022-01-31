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

public class ayhf
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ancy jdField_a_of_type_Ancy;
  public QQAppInterface a;
  
  public ayhf(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  private ancy a()
  {
    if (this.jdField_a_of_type_Ancy == null) {
      this.jdField_a_of_type_Ancy = andb.a();
    }
    return this.jdField_a_of_type_Ancy;
  }
  
  private void a()
  {
    ThreadManager.executeOnSubThread(new ConfigSetting.1(this));
  }
  
  private void b(ancy paramancy)
  {
    if (paramancy == null) {
      return;
    }
    try
    {
      paramancy.a(((ayfg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(122)).a());
      return;
    }
    catch (Exception paramancy)
    {
      QLog.e("ConfigSetting", 2, " getTemplateListFromCgi failed :" + paramancy.toString());
      paramancy.printStackTrace();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public anda a(String paramString)
  {
    Iterator localIterator = a().a().iterator();
    while (localIterator.hasNext())
    {
      anda localanda = (anda)localIterator.next();
      if (localanda.jdField_a_of_type_JavaLangString.contains(paramString)) {
        return localanda;
      }
    }
    return null;
  }
  
  public String a(aygz paramaygz)
  {
    Object localObject1;
    Object localObject2;
    if (((paramaygz instanceof ayhd)) || ((paramaygz instanceof ayhl)))
    {
      localObject1 = a().a();
      paramaygz = apvd.a(paramaygz.a());
      localObject2 = ((Map)localObject1).keySet().iterator();
    }
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (ancz)((Map)localObject1).get((String)((Iterator)localObject2).next());
      String[] arrayOfString = ((ancz)localObject3).jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramaygz)) {
          return ((ancz)localObject3).jdField_a_of_type_JavaLangString;
        }
        i += 1;
      }
      continue;
      if ((paramaygz instanceof ayhk))
      {
        localObject2 = a().a();
        localObject1 = a().a();
        paramaygz = paramaygz.a();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (anda)((Iterator)localObject2).next();
          if ((paramaygz.contains(((anda)localObject3).jdField_a_of_type_JavaLangString)) && (((SparseArray)localObject1).valueAt(((anda)localObject3).b) != null)) {
            return ((ancz)((SparseArray)localObject1).valueAt(((anda)localObject3).b)).jdField_a_of_type_JavaLangString;
          }
        }
      }
    }
    return "";
  }
  
  public void a(ancy paramancy)
  {
    if (paramancy == null) {
      return;
    }
    this.jdField_a_of_type_Ancy = paramancy;
    TicketManager localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
    if (TextUtils.isEmpty(localTicketManager.getPskey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "docs.qq.com")))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      paramancy = new ayhg(this, paramancy);
      localTicketManager.GetPskey(str, 16L, new String[] { "docs.qq.com" }, paramancy);
      return;
    }
    ThreadManager.excute(new ConfigSetting.2(this, paramancy), 128, null, false);
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
  
  public String[] a(aygz paramaygz)
  {
    int i = 0;
    Map localMap = a().a();
    Object localObject = a().a();
    if (((paramaygz instanceof ayhd)) || ((paramaygz instanceof ayhl)))
    {
      paramaygz = apvd.a(paramaygz.a());
      localObject = localMap.keySet().iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      ancz localancz = (ancz)localMap.get((String)((Iterator)localObject).next());
      String[] arrayOfString = localancz.jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramaygz)) {
          return localancz.jdField_a_of_type_ArrayOfJavaLangString;
        }
        i += 1;
      }
      continue;
      paramaygz = new String[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        paramaygz[i] = ((anda)((List)localObject).get(i)).jdField_a_of_type_JavaLangString;
        i += 1;
      }
      return paramaygz;
    }
    return new String[0];
  }
  
  public String b(aygz paramaygz)
  {
    Object localObject1;
    Object localObject2;
    if (((paramaygz instanceof ayhd)) || ((paramaygz instanceof ayhl)))
    {
      localObject1 = a().a();
      paramaygz = apvd.a(paramaygz.a());
      localObject2 = ((Map)localObject1).keySet().iterator();
    }
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (ancz)((Map)localObject1).get((String)((Iterator)localObject2).next());
      String[] arrayOfString = ((ancz)localObject3).jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramaygz)) {
          return ((ancz)localObject3).jdField_b_of_type_JavaLangString;
        }
        i += 1;
      }
      continue;
      if ((paramaygz instanceof ayhk))
      {
        localObject2 = a().a();
        localObject1 = a().a();
        paramaygz = paramaygz.a();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (anda)((Iterator)localObject2).next();
          if ((paramaygz.contains(((anda)localObject3).jdField_a_of_type_JavaLangString)) && (((SparseArray)localObject1).valueAt(((anda)localObject3).b) != null)) {
            return ((ancz)((SparseArray)localObject1).valueAt(((anda)localObject3).b)).jdField_b_of_type_JavaLangString;
          }
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