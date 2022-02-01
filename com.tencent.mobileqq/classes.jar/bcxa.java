import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
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

public class bcxa
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private aqlb jdField_a_of_type_Aqlb;
  public QQAppInterface a;
  
  public bcxa(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  private aqlb a()
  {
    if (this.jdField_a_of_type_Aqlb == null) {
      this.jdField_a_of_type_Aqlb = aqle.a();
    }
    return this.jdField_a_of_type_Aqlb;
  }
  
  private void a()
  {
    ThreadManager.executeOnSubThread(new ConfigSetting.1(this));
  }
  
  private void b(aqlb paramaqlb)
  {
    if (paramaqlb == null) {
      return;
    }
    try
    {
      paramaqlb.a(((bcvc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(122)).a());
      return;
    }
    catch (Exception paramaqlb)
    {
      QLog.e("ConfigSetting", 2, " getTemplateListFromCgi failed :" + paramaqlb.toString());
      paramaqlb.printStackTrace();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public aqld a(String paramString)
  {
    Iterator localIterator = a().a().iterator();
    while (localIterator.hasNext())
    {
      aqld localaqld = (aqld)localIterator.next();
      if (localaqld.jdField_a_of_type_JavaLangString.contains(paramString)) {
        return localaqld;
      }
    }
    return null;
  }
  
  public String a(bcwu parambcwu)
  {
    Object localObject1;
    Object localObject2;
    if (((parambcwu instanceof bcwy)) || ((parambcwu instanceof bcxg)))
    {
      localObject1 = a().a();
      parambcwu = FileUtil.getExtension(parambcwu.a());
      localObject2 = ((Map)localObject1).keySet().iterator();
    }
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (aqlc)((Map)localObject1).get((String)((Iterator)localObject2).next());
      String[] arrayOfString = ((aqlc)localObject3).jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(parambcwu)) {
          return ((aqlc)localObject3).jdField_a_of_type_JavaLangString;
        }
        i += 1;
      }
      continue;
      if ((parambcwu instanceof bcxf))
      {
        localObject2 = a().a();
        localObject1 = a().a();
        parambcwu = parambcwu.a();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (aqld)((Iterator)localObject2).next();
          if ((parambcwu.contains(((aqld)localObject3).jdField_a_of_type_JavaLangString)) && (((SparseArray)localObject1).valueAt(((aqld)localObject3).b) != null)) {
            return ((aqlc)((SparseArray)localObject1).valueAt(((aqld)localObject3).b)).jdField_a_of_type_JavaLangString;
          }
        }
      }
    }
    return "";
  }
  
  public void a(aqlb paramaqlb)
  {
    if (paramaqlb == null) {
      return;
    }
    this.jdField_a_of_type_Aqlb = paramaqlb;
    TicketManager localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
    if (TextUtils.isEmpty(localTicketManager.getPskey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "docs.qq.com")))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      paramaqlb = new bcxb(this, paramaqlb);
      localTicketManager.getPskey(str, 16L, new String[] { "docs.qq.com" }, paramaqlb);
      return;
    }
    ThreadManager.excute(new ConfigSetting.2(this, paramaqlb), 128, null, false);
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
  
  public String[] a(bcwu parambcwu)
  {
    int i = 0;
    Map localMap = a().a();
    Object localObject = a().a();
    if (((parambcwu instanceof bcwy)) || ((parambcwu instanceof bcxg)))
    {
      parambcwu = FileUtil.getExtension(parambcwu.a());
      localObject = localMap.keySet().iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      aqlc localaqlc = (aqlc)localMap.get((String)((Iterator)localObject).next());
      String[] arrayOfString = localaqlc.jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(parambcwu)) {
          return localaqlc.jdField_a_of_type_ArrayOfJavaLangString;
        }
        i += 1;
      }
      continue;
      parambcwu = new String[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        parambcwu[i] = ((aqld)((List)localObject).get(i)).jdField_a_of_type_JavaLangString;
        i += 1;
      }
      return parambcwu;
    }
    return new String[0];
  }
  
  public String b(bcwu parambcwu)
  {
    Object localObject1;
    Object localObject2;
    if (((parambcwu instanceof bcwy)) || ((parambcwu instanceof bcxg)))
    {
      localObject1 = a().a();
      parambcwu = FileUtil.getExtension(parambcwu.a());
      localObject2 = ((Map)localObject1).keySet().iterator();
    }
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (aqlc)((Map)localObject1).get((String)((Iterator)localObject2).next());
      String[] arrayOfString = ((aqlc)localObject3).jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(parambcwu)) {
          return ((aqlc)localObject3).jdField_b_of_type_JavaLangString;
        }
        i += 1;
      }
      continue;
      if ((parambcwu instanceof bcxf))
      {
        localObject2 = a().a();
        localObject1 = a().a();
        parambcwu = parambcwu.a();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (aqld)((Iterator)localObject2).next();
          if ((parambcwu.contains(((aqld)localObject3).jdField_a_of_type_JavaLangString)) && (((SparseArray)localObject1).valueAt(((aqld)localObject3).b) != null)) {
            return ((aqlc)((SparseArray)localObject1).valueAt(((aqld)localObject3).b)).jdField_b_of_type_JavaLangString;
          }
        }
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxa
 * JD-Core Version:    0.7.0.1
 */