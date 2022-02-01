package com.tencent.hippy.qq.fragment;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class HippyErrorViewWrapper
{
  private int mErrorViewColor = -1;
  private ImageView mNetworkErrorIcon;
  private TextView mNetworkErrorText;
  private View mRootView;
  
  public void hideNetworkErrorView()
  {
    if (this.mRootView != null) {
      this.mRootView.setVisibility(8);
    }
  }
  
  public void initNetworkErrorView(ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    if (this.mRootView == null)
    {
      this.mRootView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560315, null);
      this.mNetworkErrorText = ((TextView)this.mRootView.findViewById(2131376550));
      this.mNetworkErrorIcon = ((ImageView)this.mRootView.findViewById(2131376549));
      if (this.mErrorViewColor != -1) {
        this.mRootView.setBackgroundColor(this.mErrorViewColor);
      }
    }
    int i;
    if (this.mErrorViewColor == -1)
    {
      this.mNetworkErrorIcon.setImageDrawable(paramViewGroup.getResources().getDrawable(2130839418));
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mNetworkErrorText.getLayoutParams();
      localLayoutParams.topMargin = AIOUtils.a(10.0F, paramViewGroup.getResources());
      this.mNetworkErrorText.setLayoutParams(localLayoutParams);
      this.mNetworkErrorText.setTextColor(paramViewGroup.getResources().getColor(2131166909));
      this.mNetworkErrorText.setText(paramViewGroup.getResources().getString(2131718345));
      this.mRootView.setOnClickListener(paramOnClickListener);
      this.mRootView.setVisibility(0);
      i = 0;
    }
    for (;;)
    {
      if (i >= paramViewGroup.getChildCount()) {
        break label231;
      }
      if (paramViewGroup.getChildAt(i) == this.mRootView)
      {
        return;
        this.mNetworkErrorIcon.setImageDrawable(paramViewGroup.getResources().getDrawable(2130839623));
        break;
      }
      i += 1;
    }
    label231:
    paramOnClickListener = new ViewGroup.LayoutParams(-1, -1);
    paramViewGroup.addView(this.mRootView, paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.fragment.HippyErrorViewWrapper
 * JD-Core Version:    0.7.0.1
 */