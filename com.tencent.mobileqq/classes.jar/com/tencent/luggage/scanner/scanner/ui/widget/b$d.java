package com.tencent.luggage.scanner.scanner.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class b$d
  implements View.OnClickListener
{
  b$d(b paramb) {}
  
  public final void onClick(View paramView)
  {
    View.OnClickListener localOnClickListener = b.b(this.a);
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.widget.b.d
 * JD-Core Version:    0.7.0.1
 */