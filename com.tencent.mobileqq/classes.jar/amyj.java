import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class amyj
  extends Animation
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  
  public amyj(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    this.d = paramInt5;
    this.c = paramInt6;
    this.a = paramInt3;
    this.b = paramInt4;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = this.e;
    float f2 = this.a;
    float f3 = this.d;
    float f4 = this.f;
    float f5 = this.b;
    float f6 = this.c;
    paramTransformation.getMatrix().preTranslate((1.0F - paramFloat) * (1.0F - paramFloat) * f1 + 2.0F * paramFloat * (1.0F - paramFloat) * f2 + paramFloat * paramFloat * f3, (1.0F - paramFloat) * (1.0F - paramFloat) * f4 + 2.0F * paramFloat * (1.0F - paramFloat) * f5 + paramFloat * paramFloat * f6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyj
 * JD-Core Version:    0.7.0.1
 */