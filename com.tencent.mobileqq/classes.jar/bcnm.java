import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class bcnm
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final List<bcnn> jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private int b = 200;
  
  public bcnm(View paramView)
  {
    this(paramView, false);
  }
  
  public bcnm(View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Boolean = paramBoolean;
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(this);
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bcnn localbcnn = (bcnn)localIterator.next();
      if (localbcnn != null) {
        localbcnn.onSoftKeyboardOpened(paramInt);
      }
    }
  }
  
  private void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bcnn localbcnn = (bcnn)localIterator.next();
      if (localbcnn != null) {
        localbcnn.onSoftKeyboardClosed();
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
  
  public void a(bcnn parambcnn)
  {
    this.jdField_a_of_type_JavaUtilList.add(parambcnn);
  }
  
  public void b(bcnn parambcnn)
  {
    this.jdField_a_of_type_JavaUtilList.remove(parambcnn);
  }
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidViewView.getWindowVisibleDisplayFrame(localRect);
    int i = this.jdField_a_of_type_AndroidViewView.getRootView().getHeight() - (localRect.bottom - localRect.top) - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidViewView.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("SoftKeyboardStateHelper", 2, "onGlobalLayout , activityRootView.Height = " + this.jdField_a_of_type_AndroidViewView.getRootView().getHeight() + " heightDiff = " + i + " (r.bottom - r.top) = " + (localRect.bottom - localRect.top));
    }
    if ((!this.jdField_a_of_type_Boolean) && (i > this.b))
    {
      this.jdField_a_of_type_Boolean = true;
      a(i);
    }
    while ((!this.jdField_a_of_type_Boolean) || (i >= this.b)) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcnm
 * JD-Core Version:    0.7.0.1
 */