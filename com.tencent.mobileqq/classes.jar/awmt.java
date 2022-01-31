import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class awmt
  extends awmc
{
  public int a;
  public long a;
  public Context a;
  RectF jdField_a_of_type_AndroidGraphicsRectF;
  public View a;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  awmc jdField_a_of_type_Awmc;
  awmz jdField_a_of_type_Awmz;
  public awnk a;
  public boolean a;
  public int b;
  public long b;
  awmc b;
  int c;
  int d;
  public int e;
  public int k;
  public int l;
  public int m;
  private int n;
  
  public RectF a(int paramInt)
  {
    float f = this.h / 4;
    this.jdField_a_of_type_AndroidGraphicsRectF.set(this.f - f, this.g - f + this.k - paramInt, this.f + this.h + f, f + (this.g + this.i) + this.k - paramInt);
    return this.jdField_a_of_type_AndroidGraphicsRectF;
  }
  
  public void a()
  {
    float f1 = 1.0F;
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    float f2 = (float)(AnimationUtils.currentAnimationTimeMillis() - this.jdField_a_of_type_Long) * 1.0F / (float)this.jdField_b_of_type_Long;
    float f3;
    if (this.jdField_a_of_type_AndroidViewAnimationInterpolator != null)
    {
      f3 = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f2);
      if (f3 <= 1.0F) {}
    }
    for (;;)
    {
      f3 = this.m;
      a((int)(f1 * (this.l - this.m) + f3));
      if (f2 <= 0.99D) {
        break;
      }
      switch (this.e)
      {
      case 2: 
      default: 
        d();
        return;
      case 1: 
        this.e = 3;
        b();
        return;
      }
      this.e = 2;
      return;
      f1 = f3;
      continue;
      f1 = f2;
    }
  }
  
  public void a(int paramInt)
  {
    float f1 = 1.0F * paramInt / this.d;
    float f2 = this.c - this.d;
    this.g = paramInt;
    if (this.jdField_a_of_type_Awmc != null) {
      this.jdField_a_of_type_Awmc.i = ((int)(f1 * f2) + paramInt);
    }
    if (this.jdField_a_of_type_Awmz != null) {
      this.jdField_a_of_type_Awmz.d = paramInt;
    }
    if (this.jdField_b_of_type_Awmc != null) {
      this.jdField_b_of_type_Awmc.g = (this.i + paramInt + this.n);
    }
    if (this.jdField_a_of_type_Awnk != null) {
      this.jdField_a_of_type_Awnk.a(this.f + this.h / 2, this.g);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_Awmc = new awmc();
    paramInt2 = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298079);
    this.c = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298078));
    paramInt3 = this.h / 2;
    paramInt4 = paramInt2 / 2;
    this.jdField_a_of_type_Awmc.a = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844891);
    this.jdField_a_of_type_Awmc.a(paramInt3 + paramInt1 - paramInt4, 0, paramInt2, this.c, paramView);
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.m = this.jdField_a_of_type_Int;
    this.l = (this.jdField_a_of_type_Int + paramInt);
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new DecelerateInterpolator();
    this.e = 1;
    a(paramLong);
  }
  
  public void a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
    this.jdField_a_of_type_Boolean = true;
  }
  
  /* Error */
  public void a(boolean paramBoolean, android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 157
    //   8: iconst_2
    //   9: new 159	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   16: ldc 162
    //   18: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_2
    //   22: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: aload_0
    //   32: getfield 178	awmt:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   35: invokevirtual 181	android/view/View:getResources	()Landroid/content/res/Resources;
    //   38: ldc 182
    //   40: invokevirtual 130	android/content/res/Resources:getDimension	(I)F
    //   43: fstore_3
    //   44: fload_3
    //   45: f2i
    //   46: istore 8
    //   48: aload_0
    //   49: getfield 178	awmt:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   52: invokevirtual 181	android/view/View:getResources	()Landroid/content/res/Resources;
    //   55: ldc 183
    //   57: invokevirtual 130	android/content/res/Resources:getDimension	(I)F
    //   60: f2i
    //   61: istore 13
    //   63: aload_0
    //   64: getfield 178	awmt:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   67: invokevirtual 181	android/view/View:getResources	()Landroid/content/res/Resources;
    //   70: ldc 184
    //   72: invokevirtual 130	android/content/res/Resources:getDimension	(I)F
    //   75: f2i
    //   76: istore 10
    //   78: aload_0
    //   79: getfield 178	awmt:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   82: invokevirtual 181	android/view/View:getResources	()Landroid/content/res/Resources;
    //   85: ldc 185
    //   87: invokevirtual 130	android/content/res/Resources:getDimension	(I)F
    //   90: f2i
    //   91: istore 9
    //   93: aload_0
    //   94: getfield 178	awmt:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   97: invokevirtual 189	android/view/View:getWidth	()I
    //   100: iload 13
    //   102: isub
    //   103: iload 10
    //   105: isub
    //   106: istore 10
    //   108: aload_0
    //   109: iload 9
    //   111: putfield 85	awmt:d	I
    //   114: aload_2
    //   115: astore 16
    //   117: aload_2
    //   118: ifnonnull +31 -> 149
    //   121: aload_0
    //   122: getfield 191	awmt:jdField_b_of_type_Int	I
    //   125: iconst_1
    //   126: if_icmpne +358 -> 484
    //   129: aload_0
    //   130: getfield 117	awmt:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   133: invokevirtual 123	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   136: ldc 192
    //   138: invokestatic 198	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   141: astore 16
    //   143: aload 16
    //   145: astore_2
    //   146: aload_2
    //   147: astore 16
    //   149: aload_0
    //   150: getfield 191	awmt:jdField_b_of_type_Int	I
    //   153: iconst_1
    //   154: if_icmpne +363 -> 517
    //   157: aload_0
    //   158: getfield 178	awmt:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   161: invokevirtual 181	android/view/View:getResources	()Landroid/content/res/Resources;
    //   164: ldc 199
    //   166: invokevirtual 130	android/content/res/Resources:getDimension	(I)F
    //   169: fstore 6
    //   171: aload 16
    //   173: invokevirtual 204	android/graphics/Bitmap:getHeight	()I
    //   176: i2f
    //   177: fload 6
    //   179: fmul
    //   180: aload 16
    //   182: invokevirtual 205	android/graphics/Bitmap:getWidth	()I
    //   185: i2f
    //   186: fdiv
    //   187: fstore 5
    //   189: iload 8
    //   191: i2f
    //   192: fstore 4
    //   194: aload_0
    //   195: getfield 178	awmt:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   198: invokevirtual 181	android/view/View:getResources	()Landroid/content/res/Resources;
    //   201: ldc 206
    //   203: invokevirtual 130	android/content/res/Resources:getDimension	(I)F
    //   206: fstore 7
    //   208: aload_0
    //   209: getfield 178	awmt:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   212: invokevirtual 181	android/view/View:getResources	()Landroid/content/res/Resources;
    //   215: ldc 207
    //   217: invokevirtual 130	android/content/res/Resources:getDimension	(I)F
    //   220: fstore_3
    //   221: fload 4
    //   223: fload 5
    //   225: fsub
    //   226: fload 7
    //   228: fsub
    //   229: fstore 7
    //   231: fload_3
    //   232: fstore 4
    //   234: fload 7
    //   236: fstore_3
    //   237: aload_0
    //   238: getfield 92	awmt:jdField_a_of_type_Awmz	Lawmz;
    //   241: ifnonnull +96 -> 337
    //   244: aload_0
    //   245: new 94	awmz
    //   248: dup
    //   249: aload_0
    //   250: getfield 117	awmt:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   253: iload 13
    //   255: iload 8
    //   257: iload 10
    //   259: iload 9
    //   261: fload 4
    //   263: f2i
    //   264: fload_3
    //   265: f2i
    //   266: fload 6
    //   268: f2i
    //   269: fload 5
    //   271: f2i
    //   272: invokespecial 210	awmz:<init>	(Landroid/content/Context;IIIIIIII)V
    //   275: putfield 92	awmt:jdField_a_of_type_Awmz	Lawmz;
    //   278: aload_0
    //   279: getfield 92	awmt:jdField_a_of_type_Awmz	Lawmz;
    //   282: aload_0
    //   283: getfield 178	awmt:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   286: invokevirtual 181	android/view/View:getResources	()Landroid/content/res/Resources;
    //   289: ldc 211
    //   291: invokevirtual 130	android/content/res/Resources:getDimension	(I)F
    //   294: f2i
    //   295: putfield 212	awmz:i	I
    //   298: aload_0
    //   299: getfield 92	awmt:jdField_a_of_type_Awmz	Lawmz;
    //   302: aload_0
    //   303: getfield 178	awmt:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   306: invokevirtual 181	android/view/View:getResources	()Landroid/content/res/Resources;
    //   309: ldc 213
    //   311: invokevirtual 130	android/content/res/Resources:getDimension	(I)F
    //   314: f2i
    //   315: putfield 216	awmz:j	I
    //   318: aload_0
    //   319: getfield 92	awmt:jdField_a_of_type_Awmz	Lawmz;
    //   322: aload_0
    //   323: getfield 117	awmt:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   326: invokevirtual 123	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   329: ldc 217
    //   331: invokestatic 198	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   334: invokevirtual 220	awmz:c	(Landroid/graphics/Bitmap;)V
    //   337: aload_0
    //   338: getfield 92	awmt:jdField_a_of_type_Awmz	Lawmz;
    //   341: fload 4
    //   343: f2i
    //   344: putfield 221	awmz:e	I
    //   347: aload_0
    //   348: getfield 92	awmt:jdField_a_of_type_Awmz	Lawmz;
    //   351: fload_3
    //   352: f2i
    //   353: putfield 222	awmz:f	I
    //   356: aload_0
    //   357: getfield 92	awmt:jdField_a_of_type_Awmz	Lawmz;
    //   360: fload 6
    //   362: f2i
    //   363: putfield 223	awmz:g	I
    //   366: aload_0
    //   367: getfield 92	awmt:jdField_a_of_type_Awmz	Lawmz;
    //   370: fload 5
    //   372: f2i
    //   373: putfield 224	awmz:h	I
    //   376: aload_0
    //   377: getfield 191	awmt:jdField_b_of_type_Int	I
    //   380: iconst_1
    //   381: if_icmpne +206 -> 587
    //   384: aload_0
    //   385: getfield 92	awmt:jdField_a_of_type_Awmz	Lawmz;
    //   388: aload_0
    //   389: getfield 178	awmt:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   392: invokevirtual 181	android/view/View:getResources	()Landroid/content/res/Resources;
    //   395: ldc 225
    //   397: invokevirtual 130	android/content/res/Resources:getDimension	(I)F
    //   400: f2i
    //   401: putfield 226	awmz:k	I
    //   404: aload_0
    //   405: getfield 92	awmt:jdField_a_of_type_Awmz	Lawmz;
    //   408: aload_0
    //   409: getfield 178	awmt:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   412: invokevirtual 181	android/view/View:getResources	()Landroid/content/res/Resources;
    //   415: ldc 227
    //   417: invokevirtual 130	android/content/res/Resources:getDimension	(I)F
    //   420: f2i
    //   421: putfield 228	awmz:l	I
    //   424: aload_0
    //   425: getfield 191	awmt:jdField_b_of_type_Int	I
    //   428: iconst_3
    //   429: if_icmpne +189 -> 618
    //   432: aload_0
    //   433: getfield 92	awmt:jdField_a_of_type_Awmz	Lawmz;
    //   436: aload 16
    //   438: invokevirtual 230	awmz:a	(Landroid/graphics/Bitmap;)V
    //   441: aload_0
    //   442: getfield 92	awmt:jdField_a_of_type_Awmz	Lawmz;
    //   445: invokevirtual 232	awmz:a	()V
    //   448: aload_0
    //   449: iload 10
    //   451: iload 9
    //   453: iload 13
    //   455: iload 8
    //   457: aload_0
    //   458: getfield 178	awmt:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   461: invokevirtual 233	awmt:a	(IIIILandroid/view/View;)V
    //   464: iload_1
    //   465: ifeq +165 -> 630
    //   468: aload_0
    //   469: aconst_null
    //   470: putfield 97	awmt:jdField_b_of_type_Awmc	Lawmc;
    //   473: aload_0
    //   474: invokevirtual 234	awmt:a	()V
    //   477: return
    //   478: astore_2
    //   479: aload_2
    //   480: invokevirtual 237	java/lang/OutOfMemoryError:printStackTrace	()V
    //   483: return
    //   484: aload_0
    //   485: getfield 117	awmt:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   488: invokevirtual 123	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   491: ldc 238
    //   493: invokestatic 198	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   496: astore 16
    //   498: aload 16
    //   500: astore_2
    //   501: goto -355 -> 146
    //   504: astore 16
    //   506: aload 16
    //   508: invokevirtual 237	java/lang/OutOfMemoryError:printStackTrace	()V
    //   511: aload_2
    //   512: astore 16
    //   514: goto -365 -> 149
    //   517: aload_0
    //   518: getfield 178	awmt:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   521: invokevirtual 181	android/view/View:getResources	()Landroid/content/res/Resources;
    //   524: ldc 239
    //   526: invokevirtual 130	android/content/res/Resources:getDimension	(I)F
    //   529: fstore_3
    //   530: iload 8
    //   532: i2f
    //   533: fstore 5
    //   535: aload_0
    //   536: getfield 178	awmt:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   539: invokevirtual 181	android/view/View:getResources	()Landroid/content/res/Resources;
    //   542: ldc 240
    //   544: invokevirtual 130	android/content/res/Resources:getDimension	(I)F
    //   547: fstore 6
    //   549: iload 13
    //   551: i2f
    //   552: fload_3
    //   553: fsub
    //   554: fconst_2
    //   555: fdiv
    //   556: fstore 4
    //   558: fload 5
    //   560: fload_3
    //   561: fsub
    //   562: fload 6
    //   564: fsub
    //   565: fstore 7
    //   567: fload_3
    //   568: fstore 5
    //   570: fload_3
    //   571: fstore 6
    //   573: fload 7
    //   575: fstore_3
    //   576: goto -339 -> 237
    //   579: astore_2
    //   580: aload_2
    //   581: invokevirtual 237	java/lang/OutOfMemoryError:printStackTrace	()V
    //   584: goto -247 -> 337
    //   587: aload_0
    //   588: getfield 92	awmt:jdField_a_of_type_Awmz	Lawmz;
    //   591: iconst_0
    //   592: putfield 226	awmz:k	I
    //   595: aload_0
    //   596: getfield 92	awmt:jdField_a_of_type_Awmz	Lawmz;
    //   599: aload_0
    //   600: getfield 178	awmt:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   603: invokevirtual 181	android/view/View:getResources	()Landroid/content/res/Resources;
    //   606: ldc 241
    //   608: invokevirtual 130	android/content/res/Resources:getDimension	(I)F
    //   611: f2i
    //   612: putfield 228	awmz:l	I
    //   615: goto -191 -> 424
    //   618: aload_0
    //   619: getfield 92	awmt:jdField_a_of_type_Awmz	Lawmz;
    //   622: aload 16
    //   624: invokevirtual 243	awmz:b	(Landroid/graphics/Bitmap;)V
    //   627: goto -179 -> 448
    //   630: aload_0
    //   631: new 4	awmc
    //   634: dup
    //   635: invokespecial 115	awmc:<init>	()V
    //   638: putfield 97	awmt:jdField_b_of_type_Awmc	Lawmc;
    //   641: aload_0
    //   642: aload_0
    //   643: getfield 117	awmt:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   646: invokevirtual 123	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   649: ldc 244
    //   651: invokevirtual 130	android/content/res/Resources:getDimension	(I)F
    //   654: f2i
    //   655: putfield 99	awmt:n	I
    //   658: aload_0
    //   659: getfield 117	awmt:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   662: invokevirtual 123	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   665: ldc 245
    //   667: invokevirtual 130	android/content/res/Resources:getDimension	(I)F
    //   670: f2i
    //   671: istore 11
    //   673: aload_0
    //   674: getfield 117	awmt:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   677: invokevirtual 123	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   680: ldc 246
    //   682: invokevirtual 130	android/content/res/Resources:getDimension	(I)F
    //   685: f2i
    //   686: istore 12
    //   688: iload 13
    //   690: iconst_2
    //   691: idiv
    //   692: istore 13
    //   694: iload 11
    //   696: iconst_2
    //   697: idiv
    //   698: istore 14
    //   700: aload_0
    //   701: getfield 99	awmt:n	I
    //   704: istore 15
    //   706: aload_0
    //   707: getfield 97	awmt:jdField_b_of_type_Awmc	Lawmc;
    //   710: iload 13
    //   712: iload 10
    //   714: iadd
    //   715: iload 14
    //   717: isub
    //   718: iload 15
    //   720: iload 9
    //   722: iload 8
    //   724: iadd
    //   725: iadd
    //   726: iload 11
    //   728: iload 12
    //   730: aload_0
    //   731: getfield 178	awmt:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   734: invokevirtual 110	awmc:a	(IIIILandroid/view/View;)V
    //   737: goto -264 -> 473
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	740	0	this	awmt
    //   0	740	1	paramBoolean	boolean
    //   0	740	2	paramBitmap	android.graphics.Bitmap
    //   43	533	3	f1	float
    //   192	365	4	f2	float
    //   187	382	5	f3	float
    //   169	403	6	f4	float
    //   206	368	7	f5	float
    //   46	679	8	i	int
    //   91	634	9	j	int
    //   76	639	10	i1	int
    //   671	56	11	i2	int
    //   686	43	12	i3	int
    //   61	654	13	i4	int
    //   698	20	14	i5	int
    //   704	22	15	i6	int
    //   115	384	16	localBitmap1	android.graphics.Bitmap
    //   504	3	16	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   512	111	16	localBitmap2	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   31	44	478	java/lang/OutOfMemoryError
    //   121	143	504	java/lang/OutOfMemoryError
    //   484	498	504	java/lang/OutOfMemoryError
    //   318	337	579	java/lang/OutOfMemoryError
  }
  
  public boolean a(Canvas paramCanvas)
  {
    boolean bool2 = false;
    boolean bool3 = super.a();
    a();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.k);
    if ((this.jdField_a_of_type_Awmc != null) && (this.j != 0))
    {
      this.jdField_a_of_type_Awmc.j = this.j;
      this.jdField_a_of_type_Awmc.a(paramCanvas);
    }
    super.c(paramCanvas);
    if (this.jdField_a_of_type_Awmz != null) {}
    for (boolean bool1 = this.jdField_a_of_type_Awmz.a(paramCanvas);; bool1 = false)
    {
      if ((this.jdField_b_of_type_Awmc != null) && (this.j != 0))
      {
        this.jdField_b_of_type_Awmc.j = this.j;
        this.jdField_b_of_type_Awmc.a(paramCanvas);
      }
      this.jdField_a_of_type_Awnk.a(paramCanvas);
      paramCanvas.restore();
      if ((this.jdField_a_of_type_Boolean) || (bool3) || (bool1)) {
        bool2 = true;
      }
      return bool2;
    }
  }
  
  public void b()
  {
    this.m = this.g;
    this.l = this.jdField_a_of_type_Int;
    this.e = 3;
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new awmd();
    a(1500L);
  }
  
  public void c()
  {
    bdob localbdob = new bdob(Float.valueOf(1.0F), Float.valueOf(1.1F), new awmu(this));
    localbdob.setDuration(500L);
    localbdob.setRepeatCount(-1);
    localbdob.setRepeatMode(2);
    a(localbdob);
    this.jdField_a_of_type_Awnk.b();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = 1L;
    this.e = 2;
    a(this.jdField_a_of_type_Int);
  }
  
  public void e()
  {
    super.e();
    d();
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_Float = 1.0F;
    if (this.jdField_a_of_type_Awmz != null)
    {
      this.jdField_a_of_type_Awmz.jdField_b_of_type_Float = 1.0F;
      this.jdField_a_of_type_Awmz.jdField_a_of_type_Float = 1.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awmt
 * JD-Core Version:    0.7.0.1
 */