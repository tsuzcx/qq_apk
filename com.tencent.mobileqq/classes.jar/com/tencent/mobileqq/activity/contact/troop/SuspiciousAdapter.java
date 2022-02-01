package com.tencent.mobileqq.activity.contact.troop;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.contact.recommendtroop.base.CommonAdapter;
import com.tencent.widget.SwipListView.SwipListListener;

public abstract class SuspiciousAdapter<T>
  extends CommonAdapter<T>
  implements SwipListView.SwipListListener
{
  protected DelMenuBuilder a;
  protected int d = -1;
  
  public SuspiciousAdapter(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.a = new DelMenuBuilder(paramContext);
  }
  
  public void hideMenuPop() {}
  
  public void interceptTouchEvent(boolean paramBoolean) {}
  
  public void updateCurShowRightView(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      if (!(paramView instanceof Integer)) {}
    }
    for (int i = ((Integer)paramView).intValue();; i = -1)
    {
      this.d = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.SuspiciousAdapter
 * JD-Core Version:    0.7.0.1
 */