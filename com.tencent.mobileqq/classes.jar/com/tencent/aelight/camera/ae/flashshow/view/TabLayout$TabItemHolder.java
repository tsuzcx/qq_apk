package com.tencent.aelight.camera.ae.flashshow.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;

class TabLayout$TabItemHolder
{
  int a;
  View b;
  TextView c;
  View d;
  
  TabLayout$TabItemHolder(TabLayout paramTabLayout, @NonNull View paramView, String paramString, int paramInt)
  {
    this.a = paramInt;
    this.b = paramView;
    this.c = ((TextView)paramView.findViewById(2063991466));
    this.d = paramView.findViewById(2063990885);
    this.c.setTextSize(1, 16.0F);
    this.c.setText(paramString);
    paramView = (ViewGroup.MarginLayoutParams)this.d.getLayoutParams();
    paramView.topMargin = paramTabLayout.a(7.0F);
    paramView.width = paramTabLayout.a(6.0F);
    paramView.height = paramTabLayout.a(6.0F);
    this.d.setLayoutParams(paramView);
    this.d.setBackgroundResource(0);
    a(TabLayout.e(paramTabLayout));
  }
  
  void a(int paramInt)
  {
    TextView localTextView = this.c;
    Context localContext = this.e.getContext();
    if (paramInt == 0) {
      paramInt = 2063794243;
    } else {
      paramInt = 2063794242;
    }
    localTextView.setTextColor(AppCompatResources.getColorStateList(localContext, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.view.TabLayout.TabItemHolder
 * JD-Core Version:    0.7.0.1
 */