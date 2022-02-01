import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.ApplicationCallback;
import com.tencent.ark.ark.Container;
import com.tencent.ark.ark.ModuleRegister;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.security.ArkAppUrlChecker;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenterEvent;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class bcjz
  implements bckb, ark.ApplicationCallback
{
  private ArrayList<WeakReference<bckk>> a = new ArrayList();
  
  private bckk a(long paramLong)
  {
    ark.Container localContainer = ark.arkGetContainer(paramLong);
    bckk localbckk;
    if (localContainer == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkNodeContainer", 2, "getArkNode, arkcontainer is null");
      }
      localbckk = null;
    }
    label150:
    label154:
    for (;;)
    {
      return localbckk;
      if (this.a.size() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArkNodeContainer", 2, "getArkNode, list is null");
        }
        return null;
      }
      int i = 0;
      if (i < this.a.size())
      {
        localbckk = (bckk)((WeakReference)this.a.get(i)).get();
        if ((localbckk == null) || (!(localbckk instanceof bcki))) {
          break label150;
        }
      }
      for (bcke localbcke = ((bcki)localbckk).a();; localbcke = null)
      {
        if ((localbcke != null) && (localbcke.getContainer() == localContainer)) {
          break label154;
        }
        i += 1;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("ArkNodeContainer", 2, "getArkNode, not found");
        }
        return null;
      }
    }
  }
  
  public void AppCreate(ark.Application paramApplication)
  {
    ArkAppCenterEvent.a(0, paramApplication.GetSpecific("appName"), null);
  }
  
  public void AppDestroy(ark.Application paramApplication)
  {
    paramApplication = paramApplication.GetSpecific("appName");
    ArkAppCenterEvent.a(1, paramApplication, null);
    aqfh.a(paramApplication);
  }
  
  public boolean CheckUrlLegalityCallback(ark.Application paramApplication, String paramString)
  {
    paramApplication = paramApplication.GetSpecific("appName");
    ArkAppUrlChecker localArkAppUrlChecker = ArkAppConfigMgr.getInstance().getUrlChecker(paramApplication);
    boolean bool;
    int i;
    if (localArkAppUrlChecker != null)
    {
      int j = localArkAppUrlChecker.checkUrlIsValidByAppResouceList(paramString);
      if (j == 0)
      {
        bool = true;
        if (bool) {
          break label170;
        }
        if (ArkAppConfigMgr.getInstance().isUrlCheckEnable(paramApplication)) {
          break label165;
        }
        QLog.e("ArkNodeContainer", 1, new Object[] { "ArkSafe.UrlCheck.setDisable.EngineCallback seach appName=", paramApplication, ",url=", noe.b(paramString, new String[0]), ", isValid set=true" });
        i = 2;
        bool = true;
        label97:
        aqfh.a(paramApplication, paramString, j, i, "");
      }
    }
    for (;;)
    {
      QLog.e("ArkNodeContainer", 1, new Object[] { "ArkSafe.EngineCallback search appName=", paramApplication, ",url=", noe.b(paramString, new String[0]), ", isValid=", Boolean.valueOf(bool) });
      return bool;
      bool = false;
      break;
      label165:
      i = 1;
      break label97;
      label170:
      i = 0;
      break label97;
      bool = true;
    }
  }
  
  public void OutputScriptError(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      paramString1 = "";
    }
    for (;;)
    {
      if (paramString2 == null) {
        paramString2 = "";
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ArkNodeContainer", 2, String.format("%s.script error: %s", new Object[] { paramString1, paramString2 }));
        }
        aqca.a(null, paramString1, "ScriptError", 0, 0, 0L, 0L, 0L, paramString2, "");
        return;
      }
    }
  }
  
  public void RegisterModules(ark.ModuleRegister paramModuleRegister, ark.Application paramApplication)
  {
    apwe.a(paramModuleRegister, paramApplication);
    String str = paramApplication.GetSpecific("appName");
    bcka localbcka = new bcka(paramApplication, apwe.a(str));
    localbcka.a(this);
    paramApplication = apxt.a();
    if ((!TextUtils.isEmpty(str)) && (paramApplication != null))
    {
      paramApplication = (ArkAppCenter)paramApplication.getManager(121);
      if (paramApplication == null) {}
    }
    for (paramApplication = paramApplication.a();; paramApplication = null)
    {
      if (paramApplication != null) {
        localbcka.a((List)apzu.a.get(localbcka.GetTypeName()));
      }
      paramModuleRegister.RegCallbackWrapper(localbcka);
      return;
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    bckk localbckk = a(paramLong);
    if ((localbckk != null) && ((localbckk instanceof bcki))) {
      ((bcki)localbckk).a(paramString);
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkNodeContainer", 2, "onNotify, KEY：" + paramString1 + " VALUE:" + paramString2);
    }
    bckk localbckk = a(paramLong);
    if ((localbckk != null) && ((localbckk instanceof bcki))) {
      ((bcki)localbckk).a(paramString1, paramString2);
    }
  }
  
  public void a(bcki parambcki)
  {
    if (parambcki == null) {
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (((WeakReference)localIterator.next()).get() == parambcki) {
        return;
      }
    }
    this.a.add(new WeakReference(parambcki));
  }
  
  public void b(bcki parambcki)
  {
    if (parambcki == null) {}
    WeakReference localWeakReference;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = this.a.iterator();
      }
      localWeakReference = (WeakReference)localIterator.next();
    } while (localWeakReference.get() != parambcki);
    this.a.remove(localWeakReference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjz
 * JD-Core Version:    0.7.0.1
 */