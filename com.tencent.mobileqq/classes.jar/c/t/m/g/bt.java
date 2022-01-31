package c.t.m.g;

final class bt
  implements Runnable
{
  bt(bo parambo) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: invokestatic 24	c/t/m/g/o:e	()V
    //   3: invokestatic 28	c/t/m/g/o:b	()Ljava/lang/String;
    //   6: astore 4
    //   8: aload_0
    //   9: getfield 12	c/t/m/g/bt:a	Lc/t/m/g/bo;
    //   12: aload 4
    //   14: invokestatic 33	c/t/m/g/bo:a	(Lc/t/m/g/bo;Ljava/lang/String;)Lc/t/m/g/bo$a;
    //   17: astore 4
    //   19: invokestatic 39	android/os/SystemClock:elapsedRealtime	()J
    //   22: lstore_2
    //   23: aload_0
    //   24: getfield 12	c/t/m/g/bt:a	Lc/t/m/g/bo;
    //   27: astore 5
    //   29: aload 4
    //   31: getfield 44	c/t/m/g/bo$a:b	I
    //   34: invokestatic 47	c/t/m/g/bo:b	(I)I
    //   37: istore_1
    //   38: lload_2
    //   39: aload 4
    //   41: getfield 50	c/t/m/g/bo$a:a	J
    //   44: lsub
    //   45: iload_1
    //   46: i2l
    //   47: lcmp
    //   48: ifle +38 -> 86
    //   51: aload_0
    //   52: getfield 12	c/t/m/g/bt:a	Lc/t/m/g/bo;
    //   55: invokestatic 53	c/t/m/g/bo:b	(Lc/t/m/g/bo;)Landroid/os/Handler;
    //   58: aload_0
    //   59: getfield 12	c/t/m/g/bt:a	Lc/t/m/g/bo;
    //   62: invokestatic 56	c/t/m/g/bo:a	(Lc/t/m/g/bo;)Ljava/lang/Runnable;
    //   65: invokevirtual 62	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   68: aload_0
    //   69: getfield 12	c/t/m/g/bt:a	Lc/t/m/g/bo;
    //   72: invokestatic 53	c/t/m/g/bo:b	(Lc/t/m/g/bo;)Landroid/os/Handler;
    //   75: aload_0
    //   76: getfield 12	c/t/m/g/bt:a	Lc/t/m/g/bo;
    //   79: invokestatic 56	c/t/m/g/bo:a	(Lc/t/m/g/bo;)Ljava/lang/Runnable;
    //   82: invokevirtual 66	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   85: pop
    //   86: return
    //   87: astore 4
    //   89: aload 4
    //   91: athrow
    //   92: astore 4
    //   94: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	bt
    //   37	9	1	i	int
    //   22	17	2	l	long
    //   6	34	4	localObject1	Object
    //   87	3	4	localObject2	Object
    //   92	1	4	localThrowable	java.lang.Throwable
    //   27	1	5	localbo	bo
    // Exception table:
    //   from	to	target	type
    //   0	86	87	finally
    //   0	86	92	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.bt
 * JD-Core Version:    0.7.0.1
 */