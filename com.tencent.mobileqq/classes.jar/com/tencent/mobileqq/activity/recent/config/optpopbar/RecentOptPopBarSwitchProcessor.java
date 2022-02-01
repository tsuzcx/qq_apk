package com.tencent.mobileqq.activity.recent.config.optpopbar;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.RecentOptPopBar;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class RecentOptPopBarSwitchProcessor
  extends IQConfigProcessor<RecentOptPopBarSwitchBean>
{
  private static final String a = RecentOptPopBar.class.getSimpleName();
  
  @NonNull
  public RecentOptPopBarSwitchBean a(int paramInt)
  {
    return RecentOptPopBarSwitchBean.a();
  }
  
  @Nullable
  public RecentOptPopBarSwitchBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (!TextUtils.isEmpty(paramArrayOfQConfItem[0].a))) {
      return RecentOptPopBarSwitchBean.a(paramArrayOfQConfItem[0].a);
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "RecentOptPopBarSwitchProcessor#onParsed, confFiles != null && confFiles.length > 0 && !TextUtils.isEmpty(confFiles[0].content)");
    }
    return RecentOptPopBarSwitchBean.a();
  }
  
  public void a(RecentOptPopBarSwitchBean paramRecentOptPopBarSwitchBean) {}
  
  public Class<RecentOptPopBarSwitchBean> clazz()
  {
    return RecentOptPopBarSwitchBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 744;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.optpopbar.RecentOptPopBarSwitchProcessor
 * JD-Core Version:    0.7.0.1
 */