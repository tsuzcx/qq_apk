package com.tencent.biz.qqcircle.fragments.person;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.IStatusViewProvider;
import cooperation.qqcircle.helpers.QCircleSkinHelper;

class QCirclePersonalBaseBottomFragment$5
  implements Runnable
{
  QCirclePersonalBaseBottomFragment$5(QCirclePersonalBaseBottomFragment paramQCirclePersonalBaseBottomFragment, View paramView) {}
  
  public void run()
  {
    if (this.a != null)
    {
      if (!(this.this$0.c.bc_().getStatusView() instanceof QCircleStatusView)) {
        return;
      }
      QCircleStatusView localQCircleStatusView = (QCircleStatusView)this.this$0.c.bc_().getStatusView();
      ViewGroup.LayoutParams localLayoutParams = localQCircleStatusView.getLayoutParams();
      localLayoutParams.height = (ImmersiveUtils.c() - this.a.getHeight() - ImmersiveUtils.a(98.0F));
      this.this$0.c.bc_().getStatusView().setLayoutParams(localLayoutParams);
      if (localQCircleStatusView.getChildCount() > 0) {
        localQCircleStatusView.getChildAt(0).setBackgroundColor(QCircleSkinHelper.getInstance().getColor(2131167059));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBaseBottomFragment.5
 * JD-Core Version:    0.7.0.1
 */