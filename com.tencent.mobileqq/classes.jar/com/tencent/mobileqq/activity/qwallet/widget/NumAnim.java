package com.tencent.mobileqq.activity.qwallet.widget;

import amtj;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.SuperscriptSpan;
import android.util.SparseArray;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class NumAnim
  implements Runnable
{
  private static final int COUNTPERS = 30;
  public static final int REGION_MAIN = 2;
  public static final int REGION_PREFFIX = 1;
  public static final int REGION_SUFFIX = 3;
  private static final String TAG = "NumAnim";
  public static final String WAN = amtj.a(2131706788);
  static DecimalFormat decimalFormatTo1;
  static DecimalFormat decimalFormatTo2 = new DecimalFormat("0.00");
  final boolean changeDip;
  private int curr_index;
  final int fontSize;
  NumAnim.AnimListener mAnimListener = null;
  SparseArray<Boolean> mBold = new SparseArray();
  NumAnim.Ruler mRuler = new NumAnim.1(this);
  private double[] nums;
  private long pertime;
  long startTime = 0L;
  final int superscriptSize;
  private final TextView view;
  
  static
  {
    DecimalFormatSymbols localDecimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale.US);
    localDecimalFormatSymbols.setDecimalSeparator('.');
    decimalFormatTo2.setDecimalFormatSymbols(localDecimalFormatSymbols);
    decimalFormatTo2.setRoundingMode(RoundingMode.DOWN);
    decimalFormatTo1 = new DecimalFormat("0.0");
    localDecimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale.US);
    localDecimalFormatSymbols.setDecimalSeparator('.');
    decimalFormatTo1.setDecimalFormatSymbols(localDecimalFormatSymbols);
    decimalFormatTo1.setRoundingMode(RoundingMode.DOWN);
  }
  
  public NumAnim(TextView paramTextView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.view = paramTextView;
    this.superscriptSize = paramInt1;
    this.fontSize = paramInt2;
    this.changeDip = paramBoolean;
  }
  
  public static String formatNumber(double paramDouble, boolean paramBoolean)
  {
    int i;
    double d;
    label26:
    String str1;
    if ((paramBoolean) && (paramDouble >= 10000.0D))
    {
      i = 1;
      if (i == 0) {
        break label92;
      }
      d = paramDouble / 10000.0D;
      if ((paramDouble < 1000000.0D) || (paramDouble >= 10000000.0D)) {
        break label97;
      }
      str1 = decimalFormatTo1.format(d);
    }
    for (;;)
    {
      String str2 = str1;
      if (i != 0) {
        str2 = str1 + WAN;
      }
      return str2;
      i = 0;
      break;
      label92:
      d = paramDouble;
      break label26;
      label97:
      if (paramDouble >= 10000000.0D) {
        str1 = (int)d + "";
      } else {
        str1 = decimalFormatTo2.format(d);
      }
    }
  }
  
  public static double trimMax(double paramDouble)
  {
    double d = paramDouble;
    if (paramDouble > 9999999999.0D) {
      d = 9999999999.0D;
    }
    return d;
  }
  
  public void run()
  {
    if ((this.curr_index < this.nums.length) && (this.mRuler != null))
    {
      Object localObject = this.nums;
      int i = this.curr_index;
      this.curr_index = (i + 1);
      double d = trimMax(localObject[i]);
      localObject = this.mRuler.getNumber(d);
      if ((localObject != null) && (!TextUtils.isEmpty(((NumAnim.SpannableValue)localObject).valueStr)))
      {
        SpannableString localSpannableString = new SpannableString(((NumAnim.SpannableValue)localObject).valueStr);
        i = ((NumAnim.SpannableValue)localObject).suffixIndex;
        int j = ((NumAnim.SpannableValue)localObject).preffixLen;
        int k = ((NumAnim.SpannableValue)localObject).valueStr.length();
        if (j > 0)
        {
          localSpannableString.setSpan(new SuperscriptSpan(), 0, j, 33);
          localSpannableString.setSpan(new RelativeSizeSpan(0.5F), 0, j, 33);
          localSpannableString.setSpan(new AbsoluteSizeSpan(this.superscriptSize, this.changeDip), 0, j, 33);
          if (((Boolean)this.mBold.get(1, Boolean.valueOf(false))).booleanValue()) {
            localSpannableString.setSpan(new StyleSpan(1), 0, j, 33);
          }
        }
        localSpannableString.setSpan(new AbsoluteSizeSpan(this.fontSize, this.changeDip), j, i, 33);
        if (i < k)
        {
          localSpannableString.setSpan(new SuperscriptSpan(), i, k, 33);
          localSpannableString.setSpan(new RelativeSizeSpan(0.5F), i, k, 33);
          localSpannableString.setSpan(new AbsoluteSizeSpan(this.superscriptSize, this.changeDip), i, k, 33);
          if (((Boolean)this.mBold.get(3, Boolean.valueOf(false))).booleanValue()) {
            localSpannableString.setSpan(new StyleSpan(1), i, k, 33);
          }
        }
        this.view.setText(localSpannableString);
        this.view.removeCallbacks(this);
        this.view.postDelayed(this, this.pertime);
      }
    }
    if (this.curr_index >= this.nums.length)
    {
      this.view.removeCallbacks(this);
      if (this.mAnimListener != null)
      {
        this.mAnimListener.onFinished();
        if (QLog.isDevelopLevel()) {
          QLog.d("NumAnim", 4, "onFinished coast=" + (System.currentTimeMillis() - this.startTime));
        }
      }
    }
  }
  
  public void setAnimListener(NumAnim.AnimListener paramAnimListener)
  {
    this.mAnimListener = paramAnimListener;
  }
  
  public void setBold(int paramInt, boolean paramBoolean)
  {
    this.mBold.put(paramInt, Boolean.valueOf(paramBoolean));
  }
  
  public void setRuler(NumAnim.Ruler paramRuler)
  {
    this.mRuler = paramRuler;
  }
  
  /* Error */
  public void start(double paramDouble1, double paramDouble2, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 262	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3: ifeq +50 -> 53
    //   6: ldc 19
    //   8: iconst_4
    //   9: new 139	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 290
    //   19: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: dload_1
    //   23: invokevirtual 293	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   26: ldc_w 295
    //   29: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: dload_3
    //   33: invokevirtual 293	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   36: ldc_w 297
    //   39: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: lload 5
    //   44: invokevirtual 273	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   47: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 277	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_0
    //   54: invokestatic 270	java/lang/System:currentTimeMillis	()J
    //   57: putfield 117	com/tencent/mobileqq/activity/qwallet/widget/NumAnim:startTime	J
    //   60: aload_0
    //   61: getfield 119	com/tencent/mobileqq/activity/qwallet/widget/NumAnim:view	Landroid/widget/TextView;
    //   64: ifnonnull +4 -> 68
    //   67: return
    //   68: aload_0
    //   69: getfield 119	com/tencent/mobileqq/activity/qwallet/widget/NumAnim:view	Landroid/widget/TextView;
    //   72: aload_0
    //   73: invokevirtual 246	android/widget/TextView:removeCallbacks	(Ljava/lang/Runnable;)Z
    //   76: pop
    //   77: ldc2_w 298
    //   80: dload_1
    //   81: dmul
    //   82: invokestatic 164	com/tencent/mobileqq/activity/qwallet/widget/NumAnim:trimMax	(D)D
    //   85: dstore 7
    //   87: ldc2_w 298
    //   90: dload_3
    //   91: dmul
    //   92: invokestatic 164	com/tencent/mobileqq/activity/qwallet/widget/NumAnim:trimMax	(D)D
    //   95: dstore 9
    //   97: dload_1
    //   98: dload_3
    //   99: dcmpg
    //   100: ifge +100 -> 200
    //   103: iconst_1
    //   104: istore 11
    //   106: iload 11
    //   108: ifeq +98 -> 206
    //   111: dload 9
    //   113: dload 7
    //   115: dsub
    //   116: dstore_1
    //   117: ldc2_w 300
    //   120: lload 5
    //   122: lmul
    //   123: l2f
    //   124: ldc_w 302
    //   127: fdiv
    //   128: f2i
    //   129: istore 12
    //   131: dload_1
    //   132: ldc2_w 303
    //   135: dcmpg
    //   136: ifgt +7 -> 143
    //   139: dload_1
    //   140: d2i
    //   141: istore 12
    //   143: iload 12
    //   145: iconst_1
    //   146: iadd
    //   147: newarray double
    //   149: astore 14
    //   151: iconst_0
    //   152: istore 13
    //   154: iload 13
    //   156: iload 12
    //   158: if_icmpge +65 -> 223
    //   161: dload_1
    //   162: iload 12
    //   164: i2d
    //   165: ddiv
    //   166: iload 13
    //   168: i2d
    //   169: dmul
    //   170: dstore_3
    //   171: iload 11
    //   173: ifeq +42 -> 215
    //   176: dload_3
    //   177: dload 7
    //   179: dadd
    //   180: dstore_3
    //   181: aload 14
    //   183: iload 13
    //   185: dload_3
    //   186: ldc2_w 298
    //   189: ddiv
    //   190: dastore
    //   191: iload 13
    //   193: iconst_1
    //   194: iadd
    //   195: istore 13
    //   197: goto -43 -> 154
    //   200: iconst_0
    //   201: istore 11
    //   203: goto -97 -> 106
    //   206: dload 7
    //   208: dload 9
    //   210: dsub
    //   211: dstore_1
    //   212: goto -95 -> 117
    //   215: dload 7
    //   217: dload_3
    //   218: dsub
    //   219: dstore_3
    //   220: goto -39 -> 181
    //   223: aload 14
    //   225: iload 12
    //   227: dload 9
    //   229: ldc2_w 298
    //   232: ddiv
    //   233: dastore
    //   234: aload_0
    //   235: monitorenter
    //   236: aload_0
    //   237: aload 14
    //   239: putfield 162	com/tencent/mobileqq/activity/qwallet/widget/NumAnim:nums	[D
    //   242: aload 14
    //   244: arraylength
    //   245: iconst_1
    //   246: if_icmple +37 -> 283
    //   249: aload 14
    //   251: arraylength
    //   252: iconst_1
    //   253: isub
    //   254: istore 11
    //   256: aload_0
    //   257: lload 5
    //   259: iload 11
    //   261: i2l
    //   262: ldiv
    //   263: putfield 248	com/tencent/mobileqq/activity/qwallet/widget/NumAnim:pertime	J
    //   266: aload_0
    //   267: iconst_0
    //   268: putfield 160	com/tencent/mobileqq/activity/qwallet/widget/NumAnim:curr_index	I
    //   271: aload_0
    //   272: monitorexit
    //   273: aload_0
    //   274: getfield 119	com/tencent/mobileqq/activity/qwallet/widget/NumAnim:view	Landroid/widget/TextView;
    //   277: aload_0
    //   278: invokevirtual 307	android/widget/TextView:post	(Ljava/lang/Runnable;)Z
    //   281: pop
    //   282: return
    //   283: aload 14
    //   285: arraylength
    //   286: istore 11
    //   288: goto -32 -> 256
    //   291: astore 14
    //   293: aload_0
    //   294: monitorexit
    //   295: aload 14
    //   297: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	this	NumAnim
    //   0	298	1	paramDouble1	double
    //   0	298	3	paramDouble2	double
    //   0	298	5	paramLong	long
    //   85	131	7	d1	double
    //   95	133	9	d2	double
    //   104	183	11	i	int
    //   129	97	12	j	int
    //   152	44	13	k	int
    //   149	135	14	arrayOfDouble	double[]
    //   291	5	14	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   236	256	291	finally
    //   256	273	291	finally
    //   283	288	291	finally
    //   293	295	291	finally
  }
  
  public void stop()
  {
    if (this.view == null) {
      return;
    }
    this.view.removeCallbacks(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.NumAnim
 * JD-Core Version:    0.7.0.1
 */