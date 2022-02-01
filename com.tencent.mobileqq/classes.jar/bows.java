import android.animation.ValueAnimator;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam.MotionInfo;
import java.util.HashMap;
import java.util.Map;

public abstract class bows
{
  public ValueAnimator a;
  public Map<Long, TrackerStickerParam.MotionInfo> a;
  public ValueAnimator b;
  public boolean d;
  public boolean e;
  public boolean f;
  public boolean g;
  public boolean h;
  public int i = 0;
  public float j;
  public float k;
  public float l;
  public float m;
  public float n = 1.0F;
  public float o = 1.0F;
  public float p = 1.0F;
  
  public bows()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public void a(bows parambows)
  {
    if (parambows != null)
    {
      this.d = parambows.d;
      this.j = parambows.j;
      this.k = parambows.k;
      this.l = parambows.l;
      this.m = parambows.m;
      this.e = parambows.e;
      this.g = parambows.g;
      this.h = parambows.h;
      this.o = parambows.o;
      this.i = parambows.i;
    }
  }
  
  public boolean a()
  {
    return this.i == 0;
  }
  
  public boolean b()
  {
    return this.i == 3;
  }
  
  public void c(boolean paramBoolean)
  {
    this.d = false;
  }
  
  public void d()
  {
    this.g = false;
    this.h = false;
    this.j = 0.0F;
    this.k = 0.0F;
    this.l = 0.0F;
    this.m = 0.0F;
    this.o = 1.0F;
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.i = 0;
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    e();
  }
  
  public void e()
  {
    if ((this.b != null) && (this.b.isRunning())) {
      this.b.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bows
 * JD-Core Version:    0.7.0.1
 */