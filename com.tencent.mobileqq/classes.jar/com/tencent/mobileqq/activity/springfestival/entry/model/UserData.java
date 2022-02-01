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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("spring_festival_redpacket2021_userdata_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  @NotNull
  public static UserData read(String paramString)
  {
    paramString = getUserDataFileName(paramString);
    localObject1 = null;
    try
    {
      Object localObject2 = FileUtils.readObject(paramString);
      paramString = (String)localObject1;
      if ((localObject2 instanceof UserData)) {
        paramString = (UserData)localObject2;
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString = (String)localObject1;
      }
    }
    localObject1 = paramString;
    if (paramString == null) {
      localObject1 = new UserData();
    }
    return localObject1;
  }
  
  public static void write(String paramString, UserData paramUserData)
  {
    FileUtils.writeObject(getUserDataFileName(paramString), paramUserData);
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
    int j = paramEntryConfigBean.version;
    int i = this.configVersion;
    boolean bool = false;
    if (j != i)
    {
      j = paramEntryConfigBean.version;
      bool = true;
      QLog.d("shua2021_UserData", 1, String.format("onGetEntryConfig changed oldV=%d newV=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
      reset();
      this.grabReqInterval = paramEntryConfigBean.commonData.grabReqInterval;
      this.configVersion = paramEntryConfigBean.version;
    }
    return bool;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UserData{configVersion=");
    localStringBuilder.append(this.configVersion);
    localStringBuilder.append(", grabReqInterval=");
    localStringBuilder.append(this.grabReqInterval);
    localStringBuilder.append(", showGestureTs=");
    localStringBuilder.append(this.showGestureTs);
    localStringBuilder.append(", userDataItems=");
    localStringBuilder.append(this.userDataItems);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.UserData
 * JD-Core Version:    0.7.0.1
 */