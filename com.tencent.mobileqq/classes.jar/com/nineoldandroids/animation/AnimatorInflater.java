package com.nineoldandroids.animation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.animation.AnimationUtils;
import org.xmlpull.v1.XmlPullParser;

public class AnimatorInflater
{
  private static final int[] Animator = { 16843073, 16843160, 16843198, 16843199, 16843200, 16843486, 16843487, 16843488 };
  private static final int[] AnimatorSet = { 16843490 };
  private static final int AnimatorSet_ordering = 0;
  private static final int Animator_duration = 1;
  private static final int Animator_interpolator = 0;
  private static final int Animator_repeatCount = 3;
  private static final int Animator_repeatMode = 4;
  private static final int Animator_startOffset = 2;
  private static final int Animator_valueFrom = 5;
  private static final int Animator_valueTo = 6;
  private static final int Animator_valueType = 7;
  private static final int[] PropertyAnimator = { 16843489 };
  private static final int PropertyAnimator_propertyName = 0;
  private static final int TOGETHER = 0;
  private static final int VALUE_TYPE_FLOAT = 0;
  
  private static Animator createAnimatorFromXml(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    return createAnimatorFromXml(paramContext, paramXmlPullParser, Xml.asAttributeSet(paramXmlPullParser), null, 0);
  }
  
