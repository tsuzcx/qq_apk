import android.os.Bundle;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

@bdcv(a={"com.tencent.qqmini.sdk.runtime.flutter.FlutterRuntimeLoader", "com.tencent.qqmini.sdk.runtime.app.AppRuntimeLoader", "com.tencent.qqmini.sdk.minigame.GameRuntimeLoader"})
public class bdli
{
  private static volatile bdli jdField_a_of_type_Bdli;
  private static volatile byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private bdlh jdField_a_of_type_Bdlh = new bdlj(this);
  private bdma jdField_a_of_type_Bdma = new bdma(this);
  private final HashMap<Class<bdlq>, bdlq> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final LinkedList<bdlq> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private final Vector<bdlh> jdField_a_of_type_JavaUtilVector = new Vector();
  
  public bdli()
  {
    bdnw.b("minisdk-start_AppRuntimeLoaderManager", "RuntimeLoaderConfig:" + this.jdField_a_of_type_Bdma.toString());
  }
  
  public static bdli a()
  {
    if (jdField_a_of_type_Bdli == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bdli == null) {
        jdField_a_of_type_Bdli = new bdli();
      }
      return jdField_a_of_type_Bdli;
    }
  }
  
  private bdlq a(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    Iterator localIterator = this.jdField_a_of_type_Bdma.a().iterator();
    while (localIterator.hasNext())
    {
      bdmb localbdmb = (bdmb)localIterator.next();
      if ((localbdmb.jdField_a_of_type_Bdlr.a(paramBundle)) && (localbdmb.jdField_a_of_type_Bdlr.a(paramMiniAppInfo)))
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localbdmb.jdField_a_of_type_JavaLangClass)) {}
        for (paramMiniAppInfo = (bdlq)this.jdField_a_of_type_JavaUtilHashMap.remove(localbdmb.jdField_a_of_type_JavaLangClass);; paramMiniAppInfo = (bdlq)localbdmb.jdField_a_of_type_Bdlr.a(MiniAppEnv.g().getContext(), paramBundle))
        {
          paramMiniAppInfo.addRuntimeStateObserver(this.jdField_a_of_type_Bdlh);
          return paramMiniAppInfo;
        }
      }
    }
    return null;
  }
  
  private void a(bdlg parambdlg)
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
      while (localIterator.hasNext()) {
        ((bdlh)localIterator.next()).a(parambdlg);
      }
    }
    finally {}
  }
  
  private void b(bdlq parambdlq)
  {
    if (parambdlq != null) {}
    try
    {
      if (parambdlq.getMiniAppInfo() != null) {
        this.jdField_a_of_type_JavaUtilLinkedList.addFirst(parambdlq);
      }
      return;
    }
    finally
    {
      parambdlq = finally;
      throw parambdlq;
    }
  }
  
  private void c(bdlq parambdlq)
  {
    if (parambdlq != null) {}
    try
    {
      this.jdField_a_of_type_JavaUtilLinkedList.remove(parambdlq);
      return;
    }
    finally
    {
      parambdlq = finally;
      throw parambdlq;
    }
  }
  
  public bdlq a()
  {
    try
    {
      Object localObject = new LinkedList(this.jdField_a_of_type_JavaUtilLinkedList);
      if (((LinkedList)localObject).size() > 0)
      {
        localObject = (bdlq)((LinkedList)localObject).peekFirst();
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      bdnw.d("minisdk-start_AppRuntimeLoaderManager", "getCurrentRunTimeLoader exception!", localThrowable);
    }
    return null;
  }
  
  public bdlq a(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    bdnw.b("minisdk-start_AppRuntimeLoaderManager", "queryAppRunTimeLoader appId=" + paramMiniAppInfo.appId + " name=" + paramMiniAppInfo.name + " versionType=" + paramMiniAppInfo.verType + " version=" + paramMiniAppInfo.version);
    try
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedList).iterator();
      while (localIterator.hasNext())
      {
        bdlq localbdlq = (bdlq)localIterator.next();
        if (localbdlq.getMiniAppInfo() != null)
        {
          boolean bool = localbdlq.getMiniAppInfo().equals(paramMiniAppInfo);
          if (bool) {
            return localbdlq;
          }
        }
      }
    }
    catch (Throwable paramMiniAppInfo)
    {
      bdnw.d("minisdk-start_AppRuntimeLoaderManager", "getAppBrandRunTime exception!", paramMiniAppInfo);
    }
    return null;
  }
  
  public bdlq a(MiniAppInfo paramMiniAppInfo, bdls parambdls, Bundle paramBundle)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    try
    {
      paramBundle = a(paramMiniAppInfo, paramBundle);
      bdnw.b("minisdk-start_AppRuntimeLoaderManager", "initAppRuntimeLoader appId=" + paramMiniAppInfo.appId + " name=" + paramMiniAppInfo.name + " versionType=" + paramMiniAppInfo.verType + " version=" + paramMiniAppInfo.version + " obtainRuntimeLoader:" + paramBundle);
      paramBundle.setRuntimeLoadListener(new bdlk(this, parambdls));
      paramBundle.loadMiniAppInfo(paramMiniAppInfo);
      paramBundle.start();
      b(paramBundle);
      return paramBundle;
    }
    catch (Throwable paramMiniAppInfo)
    {
      bdnw.d("minisdk-start_AppRuntimeLoaderManager", "getAppBrandRunTime exception!", paramMiniAppInfo);
    }
    return null;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_Bdma.a().iterator();
    while (localIterator.hasNext())
    {
      bdmb localbdmb = (bdmb)localIterator.next();
      if (!localbdmb.jdField_a_of_type_Bdlr.a(null))
      {
        localbdmb.jdField_a_of_type_Bdlr.a(null);
      }
      else if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localbdmb.jdField_a_of_type_JavaLangClass))
      {
        bdlq localbdlq = (bdlq)localbdmb.jdField_a_of_type_Bdlr.a(MiniAppEnv.g().getContext(), new Bundle());
        localbdlq.addRuntimeStateObserver(this.jdField_a_of_type_Bdlh);
        localbdlq.getAppStateManager().a = true;
        localbdlq.start();
        this.jdField_a_of_type_JavaUtilHashMap.put(localbdmb.jdField_a_of_type_JavaLangClass, localbdlq);
      }
    }
  }
  
  public void a(bdlh parambdlh)
  {
    if (parambdlh != null) {}
    try
    {
      if (!this.jdField_a_of_type_JavaUtilVector.contains(parambdlh)) {
        this.jdField_a_of_type_JavaUtilVector.addElement(parambdlh);
      }
      return;
    }
    finally
    {
      parambdlh = finally;
      throw parambdlh;
    }
  }
  
  public void a(bdlq parambdlq)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilLinkedList.remove(parambdlq);
      this.jdField_a_of_type_JavaUtilLinkedList.addFirst(parambdlq);
      return;
    }
    catch (Throwable parambdlq)
    {
      bdnw.d("minisdk-start_AppRuntimeLoaderManager", "bringToFront exception!", parambdlq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdli
 * JD-Core Version:    0.7.0.1
 */