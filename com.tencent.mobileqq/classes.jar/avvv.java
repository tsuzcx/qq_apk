import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.Gravity;
import com.tencent.mobileqq.ocr.view.gesture.Settings;

public class avvv
{
  private static final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private static final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private static final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private static final Rect b = new Rect();
  
  public static void a(Matrix paramMatrix, Settings paramSettings, Rect paramRect)
  {
    jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramSettings.e(), paramSettings.f());
    paramMatrix.mapRect(jdField_a_of_type_AndroidGraphicsRectF);
    int i = Math.round(jdField_a_of_type_AndroidGraphicsRectF.width());
    int j = Math.round(jdField_a_of_type_AndroidGraphicsRectF.height());
    jdField_a_of_type_AndroidGraphicsRect.set(0, 0, paramSettings.a(), paramSettings.b());
    Gravity.apply(paramSettings.g(), i, j, jdField_a_of_type_AndroidGraphicsRect, paramRect);
  }
  
  public static void a(avvt paramavvt, Settings paramSettings, Rect paramRect)
  {
    paramavvt.a(jdField_a_of_type_AndroidGraphicsMatrix);
    a(jdField_a_of_type_AndroidGraphicsMatrix, paramSettings, paramRect);
  }
  
  public static void a(Settings paramSettings, Point paramPoint)
  {
    a(paramSettings, b);
    Gravity.apply(paramSettings.g(), 0, 0, b, jdField_a_of_type_AndroidGraphicsRect);
    paramPoint.set(jdField_a_of_type_AndroidGraphicsRect.left, jdField_a_of_type_AndroidGraphicsRect.top);
  }
  
  public static void a(Settings paramSettings, Rect paramRect)
  {
    jdField_a_of_type_AndroidGraphicsRect.set(0, 0, paramSettings.a(), paramSettings.b());
    Gravity.apply(paramSettings.g(), paramSettings.c(), paramSettings.d(), jdField_a_of_type_AndroidGraphicsRect, paramRect);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avvv
 * JD-Core Version:    0.7.0.1
 */