  /* Error */
  private static Animator createAnimatorFromXml(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, AnimatorSet paramAnimatorSet, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_1
    //   4: invokeinterface 70 1 0
    //   9: istore 7
    //   11: aconst_null
    //   12: astore 9
    //   14: aconst_null
    //   15: astore 10
    //   17: aload_1
    //   18: invokeinterface 73 1 0
    //   23: istore 5
    //   25: iload 5
    //   27: iconst_3
    //   28: if_icmpne +14 -> 42
    //   31: aload_1
    //   32: invokeinterface 70 1 0
    //   37: iload 7
    //   39: if_icmple +9 -> 48
    //   42: iload 5
    //   44: iconst_1
    //   45: if_icmpne +53 -> 98
    //   48: aload_3
    //   49: ifnull +46 -> 95
    //   52: aload 9
    //   54: ifnull +41 -> 95
    //   57: aload 9
    //   59: invokevirtual 78	java/util/ArrayList:size	()I
    //   62: anewarray 80	com/nineoldandroids/animation/Animator
    //   65: astore_0
    //   66: aload 9
    //   68: invokevirtual 84	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   71: astore_1
    //   72: iload 6
    //   74: istore 5
    //   76: aload_1
    //   77: invokeinterface 90 1 0
    //   82: ifne +297 -> 379
    //   85: iload 4
    //   87: ifne +314 -> 401
    //   90: aload_3
    //   91: aload_0
    //   92: invokevirtual 96	com/nineoldandroids/animation/AnimatorSet:playTogether	([Lcom/nineoldandroids/animation/Animator;)V
    //   95: aload 10
    //   97: areturn
    //   98: iload 5
    //   100: iconst_2
    //   101: if_icmpne -84 -> 17
    //   104: aload_1
    //   105: invokeinterface 100 1 0
    //   110: astore 8
    //   112: aload 8
    //   114: ldc 102
    //   116: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   119: ifeq +47 -> 166
    //   122: aload_0
    //   123: aload_2
    //   124: invokestatic 112	com/nineoldandroids/animation/AnimatorInflater:loadObjectAnimator	(Landroid/content/Context;Landroid/util/AttributeSet;)Lcom/nineoldandroids/animation/ObjectAnimator;
    //   127: astore 8
    //   129: aload 8
    //   131: astore 10
    //   133: aload_3
    //   134: ifnull -117 -> 17
    //   137: aload 9
    //   139: ifnonnull +279 -> 418
    //   142: new 75	java/util/ArrayList
    //   145: dup
    //   146: invokespecial 113	java/util/ArrayList:<init>	()V
    //   149: astore 9
    //   151: aload 9
    //   153: aload 8
    //   155: invokevirtual 116	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   158: pop
    //   159: aload 8
    //   161: astore 10
    //   163: goto -146 -> 17
    //   166: aload 8
    //   168: ldc 118
    //   170: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   173: ifeq +14 -> 187
    //   176: aload_0
    //   177: aload_2
    //   178: aconst_null
    //   179: invokestatic 122	com/nineoldandroids/animation/AnimatorInflater:loadAnimator	(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/nineoldandroids/animation/ValueAnimator;)Lcom/nineoldandroids/animation/ValueAnimator;
    //   182: astore 8
    //   184: goto -55 -> 129
    //   187: aload 8
    //   189: ldc 124
    //   191: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   194: ifeq +156 -> 350
    //   197: new 92	com/nineoldandroids/animation/AnimatorSet
    //   200: dup
    //   201: invokespecial 125	com/nineoldandroids/animation/AnimatorSet:<init>	()V
    //   204: astore 12
    //   206: aload_0
    //   207: aload_2
    //   208: getstatic 34	com/nineoldandroids/animation/AnimatorInflater:AnimatorSet	[I
    //   211: invokevirtual 131	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   214: astore 10
    //   216: aload 10
    //   218: astore 8
    //   220: new 133	android/util/TypedValue
    //   223: dup
    //   224: invokespecial 134	android/util/TypedValue:<init>	()V
    //   227: astore 11
    //   229: aload 10
    //   231: astore 8
    //   233: aload 10
    //   235: iconst_0
    //   236: aload 11
    //   238: invokevirtual 140	android/content/res/TypedArray:getValue	(ILandroid/util/TypedValue;)Z
    //   241: pop
    //   242: aload 10
    //   244: astore 8
    //   246: aload 11
    //   248: getfield 143	android/util/TypedValue:type	I
    //   251: bipush 16
    //   253: if_icmpne +45 -> 298
    //   256: aload 10
    //   258: astore 8
    //   260: aload 11
    //   262: getfield 146	android/util/TypedValue:data	I
    //   265: istore 5
    //   267: aload 10
    //   269: ifnull +8 -> 277
    //   272: aload 10
    //   274: invokevirtual 149	android/content/res/TypedArray:recycle	()V
    //   277: aload_0
    //   278: aload_1
    //   279: aload_2
    //   280: aload 12
    //   282: checkcast 92	com/nineoldandroids/animation/AnimatorSet
    //   285: iload 5
    //   287: invokestatic 62	com/nineoldandroids/animation/AnimatorInflater:createAnimatorFromXml	(Landroid/content/Context;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Lcom/nineoldandroids/animation/AnimatorSet;I)Lcom/nineoldandroids/animation/Animator;
    //   290: pop
    //   291: aload 12
    //   293: astore 8
    //   295: goto -166 -> 129
    //   298: iconst_0
    //   299: istore 5
    //   301: goto -34 -> 267
    //   304: astore 11
    //   306: aconst_null
    //   307: astore 10
    //   309: aload 10
    //   311: astore 8
    //   313: aload 11
    //   315: invokevirtual 152	java/lang/Exception:printStackTrace	()V
    //   318: aload 10
    //   320: ifnull +101 -> 421
    //   323: aload 10
    //   325: invokevirtual 149	android/content/res/TypedArray:recycle	()V
    //   328: iconst_0
    //   329: istore 5
    //   331: goto -54 -> 277
    //   334: astore_0
    //   335: aconst_null
    //   336: astore 8
    //   338: aload 8
    //   340: ifnull +8 -> 348
    //   343: aload 8
    //   345: invokevirtual 149	android/content/res/TypedArray:recycle	()V
    //   348: aload_0
    //   349: athrow
    //   350: new 154	java/lang/RuntimeException
    //   353: dup
    //   354: new 156	java/lang/StringBuilder
    //   357: dup
    //   358: ldc 158
    //   360: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   363: aload_1
    //   364: invokeinterface 100 1 0
    //   369: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokespecial 169	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   378: athrow
    //   379: aload_0
    //   380: iload 5
    //   382: aload_1
    //   383: invokeinterface 172 1 0
    //   388: checkcast 80	com/nineoldandroids/animation/Animator
    //   391: aastore
    //   392: iload 5
    //   394: iconst_1
    //   395: iadd
    //   396: istore 5
    //   398: goto -322 -> 76
    //   401: aload_3
    //   402: aload_0
    //   403: invokevirtual 175	com/nineoldandroids/animation/AnimatorSet:playSequentially	([Lcom/nineoldandroids/animation/Animator;)V
    //   406: aload 10
    //   408: areturn
    //   409: astore_0
    //   410: goto -72 -> 338
    //   413: astore 11
    //   415: goto -106 -> 309
    //   418: goto -267 -> 151
    //   421: iconst_0
    //   422: istore 5
    //   424: goto -147 -> 277
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	427	0	paramContext	Context
    //   0	427	1	paramXmlPullParser	XmlPullParser
    //   0	427	2	paramAttributeSet	AttributeSet
    //   0	427	3	paramAnimatorSet	AnimatorSet
    //   0	427	4	paramInt	int
    //   23	400	5	i	int
    //   1	72	6	j	int
    //   9	31	7	k	int
    //   110	234	8	localObject1	Object
    //   12	140	9	localArrayList	java.util.ArrayList
    //   15	392	10	localObject2	Object
    //   227	34	11	localTypedValue	TypedValue
    //   304	10	11	localException1	java.lang.Exception
    //   413	1	11	localException2	java.lang.Exception
    //   204	88	12	localAnimatorSet	AnimatorSet
    // Exception table:
    //   from	to	target	type
    //   206	216	304	java/lang/Exception
    //   206	216	334	finally
    //   220	229	409	finally
    //   233	242	409	finally
    //   246	256	409	finally
    //   260	267	409	finally
    //   313	318	409	finally
    //   220	229	413	java/lang/Exception
    //   233	242	413	java/lang/Exception
    //   246	256	413	java/lang/Exception
    //   260	267	413	java/lang/Exception
  }
  
