package com.tencent.biz.qqstory.shareGroup.addvideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.storyHome.QQStoryTakeVideoActivityLauncher;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.ActionSheet;
import nrk;

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
    ActionSheet localActionSheet = ActionSheet.a(paramContext);
    localActionSheet.a("拍摄", 5);
    localActionSheet.a("从已发表的日迹选择", 5);
    localActionSheet.c(2131433015);
    localActionSheet.a(new nrk(this, localActionSheet, paramContext, paramInt1, paramString1, paramString2, paramLong, paramInt2, paramInt3));
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
    Object localObject = StoryPublishLauncher.a();
    Bundle localBundle;
    if (((StoryPublishLauncher)localObject).a())
    {
      localBundle = new Bundle();
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
        ((StoryPublishLauncher)localObject).a(paramContext, localBundle, paramInt2);
        paramContext.overridePendingTransition(2131034327, 2131034167);
      }
    }
    do
    {
      return;
      ((StoryPublishLauncher)localObject).a(paramContext, localBundle);
      return;
      localObject = new QQStoryTakeVideoActivityLauncher(this.a).a(paramContext, 102);
      ((Intent)localObject).putExtra("shareGroupType", paramInt1);
      ((Intent)localObject).putExtra("shareGroupId", paramString1);
      ((Intent)localObject).putExtra("shareGroupName", paramString2);
      ((Intent)localObject).putExtra("groupUin", paramLong);
      ((Intent)localObject).putExtra("ignorePersonalPublish", paramBoolean);
      ((Intent)localObject).putExtra("add_video_source", paramInt3);
      if (!(paramContext instanceof Activity)) {
        break;
      }
      paramContext = (Activity)paramContext;
      paramContext.startActivityForResult((Intent)localObject, paramInt2);
    } while (!((Intent)localObject).getBooleanExtra("videoIsUsable", true));
    paramContext.overridePendingTransition(2131034327, 2131034167);
    return;
    paramContext.startActivity((Intent)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.addvideo.AddVideoController
 * JD-Core Version:    0.7.0.1
 */