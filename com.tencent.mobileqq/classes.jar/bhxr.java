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

class bhxr
  extends FrameLayout
{
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  int[] jdField_a_of_type_ArrayOfInt = new int[2];
  
  public bhxr(bhxn parambhxn, Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
  }
  
  private FrameLayout.LayoutParams a(bhxq parambhxq, bhxp parambhxp)
  {
    if (parambhxp.width == -9) {
      parambhxp.width = (parambhxq.jdField_a_of_type_AndroidViewView.getMeasuredWidth() + -parambhxp.a * 2);
    }
    if (parambhxp.height == -9) {
      parambhxp.height = (parambhxq.jdField_a_of_type_AndroidViewView.getMeasuredHeight() + -parambhxp.b * 2);
    }
    if (parambhxp.a != 2147483647)
    {
      parambhxp.gravity |= 0x3;
      parambhxp.leftMargin = (parambhxq.jdField_a_of_type_ArrayOfInt[0] + parambhxp.a - this.jdField_a_of_type_ArrayOfInt[0]);
    }
    if (parambhxp.b != 2147483647)
    {
      parambhxp.gravity |= 0x30;
      parambhxp.topMargin = (parambhxq.jdField_a_of_type_ArrayOfInt[1] + parambhxp.b - this.jdField_a_of_type_ArrayOfInt[1]);
    }
    return parambhxp;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    try
    {
      getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      int i = 0;
      while (i < bhxn.a(this.jdField_a_of_type_Bhxn).size())
      {
        bhxq localbhxq = (bhxq)bhxn.a(this.jdField_a_of_type_Bhxn).valueAt(i);
        if (localbhxq.jdField_a_of_type_ArrayOfInt == null)
        {
          localbhxq.jdField_a_of_type_ArrayOfInt = new int[2];
          localbhxq.jdField_a_of_type_AndroidViewView.getLocationOnScreen(localbhxq.jdField_a_of_type_ArrayOfInt);
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
    while (i < bhxn.a(this.jdField_a_of_type_Bhxn).size())
    {
      bhxq localbhxq = (bhxq)bhxn.a(this.jdField_a_of_type_Bhxn).valueAt(i);
      int j = paramCanvas.save();
      this.jdField_a_of_type_AndroidGraphicsRectF.set(localbhxq.jdField_a_of_type_ArrayOfInt[0], localbhxq.jdField_a_of_type_ArrayOfInt[1], localbhxq.jdField_a_of_type_ArrayOfInt[0] + localbhxq.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), localbhxq.jdField_a_of_type_ArrayOfInt[1] + localbhxq.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
      this.jdField_a_of_type_AndroidGraphicsRectF.offset(-this.jdField_a_of_type_ArrayOfInt[0], -this.jdField_a_of_type_ArrayOfInt[1]);
      paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRectF);
      localbhxq.jdField_a_of_type_AndroidViewView.getRootView().draw(paramCanvas);
      paramCanvas.restoreToCount(j);
      i += 1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = 0;
    while (paramInt1 < bhxn.a(this.jdField_a_of_type_Bhxn).size())
    {
      bhxq localbhxq = (bhxq)bhxn.a(this.jdField_a_of_type_Bhxn).valueAt(paramInt1);
      Iterator localIterator = localbhxq.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (indexOfChild((View)localPair.first) == -1)
        {
          Object localObject = ((View)localPair.first).getLayoutParams();
          if (localPair.second != null) {
            localObject = a(localbhxq, (bhxp)localPair.second);
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
      while (i < bhxn.a(this.jdField_a_of_type_Bhxn).size())
      {
        bhxq localbhxq = (bhxq)bhxn.a(this.jdField_a_of_type_Bhxn).valueAt(i);
        if ((paramMotionEvent.getX() > localbhxq.jdField_a_of_type_ArrayOfInt[0]) && (paramMotionEvent.getX() < localbhxq.jdField_a_of_type_ArrayOfInt[0] + localbhxq.jdField_a_of_type_AndroidViewView.getMeasuredWidth()) && (paramMotionEvent.getY() > localbhxq.jdField_a_of_type_ArrayOfInt[1]) && (paramMotionEvent.getY() < localbhxq.jdField_a_of_type_ArrayOfInt[1] + localbhxq.jdField_a_of_type_AndroidViewView.getMeasuredHeight()) && (localbhxq.jdField_a_of_type_AndroidViewView$OnClickListener != null))
        {
          this.jdField_a_of_type_Bhxn.a.dismiss();
          localbhxq.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(localbhxq.jdField_a_of_type_AndroidViewView);
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhxr
 * JD-Core Version:    0.7.0.1
 */