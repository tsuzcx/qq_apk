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

public class a
  implements IDiffDevOAuth
{
  private Handler a = null;
  private List<OAuthListener> b = new ArrayList();
  private b c;
  private OAuthListener d = new a.a(this);
  
  public void addListener(OAuthListener paramOAuthListener)
  {
    if (!this.b.contains(paramOAuthListener)) {
      this.b.add(paramOAuthListener);
    }
  }
  
  public boolean auth(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, OAuthListener paramOAuthListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start auth, appId = ");
    localStringBuilder.append(paramString1);
    Log.i("MicroMsg.SDK.DiffDevOAuth", localStringBuilder.toString());
    if ((paramString1 != null) && (paramString1.length() > 0) && (paramString2 != null) && (paramString2.length() > 0))
    {
      if (this.a == null) {
        this.a = new Handler(Looper.getMainLooper());
      }
      if (!this.b.contains(paramOAuthListener)) {
        this.b.add(paramOAuthListener);
      }
      if (this.c != null)
      {
        Log.d("MicroMsg.SDK.DiffDevOAuth", "auth, already running, no need to start auth again");
        return true;
      }
      paramString1 = new b(paramString1, paramString2, paramString3, paramString4, paramString5, this.d);
      this.c = paramString1;
      if (Build.VERSION.SDK_INT >= 11)
      {
        paramString1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return true;
      }
      paramString1.execute(new Void[0]);
      return true;
    }
    Log.d("MicroMsg.SDK.DiffDevOAuth", String.format("auth fail, invalid argument, appId = %s, scope = %s", new Object[] { paramString1, paramString2 }));
    return false;
  }
  
  public void detach()
  {
    Log.i("MicroMsg.SDK.DiffDevOAuth", "detach");
    this.b.clear();
    stopAuth();
  }
  
  public void removeAllListeners()
  {
    this.b.clear();
  }
  
  public void removeListener(OAuthListener paramOAuthListener)
  {
    this.b.remove(paramOAuthListener);
  }
  
  public boolean stopAuth()
  {
    Log.i("MicroMsg.SDK.DiffDevOAuth", "stopAuth");
    boolean bool;
    try
    {
      if (this.c == null) {
        bool = true;
      } else {
        bool = this.c.a();
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopAuth fail, ex = ");
      localStringBuilder.append(localException.getMessage());
      Log.w("MicroMsg.SDK.DiffDevOAuth", localStringBuilder.toString());
      bool = false;
    }
    this.c = null;
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.a
 * JD-Core Version:    0.7.0.1
 */