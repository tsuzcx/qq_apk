import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.annotation.CallSuper;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class anga<DATA, CONFIG extends angu>
{
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  protected float a;
  protected final int a;
  protected long a;
  protected Bitmap a;
  protected Canvas a;
  protected angb a;
  protected angj a;
  protected CONFIG a;
  protected anhs a;
  private DATA jdField_a_of_type_JavaLangObject;
  private HashMap<String, Object> jdField_a_of_type_JavaUtilHashMap;
  protected final PriorityQueue<ange> a;
  protected boolean a;
  protected float b;
  protected int b;
  protected long b;
  protected boolean b;
  protected float c;
  protected int c;
  protected boolean c;
  private float d;
  protected int d;
  protected boolean d;
  private float jdField_e_of_type_Float = -1.0F;
  protected int e;
  private volatile boolean jdField_e_of_type_Boolean = true;
  protected int f;
  private volatile boolean f;
  protected int g;
  
  public anga(angj paramangj)
  {
    this.jdField_a_of_type_Int = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_b_of_type_Float = -1.0F;
    this.jdField_f_of_type_Int = -1;
    this.jdField_d_of_type_Float = -1.0F;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_Angj = paramangj;
    this.jdField_a_of_type_JavaUtilPriorityQueue = new PriorityQueue();
    j();
    e();
  }
  
  private void j()
  {
    try
    {
      this.jdField_a_of_type_Angu = this.jdField_a_of_type_Angj.a(a());
      return;
    }
    catch (Exception localException)
    {
      while (!anfj.a().a().a()) {}
      throw new RuntimeException("IDanmakuUIConfig should been provided by IDanmakuUIConfigCreator in DanmakuContext");
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_JavaUtilPriorityQueue.clear();
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_b_of_type_Float = -1.0F;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_e_of_type_Int = 0;
    this.g = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_d_of_type_Float = -1.0F;
    this.jdField_e_of_type_Float = -1.0F;
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof angc)) {
          ((angc)localObject).a();
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
  }
  
  public abstract float a();
  
  public abstract int a();
  
  public int a(int paramInt)
  {
    if (this.g > paramInt) {
      return paramInt - 1;
    }
    return this.g;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Anhs.a();
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public Canvas a()
  {
    return this.jdField_a_of_type_AndroidGraphicsCanvas;
  }
  
  public anhn a(anhx paramanhx)
  {
    return new anhn(-1);
  }
  
  public DATA a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a()
  {
    a(new anhs(angj.a().d()));
    b();
  }
  
  public void a(float paramFloat)
  {
    this.jdField_e_of_type_Float = paramFloat;
  }
  
  public abstract void a(float paramFloat1, float paramFloat2, long paramLong1, long paramLong2);
  
  public void a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public abstract void a(long paramLong);
  
  public final void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Long += paramLong1;
    }
    a(paramLong2);
    if (!this.jdField_a_of_type_JavaUtilPriorityQueue.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilPriorityQueue.iterator();
      while (localIterator.hasNext())
      {
        ange localange = (ange)localIterator.next();
        localange.jdField_a_of_type_Long -= paramLong1;
        if (localange.jdField_a_of_type_Long <= 0L)
        {
          localIterator.remove();
          localange.jdField_a_of_type_Angd.a(this);
        }
      }
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsCanvas = paramCanvas;
    c(true);
  }
  
  public void a(anhs paramanhs)
  {
    this.jdField_a_of_type_Anhs = paramanhs;
  }
  
  public void a(DATA paramDATA)
  {
    if ((anfj.a().a().a()) && (paramDATA == null)) {
      throw new RuntimeException("Danmaku data should been null");
    }
    this.jdField_a_of_type_JavaLangObject = paramDATA;
    c(true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_d_of_type_Int = 1;
      return;
    }
    this.jdField_d_of_type_Int = 0;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    boolean bool = true;
    float[] arrayOfFloat = b(paramLong);
    if (arrayOfFloat == null) {
      return false;
    }
    if ((arrayOfFloat[0] <= paramFloat1) && (paramFloat1 <= arrayOfFloat[2] + paramFloat3) && (arrayOfFloat[1] <= paramFloat2) && (paramFloat2 <= arrayOfFloat[3])) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean a(int paramInt)
  {
    if ((h()) || (this.jdField_e_of_type_Int - paramInt >= 0))
    {
      this.jdField_e_of_type_Int -= paramInt;
      this.jdField_a_of_type_Long += paramInt;
      return true;
    }
    return false;
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_c_of_type_Boolean) {}
    while (paramLong - this.jdField_b_of_type_Long < this.jdField_a_of_type_Anhs.a()) {
      return false;
    }
    return true;
  }
  
  public abstract float[] a(long paramLong);
  
  public abstract float b();
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int b(int paramInt)
  {
    if (this.jdField_f_of_type_Int >= paramInt) {
      return paramInt - 1;
    }
    return this.jdField_f_of_type_Int;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long + a();
  }
  
  protected void b() {}
  
  public void b(float paramFloat)
  {
    this.jdField_d_of_type_Float = paramFloat;
  }
  
  public void b(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Float >= 0.0F) && (this.jdField_b_of_type_Float >= 0.0F) && (!g());
  }
  
  public boolean b(long paramLong)
  {
    return (this.jdField_a_of_type_Long > 0L) && (paramLong - this.jdField_a_of_type_Long >= this.jdField_a_of_type_Anhs.a());
  }
  
  public abstract float[] b(long paramLong);
  
  public abstract float c();
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void c(float paramFloat)
  {
    this.jdField_a_of_type_Anhs.a(paramFloat);
  }
  
  public void c(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_d_of_type_Int == 1;
  }
  
  public boolean c(long paramLong)
  {
    return (this.jdField_a_of_type_Long > 0L) && (paramLong - this.jdField_a_of_type_Long < 0L);
  }
  
  public abstract float d();
  
  public int d()
  {
    return angj.a().c();
  }
  
  public long d()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public void d()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void d(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public boolean d()
  {
    return angj.a().b();
  }
  
  public abstract float e();
  
  public int e()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public long e()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @CallSuper
  public void e()
  {
    angz localangz = angj.a();
    f(localangz.a());
    b(localangz.c());
    k();
    a();
  }
  
  public void e(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_Boolean) && (angz.a());
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (anga)paramObject;
      if (this.jdField_a_of_type_JavaLangObject != null) {
        return this.jdField_a_of_type_JavaLangObject.equals(paramObject.jdField_a_of_type_JavaLangObject);
      }
    } while (paramObject.jdField_a_of_type_JavaLangObject == null);
    return false;
  }
  
  public float f()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int f()
  {
    return angj.a().e();
  }
  
  public void f()
  {
    float f1 = b();
    if ((!this.jdField_d_of_type_Boolean) && (f1 < f()))
    {
      anic.c("BaseDanmaku", "onFirstExposure, danmaku = " + toString());
      i();
      this.jdField_d_of_type_Boolean = true;
    }
    if ((this.jdField_a_of_type_Angb != null) && (f1 <= 0.0F))
    {
      this.jdField_a_of_type_Angb.a(this);
      this.jdField_a_of_type_Angb = null;
    }
  }
  
  public void f(float paramFloat)
  {
    this.jdField_c_of_type_Float = paramFloat;
  }
  
  public boolean f()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public float g()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public int g()
  {
    return angj.a().f();
  }
  
  @CallSuper
  public void g()
  {
    d(false);
  }
  
  public boolean g()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public float h()
  {
    return b() + angj.a().g();
  }
  
  public void h()
  {
    this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(null);
  }
  
  public boolean h()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_JavaLangObject == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaLangObject.hashCode();
  }
  
  public float i()
  {
    return c() + d();
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_Angj != null) {
      this.jdField_a_of_type_Angj.a(this);
    }
  }
  
  public String toString()
  {
    return "BaseDanmaku" + this.jdField_a_of_type_Int + "[left:" + b() + ",top:" + c() + ",right:" + d() + ",bottom:" + e() + ", time:" + this.jdField_b_of_type_Long + ", mData=" + String.valueOf(this.jdField_a_of_type_JavaLangObject) + ", mType=" + a() + ", playerTime=" + this.jdField_a_of_type_Angj.a() + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anga
 * JD-Core Version:    0.7.0.1
 */