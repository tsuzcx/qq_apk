package com.tencent.biz.qqstory.storyHome;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import java.io.File;

@Deprecated
public class QQStoryTakeVideoActivityLauncher
{
  @NonNull
  private final QQAppInterface a;
  
  public QQStoryTakeVideoActivityLauncher(@NonNull QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public Intent a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramContext, paramBoolean1, paramBoolean2, new Intent());
  }
  
  public Intent a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, Intent paramIntent)
  {
    paramIntent.putExtra("videoIsUsable", paramBoolean2);
    paramContext = (IRedTouchManager)this.a.getRuntimeService(IRedTouchManager.class, "");
    paramIntent = paramContext.getAppInfoByPath("103100.103500.103501");
    if (paramIntent != null) {
      paramIntent.iNewFlag.get();
    }
    paramIntent = BaseApplicationImpl.getApplication().getSharedPreferences("flow_filter_reddot_sp", 4);
    if (paramIntent.getBoolean("flow_filter_reddot_key", false))
    {
      paramContext.onRedTouchItemClick("103100.103500.103501");
      paramIntent.edit().putBoolean("flow_filter_reddot_key", false).commit();
    }
    paramContext = BaseApplicationImpl.getApplication();
    paramIntent = new StringBuilder();
    paramIntent.append("flow_filter_reddot_pkg_sp");
    paramIntent.append(this.a.getCurrentAccountUin());
    paramContext.getSharedPreferences(paramIntent.toString(), 4).getBoolean("flow_filter_reddot_key", false);
    PtvFilterSoLoad.a(this.a, BaseApplicationImpl.getContext());
    PlusPanelUtils.a(QQStoryConstant.g);
    paramContext = new File(AppConstants.SDCARD_IMG_CAMERA);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    this.a.getAccount();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryTakeVideoActivityLauncher
 * JD-Core Version:    0.7.0.1
 */