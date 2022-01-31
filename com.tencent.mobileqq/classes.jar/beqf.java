import android.os.Bundle;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

@behl(a={"com.tencent.qqmini.sdk.runtime.flutter.FlutterRuntimeLoader", "com.tencent.qqmini.sdk.runtime.app.AppRuntimeLoader", "com.tencent.qqmini.sdk.minigame.GameRuntimeLoader"})
public class beqf
{
  private static volatile beqf jdField_a_of_type_Beqf;
  private static volatile byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private beqe jdField_a_of_type_Beqe = new beqg(this);
  private berb jdField_a_of_type_Berb = new berb(this);
  private final HashMap<Class<beqm>, beqm> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final LinkedList<beqm> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private final Vector<beqe> jdField_a_of_type_JavaUtilVector = new Vector();
  
  public beqf()
  {
    betc.b("minisdk-start_AppRuntimeLoaderManager", "RuntimeLoaderConfig:" + this.jdField_a_of_type_Berb.toString());
  }
  
  public static beqf a()
  {
    if (jdField_a_of_type_Beqf == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Beqf == null) {
        jdField_a_of_type_Beqf = new beqf();
      }
      return jdField_a_of_type_Beqf;
    }
  }
  
  private beqm a(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    Iterator localIterator = this.jdField_a_of_type_Berb.a().iterator();
    while (localIterator.hasNext())
    {
      berc localberc = (berc)localIterator.next();
      if ((localberc.jdField_a_of_type_Beqn.a(paramBundle)) && (localberc.jdField_a_of_type_Beqn.a(paramMiniAppInfo)))
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localberc.jdField_a_of_type_JavaLangClass)) {}
        for (paramMiniAppInfo = (beqm)this.jdField_a_of_type_JavaUtilHashMap.remove(localberc.jdField_a_of_type_JavaLangClass);; paramMiniAppInfo = (beqm)localberc.jdField_a_of_type_Beqn.a(MiniAppEnv.g().getContext(), paramBundle))
        {
          paramMiniAppInfo.addRuntimeStateObserver(this.jdField_a_of_type_Beqe);
          return paramMiniAppInfo;
        }
      }
    }
    return null;
  }
  
  private void a(beqd parambeqd)
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
      while (localIterator.hasNext()) {
        ((beqe)localIterator.next()).a(parambeqd);
      }
    }
    finally {}
  }
  
  private void b(beqm parambeqm)
  {
    if (parambeqm != null) {}
    try
    {
      if (parambeqm.getMiniAppInfo() != null) {
        this.jdField_a_of_type_JavaUtilLinkedList.addFirst(parambeqm);
      }
      return;
    }
    finally
    {
      parambeqm = finally;
      throw parambeqm;
    }
  }
  
  public beqm a()
  {
    try
    {
      Object localObject = new LinkedList(this.jdField_a_of_type_JavaUtilLinkedList);
      if (((LinkedList)localObject).size() > 0)
      {
        localObject = (beqm)((LinkedList)localObject).peekFirst();
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      betc.d("minisdk-start_AppRuntimeLoaderManager", "getCurrentRunTimeLoader exception!", localThrowable);
    }
    return null;
  }
  
  public beqm a(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    betc.b("minisdk-start_AppRuntimeLoaderManager", "queryAppRunTimeLoader appId=" + paramMiniAppInfo.appId + " name=" + paramMiniAppInfo.name + " versionType=" + paramMiniAppInfo.verType + " version=" + paramMiniAppInfo.version);
    try
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedList).iterator();
      while (localIterator.hasNext())
      {
        beqm localbeqm = (beqm)localIterator.next();
        if (localbeqm.getMiniAppInfo() != null)
        {
          boolean bool = localbeqm.getMiniAppInfo().equals(paramMiniAppInfo);
          if (bool) {
            return localbeqm;
          }
        }
      }
    }
    catch (Throwable paramMiniAppInfo)
    {
      betc.d("minisdk-start_AppRuntimeLoaderManager", "getAppBrandRunTime exception!", paramMiniAppInfo);
    }
    return null;
  }
  
  public beqm a(MiniAppInfo paramMiniAppInfo, beqo parambeqo, Bundle paramBundle)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    try
    {
      paramBundle = a(paramMiniAppInfo, paramBundle);
      betc.b("minisdk-start_AppRuntimeLoaderManager", "initAppRuntimeLoader appId=" + paramMiniAppInfo.appId + " name=" + paramMiniAppInfo.name + " versionType=" + paramMiniAppInfo.verType + " version=" + paramMiniAppInfo.version + " obtainRuntimeLoader:" + paramBundle);
      paramBundle.setRuntimeLoadListener(new beqh(this, parambeqo));
      paramBundle.loadMiniAppInfo(paramMiniAppInfo);
      paramBundle.start();
      b(paramBundle);
      return paramBundle;
    }
    catch (Throwable paramMiniAppInfo)
    {
      betc.d("minisdk-start_AppRuntimeLoaderManager", "getAppBrandRunTime exception!", paramMiniAppInfo);
    }
    return null;
  }
  
  public void a()
  {
    a(null);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (a() != null) {
      a().notifyRuntimeEvent(paramInt, paramVarArgs);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    boolean bool;
    Iterator localIterator;
    if (paramBundle == null)
    {
      bool = false;
      localIterator = this.jdField_a_of_type_Berb.a().iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      berc localberc = (berc)localIterator.next();
      if ((!bool) || ("com.tencent.qqmini.sdk.runtime.flutter.FlutterRuntimeLoader".equals(localberc.jdField_a_of_type_JavaLangClass.getName())))
      {
        if (!localberc.jdField_a_of_type_Beqn.a(paramBundle))
        {
          localberc.jdField_a_of_type_Beqn.a(paramBundle);
          continue;
          bool = paramBundle.getBoolean("isFlutterRuntimeProcess");
          break;
        }
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localberc.jdField_a_of_type_JavaLangClass))
        {
          beqm localbeqm = (beqm)localberc.jdField_a_of_type_Beqn.a(MiniAppEnv.g().getContext(), new Bundle());
          localbeqm.addRuntimeStateObserver(this.jdField_a_of_type_Beqe);
          localbeqm.getAppStateManager().a = true;
          localbeqm.start();
          this.jdField_a_of_type_JavaUtilHashMap.put(localberc.jdField_a_of_type_JavaLangClass, localbeqm);
        }
      }
    }
  }
  
  public void a(beqe parambeqe)
  {
    if (parambeqe != null) {}
    try
    {
      if (!this.jdField_a_of_type_JavaUtilVector.contains(parambeqe)) {
        this.jdField_a_of_type_JavaUtilVector.addElement(parambeqe);
      }
      return;
    }
    finally
    {
      parambeqe = finally;
      throw parambeqe;
    }
  }
  
  public void a(beqm parambeqm)
  {
    if (parambeqm != null) {}
    try
    {
      this.jdField_a_of_type_JavaUtilLinkedList.remove(parambeqm);
      return;
    }
    finally
    {
      parambeqm = finally;
      throw parambeqm;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beqf
 * JD-Core Version:    0.7.0.1
 */