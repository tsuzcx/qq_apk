package com.tencent.biz.qqstory.shareGroup.addvideo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.ActionSheet;

public class AddVideoController
{
  private final QQAppInterface a;
  
  public AddVideoController(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      throw new NullPointerException("appInterface is null");
    }
    this.a = paramQQAppInterface;
  }
  
  public void a(Context paramContext, int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2, int paramInt3)
  {
    if (paramContext == null) {
      throw new NullPointerException("context is null");
    }
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("please indicate the share group id");
    }
    if ((paramInt1 != 2) && (paramInt1 != 1)) {
      throw new IllegalArgumentException("shareGroupType is error, type=" + paramInt1);
    }
    ActionSheet localActionSheet = ActionSheet.create(paramContext);
    localActionSheet.addButton(HardCodeUtil.a(2131699962), 5);
    localActionSheet.addButton(HardCodeUtil.a(2131699960) + QQStoryConstant.a + HardCodeUtil.a(2131699961), 5);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new AddVideoController.1(this, localActionSheet, paramContext, paramInt1, paramString1, paramString2, paramLong, paramInt2, paramInt3));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  public void a(Context paramContext, int paramInt1, String paramString1, String paramString2, long paramLong, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    SLog.d("AddVideoController", "addVideoByRecord %s %s %s", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
    if (paramContext == null) {
      throw new NullPointerException("context is null");
    }
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("please indicate the share group id");
    }
    StoryPublishLauncher localStoryPublishLauncher = StoryPublishLauncher.a();
    Bundle localBundle = new Bundle();
    localBundle.putInt("entrance_type", 102);
    localBundle.putInt("shareGroupType", paramInt1);
    localBundle.putString("shareGroupId", paramString1);
    localBundle.putString("shareGroupName", paramString2);
    localBundle.putInt("add_video_source", paramInt3);
    if (paramInt1 == 1) {
      localBundle.putLong("groupUin", paramLong);
    }
    localBundle.putBoolean("ignorePersonalPublish", paramBoolean);
    if ((paramContext instanceof Activity))
    {
      paramContext = (Activity)paramContext;
      localStoryPublishLauncher.a(paramContext, localBundle, paramInt2);
      paramContext.overridePendingTransition(2130772253, 2130772045);
      return;
    }
    localStoryPublishLauncher.a(paramContext, localBundle);
  }
  
  public void b(Context paramContext, int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2, int paramInt3)
  {
    SLog.d("AddVideoController", "addVideoByExist %s %s", new Object[] { paramString1, paramString2 });
    Bundle localBundle = new Bundle();
    localBundle.putString("shareGroupId", paramString1);
    localBundle.putString("shareGroupName", paramString2);
    localBundle.putInt("add_video_source", paramInt3);
    StoryTransitionActivity.a(paramContext, AddVideoMiddleCode.class.getName(), localBundle, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.addvideo.AddVideoController
 * JD-Core Version:    0.7.0.1
 */