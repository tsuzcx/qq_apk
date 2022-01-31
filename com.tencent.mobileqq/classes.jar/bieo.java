public class bieo
  implements Cloneable
{
  public int a;
  public int b;
  public int c;
  public int d;
  
  /* Error */
  public bieo a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 23	java/lang/Object:clone	()Ljava/lang/Object;
    //   6: checkcast 2	bieo
    //   9: astore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: aload_1
    //   13: areturn
    //   14: astore_1
    //   15: aconst_null
    //   16: astore_1
    //   17: goto -7 -> 10
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	bieo
    //   9	4	1	localbieo	bieo
    //   14	1	1	localCloneNotSupportedException	java.lang.CloneNotSupportedException
    //   16	1	1	localObject1	Object
    //   20	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	14	java/lang/CloneNotSupportedException
    //   2	10	20	finally
  }
  
  public bieo a(biem parambiem, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2) {
      switch (paramInt1)
      {
      case 4: 
      default: 
        switch (paramInt2)
        {
        }
        break;
      }
    }
    for (;;)
    {
      try
      {
        parambiem = a();
        return parambiem;
      }
      finally {}
      this.a -= 1;
      break;
      this.b -= 1;
      break;
      this.c -= 1;
      break;
      this.d -= 1;
      break;
      this.a += 1;
      continue;
      this.b += 1;
      continue;
      this.c += 1;
      continue;
      this.d += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bieo
 * JD-Core Version:    0.7.0.1
 */