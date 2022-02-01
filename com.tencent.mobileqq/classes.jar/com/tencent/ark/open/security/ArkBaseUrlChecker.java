package com.tencent.ark.open.security;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.Logger;
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
    finally
    {
      label139:
      break label139;
    }
    throw paramArrayList1;
  }
  
  private static boolean isUrlValidInList(String paramString, ArrayList<ArkAppInfo.ArkWhiteUrlItem> paramArrayList)
  {
    Object localObject2;
    Object localObject1;
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayList != null))
    {
      localObject2 = parseURL(paramString);
      if (localObject2 == null)
      {
        Logger.logI("ArkApp.ArkBaseUrlChecker", new Object[] { "ArkSafe.isUrlValidInList invalid url, url = ", ArkUtil.filterKeyForLog(paramString, new String[0]) });
        return false;
      }
      localObject1 = ((URL)localObject2).getAuthority();
      localObject2 = ((URL)localObject2).getPath();
      Logger.logI("ArkApp.ArkBaseUrlChecker", new Object[] { "ArkSafe.isUrlValidInList url = ", ArkUtil.filterKeyForLog(paramString, new String[0]), ", urlDomain=", localObject1, ", urlPath=", localObject2 });
    }
    label460:
    label593:
    for (;;)
    {
      boolean bool1;
      boolean bool3;
      boolean bool2;
      try
      {
        Iterator localIterator = paramArrayList.iterator();
        bool1 = false;
        bool3 = false;
        bool2 = true;
        bool4 = bool1;
        bool5 = bool3;
        bool6 = bool2;
        try
        {
          if (!localIterator.hasNext()) {
            break label509;
          }
          paramArrayList = (ArkAppInfo.ArkWhiteUrlItem)localIterator.next();
          bool4 = bool1;
          bool5 = bool3;
          bool6 = bool2;
          if (paramArrayList != null)
          {
            Logger.logI("ArkApp.ArkBaseUrlChecker", new Object[] { "ArkSafe.isUrlValidInList.handle ruleDomain=", paramArrayList.ruleDomain, ", rulePath=", paramArrayList.rulePath });
            bool4 = TextUtils.isEmpty(paramArrayList.ruleDomain);
            int i;
            if (bool4)
            {
              bool1 = true;
            }
            else if ((paramArrayList.ruleDomain.startsWith("*")) && (localObject1 != null))
            {
              int j = paramArrayList.ruleDomain.length() - 1;
              i = ((String)localObject1).length() - j;
              if (i >= 0) {
                break label593;
              }
              i = 0;
              bool4 = ((String)localObject1).regionMatches(true, i, paramArrayList.ruleDomain, 1, j);
              bool1 = bool4;
            }
            else
            {
              bool4 = paramArrayList.ruleDomain.equalsIgnoreCase((String)localObject1);
              bool1 = bool4;
            }
            try
            {
              if (TextUtils.isEmpty(paramArrayList.rulePath))
              {
                bool2 = true;
              }
              else if ((paramArrayList.rulePath.endsWith("*")) && (localObject2 != null))
              {
                i = paramArrayList.rulePath.length();
                bool4 = ((String)localObject2).regionMatches(0, paramArrayList.rulePath, 0, i - 1);
                bool2 = bool4;
              }
              else
              {
                bool4 = paramArrayList.rulePath.equals(localObject2);
                bool2 = bool4;
              }
              if ((bool1) && (bool2))
              {
                bool6 = true;
                bool4 = bool1;
                bool5 = bool2;
                break label509;
              }
              bool6 = false;
              bool4 = bool1;
              bool5 = bool2;
            }
            catch (Exception paramArrayList)
            {
              break label460;
            }
          }
          bool1 = bool4;
          bool3 = bool5;
          bool2 = bool6;
        }
        catch (Exception paramArrayList) {}
        localObject1 = new StringBuilder();
      }
      catch (Exception paramArrayList)
      {
        bool1 = false;
        bool3 = false;
        bool2 = true;
      }
      ((StringBuilder)localObject1).append("ArkSafe.isUrlValidInList.exception2=");
      ((StringBuilder)localObject1).append(paramArrayList.toString());
      Logger.logE("ArkApp.ArkBaseUrlChecker", ((StringBuilder)localObject1).toString());
      boolean bool6 = bool2;
      boolean bool5 = bool3;
      boolean bool4 = bool1;
      label509:
      if (!bool6) {
        Logger.logI("ArkApp.ArkBaseUrlChecker", new Object[] { "ArkSafe.isUrlValidInList url=", ArkUtil.filterKeyForLog(paramString, new String[0]), ", return isValid=", Boolean.valueOf(bool6), ", isDomainValid=", Boolean.valueOf(bool4), ", isPathValid=", Boolean.valueOf(bool5) });
      }
      return bool6;
      Logger.logE("ArkApp.ArkBaseUrlChecker", "ArkSafe.isUrlValidInList return true");
      return true;
    }
  }
  
  private static URL parseURL(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      URL localURL = new URL(paramString);
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("ArkSafe.isUrlValidInList Exception:");
      localStringBuilder2.append(localMalformedURLException.toString());
      Logger.logE("ArkApp.ArkBaseUrlChecker", localStringBuilder2.toString());
      int i = paramString.indexOf('?');
      if (i < 0) {
        return null;
      }
      paramString = paramString.substring(0, i);
      try
      {
        paramString = new URL(paramString);
        return paramString;
      }
      catch (MalformedURLException paramString)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("ArkSafe.isUrlValidInList Exception:");
        localStringBuilder1.append(paramString.toString());
        Logger.logE("ArkApp.ArkBaseUrlChecker", localStringBuilder1.toString());
      }
    }
    return null;
  }
  
  public int checkURLLoose(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      Logger.logE("ArkApp.ArkBaseUrlChecker", "ArkSafe.checkURLLoose return TYPE_VALID for null url");
      return 0;
    }
    for (;;)
    {
      synchronized (this.mLock)
      {
        if ((this.mGlobalBlackList != null) && (this.mGlobalBlackList.size() > 0))
        {
          if (!isUrlValidInList(paramString, this.mGlobalBlackList))
          {
            Logger.logD("ArkApp.ArkBaseUrlChecker", new Object[] { "ArkSafe.checkURLLoose.not in black list.type=", Integer.valueOf(0), ", url=", ArkUtil.filterKeyForLog(paramString, new String[0]) });
            return 0;
          }
          if (!isUrlValidInList(paramString, this.mWhiteList))
          {
            i = 1;
            Logger.logI("ArkApp.ArkBaseUrlChecker", new Object[] { "ArkSafe.checkURLLoose.type=", Integer.valueOf(i), ", url=", ArkUtil.filterKeyForLog(paramString, new String[0]) });
            return i;
          }
        }
      }
      int i = 0;
    }
  }
  
  public int checkURLStrict(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      Logger.logE("ArkApp.ArkBaseUrlChecker", "ArkSafe.checkURLStrict return TYPE_VALID for null url");
      return 0;
    }
    for (;;)
    {
      synchronized (this.mLock)
      {
        if ((this.mGlobalBlackList != null) && (this.mGlobalBlackList.size() > 0))
        {
          if (isUrlValidInList(paramString, this.mGlobalBlackList)) {
            break label215;
          }
          bool = true;
          Logger.logD("ArkApp.ArkBaseUrlChecker", new Object[] { "ArkSafe.checkURLStrict.isGlobalBlackValid=", Boolean.valueOf(bool) });
          if (!bool)
          {
            Logger.logI("ArkApp.ArkBaseUrlChecker", new Object[] { "ArkSafe.checkURLStrict.type=", Integer.valueOf(1), ",url=", ArkUtil.filterKeyForLog(paramString, new String[0]) });
            return 1;
          }
        }
        if ((this.mGlobalWhiteList != null) && (this.mGlobalWhiteList.size() > 0) && (isUrlValidInList(paramString, this.mGlobalWhiteList))) {
          break label220;
        }
        if (!isUrlValidInList(paramString, this.mWhiteList)) {
          break label225;
        }
        break label220;
        Logger.logI("ArkApp.ArkBaseUrlChecker", new Object[] { "ArkSafe.checkURLStrict.type=", Integer.valueOf(i), ", url=", ArkUtil.filterKeyForLog(paramString, new String[0]) });
        return i;
      }
      label215:
      boolean bool = false;
      continue;
      label220:
      int i = 1;
      break label227;
      label225:
      i = 0;
      label227:
      if (i == 0) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("{");
    if (this.mWhiteList != null)
    {
      localStringBuilder.append("list:");
      localStringBuilder.append(this.mWhiteList.toString());
    }
    if (this.mGlobalWhiteList != null)
    {
      localStringBuilder.append("gloablwhite:");
      localStringBuilder.append(this.mGlobalWhiteList.toString());
    }
    if (this.mGlobalBlackList != null)
    {
      localStringBuilder.append("gloablblack:");
      localStringBuilder.append(this.mGlobalBlackList.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.security.ArkBaseUrlChecker
 * JD-Core Version:    0.7.0.1
 */