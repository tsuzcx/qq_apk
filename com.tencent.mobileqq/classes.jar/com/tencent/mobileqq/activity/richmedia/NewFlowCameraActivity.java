package com.tencent.mobileqq.activity.richmedia;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ConfigurationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Camera.FaceDetectionListener;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.TextureView;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.AddressDataProvider;
import com.tencent.biz.qqstory.model.DataProviderManager;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.QQStoryTakeVideoHelper;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.biz.qqstory.takevideo.EditPicActivity;
import com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import com.tencent.biz.qqstory.takevideo.EditTakeGifSource;
import com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import com.tencent.biz.qqstory.takevideo.NewStoryCameraZoom;
import com.tencent.biz.qqstory.takevideo.TakeVideoUtils;
import com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.biz.qqstory.takevideo2.GetFirstMediaThumbnailFunction;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.qwallet.QWalletCameraInterface;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoClipSpec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoState;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr.ForceReleaseLockOnPause;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr.ViewBitmapSource;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoThumbGenMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoThumbGenMgr.ThumbGenItem;
import com.tencent.mobileqq.activity.richmedia.state.RMViewSTInterface;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover;
import com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView;
import com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView.CameraGlFilterListener;
import com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView.SVRecordSessionParam;
import com.tencent.mobileqq.activity.richmedia.view.CameraTextureView;
import com.tencent.mobileqq.activity.richmedia.view.ExtendEditText;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.ar.FramePerformanceMonitor;
import com.tencent.mobileqq.ar.GapDataCollector.RefreshData;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.intervideo.now.NowProxy;
import com.tencent.mobileqq.nearby.NearbyVideoUtils;
import com.tencent.mobileqq.richmedia.CompoundProcessor;
import com.tencent.mobileqq.richmedia.RichmediaClient;
import com.tencent.mobileqq.richmedia.VideoCompoundController;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.gesture.GLGestureProxy;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.IPtvTemplateUpdateListener;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.VideoEnvironment.ShortVideoConfig;
import com.tencent.mobileqq.shortvideo.common.GloableValue;
import com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwAutoSegmentMgr;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwOutputNotify;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.Callback;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraPreview;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.SurfacePreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.TexturePreviewContext;
import com.tencent.mobileqq.shortvideo.ptvfilter.FilterProcessRender;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureRecognitionUtils;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.shortvideo.util.ShortVideoGuideUtil;
import com.tencent.mobileqq.shortvideo.util.VideoAnimation;
import com.tencent.mobileqq.shortvideo.util.storage.StorageManager;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.IMPlayerEndListener;
import com.tencent.mobileqq.shortvideo.widget.TCProgressBar.DelEvent;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.QzoneTextBuilder;
import com.tencent.mobileqq.tribe.fragment.TribeEffectsCameraCaptureFragment;
import com.tencent.mobileqq.tribe.fragment.TribeTakeVideoHelper;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.HorizontalListView;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.font.FontInterface;
import cooperation.qzone.font.FontManager.DefaultFontInfo;
import cooperation.qzone.report.QzoneOnlineTimeCollectRptService;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.gifCoderWnsConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.AppRuntime;
import xpq;
import xpr;
import xpt;
import xpu;
import xpv;
import xpx;
import xpy;
import xpz;
import xqa;
import xqb;
import xqc;
import xqd;
import xqe;
import xqf;
import xqj;
import xql;
import xqm;
import xqn;
import xqo;
import xqp;
import xqq;
import xqr;
import xqs;
import xqt;
import xqu;
import xqv;
import xqw;
import xqx;
import xqy;
import xqz;
import xra;
import xrb;
import xrc;
import xrd;
import xre;
import xrf;
import xrg;
import xrh;
import xri;
import xrj;
import xrl;
import xrm;
import xrn;
import xro;
import xrp;
import xrq;
import xrr;
import xrs;
import xru;
import xrv;
import xrw;
import xrx;
import xry;
import xrz;
import xsa;
import xsc;
import xsd;
import xsi;

