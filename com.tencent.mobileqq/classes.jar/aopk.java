import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.ModuleCallbackWrapper;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.QzoneMainRuntime;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

public abstract class aopk
  implements ark.ModuleCallbackWrapper
{
  public static boolean a;
  protected long a;
  protected ark.Application a;
  public String a;
  private HashMap<Long, ark.VariantWrapper> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Map<String, Set<aosz>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private long jdField_b_of_type_Long = 1L;
  public String b;
  private final HashMap<String, aopq> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  public String c;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  protected aopk(ark.Application paramApplication, long paramLong)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentArkArk$Application = paramApplication;
    this.jdField_a_of_type_JavaLangString = paramApplication.GetSpecific("appName");
    this.c = paramApplication.GetSpecific("appPath");
    this.jdField_b_of_type_JavaLangString = paramApplication.GetID();
    this.jdField_a_of_type_Long = paramLong;
    a();
  }
  
  public static Activity a()
  {
    if (BaseActivity.sTopActivity != null) {
      return BaseActivity.sTopActivity;
    }
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if ((localObject instanceof QzoneMainRuntime))
    {
      localObject = ((AppRuntime)localObject).getApplication().getResumeActivity();
      if (localObject != null) {
        return (Activity)((WeakReference)localObject).get();
      }
    }
    return null;
  }
  
  public static SessionInfo a()
  {
    SessionInfo localSessionInfo = null;
    Object localObject2 = a();
    Object localObject1 = localSessionInfo;
    if ((localObject2 instanceof FragmentActivity))
    {
      localObject2 = (FragmentActivity)localObject2;
      localObject1 = (ChatFragment)((FragmentActivity)localObject2).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localObject1 == null) {
        break label91;
      }
      localObject1 = ((ChatFragment)localObject1).a();
      if (localObject1 == null) {
        break label157;
      }
      localSessionInfo = ((BaseChatPie)localObject1).getSessionInfo();
      localObject1 = localSessionInfo;
      if (QLog.isColorLevel())
      {
        QLog.d("ArkApp.ArkAppModuleBase", 2, new Object[] { "multiAio.getTopChatSessionInfo form baseChatPie=", a(localSessionInfo) });
        localObject1 = localSessionInfo;
      }
    }
    for (;;)
    {
      return localObject1;
      label91:
      localObject1 = localSessionInfo;
      if ((localObject2 instanceof MiniChatActivity))
      {
        localObject2 = ((MiniChatActivity)localObject2).a();
        localObject1 = localSessionInfo;
        if ((localObject2 instanceof MiniChatFragment))
        {
          localSessionInfo = ((MiniChatFragment)localObject2).a();
          localObject1 = localSessionInfo;
          if (QLog.isColorLevel())
          {
            QLog.d("ArkApp.ArkAppModuleBase", 2, new Object[] { "multiAio.getTopChatSessionInfo form miniChatPie=", a(localSessionInfo) });
            return localSessionInfo;
            label157:
            localObject1 = null;
          }
        }
      }
    }
  }
  
  public static QQAppInterface a()
  {
    return aorg.a();
  }
  
  public static String a(SessionInfo paramSessionInfo)
  {
    return aorg.a(paramSessionInfo);
  }
  
  private void a()
  {
    aopq[] arrayOfaopq = a();
    if (arrayOfaopq != null)
    {
      int j = arrayOfaopq.length;
      int i = 0;
      while (i < j)
      {
        aopq localaopq = arrayOfaopq[i];
        this.jdField_b_of_type_JavaUtilHashMap.put(localaopq.a(), localaopq);
        i += 1;
      }
    }
  }
  
  private static boolean a()
  {
    return a() != null;
  }
  
  private boolean a(aopq paramaopq)
  {
    if (paramaopq.a()) {}
    while (this.jdField_a_of_type_Long == 0L) {
      return true;
    }
    return false;
  }
  
  private boolean b(aopq paramaopq)
  {
    if (a()) {
      return true;
    }
    return paramaopq.b();
  }
  
  private boolean c(aopq paramaopq)
  {
    return aonw.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentArkArk$Application, paramaopq.b());
  }
  
  public void Destruct()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ark.VariantWrapper)((Map.Entry)localIterator.next()).getValue()).Reset();
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public boolean HasMenthod(String paramString)
  {
    paramString = (aopq)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
    if (paramString == null) {
      return false;
    }
    if (!a(paramString))
    {
      QLog.i("ArkApp.ArkAppModuleBase", 1, "HasMethod, method not support app type, method=" + paramString);
      return false;
    }
    if (!b(paramString))
    {
      QLog.i("ArkApp.ArkAppModuleBase", 1, "HasMethod, method not support multi process, method=" + paramString);
      return false;
    }
    return true;
  }
  
  public boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    aopq localaopq = (aopq)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
    if (localaopq == null) {
      return false;
    }
    if (!a(paramString))
    {
      QLog.i("ArkApp.ArkAppModuleBase", 1, "Invoke, check frequency fail, method=" + paramString);
      return false;
    }
    if (!c(localaopq))
    {
      QLog.i("ArkApp.ArkAppModuleBase", 1, "Invoke, no permission, method=" + paramString);
      return false;
    }
    if ((a()) || (localaopq.b()))
    {
      localaopq.a(this, paramArrayOfVariantWrapper, paramVariantWrapper);
      return true;
    }
    QLog.i("ArkApp.ArkAppModuleBase", 1, "Invoke, method not support multiprocess, method=" + localaopq);
    return false;
  }
  
  long a(ark.VariantWrapper paramVariantWrapper)
  {
    if ((paramVariantWrapper == null) || (!paramVariantWrapper.IsFunction())) {
      return 0L;
    }
    this.jdField_b_of_type_Long += 1L;
    if (this.jdField_b_of_type_Long == 0L) {
      this.jdField_b_of_type_Long = 1L;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(this.jdField_b_of_type_Long), paramVariantWrapper);
    return this.jdField_b_of_type_Long;
  }
  
  public ark.VariantWrapper a(long paramLong)
  {
    ark.VariantWrapper localVariantWrapper = (ark.VariantWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
    return localVariantWrapper;
  }
  
  protected void a(String paramString, long paramLong1, long paramLong2)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramLong2 > 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ArkApp", 2, String.format("ModuleBase.addTokenBucket.api:%s,times:%d,period:%d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
      }
      Set localSet = (Set)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      Object localObject = localSet;
      if (localSet == null)
      {
        localObject = new HashSet();
        this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
      }
      ((Set)localObject).add(new aosz(paramLong1, paramLong2));
    }
  }
  
  public void a(List<aoti> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        aoti localaoti = (aoti)paramList.next();
        a(localaoti.jdField_a_of_type_JavaLangString, localaoti.jdField_a_of_type_Long, localaoti.jdField_b_of_type_Long);
      }
    }
  }
  
  protected boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = (Set)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (localObject == null) {
        return true;
      }
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        aosz localaosz = (aosz)((Iterator)localObject).next();
        if (!localaosz.a())
        {
          QLog.i("ArkApp", 2, String.format("ModuleBase.checkFrequency.Refuse:%s,%s ", new Object[] { paramString, localaosz.toString() }));
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  protected abstract aopq[] a();
  
  public ark.VariantWrapper b(long paramLong)
  {
    return (ark.VariantWrapper)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aopk
 * JD-Core Version:    0.7.0.1
 */