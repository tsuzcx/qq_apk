package com.tencent.mars.cdn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.luggage.wxa.qz.o;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

final class b$a
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 26)
    {
      if ((!"android.security.action.KEYCHAIN_CHANGED".equals(paramIntent.getAction())) && (!"android.security.action.TRUST_STORE_CHANGED".equals(paramIntent.getAction())) && ((!"android.security.action.KEY_ACCESS_CHANGED".equals(paramIntent.getAction())) || (paramIntent.getBooleanExtra("android.security.extra.KEY_ACCESSIBLE", false)))) {
        bool = false;
      } else {
        bool = true;
      }
    }
    else {
      bool = "android.security.STORAGE_CHANGED".equals(paramIntent.getAction());
    }
    if (bool) {
      try
      {
        b.a();
        return;
      }
      catch (NoSuchAlgorithmException paramContext)
      {
        o.b("X509Util", "Unable to reload the default TrustManager", new Object[] { paramContext });
        return;
      }
      catch (KeyStoreException paramContext)
      {
        o.b("X509Util", "Unable to reload the default TrustManager", new Object[] { paramContext });
        return;
      }
      catch (CertificateException paramContext)
      {
        o.b("X509Util", "Unable to reload the default TrustManager", new Object[] { paramContext });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mars.cdn.b.a
 * JD-Core Version:    0.7.0.1
 */