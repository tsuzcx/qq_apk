package com.tencent.av.smallscreen;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import lyu;
import lyz;
import lzd;
import lze;
import mqq.app.AppService;

public class BaseSmallScreenService
  extends AppService
  implements lyz
{
  int jdField_a_of_type_Int;
  Handler jdField_a_of_type_AndroidOsHandler;
  PhoneStateListener jdField_a_of_type_AndroidTelephonyPhoneStateListener = new lyu(this);
  TelephonyManager jdField_a_of_type_AndroidTelephonyTelephonyManager = null;
  View jdField_a_of_type_AndroidViewView = null;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  SmallScreenRelativeLayout jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = null;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  lzd jdField_a_of_type_Lzd = null;
  boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int;
  public SmallScreenRelativeLayout b;
  Runnable jdField_b_of_type_JavaLangRunnable = null;
  public lzd b;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int;
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int;
  boolean jdField_e_of_type_Boolean = true;
  int jdField_f_of_type_Int;
  boolean jdField_f_of_type_Boolean = false;
  int g;
  int h;
  int i;
  int j;
  int k;
  int l;
  int m = 0;
  int n = 7;
  int o = 0;
  
  public BaseSmallScreenService()
  {
    this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = null;
    this.jdField_b_of_type_Lzd = null;
  }
  
  static void a(WindowManager.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.flags = 136;
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramLayoutParams.type = 2038;
      return;
    }
    if (lze.a()) {}
    for (int i1 = 2005;; i1 = 2002)
    {
      paramLayoutParams.type = i1;
      return;
    }
  }
  
  public int a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    if (paramSmallScreenRelativeLayout == this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout) {}
    for (paramSmallScreenRelativeLayout = this.jdField_b_of_type_Lzd;; paramSmallScreenRelativeLayout = this.jdField_a_of_type_Lzd) {
      return paramSmallScreenRelativeLayout.a().x;
    }
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  void a()
  {
    if (!this.jdField_b_of_type_Lzd.a()) {}
  }
  
  public void a(int paramInt, String paramString) {}
  
  void a(long paramLong) {}
  
  public void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout) {}
  
  public void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramSmallScreenRelativeLayout == this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout) {}
    for (paramSmallScreenRelativeLayout = this.jdField_b_of_type_Lzd;; paramSmallScreenRelativeLayout = this.jdField_a_of_type_Lzd)
    {
      WindowManager.LayoutParams localLayoutParams = paramSmallScreenRelativeLayout.a();
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
      localLayoutParams.width = (paramInt3 - paramInt1);
      localLayoutParams.height = (paramInt4 - paramInt2);
      paramSmallScreenRelativeLayout.c();
      return;
    }
  }
  
  protected boolean a()
  {
    return lze.f(((AppInterface)this.app).getApp());
  }
  
  public boolean a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    return true;
  }
  
  public int b(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    if (paramSmallScreenRelativeLayout == this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout) {}
    for (paramSmallScreenRelativeLayout = this.jdField_b_of_type_Lzd;; paramSmallScreenRelativeLayout = this.jdField_a_of_type_Lzd) {
      return paramSmallScreenRelativeLayout.a().y;
    }
  }
  
  void b()
  {
    this.jdField_a_of_type_Lzd.a();
  }
  
  void c()
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("BaseSmallScreenService", 1, "onIsLockChanged, mIsLock[" + this.jdField_c_of_type_Boolean + "], seq[" + l1 + "]");
    }
    a(l1);
  }
  
  void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "onHasSmartBarChanged mHasSmartBar = " + this.jdField_b_of_type_Boolean);
    }
    if (this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout != null) {
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();
    }
  }
  
  void e() {}
  
  void f() {}
  
  /* Error */
  public void onCreate()
  {
    // Byte code:
    //   0: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 167
    //   8: iconst_2
    //   9: ldc 211
    //   11: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: invokespecial 213	mqq/app/AppService:onCreate	()V
    //   18: aload_0
    //   19: iconst_0
    //   20: putfield 44	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_d_of_type_Boolean	Z
    //   23: aload_0
    //   24: ldc 215
    //   26: invokevirtual 219	com/tencent/av/smallscreen/BaseSmallScreenService:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   29: checkcast 221	android/view/LayoutInflater
    //   32: astore_1
    //   33: aload_1
    //   34: ifnonnull +121 -> 155
    //   37: ldc 167
    //   39: iconst_1
    //   40: ldc 223
    //   42: invokestatic 225	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload_0
    //   46: invokevirtual 228	com/tencent/av/smallscreen/BaseSmallScreenService:stopSelf	()V
    //   49: return
    //   50: astore_1
    //   51: ldc 167
    //   53: iconst_1
    //   54: new 169	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   61: ldc 230
    //   63: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 225	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload_0
    //   77: invokevirtual 228	com/tencent/av/smallscreen/BaseSmallScreenService:stopSelf	()V
    //   80: return
    //   81: astore_1
    //   82: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq +28 -> 113
    //   88: ldc 167
    //   90: iconst_2
    //   91: new 169	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   98: ldc 230
    //   100: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_1
    //   104: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 225	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aconst_null
    //   114: astore_1
    //   115: goto -82 -> 33
    //   118: astore_1
    //   119: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +28 -> 150
    //   125: ldc 167
    //   127: iconst_2
    //   128: new 169	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   135: ldc 230
    //   137: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_1
    //   141: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 225	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aconst_null
    //   151: astore_1
    //   152: goto -119 -> 33
    //   155: aload_0
    //   156: aload_0
    //   157: ldc 235
    //   159: invokevirtual 219	com/tencent/av/smallscreen/BaseSmallScreenService:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   162: checkcast 237	android/telephony/TelephonyManager
    //   165: putfield 74	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidTelephonyTelephonyManager	Landroid/telephony/TelephonyManager;
    //   168: aload_0
    //   169: getfield 74	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidTelephonyTelephonyManager	Landroid/telephony/TelephonyManager;
    //   172: aload_0
    //   173: getfield 81	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidTelephonyPhoneStateListener	Landroid/telephony/PhoneStateListener;
    //   176: bipush 32
    //   178: invokevirtual 241	android/telephony/TelephonyManager:listen	(Landroid/telephony/PhoneStateListener;I)V
    //   181: aload_0
    //   182: aload_0
    //   183: invokevirtual 245	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   186: ldc 246
    //   188: invokevirtual 252	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   191: putfield 254	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_Int	I
    //   194: aload_0
    //   195: aload_0
    //   196: invokevirtual 245	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   199: ldc 255
    //   201: invokevirtual 252	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   204: putfield 257	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_Int	I
    //   207: aload_0
    //   208: aload_0
    //   209: invokevirtual 245	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   212: ldc_w 258
    //   215: invokevirtual 252	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   218: putfield 260	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_c_of_type_Int	I
    //   221: aload_0
    //   222: aload_0
    //   223: invokevirtual 245	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   226: ldc_w 261
    //   229: invokevirtual 252	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   232: putfield 263	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_d_of_type_Int	I
    //   235: aload_0
    //   236: aload_0
    //   237: invokevirtual 245	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   240: ldc_w 264
    //   243: invokevirtual 252	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   246: putfield 266	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_e_of_type_Int	I
    //   249: aload_0
    //   250: aload_0
    //   251: invokevirtual 245	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   254: ldc_w 267
    //   257: invokevirtual 252	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   260: putfield 269	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_f_of_type_Int	I
    //   263: aload_0
    //   264: aload_0
    //   265: invokevirtual 245	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   268: ldc_w 270
    //   271: invokevirtual 252	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   274: putfield 272	com/tencent/av/smallscreen/BaseSmallScreenService:g	I
    //   277: aload_0
    //   278: aload_0
    //   279: invokevirtual 245	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   282: ldc_w 273
    //   285: invokevirtual 252	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   288: putfield 275	com/tencent/av/smallscreen/BaseSmallScreenService:h	I
    //   291: aload_0
    //   292: aload_0
    //   293: invokevirtual 245	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   296: ldc_w 276
    //   299: invokevirtual 252	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   302: putfield 278	com/tencent/av/smallscreen/BaseSmallScreenService:i	I
    //   305: aload_0
    //   306: aload_0
    //   307: invokevirtual 245	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   310: ldc_w 279
    //   313: invokevirtual 252	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   316: putfield 281	com/tencent/av/smallscreen/BaseSmallScreenService:j	I
    //   319: aload_0
    //   320: aload_0
    //   321: invokevirtual 245	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   324: ldc_w 282
    //   327: invokevirtual 252	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   330: putfield 284	com/tencent/av/smallscreen/BaseSmallScreenService:k	I
    //   333: aload_0
    //   334: aload_0
    //   335: invokevirtual 245	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   338: ldc_w 285
    //   341: invokevirtual 252	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   344: putfield 287	com/tencent/av/smallscreen/BaseSmallScreenService:l	I
    //   347: aload_0
    //   348: aload_1
    //   349: ldc_w 288
    //   352: aconst_null
    //   353: invokevirtual 292	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   356: checkcast 202	com/tencent/av/smallscreen/SmallScreenRelativeLayout
    //   359: putfield 58	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   362: aload_0
    //   363: aload_1
    //   364: ldc_w 293
    //   367: aconst_null
    //   368: invokevirtual 292	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   371: checkcast 202	com/tencent/av/smallscreen/SmallScreenRelativeLayout
    //   374: putfield 56	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   377: aload_0
    //   378: getfield 58	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   381: invokevirtual 295	com/tencent/av/smallscreen/SmallScreenRelativeLayout:b	()V
    //   384: aload_0
    //   385: getfield 58	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   388: aload_0
    //   389: invokevirtual 299	com/tencent/av/smallscreen/SmallScreenRelativeLayout:setFloatListener	(Llyz;)V
    //   392: aload_0
    //   393: getfield 56	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   396: aload_0
    //   397: invokevirtual 299	com/tencent/av/smallscreen/SmallScreenRelativeLayout:setFloatListener	(Llyz;)V
    //   400: aload_0
    //   401: getfield 56	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   404: aload_0
    //   405: invokevirtual 245	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   408: ldc_w 300
    //   411: invokevirtual 252	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   414: iconst_5
    //   415: imul
    //   416: iconst_2
    //   417: idiv
    //   418: invokevirtual 304	com/tencent/av/smallscreen/SmallScreenRelativeLayout:setTitleHeight	(I)V
    //   421: aload_0
    //   422: aload_0
    //   423: getfield 56	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   426: ldc_w 305
    //   429: invokevirtual 309	com/tencent/av/smallscreen/SmallScreenRelativeLayout:findViewById	(I)Landroid/view/View;
    //   432: checkcast 311	android/widget/TextView
    //   435: putfield 64	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   438: aload_0
    //   439: new 109	lzd
    //   442: dup
    //   443: aload_0
    //   444: aload_0
    //   445: getfield 58	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   448: invokespecial 314	lzd:<init>	(Landroid/content/Context;Landroid/view/View;)V
    //   451: putfield 62	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_Lzd	Llzd;
    //   454: aload_0
    //   455: new 109	lzd
    //   458: dup
    //   459: aload_0
    //   460: aload_0
    //   461: getfield 56	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   464: invokespecial 314	lzd:<init>	(Landroid/content/Context;Landroid/view/View;)V
    //   467: putfield 60	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_Lzd	Llzd;
    //   470: aload_0
    //   471: getfield 58	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   474: iconst_1
    //   475: invokevirtual 318	com/tencent/av/smallscreen/SmallScreenRelativeLayout:setIsRotateSize	(Z)V
    //   478: aload_0
    //   479: getfield 58	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   482: aload_0
    //   483: getfield 254	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_Int	I
    //   486: aload_0
    //   487: getfield 257	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_Int	I
    //   490: invokevirtual 322	com/tencent/av/smallscreen/SmallScreenRelativeLayout:setSize	(II)V
    //   493: aload_0
    //   494: getfield 56	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   497: aload_0
    //   498: getfield 260	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_c_of_type_Int	I
    //   501: aload_0
    //   502: getfield 263	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_d_of_type_Int	I
    //   505: invokevirtual 322	com/tencent/av/smallscreen/SmallScreenRelativeLayout:setSize	(II)V
    //   508: aload_0
    //   509: getfield 62	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_Lzd	Llzd;
    //   512: invokevirtual 112	lzd:a	()Landroid/view/WindowManager$LayoutParams;
    //   515: invokestatic 324	com/tencent/av/smallscreen/BaseSmallScreenService:a	(Landroid/view/WindowManager$LayoutParams;)V
    //   518: aload_0
    //   519: getfield 60	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_Lzd	Llzd;
    //   522: invokevirtual 112	lzd:a	()Landroid/view/WindowManager$LayoutParams;
    //   525: invokestatic 324	com/tencent/av/smallscreen/BaseSmallScreenService:a	(Landroid/view/WindowManager$LayoutParams;)V
    //   528: aload_0
    //   529: aload_0
    //   530: getfield 56	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   533: ldc_w 325
    //   536: invokevirtual 309	com/tencent/av/smallscreen/SmallScreenRelativeLayout:findViewById	(I)Landroid/view/View;
    //   539: checkcast 327	android/widget/ImageView
    //   542: putfield 66	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   545: aload_0
    //   546: getfield 66	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   549: ldc_w 328
    //   552: invokevirtual 331	android/widget/ImageView:setImageResource	(I)V
    //   555: aload_0
    //   556: getfield 66	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   559: invokevirtual 335	android/widget/ImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   562: checkcast 337	android/graphics/drawable/AnimationDrawable
    //   565: invokevirtual 340	android/graphics/drawable/AnimationDrawable:start	()V
    //   568: aload_0
    //   569: aload_0
    //   570: getfield 56	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   573: ldc_w 341
    //   576: invokevirtual 309	com/tencent/av/smallscreen/SmallScreenRelativeLayout:findViewById	(I)Landroid/view/View;
    //   579: putfield 68	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   582: new 343	android/content/IntentFilter
    //   585: dup
    //   586: invokespecial 344	android/content/IntentFilter:<init>	()V
    //   589: astore_1
    //   590: aload_1
    //   591: ldc_w 346
    //   594: invokevirtual 350	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   597: aload_1
    //   598: ldc_w 352
    //   601: invokevirtual 350	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   604: aload_0
    //   605: invokestatic 354	lze:i	()Z
    //   608: putfield 40	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_Boolean	Z
    //   611: aload_0
    //   612: aload_0
    //   613: getfield 87	com/tencent/av/smallscreen/BaseSmallScreenService:app	Lmqq/app/AppRuntime;
    //   616: checkcast 147	com/tencent/common/app/AppInterface
    //   619: invokevirtual 151	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   622: invokestatic 356	lze:c	(Landroid/content/Context;)Z
    //   625: putfield 46	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_e_of_type_Boolean	Z
    //   628: aload_0
    //   629: aload_0
    //   630: getfield 87	com/tencent/av/smallscreen/BaseSmallScreenService:app	Lmqq/app/AppRuntime;
    //   633: checkcast 147	com/tencent/common/app/AppInterface
    //   636: invokevirtual 151	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   639: invokestatic 358	lze:b	(Landroid/content/Context;)Z
    //   642: putfield 42	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_c_of_type_Boolean	Z
    //   645: aload_0
    //   646: aload_0
    //   647: getfield 87	com/tencent/av/smallscreen/BaseSmallScreenService:app	Lmqq/app/AppRuntime;
    //   650: checkcast 147	com/tencent/common/app/AppInterface
    //   653: invokevirtual 151	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   656: invokestatic 154	lze:f	(Landroid/content/Context;)Z
    //   659: putfield 48	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_f_of_type_Boolean	Z
    //   662: aload_0
    //   663: getfield 70	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   666: ifnonnull +15 -> 681
    //   669: aload_0
    //   670: new 360	com/tencent/av/smallscreen/BaseSmallScreenService$InitRunnable
    //   673: dup
    //   674: aload_0
    //   675: invokespecial 361	com/tencent/av/smallscreen/BaseSmallScreenService$InitRunnable:<init>	(Lcom/tencent/av/smallscreen/BaseSmallScreenService;)V
    //   678: putfield 70	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   681: aload_0
    //   682: invokevirtual 363	com/tencent/av/smallscreen/BaseSmallScreenService:a	()Landroid/os/Handler;
    //   685: aload_0
    //   686: getfield 70	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   689: ldc2_w 364
    //   692: invokevirtual 369	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   695: pop
    //   696: aload_0
    //   697: getfield 72	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   700: ifnonnull +15 -> 715
    //   703: aload_0
    //   704: new 371	com/tencent/av/smallscreen/BaseSmallScreenService$OnOpChangedRunnable
    //   707: dup
    //   708: aload_0
    //   709: invokespecial 372	com/tencent/av/smallscreen/BaseSmallScreenService$OnOpChangedRunnable:<init>	(Lcom/tencent/av/smallscreen/BaseSmallScreenService;)V
    //   712: putfield 72	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   715: aload_0
    //   716: invokevirtual 363	com/tencent/av/smallscreen/BaseSmallScreenService:a	()Landroid/os/Handler;
    //   719: aload_0
    //   720: getfield 72	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   723: ldc2_w 373
    //   726: invokevirtual 369	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   729: pop
    //   730: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   733: ifeq -684 -> 49
    //   736: ldc 167
    //   738: iconst_2
    //   739: ldc_w 376
    //   742: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   745: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	746	0	this	BaseSmallScreenService
    //   32	2	1	localLayoutInflater	android.view.LayoutInflater
    //   50	17	1	localException1	java.lang.Exception
    //   81	23	1	localException2	java.lang.Exception
    //   114	1	1	localObject	java.lang.Object
    //   118	23	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   151	447	1	localIntentFilter	android.content.IntentFilter
    // Exception table:
    //   from	to	target	type
    //   14	18	50	java/lang/Exception
    //   23	33	81	java/lang/Exception
    //   23	33	118	java/lang/OutOfMemoryError
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "onDestroy start");
    }
    super.onDestroy();
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidTelephonyTelephonyManager.listen(this.jdField_a_of_type_AndroidTelephonyPhoneStateListener, 0);
    this.jdField_a_of_type_AndroidTelephonyTelephonyManager = null;
    if (this.jdField_b_of_type_JavaLangRunnable != null) {
      a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_AndroidTelephonyPhoneStateListener = null;
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_b_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_Lzd.b();
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.c();
    this.jdField_a_of_type_Lzd = null;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = null;
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "onDestroy end");
    }
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "onLowMemory");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.smallscreen.BaseSmallScreenService
 * JD-Core Version:    0.7.0.1
 */