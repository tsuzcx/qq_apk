import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.1;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class atul
  implements INetInfoHandler
{
  private static atul jdField_a_of_type_Atul;
  private static boolean b;
  private int jdField_a_of_type_Int = 1;
  private atuj jdField_a_of_type_Atuj = new atuj();
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private boolean c;
  private boolean d = true;
  private boolean e = true;
  private boolean f = true;
  private boolean g = true;
  
  private int a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return 0;
    }
    paramQQAppInterface = (atsh)paramQQAppInterface.getManager(317);
    if (paramQQAppInterface == null) {
      return 0;
    }
    return paramQQAppInterface.a();
  }
  
  public static atul a()
  {
    try
    {
      if (jdField_a_of_type_Atul == null)
      {
        jdField_a_of_type_Atul = new atul();
        jdField_a_of_type_Atul.a();
      }
      atul localatul = jdField_a_of_type_Atul;
      return localatul;
    }
    finally {}
  }
  
  private atun a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      if ((paramString.contains("[")) && (paramString.contains("]")))
      {
        i = paramString.indexOf("[");
        int j = paramString.indexOf("]");
        if (j > i) {
          return new atun(paramString.substring(i, j + 1), paramInt);
        }
        QLog.d("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] innerDnsIpPortStr2IPInfo err. ipPortStr:" + paramString);
        return null;
      }
    }
    catch (Exception localException)
    {
      QLog.e("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] innerDnsIpPortStr2IPInfo exp. ipPortStr:" + paramString);
      return null;
    }
    int i = paramString.lastIndexOf(":");
    if (i >= 0) {
      return new atun(paramString.substring(0, i), paramInt);
    }
    atun localatun = new atun(paramString, paramInt);
    return localatun;
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private List<atun> a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject2 = null;
    if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
    {
      boolean bool2 = false;
      String str2 = "";
      ArrayList localArrayList = InnerDns.getInstance().reqDnsForIpList(paramString, 1019, true, 28);
      String str1 = str2;
      boolean bool1 = bool2;
      Object localObject1 = localObject2;
      if (localArrayList != null)
      {
        str1 = str2;
        bool1 = bool2;
        localObject1 = localObject2;
        if (localArrayList.size() > 0)
        {
          localObject1 = new ArrayList();
          if (paramBoolean != true) {
            break label179;
          }
        }
      }
      label179:
      for (int i = localArrayList.size();; i = 1)
      {
        a((List)localObject1, localArrayList, paramInt1, i);
        str1 = localObject1.toString();
        bool1 = true;
        QLog.i("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] getIPv6ListByInnerDns[" + paramString + "] result:" + bool1 + " IPv6List[" + str1 + "]");
        a(paramQQAppInterface, bool1, paramString, paramInt2);
        return localObject1;
      }
    }
    QLog.e("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] getIPv6ListByInnerDns err. domain=null");
    return null;
  }
  
  private void a()
  {
    ThreadManager.getSubThreadHandler().post(new FileIPv6StrateyController.1(this));
  }
  
  private void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString, int paramInt)
  {
    int i = 2;
    int k = 0;
    int j;
    label63:
    label95:
    HashMap localHashMap;
    if (g())
    {
      j = 2;
      switch (paramInt)
      {
      case 2: 
      case 4: 
      case 6: 
      default: 
        paramInt = 0;
        switch (auoo.a())
        {
        default: 
          i = 0;
        case 3: 
          localHashMap = new HashMap();
          localHashMap.put("param_domain", String.valueOf(paramString));
          if (!paramBoolean) {}
          break;
        }
        break;
      }
    }
    for (;;)
    {
      localHashMap.put("param_result", String.valueOf(k));
      localHashMap.put("param_stackType", String.valueOf(i));
      localHashMap.put("param_loginType", String.valueOf(j));
      localHashMap.put("param_bizType", String.valueOf(paramInt));
      paramString = this.jdField_a_of_type_JavaLangString;
      if (paramQQAppInterface != null) {
        paramString = paramQQAppInterface.getCurrentAccountUin();
      }
      bdmc.a(BaseApplication.getContext()).a(paramString, "actFAIPDerect", true, 0L, 0L, localHashMap, null);
      QLog.d("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] >> reportInnerDnsResult:" + localHashMap.toString());
      return;
      j = 1;
      break;
      paramInt = 1;
      break label63;
      paramInt = 2;
      break label63;
      paramInt = 3;
      break label63;
      paramInt = 4;
      break label63;
      i = 1;
      break label95;
      i = 3;
      break label95;
      k = 1;
    }
  }
  
  private void a(List<atun> paramList, List<String> paramList1, int paramInt1, int paramInt2)
  {
    if ((paramList1 == null) || (paramList1.size() == 0) || (paramList == null) || (paramInt2 == 0)) {}
    int i;
    label33:
    Object localObject;
    do
    {
      return;
      paramList1 = paramList1.iterator();
      i = 0;
      if (!paramList1.hasNext()) {
        break;
      }
      localObject = (String)paramList1.next();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label100;
      }
      localObject = a((String)localObject, paramInt1);
      if (localObject == null) {
        break label100;
      }
    } while (i >= paramInt2);
    paramList.add(localObject);
    i += 1;
    label100:
    for (;;)
    {
      break label33;
      break;
    }
  }
  
  public static void a(List<atun> paramList, List<String> paramList1, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramList == null) || (paramList1 == null)) {
      return;
    }
    int i = paramList.size() - 1;
    label19:
    atun localatun;
    if (i >= 0)
    {
      localatun = (atun)paramList.get(i);
      if ((localatun != null) && (!TextUtils.isEmpty(localatun.jdField_a_of_type_JavaLangString)))
      {
        if (!paramBoolean1) {
          break label108;
        }
        if (!paramBoolean2) {
          break label93;
        }
        if (!TextUtils.isEmpty(localatun.a())) {
          paramList1.add(0, localatun.a());
        }
      }
    }
    for (;;)
    {
      i -= 1;
      break label19;
      break;
      label93:
      paramList1.add(0, localatun.jdField_a_of_type_JavaLangString);
      continue;
      label108:
      if (paramBoolean2)
      {
        if (!TextUtils.isEmpty(localatun.a())) {
          paramList1.add(0, localatun.a() + ":" + localatun.jdField_a_of_type_Int);
        }
      }
      else {
        paramList1.add(0, localatun.jdField_a_of_type_JavaLangString + ":" + localatun.jdField_a_of_type_Int);
      }
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public static boolean a()
  {
    return false;
  }
  
  private void b() {}
  
  private boolean g()
  {
    return MsfServiceSdk.get().getConnectedIPFamily() == 2;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public atuo a(QQAppInterface paramQQAppInterface, atum paramatum, int paramInt)
  {
    if (paramatum == null) {
      return null;
    }
    if (paramQQAppInterface == null) {
      paramQQAppInterface = a();
    }
    for (;;)
    {
      if (!a(paramQQAppInterface, paramInt)) {
        return null;
      }
      if (paramQQAppInterface != null) {
        this.jdField_a_of_type_JavaLangString = paramQQAppInterface.c();
      }
      for (;;)
      {
        QLog.i("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] getIPlistForV6Domain on enable IPV6. busType:" + paramInt + " ipv6Domain:" + paramatum.jdField_a_of_type_JavaLangString + " port:" + paramatum.jdField_a_of_type_Int + " stacktype:" + auoo.a() + " isV6Login:" + g() + " stratey:" + a(paramQQAppInterface));
        if (1 != auoo.a()) {
          break;
        }
        return null;
        QLog.w("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] getIPv6ListByInnerDns err. app=null");
      }
      Object localObject;
      if (3 == auoo.a())
      {
        paramQQAppInterface = a(paramQQAppInterface, paramatum.jdField_a_of_type_JavaLangString, paramatum.jdField_a_of_type_Int, paramInt, true);
        localObject = new atuo();
        if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
        {
          ((atuo)localObject).jdField_a_of_type_Int = 2;
          ((atuo)localObject).jdField_a_of_type_JavaUtilList = paramQQAppInterface;
          return localObject;
        }
        b();
        ((atuo)localObject).jdField_a_of_type_Int = 1;
        ((atuo)localObject).jdField_a_of_type_JavaUtilList.add(new atun(paramatum.jdField_a_of_type_JavaLangString, paramatum.jdField_a_of_type_Int));
        return localObject;
      }
      if (2 == auoo.a())
      {
        if (a(paramQQAppInterface) == 0) {
          return null;
        }
        atuo localatuo;
        if (a(paramQQAppInterface) == 1)
        {
          localObject = a(paramQQAppInterface, paramatum.jdField_a_of_type_JavaLangString, paramatum.jdField_a_of_type_Int, paramInt, false);
          localatuo = new atuo();
          if ((localObject == null) || (((List)localObject).size() == 0))
          {
            b();
            localatuo.jdField_a_of_type_Int = 1;
            localatuo.jdField_a_of_type_JavaUtilList.add(new atun(paramatum.jdField_a_of_type_JavaLangString, paramatum.jdField_a_of_type_Int));
            return localatuo;
          }
          if (this.jdField_a_of_type_Atuj.a(paramatum))
          {
            localatuo.jdField_a_of_type_Int = 2;
            localatuo.jdField_a_of_type_JavaUtilList = ((List)localObject);
            return localatuo;
          }
          this.jdField_a_of_type_Atuj.a(paramQQAppInterface, paramatum, (atun)((List)localObject).get(0));
          return null;
        }
        if (a(paramQQAppInterface) == 2)
        {
          if (g())
          {
            localObject = a(paramQQAppInterface, paramatum.jdField_a_of_type_JavaLangString, paramatum.jdField_a_of_type_Int, paramInt, false);
            localatuo = new atuo();
            if ((localObject == null) || (((List)localObject).size() == 0))
            {
              b();
              localatuo.jdField_a_of_type_Int = 1;
              localatuo.jdField_a_of_type_JavaUtilList.add(new atun(paramatum.jdField_a_of_type_JavaLangString, paramatum.jdField_a_of_type_Int));
              return localatuo;
            }
            if (this.jdField_a_of_type_Atuj.a(paramatum))
            {
              localatuo.jdField_a_of_type_Int = 2;
              localatuo.jdField_a_of_type_JavaUtilList = ((List)localObject);
              return localatuo;
            }
            this.jdField_a_of_type_Atuj.a(paramQQAppInterface, paramatum, (atun)((List)localObject).get(0));
            return null;
          }
          return null;
        }
      }
      return null;
    }
  }
  
  public List<ExcitingTransferHostInfo> a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    int i = 0;
    Object localObject = paramQQAppInterface;
    if (paramQQAppInterface == null) {
      localObject = a();
    }
    if (!a((QQAppInterface)localObject, paramInt)) {}
    label289:
    for (;;)
    {
      return null;
      QLog.i("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] getIPV6listForExcitingUpload on enable IPV6. busType:" + paramInt + " stacktype:" + auoo.a() + " isV6Login:" + g() + " stratey:" + a((QQAppInterface)localObject));
      if (1 == auoo.a()) {
        paramInt = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label289;
        }
        localObject = aubf.a().a(true);
        if ((localObject == null) || (((List)localObject).size() == 0)) {
          break;
        }
        if (paramInt != 0)
        {
          return localObject;
          if (3 == auoo.a())
          {
            paramInt = 1;
            i = 1;
            continue;
          }
          if (2 == auoo.a())
          {
            if (a((QQAppInterface)localObject) == 0)
            {
              paramInt = 0;
              continue;
            }
            if (a((QQAppInterface)localObject) == 1)
            {
              paramInt = 0;
              i = 1;
              continue;
            }
            if (a((QQAppInterface)localObject) == 2)
            {
              if (g())
              {
                paramInt = 0;
                i = 1;
                continue;
              }
              paramInt = 0;
              continue;
            }
            paramInt = 0;
          }
        }
        else
        {
          paramQQAppInterface = new ArrayList();
          localObject = ((List)localObject).iterator();
          for (;;)
          {
            ExcitingTransferHostInfo localExcitingTransferHostInfo;
            if (((Iterator)localObject).hasNext())
            {
              localExcitingTransferHostInfo = (ExcitingTransferHostInfo)((Iterator)localObject).next();
              if (paramQQAppInterface.size() < 1) {}
            }
            else
            {
              return paramQQAppInterface;
            }
            paramQQAppInterface.add(localExcitingTransferHostInfo);
          }
        }
        paramInt = 0;
      }
    }
  }
  
  public List<String> a(QQAppInterface paramQQAppInterface, int paramInt, List<String> paramList)
  {
    int i = 0;
    Object localObject = paramQQAppInterface;
    if (paramQQAppInterface == null) {
      localObject = a();
    }
    if (!a((QQAppInterface)localObject, paramInt)) {}
    for (;;)
    {
      return null;
      QLog.i("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] getIPV6listForMediaPlatfrom on enable IPV6. busType:" + paramInt + " stacktype:" + auoo.a() + " isV6Login:" + g() + " stratey:" + a((QQAppInterface)localObject));
      if ((paramList != null) && (paramList.size() != 0))
      {
        if (1 == auoo.a()) {
          paramInt = 0;
        }
        while (i != 0)
        {
          paramQQAppInterface = new ArrayList();
          if (paramInt != 0)
          {
            paramQQAppInterface.addAll(paramList);
            return paramQQAppInterface;
            if (3 == auoo.a())
            {
              paramInt = 1;
              i = 1;
              continue;
            }
            if (2 == auoo.a())
            {
              if (a((QQAppInterface)localObject) == 0)
              {
                paramInt = 0;
                continue;
              }
              if (a((QQAppInterface)localObject) == 1)
              {
                paramInt = 0;
                i = 1;
                continue;
              }
              if (a((QQAppInterface)localObject) == 2)
              {
                if (g())
                {
                  paramInt = 0;
                  i = 1;
                  continue;
                }
                paramInt = 0;
                continue;
              }
              paramInt = 0;
            }
          }
          else
          {
            paramList = paramList.iterator();
            for (;;)
            {
              if (paramList.hasNext())
              {
                localObject = (String)paramList.next();
                if (paramQQAppInterface.size() < 1) {}
              }
              else
              {
                return paramQQAppInterface;
              }
              if (!TextUtils.isEmpty((CharSequence)localObject)) {
                paramQQAppInterface.add(localObject);
              }
            }
          }
          paramInt = 0;
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    QQAppInterface localQQAppInterface = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = a();
      localQQAppInterface = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        return false;
      }
    }
    paramQQAppInterface = (atsh)localQQAppInterface.getManager(317);
    if (paramQQAppInterface == null) {
      return false;
    }
    if (paramInt == 1) {
      return paramQQAppInterface.d();
    }
    if (paramInt == 3) {
      return paramQQAppInterface.e();
    }
    if (paramInt == 5) {
      return false;
    }
    if (paramInt == 7) {
      return paramQQAppInterface.g();
    }
    return false;
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public void c(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public void d(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  public void e(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean e()
  {
    return this.f;
  }
  
  public void f(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean f()
  {
    return this.g;
  }
  
  public void onNetMobile2None()
  {
    this.jdField_a_of_type_Atuj.a();
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    this.jdField_a_of_type_Atuj.a();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    this.jdField_a_of_type_Atuj.a();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    this.jdField_a_of_type_Atuj.a();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    this.jdField_a_of_type_Atuj.a();
  }
  
  public void onNetWifi2None()
  {
    this.jdField_a_of_type_Atuj.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atul
 * JD-Core Version:    0.7.0.1
 */