@TargetApi(14)
public class NewFlowCameraActivity
  extends FlowActivity
  implements Handler.Callback, View.OnClickListener, MediaScanner.OnMediaInfoScannerListener, FlowComponentInterface, PtvTemplateAdapter.IPtvTemplateItemChangedCallback, PtvTemplateAdapter.IPtvTemplateItemSelectedCallback, ShortVideoCaptureController.CaptureProcessObserver, RMVideoSwitchCameraPicMgr.ViewBitmapSource, RMViewSTInterface, CameraFilterGLView.CameraGlFilterListener, HWEncodeListener, PtvTemplateManager.IPtvTemplateUpdateListener, ImageViewVideoPlayer.IMPlayerEndListener, TCProgressBar.DelEvent, Runnable
{
  public static int a;
  public static long a;
  public static boolean a;
  private static final boolean aD;
  private static boolean aF;
  private static boolean aR;
  public static float b;
  public static long c;
  public static boolean d;
  private static String jdField_n_of_type_JavaLangString;
  private static String o;
  private static String p;
  private static int jdField_w_of_type_Int;
  private int A;
  public boolean A;
  private int jdField_B_of_type_Int;
  boolean jdField_B_of_type_Boolean = true;
  private int C;
  public boolean C;
  private int D;
  public boolean D;
  private int E;
  public boolean E;
  private int F;
  public boolean F;
  private int jdField_G_of_type_Int = 1;
  boolean jdField_G_of_type_Boolean = false;
  private int H;
  public boolean H;
  private int jdField_I_of_type_Int = 25;
  boolean jdField_I_of_type_Boolean = false;
  private int jdField_J_of_type_Int = 2;
  private boolean jdField_J_of_type_Boolean;
  private int jdField_K_of_type_Int = 2;
  private boolean jdField_K_of_type_Boolean;
  private int jdField_L_of_type_Int;
  private boolean jdField_L_of_type_Boolean;
  private int jdField_M_of_type_Int;
  private boolean jdField_M_of_type_Boolean;
  private int jdField_N_of_type_Int = -999;
  private boolean jdField_N_of_type_Boolean;
  private int jdField_O_of_type_Int = 1;
  private boolean jdField_O_of_type_Boolean = true;
  private int jdField_P_of_type_Int = 1;
  private boolean jdField_P_of_type_Boolean;
  private int jdField_Q_of_type_Int;
  private boolean jdField_Q_of_type_Boolean;
  private int R;
  private int S = 0;
  private int T = 1;
  private int U;
  private int V;
  private int jdField_W_of_type_Int = -1;
  private boolean jdField_W_of_type_Boolean;
  private boolean X;
  private boolean Y;
  private boolean Z;
  public double a;
  public float a;
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new xqj(this);
  private Intent jdField_a_of_type_AndroidContentIntent;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public Drawable a;
  private Camera.FaceDetectionListener jdField_a_of_type_AndroidHardwareCamera$FaceDetectionListener = new xpq(this);
  public Handler a;
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener;
  public VelocityTracker a;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new xra(this);
  public View a;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  Button jdField_a_of_type_AndroidWidgetButton;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  public ImageView a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public SeekBar.OnSeekBarChangeListener a;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public QQStoryTakeVideoHelper a;
  private CameraFocusView jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView;
  private final NewStoryCameraZoom jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryCameraZoom = new NewStoryCameraZoom();
  private TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  public QWalletCameraInterface a;
  private FlowComponentInterface jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface;
  private NewFlowCameraActivity.VideoProcessListener jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$VideoProcessListener = new xqd(this);
  private NewFlowCameraOperator jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator = new NewFlowCameraOperator();
  public PtvTemplateAdapter a;
  public VideoFilterViewPager.OnViewPagerItemVisiableChangeListener a;
  private VideoFilterViewPager jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager;
  private RMVideoClipSpec jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
  public RMVideoStateMgr a;
  public CameraCover a;
  public ExtendEditText a;
  public FSurfaceViewLayout a;
  SosoInterface.OnLocationListener jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener;
  private FramePerformanceMonitor jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor;
  private SVHwAutoSegmentMgr jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwAutoSegmentMgr = new SVHwAutoSegmentMgr();
  private volatile SVHwEncoder jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder;
  CameraExceptionHandler.Callback jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler$Callback = new xro(this);
  public CameraProxy a;
  private ImageViewVideoPlayer jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer;
  RedDotImageView jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView;
  public QQCustomDialog a;
  public CircleProgress a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public MqqWeakReferenceHandler a;
  public ActionSheet a;
  public HorizontalListView a;
  Runnable jdField_a_of_type_JavaLangRunnable = new xrd(this);
  public String a;
  public ArrayList a;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List jdField_a_of_type_JavaUtilList;
  public AtomicBoolean a;
  private boolean aA;
  private boolean aB = true;
  private boolean aC;
  private boolean aE;
  private boolean aG;
  private boolean aH = true;
  private boolean aI = true;
  private boolean aJ = true;
  private boolean aK;
  private boolean aL;
  private boolean aM;
  private boolean aN;
  private boolean aO;
  private boolean aP;
  private volatile boolean aQ;
  private boolean aS;
  private boolean aa;
  private boolean ab;
  private boolean ac = true;
  private boolean ad;
  private boolean ae;
  private boolean af;
  private boolean ag;
  private boolean ah;
  private boolean ai;
  private boolean aj;
  private boolean ak;
  private boolean al;
  private boolean am;
  private boolean an = true;
  private boolean ao;
  private boolean ap;
  private boolean aq;
  private boolean ar;
  private boolean as;
  private boolean at = true;
  private boolean au;
  private boolean av;
  private boolean aw;
  private boolean ax;
  private boolean ay = true;
  private boolean az;
  public double b;
  long jdField_b_of_type_Long;
  ProgressDialog jdField_b_of_type_AndroidAppProgressDialog;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_b_of_type_AndroidViewView;
  ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  Button jdField_b_of_type_AndroidWidgetButton;
  public ImageView b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public Runnable b;
  public String b;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private double jdField_c_of_type_Double = 0.7D;
  float jdField_c_of_type_Float = 0.0F;
  public int c;
  public View c;
  Button jdField_c_of_type_AndroidWidgetButton;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  public TextView c;
  Runnable jdField_c_of_type_JavaLangRunnable = new xrf(this);
  public String c;
  private AtomicBoolean jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private double jdField_d_of_type_Double = 1.3D;
  float jdField_d_of_type_Float = 0.0F;
  public int d;
  private long jdField_d_of_type_Long;
  public View d;
  Button jdField_d_of_type_AndroidWidgetButton;
  public ImageView d;
  public TextView d;
  private Runnable jdField_d_of_type_JavaLangRunnable = new xrp(this);
  public String d;
  float jdField_e_of_type_Float = 0.0F;
  int jdField_e_of_type_Int = 0;
  private long jdField_e_of_type_Long;
  View jdField_e_of_type_AndroidViewView;
  Button jdField_e_of_type_AndroidWidgetButton;
  public ImageView e;
  public TextView e;
  public String e;
  public boolean e;
  private float jdField_f_of_type_Float;
  public int f;
  private long jdField_f_of_type_Long;
  public View f;
  Button jdField_f_of_type_AndroidWidgetButton;
  ImageView jdField_f_of_type_AndroidWidgetImageView;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  public String f;
  public boolean f;
  int jdField_g_of_type_Int;
  private long jdField_g_of_type_Long;
  protected View g;
  Button jdField_g_of_type_AndroidWidgetButton;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  TextView jdField_g_of_type_AndroidWidgetTextView;
  private String jdField_g_of_type_JavaLangString;
  public boolean g;
  int jdField_h_of_type_Int = -1;
  private long jdField_h_of_type_Long;
  private View jdField_h_of_type_AndroidViewView;
  private Button jdField_h_of_type_AndroidWidgetButton;
  private ImageView jdField_h_of_type_AndroidWidgetImageView;
  TextView jdField_h_of_type_AndroidWidgetTextView;
  private String jdField_h_of_type_JavaLangString;
  boolean jdField_h_of_type_Boolean = true;
  int jdField_i_of_type_Int = -1;
  private View jdField_i_of_type_AndroidViewView;
  private Button jdField_i_of_type_AndroidWidgetButton;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private String jdField_i_of_type_JavaLangString;
  public boolean i;
  int jdField_j_of_type_Int = 0;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  private String jdField_j_of_type_JavaLangString;
  public boolean j;
  int jdField_k_of_type_Int = 0;
  private String jdField_k_of_type_JavaLangString;
  public boolean k;
  int jdField_l_of_type_Int = 0;
  private String jdField_l_of_type_JavaLangString = a(1);
  public boolean l;
  int jdField_m_of_type_Int = 0;
  private String jdField_m_of_type_JavaLangString = "";
  boolean jdField_m_of_type_Boolean = false;
  int jdField_n_of_type_Int = 0;
  public boolean n;
  public int o;
  public boolean o;
  public int p;
  public boolean p;
  public int q;
  boolean q;
  public int r;
  private String jdField_r_of_type_JavaLangString;
  boolean jdField_r_of_type_Boolean = false;
  int jdField_s_of_type_Int = 0;
  private String jdField_s_of_type_JavaLangString;
  public boolean s;
  int jdField_t_of_type_Int;
  private String jdField_t_of_type_JavaLangString = "";
  boolean jdField_t_of_type_Boolean;
  int jdField_u_of_type_Int;
  private String jdField_u_of_type_JavaLangString = "";
  public boolean u;
  private String v;
  public boolean v;
  private String jdField_w_of_type_JavaLangString;
  boolean jdField_w_of_type_Boolean = false;
  private int jdField_x_of_type_Int;
  private String jdField_x_of_type_JavaLangString;
  public boolean x;
  private int jdField_y_of_type_Int = -1;
  private String jdField_y_of_type_JavaLangString;
  boolean jdField_y_of_type_Boolean = false;
  private int jdField_z_of_type_Int = -1;
  private String jdField_z_of_type_JavaLangString;
  boolean jdField_z_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_w_of_type_Int = 7;
    jdField_b_of_type_Float = 0.6F;
    jdField_a_of_type_Long = 1500L;
    jdField_n_of_type_JavaLangString = Environment.getExternalStorageDirectory().toString() + File.separator + "tencent" + File.separator + "video_edit_music" + File.separator;
    jdField_o_of_type_JavaLangString = jdField_n_of_type_JavaLangString + "temp.af";
    jdField_p_of_type_JavaLangString = "";
    if (Build.VERSION.SDK_INT >= 10) {}
    for (boolean bool = true;; bool = false)
    {
      aD = bool;
      aF = true;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "LoadExtractedShortVideoSo :soLoadStatus=" + VideoEnvironment.a());
        }
        int i1 = VideoEnvironment.a("AVCodec", null, true);
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "LoadExtractedShortVideoSo :code=" + i1);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
        }
      }
      aR = true;
      return;
    }
  }
  
  public NewFlowCameraActivity()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_A_of_type_Int = -1;
    this.jdField_d_of_type_Int = 1;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_A_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr = RMVideoStateMgr.a();
    this.jdField_o_of_type_Int = 90;
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_b_of_type_Double = 0.0D;
    this.jdField_D_of_type_Int = 1;
    this.jdField_D_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_H_of_type_Int = 11;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new xpx(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletCameraInterface = new xqn(this);
    this.jdField_b_of_type_JavaLangRunnable = new xqo(this);
    this.jdField_E_of_type_Boolean = false;
    this.jdField_F_of_type_Boolean = false;
    this.jdField_H_of_type_Boolean = false;
  }
  
  private void U()
  {
    this.jdField_p_of_type_Boolean = true;
    File localFile = new File(this.jdField_e_of_type_JavaLangString);
    this.jdField_q_of_type_Int = 1;
    CameraCover localCameraCover = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover;
    xrz localxrz = new xrz(this);
    NewFlowCameraOperator localNewFlowCameraOperator = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator;
    int i1 = NewFlowCameraOperator.jdField_a_of_type_Int;
    localNewFlowCameraOperator = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator;
    localCameraCover.a(localFile, localxrz, i1, NewFlowCameraOperator.jdField_a_of_type_Boolean, 1, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_d_of_type_Int);
    FlowCameraMqqAction.a("", "0X80075BE", "", "", "", "");
  }
  
  private void V()
  {
    runOnUiThread(new xpr(this));
  }
  
  private void W()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    Object localObject = VideoEnvironment.a.b;
    int[] arrayOfInt = VideoEnvironment.a.a;
    if (localObject.length != arrayOfInt.length)
    {
      QLog.e("DynamicAdjustment", 2, "config data : heights length not match the widths length");
      return;
    }
    int i1 = 0;
    while (i1 < arrayOfInt.length)
    {
      this.jdField_a_of_type_JavaUtilList.add(new Size(arrayOfInt[i1], localObject[i1]));
      i1 += 1;
    }
    Collections.sort(this.jdField_a_of_type_JavaUtilList, new xqa(this));
    this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor = new FramePerformanceMonitor();
    this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor.a(500);
    localObject = BaseApplicationImpl.getApplication().getSharedPreferences("DynamicAdjustment", 4);
    this.jdField_J_of_type_Int = ((SharedPreferences)localObject).getInt("SVDNAdjustment_max_downmark", 2);
    this.jdField_K_of_type_Int = ((SharedPreferences)localObject).getInt("SVDNAdjustment_max_upmark", 2);
    this.jdField_H_of_type_Int = ((SharedPreferences)localObject).getInt("SVDNAdjustment_up_threshold_base", 11);
    this.jdField_I_of_type_Int = ((SharedPreferences)localObject).getInt("SVDNAdjustment_down_threshold_base", 25);
    this.jdField_c_of_type_Double = ((SharedPreferences)localObject).getFloat("SVDNAdjustment_up_threshold_coefficient", 0.7F);
    this.jdField_d_of_type_Double = ((SharedPreferences)localObject).getFloat("SVDNAdjustment_down_threshold_coefficient", 1.3F);
    this.jdField_L_of_type_Int = ((SharedPreferences)localObject).getInt("SVDNAdjustment_quality_up_threshold", this.jdField_H_of_type_Int);
    this.jdField_M_of_type_Int = ((SharedPreferences)localObject).getInt("SVDNAdjustment_quality_down_threshold", this.jdField_I_of_type_Int);
    this.jdField_f_of_type_Float = ((SharedPreferences)localObject).getFloat("SVDNAdjustment_data_type", 0.5F);
    if ((this.jdField_f_of_type_Float < 0.0F) || (this.jdField_f_of_type_Float >= 1.0F)) {
      this.jdField_f_of_type_Float = 0.5F;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DynamicAdjustment", 2, "Init dynamic adjustment params. maxDownMark : " + this.jdField_J_of_type_Int + "  maxUpMark : " + this.jdField_K_of_type_Int + "  upThresholdBase : " + this.jdField_H_of_type_Int + "  downThresholdBase : " + this.jdField_I_of_type_Int + "  upThresholdcoefficient : " + this.jdField_c_of_type_Double + "  downThresholdcoefficient : " + this.jdField_d_of_type_Double + "  upThreshold : " + this.jdField_L_of_type_Int + "  downThreshold : " + this.jdField_M_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor.a(new xqb(this, (SharedPreferences)localObject));
    this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor.a();
  }
  
  private void X()
  {
    int i3 = 0;
    if (!CameraAbility.c()) {
      FlowCameraConstant.jdField_a_of_type_Int = 2;
    }
    int i2;
    do
    {
      return;
      if ((this.jdField_N_of_type_Boolean) || ((this.jdField_r_of_type_Int == 10007) && (this.jdField_O_of_type_Int == 1))) {}
      for (int i1 = 1;; i1 = 0)
      {
        i2 = i3;
        if (this.jdField_r_of_type_Int == 10007)
        {
          i2 = i3;
          if (this.jdField_O_of_type_Int == 2) {
            i2 = 1;
          }
        }
        if (i1 == 0) {
          break;
        }
        FlowCameraConstant.jdField_a_of_type_Int = 1;
        return;
      }
    } while (i2 == 0);
    FlowCameraConstant.jdField_a_of_type_Int = 2;
  }
  
  private void Y()
  {
    if ((FlowCameraConstant.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter == null) && (this.au) && (!this.aG)) {
      B();
    }
    if (this.jdField_r_of_type_Int == 10011) {
      B();
    }
    if (this.jdField_r_of_type_Int == 10003) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "bless unfold and choose the first template" + this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
      }
      B();
      if (PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).c().size() > 0)
      {
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setRestoreX(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.c());
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a((PtvTemplateManager.PtvTemplateInfo)PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).c().get(0));
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        QLog.d("PtvTemplateManager", 2, "bless unfold PtvTemplate error!", localException1);
      }
    }
    if (this.aG) {}
    try
    {
      if ((this.aK) && (this.aJ))
      {
        B();
        if (this.aL)
        {
          ArrayList localArrayList = PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(true, false, 2);
          if ((localArrayList != null) && (localArrayList.size() > 0))
          {
            this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setRestoreX(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.c());
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a((PtvTemplateManager.PtvTemplateInfo)localArrayList.get(0));
          }
        }
      }
      this.aM = true;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PTV.NewFlowCameraActivity", 2, "shareToWeb template exception:", localException2);
        }
      }
    }
    if (this.jdField_N_of_type_Boolean)
    {
      B();
      BaseApplicationImpl.getApplication().getSharedPreferences(ShortVideoGuideUtil.jdField_a_of_type_JavaLangString, 4).edit().putBoolean("is_showed_ptv_guide", true).commit();
    }
  }
  
  private void Z()
  {
    SharedPreferences localSharedPreferences;
    if (this.ak)
    {
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("flow_filter_reddot_sp", 4);
      if (!localSharedPreferences.getBoolean("flow_filter_reddot_key", false)) {
        localSharedPreferences.edit().putBoolean("flow_filter_reddot_key", true).commit();
      }
    }
    if (this.al)
    {
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("flow_filter_reddot_pkg_sp" + ((AppInterface)getAppRuntime()).getCurrentAccountUin(), 4);
      if (!localSharedPreferences.getBoolean("flow_filter_reddot_key", false)) {
        localSharedPreferences.edit().putBoolean("flow_filter_reddot_key", true).commit();
      }
    }
  }
  
  @NonNull
  private Bitmap a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.jdField_h_of_type_Int / 8, this.jdField_i_of_type_Int / 8, this.jdField_B_of_type_Boolean, false, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec);
  }
  
  /* Error */
  private static Bitmap a(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: ifnonnull +9 -> 15
    //   9: aconst_null
    //   10: astore 4
    //   12: aload 4
    //   14: areturn
    //   15: aload_0
    //   16: invokevirtual 840	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: astore 5
    //   21: aload 5
    //   23: getstatic 846	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: aconst_null
    //   30: invokevirtual 852	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore_0
    //   34: aload_0
    //   35: ifnull +216 -> 251
    //   38: aload_0
    //   39: invokeinterface 857 1 0
    //   44: istore_2
    //   45: iload_2
    //   46: ifeq +205 -> 251
    //   49: aload_0
    //   50: aload_0
    //   51: ldc_w 859
    //   54: invokeinterface 863 2 0
    //   59: invokeinterface 866 2 0
    //   64: istore_1
    //   65: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +30 -> 98
    //   71: ldc_w 266
    //   74: iconst_2
    //   75: new 212	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   82: ldc_w 868
    //   85: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: iload_1
    //   89: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 279	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aload 5
    //   100: iload_1
    //   101: i2l
    //   102: iconst_3
    //   103: aconst_null
    //   104: invokestatic 874	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   107: astore_3
    //   108: aload_3
    //   109: ifnull +15 -> 124
    //   112: aload_0
    //   113: ifnull +9 -> 122
    //   116: aload_0
    //   117: invokeinterface 877 1 0
    //   122: aload_3
    //   123: areturn
    //   124: aload_0
    //   125: invokeinterface 880 1 0
    //   130: istore_2
    //   131: iload_2
    //   132: ifne +113 -> 245
    //   135: aload_3
    //   136: astore 4
    //   138: aload_0
    //   139: ifnull -127 -> 12
    //   142: aload_0
    //   143: invokeinterface 877 1 0
    //   148: aload_3
    //   149: areturn
    //   150: astore 4
    //   152: aconst_null
    //   153: astore_0
    //   154: aload 4
    //   156: invokevirtual 881	java/lang/Exception:printStackTrace	()V
    //   159: aload_0
    //   160: astore 4
    //   162: aload_3
    //   163: ifnull -151 -> 12
    //   166: aload_3
    //   167: invokeinterface 877 1 0
    //   172: aload_0
    //   173: areturn
    //   174: astore_3
    //   175: aconst_null
    //   176: astore_0
    //   177: aload_0
    //   178: ifnull +9 -> 187
    //   181: aload_0
    //   182: invokeinterface 877 1 0
    //   187: aload_3
    //   188: athrow
    //   189: astore_3
    //   190: goto -13 -> 177
    //   193: astore 4
    //   195: aload_3
    //   196: astore_0
    //   197: aload 4
    //   199: astore_3
    //   200: goto -23 -> 177
    //   203: astore 4
    //   205: aconst_null
    //   206: astore 5
    //   208: aload_0
    //   209: astore_3
    //   210: aload 5
    //   212: astore_0
    //   213: goto -59 -> 154
    //   216: astore 4
    //   218: aload_0
    //   219: astore 5
    //   221: aload_3
    //   222: astore_0
    //   223: aload 5
    //   225: astore_3
    //   226: goto -72 -> 154
    //   229: astore_3
    //   230: aload_0
    //   231: astore 5
    //   233: aload 4
    //   235: astore_0
    //   236: aload_3
    //   237: astore 4
    //   239: aload 5
    //   241: astore_3
    //   242: goto -88 -> 154
    //   245: aload_3
    //   246: astore 4
    //   248: goto -199 -> 49
    //   251: aconst_null
    //   252: astore_3
    //   253: goto -118 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	paramContext	Context
    //   64	37	1	i1	int
    //   44	88	2	bool	boolean
    //   1	166	3	localBitmap1	Bitmap
    //   174	14	3	localObject1	Object
    //   189	7	3	localObject2	Object
    //   199	27	3	localObject3	Object
    //   229	8	3	localException1	Exception
    //   241	12	3	localObject4	Object
    //   3	134	4	localBitmap2	Bitmap
    //   150	5	4	localException2	Exception
    //   160	1	4	localContext	Context
    //   193	5	4	localObject5	Object
    //   203	1	4	localException3	Exception
    //   216	18	4	localException4	Exception
    //   237	10	4	localObject6	Object
    //   19	221	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   21	34	150	java/lang/Exception
    //   21	34	174	finally
    //   38	45	189	finally
    //   49	98	189	finally
    //   98	108	189	finally
    //   124	131	189	finally
    //   154	159	193	finally
    //   38	45	203	java/lang/Exception
    //   124	131	216	java/lang/Exception
    //   49	98	229	java/lang/Exception
    //   98	108	229	java/lang/Exception
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "公开";
    case 1: 
      return "公开";
    case 4: 
      return "好友";
    case 16: 
      return "指定人";
    case 64: 
      return "仅自己";
    }
    return "指定人";
  }
  
  private void a(int paramInt1, String paramString1, String paramString2, LocalMediaInfo paramLocalMediaInfo, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.a();
      if ((localObject != null) && (!TextUtils.isEmpty(((FilterDesc)localObject).jdField_e_of_type_JavaLangString))) {
        FlowCameraMqqAction.a("", "0X8007805", "", "", ((FilterDesc)localObject).jdField_e_of_type_JavaLangString, "");
      }
    }
    paramInt2 = 109;
    if ((paramInt1 == 10004) || (paramInt1 == 10010) || (paramInt1 == 10000) || (paramInt1 == 10007)) {
      paramInt2 = 1133;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("enable_hw_encode", true);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null) {
      ((Bundle)localObject).putString("mCurrentTemplatePath", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.jdField_a_of_type_JavaLangString);
    }
    ((Bundle)localObject).putInt("entrance_type", a());
    ((Bundle)localObject).putDouble("extra_bless_latitude", this.jdField_a_of_type_Double);
    ((Bundle)localObject).putDouble("extra_bless_longitude", this.jdField_b_of_type_Double);
    paramInt3 = getIntent().getIntExtra("edit_video_type", 0);
    label198:
    long l1;
    int i1;
    boolean bool1;
    label261:
    boolean bool2;
    label272:
    boolean bool3;
    if (this.aG)
    {
      VideoEditReport.b(3);
      if (paramInt1 != 10003) {
        break label561;
      }
      paramInt3 = 5;
      if (this.aG) {
        paramInt3 = 6;
      }
      paramString1 = new EditTakeVideoSource(paramString1, paramString2, paramLocalMediaInfo);
      l1 = super.getIntent().getLongExtra("troop_uin", 0L);
      i1 = paramInt1;
      if (paramInt1 != 10002) {
        break label750;
      }
      i1 = 10002;
      if (a() != 16) {
        break label567;
      }
      bool1 = true;
      if (a() != 5) {
        break label573;
      }
      bool2 = true;
      bool3 = super.getIntent().getBooleanExtra("ignorePersonalPublish", false);
      SLog.a("PTV.NewFlowCameraActivity", "isHotTopic:%b. isDiscover:%b. ignorePersonalPublish:%b", Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3));
      if ((!bool1) && (!bool2) && (!bool3)) {
        break label977;
      }
    }
    label561:
    label567:
    label573:
    label977:
    for (paramInt1 = 4358509;; paramInt1 = 4374893)
    {
      paramInt2 = paramInt1;
      if (l1 != 0L) {
        paramInt2 = paramInt1 & 0xFFFFBFFF & 0xFFFDFFFF & 0xFFBFFFFF;
      }
      if (this.jdField_k_of_type_Boolean)
      {
        paramInt1 = paramInt2;
        if (paramLocalMediaInfo.mDuration >= 11000L) {}
      }
      else
      {
        paramInt1 = paramInt2 & 0xFFFF7FFF;
      }
      ((Bundle)localObject).putLong("startEditVideoTime", SystemClock.uptimeMillis());
      ((Bundle)localObject).putString("story_default_label", getIntent().getStringExtra("story_default_label"));
      ((Bundle)localObject).putLong("story_topic_id", getIntent().getLongExtra("story_topic_id", 0L));
      ((Bundle)localObject).putBoolean("ignorePersonalPublish", bool3);
      ((Bundle)localObject).putInt("currentCamera", FlowCameraConstant.jdField_a_of_type_Int);
      if (this.jdField_k_of_type_Boolean)
      {
        paramInt2 = (int)Math.ceil((float)paramLocalMediaInfo.mDuration * 1.0F / 10000.0F);
        if (paramInt2 < 1)
        {
          SLog.e("PTV.NewFlowCameraActivity", "intentToEditVideoActivityFromStory error. expectFragmentCount < 1");
          return;
          if (paramInt3 == 10004)
          {
            VideoEditReport.b(2);
            break;
          }
          if (paramInt3 == 10000)
          {
            VideoEditReport.b(1);
            break;
          }
          if (paramInt3 == 10003)
          {
            VideoEditReport.b(4);
            break;
          }
          if (paramInt3 == 10010)
          {
            VideoEditReport.b(8);
            break;
          }
          VideoEditReport.b(0);
          break;
          paramInt3 = 2;
          break label198;
          bool1 = false;
          break label261;
          bool2 = false;
          break label272;
        }
        if (paramInt2 > 1) {
          StoryReportor.a("video_shoot", "series_shoot", 0, 0, new String[0]);
        }
        SLog.b("PTV.NewFlowCameraActivity", "intentToHWEditVideoActivity. expectFragmentCount = %d.", Integer.valueOf(paramInt2));
        ((Bundle)localObject).putInt("expect_fragment_count", paramInt2);
      }
      paramInt2 = paramInt1;
      if (this.jdField_s_of_type_Int == 102)
      {
        paramString2 = super.getIntent();
        paramInt3 = paramString2.getIntExtra("shareGroupType", 0);
        ((Bundle)localObject).putInt("shareGroupType", paramInt3);
        ((Bundle)localObject).putString("shareGroupId", paramString2.getStringExtra("shareGroupId"));
        ((Bundle)localObject).putString("shareGroupName", paramString2.getStringExtra("shareGroupName"));
        ((Bundle)localObject).putLong("groupUin", paramString2.getLongExtra("groupUin", -1L));
        ((Bundle)localObject).putInt("add_video_source", paramString2.getIntExtra("add_video_source", 0));
        paramInt1 |= 0x200000;
        paramInt2 = paramInt1;
        if (paramInt3 == 1) {
          paramInt2 = paramInt1 & 0xFFFDFFFF;
        }
      }
      for (paramInt3 = 1;; paramInt3 = 1)
      {
        label750:
        paramString2 = new EditVideoParams(paramInt3, paramInt2, paramString1, (Bundle)localObject);
        paramString2.a.putBoolean("enable_hw_encode", true);
        if (l1 != 0L) {
          paramString2.a.putLong("troop_uin", l1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "EditVideoParams params:" + paramString2.toString());
        }
        if ((this.aG) && (this.jdField_P_of_type_Int == 0))
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label956;
          }
          paramString1 = new Intent(this, EditWebVideoActivity.class);
          paramString1.putExtra("edit_video_call_back", this.jdField_f_of_type_JavaLangString);
        }
        for (;;)
        {
          paramString1.putExtra(EditVideoParams.class.getName(), paramString2);
          paramString1.putExtra("op_department", "grp_qq");
          paramString1.putExtra("op_type", "video_edit");
          paramString1.putExtra("stop_record_time", System.currentTimeMillis());
          paramString1.putExtra("entrance_type", this.jdField_s_of_type_Int);
          startActivityForResult(paramString1, i1);
          overridePendingTransition(0, 0);
          this.az = true;
          return;
          paramInt1 = 0;
          break;
          paramString1 = new Intent(this, EditVideoActivity.class);
        }
      }
    }
  }
  
  private void a(long paramLong) {}
  
  private void a(Intent paramIntent, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    this.jdField_r_of_type_Int = paramIntent.getIntExtra("edit_video_type", 0);
    this.aG = paramIntent.getBooleanExtra("from_web_to_share", false);
    if (paramBundle != null)
    {
      this.aB = paramBundle.getBoolean("flow_camera_disable_beauty_filter", true);
      this.aC = MediaCodecDPC.b();
      this.aH = paramBundle.getBoolean("support_video_shot", true);
      this.aI = paramBundle.getBoolean("support_photo_shot", true);
      this.jdField_O_of_type_Int = paramBundle.getInt("default_camera_mode", 1);
      this.aK = paramBundle.getBoolean("default_open_template", false);
      this.aL = paramBundle.getBoolean("default_use_first_template", false);
      this.aJ = paramBundle.getBoolean("default_show_template_btn", true);
      this.jdField_P_of_type_Int = paramBundle.getInt("default_deal_type", 1);
      this.jdField_Q_of_type_Int = paramBundle.getInt("support_heart_template", 0);
      this.jdField_x_of_type_JavaLangString = paramBundle.getString("h5_activity_id", "");
      localStringBuilder.append("supportVideo:").append(this.aH);
      localStringBuilder.append(", supportPhoto:").append(this.aI);
      localStringBuilder.append(", cameramode:").append(this.jdField_O_of_type_Int);
      localStringBuilder.append(", beauty:").append(this.aB);
      localStringBuilder.append(", unfoldTemplate:").append(this.aK);
      localStringBuilder.append(", usefirstTemplate:").append(this.aL);
      localStringBuilder.append(", showPtvBtn:").append(this.aJ);
      localStringBuilder.append(", dealType:").append(this.jdField_P_of_type_Int);
      localStringBuilder.append(", supportHeartTemplate:").append(this.jdField_Q_of_type_Int);
    }
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "init data info:" + localStringBuilder.toString());
    }
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBundle == null) {
      return;
    }
    HwEnvData.jdField_b_of_type_Boolean = paramBundle.getBoolean("key_video_presend_enable", false);
    HwEnvData.jdField_a_of_type_Boolean = paramBundle.getBoolean("key_video_hard_encode_enable", false);
    float f1 = paramBundle.getFloat("key_video_presend_slice_duration", 1.5F);
    if (f1 > 0.0F) {
      HwEnvData.jdField_a_of_type_Int = (int)(f1 * 1000.0F);
    }
    if (RMVideoStateMgr.a(paramBoolean))
    {
      this.af = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(16);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(4);
  }
  
  private void a(PublishParam paramPublishParam)
  {
    PtvFilterUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, paramPublishParam.jdField_b_of_type_JavaLangString);
    ai();
    this.jdField_b_of_type_Boolean = false;
    if (paramPublishParam.jdField_e_of_type_Int == 0)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put("result_Event", String.valueOf(0));
      m(true);
    }
    for (;;)
    {
      b(paramPublishParam);
      return;
      this.jdField_a_of_type_JavaUtilHashMap.put("result_Event", String.valueOf(3));
      m(false);
    }
  }
  
  private void a(RMVideoClipSpec paramRMVideoClipSpec)
  {
    boolean bool = true;
    float f1 = this.jdField_h_of_type_Int * 1.0F / this.jdField_i_of_type_Int;
    if (this.jdField_e_of_type_Float >= f1) {
      bool = false;
    }
    int i1;
    if (RMVideoStateMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_d_of_type_Boolean))
    {
      i1 = 16;
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "changeVideoPreviewMapSizeclip_width=" + paramRMVideoClipSpec.jdField_c_of_type_Int + "clip_height=" + paramRMVideoClipSpec.jdField_d_of_type_Int + "m_dst_width=" + paramRMVideoClipSpec.jdField_e_of_type_Int + "dst_width=" + paramRMVideoClipSpec.jdField_f_of_type_Int + "aligned_byte=" + i1 + "constScreenWidth=" + bool);
      }
      if (!bool) {
        break label398;
      }
      i4 = paramRMVideoClipSpec.jdField_c_of_type_Int % i1;
      i5 = paramRMVideoClipSpec.jdField_d_of_type_Int % i1;
      paramRMVideoClipSpec.jdField_c_of_type_Int -= i4;
      paramRMVideoClipSpec.jdField_d_of_type_Int -= i5;
      if (!this.jdField_B_of_type_Boolean) {
        break label382;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(2, paramRMVideoClipSpec, this.jdField_m_of_type_Int);
    }
    int i2;
    int i3;
    for (;;)
    {
      paramRMVideoClipSpec.jdField_e_of_type_Int = paramRMVideoClipSpec.jdField_c_of_type_Int;
      paramRMVideoClipSpec.jdField_f_of_type_Int = paramRMVideoClipSpec.jdField_d_of_type_Int;
      i2 = i5;
      i3 = i4;
      if (CodecParam.jdField_h_of_type_Int > 0)
      {
        i2 = i5;
        i3 = i4;
        if (CodecParam.jdField_h_of_type_Int < CodecParam.jdField_i_of_type_Int)
        {
          f1 = CodecParam.jdField_h_of_type_Int * 1.0F / CodecParam.jdField_i_of_type_Int;
          paramRMVideoClipSpec.jdField_e_of_type_Int = ((int)(paramRMVideoClipSpec.jdField_c_of_type_Int * f1));
          paramRMVideoClipSpec.jdField_f_of_type_Int = ((int)(f1 * paramRMVideoClipSpec.jdField_d_of_type_Int));
          i3 = i4;
          i2 = i5;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "changeVideoPreviewMapSizem_clip_width=" + i3 + "m_clip_height=" + i2 + "aligned_byte=" + i1 + "spec.clip_width=" + paramRMVideoClipSpec.jdField_c_of_type_Int + "spec.clip_height=" + paramRMVideoClipSpec.jdField_d_of_type_Int);
      }
      return;
      i1 = 4;
      break;
      label382:
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(5, paramRMVideoClipSpec, this.jdField_n_of_type_Int);
    }
    label398:
    int i4 = paramRMVideoClipSpec.jdField_c_of_type_Int % i1;
    int i5 = paramRMVideoClipSpec.jdField_d_of_type_Int % i1;
    paramRMVideoClipSpec.jdField_c_of_type_Int -= i4;
    paramRMVideoClipSpec.jdField_d_of_type_Int -= i5;
    if (this.jdField_B_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(2, paramRMVideoClipSpec, this.jdField_m_of_type_Int);
    }
    for (;;)
    {
      paramRMVideoClipSpec.jdField_e_of_type_Int = paramRMVideoClipSpec.jdField_c_of_type_Int;
      paramRMVideoClipSpec.jdField_f_of_type_Int = paramRMVideoClipSpec.jdField_d_of_type_Int;
      i2 = i5;
      i3 = i4;
      if (CodecParam.jdField_h_of_type_Int <= 0) {
        break;
      }
      i2 = i5;
      i3 = i4;
      if (CodecParam.jdField_h_of_type_Int >= CodecParam.jdField_i_of_type_Int) {
        break;
      }
      f1 = CodecParam.jdField_h_of_type_Int * 1.0F / CodecParam.jdField_i_of_type_Int;
      paramRMVideoClipSpec.jdField_e_of_type_Int = ((int)(paramRMVideoClipSpec.jdField_c_of_type_Int * f1));
      paramRMVideoClipSpec.jdField_f_of_type_Int = ((int)(f1 * paramRMVideoClipSpec.jdField_d_of_type_Int));
      i2 = i5;
      i3 = i4;
      break;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(5, paramRMVideoClipSpec, this.jdField_n_of_type_Int);
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      this.jdField_p_of_type_Boolean = false;
    }
    if (this.aq)
    {
      if (FlowCameraConstant.jdField_a_of_type_Int != 1) {
        break label47;
      }
      j(false);
    }
    while (this.jdField_r_of_type_Int == 10002)
    {
      f(paramString);
      return;
      label47:
      if (this.jdField_q_of_type_Int == 0) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.c(false);
      }
    }
    if (paramString == null) {}
    label1054:
    label1060:
    label1082:
    label1095:
    for (int i4 = -3;; i4 = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PTV.NewFlowCameraActivity", 2, "finishShotPhoto " + paramString);
      }
      int i2 = getIntent().getIntExtra("edit_video_type", 0);
      boolean bool1;
      int i1;
      int i3;
      int i7;
      if (i2 != 10002)
      {
        bool1 = true;
        i1 = getIntent().getIntExtra("extra.busi_type", 2);
        i3 = getIntent().getIntExtra("entry_source", 0);
        if ((i1 == 3) && ((i3 == 1) || (i3 == 2)))
        {
          a("612", "5", "0", true);
          if (QLog.isColorLevel()) {
            QLog.i("PTV.NewFlowCameraActivity", 2, "QZone click take photo report");
          }
        }
        if (i2 == 10002) {
          i1 = 1;
        }
        i7 = getIntent().getIntExtra("edit_video_type", 0);
        i2 = 0;
        if (!this.aG) {
          break label969;
        }
        i2 = 3;
        i1 = 6;
      }
      label241:
      boolean bool2;
      Intent localIntent;
      label969:
      label1098:
      label1101:
      for (;;)
      {
        bool2 = getIntent().getBooleanExtra("go_publish_activity", false);
        localIntent = EditPicActivity.a(this, paramString, true, true, true, bool1, true, i1, a(), i2, bool2, null);
        if (this.aG)
        {
          localIntent.putExtra("shareto_web_mode", this.jdField_P_of_type_Int);
          localIntent.putExtra("edit_video_call_back", this.jdField_f_of_type_JavaLangString);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null) {
          localIntent.putExtra("mCurrentTemplatePath", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.jdField_a_of_type_JavaLangString);
        }
        localIntent.putExtra("qcamera_photo_filepath", paramString);
        localIntent.putExtra("qcamera_rotate", this.jdField_o_of_type_Int);
        if (FlowCameraConstant.jdField_a_of_type_Int == 2) {}
        for (int i5 = 0;; i5 = 1)
        {
          localIntent.putExtra("camera_type", 103);
          localIntent.putExtra("camera_front_back", i5);
          localIntent.putExtra("camera_capture_method", this.jdField_q_of_type_Int);
          localIntent.putExtra("babyq_ability", getIntent().getLongExtra("babyq_ability", 0L));
          if (i1 == 3)
          {
            localIntent.putExtra("key_latitude", getIntent().getDoubleExtra("key_latitude", 4.9E-324D));
            localIntent.putExtra("key_longtitude", getIntent().getDoubleExtra("key_longtitude", 4.9E-324D));
          }
          FlowCameraMqqAction.a(getIntent().getIntExtra("edit_video_type", -1), "", "0X8007818", null);
          int i6 = -1;
          bool2 = false;
          bool1 = bool2;
          i2 = i6;
          i3 = i6;
          try
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null)
            {
              i3 = i6;
              paramString = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a();
              bool1 = bool2;
              i2 = i6;
              if (paramString != null)
              {
                i3 = i6;
                i6 = Integer.valueOf(paramString.id).intValue();
                i3 = i6;
                boolean bool3 = paramString.hasGesture();
                bool1 = bool2;
                i2 = i6;
                if (bool3)
                {
                  bool1 = true;
                  i2 = i6;
                }
              }
            }
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              String str;
              bool1 = bool2;
              i2 = i3;
              if (QLog.isColorLevel())
              {
                QLog.i("PTV.NewFlowCameraActivity", 2, "id not integer ");
                bool1 = bool2;
                i2 = i3;
                continue;
                bool1 = false;
                continue;
                if (i2 == 10010)
                {
                  localIntent.putExtra("sub_business_id", 104);
                  continue;
                  localIntent.putExtra("editpic_cameratype", 2);
                  continue;
                }
              }
            }
          }
          localIntent.putExtra("camera_filter_id", i2);
          localIntent.putExtra("camera_has_gesture_filter", bool1);
          if (i4 != -1) {
            break label1054;
          }
          bool1 = true;
          NewFlowCameraReporter.a(bool1, i5, i2, this.jdField_q_of_type_Int);
          paramString = (SessionInfo)localIntent.getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
          if (paramString == null) {
            break label1098;
          }
          localIntent.putExtra("uin", paramString.jdField_a_of_type_JavaLangString);
          localIntent.putExtra("uintype", paramString.jdField_a_of_type_Int);
          localIntent.putExtra("troop_uin", paramString.jdField_b_of_type_JavaLangString);
          localIntent.putExtra("uinname", paramString.jdField_d_of_type_JavaLangString);
          localIntent = AIOUtils.a(localIntent, null);
          i2 = getIntent().getIntExtra("edit_video_type", 0);
          if (i2 != 10004) {
            break label1060;
          }
          localIntent.putExtra("sub_business_id", 101);
          paramString = SplashActivity.class.getName();
          str = getIntent().getStringExtra("f_a_a_n");
          if ((str == null) || (!str.equals(ChatActivity.class.getName()))) {
            break label1095;
          }
          paramString = str;
          NewFlowCameraReporter.a("finish");
          NewFlowCameraReporter.a(localIntent);
          str = localIntent.getStringExtra("pic_confirm_text");
          if (str != null) {
            localIntent.putExtra("extra_publish_text", str);
          }
          if (i1 == 7)
          {
            str = getIntent().getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
            paramString = str;
            if (QLog.isColorLevel())
            {
              QLog.i("PTV.NewFlowCameraActivity", 2, String.format(Locale.getDefault(), "finishShotPhoto campus %s", new Object[] { str }));
              paramString = str;
            }
          }
          localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramString);
          localIntent.putExtra("key_activity_code", getIntent().getStringExtra("key_activity_code"));
          if ((i7 == 10000) || (i7 == 10004) || (i7 == 10010))
          {
            if (!paramBoolean) {
              break label1082;
            }
            localIntent.putExtra("editpic_cameratype", 1);
          }
          startActivityForResult(localIntent, 1012);
          FlowCameraMqqAction.a("", "0X80075C1", "", "", "", "");
          return;
          bool1 = false;
          break;
          if (i7 == 10004)
          {
            i2 = 2;
            break label241;
          }
          if (i7 == 10000)
          {
            i2 = 1;
            break label241;
          }
          if (i7 != 10010) {
            break label1101;
          }
          i2 = 10;
          break label241;
        }
      }
    }
  }
  
  private void a(boolean paramBoolean, GapDataCollector.RefreshData paramRefreshData)
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("DynamicAdjustment", 4);
    int i1;
    Size localSize;
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynamicAdjustment", 2, "shift down triggered");
      }
      i1 = ((SharedPreferences)localObject).getInt("SVDNAdjustment_quality_down_mark", 1);
      if (i1 >= this.jdField_J_of_type_Int)
      {
        i1 = 0;
        if (i1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          localSize = (Size)this.jdField_a_of_type_JavaUtilList.get(i1);
          if ((localSize.jdField_b_of_type_Int != GloableValue.jdField_d_of_type_Int) || (localSize.jdField_a_of_type_Int != GloableValue.jdField_c_of_type_Int)) {
            break label426;
          }
          if (i1 != 0) {
            break label147;
          }
          ((SharedPreferences)localObject).edit().putInt("SVDNAdjustment_quality_down_mark", 1).commit();
          if (QLog.isColorLevel()) {
            QLog.d("DynamicAdjustment", 2, "the lowest resolution reached");
          }
        }
      }
    }
    label147:
    label426:
    do
    {
      for (;;)
      {
        return;
        localSize = (Size)this.jdField_a_of_type_JavaUtilList.get(i1 - 1);
        ((SharedPreferences)localObject).edit().putString("SVDNAdjustment_quality_resolution", localSize.jdField_a_of_type_Int + "*" + localSize.jdField_b_of_type_Int).putInt("SVDNAdjustment_quality_down_mark", 1).putInt("SVDNAdjustment_quality_up_mark", 1).putInt("SVDNAdjustment_quality_up_threshold", (int)(this.jdField_L_of_type_Int * this.jdField_c_of_type_Double)).commit();
        if (FlowCameraConstant.jdField_a_of_type_Int == 2) {}
        for (localObject = "back";; localObject = "front")
        {
          NewFlowCameraReporter.a((String)localObject, GloableValue.jdField_c_of_type_Int + "*" + GloableValue.jdField_d_of_type_Int, localSize.jdField_a_of_type_Int + "*" + localSize.jdField_b_of_type_Int, (int)(this.jdField_L_of_type_Int * this.jdField_c_of_type_Double), this.jdField_M_of_type_Int, paramRefreshData);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("DynamicAdjustment", 2, "adjustment finished , resolution down to : " + localSize.jdField_a_of_type_Int + "*" + localSize.jdField_b_of_type_Int + "    threshold down to : " + this.jdField_L_of_type_Int * this.jdField_c_of_type_Double);
          return;
        }
        i1 += 1;
        break;
        ((SharedPreferences)localObject).edit().putInt("SVDNAdjustment_quality_down_mark", i1 + 1).putInt("SVDNAdjustment_quality_up_mark", 1).commit();
        if (QLog.isColorLevel())
        {
          QLog.d("DynamicAdjustment", 2, "mark + 1 = " + (i1 + 1));
          return;
          if (QLog.isColorLevel()) {
            QLog.d("DynamicAdjustment", 2, "shift up triggered");
          }
          i1 = ((SharedPreferences)localObject).getInt("SVDNAdjustment_quality_up_mark", 1);
          if (i1 < this.jdField_K_of_type_Int) {
            break label930;
          }
          i1 = 0;
          for (;;)
          {
            if (i1 >= this.jdField_a_of_type_JavaUtilList.size()) {
              break label928;
            }
            localSize = (Size)this.jdField_a_of_type_JavaUtilList.get(i1);
            if ((localSize.jdField_b_of_type_Int == GloableValue.jdField_d_of_type_Int) && (localSize.jdField_a_of_type_Int == GloableValue.jdField_c_of_type_Int))
            {
              if (i1 == this.jdField_a_of_type_JavaUtilList.size() - 1)
              {
                ((SharedPreferences)localObject).edit().putInt("SVDNAdjustment_quality_up_mark", 1).commit();
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("DynamicAdjustment", 2, "the highest resolution reached");
                return;
              }
              localSize = (Size)this.jdField_a_of_type_JavaUtilList.get(i1 + 1);
              ((SharedPreferences)localObject).edit().putString("SVDNAdjustment_quality_resolution", localSize.jdField_a_of_type_Int + "*" + localSize.jdField_b_of_type_Int).putInt("SVDNAdjustment_quality_up_mark", 1).putInt("SVDNAdjustment_quality_down_mark", 1).putInt("SVDNAdjustment_quality_down_threshold", (int)(this.jdField_M_of_type_Int * this.jdField_d_of_type_Double)).commit();
              if (FlowCameraConstant.jdField_a_of_type_Int == 2) {}
              for (localObject = "back";; localObject = "front")
              {
                NewFlowCameraReporter.a((String)localObject, GloableValue.jdField_c_of_type_Int + "*" + GloableValue.jdField_d_of_type_Int, localSize.jdField_a_of_type_Int + "*" + localSize.jdField_b_of_type_Int, this.jdField_L_of_type_Int, (int)(this.jdField_M_of_type_Int * this.jdField_d_of_type_Double), paramRefreshData);
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("DynamicAdjustment", 2, "adjustment finished , resolution up to :  " + localSize.jdField_a_of_type_Int + "*" + localSize.jdField_b_of_type_Int + "    threshold up to : " + this.jdField_M_of_type_Int * this.jdField_d_of_type_Double);
                return;
              }
            }
            i1 += 1;
          }
        }
      }
      ((SharedPreferences)localObject).edit().putInt("SVDNAdjustment_quality_up_mark", i1 + 1).putInt("SVDNAdjustment_quality_down_mark", 1).commit();
    } while (!QLog.isColorLevel());
    label928:
    label930:
    QLog.d("DynamicAdjustment", 2, "mark + 1 = " + (i1 + 1));
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 16) || (paramInt == 128);
  }
  
  private boolean a(int paramInt, boolean paramBoolean)
  {
    int i1 = FlowCameraConstant.jdField_a_of_type_Int;
    if (i1 == paramInt) {
      return false;
    }
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.k();
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d())
    {
      if (this.jdField_B_of_type_Boolean) {
        break label507;
      }
      if (aR) {
        break label487;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, this.jdField_B_of_type_Boolean, false, null);
      if (localObject != null)
      {
        this.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else
    {
      a(104);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeViewAt(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d();
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "click front needChangeNewSurfaceView = " + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d());
      }
      if (i1 != 1) {
        break label520;
      }
      FlowCameraConstant.jdField_a_of_type_Int = 2;
      label173:
      i(FlowCameraConstant.jdField_a_of_type_Int);
      this.jdField_y_of_type_Boolean = true;
      if (!paramBoolean) {
        break label527;
      }
      b(true);
      label194:
      VideoFilterTools.a().b();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean) && (!this.jdField_g_of_type_Boolean)) {
        c(0, true);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.jdField_a_of_type_JavaLangString);
      }
      if (((this.jdField_r_of_type_Int == 10002) || (this.jdField_r_of_type_Int == 10012)) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean) && (!this.jdField_g_of_type_Boolean)) {
        VideoAnimation.a(this.jdField_a_of_type_AndroidWidgetButton, -8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      }
      if ((c()) && (this.jdField_f_of_type_AndroidWidgetButton != null))
      {
        localObject = this.jdField_f_of_type_AndroidWidgetButton;
        if (!this.Z) {
          break label552;
        }
        paramInt = 0;
        label338:
        ((Button)localObject).setVisibility(paramInt);
        if (this.Z) {
          VideoAnimation.a(this.jdField_f_of_type_AndroidWidgetButton, -8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
        }
      }
      this.jdField_g_of_type_AndroidWidgetButton.clearAnimation();
      this.jdField_g_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.j();
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator;
      if (FlowCameraConstant.jdField_a_of_type_Int != 1) {
        break label558;
      }
    }
    label520:
    label527:
    label552:
    label558:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((NewFlowCameraOperator)localObject).a(paramBoolean);
      as();
      at();
      this.aA = false;
      this.jdField_e_of_type_Boolean = false;
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.a();
      }
      return true;
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130838680);
      break;
      label487:
      this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(-16777216));
      break;
      label507:
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130838680);
      break;
      FlowCameraConstant.jdField_a_of_type_Int = 1;
      break label173;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean)
      {
        D();
        break label194;
      }
      b(false);
      break label194;
      paramInt = 8;
      break label338;
    }
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_j_of_type_Boolean) {}
    do
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.c();
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4) || (FlowCameraConstant.jdField_a_of_type_Int == 1) || (this.jdField_H_of_type_Boolean));
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView.a(f1, f2);
    paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator.a(f1, f2, (int)this.jdField_c_of_type_Float, (int)this.jdField_d_of_type_Float, 1.0F);
    Rect localRect = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator.a(f1, f2, (int)this.jdField_c_of_type_Float, (int)this.jdField_d_of_type_Float, 1.5F);
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "[handleMessage] touch focus:" + f1 + " " + f2 + " " + paramMotionEvent + " " + localRect);
    }
    NewFlowCameraReporter.b();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(paramMotionEvent, localRect, new xrb(this));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.d();
    SLog.e("PTV.NewFlowCameraActivity", "cameraFocusView consume the touch event");
    FlowCameraMqqAction.a("", "0X80075BD", "", "", "", "");
    return true;
  }
  
  private boolean a(String paramString)
  {
    try
    {
      long l1 = Long.valueOf(paramString).longValue();
      a(l1);
      paramString = FontInterface.a(l1);
      if (paramString == null) {
        return false;
      }
      this.jdField_y_of_type_Int = paramString.jdField_a_of_type_Int;
      this.jdField_z_of_type_Int = paramString.jdField_b_of_type_Int;
      this.jdField_j_of_type_JavaLangString = paramString.jdField_a_of_type_JavaLangString;
      int i1 = this.jdField_y_of_type_Int;
      if (i1 > 0) {
        return true;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("loadDefaultFontData", 1, "loadDefaultFontData Throwable, errMsg = " + paramString.getMessage());
    }
    return false;
  }
  
  private void aa()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "initVideoFilter");
    }
    ThreadManager.post(new xqf(this), 5, null, true);
  }
  
  private void ab()
  {
    if (this.jdField_U_of_type_Int == 1) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
    localIntentFilter.addAction("tencent.video.q2v.startUploadPTV");
    localIntentFilter.addAction("tencent.video.q2v.nightMode");
    try
    {
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      this.jdField_U_of_type_Int = 1;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void ac()
  {
    ShortVideoCaptureController.a(this);
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_is_cancel_from_music", 4);
    boolean bool = localSharedPreferences.getBoolean("sp_is_cancel_from_music_key", true);
    if ((!this.jdField_x_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1))
    {
      ThreadManager.postImmediately(new xql(this), null, false);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    View localView = a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131362087);
    if (QLog.isColorLevel()) {
      QLog.d("face", 2, "onResume needChangeNewSurfaceView=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean + "mIsNeedSetup=" + this.jdField_A_of_type_Boolean);
    }
    this.jdField_A_of_type_Boolean = true;
    if (this.jdField_A_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean = true;
    }
    int i1;
    if (((localView == null) || (this.jdField_A_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean)) && (!this.aN))
    {
      i1 = 1;
      if (i1 == 0) {
        break label283;
      }
      Looper.myQueue().addIdleHandler(new xqm(this, bool, localSharedPreferences));
    }
    for (;;)
    {
      this.jdField_A_of_type_Boolean = false;
      this.jdField_z_of_type_Boolean = false;
      this.az = false;
      if ((this.ai) && (!this.ag) && (!this.ah))
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        this.ai = false;
      }
      if (this.S == 1) {
        QzoneOnlineTimeCollectRptService.a().b(4);
      }
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      return;
      i1 = 0;
      break;
      label283:
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.c();
      localSharedPreferences.edit().putBoolean("sp_is_cancel_from_music_key", true).commit();
    }
  }
  
  private void ad()
  {
    float f1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null)
    {
      RMVideoClipSpec localRMVideoClipSpec = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(this.jdField_a_of_type_Double, this.jdField_b_of_type_Double, f1, localRMVideoClipSpec.jdField_e_of_type_Int);
    }
  }
  
  private void ae()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter(null);
    CompoundProcessor localCompoundProcessor = RichmediaClient.a().a().a(this.jdField_d_of_type_JavaLangString);
    if (localCompoundProcessor != null) {
      localCompoundProcessor.a(103);
    }
    for (;;)
    {
      ShortVideoMtaReport.a("shortvideo_close", null);
      return;
      j();
    }
  }
  
  private void af()
  {
    CompoundProcessor localCompoundProcessor = RichmediaClient.a().a().a(this.jdField_d_of_type_JavaLangString);
    if (localCompoundProcessor != null) {
      localCompoundProcessor.a(103);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.f();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)
      {
        int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getSegmentCount();
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(0, i1, true);
      }
      H();
      return;
      j();
    }
  }
  
  private void ag()
  {
    if (this.aq)
    {
      this.jdField_h_of_type_AndroidWidgetButton.setBackgroundResource(2130841517);
      this.jdField_h_of_type_AndroidWidgetButton.setContentDescription("关闭闪光灯");
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.d(true);
      return;
    }
    this.jdField_h_of_type_AndroidWidgetButton.setBackgroundResource(2130841515);
    this.jdField_h_of_type_AndroidWidgetButton.setContentDescription("打开闪光灯");
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.d(false);
  }
  
  private void ah()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "setNightStatus " + this.ar);
    }
    if (this.ar)
    {
      this.jdField_i_of_type_AndroidWidgetButton.setBackgroundResource(2130841521);
      this.jdField_i_of_type_AndroidWidgetButton.setContentDescription("关闭暗光模式");
      return;
    }
    this.jdField_i_of_type_AndroidWidgetButton.setBackgroundResource(2130841519);
    this.jdField_i_of_type_AndroidWidgetButton.setContentDescription("打开暗光模式");
  }
  
  private void ai()
  {
    if ((this.jdField_o_of_type_Int == 90) || (this.jdField_o_of_type_Int == 270)) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (FlowCameraConstant.jdField_a_of_type_Int == 1) {}
      for (int i2 = 1;; i2 = 0)
      {
        a("608", "1", "0", true);
        boolean bool = e();
        Properties localProperties = new Properties();
        localProperties.setProperty("shortvideo_duration", "" + (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
        localProperties.setProperty("shortvideo_rotation", "" + i1);
        localProperties.setProperty("shortvideo_camera", "" + i2);
        Object localObject1;
        label320:
        int i3;
        if (!bool)
        {
          FlowCameraMqqAction.a("", "0X8006A16", String.valueOf((int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double), "" + i1, "" + i2, "");
          ShortVideoMtaReport.a("shortvideo_send_noeffects", localProperties);
          str1 = "";
          Object localObject2 = new HashMap();
          ((HashMap)localObject2).put("param_duration", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double));
          ((HashMap)localObject2).put("param_orientation", String.valueOf(i1));
          if (!TextUtils.isEmpty(str1)) {
            ((HashMap)localObject2).put("param_template", str1);
          }
          if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
          {
            String str2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
            StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplicationImpl.getContext());
            if (bool)
            {
              localObject1 = "actPtvUseTemplate";
              localStatisticCollector.a(str2, (String)localObject1, true, 0L, 0L, (HashMap)localObject2, "");
            }
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null)
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a();
              if (localObject1 != null)
              {
                localObject2 = new Properties();
                ((Properties)localObject2).setProperty("shortvideo_template_id", "" + (String)localObject1);
                ((Properties)localObject2).setProperty("shortvideo_template_name", "" + str1);
                ShortVideoMtaReport.a("shortvideo_send_id1", (Properties)localObject2);
              }
            }
            FlowCameraMqqAction.a("", "0X800795F", String.valueOf((int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double), "" + i1, "" + i2, "");
            ShortVideoMtaReport.a("shortvideo_send", localProperties);
          }
        }
        else
        {
          label516:
          do
          {
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter == null) {
              break;
            }
            str1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a();
            FlowCameraMqqAction.a("", "0X8006A19", String.valueOf((int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double), "" + i1, "" + i2, str1);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null)
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a();
              if ((localObject1 != null) && (((PtvTemplateManager.PtvTemplateInfo)localObject1).hasGesture())) {
                FlowCameraMqqAction.a("", "0X80083B1", String.valueOf((int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double), "" + i1, "" + i2, str1);
              }
            }
            ShortVideoMtaReport.a("shortvideo_send_effects", localProperties);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter == null) {
              break label746;
            }
            i3 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a();
          } while (i3 >= this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.jdField_a_of_type_JavaUtilArrayList.size());
        }
        label746:
        for (String str1 = ((PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.jdField_a_of_type_JavaUtilArrayList.get(i3)).name;; str1 = "")
        {
          LbsFilterStatusManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, str1);
          break;
          str1 = "";
          break label516;
          localObject1 = "actPtvNotUseTemplate";
          break label320;
        }
      }
    }
  }
  
  private void aj()
  {
    jdField_d_of_type_Boolean = false;
    if (e())
    {
      FlowCameraMqqAction.b("", "0X8006A17");
      CompoundProcessor localCompoundProcessor = RichmediaClient.a().a().a(this.jdField_d_of_type_JavaLangString);
      if (localCompoundProcessor == null) {
        break label112;
      }
      localCompoundProcessor.a(103);
    }
    for (;;)
    {
      a(true);
      if (this.jdField_y_of_type_Boolean) {
        this.jdField_z_of_type_Boolean = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("face", 2, "click left hasChangeCamera" + this.jdField_y_of_type_Boolean);
      }
      H();
      return;
      FlowCameraMqqAction.b("", "0X8006A1B");
      break;
      label112:
      j();
    }
  }
  
  private void ak()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "handleQQVideo(): onSendVideoClick mHwEncoder=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
    }
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new xsc(this, this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
  }
  
  private void al()
  {
    this.jdField_E_of_type_Boolean = true;
    this.jdField_F_of_type_Boolean = false;
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      Animation localAnimation = this.jdField_b_of_type_AndroidWidgetImageView.getAnimation();
      if (localAnimation != null)
      {
        localAnimation.cancel();
        localAnimation.setAnimationListener(null);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    if ((this.aG) && (this.aH) && (!this.aI) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_g_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "mCameraCapture clearAnimation!");
      }
    }
  }
  
  private void am()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity.photo", 2, "finishShootShortVideo");
    }
    FlowCameraMqqAction.a(getIntent().getIntExtra("edit_video_type", -1), "", "", this.jdField_a_of_type_JavaUtilHashMap);
    FlowCameraMqqAction.a(getIntent().getIntExtra("edit_video_type", -1), "", "0X8007817", null);
    Object localObject;
    if (this.aq)
    {
      if (FlowCameraConstant.jdField_a_of_type_Int == 1) {
        j(false);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidViewVelocityTracker;
      ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.jdField_u_of_type_Int);
      int i1 = (int)((VelocityTracker)localObject).getXVelocity();
      if ((!this.jdField_r_of_type_Boolean) && (Math.abs(i1) > this.jdField_t_of_type_Int)) {
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.f(-i1);
      }
      aq();
      al();
      if (!this.jdField_r_of_type_Boolean) {
        break label291;
      }
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new xsc(this, this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
    }
    for (;;)
    {
      this.jdField_s_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.e();
        this.jdField_r_of_type_Boolean = false;
      }
      this.jdField_f_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_C_of_type_Int += 1;
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "ACTION_UP isBlueAnimEnd=" + this.jdField_f_of_type_Boolean);
      }
      if (this.jdField_f_of_type_Boolean)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a()) {
          break label400;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "gl_root.isBufferWriteOK()");
        }
        v();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.c(false);
      break;
      label291:
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.a(84.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.a(84.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.a(59.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.a(59.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    label400:
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "gl_root.isBufferWriteOK nop");
    }
    a(this, 2131436145);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.lockFrameSync();
    }
    C();
    v();
  }
  
  private void an()
  {
    VideoAnimation.a(this.jdField_f_of_type_AndroidWidgetImageView, false, 250);
    a(1002, 0, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a().b();
    if (this.jdField_f_of_type_AndroidWidgetButton != null) {
      this.jdField_f_of_type_AndroidWidgetButton.setEnabled(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setEnabled(true);
  }
  
  private void ao()
  {
    int i2 = 1;
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "createHwEncode: Build.MANUFACTURER = " + Build.MANUFACTURER + " Build.MODEL = " + Build.MODEL + " HwEnvData.supportRecordAndEncode() = " + HwEnvData.b());
    }
    Object localObject1 = (SessionInfo)super.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
    Object localObject2;
    int i1;
    if ((localObject1 != null) && (HwEnvData.b()) && (this.af) && (this.S == 0) && (VideoEnvironment.b(2)) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean))
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = new SVHwEncoder();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, ((RMVideoClipSpec)localObject2).jdField_e_of_type_Int, ((RMVideoClipSpec)localObject2).jdField_f_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(-1, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_Int * 1000);
      if (CodecParam.jdField_o_of_type_Int != 16) {
        break label329;
      }
      i1 = 1;
    }
    for (;;)
    {
      if (CodecParam.jdField_p_of_type_Int == 2) {
        i2 = 2;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(CodecParam.jdField_q_of_type_Int, i1, 128000, i2);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setHwEncoder(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.a.getAndSet(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
        }
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwAutoSegmentMgr.a.getAndSet(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
        localObject2 = RichmediaClient.a().a();
        ad();
        localObject1 = ((VideoCompoundController)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder, (SessionInfo)localObject1, 2);
        this.jdField_d_of_type_JavaLangString = ((CompoundProcessor)localObject1).a();
        LogTag.a(this.jdField_d_of_type_JavaLangString, "start", "[peak]");
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a((SVHwOutputNotify)localObject1, null, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_e_of_type_Boolean);
        return;
        label329:
        if (CodecParam.jdField_o_of_type_Int != 12) {
          break label354;
        }
        i1 = 2;
        break;
        if (CodecParam.jdField_p_of_type_Int != 3) {
          i2 = 2;
        }
      }
      label354:
      i1 = 1;
    }
  }
  
  private void ap()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  private void aq()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  private void ar()
  {
    if (this.as) {
      this.jdField_i_of_type_AndroidWidgetButton.setVisibility(0);
    }
  }
  
  private void as()
  {
    if (CameraCompatibleList.d(CameraCompatibleList.F))
    {
      this.jdField_h_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_h_of_type_AndroidWidgetButton.setVisibility(8);
      return;
    }
    this.jdField_h_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_h_of_type_AndroidWidgetButton.setVisibility(0);
  }
  
  private void at()
  {
    if (FlowCameraConstant.jdField_a_of_type_Int == 1) {}
    for (String str = "后";; str = "前")
    {
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription("切换到" + str + "置摄像头");
      return;
    }
  }
  
  private void au()
  {
    Typeface localTypeface = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setTextEffect(this.jdField_k_of_type_JavaLangString);
    String str = FontInterface.a(this.jdField_y_of_type_Int, null, null, null);
    if (TextUtils.isEmpty(str)) {
      this.jdField_y_of_type_Int = -1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setTypeface(localTypeface);
      return;
      localTypeface = Typeface.createFromFile(str);
    }
  }
  
  private void av()
  {
    d("正在合成gif...");
    new NewFlowCameraActivity.EncodeTask(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$VideoProcessListener, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a(), true).execute(new Void[0]);
  }
  
  private void aw()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "intentToEditVideoActivityFromQzone start!");
    }
    for (;;)
    {
      try
      {
        int i4 = this.jdField_f_of_type_Int;
        i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
        int i2 = i1;
        if (i1 <= 0) {
          i2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getRemainedRecordFrames(0);
        }
        if (i2 > 0) {
          this.jdField_V_of_type_Int = i2;
        }
        String str = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString;
        int i5 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_e_of_type_Int;
        int i6 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_f_of_type_Int;
        Object localObject2 = "";
        boolean bool2 = false;
        RMVideoThumbGenMgr.ThumbGenItem localThumbGenItem = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr.a();
        Object localObject1 = localObject2;
        boolean bool1 = bool2;
        if (localThumbGenItem != null)
        {
          localObject1 = localObject2;
          bool1 = bool2;
          if (localThumbGenItem.jdField_c_of_type_JavaLangString != null)
          {
            localObject1 = localObject2;
            bool1 = bool2;
            if (localThumbGenItem.a.get() == 3)
            {
              bool1 = true;
              localObject1 = localThumbGenItem.jdField_c_of_type_JavaLangString;
            }
          }
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!FileUtils.b((String)localObject1)) && (QLog.isColorLevel())) {
          QLog.e("PTV.NewFlowCameraActivity", 2, "intentToEditVideoActivityFromQzone thumb file null!");
        }
        localObject2 = new Bundle();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null) {
          ((Bundle)localObject2).putString("mCurrentTemplatePath", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.jdField_a_of_type_JavaLangString);
        }
        ((Bundle)localObject2).putInt("entrance_type", a());
        ((Bundle)localObject2).putString("extra_publish_text", this.jdField_i_of_type_JavaLangString);
        int i3 = 105;
        int i7 = getIntent().getIntExtra("entry_source", 0);
        i1 = i3;
        if (TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))
        {
          i1 = i3;
          if (!"ref_h5_record_video".equals(this.jdField_r_of_type_JavaLangString))
          {
            i1 = i3;
            if (i7 != 3)
            {
              i1 = i3;
              if (!gifCoderWnsConfig.a()) {
                i1 = 8297;
              }
            }
          }
        }
        if (this.X)
        {
          localObject1 = new EditVideoParams(3, i1, new EditRecordVideoSource(str, i2, i4, FlowCameraConstant.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a(), i5, i6, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(), (String)localObject1, bool1), (Bundle)localObject2);
          a("608", "8", "0", true);
          if (QLog.isColorLevel()) {
            QLog.d("PTV.NewFlowCameraActivity", 2, "intentToEditVideoActivityFromQzone startActivityForResult---> EditVideoParams params:" + ((EditVideoParams)localObject1).toString() + ", RMVideoClipSpec:" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.toString() + " , recordFinish---startEdit");
          }
          localObject2 = new Intent(this, NewFlowEditVideoActivity.class);
          ((Intent)localObject2).putExtra(EditVideoParams.class.getName(), (Parcelable)localObject1);
          ((Intent)localObject2).putExtra("key_font_id", this.jdField_y_of_type_Int);
          ((Intent)localObject2).putExtra("key_super_font_id", this.jdField_A_of_type_Int);
          ((Intent)localObject2).putExtra("key_super_font_info", this.jdField_k_of_type_JavaLangString);
          ((Intent)localObject2).putExtra("op_department", "grp_qzone");
          ((Intent)localObject2).putExtra("op_type", "video_edit");
          ((Intent)localObject2).putExtra("topic_id", this.jdField_h_of_type_JavaLangString);
          ((Intent)localObject2).putExtra("enable_priv_list", this.Y);
          ((Intent)localObject2).putExtra("enable_input_text", this.jdField_P_of_type_Boolean);
          ((Intent)localObject2).putExtra("enable_sync_qzone", this.jdField_Q_of_type_Boolean);
          ((Intent)localObject2).putExtra("stop_record_time", System.currentTimeMillis());
          ((Intent)localObject2).putExtra("lastLoginUin", this.jdField_q_of_type_JavaLangString);
          ((Intent)localObject2).putExtra("mIsQzoneVip", this.ap);
          ((Intent)localObject2).putExtra("UseQQCameraCompression", getIntent().getIntExtra("UseQQCameraCompression", 0));
          ((Intent)localObject2).putExtra("entry_source", getIntent().getIntExtra("entry_source", 0));
          startActivityForResult((Intent)localObject2, 1011);
          overridePendingTransition(0, 0);
          if (QLog.isColorLevel()) {
            QLog.d("PTV.NewFlowCameraActivity", 2, "intentToEditVideoActivityFromQzone ---> finish startActivityForResult");
          }
          this.ax = false;
          this.ay = false;
          return;
        }
      }
      catch (Exception localException)
      {
        int i1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PTV.NewFlowCameraActivity", 2, "intentToEditVideoActivityFromQzone exception:" + localException);
      }
      i1 = 0;
    }
  }
  
  private void ax()
  {
    if (!this.aC) {
      if (QLog.isColorLevel()) {
        QLog.i("PTV.NewFlowCameraActivity", 2, "mbeBeautySurport is false");
      }
    }
    while (!this.aB) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)findViewById(2131370158));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(100);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new xru(this));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getBaseContext().getResources().getDrawable(2130842995);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370159));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = null;
  }
  
  private void ay()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("newflag", true);
    localIntent.putExtra("refer", "schemeActiveFeeds");
    QzonePluginProxyActivity.a(localIntent, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
    localIntent.addFlags(805306368);
    QZoneHelper.b(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), localIntent, -1);
  }
  
  private static Bitmap b(Context paramContext)
  {
    return new GetFirstMediaThumbnailFunction(paramContext).a();
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
    float f1 = ((RMVideoClipSpec)localObject).jdField_f_of_type_Int * 1.0F / ((RMVideoClipSpec)localObject).jdField_e_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "updateVideoDrawablePlayerUI width" + paramInt1 + "heightRatio=" + f1 + "dst_height" + ((RMVideoClipSpec)localObject).jdField_f_of_type_Int + "dst_width=" + ((RMVideoClipSpec)localObject).jdField_e_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(paramInt1, paramInt2, f1, false, ScreenUtil.a(5.0F));
    localObject = this.jdField_f_of_type_AndroidWidgetImageView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = paramInt1;
    ((ViewGroup.LayoutParams)localObject).height = paramInt2;
    this.jdField_f_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    int i2 = 0;
    if ((this.jdField_e_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetSeekBar == null)) {
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setText("美容度" + paramInt + "%");
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams == null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetTextView.getLayoutParams());
    }
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
      i2 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    }
    for (int i1 = ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetSeekBar.getLayoutParams()).leftMargin + i2 / 2;; i1 = 0)
    {
      int i3 = this.jdField_e_of_type_AndroidWidgetTextView.getWidth();
      int i4 = this.jdField_a_of_type_AndroidWidgetSeekBar.getWidth();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin = (i1 - i3 / 2 + (i4 - i2) * paramInt / 100);
      if (paramInt < 50) {}
      for (this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin = ((int)(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin - (50.0F - paramInt) / 50.0F * AIOUtils.a(7.0F, getResources())));; this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin = ((int)(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin + (paramInt - 50.0F) / 50.0F * AIOUtils.a(5.0F, getResources()))))
      {
        this.jdField_e_of_type_AndroidWidgetTextView.requestLayout();
        if ((paramBoolean) || (this.jdField_a_of_type_AndroidWidgetSeekBar.getVisibility() == 0)) {
          break;
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
        return;
      }
    }
  }
  
  private void b(Bundle paramBundle)
  {
    this.aO = paramBundle.getBoolean("enable_local_video", false);
    this.jdField_i_of_type_Boolean = paramBundle.getBoolean("enable_edit_video", false);
    this.ap = paramBundle.getBoolean("is_qzone_vip", false);
    this.jdField_h_of_type_JavaLangString = paramBundle.getString("topic_id");
    if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_M_of_type_Boolean = bool;
      this.jdField_N_of_type_Boolean = paramBundle.getBoolean("enter_ptu", false);
      this.Y = paramBundle.getBoolean("enable_priv_list", true);
      this.jdField_P_of_type_Boolean = paramBundle.getBoolean("enable_input_text", true);
      this.jdField_Q_of_type_Boolean = paramBundle.getBoolean("enable_sync_qzone", false);
      this.jdField_W_of_type_Boolean = paramBundle.getBoolean("enable_origin_video", false);
      this.jdField_W_of_type_Boolean = paramBundle.getBoolean("enable_origin_video", false);
      this.jdField_i_of_type_JavaLangString = paramBundle.getString("confirm_text");
      this.X = paramBundle.getBoolean("enable_edit_button", true);
      this.Z = paramBundle.getBoolean("enable_local_button", true);
      this.aP = paramBundle.getBoolean("enable_front", false);
      this.R = paramBundle.getInt("set_sdcard_min_size", 0);
      this.S = paramBundle.getInt("from_type", 0);
      this.T = paramBundle.getInt("clip_strategy", 1);
      FlowCameraMqqAction.a(this.jdField_r_of_type_Int);
      if ((this.R >= 57671680L) && (this.R <= 314572800L)) {
        StorageManager.jdField_a_of_type_Long = this.R;
      }
      if (this.jdField_k_of_type_Boolean) {
        StorageManager.jdField_a_of_type_Long = StorageManager.jdField_b_of_type_Long;
      }
      this.jdField_r_of_type_JavaLangString = paramBundle.getString("short_video_refer");
      this.jdField_s_of_type_JavaLangString = paramBundle.getString("set_user_callback");
      a(paramBundle, this.jdField_r_of_type_JavaLangString);
      return;
    }
  }
  
  private void b(PublishParam paramPublishParam)
  {
    MediaCodecSendTask.VideoSendPublicParam localVideoSendPublicParam = new MediaCodecSendTask.VideoSendPublicParam();
    localVideoSendPublicParam.jdField_a_of_type_AndroidAppActivity = this;
    localVideoSendPublicParam.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString;
    localVideoSendPublicParam.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface;
    localVideoSendPublicParam.jdField_b_of_type_JavaLangString = paramPublishParam.jdField_k_of_type_JavaLangString;
    int i1;
    boolean bool;
    label177:
    String str;
    if (paramPublishParam.jdField_f_of_type_Int <= 5)
    {
      i1 = paramPublishParam.jdField_f_of_type_Int;
      localVideoSendPublicParam.jdField_a_of_type_Int = i1;
      localVideoSendPublicParam.jdField_c_of_type_JavaLangString = paramPublishParam.jdField_j_of_type_JavaLangString;
      localVideoSendPublicParam.jdField_f_of_type_JavaLangString = paramPublishParam.jdField_c_of_type_JavaLangString;
      localVideoSendPublicParam.jdField_c_of_type_Int = 0;
      localVideoSendPublicParam.jdField_d_of_type_Int = 0;
      localVideoSendPublicParam.jdField_a_of_type_Double = this.jdField_a_of_type_Double;
      localVideoSendPublicParam.jdField_b_of_type_Double = this.jdField_b_of_type_Double;
      localVideoSendPublicParam.jdField_g_of_type_JavaLangString = this.jdField_m_of_type_JavaLangString;
      localVideoSendPublicParam.jdField_e_of_type_Int = this.jdField_d_of_type_Int;
      localVideoSendPublicParam.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      localVideoSendPublicParam.jdField_a_of_type_Boolean = this.jdField_i_of_type_Boolean;
      localVideoSendPublicParam.jdField_j_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
      localVideoSendPublicParam.jdField_b_of_type_Boolean = this.jdField_O_of_type_Boolean;
      if (paramPublishParam.jdField_i_of_type_Int != 1) {
        break label343;
      }
      bool = true;
      localVideoSendPublicParam.jdField_c_of_type_Boolean = bool;
      if (this.jdField_r_of_type_Int == 10007) {
        localVideoSendPublicParam.jdField_d_of_type_Boolean = true;
      }
      localVideoSendPublicParam.jdField_k_of_type_JavaLangString = paramPublishParam.jdField_b_of_type_JavaLangString;
      int i2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
      i1 = i2;
      if (i2 <= 0)
      {
        i1 = i2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
          i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getRemainedRecordFrames(0);
        }
      }
      localVideoSendPublicParam.jdField_i_of_type_Int = i1;
      localVideoSendPublicParam.jdField_j_of_type_Int = ((int)paramPublishParam.jdField_a_of_type_Long);
      str = "";
      paramPublishParam = (SessionInfo)getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      if (paramPublishParam == null) {
        break label349;
      }
      str = paramPublishParam.jdField_a_of_type_JavaLangString;
      i1 = paramPublishParam.jdField_a_of_type_Int;
      paramPublishParam = paramPublishParam.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      localVideoSendPublicParam.jdField_d_of_type_JavaLangString = str;
      localVideoSendPublicParam.jdField_b_of_type_Int = i1;
      localVideoSendPublicParam.jdField_e_of_type_JavaLangString = paramPublishParam;
      new MediaCodecSendTask(localVideoSendPublicParam).execute(new Void[0]);
      return;
      i1 = 0;
      break;
      label343:
      bool = false;
      break label177;
      label349:
      paramPublishParam = "";
      i1 = 0;
    }
  }
  
  private void c(int paramInt, boolean paramBoolean)
  {
    int i1;
    if ((this.aG) && (!this.aJ))
    {
      i1 = 1;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.clearAnimation();
      if (i1 == 0) {
        break label42;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(8);
    }
    label42:
    do
    {
      return;
      i1 = 0;
      break;
      if (paramInt != 0) {
        break label77;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(0);
    } while (!paramBoolean);
    VideoAnimation.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
    return;
    label77:
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(paramInt);
  }
  
  private void e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_g_of_type_JavaLangString = paramString;
      if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null)
      {
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
      }
      String str = NearbyVideoUtils.a(paramString);
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.c(paramString, str, new xqs(this, paramString, str));
    }
  }
  
  private void f(int paramInt)
  {
    int i1 = -1;
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "printFrameNumberLog: totalFilerFrame=" + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getRemainedRecordFrames(0);
      paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "printFrameNumberLog: frameNumOne=" + i1 + "  frameNumTwo=" + paramInt);
      }
      return;
      int i2 = -1;
      paramInt = i1;
      i1 = i2;
    }
  }
  
  private void f(String paramString)
  {
    QLog.w("PTV.NewFlowCameraActivity", 2, "finishShotPhotoFromStory " + paramString);
    Object localObject;
    long l1;
    boolean bool1;
    boolean bool2;
    label158:
    boolean bool3;
    if (paramString != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putLong("startEditVideoTime", SystemClock.uptimeMillis());
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null) {
        ((Bundle)localObject).putString("mCurrentTemplatePath", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.jdField_a_of_type_JavaLangString);
      }
      ((Bundle)localObject).putString("story_default_label", getIntent().getStringExtra("story_default_label"));
      ((Bundle)localObject).putLong("story_topic_id", getIntent().getLongExtra("story_topic_id", 0L));
      ((Bundle)localObject).putInt("entrance_type", a());
      l1 = super.getIntent().getLongExtra("troop_uin", 0L);
      if (a() != 16) {
        break label516;
      }
      bool1 = true;
      if (a() != 5) {
        break label522;
      }
      bool2 = true;
      bool3 = super.getIntent().getBooleanExtra("ignorePersonalPublish", false);
      SLog.a("PTV.NewFlowCameraActivity", "isHotTopic:%b. isDiscover:%b. ignorePersonalPublish:%b", Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3));
      if ((!bool1) && (!bool2) && (!bool3)) {
        break label528;
      }
    }
    label516:
    label522:
    label528:
    for (int i1 = 4358509;; i1 = 4374893)
    {
      int i2 = i1 & 0xFFFF7FFF;
      i1 = i2;
      if (l1 != 0L) {
        i1 = i2 & 0xFFFFBFFF & 0xFFFDFFFF & 0xFFBFFFFF;
      }
      i2 = i1;
      if (this.jdField_s_of_type_Int == 102)
      {
        Intent localIntent = super.getIntent();
        int i3 = localIntent.getIntExtra("shareGroupType", 0);
        ((Bundle)localObject).putInt("shareGroupType", i3);
        ((Bundle)localObject).putString("shareGroupId", localIntent.getStringExtra("shareGroupId"));
        ((Bundle)localObject).putString("shareGroupName", localIntent.getStringExtra("shareGroupName"));
        ((Bundle)localObject).putLong("groupUin", localIntent.getLongExtra("groupUin", -1L));
        ((Bundle)localObject).putInt("add_video_source", localIntent.getIntExtra("add_video_source", 0));
        i1 |= 0x200000;
        i2 = i1;
        if (i3 == 1) {
          i2 = i1 & 0xFFFDFFFF;
        }
      }
      ((Bundle)localObject).putBoolean("ignorePersonalPublish", bool3);
      paramString = new EditVideoParams(1, i2, new EditTakePhotoSource(paramString, 2, 0, 0), (Bundle)localObject);
      if (l1 != 0L) {
        paramString.a.putLong("troop_uin", l1);
      }
      localObject = new Intent(this, EditVideoActivity.class);
      ((Intent)localObject).putExtra(EditVideoParams.class.getName(), paramString);
      ((Intent)localObject).putExtra("op_department", "grp_story");
      ((Intent)localObject).putExtra("op_type", "video_edit");
      i1 = getIntent().getIntExtra("entrance_type", 99);
      if (i1 == 15) {
        ((Intent)localObject).putExtra("entrance_type", i1);
      }
      startActivityForResult((Intent)localObject, 10002);
      overridePendingTransition(0, 0);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label158;
    }
  }
  
  /* Error */
  private void g(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 901	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager	Lcom/tencent/mobileqq/activity/richmedia/VideoFilterViewPager;
    //   4: ifnull +47 -> 51
    //   7: aload_0
    //   8: getfield 901	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager	Lcom/tencent/mobileqq/activity/richmedia/VideoFilterViewPager;
    //   11: invokevirtual 924	com/tencent/mobileqq/activity/richmedia/VideoFilterViewPager:a	()Lcom/tencent/mobileqq/richmedia/capture/data/FilterDesc;
    //   14: astore 15
    //   16: aload 15
    //   18: ifnull +33 -> 51
    //   21: aload 15
    //   23: getfield 927	com/tencent/mobileqq/richmedia/capture/data/FilterDesc:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   26: invokestatic 933	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   29: ifne +22 -> 51
    //   32: ldc 247
    //   34: ldc_w 935
    //   37: ldc 247
    //   39: ldc 247
    //   41: aload 15
    //   43: getfield 927	com/tencent/mobileqq/richmedia/capture/data/FilterDesc:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   46: ldc 247
    //   48: invokestatic 554	com/tencent/mobileqq/activity/richmedia/FlowCameraMqqAction:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   51: aload_0
    //   52: getfield 2277	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_f_of_type_Int	I
    //   55: istore 7
    //   57: aload_0
    //   58: getfield 1295	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout	Lcom/tencent/mobileqq/activity/richmedia/view/FSurfaceViewLayout;
    //   61: invokevirtual 2279	com/tencent/mobileqq/activity/richmedia/view/FSurfaceViewLayout:b	()I
    //   64: istore_2
    //   65: iload_2
    //   66: istore 5
    //   68: iload_2
    //   69: ifgt +29 -> 98
    //   72: iload_2
    //   73: istore 5
    //   75: aload_0
    //   76: getfield 346	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   79: getfield 1870	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext	Lcom/tencent/mobileqq/shortvideo/mediadevice/PreviewContext;
    //   82: ifnull +16 -> 98
    //   85: aload_0
    //   86: getfield 346	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   89: getfield 1870	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext	Lcom/tencent/mobileqq/shortvideo/mediadevice/PreviewContext;
    //   92: iconst_0
    //   93: invokevirtual 2282	com/tencent/mobileqq/shortvideo/mediadevice/PreviewContext:getRemainedRecordFrames	(I)I
    //   96: istore 5
    //   98: iload 5
    //   100: ifle +9 -> 109
    //   103: aload_0
    //   104: iload 5
    //   106: putfield 2284	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_V_of_type_Int	I
    //   109: aconst_null
    //   110: astore 15
    //   112: aload_0
    //   113: getfield 346	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   116: getfield 1246	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   119: astore 20
    //   121: aload 20
    //   123: invokestatic 933	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   126: ifne +14 -> 140
    //   129: new 223	java/io/File
    //   132: dup
    //   133: aload 20
    //   135: invokespecial 525	java/io/File:<init>	(Ljava/lang/String;)V
    //   138: astore 15
    //   140: iload 7
    //   142: ifle +21 -> 163
    //   145: iload 5
    //   147: ifle +16 -> 163
    //   150: aload 15
    //   152: ifnull +11 -> 163
    //   155: aload 15
    //   157: invokevirtual 2676	java/io/File:exists	()Z
    //   160: ifne +16 -> 176
    //   163: aload_0
    //   164: ldc_w 2678
    //   167: iconst_0
    //   168: invokestatic 2683	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   171: invokevirtual 2686	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   174: pop
    //   175: return
    //   176: aload_0
    //   177: getfield 346	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   180: getfield 537	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoClipSpec;
    //   183: getfield 1306	com/tencent/mobileqq/activity/richmedia/state/RMVideoClipSpec:jdField_e_of_type_Int	I
    //   186: istore 8
    //   188: aload_0
    //   189: getfield 346	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   192: getfield 537	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoClipSpec;
    //   195: getfield 1310	com/tencent/mobileqq/activity/richmedia/state/RMVideoClipSpec:jdField_f_of_type_Int	I
    //   198: istore 9
    //   200: ldc 247
    //   202: astore 15
    //   204: iconst_0
    //   205: istore 10
    //   207: aload_0
    //   208: getfield 346	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   211: getfield 2287	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr;
    //   214: invokevirtual 2292	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr:a	()Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem;
    //   217: astore 16
    //   219: aload 15
    //   221: astore 17
    //   223: iload 10
    //   225: istore 13
    //   227: aload 16
    //   229: ifnull +49 -> 278
    //   232: aload 15
    //   234: astore 17
    //   236: iload 10
    //   238: istore 13
    //   240: aload 16
    //   242: getfield 2296	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   245: ifnull +33 -> 278
    //   248: aload 15
    //   250: astore 17
    //   252: iload 10
    //   254: istore 13
    //   256: aload 16
    //   258: getfield 2298	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   261: invokevirtual 1660	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   264: iconst_3
    //   265: if_icmpne +13 -> 278
    //   268: iconst_1
    //   269: istore 13
    //   271: aload 16
    //   273: getfield 2296	com/tencent/mobileqq/activity/richmedia/state/RMVideoThumbGenMgr$ThumbGenItem:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   276: astore 17
    //   278: bipush 109
    //   280: istore_3
    //   281: iload_1
    //   282: sipush 10004
    //   285: if_icmpeq +24 -> 309
    //   288: iload_1
    //   289: sipush 10000
    //   292: if_icmpeq +17 -> 309
    //   295: iload_1
    //   296: sipush 10007
    //   299: if_icmpeq +10 -> 309
    //   302: iload_1
    //   303: sipush 10010
    //   306: if_icmpne +7 -> 313
    //   309: sipush 1133
    //   312: istore_3
    //   313: new 937	android/os/Bundle
    //   316: dup
    //   317: invokespecial 938	android/os/Bundle:<init>	()V
    //   320: astore 18
    //   322: aload_0
    //   323: getfield 701	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter	Lcom/tencent/mobileqq/activity/richmedia/PtvTemplateAdapter;
    //   326: ifnull +18 -> 344
    //   329: aload 18
    //   331: ldc_w 945
    //   334: aload_0
    //   335: getfield 701	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter	Lcom/tencent/mobileqq/activity/richmedia/PtvTemplateAdapter;
    //   338: getfield 946	com/tencent/mobileqq/activity/richmedia/PtvTemplateAdapter:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   341: invokevirtual 950	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: iload_1
    //   345: sipush 10003
    //   348: if_icmpne +818 -> 1166
    //   351: iconst_0
    //   352: istore_2
    //   353: getstatic 2168	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:jdField_o_of_type_Int	I
    //   356: lookupswitch	default:+60->416, 1:+800->1156, 2:+800->1156, 3:+805->1161, 12:+805->1161, 16:+800->1156, 48:+805->1161
    //   417: ldc 19
    //   419: lconst_1
    //   420: ior
    //   421: getstatic 2171	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:jdField_q_of_type_Int	I
    //   424: invokevirtual 957	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   427: aload 18
    //   429: ldc_w 2690
    //   432: iload_2
    //   433: invokevirtual 957	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   436: iload_3
    //   437: sipush 512
    //   440: ior
    //   441: bipush 223
    //   443: iand
    //   444: istore_2
    //   445: aload 18
    //   447: ldc_w 952
    //   450: aload_0
    //   451: invokevirtual 953	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:a	()I
    //   454: invokevirtual 957	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   457: aload 18
    //   459: ldc_w 959
    //   462: aload_0
    //   463: getfield 370	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_a_of_type_Double	D
    //   466: invokevirtual 963	android/os/Bundle:putDouble	(Ljava/lang/String;D)V
    //   469: aload 18
    //   471: ldc_w 965
    //   474: aload_0
    //   475: getfield 372	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_b_of_type_Double	D
    //   478: invokevirtual 963	android/os/Bundle:putDouble	(Ljava/lang/String;D)V
    //   481: iload_1
    //   482: sipush 10003
    //   485: if_icmpne +739 -> 1224
    //   488: iconst_5
    //   489: istore_3
    //   490: aload_0
    //   491: getfield 705	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:aG	Z
    //   494: ifeq +6 -> 500
    //   497: bipush 6
    //   499: istore_3
    //   500: ldc_w 2692
    //   503: astore 15
    //   505: iconst_m1
    //   506: istore 4
    //   508: iload_1
    //   509: sipush 10012
    //   512: if_icmpne +983 -> 1495
    //   515: aload_0
    //   516: invokevirtual 969	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:getIntent	()Landroid/content/Intent;
    //   519: invokevirtual 2696	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   522: astore 16
    //   524: aload 16
    //   526: ifnull +936 -> 1462
    //   529: aload 16
    //   531: ldc_w 2698
    //   534: invokevirtual 2520	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   537: astore 16
    //   539: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   542: ifeq +31 -> 573
    //   545: ldc_w 266
    //   548: iconst_2
    //   549: new 212	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   556: ldc_w 2700
    //   559: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: aload 16
    //   564: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: invokestatic 279	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   573: new 2702	org/json/JSONObject
    //   576: dup
    //   577: aload 16
    //   579: invokespecial 2703	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   582: astore 19
    //   584: aload 19
    //   586: ldc_w 2705
    //   589: iconst_0
    //   590: invokevirtual 2708	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   593: istore 10
    //   595: aload 19
    //   597: ldc_w 2710
    //   600: iconst_0
    //   601: invokevirtual 2708	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   604: istore 11
    //   606: aload 19
    //   608: ldc_w 2712
    //   611: iconst_0
    //   612: invokevirtual 2708	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   615: istore 12
    //   617: iload 4
    //   619: istore_3
    //   620: aload 19
    //   622: ldc_w 2714
    //   625: ldc_w 2692
    //   628: invokevirtual 2717	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   631: astore 16
    //   633: iload 4
    //   635: istore_3
    //   636: aload 16
    //   638: astore 15
    //   640: aload 19
    //   642: ldc_w 2719
    //   645: iconst_m1
    //   646: invokevirtual 2722	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   649: istore 4
    //   651: iload 4
    //   653: istore_3
    //   654: aload 16
    //   656: astore 15
    //   658: aload 19
    //   660: ldc_w 2724
    //   663: ldc 247
    //   665: invokevirtual 2717	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   668: astore 19
    //   670: iload_2
    //   671: istore_3
    //   672: iload 11
    //   674: ifne +8 -> 682
    //   677: iload_2
    //   678: bipush 254
    //   680: iand
    //   681: istore_3
    //   682: iload_3
    //   683: istore_2
    //   684: iload 12
    //   686: ifne +8 -> 694
    //   689: iload_3
    //   690: bipush 251
    //   692: iand
    //   693: istore_2
    //   694: iload 4
    //   696: istore 6
    //   698: iload 12
    //   700: istore 14
    //   702: bipush 10
    //   704: istore_3
    //   705: aload 19
    //   707: astore 15
    //   709: iload_2
    //   710: istore 4
    //   712: iload 10
    //   714: istore 12
    //   716: iload 14
    //   718: istore 10
    //   720: iload 6
    //   722: istore_2
    //   723: new 2319	com/tencent/biz/qqstory/takevideo/EditRecordVideoSource
    //   726: dup
    //   727: aload 20
    //   729: iload 5
    //   731: iload 7
    //   733: i2l
    //   734: getstatic 693	com/tencent/mobileqq/activity/richmedia/FlowCameraConstant:jdField_a_of_type_Int	I
    //   737: aload_0
    //   738: getfield 346	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   741: getfield 537	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoClipSpec;
    //   744: getfield 1306	com/tencent/mobileqq/activity/richmedia/state/RMVideoClipSpec:jdField_e_of_type_Int	I
    //   747: aload_0
    //   748: getfield 346	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   751: getfield 537	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoClipSpec;
    //   754: getfield 1310	com/tencent/mobileqq/activity/richmedia/state/RMVideoClipSpec:jdField_f_of_type_Int	I
    //   757: aload_0
    //   758: getfield 1295	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout	Lcom/tencent/mobileqq/activity/richmedia/view/FSurfaceViewLayout;
    //   761: invokevirtual 2265	com/tencent/mobileqq/activity/richmedia/view/FSurfaceViewLayout:a	()I
    //   764: iload 8
    //   766: iload 9
    //   768: aload_0
    //   769: getfield 346	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   772: invokevirtual 1835	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	()F
    //   775: aload 17
    //   777: iload 13
    //   779: invokespecial 2322	com/tencent/biz/qqstory/takevideo/EditRecordVideoSource:<init>	(Ljava/lang/String;IJIIIIIIFLjava/lang/String;Z)V
    //   782: astore 19
    //   784: aload 18
    //   786: ifnonnull +518 -> 1304
    //   789: iload_1
    //   790: invokestatic 2727	com/tencent/biz/qqstory/takevideo/EditVideoParams:a	(I)Landroid/os/Bundle;
    //   793: astore 17
    //   795: new 1094	com/tencent/biz/qqstory/takevideo/EditVideoParams
    //   798: dup
    //   799: iload_3
    //   800: iload 4
    //   802: aload 19
    //   804: aload 17
    //   806: invokespecial 1097	com/tencent/biz/qqstory/takevideo/EditVideoParams:<init>	(IILcom/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;Landroid/os/Bundle;)V
    //   809: astore 18
    //   811: aload_0
    //   812: invokevirtual 969	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:getIntent	()Landroid/content/Intent;
    //   815: ldc_w 971
    //   818: iconst_0
    //   819: invokevirtual 976	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   822: istore_3
    //   823: aload_0
    //   824: getfield 705	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:aG	Z
    //   827: ifeq +484 -> 1311
    //   830: iconst_3
    //   831: invokestatic 980	com/tencent/biz/qqstory/support/report/VideoEditReport:b	(I)V
    //   834: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   837: ifeq +100 -> 937
    //   840: ldc_w 266
    //   843: iconst_2
    //   844: new 212	java/lang/StringBuilder
    //   847: dup
    //   848: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   851: ldc_w 2729
    //   854: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: iload 7
    //   859: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   862: ldc_w 2731
    //   865: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: iload 5
    //   870: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   873: ldc_w 2733
    //   876: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: aload 20
    //   881: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: ldc_w 2735
    //   887: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: getstatic 693	com/tencent/mobileqq/activity/richmedia/FlowCameraConstant:jdField_a_of_type_Int	I
    //   893: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   896: ldc_w 2737
    //   899: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: aload_0
    //   903: getfield 1295	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout	Lcom/tencent/mobileqq/activity/richmedia/view/FSurfaceViewLayout;
    //   906: invokevirtual 2265	com/tencent/mobileqq/activity/richmedia/view/FSurfaceViewLayout:a	()I
    //   909: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   912: ldc_w 2328
    //   915: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: aload_0
    //   919: getfield 346	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   922: getfield 537	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoClipSpec;
    //   925: invokevirtual 2329	com/tencent/mobileqq/activity/richmedia/state/RMVideoClipSpec:toString	()Ljava/lang/String;
    //   928: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   931: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   934: invokestatic 279	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   937: aload_0
    //   938: getfield 705	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:aG	Z
    //   941: ifeq +434 -> 1375
    //   944: aload_0
    //   945: getfield 442	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_P_of_type_Int	I
    //   948: ifne +427 -> 1375
    //   951: iconst_1
    //   952: istore_3
    //   953: iload_3
    //   954: ifeq +426 -> 1380
    //   957: new 973	android/content/Intent
    //   960: dup
    //   961: aload_0
    //   962: ldc_w 1105
    //   965: invokespecial 1108	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   968: astore 17
    //   970: aload 17
    //   972: ldc_w 1110
    //   975: aload_0
    //   976: getfield 1112	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   979: invokevirtual 1116	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   982: pop
    //   983: aload 17
    //   985: ldc_w 1094
    //   988: invokevirtual 1121	java/lang/Class:getName	()Ljava/lang/String;
    //   991: aload 18
    //   993: invokevirtual 1124	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   996: pop
    //   997: aload 17
    //   999: ldc_w 1126
    //   1002: ldc_w 1128
    //   1005: invokevirtual 1116	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1008: pop
    //   1009: aload 17
    //   1011: ldc_w 1130
    //   1014: ldc_w 1132
    //   1017: invokevirtual 1116	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1020: pop
    //   1021: aload 17
    //   1023: ldc_w 1134
    //   1026: invokestatic 1139	java/lang/System:currentTimeMillis	()J
    //   1029: invokevirtual 1142	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1032: pop
    //   1033: aload 17
    //   1035: ldc_w 2739
    //   1038: iload 5
    //   1040: invokevirtual 1145	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1043: pop
    //   1044: aload 17
    //   1046: ldc_w 2741
    //   1049: iload 7
    //   1051: invokevirtual 1145	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1054: pop
    //   1055: aload 17
    //   1057: ldc_w 2705
    //   1060: iload 12
    //   1062: invokevirtual 1419	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1065: pop
    //   1066: aload 17
    //   1068: ldc_w 2710
    //   1071: iload 11
    //   1073: invokevirtual 1419	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1076: pop
    //   1077: aload 17
    //   1079: ldc_w 2712
    //   1082: iload 10
    //   1084: invokevirtual 1419	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1087: pop
    //   1088: iload_1
    //   1089: sipush 10012
    //   1092: if_icmpne +35 -> 1127
    //   1095: aload 17
    //   1097: ldc_w 2714
    //   1100: aload 16
    //   1102: invokevirtual 1116	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1105: pop
    //   1106: aload 17
    //   1108: ldc_w 2719
    //   1111: iload_2
    //   1112: invokevirtual 1145	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1115: pop
    //   1116: aload 17
    //   1118: ldc_w 2724
    //   1121: aload 15
    //   1123: invokevirtual 1116	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1126: pop
    //   1127: aload_0
    //   1128: aload 17
    //   1130: iload_1
    //   1131: invokevirtual 1149	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:startActivityForResult	(Landroid/content/Intent;I)V
    //   1134: aload_0
    //   1135: iconst_0
    //   1136: iconst_0
    //   1137: invokevirtual 1152	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:overridePendingTransition	(II)V
    //   1140: aload_0
    //   1141: iconst_0
    //   1142: putfield 2369	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:ax	Z
    //   1145: aload_0
    //   1146: iconst_0
    //   1147: putfield 403	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:ay	Z
    //   1150: aload_0
    //   1151: iconst_1
    //   1152: putfield 1154	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:az	Z
    //   1155: return
    //   1156: iconst_1
    //   1157: istore_2
    //   1158: goto -742 -> 416
    //   1161: iconst_2
    //   1162: istore_2
    //   1163: goto -747 -> 416
    //   1166: iload_1
    //   1167: bipush 101
    //   1169: if_icmpeq +10 -> 1179
    //   1172: iload_1
    //   1173: sipush 10004
    //   1176: if_icmpne +18 -> 1194
    //   1179: aload 18
    //   1181: ldc_w 2743
    //   1184: bipush 101
    //   1186: invokevirtual 957	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1189: iload_3
    //   1190: istore_2
    //   1191: goto -746 -> 445
    //   1194: iload_1
    //   1195: bipush 104
    //   1197: if_icmpeq +12 -> 1209
    //   1200: iload_3
    //   1201: istore_2
    //   1202: iload_1
    //   1203: sipush 10010
    //   1206: if_icmpne -761 -> 445
    //   1209: aload 18
    //   1211: ldc_w 2743
    //   1214: bipush 104
    //   1216: invokevirtual 957	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1219: iload_3
    //   1220: istore_2
    //   1221: goto -776 -> 445
    //   1224: iconst_2
    //   1225: istore_3
    //   1226: goto -736 -> 490
    //   1229: astore 16
    //   1231: iconst_m1
    //   1232: istore_3
    //   1233: ldc_w 2692
    //   1236: astore 15
    //   1238: iconst_0
    //   1239: istore 10
    //   1241: iconst_0
    //   1242: istore 11
    //   1244: iconst_0
    //   1245: istore 12
    //   1247: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1250: ifeq +31 -> 1281
    //   1253: ldc_w 266
    //   1256: iconst_2
    //   1257: new 212	java/lang/StringBuilder
    //   1260: dup
    //   1261: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   1264: ldc_w 2745
    //   1267: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: aload 16
    //   1272: invokevirtual 714	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1275: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1278: invokestatic 582	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1281: aload 15
    //   1283: astore 16
    //   1285: bipush 10
    //   1287: istore 6
    //   1289: iload_2
    //   1290: istore 4
    //   1292: ldc 247
    //   1294: astore 15
    //   1296: iload_3
    //   1297: istore_2
    //   1298: iload 6
    //   1300: istore_3
    //   1301: goto -578 -> 723
    //   1304: aload 18
    //   1306: astore 17
    //   1308: goto -513 -> 795
    //   1311: iload_3
    //   1312: sipush 10004
    //   1315: if_icmpne +10 -> 1325
    //   1318: iconst_2
    //   1319: invokestatic 980	com/tencent/biz/qqstory/support/report/VideoEditReport:b	(I)V
    //   1322: goto -488 -> 834
    //   1325: iload_3
    //   1326: sipush 10000
    //   1329: if_icmpne +10 -> 1339
    //   1332: iconst_1
    //   1333: invokestatic 980	com/tencent/biz/qqstory/support/report/VideoEditReport:b	(I)V
    //   1336: goto -502 -> 834
    //   1339: iload_3
    //   1340: sipush 10003
    //   1343: if_icmpne +10 -> 1353
    //   1346: iconst_4
    //   1347: invokestatic 980	com/tencent/biz/qqstory/support/report/VideoEditReport:b	(I)V
    //   1350: goto -516 -> 834
    //   1353: iload_3
    //   1354: sipush 10010
    //   1357: if_icmpne +11 -> 1368
    //   1360: bipush 8
    //   1362: invokestatic 980	com/tencent/biz/qqstory/support/report/VideoEditReport:b	(I)V
    //   1365: goto -531 -> 834
    //   1368: iconst_0
    //   1369: invokestatic 980	com/tencent/biz/qqstory/support/report/VideoEditReport:b	(I)V
    //   1372: goto -538 -> 834
    //   1375: iconst_0
    //   1376: istore_3
    //   1377: goto -424 -> 953
    //   1380: new 973	android/content/Intent
    //   1383: dup
    //   1384: aload_0
    //   1385: ldc_w 1156
    //   1388: invokespecial 1108	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1391: astore 17
    //   1393: goto -410 -> 983
    //   1396: astore 16
    //   1398: iconst_m1
    //   1399: istore_3
    //   1400: ldc_w 2692
    //   1403: astore 15
    //   1405: iconst_0
    //   1406: istore 14
    //   1408: iconst_0
    //   1409: istore 11
    //   1411: iload 10
    //   1413: istore 12
    //   1415: iload 14
    //   1417: istore 10
    //   1419: goto -172 -> 1247
    //   1422: astore 16
    //   1424: iconst_m1
    //   1425: istore_3
    //   1426: ldc_w 2692
    //   1429: astore 15
    //   1431: iconst_0
    //   1432: istore 14
    //   1434: iload 10
    //   1436: istore 12
    //   1438: iload 14
    //   1440: istore 10
    //   1442: goto -195 -> 1247
    //   1445: astore 16
    //   1447: iload 10
    //   1449: istore 14
    //   1451: iload 12
    //   1453: istore 10
    //   1455: iload 14
    //   1457: istore 12
    //   1459: goto -212 -> 1247
    //   1462: iconst_m1
    //   1463: istore 6
    //   1465: ldc_w 2692
    //   1468: astore 16
    //   1470: iconst_0
    //   1471: istore 10
    //   1473: iconst_0
    //   1474: istore 11
    //   1476: iconst_0
    //   1477: istore 12
    //   1479: bipush 10
    //   1481: istore_3
    //   1482: iload_2
    //   1483: istore 4
    //   1485: ldc 247
    //   1487: astore 15
    //   1489: iload 6
    //   1491: istore_2
    //   1492: goto -769 -> 723
    //   1495: iconst_m1
    //   1496: istore 6
    //   1498: ldc_w 2692
    //   1501: astore 16
    //   1503: iconst_0
    //   1504: istore 10
    //   1506: iconst_0
    //   1507: istore 11
    //   1509: iconst_0
    //   1510: istore 12
    //   1512: iload_2
    //   1513: istore 4
    //   1515: ldc 247
    //   1517: astore 15
    //   1519: iload 6
    //   1521: istore_2
    //   1522: goto -799 -> 723
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1525	0	this	NewFlowCameraActivity
    //   0	1525	1	paramInt	int
    //   64	1458	2	i1	int
    //   280	1202	3	i2	int
    //   506	1008	4	i3	int
    //   66	973	5	i4	int
    //   696	824	6	i5	int
    //   55	995	7	i6	int
    //   186	579	8	i7	int
    //   198	569	9	i8	int
    //   205	1300	10	bool1	boolean
    //   604	904	11	bool2	boolean
    //   615	896	12	bool3	boolean
    //   225	553	13	bool4	boolean
    //   700	756	14	bool5	boolean
    //   14	1504	15	localObject1	Object
    //   217	884	16	localObject2	Object
    //   1229	42	16	localException1	Exception
    //   1283	1	16	localObject3	Object
    //   1396	1	16	localException2	Exception
    //   1422	1	16	localException3	Exception
    //   1445	1	16	localException4	Exception
    //   1468	34	16	str1	String
    //   221	1171	17	localObject4	Object
    //   320	985	18	localObject5	Object
    //   582	221	19	localObject6	Object
    //   119	761	20	str2	String
    // Exception table:
    //   from	to	target	type
    //   573	595	1229	java/lang/Exception
    //   595	606	1396	java/lang/Exception
    //   606	617	1422	java/lang/Exception
    //   620	633	1445	java/lang/Exception
    //   640	651	1445	java/lang/Exception
    //   658	670	1445	java/lang/Exception
  }
  
  private void g(String paramString)
  {
    P();
    Intent localIntent = new Intent(this, EditVideoActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("extra_publish_text", "确认");
    paramString = new EditVideoParams(3, 4109, new EditTakeGifSource(paramString, null, null), localBundle);
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", NewFlowCameraActivity.class.getName());
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra(EditVideoParams.class.getName(), paramString);
    localIntent.putExtra("op_type", "gif_edit");
    localIntent.putExtra("op_department", "grp_qzone");
    localIntent.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
    localIntent.putExtra("DirectBackToQzone", true);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodActivity");
    this.ay = false;
    startActivityForResult(localIntent, 1014);
  }
  
  private void h(int paramInt)
  {
    SLog.c("PTV.NewFlowCameraActivity", "start generating manifest file...");
    long l1 = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper.a(new xrs(this, l1, paramInt));
  }
  
  private boolean h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "filter=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean;
  }
  
  private void i(int paramInt)
  {
    SharedPreUtils.a(BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).edit().putInt("camera", paramInt));
  }
  
  private boolean i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a())) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = null;
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder == null) || (this.jdField_b_of_type_AndroidWidgetButton.isEnabled())) {
      return false;
    }
    return true;
  }
  
  private void j(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_i_of_type_AndroidViewView == null) {
        this.jdField_i_of_type_AndroidViewView = new View(this);
      }
      this.jdField_i_of_type_AndroidViewView.setBackgroundColor(-1);
      this.jdField_i_of_type_AndroidViewView.setAlpha(0.7F);
      if (this.jdField_i_of_type_AndroidViewView.getParent() != null) {
        ((ViewGroup)this.jdField_i_of_type_AndroidViewView.getParent()).removeView(this.jdField_i_of_type_AndroidViewView);
      }
      addContentView(this.jdField_i_of_type_AndroidViewView, new ViewGroup.LayoutParams(-1, -1));
    }
    do
    {
      do
      {
        try
        {
          this.jdField_G_of_type_Int = Settings.System.getInt(getContentResolver(), "screen_brightness_mode");
          Settings.System.putInt(getContentResolver(), "screen_brightness_mode", 0);
          this.jdField_F_of_type_Int = Settings.System.getInt(getContentResolver(), "screen_brightness");
          Settings.System.putInt(getContentResolver(), "screen_brightness", 255);
          return;
        }
        catch (Settings.SettingNotFoundException localSettingNotFoundException)
        {
          this.jdField_G_of_type_Int = 1;
          this.jdField_F_of_type_Int = 100;
          QLog.d(".photo", 2, new Object[] { "setting not found ", localSettingNotFoundException.getMessage() });
          return;
        }
        if (FlowCameraConstant.jdField_a_of_type_Int == 2)
        {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.c(false);
          return;
        }
      } while (FlowCameraConstant.jdField_a_of_type_Int != 1);
      Settings.System.putInt(getContentResolver(), "screen_brightness", this.jdField_F_of_type_Int);
      Settings.System.putInt(getContentResolver(), "screen_brightness_mode", this.jdField_G_of_type_Int);
    } while ((this.jdField_i_of_type_AndroidViewView == null) || (this.jdField_i_of_type_AndroidViewView.getParent() == null));
    ((ViewGroup)this.jdField_i_of_type_AndroidViewView.getParent()).removeView(this.jdField_i_of_type_AndroidViewView);
  }
  
  private void k(boolean paramBoolean)
  {
    int i1;
    if (FlowCameraConstant.jdField_a_of_type_Int == 1)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.b() != 1)) {
        break label398;
      }
      i1 = 0;
    }
    for (;;)
    {
      if (!this.aB) {
        i1 = 0;
      }
      if ((this.aC) && (this.jdField_C_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean) && (i1 != 0) && (this.jdField_a_of_type_AndroidWidgetSeekBar != null) && (this.jdField_a_of_type_AndroidWidgetSeekBar.getVisibility() != 0) && (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler != null))
      {
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("beauty_setting", 0);
        String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        i1 = localSharedPreferences.getInt("beauty_level" + str, (int)(jdField_b_of_type_Float * 100.0F));
        if (!paramBoolean) {
          break label384;
        }
        jdField_a_of_type_Long = 3500L;
        this.jdField_l_of_type_Boolean = true;
      }
      for (;;)
      {
        this.jdField_c_of_type_Int = i1;
        this.jdField_a_of_type_Float = (this.jdField_c_of_type_Int / 5 * 0.05F);
        this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i1);
        this.jdField_a_of_type_AndroidWidgetSeekBar.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(true);
        this.jdField_a_of_type_AndroidWidgetSeekBar.setContentDescription("调节美颜效果,当前效果" + i1 + "%");
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1011);
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1011, jdField_a_of_type_Long);
        VideoFilterTools.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.getContext());
        if ((paramBoolean) && (this.jdField_e_of_type_AndroidWidgetTextView != null))
        {
          this.jdField_e_of_type_AndroidWidgetTextView.setText("美容度" + i1 + "%");
          this.jdField_e_of_type_AndroidWidgetTextView.addOnLayoutChangeListener(new xpv(this, i1));
        }
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a()))) {
          break label393;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.b() == 1)
        {
          i1 = 0;
          break;
        }
        i1 = 1;
        break;
        label384:
        jdField_a_of_type_Long = 1500L;
      }
      label393:
      i1 = 0;
      continue;
      label398:
      i1 = 1;
    }
  }
  
  private void l(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getVisibility() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(4);
    }
    this.jdField_f_of_type_AndroidWidgetButton.setBackgroundColor(0);
    int i1 = getIntent().getIntExtra("edit_video_type", 0);
    Object localObject;
    if (this.jdField_i_of_type_Boolean)
    {
      this.jdField_f_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.clearAnimation();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(4);
      if (!this.jdField_i_of_type_Boolean) {
        break label450;
      }
      this.jdField_g_of_type_AndroidWidgetButton.clearAnimation();
      this.jdField_g_of_type_AndroidWidgetButton.setVisibility(8);
      localObject = this.jdField_f_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label436;
      }
      i1 = 0;
      label103:
      ((TextView)localObject).setVisibility(i1);
      if (paramBoolean)
      {
        if (!this.jdField_i_of_type_Boolean) {
          break label442;
        }
        localObject = this.jdField_f_of_type_AndroidWidgetTextView;
        label124:
        VideoAnimation.a((View)localObject, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      }
      label139:
      if ((!this.jdField_i_of_type_Boolean) || (!paramBoolean) || (!this.jdField_P_of_type_Boolean)) {
        break label565;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      VideoAnimation.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      if (!this.Y) {
        this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if (this.jdField_Q_of_type_Boolean)
      {
        this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new xqv(this));
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(4);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_h_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_i_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(4);
      return;
      if ((i1 == 10000) || (i1 == 10003) || (i1 == 10004) || (i1 == 10010) || (i1 == 10002) || (i1 == 10007))
      {
        this.jdField_f_of_type_AndroidWidgetButton.setVisibility(8);
        break;
      }
      this.jdField_f_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetButton.setText("重拍");
      VideoAnimation.a(this.jdField_f_of_type_AndroidWidgetButton, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      break;
      label436:
      i1 = 8;
      break label103;
      label442:
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView;
      break label124;
      label450:
      this.jdField_f_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(4);
      if ((i1 == 10000) || (i1 == 10004) || (i1 == 10010) || (i1 == 10002) || (i1 == 10003) || (i1 == 10007))
      {
        this.jdField_g_of_type_AndroidWidgetButton.setVisibility(8);
        break label139;
      }
      this.jdField_g_of_type_AndroidWidgetButton.setVisibility(0);
      if (this.jdField_i_of_type_Boolean) {}
      for (localObject = this.jdField_f_of_type_AndroidWidgetTextView;; localObject = this.jdField_g_of_type_AndroidWidgetButton)
      {
        VideoAnimation.a((View)localObject, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
        break;
      }
      label565:
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    }
  }
  
  private void m(boolean paramBoolean)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    int i1;
    if (this.aA)
    {
      i1 = 1;
      localHashMap.put("manualFocused", String.valueOf(i1));
      localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.jdField_e_of_type_Boolean) {
        break label194;
      }
      i1 = 1;
      label40:
      localHashMap.put("manualZoom", String.valueOf(i1));
      localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.aq) {
        break label199;
      }
      i1 = 1;
      label66:
      localHashMap.put("flashOn", String.valueOf(i1));
      localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.ar) {
        break label204;
      }
      i1 = 1;
      label92:
      localHashMap.put("nightOn", String.valueOf(i1));
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.a() == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.a().jdField_b_of_type_Int == 0)) {
        break label209;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("useFilter", String.valueOf(1));
      this.jdField_a_of_type_JavaUtilHashMap.put("filterId", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.a().jdField_b_of_type_Int));
    }
    for (;;)
    {
      ThreadManager.post(new xrv(this, paramBoolean), 5, null, true);
      return;
      i1 = 0;
      break;
      label194:
      i1 = 0;
      break label40;
      label199:
      i1 = 0;
      break label66;
      label204:
      i1 = 0;
      break label92;
      label209:
      this.jdField_a_of_type_JavaUtilHashMap.put("useFilter", String.valueOf(0));
    }
  }
  
  public void A()
  {
    super.finish();
  }
  
  public void B()
  {
    if (!this.am) {}
    do
    {
      do
      {
        return;
      } while ((this.aG) && (!this.aJ));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null) {
        break label117;
      }
      new ArrayList();
      if (this.jdField_r_of_type_Int != 10003) {
        break;
      }
      localObject1 = PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).c();
      if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0)) {
        break label117;
      }
    } while (!QLog.isColorLevel());
    QLog.e("PTV.NewFlowCameraActivity", 2, "unfold failed due to no data to show");
    return;
    if (this.aG) {}
    for (int i1 = 2;; i1 = 1)
    {
      localObject1 = PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(true, false, i1);
      break;
    }
    label117:
    if (this.aj)
    {
      Z();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.a(false);
      this.aj = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.clearAnimation();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(4);
    this.jdField_g_of_type_AndroidWidgetButton.clearAnimation();
    this.jdField_g_of_type_AndroidWidgetButton.setVisibility(8);
    if ((this.jdField_r_of_type_Int == 10002) || (this.jdField_r_of_type_Int == 10012)) {
      this.jdField_a_of_type_AndroidWidgetButton.clearAnimation();
    }
    this.jdField_f_of_type_AndroidWidgetTextView.clearAnimation();
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
    Object localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).width = AIOUtils.a(84.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject1).height = AIOUtils.a(84.0F, getResources());
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).width = AIOUtils.a(59.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject1).height = AIOUtils.a(59.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
    this.jdField_g_of_type_Boolean = true;
    as();
    ar();
    if (this.jdField_r_of_type_Int != 10002) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (this.jdField_i_of_type_Boolean) {
      a("612", "4", "0", true);
    }
    Object localObject2;
    label464:
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter == null)
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setStayDisplayOffsetZero(true);
      new ArrayList();
      if (this.jdField_r_of_type_Int == 10003)
      {
        localObject1 = PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).c();
        if ((GestureRecognitionUtils.c()) && (GestureRecognitionUtils.b())) {}
        localObject2 = ((ArrayList)localObject1).iterator();
        i1 = 0;
        if (!((Iterator)localObject2).hasNext()) {
          break label565;
        }
        localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject2).next();
        if ((localPtvTemplateInfo.category != 1) && (localPtvTemplateInfo.category != 2)) {
          break label542;
        }
        ((Iterator)localObject2).remove();
      }
    }
    for (;;)
    {
      break label464;
      if (this.aG) {}
      for (i1 = 2;; i1 = 1)
      {
        localObject1 = PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(true, false, i1);
        break;
      }
      label542:
      if ((localPtvTemplateInfo.category == 1) || (localPtvTemplateInfo.category == 2))
      {
        i1 = 1;
        continue;
        label565:
        if (i1 != 0) {
          FlowCameraMqqAction.a("", "0X8008487", "", "", "", "");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter = new PtvTemplateAdapter(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, (ArrayList)localObject1, jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a(this);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter);
        if ("qzoneOpenDongXiao".equals(this.jdField_f_of_type_JavaLangString))
        {
          i1 = a((ArrayList)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("PtvTemplateManager", 2, "position: " + i1);
          }
          if (i1 != -1) {
            this.jdField_a_of_type_ComTencentWidgetHorizontalListView.post(new xqz(this, i1));
          }
        }
        if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0)) {
          PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(this);
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("setadapter list size: ");
          if (localObject1 == null)
          {
            i1 = 0;
            QLog.d("PtvTemplateManager", 2, i1);
          }
        }
        else
        {
          if ((!this.aG) || (this.aM)) {
            break label836;
          }
        }
        label836:
        for (i1 = 1;; i1 = 0)
        {
          if ((FlowCameraConstant.jdField_a_of_type_Int == 1) || (i1 != 0) || (this.jdField_r_of_type_Int == 10011) || (!CameraAbility.c())) {
            break label839;
          }
          a(-1, false);
          return;
          i1 = ((ArrayList)localObject1).size();
          break;
        }
        label839:
        break;
      }
    }
  }
  
  void C()
  {
    if (QLog.isColorLevel()) {
      QLog.e("PTV.NewFlowCameraActivity", 2, "cancleProgressDailog");
    }
    try
    {
      if (this.jdField_b_of_type_AndroidAppProgressDialog != null) {
        this.jdField_b_of_type_AndroidAppProgressDialog.cancel();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void D()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "setupCameraUI");
    }
    b(false);
  }
  
  void E()
  {
    SLog.c("PTV.NewFlowCameraActivity", "changeCameraDuringRecord");
    if (!this.aE) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.e();
    }
    a(-1, true);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.e();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface.x();
    if ((FlowCameraConstant.jdField_a_of_type_Int == 2) && (this.aq)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.c(true);
    }
    for (;;)
    {
      if (!this.aE) {
        F();
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "start recording start time=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Long);
      }
      this.jdField_s_of_type_Boolean = true;
      this.jdField_f_of_type_AndroidWidgetButton.clearAnimation();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetButton.clearAnimation();
      this.jdField_f_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      return;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.c(false);
    }
  }
  
  public void F()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "enterVideoMode(), mPtvMode = false");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.e();
    this.jdField_r_of_type_Boolean = true;
  }
  
  @TargetApi(11)
  public void G()
  {
    int i1 = AIOUtils.a(59.0F, getResources());
    int i2 = AIOUtils.a(84.0F, getResources());
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 1.1333F });
    localValueAnimator.setDuration(400L);
    localValueAnimator.addUpdateListener(new xrc(this, i1, i2));
    localValueAnimator.addListener(new xre(this));
    localValueAnimator.start();
  }
  
  public void H()
  {
    int i1;
    label115:
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
    {
      if ((c()) && (this.jdField_f_of_type_AndroidWidgetButton != null) && ((this.jdField_f_of_type_AndroidWidgetButton != this.jdField_a_of_type_AndroidWidgetButton) || (this.Z)))
      {
        this.jdField_f_of_type_AndroidWidgetButton.clearAnimation();
        this.jdField_f_of_type_AndroidWidgetButton.setVisibility(0);
        if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
          break label596;
        }
        this.jdField_f_of_type_AndroidWidgetButton.setBackgroundDrawable(new BitmapDrawable(this.jdField_b_of_type_AndroidGraphicsBitmap));
        this.jdField_f_of_type_AndroidWidgetButton.setText("");
      }
      this.jdField_f_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(4);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean) {
        break label610;
      }
      i1 = 0;
      c(i1, false);
      if (this.jdField_r_of_type_Int == 10002) {
        this.jdField_a_of_type_AndroidWidgetButton.clearAnimation();
      }
      this.jdField_g_of_type_AndroidWidgetButton.clearAnimation();
      this.jdField_g_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      if (this.jdField_h_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      }
      as();
      ar();
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.a(84.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.a(84.0F, getResources());
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.a(59.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.a(59.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.a(59.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.a(59.0F, getResources());
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (!this.jdField_g_of_type_Boolean) {
        break label621;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a();
      }
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      if (this.jdField_r_of_type_Int == 10002) {
        break label615;
      }
      i1 = 0;
      label443:
      ((TextView)localObject).setVisibility(i1);
      if (this.jdField_r_of_type_Int != 10002) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(0);
      ((StringBuilder)localObject).append("秒");
      this.jdField_g_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(4);
      if (this.jdField_k_of_type_Boolean)
      {
        this.jdField_B_of_type_Int = 0;
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr.a();
      }
      return;
      label596:
      this.jdField_f_of_type_AndroidWidgetButton.setBackgroundResource(this.jdField_e_of_type_Int);
      break;
      label610:
      i1 = 4;
      break label115;
      label615:
      i1 = 8;
      break label443;
      label621:
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void I()
  {
    int i2 = this.jdField_f_of_type_Int;
    int i1 = i2;
    if (this.jdField_k_of_type_Boolean) {
      if (i2 < 60000) {
        break label154;
      }
    }
    label154:
    for (i1 = 10000;; i1 = this.jdField_f_of_type_Int % 10000)
    {
      int i3 = i1 / 1000;
      int i4 = i1 % 1000;
      i2 = i3;
      if (i4 >= 500) {
        i2 = i3 + 1;
      }
      i3 = i2;
      if (i2 > jdField_w_of_type_Int) {
        i3 = jdField_w_of_type_Int;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "[@] adjustRecordTime: time= " + i1 + ",seconds = " + i3 + ", ms=" + i4);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i3);
      localStringBuilder.append("秒");
      this.jdField_g_of_type_AndroidWidgetTextView.setText(localStringBuilder);
      return;
    }
  }
  
  public void J()
  {
    if (!this.jdField_k_of_type_Boolean) {}
    while (this.jdField_f_of_type_Int / 10000 == this.jdField_B_of_type_Int) {
      return;
    }
    this.jdField_B_of_type_Int = (this.jdField_f_of_type_Int / 10000);
    SLog.c("PTV.NewFlowCameraActivity", "adjustFragmentThumb. fragment count = %d.");
    if ((this.jdField_B_of_type_Int < 6) && (!d()))
    {
      QQToast.a(this, "手机内存空间不足。", 1).a();
      am();
      return;
    }
    Bitmap localBitmap = a();
    if (localBitmap == null)
    {
      SLog.e("PTV.NewFlowCameraActivity", "adjustFragmentThumb error. thumbBitmap = null.");
      return;
    }
    ThreadManager.postImmediately(new xrh(this, localBitmap), null, false);
  }
  
  public void K()
  {
    if (!this.jdField_k_of_type_Boolean) {}
    while ((this.jdField_f_of_type_Int < 8000) || (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))) {
      return;
    }
    SLog.c("PTV.NewFlowCameraActivity", "show fragment tip.");
    this.jdField_j_of_type_AndroidWidgetTextView.setText("继续按住进入连拍模式");
    this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setStartOffset(1500L);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new xri(this));
    this.jdField_j_of_type_AndroidWidgetTextView.startAnimation(localAlphaAnimation);
  }
  
  public void L()
  {
    if (!this.jdField_k_of_type_Boolean) {}
    while ((this.jdField_f_of_type_Int < 55000) || (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))) {
      return;
    }
    SLog.c("PTV.NewFlowCameraActivity", "show end fragment tip.");
    this.jdField_j_of_type_AndroidWidgetTextView.setText("即将拍满6段进入编辑");
    this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void L_()
  {
    an();
    b(true);
  }
  
  public void M()
  {
    Object localObject3 = null;
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter == null)
    {
      localObject1 = "";
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localObject1 = localObject3;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a();
        if ((localObject1 == null) || (((PtvTemplateManager.PtvTemplateInfo)localObject1).category != 0)) {
          break label163;
        }
        localObject1 = localObject3;
      }
    }
    label163:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("face", 2, "filterFirstFrameOK path=" + (String)localObject2);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null) && ("-3".equals(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a())))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter(PtvTemplateManager.jdField_b_of_type_JavaLangString);
        return;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.jdField_a_of_type_JavaLangString;
        break;
      }
      if (localObject1 == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter((String)localObject2);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter((String)localObject2, ((PtvTemplateManager.PtvTemplateInfo)localObject1).category, ((PtvTemplateManager.PtvTemplateInfo)localObject1).gestureType, ((PtvTemplateManager.PtvTemplateInfo)localObject1).gestureWording);
      return;
    }
  }
  
  public void N() {}
  
  public void O()
  {
    runOnUiThread(new xrl(this));
  }
  
  public void P()
  {
    if (QLog.isColorLevel()) {
      QLog.e("PTV.NewFlowCameraActivity", 2, "cancelProgressDialog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  protected final void Q() {}
  
  public void R()
  {
    this.jdField_l_of_type_JavaLangString = a(this.jdField_d_of_type_Int);
    this.jdField_d_of_type_AndroidWidgetButton.setText(this.jdField_l_of_type_JavaLangString);
  }
  
  public int a()
  {
    Object localObject = super.getIntent();
    int i2 = ((Intent)localObject).getIntExtra("entrance_type", 99);
    int i1 = i2;
    if (i2 == 100)
    {
      localObject = (SessionInfo)((Intent)localObject).getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      if (localObject == null) {
        break label94;
      }
    }
    label94:
    for (i1 = ((SessionInfo)localObject).jdField_a_of_type_Int;; i1 = 0)
    {
      switch (i1)
      {
      default: 
        i1 = 11;
        return i1;
      case 0: 
        return 11;
      case 1: 
        return 9;
      }
      return 10;
    }
  }
  
  int a(int paramInt)
  {
    int i1 = paramInt;
    if (RMVideoStateMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_d_of_type_Boolean))
    {
      int i2 = paramInt % 16;
      i1 = paramInt;
      if (i2 > 0) {
        i1 = paramInt + (16 - i2);
      }
    }
    return i1;
  }
  
  int a(ArrayList paramArrayList)
  {
    String str = getIntent().getStringExtra("dongxiao_id");
    if (!StringUtil.a(str))
    {
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        if ((paramArrayList.get(i1) != null) && (((PtvTemplateManager.PtvTemplateInfo)paramArrayList.get(i1)).id.equals(str))) {
          return i1;
        }
        i1 += 1;
      }
    }
    return -1;
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    for (Object localObject1 = null;; localObject1 = null)
    {
      try
      {
        if (this.jdField_B_of_type_Boolean) {
          continue;
        }
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.getChildAt(0);
        if (!TextureView.class.isInstance(localObject2)) {
          continue;
        }
        localObject2 = ((TextureView)localObject2).getBitmap(paramInt1, paramInt2);
        localObject1 = localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("PTV.NewFlowCameraActivity", 2, "getViewBitmap oom" + localOutOfMemoryError);
        return null;
      }
      return localObject1;
    }
  }
  
  protected FlowPanel a()
  {
    return null;
  }
  
  public String a()
  {
    return this.jdField_r_of_type_JavaLangString;
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 1944	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 3233	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: astore_2
    //   7: aload_2
    //   8: new 212	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 3235
    //   18: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 3241	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   31: aconst_null
    //   32: ldc_w 3243
    //   35: iconst_1
    //   36: anewarray 1062	java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: aload_1
    //   42: aastore
    //   43: aconst_null
    //   44: invokevirtual 852	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +214 -> 263
    //   52: aload_1
    //   53: invokeinterface 3246 1 0
    //   58: ifeq +205 -> 263
    //   61: aload_1
    //   62: aload_1
    //   63: ldc_w 3247
    //   66: invokeinterface 863 2 0
    //   71: invokeinterface 3249 2 0
    //   76: astore_2
    //   77: aload_2
    //   78: invokestatic 933	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   81: ifne +176 -> 257
    //   84: new 1062	java/lang/String
    //   87: dup
    //   88: aload_2
    //   89: invokevirtual 3253	java/lang/String:getBytes	()[B
    //   92: ldc_w 3255
    //   95: invokespecial 3258	java/lang/String:<init>	([BLjava/lang/String;)V
    //   98: invokestatic 3262	com/tencent/mobileqq/utils/SecurityUtile:b	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore_2
    //   102: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq +30 -> 135
    //   108: ldc_w 266
    //   111: iconst_2
    //   112: new 212	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 3264
    //   122: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_2
    //   126: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 1220	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: aload_2
    //   136: astore_3
    //   137: aload_1
    //   138: ifnull +11 -> 149
    //   141: aload_1
    //   142: invokeinterface 877 1 0
    //   147: aload_2
    //   148: astore_3
    //   149: aload_3
    //   150: areturn
    //   151: astore_3
    //   152: aconst_null
    //   153: astore_2
    //   154: ldc 247
    //   156: astore_1
    //   157: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +33 -> 193
    //   163: ldc_w 266
    //   166: iconst_2
    //   167: new 212	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 3266
    //   177: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_3
    //   181: invokestatic 3270	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   184: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 582	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: aload_1
    //   194: astore_3
    //   195: aload_2
    //   196: ifnull -47 -> 149
    //   199: aload_2
    //   200: invokeinterface 877 1 0
    //   205: aload_1
    //   206: areturn
    //   207: astore_2
    //   208: aconst_null
    //   209: astore_1
    //   210: aload_1
    //   211: ifnull +9 -> 220
    //   214: aload_1
    //   215: invokeinterface 877 1 0
    //   220: aload_2
    //   221: athrow
    //   222: astore_2
    //   223: goto -13 -> 210
    //   226: astore_3
    //   227: aload_2
    //   228: astore_1
    //   229: aload_3
    //   230: astore_2
    //   231: goto -21 -> 210
    //   234: astore_3
    //   235: aload_1
    //   236: astore_2
    //   237: ldc 247
    //   239: astore_1
    //   240: goto -83 -> 157
    //   243: astore 4
    //   245: aload_2
    //   246: astore_3
    //   247: aload_1
    //   248: astore_2
    //   249: aload_3
    //   250: astore_1
    //   251: aload 4
    //   253: astore_3
    //   254: goto -97 -> 157
    //   257: ldc 247
    //   259: astore_2
    //   260: goto -158 -> 102
    //   263: ldc 247
    //   265: astore_2
    //   266: goto -131 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	NewFlowCameraActivity
    //   0	269	1	paramString	String
    //   6	194	2	localObject1	Object
    //   207	14	2	localObject2	Object
    //   222	6	2	localObject3	Object
    //   230	36	2	localObject4	Object
    //   136	14	3	localObject5	Object
    //   151	30	3	localException1	Exception
    //   194	1	3	str	String
    //   226	4	3	localObject6	Object
    //   234	1	3	localException2	Exception
    //   246	8	3	localObject7	Object
    //   243	9	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   7	48	151	java/lang/Exception
    //   7	48	207	finally
    //   52	102	222	finally
    //   102	135	222	finally
    //   157	193	226	finally
    //   52	102	234	java/lang/Exception
    //   102	135	243	java/lang/Exception
  }
  
  public void a() {}
  
  public void a(float paramFloat)
  {
    if (paramFloat > 0.0F)
    {
      if (!this.jdField_o_of_type_Boolean) {}
    }
    else {
      while (!this.jdField_o_of_type_Boolean) {
        return;
      }
    }
    Object localObject = getResources();
    if (paramFloat > 0.0F) {}
    while (paramFloat > 0.0F)
    {
      this.jdField_o_of_type_Boolean = true;
      int i1 = ScreenUtil.a(59.0F);
      localObject = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = i1;
      ((ViewGroup.LayoutParams)localObject).width = i1;
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (this.au)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("点击拍照，长按录制");
        return;
        ((Resources)localObject).getDimensionPixelSize(2131559178);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("录制短视频");
        return;
      }
    }
    c(false);
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_j_of_type_Boolean) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "[@] previewSizeAdjustUI:width=" + paramInt1 + " height=" + paramInt2);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("PTV.NewFlowCameraActivity", 2, "[previewSizeAdjustUI]rmStateMgr " + null);
    return;
    this.jdField_h_of_type_Int = paramInt1;
    this.jdField_i_of_type_Int = paramInt2;
    this.ae = true;
    e(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator.a(paramInt1, paramInt2, (int)this.jdField_c_of_type_Float, (int)this.jdField_d_of_type_Float);
    if ((this.ae) && (this.ad) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder == null)) {}
    for (;;)
    {
      RMVideoClipSpec localRMVideoClipSpec = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setPreviewSize(paramInt1, paramInt2, localRMVideoClipSpec);
      if ((VersionUtils.c()) && (!this.jdField_b_of_type_AndroidWidgetButton.isEnabled())) {
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      }
      this.jdField_h_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      if (this.jdField_f_of_type_Int < CodecParam.jdField_c_of_type_Int) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("PTV.NewFlowCameraActivity", 2, "previewSizeAdjustUI spec: " + localRMVideoClipSpec.toString());
      return;
      if (i())
      {
        localRMVideoClipSpec = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, localRMVideoClipSpec.jdField_e_of_type_Int, localRMVideoClipSpec.jdField_f_of_type_Int);
          ad();
          this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(-1, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_Int * 1000);
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setHwEncoder(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
        }
      }
    }
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "onPreviewResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
    }
    if (paramInt1 == 1002)
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.ah = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.e();
    }
  }
  
  void a(int paramInt1, int paramInt2, boolean paramBoolean, int[] paramArrayOfInt)
  {
    b(paramInt1, paramInt2, paramBoolean, paramArrayOfInt);
  }
  
  void a(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    int i1 = 0;
    paramArrayOfInt = a(2131362087);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)a(paramArrayOfInt);
    if (!this.jdField_C_of_type_Boolean)
    {
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
      paramArrayOfInt.setLayoutParams(localLayoutParams);
    }
    int i2 = (int)this.jdField_d_of_type_Float;
    i2 = (int)this.jdField_d_of_type_Float - i2;
    if (paramInt2 >= this.jdField_d_of_type_Float) {
      paramInt2 = i2 - 0;
    }
    for (;;)
    {
      this.jdField_j_of_type_Int = i1;
      this.jdField_l_of_type_Int = paramInt2;
      this.jdField_m_of_type_Int = (i1 * this.jdField_i_of_type_Int / paramInt1);
      this.jdField_n_of_type_Int = (paramInt2 * this.jdField_i_of_type_Int / paramInt1);
      if (this.jdField_u_of_type_Boolean) {
        a(5.0F);
      }
      return;
      paramInt2 = (int)this.jdField_d_of_type_Float - paramInt2;
      if (this.jdField_B_of_type_Boolean)
      {
        paramInt2 = i2 - 0;
      }
      else if (paramInt2 <= 0)
      {
        paramInt2 = i2 - 0;
      }
      else
      {
        i2 -= paramInt2;
        i1 = paramInt2;
        paramInt2 = i2;
      }
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    runOnUiThread(new xrj(this, paramString, paramInt));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_o_of_type_Boolean)
    {
      this.jdField_f_of_type_Int = paramInt;
      RMVideoStateMgr localRMVideoStateMgr = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
      localRMVideoStateMgr.jdField_a_of_type_Int += 1;
      if (!paramBoolean) {
        break label57;
      }
      h(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.post(new xrg(this, paramBoolean));
      return;
      label57:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean) {}
      for (int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();; i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex())
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwAutoSegmentMgr.a(paramInt, i1);
        h(this.jdField_I_of_type_Boolean);
        if (!this.jdField_I_of_type_Boolean) {
          break label123;
        }
        this.jdField_I_of_type_Boolean = false;
        break;
      }
      label123:
      this.jdField_I_of_type_Boolean = true;
    }
  }
  
  public void a(Activity paramActivity) {}
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Activity paramActivity, Intent paramIntent) {}
  
  void a(Context paramContext, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("PTV.NewFlowCameraActivity", 2, "showProgressDialog");
    }
    try
    {
      if (this.jdField_b_of_type_AndroidAppProgressDialog != null) {
        C();
      }
      for (;;)
      {
        this.jdField_h_of_type_AndroidWidgetTextView.setText(paramInt);
        if (this.jdField_b_of_type_AndroidAppProgressDialog.isShowing()) {
          break;
        }
        this.jdField_b_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_b_of_type_AndroidAppProgressDialog = new ProgressDialog(paramContext, 2131624516);
        this.jdField_b_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_b_of_type_AndroidAppProgressDialog.show();
        this.jdField_b_of_type_AndroidAppProgressDialog.setContentView(2130969180);
        this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidAppProgressDialog.findViewById(2131363399));
      }
      return;
    }
    catch (Throwable paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PTV.NewFlowCameraActivity", 2, "showProgressDialog", paramContext);
      }
    }
  }
  
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_j_of_type_Int = 0;
    this.jdField_k_of_type_Int = 0;
    this.jdField_l_of_type_Int = 0;
    this.jdField_m_of_type_Int = 0;
    this.jdField_n_of_type_Int = 0;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.ai = false;
    this.ag = false;
    this.ah = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = null;
    this.ad = false;
    this.ae = false;
    Intent localIntent = super.getIntent();
    this.au = localIntent.getBooleanExtra("support_photo_merge", false);
    if (paramBundle != null) {
      this.jdField_v_of_type_Boolean = paramBundle.getBoolean("flow_camera_capture_mode", false);
    }
    if (this.jdField_v_of_type_Boolean) {
      this.au = true;
    }
    this.jdField_E_of_type_Int = localIntent.getIntExtra("video_min_frame_count", 11);
    this.av = localIntent.getBooleanExtra("recapture", false);
    this.jdField_m_of_type_Boolean = localIntent.getBooleanExtra("show_guide_view", false);
    this.jdField_g_of_type_Long = localIntent.getLongExtra("activity_start_time", 0L);
    a(localIntent, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("DynamicAdjustment", 2, "Start NewFlowCameraActivity time : " + this.jdField_g_of_type_Long);
    }
    if (this.aG) {
      FlowCameraMqqAction.a("", "0X8007930", "", "", "", "");
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
        HwServlet.getConfig(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      }
      ShortVideoMtaReport.a(this.jdField_r_of_type_Int);
      this.jdField_s_of_type_Int = localIntent.getIntExtra("entrance_type", 99);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)localIntent.getParcelableExtra("PhotoConst.SEND_SESSION_INFO"));
      FlowCameraConstant.jdField_a_of_type_Int = 2;
      if ((CameraAbility.c()) && (!this.au)) {
        FlowCameraConstant.jdField_a_of_type_Int = 1;
      }
      FlowCameraConstant.jdField_a_of_type_Float = 0.75F;
      if (paramBundle == null) {
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
      this.ao = false;
      Object localObject = ((ActivityManager)super.getSystemService("activity")).getDeviceConfigurationInfo();
      boolean bool1;
      boolean bool2;
      label585:
      label995:
      int i1;
      label806:
      int i2;
      if ((localObject != null) && (((ConfigurationInfo)localObject).reqGlEsVersion >= 131072))
      {
        bool1 = true;
        this.ao = bool1;
        this.am = false;
        this.an = true;
        bool1 = paramBundle.getBoolean("flow_camera_use_filter_function", false);
        if (bool1)
        {
          this.am = PtvFilterSoLoad.a(VideoEnvironment.a(), false);
          this.an = PtvFilterSoLoad.a();
        }
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "<FilterInit_> useFilter=" + bool1 + " mHasFilterSoLib=" + this.am + "  mIsLibVersionErr=" + this.an);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this.jdField_r_of_type_Int, this.am);
        this.aE = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(1);
        if (this.jdField_r_of_type_Int == 10002)
        {
          bool2 = VideoEnvironment.b(7);
          boolean bool3 = ((Boolean)((StoryConfigManager)SuperManager.a(10)).b("boolean_enable_multi_video_fragment", Boolean.valueOf(true))).booleanValue();
          if ((!bool2) || ((!bool3) && (!this.aE))) {
            break label1327;
          }
          bool1 = true;
          this.jdField_k_of_type_Boolean = bool1;
          if (paramBundle.getLong("troop_uin", 0L) != 0L) {
            this.jdField_k_of_type_Boolean = false;
          }
          SLog.a("PTV.NewFlowCameraActivity", "avCodecSupportMultiVideoBlock=%s, notMultiVideoBlockBlackList=%s, supportMediaCodec=%s", Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(this.aE));
        }
        b(paramBundle);
        a(paramBundle, false);
        if (this.jdField_i_of_type_Boolean) {
          a("612", "1", "0", true);
        }
        this.jdField_q_of_type_Boolean = paramBundle.getBoolean("flow_camera_use_surfaceview", false);
        this.jdField_u_of_type_Boolean = paramBundle.getBoolean("flow_camera_video_mode", false);
        if ((QLog.isColorLevel()) && (this.jdField_r_of_type_Int == 10008)) {
          QLog.i("PTV.NewFlowCameraActivity", 2, String.format(Locale.getDefault(), "initData capture: %b, video: %b", new Object[] { Boolean.valueOf(this.jdField_v_of_type_Boolean), Boolean.valueOf(this.jdField_u_of_type_Boolean) }));
        }
        localObject = paramBundle.getString("sv_config");
        bool2 = paramBundle.getBoolean("sv_whitelist");
        this.ak = paramBundle.getBoolean("flow_show_filter_red", false);
        this.al = paramBundle.getBoolean("flow_show_filter_red_pkg", false);
        if ((!this.ak) && (!this.al)) {
          break label1333;
        }
        bool1 = true;
        this.aj = bool1;
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "<hongdian> mShowRedDotConfig=" + this.ak + " mShowRedDotPkg=" + this.al + "  mShowRedDot=" + this.aj);
        }
        this.jdField_f_of_type_JavaLangString = paramBundle.getString("callback");
        if ((this.jdField_r_of_type_Int != 10003) && (this.jdField_r_of_type_Int != 10011)) {
          FlowCameraConstant.jdField_a_of_type_Int = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).getInt("camera", FlowCameraConstant.jdField_a_of_type_Int);
        }
        X();
        if ((getIntent().getLongExtra("babyq_ability", 0L) & 1L) > 0L) {
          FlowCameraConstant.jdField_a_of_type_Int = 2;
        }
        this.jdField_N_of_type_Int = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).getInt("camera", FlowCameraConstant.jdField_a_of_type_Int);
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator;
        if (FlowCameraConstant.jdField_a_of_type_Int != 1) {
          break label1339;
        }
        bool1 = true;
        paramBundle.a(bool1);
        if (QLog.isColorLevel()) {
          QLog.d("PTV.faceGuide", 2, "initdata mHasFilterSoLib =" + this.am);
        }
        i1 = 0;
        paramBundle = (SessionInfo)localIntent.getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
        if (paramBundle != null) {
          i1 = paramBundle.jdField_a_of_type_Int;
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("sessionType", String.valueOf(i1));
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper = new QQStoryTakeVideoHelper(this, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr, localIntent);
        if (a() == 102) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper.a(false);
        }
        paramBundle = (Bundle)localObject;
        if (this.jdField_r_of_type_Int == 10002)
        {
          localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper.a((String)localObject);
          paramBundle = (Bundle)localObject;
          if (((Integer)((StoryConfigManager)SuperManager.a(10)).b("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == -1)
          {
            this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper.a();
            paramBundle = (Bundle)localObject;
          }
        }
        i2 = NetworkUtil.a(this);
        this.jdField_D_of_type_Boolean = localIntent.getBooleanExtra("ignore_dpc_duration", false);
        if (this.jdField_r_of_type_Int == 10012) {
          this.jdField_y_of_type_JavaLangString = TribeTakeVideoHelper.a(localIntent.getExtras());
        }
        this.jdField_K_of_type_Boolean = localIntent.getBooleanExtra("is_glance_video", false);
        if (!this.jdField_D_of_type_Boolean) {
          break label1345;
        }
        this.jdField_p_of_type_Int = localIntent.getIntExtra("video_duration", 20);
        jdField_w_of_type_Int = this.jdField_p_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a((AppInterface)getAppRuntime(), 3, paramBundle, bool2, i1, i2, this.jdField_p_of_type_Int);
      }
      for (;;)
      {
        if (this.jdField_k_of_type_Boolean) {
          CodecParam.jdField_c_of_type_Int = 60000;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this, FlowCameraMqqAction.a(this), this)) {
          break label1545;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper.b();
        super.finish();
        return;
        bool1 = false;
        break;
        label1327:
        bool1 = false;
        break label585;
        label1333:
        bool1 = false;
        break label806;
        label1339:
        bool1 = false;
        break label995;
        label1345:
        if (this.jdField_K_of_type_Boolean)
        {
          this.jdField_x_of_type_Int = localIntent.getIntExtra("glance_video_max_time", QzoneConfig.getInstance().getConfig("MiniVideo", "GlanceVideoMaxTime", 1));
          jdField_w_of_type_Int = this.jdField_x_of_type_Int;
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a((AppInterface)getAppRuntime(), 2, paramBundle, bool2, i1, i2, this.jdField_x_of_type_Int);
          VideoEnvironment.d(this.jdField_x_of_type_Int);
          LpReportInfo_pf00064.allReport(627, 1);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a((AppInterface)getAppRuntime(), 2, paramBundle, bool2, i1, i2, this.jdField_g_of_type_Int);
          if ((this.jdField_r_of_type_Int == 10000) || (this.jdField_r_of_type_Int == 10003) || (this.jdField_r_of_type_Int == 10011) || (this.jdField_r_of_type_Int == 10004) || (this.jdField_r_of_type_Int == 10010)) {
            VideoEnvironment.d(10);
          }
          if (this.aG) {
            VideoEnvironment.d(10);
          }
          jdField_w_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b();
          if (this.jdField_i_of_type_Boolean) {
            CodecParam.jdField_c_of_type_Int += 100;
          }
        }
      }
      label1545:
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this, new xsa(this, this));
      localObject = getResources().getDisplayMetrics();
      this.jdField_c_of_type_Float = ((DisplayMetrics)localObject).widthPixels;
      this.jdField_d_of_type_Float = ((DisplayMetrics)localObject).heightPixels;
      this.jdField_e_of_type_Float = (this.jdField_d_of_type_Float / this.jdField_c_of_type_Float);
      this.jdField_b_of_type_Int = ((int)this.jdField_d_of_type_Float);
      this.jdField_a_of_type_AndroidViewOrientationEventListener = new xpz(this, getApplicationContext());
      if ((this.jdField_a_of_type_AndroidViewOrientationEventListener.canDetectOrientation()) && (this.jdField_r_of_type_Int != 10002)) {
        this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy = new CameraProxy(this, this.jdField_a_of_type_AndroidOsHandler);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.c(this.jdField_r_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(this.jdField_a_of_type_AndroidHardwareCamera$FaceDetectionListener);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(new CameraExceptionHandler(this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler$Callback));
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "initData(), mPtvMode:false,mCaptureMode:false, config=" + paramBundle + ", white=" + bool2);
      }
      W();
      GLVideoClipUtil.c();
      CaptureReportUtil.m();
      CaptureReportUtil.jdField_a_of_type_Int = this.jdField_r_of_type_Int;
      CaptureReportUtil.jdField_e_of_type_Boolean = false;
      CaptureReportUtil.a();
    }
  }
  
  public void a(Bundle paramBundle, String paramString)
  {
    paramBundle = paramBundle.getString("set_user_callback");
    if (paramBundle == null) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramBundle = Class.forName(paramBundle).newInstance();
          if ((paramBundle instanceof FlowComponentInterface))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface = ((FlowComponentInterface)paramBundle);
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface.c_(paramString);
            return;
          }
        }
        catch (Throwable paramBundle)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface = null;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("PTV.NewFlowCameraActivity", 2, "initComponentParamData:exp =" + paramBundle);
  }
  
  protected void a(ViewGroup paramViewGroup)
  {
    getLayoutInflater().inflate(2130970346, paramViewGroup);
    this.jdField_g_of_type_AndroidViewView = a(2131366244);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover = ((CameraCover)a(2131363420));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131369000));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131369007));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131369522));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131369521));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131368942));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView = a(2131370139);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131370140));
    this.jdField_d_of_type_AndroidViewView = a(2131370142);
    this.jdField_c_of_type_AndroidViewView = a(2131370143);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)a(2131370144));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131370145));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131370146));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)a(2131370114));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)a(2131368623));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText = ((ExtendEditText)a(2131373530));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setEditableFactory(QzoneTextBuilder.b);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131373529));
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)a(2131373531));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)a(2131373532));
    this.jdField_e_of_type_AndroidViewView = a(2131373533);
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)a(2131370157));
    if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {
      this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_i_of_type_JavaLangString);
    }
    ax();
    int i1;
    if (this.aO)
    {
      if (getIntent().getIntExtra("edit_video_type", 0) == 10002)
      {
        i1 = 1;
        if (i1 == 0) {
          break label1596;
        }
        this.jdField_b_of_type_AndroidGraphicsBitmap = b(this);
      }
    }
    else
    {
      label395:
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)a(2131369814));
      this.jdField_e_of_type_AndroidWidgetButton = ((Button)a(2131370151));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView = ((RedDotImageView)a(2131370155));
      this.jdField_g_of_type_AndroidWidgetButton = ((Button)a(2131365527));
      this.jdField_f_of_type_AndroidViewView = a(2131370156);
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)a(2131369813));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131370116));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer = ((ImageViewVideoPlayer)a(2131364406));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setIMPlayerEndListener(this);
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)a(2131364410));
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)a(2131366275));
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)a(2131369008));
      this.jdField_h_of_type_AndroidWidgetButton = ((Button)a(2131370149));
      this.jdField_i_of_type_AndroidWidgetButton = ((Button)a(2131370150));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131370161));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView = ((CameraFocusView)a(2131366946));
      b((int)this.jdField_c_of_type_Float, (int)this.jdField_d_of_type_Float);
      this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setOnClickListener(this);
      this.jdField_g_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_h_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_i_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout = ((FSurfaceViewLayout)a(2131370138));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView.setDrawableRes(2130843247);
      if (!CameraAbility.c())
      {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_h_of_type_Boolean = false;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      if (this.jdField_r_of_type_Int == 10003)
      {
        this.jdField_g_of_type_AndroidWidgetButton.setText("下一步");
        this.jdField_g_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if (!this.au) {
        break label1627;
      }
      if ((this.jdField_u_of_type_Boolean) || (!this.jdField_v_of_type_Boolean)) {
        break label1607;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131438676));
      label857:
      if ((QLog.isColorLevel()) && (this.jdField_r_of_type_Int == 10008)) {
        QLog.i("PTV.NewFlowCameraActivity", 2, String.format(Locale.getDefault(), "onCreateView mSupportPhotoMerge: %b, mRDVideoMode: %b, mRDCaptureMode: %b", new Object[] { Boolean.valueOf(this.au), Boolean.valueOf(this.jdField_u_of_type_Boolean), Boolean.valueOf(this.jdField_v_of_type_Boolean) }));
      }
      if ((this.au) || (this.aG)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      }
      if (this.jdField_r_of_type_Int == 10002)
      {
        paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper.a();
        if (!TextUtils.equals(paramViewGroup, "点击拍照，长按录像")) {
          StoryReportor.a("video_shoot", "exp_wording", 0, 0, new String[0]);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup);
      }
      ViewCompat.setImportantForAccessibility(this.jdField_a_of_type_AndroidWidgetTextView, 2);
      if (!this.aO) {
        break label1741;
      }
      this.jdField_f_of_type_AndroidWidgetButton = this.jdField_a_of_type_AndroidWidgetButton;
      paramViewGroup = this.jdField_a_of_type_AndroidWidgetButton;
      if (!this.Z) {
        break label1735;
      }
      i1 = 0;
      label1033:
      paramViewGroup.setVisibility(i1);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(this.Z);
      this.jdField_e_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_e_of_type_Int = 2130845316;
      if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (this.jdField_f_of_type_AndroidWidgetButton != null)) {
        this.jdField_f_of_type_AndroidWidgetButton.setBackgroundDrawable(new BitmapDrawable(this.jdField_b_of_type_AndroidGraphicsBitmap));
      }
      if ((this.jdField_b_of_type_AndroidGraphicsBitmap == null) && ((this.jdField_r_of_type_Int == 10002) || (this.jdField_r_of_type_Int == 10012)))
      {
        this.jdField_f_of_type_AndroidWidgetButton = this.jdField_e_of_type_AndroidWidgetButton;
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_e_of_type_Int = 0;
      }
      label1179:
      as();
      ar();
      i1 = getIntent().getIntExtra("edit_video_type", 0);
      if (((!this.aG) && (i1 != 10000) && (i1 != 10003) && (i1 != 10004) && (i1 != 10010)) || (!this.ay)) {
        break label1791;
      }
      jdField_a_of_type_Int = 2;
      paramViewGroup = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLayoutParams();
      if (paramViewGroup != null)
      {
        paramViewGroup.leftMargin = 0;
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setLayoutParams(paramViewGroup);
      }
      label1273:
      paramViewGroup = new Rect();
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getGlobalVisibleRect(paramViewGroup);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryCameraZoom.jdField_a_of_type_Float = paramViewGroup.top;
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, getResources().getColor(2131492969), 100, getResources().getColor(2131493308));
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(6.0F);
      Q();
      if (this.jdField_M_of_type_Boolean)
      {
        this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new xqc(this));
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      }
      Y();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setReddotXOffsetDp(3);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setReddotYOffsetDp(3);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setRedDotBase(1);
      at();
      if (this.jdField_k_of_type_Boolean)
      {
        this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)a(2131370153));
        this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)a(2131370162));
        this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)a(2131370154));
        this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)a(2131370160));
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
        this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
      }
      if (this.jdField_r_of_type_Int == 10002) {}
      this.jdField_a_of_type_AndroidViewView.post(new xqe(this));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break label1841;
        }
        paramViewGroup = "3";
      }
    }
    for (;;)
    {
      if (this.jdField_r_of_type_Int == 10000) {
        StoryReportor.a("aio_shoot", "exp_shoot", 0, 0, new String[] { paramViewGroup });
      }
      return;
      i1 = 0;
      break;
      label1596:
      this.jdField_b_of_type_AndroidGraphicsBitmap = a(this);
      break label395;
      label1607:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131438672));
      break label857;
      label1627:
      if ((this.jdField_r_of_type_Int == 10007) && (!this.aH) && (this.aI))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131438676));
        break label857;
      }
      if ((this.jdField_r_of_type_Int == 10008) && (!this.aH) && (this.aI))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131438676));
        break label857;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131438675));
      break label857;
      label1735:
      i1 = 8;
      break label1033;
      label1741:
      this.jdField_f_of_type_AndroidWidgetButton = this.jdField_e_of_type_AndroidWidgetButton;
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_e_of_type_Int = 0;
      break label1179;
      label1791:
      jdField_a_of_type_Int = 1;
      paramViewGroup = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLayoutParams();
      if (paramViewGroup == null) {
        break label1273;
      }
      paramViewGroup.leftMargin = ((int)(getResources().getDisplayMetrics().widthPixels / 4.5F));
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setLayoutParams(paramViewGroup);
      break label1273;
      label1841:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        paramViewGroup = "2";
      } else {
        paramViewGroup = "1";
      }
    }
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new xpu(this));
      ShortVideoExceptionReporter.a(new RuntimeException("onMediaInfoChanged failed"));
      return;
    }
    a(this.jdField_r_of_type_Int, this.jdField_v_of_type_JavaLangString, this.jdField_w_of_type_JavaLangString, paramLocalMediaInfo, 0, 0);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.c(this.jdField_E_of_type_Int)) {
      return;
    }
    getIntent().getIntExtra("edit_video_type", 0);
    this.jdField_v_of_type_JavaLangString = paramString;
    this.jdField_w_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = new LocalMediaInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path = this.jdField_v_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mMimeType = "video";
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "onEncodeFinish. hwVideoFilePath = " + this.jdField_v_of_type_JavaLangString + " ; hwAudioFilePath = " + this.jdField_w_of_type_JavaLangString);
    }
    MediaScanner.a(this).a(this, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).edit();
    paramString.putInt("sp_mc_crash_times", 0);
    SharedPreUtils.a(paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
    localReportInfo.jdField_c_of_type_JavaLangString = paramString1;
    localReportInfo.jdField_d_of_type_JavaLangString = paramString2;
    localReportInfo.jdField_e_of_type_JavaLangString = paramString3;
    paramString1 = "";
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      paramString1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    }
    QZoneClickReport.report(paramString1, localReportInfo, paramBoolean);
  }
  
  void a(boolean paramBoolean)
  {
    l();
    an();
    if (paramBoolean) {
      b(true);
    }
    if (e())
    {
      ShortVideoMtaReport.a("shortvideo_cancel_effects", null);
      return;
    }
    ShortVideoMtaReport.a("shortvideo_cancel_noeffects", null);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    super.runOnUiThread(new xrm(this, paramBoolean, paramInt));
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    super.runOnUiThread(new xrq(this, paramBoolean, paramString, paramInt));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    super.runOnUiThread(new xrn(this, paramInt, paramBoolean1, paramBoolean2));
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent, int paramInt, float paramFloat1, float paramFloat2)
  {
    int i1 = (int)(paramMotionEvent.getX(paramInt) + paramFloat1);
    int i2 = (int)(paramMotionEvent.getY(paramInt) + paramFloat2);
    SLog.b("PTV.NewFlowCameraActivity", "referX = " + paramFloat1 + ", referY = " + paramFloat2);
    SLog.b("PTV.NewFlowCameraActivity", "motionEvent.getX(pointIndex) = " + paramMotionEvent.getX(paramInt) + ", motionEvent.getY(pointIndex) = " + paramMotionEvent.getY(paramInt));
    long l1 = System.currentTimeMillis();
    if (!this.aE)
    {
      if (TakeVideoUtils.a(this.jdField_b_of_type_AndroidWidgetButton, i1, i2))
      {
        if (this.jdField_r_of_type_Int == 10002)
        {
          SLog.b("PTV.NewFlowCameraActivity", "recordButtonPointerDown : click switch camera button , change camera.");
          this.jdField_h_of_type_Long = 0L;
          E();
        }
        return true;
      }
      if (this.jdField_r_of_type_Int == 10002)
      {
        if ((paramMotionEvent.getPointerCount() != 2) || (l1 - this.jdField_h_of_type_Long >= 300L)) {
          break label235;
        }
        SLog.b("PTV.NewFlowCameraActivity", "recordButtonPointerDown : double click , change camera.");
        E();
      }
    }
    label235:
    for (this.jdField_h_of_type_Long = 0L;; this.jdField_h_of_type_Long = l1)
    {
      paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
      paramMotionEvent.setLocation(i1, i2);
      a(paramMotionEvent);
      paramMotionEvent.recycle();
      return true;
    }
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    SLog.d("PTV.NewFlowCameraActivity", "encode video failed");
    paramInt = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).getInt("sp_mc_crash_times", 0);
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).edit();
    localEditor.putInt("sp_mc_crash_times", paramInt + 1);
    SharedPreUtils.a(localEditor);
    ShortVideoExceptionReporter.a(paramThrowable);
    this.jdField_a_of_type_AndroidOsHandler.post(new xpt(this));
  }
  
  public void aa_() {}
  
  public int b()
  {
    switch (getIntent().getIntExtra("edit_video_type", 0))
    {
    default: 
      return 0;
    case 10002: 
      return 1;
    case 10000: 
      return 2;
    case 10001: 
      return 3;
    }
    return 5;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    QLog.e("PTV.NewFlowCameraActivity", 2, "CaptureProcessObserver.onFailed , failCode = " + paramInt);
    a(null, false);
  }
  
  void b(int paramInt1, int paramInt2, boolean paramBoolean, int[] paramArrayOfInt)
  {
    int i3 = (int)this.jdField_d_of_type_Float;
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "getVideoClipPreviewMapSize constScreenWidth=" + paramBoolean + String.format("screenWidth=%s,screenHeight=%s", new Object[] { Float.valueOf(this.jdField_c_of_type_Float), Float.valueOf(this.jdField_d_of_type_Float) }));
    }
    int i1;
    if (paramBoolean)
    {
      i1 = (int)this.jdField_c_of_type_Float;
      paramInt1 = (int)(paramInt1 * this.jdField_c_of_type_Float / paramInt2);
      paramArrayOfInt[0] = paramInt2;
      paramArrayOfInt[1] = ((int)(i3 * paramInt2 / this.jdField_c_of_type_Float));
    }
    for (paramInt2 = i1;; paramInt2 = i1)
    {
      paramArrayOfInt[1] = a(paramArrayOfInt[1]);
      paramArrayOfInt[2] = paramInt2;
      paramArrayOfInt[3] = paramInt1;
      return;
      i1 = (int)(paramInt2 * this.jdField_d_of_type_Float / paramInt1);
      int i2 = (int)this.jdField_d_of_type_Float;
      paramArrayOfInt[0] = ((int)(this.jdField_c_of_type_Float * paramInt2 / i1));
      paramArrayOfInt[1] = ((int)(i3 * paramInt1 / this.jdField_d_of_type_Float));
      paramInt1 = i2;
    }
  }
  
  void b(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, e());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "setupCameraUI needUseOld = " + paramBoolean);
    }
    Object localObject3 = getResources().getDisplayMetrics();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131362087) == null)
    {
      localObject1 = localObject2;
      if (paramBoolean) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
      }
    }
    label346:
    int i1;
    if ((VersionUtils.d()) && (!this.jdField_q_of_type_Boolean))
    {
      localObject2 = new CameraTextureView(this);
      if ((localObject1 != null) && ((localObject1 instanceof TexturePreviewContext)))
      {
        ((CameraTextureView)localObject2).a = ((TexturePreviewContext)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(((CameraTextureView)localObject2).a);
        localObject1 = new FrameLayout.LayoutParams(-1, ((DisplayMetrics)localObject3).heightPixels);
        ((FrameLayout.LayoutParams)localObject1).gravity = 83;
        this.jdField_B_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a(this.am, this.ao);
        paramBoolean = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a(this, this, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setAppInterface(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setEnableBeauty(this.aB);
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "setupCameraUI needAddglview:" + paramBoolean + ", needChangeNewSurfaceView:" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean + ", needOpenglView:" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_d_of_type_Boolean + ", isSurpportFilter:" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean) {
          break label928;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131438675));
        if (this.jdField_r_of_type_Int == 10002)
        {
          String str = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper.a();
          this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_d_of_type_Boolean) {
          break label1038;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean) {
          break label1019;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "setupCameraUI isTemplateMode = " + this.jdField_g_of_type_Boolean);
        }
        if (this.jdField_g_of_type_Boolean) {
          break label1000;
        }
        if (!this.jdField_i_of_type_Boolean) {
          break label957;
        }
        if (this.jdField_f_of_type_AndroidWidgetButton != null)
        {
          localObject3 = this.jdField_f_of_type_AndroidWidgetTextView;
          if (!TextUtils.isEmpty(this.jdField_f_of_type_AndroidWidgetButton.getText().toString())) {
            break label947;
          }
          i1 = 4;
          label449:
          ((TextView)localObject3).setVisibility(i1);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView;
          if (!TextUtils.isEmpty(this.jdField_f_of_type_AndroidWidgetButton.getText().toString())) {
            break label952;
          }
          i1 = 0;
          label481:
          ((RedDotImageView)localObject3).setVisibility(i1);
        }
        label487:
        if (this.aj) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.a(true);
        }
        label502:
        this.jdField_C_of_type_Boolean = true;
        ((FrameLayout.LayoutParams)localObject1).height = 1;
        ((FrameLayout.LayoutParams)localObject1).width = 1;
        label517:
        ((FrameLayout.LayoutParams)localObject1).gravity = 81;
        if (this.jdField_B_of_type_Boolean) {
          ((FrameLayout.LayoutParams)localObject1).gravity = 49;
        }
        ((View)localObject2).setId(2131362087);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.addView((View)localObject2, 0, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setCameraView((View)localObject2);
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a();
        }
        this.jdField_x_of_type_Boolean = true;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 4) {
          break label1080;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.clearAnimation();
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(4);
        label609:
        if (!this.jdField_y_of_type_Boolean) {
          break label1099;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d();
        label630:
        if ((this.jdField_r_of_type_Int == 10011) && ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_AndroidOpenglGLSurfaceView instanceof CameraFilterGLView)))
        {
          ((CameraFilterGLView)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_AndroidOpenglGLSurfaceView).jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletCameraInterface = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletCameraInterface;
          ((CameraFilterGLView)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_AndroidOpenglGLSurfaceView).jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.a(true);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_AndroidOpenglGLSurfaceView instanceof CameraFilterGLView)) {
          ((CameraFilterGLView)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_AndroidOpenglGLSurfaceView).jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor = this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor;
        }
        if ((!this.au) || (!h())) {
          break label1130;
        }
        if ((this.jdField_u_of_type_Boolean) || (!this.jdField_v_of_type_Boolean)) {
          break label1110;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131438676));
      }
    }
    for (;;)
    {
      if ((this.au) || (this.aG)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      }
      if (!this.jdField_l_of_type_Boolean) {
        k(true);
      }
      return;
      ((CameraTextureView)localObject2).a = new TexturePreviewContext(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy, ((DisplayMetrics)localObject3).widthPixels, ((DisplayMetrics)localObject3).heightPixels);
      break;
      localObject2 = new CameraPreview(this);
      if ((localObject1 != null) && ((localObject1 instanceof SurfacePreviewContext))) {}
      for (((CameraPreview)localObject2).a = ((SurfacePreviewContext)localObject1);; ((CameraPreview)localObject2).a = new SurfacePreviewContext(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy, ((DisplayMetrics)localObject3).widthPixels, ((DisplayMetrics)localObject3).heightPixels))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(((CameraPreview)localObject2).a);
        localObject1 = new FrameLayout.LayoutParams(-1, ((DisplayMetrics)localObject3).heightPixels);
        ((FrameLayout.LayoutParams)localObject1).gravity = 51;
        this.jdField_B_of_type_Boolean = true;
        break;
      }
      label928:
      if (this.aw) {
        break label346;
      }
      aa();
      this.aw = true;
      break label346;
      label947:
      i1 = 0;
      break label449;
      label952:
      i1 = 4;
      break label481;
      label957:
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(4);
      c(0, false);
      if (!this.jdField_m_of_type_Boolean) {
        break label487;
      }
      BabyQHandler.a(this.jdField_f_of_type_AndroidViewView.getContext(), this.jdField_f_of_type_AndroidViewView);
      this.jdField_m_of_type_Boolean = false;
      break label487;
      label1000:
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(4);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(4);
      break label502;
      label1019:
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(4);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(4);
      break label502;
      label1038:
      this.jdField_C_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(4);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(4);
      ((FrameLayout.LayoutParams)localObject1).height = ((DisplayMetrics)localObject3).heightPixels;
      ((FrameLayout.LayoutParams)localObject1).width = ((DisplayMetrics)localObject3).widthPixels;
      break label517;
      label1080:
      this.jdField_g_of_type_AndroidWidgetButton.clearAnimation();
      this.jdField_g_of_type_AndroidWidgetButton.setVisibility(8);
      break label609;
      label1099:
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean = false;
      break label630;
      label1110:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131438672));
      continue;
      label1130:
      if ((this.jdField_r_of_type_Int == 10007) && (!this.aH) && (this.aI)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131438676));
      } else if ((this.jdField_r_of_type_Int == 10008) && (!this.aH) && (this.aI)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131438676));
      } else {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131438675));
      }
    }
  }
  
  boolean b()
  {
    return false;
  }
  
  public int c()
  {
    return this.jdField_o_of_type_Int;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void c(int paramInt)
  {
    as();
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "CaptureProcessObserver.onCompleted, file path = " + paramString);
    }
    a(paramString, false);
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "ptvRevert(): sendVideo:" + paramBoolean + ",mIsVideoMode: " + this.jdField_o_of_type_Boolean + ", mPtvMode: " + false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.k();
      if (this.jdField_o_of_type_Boolean) {}
    }
    else
    {
      return;
    }
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface.y();
    }
    if (paramBoolean)
    {
      if (RichmediaClient.a().a().a(this.jdField_d_of_type_JavaLangString) != null) {
        break label297;
      }
      LogTag.a(this.jdField_d_of_type_JavaLangString, "sendShortVideo", "[peak] old procedure");
      getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
      float f1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
      int i3 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a();
      int i2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
      f(i2);
      int i1 = i2;
      if (i2 <= 0) {
        i1 = this.jdField_V_of_type_Int;
      }
      FlowCameraMqqAction.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr, f1, false, this.jdField_a_of_type_Double, this.jdField_b_of_type_Double, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface, false, i3, i1, this.jdField_m_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_i_of_type_Boolean, this.jdField_h_of_type_JavaLangString, this.jdField_O_of_type_Boolean, this.jdField_y_of_type_Int, this.jdField_z_of_type_Int, this.jdField_j_of_type_JavaLangString);
      if (VideoEnvironment.d())
      {
        View localView = a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131362087);
        if (localView != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView(localView);
        }
      }
    }
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      d(paramBoolean);
      this.jdField_o_of_type_Boolean = false;
      return;
      label297:
      if (VideoEnvironment.d())
      {
        setResult(1001);
        finish();
      }
      LogTag.a(this.jdField_d_of_type_JavaLangString, "sendShortVideo", "[peak] preupload procedure");
      break;
    }
  }
  
  public boolean c()
  {
    this.jdField_r_of_type_Int = getIntent().getIntExtra("edit_video_type", 0);
    return (this.jdField_r_of_type_Int != 10000) && (this.jdField_r_of_type_Int != 10003) && (this.jdField_r_of_type_Int != 10004) && (this.jdField_r_of_type_Int != 10010) && (this.jdField_r_of_type_Int != 10008) && (this.jdField_r_of_type_Int != 10007);
  }
  
  public void c_(String paramString)
  {
    this.jdField_r_of_type_JavaLangString = paramString;
  }
  
  public int d()
  {
    return 0;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity.photo", 2, "onShootShortVideo");
    }
    int i3;
    int i2;
    int i1;
    Object localObject;
    if (this.aE)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString))
      {
        QLog.d("PTV.NewFlowCameraActivity.photo", 2, "onShootShortVideo error. rmStateMgr.mVideoFileDir is empty.");
        return;
      }
      if (!new File(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString).exists())
      {
        QLog.d("PTV.NewFlowCameraActivity.photo", 2, "onShootShortVideo error. rmStateMgr.mVideoFileDir is not exit. rmStateMgr.mVideoFileDir = " + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
        return;
      }
      this.jdField_v_of_type_JavaLangString = (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString + File.separatorChar + "video-" + System.currentTimeMillis() + ".mp4");
      int i4 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_e_of_type_Int;
      i3 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_f_of_type_Int;
      i2 = i4;
      i1 = i3;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_f_of_type_Int > GloableValue.jdField_c_of_type_Int)
      {
        float f1 = 1.0F * GloableValue.jdField_c_of_type_Int / this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_f_of_type_Int;
        i1 = (int)(i4 * f1);
        i2 = (int)(f1 * i3);
        localObject = new RMVideoClipSpec();
        ((RMVideoClipSpec)localObject).jdField_a_of_type_Int = 0;
        ((RMVideoClipSpec)localObject).jdField_b_of_type_Int = 0;
        ((RMVideoClipSpec)localObject).jdField_c_of_type_Int = i1;
        ((RMVideoClipSpec)localObject).jdField_d_of_type_Int = i2;
        ((RMVideoClipSpec)localObject).jdField_e_of_type_Int = i1;
        ((RMVideoClipSpec)localObject).jdField_f_of_type_Int = i2;
        a((RMVideoClipSpec)localObject);
        i2 = ((RMVideoClipSpec)localObject).jdField_c_of_type_Int;
        i1 = ((RMVideoClipSpec)localObject).jdField_d_of_type_Int;
      }
      i3 = CameraFilterGLView.SVRecordSessionParam.a(this.jdField_o_of_type_Int);
      if (this.jdField_r_of_type_Int == 10002)
      {
        RMVideoStateMgr.a().a(new EncodeConfig(this.jdField_v_of_type_JavaLangString, i2, i1, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_Int * 1000, 1, false, i3));
        RMVideoStateMgr.a().a(this);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.e();
      StoryReportor.a("aio_shoot", "clk_shoot", 0, 0, new String[0]);
      if (this.aG)
      {
        GestureRecognitionUtils.a(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.g();
        QLog.d("GestureTestUse", 2, "you start video record result");
      }
      localObject = null;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a();
      }
      if (localObject == null) {
        break label562;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("isTemplateSelected", String.valueOf(true));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.b();
      }
      if ((this.jdField_r_of_type_Int == 10002) && (!TextUtils.equals(this.jdField_a_of_type_AndroidWidgetTextView.getText().toString().trim(), "点击拍照，长按录像"))) {
        StoryReportor.a("video_shoot", "press_wording", 0, 0, new String[0]);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new xrw(this), 100L);
      return;
      RMVideoStateMgr.a().a(new EncodeConfig(this.jdField_v_of_type_JavaLangString, i2, i1, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_Int * 1000, CodecParam.jdField_B_of_type_Int, false, i3));
      break;
      label562:
      if ((this.ad) && (this.ae) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder == null)) {
        ao();
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("isTemplateSelected", String.valueOf(false));
    }
  }
  
  public void d(int paramInt) {}
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("PTV.NewFlowCameraActivity", 2, "showProgressDialog " + paramString);
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidAppProgressDialog == null) {
          continue;
        }
        P();
        localTextView = (TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131363399);
        if (!StringUtil.a(paramString)) {
          continue;
        }
        localTextView.setText(2131434314);
      }
      catch (Throwable paramString)
      {
        TextView localTextView;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e("PTV.NewFlowCameraActivity", 2, "showProgressDialog", paramString);
        return;
        localTextView.setText(paramString);
        continue;
      }
      if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
        return;
      }
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      return;
      this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this, 2131624516);
      this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(false);
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130969180);
    }
  }
  
  void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "exitVideoMode(), mPtvMode = false, clearCache = " + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
    {
      if (paramBoolean)
      {
        a(103);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)
        {
          int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getSegmentCount();
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(0, i1, true);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr.a();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.jdField_b_of_type_Boolean)) {}
    }
  }
  
  boolean d()
  {
    String str = StorageManager.a().jdField_b_of_type_JavaLangString;
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    long l1 = StorageManager.a(str);
    if (l1 <= StorageManager.jdField_a_of_type_Long)
    {
      SLog.e("PTV.NewFlowCameraActivity", "checkDiskSpaceIsOK,freeSpace <= FREESPACE_LIMIT_EXIT freeSpace=" + l1 + " StorageManager.FREESPACE_LIMIT_EXIT=" + StorageManager.jdField_a_of_type_Long + " 手机剩余存储空间不足");
      return false;
    }
    SLog.c("PTV.NewFlowCameraActivity", "checkDiskSpaceIsOK. freeSpace=" + l1 + " StorageManager.FREESPACE_LIMIT_EXIT=" + StorageManager.jdField_a_of_type_Long);
    return true;
  }
  
  public void e()
  {
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_AndroidGraphicsBitmap;
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a();
    }
    if (localBitmap1 != null) {
      this.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
    }
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_f_of_type_AndroidWidgetImageView.setAlpha(0.2F);
  }
  
  public void e(int paramInt)
  {
    int i1;
    int i2;
    try
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
      i3 = i1;
      if (i1 <= 0) {
        i3 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getRemainedRecordFrames(0);
      }
      if (i3 > 0) {
        this.jdField_V_of_type_Int = i3;
      }
      str = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString;
      i4 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_e_of_type_Int;
      i5 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_f_of_type_Int;
      localObject2 = "";
      bool2 = false;
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr.a();
      localObject1 = localObject2;
      bool1 = bool2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        bool1 = bool2;
        if (((RMVideoThumbGenMgr.ThumbGenItem)localObject3).jdField_c_of_type_JavaLangString != null)
        {
          localObject1 = localObject2;
          bool1 = bool2;
          if (((RMVideoThumbGenMgr.ThumbGenItem)localObject3).a.get() == 3)
          {
            bool1 = true;
            localObject1 = ((RMVideoThumbGenMgr.ThumbGenItem)localObject3).jdField_c_of_type_JavaLangString;
          }
        }
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!FileUtils.b((String)localObject1)) && (QLog.isColorLevel())) {
        QLog.e("PTV.NewFlowCameraActivity", 2, "intentToEditVideoActivity thumb file null!");
      }
      localObject2 = new Bundle();
      ((Bundle)localObject2).putLong("startEditVideoTime", SystemClock.uptimeMillis());
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null) {
        ((Bundle)localObject2).putString("mCurrentTemplatePath", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.jdField_a_of_type_JavaLangString);
      }
      ((Bundle)localObject2).putString("story_default_label", getIntent().getStringExtra("story_default_label"));
      ((Bundle)localObject2).putLong("story_topic_id", getIntent().getLongExtra("story_topic_id", 0L));
      ((Bundle)localObject2).putInt("entrance_type", a());
      long l1 = super.getIntent().getLongExtra("troop_uin", 0L);
      if (l1 != 0L) {
        ((Bundle)localObject2).putLong("troop_uin", l1);
      }
      if (this.jdField_k_of_type_Boolean)
      {
        i1 = (int)Math.ceil(paramInt * 1.0F / 10000.0F);
        if (i1 < 1)
        {
          SLog.e("PTV.NewFlowCameraActivity", "intentToEditVideoActivityFromStory error. expectFragmentCount < 1");
          return;
        }
        if (i1 > 1) {
          StoryReportor.a("video_shoot", "series_shoot", 0, 0, new String[0]);
        }
        SLog.b("PTV.NewFlowCameraActivity", "intentToEditVideoActivityFromStory. expectFragmentCount = %d.", Integer.valueOf(i1));
        ((Bundle)localObject2).putInt("expect_fragment_count", i1);
      }
      i2 = 4374893;
      if (a() != 16) {
        break label911;
      }
      bool2 = true;
    }
    catch (Exception localException)
    {
      int i3;
      String str;
      int i4;
      int i5;
      Object localObject2;
      boolean bool2;
      Object localObject3;
      Object localObject1;
      boolean bool1;
      boolean bool3;
      boolean bool4;
      while (QLog.isColorLevel())
      {
        QLog.d("PTV.NewFlowCameraActivity", 2, "intentToEditVideoActivity exception:" + localException);
        return;
        label911:
        bool2 = false;
        continue;
        bool3 = false;
      }
      return;
    }
    if (a() == 5)
    {
      bool3 = true;
      bool4 = super.getIntent().getBooleanExtra("ignorePersonalPublish", false);
      SLog.a("PTV.NewFlowCameraActivity", "isHotTopic:%b. isDiscover:%b. ignorePersonalPublish:%b", Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4));
      if ((bool2) || (bool3) || (bool4)) {
        break label924;
      }
      if (!this.jdField_k_of_type_Boolean) {
        break label931;
      }
      i1 = i2;
      if (paramInt < 11000L) {
        break label931;
      }
    }
    for (;;)
    {
      i2 = i1;
      if (this.jdField_s_of_type_Int == 102)
      {
        localObject3 = super.getIntent();
        int i6 = ((Intent)localObject3).getIntExtra("shareGroupType", 0);
        ((Bundle)localObject2).putInt("shareGroupType", i6);
        ((Bundle)localObject2).putString("shareGroupId", ((Intent)localObject3).getStringExtra("shareGroupId"));
        ((Bundle)localObject2).putString("shareGroupName", ((Intent)localObject3).getStringExtra("shareGroupName"));
        ((Bundle)localObject2).putLong("groupUin", ((Intent)localObject3).getLongExtra("groupUin", -1L));
        ((Bundle)localObject2).putInt("add_video_source", ((Intent)localObject3).getIntExtra("add_video_source", 0));
        i1 |= 0x200000;
        i2 = i1;
        if (i6 == 1) {
          i2 = i1 & 0xFFFDFFFF;
        }
      }
      ((Bundle)localObject2).putBoolean("ignorePersonalPublish", bool4);
      localObject1 = new EditVideoParams(1, i2, new EditRecordVideoSource(str, i3, paramInt, FlowCameraConstant.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a(), i4, i5, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(), (String)localObject1, bool1), (Bundle)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "EditVideoParams params:" + ((EditVideoParams)localObject1).toString() + ", RMVideoClipSpec:" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.toString());
      }
      localObject2 = new Intent(this, EditVideoActivity.class);
      ((Intent)localObject2).putExtra(EditVideoParams.class.getName(), (Parcelable)localObject1);
      ((Intent)localObject2).putExtra("op_department", "grp_story");
      paramInt = getIntent().getIntExtra("entrance_type", 99);
      if (paramInt == 15) {
        ((Intent)localObject2).putExtra("entrance_type", paramInt);
      }
      ((Intent)localObject2).putExtra("op_type", "video_edit");
      ((Intent)localObject2).putExtra("stop_record_time", System.currentTimeMillis());
      startActivityForResult((Intent)localObject2, 10002);
      overridePendingTransition(2131034128, 2131034139);
      this.ax = false;
      this.ay = false;
      this.az = true;
      return;
      label924:
      i2 = 4358509;
      break;
      label931:
      i1 = i2 & 0xFFFF7FFF;
    }
  }
  
  void e(boolean paramBoolean)
  {
    int[] arrayOfInt = new int[6];
    if ((this.jdField_h_of_type_Int == -1) || (this.jdField_i_of_type_Int == -1)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("PTV.NewFlowCameraActivity", 2, "[changeVideoPreviewMapSize]rmStateMgr " + null);
    return;
    RMVideoClipSpec localRMVideoClipSpec = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
    float f1 = this.jdField_h_of_type_Int * 1.0F / this.jdField_i_of_type_Int;
    if (this.jdField_e_of_type_Float >= f1) {}
    for (boolean bool = false;; bool = true)
    {
      if (paramBoolean) {
        a(this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, bool, arrayOfInt);
      }
      try
      {
        a(arrayOfInt[2], arrayOfInt[3], arrayOfInt);
        label131:
        if (!paramBoolean) {
          a(this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, bool, arrayOfInt);
        }
        localRMVideoClipSpec.jdField_c_of_type_Int = arrayOfInt[0];
        localRMVideoClipSpec.jdField_d_of_type_Int = arrayOfInt[1];
        localRMVideoClipSpec.jdField_e_of_type_Int = this.jdField_h_of_type_Int;
        localRMVideoClipSpec.jdField_f_of_type_Int = this.jdField_i_of_type_Int;
        a(localRMVideoClipSpec);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(localRMVideoClipSpec, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_d_of_type_Boolean);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        break label131;
      }
    }
  }
  
  public boolean e()
  {
    if (!this.jdField_g_of_type_Boolean) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    return true;
  }
  
  public void f()
  {
    int i3 = 0;
    NewFlowCameraReporter.a("shootPhoto");
    al();
    this.jdField_s_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a();; str = null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a().hasGesture())) {}
      for (boolean bool = true;; bool = false)
      {
        NewFlowCameraReporter.a(str, this.jdField_x_of_type_JavaLangString, bool);
        this.jdField_e_of_type_JavaLangString = getIntent().getExtras().getString("qcamera_photo_filepath");
        if (QLog.isColorLevel()) {
          QLog.d(".photo", 2, "shot photo path=" + this.jdField_e_of_type_JavaLangString);
        }
        int i1;
        if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
        {
          if (StringUtil.a(str)) {
            break label348;
          }
          i1 = 1;
          if (FlowCameraConstant.jdField_a_of_type_Int != 2) {
            break label353;
          }
          if ((!this.jdField_g_of_type_Boolean) || (i1 == 0)) {
            break label433;
          }
          i1 = 1;
        }
        for (;;)
        {
          label170:
          int i2 = i1;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager != null)
          {
            i2 = i1;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.a() != null)
            {
              i2 = i1;
              if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.a().a()) {
                i2 = 1;
              }
            }
          }
          if ((i2 != 0) || (!CameraUtils.a()) || (this.ar))
          {
            i1 = i3;
            if (this.aq)
            {
              i1 = 1500;
              if (FlowCameraConstant.jdField_a_of_type_Int == 1) {
                j(true);
              }
            }
            else
            {
              label250:
              new Handler().postDelayed(new xrx(this), i1);
              this.jdField_p_of_type_Boolean = true;
            }
          }
          for (;;)
          {
            HashMap localHashMap = new HashMap();
            localHashMap.put("cameraType", String.valueOf(FlowCameraConstant.jdField_a_of_type_Int));
            localHashMap.put("isTemplateMode", String.valueOf(this.jdField_g_of_type_Boolean));
            localHashMap.put("templateId", str);
            FlowCameraMqqAction.a(getIntent().getIntExtra("edit_video_type", -1), "", "", localHashMap);
            return;
            label348:
            i1 = 0;
            break;
            label353:
            i1 = 1;
            break label170;
            this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.c(true);
            break label250;
            if (QLog.isColorLevel()) {
              QLog.d(".photo", 2, "shot photo with custom camera");
            }
            if ((this.aq) && (!this.aA))
            {
              NewFlowCameraReporter.b();
              this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(null, null, new xry(this));
            }
            else
            {
              U();
              V();
            }
          }
          label433:
          i1 = 0;
        }
      }
    }
  }
  
  public void f(boolean paramBoolean) {}
  
  public void finish()
  {
    super.finish();
    if ((this.S == 1) && (this.ag)) {
      overridePendingTransition(0, 2131034133);
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "CaptureProcessObserver.onDataReady");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.b();
    }
  }
  
  public void g(boolean paramBoolean) {}
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.c();
    }
  }
  
  void h(boolean paramBoolean)
  {
    runOnUiThread(new xsd(this, paramBoolean));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "handleMessage,msg.what = " + paramMessage.what);
    }
    boolean bool1 = bool2;
    switch (paramMessage.what)
    {
    case 1002: 
    case 1004: 
    case 1005: 
    case 1006: 
    case 1007: 
    default: 
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        P();
        QQToast.a(this, 1, 2131435303, 0).a();
        i(true);
        return true;
        bool1 = bool2;
      } while (!a(this.jdField_q_of_type_JavaLangString));
      au();
      return true;
      au();
      return true;
      if (this.jdField_a_of_type_AndroidWidgetSeekBar != null) {
        this.jdField_a_of_type_AndroidWidgetSeekBar.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
      }
      bool1 = bool2;
    } while (this.jdField_e_of_type_AndroidWidgetTextView == null);
    this.jdField_e_of_type_AndroidWidgetTextView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
    return true;
  }
  
  public void i()
  {
    ArrayList localArrayList;
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null)
    {
      new ArrayList();
      if (this.jdField_r_of_type_Int != 10003) {
        break label130;
      }
      localArrayList = PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).c();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("onPtvTemplateUpdated: ");
        if (localArrayList != null) {
          break label161;
        }
      }
    }
    label130:
    label161:
    for (int i1 = 0;; i1 = localArrayList.size())
    {
      QLog.d("PtvTemplateManager", 2, i1);
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(null);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.getCount() == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a(localArrayList);
          runOnUiThread(new xpy(this));
        }
      }
      return;
      if (this.aG) {}
      for (i1 = 2;; i1 = 1)
      {
        localArrayList = PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(true, false, i1);
        break;
      }
    }
  }
  
  public void i(boolean paramBoolean)
  {
    setResult(1001);
    finish();
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mEncodeRef.getAndSet(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.a.getAndSet(null);
    }
  }
  
  public void k()
  {
    jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec = null;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, this.jdField_B_of_type_Boolean, false, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec);
    if (localObject != null) {
      ThreadManager.post(new xqr(this, (Bitmap)localObject), 8, null, false);
    }
    ae();
    localObject = getIntent();
    ((Intent)localObject).putExtra("flow_back", 0);
    setResult(1001, (Intent)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper.b();
    super.onBackPressed();
  }
  
  void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.c();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.e();
    }
  }
  
  void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double == 0.0D)
    {
      k();
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this, false);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a("放弃录制，当前视频将会被删除");
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a("放弃", 3);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d("取消");
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new xqt(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public void n()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(0);
    localStringBuilder.append("秒");
    this.jdField_g_of_type_AndroidWidgetTextView.setText(localStringBuilder);
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_h_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
  }
  
  public void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "initUI_RecordState mIsVideoMode=" + this.jdField_o_of_type_Boolean);
    }
    TextView localTextView;
    if (this.jdField_o_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_f_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.getVisibility() == 0) {
        VideoAnimation.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView, 0.0F, 8.0F, 0.0F, 0.0F, 300, 1.0F, 0.0F);
      }
      if ((this.jdField_f_of_type_AndroidWidgetButton != null) && (this.jdField_f_of_type_AndroidWidgetButton.getVisibility() == 0)) {
        VideoAnimation.a(this.jdField_f_of_type_AndroidWidgetButton, 0.0F, 8.0F, 0.0F, 0.0F, 300, 1.0F, 0.0F);
      }
      if (this.jdField_r_of_type_Int == 10002) {
        VideoAnimation.a(this.jdField_a_of_type_AndroidWidgetButton, 0.0F, 8.0F, 0.0F, 0.0F, 300, 1.0F, 0.0F);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Int = 0;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double <= 0.0D) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_g_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_f_of_type_Boolean = true;
      }
      if (this.ax) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_f_of_type_Boolean = true;
      }
      if ((this.jdField_r_of_type_Int != 10002) || (this.aE))
      {
        if (this.jdField_b_of_type_AndroidWidgetButton.isEnabled()) {
          this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
        }
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
      }
      if (this.jdField_h_of_type_AndroidWidgetButton.isEnabled()) {
        this.jdField_h_of_type_AndroidWidgetButton.setEnabled(false);
      }
      this.jdField_h_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_i_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwAutoSegmentMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      localTextView = this.jdField_g_of_type_AndroidWidgetTextView;
      if (!this.jdField_K_of_type_Boolean) {
        break label370;
      }
    }
    label370:
    for (int i1 = 8;; i1 = 0)
    {
      localTextView.setVisibility(i1);
      if ((this.aO) && (this.jdField_a_of_type_AndroidWidgetButton.isEnabled()))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
      if (this.jdField_K_of_type_Boolean) {
        LpReportInfo_pf00064.allReport(627, 2);
      }
      return;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1011)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
      }
      if (paramInt2 == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PTV.NewFlowCameraActivity", 2, "Press the cancel button state=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) {
          FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
        }
        a("608", "2", "0", true);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4))
        {
          this.ax = true;
          aj();
          this.ay = true;
          this.jdField_A_of_type_Boolean = true;
        }
      }
    }
    boolean bool1;
    boolean bool2;
    Object localObject1;
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface.a(this, paramInt1, paramInt2, paramIntent);
      }
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        this.jdField_m_of_type_JavaLangString = paramIntent.getStringExtra("key_content");
        if (this.jdField_m_of_type_JavaLangString == null) {
          this.jdField_m_of_type_JavaLangString = "";
        }
        this.jdField_d_of_type_Int = paramIntent.getIntExtra("key_priv", 1);
        this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)paramIntent.getSerializableExtra("key_priv_uin_list"));
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        this.jdField_O_of_type_Boolean = paramIntent.getBooleanExtra("key_topic_sync_qzone", this.jdField_O_of_type_Boolean);
        this.jdField_y_of_type_Int = paramIntent.getIntExtra("key_font_id", -1);
        this.jdField_z_of_type_Int = paramIntent.getIntExtra("key_font_format_type", 0);
        this.jdField_j_of_type_JavaLangString = paramIntent.getStringExtra("key_font_url");
        this.jdField_A_of_type_Int = paramIntent.getIntExtra("key_super_font_id", -1);
        this.jdField_k_of_type_JavaLangString = paramIntent.getStringExtra("key_super_font_info");
        bool1 = paramIntent.getBooleanExtra("key_generate_gif", false);
        bool2 = paramIntent.getBooleanExtra("key_timer_delete", false);
        localObject1 = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
        if (localObject1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("PTV.NewFlowCameraActivity", 2, "publishParam : " + ((PublishParam)localObject1).toString());
          }
          getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
          f1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
          i3 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a();
          i2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
          f(i2);
          i1 = i2;
          if (i2 <= 0)
          {
            i1 = i2;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
              i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getRemainedRecordFrames(0);
            }
          }
          i2 = i1;
          if (i1 <= 0) {
            i2 = ((PublishParam)localObject1).jdField_g_of_type_Int;
          }
          i1 = i2;
          if (i2 <= 0) {
            i1 = this.jdField_V_of_type_Int;
          }
          if (QLog.isColorLevel()) {
            QLog.i("PTV.NewFlowCameraActivity", 2, "start sendShortVideoWithMood --- ");
          }
          i2 = getIntent().getIntExtra("entry_source", 0);
          FlowCameraMqqAction.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr, f1, false, this.jdField_a_of_type_Double, this.jdField_b_of_type_Double, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface, false, i3, i1, this.jdField_m_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_i_of_type_Boolean, this.jdField_h_of_type_JavaLangString, this.jdField_O_of_type_Boolean, ((PublishParam)localObject1).jdField_c_of_type_JavaLangString, ((PublishParam)localObject1).jdField_d_of_type_JavaLangString, this.jdField_y_of_type_Int, this.jdField_z_of_type_Int, this.jdField_j_of_type_JavaLangString, ((PublishParam)localObject1).jdField_b_of_type_JavaLangString, ((PublishParam)localObject1).jdField_a_of_type_Long, ((PublishParam)localObject1).jdField_f_of_type_Int, bool1, i2, bool2, this.jdField_A_of_type_Int, this.jdField_k_of_type_JavaLangString);
          continue;
          if (paramInt1 == 2)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PTV.NewFlowCameraActivity", 2, "onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
            }
            if (paramIntent != null)
            {
              localObject1 = paramIntent.getExtras();
              if (((Bundle)localObject1).containsKey("permission_code")) {
                this.jdField_d_of_type_Int = ((Bundle)localObject1).getInt("permission_code");
              }
              if (((Bundle)localObject1).containsKey("uin_list"))
              {
                if (this.jdField_a_of_type_JavaUtilArrayList == null) {
                  this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
                }
                this.jdField_a_of_type_JavaUtilArrayList.clear();
                localObject2 = ((Bundle)localObject1).getStringArrayList("uin_list");
                if (localObject2 != null) {
                  this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject2);
                }
              }
              if (a(this.jdField_d_of_type_Int))
              {
                this.jdField_c_of_type_JavaLangString = ((Bundle)localObject1).getString("key_setting_raw_json");
                this.jdField_b_of_type_JavaLangString = ((Bundle)localObject1).getString("key_selected_tag");
              }
              R();
            }
          }
          else if (paramInt1 == 1009)
          {
            this.aS = false;
            this.jdField_c_of_type_Boolean = false;
            if (this.jdField_h_of_type_AndroidViewView != null) {
              this.jdField_h_of_type_AndroidViewView.setVisibility(8);
            }
            if (paramIntent != null)
            {
              localObject3 = paramIntent.getExtras();
              if (((Bundle)localObject3).containsKey("extra_key_bundle_priv_key"))
              {
                localObject1 = ((Bundle)localObject3).getBundle("extra_key_bundle_priv_key");
                if (localObject1 != null)
                {
                  this.jdField_d_of_type_Int = ((Bundle)localObject1).getInt("permission_code");
                  if (this.jdField_a_of_type_JavaUtilArrayList == null) {
                    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
                  }
                  this.jdField_a_of_type_JavaUtilArrayList.clear();
                  localObject2 = ((Bundle)localObject1).getStringArrayList("uin_list");
                  if (localObject2 != null) {
                    this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject2);
                  }
                  if (a(this.jdField_d_of_type_Int))
                  {
                    this.jdField_c_of_type_JavaLangString = ((Bundle)localObject1).getString("key_setting_raw_json");
                    this.jdField_b_of_type_JavaLangString = ((Bundle)localObject1).getString("key_selected_tag");
                  }
                  R();
                }
              }
              if (((Bundle)localObject3).containsKey("extraIsTopicSyncQzone"))
              {
                bool1 = ((Bundle)localObject3).getBoolean("extraIsTopicSyncQzone");
                this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool1);
              }
              if (((Bundle)localObject3).containsKey("contentIntentKey"))
              {
                localObject2 = ((Bundle)localObject3).getString("contentIntentKey");
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = "";
                }
                this.jdField_m_of_type_JavaLangString = ((String)localObject1);
              }
              if (((Bundle)localObject3).containsKey("contentIntentKeyForVideoEditWithEmo"))
              {
                localObject1 = ((Bundle)localObject3).getString("contentIntentKeyForVideoEditWithEmo");
                this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setText((CharSequence)localObject1);
              }
              this.jdField_y_of_type_Int = ((Bundle)localObject3).getInt("extra_key_font_id", -1);
              this.jdField_z_of_type_Int = ((Bundle)localObject3).getInt("extra_key_font_format_type");
              this.jdField_j_of_type_JavaLangString = ((Bundle)localObject3).getString("extra_key_font_url");
              this.jdField_A_of_type_Int = ((Bundle)localObject3).getInt("extra_key_super_font_id", -1);
              this.jdField_k_of_type_JavaLangString = ((Bundle)localObject3).getString("extra_key_super_font_info");
              this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(1009);
            }
          }
          else if ((paramInt1 == 1010) && (paramInt2 == -1))
          {
            ToastUtil.a().a("开通成功");
            this.ap = true;
          }
          else
          {
            if (paramInt1 != 10000) {
              break label2332;
            }
            if (QLog.isColorLevel()) {
              QLog.d("PTV.NewFlowCameraActivity", 2, "aio onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
            }
            if (paramInt2 != -1) {
              break label2199;
            }
            if (paramIntent != null)
            {
              localObject1 = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
              if (localObject1 != null)
              {
                this.aN = true;
                if (((PublishParam)localObject1).jdField_j_of_type_Int != 1) {
                  break;
                }
                localObject2 = ((PublishParam)localObject1).jdField_c_of_type_JavaLangString;
                if (QLog.isColorLevel())
                {
                  QLog.d("PTV.NewFlowCameraActivity", 2, "hwEncodeVideo videoMergeThumbPath =" + (String)localObject2);
                  QLog.d("PTV.NewFlowCameraActivity", 2, "publishParam =" + ((PublishParam)localObject1).toString());
                }
                getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
                a((PublishParam)localObject1);
                label1400:
                if ((this.jdField_s_of_type_Int != 14) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {
                  break label2191;
                }
                localObject1 = AIOUtils.a(new Intent(this, SplashActivity.class), new int[] { 2 });
                ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
                ((Intent)localObject1).putExtra("uintype", 1);
                startActivity((Intent)localObject1);
              }
            }
          }
        }
      }
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString;
    localObject2 = (String)localObject2 + File.separator + "configure.txt";
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(((PublishParam)localObject1).jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "configure file content:" + ((StringBuilder)localObject3).toString());
    }
    FileUtils.a((String)localObject2, ((StringBuilder)localObject3).toString());
    getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
    float f1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
    int i3 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a();
    int i2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
    int i1 = i2;
    if (i2 <= 0)
    {
      i1 = i2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
        i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getRemainedRecordFrames(0);
      }
    }
    f(i1);
    if (i1 <= 0) {
      i1 = this.jdField_V_of_type_Int;
    }
    label2056:
    label3336:
    for (;;)
    {
      ai();
      this.jdField_b_of_type_Boolean = false;
      if (e()) {
        FlowCameraMqqAction.a("", "0X80076DF", "", "", "", "");
      }
      if (((PublishParam)localObject1).jdField_e_of_type_Int == 0)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put("result_Event", String.valueOf(0));
        m(true);
      }
      for (;;)
      {
        localObject2 = RichmediaClient.a().a().a(this.jdField_d_of_type_JavaLangString);
        if (localObject2 == null) {
          break label2056;
        }
        if (((PublishParam)localObject1).jdField_e_of_type_Int != 0) {
          break label1906;
        }
        LogTag.a(this.jdField_d_of_type_JavaLangString, "SendBtn Click ", ",(int)rmStateMgr.mTotalTime = " + (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double + ",frames = " + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex() + " VideoABTest:" + SystemClock.uptimeMillis());
        ((CompoundProcessor)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex(), this.jdField_f_of_type_Long, this.jdField_C_of_type_Int, false);
        setResult(1001);
        finish();
        break;
        this.jdField_a_of_type_JavaUtilHashMap.put("result_Event", String.valueOf(3));
        m(false);
      }
      label1906:
      ((CompoundProcessor)localObject2).a(111);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
      double d1 = this.jdField_a_of_type_Double;
      double d2 = this.jdField_b_of_type_Double;
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface;
      String str1 = this.jdField_m_of_type_JavaLangString;
      i2 = this.jdField_d_of_type_Int;
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      bool2 = this.jdField_i_of_type_Boolean;
      String str2 = this.jdField_h_of_type_JavaLangString;
      boolean bool3 = this.jdField_O_of_type_Boolean;
      String str3 = ((PublishParam)localObject1).jdField_c_of_type_JavaLangString;
      String str4 = ((PublishParam)localObject1).jdField_d_of_type_JavaLangString;
      int i4 = ((PublishParam)localObject1).jdField_f_of_type_Int;
      if (((PublishParam)localObject1).jdField_i_of_type_Int == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        FlowCameraMqqAction.a(this, (RMVideoStateMgr)localObject2, f1, false, d1, d2, (FlowComponentInterface)localObject3, false, i3, i1, str1, i2, localArrayList, bool2, str2, bool3, str3, str4, i4, true, bool1);
        break;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
      d1 = this.jdField_a_of_type_Double;
      d2 = this.jdField_b_of_type_Double;
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface;
      str1 = this.jdField_m_of_type_JavaLangString;
      i2 = this.jdField_d_of_type_Int;
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      bool2 = this.jdField_i_of_type_Boolean;
      str2 = this.jdField_h_of_type_JavaLangString;
      bool3 = this.jdField_O_of_type_Boolean;
      str3 = ((PublishParam)localObject1).jdField_c_of_type_JavaLangString;
      str4 = ((PublishParam)localObject1).jdField_d_of_type_JavaLangString;
      i4 = ((PublishParam)localObject1).jdField_f_of_type_Int;
      if (((PublishParam)localObject1).jdField_i_of_type_Int == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        FlowCameraMqqAction.a(this, (RMVideoStateMgr)localObject2, f1, false, d1, d2, (FlowComponentInterface)localObject3, false, i3, i1, str1, i2, localArrayList, bool2, str2, bool3, str3, str4, i4, true, bool1);
        break label1400;
        label2191:
        break;
      }
      label2199:
      if (paramInt2 != 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("PTV.NewFlowCameraActivity", 2, "Press the cancel button state=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) {
        FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("result_Event", String.valueOf(2));
      m(false);
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 4)) {
        break;
      }
      this.ax = true;
      aj();
      this.ay = true;
      this.jdField_A_of_type_Boolean = true;
      break;
      label2332:
      if (paramInt1 == 10003)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "Bless onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
        }
        if (paramInt2 == -1)
        {
          if (paramIntent == null) {
            break;
          }
          localObject1 = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
          if (localObject1 == null) {
            break;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString;
          localObject2 = (String)localObject2 + File.separator + "configure.txt";
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(((PublishParam)localObject1).jdField_b_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d("PTV.NewFlowCameraActivity", 2, "configure file content:" + ((StringBuilder)localObject3).toString());
          }
          FileUtils.a((String)localObject2, ((StringBuilder)localObject3).toString());
          f1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
          i3 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a();
          i2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
          i1 = i2;
          if (i2 <= 0) {
            i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getRemainedRecordFrames(0);
          }
          f(i1);
          if (i1 > 0) {
            break label5462;
          }
          i1 = this.jdField_V_of_type_Int;
        }
      }
      label3219:
      label3878:
      label5453:
      label5456:
      label5459:
      label5462:
      for (;;)
      {
        ai();
        this.jdField_b_of_type_Boolean = false;
        localObject2 = new SessionInfo();
        ((SessionInfo)localObject2).jdField_a_of_type_JavaLangString = "0";
        ((SessionInfo)localObject2).jdField_a_of_type_Int = 0;
        getIntent().putExtra("PhotoConst.SEND_SESSION_INFO", (Parcelable)localObject2);
        getIntent().putExtra("param_entrance", 15);
        getIntent().putExtra("fake_id", ((PublishParam)localObject1).jdField_b_of_type_JavaLangString);
        FlowCameraMqqAction.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr, f1, true, this.jdField_a_of_type_Double, this.jdField_b_of_type_Double, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface, false, i3, i1, this.jdField_m_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_i_of_type_Boolean, this.jdField_h_of_type_JavaLangString, this.jdField_O_of_type_Boolean, ((PublishParam)localObject1).jdField_c_of_type_JavaLangString, ((PublishParam)localObject1).jdField_d_of_type_JavaLangString, ((PublishParam)localObject1).jdField_f_of_type_Int, true, false);
        break;
        if (paramInt2 != 0) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("PTV.NewFlowCameraActivity", 2, "Press the cancel button state=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("result_Event", String.valueOf(2));
        m(false);
        this.jdField_d_of_type_Long = System.currentTimeMillis();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 4) {
          break;
        }
        this.ax = true;
        aj();
        this.ay = true;
        break;
        if (paramInt1 == 1012)
        {
          if (paramInt2 == 0)
          {
            if (QLog.isColorLevel()) {
              QLog.i("PTV.NewFlowCameraActivity", 2, "restart from edit pic");
            }
            this.ax = true;
            H();
            this.ay = true;
            this.jdField_A_of_type_Boolean = true;
            break;
          }
          if ((paramInt2 != -1) || (paramIntent == null)) {
            break;
          }
          i1 = paramIntent.getIntExtra("forward_to_someplace_from_shoot_quick", 0);
          i2 = paramIntent.getIntExtra("forward_to_someplace_from_pre_guide", 0);
          if (i1 != 0) {
            break label5459;
          }
          i1 = i2;
        }
        for (;;)
        {
          if (i1 == 1002)
          {
            ay();
            this.jdField_b_of_type_Boolean = false;
            paramIntent.putExtra("open_leba_tab_fragment", true);
            setResult(-1, paramIntent);
            finish();
          }
          for (;;)
          {
            if (!paramIntent.getBooleanExtra("go_publish_activity", false)) {
              break label3219;
            }
            this.jdField_m_of_type_JavaLangString = paramIntent.getStringExtra("key_content");
            if (this.jdField_m_of_type_JavaLangString == null) {
              this.jdField_m_of_type_JavaLangString = "";
            }
            this.jdField_d_of_type_Int = paramIntent.getIntExtra("key_priv", 1);
            this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)paramIntent.getSerializableExtra("key_priv_uin_list"));
            if (this.jdField_a_of_type_JavaUtilArrayList == null) {
              this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            }
            this.jdField_O_of_type_Boolean = paramIntent.getBooleanExtra("key_topic_sync_qzone", this.jdField_O_of_type_Boolean);
            this.jdField_y_of_type_Int = paramIntent.getIntExtra("key_font_id", -1);
            this.jdField_z_of_type_Int = paramIntent.getIntExtra("key_font_format_type", 0);
            this.jdField_j_of_type_JavaLangString = paramIntent.getStringExtra("key_font_url");
            this.jdField_A_of_type_Int = paramIntent.getIntExtra("key_super_font_id", -1);
            this.jdField_k_of_type_JavaLangString = paramIntent.getStringExtra("key_super_font_info");
            localObject1 = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
            bool1 = paramIntent.getBooleanExtra("key_timer_delete", false);
            QLog.i("PTV.NewFlowCameraActivity", 2, "get mSetTimerDelete: " + bool1);
            QZoneHelper.a(this.jdField_m_of_type_JavaLangString, (ArrayList)localObject1, this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_y_of_type_Int, this.jdField_z_of_type_Int, this.jdField_j_of_type_JavaLangString, bool1, this.jdField_A_of_type_Int, this.jdField_k_of_type_JavaLangString);
            finish();
            break;
            if (i1 == 1003) {
              this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper.a(paramIntent, this.jdField_e_of_type_AndroidWidgetImageView);
            }
          }
          break;
          if ((paramInt1 == 10004) || (paramInt1 == 10010))
          {
            if (QLog.isColorLevel()) {
              QLog.d("PTV.NewFlowCameraActivity", 2, "quick shoot onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
            }
            if (paramInt2 == -1)
            {
              if (paramIntent == null) {
                break;
              }
              localObject1 = (SessionInfo)paramIntent.getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
              if (localObject1 != null) {
                getIntent().putExtra("PhotoConst.SEND_SESSION_INFO", (Parcelable)localObject1);
              }
              if (paramInt1 == 10010)
              {
                getIntent().putExtra("forward_source_from_pre_guide", true);
                localObject1 = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
                if (localObject1 == null) {
                  break;
                }
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString;
                localObject2 = (String)localObject2 + File.separator + "configure.txt";
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append(((PublishParam)localObject1).jdField_b_of_type_JavaLangString);
                if (QLog.isColorLevel()) {
                  QLog.d("PTV.NewFlowCameraActivity", 2, "configure file content:" + ((StringBuilder)localObject3).toString());
                }
                FileUtils.a((String)localObject2, ((StringBuilder)localObject3).toString());
                getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
                f1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
                i4 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a();
                i2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
                i1 = i2;
                if (i2 <= 0)
                {
                  i1 = i2;
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
                    i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getRemainedRecordFrames(0);
                  }
                }
                f(i1);
                if (i1 > 0) {
                  break label5456;
                }
                i1 = this.jdField_V_of_type_Int;
              }
            }
          }
          for (;;)
          {
            ai();
            this.jdField_b_of_type_Boolean = false;
            if (e()) {
              FlowCameraMqqAction.a("", "0X80076DF", "", "", "", "");
            }
            if (((PublishParam)localObject1).jdField_e_of_type_Int == 0)
            {
              this.jdField_a_of_type_JavaUtilHashMap.put("result_Event", String.valueOf(0));
              m(true);
            }
            for (;;)
            {
              i3 = paramIntent.getIntExtra("forward_to_someplace_from_shoot_quick", 0);
              i2 = i3;
              if (i3 == 0)
              {
                i2 = i3;
                if (paramInt1 == 10010) {
                  i2 = paramIntent.getIntExtra("forward_to_someplace_from_pre_guide", 0);
                }
              }
              if (i2 != 1002) {
                break label3878;
              }
              ay();
              localObject2 = paramIntent.getStringExtra("forward_source_to_qzone");
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                getIntent().putExtra("forward_source_to_qzone", (String)localObject2);
                a(paramIntent.getExtras(), (String)localObject2);
              }
              this.jdField_m_of_type_JavaLangString = paramIntent.getStringExtra("key_content");
              paramIntent.putExtra("open_leba_tab_fragment", true);
              setResult(-1, paramIntent);
              finish();
              this.jdField_i_of_type_Boolean = paramIntent.getBooleanExtra("forward_to_qzone_to_enable_edit", false);
              FlowCameraMqqAction.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr, f1, false, this.jdField_a_of_type_Double, this.jdField_b_of_type_Double, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface, false, i4, i1, this.jdField_m_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_i_of_type_Boolean, this.jdField_h_of_type_JavaLangString, this.jdField_O_of_type_Boolean, ((PublishParam)localObject1).jdField_c_of_type_JavaLangString, ((PublishParam)localObject1).jdField_d_of_type_JavaLangString, this.jdField_y_of_type_Int, this.jdField_z_of_type_Int, this.jdField_j_of_type_JavaLangString, ((PublishParam)localObject1).jdField_b_of_type_JavaLangString, ((PublishParam)localObject1).jdField_a_of_type_Long, ((PublishParam)localObject1).jdField_f_of_type_Int, false);
              break;
              getIntent().putExtra("forward_source_from_shoot_quick", true);
              break label3336;
              this.jdField_a_of_type_JavaUtilHashMap.put("result_Event", String.valueOf(3));
              m(false);
            }
            if (i2 == 1003)
            {
              this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper.a(paramIntent, this.jdField_e_of_type_AndroidWidgetImageView);
              break;
            }
            setResult(-1, paramIntent);
            finish();
            FlowCameraMqqAction.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr, f1, false, this.jdField_a_of_type_Double, this.jdField_b_of_type_Double, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface, false, i4, i1, this.jdField_m_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_i_of_type_Boolean, this.jdField_h_of_type_JavaLangString, this.jdField_O_of_type_Boolean, ((PublishParam)localObject1).jdField_c_of_type_JavaLangString, ((PublishParam)localObject1).jdField_d_of_type_JavaLangString, ((PublishParam)localObject1).jdField_f_of_type_Int, true, false);
            break;
            if (paramInt2 != 0) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.i("PTV.NewFlowCameraActivity", 2, "Press the cancel button state=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) {
              FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
            }
            this.jdField_a_of_type_JavaUtilHashMap.put("result_Event", String.valueOf(2));
            m(false);
            this.jdField_d_of_type_Long = System.currentTimeMillis();
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 4)) {
              break;
            }
            this.ax = true;
            aj();
            this.ay = true;
            this.jdField_A_of_type_Boolean = true;
            break;
            if ((paramInt1 == 10002) || (paramInt1 == 10006))
            {
              if (paramInt2 == -1)
              {
                this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper.a(paramIntent, this.jdField_e_of_type_AndroidWidgetImageView);
                break;
              }
              if (paramInt2 != 0) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.i("PTV.NewFlowCameraActivity", 2, "Press the cancel button state=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) {
                FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
              }
              a("608", "2", "0", true);
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 4)) {
                break;
              }
              this.ax = true;
              aj();
              this.ay = true;
              this.jdField_A_of_type_Boolean = true;
              break;
            }
            if (paramInt1 == 10012)
            {
              if (paramInt2 == -1)
              {
                TribeTakeVideoHelper.a(this, paramIntent, this.jdField_e_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr);
                break;
              }
              if (paramInt2 != 0) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.i("PTV.NewFlowCameraActivity", 2, "Press the cancel button state=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) {
                FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
              }
              a("608", "2", "0", true);
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 4)) {
                break;
              }
              this.ax = true;
              aj();
              this.ay = true;
              this.jdField_A_of_type_Boolean = true;
              break;
            }
            if (paramInt1 == 1014)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PTV.NewFlowCameraActivity", 2, "onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
              }
              if (paramInt2 == 0)
              {
                if (QLog.isColorLevel()) {
                  QLog.i("PTV.NewFlowCameraActivity", 2, "Press the cancel button state=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
                }
                if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) {
                  FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
                }
                a("608", "2", "0", true);
                if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 4)) {
                  break;
                }
                this.ax = true;
                aj();
                this.ay = true;
                this.jdField_A_of_type_Boolean = true;
                break;
              }
              if (paramInt2 != -1) {
                break;
              }
              QLog.i("PTV.NewFlowCameraActivity", 2, "REQ_PREVIEW_EDIT_GIF_ACTIVITY result ok");
              finish();
              break;
            }
            if (paramInt1 == 10007)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PTV.NewFlowCameraActivity", 2, "web onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
              }
              if (paramInt2 == -1)
              {
                if (paramIntent == null) {
                  break;
                }
                localObject1 = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
                if (localObject1 == null) {
                  break;
                }
                this.aN = true;
                if (((PublishParam)localObject1).jdField_j_of_type_Int == 1)
                {
                  localObject2 = ((PublishParam)localObject1).jdField_c_of_type_JavaLangString;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("PTV.NewFlowCameraActivity", 2, "hwEncodeVideo videoMergeThumbPath =" + (String)localObject2);
                    QLog.d("PTV.NewFlowCameraActivity", 2, "publishParam =" + ((PublishParam)localObject1).toString());
                  }
                  getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
                  localObject2 = new SessionInfo();
                  ((SessionInfo)localObject2).jdField_a_of_type_JavaLangString = "0";
                  ((SessionInfo)localObject2).jdField_a_of_type_Int = 0;
                  getIntent().putExtra("PhotoConst.SEND_SESSION_INFO", (Parcelable)localObject2);
                  getIntent().putExtra("param_entrance", 32);
                  getIntent().putExtra("fake_id", ((PublishParam)localObject1).jdField_b_of_type_JavaLangString);
                  a((PublishParam)localObject1);
                  break;
                }
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString;
                localObject2 = (String)localObject2 + File.separator + "configure.txt";
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append(((PublishParam)localObject1).jdField_b_of_type_JavaLangString);
                if (QLog.isColorLevel()) {
                  QLog.d("PTV.NewFlowCameraActivity", 2, "configure file content:" + ((StringBuilder)localObject3).toString());
                }
                FileUtils.a((String)localObject2, ((StringBuilder)localObject3).toString());
                f1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
                i3 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a();
                i2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
                i1 = i2;
                if (i2 <= 0) {
                  i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getRemainedRecordFrames(0);
                }
                f(i1);
                if (i1 > 0) {
                  break label5453;
                }
                i1 = this.jdField_V_of_type_Int;
              }
            }
            for (;;)
            {
              ai();
              this.jdField_b_of_type_Boolean = false;
              localObject2 = new SessionInfo();
              ((SessionInfo)localObject2).jdField_a_of_type_JavaLangString = "0";
              ((SessionInfo)localObject2).jdField_a_of_type_Int = 0;
              getIntent().putExtra("PhotoConst.SEND_SESSION_INFO", (Parcelable)localObject2);
              getIntent().putExtra("param_entrance", 32);
              getIntent().putExtra("fake_id", ((PublishParam)localObject1).jdField_b_of_type_JavaLangString);
              getIntent().putExtra("edit_web", true);
              FlowCameraMqqAction.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr, f1, true, this.jdField_a_of_type_Double, this.jdField_b_of_type_Double, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface, false, i3, i1, this.jdField_m_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_i_of_type_Boolean, this.jdField_h_of_type_JavaLangString, this.jdField_O_of_type_Boolean, ((PublishParam)localObject1).jdField_c_of_type_JavaLangString, ((PublishParam)localObject1).jdField_d_of_type_JavaLangString, ((PublishParam)localObject1).jdField_f_of_type_Int, true, false);
              break;
              if (paramInt2 != 0) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.i("PTV.NewFlowCameraActivity", 2, "Press the cancel button state=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
              }
              this.jdField_a_of_type_JavaUtilHashMap.put("result_Event", String.valueOf(2));
              m(false);
              this.jdField_d_of_type_Long = System.currentTimeMillis();
              if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 4) {
                break;
              }
              this.ax = true;
              aj();
              this.ay = true;
              break;
              if (paramInt1 == 3)
              {
                if (paramInt2 == -1)
                {
                  onBackPressed();
                  break;
                }
                if (paramInt2 != 0) {
                  break;
                }
                QLog.d("PTV.NewFlowCameraActivity", 4, "REQ_EDIE_LOCAL_VIDEO RESULT_CANCELED");
                if (QLog.isColorLevel()) {
                  QLog.i("PTV.NewFlowCameraActivity", 2, "Press the cancel button state=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
                }
                this.aa = true;
                if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 4) && (!this.jdField_j_of_type_Boolean)) {
                  break;
                }
                a("608", "2", "0", true);
                if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout != null)
                {
                  this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.c();
                  this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVisibility(0);
                }
                this.jdField_j_of_type_Boolean = false;
                break;
              }
              if (paramInt1 != TribeEffectsCameraCaptureFragment.jdField_a_of_type_Int) {
                break;
              }
              TribeTakeVideoHelper.a(this, paramIntent, paramInt2);
              break;
            }
          }
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    if (this.jdField_o_of_type_Boolean)
    {
      if ((this.jdField_r_of_type_Int == 10011) && (this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0))
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a("PTV.NewFlowCameraActivity");
        aj();
        return;
      }
      m();
      return;
    }
    k();
  }
  
  public void onClick(View paramView)
  {
    if (!this.jdField_x_of_type_Boolean) {}
    label79:
    label355:
    do
    {
      int i1;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    i1 = paramView.getId();
                    boolean bool;
                    if (i1 == 2131370149)
                    {
                      NewFlowCameraReporter.a();
                      if (!this.aq) {}
                      for (bool = true;; bool = false)
                      {
                        this.aq = bool;
                        ag();
                        if (this.jdField_r_of_type_Int != 10002) {
                          break;
                        }
                        if (!this.aq) {
                          break label79;
                        }
                        StoryReportor.a("video_shoot", "open_flash", 0, 0, new String[0]);
                        return;
                      }
                      StoryReportor.a("video_shoot", "close_flash", 0, 0, new String[0]);
                      return;
                    }
                    if (i1 == 2131370150)
                    {
                      if (!this.ar)
                      {
                        bool = true;
                        this.ar = bool;
                        ah();
                        GLVideoClipUtil.a(this.ar);
                        if (!this.ar) {
                          break label170;
                        }
                      }
                      for (paramView = "1";; paramView = "0")
                      {
                        ReportController.b(null, "dc00898", "", "", "0X8007BB7", "0X8007BB7", 0, 0, paramView, "", "", "");
                        return;
                        bool = false;
                        break;
                      }
                    }
                    if (i1 != 2131369007) {
                      break;
                    }
                  } while ((!Utils.a()) || (this.jdField_o_of_type_Boolean) || (!QLog.isColorLevel()));
                  QLog.i("PTV.NewFlowCameraActivity", 2, "Press the capture button.");
                  return;
                  if (i1 != 2131370151) {
                    break;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.i("PTV.NewFlowCameraActivity", 2, "Press the cancel button state=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
                  }
                } while (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 4);
                aj();
                return;
                if (i1 == 2131368623)
                {
                  FlowCameraMqqAction.b("", "0X8006A12");
                  if (this.jdField_r_of_type_Int == 10012) {
                    if (!"barindex".equals(this.jdField_y_of_type_JavaLangString)) {
                      break label355;
                    }
                  }
                  for (i1 = 1;; i1 = 2)
                  {
                    ReportController.b(null, "dc00899", "Grp_tribe", "", "video_shoot", "Clk_left", i1, 0, "", "", "", "");
                    k();
                    return;
                  }
                }
                if ((i1 != 2131370155) && (i1 != 2131370157) && (i1 != 2131365527)) {
                  break label858;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("PTV.NewFlowCameraActivity", 2, "click right state is =" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
                }
                if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 4) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("PTV.NewFlowCameraActivity", 2, "click right totalTime=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
                }
              } while (this.aG);
              if (this.jdField_r_of_type_Int == 10011)
              {
                if (TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
                  new NewFlowCameraActivity.EncodeTask(this, null, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$VideoProcessListener, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a(), false).execute(new Void[0]);
                }
                for (;;)
                {
                  b("正在上传");
                  return;
                  e(this.jdField_g_of_type_JavaLangString);
                }
              }
              new DCShortVideo(BaseApplication.getContext());
              this.ag = true;
              ak();
              this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.k();
              a(102);
              LogTag.a(this.jdField_d_of_type_JavaLangString, "SendBtn Click ", ",(int)rmStateMgr.mTotalTime = " + (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double + ",frames = " + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex() + " VideoABTest:" + SystemClock.uptimeMillis());
              paramView = RichmediaClient.a().a().a(this.jdField_d_of_type_JavaLangString);
              if (paramView != null) {
                paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex(), this.jdField_f_of_type_Long, this.jdField_C_of_type_Int);
              }
              c(true);
              this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, this.jdField_B_of_type_Boolean, false, null);
            } while (VideoEnvironment.d());
            setResult(1001);
            finish();
            return;
            if (QLog.isColorLevel()) {
              QLog.d("PTV.NewFlowCameraActivity", 2, "click right invisible enable=" + paramView.isEnabled());
            }
            BabyQHandler.a(this.jdField_f_of_type_AndroidViewView);
            B();
            FlowCameraMqqAction.a(getIntent().getIntExtra("edit_video_type", -1), "", "0X800781F", null);
            FlowCameraMqqAction.b("", "0X8006A14");
            ShortVideoMtaReport.a("shortvideo_effects_entry", null);
          } while (!this.jdField_K_of_type_Boolean);
          LpReportInfo_pf00064.allReport(627, 3);
          return;
          if (i1 != 2131370114) {
            break;
          }
          jdField_d_of_type_Boolean = false;
          a(-1, false);
          if ((FlowCameraConstant.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter == null) && (this.am)) {
            B();
          }
          FlowCameraMqqAction.b("", "0X8006A15");
          ShortVideoMtaReport.a("shortvideo_rotate_camera", null);
          if (this.jdField_r_of_type_Int == 10002)
          {
            if (FlowCameraConstant.jdField_a_of_type_Int == 1)
            {
              StoryReportor.a("video_shoot", "camera_front", 0, 0, new String[0]);
              return;
            }
            StoryReportor.a("video_shoot", "camera_back", 0, 0, new String[0]);
            return;
          }
        } while (this.jdField_r_of_type_Int != 10012);
        if (FlowCameraConstant.jdField_a_of_type_Int == 1)
        {
          if ("barindex".equals(this.jdField_y_of_type_JavaLangString)) {}
          for (i1 = 1;; i1 = 2)
          {
            ReportController.b(null, "dc00899", "Grp_tribe", "", "video_shoot", "camera_front", i1, 0, "", "", "", "");
            return;
          }
        }
        if ("barindex".equals(this.jdField_y_of_type_JavaLangString)) {}
        for (i1 = 1;; i1 = 2)
        {
          ReportController.b(null, "dc00899", "Grp_tribe", "", "video_shoot", "camera_back", i1, 0, "", "", "", "");
          return;
        }
        if (i1 == 2131370116)
        {
          if (QLog.isColorLevel()) {
            QLog.i("PTV.NewFlowCameraActivity", 2, "Press the cancel button state=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4) || (this.jdField_j_of_type_Boolean))
          {
            a("608", "2", "0", true);
            if (e()) {
              FlowCameraMqqAction.b("", "0X8006A17");
            }
            for (;;)
            {
              a(true);
              if (this.jdField_y_of_type_Boolean) {
                this.jdField_z_of_type_Boolean = true;
              }
              if (QLog.isColorLevel()) {
                QLog.d("face", 2, "click left hasChangeCamera" + this.jdField_y_of_type_Boolean);
              }
              H();
              return;
              FlowCameraMqqAction.b("", "0X8006A1B");
            }
          }
          if (QLog.isColorLevel()) {
            QLog.e("PTV.NewFlowCameraActivity", 2, "flow_camera_btn_video_local");
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface.a(this);
          }
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new xqw(this), 1000L);
          return;
        }
        Object localObject1;
        Object localObject2;
        Iterator localIterator;
        if (i1 == 2131373531)
        {
          localObject1 = QzoneConfig.getInstance().getConfig("H5Url", "UgcPermitSetting", "https://h5.qzone.qq.com/ugc/setting?_wv=3&type=mood&uin={uin}&qua={qua}&_proxy=1");
          paramView = "";
          if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
            paramView = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
          }
          paramView = ((String)localObject1).replace("{uin}", paramView).replace("{qua}", QUA.a());
          a("608", "6", "0", true);
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("permission_code", this.jdField_d_of_type_Int);
          if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
          {
            ((Bundle)localObject1).putStringArrayList("uin_list", this.jdField_a_of_type_JavaUtilArrayList);
            localObject2 = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
            localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (localIterator.hasNext()) {
              ((ArrayList)localObject2).add(a((String)localIterator.next()));
            }
            ((Bundle)localObject1).putStringArrayList("key_nicknames", (ArrayList)localObject2);
          }
          if ((a(this.jdField_d_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
            ((Bundle)localObject1).putString("key_setting_raw_json", this.jdField_c_of_type_JavaLangString);
          }
          QZoneHelper.a(this, paramView, 2, (Bundle)localObject1, "");
          return;
        }
        if (i1 == 2131373530)
        {
          this.aS = true;
          this.jdField_L_of_type_Boolean = true;
          this.jdField_c_of_type_Boolean = true;
          a("608", "5", "0", true);
          localObject1 = QZoneHelper.UserInfo.a();
          localObject2 = new Bundle();
          ((Bundle)localObject2).putInt("permission_code", this.jdField_d_of_type_Int);
          if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
          {
            ((Bundle)localObject2).putStringArrayList("uin_list", this.jdField_a_of_type_JavaUtilArrayList);
            paramView = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
            localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (localIterator.hasNext()) {
              paramView.add(a((String)localIterator.next()));
            }
            ((Bundle)localObject2).putStringArrayList("key_nicknames", paramView);
          }
          if ((a(this.jdField_d_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
            ((Bundle)localObject2).putString("key_setting_raw_json", this.jdField_c_of_type_JavaLangString);
          }
          if (this.jdField_h_of_type_AndroidViewView == null)
          {
            this.jdField_h_of_type_AndroidViewView = new View(this);
            this.jdField_h_of_type_AndroidViewView.setBackgroundColor(Color.argb(128, 0, 0, 0));
            this.jdField_h_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            ((RelativeLayout)this.jdField_g_of_type_AndroidViewView).addView(this.jdField_h_of_type_AndroidViewView);
          }
          this.jdField_h_of_type_AndroidViewView.setVisibility(0);
          paramView = "";
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText != null) {
            paramView = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.getText().toString();
          }
          if (this.jdField_M_of_type_Boolean) {}
          for (i1 = 0;; i1 = 1)
          {
            QZoneHelper.a(this, (QZoneHelper.UserInfo)localObject1, 1009, "", paramView, "", "", 0, i1, 1, 0, 0, 0, "", 10000, (Bundle)localObject2, this.jdField_M_of_type_Boolean, this.jdField_O_of_type_Boolean, this.jdField_y_of_type_Int, this.jdField_A_of_type_Int, false);
            return;
          }
        }
        if (i1 == 2131370152)
        {
          StoryReportor.a("video_shoot", "clk_now", 0, 0, new String[0]);
          paramView = new NowProxy();
          if (paramView.a())
          {
            SLog.b("PTV.NewFlowCameraActivity", "now app is installed");
            paramView.a(null);
            return;
          }
          StoryReportor.a("video_shoot", "exp_now", 0, 0, new String[0]);
          SLog.b("PTV.NewFlowCameraActivity", "now app is not installed, ask the user");
          localObject1 = DialogUtil.a(this, 230);
          ((QQCustomDialog)localObject1).setTitle(null);
          ((QQCustomDialog)localObject1).setMessage("首次开启直播需下载NOW应用");
          ((QQCustomDialog)localObject1).setNegativeButton("取消", new xqx(this));
          ((QQCustomDialog)localObject1).setPositiveButton("确定", new xqy(this, paramView));
          ((QQCustomDialog)localObject1).getBtnight().getPaint().setFakeBoldText(true);
          ((QQCustomDialog)localObject1).setCancelable(true);
          ((QQCustomDialog)localObject1).getWindow().setBackgroundDrawable(new ColorDrawable(0));
          ((QQCustomDialog)localObject1).show();
          return;
        }
      } while (i1 != 2131370022);
      aj();
    } while (this.jdField_b_of_type_AndroidViewView == null);
    label170:
    label858:
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.getWindow().addFlags(128);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("DeviceInfo:");
      localStringBuilder.append("PRODUCT=").append(Build.PRODUCT).append("|");
      localStringBuilder.append("MODEL=").append(Build.MODEL).append("|");
      localStringBuilder.append("BOARD=").append(Build.BOARD).append("|");
      localStringBuilder.append("BOOTLOADER=").append(Build.BOOTLOADER).append("|");
      localStringBuilder.append("CPU_ABI=").append(Build.CPU_ABI).append("|");
      localStringBuilder.append("CPU_ABI2=").append(Build.CPU_ABI2).append("|");
      localStringBuilder.append("DEVICE=").append(Build.DEVICE).append("|");
      localStringBuilder.append("DISPLAY=").append(Build.DISPLAY).append("|");
      localStringBuilder.append("FLNGERPRINT=").append(Build.FINGERPRINT).append("|");
      localStringBuilder.append("HARDWARE=").append(Build.HARDWARE).append("|");
      localStringBuilder.append("ID=").append(Build.ID).append("|");
      localStringBuilder.append("SERIAL=").append(Build.SERIAL).append("|");
      localStringBuilder.append("MANUFACTURER=").append(Build.MANUFACTURER).append("|");
      localStringBuilder.append("SDK_INT=").append(Build.VERSION.SDK_INT).append("|");
      QLog.i("PTV.NewFlowCameraActivity", 2, localStringBuilder.toString());
    }
    this.jdField_U_of_type_Boolean = true;
    this.jdField_V_of_type_Boolean = b();
    PerfTracer.traceStart("Video_component_onCreate");
    super.onCreate(paramBundle);
    if (g())
    {
      QQToast.a(this, "该功能无法在分屏模式下使用。", 0).a();
      finish();
      return;
    }
    LbsFilterStatusManager.jdField_a_of_type_ComTencentCommonAppAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    LbsFilterStatusManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (this.jdField_r_of_type_Int == 10002) {
      QQStoryFlowCallback.a(this, 1);
    }
    if (this.jdField_r_of_type_Int == 10002) {
      StoryReportor.a("video_shoot", "exp_findview", 0, 0, new String[] { "", "", "", a() + "" });
    }
    if ((this.jdField_r_of_type_Int == 10000) || (this.jdField_r_of_type_Int == 10004) || (this.jdField_r_of_type_Int == 10010)) {
      NewFlowCameraReporter.j();
    }
    PerfTracer.traceEnd("Video_component_onCreate");
    this.jdField_f_of_type_Long = 0L;
    this.jdField_C_of_type_Int = 0;
    if (this.jdField_r_of_type_Int == 10003)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "Begin to initBlessSpecialPendantConfigInfo!");
      }
      PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).c(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    for (;;)
    {
      paramBundle = ViewConfiguration.get(this);
      this.jdField_t_of_type_Int = paramBundle.getScaledMinimumFlingVelocity();
      this.jdField_u_of_type_Int = paramBundle.getScaledMaximumFlingVelocity();
      if (VideoEnvironment.b() >= 56) {}
      try
      {
        VideoSourceHelper.nativeSetMaxPhotoFrameCount(0);
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(1008);
        RMVideoStateMgr.a().jdField_b_of_type_Boolean = true;
        paramBundle = (AddressDataProvider)((DataProviderManager)SuperManager.a(20)).a(1);
        if (paramBundle.a() == null) {
          paramBundle.b();
        }
        i(FlowCameraConstant.jdField_a_of_type_Int);
        return;
        if (this.aG)
        {
          PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).b(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
          continue;
        }
        PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      }
      catch (UnsatisfiedLinkError paramBundle)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PTV.NewFlowCameraActivity", 2, "nativeSetMaxPhotoFrameCount:exp=", paramBundle);
          }
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
    try
    {
      if (this.jdField_U_of_type_Int == 1)
      {
        unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_U_of_type_Int = 0;
      }
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.d();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.c();
      if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null) {
        this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      }
      if (this.jdField_r_of_type_Int == 10002) {
        QQStoryFlowCallback.b(this);
      }
      if (!this.an) {
        ThreadManager.post(new xqq(this), 8, null, true);
      }
      VideoFilterTools.a().a(null);
      VideoFilterTools.a().b();
      VideoFilterTools.a().a();
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(null);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor != null) {
        this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor.b();
      }
      PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(null);
      NewFlowCameraReporter.a(this.jdField_N_of_type_Int, jdField_c_of_type_Long - this.jdField_g_of_type_Long, this.jdField_r_of_type_Int + "", aF);
      if (FlowCameraConstant.jdField_a_of_type_Int == 2)
      {
        String str1 = "back";
        NewFlowCameraReporter.a(str1, GloableValue.jdField_c_of_type_Int + "*" + GloableValue.jdField_d_of_type_Int, NewFlowCameraReporter.jdField_a_of_type_JavaLangString);
        NewFlowCameraReporter.l();
        jdField_c_of_type_Long = 0L;
        aF = false;
        if (QLog.isColorLevel()) {
          QLog.d("DynamicAdjustment", 2, "clear firstFrameShownTime :  " + jdField_c_of_type_Long);
        }
        LbsFilterStatusManager.c();
        GestureRecognitionUtils.jdField_a_of_type_JavaUtilHashMap.clear();
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("PTV.NewFlowCameraActivity", 2, " already unregisterReceiver" + localIllegalArgumentException);
          continue;
          String str2 = "front";
        }
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    if (g())
    {
      QQToast.a(this, "该功能无法在分屏模式下使用。", 0).a();
      finish();
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    this.jdField_j_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.e();
      this.jdField_r_of_type_Boolean = false;
    }
    this.jdField_a_of_type_AndroidContentIntent = new Intent(BaseApplicationImpl.getContext(), EditLocalVideoActivity.class);
    this.jdField_a_of_type_AndroidContentIntent.putExtras(paramIntent);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("is_qzone_vip", this.ap);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("param.topicId", this.jdField_h_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("param.topicSyncQzone", this.jdField_O_of_type_Boolean);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("extra_key_font_id", this.jdField_y_of_type_Int);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("extra_key_font_format_type", this.jdField_z_of_type_Int);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("extra_key_font_url", this.jdField_j_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("extra_key_super_font_id", this.jdField_A_of_type_Int);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("extra_key_super_font_info", this.jdField_k_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("short_video_refer", this.jdField_r_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("set_user_callback", this.jdField_s_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.postDelayed(new xrr(this), 0L);
    super.onNewIntent(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130846407);
    this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130846407);
    if (this.aS) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b();
      Object localObject = RMVideoStateMgr.a();
      ((RMVideoStateMgr)localObject).n();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
      this.jdField_n_of_type_Boolean = false;
      if (this.S == 1) {
        QzoneOnlineTimeCollectRptService.a().a();
      }
      if (((RMVideoStateMgr)localObject).jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4) {
        l();
      }
      localObject = a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131362087);
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView((View)localObject);
      }
      if ((!this.ai) && (!this.ag) && (!this.ah))
      {
        this.ai = true;
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 300000L);
      }
      if (this.jdField_r_of_type_Int == 10002) {
        ((DoodleEmojiManager)SuperManager.a(8)).e();
      }
      VideoFilterTools.a().b();
      LbsFilterStatusManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).b();
    } while ((this.jdField_j_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy == null));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.b(true);
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.aN)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130843216);
      this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    for (;;)
    {
      this.jdField_p_of_type_Boolean = false;
      if ((this.jdField_r_of_type_Int != 10002) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper.jdField_a_of_type_Int != 1)) {
        break;
      }
      SLog.c("PTV.NewFlowCameraActivity", "onResume do nothing because we are going to publish");
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.setVisibility(8);
      }
    }
    if ((!this.jdField_j_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy != null) && (!this.aN)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a();
    }
    if (this.aS)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      return;
    }
    if (this.jdField_j_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    ac();
    LbsFilterStatusManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a();
  }
  
  public void onStart()
  {
    super.onStart();
    ab();
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_b_of_type_Double = 0.0D;
    this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new xqp(this, 1, true, true, 0L, false, false, "NewFlowCameraActivity");
    SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_z_of_type_Boolean) {
      this.jdField_A_of_type_Boolean = true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener != null))
    {
      SosoInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
      this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = null;
      this.jdField_a_of_type_Double = 0.0D;
      this.jdField_b_of_type_Double = 0.0D;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    if (!this.jdField_x_of_type_Boolean) {}
    while ((this.jdField_t_of_type_Boolean) || (!this.jdField_a_of_type_AndroidWidgetImageView.isClickable())) {
      return bool;
    }
    if (paramMotionEvent.getAction() != 2) {
      this.jdField_G_of_type_Boolean = false;
    }
    GLGestureProxy.a().a(paramMotionEvent, false, null, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_AndroidOpenglGLSurfaceView);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryCameraZoom.a(paramMotionEvent, false))
    {
      SLog.a("PTV.NewFlowCameraActivity", "mNewStoryCameraZoom consume the touch event");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.c();
      }
      if (!this.jdField_G_of_type_Boolean)
      {
        FlowCameraMqqAction.a("", "0X80075BC", "", "", "", "");
        this.jdField_e_of_type_Boolean = true;
      }
      this.jdField_G_of_type_Boolean = true;
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 4)
    {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.isShown())) {}
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.onTouchEvent(paramMotionEvent);
      if ((paramMotionEvent.getAction() == 1) && (!this.jdField_H_of_type_Boolean)) {
        k(false);
      }
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("PTV.NewFlowCameraActivity", 2, "onTouchEvent", localException);
        }
        paramMotionEvent.setAction(3);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.onTouchEvent(paramMotionEvent);
      }
    }
  }
  
  public void p()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "initUI_IdleState mIsVideoMode=" + this.jdField_o_of_type_Boolean + ", needGenThumbPic:" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_f_of_type_Boolean);
    }
    Button localButton;
    if (this.jdField_o_of_type_Boolean)
    {
      if ((QLog.isColorLevel()) && (this.jdField_f_of_type_AndroidWidgetButton != null))
      {
        QLog.i("PTV.NewFlowCameraActivity", 2, "initUI_IdleState:mSendButton.getVisibility=" + this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.getVisibility());
        QLog.i("PTV.NewFlowCameraActivity", 2, "initUI_IdleState:mLeftButton.getVisibility=" + this.jdField_f_of_type_AndroidWidgetButton.getVisibility());
      }
      if ((QLog.isColorLevel()) && (this.jdField_f_of_type_AndroidWidgetButton != null))
      {
        QLog.i("PTV.NewFlowCameraActivity", 2, "initUI_IdleState:mSendButton.isEnabled=" + this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.isEnabled());
        QLog.i("PTV.NewFlowCameraActivity", 2, "initUI_IdleState:mLeftButton.isEnabled=" + this.jdField_f_of_type_AndroidWidgetButton.isEnabled());
        QLog.i("PTV.NewFlowCameraActivity", 2, "initUI_IdleState:mCameraCapture.isEnabled=" + this.jdField_a_of_type_AndroidWidgetImageView.isEnabled());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setNeedWrite(false);
      this.jdField_r_of_type_Boolean = false;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.getVisibility() == 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean)) {
        c(0, true);
      }
      if ((c()) && (this.jdField_f_of_type_AndroidWidgetButton != null))
      {
        if (this.jdField_f_of_type_AndroidWidgetButton.getVisibility() == 4)
        {
          this.jdField_f_of_type_AndroidWidgetButton.setVisibility(0);
          VideoAnimation.a(this.jdField_f_of_type_AndroidWidgetButton, -8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
        }
        this.jdField_f_of_type_AndroidWidgetButton.setEnabled(true);
      }
      if (((this.jdField_r_of_type_Int == 10002) || (this.jdField_r_of_type_Int == 10012)) && (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 4))
      {
        localButton = this.jdField_a_of_type_AndroidWidgetButton;
        if (!this.Z) {
          break label581;
        }
      }
    }
    label581:
    for (int i1 = 0;; i1 = 8)
    {
      localButton.setVisibility(i1);
      VideoAnimation.a(this.jdField_a_of_type_AndroidWidgetButton, -8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setEnabled(true);
      this.jdField_g_of_type_AndroidWidgetButton.clearAnimation();
      this.jdField_g_of_type_AndroidWidgetButton.setVisibility(8);
      f(false);
      float f1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_f_of_type_Boolean)
      {
        f1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
        if (!RMVideoStateMgr.jdField_a_of_type_Boolean) {}
        i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_e_of_type_Int;
        int i2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, f1, i1, i2);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_f_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = null;
      }
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.c();
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) && (!bool))
      {
        f1 = (float)(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b() * 1000.0F / this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(f1, -1);
      }
      return;
    }
  }
  
  public void q()
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_AndroidWidgetImageView.isEnabled()) {
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
    }
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "initUI_previewState, needIntent:" + this.ay + ", shareToWeb:" + this.aG);
    }
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.a();
      if ((localObject2 != null) && (!TextUtils.isEmpty(((FilterDesc)localObject2).jdField_e_of_type_JavaLangString)) && (!TextUtils.equals(((FilterDesc)localObject2).jdField_e_of_type_JavaLangString, "EMPTY"))) {
        StoryReportor.a("video_shoot", "clk_swipe", b(), 0, new String[] { ((FilterDesc)localObject2).jdField_e_of_type_JavaLangString });
      }
    }
    if (!this.aE)
    {
      this.jdField_r_of_type_Int = getIntent().getIntExtra("edit_video_type", 0);
      if (((this.jdField_r_of_type_Int != 10000) && (this.jdField_r_of_type_Int != 10003) && (this.jdField_r_of_type_Int != 10004) && (this.jdField_r_of_type_Int != 10010) && (this.jdField_r_of_type_Int != 10008) && (this.jdField_r_of_type_Int != 10012)) || (!this.ay)) {
        break label240;
      }
      g(this.jdField_r_of_type_Int);
    }
    label240:
    int i1;
    do
    {
      return;
      if ((this.jdField_r_of_type_Int == 10002) && (this.ay))
      {
        i1 = this.jdField_f_of_type_Int;
        if ((!this.jdField_k_of_type_Boolean) || (i1 < 11000L))
        {
          h(i1);
          return;
        }
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new xsi(this, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, i1, null), 100L);
        return;
      }
      if (this.jdField_K_of_type_Boolean)
      {
        av();
        return;
      }
      if ((this.jdField_i_of_type_Boolean) && (this.ay))
      {
        aw();
        return;
      }
      if ((this.jdField_r_of_type_Int == 10007) && (this.ay))
      {
        g(this.jdField_r_of_type_Int);
        return;
      }
    } while ((this.jdField_i_of_type_Boolean) || (this.jdField_r_of_type_Int == 10000));
    if ((this.jdField_r_of_type_Int == 10011) && (!jdField_d_of_type_Boolean))
    {
      if (this.jdField_b_of_type_AndroidViewView == null)
      {
        this.jdField_b_of_type_AndroidViewView = getLayoutInflater().inflate(2130970426, null);
        localObject1 = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout)this.jdField_g_of_type_AndroidViewView).addView(this.jdField_b_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject1);
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131370022)).setOnClickListener(this);
      if (!jdField_d_of_type_Boolean) {
        break label693;
      }
    }
    label678:
    label693:
    for (localObject1 = "1";; localObject1 = "2")
    {
      NearbyVideoUtils.a("shoot", new String[] { localObject1 });
      return;
      int i3 = this.jdField_f_of_type_Int;
      int i2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
      i1 = i2;
      if (i2 <= 0) {
        i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getRemainedRecordFrames(0);
      }
      if (i1 > 0) {
        this.jdField_V_of_type_Int = i1;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(CodecParam.jdField_c_of_type_Int, i3, this.jdField_V_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setCyclePlay(true);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr.a();
      BitmapFactory.Options localOptions;
      if ((localObject2 != null) && (((RMVideoThumbGenMgr.ThumbGenItem)localObject2).jdField_c_of_type_JavaLangString != null) && (((RMVideoThumbGenMgr.ThumbGenItem)localObject2).a.get() == 3) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null))
      {
        localOptions = new BitmapFactory.Options();
        localOptions.inSampleSize = 2;
        localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      }
      try
      {
        localObject2 = BitmapFactory.decodeFile(((RMVideoThumbGenMgr.ThumbGenItem)localObject2).jdField_c_of_type_JavaLangString, localOptions);
        localObject1 = localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        break label678;
      }
      if (localObject1 != null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.b();
      break;
    }
  }
  
  public void r()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
    }
    this.ad = true;
    boolean bool1 = CameraCompatibleList.a(CameraCompatibleList.jdField_q_of_type_JavaLangString);
    boolean bool2 = CameraCompatibleList.e(CameraCompatibleList.A);
    if ((!this.jdField_n_of_type_Boolean) && ((bool1) || (bool2)) && (!this.aQ))
    {
      this.aQ = true;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 2000L);
    }
    ag();
  }
  
  public void run() {}
  
  public void s()
  {
    if (this.jdField_e_of_type_AndroidWidgetImageView.getVisibility() == 0)
    {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_e_of_type_AndroidWidgetImageView.setAlpha(255);
    }
    if (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() == 0)
    {
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetImageView.setAlpha(255);
    }
    if (QLog.isColorLevel()) {
      QLog.d("face", 4, "getFirstFrame gl_root.getVisibility()=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.getVisibility());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVisibility(0);
    this.jdField_n_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "(OLD)LaunchActivity to FirstFrameShown cost : " + (jdField_c_of_type_Long - this.jdField_g_of_type_Long) + "ms");
    }
  }
  
  public void t() {}
  
  public void u() {}
  
  public void v()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr == null) {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "replayVideo rmStateMgr=null");
      }
    }
    do
    {
      return;
      this.jdField_j_of_type_Boolean = false;
      if (this.jdField_c_of_type_AndroidWidgetButton != null) {
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(4);
      }
      if (this.aG) {
        FlowCameraMqqAction.a("", "0X8007931", "", "", "", "");
      }
      this.jdField_f_of_type_Boolean = false;
      ag();
      if (this.jdField_k_of_type_Boolean) {
        this.jdField_j_of_type_AndroidWidgetTextView.clearAnimation();
      }
      if (!this.aE) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.c(this.jdField_E_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "replayVideo getVFileAndAFile=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString + "errcode=" + 0 + "hasFrame=" + bool);
      }
      if (!bool)
      {
        QQToast.a(this, "拍摄时间过短，请重新拍摄。", 0).a();
        if (this.jdField_r_of_type_Int == 10002) {
          StoryReportor.a("video_shoot", "exp_time_float", 0, 0, new String[0]);
        }
        this.ab = true;
        af();
        FlowCameraMqqAction.a("", "0X80075C0", "", "", "", "");
        jdField_d_of_type_Boolean = false;
        return;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PTV.NewFlowCameraActivity", 2, "replayVideo isCurrentPreviewState= true......");
    return;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, this.jdField_B_of_type_Boolean, false, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec);
    if (localObject != null) {
      ThreadManager.post(new xqu(this, (Bitmap)localObject), 8, null, false);
    }
    l(false);
    this.ah = true;
    localObject = a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131362087);
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView((View)localObject);
      this.jdField_n_of_type_Boolean = false;
    }
    if (!this.aE)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
      float f1 = ((RMVideoClipSpec)localObject).jdField_f_of_type_Int * 1.0F / ((RMVideoClipSpec)localObject).jdField_e_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.i("PTV.NewFlowCameraActivity", 2, "heightRatio=" + f1 + "clipspec.dst_height=" + ((RMVideoClipSpec)localObject).jdField_f_of_type_Int + "clipspec.dst_width=" + ((RMVideoClipSpec)localObject).jdField_e_of_type_Int);
      }
      b((int)this.jdField_c_of_type_Float, (int)this.jdField_d_of_type_Float);
      FileUtils.d(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(), jdField_o_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(4);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter(null, false, false);
    Properties localProperties = new Properties();
    localProperties.setProperty("shortvideo_duration", "" + (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
    if ((this.jdField_o_of_type_Int == 90) || (this.jdField_o_of_type_Int == 270)) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (FlowCameraConstant.jdField_a_of_type_Int == 1) {}
      for (int i2 = 1;; i2 = 0)
      {
        if (!e())
        {
          FlowCameraMqqAction.a("", "0X8006A13", String.valueOf((int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double), "" + i1, "" + i2, "");
          ShortVideoMtaReport.a("shortvideo_record_noeffcts", localProperties);
          if (FlowCameraConstant.jdField_a_of_type_Int != 1) {
            break label1102;
          }
          ShortVideoMtaReport.a("shortvideo_front_camera", null);
          label710:
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null) {
            break label1112;
          }
        }
        label1102:
        label1112:
        for (localObject = "";; localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a())
        {
          FlowCameraMqqAction.a("", "0X80075BF", (String)localObject, "", "", "");
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null)
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a();
            if (localObject != null)
            {
              localProperties = new Properties();
              localProperties.setProperty("shortvideo_template_id", (String)localObject);
              localProperties.setProperty("shortvideo_template_name", "" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.b());
              ShortVideoMtaReport.a("shortvideo_record_id1", localProperties);
            }
          }
          if (this.jdField_r_of_type_Int == 10002) {
            StoryReportor.a("video_shoot", "press_shoot", 0, 0, new String[] { "1" });
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("PTV.NewFlowCameraActivity", 2, "replay totaltime = " + (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null) {}
          for (localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a();; localObject = "")
          {
            FlowCameraMqqAction.a("", "0X8006A18", String.valueOf((int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double), "" + i1, "" + i2, (String)localObject);
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a().hasGesture())) {
              FlowCameraMqqAction.a("", "0X80083AF", String.valueOf((int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double), "" + i1, "" + i2, (String)localObject);
            }
            if (!TextUtils.isEmpty(this.jdField_x_of_type_JavaLangString)) {
              FlowCameraMqqAction.a("", "0X80083B7", (String)localObject, "", this.jdField_x_of_type_JavaLangString, "");
            }
            ShortVideoMtaReport.a("shortvideo_record_effects", localProperties);
            break;
          }
          ShortVideoMtaReport.a("shortvideo_back_camera", null);
          break label710;
        }
      }
    }
  }
  
  public void w() {}
  
  public void x()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "enterViewVideoMode");
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.a(false);
    TextView localTextView = this.jdField_g_of_type_AndroidWidgetTextView;
    if (this.jdField_K_of_type_Boolean) {}
    for (int i1 = 8;; i1 = 0)
    {
      localTextView.setVisibility(i1);
      if (!this.jdField_b_of_type_AndroidWidgetButton.isEnabled()) {
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      }
      if (this.jdField_h_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      }
      as();
      ar();
      return;
    }
  }
  
  public void y()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "exitViewVideoMode");
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
    if (!this.jdField_b_of_type_AndroidWidgetButton.isEnabled()) {
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
    }
    if (this.jdField_h_of_type_Boolean) {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    }
    as();
    ar();
  }
  
  public void z()
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new xsc(this, this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "recordVideoFinish");
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a())
    {
      v();
      if (this.aq)
      {
        if (FlowCameraConstant.jdField_a_of_type_Int != 1) {
          break label148;
        }
        j(false);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.f();
      return;
      a(this, 2131436145);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.lockFrameSync();
      C();
      v();
      break;
      label148:
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity
 * JD-Core Version:    0.7.0.1
 */