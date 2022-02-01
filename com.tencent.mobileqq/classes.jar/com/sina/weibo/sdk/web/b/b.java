package com.sina.weibo.sdk.web.b;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.web.WebData;

public abstract class b
{
  protected WebData aI;
  protected String aJ;
  protected Context af;
  
  protected b() {}
  
  public b(AuthInfo paramAuthInfo, int paramInt, String paramString1, String paramString2)
  {
    this.aI = new WebData(paramAuthInfo, paramInt, paramString1, paramString2);
    this.aJ = System.currentTimeMillis();
  }
  
  protected abstract void a(Bundle paramBundle);
  
  public void a(b.a parama) {}
  
  protected abstract void b(Bundle paramBundle);
  
  public abstract String getUrl();
  
  public final void readFromBundle(Bundle paramBundle)
  {
    this.aI = ((WebData)paramBundle.getParcelable("web_data"));
    this.aJ = paramBundle.getString("_weibo_transaction");
    b(paramBundle);
  }
  
  public final void setContext(Context paramContext)
  {
    this.af = paramContext;
  }
  
  public boolean w()
  {
    return false;
  }
  
  public final Bundle writeToBundle(Bundle paramBundle)
  {
    paramBundle.putParcelable("web_data", this.aI);
    switch (this.aI.getType())
    {
    }
    for (;;)
    {
      paramBundle.putString("_weibo_transaction", this.aJ);
      a(paramBundle);
      return paramBundle;
      paramBundle.putInt("web_type", 1);
      continue;
      paramBundle.putInt("web_type", 2);
      continue;
      paramBundle.putInt("web_type", 3);
    }
  }
  
  public final WebData x()
  {
    return this.aI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.web.b.b
 * JD-Core Version:    0.7.0.1
 */