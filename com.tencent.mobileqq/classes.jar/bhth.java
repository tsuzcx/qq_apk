import android.graphics.Point;

final class bhth
  implements bhtk<Point>
{
  public Point a(float paramFloat, Point paramPoint1, Point paramPoint2)
  {
    float f1 = paramPoint1.x;
    float f2 = paramPoint1.y;
    return new Point((int)(f1 + (paramPoint2.x - f1) * paramFloat), (int)(f2 + (paramPoint2.y - f2) * paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhth
 * JD-Core Version:    0.7.0.1
 */