package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.funchat.AVListImageView;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class VoiceChangeItemView1
  extends RelativeLayout
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  AVListImageView jdField_a_of_type_ComTencentAvFunchatAVListImageView = null;
  VoiceChangeData.VoiceInfo jdField_a_of_type_ComTencentAvUiVoiceChangeData$VoiceInfo = null;
  VoiceChangeItemView1.ICallback jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1$ICallback;
  int b;
  
  public VoiceChangeItemView1(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = -16777216;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public void a()
  {
    ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131559785, this);
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView = ((AVListImageView)findViewById(2131380972));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380977));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380976));
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.getLayoutParams();
    int i = AIOUtils.b(65.0F, getResources());
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setLayoutParams(localLayoutParams);
    setOnClickListener(this);
  }
  
  public void a(int paramInt1, VoiceChangeData.VoiceInfo paramVoiceInfo, boolean paramBoolean, int paramInt2, VoiceChangeItemView1.ICallback paramICallback)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1$ICallback = paramICallback;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentAvUiVoiceChangeData$VoiceInfo = paramVoiceInfo;
    if (paramVoiceInfo.jdField_a_of_type_Int == 0)
    {
      paramICallback = this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.getResources();
      if (this.jdField_b_of_type_Int == -16777216) {
        paramICallback = TintStateDrawable.a(paramICallback, 2130842266, 2131166006);
      } else {
        paramICallback = TintStateDrawable.a(paramICallback, 2130842266, 2131166043);
      }
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageDrawable(paramICallback);
    }
    else if (!TextUtils.isEmpty(paramVoiceInfo.jdField_b_of_type_JavaLangString))
    {
      paramICallback = URLDrawable.URLDrawableOptions.obtain();
      paramInt1 = AIOUtils.b(60.0F, getResources());
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(getResources().getColor(2131165886));
      localGradientDrawable.setShape(1);
      localGradientDrawable.setSize(paramInt1, paramInt1);
      paramICallback.mRequestWidth = paramInt1;
      paramICallback.mRequestHeight = paramInt1;
      paramICallback.mFailedDrawable = localGradientDrawable;
      paramICallback.mLoadingDrawable = localGradientDrawable;
      paramICallback = URLDrawable.getDrawable(paramVoiceInfo.jdField_b_of_type_JavaLangString, paramICallback);
      paramICallback.setTag(URLDrawableDecodeHandler.a(paramInt1, paramInt1));
      paramICallback.setDecodeHandler(URLDrawableDecodeHandler.a);
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setImageDrawable(paramICallback);
    }
    paramInt1 = paramVoiceInfo.jdField_b_of_type_Int;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842383);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842383);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842383);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramVoiceInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_b_of_type_Int);
    setHighlight(paramBoolean);
    paramICallback = new StringBuilder();
    paramICallback.append(paramVoiceInfo.jdField_a_of_type_JavaLangString);
    paramICallback.append(HardCodeUtil.a(2131716326));
    setContentDescription(paramICallback.toString());
  }
  
  public void onClick(View paramView)
  {
    VoiceChangeItemView1.ICallback localICallback = this.jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1$ICallback;
    if (localICallback != null) {
      localICallback.a(this, this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.dispatchTouchEvent(paramMotionEvent);
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setHighlight(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvUiVoiceChangeData$VoiceInfo;
    if ((localObject != null) && (((VoiceChangeData.VoiceInfo)localObject).jdField_a_of_type_Int == 0)) {
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setSelected(paramBoolean);
    } else {
      this.jdField_a_of_type_ComTencentAvFunchatAVListImageView.setHighlight(paramBoolean);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    int i;
    if (paramBoolean) {
      i = -15550475;
    } else {
      i = this.jdField_b_of_type_Int;
    }
    ((TextView)localObject).setTextColor(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeItemView1
 * JD-Core Version:    0.7.0.1
 */