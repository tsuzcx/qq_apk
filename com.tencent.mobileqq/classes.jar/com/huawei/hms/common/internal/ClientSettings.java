package com.huawei.hms.common.internal;

import android.app.Activity;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.lang.ref.WeakReference;
import java.util.List;

public class ClientSettings
{
  private List<String> apiName;
  private String appId;
  private String clientClassName;
  private String clientPackageName;
  private WeakReference<Activity> cpActivity;
  private boolean hasActivity;
  private String innerHmsPkg;
  private String mCpID;
  private List<Scope> scopes;
  private SubAppInfo subAppId;
  
  public ClientSettings(String paramString1, String paramString2, List<Scope> paramList, String paramString3, List<String> paramList1)
  {
    this.clientPackageName = paramString1;
    this.clientClassName = paramString2;
    this.scopes = paramList;
    this.appId = paramString3;
    this.apiName = paramList1;
  }
  
  public ClientSettings(String paramString1, String paramString2, List<Scope> paramList, String paramString3, List<String> paramList1, SubAppInfo paramSubAppInfo)
  {
    this(paramString1, paramString2, paramList, paramString3, paramList1);
    setSubAppId(paramSubAppInfo);
  }
  
  public List<String> getApiName()
  {
    return this.apiName;
  }
  
  public String getAppID()
  {
    return this.appId;
  }
  
  public String getClientClassName()
  {
    return this.clientClassName;
  }
  
  public String getClientPackageName()
  {
    return this.clientPackageName;
  }
  
  public Activity getCpActivity()
  {
    WeakReference localWeakReference = this.cpActivity;
    if (localWeakReference == null) {
      return null;
    }
    return (Activity)localWeakReference.get();
  }
  
  public String getCpID()
  {
    return this.mCpID;
  }
  
  public String getInnerHmsPkg()
  {
    return this.innerHmsPkg;
  }
  
  public List<Scope> getScopes()
  {
    return this.scopes;
  }
  
  public SubAppInfo getSubAppID()
  {
    return this.subAppId;
  }
  
  public boolean isHasActivity()
  {
    return this.hasActivity;
  }
  
  public void setApiName(List<String> paramList)
  {
    this.apiName = paramList;
  }
  
  public void setAppID(String paramString)
  {
    this.appId = paramString;
  }
  
  public void setClientClassName(String paramString)
  {
    this.clientClassName = paramString;
  }
  
  public void setClientPackageName(String paramString)
  {
    this.clientPackageName = paramString;
  }
  
  public void setCpActivity(Activity paramActivity)
  {
    this.cpActivity = new WeakReference(paramActivity);
    this.hasActivity = true;
  }
  
  public void setCpID(String paramString)
  {
    this.mCpID = paramString;
  }
  
  public void setInnerHmsPkg(String paramString)
  {
    this.innerHmsPkg = paramString;
  }
  
  public void setScopes(List<Scope> paramList)
  {
    this.scopes = paramList;
  }
  
  public void setSubAppId(SubAppInfo paramSubAppInfo)
  {
    this.subAppId = paramSubAppInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.common.internal.ClientSettings
 * JD-Core Version:    0.7.0.1
 */