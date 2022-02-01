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

class biyp
  extends FrameLayout
{
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  int[] jdField_a_of_type_ArrayOfInt = new int[2];
  
  public biyp(biyl parambiyl, Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
  }
  
  private FrameLayout.LayoutParams a(biyo parambiyo, biyn parambiyn)
  {
    if (parambiyn.width == -9) {
      parambiyn.width = (parambiyo.jdField_a_of_type_AndroidViewView.getMeasuredWidth() + -parambiyn.a * 2);
    }
    if (parambiyn.height == -9) {
      parambiyn.height = (parambiyo.jdField_a_of_type_AndroidViewView.getMeasuredHeight() + -parambiyn.b * 2);
    }
    if (parambiyn.a != 2147483647)
    {
      parambiyn.gravity |= 0x3;
      parambiyn.leftMargin = (parambiyo.jdField_a_of_type_ArrayOfInt[0] + parambiyn.a - this.jdField_a_of_type_ArrayOfInt[0]);
    }
    if (parambiyn.b != 2147483647)
    {
      parambiyn.gravity |= 0x30;
      parambiyn.topMargin = (parambiyo.jdField_a_of_type_ArrayOfInt[1] + parambiyn.b - this.jdField_a_of_type_ArrayOfInt[1]);
    }
    return parambiyn;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    try
    {
      getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      int i = 0;
      while (i < biyl.a(this.jdField_a_of_type_Biyl).size())
      {
        biyo localbiyo = (biyo)biyl.a(this.jdField_a_of_type_Biyl).valueAt(i);
        if (localbiyo.jdField_a_of_type_ArrayOfInt == null)
        {
          localbiyo.jdField_a_of_type_ArrayOfInt = new int[2];
          localbiyo.jdField_a_of_type_AndroidViewView.getLocationOnScreen(localbiyo.jdField_a_of_type_ArrayOfInt);
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
    while (i < biyl.a(this.jdField_a_of_type_Biyl).size())
    {
      biyo localbiyo = (biyo)biyl.a(this.jdField_a_of_type_Biyl).valueAt(i);
      int j = paramCanvas.save();
      this.jdField_a_of_type_AndroidGraphicsRectF.set(localbiyo.jdField_a_of_type_ArrayOfInt[0], localbiyo.jdField_a_of_type_ArrayOfInt[1], localbiyo.jdField_a_of_type_ArrayOfInt[0] + localbiyo.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), localbiyo.jdField_a_of_type_ArrayOfInt[1] + localbiyo.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
      this.jdField_a_of_type_AndroidGraphicsRectF.offset(-this.jdField_a_of_type_ArrayOfInt[0], -this.jdField_a_of_type_ArrayOfInt[1]);
      paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRectF);
      localbiyo.jdField_a_of_type_AndroidViewView.getRootView().draw(paramCanvas);
      paramCanvas.restoreToCount(j);
      i += 1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = 0;
    while (paramInt1 < biyl.a(this.jdField_a_of_type_Biyl).size())
    {
      biyo localbiyo = (biyo)biyl.a(this.jdField_a_of_type_Biyl).valueAt(paramInt1);
      Iterator localIterator = localbiyo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (indexOfChild((View)localPair.first) == -1)
        {
          Object localObject = ((View)localPair.first).getLayoutParams();
          if (localPair.second != null) {
            localObject = a(localbiyo, (biyn)localPair.second);
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
      while (i < biyl.a(this.jdField_a_of_type_Biyl).size())
      {
        biyo localbiyo = (biyo)biyl.a(this.jdField_a_of_type_Biyl).valueAt(i);
        if ((paramMotionEvent.getX() > localbiyo.jdField_a_of_type_ArrayOfInt[0]) && (paramMotionEvent.getX() < localbiyo.jdField_a_of_type_ArrayOfInt[0] + localbiyo.jdField_a_of_type_AndroidViewView.getMeasuredWidth()) && (paramMotionEvent.getY() > localbiyo.jdField_a_of_type_ArrayOfInt[1]) && (paramMotionEvent.getY() < localbiyo.jdField_a_of_type_ArrayOfInt[1] + localbiyo.jdField_a_of_type_AndroidViewView.getMeasuredHeight()) && (localbiyo.jdField_a_of_type_AndroidViewView$OnClickListener != null))
        {
          this.jdField_a_of_type_Biyl.a.dismiss();
          localbiyo.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(localbiyo.jdField_a_of_type_AndroidViewView);
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biyp
 * JD-Core Version:    0.7.0.1
 */