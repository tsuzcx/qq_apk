import com.tencent.tavcut.bean.Size;

class blot
  implements blox
{
  public int a()
  {
    return 1920;
  }
  
  public Size a(Size paramSize)
  {
    int i = ((Integer)blow.a(Integer.valueOf(960), Integer.valueOf(1280), Integer.valueOf(1920))).intValue();
    Size localSize = new Size(0, 0);
    double d = paramSize.getWidth() / paramSize.getHeight();
    if (paramSize.getWidth() > paramSize.getHeight())
    {
      localSize.setWidth(Math.min(paramSize.getWidth(), i));
      localSize.setHeight(blow.a(localSize.getWidth() / d));
      return localSize;
    }
    localSize.setHeight(Math.min(paramSize.getHeight(), i));
    localSize.setWidth(blow.a(d * localSize.getHeight()));
    return localSize;
  }
  
  public int b()
  {
    return ((Integer)blow.a(Integer.valueOf(3145728), Integer.valueOf(4194304), Integer.valueOf(5242880))).intValue();
  }
  
  public int c()
  {
    return 30;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blot
 * JD-Core Version:    0.7.0.1
 */