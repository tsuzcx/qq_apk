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

class bcmy
  extends FrameLayout
{
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  int[] jdField_a_of_type_ArrayOfInt = new int[2];
  
  public bcmy(bcmu parambcmu, Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
  }
  
  private FrameLayout.LayoutParams a(bcmx parambcmx, bcmw parambcmw)
  {
    if (parambcmw.width == -9) {
      parambcmw.width = (parambcmx.jdField_a_of_type_AndroidViewView.getMeasuredWidth() + -parambcmw.a * 2);
    }
    if (parambcmw.height == -9) {
      parambcmw.height = (parambcmx.jdField_a_of_type_AndroidViewView.getMeasuredHeight() + -parambcmw.b * 2);
    }
    if (parambcmw.a != 2147483647)
    {
      parambcmw.gravity |= 0x3;
      parambcmw.leftMargin = (parambcmx.jdField_a_of_type_ArrayOfInt[0] + parambcmw.a - this.jdField_a_of_type_ArrayOfInt[0]);
    }
    if (parambcmw.b != 2147483647)
    {
      parambcmw.gravity |= 0x30;
      parambcmw.topMargin = (parambcmx.jdField_a_of_type_ArrayOfInt[1] + parambcmw.b - this.jdField_a_of_type_ArrayOfInt[1]);
    }
    return parambcmw;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    try
    {
      getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      int i = 0;
      while (i < bcmu.a(this.jdField_a_of_type_Bcmu).size())
      {
        bcmx localbcmx = (bcmx)bcmu.a(this.jdField_a_of_type_Bcmu).valueAt(i);
        if (localbcmx.jdField_a_of_type_ArrayOfInt == null)
        {
          localbcmx.jdField_a_of_type_ArrayOfInt = new int[2];
          localbcmx.jdField_a_of_type_AndroidViewView.getLocationOnScreen(localbcmx.jdField_a_of_type_ArrayOfInt);
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
    while (i < bcmu.a(this.jdField_a_of_type_Bcmu).size())
    {
      bcmx localbcmx = (bcmx)bcmu.a(this.jdField_a_of_type_Bcmu).valueAt(i);
      int j = paramCanvas.save();
      this.jdField_a_of_type_AndroidGraphicsRectF.set(localbcmx.jdField_a_of_type_ArrayOfInt[0], localbcmx.jdField_a_of_type_ArrayOfInt[1], localbcmx.jdField_a_of_type_ArrayOfInt[0] + localbcmx.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), localbcmx.jdField_a_of_type_ArrayOfInt[1] + localbcmx.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
      this.jdField_a_of_type_AndroidGraphicsRectF.offset(-this.jdField_a_of_type_ArrayOfInt[0], -this.jdField_a_of_type_ArrayOfInt[1]);
      paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRectF);
      localbcmx.jdField_a_of_type_AndroidViewView.getRootView().draw(paramCanvas);
      paramCanvas.restoreToCount(j);
      i += 1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = 0;
    while (paramInt1 < bcmu.a(this.jdField_a_of_type_Bcmu).size())
    {
      bcmx localbcmx = (bcmx)bcmu.a(this.jdField_a_of_type_Bcmu).valueAt(paramInt1);
      Iterator localIterator = localbcmx.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (indexOfChild((View)localPair.first) == -1)
        {
          Object localObject = ((View)localPair.first).getLayoutParams();
          if (localPair.second != null) {
            localObject = a(localbcmx, (bcmw)localPair.second);
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
      while (i < bcmu.a(this.jdField_a_of_type_Bcmu).size())
      {
        bcmx localbcmx = (bcmx)bcmu.a(this.jdField_a_of_type_Bcmu).valueAt(i);
        if ((paramMotionEvent.getX() > localbcmx.jdField_a_of_type_ArrayOfInt[0]) && (paramMotionEvent.getX() < localbcmx.jdField_a_of_type_ArrayOfInt[0] + localbcmx.jdField_a_of_type_AndroidViewView.getMeasuredWidth()) && (paramMotionEvent.getY() > localbcmx.jdField_a_of_type_ArrayOfInt[1]) && (paramMotionEvent.getY() < localbcmx.jdField_a_of_type_ArrayOfInt[1] + localbcmx.jdField_a_of_type_AndroidViewView.getMeasuredHeight()) && (localbcmx.jdField_a_of_type_AndroidViewView$OnClickListener != null))
        {
          this.jdField_a_of_type_Bcmu.a.dismiss();
          localbcmx.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(localbcmx.jdField_a_of_type_AndroidViewView);
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcmy
 * JD-Core Version:    0.7.0.1
 */