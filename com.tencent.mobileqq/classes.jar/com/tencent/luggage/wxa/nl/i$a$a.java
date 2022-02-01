package com.tencent.luggage.wxa.nl;

import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter$RouterController$Factory;", "Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter$RouterController;", "()V", "SUPPORTED_PKG_ENCRYPT_VERSION_MAX", "", "TAG", "", "isEncryptPkgEnabled", "", "isEncryptPkgKeyInstalled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "useEncryptPkg", "isGame", "useNewCgi", "useNewSeparatedPluginCompatibleLogic", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class i$a$a
  implements i.a
{
  private static final AtomicBoolean c = new AtomicBoolean(false);
  private static boolean d;
  
  public boolean a(boolean paramBoolean)
  {
    if (!c.getAndSet(true))
    {
      d = p.a.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("after WxaEncryptPkgKeyInstaller.ensureKeyInstalled(), isEncryptPkgEnabled=");
      localStringBuilder.append(d);
      o.d("MicroMsg.GetPkgDownloadUrlUnifiedCgiRouter", localStringBuilder.toString());
    }
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.i.a.a
 * JD-Core Version:    0.7.0.1
 */