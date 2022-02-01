import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQBlur.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(19)
public class bjbl
{
  public static int a;
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private static Field jdField_a_of_type_JavaLangReflectField;
  private float jdField_a_of_type_Float = 8.0F;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private volatile Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#DAFAFAFC"));
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private bjbm jdField_a_of_type_Bjbm;
  private bjbn jdField_a_of_type_Bjbn;
  private String jdField_a_of_type_JavaLangString;
  private List<View> jdField_a_of_type_JavaUtilList = new ArrayList();
  private volatile boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float = 1.0F;
  private int jdField_b_of_type_Int = 6;
  private long jdField_b_of_type_Long;
  private volatile View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float = 1.0F;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int = 2;
  private long jdField_d_of_type_Long;
  private float jdField_e_of_type_Float;
  private long jdField_e_of_type_Long;
  private long f;
  private long g;
  private long h;
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_AndroidOsHandlerThread = ThreadManagerV2.newFreeHandlerThread("QQBlur", -8);
    jdField_a_of_type_AndroidOsHandlerThread.start();
  }
  
  private static int a(float paramFloat1, float paramFloat2)
  {
    return (int)Math.ceil(paramFloat1 / paramFloat2);
  }
  
  public static int a(int paramInt)
  {
    if (paramInt % 16 == 0) {
      return paramInt;
    }
    return paramInt - paramInt % 16 + 16;
  }
  
  private CharSequence a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "StackBlur.Java";
    case 1: 
      return "StackBlur.Native";
    case 2: 
      return "StackBlur.RS";
    }
    return "GaussBlur.RS";
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBlur", 2, "onPolicyChange() called with: from = [" + paramInt1 + "], to = [" + paramInt2 + "]");
    }
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
  }
  
  private void a(View paramView, int paramInt)
  {
    SystemClock.uptimeMillis();
    try
    {
      if (jdField_a_of_type_JavaLangReflectField == null)
      {
        jdField_a_of_type_JavaLangReflectField = View.class.getDeclaredField("mViewFlags");
        jdField_a_of_type_JavaLangReflectField.setAccessible(true);
      }
      int i = jdField_a_of_type_JavaLangReflectField.getInt(paramView);
      jdField_a_of_type_JavaLangReflectField.setInt(paramView, i & 0xFFFFFFF3 | paramInt & 0xC);
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        QLog.e("QQBlur", 1, "setViewInvisible: ", paramView);
      }
    }
    SystemClock.uptimeMillis();
    if (this.h >= 100000L) {
      this.h = 0L;
    }
    this.h += 1L;
    if (this.h % 2000L == 0L) {}
  }
  
  private void a(View paramView, List<View> paramList)
  {
    if (paramView == null) {
      break label4;
    }
    for (;;)
    {
      label4:
      return;
      if (paramView.getVisibility() == 0)
      {
        paramList.add(paramView);
        a(paramView, 4);
        if (!(paramView instanceof ViewGroup)) {
          break;
        }
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        int i = 0;
        while (i < j)
        {
          a(paramView.getChildAt(i), paramList);
          i += 1;
        }
      }
    }
  }
  
  private void a(StackBlurManager paramStackBlurManager)
  {
    paramStackBlurManager = new QQBlur.1(this, paramStackBlurManager);
    this.jdField_a_of_type_AndroidOsHandler.post(paramStackBlurManager);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    int i = a(paramInt1, this.jdField_a_of_type_Float);
    int j = a(paramInt2, this.jdField_a_of_type_Float);
    int k = a(i);
    int m = a(j);
    if (k > this.jdField_b_of_type_AndroidViewView.getResources().getDisplayMetrics().widthPixels) {
      QLog.e("QQBlur", 1, "prepareBlurBitmapCore: roundScaledWidth = " + k + ", viewWidth = " + paramInt1 + ", scaleFactor = " + this.jdField_a_of_type_Float);
    }
    for (;;)
    {
      return true;
      if (m > this.jdField_b_of_type_AndroidViewView.getResources().getDisplayMetrics().heightPixels)
      {
        QLog.e("QQBlur", 1, "prepareBlurBitmapCore: roundScaledHeight = " + m + ", viewHeight = " + paramInt2 + ", scaleFactor = " + this.jdField_a_of_type_Float);
        return true;
      }
      this.jdField_c_of_type_Float = (j / m);
      this.jdField_b_of_type_Float = (i / k);
      float f1 = this.jdField_a_of_type_Float * this.jdField_b_of_type_Float;
      float f2 = this.jdField_a_of_type_Float * this.jdField_c_of_type_Float;
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
        if (localBitmap == null) {
          continue;
        }
        this.jdField_e_of_type_Long = localBitmap.getWidth();
        this.f = localBitmap.getHeight();
        if (Build.VERSION.SDK_INT >= 19)
        {
          this.g = localBitmap.getAllocationByteCount();
          localBitmap.eraseColor(this.jdField_c_of_type_Int);
          this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(localBitmap);
          Object localObject2 = new int[2];
          this.jdField_b_of_type_AndroidViewView.getLocationInWindow((int[])localObject2);
          Object localObject3 = new int[2];
          this.jdField_a_of_type_AndroidViewView.getLocationInWindow((int[])localObject3);
          this.jdField_a_of_type_AndroidGraphicsCanvas.save();
          this.jdField_a_of_type_AndroidGraphicsCanvas.translate(-(localObject2[0] - localObject3[0]) / f1, -(localObject2[1] - localObject3[1]) / f2);
          this.jdField_a_of_type_AndroidGraphicsCanvas.scale(1.0F / f1, 1.0F / f2);
          localObject2 = new StackBlurManager(localBitmap);
          ((StackBlurManager)localObject2).setDbg(false);
          ((StackBlurManager)localObject2).setExecutorThreads(((StackBlurManager)localObject2).getExecutorThreads());
          localObject3 = new Bundle();
          if (this.jdField_a_of_type_Bjbn != null) {
            this.jdField_a_of_type_Bjbn.a((Bundle)localObject3);
          }
          this.jdField_c_of_type_Boolean = true;
          if ((Build.VERSION.SDK_INT <= 27) || (this.jdField_b_of_type_AndroidViewView.getContext().getApplicationInfo().targetSdkVersion <= 27)) {
            break label546;
          }
          this.jdField_a_of_type_AndroidViewView.draw(this.jdField_a_of_type_AndroidGraphicsCanvas);
          this.jdField_a_of_type_AndroidGraphicsCanvas.restore();
          g();
          this.jdField_c_of_type_Boolean = false;
          if (this.jdField_a_of_type_Bjbn != null) {
            this.jdField_a_of_type_Bjbn.b((Bundle)localObject3);
          }
          a((StackBlurManager)localObject2);
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("QQBlur", 1, "prepareBlurBitmapCore: ", localThrowable);
          Object localObject1 = null;
          continue;
          this.g = localObject1.getByteCount();
          continue;
          label546:
          Rect localRect = this.jdField_a_of_type_AndroidGraphicsCanvas.getClipBounds();
          localRect.inset(-localObject1.getWidth(), -localObject1.getHeight());
          if (this.jdField_a_of_type_AndroidGraphicsCanvas.clipRect(localRect, Region.Op.REPLACE)) {
            this.jdField_a_of_type_AndroidViewView.draw(this.jdField_a_of_type_AndroidGraphicsCanvas);
          } else {
            QLog.e("QQBlur", 1, "prepareBlurBitmapCore: canvas clip rect empty. Cannot draw!!!");
          }
        }
      }
    }
  }
  
  private void e()
  {
    long l1 = SystemClock.elapsedRealtime();
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_b_of_type_AndroidViewView == null)) {
      QLog.e("QQBlur", 1, "prepareBlurBitmap: mBgView = " + this.jdField_a_of_type_AndroidViewView + " mBlurView = " + this.jdField_b_of_type_AndroidViewView);
    }
    int i;
    int j;
    do
    {
      return;
      i = this.jdField_b_of_type_AndroidViewView.getWidth();
      j = this.jdField_b_of_type_AndroidViewView.getHeight();
      if ((i <= 0) || (j <= 0))
      {
        QLog.e("QQBlur", 1, "prepareBlurBitmap: viewWidth = " + i + " viewHeight = " + j);
        return;
      }
    } while (a(i, j));
    long l2 = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_Long += 1L;
    this.jdField_b_of_type_Long = (l2 - l1 + this.jdField_b_of_type_Long);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView == null)) {}
  }
  
  private void g()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (localView != null) {
        a(localView, 0);
      }
    }
  }
  
  public bjbl a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBlur", 2, "onCreate() called");
    }
    if (this.jdField_b_of_type_Boolean) {}
    this.jdField_a_of_type_AndroidContentContext = this.jdField_b_of_type_AndroidViewView.getContext();
    this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_b_of_type_Boolean = true;
    f();
    return this;
  }
  
  public bjbl a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    return this;
  }
  
  public bjbl a(bjbn parambjbn)
  {
    this.jdField_a_of_type_Bjbn = parambjbn;
    return this;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("方案=").append(a(jdField_a_of_type_Int)).append(",");
    localStringBuilder.append("缩放倍数=").append(this.jdField_a_of_type_Float).append(",");
    localStringBuilder.append("模糊半径=").append(this.jdField_b_of_type_Int).append(",");
    localStringBuilder.append("尺寸=" + this.jdField_e_of_type_Long + "x" + this.f).append(",");
    localStringBuilder.append("空间=" + this.g / 1000L + "KB").append(",");
    localStringBuilder.append("并发数=" + this.jdField_d_of_type_Int).append(",");
    localStringBuilder.append("主线程采样=[" + String.format("%.2f", new Object[] { Float.valueOf((float)this.jdField_b_of_type_Long / (float)this.jdField_a_of_type_Long) }) + "]ms").append(",");
    localStringBuilder.append("后台线程处理=[" + String.format("%.2f", new Object[] { Float.valueOf((float)this.jdField_d_of_type_Long / (float)this.jdField_c_of_type_Long) }) + "]ms");
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    QLog.i("QQBlur." + this.jdField_a_of_type_JavaLangString, 2, a());
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void a(View paramView, Canvas paramCanvas)
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null)
    {
      paramCanvas.save();
      paramCanvas.scale(paramView.getWidth() * 1.0F / localBitmap.getWidth(), paramView.getHeight() * 1.0F / localBitmap.getHeight());
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null) {
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader(new BitmapShader(localBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, localBitmap.getWidth(), localBitmap.getHeight());
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_d_of_type_Float, this.jdField_e_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
      paramCanvas.restore();
      return;
    }
    QLog.e("QQBlur", 1, "onDrawBlur: blured bitmap is null " + Integer.toHexString(System.identityHashCode(paramView)));
  }
  
  public void a(bjbm parambjbm)
  {
    this.jdField_a_of_type_Bjbm = parambjbm;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public bjbl b(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView;
    return this;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Bjbm != null) {
      bool = this.jdField_a_of_type_Bjbm.a();
    }
    for (;;)
    {
      View localView = this.jdField_b_of_type_AndroidViewView;
      if ((!this.jdField_a_of_type_Boolean) && (bool) && (localView != null) && (localView.isShown()))
      {
        e();
        localView.invalidate();
      }
      return true;
      if (this.jdField_a_of_type_AndroidViewView != null) {
        bool = this.jdField_a_of_type_AndroidViewView.isDirty();
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBlur", 2, "onDestroy() called");
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
      this.jdField_a_of_type_AndroidViewView = null;
      this.jdField_b_of_type_AndroidViewView = null;
      this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(null);
      this.jdField_a_of_type_AndroidGraphicsCanvas = null;
      this.jdField_a_of_type_AndroidGraphicsPaint = null;
      this.jdField_a_of_type_Bjbn = null;
      this.jdField_a_of_type_AndroidContentContext = null;
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    a(this.jdField_a_of_type_AndroidViewView.getRootView(), this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjbl
 * JD-Core Version:    0.7.0.1
 */