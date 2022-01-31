package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.opensdk.diffdev.IDiffDevOAuth;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements IDiffDevOAuth
{
  private List<OAuthListener> Y = new ArrayList();
  private d Z;
  private OAuthListener aa = new b(this);
  private Handler handler = null;
  
  public final void addListener(OAuthListener paramOAuthListener)
  {
    if (!this.Y.contains(paramOAuthListener)) {
      this.Y.add(paramOAuthListener);
    }
  }
  
  public final boolean auth(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, OAuthListener paramOAuthListener)
  {
    Log.i("MicroMsg.SDK.DiffDevOAuth", "start auth, appId = " + paramString1);
    if ((paramString1 == null) || (paramString1.length() <= 0) || (paramString2 == null) || (paramString2.length() <= 0))
    {
      Log.d("MicroMsg.SDK.DiffDevOAuth", String.format("auth fail, invalid argument, appId = %s, scope = %s", new Object[] { paramString1, paramString2 }));
      return false;
    }
    if (this.handler == null) {
      this.handler = new Handler(Looper.getMainLooper());
    }
    addListener(paramOAuthListener);
    if (this.Z != null)
    {
      Log.d("MicroMsg.SDK.DiffDevOAuth", "auth, already running, no need to start auth again");
      return true;
    }
    this.Z = new d(paramString1, paramString2, paramString3, paramString4, paramString5, this.aa);
    paramString1 = this.Z;
    if (Build.VERSION.SDK_INT >= 11) {
      paramString1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
    for (;;)
    {
      return true;
      paramString1.execute(new Void[0]);
    }
  }
  
  public final void detach()
  {
    Log.i("MicroMsg.SDK.DiffDevOAuth", "detach");
    this.Y.clear();
    stopAuth();
  }
  
  public final void removeAllListeners()
  {
    this.Y.clear();
  }
  
  public final void removeListener(OAuthListener paramOAuthListener)
  {
    this.Y.remove(paramOAuthListener);
  }
  
  public final boolean stopAuth()
  {
    Log.i("MicroMsg.SDK.DiffDevOAuth", "stopAuth");
    for (;;)
    {
      try
      {
        d locald = this.Z;
        if (locald != null) {
          continue;
        }
        bool = true;
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.SDK.DiffDevOAuth", "stopAuth fail, ex = " + localException.getMessage());
        boolean bool = false;
        continue;
      }
      this.Z = null;
      return bool;
      bool = this.Z.q();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.a
 * JD-Core Version:    0.7.0.1
 */