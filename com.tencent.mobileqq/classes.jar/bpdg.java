import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.os.Build;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;

public abstract class bpdg
  extends bows
{
  public PointF a;
  public SegmentKeeper a;
  public int[] a;
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
  
  public bpdg()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper();
  }
  
  public bpdg(@NonNull PointF paramPointF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper();
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(paramPointF.x, paramPointF.y);
    this.q = paramFloat1;
    this.r = paramFloat2;
    this.s = paramFloat3;
    this.t = paramFloat4;
    this.u = paramFloat5;
    this.v = paramFloat6;
    this.i = paramBoolean;
    this.n = Build.MODEL.equals("MI 5C");
  }
  
  public bpdg(bpdg parambpdg, float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper();
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(parambpdg.jdField_a_of_type_AndroidGraphicsPointF.x * paramFloat, parambpdg.jdField_a_of_type_AndroidGraphicsPointF.y * paramFloat);
    parambpdg.q *= paramFloat;
    this.r = parambpdg.r;
    parambpdg.s *= paramFloat;
    parambpdg.t *= paramFloat;
    this.u = parambpdg.u;
    this.v = parambpdg.v;
    this.i = parambpdg.i;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.set(parambpdg.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper);
  }
  
  public void a(Canvas paramCanvas) {}
  
  public boolean c()
  {
    return !this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpdg
 * JD-Core Version:    0.7.0.1
 */