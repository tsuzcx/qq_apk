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

public class axgz
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ammm jdField_a_of_type_Ammm;
  public QQAppInterface a;
  
  public axgz(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  private ammm a()
  {
    if (this.jdField_a_of_type_Ammm == null) {
      this.jdField_a_of_type_Ammm = ammp.a();
    }
    return this.jdField_a_of_type_Ammm;
  }
  
  private void a()
  {
    ThreadManager.executeOnSubThread(new ConfigSetting.1(this));
  }
  
  private void b(ammm paramammm)
  {
    if (paramammm == null) {
      return;
    }
    try
    {
      paramammm.a(((axfb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(122)).a());
      return;
    }
    catch (Exception paramammm)
    {
      QLog.e("ConfigSetting", 2, " getTemplateListFromCgi failed :" + paramammm.toString());
      paramammm.printStackTrace();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ammo a(String paramString)
  {
    Iterator localIterator = a().a().iterator();
    while (localIterator.hasNext())
    {
      ammo localammo = (ammo)localIterator.next();
      if (localammo.jdField_a_of_type_JavaLangString.contains(paramString)) {
        return localammo;
      }
    }
    return null;
  }
  
  public String a(axgt paramaxgt)
  {
    Object localObject1;
    Object localObject2;
    if (((paramaxgt instanceof axgx)) || ((paramaxgt instanceof axhf)))
    {
      localObject1 = a().a();
      paramaxgt = apdh.a(paramaxgt.a());
      localObject2 = ((Map)localObject1).keySet().iterator();
    }
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (ammn)((Map)localObject1).get((String)((Iterator)localObject2).next());
      String[] arrayOfString = ((ammn)localObject3).jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramaxgt)) {
          return ((ammn)localObject3).jdField_a_of_type_JavaLangString;
        }
        i += 1;
      }
      continue;
      if ((paramaxgt instanceof axhe))
      {
        localObject2 = a().a();
        localObject1 = a().a();
        paramaxgt = paramaxgt.a();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ammo)((Iterator)localObject2).next();
          if ((paramaxgt.contains(((ammo)localObject3).jdField_a_of_type_JavaLangString)) && (((SparseArray)localObject1).valueAt(((ammo)localObject3).b) != null)) {
            return ((ammn)((SparseArray)localObject1).valueAt(((ammo)localObject3).b)).jdField_a_of_type_JavaLangString;
          }
        }
      }
    }
    return "";
  }
  
  public void a(ammm paramammm)
  {
    if (paramammm == null) {
      return;
    }
    this.jdField_a_of_type_Ammm = paramammm;
    TicketManager localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
    if (TextUtils.isEmpty(localTicketManager.getPskey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "docs.qq.com")))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      paramammm = new axha(this, paramammm);
      localTicketManager.GetPskey(str, 16L, new String[] { "docs.qq.com" }, paramammm);
      return;
    }
    ThreadManager.excute(new ConfigSetting.2(this, paramammm), 128, null, false);
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
  
  public String[] a(axgt paramaxgt)
  {
    int i = 0;
    Map localMap = a().a();
    Object localObject = a().a();
    if (((paramaxgt instanceof axgx)) || ((paramaxgt instanceof axhf)))
    {
      paramaxgt = apdh.a(paramaxgt.a());
      localObject = localMap.keySet().iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      ammn localammn = (ammn)localMap.get((String)((Iterator)localObject).next());
      String[] arrayOfString = localammn.jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramaxgt)) {
          return localammn.jdField_a_of_type_ArrayOfJavaLangString;
        }
        i += 1;
      }
      continue;
      paramaxgt = new String[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        paramaxgt[i] = ((ammo)((List)localObject).get(i)).jdField_a_of_type_JavaLangString;
        i += 1;
      }
      return paramaxgt;
    }
    return new String[0];
  }
  
  public String b(axgt paramaxgt)
  {
    Object localObject1;
    Object localObject2;
    if (((paramaxgt instanceof axgx)) || ((paramaxgt instanceof axhf)))
    {
      localObject1 = a().a();
      paramaxgt = apdh.a(paramaxgt.a());
      localObject2 = ((Map)localObject1).keySet().iterator();
    }
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (ammn)((Map)localObject1).get((String)((Iterator)localObject2).next());
      String[] arrayOfString = ((ammn)localObject3).jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramaxgt)) {
          return ((ammn)localObject3).jdField_b_of_type_JavaLangString;
        }
        i += 1;
      }
      continue;
      if ((paramaxgt instanceof axhe))
      {
        localObject2 = a().a();
        localObject1 = a().a();
        paramaxgt = paramaxgt.a();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ammo)((Iterator)localObject2).next();
          if ((paramaxgt.contains(((ammo)localObject3).jdField_a_of_type_JavaLangString)) && (((SparseArray)localObject1).valueAt(((ammo)localObject3).b) != null)) {
            return ((ammn)((SparseArray)localObject1).valueAt(((ammo)localObject3).b)).jdField_b_of_type_JavaLangString;
          }
        }
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axgz
 * JD-Core Version:    0.7.0.1
 */