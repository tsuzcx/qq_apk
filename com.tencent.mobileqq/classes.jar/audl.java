import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Point;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.ocr.view.gesture.GestureFrameLayout;
import com.tencent.mobileqq.ocr.view.gesture.GestureProxy;
import com.tencent.mobileqq.ocr.view.gesture.Settings;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class audl
  extends auef
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Point jdField_a_of_type_AndroidGraphicsPoint;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private audi jdField_a_of_type_Audi;
  private audk jdField_a_of_type_Audk;
  private audm jdField_a_of_type_Audm;
  private aueb jdField_a_of_type_Aueb;
  private GestureFrameLayout jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout;
  private List<audk> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[2];
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public audl(GestureFrameLayout paramGestureFrameLayout, List<audk> paramList, View.OnClickListener paramOnClickListener, audm paramaudm)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout = paramGestureFrameLayout;
    this.jdField_a_of_type_AndroidContentContext = paramGestureFrameLayout.getContext();
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Audm = paramaudm;
    paramGestureFrameLayout.a().a().a().invert(this.jdField_a_of_type_AndroidGraphicsMatrix);
    this.jdField_a_of_type_Audi = new audi();
    this.jdField_a_of_type_Audi.a(2131364825, this.jdField_a_of_type_AndroidContentContext.getString(2131691303), 2130838597);
    this.jdField_a_of_type_Audi.a(2131366632, this.jdField_a_of_type_AndroidContentContext.getString(2131692752), 2130838606);
    this.jdField_a_of_type_Audi.a(2131377659, this.jdField_a_of_type_AndroidContentContext.getString(2131699254), 2130838606);
    this.jdField_a_of_type_Audi.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    if (aueb.a()) {}
    for (paramGestureFrameLayout = new aueb();; paramGestureFrameLayout = null)
    {
      this.jdField_a_of_type_Aueb = paramGestureFrameLayout;
      return;
    }
  }
  
  public static int a(Point paramPoint1, Point paramPoint2)
  {
    return paramPoint1.x * paramPoint2.x + paramPoint1.y * paramPoint2.y;
  }
  
  public static Point a(Point paramPoint1, Point paramPoint2)
  {
    return new Point(paramPoint2.x - paramPoint1.x, paramPoint2.y - paramPoint1.y);
  }
  
  private void a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    int k;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ArrayOfFloat[0] = paramMotionEvent1.getX();
      this.jdField_a_of_type_ArrayOfFloat[1] = paramMotionEvent1.getY();
      this.jdField_a_of_type_AndroidGraphicsMatrix.mapPoints(this.jdField_a_of_type_ArrayOfFloat);
      i = Math.round(this.jdField_a_of_type_ArrayOfFloat[0]);
      j = Math.round(this.jdField_a_of_type_ArrayOfFloat[1]);
      paramMotionEvent1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramMotionEvent1.hasNext())
      {
        audk localaudk = (audk)paramMotionEvent1.next();
        k = this.jdField_a_of_type_JavaUtilList.indexOf(localaudk);
        if (a(new Point(i, j), localaudk)) {
          a(localaudk, k);
        }
      }
    }
    this.jdField_a_of_type_ArrayOfFloat[0] = paramMotionEvent2.getX();
    this.jdField_a_of_type_ArrayOfFloat[1] = paramMotionEvent2.getY();
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapPoints(this.jdField_a_of_type_ArrayOfFloat);
    int i = Math.round(this.jdField_a_of_type_ArrayOfFloat[0]);
    int j = Math.round(this.jdField_a_of_type_ArrayOfFloat[1]);
    if (this.jdField_a_of_type_AndroidGraphicsPoint != null)
    {
      paramMotionEvent1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramMotionEvent1.hasNext())
      {
        paramMotionEvent2 = (audk)paramMotionEvent1.next();
        k = this.jdField_a_of_type_JavaUtilList.indexOf(paramMotionEvent2);
        if (a(i, j, this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y, paramMotionEvent2)) {
          a(paramMotionEvent2, k);
        }
      }
    }
    this.jdField_a_of_type_AndroidGraphicsPoint = new Point(i, j);
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int i = (paramInt8 - paramInt6) * (paramInt3 - paramInt1) - (paramInt7 - paramInt5) * (paramInt4 - paramInt2);
    float f1 = ((paramInt7 - paramInt5) * (paramInt2 - paramInt6) - (paramInt8 - paramInt6) * (paramInt1 - paramInt5)) / i;
    float f2 = ((paramInt3 - paramInt1) * (paramInt2 - paramInt6) - (paramInt4 - paramInt2) * (paramInt1 - paramInt5)) / i;
    return (f1 >= 0.0F) && (f1 <= 1.0F) && (f2 >= 0.0F) && (f2 <= 1.0F);
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, audk paramaudk)
  {
    Point localPoint1 = (Point)paramaudk.jdField_a_of_type_JavaUtilList.get(0);
    Point localPoint2 = (Point)paramaudk.jdField_a_of_type_JavaUtilList.get(1);
    if (a(paramInt1, paramInt2, paramInt3, paramInt4, localPoint1.x, localPoint1.y, localPoint2.x, localPoint2.y)) {
      return true;
    }
    Point localPoint3 = (Point)paramaudk.jdField_a_of_type_JavaUtilList.get(2);
    paramaudk = (Point)paramaudk.jdField_a_of_type_JavaUtilList.get(3);
    if (a(paramInt1, paramInt2, paramInt3, paramInt4, localPoint3.x, localPoint3.y, paramaudk.x, paramaudk.y)) {
      return true;
    }
    return (a(paramInt1, paramInt2, paramInt3, paramInt4, localPoint2.x, localPoint2.y, localPoint3.x, localPoint3.y)) || (a(paramInt1, paramInt2, paramInt3, paramInt4, paramaudk.x, paramaudk.y, localPoint1.x, localPoint1.y));
  }
  
  private static boolean a(Point paramPoint, audk paramaudk)
  {
    if ((paramPoint.y > paramaudk.e) || (paramPoint.y < paramaudk.g) || (paramPoint.x > paramaudk.d) || (paramPoint.x < paramaudk.f)) {}
    int i;
    do
    {
      Point localPoint1;
      Point localPoint3;
      do
      {
        return false;
        if (paramaudk.jdField_a_of_type_Int % 90 < 1) {
          return true;
        }
        Point localPoint2 = (Point)paramaudk.jdField_a_of_type_JavaUtilList.get(0);
        localPoint1 = (Point)paramaudk.jdField_a_of_type_JavaUtilList.get(1);
        paramaudk = (Point)paramaudk.jdField_a_of_type_JavaUtilList.get(2);
        localPoint3 = a(localPoint2, localPoint1);
        i = a(localPoint3, a(localPoint2, paramPoint));
      } while ((i < 0) || (i > a(localPoint3, localPoint3)));
      paramaudk = a(localPoint1, paramaudk);
      i = a(paramaudk, a(localPoint1, paramPoint));
    } while (i < 0);
    if (i <= a(paramaudk, paramaudk)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean a(MotionEvent paramMotionEvent, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ArrayOfFloat[0] = paramMotionEvent.getX();
    this.jdField_a_of_type_ArrayOfFloat[1] = paramMotionEvent.getY();
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapPoints(this.jdField_a_of_type_ArrayOfFloat);
    int j = Math.round(this.jdField_a_of_type_ArrayOfFloat[0]);
    int k = Math.round(this.jdField_a_of_type_ArrayOfFloat[1]);
    paramMotionEvent = this.jdField_a_of_type_JavaUtilList.iterator();
    boolean bool = false;
    label124:
    int i;
    if (paramMotionEvent.hasNext())
    {
      audk localaudk = (audk)paramMotionEvent.next();
      if (!a(new Point(j, k), localaudk)) {
        break label208;
      }
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        if (!localaudk.jdField_b_of_type_Boolean)
        {
          bool = true;
          localaudk.jdField_b_of_type_Boolean = bool;
          this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout);
          if (!localaudk.jdField_b_of_type_Boolean) {
            break label199;
          }
          i = 1;
          label153:
          auab.a("0X800AAED", i);
        }
      }
      else
      {
        if ((localaudk.jdField_b_of_type_Boolean) && (!paramBoolean2))
        {
          this.jdField_c_of_type_Int = 1;
          if (paramBoolean1) {
            this.jdField_a_of_type_Audk = localaudk;
          }
        }
        bool = true;
      }
    }
    label199:
    label208:
    for (;;)
    {
      break;
      bool = false;
      break label124;
      i = 2;
      break label153;
      return bool;
    }
  }
  
  public void a(Matrix paramMatrix)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.set(paramMatrix);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    int i = 2;
    this.jdField_a_of_type_Audm.a();
    if ((this.jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_Audk != null))
    {
      Object localObject = (Point)this.jdField_a_of_type_Audk.jdField_a_of_type_JavaUtilList.get(0);
      paramMotionEvent = (Point)this.jdField_a_of_type_Audk.jdField_a_of_type_JavaUtilList.get(1);
      Matrix localMatrix = new Matrix();
      this.jdField_a_of_type_AndroidGraphicsMatrix.invert(localMatrix);
      float[] arrayOfFloat = new float[2];
      arrayOfFloat[0] = ((Point)localObject).x;
      arrayOfFloat[1] = ((Point)localObject).y;
      localObject = new float[2];
      localObject[0] = paramMotionEvent.x;
      localObject[1] = paramMotionEvent.y;
      localMatrix.mapPoints(arrayOfFloat);
      localMatrix.mapPoints((float[])localObject);
      int j = (int)(arrayOfFloat[0] + localObject[0]) / 2;
      float f = arrayOfFloat[1];
      int k = (int)(localObject[1] + f) / 2;
      this.jdField_a_of_type_Audi.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout, j, k);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Int = 4;
      if (this.jdField_c_of_type_Int == 1) {
        i = 1;
      }
      axqw.b(null, "dc00898", "", "", "0X800AAEE", "0X800AAEE", i, 0, String.valueOf(this.jdField_a_of_type_Int), "0", "0", "");
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      this.d = false;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 500L);
      this.jdField_a_of_type_AndroidGraphicsPoint = null;
      this.jdField_c_of_type_Int = -1;
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Audk = null;
      this.jdField_a_of_type_Boolean = false;
      return;
      if (this.d)
      {
        this.jdField_b_of_type_Int = 1;
        auab.a("0X800AAF6", 0);
      }
      else if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_b_of_type_Int = 3;
        auab.a("0X800AAF7", 0);
      }
    }
  }
  
  public void a(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_a_of_type_Aueb.a();
    this.d = true;
  }
  
  public void a(audk paramaudk, int paramInt)
  {
    boolean bool = true;
    if (this.jdField_c_of_type_Int == -1)
    {
      if (paramaudk.jdField_b_of_type_Boolean)
      {
        paramInt = 2;
        this.jdField_c_of_type_Int = paramInt;
        this.jdField_b_of_type_Boolean = true;
      }
    }
    else {
      if (this.jdField_c_of_type_Int != 1) {
        break label92;
      }
    }
    for (;;)
    {
      if (bool != paramaudk.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Int += 1;
        paramaudk.jdField_b_of_type_Boolean = bool;
        this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout);
        this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a().a().a(false);
      }
      return;
      paramInt = 1;
      break;
      label92:
      bool = false;
    }
  }
  
  public boolean a()
  {
    return ((OCRPerformFragment)this.jdField_a_of_type_AndroidViewView$OnClickListener).a();
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    this.jdField_b_of_type_Int = 2;
    return super.a(paramMotionEvent);
  }
  
  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (paramMotionEvent2.getPointerCount() >= 2)
    {
      this.jdField_c_of_type_Boolean = true;
      return false;
    }
    if ((this.jdField_c_of_type_Boolean) || ((this.jdField_a_of_type_AndroidGraphicsPoint == null) && (a()) && (!a(paramMotionEvent1, false, true))))
    {
      this.jdField_c_of_type_Boolean = true;
      return false;
    }
    a(paramMotionEvent1, paramMotionEvent2);
    return true;
  }
  
  public boolean a(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_a_of_type_Aueb.a(1);
    this.jdField_a_of_type_Audm.b();
    return super.a(paramScaleGestureDetector);
  }
  
  public void b(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Audi.a();
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a().a().a(true);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    a(paramMotionEvent, false, false);
    this.jdField_b_of_type_Int = 6;
    return true;
  }
  
  public boolean b(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    this.jdField_b_of_type_Int = 7;
    return super.b(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public boolean b(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_a_of_type_Aueb.b();
    return super.b(paramScaleGestureDetector);
  }
  
  public void c(MotionEvent paramMotionEvent)
  {
    a(paramMotionEvent, true, false);
    this.jdField_b_of_type_Int = 5;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    paramMessage = new HashMap();
    paramMessage.put("actType", String.valueOf(this.jdField_b_of_type_Int));
    axrl.a(BaseApplication.getContext()).a(null, "actOcrGestureType", true, 0L, 0L, paramMessage, null);
    QLog.d("OcrScroll", 1, new Object[] { "report ActOcrGestureType, type:", Integer.valueOf(this.jdField_b_of_type_Int) });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     audl
 * JD-Core Version:    0.7.0.1
 */