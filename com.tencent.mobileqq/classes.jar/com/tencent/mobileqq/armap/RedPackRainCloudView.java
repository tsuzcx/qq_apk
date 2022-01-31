package com.tencent.mobileqq.armap;

import aawa;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.SuperscriptSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.armap.wealthgod.ARMapFlakeView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.text.NumberFormat;

public class RedPackRainCloudView
  extends RelativeLayout
{
  public static String a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SdCardImageAnimView jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView;
  private ARMapFlakeView jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapFlakeView;
  public boolean a;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = "topbar";
  public boolean b;
  private int c;
  public boolean c;
  private boolean d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "RedPackRainCloudView";
  }
  
  public RedPackRainCloudView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
  }
  
  public RedPackRainCloudView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
  }
  
  @TargetApi(11)
  private void a(long paramLong)
  {
    if ((this.jdField_a_of_type_Long == -1L) || (!VersionUtils.e()))
    {
      this.jdField_a_of_type_Long = paramLong;
      int i = String.valueOf(paramLong).length();
      if (i >= 8) {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 19.0F);
      }
      for (;;)
      {
        localObject = NumberFormat.getNumberInstance();
        localObject = new SpannableString(((NumberFormat)localObject).format(paramLong) + "个");
        ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(-10066330);
        ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(12, true), ((SpannableString)localObject).length() - 1, ((SpannableString)localObject).length(), 33);
        ((SpannableString)localObject).setSpan(localForegroundColorSpan, ((SpannableString)localObject).length() - 1, ((SpannableString)localObject).length(), 33);
        ((SpannableString)localObject).setSpan(new StyleSpan(1), 0, ((SpannableString)localObject).length() - 1, 33);
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        return;
        if (i >= 7) {
          this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 21.0F);
        } else if (i >= 6) {
          this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 23.0F);
        } else if (i >= 5) {
          this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 25.0F);
        } else {
          this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 27.0F);
        }
      }
    }
    Object localObject = ValueAnimator.ofInt(new int[] { (int)this.jdField_a_of_type_Long, (int)paramLong });
    ((ValueAnimator)localObject).addUpdateListener(new aawa(this));
    ((ValueAnimator)localObject).setInterpolator(new DecelerateInterpolator());
    ((ValueAnimator)localObject).setDuration(400L);
    ((ValueAnimator)localObject).start();
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void c()
  {
    LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970213, this);
    this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView = ((SdCardImageAnimView)findViewById(2131369658));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369657);
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapFlakeView = ((ARMapFlakeView)findViewById(2131369656));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369659));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363787));
    this.jdField_a_of_type_Int = AIOUtils.a(68.0F, getResources());
    this.jdField_b_of_type_Int = AIOUtils.a(8.0F, getResources());
    this.jdField_c_of_type_Int = AIOUtils.a(20.0F, getResources());
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView == null) {}
    while ((this.jdField_a_of_type_Boolean) || (!this.d)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.a();
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapFlakeView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapFlakeView.c();
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapFlakeView.b();
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 213	com/tencent/mobileqq/armap/RedPackRainCloudView:d	Z
    //   4: ifne +7 -> 11
    //   7: aload_1
    //   8: ifnonnull +4 -> 12
    //   11: return
    //   12: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +12 -> 27
    //   18: getstatic 23	com/tencent/mobileqq/armap/RedPackRainCloudView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: iconst_2
    //   22: ldc 228
    //   24: invokestatic 232	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: invokestatic 237	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   30: ldc 239
    //   32: invokevirtual 243	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   35: ifeq +336 -> 371
    //   38: new 245	java/io/File
    //   41: dup
    //   42: aload_1
    //   43: invokespecial 247	java/io/File:<init>	(Ljava/lang/String;)V
    //   46: invokevirtual 250	java/io/File:exists	()Z
    //   49: ifeq +322 -> 371
    //   52: new 83	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   59: aload_1
    //   60: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: ldc 252
    //   65: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_0
    //   69: getfield 36	com/tencent/mobileqq/armap/RedPackRainCloudView:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   72: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc 254
    //   77: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 259	com/tencent/mobileqq/armap/utils/ARResUtil:a	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   86: astore 9
    //   88: aload 9
    //   90: ifnull +281 -> 371
    //   93: new 261	java/util/ArrayList
    //   96: dup
    //   97: invokespecial 262	java/util/ArrayList:<init>	()V
    //   100: astore 8
    //   102: aload 9
    //   104: ldc_w 264
    //   107: invokevirtual 270	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   110: invokestatic 276	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   113: istore 7
    //   115: aload 9
    //   117: ldc_w 278
    //   120: invokevirtual 270	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   123: invokestatic 284	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   126: fstore_2
    //   127: fload_2
    //   128: f2d
    //   129: ldc2_w 285
    //   132: dcmpl
    //   133: ifle +262 -> 395
    //   136: iload 7
    //   138: i2f
    //   139: fload_2
    //   140: fdiv
    //   141: ldc_w 287
    //   144: fadd
    //   145: f2i
    //   146: istore_3
    //   147: iload_3
    //   148: bipush 20
    //   150: if_icmple +239 -> 389
    //   153: iload_3
    //   154: iconst_2
    //   155: idiv
    //   156: istore 4
    //   158: iload 4
    //   160: istore_3
    //   161: iconst_2
    //   162: istore 4
    //   164: iconst_0
    //   165: istore 5
    //   167: iload_3
    //   168: istore 6
    //   170: iload 5
    //   172: iload 7
    //   174: if_icmpge +116 -> 290
    //   177: new 245	java/io/File
    //   180: dup
    //   181: new 83	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   188: aload_1
    //   189: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: ldc 252
    //   194: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_0
    //   198: getfield 36	com/tencent/mobileqq/armap/RedPackRainCloudView:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   201: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: iload 5
    //   206: invokevirtual 290	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   209: ldc_w 292
    //   212: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokespecial 247	java/io/File:<init>	(Ljava/lang/String;)V
    //   221: invokevirtual 250	java/io/File:exists	()Z
    //   224: ifeq +46 -> 270
    //   227: aload 8
    //   229: new 83	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   236: aload_1
    //   237: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: ldc 252
    //   242: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload_0
    //   246: getfield 36	com/tencent/mobileqq/armap/RedPackRainCloudView:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   249: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: iload 5
    //   254: invokevirtual 290	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   257: ldc_w 292
    //   260: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokevirtual 295	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   269: pop
    //   270: iload 5
    //   272: iload 4
    //   274: iadd
    //   275: istore 5
    //   277: goto -110 -> 167
    //   280: astore_1
    //   281: iconst_0
    //   282: istore_3
    //   283: aload_1
    //   284: invokevirtual 298	org/json/JSONException:printStackTrace	()V
    //   287: iload_3
    //   288: istore 6
    //   290: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   293: ifeq +45 -> 338
    //   296: getstatic 23	com/tencent/mobileqq/armap/RedPackRainCloudView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   299: iconst_2
    //   300: new 83	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   307: ldc_w 300
    //   310: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: iload 6
    //   315: invokevirtual 290	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   318: ldc_w 302
    //   321: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: aload 8
    //   326: invokevirtual 305	java/util/ArrayList:size	()I
    //   329: invokevirtual 290	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   332: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 232	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: aload 8
    //   340: invokevirtual 305	java/util/ArrayList:size	()I
    //   343: ifle +23 -> 366
    //   346: aload_0
    //   347: getfield 179	com/tencent/mobileqq/armap/RedPackRainCloudView:jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView	Lcom/tencent/mobileqq/armap/SdCardImageAnimView;
    //   350: aload 8
    //   352: iconst_1
    //   353: iconst_0
    //   354: invokevirtual 309	com/tencent/mobileqq/armap/SdCardImageAnimView:setAnimationData	(Ljava/util/ArrayList;ZZ)V
    //   357: aload_0
    //   358: getfield 179	com/tencent/mobileqq/armap/RedPackRainCloudView:jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView	Lcom/tencent/mobileqq/armap/SdCardImageAnimView;
    //   361: iload 6
    //   363: invokevirtual 312	com/tencent/mobileqq/armap/SdCardImageAnimView:setFPS	(I)V
    //   366: aload_0
    //   367: iconst_1
    //   368: putfield 213	com/tencent/mobileqq/armap/RedPackRainCloudView:d	Z
    //   371: aload_0
    //   372: getfield 187	com/tencent/mobileqq/armap/RedPackRainCloudView:jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapFlakeView	Lcom/tencent/mobileqq/armap/wealthgod/ARMapFlakeView;
    //   375: bipush 101
    //   377: invokevirtual 315	com/tencent/mobileqq/armap/wealthgod/ARMapFlakeView:setDataType	(I)V
    //   380: return
    //   381: astore_1
    //   382: goto -99 -> 283
    //   385: astore_1
    //   386: goto -103 -> 283
    //   389: iconst_1
    //   390: istore 4
    //   392: goto -228 -> 164
    //   395: iconst_0
    //   396: istore_3
    //   397: goto -250 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	this	RedPackRainCloudView
    //   0	400	1	paramString	String
    //   126	14	2	f	float
    //   146	251	3	i	int
    //   156	235	4	j	int
    //   165	111	5	k	int
    //   168	194	6	m	int
    //   113	62	7	n	int
    //   100	251	8	localArrayList	java.util.ArrayList
    //   86	30	9	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   102	127	280	org/json/JSONException
    //   153	158	381	org/json/JSONException
    //   177	270	385	org/json/JSONException
  }
  
  public void a(String paramString, long paramLong)
  {
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.setImageResource(2130842249);
      this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(this.jdField_a_of_type_Int, 0, this.jdField_b_of_type_Int, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(this.jdField_a_of_type_Int, 0, this.jdField_c_of_type_Int, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(1);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "bindActiveData swtich status");
      }
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    a(paramLong);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean))
    {
      b();
      this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.setImageBitmap(null);
      this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(1);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "bindWaitData swtich status");
      }
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
    if (paramBoolean)
    {
      paramString1 = new SpannableString("还需等待 " + paramString2);
      paramString2 = new ForegroundColorSpan(-10066330);
      paramString1.setSpan(new AbsoluteSizeSpan(12, true), 0, "还需等待 ".length(), 33);
      paramString1.setSpan(paramString2, 0, "还需等待 ".length(), 33);
      paramString1.setSpan(new SuperscriptSpan(), 0, "还需等待 ".length(), 33);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString1);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 29.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, 0);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString2);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapFlakeView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapFlakeView.a();
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b(String paramString)
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      b();
      this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.setImageBitmap(null);
      this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(35.0F, getResources()), AIOUtils.a(43.0F, getResources()), AIOUtils.a(35.0F, getResources()), 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 18.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(2);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "bindZeroData swtich status");
      }
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void setOnCloudClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.RedPackRainCloudView
 * JD-Core Version:    0.7.0.1
 */