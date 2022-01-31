import android.content.Context;

public class beyh
{
  private bexy[] a = new bexy[3];
  
  public bexy a(Context paramContext, int paramInt)
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
      paramContext = new beyb(paramContext);
      continue;
      paramContext = new bexz(paramContext);
      continue;
      paramContext = new beyf(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beyh
 * JD-Core Version:    0.7.0.1
 */