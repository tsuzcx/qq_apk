package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

class PathProperty<T>
  extends Property<T, Float>
{
  private float mCurrentFraction;
  private final float mPathLength;
  private final PathMeasure mPathMeasure;
  private final PointF mPointF = new PointF();
  private final float[] mPosition = new float[2];
  private final Property<T, PointF> mProperty;
  
  PathProperty(Property<T, PointF> paramProperty, Path paramPath)
  {
    super(Float.class, paramProperty.getName());
    this.mProperty = paramProperty;
    this.mPathMeasure = new PathMeasure(paramPath, false);
    this.mPathLength = this.mPathMeasure.getLength();
  }
  
  public Float get(T paramT)
  {
    return Float.valueOf(this.mCurrentFraction);
  }
  
  public void set(T paramT, Float paramFloat)
  {
    this.mCurrentFraction = paramFloat.floatValue();
    this.mPathMeasure.getPosTan(this.mPathLength * paramFloat.floatValue(), this.mPosition, null);
    paramFloat = this.mPointF;
    float[] arrayOfFloat = this.mPosition;
    paramFloat.x = arrayOfFloat[0];
    paramFloat.y = arrayOfFloat[1];
    this.mProperty.set(paramT, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.PathProperty
 * JD-Core Version:    0.7.0.1
 */