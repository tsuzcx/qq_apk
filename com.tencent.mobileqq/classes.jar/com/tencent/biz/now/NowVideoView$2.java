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
    paramString.c = paramString.d;
    paramString = this.a;
    paramString.d = paramInt;
    paramString = paramString.jdField_a_of_type_AndroidWidgetImageView;
    boolean bool = NowVideoController.a().b;
    if (paramInt == 3)
    {
      if (this.a.jdField_a_of_type_AndroidViewAnimationRotateAnimation == null)
      {
        this.a.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
        this.a.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(500L);
        this.a.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatCount(-1);
        this.a.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatMode(1);
        this.a.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setStartTime(-1L);
        paramQQLiveDrawableParams = new LinearInterpolator();
        this.a.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setInterpolator(paramQQLiveDrawableParams);
      }
      if (paramString != null)
      {
        paramString.setVisibility(0);
        paramString.setImageResource(2130843371);
        paramString.clearAnimation();
        this.a.jdField_a_of_type_AndroidOsHandler.post(new NowVideoView.2.1(this, paramString));
      }
    }
    else if (paramInt == 0)
    {
      if (paramString != null)
      {
        paramString.clearAnimation();
        paramString.setImageResource(2130843373);
        paramString.setVisibility(0);
      }
    }
    else if (paramInt == 4)
    {
      if ((paramString != null) && (!bool))
      {
        paramString.clearAnimation();
        paramString.setImageResource(2130843373);
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
      paramString.e = 0;
      paramString.f = 0;
      paramString.a(1);
    }
    else if (paramInt == 5)
    {
      if (paramString != null)
      {
        paramString.clearAnimation();
        paramString.setVisibility(0);
        paramString.setImageResource(2130843369);
      }
      if (!NetworkUtil.isNetworkAvailable(this.a.getContext()))
      {
        QQToast.a(this.a.getContext(), 1, 2131694425, 0).b(NowVideoView.g);
        return;
      }
      if (this.a.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        this.a.jdField_a_of_type_JavaUtilList.remove(this.a.jdField_a_of_type_JavaUtilList.get(this.a.jdField_a_of_type_JavaUtilList.size() - 1));
        this.a.jdField_a_of_type_ComTencentBizNowNowVideoView$ThirdDataSourceAdapter.a();
      }
      if ((this.a.jdField_a_of_type_JavaUtilList.size() == 0) && ((paramObject instanceof QQLiveDrawable.ErrorInfo)))
      {
        paramString = (QQLiveDrawable.ErrorInfo)paramObject;
        paramQQLiveDrawableParams = new StringBuilder();
        paramQQLiveDrawableParams.append("ErrorInf = ");
        paramQQLiveDrawableParams.append(paramString.toString());
        QLog.d("NowVideoView", 2, paramQQLiveDrawableParams.toString());
      }
    }
    paramString = this.a;
    paramString.a(paramString.c, this.a.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.now.NowVideoView.2
 * JD-Core Version:    0.7.0.1
 */