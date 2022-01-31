import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class bglm
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final List<bgln> jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private int b = 200;
  
  public bglm(View paramView)
  {
    this(paramView, false);
  }
  
  public bglm(View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Boolean = paramBoolean;
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(this);
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bgln localbgln = (bgln)localIterator.next();
      if (localbgln != null) {
        localbgln.onSoftKeyboardClosed();
      }
    }
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bgln localbgln = (bgln)localIterator.next();
      if (localbgln != null) {
        localbgln.onSoftKeyboardOpened(paramInt);
      }
    }
  }
  
  public void a(bgln parambgln)
  {
    this.jdField_a_of_type_JavaUtilList.add(parambgln);
  }
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidViewView.getWindowVisibleDisplayFrame(localRect);
    int i = this.jdField_a_of_type_AndroidViewView.getRootView().getHeight() - (localRect.bottom - localRect.top) - DisplayUtil.getStatusBarHeight(this.jdField_a_of_type_AndroidViewView.getContext());
    QMLog.d("SoftKeyboardStateHelper", "onGlobalLayout , activityRootView.Height = " + this.jdField_a_of_type_AndroidViewView.getRootView().getHeight() + " heightDiff = " + i + " (r.bottom - r.top) = " + (localRect.bottom - localRect.top));
    if ((!this.jdField_a_of_type_Boolean) && (i > this.b))
    {
      this.jdField_a_of_type_Boolean = true;
      a(i);
    }
    while ((!this.jdField_a_of_type_Boolean) || (i >= this.b)) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bglm
 * JD-Core Version:    0.7.0.1
 */