package com.tencent.mobileqq.activity.shortvideo;

import Override;
import afaz;
import afbb;
import alck;
import alcl;
import alcm;
import alcn;
import alcp;
import alcq;
import alcr;
import alcu;
import alcv;
import alcw;
import alcx;
import alcy;
import alcz;
import alda;
import aldb;
import aldc;
import aldd;
import amtj;
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
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import atky;
import avmx;
import awct;
import ayjs;
import badr;
import bbqf;
import bbqh;
import bbqx;
import bcef;
import bfur;
import bfyz;
import bjnw;
import bjpi;
import bkox;
import bkql;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.DragView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(11)
public class ShortVideoPlayActivity
  extends BaseActivity
  implements afbb, View.OnClickListener, bjpi, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnNetVideoInfoListener, TVK_IMediaPlayer.OnSeekCompleteListener, TVK_IMediaPlayer.OnVideoPreparedListener, TVK_IMediaPlayer.OnVideoPreparingListener, IVideoViewBase.IVideoViewCallBack
{
  static String[] jdField_b_of_type_ArrayOfJavaLangString;
  static String jdField_l_of_type_JavaLangString = bfyz.f(BaseApplication.getContext());
  private int A;
  private int B;
  private int C;
  private int D = -1;
  private int E;
  private int F;
  public int a;
  long jdField_a_of_type_Long;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator = null;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public Context a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  Bundle jdField_a_of_type_AndroidOsBundle;
  public View a;
  protected ImageView a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener;
  public SeekBar a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public bkql a;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  DragView jdField_a_of_type_ComTencentWidgetDragView;
  final Runnable jdField_a_of_type_JavaLangRunnable;
  String jdField_a_of_type_JavaLangString;
  public WeakReference<TVK_IMediaPlayer> a;
  boolean jdField_a_of_type_Boolean = false;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  public int b;
  long jdField_b_of_type_Long;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  SeekBar jdField_b_of_type_AndroidWidgetSeekBar;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  final Runnable jdField_b_of_type_JavaLangRunnable;
  public String b;
  public final WeakReference<MqqHandler> b;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  long jdField_c_of_type_Long;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  public RelativeLayout c;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString = "";
  public boolean c;
  int jdField_d_of_type_Int = -1;
  public long d;
  RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  String jdField_d_of_type_JavaLangString = "";
  public boolean d;
  public int e;
  public long e;
  RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  String jdField_e_of_type_JavaLangString;
  boolean jdField_e_of_type_Boolean = false;
  public int f;
  long jdField_f_of_type_Long = -1L;
  private RelativeLayout jdField_f_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  String jdField_f_of_type_JavaLangString;
  boolean jdField_f_of_type_Boolean = false;
  int jdField_g_of_type_Int;
  long jdField_g_of_type_Long = -1L;
  public String g;
  public boolean g;
  public int h;
  long jdField_h_of_type_Long;
  public String h;
  boolean jdField_h_of_type_Boolean;
  public int i;
  long jdField_i_of_type_Long;
  String jdField_i_of_type_JavaLangString;
  boolean jdField_i_of_type_Boolean = false;
  int jdField_j_of_type_Int = 1;
  private long jdField_j_of_type_Long;
  public String j;
  boolean jdField_j_of_type_Boolean = false;
  private int jdField_k_of_type_Int;
  private long jdField_k_of_type_Long;
  String jdField_k_of_type_JavaLangString;
  public boolean k;
  private int jdField_l_of_type_Int;
  private long jdField_l_of_type_Long;
  boolean jdField_l_of_type_Boolean = false;
  private int jdField_m_of_type_Int;
  private long jdField_m_of_type_Long;
  private String jdField_m_of_type_JavaLangString;
  public boolean m;
  private int jdField_n_of_type_Int;
  private long jdField_n_of_type_Long;
  private String jdField_n_of_type_JavaLangString;
  boolean jdField_n_of_type_Boolean;
  private int jdField_o_of_type_Int;
  private long jdField_o_of_type_Long;
  private String jdField_o_of_type_JavaLangString;
  private boolean jdField_o_of_type_Boolean;
  private int jdField_p_of_type_Int;
  private long jdField_p_of_type_Long;
  private String jdField_p_of_type_JavaLangString;
  private boolean jdField_p_of_type_Boolean;
  private int jdField_q_of_type_Int;
  private long jdField_q_of_type_Long;
  private String jdField_q_of_type_JavaLangString;
  private boolean jdField_q_of_type_Boolean;
  private int jdField_r_of_type_Int;
  private long jdField_r_of_type_Long;
  private String jdField_r_of_type_JavaLangString;
  private boolean jdField_r_of_type_Boolean;
  private int jdField_s_of_type_Int;
  private long jdField_s_of_type_Long;
  private String jdField_s_of_type_JavaLangString;
  private boolean jdField_s_of_type_Boolean = true;
  private int jdField_t_of_type_Int;
  private long jdField_t_of_type_Long;
  private String jdField_t_of_type_JavaLangString;
  private boolean jdField_t_of_type_Boolean = true;
  private int jdField_u_of_type_Int;
  private long jdField_u_of_type_Long;
  private String jdField_u_of_type_JavaLangString;
  private boolean jdField_u_of_type_Boolean = true;
  private int jdField_v_of_type_Int;
  private long jdField_v_of_type_Long;
  private boolean jdField_v_of_type_Boolean;
  private int jdField_w_of_type_Int;
  private long jdField_w_of_type_Long;
  private boolean jdField_w_of_type_Boolean;
  private int jdField_x_of_type_Int;
  private long jdField_x_of_type_Long;
  private boolean jdField_x_of_type_Boolean;
  private int jdField_y_of_type_Int;
  private long jdField_y_of_type_Long;
  private boolean jdField_y_of_type_Boolean;
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
    this.jdField_d_of_type_Long = -1L;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_f_of_type_Int = -1;
    this.jdField_j_of_type_JavaLangString = "0";
    this.jdField_k_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.3F });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(2500L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new alck(this));
    }
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(new alcr(this));
    this.jdField_a_of_type_JavaLangRunnable = new ShortVideoPlayActivity.5(this);
    this.jdField_b_of_type_JavaLangRunnable = new ShortVideoPlayActivity.6(this);
    this.jdField_n_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aldd(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new alcv(this);
  }
  
  private void A()
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
        break label111;
      }
      i1 = 1;
      label72:
      if (i1 != 0) {
        break label116;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131717955, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
    }
    label111:
    label116:
    bbqh localbbqh;
    do
    {
      return;
      i1 = 0;
      break;
      i1 = 0;
      break label72;
      localObject = bbqf.a(2, 0);
      localbbqh = a();
      if ((!AppNetConnInfo.isWifiConn()) && (localbbqh != null) && (localbbqh.jdField_b_of_type_Long > 204800L)) {
        a(bfur.a(this, 230, getString(2131718459), getString(2131718460), new alcp(this), new alcq(this)));
      }
    } while (localbbqh == null);
    localbbqh.jdField_a_of_type_Boolean = true;
    ((bbqx)localObject).a = localbbqh;
    bbqf.a((bbqx)localObject, this.app);
    this.jdField_k_of_type_JavaLangString = localbbqh.jdField_h_of_type_JavaLangString;
  }
  
  private void B()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  private void C()
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    QZoneHelper.forwardToPublishMood(getActivity(), localUserInfo, this.jdField_b_of_type_JavaLangString, 10001);
    bcef.b(this.app, "dc00898", "", "", "0X800753A", "0X800753A", 0, 0, "", "", "", "");
  }
  
  private void D()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (this.D == -1) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 2003)) {
      break label28;
    }
    label28:
    while (!this.jdField_u_of_type_Boolean) {
      return;
    }
    this.jdField_u_of_type_Boolean = false;
    if (this.jdField_i_of_type_Long == 0L) {}
    for (int i1 = 0;; i1 = (int)(100L * this.jdField_h_of_type_Long / this.jdField_i_of_type_Long))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress < 0) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress = 0;
      }
      int i2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress;
      if (((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1002) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 2002)) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == this.D) && (i1 - i2 < 10)) {
        break;
      }
      if ((this.jdField_c_of_type_Int != 6) && (this.jdField_c_of_type_Int != 17) && (this.jdField_c_of_type_Int != 9))
      {
        i2 = i1;
        if (this.jdField_c_of_type_Int != 20) {}
      }
      else
      {
        if (this.D == 2002) {
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.transferedSize = ((int)this.jdField_h_of_type_Long);
        }
        i2 = i1;
        if (this.D == 2003)
        {
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.transferedSize = 0;
          i2 = 100;
        }
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 2004) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1004)) && ((this.D == 1002) || (this.D == 2002))) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus = this.D;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.fileType = this.jdField_c_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress = i2;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.mPreUpload) && (this.D == 1003) && (this.jdField_g_of_type_JavaLangString != null)) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5 = this.jdField_g_of_type_JavaLangString;
      }
      if ((this.D == 2003) && (!StringUtil.isEmpty(this.jdField_b_of_type_JavaLangString)))
      {
        File localFile = new File(this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.lastModified = localFile.lastModified();
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.serial();
      this.app.getMessageFacade().updateMsgContentByUniseq(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.msgData);
      return;
    }
  }
  
  private void E()
  {
    if (this.jdField_b_of_type_Int != 3) {
      return;
    }
    this.jdField_a_of_type_Bkql = new alda(this, this, new alcz(this), a(), 5, this.app);
  }
  
  private void I()
  {
    String str = a();
    if (!a(str))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131718438, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
      return;
    }
    if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) {
      ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(str, (MqqHandler)this.jdField_b_of_type_JavaLangRefWeakReference.get(), this.jdField_g_of_type_JavaLangString + ".mp4", false));
    }
    if (this.jdField_e_of_type_Int == 0)
    {
      bcef.b(this.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "1", "", "");
      this.jdField_d_of_type_Boolean = true;
    }
    for (;;)
    {
      new badr(BaseApplication.getContext()).a(this.app, 2002, this.jdField_f_of_type_Int, this.jdField_j_of_type_JavaLangString);
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      awct.a("0X8009ABD");
      return;
      if (this.jdField_e_of_type_Int == 3000)
      {
        bcef.b(this.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "2", "", "");
        this.jdField_d_of_type_Boolean = true;
      }
      else if (this.jdField_e_of_type_Int == 1)
      {
        bcef.b(this.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "3", "", "");
        this.jdField_d_of_type_Boolean = true;
      }
      else
      {
        bcef.b(this.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "4", "", "");
        this.jdField_d_of_type_Boolean = true;
      }
    }
  }
  
  private void J()
  {
    bkox.a(this.jdField_a_of_type_AndroidContentContext, this.app.getCurrentUin(), this.jdField_b_of_type_Long, this.jdField_c_of_type_Long);
  }
  
  private void K()
  {
    String str = a();
    if (!a(str))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131718438, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
      return;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.parse("file://" + str), "video/*");
    startActivity(localIntent);
    if (this.jdField_e_of_type_Int == 0)
    {
      bcef.b(this.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
      this.jdField_d_of_type_Boolean = true;
      return;
    }
    if (this.jdField_e_of_type_Int == 3000)
    {
      bcef.b(this.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
      this.jdField_d_of_type_Boolean = true;
      return;
    }
    if (this.jdField_e_of_type_Int == 1)
    {
      bcef.b(this.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
      this.jdField_d_of_type_Boolean = true;
      return;
    }
    bcef.b(this.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
    this.jdField_d_of_type_Boolean = true;
  }
  
  private int a()
  {
    int i1 = 16392;
    if (this.jdField_b_of_type_Long != -1L) {
      i1 = 16456;
    }
    return i1 | 0x200;
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
  
  private bbqh a()
  {
    bbqh localbbqh = new bbqh();
    try
    {
      JSONObject localJSONObject = new JSONObject(this.jdField_e_of_type_JavaLangString);
      if (localJSONObject != null)
      {
        localbbqh.jdField_a_of_type_Int = localJSONObject.getInt("busi_type");
        localbbqh.jdField_a_of_type_JavaLangString = localJSONObject.getString("file_uuid");
        String str = localJSONObject.getString("file_md5");
        localbbqh.jdField_e_of_type_JavaLangString = str;
        this.jdField_g_of_type_JavaLangString = str;
        localbbqh.jdField_b_of_type_Long = localJSONObject.getInt("file_size");
        localbbqh.jdField_b_of_type_Int = this.jdField_f_of_type_Int;
        localbbqh.jdField_b_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
        localbbqh.jdField_c_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
        localbbqh.jdField_d_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
        localbbqh.jdField_e_of_type_Int = 1001;
        this.jdField_c_of_type_Int = 1001;
        localbbqh.jdField_h_of_type_JavaLangString = a(localbbqh.jdField_e_of_type_JavaLangString);
        return localbbqh;
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
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.SDCARD_PATH);
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
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(a(paramLong1) + "/" + a(paramLong2));
    }
    if (this.jdField_b_of_type_AndroidWidgetSeekBar != null) {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(i1);
    }
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
    if (!this.jdField_t_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (!this.jdField_p_of_type_Boolean);
      if (this.C == 0) {
        paramBoolean = true;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null);
    this.jdField_t_of_type_Boolean = false;
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
      localHashMap.put("param_picSize", String.valueOf(this.jdField_i_of_type_Long));
      localHashMap.put("param_fileMd5", this.jdField_g_of_type_JavaLangString);
      localHashMap.put("param_busiType", this.jdField_b_of_type_Int + "");
      localHashMap.put("param_videoDuration", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime));
      if (!paramBoolean) {
        break;
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, true, this.jdField_s_of_type_Long, this.jdField_i_of_type_Long, localHashMap, "");
      return;
      if ((this.jdField_c_of_type_Int == 9) || (this.jdField_c_of_type_Int == 17))
      {
        str = "actShortVideoDiscussgroupDownloadVideo";
        localHashMap.put("param_grpUin", this.jdField_j_of_type_JavaLangString);
      }
    }
    if (this.C != -9527) {
      localHashMap.remove("param_rspHeader");
    }
    localHashMap.put("param_FailCode", String.valueOf(this.C));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, false, this.jdField_s_of_type_Long, 0L, localHashMap, "");
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
      QQToast.a(paramContext, 1, 2131717955, 0).b(paramContext.getResources().getDimensionPixelSize(2131299076));
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
    if (StringUtil.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      paramString = paramString.split("\r\n");
      if (paramString != null)
      {
        this.jdField_u_of_type_Int = a(paramString[0]);
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
                  break label437;
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
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSDKDownloadHijacked", true, 0L, 0L, (HashMap)localObject2, "");
            throw new IOException((String)localObject1);
            label437:
            i1 = 0;
          }
        }
      }
    }
  }
  
  private void w()
  {
    if (this.jdField_i_of_type_Boolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      if ((bbqf.jdField_a_of_type_Boolean) || (System.currentTimeMillis() - bbqf.jdField_a_of_type_Long < 300000L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "needRemind=false");
        }
        i1 = 0;
      }
      if (i1 != 0)
      {
        Object localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131718458);
        QQCustomDialog localQQCustomDialog = bfur.a(this.jdField_a_of_type_AndroidContentContext, 230, null, (String)localObject, 2131694094, 2131719734, new aldb(this), new aldc(this));
        localObject = avmx.a(this.jdField_a_of_type_AndroidContentContext, this.app, 1, (String)localObject);
        if ((localObject instanceof SpannableString)) {
          localQQCustomDialog.setMessageWithoutAutoLink((CharSequence)localObject);
        }
        j();
        this.jdField_k_of_type_Boolean = false;
        a(localQQCustomDialog);
      }
      return;
    }
  }
  
  private void x()
  {
    this.jdField_v_of_type_Long = System.currentTimeMillis();
    this.jdField_q_of_type_Boolean = true;
    TVK_SDKMgr.installPlugin(getApplicationContext(), new alcn(this));
  }
  
  private void y()
  {
    Object localObject;
    if (this.jdField_j_of_type_Boolean)
    {
      localObject = this.app.getTransFileController().findProcessor(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      if ((localObject instanceof ShortVideoUploadProcessor))
      {
        localObject = (ShortVideoUploadProcessor)localObject;
        a(((ShortVideoUploadProcessor)localObject).getTransferedSize(), ((ShortVideoUploadProcessor)localObject).getFileSize());
      }
      localObject = afaz.a(this.app);
      if (localObject != null) {
        ((afaz)localObject).a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this);
      }
      this.jdField_b_of_type_JavaLangString = ShortVideoUtils.getShortVideoSavePath(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
      if (new File(this.jdField_b_of_type_JavaLangString).exists())
      {
        long l1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
        this.jdField_i_of_type_Long = l1;
        this.jdField_h_of_type_Long = l1;
        this.jdField_l_of_type_Int = 10000;
      }
      for (;;)
      {
        a(this.jdField_e_of_type_Long);
        return;
        a(amtj.a(2131713183));
      }
    }
    l();
    if ((this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 2) || (this.jdField_b_of_type_Int == 4) || (this.jdField_e_of_type_Int == 9501) || (this.jdField_b_of_type_Int == 6))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if ((this.jdField_b_of_type_Int != 2) || (this.jdField_e_of_type_JavaLangString == null)) {}
    }
    try
    {
      localObject = new JSONObject(this.jdField_e_of_type_JavaLangString);
      this.jdField_c_of_type_Int = 1001;
      this.jdField_b_of_type_JavaLangString = a(((JSONObject)localObject).getString("file_md5"));
      this.jdField_i_of_type_Long = ((JSONObject)localObject).getInt("file_size");
      this.jdField_q_of_type_JavaLangString = ((JSONObject)localObject).getString("file_uuid");
      label297:
      localObject = new File(this.jdField_b_of_type_JavaLangString);
      if ((((File)localObject).exists()) && (((File)localObject).isFile()))
      {
        this.jdField_h_of_type_Long = ((File)localObject).length();
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "onCreateVideoSdkView(), #PLAY_CALLER_STRUCT_MSG#, have video size=" + this.jdField_h_of_type_Long + " msg.size=" + this.jdField_i_of_type_Long);
        }
        if (this.jdField_h_of_type_Long < this.jdField_i_of_type_Long) {
          this.jdField_i_of_type_Boolean = true;
        }
        if (this.jdField_i_of_type_Boolean)
        {
          A();
          localObject = afaz.a(this.app);
          if (localObject != null) {
            ((afaz)localObject).a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this);
          }
          this.jdField_a_of_type_AndroidWidgetSeekBar.setSecondaryProgress(this.jdField_l_of_type_Int);
        }
      }
      do
      {
        this.jdField_p_of_type_Boolean = this.jdField_i_of_type_Boolean;
        if (this.jdField_i_of_type_Boolean) {
          break label970;
        }
        a(this.jdField_e_of_type_Long);
        return;
        this.jdField_i_of_type_Boolean = true;
        break;
      } while ((this.jdField_b_of_type_Int != 0) && (this.jdField_b_of_type_Int != 5));
      int i1;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getBitValue(1) == 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getBitValue(0) == 1)
        {
          i1 = 101;
          label519:
          ayjs.a(1000, i1);
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.setBitValue(1, (byte)1);
          ThreadManager.getFileThreadHandler().post(new ShortVideoPlayActivity.15(this));
        }
      }
      else
      {
        this.jdField_b_of_type_JavaLangString = ShortVideoUtils.getShortVideoSavePath(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
        localObject = new File(this.jdField_b_of_type_JavaLangString);
        if (!((File)localObject).exists()) {
          break label947;
        }
        this.jdField_h_of_type_Long = ((File)localObject).length();
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "onCreateVideoSdkView(), #PLAY_CALLER_SHORT_VIDEO#, have video size=" + this.jdField_h_of_type_Long + " msg.size=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize + " status=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus);
        }
        this.jdField_i_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
        this.jdField_l_of_type_Int = 10000;
        this.jdField_a_of_type_AndroidWidgetSeekBar.setSecondaryProgress(10000);
        this.jdField_h_of_type_Boolean = false;
        if (this.jdField_h_of_type_Long >= this.jdField_i_of_type_Long) {}
      }
      for (this.jdField_i_of_type_Boolean = true;; this.jdField_i_of_type_Boolean = true)
      {
        if (this.jdField_i_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPlayActivity", 2, "initData, #PLAY_CALLER_SHORT_VIDEO#, need download, startDownload...");
          }
          if (a(this.jdField_a_of_type_AndroidContentContext))
          {
            localObject = bbqf.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 1);
            if (localObject != null)
            {
              bbqf.a((bbqx)localObject, this.app);
              this.jdField_c_of_type_Int = ((bbqx)localObject).a.jdField_e_of_type_Int;
              a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
            }
          }
          localObject = afaz.a(this.app);
          if (localObject != null) {
            ((afaz)localObject).a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this);
          }
          this.jdField_i_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
          this.jdField_l_of_type_Int = ((int)(10000L * this.jdField_h_of_type_Long / this.jdField_i_of_type_Long));
          this.jdField_k_of_type_Int = 0;
          this.jdField_j_of_type_Long = 0L;
          this.jdField_h_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidWidgetSeekBar.setSecondaryProgress(this.jdField_l_of_type_Int);
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPlayActivity", 2, "onCreateVideoSdkView() mCacheProgress=" + this.jdField_l_of_type_Int + ",mTransferredSize=" + this.jdField_h_of_type_Long);
          }
        }
        if (this.jdField_b_of_type_Int != 5) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
        i1 = 102;
        break label519;
        label947:
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
        }
      }
      label970:
      p();
      a(4);
      return;
    }
    catch (Exception localException)
    {
      break label297;
    }
  }
  
  private void z()
  {
    if ((VersionUtils.isJellyBean()) && (!ShortVideoUtils.isInFullScreenBlackList()) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setSystemUiVisibility(1284);
    }
  }
  
  public void F()
  {
    bcef.b(null, "dc00898", "", "", "0X8009AB3", "0X8009AB3", this.jdField_d_of_type_Int, 0, "", "", "", "");
    g();
    finish();
    try
    {
      overridePendingTransition(2130772039, 2130772041);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] overridePendingTransition=" + localException);
    }
  }
  
  public void G()
  {
    this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  public void H()
  {
    s();
  }
  
  public void OnDownloadCallback(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        int i1 = paramString.getInt("callBackType");
        int i2 = paramString.getInt("fileSize");
        if (i2 != this.jdField_i_of_type_Long)
        {
          this.jdField_i_of_type_Long = i2;
          QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] OnDownloadCallback fileSize mismatched msg.file=" + this.jdField_i_of_type_Long);
        }
        int i3 = paramString.getInt("newFileSize");
        long l1 = paramString.getInt("offset");
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "OnDownloadCallback, offset = " + l1 + ", seekFlagForCacheProgress = " + this.jdField_g_of_type_Boolean);
        }
        if (l1 > 0L)
        {
          if (this.jdField_g_of_type_Boolean)
          {
            this.jdField_h_of_type_Long = l1;
            this.jdField_g_of_type_Boolean = false;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPlayActivity", 2, "OnDownloadCallback, mTransferredSize = " + this.jdField_h_of_type_Long);
          }
          int i4 = paramString.getInt("httpDownloadSum");
          this.jdField_n_of_type_Int = i4;
          if (i4 > 0) {
            this.jdField_o_of_type_Int += 1;
          }
          int i5 = paramString.getInt("dataFromCacheSize");
          if (this.jdField_p_of_type_Int < i5) {
            this.jdField_p_of_type_Int = i5;
          }
          this.jdField_m_of_type_Int = paramString.getInt("speedKBS");
          if ((i1 != 7) && (i1 != 3)) {
            break label789;
          }
          if (i1 == 7)
          {
            this.jdField_i_of_type_Boolean = false;
            this.jdField_h_of_type_Long = this.jdField_i_of_type_Long;
            this.D = 2003;
            D();
          }
          if (this.jdField_t_of_type_Long != 0L)
          {
            this.jdField_s_of_type_Long = (System.currentTimeMillis() - this.jdField_t_of_type_Long);
            this.jdField_t_of_type_Long = 0L;
          }
          if (this.jdField_x_of_type_Int == 0) {
            this.jdField_x_of_type_Int = paramString.getInt("httpRedirectNum");
          }
          if (this.jdField_y_of_type_Int == 0) {
            this.jdField_y_of_type_Int = paramString.getInt("httpRedirectCostMs");
          }
          if ((paramString.has("httpDNSCostMs")) && (this.z == 0)) {
            this.z = paramString.getInt("httpDNSCostMs");
          }
          if ((paramString.has("httpConnectCostMs")) && (this.A == 0)) {
            this.A = paramString.getInt("httpConnectCostMs");
          }
          if ((paramString.has("httpFirstRecvCostMs")) && (this.B == 0)) {
            this.B = paramString.getInt("httpFirstRecvCostMs");
          }
          if ((paramString.has("httpURL")) && (this.jdField_p_of_type_JavaLangString == null)) {
            this.jdField_p_of_type_JavaLangString = paramString.getString("httpURL");
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          paramString = new StringBuilder("[MediaPlayer] OnDownloadCallback:");
          paramString.append("callBackType=").append(i1).append("|");
          paramString.append("fileSize=").append(i2).append("|");
          paramString.append("newFileSize=").append(i3).append("|");
          paramString.append("offset=").append(this.jdField_h_of_type_Long).append("|");
          paramString.append("httpDownloadSum=").append(i4).append("|");
          paramString.append("dataFromCacheSize=").append(i5).append("|");
          paramString.append("speedKBS=").append(this.jdField_m_of_type_Int).append("|");
          paramString.append("HttpRedirectNum=").append(this.jdField_x_of_type_Int).append("|");
          paramString.append("HttpRedirectCostMs=").append(this.jdField_y_of_type_Int).append("|");
          paramString.append("HttpDNSCost=").append(this.z).append("|");
          paramString.append("HttpConnectCost=").append(this.A).append("|");
          paramString.append("HttpFirstRecvCost=").append(this.B).append("|");
          paramString.append("mHttpUrl=").append(this.jdField_p_of_type_JavaLangString).append("|");
          QLog.i("ShortVideoPlayActivity", 2, paramString.toString());
          return;
        }
        if (l1 <= this.jdField_h_of_type_Long) {
          continue;
        }
        this.jdField_h_of_type_Long = l1;
        continue;
        if (i1 != 1) {
          continue;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      label789:
      if (paramString.has("httpHeader"))
      {
        String str = paramString.getString("httpHeader");
        try
        {
          b(str);
          if ((!TextUtils.isEmpty(this.jdField_m_of_type_JavaLangString)) && (this.jdField_m_of_type_JavaLangString.equals("-5103059")))
          {
            this.D = 5002;
            D();
            a(amtj.a(2131713162));
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            this.C = 9064;
            this.D = 2005;
            D();
            a(amtj.a(2131713167));
          }
        }
      }
    }
  }
  
  public Intent a()
  {
    Object localObject = a();
    Bundle localBundle = c(this).getExtras();
    localBundle.putInt("forward_type", 21);
    localBundle.putBoolean("forward_need_sendmsg", true);
    localBundle.putString("forward_thumb", ShortVideoUtils.getShortVideoThumbPicPath(this.jdField_h_of_type_JavaLangString, "jpg"));
    localBundle.putString("file_send_path", (String)localObject);
    localObject = new Intent();
    ((Intent)localObject).putExtras(localBundle);
    return localObject;
  }
  
  String a()
  {
    if (this.jdField_b_of_type_Int == 0) {
      return ShortVideoUtils.getShortVideoSavePath(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    }
    return this.jdField_b_of_type_JavaLangString;
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
    int i2 = 1;
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
    int i3 = NetworkUtil.getNetworkType(BaseApplication.getContext());
    int i1 = i2;
    if (i3 != 1) {
      if (i3 != 4) {
        break label108;
      }
    }
    label108:
    for (i1 = i2; i1 != 0; i1 = 0)
    {
      x();
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697201), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299076));
      return;
    }
    bfur.a(this.jdField_a_of_type_AndroidContentContext, 232, null, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697198), new alcl(this), new alcm(this)).show();
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null)
    {
      Drawable localDrawable = this.jdField_d_of_type_AndroidWidgetRelativeLayout.getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
      if (paramFloat < 0.8F)
      {
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      }
    }
  }
  
  void a(int paramInt)
  {
    runOnUiThread(new ShortVideoPlayActivity.19(this, paramInt));
  }
  
  void a(int paramInt1, int paramInt2)
  {
    this.jdField_j_of_type_Int = 0;
    this.C = 9001;
    String str1 = getString(2131718466);
    Object localObject;
    int i2;
    if ((paramInt1 == 101) && (this.jdField_a_of_type_ArrayOfJavaLangString != null) && (!StringUtil.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
      i2 = localObject.length;
      i1 = 0;
      while (i1 < i2)
      {
        String str2 = localObject[i1];
        if (!StringUtil.isEmpty(str2)) {
          InnerDns.getInstance().reportBadIp(this.jdField_a_of_type_JavaLangString, InnerDns.getHostFromUrl(str2), 1005);
        }
        i1 += 1;
      }
    }
    if (this.jdField_b_of_type_Int == 1)
    {
      p();
      q();
      str1 = getString(2131718463);
      localObject = str1;
      if (paramInt1 == 122) {
        if (paramInt2 != 204)
        {
          localObject = str1;
          if (paramInt2 != 202) {}
        }
        else
        {
          localObject = getString(2131718463);
        }
      }
      a(bfur.a(this, 232, null, (String)localObject, new alcu(this), null));
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "handleError，mPlayCallerType = " + this.jdField_b_of_type_Int);
      }
      this.jdField_f_of_type_Long = -1L;
      this.jdField_g_of_type_Long = -1L;
      return;
    }
    if (this.jdField_b_of_type_Int == 0)
    {
      if (this.jdField_e_of_type_Boolean) {
        break label407;
      }
      i2 = (int)(DeviceInfoUtil.getSystemAvaialbeMemory() / 1024L);
      if (StringUtil.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        break label410;
      }
    }
    label407:
    label410:
    for (int i1 = (int)(new File(this.jdField_b_of_type_JavaLangString).length() / 1024L);; i1 = 0)
    {
      localObject = DeviceInfoUtil.getDeviceModel();
      bcef.b(this.app, "CliOper", "", "", "0X8004674", "0X8004674", 0, 0, "" + i2, "" + i1, (String)localObject, this.jdField_g_of_type_JavaLangString);
      this.jdField_e_of_type_Boolean = true;
      break;
      if (this.jdField_b_of_type_Int == 2)
      {
        a(this.jdField_c_of_type_JavaLangString, 0, 1002, this.jdField_d_of_type_JavaLangString);
        str1 = getString(2131718463);
        break;
      }
      break;
    }
  }
  
  public void a(long paramLong)
  {
    long l1 = paramLong;
    label807:
    label846:
    label1238:
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
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null)
        {
          l1 = paramLong;
          QLog.e("ShortVideoPlayActivity", 2, "play, mVideoProxyFactory is null .");
          return;
        }
        l1 = paramLong;
        this.jdField_a_of_type_Long = paramLong;
        l1 = paramLong;
        this.jdField_s_of_type_Boolean = true;
        int i1 = 0;
        l1 = paramLong;
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          l1 = paramLong;
          if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {}
        }
        else
        {
          l1 = paramLong;
          this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(getApplicationContext(), (IVideoViewBase)this.jdField_b_of_type_AndroidViewView));
          l1 = paramLong;
          ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).setOnCompletionListener(this);
          l1 = paramLong;
          ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).setOnErrorListener(this);
          l1 = paramLong;
          ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).setOnVideoPreparedListener(this);
          l1 = paramLong;
          ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).setOnSeekCompleteListener(this);
          l1 = paramLong;
          ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).setOnInfoListener(this);
          l1 = paramLong;
          ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).setOnNetVideoInfoListener(this);
          l1 = paramLong;
          ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).setOnVideoPreparingListener(this);
          l1 = paramLong;
          ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).setOnDownloadCallback(this);
          l1 = paramLong;
          this.jdField_o_of_type_Long = System.currentTimeMillis();
          i1 = 1;
        }
        l1 = paramLong;
        if (this.jdField_o_of_type_Boolean)
        {
          i1 = 1;
          l1 = paramLong;
          this.jdField_s_of_type_Int += 1;
        }
        if (i1 == 0) {
          break label1056;
        }
        if (paramLong != 0L) {
          break label1238;
        }
        l1 = paramLong;
        if (this.jdField_a_of_type_AndroidWidgetSeekBar.getProgress() <= 0) {
          break label1238;
        }
        l1 = paramLong;
        if (this.jdField_a_of_type_AndroidWidgetSeekBar.getProgress() >= 10000) {
          break label1238;
        }
        l1 = paramLong;
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) {
          break label1238;
        }
        l1 = paramLong;
        i1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime * 1000 * this.jdField_a_of_type_AndroidWidgetSeekBar.getProgress() / 100;
        paramLong = i1;
        String str;
        HashMap localHashMap;
        QLog.d("ShortVideoPlayActivity", 1, "#play#, msec=" + paramLong, localException1);
      }
      catch (Exception localException1)
      {
        try
        {
          if ((this.jdField_a_of_type_ArrayOfJavaLangString == null) || (!this.jdField_i_of_type_Boolean)) {
            break label906;
          }
          if (((this.jdField_b_of_type_Int != 0) && (this.jdField_b_of_type_Int != 5)) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
            break label846;
          }
          str = ShortVideoUtils.getShortVideoSavePath(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
          localObject2 = new TVK_PlayerVideoInfo();
          ((TVK_PlayerVideoInfo)localObject2).setConfigMap("file_dir", str);
          ((TVK_PlayerVideoInfo)localObject2).setConfigMap("cache_servers_type", "20160518");
          ((TVK_PlayerVideoInfo)localObject2).setConfigMap("keep_last_frame", "true");
          localHashMap = new HashMap();
          localHashMap.put("shouq_bus_type", "bus_type_aio_long_fs");
          ((TVK_PlayerVideoInfo)localObject2).setReportInfoMap(localHashMap);
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) {
            ((TVK_PlayerVideoInfo)localObject2).setConfigMap("duration", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime));
          }
          ((TVK_PlayerVideoInfo)localObject2).setVid(this.jdField_g_of_type_JavaLangString);
          ((TVK_PlayerVideoInfo)localObject2).setPlayMode("cache_extend_video");
          if (QLog.isColorLevel())
          {
            QLog.d("ShortVideoPlayActivity", 2, "#play#, setVid =" + this.jdField_g_of_type_JavaLangString + " videoPath=" + str);
            QLog.d("ShortVideoPlayActivity", 2, "#play#, url0 =" + this.jdField_a_of_type_ArrayOfJavaLangString[0]);
          }
          this.jdField_t_of_type_Long = System.currentTimeMillis();
          ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_ArrayOfJavaLangString, paramLong, 0L, (TVK_PlayerVideoInfo)localObject2, null);
          l1 = paramLong;
          this.jdField_o_of_type_Boolean = false;
          l1 = paramLong;
          if (this.jdField_b_of_type_Int == 0)
          {
            l1 = paramLong;
            if (!this.jdField_d_of_type_Boolean)
            {
              l1 = paramLong;
              if (this.jdField_e_of_type_Int != 0) {
                break label1079;
              }
              l1 = paramLong;
              bcef.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "1", "", "");
              l1 = paramLong;
              this.jdField_d_of_type_Boolean = true;
            }
          }
          l1 = paramLong;
          if (this.jdField_g_of_type_Long >= 0L)
          {
            l1 = paramLong;
            this.jdField_f_of_type_Long += System.currentTimeMillis() - this.jdField_g_of_type_Long;
          }
          l1 = paramLong;
          this.jdField_g_of_type_Long = System.currentTimeMillis();
          return;
        }
        catch (Exception localException2)
        {
          Object localObject2;
          Object localObject1;
          break label807;
        }
        localException1 = localException1;
        paramLong = l1;
      }
      i();
      a(0, 0);
      return;
      if ((this.jdField_b_of_type_Int == 2) && (this.jdField_e_of_type_JavaLangString != null))
      {
        localObject1 = this.jdField_k_of_type_JavaLangString;
      }
      else
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ShortVideoPlayActivity", 2, "#play#, mVideo caller type not right:" + this.jdField_b_of_type_Int);
        return;
        if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPlayActivity", 2, "#play#, videoPath=" + this.jdField_b_of_type_JavaLangString);
          }
          localObject1 = new TVK_PlayerVideoInfo();
          ((TVK_PlayerVideoInfo)localObject1).setConfigMap("keep_last_frame", "true");
          ((TVK_PlayerVideoInfo)localObject1).setPlayType(4);
          localObject2 = new HashMap();
          ((Map)localObject2).put("shouq_bus_type", "bus_type_aio_long_fs");
          ((TVK_PlayerVideoInfo)localObject1).setReportInfoMap((Map)localObject2);
          ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_b_of_type_JavaLangString, paramLong, 0L, (TVK_PlayerVideoInfo)localObject1);
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ShortVideoPlayActivity", 2, "#play#, mVideoPath should not be null!");
          return;
          l1 = paramLong;
          ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).seekTo((int)paramLong);
          continue;
          l1 = paramLong;
          if (this.jdField_e_of_type_Int == 3000)
          {
            l1 = paramLong;
            bcef.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "2", "", "");
            l1 = paramLong;
            this.jdField_d_of_type_Boolean = true;
          }
          else
          {
            l1 = paramLong;
            if (this.jdField_e_of_type_Int == 1)
            {
              l1 = paramLong;
              bcef.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "3", "", "");
              l1 = paramLong;
              this.jdField_d_of_type_Boolean = true;
            }
            else
            {
              l1 = paramLong;
              bcef.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "4", "", "");
              l1 = paramLong;
              this.jdField_d_of_type_Boolean = true;
            }
          }
        }
      }
    }
    label906:
    label1056:
    label1079:
    return;
  }
  
  void a(Intent paramIntent)
  {
    if (paramIntent.getExtras() == null) {}
    do
    {
      return;
      this.jdField_b_of_type_JavaLangString = paramIntent.getExtras().getString("file_send_path");
      this.jdField_b_of_type_Int = paramIntent.getExtras().getInt("video_play_caller", 0);
      this.jdField_b_of_type_Long = paramIntent.getExtras().getLong("fav_id", 0L);
      this.jdField_c_of_type_Long = paramIntent.getExtras().getInt("fav_group_id", 0);
      this.jdField_b_of_type_Boolean = paramIntent.getExtras().getBoolean("video_title_bar_hide", false);
      this.jdField_c_of_type_JavaLangString = paramIntent.getExtras().getString("ad_gdt");
      this.jdField_d_of_type_JavaLangString = paramIntent.getExtras().getString("msg_id");
      this.jdField_f_of_type_Int = paramIntent.getExtras().getInt("from_uin_type");
      this.jdField_j_of_type_JavaLangString = paramIntent.getExtras().getString("from_session_uin");
      this.jdField_e_of_type_Int = paramIntent.getExtras().getInt("uintype");
      this.jdField_e_of_type_JavaLangString = paramIntent.getExtras().getString("struct_msg_video_info");
      this.jdField_f_of_type_JavaLangString = paramIntent.getExtras().getString("from_uin");
      this.jdField_m_of_type_Long = paramIntent.getExtras().getLong("message_click_start");
      this.jdField_q_of_type_JavaLangString = paramIntent.getExtras().getString("file_uuid");
      this.jdField_g_of_type_JavaLangString = paramIntent.getExtras().getString("file_shortvideo_md5");
      this.jdField_h_of_type_JavaLangString = paramIntent.getExtras().getString("thumbfile_md5");
      this.jdField_a_of_type_AndroidGraphicsRect = ((Rect)paramIntent.getExtras().getParcelable("KEY_THUMBNAL_BOUND"));
      this.jdField_d_of_type_Int = paramIntent.getExtras().getInt("extra.EXTRA_ENTRANCE");
      this.jdField_c_of_type_Boolean = paramIntent.getExtras().getBoolean("extra.IS_FROM_MULTI_MSG");
      this.jdField_w_of_type_Boolean = paramIntent.getExtras().getBoolean("is_hotVideo");
      this.jdField_r_of_type_JavaLangString = paramIntent.getExtras().getString("hot_video_icon");
      this.jdField_t_of_type_JavaLangString = paramIntent.getExtras().getString("hot_video_icon_sub");
      this.jdField_s_of_type_JavaLangString = paramIntent.getExtras().getString("hot_video_url");
      this.jdField_u_of_type_JavaLangString = paramIntent.getExtras().getString("hot_video_title");
      if (this.jdField_b_of_type_Long != -1L) {
        paramIntent.putExtra("big_brother_source_key", "biz_src_jc_shoucang");
      }
      if ((this.jdField_b_of_type_Int == 0) || (this.jdField_b_of_type_Int == 5))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)paramIntent.getExtras().getParcelable("key_message_for_shortvideo"));
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)
        {
          QQToast.a(this, 1, amtj.a(2131713139), 0).b(getTitleBarHeight());
          finish();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "initData(), PLAY_CALLER_SHORT_VIDEO, msg = " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.toLogString() + ", mUinType = " + this.jdField_e_of_type_Int);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoPlayActivity", 2, "initData(): mVideoPath=" + this.jdField_b_of_type_JavaLangString + ", mPlayCallerType=" + this.jdField_b_of_type_Int + ", mCursessionType = " + this.jdField_f_of_type_Int + ", mCurSessionUin = " + this.jdField_j_of_type_JavaLangString + ", mUinType = " + this.jdField_e_of_type_Int);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    int i1 = 0;
    if (((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq != paramFileMsg.uniseq)) && (this.jdField_b_of_type_Int != 2)) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, " handleMessage what==" + paramInt1 + ", arg1:" + paramInt2);
        }
        if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
          QLog.d("ShortVideoPlayActivity", 2, "handleMessage msg.uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq + ",fileType:" + ShortVideoUtils.getFileTypeStr(paramFileMsg.fileType) + " ===> fileStatus:" + ShortVideoUtils.getFileStatusStr(paramFileMsg.status));
        }
      } while ((paramFileMsg.fileType != 6) && (paramFileMsg.fileType != 17) && (paramFileMsg.fileType != 9) && (paramFileMsg.fileType != 20));
      switch (paramFileMsg.status)
      {
      case 2004: 
      default: 
        return;
      case 1002: 
        a(paramFileMsg.transferedSize, paramFileMsg.fileSize);
        return;
      case 2003: 
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "handleMessage STATUS_RECV_FINISHED");
        }
        this.jdField_l_of_type_Int = 10000;
        return;
      case 2005: 
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718476, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
        this.C = paramFileMsg.errorCode;
        return;
      case 5001: 
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718474, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
        this.C = paramFileMsg.errorCode;
        return;
      case 5002: 
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718475, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
        this.C = paramFileMsg.errorCode;
        return;
      case 2002: 
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "STATUS_RECV_PROCESS: get url finished");
        }
        this.jdField_g_of_type_Int = ((int)(System.currentTimeMillis() - this.jdField_g_of_type_Long));
      }
    } while (paramFileMsg.urls == null);
    this.jdField_a_of_type_ArrayOfJavaLangString = paramFileMsg.urls;
    this.jdField_a_of_type_JavaLangString = paramFileMsg.domain;
    this.jdField_w_of_type_Long = paramFileMsg.stepUrlCost;
    paramInt1 = i1;
    while (paramInt1 < 1)
    {
      if (!StringUtil.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        paramView = new StringBuilder();
        paramFileMsg = this.jdField_a_of_type_ArrayOfJavaLangString;
        paramFileMsg[paramInt1] = (paramFileMsg[paramInt1] + "&txhost=" + this.jdField_a_of_type_JavaLangString);
      }
      paramInt1 += 1;
    }
    a(0L);
    return;
    B();
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo)
  {
    String str = ShortVideoUtils.getNetTypeStr(NetworkUtil.getSystemNetwork(this.jdField_a_of_type_AndroidContentContext));
    if ((paramMessageForShortVideo.istroop == 0) || (paramMessageForShortVideo.istroop == 1008))
    {
      bcef.b(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "1", str, "");
      return;
    }
    if (paramMessageForShortVideo.istroop == 3000)
    {
      bcef.b(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "2", str, "");
      return;
    }
    if (paramMessageForShortVideo.istroop == 1)
    {
      bcef.b(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "3", str, "");
      return;
    }
    bcef.b(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "4", str, "");
  }
  
  void a(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onCompletion(), mPlayProgress=" + this.jdField_k_of_type_Int + ", mCacheProgress=" + this.jdField_l_of_type_Int + ", mCurPlayPosition" + this.jdField_j_of_type_Long + ", mDuration=" + this.jdField_d_of_type_Long);
    }
    this.jdField_k_of_type_Int = 10000;
    if (!this.jdField_y_of_type_Boolean) {
      this.jdField_y_of_type_Long = this.jdField_d_of_type_Long;
    }
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(10000);
    if ((this.jdField_b_of_type_Int == 2) && (this.jdField_a_of_type_Int == 1)) {
      a(this.jdField_c_of_type_JavaLangString, 2, 1002, this.jdField_d_of_type_JavaLangString);
    }
    a(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_AndroidWidgetTextView.getText());
    d();
    this.jdField_e_of_type_Long = 0L;
    this.jdField_o_of_type_Boolean = true;
    if (this.jdField_g_of_type_Long >= 0L)
    {
      this.jdField_f_of_type_Long += System.currentTimeMillis() - this.jdField_g_of_type_Long;
      if (!this.jdField_f_of_type_Boolean)
      {
        new badr(BaseApplication.getContext()).a(this.app, 2002, (int)(this.jdField_d_of_type_Long / 1000L), this.jdField_f_of_type_Int, this.jdField_j_of_type_JavaLangString, this.jdField_f_of_type_Long / 1000L);
        this.jdField_f_of_type_Boolean = true;
      }
    }
    t();
  }
  
  public void a(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    this.jdField_v_of_type_Int = paramInt1;
    this.jdField_w_of_type_Int = paramInt2;
    t();
    a(false);
    this.D = 2005;
    a(3);
    i();
    a(paramInt1, paramInt2);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) {
      ((MqqHandler)this.jdField_b_of_type_JavaLangRefWeakReference.get()).post(new ShortVideoPlayActivity.14(this, paramString));
    }
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
    bcef.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D93", "0X8005D93", paramInt2, 1, paramInt1, paramString1, paramString2, "", "");
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "#resume#");
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Int == 2)
        {
          ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).start();
          a(1);
          bool1 = true;
        }
      }
    }
    if (this.jdField_g_of_type_Long >= 0L) {
      this.jdField_f_of_type_Long += System.currentTimeMillis() - this.jdField_g_of_type_Long;
    }
    this.jdField_g_of_type_Long = System.currentTimeMillis();
    return bool1;
  }
  
  boolean a(String paramString)
  {
    boolean bool = FileUtils.fileExists(paramString);
    if (this.jdField_i_of_type_Boolean) {
      bool = false;
    }
    return bool;
  }
  
  void b()
  {
    try
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null)
      {
        this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(this));
        this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-16777216);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        ((IVideoViewBase)this.jdField_b_of_type_AndroidViewView).addViewCallBack(this);
        if (this.jdField_a_of_type_AndroidGraphicsRect != null)
        {
          localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(13);
          this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
          this.jdField_a_of_type_ComTencentWidgetDragView.addView(this.jdField_b_of_type_AndroidViewView);
          this.jdField_d_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentWidgetDragView, 0);
        }
        for (;;)
        {
          y();
          return;
          this.jdField_d_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidViewView, 0);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  void b(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3) && (paramInt != 4)) {}
    do
    {
      do
      {
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
            if (this.jdField_l_of_type_Long != 0L) {
              this.jdField_k_of_type_Long += System.currentTimeMillis() - this.jdField_l_of_type_Long;
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
              if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) {
                ((MqqHandler)this.jdField_b_of_type_JavaLangRefWeakReference.get()).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
              }
              this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845614);
              this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(amtj.a(2131713184));
              return;
              if ((this.jdField_a_of_type_Int == 4) && (paramInt != 4) && (this.jdField_r_of_type_Long != 0L)) {
                this.jdField_q_of_type_Long += System.currentTimeMillis() - this.jdField_r_of_type_Long;
              }
              break;
            }
          }
          this.jdField_l_of_type_Long = System.currentTimeMillis();
          this.jdField_q_of_type_Int += 1;
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845616);
          this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(amtj.a(2131713164));
          this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
          if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)
          {
            ((MqqHandler)this.jdField_b_of_type_JavaLangRefWeakReference.get()).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
            ((MqqHandler)this.jdField_b_of_type_JavaLangRefWeakReference.get()).postDelayed(this.jdField_a_of_type_JavaLangRunnable, 50L);
          }
          e();
          p();
          q();
        } while (this.jdField_f_of_type_AndroidWidgetRelativeLayout == null);
        this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        return;
        this.jdField_r_of_type_Int += 1;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845614);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(amtj.a(2131713166));
        return;
        this.jdField_r_of_type_Long = System.currentTimeMillis();
        this.jdField_t_of_type_Int += 1;
        if (this.jdField_i_of_type_Boolean) {
          this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        }
      } while (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null);
      ((MqqHandler)this.jdField_b_of_type_JavaLangRefWeakReference.get()).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      ((MqqHandler)this.jdField_b_of_type_JavaLangRefWeakReference.get()).postDelayed(this.jdField_a_of_type_JavaLangRunnable, 50L);
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845614);
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(amtj.a(2131713157));
    } while (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null);
    ((MqqHandler)this.jdField_b_of_type_JavaLangRefWeakReference.get()).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      long l1 = paramLong;
      if (paramLong < 0L) {
        l1 = 0L;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(l1));
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).isPlaying());
  }
  
  void c()
  {
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)getLayoutInflater().inflate(2131561456, null, false));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131376679));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131371857));
    z();
    this.jdField_a_of_type_AndroidViewView = this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131372110);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131365188));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131370270));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131370700));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131373016));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131379007));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131376995));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(10000);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131372111));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131364035));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131375845));
    if (((this.jdField_b_of_type_Int == 0) || (this.jdField_b_of_type_Int == 5)) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1001) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1002)) && (this.app.getTransFileController().findProcessor(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq) != null))
    {
      this.jdField_j_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131380191));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131380193));
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(100);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131364616));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131380192));
    }
    this.jdField_a_of_type_ComTencentWidgetDragView = new DragView(this);
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentWidgetDragView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentWidgetDragView.setGestureChangeListener(this);
    if (LiuHaiUtils.b()) {}
    for (int i1 = LiuHaiUtils.jdField_a_of_type_Int;; i1 = 0)
    {
      if (this.jdField_a_of_type_AndroidGraphicsRect != null)
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsRect;
        ((Rect)localObject).top -= i1;
        localObject = this.jdField_a_of_type_AndroidGraphicsRect;
        ((Rect)localObject).bottom -= i1;
      }
      this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(this.jdField_a_of_type_AndroidGraphicsRect);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131374206));
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_e_of_type_AndroidWidgetRelativeLayout);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131369767));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.bringToFront();
      localObject = (RelativeLayout)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131369766);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
      localLayoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(getApplicationContext());
      ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131363264));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      b(0L);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(0L));
      n();
      o();
      E();
      return;
    }
  }
  
  boolean c()
  {
    return this.jdField_a_of_type_Int == 4;
  }
  
  void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "startShowing : mHidden = " + this.jdField_n_of_type_Boolean);
    }
    if (!this.jdField_n_of_type_Boolean) {
      return;
    }
    if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) {
      ((MqqHandler)this.jdField_b_of_type_JavaLangRefWeakReference.get()).removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
    if (Build.VERSION.SDK_INT > 11) {
      this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.clearAnimation();
    if (Build.VERSION.SDK_INT > 11) {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setAlpha(1.0F);
    }
    this.jdField_n_of_type_Boolean = false;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
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
      QQToast.a(this, 2131718452, 0).a();
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    }
    ForwardUtils.handleForwardData((QQAppInterface)getAppRuntime(), this, getApplicationContext(), paramIntent, null);
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    g();
    overridePendingTransition(0, 2130772354);
  }
  
  /* Error */
  public boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield 1995	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:mActNeedImmersive	Z
    //   5: aload_0
    //   6: invokestatic 1998	dov/com/tencent/mobileqq/richmedia/capture/util/LiuHaiUtils:a	(Landroid/app/Activity;)V
    //   9: invokestatic 1901	dov/com/tencent/mobileqq/richmedia/capture/util/LiuHaiUtils:b	()Z
    //   12: ifeq +8 -> 20
    //   15: aload_0
    //   16: invokestatic 2002	dov/com/tencent/mobileqq/richmedia/capture/util/LiuHaiUtils:enableNotch	(Landroid/app/Activity;)Z
    //   19: pop
    //   20: aload_0
    //   21: aload_1
    //   22: invokespecial 2004	com/tencent/mobileqq/app/BaseActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   25: pop
    //   26: aload_0
    //   27: ldc_w 2005
    //   30: invokespecial 2008	com/tencent/mobileqq/app/BaseActivity:setContentView	(I)V
    //   33: aload_0
    //   34: invokevirtual 2012	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:getWindow	()Landroid/view/Window;
    //   37: sipush 128
    //   40: invokevirtual 2017	android/view/Window:addFlags	(I)V
    //   43: aload_0
    //   44: aload_0
    //   45: invokevirtual 2018	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:getResources	()Landroid/content/res/Resources;
    //   48: invokevirtual 2022	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   51: getfield 2027	android/util/DisplayMetrics:widthPixels	I
    //   54: putfield 2029	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:E	I
    //   57: aload_0
    //   58: aload_0
    //   59: invokevirtual 2018	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:getResources	()Landroid/content/res/Resources;
    //   62: invokevirtual 2022	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   65: getfield 2032	android/util/DisplayMetrics:heightPixels	I
    //   68: putfield 2034	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:F	I
    //   71: aload_0
    //   72: aload_0
    //   73: ldc_w 2035
    //   76: invokevirtual 1914	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:findViewById	(I)Landroid/view/View;
    //   79: checkcast 379	android/widget/LinearLayout
    //   82: putfield 2037	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   85: aload_0
    //   86: getfield 2037	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   89: ifnull +34 -> 123
    //   92: aload_0
    //   93: getfield 2037	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   96: invokevirtual 2038	android/widget/LinearLayout:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   99: astore_2
    //   100: aload_2
    //   101: getstatic 1902	dov/com/tencent/mobileqq/richmedia/capture/util/LiuHaiUtils:jdField_a_of_type_Int	I
    //   104: putfield 2043	android/view/ViewGroup$LayoutParams:height	I
    //   107: aload_0
    //   108: getfield 2037	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   111: aload_2
    //   112: invokevirtual 2044	android/widget/LinearLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   115: aload_0
    //   116: getfield 2037	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   119: iconst_0
    //   120: invokevirtual 380	android/widget/LinearLayout:setVisibility	(I)V
    //   123: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +284 -> 410
    //   129: new 248	java/lang/StringBuilder
    //   132: dup
    //   133: ldc_w 2046
    //   136: invokespecial 693	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   139: astore_2
    //   140: aload_2
    //   141: ldc_w 2048
    //   144: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: getstatic 2053	android/os/Build:PRODUCT	Ljava/lang/String;
    //   150: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc_w 852
    //   156: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload_2
    //   161: ldc_w 2055
    //   164: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: getstatic 2058	android/os/Build:MODEL	Ljava/lang/String;
    //   170: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: ldc_w 852
    //   176: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_2
    //   181: ldc_w 2060
    //   184: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: getstatic 2063	android/os/Build:BOARD	Ljava/lang/String;
    //   190: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc_w 852
    //   196: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload_2
    //   201: ldc_w 2065
    //   204: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: getstatic 2068	android/os/Build:BOOTLOADER	Ljava/lang/String;
    //   210: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: ldc_w 852
    //   216: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload_2
    //   221: ldc_w 2070
    //   224: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: getstatic 2073	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   230: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc_w 852
    //   236: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload_2
    //   241: ldc_w 2075
    //   244: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: getstatic 2078	android/os/Build:CPU_ABI2	Ljava/lang/String;
    //   250: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: ldc_w 852
    //   256: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload_2
    //   261: ldc_w 2080
    //   264: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: getstatic 2083	android/os/Build:DEVICE	Ljava/lang/String;
    //   270: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc_w 852
    //   276: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload_2
    //   281: ldc_w 2085
    //   284: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: getstatic 2088	android/os/Build:DISPLAY	Ljava/lang/String;
    //   290: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc_w 852
    //   296: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload_2
    //   301: ldc_w 2090
    //   304: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: getstatic 2093	android/os/Build:FINGERPRINT	Ljava/lang/String;
    //   310: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: ldc_w 852
    //   316: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload_2
    //   321: ldc_w 2095
    //   324: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: getstatic 2098	android/os/Build:HARDWARE	Ljava/lang/String;
    //   330: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: ldc_w 852
    //   336: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload_2
    //   341: ldc_w 2100
    //   344: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: getstatic 2103	android/os/Build:ID	Ljava/lang/String;
    //   350: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: ldc_w 852
    //   356: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload_2
    //   361: ldc_w 2105
    //   364: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: getstatic 2108	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   370: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: ldc_w 852
    //   376: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload_2
    //   381: ldc_w 2110
    //   384: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: getstatic 184	android/os/Build$VERSION:SDK_INT	I
    //   390: invokevirtual 710	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   393: ldc_w 852
    //   396: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: ldc 246
    //   402: iconst_2
    //   403: aload_2
    //   404: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 1198	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   410: aload_1
    //   411: ifnull +50 -> 461
    //   414: aload_0
    //   415: aload_1
    //   416: ldc_w 2112
    //   419: invokevirtual 1527	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   422: i2l
    //   423: putfield 991	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_e_of_type_Long	J
    //   426: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   429: ifeq +32 -> 461
    //   432: ldc 246
    //   434: iconst_2
    //   435: new 248	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   442: ldc_w 2114
    //   445: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload_0
    //   449: getfield 991	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_e_of_type_Long	J
    //   452: invokevirtual 662	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   455: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   458: invokestatic 264	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   461: aload_0
    //   462: aload_0
    //   463: putfield 289	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   466: aload_0
    //   467: aload_0
    //   468: invokespecial 622	com/tencent/mobileqq/app/BaseActivity:getIntent	()Landroid/content/Intent;
    //   471: invokevirtual 1217	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   474: putfield 2116	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   477: aload_0
    //   478: aload_0
    //   479: invokespecial 622	com/tencent/mobileqq/app/BaseActivity:getIntent	()Landroid/content/Intent;
    //   482: invokevirtual 2118	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:a	(Landroid/content/Intent;)V
    //   485: aload_0
    //   486: getfield 1566	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_w_of_type_Boolean	Z
    //   489: ifeq +200 -> 689
    //   492: aload_0
    //   493: ldc_w 2119
    //   496: invokevirtual 1914	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:findViewById	(I)Landroid/view/View;
    //   499: checkcast 1817	com/tencent/image/URLImageView
    //   502: astore_1
    //   503: aload_0
    //   504: getfield 1570	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_r_of_type_JavaLangString	Ljava/lang/String;
    //   507: ifnull +359 -> 866
    //   510: aload_0
    //   511: getfield 1570	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_r_of_type_JavaLangString	Ljava/lang/String;
    //   514: invokevirtual 2121	java/lang/String:isEmpty	()Z
    //   517: ifne +349 -> 866
    //   520: aload_1
    //   521: iconst_0
    //   522: invokevirtual 1818	com/tencent/image/URLImageView:setVisibility	(I)V
    //   525: aload_1
    //   526: aload_0
    //   527: getfield 1570	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_r_of_type_JavaLangString	Ljava/lang/String;
    //   530: invokestatic 2127	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;)Lcom/tencent/image/URLDrawable;
    //   533: invokevirtual 2131	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   536: aload_0
    //   537: getfield 687	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   540: ifnull +30 -> 570
    //   543: aload_0
    //   544: getfield 687	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   547: invokevirtual 2121	java/lang/String:isEmpty	()Z
    //   550: ifne +20 -> 570
    //   553: aload_1
    //   554: iconst_1
    //   555: invokevirtual 2134	com/tencent/image/URLImageView:setClickable	(Z)V
    //   558: aload_1
    //   559: new 2136	alde
    //   562: dup
    //   563: aload_0
    //   564: invokespecial 2137	alde:<init>	(Lcom/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity;)V
    //   567: invokevirtual 2138	com/tencent/image/URLImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   570: aload_0
    //   571: ldc_w 2139
    //   574: invokevirtual 1914	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:findViewById	(I)Landroid/view/View;
    //   577: checkcast 1817	com/tencent/image/URLImageView
    //   580: astore_1
    //   581: aload_0
    //   582: getfield 1574	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_t_of_type_JavaLangString	Ljava/lang/String;
    //   585: ifnull +331 -> 916
    //   588: aload_0
    //   589: getfield 1574	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_t_of_type_JavaLangString	Ljava/lang/String;
    //   592: invokevirtual 2121	java/lang/String:isEmpty	()Z
    //   595: ifne +321 -> 916
    //   598: aload_1
    //   599: iconst_0
    //   600: invokevirtual 1818	com/tencent/image/URLImageView:setVisibility	(I)V
    //   603: aload_1
    //   604: aload_0
    //   605: getfield 1574	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_t_of_type_JavaLangString	Ljava/lang/String;
    //   608: invokestatic 2127	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;)Lcom/tencent/image/URLDrawable;
    //   611: invokevirtual 2131	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   614: aload_0
    //   615: getfield 1580	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_u_of_type_JavaLangString	Ljava/lang/String;
    //   618: ifnull +322 -> 940
    //   621: aload_0
    //   622: getfield 1580	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_u_of_type_JavaLangString	Ljava/lang/String;
    //   625: invokevirtual 2121	java/lang/String:isEmpty	()Z
    //   628: ifne +312 -> 940
    //   631: aload_0
    //   632: ldc_w 2140
    //   635: invokevirtual 1914	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:findViewById	(I)Landroid/view/View;
    //   638: checkcast 720	android/widget/TextView
    //   641: astore_1
    //   642: aload_1
    //   643: iconst_0
    //   644: invokevirtual 2141	android/widget/TextView:setVisibility	(I)V
    //   647: aload_1
    //   648: aload_0
    //   649: getfield 1580	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_u_of_type_JavaLangString	Ljava/lang/String;
    //   652: invokevirtual 724	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   655: aload_0
    //   656: getfield 687	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   659: ifnull +30 -> 689
    //   662: aload_0
    //   663: getfield 687	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   666: invokevirtual 2121	java/lang/String:isEmpty	()Z
    //   669: ifne +20 -> 689
    //   672: aload_1
    //   673: iconst_1
    //   674: invokevirtual 2142	android/widget/TextView:setClickable	(Z)V
    //   677: aload_1
    //   678: new 2144	aldf
    //   681: dup
    //   682: aload_0
    //   683: invokespecial 2145	aldf:<init>	(Lcom/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity;)V
    //   686: invokevirtual 1938	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   689: aload_0
    //   690: invokevirtual 2147	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:c	()V
    //   693: aload_0
    //   694: invokevirtual 2149	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:a	()V
    //   697: new 2151	android/content/IntentFilter
    //   700: dup
    //   701: invokespecial 2152	android/content/IntentFilter:<init>	()V
    //   704: astore_1
    //   705: aload_1
    //   706: ldc_w 2154
    //   709: invokevirtual 2157	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   712: aload_1
    //   713: ldc_w 2159
    //   716: invokevirtual 2157	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   719: aload_0
    //   720: aload_0
    //   721: getfield 233	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   724: aload_1
    //   725: invokevirtual 2163	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   728: pop
    //   729: aload_0
    //   730: getfield 360	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   733: ldc 2
    //   735: aload_0
    //   736: getfield 216	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_b_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   739: invokevirtual 502	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   742: checkcast 512	mqq/os/MqqHandler
    //   745: invokevirtual 2167	com/tencent/mobileqq/app/QQAppInterface:setHandler	(Ljava/lang/Class;Lmqq/os/MqqHandler;)V
    //   748: aload_0
    //   749: invokestatic 901	java/lang/System:currentTimeMillis	()J
    //   752: putfield 149	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_g_of_type_Long	J
    //   755: aload_0
    //   756: getfield 360	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   759: ldc_w 400
    //   762: ldc 131
    //   764: ldc 131
    //   766: ldc_w 2169
    //   769: ldc_w 2169
    //   772: iconst_0
    //   773: iconst_0
    //   774: ldc 131
    //   776: ldc 131
    //   778: ldc 131
    //   780: ldc 131
    //   782: invokestatic 407	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   785: aload_0
    //   786: getfield 360	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   789: ldc_w 400
    //   792: ldc 131
    //   794: ldc 131
    //   796: ldc_w 2171
    //   799: ldc_w 2171
    //   802: iconst_0
    //   803: iconst_0
    //   804: ldc 131
    //   806: ldc 131
    //   808: ldc 131
    //   810: ldc 131
    //   812: invokestatic 407	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   815: aload_0
    //   816: getfield 1098	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_c_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   819: ifnull +19 -> 838
    //   822: aload_0
    //   823: getfield 1520	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_b_of_type_Boolean	Z
    //   826: ifeq +12 -> 838
    //   829: aload_0
    //   830: getfield 1098	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_c_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   833: bipush 8
    //   835: invokevirtual 375	android/widget/RelativeLayout:setVisibility	(I)V
    //   838: iconst_1
    //   839: ireturn
    //   840: astore_2
    //   841: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   844: ifeq +13 -> 857
    //   847: ldc 246
    //   849: iconst_2
    //   850: ldc_w 2173
    //   853: aload_2
    //   854: invokestatic 1480	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   857: aload_1
    //   858: bipush 8
    //   860: invokevirtual 1818	com/tencent/image/URLImageView:setVisibility	(I)V
    //   863: goto -327 -> 536
    //   866: aload_1
    //   867: bipush 8
    //   869: invokevirtual 1818	com/tencent/image/URLImageView:setVisibility	(I)V
    //   872: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   875: ifeq -305 -> 570
    //   878: ldc 246
    //   880: iconst_2
    //   881: ldc_w 2175
    //   884: invokestatic 264	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   887: goto -317 -> 570
    //   890: astore_2
    //   891: aload_1
    //   892: bipush 8
    //   894: invokevirtual 1818	com/tencent/image/URLImageView:setVisibility	(I)V
    //   897: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   900: ifeq -286 -> 614
    //   903: ldc 246
    //   905: iconst_2
    //   906: ldc_w 2177
    //   909: aload_2
    //   910: invokestatic 1480	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   913: goto -299 -> 614
    //   916: aload_1
    //   917: bipush 8
    //   919: invokevirtual 1818	com/tencent/image/URLImageView:setVisibility	(I)V
    //   922: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   925: ifeq -311 -> 614
    //   928: ldc 246
    //   930: iconst_2
    //   931: ldc_w 2179
    //   934: invokestatic 264	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   937: goto -323 -> 614
    //   940: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   943: ifeq -254 -> 689
    //   946: ldc 246
    //   948: iconst_2
    //   949: ldc_w 2181
    //   952: invokestatic 264	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   955: goto -266 -> 689
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	958	0	this	ShortVideoPlayActivity
    //   0	958	1	paramBundle	Bundle
    //   99	305	2	localObject	Object
    //   840	14	2	localException1	Exception
    //   890	20	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   520	536	840	java/lang/Exception
    //   598	614	890	java/lang/Exception
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "doOnDestroy");
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).isPlaying())) {
      this.jdField_e_of_type_Long = ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentPostion();
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
      label132:
      this.app.removeHandler(ShortVideoPlayActivity.class);
      if (this.jdField_g_of_type_Long >= 0L)
      {
        this.jdField_f_of_type_Long += System.currentTimeMillis() - this.jdField_g_of_type_Long;
        if (!this.jdField_f_of_type_Boolean)
        {
          new badr(BaseApplication.getContext()).a(this.app, 2002, (int)(this.jdField_d_of_type_Long / 1000L), this.jdField_f_of_type_Int, this.jdField_j_of_type_JavaLangString, this.jdField_f_of_type_Long / 1000L);
          this.jdField_f_of_type_Boolean = true;
        }
      }
      if (this.jdField_h_of_type_Boolean) {
        new badr(BaseApplication.getContext()).a(true, this.jdField_g_of_type_Int, this.jdField_k_of_type_Int / 100, this.jdField_l_of_type_Int / 100, (int)this.jdField_d_of_type_Long, (int)this.jdField_i_of_type_Long, 0, this.jdField_h_of_type_Int, this.jdField_j_of_type_Int, this.jdField_f_of_type_Long);
      }
      if (!this.jdField_j_of_type_Boolean)
      {
        t();
        a(true);
        D();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uiOperatorFlag == 2) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress != 100))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus = 2009;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.serial();
        this.app.getMessageFacade().updateMsgContentByUniseq(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.msgData);
      }
      if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) {
        ((MqqHandler)this.jdField_b_of_type_JavaLangRefWeakReference.get()).removeCallbacksAndMessages(null);
      }
      if (this.jdField_a_of_type_ComTencentWidgetDragView != null)
      {
        this.jdField_a_of_type_ComTencentWidgetDragView.removeAllViews();
        this.jdField_a_of_type_ComTencentWidgetDragView = null;
      }
      QQAppInterface localQQAppInterface = this.app;
      int i1 = this.jdField_f_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) {}
      for (String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin;; str = "")
      {
        ShortVideoUtils.reportVideoPlayEvent(localQQAppInterface, i1, str, 2, 1, this.jdField_d_of_type_Long, this.jdField_y_of_type_Long);
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label132;
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    do
    {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
    } while (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0);
    if ((this.jdField_e_of_type_Int != 9501) || (this.jdField_b_of_type_Int == 5)) {
      m();
    }
    return true;
  }
  
  public void doOnPause()
  {
    if (!this.jdField_o_of_type_Boolean) {
      this.jdField_l_of_type_Boolean = true;
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).isPlaying()))
    {
      this.jdField_e_of_type_Long = ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentPostion();
      this.jdField_k_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "pause mCurrentPosition:" + this.jdField_e_of_type_Long);
      }
    }
    for (;;)
    {
      j();
      super.doOnPause();
      return;
      if (c()) {
        this.jdField_k_of_type_Boolean = true;
      }
    }
  }
  
  @TargetApi(10)
  public void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "doOnResume: mInterrupted = " + this.jdField_l_of_type_Boolean + ", mNeedPlay = " + this.jdField_k_of_type_Boolean + " mSurfaceViewDestroyed=" + this.jdField_v_of_type_Boolean);
    }
    z();
    if ((this.jdField_l_of_type_Boolean) || (this.jdField_o_of_type_Boolean))
    {
      if (!this.jdField_k_of_type_Boolean) {
        break label141;
      }
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (!((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).isPlaying()) && (!a())) {
        a(this.jdField_e_of_type_Long);
      }
    }
    label141:
    do
    {
      do
      {
        return;
      } while (Build.VERSION.SDK_INT < 10);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "onResume, restore last pause, mCurrentPosition=" + this.jdField_e_of_type_Long);
      }
      if (this.jdField_v_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoPlayActivity", 2, "onResume, restore last pause mSurfaceViewDestroyed=" + this.jdField_v_of_type_Boolean);
    return;
    if ((this.jdField_b_of_type_Int == 0) || (this.jdField_b_of_type_Int == 5)) {
      if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!FileUtils.fileExistsAndNotEmpty(this.jdField_b_of_type_JavaLangString))) {}
    }
    for (;;)
    {
      try
      {
        MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
        localMediaMetadataRetriever.setDataSource(this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidGraphicsBitmap = localMediaMetadataRetriever.getFrameAtTime(this.jdField_e_of_type_Long * 1000L);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        localMediaMetadataRetriever.release();
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
  
  public void doOnStart()
  {
    MediaPlayerManager.a(this.app).a(true);
    if (VersionUtils.isrFroyo()) {
      ((AudioManager)getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
    super.doOnStart();
  }
  
  public void doOnStop()
  {
    if (!this.jdField_o_of_type_Boolean) {
      this.jdField_l_of_type_Boolean = true;
    }
    if (VersionUtils.isrFroyo()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
    }
    super.doOnStop();
  }
  
  void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "delayStartHiding");
    }
    if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)
    {
      ((MqqHandler)this.jdField_b_of_type_JavaLangRefWeakReference.get()).removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).isPlaying())) {
        ((MqqHandler)this.jdField_b_of_type_JavaLangRefWeakReference.get()).postDelayed(this.jdField_b_of_type_JavaLangRunnable, 2500L);
      }
    }
  }
  
  void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "startHiding : mHidden = " + this.jdField_n_of_type_Boolean + ",playState:" + a(this.jdField_a_of_type_Int));
    }
    if (this.jdField_n_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Int != 1);
      this.jdField_n_of_type_Boolean = true;
    } while (((this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) && (this.jdField_c_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)) || (Build.VERSION.SDK_INT < 11));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  void g()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).stop();
      ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).release();
      ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).removeAllListener();
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
    a(0);
  }
  
  void h()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {}
    do
    {
      long l1;
      do
      {
        return;
        l1 = ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getDuration();
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "initDuration: duration=" + l1);
        }
      } while (l1 == 0L);
      this.jdField_d_of_type_Long = ((int)l1);
      this.jdField_i_of_type_JavaLangString = ShortVideoUtils.stringForTime(this.jdField_d_of_type_Long);
    } while ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetTextView.getText().equals(this.jdField_i_of_type_JavaLangString)));
    runOnUiThread(new ShortVideoPlayActivity.18(this));
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
    if ((b()) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      this.jdField_e_of_type_Long = ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentPostion();
      ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).pause();
    }
    a(2);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "#pause# , mCurrentPosition = " + this.jdField_e_of_type_Long);
    }
    if (this.jdField_g_of_type_Long >= 0L) {
      this.jdField_f_of_type_Long += System.currentTimeMillis() - this.jdField_g_of_type_Long;
    }
  }
  
  void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "handleClick: mPlayState = " + a(this.jdField_a_of_type_Int) + ", mCurrentPosition = " + this.jdField_e_of_type_Long);
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
        a(this.jdField_e_of_type_Long);
        return;
        j();
        return;
        a();
      } while ((this.jdField_e_of_type_Long == 0L) || (!this.jdField_v_of_type_Boolean));
      a(this.jdField_e_of_type_Long);
      return;
    }
    a(0L);
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onClick surfaceView, mHidden=" + this.jdField_n_of_type_Boolean);
    }
    if (this.jdField_n_of_type_Boolean)
    {
      d();
      e();
    }
  }
  
  protected void m()
  {
    int i1 = 0;
    String str2 = getResources().getString(2131718485);
    String str3 = getResources().getString(2131718486);
    String str4 = getResources().getString(2131718445);
    String str5 = getResources().getString(2131718464);
    String str6 = getResources().getString(2131690620);
    String str1;
    boolean bool1;
    bjnw localbjnw;
    if (this.jdField_b_of_type_Int == 0)
    {
      str1 = ShortVideoUtils.getShortVideoSavePath(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
      bool1 = FileUtils.fileExists(str1);
      if (this.jdField_i_of_type_Boolean) {
        bool1 = false;
      }
      boolean bool2 = "1".equals(DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.shortvideo_forward_switch.name(), "1"));
      if (getIntent().getIntExtra("from_busi_type", 0) == 2) {
        i1 = 1;
      }
      localbjnw = bjnw.a(this);
      if ((bool2) && (this.jdField_e_of_type_Int != 9501) && (i1 == 0)) {
        localbjnw.c(str2);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus != 5001)) {
        localbjnw.c(str3);
      }
      if (this.jdField_b_of_type_Int != 3)
      {
        if (!bool1) {
          break label269;
        }
        localbjnw.c(str4);
        localbjnw.c(str5);
      }
    }
    for (;;)
    {
      localbjnw.d(str6);
      localbjnw.show();
      localbjnw.a(new alcw(this, localbjnw, str2, str1, str3, bool1, str4, str1, str5));
      return;
      str1 = this.jdField_b_of_type_JavaLangString;
      break;
      label269:
      localbjnw.a(str4, 7);
      localbjnw.a(str5, 7);
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
      localObject = ShortVideoUtils.getShortVideoThumbPicPath(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.thumbMD5, "jpg");
      if (!FileUtils.fileExistsAndNotEmpty((String)localObject)) {}
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
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      s();
      continue;
      this.app.getTransFileController().pauseSendingShortVideo(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      s();
      continue;
      l();
      k();
      continue;
      l();
      if (this.jdField_a_of_type_Int == 1) {
        j();
      }
      this.jdField_a_of_type_Bkql.onClick(paramView);
      continue;
      s();
    }
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    runOnUiThread(new ShortVideoPlayActivity.25(this, paramTVK_IMediaPlayer));
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (!this.jdField_w_of_type_Boolean) {}
    for (;;)
    {
      EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
      return;
      if (paramConfiguration.orientation == 2) {
        ((RelativeLayout)findViewById(2131368207)).setVisibility(8);
      } else {
        ((RelativeLayout)findViewById(2131368207)).setVisibility(0);
      }
    }
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onError what=" + paramInt1 + ",extra=" + paramInt2 + ",mCacheProgress=" + this.jdField_l_of_type_Int + ", mPlayProgress=" + this.jdField_k_of_type_Int + ", mCurPlayPosition=" + this.jdField_j_of_type_Long);
    }
    runOnUiThread(new ShortVideoPlayActivity.26(this, paramTVK_IMediaPlayer, paramInt1, paramInt2, paramInt3, paramString, paramObject));
    return false;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onInfo what=" + paramInt + ",extra=" + paramObject + ",mCacheProgress=" + this.jdField_l_of_type_Int + ", mPlayProgress=" + this.jdField_k_of_type_Int + ", mCurPlayPosition=" + this.jdField_j_of_type_Long);
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
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).isPlaying())) {
        a(1);
      } else {
        a(2);
      }
    }
  }
  
  public void onNetVideoInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onNetVideoInfo what=" + paramTVK_NetVideoInfo.getErrInfo() + ",extra=" + paramTVK_NetVideoInfo.getState() + ",mCacheProgress=" + this.jdField_l_of_type_Int + ", mPlayProgress=" + this.jdField_k_of_type_Int + ", mCurPlayPosition=" + this.jdField_j_of_type_Long);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (!this.jdField_o_of_type_Boolean) {
      this.jdField_l_of_type_Boolean = true;
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).isPlaying()))
    {
      this.jdField_e_of_type_Long = ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentPostion();
      this.jdField_k_of_type_Boolean = true;
    }
    paramBundle.putLong("state_play_position", this.jdField_e_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onSaveInstanceState: mCurrentPosition: " + this.jdField_e_of_type_Long);
    }
  }
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onSeekComplete mCacheProgress=" + this.jdField_l_of_type_Int + ", mPlayProgress=" + this.jdField_k_of_type_Int + ", mCurPlayPosition=" + this.jdField_j_of_type_Long);
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).start();
    }
  }
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder) {}
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder) {}
  
  public void onSurfaceDestory(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onSurfaceDestory");
    }
    this.jdField_v_of_type_Boolean = true;
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onVideoPrepared: mDuration=" + this.jdField_d_of_type_Long + " mInterrupted" + this.jdField_l_of_type_Boolean + " mNeedPlay" + this.jdField_k_of_type_Boolean);
    }
    this.jdField_v_of_type_Boolean = false;
    runOnUiThread(new ShortVideoPlayActivity.27(this));
    if (this.jdField_b_of_type_Int == 2) {
      a(this.jdField_c_of_type_JavaLangString, 1, 1002, this.jdField_d_of_type_JavaLangString);
    }
    if (this.jdField_m_of_type_Long != 0L)
    {
      this.jdField_n_of_type_Long = (System.currentTimeMillis() - this.jdField_m_of_type_Long);
      this.jdField_m_of_type_Long = 0L;
    }
    if (this.jdField_o_of_type_Long != 0L)
    {
      this.jdField_p_of_type_Long = (System.currentTimeMillis() - this.jdField_o_of_type_Long);
      this.jdField_o_of_type_Long = 0L;
    }
    if (this.jdField_l_of_type_Boolean)
    {
      this.jdField_l_of_type_Boolean = false;
      if (this.jdField_k_of_type_Boolean) {}
    }
    do
    {
      return;
      this.jdField_k_of_type_Boolean = false;
      if (this.jdField_d_of_type_Long <= 0L) {
        h();
      }
    } while ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null));
    ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).start();
    if (this.jdField_a_of_type_Long > 0L) {
      ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).seekTo((int)this.jdField_a_of_type_Long);
    }
    a(1);
  }
  
  public void onVideoPreparing(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onVideoPreparing mCacheProgress=" + this.jdField_l_of_type_Int + ", mPlayProgress=" + this.jdField_k_of_type_Int + ", mCurPlayPosition=" + this.jdField_j_of_type_Long);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      z();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onWindowFocusChanged: hasFocus: " + paramBoolean);
    }
  }
  
  void p()
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
    a(bfur.a(this, 232, null, getString(2131718467), new alcx(this), new alcy(this)));
  }
  
  public void requestWindowFeature(Intent paramIntent)
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
      overridePendingTransition(2130772039, 2130772041);
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
    if (!this.jdField_s_of_type_Boolean) {}
    while (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    StringBuffer localStringBuffer = new StringBuffer();
    if (!this.jdField_i_of_type_Boolean)
    {
      i1 = 1;
      if (this.jdField_j_of_type_Int == 0) {
        i1 = 3;
      }
      localHashMap.put("player_state", String.valueOf(i1));
      localStringBuffer.append(" player_state " + i1);
      localHashMap.put("Download", String.valueOf(this.jdField_p_of_type_Boolean));
      localStringBuffer.append(" Download" + this.jdField_p_of_type_Boolean);
      localHashMap.put("FileSize", String.valueOf(this.jdField_i_of_type_Long));
      localStringBuffer.append(" FileSize" + this.jdField_i_of_type_Long);
      localHashMap.put("HttpDownloadSum", String.valueOf(this.jdField_n_of_type_Int));
      localStringBuffer.append(" HttpDownloadSum" + this.jdField_n_of_type_Int);
      if (this.jdField_p_of_type_Boolean) {
        break label1216;
      }
      localHashMap.put("DataFromCacheSize", String.valueOf(this.jdField_i_of_type_Long));
      localStringBuffer.append(" DataFromCacheSize" + this.jdField_i_of_type_Long);
      label277:
      localHashMap.put("FileDuration", String.valueOf(this.jdField_d_of_type_Long));
      localStringBuffer.append(" FileDuration" + this.jdField_d_of_type_Long);
      localHashMap.put("PlayTime", String.valueOf(this.jdField_k_of_type_Long));
      localStringBuffer.append(" PlayTime" + this.jdField_k_of_type_Long);
      localHashMap.put("PlayStateCount", String.valueOf(this.jdField_q_of_type_Int));
      localStringBuffer.append(" PlayStateCount" + this.jdField_q_of_type_Int);
      localHashMap.put("PlayProgress", String.valueOf(this.jdField_k_of_type_Int / 100));
      localStringBuffer.append(" PlayProgress" + this.jdField_k_of_type_Int / 100);
      localHashMap.put("FirstPlayTime", String.valueOf(this.jdField_n_of_type_Long));
      localStringBuffer.append(" FirstPlayTime" + this.jdField_n_of_type_Long);
      localHashMap.put("FirstBufferTime", String.valueOf(this.jdField_p_of_type_Long));
      localStringBuffer.append(" FirstBufferTime" + this.jdField_p_of_type_Long);
      localHashMap.put("SeekTimes", String.valueOf(this.jdField_i_of_type_Int));
      localStringBuffer.append(" SeekTimes" + this.jdField_i_of_type_Int);
      if (this.jdField_t_of_type_Int != 0) {
        break label1264;
      }
      i1 = this.jdField_t_of_type_Int;
      label610:
      localHashMap.put("BufferTimes", String.valueOf(i1));
      localStringBuffer.append(" BufferTimes" + i1);
      localHashMap.put("BufferCostTime", String.valueOf(this.jdField_q_of_type_Long));
      localStringBuffer.append(" BufferCostTime" + this.jdField_q_of_type_Long);
      if (this.jdField_t_of_type_Long != 0L)
      {
        this.jdField_s_of_type_Long = (System.currentTimeMillis() - this.jdField_t_of_type_Long);
        this.jdField_t_of_type_Long = 0L;
      }
      i1 = 0;
      if (this.jdField_o_of_type_Int != 0) {
        i1 = this.jdField_n_of_type_Int / (this.jdField_o_of_type_Int * 1000);
      }
      localHashMap.put("SpeedKBS", String.valueOf(i1));
      localStringBuffer.append(" SpeedKBS" + i1);
      if (this.jdField_s_of_type_Int <= 0) {
        break label1274;
      }
      str1 = "1";
      label794:
      localHashMap.put("IsRePlay", str1);
      localStringBuffer.append(" IsRePlay" + this.jdField_s_of_type_Int);
      localHashMap.put("SuspendTimes", String.valueOf(this.jdField_r_of_type_Int));
      localStringBuffer.append(" SuspendTimes" + this.jdField_r_of_type_Int);
      if (this.C == 0) {
        break label1281;
      }
      localHashMap.put("param_FailCode", String.valueOf(this.C));
    }
    Object localObject;
    int i3;
    label1281:
    for (boolean bool = false;; bool = true)
    {
      localHashMap.put("ErrorCode", String.valueOf(this.jdField_v_of_type_Int));
      localHashMap.put("ErrorDetailCode", String.valueOf(this.jdField_w_of_type_Int));
      localHashMap.put("HttpStatus", String.valueOf(this.jdField_u_of_type_Int));
      localStringBuffer.append(" HttpStatus" + this.jdField_u_of_type_Int);
      localHashMap.put("User-ReturnCode", this.jdField_m_of_type_JavaLangString);
      localStringBuffer.append(" User-ReturnCode" + this.jdField_m_of_type_JavaLangString);
      localHashMap.put("X-RtFlag", this.jdField_n_of_type_JavaLangString);
      localStringBuffer.append(" X-RtFlag" + this.jdField_n_of_type_JavaLangString);
      int i2 = -1;
      localObject = new StringBuffer("");
      str1 = null;
      if (!StringUtil.isEmpty(this.jdField_p_of_type_JavaLangString)) {
        str1 = InnerDns.getHostFromUrl(this.jdField_p_of_type_JavaLangString);
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
        String str2 = InnerDns.getHostFromUrl(this.jdField_a_of_type_ArrayOfJavaLangString[i1]);
        ((StringBuffer)localObject).append(str2 + ",");
        i3 = i2;
        if (i2 == -1)
        {
          i3 = i2;
          if (!StringUtil.isEmpty(str1))
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
      localHashMap.put("DataFromCacheSize", String.valueOf(this.jdField_p_of_type_Int));
      localStringBuffer.append(" DataFromCacheSize" + this.jdField_p_of_type_Int);
      break label277;
      label1264:
      i1 = this.jdField_t_of_type_Int - 1;
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
    localHashMap.put("HttpRedirectNum", String.valueOf(this.jdField_x_of_type_Int));
    localStringBuffer.append(" HttpRedirectNum" + this.jdField_x_of_type_Int);
    localHashMap.put("HttpRedirectCostMs", String.valueOf(this.jdField_y_of_type_Int));
    localStringBuffer.append(" HttpRedirectCostMs" + this.jdField_y_of_type_Int);
    localHashMap.put("HttpDnsCostMs", String.valueOf(this.z));
    localStringBuffer.append(" HttpDnsCostMs" + this.z);
    localHashMap.put("HttpConnectCostMs", String.valueOf(this.A));
    localStringBuffer.append(" HttpConnectCostMs" + this.A);
    localHashMap.put("HttpFirstRecvCostMs", String.valueOf(this.B));
    localStringBuffer.append(" HttpFirstRecvCostMs" + this.B);
    localHashMap.put("RetrySuccessTimes", "0");
    localHashMap.put("RetryFailedTimes", "0");
    localHashMap.put("ApplyCostTime", String.valueOf(this.jdField_w_of_type_Long));
    localStringBuffer.append(" ApplyCostTime" + this.jdField_w_of_type_Long);
    localHashMap.put("HttpCostTime", String.valueOf(this.jdField_s_of_type_Long));
    localStringBuffer.append(" HttpCostTime" + this.jdField_s_of_type_Long);
    localHashMap.put("DownType", "1");
    localHashMap.put("SceneType", "2");
    localHashMap.put("BusiType", String.valueOf(this.jdField_b_of_type_Int));
    localHashMap.put("SubBusiType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.subBusiType));
    localHashMap.put("FromUin", String.valueOf(this.jdField_f_of_type_JavaLangString));
    localHashMap.put("GrpUin", String.valueOf(this.jdField_j_of_type_JavaLangString));
    localHashMap.put("Uuid", String.valueOf(this.jdField_q_of_type_JavaLangString));
    localHashMap.put("MsgFileMd5", String.valueOf(this.jdField_g_of_type_JavaLangString));
    localHashMap.put("DownFileMd5", String.valueOf(this.jdField_g_of_type_JavaLangString));
    String str1 = String.valueOf(NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication().getApplicationContext()));
    localHashMap.put("NetworkInfo", str1);
    localStringBuffer.append(" NetworkInfo" + str1);
    localHashMap.put("ProductVersion", String.valueOf(this.app.getAppid()));
    localHashMap.put("EncryptKey", "0");
    if (this.jdField_q_of_type_Boolean)
    {
      str1 = "1";
      localHashMap.put("IsUpdateSuit", str1);
      localObject = new StringBuilder().append(" IsUpdateSuit");
      if (!this.jdField_q_of_type_Boolean) {
        break label2263;
      }
      str1 = "1";
      label1994:
      localStringBuffer.append(str1);
      localHashMap.put("UpdateSuitCostTime", String.valueOf(this.jdField_u_of_type_Long));
      localStringBuffer.append(" UpdateSuitCostTime" + this.jdField_u_of_type_Long);
      if (!this.jdField_r_of_type_Boolean) {
        break label2270;
      }
      str1 = "1";
      label2067:
      localHashMap.put("UpdateSuitResult", str1);
      localObject = new StringBuilder().append(" UpdateSuitResult");
      if (!this.jdField_r_of_type_Boolean) {
        break label2277;
      }
    }
    label2263:
    label2270:
    label2277:
    for (str1 = "1";; str1 = "0")
    {
      localStringBuffer.append(str1);
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoPlayActivity", 2, localStringBuffer.toString());
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actStreamingVideoPlay", bool, this.jdField_s_of_type_Long, this.jdField_i_of_type_Long, localHashMap, "");
      this.jdField_s_of_type_Boolean = false;
      this.jdField_q_of_type_Int = 0;
      this.jdField_i_of_type_Int = 0;
      this.jdField_t_of_type_Int = 0;
      this.jdField_r_of_type_Int = 0;
      this.jdField_q_of_type_Long = 0L;
      this.jdField_s_of_type_Long = 0L;
      this.jdField_k_of_type_Long = 0L;
      this.A = 0;
      this.z = 0;
      this.jdField_n_of_type_Long = 0L;
      this.jdField_p_of_type_Long = 0L;
      this.jdField_w_of_type_Long = 0L;
      this.B = 0;
      this.jdField_y_of_type_Int = 0;
      this.jdField_u_of_type_Long = 0L;
      this.jdField_v_of_type_Int = 0;
      this.jdField_w_of_type_Int = 0;
      return;
      str1 = "0";
      break;
      str1 = "0";
      break label1994;
      str1 = "0";
      break label2067;
    }
  }
  
  public void u()
  {
    String str = AppConstants.DATALINE_PC_UIN;
    Intent localIntent = a();
    localIntent.putExtra("toUin", str);
    localIntent.putExtra("uinType", 6000);
    localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
    localIntent.putExtra("forward_filepath", a());
    localIntent.putExtra("forward_extra", a());
    localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "click menu to forward shortVideo......");
    }
    Bundle localBundle = b(this).getExtras();
    localBundle.putInt("forward_type", 21);
    localBundle.putBoolean("forward_need_sendmsg", true);
    localBundle.putString("forward_thumb", ShortVideoUtils.getShortVideoThumbPicPath(this.jdField_h_of_type_JavaLangString, "jpg"));
    localBundle.putString("file_send_path", a());
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    atky.a(this, localIntent);
    h(this);
    if (this.jdField_c_of_type_Boolean) {
      awct.a("0X8009ABC");
    }
    bcef.b(this.app, "CliOper", "", "", "0X80052CC", "0X80052CC", 0, 0, "", "2", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity
 * JD-Core Version:    0.7.0.1
 */