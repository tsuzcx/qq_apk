package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.identification.AppConf;
import com.tencent.mobileqq.identification.AppConf.AppWordings;
import com.tencent.mobileqq.identification.FaceConf;
import com.tencent.mobileqq.identification.IYTFaceView;
import com.tencent.mobileqq.identification.IdentificationActivityHelper;
import com.tencent.mobileqq.identification.IdentificationConstant;
import com.tencent.mobileqq.identification.RequestListener;
import com.tencent.mobileqq.qqconnectface.api.ICamera;
import com.tencent.mobileqq.qqconnectface.impl.FaceCameraProxy;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.richmedia.capture.util.SensorShower;
import com.tencent.mobileqq.richmedia.capture.view.CaptureParam;
import com.tencent.mobileqq.richmedia.capture.view.CircleBarView;
import com.tencent.mobileqq.richmedia.capture.view.OutPreviewCallback;
import com.tencent.mobileqq.richmedia.capture.view.QIdentifierCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.QIdentityCircleLayout;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.ytagreflectlivecheck.ui.YTReflectLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

@RoutePage(desc="人脸识别页面", path="/base/connectface/identity")
public class QQIdentiferActivity
  extends QBaseActivity
  implements Handler.Callback, View.OnClickListener, IYTFaceView, RequestListener, OutPreviewCallback
{
  private static final int APPID_DELETE_FACE = 101868556;
  public static final int CAMERA_STATE_RIGHT_FACE = 1;
  private static final int ERROR_REQUEST_FEATURE_CODE = -11;
  private static final String FACE_IDENTIFICATION_AUTO_LOGIN_TVALUE = "0X800AD2C";
  private static final String KEY_ERROR_MSG = "errorMsg";
  public static final String KEY_FACE_SCANN_ERROR = "isScanError";
  private static final String KEY_UIN = "key_uin";
  private static final int LIGHT_THRESHOLD = 175;
  private static final int MAX_IDENTIFY_TIMES = 5;
  public static final int MSG_NOTICE_REFRESH_NOTICE = 4;
  public static final int MSG_PAGE_CHANGE = 0;
  public static final int MSG_PAGE_INIT_TIMEOUT = 1;
  public static final int MSG_POST_FILE_TIME_OUT = 5;
  public static final int MSG_RESULT_FAILFUL_FINISH = 6;
  public static final int MSG_RESULT_SUCESSFUL_FINISH = 3;
  public static final int PAGE_ID_UPLOAD = 2;
  public static final String REPORT_ACTION_CANCEL_CLICK = "0X800A860";
  public static final String TAG = "qq_Identification.act";
  private static final String TAG_IDENTIFICATION_ERROR_CODE = "tagIdentificationErrorCode";
  private static final String YT_MSG_KEY_CODE = "errorcode";
  private static final String YT_MSG_KEY_INFO = "extrainfo";
  private static final String YT_MSG_KEY_MSG = "errormsg";
  private static final int YT_SDK_ERROR_CODE = -10;
  private int DELAY_RESULT_SUCESSFUL_FINISH = 1500;
  private int DELAY_SET_NOTICE = 500;
  private int PAGE_INIT_TIMEOUT = 120000;
  private final long POST_FILE_TIMEOUT_SECOND = 60000L;
  private int faceClear = Color.argb(0, 0, 0, 0);
  private int faceNo = Color.rgb(255, 64, 96);
  private int faceOk = Color.rgb(0, 202, 252);
  public int identificationType;
  private boolean initYTFinish;
  private AtomicBoolean isCameraOnPause = new AtomicBoolean(false);
  private AtomicBoolean isReflecting = new AtomicBoolean(false);
  private AtomicBoolean isScaningFace = new AtomicBoolean(true);
  private IdentificationActivityHelper mActivityHelper;
  private StringBuilder mAllResults = new StringBuilder();
  private ImageView mBlurIv;
  private RelativeLayout mBtnLayout;
  private TextView mCameraErrorTv;
  private ICamera mCameraProxy;
  private int mCameraState;
  private TextView mCameraTv;
  private QIdentifierCaptureView mCameraView;
  private CircleBarView mCircleView;
  private Context mContext;
  private long mEnterTime;
  private FaceConf mFaceConf;
  private MqqHandler mHandler = new MqqHandler(this);
  private int mIdentifyTimes = 0;
  private RelativeLayout mInfoLayout;
  private boolean mIsPreCheckOk;
  private byte[] mLastPreviewData;
  private View mMaskView;
  private LinearLayout mNoticeLayout;
  private String mNoticeText;
  private int mPageId = -1;
  private QIdentityCircleLayout mQIdentityCircleLayout;
  private BroadcastReceiver mReceiver = new QQIdentiferActivity.7(this);
  private int mReceiverState;
  private boolean mResultCanRetry;
  private String mResultErrorStr = HardCodeUtil.a(2131891952);
  private ImageView mResultImg;
  private LinearLayout mResultLayout;
  private boolean mResultSucess;
  private TextView mResultTv;
  private Map<String, Object> mScanningData = new HashMap();
  private MqqHandler mSubHandler = new MqqHandler(ThreadManager.getSubThreadLooper(), this);
  private TextView mTitleProgressTv;
  private Map<String, Integer> mWordingMap;
  public YTReflectLayout mYTReflectLayout;
  private String method;
  private long reflectTimeDelta;
  private Map<String, String> sdkTips = new QQIdentiferActivity.1(this);
  private AtomicBoolean uploading = new AtomicBoolean(false);
  private View ytTips;
  
  private void addWordingRecord(String paramString)
  {
    if ("identify".equals(this.method)) {
      return;
    }
    if (paramString == null)
    {
      QLog.e("qq_Identification.act", 1, "add wording record, wording is null");
      return;
    }
    if (this.mWordingMap.containsKey(paramString))
    {
      Integer localInteger = (Integer)this.mWordingMap.get(paramString);
      this.mWordingMap.put(paramString, Integer.valueOf(localInteger.intValue() + 1));
      return;
    }
    this.mWordingMap.put(paramString, Integer.valueOf(1));
  }
  
  private void blueLastFrameAsync()
  {
    ThreadManagerV2.executeOnFileThread(new QQIdentiferActivity.9(this));
  }
  
  private void collectErrorCode(int paramInt, String paramString)
  {
    QLog.d("qq_Identification.act", 1, new Object[] { "collectErrorCode error code : ", Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap(4);
    localHashMap.put("errorCode", String.valueOf(paramInt));
    if (!TextUtils.isEmpty(paramString)) {
      localHashMap.put("errorMsg", paramString);
    }
    paramString = getAppRuntime();
    if (paramString == null) {
      paramString = "";
    } else {
      paramString = paramString.getAccount();
    }
    if (!TextUtils.isEmpty(paramString)) {
      localHashMap.put("key_uin", paramString);
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramString, "tagIdentificationErrorCode", this.mResultSucess, 0L, 0L, localHashMap, "");
  }
  
  private void doResultFail()
  {
    if (!this.method.equalsIgnoreCase("studyModeIdentify"))
    {
      showFailedResult(this.mResultErrorStr);
      return;
    }
    int i = this.mIdentifyTimes;
    if (i >= 4)
    {
      this.mResultCanRetry = false;
      showFailedResult(this.mResultErrorStr);
      this.mIdentifyTimes = 0;
      this.mHandler.sendEmptyMessageDelayed(6, this.DELAY_RESULT_SUCESSFUL_FINISH);
      return;
    }
    this.mIdentifyTimes = (i + 1);
    showFailedResult(this.mResultErrorStr);
  }
  
  private void doResultSucess()
  {
    showSuccessResult();
    this.mHandler.sendEmptyMessageDelayed(3, this.DELAY_RESULT_SUCESSFUL_FINISH);
  }
  
  private String getAppWording()
  {
    int i = this.mFaceConf.getServiceType();
    Object localObject1 = this.mFaceConf.getAppConf();
    Object localObject2;
    if ((localObject1 != null) && (i != -1) && (((AppConf)localObject1).al != null) && (!((AppConf)localObject1).al.isEmpty()))
    {
      localObject1 = ((AppConf)localObject1).al.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AppConf.AppWordings)((Iterator)localObject1).next();
        if (((AppConf.AppWordings)localObject2).serviceType == i) {
          return ((AppConf.AppWordings)localObject2).text;
        }
      }
      return null;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getAppWording PARAMS ERROR serviceType=");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(" appConf=");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("qq_Identification.act", 2, ((StringBuilder)localObject2).toString());
    }
    return null;
  }
  
  private CaptureParam initCaptureParam()
  {
    CaptureParam localCaptureParam = new CaptureParam();
    localCaptureParam.b(480);
    localCaptureParam.a(640);
    localCaptureParam.a(false);
    return localCaptureParam;
  }
  
  private boolean isNeedsetCancelResult()
  {
    if ("studyModeIdentify".equals(this.method))
    {
      setCanceledResult(201, IdentificationConstant.h);
      return true;
    }
    return false;
  }
  
  private void onFailedResultReport()
  {
    reportByEntrance("0X800A865");
    if ("changeSecureMobile".equals(this.method)) {
      ReportController.b(null, "dc00898", "", "", "0X800AEC5", "0X800AEC5", 0, 0, "", "", "", "");
    }
  }
  
  private void onPageShowReport()
  {
    if ("deleteFace".equals(this.method))
    {
      ReportController.b(null, "dc00898", "", "", "0X800AF62", "0X800AF62", 0, 0, "", "", "", "");
      return;
    }
    if ("changeSecureMobile".equals(this.method))
    {
      ReportController.a(null, "dc00898", "", "", "0X800AEC3", "0X800AEC3", 0, 0, "", "", "", "");
      return;
    }
    if ("identify".equals(this.method))
    {
      QQIdentiferUtil.a(this.mFaceConf.getAppConf(), "0X800B2BF");
      return;
    }
    if ("loginVerify".equals(this.method)) {
      ReportController.b(null, "dc00898", "", "", "0X800BC46", "0X800BC46", 0, 0, "", "", "", "");
    }
  }
  
  private String parseFailedString(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("qq_Identification.act", 1, "parse msg to json error : originMsg is empty");
      return paramString;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      String str = ((JSONObject)localObject).optString("errormsg", "");
      localObject = ((JSONObject)localObject).optString("extrainfo", "");
      str = (String)this.sdkTips.get(str);
      if (TextUtils.isEmpty(str))
      {
        boolean bool = TextUtils.isEmpty((CharSequence)localObject);
        if (bool) {
          return paramString;
        }
        return localObject;
      }
      return str;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("qq_Identification.act", 1, new Object[] { "parse msg to json error : ", localJSONException.getMessage() });
    }
    return paramString;
  }
  
  private boolean preCheck()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (checkSelfPermission("android.permission.CAMERA") != 0))
    {
      setResult(205, HardCodeUtil.a(2131908008));
      finish();
      return false;
    }
    if (!this.mCameraProxy.c())
    {
      setResult(203, HardCodeUtil.a(2131908006));
      DialogUtil.a(this, 230, HardCodeUtil.a(2131908020), HardCodeUtil.a(2131908006), "", HardCodeUtil.a(2131888010), new QQIdentiferActivity.5(this), null).show();
      return false;
    }
    if (isInMultiWindow())
    {
      setResult(206, IdentificationConstant.g);
      finish();
      return false;
    }
    return true;
  }
  
  private void reportBackByEntrance()
  {
    int i = QQIdentiferUtil.a(this.method);
    if ("setFaceData".equals(this.method))
    {
      ReportController.b(null, "dc00898", "", "", "0X800A860", "0X800A860", i, 0, "1", "", "", "");
      return;
    }
    if ("loginVerify".equals(this.method))
    {
      ReportController.a(null, "dc00898", "", "", "0X800A860", "0X800A860", i, 0, "2", "", "", "");
      return;
    }
    ReportController.a(null, "dc00898", "", "", "0X800A860", "0X800A860", i, 0, "", "", "", "");
  }
  
  private void reportByEntrance(String paramString)
  {
    reportByEntrance(paramString, "", "");
  }
  
  private void reportByEntrance(String paramString1, String paramString2, String paramString3)
  {
    if ("setFaceData".equals(this.method))
    {
      ReportController.b(null, "dc00898", "", "", paramString1, paramString1, 0, 0, "1", paramString2, paramString3, "");
      return;
    }
    if ("loginVerify".equals(this.method)) {
      ReportController.a(null, "dc00898", "", "", paramString1, paramString1, 0, 0, "2", paramString2, paramString3, "");
    }
  }
  
  private Intent setAllResults(Intent paramIntent)
  {
    String str = this.mAllResults.toString();
    if ((paramIntent != null) && (paramIntent.hasExtra("data"))) {
      collectErrorCode(paramIntent.getBundleExtra("data").getInt("ret", 299), "");
    }
    if (TextUtils.isEmpty(str)) {
      return paramIntent;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("allResults", str);
    return localIntent;
  }
  
  private void setCanceledResult(int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("ret", paramInt);
    localBundle.putString("errMsg", paramString);
    localIntent.putExtra("data", localBundle);
    setResult(0, setAllResults(localIntent));
  }
  
  private void setResult(int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("ret", paramInt);
    localBundle.putString("errMsg", paramString);
    localIntent.putExtra("data", localBundle);
    setResult(-1, setAllResults(localIntent));
  }
  
  private void updateCancelResult()
  {
    if (this.uploading.get()) {
      setResult(210, IdentificationConstant.h);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @RequiresApi(api=18)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mContext = this;
    Object localObject = getWindow();
    ((Window)localObject).setFlags(128, 128);
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131627472);
    ImmersiveUtils.setStatusTextColor(true, (Window)localObject);
    this.mWordingMap = new HashMap();
    this.mCameraProxy = new FaceCameraProxy();
    this.mIsPreCheckOk = preCheck();
    if (!this.mIsPreCheckOk)
    {
      QLog.e("qq_Identification.act", 1, "preCheck not pass");
      findViewById(16908290).setVisibility(8);
      return true;
    }
    this.mFaceConf = ((FaceConf)getIntent().getSerializableExtra("faceConf"));
    paramBundle = this.mFaceConf;
    if (paramBundle == null)
    {
      finish();
      QLog.e("qq_Identification.act", 1, "mFaceConf is null");
      return true;
    }
    paramBundle = paramBundle.getAppConf();
    if (paramBundle == null)
    {
      finish();
      QLog.e("qq_Identification.act", 1, "appConf is null");
      return true;
    }
    this.identificationType = paramBundle.mode;
    this.method = this.mFaceConf.getMethod();
    if ((this.mFaceConf.getAppId() == 101868556) && ("changeSecureMobile".equals(this.method))) {
      this.method = "deleteFace";
    }
    this.mNoticeLayout = ((LinearLayout)findViewById(2131447502));
    this.mInfoLayout = ((RelativeLayout)findViewById(2131435338));
    this.mQIdentityCircleLayout = ((QIdentityCircleLayout)findViewById(2131435337));
    this.mMaskView = findViewById(2131449312);
    this.mCameraView = ((QIdentifierCaptureView)findViewById(2131430271));
    this.mCameraView.a(false);
    this.mCameraView.setCaptureParam(initCaptureParam());
    this.mCameraView.setPreviewCallback(this);
    this.mCameraView.setCaptureListener(new QQIdentiferActivity.2(this));
    this.mTitleProgressTv = ((TextView)findViewById(2131440768));
    this.mResultTv = ((TextView)findViewById(2131447558));
    this.mResultImg = ((ImageView)findViewById(2131447556));
    this.mCameraTv = ((TextView)findViewById(2131447503));
    this.mCameraErrorTv = ((TextView)findViewById(2131430264));
    this.mYTReflectLayout = ((YTReflectLayout)findViewById(2131450369));
    this.mCircleView = ((CircleBarView)findViewById(2131450368));
    this.mBtnLayout = ((RelativeLayout)findViewById(2131447555));
    this.mResultLayout = ((LinearLayout)findViewById(2131447557));
    this.ytTips = findViewById(2131450370);
    this.mBlurIv = ((ImageView)findViewById(2131436290));
    this.mCircleView.a(getResources().getColor(2131165772));
    paramBundle = findViewById(2131430272);
    paramBundle.setOnClickListener(this);
    paramBundle.post(new QQIdentiferActivity.3(this, paramBundle));
    findViewById(2131447554).setOnClickListener(this);
    this.uploading.set(false);
    this.mActivityHelper = new IdentificationActivityHelper(this, this.identificationType);
    this.mHandler.sendEmptyMessageDelayed(1, this.PAGE_INIT_TIMEOUT);
    this.mHandler.sendEmptyMessage(4);
    showYTSdkInitStart();
    if (TextUtils.isEmpty(getAppWording()))
    {
      QLog.d("qq_Identification.act", 1, "getAppWording return empty");
      SensorShower.a().a(getApplicationContext(), new QQIdentiferActivity.4(this));
    }
    if (this.mReceiverState == 0)
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("tencent.av.v2q.StartVideoChat");
      paramBundle.addAction("tencent.av.v2q.AvSwitch");
      paramBundle.addAction("mqq.intent.action.ACCOUNT_KICKED");
      this.mContext.registerReceiver(this.mReceiver, paramBundle);
      this.mReceiverState = 1;
    }
    this.mEnterTime = System.currentTimeMillis();
    int i = this.mFaceConf.getServiceType();
    paramBundle = this.mRuntime;
    int j = QQIdentiferUtil.a(this.method);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.identificationType);
    ReportController.b(paramBundle, "dc00898", "", "", "0X80097EA", "0X80097EA", j, 0, (String)localObject, localStringBuilder.toString(), String.valueOf(this.mFaceConf.getAppId()), "");
    reportByEntrance("0X800A85F");
    onPageShowReport();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (!this.mIsPreCheckOk) {
      return;
    }
    this.initYTFinish = false;
    this.mHandler.removeCallbacksAndMessages(null);
    this.mSubHandler.removeCallbacksAndMessages(null);
    if (TextUtils.isEmpty(getAppWording())) {
      SensorShower.a().b();
    }
    Object localObject = this.mActivityHelper;
    if (localObject != null) {
      ((IdentificationActivityHelper)localObject).k();
    }
    if (this.mReceiverState == 1)
    {
      this.mContext.unregisterReceiver(this.mReceiver);
      this.mReceiverState = 0;
    }
    if (!this.mResultSucess)
    {
      long l = System.currentTimeMillis() - this.mEnterTime;
      if ("setFaceData".equals(this.method)) {
        ReportController.b(null, "dc00898", "", "", "0X800A862", "0X800A862", 0, 0, String.valueOf(l), "1", "", "");
      } else if ("loginVerify".equals(this.method)) {
        ReportController.b(null, "dc00898", "", "", "0X800A862", "0X800A862", 0, 0, String.valueOf(l), "2", "", "");
      }
    }
    localObject = this.mWordingMap;
    if ((localObject != null) && (!((Map)localObject).isEmpty()))
    {
      localObject = this.mWordingMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        reportByEntrance("0X800A863", String.valueOf(((Integer)this.mWordingMap.get(str)).intValue()), str);
      }
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (!this.mIsPreCheckOk) {
      return;
    }
    this.mCameraView.onPause();
    this.isCameraOnPause.set(true);
    YtSDKKitFramework.getInstance().deInit();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (!this.mIsPreCheckOk) {
      return;
    }
    QLog.d("qq_Identification.act", 1, new Object[] { "onResume isScanningFace : ", Boolean.valueOf(this.isScaningFace.get()) });
    if (this.isScaningFace.get()) {
      this.mCameraView.onResume();
    }
  }
  
  public Bundle getParams()
  {
    return null;
  }
  
  public void handleEvent(Map<String, Object> paramMap)
  {
    if (this.mCameraView != null)
    {
      if (this.isCameraOnPause.get()) {
        return;
      }
      if (paramMap.containsKey("state_stats")) {
        QLog.d("qq_Identification.act", 1, paramMap.get("state_stats").toString());
      }
      if (paramMap.containsKey("ui_tips")) {
        try
        {
          String str1 = getActivity().getPackageName();
          localObject = (String)paramMap.get("ui_tips");
          String str3 = (String)this.sdkTips.get(localObject);
          if (!TextUtils.isEmpty(str3)) {
            this.mNoticeText = str3;
          } else {
            this.mNoticeText = getString(getResources().getIdentifier((String)localObject, "string", str1));
          }
        }
        catch (Exception localException)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("get resource string error : ");
          ((StringBuilder)localObject).append(localException.getMessage());
          QLog.e("qq_Identification.act", 1, ((StringBuilder)localObject).toString());
        }
      }
      if (paramMap.containsKey("ui_action")) {
        if ("not_pass".equals(paramMap.get("ui_action"))) {
          this.mScanningData.put("keyStateIdentify", "stateNotPass");
        } else if ("pass".equals(paramMap.get("ui_action"))) {
          this.mScanningData.put("keyStateIdentify", "statePass");
        } else {
          this.mScanningData.put("keyStateIdentify", null);
        }
      }
      if ((paramMap.containsKey("process_action")) && ("failed".equals(paramMap.get("process_action"))))
      {
        this.mResultCanRetry = true;
        String str2 = (String)paramMap.get("message");
        this.mResultErrorStr = parseFailedString(str2);
        QLog.e("qq_Identification.act", 1, new Object[] { "handleEvent process result failed : ", this.mResultErrorStr, " origin msg : ", str2 });
        showFailedResult(this.mResultErrorStr);
        collectErrorCode(-10, this.mResultErrorStr);
      }
      paramMap.containsKey("version_tips");
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 3)
      {
        if (i != 4)
        {
          if (i != 5)
          {
            if (i != 6) {
              return false;
            }
            finish();
            return false;
          }
          QLog.d("qq_Identification.act", 1, "MSG_POST_FILE_TIME_OUT");
          showFailedResult(HardCodeUtil.a(2131908001));
          return false;
        }
        if ((!TextUtils.isEmpty(this.mNoticeText)) && (!this.isCameraOnPause.get())) {
          showScanningTips(this.mNoticeText, this.mScanningData);
        }
        this.mHandler.sendEmptyMessageDelayed(4, this.DELAY_SET_NOTICE);
        return false;
      }
      if ("loginVerify".equals(this.method))
      {
        ReportController.a(this.mRuntime, "dc00898", "", "", "0X800AD2C", "0X800AD2C", 0, 0, "", "", "", "");
        paramMessage = new Intent();
        paramMessage.setAction("com.tencent.mobileqq.InvitationWebViewPlugin");
        paramMessage.putExtra("key_login_by_qr_face", true);
        paramMessage.setPackage(MobileQQ.getContext().getPackageName());
        sendBroadcast(paramMessage);
      }
      finish();
      return false;
    }
    QLog.d("qq_Identification.act", 1, "init time out");
    showYTInitFinish(false, 218);
    return false;
  }
  
  protected boolean onBackEvent()
  {
    if (!isNeedsetCancelResult()) {
      updateCancelResult();
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131430272)
    {
      if (!"setFaceData".equals(this.method))
      {
        QLog.d("qq_Identification.act", 1, "click cancel, method is not METHOD_SETTING_FACE_DATA");
        updateCancelResult();
      }
      isNeedsetCancelResult();
      reportBackByEntrance();
      finish();
    }
    else if (i == 2131447554)
    {
      reportByEntrance("0X800A866");
      YtSDKKitFramework.getInstance().deInit();
      this.mCameraView.onResume();
      this.isScaningFace.set(true);
      showRetryView();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  @TargetApi(24)
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    if ((paramBoolean) && (Build.VERSION.SDK_INT < 24)) {
      return;
    }
    if (paramBoolean)
    {
      setResult(206, HardCodeUtil.a(2131908007));
      finish();
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    paramCamera = paramCamera.getParameters().getPreviewSize();
    if (!this.initYTFinish) {
      return;
    }
    this.mLastPreviewData = paramArrayOfByte;
    YtSDKKitFramework.getInstance().updateWithFrameData(paramArrayOfByte, paramCamera.width, paramCamera.height, 1);
  }
  
  public void onRequestFinish(int paramInt, Bundle paramBundle)
  {
    this.uploading.set(false);
    Object localObject;
    int i;
    if (paramBundle != null)
    {
      int j = paramBundle.getInt("ret", -1);
      if ((j != -1) && (paramBundle.getBoolean("needRetry", false)))
      {
        localObject = this.mAllResults;
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append("|");
      }
      i = j;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("QQIdentifer onRequestFinish: ,ret=");
        ((StringBuilder)localObject).append(j);
        QLog.d("qq_Identification.act", 2, ((StringBuilder)localObject).toString());
        i = j;
      }
    }
    else
    {
      i = -1;
    }
    if (paramInt != 1)
    {
      if (paramBundle != null)
      {
        this.mResultErrorStr = paramBundle.getString("errMsg");
        localObject = new Intent();
        ((Intent)localObject).putExtra("data", paramBundle);
        setResult(-1, setAllResults((Intent)localObject));
      }
      else
      {
        this.mResultErrorStr = HardCodeUtil.a(2131908004);
        setResult(-1, setAllResults(null));
      }
      this.mResultSucess = false;
      this.mResultCanRetry = true;
    }
    else if (paramBundle != null)
    {
      boolean bool;
      if (paramBundle.getInt("ret") == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.mResultSucess = bool;
      this.mResultCanRetry = paramBundle.getBoolean("needRetry");
      this.mResultErrorStr = paramBundle.getString("errMsg");
      localObject = new Intent();
      ((Intent)localObject).putExtra("data", paramBundle);
      paramBundle = setAllResults((Intent)localObject);
      if (this.mResultSucess) {
        paramBundle.putExtra("key_face_scan_result", true);
      }
      setResult(-1, paramBundle);
    }
    else
    {
      this.mResultSucess = false;
      this.mResultCanRetry = true;
      this.mResultErrorStr = HardCodeUtil.a(2131907997);
      setResult(-1, setAllResults(null));
    }
    QLog.d("qq_Identification.act", 1, new Object[] { "onRequestFinish: code=", Integer.valueOf(paramInt), ",ret=", Integer.valueOf(i), "|", this.mResultErrorStr, " isSuccess : ", Boolean.valueOf(this.mResultSucess) });
    this.mHandler.post(new QQIdentiferActivity.6(this));
  }
  
  public void onUploadVideo()
  {
    this.uploading.set(true);
    showUploadingFileView();
  }
  
  public void showFailedResult(CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = HardCodeUtil.a(2131908004);
    }
    this.mCameraView.onPause();
    this.isCameraOnPause.set(true);
    paramCharSequence = this.isScaningFace;
    int i = 0;
    paramCharSequence.set(false);
    this.mNoticeLayout.setVisibility(8);
    this.mResultLayout.setVisibility(0);
    this.mBtnLayout.setVisibility(0);
    this.mInfoLayout.findViewById(2131447551).setVisibility(8);
    this.mResultTv.setText((CharSequence)localObject);
    this.mResultImg.setImageResource(2130841202);
    this.mCircleView.a();
    this.mCircleView.a(getResources().getColor(2131165772));
    this.mCircleView.b(this.faceClear);
    this.mMaskView.setVisibility(0);
    this.mHandler.removeMessages(5);
    this.isReflecting.set(false);
    blueLastFrameAsync();
    paramCharSequence = findViewById(2131447554);
    if (!this.mResultCanRetry) {
      i = 8;
    }
    paramCharSequence.setVisibility(i);
    addWordingRecord(((CharSequence)localObject).toString());
    onFailedResultReport();
  }
  
  public void showRetryView()
  {
    this.mInfoLayout.findViewById(2131447551).setVisibility(8);
    this.mResultLayout.setVisibility(8);
    this.mBtnLayout.setVisibility(8);
    this.mNoticeLayout.setVisibility(0);
    this.mMaskView.setVisibility(8);
    this.mBlurIv.setVisibility(8);
    this.mCameraView.setVisibility(0);
  }
  
  public void showScanningTips(CharSequence paramCharSequence, Map<String, Object> paramMap)
  {
    if ((this.mNoticeLayout.getVisibility() == 0) && (!this.isReflecting.get()))
    {
      this.mCameraTv.setText(paramCharSequence);
      paramMap = paramMap.get("keyStateIdentify");
      if ("statePass".equals(paramMap))
      {
        this.mCircleView.a(this.faceOk);
        this.mCircleView.b(this.faceClear);
      }
      else if ("stateNotPass".equals(paramMap))
      {
        this.mCircleView.a(this.faceNo);
        this.mCircleView.b(this.faceClear);
      }
      addWordingRecord(paramCharSequence.toString());
      return;
    }
    this.mCircleView.b(this.faceClear);
    if (this.isReflecting.get()) {
      this.mCameraTv.setText(paramCharSequence);
    }
  }
  
  public void showSuccessResult()
  {
    this.mCameraView.onPause();
    this.isCameraOnPause.set(true);
    this.isScaningFace.set(false);
    this.mNoticeLayout.setVisibility(8);
    this.ytTips.setVisibility(0);
    this.mInfoLayout.findViewById(2131447551).setVisibility(8);
    this.mResultLayout.setVisibility(0);
    this.mResultTv.setText(HardCodeUtil.a(2131908012));
    this.mResultImg.setImageResource(2130841203);
    this.mBtnLayout.setVisibility(0);
    findViewById(2131447554).setVisibility(8);
    this.mCircleView.a();
    this.mCircleView.a(this.faceOk);
    this.mCircleView.b(this.faceClear);
    this.mHandler.removeMessages(5);
    this.isReflecting.set(false);
    if ("loginVerify".equals(this.method)) {
      ReportController.b(null, "dc00898", "", "", "0X800A31A", "0X800A31A", 0, 0, "", "", "", "");
    } else if ("setFaceData".equals(this.method)) {
      ReportController.b(null, "dc00898", "", "", "0X800A31F", "0X800A31F", 0, 0, "", "", "", "");
    } else if ("deleteFace".equals(this.method)) {
      ReportController.b(null, "dc00898", "", "", "0X800AE96", "0X800AE96", 0, 0, "", "", "", "");
    } else if ("changeSecureMobile".equals(this.method)) {
      ReportController.b(null, "dc00898", "", "", "0X800AEC4", "0X800AEC4", 0, 0, "", "", "", "");
    }
    long l = System.currentTimeMillis() - this.mEnterTime;
    if ("setFaceData".equals(this.method))
    {
      ReportController.b(null, "dc00898", "", "", "0X800A861", "0X800A861", 0, 0, String.valueOf(l), "1", "", "");
      return;
    }
    if ("loginVerify".equals(this.method))
    {
      ReportController.b(null, "dc00898", "", "", "0X800A861", "0X800A861", 0, 0, String.valueOf(l), "2", "", "");
      return;
    }
    if ("identify".equals(this.method)) {
      QQIdentiferUtil.a(this.mFaceConf.getAppConf(), "0X800B2C0");
    }
  }
  
  public void showTitleTips(CharSequence paramCharSequence)
  {
    this.mCameraErrorTv.setText(paramCharSequence);
    addWordingRecord(paramCharSequence.toString());
  }
  
  public void showUploadingFileView()
  {
    this.mCameraView.onPause();
    this.isCameraOnPause.set(true);
    this.isScaningFace.set(false);
    this.mNoticeLayout.setVisibility(8);
    this.mInfoLayout.findViewById(2131447551).setVisibility(0);
    this.mMaskView.setVisibility(0);
    this.mTitleProgressTv.setText(HardCodeUtil.a(2131907998));
    findViewById(2131435793).setVisibility(8);
    addWordingRecord(HardCodeUtil.a(2131907998));
    this.mCircleView.a(this.faceClear);
    this.mCircleView.b(this.faceOk);
    this.mCircleView.c(1000);
    blueLastFrameAsync();
    this.mHandler.sendEmptyMessageDelayed(5, 60000L);
  }
  
  public void showYTInitFinish(boolean paramBoolean, int paramInt)
  {
    this.mHandler.removeMessages(1);
    if (paramBoolean)
    {
      this.mNoticeLayout.setVisibility(4);
      this.mInfoLayout.findViewById(2131447551).setVisibility(8);
      if (!TextUtils.isEmpty(getAppWording()))
      {
        String str = getAppWording();
        showTitleTips(str);
        addWordingRecord(str);
      }
      this.initYTFinish = true;
      this.mMaskView.setVisibility(8);
      findViewById(2131430272).post(new QQIdentiferActivity.8(this));
      return;
    }
    setResult(paramInt, this.mResultErrorStr);
    showFailedResult(HardCodeUtil.a(2131908013));
  }
  
  public void showYTSdkInitStart()
  {
    this.mNoticeLayout.setVisibility(8);
    this.mInfoLayout.findViewById(2131447551).setVisibility(0);
    this.mMaskView.setVisibility(0);
    this.mTitleProgressTv.setText(HardCodeUtil.a(2131908003));
    addWordingRecord(HardCodeUtil.a(2131908003));
  }
  
  public void updateLightReflect(ColorMatrixColorFilter paramColorMatrixColorFilter)
  {
    this.mYTReflectLayout.setColorMatrixColorFilter(paramColorMatrixColorFilter);
    this.mCircleView.a(this.faceClear);
    this.isReflecting.set(true);
    long l1 = System.currentTimeMillis();
    long l2 = this.reflectTimeDelta;
    if (l2 != 0L) {
      QLog.d("qq_Identification.act", 1, new Object[] { "reflect delta time is : ", Long.valueOf(l1 - l2) });
    }
    this.reflectTimeDelta = l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferActivity
 * JD-Core Version:    0.7.0.1
 */