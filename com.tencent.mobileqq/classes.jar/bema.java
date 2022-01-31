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

class bema
  extends FrameLayout
{
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  int[] jdField_a_of_type_ArrayOfInt = new int[2];
  
  public bema(belw parambelw, Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
  }
  
  private FrameLayout.LayoutParams a(belz parambelz, bely parambely)
  {
    if (parambely.width == -9) {
      parambely.width = (parambelz.jdField_a_of_type_AndroidViewView.getMeasuredWidth() + -parambely.a * 2);
    }
    if (parambely.height == -9) {
      parambely.height = (parambelz.jdField_a_of_type_AndroidViewView.getMeasuredHeight() + -parambely.b * 2);
    }
    if (parambely.a != 2147483647)
    {
      parambely.gravity |= 0x3;
      parambely.leftMargin = (parambelz.jdField_a_of_type_ArrayOfInt[0] + parambely.a - this.jdField_a_of_type_ArrayOfInt[0]);
    }
    if (parambely.b != 2147483647)
    {
      parambely.gravity |= 0x30;
      parambely.topMargin = (parambelz.jdField_a_of_type_ArrayOfInt[1] + parambely.b - this.jdField_a_of_type_ArrayOfInt[1]);
    }
    return parambely;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    try
    {
      getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      int i = 0;
      while (i < belw.a(this.jdField_a_of_type_Belw).size())
      {
        belz localbelz = (belz)belw.a(this.jdField_a_of_type_Belw).valueAt(i);
        if (localbelz.jdField_a_of_type_ArrayOfInt == null)
        {
          localbelz.jdField_a_of_type_ArrayOfInt = new int[2];
          localbelz.jdField_a_of_type_AndroidViewView.getLocationOnScreen(localbelz.jdField_a_of_type_ArrayOfInt);
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
    while (i < belw.a(this.jdField_a_of_type_Belw).size())
    {
      belz localbelz = (belz)belw.a(this.jdField_a_of_type_Belw).valueAt(i);
      int j = paramCanvas.save();
      this.jdField_a_of_type_AndroidGraphicsRectF.set(localbelz.jdField_a_of_type_ArrayOfInt[0], localbelz.jdField_a_of_type_ArrayOfInt[1], localbelz.jdField_a_of_type_ArrayOfInt[0] + localbelz.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), localbelz.jdField_a_of_type_ArrayOfInt[1] + localbelz.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
      this.jdField_a_of_type_AndroidGraphicsRectF.offset(-this.jdField_a_of_type_ArrayOfInt[0], -this.jdField_a_of_type_ArrayOfInt[1]);
      paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRectF);
      localbelz.jdField_a_of_type_AndroidViewView.getRootView().draw(paramCanvas);
      paramCanvas.restoreToCount(j);
      i += 1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = 0;
    while (paramInt1 < belw.a(this.jdField_a_of_type_Belw).size())
    {
      belz localbelz = (belz)belw.a(this.jdField_a_of_type_Belw).valueAt(paramInt1);
      Iterator localIterator = localbelz.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (indexOfChild((View)localPair.first) == -1)
        {
          Object localObject = ((View)localPair.first).getLayoutParams();
          if (localPair.second != null) {
            localObject = a(localbelz, (bely)localPair.second);
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
      while (i < belw.a(this.jdField_a_of_type_Belw).size())
      {
        belz localbelz = (belz)belw.a(this.jdField_a_of_type_Belw).valueAt(i);
        if ((paramMotionEvent.getX() > localbelz.jdField_a_of_type_ArrayOfInt[0]) && (paramMotionEvent.getX() < localbelz.jdField_a_of_type_ArrayOfInt[0] + localbelz.jdField_a_of_type_AndroidViewView.getMeasuredWidth()) && (paramMotionEvent.getY() > localbelz.jdField_a_of_type_ArrayOfInt[1]) && (paramMotionEvent.getY() < localbelz.jdField_a_of_type_ArrayOfInt[1] + localbelz.jdField_a_of_type_AndroidViewView.getMeasuredHeight()) && (localbelz.jdField_a_of_type_AndroidViewView$OnClickListener != null))
        {
          this.jdField_a_of_type_Belw.a.dismiss();
          localbelz.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(localbelz.jdField_a_of_type_AndroidViewView);
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bema
 * JD-Core Version:    0.7.0.1
 */