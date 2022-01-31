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
import mbj;
import mbo;
import mbs;
import mbt;
import mqq.app.AppService;

public class BaseSmallScreenService
  extends AppService
  implements mbo
{
  int jdField_a_of_type_Int;
  Handler jdField_a_of_type_AndroidOsHandler;
  PhoneStateListener jdField_a_of_type_AndroidTelephonyPhoneStateListener = new mbj(this);
  TelephonyManager jdField_a_of_type_AndroidTelephonyTelephonyManager = null;
  View jdField_a_of_type_AndroidViewView = null;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  SmallScreenRelativeLayout jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = null;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  mbs jdField_a_of_type_Mbs = null;
  boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int;
  public SmallScreenRelativeLayout b;
  Runnable jdField_b_of_type_JavaLangRunnable = null;
  public mbs b;
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
    this.jdField_b_of_type_Mbs = null;
  }
  
  static void a(WindowManager.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.flags = 136;
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramLayoutParams.type = 2038;
      return;
    }
    if (mbt.a()) {}
    for (int i1 = 2005;; i1 = 2002)
    {
      paramLayoutParams.type = i1;
      return;
    }
  }
  
  public int a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    if (paramSmallScreenRelativeLayout == this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout) {}
    for (paramSmallScreenRelativeLayout = this.jdField_b_of_type_Mbs;; paramSmallScreenRelativeLayout = this.jdField_a_of_type_Mbs) {
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
    if (!this.jdField_b_of_type_Mbs.a()) {}
  }
  
  public void a(int paramInt, String paramString) {}
  
  void a(long paramLong) {}
  
  public void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout) {}
  
  public void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramSmallScreenRelativeLayout == this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout) {}
    for (paramSmallScreenRelativeLayout = this.jdField_b_of_type_Mbs;; paramSmallScreenRelativeLayout = this.jdField_a_of_type_Mbs)
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
    return mbt.f(((AppInterface)this.app).getApp());
  }
  
  public boolean a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    return true;
  }
  
  public int b(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    if (paramSmallScreenRelativeLayout == this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout) {}
    for (paramSmallScreenRelativeLayout = this.jdField_b_of_type_Mbs;; paramSmallScreenRelativeLayout = this.jdField_a_of_type_Mbs) {
      return paramSmallScreenRelativeLayout.a().y;
    }
  }
  
  void b()
  {
    this.jdField_a_of_type_Mbs.a();
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
    //   0: iconst_1
    //   1: istore_2
    //   2: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +11 -> 16
    //   8: ldc 167
    //   10: iconst_2
    //   11: ldc 211
    //   13: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aload_0
    //   17: invokespecial 213	mqq/app/AppService:onCreate	()V
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 44	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_d_of_type_Boolean	Z
    //   25: aload_0
    //   26: ldc 215
    //   28: invokevirtual 219	com/tencent/av/smallscreen/BaseSmallScreenService:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   31: checkcast 221	android/view/LayoutInflater
    //   34: astore_3
    //   35: aload_3
    //   36: ifnonnull +121 -> 157
    //   39: ldc 167
    //   41: iconst_1
    //   42: ldc 223
    //   44: invokestatic 225	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: aload_0
    //   48: invokevirtual 228	com/tencent/av/smallscreen/BaseSmallScreenService:stopSelf	()V
    //   51: return
    //   52: astore_3
    //   53: ldc 167
    //   55: iconst_1
    //   56: new 169	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   63: ldc 230
    //   65: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_3
    //   69: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 225	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aload_0
    //   79: invokevirtual 228	com/tencent/av/smallscreen/BaseSmallScreenService:stopSelf	()V
    //   82: return
    //   83: astore_3
    //   84: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +28 -> 115
    //   90: ldc 167
    //   92: iconst_2
    //   93: new 169	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   100: ldc 230
    //   102: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_3
    //   106: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 225	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: aconst_null
    //   116: astore_3
    //   117: goto -82 -> 35
    //   120: astore_3
    //   121: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   124: ifeq +28 -> 152
    //   127: ldc 167
    //   129: iconst_2
    //   130: new 169	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   137: ldc 230
    //   139: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_3
    //   143: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 225	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: aconst_null
    //   153: astore_3
    //   154: goto -119 -> 35
    //   157: aload_0
    //   158: aload_0
    //   159: ldc 235
    //   161: invokevirtual 219	com/tencent/av/smallscreen/BaseSmallScreenService:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   164: checkcast 237	android/telephony/TelephonyManager
    //   167: putfield 74	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidTelephonyTelephonyManager	Landroid/telephony/TelephonyManager;
    //   170: aload_0
    //   171: getfield 74	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidTelephonyTelephonyManager	Landroid/telephony/TelephonyManager;
    //   174: aload_0
    //   175: getfield 81	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidTelephonyPhoneStateListener	Landroid/telephony/PhoneStateListener;
    //   178: bipush 32
    //   180: invokevirtual 241	android/telephony/TelephonyManager:listen	(Landroid/telephony/PhoneStateListener;I)V
    //   183: aload_0
    //   184: aload_0
    //   185: invokevirtual 245	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   188: ldc 246
    //   190: invokevirtual 252	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   193: putfield 254	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_Int	I
    //   196: aload_0
    //   197: aload_0
    //   198: invokevirtual 245	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   201: ldc 255
    //   203: invokevirtual 252	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   206: putfield 257	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_Int	I
    //   209: aload_0
    //   210: aload_0
    //   211: invokevirtual 245	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   214: ldc_w 258
    //   217: invokevirtual 252	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   220: putfield 260	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_c_of_type_Int	I
    //   223: aload_0
    //   224: aload_0
    //   225: invokevirtual 245	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   228: ldc_w 261
    //   231: invokevirtual 252	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   234: putfield 263	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_d_of_type_Int	I
    //   237: aload_0
    //   238: aload_0
    //   239: invokevirtual 245	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   242: ldc_w 264
    //   245: invokevirtual 252	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   248: putfield 266	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_e_of_type_Int	I
    //   251: aload_0
    //   252: aload_0
    //   253: invokevirtual 245	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   256: ldc_w 267
    //   259: invokevirtual 252	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   262: putfield 269	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_f_of_type_Int	I
    //   265: aload_0
    //   266: aload_0
    //   267: invokevirtual 245	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   270: ldc_w 270
    //   273: invokevirtual 252	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   276: putfield 272	com/tencent/av/smallscreen/BaseSmallScreenService:g	I
    //   279: aload_0
    //   280: aload_0
    //   281: invokevirtual 245	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   284: ldc_w 273
    //   287: invokevirtual 252	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   290: putfield 275	com/tencent/av/smallscreen/BaseSmallScreenService:h	I
    //   293: aload_0
    //   294: aload_0
    //   295: invokevirtual 245	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   298: ldc_w 276
    //   301: invokevirtual 252	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   304: putfield 278	com/tencent/av/smallscreen/BaseSmallScreenService:i	I
    //   307: aload_0
    //   308: aload_0
    //   309: invokevirtual 245	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   312: ldc_w 279
    //   315: invokevirtual 252	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   318: putfield 281	com/tencent/av/smallscreen/BaseSmallScreenService:j	I
    //   321: aload_0
    //   322: aload_0
    //   323: invokevirtual 245	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   326: ldc_w 282
    //   329: invokevirtual 252	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   332: putfield 284	com/tencent/av/smallscreen/BaseSmallScreenService:k	I
    //   335: aload_0
    //   336: aload_0
    //   337: invokevirtual 245	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   340: ldc_w 285
    //   343: invokevirtual 252	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   346: putfield 287	com/tencent/av/smallscreen/BaseSmallScreenService:l	I
    //   349: aload_0
    //   350: aload_3
    //   351: ldc_w 288
    //   354: aconst_null
    //   355: invokevirtual 292	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   358: checkcast 202	com/tencent/av/smallscreen/SmallScreenRelativeLayout
    //   361: putfield 58	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   364: aload_0
    //   365: aload_3
    //   366: ldc_w 293
    //   369: aconst_null
    //   370: invokevirtual 292	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   373: checkcast 202	com/tencent/av/smallscreen/SmallScreenRelativeLayout
    //   376: putfield 56	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   379: aload_0
    //   380: getfield 58	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   383: invokevirtual 295	com/tencent/av/smallscreen/SmallScreenRelativeLayout:b	()V
    //   386: aload_0
    //   387: getfield 58	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   390: aload_0
    //   391: invokevirtual 299	com/tencent/av/smallscreen/SmallScreenRelativeLayout:setFloatListener	(Lmbo;)V
    //   394: aload_0
    //   395: getfield 56	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   398: aload_0
    //   399: invokevirtual 299	com/tencent/av/smallscreen/SmallScreenRelativeLayout:setFloatListener	(Lmbo;)V
    //   402: aload_0
    //   403: getfield 56	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   406: aload_0
    //   407: invokevirtual 245	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   410: ldc_w 300
    //   413: invokevirtual 252	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   416: iconst_5
    //   417: imul
    //   418: iconst_2
    //   419: idiv
    //   420: invokevirtual 304	com/tencent/av/smallscreen/SmallScreenRelativeLayout:setTitleHeight	(I)V
    //   423: aload_0
    //   424: aload_0
    //   425: getfield 56	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   428: ldc_w 305
    //   431: invokevirtual 309	com/tencent/av/smallscreen/SmallScreenRelativeLayout:findViewById	(I)Landroid/view/View;
    //   434: checkcast 311	android/widget/TextView
    //   437: putfield 64	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   440: aload_0
    //   441: new 109	mbs
    //   444: dup
    //   445: aload_0
    //   446: aload_0
    //   447: getfield 58	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   450: invokespecial 314	mbs:<init>	(Landroid/content/Context;Landroid/view/View;)V
    //   453: putfield 62	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_Mbs	Lmbs;
    //   456: aload_0
    //   457: new 109	mbs
    //   460: dup
    //   461: aload_0
    //   462: aload_0
    //   463: getfield 56	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   466: invokespecial 314	mbs:<init>	(Landroid/content/Context;Landroid/view/View;)V
    //   469: putfield 60	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_Mbs	Lmbs;
    //   472: aload_0
    //   473: getfield 58	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   476: iconst_1
    //   477: invokevirtual 318	com/tencent/av/smallscreen/SmallScreenRelativeLayout:setIsRotateSize	(Z)V
    //   480: aload_0
    //   481: getfield 58	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   484: aload_0
    //   485: getfield 254	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_Int	I
    //   488: aload_0
    //   489: getfield 257	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_Int	I
    //   492: invokevirtual 322	com/tencent/av/smallscreen/SmallScreenRelativeLayout:setSize	(II)V
    //   495: aload_0
    //   496: getfield 56	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   499: aload_0
    //   500: getfield 260	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_c_of_type_Int	I
    //   503: aload_0
    //   504: getfield 263	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_d_of_type_Int	I
    //   507: invokevirtual 322	com/tencent/av/smallscreen/SmallScreenRelativeLayout:setSize	(II)V
    //   510: aload_0
    //   511: getfield 62	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_Mbs	Lmbs;
    //   514: invokevirtual 112	mbs:a	()Landroid/view/WindowManager$LayoutParams;
    //   517: invokestatic 324	com/tencent/av/smallscreen/BaseSmallScreenService:a	(Landroid/view/WindowManager$LayoutParams;)V
    //   520: aload_0
    //   521: getfield 60	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_Mbs	Lmbs;
    //   524: invokevirtual 112	mbs:a	()Landroid/view/WindowManager$LayoutParams;
    //   527: invokestatic 324	com/tencent/av/smallscreen/BaseSmallScreenService:a	(Landroid/view/WindowManager$LayoutParams;)V
    //   530: aload_0
    //   531: aload_0
    //   532: getfield 56	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   535: ldc_w 325
    //   538: invokevirtual 309	com/tencent/av/smallscreen/SmallScreenRelativeLayout:findViewById	(I)Landroid/view/View;
    //   541: checkcast 327	android/widget/ImageView
    //   544: putfield 66	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   547: aload_0
    //   548: getfield 66	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   551: ldc_w 328
    //   554: invokevirtual 331	android/widget/ImageView:setImageResource	(I)V
    //   557: aload_0
    //   558: getfield 66	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   561: invokevirtual 335	android/widget/ImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   564: checkcast 337	android/graphics/drawable/AnimationDrawable
    //   567: invokevirtual 340	android/graphics/drawable/AnimationDrawable:start	()V
    //   570: aload_0
    //   571: aload_0
    //   572: getfield 56	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   575: ldc_w 341
    //   578: invokevirtual 309	com/tencent/av/smallscreen/SmallScreenRelativeLayout:findViewById	(I)Landroid/view/View;
    //   581: putfield 68	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   584: new 343	android/content/IntentFilter
    //   587: dup
    //   588: invokespecial 344	android/content/IntentFilter:<init>	()V
    //   591: astore_3
    //   592: aload_3
    //   593: ldc_w 346
    //   596: invokevirtual 350	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   599: aload_3
    //   600: ldc_w 352
    //   603: invokevirtual 350	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   606: aload_0
    //   607: invokestatic 354	mbt:i	()Z
    //   610: putfield 40	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_Boolean	Z
    //   613: getstatic 98	android/os/Build$VERSION:SDK_INT	I
    //   616: bipush 21
    //   618: if_icmplt +160 -> 778
    //   621: invokestatic 359	com/tencent/av/VideoController:a	()Lcom/tencent/av/VideoController;
    //   624: invokevirtual 362	com/tencent/av/VideoController:a	()Lmls;
    //   627: invokevirtual 366	mls:c	()Z
    //   630: ifeq +148 -> 778
    //   633: iconst_1
    //   634: istore_1
    //   635: aload_0
    //   636: getfield 87	com/tencent/av/smallscreen/BaseSmallScreenService:app	Lmqq/app/AppRuntime;
    //   639: checkcast 147	com/tencent/common/app/AppInterface
    //   642: invokevirtual 151	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   645: invokestatic 368	mbt:c	(Landroid/content/Context;)Z
    //   648: ifeq +135 -> 783
    //   651: iload_1
    //   652: ifne +131 -> 783
    //   655: aload_0
    //   656: iload_2
    //   657: putfield 46	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_e_of_type_Boolean	Z
    //   660: aload_0
    //   661: aload_0
    //   662: getfield 87	com/tencent/av/smallscreen/BaseSmallScreenService:app	Lmqq/app/AppRuntime;
    //   665: checkcast 147	com/tencent/common/app/AppInterface
    //   668: invokevirtual 151	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   671: invokestatic 370	mbt:b	(Landroid/content/Context;)Z
    //   674: putfield 42	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_c_of_type_Boolean	Z
    //   677: aload_0
    //   678: aload_0
    //   679: getfield 87	com/tencent/av/smallscreen/BaseSmallScreenService:app	Lmqq/app/AppRuntime;
    //   682: checkcast 147	com/tencent/common/app/AppInterface
    //   685: invokevirtual 151	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   688: invokestatic 154	mbt:f	(Landroid/content/Context;)Z
    //   691: putfield 48	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_f_of_type_Boolean	Z
    //   694: aload_0
    //   695: getfield 70	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   698: ifnonnull +15 -> 713
    //   701: aload_0
    //   702: new 372	com/tencent/av/smallscreen/BaseSmallScreenService$InitRunnable
    //   705: dup
    //   706: aload_0
    //   707: invokespecial 373	com/tencent/av/smallscreen/BaseSmallScreenService$InitRunnable:<init>	(Lcom/tencent/av/smallscreen/BaseSmallScreenService;)V
    //   710: putfield 70	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   713: aload_0
    //   714: invokevirtual 375	com/tencent/av/smallscreen/BaseSmallScreenService:a	()Landroid/os/Handler;
    //   717: aload_0
    //   718: getfield 70	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   721: ldc2_w 376
    //   724: invokevirtual 381	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   727: pop
    //   728: aload_0
    //   729: getfield 72	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   732: ifnonnull +15 -> 747
    //   735: aload_0
    //   736: new 383	com/tencent/av/smallscreen/BaseSmallScreenService$OnOpChangedRunnable
    //   739: dup
    //   740: aload_0
    //   741: invokespecial 384	com/tencent/av/smallscreen/BaseSmallScreenService$OnOpChangedRunnable:<init>	(Lcom/tencent/av/smallscreen/BaseSmallScreenService;)V
    //   744: putfield 72	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   747: aload_0
    //   748: invokevirtual 375	com/tencent/av/smallscreen/BaseSmallScreenService:a	()Landroid/os/Handler;
    //   751: aload_0
    //   752: getfield 72	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   755: ldc2_w 385
    //   758: invokevirtual 381	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   761: pop
    //   762: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   765: ifeq -714 -> 51
    //   768: ldc 167
    //   770: iconst_2
    //   771: ldc_w 388
    //   774: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   777: return
    //   778: iconst_0
    //   779: istore_1
    //   780: goto -145 -> 635
    //   783: iconst_0
    //   784: istore_2
    //   785: goto -130 -> 655
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	788	0	this	BaseSmallScreenService
    //   634	146	1	i1	int
    //   1	784	2	bool	boolean
    //   34	2	3	localLayoutInflater	android.view.LayoutInflater
    //   52	17	3	localException1	java.lang.Exception
    //   83	23	3	localException2	java.lang.Exception
    //   116	1	3	localObject	java.lang.Object
    //   120	23	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   153	447	3	localIntentFilter	android.content.IntentFilter
    // Exception table:
    //   from	to	target	type
    //   16	20	52	java/lang/Exception
    //   25	35	83	java/lang/Exception
    //   25	35	120	java/lang/OutOfMemoryError
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
    this.jdField_a_of_type_Mbs.b();
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.c();
    this.jdField_a_of_type_Mbs = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.smallscreen.BaseSmallScreenService
 * JD-Core Version:    0.7.0.1
 */