package c.t.m.g;

public final class dc
{
  private static final int[] c = { 31, 113, 239, 397, 439, 557, 619, 773, 853, 977 };
  public byte[] a;
  public byte[] b;
  private dc.a[] d;
  
  public dc()
  {
    this((byte)0);
  }
  
  public dc(byte paramByte)
  {
    paramByte = 0;
    this.a = new byte[0];
    this.d = new dc.a[Math.min(Math.max(1, 5), 10)];
    for (;;)
    {
      dc.a[] arrayOfa = this.d;
      if (paramByte >= arrayOfa.length) {
        break;
      }
      arrayOfa[paramByte] = new dc.a(c[paramByte]);
      paramByte += 1;
    }
    this.b = new byte[8192];
  }
  
  public final void a(String paramString)
  {
    synchronized (this.a)
    {
      dc.a[] arrayOfa = this.d;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        int k = arrayOfa[i].a(paramString);
        byte[] arrayOfByte2 = this.b;
        int m = k / 8;
        arrayOfByte2[m] = ((byte)(1 << k % 8 | arrayOfByte2[m]));
        i += 1;
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public final byte[] a()
  {
    synchronized (this.a)
    {
      byte[] arrayOfByte2 = this.b;
      return arrayOfByte2;
    }
  }
  
  /* Error */
  public final boolean b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	c/t/m/g/dc:a	[B
    //   4: astore 6
    //   6: aload 6
    //   8: monitorenter
    //   9: aload_1
    //   10: ifnonnull +8 -> 18
    //   13: aload 6
    //   15: monitorexit
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_0
    //   19: getfield 37	c/t/m/g/dc:d	[Lc/t/m/g/dc$a;
    //   22: astore 7
    //   24: aload 7
    //   26: arraylength
    //   27: istore 4
    //   29: iconst_0
    //   30: istore_2
    //   31: iconst_1
    //   32: istore_3
    //   33: iload_2
    //   34: iload 4
    //   36: if_icmpge +46 -> 82
    //   39: aload 7
    //   41: iload_2
    //   42: aaload
    //   43: aload_1
    //   44: invokevirtual 46	c/t/m/g/dc$a:a	(Ljava/lang/String;)I
    //   47: istore 5
    //   49: iconst_1
    //   50: iload 5
    //   52: bipush 8
    //   54: irem
    //   55: ishl
    //   56: aload_0
    //   57: getfield 42	c/t/m/g/dc:b	[B
    //   60: iload 5
    //   62: bipush 8
    //   64: idiv
    //   65: baload
    //   66: iand
    //   67: ifeq +32 -> 99
    //   70: goto +3 -> 73
    //   73: iload_3
    //   74: ifne +30 -> 104
    //   77: aload 6
    //   79: monitorexit
    //   80: iconst_0
    //   81: ireturn
    //   82: aload 6
    //   84: monitorexit
    //   85: iconst_1
    //   86: ireturn
    //   87: astore_1
    //   88: aload 6
    //   90: monitorexit
    //   91: goto +5 -> 96
    //   94: aload_1
    //   95: athrow
    //   96: goto -2 -> 94
    //   99: iconst_0
    //   100: istore_3
    //   101: goto -28 -> 73
    //   104: iload_2
    //   105: iconst_1
    //   106: iadd
    //   107: istore_2
    //   108: goto -77 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	dc
    //   0	111	1	paramString	String
    //   30	78	2	i	int
    //   32	69	3	j	int
    //   27	10	4	k	int
    //   47	18	5	m	int
    //   4	85	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   13	16	87	finally
    //   18	29	87	finally
    //   39	70	87	finally
    //   77	80	87	finally
    //   82	85	87	finally
    //   88	91	87	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.dc
 * JD-Core Version:    0.7.0.1
 */