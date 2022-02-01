package com.tencent.mobileqq.activity.springfestival.entry.model;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;

public class UserData
  implements Serializable
{
  public static final int GRAB_REQ_INTERVAL_DEFAULT = 3000;
  public static final String TAG = "shua2021_UserData";
  public static final String USER_DATA_FILE_PREFIX = "spring_festival_redpacket2021_userdata_";
  public int configVersion = 0;
  public int grabReqInterval = 3000;
  public boolean hasClickedHolder = false;
  public boolean hasShowedMiniApp = false;
  private int shareForbidden;
  public long showGestureTs = 0L;
  ConcurrentHashMap<String, UserData.UserDataItem> userDataItems = new ConcurrentHashMap();
  
  public static final String getUserDataFileName(String paramString)
  {
    return "spring_festival_redpacket2021_userdata_" + paramString;
  }
  
  @NotNull
  public static UserData read(String paramString)
  {
    paramString = getUserDataFileName(paramString);
    try
    {
      paramString = FileUtils.a(paramString);
      if ((paramString instanceof UserData))
      {
        paramString = (UserData)paramString;
        Object localObject = paramString;
        if (paramString == null) {
          localObject = new UserData();
        }
        return localObject;
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString = null;
        continue;
        paramString = null;
      }
    }
  }
  
  public static void write(String paramString, UserData paramUserData)
  {
    FileUtils.a(getUserDataFileName(paramString), paramUserData);
  }
  
  public UserData.UserDataItem getAndGenUserDataItem(String paramString)
  {
    UserData.UserDataItem localUserDataItem2 = (UserData.UserDataItem)this.userDataItems.get(paramString);
    UserData.UserDataItem localUserDataItem1 = localUserDataItem2;
    if (localUserDataItem2 == null)
    {
      localUserDataItem1 = new UserData.UserDataItem(paramString);
      this.userDataItems.put(paramString, localUserDataItem1);
    }
    return localUserDataItem1;
  }
  
  public int getShareForbidden()
  {
    return this.shareForbidden;
  }
  
  public boolean onGetEntryConfig(EntryConfigBean paramEntryConfigBean)
  {
    if (paramEntryConfigBean.version != this.configVersion)
    {
      QLog.d("shua2021_UserData", 1, String.format("onGetEntryConfig changed oldV=%d newV=%d", new Object[] { Integer.valueOf(this.configVersion), Integer.valueOf(paramEntryConfigBean.version) }));
      reset();
      this.grabReqInterval = paramEntryConfigBean.commonData.grabReqInterval;
      this.configVersion = paramEntryConfigBean.version;
      return true;
    }
    return false;
  }
  
  public void reset()
  {
    this.configVersion = 0;
    this.grabReqInterval = 3000;
    this.showGestureTs = 0L;
    this.hasClickedHolder = false;
    this.hasShowedMiniApp = false;
    this.userDataItems.clear();
  }
  
  public void setShareForbidden(int paramInt)
  {
    this.shareForbidden = paramInt;
  }
  
  public String toString()
  {
    return "UserData{configVersion=" + this.configVersion + ", grabReqInterval=" + this.grabReqInterval + ", showGestureTs=" + this.showGestureTs + ", userDataItems=" + this.userDataItems + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.UserData
 * JD-Core Version:    0.7.0.1
 */