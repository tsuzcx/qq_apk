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

class bher
  extends FrameLayout
{
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  int[] jdField_a_of_type_ArrayOfInt = new int[2];
  
  public bher(bhen parambhen, Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
  }
  
  private FrameLayout.LayoutParams a(bheq parambheq, bhep parambhep)
  {
    if (parambhep.width == -9) {
      parambhep.width = (parambheq.jdField_a_of_type_AndroidViewView.getMeasuredWidth() + -parambhep.a * 2);
    }
    if (parambhep.height == -9) {
      parambhep.height = (parambheq.jdField_a_of_type_AndroidViewView.getMeasuredHeight() + -parambhep.b * 2);
    }
    if (parambhep.a != 2147483647)
    {
      parambhep.gravity |= 0x3;
      parambhep.leftMargin = (parambheq.jdField_a_of_type_ArrayOfInt[0] + parambhep.a - this.jdField_a_of_type_ArrayOfInt[0]);
    }
    if (parambhep.b != 2147483647)
    {
      parambhep.gravity |= 0x30;
      parambhep.topMargin = (parambheq.jdField_a_of_type_ArrayOfInt[1] + parambhep.b - this.jdField_a_of_type_ArrayOfInt[1]);
    }
    return parambhep;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    try
    {
      getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      int i = 0;
      while (i < bhen.a(this.jdField_a_of_type_Bhen).size())
      {
        bheq localbheq = (bheq)bhen.a(this.jdField_a_of_type_Bhen).valueAt(i);
        if (localbheq.jdField_a_of_type_ArrayOfInt == null)
        {
          localbheq.jdField_a_of_type_ArrayOfInt = new int[2];
          localbheq.jdField_a_of_type_AndroidViewView.getLocationOnScreen(localbheq.jdField_a_of_type_ArrayOfInt);
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
    while (i < bhen.a(this.jdField_a_of_type_Bhen).size())
    {
      bheq localbheq = (bheq)bhen.a(this.jdField_a_of_type_Bhen).valueAt(i);
      int j = paramCanvas.save();
      this.jdField_a_of_type_AndroidGraphicsRectF.set(localbheq.jdField_a_of_type_ArrayOfInt[0], localbheq.jdField_a_of_type_ArrayOfInt[1], localbheq.jdField_a_of_type_ArrayOfInt[0] + localbheq.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), localbheq.jdField_a_of_type_ArrayOfInt[1] + localbheq.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
      this.jdField_a_of_type_AndroidGraphicsRectF.offset(-this.jdField_a_of_type_ArrayOfInt[0], -this.jdField_a_of_type_ArrayOfInt[1]);
      paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRectF);
      localbheq.jdField_a_of_type_AndroidViewView.getRootView().draw(paramCanvas);
      paramCanvas.restoreToCount(j);
      i += 1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = 0;
    while (paramInt1 < bhen.a(this.jdField_a_of_type_Bhen).size())
    {
      bheq localbheq = (bheq)bhen.a(this.jdField_a_of_type_Bhen).valueAt(paramInt1);
      Iterator localIterator = localbheq.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (indexOfChild((View)localPair.first) == -1)
        {
          Object localObject = ((View)localPair.first).getLayoutParams();
          if (localPair.second != null) {
            localObject = a(localbheq, (bhep)localPair.second);
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
      while (i < bhen.a(this.jdField_a_of_type_Bhen).size())
      {
        bheq localbheq = (bheq)bhen.a(this.jdField_a_of_type_Bhen).valueAt(i);
        if ((paramMotionEvent.getX() > localbheq.jdField_a_of_type_ArrayOfInt[0]) && (paramMotionEvent.getX() < localbheq.jdField_a_of_type_ArrayOfInt[0] + localbheq.jdField_a_of_type_AndroidViewView.getMeasuredWidth()) && (paramMotionEvent.getY() > localbheq.jdField_a_of_type_ArrayOfInt[1]) && (paramMotionEvent.getY() < localbheq.jdField_a_of_type_ArrayOfInt[1] + localbheq.jdField_a_of_type_AndroidViewView.getMeasuredHeight()) && (localbheq.jdField_a_of_type_AndroidViewView$OnClickListener != null))
        {
          this.jdField_a_of_type_Bhen.a.dismiss();
          localbheq.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(localbheq.jdField_a_of_type_AndroidViewView);
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bher
 * JD-Core Version:    0.7.0.1
 */