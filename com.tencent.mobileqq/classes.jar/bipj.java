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

class bipj
  extends FrameLayout
{
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  int[] jdField_a_of_type_ArrayOfInt = new int[2];
  
  public bipj(bipf parambipf, Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
  }
  
  private FrameLayout.LayoutParams a(bipi parambipi, biph parambiph)
  {
    if (parambiph.width == -9) {
      parambiph.width = (parambipi.jdField_a_of_type_AndroidViewView.getMeasuredWidth() + -parambiph.a * 2);
    }
    if (parambiph.height == -9) {
      parambiph.height = (parambipi.jdField_a_of_type_AndroidViewView.getMeasuredHeight() + -parambiph.b * 2);
    }
    if (parambiph.a != 2147483647)
    {
      parambiph.gravity |= 0x3;
      parambiph.leftMargin = (parambipi.jdField_a_of_type_ArrayOfInt[0] + parambiph.a - this.jdField_a_of_type_ArrayOfInt[0]);
    }
    if (parambiph.b != 2147483647)
    {
      parambiph.gravity |= 0x30;
      parambiph.topMargin = (parambipi.jdField_a_of_type_ArrayOfInt[1] + parambiph.b - this.jdField_a_of_type_ArrayOfInt[1]);
    }
    return parambiph;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    try
    {
      getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      int i = 0;
      while (i < bipf.a(this.jdField_a_of_type_Bipf).size())
      {
        bipi localbipi = (bipi)bipf.a(this.jdField_a_of_type_Bipf).valueAt(i);
        if (localbipi.jdField_a_of_type_ArrayOfInt == null)
        {
          localbipi.jdField_a_of_type_ArrayOfInt = new int[2];
          localbipi.jdField_a_of_type_AndroidViewView.getLocationOnScreen(localbipi.jdField_a_of_type_ArrayOfInt);
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
    while (i < bipf.a(this.jdField_a_of_type_Bipf).size())
    {
      bipi localbipi = (bipi)bipf.a(this.jdField_a_of_type_Bipf).valueAt(i);
      int j = paramCanvas.save();
      this.jdField_a_of_type_AndroidGraphicsRectF.set(localbipi.jdField_a_of_type_ArrayOfInt[0], localbipi.jdField_a_of_type_ArrayOfInt[1], localbipi.jdField_a_of_type_ArrayOfInt[0] + localbipi.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), localbipi.jdField_a_of_type_ArrayOfInt[1] + localbipi.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
      this.jdField_a_of_type_AndroidGraphicsRectF.offset(-this.jdField_a_of_type_ArrayOfInt[0], -this.jdField_a_of_type_ArrayOfInt[1]);
      paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRectF);
      localbipi.jdField_a_of_type_AndroidViewView.getRootView().draw(paramCanvas);
      paramCanvas.restoreToCount(j);
      i += 1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = 0;
    while (paramInt1 < bipf.a(this.jdField_a_of_type_Bipf).size())
    {
      bipi localbipi = (bipi)bipf.a(this.jdField_a_of_type_Bipf).valueAt(paramInt1);
      Iterator localIterator = localbipi.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (indexOfChild((View)localPair.first) == -1)
        {
          Object localObject = ((View)localPair.first).getLayoutParams();
          if (localPair.second != null) {
            localObject = a(localbipi, (biph)localPair.second);
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
      while (i < bipf.a(this.jdField_a_of_type_Bipf).size())
      {
        bipi localbipi = (bipi)bipf.a(this.jdField_a_of_type_Bipf).valueAt(i);
        if ((paramMotionEvent.getX() > localbipi.jdField_a_of_type_ArrayOfInt[0]) && (paramMotionEvent.getX() < localbipi.jdField_a_of_type_ArrayOfInt[0] + localbipi.jdField_a_of_type_AndroidViewView.getMeasuredWidth()) && (paramMotionEvent.getY() > localbipi.jdField_a_of_type_ArrayOfInt[1]) && (paramMotionEvent.getY() < localbipi.jdField_a_of_type_ArrayOfInt[1] + localbipi.jdField_a_of_type_AndroidViewView.getMeasuredHeight()) && (localbipi.jdField_a_of_type_AndroidViewView$OnClickListener != null))
        {
          this.jdField_a_of_type_Bipf.a.dismiss();
          localbipi.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(localbipi.jdField_a_of_type_AndroidViewView);
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bipj
 * JD-Core Version:    0.7.0.1
 */