import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
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
public class bcpj
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
  private bcpk jdField_a_of_type_Bcpk;
  private bcpl jdField_a_of_type_Bcpl;
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
  private long i;
  private long j;
  private long k;
  
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
    this.jdField_e_of_type_Long = 0L;
    this.f = 0L;
  }
  
  private void a(View paramView, int paramInt)
  {
    long l1 = SystemClock.uptimeMillis();
    try
    {
      if (jdField_a_of_type_JavaLangReflectField == null)
      {
        jdField_a_of_type_JavaLangReflectField = View.class.getDeclaredField("mViewFlags");
        jdField_a_of_type_JavaLangReflectField.setAccessible(true);
      }
      int m = jdField_a_of_type_JavaLangReflectField.getInt(paramView);
      jdField_a_of_type_JavaLangReflectField.setInt(paramView, m & 0xFFFFFFF3 | paramInt & 0xC);
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        long l2;
        QLog.e("QQBlur", 1, "setViewInvisible: ", paramView);
      }
    }
    l2 = SystemClock.uptimeMillis();
    if (this.j >= 100000L)
    {
      this.j = 0L;
      this.k = 0L;
    }
    this.j += 1L;
    this.k = (l2 - l1 + this.k);
    if (this.j % 2000L == 0L) {}
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
        int n = paramView.getChildCount();
        int m = 0;
        while (m < n)
        {
          a(paramView.getChildAt(m), paramList);
          m += 1;
        }
      }
    }
  }
  
  private void e()
  {
    long l1 = SystemClock.elapsedRealtime();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getWidth() > 0) && (this.jdField_b_of_type_AndroidViewView.getHeight() > 0))
    {
      int m = a(this.jdField_b_of_type_AndroidViewView.getWidth(), this.jdField_a_of_type_Float);
      int n = a(this.jdField_b_of_type_AndroidViewView.getHeight(), this.jdField_a_of_type_Float);
      int i1 = a(m);
      int i2 = a(n);
      this.jdField_c_of_type_Float = (n / i2);
      this.jdField_b_of_type_Float = (m / i1);
      float f1 = this.jdField_a_of_type_Float * this.jdField_b_of_type_Float;
      float f2 = this.jdField_a_of_type_Float * this.jdField_c_of_type_Float;
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
        if (localBitmap == null) {
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("QQBlur", 1, "prepareBlurBitmap: ", localException);
          localObject1 = null;
        }
        this.g = ((Bitmap)localObject1).getWidth();
        this.h = ((Bitmap)localObject1).getHeight();
        if (Build.VERSION.SDK_INT < 19) {
          break label483;
        }
      }
      this.i = ((Bitmap)localObject1).getAllocationByteCount();
      ((Bitmap)localObject1).eraseColor(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap((Bitmap)localObject1);
      localObject2 = new int[2];
      this.jdField_b_of_type_AndroidViewView.getLocationInWindow((int[])localObject2);
      localObject3 = new int[2];
      this.jdField_a_of_type_AndroidViewView.getLocationInWindow((int[])localObject3);
      this.jdField_a_of_type_AndroidGraphicsCanvas.save();
      this.jdField_a_of_type_AndroidGraphicsCanvas.translate(-(localObject2[0] - localObject3[0]) / f1, -(localObject2[1] - localObject3[1]) / f2);
      this.jdField_a_of_type_AndroidGraphicsCanvas.scale(1.0F / f1, 1.0F / f2);
      localObject2 = new StackBlurManager((Bitmap)localObject1);
      ((StackBlurManager)localObject2).setDbg(false);
      ((StackBlurManager)localObject2).setExecutorThreads(((StackBlurManager)localObject2).getExecutorThreads());
      localObject3 = new Bundle();
      if (this.jdField_a_of_type_Bcpl != null) {
        this.jdField_a_of_type_Bcpl.a((Bundle)localObject3);
      }
      this.jdField_c_of_type_Boolean = true;
      if ((Build.VERSION.SDK_INT <= 27) || (this.jdField_b_of_type_AndroidViewView.getContext().getApplicationInfo().targetSdkVersion <= 27)) {
        break label496;
      }
      this.jdField_a_of_type_AndroidViewView.draw(this.jdField_a_of_type_AndroidGraphicsCanvas);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsCanvas.restore();
      g();
      this.jdField_c_of_type_Boolean = false;
      if (this.jdField_a_of_type_Bcpl != null) {
        this.jdField_a_of_type_Bcpl.b((Bundle)localObject3);
      }
      localObject1 = new QQBlur.1(this, (StackBlurManager)localObject2);
      this.jdField_a_of_type_AndroidOsHandler.post((Runnable)localObject1);
      long l2 = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_Long += 1L;
      this.jdField_b_of_type_Long = (l2 - l1 + this.jdField_b_of_type_Long);
      return;
      label483:
      this.i = ((Bitmap)localObject1).getByteCount();
      break;
      label496:
      Rect localRect = this.jdField_a_of_type_AndroidGraphicsCanvas.getClipBounds();
      localRect.inset(-((Bitmap)localObject1).getWidth(), -((Bitmap)localObject1).getHeight());
      if (this.jdField_a_of_type_AndroidGraphicsCanvas.clipRect(localRect, Region.Op.REPLACE)) {
        this.jdField_a_of_type_AndroidViewView.draw(this.jdField_a_of_type_AndroidGraphicsCanvas);
      } else {
        QLog.e("QQBlur", 1, "prepareBlurBitmap: canvas clip rect empty. Cannot draw!!!");
      }
    }
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
  
  public bcpj a()
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
  
  public bcpj a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    return this;
  }
  
  public bcpj a(bcpl parambcpl)
  {
    this.jdField_a_of_type_Bcpl = parambcpl;
    return this;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("方案=").append(a(jdField_a_of_type_Int)).append(",");
    localStringBuilder.append("缩放倍数=").append(this.jdField_a_of_type_Float).append(",");
    localStringBuilder.append("模糊半径=").append(this.jdField_b_of_type_Int).append(",");
    localStringBuilder.append("尺寸=" + this.g + "x" + this.h).append(",");
    localStringBuilder.append("空间=" + this.i / 1000L + "KB").append(",");
    localStringBuilder.append("并发数=" + this.jdField_d_of_type_Int).append(",");
    localStringBuilder.append("主线程采样=[" + String.format("%.2f", new Object[] { Float.valueOf((float)this.jdField_b_of_type_Long / (float)this.jdField_a_of_type_Long) }) + "]ms").append(",");
    localStringBuilder.append("后台线程处理=[" + String.format("%.2f", new Object[] { Float.valueOf((float)this.f / (float)this.jdField_e_of_type_Long) }) + "]ms");
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
    long l1 = SystemClock.elapsedRealtime();
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
    }
    for (;;)
    {
      long l2 = SystemClock.elapsedRealtime();
      this.jdField_c_of_type_Long += 1L;
      this.jdField_d_of_type_Long = (l2 - l1 + this.jdField_d_of_type_Long);
      return;
      QLog.e("QQBlur", 1, "onDrawBlur: blured bitmap is null " + Integer.toHexString(System.identityHashCode(paramView)));
    }
  }
  
  public void a(bcpk parambcpk)
  {
    this.jdField_a_of_type_Bcpk = parambcpk;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public bcpj b(View paramView)
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
    if (this.jdField_a_of_type_Bcpk != null) {
      bool = this.jdField_a_of_type_Bcpk.a();
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
      this.jdField_a_of_type_Bcpl = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcpj
 * JD-Core Version:    0.7.0.1
 */