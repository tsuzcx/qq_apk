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

public class awsr
  implements awst, ark.ApplicationCallback
{
  private ArrayList<WeakReference<awtc>> a = new ArrayList();
  
  private awtc a(long paramLong)
  {
    ark.Container localContainer = ark.arkGetContainer(paramLong);
    awtc localawtc;
    if (localContainer == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkNodeContainer", 2, "getArkNode, arkcontainer is null");
      }
      localawtc = null;
    }
    label150:
    label154:
    for (;;)
    {
      return localawtc;
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
        localawtc = (awtc)((WeakReference)this.a.get(i)).get();
        if ((localawtc == null) || (!(localawtc instanceof awta))) {
          break label150;
        }
      }
      for (awsw localawsw = ((awta)localawtc).a();; localawsw = null)
      {
        if ((localawsw != null) && (localawsw.getContainer() == localContainer)) {
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
    alwg.a(paramApplication);
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
        QLog.e("ArkNodeContainer", 1, new Object[] { "ArkSafe.UrlCheck.setDisable.EngineCallback seach appName=", paramApplication, ",url=", nau.b(paramString, new String[0]), ", isValid set=true" });
        i = 2;
        bool = true;
        label97:
        alwg.a(paramApplication, paramString, j, i, "");
      }
    }
    for (;;)
    {
      QLog.e("ArkNodeContainer", 1, new Object[] { "ArkSafe.EngineCallback search appName=", paramApplication, ",url=", nau.b(paramString, new String[0]), ", isValid=", Boolean.valueOf(bool) });
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
        altc.a(null, paramString1, "ScriptError", 0, 0, 0L, 0L, 0L, paramString2, "");
        return;
      }
    }
  }
  
  public void RegisterModules(ark.ModuleRegister paramModuleRegister, ark.Application paramApplication)
  {
    aloy.a(paramModuleRegister, paramApplication);
    String str = paramApplication.GetSpecific("appName");
    awss localawss = new awss(paramApplication, aloy.a(str));
    localawss.a(this);
    paramApplication = aloy.a();
    if ((!TextUtils.isEmpty(str)) && (paramApplication != null))
    {
      paramApplication = (ArkAppCenter)paramApplication.getManager(121);
      if (paramApplication == null) {}
    }
    for (paramApplication = paramApplication.a();; paramApplication = null)
    {
      if (paramApplication != null) {
        localawss.a((List)alqx.a.get(localawss.GetTypeName()));
      }
      paramModuleRegister.RegCallbackWrapper(localawss);
      return;
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    awtc localawtc = a(paramLong);
    if ((localawtc != null) && ((localawtc instanceof awta))) {
      ((awta)localawtc).a(paramString);
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkNodeContainer", 2, "onNotify, KEY：" + paramString1 + " VALUE:" + paramString2);
    }
    awtc localawtc = a(paramLong);
    if ((localawtc != null) && ((localawtc instanceof awta))) {
      ((awta)localawtc).a(paramString1, paramString2);
    }
  }
  
  public void a(awta paramawta)
  {
    if (paramawta == null) {
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (((WeakReference)localIterator.next()).get() == paramawta) {
        return;
      }
    }
    this.a.add(new WeakReference(paramawta));
  }
  
  public void b(awta paramawta)
  {
    if (paramawta == null) {}
    WeakReference localWeakReference;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = this.a.iterator();
      }
      localWeakReference = (WeakReference)localIterator.next();
    } while (localWeakReference.get() != paramawta);
    this.a.remove(localWeakReference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awsr
 * JD-Core Version:    0.7.0.1
 */