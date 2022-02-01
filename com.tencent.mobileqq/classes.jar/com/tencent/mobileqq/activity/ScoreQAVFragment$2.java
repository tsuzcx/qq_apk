package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

class ScoreQAVFragment$2
  implements ScoreQAVFragment.OnItemClickListener
{
  ScoreQAVFragment$2(ScoreQAVFragment paramScoreQAVFragment) {}
  
  public void a(View paramView, int paramInt)
  {
    paramView = (Button)paramView.findViewById(2131374736);
    if (paramView.isSelected())
    {
      paramView.setSelected(false);
      this.a.a(paramInt);
      this.a.a.size();
      return;
    }
    paramView.setSelected(true);
    this.a.a.add(Integer.valueOf(paramInt));
    this.a.a.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ScoreQAVFragment.2
 * JD-Core Version:    0.7.0.1
 */