  /* Error */
  public static Animator loadAnimator(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore_3
    //   7: aload_0
    //   8: invokevirtual 184	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   11: iload_1
    //   12: invokevirtual 190	android/content/res/Resources:getAnimation	(I)Landroid/content/res/XmlResourceParser;
    //   15: astore 5
    //   17: aload 5
    //   19: astore_3
    //   20: aload 5
    //   22: astore_2
    //   23: aload 5
    //   25: astore 4
    //   27: aload_0
    //   28: aload 5
    //   30: invokestatic 192	com/nineoldandroids/animation/AnimatorInflater:createAnimatorFromXml	(Landroid/content/Context;Lorg/xmlpull/v1/XmlPullParser;)Lcom/nineoldandroids/animation/Animator;
    //   33: astore_0
    //   34: aload 5
    //   36: ifnull +10 -> 46
    //   39: aload 5
    //   41: invokeinterface 197 1 0
    //   46: aload_0
    //   47: areturn
    //   48: astore_0
    //   49: aload_3
    //   50: astore_2
    //   51: new 199	android/content/res/Resources$NotFoundException
    //   54: dup
    //   55: new 156	java/lang/StringBuilder
    //   58: dup
    //   59: ldc 201
    //   61: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   64: iload_1
    //   65: invokestatic 207	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   68: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokespecial 208	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   77: astore 4
    //   79: aload_3
    //   80: astore_2
    //   81: aload 4
    //   83: aload_0
    //   84: invokevirtual 212	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   87: pop
    //   88: aload_3
    //   89: astore_2
    //   90: aload 4
    //   92: athrow
    //   93: astore_0
    //   94: aload_2
    //   95: ifnull +9 -> 104
    //   98: aload_2
    //   99: invokeinterface 197 1 0
    //   104: aload_0
    //   105: athrow
    //   106: astore_0
    //   107: aload 4
    //   109: astore_2
    //   110: new 199	android/content/res/Resources$NotFoundException
    //   113: dup
    //   114: new 156	java/lang/StringBuilder
    //   117: dup
    //   118: ldc 201
    //   120: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: iload_1
    //   124: invokestatic 207	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   127: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokespecial 208	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   136: astore_3
    //   137: aload 4
    //   139: astore_2
    //   140: aload_3
    //   141: aload_0
    //   142: invokevirtual 212	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   145: pop
    //   146: aload 4
    //   148: astore_2
    //   149: aload_3
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramContext	Context
    //   0	151	1	paramInt	int
    //   1	148	2	localObject1	Object
    //   6	144	3	localObject2	Object
    //   3	144	4	localObject3	Object
    //   15	25	5	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   7	17	48	org/xmlpull/v1/XmlPullParserException
    //   27	34	48	org/xmlpull/v1/XmlPullParserException
    //   7	17	93	finally
    //   27	34	93	finally
    //   51	79	93	finally
    //   81	88	93	finally
    //   90	93	93	finally
    //   110	137	93	finally
    //   140	146	93	finally
    //   149	151	93	finally
    //   7	17	106	java/io/IOException
    //   27	34	106	java/io/IOException
  }
  
