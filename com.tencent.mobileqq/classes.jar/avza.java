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

public class avza
  extends avzu
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Point jdField_a_of_type_AndroidGraphicsPoint;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private avyx jdField_a_of_type_Avyx;
  private avzb jdField_a_of_type_Avzb;
  private avzq jdField_a_of_type_Avzq;
  private GestureFrameLayout jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout;
  private List<avyz> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[2];
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public avza(GestureFrameLayout paramGestureFrameLayout, List<avyz> paramList, View.OnClickListener paramOnClickListener, avzb paramavzb)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout = paramGestureFrameLayout;
    this.jdField_a_of_type_AndroidContentContext = paramGestureFrameLayout.getContext();
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Avzb = paramavzb;
    paramGestureFrameLayout.a().a().a().invert(this.jdField_a_of_type_AndroidGraphicsMatrix);
    this.jdField_a_of_type_Avyx = new avyx();
    this.jdField_a_of_type_Avyx.a(2131364912, this.jdField_a_of_type_AndroidContentContext.getString(2131691357), 2130838669);
    this.jdField_a_of_type_Avyx.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131692837), 2130838678);
    this.jdField_a_of_type_Avyx.a(2131378254, this.jdField_a_of_type_AndroidContentContext.getString(2131699622), 2130838678);
    this.jdField_a_of_type_Avyx.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    if (avzq.a()) {}
    for (paramGestureFrameLayout = new avzq();; paramGestureFrameLayout = null)
    {
      this.jdField_a_of_type_Avzq = paramGestureFrameLayout;
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
        avyz localavyz = (avyz)paramMotionEvent1.next();
        k = this.jdField_a_of_type_JavaUtilList.indexOf(localavyz);
        if (a(new Point(i, j), localavyz)) {
          a(localavyz, k);
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
        paramMotionEvent2 = (avyz)paramMotionEvent1.next();
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
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, avyz paramavyz)
  {
    Point localPoint1 = (Point)paramavyz.jdField_a_of_type_JavaUtilList.get(0);
    Point localPoint2 = (Point)paramavyz.jdField_a_of_type_JavaUtilList.get(1);
    if (a(paramInt1, paramInt2, paramInt3, paramInt4, localPoint1.x, localPoint1.y, localPoint2.x, localPoint2.y)) {
      return true;
    }
    Point localPoint3 = (Point)paramavyz.jdField_a_of_type_JavaUtilList.get(2);
    paramavyz = (Point)paramavyz.jdField_a_of_type_JavaUtilList.get(3);
    if (a(paramInt1, paramInt2, paramInt3, paramInt4, localPoint3.x, localPoint3.y, paramavyz.x, paramavyz.y)) {
      return true;
    }
    return (a(paramInt1, paramInt2, paramInt3, paramInt4, localPoint2.x, localPoint2.y, localPoint3.x, localPoint3.y)) || (a(paramInt1, paramInt2, paramInt3, paramInt4, paramavyz.x, paramavyz.y, localPoint1.x, localPoint1.y));
  }
  
  private static boolean a(Point paramPoint, avyz paramavyz)
  {
    if ((paramPoint.y > paramavyz.e) || (paramPoint.y < paramavyz.g) || (paramPoint.x > paramavyz.d) || (paramPoint.x < paramavyz.f)) {}
    int i;
    do
    {
      Point localPoint1;
      Point localPoint3;
      do
      {
        return false;
        if (paramavyz.jdField_a_of_type_Int % 90 < 1) {
          return true;
        }
        Point localPoint2 = (Point)paramavyz.jdField_a_of_type_JavaUtilList.get(0);
        localPoint1 = (Point)paramavyz.jdField_a_of_type_JavaUtilList.get(1);
        paramavyz = (Point)paramavyz.jdField_a_of_type_JavaUtilList.get(2);
        localPoint3 = a(localPoint2, localPoint1);
        i = a(localPoint3, a(localPoint2, paramPoint));
      } while ((i < 0) || (i > a(localPoint3, localPoint3)));
      paramavyz = a(localPoint1, paramavyz);
      i = a(paramavyz, a(localPoint1, paramPoint));
    } while (i < 0);
    if (i <= a(paramavyz, paramavyz)) {}
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
      avyz localavyz = (avyz)paramMotionEvent.next();
      if (!a(new Point(j, k), localavyz)) {
        break label218;
      }
      if (!paramBoolean2)
      {
        if ((paramBoolean1) || (!localavyz.jdField_b_of_type_Boolean))
        {
          bool = true;
          localavyz.jdField_b_of_type_Boolean = bool;
          this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout);
          if ((!paramBoolean1) && (!localavyz.jdField_b_of_type_Boolean)) {
            break label203;
          }
          i = 1;
          label157:
          this.jdField_c_of_type_Int = i;
          if (paramBoolean1) {
            a(localavyz);
          }
          if (!localavyz.jdField_b_of_type_Boolean) {
            break label209;
          }
          i = 1;
          label184:
          avvq.a("0X800AAED", i);
        }
      }
      else {
        bool = true;
      }
    }
    label203:
    label209:
    label218:
    for (;;)
    {
      break;
      bool = false;
      break label124;
      i = 2;
      break label157;
      i = 2;
      break label184;
      return bool;
    }
  }
  
  public void a(Matrix paramMatrix)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.set(paramMatrix);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Avzb.a();
    int i;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Int = 4;
      if (this.jdField_c_of_type_Int == 1)
      {
        i = 1;
        azqs.b(null, "dc00898", "", "", "0X800AAEE", "0X800AAEE", i, 0, String.valueOf(this.jdField_a_of_type_Int), "0", "0", "");
      }
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
      this.jdField_a_of_type_Boolean = false;
      return;
      i = 2;
      break;
      if (this.d)
      {
        this.jdField_b_of_type_Int = 1;
        avvq.a("0X800AAF6", 0);
      }
      else if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_b_of_type_Int = 3;
        avvq.a("0X800AAF7", 0);
      }
    }
  }
  
  public void a(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_a_of_type_Avzq.a();
    this.d = true;
  }
  
  public void a(avyz paramavyz)
  {
    if (!this.jdField_a_of_type_Avyx.a())
    {
      Object localObject = (Point)paramavyz.jdField_a_of_type_JavaUtilList.get(0);
      paramavyz = (Point)paramavyz.jdField_a_of_type_JavaUtilList.get(1);
      Matrix localMatrix = new Matrix();
      this.jdField_a_of_type_AndroidGraphicsMatrix.invert(localMatrix);
      float[] arrayOfFloat = new float[2];
      arrayOfFloat[0] = ((Point)localObject).x;
      arrayOfFloat[1] = ((Point)localObject).y;
      localObject = new float[2];
      localObject[0] = paramavyz.x;
      localObject[1] = paramavyz.y;
      localMatrix.mapPoints(arrayOfFloat);
      localMatrix.mapPoints((float[])localObject);
      int i = (int)(arrayOfFloat[0] + localObject[0]) / 2;
      float f = arrayOfFloat[1];
      int j = (int)(localObject[1] + f) / 2;
      this.jdField_a_of_type_Avyx.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout, i, j);
    }
  }
  
  public void a(avyz paramavyz, int paramInt)
  {
    boolean bool = true;
    if (this.jdField_c_of_type_Int == -1)
    {
      if (paramavyz.jdField_b_of_type_Boolean)
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
      if (bool != paramavyz.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Int += 1;
        paramavyz.jdField_b_of_type_Boolean = bool;
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
    this.jdField_a_of_type_Avzq.a(1);
    this.jdField_a_of_type_Avzb.b();
    return super.a(paramScaleGestureDetector);
  }
  
  public void b(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Avyx.a();
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
    this.jdField_a_of_type_Avzq.b();
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
    azri.a(BaseApplication.getContext()).a(null, "actOcrGestureType", true, 0L, 0L, paramMessage, null);
    QLog.d("OcrScroll", 1, new Object[] { "report ActOcrGestureType, type:", Integer.valueOf(this.jdField_b_of_type_Int) });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avza
 * JD-Core Version:    0.7.0.1
 */