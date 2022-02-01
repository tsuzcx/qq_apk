package com.tencent.av.ui;

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
import bdla;
import bhhr;
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
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import lbd;
import lbz;
import lcf;
import lcg;
import lcu;
import lfe;
import lgo;
import lix;
import ljc;
import lmn;
import lql;
import lqo;
import lrs;
import lsb;
import lsc;
import lsd;
import lsi;
import lsm;
import lsn;
import lsq;
import ltt;
import lzr;
import mbf;
import mcx;
import mdd;
import meu;
import mjo;
import mjy;
import mkq;
import mls;
import mlt;
import mlu;
import mlv;
import mlw;
import mlx;
import mly;
import mlz;
import mma;
import mmb;
import mmc;
import mmd;
import mme;
import mmg;
import mmj;
import mpl;
import mqq.os.MqqHandler;
import mrq;
import mtq;
import mvk;
import myi;
import mzh;
import mzi;
import nad;

public class VideoLayerUI
  extends VideoLayerUIBase
{
  private int A;
  private int B;
  private int C;
  private int D;
  private volatile int E = -1;
  private int F = -1;
  private int G = -1;
  private int H = -1;
  private int I;
  private int J;
  private int K;
  public long a;
  private DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
  public GestureDetector a;
  private ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public AVActivity.AnimationTrigger a;
  protected VideoLayerUI.MultiVideoOpenAnimation a;
  private RotateLayout jdField_a_of_type_ComTencentAvWidgetRotateLayout;
  private ArrayList<lsc> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ConcurrentHashMap<Long, mmg> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private lcg jdField_a_of_type_Lcg;
  private lql jdField_a_of_type_Lql;
  private lsi jdField_a_of_type_Lsi;
  private lsm jdField_a_of_type_Lsm;
  private ltt jdField_a_of_type_Ltt;
  private mkq jdField_a_of_type_Mkq = new mkq(this.jdField_a_of_type_AndroidContentContext, paramVideoAppInterface, this);
  private mma jdField_a_of_type_Mma;
  private mmd jdField_a_of_type_Mmd = new mmd(this);
  private mmj jdField_a_of_type_Mmj = new mmj(this.jdField_a_of_type_ComTencentAvVideoController, this);
  mpl jdField_a_of_type_Mpl;
  private GestureDetector jdField_b_of_type_AndroidViewGestureDetector;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ArrayList<Runnable> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private List<RecvMsg> jdField_b_of_type_JavaUtilList = new LinkedList();
  private lsd jdField_b_of_type_Lsd;
  private long jdField_c_of_type_Long = -1L;
  private Runnable jdField_c_of_type_JavaLangRunnable = new VideoLayerUI.NewMsgRunnable(this, null);
  boolean jdField_c_of_type_Boolean = false;
  private long jdField_d_of_type_Long;
  private Rect jdField_d_of_type_AndroidGraphicsRect = new Rect();
  private Runnable jdField_d_of_type_JavaLangRunnable = new VideoLayerUI.LastMsgRunnable(this, null);
  private Rect e;
  private final boolean f = true;
  private volatile boolean g;
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
  protected int n = 0;
  private final int w = MultiVideoCtrlLayerUIBase.b;
  private int x = -1;
  private int y = -1;
  private int z;
  
  public VideoLayerUI(VideoAppInterface paramVideoAppInterface, Context paramContext, View paramView)
  {
    super(paramVideoAppInterface, paramContext, paramView);
    this.jdField_j_of_type_Int = 144;
    this.jdField_k_of_type_Int = 144;
    this.jdField_l_of_type_Int = 4;
    this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_e_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_i_of_type_Boolean = true;
    this.jdField_a_of_type_Mjo = mjo.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1, false);
    this.jdField_a_of_type_Mzi = new mzi(false);
    this.jdField_a_of_type_Mzh = new mzh(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramContext);
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
    this.u = bhhr.a(this.jdField_a_of_type_AndroidContentContext).getInt("video_position", 3);
  }
  
  private void B()
  {
    int i2 = 2130841982;
    int i1 = i2;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      i1 = i2;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 1008) {
        i1 = 2130842142;
      }
    }
    this.jdField_a_of_type_ArrayOfMeu[0].a(mvk.a(this.jdField_a_of_type_AndroidContentContext, i1));
    super.a(mvk.a(this.jdField_a_of_type_AndroidContentContext, i1));
  }
  
  private void C()
  {
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(this.jdField_a_of_type_AndroidContentContext, new mmc(this));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new mlx(this));
    this.jdField_a_of_type_Lql = new lql(this.jdField_a_of_type_AndroidContentContext, new mly(this, null));
    this.jdField_b_of_type_Lsd = new mme(this.jdField_a_of_type_Mmd);
    a(this.jdField_b_of_type_Lsd);
    this.m = AIOUtils.dp2px(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  private void D()
  {
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.z = 0;
      this.A = 0;
      this.h = true;
      return;
    }
  }
  
  private void E()
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null)
    {
      this.jdField_a_of_type_ComTencentAvWidgetRotateLayout = ((RotateLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363116));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363125));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363127));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363126));
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources();
      this.I = ((int)localResources.getDimension(2131297806));
      this.J = ((int)localResources.getDimension(2131297807));
      int i1 = (int)(localResources.getDimension(2131296385) + localResources.getDimension(2131296452));
      int i2 = (int)(localResources.getDimension(2131296387) + localResources.getDimension(2131296454));
      int i3 = (int)(localResources.getDimension(2131296384) + localResources.getDimension(2131296451));
      float f1 = localResources.getDimension(2131296386);
      int i4 = (int)(localResources.getDimension(2131296453) + f1);
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i1, i2, i3, i4);
      this.jdField_b_of_type_AndroidWidgetTextView.setTag(Long.valueOf(0L));
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.I);
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(this.J);
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
    this.jdField_a_of_type_Mma = new mma(this, this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView);
    ViewCompat.setAccessibilityDelegate(this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView, this.jdField_a_of_type_Mma);
  }
  
  private void G()
  {
    if (this.jdField_a_of_type_Ltt == null) {
      this.jdField_a_of_type_Ltt = new ltt(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (AVActivity)this.jdField_a_of_type_AndroidContentContext);
    }
  }
  
  private void H()
  {
    if (this.jdField_a_of_type_Ltt != null)
    {
      this.jdField_a_of_type_Ltt.g();
      this.jdField_a_of_type_Ltt = null;
    }
  }
  
  private void I()
  {
    int i2 = this.D;
    int i1 = Math.max(0, i2 / (this.jdField_j_of_type_Int + this.jdField_l_of_type_Int));
    int i3 = this.jdField_j_of_type_Int;
    int i4 = this.jdField_l_of_type_Int;
    i2 = (int)Math.ceil((k() - ((i1 + 1) * (i3 + i4) - i2)) * 1.0F / (this.jdField_j_of_type_Int + this.jdField_l_of_type_Int));
    e(i1, Math.min(l() - 1, i2 + i1));
  }
  
  public static int a(String paramString, Context paramContext, int paramInt, boolean paramBoolean, Display paramDisplay)
  {
    if (paramBoolean)
    {
      int i1 = paramDisplay.getRotation();
      int i2 = (i1 * 90 + paramInt) % 360;
      CameraUtils.a(paramContext).b(true);
      if (QLog.isDevelopLevel()) {
        QLog.w(paramString, 1, "setRotation, rotation[" + paramInt + "], displayRotation[" + i1 + "], viewRotation[" + i2 + "]");
      }
      return i2;
    }
    CameraUtils.a(paramContext).b(false);
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
    Bitmap localBitmap = mvk.a(this.jdField_a_of_type_AndroidContentContext, 2130840576);
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
  
  private Bitmap a(mmg parammmg)
  {
    if (parammmg.jdField_a_of_type_Int == 0) {
      return this.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(parammmg.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().g), this.jdField_a_of_type_ComTencentAvVideoController.a().F, true, false);
    }
    return ((BitmapDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842161)).getBitmap();
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
    int i1 = paramCharSequence.length();
    QQText.EmoticonSpan[] arrayOfEmoticonSpan = (QQText.EmoticonSpan[])((QQText)paramCharSequence).getSpans(0, i1, QQText.EmoticonSpan.class);
    i1 = 0;
    int i3;
    for (int i2 = 0; i1 < arrayOfEmoticonSpan.length; i2 = i3)
    {
      Object localObject = arrayOfEmoticonSpan[i1];
      i3 = i2;
      if ((localObject instanceof QQText.EmoticonSpan))
      {
        int i4 = ((QQText)paramCharSequence).getSpanStart(localObject);
        int i5 = ((QQText)paramCharSequence).getSpanEnd(localObject);
        i3 = i2;
        if (((QQText.EmoticonSpan)localObject).emojiType == 2)
        {
          localObject = ((QQText.EmoticonSpan)localObject).getDescription();
          localStringBuffer.replace(i4 + i2, i5 + i2, (String)localObject);
          i3 = i2 + (((String)localObject).length() - (i5 - i4));
        }
      }
      i1 += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString, int paramInt)
  {
    return paramString + "_" + paramInt;
  }
  
  private String a(mmg parammmg)
  {
    if (parammmg.jdField_a_of_type_Int == 0)
    {
      parammmg = this.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(parammmg.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().g), this.jdField_a_of_type_ComTencentAvVideoController.a().F);
      return parammmg;
    }
    long l1 = parammmg.jdField_a_of_type_Long;
    if (parammmg.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null) {}
    for (AVPhoneUserInfo localAVPhoneUserInfo = parammmg.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;; localAVPhoneUserInfo = this.jdField_a_of_type_ComTencentAvVideoController.a(l1, this.jdField_a_of_type_ComTencentAvVideoController.a().f))
    {
      if ((localAVPhoneUserInfo == null) || (localAVPhoneUserInfo.telInfo.mobile == null)) {
        break label154;
      }
      parammmg.jdField_a_of_type_JavaLangString = localAVPhoneUserInfo.telInfo.mobile;
      String str = this.jdField_a_of_type_ComTencentAvVideoController.a(localAVPhoneUserInfo.telInfo.mobile);
      parammmg = str;
      if (str != null) {
        break;
      }
      return mtq.a(localAVPhoneUserInfo.telInfo.mobile, 4);
    }
    label154:
    if ((localAVPhoneUserInfo != null) && (QLog.isColorLevel())) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getMemmberName --> can not get Open Id. PhoneInfo = " + localAVPhoneUserInfo.toString());
    }
    return this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693004);
  }
  
  private void a(long paramLong, int paramInt)
  {
    int i1 = a("refreshMicState", String.valueOf(paramLong), 1);
    if (i1 != -1) {
      this.jdField_a_of_type_ArrayOfMeu[i1].h(paramInt);
    }
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    paramView = paramView.findViewById(2131363133);
    if ((paramBoolean) && (!VideoController.a().r())) {}
    for (int i1 = 1; i1 != 0; i1 = 0)
    {
      paramView.setVisibility(0);
      return;
    }
    paramView.setVisibility(8);
  }
  
  private void a(lqo paramlqo, lsc paramlsc, boolean paramBoolean)
  {
    int i3 = 1;
    int i1;
    if ((paramlsc.a()) || (paramlsc.b()))
    {
      i1 = 1;
      if ((paramlsc.b().left - this.z <= this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels) && (paramlsc.b().right - this.z >= 0)) {
        break label90;
      }
      i2 = 1;
      label60:
      if ((i2 == 0) || (paramBoolean)) {
        break label96;
      }
    }
    label90:
    label96:
    for (int i2 = i3;; i2 = 0)
    {
      if ((i1 != 0) && (i2 == 0)) {
        break label102;
      }
      return;
      i1 = 0;
      break;
      i2 = 0;
      break label60;
    }
    label102:
    paramlqo.a(0, 0);
    paramlsc.a(paramlqo);
    paramlqo.a(-0, -0);
  }
  
  private void a(meu parammeu, float paramFloat, long paramLong)
  {
    paramLong /= 10L;
    a(new VideoLayerUI.10(this, paramLong, parammeu, (float)Math.pow(paramFloat, 1.0D / paramLong)));
  }
  
  private void a(meu parammeu, boolean paramBoolean)
  {
    lsn locallsn = new lsn();
    locallsn.b(50);
    locallsn.b(0.0F, 0.0F, 0.0F, 90.0F, 0.0F, 0.0F);
    locallsn.a(new mls(this, parammeu, paramBoolean));
    locallsn.a(1);
    parammeu.a(locallsn);
    parammeu.b();
  }
  
  private void a(boolean paramBoolean, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0))
    {
      u();
      Object localObject = this.jdField_a_of_type_Mpl.a();
      if (localObject != null)
      {
        localObject = ((ZimuItem)localObject).getId();
        int i1 = 1;
        if (!paramBoolean) {
          i1 = 4;
        }
        new mdd(paramLong, "showLastZimu", i1, (String)localObject).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
    }
  }
  
  private boolean a(CharSequence paramCharSequence)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i1;
    if ((paramCharSequence instanceof QQText))
    {
      paramCharSequence = (QQText.EmoticonSpan[])((QQText)paramCharSequence).getSpans(0, paramCharSequence.length(), QQText.EmoticonSpan.class);
      i1 = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i1 < paramCharSequence.length)
      {
        if (paramCharSequence[i1].emojiType == 2) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  private mmg b(long paramLong)
  {
    mmg localmmg2 = (mmg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    mmg localmmg1 = localmmg2;
    if (localmmg2 == null)
    {
      localmmg1 = new mmg();
      localmmg1.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), localmmg1);
    }
    return localmmg1;
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if ((this.D == paramInt) && (!paramBoolean)) {
      return;
    }
    this.D = paramInt;
    I();
  }
  
  private void b(long paramLong, meu parammeu, String paramString, int paramInt, boolean paramBoolean)
  {
    if (parammeu != null)
    {
      a(paramString, paramInt);
      parammeu.a(paramString, paramInt);
      parammeu.a(0);
      parammeu.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
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
      q(this.v);
      i(true);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
    } while ((paramRecvMsg == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null));
    Object localObject = new QQText(paramRecvMsg, 11);
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
    int i5 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    int i2;
    float f1;
    int i1;
    boolean bool;
    if (paramInt == 0)
    {
      i2 = this.jdField_a_of_type_ArrayOfMeu[0].f();
      f1 = this.jdField_a_of_type_ArrayOfMeu[0].d();
      i1 = this.jdField_a_of_type_ArrayOfMeu[0].g();
      bool = this.jdField_a_of_type_ArrayOfMeu[0].i();
      if (i5 == 4) {
        paramString = this.jdField_a_of_type_ArrayOfMeu[0].a();
      }
    }
    for (;;)
    {
      int i3;
      int i4;
      if ((i5 == 4) && (this.jdField_a_of_type_Mjo.a() == 3))
      {
        i3 = 1;
        if (Build.VERSION.SDK_INT < 21) {
          break label214;
        }
        i4 = 1;
      }
      label154:
      label214:
      int i6;
      meu localmeu;
      for (;;)
      {
        if ((i3 != 0) && (i4 != 0))
        {
          i3 = -1;
          i4 = paramInt + 1;
          for (;;)
          {
            if (i4 < this.jdField_a_of_type_ArrayOfMeu.length)
            {
              if (this.jdField_a_of_type_ArrayOfMeu[i4].a() == 0) {
                i3 = i4;
              }
              i4 += 1;
              continue;
              i3 = 0;
              break;
              i4 = 0;
              break label154;
            }
          }
          if (i3 != -1)
          {
            i4 = this.jdField_a_of_type_ArrayOfMeu[paramInt].d();
            i6 = this.jdField_a_of_type_ArrayOfMeu[i3].d();
            this.jdField_a_of_type_ArrayOfMeu[paramInt].c(i6);
            this.jdField_a_of_type_ArrayOfMeu[i3].c(i4);
            localmeu = this.jdField_a_of_type_ArrayOfMeu[paramInt];
            this.jdField_a_of_type_ArrayOfMeu[paramInt] = this.jdField_a_of_type_ArrayOfMeu[i3];
            this.jdField_a_of_type_ArrayOfMeu[i3] = localmeu;
            localmeu.a("");
            localmeu = this.jdField_a_of_type_ArrayOfMeu[i3];
            localmeu.a(1);
            localmeu.b(null);
            localmeu.m(true);
            localmeu.k(false);
            localmeu.g(false);
            localmeu.l(true);
            localmeu.a(null, 0);
            label362:
            if (paramInt == 0)
            {
              this.jdField_a_of_type_ArrayOfMeu[0].h(false);
              this.jdField_a_of_type_ArrayOfMeu[0].k(i2);
              this.jdField_a_of_type_ArrayOfMeu[0].a(f1);
              this.jdField_a_of_type_ArrayOfMeu[0].j(i1);
              this.jdField_a_of_type_ArrayOfMeu[0].j(bool);
              if (i5 == 4)
              {
                if (this.jdField_a_of_type_ArrayOfMeu[0].h() != 2) {
                  break label662;
                }
                this.jdField_a_of_type_ArrayOfMeu[0].a(ImageView.ScaleType.CENTER_INSIDE);
              }
            }
          }
        }
      }
      for (;;)
      {
        c(false);
        return;
        i3 = paramInt;
        break;
        i3 = paramInt;
        while (i3 < this.jdField_a_of_type_ArrayOfMeu.length)
        {
          if ((i3 >= this.jdField_a_of_type_ArrayOfMeu.length - 1) || (this.jdField_a_of_type_ArrayOfMeu[(i3 + 1)].a() != 0)) {
            break label599;
          }
          i4 = this.jdField_a_of_type_ArrayOfMeu[i3].d();
          i6 = this.jdField_a_of_type_ArrayOfMeu[(i3 + 1)].d();
          this.jdField_a_of_type_ArrayOfMeu[i3].c(i6);
          this.jdField_a_of_type_ArrayOfMeu[(i3 + 1)].c(i4);
          localmeu = this.jdField_a_of_type_ArrayOfMeu[i3];
          this.jdField_a_of_type_ArrayOfMeu[i3] = this.jdField_a_of_type_ArrayOfMeu[(i3 + 1)];
          this.jdField_a_of_type_ArrayOfMeu[(i3 + 1)] = localmeu;
          i3 += 1;
        }
        break label362;
        label599:
        localmeu = this.jdField_a_of_type_ArrayOfMeu[i3];
        localmeu.a(1);
        localmeu.b(null);
        localmeu.m(true);
        localmeu.k(false);
        localmeu.g(false);
        localmeu.l(true);
        localmeu.a(null, 0);
        localmeu.a("");
        break label362;
        label662:
        this.jdField_a_of_type_ArrayOfMeu[0].a(paramString);
      }
      continue;
      f1 = 0.0F;
      i2 = 0;
      i1 = 0;
      bool = false;
    }
  }
  
  private void b(meu parammeu, boolean paramBoolean)
  {
    lsn locallsn = new lsn();
    locallsn.b(50);
    locallsn.b(0.0F, 0.0F, -90.0F, 0.0F, 0.0F, 0.0F);
    locallsn.a(2);
    locallsn.a(new mlt(this));
    parammeu.a(locallsn);
    parammeu.b();
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_d_of_type_Long != 0L) && (System.currentTimeMillis() - this.jdField_d_of_type_Long < 1000L))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "bigWindowToSmallWindowAnim, 大小窗正在切换中[" + this.jdField_d_of_type_Long + "]");
      return false;
    }
    meu localmeu = this.jdField_a_of_type_ArrayOfMeu[paramInt2];
    localmeu.a(Boolean.valueOf(false));
    localmeu.a(0, 0, 0, 0);
    int i1 = localmeu.d();
    localmeu.c(1);
    float f1 = localmeu.b().left;
    float f2 = localmeu.b().top;
    Rect localRect = super.a();
    lsn locallsn = new lsn();
    locallsn.b(100);
    locallsn.a(f1, f2, 0.0F, -localRect.left, -localRect.top, 0.0F);
    locallsn.a(localmeu.b().width(), localmeu.b().height(), super.b() + localRect.left + localRect.right, super.c() + localRect.top + localRect.bottom);
    locallsn.a(new mlv(this, paramInt2, i1, paramInt1));
    locallsn.a(2);
    localmeu.a(locallsn);
    localmeu.b();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    return true;
  }
  
  private void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
    paramInt3 = paramInt1 + this.jdField_l_of_type_Int;
    paramInt4 = this.jdField_j_of_type_Int;
    paramInt1 = paramInt3;
    paramInt3 += paramInt4;
    int i1 = 1;
    paramInt4 = paramInt1;
    paramInt1 = i1;
    while (paramInt1 <= i2)
    {
      ((lsc)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1 - 1)).b(paramInt4, paramInt2, paramInt3, this.jdField_k_of_type_Int + paramInt2);
      paramInt4 += this.jdField_j_of_type_Int + this.jdField_l_of_type_Int;
      paramInt3 = paramInt4 + this.jdField_j_of_type_Int;
      paramInt1 += 1;
    }
    this.E = ((this.jdField_j_of_type_Int + this.jdField_l_of_type_Int) * i2 + this.jdField_l_of_type_Int);
  }
  
  private void c(int paramInt, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramInt == this.z)) {
      return;
    }
    this.z = paramInt;
    paramInt = m();
    if ((this.z > paramInt) && (this.jdField_a_of_type_Lsm.a()))
    {
      this.jdField_a_of_type_Lsm.b(this.z);
      this.z = paramInt;
    }
    b(this.z, paramBoolean);
    n(this.z);
  }
  
  private boolean c(int paramInt1, int paramInt2)
  {
    if ((this.jdField_d_of_type_Long != 0L) && (System.currentTimeMillis() - this.jdField_d_of_type_Long < 1000L))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "bigWindowToSmallWindowAnim, 大小窗正在切换中[" + this.jdField_d_of_type_Long + "]");
      return false;
    }
    Object localObject = this.jdField_a_of_type_ArrayOfMeu[paramInt1];
    meu localmeu = this.jdField_a_of_type_ArrayOfMeu[paramInt2];
    ((meu)localObject).a(Boolean.valueOf(false));
    ((meu)localObject).a(0, 0, 0, 0);
    localmeu.a(Boolean.valueOf(false));
    localmeu.a(0, 0, 0, 0);
    int i1 = localmeu.d();
    localmeu.c(((meu)localObject).d());
    Rect localRect = localmeu.b();
    localObject = ((meu)localObject).b();
    lsn locallsn = new lsn();
    locallsn.b(300);
    locallsn.a(localRect.left, localRect.top, 0.0F, ((Rect)localObject).left, ((Rect)localObject).top, 0.0F);
    locallsn.a(localRect.width(), localRect.height(), ((Rect)localObject).width(), ((Rect)localObject).height());
    locallsn.a(new mlw(this, paramInt2, i1, paramInt1));
    locallsn.a(2);
    localmeu.a(locallsn);
    localmeu.b();
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
    meu localmeu = this.jdField_a_of_type_ArrayOfMeu[paramInt2];
    localmeu.a(Boolean.valueOf(false));
    localmeu.a(0, 0, 0, 0);
    b(new VideoLayerUI.9(this, paramInt1, paramInt2));
    b();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    return true;
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == this.B) && (paramInt2 == this.C)) {}
    for (;;)
    {
      return;
      if (paramInt1 < paramInt2)
      {
        this.B = paramInt1;
        this.C = paramInt2;
      }
      while (this.jdField_a_of_type_Lsi != null)
      {
        this.jdField_a_of_type_Lsi.a(this.B, this.C);
        return;
        this.C = 0;
        this.B = 0;
      }
    }
  }
  
  private void g(lqo paramlqo)
  {
    int i1;
    int i2;
    int i4;
    int i3;
    if (paramlqo.a() > paramlqo.b())
    {
      i1 = 1;
      i2 = AIOUtils.dp2px(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      i4 = nad.a(this.jdField_a_of_type_AndroidContentContext);
      i3 = b() / 2;
      if (i1 == 0) {
        break label116;
      }
      i2 = c() / 2;
      label59:
      paramlqo.a(i3, i2, 0.0F);
      if (i1 == 0) {
        break label130;
      }
      paramlqo.a(0.0F, 0.0F, b(), c(), -16777216);
    }
    for (;;)
    {
      paramlqo.a(-i3, -i2, 0.0F);
      return;
      i1 = 0;
      break;
      label116:
      i2 = i2 + i4 + nad.a() / 2;
      break label59;
      label130:
      paramlqo.a(0.0F, 0.0F, b(), nad.a() + 2, -16777216);
    }
  }
  
  private void h(lqo arg1)
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
  
  private void h(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ArrayOfMeu[0] != null) && (this.jdField_a_of_type_ArrayOfMeu[1] != null))
    {
      this.jdField_a_of_type_ArrayOfMeu[0].e(paramBoolean);
      this.jdField_a_of_type_ArrayOfMeu[1].e(paramBoolean);
    }
  }
  
  private void i(long paramLong)
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (!this.jdField_c_of_type_Boolean)) {
      ((AVActivity)this.jdField_a_of_type_AndroidContentContext).a.D(paramLong);
    }
  }
  
  private void i(lqo paramlqo)
  {
    h(paramlqo);
    long l1 = lsb.a();
    boolean bool1 = this.jdField_a_of_type_Lsm.a(l1);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    int i3 = 1;
    int i1 = 1;
    Object localObject1;
    int i6;
    int i5;
    int i2;
    for (;;)
    {
      try
      {
        localObject1 = (meu)a(0);
        l1 = Long.parseLong(((meu)localObject1).c());
        i6 = ((meu)localObject1).h();
        localObject1 = a();
        if ((localObject1 != null) && (!(((AVActivity)localObject1).a instanceof DoubleVideoMeetingCtrlUI)))
        {
          localObject1 = this.jdField_a_of_type_Mmj.a(false);
          if (!this.jdField_i_of_type_Boolean) {
            break label1307;
          }
          this.jdField_a_of_type_Mkq.a((ArrayList)localObject1);
          if (((ArrayList)localObject1).size() <= this.w) {
            break label674;
          }
          i4 = 1;
          i5 = 1;
          if ((i5 < ((ArrayList)localObject1).size()) && ((this.jdField_a_of_type_JavaUtilArrayList.size() != this.w - 2) || (i4 == 0))) {
            break;
          }
          i2 = i1;
          if (i4 != 0)
          {
            this.jdField_a_of_type_Meu.b(((ArrayList)localObject1).size() - this.w + 1 + "+");
            if (!((Boolean)this.jdField_a_of_type_Meu.a(2)).booleanValue()) {
              break label1290;
            }
            this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Meu);
            i2 = i1;
          }
          label233:
          if ((i2 >= 2) && (mvk.a(2))) {
            ThreadManager.getUIHandler().post(new VideoLayerUI.3(this));
          }
          paramlqo.a(b() / 2, c() / 2, 0.0F);
          c(paramlqo);
          paramlqo.a(-b() / 2, -c() / 2, 0.0F);
          i2 = a("renderSliderWindowStyle", String.valueOf(((mmg)((ArrayList)localObject1).get(0)).jdField_a_of_type_Long), ((mmg)((ArrayList)localObject1).get(0)).b());
          i1 = i2;
          if (i2 == -1) {
            i1 = 0;
          }
          localObject2 = this.jdField_a_of_type_ArrayOfMeu[i1];
          if (!((mmg)((ArrayList)localObject1).get(0)).e()) {
            break label1361;
          }
          i1 = 1;
          label378:
          i2 = i1;
          if (i1 == 0)
          {
            if (!((mmg)((ArrayList)localObject1).get(0)).d()) {
              break label1366;
            }
            i2 = 2;
          }
          label401:
          ((meu)localObject2).h(i2);
          ((meu)localObject2).h(false);
          ((meu)localObject2).a(0, 0, 0, 0);
          ((meu)localObject2).b(0, 0, super.b(), super.c());
          a(paramlqo, (lsc)localObject2, true);
          if ((!((meu)localObject2).a()) && (QLog.isDevelopLevel())) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 1, "error happen big screen can not render with Uin:=" + ((meu)localObject2).c() + ",srcType:=" + ((meu)localObject2).h());
          }
          c(this.jdField_e_of_type_AndroidGraphicsRect.left, this.jdField_e_of_type_AndroidGraphicsRect.top, this.jdField_e_of_type_AndroidGraphicsRect.right, this.jdField_e_of_type_AndroidGraphicsRect.bottom);
          c(this.jdField_a_of_type_Lsm.a(), this.h);
          if (this.h) {
            this.h = false;
          }
          paramlqo.a(-this.z, -this.A);
          i1 = 0;
          if (i1 >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
            break label1371;
          }
          a(paramlqo, (lsc)this.jdField_a_of_type_JavaUtilArrayList.get(i1), false);
          i1 += 1;
          continue;
          return;
        }
      }
      catch (NumberFormatException paramlqo)
      {
        paramlqo.printStackTrace();
      }
      label624:
      localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.c();
      this.jdField_a_of_type_Mmj.a((ArrayList)localObject1);
      localObject1 = this.jdField_a_of_type_Mmj.a(true);
      if (((ArrayList)localObject1).size() == 0) {
        QLog.d("GLLinearLayout", 1, "videoMemmberInfos size is zero");
      }
      continue;
      label674:
      int i4 = 0;
    }
    Object localObject2 = (mmg)((ArrayList)localObject1).get(i5);
    long l2 = ((mmg)localObject2).a();
    i3 = ((mmg)localObject2).b();
    ((mmg)localObject2).a();
    boolean bool2 = ((mmg)localObject2).jdField_a_of_type_Boolean;
    boolean bool3 = ((mmg)localObject2).c();
    ((mmg)localObject2).d();
    Object localObject3;
    if (bool3)
    {
      i2 = i1;
      if (l2 == l1)
      {
        i2 = i1;
        if (i3 == i6)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 1, "arraysToList3 bigindex index:=" + i5);
          }
          i2 = i1 + 1;
        }
      }
      int i7 = a("renderSliderWindowStyle", String.valueOf(l2), i3);
      if (i7 != -1)
      {
        localObject3 = this.jdField_a_of_type_ArrayOfMeu[i7];
        if (((mmg)localObject2).e())
        {
          i1 = 1;
          label836:
          i3 = i1;
          if (i1 == 0)
          {
            if (!((mmg)localObject2).d()) {
              break label1108;
            }
            i3 = 2;
          }
          label854:
          ((meu)localObject3).h(i3);
          if (TextUtils.isEmpty(((meu)localObject3).b()))
          {
            ((meu)localObject3).b(a((mmg)localObject2));
            ((meu)localObject3).j(true);
          }
          ((meu)localObject3).j(12);
          ((meu)localObject3).a(mvk.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
          ((meu)localObject3).h(true);
          this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ArrayOfMeu[i7]);
          i1 = i2 + 1;
          i2 = 1;
        }
      }
    }
    for (;;)
    {
      label938:
      meu localmeu;
      if (((!bool3) && (bool2)) || (i2 == 0))
      {
        localmeu = this.jdField_a_of_type_Mkq.a(l2);
        localmeu.b(false);
        localmeu.h(true);
        if (((mmg)localObject2).e())
        {
          i2 = 1;
          label985:
          i3 = i2;
          if (i2 == 0)
          {
            if (!((mmg)localObject2).d()) {
              break label1126;
            }
            i3 = 2;
          }
          label1003:
          localmeu.h(i3);
          if (((Boolean)localmeu.a(2)).booleanValue()) {
            break label1132;
          }
          localmeu.b(a((mmg)localObject2));
          localmeu.j(true);
          localObject3 = a((mmg)localObject2);
          localObject2 = localObject3;
          if (Build.VERSION.SDK_INT == 23) {
            localObject2 = a((Bitmap)localObject3);
          }
          localObject2 = new lrs((Bitmap)localObject2);
          ((lrs)localObject2).b(paramlqo);
          localmeu.a((lrs)localObject2);
        }
      }
      for (;;)
      {
        i5 += 1;
        break;
        i1 = 0;
        break label836;
        label1108:
        i3 = 3;
        break label854;
        i1 = i2;
        i2 = 0;
        break label938;
        i2 = 0;
        break label985;
        label1126:
        i3 = 3;
        break label1003;
        label1132:
        this.jdField_a_of_type_JavaUtilArrayList.add(localmeu);
        continue;
        if (!bool2)
        {
          localmeu = this.jdField_a_of_type_Mkq.a(l2);
          localmeu.b(true);
          localmeu.g(Color.parseColor("#4C000000"));
          localmeu.h(-1);
          localmeu.h(true);
          if (!((Boolean)localmeu.a(2)).booleanValue())
          {
            localmeu.b(a((mmg)localObject2));
            localmeu.j(true);
            localObject3 = a((mmg)localObject2);
            localObject2 = localObject3;
            if (Build.VERSION.SDK_INT == 23) {
              localObject2 = a((Bitmap)localObject3);
            }
            localObject2 = new lrs((Bitmap)localObject2);
            ((lrs)localObject2).b(paramlqo);
            localmeu.a((lrs)localObject2);
          }
          else
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(localmeu);
          }
        }
      }
      label1290:
      this.jdField_a_of_type_Meu.a(2, Boolean.valueOf(true));
      i2 = i1;
      break label233;
      label1307:
      i1 = 0;
      i2 = i3;
      if (i1 >= this.jdField_a_of_type_ArrayOfMeu.length) {
        break label233;
      }
      localObject2 = this.jdField_a_of_type_ArrayOfMeu[i1];
      if (!((lsc)localObject2).a()) {}
      for (;;)
      {
        i1 += 1;
        break;
        if (i1 != 0) {
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        }
      }
      label1361:
      i1 = 0;
      break label378;
      label1366:
      i2 = 3;
      break label401;
      label1371:
      paramlqo.a(this.z, this.A);
      if (!(false | bool1)) {
        break label624;
      }
      b();
      return;
      i2 = 1;
    }
  }
  
  private void i(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showMsgbox: show = " + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {}
    do
    {
      return;
      localObject = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources();
      int i1 = (int)(((Resources)localObject).getDimension(2131296385) + ((Resources)localObject).getDimension(2131296452));
      int i2 = (int)(((Resources)localObject).getDimension(2131296387) + ((Resources)localObject).getDimension(2131296454));
      int i3 = (int)(((Resources)localObject).getDimension(2131296384) + ((Resources)localObject).getDimension(2131296451));
      f1 = ((Resources)localObject).getDimension(2131296386);
      int i4 = (int)(((Resources)localObject).getDimension(2131296453) + f1);
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i1, i2, i3, i4);
      this.jdField_b_of_type_AndroidWidgetTextView.getBackground().setAlpha(128);
      if ((this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.isShown()) && (!paramBoolean))
      {
        localObject = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject).setDuration(1000L);
        ((AlphaAnimation)localObject).setFillAfter(true);
        ((AlphaAnimation)localObject).setAnimationListener(new mlz(this, null));
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
  
  private int j()
  {
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < this.jdField_a_of_type_ArrayOfMeu.length; i2 = i3)
    {
      meu localmeu = this.jdField_a_of_type_ArrayOfMeu[i1];
      String str = localmeu.c();
      i3 = i2;
      if (localmeu.a() == 0)
      {
        i3 = i2;
        if (!TextUtils.isEmpty(str)) {
          i3 = i2 + 1;
        }
      }
      i1 += 1;
    }
    return i2;
  }
  
  private int k()
  {
    return this.jdField_d_of_type_AndroidGraphicsRect.right - this.jdField_d_of_type_AndroidGraphicsRect.left;
  }
  
  private int l()
  {
    return j();
  }
  
  private int m()
  {
    int i2 = this.E - k();
    int i1 = i2;
    if (i2 <= 0) {
      i1 = 0;
    }
    return i1;
  }
  
  private boolean o()
  {
    return (this.jdField_a_of_type_Mjo != null) && (this.jdField_a_of_type_Mjo.a() == 4) && (!this.g);
  }
  
  private boolean p()
  {
    return (this.jdField_a_of_type_Mjo != null) && (this.jdField_a_of_type_Mjo.a() == 1) && (!this.g) && (this.jdField_a_of_type_Mjo.a());
  }
  
  private void q(int paramInt)
  {
    if ((this.jdField_l_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getLayoutParams();
    int i4 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131299178);
    int i3 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131299179);
    int i5 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131299173);
    int i2 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131299174);
    int i6 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131299172);
    if ((this.p == 0) || (this.o == 0))
    {
      i2 = i5;
      i3 = i4;
    }
    int i7 = j();
    Object localObject1;
    int i1;
    label270:
    label495:
    Object localObject2;
    if (i7 <= 0)
    {
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(10, 0);
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(12, -1);
      localLayoutParams.leftMargin = i5;
      localLayoutParams.bottomMargin = (i2 + this.p);
      this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setLayoutParams(localLayoutParams);
      localObject1 = (RotateLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      ((RotateLayout.LayoutParams)localObject1).jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      i2 = this.jdField_a_of_type_AndroidViewView.getWidth() - i5 * 2;
      i1 = i2;
      if (i2 > this.J) {
        i1 = this.J;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(i1);
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setMsgboxLayout, orientation[" + paramInt + "], leftMargin[" + localLayoutParams.leftMargin + "], topMargin[" + localLayoutParams.topMargin + "], rightMargin[" + localLayoutParams.rightMargin + "], bottomMargin[" + localLayoutParams.bottomMargin + "], mMsgLayout[" + this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getWidth() + ", " + this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getHeight() + "]");
      }
    }
    else
    {
      i1 = paramInt;
      if (this.p != 0)
      {
        i1 = paramInt;
        if (this.o != 0) {
          i1 = 0;
        }
      }
      localObject1 = this.jdField_a_of_type_ArrayOfMeu[1].b();
      paramInt = i();
      if (i1 != 0) {
        break label761;
      }
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(10, 0);
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(12, -1);
      if (i7 != 1) {
        break label683;
      }
      localLayoutParams.leftMargin = i5;
      localLayoutParams.bottomMargin = (i2 + this.p);
      localLayoutParams.bottomMargin += this.K;
      this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setLayoutParams(localLayoutParams);
      if (QLog.isDevelopLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 4, "setLayoutParams, [" + localLayoutParams.leftMargin + ", " + localLayoutParams.topMargin + ", " + localLayoutParams.rightMargin + ", " + localLayoutParams.bottomMargin + "]");
      }
      localObject2 = (RotateLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      ((RotateLayout.LayoutParams)localObject2).jdField_a_of_type_Int = i1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = super.b();
      if (i7 != 1) {
        break label1167;
      }
    }
    label1167:
    for (paramInt = ((Rect)localObject2).width() - i5 * 2;; paramInt = ((Rect)localObject2).width() - ((Rect)localObject1).width() - i4 - i5 - i6)
    {
      i2 = paramInt;
      if (paramInt > this.J) {
        i2 = this.J;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(i2);
      paramInt = i1;
      break label270;
      break;
      label683:
      if (i7 == 2)
      {
        if (paramInt == 4) {}
        for (localLayoutParams.leftMargin = (((Rect)localObject1).width() + i4 + i6);; localLayoutParams.leftMargin = i5)
        {
          localLayoutParams.bottomMargin = (i2 + this.p);
          break;
        }
      }
      localLayoutParams.leftMargin = i5;
      localLayoutParams.bottomMargin = (i2 + this.p + ((Rect)localObject1).height());
      break label495;
      label761:
      if (i1 == 90)
      {
        localLayoutParams.addRule(10, 0);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.addRule(11, -1);
        localLayoutParams.addRule(12, -1);
        if (i7 == 1)
        {
          localLayoutParams.rightMargin = i5;
          localLayoutParams.bottomMargin = (i2 + this.p);
          break label495;
        }
        if (i7 < 2) {
          break label495;
        }
        if (paramInt == 3) {}
        for (localLayoutParams.bottomMargin = (((Rect)localObject1).height() + i3 + i6 + this.p);; localLayoutParams.bottomMargin = (i2 + this.p))
        {
          localLayoutParams.rightMargin = i5;
          break;
        }
      }
      if (i1 == 180)
      {
        localLayoutParams.addRule(9, 0);
        localLayoutParams.addRule(12, 0);
        localLayoutParams.addRule(11, -1);
        localLayoutParams.addRule(10, -1);
        if (i7 == 1)
        {
          localLayoutParams.rightMargin = i5;
          localLayoutParams.topMargin = (i2 + this.o);
          break label495;
        }
        if (i7 == 2)
        {
          if (paramInt == 2) {}
          for (localLayoutParams.rightMargin = (((Rect)localObject1).width() + i4 + i6);; localLayoutParams.rightMargin = i5)
          {
            localLayoutParams.topMargin = (i2 + this.o);
            break;
          }
        }
        localLayoutParams.rightMargin = i5;
        if (paramInt == 2)
        {
          localLayoutParams.topMargin = (i2 + this.o + ((Rect)localObject1).height());
          break label495;
        }
        localLayoutParams.topMargin = (i2 + this.o);
        break label495;
      }
      if (i1 != 270) {
        break label495;
      }
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(12, 0);
      localLayoutParams.addRule(10, -1);
      localLayoutParams.addRule(9, -1);
      if (i7 == 1)
      {
        localLayoutParams.leftMargin = i5;
        localLayoutParams.topMargin = (i2 + this.o);
        break label495;
      }
      if (i7 < 2) {
        break label495;
      }
      if (paramInt == 1) {}
      for (localLayoutParams.topMargin = (((Rect)localObject1).height() + i3 + i6 + this.o);; localLayoutParams.topMargin = (i2 + this.o))
      {
        localLayoutParams.leftMargin = i5;
        break;
      }
    }
  }
  
  private boolean q()
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
  
  private void r(int paramInt)
  {
    if (paramInt > 0)
    {
      int i1 = 0;
      if (paramInt == 2) {
        i1 = 2131695236;
      }
      if ((i1 != 0) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
        mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1008, i1);
      }
    }
  }
  
  private void z()
  {
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
    ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindowManager().getDefaultDisplay().getRealMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
    this.jdField_l_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297890);
    this.jdField_j_of_type_Int = ((this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels - this.jdField_l_of_type_Int * 5) / 4);
    this.jdField_k_of_type_Int = this.jdField_j_of_type_Int;
    int i1 = this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels;
    i1 = this.jdField_j_of_type_Int;
    i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299179);
    this.jdField_d_of_type_AndroidGraphicsRect = new Rect(0, this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels - i1 - this.jdField_k_of_type_Int, this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels, this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels - i1);
    this.jdField_b_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new mmb(this, null));
    this.jdField_a_of_type_Lsm = new lsm(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Lsm.a(true);
    this.jdField_a_of_type_Lsm.a((int)mvk.a(this.jdField_a_of_type_AndroidContentContext, 50.0F));
    this.jdField_a_of_type_Meu = new meu(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, String.format("%s_%s", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(1000) }), this.jdField_a_of_type_ComTencentAvVideoController.g());
    this.jdField_a_of_type_Meu.a(1);
    this.jdField_a_of_type_Meu.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_Meu.a("null", 1);
    this.jdField_a_of_type_Meu.a(true);
    this.jdField_a_of_type_Meu.d(false);
    this.jdField_a_of_type_Meu.h(false);
    this.jdField_a_of_type_Meu.i(true);
    i1 = AIOUtils.dp2px(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_Meu.a(i1);
    this.jdField_a_of_type_Meu.j(true);
    this.jdField_a_of_type_Meu.d(Color.parseColor("#686E6C"));
    this.jdField_a_of_type_Meu.a(2, Boolean.valueOf(false));
    this.jdField_a_of_type_Meu.c(999);
    a(this.jdField_a_of_type_Meu);
  }
  
  public int a(float paramFloat)
  {
    int i1 = Math.round(paramFloat) + this.D;
    if (i1 < 0) {
      return -1;
    }
    return i1 / (this.jdField_j_of_type_Int + this.jdField_l_of_type_Int);
  }
  
  public AVActivity a()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity)) {
      return (AVActivity)this.jdField_a_of_type_AndroidContentContext;
    }
    return null;
  }
  
  public mmg a(long paramLong)
  {
    return (mmg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
  }
  
  public myi a()
  {
    return this.jdField_a_of_type_Mzi;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (p()) {
      this.jdField_a_of_type_Mzi.a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    if ((!this.jdField_d_of_type_Boolean) && (!l())) {
      this.t = paramInt;
    }
    for (;;)
    {
      return;
      if ((paramInt != this.s) || (paramInt == this.t))
      {
        if (paramInt % 90 != this.s % 90) {
          this.q = 0;
        }
        this.s = paramInt;
        this.t = paramInt;
        int i1 = a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentContext, paramInt, paramBoolean, this.jdField_a_of_type_AndroidViewDisplay);
        switch (paramInt)
        {
        }
        while (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 2)
        {
          if (this.v != 0)
          {
            paramBoolean = bool;
            if (this.v != 180) {}
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
            super.a(paramInt).b(i1);
            paramInt += 1;
          }
          q(i1);
          this.v = i1;
        }
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i2 = 0;
    int i1 = 0;
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "notifyControlUIOffset, mTopOffset[" + this.o + "->" + paramInt1 + "], mBottomOffset[" + this.p + "->" + paramInt2 + "], mFullScreen[" + this.jdField_c_of_type_Boolean + "->" + paramBoolean + "], seq[" + paramLong + "]");
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.o = paramInt1;
    this.p = paramInt2;
    c(true);
    q(this.v);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
    {
      paramInt1 = i2;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().J)
      {
        paramInt1 = i1;
        while (paramInt1 < this.jdField_a_of_type_ArrayOfMeu.length)
        {
          this.jdField_a_of_type_ArrayOfMeu[paramInt1].j(true);
          paramInt1 += 1;
        }
      }
      while (paramInt1 < this.jdField_a_of_type_ArrayOfMeu.length)
      {
        this.jdField_a_of_type_ArrayOfMeu[paramInt1].j(true);
        paramInt1 += 1;
      }
    }
    if (this.jdField_a_of_type_Mpl != null) {
      this.jdField_a_of_type_Mpl.a(this, this.o, this.p);
    }
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    this.G = a("notifyGLVideoViewChange", String.valueOf(paramLong1), paramInt1);
    this.H = a("notifyGLVideoViewChange", String.valueOf(paramLong2), paramInt2);
    b(new VideoLayerUI.2(this, this.G, this.H));
  }
  
  public void a(long paramLong, Boolean paramBoolean)
  {
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    b(paramLong);
    int i1 = a("openSelfScreenShare", str, 2);
    if ((paramBoolean.booleanValue()) && (i1 > 0)) {
      a(0, i1);
    }
  }
  
  void a(long paramLong, String paramString, int paramInt)
  {
    int i1 = a("closePeerVideo", paramString, paramInt);
    if (i1 >= 0)
    {
      paramString = a(paramString, paramInt);
      GraphicRenderMgr localGraphicRenderMgr = GraphicRenderMgr.getInstance();
      localGraphicRenderMgr.flushGlRender(paramString);
      localGraphicRenderMgr.setGlRender(paramString, null);
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setGlRender[closePeerVideo_no], key[" + paramString + "], index[" + i1 + "], seq[" + paramLong + "]");
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int, true, true);
      b("closePeerVideo", i1);
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i1 = a("setBackground", paramString, paramInt);
    int i2 = i1;
    boolean bool;
    label58:
    meu localmeu;
    if (i1 < 0)
    {
      i2 = a(0);
      if (i2 >= 0)
      {
        if (paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
          break label264;
        }
        bool = true;
        localmeu = this.jdField_a_of_type_ArrayOfMeu[i2];
        a(paramLong, localmeu, paramString, paramInt, bool);
        if ((localmeu != null) && (!bool)) {
          localmeu.a(paramLong, CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a());
        }
      }
      i1 = i2;
      if (paramBoolean2)
      {
        i1 = i2;
        if (i2 > 0)
        {
          a(0, i2);
          i1 = 0;
        }
      }
      i2 = i1;
      if (i1 <= 0) {}
    }
    label264:
    int i3;
    for (i2 = 1;; i2 = i3)
    {
      if (i1 >= 0)
      {
        localmeu = this.jdField_a_of_type_ArrayOfMeu[i1];
        localmeu.a(paramBitmap);
        localmeu.m(paramBoolean1);
        if (!paramBoolean1) {
          localmeu.k(false);
        }
      }
      if (i2 != 0) {
        m(i1);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setBackground uin: " + paramString + ", videoSrcType: " + paramInt + ", index: " + i1 + ", needRenderVideo: " + paramBoolean1);
      return;
      bool = false;
      break label58;
      i3 = 0;
      i1 = i2;
    }
  }
  
  void a(long paramLong, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    meu localmeu = null;
    int i1 = a("openPeerVideo, seq[" + paramLong + "]", paramString, paramInt);
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
      if (i1 > 1)
      {
        lzr.a();
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "SetGlRender index break!!!!!! index=" + i1 + ", remotehasvideo=" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean);
        return;
        bool = paramBoolean1;
      }
      String str = a(paramString, paramInt);
      int i2;
      if (i1 < 0)
      {
        i1 = a(0);
        if (i1 >= 0)
        {
          localmeu = this.jdField_a_of_type_ArrayOfMeu[i1];
          a(paramLong, localmeu, paramString, paramInt, true);
        }
        if ((localmeu != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().c.size() <= 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)) {
          localmeu.a(AIOUtils.dp2px(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        }
        if ((i1 <= 1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 4)) {
          break label565;
        }
        i2 = 1;
        paramString = localmeu;
        paramInt = i1;
        i1 = i2;
      }
      for (;;)
      {
        if (paramString != null)
        {
          paramString.g(paramBoolean2);
          paramString.a(paramLong, this.jdField_a_of_type_Mjo.c());
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
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().N == 3) {
            paramString.h(true);
          }
        }
        for (;;)
        {
          if ((bool) && (paramInt > 0) && (!f()) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Boolean))) {
            a(0, paramInt);
          }
          if (i1 == 0) {
            break;
          }
          m(paramInt);
          return;
          paramString = this.jdField_a_of_type_ArrayOfMeu[i1];
          GraphicRenderMgr.getInstance().setGlRender(str, paramString.a());
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setGlRender[openPeerVideo], key[" + str + "], seq[" + paramLong + "], index[" + i1 + "], " + paramString.d());
          this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int, false, true);
          paramInt = i1;
          i1 = 0;
          break label262;
          paramBoolean1 = false;
          break label292;
          paramString.a(ImageView.ScaleType.CENTER_CROP);
          continue;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) {
            paramString.a(ImageView.ScaleType.CENTER_INSIDE);
          }
        }
        i2 = 0;
        paramString = localmeu;
        paramInt = i1;
        i1 = i2;
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
      while ((this.jdField_a_of_type_Mpl != null) && (!g()))
      {
        a(paramBoolean1, paramLong);
        return;
        a(paramLong, paramString, paramInt);
      }
    }
  }
  
  void a(long paramLong, meu parammeu, String paramString, int paramInt, boolean paramBoolean)
  {
    String str;
    if (parammeu != null)
    {
      str = a(paramString, paramInt);
      parammeu.a(paramString, paramInt);
      parammeu.a(0);
      parammeu.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    }
    try
    {
      paramString = parammeu.a();
      GraphicRenderMgr.getInstance().setAccountUin(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      GraphicRenderMgr.getInstance().setGlRender(str, paramString);
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setGlRender[initGLVideoViewBasePara], key[" + str + "], debug[" + parammeu.d() + "], videoSrcType[" + paramInt + "], yuvTexture[" + paramString + "]");
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int, false, paramBoolean);
      return;
    }
    catch (UnsatisfiedLinkError parammeu)
    {
      parammeu.printStackTrace();
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    int i2 = 2;
    int i1 = 1;
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "notifyAudioMemberChange");
    if (((this.jdField_a_of_type_ComTencentAvVideoController.a().F == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)) || (this.jdField_a_of_type_ComTencentAvVideoController.a().F == 2))
    {
      mmg localmmg = b(paramLong);
      localmmg.b = paramBoolean;
      if (!localmmg.jdField_c_of_type_Boolean) {
        break label129;
      }
      if (i1 != 0) {
        break label141;
      }
      if (!localmmg.d()) {
        break label135;
      }
      i1 = i2;
    }
    label129:
    label135:
    label141:
    for (;;)
    {
      a(paramLong, i1);
      if ((this.jdField_a_of_type_Mmj != null) && (this.jdField_a_of_type_Mmj.a(paramLong, paramBoolean))) {
        b();
      }
      return;
      i1 = 0;
      break;
      i1 = 3;
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
    lbd.f(this.jdField_a_of_type_JavaLangString, "notifyEvent :" + paramInteger + "|" + paramObject);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { paramInteger, paramObject });
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Mjo.a() != 2)
    {
      String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      a("switchLocalView_" + paramString, str);
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, float paramFloat, int paramInt2)
  {
    boolean bool = true;
    int i1 = a("setText", paramString1, paramInt1);
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setText, uin[" + paramString1 + "], videoSrcType[" + paramInt1 + "], text[" + paramString2 + "], textSize[" + paramFloat + "], textColor[" + paramInt2 + "], index[" + i1 + "]");
    }
    if (i1 >= 0)
    {
      paramString1 = this.jdField_a_of_type_ArrayOfMeu[i1];
      paramString1.a(0);
      paramString1.b(paramString2);
      paramString1.a(paramFloat);
      paramString1.k(paramInt2);
      if (f() != 3) {
        break label229;
      }
      if (i1 <= 0) {
        break label188;
      }
    }
    for (;;)
    {
      paramString1.h(bool);
      if (i1 != 0) {
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
        paramString1.a(AIOUtils.dp2px(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        bool = false;
        continue;
        label229:
        if (i1 == 0) {
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
  
  public void a(ArrayList<lcu> paramArrayList)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "notifyAudioMemberChange");
    if (this.jdField_a_of_type_Mmj != null) {
      this.jdField_a_of_type_Mmj.a(paramArrayList);
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
      paramObservable = (lgo)paramObservable[1];
      this.jdField_a_of_type_Mpl.a(paramObservable);
      return;
    case 6010: 
      u();
      r(((Integer)paramObservable[1]).intValue());
      return;
    case 6005: 
      b((mdd)mcx.a(paramObservable));
      return;
    case 6501: 
      if ((this.jdField_a_of_type_Mpl != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0)))
      {
        this.jdField_a_of_type_Mpl.a(true);
        return;
      }
      ljc.a(true);
      return;
    }
    c(true);
  }
  
  public void a(lfe paramlfe)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "tryRegisterMemmberChangeListener");
    paramlfe.a(this.jdField_a_of_type_Mmj);
  }
  
  protected void a(lqo paramlqo, boolean paramBoolean)
  {
    if (o())
    {
      i(paramlqo);
      return;
    }
    this.jdField_e_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.z = 0;
    this.A = 0;
    super.a(paramlqo, paramBoolean);
  }
  
  void a(mdd parammdd)
  {
    u();
    String str = parammdd.b;
    long l1 = parammdd.a();
    if (ljc.a(str))
    {
      bool2 = lmn.a();
      bool1 = bool2;
      if (bool2) {
        bool1 = this.jdField_a_of_type_Mpl.b(parammdd.a(), str, (ViewGroup)this.jdField_a_of_type_AndroidViewView, this.o, this.p);
      }
      if ((bool1) && ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity))) {
        ((AVActivity)this.jdField_a_of_type_AndroidContentContext).g(l1);
      }
    }
    while ((!this.jdField_a_of_type_Mpl.a(parammdd.a(), str, (ViewGroup)this.jdField_a_of_type_AndroidViewView, this.o, this.p)) || (!(this.jdField_a_of_type_AndroidContentContext instanceof AVActivity)))
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
      str1 = this.jdField_a_of_type_ArrayOfMeu[paramInt1].c();
      String str2 = this.jdField_a_of_type_ArrayOfMeu[paramInt2].c();
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "switchVideo, begin, [" + paramInt1 + "]=[" + str1 + "], [" + paramInt2 + "]=[" + str2 + "]", new Throwable("打印调用栈"));
    }
    if ((paramInt1 == paramInt2) || (paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_ArrayOfMeu.length) || (paramInt2 < 0) || (paramInt2 >= this.jdField_a_of_type_ArrayOfMeu.length))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "switchVideo index invalid!");
      }
      return false;
    }
    if (paramInt2 == 0)
    {
      c(paramInt1, paramInt2);
      return true;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
    {
      if (paramInt1 != 0) {
        break label265;
      }
      this.jdField_a_of_type_ArrayOfMeu[paramInt2].a(ImageView.ScaleType.CENTER_INSIDE);
    }
    for (;;)
    {
      str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      this.jdField_a_of_type_ArrayOfMeu[paramInt1].c();
      if (str1.equals(this.jdField_a_of_type_ArrayOfMeu[paramInt2].c())) {
        this.jdField_a_of_type_ArrayOfMeu[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      }
      if ((this.jdField_a_of_type_Mjo == null) || (this.jdField_a_of_type_Mjo.a() != 3)) {
        break;
      }
      return c(paramInt1, paramInt2);
      label265:
      if (paramInt2 == 0) {
        this.jdField_a_of_type_ArrayOfMeu[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      }
    }
    if ((this.jdField_a_of_type_Mjo != null) && (this.jdField_a_of_type_Mjo.a() == 4)) {
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
    int i1 = a("setVideoToBigView", paramString2, 1);
    if (i1 > 0) {
      bool = a(0, i1);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "setVideoToBigView[" + paramString1 + "], uin[" + paramString2 + "], index[" + i1 + "], bRet[" + bool + "]");
    }
    return bool;
  }
  
  public void b(long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int i1 = a("openSelfScreenShareRender", (String)localObject2, 2);
    if (i1 < 0)
    {
      int i2 = a(0);
      if (i2 >= 0)
      {
        localObject1 = this.jdField_a_of_type_ArrayOfMeu[i2];
        b(paramLong, (meu)localObject1, (String)localObject2, 2, true);
      }
      i1 = i2;
      localObject2 = localObject1;
      if (i2 == 0)
      {
        i1 = i2;
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          i1 = i2;
          localObject2 = localObject1;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
          {
            ((meu)localObject1).h(false);
            localObject2 = localObject1;
            i1 = i2;
          }
        }
      }
    }
    for (;;)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setGlRender[openSelfScreenShareRender], index:=" + i1);
      if (localObject2 != null)
      {
        ((meu)localObject2).g(false);
        ((meu)localObject2).k(false);
        ((meu)localObject2).m(true);
        ((meu)localObject2).a(0);
        ((meu)localObject2).a(ImageView.ScaleType.CENTER_CROP);
      }
      return;
      localObject1 = a((String)localObject2, 2);
      localObject2 = this.jdField_a_of_type_ArrayOfMeu[i1];
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setGlRender[openSelfScreenShareRender], key[" + (String)localObject1 + "], index[" + i1 + "], forceToBigView[" + false + "], " + ((meu)localObject2).d());
    }
  }
  
  void b(long paramLong, Boolean paramBoolean)
  {
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
    int i1 = a("openSelfVideo", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), 1);
    f(paramLong);
    if ((paramBoolean.booleanValue()) && (i1 > 0) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Boolean))) {
      a(0, i1);
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    int i2 = 2;
    int i1 = 1;
    if (((this.jdField_a_of_type_ComTencentAvVideoController.a().F == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)) || (this.jdField_a_of_type_ComTencentAvVideoController.a().F == 2))
    {
      mmg localmmg = b(paramLong);
      localmmg.jdField_c_of_type_Boolean = paramBoolean;
      if (!localmmg.jdField_c_of_type_Boolean) {
        break label118;
      }
      if (i1 != 0) {
        break label130;
      }
      if (!localmmg.d()) {
        break label124;
      }
      i1 = i2;
    }
    label130:
    for (;;)
    {
      a(paramLong, i1);
      if ((this.jdField_a_of_type_Mmj != null) && (this.jdField_a_of_type_Mmj.b(paramLong, paramBoolean))) {
        b();
      }
      return;
      label118:
      i1 = 0;
      break;
      label124:
      i1 = 3;
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
  
  void b(mdd parammdd)
  {
    boolean bool = false;
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestZimu, mHandle[" + parammdd.jdField_a_of_type_Int + "], seq[" + parammdd.a() + "]");
    }
    if (parammdd.jdField_a_of_type_Int == 2) {
      if ((this.jdField_a_of_type_Mpl != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0)))
      {
        this.jdField_a_of_type_Mpl.a((ViewGroup)this.jdField_a_of_type_AndroidViewView, parammdd.a());
        if ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity)) {
          ((AVActivity)this.jdField_a_of_type_AndroidContentContext).g(parammdd.a());
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
          if (parammdd.jdField_a_of_type_Int == 1)
          {
            a(parammdd);
            return;
          }
          if ((parammdd.jdField_a_of_type_Int != 3) && (parammdd.jdField_a_of_type_Int != 4)) {
            break;
          }
        } while (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0));
        u();
        if (parammdd.jdField_a_of_type_Int == 3) {
          bool = true;
        }
      } while ((!this.jdField_a_of_type_Mpl.a(parammdd.a(), (ViewGroup)this.jdField_a_of_type_AndroidViewView, bool)) || (!(this.jdField_a_of_type_AndroidContentContext instanceof AVActivity)));
      ((AVActivity)this.jdField_a_of_type_AndroidContentContext).g(parammdd.a());
      return;
    } while (parammdd.jdField_a_of_type_Int != 5);
    if (this.jdField_a_of_type_Mpl != null)
    {
      this.jdField_a_of_type_Mpl.a(parammdd.a());
      return;
    }
    ljc.a(false);
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
      if ((this.jdField_a_of_type_Mpl != null) && (!l())) {
        a(paramBoolean1, paramLong);
      }
      return true;
      e(paramLong);
    }
  }
  
  public void c(long paramLong)
  {
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int i1 = a("closeSelfScreenShare", str, 2);
    if (i1 >= 0)
    {
      str = a(str, 2);
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setGlRender[closeSelfVideo_no], key[" + str + "], index[" + i1 + "], seq[" + paramLong + "]");
      d(paramLong);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    long l1 = AudioHelper.b();
    int i1 = super.b();
    int i2 = super.c();
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (a(locallfe))
    {
      mjo localmjo = this.jdField_a_of_type_Mjo;
      meu[] arrayOfmeu = this.jdField_a_of_type_ArrayOfMeu;
      int i3 = this.u;
      int i4 = this.o;
      int i5 = this.p;
      if (!locallfe.jdField_e_of_type_Boolean)
      {
        paramBoolean = true;
        localmjo.a(arrayOfmeu, i1, i2, i3, i4, i5, paramBoolean);
        lix.c(i2, i1);
      }
    }
    for (;;)
    {
      super.b();
      return;
      paramBoolean = false;
      break;
      if (b(locallfe))
      {
        this.jdField_a_of_type_Mjo.a(this.p, this.jdField_d_of_type_AndroidGraphicsRect, this.jdField_e_of_type_AndroidGraphicsRect, this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
        this.jdField_a_of_type_Mjo.a(locallfe, this.jdField_a_of_type_ArrayOfMeu, i1, i2, paramBoolean, this.v, this.p);
        new mdd(l1, "layoutVideoView", 5, null).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
    }
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    return (this.jdField_a_of_type_Mma != null) && (this.jdField_a_of_type_Mma.dispatchHoverEvent(paramMotionEvent));
  }
  
  public void d(long paramLong)
  {
    int i1 = a("closeSelfScreenShareRender", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), 2);
    if (i1 >= 0) {
      b("closeSelfScreenShareRender", i1);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ArrayOfMeu[0] != null) && (this.jdField_a_of_type_ArrayOfMeu[1] != null))
    {
      this.jdField_a_of_type_Mjo.a(paramBoolean);
      c(true);
    }
  }
  
  void e(long paramLong)
  {
    ThreadManager.post(this.jdField_b_of_type_JavaLangRunnable, 8, null, false);
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int i1 = a("closeSelfVideo", str, 1);
    if (i1 >= 0)
    {
      str = a(str, 1);
      GraphicRenderMgr localGraphicRenderMgr = GraphicRenderMgr.getInstance();
      localGraphicRenderMgr.flushGlRender(str);
      localGraphicRenderMgr.clearCameraFrames();
      localGraphicRenderMgr.setGlRender(str, null);
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setGlRender[closeSelfVideo_no], key[" + str + "], index[" + i1 + "], seq[" + paramLong + "]");
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int, true, false);
      g(paramLong);
    }
  }
  
  public void e(lqo paramlqo)
  {
    int i1;
    float f1;
    float f2;
    float f3;
    float f4;
    label165:
    Object localObject;
    if (p())
    {
      if (paramlqo.a() <= paramlqo.b()) {
        break label332;
      }
      i1 = 1;
      if (i1 == 0)
      {
        i2 = b() / 2;
        int i3 = c() / 2;
        paramlqo.a(i2, i3, 0.0F);
        paramlqo.a(0.0F, 0.0F, b(), c(), Color.parseColor("#1E1F22"));
        f1 = this.jdField_a_of_type_Lrs.b().getWidth();
        f2 = this.jdField_a_of_type_Lrs.b().getHeight();
        f3 = f1 / f2;
        f4 = b() * 1.0F / c();
        if (f3 <= f4) {
          break label338;
        }
        f3 = f2 * f4;
        f4 = (f1 - f3) / 2.0F;
        this.jdField_a_of_type_Lrs.a((int)f4, 0, (int)f3, (int)f2);
        this.jdField_a_of_type_Lrs.a((int)f1, (int)f2);
        this.jdField_a_of_type_Lrs.a(paramlqo, 0, 0, b(), c());
        paramlqo.a(-i2, -i3, 0.0F);
      }
      localObject = VideoController.a().b();
      if ((localObject == null) || (!((WatchTogetherMediaPlayCtrl)localObject).c())) {
        break label371;
      }
    }
    label332:
    label338:
    label371:
    for (int i2 = 1;; i2 = 0)
    {
      if (i2 == 0) {
        g(paramlqo);
      }
      this.jdField_a_of_type_Mzi.b(paramlqo.a(), paramlqo.b());
      if (i2 != 0) {
        g(paramlqo);
      }
      localObject = lbz.a().a();
      if ((i1 == 0) && (localObject != null)) {
        this.jdField_a_of_type_Mzh.a(paramlqo, ((lfe)localObject).jdField_j_of_type_Boolean, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin(), ((lfe)localObject).jdField_k_of_type_Boolean, Long.valueOf(((lfe)localObject).jdField_d_of_type_JavaLangString).longValue());
      }
      super.e(paramlqo);
      return;
      i1 = 0;
      break;
      f3 = f1 / f4;
      f4 = (f2 - f3) / 2.0F;
      this.jdField_a_of_type_Lrs.a(0, (int)f4, (int)f1, (int)f3);
      break label165;
    }
  }
  
  public void e(boolean paramBoolean)
  {
    mrq.a("switch_camera", "onCameraSwitched", 3, new Object[0]);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onCameraSwitched isFrontCamera: " + paramBoolean);
    }
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int i1 = a("onCameraSwitched", str, 1);
    if (i1 >= 0)
    {
      str = str + "_" + 1;
      GraphicRenderMgr localGraphicRenderMgr = GraphicRenderMgr.getInstance();
      localGraphicRenderMgr.clearCameraFrames();
      localGraphicRenderMgr.flushGlRender(str);
      this.jdField_a_of_type_ArrayOfMeu[i1].o(false);
      this.jdField_a_of_type_Lcg = new mlu(this, i1, paramBoolean);
      this.jdField_a_of_type_ComTencentAvVideoController.a.a(true, this.jdField_a_of_type_Lcg);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int != 3000) {
        break label304;
      }
      if (!paramBoolean) {
        break label268;
      }
      bdla.b(null, "CliOper", "", "", "0X80041B5", "0X80041B5", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().J)
      {
        if (!paramBoolean) {
          break;
        }
        bdla.b(null, "CliOper", "", "", "0X8005211", "0X8005211", 0, 0, "", "", "", "");
      }
      return;
      label268:
      bdla.b(null, "CliOper", "", "", "0X80041B4", "0X80041B4", 0, 0, "", "", "", "");
      continue;
      label304:
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 1) {
        if (paramBoolean)
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 10) {
            bdla.b(null, "CliOper", "", "", "0X800593B", "0X800593B", 0, 0, "", "", "", "");
          } else {
            bdla.b(null, "CliOper", "", "", "0X80046E2", "0X80046E2", 0, 0, "", "", "", "");
          }
        }
        else if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 10) {
          bdla.b(null, "CliOper", "", "", "0X800593A", "0X800593A", 0, 0, "", "", "", "");
        } else {
          bdla.b(null, "CliOper", "", "", "0X80046E1", "0X80046E1", 0, 0, "", "", "", "");
        }
      }
    }
    bdla.b(null, "CliOper", "", "", "0X8005210", "0X8005210", 0, 0, "", "", "", "");
  }
  
  boolean e()
  {
    return lsq.a(this.jdField_a_of_type_AndroidContentContext) == 2;
  }
  
  public int f()
  {
    return this.jdField_a_of_type_Mjo.a();
  }
  
  public void f()
  {
    super.f();
    if (p()) {
      this.jdField_a_of_type_Mzi.b();
    }
  }
  
  public void f(long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int i1 = a("openSelfVideo", (String)localObject2, 1);
    if (i1 < 0)
    {
      i1 = a(0);
      if (i1 >= 0)
      {
        localObject1 = this.jdField_a_of_type_ArrayOfMeu[i1];
        a(paramLong, (meu)localObject1, (String)localObject2, 1, false);
      }
      if ((i1 == 0) && (localObject1 != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)) {
        ((meu)localObject1).h(false);
      }
      lfe locallfe = lbz.a().a();
      localObject2 = localObject1;
      if (i1 == 0)
      {
        localObject2 = localObject1;
        if (locallfe != null)
        {
          localObject2 = localObject1;
          if (locallfe.A())
          {
            c(true);
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
          ((meu)localObject2).a(paramLong, CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a());
        }
        ((meu)localObject2).g(false);
        ((meu)localObject2).k(false);
        ((meu)localObject2).m(true);
        ((meu)localObject2).a(0);
        ((meu)localObject2).a(ImageView.ScaleType.CENTER_CROP);
      }
      return;
      localObject1 = a((String)localObject2, 1);
      localObject2 = this.jdField_a_of_type_ArrayOfMeu[i1];
      GraphicRenderMgr.getInstance().setGlRender((String)localObject1, ((meu)localObject2).a());
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setGlRender[openSelfVideo], key[" + (String)localObject1 + "], index[" + i1 + "], forceToBigView[" + false + "], " + ((meu)localObject2).d());
    }
  }
  
  public void f(boolean paramBoolean)
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
    for (int i1 = 0;; i1 = 8)
    {
      localTextView.setVisibility(i1);
      return;
    }
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
        lbd.f(this.jdField_a_of_type_JavaLangString, "SwitchLocalToBigView:" + bool3 + "|" + bool1);
        return bool2;
        bool1 = false;
        break;
      }
    }
    return false;
  }
  
  public int g()
  {
    return this.n;
  }
  
  public void g()
  {
    super.g();
    if (p()) {
      this.jdField_a_of_type_Mzi.a();
    }
  }
  
  public void g(int paramInt)
  {
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "changeLayoutMode, screenStyle[" + this.jdField_a_of_type_ComTencentAvVideoController.a().N + "->" + paramInt + "], ScreenLayout[" + this.jdField_a_of_type_Mjo.a() + "->" + paramInt + "], seq[" + l1 + "]");
    if ((b(this.jdField_a_of_type_ComTencentAvVideoController.a())) && (paramInt == 1)) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "changeLayoutMode with error happen", new Throwable());
    }
    super.g(paramInt);
    int i1 = this.jdField_a_of_type_Mjo.a();
    if (i1 != paramInt)
    {
      this.g = true;
      this.jdField_a_of_type_Mjo = mjo.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, false);
      if (i())
      {
        super.a(null);
        super.d(-15197410);
        new mdd(l1, "changeLayoutMode", 5, null).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        c(true);
        if ((i1 != 3) || (paramInt != 4)) {
          break label349;
        }
        i1 = 1;
      }
    }
    for (;;)
    {
      label232:
      if (i1 == 1)
      {
        float f1 = mvk.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
        float f2 = mvk.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
        i1 = 0;
        if (i1 < this.jdField_a_of_type_ArrayOfMeu.length)
        {
          if (i1 == 0)
          {
            this.jdField_a_of_type_ArrayOfMeu[i1].h(false);
            this.jdField_a_of_type_ArrayOfMeu[i1].j(12);
            this.jdField_a_of_type_ArrayOfMeu[i1].a(f2);
          }
          for (;;)
          {
            this.jdField_a_of_type_ArrayOfMeu[i1].i();
            i1 += 1;
            break label263;
            B();
            a(Integer.valueOf(6501), null);
            break;
            if ((i1 == 4) && (paramInt == 3))
            {
              i1 = 2;
              break label232;
            }
            if (paramInt != 3) {
              break label543;
            }
            i1 = 3;
            break label232;
            this.jdField_a_of_type_ArrayOfMeu[i1].h(true);
            this.jdField_a_of_type_ArrayOfMeu[i1].j(12);
            this.jdField_a_of_type_ArrayOfMeu[i1].a(f1);
          }
        }
      }
      label263:
      label349:
      i1 = 0;
      if (i1 < this.jdField_a_of_type_ArrayOfMeu.length)
      {
        this.jdField_a_of_type_ArrayOfMeu[i1].d(this.jdField_a_of_type_Mjo.c());
        meu localmeu = this.jdField_a_of_type_ArrayOfMeu[i1];
        if (paramInt == 3) {}
        for (boolean bool = true;; bool = false)
        {
          localmeu.f(bool);
          a(l1, this.jdField_a_of_type_ArrayOfMeu[i1]);
          i1 += 1;
          break;
        }
      }
      if ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity)) {
        ((AVActivity)this.jdField_a_of_type_AndroidContentContext).g(l1);
      }
      this.g = false;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) {
        i(paramInt);
      }
      return;
      label543:
      i1 = 0;
    }
  }
  
  public void g(long paramLong)
  {
    int i1 = a("closeSelfRender", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), 1);
    if (i1 >= 0) {
      b("closeSelfRender", i1);
    }
  }
  
  void g(boolean paramBoolean)
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
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130849834);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#5f656f"));
    this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130849835);
  }
  
  boolean g()
  {
    boolean bool2 = false;
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < this.jdField_a_of_type_ArrayOfMeu.length)
      {
        meu localmeu = this.jdField_a_of_type_ArrayOfMeu[i1];
        if ((localmeu.a() == 0) && (str.equals(localmeu.c()))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  protected void h(int paramInt)
  {
    this.jdField_a_of_type_Mjo.a(this.jdField_a_of_type_ArrayOfMeu, paramInt, b(), c(), this.o, this.p);
  }
  
  public boolean h()
  {
    return (this.p == 0) || (this.o == 0) || (this.o == this.jdField_i_of_type_Int) || (this.jdField_c_of_type_Boolean);
  }
  
  public void i(int paramInt)
  {
    if (this.F != paramInt) {
      this.F = paramInt;
    }
  }
  
  public void j(int paramInt)
  {
    boolean bool2 = true;
    label48:
    CameraUtils localCameraUtils;
    if ((this.jdField_a_of_type_Mjo != null) && (a(this.jdField_a_of_type_ComTencentAvVideoController.a())))
    {
      this.jdField_a_of_type_Mjo.a(paramInt);
      if (paramInt == 2) {
        break label80;
      }
      bool1 = true;
      c(bool1);
      if (paramInt == 0) {
        break label85;
      }
      bool1 = true;
      h(bool1);
      localCameraUtils = CameraUtils.a(this.jdField_a_of_type_AndroidContentContext);
      if (paramInt == 0) {
        break label90;
      }
    }
    label80:
    label85:
    label90:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localCameraUtils.a(bool1);
      this.n = paramInt;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label48;
    }
  }
  
  public void k(int paramInt)
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
  
  protected void l()
  {
    super.l();
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.post(new VideoLayerUI.1(this));
    this.jdField_a_of_type_Mzi.a(this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView);
  }
  
  public void l(int paramInt)
  {
    this.K = paramInt;
  }
  
  protected void m()
  {
    this.jdField_a_of_type_Mjy = new mjy(this.jdField_a_of_type_ComTencentAvVideoController);
  }
  
  void m(int paramInt)
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
  
  protected void n(int paramInt) {}
  
  public void o() {}
  
  public void p()
  {
    if (this.jdField_a_of_type_Lcg != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a.c();
      this.jdField_a_of_type_Lcg = null;
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
    this.jdField_b_of_type_Lsd = null;
    this.jdField_a_of_type_AndroidViewGestureDetector = null;
    this.jdField_a_of_type_Lql = null;
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = null;
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MultiVideoOpenAnimation = null;
    H();
    if (this.jdField_a_of_type_Mpl != null)
    {
      if ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity))
      {
        localObject = (AVActivity)this.jdField_a_of_type_AndroidContentContext;
        this.jdField_a_of_type_Mpl.b(((AVActivity)localObject).jdField_e_of_type_Boolean);
      }
      this.jdField_a_of_type_Mpl = null;
    }
    int i1;
    if ((this.F == -1) || (this.F == 2) || (this.F == 1))
    {
      i1 = 1;
      if (i1 == 0) {
        if (this.jdField_a_of_type_Mjo.a() != 3) {
          break label356;
        }
      }
    }
    label356:
    for (Object localObject = "1";; localObject = "2")
    {
      bdla.b(null, "CliOper", "", "", "0X8009F5D", "0X8009F5D", 0, 0, (String)localObject, "", "", "");
      if (this.jdField_a_of_type_Mjo != null)
      {
        this.jdField_a_of_type_Mjo.a();
        this.jdField_a_of_type_Mjo = null;
      }
      D();
      if (this.jdField_a_of_type_Mmj != null) {
        this.jdField_a_of_type_Mmj.b();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      if (this.jdField_a_of_type_Mzi != null)
      {
        this.jdField_a_of_type_Mzi.c();
        this.jdField_a_of_type_Mzi = null;
      }
      if (this.jdField_a_of_type_Mzh != null)
      {
        this.jdField_a_of_type_Mzh.a();
        this.jdField_a_of_type_Mzh = null;
      }
      super.p();
      return;
      i1 = 0;
      break;
    }
  }
  
  public void q()
  {
    super.q();
    q(this.v);
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
    q(this.v);
  }
  
  void t()
  {
    int i1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0)) && (i1 == 2))
    {
      u();
      this.jdField_a_of_type_Mpl.a();
    }
  }
  
  void u()
  {
    if (this.jdField_a_of_type_Mpl == null) {
      this.jdField_a_of_type_Mpl = new mpl(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI
 * JD-Core Version:    0.7.0.1
 */