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

public class ayis
  extends ayjm
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Point jdField_a_of_type_AndroidGraphicsPoint;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ayip jdField_a_of_type_Ayip;
  private ayit jdField_a_of_type_Ayit;
  private ayji jdField_a_of_type_Ayji;
  private GestureFrameLayout jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout;
  private List<ayir> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[2];
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public ayis(GestureFrameLayout paramGestureFrameLayout, List<ayir> paramList, View.OnClickListener paramOnClickListener, ayit paramayit)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout = paramGestureFrameLayout;
    this.jdField_a_of_type_AndroidContentContext = paramGestureFrameLayout.getContext();
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Ayit = paramayit;
    paramGestureFrameLayout.a().a().a().invert(this.jdField_a_of_type_AndroidGraphicsMatrix);
    this.jdField_a_of_type_Ayip = new ayip();
    this.jdField_a_of_type_Ayip.a(2131365147, this.jdField_a_of_type_AndroidContentContext.getString(2131691137), 2130838920);
    this.jdField_a_of_type_Ayip.a(2131367027, this.jdField_a_of_type_AndroidContentContext.getString(2131692395), 2130838929);
    this.jdField_a_of_type_Ayip.a(2131379108, this.jdField_a_of_type_AndroidContentContext.getString(2131698143), 2130838929);
    this.jdField_a_of_type_Ayip.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    if (ayji.a()) {}
    for (paramGestureFrameLayout = new ayji();; paramGestureFrameLayout = null)
    {
      this.jdField_a_of_type_Ayji = paramGestureFrameLayout;
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
        ayir localayir = (ayir)paramMotionEvent1.next();
        k = this.jdField_a_of_type_JavaUtilList.indexOf(localayir);
        if (a(new Point(i, j), localayir)) {
          a(localayir, k);
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
        paramMotionEvent2 = (ayir)paramMotionEvent1.next();
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
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ayir paramayir)
  {
    Point localPoint1 = (Point)paramayir.jdField_a_of_type_JavaUtilList.get(0);
    Point localPoint2 = (Point)paramayir.jdField_a_of_type_JavaUtilList.get(1);
    if (a(paramInt1, paramInt2, paramInt3, paramInt4, localPoint1.x, localPoint1.y, localPoint2.x, localPoint2.y)) {
      return true;
    }
    Point localPoint3 = (Point)paramayir.jdField_a_of_type_JavaUtilList.get(2);
    paramayir = (Point)paramayir.jdField_a_of_type_JavaUtilList.get(3);
    if (a(paramInt1, paramInt2, paramInt3, paramInt4, localPoint3.x, localPoint3.y, paramayir.x, paramayir.y)) {
      return true;
    }
    return (a(paramInt1, paramInt2, paramInt3, paramInt4, localPoint2.x, localPoint2.y, localPoint3.x, localPoint3.y)) || (a(paramInt1, paramInt2, paramInt3, paramInt4, paramayir.x, paramayir.y, localPoint1.x, localPoint1.y));
  }
  
  private static boolean a(Point paramPoint, ayir paramayir)
  {
    if ((paramPoint.y > paramayir.e) || (paramPoint.y < paramayir.g) || (paramPoint.x > paramayir.d) || (paramPoint.x < paramayir.f)) {}
    int i;
    do
    {
      Point localPoint1;
      Point localPoint3;
      do
      {
        return false;
        if (paramayir.jdField_a_of_type_Int % 90 < 1) {
          return true;
        }
        Point localPoint2 = (Point)paramayir.jdField_a_of_type_JavaUtilList.get(0);
        localPoint1 = (Point)paramayir.jdField_a_of_type_JavaUtilList.get(1);
        paramayir = (Point)paramayir.jdField_a_of_type_JavaUtilList.get(2);
        localPoint3 = a(localPoint2, localPoint1);
        i = a(localPoint3, a(localPoint2, paramPoint));
      } while ((i < 0) || (i > a(localPoint3, localPoint3)));
      paramayir = a(localPoint1, paramayir);
      i = a(paramayir, a(localPoint1, paramPoint));
    } while (i < 0);
    if (i <= a(paramayir, paramayir)) {}
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
      ayir localayir = (ayir)paramMotionEvent.next();
      if (!a(new Point(j, k), localayir)) {
        break label218;
      }
      if (!paramBoolean2)
      {
        if ((paramBoolean1) || (!localayir.jdField_b_of_type_Boolean))
        {
          bool = true;
          localayir.jdField_b_of_type_Boolean = bool;
          this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout);
          if ((!paramBoolean1) && (!localayir.jdField_b_of_type_Boolean)) {
            break label203;
          }
          i = 1;
          label157:
          this.jdField_c_of_type_Int = i;
          if (paramBoolean1) {
            a(localayir);
          }
          if (!localayir.jdField_b_of_type_Boolean) {
            break label209;
          }
          i = 1;
          label184:
          ayfi.a("0X800AAED", i);
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
    this.jdField_a_of_type_Ayit.a();
    int i;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Int = 4;
      if (this.jdField_c_of_type_Int == 1)
      {
        i = 1;
        bcst.b(null, "dc00898", "", "", "0X800AAEE", "0X800AAEE", i, 0, String.valueOf(this.jdField_a_of_type_Int), "0", "0", "");
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
        ayfi.a("0X800AAF6", 0);
      }
      else if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_b_of_type_Int = 3;
        ayfi.a("0X800AAF7", 0);
      }
    }
  }
  
  public void a(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_a_of_type_Ayji.a();
    this.d = true;
  }
  
  public void a(ayir paramayir)
  {
    if (!this.jdField_a_of_type_Ayip.a())
    {
      Object localObject = (Point)paramayir.jdField_a_of_type_JavaUtilList.get(0);
      paramayir = (Point)paramayir.jdField_a_of_type_JavaUtilList.get(1);
      Matrix localMatrix = new Matrix();
      this.jdField_a_of_type_AndroidGraphicsMatrix.invert(localMatrix);
      float[] arrayOfFloat = new float[2];
      arrayOfFloat[0] = ((Point)localObject).x;
      arrayOfFloat[1] = ((Point)localObject).y;
      localObject = new float[2];
      localObject[0] = paramayir.x;
      localObject[1] = paramayir.y;
      localMatrix.mapPoints(arrayOfFloat);
      localMatrix.mapPoints((float[])localObject);
      int i = (int)(arrayOfFloat[0] + localObject[0]) / 2;
      float f = arrayOfFloat[1];
      int j = (int)(localObject[1] + f) / 2;
      this.jdField_a_of_type_Ayip.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout, i, j);
    }
  }
  
  public void a(ayir paramayir, int paramInt)
  {
    boolean bool = true;
    if (this.jdField_c_of_type_Int == -1)
    {
      if (paramayir.jdField_b_of_type_Boolean)
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
      if (bool != paramayir.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Int += 1;
        paramayir.jdField_b_of_type_Boolean = bool;
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
    this.jdField_a_of_type_Ayji.a(1);
    this.jdField_a_of_type_Ayit.b();
    return super.a(paramScaleGestureDetector);
  }
  
  public void b(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Ayip.a();
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
    this.jdField_a_of_type_Ayji.b();
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
    bctj.a(BaseApplication.getContext()).a(null, "actOcrGestureType", true, 0L, 0L, paramMessage, null);
    QLog.d("OcrScroll", 1, new Object[] { "report ActOcrGestureType, type:", Integer.valueOf(this.jdField_b_of_type_Int) });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayis
 * JD-Core Version:    0.7.0.1
 */