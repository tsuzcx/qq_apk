package com.tencent.mm.ui.widget.listview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

class AnimatedExpandableListView$DummyView
  extends View
{
  private List<View> a = new ArrayList();
  private Drawable b;
  private int c;
  private int d;
  
  private AnimatedExpandableListView$DummyView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if (paramDrawable != null)
    {
      this.b = paramDrawable;
      this.c = paramInt1;
      this.d = paramInt2;
      paramDrawable.setBounds(0, 0, paramInt1, paramInt2);
    }
  }
  
  public void addFakeView(View paramView)
  {
    paramView.layout(0, 0, getWidth(), getHeight());
    this.a.add(paramView);
  }
  
  public void clearViews()
  {
    this.a.clear();
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    Object localObject = this.b;
    int i = 0;
    if (localObject != null) {
      ((Drawable)localObject).setBounds(0, 0, this.c, this.d);
    }
    int j = this.a.size();
    while (i < j)
    {
      localObject = (View)this.a.get(i);
      ((View)localObject).draw(paramCanvas);
      paramCanvas.translate(0.0F, ((View)localObject).getMeasuredHeight());
      localObject = this.b;
      if (localObject != null)
      {
        ((Drawable)localObject).draw(paramCanvas);
        paramCanvas.translate(0.0F, this.d);
      }
      i += 1;
    }
    paramCanvas.restore();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      ((View)this.a.get(i)).layout(paramInt1, paramInt2, paramInt3, paramInt4);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.DummyView
 * JD-Core Version:    0.7.0.1
 */