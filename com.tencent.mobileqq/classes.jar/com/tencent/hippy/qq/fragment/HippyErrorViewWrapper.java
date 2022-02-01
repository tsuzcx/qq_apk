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
import com.tencent.mobileqq.util.Utils;

public class HippyErrorViewWrapper
{
  private int mErrorViewColor = -1;
  private ImageView mNetworkErrorIcon;
  private TextView mNetworkErrorText;
  private View mRootView;
  
  public void hideNetworkErrorView()
  {
    View localView = this.mRootView;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void initNetworkErrorView(ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    if (this.mRootView == null)
    {
      this.mRootView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131563030, null);
      this.mNetworkErrorText = ((TextView)this.mRootView.findViewById(2131371773));
      this.mNetworkErrorIcon = ((ImageView)this.mRootView.findViewById(2131371771));
      i = this.mErrorViewColor;
      if (i != -1) {
        this.mRootView.setBackgroundColor(i);
      }
    }
    if (this.mErrorViewColor == -1) {
      this.mNetworkErrorIcon.setImageDrawable(paramViewGroup.getResources().getDrawable(2130839274));
    } else {
      this.mNetworkErrorIcon.setImageDrawable(paramViewGroup.getResources().getDrawable(2130839481));
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mNetworkErrorText.getLayoutParams();
    localLayoutParams.topMargin = Utils.a(10.0F, paramViewGroup.getResources());
    this.mNetworkErrorText.setLayoutParams(localLayoutParams);
    this.mNetworkErrorText.setTextColor(paramViewGroup.getResources().getColor(2131165628));
    this.mNetworkErrorText.setText(paramViewGroup.getResources().getString(2131692074));
    this.mRootView.setOnClickListener(paramOnClickListener);
    paramOnClickListener = this.mRootView;
    int i = 0;
    paramOnClickListener.setVisibility(0);
    while (i < paramViewGroup.getChildCount())
    {
      if (paramViewGroup.getChildAt(i) == this.mRootView) {
        return;
      }
      i += 1;
    }
    paramOnClickListener = new ViewGroup.LayoutParams(-1, -1);
    paramViewGroup.addView(this.mRootView, paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.fragment.HippyErrorViewWrapper
 * JD-Core Version:    0.7.0.1
 */