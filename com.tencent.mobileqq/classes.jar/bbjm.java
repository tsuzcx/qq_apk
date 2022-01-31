import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.Pair;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class bbjm
  extends FrameLayout
{
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  int[] jdField_a_of_type_ArrayOfInt = new int[2];
  
  public bbjm(bbji parambbji, Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
  }
  
  private FrameLayout.LayoutParams a(bbjl parambbjl, bbjk parambbjk)
  {
    if (parambbjk.width == -9) {
      parambbjk.width = (parambbjl.jdField_a_of_type_AndroidViewView.getMeasuredWidth() + -parambbjk.a * 2);
    }
    if (parambbjk.height == -9) {
      parambbjk.height = (parambbjl.jdField_a_of_type_AndroidViewView.getMeasuredHeight() + -parambbjk.b * 2);
    }
    if (parambbjk.a != 2147483647)
    {
      parambbjk.gravity |= 0x3;
      parambbjk.leftMargin = (parambbjl.jdField_a_of_type_ArrayOfInt[0] + parambbjk.a - this.jdField_a_of_type_ArrayOfInt[0]);
    }
    if (parambbjk.b != 2147483647)
    {
      parambbjk.gravity |= 0x30;
      parambbjk.topMargin = (parambbjl.jdField_a_of_type_ArrayOfInt[1] + parambbjk.b - this.jdField_a_of_type_ArrayOfInt[1]);
    }
    return parambbjk;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    try
    {
      getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      int i = 0;
      while (i < bbji.a(this.jdField_a_of_type_Bbji).size())
      {
        bbjl localbbjl = (bbjl)bbji.a(this.jdField_a_of_type_Bbji).valueAt(i);
        if (localbbjl.jdField_a_of_type_ArrayOfInt == null)
        {
          localbbjl.jdField_a_of_type_ArrayOfInt = new int[2];
          localbbjl.jdField_a_of_type_AndroidViewView.getLocationOnScreen(localbbjl.jdField_a_of_type_ArrayOfInt);
        }
        i += 1;
      }
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GuideView", 2, "getLocationOnScreen Null Pointer");
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = 0;
    while (i < bbji.a(this.jdField_a_of_type_Bbji).size())
    {
      bbjl localbbjl = (bbjl)bbji.a(this.jdField_a_of_type_Bbji).valueAt(i);
      int j = paramCanvas.save();
      this.jdField_a_of_type_AndroidGraphicsRectF.set(localbbjl.jdField_a_of_type_ArrayOfInt[0], localbbjl.jdField_a_of_type_ArrayOfInt[1], localbbjl.jdField_a_of_type_ArrayOfInt[0] + localbbjl.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), localbbjl.jdField_a_of_type_ArrayOfInt[1] + localbbjl.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
      this.jdField_a_of_type_AndroidGraphicsRectF.offset(-this.jdField_a_of_type_ArrayOfInt[0], -this.jdField_a_of_type_ArrayOfInt[1]);
      paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRectF);
      localbbjl.jdField_a_of_type_AndroidViewView.getRootView().draw(paramCanvas);
      paramCanvas.restoreToCount(j);
      i += 1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = 0;
    while (paramInt1 < bbji.a(this.jdField_a_of_type_Bbji).size())
    {
      bbjl localbbjl = (bbjl)bbji.a(this.jdField_a_of_type_Bbji).valueAt(paramInt1);
      Iterator localIterator = localbbjl.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (indexOfChild((View)localPair.first) == -1)
        {
          Object localObject = ((View)localPair.first).getLayoutParams();
          if (localPair.second != null) {
            localObject = a(localbbjl, (bbjk)localPair.second);
          }
          if (localObject != null) {
            addViewInLayout((View)localPair.first, -1, (ViewGroup.LayoutParams)localObject);
          }
        }
      }
      paramInt1 += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      int i = 0;
      while (i < bbji.a(this.jdField_a_of_type_Bbji).size())
      {
        bbjl localbbjl = (bbjl)bbji.a(this.jdField_a_of_type_Bbji).valueAt(i);
        if ((paramMotionEvent.getX() > localbbjl.jdField_a_of_type_ArrayOfInt[0]) && (paramMotionEvent.getX() < localbbjl.jdField_a_of_type_ArrayOfInt[0] + localbbjl.jdField_a_of_type_AndroidViewView.getMeasuredWidth()) && (paramMotionEvent.getY() > localbbjl.jdField_a_of_type_ArrayOfInt[1]) && (paramMotionEvent.getY() < localbbjl.jdField_a_of_type_ArrayOfInt[1] + localbbjl.jdField_a_of_type_AndroidViewView.getMeasuredHeight()) && (localbbjl.jdField_a_of_type_AndroidViewView$OnClickListener != null))
        {
          this.jdField_a_of_type_Bbji.a.dismiss();
          localbbjl.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(localbbjl.jdField_a_of_type_AndroidViewView);
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbjm
 * JD-Core Version:    0.7.0.1
 */