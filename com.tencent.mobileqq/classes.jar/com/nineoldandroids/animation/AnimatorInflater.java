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
    //   0: aload_1
    //   1: invokeinterface 70 1 0
    //   6: istore 9
    //   8: aconst_null
    //   9: astore 13
    //   11: aload 13
    //   13: astore 12
    //   15: aload_1
    //   16: invokeinterface 73 1 0
    //   21: istore 10
    //   23: iconst_0
    //   24: istore 8
    //   26: iconst_0
    //   27: istore 7
    //   29: iconst_0
    //   30: istore 6
    //   32: iconst_0
    //   33: istore 5
    //   35: iload 10
    //   37: iconst_3
    //   38: if_icmpne +14 -> 52
    //   41: aload_1
    //   42: invokeinterface 70 1 0
    //   47: iload 9
    //   49: if_icmple +9 -> 58
    //   52: iload 10
    //   54: iconst_1
    //   55: if_icmpne +82 -> 137
    //   58: aload_3
    //   59: ifnull +75 -> 134
    //   62: aload 13
    //   64: ifnull +70 -> 134
    //   67: aload 13
    //   69: invokevirtual 78	java/util/ArrayList:size	()I
    //   72: anewarray 80	com/nineoldandroids/animation/Animator
    //   75: astore_0
    //   76: aload 13
    //   78: invokevirtual 84	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   81: astore_1
    //   82: aload_1
    //   83: invokeinterface 90 1 0
    //   88: ifne +24 -> 112
    //   91: iload 4
    //   93: ifne +11 -> 104
    //   96: aload_3
    //   97: aload_0
    //   98: invokevirtual 96	com/nineoldandroids/animation/AnimatorSet:playTogether	([Lcom/nineoldandroids/animation/Animator;)V
    //   101: aload 12
    //   103: areturn
    //   104: aload_3
    //   105: aload_0
    //   106: invokevirtual 99	com/nineoldandroids/animation/AnimatorSet:playSequentially	([Lcom/nineoldandroids/animation/Animator;)V
    //   109: aload 12
    //   111: areturn
    //   112: aload_0
    //   113: iload 5
    //   115: aload_1
    //   116: invokeinterface 102 1 0
    //   121: checkcast 80	com/nineoldandroids/animation/Animator
    //   124: aastore
    //   125: iload 5
    //   127: iconst_1
    //   128: iadd
    //   129: istore 5
    //   131: goto -49 -> 82
    //   134: aload 12
    //   136: areturn
    //   137: iload 10
    //   139: iconst_2
    //   140: if_icmpeq +6 -> 146
    //   143: goto -128 -> 15
    //   146: aload_1
    //   147: invokeinterface 106 1 0
    //   152: astore 11
    //   154: aload 11
    //   156: ldc 108
    //   158: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   161: ifeq +13 -> 174
    //   164: aload_0
    //   165: aload_2
    //   166: invokestatic 118	com/nineoldandroids/animation/AnimatorInflater:loadObjectAnimator	(Landroid/content/Context;Landroid/util/AttributeSet;)Lcom/nineoldandroids/animation/ObjectAnimator;
    //   169: astore 11
    //   171: goto +185 -> 356
    //   174: aload 11
    //   176: ldc 120
    //   178: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   181: ifeq +14 -> 195
    //   184: aload_0
    //   185: aload_2
    //   186: aconst_null
    //   187: invokestatic 124	com/nineoldandroids/animation/AnimatorInflater:loadAnimator	(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/nineoldandroids/animation/ValueAnimator;)Lcom/nineoldandroids/animation/ValueAnimator;
    //   190: astore 11
    //   192: goto +164 -> 356
    //   195: aload 11
    //   197: ldc 126
    //   199: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   202: ifeq +212 -> 414
    //   205: new 92	com/nineoldandroids/animation/AnimatorSet
    //   208: dup
    //   209: invokespecial 127	com/nineoldandroids/animation/AnimatorSet:<init>	()V
    //   212: astore 15
    //   214: aload_0
    //   215: aload_2
    //   216: getstatic 34	com/nineoldandroids/animation/AnimatorInflater:AnimatorSet	[I
    //   219: invokevirtual 133	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   222: astore 11
    //   224: aload 11
    //   226: astore 12
    //   228: new 135	android/util/TypedValue
    //   231: dup
    //   232: invokespecial 136	android/util/TypedValue:<init>	()V
    //   235: astore 14
    //   237: aload 11
    //   239: astore 12
    //   241: aload 11
    //   243: iconst_0
    //   244: aload 14
    //   246: invokevirtual 142	android/content/res/TypedArray:getValue	(ILandroid/util/TypedValue;)Z
    //   249: pop
    //   250: iload 8
    //   252: istore 5
    //   254: aload 11
    //   256: astore 12
    //   258: aload 14
    //   260: getfield 145	android/util/TypedValue:type	I
    //   263: bipush 16
    //   265: if_icmpne +14 -> 279
    //   268: aload 11
    //   270: astore 12
    //   272: aload 14
    //   274: getfield 148	android/util/TypedValue:data	I
    //   277: istore 5
    //   279: iload 5
    //   281: istore 6
    //   283: aload 11
    //   285: ifnull +53 -> 338
    //   288: aload 11
    //   290: invokevirtual 151	android/content/res/TypedArray:recycle	()V
    //   293: iload 5
    //   295: istore 6
    //   297: goto +41 -> 338
    //   300: astore 14
    //   302: goto +15 -> 317
    //   305: astore_0
    //   306: aconst_null
    //   307: astore 12
    //   309: goto +93 -> 402
    //   312: astore 14
    //   314: aconst_null
    //   315: astore 11
    //   317: aload 11
    //   319: astore 12
    //   321: aload 14
    //   323: invokevirtual 154	java/lang/Exception:printStackTrace	()V
    //   326: aload 11
    //   328: ifnull +10 -> 338
    //   331: iload 7
    //   333: istore 5
    //   335: goto -47 -> 288
    //   338: aload_0
    //   339: aload_1
    //   340: aload_2
    //   341: aload 15
    //   343: checkcast 92	com/nineoldandroids/animation/AnimatorSet
    //   346: iload 6
    //   348: invokestatic 62	com/nineoldandroids/animation/AnimatorInflater:createAnimatorFromXml	(Landroid/content/Context;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Lcom/nineoldandroids/animation/AnimatorSet;I)Lcom/nineoldandroids/animation/Animator;
    //   351: pop
    //   352: aload 15
    //   354: astore 11
    //   356: aload 11
    //   358: astore 12
    //   360: aload_3
    //   361: ifnull -346 -> 15
    //   364: aload 13
    //   366: astore 12
    //   368: aload 13
    //   370: ifnonnull +12 -> 382
    //   373: new 75	java/util/ArrayList
    //   376: dup
    //   377: invokespecial 155	java/util/ArrayList:<init>	()V
    //   380: astore 12
    //   382: aload 12
    //   384: aload 11
    //   386: invokevirtual 158	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   389: pop
    //   390: aload 12
    //   392: astore 13
    //   394: aload 11
    //   396: astore 12
    //   398: goto -383 -> 15
    //   401: astore_0
    //   402: aload 12
    //   404: ifnull +8 -> 412
    //   407: aload 12
    //   409: invokevirtual 151	android/content/res/TypedArray:recycle	()V
    //   412: aload_0
    //   413: athrow
    //   414: new 160	java/lang/StringBuilder
    //   417: dup
    //   418: ldc 162
    //   420: invokespecial 165	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   423: astore_0
    //   424: aload_0
    //   425: aload_1
    //   426: invokeinterface 106 1 0
    //   431: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: new 171	java/lang/RuntimeException
    //   438: dup
    //   439: aload_0
    //   440: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokespecial 175	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   446: astore_0
    //   447: goto +5 -> 452
    //   450: aload_0
    //   451: athrow
    //   452: goto -2 -> 450
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	455	0	paramContext	Context
    //   0	455	1	paramXmlPullParser	XmlPullParser
    //   0	455	2	paramAttributeSet	AttributeSet
    //   0	455	3	paramAnimatorSet	AnimatorSet
    //   0	455	4	paramInt	int
    //   33	301	5	i	int
    //   30	317	6	j	int
    //   27	305	7	k	int
    //   24	227	8	m	int
    //   6	44	9	n	int
    //   21	120	10	i1	int
    //   152	243	11	localObject1	Object
    //   13	395	12	localObject2	Object
    //   9	384	13	localObject3	Object
    //   235	38	14	localTypedValue	TypedValue
    //   300	1	14	localException1	java.lang.Exception
    //   312	10	14	localException2	java.lang.Exception
    //   212	141	15	localAnimatorSet	AnimatorSet
    // Exception table:
    //   from	to	target	type
    //   228	237	300	java/lang/Exception
    //   241	250	300	java/lang/Exception
    //   258	268	300	java/lang/Exception
    //   272	279	300	java/lang/Exception
    //   214	224	305	finally
    //   214	224	312	java/lang/Exception
    //   228	237	401	finally
    //   241	250	401	finally
    //   258	268	401	finally
    //   272	279	401	finally
    //   321	326	401	finally
  }
  
  /* Error */
  public static Animator loadAnimator(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_0
    //   8: invokevirtual 184	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   11: iload_1
    //   12: invokevirtual 190	android/content/res/Resources:getAnimation	(I)Landroid/content/res/XmlResourceParser;
    //   15: astore 5
    //   17: aload 5
    //   19: astore_2
    //   20: aload 5
    //   22: astore_3
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
    //   49: goto +114 -> 163
    //   52: astore_0
    //   53: aload_3
    //   54: astore_2
    //   55: new 160	java/lang/StringBuilder
    //   58: dup
    //   59: ldc 199
    //   61: invokespecial 165	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   64: astore 4
    //   66: aload_3
    //   67: astore_2
    //   68: aload 4
    //   70: iload_1
    //   71: invokestatic 205	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   74: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_3
    //   79: astore_2
    //   80: new 207	android/content/res/Resources$NotFoundException
    //   83: dup
    //   84: aload 4
    //   86: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokespecial 208	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   92: astore 4
    //   94: aload_3
    //   95: astore_2
    //   96: aload 4
    //   98: aload_0
    //   99: invokevirtual 212	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   102: pop
    //   103: aload_3
    //   104: astore_2
    //   105: aload 4
    //   107: athrow
    //   108: astore_0
    //   109: aload 4
    //   111: astore_2
    //   112: new 160	java/lang/StringBuilder
    //   115: dup
    //   116: ldc 199
    //   118: invokespecial 165	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   121: astore_3
    //   122: aload 4
    //   124: astore_2
    //   125: aload_3
    //   126: iload_1
    //   127: invokestatic 205	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   130: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 4
    //   136: astore_2
    //   137: new 207	android/content/res/Resources$NotFoundException
    //   140: dup
    //   141: aload_3
    //   142: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokespecial 208	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   148: astore_3
    //   149: aload 4
    //   151: astore_2
    //   152: aload_3
    //   153: aload_0
    //   154: invokevirtual 212	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   157: pop
    //   158: aload 4
    //   160: astore_2
    //   161: aload_3
    //   162: athrow
    //   163: aload_2
    //   164: ifnull +9 -> 173
    //   167: aload_2
    //   168: invokeinterface 197 1 0
    //   173: aload_0
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	paramContext	Context
    //   0	175	1	paramInt	int
    //   6	162	2	localObject1	Object
    //   1	161	3	localObject2	Object
    //   3	156	4	localObject3	Object
    //   15	25	5	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   7	17	48	finally
    //   27	34	48	finally
    //   55	66	48	finally
    //   68	78	48	finally
    //   80	94	48	finally
    //   96	103	48	finally
    //   105	108	48	finally
    //   112	122	48	finally
    //   125	134	48	finally
    //   137	149	48	finally
    //   152	158	48	finally
    //   161	163	48	finally
    //   7	17	52	java/io/IOException
    //   27	34	52	java/io/IOException
    //   7	17	108	org/xmlpull/v1/XmlPullParserException
    //   27	34	108	org/xmlpull/v1/XmlPullParserException
  }
  
  private static ValueAnimator loadAnimator(Context paramContext, AttributeSet paramAttributeSet, ValueAnimator paramValueAnimator)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, Animator);
    long l1 = localTypedArray.getInt(1, 0);
    long l2 = localTypedArray.getInt(2, 0);
    int i = localTypedArray.getInt(7, 0);
    if (paramValueAnimator == null) {
      paramAttributeSet = new ValueAnimator();
    } else {
      paramAttributeSet = paramValueAnimator;
    }
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    paramValueAnimator = localTypedArray.peekValue(5);
    int j;
    if (paramValueAnimator != null) {
      j = 1;
    } else {
      j = 0;
    }
    int m;
    if (j != 0) {
      m = paramValueAnimator.type;
    } else {
      m = 0;
    }
    paramValueAnimator = localTypedArray.peekValue(6);
    int k;
    if (paramValueAnimator != null) {
      k = 1;
    } else {
      k = 0;
    }
    int n;
    if (k != 0) {
      n = paramValueAnimator.type;
    } else {
      n = 0;
    }
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
      paramAttributeSet.setEvaluator(new ArgbEvaluator());
      i1 = 0;
    }
    if (i1 != 0)
    {
      float f1;
      if (j != 0)
      {
        if (m == 5) {
          f1 = localTypedArray.getDimension(5, 0.0F);
        } else {
          f1 = localTypedArray.getFloat(5, 0.0F);
        }
        if (k != 0)
        {
          float f2;
          if (n == 5) {
            f2 = localTypedArray.getDimension(6, 0.0F);
          } else {
            f2 = localTypedArray.getFloat(6, 0.0F);
          }
          paramAttributeSet.setFloatValues(new float[] { f1, f2 });
        }
        else
        {
          paramAttributeSet.setFloatValues(new float[] { f1 });
        }
      }
      else
      {
        if (n == 5) {
          f1 = localTypedArray.getDimension(6, 0.0F);
        } else {
          f1 = localTypedArray.getFloat(6, 0.0F);
        }
        paramAttributeSet.setFloatValues(new float[] { f1 });
      }
    }
    else if (j != 0)
    {
      if (m == 5) {
        i = (int)localTypedArray.getDimension(5, 0.0F);
      } else if ((m >= 28) && (m <= 31)) {
        i = localTypedArray.getColor(5, 0);
      } else {
        i = localTypedArray.getInt(5, 0);
      }
      if (k != 0)
      {
        if (n == 5) {
          j = (int)localTypedArray.getDimension(6, 0.0F);
        } else if ((n >= 28) && (n <= 31)) {
          j = localTypedArray.getColor(6, 0);
        } else {
          j = localTypedArray.getInt(6, 0);
        }
        paramAttributeSet.setIntValues(new int[] { i, j });
      }
      else
      {
        paramAttributeSet.setIntValues(new int[] { i });
      }
    }
    else if (k != 0)
    {
      if (n == 5) {
        i = (int)localTypedArray.getDimension(6, 0.0F);
      }
      for (;;)
      {
        break;
        if ((n >= 28) && (n <= 31)) {
          i = localTypedArray.getColor(6, 0);
        } else {
          i = localTypedArray.getInt(6, 0);
        }
      }
      paramAttributeSet.setIntValues(new int[] { i });
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nineoldandroids.animation.AnimatorInflater
 * JD-Core Version:    0.7.0.1
 */