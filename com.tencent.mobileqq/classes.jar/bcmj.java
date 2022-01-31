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

class bcmj
  extends FrameLayout
{
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  int[] jdField_a_of_type_ArrayOfInt = new int[2];
  
  public bcmj(bcmf parambcmf, Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
  }
  
  private FrameLayout.LayoutParams a(bcmi parambcmi, bcmh parambcmh)
  {
    if (parambcmh.width == -9) {
      parambcmh.width = (parambcmi.jdField_a_of_type_AndroidViewView.getMeasuredWidth() + -parambcmh.a * 2);
    }
    if (parambcmh.height == -9) {
      parambcmh.height = (parambcmi.jdField_a_of_type_AndroidViewView.getMeasuredHeight() + -parambcmh.b * 2);
    }
    if (parambcmh.a != 2147483647)
    {
      parambcmh.gravity |= 0x3;
      parambcmh.leftMargin = (parambcmi.jdField_a_of_type_ArrayOfInt[0] + parambcmh.a - this.jdField_a_of_type_ArrayOfInt[0]);
    }
    if (parambcmh.b != 2147483647)
    {
      parambcmh.gravity |= 0x30;
      parambcmh.topMargin = (parambcmi.jdField_a_of_type_ArrayOfInt[1] + parambcmh.b - this.jdField_a_of_type_ArrayOfInt[1]);
    }
    return parambcmh;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    try
    {
      getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      int i = 0;
      while (i < bcmf.a(this.jdField_a_of_type_Bcmf).size())
      {
        bcmi localbcmi = (bcmi)bcmf.a(this.jdField_a_of_type_Bcmf).valueAt(i);
        if (localbcmi.jdField_a_of_type_ArrayOfInt == null)
        {
          localbcmi.jdField_a_of_type_ArrayOfInt = new int[2];
          localbcmi.jdField_a_of_type_AndroidViewView.getLocationOnScreen(localbcmi.jdField_a_of_type_ArrayOfInt);
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
    while (i < bcmf.a(this.jdField_a_of_type_Bcmf).size())
    {
      bcmi localbcmi = (bcmi)bcmf.a(this.jdField_a_of_type_Bcmf).valueAt(i);
      int j = paramCanvas.save();
      this.jdField_a_of_type_AndroidGraphicsRectF.set(localbcmi.jdField_a_of_type_ArrayOfInt[0], localbcmi.jdField_a_of_type_ArrayOfInt[1], localbcmi.jdField_a_of_type_ArrayOfInt[0] + localbcmi.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), localbcmi.jdField_a_of_type_ArrayOfInt[1] + localbcmi.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
      this.jdField_a_of_type_AndroidGraphicsRectF.offset(-this.jdField_a_of_type_ArrayOfInt[0], -this.jdField_a_of_type_ArrayOfInt[1]);
      paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRectF);
      localbcmi.jdField_a_of_type_AndroidViewView.getRootView().draw(paramCanvas);
      paramCanvas.restoreToCount(j);
      i += 1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = 0;
    while (paramInt1 < bcmf.a(this.jdField_a_of_type_Bcmf).size())
    {
      bcmi localbcmi = (bcmi)bcmf.a(this.jdField_a_of_type_Bcmf).valueAt(paramInt1);
      Iterator localIterator = localbcmi.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (indexOfChild((View)localPair.first) == -1)
        {
          Object localObject = ((View)localPair.first).getLayoutParams();
          if (localPair.second != null) {
            localObject = a(localbcmi, (bcmh)localPair.second);
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
      while (i < bcmf.a(this.jdField_a_of_type_Bcmf).size())
      {
        bcmi localbcmi = (bcmi)bcmf.a(this.jdField_a_of_type_Bcmf).valueAt(i);
        if ((paramMotionEvent.getX() > localbcmi.jdField_a_of_type_ArrayOfInt[0]) && (paramMotionEvent.getX() < localbcmi.jdField_a_of_type_ArrayOfInt[0] + localbcmi.jdField_a_of_type_AndroidViewView.getMeasuredWidth()) && (paramMotionEvent.getY() > localbcmi.jdField_a_of_type_ArrayOfInt[1]) && (paramMotionEvent.getY() < localbcmi.jdField_a_of_type_ArrayOfInt[1] + localbcmi.jdField_a_of_type_AndroidViewView.getMeasuredHeight()) && (localbcmi.jdField_a_of_type_AndroidViewView$OnClickListener != null))
        {
          this.jdField_a_of_type_Bcmf.a.dismiss();
          localbcmi.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(localbcmi.jdField_a_of_type_AndroidViewView);
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcmj
 * JD-Core Version:    0.7.0.1
 */