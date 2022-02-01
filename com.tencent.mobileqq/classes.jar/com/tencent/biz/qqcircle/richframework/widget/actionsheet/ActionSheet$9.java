package com.tencent.biz.qqcircle.richframework.widget.actionsheet;

import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;

class ActionSheet$9
  implements View.OnClickListener
{
  ActionSheet$9(ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if ((ActionSheet.e(this.a)) && ((ActionSheet.f(this.a) == null) || (!ActionSheet.f(this.a).contains(Integer.valueOf(i)))) && (ActionSheet.g(this.a) != -1) && (i != ActionSheet.g(this.a)))
    {
      localObject = (View)ActionSheet.h(this.a).get(ActionSheet.g(this.a));
      ((View)localObject).findViewById(2131427550).setVisibility(8);
      localObject = (TextView)((View)localObject).findViewById(2131427549);
      ActionSheet.a(this.a, (TextView)localObject, false);
      localObject = (View)ActionSheet.h(this.a).get(i);
      ((View)localObject).findViewById(2131427550).setVisibility(0);
      localObject = (TextView)((View)localObject).findViewById(2131427549);
      ActionSheet.a(this.a, (TextView)localObject, true);
      ActionSheet.a(this.a, i);
    }
    if (ActionSheet.i(this.a) != null) {
      ActionSheet.i(this.a).a(paramView, i);
    }
    if (ActionSheet.j(this.a) != null)
    {
      localObject = (TextView)paramView.findViewById(2131427549);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        ActionSheet.j(this.a).a(paramView, i, ((TextView)localObject).getText().toString());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet.9
 * JD-Core Version:    0.7.0.1
 */