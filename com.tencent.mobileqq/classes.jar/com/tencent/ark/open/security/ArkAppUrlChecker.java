package com.tencent.ark.open.security;

import com.tencent.ark.open.ArkAppInfo.AppUrlWhiteList;
import com.tencent.ark.open.ArkAppInfo.ArkWhiteUrlItem;
import java.util.ArrayList;

public class ArkAppUrlChecker
  extends ArkBaseUrlChecker
{
  private ArrayList<ArkAppInfo.ArkWhiteUrlItem> mAppNavigationList = null;
  private ArrayList<ArkAppInfo.ArkWhiteUrlItem> mAppResouceList = null;
  
  public ArkAppUrlChecker(ArkAppInfo.AppUrlWhiteList paramAppUrlWhiteList, ArrayList<ArkAppInfo.ArkWhiteUrlItem> paramArrayList1, ArrayList<ArkAppInfo.ArkWhiteUrlItem> paramArrayList2)
  {
    super(null, paramArrayList1, paramArrayList2);
    paramArrayList1 = this.mLock;
    if (paramAppUrlWhiteList != null) {}
    try
    {
      if (paramAppUrlWhiteList.resourceList != null)
      {
        this.mAppResouceList = new ArrayList();
        this.mAppResouceList.addAll(paramAppUrlWhiteList.resourceList);
      }
      if ((paramAppUrlWhiteList != null) && (paramAppUrlWhiteList.navigationList != null))
      {
        this.mAppNavigationList = new ArrayList();
        this.mAppNavigationList.addAll(paramAppUrlWhiteList.navigationList);
      }
      return;
    }
    finally {}
  }
  
  public int checkUrlIsValidByAppNavigationList(String paramString)
  {
    synchronized (this.mLock)
    {
      this.mWhiteList = this.mAppNavigationList;
      int i = super.checkURLStrict(paramString);
      return i;
    }
  }
  
  public int checkUrlIsValidByAppResouceList(String paramString)
  {
    synchronized (this.mLock)
    {
      this.mWhiteList = this.mAppResouceList;
      int i = super.checkURLStrict(paramString);
      return i;
    }
  }
  
  public ArkBaseUrlChecker getAppNavigationChecker()
  {
    synchronized (this.mLock)
    {
      this.mWhiteList = this.mAppNavigationList;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.security.ArkAppUrlChecker
 * JD-Core Version:    0.7.0.1
 */