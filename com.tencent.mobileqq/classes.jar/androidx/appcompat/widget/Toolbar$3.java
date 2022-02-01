package androidx.appcompat.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class Toolbar$3
  implements View.OnClickListener
{
  Toolbar$3(Toolbar paramToolbar) {}
  
  public void onClick(View paramView)
  {
    this.this$0.collapseActionView();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.Toolbar.3
 * JD-Core Version:    0.7.0.1
 */