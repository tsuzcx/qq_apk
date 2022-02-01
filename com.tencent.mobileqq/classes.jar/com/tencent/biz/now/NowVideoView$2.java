package com.tencent.biz.now;

import android.os.Handler;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.tencent.image.QQLiveDrawable.ErrorInfo;
import com.tencent.image.QQLiveDrawable.OnStateListener;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class NowVideoView$2
  implements QQLiveDrawable.OnStateListener
{
  NowVideoView$2(NowVideoView paramNowVideoView) {}
  
  public void onStateChange(String paramString, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, int paramInt, Object paramObject)
  {
    paramString = this.a;
    paramString.o = paramString.p;
    paramString = this.a;
    paramString.p = paramInt;
    paramString = paramString.t;
    boolean bool = NowVideoController.a().c;
    if (paramInt == 3)
    {
      if (this.a.x == null)
      {
        this.a.x = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
        this.a.x.setDuration(500L);
        this.a.x.setRepeatCount(-1);
        this.a.x.setRepeatMode(1);
        this.a.x.setStartTime(-1L);
        paramQQLiveDrawableParams = new LinearInterpolator();
        this.a.x.setInterpolator(paramQQLiveDrawableParams);
      }
      if (paramString != null)
      {
        paramString.setVisibility(0);
        paramString.setImageResource(2130844325);
        paramString.clearAnimation();
        this.a.m.post(new NowVideoView.2.1(this, paramString));
      }
    }
    else if (paramInt == 0)
    {
      if (paramString != null)
      {
        paramString.clearAnimation();
        paramString.setImageResource(2130844327);
        paramString.setVisibility(0);
      }
    }
    else if (paramInt == 4)
    {
      if ((paramString != null) && (!bool))
      {
        paramString.clearAnimation();
        paramString.setImageResource(2130844327);
        paramString.setVisibility(0);
      }
    }
    else if (paramInt == 2)
    {
      if (paramString != null)
      {
        paramString.clearAnimation();
        paramString.setVisibility(8);
      }
      paramString = this.a;
      paramString.q = 0;
      paramString.r = 0;
      paramString.a(1);
    }
    else if (paramInt == 5)
    {
      if (paramString != null)
      {
        paramString.clearAnimation();
        paramString.setVisibility(0);
        paramString.setImageResource(2130844323);
      }
      if (!NetworkUtil.isNetworkAvailable(this.a.getContext()))
      {
        QQToast.makeText(this.a.getContext(), 1, 2131892105, 0).show(NowVideoView.s);
        return;
      }
      if (this.a.i.size() > 0)
      {
        this.a.i.remove(this.a.i.get(this.a.i.size() - 1));
        this.a.w.a();
      }
      if ((this.a.i.size() == 0) && ((paramObject instanceof QQLiveDrawable.ErrorInfo)))
      {
        paramString = (QQLiveDrawable.ErrorInfo)paramObject;
        paramQQLiveDrawableParams = new StringBuilder();
        paramQQLiveDrawableParams.append("ErrorInf = ");
        paramQQLiveDrawableParams.append(paramString.toString());
        QLog.d("NowVideoView", 2, paramQQLiveDrawableParams.toString());
      }
    }
    paramString = this.a;
    paramString.a(paramString.o, this.a.p);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.now.NowVideoView.2
 * JD-Core Version:    0.7.0.1
 */