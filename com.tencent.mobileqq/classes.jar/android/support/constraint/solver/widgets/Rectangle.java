package android.support.constraint.solver.widgets;

public class Rectangle
{
  public int height;
  public int width;
  public int x;
  public int y;
  
  public boolean contains(int paramInt1, int paramInt2)
  {
    int i = this.x;
    if ((paramInt1 >= i) && (paramInt1 < i + this.width))
    {
      paramInt1 = this.y;
      if ((paramInt2 >= paramInt1) && (paramInt2 < paramInt1 + this.height)) {
        return true;
      }
    }
    return false;
  }
  
  public int getCenterX()
  {
    return (this.x + this.width) / 2;
  }
  
  public int getCenterY()
  {
    return (this.y + this.height) / 2;
  }
  
  void grow(int paramInt1, int paramInt2)
  {
    this.x -= paramInt1;
    this.y -= paramInt2;
    this.width += paramInt1 * 2;
    this.height += paramInt2 * 2;
  }
  
  boolean intersects(Rectangle paramRectangle)
  {
    int i = this.x;
    int j = paramRectangle.x;
    if ((i >= j) && (i < j + paramRectangle.width))
    {
      i = this.y;
      j = paramRectangle.y;
      if ((i >= j) && (i < j + paramRectangle.height)) {
        return true;
      }
    }
    return false;
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.constraint.solver.widgets.Rectangle
 * JD-Core Version:    0.7.0.1
 */