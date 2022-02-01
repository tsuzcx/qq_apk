package com.tencent.biz.qcircleshadow.lib;

import android.graphics.Bitmap;
import com.tencent.biz.qcircleshadow.local.requests.QCircleGetMainPageRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudMeta.StUser;
import mqq.app.AppRuntime;

public class QCircleHostGlobalInfo
{
  private static final String TAG = "QCircleHostGlobalInfo";
  private static boolean mCurrentIsActive;
  private static long mDataStatePos;
  private static String mFeedId;
  private static Bitmap mFrameSnapShot;
  private static boolean mHasRestoreState;
  private static volatile FeedCloudMeta.StUser sCurrentUser;
  
  public static String getCurrentLoginAccount()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getAccount();
  }
  
  public static String getCurrentNickName()
  {
    QQAppInterface localQQAppInterface = QCircleCommonUtil.getQQAppInterface();
    if (localQQAppInterface != null) {
      return ContactUtils.getAccountNickName(localQQAppInterface, BaseApplicationImpl.getApplication().getRuntime().getAccount());
    }
    return "";
  }
  
  public static FeedCloudMeta.StUser getCurrentUser()
  {
    try
    {
      if (sCurrentUser == null)
      {
        if (VSNetworkHelper.getInstance() != null) {
          VSNetworkHelper.getInstance().sendRequest(new QCircleGetMainPageRequest(BaseApplicationImpl.getApplication().getRuntime().getAccount()), new QCircleHostGlobalInfo.1());
        }
        FeedCloudMeta.StUser localStUser = getSimpleCurrentUser();
        return localStUser;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return sCurrentUser;
  }
  
  public static long getDataStatePos()
  {
    return mDataStatePos;
  }
  
  public static String getFeedId()
  {
    return mFeedId;
  }
  
  public static Bitmap getFrameSnapShot()
  {
    return mFrameSnapShot;
  }
  
  public static FeedCloudMeta.StUser getSimpleCurrentUser()
  {
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    localStUser.id.set(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    QQAppInterface localQQAppInterface = QCircleCommonUtil.getQQAppInterface();
    if (localQQAppInterface != null) {
      localStUser.nick.set(ContactUtils.getAccountNickName(localQQAppInterface, BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    }
    return localStUser;
  }
  
  public static boolean isCurrentIsActive()
  {
    return mCurrentIsActive;
  }
  
  public static boolean isHasRestoreState()
  {
    return mHasRestoreState;
  }
  
  public static void releaseWhenAccountChange()
  {
    sCurrentUser = null;
  }
  
  public static void saveFeedStatePos(String paramString, long paramLong)
  {
    mFeedId = paramString;
    mDataStatePos = paramLong;
  }
  
  public static void setCurrentIsActive(boolean paramBoolean)
  {
    mCurrentIsActive = paramBoolean;
    QLog.d("QCircleHostGlobalInfo", 4, "setCurrentIsActive:" + paramBoolean);
  }
  
  public static void setFrameSnapShot(Bitmap paramBitmap)
  {
    mFrameSnapShot = paramBitmap;
  }
  
  public static void setHasRestoreState(boolean paramBoolean)
  {
    mHasRestoreState = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostGlobalInfo
 * JD-Core Version:    0.7.0.1
 */