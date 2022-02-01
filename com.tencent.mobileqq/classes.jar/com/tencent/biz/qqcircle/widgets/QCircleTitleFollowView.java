package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.utils.QFSCommonUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;

public class QCircleTitleFollowView
  extends QCircleFollowView
{
  private boolean b = false;
  
  public QCircleTitleFollowView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleTitleFollowView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleTitleFollowView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a()
  {
    super.a();
    setVisibility(8);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.a != null)
    {
      this.a.followState.set(paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin:");
      localStringBuilder.append(this.a.id.get());
      localStringBuilder.append(" state:");
      localStringBuilder.append(paramInt);
      QLog.d("QCircleFollowView", 1, localStringBuilder.toString());
    }
    if ((getVisibility() == 8) && ((!this.b) || (paramInt != 0))) {
      return;
    }
    if (QCirclePluginUtil.c(paramInt)) {
      a(paramBoolean);
    } else {
      b();
    }
    b(paramInt);
  }
  
  public void onThemeUpdate()
  {
    super.onThemeUpdate();
    if (QFSCommonUtil.a(this.a)) {
      setVisibility(8);
    }
  }
  
  public void setUserData(FeedCloudMeta.StUser paramStUser)
  {
    int i = getVisibility();
    super.setUserData(paramStUser);
    setVisibility(i);
  }
  
  public void setmCanShowUnfollow(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleTitleFollowView
 * JD-Core Version:    0.7.0.1
 */