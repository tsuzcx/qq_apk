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
    paramAuthInfo = new StringBuilder();
    paramAuthInfo.append(System.currentTimeMillis());
    this.aJ = paramAuthInfo.toString();
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
    int i = this.aI.getType();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          paramBundle.putInt("web_type", 3);
        }
      }
      else {
        paramBundle.putInt("web_type", 2);
      }
    }
    else {
      paramBundle.putInt("web_type", 1);
    }
    paramBundle.putString("_weibo_transaction", this.aJ);
    a(paramBundle);
    return paramBundle;
  }
  
  public final WebData x()
  {
    return this.aI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.web.b.b
 * JD-Core Version:    0.7.0.1
 */