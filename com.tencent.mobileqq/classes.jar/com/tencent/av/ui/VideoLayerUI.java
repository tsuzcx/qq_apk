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
import com.tencent.av.AVLog;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoCameraListener;
import com.tencent.av.VideoCameraListener.SwitchCameraListener;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.SentenceInfo;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.api.IGraphicRender;
import com.tencent.av.opengl.gesturedetectors.MoveGestureDetector;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.texture.BitmapTexture;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.opengl.ui.GLView;
import com.tencent.av.opengl.ui.GLView.OnTouchListener;
import com.tencent.av.opengl.ui.OnVisiableItemChangeListener;
import com.tencent.av.opengl.ui.ScrollerHelper;
import com.tencent.av.opengl.ui.animation.GLAnimation;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.funchat.zimu.ZimuViewProxy;
import com.tencent.av.utils.AVTraceUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.UITools;
import com.tencent.av.widget.RotateLayout;
import com.tencent.av.widget.RotateLayout.LayoutParams;
import com.tencent.av.wtogether.callback.VideoSink;
import com.tencent.av.wtogether.gles.WatchTogetherVideoBgRender;
import com.tencent.av.wtogether.gles.WatchTogetherVideoRenderHelper;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.av.wtogether.util.WTogetherUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.LogUtil;

