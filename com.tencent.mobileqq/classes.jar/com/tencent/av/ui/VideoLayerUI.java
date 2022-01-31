package com.tencent.av.ui;

import actn;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import axqw;
import ayki;
import aykp;
import bbjn;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.widget.RotateLayout;
import com.tencent.av.widget.RotateLayout.LayoutParams;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import lcl;
import ldw;
import lgf;
import lhh;
import ljo;
import ljt;
import lmz;
import lqq;
import lqt;
import lrx;
import lsg;
import lsh;
import lsi;
import lsn;
import lsr;
import lss;
import lsv;
import lty;
import lzj;
import mat;
import mck;
import mcq;
import mee;
import miw;
import mjd;
import mju;
import mkw;
import mkx;
import mky;
import mkz;
import mla;
import mlb;
import mlc;
import mld;
import mle;
import mlf;
import mlg;
import mlh;
import mlj;
import mlm;
import mom;
import mqq;
import mqq.os.MqqHandler;
import msp;
import muf;

public class VideoLayerUI
  extends VideoLayerUIBase
{
  private int A;
  private int B;
  private volatile int C = -1;
  private int D = -1;
  private final int E = MultiVideoCtrlLayerUIBase.b;
  private int F = -1;
  private int G = -1;
  private int H;
  private int I;
  private int J;
  public long a;
  private DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
  public GestureDetector a;
  private ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public AVActivity.AnimationTrigger a;
  protected VideoLayerUI.MultiVideoOpenAnimation a;
  private RotateLayout jdField_a_of_type_ComTencentAvWidgetRotateLayout;
  private ArrayList<lsh> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Long, mlj> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private lqq jdField_a_of_type_Lqq;
  private lsn jdField_a_of_type_Lsn;
  private lsr jdField_a_of_type_Lsr;
  private lty jdField_a_of_type_Lty;
  private mju jdField_a_of_type_Mju = new mju(this.jdField_a_of_type_AndroidContentContext, paramVideoAppInterface, this);
  private mle jdField_a_of_type_Mle;
  private mlm jdField_a_of_type_Mlm = new mlm(this.jdField_a_of_type_ComTencentAvVideoController);
  mom jdField_a_of_type_Mom;
  private GestureDetector jdField_b_of_type_AndroidViewGestureDetector;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ArrayList<Runnable> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private List<RecvMsg> jdField_b_of_type_JavaUtilList = new LinkedList();
  private lsi jdField_b_of_type_Lsi;
  private long jdField_c_of_type_Long = -1L;
  private Runnable jdField_c_of_type_JavaLangRunnable = new VideoLayerUI.NewMsgRunnable(this, null);
  boolean jdField_c_of_type_Boolean = false;
  private long jdField_d_of_type_Long;
  private Rect jdField_d_of_type_AndroidGraphicsRect = new Rect();
  private Runnable jdField_d_of_type_JavaLangRunnable = new VideoLayerUI.LastMsgRunnable(this, null);
  private Rect jdField_e_of_type_AndroidGraphicsRect = new Rect();
  private volatile boolean jdField_e_of_type_Boolean;
  private final boolean f = true;
  private boolean g = true;
  private boolean h = true;
  public int i;
  private boolean i;
  public int j;
  private boolean j;
  public int k;
  private boolean k;
  public int l = 4;
  public int m = 0;
  private int v = -1;
  private int w = -1;
  private int x;
  private int y;
  private int z;
  
  public VideoLayerUI(VideoAppInterface paramVideoAppInterface, Context paramContext, View paramView)
  {
    super(paramVideoAppInterface, paramContext, paramView);
    this.jdField_j_of_type_Int = 144;
    this.jdField_k_of_type_Int = 144;
    this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Miw = miw.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1, false);
    o();
    m();
    z();
    A();
    n();
    B();
    l();
    F();
    C();
    t();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "VideoLayerUI");
  }
  
  private void A()
  {
    this.t = bbjn.a(this.jdField_a_of_type_AndroidContentContext).getInt("video_position", 3);
  }
  
  private void B()
  {
    int i1 = 2130841453;
    int n = i1;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      n = i1;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 1008) {
        n = 2130841604;
      }
    }
    this.jdField_a_of_type_ArrayOfMee[0].a(muf.a(this.jdField_a_of_type_AndroidContentContext, n));
    super.a(muf.a(this.jdField_a_of_type_AndroidContentContext, n));
  }
  
  private void C()
  {
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(this.jdField_a_of_type_AndroidContentContext, new mlg(this));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new mlb(this));
    this.jdField_a_of_type_Lqq = new lqq(this.jdField_a_of_type_AndroidContentContext, new mlc(this, null));
    this.jdField_b_of_type_Lsi = new mlh(this);
    a(this.jdField_b_of_type_Lsi);
    this.m = actn.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  private void D()
  {
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.x = 0;
      this.y = 0;
      this.g = true;
      return;
    }
  }
  
  private void E()
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null)
    {
      this.jdField_a_of_type_ComTencentAvWidgetRotateLayout = ((RotateLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362912));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362919));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362921));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362920));
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources();
      this.H = ((int)localResources.getDimension(2131297638));
      this.I = ((int)localResources.getDimension(2131297639));
      int n = (int)(localResources.getDimension(2131296288) + localResources.getDimension(2131296355));
      int i1 = (int)(localResources.getDimension(2131296290) + localResources.getDimension(2131296357));
      int i2 = (int)(localResources.getDimension(2131296287) + localResources.getDimension(2131296354));
      float f1 = localResources.getDimension(2131296289);
      int i3 = (int)(localResources.getDimension(2131296356) + f1);
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(n, i1, i2, i3);
      this.jdField_b_of_type_AndroidWidgetTextView.setTag(Long.valueOf(0L));
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.H);
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(this.I);
      this.jdField_b_of_type_AndroidWidgetTextView.getBackground().setAlpha(128);
      if (AudioHelper.a(0) == 1)
      {
        this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setBackgroundColor(-460545);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(-984833);
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundColor(-1);
      }
    }
  }
  
  private void F()
  {
    this.jdField_a_of_type_Mle = new mle(this, this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView);
    ViewCompat.setAccessibilityDelegate(this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView, this.jdField_a_of_type_Mle);
  }
  
  private void G()
  {
    if (this.jdField_a_of_type_Lty == null) {
      this.jdField_a_of_type_Lty = new lty(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (AVActivity)this.jdField_a_of_type_AndroidContentContext);
    }
  }
  
  private void H()
  {
    if (this.jdField_a_of_type_Lty != null)
    {
      this.jdField_a_of_type_Lty.g();
      this.jdField_a_of_type_Lty = null;
    }
  }
  
  private void I()
  {
    int i1 = this.B;
    int n = Math.max(0, i1 / (this.jdField_j_of_type_Int + this.l));
    int i2 = this.jdField_j_of_type_Int;
    int i3 = this.l;
    i1 = (int)Math.ceil((j() - ((n + 1) * (i2 + i3) - i1)) * 1.0F / (this.jdField_j_of_type_Int + this.l));
    d(n, Math.min(k() - 1, i1 + n));
  }
  
  public static int a(String paramString, Context paramContext, int paramInt, boolean paramBoolean, Display paramDisplay)
  {
    if (paramBoolean)
    {
      int n = paramDisplay.getRotation();
      int i1 = (n * 90 + paramInt) % 360;
      CameraUtils.a(paramContext).a(true);
      if (QLog.isDevelopLevel()) {
        QLog.w(paramString, 1, "setRotation, rotation[" + paramInt + "], displayRotation[" + n + "], viewRotation[" + i1 + "]");
      }
      return i1;
    }
    CameraUtils.a(paramContext).a(false);
    return paramInt;
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      localObject = paramBitmap;
      if (paramBitmap == null) {
        break label93;
      }
      if (!paramBitmap.isRecycled())
      {
        localObject = paramBitmap;
        if (paramBitmap.getConfig() != null) {
          break label93;
        }
      }
    }
    Bitmap localBitmap = muf.a(this.jdField_a_of_type_AndroidContentContext, 2130840212);
    Object localObject = localBitmap;
    if (QLog.isDevelopLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      if ("memory not enough or binder bad,so quit load headIcon,bitmap.getConfig():=" + localBitmap == null) {
        break label95;
      }
    }
    label93:
    label95:
    for (paramBitmap = localBitmap.getConfig();; paramBitmap = "bitmap null")
    {
      QLog.d((String)localObject, 1, new Object[] { paramBitmap });
      localObject = localBitmap;
      return localObject;
    }
  }
  
  private Bitmap a(mlj parammlj)
  {
    if (parammlj.jdField_a_of_type_Int == 0) {
      return this.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(parammlj.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().g), this.jdField_a_of_type_ComTencentAvVideoController.a().E, true, false);
    }
    return ((BitmapDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841623)).getBitmap();
  }
  
  private Boolean a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().C == 2) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  private static final String a(CharSequence paramCharSequence)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramCharSequence);
    int n = paramCharSequence.length();
    aykp[] arrayOfaykp = (aykp[])((ayki)paramCharSequence).getSpans(0, n, aykp.class);
    n = 0;
    int i2;
    for (int i1 = 0; n < arrayOfaykp.length; i1 = i2)
    {
      Object localObject = arrayOfaykp[n];
      i2 = i1;
      if ((localObject instanceof aykp))
      {
        int i3 = ((ayki)paramCharSequence).getSpanStart(localObject);
        int i4 = ((ayki)paramCharSequence).getSpanEnd(localObject);
        i2 = i1;
        if (((aykp)localObject).c == 2)
        {
          localObject = ((aykp)localObject).a();
          localStringBuffer.replace(i3 + i1, i4 + i1, (String)localObject);
          i2 = i1 + (((String)localObject).length() - (i4 - i3));
        }
      }
      n += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString, int paramInt)
  {
    return paramString + "_" + paramInt;
  }
  
  private String a(mlj parammlj)
  {
    if (parammlj.jdField_a_of_type_Int == 0)
    {
      parammlj = this.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(parammlj.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().g), this.jdField_a_of_type_ComTencentAvVideoController.a().E);
      return parammlj;
    }
    long l1 = parammlj.jdField_a_of_type_Long;
    if (parammlj.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null) {}
    for (AVPhoneUserInfo localAVPhoneUserInfo = parammlj.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;; localAVPhoneUserInfo = this.jdField_a_of_type_ComTencentAvVideoController.a(l1, this.jdField_a_of_type_ComTencentAvVideoController.a().f))
    {
      if ((localAVPhoneUserInfo == null) || (localAVPhoneUserInfo.telInfo.mobile == null)) {
        break label154;
      }
      parammlj.jdField_a_of_type_JavaLangString = localAVPhoneUserInfo.telInfo.mobile;
      String str = this.jdField_a_of_type_ComTencentAvVideoController.a(localAVPhoneUserInfo.telInfo.mobile);
      parammlj = str;
      if (str != null) {
        break;
      }
      return msp.a(localAVPhoneUserInfo.telInfo.mobile, 4);
    }
    label154:
    if ((localAVPhoneUserInfo != null) && (QLog.isColorLevel())) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getMemmberName --> can not get Open Id. PhoneInfo = " + localAVPhoneUserInfo.toString());
    }
    return this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693243);
  }
  
  private mlj a(long paramLong)
  {
    mlj localmlj2 = (mlj)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    mlj localmlj1 = localmlj2;
    if (localmlj2 == null)
    {
      localmlj1 = new mlj();
      localmlj1.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localmlj1);
    }
    return localmlj1;
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    paramView = paramView.findViewById(2131362927);
    if (paramBoolean)
    {
      paramView.setVisibility(0);
      return;
    }
    paramView.setVisibility(8);
  }
  
  private void a(lqt paramlqt, lsh paramlsh, boolean paramBoolean)
  {
    int i2 = 1;
    int n;
    if ((paramlsh.a()) || (paramlsh.b()))
    {
      n = 1;
      if ((paramlsh.b().left - this.x <= this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels) && (paramlsh.b().right - this.x >= 0)) {
        break label90;
      }
      i1 = 1;
      label60:
      if ((i1 == 0) || (paramBoolean)) {
        break label96;
      }
    }
    label90:
    label96:
    for (int i1 = i2;; i1 = 0)
    {
      if ((n != 0) && (i1 == 0)) {
        break label102;
      }
      return;
      n = 0;
      break;
      i1 = 0;
      break label60;
    }
    label102:
    paramlqt.a(0, 0);
    paramlsh.a(paramlqt);
    paramlqt.a(-0, -0);
  }
  
  private void a(mee parammee, float paramFloat, long paramLong)
  {
    paramLong /= 10L;
    a(new VideoLayerUI.10(this, paramLong, parammee, (float)Math.pow(paramFloat, 1.0D / paramLong)));
  }
  
  private void a(mee parammee, boolean paramBoolean)
  {
    lss locallss = new lss();
    locallss.b(50);
    locallss.b(0.0F, 0.0F, 0.0F, 90.0F, 0.0F, 0.0F);
    locallss.a(new mkw(this, parammee, paramBoolean));
    locallss.a(1);
    parammee.a(locallss);
    parammee.b();
  }
  
  private void a(boolean paramBoolean, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0))
    {
      u();
      Object localObject = this.jdField_a_of_type_Mom.a();
      if (localObject != null)
      {
        localObject = ((ZimuItem)localObject).getId();
        int n = 1;
        if (!paramBoolean) {
          n = 4;
        }
        new mcq(paramLong, "showLastZimu", n, (String)localObject).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
    }
  }
  
  private boolean a(CharSequence paramCharSequence)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int n;
    if ((paramCharSequence instanceof ayki))
    {
      paramCharSequence = (aykp[])((ayki)paramCharSequence).getSpans(0, paramCharSequence.length(), aykp.class);
      n = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (n < paramCharSequence.length)
      {
        if (paramCharSequence[n].c == 2) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      n += 1;
    }
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if ((this.B == paramInt) && (!paramBoolean)) {
      return;
    }
    this.B = paramInt;
    I();
  }
  
  private void b(RecvMsg paramRecvMsg)
  {
    if (a().booleanValue()) {}
    do
    {
      return;
      String str2 = paramRecvMsg.c();
      String str3 = paramRecvMsg.a();
      String str1 = paramRecvMsg.b();
      localObject = str1;
      if (TextUtils.isEmpty(str1))
      {
        localObject = str1;
        if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean)
        {
          localObject = str1;
          if (str3 != null) {
            localObject = this.jdField_a_of_type_ComTencentAvVideoController.a(str3, String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().g), this.jdField_a_of_type_ComTencentAvVideoController.a().E);
          }
        }
      }
      paramRecvMsg = paramRecvMsg.d();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showRecvMsg friendUin: " + str2 + ", senderUin: " + str3 + ", senderName: " + (String)localObject + ", msg: " + paramRecvMsg);
      }
      o(this.u);
      g(true);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
    } while ((paramRecvMsg == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null));
    Object localObject = new ayki(paramRecvMsg, 11);
    paramRecvMsg = (RecvMsg)localObject;
    if (a((CharSequence)localObject)) {
      paramRecvMsg = a((CharSequence)localObject);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramRecvMsg);
  }
  
  private void b(String paramString, int paramInt)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "closeVideoView[" + paramString + "], index[" + paramInt + "]");
    paramString = ImageView.ScaleType.CENTER_INSIDE;
    int i4 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    int i1;
    float f1;
    int n;
    boolean bool;
    if (paramInt == 0)
    {
      i1 = this.jdField_a_of_type_ArrayOfMee[0].f();
      f1 = this.jdField_a_of_type_ArrayOfMee[0].d();
      n = this.jdField_a_of_type_ArrayOfMee[0].g();
      bool = this.jdField_a_of_type_ArrayOfMee[0].i();
      if (i4 == 4) {
        paramString = this.jdField_a_of_type_ArrayOfMee[0].a();
      }
    }
    for (;;)
    {
      int i2;
      int i3;
      if ((i4 == 4) && (this.jdField_a_of_type_Miw.a() == 3))
      {
        i2 = 1;
        if (Build.VERSION.SDK_INT < 21) {
          break label214;
        }
        i3 = 1;
      }
      label154:
      label214:
      int i5;
      mee localmee;
      for (;;)
      {
        if ((i2 != 0) && (i3 != 0))
        {
          i2 = -1;
          i3 = paramInt + 1;
          for (;;)
          {
            if (i3 < this.jdField_a_of_type_ArrayOfMee.length)
            {
              if (this.jdField_a_of_type_ArrayOfMee[i3].a() == 0) {
                i2 = i3;
              }
              i3 += 1;
              continue;
              i2 = 0;
              break;
              i3 = 0;
              break label154;
            }
          }
          if (i2 != -1)
          {
            i3 = this.jdField_a_of_type_ArrayOfMee[paramInt].d();
            i5 = this.jdField_a_of_type_ArrayOfMee[i2].d();
            this.jdField_a_of_type_ArrayOfMee[paramInt].c(i5);
            this.jdField_a_of_type_ArrayOfMee[i2].c(i3);
            localmee = this.jdField_a_of_type_ArrayOfMee[paramInt];
            this.jdField_a_of_type_ArrayOfMee[paramInt] = this.jdField_a_of_type_ArrayOfMee[i2];
            this.jdField_a_of_type_ArrayOfMee[i2] = localmee;
            localmee.a("");
            localmee = this.jdField_a_of_type_ArrayOfMee[i2];
            localmee.a(1);
            localmee.b(null);
            localmee.m(true);
            localmee.k(false);
            localmee.g(false);
            localmee.l(true);
            localmee.a(null, 0);
            label362:
            if (paramInt == 0)
            {
              this.jdField_a_of_type_ArrayOfMee[0].h(false);
              this.jdField_a_of_type_ArrayOfMee[0].k(i1);
              this.jdField_a_of_type_ArrayOfMee[0].a(f1);
              this.jdField_a_of_type_ArrayOfMee[0].j(n);
              this.jdField_a_of_type_ArrayOfMee[0].j(bool);
              if (i4 == 4)
              {
                if (this.jdField_a_of_type_ArrayOfMee[0].h() != 2) {
                  break label662;
                }
                this.jdField_a_of_type_ArrayOfMee[0].a(ImageView.ScaleType.CENTER_INSIDE);
              }
            }
          }
        }
      }
      for (;;)
      {
        c(false);
        return;
        i2 = paramInt;
        break;
        i2 = paramInt;
        while (i2 < this.jdField_a_of_type_ArrayOfMee.length)
        {
          if ((i2 >= this.jdField_a_of_type_ArrayOfMee.length - 1) || (this.jdField_a_of_type_ArrayOfMee[(i2 + 1)].a() != 0)) {
            break label599;
          }
          i3 = this.jdField_a_of_type_ArrayOfMee[i2].d();
          i5 = this.jdField_a_of_type_ArrayOfMee[(i2 + 1)].d();
          this.jdField_a_of_type_ArrayOfMee[i2].c(i5);
          this.jdField_a_of_type_ArrayOfMee[(i2 + 1)].c(i3);
          localmee = this.jdField_a_of_type_ArrayOfMee[i2];
          this.jdField_a_of_type_ArrayOfMee[i2] = this.jdField_a_of_type_ArrayOfMee[(i2 + 1)];
          this.jdField_a_of_type_ArrayOfMee[(i2 + 1)] = localmee;
          i2 += 1;
        }
        break label362;
        label599:
        localmee = this.jdField_a_of_type_ArrayOfMee[i2];
        localmee.a(1);
        localmee.b(null);
        localmee.m(true);
        localmee.k(false);
        localmee.g(false);
        localmee.l(true);
        localmee.a(null, 0);
        localmee.a("");
        break label362;
        label662:
        this.jdField_a_of_type_ArrayOfMee[0].a(paramString);
      }
      continue;
      f1 = 0.0F;
      i1 = 0;
      n = 0;
      bool = false;
    }
  }
  
  private void b(mee parammee, boolean paramBoolean)
  {
    lss locallss = new lss();
    locallss.b(50);
    locallss.b(0.0F, 0.0F, -90.0F, 0.0F, 0.0F, 0.0F);
    locallss.a(2);
    locallss.a(new mkx(this));
    parammee.a(locallss);
    parammee.b();
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_d_of_type_Long != 0L) && (System.currentTimeMillis() - this.jdField_d_of_type_Long < 1000L))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "bigWindowToSmallWindowAnim, 大小窗正在切换中[" + this.jdField_d_of_type_Long + "]");
      return false;
    }
    mee localmee = this.jdField_a_of_type_ArrayOfMee[paramInt2];
    localmee.a(Boolean.valueOf(false));
    localmee.a(0, 0, 0, 0);
    int n = localmee.d();
    localmee.c(1);
    float f1 = localmee.b().left;
    float f2 = localmee.b().top;
    Rect localRect = super.a();
    lss locallss = new lss();
    locallss.b(100);
    locallss.a(f1, f2, 0.0F, -localRect.left, -localRect.top, 0.0F);
    locallss.a(localmee.b().width(), localmee.b().height(), super.b() + localRect.left + localRect.right, super.c() + localRect.top + localRect.bottom);
    locallss.a(new mkz(this, paramInt2, n, paramInt1));
    locallss.a(2);
    localmee.a(locallss);
    localmee.b();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    return true;
  }
  
  private void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    paramInt3 = paramInt1 + this.l;
    paramInt4 = this.jdField_j_of_type_Int;
    paramInt1 = paramInt3;
    paramInt3 += paramInt4;
    int n = 1;
    paramInt4 = paramInt1;
    paramInt1 = n;
    while (paramInt1 <= i1)
    {
      ((lsh)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1 - 1)).b(paramInt4, paramInt2, paramInt3, this.jdField_k_of_type_Int + paramInt2);
      paramInt4 += this.jdField_j_of_type_Int + this.l;
      paramInt3 = paramInt4 + this.jdField_j_of_type_Int;
      paramInt1 += 1;
    }
    this.C = ((this.jdField_j_of_type_Int + this.l) * i1 + this.l);
  }
  
  private void c(int paramInt, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramInt == this.x)) {
      return;
    }
    this.x = paramInt;
    paramInt = l();
    if ((this.x > paramInt) && (this.jdField_a_of_type_Lsr.a()))
    {
      this.jdField_a_of_type_Lsr.b(this.x);
      this.x = paramInt;
    }
    b(this.x, paramBoolean);
    m(this.x);
  }
  
  private boolean c(int paramInt1, int paramInt2)
  {
    if ((this.jdField_d_of_type_Long != 0L) && (System.currentTimeMillis() - this.jdField_d_of_type_Long < 1000L))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "bigWindowToSmallWindowAnim, 大小窗正在切换中[" + this.jdField_d_of_type_Long + "]");
      return false;
    }
    Object localObject = this.jdField_a_of_type_ArrayOfMee[paramInt1];
    mee localmee = this.jdField_a_of_type_ArrayOfMee[paramInt2];
    ((mee)localObject).a(Boolean.valueOf(false));
    ((mee)localObject).a(0, 0, 0, 0);
    localmee.a(Boolean.valueOf(false));
    localmee.a(0, 0, 0, 0);
    int n = localmee.d();
    localmee.c(((mee)localObject).d());
    Rect localRect = localmee.b();
    localObject = ((mee)localObject).b();
    lss locallss = new lss();
    locallss.b(300);
    locallss.a(localRect.left, localRect.top, 0.0F, ((Rect)localObject).left, ((Rect)localObject).top, 0.0F);
    locallss.a(localRect.width(), localRect.height(), ((Rect)localObject).width(), ((Rect)localObject).height());
    locallss.a(new mla(this, paramInt2, n, paramInt1));
    locallss.a(2);
    localmee.a(locallss);
    localmee.b();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    return true;
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == this.z) && (paramInt2 == this.A)) {}
    for (;;)
    {
      return;
      if (paramInt1 < paramInt2)
      {
        this.z = paramInt1;
        this.A = paramInt2;
      }
      while (this.jdField_a_of_type_Lsn != null)
      {
        this.jdField_a_of_type_Lsn.a(this.z, this.A);
        return;
        this.A = 0;
        this.z = 0;
      }
    }
  }
  
  private void d(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Miw.a() != 3) {}
    int n;
    do
    {
      return;
      n = a("tryUpdateSpeakingStatus", String.valueOf(paramLong), 1);
    } while ((n == -1) || (this.jdField_a_of_type_ArrayOfMee[n].m == paramBoolean));
    this.jdField_a_of_type_ArrayOfMee[n].c(paramBoolean);
  }
  
  private boolean d(int paramInt1, int paramInt2)
  {
    if ((this.jdField_d_of_type_Long != 0L) && (System.currentTimeMillis() - this.jdField_d_of_type_Long < 1000L))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "sliderWindowBigToSmallAnimation, 大小窗正在切换中[" + this.jdField_d_of_type_Long + "]");
      return false;
    }
    mee localmee = this.jdField_a_of_type_ArrayOfMee[paramInt2];
    localmee.a(Boolean.valueOf(false));
    localmee.a(0, 0, 0, 0);
    b(new VideoLayerUI.9(this, paramInt1, paramInt2));
    b();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    return true;
  }
  
  private void f(long paramLong)
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (!this.jdField_c_of_type_Boolean)) {
      ((AVActivity)this.jdField_a_of_type_AndroidContentContext).a.z(paramLong);
    }
  }
  
  private void g(lqt arg1)
  {
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      while (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty())
      {
        Runnable localRunnable = (Runnable)this.jdField_b_of_type_JavaUtilArrayList.remove(0);
        if (localRunnable != null)
        {
          long l1 = System.currentTimeMillis();
          localRunnable.run();
          long l2 = System.currentTimeMillis();
          if (l2 - l1 >= 100L) {
            QLog.d("GLLinearLayout", 1, "event queue cost too long: " + (l2 - l1));
          }
        }
      }
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showMsgbox: show = " + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {}
    do
    {
      return;
      localObject = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources();
      int n = (int)(((Resources)localObject).getDimension(2131296288) + ((Resources)localObject).getDimension(2131296355));
      int i1 = (int)(((Resources)localObject).getDimension(2131296290) + ((Resources)localObject).getDimension(2131296357));
      int i2 = (int)(((Resources)localObject).getDimension(2131296287) + ((Resources)localObject).getDimension(2131296354));
      f1 = ((Resources)localObject).getDimension(2131296289);
      int i3 = (int)(((Resources)localObject).getDimension(2131296356) + f1);
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(n, i1, i2, i3);
      this.jdField_b_of_type_AndroidWidgetTextView.getBackground().setAlpha(128);
      if ((this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.isShown()) && (!paramBoolean))
      {
        localObject = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject).setDuration(1000L);
        ((AlphaAnimation)localObject).setFillAfter(true);
        ((AlphaAnimation)localObject).setAnimationListener(new mld(this, null));
        this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.startAnimation((Animation)localObject);
        return;
      }
    } while (!paramBoolean);
    Object localObject = new Transformation();
    ((Transformation)localObject).setAlpha(0.0F);
    AlphaAnimation localAlphaAnimation = (AlphaAnimation)this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getAnimation();
    if (localAlphaAnimation != null)
    {
      localAlphaAnimation.setAnimationListener(null);
      localAlphaAnimation.getTransformation(System.currentTimeMillis(), (Transformation)localObject);
    }
    float f1 = ((Transformation)localObject).getAlpha();
    this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.clearAnimation();
    localObject = new AlphaAnimation(f1, 1.0F);
    ((AlphaAnimation)localObject).setDuration(1000L);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setFillBefore(true);
    this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.startAnimation((Animation)localObject);
    this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setTag(Long.valueOf(System.currentTimeMillis()));
  }
  
  private void h(lqt paramlqt)
  {
    g(paramlqt);
    long l1 = lsg.a();
    boolean bool2 = this.jdField_a_of_type_Lsr.a(l1);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    int i2 = 1;
    int n = 1;
    int i4;
    ArrayList localArrayList;
    int i3;
    int i1;
    for (;;)
    {
      try
      {
        localObject1 = (mee)a(0);
        l1 = Long.parseLong(((mee)localObject1).b());
        i4 = ((mee)localObject1).h();
        localArrayList = this.jdField_a_of_type_Mlm.a();
        if (!this.h) {
          break label1085;
        }
        this.jdField_a_of_type_Mju.a(localArrayList);
        if (localArrayList.size() > this.E)
        {
          i2 = 1;
          i3 = 1;
          if ((i3 < localArrayList.size()) && ((this.jdField_a_of_type_JavaUtilArrayList.size() != this.E - 2) || (i2 == 0))) {
            break;
          }
          i1 = n;
          if (i2 != 0)
          {
            this.jdField_a_of_type_Mee.b(localArrayList.size() - this.E + 1 + "+");
            if (!((Boolean)this.jdField_a_of_type_Mee.a(2)).booleanValue()) {
              break label1068;
            }
            this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Mee);
            i1 = n;
          }
          label210:
          if ((i1 >= 2) && (muf.a(2))) {
            ThreadManager.getUIHandler().post(new VideoLayerUI.3(this));
          }
          paramlqt.a(b() / 2, c() / 2, 0.0F);
          c(paramlqt);
          paramlqt.a(-b() / 2, -c() / 2, 0.0F);
          i1 = a("renderSliderWindowStyle", String.valueOf(((mlj)localArrayList.get(0)).jdField_a_of_type_Long), ((mlj)localArrayList.get(0)).b());
          n = i1;
          if (i1 == -1) {
            n = 0;
          }
          localObject1 = this.jdField_a_of_type_ArrayOfMee[n];
          ((mee)localObject1).c(((mlj)localArrayList.get(0)).d());
          ((mee)localObject1).h(false);
          ((mee)localObject1).a(0, 0, 0, 0);
          ((mee)localObject1).b(0, 0, super.b(), super.c());
          a(paramlqt, (lsh)localObject1, true);
          if ((!((mee)localObject1).a()) && (QLog.isDevelopLevel())) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 1, "error happen big screen can not render with Uin:=" + ((mee)localObject1).b() + ",srcType:=" + ((mee)localObject1).h());
          }
          c(this.jdField_e_of_type_AndroidGraphicsRect.left, this.jdField_e_of_type_AndroidGraphicsRect.top, this.jdField_e_of_type_AndroidGraphicsRect.right, this.jdField_e_of_type_AndroidGraphicsRect.bottom);
          n = this.jdField_a_of_type_Lsr.a();
          if (!this.g) {
            break label1139;
          }
          bool1 = true;
          label503:
          c(n, bool1);
          if (this.g) {
            this.g = false;
          }
          paramlqt.a(-this.x, -this.y);
          n = 0;
          if (n >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
            break label1145;
          }
          a(paramlqt, (lsh)this.jdField_a_of_type_JavaUtilArrayList.get(n), false);
          n += 1;
          continue;
          return;
        }
      }
      catch (NumberFormatException paramlqt)
      {
        paramlqt.printStackTrace();
      }
      label582:
      i2 = 0;
    }
    Object localObject1 = (mlj)localArrayList.get(i3);
    long l2 = ((mlj)localObject1).a();
    int i5 = ((mlj)localObject1).b();
    ((mlj)localObject1).a();
    boolean bool1 = ((mlj)localObject1).jdField_a_of_type_Boolean;
    boolean bool3 = ((mlj)localObject1).c();
    boolean bool4 = ((mlj)localObject1).d();
    Object localObject2;
    if (bool3)
    {
      i1 = n;
      if (l2 == l1)
      {
        i1 = n;
        if (i5 == i4)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 1, "arraysToList3 bigindex index:=" + i3);
          }
          i1 = n + 1;
        }
      }
      n = a("renderSliderWindowStyle", String.valueOf(l2), i5);
      if (n != -1)
      {
        localObject2 = this.jdField_a_of_type_ArrayOfMee[n];
        ((mee)localObject2).c(bool4);
        ((mee)localObject2).h(true);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ArrayOfMee[n]);
        n = i1 + 1;
        i1 = 1;
      }
    }
    for (;;)
    {
      label766:
      mee localmee;
      if (((!bool3) && (bool1)) || (i1 == 0))
      {
        localmee = this.jdField_a_of_type_Mju.a(l2);
        localmee.b(false);
        localmee.h(true);
        localmee.c(bool4);
        if (!((Boolean)localmee.a(2)).booleanValue())
        {
          localmee.b(a((mlj)localObject1));
          localmee.j(true);
          localObject2 = a((mlj)localObject1);
          localObject1 = localObject2;
          if (Build.VERSION.SDK_INT == 23) {
            localObject1 = a((Bitmap)localObject2);
          }
          localObject1 = new lrx((Bitmap)localObject1);
          ((lrx)localObject1).b(paramlqt);
          localmee.a((lrx)localObject1);
        }
      }
      for (;;)
      {
        i3 += 1;
        break;
        n = i1;
        i1 = 0;
        break label766;
        this.jdField_a_of_type_JavaUtilArrayList.add(localmee);
        continue;
        if (!bool1)
        {
          localmee = this.jdField_a_of_type_Mju.a(l2);
          localmee.b(true);
          localmee.g(Color.parseColor("#4C000000"));
          localmee.c(false);
          localmee.h(true);
          if (!((Boolean)localmee.a(2)).booleanValue())
          {
            localmee.b(a((mlj)localObject1));
            localmee.j(true);
            localObject2 = a((mlj)localObject1);
            localObject1 = localObject2;
            if (Build.VERSION.SDK_INT == 23) {
              localObject1 = a((Bitmap)localObject2);
            }
            localObject1 = new lrx((Bitmap)localObject1);
            ((lrx)localObject1).b(paramlqt);
            localmee.a((lrx)localObject1);
          }
          else
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(localmee);
          }
        }
      }
      label1068:
      this.jdField_a_of_type_Mee.a(2, Boolean.valueOf(true));
      i1 = n;
      break label210;
      label1085:
      n = 0;
      i1 = i2;
      if (n >= this.jdField_a_of_type_ArrayOfMee.length) {
        break label210;
      }
      localObject1 = this.jdField_a_of_type_ArrayOfMee[n];
      if (!((lsh)localObject1).a()) {}
      for (;;)
      {
        n += 1;
        break;
        if (n != 0) {
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        }
      }
      label1139:
      bool1 = false;
      break label503;
      label1145:
      paramlqt.a(this.x, this.y);
      if (!(false | bool2)) {
        break label582;
      }
      b();
      return;
      i1 = 1;
    }
  }
  
  private int i()
  {
    int n = 0;
    int i2;
    for (int i1 = 0; n < this.jdField_a_of_type_ArrayOfMee.length; i1 = i2)
    {
      mee localmee = this.jdField_a_of_type_ArrayOfMee[n];
      String str = localmee.b();
      i2 = i1;
      if (localmee.a() == 0)
      {
        i2 = i1;
        if (!TextUtils.isEmpty(str)) {
          i2 = i1 + 1;
        }
      }
      n += 1;
    }
    return i1;
  }
  
  private int j()
  {
    return this.jdField_d_of_type_AndroidGraphicsRect.right - this.jdField_d_of_type_AndroidGraphicsRect.left;
  }
  
  private int k()
  {
    return i();
  }
  
  private int l()
  {
    int i1 = this.C - j();
    int n = i1;
    if (i1 <= 0) {
      n = 0;
    }
    return n;
  }
  
  private void o(int paramInt)
  {
    if ((this.jdField_k_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getLayoutParams();
    int i3 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131298950);
    int i2 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131298951);
    int i4 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131298945);
    int i1 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131298946);
    int i5 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131298944);
    if ((this.o == 0) || (this.n == 0))
    {
      i1 = i4;
      i2 = i3;
    }
    int i6 = i();
    Object localObject1;
    int n;
    label270:
    label495:
    Object localObject2;
    if (i6 <= 0)
    {
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(10, 0);
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(12, -1);
      localLayoutParams.leftMargin = i4;
      localLayoutParams.bottomMargin = (i1 + this.o);
      this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setLayoutParams(localLayoutParams);
      localObject1 = (RotateLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      ((RotateLayout.LayoutParams)localObject1).jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      i1 = this.jdField_a_of_type_AndroidViewView.getWidth() - i4 * 2;
      n = i1;
      if (i1 > this.I) {
        n = this.I;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(n);
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setMsgboxLayout, orientation[" + paramInt + "], leftMargin[" + localLayoutParams.leftMargin + "], topMargin[" + localLayoutParams.topMargin + "], rightMargin[" + localLayoutParams.rightMargin + "], bottomMargin[" + localLayoutParams.bottomMargin + "], mMsgLayout[" + this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getWidth() + ", " + this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getHeight() + "]");
      }
    }
    else
    {
      n = paramInt;
      if (this.o != 0)
      {
        n = paramInt;
        if (this.n != 0) {
          n = 0;
        }
      }
      localObject1 = this.jdField_a_of_type_ArrayOfMee[1].b();
      paramInt = h();
      if (n != 0) {
        break label761;
      }
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(10, 0);
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(12, -1);
      if (i6 != 1) {
        break label683;
      }
      localLayoutParams.leftMargin = i4;
      localLayoutParams.bottomMargin = (i1 + this.o);
      localLayoutParams.bottomMargin += this.J;
      this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setLayoutParams(localLayoutParams);
      if (QLog.isDevelopLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 4, "setLayoutParams, [" + localLayoutParams.leftMargin + ", " + localLayoutParams.topMargin + ", " + localLayoutParams.rightMargin + ", " + localLayoutParams.bottomMargin + "]");
      }
      localObject2 = (RotateLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      ((RotateLayout.LayoutParams)localObject2).jdField_a_of_type_Int = n;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = super.b();
      if (i6 != 1) {
        break label1167;
      }
    }
    label1167:
    for (paramInt = ((Rect)localObject2).width() - i4 * 2;; paramInt = ((Rect)localObject2).width() - ((Rect)localObject1).width() - i3 - i4 - i5)
    {
      i1 = paramInt;
      if (paramInt > this.I) {
        i1 = this.I;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(i1);
      paramInt = n;
      break label270;
      break;
      label683:
      if (i6 == 2)
      {
        if (paramInt == 4) {}
        for (localLayoutParams.leftMargin = (((Rect)localObject1).width() + i3 + i5);; localLayoutParams.leftMargin = i4)
        {
          localLayoutParams.bottomMargin = (i1 + this.o);
          break;
        }
      }
      localLayoutParams.leftMargin = i4;
      localLayoutParams.bottomMargin = (i1 + this.o + ((Rect)localObject1).height());
      break label495;
      label761:
      if (n == 90)
      {
        localLayoutParams.addRule(10, 0);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.addRule(11, -1);
        localLayoutParams.addRule(12, -1);
        if (i6 == 1)
        {
          localLayoutParams.rightMargin = i4;
          localLayoutParams.bottomMargin = (i1 + this.o);
          break label495;
        }
        if (i6 < 2) {
          break label495;
        }
        if (paramInt == 3) {}
        for (localLayoutParams.bottomMargin = (((Rect)localObject1).height() + i2 + i5 + this.o);; localLayoutParams.bottomMargin = (i1 + this.o))
        {
          localLayoutParams.rightMargin = i4;
          break;
        }
      }
      if (n == 180)
      {
        localLayoutParams.addRule(9, 0);
        localLayoutParams.addRule(12, 0);
        localLayoutParams.addRule(11, -1);
        localLayoutParams.addRule(10, -1);
        if (i6 == 1)
        {
          localLayoutParams.rightMargin = i4;
          localLayoutParams.topMargin = (i1 + this.n);
          break label495;
        }
        if (i6 == 2)
        {
          if (paramInt == 2) {}
          for (localLayoutParams.rightMargin = (((Rect)localObject1).width() + i3 + i5);; localLayoutParams.rightMargin = i4)
          {
            localLayoutParams.topMargin = (i1 + this.n);
            break;
          }
        }
        localLayoutParams.rightMargin = i4;
        if (paramInt == 2)
        {
          localLayoutParams.topMargin = (i1 + this.n + ((Rect)localObject1).height());
          break label495;
        }
        localLayoutParams.topMargin = (i1 + this.n);
        break label495;
      }
      if (n != 270) {
        break label495;
      }
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(12, 0);
      localLayoutParams.addRule(10, -1);
      localLayoutParams.addRule(9, -1);
      if (i6 == 1)
      {
        localLayoutParams.leftMargin = i4;
        localLayoutParams.topMargin = (i1 + this.n);
        break label495;
      }
      if (i6 < 2) {
        break label495;
      }
      if (paramInt == 1) {}
      for (localLayoutParams.topMargin = (((Rect)localObject1).height() + i2 + i5 + this.n);; localLayoutParams.topMargin = (i1 + this.n))
      {
        localLayoutParams.leftMargin = i4;
        break;
      }
    }
  }
  
  private boolean o()
  {
    return (this.jdField_a_of_type_Miw != null) && (this.jdField_a_of_type_Miw.a() == 4) && (!this.jdField_e_of_type_Boolean);
  }
  
  private void p(int paramInt)
  {
    if (paramInt > 0)
    {
      int n = 0;
      if (paramInt == 2) {
        n = 2131695797;
      }
      if ((n != 0) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
        mat.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1008, n);
      }
    }
  }
  
  private boolean p()
  {
    long l1 = this.jdField_c_of_type_Long;
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    if (this.jdField_c_of_type_Long - l1 > 1000L) {
      return true;
    }
    this.jdField_c_of_type_Long = l1;
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "canPerformClick not allowed");
    return false;
  }
  
  private void z()
  {
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
    ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindowManager().getDefaultDisplay().getRealMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
    this.l = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297722);
    this.jdField_j_of_type_Int = ((this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels - this.l * 5) / 4);
    this.jdField_k_of_type_Int = this.jdField_j_of_type_Int;
    int n = this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels;
    n = this.jdField_j_of_type_Int;
    n = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298951);
    this.jdField_d_of_type_AndroidGraphicsRect = new Rect(0, this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels - n - this.jdField_k_of_type_Int, this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels, this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels - n);
    this.jdField_b_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new mlf(this, null));
    this.jdField_a_of_type_Lsr = new lsr(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Lsr.a(true);
    this.jdField_a_of_type_Lsr.a((int)muf.a(this.jdField_a_of_type_AndroidContentContext, 50.0F));
    this.jdField_a_of_type_Mee = new mee(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, String.format("%s_%s", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(1000) }), this.jdField_a_of_type_ComTencentAvVideoController.g());
    this.jdField_a_of_type_Mee.a(1);
    this.jdField_a_of_type_Mee.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_Mee.a("null", 1);
    this.jdField_a_of_type_Mee.a(true);
    this.jdField_a_of_type_Mee.e(false);
    this.jdField_a_of_type_Mee.h(false);
    this.jdField_a_of_type_Mee.i(true);
    n = actn.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_Mee.a(n);
    this.jdField_a_of_type_Mee.j(true);
    this.jdField_a_of_type_Mee.d(Color.parseColor("#686E6C"));
    this.jdField_a_of_type_Mee.a(2, Boolean.valueOf(false));
    this.jdField_a_of_type_Mee.c(999);
    a(this.jdField_a_of_type_Mee);
  }
  
  public int a(float paramFloat)
  {
    int n = Math.round(paramFloat) + this.B;
    if (n < 0) {
      return -1;
    }
    return n / (this.jdField_j_of_type_Int + this.l);
  }
  
  public AVActivity a()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity)) {
      return (AVActivity)this.jdField_a_of_type_AndroidContentContext;
    }
    return null;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    if ((!this.jdField_d_of_type_Boolean) && (!l())) {
      this.s = paramInt;
    }
    for (;;)
    {
      return;
      if ((paramInt != this.r) || (paramInt == this.s))
      {
        if (paramInt % 90 != this.r % 90) {
          this.p = 0;
        }
        this.r = paramInt;
        this.s = paramInt;
        int n = a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentContext, paramInt, paramBoolean, this.jdField_a_of_type_AndroidViewDisplay);
        switch (paramInt)
        {
        }
        while (this.jdField_a_of_type_ComTencentAvVideoController.a().C == 2)
        {
          if (this.u != 0)
          {
            paramBoolean = bool;
            if (this.u != 180) {}
          }
          else
          {
            paramBoolean = true;
          }
          c(paramBoolean);
          return;
          paramInt = 0;
          while (paramInt < super.e())
          {
            super.a(paramInt).b(n);
            paramInt += 1;
          }
          o(n);
          this.u = n;
        }
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i1 = 0;
    int n = 0;
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "notifyControlUIOffset, mTopOffset[" + this.n + "->" + paramInt1 + "], mBottomOffset[" + this.o + "->" + paramInt2 + "], mFullScreen[" + this.jdField_c_of_type_Boolean + "->" + paramBoolean + "], seq[" + paramLong + "]");
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.n = paramInt1;
    this.o = paramInt2;
    c(true);
    o(this.u);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
    {
      paramInt1 = i1;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().I)
      {
        paramInt1 = n;
        while (paramInt1 < this.jdField_a_of_type_ArrayOfMee.length)
        {
          this.jdField_a_of_type_ArrayOfMee[paramInt1].j(true);
          paramInt1 += 1;
        }
      }
      while (paramInt1 < this.jdField_a_of_type_ArrayOfMee.length)
      {
        this.jdField_a_of_type_ArrayOfMee[paramInt1].j(true);
        paramInt1 += 1;
      }
    }
    if (this.jdField_a_of_type_Mom != null) {
      this.jdField_a_of_type_Mom.a(this, this.n, this.o);
    }
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    this.F = a("notifyGLVideoViewChange", String.valueOf(paramLong1), paramInt1);
    this.G = a("notifyGLVideoViewChange", String.valueOf(paramLong2), paramInt2);
    b(new VideoLayerUI.2(this, this.F, this.G));
  }
  
  void a(long paramLong, Boolean paramBoolean)
  {
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
    int n = a("openSelfVideo", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), 1);
    c(paramLong);
    if ((paramBoolean.booleanValue()) && (n > 0) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Boolean))) {
      a(0, n);
    }
  }
  
  void a(long paramLong, String paramString, int paramInt)
  {
    int n = a("closePeerVideo", paramString, paramInt);
    if (n >= 0)
    {
      paramString = a(paramString, paramInt);
      GraphicRenderMgr localGraphicRenderMgr = GraphicRenderMgr.getInstance();
      localGraphicRenderMgr.flushGlRender(paramString);
      localGraphicRenderMgr.setGlRender(paramString, null);
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setGlRender[closePeerVideo_no], key[" + paramString + "], index[" + n + "], seq[" + paramLong + "]");
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int, true, true);
      b("closePeerVideo", n);
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int n = a("setBackground", paramString, paramInt);
    int i1 = n;
    boolean bool;
    label58:
    mee localmee;
    if (n < 0)
    {
      i1 = a(0);
      if (i1 >= 0)
      {
        if (paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
          break label264;
        }
        bool = true;
        localmee = this.jdField_a_of_type_ArrayOfMee[i1];
        a(paramLong, localmee, paramString, paramInt, bool);
        if ((localmee != null) && (!bool)) {
          localmee.a(paramLong, CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a());
        }
      }
      n = i1;
      if (paramBoolean2)
      {
        n = i1;
        if (i1 > 0)
        {
          a(0, i1);
          n = 0;
        }
      }
      i1 = n;
      if (n <= 0) {}
    }
    label264:
    int i2;
    for (i1 = 1;; i1 = i2)
    {
      if (n >= 0)
      {
        localmee = this.jdField_a_of_type_ArrayOfMee[n];
        localmee.a(paramBitmap);
        localmee.m(paramBoolean1);
        if (!paramBoolean1) {
          localmee.k(false);
        }
      }
      if (i1 != 0) {
        l(n);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setBackground uin: " + paramString + ", videoSrcType: " + paramInt + ", index: " + n + ", needRenderVideo: " + paramBoolean1);
      return;
      bool = false;
      break label58;
      i2 = 0;
      n = i1;
    }
  }
  
  void a(long paramLong, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    mee localmee = null;
    int n = a("openPeerVideo, seq[" + paramLong + "]", paramString, paramInt);
    if (a(this.jdField_a_of_type_ComTencentAvVideoController.a())) {
      if ((paramBoolean1) || (k())) {
        break label582;
      }
    }
    label262:
    label292:
    label565:
    label582:
    for (boolean bool = true;; bool = paramBoolean1)
    {
      if (n > 1)
      {
        lzj.a();
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "SetGlRender index break!!!!!! index=" + n + ", remotehasvideo=" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean);
        return;
        bool = paramBoolean1;
      }
      String str = a(paramString, paramInt);
      int i1;
      if (n < 0)
      {
        n = a(0);
        if (n >= 0)
        {
          localmee = this.jdField_a_of_type_ArrayOfMee[n];
          a(paramLong, localmee, paramString, paramInt, true);
        }
        if ((localmee != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().c.size() <= 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)) {
          localmee.a(actn.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        }
        if ((n <= 1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 4)) {
          break label565;
        }
        i1 = 1;
        paramString = localmee;
        paramInt = n;
        n = i1;
      }
      for (;;)
      {
        if (paramString != null)
        {
          paramString.g(paramBoolean2);
          paramString.a(paramLong, this.jdField_a_of_type_Miw.b());
          if (paramBoolean1) {
            break label525;
          }
          paramBoolean1 = true;
          paramString.k(paramBoolean1);
          paramString.a(0);
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 4) {
            break label541;
          }
          if (paramInt != 0) {
            break label531;
          }
          paramString.a(ImageView.ScaleType.CENTER_INSIDE);
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().M == 3) {
            paramString.h(true);
          }
        }
        for (;;)
        {
          if ((bool) && (paramInt > 0) && (!f()) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Boolean))) {
            a(0, paramInt);
          }
          if (n == 0) {
            break;
          }
          l(paramInt);
          return;
          paramString = this.jdField_a_of_type_ArrayOfMee[n];
          GraphicRenderMgr.getInstance().setGlRender(str, paramString.a());
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setGlRender[openPeerVideo], key[" + str + "], seq[" + paramLong + "], index[" + n + "], " + paramString.c());
          this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int, false, true);
          paramInt = n;
          n = 0;
          break label262;
          paramBoolean1 = false;
          break label292;
          paramString.a(ImageView.ScaleType.CENTER_CROP);
          continue;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) {
            paramString.a(ImageView.ScaleType.CENTER_INSIDE);
          }
        }
        i1 = 0;
        paramString = localmee;
        paramInt = n;
        n = i1;
      }
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setRemoteHasVideo, uin[" + paramString + "], videoSrcType[" + paramInt + "], isRemoteHasVideo[" + paramBoolean1 + "], forceToBigView[" + paramBoolean2 + "], mIsLocalHasVideo[" + this.jdField_d_of_type_Boolean + "], isPC[" + paramBoolean3 + "], seq[" + paramLong + "]");
    }
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) || (!e())) {}
    for (;;)
    {
      return;
      n();
      if (paramBoolean1) {
        G();
      }
      if (paramBoolean1) {
        a(paramLong, paramString, paramInt, paramBoolean2, paramBoolean3);
      }
      while ((this.jdField_a_of_type_Mom != null) && (!g()))
      {
        a(paramBoolean1, paramLong);
        return;
        a(paramLong, paramString, paramInt);
      }
    }
  }
  
  void a(long paramLong, mee parammee, String paramString, int paramInt, boolean paramBoolean)
  {
    String str;
    if (parammee != null)
    {
      str = a(paramString, paramInt);
      parammee.a(paramString, paramInt);
      parammee.a(0);
      parammee.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    }
    try
    {
      GraphicRenderMgr.getInstance().setAccountUin(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      GraphicRenderMgr.getInstance().setGlRender(str, parammee.a());
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setGlRender[initGLVideoViewBasePara], key[" + str + "], " + parammee.c());
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int, false, paramBoolean);
      return;
    }
    catch (UnsatisfiedLinkError parammee)
    {
      parammee.printStackTrace();
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "notifyAudioMemberChange");
    if (((this.jdField_a_of_type_ComTencentAvVideoController.a().E == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().C == 10)) || (this.jdField_a_of_type_ComTencentAvVideoController.a().E == 2))
    {
      mlj localmlj = a(paramLong);
      localmlj.b = paramBoolean;
      d(paramLong, localmlj.d());
      if ((this.jdField_a_of_type_Mlm != null) && (this.jdField_a_of_type_Mlm.a(paramLong, paramBoolean))) {
        b();
      }
    }
  }
  
  void a(View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      E();
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void a(RecvMsg paramRecvMsg)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 1011) {}
    String str2;
    do
    {
      return;
      String str1 = paramRecvMsg.c();
      str2 = paramRecvMsg.a();
      String str3 = paramRecvMsg.b();
      String str4 = paramRecvMsg.d();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onReceiveMsg friendUin: " + str1 + ", senderUin: " + str2 + ", senderName: " + str3 + ", msg: " + str4);
      }
    } while (str2.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()));
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      E();
    }
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.isShown())
    {
      if (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getTag()).longValue() >= 3000L)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
        b(paramRecvMsg);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 3000L);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 3000L);
        return;
      }
      this.jdField_b_of_type_JavaUtilList.add(paramRecvMsg);
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    b(paramRecvMsg);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 3000L);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 3000L);
  }
  
  public void a(AVActivity.AnimationTrigger paramAnimationTrigger)
  {
    this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger = paramAnimationTrigger;
  }
  
  public void a(Integer paramInteger, Object paramObject)
  {
    lcl.c(this.jdField_a_of_type_JavaLangString, "notifyEvent :" + paramInteger + "|" + paramObject);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { paramInteger, paramObject });
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Miw.a() != 2)
    {
      String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      a("switchLocalView_" + paramString, str);
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, float paramFloat, int paramInt2)
  {
    boolean bool = true;
    int n = a("setText", paramString1, paramInt1);
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setText, uin[" + paramString1 + "], videoSrcType[" + paramInt1 + "], text[" + paramString2 + "], textSize[" + paramFloat + "], textColor[" + paramInt2 + "], index[" + n + "]");
    }
    if (n >= 0)
    {
      paramString1 = this.jdField_a_of_type_ArrayOfMee[n];
      paramString1.a(0);
      paramString1.b(paramString2);
      paramString1.a(paramFloat);
      paramString1.k(paramInt2);
      if (f() != 3) {
        break label229;
      }
      if (n <= 0) {
        break label188;
      }
    }
    for (;;)
    {
      paramString1.h(bool);
      if (n != 0) {
        break label247;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().C != 2) {
        break;
      }
      paramString1.b("");
      return;
      label188:
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().c.size() <= 1)
      {
        paramString1.a(actn.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        bool = false;
        continue;
        label229:
        if (n == 0) {
          bool = false;
        }
      }
    }
    paramString1.j(12);
    return;
    label247:
    if (b(this.jdField_a_of_type_ComTencentAvVideoController.a()))
    {
      paramString1.j(12);
      return;
    }
    paramString1.j(2147483647);
  }
  
  public void a(ArrayList<ldw> paramArrayList)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "notifyAudioMemberChange");
    if (this.jdField_a_of_type_Mlm != null) {
      this.jdField_a_of_type_Mlm.a(paramArrayList);
    }
  }
  
  protected void a(Observable paramObservable, Object paramObject)
  {
    paramObservable = (Object[])paramObject;
    switch (((Integer)paramObservable[0]).intValue())
    {
    default: 
      return;
    case 6008: 
      u();
      paramObservable = (lhh)paramObservable[1];
      this.jdField_a_of_type_Mom.a(paramObservable);
      return;
    case 6010: 
      u();
      p(((Integer)paramObservable[1]).intValue());
      return;
    case 6005: 
      b((mcq)mck.a(paramObservable));
      return;
    case 6501: 
      if ((this.jdField_a_of_type_Mom != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0)))
      {
        this.jdField_a_of_type_Mom.a(true);
        return;
      }
      ljt.a(true);
      return;
    }
    c(true);
  }
  
  public void a(lgf paramlgf)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "tryRegisterMemmberChangeListener");
    paramlgf.a(this.jdField_a_of_type_Mlm);
  }
  
  protected void a(lqt paramlqt, boolean paramBoolean)
  {
    if (o())
    {
      h(paramlqt);
      return;
    }
    this.x = 0;
    this.y = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    super.a(paramlqt, paramBoolean);
  }
  
  void a(mcq parammcq)
  {
    u();
    String str = parammcq.b;
    long l1 = parammcq.a();
    if (ljt.a(str))
    {
      bool2 = lmz.a();
      bool1 = bool2;
      if (bool2) {
        bool1 = this.jdField_a_of_type_Mom.b(parammcq.a(), str, (ViewGroup)this.jdField_a_of_type_AndroidViewView, this.n, this.o);
      }
      if ((bool1) && ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity))) {
        ((AVActivity)this.jdField_a_of_type_AndroidContentContext).g(l1);
      }
    }
    while ((!this.jdField_a_of_type_Mom.a(parammcq.a(), str, (ViewGroup)this.jdField_a_of_type_AndroidViewView, this.n, this.o)) || (!(this.jdField_a_of_type_AndroidContentContext instanceof AVActivity)))
    {
      boolean bool2;
      boolean bool1;
      return;
    }
    ((AVActivity)this.jdField_a_of_type_AndroidContentContext).g(l1);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    String str1;
    if (QLog.isColorLevel())
    {
      str1 = this.jdField_a_of_type_ArrayOfMee[paramInt1].b();
      String str2 = this.jdField_a_of_type_ArrayOfMee[paramInt2].b();
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "switchVideo, begin, [" + paramInt1 + "]=[" + str1 + "], [" + paramInt2 + "]=[" + str2 + "]", new Throwable("打印调用栈"));
    }
    if ((paramInt1 == paramInt2) || (paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_ArrayOfMee.length) || (paramInt2 < 0) || (paramInt2 >= this.jdField_a_of_type_ArrayOfMee.length))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "switchVideo index invalid!");
      }
      return false;
    }
    if (paramInt2 == 0)
    {
      a(paramInt1, paramInt2);
      return true;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
    {
      if (paramInt1 != 0) {
        break label265;
      }
      this.jdField_a_of_type_ArrayOfMee[paramInt2].a(ImageView.ScaleType.CENTER_INSIDE);
    }
    for (;;)
    {
      str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      this.jdField_a_of_type_ArrayOfMee[paramInt1].b();
      if (str1.equals(this.jdField_a_of_type_ArrayOfMee[paramInt2].b())) {
        this.jdField_a_of_type_ArrayOfMee[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      }
      if ((this.jdField_a_of_type_Miw == null) || (this.jdField_a_of_type_Miw.a() != 3)) {
        break;
      }
      return c(paramInt1, paramInt2);
      label265:
      if (paramInt2 == 0) {
        this.jdField_a_of_type_ArrayOfMee[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      }
    }
    if ((this.jdField_a_of_type_Miw != null) && (this.jdField_a_of_type_Miw.a() == 4)) {
      return d(paramInt1, paramInt2);
    }
    return b(paramInt1, paramInt2);
  }
  
  public boolean a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!e()) {
      return false;
    }
    if (paramBoolean1) {
      G();
    }
    if (paramBoolean1) {
      a(paramLong, Boolean.valueOf(paramBoolean2));
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = paramBoolean1;
      if ((this.jdField_a_of_type_Mom != null) && (!l())) {
        a(paramBoolean1, paramLong);
      }
      return true;
      b(paramLong);
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return a("hasVideoView", paramString, paramInt) >= 0;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool = false;
    int n = a("setVideoToBigView", paramString2, 1);
    if (n > 0) {
      bool = a(0, n);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "setVideoToBigView[" + paramString1 + "], uin[" + paramString2 + "], index[" + n + "], bRet[" + bool + "]");
    }
    return bool;
  }
  
  void b(long paramLong)
  {
    ThreadManager.post(this.jdField_b_of_type_JavaLangRunnable, 8, null, false);
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int n = a("closeSelfVideo", str, 1);
    if (n >= 0)
    {
      str = a(str, 1);
      GraphicRenderMgr localGraphicRenderMgr = GraphicRenderMgr.getInstance();
      localGraphicRenderMgr.flushGlRender(str);
      localGraphicRenderMgr.clearCameraFrames();
      localGraphicRenderMgr.setGlRender(str, null);
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setGlRender[closeSelfVideo_no], key[" + str + "], index[" + n + "], seq[" + paramLong + "]");
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int, true, false);
      d(paramLong);
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "notifyAudioMemberChange");
    if (((this.jdField_a_of_type_ComTencentAvVideoController.a().E == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().C == 10)) || (this.jdField_a_of_type_ComTencentAvVideoController.a().E == 2))
    {
      mlj localmlj = a(paramLong);
      localmlj.jdField_c_of_type_Boolean = paramBoolean;
      d(paramLong, localmlj.d());
      if ((this.jdField_a_of_type_Mlm != null) && (this.jdField_a_of_type_Mlm.b(paramLong, paramBoolean))) {
        b();
      }
    }
  }
  
  public void b(Runnable paramRunnable)
  {
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(paramRunnable);
      return;
    }
  }
  
  void b(mcq parammcq)
  {
    boolean bool = false;
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestZimu, mHandle[" + parammcq.jdField_a_of_type_Int + "], seq[" + parammcq.a() + "]");
    }
    if (parammcq.jdField_a_of_type_Int == 2) {
      if ((this.jdField_a_of_type_Mom != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0)))
      {
        this.jdField_a_of_type_Mom.a((ViewGroup)this.jdField_a_of_type_AndroidViewView, parammcq.a());
        if ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity)) {
          ((AVActivity)this.jdField_a_of_type_AndroidContentContext).g(parammcq.a());
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (parammcq.jdField_a_of_type_Int == 1)
          {
            a(parammcq);
            return;
          }
          if ((parammcq.jdField_a_of_type_Int != 3) && (parammcq.jdField_a_of_type_Int != 4)) {
            break;
          }
        } while (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0));
        u();
        if (parammcq.jdField_a_of_type_Int == 3) {
          bool = true;
        }
      } while ((!this.jdField_a_of_type_Mom.a(parammcq.a(), (ViewGroup)this.jdField_a_of_type_AndroidViewView, bool)) || (!(this.jdField_a_of_type_AndroidContentContext instanceof AVActivity)));
      ((AVActivity)this.jdField_a_of_type_AndroidContentContext).g(parammcq.a());
      return;
    } while (parammcq.jdField_a_of_type_Int != 5);
    if (this.jdField_a_of_type_Mom != null)
    {
      this.jdField_a_of_type_Mom.a(parammcq.a());
      return;
    }
    ljt.a(false);
  }
  
  public void c(long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int n = a("openSelfVideo", (String)localObject2, 1);
    if (n < 0)
    {
      n = a(0);
      if (n >= 0)
      {
        localObject1 = this.jdField_a_of_type_ArrayOfMee[n];
        a(paramLong, (mee)localObject1, (String)localObject2, 1, false);
      }
      localObject2 = localObject1;
      if (n == 0)
      {
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
          {
            ((mee)localObject1).h(false);
            localObject2 = localObject1;
          }
        }
      }
    }
    for (;;)
    {
      if (localObject2 != null)
      {
        if (CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b(paramLong)) {
          ((mee)localObject2).a(paramLong, CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a());
        }
        ((mee)localObject2).g(false);
        ((mee)localObject2).k(false);
        ((mee)localObject2).m(true);
        ((mee)localObject2).a(0);
        ((mee)localObject2).a(ImageView.ScaleType.CENTER_CROP);
      }
      return;
      localObject1 = a((String)localObject2, 1);
      localObject2 = this.jdField_a_of_type_ArrayOfMee[n];
      GraphicRenderMgr.getInstance().setGlRender((String)localObject1, ((mee)localObject2).a());
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setGlRender[openSelfVideo], key[" + (String)localObject1 + "], index[" + n + "], forceToBigView[" + false + "], " + ((mee)localObject2).c());
    }
  }
  
  public void c(boolean paramBoolean)
  {
    long l1 = AudioHelper.b();
    int n = super.b();
    int i1 = super.c();
    lgf locallgf = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (a(locallgf))
    {
      miw localmiw = this.jdField_a_of_type_Miw;
      mee[] arrayOfmee = this.jdField_a_of_type_ArrayOfMee;
      int i2 = this.t;
      int i3 = this.n;
      int i4 = this.o;
      if (!locallgf.jdField_e_of_type_Boolean)
      {
        paramBoolean = true;
        localmiw.a(arrayOfmee, n, i1, i2, i3, i4, paramBoolean);
        ljo.c(i1, n);
      }
    }
    for (;;)
    {
      super.b();
      return;
      paramBoolean = false;
      break;
      if (b(locallgf))
      {
        this.jdField_a_of_type_Miw.a(this.o, this.jdField_d_of_type_AndroidGraphicsRect, this.jdField_e_of_type_AndroidGraphicsRect, this.jdField_a_of_type_JavaUtilHashMap);
        this.jdField_a_of_type_Miw.a(locallgf, this.jdField_a_of_type_ArrayOfMee, n, i1, paramBoolean, this.u, this.o);
        new mcq(l1, "layoutVideoView", 5, null).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
    }
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    return (this.jdField_a_of_type_Mle != null) && (this.jdField_a_of_type_Mle.dispatchHoverEvent(paramMotionEvent));
  }
  
  public void d(long paramLong)
  {
    int n = a("closeSelfRender", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), 1);
    if (n >= 0) {
      b("closeSelfRender", n);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    mqq.a("switch_camera", "onCameraSwitched", 3, new Object[0]);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onCameraSwitched isFrontCamera: " + paramBoolean);
    }
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int n = a("onCameraSwitched", str, 1);
    if (n >= 0)
    {
      str = str + "_" + 1;
      GraphicRenderMgr localGraphicRenderMgr = GraphicRenderMgr.getInstance();
      localGraphicRenderMgr.clearCameraFrames();
      localGraphicRenderMgr.flushGlRender(str);
      this.jdField_a_of_type_ComTencentAvVideoController.a(true);
      this.jdField_a_of_type_ArrayOfMee[n].o(false);
      this.jdField_a_of_type_ComTencentAvVideoController.a(new mky(this, n, paramBoolean));
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int != 3000) {
        break label300;
      }
      if (!paramBoolean) {
        break label264;
      }
      axqw.b(null, "CliOper", "", "", "0X80041B5", "0X80041B5", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().I)
      {
        if (!paramBoolean) {
          break;
        }
        axqw.b(null, "CliOper", "", "", "0X8005211", "0X8005211", 0, 0, "", "", "", "");
      }
      return;
      label264:
      axqw.b(null, "CliOper", "", "", "0X80041B4", "0X80041B4", 0, 0, "", "", "", "");
      continue;
      label300:
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int == 1) {
        if (paramBoolean)
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().C == 10) {
            axqw.b(null, "CliOper", "", "", "0X800593B", "0X800593B", 0, 0, "", "", "", "");
          } else {
            axqw.b(null, "CliOper", "", "", "0X80046E2", "0X80046E2", 0, 0, "", "", "", "");
          }
        }
        else if (this.jdField_a_of_type_ComTencentAvVideoController.a().C == 10) {
          axqw.b(null, "CliOper", "", "", "0X800593A", "0X800593A", 0, 0, "", "", "", "");
        } else {
          axqw.b(null, "CliOper", "", "", "0X80046E1", "0X80046E1", 0, 0, "", "", "", "");
        }
      }
    }
    axqw.b(null, "CliOper", "", "", "0X8005210", "0X8005210", 0, 0, "", "", "", "");
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      E();
    }
    TextView localTextView;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label35;
      }
    }
    label35:
    for (int n = 0;; n = 8)
    {
      localTextView.setVisibility(n);
      return;
    }
  }
  
  boolean e()
  {
    return lsv.a(this.jdField_a_of_type_AndroidContentContext) == 2;
  }
  
  public int f()
  {
    return this.jdField_a_of_type_Miw.a();
  }
  
  void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      E();
    }
    if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null)) {}
    while (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffffff"));
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130848752);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#5f656f"));
    this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130848753);
  }
  
  boolean f()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity))
    {
      boolean bool3 = ((AVActivity)this.jdField_a_of_type_AndroidContentContext).a();
      boolean bool1;
      if (!k())
      {
        bool1 = true;
        if ((!bool3) || (!bool1)) {
          break label84;
        }
      }
      label84:
      for (boolean bool2 = true;; bool2 = false)
      {
        lcl.c(this.jdField_a_of_type_JavaLangString, "SwitchLocalToBigView:" + bool3 + "|" + bool1);
        return bool2;
        bool1 = false;
        break;
      }
    }
    return false;
  }
  
  public void g(int paramInt)
  {
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "changeLayoutMode, screenStyle[" + this.jdField_a_of_type_ComTencentAvVideoController.a().M + "->" + paramInt + "], ScreenLayout[" + this.jdField_a_of_type_Miw.a() + "->" + paramInt + "], seq[" + l1 + "]");
    super.g(paramInt);
    int n = this.jdField_a_of_type_Miw.a();
    if (n != paramInt)
    {
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_Miw = miw.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, false);
      if (i())
      {
        super.a(null);
        super.d(-15197410);
        new mcq(l1, "changeLayoutMode", 5, null).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        c(true);
        if ((n != 3) || (paramInt != 4)) {
          break label313;
        }
        n = 1;
      }
    }
    for (;;)
    {
      label196:
      if (n == 1)
      {
        float f1 = muf.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
        float f2 = muf.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
        n = 0;
        label227:
        if (n < this.jdField_a_of_type_ArrayOfMee.length)
        {
          if (n == 0)
          {
            this.jdField_a_of_type_ArrayOfMee[n].h(false);
            this.jdField_a_of_type_ArrayOfMee[n].j(12);
            this.jdField_a_of_type_ArrayOfMee[n].a(f2);
          }
          for (;;)
          {
            this.jdField_a_of_type_ArrayOfMee[n].i();
            n += 1;
            break label227;
            B();
            a(Integer.valueOf(6501), null);
            break;
            if ((n == 4) && (paramInt == 3))
            {
              n = 2;
              break label196;
            }
            if (paramInt != 3) {
              break label507;
            }
            n = 3;
            break label196;
            this.jdField_a_of_type_ArrayOfMee[n].h(true);
            this.jdField_a_of_type_ArrayOfMee[n].j(12);
            this.jdField_a_of_type_ArrayOfMee[n].a(f1);
          }
        }
      }
      label313:
      n = 0;
      if (n < this.jdField_a_of_type_ArrayOfMee.length)
      {
        this.jdField_a_of_type_ArrayOfMee[n].e(this.jdField_a_of_type_Miw.b());
        mee localmee = this.jdField_a_of_type_ArrayOfMee[n];
        if (paramInt == 3) {}
        for (boolean bool = true;; bool = false)
        {
          localmee.f(bool);
          a(l1, this.jdField_a_of_type_ArrayOfMee[n]);
          n += 1;
          break;
        }
      }
      if ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity)) {
        ((AVActivity)this.jdField_a_of_type_AndroidContentContext).g(l1);
      }
      this.jdField_e_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) {
        i(paramInt);
      }
      return;
      label507:
      n = 0;
    }
  }
  
  boolean g()
  {
    boolean bool2 = false;
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int n = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (n < this.jdField_a_of_type_ArrayOfMee.length)
      {
        mee localmee = this.jdField_a_of_type_ArrayOfMee[n];
        if ((localmee.a() == 0) && (str.equals(localmee.b()))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      n += 1;
    }
  }
  
  protected void h(int paramInt)
  {
    this.jdField_a_of_type_Miw.a(this.jdField_a_of_type_ArrayOfMee, paramInt, b(), c(), this.n, this.o);
  }
  
  public boolean h()
  {
    return (this.o == 0) || (this.n == 0) || (this.n == this.jdField_i_of_type_Int) || (this.jdField_c_of_type_Boolean);
  }
  
  public void i(int paramInt)
  {
    if (this.D != paramInt) {
      this.D = paramInt;
    }
  }
  
  public void j(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      E();
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(paramInt);
      if (paramInt == 1) {
        this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine();
      }
    }
  }
  
  public void k(int paramInt)
  {
    this.J = paramInt;
  }
  
  protected void l()
  {
    super.l();
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.post(new VideoLayerUI.1(this));
  }
  
  void l(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MultiVideoOpenAnimation != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MultiVideoOpenAnimation);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MultiVideoOpenAnimation = null;
      c(false);
    }
    if (!o())
    {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MultiVideoOpenAnimation = new VideoLayerUI.MultiVideoOpenAnimation(this, paramInt);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MultiVideoOpenAnimation);
    }
  }
  
  protected void m()
  {
    this.jdField_a_of_type_Mjd = new mjd(this.jdField_a_of_type_ComTencentAvVideoController);
  }
  
  protected void m(int paramInt) {}
  
  public void o() {}
  
  public void p()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MultiVideoOpenAnimation);
    this.jdField_c_of_type_JavaLangRunnable = null;
    this.jdField_d_of_type_JavaLangRunnable = null;
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentAvWidgetRotateLayout = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_JavaUtilList = null;
    a(null);
    this.jdField_b_of_type_Lsi = null;
    this.jdField_a_of_type_AndroidViewGestureDetector = null;
    this.jdField_a_of_type_Lqq = null;
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = null;
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MultiVideoOpenAnimation = null;
    H();
    if (this.jdField_a_of_type_Mom != null)
    {
      if ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity))
      {
        localObject = (AVActivity)this.jdField_a_of_type_AndroidContentContext;
        this.jdField_a_of_type_Mom.b(((AVActivity)localObject).jdField_e_of_type_Boolean);
      }
      this.jdField_a_of_type_Mom = null;
    }
    int n;
    if ((this.D == -1) || (this.D == 2) || (this.D == 1))
    {
      n = 1;
      if (n == 0) {
        if (this.jdField_a_of_type_Miw.a() != 3) {
          break label296;
        }
      }
    }
    label296:
    for (Object localObject = "1";; localObject = "2")
    {
      axqw.b(null, "CliOper", "", "", "0X8009F5D", "0X8009F5D", 0, 0, (String)localObject, "", "", "");
      if (this.jdField_a_of_type_Miw != null)
      {
        this.jdField_a_of_type_Miw.a();
        this.jdField_a_of_type_Miw = null;
      }
      D();
      if (this.jdField_a_of_type_Mlm != null) {
        this.jdField_a_of_type_Mlm.b();
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      super.p();
      return;
      n = 0;
      break;
    }
  }
  
  public void q()
  {
    super.q();
    o(this.u);
  }
  
  public void r()
  {
    if (this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.onResume();
    }
  }
  
  protected void s()
  {
    this.jdField_k_of_type_Boolean = false;
    o(this.u);
  }
  
  void t()
  {
    int n = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0)) && (n == 2))
    {
      u();
      this.jdField_a_of_type_Mom.a();
    }
  }
  
  void u()
  {
    if (this.jdField_a_of_type_Mom == null) {
      this.jdField_a_of_type_Mom = new mom(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI
 * JD-Core Version:    0.7.0.1
 */