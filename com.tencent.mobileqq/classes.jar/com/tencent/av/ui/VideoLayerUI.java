package com.tencent.av.ui;

import agej;
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
import bdll;
import begp;
import begw;
import bhsi;
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
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import lbj;
import lch;
import lci;
import lcv;
import lff;
import lgi;
import lir;
import liw;
import lmi;
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
import lzq;
import mbb;
import mct;
import mcz;
import mep;
import mjj;
import mjs;
import mkk;
import mlm;
import mln;
import mlo;
import mlp;
import mlq;
import mlr;
import mls;
import mlt;
import mlu;
import mlv;
import mlw;
import mlx;
import mly;
import mma;
import mmd;
import mpf;
import mqq.os.MqqHandler;
import mrk;
import mtk;
import mvd;

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
  private ConcurrentHashMap<Long, mma> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private lci jdField_a_of_type_Lci;
  private lqq jdField_a_of_type_Lqq;
  private lsn jdField_a_of_type_Lsn;
  private lsr jdField_a_of_type_Lsr;
  private lty jdField_a_of_type_Lty;
  private mkk jdField_a_of_type_Mkk = new mkk(this.jdField_a_of_type_AndroidContentContext, paramVideoAppInterface, this);
  private mlu jdField_a_of_type_Mlu;
  private mlx jdField_a_of_type_Mlx = new mlx(this);
  private mmd jdField_a_of_type_Mmd = new mmd(this.jdField_a_of_type_ComTencentAvVideoController, this);
  mpf jdField_a_of_type_Mpf;
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
  private Rect e;
  private volatile boolean f;
  private final boolean g = true;
  private boolean h = true;
  public int i;
  private boolean i;
  public int j;
  private boolean j;
  public int k;
  private boolean k;
  public int l;
  private boolean l;
  public int m = 0;
  private int v = -1;
  private int w = -1;
  private int x;
  private int y;
  private int z;
  
  public VideoLayerUI(VideoAppInterface paramVideoAppInterface, Context paramContext, View paramView)
  {
    super(paramVideoAppInterface, paramContext, paramView);
    this.jdField_e_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_j_of_type_Int = 144;
    this.jdField_k_of_type_Int = 144;
    this.jdField_l_of_type_Int = 4;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Mjj = mjj.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1, false);
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
    this.t = bhsi.a(this.jdField_a_of_type_AndroidContentContext).getInt("video_position", 3);
  }
  
  private void B()
  {
    int i1 = 2130841927;
    int n = i1;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      n = i1;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 1008) {
        n = 2130842086;
      }
    }
    this.jdField_a_of_type_ArrayOfMep[0].a(mvd.a(this.jdField_a_of_type_AndroidContentContext, n));
    super.a(mvd.a(this.jdField_a_of_type_AndroidContentContext, n));
  }
  
  private void C()
  {
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(this.jdField_a_of_type_AndroidContentContext, new mlw(this));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new mlr(this));
    this.jdField_a_of_type_Lqq = new lqq(this.jdField_a_of_type_AndroidContentContext, new mls(this, null));
    this.jdField_b_of_type_Lsi = new mly(this.jdField_a_of_type_Mlx);
    a(this.jdField_b_of_type_Lsi);
    this.m = agej.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  private void D()
  {
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.x = 0;
      this.y = 0;
      this.h = true;
      return;
    }
  }
  
  private void E()
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null)
    {
      this.jdField_a_of_type_ComTencentAvWidgetRotateLayout = ((RotateLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363082));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363089));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363091));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363090));
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources();
      this.H = ((int)localResources.getDimension(2131297750));
      this.I = ((int)localResources.getDimension(2131297751));
      int n = (int)(localResources.getDimension(2131296332) + localResources.getDimension(2131296399));
      int i1 = (int)(localResources.getDimension(2131296334) + localResources.getDimension(2131296401));
      int i2 = (int)(localResources.getDimension(2131296331) + localResources.getDimension(2131296398));
      float f1 = localResources.getDimension(2131296333);
      int i3 = (int)(localResources.getDimension(2131296400) + f1);
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
    this.jdField_a_of_type_Mlu = new mlu(this, this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView);
    ViewCompat.setAccessibilityDelegate(this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView, this.jdField_a_of_type_Mlu);
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
    int n = Math.max(0, i1 / (this.jdField_j_of_type_Int + this.jdField_l_of_type_Int));
    int i2 = this.jdField_j_of_type_Int;
    int i3 = this.jdField_l_of_type_Int;
    i1 = (int)Math.ceil((j() - ((n + 1) * (i2 + i3) - i1)) * 1.0F / (this.jdField_j_of_type_Int + this.jdField_l_of_type_Int));
    c(n, Math.min(k() - 1, i1 + n));
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
    Bitmap localBitmap = mvd.a(this.jdField_a_of_type_AndroidContentContext, 2130840502);
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
  
  private Bitmap a(mma parammma)
  {
    if (parammma.jdField_a_of_type_Int == 0) {
      return this.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(parammma.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().g), this.jdField_a_of_type_ComTencentAvVideoController.a().F, true, false);
    }
    return ((BitmapDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842105)).getBitmap();
  }
  
  private Boolean a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 2) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  private static final String a(CharSequence paramCharSequence)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramCharSequence);
    int n = paramCharSequence.length();
    begw[] arrayOfbegw = (begw[])((begp)paramCharSequence).getSpans(0, n, begw.class);
    n = 0;
    int i2;
    for (int i1 = 0; n < arrayOfbegw.length; i1 = i2)
    {
      Object localObject = arrayOfbegw[n];
      i2 = i1;
      if ((localObject instanceof begw))
      {
        int i3 = ((begp)paramCharSequence).getSpanStart(localObject);
        int i4 = ((begp)paramCharSequence).getSpanEnd(localObject);
        i2 = i1;
        if (((begw)localObject).c == 2)
        {
          localObject = ((begw)localObject).a();
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
  
  private String a(mma parammma)
  {
    if (parammma.jdField_a_of_type_Int == 0)
    {
      parammma = this.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(parammma.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().g), this.jdField_a_of_type_ComTencentAvVideoController.a().F);
      return parammma;
    }
    long l1 = parammma.jdField_a_of_type_Long;
    if (parammma.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null) {}
    for (AVPhoneUserInfo localAVPhoneUserInfo = parammma.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;; localAVPhoneUserInfo = this.jdField_a_of_type_ComTencentAvVideoController.a(l1, this.jdField_a_of_type_ComTencentAvVideoController.a().f))
    {
      if ((localAVPhoneUserInfo == null) || (localAVPhoneUserInfo.telInfo.mobile == null)) {
        break label154;
      }
      parammma.jdField_a_of_type_JavaLangString = localAVPhoneUserInfo.telInfo.mobile;
      String str = this.jdField_a_of_type_ComTencentAvVideoController.a(localAVPhoneUserInfo.telInfo.mobile);
      parammma = str;
      if (str != null) {
        break;
      }
      return mtk.a(localAVPhoneUserInfo.telInfo.mobile, 4);
    }
    label154:
    if ((localAVPhoneUserInfo != null) && (QLog.isColorLevel())) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getMemmberName --> can not get Open Id. PhoneInfo = " + localAVPhoneUserInfo.toString());
    }
    return this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692847);
  }
  
  private void a(long paramLong, int paramInt)
  {
    int n = a("refreshMicState", String.valueOf(paramLong), 1);
    if (n != -1) {
      this.jdField_a_of_type_ArrayOfMep[n].h(paramInt);
    }
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    paramView = paramView.findViewById(2131363097);
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
  
  private void a(mep parammep, float paramFloat, long paramLong)
  {
    paramLong /= 10L;
    a(new VideoLayerUI.10(this, paramLong, parammep, (float)Math.pow(paramFloat, 1.0D / paramLong)));
  }
  
  private void a(mep parammep, boolean paramBoolean)
  {
    lss locallss = new lss();
    locallss.b(50);
    locallss.b(0.0F, 0.0F, 0.0F, 90.0F, 0.0F, 0.0F);
    locallss.a(new mlm(this, parammep, paramBoolean));
    locallss.a(1);
    parammep.a(locallss);
    parammep.b();
  }
  
  private void a(boolean paramBoolean, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0))
    {
      u();
      Object localObject = this.jdField_a_of_type_Mpf.a();
      if (localObject != null)
      {
        localObject = ((ZimuItem)localObject).getId();
        int n = 1;
        if (!paramBoolean) {
          n = 4;
        }
        new mcz(paramLong, "showLastZimu", n, (String)localObject).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
    }
  }
  
  private boolean a(CharSequence paramCharSequence)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int n;
    if ((paramCharSequence instanceof begp))
    {
      paramCharSequence = (begw[])((begp)paramCharSequence).getSpans(0, paramCharSequence.length(), begw.class);
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
  
  private mma b(long paramLong)
  {
    mma localmma2 = (mma)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    mma localmma1 = localmma2;
    if (localmma2 == null)
    {
      localmma1 = new mma();
      localmma1.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), localmma1);
    }
    return localmma1;
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if ((this.B == paramInt) && (!paramBoolean)) {
      return;
    }
    this.B = paramInt;
    I();
  }
  
  private void b(long paramLong, mep parammep, String paramString, int paramInt, boolean paramBoolean)
  {
    if (parammep != null)
    {
      a(paramString, paramInt);
      parammep.a(paramString, paramInt);
      parammep.a(0);
      parammep.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    }
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
            localObject = this.jdField_a_of_type_ComTencentAvVideoController.a(str3, String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().g), this.jdField_a_of_type_ComTencentAvVideoController.a().F);
          }
        }
      }
      paramRecvMsg = paramRecvMsg.d();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showRecvMsg friendUin: " + str2 + ", senderUin: " + str3 + ", senderName: " + (String)localObject + ", msg: " + paramRecvMsg);
      }
      p(this.u);
      g(true);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
    } while ((paramRecvMsg == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null));
    Object localObject = new begp(paramRecvMsg, 11);
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
      i1 = this.jdField_a_of_type_ArrayOfMep[0].f();
      f1 = this.jdField_a_of_type_ArrayOfMep[0].d();
      n = this.jdField_a_of_type_ArrayOfMep[0].g();
      bool = this.jdField_a_of_type_ArrayOfMep[0].i();
      if (i4 == 4) {
        paramString = this.jdField_a_of_type_ArrayOfMep[0].a();
      }
    }
    for (;;)
    {
      int i2;
      int i3;
      if ((i4 == 4) && (this.jdField_a_of_type_Mjj.a() == 3))
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
      mep localmep;
      for (;;)
      {
        if ((i2 != 0) && (i3 != 0))
        {
          i2 = -1;
          i3 = paramInt + 1;
          for (;;)
          {
            if (i3 < this.jdField_a_of_type_ArrayOfMep.length)
            {
              if (this.jdField_a_of_type_ArrayOfMep[i3].a() == 0) {
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
            i3 = this.jdField_a_of_type_ArrayOfMep[paramInt].d();
            i5 = this.jdField_a_of_type_ArrayOfMep[i2].d();
            this.jdField_a_of_type_ArrayOfMep[paramInt].c(i5);
            this.jdField_a_of_type_ArrayOfMep[i2].c(i3);
            localmep = this.jdField_a_of_type_ArrayOfMep[paramInt];
            this.jdField_a_of_type_ArrayOfMep[paramInt] = this.jdField_a_of_type_ArrayOfMep[i2];
            this.jdField_a_of_type_ArrayOfMep[i2] = localmep;
            localmep.a("");
            localmep = this.jdField_a_of_type_ArrayOfMep[i2];
            localmep.a(1);
            localmep.b(null);
            localmep.l(true);
            localmep.j(false);
            localmep.f(false);
            localmep.k(true);
            localmep.a(null, 0);
            label362:
            if (paramInt == 0)
            {
              this.jdField_a_of_type_ArrayOfMep[0].g(false);
              this.jdField_a_of_type_ArrayOfMep[0].k(i1);
              this.jdField_a_of_type_ArrayOfMep[0].a(f1);
              this.jdField_a_of_type_ArrayOfMep[0].j(n);
              this.jdField_a_of_type_ArrayOfMep[0].i(bool);
              if (i4 == 4)
              {
                if (this.jdField_a_of_type_ArrayOfMep[0].h() != 2) {
                  break label662;
                }
                this.jdField_a_of_type_ArrayOfMep[0].a(ImageView.ScaleType.CENTER_INSIDE);
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
        while (i2 < this.jdField_a_of_type_ArrayOfMep.length)
        {
          if ((i2 >= this.jdField_a_of_type_ArrayOfMep.length - 1) || (this.jdField_a_of_type_ArrayOfMep[(i2 + 1)].a() != 0)) {
            break label599;
          }
          i3 = this.jdField_a_of_type_ArrayOfMep[i2].d();
          i5 = this.jdField_a_of_type_ArrayOfMep[(i2 + 1)].d();
          this.jdField_a_of_type_ArrayOfMep[i2].c(i5);
          this.jdField_a_of_type_ArrayOfMep[(i2 + 1)].c(i3);
          localmep = this.jdField_a_of_type_ArrayOfMep[i2];
          this.jdField_a_of_type_ArrayOfMep[i2] = this.jdField_a_of_type_ArrayOfMep[(i2 + 1)];
          this.jdField_a_of_type_ArrayOfMep[(i2 + 1)] = localmep;
          i2 += 1;
        }
        break label362;
        label599:
        localmep = this.jdField_a_of_type_ArrayOfMep[i2];
        localmep.a(1);
        localmep.b(null);
        localmep.l(true);
        localmep.j(false);
        localmep.f(false);
        localmep.k(true);
        localmep.a(null, 0);
        localmep.a("");
        break label362;
        label662:
        this.jdField_a_of_type_ArrayOfMep[0].a(paramString);
      }
      continue;
      f1 = 0.0F;
      i1 = 0;
      n = 0;
      bool = false;
    }
  }
  
  private void b(mep parammep, boolean paramBoolean)
  {
    lss locallss = new lss();
    locallss.b(50);
    locallss.b(0.0F, 0.0F, -90.0F, 0.0F, 0.0F, 0.0F);
    locallss.a(2);
    locallss.a(new mln(this));
    parammep.a(locallss);
    parammep.b();
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_d_of_type_Long != 0L) && (System.currentTimeMillis() - this.jdField_d_of_type_Long < 1000L))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "bigWindowToSmallWindowAnim, 大小窗正在切换中[" + this.jdField_d_of_type_Long + "]");
      return false;
    }
    mep localmep = this.jdField_a_of_type_ArrayOfMep[paramInt2];
    localmep.a(Boolean.valueOf(false));
    localmep.a(0, 0, 0, 0);
    int n = localmep.d();
    localmep.c(1);
    float f1 = localmep.b().left;
    float f2 = localmep.b().top;
    Rect localRect = super.a();
    lss locallss = new lss();
    locallss.b(100);
    locallss.a(f1, f2, 0.0F, -localRect.left, -localRect.top, 0.0F);
    locallss.a(localmep.b().width(), localmep.b().height(), super.b() + localRect.left + localRect.right, super.c() + localRect.top + localRect.bottom);
    locallss.a(new mlp(this, paramInt2, n, paramInt1));
    locallss.a(2);
    localmep.a(locallss);
    localmep.b();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    return true;
  }
  
  private void c(int paramInt1, int paramInt2)
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
  
  private void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    paramInt3 = paramInt1 + this.jdField_l_of_type_Int;
    paramInt4 = this.jdField_j_of_type_Int;
    paramInt1 = paramInt3;
    paramInt3 += paramInt4;
    int n = 1;
    paramInt4 = paramInt1;
    paramInt1 = n;
    while (paramInt1 <= i1)
    {
      ((lsh)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1 - 1)).b(paramInt4, paramInt2, paramInt3, this.jdField_k_of_type_Int + paramInt2);
      paramInt4 += this.jdField_j_of_type_Int + this.jdField_l_of_type_Int;
      paramInt3 = paramInt4 + this.jdField_j_of_type_Int;
      paramInt1 += 1;
    }
    this.C = ((this.jdField_j_of_type_Int + this.jdField_l_of_type_Int) * i1 + this.jdField_l_of_type_Int);
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
    Object localObject = this.jdField_a_of_type_ArrayOfMep[paramInt1];
    mep localmep = this.jdField_a_of_type_ArrayOfMep[paramInt2];
    ((mep)localObject).a(Boolean.valueOf(false));
    ((mep)localObject).a(0, 0, 0, 0);
    localmep.a(Boolean.valueOf(false));
    localmep.a(0, 0, 0, 0);
    int n = localmep.d();
    localmep.c(((mep)localObject).d());
    Rect localRect = localmep.b();
    localObject = ((mep)localObject).b();
    lss locallss = new lss();
    locallss.b(300);
    locallss.a(localRect.left, localRect.top, 0.0F, ((Rect)localObject).left, ((Rect)localObject).top, 0.0F);
    locallss.a(localRect.width(), localRect.height(), ((Rect)localObject).width(), ((Rect)localObject).height());
    locallss.a(new mlq(this, paramInt2, n, paramInt1));
    locallss.a(2);
    localmep.a(locallss);
    localmep.b();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    return true;
  }
  
  private boolean d(int paramInt1, int paramInt2)
  {
    if ((this.jdField_d_of_type_Long != 0L) && (System.currentTimeMillis() - this.jdField_d_of_type_Long < 1000L))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "sliderWindowBigToSmallAnimation, 大小窗正在切换中[" + this.jdField_d_of_type_Long + "]");
      return false;
    }
    mep localmep = this.jdField_a_of_type_ArrayOfMep[paramInt2];
    localmep.a(Boolean.valueOf(false));
    localmep.a(0, 0, 0, 0);
    b(new VideoLayerUI.9(this, paramInt1, paramInt2));
    b();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    return true;
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
      int n = (int)(((Resources)localObject).getDimension(2131296332) + ((Resources)localObject).getDimension(2131296399));
      int i1 = (int)(((Resources)localObject).getDimension(2131296334) + ((Resources)localObject).getDimension(2131296401));
      int i2 = (int)(((Resources)localObject).getDimension(2131296331) + ((Resources)localObject).getDimension(2131296398));
      f1 = ((Resources)localObject).getDimension(2131296333);
      int i3 = (int)(((Resources)localObject).getDimension(2131296400) + f1);
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(n, i1, i2, i3);
      this.jdField_b_of_type_AndroidWidgetTextView.getBackground().setAlpha(128);
      if ((this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.isShown()) && (!paramBoolean))
      {
        localObject = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject).setDuration(1000L);
        ((AlphaAnimation)localObject).setFillAfter(true);
        ((AlphaAnimation)localObject).setAnimationListener(new mlt(this, null));
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
    Object localObject1;
    int i5;
    int i4;
    int i1;
    for (;;)
    {
      try
      {
        localObject1 = (mep)a(0);
        l1 = Long.parseLong(((mep)localObject1).b());
        i5 = ((mep)localObject1).h();
        if (!(a().a instanceof DoubleVideoMeetingCtrlUI))
        {
          localObject1 = this.jdField_a_of_type_Mmd.a(false);
          if (!this.jdField_i_of_type_Boolean) {
            break label1308;
          }
          this.jdField_a_of_type_Mkk.a((ArrayList)localObject1);
          if (((ArrayList)localObject1).size() <= this.E) {
            break label675;
          }
          i3 = 1;
          i4 = 1;
          if ((i4 < ((ArrayList)localObject1).size()) && ((this.jdField_a_of_type_JavaUtilArrayList.size() != this.E - 2) || (i3 == 0))) {
            break;
          }
          i1 = n;
          if (i3 != 0)
          {
            this.jdField_a_of_type_Mep.b(((ArrayList)localObject1).size() - this.E + 1 + "+");
            if (!((Boolean)this.jdField_a_of_type_Mep.a(2)).booleanValue()) {
              break label1291;
            }
            this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Mep);
            i1 = n;
          }
          label224:
          if ((i1 >= 2) && (mvd.a(2))) {
            ThreadManager.getUIHandler().post(new VideoLayerUI.3(this));
          }
          paramlqt.a(b() / 2, c() / 2, 0.0F);
          c(paramlqt);
          paramlqt.a(-b() / 2, -c() / 2, 0.0F);
          i1 = a("renderSliderWindowStyle", String.valueOf(((mma)((ArrayList)localObject1).get(0)).jdField_a_of_type_Long), ((mma)((ArrayList)localObject1).get(0)).b());
          n = i1;
          if (i1 == -1) {
            n = 0;
          }
          localObject2 = this.jdField_a_of_type_ArrayOfMep[n];
          if (!((mma)((ArrayList)localObject1).get(0)).e()) {
            break label1362;
          }
          n = 1;
          label369:
          i1 = n;
          if (n == 0)
          {
            if (!((mma)((ArrayList)localObject1).get(0)).d()) {
              break label1367;
            }
            i1 = 2;
          }
          label392:
          ((mep)localObject2).h(i1);
          ((mep)localObject2).g(false);
          ((mep)localObject2).a(0, 0, 0, 0);
          ((mep)localObject2).b(0, 0, super.b(), super.c());
          a(paramlqt, (lsh)localObject2, true);
          if ((!((mep)localObject2).a()) && (QLog.isDevelopLevel())) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 1, "error happen big screen can not render with Uin:=" + ((mep)localObject2).b() + ",srcType:=" + ((mep)localObject2).h());
          }
          c(this.jdField_e_of_type_AndroidGraphicsRect.left, this.jdField_e_of_type_AndroidGraphicsRect.top, this.jdField_e_of_type_AndroidGraphicsRect.right, this.jdField_e_of_type_AndroidGraphicsRect.bottom);
          n = this.jdField_a_of_type_Lsr.a();
          if (!this.h) {
            break label1372;
          }
          bool1 = true;
          label546:
          c(n, bool1);
          if (this.h) {
            this.h = false;
          }
          paramlqt.a(-this.x, -this.y);
          n = 0;
          if (n >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
            break label1378;
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
      label625:
      localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.c();
      this.jdField_a_of_type_Mmd.a((ArrayList)localObject1);
      localObject1 = this.jdField_a_of_type_Mmd.a(true);
      if (((ArrayList)localObject1).size() == 0) {
        QLog.d("GLLinearLayout", 1, "videoMemmberInfos size is zero");
      }
      continue;
      label675:
      int i3 = 0;
    }
    Object localObject2 = (mma)((ArrayList)localObject1).get(i4);
    long l2 = ((mma)localObject2).a();
    i2 = ((mma)localObject2).b();
    ((mma)localObject2).a();
    boolean bool1 = ((mma)localObject2).jdField_a_of_type_Boolean;
    boolean bool3 = ((mma)localObject2).c();
    ((mma)localObject2).d();
    Object localObject3;
    if (bool3)
    {
      i1 = n;
      if (l2 == l1)
      {
        i1 = n;
        if (i2 == i5)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 1, "arraysToList3 bigindex index:=" + i4);
          }
          i1 = n + 1;
        }
      }
      int i6 = a("renderSliderWindowStyle", String.valueOf(l2), i2);
      if (i6 != -1)
      {
        localObject3 = this.jdField_a_of_type_ArrayOfMep[i6];
        if (((mma)localObject2).e())
        {
          n = 1;
          label837:
          i2 = n;
          if (n == 0)
          {
            if (!((mma)localObject2).d()) {
              break label1109;
            }
            i2 = 2;
          }
          label855:
          ((mep)localObject3).h(i2);
          if (TextUtils.isEmpty(((mep)localObject3).a()))
          {
            ((mep)localObject3).b(a((mma)localObject2));
            ((mep)localObject3).i(true);
          }
          ((mep)localObject3).j(12);
          ((mep)localObject3).a(mvd.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
          ((mep)localObject3).g(true);
          this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ArrayOfMep[i6]);
          n = i1 + 1;
          i1 = 1;
        }
      }
    }
    for (;;)
    {
      label939:
      mep localmep;
      if (((!bool3) && (bool1)) || (i1 == 0))
      {
        localmep = this.jdField_a_of_type_Mkk.a(l2);
        localmep.b(false);
        localmep.g(true);
        if (((mma)localObject2).e())
        {
          i1 = 1;
          label986:
          i2 = i1;
          if (i1 == 0)
          {
            if (!((mma)localObject2).d()) {
              break label1127;
            }
            i2 = 2;
          }
          label1004:
          localmep.h(i2);
          if (((Boolean)localmep.a(2)).booleanValue()) {
            break label1133;
          }
          localmep.b(a((mma)localObject2));
          localmep.i(true);
          localObject3 = a((mma)localObject2);
          localObject2 = localObject3;
          if (Build.VERSION.SDK_INT == 23) {
            localObject2 = a((Bitmap)localObject3);
          }
          localObject2 = new lrx((Bitmap)localObject2);
          ((lrx)localObject2).b(paramlqt);
          localmep.a((lrx)localObject2);
        }
      }
      for (;;)
      {
        i4 += 1;
        break;
        n = 0;
        break label837;
        label1109:
        i2 = 3;
        break label855;
        n = i1;
        i1 = 0;
        break label939;
        i1 = 0;
        break label986;
        label1127:
        i2 = 3;
        break label1004;
        label1133:
        this.jdField_a_of_type_JavaUtilArrayList.add(localmep);
        continue;
        if (!bool1)
        {
          localmep = this.jdField_a_of_type_Mkk.a(l2);
          localmep.b(true);
          localmep.g(Color.parseColor("#4C000000"));
          localmep.h(-1);
          localmep.g(true);
          if (!((Boolean)localmep.a(2)).booleanValue())
          {
            localmep.b(a((mma)localObject2));
            localmep.i(true);
            localObject3 = a((mma)localObject2);
            localObject2 = localObject3;
            if (Build.VERSION.SDK_INT == 23) {
              localObject2 = a((Bitmap)localObject3);
            }
            localObject2 = new lrx((Bitmap)localObject2);
            ((lrx)localObject2).b(paramlqt);
            localmep.a((lrx)localObject2);
          }
          else
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(localmep);
          }
        }
      }
      label1291:
      this.jdField_a_of_type_Mep.a(2, Boolean.valueOf(true));
      i1 = n;
      break label224;
      label1308:
      n = 0;
      i1 = i2;
      if (n >= this.jdField_a_of_type_ArrayOfMep.length) {
        break label224;
      }
      localObject2 = this.jdField_a_of_type_ArrayOfMep[n];
      if (!((lsh)localObject2).a()) {}
      for (;;)
      {
        n += 1;
        break;
        if (n != 0) {
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        }
      }
      label1362:
      n = 0;
      break label369;
      label1367:
      i1 = 3;
      break label392;
      label1372:
      bool1 = false;
      break label546;
      label1378:
      paramlqt.a(this.x, this.y);
      if (!(false | bool2)) {
        break label625;
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
    for (int i1 = 0; n < this.jdField_a_of_type_ArrayOfMep.length; i1 = i2)
    {
      mep localmep = this.jdField_a_of_type_ArrayOfMep[n];
      String str = localmep.b();
      i2 = i1;
      if (localmep.a() == 0)
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
  
  private void i(long paramLong)
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (!this.jdField_c_of_type_Boolean)) {
      ((AVActivity)this.jdField_a_of_type_AndroidContentContext).a.C(paramLong);
    }
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
  
  private boolean o()
  {
    return (this.jdField_a_of_type_Mjj != null) && (this.jdField_a_of_type_Mjj.a() == 4) && (!this.f);
  }
  
  private void p(int paramInt)
  {
    if ((this.jdField_l_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getLayoutParams();
    int i3 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131299102);
    int i2 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131299103);
    int i4 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131299097);
    int i1 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131299098);
    int i5 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131299096);
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
      localObject1 = this.jdField_a_of_type_ArrayOfMep[1].b();
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
  
  private void q(int paramInt)
  {
    if (paramInt > 0)
    {
      int n = 0;
      if (paramInt == 2) {
        n = 2131694882;
      }
      if ((n != 0) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
        mbb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1008, n);
      }
    }
  }
  
  private void z()
  {
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
    ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindowManager().getDefaultDisplay().getRealMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
    this.jdField_l_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297834);
    this.jdField_j_of_type_Int = ((this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels - this.jdField_l_of_type_Int * 5) / 4);
    this.jdField_k_of_type_Int = this.jdField_j_of_type_Int;
    int n = this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels;
    n = this.jdField_j_of_type_Int;
    n = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299103);
    this.jdField_d_of_type_AndroidGraphicsRect = new Rect(0, this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels - n - this.jdField_k_of_type_Int, this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels, this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels - n);
    this.jdField_b_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new mlv(this, null));
    this.jdField_a_of_type_Lsr = new lsr(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Lsr.a(true);
    this.jdField_a_of_type_Lsr.a((int)mvd.a(this.jdField_a_of_type_AndroidContentContext, 50.0F));
    this.jdField_a_of_type_Mep = new mep(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, String.format("%s_%s", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(1000) }), this.jdField_a_of_type_ComTencentAvVideoController.g());
    this.jdField_a_of_type_Mep.a(1);
    this.jdField_a_of_type_Mep.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_Mep.a("null", 1);
    this.jdField_a_of_type_Mep.a(true);
    this.jdField_a_of_type_Mep.d(false);
    this.jdField_a_of_type_Mep.g(false);
    this.jdField_a_of_type_Mep.h(true);
    n = agej.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_Mep.a(n);
    this.jdField_a_of_type_Mep.i(true);
    this.jdField_a_of_type_Mep.d(Color.parseColor("#686E6C"));
    this.jdField_a_of_type_Mep.a(2, Boolean.valueOf(false));
    this.jdField_a_of_type_Mep.c(999);
    a(this.jdField_a_of_type_Mep);
  }
  
  public int a(float paramFloat)
  {
    int n = Math.round(paramFloat) + this.B;
    if (n < 0) {
      return -1;
    }
    return n / (this.jdField_j_of_type_Int + this.jdField_l_of_type_Int);
  }
  
  public AVActivity a()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity)) {
      return (AVActivity)this.jdField_a_of_type_AndroidContentContext;
    }
    return null;
  }
  
  public mma a(long paramLong)
  {
    return (mma)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
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
        while (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 2)
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
          p(n);
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
    p(this.u);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
    {
      paramInt1 = i1;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().J)
      {
        paramInt1 = n;
        while (paramInt1 < this.jdField_a_of_type_ArrayOfMep.length)
        {
          this.jdField_a_of_type_ArrayOfMep[paramInt1].i(true);
          paramInt1 += 1;
        }
      }
      while (paramInt1 < this.jdField_a_of_type_ArrayOfMep.length)
      {
        this.jdField_a_of_type_ArrayOfMep[paramInt1].i(true);
        paramInt1 += 1;
      }
    }
    if (this.jdField_a_of_type_Mpf != null) {
      this.jdField_a_of_type_Mpf.a(this, this.n, this.o);
    }
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    this.F = a("notifyGLVideoViewChange", String.valueOf(paramLong1), paramInt1);
    this.G = a("notifyGLVideoViewChange", String.valueOf(paramLong2), paramInt2);
    b(new VideoLayerUI.2(this, this.F, this.G));
  }
  
  public void a(long paramLong, Boolean paramBoolean)
  {
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    b(paramLong);
    int n = a("openSelfScreenShare", str, 2);
    if ((paramBoolean.booleanValue()) && (n > 0)) {
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
    mep localmep;
    if (n < 0)
    {
      i1 = a(0);
      if (i1 >= 0)
      {
        if (paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
          break label264;
        }
        bool = true;
        localmep = this.jdField_a_of_type_ArrayOfMep[i1];
        a(paramLong, localmep, paramString, paramInt, bool);
        if ((localmep != null) && (!bool)) {
          localmep.a(paramLong, CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a());
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
        localmep = this.jdField_a_of_type_ArrayOfMep[n];
        localmep.a(paramBitmap);
        localmep.l(paramBoolean1);
        if (!paramBoolean1) {
          localmep.j(false);
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
    mep localmep = null;
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
        lzq.a();
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
          localmep = this.jdField_a_of_type_ArrayOfMep[n];
          a(paramLong, localmep, paramString, paramInt, true);
        }
        if ((localmep != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().c.size() <= 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)) {
          localmep.a(agej.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        }
        if ((n <= 1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 4)) {
          break label565;
        }
        i1 = 1;
        paramString = localmep;
        paramInt = n;
        n = i1;
      }
      for (;;)
      {
        if (paramString != null)
        {
          paramString.f(paramBoolean2);
          paramString.a(paramLong, this.jdField_a_of_type_Mjj.b());
          if (paramBoolean1) {
            break label525;
          }
          paramBoolean1 = true;
          paramString.j(paramBoolean1);
          paramString.a(0);
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 4) {
            break label541;
          }
          if (paramInt != 0) {
            break label531;
          }
          paramString.a(ImageView.ScaleType.CENTER_INSIDE);
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().N == 3) {
            paramString.g(true);
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
          paramString = this.jdField_a_of_type_ArrayOfMep[n];
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
        paramString = localmep;
        paramInt = n;
        n = i1;
      }
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setRemoteHasVideo, uin[" + paramString + "], videoSrcType[" + paramInt + "], isRemoteHasVideo[" + paramBoolean1 + "], forceToBigView[" + paramBoolean2 + "], mIsLocalHasVideo[" + this.jdField_d_of_type_Boolean + "], isFillBlackEdge[" + paramBoolean3 + "], seq[" + paramLong + "]");
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
      while ((this.jdField_a_of_type_Mpf != null) && (!g()))
      {
        a(paramBoolean1, paramLong);
        return;
        a(paramLong, paramString, paramInt);
      }
    }
  }
  
  void a(long paramLong, mep parammep, String paramString, int paramInt, boolean paramBoolean)
  {
    String str;
    if (parammep != null)
    {
      str = a(paramString, paramInt);
      parammep.a(paramString, paramInt);
      parammep.a(0);
      parammep.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    }
    try
    {
      paramString = parammep.a();
      GraphicRenderMgr.getInstance().setAccountUin(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      GraphicRenderMgr.getInstance().setGlRender(str, paramString);
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setGlRender[initGLVideoViewBasePara], key[" + str + "], debug[" + parammep.c() + "], videoSrcType[" + paramInt + "], yuvTexture[" + paramString + "]");
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int, false, paramBoolean);
      return;
    }
    catch (UnsatisfiedLinkError parammep)
    {
      parammep.printStackTrace();
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    int i1 = 2;
    int n = 1;
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "notifyAudioMemberChange");
    if (((this.jdField_a_of_type_ComTencentAvVideoController.a().F == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)) || (this.jdField_a_of_type_ComTencentAvVideoController.a().F == 2))
    {
      mma localmma = b(paramLong);
      localmma.b = paramBoolean;
      if (!localmma.jdField_c_of_type_Boolean) {
        break label129;
      }
      if (n != 0) {
        break label141;
      }
      if (!localmma.d()) {
        break label135;
      }
      n = i1;
    }
    label129:
    label135:
    label141:
    for (;;)
    {
      a(paramLong, n);
      if ((this.jdField_a_of_type_Mmd != null) && (this.jdField_a_of_type_Mmd.a(paramLong, paramBoolean))) {
        b();
      }
      return;
      n = 0;
      break;
      n = 3;
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
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 1011) {}
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
    lbj.c(this.jdField_a_of_type_JavaLangString, "notifyEvent :" + paramInteger + "|" + paramObject);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { paramInteger, paramObject });
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Mjj.a() != 2)
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
      paramString1 = this.jdField_a_of_type_ArrayOfMep[n];
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
      paramString1.g(bool);
      if (n != 0) {
        break label247;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().D != 2) {
        break;
      }
      paramString1.b("");
      return;
      label188:
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().c.size() <= 1)
      {
        paramString1.a(agej.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
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
  
  public void a(ArrayList<lcv> paramArrayList)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "notifyAudioMemberChange");
    if (this.jdField_a_of_type_Mmd != null) {
      this.jdField_a_of_type_Mmd.a(paramArrayList);
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
      paramObservable = (lgi)paramObservable[1];
      this.jdField_a_of_type_Mpf.a(paramObservable);
      return;
    case 6010: 
      u();
      q(((Integer)paramObservable[1]).intValue());
      return;
    case 6005: 
      b((mcz)mct.a(paramObservable));
      return;
    case 6501: 
      if ((this.jdField_a_of_type_Mpf != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0)))
      {
        this.jdField_a_of_type_Mpf.a(true);
        return;
      }
      liw.a(true);
      return;
    }
    c(true);
  }
  
  public void a(lff paramlff)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "tryRegisterMemmberChangeListener");
    paramlff.a(this.jdField_a_of_type_Mmd);
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
  
  void a(mcz parammcz)
  {
    u();
    String str = parammcz.b;
    long l1 = parammcz.a();
    if (liw.a(str))
    {
      bool2 = lmi.a();
      bool1 = bool2;
      if (bool2) {
        bool1 = this.jdField_a_of_type_Mpf.b(parammcz.a(), str, (ViewGroup)this.jdField_a_of_type_AndroidViewView, this.n, this.o);
      }
      if ((bool1) && ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity))) {
        ((AVActivity)this.jdField_a_of_type_AndroidContentContext).g(l1);
      }
    }
    while ((!this.jdField_a_of_type_Mpf.a(parammcz.a(), str, (ViewGroup)this.jdField_a_of_type_AndroidViewView, this.n, this.o)) || (!(this.jdField_a_of_type_AndroidContentContext instanceof AVActivity)))
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
      str1 = this.jdField_a_of_type_ArrayOfMep[paramInt1].b();
      String str2 = this.jdField_a_of_type_ArrayOfMep[paramInt2].b();
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "switchVideo, begin, [" + paramInt1 + "]=[" + str1 + "], [" + paramInt2 + "]=[" + str2 + "]", new Throwable("打印调用栈"));
    }
    if ((paramInt1 == paramInt2) || (paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_ArrayOfMep.length) || (paramInt2 < 0) || (paramInt2 >= this.jdField_a_of_type_ArrayOfMep.length))
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
      this.jdField_a_of_type_ArrayOfMep[paramInt2].a(ImageView.ScaleType.CENTER_INSIDE);
    }
    for (;;)
    {
      str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      this.jdField_a_of_type_ArrayOfMep[paramInt1].b();
      if (str1.equals(this.jdField_a_of_type_ArrayOfMep[paramInt2].b())) {
        this.jdField_a_of_type_ArrayOfMep[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      }
      if ((this.jdField_a_of_type_Mjj == null) || (this.jdField_a_of_type_Mjj.a() != 3)) {
        break;
      }
      return c(paramInt1, paramInt2);
      label265:
      if (paramInt2 == 0) {
        this.jdField_a_of_type_ArrayOfMep[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      }
    }
    if ((this.jdField_a_of_type_Mjj != null) && (this.jdField_a_of_type_Mjj.a() == 4)) {
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
      a(paramLong, Boolean.valueOf(paramBoolean2));
    }
    for (;;)
    {
      this.jdField_e_of_type_Boolean = paramBoolean1;
      return true;
      c(paramLong);
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
  
  public void b(long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int n = a("openSelfScreenShareRender", (String)localObject2, 2);
    if (n < 0)
    {
      int i1 = a(0);
      if (i1 >= 0)
      {
        localObject1 = this.jdField_a_of_type_ArrayOfMep[i1];
        b(paramLong, (mep)localObject1, (String)localObject2, 2, true);
      }
      n = i1;
      localObject2 = localObject1;
      if (i1 == 0)
      {
        n = i1;
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          n = i1;
          localObject2 = localObject1;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
          {
            ((mep)localObject1).g(false);
            localObject2 = localObject1;
            n = i1;
          }
        }
      }
    }
    for (;;)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setGlRender[openSelfScreenShareRender], index:=" + n);
      if (localObject2 != null)
      {
        ((mep)localObject2).f(false);
        ((mep)localObject2).j(false);
        ((mep)localObject2).l(true);
        ((mep)localObject2).a(0);
        ((mep)localObject2).a(ImageView.ScaleType.CENTER_CROP);
      }
      return;
      localObject1 = a((String)localObject2, 2);
      localObject2 = this.jdField_a_of_type_ArrayOfMep[n];
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setGlRender[openSelfScreenShareRender], key[" + (String)localObject1 + "], index[" + n + "], forceToBigView[" + false + "], " + ((mep)localObject2).c());
    }
  }
  
  void b(long paramLong, Boolean paramBoolean)
  {
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
    int n = a("openSelfVideo", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), 1);
    f(paramLong);
    if ((paramBoolean.booleanValue()) && (n > 0) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Boolean))) {
      a(0, n);
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    int i1 = 2;
    int n = 1;
    if (((this.jdField_a_of_type_ComTencentAvVideoController.a().F == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)) || (this.jdField_a_of_type_ComTencentAvVideoController.a().F == 2))
    {
      mma localmma = b(paramLong);
      localmma.jdField_c_of_type_Boolean = paramBoolean;
      if (!localmma.jdField_c_of_type_Boolean) {
        break label118;
      }
      if (n != 0) {
        break label130;
      }
      if (!localmma.d()) {
        break label124;
      }
      n = i1;
    }
    label130:
    for (;;)
    {
      a(paramLong, n);
      if ((this.jdField_a_of_type_Mmd != null) && (this.jdField_a_of_type_Mmd.b(paramLong, paramBoolean))) {
        b();
      }
      return;
      label118:
      n = 0;
      break;
      label124:
      n = 3;
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
  
  void b(mcz parammcz)
  {
    boolean bool = false;
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestZimu, mHandle[" + parammcz.jdField_a_of_type_Int + "], seq[" + parammcz.a() + "]");
    }
    if (parammcz.jdField_a_of_type_Int == 2) {
      if ((this.jdField_a_of_type_Mpf != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0)))
      {
        this.jdField_a_of_type_Mpf.a((ViewGroup)this.jdField_a_of_type_AndroidViewView, parammcz.a());
        if ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity)) {
          ((AVActivity)this.jdField_a_of_type_AndroidContentContext).g(parammcz.a());
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
          if (parammcz.jdField_a_of_type_Int == 1)
          {
            a(parammcz);
            return;
          }
          if ((parammcz.jdField_a_of_type_Int != 3) && (parammcz.jdField_a_of_type_Int != 4)) {
            break;
          }
        } while (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0));
        u();
        if (parammcz.jdField_a_of_type_Int == 3) {
          bool = true;
        }
      } while ((!this.jdField_a_of_type_Mpf.a(parammcz.a(), (ViewGroup)this.jdField_a_of_type_AndroidViewView, bool)) || (!(this.jdField_a_of_type_AndroidContentContext instanceof AVActivity)));
      ((AVActivity)this.jdField_a_of_type_AndroidContentContext).g(parammcz.a());
      return;
    } while (parammcz.jdField_a_of_type_Int != 5);
    if (this.jdField_a_of_type_Mpf != null)
    {
      this.jdField_a_of_type_Mpf.a(parammcz.a());
      return;
    }
    liw.a(false);
  }
  
  public boolean b(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!e()) {
      return false;
    }
    if (paramBoolean1) {
      G();
    }
    if (paramBoolean1) {
      b(paramLong, Boolean.valueOf(paramBoolean2));
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = paramBoolean1;
      if ((this.jdField_a_of_type_Mpf != null) && (!l())) {
        a(paramBoolean1, paramLong);
      }
      return true;
      e(paramLong);
    }
  }
  
  public void c(long paramLong)
  {
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int n = a("closeSelfScreenShare", str, 2);
    if (n >= 0)
    {
      str = a(str, 2);
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setGlRender[closeSelfVideo_no], key[" + str + "], index[" + n + "], seq[" + paramLong + "]");
      d(paramLong);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    long l1 = AudioHelper.b();
    int n = super.b();
    int i1 = super.c();
    lff locallff = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (a(locallff))
    {
      mjj localmjj = this.jdField_a_of_type_Mjj;
      mep[] arrayOfmep = this.jdField_a_of_type_ArrayOfMep;
      int i2 = this.t;
      int i3 = this.n;
      int i4 = this.o;
      if (!locallff.jdField_e_of_type_Boolean)
      {
        paramBoolean = true;
        localmjj.a(arrayOfmep, n, i1, i2, i3, i4, paramBoolean);
        lir.c(i1, n);
      }
    }
    for (;;)
    {
      super.b();
      return;
      paramBoolean = false;
      break;
      if (b(locallff))
      {
        this.jdField_a_of_type_Mjj.a(this.o, this.jdField_d_of_type_AndroidGraphicsRect, this.jdField_e_of_type_AndroidGraphicsRect, this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
        this.jdField_a_of_type_Mjj.a(locallff, this.jdField_a_of_type_ArrayOfMep, n, i1, paramBoolean, this.u, this.o);
        new mcz(l1, "layoutVideoView", 5, null).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
    }
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    return (this.jdField_a_of_type_Mlu != null) && (this.jdField_a_of_type_Mlu.dispatchHoverEvent(paramMotionEvent));
  }
  
  public void d(long paramLong)
  {
    int n = a("closeSelfScreenShareRender", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), 2);
    if (n >= 0) {
      b("closeSelfScreenShareRender", n);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    mrk.a("switch_camera", "onCameraSwitched", 3, new Object[0]);
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
      this.jdField_a_of_type_ArrayOfMep[n].n(false);
      this.jdField_a_of_type_Lci = new mlo(this, n, paramBoolean);
      this.jdField_a_of_type_ComTencentAvVideoController.a.a(true, this.jdField_a_of_type_Lci);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int != 3000) {
        break label304;
      }
      if (!paramBoolean) {
        break label268;
      }
      bdll.b(null, "CliOper", "", "", "0X80041B5", "0X80041B5", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().J)
      {
        if (!paramBoolean) {
          break;
        }
        bdll.b(null, "CliOper", "", "", "0X8005211", "0X8005211", 0, 0, "", "", "", "");
      }
      return;
      label268:
      bdll.b(null, "CliOper", "", "", "0X80041B4", "0X80041B4", 0, 0, "", "", "", "");
      continue;
      label304:
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 1) {
        if (paramBoolean)
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 10) {
            bdll.b(null, "CliOper", "", "", "0X800593B", "0X800593B", 0, 0, "", "", "", "");
          } else {
            bdll.b(null, "CliOper", "", "", "0X80046E2", "0X80046E2", 0, 0, "", "", "", "");
          }
        }
        else if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 10) {
          bdll.b(null, "CliOper", "", "", "0X800593A", "0X800593A", 0, 0, "", "", "", "");
        } else {
          bdll.b(null, "CliOper", "", "", "0X80046E1", "0X80046E1", 0, 0, "", "", "", "");
        }
      }
    }
    bdll.b(null, "CliOper", "", "", "0X8005210", "0X8005210", 0, 0, "", "", "", "");
  }
  
  void e(long paramLong)
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
      g(paramLong);
    }
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
    return this.jdField_a_of_type_Mjj.a();
  }
  
  public void f(long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int n = a("openSelfVideo", (String)localObject2, 1);
    if (n < 0)
    {
      n = a(0);
      if (n >= 0)
      {
        localObject1 = this.jdField_a_of_type_ArrayOfMep[n];
        a(paramLong, (mep)localObject1, (String)localObject2, 1, false);
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
            ((mep)localObject1).g(false);
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
          ((mep)localObject2).a(paramLong, CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a());
        }
        ((mep)localObject2).f(false);
        ((mep)localObject2).j(false);
        ((mep)localObject2).l(true);
        ((mep)localObject2).a(0);
        ((mep)localObject2).a(ImageView.ScaleType.CENTER_CROP);
      }
      return;
      localObject1 = a((String)localObject2, 1);
      localObject2 = this.jdField_a_of_type_ArrayOfMep[n];
      GraphicRenderMgr.getInstance().setGlRender((String)localObject1, ((mep)localObject2).a());
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setGlRender[openSelfVideo], key[" + (String)localObject1 + "], index[" + n + "], forceToBigView[" + false + "], " + ((mep)localObject2).c());
    }
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
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130849824);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#5f656f"));
    this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130849825);
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
        lbj.c(this.jdField_a_of_type_JavaLangString, "SwitchLocalToBigView:" + bool3 + "|" + bool1);
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
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "changeLayoutMode, screenStyle[" + this.jdField_a_of_type_ComTencentAvVideoController.a().N + "->" + paramInt + "], ScreenLayout[" + this.jdField_a_of_type_Mjj.a() + "->" + paramInt + "], seq[" + l1 + "]");
    if ((b(this.jdField_a_of_type_ComTencentAvVideoController.a())) && (paramInt == 1)) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "changeLayoutMode with error happen", new Throwable());
    }
    super.g(paramInt);
    int n = this.jdField_a_of_type_Mjj.a();
    if (n != paramInt)
    {
      this.f = true;
      this.jdField_a_of_type_Mjj = mjj.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, false);
      if (i())
      {
        super.a(null);
        super.d(-15197410);
        new mcz(l1, "changeLayoutMode", 5, null).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        c(true);
        if ((n != 3) || (paramInt != 4)) {
          break label349;
        }
        n = 1;
      }
    }
    for (;;)
    {
      label232:
      if (n == 1)
      {
        float f1 = mvd.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
        float f2 = mvd.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
        n = 0;
        if (n < this.jdField_a_of_type_ArrayOfMep.length)
        {
          if (n == 0)
          {
            this.jdField_a_of_type_ArrayOfMep[n].g(false);
            this.jdField_a_of_type_ArrayOfMep[n].j(12);
            this.jdField_a_of_type_ArrayOfMep[n].a(f2);
          }
          for (;;)
          {
            this.jdField_a_of_type_ArrayOfMep[n].i();
            n += 1;
            break label263;
            B();
            a(Integer.valueOf(6501), null);
            break;
            if ((n == 4) && (paramInt == 3))
            {
              n = 2;
              break label232;
            }
            if (paramInt != 3) {
              break label543;
            }
            n = 3;
            break label232;
            this.jdField_a_of_type_ArrayOfMep[n].g(true);
            this.jdField_a_of_type_ArrayOfMep[n].j(12);
            this.jdField_a_of_type_ArrayOfMep[n].a(f1);
          }
        }
      }
      label263:
      label349:
      n = 0;
      if (n < this.jdField_a_of_type_ArrayOfMep.length)
      {
        this.jdField_a_of_type_ArrayOfMep[n].d(this.jdField_a_of_type_Mjj.b());
        mep localmep = this.jdField_a_of_type_ArrayOfMep[n];
        if (paramInt == 3) {}
        for (boolean bool = true;; bool = false)
        {
          localmep.e(bool);
          a(l1, this.jdField_a_of_type_ArrayOfMep[n]);
          n += 1;
          break;
        }
      }
      if ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity)) {
        ((AVActivity)this.jdField_a_of_type_AndroidContentContext).g(l1);
      }
      this.f = false;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) {
        i(paramInt);
      }
      return;
      label543:
      n = 0;
    }
  }
  
  public void g(long paramLong)
  {
    int n = a("closeSelfRender", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), 1);
    if (n >= 0) {
      b("closeSelfRender", n);
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
      if (n < this.jdField_a_of_type_ArrayOfMep.length)
      {
        mep localmep = this.jdField_a_of_type_ArrayOfMep[n];
        if ((localmep.a() == 0) && (str.equals(localmep.b()))) {
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
    this.jdField_a_of_type_Mjj.a(this.jdField_a_of_type_ArrayOfMep, paramInt, b(), c(), this.n, this.o);
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
    this.jdField_a_of_type_Mjs = new mjs(this.jdField_a_of_type_ComTencentAvVideoController);
  }
  
  protected void m(int paramInt) {}
  
  public void o() {}
  
  public void p()
  {
    if (this.jdField_a_of_type_Lci != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a.c();
      this.jdField_a_of_type_Lci = null;
    }
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
    if (this.jdField_a_of_type_Mpf != null)
    {
      if ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity))
      {
        localObject = (AVActivity)this.jdField_a_of_type_AndroidContentContext;
        this.jdField_a_of_type_Mpf.b(((AVActivity)localObject).jdField_e_of_type_Boolean);
      }
      this.jdField_a_of_type_Mpf = null;
    }
    int n;
    if ((this.D == -1) || (this.D == 2) || (this.D == 1))
    {
      n = 1;
      if (n == 0) {
        if (this.jdField_a_of_type_Mjj.a() != 3) {
          break label318;
        }
      }
    }
    label318:
    for (Object localObject = "1";; localObject = "2")
    {
      bdll.b(null, "CliOper", "", "", "0X8009F5D", "0X8009F5D", 0, 0, (String)localObject, "", "", "");
      if (this.jdField_a_of_type_Mjj != null)
      {
        this.jdField_a_of_type_Mjj.a();
        this.jdField_a_of_type_Mjj = null;
      }
      D();
      if (this.jdField_a_of_type_Mmd != null) {
        this.jdField_a_of_type_Mmd.b();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      super.p();
      return;
      n = 0;
      break;
    }
  }
  
  public void q()
  {
    super.q();
    p(this.u);
  }
  
  public void r()
  {
    if (this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.onResume();
    }
  }
  
  protected void s()
  {
    this.jdField_l_of_type_Boolean = false;
    p(this.u);
  }
  
  void t()
  {
    int n = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0)) && (n == 2))
    {
      u();
      this.jdField_a_of_type_Mpf.a();
    }
  }
  
  void u()
  {
    if (this.jdField_a_of_type_Mpf == null) {
      this.jdField_a_of_type_Mpf = new mpf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI
 * JD-Core Version:    0.7.0.1
 */