import android.graphics.Point;

final class bblc
  implements bblf<Point>
{
  public Point a(float paramFloat, Point paramPoint1, Point paramPoint2)
  {
    float f1 = paramPoint1.x;
    float f2 = paramPoint1.y;
    return new Point((int)(f1 + (paramPoint2.x - f1) * paramFloat), (int)(f2 + (paramPoint2.y - f2) * paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bblc
 * JD-Core Version:    0.7.0.1
 */