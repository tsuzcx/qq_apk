package com.tencent.mobileqq.activity.shortvideo;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.prediction.PredictionReporter;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnNetVideoInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparingListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase.IVideoViewCallBack;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import xzu;
import xzv;
import xzw;
import xzx;
import xzz;
import yab;
import yac;
import yad;
import yae;
import yaf;
import yag;
import yaj;
import yak;
import yal;
import yam;
import yan;
import yao;
import yap;
import yaq;
import yar;
import yas;
import yat;
import yau;
import yav;

@TargetApi(11)
public class ShortVideoPlayActivity
  extends BaseActivity
  implements View.OnClickListener, FileTransferManager.Callback, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnNetVideoInfoListener, TVK_IMediaPlayer.OnSeekCompleteListener, TVK_IMediaPlayer.OnVideoPreparedListener, TVK_IMediaPlayer.OnVideoPreparingListener, IVideoViewBase.IVideoViewCallBack
{
  static String[] jdField_b_of_type_ArrayOfJavaLangString;
  static String jdField_l_of_type_JavaLangString = SharedPreUtils.f(BaseApplication.getContext());
  private int A;
  private int B;
  private int C = -1;
  private int D;
  private int E;
  public int a;
  long jdField_a_of_type_Long;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator = null;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public Context a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Bundle jdField_a_of_type_AndroidOsBundle;
  public View a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener;
  public SeekBar a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  public MessageForShortVideo a;
  public TVK_IMediaPlayer a;
  TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  public final Runnable a;
  String jdField_a_of_type_JavaLangString;
  public final MqqHandler a;
  boolean jdField_a_of_type_Boolean = false;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  public int b;
  public long b;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  SeekBar jdField_b_of_type_AndroidWidgetSeekBar;
  public TextView b;
  final Runnable jdField_b_of_type_JavaLangRunnable;
  public String b;
  public boolean b;
  int jdField_c_of_type_Int;
  public long c;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  public RelativeLayout c;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString = "";
  boolean jdField_c_of_type_Boolean = false;
  public int d;
  long jdField_d_of_type_Long = -1L;
  RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  String jdField_d_of_type_JavaLangString = "";
  boolean jdField_d_of_type_Boolean = false;
  public int e;
  long jdField_e_of_type_Long = -1L;
  RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  String jdField_e_of_type_JavaLangString;
  boolean jdField_e_of_type_Boolean;
  int jdField_f_of_type_Int;
  public long f;
  private RelativeLayout jdField_f_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  String jdField_f_of_type_JavaLangString;
  public boolean f;
  public int g;
  public long g;
  public String g;
  boolean g;
  public int h;
  private long h;
  public String h;
  public boolean h;
  int jdField_i_of_type_Int = 1;
  private long jdField_i_of_type_Long;
  public String i;
  boolean jdField_i_of_type_Boolean = false;
  private int jdField_j_of_type_Int;
  private long jdField_j_of_type_Long;
  public String j;
  boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private long jdField_k_of_type_Long;
  String jdField_k_of_type_JavaLangString;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private long jdField_l_of_type_Long;
  private boolean jdField_l_of_type_Boolean;
  private int jdField_m_of_type_Int;
  private long jdField_m_of_type_Long;
  private String jdField_m_of_type_JavaLangString;
  private boolean jdField_m_of_type_Boolean;
  private int jdField_n_of_type_Int;
  private long jdField_n_of_type_Long;
  private String jdField_n_of_type_JavaLangString;
  private boolean jdField_n_of_type_Boolean;
  private int jdField_o_of_type_Int;
  private long jdField_o_of_type_Long;
  private String jdField_o_of_type_JavaLangString;
  private boolean jdField_o_of_type_Boolean = true;
  private int jdField_p_of_type_Int;
  private long jdField_p_of_type_Long;
  private String jdField_p_of_type_JavaLangString;
  private boolean jdField_p_of_type_Boolean = true;
  private int jdField_q_of_type_Int;
  private long jdField_q_of_type_Long;
  private String jdField_q_of_type_JavaLangString;
  private boolean jdField_q_of_type_Boolean = true;
  private int jdField_r_of_type_Int;
  private long jdField_r_of_type_Long;
  private String jdField_r_of_type_JavaLangString;
  private boolean jdField_r_of_type_Boolean;
  private int jdField_s_of_type_Int;
  private long jdField_s_of_type_Long;
  private String jdField_s_of_type_JavaLangString;
  private boolean jdField_s_of_type_Boolean;
  private int jdField_t_of_type_Int;
  private long jdField_t_of_type_Long;
  private String jdField_t_of_type_JavaLangString;
  private boolean jdField_t_of_type_Boolean;
  private int jdField_u_of_type_Int;
  private long jdField_u_of_type_Long;
  private String jdField_u_of_type_JavaLangString;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  static
  {
    if ((jdField_l_of_type_JavaLangString != null) && (jdField_l_of_type_JavaLangString.length() > 0)) {
      jdField_b_of_type_ArrayOfJavaLangString = jdField_l_of_type_JavaLangString.split("\\|");
    }
  }
  
  public ShortVideoPlayActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_e_of_type_Int = -1;
    this.jdField_j_of_type_JavaLangString = "0";
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.3F });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(2500L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new xzu(this));
    }
    this.jdField_a_of_type_MqqOsMqqHandler = new yag(this);
    this.jdField_a_of_type_JavaLangRunnable = new yat(this);
    this.jdField_b_of_type_JavaLangRunnable = new yau(this);
    this.jdField_j_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new yav(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new yak(this);
  }
  
  private void A()
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    QZoneHelper.b(getActivity(), localUserInfo, this.jdField_b_of_type_JavaLangString, 10001);
    ReportController.b(this.app, "dc00898", "", "", "0X800753A", "0X800753A", 0, 0, "", "", "", "");
  }
  
  private void B()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (this.C == -1) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 2003)) {
      break label28;
    }
    label28:
    while (!this.jdField_q_of_type_Boolean) {
      return;
    }
    this.jdField_q_of_type_Boolean = false;
    if (this.jdField_g_of_type_Long == 0L) {}
    for (int i1 = 0;; i1 = (int)(100L * this.jdField_f_of_type_Long / this.jdField_g_of_type_Long))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress < 0) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress = 0;
      }
      int i2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress;
      if (((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1002) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 2002)) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == this.C) && (i1 - i2 < 10)) {
        break;
      }
      if ((this.jdField_c_of_type_Int != 6) && (this.jdField_c_of_type_Int != 17) && (this.jdField_c_of_type_Int != 9))
      {
        i2 = i1;
        if (this.jdField_c_of_type_Int != 20) {}
      }
      else
      {
        if (this.C == 2002) {
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.transferedSize = ((int)this.jdField_f_of_type_Long);
        }
        i2 = i1;
        if (this.C == 2003)
        {
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.transferedSize = 0;
          i2 = 100;
        }
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 2004) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1004)) && ((this.C == 1002) || (this.C == 2002))) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus = this.C;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.fileType = this.jdField_c_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress = i2;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.mPreUpload) && (this.C == 1003) && (this.jdField_g_of_type_JavaLangString != null)) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5 = this.jdField_g_of_type_JavaLangString;
      }
      if ((this.C == 2003) && (!StringUtil.a(this.jdField_b_of_type_JavaLangString)))
      {
        File localFile = new File(this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.lastModified = localFile.lastModified();
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.serial();
      this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.msgData);
      return;
    }
  }
  
  private int a(String paramString)
  {
    if (paramString == null) {}
    int i1;
    do
    {
      do
      {
        return -1;
        paramString = paramString.trim();
        i1 = paramString.indexOf(' ');
      } while ((i1 < 0) || (i1 + 1 >= paramString.length()));
      paramString = paramString.substring(i1 + 1);
    } while (paramString == null);
    paramString = paramString.trim();
    paramString = paramString.substring(0, paramString.indexOf(' '));
    try
    {
      i1 = Integer.parseInt(paramString);
      return i1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  private ShortVideoDownloadInfo a()
  {
    ShortVideoDownloadInfo localShortVideoDownloadInfo = new ShortVideoDownloadInfo();
    try
    {
      JSONObject localJSONObject = new JSONObject(this.jdField_e_of_type_JavaLangString);
      if (localJSONObject != null)
      {
        localShortVideoDownloadInfo.jdField_a_of_type_Int = localJSONObject.getInt("busi_type");
        localShortVideoDownloadInfo.jdField_a_of_type_JavaLangString = localJSONObject.getString("file_uuid");
        String str = localJSONObject.getString("file_md5");
        localShortVideoDownloadInfo.jdField_e_of_type_JavaLangString = str;
        this.jdField_g_of_type_JavaLangString = str;
        localShortVideoDownloadInfo.jdField_b_of_type_Long = localJSONObject.getInt("file_size");
        localShortVideoDownloadInfo.jdField_b_of_type_Int = this.jdField_e_of_type_Int;
        localShortVideoDownloadInfo.jdField_b_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
        localShortVideoDownloadInfo.jdField_c_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
        localShortVideoDownloadInfo.jdField_d_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
        localShortVideoDownloadInfo.jdField_e_of_type_Int = 1001;
        this.jdField_c_of_type_Int = 1001;
        localShortVideoDownloadInfo.jdField_h_of_type_JavaLangString = a(localShortVideoDownloadInfo.jdField_e_of_type_JavaLangString);
        return localShortVideoDownloadInfo;
      }
      return null;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private String a(long paramLong)
  {
    if (paramLong < 1024L) {
      return paramLong + "B";
    }
    if (paramLong < 1048576L)
    {
      f1 = (float)paramLong / 1024.0F;
      return String.format("%.2f", new Object[] { Float.valueOf(f1) }) + "K";
    }
    float f1 = (float)paramLong / 1048576.0F;
    return String.format("%.2f", new Object[] { Float.valueOf(f1) }) + "M";
  }
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.aJ);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("publicaccount");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(".");
    localStringBuilder.append("mp4");
    return localStringBuilder.toString();
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    int i1 = 0;
    if (paramLong2 != 0L) {
      i1 = (int)(100L * paramLong1 / paramLong2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "updateUploadInfo " + i1 + " " + paramLong1 + " " + paramLong2);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(a(paramLong1) + "/" + a(paramLong2));
    this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(i1);
  }
  
  private void a(Dialog paramDialog)
  {
    if ((BaseActivity.mAppForground) && (!isFinishing())) {}
    try
    {
      paramDialog.show();
      return;
    }
    catch (Throwable paramDialog) {}
  }
  
  private void a(boolean paramBoolean)
  {
    if (!this.jdField_p_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (!this.jdField_l_of_type_Boolean);
      if (this.B == 0) {
        paramBoolean = true;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null);
    this.jdField_p_of_type_Boolean = false;
    HashMap localHashMap = new HashMap();
    String str = "actShortVideoDownloadVideo";
    if (this.jdField_c_of_type_Int == 6) {
      str = "actShortVideoDownloadVideo";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "reportTag = " + str);
      }
      localHashMap.put("param_uuid", this.jdField_q_of_type_JavaLangString);
      localHashMap.put("param_picSize", String.valueOf(this.jdField_g_of_type_Long));
      localHashMap.put("param_fileMd5", this.jdField_g_of_type_JavaLangString);
      localHashMap.put("param_busiType", this.jdField_b_of_type_Int + "");
      localHashMap.put("param_videoDuration", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime));
      if (!paramBoolean) {
        break;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, str, true, this.jdField_q_of_type_Long, this.jdField_g_of_type_Long, localHashMap, "");
      return;
      if ((this.jdField_c_of_type_Int == 9) || (this.jdField_c_of_type_Int == 17))
      {
        str = "actShortVideoDiscussgroupDownloadVideo";
        localHashMap.put("param_grpUin", this.jdField_j_of_type_JavaLangString);
      }
    }
    if (this.B != -9527) {
      localHashMap.remove("param_rspHeader");
    }
    localHashMap.put("param_FailCode", String.valueOf(this.B));
    StatisticCollector.a(BaseApplication.getContext()).a(null, str, false, this.jdField_q_of_type_Long, 0L, localHashMap, "");
  }
  
  private boolean a(Context paramContext)
  {
    File localFile = Environment.getExternalStorageDirectory();
    if ((localFile.exists()) && (localFile.canWrite()))
    {
      i1 = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i1 == 0)) {
        break label72;
      }
    }
    label72:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0) {
        break label77;
      }
      QQToast.a(paramContext, 1, 2131434753, 0).b(paramContext.getResources().getDimensionPixelSize(2131558448));
      return false;
      i1 = 0;
      break;
    }
    label77:
    return true;
  }
  
  private String b(String paramString)
  {
    if (paramString == null) {}
    do
    {
      int i1;
      do
      {
        return null;
        i1 = paramString.indexOf(':');
      } while ((i1 < 0) || (i1 + 1 >= paramString.length()));
      paramString = paramString.substring(i1 + 1);
    } while (paramString == null);
    return paramString.trim();
  }
  
  private void b(String paramString)
  {
    if (StringUtil.a(paramString)) {}
    for (;;)
    {
      return;
      paramString = paramString.split("\r\n");
      if (paramString != null)
      {
        this.jdField_t_of_type_Int = a(paramString[0]);
        int i1 = 1;
        Object localObject1;
        if (i1 < paramString.length)
        {
          localObject1 = paramString[i1];
          if (((String)localObject1).startsWith("User-ReturnCode")) {
            this.jdField_m_of_type_JavaLangString = b((String)localObject1);
          }
          for (;;)
          {
            i1 += 1;
            break;
            if (((String)localObject1).startsWith("X-RtFlag")) {
              this.jdField_n_of_type_JavaLangString = b((String)localObject1);
            } else if (((String)localObject1).startsWith("Content-Type")) {
              this.jdField_o_of_type_JavaLangString = b((String)localObject1);
            }
          }
        }
        if ((jdField_b_of_type_ArrayOfJavaLangString != null) && (jdField_b_of_type_ArrayOfJavaLangString.length > 0) && (this.jdField_o_of_type_JavaLangString != null) && (this.jdField_o_of_type_JavaLangString.length() > 0))
        {
          if ((jdField_b_of_type_ArrayOfJavaLangString.length == 1) && (jdField_b_of_type_ArrayOfJavaLangString[0] != null) && (jdField_b_of_type_ArrayOfJavaLangString[0].toLowerCase().equals("allin")))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoPlayActivity", 2, "check content all in");
            }
            i1 = 1;
          }
          while (i1 == 0)
          {
            paramString = new StringBuilder();
            localObject1 = jdField_b_of_type_ArrayOfJavaLangString;
            int i2 = localObject1.length;
            i1 = 0;
            while (i1 < i2)
            {
              localObject2 = localObject1[i1];
              if (localObject2 != null)
              {
                paramString.append((String)localObject2);
                paramString.append("|");
              }
              i1 += 1;
              continue;
              paramString = jdField_b_of_type_ArrayOfJavaLangString;
              i2 = paramString.length;
              i1 = 0;
              for (;;)
              {
                if (i1 >= i2) {
                  break label439;
                }
                localObject1 = paramString[i1];
                if ((localObject1 != null) && (this.jdField_o_of_type_JavaLangString.contains((CharSequence)localObject1)))
                {
                  i1 = 1;
                  break;
                }
                i1 += 1;
              }
            }
            localObject1 = "not accept content type: real:" + this.jdField_o_of_type_JavaLangString + ". whiteList_type :" + paramString.toString();
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoPlayActivity", 2, (String)localObject1);
            }
            Object localObject2 = new HashMap();
            ((HashMap)localObject2).put(BaseConstants.RDM_NoChangeFailCode, "");
            ((HashMap)localObject2).put("Content-Type", this.jdField_o_of_type_JavaLangString);
            ((HashMap)localObject2).put("White-List", paramString.toString());
            StatisticCollector.a(BaseApplication.getContext()).a(null, "actSDKDownloadHijacked", true, 0L, 0L, (HashMap)localObject2, "");
            throw new IOException((String)localObject1);
            label439:
            i1 = 0;
          }
        }
      }
    }
  }
  
  private void u()
  {
    if (this.jdField_f_of_type_Boolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      if ((ShortVideoBusiManager.jdField_a_of_type_Boolean) || (System.currentTimeMillis() - ShortVideoBusiManager.jdField_a_of_type_Long < 300000L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "needRemind=false");
        }
        i1 = 0;
      }
      if (i1 != 0)
      {
        Object localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131437376);
        QQCustomDialog localQQCustomDialog = DialogUtil.b(this.jdField_a_of_type_AndroidContentContext, 230, null, (String)localObject, 2131432995, 2131432994, new yar(this), new yas(this));
        localObject = CUOpenCardGuideMng.a(this.jdField_a_of_type_AndroidContentContext, this.app, 1, (String)localObject);
        if ((localObject instanceof SpannableString)) {
          localQQCustomDialog.setMessageWithoutAutoLink((CharSequence)localObject);
        }
        j();
        this.jdField_h_of_type_Boolean = false;
        a(localQQCustomDialog);
      }
      return;
    }
  }
  
  private void v()
  {
    this.jdField_t_of_type_Long = System.currentTimeMillis();
    this.jdField_m_of_type_Boolean = true;
    TVK_SDKMgr.installPlugin(getApplicationContext(), new xzx(this));
  }
  
  private void w()
  {
    Object localObject;
    if (this.jdField_g_of_type_Boolean)
    {
      localObject = this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      if ((localObject instanceof ShortVideoUploadProcessor))
      {
        localObject = (ShortVideoUploadProcessor)localObject;
        a(((ShortVideoUploadProcessor)localObject).b(), ((ShortVideoUploadProcessor)localObject).a());
      }
      localObject = FileTransferManager.a(this.app);
      if (localObject != null) {
        ((FileTransferManager)localObject).a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this);
      }
      this.jdField_b_of_type_JavaLangString = ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
      if (new File(this.jdField_b_of_type_JavaLangString).exists())
      {
        long l1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
        this.jdField_g_of_type_Long = l1;
        this.jdField_f_of_type_Long = l1;
        this.jdField_k_of_type_Int = 10000;
      }
      for (;;)
      {
        a(this.jdField_c_of_type_Long);
        return;
        a("上传状态错误，文件不存在");
      }
    }
    l();
    if ((this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 2) || (this.jdField_b_of_type_Int == 4) || (this.jdField_d_of_type_Int == 9501))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if ((this.jdField_b_of_type_Int != 2) || (this.jdField_e_of_type_JavaLangString == null)) {}
    }
    try
    {
      localObject = new JSONObject(this.jdField_e_of_type_JavaLangString);
      this.jdField_c_of_type_Int = 1001;
      this.jdField_b_of_type_JavaLangString = a(((JSONObject)localObject).getString("file_md5"));
      this.jdField_g_of_type_Long = ((JSONObject)localObject).getInt("file_size");
      this.jdField_q_of_type_JavaLangString = ((JSONObject)localObject).getString("file_uuid");
      label285:
      localObject = new File(this.jdField_b_of_type_JavaLangString);
      if ((((File)localObject).exists()) && (((File)localObject).isFile()))
      {
        this.jdField_f_of_type_Long = ((File)localObject).length();
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "onCreateVideoSdkView(), #PLAY_CALLER_STRUCT_MSG#, have video size=" + this.jdField_f_of_type_Long + " msg.size=" + this.jdField_g_of_type_Long);
        }
        if (this.jdField_f_of_type_Long < this.jdField_g_of_type_Long) {
          this.jdField_f_of_type_Boolean = true;
        }
        if (this.jdField_f_of_type_Boolean)
        {
          y();
          localObject = FileTransferManager.a(this.app);
          if (localObject != null) {
            ((FileTransferManager)localObject).a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this);
          }
          this.jdField_a_of_type_AndroidWidgetSeekBar.setSecondaryProgress(this.jdField_k_of_type_Int);
        }
      }
      label926:
      label948:
      for (;;)
      {
        this.jdField_l_of_type_Boolean = this.jdField_f_of_type_Boolean;
        if (this.jdField_f_of_type_Boolean) {
          break label950;
        }
        a(this.jdField_c_of_type_Long);
        return;
        this.jdField_f_of_type_Boolean = true;
        break;
        if (this.jdField_b_of_type_Int == 0)
        {
          int i1;
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getBitValue(1) == 0)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getBitValue(0) == 1)
            {
              i1 = 101;
              label500:
              PredictionReporter.a(1000, i1);
              this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.setBitValue(1, (byte)1);
              ThreadManager.getFileThreadHandler().post(new yab(this));
            }
          }
          else
          {
            this.jdField_b_of_type_JavaLangString = ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
            localObject = new File(this.jdField_b_of_type_JavaLangString);
            if (!((File)localObject).exists()) {
              break label926;
            }
            this.jdField_f_of_type_Long = ((File)localObject).length();
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoPlayActivity", 2, "onCreateVideoSdkView(), #PLAY_CALLER_SHORT_VIDEO#, have video size=" + this.jdField_f_of_type_Long + " msg.size=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize + " status=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus);
            }
            this.jdField_g_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
            this.jdField_k_of_type_Int = 10000;
            this.jdField_a_of_type_AndroidWidgetSeekBar.setSecondaryProgress(10000);
            this.jdField_e_of_type_Boolean = false;
            if (this.jdField_f_of_type_Long >= this.jdField_g_of_type_Long) {}
          }
          for (this.jdField_f_of_type_Boolean = true;; this.jdField_f_of_type_Boolean = true)
          {
            if (!this.jdField_f_of_type_Boolean) {
              break label948;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoPlayActivity", 2, "initData, #PLAY_CALLER_SHORT_VIDEO#, need download, startDownload...");
            }
            if (a(this.jdField_a_of_type_AndroidContentContext))
            {
              localObject = ShortVideoBusiManager.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 1);
              if (localObject != null)
              {
                ShortVideoBusiManager.a((ShortVideoReq)localObject, this.app);
                this.jdField_c_of_type_Int = ((ShortVideoReq)localObject).a.jdField_e_of_type_Int;
                a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
              }
            }
            localObject = FileTransferManager.a(this.app);
            if (localObject != null) {
              ((FileTransferManager)localObject).a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this);
            }
            this.jdField_f_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.transferedSize;
            this.jdField_g_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
            this.jdField_k_of_type_Int = ((int)(10000L * this.jdField_f_of_type_Long / this.jdField_g_of_type_Long));
            this.jdField_j_of_type_Int = 0;
            this.jdField_h_of_type_Long = 0L;
            this.jdField_e_of_type_Boolean = true;
            this.jdField_a_of_type_AndroidWidgetSeekBar.setSecondaryProgress(this.jdField_k_of_type_Int);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ShortVideoPlayActivity", 2, "onCreateVideoSdkView() mCacheProgress=" + this.jdField_k_of_type_Int + ",mTransferredSize=" + this.jdField_f_of_type_Long);
            break;
            i1 = 102;
            break label500;
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoPlayActivity", 2, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
            }
          }
        }
      }
      label950:
      p();
      a(4);
      return;
    }
    catch (Exception localException)
    {
      break label285;
    }
  }
  
  private void x()
  {
    if ((VersionUtils.g()) && (!ShortVideoUtils.c()) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setSystemUiVisibility(1284);
    }
  }
  
  private void y()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "startDownLoadVideoForPubAccount: " + this.jdField_e_of_type_JavaLangString);
    }
    Object localObject = Environment.getExternalStorageDirectory();
    int i1;
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      i1 = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i1 == 0)) {
        break label113;
      }
      i1 = 1;
      label74:
      if (i1 != 0) {
        break label118;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131434753, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
    }
    label113:
    label118:
    ShortVideoDownloadInfo localShortVideoDownloadInfo;
    do
    {
      return;
      i1 = 0;
      break;
      i1 = 0;
      break label74;
      localObject = ShortVideoBusiManager.a(2, 0);
      localShortVideoDownloadInfo = a();
      if ((!AppNetConnInfo.isWifiConn()) && (localShortVideoDownloadInfo != null) && (localShortVideoDownloadInfo.jdField_b_of_type_Long > 204800L)) {
        a(DialogUtil.a(this, 230, getString(2131437378), getString(2131437377), new yac(this), new yad(this)));
      }
    } while (localShortVideoDownloadInfo == null);
    localShortVideoDownloadInfo.jdField_a_of_type_Boolean = true;
    ((ShortVideoReq)localObject).a = localShortVideoDownloadInfo;
    ShortVideoBusiManager.a((ShortVideoReq)localObject, this.app);
    this.jdField_k_of_type_JavaLangString = localShortVideoDownloadInfo.jdField_h_of_type_JavaLangString;
  }
  
  private void z()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  /* Error */
  public void OnDownloadCallback(String paramString)
  {
    // Byte code:
    //   0: new 372	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 375	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: ldc_w 947
    //   13: invokevirtual 380	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   16: istore_2
    //   17: aload_1
    //   18: ldc_w 949
    //   21: invokevirtual 380	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   24: istore_3
    //   25: iload_3
    //   26: i2l
    //   27: aload_0
    //   28: getfield 260	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_g_of_type_Long	J
    //   31: lcmp
    //   32: ifeq +39 -> 71
    //   35: aload_0
    //   36: iload_3
    //   37: i2l
    //   38: putfield 260	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_g_of_type_Long	J
    //   41: ldc_w 474
    //   44: iconst_2
    //   45: new 411	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 412	java/lang/StringBuilder:<init>	()V
    //   52: ldc_w 951
    //   55: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: getfield 260	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_g_of_type_Long	J
    //   62: invokevirtual 416	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   65: invokevirtual 423	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 484	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: aload_1
    //   72: ldc_w 953
    //   75: invokevirtual 380	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   78: istore 4
    //   80: aload_0
    //   81: aload_1
    //   82: ldc_w 955
    //   85: invokevirtual 380	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   88: i2l
    //   89: putfield 267	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_f_of_type_Long	J
    //   92: aload_1
    //   93: ldc_w 957
    //   96: invokevirtual 380	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   99: istore 5
    //   101: aload_0
    //   102: iload 5
    //   104: putfield 959	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_m_of_type_Int	I
    //   107: iload 5
    //   109: ifle +13 -> 122
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 961	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_n_of_type_Int	I
    //   117: iconst_1
    //   118: iadd
    //   119: putfield 961	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_n_of_type_Int	I
    //   122: aload_1
    //   123: ldc_w 963
    //   126: invokevirtual 380	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   129: istore 6
    //   131: aload_0
    //   132: getfield 965	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_o_of_type_Int	I
    //   135: iload 6
    //   137: if_icmpge +9 -> 146
    //   140: aload_0
    //   141: iload 6
    //   143: putfield 965	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_o_of_type_Int	I
    //   146: aload_0
    //   147: aload_1
    //   148: ldc_w 967
    //   151: invokevirtual 380	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   154: putfield 691	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_l_of_type_Int	I
    //   157: iload_2
    //   158: bipush 7
    //   160: if_icmpeq +8 -> 168
    //   163: iload_2
    //   164: iconst_3
    //   165: if_icmpne +497 -> 662
    //   168: iload_2
    //   169: bipush 7
    //   171: if_icmpne +27 -> 198
    //   174: aload_0
    //   175: iconst_0
    //   176: putfield 152	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_f_of_type_Boolean	Z
    //   179: aload_0
    //   180: aload_0
    //   181: getfield 260	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_g_of_type_Long	J
    //   184: putfield 267	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_f_of_type_Long	J
    //   187: aload_0
    //   188: sipush 2003
    //   191: putfield 166	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:C	I
    //   194: aload_0
    //   195: invokespecial 969	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:B	()V
    //   198: aload_0
    //   199: getfield 971	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_r_of_type_Long	J
    //   202: lconst_0
    //   203: lcmp
    //   204: ifeq +20 -> 224
    //   207: aload_0
    //   208: invokestatic 708	java/lang/System:currentTimeMillis	()J
    //   211: aload_0
    //   212: getfield 971	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_r_of_type_Long	J
    //   215: lsub
    //   216: putfield 565	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_q_of_type_Long	J
    //   219: aload_0
    //   220: lconst_0
    //   221: putfield 971	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_r_of_type_Long	J
    //   224: aload_0
    //   225: getfield 973	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:w	I
    //   228: ifne +14 -> 242
    //   231: aload_0
    //   232: aload_1
    //   233: ldc_w 975
    //   236: invokevirtual 380	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   239: putfield 973	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:w	I
    //   242: aload_0
    //   243: getfield 977	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:x	I
    //   246: ifne +14 -> 260
    //   249: aload_0
    //   250: aload_1
    //   251: ldc_w 979
    //   254: invokevirtual 380	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   257: putfield 977	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:x	I
    //   260: aload_1
    //   261: ldc_w 981
    //   264: invokevirtual 984	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   267: ifeq +21 -> 288
    //   270: aload_0
    //   271: getfield 986	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:y	I
    //   274: ifne +14 -> 288
    //   277: aload_0
    //   278: aload_1
    //   279: ldc_w 981
    //   282: invokevirtual 380	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   285: putfield 986	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:y	I
    //   288: aload_1
    //   289: ldc_w 988
    //   292: invokevirtual 984	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   295: ifeq +21 -> 316
    //   298: aload_0
    //   299: getfield 990	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:z	I
    //   302: ifne +14 -> 316
    //   305: aload_0
    //   306: aload_1
    //   307: ldc_w 988
    //   310: invokevirtual 380	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   313: putfield 990	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:z	I
    //   316: aload_1
    //   317: ldc_w 992
    //   320: invokevirtual 984	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   323: ifeq +21 -> 344
    //   326: aload_0
    //   327: getfield 994	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:A	I
    //   330: ifne +14 -> 344
    //   333: aload_0
    //   334: aload_1
    //   335: ldc_w 992
    //   338: invokevirtual 380	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   341: putfield 994	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:A	I
    //   344: aload_1
    //   345: ldc_w 996
    //   348: invokevirtual 984	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   351: ifeq +21 -> 372
    //   354: aload_0
    //   355: getfield 998	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_p_of_type_JavaLangString	Ljava/lang/String;
    //   358: ifnonnull +14 -> 372
    //   361: aload_0
    //   362: aload_1
    //   363: ldc_w 996
    //   366: invokevirtual 387	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   369: putfield 998	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_p_of_type_JavaLangString	Ljava/lang/String;
    //   372: invokestatic 472	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   375: ifeq +397 -> 772
    //   378: new 411	java/lang/StringBuilder
    //   381: dup
    //   382: ldc_w 1000
    //   385: invokespecial 454	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   388: astore_1
    //   389: aload_1
    //   390: ldc_w 1002
    //   393: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: iload_2
    //   397: invokevirtual 479	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   400: ldc_w 669
    //   403: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload_1
    //   408: ldc_w 1004
    //   411: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: iload_3
    //   415: invokevirtual 479	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   418: ldc_w 669
    //   421: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload_1
    //   426: ldc_w 1006
    //   429: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: iload 4
    //   434: invokevirtual 479	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   437: ldc_w 669
    //   440: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload_1
    //   445: ldc_w 1008
    //   448: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload_0
    //   452: getfield 267	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_f_of_type_Long	J
    //   455: invokevirtual 416	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   458: ldc_w 669
    //   461: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: aload_1
    //   466: ldc_w 1010
    //   469: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: iload 5
    //   474: invokevirtual 479	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   477: ldc_w 669
    //   480: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload_1
    //   485: ldc_w 1012
    //   488: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: iload 6
    //   493: invokevirtual 479	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   496: ldc_w 669
    //   499: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: aload_1
    //   504: ldc_w 1014
    //   507: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: aload_0
    //   511: getfield 691	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_l_of_type_Int	I
    //   514: invokevirtual 479	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   517: ldc_w 669
    //   520: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload_1
    //   525: ldc_w 1016
    //   528: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: aload_0
    //   532: getfield 973	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:w	I
    //   535: invokevirtual 479	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   538: ldc_w 669
    //   541: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: aload_1
    //   546: ldc_w 1018
    //   549: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: aload_0
    //   553: getfield 977	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:x	I
    //   556: invokevirtual 479	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   559: ldc_w 669
    //   562: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload_1
    //   567: ldc_w 1020
    //   570: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: aload_0
    //   574: getfield 986	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:y	I
    //   577: invokevirtual 479	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   580: ldc_w 669
    //   583: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: pop
    //   587: aload_1
    //   588: ldc_w 1022
    //   591: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: aload_0
    //   595: getfield 990	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:z	I
    //   598: invokevirtual 479	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   601: ldc_w 669
    //   604: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: aload_1
    //   609: ldc_w 1024
    //   612: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: aload_0
    //   616: getfield 994	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:A	I
    //   619: invokevirtual 479	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   622: ldc_w 669
    //   625: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: aload_1
    //   630: ldc_w 1026
    //   633: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: aload_0
    //   637: getfield 998	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_p_of_type_JavaLangString	Ljava/lang/String;
    //   640: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: ldc_w 669
    //   646: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: ldc_w 474
    //   653: iconst_2
    //   654: aload_1
    //   655: invokevirtual 423	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   658: invokestatic 1028	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   661: return
    //   662: iload_2
    //   663: iconst_1
    //   664: if_icmpne -440 -> 224
    //   667: aload_1
    //   668: ldc_w 1030
    //   671: invokevirtual 984	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   674: ifeq -450 -> 224
    //   677: aload_1
    //   678: ldc_w 1030
    //   681: invokevirtual 387	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   684: astore 7
    //   686: aload_0
    //   687: aload 7
    //   689: invokespecial 1032	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:b	(Ljava/lang/String;)V
    //   692: aload_0
    //   693: getfield 652	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   696: invokestatic 1037	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   699: ifne -475 -> 224
    //   702: aload_0
    //   703: getfield 652	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   706: ldc_w 1039
    //   709: invokevirtual 602	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   712: ifeq -488 -> 224
    //   715: aload_0
    //   716: sipush 5002
    //   719: putfield 166	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:C	I
    //   722: aload_0
    //   723: invokespecial 969	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:B	()V
    //   726: aload_0
    //   727: ldc_w 1041
    //   730: invokevirtual 805	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:a	(Ljava/lang/String;)V
    //   733: goto -509 -> 224
    //   736: astore_1
    //   737: aload_1
    //   738: invokevirtual 1042	org/json/JSONException:printStackTrace	()V
    //   741: return
    //   742: astore 7
    //   744: aload_0
    //   745: sipush 9064
    //   748: putfield 528	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:B	I
    //   751: aload_0
    //   752: sipush 2005
    //   755: putfield 166	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:C	I
    //   758: aload_0
    //   759: invokespecial 969	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:B	()V
    //   762: aload_0
    //   763: ldc_w 1044
    //   766: invokevirtual 805	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:a	(Ljava/lang/String;)V
    //   769: goto -77 -> 692
    //   772: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	773	0	this	ShortVideoPlayActivity
    //   0	773	1	paramString	String
    //   16	649	2	i1	int
    //   24	391	3	i2	int
    //   78	355	4	i3	int
    //   99	374	5	i4	int
    //   129	363	6	i5	int
    //   684	4	7	str	String
    //   742	1	7	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   0	71	736	org/json/JSONException
    //   71	107	736	org/json/JSONException
    //   112	122	736	org/json/JSONException
    //   122	146	736	org/json/JSONException
    //   146	157	736	org/json/JSONException
    //   174	198	736	org/json/JSONException
    //   198	224	736	org/json/JSONException
    //   224	242	736	org/json/JSONException
    //   242	260	736	org/json/JSONException
    //   260	288	736	org/json/JSONException
    //   288	316	736	org/json/JSONException
    //   316	344	736	org/json/JSONException
    //   344	372	736	org/json/JSONException
    //   372	661	736	org/json/JSONException
    //   667	686	736	org/json/JSONException
    //   686	692	736	org/json/JSONException
    //   692	733	736	org/json/JSONException
    //   744	769	736	org/json/JSONException
    //   686	692	742	java/io/IOException
  }
  
  String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "null";
    case 0: 
      return " idle ";
    case 1: 
      return " playing ";
    case 2: 
      return " pause ";
    case 3: 
      return " error ";
    }
    return " buffering ";
  }
  
  public void a()
  {
    int i1 = 1;
    if (!this.jdField_a_of_type_Boolean)
    {
      TVK_SDKMgr.initSdk(getApplicationContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      this.jdField_a_of_type_Boolean = true;
    }
    if (TVK_SDKMgr.isInstalled(getApplicationContext()))
    {
      b();
      return;
    }
    if (NetworkUtil.b(BaseApplication.getContext()) == 1) {}
    while (i1 != 0)
    {
      v();
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430792), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131558448));
      return;
      i1 = 0;
    }
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 232, null, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430790), new xzv(this), new xzw(this)).show();
  }
  
  void a(int paramInt)
  {
    runOnUiThread(new yaf(this, paramInt));
  }
  
  void a(int paramInt1, int paramInt2)
  {
    this.jdField_i_of_type_Int = 0;
    this.B = 9001;
    String str1 = getString(2131437348);
    Object localObject;
    int i2;
    if ((paramInt1 == 101) && (this.jdField_a_of_type_ArrayOfJavaLangString != null) && (!StringUtil.a(this.jdField_a_of_type_JavaLangString)))
    {
      localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
      i2 = localObject.length;
      i1 = 0;
      while (i1 < i2)
      {
        String str2 = localObject[i1];
        if (!StringUtil.a(str2)) {
          InnerDns.a().a(this.jdField_a_of_type_JavaLangString, InnerDns.a(str2), 1005);
        }
        i1 += 1;
      }
    }
    if (this.jdField_b_of_type_Int == 1)
    {
      p();
      q();
      str1 = getString(2131437368);
      localObject = str1;
      if (paramInt1 == 122) {
        if (paramInt2 != 204)
        {
          localObject = str1;
          if (paramInt2 != 202) {}
        }
        else
        {
          localObject = getString(2131437368);
        }
      }
      a(DialogUtil.a(this, 232, null, (String)localObject, new yaj(this), null));
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "handleError，mPlayCallerType = " + this.jdField_b_of_type_Int);
      }
      this.jdField_d_of_type_Long = -1L;
      this.jdField_e_of_type_Long = -1L;
      return;
    }
    if (this.jdField_b_of_type_Int == 0)
    {
      if (this.jdField_c_of_type_Boolean) {
        break label408;
      }
      i2 = (int)(DeviceInfoUtil.f() / 1024L);
      if (StringUtil.a(this.jdField_b_of_type_JavaLangString)) {
        break label411;
      }
    }
    label408:
    label411:
    for (int i1 = (int)(new File(this.jdField_b_of_type_JavaLangString).length() / 1024L);; i1 = 0)
    {
      localObject = DeviceInfoUtil.e();
      ReportController.b(this.app, "CliOper", "", "", "0X8004674", "0X8004674", 0, 0, "" + i2, "" + i1, (String)localObject, this.jdField_g_of_type_JavaLangString);
      this.jdField_c_of_type_Boolean = true;
      break;
      if (this.jdField_b_of_type_Int == 2)
      {
        a(this.jdField_c_of_type_JavaLangString, 0, 1002, this.jdField_d_of_type_JavaLangString);
        str1 = getString(2131437368);
        break;
      }
      break;
    }
  }
  
  public void a(long paramLong)
  {
    l1 = paramLong;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          l1 = paramLong;
          QLog.d("ShortVideoPlayActivity", 2, "#play#, msec=" + paramLong);
        }
        l1 = paramLong;
        this.jdField_a_of_type_Long = paramLong;
        l1 = paramLong;
        this.jdField_o_of_type_Boolean = true;
        int i1 = 0;
        l1 = paramLong;
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
        {
          l1 = paramLong;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(getApplicationContext(), (IVideoViewBase)this.jdField_b_of_type_AndroidViewView);
          l1 = paramLong;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(this);
          l1 = paramLong;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(this);
          l1 = paramLong;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(this);
          l1 = paramLong;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnSeekCompleteListener(this);
          l1 = paramLong;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(this);
          l1 = paramLong;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnNetVideoInfoListener(this);
          l1 = paramLong;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparingListener(this);
          l1 = paramLong;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(this);
          l1 = paramLong;
          this.jdField_m_of_type_Long = System.currentTimeMillis();
          i1 = 1;
        }
        l1 = paramLong;
        if (this.jdField_k_of_type_Boolean)
        {
          i1 = 1;
          l1 = paramLong;
          this.jdField_r_of_type_Int += 1;
        }
        if (i1 == 0) {
          continue;
        }
        if (paramLong != 0L) {
          continue;
        }
        l1 = paramLong;
        if (this.jdField_a_of_type_AndroidWidgetSeekBar.getProgress() <= 0) {
          continue;
        }
        l1 = paramLong;
        if (this.jdField_a_of_type_AndroidWidgetSeekBar.getProgress() >= 10000) {
          continue;
        }
        l1 = paramLong;
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) {
          continue;
        }
        l1 = paramLong;
        i1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime * 1000 * this.jdField_a_of_type_AndroidWidgetSeekBar.getProgress() / 100;
        paramLong = i1;
        try
        {
          if ((this.jdField_a_of_type_ArrayOfJavaLangString == null) || (!this.jdField_f_of_type_Boolean)) {
            continue;
          }
          String str;
          if ((this.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
          {
            str = ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
            localObject = new TVK_PlayerVideoInfo();
            ((TVK_PlayerVideoInfo)localObject).setConfigMap("file_dir", str);
            ((TVK_PlayerVideoInfo)localObject).setConfigMap("cache_servers_type", "20160518");
            ((TVK_PlayerVideoInfo)localObject).setConfigMap("keep_last_frame", "true");
            HashMap localHashMap = new HashMap();
            localHashMap.put("shouq_bus_type", "bus_type_aio_shortvideo_url");
            ((TVK_PlayerVideoInfo)localObject).setReportInfoMap(localHashMap);
            if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) {
              ((TVK_PlayerVideoInfo)localObject).setConfigMap("duration", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime));
            }
            ((TVK_PlayerVideoInfo)localObject).setVid(this.jdField_g_of_type_JavaLangString);
            ((TVK_PlayerVideoInfo)localObject).setPlayMode("cache_extend_video");
            if (QLog.isColorLevel())
            {
              QLog.d("ShortVideoPlayActivity", 2, "#play#, setVid =" + this.jdField_g_of_type_JavaLangString + " videoPath=" + str);
              QLog.d("ShortVideoPlayActivity", 2, "#play#, url0 =" + this.jdField_a_of_type_ArrayOfJavaLangString[0]);
            }
            this.jdField_r_of_type_Long = System.currentTimeMillis();
            this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_ArrayOfJavaLangString, paramLong, 0L, (TVK_PlayerVideoInfo)localObject, null);
            l1 = paramLong;
            this.jdField_k_of_type_Boolean = false;
            l1 = paramLong;
            if (this.jdField_b_of_type_Int == 0)
            {
              l1 = paramLong;
              if (!this.jdField_b_of_type_Boolean)
              {
                l1 = paramLong;
                if (this.jdField_d_of_type_Int != 0) {
                  continue;
                }
                l1 = paramLong;
                ReportController.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "1", "", "");
                l1 = paramLong;
                this.jdField_b_of_type_Boolean = true;
              }
            }
            l1 = paramLong;
            if (this.jdField_e_of_type_Long >= 0L)
            {
              l1 = paramLong;
              this.jdField_d_of_type_Long += System.currentTimeMillis() - this.jdField_e_of_type_Long;
            }
            l1 = paramLong;
            this.jdField_e_of_type_Long = System.currentTimeMillis();
            return;
          }
          if ((this.jdField_b_of_type_Int == 2) && (this.jdField_e_of_type_JavaLangString != null))
          {
            str = this.jdField_k_of_type_JavaLangString;
            continue;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ShortVideoPlayActivity", 2, "#play#, mVideo caller type not right:" + this.jdField_b_of_type_Int);
          return;
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        Object localObject;
        TVK_PlayerVideoInfo localTVK_PlayerVideoInfo;
        paramLong = l1;
        continue;
      }
      QLog.d("ShortVideoPlayActivity", 1, "#play#, msec=" + paramLong, localException1);
      i();
      a(0, 0);
      return;
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "#play#, videoPath=" + this.jdField_b_of_type_JavaLangString);
        }
        localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
        localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
        localTVK_PlayerVideoInfo.setPlayType(4);
        localObject = new HashMap();
        ((Map)localObject).put("shouq_bus_type", "bus_type_aio_shortvideo_local");
        localTVK_PlayerVideoInfo.setReportInfoMap((Map)localObject);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_b_of_type_JavaLangString, paramLong, 0L, localTVK_PlayerVideoInfo);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoPlayActivity", 2, "#play#, mVideoPath should not be null!");
        return;
        l1 = paramLong;
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo((int)paramLong);
        continue;
        l1 = paramLong;
        if (this.jdField_d_of_type_Int == 3000)
        {
          l1 = paramLong;
          ReportController.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "2", "", "");
          l1 = paramLong;
          this.jdField_b_of_type_Boolean = true;
        }
        else
        {
          l1 = paramLong;
          if (this.jdField_d_of_type_Int == 1)
          {
            l1 = paramLong;
            ReportController.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "3", "", "");
            l1 = paramLong;
            this.jdField_b_of_type_Boolean = true;
          }
          else
          {
            l1 = paramLong;
            ReportController.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "4", "", "");
            l1 = paramLong;
            this.jdField_b_of_type_Boolean = true;
          }
        }
      }
    }
  }
  
  void a(Intent paramIntent)
  {
    this.jdField_b_of_type_JavaLangString = paramIntent.getExtras().getString("file_send_path");
    this.jdField_b_of_type_Int = paramIntent.getExtras().getInt("video_play_caller", 0);
    this.jdField_c_of_type_JavaLangString = paramIntent.getExtras().getString("ad_gdt");
    this.jdField_d_of_type_JavaLangString = paramIntent.getExtras().getString("msg_id");
    this.jdField_e_of_type_Int = paramIntent.getExtras().getInt("from_uin_type");
    this.jdField_j_of_type_JavaLangString = paramIntent.getExtras().getString("from_session_uin");
    this.jdField_d_of_type_Int = paramIntent.getExtras().getInt("uintype");
    this.jdField_e_of_type_JavaLangString = paramIntent.getExtras().getString("struct_msg_video_info");
    this.jdField_f_of_type_JavaLangString = paramIntent.getExtras().getString("from_uin");
    this.jdField_k_of_type_Long = paramIntent.getExtras().getLong("message_click_start");
    this.jdField_q_of_type_JavaLangString = paramIntent.getExtras().getString("file_uuid");
    this.jdField_g_of_type_JavaLangString = paramIntent.getExtras().getString("file_shortvideo_md5");
    this.jdField_h_of_type_JavaLangString = paramIntent.getExtras().getString("thumbfile_md5");
    this.jdField_s_of_type_Boolean = paramIntent.getExtras().getBoolean("is_hotVideo");
    this.jdField_r_of_type_JavaLangString = paramIntent.getExtras().getString("hot_video_icon");
    this.jdField_t_of_type_JavaLangString = paramIntent.getExtras().getString("hot_video_icon_sub");
    this.jdField_s_of_type_JavaLangString = paramIntent.getExtras().getString("hot_video_url");
    this.jdField_u_of_type_JavaLangString = paramIntent.getExtras().getString("hot_video_title");
    if (this.jdField_b_of_type_Int == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)paramIntent.getExtras().getParcelable("key_message_for_shortvideo"));
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)
      {
        QQToast.a(this, 1, "参数错误，传入的shortvideoMsg为空！", 0).b(getTitleBarHeight());
        finish();
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "initData(), PLAY_CALLER_SHORT_VIDEO, msg = " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.toLogString() + ", mUinType = " + this.jdField_d_of_type_Int);
      }
    }
    QLog.d("ShortVideoPlayActivity", 2, "initData(): mVideoPath=" + this.jdField_b_of_type_JavaLangString + ", mPlayCallerType=" + this.jdField_b_of_type_Int + ", mCursessionType = " + this.jdField_e_of_type_Int + ", mCurSessionUin = " + this.jdField_j_of_type_JavaLangString + ", mUinType = " + this.jdField_d_of_type_Int);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    int i1 = 0;
    if (((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq != paramFileMsg.jdField_b_of_type_Long)) && (this.jdField_b_of_type_Int != 2)) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, " handleMessage what==" + paramInt1 + ", arg1:" + paramInt2);
        }
        if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
          QLog.d("ShortVideoPlayActivity", 2, "handleMessage msg.uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq + ",fileType:" + ShortVideoUtils.a(paramFileMsg.jdField_b_of_type_Int) + " ===> fileStatus:" + ShortVideoUtils.b(paramFileMsg.jdField_d_of_type_Int));
        }
      } while ((paramFileMsg.jdField_b_of_type_Int != 6) && (paramFileMsg.jdField_b_of_type_Int != 17) && (paramFileMsg.jdField_b_of_type_Int != 9) && (paramFileMsg.jdField_b_of_type_Int != 20));
      switch (paramFileMsg.jdField_d_of_type_Int)
      {
      case 2004: 
      default: 
        return;
      case 1002: 
        a(paramFileMsg.jdField_e_of_type_Long, paramFileMsg.jdField_a_of_type_Long);
        return;
      case 2003: 
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "handleMessage STATUS_RECV_FINISHED");
        }
        this.jdField_k_of_type_Int = 10000;
        return;
      case 2005: 
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437350, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
        this.B = paramFileMsg.jdField_g_of_type_Int;
        return;
      case 5001: 
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437351, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
        this.B = paramFileMsg.jdField_g_of_type_Int;
        return;
      case 5002: 
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437352, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
        this.B = paramFileMsg.jdField_g_of_type_Int;
        return;
      case 2002: 
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "STATUS_RECV_PROCESS: get url finished");
        }
        this.jdField_f_of_type_Int = ((int)(System.currentTimeMillis() - this.jdField_e_of_type_Long));
      }
    } while (paramFileMsg.c == null);
    this.jdField_a_of_type_ArrayOfJavaLangString = paramFileMsg.c;
    this.jdField_a_of_type_JavaLangString = paramFileMsg.jdField_u_of_type_JavaLangString;
    this.jdField_u_of_type_Long = paramFileMsg.jdField_f_of_type_Long;
    paramInt1 = i1;
    while (paramInt1 < 1)
    {
      if (!StringUtil.a(this.jdField_a_of_type_JavaLangString))
      {
        paramView = new StringBuilder();
        paramFileMsg = this.jdField_a_of_type_ArrayOfJavaLangString;
        paramFileMsg[paramInt1] = (paramFileMsg[paramInt1] + "&txhost=" + this.jdField_a_of_type_JavaLangString);
      }
      paramInt1 += 1;
    }
    a(0L);
    return;
    z();
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo)
  {
    String str = ShortVideoUtils.d(NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext));
    if ((paramMessageForShortVideo.istroop == 0) || (paramMessageForShortVideo.istroop == 1008))
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "1", str, "");
      return;
    }
    if (paramMessageForShortVideo.istroop == 3000)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "2", str, "");
      return;
    }
    if (paramMessageForShortVideo.istroop == 1)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "3", str, "");
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "4", str, "");
  }
  
  public void a(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onCompletion(), mPlayProgress=" + this.jdField_j_of_type_Int + ", mCacheProgress=" + this.jdField_k_of_type_Int + ", mCurPlayPosition" + this.jdField_h_of_type_Long + ", mDuration=" + this.jdField_b_of_type_Long);
    }
    this.jdField_j_of_type_Int = 10000;
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(10000);
    if ((this.jdField_b_of_type_Int == 2) && (this.jdField_a_of_type_Int == 1)) {
      a(this.jdField_c_of_type_JavaLangString, 2, 1002, this.jdField_d_of_type_JavaLangString);
    }
    a(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_AndroidWidgetTextView.getText());
    d();
    this.jdField_c_of_type_Long = 0L;
    this.jdField_k_of_type_Boolean = true;
    if (this.jdField_e_of_type_Long >= 0L)
    {
      this.jdField_d_of_type_Long += System.currentTimeMillis() - this.jdField_e_of_type_Long;
      if (!this.jdField_d_of_type_Boolean)
      {
        new DCShortVideo(BaseApplication.getContext()).a(this.app, 2002, (int)(this.jdField_b_of_type_Long / 1000L), this.jdField_e_of_type_Int, this.jdField_j_of_type_JavaLangString, this.jdField_d_of_type_Long / 1000L);
        this.jdField_d_of_type_Boolean = true;
      }
    }
    t();
  }
  
  public void a(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    this.jdField_u_of_type_Int = paramInt1;
    this.v = paramInt2;
    t();
    a(false);
    this.C = 2005;
    a(3);
    i();
    a(paramInt1, paramInt2);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new xzz(this, paramString));
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    String str;
    if (!TextUtils.isEmpty(paramString1)) {
      str = "0";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString1);
      paramString1 = str;
      if (localJSONObject.has("ad_id")) {
        paramString1 = localJSONObject.getString("ad_id");
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "parse ad_id error");
        }
        paramString1 = "0";
      }
    }
    ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D93", "0X8005D93", paramInt2, 1, paramInt1, paramString1, paramString2, "", "");
  }
  
  public boolean a()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "#resume#");
    }
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_Int == 2))
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      a(1);
    }
    for (;;)
    {
      if (this.jdField_e_of_type_Long >= 0L) {
        this.jdField_d_of_type_Long += System.currentTimeMillis() - this.jdField_e_of_type_Long;
      }
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      return bool;
      bool = false;
    }
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null)
      {
        this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView(this));
        this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-16777216);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        ((IVideoViewBase)this.jdField_b_of_type_AndroidViewView).addViewCallBack(this);
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidViewView, 0);
        w();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3) && (paramInt != 4)) {
      break label24;
    }
    label24:
    do
    {
      do
      {
        return;
      } while (paramInt == this.jdField_a_of_type_Int);
      if (isFinishing())
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ShortVideoPlayActivity", 2, "changePlayState, while finishing");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "changePlayState, " + a(this.jdField_a_of_type_Int) + " ==> " + a(paramInt));
      }
      if ((this.jdField_a_of_type_Int == 1) && (paramInt != 1)) {
        if (this.jdField_j_of_type_Long != 0L) {
          this.jdField_i_of_type_Long += System.currentTimeMillis() - this.jdField_j_of_type_Long;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Int = paramInt;
        switch (paramInt)
        {
        default: 
          return;
        case 0: 
          this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842910);
          return;
          if ((this.jdField_a_of_type_Int == 4) && (paramInt != 4) && (this.jdField_p_of_type_Long != 0L)) {
            this.jdField_o_of_type_Long += System.currentTimeMillis() - this.jdField_p_of_type_Long;
          }
          break;
        }
      }
      this.jdField_j_of_type_Long = System.currentTimeMillis();
      this.jdField_p_of_type_Int += 1;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842912);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 50L);
      e();
      p();
      q();
    } while (this.jdField_f_of_type_AndroidWidgetRelativeLayout == null);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    return;
    this.jdField_q_of_type_Int += 1;
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842910);
    return;
    this.jdField_p_of_type_Long = System.currentTimeMillis();
    this.jdField_s_of_type_Int += 1;
    if (this.jdField_f_of_type_Boolean) {
      this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 50L);
    return;
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842910);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      long l1 = paramLong;
      if (paramLong < 0L) {
        l1 = 0L;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(l1));
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying());
  }
  
  void c()
  {
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)getLayoutInflater().inflate(2130970579, null, false));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131362822));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131371319));
    x();
    this.jdField_a_of_type_AndroidViewView = this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131371314);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131368802));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131371311));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131368804));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131364654));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131364656));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131364655));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(10000);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131371320));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131371312));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131371313));
    if ((this.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1001) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1002)) && (this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq) != null))
    {
      this.jdField_g_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131371315));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131371317));
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(100);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131371316));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131371318));
    }
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131371304));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_e_of_type_AndroidWidgetRelativeLayout);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131365200));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.bringToFront();
    localObject = (RelativeLayout)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131371305);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
    localLayoutParams.topMargin = ImmersiveUtils.a(getApplicationContext());
    ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131368022));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    b(0L);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(0L));
    n();
    o();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Int == 4;
  }
  
  void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "startShowing : mHidden = " + this.jdField_j_of_type_Boolean);
    }
    if (!this.jdField_j_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
    if (Build.VERSION.SDK_INT > 11) {
      this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.clearAnimation();
    if (Build.VERSION.SDK_INT > 11) {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setAlpha(1.0F);
    }
    this.jdField_j_of_type_Boolean = false;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10001) {
      switch (paramInt2)
      {
      }
    }
    while (paramInt1 != 21)
    {
      return;
      QQToast.a(this, 2131437343, 0).a();
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    }
    ForwardUtils.a((QQAppInterface)getAppRuntime(), this, getApplicationContext(), paramIntent, null);
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    g();
    overridePendingTransition(0, 2131034423);
  }
  
  /* Error */
  protected boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield 1700	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:mActNeedImmersive	Z
    //   5: aload_0
    //   6: aload_1
    //   7: invokespecial 1702	com/tencent/mobileqq/app/BaseActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   10: pop
    //   11: aload_0
    //   12: ldc_w 1703
    //   15: invokespecial 1706	com/tencent/mobileqq/app/BaseActivity:setContentView	(I)V
    //   18: aload_0
    //   19: invokevirtual 1710	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:getWindow	()Landroid/view/Window;
    //   22: sipush 128
    //   25: invokevirtual 1715	android/view/Window:addFlags	(I)V
    //   28: aload_0
    //   29: aload_0
    //   30: invokevirtual 1716	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:getResources	()Landroid/content/res/Resources;
    //   33: invokevirtual 1720	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   36: getfield 1725	android/util/DisplayMetrics:widthPixels	I
    //   39: putfield 1727	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:D	I
    //   42: aload_0
    //   43: aload_0
    //   44: invokevirtual 1716	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:getResources	()Landroid/content/res/Resources;
    //   47: invokevirtual 1720	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   50: getfield 1730	android/util/DisplayMetrics:heightPixels	I
    //   53: putfield 1732	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:E	I
    //   56: invokestatic 472	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +285 -> 344
    //   62: new 411	java/lang/StringBuilder
    //   65: dup
    //   66: ldc_w 1734
    //   69: invokespecial 454	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   72: astore_2
    //   73: aload_2
    //   74: ldc_w 1736
    //   77: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: getstatic 1741	android/os/Build:PRODUCT	Ljava/lang/String;
    //   83: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc_w 669
    //   89: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_2
    //   94: ldc_w 1743
    //   97: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: getstatic 1746	android/os/Build:MODEL	Ljava/lang/String;
    //   103: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc_w 669
    //   109: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_2
    //   114: ldc_w 1748
    //   117: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: getstatic 1751	android/os/Build:BOARD	Ljava/lang/String;
    //   123: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc_w 669
    //   129: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload_2
    //   134: ldc_w 1753
    //   137: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: getstatic 1756	android/os/Build:BOOTLOADER	Ljava/lang/String;
    //   143: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc_w 669
    //   149: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload_2
    //   154: ldc_w 1758
    //   157: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: getstatic 1761	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   163: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc_w 669
    //   169: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload_2
    //   174: ldc_w 1763
    //   177: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: getstatic 1766	android/os/Build:CPU_ABI2	Ljava/lang/String;
    //   183: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: ldc_w 669
    //   189: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_2
    //   194: ldc_w 1768
    //   197: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: getstatic 1771	android/os/Build:DEVICE	Ljava/lang/String;
    //   203: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc_w 669
    //   209: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload_2
    //   214: ldc_w 1773
    //   217: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: getstatic 1776	android/os/Build:DISPLAY	Ljava/lang/String;
    //   223: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: ldc_w 669
    //   229: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_2
    //   234: ldc_w 1778
    //   237: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: getstatic 1781	android/os/Build:FINGERPRINT	Ljava/lang/String;
    //   243: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: ldc_w 669
    //   249: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload_2
    //   254: ldc_w 1783
    //   257: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: getstatic 1786	android/os/Build:HARDWARE	Ljava/lang/String;
    //   263: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: ldc_w 669
    //   269: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload_2
    //   274: ldc_w 1788
    //   277: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: getstatic 1791	android/os/Build:ID	Ljava/lang/String;
    //   283: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: ldc_w 669
    //   289: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload_2
    //   294: ldc_w 1793
    //   297: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: getstatic 1796	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   303: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: ldc_w 669
    //   309: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload_2
    //   314: ldc_w 1798
    //   317: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: getstatic 173	android/os/Build$VERSION:SDK_INT	I
    //   323: invokevirtual 479	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   326: ldc_w 669
    //   329: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: ldc_w 474
    //   336: iconst_2
    //   337: aload_2
    //   338: invokevirtual 423	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 1028	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: aload_1
    //   345: ifnull +51 -> 396
    //   348: aload_0
    //   349: aload_1
    //   350: ldc_w 1800
    //   353: invokevirtual 1301	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   356: i2l
    //   357: putfield 798	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_c_of_type_Long	J
    //   360: invokestatic 472	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq +33 -> 396
    //   366: ldc_w 474
    //   369: iconst_2
    //   370: new 411	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 412	java/lang/StringBuilder:<init>	()V
    //   377: ldc_w 1802
    //   380: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: aload_0
    //   384: getfield 798	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_c_of_type_Long	J
    //   387: invokevirtual 416	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   390: invokevirtual 423	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokestatic 484	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   396: aload_0
    //   397: aload_0
    //   398: putfield 716	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   401: aload_0
    //   402: aload_0
    //   403: invokespecial 363	com/tencent/mobileqq/app/BaseActivity:getIntent	()Landroid/content/Intent;
    //   406: invokevirtual 1284	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   409: putfield 1804	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   412: aload_0
    //   413: aload_0
    //   414: invokespecial 363	com/tencent/mobileqq/app/BaseActivity:getIntent	()Landroid/content/Intent;
    //   417: invokevirtual 1806	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:a	(Landroid/content/Intent;)V
    //   420: aload_0
    //   421: getfield 1329	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_s_of_type_Boolean	Z
    //   424: ifeq +200 -> 624
    //   427: aload_0
    //   428: ldc_w 1807
    //   431: invokevirtual 1625	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:findViewById	(I)Landroid/view/View;
    //   434: checkcast 1551	com/tencent/image/URLImageView
    //   437: astore_1
    //   438: aload_0
    //   439: getfield 1333	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_r_of_type_JavaLangString	Ljava/lang/String;
    //   442: ifnull +329 -> 771
    //   445: aload_0
    //   446: getfield 1333	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_r_of_type_JavaLangString	Ljava/lang/String;
    //   449: invokevirtual 1809	java/lang/String:isEmpty	()Z
    //   452: ifne +319 -> 771
    //   455: aload_1
    //   456: iconst_0
    //   457: invokevirtual 1552	com/tencent/image/URLImageView:setVisibility	(I)V
    //   460: aload_1
    //   461: aload_0
    //   462: getfield 1333	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_r_of_type_JavaLangString	Ljava/lang/String;
    //   465: invokestatic 1815	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;)Lcom/tencent/image/URLDrawable;
    //   468: invokevirtual 1819	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   471: aload_0
    //   472: getfield 448	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   475: ifnull +30 -> 505
    //   478: aload_0
    //   479: getfield 448	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   482: invokevirtual 1809	java/lang/String:isEmpty	()Z
    //   485: ifne +20 -> 505
    //   488: aload_1
    //   489: iconst_1
    //   490: invokevirtual 1822	com/tencent/image/URLImageView:setClickable	(Z)V
    //   493: aload_1
    //   494: new 1824	yaw
    //   497: dup
    //   498: aload_0
    //   499: invokespecial 1825	yaw:<init>	(Lcom/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity;)V
    //   502: invokevirtual 1826	com/tencent/image/URLImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   505: aload_0
    //   506: ldc_w 1827
    //   509: invokevirtual 1625	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:findViewById	(I)Landroid/view/View;
    //   512: checkcast 1551	com/tencent/image/URLImageView
    //   515: astore_1
    //   516: aload_0
    //   517: getfield 1337	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_t_of_type_JavaLangString	Ljava/lang/String;
    //   520: ifnull +303 -> 823
    //   523: aload_0
    //   524: getfield 1337	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_t_of_type_JavaLangString	Ljava/lang/String;
    //   527: invokevirtual 1809	java/lang/String:isEmpty	()Z
    //   530: ifne +293 -> 823
    //   533: aload_1
    //   534: iconst_0
    //   535: invokevirtual 1552	com/tencent/image/URLImageView:setVisibility	(I)V
    //   538: aload_1
    //   539: aload_0
    //   540: getfield 1337	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_t_of_type_JavaLangString	Ljava/lang/String;
    //   543: invokestatic 1815	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;)Lcom/tencent/image/URLDrawable;
    //   546: invokevirtual 1819	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   549: aload_0
    //   550: getfield 1343	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_u_of_type_JavaLangString	Ljava/lang/String;
    //   553: ifnull +295 -> 848
    //   556: aload_0
    //   557: getfield 1343	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_u_of_type_JavaLangString	Ljava/lang/String;
    //   560: invokevirtual 1809	java/lang/String:isEmpty	()Z
    //   563: ifne +285 -> 848
    //   566: aload_0
    //   567: ldc_w 1828
    //   570: invokevirtual 1625	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:findViewById	(I)Landroid/view/View;
    //   573: checkcast 492	android/widget/TextView
    //   576: astore_1
    //   577: aload_1
    //   578: iconst_0
    //   579: invokevirtual 1829	android/widget/TextView:setVisibility	(I)V
    //   582: aload_1
    //   583: aload_0
    //   584: getfield 1343	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_u_of_type_JavaLangString	Ljava/lang/String;
    //   587: invokevirtual 496	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   590: aload_0
    //   591: getfield 448	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   594: ifnull +30 -> 624
    //   597: aload_0
    //   598: getfield 448	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   601: invokevirtual 1809	java/lang/String:isEmpty	()Z
    //   604: ifne +20 -> 624
    //   607: aload_1
    //   608: iconst_1
    //   609: invokevirtual 1830	android/widget/TextView:setClickable	(Z)V
    //   612: aload_1
    //   613: new 1832	yax
    //   616: dup
    //   617: aload_0
    //   618: invokespecial 1833	yax:<init>	(Lcom/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity;)V
    //   621: invokevirtual 1651	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   624: aload_0
    //   625: invokevirtual 1835	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:c	()V
    //   628: aload_0
    //   629: invokevirtual 1837	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:a	()V
    //   632: new 1839	android/content/IntentFilter
    //   635: dup
    //   636: invokespecial 1840	android/content/IntentFilter:<init>	()V
    //   639: astore_1
    //   640: aload_1
    //   641: ldc_w 1842
    //   644: invokevirtual 1845	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   647: aload_1
    //   648: ldc_w 1847
    //   651: invokevirtual 1845	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   654: aload_0
    //   655: aload_0
    //   656: getfield 217	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   659: aload_1
    //   660: invokevirtual 1851	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   663: pop
    //   664: aload_0
    //   665: getfield 242	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   668: ldc 2
    //   670: aload_0
    //   671: getfield 200	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   674: invokevirtual 1855	com/tencent/mobileqq/app/QQAppInterface:setHandler	(Ljava/lang/Class;Lmqq/os/MqqHandler;)V
    //   677: aload_0
    //   678: invokestatic 708	java/lang/System:currentTimeMillis	()J
    //   681: putfield 140	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_e_of_type_Long	J
    //   684: aload_0
    //   685: getfield 242	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   688: ldc 244
    //   690: ldc 124
    //   692: ldc 124
    //   694: ldc_w 1857
    //   697: ldc_w 1857
    //   700: iconst_0
    //   701: iconst_0
    //   702: ldc 124
    //   704: ldc 124
    //   706: ldc 124
    //   708: ldc 124
    //   710: invokestatic 251	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   713: aload_0
    //   714: getfield 242	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   717: ldc 244
    //   719: ldc 124
    //   721: ldc 124
    //   723: ldc_w 1859
    //   726: ldc_w 1859
    //   729: iconst_0
    //   730: iconst_0
    //   731: ldc 124
    //   733: ldc 124
    //   735: ldc 124
    //   737: ldc 124
    //   739: invokestatic 251	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   742: iconst_1
    //   743: ireturn
    //   744: astore_2
    //   745: invokestatic 472	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   748: ifeq +14 -> 762
    //   751: ldc_w 474
    //   754: iconst_2
    //   755: ldc_w 1861
    //   758: aload_2
    //   759: invokestatic 1253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   762: aload_1
    //   763: bipush 8
    //   765: invokevirtual 1552	com/tencent/image/URLImageView:setVisibility	(I)V
    //   768: goto -297 -> 471
    //   771: aload_1
    //   772: bipush 8
    //   774: invokevirtual 1552	com/tencent/image/URLImageView:setVisibility	(I)V
    //   777: invokestatic 472	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   780: ifeq -275 -> 505
    //   783: ldc_w 474
    //   786: iconst_2
    //   787: ldc_w 1863
    //   790: invokestatic 484	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   793: goto -288 -> 505
    //   796: astore_2
    //   797: aload_1
    //   798: bipush 8
    //   800: invokevirtual 1552	com/tencent/image/URLImageView:setVisibility	(I)V
    //   803: invokestatic 472	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   806: ifeq -257 -> 549
    //   809: ldc_w 474
    //   812: iconst_2
    //   813: ldc_w 1865
    //   816: aload_2
    //   817: invokestatic 1253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   820: goto -271 -> 549
    //   823: aload_1
    //   824: bipush 8
    //   826: invokevirtual 1552	com/tencent/image/URLImageView:setVisibility	(I)V
    //   829: invokestatic 472	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   832: ifeq -283 -> 549
    //   835: ldc_w 474
    //   838: iconst_2
    //   839: ldc_w 1867
    //   842: invokestatic 484	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   845: goto -296 -> 549
    //   848: invokestatic 472	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   851: ifeq -227 -> 624
    //   854: ldc_w 474
    //   857: iconst_2
    //   858: ldc_w 1869
    //   861: invokestatic 484	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   864: goto -240 -> 624
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	867	0	this	ShortVideoPlayActivity
    //   0	867	1	paramBundle	Bundle
    //   72	266	2	localStringBuilder	StringBuilder
    //   744	15	2	localException1	Exception
    //   796	21	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   455	471	744	java/lang/Exception
    //   533	549	796	java/lang/Exception
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "doOnDestroy");
    }
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying())) {
      this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
    }
    g();
    TVK_SDKMgr.setOnLogListener(null);
    if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_b_of_type_AndroidViewView);
    }
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      ((IVideoViewBase)this.jdField_b_of_type_AndroidViewView).removeViewCallBack(this);
      this.jdField_b_of_type_AndroidViewView = null;
    }
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      label111:
      this.app.removeHandler(ShortVideoPlayActivity.class);
      if (this.jdField_e_of_type_Long >= 0L)
      {
        this.jdField_d_of_type_Long += System.currentTimeMillis() - this.jdField_e_of_type_Long;
        if (!this.jdField_d_of_type_Boolean)
        {
          new DCShortVideo(BaseApplication.getContext()).a(this.app, 2002, (int)(this.jdField_b_of_type_Long / 1000L), this.jdField_e_of_type_Int, this.jdField_j_of_type_JavaLangString, this.jdField_d_of_type_Long / 1000L);
          this.jdField_d_of_type_Boolean = true;
        }
      }
      if (this.jdField_e_of_type_Boolean) {
        new DCShortVideo(BaseApplication.getContext()).a(true, this.jdField_f_of_type_Int, this.jdField_j_of_type_Int / 100, this.jdField_k_of_type_Int / 100, (int)this.jdField_b_of_type_Long, (int)this.jdField_g_of_type_Long, 0, this.jdField_g_of_type_Int, this.jdField_i_of_type_Int, this.jdField_d_of_type_Long);
      }
      if (!this.jdField_g_of_type_Boolean)
      {
        t();
        a(true);
        B();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uiOperatorFlag == 2) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress != 100))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus = 2009;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.serial();
        this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.msgData);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label111;
    }
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    do
    {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
    } while (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0);
    if (this.jdField_d_of_type_Int != 9501) {
      m();
    }
    return true;
  }
  
  public void doOnPause()
  {
    if (!this.jdField_k_of_type_Boolean) {
      this.jdField_i_of_type_Boolean = true;
    }
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()))
    {
      this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
      this.jdField_h_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "pause mCurrentPosition:" + this.jdField_c_of_type_Long);
      }
    }
    for (;;)
    {
      super.doOnPause();
      return;
      if (c()) {
        this.jdField_h_of_type_Boolean = true;
      }
    }
  }
  
  @TargetApi(10)
  public void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "doOnResume: mInterrupted = " + this.jdField_i_of_type_Boolean + ", mNeedPlay = " + this.jdField_h_of_type_Boolean + " mSurfaceViewDestroyed=" + this.jdField_r_of_type_Boolean);
    }
    x();
    if ((this.jdField_i_of_type_Boolean) || (this.jdField_k_of_type_Boolean))
    {
      if (!this.jdField_h_of_type_Boolean) {
        break label126;
      }
      if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) && (!a())) {
        a(this.jdField_c_of_type_Long);
      }
    }
    label126:
    do
    {
      do
      {
        return;
      } while (Build.VERSION.SDK_INT < 10);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "onResume, restore last pause, mCurrentPosition=" + this.jdField_c_of_type_Long);
      }
      if (this.jdField_r_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoPlayActivity", 2, "onResume, restore last pause mSurfaceViewDestroyed=" + this.jdField_r_of_type_Boolean);
    return;
    if (this.jdField_b_of_type_Int == 0) {
      if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!FileUtils.b(this.jdField_b_of_type_JavaLangString))) {}
    }
    for (;;)
    {
      try
      {
        MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
        localMediaMetadataRetriever.setDataSource(this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidGraphicsBitmap = localMediaMetadataRetriever.getFrameAtTime(this.jdField_c_of_type_Long * 1000L);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new ColorDrawable(0));
        continue;
      }
      if (this.jdField_b_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new ColorDrawable(0));
      }
    }
  }
  
  protected void doOnStart()
  {
    MediaPlayerManager.a(this.app).a(true);
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
    super.doOnStart();
  }
  
  protected void doOnStop()
  {
    if (!this.jdField_k_of_type_Boolean) {
      this.jdField_i_of_type_Boolean = true;
    }
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
    }
    super.doOnStop();
  }
  
  void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "delayStartHiding");
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying())) {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 2500L);
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "startHiding : mHidden = " + this.jdField_j_of_type_Boolean + ",playState:" + a(this.jdField_a_of_type_Int));
    }
    if (this.jdField_j_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Int != 1);
      this.jdField_j_of_type_Boolean = true;
    } while (((this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) && (this.jdField_c_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)) || (Build.VERSION.SDK_INT < 11));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  void g()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
    a(0);
  }
  
  public void h()
  {
    long l1 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "initDuration: duration=" + l1);
    }
    if (l1 != 0L)
    {
      this.jdField_b_of_type_Long = ((int)l1);
      this.jdField_i_of_type_JavaLangString = ShortVideoUtils.a(this.jdField_b_of_type_Long);
      if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (!this.jdField_b_of_type_AndroidWidgetTextView.getText().equals(this.jdField_i_of_type_JavaLangString))) {
        runOnUiThread(new yae(this));
      }
    }
  }
  
  void i()
  {
    a(0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void j()
  {
    if (b())
    {
      this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
    a(2);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "#pause# , mCurrentPosition = " + this.jdField_c_of_type_Long);
    }
    if (this.jdField_e_of_type_Long >= 0L) {
      this.jdField_d_of_type_Long += System.currentTimeMillis() - this.jdField_e_of_type_Long;
    }
  }
  
  void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "handleClick: mPlayState = " + a(this.jdField_a_of_type_Int) + ", mCurrentPosition = " + this.jdField_c_of_type_Long);
    }
    switch (this.jdField_a_of_type_Int)
    {
    case 4: 
    default: 
    case 0: 
    case 1: 
    case 2: 
      do
      {
        return;
        a(this.jdField_c_of_type_Long);
        return;
        j();
        return;
        a();
      } while ((this.jdField_c_of_type_Long == 0L) || (!this.jdField_r_of_type_Boolean));
      a(this.jdField_c_of_type_Long);
      return;
    }
    a(0L);
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onClick surfaceView, mHidden=" + this.jdField_j_of_type_Boolean);
    }
    if (this.jdField_j_of_type_Boolean)
    {
      d();
      e();
    }
  }
  
  void m()
  {
    int i1 = 0;
    String str2 = getResources().getString(2131437365);
    String str3 = getResources().getString(2131437366);
    String str4 = getResources().getString(2131437342);
    String str5 = getResources().getString(2131437347);
    String str6 = getResources().getString(2131432998);
    String str1;
    boolean bool1;
    ActionSheet localActionSheet;
    if (this.jdField_b_of_type_Int == 0)
    {
      str1 = ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
      bool1 = FileUtils.a(str1);
      if (this.jdField_f_of_type_Boolean) {
        bool1 = false;
      }
      boolean bool2 = "1".equals(DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.shortvideo_forward_switch.name(), "1"));
      if (getIntent().getIntExtra("from_busi_type", 0) == 2) {
        i1 = 1;
      }
      localActionSheet = ActionSheet.a(this);
      if ((bool2) && (this.jdField_d_of_type_Int != 9501) && (i1 == 0)) {
        localActionSheet.c(str2);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus != 5001)) {
        localActionSheet.c(str3);
      }
      if (this.jdField_b_of_type_Int != 3)
      {
        if (!bool1) {
          break label269;
        }
        localActionSheet.c(str4);
        localActionSheet.c(str5);
      }
    }
    for (;;)
    {
      localActionSheet.d(str6);
      localActionSheet.show();
      localActionSheet.a(new yal(this, localActionSheet, str2, str1, str3, bool1, str4, str1, str5));
      return;
      str1 = this.jdField_b_of_type_JavaLangString;
      break;
      label269:
      localActionSheet.a(str4, 7);
      localActionSheet.a(str5, 7);
    }
  }
  
  void n()
  {
    if (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() != 0) {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  void o()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)
    {
      localObject = ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.thumbMD5, "jpg");
      if (!FileUtils.b((String)localObject)) {}
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(-16777216);
      localObject = URLDrawable.getDrawable(new File((String)localObject), localURLDrawableOptions);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "showLoadingImage crashed =" + localException.toString());
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    s();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131371314: 
    default: 
      return;
    case 2131371304: 
      s();
      return;
    case 2131371316: 
      this.app.a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      s();
      return;
    case 2131371320: 
      l();
      k();
      return;
    case 2131368804: 
      l();
      if (this.jdField_a_of_type_Int == 1) {
        j();
      }
      m();
      return;
    }
    s();
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    runOnUiThread(new yao(this, paramTVK_IMediaPlayer));
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (!this.jdField_s_of_type_Boolean) {
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      ((RelativeLayout)findViewById(2131371307)).setVisibility(8);
      return;
    }
    ((RelativeLayout)findViewById(2131371307)).setVisibility(0);
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onError what=" + paramInt1 + ",extra=" + paramInt2 + ",mCacheProgress=" + this.jdField_k_of_type_Int + ", mPlayProgress=" + this.jdField_j_of_type_Int + ", mCurPlayPosition=" + this.jdField_h_of_type_Long);
    }
    runOnUiThread(new yap(this, paramTVK_IMediaPlayer, paramInt1, paramInt2, paramInt3, paramString, paramObject));
    return false;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onInfo what=" + paramInt + ",extra=" + paramObject + ",mCacheProgress=" + this.jdField_k_of_type_Int + ", mPlayProgress=" + this.jdField_j_of_type_Int + ", mCurPlayPosition=" + this.jdField_h_of_type_Long);
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "video start buffering !");
      }
      a(4);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "video end buffering !");
      }
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) {
        a(1);
      } else {
        a(2);
      }
    }
  }
  
  public void onNetVideoInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onNetVideoInfo what=" + paramTVK_NetVideoInfo.getErrInfo() + ",extra=" + paramTVK_NetVideoInfo.getState() + ",mCacheProgress=" + this.jdField_k_of_type_Int + ", mPlayProgress=" + this.jdField_j_of_type_Int + ", mCurPlayPosition=" + this.jdField_h_of_type_Long);
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (!this.jdField_k_of_type_Boolean) {
      this.jdField_i_of_type_Boolean = true;
    }
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()))
    {
      this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
      this.jdField_h_of_type_Boolean = true;
    }
    paramBundle.putLong("state_play_position", this.jdField_c_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onSaveInstanceState: mCurrentPosition: " + this.jdField_c_of_type_Long);
    }
  }
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onSeekComplete mCacheProgress=" + this.jdField_k_of_type_Int + ", mPlayProgress=" + this.jdField_j_of_type_Int + ", mCurPlayPosition=" + this.jdField_h_of_type_Long);
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
  }
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder) {}
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder) {}
  
  public void onSurfaceDestory(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onSurfaceDestory");
    }
    this.jdField_r_of_type_Boolean = true;
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onVideoPrepared: mDuration=" + this.jdField_b_of_type_Long + " mInterrupted" + this.jdField_i_of_type_Boolean + " mNeedPlay" + this.jdField_h_of_type_Boolean);
    }
    this.jdField_r_of_type_Boolean = false;
    runOnUiThread(new yaq(this));
    if (this.jdField_b_of_type_Int == 2) {
      a(this.jdField_c_of_type_JavaLangString, 1, 1002, this.jdField_d_of_type_JavaLangString);
    }
    if (this.jdField_k_of_type_Long != 0L)
    {
      this.jdField_l_of_type_Long = (System.currentTimeMillis() - this.jdField_k_of_type_Long);
      this.jdField_k_of_type_Long = 0L;
    }
    if (this.jdField_m_of_type_Long != 0L)
    {
      this.jdField_n_of_type_Long = (System.currentTimeMillis() - this.jdField_m_of_type_Long);
      this.jdField_m_of_type_Long = 0L;
    }
    if (this.jdField_i_of_type_Boolean)
    {
      this.jdField_i_of_type_Boolean = false;
      if (!this.jdField_h_of_type_Boolean) {
        return;
      }
    }
    this.jdField_h_of_type_Boolean = false;
    if (this.jdField_b_of_type_Long <= 0L) {
      h();
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    if (this.jdField_a_of_type_Long > 0L) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo((int)this.jdField_a_of_type_Long);
    }
    a(1);
  }
  
  public void onVideoPreparing(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onVideoPreparing mCacheProgress=" + this.jdField_k_of_type_Int + ", mPlayProgress=" + this.jdField_j_of_type_Int + ", mCurPlayPosition=" + this.jdField_h_of_type_Long);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      x();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onWindowFocusChanged: hasFocus: " + paramBoolean);
    }
  }
  
  public void p()
  {
    if ((this.jdField_e_of_type_AndroidWidgetTextView != null) && (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  void q()
  {
    if ((this.jdField_a_of_type_ComTencentImageURLImageView != null) && (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
  
  public void r()
  {
    a(DialogUtil.a(this, 232, null, getString(2131437367), new yam(this), new yan(this)));
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "userBackPressed");
    }
    g();
    setResult(-1, getIntent());
    finish();
    try
    {
      overridePendingTransition(2131034165, 2131034167);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] overridePendingTransition=" + localException);
    }
  }
  
  public void t()
  {
    if (!this.jdField_o_of_type_Boolean) {}
    while (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    StringBuffer localStringBuffer = new StringBuffer();
    if (!this.jdField_f_of_type_Boolean)
    {
      i1 = 1;
      if (this.jdField_i_of_type_Int == 0) {
        i1 = 3;
      }
      localHashMap.put("player_state", String.valueOf(i1));
      localStringBuffer.append(" player_state " + i1);
      localHashMap.put("Download", String.valueOf(this.jdField_l_of_type_Boolean));
      localStringBuffer.append(" Download" + this.jdField_l_of_type_Boolean);
      localHashMap.put("FileSize", String.valueOf(this.jdField_g_of_type_Long));
      localStringBuffer.append(" FileSize" + this.jdField_g_of_type_Long);
      localHashMap.put("HttpDownloadSum", String.valueOf(this.jdField_m_of_type_Int));
      localStringBuffer.append(" HttpDownloadSum" + this.jdField_m_of_type_Int);
      if (this.jdField_l_of_type_Boolean) {
        break label1216;
      }
      localHashMap.put("DataFromCacheSize", String.valueOf(this.jdField_g_of_type_Long));
      localStringBuffer.append(" DataFromCacheSize" + this.jdField_g_of_type_Long);
      label277:
      localHashMap.put("FileDuration", String.valueOf(this.jdField_b_of_type_Long));
      localStringBuffer.append(" FileDuration" + this.jdField_b_of_type_Long);
      localHashMap.put("PlayTime", String.valueOf(this.jdField_i_of_type_Long));
      localStringBuffer.append(" PlayTime" + this.jdField_i_of_type_Long);
      localHashMap.put("PlayStateCount", String.valueOf(this.jdField_p_of_type_Int));
      localStringBuffer.append(" PlayStateCount" + this.jdField_p_of_type_Int);
      localHashMap.put("PlayProgress", String.valueOf(this.jdField_j_of_type_Int / 100));
      localStringBuffer.append(" PlayProgress" + this.jdField_j_of_type_Int / 100);
      localHashMap.put("FirstPlayTime", String.valueOf(this.jdField_l_of_type_Long));
      localStringBuffer.append(" FirstPlayTime" + this.jdField_l_of_type_Long);
      localHashMap.put("FirstBufferTime", String.valueOf(this.jdField_n_of_type_Long));
      localStringBuffer.append(" FirstBufferTime" + this.jdField_n_of_type_Long);
      localHashMap.put("SeekTimes", String.valueOf(this.jdField_h_of_type_Int));
      localStringBuffer.append(" SeekTimes" + this.jdField_h_of_type_Int);
      if (this.jdField_s_of_type_Int != 0) {
        break label1264;
      }
      i1 = this.jdField_s_of_type_Int;
      label610:
      localHashMap.put("BufferTimes", String.valueOf(i1));
      localStringBuffer.append(" BufferTimes" + i1);
      localHashMap.put("BufferCostTime", String.valueOf(this.jdField_o_of_type_Long));
      localStringBuffer.append(" BufferCostTime" + this.jdField_o_of_type_Long);
      if (this.jdField_r_of_type_Long != 0L)
      {
        this.jdField_q_of_type_Long = (System.currentTimeMillis() - this.jdField_r_of_type_Long);
        this.jdField_r_of_type_Long = 0L;
      }
      i1 = 0;
      if (this.jdField_n_of_type_Int != 0) {
        i1 = this.jdField_m_of_type_Int / (this.jdField_n_of_type_Int * 1000);
      }
      localHashMap.put("SpeedKBS", String.valueOf(i1));
      localStringBuffer.append(" SpeedKBS" + i1);
      if (this.jdField_r_of_type_Int <= 0) {
        break label1274;
      }
      str1 = "1";
      label794:
      localHashMap.put("IsRePlay", str1);
      localStringBuffer.append(" IsRePlay" + this.jdField_r_of_type_Int);
      localHashMap.put("SuspendTimes", String.valueOf(this.jdField_q_of_type_Int));
      localStringBuffer.append(" SuspendTimes" + this.jdField_q_of_type_Int);
      if (this.B == 0) {
        break label1281;
      }
      localHashMap.put("param_FailCode", String.valueOf(this.B));
    }
    Object localObject;
    int i3;
    label1281:
    for (boolean bool = false;; bool = true)
    {
      localHashMap.put("ErrorCode", String.valueOf(this.jdField_u_of_type_Int));
      localHashMap.put("ErrorDetailCode", String.valueOf(this.v));
      localHashMap.put("HttpStatus", String.valueOf(this.jdField_t_of_type_Int));
      localStringBuffer.append(" HttpStatus" + this.jdField_t_of_type_Int);
      localHashMap.put("User-ReturnCode", this.jdField_m_of_type_JavaLangString);
      localStringBuffer.append(" User-ReturnCode" + this.jdField_m_of_type_JavaLangString);
      localHashMap.put("X-RtFlag", this.jdField_n_of_type_JavaLangString);
      localStringBuffer.append(" X-RtFlag" + this.jdField_n_of_type_JavaLangString);
      int i2 = -1;
      localObject = new StringBuffer("");
      str1 = null;
      if (!StringUtil.a(this.jdField_p_of_type_JavaLangString)) {
        str1 = InnerDns.a(this.jdField_p_of_type_JavaLangString);
      }
      i3 = i2;
      if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
        break label1287;
      }
      i3 = i2;
      if (this.jdField_a_of_type_ArrayOfJavaLangString.length <= 0) {
        break label1287;
      }
      i1 = 0;
      for (;;)
      {
        i3 = i2;
        if (i1 >= this.jdField_a_of_type_ArrayOfJavaLangString.length) {
          break;
        }
        String str2 = InnerDns.a(this.jdField_a_of_type_ArrayOfJavaLangString[i1]);
        ((StringBuffer)localObject).append(str2 + ",");
        i3 = i2;
        if (i2 == -1)
        {
          i3 = i2;
          if (!StringUtil.a(str1))
          {
            i3 = i2;
            if (str1.equals(str2)) {
              i3 = i1;
            }
          }
        }
        i1 += 1;
        i2 = i3;
      }
      i1 = 2;
      break;
      label1216:
      localHashMap.put("DataFromCacheSize", String.valueOf(this.jdField_o_of_type_Int));
      localStringBuffer.append(" DataFromCacheSize" + this.jdField_o_of_type_Int);
      break label277;
      label1264:
      i1 = this.jdField_s_of_type_Int - 1;
      break label610;
      label1274:
      str1 = "0";
      break label794;
    }
    label1287:
    localHashMap.put("IpList", ((StringBuffer)localObject).toString());
    int i1 = i3 + 1;
    localHashMap.put("SuccIpIndex", String.valueOf(i1));
    localStringBuffer.append(" SuccIpIndex" + i1);
    localHashMap.put("HttpDomain", this.jdField_a_of_type_JavaLangString);
    localStringBuffer.append(" HttpDomain" + this.jdField_a_of_type_JavaLangString);
    localHashMap.put("HttpRedirectNum", String.valueOf(this.w));
    localStringBuffer.append(" HttpRedirectNum" + this.w);
    localHashMap.put("HttpRedirectCostMs", String.valueOf(this.x));
    localStringBuffer.append(" HttpRedirectCostMs" + this.x);
    localHashMap.put("HttpDnsCostMs", String.valueOf(this.y));
    localStringBuffer.append(" HttpDnsCostMs" + this.y);
    localHashMap.put("HttpConnectCostMs", String.valueOf(this.z));
    localStringBuffer.append(" HttpConnectCostMs" + this.z);
    localHashMap.put("HttpFirstRecvCostMs", String.valueOf(this.A));
    localStringBuffer.append(" HttpFirstRecvCostMs" + this.A);
    localHashMap.put("RetrySuccessTimes", "0");
    localHashMap.put("RetryFailedTimes", "0");
    localHashMap.put("ApplyCostTime", String.valueOf(this.jdField_u_of_type_Long));
    localStringBuffer.append(" ApplyCostTime" + this.jdField_u_of_type_Long);
    localHashMap.put("HttpCostTime", String.valueOf(this.jdField_q_of_type_Long));
    localStringBuffer.append(" HttpCostTime" + this.jdField_q_of_type_Long);
    localHashMap.put("DownType", "1");
    localHashMap.put("SceneType", "2");
    localHashMap.put("BusiType", String.valueOf(this.jdField_b_of_type_Int));
    localHashMap.put("SubBusiType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.subBusiType));
    localHashMap.put("FromUin", String.valueOf(this.jdField_f_of_type_JavaLangString));
    localHashMap.put("GrpUin", String.valueOf(this.jdField_j_of_type_JavaLangString));
    localHashMap.put("Uuid", String.valueOf(this.jdField_q_of_type_JavaLangString));
    localHashMap.put("MsgFileMd5", String.valueOf(this.jdField_g_of_type_JavaLangString));
    localHashMap.put("DownFileMd5", String.valueOf(this.jdField_g_of_type_JavaLangString));
    String str1 = String.valueOf(NetworkUtil.a(BaseApplicationImpl.getApplication().getApplicationContext()));
    localHashMap.put("NetworkInfo", str1);
    localStringBuffer.append(" NetworkInfo" + str1);
    localHashMap.put("ProductVersion", String.valueOf(this.app.getAppid()));
    localHashMap.put("EncryptKey", "0");
    if (this.jdField_m_of_type_Boolean)
    {
      str1 = "1";
      localHashMap.put("IsUpdateSuit", str1);
      localObject = new StringBuilder().append(" IsUpdateSuit");
      if (!this.jdField_m_of_type_Boolean) {
        break label2264;
      }
      str1 = "1";
      label1994:
      localStringBuffer.append(str1);
      localHashMap.put("UpdateSuitCostTime", String.valueOf(this.jdField_s_of_type_Long));
      localStringBuffer.append(" UpdateSuitCostTime" + this.jdField_s_of_type_Long);
      if (!this.jdField_n_of_type_Boolean) {
        break label2271;
      }
      str1 = "1";
      label2067:
      localHashMap.put("UpdateSuitResult", str1);
      localObject = new StringBuilder().append(" UpdateSuitResult");
      if (!this.jdField_n_of_type_Boolean) {
        break label2278;
      }
    }
    label2264:
    label2271:
    label2278:
    for (str1 = "1";; str1 = "0")
    {
      localStringBuffer.append(str1);
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoPlayActivity", 2, localStringBuffer.toString());
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actStreamingVideoPlay", bool, this.jdField_q_of_type_Long, this.jdField_g_of_type_Long, localHashMap, "");
      this.jdField_o_of_type_Boolean = false;
      this.jdField_p_of_type_Int = 0;
      this.jdField_h_of_type_Int = 0;
      this.jdField_s_of_type_Int = 0;
      this.jdField_q_of_type_Int = 0;
      this.jdField_o_of_type_Long = 0L;
      this.jdField_q_of_type_Long = 0L;
      this.jdField_i_of_type_Long = 0L;
      this.z = 0;
      this.y = 0;
      this.jdField_l_of_type_Long = 0L;
      this.jdField_n_of_type_Long = 0L;
      this.jdField_u_of_type_Long = 0L;
      this.A = 0;
      this.x = 0;
      this.jdField_s_of_type_Long = 0L;
      this.jdField_u_of_type_Int = 0;
      this.v = 0;
      return;
      str1 = "0";
      break;
      str1 = "0";
      break label1994;
      str1 = "0";
      break label2067;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity
 * JD-Core Version:    0.7.0.1
 */