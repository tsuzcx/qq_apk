package com.tencent.aelight.camera.aioeditor.capture.text;

import android.text.StaticLayout;
import java.lang.reflect.Constructor;

public class StaticLayoutWithMaxLines
{
  private static boolean a;
  private static Constructor<StaticLayout> b;
  private static Object[] c;
  private static Object d;
  
  /* Error */
  public static StaticLayout a(java.lang.CharSequence paramCharSequence, int paramInt1, int paramInt2, android.text.TextPaint paramTextPaint, int paramInt3, android.text.Layout.Alignment paramAlignment, float paramFloat1, float paramFloat2, boolean paramBoolean, android.text.TextUtils.TruncateAt paramTruncateAt, int paramInt4, int paramInt5)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 23	com/tencent/aelight/camera/aioeditor/capture/text/StaticLayoutWithMaxLines:a	()V
    //   6: getstatic 25	com/tencent/aelight/camera/aioeditor/capture/text/StaticLayoutWithMaxLines:c	[Ljava/lang/Object;
    //   9: iconst_0
    //   10: aload_0
    //   11: aastore
    //   12: getstatic 25	com/tencent/aelight/camera/aioeditor/capture/text/StaticLayoutWithMaxLines:c	[Ljava/lang/Object;
    //   15: iconst_1
    //   16: iload_1
    //   17: invokestatic 31	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   20: aastore
    //   21: getstatic 25	com/tencent/aelight/camera/aioeditor/capture/text/StaticLayoutWithMaxLines:c	[Ljava/lang/Object;
    //   24: iconst_2
    //   25: iload_2
    //   26: invokestatic 31	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   29: aastore
    //   30: getstatic 25	com/tencent/aelight/camera/aioeditor/capture/text/StaticLayoutWithMaxLines:c	[Ljava/lang/Object;
    //   33: iconst_3
    //   34: aload_3
    //   35: aastore
    //   36: getstatic 25	com/tencent/aelight/camera/aioeditor/capture/text/StaticLayoutWithMaxLines:c	[Ljava/lang/Object;
    //   39: iconst_4
    //   40: iload 4
    //   42: invokestatic 31	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: aastore
    //   46: getstatic 25	com/tencent/aelight/camera/aioeditor/capture/text/StaticLayoutWithMaxLines:c	[Ljava/lang/Object;
    //   49: iconst_5
    //   50: aload 5
    //   52: aastore
    //   53: getstatic 25	com/tencent/aelight/camera/aioeditor/capture/text/StaticLayoutWithMaxLines:c	[Ljava/lang/Object;
    //   56: bipush 6
    //   58: getstatic 33	com/tencent/aelight/camera/aioeditor/capture/text/StaticLayoutWithMaxLines:d	Ljava/lang/Object;
    //   61: aastore
    //   62: getstatic 25	com/tencent/aelight/camera/aioeditor/capture/text/StaticLayoutWithMaxLines:c	[Ljava/lang/Object;
    //   65: bipush 7
    //   67: fload 6
    //   69: invokestatic 38	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   72: aastore
    //   73: getstatic 25	com/tencent/aelight/camera/aioeditor/capture/text/StaticLayoutWithMaxLines:c	[Ljava/lang/Object;
    //   76: bipush 8
    //   78: fload 7
    //   80: invokestatic 38	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   83: aastore
    //   84: getstatic 25	com/tencent/aelight/camera/aioeditor/capture/text/StaticLayoutWithMaxLines:c	[Ljava/lang/Object;
    //   87: bipush 9
    //   89: iload 8
    //   91: invokestatic 43	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   94: aastore
    //   95: getstatic 25	com/tencent/aelight/camera/aioeditor/capture/text/StaticLayoutWithMaxLines:c	[Ljava/lang/Object;
    //   98: bipush 10
    //   100: aload 9
    //   102: aastore
    //   103: getstatic 25	com/tencent/aelight/camera/aioeditor/capture/text/StaticLayoutWithMaxLines:c	[Ljava/lang/Object;
    //   106: bipush 11
    //   108: iload 10
    //   110: invokestatic 31	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   113: aastore
    //   114: getstatic 25	com/tencent/aelight/camera/aioeditor/capture/text/StaticLayoutWithMaxLines:c	[Ljava/lang/Object;
    //   117: bipush 12
    //   119: iload 11
    //   121: invokestatic 31	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   124: aastore
    //   125: getstatic 45	com/tencent/aelight/camera/aioeditor/capture/text/StaticLayoutWithMaxLines:b	Ljava/lang/reflect/Constructor;
    //   128: getstatic 25	com/tencent/aelight/camera/aioeditor/capture/text/StaticLayoutWithMaxLines:c	[Ljava/lang/Object;
    //   131: invokevirtual 51	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   134: checkcast 53	android/text/StaticLayout
    //   137: astore_0
    //   138: ldc 2
    //   140: monitorexit
    //   141: aload_0
    //   142: areturn
    //   143: astore_0
    //   144: new 55	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   151: astore_3
    //   152: aload_3
    //   153: ldc 58
    //   155: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_3
    //   160: aload_0
    //   161: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: new 67	java/lang/IllegalStateException
    //   168: dup
    //   169: aload_3
    //   170: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokespecial 74	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   176: athrow
    //   177: astore_0
    //   178: ldc 2
    //   180: monitorexit
    //   181: aload_0
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	paramCharSequence	java.lang.CharSequence
    //   0	183	1	paramInt1	int
    //   0	183	2	paramInt2	int
    //   0	183	3	paramTextPaint	android.text.TextPaint
    //   0	183	4	paramInt3	int
    //   0	183	5	paramAlignment	android.text.Layout.Alignment
    //   0	183	6	paramFloat1	float
    //   0	183	7	paramFloat2	float
    //   0	183	8	paramBoolean	boolean
    //   0	183	9	paramTruncateAt	android.text.TextUtils.TruncateAt
    //   0	183	10	paramInt4	int
    //   0	183	11	paramInt5	int
    // Exception table:
    //   from	to	target	type
    //   6	138	143	java/lang/Exception
    //   3	6	177	finally
    //   6	138	177	finally
    //   144	177	177	finally
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 84	com/tencent/aelight/camera/aioeditor/capture/text/StaticLayoutWithMaxLines:a	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: getstatic 90	android/os/Build$VERSION:SDK_INT	I
    //   18: bipush 18
    //   20: if_icmplt +15 -> 35
    //   23: ldc 92
    //   25: astore_1
    //   26: getstatic 98	android/text/TextDirectionHeuristics:FIRSTSTRONG_LTR	Landroid/text/TextDirectionHeuristic;
    //   29: putstatic 33	com/tencent/aelight/camera/aioeditor/capture/text/StaticLayoutWithMaxLines:d	Ljava/lang/Object;
    //   32: goto +36 -> 68
    //   35: ldc 2
    //   37: invokevirtual 104	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   40: astore_2
    //   41: aload_2
    //   42: ldc 106
    //   44: invokevirtual 112	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   47: astore_1
    //   48: aload_2
    //   49: ldc 114
    //   51: invokevirtual 112	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   54: astore_2
    //   55: aload_2
    //   56: ldc 115
    //   58: invokevirtual 119	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   61: aload_2
    //   62: invokevirtual 125	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   65: putstatic 33	com/tencent/aelight/camera/aioeditor/capture/text/StaticLayoutWithMaxLines:d	Ljava/lang/Object;
    //   68: bipush 13
    //   70: anewarray 100	java/lang/Class
    //   73: astore_2
    //   74: aload_2
    //   75: iconst_0
    //   76: ldc 127
    //   78: aastore
    //   79: aload_2
    //   80: iconst_1
    //   81: getstatic 131	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   84: aastore
    //   85: aload_2
    //   86: iconst_2
    //   87: getstatic 131	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   90: aastore
    //   91: aload_2
    //   92: iconst_3
    //   93: ldc 133
    //   95: aastore
    //   96: aload_2
    //   97: iconst_4
    //   98: getstatic 131	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   101: aastore
    //   102: aload_2
    //   103: iconst_5
    //   104: ldc 135
    //   106: aastore
    //   107: aload_2
    //   108: bipush 6
    //   110: aload_1
    //   111: aastore
    //   112: aload_2
    //   113: bipush 7
    //   115: getstatic 136	java/lang/Float:TYPE	Ljava/lang/Class;
    //   118: aastore
    //   119: aload_2
    //   120: bipush 8
    //   122: getstatic 136	java/lang/Float:TYPE	Ljava/lang/Class;
    //   125: aastore
    //   126: aload_2
    //   127: bipush 9
    //   129: getstatic 137	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   132: aastore
    //   133: aload_2
    //   134: bipush 10
    //   136: ldc 139
    //   138: aastore
    //   139: aload_2
    //   140: bipush 11
    //   142: getstatic 131	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   145: aastore
    //   146: aload_2
    //   147: bipush 12
    //   149: getstatic 131	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   152: aastore
    //   153: ldc 53
    //   155: aload_2
    //   156: invokevirtual 143	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   159: putstatic 45	com/tencent/aelight/camera/aioeditor/capture/text/StaticLayoutWithMaxLines:b	Ljava/lang/reflect/Constructor;
    //   162: getstatic 45	com/tencent/aelight/camera/aioeditor/capture/text/StaticLayoutWithMaxLines:b	Ljava/lang/reflect/Constructor;
    //   165: iconst_1
    //   166: invokevirtual 147	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   169: aload_2
    //   170: arraylength
    //   171: anewarray 4	java/lang/Object
    //   174: putstatic 25	com/tencent/aelight/camera/aioeditor/capture/text/StaticLayoutWithMaxLines:c	[Ljava/lang/Object;
    //   177: iconst_1
    //   178: putstatic 84	com/tencent/aelight/camera/aioeditor/capture/text/StaticLayoutWithMaxLines:a	Z
    //   181: goto +59 -> 240
    //   184: astore_1
    //   185: goto +59 -> 244
    //   188: astore_1
    //   189: ldc 149
    //   191: ldc 151
    //   193: aload_1
    //   194: invokestatic 157	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   197: pop
    //   198: goto -21 -> 177
    //   201: astore_1
    //   202: ldc 149
    //   204: ldc 159
    //   206: aload_1
    //   207: invokestatic 157	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   210: pop
    //   211: goto -34 -> 177
    //   214: astore_1
    //   215: ldc 149
    //   217: ldc 161
    //   219: aload_1
    //   220: invokestatic 157	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   223: pop
    //   224: goto -47 -> 177
    //   227: astore_1
    //   228: ldc 149
    //   230: ldc 163
    //   232: aload_1
    //   233: invokestatic 157	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   236: pop
    //   237: goto -60 -> 177
    //   240: ldc 2
    //   242: monitorexit
    //   243: return
    //   244: iconst_1
    //   245: putstatic 84	com/tencent/aelight/camera/aioeditor/capture/text/StaticLayoutWithMaxLines:a	Z
    //   248: aload_1
    //   249: athrow
    //   250: astore_1
    //   251: ldc 2
    //   253: monitorexit
    //   254: goto +5 -> 259
    //   257: aload_1
    //   258: athrow
    //   259: goto -2 -> 257
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   25	86	1	localObject1	Object
    //   184	1	1	localObject2	Object
    //   188	6	1	localIllegalAccessException	java.lang.IllegalAccessException
    //   201	6	1	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   214	6	1	localClassNotFoundException	java.lang.ClassNotFoundException
    //   227	22	1	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   250	8	1	localObject3	Object
    //   40	130	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   15	23	184	finally
    //   26	32	184	finally
    //   35	68	184	finally
    //   68	74	184	finally
    //   79	91	184	finally
    //   96	102	184	finally
    //   112	133	184	finally
    //   139	177	184	finally
    //   189	198	184	finally
    //   202	211	184	finally
    //   215	224	184	finally
    //   228	237	184	finally
    //   15	23	188	java/lang/IllegalAccessException
    //   26	32	188	java/lang/IllegalAccessException
    //   35	68	188	java/lang/IllegalAccessException
    //   68	74	188	java/lang/IllegalAccessException
    //   79	91	188	java/lang/IllegalAccessException
    //   96	102	188	java/lang/IllegalAccessException
    //   112	133	188	java/lang/IllegalAccessException
    //   139	177	188	java/lang/IllegalAccessException
    //   15	23	201	java/lang/NoSuchFieldException
    //   26	32	201	java/lang/NoSuchFieldException
    //   35	68	201	java/lang/NoSuchFieldException
    //   68	74	201	java/lang/NoSuchFieldException
    //   79	91	201	java/lang/NoSuchFieldException
    //   96	102	201	java/lang/NoSuchFieldException
    //   112	133	201	java/lang/NoSuchFieldException
    //   139	177	201	java/lang/NoSuchFieldException
    //   15	23	214	java/lang/ClassNotFoundException
    //   26	32	214	java/lang/ClassNotFoundException
    //   35	68	214	java/lang/ClassNotFoundException
    //   68	74	214	java/lang/ClassNotFoundException
    //   79	91	214	java/lang/ClassNotFoundException
    //   96	102	214	java/lang/ClassNotFoundException
    //   112	133	214	java/lang/ClassNotFoundException
    //   139	177	214	java/lang/ClassNotFoundException
    //   15	23	227	java/lang/NoSuchMethodException
    //   26	32	227	java/lang/NoSuchMethodException
    //   35	68	227	java/lang/NoSuchMethodException
    //   68	74	227	java/lang/NoSuchMethodException
    //   79	91	227	java/lang/NoSuchMethodException
    //   96	102	227	java/lang/NoSuchMethodException
    //   112	133	227	java/lang/NoSuchMethodException
    //   139	177	227	java/lang/NoSuchMethodException
    //   3	7	250	finally
    //   177	181	250	finally
    //   244	250	250	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.StaticLayoutWithMaxLines
 * JD-Core Version:    0.7.0.1
 */