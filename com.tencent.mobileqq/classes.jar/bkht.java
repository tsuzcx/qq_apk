import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;

@TargetApi(14)
public class bkht
{
  public static int a;
  public static int b;
  
  public static float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 < paramInt4) {
      return 1.0F;
    }
    return paramInt4 / paramInt2;
  }
  
  public static int a()
  {
    return a(BaseApplicationImpl.getApplication().getBaseContext(), 30.0F);
  }
  
  public static int a(Context paramContext)
  {
    if (a > 0) {
      return a;
    }
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
    }
    for (a = localPoint.x;; a = paramContext.getDefaultDisplay().getWidth()) {
      return a;
    }
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static void a(Canvas paramCanvas, bkhv parambkhv, bkhw parambkhw, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = a();
    paramCanvas.concat(parambkhv.b(parambkhw));
    int j = (int)(parambkhw.u * parambkhw.q * parambkhw.w) + parambkhw.j * 2;
    int k = (int)(parambkhw.v * parambkhw.q * parambkhw.w) + parambkhw.j * 2;
    paramCanvas.translate(-j * 1.0F / 2.0F, -k * 1.0F / 2.0F);
    parambkhv = new Paint();
    parambkhv.setStyle(Paint.Style.STROKE);
    parambkhv.setColor(BaseApplicationImpl.getApplication().getResources().getColor(2131167146));
    parambkhv.setStrokeWidth(a(BaseApplicationImpl.getApplication().getBaseContext(), 1.0F));
    int m = a(BaseApplicationImpl.getApplication().getBaseContext(), 3.0F);
    paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, j, k), m, m, parambkhv);
    paramCanvas.translate(-i / 2, -i / 2);
    if (paramInt1 > 0)
    {
      parambkhv = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt1);
      parambkhv.setBounds(0, 0, i, i);
      parambkhv.draw(paramCanvas);
    }
    paramCanvas.translate(j, k);
    if (paramInt3 > 0)
    {
      parambkhv = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt3);
      parambkhv.setBounds(0, 0, i, i);
      parambkhv.draw(paramCanvas);
    }
    paramCanvas.translate(0.0F, -k);
    if (paramInt2 > 0)
    {
      parambkhv = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt2);
      parambkhv.setBounds(0, 0, i, i);
      parambkhv.draw(paramCanvas);
    }
  }
  
  public static int b(Context paramContext)
  {
    if (b > 0) {
      return b;
    }
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
    }
    for (b = localPoint.y;; b = paramContext.getDefaultDisplay().getHeight()) {
      return b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkht
 * JD-Core Version:    0.7.0.1
 */