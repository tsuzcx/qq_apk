import android.content.Context;

public class bbqz
{
  private bbqs[] a = new bbqs[2];
  
  public bbqs a(Context paramContext, int paramInt)
  {
    Object localObject1;
    if ((paramInt < 0) || (paramInt > 2)) {
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
      paramContext = new bbqv(paramContext);
      continue;
      paramContext = new bbqt(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbqz
 * JD-Core Version:    0.7.0.1
 */