package com.tencent.mm.opensdk.diffdev.a;

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
  private List<OAuthListener> c = new ArrayList();
  private d d;
  private OAuthListener e = new b(this);
  private Handler handler = null;
  
  public final void addListener(OAuthListener paramOAuthListener)
  {
    if (!this.c.contains(paramOAuthListener)) {
      this.c.add(paramOAuthListener);
    }
  }
  
  public final boolean auth(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, OAuthListener paramOAuthListener)
  {
    StringBuilder localStringBuilder = new StringBuilder("start auth, appId = ");
    localStringBuilder.append(paramString1);
    Log.i("MicroMsg.SDK.DiffDevOAuth", localStringBuilder.toString());
    if ((paramString1 != null) && (paramString1.length() > 0) && (paramString2 != null) && (paramString2.length() > 0))
    {
      if (this.handler == null) {
        this.handler = new Handler(Looper.getMainLooper());
      }
      addListener(paramOAuthListener);
      if (this.d != null)
      {
        Log.d("MicroMsg.SDK.DiffDevOAuth", "auth, already running, no need to start auth again");
        return true;
      }
      this.d = new d(paramString1, paramString2, paramString3, paramString4, paramString5, this.e);
      paramString1 = this.d;
      if (Build.VERSION.SDK_INT >= 11)
      {
        paramString1.executeOnExecutor(com.tencent.mm.opensdk.utils.d.E, new Void[0]);
        return true;
      }
      paramString1.execute(new Void[0]);
      return true;
    }
    Log.d("MicroMsg.SDK.DiffDevOAuth", String.format("auth fail, invalid argument, appId = %s, scope = %s", new Object[] { paramString1, paramString2 }));
    return false;
  }
  
  public final void detach()
  {
    Log.i("MicroMsg.SDK.DiffDevOAuth", "detach");
    this.c.clear();
    stopAuth();
  }
  
  public final void removeAllListeners()
  {
    this.c.clear();
  }
  
  public final void removeListener(OAuthListener paramOAuthListener)
  {
    this.c.remove(paramOAuthListener);
  }
  
  public final boolean stopAuth()
  {
    Log.i("MicroMsg.SDK.DiffDevOAuth", "stopAuth");
    boolean bool;
    try
    {
      if (this.d == null) {
        bool = true;
      } else {
        bool = this.d.a();
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("stopAuth fail, ex = ");
      localStringBuilder.append(localException.getMessage());
      Log.w("MicroMsg.SDK.DiffDevOAuth", localStringBuilder.toString());
      bool = false;
    }
    this.d = null;
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.a
 * JD-Core Version:    0.7.0.1
 */