package com.tencent.gdtad.views.freeflip;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtViewStatus.Listener;
import com.tencent.mobileqq.utils.ViewUtils;
import qmq;

public class GdtFreeFlipView
  extends FrameLayout
{
  protected int a;
  private GdtViewStatus.Listener jdField_a_of_type_ComTencentGdtadViewsGdtViewStatus$Listener = new qmq(this);
  private GdtFreeFlipContentView jdField_a_of_type_ComTencentGdtadViewsFreeflipGdtFreeFlipContentView;
  private boolean jdField_a_of_type_Boolean;
  protected int b;
  private int c = 0;
  private int d = 2147483647;
  private int e = 2147483647;
  private int f = 2147483647;
  
  public GdtFreeFlipView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GdtFreeFlipView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GdtFreeFlipView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int a()
  {
    Rect localRect = new Rect();
    if (getGlobalVisibleRect(localRect)) {
      return localRect.top;
    }
    return 2147483647;
  }
  
  private int a(int paramInt)
  {
    if (a()) {
      if (Math.abs(paramInt - this.d) >= Math.abs(this.e - paramInt)) {}
    }
    while (Math.abs(paramInt) < Math.abs(ViewUtils.c() - paramInt))
    {
      return 1;
      return 2;
    }
    return 2;
  }
  
  private void a()
  {
    int i = a();
    if (i == 2147483647) {
      GdtLog.d("GdtFreeFlipView", "resume error");
    }
    do
    {
      return;
      GdtLog.b("GdtFreeFlipView", String.format("resume y:%d", new Object[] { Integer.valueOf(i) }));
      this.c = 1;
    } while (this.jdField_a_of_type_ComTencentGdtadViewsFreeflipGdtFreeFlipContentView == null);
    this.jdField_a_of_type_ComTencentGdtadViewsFreeflipGdtFreeFlipContentView.a(a(i));
  }
  
  private void b()
  {
    GdtLog.b("GdtFreeFlipView", String.format("pause oldY:%d", new Object[] { Integer.valueOf(this.f) }));
    this.c = 2;
    if (this.jdField_a_of_type_ComTencentGdtadViewsFreeflipGdtFreeFlipContentView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsFreeflipGdtFreeFlipContentView.b(a(this.f));
    }
  }
  
  protected boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && (this.d != 2147483647) && (this.e != 2147483647);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_Int, 1073741824);
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.b, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.views.freeflip.GdtFreeFlipView
 * JD-Core Version:    0.7.0.1
 */