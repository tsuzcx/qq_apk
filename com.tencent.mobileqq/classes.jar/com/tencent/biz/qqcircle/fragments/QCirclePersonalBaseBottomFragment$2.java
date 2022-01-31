package com.tencent.biz.qqcircle.fragments;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.widget.immersive.ImmersiveUtils;
import tvw;

class QCirclePersonalBaseBottomFragment$2
  implements Runnable
{
  QCirclePersonalBaseBottomFragment$2(QCirclePersonalBaseBottomFragment paramQCirclePersonalBaseBottomFragment, View paramView) {}
  
  public void run()
  {
    if (this.a != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.this$0.a.a().getLayoutParams();
      localLayoutParams.height = (ImmersiveUtils.b() - this.a.getHeight() - ImmersiveUtils.a(98.0F));
      this.this$0.a.a().setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCirclePersonalBaseBottomFragment.2
 * JD-Core Version:    0.7.0.1
 */