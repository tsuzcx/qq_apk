import java.util.List;

public class been
{
  public static boolean a(int paramInt, List paramList)
  {
    return (paramList == null) || (paramInt < 0) || (paramInt >= paramList.size());
  }
  
  public static <T> boolean a(T[] paramArrayOfT, T paramT)
  {
    if ((paramArrayOfT == null) || (paramT == null)) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfT.length;
      int i = 0;
      while (i < j)
      {
        T ? = paramArrayOfT[i];
        if ((? != null) && (?.equals(paramT))) {
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     been
 * JD-Core Version:    0.7.0.1
 */