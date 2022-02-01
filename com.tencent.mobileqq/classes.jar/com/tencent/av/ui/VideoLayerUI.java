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
    m();
    y();
    z();
    n();
    A();
    l();
    F();
    B();
    s();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "VideoLayerUI");
  }
  
  private void A()
  {
    int i1;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int == 1008)) {
      i1 = 2130842183;
    } else {
      i1 = 2130842022;
    }
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(UITools.a(this.jdField_a_of_type_AndroidContentContext, i1));
    super.a(UITools.a(this.jdField_a_of_type_AndroidContentContext, i1));
  }
  
  private void B()
  {
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(this.jdField_a_of_type_AndroidContentContext, new VideoLayerUI.ScaleGestureListener(this));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new VideoLayerUI.GestureListener(this));
    this.jdField_a_of_type_ComTencentAvOpenglGesturedetectorsMoveGestureDetector = new MoveGestureDetector(this.jdField_a_of_type_AndroidContentContext, new VideoLayerUI.MoveListener(this, null));
    this.jdField_b_of_type_ComTencentAvOpenglUiGLView$OnTouchListener = new VideoLayerUI.WeakTouchListener(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$TouchListener);
    a(this.jdField_b_of_type_ComTencentAvOpenglUiGLView$OnTouchListener);
    this.o = AIOUtils.b(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  private void C()
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
  
  private void D()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture != null) {
      return;
    }
    Bitmap localBitmap = UITools.a(this.jdField_a_of_type_AndroidContentContext, 2130842390);
    if (localBitmap != null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture = new BitmapTexture(localBitmap);
      this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture.a(false);
    }
  }
  
  private void E()
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null)
    {
      this.jdField_a_of_type_ComTencentAvWidgetRotateLayout = ((RotateLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363107));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363116));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363118));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363117));
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources();
      this.L = ((int)localResources.getDimension(2131297867));
      this.M = ((int)localResources.getDimension(2131297868));
      int i1 = (int)(localResources.getDimension(2131296380) + localResources.getDimension(2131296447));
      int i2 = (int)(localResources.getDimension(2131296382) + localResources.getDimension(2131296449));
      int i3 = (int)(localResources.getDimension(2131296379) + localResources.getDimension(2131296446));
      int i4 = (int)(localResources.getDimension(2131296381) + localResources.getDimension(2131296448));
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
  
  private void F()
  {
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MyExploreByTouchHelper = new VideoLayerUI.MyExploreByTouchHelper(this, this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView);
    ViewCompat.setAccessibilityDelegate(this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView, this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MyExploreByTouchHelper);
  }
  
  private void G()
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
      CameraUtils.a(paramContext).setSupportLandscape(true);
      if (QLog.isDevelopLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("setRotation, rotation[");
        paramContext.append(paramInt);
        paramContext.append("], displayRotation[");
        paramContext.append(i1);
        paramContext.append("], viewRotation[");
        paramContext.append(i2);
        paramContext.append("]");
        QLog.w(paramString, 1, paramContext.toString());
      }
      return i2;
    }
    CameraUtils.a(paramContext).setSupportLandscape(false);
    return paramInt;
  }
  
  private Bitmap a(Bitmap paramBitmap)
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
    Bitmap localBitmap = UITools.a(this.jdField_a_of_type_AndroidContentContext, 2130840582);
    Object localObject = localBitmap;
    if (QLog.isDevelopLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
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
  
  private Bitmap a(VideoMemberInfo paramVideoMemberInfo)
  {
    if (paramVideoMemberInfo.jdField_a_of_type_Int == 0) {
      return this.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(paramVideoMemberInfo.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long), this.jdField_a_of_type_ComTencentAvVideoController.a().E, true, false);
    }
    return ((BitmapDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842202)).getBitmap();
  }
  
  private Boolean a()
  {
    boolean bool;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 2) {
      bool = true;
    } else {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
  
  private String a(VideoMemberInfo paramVideoMemberInfo)
  {
    if (paramVideoMemberInfo.jdField_a_of_type_Int == 0) {
      return this.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(paramVideoMemberInfo.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long), this.jdField_a_of_type_ComTencentAvVideoController.a().E);
    }
    long l1 = paramVideoMemberInfo.jdField_a_of_type_Long;
    AVPhoneUserInfo localAVPhoneUserInfo;
    if (paramVideoMemberInfo.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null) {
      localAVPhoneUserInfo = paramVideoMemberInfo.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
    } else {
      localAVPhoneUserInfo = this.jdField_a_of_type_ComTencentAvVideoController.a(l1, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_JavaUtilArrayList);
    }
    if ((localAVPhoneUserInfo != null) && (localAVPhoneUserInfo.telInfo.mobile != null))
    {
      paramVideoMemberInfo.jdField_a_of_type_JavaLangString = localAVPhoneUserInfo.telInfo.mobile;
      paramVideoMemberInfo = this.jdField_a_of_type_ComTencentAvVideoController.a(localAVPhoneUserInfo.telInfo.mobile);
      if (paramVideoMemberInfo != null) {
        return paramVideoMemberInfo;
      }
      return PstnUtils.a(localAVPhoneUserInfo.telInfo.mobile, 4);
    }
    if ((localAVPhoneUserInfo != null) && (QLog.isColorLevel()))
    {
      paramVideoMemberInfo = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMemmberName --> can not get Open Id. PhoneInfo = ");
      localStringBuilder.append(localAVPhoneUserInfo.toString());
      QLog.d(paramVideoMemberInfo, 2, localStringBuilder.toString());
    }
    return this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693109);
  }
  
  private static final String a(CharSequence paramCharSequence)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramCharSequence);
    int i2 = paramCharSequence.length();
    paramCharSequence = (QQText)paramCharSequence;
    int i1 = 0;
    EmoticonSpan[] arrayOfEmoticonSpan = (EmoticonSpan[])paramCharSequence.getSpans(0, i2, EmoticonSpan.class);
    int i3;
    for (i2 = 0; i1 < arrayOfEmoticonSpan.length; i2 = i3)
    {
      Object localObject = arrayOfEmoticonSpan[i1];
      i3 = i2;
      if ((localObject instanceof EmoticonSpan))
      {
        int i4 = paramCharSequence.getSpanStart(localObject);
        int i5 = paramCharSequence.getSpanEnd(localObject);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
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
    paramView = paramView.findViewById(2131363124);
    int i1;
    if ((paramBoolean) && (!VideoController.a().p())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      paramView.setVisibility(0);
      return;
    }
    paramView.setVisibility(8);
  }
  
  private void a(GLCanvas paramGLCanvas, GLView paramGLView, boolean paramBoolean)
  {
    boolean bool = paramGLView.a();
    int i3 = 1;
    int i1;
    if ((!bool) && (!paramGLView.b())) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    int i2;
    if ((paramGLView.b().left - this.C <= this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels) && (paramGLView.b().right - this.C >= 0)) {
      i2 = 0;
    } else {
      i2 = 1;
    }
    if ((i2 != 0) && (!paramBoolean)) {
      i2 = i3;
    } else {
      i2 = 0;
    }
    if (i1 != 0)
    {
      if (i2 != 0) {
        return;
      }
      float f1 = 0;
      paramGLCanvas.a(f1, f1);
      paramGLView.a(paramGLCanvas);
      f1 = 0;
      paramGLCanvas.a(f1, f1);
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
    paramGLVideoView.b();
  }
  
  private void a(boolean paramBoolean, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0))
    {
      t();
      Object localObject = this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.a();
      if (localObject != null)
      {
        localObject = ((ZimuItem)localObject).getId();
        int i1;
        if (!paramBoolean) {
          i1 = 4;
        } else {
          i1 = 1;
        }
        new ControlUIObserver.ZimuRequest(paramLong, "showLastZimu", i1, (String)localObject).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
    }
  }
  
  private boolean a(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof QQText))
    {
      paramCharSequence = (EmoticonSpan[])((QQText)paramCharSequence).getSpans(0, paramCharSequence.length(), EmoticonSpan.class);
      int i1 = 0;
      while (i1 < paramCharSequence.length)
      {
        if (paramCharSequence[i1].emojiType == 2) {
          return true;
        }
        i1 += 1;
      }
    }
    return false;
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
    G();
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
    if (a().booleanValue()) {
      return;
    }
    String str1 = paramRecvMsg.c();
    String str2 = paramRecvMsg.a();
    Object localObject2 = paramRecvMsg.b();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_d_of_type_Boolean)
      {
        localObject1 = localObject2;
        if (str2 != null) {
          localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a(str2, String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long), this.jdField_a_of_type_ComTencentAvVideoController.a().E);
        }
      }
    }
    paramRecvMsg = paramRecvMsg.d();
    if (QLog.isColorLevel())
    {
      localObject2 = this.jdField_a_of_type_JavaLangString;
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
    q(this.x);
    i(true);
    localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject2 != null) {
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    if ((paramRecvMsg != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null))
    {
      localObject1 = new QQText(paramRecvMsg, 11);
      paramRecvMsg = (RecvMsg)localObject1;
      if (a((CharSequence)localObject1)) {
        paramRecvMsg = a((CharSequence)localObject1);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramRecvMsg);
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
    paramGLVideoView.b();
  }
  
  private void b(String paramString, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("closeVideoView[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], index[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    paramString = ImageView.ScaleType.CENTER_INSIDE;
    int i5 = this.jdField_a_of_type_ComTencentAvVideoController.a().d;
    int i1;
    int i2;
    int i4;
    float f1;
    int i3;
    boolean bool1;
    if (paramInt == 0)
    {
      i1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].e();
      float f2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].d();
      i2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].f();
      boolean bool2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].h();
      i4 = i1;
      f1 = f2;
      i3 = i2;
      bool1 = bool2;
      if (i5 == 4)
      {
        paramString = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a();
        i4 = i1;
        f1 = f2;
        i3 = i2;
        bool1 = bool2;
      }
    }
    else
    {
      f1 = 0.0F;
      i4 = 0;
      i3 = 0;
      bool1 = false;
    }
    if ((i5 == 4) && (this.jdField_a_of_type_ComTencentAvUiScreenLayout.a() == 3)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    int i6;
    if ((i1 != 0) && (i2 != 0))
    {
      i2 = paramInt + 1;
      i1 = -1;
      while (i2 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i2].a() == 0) {
          i1 = i2;
        }
        i2 += 1;
      }
      if (i1 != -1)
      {
        i2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt].d();
        i6 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].d();
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt].c(i6);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].c(i2);
        localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt];
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt] = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1] = localObject;
        ((GLVideoView)localObject).a("");
      }
      else
      {
        i1 = paramInt;
      }
      localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
      ((GLVideoView)localObject).a(1);
      ((GLVideoView)localObject).b(null);
      ((GLVideoView)localObject).m(true);
      ((GLVideoView)localObject).k(false);
      ((GLVideoView)localObject).g(false);
      ((GLVideoView)localObject).l(true);
      ((GLVideoView)localObject).a(null, 0);
    }
    else
    {
      i1 = paramInt;
      while (i1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
      {
        if (i1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length - 1)
        {
          localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView;
          i2 = i1 + 1;
          if (localObject[i2].a() == 0)
          {
            i6 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].d();
            int i7 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i2].d();
            this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].c(i7);
            this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i2].c(i6);
            localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
            this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1] = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i2];
            this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i2] = localObject;
            i1 = i2;
            continue;
          }
        }
        localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
        ((GLVideoView)localObject).a(1);
        ((GLVideoView)localObject).b(null);
        ((GLVideoView)localObject).m(true);
        ((GLVideoView)localObject).k(false);
        ((GLVideoView)localObject).g(false);
        ((GLVideoView)localObject).l(true);
        ((GLVideoView)localObject).a(null, 0);
        ((GLVideoView)localObject).a("");
      }
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].h(false);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].k(i4);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(f1);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].j(i3);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].j(bool1);
      if (i5 == 4) {
        if (this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].g() == 2) {
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(ImageView.ScaleType.CENTER_INSIDE);
        } else {
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(paramString);
        }
      }
    }
    c(false);
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_d_of_type_Long != 0L) && (System.currentTimeMillis() - this.jdField_d_of_type_Long < 1000L))
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("bigWindowToSmallWindowAnim, 大小窗正在切换中[");
      ((StringBuilder)localObject2).append(this.jdField_d_of_type_Long);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return false;
    }
    Object localObject1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2];
    ((GLVideoView)localObject1).a(Boolean.valueOf(false));
    ((GLVideoView)localObject1).a(0, 0, 0, 0);
    int i1 = ((GLVideoView)localObject1).d();
    ((GLVideoView)localObject1).c(1);
    float f1 = ((GLVideoView)localObject1).b().left;
    float f2 = ((GLVideoView)localObject1).b().top;
    Object localObject2 = super.a();
    GLAnimation localGLAnimation = new GLAnimation();
    localGLAnimation.b(100);
    localGLAnimation.a(f1, f2, 0.0F, -((Rect)localObject2).left, -((Rect)localObject2).top, 0.0F);
    localGLAnimation.a(((GLVideoView)localObject1).b().width(), ((GLVideoView)localObject1).b().height(), super.b() + ((Rect)localObject2).left + ((Rect)localObject2).right, super.c() + ((Rect)localObject2).top + ((Rect)localObject2).bottom);
    localGLAnimation.a(new VideoLayerUI.7(this, paramInt2, i1, paramInt1));
    localGLAnimation.a(2);
    ((GLVideoView)localObject1).a(localGLAnimation);
    ((GLVideoView)localObject1).b();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    return true;
  }
  
  private void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    paramInt3 = paramInt1 + this.n;
    paramInt4 = this.jdField_l_of_type_Int + paramInt3;
    paramInt1 = 1;
    while (paramInt1 <= i1)
    {
      ((GLView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1 - 1)).b(paramInt3, paramInt2, paramInt4, this.m + paramInt2);
      paramInt4 = this.jdField_l_of_type_Int;
      paramInt3 += this.n + paramInt4;
      paramInt4 += paramInt3;
      paramInt1 += 1;
    }
    paramInt1 = this.jdField_l_of_type_Int;
    paramInt2 = this.n;
    this.H = (i1 * (paramInt1 + paramInt2) + paramInt2);
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
    long l1 = this.jdField_d_of_type_Long;
    Object localObject2 = Boolean.valueOf(false);
    if ((l1 != 0L) && (System.currentTimeMillis() - this.jdField_d_of_type_Long < 1000L))
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("bigWindowToSmallWindowAnim, 大小窗正在切换中[");
      ((StringBuilder)localObject2).append(this.jdField_d_of_type_Long);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return false;
    }
    Object localObject3 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1];
    Object localObject1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2];
    ((GLVideoView)localObject3).a((Boolean)localObject2);
    ((GLVideoView)localObject3).a(0, 0, 0, 0);
    ((GLVideoView)localObject1).a((Boolean)localObject2);
    ((GLVideoView)localObject1).a(0, 0, 0, 0);
    int i1 = ((GLVideoView)localObject1).d();
    ((GLVideoView)localObject1).c(((GLVideoView)localObject3).d());
    localObject2 = ((GLVideoView)localObject1).b();
    localObject3 = ((GLVideoView)localObject3).b();
    GLAnimation localGLAnimation = new GLAnimation();
    localGLAnimation.b(300);
    localGLAnimation.a(((Rect)localObject2).left, ((Rect)localObject2).top, 0.0F, ((Rect)localObject3).left, ((Rect)localObject3).top, 0.0F);
    localGLAnimation.a(((Rect)localObject2).width(), ((Rect)localObject2).height(), ((Rect)localObject3).width(), ((Rect)localObject3).height());
    localGLAnimation.a(new VideoLayerUI.8(this, paramInt2, i1, paramInt1));
    localGLAnimation.a(2);
    ((GLVideoView)localObject1).a(localGLAnimation);
    ((GLVideoView)localObject1).b();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    return true;
  }
  
  private boolean d(int paramInt1, int paramInt2)
  {
    if ((this.jdField_d_of_type_Long != 0L) && (System.currentTimeMillis() - this.jdField_d_of_type_Long < 1000L))
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sliderWindowBigToSmallAnimation, 大小窗正在切换中[");
      localStringBuilder.append(this.jdField_d_of_type_Long);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      return false;
    }
    Object localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2];
    ((GLVideoView)localObject).a(Boolean.valueOf(false));
    ((GLVideoView)localObject).a(0, 0, 0, 0);
    b(new VideoLayerUI.9(this, paramInt1, paramInt2));
    b();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    return true;
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == this.E) && (paramInt2 == this.F)) {
      return;
    }
    if (paramInt1 < paramInt2)
    {
      this.E = paramInt1;
      this.F = paramInt2;
    }
    else
    {
      this.F = 0;
      this.E = 0;
    }
    OnVisiableItemChangeListener localOnVisiableItemChangeListener = this.jdField_a_of_type_ComTencentAvOpenglUiOnVisiableItemChangeListener;
    if (localOnVisiableItemChangeListener != null) {
      localOnVisiableItemChangeListener.a(this.E, this.F);
    }
  }
  
  private void g(GLCanvas paramGLCanvas)
  {
    int i1;
    if (paramGLCanvas.a() > paramGLCanvas.b()) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = AIOUtils.b(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int i4 = WTogetherUtil.a(this.jdField_a_of_type_AndroidContentContext);
    int i3 = b() / 2;
    if (i1 != 0) {
      i2 = c() / 2;
    } else {
      i2 = i2 + i4 + WTogetherUtil.a() / 2;
    }
    paramGLCanvas.a(i3, i2, 0.0F);
    if (i1 != 0) {
      paramGLCanvas.a(0.0F, 0.0F, b(), c(), -16777216);
    } else {
      paramGLCanvas.a(0.0F, 0.0F, b(), WTogetherUtil.a() + 2, -16777216);
    }
    paramGLCanvas.a(-i3, -i2, 0.0F);
  }
  
  private void h(GLCanvas arg1)
  {
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      while (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty())
      {
        Object localObject1 = (Runnable)this.jdField_b_of_type_JavaUtilArrayList.remove(0);
        if (localObject1 != null)
        {
          long l1 = System.currentTimeMillis();
          ((Runnable)localObject1).run();
          l1 = System.currentTimeMillis() - l1;
          if (l1 >= 100L)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("event queue cost too long: ");
            ((StringBuilder)localObject1).append(l1);
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
    if ((this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0] != null) && (this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1] != null))
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].e(paramBoolean);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].e(paramBoolean);
    }
  }
  
  private void i(long paramLong)
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (!this.jdField_c_of_type_Boolean)) {
      ((AVActivity)this.jdField_a_of_type_AndroidContentContext).a.C(paramLong);
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
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("showMsgbox: show = ");
      ((StringBuilder)localObject2).append(paramBoolean);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources();
    int i1 = (int)(((Resources)localObject1).getDimension(2131296380) + ((Resources)localObject1).getDimension(2131296447));
    int i2 = (int)(((Resources)localObject1).getDimension(2131296382) + ((Resources)localObject1).getDimension(2131296449));
    int i3 = (int)(((Resources)localObject1).getDimension(2131296379) + ((Resources)localObject1).getDimension(2131296446));
    int i4 = (int)(((Resources)localObject1).getDimension(2131296381) + ((Resources)localObject1).getDimension(2131296448));
    this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i1, i2, i3, i4);
    this.jdField_b_of_type_AndroidWidgetTextView.getBackground().setAlpha(128);
    if ((this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.isShown()) && (!paramBoolean))
    {
      localObject1 = new AlphaAnimation(1.0F, 0.0F);
      ((AlphaAnimation)localObject1).setDuration(1000L);
      ((AlphaAnimation)localObject1).setFillAfter(true);
      ((AlphaAnimation)localObject1).setAnimationListener(new VideoLayerUI.MsgboxAnimationListener(this, null));
      this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.startAnimation((Animation)localObject1);
      return;
    }
    if (paramBoolean)
    {
      localObject1 = new Transformation();
      ((Transformation)localObject1).setAlpha(0.0F);
      localObject2 = (AlphaAnimation)this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getAnimation();
      if (localObject2 != null)
      {
        ((AlphaAnimation)localObject2).setAnimationListener(null);
        ((AlphaAnimation)localObject2).getTransformation(System.currentTimeMillis(), (Transformation)localObject1);
      }
      float f1 = ((Transformation)localObject1).getAlpha();
      this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.clearAnimation();
      localObject1 = new AlphaAnimation(f1, 1.0F);
      ((AlphaAnimation)localObject1).setDuration(1000L);
      ((AlphaAnimation)localObject1).setFillAfter(true);
      ((AlphaAnimation)localObject1).setFillBefore(true);
      this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.startAnimation((Animation)localObject1);
      this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setTag(Long.valueOf(System.currentTimeMillis()));
    }
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
    if (!this.jdField_l_of_type_Boolean)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentAvWidgetRotateLayout;
      if (localObject1 == null) {
        return;
      }
      localObject1 = (RelativeLayout.LayoutParams)((RotateLayout)localObject1).getLayoutParams();
      int i3 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131299267);
      int i1 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131299268);
      int i4 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131299262);
      int i2 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131299263);
      int i5 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131299261);
      if ((this.r == 0) || (this.q == 0))
      {
        i1 = i3;
        i2 = i4;
      }
      int i6 = j();
      Object localObject2;
      Object localObject3;
      if (i6 <= 0)
      {
        ((RelativeLayout.LayoutParams)localObject1).addRule(11, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(10, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(9, -1);
        ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = i4;
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (i2 + this.r);
        this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject2 = (RotateLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        ((RotateLayout.LayoutParams)localObject2).jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        i2 = this.jdField_a_of_type_AndroidViewView.getWidth() - i4 * 2;
        i3 = this.M;
        i1 = i2;
        if (i2 > i3) {
          i1 = i3;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(i1);
      }
      else
      {
        if ((this.r != 0) && (this.q != 0)) {
          paramInt = 0;
        }
        localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b();
        int i7 = i();
        if (paramInt == 0)
        {
          ((RelativeLayout.LayoutParams)localObject1).addRule(11, 0);
          ((RelativeLayout.LayoutParams)localObject1).addRule(10, 0);
          ((RelativeLayout.LayoutParams)localObject1).addRule(9, -1);
          ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
          if (i6 == 1)
          {
            ((RelativeLayout.LayoutParams)localObject1).leftMargin = i4;
            ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (i2 + this.r);
          }
          else if (i6 == 2)
          {
            if (i7 == 4) {
              ((RelativeLayout.LayoutParams)localObject1).leftMargin = (((Rect)localObject2).width() + i3 + i5);
            } else {
              ((RelativeLayout.LayoutParams)localObject1).leftMargin = i4;
            }
            ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (i2 + this.r);
          }
          else
          {
            ((RelativeLayout.LayoutParams)localObject1).leftMargin = i4;
            ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (i2 + this.r + ((Rect)localObject2).height());
          }
        }
        else if (paramInt == 90)
        {
          ((RelativeLayout.LayoutParams)localObject1).addRule(10, 0);
          ((RelativeLayout.LayoutParams)localObject1).addRule(9, 0);
          ((RelativeLayout.LayoutParams)localObject1).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
          if (i6 == 1)
          {
            ((RelativeLayout.LayoutParams)localObject1).rightMargin = i4;
            ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (i2 + this.r);
          }
          else if (i6 >= 2)
          {
            if (i7 == 3) {
              ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (((Rect)localObject2).height() + i1 + i5 + this.r);
            } else {
              ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (i2 + this.r);
            }
            ((RelativeLayout.LayoutParams)localObject1).rightMargin = i4;
          }
        }
        else if (paramInt == 180)
        {
          ((RelativeLayout.LayoutParams)localObject1).addRule(9, 0);
          ((RelativeLayout.LayoutParams)localObject1).addRule(12, 0);
          ((RelativeLayout.LayoutParams)localObject1).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject1).addRule(10, -1);
          if (i6 == 1)
          {
            ((RelativeLayout.LayoutParams)localObject1).rightMargin = i4;
            ((RelativeLayout.LayoutParams)localObject1).topMargin = (i2 + this.q);
          }
          else if (i6 == 2)
          {
            if (i7 == 2) {
              ((RelativeLayout.LayoutParams)localObject1).rightMargin = (((Rect)localObject2).width() + i3 + i5);
            } else {
              ((RelativeLayout.LayoutParams)localObject1).rightMargin = i4;
            }
            ((RelativeLayout.LayoutParams)localObject1).topMargin = (i2 + this.q);
          }
          else
          {
            ((RelativeLayout.LayoutParams)localObject1).rightMargin = i4;
            if (i7 == 2) {
              ((RelativeLayout.LayoutParams)localObject1).topMargin = (i2 + this.q + ((Rect)localObject2).height());
            } else {
              ((RelativeLayout.LayoutParams)localObject1).topMargin = (i2 + this.q);
            }
          }
        }
        else if (paramInt == 270)
        {
          ((RelativeLayout.LayoutParams)localObject1).addRule(11, 0);
          ((RelativeLayout.LayoutParams)localObject1).addRule(12, 0);
          ((RelativeLayout.LayoutParams)localObject1).addRule(10, -1);
          ((RelativeLayout.LayoutParams)localObject1).addRule(9, -1);
          if (i6 == 1)
          {
            ((RelativeLayout.LayoutParams)localObject1).leftMargin = i4;
            ((RelativeLayout.LayoutParams)localObject1).topMargin = (i2 + this.q);
          }
          else if (i6 >= 2)
          {
            if (i7 == 1) {
              ((RelativeLayout.LayoutParams)localObject1).topMargin = (((Rect)localObject2).height() + i1 + i5 + this.q);
            } else {
              ((RelativeLayout.LayoutParams)localObject1).topMargin = (i2 + this.q);
            }
            ((RelativeLayout.LayoutParams)localObject1).leftMargin = i4;
          }
        }
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin += this.N;
        this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        if (QLog.isDevelopLevel())
        {
          localObject3 = this.jdField_a_of_type_JavaLangString;
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
        localObject3 = (RotateLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        ((RotateLayout.LayoutParams)localObject3).jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = super.b();
        if (i6 == 1) {
          i1 = ((Rect)localObject3).width() - i4 * 2;
        } else {
          i1 = ((Rect)localObject3).width() - ((Rect)localObject2).width() - i3 - i4 - i5;
        }
        i3 = this.M;
        i2 = i1;
        if (i1 > i3) {
          i2 = i3;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(i2);
      }
      if (QLog.isDevelopLevel())
      {
        localObject2 = this.jdField_a_of_type_JavaLangString;
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
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getWidth());
        ((StringBuilder)localObject3).append(", ");
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getHeight());
        ((StringBuilder)localObject3).append("]");
        QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
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
        i1 = 2131695487;
      }
      if ((i1 != 0) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1008, i1);
      }
    }
  }
  
  private void y()
  {
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
    ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindowManager().getDefaultDisplay().getRealMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
    this.n = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297951);
    this.jdField_l_of_type_Int = ((this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels - this.n * 5) / 4);
    this.m = this.jdField_l_of_type_Int;
    int i1 = this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels;
    i1 = this.jdField_l_of_type_Int;
    i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299268);
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
    i1 = AIOUtils.b(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_ComTencentAvUiGLVideoView.a(i1);
    this.jdField_a_of_type_ComTencentAvUiGLVideoView.j(true);
    this.jdField_a_of_type_ComTencentAvUiGLVideoView.d(Color.parseColor("#686E6C"));
    this.jdField_a_of_type_ComTencentAvUiGLVideoView.a(2, Boolean.valueOf(false));
    this.jdField_a_of_type_ComTencentAvUiGLVideoView.c(999);
    a(this.jdField_a_of_type_ComTencentAvUiGLVideoView);
  }
  
  private void z()
  {
    this.w = SharedPreUtils.a(this.jdField_a_of_type_AndroidContentContext).getInt("video_position", 3);
  }
  
  public void B_()
  {
    super.B_();
    q(this.x);
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
  
  protected void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (p()) {
      this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherVideoRenderHelper.a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((!this.jdField_d_of_type_Boolean) && (!l()))
    {
      this.v = paramInt;
      return;
    }
    if ((paramInt == this.u) && (paramInt != this.v)) {
      return;
    }
    int i1 = this.u;
    boolean bool = false;
    if (paramInt % 90 != i1 % 90) {
      this.s = 0;
    }
    this.u = paramInt;
    this.v = paramInt;
    i1 = a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentContext, paramInt, paramBoolean, this.jdField_a_of_type_AndroidViewDisplay);
    if ((paramInt == 0) || (paramInt == 90) || (paramInt == 180) || (paramInt == 270))
    {
      paramInt = 0;
      while (paramInt < super.e())
      {
        super.a(paramInt).b(i1);
        paramInt += 1;
      }
      q(i1);
      this.x = i1;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 2)
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
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyControlUIOffset, mTopOffset[");
      localStringBuilder.append(this.q);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], mBottomOffset[");
      localStringBuilder.append(this.r);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], mFullScreen[");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.q = paramInt1;
    this.r = paramInt2;
    c(true);
    q(this.x);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 4)
    {
      paramBoolean = this.jdField_a_of_type_ComTencentAvVideoController.a().y;
      paramInt1 = 0;
      paramInt2 = 0;
      if (!paramBoolean)
      {
        paramInt1 = paramInt2;
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
    Object localObject = this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy;
    if (localObject != null) {
      ((ZimuViewProxy)localObject).a(this, this.q, this.r);
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
    if (paramGLVideoView != null)
    {
      String str1 = a(paramString, paramInt);
      paramGLVideoView.a(paramString, paramInt);
      paramGLVideoView.a(0);
      paramGLVideoView.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      try
      {
        paramString = paramGLVideoView.a();
        GraphicRenderMgr.getInstance().setAccountUin(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        GraphicRenderMgr.setGlRender(str1, paramString);
        String str2 = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setGlRender[initGLVideoViewBasePara], key[");
        localStringBuilder.append(str1);
        localStringBuilder.append("], debug[");
        localStringBuilder.append(paramGLVideoView.d());
        localStringBuilder.append("], videoSrcType[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("], yuvTexture[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.w(str2, 1, localStringBuilder.toString());
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.a().d, false, paramBoolean);
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
      GraphicRenderMgr.getInstance().flushGlRender(paramString);
      GraphicRenderMgr.setGlRender(paramString, null);
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGlRender[closePeerVideo_no], key[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], index[");
      localStringBuilder.append(i1);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.a().d, true, true);
      b("closePeerVideo", i1);
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i1 = a("setBackground", paramString, paramInt);
    int i3 = 1;
    int i2 = i1;
    Object localObject;
    if (i1 < 0)
    {
      i1 = a(0);
      if (i1 >= 0)
      {
        boolean bool = paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()) ^ true;
        localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
        a(paramLong, (GLVideoView)localObject, paramString, paramInt, bool);
        if ((localObject != null) && (!bool)) {
          ((GLVideoView)localObject).a(paramLong, CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).isFrontCamera());
        }
      }
      if ((paramBoolean2) && (i1 > 0))
      {
        a(0, i1);
        i1 = 0;
      }
      i2 = i1;
      if (i1 > 0) {}
    }
    else
    {
      i3 = 0;
      i1 = i2;
    }
    if (i1 >= 0)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
      ((GLVideoView)localObject).a(paramBitmap);
      ((GLVideoView)localObject).m(paramBoolean1);
      if (!paramBoolean1) {
        ((GLVideoView)localObject).k(false);
      }
    }
    if (i3 != 0) {
      m(i1);
    }
    if (QLog.isColorLevel())
    {
      paramBitmap = this.jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setBackground uin: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", videoSrcType: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", index: ");
      ((StringBuilder)localObject).append(i1);
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
    int i1 = a(((StringBuilder)localObject).toString(), paramString, paramInt);
    boolean bool;
    if (a(this.jdField_a_of_type_ComTencentAvVideoController.a()))
    {
      if ((!paramBoolean1) && (!k())) {
        bool = true;
      } else {
        bool = paramBoolean1;
      }
      if (i1 > 1)
      {
        SmallScreenUtils.a();
        paramString = this.jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("SetGlRender index break!!!!!! index=");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(", remotehasvideo=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean);
        QLog.e(paramString, 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    else
    {
      bool = paramBoolean1;
    }
    String str = a(paramString, paramInt);
    if (i1 < 0)
    {
      i1 = a(0);
      if (i1 >= 0)
      {
        localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
        a(paramLong, (GLVideoView)localObject, paramString, paramInt, true);
        paramString = (String)localObject;
      }
      else
      {
        paramString = null;
      }
      if ((paramString != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() <= 1) && (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 4)) {
        paramString.a(AIOUtils.b(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      }
      paramInt = i1;
      localObject = paramString;
      if (i1 > 1)
      {
        paramInt = i1;
        localObject = paramString;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 4)
        {
          paramInt = 1;
          break label463;
        }
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
      GraphicRenderMgr.setGlRender(str, ((GLVideoView)localObject).a());
      paramString = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGlRender[openPeerVideo], key[");
      localStringBuilder.append(str);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], index[");
      localStringBuilder.append(i1);
      localStringBuilder.append("], ");
      localStringBuilder.append(((GLVideoView)localObject).d());
      QLog.w(paramString, 1, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.a().d, false, true);
      paramInt = i1;
    }
    int i2 = 0;
    paramString = (String)localObject;
    i1 = paramInt;
    paramInt = i2;
    label463:
    if (paramString != null)
    {
      paramString.g(paramBoolean2);
      paramString.a(paramLong, this.jdField_a_of_type_ComTencentAvUiScreenLayout.c());
      paramString.k(paramBoolean1 ^ true);
      paramString.a(0);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 4)
      {
        if (i1 == 0)
        {
          paramString.a(ImageView.ScaleType.CENTER_INSIDE);
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().L == 3) {
            paramString.h(true);
          }
        }
        else
        {
          paramString.a(ImageView.ScaleType.CENTER_CROP);
        }
      }
      else if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2) {
        paramString.a(ImageView.ScaleType.CENTER_INSIDE);
      }
    }
    if ((bool) && (i1 > 0) && (!f()) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().d != 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().i))) {
      a(0, i1);
    }
    if (paramInt != 0) {
      m(i1);
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
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
      localStringBuilder.append(this.jdField_d_of_type_Boolean);
      localStringBuilder.append("], isFillBlackEdge[");
      localStringBuilder.append(paramBoolean3);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())))
    {
      if (!e()) {
        return;
      }
      n();
      if (paramBoolean1) {
        a(paramLong, paramString, paramInt, paramBoolean2, paramBoolean3);
      } else {
        a(paramLong, paramString, paramInt);
      }
      if ((this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy != null) && (!g())) {
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
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      E();
    }
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setOnClickListener(paramOnClickListener);
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
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int == 1011) {
      return;
    }
    String str1 = paramRecvMsg.c();
    String str2 = paramRecvMsg.a();
    String str3 = paramRecvMsg.b();
    String str4 = paramRecvMsg.d();
    if (QLog.isColorLevel())
    {
      String str5 = this.jdField_a_of_type_JavaLangString;
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
    if (str2.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
      return;
    }
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
  
  void a(ControlUIObserver.ZimuRequest paramZimuRequest)
  {
    t();
    String str = paramZimuRequest.b;
    long l1 = paramZimuRequest.a();
    if ((this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.a(paramZimuRequest.a(), str, (ViewGroup)this.jdField_a_of_type_AndroidViewView, this.q, this.r)) && ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity))) {
      ((AVActivity)this.jdField_a_of_type_AndroidContentContext).g(l1);
    }
  }
  
  protected void a(Integer paramInteger, Object paramObject)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyEvent :");
    localStringBuilder.append(paramInteger);
    localStringBuilder.append("|");
    localStringBuilder.append(paramObject);
    AVLog.printColorLog(str, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { paramInteger, paramObject });
  }
  
  void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvUiScreenLayout.a() != 2)
    {
      String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchLocalView_");
      localStringBuilder.append(paramString);
      a(localStringBuilder.toString(), str);
    }
  }
  
  void a(String paramString1, int paramInt1, String paramString2, float paramFloat, int paramInt2)
  {
    int i1 = a("setText", paramString1, paramInt1);
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    if (bool2)
    {
      String str = this.jdField_a_of_type_JavaLangString;
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
      localStringBuilder.append(i1);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (i1 >= 0)
    {
      paramString1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
      paramString1.a(0);
      paramString1.b(paramString2);
      paramString1.a(paramFloat);
      paramString1.k(paramInt2);
      if (f() == 3)
      {
        if ((i1 <= 0) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() <= 1)) {
          paramString1.a(AIOUtils.b(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        }
      }
      else {
        while (i1 == 0)
        {
          bool1 = false;
          break;
        }
      }
      paramString1.h(bool1);
      if (i1 == 0)
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 2)
        {
          paramString1.b("");
          return;
        }
        paramString1.j(12);
        return;
      }
      if (b(this.jdField_a_of_type_ComTencentAvVideoController.a()))
      {
        paramString1.j(12);
        return;
      }
      paramString1.j(2147483647);
    }
  }
  
  public void a(ArrayList<VideoController.GAudioFriends> paramArrayList)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "notifyAudioMemberChange");
    VideoTalkMemberManager localVideoTalkMemberManager = this.jdField_a_of_type_ComTencentAvUiVideoTalkMemberManager;
    if (localVideoTalkMemberManager != null) {
      localVideoTalkMemberManager.a(paramArrayList);
    }
  }
  
  protected void a(Observable paramObservable, Object paramObject)
  {
    paramObservable = (Object[])paramObject;
    int i1 = ((Integer)paramObservable[0]).intValue();
    if (i1 != 6005)
    {
      if (i1 != 6008)
      {
        if (i1 != 6010)
        {
          if (i1 != 6013)
          {
            if (i1 != 6501) {
              return;
            }
            if ((this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0))) {
              this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.a(true);
            }
          }
          else
          {
            c(true);
          }
        }
        else
        {
          t();
          r(((Integer)paramObservable[1]).intValue());
        }
      }
      else
      {
        t();
        paramObservable = (SentenceInfo)paramObservable[1];
        this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.a(paramObservable);
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
  
  protected boolean a(int paramInt1, int paramInt2)
  {
    String str1;
    if (QLog.isColorLevel())
    {
      str1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].c();
      String str2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].c();
      String str3 = this.jdField_a_of_type_JavaLangString;
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
    if ((paramInt1 != paramInt2) && (paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length) && (paramInt2 >= 0) && (paramInt2 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length))
    {
      if (paramInt2 == 0)
      {
        c(paramInt1, paramInt2);
        return true;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 4)
      {
        if (paramInt1 == 0) {
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_INSIDE);
        } else if (paramInt2 == 0) {
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
        }
        str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].c();
        if (str1.equals(this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].c())) {
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
        }
      }
      if ((this.jdField_a_of_type_ComTencentAvUiScreenLayout != null) && (this.jdField_a_of_type_ComTencentAvUiScreenLayout.a() == 3)) {
        return c(paramInt1, paramInt2);
      }
      if ((this.jdField_a_of_type_ComTencentAvUiScreenLayout != null) && (this.jdField_a_of_type_ComTencentAvUiScreenLayout.a() == 4)) {
        return d(paramInt1, paramInt2);
      }
      return b(paramInt1, paramInt2);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "switchVideo index invalid!");
    }
    return false;
  }
  
  public boolean a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!e()) {
      return false;
    }
    if (paramBoolean1) {
      a(paramLong, Boolean.valueOf(paramBoolean2));
    } else {
      c(paramLong);
    }
    this.jdField_e_of_type_Boolean = paramBoolean1;
    return true;
  }
  
  boolean a(String paramString, int paramInt)
  {
    return a("hasVideoView", paramString, paramInt) >= 0;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    int i1 = a("setVideoToBigView", paramString2, 1);
    boolean bool = false;
    if (i1 > 0) {
      bool = a(0, i1);
    }
    if (QLog.isDevelopLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setVideoToBigView[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("], uin[");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("], index[");
      localStringBuilder.append(i1);
      localStringBuilder.append("], bRet[");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.d(str, 1, localStringBuilder.toString());
    }
    return bool;
  }
  
  public void b(long paramLong)
  {
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
      else
      {
        localObject1 = null;
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
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 4)
          {
            ((GLVideoView)localObject1).h(false);
            i1 = i2;
            localObject2 = localObject1;
          }
        }
      }
    }
    else
    {
      localObject1 = a((String)localObject2, 2);
      localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
      localObject3 = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGlRender[openSelfScreenShareRender], key[");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("], index[");
      localStringBuilder.append(i1);
      localStringBuilder.append("], forceToBigView[");
      localStringBuilder.append(false);
      localStringBuilder.append("], ");
      localStringBuilder.append(((GLVideoView)localObject2).d());
      QLog.w((String)localObject3, 1, localStringBuilder.toString());
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("setGlRender[openSelfScreenShareRender], index:=");
    ((StringBuilder)localObject3).append(i1);
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject3).toString());
    if (localObject2 != null)
    {
      ((GLVideoView)localObject2).g(false);
      ((GLVideoView)localObject2).k(false);
      ((GLVideoView)localObject2).m(true);
      ((GLVideoView)localObject2).a(0);
      ((GLVideoView)localObject2).a(ImageView.ScaleType.CENTER_CROP);
    }
  }
  
  void b(long paramLong, Boolean paramBoolean)
  {
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
    int i1 = a("openSelfVideo", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), 1);
    f(paramLong);
    if ((paramBoolean.booleanValue()) && (i1 > 0) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().d != 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().i))) {
      a(0, i1);
    }
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
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestZimu, mHandle[");
      localStringBuilder.append(paramZimuRequest.jdField_a_of_type_Int);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramZimuRequest.a());
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    if (paramZimuRequest.jdField_a_of_type_Int == 2)
    {
      if ((this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0)))
      {
        this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.a((ViewGroup)this.jdField_a_of_type_AndroidViewView, paramZimuRequest.a());
        if ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity)) {
          ((AVActivity)this.jdField_a_of_type_AndroidContentContext).g(paramZimuRequest.a());
        }
      }
    }
    else
    {
      if (paramZimuRequest.jdField_a_of_type_Int == 1)
      {
        a(paramZimuRequest);
        return;
      }
      if ((paramZimuRequest.jdField_a_of_type_Int != 3) && (paramZimuRequest.jdField_a_of_type_Int != 4))
      {
        if (paramZimuRequest.jdField_a_of_type_Int == 5)
        {
          localObject = this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy;
          if (localObject != null) {
            ((ZimuViewProxy)localObject).a(paramZimuRequest.a());
          }
        }
      }
      else if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0))
      {
        t();
        if (paramZimuRequest.jdField_a_of_type_Int != 3) {
          bool1 = false;
        }
        if ((this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.a(paramZimuRequest.a(), (ViewGroup)this.jdField_a_of_type_AndroidViewView, bool1)) && ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity))) {
          ((AVActivity)this.jdField_a_of_type_AndroidContentContext).g(paramZimuRequest.a());
        }
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
  
  public boolean b(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!e()) {
      return false;
    }
    if (paramBoolean1) {
      b(paramLong, Boolean.valueOf(paramBoolean2));
    } else {
      e(paramLong);
    }
    this.jdField_d_of_type_Boolean = paramBoolean1;
    if ((this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy != null) && (!l())) {
      a(paramBoolean1, paramLong);
    }
    return true;
  }
  
  public void c(long paramLong)
  {
    String str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int i1 = a("closeSelfScreenShare", str1, 2);
    if (i1 >= 0)
    {
      str1 = a(str1, 2);
      String str2 = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGlRender[closeSelfVideo_no], key[");
      localStringBuilder.append(str1);
      localStringBuilder.append("], index[");
      localStringBuilder.append(i1);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str2, 1, localStringBuilder.toString());
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
      this.jdField_a_of_type_ComTencentAvUiScreenLayout.a(this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView, i1, i2, this.w, this.q, this.r, localSessionInfo.jdField_e_of_type_Boolean ^ true);
    }
    else if (b(localSessionInfo))
    {
      this.jdField_a_of_type_ComTencentAvUiScreenLayout.a(this.r, this.jdField_d_of_type_AndroidGraphicsRect, this.jdField_e_of_type_AndroidGraphicsRect, this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
      this.jdField_a_of_type_ComTencentAvUiScreenLayout.a(localSessionInfo, this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView, i1, i2, paramBoolean, this.x, this.r);
      new ControlUIObserver.ZimuRequest(l1, "layoutVideoView", 5, null).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    super.b();
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    VideoLayerUI.MyExploreByTouchHelper localMyExploreByTouchHelper = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MyExploreByTouchHelper;
    return (localMyExploreByTouchHelper != null) && (localMyExploreByTouchHelper.dispatchHoverEvent(paramMotionEvent));
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
      Object localObject = GraphicRenderMgr.getInstance();
      ((IGraphicRender)localObject).flushGlRender(str);
      ((IGraphicRender)localObject).clearCameraFrames();
      GraphicRenderMgr.setGlRender(str, null);
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGlRender[closeSelfVideo_no], key[");
      localStringBuilder.append(str);
      localStringBuilder.append("], index[");
      localStringBuilder.append(i1);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.a().d, true, false);
      g(paramLong);
    }
  }
  
  protected void e(GLCanvas paramGLCanvas)
  {
    if (p())
    {
      int i1 = paramGLCanvas.a();
      int i3 = paramGLCanvas.b();
      int i2 = 1;
      if (i1 > i3) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      D();
      if ((i1 == 0) && (this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture != null))
      {
        i3 = b() / 2;
        int i4 = c() / 2;
        paramGLCanvas.a(i3, i4, 0.0F);
        paramGLCanvas.a(0.0F, 0.0F, b(), c(), Color.parseColor("#1E1F22"));
        float f1 = this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture.b().getWidth();
        float f2 = this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture.b().getHeight();
        float f3 = f1 / f2;
        float f4 = b() * 1.0F / c();
        if (f3 > f4)
        {
          f3 = f4 * f2;
          f4 = (f1 - f3) / 2.0F;
          this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture.a((int)f4, 0, (int)f3, (int)f2);
        }
        else
        {
          f3 = f1 / f4;
          f4 = (f2 - f3) / 2.0F;
          this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture.a(0, (int)f4, (int)f1, (int)f3);
        }
        this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture.a((int)f1, (int)f2);
        this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture.a(paramGLCanvas, 0, 0, b(), c());
        paramGLCanvas.a(-i3, -i4, 0.0F);
      }
      Object localObject = VideoController.a().b();
      if ((localObject == null) || (!((WatchTogetherMediaPlayCtrl)localObject).c())) {
        i2 = 0;
      }
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
        this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherVideoBgRender.a(paramGLCanvas, ((SessionInfo)localObject).jdField_j_of_type_Boolean, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin(), ((SessionInfo)localObject).jdField_k_of_type_Boolean, Long.valueOf(((SessionInfo)localObject).jdField_c_of_type_JavaLangString).longValue());
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
      str = this.jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCameraSwitched isFrontCamera: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d(str, 2, ((StringBuilder)localObject).toString());
    }
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int i1 = a("onCameraSwitched", str, 1);
    if (i1 >= 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(1);
      str = ((StringBuilder)localObject).toString();
      localObject = GraphicRenderMgr.getInstance();
      ((IGraphicRender)localObject).clearCameraFrames();
      ((IGraphicRender)localObject).flushGlRender(str);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].o(false);
      this.jdField_a_of_type_ComTencentAvVideoCameraListener$SwitchCameraListener = new VideoLayerUI.6(this, i1, paramBoolean);
      this.jdField_a_of_type_ComTencentAvVideoController.a.a(true, this.jdField_a_of_type_ComTencentAvVideoCameraListener$SwitchCameraListener);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 4) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int == 3000)
      {
        if (paramBoolean) {
          ReportController.b(null, "CliOper", "", "", "0X80041B5", "0X80041B5", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X80041B4", "0X80041B4", 0, 0, "", "", "", "");
        }
      }
      else if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int == 1) {
        if (paramBoolean)
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 10) {
            ReportController.b(null, "CliOper", "", "", "0X800593B", "0X800593B", 0, 0, "", "", "", "");
          } else {
            ReportController.b(null, "CliOper", "", "", "0X80046E2", "0X80046E2", 0, 0, "", "", "", "");
          }
        }
        else if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 10) {
          ReportController.b(null, "CliOper", "", "", "0X800593A", "0X800593A", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X80046E1", "0X80046E1", 0, 0, "", "", "", "");
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().y)
    {
      if (paramBoolean)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005211", "0X8005211", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X8005210", "0X8005210", 0, 0, "", "", "", "");
    }
  }
  
  boolean e()
  {
    return Utils.a(this.jdField_a_of_type_AndroidContentContext) == 2;
  }
  
  public int f()
  {
    return this.jdField_a_of_type_ComTencentAvUiScreenLayout.a();
  }
  
  protected void f()
  {
    super.f();
    if (p()) {
      this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherVideoRenderHelper.b();
    }
  }
  
  public void f(long paramLong)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int i1 = a("openSelfVideo", (String)localObject2, 1);
    Object localObject1;
    Object localObject3;
    if (i1 < 0)
    {
      i1 = a(0);
      if (i1 >= 0)
      {
        localObject1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
        a(paramLong, (GLVideoView)localObject1, (String)localObject2, 1, false);
      }
      else
      {
        localObject1 = null;
      }
      if ((i1 == 0) && (localObject1 != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 4)) {
        ((GLVideoView)localObject1).h(false);
      }
      localObject3 = SessionMgr.a().a();
      localObject2 = localObject1;
      if (i1 == 0)
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
      localObject1 = a((String)localObject2, 1);
      localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
      GraphicRenderMgr.setGlRender((String)localObject1, ((GLVideoView)localObject2).a());
      localObject3 = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGlRender[openSelfVideo], key[");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("], index[");
      localStringBuilder.append(i1);
      localStringBuilder.append("], forceToBigView[");
      localStringBuilder.append(false);
      localStringBuilder.append("], ");
      localStringBuilder.append(((GLVideoView)localObject2).d());
      QLog.w((String)localObject3, 1, localStringBuilder.toString());
    }
    if (localObject2 != null)
    {
      if (CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).isCameraOpened(paramLong)) {
        ((GLVideoView)localObject2).a(paramLong, CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).isFrontCamera());
      }
      ((GLVideoView)localObject2).g(false);
      ((GLVideoView)localObject2).k(false);
      ((GLVideoView)localObject2).m(true);
      ((GLVideoView)localObject2).a(0);
      ((GLVideoView)localObject2).a(ImageView.ScaleType.CENTER_CROP);
    }
  }
  
  void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      E();
    }
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localTextView.setVisibility(i1);
    }
  }
  
  boolean f()
  {
    boolean bool3 = this.jdField_a_of_type_AndroidContentContext instanceof AVActivity;
    boolean bool1 = false;
    boolean bool2 = false;
    if (bool3)
    {
      bool3 = ((AVActivity)this.jdField_a_of_type_AndroidContentContext).a();
      boolean bool4 = k() ^ true;
      bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (bool4) {
          bool1 = true;
        }
      }
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SwitchLocalToBigView:");
      localStringBuilder.append(bool3);
      localStringBuilder.append("|");
      localStringBuilder.append(bool4);
      AVLog.printColorLog(str, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public int g()
  {
    return this.p;
  }
  
  protected void g()
  {
    super.g();
    if (p()) {
      this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherVideoRenderHelper.a();
    }
  }
  
  public void g(int paramInt)
  {
    long l1 = AudioHelper.b();
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("changeLayoutMode, screenStyle[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.a().L);
    localStringBuilder.append("->");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], ScreenLayout[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiScreenLayout.a());
    localStringBuilder.append("->");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
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
      }
      else
      {
        A();
        a(Integer.valueOf(6501), null);
      }
      c(true);
      if ((i1 == 3) && (paramInt == 4)) {
        i1 = 1;
      } else if ((i1 == 4) && (paramInt == 3)) {
        i1 = 2;
      } else if (paramInt == 3) {
        i1 = 3;
      } else {
        i1 = 0;
      }
      if (i1 == 1)
      {
        float f1 = UITools.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
        float f2 = UITools.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
        i1 = 0;
        while (i1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
        {
          if (i1 == 0)
          {
            this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].h(false);
            this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].j(12);
            this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].a(f2);
          }
          else
          {
            this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].h(true);
            this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].j(12);
            this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].a(f1);
          }
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].i();
          i1 += 1;
        }
      }
      i1 = 0;
      while (i1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1].d(this.jdField_a_of_type_ComTencentAvUiScreenLayout.c());
        localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
        boolean bool;
        if (paramInt == 3) {
          bool = true;
        } else {
          bool = false;
        }
        ((GLVideoView)localObject).f(bool);
        a(l1, this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1]);
        i1 += 1;
      }
      if ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity)) {
        ((AVActivity)this.jdField_a_of_type_AndroidContentContext).g(l1);
      }
      this.jdField_g_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 4) {
        i(paramInt);
      }
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
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        if (paramBoolean)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffffff"));
          this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130850159);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#5f656f"));
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130850160);
      }
    }
  }
  
  boolean g()
  {
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
    {
      GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i1];
      if ((localGLVideoView.a() == 0) && (str.equals(localGLVideoView.c()))) {
        return true;
      }
      i1 += 1;
    }
    return false;
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
    if ((this.jdField_a_of_type_ComTencentAvUiScreenLayout != null) && (a(this.jdField_a_of_type_ComTencentAvVideoController.a())))
    {
      this.jdField_a_of_type_ComTencentAvUiScreenLayout.a(paramInt);
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
      ICameraManagerApi localICameraManagerApi = CameraUtils.a(this.jdField_a_of_type_AndroidContentContext);
      if (paramInt != 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localICameraManagerApi.setCameraSensorMode(bool1);
    }
    this.p = paramInt;
  }
  
  void k(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      E();
    }
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      localTextView.setMaxLines(paramInt);
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
  
  public void m() {}
  
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
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy != null)
    {
      if ((this.jdField_a_of_type_AndroidContentContext instanceof AVActivity))
      {
        localObject = (AVActivity)this.jdField_a_of_type_AndroidContentContext;
        this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.b(((AVActivity)localObject).jdField_e_of_type_Boolean);
      }
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy = null;
    }
    int i3 = this.I;
    int i2 = 1;
    int i1 = i2;
    if (i3 != -1)
    {
      i1 = i2;
      if (i3 != 2) {
        if (i3 == 1) {
          i1 = i2;
        } else {
          i1 = 0;
        }
      }
    }
    if (i1 == 0)
    {
      if (this.jdField_a_of_type_ComTencentAvUiScreenLayout.a() == 3) {
        localObject = "1";
      } else {
        localObject = "2";
      }
      ReportController.b(null, "CliOper", "", "", "0X8009F5D", "0X8009F5D", 0, 0, (String)localObject, "", "", "");
    }
    if (this.jdField_a_of_type_ComTencentAvUiScreenLayout != null)
    {
      this.jdField_a_of_type_ComTencentAvUiScreenLayout.a();
      this.jdField_a_of_type_ComTencentAvUiScreenLayout = null;
    }
    C();
    Object localObject = this.jdField_a_of_type_ComTencentAvUiVideoTalkMemberManager;
    if (localObject != null) {
      ((VideoTalkMemberManager)localObject).b();
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
  }
  
  public void q()
  {
    if (this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.onResume();
    }
  }
  
  protected void r()
  {
    this.jdField_l_of_type_Boolean = false;
    q(this.x);
  }
  
  void s()
  {
    int i1 = this.jdField_a_of_type_ComTencentAvVideoController.a().d;
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0)) && (i1 == 2))
    {
      t();
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.a();
    }
  }
  
  void t()
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy == null) {
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy = new ZimuViewProxy(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI
 * JD-Core Version:    0.7.0.1
 */