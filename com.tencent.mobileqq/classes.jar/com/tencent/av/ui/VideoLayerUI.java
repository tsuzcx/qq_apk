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
import com.tencent.av.business.manager.zimu.ARZimuTask;
import com.tencent.av.business.manager.zimu.ARZimuUtil;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.gameplay.GPNativeSoLoader;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.gesturedetectors.MoveGestureDetector;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.texture.BitmapTexture;
import com.tencent.av.opengl.ui.AnimationTime;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.opengl.ui.GLView;
import com.tencent.av.opengl.ui.GLView.OnTouchListener;
import com.tencent.av.opengl.ui.OnVisiableItemChangeListener;
import com.tencent.av.opengl.ui.ScrollerHelper;
import com.tencent.av.opengl.ui.animation.GLAnimation;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.redpacket.AVRedPacketGameControl;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.funchat.zimu.ZimuViewProxy;
import com.tencent.av.utils.AVTraceUtil;
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
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class VideoLayerUI
  extends VideoLayerUIBase
{
  private int A = -1;
  private volatile int B = 0;
  private int C = 0;
  private int D = 0;
  private int E = 0;
  private int F = 0;
  private int G;
  private volatile int H = -1;
  private int I = -1;
  private int J = -1;
  private int K = -1;
  private int L = 0;
  private int M = 0;
  private int N = 0;
  long jdField_a_of_type_Long = 0L;
  private DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
  public GestureDetector a;
  private ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector = null;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private VideoCameraListener.SwitchCameraListener jdField_a_of_type_ComTencentAvVideoCameraListener$SwitchCameraListener = null;
  private MoveGestureDetector jdField_a_of_type_ComTencentAvOpenglGesturedetectorsMoveGestureDetector = null;
  private OnVisiableItemChangeListener jdField_a_of_type_ComTencentAvOpenglUiOnVisiableItemChangeListener;
  private ScrollerHelper jdField_a_of_type_ComTencentAvOpenglUiScrollerHelper;
  private AVRedPacketGameControl jdField_a_of_type_ComTencentAvRedpacketAVRedPacketGameControl;
  AVActivity.AnimationTrigger jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger = null;
  private VideoHoldViewPools jdField_a_of_type_ComTencentAvUiVideoHoldViewPools = new VideoHoldViewPools(this.jdField_a_of_type_AndroidContentContext, paramVideoAppInterface, this);
  protected VideoLayerUI.MultiVideoOpenAnimation a;
  private VideoLayerUI.MyExploreByTouchHelper jdField_a_of_type_ComTencentAvUiVideoLayerUI$MyExploreByTouchHelper;
  private VideoLayerUI.TouchListener jdField_a_of_type_ComTencentAvUiVideoLayerUI$TouchListener = new VideoLayerUI.TouchListener(this);
  private VideoTalkMemberManager jdField_a_of_type_ComTencentAvUiVideoTalkMemberManager = new VideoTalkMemberManager(this.jdField_a_of_type_ComTencentAvVideoController, this);
  ZimuViewProxy jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy;
  private RotateLayout jdField_a_of_type_ComTencentAvWidgetRotateLayout = null;
  private ArrayList<GLView> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ConcurrentHashMap<Long, VideoMemberInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private GestureDetector jdField_b_of_type_AndroidViewGestureDetector;
  private TextView jdField_b_of_type_AndroidWidgetTextView = null;
  private GLView.OnTouchListener jdField_b_of_type_ComTencentAvOpenglUiGLView$OnTouchListener = null;
  private ArrayList<Runnable> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private List<RecvMsg> jdField_b_of_type_JavaUtilList = new LinkedList();
  private long jdField_c_of_type_Long = -1L;
  private Runnable jdField_c_of_type_JavaLangRunnable = new VideoLayerUI.NewMsgRunnable(this, null);
  boolean jdField_c_of_type_Boolean = false;
  private long jdField_d_of_type_Long = 0L;
  private Rect jdField_d_of_type_AndroidGraphicsRect = new Rect();
  private Runnable jdField_d_of_type_JavaLangRunnable = new VideoLayerUI.LastMsgRunnable(this, null);
  private Rect e;
  private final boolean f;
  private volatile boolean g;
  private boolean h = true;
  private boolean i = true;
  private boolean j;
  public int k;
  private boolean k;
  public int l;
  private boolean l;
  public int m = 144;
  public int n = 4;
  int o = 0;
  protected int p = 0;
  private final int y = MultiVideoCtrlLayerUIBase.b;
  private int z = -1;
  
  public VideoLayerUI(VideoAppInterface paramVideoAppInterface, Context paramContext, View paramView)
  {
    super(paramVideoAppInterface, paramContext, paramView);
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewGestureDetector = null;
    this.jdField_k_of_type_Int = 0;
    this.jdField_l_of_type_Int = 144;
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MultiVideoOpenAnimation = null;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_e_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvUiScreenLayout = ScreenLayout.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1, false);
    this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherVideoRenderHelper = new WatchTogetherVideoRenderHelper(false);
    this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherVideoBgRender = new WatchTogetherVideoBgRender(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramContext);
    o();
    m();
    z();
    A();
    n();
    B();
    l();
    G();
    C();
    t();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "VideoLayerUI");
  }
  
  private void A()
  {
    this.w = SharedPreUtils.a(this.jdField_a_of_type_AndroidContentContext).getInt("video_position", 3);
  }
  
  private void B()
  {
    int i2 = 2130842125;
    int i1 = i2;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      i1 = i2;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 1008) {
        i1 = 2130842285;
      }
    }
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(UITools.a(this.jdField_a_of_type_AndroidContentContext, i1));
    super.a(UITools.a(this.jdField_a_of_type_AndroidContentContext, i1));
  }
  
  private void C()
  {
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(this.jdField_a_of_type_AndroidContentContext, new VideoLayerUI.ScaleGestureListener(this));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new VideoLayerUI.GestureListener(this));
    this.jdField_a_of_type_ComTencentAvOpenglGesturedetectorsMoveGestureDetector = new MoveGestureDetector(this.jdField_a_of_type_AndroidContentContext, new VideoLayerUI.MoveListener(this, null));
    this.jdField_b_of_type_ComTencentAvOpenglUiGLView$OnTouchListener = new VideoLayerUI.WeakTouchListener(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$TouchListener);
    a(this.jdField_b_of_type_ComTencentAvOpenglUiGLView$OnTouchListener);
    this.o = AIOUtils.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  private void D()
  {
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.C = 0;
      this.D = 0;
      this.h = true;
      return;
    }
  }
  
  private void E()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture != null) {}
    Bitmap localBitmap;
    do
    {
      return;
      localBitmap = UITools.a(this.jdField_a_of_type_AndroidContentContext, 2130842491);
    } while (localBitmap == null);
    this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture = new BitmapTexture(localBitmap);
    this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture.a(false);
  }
  
  private void F()
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null)
    {
      this.jdField_a_of_type_ComTencentAvWidgetRotateLayout = ((RotateLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363167));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363176));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363178));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363177));
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources();
      this.L = ((int)localResources.getDimension(2131297873));
      this.M = ((int)localResources.getDimension(2131297874));
      int i1 = (int)(localResources.getDimension(2131296401) + localResources.getDimension(2131296468));
      int i2 = (int)(localResources.getDimension(2131296403) + localResources.getDimension(2131296470));
      int i3 = (int)(localResources.getDimension(2131296400) + localResources.getDimension(2131296467));
      float f1 = localResources.getDimension(2131296402);
      int i4 = (int)(localResources.getDimension(2131296469) + f1);
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i1, i2, i3, i4);
      this.jdField_b_of_type_AndroidWidgetTextView.setTag(Long.valueOf(0L));
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.L);
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(this.M);
      this.jdField_b_of_type_AndroidWidgetTextView.getBackground().setAlpha(128);
      if (AudioHelper.a(0) == 1)
      {
        this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setBackgroundColor(-460545);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(-984833);
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundColor(-1);
      }
    }
  }
  
  private void G()
  {
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MyExploreByTouchHelper = new VideoLayerUI.MyExploreByTouchHelper(this, this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView);
    ViewCompat.setAccessibilityDelegate(this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView, this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MyExploreByTouchHelper);
  }
  
  private void H()
  {
    if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketGameControl == null) {
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketGameControl = new AVRedPacketGameControl(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (AVActivity)this.jdField_a_of_type_AndroidContentContext);
    }
  }
  
  private void I()
  {
    if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketGameControl != null)
    {
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketGameControl.g();
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketGameControl = null;
    }
  }
  
  private void J()
  {
    int i2 = this.G;
    int i1 = Math.max(0, i2 / (this.jdField_l_of_type_Int + this.n));
    int i3 = this.jdField_l_of_type_Int;
    int i4 = this.n;
    i2 = (int)Math.ceil((k() - ((i1 + 1) * (i3 + i4) - i2)) * 1.0F / (this.jdField_l_of_type_Int + this.n));
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
    Bitmap localBitmap = UITools.a(this.jdField_a_of_type_AndroidContentContext, 2130840707);
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
  
  private Bitmap a(VideoMemberInfo paramVideoMemberInfo)
  {
    if (paramVideoMemberInfo.jdField_a_of_type_Int == 0) {
      return this.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(paramVideoMemberInfo.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().g), this.jdField_a_of_type_ComTencentAvVideoController.a().F, true, false);
    }
    return ((BitmapDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842304)).getBitmap();
  }
  
  private Boolean a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 2) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  private String a(VideoMemberInfo paramVideoMemberInfo)
  {
    if (paramVideoMemberInfo.jdField_a_of_type_Int == 0)
    {
      paramVideoMemberInfo = this.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(paramVideoMemberInfo.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().g), this.jdField_a_of_type_ComTencentAvVideoController.a().F);
      return paramVideoMemberInfo;
    }
    long l1 = paramVideoMemberInfo.jdField_a_of_type_Long;
    if (paramVideoMemberInfo.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null) {}
    for (AVPhoneUserInfo localAVPhoneUserInfo = paramVideoMemberInfo.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;; localAVPhoneUserInfo = this.jdField_a_of_type_ComTencentAvVideoController.a(l1, this.jdField_a_of_type_ComTencentAvVideoController.a().f))
    {
      if ((localAVPhoneUserInfo == null) || (localAVPhoneUserInfo.telInfo.mobile == null)) {
        break label154;
      }
      paramVideoMemberInfo.jdField_a_of_type_JavaLangString = localAVPhoneUserInfo.telInfo.mobile;
      String str = this.jdField_a_of_type_ComTencentAvVideoController.a(localAVPhoneUserInfo.telInfo.mobile);
      paramVideoMemberInfo = str;
      if (str != null) {
        break;
      }
      return PstnUtils.a(localAVPhoneUserInfo.telInfo.mobile, 4);
    }
    label154:
    if ((localAVPhoneUserInfo != null) && (QLog.isColorLevel())) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getMemmberName --> can not get Open Id. PhoneInfo = " + localAVPhoneUserInfo.toString());
    }
    return this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693149);
  }
  
  private static final String a(CharSequence paramCharSequence)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramCharSequence);
    int i1 = paramCharSequence.length();
    EmoticonSpan[] arrayOfEmoticonSpan = (EmoticonSpan[])((QQText)paramCharSequence).getSpans(0, i1, EmoticonSpan.class);
    i1 = 0;
    int i3;
    for (int i2 = 0; i1 < arrayOfEmoticonSpan.length; i2 = i3)
    {
      Object localObject = arrayOfEmoticonSpan[i1];
      i3 = i2;
      if ((localObject instanceof EmoticonSpan))
      {
        int i4 = ((QQText)paramCharSequence).getSpanStart(localObject);
        int i5 = ((QQText)paramCharSequence).getSpanEnd(localObject);
        i3 = i2;
        if (((EmoticonSpan)localObject).emojiType == 2)
        {
          localObject = ((EmoticonSpan)localObject).getDescription();
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
  
  private void a(long paramLong, int paramInt)
  {
    int i1 = a("refreshMicState", String.valueOf(paramLong), 1);
    if (i1 != -1) {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].h(paramInt);
    }
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    paramView = paramView.findViewById(2131363184);
    if ((paramBoolean) && (!VideoController.a().r())) {}
    for (int i1 = 1; i1 != 0; i1 = 0)
    {
      paramView.setVisibility(0);
      return;
    }
    paramView.setVisibility(8);
  }
  
  private void a(GLCanvas paramGLCanvas, GLView paramGLView, boolean paramBoolean)
  {
    int i3 = 1;
    int i1;
    if ((paramGLView.a()) || (paramGLView.b()))
    {
      i1 = 1;
      if ((paramGLView.b().left - this.C <= this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels) && (paramGLView.b().right - this.C >= 0)) {
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
    paramGLCanvas.a(0, 0);
    paramGLView.a(paramGLCanvas);
    paramGLCanvas.a(-0, -0);
  }
  
  private void a(GLVideoView paramGLVideoView, float paramFloat, long paramLong)
  {
    paramLong /= 10L;
    a(new VideoLayerUI.10(this, paramLong, paramGLVideoView, (float)Math.pow(paramFloat, 1.0D / paramLong)));
  }
  
  private void a(GLVideoView paramGLVideoView, boolean paramBoolean)
  {
    GLAnimation localGLAnimation = new GLAnimation();
    localGLAnimation.b(50);
    localGLAnimation.b(0.0F, 0.0F, 0.0F, 90.0F, 0.0F, 0.0F);
    localGLAnimation.a(new VideoLayerUI.4(this, paramGLVideoView, paramBoolean));
    localGLAnimation.a(1);
    paramGLVideoView.a(localGLAnimation);
    paramGLVideoView.b();
  }
  
  private void a(boolean paramBoolean, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0))
    {
      u();
      Object localObject = this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.a();
      if (localObject != null)
      {
        localObject = ((ZimuItem)localObject).getId();
        int i1 = 1;
        if (!paramBoolean) {
          i1 = 4;
        }
        new ControlUIObserver.ZimuRequest(paramLong, "showLastZimu", i1, (String)localObject).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
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
      paramCharSequence = (EmoticonSpan[])((QQText)paramCharSequence).getSpans(0, paramCharSequence.length(), EmoticonSpan.class);
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
  
  private VideoMemberInfo b(long paramLong)
  {
    VideoMemberInfo localVideoMemberInfo2 = (VideoMemberInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    VideoMemberInfo localVideoMemberInfo1 = localVideoMemberInfo2;
    if (localVideoMemberInfo2 == null)
    {
      localVideoMemberInfo1 = new VideoMemberInfo();
      localVideoMemberInfo1.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), localVideoMemberInfo1);
    }
    return localVideoMemberInfo1;
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if ((this.G == paramInt) && (!paramBoolean)) {
      return;
    }
    this.G = paramInt;
    J();
  }
  
  private void b(long paramLong, GLVideoView paramGLVideoView, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramGLVideoView != null)
    {
      a(paramString, paramInt);
      paramGLVideoView.a(paramString, paramInt);
      paramGLVideoView.a(0);
      paramGLVideoView.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
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
        if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_d_of_type_Boolean)
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
      q(this.x);
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
  
  private void b(GLVideoView paramGLVideoView, boolean paramBoolean)
  {
    GLAnimation localGLAnimation = new GLAnimation();
    localGLAnimation.b(50);
    localGLAnimation.b(0.0F, 0.0F, -90.0F, 0.0F, 0.0F, 0.0F);
    localGLAnimation.a(2);
    localGLAnimation.a(new VideoLayerUI.5(this));
    paramGLVideoView.a(localGLAnimation);
    paramGLVideoView.b();
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
      i2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].e();
      f1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].d();
      i1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].f();
      bool = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].i();
      if (i5 == 4) {
        paramString = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a();
      }
    }
    for (;;)
    {
      int i3;
      int i4;
      if ((i5 == 4) && (this.jdField_a_of_type_ComTencentAvUiScreenLayout.a() == 3))
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
      GLVideoView localGLVideoView;
      for (;;)
      {
        if ((i3 != 0) && (i4 != 0))
        {
          i3 = -1;
          i4 = paramInt + 1;
          for (;;)
          {
            if (i4 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
            {
              if (this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i4].a() == 0) {
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
            i4 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt].d();
            i6 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i3].d();
            this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt].c(i6);
            this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i3].c(i4);
            localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt];
            this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt] = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i3];
            this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i3] = localGLVideoView;
            localGLVideoView.a("");
            localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i3];
            localGLVideoView.a(1);
            localGLVideoView.b(null);
            localGLVideoView.m(true);
            localGLVideoView.k(false);
            localGLVideoView.g(false);
            localGLVideoView.l(true);
            localGLVideoView.a(null, 0);
            label362:
            if (paramInt == 0)
            {
              this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].h(false);
              this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].k(i2);
              this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(f1);
              this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].j(i1);
              this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].j(bool);
              if (i5 == 4)
              {
                if (this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].g() != 2) {
                  break label662;
                }
                this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(ImageView.ScaleType.CENTER_INSIDE);
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
        while (i3 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
        {
          if ((i3 >= this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length - 1) || (this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[(i3 + 1)].a() != 0)) {
            break label599;
          }
          i4 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i3].d();
          i6 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[(i3 + 1)].d();
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i3].c(i6);
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[(i3 + 1)].c(i4);
          localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i3];
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i3] = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[(i3 + 1)];
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[(i3 + 1)] = localGLVideoView;
          i3 += 1;
        }
        break label362;
        label599:
        localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i3];
        localGLVideoView.a(1);
        localGLVideoView.b(null);
        localGLVideoView.m(true);
        localGLVideoView.k(false);
        localGLVideoView.g(false);
        localGLVideoView.l(true);
        localGLVideoView.a(null, 0);
        localGLVideoView.a("");
        break label362;
        label662:
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(paramString);
      }
      continue;
      f1 = 0.0F;
      i2 = 0;
      i1 = 0;
      bool = false;
    }
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_d_of_type_Long != 0L) && (System.currentTimeMillis() - this.jdField_d_of_type_Long < 1000L))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "bigWindowToSmallWindowAnim, 大小窗正在切换中[" + this.jdField_d_of_type_Long + "]");
      return false;
    }
    GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2];
    localGLVideoView.a(Boolean.valueOf(false));
    localGLVideoView.a(0, 0, 0, 0);
    int i1 = localGLVideoView.d();
    localGLVideoView.c(1);
    float f1 = localGLVideoView.b().left;
    float f2 = localGLVideoView.b().top;
    Rect localRect = super.a();
    GLAnimation localGLAnimation = new GLAnimation();
    localGLAnimation.b(100);
    localGLAnimation.a(f1, f2, 0.0F, -localRect.left, -localRect.top, 0.0F);
    localGLAnimation.a(localGLVideoView.b().width(), localGLVideoView.b().height(), super.b() + localRect.left + localRect.right, super.c() + localRect.top + localRect.bottom);
    localGLAnimation.a(new VideoLayerUI.7(this, paramInt2, i1, paramInt1));
    localGLAnimation.a(2);
    localGLVideoView.a(localGLAnimation);
    localGLVideoView.b();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    return true;
  }
  
  private void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
    paramInt3 = paramInt1 + this.n;
    paramInt4 = this.jdField_l_of_type_Int;
    paramInt1 = paramInt3;
    paramInt3 += paramInt4;
    int i1 = 1;
    paramInt4 = paramInt1;
    paramInt1 = i1;
    while (paramInt1 <= i2)
    {
      ((GLView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1 - 1)).b(paramInt4, paramInt2, paramInt3, this.m + paramInt2);
      paramInt4 += this.jdField_l_of_type_Int + this.n;
      paramInt3 = paramInt4 + this.jdField_l_of_type_Int;
      paramInt1 += 1;
    }
    this.H = ((this.jdField_l_of_type_Int + this.n) * i2 + this.n);
  }
  
  private void c(int paramInt, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramInt == this.C)) {
      return;
    }
    this.C = paramInt;
    paramInt = m();
    if ((this.C > paramInt) && (this.jdField_a_of_type_ComTencentAvOpenglUiScrollerHelper.a()))
    {
      this.jdField_a_of_type_ComTencentAvOpenglUiScrollerHelper.b(this.C);
      this.C = paramInt;
    }
    b(this.C, paramBoolean);
    n(this.C);
  }
  
  private boolean c(int paramInt1, int paramInt2)
  {
    if ((this.jdField_d_of_type_Long != 0L) && (System.currentTimeMillis() - this.jdField_d_of_type_Long < 1000L))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "bigWindowToSmallWindowAnim, 大小窗正在切换中[" + this.jdField_d_of_type_Long + "]");
      return false;
    }
    Object localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1];
    GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2];
    ((GLVideoView)localObject).a(Boolean.valueOf(false));
    ((GLVideoView)localObject).a(0, 0, 0, 0);
    localGLVideoView.a(Boolean.valueOf(false));
    localGLVideoView.a(0, 0, 0, 0);
    int i1 = localGLVideoView.d();
    localGLVideoView.c(((GLVideoView)localObject).d());
    Rect localRect = localGLVideoView.b();
    localObject = ((GLVideoView)localObject).b();
    GLAnimation localGLAnimation = new GLAnimation();
    localGLAnimation.b(300);
    localGLAnimation.a(localRect.left, localRect.top, 0.0F, ((Rect)localObject).left, ((Rect)localObject).top, 0.0F);
    localGLAnimation.a(localRect.width(), localRect.height(), ((Rect)localObject).width(), ((Rect)localObject).height());
    localGLAnimation.a(new VideoLayerUI.8(this, paramInt2, i1, paramInt1));
    localGLAnimation.a(2);
    localGLVideoView.a(localGLAnimation);
    localGLVideoView.b();
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
    GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2];
    localGLVideoView.a(Boolean.valueOf(false));
    localGLVideoView.a(0, 0, 0, 0);
    b(new VideoLayerUI.9(this, paramInt1, paramInt2));
    b();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    return true;
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == this.E) && (paramInt2 == this.F)) {}
    for (;;)
    {
      return;
      if (paramInt1 < paramInt2)
      {
        this.E = paramInt1;
        this.F = paramInt2;
      }
      while (this.jdField_a_of_type_ComTencentAvOpenglUiOnVisiableItemChangeListener != null)
      {
        this.jdField_a_of_type_ComTencentAvOpenglUiOnVisiableItemChangeListener.a(this.E, this.F);
        return;
        this.F = 0;
        this.E = 0;
      }
    }
  }
  
  private void g(GLCanvas paramGLCanvas)
  {
    int i1;
    int i2;
    int i4;
    int i3;
    if (paramGLCanvas.a() > paramGLCanvas.b())
    {
      i1 = 1;
      i2 = AIOUtils.a(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      i4 = WTogetherUtil.a(this.jdField_a_of_type_AndroidContentContext);
      i3 = b() / 2;
      if (i1 == 0) {
        break label116;
      }
      i2 = c() / 2;
      label59:
      paramGLCanvas.a(i3, i2, 0.0F);
      if (i1 == 0) {
        break label130;
      }
      paramGLCanvas.a(0.0F, 0.0F, b(), c(), -16777216);
    }
    for (;;)
    {
      paramGLCanvas.a(-i3, -i2, 0.0F);
      return;
      i1 = 0;
      break;
      label116:
      i2 = i2 + i4 + WTogetherUtil.a() / 2;
      break label59;
      label130:
      paramGLCanvas.a(0.0F, 0.0F, b(), WTogetherUtil.a() + 2, -16777216);
    }
  }
  
  private void h(GLCanvas arg1)
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
    if ((this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0] != null) && (this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1] != null))
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].e(paramBoolean);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].e(paramBoolean);
    }
  }
  
  private void i(long paramLong)
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (!this.jdField_c_of_type_Boolean)) {
      ((AVActivity)this.jdField_a_of_type_AndroidContentContext).a.D(paramLong);
    }
  }
  
  private void i(GLCanvas paramGLCanvas)
  {
    h(paramGLCanvas);
    long l1 = AnimationTime.a();
    boolean bool1 = this.jdField_a_of_type_ComTencentAvOpenglUiScrollerHelper.a(l1);
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
        localObject1 = (GLVideoView)a(0);
        l1 = Long.parseLong(((GLVideoView)localObject1).c());
        i6 = ((GLVideoView)localObject1).g();
        localObject1 = a();
        if ((localObject1 != null) && (!(((AVActivity)localObject1).a instanceof DoubleVideoMeetingCtrlUI)))
        {
          localObject1 = this.jdField_a_of_type_ComTencentAvUiVideoTalkMemberManager.a(false);
          if (!this.i) {
            break label1307;
          }
          this.jdField_a_of_type_ComTencentAvUiVideoHoldViewPools.a((ArrayList)localObject1);
          if (((ArrayList)localObject1).size() <= this.y) {
            break label674;
          }
          i4 = 1;
          i5 = 1;
          if ((i5 < ((ArrayList)localObject1).size()) && ((this.jdField_a_of_type_JavaUtilArrayList.size() != this.y - 2) || (i4 == 0))) {
            break;
          }
          i2 = i1;
          if (i4 != 0)
          {
            this.jdField_a_of_type_ComTencentAvUiGLVideoView.b(((ArrayList)localObject1).size() - this.y + 1 + "+");
            if (!((Boolean)this.jdField_a_of_type_ComTencentAvUiGLVideoView.a(2)).booleanValue()) {
              break label1290;
            }
            this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentAvUiGLVideoView);
            i2 = i1;
          }
          label233:
          if ((i2 >= 2) && (UITools.a(2))) {
            ThreadManager.getUIHandler().post(new VideoLayerUI.3(this));
          }
          paramGLCanvas.a(b() / 2, c() / 2, 0.0F);
          c(paramGLCanvas);
          paramGLCanvas.a(-b() / 2, -c() / 2, 0.0F);
          i2 = a("renderSliderWindowStyle", String.valueOf(((VideoMemberInfo)((ArrayList)localObject1).get(0)).jdField_a_of_type_Long), ((VideoMemberInfo)((ArrayList)localObject1).get(0)).b());
          i1 = i2;
          if (i2 == -1) {
            i1 = 0;
          }
          localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
          if (!((VideoMemberInfo)((ArrayList)localObject1).get(0)).e()) {
            break label1361;
          }
          i1 = 1;
          label378:
          i2 = i1;
          if (i1 == 0)
          {
            if (!((VideoMemberInfo)((ArrayList)localObject1).get(0)).d()) {
              break label1366;
            }
            i2 = 2;
          }
          label401:
          ((GLVideoView)localObject2).h(i2);
          ((GLVideoView)localObject2).h(false);
          ((GLVideoView)localObject2).a(0, 0, 0, 0);
          ((GLVideoView)localObject2).b(0, 0, super.b(), super.c());
          a(paramGLCanvas, (GLView)localObject2, true);
          if ((!((GLVideoView)localObject2).a()) && (QLog.isDevelopLevel())) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 1, "error happen big screen can not render with Uin:=" + ((GLVideoView)localObject2).c() + ",srcType:=" + ((GLVideoView)localObject2).g());
          }
          c(this.jdField_e_of_type_AndroidGraphicsRect.left, this.jdField_e_of_type_AndroidGraphicsRect.top, this.jdField_e_of_type_AndroidGraphicsRect.right, this.jdField_e_of_type_AndroidGraphicsRect.bottom);
          c(this.jdField_a_of_type_ComTencentAvOpenglUiScrollerHelper.a(), this.h);
          if (this.h) {
            this.h = false;
          }
          paramGLCanvas.a(-this.C, -this.D);
          i1 = 0;
          if (i1 >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
            break label1371;
          }
          a(paramGLCanvas, (GLView)this.jdField_a_of_type_JavaUtilArrayList.get(i1), false);
          i1 += 1;
          continue;
          return;
        }
      }
      catch (NumberFormatException paramGLCanvas)
      {
        paramGLCanvas.printStackTrace();
      }
      label624:
      localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.c();
      this.jdField_a_of_type_ComTencentAvUiVideoTalkMemberManager.a((ArrayList)localObject1);
      localObject1 = this.jdField_a_of_type_ComTencentAvUiVideoTalkMemberManager.a(true);
      if (((ArrayList)localObject1).size() == 0) {
        QLog.d("GLLinearLayout", 1, "videoMemmberInfos size is zero");
      }
      continue;
      label674:
      int i4 = 0;
    }
    Object localObject2 = (VideoMemberInfo)((ArrayList)localObject1).get(i5);
    long l2 = ((VideoMemberInfo)localObject2).a();
    i3 = ((VideoMemberInfo)localObject2).b();
    ((VideoMemberInfo)localObject2).a();
    boolean bool2 = ((VideoMemberInfo)localObject2).jdField_a_of_type_Boolean;
    boolean bool3 = ((VideoMemberInfo)localObject2).c();
    ((VideoMemberInfo)localObject2).d();
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
        localObject3 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i7];
        if (((VideoMemberInfo)localObject2).e())
        {
          i1 = 1;
          label836:
          i3 = i1;
          if (i1 == 0)
          {
            if (!((VideoMemberInfo)localObject2).d()) {
              break label1108;
            }
            i3 = 2;
          }
          label854:
          ((GLVideoView)localObject3).h(i3);
          if (TextUtils.isEmpty(((GLVideoView)localObject3).b()))
          {
            ((GLVideoView)localObject3).b(a((VideoMemberInfo)localObject2));
            ((GLVideoView)localObject3).j(true);
          }
          ((GLVideoView)localObject3).j(12);
          ((GLVideoView)localObject3).a(UITools.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
          ((GLVideoView)localObject3).h(true);
          this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i7]);
          i1 = i2 + 1;
          i2 = 1;
        }
      }
    }
    for (;;)
    {
      label938:
      GLVideoView localGLVideoView;
      if (((!bool3) && (bool2)) || (i2 == 0))
      {
        localGLVideoView = this.jdField_a_of_type_ComTencentAvUiVideoHoldViewPools.a(l2);
        localGLVideoView.b(false);
        localGLVideoView.h(true);
        if (((VideoMemberInfo)localObject2).e())
        {
          i2 = 1;
          label985:
          i3 = i2;
          if (i2 == 0)
          {
            if (!((VideoMemberInfo)localObject2).d()) {
              break label1126;
            }
            i3 = 2;
          }
          label1003:
          localGLVideoView.h(i3);
          if (((Boolean)localGLVideoView.a(2)).booleanValue()) {
            break label1132;
          }
          localGLVideoView.b(a((VideoMemberInfo)localObject2));
          localGLVideoView.j(true);
          localObject3 = a((VideoMemberInfo)localObject2);
          localObject2 = localObject3;
          if (Build.VERSION.SDK_INT == 23) {
            localObject2 = a((Bitmap)localObject3);
          }
          localObject2 = new BitmapTexture((Bitmap)localObject2);
          ((BitmapTexture)localObject2).b(paramGLCanvas);
          localGLVideoView.a((BitmapTexture)localObject2);
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
        this.jdField_a_of_type_JavaUtilArrayList.add(localGLVideoView);
        continue;
        if (!bool2)
        {
          localGLVideoView = this.jdField_a_of_type_ComTencentAvUiVideoHoldViewPools.a(l2);
          localGLVideoView.b(true);
          localGLVideoView.g(Color.parseColor("#4C000000"));
          localGLVideoView.h(-1);
          localGLVideoView.h(true);
          if (!((Boolean)localGLVideoView.a(2)).booleanValue())
          {
            localGLVideoView.b(a((VideoMemberInfo)localObject2));
            localGLVideoView.j(true);
            localObject3 = a((VideoMemberInfo)localObject2);
            localObject2 = localObject3;
            if (Build.VERSION.SDK_INT == 23) {
              localObject2 = a((Bitmap)localObject3);
            }
            localObject2 = new BitmapTexture((Bitmap)localObject2);
            ((BitmapTexture)localObject2).b(paramGLCanvas);
            localGLVideoView.a((BitmapTexture)localObject2);
          }
          else
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(localGLVideoView);
          }
        }
      }
      label1290:
      this.jdField_a_of_type_ComTencentAvUiGLVideoView.a(2, Boolean.valueOf(true));
      i2 = i1;
      break label233;
      label1307:
      i1 = 0;
      i2 = i3;
      if (i1 >= this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length) {
        break label233;
      }
      localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
      if (!((GLView)localObject2).a()) {}
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
      paramGLCanvas.a(this.C, this.D);
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
      int i1 = (int)(((Resources)localObject).getDimension(2131296401) + ((Resources)localObject).getDimension(2131296468));
      int i2 = (int)(((Resources)localObject).getDimension(2131296403) + ((Resources)localObject).getDimension(2131296470));
      int i3 = (int)(((Resources)localObject).getDimension(2131296400) + ((Resources)localObject).getDimension(2131296467));
      f1 = ((Resources)localObject).getDimension(2131296402);
      int i4 = (int)(((Resources)localObject).getDimension(2131296469) + f1);
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i1, i2, i3, i4);
      this.jdField_b_of_type_AndroidWidgetTextView.getBackground().setAlpha(128);
      if ((this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.isShown()) && (!paramBoolean))
      {
        localObject = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject).setDuration(1000L);
        ((AlphaAnimation)localObject).setFillAfter(true);
        ((AlphaAnimation)localObject).setAnimationListener(new VideoLayerUI.MsgboxAnimationListener(this, null));
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
    for (int i2 = 0; i1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length; i2 = i3)
    {
      GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
      String str = localGLVideoView.c();
      i3 = i2;
      if (localGLVideoView.a() == 0)
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
    int i2 = this.H - k();
    int i1 = i2;
    if (i2 <= 0) {
      i1 = 0;
    }
    return i1;
  }
  
  private boolean o()
  {
    return (this.jdField_a_of_type_ComTencentAvUiScreenLayout != null) && (this.jdField_a_of_type_ComTencentAvUiScreenLayout.a() == 4) && (!this.jdField_g_of_type_Boolean);
  }
  
  private boolean p()
  {
    return (this.jdField_a_of_type_ComTencentAvUiScreenLayout != null) && (this.jdField_a_of_type_ComTencentAvUiScreenLayout.a() == 1) && (!this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUiScreenLayout.a());
  }
  
  private void q(int paramInt)
  {
    if ((this.jdField_l_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getLayoutParams();
    int i4 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131299264);
    int i3 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131299265);
    int i5 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131299259);
    int i2 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131299260);
    int i6 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131299258);
    if ((this.r == 0) || (this.q == 0))
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
      localLayoutParams.bottomMargin = (i2 + this.r);
      this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setLayoutParams(localLayoutParams);
      localObject1 = (RotateLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      ((RotateLayout.LayoutParams)localObject1).jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      i2 = this.jdField_a_of_type_AndroidViewView.getWidth() - i5 * 2;
      i1 = i2;
      if (i2 > this.M) {
        i1 = this.M;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(i1);
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setMsgboxLayout, orientation[" + paramInt + "], leftMargin[" + localLayoutParams.leftMargin + "], topMargin[" + localLayoutParams.topMargin + "], rightMargin[" + localLayoutParams.rightMargin + "], bottomMargin[" + localLayoutParams.bottomMargin + "], mMsgLayout[" + this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getWidth() + ", " + this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getHeight() + "]");
      }
    }
    else
    {
      i1 = paramInt;
      if (this.r != 0)
      {
        i1 = paramInt;
        if (this.q != 0) {
          i1 = 0;
        }
      }
      localObject1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b();
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
      localLayoutParams.bottomMargin = (i2 + this.r);
      localLayoutParams.bottomMargin += this.N;
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
      if (paramInt > this.M) {
        i2 = this.M;
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
          localLayoutParams.bottomMargin = (i2 + this.r);
          break;
        }
      }
      localLayoutParams.leftMargin = i5;
      localLayoutParams.bottomMargin = (i2 + this.r + ((Rect)localObject1).height());
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
          localLayoutParams.bottomMargin = (i2 + this.r);
          break label495;
        }
        if (i7 < 2) {
          break label495;
        }
        if (paramInt == 3) {}
        for (localLayoutParams.bottomMargin = (((Rect)localObject1).height() + i3 + i6 + this.r);; localLayoutParams.bottomMargin = (i2 + this.r))
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
          localLayoutParams.topMargin = (i2 + this.q);
          break label495;
        }
        if (i7 == 2)
        {
          if (paramInt == 2) {}
          for (localLayoutParams.rightMargin = (((Rect)localObject1).width() + i4 + i6);; localLayoutParams.rightMargin = i5)
          {
            localLayoutParams.topMargin = (i2 + this.q);
            break;
          }
        }
        localLayoutParams.rightMargin = i5;
        if (paramInt == 2)
        {
          localLayoutParams.topMargin = (i2 + this.q + ((Rect)localObject1).height());
          break label495;
        }
        localLayoutParams.topMargin = (i2 + this.q);
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
        localLayoutParams.topMargin = (i2 + this.q);
        break label495;
      }
      if (i7 < 2) {
        break label495;
      }
      if (paramInt == 1) {}
      for (localLayoutParams.topMargin = (((Rect)localObject1).height() + i3 + i6 + this.q);; localLayoutParams.topMargin = (i2 + this.q))
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
        i1 = 2131695476;
      }
      if ((i1 != 0) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1008, i1);
      }
    }
  }
  
  private void z()
  {
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
    ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindowManager().getDefaultDisplay().getRealMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
    this.n = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297957);
    this.jdField_l_of_type_Int = ((this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels - this.n * 5) / 4);
    this.m = this.jdField_l_of_type_Int;
    int i1 = this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels;
    i1 = this.jdField_l_of_type_Int;
    i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299265);
    this.jdField_d_of_type_AndroidGraphicsRect = new Rect(0, this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels - i1 - this.m, this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels, this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels - i1);
    this.jdField_b_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new VideoLayerUI.MyGestureListener(this, null));
    this.jdField_a_of_type_ComTencentAvOpenglUiScrollerHelper = new ScrollerHelper(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentAvOpenglUiScrollerHelper.a(true);
    this.jdField_a_of_type_ComTencentAvOpenglUiScrollerHelper.a((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 50.0F));
    this.jdField_a_of_type_ComTencentAvUiGLVideoView = new GLVideoView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, String.format("%s_%s", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(1000) }), this.jdField_a_of_type_ComTencentAvVideoController.g());
    this.jdField_a_of_type_ComTencentAvUiGLVideoView.a(1);
    this.jdField_a_of_type_ComTencentAvUiGLVideoView.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_ComTencentAvUiGLVideoView.a("null", 1);
    this.jdField_a_of_type_ComTencentAvUiGLVideoView.a(true);
    this.jdField_a_of_type_ComTencentAvUiGLVideoView.d(false);
    this.jdField_a_of_type_ComTencentAvUiGLVideoView.h(false);
    this.jdField_a_of_type_ComTencentAvUiGLVideoView.i(true);
    i1 = AIOUtils.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_ComTencentAvUiGLVideoView.a(i1);
    this.jdField_a_of_type_ComTencentAvUiGLVideoView.j(true);
    this.jdField_a_of_type_ComTencentAvUiGLVideoView.d(Color.parseColor("#686E6C"));
    this.jdField_a_of_type_ComTencentAvUiGLVideoView.a(2, Boolean.valueOf(false));
    this.jdField_a_of_type_ComTencentAvUiGLVideoView.c(999);
    a(this.jdField_a_of_type_ComTencentAvUiGLVideoView);
  }
  
  public int a(float paramFloat)
  {
    int i1 = Math.round(paramFloat) + this.G;
    if (i1 < 0) {
      return -1;
    }
    return i1 / (this.jdField_l_of_type_Int + this.n);
  }
  
  AVActivity a()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity)) {
      return (AVActivity)this.jdField_a_of_type_AndroidContentContext;
    }
    return null;
  }
  
  public VideoMemberInfo a(long paramLong)
  {
    return (VideoMemberInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
  }
  
  public VideoSink a()
  {
    return this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherVideoRenderHelper;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (p()) {
      this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherVideoRenderHelper.a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    if ((!this.jdField_d_of_type_Boolean) && (!l())) {
      this.v = paramInt;
    }
    for (;;)
    {
      return;
      if ((paramInt != this.u) || (paramInt == this.v))
      {
        if (paramInt % 90 != this.u % 90) {
          this.s = 0;
        }
        this.u = paramInt;
        this.v = paramInt;
        int i1 = a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentContext, paramInt, paramBoolean, this.jdField_a_of_type_AndroidViewDisplay);
        switch (paramInt)
        {
        }
        while (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 2)
        {
          if (this.x != 0)
          {
            paramBoolean = bool;
            if (this.x != 180) {}
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
          this.x = i1;
        }
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i2 = 0;
    int i1 = 0;
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "notifyControlUIOffset, mTopOffset[" + this.q + "->" + paramInt1 + "], mBottomOffset[" + this.r + "->" + paramInt2 + "], mFullScreen[" + this.jdField_c_of_type_Boolean + "->" + paramBoolean + "], seq[" + paramLong + "]");
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.q = paramInt1;
    this.r = paramInt2;
    c(true);
    q(this.x);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
    {
      paramInt1 = i2;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().J)
      {
        paramInt1 = i1;
        while (paramInt1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
        {
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].j(true);
          paramInt1 += 1;
        }
      }
      while (paramInt1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].j(true);
        paramInt1 += 1;
      }
    }
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy != null) {
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.a(this, this.q, this.r);
    }
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    this.J = a("notifyGLVideoViewChange", String.valueOf(paramLong1), paramInt1);
    this.K = a("notifyGLVideoViewChange", String.valueOf(paramLong2), paramInt2);
    b(new VideoLayerUI.2(this, this.J, this.K));
  }
  
  void a(long paramLong, GLVideoView paramGLVideoView, String paramString, int paramInt, boolean paramBoolean)
  {
    String str;
    if (paramGLVideoView != null)
    {
      str = a(paramString, paramInt);
      paramGLVideoView.a(paramString, paramInt);
      paramGLVideoView.a(0);
      paramGLVideoView.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    }
    try
    {
      paramString = paramGLVideoView.a();
      GraphicRenderMgr.getInstance().setAccountUin(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      GraphicRenderMgr.getInstance().setGlRender(str, paramString);
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setGlRender[initGLVideoViewBasePara], key[" + str + "], debug[" + paramGLVideoView.d() + "], videoSrcType[" + paramInt + "], yuvTexture[" + paramString + "]");
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int, false, paramBoolean);
      return;
    }
    catch (UnsatisfiedLinkError paramGLVideoView)
    {
      paramGLVideoView.printStackTrace();
    }
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
    GLVideoView localGLVideoView;
    if (i1 < 0)
    {
      i2 = a(0);
      if (i2 >= 0)
      {
        if (paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
          break label264;
        }
        bool = true;
        localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i2];
        a(paramLong, localGLVideoView, paramString, paramInt, bool);
        if ((localGLVideoView != null) && (!bool)) {
          localGLVideoView.a(paramLong, CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a());
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
        localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
        localGLVideoView.a(paramBitmap);
        localGLVideoView.m(paramBoolean1);
        if (!paramBoolean1) {
          localGLVideoView.k(false);
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
    GLVideoView localGLVideoView = null;
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
        SmallScreenUtils.a();
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
          localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
          a(paramLong, localGLVideoView, paramString, paramInt, true);
        }
        if ((localGLVideoView != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().c.size() <= 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)) {
          localGLVideoView.a(AIOUtils.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        }
        if ((i1 <= 1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 4)) {
          break label565;
        }
        i2 = 1;
        paramString = localGLVideoView;
        paramInt = i1;
        i1 = i2;
      }
      for (;;)
      {
        if (paramString != null)
        {
          paramString.g(paramBoolean2);
          paramString.a(paramLong, this.jdField_a_of_type_ComTencentAvUiScreenLayout.c());
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
          if ((bool) && (paramInt > 0) && (!f()) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().i))) {
            a(0, paramInt);
          }
          if (i1 == 0) {
            break;
          }
          m(paramInt);
          return;
          paramString = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
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
        paramString = localGLVideoView;
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
        H();
      }
      if (paramBoolean1) {
        a(paramLong, paramString, paramInt, paramBoolean2, paramBoolean3);
      }
      while ((this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy != null) && (!g()))
      {
        a(paramBoolean1, paramLong);
        return;
        a(paramLong, paramString, paramInt);
      }
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    int i2 = 2;
    int i1 = 1;
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "notifyAudioMemberChange");
    if (((this.jdField_a_of_type_ComTencentAvVideoController.a().F == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)) || (this.jdField_a_of_type_ComTencentAvVideoController.a().F == 2))
    {
      VideoMemberInfo localVideoMemberInfo = b(paramLong);
      localVideoMemberInfo.b = paramBoolean;
      if (!localVideoMemberInfo.jdField_d_of_type_Boolean) {
        break label129;
      }
      if (i1 != 0) {
        break label141;
      }
      if (!localVideoMemberInfo.d()) {
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
      if ((this.jdField_a_of_type_ComTencentAvUiVideoTalkMemberManager != null) && (this.jdField_a_of_type_ComTencentAvUiVideoTalkMemberManager.a(paramLong, paramBoolean))) {
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
      F();
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "tryRegisterMemmberChangeListener");
    paramSessionInfo.a(this.jdField_a_of_type_ComTencentAvUiVideoTalkMemberManager);
  }
  
  protected void a(GLCanvas paramGLCanvas, boolean paramBoolean)
  {
    if (o())
    {
      i(paramGLCanvas);
      return;
    }
    this.jdField_g_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.C = 0;
    this.D = 0;
    super.a(paramGLCanvas, paramBoolean);
  }
  
  void a(RecvMsg paramRecvMsg)
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
      F();
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
  
  void a(ControlUIObserver.ZimuRequest paramZimuRequest)
  {
    u();
    String str = paramZimuRequest.b;
    long l1 = paramZimuRequest.a();
    if (ARZimuUtil.a(str))
    {
      bool2 = GPNativeSoLoader.a();
      bool1 = bool2;
      if (bool2) {
        bool1 = this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.b(paramZimuRequest.a(), str, (ViewGroup)this.jdField_a_of_type_AndroidViewView, this.q, this.r);
      }
      if ((bool1) && ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity))) {
        ((AVActivity)this.jdField_a_of_type_AndroidContentContext).g(l1);
      }
    }
    while ((!this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.a(paramZimuRequest.a(), str, (ViewGroup)this.jdField_a_of_type_AndroidViewView, this.q, this.r)) || (!(this.jdField_a_of_type_AndroidContentContext instanceof AVActivity)))
    {
      boolean bool2;
      boolean bool1;
      return;
    }
    ((AVActivity)this.jdField_a_of_type_AndroidContentContext).g(l1);
  }
  
  protected void a(Integer paramInteger, Object paramObject)
  {
    AVLog.printColorLog(this.jdField_a_of_type_JavaLangString, "notifyEvent :" + paramInteger + "|" + paramObject);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { paramInteger, paramObject });
  }
  
  void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvUiScreenLayout.a() != 2)
    {
      String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      a("switchLocalView_" + paramString, str);
    }
  }
  
  void a(String paramString1, int paramInt1, String paramString2, float paramFloat, int paramInt2)
  {
    boolean bool = true;
    int i1 = a("setText", paramString1, paramInt1);
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setText, uin[" + paramString1 + "], videoSrcType[" + paramInt1 + "], text[" + paramString2 + "], textSize[" + paramFloat + "], textColor[" + paramInt2 + "], index[" + i1 + "]");
    }
    if (i1 >= 0)
    {
      paramString1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
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
        paramString1.a(AIOUtils.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
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
  
  public void a(ArrayList<VideoController.GAudioFriends> paramArrayList)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "notifyAudioMemberChange");
    if (this.jdField_a_of_type_ComTencentAvUiVideoTalkMemberManager != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoTalkMemberManager.a(paramArrayList);
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
      paramObservable = (SentenceInfo)paramObservable[1];
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.a(paramObservable);
      return;
    case 6010: 
      u();
      r(((Integer)paramObservable[1]).intValue());
      return;
    case 6005: 
      b((ControlUIObserver.ZimuRequest)ControlUIObserver.a(paramObservable));
      return;
    case 6501: 
      if ((this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0)))
      {
        this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.a(true);
        return;
      }
      ARZimuUtil.a(true);
      return;
    }
    c(true);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected boolean a(int paramInt1, int paramInt2)
  {
    String str1;
    if (QLog.isColorLevel())
    {
      str1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].c();
      String str2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].c();
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "switchVideo, begin, [" + paramInt1 + "]=[" + str1 + "], [" + paramInt2 + "]=[" + str2 + "]", new Throwable("打印调用栈"));
    }
    if ((paramInt1 == paramInt2) || (paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length) || (paramInt2 < 0) || (paramInt2 >= this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length))
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
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_INSIDE);
    }
    for (;;)
    {
      str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].c();
      if (str1.equals(this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].c())) {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      }
      if ((this.jdField_a_of_type_ComTencentAvUiScreenLayout == null) || (this.jdField_a_of_type_ComTencentAvUiScreenLayout.a() != 3)) {
        break;
      }
      return c(paramInt1, paramInt2);
      label265:
      if (paramInt2 == 0) {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvUiScreenLayout != null) && (this.jdField_a_of_type_ComTencentAvUiScreenLayout.a() == 4)) {
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
  
  boolean a(String paramString, int paramInt)
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
        localObject1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i2];
        b(paramLong, (GLVideoView)localObject1, (String)localObject2, 2, true);
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
            ((GLVideoView)localObject1).h(false);
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
        ((GLVideoView)localObject2).g(false);
        ((GLVideoView)localObject2).k(false);
        ((GLVideoView)localObject2).m(true);
        ((GLVideoView)localObject2).a(0);
        ((GLVideoView)localObject2).a(ImageView.ScaleType.CENTER_CROP);
      }
      return;
      localObject1 = a((String)localObject2, 2);
      localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setGlRender[openSelfScreenShareRender], key[" + (String)localObject1 + "], index[" + i1 + "], forceToBigView[" + false + "], " + ((GLVideoView)localObject2).d());
    }
  }
  
  void b(long paramLong, Boolean paramBoolean)
  {
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
    int i1 = a("openSelfVideo", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), 1);
    f(paramLong);
    if ((paramBoolean.booleanValue()) && (i1 > 0) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().i))) {
      a(0, i1);
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    int i2 = 2;
    int i1 = 1;
    if (((this.jdField_a_of_type_ComTencentAvVideoController.a().F == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)) || (this.jdField_a_of_type_ComTencentAvVideoController.a().F == 2))
    {
      VideoMemberInfo localVideoMemberInfo = b(paramLong);
      localVideoMemberInfo.jdField_d_of_type_Boolean = paramBoolean;
      if (!localVideoMemberInfo.jdField_d_of_type_Boolean) {
        break label118;
      }
      if (i1 != 0) {
        break label130;
      }
      if (!localVideoMemberInfo.d()) {
        break label124;
      }
      i1 = i2;
    }
    label130:
    for (;;)
    {
      a(paramLong, i1);
      if ((this.jdField_a_of_type_ComTencentAvUiVideoTalkMemberManager != null) && (this.jdField_a_of_type_ComTencentAvUiVideoTalkMemberManager.b(paramLong, paramBoolean))) {
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
  
  void b(ControlUIObserver.ZimuRequest paramZimuRequest)
  {
    boolean bool = false;
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestZimu, mHandle[" + paramZimuRequest.jdField_a_of_type_Int + "], seq[" + paramZimuRequest.a() + "]");
    }
    if (paramZimuRequest.jdField_a_of_type_Int == 2) {
      if ((this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0)))
      {
        this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.a((ViewGroup)this.jdField_a_of_type_AndroidViewView, paramZimuRequest.a());
        if ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity)) {
          ((AVActivity)this.jdField_a_of_type_AndroidContentContext).g(paramZimuRequest.a());
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
          if (paramZimuRequest.jdField_a_of_type_Int == 1)
          {
            a(paramZimuRequest);
            return;
          }
          if ((paramZimuRequest.jdField_a_of_type_Int != 3) && (paramZimuRequest.jdField_a_of_type_Int != 4)) {
            break;
          }
        } while (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0));
        u();
        if (paramZimuRequest.jdField_a_of_type_Int == 3) {
          bool = true;
        }
      } while ((!this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.a(paramZimuRequest.a(), (ViewGroup)this.jdField_a_of_type_AndroidViewView, bool)) || (!(this.jdField_a_of_type_AndroidContentContext instanceof AVActivity)));
      ((AVActivity)this.jdField_a_of_type_AndroidContentContext).g(paramZimuRequest.a());
      return;
    } while (paramZimuRequest.jdField_a_of_type_Int != 5);
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy != null)
    {
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.a(paramZimuRequest.a());
      return;
    }
    ARZimuUtil.a(false);
  }
  
  public void b(Runnable paramRunnable)
  {
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(paramRunnable);
      return;
    }
  }
  
  public boolean b(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!e()) {
      return false;
    }
    if (paramBoolean1) {
      H();
    }
    if (paramBoolean1) {
      b(paramLong, Boolean.valueOf(paramBoolean2));
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = paramBoolean1;
      if ((this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy != null) && (!l())) {
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
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (a(localSessionInfo))
    {
      ScreenLayout localScreenLayout = this.jdField_a_of_type_ComTencentAvUiScreenLayout;
      GLVideoView[] arrayOfGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView;
      int i3 = this.w;
      int i4 = this.q;
      int i5 = this.r;
      if (!localSessionInfo.jdField_e_of_type_Boolean)
      {
        paramBoolean = true;
        localScreenLayout.a(arrayOfGLVideoView, i1, i2, i3, i4, i5, paramBoolean);
        ARZimuTask.c(i2, i1);
      }
    }
    for (;;)
    {
      super.b();
      return;
      paramBoolean = false;
      break;
      if (b(localSessionInfo))
      {
        this.jdField_a_of_type_ComTencentAvUiScreenLayout.a(this.r, this.jdField_d_of_type_AndroidGraphicsRect, this.jdField_e_of_type_AndroidGraphicsRect, this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
        this.jdField_a_of_type_ComTencentAvUiScreenLayout.a(localSessionInfo, this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView, i1, i2, paramBoolean, this.x, this.r);
        new ControlUIObserver.ZimuRequest(l1, "layoutVideoView", 5, null).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
    }
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    return (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MyExploreByTouchHelper != null) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MyExploreByTouchHelper.dispatchHoverEvent(paramMotionEvent));
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
    if ((this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0] != null) && (this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1] != null))
    {
      this.jdField_a_of_type_ComTencentAvUiScreenLayout.a(paramBoolean);
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
  
  public void e(GLCanvas paramGLCanvas)
  {
    int i2 = 1;
    int i1;
    float f1;
    float f2;
    float f3;
    float f4;
    label179:
    Object localObject;
    if (p())
    {
      if (paramGLCanvas.a() <= paramGLCanvas.b()) {
        break label362;
      }
      i1 = 1;
      E();
      if ((i1 == 0) && (this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture != null))
      {
        int i3 = b() / 2;
        int i4 = c() / 2;
        paramGLCanvas.a(i3, i4, 0.0F);
        paramGLCanvas.a(0.0F, 0.0F, b(), c(), Color.parseColor("#1E1F22"));
        f1 = this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture.b().getWidth();
        f2 = this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture.b().getHeight();
        f3 = f1 / f2;
        f4 = b() * 1.0F / c();
        if (f3 <= f4) {
          break label368;
        }
        f3 = f2 * f4;
        f4 = (f1 - f3) / 2.0F;
        this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture.a((int)f4, 0, (int)f3, (int)f2);
        this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture.a((int)f1, (int)f2);
        this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture.a(paramGLCanvas, 0, 0, b(), c());
        paramGLCanvas.a(-i3, -i4, 0.0F);
      }
      localObject = VideoController.a().b();
      if ((localObject == null) || (!((WatchTogetherMediaPlayCtrl)localObject).c())) {
        break label401;
      }
    }
    for (;;)
    {
      if (i2 == 0) {
        g(paramGLCanvas);
      }
      this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherVideoRenderHelper.b(paramGLCanvas.a(), paramGLCanvas.b());
      if (i2 != 0) {
        g(paramGLCanvas);
      }
      localObject = SessionMgr.a().a();
      if ((i1 == 0) && (localObject != null))
      {
        this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherVideoBgRender.a(paramGLCanvas.a(), paramGLCanvas.b());
        this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherVideoBgRender.a(paramGLCanvas, ((SessionInfo)localObject).jdField_j_of_type_Boolean, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin(), ((SessionInfo)localObject).jdField_k_of_type_Boolean, Long.valueOf(((SessionInfo)localObject).jdField_d_of_type_JavaLangString).longValue());
      }
      super.e(paramGLCanvas);
      return;
      label362:
      i1 = 0;
      break;
      label368:
      f3 = f1 / f4;
      f4 = (f2 - f3) / 2.0F;
      this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture.a(0, (int)f4, (int)f1, (int)f3);
      break label179;
      label401:
      i2 = 0;
    }
  }
  
  public void e(boolean paramBoolean)
  {
    AVTraceUtil.a("switch_camera", "onCameraSwitched", 3, new Object[0]);
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
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].o(false);
      this.jdField_a_of_type_ComTencentAvVideoCameraListener$SwitchCameraListener = new VideoLayerUI.6(this, i1, paramBoolean);
      this.jdField_a_of_type_ComTencentAvVideoController.a.a(true, this.jdField_a_of_type_ComTencentAvVideoCameraListener$SwitchCameraListener);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int != 3000) {
        break label304;
      }
      if (!paramBoolean) {
        break label268;
      }
      ReportController.b(null, "CliOper", "", "", "0X80041B5", "0X80041B5", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().J)
      {
        if (!paramBoolean) {
          break;
        }
        ReportController.b(null, "CliOper", "", "", "0X8005211", "0X8005211", 0, 0, "", "", "", "");
      }
      return;
      label268:
      ReportController.b(null, "CliOper", "", "", "0X80041B4", "0X80041B4", 0, 0, "", "", "", "");
      continue;
      label304:
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 1) {
        if (paramBoolean)
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 10) {
            ReportController.b(null, "CliOper", "", "", "0X800593B", "0X800593B", 0, 0, "", "", "", "");
          } else {
            ReportController.b(null, "CliOper", "", "", "0X80046E2", "0X80046E2", 0, 0, "", "", "", "");
          }
        }
        else if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 10) {
          ReportController.b(null, "CliOper", "", "", "0X800593A", "0X800593A", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X80046E1", "0X80046E1", 0, 0, "", "", "", "");
        }
      }
    }
    ReportController.b(null, "CliOper", "", "", "0X8005210", "0X8005210", 0, 0, "", "", "", "");
  }
  
  boolean e()
  {
    return Utils.a(this.jdField_a_of_type_AndroidContentContext) == 2;
  }
  
  public int f()
  {
    return this.jdField_a_of_type_ComTencentAvUiScreenLayout.a();
  }
  
  public void f()
  {
    super.f();
    if (p()) {
      this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherVideoRenderHelper.b();
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
        localObject1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
        a(paramLong, (GLVideoView)localObject1, (String)localObject2, 1, false);
      }
      if ((i1 == 0) && (localObject1 != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)) {
        ((GLVideoView)localObject1).h(false);
      }
      SessionInfo localSessionInfo = SessionMgr.a().a();
      localObject2 = localObject1;
      if (i1 == 0)
      {
        localObject2 = localObject1;
        if (localSessionInfo != null)
        {
          localObject2 = localObject1;
          if (localSessionInfo.A())
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
          ((GLVideoView)localObject2).a(paramLong, CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a());
        }
        ((GLVideoView)localObject2).g(false);
        ((GLVideoView)localObject2).k(false);
        ((GLVideoView)localObject2).m(true);
        ((GLVideoView)localObject2).a(0);
        ((GLVideoView)localObject2).a(ImageView.ScaleType.CENTER_CROP);
      }
      return;
      localObject1 = a((String)localObject2, 1);
      localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
      GraphicRenderMgr.getInstance().setGlRender((String)localObject1, ((GLVideoView)localObject2).a());
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setGlRender[openSelfVideo], key[" + (String)localObject1 + "], index[" + i1 + "], forceToBigView[" + false + "], " + ((GLVideoView)localObject2).d());
    }
  }
  
  void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      F();
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
        AVLog.printColorLog(this.jdField_a_of_type_JavaLangString, "SwitchLocalToBigView:" + bool3 + "|" + bool1);
        return bool2;
        bool1 = false;
        break;
      }
    }
    return false;
  }
  
  public int g()
  {
    return this.p;
  }
  
  public void g()
  {
    super.g();
    if (p()) {
      this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherVideoRenderHelper.a();
    }
  }
  
  public void g(int paramInt)
  {
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "changeLayoutMode, screenStyle[" + this.jdField_a_of_type_ComTencentAvVideoController.a().N + "->" + paramInt + "], ScreenLayout[" + this.jdField_a_of_type_ComTencentAvUiScreenLayout.a() + "->" + paramInt + "], seq[" + l1 + "]");
    if ((b(this.jdField_a_of_type_ComTencentAvVideoController.a())) && (paramInt == 1)) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "changeLayoutMode with error happen", new Throwable());
    }
    super.g(paramInt);
    int i1 = this.jdField_a_of_type_ComTencentAvUiScreenLayout.a();
    if (i1 != paramInt)
    {
      this.jdField_g_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvUiScreenLayout = ScreenLayout.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, false);
      if (i())
      {
        super.a(null);
        super.d(-15197410);
        new ControlUIObserver.ZimuRequest(l1, "changeLayoutMode", 5, null).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
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
        float f1 = UITools.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
        float f2 = UITools.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
        i1 = 0;
        if (i1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
        {
          if (i1 == 0)
          {
            this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].h(false);
            this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].j(12);
            this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].a(f2);
          }
          for (;;)
          {
            this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].i();
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
            this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].h(true);
            this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].j(12);
            this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].a(f1);
          }
        }
      }
      label263:
      label349:
      i1 = 0;
      if (i1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].d(this.jdField_a_of_type_ComTencentAvUiScreenLayout.c());
        GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
        if (paramInt == 3) {}
        for (boolean bool = true;; bool = false)
        {
          localGLVideoView.f(bool);
          a(l1, this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1]);
          i1 += 1;
          break;
        }
      }
      if ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity)) {
        ((AVActivity)this.jdField_a_of_type_AndroidContentContext).g(l1);
      }
      this.jdField_g_of_type_Boolean = false;
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
      F();
    }
    if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null)) {}
    while (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffffff"));
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130850232);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#5f656f"));
    this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130850233);
  }
  
  boolean g()
  {
    boolean bool2 = false;
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
      {
        GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
        if ((localGLVideoView.a() == 0) && (str.equals(localGLVideoView.c()))) {
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
    this.jdField_a_of_type_ComTencentAvUiScreenLayout.a(this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView, paramInt, b(), c(), this.q, this.r);
  }
  
  boolean h()
  {
    return (this.r == 0) || (this.q == 0) || (this.q == this.jdField_k_of_type_Int) || (this.jdField_c_of_type_Boolean);
  }
  
  public void i(int paramInt)
  {
    if (this.I != paramInt) {
      this.I = paramInt;
    }
  }
  
  public void j(int paramInt)
  {
    boolean bool2 = true;
    label48:
    CameraUtils localCameraUtils;
    if ((this.jdField_a_of_type_ComTencentAvUiScreenLayout != null) && (a(this.jdField_a_of_type_ComTencentAvVideoController.a())))
    {
      this.jdField_a_of_type_ComTencentAvUiScreenLayout.a(paramInt);
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
      this.p = paramInt;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label48;
    }
  }
  
  void k(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      F();
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
    this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherVideoRenderHelper.a(this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView);
  }
  
  public void l(int paramInt)
  {
    this.N = paramInt;
  }
  
  protected void m()
  {
    this.jdField_a_of_type_ComTencentAvUiVideoAfterTreatmentManager = new VideoAfterTreatmentManager(this.jdField_a_of_type_ComTencentAvVideoController);
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
    if (this.jdField_a_of_type_ComTencentAvVideoCameraListener$SwitchCameraListener != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a.c();
      this.jdField_a_of_type_ComTencentAvVideoCameraListener$SwitchCameraListener = null;
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
    this.jdField_b_of_type_ComTencentAvOpenglUiGLView$OnTouchListener = null;
    this.jdField_a_of_type_AndroidViewGestureDetector = null;
    this.jdField_a_of_type_ComTencentAvOpenglGesturedetectorsMoveGestureDetector = null;
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = null;
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MultiVideoOpenAnimation = null;
    I();
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy != null)
    {
      if ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity))
      {
        localObject = (AVActivity)this.jdField_a_of_type_AndroidContentContext;
        this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.b(((AVActivity)localObject).jdField_e_of_type_Boolean);
      }
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy = null;
    }
    int i1;
    if ((this.I == -1) || (this.I == 2) || (this.I == 1))
    {
      i1 = 1;
      if (i1 == 0) {
        if (this.jdField_a_of_type_ComTencentAvUiScreenLayout.a() != 3) {
          break label356;
        }
      }
    }
    label356:
    for (Object localObject = "1";; localObject = "2")
    {
      ReportController.b(null, "CliOper", "", "", "0X8009F5D", "0X8009F5D", 0, 0, (String)localObject, "", "", "");
      if (this.jdField_a_of_type_ComTencentAvUiScreenLayout != null)
      {
        this.jdField_a_of_type_ComTencentAvUiScreenLayout.a();
        this.jdField_a_of_type_ComTencentAvUiScreenLayout = null;
      }
      D();
      if (this.jdField_a_of_type_ComTencentAvUiVideoTalkMemberManager != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoTalkMemberManager.b();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      if (this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherVideoRenderHelper != null)
      {
        this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherVideoRenderHelper.c();
        this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherVideoRenderHelper = null;
      }
      if (this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherVideoBgRender != null)
      {
        this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherVideoBgRender.a();
        this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherVideoBgRender = null;
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
    q(this.x);
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
    q(this.x);
  }
  
  void t()
  {
    int i1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0)) && (i1 == 2))
    {
      u();
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.a();
    }
  }
  
  void u()
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy == null) {
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy = new ZimuViewProxy(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI
 * JD-Core Version:    0.7.0.1
 */