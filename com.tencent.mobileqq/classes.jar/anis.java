public class anis
{
  public static void a(int paramInt)
  {
    a(paramInt, "");
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, null, paramInt2, -100, 0L, 0, 0L, new Object[] { "" });
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, Object... paramVarArgs)
  {
    a(paramInt1, null, paramInt2, paramInt3, paramLong, 0, 0L, paramVarArgs);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, Object... paramVarArgs)
  {
    a(paramInt1, null, paramInt2, paramInt3, 0L, 0, 0L, paramVarArgs);
  }
  
  public static void a(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    a(paramInt1, null, paramInt2, -100, 0L, 0, 0L, paramVarArgs);
  }
  
  public static void a(int paramInt, String paramString)
  {
    a(paramInt, paramString, null);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2)
  {
    a(paramInt1, paramString, paramInt2, -100, 0L, 0, 0L, new Object[] { "" });
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong1, int paramInt4, long paramLong2, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 30);
    int i = 0;
    while (i < paramVarArgs.length)
    {
      localStringBuilder.append(paramVarArgs[i]);
      i += 1;
    }
    aniz.a(paramInt1, paramString, paramInt2, paramInt3, paramLong1, paramInt4, paramLong2, new Object[] { localStringBuilder.toString() });
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, int paramInt3, Object... paramVarArgs)
  {
    a(paramInt1, paramString, paramInt2, paramInt3, 0L, 0, 0L, paramVarArgs);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, Object... paramVarArgs)
  {
    a(paramInt1, paramString, paramInt2, -100, 0L, 0, 0L, paramVarArgs);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    aniz.a(paramInt, paramString1, paramString2);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, int... paramVarArgs)
  {
    aniz.a(paramInt, paramString1, paramString2, paramVarArgs);
  }
  
  public static void a(int paramInt, String paramString, int... paramVarArgs)
  {
    a(paramInt, paramString, null, paramVarArgs);
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    aniz.a(paramInt, paramBoolean);
  }
  
  public static void a(anit paramanit)
  {
    aniz.a(paramanit);
  }
  
  public static void b(int paramInt)
  {
    b(paramInt, null);
  }
  
  public static void b(int paramInt, String paramString)
  {
    aniz.a(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anis
 * JD-Core Version:    0.7.0.1
 */