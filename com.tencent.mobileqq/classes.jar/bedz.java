import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.filemanager.util.FileUtil;
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

public class bedz
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private arom jdField_a_of_type_Arom;
  public QQAppInterface a;
  
  public bedz(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  private arom a()
  {
    if (this.jdField_a_of_type_Arom == null) {
      this.jdField_a_of_type_Arom = arop.a();
    }
    return this.jdField_a_of_type_Arom;
  }
  
  private void a()
  {
    ThreadManager.executeOnSubThread(new ConfigSetting.1(this));
  }
  
  private void b(arom paramarom)
  {
    if (paramarom == null) {
      return;
    }
    try
    {
      paramarom.a(((becb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER)).a());
      return;
    }
    catch (Exception paramarom)
    {
      QLog.e("ConfigSetting", 2, " getTemplateListFromCgi failed :" + paramarom.toString());
      paramarom.printStackTrace();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public aroo a(String paramString)
  {
    Iterator localIterator = a().a().iterator();
    while (localIterator.hasNext())
    {
      aroo localaroo = (aroo)localIterator.next();
      if (localaroo.jdField_a_of_type_JavaLangString.contains(paramString)) {
        return localaroo;
      }
    }
    return null;
  }
  
  public String a(bedt parambedt)
  {
    Object localObject1;
    Object localObject2;
    if (((parambedt instanceof bedx)) || ((parambedt instanceof beef)))
    {
      localObject1 = a().a();
      parambedt = FileUtil.getExtension(parambedt.a());
      localObject2 = ((Map)localObject1).keySet().iterator();
    }
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (aron)((Map)localObject1).get((String)((Iterator)localObject2).next());
      String[] arrayOfString = ((aron)localObject3).jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(parambedt)) {
          return ((aron)localObject3).jdField_a_of_type_JavaLangString;
        }
        i += 1;
      }
      continue;
      if ((parambedt instanceof beee))
      {
        localObject2 = a().a();
        localObject1 = a().a();
        parambedt = parambedt.a();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (aroo)((Iterator)localObject2).next();
          if ((parambedt.contains(((aroo)localObject3).jdField_a_of_type_JavaLangString)) && (((SparseArray)localObject1).valueAt(((aroo)localObject3).b) != null)) {
            return ((aron)((SparseArray)localObject1).valueAt(((aroo)localObject3).b)).jdField_a_of_type_JavaLangString;
          }
        }
      }
    }
    return "";
  }
  
  public void a(arom paramarom)
  {
    if (paramarom == null) {
      return;
    }
    this.jdField_a_of_type_Arom = paramarom;
    TicketManager localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
    if (TextUtils.isEmpty(localTicketManager.getPskey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "docs.qq.com")))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      paramarom = new beea(this, paramarom);
      localTicketManager.getPskey(str, 16L, new String[] { "docs.qq.com" }, paramarom);
      return;
    }
    ThreadManager.excute(new ConfigSetting.2(this, paramarom), 128, null, false);
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
  
  public String[] a(bedt parambedt)
  {
    int i = 0;
    Map localMap = a().a();
    Object localObject = a().a();
    if (((parambedt instanceof bedx)) || ((parambedt instanceof beef)))
    {
      parambedt = FileUtil.getExtension(parambedt.a());
      localObject = localMap.keySet().iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      aron localaron = (aron)localMap.get((String)((Iterator)localObject).next());
      String[] arrayOfString = localaron.jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(parambedt)) {
          return localaron.jdField_a_of_type_ArrayOfJavaLangString;
        }
        i += 1;
      }
      continue;
      parambedt = new String[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        parambedt[i] = ((aroo)((List)localObject).get(i)).jdField_a_of_type_JavaLangString;
        i += 1;
      }
      return parambedt;
    }
    return new String[0];
  }
  
  public String b(bedt parambedt)
  {
    Object localObject1;
    Object localObject2;
    if (((parambedt instanceof bedx)) || ((parambedt instanceof beef)))
    {
      localObject1 = a().a();
      parambedt = FileUtil.getExtension(parambedt.a());
      localObject2 = ((Map)localObject1).keySet().iterator();
    }
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (aron)((Map)localObject1).get((String)((Iterator)localObject2).next());
      String[] arrayOfString = ((aron)localObject3).jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(parambedt)) {
          return ((aron)localObject3).jdField_b_of_type_JavaLangString;
        }
        i += 1;
      }
      continue;
      if ((parambedt instanceof beee))
      {
        localObject2 = a().a();
        localObject1 = a().a();
        parambedt = parambedt.a();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (aroo)((Iterator)localObject2).next();
          if ((parambedt.contains(((aroo)localObject3).jdField_a_of_type_JavaLangString)) && (((SparseArray)localObject1).valueAt(((aroo)localObject3).b) != null)) {
            return ((aron)((SparseArray)localObject1).valueAt(((aroo)localObject3).b)).jdField_b_of_type_JavaLangString;
          }
        }
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bedz
 * JD-Core Version:    0.7.0.1
 */