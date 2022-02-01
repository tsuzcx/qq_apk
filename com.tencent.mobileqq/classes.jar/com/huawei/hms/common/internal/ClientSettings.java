package com.huawei.hms.common.internal;

import android.app.Activity;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.lang.ref.WeakReference;
import java.util.List;

public class ClientSettings
{
  private String a;
  private String b;
  private List<Scope> c;
  private String d;
  private List<String> e;
  private String f;
  private SubAppInfo g;
  private WeakReference<Activity> h;
  private boolean i;
  
  public ClientSettings(String paramString1, String paramString2, List<Scope> paramList, String paramString3, List<String> paramList1)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramList;
    this.d = paramString3;
    this.e = paramList1;
  }
  
  public ClientSettings(String paramString1, String paramString2, List<Scope> paramList, String paramString3, List<String> paramList1, SubAppInfo paramSubAppInfo)
  {
    this(paramString1, paramString2, paramList, paramString3, paramList1);
    setSubAppId(paramSubAppInfo);
  }
  
  public List<String> getApiName()
  {
    return this.e;
  }
  
  public String getAppID()
  {
    return this.d;
  }
  
  public String getClientClassName()
  {
    return this.b;
  }
  
  public String getClientPackageName()
  {
    return this.a;
  }
  
  public Activity getCpActivity()
  {
    if (this.h == null) {
      return null;
    }
    return (Activity)this.h.get();
  }
  
  public String getCpID()
  {
    return this.f;
  }
  
  public List<Scope> getScopes()
  {
    return this.c;
  }
  
  public SubAppInfo getSubAppID()
  {
    return this.g;
  }
  
  public boolean isHasActivity()
  {
    return this.i;
  }
  
  public void setApiName(List<String> paramList)
  {
    this.e = paramList;
  }
  
  public void setAppID(String paramString)
  {
    this.d = paramString;
  }
  
  public void setClientClassName(String paramString)
  {
    this.b = paramString;
  }
  
  public void setClientPackageName(String paramString)
  {
    this.a = paramString;
  }
  
  public void setCpActivity(Activity paramActivity)
  {
    this.h = new WeakReference(paramActivity);
    this.i = true;
  }
  
  public void setCpID(String paramString)
  {
    this.f = paramString;
  }
  
  public void setScopes(List<Scope> paramList)
  {
    this.c = paramList;
  }
  
  public void setSubAppId(SubAppInfo paramSubAppInfo)
  {
    this.g = paramSubAppInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.ClientSettings
 * JD-Core Version:    0.7.0.1
 */