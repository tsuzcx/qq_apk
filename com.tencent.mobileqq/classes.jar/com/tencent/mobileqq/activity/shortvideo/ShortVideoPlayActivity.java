package com.tencent.mobileqq.activity.shortvideo;

import aery;
import aesa;
import akcy;
import akcz;
import akda;
import akdb;
import akdd;
import akde;
import akdf;
import akdi;
import akdj;
import akdk;
import akdl;
import akdm;
import akdn;
import akdo;
import akdp;
import alof;
import alud;
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
import atzp;
import awoa;
import axtc;
import azdd;
import azdg;
import azdx;
import azqs;
import azri;
import bass;
import bayf;
import bazo;
import bdgk;
import bdgm;
import bdhb;
import bdin;
import bdjz;
import bdne;
import bdnn;
import bhtb;
import bhuf;
import bhvx;
import bjdt;
import bjea;
import bnle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
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
import com.tencent.widget.DragView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(11)
public class ShortVideoPlayActivity
  extends BaseActivity
  implements aesa, View.OnClickListener, bhvx, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnNetVideoInfoListener, TVK_IMediaPlayer.OnSeekCompleteListener, TVK_IMediaPlayer.OnVideoPreparedListener, TVK_IMediaPlayer.OnVideoPreparingListener, IVideoViewBase.IVideoViewCallBack
{
  static String[] jdField_b_of_type_ArrayOfJavaLangString;
  static String jdField_l_of_type_JavaLangString = bdne.f(BaseApplication.getContext());
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
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener;
  public SeekBar a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
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
  public long b;
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
  public long c;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  public RelativeLayout c;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString = "";
  public boolean c;
  int jdField_d_of_type_Int = -1;
  long jdField_d_of_type_Long = -1L;
  RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  String jdField_d_of_type_JavaLangString = "";
  public boolean d;
  public int e;
  long jdField_e_of_type_Long = -1L;
  RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  String jdField_e_of_type_JavaLangString;
  boolean jdField_e_of_type_Boolean = false;
  public int f;
  long jdField_f_of_type_Long;
  private RelativeLayout jdField_f_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  String jdField_f_of_type_JavaLangString;
  boolean jdField_f_of_type_Boolean = false;
  int jdField_g_of_type_Int;
  long jdField_g_of_type_Long;
  public String g;
  public boolean g;
  public int h;
  private long jdField_h_of_type_Long;
  public String h;
  boolean jdField_h_of_type_Boolean;
  public int i;
  private long jdField_i_of_type_Long;
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
  private boolean jdField_x_of_type_Boolean;
  private int jdField_y_of_type_Int;
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
    this.jdField_b_of_type_Long = -1L;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_f_of_type_Int = -1;
    this.jdField_j_of_type_JavaLangString = "0";
    this.jdField_k_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.3F });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(2500L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new akcy(this));
    }
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(new akdf(this));
    this.jdField_a_of_type_JavaLangRunnable = new ShortVideoPlayActivity.5(this);
    this.jdField_b_of_type_JavaLangRunnable = new ShortVideoPlayActivity.6(this);
    this.jdField_n_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new akdp(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new akdj(this);
  }
  
  private void A()
  {
    bjea localbjea = bjea.a();
    bjdt.c(getActivity(), localbjea, this.jdField_b_of_type_JavaLangString, 10001);
    azqs.b(this.app, "dc00898", "", "", "0X800753A", "0X800753A", 0, 0, "", "", "", "");
  }
  
  private void B()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (this.D == -1) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 2003)) {
      break label28;
    }
    label28:
    while (!this.jdField_u_of_type_Boolean) {
      return;
    }
    this.jdField_u_of_type_Boolean = false;
    if (this.jdField_g_of_type_Long == 0L) {}
    for (int i1 = 0;; i1 = (int)(100L * this.jdField_f_of_type_Long / this.jdField_g_of_type_Long))
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
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.transferedSize = ((int)this.jdField_f_of_type_Long);
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
      if ((this.D == 2003) && (!bdnn.a(this.jdField_b_of_type_JavaLangString)))
      {
        File localFile = new File(this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.lastModified = localFile.lastModified();
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.serial();
      this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.msgData);
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
  
  private azdg a()
  {
    azdg localazdg = new azdg();
    try
    {
      JSONObject localJSONObject = new JSONObject(this.jdField_e_of_type_JavaLangString);
      if (localJSONObject != null)
      {
        localazdg.jdField_a_of_type_Int = localJSONObject.getInt("busi_type");
        localazdg.jdField_a_of_type_JavaLangString = localJSONObject.getString("file_uuid");
        String str = localJSONObject.getString("file_md5");
        localazdg.jdField_e_of_type_JavaLangString = str;
        this.jdField_g_of_type_JavaLangString = str;
        localazdg.jdField_b_of_type_Long = localJSONObject.getInt("file_size");
        localazdg.jdField_b_of_type_Int = this.jdField_f_of_type_Int;
        localazdg.jdField_b_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
        localazdg.jdField_c_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
        localazdg.jdField_d_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
        localazdg.jdField_e_of_type_Int = 1001;
        this.jdField_c_of_type_Int = 1001;
        localazdg.jdField_h_of_type_JavaLangString = a(localazdg.jdField_e_of_type_JavaLangString);
        return localazdg;
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
    StringBuilder localStringBuilder = new StringBuilder(alof.aX);
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
      localHashMap.put("param_picSize", String.valueOf(this.jdField_g_of_type_Long));
      localHashMap.put("param_fileMd5", this.jdField_g_of_type_JavaLangString);
      localHashMap.put("param_busiType", this.jdField_b_of_type_Int + "");
      localHashMap.put("param_videoDuration", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime));
      if (!paramBoolean) {
        break;
      }
      azri.a(BaseApplication.getContext()).a(null, str, true, this.jdField_q_of_type_Long, this.jdField_g_of_type_Long, localHashMap, "");
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
    azri.a(BaseApplication.getContext()).a(null, str, false, this.jdField_q_of_type_Long, 0L, localHashMap, "");
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
      QQToast.a(paramContext, 1, 2131719547, 0).b(paramContext.getResources().getDimensionPixelSize(2131298914));
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
    if (bdnn.a(paramString)) {}
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
            azri.a(BaseApplication.getContext()).a(null, "actSDKDownloadHijacked", true, 0L, 0L, (HashMap)localObject2, "");
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
    if (this.jdField_i_of_type_Boolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      if ((azdd.jdField_a_of_type_Boolean) || (System.currentTimeMillis() - azdd.jdField_a_of_type_Long < 300000L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "needRemind=false");
        }
        i1 = 0;
      }
      if (i1 != 0)
      {
        Object localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131720121);
        bdjz localbdjz = bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230, null, (String)localObject, 2131694806, 2131721503, new akdn(this), new akdo(this));
        localObject = atzp.a(this.jdField_a_of_type_AndroidContentContext, this.app, 1, (String)localObject);
        if ((localObject instanceof SpannableString)) {
          localbdjz.setMessageWithoutAutoLink((CharSequence)localObject);
        }
        j();
        this.jdField_k_of_type_Boolean = false;
        a(localbdjz);
      }
      return;
    }
  }
  
  private void v()
  {
    this.jdField_t_of_type_Long = System.currentTimeMillis();
    this.jdField_q_of_type_Boolean = true;
    TVK_SDKMgr.installPlugin(getApplicationContext(), new akdb(this));
  }
  
  private void w()
  {
    Object localObject;
    if (this.jdField_j_of_type_Boolean)
    {
      localObject = this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      if ((localObject instanceof ShortVideoUploadProcessor))
      {
        localObject = (ShortVideoUploadProcessor)localObject;
        a(((ShortVideoUploadProcessor)localObject).b(), ((ShortVideoUploadProcessor)localObject).a());
      }
      localObject = aery.a(this.app);
      if (localObject != null) {
        ((aery)localObject).a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this);
      }
      this.jdField_b_of_type_JavaLangString = ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
      if (new File(this.jdField_b_of_type_JavaLangString).exists())
      {
        long l1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
        this.jdField_g_of_type_Long = l1;
        this.jdField_f_of_type_Long = l1;
        this.jdField_l_of_type_Int = 10000;
      }
      for (;;)
      {
        a(this.jdField_c_of_type_Long);
        return;
        a(alud.a(2131714472));
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
      this.jdField_g_of_type_Long = ((JSONObject)localObject).getInt("file_size");
      this.jdField_q_of_type_JavaLangString = ((JSONObject)localObject).getString("file_uuid");
      label297:
      localObject = new File(this.jdField_b_of_type_JavaLangString);
      if ((((File)localObject).exists()) && (((File)localObject).isFile()))
      {
        this.jdField_f_of_type_Long = ((File)localObject).length();
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "onCreateVideoSdkView(), #PLAY_CALLER_STRUCT_MSG#, have video size=" + this.jdField_f_of_type_Long + " msg.size=" + this.jdField_g_of_type_Long);
        }
        if (this.jdField_f_of_type_Long < this.jdField_g_of_type_Long) {
          this.jdField_i_of_type_Boolean = true;
        }
        if (this.jdField_i_of_type_Boolean)
        {
          y();
          localObject = aery.a(this.app);
          if (localObject != null) {
            ((aery)localObject).a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this);
          }
          this.jdField_a_of_type_AndroidWidgetSeekBar.setSecondaryProgress(this.jdField_l_of_type_Int);
        }
      }
      do
      {
        this.jdField_p_of_type_Boolean = this.jdField_i_of_type_Boolean;
        if (this.jdField_i_of_type_Boolean) {
          break label975;
        }
        a(this.jdField_c_of_type_Long);
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
          label520:
          awoa.a(1000, i1);
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.setBitValue(1, (byte)1);
          ThreadManager.getFileThreadHandler().post(new ShortVideoPlayActivity.15(this));
        }
      }
      else
      {
        this.jdField_b_of_type_JavaLangString = ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
        localObject = new File(this.jdField_b_of_type_JavaLangString);
        if (!((File)localObject).exists()) {
          break label951;
        }
        this.jdField_f_of_type_Long = ((File)localObject).length();
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "onCreateVideoSdkView(), #PLAY_CALLER_SHORT_VIDEO#, have video size=" + this.jdField_f_of_type_Long + " msg.size=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize + " status=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus);
        }
        this.jdField_g_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
        this.jdField_l_of_type_Int = 10000;
        this.jdField_a_of_type_AndroidWidgetSeekBar.setSecondaryProgress(10000);
        this.jdField_h_of_type_Boolean = false;
        if (this.jdField_f_of_type_Long >= this.jdField_g_of_type_Long) {}
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
            localObject = azdd.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 1);
            if (localObject != null)
            {
              azdd.a((azdx)localObject, this.app);
              this.jdField_c_of_type_Int = ((azdx)localObject).a.jdField_e_of_type_Int;
              a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
            }
          }
          localObject = aery.a(this.app);
          if (localObject != null) {
            ((aery)localObject).a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this);
          }
          this.jdField_g_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
          this.jdField_l_of_type_Int = ((int)(10000L * this.jdField_f_of_type_Long / this.jdField_g_of_type_Long));
          this.jdField_k_of_type_Int = 0;
          this.jdField_h_of_type_Long = 0L;
          this.jdField_h_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidWidgetSeekBar.setSecondaryProgress(this.jdField_l_of_type_Int);
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPlayActivity", 2, "onCreateVideoSdkView() mCacheProgress=" + this.jdField_l_of_type_Int + ",mTransferredSize=" + this.jdField_f_of_type_Long);
          }
        }
        if (this.jdField_b_of_type_Int != 5) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
        i1 = 102;
        break label520;
        label951:
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
        }
      }
      label975:
      p();
      a(4);
      return;
    }
    catch (Exception localException)
    {
      break label297;
    }
  }
  
  private void x()
  {
    if ((bhtb.g()) && (!ShortVideoUtils.c()) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
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
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719547, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
    }
    label113:
    label118:
    azdg localazdg;
    do
    {
      return;
      i1 = 0;
      break;
      i1 = 0;
      break label74;
      localObject = azdd.a(2, 0);
      localazdg = a();
      if ((!AppNetConnInfo.isWifiConn()) && (localazdg != null) && (localazdg.jdField_b_of_type_Long > 204800L)) {
        a(bdgm.a(this, 230, getString(2131720122), getString(2131720123), new akdd(this), new akde(this)));
      }
    } while (localazdg == null);
    localazdg.jdField_a_of_type_Boolean = true;
    ((azdx)localObject).a = localazdg;
    azdd.a((azdx)localObject, this.app);
    this.jdField_k_of_type_JavaLangString = localazdg.jdField_h_of_type_JavaLangString;
  }
  
  private void z()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  public void F()
  {
    azqs.b(null, "dc00898", "", "", "0X8009AB3", "0X8009AB3", this.jdField_d_of_type_Int, 0, "", "", "", "");
    g();
    finish();
    try
    {
      overridePendingTransition(2130772036, 2130772038);
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
        if (i2 != this.jdField_g_of_type_Long)
        {
          this.jdField_g_of_type_Long = i2;
          QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] OnDownloadCallback fileSize mismatched msg.file=" + this.jdField_g_of_type_Long);
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
            this.jdField_f_of_type_Long = l1;
            this.jdField_g_of_type_Boolean = false;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPlayActivity", 2, "OnDownloadCallback, mTransferredSize = " + this.jdField_f_of_type_Long);
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
            break label793;
          }
          if (i1 == 7)
          {
            this.jdField_i_of_type_Boolean = false;
            this.jdField_f_of_type_Long = this.jdField_g_of_type_Long;
            this.D = 2003;
            B();
          }
          if (this.jdField_r_of_type_Long != 0L)
          {
            this.jdField_q_of_type_Long = (System.currentTimeMillis() - this.jdField_r_of_type_Long);
            this.jdField_r_of_type_Long = 0L;
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
          paramString.append("offset=").append(this.jdField_f_of_type_Long).append("|");
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
        if (l1 <= this.jdField_f_of_type_Long) {
          continue;
        }
        this.jdField_f_of_type_Long = l1;
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
      label793:
      if (paramString.has("httpHeader"))
      {
        String str = paramString.getString("httpHeader");
        try
        {
          b(str);
          if ((!TextUtils.isEmpty(this.jdField_m_of_type_JavaLangString)) && (this.jdField_m_of_type_JavaLangString.equals("-5103059")))
          {
            this.D = 5002;
            B();
            a(alud.a(2131714451));
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            this.C = 9064;
            this.D = 2005;
            B();
            a(alud.a(2131714456));
          }
        }
      }
    }
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
    int i3 = bdin.b(BaseApplication.getContext());
    int i1 = i2;
    if (i3 != 1) {
      if (i3 != 4) {
        break label108;
      }
    }
    label108:
    for (i1 = i2; i1 != 0; i1 = 0)
    {
      v();
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698160), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131298914));
      return;
    }
    bdgm.a(this.jdField_a_of_type_AndroidContentContext, 232, null, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698157), new akcz(this), new akda(this)).show();
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
    String str1 = getString(2131720129);
    Object localObject;
    int i2;
    if ((paramInt1 == 101) && (this.jdField_a_of_type_ArrayOfJavaLangString != null) && (!bdnn.a(this.jdField_a_of_type_JavaLangString)))
    {
      localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
      i2 = localObject.length;
      i1 = 0;
      while (i1 < i2)
      {
        String str2 = localObject[i1];
        if (!bdnn.a(str2)) {
          bazo.a().a(this.jdField_a_of_type_JavaLangString, bazo.a(str2), 1005);
        }
        i1 += 1;
      }
    }
    if (this.jdField_b_of_type_Int == 1)
    {
      p();
      q();
      str1 = getString(2131720126);
      localObject = str1;
      if (paramInt1 == 122) {
        if (paramInt2 != 204)
        {
          localObject = str1;
          if (paramInt2 != 202) {}
        }
        else
        {
          localObject = getString(2131720126);
        }
      }
      a(bdgm.a(this, 232, null, (String)localObject, new akdi(this), null));
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "handleError，mPlayCallerType = " + this.jdField_b_of_type_Int);
      }
      this.jdField_d_of_type_Long = -1L;
      this.jdField_e_of_type_Long = -1L;
      return;
    }
    if (this.jdField_b_of_type_Int == 0)
    {
      if (this.jdField_e_of_type_Boolean) {
        break label408;
      }
      i2 = (int)(bdgk.e() / 1024L);
      if (bdnn.a(this.jdField_b_of_type_JavaLangString)) {
        break label411;
      }
    }
    label408:
    label411:
    for (int i1 = (int)(new File(this.jdField_b_of_type_JavaLangString).length() / 1024L);; i1 = 0)
    {
      localObject = bdgk.d();
      azqs.b(this.app, "CliOper", "", "", "0X8004674", "0X8004674", 0, 0, "" + i2, "" + i1, (String)localObject, this.jdField_g_of_type_JavaLangString);
      this.jdField_e_of_type_Boolean = true;
      break;
      if (this.jdField_b_of_type_Int == 2)
      {
        a(this.jdField_c_of_type_JavaLangString, 0, 1002, this.jdField_d_of_type_JavaLangString);
        str1 = getString(2131720126);
        break;
      }
      break;
    }
  }
  
  public void a(long paramLong)
  {
    long l1 = paramLong;
    label811:
    label851:
    label1246:
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
          this.jdField_m_of_type_Long = System.currentTimeMillis();
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
          break label1064;
        }
        if (paramLong != 0L) {
          break label1246;
        }
        l1 = paramLong;
        if (this.jdField_a_of_type_AndroidWidgetSeekBar.getProgress() <= 0) {
          break label1246;
        }
        l1 = paramLong;
        if (this.jdField_a_of_type_AndroidWidgetSeekBar.getProgress() >= 10000) {
          break label1246;
        }
        l1 = paramLong;
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) {
          break label1246;
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
            break label912;
          }
          if (((this.jdField_b_of_type_Int != 0) && (this.jdField_b_of_type_Int != 5)) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
            break label851;
          }
          str = ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
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
          this.jdField_r_of_type_Long = System.currentTimeMillis();
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
                break label1087;
              }
              l1 = paramLong;
              azqs.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "1", "", "");
              l1 = paramLong;
              this.jdField_d_of_type_Boolean = true;
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
        catch (Exception localException2)
        {
          Object localObject2;
          Object localObject1;
          break label811;
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
            azqs.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "2", "", "");
            l1 = paramLong;
            this.jdField_d_of_type_Boolean = true;
          }
          else
          {
            l1 = paramLong;
            if (this.jdField_e_of_type_Int == 1)
            {
              l1 = paramLong;
              azqs.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "3", "", "");
              l1 = paramLong;
              this.jdField_d_of_type_Boolean = true;
            }
            else
            {
              l1 = paramLong;
              azqs.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "4", "", "");
              l1 = paramLong;
              this.jdField_d_of_type_Boolean = true;
            }
          }
        }
      }
    }
    label912:
    label1064:
    label1087:
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
      this.jdField_b_of_type_Boolean = paramIntent.getExtras().getBoolean("video_title_bar_hide", false);
      this.jdField_c_of_type_JavaLangString = paramIntent.getExtras().getString("ad_gdt");
      this.jdField_d_of_type_JavaLangString = paramIntent.getExtras().getString("msg_id");
      this.jdField_f_of_type_Int = paramIntent.getExtras().getInt("from_uin_type");
      this.jdField_j_of_type_JavaLangString = paramIntent.getExtras().getString("from_session_uin");
      this.jdField_e_of_type_Int = paramIntent.getExtras().getInt("uintype");
      this.jdField_e_of_type_JavaLangString = paramIntent.getExtras().getString("struct_msg_video_info");
      this.jdField_f_of_type_JavaLangString = paramIntent.getExtras().getString("from_uin");
      this.jdField_k_of_type_Long = paramIntent.getExtras().getLong("message_click_start");
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
      if ((this.jdField_b_of_type_Int == 0) || (this.jdField_b_of_type_Int == 5))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)paramIntent.getExtras().getParcelable("key_message_for_shortvideo"));
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)
        {
          QQToast.a(this, 1, alud.a(2131714428), 0).b(getTitleBarHeight());
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
  
  public void a(View paramView, bass parambass, int paramInt1, int paramInt2)
  {
    int i1 = 0;
    if (((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq != parambass.jdField_b_of_type_Long)) && (this.jdField_b_of_type_Int != 2)) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, " handleMessage what==" + paramInt1 + ", arg1:" + paramInt2);
        }
        if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
          QLog.d("ShortVideoPlayActivity", 2, "handleMessage msg.uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq + ",fileType:" + ShortVideoUtils.a(parambass.jdField_b_of_type_Int) + " ===> fileStatus:" + ShortVideoUtils.b(parambass.jdField_d_of_type_Int));
        }
      } while ((parambass.jdField_b_of_type_Int != 6) && (parambass.jdField_b_of_type_Int != 17) && (parambass.jdField_b_of_type_Int != 9) && (parambass.jdField_b_of_type_Int != 20));
      switch (parambass.jdField_d_of_type_Int)
      {
      case 2004: 
      default: 
        return;
      case 1002: 
        a(parambass.jdField_e_of_type_Long, parambass.jdField_a_of_type_Long);
        return;
      case 2003: 
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "handleMessage STATUS_RECV_FINISHED");
        }
        this.jdField_l_of_type_Int = 10000;
        return;
      case 2005: 
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720140, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
        this.C = parambass.jdField_g_of_type_Int;
        return;
      case 5001: 
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720138, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
        this.C = parambass.jdField_g_of_type_Int;
        return;
      case 5002: 
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720139, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
        this.C = parambass.jdField_g_of_type_Int;
        return;
      case 2002: 
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "STATUS_RECV_PROCESS: get url finished");
        }
        this.jdField_g_of_type_Int = ((int)(System.currentTimeMillis() - this.jdField_e_of_type_Long));
      }
    } while (parambass.c == null);
    this.jdField_a_of_type_ArrayOfJavaLangString = parambass.c;
    this.jdField_a_of_type_JavaLangString = parambass.jdField_u_of_type_JavaLangString;
    this.jdField_u_of_type_Long = parambass.jdField_f_of_type_Long;
    paramInt1 = i1;
    while (paramInt1 < 1)
    {
      if (!bdnn.a(this.jdField_a_of_type_JavaLangString))
      {
        paramView = new StringBuilder();
        parambass = this.jdField_a_of_type_ArrayOfJavaLangString;
        parambass[paramInt1] = (parambass[paramInt1] + "&txhost=" + this.jdField_a_of_type_JavaLangString);
      }
      paramInt1 += 1;
    }
    a(0L);
    return;
    z();
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo)
  {
    String str = ShortVideoUtils.d(bdin.a(this.jdField_a_of_type_AndroidContentContext));
    if ((paramMessageForShortVideo.istroop == 0) || (paramMessageForShortVideo.istroop == 1008))
    {
      azqs.b(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "1", str, "");
      return;
    }
    if (paramMessageForShortVideo.istroop == 3000)
    {
      azqs.b(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "2", str, "");
      return;
    }
    if (paramMessageForShortVideo.istroop == 1)
    {
      azqs.b(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "3", str, "");
      return;
    }
    azqs.b(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "4", str, "");
  }
  
  void a(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onCompletion(), mPlayProgress=" + this.jdField_k_of_type_Int + ", mCacheProgress=" + this.jdField_l_of_type_Int + ", mCurPlayPosition" + this.jdField_h_of_type_Long + ", mDuration=" + this.jdField_b_of_type_Long);
    }
    this.jdField_k_of_type_Int = 10000;
    if (!this.jdField_y_of_type_Boolean) {
      this.jdField_w_of_type_Long = this.jdField_b_of_type_Long;
    }
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(10000);
    if ((this.jdField_b_of_type_Int == 2) && (this.jdField_a_of_type_Int == 1)) {
      a(this.jdField_c_of_type_JavaLangString, 2, 1002, this.jdField_d_of_type_JavaLangString);
    }
    a(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_AndroidWidgetTextView.getText());
    d();
    this.jdField_c_of_type_Long = 0L;
    this.jdField_o_of_type_Boolean = true;
    if (this.jdField_e_of_type_Long >= 0L)
    {
      this.jdField_d_of_type_Long += System.currentTimeMillis() - this.jdField_e_of_type_Long;
      if (!this.jdField_f_of_type_Boolean)
      {
        new axtc(BaseApplication.getContext()).a(this.app, 2002, (int)(this.jdField_b_of_type_Long / 1000L), this.jdField_f_of_type_Int, this.jdField_j_of_type_JavaLangString, this.jdField_d_of_type_Long / 1000L);
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
    azqs.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D93", "0X8005D93", paramInt2, 1, paramInt1, paramString1, paramString2, "", "");
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
    if (this.jdField_e_of_type_Long >= 0L) {
      this.jdField_d_of_type_Long += System.currentTimeMillis() - this.jdField_e_of_type_Long;
    }
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    return bool1;
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
          w();
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
              if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) {
                ((MqqHandler)this.jdField_b_of_type_JavaLangRefWeakReference.get()).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
              }
              this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845324);
              this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(alud.a(2131714473));
              return;
              if ((this.jdField_a_of_type_Int == 4) && (paramInt != 4) && (this.jdField_p_of_type_Long != 0L)) {
                this.jdField_o_of_type_Long += System.currentTimeMillis() - this.jdField_p_of_type_Long;
              }
              break;
            }
          }
          this.jdField_j_of_type_Long = System.currentTimeMillis();
          this.jdField_q_of_type_Int += 1;
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845326);
          this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(alud.a(2131714453));
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
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845324);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(alud.a(2131714455));
        return;
        this.jdField_p_of_type_Long = System.currentTimeMillis();
        this.jdField_t_of_type_Int += 1;
        if (this.jdField_i_of_type_Boolean) {
          this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        }
      } while (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null);
      ((MqqHandler)this.jdField_b_of_type_JavaLangRefWeakReference.get()).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      ((MqqHandler)this.jdField_b_of_type_JavaLangRefWeakReference.get()).postDelayed(this.jdField_a_of_type_JavaLangRunnable, 50L);
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845324);
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(alud.a(2131714446));
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(l1));
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).isPlaying());
  }
  
  void c()
  {
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)getLayoutInflater().inflate(2131561307, null, false));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131376034));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131371220));
    x();
    this.jdField_a_of_type_AndroidViewView = this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131371460);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131364882));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131369769));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131370187));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131372339));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131378220));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131376325));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(10000);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131371461));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131363779));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131375207));
    if (((this.jdField_b_of_type_Int == 0) || (this.jdField_b_of_type_Int == 5)) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1001) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1002)) && (this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq) != null))
    {
      this.jdField_j_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131379355));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131379357));
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(100);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131364328));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131379356));
    }
    this.jdField_a_of_type_ComTencentWidgetDragView = new DragView(this);
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentWidgetDragView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentWidgetDragView.setGestureChangeListener(this);
    if (bnle.b()) {}
    for (int i1 = bnle.jdField_a_of_type_Int;; i1 = 0)
    {
      if (this.jdField_a_of_type_AndroidGraphicsRect != null)
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsRect;
        ((Rect)localObject).top -= i1;
        localObject = this.jdField_a_of_type_AndroidGraphicsRect;
        ((Rect)localObject).bottom -= i1;
      }
      this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(this.jdField_a_of_type_AndroidGraphicsRect);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131373596));
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_e_of_type_AndroidWidgetRelativeLayout);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131369294));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.bringToFront();
      localObject = (RelativeLayout)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131369293);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
      localLayoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(getApplicationContext());
      ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131363024));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      b(0L);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(0L));
      n();
      o();
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
      QQToast.a(this, 2131720115, 0).a();
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
    overridePendingTransition(0, 2130772345);
  }
  
  /* Error */
  public boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield 1816	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:mActNeedImmersive	Z
    //   5: aload_0
    //   6: invokestatic 1819	bnle:a	(Landroid/app/Activity;)V
    //   9: invokestatic 1740	bnle:b	()Z
    //   12: ifeq +8 -> 20
    //   15: aload_0
    //   16: invokestatic 1822	bnle:c	(Landroid/app/Activity;)Z
    //   19: pop
    //   20: aload_0
    //   21: aload_1
    //   22: invokespecial 1824	com/tencent/mobileqq/app/BaseActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   25: pop
    //   26: aload_0
    //   27: ldc_w 1825
    //   30: invokespecial 1828	com/tencent/mobileqq/app/BaseActivity:setContentView	(I)V
    //   33: aload_0
    //   34: invokevirtual 1832	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:getWindow	()Landroid/view/Window;
    //   37: sipush 128
    //   40: invokevirtual 1837	android/view/Window:addFlags	(I)V
    //   43: aload_0
    //   44: aload_0
    //   45: invokevirtual 1838	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:getResources	()Landroid/content/res/Resources;
    //   48: invokevirtual 1842	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   51: getfield 1847	android/util/DisplayMetrics:widthPixels	I
    //   54: putfield 1849	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:E	I
    //   57: aload_0
    //   58: aload_0
    //   59: invokevirtual 1838	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:getResources	()Landroid/content/res/Resources;
    //   62: invokevirtual 1842	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   65: getfield 1852	android/util/DisplayMetrics:heightPixels	I
    //   68: putfield 1854	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:F	I
    //   71: aload_0
    //   72: aload_0
    //   73: ldc_w 1855
    //   76: invokevirtual 1753	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:findViewById	(I)Landroid/view/View;
    //   79: checkcast 965	android/widget/LinearLayout
    //   82: putfield 1857	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   85: aload_0
    //   86: getfield 1857	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   89: ifnull +34 -> 123
    //   92: aload_0
    //   93: getfield 1857	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   96: invokevirtual 1858	android/widget/LinearLayout:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   99: astore_2
    //   100: aload_2
    //   101: getstatic 1741	bnle:jdField_a_of_type_Int	I
    //   104: putfield 1863	android/view/ViewGroup$LayoutParams:height	I
    //   107: aload_0
    //   108: getfield 1857	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   111: aload_2
    //   112: invokevirtual 1864	android/widget/LinearLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   115: aload_0
    //   116: getfield 1857	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   119: iconst_0
    //   120: invokevirtual 966	android/widget/LinearLayout:setVisibility	(I)V
    //   123: invokestatic 487	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +285 -> 411
    //   129: new 426	java/lang/StringBuilder
    //   132: dup
    //   133: ldc_w 1866
    //   136: invokespecial 469	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   139: astore_2
    //   140: aload_2
    //   141: ldc_w 1868
    //   144: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: getstatic 1873	android/os/Build:PRODUCT	Ljava/lang/String;
    //   150: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc_w 684
    //   156: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload_2
    //   161: ldc_w 1875
    //   164: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: getstatic 1878	android/os/Build:MODEL	Ljava/lang/String;
    //   170: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: ldc_w 684
    //   176: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_2
    //   181: ldc_w 1880
    //   184: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: getstatic 1883	android/os/Build:BOARD	Ljava/lang/String;
    //   190: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc_w 684
    //   196: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload_2
    //   201: ldc_w 1885
    //   204: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: getstatic 1888	android/os/Build:BOOTLOADER	Ljava/lang/String;
    //   210: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: ldc_w 684
    //   216: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload_2
    //   221: ldc_w 1890
    //   224: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: getstatic 1893	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   230: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc_w 684
    //   236: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload_2
    //   241: ldc_w 1895
    //   244: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: getstatic 1898	android/os/Build:CPU_ABI2	Ljava/lang/String;
    //   250: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: ldc_w 684
    //   256: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload_2
    //   261: ldc_w 1900
    //   264: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: getstatic 1903	android/os/Build:DEVICE	Ljava/lang/String;
    //   270: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc_w 684
    //   276: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload_2
    //   281: ldc_w 1905
    //   284: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: getstatic 1908	android/os/Build:DISPLAY	Ljava/lang/String;
    //   290: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc_w 684
    //   296: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload_2
    //   301: ldc_w 1910
    //   304: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: getstatic 1913	android/os/Build:FINGERPRINT	Ljava/lang/String;
    //   310: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: ldc_w 684
    //   316: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload_2
    //   321: ldc_w 1915
    //   324: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: getstatic 1918	android/os/Build:HARDWARE	Ljava/lang/String;
    //   330: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: ldc_w 684
    //   336: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload_2
    //   341: ldc_w 1920
    //   344: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: getstatic 1923	android/os/Build:ID	Ljava/lang/String;
    //   350: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: ldc_w 684
    //   356: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload_2
    //   361: ldc_w 1925
    //   364: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: getstatic 1928	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   370: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: ldc_w 684
    //   376: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload_2
    //   381: ldc_w 1930
    //   384: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: getstatic 183	android/os/Build$VERSION:SDK_INT	I
    //   390: invokevirtual 494	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   393: ldc_w 684
    //   396: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: ldc_w 489
    //   403: iconst_2
    //   404: aload_2
    //   405: invokevirtual 438	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 1086	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: aload_1
    //   412: ifnull +51 -> 463
    //   415: aload_0
    //   416: aload_1
    //   417: ldc_w 1932
    //   420: invokevirtual 1388	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   423: i2l
    //   424: putfield 819	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_c_of_type_Long	J
    //   427: invokestatic 487	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   430: ifeq +33 -> 463
    //   433: ldc_w 489
    //   436: iconst_2
    //   437: new 426	java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   444: ldc_w 1934
    //   447: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload_0
    //   451: getfield 819	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_c_of_type_Long	J
    //   454: invokevirtual 431	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   457: invokevirtual 438	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   460: invokestatic 499	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   463: aload_0
    //   464: aload_0
    //   465: putfield 737	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   468: aload_0
    //   469: aload_0
    //   470: invokespecial 378	com/tencent/mobileqq/app/BaseActivity:getIntent	()Landroid/content/Intent;
    //   473: invokevirtual 1363	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   476: putfield 1936	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   479: aload_0
    //   480: aload_0
    //   481: invokespecial 378	com/tencent/mobileqq/app/BaseActivity:getIntent	()Landroid/content/Intent;
    //   484: invokevirtual 1938	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:a	(Landroid/content/Intent;)V
    //   487: aload_0
    //   488: getfield 1431	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_w_of_type_Boolean	Z
    //   491: ifeq +200 -> 691
    //   494: aload_0
    //   495: ldc_w 1939
    //   498: invokevirtual 1753	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:findViewById	(I)Landroid/view/View;
    //   501: checkcast 1658	com/tencent/image/URLImageView
    //   504: astore_1
    //   505: aload_0
    //   506: getfield 1435	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_r_of_type_JavaLangString	Ljava/lang/String;
    //   509: ifnull +360 -> 869
    //   512: aload_0
    //   513: getfield 1435	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_r_of_type_JavaLangString	Ljava/lang/String;
    //   516: invokevirtual 1941	java/lang/String:isEmpty	()Z
    //   519: ifne +350 -> 869
    //   522: aload_1
    //   523: iconst_0
    //   524: invokevirtual 1659	com/tencent/image/URLImageView:setVisibility	(I)V
    //   527: aload_1
    //   528: aload_0
    //   529: getfield 1435	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_r_of_type_JavaLangString	Ljava/lang/String;
    //   532: invokestatic 1947	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;)Lcom/tencent/image/URLDrawable;
    //   535: invokevirtual 1951	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   538: aload_0
    //   539: getfield 463	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   542: ifnull +30 -> 572
    //   545: aload_0
    //   546: getfield 463	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   549: invokevirtual 1941	java/lang/String:isEmpty	()Z
    //   552: ifne +20 -> 572
    //   555: aload_1
    //   556: iconst_1
    //   557: invokevirtual 1954	com/tencent/image/URLImageView:setClickable	(Z)V
    //   560: aload_1
    //   561: new 1956	akdq
    //   564: dup
    //   565: aload_0
    //   566: invokespecial 1957	akdq:<init>	(Lcom/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity;)V
    //   569: invokevirtual 1958	com/tencent/image/URLImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   572: aload_0
    //   573: ldc_w 1959
    //   576: invokevirtual 1753	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:findViewById	(I)Landroid/view/View;
    //   579: checkcast 1658	com/tencent/image/URLImageView
    //   582: astore_1
    //   583: aload_0
    //   584: getfield 1439	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_t_of_type_JavaLangString	Ljava/lang/String;
    //   587: ifnull +334 -> 921
    //   590: aload_0
    //   591: getfield 1439	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_t_of_type_JavaLangString	Ljava/lang/String;
    //   594: invokevirtual 1941	java/lang/String:isEmpty	()Z
    //   597: ifne +324 -> 921
    //   600: aload_1
    //   601: iconst_0
    //   602: invokevirtual 1659	com/tencent/image/URLImageView:setVisibility	(I)V
    //   605: aload_1
    //   606: aload_0
    //   607: getfield 1439	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_t_of_type_JavaLangString	Ljava/lang/String;
    //   610: invokestatic 1947	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;)Lcom/tencent/image/URLDrawable;
    //   613: invokevirtual 1951	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   616: aload_0
    //   617: getfield 1445	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_u_of_type_JavaLangString	Ljava/lang/String;
    //   620: ifnull +326 -> 946
    //   623: aload_0
    //   624: getfield 1445	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_u_of_type_JavaLangString	Ljava/lang/String;
    //   627: invokevirtual 1941	java/lang/String:isEmpty	()Z
    //   630: ifne +316 -> 946
    //   633: aload_0
    //   634: ldc_w 1960
    //   637: invokevirtual 1753	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:findViewById	(I)Landroid/view/View;
    //   640: checkcast 507	android/widget/TextView
    //   643: astore_1
    //   644: aload_1
    //   645: iconst_0
    //   646: invokevirtual 1961	android/widget/TextView:setVisibility	(I)V
    //   649: aload_1
    //   650: aload_0
    //   651: getfield 1445	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_u_of_type_JavaLangString	Ljava/lang/String;
    //   654: invokevirtual 511	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   657: aload_0
    //   658: getfield 463	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   661: ifnull +30 -> 691
    //   664: aload_0
    //   665: getfield 463	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   668: invokevirtual 1941	java/lang/String:isEmpty	()Z
    //   671: ifne +20 -> 691
    //   674: aload_1
    //   675: iconst_1
    //   676: invokevirtual 1962	android/widget/TextView:setClickable	(Z)V
    //   679: aload_1
    //   680: new 1964	akdr
    //   683: dup
    //   684: aload_0
    //   685: invokespecial 1965	akdr:<init>	(Lcom/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity;)V
    //   688: invokevirtual 1777	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   691: aload_0
    //   692: invokevirtual 1967	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:c	()V
    //   695: aload_0
    //   696: invokevirtual 1969	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:a	()V
    //   699: new 1971	android/content/IntentFilter
    //   702: dup
    //   703: invokespecial 1972	android/content/IntentFilter:<init>	()V
    //   706: astore_1
    //   707: aload_1
    //   708: ldc_w 1974
    //   711: invokevirtual 1977	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   714: aload_1
    //   715: ldc_w 1979
    //   718: invokevirtual 1977	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   721: aload_0
    //   722: aload_0
    //   723: getfield 232	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   726: aload_1
    //   727: invokevirtual 1983	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   730: pop
    //   731: aload_0
    //   732: getfield 257	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   735: ldc 2
    //   737: aload_0
    //   738: getfield 215	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_b_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   741: invokevirtual 1223	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   744: checkcast 878	mqq/os/MqqHandler
    //   747: invokevirtual 1987	com/tencent/mobileqq/app/QQAppInterface:setHandler	(Ljava/lang/Class;Lmqq/os/MqqHandler;)V
    //   750: aload_0
    //   751: invokestatic 729	java/lang/System:currentTimeMillis	()J
    //   754: putfield 148	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_e_of_type_Long	J
    //   757: aload_0
    //   758: getfield 257	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   761: ldc_w 259
    //   764: ldc 130
    //   766: ldc 130
    //   768: ldc_w 1989
    //   771: ldc_w 1989
    //   774: iconst_0
    //   775: iconst_0
    //   776: ldc 130
    //   778: ldc 130
    //   780: ldc 130
    //   782: ldc 130
    //   784: invokestatic 266	azqs:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   787: aload_0
    //   788: getfield 257	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   791: ldc_w 259
    //   794: ldc 130
    //   796: ldc 130
    //   798: ldc_w 1991
    //   801: ldc_w 1991
    //   804: iconst_0
    //   805: iconst_0
    //   806: ldc 130
    //   808: ldc 130
    //   810: ldc 130
    //   812: ldc 130
    //   814: invokestatic 266	azqs:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   817: aload_0
    //   818: getfield 986	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_c_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   821: ifnull +19 -> 840
    //   824: aload_0
    //   825: getfield 1381	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_b_of_type_Boolean	Z
    //   828: ifeq +12 -> 840
    //   831: aload_0
    //   832: getfield 986	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:jdField_c_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   835: bipush 8
    //   837: invokevirtual 961	android/widget/RelativeLayout:setVisibility	(I)V
    //   840: iconst_1
    //   841: ireturn
    //   842: astore_2
    //   843: invokestatic 487	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   846: ifeq +14 -> 860
    //   849: ldc_w 489
    //   852: iconst_2
    //   853: ldc_w 1993
    //   856: aload_2
    //   857: invokestatic 1332	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   860: aload_1
    //   861: bipush 8
    //   863: invokevirtual 1659	com/tencent/image/URLImageView:setVisibility	(I)V
    //   866: goto -328 -> 538
    //   869: aload_1
    //   870: bipush 8
    //   872: invokevirtual 1659	com/tencent/image/URLImageView:setVisibility	(I)V
    //   875: invokestatic 487	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   878: ifeq -306 -> 572
    //   881: ldc_w 489
    //   884: iconst_2
    //   885: ldc_w 1995
    //   888: invokestatic 499	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   891: goto -319 -> 572
    //   894: astore_2
    //   895: aload_1
    //   896: bipush 8
    //   898: invokevirtual 1659	com/tencent/image/URLImageView:setVisibility	(I)V
    //   901: invokestatic 487	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   904: ifeq -288 -> 616
    //   907: ldc_w 489
    //   910: iconst_2
    //   911: ldc_w 1997
    //   914: aload_2
    //   915: invokestatic 1332	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   918: goto -302 -> 616
    //   921: aload_1
    //   922: bipush 8
    //   924: invokevirtual 1659	com/tencent/image/URLImageView:setVisibility	(I)V
    //   927: invokestatic 487	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   930: ifeq -314 -> 616
    //   933: ldc_w 489
    //   936: iconst_2
    //   937: ldc_w 1999
    //   940: invokestatic 499	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   943: goto -327 -> 616
    //   946: invokestatic 487	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   949: ifeq -258 -> 691
    //   952: ldc_w 489
    //   955: iconst_2
    //   956: ldc_w 2001
    //   959: invokestatic 499	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   962: goto -271 -> 691
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	965	0	this	ShortVideoPlayActivity
    //   0	965	1	paramBundle	Bundle
    //   99	306	2	localObject	Object
    //   842	15	2	localException1	Exception
    //   894	21	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   522	538	842	java/lang/Exception
    //   600	616	894	java/lang/Exception
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "doOnDestroy");
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).isPlaying())) {
      this.jdField_c_of_type_Long = ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentPostion();
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
      label133:
      this.app.removeHandler(ShortVideoPlayActivity.class);
      if (this.jdField_e_of_type_Long >= 0L)
      {
        this.jdField_d_of_type_Long += System.currentTimeMillis() - this.jdField_e_of_type_Long;
        if (!this.jdField_f_of_type_Boolean)
        {
          new axtc(BaseApplication.getContext()).a(this.app, 2002, (int)(this.jdField_b_of_type_Long / 1000L), this.jdField_f_of_type_Int, this.jdField_j_of_type_JavaLangString, this.jdField_d_of_type_Long / 1000L);
          this.jdField_f_of_type_Boolean = true;
        }
      }
      if (this.jdField_h_of_type_Boolean) {
        new axtc(BaseApplication.getContext()).a(true, this.jdField_g_of_type_Int, this.jdField_k_of_type_Int / 100, this.jdField_l_of_type_Int / 100, (int)this.jdField_b_of_type_Long, (int)this.jdField_g_of_type_Long, 0, this.jdField_h_of_type_Int, this.jdField_j_of_type_Int, this.jdField_d_of_type_Long);
      }
      if (!this.jdField_j_of_type_Boolean)
      {
        t();
        a(true);
        B();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uiOperatorFlag == 2) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress != 100))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus = 2009;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.serial();
        this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.msgData);
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
        ShortVideoUtils.a(localQQAppInterface, i1, str, 2, 1, this.jdField_b_of_type_Long, this.jdField_w_of_type_Long);
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label133;
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
      this.jdField_c_of_type_Long = ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentPostion();
      this.jdField_k_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "pause mCurrentPosition:" + this.jdField_c_of_type_Long);
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
    x();
    if ((this.jdField_l_of_type_Boolean) || (this.jdField_o_of_type_Boolean))
    {
      if (!this.jdField_k_of_type_Boolean) {
        break label142;
      }
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (!((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).isPlaying()) && (!a())) {
        a(this.jdField_c_of_type_Long);
      }
    }
    label142:
    do
    {
      do
      {
        return;
      } while (Build.VERSION.SDK_INT < 10);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "onResume, restore last pause, mCurrentPosition=" + this.jdField_c_of_type_Long);
      }
      if (this.jdField_v_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoPlayActivity", 2, "onResume, restore last pause mSurfaceViewDestroyed=" + this.jdField_v_of_type_Boolean);
    return;
    if ((this.jdField_b_of_type_Int == 0) || (this.jdField_b_of_type_Int == 5)) {
      if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!bdhb.b(this.jdField_b_of_type_JavaLangString))) {}
    }
    for (;;)
    {
      try
      {
        MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
        localMediaMetadataRetriever.setDataSource(this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidGraphicsBitmap = localMediaMetadataRetriever.getFrameAtTime(this.jdField_c_of_type_Long * 1000L);
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
    if (bhtb.b()) {
      ((AudioManager)getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
    super.doOnStart();
  }
  
  public void doOnStop()
  {
    if (!this.jdField_o_of_type_Boolean) {
      this.jdField_l_of_type_Boolean = true;
    }
    if (bhtb.b()) {
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
      this.jdField_b_of_type_Long = ((int)l1);
      this.jdField_i_of_type_JavaLangString = ShortVideoUtils.a(this.jdField_b_of_type_Long);
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
      this.jdField_c_of_type_Long = ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentPostion();
      ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).pause();
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
      } while ((this.jdField_c_of_type_Long == 0L) || (!this.jdField_v_of_type_Boolean));
      a(this.jdField_c_of_type_Long);
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
  
  void m()
  {
    int i1 = 0;
    String str2 = getResources().getString(2131720149);
    String str3 = getResources().getString(2131720150);
    String str4 = getResources().getString(2131720107);
    String str5 = getResources().getString(2131720127);
    String str6 = getResources().getString(2131690648);
    String str1;
    boolean bool1;
    bhuf localbhuf;
    if (this.jdField_b_of_type_Int == 0)
    {
      str1 = ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
      bool1 = bdhb.a(str1);
      if (this.jdField_i_of_type_Boolean) {
        bool1 = false;
      }
      boolean bool2 = "1".equals(DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.shortvideo_forward_switch.name(), "1"));
      if (getIntent().getIntExtra("from_busi_type", 0) == 2) {
        i1 = 1;
      }
      localbhuf = bhuf.a(this);
      if ((bool2) && (this.jdField_e_of_type_Int != 9501) && (i1 == 0)) {
        localbhuf.c(str2);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus != 5001)) {
        localbhuf.c(str3);
      }
      if (this.jdField_b_of_type_Int != 3)
      {
        if (!bool1) {
          break label269;
        }
        localbhuf.c(str4);
        localbhuf.c(str5);
      }
    }
    for (;;)
    {
      localbhuf.d(str6);
      localbhuf.show();
      localbhuf.a(new akdk(this, localbhuf, str2, str1, str3, bool1, str4, str1, str5));
      return;
      str1 = this.jdField_b_of_type_JavaLangString;
      break;
      label269:
      localbhuf.a(str4, 7);
      localbhuf.a(str5, 7);
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
      if (!bdhb.b((String)localObject)) {}
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
    case 2131371460: 
    default: 
      return;
    case 2131373596: 
      s();
      return;
    case 2131364328: 
      this.app.a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      s();
      return;
    case 2131371461: 
      l();
      k();
      return;
    case 2131370187: 
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
    runOnUiThread(new ShortVideoPlayActivity.25(this, paramTVK_IMediaPlayer));
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (!this.jdField_w_of_type_Boolean) {
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      ((RelativeLayout)findViewById(2131367792)).setVisibility(8);
      return;
    }
    ((RelativeLayout)findViewById(2131367792)).setVisibility(0);
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onError what=" + paramInt1 + ",extra=" + paramInt2 + ",mCacheProgress=" + this.jdField_l_of_type_Int + ", mPlayProgress=" + this.jdField_k_of_type_Int + ", mCurPlayPosition=" + this.jdField_h_of_type_Long);
    }
    runOnUiThread(new ShortVideoPlayActivity.26(this, paramTVK_IMediaPlayer, paramInt1, paramInt2, paramInt3, paramString, paramObject));
    return false;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onInfo what=" + paramInt + ",extra=" + paramObject + ",mCacheProgress=" + this.jdField_l_of_type_Int + ", mPlayProgress=" + this.jdField_k_of_type_Int + ", mCurPlayPosition=" + this.jdField_h_of_type_Long);
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
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onNetVideoInfo what=" + paramTVK_NetVideoInfo.getErrInfo() + ",extra=" + paramTVK_NetVideoInfo.getState() + ",mCacheProgress=" + this.jdField_l_of_type_Int + ", mPlayProgress=" + this.jdField_k_of_type_Int + ", mCurPlayPosition=" + this.jdField_h_of_type_Long);
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
      this.jdField_c_of_type_Long = ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentPostion();
      this.jdField_k_of_type_Boolean = true;
    }
    paramBundle.putLong("state_play_position", this.jdField_c_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onSaveInstanceState: mCurrentPosition: " + this.jdField_c_of_type_Long);
    }
  }
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onSeekComplete mCacheProgress=" + this.jdField_l_of_type_Int + ", mPlayProgress=" + this.jdField_k_of_type_Int + ", mCurPlayPosition=" + this.jdField_h_of_type_Long);
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
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onVideoPrepared: mDuration=" + this.jdField_b_of_type_Long + " mInterrupted" + this.jdField_l_of_type_Boolean + " mNeedPlay" + this.jdField_k_of_type_Boolean);
    }
    this.jdField_v_of_type_Boolean = false;
    runOnUiThread(new ShortVideoPlayActivity.27(this));
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
    if (this.jdField_l_of_type_Boolean)
    {
      this.jdField_l_of_type_Boolean = false;
      if (this.jdField_k_of_type_Boolean) {}
    }
    do
    {
      return;
      this.jdField_k_of_type_Boolean = false;
      if (this.jdField_b_of_type_Long <= 0L) {
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
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onVideoPreparing mCacheProgress=" + this.jdField_l_of_type_Int + ", mPlayProgress=" + this.jdField_k_of_type_Int + ", mCurPlayPosition=" + this.jdField_h_of_type_Long);
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
    a(bdgm.a(this, 232, null, getString(2131720130), new akdl(this), new akdm(this)));
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
      overridePendingTransition(2130772036, 2130772038);
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
      localHashMap.put("FileSize", String.valueOf(this.jdField_g_of_type_Long));
      localStringBuffer.append(" FileSize" + this.jdField_g_of_type_Long);
      localHashMap.put("HttpDownloadSum", String.valueOf(this.jdField_n_of_type_Int));
      localStringBuffer.append(" HttpDownloadSum" + this.jdField_n_of_type_Int);
      if (this.jdField_p_of_type_Boolean) {
        break label1216;
      }
      localHashMap.put("DataFromCacheSize", String.valueOf(this.jdField_g_of_type_Long));
      localStringBuffer.append(" DataFromCacheSize" + this.jdField_g_of_type_Long);
      label277:
      localHashMap.put("FileDuration", String.valueOf(this.jdField_b_of_type_Long));
      localStringBuffer.append(" FileDuration" + this.jdField_b_of_type_Long);
      localHashMap.put("PlayTime", String.valueOf(this.jdField_i_of_type_Long));
      localStringBuffer.append(" PlayTime" + this.jdField_i_of_type_Long);
      localHashMap.put("PlayStateCount", String.valueOf(this.jdField_q_of_type_Int));
      localStringBuffer.append(" PlayStateCount" + this.jdField_q_of_type_Int);
      localHashMap.put("PlayProgress", String.valueOf(this.jdField_k_of_type_Int / 100));
      localStringBuffer.append(" PlayProgress" + this.jdField_k_of_type_Int / 100);
      localHashMap.put("FirstPlayTime", String.valueOf(this.jdField_l_of_type_Long));
      localStringBuffer.append(" FirstPlayTime" + this.jdField_l_of_type_Long);
      localHashMap.put("FirstBufferTime", String.valueOf(this.jdField_n_of_type_Long));
      localStringBuffer.append(" FirstBufferTime" + this.jdField_n_of_type_Long);
      localHashMap.put("SeekTimes", String.valueOf(this.jdField_i_of_type_Int));
      localStringBuffer.append(" SeekTimes" + this.jdField_i_of_type_Int);
      if (this.jdField_t_of_type_Int != 0) {
        break label1264;
      }
      i1 = this.jdField_t_of_type_Int;
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
      if (!bdnn.a(this.jdField_p_of_type_JavaLangString)) {
        str1 = bazo.a(this.jdField_p_of_type_JavaLangString);
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
        String str2 = bazo.a(this.jdField_a_of_type_ArrayOfJavaLangString[i1]);
        ((StringBuffer)localObject).append(str2 + ",");
        i3 = i2;
        if (i2 == -1)
        {
          i3 = i2;
          if (!bdnn.a(str1))
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
    String str1 = String.valueOf(bdin.a(BaseApplicationImpl.getApplication().getApplicationContext()));
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
        break label2264;
      }
      str1 = "1";
      label1994:
      localStringBuffer.append(str1);
      localHashMap.put("UpdateSuitCostTime", String.valueOf(this.jdField_s_of_type_Long));
      localStringBuffer.append(" UpdateSuitCostTime" + this.jdField_s_of_type_Long);
      if (!this.jdField_r_of_type_Boolean) {
        break label2271;
      }
      str1 = "1";
      label2067:
      localHashMap.put("UpdateSuitResult", str1);
      localObject = new StringBuilder().append(" UpdateSuitResult");
      if (!this.jdField_r_of_type_Boolean) {
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
      azri.a(BaseApplication.getContext()).a(null, "actStreamingVideoPlay", bool, this.jdField_q_of_type_Long, this.jdField_g_of_type_Long, localHashMap, "");
      this.jdField_s_of_type_Boolean = false;
      this.jdField_q_of_type_Int = 0;
      this.jdField_i_of_type_Int = 0;
      this.jdField_t_of_type_Int = 0;
      this.jdField_r_of_type_Int = 0;
      this.jdField_o_of_type_Long = 0L;
      this.jdField_q_of_type_Long = 0L;
      this.jdField_i_of_type_Long = 0L;
      this.A = 0;
      this.z = 0;
      this.jdField_l_of_type_Long = 0L;
      this.jdField_n_of_type_Long = 0L;
      this.jdField_u_of_type_Long = 0L;
      this.B = 0;
      this.jdField_y_of_type_Int = 0;
      this.jdField_s_of_type_Long = 0L;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity
 * JD-Core Version:    0.7.0.1
 */