import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.os.Build;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;

public abstract class bkin
  extends bkbr
{
  public SegmentKeeper a = new SegmentKeeper();
  public int[] a;
  public PointF b;
  public ValueAnimator c;
  public boolean i = true;
  public int j;
  public boolean j;
  public int k = -1;
  public boolean k;
  public int l = -1;
  public boolean l;
  public int m = -1;
  public boolean m;
  public boolean n;
  public float q = 1.0F;
  public float r;
  public float s;
  public float t;
  public float u;
  public float v;
  public float w = 1.0F;
  
  public bkin() {}
  
  public bkin(@NonNull PointF paramPointF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
  {
    this.b = new PointF(paramPointF.x, paramPointF.y);
    this.q = paramFloat1;
    this.r = paramFloat2;
    this.s = paramFloat3;
    this.t = paramFloat4;
    this.u = paramFloat5;
    this.v = paramFloat6;
    this.i = paramBoolean;
    this.n = Build.MODEL.equals("MI 5C");
  }
  
  public bkin(bkin parambkin, float paramFloat)
  {
    this.b = new PointF(parambkin.b.x * paramFloat, parambkin.b.y * paramFloat);
    parambkin.q *= paramFloat;
    this.r = parambkin.r;
    parambkin.s *= paramFloat;
    parambkin.t *= paramFloat;
    this.u = parambkin.u;
    this.v = parambkin.v;
    this.i = parambkin.i;
    this.a.set(parambkin.a);
  }
  
  public void a(Canvas paramCanvas) {}
  
  public boolean d()
  {
    return !this.a.isEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkin
 * JD-Core Version:    0.7.0.1
 */