  private static ValueAnimator loadAnimator(Context paramContext, AttributeSet paramAttributeSet, ValueAnimator paramValueAnimator)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, Animator);
    long l1 = localTypedArray.getInt(1, 0);
    long l2 = localTypedArray.getInt(2, 0);
    int i = localTypedArray.getInt(7, 0);
    paramAttributeSet = paramValueAnimator;
    if (paramValueAnimator == null) {
      paramAttributeSet = new ValueAnimator();
    }
    int j;
    label76:
    int m;
    label87:
    int k;
    label102:
    int n;
    label113:
    float f1;
    label201:
    float f2;
    if (i == 0)
    {
      i = 1;
      paramValueAnimator = localTypedArray.peekValue(5);
      if (paramValueAnimator == null) {
        break label328;
      }
      j = 1;
      if (j == 0) {
        break label334;
      }
      m = paramValueAnimator.type;
      paramValueAnimator = localTypedArray.peekValue(6);
      if (paramValueAnimator == null) {
        break label340;
      }
      k = 1;
      if (k == 0) {
        break label346;
      }
      n = paramValueAnimator.type;
      int i1;
      if ((j == 0) || (m < 28) || (m > 31))
      {
        i1 = i;
        if (k != 0)
        {
          i1 = i;
          if (n >= 28)
          {
            i1 = i;
            if (n > 31) {}
          }
        }
      }
      else
      {
        i1 = 0;
        paramAttributeSet.setEvaluator(new ArgbEvaluator());
      }
      if (i1 == 0) {
        break label431;
      }
      if (j == 0) {
        break label390;
      }
      if (m != 5) {
        break label352;
      }
      f1 = localTypedArray.getDimension(5, 0.0F);
      if (k == 0) {
        break label376;
      }
      if (n != 5) {
        break label363;
      }
      f2 = localTypedArray.getDimension(6, 0.0F);
      label222:
      paramAttributeSet.setFloatValues(new float[] { f1, f2 });
    }
    label328:
    label334:
    label340:
    label346:
    label352:
    label363:
    label376:
    do
    {
      for (;;)
      {
        paramAttributeSet.setDuration(l1);
        paramAttributeSet.setStartDelay(l2);
        if (localTypedArray.hasValue(3)) {
          paramAttributeSet.setRepeatCount(localTypedArray.getInt(3, 0));
        }
        if (localTypedArray.hasValue(4)) {
          paramAttributeSet.setRepeatMode(localTypedArray.getInt(4, 1));
        }
        i = localTypedArray.getResourceId(0, 0);
        if (i > 0) {
          paramAttributeSet.setInterpolator(AnimationUtils.loadInterpolator(paramContext, i));
        }
        localTypedArray.recycle();
        return paramAttributeSet;
        i = 0;
        break;
        j = 0;
        break label76;
        m = 0;
        break label87;
        k = 0;
        break label102;
        n = 0;
        break label113;
        f1 = localTypedArray.getFloat(5, 0.0F);
        break label201;
        f2 = localTypedArray.getFloat(6, 0.0F);
        break label222;
        paramAttributeSet.setFloatValues(new float[] { f1 });
        continue;
        if (n == 5) {}
        for (f1 = localTypedArray.getDimension(6, 0.0F);; f1 = localTypedArray.getFloat(6, 0.0F))
        {
          paramAttributeSet.setFloatValues(new float[] { f1 });
          break;
        }
        if (j == 0) {
          break label587;
        }
        if (m == 5)
        {
          i = (int)localTypedArray.getDimension(5, 0.0F);
          if (k == 0) {
            break label572;
          }
          if (n != 5) {
            break label532;
          }
          j = (int)localTypedArray.getDimension(6, 0.0F);
        }
        for (;;)
        {
          paramAttributeSet.setIntValues(new int[] { i, j });
          break;
          if ((m >= 28) && (m <= 31))
          {
            i = localTypedArray.getColor(5, 0);
            break label452;
          }
          i = localTypedArray.getInt(5, 0);
          break label452;
          if ((n >= 28) && (n <= 31)) {
            j = localTypedArray.getColor(6, 0);
          } else {
            j = localTypedArray.getInt(6, 0);
          }
        }
        paramAttributeSet.setIntValues(new int[] { i });
      }
    } while (k == 0);
    label390:
    label431:
    label452:
    label587:
    if (n == 5) {
      i = (int)localTypedArray.getDimension(6, 0.0F);
    }
    for (;;)
    {
      label532:
      label572:
      paramAttributeSet.setIntValues(new int[] { i });
      break;
      if ((n >= 28) && (n <= 31)) {
        i = localTypedArray.getColor(6, 0);
      } else {
        i = localTypedArray.getInt(6, 0);
      }
    }
  }
  
  private static ObjectAnimator loadObjectAnimator(Context paramContext, AttributeSet paramAttributeSet)
  {
    ObjectAnimator localObjectAnimator = new ObjectAnimator();
    loadAnimator(paramContext, paramAttributeSet, localObjectAnimator);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, PropertyAnimator);
    localObjectAnimator.setPropertyName(paramContext.getString(0));
    paramContext.recycle();
    return localObjectAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.nineoldandroids.animation.AnimatorInflater
 * JD-Core Version:    0.7.0.1
 */