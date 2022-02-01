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
import android.content.res.Configuration;
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
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Parcelable;
import android.os.SystemClock;
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
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.QQStoryTakeVideoHelper;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import com.tencent.biz.qqstory.takevideo.EditTakeGifSource;
import com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
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
import com.tencent.mobileqq.activity.richmedia.view.CameraTextureView;
import com.tencent.mobileqq.activity.richmedia.view.ExtendEditText;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.FramePerformanceMonitor;
import com.tencent.mobileqq.ar.GapDataCollector.RefreshData;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager;
import com.tencent.mobileqq.nearby.NearbyVideoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.CompoundProcessor;
import com.tencent.mobileqq.richmedia.RichmediaClient;
import com.tencent.mobileqq.richmedia.VideoCompoundController;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;
import com.tencent.mobileqq.shortvideo.AIOShortVideoUtil;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.IPtvTemplateUpdateListener;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.camera2.CameraFocusParams;
import com.tencent.mobileqq.shortvideo.common.GloableValue;
import com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwAutoSegmentMgr;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwOutputNotify;
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
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.shortvideo.util.ShortVideoGuideUtil;
import com.tencent.mobileqq.shortvideo.util.VideoAnimation;
import com.tencent.mobileqq.shortvideo.util.storage.StorageManager;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.IMPlayerEndListener;
import com.tencent.mobileqq.shortvideo.widget.TCProgressBar.DelEvent;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.QzoneTextBuilder;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.QQDeviceInfo;
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
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.capture.CaptureContext;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.AppRuntime;
import org.json.JSONObject;

