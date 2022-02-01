package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;

public class QCircleTitleFollowView
  extends QCircleFollowView
{
  private boolean b;
  
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
      QLog.d("QCircleFollowView", 1, "uin:" + this.a.id.get() + " state:" + paramInt);
    }
    if ((getVisibility() == 8) && ((!this.b) || (paramInt != 0))) {
      return;
    }
    if (paramInt == 1)
    {
      a(paramBoolean);
      return;
    }
    b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleTitleFollowView
 * JD-Core Version:    0.7.0.1
 */