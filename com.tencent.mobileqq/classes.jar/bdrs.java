import com.tencent.qphone.base.util.QLog;

public class bdrs
{
  public static int a(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0)
    {
      QLog.e("Q.qqhead.VasFaceManager", 1, "unknown DynamicSource", new RuntimeException("DynamicFaceDrawable don't have " + paramInt));
      i = 7;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdrs
 * JD-Core Version:    0.7.0.1
 */