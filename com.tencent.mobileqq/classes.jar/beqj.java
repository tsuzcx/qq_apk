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

class beqj
  extends FrameLayout
{
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  int[] jdField_a_of_type_ArrayOfInt = new int[2];
  
  public beqj(beqf parambeqf, Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
  }
  
  private FrameLayout.LayoutParams a(beqi parambeqi, beqh parambeqh)
  {
    if (parambeqh.width == -9) {
      parambeqh.width = (parambeqi.jdField_a_of_type_AndroidViewView.getMeasuredWidth() + -parambeqh.a * 2);
    }
    if (parambeqh.height == -9) {
      parambeqh.height = (parambeqi.jdField_a_of_type_AndroidViewView.getMeasuredHeight() + -parambeqh.b * 2);
    }
    if (parambeqh.a != 2147483647)
    {
      parambeqh.gravity |= 0x3;
      parambeqh.leftMargin = (parambeqi.jdField_a_of_type_ArrayOfInt[0] + parambeqh.a - this.jdField_a_of_type_ArrayOfInt[0]);
    }
    if (parambeqh.b != 2147483647)
    {
      parambeqh.gravity |= 0x30;
      parambeqh.topMargin = (parambeqi.jdField_a_of_type_ArrayOfInt[1] + parambeqh.b - this.jdField_a_of_type_ArrayOfInt[1]);
    }
    return parambeqh;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    try
    {
      getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      int i = 0;
      while (i < beqf.a(this.jdField_a_of_type_Beqf).size())
      {
        beqi localbeqi = (beqi)beqf.a(this.jdField_a_of_type_Beqf).valueAt(i);
        if (localbeqi.jdField_a_of_type_ArrayOfInt == null)
        {
          localbeqi.jdField_a_of_type_ArrayOfInt = new int[2];
          localbeqi.jdField_a_of_type_AndroidViewView.getLocationOnScreen(localbeqi.jdField_a_of_type_ArrayOfInt);
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
    while (i < beqf.a(this.jdField_a_of_type_Beqf).size())
    {
      beqi localbeqi = (beqi)beqf.a(this.jdField_a_of_type_Beqf).valueAt(i);
      int j = paramCanvas.save();
      this.jdField_a_of_type_AndroidGraphicsRectF.set(localbeqi.jdField_a_of_type_ArrayOfInt[0], localbeqi.jdField_a_of_type_ArrayOfInt[1], localbeqi.jdField_a_of_type_ArrayOfInt[0] + localbeqi.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), localbeqi.jdField_a_of_type_ArrayOfInt[1] + localbeqi.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
      this.jdField_a_of_type_AndroidGraphicsRectF.offset(-this.jdField_a_of_type_ArrayOfInt[0], -this.jdField_a_of_type_ArrayOfInt[1]);
      paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRectF);
      localbeqi.jdField_a_of_type_AndroidViewView.getRootView().draw(paramCanvas);
      paramCanvas.restoreToCount(j);
      i += 1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = 0;
    while (paramInt1 < beqf.a(this.jdField_a_of_type_Beqf).size())
    {
      beqi localbeqi = (beqi)beqf.a(this.jdField_a_of_type_Beqf).valueAt(paramInt1);
      Iterator localIterator = localbeqi.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (indexOfChild((View)localPair.first) == -1)
        {
          Object localObject = ((View)localPair.first).getLayoutParams();
          if (localPair.second != null) {
            localObject = a(localbeqi, (beqh)localPair.second);
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
      while (i < beqf.a(this.jdField_a_of_type_Beqf).size())
      {
        beqi localbeqi = (beqi)beqf.a(this.jdField_a_of_type_Beqf).valueAt(i);
        if ((paramMotionEvent.getX() > localbeqi.jdField_a_of_type_ArrayOfInt[0]) && (paramMotionEvent.getX() < localbeqi.jdField_a_of_type_ArrayOfInt[0] + localbeqi.jdField_a_of_type_AndroidViewView.getMeasuredWidth()) && (paramMotionEvent.getY() > localbeqi.jdField_a_of_type_ArrayOfInt[1]) && (paramMotionEvent.getY() < localbeqi.jdField_a_of_type_ArrayOfInt[1] + localbeqi.jdField_a_of_type_AndroidViewView.getMeasuredHeight()) && (localbeqi.jdField_a_of_type_AndroidViewView$OnClickListener != null))
        {
          this.jdField_a_of_type_Beqf.a.dismiss();
          localbeqi.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(localbeqi.jdField_a_of_type_AndroidViewView);
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beqj
 * JD-Core Version:    0.7.0.1
 */