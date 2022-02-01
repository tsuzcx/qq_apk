package com.tencent.biz.qqcircle.fragments.person;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.widget.immersive.ImmersiveUtils;
import zxi;

class QCirclePersonalBaseBottomFragment$3
  implements Runnable
{
  QCirclePersonalBaseBottomFragment$3(QCirclePersonalBaseBottomFragment paramQCirclePersonalBaseBottomFragment, View paramView) {}
  
  public void run()
  {
    if (this.a != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.this$0.a.a().getLayoutParams();
      localLayoutParams.height = (ImmersiveUtils.b() - this.a.getHeight() - ImmersiveUtils.a(98.0F));
      this.this$0.a.a().setLayoutParams(localLayoutParams);
      if (this.this$0.a.a().getChildCount() > 0) {
        this.this$0.a.a().getChildAt(0).setBackgroundColor(this.this$0.getResources().getColor(2131166233));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBaseBottomFragment.3
 * JD-Core Version:    0.7.0.1
 */