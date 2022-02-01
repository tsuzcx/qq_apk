import android.content.Context;

public class bjge
{
  private bjfv[] a = new bjfv[3];
  
  public bjfv a(Context paramContext, int paramInt)
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
      paramContext = new bjfy(paramContext);
      continue;
      paramContext = new bjfw(paramContext);
      continue;
      paramContext = new bjgc(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjge
 * JD-Core Version:    0.7.0.1
 */