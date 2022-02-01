import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.CustomedTabWidget;
import java.lang.ref.WeakReference;

public class bhvz
  extends Handler
{
  private WeakReference<CustomedTabWidget> a;
  
  public bhvz(CustomedTabWidget paramCustomedTabWidget)
  {
    this.a = new WeakReference(paramCustomedTabWidget);
  }
  
  public void handleMessage(Message arg1)
  {
    CustomedTabWidget localCustomedTabWidget = (CustomedTabWidget)this.a.get();
    if (localCustomedTabWidget == null) {
      return;
    }
    if (localCustomedTabWidget.jdField_a_of_type_Float < 0.0F) {
      localCustomedTabWidget.invalidate((int)(localCustomedTabWidget.b.left + localCustomedTabWidget.jdField_a_of_type_Float), localCustomedTabWidget.b.top, localCustomedTabWidget.b.right, localCustomedTabWidget.b.bottom);
    }
    synchronized (localCustomedTabWidget.jdField_a_of_type_Bhvz)
    {
      Rect localRect = localCustomedTabWidget.b;
      localRect.left = ((int)(localRect.left + localCustomedTabWidget.jdField_a_of_type_Float));
      localRect = localCustomedTabWidget.b;
      localRect.right = ((int)(localRect.right + localCustomedTabWidget.jdField_a_of_type_Float));
      if ((localCustomedTabWidget.jdField_a_of_type_AndroidGraphicsRect.left - localCustomedTabWidget.b.left) / localCustomedTabWidget.jdField_a_of_type_Float >= 1.0F)
      {
        sendEmptyMessage(0);
        return;
        localCustomedTabWidget.invalidate(localCustomedTabWidget.b.left, localCustomedTabWidget.b.top, (int)(localCustomedTabWidget.b.right + localCustomedTabWidget.jdField_a_of_type_Float), localCustomedTabWidget.b.bottom);
      }
    }
    localObject.b.set(localObject.jdField_a_of_type_AndroidGraphicsRect.left, localObject.jdField_a_of_type_AndroidGraphicsRect.top, localObject.jdField_a_of_type_AndroidGraphicsRect.right, localObject.jdField_a_of_type_AndroidGraphicsRect.bottom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhvz
 * JD-Core Version:    0.7.0.1
 */