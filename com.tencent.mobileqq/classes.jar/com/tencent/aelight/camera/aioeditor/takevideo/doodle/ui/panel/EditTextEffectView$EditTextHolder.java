package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingView;
import com.tencent.mobileqq.flashchat.OnHolderItemClickListener;
import com.tencent.qphone.base.util.QLog;

class EditTextEffectView$EditTextHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  OnHolderItemClickListener a;
  DynamicTextConfigManager.DynamicTextConfigBean b;
  View c;
  ImageView d;
  ImageView e;
  ImageView f;
  View g;
  ImageView h;
  QIMCommonLoadingView i;
  int j;
  
  public EditTextEffectView$EditTextHolder(View paramView, OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    super(paramView);
    this.a = paramOnHolderItemClickListener;
    this.c = paramView;
    this.d = ((ImageView)paramView.findViewById(2131432369));
    this.e = ((ImageView)paramView.findViewById(2131432370));
    this.f = ((ImageView)paramView.findViewById(2131432372));
    this.g = paramView.findViewById(2131432371);
    this.i = ((QIMCommonLoadingView)paramView.findViewById(2131437654));
    this.h = ((ImageView)paramView.findViewById(2131435656));
    paramView.setOnClickListener(this);
    paramOnHolderItemClickListener = (RelativeLayout.LayoutParams)this.i.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramOnHolderItemClickListener.width = localMarginLayoutParams.width;
    paramOnHolderItemClickListener.height = localMarginLayoutParams.height;
    paramOnHolderItemClickListener.addRule(10);
    paramOnHolderItemClickListener.addRule(9);
    paramOnHolderItemClickListener.addRule(12);
    paramOnHolderItemClickListener.addRule(11);
    this.i.setLayoutParams(paramOnHolderItemClickListener);
    this.i.setBgCorner(QIMCommonLoadingView.a(7.0F, paramView.getContext()));
    localLayoutParams.width = localMarginLayoutParams.width;
    localLayoutParams.height = localMarginLayoutParams.height;
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(11);
    this.f.setLayoutParams(localLayoutParams);
  }
  
  public void a(float paramFloat)
  {
    if (this.i.getVisibility() != 0) {
      this.i.setVisibility(0);
    }
    this.i.setProgress((int)paramFloat);
    int k = this.i.getMeasuredWidth();
    int m = this.i.getMeasuredHeight();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateProgress progress is: ");
      localStringBuilder.append(paramFloat);
      localStringBuilder.append(" pos is: ");
      localStringBuilder.append(this.j);
      localStringBuilder.append(" width is: ");
      localStringBuilder.append(k);
      localStringBuilder.append("height is: ");
      localStringBuilder.append(m);
      QLog.i("DText", 2, localStringBuilder.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.i.getVisibility() != 8) {
      this.i.setVisibility(8);
    }
    if (paramBoolean)
    {
      if (this.h.getVisibility() != 8) {
        this.h.setVisibility(8);
      }
    }
    else if (this.h.getVisibility() != 0) {
      this.h.setVisibility(0);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("finish download pos is: ");
      localStringBuilder.append(this.j);
      QLog.i("DText", 2, localStringBuilder.toString());
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.f.getVisibility() != 0) {
        this.f.setVisibility(0);
      }
    }
    else if (this.f.getVisibility() != 8) {
      this.f.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.c)
    {
      OnHolderItemClickListener localOnHolderItemClickListener = this.a;
      if (localOnHolderItemClickListener != null) {
        localOnHolderItemClickListener.a(paramView, getAdapterPosition(), -1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditTextEffectView.EditTextHolder
 * JD-Core Version:    0.7.0.1
 */