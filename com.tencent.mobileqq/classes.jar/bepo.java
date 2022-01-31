import android.os.Bundle;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

@begu(a={"com.tencent.qqmini.sdk.runtime.flutter.FlutterRuntimeLoader", "com.tencent.qqmini.sdk.runtime.app.AppRuntimeLoader", "com.tencent.qqmini.sdk.minigame.GameRuntimeLoader"})
public class bepo
{
  private static volatile bepo jdField_a_of_type_Bepo;
  private static volatile byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private bepn jdField_a_of_type_Bepn = new bepp(this);
  private beqk jdField_a_of_type_Beqk = new beqk(this);
  private final HashMap<Class<bepv>, bepv> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final LinkedList<bepv> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private final Vector<bepn> jdField_a_of_type_JavaUtilVector = new Vector();
  
  public bepo()
  {
    besl.b("minisdk-start_AppRuntimeLoaderManager", "RuntimeLoaderConfig:" + this.jdField_a_of_type_Beqk.toString());
  }
  
  public static bepo a()
  {
    if (jdField_a_of_type_Bepo == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bepo == null) {
        jdField_a_of_type_Bepo = new bepo();
      }
      return jdField_a_of_type_Bepo;
    }
  }
  
  private bepv a(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    Iterator localIterator = this.jdField_a_of_type_Beqk.a().iterator();
    while (localIterator.hasNext())
    {
      beql localbeql = (beql)localIterator.next();
      if ((localbeql.jdField_a_of_type_Bepw.a(paramBundle)) && (localbeql.jdField_a_of_type_Bepw.a(paramMiniAppInfo)))
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localbeql.jdField_a_of_type_JavaLangClass)) {}
        for (paramMiniAppInfo = (bepv)this.jdField_a_of_type_JavaUtilHashMap.remove(localbeql.jdField_a_of_type_JavaLangClass);; paramMiniAppInfo = (bepv)localbeql.jdField_a_of_type_Bepw.a(MiniAppEnv.g().getContext(), paramBundle))
        {
          paramMiniAppInfo.addRuntimeStateObserver(this.jdField_a_of_type_Bepn);
          return paramMiniAppInfo;
        }
      }
    }
    return null;
  }
  
  private void a(bepm parambepm)
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
      while (localIterator.hasNext()) {
        ((bepn)localIterator.next()).a(parambepm);
      }
    }
    finally {}
  }
  
  private void b(bepv parambepv)
  {
    if (parambepv != null) {}
    try
    {
      if (parambepv.getMiniAppInfo() != null) {
        this.jdField_a_of_type_JavaUtilLinkedList.addFirst(parambepv);
      }
      return;
    }
    finally
    {
      parambepv = finally;
      throw parambepv;
    }
  }
  
  public bepv a()
  {
    try
    {
      Object localObject = new LinkedList(this.jdField_a_of_type_JavaUtilLinkedList);
      if (((LinkedList)localObject).size() > 0)
      {
        localObject = (bepv)((LinkedList)localObject).peekFirst();
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      besl.d("minisdk-start_AppRuntimeLoaderManager", "getCurrentRunTimeLoader exception!", localThrowable);
    }
    return null;
  }
  
  public bepv a(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    besl.b("minisdk-start_AppRuntimeLoaderManager", "queryAppRunTimeLoader appId=" + paramMiniAppInfo.appId + " name=" + paramMiniAppInfo.name + " versionType=" + paramMiniAppInfo.verType + " version=" + paramMiniAppInfo.version);
    try
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedList).iterator();
      while (localIterator.hasNext())
      {
        bepv localbepv = (bepv)localIterator.next();
        if (localbepv.getMiniAppInfo() != null)
        {
          boolean bool = localbepv.getMiniAppInfo().equals(paramMiniAppInfo);
          if (bool) {
            return localbepv;
          }
        }
      }
    }
    catch (Throwable paramMiniAppInfo)
    {
      besl.d("minisdk-start_AppRuntimeLoaderManager", "getAppBrandRunTime exception!", paramMiniAppInfo);
    }
    return null;
  }
  
  public bepv a(MiniAppInfo paramMiniAppInfo, bepx parambepx, Bundle paramBundle)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    try
    {
      paramBundle = a(paramMiniAppInfo, paramBundle);
      besl.b("minisdk-start_AppRuntimeLoaderManager", "initAppRuntimeLoader appId=" + paramMiniAppInfo.appId + " name=" + paramMiniAppInfo.name + " versionType=" + paramMiniAppInfo.verType + " version=" + paramMiniAppInfo.version + " obtainRuntimeLoader:" + paramBundle);
      paramBundle.setRuntimeLoadListener(new bepq(this, parambepx));
      paramBundle.loadMiniAppInfo(paramMiniAppInfo);
      paramBundle.start();
      b(paramBundle);
      return paramBundle;
    }
    catch (Throwable paramMiniAppInfo)
    {
      besl.d("minisdk-start_AppRuntimeLoaderManager", "getAppBrandRunTime exception!", paramMiniAppInfo);
    }
    return null;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_Beqk.a().iterator();
    while (localIterator.hasNext())
    {
      beql localbeql = (beql)localIterator.next();
      if (!localbeql.jdField_a_of_type_Bepw.a(null))
      {
        localbeql.jdField_a_of_type_Bepw.a(null);
      }
      else if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localbeql.jdField_a_of_type_JavaLangClass))
      {
        bepv localbepv = (bepv)localbeql.jdField_a_of_type_Bepw.a(MiniAppEnv.g().getContext(), new Bundle());
        localbepv.addRuntimeStateObserver(this.jdField_a_of_type_Bepn);
        localbepv.getAppStateManager().a = true;
        localbepv.start();
        this.jdField_a_of_type_JavaUtilHashMap.put(localbeql.jdField_a_of_type_JavaLangClass, localbepv);
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (a() != null) {
      a().notifyRuntimeEvent(paramInt, paramVarArgs);
    }
  }
  
  public void a(bepn parambepn)
  {
    if (parambepn != null) {}
    try
    {
      if (!this.jdField_a_of_type_JavaUtilVector.contains(parambepn)) {
        this.jdField_a_of_type_JavaUtilVector.addElement(parambepn);
      }
      return;
    }
    finally
    {
      parambepn = finally;
      throw parambepn;
    }
  }
  
  public void a(bepv parambepv)
  {
    if (parambepv != null) {}
    try
    {
      this.jdField_a_of_type_JavaUtilLinkedList.remove(parambepv);
      return;
    }
    finally
    {
      parambepv = finally;
      throw parambepv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bepo
 * JD-Core Version:    0.7.0.1
 */