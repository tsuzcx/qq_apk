package com.tencent.luggage.wxa.he;

import java.lang.reflect.Field;

public class b<T>
{
  private Object a;
  private String b;
  private boolean c;
  private Field d;
  private String e;
  
  public b(Object paramObject, String paramString1, String paramString2)
  {
    if (paramObject != null)
    {
      this.a = paramObject;
      this.b = paramString1;
      this.e = paramString2;
      return;
    }
    throw new IllegalArgumentException("obj cannot be null");
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 37	com/tencent/luggage/wxa/he/b:c	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: iconst_1
    //   10: putfield 37	com/tencent/luggage/wxa/he/b:c	Z
    //   13: aload_0
    //   14: getfield 21	com/tencent/luggage/wxa/he/b:a	Ljava/lang/Object;
    //   17: invokevirtual 41	java/lang/Object:getClass	()Ljava/lang/Class;
    //   20: astore_3
    //   21: aload_3
    //   22: ifnull +134 -> 156
    //   25: aload_3
    //   26: aload_0
    //   27: getfield 23	com/tencent/luggage/wxa/he/b:b	Ljava/lang/String;
    //   30: invokevirtual 47	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   33: astore 4
    //   35: aload 4
    //   37: iconst_1
    //   38: invokevirtual 53	java/lang/reflect/Field:setAccessible	(Z)V
    //   41: aload_0
    //   42: aload 4
    //   44: putfield 55	com/tencent/luggage/wxa/he/b:d	Ljava/lang/reflect/Field;
    //   47: aload_3
    //   48: invokevirtual 58	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   51: pop
    //   52: return
    //   53: astore 4
    //   55: goto +85 -> 140
    //   58: aload_0
    //   59: getfield 25	com/tencent/luggage/wxa/he/b:e	Ljava/lang/String;
    //   62: ifnull +86 -> 148
    //   65: aload_0
    //   66: getfield 25	com/tencent/luggage/wxa/he/b:e	Ljava/lang/String;
    //   69: ldc 60
    //   71: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   74: ifne +74 -> 148
    //   77: aload_3
    //   78: invokevirtual 70	java/lang/Class:getDeclaredFields	()[Ljava/lang/reflect/Field;
    //   81: astore 4
    //   83: aload 4
    //   85: arraylength
    //   86: istore_2
    //   87: iconst_0
    //   88: istore_1
    //   89: iload_1
    //   90: iload_2
    //   91: if_icmpge +57 -> 148
    //   94: aload 4
    //   96: iload_1
    //   97: aaload
    //   98: astore 5
    //   100: aload 5
    //   102: invokevirtual 73	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   105: invokevirtual 77	java/lang/Class:getName	()Ljava/lang/String;
    //   108: aload_0
    //   109: getfield 25	com/tencent/luggage/wxa/he/b:e	Ljava/lang/String;
    //   112: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   115: ifeq +18 -> 133
    //   118: aload 5
    //   120: iconst_1
    //   121: invokevirtual 53	java/lang/reflect/Field:setAccessible	(Z)V
    //   124: aload_0
    //   125: aload 5
    //   127: putfield 55	com/tencent/luggage/wxa/he/b:d	Ljava/lang/reflect/Field;
    //   130: goto +18 -> 148
    //   133: iload_1
    //   134: iconst_1
    //   135: iadd
    //   136: istore_1
    //   137: goto -48 -> 89
    //   140: aload_3
    //   141: invokevirtual 58	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   144: pop
    //   145: aload 4
    //   147: athrow
    //   148: aload_3
    //   149: invokevirtual 58	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   152: astore_3
    //   153: goto -132 -> 21
    //   156: return
    //   157: astore 4
    //   159: goto -101 -> 58
    //   162: astore 4
    //   164: goto -16 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	b
    //   88	49	1	i	int
    //   86	6	2	j	int
    //   20	133	3	localClass	java.lang.Class
    //   33	10	4	localField1	Field
    //   53	1	4	localObject	Object
    //   81	65	4	arrayOfField	Field[]
    //   157	1	4	localException1	java.lang.Exception
    //   162	1	4	localException2	java.lang.Exception
    //   98	28	5	localField2	Field
    // Exception table:
    //   from	to	target	type
    //   25	47	53	finally
    //   58	87	53	finally
    //   100	130	53	finally
    //   25	47	157	java/lang/Exception
    //   58	87	162	java/lang/Exception
    //   100	130	162	java/lang/Exception
  }
  
  public void a(T paramT)
  {
    a();
    Field localField = this.d;
    if (localField != null)
    {
      localField.set(this.a, paramT);
      return;
    }
    throw new NoSuchFieldException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.he.b
 * JD-Core Version:    0.7.0.1
 */