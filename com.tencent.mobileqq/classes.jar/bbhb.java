import android.view.MotionEvent;
import android.view.View;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import dov.com.qq.im.ae.camera.ui.panel.AbsBottomPanal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bbhb
  implements GLGestureListener
{
  protected View a;
  private bbhc a;
  protected List<AbsBottomPanal> a;
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(bbhc parambbhc)
  {
    this.jdField_a_of_type_Bbhc = parambbhc;
  }
  
  public void a(AbsBottomPanal paramAbsBottomPanal)
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(paramAbsBottomPanal);
    }
    while (this.jdField_a_of_type_JavaUtilList.contains(paramAbsBottomPanal)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramAbsBottomPanal);
  }
  
  public int onGetPriority()
  {
    return 1060;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getAction();
    if ((i == 1) && (!paramBoolean)) {}
    switch (j & 0xFF)
    {
    default: 
      return false;
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {}
    for (Object localObject = this.jdField_a_of_type_AndroidViewView;; localObject = GLGestureProxy.getInstance().getGLSurfaceView())
    {
      if (this.jdField_a_of_type_Bbhc != null) {
        this.jdField_a_of_type_Bbhc.a();
      }
      if (this.jdField_a_of_type_JavaUtilList == null) {
        break;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        AbsBottomPanal localAbsBottomPanal = (AbsBottomPanal)localIterator.next();
        if ((localObject != null) && (localAbsBottomPanal != null) && (paramMotionEvent.getY() < ((View)localObject).getHeight() - localAbsBottomPanal.getHeight()) && (!localAbsBottomPanal.b())) {
          localAbsBottomPanal.d();
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbhb
 * JD-Core Version:    0.7.0.1
 */