public class VideoLayerUI
  extends VideoLayerUIBase
{
  public GestureDetector I = null;
  public int J = 0;
  public int K = 144;
  public int L = 144;
  public int M = 4;
  protected VideoLayerUI.MultiVideoOpenAnimation N = null;
  int O = 0;
  boolean P = false;
  AVActivity.AnimationTrigger Q = null;
  long R = 0L;
  ZimuViewProxy S;
  protected int T = 0;
  private GLView.OnTouchListener aA = null;
  private MoveGestureDetector aB = null;
  private ScaleGestureDetector aC = null;
  private int aD = -1;
  private int aE = -1;
  private volatile boolean aF = false;
  private Rect aG = new Rect();
  private Rect aH = new Rect();
  private volatile int aI = 0;
  private ArrayList<GLView> aJ = new ArrayList();
  private int aK = 0;
  private int aL = 0;
  private boolean aM = true;
  private int aN = 0;
  private int aO = 0;
  private int aP;
  private volatile int aQ = -1;
  private GestureDetector aR;
  private ScrollerHelper aS;
  private boolean aT = true;
  private boolean aU;
  private OnVisiableItemChangeListener aV;
  private DisplayMetrics aW = new DisplayMetrics();
  private long aX = -1L;
  private int aY = -1;
  private VideoTalkMemberManager aZ = new VideoTalkMemberManager(this.Z, this);
  private final boolean ay = true;
  private final int az = MultiVideoCtrlLayerUIBase.e;
  private VideoHoldViewPools ba = new VideoHoldViewPools(this.X, paramVideoAppInterface, this);
  private ConcurrentHashMap<Long, VideoMemberInfo> bb = new ConcurrentHashMap();
  private boolean bc = false;
  private int bd = -1;
  private int be = -1;
  private ArrayList<Runnable> bf = new ArrayList();
  private VideoCameraListener.SwitchCameraListener bg = null;
  private long bh = 0L;
  private boolean bi = false;
  private RotateLayout bj = null;
  private LinearLayout bk = null;
  private TextView bl = null;
  private TextView bm = null;
  private List<RecvMsg> bn = new LinkedList();
  private Runnable bo = new VideoLayerUI.NewMsgRunnable(this, null);
  private Runnable bp = new VideoLayerUI.LastMsgRunnable(this, null);
  private int bq = 0;
  private int br = 0;
  private int bs = 0;
  private VideoLayerUI.TouchListener bt = new VideoLayerUI.TouchListener(this);
  private VideoLayerUI.MyExploreByTouchHelper bu;
  
  public VideoLayerUI(VideoAppInterface paramVideoAppInterface, Context paramContext, View paramView)
  {
    super(paramVideoAppInterface, paramContext, paramView);
    this.aj = ScreenLayout.a(this.X, this.Y, 1, false);
    this.am = new WatchTogetherVideoRenderHelper(false);
    this.an = new WatchTogetherVideoBgRender(this.Y, paramContext);
    z();
    af();
    ag();
    C();
    ah();
    A();
    aq();
    ai();
    Q();
    QLog.w(this.U, 1, "VideoLayerUI");
  }
  
  public static int a(String paramString, Context paramContext, int paramInt, boolean paramBoolean, Display paramDisplay)
  {
    if (paramBoolean)
    {
      int i = paramDisplay.getRotation();
      int j = (i * 90 + paramInt) % 360;
      CameraUtils.a(paramContext).setSupportLandscape(true);
      if (QLog.isDevelopLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("setRotation, rotation[");
        paramContext.append(paramInt);
        paramContext.append("], displayRotation[");
        paramContext.append(i);
        paramContext.append("], viewRotation[");
        paramContext.append(j);
        paramContext.append("]");
        QLog.w(paramString, 1, paramContext.toString());
      }
      return j;
    }
    CameraUtils.a(paramContext).setSupportLandscape(false);
    return paramInt;
  }
  
  private String a(VideoMemberInfo paramVideoMemberInfo)
  {
    if (paramVideoMemberInfo.a == 0) {
      return this.Z.a(String.valueOf(paramVideoMemberInfo.b), String.valueOf(this.Z.k().aN), this.Z.k().aQ);
    }
    long l = paramVideoMemberInfo.b;
    AVPhoneUserInfo localAVPhoneUserInfo;
    if (paramVideoMemberInfo.g != null) {
      localAVPhoneUserInfo = paramVideoMemberInfo.g;
    } else {
      localAVPhoneUserInfo = this.Z.b(l, this.Z.k().bm);
    }
    if ((localAVPhoneUserInfo != null) && (localAVPhoneUserInfo.telInfo.mobile != null))
    {
      paramVideoMemberInfo.c = localAVPhoneUserInfo.telInfo.mobile;
      paramVideoMemberInfo = this.Z.d(localAVPhoneUserInfo.telInfo.mobile);
      if (paramVideoMemberInfo != null) {
        return paramVideoMemberInfo;
      }
      return PstnUtils.a(localAVPhoneUserInfo.telInfo.mobile, 4);
    }
    if ((localAVPhoneUserInfo != null) && (QLog.isColorLevel()))
    {
      paramVideoMemberInfo = this.U;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMemmberName --> can not get Open Id. PhoneInfo = ");
      localStringBuilder.append(localAVPhoneUserInfo.toString());
      QLog.d(paramVideoMemberInfo, 2, localStringBuilder.toString());
    }
    return this.X.getResources().getString(2131890648);
  }
  
  private static final String a(CharSequence paramCharSequence)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramCharSequence);
    int j = paramCharSequence.length();
    paramCharSequence = (QQText)paramCharSequence;
    int i = 0;
    EmoticonSpan[] arrayOfEmoticonSpan = (EmoticonSpan[])paramCharSequence.getSpans(0, j, EmoticonSpan.class);
    int k;
    for (j = 0; i < arrayOfEmoticonSpan.length; j = k)
    {
      Object localObject = arrayOfEmoticonSpan[i];
      k = j;
      if ((localObject instanceof EmoticonSpan))
      {
        int m = paramCharSequence.getSpanStart(localObject);
        int n = paramCharSequence.getSpanEnd(localObject);
        k = j;
        if (((EmoticonSpan)localObject).emojiType == 2)
        {
          localObject = ((EmoticonSpan)localObject).getDescription();
          localStringBuffer.replace(m + j, n + j, (String)localObject);
          k = j + (((String)localObject).length() - (n - m));
        }
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  private void a(long paramLong, int paramInt)
  {
    int i = a("refreshMicState", String.valueOf(paramLong), 1);
    if (i != -1) {
      this.ae[i].i(paramInt);
    }
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    paramView = paramView.findViewById(2131428977);
    int i;
    if ((paramBoolean) && (!VideoController.f().aD())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramView.setVisibility(0);
      return;
    }
    paramView.setVisibility(8);
  }
  
  private void a(GLCanvas paramGLCanvas, GLView paramGLView, boolean paramBoolean)
  {
    boolean bool = paramGLView.c();
    int k = 1;
    int i;
    if ((!bool) && (!paramGLView.k())) {
      i = 0;
    } else {
      i = 1;
    }
    int j;
    if ((paramGLView.f().left - this.aK <= this.aW.widthPixels) && (paramGLView.f().right - this.aK >= 0)) {
      j = 0;
    } else {
      j = 1;
    }
    if ((j != 0) && (!paramBoolean)) {
      j = k;
    } else {
      j = 0;
    }
    if (i != 0)
    {
      if (j != 0) {
        return;
      }
      float f = 0;
      paramGLCanvas.a(f, f);
      paramGLView.a(paramGLCanvas);
      f = 0;
      paramGLCanvas.a(f, f);
    }
  }
  
  private void a(GLVideoView paramGLVideoView, float paramFloat, long paramLong)
  {
    paramLong /= 10L;
    double d1 = paramFloat;
    double d2 = paramLong;
    Double.isNaN(d2);
    a(new VideoLayerUI.10(this, paramLong, paramGLVideoView, (float)Math.pow(d1, 1.0D / d2)));
  }
  
  private void a(GLVideoView paramGLVideoView, boolean paramBoolean)
  {
    GLAnimation localGLAnimation = new GLAnimation();
    localGLAnimation.b(50);
    localGLAnimation.b(0.0F, 0.0F, 0.0F, 90.0F, 0.0F, 0.0F);
    localGLAnimation.a(new VideoLayerUI.4(this, paramGLVideoView, paramBoolean));
    localGLAnimation.a(1);
    paramGLVideoView.a(localGLAnimation);
    paramGLVideoView.m();
  }
  
  private void a(boolean paramBoolean, long paramLong)
  {
    if (this.Y.d(0))
    {
      R();
      Object localObject = this.S.c();
      if (localObject != null)
      {
        localObject = ((ZimuItem)localObject).getId();
        int i;
        if (!paramBoolean) {
          i = 4;
        } else {
          i = 1;
        }
        new ControlUIObserver.ZimuRequest(paramLong, "showLastZimu", i, (String)localObject).a(this.Y);
      }
    }
  }
  
  private void af()
  {
    this.aW = new DisplayMetrics();
    ((Activity)this.X).getWindowManager().getDefaultDisplay().getRealMetrics(this.aW);
    this.M = this.X.getResources().getDimensionPixelSize(2131298621);
    this.K = ((this.aW.widthPixels - this.M * 5) / 4);
    this.L = this.K;
    int i = this.aW.heightPixels;
    i = this.K;
    i = this.X.getResources().getDimensionPixelSize(2131300024);
    this.aG = new Rect(0, this.aW.heightPixels - i - this.L, this.aW.widthPixels, this.aW.heightPixels - i);
    this.aR = new GestureDetector(this.X, new VideoLayerUI.MyGestureListener(this, null));
    this.aS = new ScrollerHelper(this.X);
    this.aS.a(true);
    this.aS.a((int)UITools.a(this.X, 50.0F));
    this.af = new GLVideoView(this.X, this.Y, String.format("%s_%s", new Object[] { this.U, Integer.valueOf(1000) }), this.Z.ay());
    this.af.a(1);
    this.af.a(this.Y.getCurrentAccountUin());
    this.af.a("null", 1);
    this.af.a(true);
    this.af.e(false);
    this.af.i(false);
    this.af.j(true);
    i = AIOUtils.b(16.0F, this.X.getResources());
    this.af.a(i);
    this.af.k(true);
    this.af.e(Color.parseColor("#686E6C"));
    this.af.a(2, Boolean.valueOf(false));
    this.af.c(999);
    a(this.af);
  }
  
  private void ag()
  {
    this.at = SharedPreUtils.B(this.X).getInt("video_position", 3);
  }
  
  private void ah()
  {
    int i;
    if ((this.Z != null) && (this.Z.k().p == 1008)) {
      i = 2130843118;
    } else {
      i = 2130842939;
    }
    this.ae[0].a(UITools.a(this.X, i));
    super.a(UITools.a(this.X, i));
  }
  
  private void ai()
  {
    this.aC = new ScaleGestureDetector(this.X, new VideoLayerUI.ScaleGestureListener(this));
    this.I = new GestureDetector(this.X, new VideoLayerUI.GestureListener(this));
    this.aB = new MoveGestureDetector(this.X, new VideoLayerUI.MoveListener(this, null));
    this.aA = new VideoLayerUI.WeakTouchListener(this.bt);
    a(this.aA);
    this.O = AIOUtils.b(20.0F, this.X.getResources());
  }
  
  private void aj()
  {
    synchronized (this.bf)
    {
      this.bf.clear();
      this.aK = 0;
      this.aL = 0;
      this.aM = true;
      return;
    }
  }
  
  private void ak()
  {
    if (this.ao != null) {
      return;
    }
    Bitmap localBitmap = UITools.a(this.X, 2130843338);
    if (localBitmap != null)
    {
      this.ao = new BitmapTexture(localBitmap);
      this.ao.b(false);
    }
  }
  
  private boolean al()
  {
    return (this.aj != null) && (this.aj.b() == 4) && (!this.aF);
  }
  
  private boolean am()
  {
    return (this.aj != null) && (this.aj.b() == 1) && (!this.aF) && (this.aj.c());
  }
  
  private int an()
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.ae.length; j = k)
    {
      GLVideoView localGLVideoView = this.ae[i];
      String str = localGLVideoView.R();
      k = j;
      if (localGLVideoView.b() == 0)
      {
        k = j;
        if (!TextUtils.isEmpty(str)) {
          k = j + 1;
        }
      }
      i += 1;
    }
    return j;
  }
  
  private Boolean ao()
  {
    boolean bool;
    if (this.Z.k().o == 2) {
      bool = true;
    } else {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
  
  private void ap()
  {
    if (this.bj == null)
    {
      this.bj = ((RotateLayout)this.aa.findViewById(2131428960));
      this.bk = ((LinearLayout)this.aa.findViewById(2131428969));
      this.bl = ((TextView)this.aa.findViewById(2131428971));
      this.bm = ((TextView)this.aa.findViewById(2131428970));
      Resources localResources = this.X.getApplicationContext().getResources();
      this.bq = ((int)localResources.getDimension(2131298537));
      this.br = ((int)localResources.getDimension(2131298538));
      int i = (int)(localResources.getDimension(2131296611) + localResources.getDimension(2131296680));
      int j = (int)(localResources.getDimension(2131296614) + localResources.getDimension(2131296683));
      int k = (int)(localResources.getDimension(2131296609) + localResources.getDimension(2131296678));
      int m = (int)(localResources.getDimension(2131296613) + localResources.getDimension(2131296682));
      this.bm.setPadding(i, j, k, m);
      this.bm.setTag(Long.valueOf(0L));
      this.bl.setMaxWidth(this.bq);
      this.bm.setMaxWidth(this.br);
      this.bm.getBackground().setAlpha(128);
      if (AudioHelper.a(0) == 1)
      {
        this.bj.setBackgroundColor(-460545);
        this.bk.setBackgroundColor(-984833);
        this.bm.setBackgroundColor(-1);
      }
    }
  }
  
  private void aq()
  {
    this.bu = new VideoLayerUI.MyExploreByTouchHelper(this, this.ad);
    ViewCompat.setAccessibilityDelegate(this.ad, this.bu);
  }
  
  private boolean ar()
  {
    long l = this.aX;
    this.aX = System.currentTimeMillis();
    if (this.aX - l > 1000L) {
      return true;
    }
    this.aX = l;
    QLog.d(this.U, 1, "canPerformClick not allowed");
    return false;
  }
  
  private int as()
  {
    return this.aG.right - this.aG.left;
  }
  
  private int at()
  {
    return an();
  }
  
  private int au()
  {
    int j = this.aQ - as();
    int i = j;
    if (j <= 0) {
      i = 0;
    }
    return i;
  }
  
  private void av()
  {
    int j = this.aP;
    int i = Math.max(0, j / (this.K + this.M));
    int k = this.K;
    int m = this.M;
    j = (int)Math.ceil((as() - ((i + 1) * (k + m) - j)) * 1.0F / (this.K + this.M));
    i(i, Math.min(at() - 1, j + i));
  }
  
  private Bitmap b(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      localObject = paramBitmap;
      if (paramBitmap == null) {
        return localObject;
      }
      if (!paramBitmap.isRecycled())
      {
        localObject = paramBitmap;
        if (paramBitmap.getConfig() != null) {
          return localObject;
        }
      }
    }
    Bitmap localBitmap = UITools.a(this.X, 2130841348);
    Object localObject = localBitmap;
    if (QLog.isDevelopLevel())
    {
      localObject = this.U;
      paramBitmap = new StringBuilder();
      paramBitmap.append("memory not enough or binder bad,so quit load headIcon,bitmap.getConfig():=");
      paramBitmap.append(localBitmap);
      if (paramBitmap.toString() != null) {
        paramBitmap = localBitmap.getConfig();
      } else {
        paramBitmap = "bitmap null";
      }
      QLog.d((String)localObject, 1, new Object[] { paramBitmap });
      localObject = localBitmap;
    }
    return localObject;
  }
  
  private Bitmap b(VideoMemberInfo paramVideoMemberInfo)
  {
    if (paramVideoMemberInfo.a == 0) {
      return this.Z.a(String.valueOf(paramVideoMemberInfo.b), String.valueOf(this.Z.k().aN), this.Z.k().aQ, true, false);
    }
    return ((BitmapDrawable)this.X.getResources().getDrawable(2130843137)).getBitmap();
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if ((this.aP == paramInt) && (!paramBoolean)) {
      return;
    }
    this.aP = paramInt;
    av();
  }
  
  private void b(long paramLong, GLVideoView paramGLVideoView, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramGLVideoView != null)
    {
      paramGLVideoView.a(paramString, paramInt);
      paramGLVideoView.a(0);
      paramGLVideoView.a(this.Y.getCurrentAccountUin());
    }
  }
  
  private void b(RecvMsg paramRecvMsg)
  {
    if (ao().booleanValue()) {
      return;
    }
    String str1 = paramRecvMsg.c();
    String str2 = paramRecvMsg.a();
    Object localObject2 = paramRecvMsg.b();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (this.Z.j)
      {
        localObject1 = localObject2;
        if (str2 != null) {
          localObject1 = this.Z.a(str2, String.valueOf(this.Z.k().aN), this.Z.k().aQ);
        }
      }
    }
    paramRecvMsg = paramRecvMsg.d();
    if (QLog.isColorLevel())
    {
      localObject2 = this.U;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showRecvMsg friendUin: ");
      localStringBuilder.append(str1);
      localStringBuilder.append(", senderUin: ");
      localStringBuilder.append(str2);
      localStringBuilder.append(", senderName: ");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(", msg: ");
      localStringBuilder.append(paramRecvMsg);
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    t(this.au);
    i(true);
    localObject2 = this.bl;
    if (localObject2 != null) {
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    if ((paramRecvMsg != null) && (this.bm != null))
    {
      localObject1 = new QQText(paramRecvMsg, 11);
      paramRecvMsg = (RecvMsg)localObject1;
      if (b((CharSequence)localObject1)) {
        paramRecvMsg = a((CharSequence)localObject1);
      }
      this.bm.setText(paramRecvMsg);
    }
  }
  
  private void b(GLVideoView paramGLVideoView, boolean paramBoolean)
  {
    GLAnimation localGLAnimation = new GLAnimation();
    localGLAnimation.b(50);
    localGLAnimation.b(0.0F, 0.0F, -90.0F, 0.0F, 0.0F, 0.0F);
    localGLAnimation.a(2);
    localGLAnimation.a(new VideoLayerUI.5(this));
    paramGLVideoView.a(localGLAnimation);
    paramGLVideoView.m();
  }
  
  private boolean b(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof QQText))
    {
      paramCharSequence = (EmoticonSpan[])((QQText)paramCharSequence).getSpans(0, paramCharSequence.length(), EmoticonSpan.class);
      int i = 0;
      while (i < paramCharSequence.length)
      {
        if (paramCharSequence[i].emojiType == 2) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private void c(int paramInt, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramInt == this.aK)) {
      return;
    }
    this.aK = paramInt;
    paramInt = au();
    if ((this.aK > paramInt) && (this.aS.a()))
    {
      this.aS.b(this.aK);
      this.aK = paramInt;
    }
    b(this.aK, paramBoolean);
    q(this.aK);
  }
  
  private void d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.aJ.size();
    paramInt3 = paramInt1 + this.M;
    paramInt4 = this.K + paramInt3;
    paramInt1 = 1;
    while (paramInt1 <= i)
    {
      ((GLView)this.aJ.get(paramInt1 - 1)).c(paramInt3, paramInt2, paramInt4, this.L + paramInt2);
      paramInt4 = this.K;
      paramInt3 += this.M + paramInt4;
      paramInt4 += paramInt3;
      paramInt1 += 1;
    }
    paramInt1 = this.K;
    paramInt2 = this.M;
    this.aQ = (i * (paramInt1 + paramInt2) + paramInt2);
  }
  
  private void d(long paramLong, Boolean paramBoolean)
  {
    int i = a("openSelfVideo", this.Y.getCurrentAccountUin(), 1);
    g(paramLong);
    if ((paramBoolean.booleanValue()) && (i > 0) && ((this.Z.k().g != 2) || (this.Z.k().G))) {
      c(0, i);
    }
  }
  
  private void e(String paramString, int paramInt)
  {
    Object localObject = this.U;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("closeVideoView[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], index[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    paramString = ImageView.ScaleType.CENTER_INSIDE;
    int n = this.Z.k().g;
    int i;
    int j;
    int m;
    float f1;
    int k;
    boolean bool1;
    if (paramInt == 0)
    {
      i = this.ae[0].K();
      float f2 = this.ae[0].J();
      j = this.ae[0].L();
      boolean bool2 = this.ae[0].N();
      m = i;
      f1 = f2;
      k = j;
      bool1 = bool2;
      if (n == 4)
      {
        paramString = this.ae[0].P();
        m = i;
        f1 = f2;
        k = j;
        bool1 = bool2;
      }
    }
    else
    {
      f1 = 0.0F;
      m = 0;
      k = 0;
      bool1 = false;
    }
    if ((n == 4) && (this.aj.b() == 3)) {
      i = 1;
    } else {
      i = 0;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      j = 1;
    } else {
      j = 0;
    }
    int i1;
    if ((i != 0) && (j != 0))
    {
      j = paramInt + 1;
      i = -1;
      while (j < this.ae.length)
      {
        if (this.ae[j].b() == 0) {
          i = j;
        }
        j += 1;
      }
      if (i != -1)
      {
        j = this.ae[paramInt].j();
        i1 = this.ae[i].j();
        this.ae[paramInt].c(i1);
        this.ae[i].c(j);
        localObject = this.ae[paramInt];
        this.ae[paramInt] = this.ae[i];
        this.ae[i] = localObject;
        ((GLVideoView)localObject).a("");
      }
      else
      {
        i = paramInt;
      }
      localObject = this.ae[i];
      ((GLVideoView)localObject).a(1);
      ((GLVideoView)localObject).b(null);
      ((GLVideoView)localObject).n(true);
      ((GLVideoView)localObject).l(false);
      ((GLVideoView)localObject).h(false);
      ((GLVideoView)localObject).m(true);
      ((GLVideoView)localObject).a(null, 0);
    }
    else
    {
      i = paramInt;
      while (i < this.ae.length)
      {
        if (i < this.ae.length - 1)
        {
          localObject = this.ae;
          j = i + 1;
          if (localObject[j].b() == 0)
          {
            i1 = this.ae[i].j();
            int i2 = this.ae[j].j();
            this.ae[i].c(i2);
            this.ae[j].c(i1);
            localObject = this.ae[i];
            this.ae[i] = this.ae[j];
            this.ae[j] = localObject;
            i = j;
            continue;
          }
        }
        localObject = this.ae[i];
        ((GLVideoView)localObject).a(1);
        ((GLVideoView)localObject).b(null);
        ((GLVideoView)localObject).n(true);
        ((GLVideoView)localObject).l(false);
        ((GLVideoView)localObject).h(false);
        ((GLVideoView)localObject).m(true);
        ((GLVideoView)localObject).a(null, 0);
        ((GLVideoView)localObject).a("");
      }
    }
    if (paramInt == 0)
    {
      this.ae[0].i(false);
      this.ae[0].m(m);
      this.ae[0].a(f1);
      this.ae[0].l(k);
      this.ae[0].k(bool1);
      if (n == 4) {
        if (this.ae[0].S() == 2) {
          this.ae[0].a(ImageView.ScaleType.CENTER_INSIDE);
        } else {
          this.ae[0].a(paramString);
        }
      }
    }
    c(false);
  }
  
  private boolean f(int paramInt1, int paramInt2)
  {
    if ((this.bh != 0L) && (System.currentTimeMillis() - this.bh < 1000L))
    {
      localObject1 = this.U;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("bigWindowToSmallWindowAnim, 大小窗正在切换中[");
      ((StringBuilder)localObject2).append(this.bh);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return false;
    }
    Object localObject1 = this.ae[paramInt2];
    ((GLVideoView)localObject1).a(Boolean.valueOf(false));
    ((GLVideoView)localObject1).a(0, 0, 0, 0);
    int i = ((GLVideoView)localObject1).j();
    ((GLVideoView)localObject1).c(1);
    float f1 = ((GLVideoView)localObject1).f().left;
    float f2 = ((GLVideoView)localObject1).f().top;
    Object localObject2 = super.e();
    GLAnimation localGLAnimation = new GLAnimation();
    localGLAnimation.b(100);
    localGLAnimation.a(f1, f2, 0.0F, -((Rect)localObject2).left, -((Rect)localObject2).top, 0.0F);
    localGLAnimation.a(((GLVideoView)localObject1).f().width(), ((GLVideoView)localObject1).f().height(), super.g() + ((Rect)localObject2).left + ((Rect)localObject2).right, super.h() + ((Rect)localObject2).top + ((Rect)localObject2).bottom);
    localGLAnimation.a(new VideoLayerUI.7(this, paramInt2, i, paramInt1));
    localGLAnimation.a(2);
    ((GLVideoView)localObject1).a(localGLAnimation);
    ((GLVideoView)localObject1).m();
    this.bh = System.currentTimeMillis();
    return true;
  }
  
  private void g(GLCanvas paramGLCanvas)
  {
    int i;
    if (paramGLCanvas.b() > paramGLCanvas.c()) {
      i = 1;
    } else {
      i = 0;
    }
    int j = AIOUtils.b(64.0F, this.X.getResources());
    int m = WTogetherUtil.a(this.X);
    int k = g() / 2;
    if (i != 0) {
      j = h() / 2;
    } else {
      j = j + m + WTogetherUtil.b() / 2;
    }
    paramGLCanvas.a(k, j, 0.0F);
    if (i != 0) {
      paramGLCanvas.a(0.0F, 0.0F, g(), h(), -16777216);
    } else {
      paramGLCanvas.a(0.0F, 0.0F, g(), WTogetherUtil.b() + 2, -16777216);
    }
    paramGLCanvas.a(-k, -j, 0.0F);
  }
  
  private boolean g(int paramInt1, int paramInt2)
  {
    long l = this.bh;
    Object localObject2 = Boolean.valueOf(false);
    if ((l != 0L) && (System.currentTimeMillis() - this.bh < 1000L))
    {
      localObject1 = this.U;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("bigWindowToSmallWindowAnim, 大小窗正在切换中[");
      ((StringBuilder)localObject2).append(this.bh);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return false;
    }
    Object localObject3 = this.ae[paramInt1];
    Object localObject1 = this.ae[paramInt2];
    ((GLVideoView)localObject3).a((Boolean)localObject2);
    ((GLVideoView)localObject3).a(0, 0, 0, 0);
    ((GLVideoView)localObject1).a((Boolean)localObject2);
    ((GLVideoView)localObject1).a(0, 0, 0, 0);
    int i = ((GLVideoView)localObject1).j();
    ((GLVideoView)localObject1).c(((GLVideoView)localObject3).j());
    localObject2 = ((GLVideoView)localObject1).f();
    localObject3 = ((GLVideoView)localObject3).f();
    GLAnimation localGLAnimation = new GLAnimation();
    localGLAnimation.b(300);
    localGLAnimation.a(((Rect)localObject2).left, ((Rect)localObject2).top, 0.0F, ((Rect)localObject3).left, ((Rect)localObject3).top, 0.0F);
    localGLAnimation.a(((Rect)localObject2).width(), ((Rect)localObject2).height(), ((Rect)localObject3).width(), ((Rect)localObject3).height());
    localGLAnimation.a(new VideoLayerUI.8(this, paramInt2, i, paramInt1));
    localGLAnimation.a(2);
    ((GLVideoView)localObject1).a(localGLAnimation);
    ((GLVideoView)localObject1).m();
    this.bh = System.currentTimeMillis();
    return true;
  }
  
  private void h(GLCanvas arg1)
  {
    synchronized (this.bf)
    {
      while (!this.bf.isEmpty())
      {
        Object localObject1 = (Runnable)this.bf.remove(0);
        if (localObject1 != null)
        {
          long l = System.currentTimeMillis();
          ((Runnable)localObject1).run();
          l = System.currentTimeMillis() - l;
          if (l >= 100L)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("event queue cost too long: ");
            ((StringBuilder)localObject1).append(l);
            QLog.d("GLLinearLayout", 1, ((StringBuilder)localObject1).toString());
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void h(boolean paramBoolean)
  {
    if ((this.ae[0] != null) && (this.ae[1] != null))
    {
      this.ae[0].f(paramBoolean);
      this.ae[1].f(paramBoolean);
    }
  }
  
  private boolean h(int paramInt1, int paramInt2)
  {
    if ((this.bh != 0L) && (System.currentTimeMillis() - this.bh < 1000L))
    {
      localObject = this.U;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sliderWindowBigToSmallAnimation, 大小窗正在切换中[");
      localStringBuilder.append(this.bh);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      return false;
    }
    Object localObject = this.ae[paramInt2];
    ((GLVideoView)localObject).a(Boolean.valueOf(false));
    ((GLVideoView)localObject).a(0, 0, 0, 0);
    b(new VideoLayerUI.9(this, paramInt1, paramInt2));
    m();
    this.bh = System.currentTimeMillis();
    return true;
  }
  
  private void i(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == this.aN) && (paramInt2 == this.aO)) {
      return;
    }
    if (paramInt1 < paramInt2)
    {
      this.aN = paramInt1;
      this.aO = paramInt2;
    }
    else
    {
      this.aO = 0;
      this.aN = 0;
    }
    OnVisiableItemChangeListener localOnVisiableItemChangeListener = this.aV;
    if (localOnVisiableItemChangeListener != null) {
      localOnVisiableItemChangeListener.a(this.aN, this.aO);
    }
  }
  
  private void i(GLCanvas paramGLCanvas)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void i(boolean paramBoolean)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.U;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("showMsgbox: show = ");
      ((StringBuilder)localObject2).append(paramBoolean);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (this.bj == null) {
      return;
    }
    Object localObject1 = this.X.getApplicationContext().getResources();
    int i = (int)(((Resources)localObject1).getDimension(2131296611) + ((Resources)localObject1).getDimension(2131296680));
    int j = (int)(((Resources)localObject1).getDimension(2131296614) + ((Resources)localObject1).getDimension(2131296683));
    int k = (int)(((Resources)localObject1).getDimension(2131296609) + ((Resources)localObject1).getDimension(2131296678));
    int m = (int)(((Resources)localObject1).getDimension(2131296613) + ((Resources)localObject1).getDimension(2131296682));
    this.bm.setPadding(i, j, k, m);
    this.bm.getBackground().setAlpha(128);
    if ((this.bj.isShown()) && (!paramBoolean))
    {
      localObject1 = new AlphaAnimation(1.0F, 0.0F);
      ((AlphaAnimation)localObject1).setDuration(1000L);
      ((AlphaAnimation)localObject1).setFillAfter(true);
      ((AlphaAnimation)localObject1).setAnimationListener(new VideoLayerUI.MsgboxAnimationListener(this, null));
      this.bj.startAnimation((Animation)localObject1);
      return;
    }
    if (paramBoolean)
    {
      localObject1 = new Transformation();
      ((Transformation)localObject1).setAlpha(0.0F);
      localObject2 = (AlphaAnimation)this.bj.getAnimation();
      if (localObject2 != null)
      {
        ((AlphaAnimation)localObject2).setAnimationListener(null);
        ((AlphaAnimation)localObject2).getTransformation(System.currentTimeMillis(), (Transformation)localObject1);
      }
      float f = ((Transformation)localObject1).getAlpha();
      this.bj.clearAnimation();
      localObject1 = new AlphaAnimation(f, 1.0F);
      ((AlphaAnimation)localObject1).setDuration(1000L);
      ((AlphaAnimation)localObject1).setFillAfter(true);
      ((AlphaAnimation)localObject1).setFillBefore(true);
      this.bj.startAnimation((Animation)localObject1);
      this.bj.setVisibility(0);
      this.bj.setTag(Long.valueOf(System.currentTimeMillis()));
    }
  }
  
  private VideoMemberInfo j(long paramLong)
  {
    VideoMemberInfo localVideoMemberInfo2 = (VideoMemberInfo)this.bb.get(Long.valueOf(paramLong));
    VideoMemberInfo localVideoMemberInfo1 = localVideoMemberInfo2;
    if (localVideoMemberInfo2 == null)
    {
      localVideoMemberInfo1 = new VideoMemberInfo();
      localVideoMemberInfo1.b = paramLong;
      this.bb.put(Long.valueOf(paramLong), localVideoMemberInfo1);
    }
    return localVideoMemberInfo1;
  }
  
  private void k(long paramLong)
  {
    if ((this.X != null) && (!this.P)) {
      ((AVActivity)this.X).K.I(paramLong);
    }
  }
  
  private void t(int paramInt)
  {
    if (!this.bi)
    {
      Object localObject1 = this.bj;
      if (localObject1 == null) {
        return;
      }
      localObject1 = (RelativeLayout.LayoutParams)((RotateLayout)localObject1).getLayoutParams();
      int k = this.X.getApplicationContext().getResources().getDimensionPixelSize(2131300023);
      int i = this.X.getApplicationContext().getResources().getDimensionPixelSize(2131300024);
      int m = this.X.getApplicationContext().getResources().getDimensionPixelSize(2131300018);
      int j = this.X.getApplicationContext().getResources().getDimensionPixelSize(2131300019);
      int n = this.X.getApplicationContext().getResources().getDimensionPixelSize(2131300017);
      if ((this.ac == 0) || (this.ab == 0))
      {
        i = k;
        j = m;
      }
      int i1 = an();
      Object localObject2;
      Object localObject3;
      if (i1 <= 0)
      {
        ((RelativeLayout.LayoutParams)localObject1).addRule(11, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(10, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(9, -1);
        ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = m;
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (j + this.ac);
        this.bj.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject2 = (RotateLayout.LayoutParams)this.bk.getLayoutParams();
        ((RotateLayout.LayoutParams)localObject2).a = 0;
        this.bk.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        j = this.aa.getWidth() - m * 2;
        k = this.br;
        i = j;
        if (j > k) {
          i = k;
        }
        this.bm.setMaxWidth(i);
      }
      else
      {
        if ((this.ac != 0) && (this.ab != 0)) {
          paramInt = 0;
        }
        localObject2 = this.ae[1].f();
        int i2 = ad();
        if (paramInt == 0)
        {
          ((RelativeLayout.LayoutParams)localObject1).addRule(11, 0);
          ((RelativeLayout.LayoutParams)localObject1).addRule(10, 0);
          ((RelativeLayout.LayoutParams)localObject1).addRule(9, -1);
          ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
          if (i1 == 1)
          {
            ((RelativeLayout.LayoutParams)localObject1).leftMargin = m;
            ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (j + this.ac);
          }
          else if (i1 == 2)
          {
            if (i2 == 4) {
              ((RelativeLayout.LayoutParams)localObject1).leftMargin = (((Rect)localObject2).width() + k + n);
            } else {
              ((RelativeLayout.LayoutParams)localObject1).leftMargin = m;
            }
            ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (j + this.ac);
          }
          else
          {
            ((RelativeLayout.LayoutParams)localObject1).leftMargin = m;
            ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (j + this.ac + ((Rect)localObject2).height());
          }
        }
        else if (paramInt == 90)
        {
          ((RelativeLayout.LayoutParams)localObject1).addRule(10, 0);
          ((RelativeLayout.LayoutParams)localObject1).addRule(9, 0);
          ((RelativeLayout.LayoutParams)localObject1).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
          if (i1 == 1)
          {
            ((RelativeLayout.LayoutParams)localObject1).rightMargin = m;
            ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (j + this.ac);
          }
          else if (i1 >= 2)
          {
            if (i2 == 3) {
              ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (((Rect)localObject2).height() + i + n + this.ac);
            } else {
              ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (j + this.ac);
            }
            ((RelativeLayout.LayoutParams)localObject1).rightMargin = m;
          }
        }
        else if (paramInt == 180)
        {
          ((RelativeLayout.LayoutParams)localObject1).addRule(9, 0);
          ((RelativeLayout.LayoutParams)localObject1).addRule(12, 0);
          ((RelativeLayout.LayoutParams)localObject1).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject1).addRule(10, -1);
          if (i1 == 1)
          {
            ((RelativeLayout.LayoutParams)localObject1).rightMargin = m;
            ((RelativeLayout.LayoutParams)localObject1).topMargin = (j + this.ab);
          }
          else if (i1 == 2)
          {
            if (i2 == 2) {
              ((RelativeLayout.LayoutParams)localObject1).rightMargin = (((Rect)localObject2).width() + k + n);
            } else {
              ((RelativeLayout.LayoutParams)localObject1).rightMargin = m;
            }
            ((RelativeLayout.LayoutParams)localObject1).topMargin = (j + this.ab);
          }
          else
          {
            ((RelativeLayout.LayoutParams)localObject1).rightMargin = m;
            if (i2 == 2) {
              ((RelativeLayout.LayoutParams)localObject1).topMargin = (j + this.ab + ((Rect)localObject2).height());
            } else {
              ((RelativeLayout.LayoutParams)localObject1).topMargin = (j + this.ab);
            }
          }
        }
        else if (paramInt == 270)
        {
          ((RelativeLayout.LayoutParams)localObject1).addRule(11, 0);
          ((RelativeLayout.LayoutParams)localObject1).addRule(12, 0);
          ((RelativeLayout.LayoutParams)localObject1).addRule(10, -1);
          ((RelativeLayout.LayoutParams)localObject1).addRule(9, -1);
          if (i1 == 1)
          {
            ((RelativeLayout.LayoutParams)localObject1).leftMargin = m;
            ((RelativeLayout.LayoutParams)localObject1).topMargin = (j + this.ab);
          }
          else if (i1 >= 2)
          {
            if (i2 == 1) {
              ((RelativeLayout.LayoutParams)localObject1).topMargin = (((Rect)localObject2).height() + i + n + this.ab);
            } else {
              ((RelativeLayout.LayoutParams)localObject1).topMargin = (j + this.ab);
            }
            ((RelativeLayout.LayoutParams)localObject1).leftMargin = m;
          }
        }
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin += this.bs;
        this.bj.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        if (QLog.isDevelopLevel())
        {
          localObject3 = this.U;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setLayoutParams, [");
          localStringBuilder.append(((RelativeLayout.LayoutParams)localObject1).leftMargin);
          localStringBuilder.append(", ");
          localStringBuilder.append(((RelativeLayout.LayoutParams)localObject1).topMargin);
          localStringBuilder.append(", ");
          localStringBuilder.append(((RelativeLayout.LayoutParams)localObject1).rightMargin);
          localStringBuilder.append(", ");
          localStringBuilder.append(((RelativeLayout.LayoutParams)localObject1).bottomMargin);
          localStringBuilder.append("]");
          QLog.d((String)localObject3, 4, localStringBuilder.toString());
        }
        localObject3 = (RotateLayout.LayoutParams)this.bk.getLayoutParams();
        ((RotateLayout.LayoutParams)localObject3).a = paramInt;
        this.bk.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = super.f();
        if (i1 == 1) {
          i = ((Rect)localObject3).width() - m * 2;
        } else {
          i = ((Rect)localObject3).width() - ((Rect)localObject2).width() - k - m - n;
        }
        k = this.br;
        j = i;
        if (i > k) {
          j = k;
        }
        this.bm.setMaxWidth(j);
      }
      if (QLog.isDevelopLevel())
      {
        localObject2 = this.U;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("setMsgboxLayout, orientation[");
        ((StringBuilder)localObject3).append(paramInt);
        ((StringBuilder)localObject3).append("], leftMargin[");
        ((StringBuilder)localObject3).append(((RelativeLayout.LayoutParams)localObject1).leftMargin);
        ((StringBuilder)localObject3).append("], topMargin[");
        ((StringBuilder)localObject3).append(((RelativeLayout.LayoutParams)localObject1).topMargin);
        ((StringBuilder)localObject3).append("], rightMargin[");
        ((StringBuilder)localObject3).append(((RelativeLayout.LayoutParams)localObject1).rightMargin);
        ((StringBuilder)localObject3).append("], bottomMargin[");
        ((StringBuilder)localObject3).append(((RelativeLayout.LayoutParams)localObject1).bottomMargin);
        ((StringBuilder)localObject3).append("], mMsgLayout[");
        ((StringBuilder)localObject3).append(this.bj.getWidth());
        ((StringBuilder)localObject3).append(", ");
        ((StringBuilder)localObject3).append(this.bj.getHeight());
        ((StringBuilder)localObject3).append("]");
        QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
      }
    }
  }
  
  private void u(int paramInt)
  {
    if (paramInt > 0)
    {
      int i = 0;
      if (paramInt == 2) {
        i = 2131893246;
      }
      if ((i != 0) && (this.Y != null)) {
        TipsUtil.a(this.Y, 1008, i);
      }
    }
  }
  
  protected void A()
  {
    super.A();
    this.ad.post(new VideoLayerUI.1(this));
    this.am.a(this.ad);
  }
  
  public int B()
  {
    return this.aj.b();
  }
  
  public VideoSink D()
  {
    return this.am;
  }
  
  public void E()
  {
    if (this.bg != null)
    {
      this.Z.t.d();
      this.bg = null;
    }
    this.Y.a().removeCallbacks(this.bo);
    this.Y.a().removeCallbacks(this.bp);
    this.Y.a().removeCallbacks(this.N);
    this.bo = null;
    this.bp = null;
    this.bn.clear();
    this.bn = null;
    this.bj = null;
    this.bk = null;
    this.bl = null;
    this.bm = null;
    this.bn = null;
    a(null);
    this.aA = null;
    this.I = null;
    this.aB = null;
    this.aC = null;
    this.N = null;
    if (this.S != null)
    {
      if ((this.X instanceof AVActivity))
      {
        localObject = (AVActivity)this.X;
        this.S.b(((AVActivity)localObject).y);
      }
      this.S = null;
    }
    int k = this.aY;
    int j = 1;
    int i = j;
    if (k != -1)
    {
      i = j;
      if (k != 2) {
        if (k == 1) {
          i = j;
        } else {
          i = 0;
        }
      }
    }
    if (i == 0)
    {
      if (this.aj.b() == 3) {
        localObject = "1";
      } else {
        localObject = "2";
      }
      ReportController.b(null, "CliOper", "", "", "0X8009F5D", "0X8009F5D", 0, 0, (String)localObject, "", "", "");
    }
    if (this.aj != null)
    {
      this.aj.a();
      this.aj = null;
    }
    aj();
    Object localObject = this.aZ;
    if (localObject != null) {
      ((VideoTalkMemberManager)localObject).c();
    }
    this.bb.clear();
    if (this.am != null)
    {
      this.am.e();
      this.am = null;
    }
    if (this.an != null)
    {
      this.an.a();
      this.an = null;
    }
    super.E();
  }
  
  public int F()
  {
    return this.T;
  }
  
  public void G()
  {
    super.G();
    t(this.au);
  }
  
  public void H()
  {
    if (this.ad != null) {
      this.ad.onResume();
    }
  }
  
  public void I()
  {
    int i = 0;
    while (i < this.ae.length)
    {
      this.ae[i].y();
      i += 1;
    }
  }
  
  boolean J()
  {
    return Utils.a(this.X) == 2;
  }
  
  public void K()
  {
    ThreadManager.post(this.ap, 8, null, false);
  }
  
  boolean L()
  {
    boolean bool3 = this.X instanceof AVActivity;
    boolean bool1 = false;
    boolean bool2 = false;
    if (bool3)
    {
      bool3 = ((AVActivity)this.X).i();
      boolean bool4 = Y() ^ true;
      bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (bool4) {
          bool1 = true;
        }
      }
      String str = this.U;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SwitchLocalToBigView:");
      localStringBuilder.append(bool3);
      localStringBuilder.append("|");
      localStringBuilder.append(bool4);
      AVLog.printColorLog(str, localStringBuilder.toString());
    }
    return bool1;
  }
  
  boolean M()
  {
    String str = this.Y.getCurrentAccountUin();
    int i = 0;
    while (i < this.ae.length)
    {
      GLVideoView localGLVideoView = this.ae[i];
      if ((localGLVideoView.b() == 0) && (str.equals(localGLVideoView.R()))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  boolean N()
  {
    return ((this.ac == 0) || (this.ab == 0) || (this.ab == this.J) || (this.P)) && (this.aj.b() != 6);
  }
  
  protected void O()
  {
    this.bi = false;
    t(this.au);
  }
  
  AVActivity P()
  {
    if ((this.X instanceof AVActivity)) {
      return (AVActivity)this.X;
    }
    return null;
  }
  
  void Q()
  {
    int i = this.Z.k().g;
    if ((this.Y.d(0)) && (i == 2))
    {
      R();
      this.S.a();
    }
  }
  
  void R()
  {
    if (this.S == null) {
      this.S = new ZimuViewProxy(this.Y, this.X);
    }
  }
  
  public int a(float paramFloat)
  {
    int i = Math.round(paramFloat) + this.aP;
    if (i < 0) {
      return -1;
    }
    return i / (this.K + this.M);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (am()) {
      this.am.a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((!this.V) && (!Z()))
    {
      this.as = paramInt;
      return;
    }
    if ((paramInt == this.ar) && (paramInt != this.as)) {
      return;
    }
    int i = this.ar;
    boolean bool = false;
    if (paramInt % 90 != i % 90) {
      this.ag = 0;
    }
    this.ar = paramInt;
    this.as = paramInt;
    i = a(this.U, this.X, paramInt, paramBoolean, this.av);
    if ((paramInt == 0) || (paramInt == 90) || (paramInt == 180) || (paramInt == 270))
    {
      paramInt = 0;
      while (paramInt < super.t())
      {
        super.h(paramInt).b(i);
        paramInt += 1;
      }
      t(i);
      this.au = i;
    }
    if (this.Z.k().o == 2)
    {
      if (this.au != 0)
      {
        paramBoolean = bool;
        if (this.au != 180) {}
      }
      else
      {
        paramBoolean = true;
      }
      c(paramBoolean);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int i = 1;
    if (bool)
    {
      localObject = this.U;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyControlUIOffset, mTopOffset[");
      localStringBuilder.append(this.ab);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], mBottomOffset[");
      localStringBuilder.append(this.ac);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], mFullScreen[");
      localStringBuilder.append(this.P);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    this.P = paramBoolean;
    this.ab = paramInt1;
    this.ac = paramInt2;
    c(true);
    t(this.au);
    if (this.Z.k().g == 4)
    {
      paramInt1 = 0;
      while (paramInt1 < this.ae.length)
      {
        this.ae[paramInt1].k(true);
        paramInt1 += 1;
      }
      if (this.Z.k().bi.size() <= 1) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if (this.Z.k().bM == 4) {
        paramInt2 = i;
      } else {
        paramInt2 = 0;
      }
      if ((!P().K.ab()) && ((paramInt1 != 0) || (paramInt2 != 0))) {
        this.ae[0].k(false);
      }
    }
    Object localObject = this.S;
    if (localObject != null) {
      ((ZimuViewProxy)localObject).a(this, this.ab, this.ac);
    }
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    this.bd = a("notifyGLVideoViewChange", String.valueOf(paramLong1), paramInt1);
    this.be = a("notifyGLVideoViewChange", String.valueOf(paramLong2), paramInt2);
    b(new VideoLayerUI.2(this, this.bd, this.be));
  }
  
  void a(long paramLong, GLVideoView paramGLVideoView, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramGLVideoView != null)
    {
      String str = a(paramString, paramInt);
      paramGLVideoView.a(paramString, paramInt);
      paramGLVideoView.a(0);
      paramGLVideoView.a(this.Y.getCurrentAccountUin());
      try
      {
        YUVTexture localYUVTexture = paramGLVideoView.B();
        GraphicRenderMgr.getInstance().setAccountUin(this.Y.getCurrentAccountUin());
        GraphicRenderMgr.setGlRender(str, localYUVTexture);
        str = this.U;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setGlRender[initGLVideoViewBasePara], key[");
        localStringBuilder.append(LogUtil.getSafePrintUin(paramString));
        localStringBuilder.append("], debug[");
        localStringBuilder.append(paramGLVideoView.T());
        localStringBuilder.append("], videoSrcType[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("], yuvTexture[");
        localStringBuilder.append(localYUVTexture);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
        this.Z.a(paramLong, this.Z.k().g, false, paramBoolean);
        return;
      }
      catch (UnsatisfiedLinkError paramGLVideoView)
      {
        paramGLVideoView.printStackTrace();
      }
    }
  }
  
  public void a(long paramLong, Boolean paramBoolean)
  {
    String str = this.Y.getCurrentAccountUin();
    c(paramLong);
    int i = a("openSelfScreenShare", str, 2);
    if ((paramBoolean.booleanValue()) && (i > 0)) {
      c(0, i);
    }
  }
  
  void a(long paramLong, String paramString, int paramInt)
  {
    int i = a("closePeerVideo", paramString, paramInt);
    if (i >= 0)
    {
      String str = a(paramString, paramInt);
      GraphicRenderMgr.getInstance().flushGlRender(str);
      GraphicRenderMgr.setGlRender(str, null);
      str = this.U;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGlRender[closePeerVideo_no], key[");
      localStringBuilder.append(LogUtil.getSafePrintUin(paramString));
      localStringBuilder.append("_");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], index[");
      localStringBuilder.append(i);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      this.Z.a(paramLong, this.Z.k().g, true, true);
      if (this.ae[i].z())
      {
        this.ae[i].a(paramLong, false);
        return;
      }
      e("closePeerVideo", i);
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i = a("setBackground", paramString, paramInt);
    int k = 1;
    int j = i;
    Object localObject;
    if (i < 0)
    {
      i = r(0);
      if (i >= 0)
      {
        boolean bool = paramString.equals(this.Y.getCurrentAccountUin()) ^ true;
        localObject = this.ae[i];
        a(paramLong, (GLVideoView)localObject, paramString, paramInt, bool);
        if ((localObject != null) && (!bool)) {
          ((GLVideoView)localObject).a(paramLong, CameraUtils.a(this.X).isFrontCamera());
        }
      }
      if ((paramBoolean2) && (i > 0))
      {
        c(0, i);
        i = 0;
      }
      j = i;
      if (i > 0) {}
    }
    else
    {
      k = 0;
      i = j;
    }
    if (i >= 0)
    {
      localObject = this.ae[i];
      ((GLVideoView)localObject).a(paramBitmap);
      ((GLVideoView)localObject).n(paramBoolean1);
      if (!paramBoolean1) {
        ((GLVideoView)localObject).l(false);
      }
    }
    if (k != 0) {
      p(i);
    }
    if (QLog.isColorLevel())
    {
      paramBitmap = this.U;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setBackground uin: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", videoSrcType: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", index: ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", needRenderVideo: ");
      ((StringBuilder)localObject).append(paramBoolean1);
      QLog.d(paramBitmap, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  void a(long paramLong, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("openPeerVideo, seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    int i = a(((StringBuilder)localObject).toString(), paramString, paramInt);
    boolean bool1;
    if (b(this.Z.k()))
    {
      if ((!paramBoolean1) && (!Y())) {
        bool1 = true;
      } else {
        bool1 = paramBoolean1;
      }
      if (i > 1)
      {
        SmallScreenUtils.a();
        paramString = this.U;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("SetGlRender index break!!!!!! index=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", remotehasvideo=");
        ((StringBuilder)localObject).append(this.Z.k().I);
        QLog.e(paramString, 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    else
    {
      bool1 = paramBoolean1;
    }
    String str = a(paramString, paramInt);
    if (i < 0)
    {
      i = r(0);
      if (i >= 0)
      {
        localObject = this.ae[i];
        a(paramLong, (GLVideoView)localObject, paramString, paramInt, true);
        paramString = (String)localObject;
      }
      else
      {
        paramString = null;
      }
      if ((paramString != null) && (this.Z.k().bi.size() <= 1) && (this.Z.k().g == 4)) {
        paramString.a(AIOUtils.b(18.0F, this.X.getResources()));
      }
      paramInt = i;
      localObject = paramString;
      if (i > 1)
      {
        paramInt = i;
        localObject = paramString;
        if (this.Z.k().g == 4)
        {
          paramInt = 1;
          break label484;
        }
      }
    }
    else
    {
      localObject = this.ae[i];
      GraphicRenderMgr.setGlRender(str, ((GLVideoView)localObject).B());
      str = this.U;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGlRender[openPeerVideo], key[");
      localStringBuilder.append(LogUtil.getSafePrintUin(paramString));
      localStringBuilder.append("_");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], index[");
      localStringBuilder.append(i);
      localStringBuilder.append("], ");
      localStringBuilder.append(((GLVideoView)localObject).T());
      QLog.w(str, 1, localStringBuilder.toString());
      this.Z.a(paramLong, this.Z.k().g, false, true);
      paramInt = i;
    }
    int j = 0;
    paramString = (String)localObject;
    i = paramInt;
    paramInt = j;
    label484:
    if (paramString != null)
    {
      boolean bool2;
      if (this.Z.k().bi.size() > 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      paramString.h(paramBoolean2);
      if (!paramString.z()) {
        paramString.a(paramLong, this.aj.e());
      }
      paramString.l(paramBoolean1 ^ true);
      paramString.a(0);
      if (this.Z.k().g == 4)
      {
        if (i == 0)
        {
          paramString.a(ImageView.ScaleType.CENTER_INSIDE);
          if (this.Z.k().bM == 3) {
            paramString.i(bool2);
          }
        }
        else
        {
          paramString.a(ImageView.ScaleType.CENTER_CROP);
        }
      }
      else if (this.Z.k().g == 2) {
        paramString.a(ImageView.ScaleType.CENTER_INSIDE);
      }
    }
    if ((bool1) && (i > 0) && (!L()) && ((this.Z.k().g != 2) || (this.Z.k().G))) {
      c(0, i);
    }
    if (paramInt != 0) {
      p(i);
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel())
    {
      String str = this.U;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setRemoteHasVideo, uin[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], videoSrcType[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], isRemoteHasVideo[");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append("], forceToBigView[");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append("], mIsLocalHasVideo[");
      localStringBuilder.append(this.V);
      localStringBuilder.append("], isFillBlackEdge[");
      localStringBuilder.append(paramBoolean3);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.Y.getCurrentAccountUin())))
    {
      if (!J()) {
        return;
      }
      ab();
      if (paramBoolean1) {
        a(paramLong, paramString, paramInt, paramBoolean2, paramBoolean3);
      } else {
        a(paramLong, paramString, paramInt);
      }
      if ((this.S != null) && (!M())) {
        a(paramBoolean1, paramLong);
      }
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  void a(View.OnClickListener paramOnClickListener)
  {
    if (this.bj == null) {
      ap();
    }
    TextView localTextView = this.bm;
    if (localTextView != null) {
      localTextView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    QLog.w(this.U, 1, "tryRegisterMemmberChangeListener");
    paramSessionInfo.a(this.aZ);
  }
  
  protected void a(GLCanvas paramGLCanvas, boolean paramBoolean)
  {
    if (al())
    {
      i(paramGLCanvas);
      return;
    }
    this.o = 0;
    this.n = 0;
    this.aK = 0;
    this.aL = 0;
    super.a(paramGLCanvas, paramBoolean);
  }
  
  void a(RecvMsg paramRecvMsg)
  {
    if (this.Z.k().p == 1011) {
      return;
    }
    String str1 = paramRecvMsg.c();
    String str2 = paramRecvMsg.a();
    String str3 = paramRecvMsg.b();
    String str4 = paramRecvMsg.d();
    if (QLog.isColorLevel())
    {
      String str5 = this.U;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceiveMsg friendUin: ");
      localStringBuilder.append(str1);
      localStringBuilder.append(", senderUin: ");
      localStringBuilder.append(str2);
      localStringBuilder.append(", senderName: ");
      localStringBuilder.append(str3);
      localStringBuilder.append(", msg: ");
      localStringBuilder.append(str4);
      QLog.d(str5, 2, localStringBuilder.toString());
    }
    if (str2.equals(this.Y.getCurrentAccountUin())) {
      return;
    }
    if (this.bj == null) {
      ap();
    }
    if (this.bj.isShown())
    {
      if (System.currentTimeMillis() - ((Long)this.bj.getTag()).longValue() >= 3000L)
      {
        this.Y.a().removeCallbacks(this.bo);
        this.Y.a().removeCallbacks(this.bp);
        b(paramRecvMsg);
        this.Y.a().postDelayed(this.bo, 3000L);
        this.Y.a().postDelayed(this.bp, 3000L);
        return;
      }
      this.bn.add(paramRecvMsg);
      return;
    }
    this.Y.a().removeCallbacks(this.bo);
    this.Y.a().removeCallbacks(this.bp);
    b(paramRecvMsg);
    this.Y.a().postDelayed(this.bo, 3000L);
    this.Y.a().postDelayed(this.bp, 3000L);
  }
  
  public void a(AVActivity.AnimationTrigger paramAnimationTrigger)
  {
    this.Q = paramAnimationTrigger;
  }
  
  void a(ControlUIObserver.ZimuRequest paramZimuRequest)
  {
    R();
    String str = paramZimuRequest.c;
    long l = paramZimuRequest.a();
    if ((this.S.a(paramZimuRequest.a(), str, (ViewGroup)this.aa, this.ab, this.ac)) && ((this.X instanceof AVActivity))) {
      ((AVActivity)this.X).h(l);
    }
  }
  
  protected void a(Integer paramInteger, Object paramObject)
  {
    String str = this.U;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyEvent :");
    localStringBuilder.append(paramInteger);
    localStringBuilder.append("|");
    localStringBuilder.append(paramObject);
    AVLog.printColorLog(str, localStringBuilder.toString());
    this.Y.a(new Object[] { paramInteger, paramObject });
  }
  
  void a(String paramString)
  {
    if (this.aj.b() != 2)
    {
      String str = this.Y.getCurrentAccountUin();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchLocalView_");
      localStringBuilder.append(paramString);
      a(localStringBuilder.toString(), str);
    }
  }
  
  void a(String paramString1, int paramInt1, String paramString2, float paramFloat, int paramInt2)
  {
    int i = a("setText", paramString1, paramInt1);
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    if (bool2)
    {
      String str = this.U;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setText, uin[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("], videoSrcType[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], text[");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("], textSize[");
      localStringBuilder.append(paramFloat);
      localStringBuilder.append("], textColor[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], index[");
      localStringBuilder.append(i);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (i >= 0)
    {
      paramString1 = this.ae[i];
      paramString1.a(0);
      paramString1.b(paramString2);
      paramString1.a(paramFloat);
      paramString1.m(paramInt2);
      if (B() == 3)
      {
        if ((i <= 0) && (this.Z.k().bi.size() <= 1)) {
          paramString1.a(AIOUtils.b(18.0F, this.X.getResources()));
        }
      }
      else {
        while (i == 0)
        {
          bool1 = false;
          break;
        }
      }
      paramString1.i(bool1);
      if (i == 0)
      {
        if (this.Z.k().o == 2)
        {
          paramString1.b("");
          return;
        }
        paramString1.l(12);
        return;
      }
      if (c(this.Z.k()))
      {
        paramString1.l(12);
        return;
      }
      paramString1.l(2147483647);
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    String str = this.U;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enablePeerAvatar2D enable=");
    localStringBuilder.append(paramBoolean);
    QLog.d(str, 1, localStringBuilder.toString());
    long l = AudioHelper.c();
    int j = a("enableAvatar2D", paramString, paramInt);
    int i = j;
    if (j < 0)
    {
      j = r(0);
      i = j;
      if (j >= 0)
      {
        a(l, this.ae[j], paramString, paramInt, true);
        i = j;
      }
    }
    if (i >= 0)
    {
      paramString = this.ae[i];
      paramString.a(l, false);
      paramString.c(paramBoolean);
      paramString.m();
    }
    if (i > 0) {
      c(0, i);
    }
  }
  
  public void a(ArrayList<VideoController.GAudioFriends> paramArrayList)
  {
    QLog.w(this.U, 1, "notifyAudioMemberChange");
    VideoTalkMemberManager localVideoTalkMemberManager = this.aZ;
    if (localVideoTalkMemberManager != null) {
      localVideoTalkMemberManager.a(paramArrayList);
    }
  }
  
  protected void a(Observable paramObservable, Object paramObject)
  {
    paramObservable = (Object[])paramObject;
    int i = ((Integer)paramObservable[0]).intValue();
    if (i != 6005)
    {
      if (i != 6008)
      {
        if (i != 6010)
        {
          if (i != 6013)
          {
            if (i != 6501) {
              return;
            }
            if ((this.S != null) && (this.Y.d(0))) {
              this.S.a(true);
            }
          }
          else
          {
            c(true);
          }
        }
        else
        {
          R();
          u(((Integer)paramObservable[1]).intValue());
        }
      }
      else
      {
        R();
        paramObservable = (SentenceInfo)paramObservable[1];
        this.S.a(paramObservable);
      }
    }
    else {
      b((ControlUIObserver.ZimuRequest)ControlUIObserver.a(paramObservable));
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!J()) {
      return false;
    }
    if (paramBoolean1) {
      a(paramLong, Boolean.valueOf(paramBoolean2));
    } else {
      d(paramLong);
    }
    this.W = paramBoolean1;
    return true;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    int i = a("setVideoToBigView", paramString2, 1);
    boolean bool = false;
    if (i > 0) {
      bool = c(0, i);
    }
    if (QLog.isDevelopLevel())
    {
      String str = this.U;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setVideoToBigView[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("], uin[");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("], index[");
      localStringBuilder.append(i);
      localStringBuilder.append("], bRet[");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.d(str, 1, localStringBuilder.toString());
    }
    return bool;
  }
  
  public boolean a(String paramString, byte[] paramArrayOfByte)
  {
    boolean bool = true;
    int i = a("enableAvatar2D", paramString, 1);
    if (i < 0)
    {
      a(paramString, 1, true);
      i = a("enableAvatar2D", paramString, 1);
    }
    else
    {
      bool = false;
    }
    this.ae[i].a(paramArrayOfByte);
    if ((this.al == null) || (!this.al.c())) {
      this.ae[i].m();
    }
    return bool;
  }
  
  public VideoMemberInfo b(long paramLong)
  {
    return (VideoMemberInfo)this.bb.get(Long.valueOf(paramLong));
  }
  
  void b(long paramLong, Boolean paramBoolean)
  {
    ThreadManager.post(this.ap, 8, null, false);
    d(paramLong, paramBoolean);
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  void b(ControlUIObserver.ZimuRequest paramZimuRequest)
  {
    boolean bool2 = QLog.isDevelopLevel();
    boolean bool1 = true;
    Object localObject;
    if (bool2)
    {
      localObject = this.U;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestZimu, mHandle[");
      localStringBuilder.append(paramZimuRequest.b);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramZimuRequest.a());
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    if (paramZimuRequest.b == 2)
    {
      if ((this.S != null) && (this.Y.d(0)))
      {
        this.S.a((ViewGroup)this.aa, paramZimuRequest.a());
        if ((this.X instanceof AVActivity)) {
          ((AVActivity)this.X).h(paramZimuRequest.a());
        }
      }
    }
    else
    {
      if (paramZimuRequest.b == 1)
      {
        a(paramZimuRequest);
        return;
      }
      if ((paramZimuRequest.b != 3) && (paramZimuRequest.b != 4))
      {
        if (paramZimuRequest.b == 5)
        {
          localObject = this.S;
          if (localObject != null) {
            ((ZimuViewProxy)localObject).a(paramZimuRequest.a());
          }
        }
      }
      else if (this.Y.d(0))
      {
        R();
        if (paramZimuRequest.b != 3) {
          bool1 = false;
        }
        if ((this.S.a(paramZimuRequest.a(), (ViewGroup)this.aa, bool1)) && ((this.X instanceof AVActivity))) {
          ((AVActivity)this.X).h(paramZimuRequest.a());
        }
      }
    }
  }
  
  public void b(Runnable paramRunnable)
  {
    synchronized (this.bf)
    {
      this.bf.add(paramRunnable);
      return;
    }
  }
  
  public boolean b(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!J()) {
      return false;
    }
    if (paramBoolean1) {
      b(paramLong, Boolean.valueOf(paramBoolean2));
    } else {
      f(paramLong);
    }
    this.V = paramBoolean1;
    if ((this.S != null) && (!Z())) {
      a(paramBoolean1, paramLong);
    }
    return true;
  }
  
  boolean b(String paramString, int paramInt)
  {
    return a("hasVideoView", paramString, paramInt) >= 0;
  }
  
  public void c(long paramLong)
  {
    Object localObject2 = this.Y.getCurrentAccountUin();
    int i = a("openSelfScreenShareRender", (String)localObject2, 2);
    if (i < 0)
    {
      int j = r(0);
      if (j >= 0)
      {
        localObject1 = this.ae[j];
        b(paramLong, (GLVideoView)localObject1, (String)localObject2, 2, true);
      }
      else
      {
        localObject1 = null;
      }
      i = j;
      localObject2 = localObject1;
      if (j == 0)
      {
        i = j;
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          i = j;
          localObject2 = localObject1;
          if (this.Z.k().g == 4)
          {
            ((GLVideoView)localObject1).i(false);
            i = j;
            localObject2 = localObject1;
          }
        }
      }
    }
    else
    {
      localObject1 = a((String)localObject2, 2);
      localObject2 = this.ae[i];
      if (QLog.isDebugVersion())
      {
        localObject3 = this.U;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setGlRender[openSelfScreenShareRender], key[");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("], index[");
        localStringBuilder.append(i);
        localStringBuilder.append("], forceToBigView[");
        localStringBuilder.append(false);
        localStringBuilder.append("], ");
        localStringBuilder.append(((GLVideoView)localObject2).T());
        QLog.w((String)localObject3, 1, localStringBuilder.toString());
      }
    }
    Object localObject1 = this.U;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("setGlRender[openSelfScreenShareRender], index:=");
    ((StringBuilder)localObject3).append(i);
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject3).toString());
    if (localObject2 != null)
    {
      ((GLVideoView)localObject2).h(false);
      ((GLVideoView)localObject2).l(false);
      ((GLVideoView)localObject2).n(true);
      ((GLVideoView)localObject2).a(0);
      ((GLVideoView)localObject2).a(ImageView.ScaleType.CENTER_CROP);
    }
  }
  
  public void c(long paramLong, Boolean paramBoolean)
  {
    if (!J()) {
      return;
    }
    this.V = true;
    d(paramLong, paramBoolean);
  }
  
  public void c(boolean paramBoolean)
  {
    long l = AudioHelper.c();
    int i = super.g();
    int j = super.h();
    SessionInfo localSessionInfo = this.Z.k();
    if (b(localSessionInfo))
    {
      this.aj.a(this.ae, i, j, this.at, this.ab, this.ac, localSessionInfo.B ^ true);
    }
    else if (c(localSessionInfo))
    {
      this.aj.a(this.ac, this.aG, this.aH, this.bb);
      this.aj.a(localSessionInfo, this.ae, i, j, paramBoolean, this.au, this.ac);
      new ControlUIObserver.ZimuRequest(l, "layoutVideoView", 5, null).a(this.Y);
    }
    super.m();
  }
  
  protected boolean c(int paramInt1, int paramInt2)
  {
    String str1;
    if (QLog.isColorLevel())
    {
      str1 = this.ae[paramInt1].R();
      String str2 = this.ae[paramInt2].R();
      String str3 = this.U;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchVideo, begin, [");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("]=[");
      localStringBuilder.append(str1);
      localStringBuilder.append("], [");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("]=[");
      localStringBuilder.append(str2);
      localStringBuilder.append("]");
      QLog.w(str3, 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
    }
    if ((paramInt1 != paramInt2) && (paramInt1 >= 0) && (paramInt1 < this.ae.length) && (paramInt2 >= 0) && (paramInt2 < this.ae.length))
    {
      if (paramInt2 == 0)
      {
        d(paramInt1, paramInt2);
        return true;
      }
      if (this.Z.k().g == 4)
      {
        if (paramInt1 == 0) {
          this.ae[paramInt2].a(ImageView.ScaleType.CENTER_INSIDE);
        } else if (paramInt2 == 0) {
          this.ae[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
        }
        str1 = this.Y.getCurrentAccountUin();
        this.ae[paramInt1].R();
        if (str1.equals(this.ae[paramInt2].R())) {
          this.ae[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
        }
      }
      if ((this.aj != null) && (this.aj.b() == 3)) {
        return g(paramInt1, paramInt2);
      }
      if ((this.aj != null) && (this.aj.b() == 4)) {
        return h(paramInt1, paramInt2);
      }
      return f(paramInt1, paramInt2);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.U, 2, "switchVideo index invalid!");
    }
    return false;
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    VideoLayerUI.MyExploreByTouchHelper localMyExploreByTouchHelper = this.bu;
    return (localMyExploreByTouchHelper != null) && (localMyExploreByTouchHelper.dispatchHoverEvent(paramMotionEvent));
  }
  
  public void d(long paramLong)
  {
    String str1 = this.Y.getCurrentAccountUin();
    int i = a("closeSelfScreenShare", str1, 2);
    if (i >= 0)
    {
      str1 = a(LogUtil.getSafePrintUin(str1), 2);
      String str2 = this.U;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGlRender[closeSelfVideo_no], key[");
      localStringBuilder.append(str1);
      localStringBuilder.append("], index[");
      localStringBuilder.append(i);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str2, 1, localStringBuilder.toString());
      e(paramLong);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if ((this.ae[0] != null) && (this.ae[1] != null))
    {
      this.aj.a(paramBoolean);
      c(true);
    }
  }
  
  public void e(long paramLong)
  {
    int i = a("closeSelfScreenShareRender", this.Y.getCurrentAccountUin(), 2);
    if (i >= 0) {
      e("closeSelfScreenShareRender", i);
    }
  }
  
  protected void e(GLCanvas paramGLCanvas)
  {
    if (am())
    {
      int i = paramGLCanvas.b();
      int k = paramGLCanvas.c();
      int j = 1;
      if (i > k) {
        i = 1;
      } else {
        i = 0;
      }
      ak();
      if ((i == 0) && (this.ao != null))
      {
        k = g() / 2;
        int m = h() / 2;
        paramGLCanvas.a(k, m, 0.0F);
        paramGLCanvas.a(0.0F, 0.0F, g(), h(), Color.parseColor("#1E1F22"));
        float f1 = this.ao.w().getWidth();
        float f2 = this.ao.w().getHeight();
        float f3 = f1 / f2;
        float f4 = g() * 1.0F / h();
        if (f3 > f4)
        {
          f3 = f4 * f2;
          f4 = (f1 - f3) / 2.0F;
          this.ao.a((int)f4, 0, (int)f3, (int)f2);
        }
        else
        {
          f3 = f1 / f4;
          f4 = (f2 - f3) / 2.0F;
          this.ao.a(0, (int)f4, (int)f1, (int)f3);
        }
        this.ao.a((int)f1, (int)f2);
        this.ao.a(paramGLCanvas, 0, 0, g(), h());
        paramGLCanvas.a(-k, -m, 0.0F);
      }
      Object localObject = VideoController.f().aB();
      if ((localObject == null) || (!((WatchTogetherMediaPlayCtrl)localObject).h())) {
        j = 0;
      }
      if (j == 0) {
        g(paramGLCanvas);
      }
      this.am.b(paramGLCanvas.b(), paramGLCanvas.c());
      if (j != 0) {
        g(paramGLCanvas);
      }
      localObject = SessionMgr.a().b();
      if ((i == 0) && (localObject != null))
      {
        this.an.a(paramGLCanvas.b(), paramGLCanvas.c());
        this.an.a(paramGLCanvas, ((SessionInfo)localObject).H, this.Y.getLongAccountUin(), ((SessionInfo)localObject).I, Long.valueOf(((SessionInfo)localObject).s).longValue());
      }
    }
    super.e(paramGLCanvas);
  }
  
  public void e(boolean paramBoolean)
  {
    AVTraceUtil.a("switch_camera", "onCameraSwitched", 3, new Object[0]);
    Object localObject;
    if (QLog.isColorLevel())
    {
      str = this.U;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCameraSwitched isFrontCamera: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d(str, 2, ((StringBuilder)localObject).toString());
    }
    String str = this.Y.getCurrentAccountUin();
    int i = a("onCameraSwitched", str, 1);
    if (i >= 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(1);
      str = ((StringBuilder)localObject).toString();
      localObject = GraphicRenderMgr.getInstance();
      ((IGraphicRender)localObject).clearCameraFrames();
      ((IGraphicRender)localObject).flushGlRender(str);
      this.ae[i].p(false);
      this.bg = new VideoLayerUI.6(this, i, paramBoolean);
      this.Z.t.a(true, this.bg);
    }
    if (this.Z.k().g == 4) {
      if (this.Z.k().p == 3000)
      {
        if (paramBoolean) {
          ReportController.b(null, "CliOper", "", "", "0X80041B5", "0X80041B5", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X80041B4", "0X80041B4", 0, 0, "", "", "", "");
        }
      }
      else if (this.Z.k().p == 1) {
        if (paramBoolean)
        {
          if (this.Z.k().o == 10) {
            ReportController.b(null, "CliOper", "", "", "0X800593B", "0X800593B", 0, 0, "", "", "", "");
          } else {
            ReportController.b(null, "CliOper", "", "", "0X80046E2", "0X80046E2", 0, 0, "", "", "", "");
          }
        }
        else if (this.Z.k().o == 10) {
          ReportController.b(null, "CliOper", "", "", "0X800593A", "0X800593A", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X80046E1", "0X80046E1", 0, 0, "", "", "", "");
        }
      }
    }
    if (this.Z.k().am)
    {
      if (paramBoolean)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005211", "0X8005211", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X8005210", "0X8005210", 0, 0, "", "", "", "");
    }
  }
  
  void f(long paramLong)
  {
    ThreadManager.post(this.aq, 8, null, false);
    String str1 = this.Y.getCurrentAccountUin();
    int i = a("closeSelfVideo", str1, 1);
    if (i >= 0)
    {
      String str2 = a(str1, 1);
      Object localObject = GraphicRenderMgr.getInstance();
      ((IGraphicRender)localObject).flushGlRender(str2);
      ((IGraphicRender)localObject).clearCameraFrames();
      GraphicRenderMgr.setGlRender(str2, null);
      str2 = this.U;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setGlRender[closeSelfVideo_no], key[");
      ((StringBuilder)localObject).append(LogUtil.getSafePrintUin(str1));
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(1);
      ((StringBuilder)localObject).append("], index[");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w(str2, 1, ((StringBuilder)localObject).toString());
      this.Z.a(paramLong, this.Z.k().g, true, false);
      h(paramLong);
    }
  }
  
  void f(boolean paramBoolean)
  {
    if (this.bj == null) {
      ap();
    }
    TextView localTextView = this.bl;
    if (localTextView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localTextView.setVisibility(i);
    }
  }
  
  public void g(long paramLong)
  {
    Object localObject3 = this.Y.getCurrentAccountUin();
    int i = a("openSelfVideo", (String)localObject3, 1);
    Object localObject1;
    Object localObject2;
    if (i < 0)
    {
      i = r(0);
      if (i >= 0)
      {
        localObject1 = this.ae[i];
        a(paramLong, (GLVideoView)localObject1, (String)localObject3, 1, false);
      }
      else
      {
        localObject1 = null;
      }
      if ((i == 0) && (localObject1 != null) && (this.Z.k().g == 4)) {
        ((GLVideoView)localObject1).i(false);
      }
      localObject3 = SessionMgr.a().b();
      localObject2 = localObject1;
      if (i == 0)
      {
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (((SessionInfo)localObject3).r())
          {
            c(true);
            localObject2 = localObject1;
          }
        }
      }
    }
    else
    {
      localObject1 = a((String)localObject3, 1);
      localObject2 = this.ae[i];
      GraphicRenderMgr.setGlRender((String)localObject1, ((GLVideoView)localObject2).B());
      localObject1 = this.U;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGlRender[openSelfVideo], key[");
      localStringBuilder.append(LogUtil.getSafePrintUin((String)localObject3));
      localStringBuilder.append("_");
      localStringBuilder.append(1);
      localStringBuilder.append("], index[");
      localStringBuilder.append(i);
      localStringBuilder.append("], forceToBigView[");
      localStringBuilder.append(false);
      localStringBuilder.append("], ");
      localStringBuilder.append(((GLVideoView)localObject2).T());
      QLog.w((String)localObject1, 1, localStringBuilder.toString());
    }
    if (localObject2 != null)
    {
      if (CameraUtils.a(this.X).isCameraOpened(paramLong)) {
        ((GLVideoView)localObject2).a(paramLong, CameraUtils.a(this.X).isFrontCamera());
      }
      ((GLVideoView)localObject2).h(false);
      ((GLVideoView)localObject2).l(false);
      ((GLVideoView)localObject2).n(true);
      ((GLVideoView)localObject2).a(0);
      ((GLVideoView)localObject2).a(ImageView.ScaleType.CENTER_CROP);
    }
  }
  
  void g(boolean paramBoolean)
  {
    if (this.bj == null) {
      ap();
    }
    if (this.bl != null)
    {
      if (this.bm == null) {
        return;
      }
      if (this.Z != null)
      {
        if (paramBoolean)
        {
          this.bl.setTextColor(Color.parseColor("#ffffff"));
          this.bm.setBackgroundResource(2130851944);
          return;
        }
        this.bl.setTextColor(Color.parseColor("#5f656f"));
        this.bm.setBackgroundResource(2130851945);
      }
    }
  }
  
  public void h(long paramLong)
  {
    int i = a("closeSelfRender", this.Y.getCurrentAccountUin(), 1);
    if (i >= 0) {
      e("closeSelfRender", i);
    }
  }
  
  public void i(int paramInt)
  {
    long l = AudioHelper.c();
    Object localObject = this.U;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("changeLayoutMode, screenStyle[");
    localStringBuilder.append(this.Z.k().bM);
    localStringBuilder.append("->");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], ScreenLayout[");
    localStringBuilder.append(this.aj.b());
    localStringBuilder.append("->");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if ((c(this.Z.k())) && (paramInt == 1)) {
      QLog.d(this.U, 1, "changeLayoutMode with error happen", new Throwable());
    }
    super.i(paramInt);
    int i = this.aj.b();
    if (i != paramInt)
    {
      this.aF = true;
      this.aj = ScreenLayout.a(this.X, this.Y, paramInt, false);
      if (V())
      {
        super.a(null);
        super.e(-15197410);
        new ControlUIObserver.ZimuRequest(l, "changeLayoutMode", 5, null).a(this.Y);
      }
      else
      {
        ah();
        a(Integer.valueOf(6501), null);
      }
      c(true);
      if ((i == 3) && (paramInt == 4)) {
        i = 1;
      } else if ((i == 4) && (paramInt == 3)) {
        i = 2;
      } else if (paramInt == 3) {
        i = 3;
      } else {
        i = 0;
      }
      if (i == 1)
      {
        float f1 = UITools.a(this.X, 12.0F);
        float f2 = UITools.a(this.X, 18.0F);
        i = 0;
        while (i < this.ae.length)
        {
          if (i == 0)
          {
            this.ae[i].i(false);
            this.ae[i].l(12);
            this.ae[i].a(f2);
          }
          else
          {
            this.ae[i].i(true);
            this.ae[i].l(12);
            this.ae[i].a(f1);
          }
          this.ae[i].H();
          i += 1;
        }
      }
      i = 0;
      while (i < this.ae.length)
      {
        this.ae[i].e(this.aj.e());
        localObject = this.ae[i];
        boolean bool;
        if (paramInt == 3) {
          bool = true;
        } else {
          bool = false;
        }
        ((GLVideoView)localObject).g(bool);
        a(l, this.ae[i]);
        i += 1;
      }
      if ((this.X instanceof AVActivity)) {
        ((AVActivity)this.X).h(l);
      }
      this.aF = false;
      if (this.Z.k().g == 4) {
        k(paramInt);
      }
    }
  }
  
  protected void j(int paramInt)
  {
    this.aj.a(this.ae, paramInt, g(), h(), this.ab, this.ac);
  }
  
  public void k(int paramInt)
  {
    if (this.aY != paramInt) {
      this.aY = paramInt;
    }
  }
  
  public void l(int paramInt)
  {
    if ((this.aj != null) && (b(this.Z.k())))
    {
      this.aj.a(paramInt);
      boolean bool2 = true;
      boolean bool1;
      if (paramInt != 2) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      c(bool1);
      if (paramInt != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      h(bool1);
      ICameraManagerApi localICameraManagerApi = CameraUtils.a(this.X);
      if (paramInt != 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localICameraManagerApi.setCameraSensorMode(bool1);
    }
    this.T = paramInt;
  }
  
  public void m(int paramInt)
  {
    int i = a("enableAvatar2D", this.Z.k().s, 1);
    if (i >= 0)
    {
      if (paramInt == 6)
      {
        this.ae[i].a(ImageView.ScaleType.CENTER_CROP);
        return;
      }
      this.ae[i].a(ImageView.ScaleType.CENTER_INSIDE);
    }
  }
  
  void n(int paramInt)
  {
    if (this.bj == null) {
      ap();
    }
    TextView localTextView = this.bm;
    if (localTextView != null)
    {
      localTextView.setMaxLines(paramInt);
      if (paramInt == 1) {
        this.bm.setSingleLine();
      }
    }
  }
  
  public void o(int paramInt)
  {
    this.bs = paramInt;
  }
  
  void p(int paramInt)
  {
    if (this.N != null)
    {
      this.Y.a().removeCallbacks(this.N);
      this.N = null;
      c(false);
    }
    if (!al())
    {
      this.N = new VideoLayerUI.MultiVideoOpenAnimation(this, paramInt);
      this.Y.a().post(this.N);
    }
  }
  
  protected void q()
  {
    super.q();
    if (am()) {
      this.am.d();
    }
  }
  
  protected void q(int paramInt) {}
  
  protected void r()
  {
    super.r();
    if (am()) {
      this.am.c();
    }
  }
  
  public void z() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI
 * JD-Core Version:    0.7.0.1
 */