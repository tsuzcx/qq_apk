package com.tencent.ditto.widget.text;

import android.os.Build.VERSION;
import android.text.StaticLayout;
import java.lang.reflect.Constructor;

public class StaticLayoutWithMaxLines
{
  private static final boolean DEG = false;
  private static final String TAG = "StaticLayoutWithMaxLines";
  private static final String TEXT_DIRS_CLASS = "android.text.TextDirectionHeuristics";
  private static final String TEXT_DIR_CLASS = "android.text.TextDirectionHeuristic";
  private static final String TEXT_DIR_FIRST_STRONG_LTR = "FIRSTSTRONG_LTR";
  private static Constructor<StaticLayout> sConstructor;
  private static Object[] sConstructorArgs;
  private static boolean sInitialized;
  private static Object sTextDirection;
  
  /* Error */
  public static StaticLayout create(java.lang.CharSequence paramCharSequence, int paramInt1, int paramInt2, android.text.TextPaint paramTextPaint, int paramInt3, android.text.Layout.Alignment paramAlignment, float paramFloat1, float paramFloat2, boolean paramBoolean, android.text.TextUtils.TruncateAt paramTruncateAt, int paramInt4, int paramInt5)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 41	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:ensureInitialized	()V
    //   6: getstatic 43	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   9: iconst_0
    //   10: aload_0
    //   11: aastore
    //   12: getstatic 43	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   15: iconst_1
    //   16: iload_1
    //   17: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   20: aastore
    //   21: getstatic 43	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   24: iconst_2
    //   25: iload_2
    //   26: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   29: aastore
    //   30: getstatic 43	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   33: iconst_3
    //   34: aload_3
    //   35: aastore
    //   36: getstatic 43	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   39: iconst_4
    //   40: iload 4
    //   42: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: aastore
    //   46: getstatic 43	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   49: iconst_5
    //   50: aload 5
    //   52: aastore
    //   53: getstatic 43	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   56: bipush 6
    //   58: getstatic 51	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sTextDirection	Ljava/lang/Object;
    //   61: aastore
    //   62: getstatic 43	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   65: bipush 7
    //   67: fload 6
    //   69: invokestatic 56	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   72: aastore
    //   73: getstatic 43	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   76: bipush 8
    //   78: fload 7
    //   80: invokestatic 56	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   83: aastore
    //   84: getstatic 43	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   87: bipush 9
    //   89: iload 8
    //   91: invokestatic 61	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   94: aastore
    //   95: getstatic 43	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   98: bipush 10
    //   100: aload 9
    //   102: aastore
    //   103: getstatic 43	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   106: bipush 11
    //   108: iload 10
    //   110: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   113: aastore
    //   114: getstatic 43	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   117: bipush 12
    //   119: iload 11
    //   121: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   124: aastore
    //   125: getstatic 63	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructor	Ljava/lang/reflect/Constructor;
    //   128: getstatic 43	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   131: invokevirtual 69	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   134: checkcast 71	android/text/StaticLayout
    //   137: astore_0
    //   138: ldc 2
    //   140: monitorexit
    //   141: aload_0
    //   142: areturn
    //   143: astore_0
    //   144: new 73	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   151: astore_3
    //   152: aload_3
    //   153: ldc 76
    //   155: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_3
    //   160: aload_0
    //   161: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: new 85	java/lang/IllegalStateException
    //   168: dup
    //   169: aload_3
    //   170: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokespecial 92	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
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
  @android.annotation.TargetApi(18)
  public static void ensureInitialized()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 105	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sInitialized	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: getstatic 111	android/os/Build$VERSION:SDK_INT	I
    //   18: bipush 18
    //   20: if_icmplt +15 -> 35
    //   23: ldc 113
    //   25: astore_1
    //   26: getstatic 118	android/text/TextDirectionHeuristics:FIRSTSTRONG_LTR	Landroid/text/TextDirectionHeuristic;
    //   29: putstatic 51	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sTextDirection	Ljava/lang/Object;
    //   32: goto +55 -> 87
    //   35: ldc 2
    //   37: invokevirtual 124	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   40: astore_2
    //   41: aload_2
    //   42: astore_1
    //   43: aload_2
    //   44: ifnonnull +7 -> 51
    //   47: invokestatic 129	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   50: astore_1
    //   51: aload_1
    //   52: ifnull +233 -> 285
    //   55: aload_1
    //   56: ldc 17
    //   58: invokestatic 135	com/tencent/ditto/utils/ClassLoadUtils:load	(Ljava/lang/ClassLoader;Ljava/lang/String;)Ljava/lang/Class;
    //   61: astore_2
    //   62: aload_1
    //   63: ldc 14
    //   65: invokestatic 135	com/tencent/ditto/utils/ClassLoadUtils:load	(Ljava/lang/ClassLoader;Ljava/lang/String;)Ljava/lang/Class;
    //   68: astore_1
    //   69: aload_1
    //   70: ldc 20
    //   72: invokevirtual 139	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   75: aload_1
    //   76: invokevirtual 145	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   79: putstatic 51	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sTextDirection	Ljava/lang/Object;
    //   82: aload_2
    //   83: astore_1
    //   84: goto +3 -> 87
    //   87: bipush 13
    //   89: anewarray 120	java/lang/Class
    //   92: astore_2
    //   93: aload_2
    //   94: iconst_0
    //   95: ldc 147
    //   97: aastore
    //   98: aload_2
    //   99: iconst_1
    //   100: getstatic 151	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   103: aastore
    //   104: aload_2
    //   105: iconst_2
    //   106: getstatic 151	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   109: aastore
    //   110: aload_2
    //   111: iconst_3
    //   112: ldc 153
    //   114: aastore
    //   115: aload_2
    //   116: iconst_4
    //   117: getstatic 151	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   120: aastore
    //   121: aload_2
    //   122: iconst_5
    //   123: ldc 155
    //   125: aastore
    //   126: aload_2
    //   127: bipush 6
    //   129: aload_1
    //   130: aastore
    //   131: aload_2
    //   132: bipush 7
    //   134: getstatic 156	java/lang/Float:TYPE	Ljava/lang/Class;
    //   137: aastore
    //   138: aload_2
    //   139: bipush 8
    //   141: getstatic 156	java/lang/Float:TYPE	Ljava/lang/Class;
    //   144: aastore
    //   145: aload_2
    //   146: bipush 9
    //   148: getstatic 157	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   151: aastore
    //   152: aload_2
    //   153: bipush 10
    //   155: ldc 159
    //   157: aastore
    //   158: aload_2
    //   159: bipush 11
    //   161: getstatic 151	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   164: aastore
    //   165: aload_2
    //   166: bipush 12
    //   168: getstatic 151	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   171: aastore
    //   172: ldc 71
    //   174: aload_2
    //   175: invokevirtual 163	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   178: putstatic 63	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructor	Ljava/lang/reflect/Constructor;
    //   181: getstatic 63	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructor	Ljava/lang/reflect/Constructor;
    //   184: iconst_1
    //   185: invokevirtual 167	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   188: aload_2
    //   189: arraylength
    //   190: anewarray 4	java/lang/Object
    //   193: putstatic 43	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   196: iconst_1
    //   197: putstatic 105	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sInitialized	Z
    //   200: goto +63 -> 263
    //   203: astore_1
    //   204: goto +63 -> 267
    //   207: astore_1
    //   208: getstatic 169	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:TAG	Ljava/lang/String;
    //   211: ldc 171
    //   213: aload_1
    //   214: invokestatic 177	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   217: pop
    //   218: goto -22 -> 196
    //   221: astore_1
    //   222: getstatic 169	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:TAG	Ljava/lang/String;
    //   225: ldc 179
    //   227: aload_1
    //   228: invokestatic 177	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   231: pop
    //   232: goto -36 -> 196
    //   235: astore_1
    //   236: getstatic 169	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:TAG	Ljava/lang/String;
    //   239: ldc 181
    //   241: aload_1
    //   242: invokestatic 177	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   245: pop
    //   246: goto -50 -> 196
    //   249: astore_1
    //   250: getstatic 169	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:TAG	Ljava/lang/String;
    //   253: ldc 183
    //   255: aload_1
    //   256: invokestatic 177	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   259: pop
    //   260: goto -64 -> 196
    //   263: ldc 2
    //   265: monitorexit
    //   266: return
    //   267: iconst_1
    //   268: putstatic 105	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sInitialized	Z
    //   271: aload_1
    //   272: athrow
    //   273: astore_1
    //   274: ldc 2
    //   276: monitorexit
    //   277: goto +5 -> 282
    //   280: aload_1
    //   281: athrow
    //   282: goto -2 -> 280
    //   285: aconst_null
    //   286: astore_1
    //   287: goto -200 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   25	105	1	localObject1	Object
    //   203	1	1	localObject2	Object
    //   207	7	1	localIllegalAccessException	java.lang.IllegalAccessException
    //   221	7	1	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   235	7	1	localClassNotFoundException	java.lang.ClassNotFoundException
    //   249	23	1	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   273	8	1	localObject3	Object
    //   286	1	1	localObject4	Object
    //   40	149	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   15	23	203	finally
    //   26	32	203	finally
    //   35	41	203	finally
    //   47	51	203	finally
    //   55	82	203	finally
    //   87	93	203	finally
    //   98	110	203	finally
    //   115	121	203	finally
    //   131	152	203	finally
    //   158	196	203	finally
    //   208	218	203	finally
    //   222	232	203	finally
    //   236	246	203	finally
    //   250	260	203	finally
    //   15	23	207	java/lang/IllegalAccessException
    //   26	32	207	java/lang/IllegalAccessException
    //   35	41	207	java/lang/IllegalAccessException
    //   47	51	207	java/lang/IllegalAccessException
    //   55	82	207	java/lang/IllegalAccessException
    //   87	93	207	java/lang/IllegalAccessException
    //   98	110	207	java/lang/IllegalAccessException
    //   115	121	207	java/lang/IllegalAccessException
    //   131	152	207	java/lang/IllegalAccessException
    //   158	196	207	java/lang/IllegalAccessException
    //   15	23	221	java/lang/NoSuchFieldException
    //   26	32	221	java/lang/NoSuchFieldException
    //   35	41	221	java/lang/NoSuchFieldException
    //   47	51	221	java/lang/NoSuchFieldException
    //   55	82	221	java/lang/NoSuchFieldException
    //   87	93	221	java/lang/NoSuchFieldException
    //   98	110	221	java/lang/NoSuchFieldException
    //   115	121	221	java/lang/NoSuchFieldException
    //   131	152	221	java/lang/NoSuchFieldException
    //   158	196	221	java/lang/NoSuchFieldException
    //   15	23	235	java/lang/ClassNotFoundException
    //   26	32	235	java/lang/ClassNotFoundException
    //   35	41	235	java/lang/ClassNotFoundException
    //   47	51	235	java/lang/ClassNotFoundException
    //   55	82	235	java/lang/ClassNotFoundException
    //   87	93	235	java/lang/ClassNotFoundException
    //   98	110	235	java/lang/ClassNotFoundException
    //   115	121	235	java/lang/ClassNotFoundException
    //   131	152	235	java/lang/ClassNotFoundException
    //   158	196	235	java/lang/ClassNotFoundException
    //   15	23	249	java/lang/NoSuchMethodException
    //   26	32	249	java/lang/NoSuchMethodException
    //   35	41	249	java/lang/NoSuchMethodException
    //   47	51	249	java/lang/NoSuchMethodException
    //   55	82	249	java/lang/NoSuchMethodException
    //   87	93	249	java/lang/NoSuchMethodException
    //   98	110	249	java/lang/NoSuchMethodException
    //   115	121	249	java/lang/NoSuchMethodException
    //   131	152	249	java/lang/NoSuchMethodException
    //   158	196	249	java/lang/NoSuchMethodException
    //   3	7	273	finally
    //   196	200	273	finally
    //   267	273	273	finally
  }
  
  public static boolean isSupported()
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (i < 14) {
      return false;
    }
    ensureInitialized();
    if (sConstructor != null) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ditto.widget.text.StaticLayoutWithMaxLines
 * JD-Core Version:    0.7.0.1
 */