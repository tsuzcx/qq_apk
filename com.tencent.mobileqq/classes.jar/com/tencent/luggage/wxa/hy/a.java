package com.tencent.luggage.wxa.hy;

import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import java.lang.reflect.Constructor;

public class a
{
  private static boolean a;
  private static boolean b;
  private static Constructor<StaticLayout> c;
  private static Object d;
  
  public static StaticLayout a(CharSequence paramCharSequence, int paramInt1, int paramInt2, TextPaint paramTextPaint, int paramInt3, Layout.Alignment paramAlignment, float paramFloat1, float paramFloat2, boolean paramBoolean, TextUtils.TruncateAt paramTruncateAt, int paramInt4, int paramInt5)
  {
    try
    {
      a();
      boolean bool = b;
      if (!bool) {
        try
        {
          Object localObject = d;
          paramCharSequence = (StaticLayout)c.newInstance(new Object[] { paramCharSequence, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramTextPaint, Integer.valueOf(paramInt3), paramAlignment, localObject, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Boolean.valueOf(paramBoolean), paramTruncateAt, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
          return paramCharSequence;
        }
        catch (Exception paramCharSequence)
        {
          paramTextPaint = new StringBuilder();
          paramTextPaint.append("Error creating StaticLayout with max lines: ");
          paramTextPaint.append(paramCharSequence.getCause());
          throw new IllegalStateException(paramTextPaint.toString());
        }
      }
      throw new IllegalStateException("initialize error, cannot create StaticLayout");
    }
    finally {}
  }
  
  public static StaticLayout a(CharSequence paramCharSequence, int paramInt1, int paramInt2, TextPaint paramTextPaint, int paramInt3, Layout.Alignment paramAlignment, TextDirectionHeuristic paramTextDirectionHeuristic, float paramFloat1, float paramFloat2, boolean paramBoolean, TextUtils.TruncateAt paramTruncateAt, int paramInt4, int paramInt5)
  {
    try
    {
      a();
      boolean bool = b;
      if (!bool) {
        try
        {
          paramCharSequence = (StaticLayout)c.newInstance(new Object[] { paramCharSequence, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramTextPaint, Integer.valueOf(paramInt3), paramAlignment, paramTextDirectionHeuristic, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Boolean.valueOf(paramBoolean), paramTruncateAt, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
          return paramCharSequence;
        }
        catch (Exception paramCharSequence)
        {
          paramTextPaint = new StringBuilder();
          paramTextPaint.append("Error creating StaticLayout with max lines: ");
          paramTextPaint.append(paramCharSequence.getCause());
          throw new IllegalStateException(paramTextPaint.toString());
        }
      }
      throw new IllegalStateException("initialize error, cannot create StaticLayout");
    }
    finally {}
  }
  
  /* Error */
  @android.annotation.TargetApi(18)
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 93	com/tencent/luggage/wxa/hy/a:a	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: getstatic 99	android/os/Build$VERSION:SDK_INT	I
    //   18: bipush 18
    //   20: if_icmplt +15 -> 35
    //   23: ldc 101
    //   25: astore_1
    //   26: getstatic 107	android/text/TextDirectionHeuristics:FIRSTSTRONG_LTR	Landroid/text/TextDirectionHeuristic;
    //   29: putstatic 26	com/tencent/luggage/wxa/hy/a:d	Ljava/lang/Object;
    //   32: goto +36 -> 68
    //   35: ldc 2
    //   37: invokevirtual 113	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   40: astore_2
    //   41: aload_2
    //   42: ldc 115
    //   44: invokevirtual 121	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   47: astore_1
    //   48: aload_2
    //   49: ldc 123
    //   51: invokevirtual 121	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   54: astore_2
    //   55: aload_2
    //   56: ldc 124
    //   58: invokevirtual 128	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   61: aload_2
    //   62: invokevirtual 134	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   65: putstatic 26	com/tencent/luggage/wxa/hy/a:d	Ljava/lang/Object;
    //   68: ldc 52
    //   70: bipush 13
    //   72: anewarray 109	java/lang/Class
    //   75: dup
    //   76: iconst_0
    //   77: ldc 136
    //   79: aastore
    //   80: dup
    //   81: iconst_1
    //   82: getstatic 140	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   85: aastore
    //   86: dup
    //   87: iconst_2
    //   88: getstatic 140	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   91: aastore
    //   92: dup
    //   93: iconst_3
    //   94: ldc 142
    //   96: aastore
    //   97: dup
    //   98: iconst_4
    //   99: getstatic 140	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   102: aastore
    //   103: dup
    //   104: iconst_5
    //   105: ldc 144
    //   107: aastore
    //   108: dup
    //   109: bipush 6
    //   111: aload_1
    //   112: aastore
    //   113: dup
    //   114: bipush 7
    //   116: getstatic 145	java/lang/Float:TYPE	Ljava/lang/Class;
    //   119: aastore
    //   120: dup
    //   121: bipush 8
    //   123: getstatic 145	java/lang/Float:TYPE	Ljava/lang/Class;
    //   126: aastore
    //   127: dup
    //   128: bipush 9
    //   130: getstatic 146	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   133: aastore
    //   134: dup
    //   135: bipush 10
    //   137: ldc 148
    //   139: aastore
    //   140: dup
    //   141: bipush 11
    //   143: getstatic 140	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   146: aastore
    //   147: dup
    //   148: bipush 12
    //   150: getstatic 140	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   153: aastore
    //   154: invokevirtual 152	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   157: putstatic 28	com/tencent/luggage/wxa/hy/a:c	Ljava/lang/reflect/Constructor;
    //   160: getstatic 28	com/tencent/luggage/wxa/hy/a:c	Ljava/lang/reflect/Constructor;
    //   163: iconst_1
    //   164: invokevirtual 156	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   167: iconst_1
    //   168: putstatic 93	com/tencent/luggage/wxa/hy/a:a	Z
    //   171: goto +122 -> 293
    //   174: astore_1
    //   175: goto +154 -> 329
    //   178: astore_1
    //   179: ldc 158
    //   181: ldc 160
    //   183: iconst_1
    //   184: anewarray 4	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: aload_1
    //   190: aastore
    //   191: invokestatic 165	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   194: iconst_1
    //   195: putstatic 24	com/tencent/luggage/wxa/hy/a:b	Z
    //   198: goto -31 -> 167
    //   201: astore_1
    //   202: ldc 158
    //   204: ldc 167
    //   206: iconst_1
    //   207: anewarray 4	java/lang/Object
    //   210: dup
    //   211: iconst_0
    //   212: aload_1
    //   213: aastore
    //   214: invokestatic 165	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   217: iconst_1
    //   218: putstatic 24	com/tencent/luggage/wxa/hy/a:b	Z
    //   221: goto -54 -> 167
    //   224: astore_1
    //   225: ldc 158
    //   227: ldc 169
    //   229: iconst_1
    //   230: anewarray 4	java/lang/Object
    //   233: dup
    //   234: iconst_0
    //   235: aload_1
    //   236: aastore
    //   237: invokestatic 165	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   240: iconst_1
    //   241: putstatic 24	com/tencent/luggage/wxa/hy/a:b	Z
    //   244: goto -77 -> 167
    //   247: astore_1
    //   248: ldc 158
    //   250: ldc 171
    //   252: iconst_1
    //   253: anewarray 4	java/lang/Object
    //   256: dup
    //   257: iconst_0
    //   258: aload_1
    //   259: aastore
    //   260: invokestatic 165	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: iconst_1
    //   264: putstatic 24	com/tencent/luggage/wxa/hy/a:b	Z
    //   267: goto -100 -> 167
    //   270: astore_1
    //   271: ldc 158
    //   273: ldc 173
    //   275: iconst_1
    //   276: anewarray 4	java/lang/Object
    //   279: dup
    //   280: iconst_0
    //   281: aload_1
    //   282: aastore
    //   283: invokestatic 165	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   286: iconst_1
    //   287: putstatic 24	com/tencent/luggage/wxa/hy/a:b	Z
    //   290: goto -123 -> 167
    //   293: new 54	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   300: astore_1
    //   301: aload_1
    //   302: ldc 175
    //   304: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload_1
    //   309: getstatic 24	com/tencent/luggage/wxa/hy/a:b	Z
    //   312: invokevirtual 178	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: ldc 158
    //   318: aload_1
    //   319: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 181	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: ldc 2
    //   327: monitorexit
    //   328: return
    //   329: iconst_1
    //   330: putstatic 93	com/tencent/luggage/wxa/hy/a:a	Z
    //   333: aload_1
    //   334: athrow
    //   335: astore_1
    //   336: ldc 2
    //   338: monitorexit
    //   339: goto +5 -> 344
    //   342: aload_1
    //   343: athrow
    //   344: goto -2 -> 342
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   25	87	1	localObject1	Object
    //   174	1	1	localObject2	Object
    //   178	12	1	localException	Exception
    //   201	12	1	localIllegalAccessException	java.lang.IllegalAccessException
    //   224	12	1	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   247	12	1	localClassNotFoundException	java.lang.ClassNotFoundException
    //   270	12	1	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   300	34	1	localStringBuilder	StringBuilder
    //   335	8	1	localObject3	Object
    //   40	22	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   15	23	174	finally
    //   26	32	174	finally
    //   35	68	174	finally
    //   68	167	174	finally
    //   179	198	174	finally
    //   202	221	174	finally
    //   225	244	174	finally
    //   248	267	174	finally
    //   271	290	174	finally
    //   15	23	178	java/lang/Exception
    //   26	32	178	java/lang/Exception
    //   35	68	178	java/lang/Exception
    //   68	167	178	java/lang/Exception
    //   15	23	201	java/lang/IllegalAccessException
    //   26	32	201	java/lang/IllegalAccessException
    //   35	68	201	java/lang/IllegalAccessException
    //   68	167	201	java/lang/IllegalAccessException
    //   15	23	224	java/lang/NoSuchFieldException
    //   26	32	224	java/lang/NoSuchFieldException
    //   35	68	224	java/lang/NoSuchFieldException
    //   68	167	224	java/lang/NoSuchFieldException
    //   15	23	247	java/lang/ClassNotFoundException
    //   26	32	247	java/lang/ClassNotFoundException
    //   35	68	247	java/lang/ClassNotFoundException
    //   68	167	247	java/lang/ClassNotFoundException
    //   15	23	270	java/lang/NoSuchMethodException
    //   26	32	270	java/lang/NoSuchMethodException
    //   35	68	270	java/lang/NoSuchMethodException
    //   68	167	270	java/lang/NoSuchMethodException
    //   3	7	335	finally
    //   167	171	335	finally
    //   293	325	335	finally
    //   329	335	335	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hy.a
 * JD-Core Version:    0.7.0.1
 */