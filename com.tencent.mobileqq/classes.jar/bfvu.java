public class bfvu
{
  /* Error */
  public static int a(java.lang.String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: ldc 10
    //   5: invokevirtual 16	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   8: astore_0
    //   9: iconst_0
    //   10: istore_1
    //   11: iload_1
    //   12: istore_3
    //   13: iload_2
    //   14: aload_0
    //   15: arraylength
    //   16: if_icmpge +51 -> 67
    //   19: iload_1
    //   20: i2l
    //   21: lstore 4
    //   23: iconst_3
    //   24: iload_2
    //   25: isub
    //   26: i2l
    //   27: lstore 6
    //   29: aload_0
    //   30: iload_2
    //   31: aaload
    //   32: invokestatic 22	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   35: lstore 8
    //   37: lload 4
    //   39: ldc2_w 23
    //   42: lload 6
    //   44: lload 8
    //   46: lmul
    //   47: lxor
    //   48: ladd
    //   49: l2i
    //   50: istore_1
    //   51: iload_2
    //   52: iconst_1
    //   53: iadd
    //   54: istore_2
    //   55: goto -44 -> 11
    //   58: astore_0
    //   59: iconst_0
    //   60: istore_1
    //   61: aload_0
    //   62: invokevirtual 28	java/lang/Exception:printStackTrace	()V
    //   65: iload_1
    //   66: istore_3
    //   67: iload_3
    //   68: ireturn
    //   69: astore_0
    //   70: goto -9 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	paramString	java.lang.String
    //   10	56	1	i	int
    //   1	54	2	j	int
    //   12	56	3	k	int
    //   21	17	4	l1	long
    //   27	16	6	l2	long
    //   35	10	8	l3	long
    // Exception table:
    //   from	to	target	type
    //   2	9	58	java/lang/Exception
    //   13	19	69	java/lang/Exception
    //   29	37	69	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfvu
 * JD-Core Version:    0.7.0.1
 */