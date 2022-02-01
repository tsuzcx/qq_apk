package c.t.m.g;

import android.content.Context;

public final class dp
{
  protected static volatile boolean a = false;
  private static volatile Context b;
  
  public static final Context a()
  {
    try
    {
      if (b != null)
      {
        Context localContext = b;
        return localContext;
      }
      throw new NullPointerException("u should init first.");
    }
    finally {}
  }
  
  public static final void a(Context paramContext)
  {
    try
    {
      if ((b != null) && (b.getApplicationContext() != null)) {
        break label52;
      }
      if ((paramContext == null) || (paramContext.getApplicationContext() == null)) {
        throw new NullPointerException("context cannot be null.");
      }
    }
    finally {}
    b = paramContext.getApplicationContext();
    label52:
  }
  
  public static final void b()
  {
    a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     c.t.m.g.dp
 * JD-Core Version:    0.7.0.1
 */