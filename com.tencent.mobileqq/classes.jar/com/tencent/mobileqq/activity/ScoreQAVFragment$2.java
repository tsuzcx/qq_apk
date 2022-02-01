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
    paramView = (Button)paramView.findViewById(2131375221);
    if (paramView.isSelected())
    {
      paramView.setSelected(false);
      this.a.a(paramInt);
      if (this.a.a.size() != 0) {}
    }
    do
    {
      return;
      paramView.setSelected(true);
      this.a.a.add(Integer.valueOf(paramInt));
    } while (this.a.a.size() <= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ScoreQAVFragment.2
 * JD-Core Version:    0.7.0.1
 */