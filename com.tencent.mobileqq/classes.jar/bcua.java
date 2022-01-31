import android.content.Context;

public class bcua
{
  private bctr[] a = new bctr[3];
  
  public bctr a(Context paramContext, int paramInt)
  {
    Object localObject1;
    if ((paramInt < 0) || (paramInt > 3)) {
      localObject1 = null;
    }
    do
    {
      do
      {
        return localObject1;
        ??? = this.a[paramInt];
        localObject1 = ???;
      } while (??? != null);
      localObject1 = ???;
    } while (paramContext == null);
    synchronized (this.a)
    {
      localObject1 = this.a[paramInt];
      if (localObject1 != null) {
        return localObject1;
      }
    }
    switch (paramInt)
    {
    default: 
      paramContext = (Context)localObject1;
    }
    for (;;)
    {
      this.a[paramInt] = paramContext;
      return paramContext;
      paramContext = new bctu(paramContext);
      continue;
      paramContext = new bcts(paramContext);
      continue;
      paramContext = new bcty(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcua
 * JD-Core Version:    0.7.0.1
 */