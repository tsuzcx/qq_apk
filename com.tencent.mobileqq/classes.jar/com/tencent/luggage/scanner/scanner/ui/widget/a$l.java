package com.tencent.luggage.scanner.scanner.ui.widget;

import android.graphics.PointF;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/luggage/scanner/scanner/ui/widget/ScanCodeMaskView$showSuccessView$1$1$1", "com/tencent/luggage/scanner/scanner/ui/widget/ScanCodeMaskView$$special$$inlined$apply$lambda$1"}, k=3, mv={1, 1, 16})
final class a$l
  implements View.OnClickListener
{
  a$l(int paramInt, PointF paramPointF, Ref.ObjectRef paramObjectRef, a parama, Ref.BooleanRef paramBooleanRef) {}
  
  public final void onClick(View paramView)
  {
    a.a(this.d, this.a);
    Object localObject = a.d(this.d);
    if (localObject != null) {
      ((c)localObject).a(this.a, (View)this.c.element);
    }
    localObject = ((Iterable)a.e(this.d)).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((View)((Iterator)localObject).next()).setOnClickListener(null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.widget.a.l
 * JD-Core Version:    0.7.0.1
 */