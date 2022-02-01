package com.tencent.mobileqq.activity.aio.helper;

import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class JdTipHelper
  implements Handler.Callback, ILifeCycleHelper
{
  RelativeLayout a;
  URLImageView b;
  RelativeLayout c;
  Animation d;
  Animation e;
  Animation f;
  ImageView g;
  ImageView h;
  int i = DisplayUtil.a(BaseApplicationImpl.getContext(), 50.0F);
  int j = DisplayUtil.a(BaseApplicationImpl.getContext(), 30.0F);
  Animation.AnimationListener k = new JdTipHelper.1(this);
  private final AIOContext l;
  
  public JdTipHelper(AIOContext paramAIOContext)
  {
    this.l = paramAIOContext;
  }
  
  public void a()
  {
    if ((this.b != null) && (this.c != null))
    {
      if (this.a == null) {
        return;
      }
      int m = this.i;
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(m, m);
      localLayoutParams.addRule(11);
      Object localObject = this.c;
      m = 2131447885;
      localObject = ((RelativeLayout)localObject).findViewById(2131447885);
      View localView = this.c.findViewById(2131447879);
      if ((localObject == null) || (((View)localObject).getVisibility() != 0)) {
        m = -1;
      }
      int n = m;
      if (localView != null)
      {
        n = m;
        if (localView.getVisibility() == 0) {
          n = 2131447879;
        }
      }
      m = this.j;
      int i1 = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299920);
      if (n == -1)
      {
        localLayoutParams.addRule(10);
        m += i1;
      }
      else
      {
        localLayoutParams.addRule(3, n);
      }
      localLayoutParams.topMargin = m;
      localLayoutParams.rightMargin = DisplayUtil.a(BaseApplicationImpl.getContext(), 40.0F);
      this.a.setLayoutParams(localLayoutParams);
    }
  }
  
  @NonNull
  public String getTag()
  {
    return "JdTipHelper";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 68)
    {
      a();
      return true;
    }
    return false;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt == 15)
    {
      RelativeLayout localRelativeLayout1 = this.c;
      if (localRelativeLayout1 != null)
      {
        RelativeLayout localRelativeLayout2 = this.a;
        if ((localRelativeLayout2 != null) && (localRelativeLayout1.indexOfChild(localRelativeLayout2) != -1))
        {
          this.a.clearAnimation();
          this.c.removeView(this.a);
          this.c = null;
          this.a = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.JdTipHelper
 * JD-Core Version:    0.7.0.1
 */