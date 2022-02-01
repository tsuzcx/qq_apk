package com.tencent.biz.pubaccount.persistence.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class PAAdPreloadTask
  extends Entity
{
  public static final int NETWORK_TYPE_4G = 2;
  public static final int NETWORK_TYPE_NONE = 0;
  public static final int NETWORK_TYPE_WIFI = 1;
  public static final int PRELOAD_STATE_FAILED = 4;
  public static final int PRELOAD_STATE_FINISH = 3;
  public static final int PRELOAD_STATE_LOADING = 2;
  public static final int PRELOAD_STATE_NEW = 1;
  public static final int SOURCE_PRELOAD_CONFIG = 1;
  public static final int SOURCE_PRELOAD_MESSAGE = 2;
  public static final int SOURCE_PRELOAD_PLAY = 3;
  public static final String TABLE_NAME = "PAAdPreloadTask";
  public long mExpireTime = 0L;
  public String mMsgId = null;
  public int mNetworkType = 1;
  public int mPreloadState = 0;
  public long mReceiveTime = 0L;
  public int mSource = 0;
  public String mTaskId = null;
  public String mUserUin = null;
  public String mVideoVid = null;
  
  public static int checkNetworkType(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 3)) {
      return paramInt;
    }
    return 1;
  }
  
  public static ArrayList<PAAdPreloadTask> parserConfigTask(String paramString1, String paramString2)
  {
    localArrayList = new ArrayList();
    try
    {
      Object localObject = new JSONObject(paramString2);
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      long l2 = ((JSONObject)localObject).getLong("expire_time");
      if (l2 <= l1) {
        return localArrayList;
      }
      paramString2 = ((JSONObject)localObject).getString("task_id");
      int j = ((JSONObject)localObject).getInt("network_type");
      localObject = ((JSONObject)localObject).getJSONArray("video_list");
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        PAAdPreloadTask localPAAdPreloadTask = new PAAdPreloadTask();
        localPAAdPreloadTask.mUserUin = paramString1;
        localPAAdPreloadTask.mTaskId = paramString2;
        localPAAdPreloadTask.mVideoVid = localJSONObject.getString("vid");
        localPAAdPreloadTask.mSource = 1;
        localPAAdPreloadTask.mReceiveTime = l1;
        localPAAdPreloadTask.mExpireTime = l2;
        localPAAdPreloadTask.mPreloadState = 1;
        localPAAdPreloadTask.mNetworkType = checkNetworkType(j);
        localArrayList.add(localPAAdPreloadTask);
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (PAAdPreloadTask)paramObject;
      if (TextUtils.isEmpty(this.mUserUin)) {
        return false;
      }
      if (!this.mUserUin.equals(paramObject.mUserUin)) {
        return false;
      }
      return this.mVideoVid.equals(paramObject.mVideoVid);
    }
    return false;
  }
  
  public int hashCode()
  {
    return (this.mUserUin.hashCode() * 31 + this.mVideoVid.hashCode()) * 31 + this.mNetworkType;
  }
  
  public boolean isExpire()
  {
    return this.mExpireTime < NetConnInfoCenter.getServerTimeMillis();
  }
  
  public boolean isNetworkValid()
  {
    if (((this.mNetworkType & 0x1) != 0) && (NetworkUtil.isWifiConnected(null))) {
      return true;
    }
    return ((this.mNetworkType & 0x2) != 0) && (NetworkUtil.getSystemNetwork(BaseApplication.getContext()) == 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask
 * JD-Core Version:    0.7.0.1
 */