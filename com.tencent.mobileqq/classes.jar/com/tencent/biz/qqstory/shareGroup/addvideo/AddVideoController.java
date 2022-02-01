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
    if (paramQQAppInterface != null)
    {
      this.a = paramQQAppInterface;
      return;
    }
    throw new NullPointerException("appInterface is null");
  }
  
  public void a(Context paramContext, int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2, int paramInt3)
  {
    if (paramContext != null)
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        if ((paramInt1 != 2) && (paramInt1 != 1))
        {
          paramContext = new StringBuilder();
          paramContext.append("shareGroupType is error, type=");
          paramContext.append(paramInt1);
          throw new IllegalArgumentException(paramContext.toString());
        }
        ActionSheet localActionSheet = ActionSheet.create(paramContext);
        localActionSheet.addButton(HardCodeUtil.a(2131898148), 5);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131898146));
        localStringBuilder.append(QQStoryConstant.a);
        localStringBuilder.append(HardCodeUtil.a(2131898147));
        localActionSheet.addButton(localStringBuilder.toString(), 5);
        localActionSheet.addCancelButton(2131887648);
        localActionSheet.setOnButtonClickListener(new AddVideoController.1(this, localActionSheet, paramContext, paramInt1, paramString1, paramString2, paramLong, paramInt2, paramInt3));
        if (!localActionSheet.isShowing()) {
          localActionSheet.show();
        }
        return;
      }
      throw new IllegalArgumentException("please indicate the share group id");
    }
    throw new NullPointerException("context is null");
  }
  
  public void a(Context paramContext, int paramInt1, String paramString1, String paramString2, long paramLong, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    SLog.d("AddVideoController", "addVideoByRecord %s %s %s", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
    if (paramContext != null)
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString1 = StoryPublishLauncher.a();
        paramString2 = new Bundle();
        paramString2.putInt("entrance_type", 102);
        if ((paramContext instanceof Activity))
        {
          paramContext = (Activity)paramContext;
          paramString1.a(paramContext, paramString2, paramInt2);
          paramContext.overridePendingTransition(2130772373, 2130772092);
          return;
        }
        paramString1.a(paramContext, paramString2);
        return;
      }
      throw new IllegalArgumentException("please indicate the share group id");
    }
    throw new NullPointerException("context is null");
  }
  
  public void b(Context paramContext, int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2, int paramInt3)
  {
    SLog.d("AddVideoController", "addVideoByExist %s %s", new Object[] { paramString1, paramString2 });
    paramString1 = new Bundle();
    StoryTransitionActivity.a(paramContext, AddVideoMiddleCode.class.getName(), paramString1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.addvideo.AddVideoController
 * JD-Core Version:    0.7.0.1
 */