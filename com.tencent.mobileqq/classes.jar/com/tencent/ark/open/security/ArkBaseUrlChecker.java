package com.tencent.ark.open.security;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.open.ArkAppInfo.ArkWhiteUrlItem;
import com.tencent.ark.open.ArkUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class ArkBaseUrlChecker
  implements Parcelable
{
  public static final Parcelable.Creator<ArkBaseUrlChecker> CREATOR = new ArkBaseUrlChecker.1();
  private static final ArkEnvironmentManager ENV = ;
  private static final String TAG = "ArkApp.ArkBaseUrlChecker";
  public static final int TYPE_INVALID_BLACK = 1;
  public static final int TYPE_INVALID_WHITE = 2;
  public static final int TYPE_VALID = 0;
  private ArrayList<ArkAppInfo.ArkWhiteUrlItem> mGlobalBlackList = null;
  private ArrayList<ArkAppInfo.ArkWhiteUrlItem> mGlobalWhiteList = null;
  protected Object mLock = new Object();
  protected ArrayList<ArkAppInfo.ArkWhiteUrlItem> mWhiteList = null;
  
  protected ArkBaseUrlChecker(Parcel paramParcel)
  {
    this.mWhiteList = paramParcel.createTypedArrayList(ArkAppInfo.ArkWhiteUrlItem.CREATOR);
    this.mGlobalWhiteList = paramParcel.createTypedArrayList(ArkAppInfo.ArkWhiteUrlItem.CREATOR);
    this.mGlobalBlackList = paramParcel.createTypedArrayList(ArkAppInfo.ArkWhiteUrlItem.CREATOR);
  }
  
  public ArkBaseUrlChecker(ArrayList<ArkAppInfo.ArkWhiteUrlItem> paramArrayList1, ArrayList<ArkAppInfo.ArkWhiteUrlItem> paramArrayList2, ArrayList<ArkAppInfo.ArkWhiteUrlItem> paramArrayList3)
  {
    Object localObject = this.mLock;
    if (paramArrayList1 != null) {}
    try
    {
      if (paramArrayList1.size() > 0)
      {
        this.mWhiteList = new ArrayList();
        this.mWhiteList.addAll(paramArrayList1);
      }
      if ((paramArrayList2 != null) && (paramArrayList2.size() > 0))
      {
        this.mGlobalWhiteList = new ArrayList();
        this.mGlobalWhiteList.addAll(paramArrayList2);
      }
      if ((paramArrayList3 != null) && (paramArrayList3.size() > 0))
      {
        this.mGlobalBlackList = new ArrayList();
        this.mGlobalBlackList.addAll(paramArrayList3);
      }
      return;
    }
    finally {}
  }
  
  private static boolean isUrlValidInList(String paramString, ArrayList<ArkAppInfo.ArkWhiteUrlItem> paramArrayList)
  {
    boolean bool4;
    if ((TextUtils.isEmpty(paramString)) || (paramArrayList == null))
    {
      ENV.logE("ArkApp.ArkBaseUrlChecker", "ArkSafe.isUrlValidInList return true");
      bool4 = true;
    }
    for (;;)
    {
      return bool4;
      Object localObject = parseURL(paramString);
      if (localObject == null)
      {
        ENV.logI("ArkApp.ArkBaseUrlChecker", new Object[] { "ArkSafe.isUrlValidInList invalid url, url = ", ArkUtil.filterKeyForLog(paramString, new String[0]) });
        return false;
      }
      String str = ((URL)localObject).getAuthority();
      localObject = ((URL)localObject).getPath();
      ENV.logI("ArkApp.ArkBaseUrlChecker", new Object[] { "ArkSafe.isUrlValidInList url = ", ArkUtil.filterKeyForLog(paramString, new String[0]), ", urlDomain=", str, ", urlPath=", localObject });
      boolean bool6 = false;
      boolean bool3 = false;
      boolean bool5 = false;
      boolean bool2 = false;
      bool4 = true;
      boolean bool1 = true;
      try
      {
        paramArrayList = paramArrayList.iterator();
        bool4 = bool1;
        bool5 = bool2;
        bool6 = bool3;
        if (paramArrayList.hasNext())
        {
          bool4 = bool1;
          bool5 = bool2;
          bool6 = bool3;
          localArkWhiteUrlItem = (ArkAppInfo.ArkWhiteUrlItem)paramArrayList.next();
          if (localArkWhiteUrlItem != null)
          {
            bool4 = bool1;
            bool5 = bool2;
            bool6 = bool3;
            ENV.logI("ArkApp.ArkBaseUrlChecker", new Object[] { "ArkSafe.isUrlValidInList.handle ruleDomain=", localArkWhiteUrlItem.ruleDomain, ", rulePath=", localArkWhiteUrlItem.rulePath });
            bool4 = bool1;
            bool5 = bool2;
            bool6 = bool3;
            boolean bool7 = TextUtils.isEmpty(localArkWhiteUrlItem.ruleDomain);
            if (bool7) {
              bool3 = true;
            }
          }
        }
      }
      catch (Exception paramArrayList)
      {
        for (;;)
        {
          try
          {
            ArkAppInfo.ArkWhiteUrlItem localArkWhiteUrlItem;
            bool4 = TextUtils.isEmpty(localArkWhiteUrlItem.rulePath);
            int i;
            if (bool4)
            {
              bool1 = true;
              if ((!bool3) || (!bool1)) {
                continue;
              }
              bool4 = true;
              bool2 = bool1;
              bool1 = bool4;
              bool4 = bool1;
              if (bool1) {
                break;
              }
              ENV.logI("ArkApp.ArkBaseUrlChecker", new Object[] { "ArkSafe.isUrlValidInList url=", ArkUtil.filterKeyForLog(paramString, new String[0]), ", return isValid=", Boolean.valueOf(bool1), ", isDomainValid=", Boolean.valueOf(bool3), ", isPathValid=", Boolean.valueOf(bool2) });
              return bool1;
              bool4 = bool1;
              bool5 = bool2;
              bool6 = bool3;
              if ((localArkWhiteUrlItem.ruleDomain.startsWith("*")) && (str != null))
              {
                bool4 = bool1;
                bool5 = bool2;
                bool6 = bool3;
                int k = localArkWhiteUrlItem.ruleDomain.length() - 1;
                bool4 = bool1;
                bool5 = bool2;
                bool6 = bool3;
                int j = str.length() - k;
                i = j;
                if (j < 0) {
                  i = 0;
                }
                bool4 = bool1;
                bool5 = bool2;
                bool6 = bool3;
                bool3 = str.regionMatches(true, i, localArkWhiteUrlItem.ruleDomain, 1, k);
                continue;
              }
              bool4 = bool1;
              bool5 = bool2;
              bool6 = bool3;
              bool3 = localArkWhiteUrlItem.ruleDomain.equalsIgnoreCase(str);
              continue;
            }
            if ((localArkWhiteUrlItem.rulePath.endsWith("*")) && (localObject != null))
            {
              i = localArkWhiteUrlItem.rulePath.length();
              bool4 = ((String)localObject).regionMatches(0, localArkWhiteUrlItem.rulePath, 0, i - 1);
              bool1 = bool4;
              continue;
            }
            bool4 = localArkWhiteUrlItem.rulePath.equals(localObject);
            bool1 = bool4;
            continue;
            bool2 = false;
            bool4 = bool1;
            bool1 = bool2;
            bool2 = bool4;
          }
          catch (Exception paramArrayList)
          {
            bool6 = bool3;
            continue;
          }
          paramArrayList = paramArrayList;
          bool2 = bool5;
          bool1 = bool4;
          ENV.logE("ArkApp.ArkBaseUrlChecker", "ArkSafe.isUrlValidInList.exception2=" + paramArrayList.toString());
          bool3 = bool6;
          continue;
          bool4 = bool2;
          bool2 = bool1;
          bool1 = bool4;
          continue;
          bool4 = bool1;
        }
      }
    }
  }
  
  private static URL parseURL(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return null;
      try
      {
        URL localURL = new URL(paramString);
        return localURL;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        ENV.logE("ArkApp.ArkBaseUrlChecker", "ArkSafe.isUrlValidInList Exception:" + localMalformedURLException.toString());
        i = paramString.indexOf('?');
      }
    } while (i < 0);
    paramString = paramString.substring(0, i);
    try
    {
      paramString = new URL(paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      ENV.logE("ArkApp.ArkBaseUrlChecker", "ArkSafe.isUrlValidInList Exception:" + paramString.toString());
    }
    return null;
  }
  
  public int checkURLLoose(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ENV.logE("ArkApp.ArkBaseUrlChecker", "ArkSafe.checkURLLoose return TYPE_VALID for null url");
      return 0;
    }
    synchronized (this.mLock)
    {
      if ((this.mGlobalBlackList == null) || (this.mGlobalBlackList.size() <= 0)) {
        break label160;
      }
      if (!isUrlValidInList(paramString, this.mGlobalBlackList))
      {
        ENV.logD("ArkApp.ArkBaseUrlChecker", new Object[] { "ArkSafe.checkURLLoose.not in black list.type=", Integer.valueOf(0), ", url=", ArkUtil.filterKeyForLog(paramString, new String[0]) });
        return 0;
      }
    }
    if (!isUrlValidInList(paramString, this.mWhiteList)) {}
    label160:
    for (int i = 1;; i = 0)
    {
      ENV.logI("ArkApp.ArkBaseUrlChecker", new Object[] { "ArkSafe.checkURLLoose.type=", Integer.valueOf(i), ", url=", ArkUtil.filterKeyForLog(paramString, new String[0]) });
      return i;
    }
  }
  
  public int checkURLStrict(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ENV.logE("ArkApp.ArkBaseUrlChecker", "ArkSafe.checkURLStrict return TYPE_VALID for null url");
      return 0;
    }
    for (;;)
    {
      boolean bool;
      synchronized (this.mLock)
      {
        if ((this.mGlobalBlackList != null) && (this.mGlobalBlackList.size() > 0))
        {
          if (isUrlValidInList(paramString, this.mGlobalBlackList)) {
            break label234;
          }
          bool = true;
          ENV.logD("ArkApp.ArkBaseUrlChecker", new Object[] { "ArkSafe.checkURLStrict.isGlobalBlackValid=", Boolean.valueOf(bool) });
          if (!bool)
          {
            ENV.logI("ArkApp.ArkBaseUrlChecker", new Object[] { "ArkSafe.checkURLStrict.type=", Integer.valueOf(1), ",url=", ArkUtil.filterKeyForLog(paramString, new String[0]) });
            return 1;
          }
        }
        if ((this.mGlobalWhiteList == null) || (this.mGlobalWhiteList.size() <= 0) || (!isUrlValidInList(paramString, this.mGlobalWhiteList))) {
          if (isUrlValidInList(paramString, this.mWhiteList))
          {
            break label239;
            label173:
            ENV.logI("ArkApp.ArkBaseUrlChecker", new Object[] { "ArkSafe.checkURLStrict.type=", Integer.valueOf(i), ", url=", ArkUtil.filterKeyForLog(paramString, new String[0]) });
            return i;
          }
          else
          {
            i = 0;
          }
        }
      }
      label234:
      label239:
      do
      {
        i = 0;
        break label173;
        bool = false;
        break;
        i = 1;
      } while (i != 0);
      int i = 2;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("{");
    if (this.mWhiteList != null) {
      localStringBuilder.append("list:").append(this.mWhiteList.toString());
    }
    if (this.mGlobalWhiteList != null) {
      localStringBuilder.append("gloablwhite:").append(this.mGlobalWhiteList.toString());
    }
    if (this.mGlobalBlackList != null) {
      localStringBuilder.append("gloablblack:").append(this.mGlobalBlackList.toString());
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(this.mWhiteList);
    paramParcel.writeTypedList(this.mGlobalWhiteList);
    paramParcel.writeTypedList(this.mGlobalBlackList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.open.security.ArkBaseUrlChecker
 * JD-Core Version:    0.7.0.1
 */