@TargetApi(14)
public class NewFlowCameraActivity
  extends FlowActivity
  implements Handler.Callback, View.OnClickListener, MediaScanner.OnMediaInfoScannerListener, FlowComponentInterface, PtvTemplateAdapter.IPtvTemplateItemChangedCallback, PtvTemplateAdapter.IPtvTemplateItemSelectedCallback, ShortVideoCaptureController.CaptureProcessObserver, RMVideoSwitchCameraPicMgr.ViewBitmapSource, RMViewSTInterface, CameraFilterGLView.CameraGlFilterListener, HWEncodeListener, PtvTemplateManager.IPtvTemplateUpdateListener, ImageViewVideoPlayer.IMPlayerEndListener, TCProgressBar.DelEvent, Runnable
{
  public static long a;
  private static final boolean aB;
  private static boolean aD = true;
  private static boolean aP;
  public static float b;
  public static int b;
  public static boolean b;
  public static long c;
  public static boolean c;
  private static String jdField_n_of_type_JavaLangString;
  private static String jdField_o_of_type_JavaLangString;
  private static String jdField_p_of_type_JavaLangString;
  private static int jdField_u_of_type_Int;
  private int jdField_A_of_type_Int;
  boolean jdField_A_of_type_Boolean = true;
  private int B;
  public boolean B;
  private int jdField_C_of_type_Int = 0;
  boolean jdField_C_of_type_Boolean = false;
  private int jdField_D_of_type_Int = 1;
  boolean jdField_D_of_type_Boolean = false;
  private int jdField_E_of_type_Int;
  boolean jdField_E_of_type_Boolean = false;
  private int jdField_F_of_type_Int = 0;
  boolean jdField_F_of_type_Boolean = false;
  private int jdField_G_of_type_Int = 1;
  boolean jdField_G_of_type_Boolean = false;
  private int jdField_H_of_type_Int = 11;
  boolean jdField_H_of_type_Boolean = false;
  private int I;
  protected boolean I;
  private int J;
  protected boolean J;
  private int K;
  protected boolean K;
  private int jdField_L_of_type_Int;
  private boolean jdField_L_of_type_Boolean = false;
  private int jdField_M_of_type_Int;
  private boolean jdField_M_of_type_Boolean;
  private int jdField_N_of_type_Int = -999;
  private boolean jdField_N_of_type_Boolean;
  private int jdField_O_of_type_Int = 1;
  private boolean jdField_O_of_type_Boolean;
  private int jdField_P_of_type_Int = 1;
  private boolean jdField_P_of_type_Boolean;
  private int jdField_Q_of_type_Int;
  private boolean jdField_Q_of_type_Boolean = true;
  private int jdField_R_of_type_Int = 0;
  private boolean jdField_R_of_type_Boolean;
  private int jdField_S_of_type_Int = 0;
  private boolean jdField_S_of_type_Boolean;
  private int jdField_T_of_type_Int = 1;
  private boolean jdField_T_of_type_Boolean;
  private int jdField_U_of_type_Int = 0;
  private boolean jdField_U_of_type_Boolean;
  private int jdField_V_of_type_Int = 0;
  private boolean jdField_V_of_type_Boolean;
  private int jdField_W_of_type_Int = -1;
  private boolean jdField_W_of_type_Boolean;
  private boolean X = false;
  private boolean Y = false;
  private boolean Z = true;
  double jdField_a_of_type_Double = 0.0D;
  float jdField_a_of_type_Float;
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new NewFlowCameraActivity.21(this);
  private Intent jdField_a_of_type_AndroidContentIntent;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Camera.FaceDetectionListener jdField_a_of_type_AndroidHardwareCamera$FaceDetectionListener = new NewFlowCameraActivity.1(this);
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener;
  VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new NewFlowCameraActivity.36(this);
  View jdField_a_of_type_AndroidViewView;
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
  private FlowComponentInterface jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface = null;
  private NewFlowCameraActivity.VideoProcessListener jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$VideoProcessListener = new NewFlowCameraActivity.2(this);
  private NewFlowCameraOperator jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator = new NewFlowCameraOperator();
  public PtvTemplateAdapter a;
  VideoFilterViewPager.OnViewPagerItemVisiableChangeListener jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager$OnViewPagerItemVisiableChangeListener;
  private VideoFilterViewPager jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager;
  private RMVideoClipSpec jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec = null;
  public RMVideoStateMgr a;
  CameraCover jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover;
  public ExtendEditText a;
  FSurfaceViewLayout jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout;
  private FramePerformanceMonitor jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor;
  private SVHwAutoSegmentMgr jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwAutoSegmentMgr = new SVHwAutoSegmentMgr();
  private volatile SVHwEncoder jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = null;
  CameraExceptionHandler.Callback jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler$Callback = new NewFlowCameraActivity.5(this);
  CameraProxy jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy;
  private ImageViewVideoPlayer jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer;
  SosoInterfaceOnLocationListener jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener;
  RedDotImageView jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  CircleProgress jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  Runnable jdField_a_of_type_JavaLangRunnable = new NewFlowCameraActivity.4(this);
  String jdField_a_of_type_JavaLangString = "";
  public ArrayList<String> a;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<Size> jdField_a_of_type_JavaUtilList;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean aA = false;
  private boolean aC = false;
  private boolean aE = false;
  private boolean aF = true;
  private boolean aG = true;
  private boolean aH = true;
  private boolean aI = false;
  private boolean aJ = false;
  private boolean aK = false;
  private boolean aL = false;
  private boolean aM = false;
  private boolean aN = false;
  private volatile boolean aO = false;
  private boolean aQ = false;
  private boolean aa = false;
  private boolean ab = false;
  private boolean ac = false;
  private boolean ad = false;
  private boolean ae = false;
  private boolean af = false;
  private boolean ag = false;
  private boolean ah = false;
  private boolean ai = false;
  private boolean aj;
  private boolean ak = true;
  private boolean al;
  private boolean am;
  private boolean an = false;
  private boolean ao = false;
  private boolean ap = false;
  private boolean aq = true;
  private boolean ar;
  private boolean as;
  private boolean at = false;
  private boolean au;
  private boolean av = true;
  private boolean aw = false;
  private boolean ax = false;
  private boolean ay = false;
  private boolean az = true;
  double jdField_b_of_type_Double = 0.0D;
  long jdField_b_of_type_Long;
  ProgressDialog jdField_b_of_type_AndroidAppProgressDialog;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_b_of_type_AndroidViewView;
  ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  Button jdField_b_of_type_AndroidWidgetButton;
  public ImageView b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  Runnable jdField_b_of_type_JavaLangRunnable = new NewFlowCameraActivity.25(this);
  public String b;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private double jdField_c_of_type_Double = 0.7D;
  float jdField_c_of_type_Float = 0.0F;
  int jdField_c_of_type_Int;
  View jdField_c_of_type_AndroidViewView;
  Button jdField_c_of_type_AndroidWidgetButton;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  Runnable jdField_c_of_type_JavaLangRunnable = new NewFlowCameraActivity.40(this);
  public String c;
  private AtomicBoolean jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private double jdField_d_of_type_Double = 1.3D;
  float jdField_d_of_type_Float = 0.0F;
  public int d;
  private long jdField_d_of_type_Long = 0L;
  View jdField_d_of_type_AndroidViewView;
  Button jdField_d_of_type_AndroidWidgetButton;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  private Runnable jdField_d_of_type_JavaLangRunnable = new NewFlowCameraActivity.50(this);
  String jdField_d_of_type_JavaLangString;
  public boolean d;
  float jdField_e_of_type_Float = 0.0F;
  int jdField_e_of_type_Int = 0;
  private long jdField_e_of_type_Long = 0L;
  View jdField_e_of_type_AndroidViewView;
  Button jdField_e_of_type_AndroidWidgetButton;
  ImageView jdField_e_of_type_AndroidWidgetImageView;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  String jdField_e_of_type_JavaLangString;
  public boolean e;
  private float jdField_f_of_type_Float;
  int jdField_f_of_type_Int;
  private long jdField_f_of_type_Long;
  View jdField_f_of_type_AndroidViewView;
  Button jdField_f_of_type_AndroidWidgetButton;
  ImageView jdField_f_of_type_AndroidWidgetImageView;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  public String f;
  boolean jdField_f_of_type_Boolean;
  int jdField_g_of_type_Int = -1;
  private long jdField_g_of_type_Long = 0L;
  protected View g;
  Button jdField_g_of_type_AndroidWidgetButton;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  TextView jdField_g_of_type_AndroidWidgetTextView;
  private String jdField_g_of_type_JavaLangString;
  boolean jdField_g_of_type_Boolean = true;
  int jdField_h_of_type_Int = -1;
  private long jdField_h_of_type_Long = 0L;
  private View jdField_h_of_type_AndroidViewView;
  private Button jdField_h_of_type_AndroidWidgetButton;
  private ImageView jdField_h_of_type_AndroidWidgetImageView;
  TextView jdField_h_of_type_AndroidWidgetTextView;
  private String jdField_h_of_type_JavaLangString;
  public boolean h;
  int jdField_i_of_type_Int = 0;
  private View jdField_i_of_type_AndroidViewView = null;
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
  boolean jdField_l_of_type_Boolean = false;
  int jdField_m_of_type_Int = 0;
  private String jdField_m_of_type_JavaLangString = "";
  boolean jdField_m_of_type_Boolean;
  int jdField_n_of_type_Int = 90;
  boolean jdField_n_of_type_Boolean;
  int jdField_o_of_type_Int;
  boolean jdField_o_of_type_Boolean = false;
  public int p;
  boolean jdField_p_of_type_Boolean;
  public int q;
  private String jdField_q_of_type_JavaLangString;
  boolean jdField_q_of_type_Boolean = false;
  int jdField_r_of_type_Int = 0;
  private String jdField_r_of_type_JavaLangString;
  boolean jdField_r_of_type_Boolean;
  int jdField_s_of_type_Int;
  private String jdField_s_of_type_JavaLangString = "";
  boolean jdField_s_of_type_Boolean;
  int jdField_t_of_type_Int;
  private String jdField_t_of_type_JavaLangString = "";
  boolean jdField_t_of_type_Boolean;
  private String jdField_u_of_type_JavaLangString;
  boolean jdField_u_of_type_Boolean;
  private int jdField_v_of_type_Int;
  private String jdField_v_of_type_JavaLangString;
  boolean jdField_v_of_type_Boolean = false;
  private int jdField_w_of_type_Int = -1;
  private String jdField_w_of_type_JavaLangString = null;
  boolean jdField_w_of_type_Boolean;
  private int jdField_x_of_type_Int = -1;
  private String jdField_x_of_type_JavaLangString = null;
  boolean jdField_x_of_type_Boolean = false;
  private int jdField_y_of_type_Int = -1;
  boolean jdField_y_of_type_Boolean = false;
  private int z;
  public boolean z;
  
  static
  {
    boolean bool = false;
    jdField_b_of_type_Int = 1;
    jdField_u_of_type_Int = 7;
    jdField_b_of_type_Boolean = false;
    jdField_c_of_type_Boolean = false;
    jdField_b_of_type_Float = 0.6F;
    jdField_a_of_type_Long = 1500L;
    jdField_n_of_type_JavaLangString = PathUtils.jdField_a_of_type_JavaLangString + "/tencent" + File.separator + "video_edit_music" + File.separator;
    jdField_o_of_type_JavaLangString = jdField_n_of_type_JavaLangString + "temp.af";
    jdField_p_of_type_JavaLangString = "";
    if (Build.VERSION.SDK_INT >= 10) {
      bool = true;
    }
    aB = bool;
    jdField_c_of_type_Long = 0L;
    try
    {
      int i1 = VideoEnvironment.loadAVCodecSo();
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "LoadExtractedShortVideoSo :code=" + i1);
      }
      aP = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public NewFlowCameraActivity()
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_d_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_z_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr = RMVideoStateMgr.a();
    this.jdField_B_of_type_Boolean = false;
    this.jdField_B_of_type_Int = 0;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_I_of_type_Int = 25;
    this.jdField_J_of_type_Int = 2;
    this.jdField_K_of_type_Int = 2;
    this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new NewFlowCameraActivity.14(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletCameraInterface = new NewFlowCameraActivity.24(this);
    this.jdField_I_of_type_Boolean = false;
    this.jdField_J_of_type_Boolean = false;
    this.jdField_K_of_type_Boolean = false;
  }
  
  private void P()
  {
    this.jdField_o_of_type_Boolean = true;
    File localFile = new File(this.jdField_e_of_type_JavaLangString);
    this.jdField_p_of_type_Int = 1;
    CameraCover localCameraCover = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover;
    NewFlowCameraActivity.9 local9 = new NewFlowCameraActivity.9(this);
    NewFlowCameraOperator localNewFlowCameraOperator = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator;
    int i1 = NewFlowCameraOperator.jdField_a_of_type_Int;
    localNewFlowCameraOperator = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator;
    localCameraCover.a(localFile, local9, i1, NewFlowCameraOperator.jdField_a_of_type_Boolean, 1, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_d_of_type_Int);
    FlowCameraMqqAction.a("", "0X80075BE", "", "", "", "");
  }
  
  private void Q()
  {
    runOnUiThread(new NewFlowCameraActivity.10(this));
  }
  
  private void R()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor = new FramePerformanceMonitor();
    this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor.a(500);
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("DynamicAdjustment", 4);
    this.jdField_J_of_type_Int = localSharedPreferences.getInt("SVDNAdjustment_max_downmark", 2);
    this.jdField_K_of_type_Int = localSharedPreferences.getInt("SVDNAdjustment_max_upmark", 2);
    this.jdField_H_of_type_Int = localSharedPreferences.getInt("SVDNAdjustment_up_threshold_base", 11);
    this.jdField_I_of_type_Int = localSharedPreferences.getInt("SVDNAdjustment_down_threshold_base", 25);
    this.jdField_c_of_type_Double = localSharedPreferences.getFloat("SVDNAdjustment_up_threshold_coefficient", 0.7F);
    this.jdField_d_of_type_Double = localSharedPreferences.getFloat("SVDNAdjustment_down_threshold_coefficient", 1.3F);
    this.jdField_L_of_type_Int = localSharedPreferences.getInt("SVDNAdjustment_quality_up_threshold", this.jdField_H_of_type_Int);
    this.jdField_M_of_type_Int = localSharedPreferences.getInt("SVDNAdjustment_quality_down_threshold", this.jdField_I_of_type_Int);
    this.jdField_f_of_type_Float = localSharedPreferences.getFloat("SVDNAdjustment_data_type", 0.5F);
    if ((this.jdField_f_of_type_Float < 0.0F) || (this.jdField_f_of_type_Float >= 1.0F)) {
      this.jdField_f_of_type_Float = 0.5F;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DynamicAdjustment", 2, "Init dynamic adjustment params. maxDownMark : " + this.jdField_J_of_type_Int + "  maxUpMark : " + this.jdField_K_of_type_Int + "  upThresholdBase : " + this.jdField_H_of_type_Int + "  downThresholdBase : " + this.jdField_I_of_type_Int + "  upThresholdcoefficient : " + this.jdField_c_of_type_Double + "  downThresholdcoefficient : " + this.jdField_d_of_type_Double + "  upThreshold : " + this.jdField_L_of_type_Int + "  downThreshold : " + this.jdField_M_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor.a(new NewFlowCameraActivity.17(this, localSharedPreferences));
    this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor.a();
  }
  
  private void S()
  {
    int i3 = 0;
    if (!CameraAbility.c()) {
      FlowCameraConstant.jdField_a_of_type_Int = 2;
    }
    int i2;
    do
    {
      return;
      if ((this.jdField_P_of_type_Boolean) || ((this.jdField_q_of_type_Int == 10007) && (this.jdField_O_of_type_Int == 1))) {}
      for (int i1 = 1;; i1 = 0)
      {
        i2 = i3;
        if (this.jdField_q_of_type_Int == 10007)
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
  
  private void T()
  {
    if ((FlowCameraConstant.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter == null) && (this.ar) && (!this.aE)) {
      y();
    }
    if (this.jdField_q_of_type_Int == 10011) {
      y();
    }
    if (this.jdField_q_of_type_Int == 10003) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "bless unfold and choose the first template" + this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
      }
      y();
      if ((PtvTemplateManager.a(this.appInterface).c().size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null))
      {
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setRestoreX(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.c());
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a((PtvTemplateManager.PtvTemplateInfo)PtvTemplateManager.a(this.appInterface).c().get(0));
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        QLog.d("PtvTemplateManager", 2, "bless unfold PtvTemplate error!", localException1);
      }
    }
    if (this.aE) {}
    try
    {
      if ((this.aI) && (this.aH))
      {
        y();
        if (this.aJ)
        {
          ArrayList localArrayList = PtvTemplateManager.a(this.appInterface).a(true, false, 2);
          if ((localArrayList != null) && (localArrayList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null))
          {
            this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setRestoreX(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.c());
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a((PtvTemplateManager.PtvTemplateInfo)localArrayList.get(0));
          }
        }
      }
      this.aK = true;
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
    if (this.jdField_P_of_type_Boolean)
    {
      y();
      BaseApplicationImpl.getApplication().getSharedPreferences(ShortVideoGuideUtil.jdField_a_of_type_JavaLangString, 4).edit().putBoolean("is_showed_ptv_guide", true).commit();
    }
  }
  
  private void U()
  {
    SharedPreferences localSharedPreferences;
    if (this.ah)
    {
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("flow_filter_reddot_sp", 4);
      if (!localSharedPreferences.getBoolean("flow_filter_reddot_key", false)) {
        localSharedPreferences.edit().putBoolean("flow_filter_reddot_key", true).commit();
      }
    }
    if (this.ai)
    {
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("flow_filter_reddot_pkg_sp" + ((AppInterface)getAppRuntime()).getCurrentAccountUin(), 4);
      if (!localSharedPreferences.getBoolean("flow_filter_reddot_key", false)) {
        localSharedPreferences.edit().putBoolean("flow_filter_reddot_key", true).commit();
      }
    }
  }
  
  private void V()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "initVideoFilter");
    }
    ThreadManager.post(new NewFlowCameraActivity.20(this), 5, null, true);
  }
  
  private void W()
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
  
  private void X()
  {
    ShortVideoCaptureController.a(this);
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_is_cancel_from_music", 4);
    boolean bool = localSharedPreferences.getBoolean("sp_is_cancel_from_music_key", true);
    if ((!this.jdField_w_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1))
    {
      ThreadManager.postImmediately(new NewFlowCameraActivity.22(this), null, false);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    View localView = findViewById(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131367151);
    if (QLog.isColorLevel()) {
      QLog.d("face", 2, "onResume needChangeNewSurfaceView=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean + "mIsNeedSetup=" + this.jdField_z_of_type_Boolean);
    }
    this.jdField_z_of_type_Boolean = true;
    if (this.jdField_z_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean = true;
    }
    int i1;
    if (((localView == null) || (this.jdField_z_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean)) && (!this.aL))
    {
      i1 = 1;
      if (i1 == 0) {
        break label283;
      }
      Looper.myQueue().addIdleHandler(new NewFlowCameraActivity.23(this, bool, localSharedPreferences));
    }
    for (;;)
    {
      this.jdField_z_of_type_Boolean = false;
      this.jdField_y_of_type_Boolean = false;
      this.aw = false;
      if ((this.af) && (!this.ad) && (!this.ae))
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        this.af = false;
      }
      if (this.jdField_S_of_type_Int == 1) {
        QzoneOnlineTimeCollectRptService.getInstance().beginTrace(4);
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
  
  private void Y()
  {
    float f1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null)
    {
      RMVideoClipSpec localRMVideoClipSpec = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(this.jdField_a_of_type_Double, this.jdField_b_of_type_Double, f1, localRMVideoClipSpec.jdField_e_of_type_Int);
    }
  }
  
  private void Z()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter(null);
    CompoundProcessor localCompoundProcessor = RichmediaClient.a().a().a(this.jdField_d_of_type_JavaLangString);
    if (localCompoundProcessor != null)
    {
      localCompoundProcessor.a(103);
      return;
    }
    g();
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 90: 
    default: 
      return 0;
    case 0: 
      return 270;
    case 180: 
      return 90;
    }
    return 180;
  }
  
  @NonNull
  private Bitmap a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.jdField_g_of_type_Int / 8, this.jdField_h_of_type_Int / 8, this.jdField_A_of_type_Boolean, false, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec);
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
    //   16: invokevirtual 1052	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: astore 5
    //   21: aload 5
    //   23: getstatic 1058	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: aconst_null
    //   30: invokevirtual 1064	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore_0
    //   34: aload_0
    //   35: ifnull +216 -> 251
    //   38: aload_0
    //   39: invokeinterface 1069 1 0
    //   44: istore_2
    //   45: iload_2
    //   46: ifeq +205 -> 251
    //   49: aload_0
    //   50: aload_0
    //   51: ldc_w 1071
    //   54: invokeinterface 1075 2 0
    //   59: invokeinterface 1077 2 0
    //   64: istore_1
    //   65: invokestatic 274	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +30 -> 98
    //   71: ldc_w 276
    //   74: iconst_2
    //   75: new 217	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   82: ldc_w 1079
    //   85: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: iload_1
    //   89: invokevirtual 281	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 284	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aload 5
    //   100: iload_1
    //   101: i2l
    //   102: iconst_3
    //   103: aconst_null
    //   104: invokestatic 1085	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   107: astore_3
    //   108: aload_3
    //   109: ifnull +15 -> 124
    //   112: aload_0
    //   113: ifnull +9 -> 122
    //   116: aload_0
    //   117: invokeinterface 1088 1 0
    //   122: aload_3
    //   123: areturn
    //   124: aload_0
    //   125: invokeinterface 1091 1 0
    //   130: istore_2
    //   131: iload_2
    //   132: ifne +113 -> 245
    //   135: aload_3
    //   136: astore 4
    //   138: aload_0
    //   139: ifnull -127 -> 12
    //   142: aload_0
    //   143: invokeinterface 1088 1 0
    //   148: aload_3
    //   149: areturn
    //   150: astore 4
    //   152: aconst_null
    //   153: astore_0
    //   154: aload 4
    //   156: invokevirtual 905	java/lang/Exception:printStackTrace	()V
    //   159: aload_0
    //   160: astore 4
    //   162: aload_3
    //   163: ifnull -151 -> 12
    //   166: aload_3
    //   167: invokeinterface 1088 1 0
    //   172: aload_0
    //   173: areturn
    //   174: astore_3
    //   175: aconst_null
    //   176: astore_0
    //   177: aload_0
    //   178: ifnull +9 -> 187
    //   181: aload_0
    //   182: invokeinterface 1088 1 0
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
      return HardCodeUtil.a(2131707460);
    case 1: 
      return HardCodeUtil.a(2131707450);
    case 4: 
      return HardCodeUtil.a(2131707476);
    case 16: 
      return HardCodeUtil.a(2131707483);
    case 64: 
      return HardCodeUtil.a(2131707489);
    }
    return HardCodeUtil.a(2131707472);
  }
  
  private void a(int paramInt1, String paramString1, String paramString2, LocalMediaInfo paramLocalMediaInfo, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.a();
      if ((localObject != null) && (!TextUtils.isEmpty(((FilterDesc)localObject).name))) {
        FlowCameraMqqAction.a("", "0X8007805", "", "", ((FilterDesc)localObject).name, "");
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
    if (this.aE)
    {
      VideoEditReport.b(3);
      if (paramInt1 != 10003) {
        break label561;
      }
      paramInt3 = 5;
      if (this.aE) {
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
      if (this.jdField_j_of_type_Boolean)
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
      if (this.jdField_j_of_type_Boolean)
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
      if (this.jdField_r_of_type_Int == 102)
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
        if ((this.aE) && (this.jdField_P_of_type_Int == 0))
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
          paramString1.putExtra("entrance_type", this.jdField_r_of_type_Int);
          startActivityForResult(paramString1, i1);
          overridePendingTransition(0, 0);
          this.aw = true;
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
    this.jdField_q_of_type_Int = paramIntent.getIntExtra("edit_video_type", 0);
    this.aE = paramIntent.getBooleanExtra("from_web_to_share", false);
    if (paramBundle != null)
    {
      this.az = paramBundle.getBoolean("flow_camera_disable_beauty_filter", true);
      this.aA = MediaCodecDPC.b();
      this.aF = paramBundle.getBoolean("support_video_shot", true);
      this.aG = paramBundle.getBoolean("support_photo_shot", true);
      this.jdField_O_of_type_Int = paramBundle.getInt("default_camera_mode", 1);
      this.aI = paramBundle.getBoolean("default_open_template", false);
      this.aJ = paramBundle.getBoolean("default_use_first_template", false);
      this.aH = paramBundle.getBoolean("default_show_template_btn", true);
      this.jdField_P_of_type_Int = paramBundle.getInt("default_deal_type", 1);
      this.jdField_Q_of_type_Int = paramBundle.getInt("support_heart_template", 0);
      this.jdField_w_of_type_JavaLangString = paramBundle.getString("h5_activity_id", "");
      localStringBuilder.append("supportVideo:").append(this.aF);
      localStringBuilder.append(", supportPhoto:").append(this.aG);
      localStringBuilder.append(", cameramode:").append(this.jdField_O_of_type_Int);
      localStringBuilder.append(", beauty:").append(this.az);
      localStringBuilder.append(", unfoldTemplate:").append(this.aI);
      localStringBuilder.append(", usefirstTemplate:").append(this.aJ);
      localStringBuilder.append(", showPtvBtn:").append(this.aH);
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
      this.ac = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(16);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(4);
  }
  
  private void a(PublishParam paramPublishParam)
  {
    PtvFilterUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, paramPublishParam.jdField_b_of_type_JavaLangString);
    ad();
    this.jdField_a_of_type_Boolean = false;
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
    float f1 = this.jdField_g_of_type_Int * 1.0F / this.jdField_h_of_type_Int;
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
      if (!this.jdField_A_of_type_Boolean) {
        break label382;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(2, paramRMVideoClipSpec, this.jdField_l_of_type_Int);
    }
    int i2;
    int i3;
    for (;;)
    {
      paramRMVideoClipSpec.jdField_e_of_type_Int = paramRMVideoClipSpec.jdField_c_of_type_Int;
      paramRMVideoClipSpec.jdField_f_of_type_Int = paramRMVideoClipSpec.jdField_d_of_type_Int;
      i2 = i5;
      i3 = i4;
      if (CodecParam.VIDEO_RATIO_MOL > 0)
      {
        i2 = i5;
        i3 = i4;
        if (CodecParam.VIDEO_RATIO_MOL < CodecParam.VIDEO_RATIO_DEN)
        {
          f1 = CodecParam.VIDEO_RATIO_MOL * 1.0F / CodecParam.VIDEO_RATIO_DEN;
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
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(5, paramRMVideoClipSpec, this.jdField_m_of_type_Int);
    }
    label398:
    int i4 = paramRMVideoClipSpec.jdField_c_of_type_Int % i1;
    int i5 = paramRMVideoClipSpec.jdField_d_of_type_Int % i1;
    paramRMVideoClipSpec.jdField_c_of_type_Int -= i4;
    paramRMVideoClipSpec.jdField_d_of_type_Int -= i5;
    if (this.jdField_A_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(2, paramRMVideoClipSpec, this.jdField_l_of_type_Int);
    }
    for (;;)
    {
      paramRMVideoClipSpec.jdField_e_of_type_Int = paramRMVideoClipSpec.jdField_c_of_type_Int;
      paramRMVideoClipSpec.jdField_f_of_type_Int = paramRMVideoClipSpec.jdField_d_of_type_Int;
      i2 = i5;
      i3 = i4;
      if (CodecParam.VIDEO_RATIO_MOL <= 0) {
        break;
      }
      i2 = i5;
      i3 = i4;
      if (CodecParam.VIDEO_RATIO_MOL >= CodecParam.VIDEO_RATIO_DEN) {
        break;
      }
      f1 = CodecParam.VIDEO_RATIO_MOL * 1.0F / CodecParam.VIDEO_RATIO_DEN;
      paramRMVideoClipSpec.jdField_e_of_type_Int = ((int)(paramRMVideoClipSpec.jdField_c_of_type_Int * f1));
      paramRMVideoClipSpec.jdField_f_of_type_Int = ((int)(f1 * paramRMVideoClipSpec.jdField_d_of_type_Int));
      i2 = i5;
      i3 = i4;
      break;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(5, paramRMVideoClipSpec, this.jdField_m_of_type_Int);
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      this.jdField_o_of_type_Boolean = false;
    }
    if (this.an)
    {
      if (FlowCameraConstant.jdField_a_of_type_Int != 1) {
        break label47;
      }
      j(false);
    }
    while (this.jdField_q_of_type_Int == 10002)
    {
      e(paramString);
      return;
      label47:
      if (this.jdField_p_of_type_Int == 0) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.c(false);
      }
    }
    if (paramString == null) {}
    for (int i3 = -3;; i3 = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PTV.NewFlowCameraActivity", 2, "finishShotPhoto " + paramString);
      }
      int i2 = getIntent().getIntExtra("edit_video_type", 0);
      boolean bool1;
      int i1;
      int i4;
      int i6;
      if (i2 != 10002)
      {
        bool1 = true;
        i1 = getIntent().getIntExtra("extra.busi_type", 2);
        i4 = getIntent().getIntExtra("entry_source", 0);
        if ((i1 == 3) && ((i4 == 1) || (i4 == 2)))
        {
          a("612", "5", "0", true);
          if (QLog.isColorLevel()) {
            QLog.i("PTV.NewFlowCameraActivity", 2, "QZone click take photo report");
          }
        }
        if (i2 == 10002) {
          i1 = 1;
        }
        i6 = getIntent().getIntExtra("edit_video_type", 0);
        i2 = 0;
        if (!this.aE) {
          break label901;
        }
        i2 = 3;
        i1 = 6;
      }
      label241:
      boolean bool2;
      Object localObject;
      label901:
      label984:
      label990:
      label1002:
      label1005:
      label1011:
      for (;;)
      {
        bool2 = getIntent().getBooleanExtra("go_publish_activity", false);
        localObject = EditPicActivity.a(this, paramString, true, true, true, bool1, true, false, false, false, i1, a(), i2, bool2, null);
        if (this.aE)
        {
          ((Intent)localObject).putExtra("shareto_web_mode", this.jdField_P_of_type_Int);
          ((Intent)localObject).putExtra("edit_video_call_back", this.jdField_f_of_type_JavaLangString);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null) {
          ((Intent)localObject).putExtra("mCurrentTemplatePath", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.jdField_a_of_type_JavaLangString);
        }
        ((Intent)localObject).putExtra("qcamera_photo_filepath", paramString);
        ((Intent)localObject).putExtra("qcamera_rotate", this.jdField_n_of_type_Int);
        if (FlowCameraConstant.jdField_a_of_type_Int == 2) {}
        for (i4 = 0;; i4 = 1)
        {
          ((Intent)localObject).putExtra("camera_type", 103);
          ((Intent)localObject).putExtra("camera_front_back", i4);
          ((Intent)localObject).putExtra("camera_capture_method", this.jdField_p_of_type_Int);
          ((Intent)localObject).putExtra("babyq_ability", getIntent().getLongExtra("babyq_ability", 0L));
          if (i1 == 3)
          {
            ((Intent)localObject).putExtra("key_latitude", getIntent().getDoubleExtra("key_latitude", 4.9E-324D));
            ((Intent)localObject).putExtra("key_longtitude", getIntent().getDoubleExtra("key_longtitude", 4.9E-324D));
          }
          FlowCameraMqqAction.a(getIntent().getIntExtra("edit_video_type", -1), "", "0X8007818", null);
          int i5 = -1;
          bool2 = false;
          bool1 = bool2;
          i1 = i5;
          i2 = i5;
          try
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null)
            {
              i2 = i5;
              paramString = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a();
              bool1 = bool2;
              i1 = i5;
              if (paramString != null)
              {
                i2 = i5;
                i5 = Integer.valueOf(paramString.id).intValue();
                i2 = i5;
                boolean bool3 = paramString.hasGesture();
                bool1 = bool2;
                i1 = i5;
                if (bool3)
                {
                  bool1 = true;
                  i1 = i5;
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
              i1 = i2;
              if (QLog.isColorLevel())
              {
                QLog.i("PTV.NewFlowCameraActivity", 2, "id not integer ");
                bool1 = bool2;
                i1 = i2;
                continue;
                bool1 = false;
                continue;
                paramString.putExtra("editpic_cameratype", 2);
                continue;
                continue;
                paramString = (String)localObject;
              }
            }
          }
          ((Intent)localObject).putExtra("camera_filter_id", i1);
          ((Intent)localObject).putExtra("camera_has_gesture_filter", bool1);
          if (i3 != -1) {
            break label984;
          }
          bool1 = true;
          NewFlowCameraReporter.a(bool1, i4, i1, this.jdField_p_of_type_Int);
          paramString = (SessionInfo)((Intent)localObject).getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
          if (paramString == null) {
            break label1005;
          }
          ((Intent)localObject).putExtra("uin", paramString.jdField_a_of_type_JavaLangString);
          ((Intent)localObject).putExtra("uintype", paramString.jdField_a_of_type_Int);
          ((Intent)localObject).putExtra("troop_uin", paramString.jdField_b_of_type_JavaLangString);
          ((Intent)localObject).putExtra("uinname", paramString.jdField_d_of_type_JavaLangString);
          paramString = AIOUtils.a((Intent)localObject, null);
          if (getIntent().getIntExtra("edit_video_type", 0) == 10010) {
            paramString.putExtra("sub_business_id", 104);
          }
          localObject = SplashActivity.class.getName();
          str = getIntent().getStringExtra("f_a_a_n");
          if ((str == null) || (!str.equals(ChatActivity.class.getName()))) {
            break label1002;
          }
          localObject = str;
          NewFlowCameraReporter.a("finish");
          NewFlowCameraReporter.a(paramString);
          str = paramString.getStringExtra("pic_confirm_text");
          if (str != null) {
            paramString.putExtra("extra_publish_text", str);
          }
          paramString.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", (String)localObject);
          paramString.putExtra("key_activity_code", getIntent().getStringExtra("key_activity_code"));
          if ((i6 == 10000) || (i6 == 10004) || (i6 == 10010))
          {
            if (!paramBoolean) {
              break label990;
            }
            paramString.putExtra("editpic_cameratype", 1);
          }
          startActivityForResult(paramString, 1012);
          FlowCameraMqqAction.a("", "0X80075C1", "", "", "", "");
          return;
          bool1 = false;
          break;
          if (i6 == 10004)
          {
            i2 = 2;
            break label241;
          }
          if (i6 == 10000)
          {
            i2 = 1;
            break label241;
          }
          if (i6 != 10010) {
            break label1011;
          }
          i2 = 10;
          break label241;
        }
      }
    }
  }
  
  private void a(boolean paramBoolean, GapDataCollector.RefreshData paramRefreshData)
  {
    paramRefreshData = BaseApplicationImpl.getApplication().getSharedPreferences("DynamicAdjustment", 4);
    int i1;
    Size localSize;
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynamicAdjustment", 2, "shift down triggered");
      }
      i1 = paramRefreshData.getInt("SVDNAdjustment_quality_down_mark", 1);
      if (i1 >= this.jdField_J_of_type_Int)
      {
        i1 = 0;
        if (i1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          localSize = (Size)this.jdField_a_of_type_JavaUtilList.get(i1);
          if ((localSize.jdField_b_of_type_Int != GloableValue.jdField_d_of_type_Int) || (localSize.jdField_a_of_type_Int != GloableValue.jdField_c_of_type_Int)) {
            break label321;
          }
          if (i1 != 0) {
            break label144;
          }
          paramRefreshData.edit().putInt("SVDNAdjustment_quality_down_mark", 1).commit();
          if (QLog.isColorLevel()) {
            QLog.d("DynamicAdjustment", 2, "the lowest resolution reached");
          }
        }
      }
    }
    label144:
    label321:
    label718:
    label720:
    do
    {
      for (;;)
      {
        return;
        localSize = (Size)this.jdField_a_of_type_JavaUtilList.get(i1 - 1);
        paramRefreshData.edit().putString("SVDNAdjustment_quality_resolution", localSize.jdField_a_of_type_Int + "*" + localSize.jdField_b_of_type_Int).putInt("SVDNAdjustment_quality_down_mark", 1).putInt("SVDNAdjustment_quality_up_mark", 1).putInt("SVDNAdjustment_quality_up_threshold", (int)(this.jdField_L_of_type_Int * this.jdField_c_of_type_Double)).commit();
        if (QLog.isColorLevel())
        {
          QLog.d("DynamicAdjustment", 2, "adjustment finished , resolution down to : " + localSize.jdField_a_of_type_Int + "*" + localSize.jdField_b_of_type_Int + "    threshold down to : " + this.jdField_L_of_type_Int * this.jdField_c_of_type_Double);
          return;
          i1 += 1;
          break;
          paramRefreshData.edit().putInt("SVDNAdjustment_quality_down_mark", i1 + 1).putInt("SVDNAdjustment_quality_up_mark", 1).commit();
          if (QLog.isColorLevel())
          {
            QLog.d("DynamicAdjustment", 2, "mark + 1 = " + (i1 + 1));
            return;
            if (QLog.isColorLevel()) {
              QLog.d("DynamicAdjustment", 2, "shift up triggered");
            }
            i1 = paramRefreshData.getInt("SVDNAdjustment_quality_up_mark", 1);
            if (i1 < this.jdField_K_of_type_Int) {
              break label720;
            }
            i1 = 0;
            for (;;)
            {
              if (i1 >= this.jdField_a_of_type_JavaUtilList.size()) {
                break label718;
              }
              localSize = (Size)this.jdField_a_of_type_JavaUtilList.get(i1);
              if ((localSize.jdField_b_of_type_Int == GloableValue.jdField_d_of_type_Int) && (localSize.jdField_a_of_type_Int == GloableValue.jdField_c_of_type_Int))
              {
                if (i1 == this.jdField_a_of_type_JavaUtilList.size() - 1)
                {
                  paramRefreshData.edit().putInt("SVDNAdjustment_quality_up_mark", 1).commit();
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("DynamicAdjustment", 2, "the highest resolution reached");
                  return;
                }
                localSize = (Size)this.jdField_a_of_type_JavaUtilList.get(i1 + 1);
                paramRefreshData.edit().putString("SVDNAdjustment_quality_resolution", localSize.jdField_a_of_type_Int + "*" + localSize.jdField_b_of_type_Int).putInt("SVDNAdjustment_quality_up_mark", 1).putInt("SVDNAdjustment_quality_down_mark", 1).putInt("SVDNAdjustment_quality_down_threshold", (int)(this.jdField_M_of_type_Int * this.jdField_d_of_type_Double)).commit();
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("DynamicAdjustment", 2, "adjustment finished , resolution up to :  " + localSize.jdField_a_of_type_Int + "*" + localSize.jdField_b_of_type_Int + "    threshold up to : " + this.jdField_M_of_type_Int * this.jdField_d_of_type_Double);
                return;
              }
              i1 += 1;
            }
          }
        }
      }
      paramRefreshData.edit().putInt("SVDNAdjustment_quality_up_mark", i1 + 1).putInt("SVDNAdjustment_quality_down_mark", 1).commit();
    } while (!QLog.isColorLevel());
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
      if (this.jdField_A_of_type_Boolean) {
        break label507;
      }
      if (aP) {
        break label487;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.jdField_g_of_type_Int, this.jdField_h_of_type_Int, this.jdField_A_of_type_Boolean, false, null);
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
      this.jdField_x_of_type_Boolean = true;
      if (!paramBoolean) {
        break label527;
      }
      b(true);
      label194:
      VideoFilterTools.a().b();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean) && (!this.jdField_f_of_type_Boolean)) {
        c(0, true);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.jdField_a_of_type_JavaLangString);
      }
      if (((this.jdField_q_of_type_Int == 10002) || (this.jdField_q_of_type_Int == 10012)) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean) && (!this.jdField_f_of_type_Boolean)) {
        VideoAnimation.a(this.jdField_a_of_type_AndroidWidgetButton, -8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      }
      if ((b()) && (this.jdField_f_of_type_AndroidWidgetButton != null))
      {
        localObject = this.jdField_f_of_type_AndroidWidgetButton;
        if (!this.jdField_W_of_type_Boolean) {
          break label552;
        }
        paramInt = 0;
        label338:
        ((Button)localObject).setVisibility(paramInt);
        if (this.jdField_W_of_type_Boolean) {
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
      an();
      ao();
      this.ay = false;
      this.jdField_d_of_type_Boolean = false;
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.a();
      }
      return true;
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130839647);
      break;
      label487:
      this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(-16777216));
      break;
      label507:
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130839647);
      break;
      FlowCameraConstant.jdField_a_of_type_Int = 1;
      break label173;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean)
      {
        A();
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
    if (this.jdField_i_of_type_Boolean) {}
    do
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.c();
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4) || (FlowCameraConstant.jdField_a_of_type_Int == 1) || (this.jdField_G_of_type_Boolean));
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView.a(f1, f2);
    paramMotionEvent = new CameraFocusParams();
    paramMotionEvent.jdField_a_of_type_Float = f1;
    paramMotionEvent.jdField_b_of_type_Float = f2;
    paramMotionEvent.jdField_a_of_type_Int = ((int)this.jdField_c_of_type_Float);
    paramMotionEvent.jdField_b_of_type_Int = ((int)this.jdField_d_of_type_Float);
    paramMotionEvent.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator;
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "[handleMessage] touch focus:" + f1 + " " + f2);
    }
    NewFlowCameraReporter.b();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(paramMotionEvent, new NewFlowCameraActivity.37(this));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.e();
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
      paramString = FontInterface.getDefaultFont(l1);
      if (paramString == null) {
        return false;
      }
      this.jdField_w_of_type_Int = paramString.fontId;
      this.jdField_x_of_type_Int = paramString.formatType;
      this.jdField_j_of_type_JavaLangString = paramString.fontUrl;
      int i1 = this.jdField_w_of_type_Int;
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
      E();
      return;
      g();
    }
  }
  
  private void ab()
  {
    if (this.an)
    {
      this.jdField_h_of_type_AndroidWidgetButton.setBackgroundResource(2130844171);
      this.jdField_h_of_type_AndroidWidgetButton.setContentDescription(HardCodeUtil.a(2131707490));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.d(true);
      return;
    }
    this.jdField_h_of_type_AndroidWidgetButton.setBackgroundResource(2130844169);
    this.jdField_h_of_type_AndroidWidgetButton.setContentDescription(HardCodeUtil.a(2131707477));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.d(false);
  }
  
  private void ac()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "setNightStatus " + this.ao);
    }
    if (this.ao)
    {
      this.jdField_i_of_type_AndroidWidgetButton.setBackgroundResource(2130844175);
      this.jdField_i_of_type_AndroidWidgetButton.setContentDescription(HardCodeUtil.a(2131707464));
      return;
    }
    this.jdField_i_of_type_AndroidWidgetButton.setBackgroundResource(2130844173);
    this.jdField_i_of_type_AndroidWidgetButton.setContentDescription(HardCodeUtil.a(2131707474));
  }
  
  private void ad()
  {
    if ((this.jdField_n_of_type_Int == 90) || (this.jdField_n_of_type_Int == 270)) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (FlowCameraConstant.jdField_a_of_type_Int == 1) {}
      for (int i2 = 1;; i2 = 0)
      {
        a("608", "1", "0", true);
        boolean bool = d();
        String str1 = "";
        Object localObject;
        label212:
        int i3;
        if (!bool)
        {
          FlowCameraMqqAction.a("", "0X8006A16", String.valueOf((int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double), "" + i1, "" + i2, "");
          localObject = new HashMap();
          ((HashMap)localObject).put("param_duration", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double));
          ((HashMap)localObject).put("param_orientation", String.valueOf(i1));
          if (!TextUtils.isEmpty(str1)) {
            ((HashMap)localObject).put("param_template", str1);
          }
          if (this.appInterface != null)
          {
            String str2 = this.appInterface.getCurrentAccountUin();
            StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplicationImpl.getContext());
            if (bool)
            {
              str1 = "actPtvUseTemplate";
              localStatisticCollector.collectPerformance(str2, str1, true, 0L, 0L, (HashMap)localObject, "");
            }
          }
          else
          {
            FlowCameraMqqAction.a("", "0X800795F", String.valueOf((int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double), "" + i1, "" + i2, "");
          }
        }
        else
        {
          label304:
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
              localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a();
              if ((localObject != null) && (((PtvTemplateManager.PtvTemplateInfo)localObject).hasGesture())) {
                FlowCameraMqqAction.a("", "0X80083B1", String.valueOf((int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double), "" + i1, "" + i2, str1);
              }
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter == null) {
              break label526;
            }
            i3 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a();
          } while (i3 >= this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.jdField_a_of_type_JavaUtilArrayList.size());
        }
        label526:
        for (str1 = ((PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.jdField_a_of_type_JavaUtilArrayList.get(i3)).name;; str1 = "")
        {
          LbsFilterStatusManager.a(this.appInterface, str1);
          break;
          str1 = "";
          break label304;
          str1 = "actPtvNotUseTemplate";
          break label212;
        }
      }
    }
  }
  
  private void ae()
  {
    jdField_c_of_type_Boolean = false;
    if (d())
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
      if (this.jdField_x_of_type_Boolean) {
        this.jdField_y_of_type_Boolean = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("face", 2, "click left hasChangeCamera" + this.jdField_x_of_type_Boolean);
      }
      E();
      return;
      FlowCameraMqqAction.b("", "0X8006A1B");
      break;
      label112:
      g();
    }
  }
  
  private void af()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "handleQQVideo(): onSendVideoClick mHwEncoder=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
    }
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new NewFlowCameraActivity.HandleEndVideoEncode(this, this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
  }
  
  private void ag()
  {
    this.jdField_D_of_type_Boolean = true;
    this.jdField_E_of_type_Boolean = false;
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
    if ((this.aE) && (this.aF) && (!this.aG) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_f_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "mCameraCapture clearAnimation!");
      }
    }
  }
  
  private void ah()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity.photo", 2, "finishShootShortVideo");
    }
    FlowCameraMqqAction.a(getIntent().getIntExtra("edit_video_type", -1), "", "", this.jdField_a_of_type_JavaUtilHashMap);
    FlowCameraMqqAction.a(getIntent().getIntExtra("edit_video_type", -1), "", "0X8007817", null);
    Object localObject;
    if (this.an)
    {
      if (FlowCameraConstant.jdField_a_of_type_Int == 1) {
        j(false);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidViewVelocityTracker;
      ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.jdField_t_of_type_Int);
      int i1 = (int)((VelocityTracker)localObject).getXVelocity();
      if ((!this.jdField_q_of_type_Boolean) && (Math.abs(i1) > this.jdField_s_of_type_Int)) {
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.fling(-i1);
      }
      al();
      ag();
      if (!this.jdField_q_of_type_Boolean) {
        break label291;
      }
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new NewFlowCameraActivity.HandleEndVideoEncode(this, this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
    }
    for (;;)
    {
      this.jdField_r_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.e();
        this.jdField_q_of_type_Boolean = false;
      }
      this.jdField_f_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_A_of_type_Int += 1;
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "ACTION_UP isBlueAnimEnd=" + this.jdField_e_of_type_Boolean);
      }
      if (this.jdField_e_of_type_Boolean)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a()) {
          break label400;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "gl_root.isBufferWriteOK()");
        }
        s();
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
    a(this, 2131694889);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.lockFrameSync();
    }
    z();
    s();
  }
  
  private void ai()
  {
    VideoAnimation.a(this.jdField_f_of_type_AndroidWidgetImageView, false, 250);
    a(1002, 0, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a().b();
    if (this.jdField_f_of_type_AndroidWidgetButton != null) {
      this.jdField_f_of_type_AndroidWidgetButton.setEnabled(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setEnabled(true);
  }
  
  private void aj()
  {
    int i2 = 1;
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "createHwEncode: Build.MANUFACTURER = " + Build.MANUFACTURER + " Build.MODEL = " + Build.MODEL + " HwEnvData.supportRecordAndEncode() = " + HwEnvData.b());
    }
    Object localObject1 = (SessionInfo)super.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
    Object localObject2;
    int i1;
    if ((localObject1 != null) && (HwEnvData.b()) && (this.ac) && (this.jdField_S_of_type_Int == 0) && (VideoEnvironment.supportSubmitCallback()) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean))
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = new SVHwEncoder();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, ((RMVideoClipSpec)localObject2).jdField_e_of_type_Int, ((RMVideoClipSpec)localObject2).jdField_f_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(-1, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_Int * 1000);
      if (CodecParam.mAudioChannel != 16) {
        break label328;
      }
      i1 = 1;
    }
    for (;;)
    {
      if (CodecParam.mAudioFormat == 2) {
        i2 = 2;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(CodecParam.mAudioSampleRate, i1, 128000, i2);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setHwEncoder(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.a.getAndSet(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
        }
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwAutoSegmentMgr.a.getAndSet(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
        localObject2 = RichmediaClient.a().a();
        Y();
        localObject1 = ((VideoCompoundController)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder, (SessionInfo)localObject1, 2);
        this.jdField_d_of_type_JavaLangString = ((CompoundProcessor)localObject1).a();
        LogTag.a(this.jdField_d_of_type_JavaLangString, "start", "[peak]");
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a((SVHwOutputNotify)localObject1, null, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_e_of_type_Boolean);
        return;
        label328:
        if (CodecParam.mAudioChannel != 12) {
          break label353;
        }
        i1 = 2;
        break;
        if (CodecParam.mAudioFormat != 3) {
          i2 = 2;
        }
      }
      label353:
      i1 = 1;
    }
  }
  
  private void ak()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  private void al()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  private void am()
  {
    if (this.ap) {
      this.jdField_i_of_type_AndroidWidgetButton.setVisibility(0);
    }
  }
  
  private void an()
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
  
  private void ao()
  {
    if (FlowCameraConstant.jdField_a_of_type_Int == 1) {}
    for (String str = HardCodeUtil.a(2131707486);; str = HardCodeUtil.a(2131707468))
    {
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(HardCodeUtil.a(2131707469) + str + HardCodeUtil.a(2131707458));
      return;
    }
  }
  
  private void ap()
  {
    Typeface localTypeface = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setTextEffect(this.jdField_k_of_type_JavaLangString);
    String str = FontInterface.getTrueTypeFont(this.jdField_w_of_type_Int, null, null, null);
    if (TextUtils.isEmpty(str)) {
      this.jdField_w_of_type_Int = -1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setTypeface(localTypeface);
      return;
      localTypeface = Typeface.createFromFile(str);
    }
  }
  
  private void aq()
  {
    c("正在合成gif...");
    new NewFlowCameraActivity.EncodeTask(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$VideoProcessListener, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a(), true).execute(new Void[0]);
  }
  
  private void ar()
  {
    if (!this.aA) {
      if (QLog.isColorLevel()) {
        QLog.i("PTV.NewFlowCameraActivity", 2, "mbeBeautySurport is false");
      }
    }
    while (!this.az) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)findViewById(2131363564));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(100);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new NewFlowCameraActivity.54(this));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getBaseContext().getResources().getDrawable(2130846003);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363566));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = null;
  }
  
  private void as()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("newflag", true);
    localIntent.putExtra("refer", "schemeActiveFeeds");
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
    localIntent.addFlags(805306368);
    QZoneHelper.forwardToFriendFeed(this, this.appInterface.getCurrentAccountUin(), localIntent, -1);
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
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.updateUISize(paramInt1, paramInt2, f1, false, ScreenUtil.dip2px(5.0F));
    localObject = this.jdField_f_of_type_AndroidWidgetImageView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = paramInt1;
    ((ViewGroup.LayoutParams)localObject).height = paramInt2;
    this.jdField_f_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1011)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
      }
      if (paramInt2 != 0) {
        break label168;
      }
      if (QLog.isColorLevel()) {
        QLog.i("PTV.NewFlowCameraActivity", 2, "Press the cancel button state=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) {
        FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
      }
      a("608", "2", "0", true);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4))
      {
        this.au = true;
        ae();
        this.av = true;
        this.jdField_z_of_type_Boolean = true;
      }
    }
    label168:
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return;
      } while ((paramInt2 != -1) || (paramIntent == null));
      this.jdField_m_of_type_JavaLangString = paramIntent.getStringExtra("key_content");
      if (this.jdField_m_of_type_JavaLangString == null) {
        this.jdField_m_of_type_JavaLangString = "";
      }
      this.jdField_d_of_type_Int = paramIntent.getIntExtra("key_priv", 1);
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)paramIntent.getSerializableExtra("key_priv_uin_list"));
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      this.jdField_Q_of_type_Boolean = paramIntent.getBooleanExtra("key_topic_sync_qzone", this.jdField_Q_of_type_Boolean);
      this.jdField_w_of_type_Int = paramIntent.getIntExtra("key_font_id", -1);
      this.jdField_x_of_type_Int = paramIntent.getIntExtra("key_font_format_type", 0);
      this.jdField_j_of_type_JavaLangString = paramIntent.getStringExtra("key_font_url");
      this.jdField_y_of_type_Int = paramIntent.getIntExtra("key_super_font_id", -1);
      this.jdField_k_of_type_JavaLangString = paramIntent.getStringExtra("key_super_font_info");
      bool1 = paramIntent.getBooleanExtra("key_generate_gif", false);
      bool2 = paramIntent.getBooleanExtra("key_timer_delete", false);
      paramIntent = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
    } while (paramIntent == null);
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "publishParam : " + paramIntent.toString());
    }
    getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
    float f1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a();
    paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
    f(paramInt2);
    paramInt1 = paramInt2;
    if (paramInt2 <= 0)
    {
      paramInt1 = paramInt2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
        paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getRemainedRecordFrames(0);
      }
    }
    paramInt2 = paramInt1;
    if (paramInt1 <= 0) {
      paramInt2 = paramIntent.jdField_g_of_type_Int;
    }
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = this.jdField_V_of_type_Int;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "start sendShortVideoWithMood --- ");
    }
    paramInt2 = getIntent().getIntExtra("entry_source", 0);
    FlowCameraMqqAction.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr, f1, false, this.jdField_a_of_type_Double, this.jdField_b_of_type_Double, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface, false, i1, paramInt1, this.jdField_m_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_h_of_type_Boolean, this.jdField_h_of_type_JavaLangString, this.jdField_Q_of_type_Boolean, paramIntent.jdField_c_of_type_JavaLangString, paramIntent.jdField_d_of_type_JavaLangString, this.jdField_w_of_type_Int, this.jdField_x_of_type_Int, this.jdField_j_of_type_JavaLangString, paramIntent.jdField_b_of_type_JavaLangString, paramIntent.jdField_a_of_type_Long, paramIntent.jdField_f_of_type_Int, bool1, paramInt2, bool2, this.jdField_y_of_type_Int, this.jdField_k_of_type_JavaLangString);
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    int i2 = 0;
    if ((this.jdField_e_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetSeekBar == null)) {
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707485) + paramInt + "%");
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
    this.aM = paramBundle.getBoolean("enable_local_video", false);
    this.jdField_h_of_type_Boolean = paramBundle.getBoolean("enable_edit_video", false);
    this.am = paramBundle.getBoolean("is_qzone_vip", false);
    this.jdField_h_of_type_JavaLangString = paramBundle.getString("topic_id");
    if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_O_of_type_Boolean = bool;
      this.jdField_P_of_type_Boolean = paramBundle.getBoolean("enter_ptu", false);
      this.jdField_V_of_type_Boolean = paramBundle.getBoolean("enable_priv_list", true);
      this.jdField_R_of_type_Boolean = paramBundle.getBoolean("enable_input_text", true);
      this.jdField_S_of_type_Boolean = paramBundle.getBoolean("enable_sync_qzone", false);
      this.jdField_T_of_type_Boolean = paramBundle.getBoolean("enable_origin_video", false);
      this.jdField_T_of_type_Boolean = paramBundle.getBoolean("enable_origin_video", false);
      this.jdField_i_of_type_JavaLangString = paramBundle.getString("confirm_text");
      this.jdField_U_of_type_Boolean = paramBundle.getBoolean("enable_edit_button", true);
      this.jdField_W_of_type_Boolean = paramBundle.getBoolean("enable_local_button", true);
      this.aN = paramBundle.getBoolean("enable_front", false);
      this.jdField_R_of_type_Int = paramBundle.getInt("set_sdcard_min_size", 0);
      this.jdField_S_of_type_Int = paramBundle.getInt("from_type", 0);
      this.jdField_T_of_type_Int = paramBundle.getInt("clip_strategy", 1);
      FlowCameraMqqAction.a(this.jdField_q_of_type_Int);
      if ((this.jdField_R_of_type_Int >= 57671680L) && (this.jdField_R_of_type_Int <= 314572800L)) {
        StorageManager.jdField_a_of_type_Long = this.jdField_R_of_type_Int;
      }
      if (this.jdField_j_of_type_Boolean) {
        StorageManager.jdField_a_of_type_Long = StorageManager.jdField_b_of_type_Long;
      }
      this.jdField_q_of_type_JavaLangString = paramBundle.getString("short_video_refer");
      this.jdField_r_of_type_JavaLangString = paramBundle.getString("set_user_callback");
      a(paramBundle, this.jdField_q_of_type_JavaLangString);
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
      localVideoSendPublicParam.jdField_a_of_type_Boolean = this.jdField_h_of_type_Boolean;
      localVideoSendPublicParam.jdField_j_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
      localVideoSendPublicParam.jdField_b_of_type_Boolean = this.jdField_Q_of_type_Boolean;
      if (paramPublishParam.jdField_i_of_type_Int != 1) {
        break label343;
      }
      bool = true;
      localVideoSendPublicParam.jdField_c_of_type_Boolean = bool;
      if (this.jdField_q_of_type_Int == 10007) {
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
  
  private void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
      }
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getExtras();
        if (paramIntent.containsKey("permission_code")) {
          this.jdField_d_of_type_Int = paramIntent.getInt("permission_code");
        }
        if (paramIntent.containsKey("uin_list"))
        {
          if (this.jdField_a_of_type_JavaUtilArrayList == null) {
            this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          }
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          ArrayList localArrayList = paramIntent.getStringArrayList("uin_list");
          if (localArrayList != null) {
            this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
          }
        }
        if (a(this.jdField_d_of_type_Int))
        {
          this.jdField_c_of_type_JavaLangString = paramIntent.getString("key_setting_raw_json");
          this.jdField_b_of_type_JavaLangString = paramIntent.getString("key_selected_tag");
        }
        O();
      }
    }
  }
  
  private void c(int paramInt, boolean paramBoolean)
  {
    int i1;
    if ((this.aE) && (!this.aH))
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
  
  private void d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1009)
    {
      this.aQ = false;
      this.mNeedPauseRichMedia = false;
      if (this.jdField_h_of_type_AndroidViewView != null) {
        this.jdField_h_of_type_AndroidViewView.setVisibility(8);
      }
      if (paramIntent != null)
      {
        Bundle localBundle = paramIntent.getExtras();
        Object localObject;
        if (localBundle.containsKey("extra_key_bundle_priv_key"))
        {
          paramIntent = localBundle.getBundle("extra_key_bundle_priv_key");
          if (paramIntent != null)
          {
            this.jdField_d_of_type_Int = paramIntent.getInt("permission_code");
            if (this.jdField_a_of_type_JavaUtilArrayList == null) {
              this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            }
            this.jdField_a_of_type_JavaUtilArrayList.clear();
            localObject = paramIntent.getStringArrayList("uin_list");
            if (localObject != null) {
              this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
            }
            if (a(this.jdField_d_of_type_Int))
            {
              this.jdField_c_of_type_JavaLangString = paramIntent.getString("key_setting_raw_json");
              this.jdField_b_of_type_JavaLangString = paramIntent.getString("key_selected_tag");
            }
            O();
          }
        }
        if (localBundle.containsKey("extraIsTopicSyncQzone"))
        {
          boolean bool = localBundle.getBoolean("extraIsTopicSyncQzone");
          this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        }
        if (localBundle.containsKey("contentIntentKey"))
        {
          localObject = localBundle.getString("contentIntentKey");
          paramIntent = (Intent)localObject;
          if (localObject == null) {
            paramIntent = "";
          }
          this.jdField_m_of_type_JavaLangString = paramIntent;
        }
        if (localBundle.containsKey("contentIntentKeyForVideoEditWithEmo"))
        {
          paramIntent = localBundle.getString("contentIntentKeyForVideoEditWithEmo");
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setText(paramIntent);
        }
        this.jdField_w_of_type_Int = localBundle.getInt("extra_key_font_id", -1);
        this.jdField_x_of_type_Int = localBundle.getInt("extra_key_font_format_type");
        this.jdField_j_of_type_JavaLangString = localBundle.getString("extra_key_font_url");
        this.jdField_y_of_type_Int = localBundle.getInt("extra_key_super_font_id", -1);
        this.jdField_k_of_type_JavaLangString = localBundle.getString("extra_key_super_font_info");
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(1009);
      }
    }
  }
  
  private void d(String paramString)
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
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.c(paramString, str, new NewFlowCameraActivity.3(this, paramString, str));
    }
  }
  
  private void e(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1012)
    {
      if (paramInt2 != 0) {
        break label47;
      }
      if (QLog.isColorLevel()) {
        QLog.i("PTV.NewFlowCameraActivity", 2, "restart from edit pic");
      }
      this.au = true;
      E();
      this.av = true;
      this.jdField_z_of_type_Boolean = true;
    }
    label47:
    while ((paramInt2 != -1) || (paramIntent == null)) {
      return;
    }
    paramInt1 = paramIntent.getIntExtra("forward_to_someplace_from_shoot_quick", 0);
    paramInt2 = paramIntent.getIntExtra("forward_to_someplace_from_pre_guide", 0);
    if (paramInt1 == 0) {
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      if (paramInt1 == 1002)
      {
        as();
        this.jdField_a_of_type_Boolean = false;
        paramIntent.putExtra("open_leba_tab_fragment", true);
        setResult(-1, paramIntent);
        finish();
      }
      while (paramIntent.getBooleanExtra("go_publish_activity", false))
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
        this.jdField_Q_of_type_Boolean = paramIntent.getBooleanExtra("key_topic_sync_qzone", this.jdField_Q_of_type_Boolean);
        this.jdField_w_of_type_Int = paramIntent.getIntExtra("key_font_id", -1);
        this.jdField_x_of_type_Int = paramIntent.getIntExtra("key_font_format_type", 0);
        this.jdField_j_of_type_JavaLangString = paramIntent.getStringExtra("key_font_url");
        this.jdField_y_of_type_Int = paramIntent.getIntExtra("key_super_font_id", -1);
        this.jdField_k_of_type_JavaLangString = paramIntent.getStringExtra("key_super_font_info");
        ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        boolean bool = paramIntent.getBooleanExtra("key_timer_delete", false);
        QLog.i("PTV.NewFlowCameraActivity", 2, "get mSetTimerDelete: " + bool);
        QZoneHelper.publishPictureMoodSilently(this.jdField_m_of_type_JavaLangString, localArrayList, this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_w_of_type_Int, this.jdField_x_of_type_Int, this.jdField_j_of_type_JavaLangString, bool, this.jdField_y_of_type_Int, this.jdField_k_of_type_JavaLangString);
        finish();
        return;
        if (paramInt1 == 1003) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper.a(paramIntent, this.jdField_e_of_type_AndroidWidgetImageView);
        }
      }
      break;
    }
  }
  
  private void e(String paramString)
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
      if (this.jdField_r_of_type_Int == 102)
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
  
  private boolean e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "filter=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean;
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
  
  private void f(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1;
    Object localObject2;
    float f1;
    int i3;
    int i1;
    if ((paramInt1 == 10004) || (paramInt1 == 10010))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "quick shoot onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
      }
      if ((paramInt2 != -1) || (paramIntent == null)) {
        break label633;
      }
      localObject1 = (SessionInfo)paramIntent.getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      getIntent().putExtra("PhotoConst.SEND_SESSION_INFO", (Parcelable)localObject1);
      localObject2 = getIntent();
      if (paramInt1 != 10010) {
        break label525;
      }
      localObject1 = "forward_source_from_pre_guide";
      ((Intent)localObject2).putExtra((String)localObject1, true);
      localObject1 = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
      if (localObject1 != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString;
        localObject2 = (String)localObject2 + File.separator + "configure.txt";
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((PublishParam)localObject1).jdField_b_of_type_JavaLangString);
        FileUtils.a((String)localObject2, localStringBuilder.toString());
        getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
        f1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
        i3 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a();
        i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
        paramInt2 = i1;
        if (i1 <= 0)
        {
          paramInt2 = i1;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
            paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getRemainedRecordFrames(0);
          }
        }
        f(paramInt2);
        if (paramInt2 > 0) {
          break label722;
        }
        paramInt2 = this.jdField_V_of_type_Int;
      }
    }
    label525:
    label722:
    for (;;)
    {
      ad();
      this.jdField_a_of_type_Boolean = false;
      int i2 = paramIntent.getIntExtra("forward_to_someplace_from_shoot_quick", 0);
      i1 = i2;
      if (i2 == 0)
      {
        i1 = i2;
        if (paramInt1 == 10010) {
          i1 = paramIntent.getIntExtra("forward_to_someplace_from_pre_guide", 0);
        }
      }
      if (i1 == 1002)
      {
        as();
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
        this.jdField_h_of_type_Boolean = paramIntent.getBooleanExtra("forward_to_qzone_to_enable_edit", false);
        FlowCameraMqqAction.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr, f1, false, this.jdField_a_of_type_Double, this.jdField_b_of_type_Double, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface, false, i3, paramInt2, this.jdField_m_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_h_of_type_Boolean, this.jdField_h_of_type_JavaLangString, this.jdField_Q_of_type_Boolean, ((PublishParam)localObject1).jdField_c_of_type_JavaLangString, ((PublishParam)localObject1).jdField_d_of_type_JavaLangString, this.jdField_w_of_type_Int, this.jdField_x_of_type_Int, this.jdField_j_of_type_JavaLangString, ((PublishParam)localObject1).jdField_b_of_type_JavaLangString, ((PublishParam)localObject1).jdField_a_of_type_Long, ((PublishParam)localObject1).jdField_f_of_type_Int, false);
      }
      label633:
      do
      {
        do
        {
          return;
          localObject1 = "forward_source_from_shoot_quick";
          break;
          if (i1 == 1003)
          {
            this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper.a(paramIntent, this.jdField_e_of_type_AndroidWidgetImageView);
            return;
          }
          setResult(-1, paramIntent);
          finish();
          FlowCameraMqqAction.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr, f1, false, this.jdField_a_of_type_Double, this.jdField_b_of_type_Double, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface, false, i3, paramInt2, this.jdField_m_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_h_of_type_Boolean, this.jdField_h_of_type_JavaLangString, this.jdField_Q_of_type_Boolean, ((PublishParam)localObject1).jdField_c_of_type_JavaLangString, ((PublishParam)localObject1).jdField_d_of_type_JavaLangString, ((PublishParam)localObject1).jdField_f_of_type_Int, true, false);
          return;
        } while (paramInt2 != 0);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) {
          FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("result_Event", String.valueOf(2));
        m(false);
        this.jdField_d_of_type_Long = System.currentTimeMillis();
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 4));
      this.au = true;
      ae();
      this.av = true;
      this.jdField_z_of_type_Boolean = true;
      return;
    }
  }
  
  private void f(String paramString)
  {
    M();
    Intent localIntent = new Intent(this, EditVideoActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("extra_publish_text", HardCodeUtil.a(2131707487));
    paramString = new EditVideoParams(3, 4109, new EditTakeGifSource(paramString, null, null), localBundle);
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", NewFlowCameraActivity.class.getName());
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra(EditVideoParams.class.getName(), paramString);
    localIntent.putExtra("op_type", "gif_edit");
    localIntent.putExtra("op_department", "grp_qzone");
    localIntent.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
    localIntent.putExtra("DirectBackToQzone", true);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    this.av = false;
    startActivityForResult(localIntent, 1014);
  }
  
  private boolean f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a())) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = null;
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder == null) || (this.jdField_b_of_type_AndroidWidgetButton.isEnabled())) {
      return false;
    }
    return true;
  }
  
  private void g(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.a();
      if ((localObject1 != null) && (!TextUtils.isEmpty(((FilterDesc)localObject1).name))) {
        FlowCameraMqqAction.a("", "0X8007805", "", "", ((FilterDesc)localObject1).name, "");
      }
    }
    int i6 = this.jdField_f_of_type_Int;
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
    int i4 = i1;
    if (i1 <= 0)
    {
      i4 = i1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
        i4 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getRemainedRecordFrames(0);
      }
    }
    if (i4 > 0) {
      this.jdField_V_of_type_Int = i4;
    }
    Object localObject1 = null;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString;
    if (!TextUtils.isEmpty(str2)) {
      localObject1 = new File(str2);
    }
    if ((i6 <= 0) || (i4 <= 0) || (localObject1 == null) || (!((File)localObject1).exists()))
    {
      QQToast.a(this, HardCodeUtil.a(2131707467), 0).a();
      return;
    }
    int i7 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_e_of_type_Int;
    int i8 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_f_of_type_Int;
    localObject1 = "";
    boolean bool1 = false;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr.a();
    Object localObject4 = localObject1;
    boolean bool4 = bool1;
    if (localObject2 != null)
    {
      localObject4 = localObject1;
      bool4 = bool1;
      if (((RMVideoThumbGenMgr.ThumbGenItem)localObject2).jdField_c_of_type_JavaLangString != null)
      {
        localObject4 = localObject1;
        bool4 = bool1;
        if (((RMVideoThumbGenMgr.ThumbGenItem)localObject2).a.get() == 3)
        {
          bool4 = true;
          localObject4 = ((RMVideoThumbGenMgr.ThumbGenItem)localObject2).jdField_c_of_type_JavaLangString;
        }
      }
    }
    int i2 = 109;
    if ((paramInt == 10004) || (paramInt == 10000) || (paramInt == 10007) || (paramInt == 10010)) {
      i2 = 1133;
    }
    Object localObject5 = new Bundle();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null) {
      ((Bundle)localObject5).putString("mCurrentTemplatePath", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.jdField_a_of_type_JavaLangString);
    }
    label445:
    label490:
    int i3;
    if (paramInt == 10003)
    {
      i1 = 0;
      switch (CodecParam.mAudioChannel)
      {
      default: 
        ((Bundle)localObject5).putInt("audio_samplerate", CodecParam.mAudioSampleRate);
        ((Bundle)localObject5).putInt("audio_channel", i1);
        i1 = (i2 | 0x200) & 0xFFFFFFDF;
        ((Bundle)localObject5).putInt("entrance_type", a());
        ((Bundle)localObject5).putDouble("extra_bless_latitude", this.jdField_a_of_type_Double);
        ((Bundle)localObject5).putDouble("extra_bless_longitude", this.jdField_b_of_type_Double);
        if (paramInt == 10003)
        {
          i2 = 5;
          if (this.aE) {
            i2 = 6;
          }
          localObject1 = "barindex";
          i3 = -1;
          if (paramInt != 10012) {
            break label1467;
          }
          localObject2 = getIntent().getExtras();
          if (localObject2 == null) {
            break label1434;
          }
          localObject2 = ((Bundle)localObject2).getString("options");
          if (QLog.isColorLevel()) {
            QLog.d("PTV.NewFlowCameraActivity", 2, "onVideoCaptured option: " + (String)localObject2);
          }
        }
        break;
      }
    }
    for (;;)
    {
      boolean bool2;
      boolean bool3;
      boolean bool5;
      try
      {
        localObject6 = new JSONObject((String)localObject2);
        bool1 = ((JSONObject)localObject6).optBoolean("needTheme", false);
      }
      catch (Exception localException1)
      {
        Object localObject6;
        i2 = -1;
        localObject1 = "barindex";
        bool1 = false;
        bool2 = false;
        bool3 = false;
      }
      try
      {
        bool2 = ((JSONObject)localObject6).optBoolean("needVideoDoodle", false);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject3;
          i2 = -1;
          localObject1 = "barindex";
          bool5 = false;
          bool2 = false;
          bool3 = bool1;
          bool1 = bool5;
        }
      }
      try
      {
        bool3 = ((JSONObject)localObject6).optBoolean("needVideoWording", false);
        i2 = i3;
      }
      catch (Exception localException3)
      {
        i2 = -1;
        localObject1 = "barindex";
        bool5 = false;
        bool3 = bool1;
        bool1 = bool5;
        break label1219;
      }
      try
      {
        localObject2 = ((JSONObject)localObject6).optString("from", "barindex");
        i2 = i3;
        localObject1 = localObject2;
        i3 = ((JSONObject)localObject6).optInt("theme_id", -1);
        i2 = i3;
        localObject1 = localObject2;
        localObject6 = ((JSONObject)localObject6).optString("theme_name", "");
        i2 = i1;
        if (!bool2) {
          i2 = i1 & 0xFFFFFFFE;
        }
        i1 = i2;
        if (!bool3) {
          i1 = i2 & 0xFFFFFFFB;
        }
        i5 = i3;
        bool5 = bool3;
        i2 = 10;
        localObject1 = localObject6;
        i3 = i1;
        bool3 = bool1;
        bool1 = bool5;
        i1 = i5;
        localObject6 = new EditRecordVideoSource(str2, i4, i6, FlowCameraConstant.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a(), i7, i8, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(), (String)localObject4, bool4);
        if (localObject5 != null) {
          break label1276;
        }
        localObject4 = EditVideoParams.a(paramInt);
        localObject5 = new EditVideoParams(i2, i3, (EditVideoParams.EditSource)localObject6, (Bundle)localObject4);
        i2 = getIntent().getIntExtra("edit_video_type", 0);
        if (!this.aE) {
          break label1283;
        }
        VideoEditReport.b(3);
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "EditVideoParams params, recordTime:" + i6 + ", recordFrames:" + i4 + ", sourcePath:" + str2 + ", currentCamera:" + FlowCameraConstant.jdField_a_of_type_Int + ", Orientation:" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a() + ", RMVideoClipSpec:" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.toString());
        }
        if ((!this.aE) || (this.jdField_P_of_type_Int != 0)) {
          break label1347;
        }
        i2 = 1;
        if (i2 == 0) {
          break label1352;
        }
        localObject4 = new Intent(this, EditWebVideoActivity.class);
        ((Intent)localObject4).putExtra("edit_video_call_back", this.jdField_f_of_type_JavaLangString);
        ((Intent)localObject4).putExtra(EditVideoParams.class.getName(), (Parcelable)localObject5);
        ((Intent)localObject4).putExtra("op_department", "grp_qq");
        ((Intent)localObject4).putExtra("op_type", "video_edit");
        ((Intent)localObject4).putExtra("stop_record_time", System.currentTimeMillis());
        ((Intent)localObject4).putExtra("sv_total_frame_count", i4);
        ((Intent)localObject4).putExtra("sv_total_record_time", i6);
        ((Intent)localObject4).putExtra("needTheme", bool3);
        ((Intent)localObject4).putExtra("needVideoDoodle", bool2);
        ((Intent)localObject4).putExtra("needVideoWording", bool1);
        if (paramInt == 10012)
        {
          ((Intent)localObject4).putExtra("from", (String)localObject2);
          ((Intent)localObject4).putExtra("theme_id", i1);
          ((Intent)localObject4).putExtra("theme_name", (String)localObject1);
        }
        startActivityForResult((Intent)localObject4, paramInt);
        overridePendingTransition(0, 0);
        this.au = false;
        this.av = false;
        this.aw = true;
        return;
      }
      catch (Exception localException4)
      {
        bool5 = bool1;
        bool1 = bool3;
        bool3 = bool5;
        break label1219;
      }
      i1 = 1;
      break;
      i1 = 2;
      break;
      if (paramInt != 104)
      {
        i1 = i2;
        if (paramInt != 10010) {
          break label445;
        }
      }
      ((Bundle)localObject5).putInt("qq_sub_business_id", 104);
      i1 = i2;
      break label445;
      i2 = 2;
      break label490;
      label1219:
      if (QLog.isColorLevel()) {
        QLog.e("PTV.NewFlowCameraActivity", 2, "onVideoCaptured: " + localException1);
      }
      localObject3 = localObject1;
      int i5 = 10;
      i3 = i1;
      localObject1 = "";
      i1 = i2;
      i2 = i5;
      continue;
      label1276:
      localObject4 = localObject5;
      continue;
      label1283:
      if (i2 == 10004)
      {
        VideoEditReport.b(2);
      }
      else if (i2 == 10000)
      {
        VideoEditReport.b(1);
      }
      else if (i2 == 10003)
      {
        VideoEditReport.b(4);
      }
      else if (i2 == 10010)
      {
        VideoEditReport.b(8);
      }
      else
      {
        VideoEditReport.b(0);
        continue;
        label1347:
        i2 = 0;
        continue;
        label1352:
        localObject4 = new Intent(this, EditVideoActivity.class);
        continue;
        label1434:
        i5 = -1;
        String str1 = "barindex";
        bool1 = false;
        bool2 = false;
        bool3 = false;
        i2 = 10;
        i3 = i1;
        localObject1 = "";
        i1 = i5;
        continue;
        label1467:
        i5 = -1;
        str1 = "barindex";
        bool1 = false;
        bool2 = false;
        bool3 = false;
        i3 = i1;
        localObject1 = "";
        i1 = i5;
      }
    }
  }
  
  private void g(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 10002) || (paramInt1 == 10006))
    {
      if (paramInt2 != -1) {
        break label32;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper.a(paramIntent, this.jdField_e_of_type_AndroidWidgetImageView);
    }
    label32:
    do
    {
      do
      {
        return;
      } while (paramInt2 != 0);
      if (QLog.isColorLevel()) {
        QLog.i("PTV.NewFlowCameraActivity", 2, "Press the cancel button state=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) {
        FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
      }
      a("608", "2", "0", true);
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 4));
    this.au = true;
    ae();
    this.av = true;
    this.jdField_z_of_type_Boolean = true;
  }
  
  private void h(int paramInt)
  {
    SLog.c("PTV.NewFlowCameraActivity", "start generating manifest file...");
    long l1 = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper.a(new NewFlowCameraActivity.53(this, l1, paramInt));
  }
  
  private void h(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10007)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "web onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
      }
      if (paramInt2 != -1) {
        break label555;
      }
      if (paramIntent != null)
      {
        paramIntent = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
        if (paramIntent != null)
        {
          this.aL = true;
          if (paramIntent.jdField_j_of_type_Int != 1) {
            break label241;
          }
          localObject = paramIntent.jdField_c_of_type_JavaLangString;
          if (QLog.isColorLevel())
          {
            QLog.d("PTV.NewFlowCameraActivity", 2, "hwEncodeVideo videoMergeThumbPath =" + (String)localObject);
            QLog.d("PTV.NewFlowCameraActivity", 2, "publishParam =" + paramIntent.toString());
          }
          getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
          localObject = new SessionInfo();
          ((SessionInfo)localObject).jdField_a_of_type_JavaLangString = "0";
          ((SessionInfo)localObject).jdField_a_of_type_Int = 0;
          getIntent().putExtra("PhotoConst.SEND_SESSION_INFO", (Parcelable)localObject);
          getIntent().putExtra("param_entrance", 32);
          getIntent().putExtra("fake_id", paramIntent.jdField_b_of_type_JavaLangString);
          a(paramIntent);
        }
      }
    }
    return;
    label241:
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString;
    localObject = (String)localObject + File.separator + "configure.txt";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramIntent.jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "configure file content:" + localStringBuilder.toString());
    }
    FileUtils.a((String)localObject, localStringBuilder.toString());
    float f1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a();
    paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getRemainedRecordFrames(0);
    }
    f(paramInt1);
    if (paramInt1 <= 0) {
      paramInt1 = this.jdField_V_of_type_Int;
    }
    for (;;)
    {
      ad();
      this.jdField_a_of_type_Boolean = false;
      localObject = new SessionInfo();
      ((SessionInfo)localObject).jdField_a_of_type_JavaLangString = "0";
      ((SessionInfo)localObject).jdField_a_of_type_Int = 0;
      getIntent().putExtra("PhotoConst.SEND_SESSION_INFO", (Parcelable)localObject);
      getIntent().putExtra("param_entrance", 32);
      getIntent().putExtra("fake_id", paramIntent.jdField_b_of_type_JavaLangString);
      getIntent().putExtra("edit_web", true);
      FlowCameraMqqAction.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr, f1, true, this.jdField_a_of_type_Double, this.jdField_b_of_type_Double, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface, false, i1, paramInt1, this.jdField_m_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_h_of_type_Boolean, this.jdField_h_of_type_JavaLangString, this.jdField_Q_of_type_Boolean, paramIntent.jdField_c_of_type_JavaLangString, paramIntent.jdField_d_of_type_JavaLangString, paramIntent.jdField_f_of_type_Int, true, false);
      return;
      label555:
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
      this.au = true;
      ae();
      this.av = true;
      return;
    }
  }
  
  private void i(int paramInt)
  {
    SharedPreUtils.a(BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).edit().putInt("camera", paramInt));
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
    for (;;)
    {
      try
      {
        this.jdField_G_of_type_Int = Settings.System.getInt(getContentResolver(), "screen_brightness_mode");
        Settings.System.putInt(getContentResolver(), "screen_brightness_mode", 0);
        this.jdField_F_of_type_Int = Settings.System.getInt(getContentResolver(), "screen_brightness");
        Settings.System.putInt(getContentResolver(), "screen_brightness", 255);
        return;
      }
      catch (Exception localException1)
      {
        this.jdField_G_of_type_Int = 1;
        this.jdField_F_of_type_Int = 100;
        QLog.d(".photo", 2, new Object[] { "setting not found ", localException1.getMessage() });
        return;
      }
      if (FlowCameraConstant.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.c(false);
        return;
      }
      if (FlowCameraConstant.jdField_a_of_type_Int == 1) {
        try
        {
          Settings.System.putInt(getContentResolver(), "screen_brightness", this.jdField_F_of_type_Int);
          Settings.System.putInt(getContentResolver(), "screen_brightness_mode", this.jdField_G_of_type_Int);
          if ((this.jdField_i_of_type_AndroidViewView != null) && (this.jdField_i_of_type_AndroidViewView.getParent() != null))
          {
            ((ViewGroup)this.jdField_i_of_type_AndroidViewView.getParent()).removeView(this.jdField_i_of_type_AndroidViewView);
            return;
          }
        }
        catch (Exception localException2)
        {
          QLog.d(".photo", 2, new Object[] { "setting not found ", localException2.getMessage() });
        }
      }
    }
  }
  
  private void k(boolean paramBoolean)
  {
    int i1;
    if (FlowCameraConstant.jdField_a_of_type_Int == 1)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.b() != 1)) {
        break label404;
      }
      i1 = 0;
    }
    for (;;)
    {
      if (!this.az) {
        i1 = 0;
      }
      if ((this.aA) && (this.jdField_B_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean) && (i1 != 0) && (this.jdField_a_of_type_AndroidWidgetSeekBar != null) && (this.jdField_a_of_type_AndroidWidgetSeekBar.getVisibility() != 0) && (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler != null))
      {
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("beauty_setting", 0);
        String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        i1 = localSharedPreferences.getInt("beauty_level" + str, (int)(jdField_b_of_type_Float * 100.0F));
        if (!paramBoolean) {
          break label390;
        }
        jdField_a_of_type_Long = 3500L;
        this.jdField_k_of_type_Boolean = true;
      }
      for (;;)
      {
        this.jdField_c_of_type_Int = i1;
        this.jdField_a_of_type_Float = (this.jdField_c_of_type_Int / 5 * 0.05F);
        this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i1);
        this.jdField_a_of_type_AndroidWidgetSeekBar.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(true);
        this.jdField_a_of_type_AndroidWidgetSeekBar.setContentDescription(HardCodeUtil.a(2131707488) + i1 + "%");
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1011);
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1011, jdField_a_of_type_Long);
        VideoFilterTools.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.getContext());
        if ((paramBoolean) && (this.jdField_e_of_type_AndroidWidgetTextView != null))
        {
          this.jdField_e_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707448) + i1 + "%");
          this.jdField_e_of_type_AndroidWidgetTextView.addOnLayoutChangeListener(new NewFlowCameraActivity.13(this, i1));
        }
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a()))) {
          break label399;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.b() == 1)
        {
          i1 = 0;
          break;
        }
        i1 = 1;
        break;
        label390:
        jdField_a_of_type_Long = 1500L;
      }
      label399:
      i1 = 0;
      continue;
      label404:
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
    if (this.jdField_h_of_type_Boolean)
    {
      this.jdField_f_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.clearAnimation();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(4);
      if (!this.jdField_h_of_type_Boolean) {
        break label453;
      }
      this.jdField_g_of_type_AndroidWidgetButton.clearAnimation();
      this.jdField_g_of_type_AndroidWidgetButton.setVisibility(8);
      localObject = this.jdField_f_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label439;
      }
      i1 = 0;
      label103:
      ((TextView)localObject).setVisibility(i1);
      if (paramBoolean)
      {
        if (!this.jdField_h_of_type_Boolean) {
          break label445;
        }
        localObject = this.jdField_f_of_type_AndroidWidgetTextView;
        label124:
        VideoAnimation.a((View)localObject, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      }
      label139:
      if ((!this.jdField_h_of_type_Boolean) || (!paramBoolean) || (!this.jdField_R_of_type_Boolean)) {
        break label568;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      VideoAnimation.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      if (!this.jdField_V_of_type_Boolean) {
        this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if (this.jdField_S_of_type_Boolean)
      {
        this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new NewFlowCameraActivity.31(this));
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
      this.jdField_f_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131707456));
      VideoAnimation.a(this.jdField_f_of_type_AndroidWidgetButton, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      break;
      label439:
      i1 = 8;
      break label103;
      label445:
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView;
      break label124;
      label453:
      this.jdField_f_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(4);
      if ((i1 == 10000) || (i1 == 10004) || (i1 == 10010) || (i1 == 10002) || (i1 == 10003) || (i1 == 10007))
      {
        this.jdField_g_of_type_AndroidWidgetButton.setVisibility(8);
        break label139;
      }
      this.jdField_g_of_type_AndroidWidgetButton.setVisibility(0);
      if (this.jdField_h_of_type_Boolean) {}
      for (localObject = this.jdField_f_of_type_AndroidWidgetTextView;; localObject = this.jdField_g_of_type_AndroidWidgetButton)
      {
        VideoAnimation.a((View)localObject, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
        break;
      }
      label568:
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    }
  }
  
  private void m(boolean paramBoolean)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    int i1;
    if (this.ay)
    {
      i1 = 1;
      localHashMap.put("manualFocused", String.valueOf(i1));
      localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.jdField_d_of_type_Boolean) {
        break label194;
      }
      i1 = 1;
      label40:
      localHashMap.put("manualZoom", String.valueOf(i1));
      localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.an) {
        break label199;
      }
      i1 = 1;
      label66:
      localHashMap.put("flashOn", String.valueOf(i1));
      localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.ao) {
        break label204;
      }
      i1 = 1;
      label92:
      localHashMap.put("nightOn", String.valueOf(i1));
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.a() == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.a().id == 0)) {
        break label209;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("useFilter", String.valueOf(1));
      this.jdField_a_of_type_JavaUtilHashMap.put("filterId", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.a().id));
    }
    for (;;)
    {
      ThreadManager.post(new NewFlowCameraActivity.55(this, paramBoolean), 5, null, true);
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
  
  void A()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "setupCameraUI");
    }
    b(false);
  }
  
  void B()
  {
    SLog.c("PTV.NewFlowCameraActivity", "changeCameraDuringRecord");
    if (!this.aC) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.e();
    }
    a(-1, true);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.f();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface.u();
    if ((FlowCameraConstant.jdField_a_of_type_Int == 2) && (this.an)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.c(true);
    }
    for (;;)
    {
      if (!this.aC) {
        C();
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "start recording start time=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Long);
      }
      this.jdField_r_of_type_Boolean = true;
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
  
  void C()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "enterVideoMode(), mPtvMode = false");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.e();
    this.jdField_q_of_type_Boolean = true;
  }
  
  @TargetApi(11)
  void D()
  {
    int i1 = AIOUtils.a(59.0F, getResources());
    int i2 = AIOUtils.a(84.0F, getResources());
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 1.1333F });
    localValueAnimator.setDuration(400L);
    localValueAnimator.addUpdateListener(new NewFlowCameraActivity.38(this, i1, i2));
    localValueAnimator.addListener(new NewFlowCameraActivity.39(this));
    localValueAnimator.start();
  }
  
  public void E()
  {
    int i1;
    label115:
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
    {
      if ((b()) && (this.jdField_f_of_type_AndroidWidgetButton != null) && ((this.jdField_f_of_type_AndroidWidgetButton != this.jdField_a_of_type_AndroidWidgetButton) || (this.jdField_W_of_type_Boolean)))
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
      if (this.jdField_q_of_type_Int == 10002) {
        this.jdField_a_of_type_AndroidWidgetButton.clearAnimation();
      }
      this.jdField_g_of_type_AndroidWidgetButton.clearAnimation();
      this.jdField_g_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      if (this.jdField_g_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      }
      an();
      am();
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
      if (!this.jdField_f_of_type_Boolean) {
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
      if (this.jdField_q_of_type_Int == 10002) {
        break label615;
      }
      i1 = 0;
      label443:
      ((TextView)localObject).setVisibility(i1);
      if (this.jdField_q_of_type_Int != 10002) {}
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
      if (this.jdField_j_of_type_Boolean)
      {
        this.jdField_z_of_type_Int = 0;
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
  
  void F()
  {
    int i2 = this.jdField_f_of_type_Int;
    int i1 = i2;
    if (this.jdField_j_of_type_Boolean) {
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
      if (i2 > jdField_u_of_type_Int) {
        i3 = jdField_u_of_type_Int;
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
  
  void G()
  {
    if (!this.jdField_j_of_type_Boolean) {}
    while (this.jdField_f_of_type_Int / 10000 == this.jdField_z_of_type_Int) {
      return;
    }
    this.jdField_z_of_type_Int = (this.jdField_f_of_type_Int / 10000);
    SLog.c("PTV.NewFlowCameraActivity", "adjustFragmentThumb. fragment count = %d.");
    if ((this.jdField_z_of_type_Int < 6) && (!c()))
    {
      QQToast.a(this, HardCodeUtil.a(2131707478), 1).a();
      ah();
      return;
    }
    Bitmap localBitmap = a();
    if (localBitmap == null)
    {
      SLog.e("PTV.NewFlowCameraActivity", "adjustFragmentThumb error. thumbBitmap = null.");
      return;
    }
    ThreadManager.postImmediately(new NewFlowCameraActivity.42(this, localBitmap), null, false);
  }
  
  void H()
  {
    if (!this.jdField_j_of_type_Boolean) {}
    while ((this.jdField_f_of_type_Int < 8000) || (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))) {
      return;
    }
    SLog.c("PTV.NewFlowCameraActivity", "show fragment tip.");
    this.jdField_j_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707455));
    this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setStartOffset(1500L);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new NewFlowCameraActivity.43(this));
    this.jdField_j_of_type_AndroidWidgetTextView.startAnimation(localAlphaAnimation);
  }
  
  void I()
  {
    if (!this.jdField_j_of_type_Boolean) {}
    while ((this.jdField_f_of_type_Int < 55000) || (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))) {
      return;
    }
    SLog.c("PTV.NewFlowCameraActivity", "show end fragment tip.");
    this.jdField_j_of_type_AndroidWidgetTextView.setText("即将拍满6段进入编辑");
    this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void J()
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
  
  public void K() {}
  
  public void L()
  {
    runOnUiThread(new NewFlowCameraActivity.45(this));
  }
  
  void M()
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
  
  protected final void N() {}
  
  public void O()
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
        break label50;
      }
    }
    label50:
    for (i1 = ((SessionInfo)localObject).jdField_a_of_type_Int;; i1 = 0)
    {
      i1 = AIOShortVideoUtil.a(i1);
      return i1;
    }
  }
  
  int a(ArrayList<PtvTemplateManager.PtvTemplateInfo> paramArrayList)
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
        if (this.jdField_A_of_type_Boolean) {
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
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 1953	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 3272	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: astore_2
    //   7: aload_2
    //   8: new 217	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 3274
    //   18: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 3280	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   31: aconst_null
    //   32: ldc_w 3282
    //   35: iconst_1
    //   36: anewarray 1271	java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: aload_1
    //   42: aastore
    //   43: aconst_null
    //   44: invokevirtual 1064	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +214 -> 263
    //   52: aload_1
    //   53: invokeinterface 3285 1 0
    //   58: ifeq +205 -> 263
    //   61: aload_1
    //   62: aload_1
    //   63: ldc_w 3286
    //   66: invokeinterface 1075 2 0
    //   71: invokeinterface 3288 2 0
    //   76: astore_2
    //   77: aload_2
    //   78: invokestatic 1144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   81: ifne +176 -> 257
    //   84: new 1271	java/lang/String
    //   87: dup
    //   88: aload_2
    //   89: invokevirtual 3292	java/lang/String:getBytes	()[B
    //   92: ldc_w 3294
    //   95: invokespecial 3297	java/lang/String:<init>	([BLjava/lang/String;)V
    //   98: invokestatic 3302	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore_2
    //   102: invokestatic 274	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq +30 -> 135
    //   108: ldc_w 276
    //   111: iconst_2
    //   112: new 217	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 3304
    //   122: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_2
    //   126: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 1416	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: aload_2
    //   136: astore_3
    //   137: aload_1
    //   138: ifnull +11 -> 149
    //   141: aload_1
    //   142: invokeinterface 1088 1 0
    //   147: aload_2
    //   148: astore_3
    //   149: aload_3
    //   150: areturn
    //   151: astore_3
    //   152: aconst_null
    //   153: astore_2
    //   154: ldc 249
    //   156: astore_1
    //   157: invokestatic 274	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +33 -> 193
    //   163: ldc_w 276
    //   166: iconst_2
    //   167: new 217	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 3306
    //   177: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_3
    //   181: invokestatic 3310	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   184: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 1896	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: aload_1
    //   194: astore_3
    //   195: aload_2
    //   196: ifnull -47 -> 149
    //   199: aload_2
    //   200: invokeinterface 1088 1 0
    //   205: aload_1
    //   206: areturn
    //   207: astore_2
    //   208: aconst_null
    //   209: astore_1
    //   210: aload_1
    //   211: ifnull +9 -> 220
    //   214: aload_1
    //   215: invokeinterface 1088 1 0
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
    //   237: ldc 249
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
    //   257: ldc 249
    //   259: astore_2
    //   260: goto -158 -> 102
    //   263: ldc 249
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
  
  void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  void a(float paramFloat)
  {
    if (paramFloat > 0.0F)
    {
      if (!this.jdField_n_of_type_Boolean) {}
    }
    else {
      while (!this.jdField_n_of_type_Boolean) {
        return;
      }
    }
    Object localObject = getResources();
    if (paramFloat > 0.0F) {}
    while (paramFloat > 0.0F)
    {
      this.jdField_n_of_type_Boolean = true;
      int i1 = ScreenUtil.dip2px(59.0F);
      localObject = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = i1;
      ((ViewGroup.LayoutParams)localObject).width = i1;
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (this.ar)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131707471));
        return;
        ((Resources)localObject).getDimensionPixelSize(2131297112);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131707447));
        return;
      }
    }
    c(false);
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_i_of_type_Boolean) {}
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
    this.jdField_g_of_type_Int = paramInt1;
    this.jdField_h_of_type_Int = paramInt2;
    this.ab = true;
    e(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator.a(paramInt1, paramInt2, (int)this.jdField_c_of_type_Float, (int)this.jdField_d_of_type_Float);
    if ((this.ab) && (this.aa) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder == null)) {}
    for (;;)
    {
      RMVideoClipSpec localRMVideoClipSpec = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setPreviewSize(paramInt1, paramInt2, localRMVideoClipSpec);
      if ((VersionUtils.c()) && (!this.jdField_b_of_type_AndroidWidgetButton.isEnabled())) {
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      }
      this.jdField_h_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      if (this.jdField_f_of_type_Int < CodecParam.RECORD_MAX_TIME) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("PTV.NewFlowCameraActivity", 2, "previewSizeAdjustUI spec: " + localRMVideoClipSpec.toString());
      return;
      if (f())
      {
        localRMVideoClipSpec = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, localRMVideoClipSpec.jdField_e_of_type_Int, localRMVideoClipSpec.jdField_f_of_type_Int);
          Y();
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
      this.ae = false;
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
    paramArrayOfInt = findViewById(2131367151);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams(paramArrayOfInt);
    if (!this.jdField_B_of_type_Boolean)
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
      this.jdField_i_of_type_Int = i1;
      this.jdField_k_of_type_Int = paramInt2;
      this.jdField_l_of_type_Int = (i1 * this.jdField_h_of_type_Int / paramInt1);
      this.jdField_m_of_type_Int = (paramInt2 * this.jdField_h_of_type_Int / paramInt1);
      if (this.jdField_t_of_type_Boolean) {
        a(5.0F);
      }
      return;
      paramInt2 = (int)this.jdField_d_of_type_Float - paramInt2;
      if (this.jdField_A_of_type_Boolean)
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
    runOnUiThread(new NewFlowCameraActivity.44(this, paramString, paramInt));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_n_of_type_Boolean)
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.post(new NewFlowCameraActivity.41(this, paramBoolean));
      return;
      label57:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean) {}
      for (int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();; i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex())
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwAutoSegmentMgr.a(paramInt, i1);
        h(this.jdField_H_of_type_Boolean);
        if (!this.jdField_H_of_type_Boolean) {
          break label123;
        }
        this.jdField_H_of_type_Boolean = false;
        break;
      }
      label123:
      this.jdField_H_of_type_Boolean = true;
    }
  }
  
  void a(Context paramContext, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("PTV.NewFlowCameraActivity", 2, "showProgressDialog");
    }
    try
    {
      if (this.jdField_b_of_type_AndroidAppProgressDialog != null) {
        z();
      }
      for (;;)
      {
        this.jdField_h_of_type_AndroidWidgetTextView.setText(paramInt);
        if (this.jdField_b_of_type_AndroidAppProgressDialog.isShowing()) {
          break;
        }
        this.jdField_b_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_b_of_type_AndroidAppProgressDialog = new ReportProgressDialog(paramContext, 2131755842);
        this.jdField_b_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_b_of_type_AndroidAppProgressDialog.show();
        this.jdField_b_of_type_AndroidAppProgressDialog.setContentView(2131559683);
        this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidAppProgressDialog.findViewById(2131373066));
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
    boolean bool2 = true;
    super.a(paramBundle);
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = 0;
    this.jdField_k_of_type_Int = 0;
    this.jdField_l_of_type_Int = 0;
    this.jdField_m_of_type_Int = 0;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.af = false;
    this.ad = false;
    this.ae = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = null;
    this.aa = false;
    this.ab = false;
    Intent localIntent = super.getIntent();
    this.ar = localIntent.getBooleanExtra("support_photo_merge", false);
    if (paramBundle != null) {
      this.jdField_u_of_type_Boolean = paramBundle.getBoolean("flow_camera_capture_mode", false);
    }
    if (this.jdField_u_of_type_Boolean) {
      this.ar = true;
    }
    this.jdField_E_of_type_Int = localIntent.getIntExtra("video_min_frame_count", 11);
    this.as = localIntent.getBooleanExtra("recapture", false);
    this.jdField_l_of_type_Boolean = localIntent.getBooleanExtra("show_guide_view", false);
    this.jdField_g_of_type_Long = localIntent.getLongExtra("activity_start_time", 0L);
    a(localIntent, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("DynamicAdjustment", 2, "Start NewFlowCameraActivity time : " + this.jdField_g_of_type_Long);
    }
    if (this.aE) {
      FlowCameraMqqAction.a("", "0X8007930", "", "", "", "");
    }
    Object localObject;
    try
    {
      if (this.appInterface != null) {
        HwServlet.getConfig(this.appInterface, this.appInterface.getCurrentAccountUin());
      }
      this.jdField_r_of_type_Int = localIntent.getIntExtra("entrance_type", 99);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)localIntent.getParcelableExtra("PhotoConst.SEND_SESSION_INFO"));
      FlowCameraConstant.jdField_a_of_type_Int = 2;
      if ((CameraAbility.c()) && (!this.ar)) {
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
      this.al = false;
      localObject = ((ActivityManager)super.getSystemService("activity")).getDeviceConfigurationInfo();
      if (localObject == null) {
        break label981;
      }
    }
    boolean bool1;
    if (((ConfigurationInfo)localObject).reqGlEsVersion >= 131072)
    {
      bool1 = true;
      this.al = bool1;
      this.aj = false;
      this.ak = true;
      bool1 = paramBundle.getBoolean("flow_camera_use_filter_function", false);
      if (bool1)
      {
        this.aj = AEResUtil.e();
        this.ak = AEResUtil.d();
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "<FilterInit_> useFilter=" + bool1 + " mHasFilterSoLib=" + this.aj + "  mIsLibVersionErr=" + this.ak);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this.jdField_q_of_type_Int, this.aj);
      this.aC = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(1);
      b(paramBundle);
      a(paramBundle, false);
      if (this.jdField_h_of_type_Boolean) {
        a("612", "1", "0", true);
      }
      this.jdField_p_of_type_Boolean = paramBundle.getBoolean("flow_camera_use_surfaceview", false);
      this.jdField_t_of_type_Boolean = paramBundle.getBoolean("flow_camera_video_mode", false);
      localObject = paramBundle.getString("sv_config");
      this.ah = paramBundle.getBoolean("flow_show_filter_red", false);
      this.ai = paramBundle.getBoolean("flow_show_filter_red_pkg", false);
      if ((!this.ah) && (!this.ai)) {
        break label986;
      }
      bool1 = true;
      label614:
      this.ag = bool1;
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "<hongdian> mShowRedDotConfig=" + this.ah + " mShowRedDotPkg=" + this.ai + "  mShowRedDot=" + this.ag);
      }
      this.jdField_f_of_type_JavaLangString = paramBundle.getString("callback");
      if ((this.jdField_q_of_type_Int != 10003) && (this.jdField_q_of_type_Int != 10011)) {
        FlowCameraConstant.jdField_a_of_type_Int = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).getInt("camera", FlowCameraConstant.jdField_a_of_type_Int);
      }
      S();
      if ((getIntent().getLongExtra("babyq_ability", 0L) & 1L) > 0L) {
        FlowCameraConstant.jdField_a_of_type_Int = 2;
      }
      this.jdField_N_of_type_Int = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).getInt("camera", FlowCameraConstant.jdField_a_of_type_Int);
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator;
      if (FlowCameraConstant.jdField_a_of_type_Int != 1) {
        break label991;
      }
      bool1 = bool2;
      label802:
      paramBundle.a(bool1);
      if (QLog.isColorLevel()) {
        QLog.d("PTV.faceGuide", 2, "initdata mHasFilterSoLib =" + this.aj);
      }
      paramBundle = (SessionInfo)localIntent.getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      if (paramBundle == null) {
        break label1241;
      }
    }
    label981:
    label1241:
    for (int i1 = paramBundle.jdField_a_of_type_Int;; i1 = 0)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put("sessionType", String.valueOf(i1));
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper = new QQStoryTakeVideoHelper(this, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr, localIntent);
      if (a() == 102) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper.a(false);
      }
      this.jdField_C_of_type_Boolean = localIntent.getBooleanExtra("ignore_dpc_duration", false);
      this.jdField_M_of_type_Boolean = localIntent.getBooleanExtra("is_glance_video", false);
      if (this.jdField_j_of_type_Boolean) {
        CodecParam.RECORD_MAX_TIME = 60000;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this, FlowCameraMqqAction.a(this), this))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper.a();
        super.finish();
        return;
        bool1 = false;
        break;
        label986:
        bool1 = false;
        break label614;
        label991:
        bool1 = false;
        break label802;
      }
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this, new NewFlowCameraActivity.CoverGestureDetector(this, this));
      paramBundle = getResources().getDisplayMetrics();
      this.jdField_c_of_type_Float = paramBundle.widthPixels;
      this.jdField_d_of_type_Float = paramBundle.heightPixels;
      this.jdField_e_of_type_Float = (this.jdField_d_of_type_Float / this.jdField_c_of_type_Float);
      this.jdField_a_of_type_Int = ((int)this.jdField_d_of_type_Float);
      this.jdField_a_of_type_AndroidViewOrientationEventListener = new NewFlowCameraActivity.16(this, getApplicationContext());
      if ((this.jdField_a_of_type_AndroidViewOrientationEventListener.canDetectOrientation()) && (this.jdField_q_of_type_Int != 10002)) {
        this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy = new CameraProxy(this, this.jdField_a_of_type_AndroidOsHandler);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(this.jdField_a_of_type_AndroidHardwareCamera$FaceDetectionListener);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(new CameraExceptionHandler(this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler$Callback));
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "initData(), mPtvMode:false,mCaptureMode:false, config=" + (String)localObject);
      }
      R();
      GLVideoClipUtil.c();
      CaptureReportUtil.c();
      CaptureReportUtil.jdField_a_of_type_Int = this.jdField_q_of_type_Int;
      CaptureReportUtil.jdField_e_of_type_Boolean = false;
      CaptureReportUtil.a();
      return;
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
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface.setRefer(paramString);
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
    getLayoutInflater().inflate(2131561254, paramViewGroup);
    this.jdField_g_of_type_AndroidViewView = findViewById(2131367255);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover = ((CameraCover)findViewById(2131367232));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131367171));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367155));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367156));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367253));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367214));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367177);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367178));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131367187);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131367188);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367189));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367186));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367179));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131367223));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131367221));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText = ((ExtendEditText)findViewById(2131367169));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setEditableFactory(QzoneTextBuilder.a);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131367168));
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)findViewById(2131367212));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131367218));
    this.jdField_e_of_type_AndroidViewView = findViewById(2131367217);
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367226));
    if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {
      this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_i_of_type_JavaLangString);
    }
    ar();
    int i1;
    if (this.aM)
    {
      if (getIntent().getIntExtra("edit_video_type", 0) == 10002)
      {
        i1 = 1;
        if (i1 == 0) {
          break label1536;
        }
        this.jdField_b_of_type_AndroidGraphicsBitmap = b(this);
      }
    }
    else
    {
      label395:
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367219));
      this.jdField_e_of_type_AndroidWidgetButton = ((Button)findViewById(2131367159));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView = ((RedDotImageView)findViewById(2131367162));
      this.jdField_g_of_type_AndroidWidgetButton = ((Button)findViewById(2131377769));
      this.jdField_f_of_type_AndroidViewView = findViewById(2131367163);
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367207));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131367164));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer = ((ImageViewVideoPlayer)findViewById(2131367175));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setIMPlayerEndListener(this);
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367205));
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131368580));
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)findViewById(2131365444));
      this.jdField_h_of_type_AndroidWidgetButton = ((Button)findViewById(2131367222));
      this.jdField_i_of_type_AndroidWidgetButton = ((Button)findViewById(2131367224));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131367233));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView = ((CameraFocusView)findViewById(2131364348));
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
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout = ((FSurfaceViewLayout)findViewById(2131367235));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView.setDrawableRes(2130846314);
      if (!CameraAbility.c())
      {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_g_of_type_Boolean = false;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      if (this.jdField_q_of_type_Int == 10003)
      {
        this.jdField_g_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131707479));
        this.jdField_g_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if (!this.ar) {
        break label1567;
      }
      if ((this.jdField_t_of_type_Boolean) || (!this.jdField_u_of_type_Boolean)) {
        break label1547;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131699192));
      label860:
      if ((this.ar) || (this.aE)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      }
      if (this.jdField_q_of_type_Int == 10002)
      {
        paramViewGroup = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper.a();
        if (!TextUtils.equals(paramViewGroup, HardCodeUtil.a(2131707492))) {
          StoryReportor.a("video_shoot", "exp_wording", 0, 0, new String[0]);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup);
      }
      ViewCompat.setImportantForAccessibility(this.jdField_a_of_type_AndroidWidgetTextView, 2);
      if (!this.aM) {
        break label1681;
      }
      this.jdField_f_of_type_AndroidWidgetButton = this.jdField_a_of_type_AndroidWidgetButton;
      paramViewGroup = this.jdField_a_of_type_AndroidWidgetButton;
      if (!this.jdField_W_of_type_Boolean) {
        break label1675;
      }
      i1 = 0;
      label973:
      paramViewGroup.setVisibility(i1);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(this.jdField_W_of_type_Boolean);
      this.jdField_e_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_e_of_type_Int = 2130849591;
      if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (this.jdField_f_of_type_AndroidWidgetButton != null)) {
        this.jdField_f_of_type_AndroidWidgetButton.setBackgroundDrawable(new BitmapDrawable(this.jdField_b_of_type_AndroidGraphicsBitmap));
      }
      if ((this.jdField_b_of_type_AndroidGraphicsBitmap == null) && ((this.jdField_q_of_type_Int == 10002) || (this.jdField_q_of_type_Int == 10012)))
      {
        this.jdField_f_of_type_AndroidWidgetButton = this.jdField_e_of_type_AndroidWidgetButton;
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_e_of_type_Int = 0;
      }
      label1119:
      an();
      am();
      i1 = getIntent().getIntExtra("edit_video_type", 0);
      if (((!this.aE) && (i1 != 10000) && (i1 != 10003) && (i1 != 10004) && (i1 != 10010)) || (!this.av)) {
        break label1731;
      }
      jdField_b_of_type_Int = 2;
      paramViewGroup = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLayoutParams();
      if (paramViewGroup != null)
      {
        paramViewGroup.leftMargin = 0;
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setLayoutParams(paramViewGroup);
      }
      label1213:
      paramViewGroup = new Rect();
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getGlobalVisibleRect(paramViewGroup);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryCameraZoom.jdField_a_of_type_Float = paramViewGroup.top;
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, getResources().getColor(2131167374), 100, getResources().getColor(2131165381));
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(6.0F);
      N();
      if (this.jdField_O_of_type_Boolean)
      {
        this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new NewFlowCameraActivity.18(this));
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      }
      T();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setReddotXOffsetDp(3);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setReddotYOffsetDp(3);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setRedDotBase(1);
      ao();
      if (this.jdField_j_of_type_Boolean)
      {
        this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367184));
        this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367182));
        this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367183));
        this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367185));
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
        this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
      }
      if (this.jdField_q_of_type_Int == 10002) {}
      this.jdField_a_of_type_AndroidViewView.post(new NewFlowCameraActivity.19(this));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break label1781;
        }
        paramViewGroup = "3";
      }
    }
    for (;;)
    {
      if (this.jdField_q_of_type_Int == 10000) {
        StoryReportor.a("aio_shoot", "exp_shoot", 0, 0, new String[] { paramViewGroup });
      }
      return;
      i1 = 0;
      break;
      label1536:
      this.jdField_b_of_type_AndroidGraphicsBitmap = a(this);
      break label395;
      label1547:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131699202));
      break label860;
      label1567:
      if ((this.jdField_q_of_type_Int == 10007) && (!this.aF) && (this.aG))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131699192));
        break label860;
      }
      if ((this.jdField_q_of_type_Int == 10017) && (!this.aF) && (this.aG))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131699192));
        break label860;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131699201));
      break label860;
      label1675:
      i1 = 8;
      break label973;
      label1681:
      this.jdField_f_of_type_AndroidWidgetButton = this.jdField_e_of_type_AndroidWidgetButton;
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_e_of_type_Int = 0;
      break label1119;
      label1731:
      jdField_b_of_type_Int = 1;
      paramViewGroup = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLayoutParams();
      if (paramViewGroup == null) {
        break label1213;
      }
      paramViewGroup.leftMargin = ((int)(getResources().getDisplayMetrics().widthPixels / 4.5F));
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setLayoutParams(paramViewGroup);
      break label1213;
      label1781:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        paramViewGroup = "2";
      } else {
        paramViewGroup = "1";
      }
    }
  }
  
  void a(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
    localReportInfo.actionType = paramString1;
    localReportInfo.subactionType = paramString2;
    localReportInfo.reserves = paramString3;
    paramString1 = "";
    if (this.appInterface != null) {
      paramString1 = this.appInterface.getCurrentAccountUin();
    }
    QZoneClickReport.report(paramString1, localReportInfo, paramBoolean);
  }
  
  void a(boolean paramBoolean)
  {
    i();
    ai();
    if (paramBoolean) {
      b(true);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    super.runOnUiThread(new NewFlowCameraActivity.47(this, paramBoolean, paramInt));
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    super.runOnUiThread(new NewFlowCameraActivity.51(this, paramBoolean, paramString, paramInt));
  }
  
  boolean a()
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
    if (!this.aC)
    {
      if (TakeVideoUtils.a(this.jdField_b_of_type_AndroidWidgetButton, i1, i2))
      {
        if (this.jdField_q_of_type_Int == 10002)
        {
          SLog.b("PTV.NewFlowCameraActivity", "recordButtonPointerDown : click switch camera button , change camera.");
          this.jdField_h_of_type_Long = 0L;
          B();
        }
        return true;
      }
      if (this.jdField_q_of_type_Int == 10002)
      {
        if ((paramMotionEvent.getPointerCount() != 2) || (l1 - this.jdField_h_of_type_Long >= 300L)) {
          break label235;
        }
        SLog.b("PTV.NewFlowCameraActivity", "recordButtonPointerDown : double click , change camera.");
        B();
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
  
  int b(int paramInt)
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
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity.photo", 2, "onShootShortVideo");
    }
    int i3;
    int i2;
    int i1;
    Object localObject;
    if (this.aC)
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
      this.jdField_u_of_type_JavaLangString = (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString + File.separatorChar + "video-" + System.currentTimeMillis() + ".mp4");
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
      i3 = a(this.jdField_n_of_type_Int);
      if (this.jdField_q_of_type_Int == 10002)
      {
        RMVideoStateMgr.a().a(new EncodeConfig(this.jdField_u_of_type_JavaLangString, i2, i1, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_Int * 1000, 1, false, i3));
        RMVideoStateMgr.a().a(this);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.e();
      StoryReportor.a("aio_shoot", "clk_shoot", 0, 0, new String[0]);
      if (this.aE)
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
        break label565;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("isTemplateSelected", String.valueOf(true));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.b();
      }
      if ((this.jdField_q_of_type_Int == 10002) && (!TextUtils.equals(this.jdField_a_of_type_AndroidWidgetTextView.getText().toString().trim(), HardCodeUtil.a(2131707465)))) {
        StoryReportor.a("video_shoot", "press_wording", 0, 0, new String[0]);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new NewFlowCameraActivity.6(this), 100L);
      return;
      RMVideoStateMgr.a().a(new EncodeConfig(this.jdField_u_of_type_JavaLangString, i2, i1, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_Int * 1000, CodecParam.mIFrameInterval, false, i3));
      break;
      label565:
      if ((this.aa) && (this.ab) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder == null)) {
        aj();
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("isTemplateSelected", String.valueOf(false));
    }
  }
  
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
      paramArrayOfInt[1] = b(paramArrayOfInt[1]);
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
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "CaptureProcessObserver.onCompleted, file path = " + paramString);
    }
    a(paramString, false);
  }
  
  void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "setupCameraUI needUseOld = " + paramBoolean);
    }
    Object localObject3 = getResources().getDisplayMetrics();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (findViewById(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131367151) == null)
    {
      localObject1 = localObject2;
      if (paramBoolean) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
      }
    }
    label346:
    int i1;
    if ((VersionUtils.d()) && (!this.jdField_p_of_type_Boolean))
    {
      localObject2 = new CameraTextureView(this);
      if ((localObject1 != null) && ((localObject1 instanceof TexturePreviewContext)))
      {
        ((CameraTextureView)localObject2).a = ((TexturePreviewContext)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(((CameraTextureView)localObject2).a);
        localObject1 = new FrameLayout.LayoutParams(-1, ((DisplayMetrics)localObject3).heightPixels);
        ((FrameLayout.LayoutParams)localObject1).gravity = 83;
        this.jdField_A_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a(this.aj, this.al);
        paramBoolean = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a(this, this, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setAppInterface(this.appInterface);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setEnableBeauty(this.az);
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "setupCameraUI needAddglview:" + paramBoolean + ", needChangeNewSurfaceView:" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean + ", needOpenglView:" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_d_of_type_Boolean + ", isSurpportFilter:" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean) {
          break label928;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131699201));
        if (this.jdField_q_of_type_Int == 10002)
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
          QLog.d("PTV.NewFlowCameraActivity", 2, "setupCameraUI isTemplateMode = " + this.jdField_f_of_type_Boolean);
        }
        if (this.jdField_f_of_type_Boolean) {
          break label1000;
        }
        if (!this.jdField_h_of_type_Boolean) {
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
        if (this.ag) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.a(true);
        }
        label502:
        this.jdField_B_of_type_Boolean = true;
        ((FrameLayout.LayoutParams)localObject1).height = 1;
        ((FrameLayout.LayoutParams)localObject1).width = 1;
        label517:
        ((FrameLayout.LayoutParams)localObject1).gravity = 81;
        if (this.jdField_A_of_type_Boolean) {
          ((FrameLayout.LayoutParams)localObject1).gravity = 49;
        }
        ((View)localObject2).setId(2131367151);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.addView((View)localObject2, 0, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setCameraView((View)localObject2);
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a();
        }
        this.jdField_w_of_type_Boolean = true;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 4) {
          break label1080;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.clearAnimation();
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(4);
        label609:
        if (!this.jdField_x_of_type_Boolean) {
          break label1099;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d();
        label630:
        if ((this.jdField_q_of_type_Int == 10011) && ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_AndroidOpenglGLSurfaceView instanceof CameraFilterGLView)))
        {
          ((CameraFilterGLView)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_AndroidOpenglGLSurfaceView).jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletCameraInterface = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletCameraInterface;
          ((CameraFilterGLView)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_AndroidOpenglGLSurfaceView).jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.a(true);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_AndroidOpenglGLSurfaceView instanceof CameraFilterGLView)) {
          ((CameraFilterGLView)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_AndroidOpenglGLSurfaceView).jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor = this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor;
        }
        if ((!this.ar) || (!e())) {
          break label1130;
        }
        if ((this.jdField_t_of_type_Boolean) || (!this.jdField_u_of_type_Boolean)) {
          break label1110;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131699192));
      }
    }
    for (;;)
    {
      if ((this.ar) || (this.aE)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      }
      if (!this.jdField_k_of_type_Boolean) {
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
        this.jdField_A_of_type_Boolean = true;
        break;
      }
      label928:
      if (this.at) {
        break label346;
      }
      V();
      this.at = true;
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
      if (!this.jdField_l_of_type_Boolean) {
        break label487;
      }
      BabyQHandler.a(this.jdField_f_of_type_AndroidViewView.getContext(), this.jdField_f_of_type_AndroidViewView);
      this.jdField_l_of_type_Boolean = false;
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
      this.jdField_B_of_type_Boolean = false;
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131699202));
      continue;
      label1130:
      if ((this.jdField_q_of_type_Int == 10007) && (!this.aF) && (this.aG)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131699192));
      } else if ((this.jdField_q_of_type_Int == 10017) && (!this.aF) && (this.aG)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131699192));
      } else {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131699201));
      }
    }
  }
  
  public boolean b()
  {
    this.jdField_q_of_type_Int = getIntent().getIntExtra("edit_video_type", 0);
    return (this.jdField_q_of_type_Int != 10000) && (this.jdField_q_of_type_Int != 10003) && (this.jdField_q_of_type_Int != 10004) && (this.jdField_q_of_type_Int != 10010) && (this.jdField_q_of_type_Int != 10007);
  }
  
  public int c()
  {
    return this.jdField_n_of_type_Int;
  }
  
  public void c()
  {
    int i3 = 0;
    NewFlowCameraReporter.a("shootPhoto");
    ag();
    this.jdField_r_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a();; str = null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a().hasGesture())) {}
      for (boolean bool = true;; bool = false)
      {
        NewFlowCameraReporter.a(str, this.jdField_w_of_type_JavaLangString, bool);
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
          if ((!this.jdField_f_of_type_Boolean) || (i1 == 0)) {
            break label432;
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
              if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.a().isEmptyFilter()) {
                i2 = 1;
              }
            }
          }
          if ((i2 != 0) || (!CameraUtils.a()) || (this.ao))
          {
            i1 = i3;
            if (this.an)
            {
              i1 = 1500;
              if (FlowCameraConstant.jdField_a_of_type_Int == 1) {
                j(true);
              }
            }
            else
            {
              label250:
              new Handler().postDelayed(new NewFlowCameraActivity.7(this), i1);
              this.jdField_o_of_type_Boolean = true;
            }
          }
          for (;;)
          {
            HashMap localHashMap = new HashMap();
            localHashMap.put("cameraType", String.valueOf(FlowCameraConstant.jdField_a_of_type_Int));
            localHashMap.put("isTemplateMode", String.valueOf(this.jdField_f_of_type_Boolean));
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
            if ((this.an) && (!this.ay))
            {
              NewFlowCameraReporter.b();
              this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(null, new NewFlowCameraActivity.8(this));
            }
            else
            {
              P();
              Q();
            }
          }
          label432:
          i1 = 0;
        }
      }
    }
  }
  
  public void c(int paramInt)
  {
    an();
  }
  
  void c(String paramString)
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
        M();
        localTextView = (TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131373066);
        if (!StringUtil.a(paramString)) {
          continue;
        }
        localTextView.setText(2131717003);
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
      this.jdField_a_of_type_AndroidAppProgressDialog = new ReportProgressDialog(this, 2131755842);
      this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(false);
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559683);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "ptvRevert(): sendVideo:" + paramBoolean + ",mIsVideoMode: " + this.jdField_n_of_type_Boolean + ", mPtvMode: " + false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.k();
      if (this.jdField_n_of_type_Boolean) {}
    }
    else
    {
      return;
    }
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface.v();
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
      FlowCameraMqqAction.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr, f1, false, this.jdField_a_of_type_Double, this.jdField_b_of_type_Double, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface, false, i3, i1, this.jdField_m_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_h_of_type_Boolean, this.jdField_h_of_type_JavaLangString, this.jdField_Q_of_type_Boolean, this.jdField_w_of_type_Int, this.jdField_x_of_type_Int, this.jdField_j_of_type_JavaLangString);
      if (VideoEnvironment.supportSubmitCallback())
      {
        View localView = findViewById(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131367151);
        if (localView != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView(localView);
        }
      }
    }
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      d(paramBoolean);
      this.jdField_n_of_type_Boolean = false;
      return;
      label297:
      if (VideoEnvironment.supportSubmitCallback())
      {
        setResult(1001);
        finish();
      }
      LogTag.a(this.jdField_d_of_type_JavaLangString, "sendShortVideo", "[peak] preupload procedure");
      break;
    }
  }
  
  boolean c()
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
  
  public int d()
  {
    return 0;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "CaptureProcessObserver.onDataReady");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.b();
    }
  }
  
  public void d(int paramInt) {}
  
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
  
  public boolean d()
  {
    if (!this.jdField_f_of_type_Boolean) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    return true;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.c();
    }
  }
  
  protected void e(int paramInt)
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
      if (this.jdField_j_of_type_Boolean)
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
      if (!this.jdField_j_of_type_Boolean) {
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
      if (this.jdField_r_of_type_Int == 102)
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
      overridePendingTransition(2130771988, 2130772008);
      this.au = false;
      this.av = false;
      this.aw = true;
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
    if ((this.jdField_g_of_type_Int == -1) || (this.jdField_h_of_type_Int == -1)) {}
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
    float f1 = this.jdField_g_of_type_Int * 1.0F / this.jdField_h_of_type_Int;
    if (this.jdField_e_of_type_Float >= f1) {}
    for (boolean bool = false;; bool = true)
    {
      if (paramBoolean) {
        a(this.jdField_g_of_type_Int, this.jdField_h_of_type_Int, bool, arrayOfInt);
      }
      try
      {
        a(arrayOfInt[2], arrayOfInt[3], arrayOfInt);
        label131:
        if (!paramBoolean) {
          a(this.jdField_g_of_type_Int, this.jdField_h_of_type_Int, bool, arrayOfInt);
        }
        localRMVideoClipSpec.jdField_c_of_type_Int = arrayOfInt[0];
        localRMVideoClipSpec.jdField_d_of_type_Int = arrayOfInt[1];
        localRMVideoClipSpec.jdField_e_of_type_Int = this.jdField_g_of_type_Int;
        localRMVideoClipSpec.jdField_f_of_type_Int = this.jdField_h_of_type_Int;
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
  
  public void f()
  {
    ArrayList localArrayList;
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null)
    {
      new ArrayList();
      if (this.jdField_q_of_type_Int != 10003) {
        break label130;
      }
      localArrayList = PtvTemplateManager.a(this.appInterface).c();
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
        PtvTemplateManager.a(this.appInterface).a(null);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.getCount() == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a(localArrayList);
          runOnUiThread(new NewFlowCameraActivity.15(this));
        }
      }
      return;
      if (this.aE) {}
      for (i1 = 2;; i1 = 1)
      {
        localArrayList = PtvTemplateManager.a(this.appInterface).a(true, false, i1);
        break;
      }
    }
  }
  
  public void f(boolean paramBoolean) {}
  
  public void finish()
  {
    super.finish();
    if ((this.jdField_S_of_type_Int == 1) && (this.ad)) {
      overridePendingTransition(0, 2130771995);
    }
  }
  
  void g()
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
  
  public void g(boolean paramBoolean) {}
  
  public String getRefer()
  {
    return this.jdField_q_of_type_JavaLangString;
  }
  
  void h()
  {
    jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec = null;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.jdField_g_of_type_Int, this.jdField_h_of_type_Int, this.jdField_A_of_type_Boolean, false, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec);
    if (localObject != null) {
      ThreadManager.post(new NewFlowCameraActivity.28(this, (Bitmap)localObject), 8, null, false);
    }
    Z();
    localObject = getIntent();
    ((Intent)localObject).putExtra("flow_back", 0);
    setResult(1001, (Intent)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper.a();
    super.onBackPressed();
  }
  
  void h(boolean paramBoolean)
  {
    runOnUiThread(new NewFlowCameraActivity.RefreshUITimer(this, paramBoolean));
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
        M();
        QQToast.a(this, 1, 2131719291, 0).a();
        i(true);
        return true;
        bool1 = bool2;
      } while (!a(this.lastLoginUin));
      ap();
      return true;
      ap();
      return true;
      if (this.jdField_a_of_type_AndroidWidgetSeekBar != null) {
        this.jdField_a_of_type_AndroidWidgetSeekBar.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
      }
      bool1 = bool2;
    } while (this.jdField_e_of_type_AndroidWidgetTextView == null);
    this.jdField_e_of_type_AndroidWidgetTextView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
    return true;
  }
  
  void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.stopPlayer();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.releasePlayer();
    }
  }
  
  void i(boolean paramBoolean)
  {
    setResult(1001);
    finish();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double == 0.0D)
    {
      h();
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.createFullScreenDialog(this, false);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setMainTitle(HardCodeUtil.a(2131707463));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(HardCodeUtil.a(2131707451), 3);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(HardCodeUtil.a(2131707453));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new NewFlowCameraActivity.29(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public void k()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(0);
    localStringBuilder.append("秒");
    this.jdField_g_of_type_AndroidWidgetTextView.setText(localStringBuilder);
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_h_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "initUI_RecordState mIsVideoMode=" + this.jdField_n_of_type_Boolean);
    }
    TextView localTextView;
    if (this.jdField_n_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_e_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.getVisibility() == 0) {
        VideoAnimation.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView, 0.0F, 8.0F, 0.0F, 0.0F, 300, 1.0F, 0.0F);
      }
      if ((this.jdField_f_of_type_AndroidWidgetButton != null) && (this.jdField_f_of_type_AndroidWidgetButton.getVisibility() == 0)) {
        VideoAnimation.a(this.jdField_f_of_type_AndroidWidgetButton, 0.0F, 8.0F, 0.0F, 0.0F, 300, 1.0F, 0.0F);
      }
      if (this.jdField_q_of_type_Int == 10002) {
        VideoAnimation.a(this.jdField_a_of_type_AndroidWidgetButton, 0.0F, 8.0F, 0.0F, 0.0F, 300, 1.0F, 0.0F);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Int = 0;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double <= 0.0D) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_g_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_f_of_type_Boolean = true;
      }
      if (this.au) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_f_of_type_Boolean = true;
      }
      if ((this.jdField_q_of_type_Int != 10002) || (this.aC))
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
      if (!this.jdField_M_of_type_Boolean) {
        break label370;
      }
    }
    label370:
    for (int i1 = 8;; i1 = 0)
    {
      localTextView.setVisibility(i1);
      if ((this.aM) && (this.jdField_a_of_type_AndroidWidgetButton.isEnabled()))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
      if (this.jdField_M_of_type_Boolean) {
        LpReportInfo_pf00064.allReport(627, 2);
      }
      return;
    }
  }
  
  public void localVideoClick(Activity paramActivity) {}
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "initUI_IdleState mIsVideoMode=" + this.jdField_n_of_type_Boolean + ", needGenThumbPic:" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_f_of_type_Boolean);
    }
    Button localButton;
    if (this.jdField_n_of_type_Boolean)
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
      this.jdField_q_of_type_Boolean = false;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.getVisibility() == 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean)) {
        c(0, true);
      }
      if ((b()) && (this.jdField_f_of_type_AndroidWidgetButton != null))
      {
        if (this.jdField_f_of_type_AndroidWidgetButton.getVisibility() == 4)
        {
          this.jdField_f_of_type_AndroidWidgetButton.setVisibility(0);
          VideoAnimation.a(this.jdField_f_of_type_AndroidWidgetButton, -8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
        }
        this.jdField_f_of_type_AndroidWidgetButton.setEnabled(true);
      }
      if (((this.jdField_q_of_type_Int == 10002) || (this.jdField_q_of_type_Int == 10012)) && (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 4))
      {
        localButton = this.jdField_a_of_type_AndroidWidgetButton;
        if (!this.jdField_W_of_type_Boolean) {
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
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.mLoadingBitmap = null;
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
  
  public void n()
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_AndroidWidgetImageView.isEnabled()) {
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
    }
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "initUI_previewState, needIntent:" + this.av + ", shareToWeb:" + this.aE);
    }
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.a();
      if ((localObject2 != null) && (!TextUtils.isEmpty(((FilterDesc)localObject2).name)) && (!TextUtils.equals(((FilterDesc)localObject2).name, "EMPTY"))) {
        StoryReportor.a("video_shoot", "clk_swipe", b(), 0, new String[] { ((FilterDesc)localObject2).name });
      }
    }
    if (!this.aC)
    {
      this.jdField_q_of_type_Int = getIntent().getIntExtra("edit_video_type", 0);
      if (((this.jdField_q_of_type_Int != 10000) && (this.jdField_q_of_type_Int != 10003) && (this.jdField_q_of_type_Int != 10004) && (this.jdField_q_of_type_Int != 10010) && (this.jdField_q_of_type_Int != 10012)) || (!this.av)) {
        break label230;
      }
      g(this.jdField_q_of_type_Int);
    }
    label230:
    int i1;
    do
    {
      do
      {
        return;
        if ((this.jdField_q_of_type_Int == 10002) && (this.av))
        {
          i1 = this.jdField_f_of_type_Int;
          if ((!this.jdField_j_of_type_Boolean) || (i1 < 11000L))
          {
            h(i1);
            return;
          }
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new NewFlowCameraActivity.WaitStartEditActivityRunnable(this, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, i1, null), 100L);
          return;
        }
        if (this.jdField_M_of_type_Boolean)
        {
          aq();
          return;
        }
      } while ((this.jdField_h_of_type_Boolean) && (this.av));
      if ((this.jdField_q_of_type_Int == 10007) && (this.av))
      {
        g(this.jdField_q_of_type_Int);
        return;
      }
    } while ((this.jdField_h_of_type_Boolean) || (this.jdField_q_of_type_Int == 10000));
    if ((this.jdField_q_of_type_Int == 10011) && (!jdField_c_of_type_Boolean))
    {
      if (this.jdField_b_of_type_AndroidViewView == null)
      {
        this.jdField_b_of_type_AndroidViewView = getLayoutInflater().inflate(2131561342, null);
        localObject1 = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout)this.jdField_g_of_type_AndroidViewView).addView(this.jdField_b_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject1);
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131365346)).setOnClickListener(this);
      if (!jdField_c_of_type_Boolean) {
        break label678;
      }
    }
    label663:
    label678:
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
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.mSecurityChecked = false;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.initPlayer(CodecParam.RECORD_MAX_TIME, i3, this.jdField_V_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setCyclePlay(true);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr.a();
      BitmapFactory.Options localOptions;
      if ((localObject2 != null) && (((RMVideoThumbGenMgr.ThumbGenItem)localObject2).jdField_c_of_type_JavaLangString != null) && (((RMVideoThumbGenMgr.ThumbGenItem)localObject2).a.get() == 3) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.mLoadingBitmap == null))
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
        break label663;
      }
      if (localObject1 != null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.startPlayer();
      break;
    }
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
    }
    this.aa = true;
    boolean bool1 = CameraCompatibleList.a(CameraCompatibleList.jdField_q_of_type_JavaLangString);
    boolean bool2 = CameraCompatibleList.e(CameraCompatibleList.A);
    if ((!this.jdField_m_of_type_Boolean) && ((bool1) || (bool2)) && (!this.aO))
    {
      this.aO = true;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 2000L);
    }
    ab();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    b(paramInt1, paramInt2, paramIntent);
    c(paramInt1, paramInt2, paramIntent);
    d(paramInt1, paramInt2, paramIntent);
    e(paramInt1, paramInt2, paramIntent);
    f(paramInt1, paramInt2, paramIntent);
    g(paramInt1, paramInt2, paramIntent);
    h(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1010) && (paramInt2 == -1))
    {
      ToastUtil.a().a(2131717737);
      this.am = true;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface.onActivityResult(this, paramInt1, paramInt2, paramIntent);
      }
      return;
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
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4))
          {
            this.au = true;
            ae();
            this.av = true;
            this.jdField_z_of_type_Boolean = true;
          }
        }
        else if (paramInt2 == -1)
        {
          QLog.i("PTV.NewFlowCameraActivity", 2, "REQ_PREVIEW_EDIT_GIF_ACTIVITY result ok");
          finish();
        }
      }
      else if (paramInt1 == 3)
      {
        if (paramInt2 == -1)
        {
          onBackPressed();
        }
        else if (paramInt2 == 0)
        {
          QLog.d("PTV.NewFlowCameraActivity", 4, "REQ_EDIE_LOCAL_VIDEO RESULT_CANCELED");
          if (QLog.isColorLevel()) {
            QLog.i("PTV.NewFlowCameraActivity", 2, "Press the cancel button state=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
          }
          this.X = true;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4) || (this.jdField_i_of_type_Boolean))
          {
            a("608", "2", "0", true);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.c();
              this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVisibility(0);
            }
            this.jdField_i_of_type_Boolean = false;
          }
        }
      }
    }
  }
  
  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onBackPressed()
  {
    if (this.jdField_n_of_type_Boolean)
    {
      if ((this.jdField_q_of_type_Int == 10011) && (this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0))
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a("PTV.NewFlowCameraActivity");
        ae();
        return;
      }
      j();
      return;
    }
    h();
  }
  
  public void onClick(View paramView)
  {
    if (!this.jdField_w_of_type_Boolean) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i1 = paramView.getId();
      boolean bool;
      if (i1 == 2131367222)
      {
        NewFlowCameraReporter.a();
        if (!this.an) {}
        for (bool = true;; bool = false)
        {
          this.an = bool;
          ab();
          if (this.jdField_q_of_type_Int != 10002) {
            break;
          }
          if (!this.an) {
            break label88;
          }
          StoryReportor.a("video_shoot", "open_flash", 0, 0, new String[0]);
          break;
        }
        label88:
        StoryReportor.a("video_shoot", "close_flash", 0, 0, new String[0]);
      }
      else
      {
        label122:
        Object localObject1;
        if (i1 == 2131367224)
        {
          if (!this.ao)
          {
            bool = true;
            this.ao = bool;
            ac();
            GLVideoClipUtil.a(this.ao);
            if (!this.ao) {
              break label185;
            }
          }
          label185:
          for (localObject1 = "1";; localObject1 = "0")
          {
            ReportController.b(null, "dc00898", "", "", "0X8007BB7", "0X8007BB7", 0, 0, (String)localObject1, "", "", "");
            break;
            bool = false;
            break label122;
          }
        }
        if (i1 == 2131367155)
        {
          if ((Utils.a()) && (!this.jdField_n_of_type_Boolean) && (QLog.isColorLevel())) {
            QLog.i("PTV.NewFlowCameraActivity", 2, "Press the capture button.");
          }
        }
        else if (i1 == 2131367159)
        {
          if (QLog.isColorLevel()) {
            QLog.i("PTV.NewFlowCameraActivity", 2, "Press the cancel button state=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4) {
            ae();
          }
        }
        else if (i1 == 2131367221)
        {
          FlowCameraMqqAction.b("", "0X8006A12");
          h();
        }
        else if ((i1 == 2131367162) || (i1 == 2131367226) || (i1 == 2131377769))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PTV.NewFlowCameraActivity", 2, "click right state is =" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PTV.NewFlowCameraActivity", 2, "click right totalTime=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
            }
            if (!this.aE)
            {
              if (this.jdField_q_of_type_Int == 10011)
              {
                if (TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
                  new NewFlowCameraActivity.EncodeTask(this, null, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$VideoProcessListener, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a(), false).execute(new Void[0]);
                }
                for (;;)
                {
                  a(HardCodeUtil.a(2131707449));
                  break;
                  d(this.jdField_g_of_type_JavaLangString);
                }
              }
              new DCShortVideo(BaseApplication.getContext());
              this.ad = true;
              af();
              this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.k();
              a(102);
              LogTag.a(this.jdField_d_of_type_JavaLangString, "SendBtn Click ", ",(int)rmStateMgr.mTotalTime = " + (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double + ",frames = " + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex() + " VideoABTest:" + SystemClock.uptimeMillis());
              localObject1 = RichmediaClient.a().a().a(this.jdField_d_of_type_JavaLangString);
              if (localObject1 != null) {
                ((CompoundProcessor)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex(), this.jdField_f_of_type_Long, this.jdField_A_of_type_Int);
              }
              c(true);
              this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.jdField_g_of_type_Int, this.jdField_h_of_type_Int, this.jdField_A_of_type_Boolean, false, null);
              if (!VideoEnvironment.supportSubmitCallback())
              {
                setResult(1001);
                finish();
              }
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("PTV.NewFlowCameraActivity", 2, "click right invisible enable=" + paramView.isEnabled());
            }
            BabyQHandler.a(this.jdField_f_of_type_AndroidViewView);
            y();
            FlowCameraMqqAction.a(getIntent().getIntExtra("edit_video_type", -1), "", "0X800781F", null);
            FlowCameraMqqAction.b("", "0X8006A14");
            if (this.jdField_M_of_type_Boolean) {
              LpReportInfo_pf00064.allReport(627, 3);
            }
          }
        }
        else if (i1 == 2131367223)
        {
          jdField_c_of_type_Boolean = false;
          a(-1, false);
          if ((FlowCameraConstant.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter == null) && (this.aj)) {
            y();
          }
          FlowCameraMqqAction.b("", "0X8006A15");
          if (this.jdField_q_of_type_Int == 10002) {
            if (FlowCameraConstant.jdField_a_of_type_Int == 1) {
              StoryReportor.a("video_shoot", "camera_front", 0, 0, new String[0]);
            } else {
              StoryReportor.a("video_shoot", "camera_back", 0, 0, new String[0]);
            }
          }
        }
        else if (i1 == 2131367164)
        {
          if (QLog.isColorLevel()) {
            QLog.i("PTV.NewFlowCameraActivity", 2, "Press the cancel button state=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4) || (this.jdField_i_of_type_Boolean))
          {
            a("608", "2", "0", true);
            if (d()) {
              FlowCameraMqqAction.b("", "0X8006A17");
            }
            for (;;)
            {
              a(true);
              if (this.jdField_x_of_type_Boolean) {
                this.jdField_y_of_type_Boolean = true;
              }
              if (QLog.isColorLevel()) {
                QLog.d("face", 2, "click left hasChangeCamera" + this.jdField_x_of_type_Boolean);
              }
              E();
              break;
              FlowCameraMqqAction.b("", "0X8006A1B");
            }
          }
          if (QLog.isColorLevel()) {
            QLog.e("PTV.NewFlowCameraActivity", 2, "flow_camera_btn_video_local");
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface.localVideoClick(this);
          }
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new NewFlowCameraActivity.32(this), 1000L);
        }
        else
        {
          Object localObject2;
          Object localObject3;
          Iterator localIterator;
          if (i1 == 2131367212)
          {
            localObject2 = QzoneConfig.getInstance().getConfig("H5Url", "UgcPermitSetting", "https://h5.qzone.qq.com/ugc/setting?_wv=3&type=mood&uin={uin}&qua={qua}&_proxy=1");
            localObject1 = "";
            if (this.appInterface != null) {
              localObject1 = this.appInterface.getCurrentAccountUin();
            }
            localObject1 = ((String)localObject2).replace("{uin}", (CharSequence)localObject1).replace("{qua}", QUA.getQUA3());
            a("608", "6", "0", true);
            localObject2 = new Bundle();
            ((Bundle)localObject2).putInt("permission_code", this.jdField_d_of_type_Int);
            if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
            {
              ((Bundle)localObject2).putStringArrayList("uin_list", this.jdField_a_of_type_JavaUtilArrayList);
              localObject3 = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
              localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
              while (localIterator.hasNext()) {
                ((ArrayList)localObject3).add(a((String)localIterator.next()));
              }
              ((Bundle)localObject2).putStringArrayList("key_nicknames", (ArrayList)localObject3);
            }
            if ((a(this.jdField_d_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
              ((Bundle)localObject2).putString("key_setting_raw_json", this.jdField_c_of_type_JavaLangString);
            }
            QZoneHelper.forwardToBrowser(this, (String)localObject1, 2, (Bundle)localObject2, "");
          }
          else
          {
            if (i1 == 2131367169)
            {
              this.aQ = true;
              this.jdField_N_of_type_Boolean = true;
              this.mNeedPauseRichMedia = true;
              a("608", "5", "0", true);
              localObject2 = QZoneHelper.UserInfo.getInstance();
              localObject3 = new Bundle();
              ((Bundle)localObject3).putInt("permission_code", this.jdField_d_of_type_Int);
              if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
              {
                ((Bundle)localObject3).putStringArrayList("uin_list", this.jdField_a_of_type_JavaUtilArrayList);
                localObject1 = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
                localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
                while (localIterator.hasNext()) {
                  ((ArrayList)localObject1).add(a((String)localIterator.next()));
                }
                ((Bundle)localObject3).putStringArrayList("key_nicknames", (ArrayList)localObject1);
              }
              if ((a(this.jdField_d_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
                ((Bundle)localObject3).putString("key_setting_raw_json", this.jdField_c_of_type_JavaLangString);
              }
              if (this.jdField_h_of_type_AndroidViewView == null)
              {
                this.jdField_h_of_type_AndroidViewView = new View(this);
                this.jdField_h_of_type_AndroidViewView.setBackgroundColor(Color.argb(128, 0, 0, 0));
                this.jdField_h_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                ((RelativeLayout)this.jdField_g_of_type_AndroidViewView).addView(this.jdField_h_of_type_AndroidViewView);
              }
              this.jdField_h_of_type_AndroidViewView.setVisibility(0);
              localObject1 = "";
              if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText != null) {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.getText().toString();
              }
              if (this.jdField_O_of_type_Boolean) {}
              for (i1 = 0;; i1 = 1)
              {
                QZoneHelper.forwardToVideoEditActionPanel(this, (QZoneHelper.UserInfo)localObject2, 1009, "", (String)localObject1, "", "", 0, i1, 1, 0, 0, 0, "", 10000, (Bundle)localObject3, this.jdField_O_of_type_Boolean, this.jdField_Q_of_type_Boolean, this.jdField_w_of_type_Int, this.jdField_y_of_type_Int, false);
                break;
              }
            }
            if (i1 == 2131365352)
            {
              StoryReportor.a("video_shoot", "clk_now", 0, 0, new String[0]);
              if (DynamicNowManager.a())
              {
                SLog.b("PTV.NewFlowCameraActivity", "now app is installed");
                DynamicNowManager.d(null);
              }
              else
              {
                StoryReportor.a("video_shoot", "exp_now", 0, 0, new String[0]);
                SLog.b("PTV.NewFlowCameraActivity", "now app is not installed, ask the user");
                localObject1 = DialogUtil.a(this, 230);
                ((QQCustomDialog)localObject1).setTitle(null);
                ((QQCustomDialog)localObject1).setMessage("首次开启直播需下载NOW应用");
                ((QQCustomDialog)localObject1).setNegativeButton(HardCodeUtil.a(2131707457), new NewFlowCameraActivity.33(this));
                ((QQCustomDialog)localObject1).setPositiveButton(HardCodeUtil.a(2131707480), new NewFlowCameraActivity.34(this));
                ((QQCustomDialog)localObject1).getBtnight().getPaint().setFakeBoldText(true);
                ((QQCustomDialog)localObject1).setCancelable(true);
                ((QQCustomDialog)localObject1).getWindow().setBackgroundDrawable(new ColorDrawable(0));
                ((QQCustomDialog)localObject1).show();
              }
            }
            else if (i1 == 2131365346)
            {
              ae();
              if (this.jdField_b_of_type_AndroidViewView != null)
              {
                this.jdField_b_of_type_AndroidViewView.setVisibility(8);
                this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
              }
            }
          }
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
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
      localStringBuilder.append("SERIAL=").append(QQDeviceInfo.getSerial(BaseActivity.sTopActivity)).append("|");
      localStringBuilder.append("MANUFACTURER=").append(Build.MANUFACTURER).append("|");
      localStringBuilder.append("SDK_INT=").append(Build.VERSION.SDK_INT).append("|");
      QLog.i("PTV.NewFlowCameraActivity", 2, localStringBuilder.toString());
    }
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = a();
    PerfTracer.traceStart("Video_component_onCreate");
    super.onCreate(paramBundle);
    if (isInMultiWindow())
    {
      QQToast.a(this, HardCodeUtil.a(2131707462), 0).a();
      finish();
      return;
    }
    this.appInterface = CaptureContext.a();
    LbsFilterStatusManager.a = this.appInterface;
    LbsFilterStatusManager.a(this.appInterface);
    if (this.jdField_q_of_type_Int == 10002) {
      QQStoryFlowCallback.a(this, 1);
    }
    if (this.jdField_q_of_type_Int == 10002) {
      StoryReportor.a("video_shoot", "exp_findview", 0, 0, new String[] { "", "", "", a() + "" });
    }
    if ((this.jdField_q_of_type_Int == 10000) || (this.jdField_q_of_type_Int == 10004) || (this.jdField_q_of_type_Int == 10010)) {
      NewFlowCameraReporter.j();
    }
    PerfTracer.traceEnd("Video_component_onCreate");
    this.jdField_f_of_type_Long = 0L;
    this.jdField_A_of_type_Int = 0;
    if (this.jdField_q_of_type_Int == 10003)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "Begin to initBlessSpecialPendantConfigInfo!");
      }
      PtvTemplateManager.a(this.appInterface).c(this.appInterface);
    }
    for (;;)
    {
      paramBundle = ViewConfiguration.get(this);
      this.jdField_s_of_type_Int = paramBundle.getScaledMinimumFlingVelocity();
      this.jdField_t_of_type_Int = paramBundle.getScaledMaximumFlingVelocity();
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(1008);
      RMVideoStateMgr.a().jdField_b_of_type_Boolean = true;
      paramBundle = (AddressDataProvider)((DataProviderManager)SuperManager.a(20)).a(1);
      if (paramBundle.a() == null) {
        paramBundle.a();
      }
      i(FlowCameraConstant.jdField_a_of_type_Int);
      StatisticCollector.report("exposure_newFlowCamera");
      return;
      if (this.aE) {
        PtvTemplateManager.a(this.appInterface).b(this.appInterface);
      } else {
        PtvTemplateManager.a(this.appInterface).a(this.appInterface);
      }
    }
  }
  
  public void onDestroy()
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
      if (this.jdField_q_of_type_Int == 10002) {
        QQStoryFlowCallback.a(this);
      }
      if (!this.ak) {
        ThreadManager.post(new NewFlowCameraActivity.27(this), 8, null, true);
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
      PtvTemplateManager.a(this.appInterface).a(null);
      NewFlowCameraReporter.a(this.jdField_N_of_type_Int, jdField_c_of_type_Long - this.jdField_g_of_type_Long, this.jdField_q_of_type_Int + "", aD);
      NewFlowCameraReporter.l();
      jdField_c_of_type_Long = 0L;
      aD = false;
      if (QLog.isColorLevel()) {
        QLog.d("DynamicAdjustment", 2, "clear firstFrameShownTime :  " + jdField_c_of_type_Long);
      }
      LbsFilterStatusManager.c();
      GestureRecognitionUtils.jdField_a_of_type_JavaUtilHashMap.clear();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, " already unregisterReceiver" + localIllegalArgumentException);
        }
      }
    }
  }
  
  public void onDrawLastFrameEnd()
  {
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.mLastFramePicture;
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.getCurrentBitmap();
    }
    if (localBitmap1 != null) {
      this.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
    }
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_f_of_type_AndroidWidgetImageView.setAlpha(0.2F);
  }
  
  public void onEncodeError(int paramInt, Throwable paramThrowable)
  {
    SLog.d("PTV.NewFlowCameraActivity", "encode video failed");
    paramInt = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).getInt("sp_mc_crash_times", 0);
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).edit();
    localEditor.putInt("sp_mc_crash_times", paramInt + 1);
    SharedPreUtils.a(localEditor);
    ShortVideoExceptionReporter.a(paramThrowable);
    this.jdField_a_of_type_AndroidOsHandler.post(new NewFlowCameraActivity.11(this));
  }
  
  public void onEncodeFinish(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.c(this.jdField_E_of_type_Int)) {
      return;
    }
    getIntent().getIntExtra("edit_video_type", 0);
    this.jdField_u_of_type_JavaLangString = paramString;
    this.jdField_v_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = new LocalMediaInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path = this.jdField_u_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mMimeType = "video";
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "onEncodeFinish. hwVideoFilePath = " + this.jdField_u_of_type_JavaLangString + " ; hwAudioFilePath = " + this.jdField_v_of_type_JavaLangString);
    }
    MediaScanner.getInstance(this).queryMediaInfoAsync(this, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).edit();
    paramString.putInt("sp_mc_crash_times", 0);
    SharedPreUtils.a(paramString);
  }
  
  public void onEncodeFrame() {}
  
  public void onEncodeStart() {}
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new NewFlowCameraActivity.12(this));
      ShortVideoExceptionReporter.a(new RuntimeException("onMediaInfoChanged failed"));
      return;
    }
    a(this.jdField_q_of_type_Int, this.jdField_u_of_type_JavaLangString, this.jdField_v_of_type_JavaLangString, paramLocalMediaInfo, 0, 0);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    if (isInMultiWindow())
    {
      QQToast.a(this, HardCodeUtil.a(2131707452), 0).a();
      finish();
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    this.jdField_i_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.e();
      this.jdField_q_of_type_Boolean = false;
    }
    this.jdField_a_of_type_AndroidContentIntent = new Intent(BaseApplicationImpl.getContext(), EditLocalVideoActivity.class);
    this.jdField_a_of_type_AndroidContentIntent.putExtras(paramIntent);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("is_qzone_vip", this.am);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("param.topicId", this.jdField_h_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("param.topicSyncQzone", this.jdField_Q_of_type_Boolean);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("extra_key_font_id", this.jdField_w_of_type_Int);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("extra_key_font_format_type", this.jdField_x_of_type_Int);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("extra_key_font_url", this.jdField_j_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("extra_key_super_font_id", this.jdField_y_of_type_Int);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("extra_key_super_font_info", this.jdField_k_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("short_video_refer", this.jdField_q_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("set_user_callback", this.jdField_r_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.postDelayed(new NewFlowCameraActivity.52(this), 0L);
    super.onNewIntent(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130851162);
    this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130851162);
    if (this.aQ) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b();
      Object localObject = RMVideoStateMgr.a();
      ((RMVideoStateMgr)localObject).n();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
      this.jdField_m_of_type_Boolean = false;
      if (this.jdField_S_of_type_Int == 1) {
        QzoneOnlineTimeCollectRptService.getInstance().closeTrace();
      }
      if (((RMVideoStateMgr)localObject).jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4) {
        i();
      }
      localObject = findViewById(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131367151);
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView((View)localObject);
      }
      if ((!this.af) && (!this.ad) && (!this.ae))
      {
        this.af = true;
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 300000L);
      }
      if (this.jdField_q_of_type_Int == 10002) {
        ((DoodleEmojiManager)SuperManager.a(8)).d();
      }
      VideoFilterTools.a().b();
      LbsFilterStatusManager.a(this.appInterface).b();
    } while ((this.jdField_i_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy == null));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.b(true);
  }
  
  public void onPlayerEnd()
  {
    ai();
    b(true);
  }
  
  public void onPlayerRecyle() {}
  
  public void onResume()
  {
    super.onResume();
    if (!this.aL)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130846283);
      this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    for (;;)
    {
      this.jdField_o_of_type_Boolean = false;
      if ((this.jdField_q_of_type_Int != 10002) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper.jdField_a_of_type_Int != 1)) {
        break;
      }
      SLog.c("PTV.NewFlowCameraActivity", "onResume do nothing because we are going to publish");
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.setVisibility(8);
      }
    }
    if ((!this.jdField_i_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy != null) && (!this.aL)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a();
    }
    if (this.aQ)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      return;
    }
    if (this.jdField_i_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    X();
    LbsFilterStatusManager.a(this.appInterface).a();
  }
  
  public void onStart()
  {
    super.onStart();
    W();
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_b_of_type_Double = 0.0D;
    this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener = new NewFlowCameraActivity.26(this, 1, true, true, 0L, false, false, "NewFlowCameraActivity");
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener);
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_y_of_type_Boolean) {
      this.jdField_z_of_type_Boolean = true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener != null))
    {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener);
      this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener = null;
      this.jdField_a_of_type_Double = 0.0D;
      this.jdField_b_of_type_Double = 0.0D;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    if (!this.jdField_w_of_type_Boolean) {}
    while ((this.jdField_s_of_type_Boolean) || (!this.jdField_a_of_type_AndroidWidgetImageView.isClickable())) {
      return bool;
    }
    if (paramMotionEvent.getAction() != 2) {
      this.jdField_F_of_type_Boolean = false;
    }
    GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, false, null, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_AndroidOpenglGLSurfaceView);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryCameraZoom.a(paramMotionEvent, false))
    {
      SLog.a("PTV.NewFlowCameraActivity", "mNewStoryCameraZoom consume the touch event");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.c();
      }
      if (!this.jdField_F_of_type_Boolean)
      {
        FlowCameraMqqAction.a("", "0X80075BC", "", "", "", "");
        this.jdField_d_of_type_Boolean = true;
      }
      this.jdField_F_of_type_Boolean = true;
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
      if ((paramMotionEvent.getAction() == 1) && (!this.jdField_G_of_type_Boolean)) {
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
    this.jdField_m_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "(OLD)LaunchActivity to FirstFrameShown cost : " + (jdField_c_of_type_Long - this.jdField_g_of_type_Long) + "ms");
    }
  }
  
  public void q() {}
  
  public void r() {}
  
  public void run() {}
  
  public void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr == null) {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "replayVideo rmStateMgr=null");
      }
    }
    do
    {
      return;
      this.jdField_i_of_type_Boolean = false;
      if (this.jdField_c_of_type_AndroidWidgetButton != null) {
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(4);
      }
      if (this.aE) {
        FlowCameraMqqAction.a("", "0X8007931", "", "", "", "");
      }
      this.jdField_e_of_type_Boolean = false;
      ab();
      if (this.jdField_j_of_type_Boolean) {
        this.jdField_j_of_type_AndroidWidgetTextView.clearAnimation();
      }
      if (!this.aC) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.getVFileAndAFile(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.c(this.jdField_E_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "replayVideo getVFileAndAFile=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString + "errcode=" + 0 + "hasFrame=" + bool);
      }
      if (!bool)
      {
        QQToast.a(this, HardCodeUtil.a(2131707461), 0).a();
        if (this.jdField_q_of_type_Int == 10002) {
          StoryReportor.a("video_shoot", "exp_time_float", 0, 0, new String[0]);
        }
        this.Y = true;
        aa();
        FlowCameraMqqAction.a("", "0X80075C0", "", "", "", "");
        jdField_c_of_type_Boolean = false;
        return;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PTV.NewFlowCameraActivity", 2, "replayVideo isCurrentPreviewState= true......");
    return;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.mSecurityChecked = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.jdField_g_of_type_Int, this.jdField_h_of_type_Int, this.jdField_A_of_type_Boolean, false, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec);
    if (localObject != null) {
      ThreadManager.post(new NewFlowCameraActivity.30(this, (Bitmap)localObject), 8, null, false);
    }
    l(false);
    this.ae = true;
    localObject = findViewById(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131367151);
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView((View)localObject);
      this.jdField_m_of_type_Boolean = false;
    }
    if (!this.aC)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
      float f1 = ((RMVideoClipSpec)localObject).jdField_f_of_type_Int * 1.0F / ((RMVideoClipSpec)localObject).jdField_e_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.i("PTV.NewFlowCameraActivity", 2, "heightRatio=" + f1 + "clipspec.dst_height=" + ((RMVideoClipSpec)localObject).jdField_f_of_type_Int + "clipspec.dst_width=" + ((RMVideoClipSpec)localObject).jdField_e_of_type_Int);
      }
      b((int)this.jdField_c_of_type_Float, (int)this.jdField_d_of_type_Float);
      FileUtils.d(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.getmAFile(), jdField_o_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(4);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter(null, false, false);
    if ((this.jdField_n_of_type_Int == 90) || (this.jdField_n_of_type_Int == 270)) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (FlowCameraConstant.jdField_a_of_type_Int == 1) {}
      for (int i2 = 1;; i2 = 0)
      {
        if (!d())
        {
          FlowCameraMqqAction.a("", "0X8006A13", String.valueOf((int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double), "" + i1, "" + i2, "");
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null) {
            break label948;
          }
        }
        label948:
        for (localObject = "";; localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a())
        {
          FlowCameraMqqAction.a("", "0X80075BF", (String)localObject, "", "", "");
          if (this.jdField_q_of_type_Int == 10002) {
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
            if (TextUtils.isEmpty(this.jdField_w_of_type_JavaLangString)) {
              break;
            }
            FlowCameraMqqAction.a("", "0X80083B7", (String)localObject, "", this.jdField_w_of_type_JavaLangString, "");
            break;
          }
        }
      }
    }
  }
  
  public void sendClick(Activity paramActivity, Intent paramIntent) {}
  
  public void setRefer(String paramString)
  {
    this.jdField_q_of_type_JavaLangString = paramString;
  }
  
  public void t() {}
  
  public void u()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "enterViewVideoMode");
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.a(false);
    TextView localTextView = this.jdField_g_of_type_AndroidWidgetTextView;
    if (this.jdField_M_of_type_Boolean) {}
    for (int i1 = 8;; i1 = 0)
    {
      localTextView.setVisibility(i1);
      if (!this.jdField_b_of_type_AndroidWidgetButton.isEnabled()) {
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      }
      if (this.jdField_g_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      }
      an();
      am();
      return;
    }
  }
  
  public void v()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "exitViewVideoMode");
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
    if (!this.jdField_b_of_type_AndroidWidgetButton.isEnabled()) {
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
    }
    if (this.jdField_g_of_type_Boolean) {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    }
    an();
    am();
  }
  
  public void w()
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new NewFlowCameraActivity.HandleEndVideoEncode(this, this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
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
      s();
      if (this.an)
      {
        if (FlowCameraConstant.jdField_a_of_type_Int != 1) {
          break label148;
        }
        j(false);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.h();
      return;
      a(this, 2131694889);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.lockFrameSync();
      z();
      s();
      break;
      label148:
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.c(false);
    }
  }
  
  public void x()
  {
    super.finish();
  }
  
  void y()
  {
    if (!this.aj) {}
    do
    {
      do
      {
        return;
      } while ((this.aE) && (!this.aH));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null) {
        break label117;
      }
      new ArrayList();
      if (this.jdField_q_of_type_Int != 10003) {
        break;
      }
      localObject = PtvTemplateManager.a(this.appInterface).c();
      if ((localObject != null) && (((ArrayList)localObject).size() != 0)) {
        break label117;
      }
    } while (!QLog.isColorLevel());
    QLog.e("PTV.NewFlowCameraActivity", 2, "unfold failed due to no data to show");
    return;
    if (this.aE) {}
    for (int i1 = 2;; i1 = 1)
    {
      localObject = PtvTemplateManager.a(this.appInterface).a(true, false, i1);
      break;
    }
    label117:
    if (this.ag)
    {
      U();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.a(false);
      this.ag = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.clearAnimation();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(4);
    this.jdField_g_of_type_AndroidWidgetButton.clearAnimation();
    this.jdField_g_of_type_AndroidWidgetButton.setVisibility(8);
    if ((this.jdField_q_of_type_Int == 10002) || (this.jdField_q_of_type_Int == 10012)) {
      this.jdField_a_of_type_AndroidWidgetButton.clearAnimation();
    }
    this.jdField_f_of_type_AndroidWidgetTextView.clearAnimation();
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.a(84.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.a(84.0F, getResources());
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.a(59.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.a(59.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
    this.jdField_f_of_type_Boolean = true;
    an();
    am();
    if (this.jdField_q_of_type_Int != 10002) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (this.jdField_h_of_type_Boolean) {
      a("612", "4", "0", true);
    }
    label464:
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter == null)
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setStayDisplayOffsetZero(true);
      new ArrayList();
      if (this.jdField_q_of_type_Int == 10003)
      {
        localObject = PtvTemplateManager.a(this.appInterface).c();
        if ((GestureRecognitionUtils.c()) && (GestureRecognitionUtils.b())) {}
        Iterator localIterator = ((ArrayList)localObject).iterator();
        i1 = 0;
        if (!localIterator.hasNext()) {
          break label565;
        }
        localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)localIterator.next();
        if ((localPtvTemplateInfo.category != 1) && (localPtvTemplateInfo.category != 2)) {
          break label542;
        }
        localIterator.remove();
      }
    }
    for (;;)
    {
      break label464;
      if (this.aE) {}
      for (i1 = 2;; i1 = 1)
      {
        localObject = PtvTemplateManager.a(this.appInterface).a(true, false, i1);
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
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter = new PtvTemplateAdapter(this.appInterface, this, (ArrayList)localObject, jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a(this);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter);
        if ("qzoneOpenDongXiao".equals(this.jdField_f_of_type_JavaLangString))
        {
          i1 = a((ArrayList)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("PtvTemplateManager", 2, "position: " + i1);
          }
          if (i1 != -1) {
            this.jdField_a_of_type_ComTencentWidgetHorizontalListView.post(new NewFlowCameraActivity.35(this, i1));
          }
        }
        if (((ArrayList)localObject).size() == 0) {
          PtvTemplateManager.a(this.appInterface).a(this);
        }
        if (QLog.isColorLevel()) {
          QLog.d("PtvTemplateManager", 2, "setadapter list size: " + ((ArrayList)localObject).size());
        }
        if ((this.aE) && (!this.aK)) {}
        for (i1 = 1; (FlowCameraConstant.jdField_a_of_type_Int != 1) && (i1 == 0) && (this.jdField_q_of_type_Int != 10011) && (CameraAbility.c()); i1 = 0)
        {
          a(-1, false);
          return;
        }
        break;
      }
    }
  }
  
  void z()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity
 * JD-Core Version:    0.7.0.1
 */