package com.tencent.mobileqq.activity.richmedia;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaScannerConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.download.DownloadProgressListener;
import com.tencent.biz.qqstory.base.download.DownloaderImp;
import com.tencent.biz.qqstory.takevideo.music.QQStoryBGMusicUtils;
import com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.AudioPlayer.AudioPlayerListener;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base.P2VGlobalConfig;
import com.tencent.mobileqq.activity.richmedia.p2veffect.listener.IControllerPrepareListener;
import com.tencent.mobileqq.activity.richmedia.p2veffect.listener.IFastRenderCallback;
import com.tencent.mobileqq.activity.richmedia.p2veffect.main.P2VEffectConvertor;
import com.tencent.mobileqq.activity.richmedia.p2veffect.model.MediaItem;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.IP2VMusicEditListener;
import com.tencent.mobileqq.activity.richmedia.p2veffect.utils.P2VEffectLoader;
import com.tencent.mobileqq.activity.richmedia.view.DynamicVideoView;
import com.tencent.mobileqq.activity.richmedia.view.ExtendEditText;
import com.tencent.mobileqq.activity.richmedia.view.RotationSeekBar;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.text.QzoneTextBuilder;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.CircleProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ytcommon.util.YTCommonInterface;
import com.tribe.async.dispatch.IEventReceiver;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.font.FontInterface;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.P2VUtil;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import xzk;
import xzl;
import xzn;
import xzq;
import xzr;
import xzs;
import xzu;
import xzv;
import xzw;
import xzx;
import xzy;
import yaa;
import yab;
import yae;
import yaf;
import yag;

public class QzDynamicVideoPreviewActivity
  extends FlowActivity
  implements View.OnClickListener, IControllerPrepareListener, P2VEditMusicDialog.IP2VMusicEditListener, IEventReceiver
{
  public int a;
  private long jdField_a_of_type_Long;
  public Handler a;
  private PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private DownloaderImp jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp;
  private QQStoryMusicInfo jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo;
  private PressDarkImageButton jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private AudioPlayer.AudioPlayerListener jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener = new xzk(this);
  private AudioPlayer jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
  private IFastRenderCallback jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectListenerIFastRenderCallback = new xzn(this);
  private P2VEffectConvertor jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMainP2VEffectConvertor;
  private DynamicVideoView jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewDynamicVideoView;
  private ExtendEditText jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText;
  private RotationSeekBar jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewRotationSeekBar;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private CircleProgressView jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView;
  Runnable jdField_a_of_type_JavaLangRunnable = new xzx(this);
  public String a;
  public ArrayList a;
  public boolean a;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private PressDarkImageButton jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
  private Runnable jdField_b_of_type_JavaLangRunnable;
  public String b;
  public ArrayList b;
  int jdField_c_of_type_Int = 0;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public String c;
  private ArrayList jdField_c_of_type_JavaUtilArrayList;
  private int jdField_d_of_type_Int = 0;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  public String d;
  private ArrayList jdField_d_of_type_JavaUtilArrayList = new ArrayList();
  public boolean d;
  private int jdField_e_of_type_Int;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private String jdField_e_of_type_JavaLangString = a(1);
  private ArrayList jdField_e_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int = -1;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private String jdField_f_of_type_JavaLangString;
  private ArrayList jdField_f_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = -1;
  private String jdField_g_of_type_JavaLangString;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int = -1;
  private String jdField_h_of_type_JavaLangString;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int = -1;
  private String jdField_i_of_type_JavaLangString;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int = QzoneConfig.getInstance().getConfig("QZoneSetting", "makevideoMaxPicVideoCount", 30);
  private boolean jdField_k_of_type_Boolean;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  private boolean s;
  private boolean t;
  private boolean u;
  private boolean v;
  
  public QzDynamicVideoPreviewActivity()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidOsHandler = new xzw(this, Looper.getMainLooper());
  }
  
  private int a(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 16) || (paramInt == 128);
  }
  
  @SuppressLint({"DefaultLocale"})
  private static String b(long paramLong)
  {
    paramLong /= 1000L;
    return String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
  }
  
  private void b(String paramString)
  {
    if (this.jdField_b_of_type_JavaLangRunnable != null) {
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").removeTask(this.jdField_b_of_type_JavaLangRunnable);
    }
    this.jdField_d_of_type_JavaLangString = null;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo == null) {
      return;
    }
    long l1 = this.jdField_a_of_type_Long / 1000L;
    long l2 = (int)ShortVideoUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.jdField_g_of_type_JavaLangString) / 1000;
    this.jdField_b_of_type_JavaLangRunnable = new xzs(this, l1, paramString);
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(this.jdField_b_of_type_JavaLangRunnable);
  }
  
  private void b(String paramString1, String paramString2)
  {
    if (!this.m)
    {
      this.m = true;
      if (!this.v) {
        break label129;
      }
      paramString2 = new ArrayList();
      paramString2.add(paramString1);
      paramString1 = new Intent(getIntent());
      paramString1.putExtra("PhotoConst.PHOTO_PATHS", paramString2);
      paramString1.putExtra("param.duration", this.jdField_a_of_type_Long);
      paramString1.putExtra("param.videoHeight", 1280);
      paramString1.putExtra("param.videoWidth", 720);
      paramString1.setFlags(536870912);
      paramString1.putExtra("PhotoConst.IS_MAKE_VIDEO", true);
      QZoneHelper.a(this, "", paramString1, -1);
    }
    for (;;)
    {
      finish();
      return;
      QLog.w("QzDynamicVideoPreviewActivity", 2, "requestPublish duplicate");
      return;
      label129:
      a(paramString1, paramString2);
    }
  }
  
  private void c(String paramString)
  {
    xzu localxzu = new xzu(this);
    MediaScannerConnection.scanFile(this, new String[] { paramString }, null, localxzu);
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.u) {
      if ((!paramBoolean) || (this.jdField_i_of_type_JavaLangString == null) || (this.jdField_i_of_type_JavaLangString.contains(P2VGlobalConfig.P2V_VIDEO_ROOT))) {
        break label98;
      }
    }
    for (this.u = false; (this.u) && (this.jdField_i_of_type_JavaLangString != null); this.u = false)
    {
      label36:
      Message localMessage = new Message();
      Bundle localBundle = new Bundle();
      localBundle.putString("keySucceedGeneratePath", this.jdField_i_of_type_JavaLangString);
      localMessage.what = 30;
      localMessage.setData(localBundle);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
      label98:
      if ((paramBoolean) || (this.jdField_i_of_type_JavaLangString == null) || (this.jdField_i_of_type_JavaLangString.contains(P2VGlobalConfig.P2V_VIDEO_CACHE_ROOT))) {
        break label36;
      }
    }
    v();
    this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire();
    this.jdField_h_of_type_JavaLangString = new File(P2VGlobalConfig.NO_AUDIO_MP4).getPath();
    this.jdField_j_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMainP2VEffectConvertor.setWaterMarkerEnable(this.jdField_j_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMainP2VEffectConvertor.save(this.jdField_h_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectListenerIFastRenderCallback);
  }
  
  private void m()
  {
    ArrayList localArrayList = new ArrayList();
    int i2;
    if ((this.jdField_c_of_type_JavaUtilArrayList != null) && (this.jdField_c_of_type_JavaUtilArrayList.size() > 0))
    {
      int i1 = 0;
      i2 = 0;
      while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
      {
        String str = (String)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
        if (!new File(str).exists())
        {
          localArrayList.add(str);
          i2 = 1;
        }
        i1 += 1;
      }
      this.jdField_c_of_type_JavaUtilArrayList.removeAll(localArrayList);
      if (this.jdField_c_of_type_JavaUtilArrayList.size() == 0)
      {
        QQToast.a(this, getString(2131432961), 0).a();
        finish();
      }
    }
    else
    {
      return;
    }
    if (i2 != 0) {
      QQToast.a(this, getString(2131432960), 0).a();
    }
    this.jdField_g_of_type_Boolean = true;
  }
  
  private void n()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, PhotoListActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", getClass().getName());
    localIntent.putExtra("from_tribe_class_name", getClass().getSimpleName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", this.jdField_k_of_type_Int);
    localIntent.putExtra("album_enter_directly", true);
    localIntent.putExtra("ALBUM_ID", "$RecentAlbumId");
    localIntent.putExtra("ALBUM_NAME", "最近照片");
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 3);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", P2VGlobalConfig.VIDEO_CAN_UPLOAD_LIMIT_MS);
    localIntent.putExtra("PhotoConst.QZONE_COVER_PHOTOLIST_KEY_VIDEO_DURATION", P2VGlobalConfig.VIDEO_CAN_UPLOAD_LIMIT_MS);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_VIDEO_DURATION_LIMIT", P2VGlobalConfig.VIDEO_CAN_UPLOAD_LIMIT_MS);
    localIntent.putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    startActivityForResult(localIntent, 0);
    AlbumUtil.a(this, false, true);
  }
  
  private void o()
  {
    QzoneModuleManager.getInstance().downloadModule("cyber_clink.jar", new yab(this));
  }
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewDynamicVideoView = ((DynamicVideoView)a(2131372768));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131371704));
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton = ((PressDarkImageButton)a(2131372778));
    this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton = ((PressDarkImageButton)a(2131372779));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131364477));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131372092));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewRotationSeekBar = ((RotationSeekBar)a(2131372772));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewRotationSeekBar.setMax(100);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)a(2131372770));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)a(2131372771));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)a(2131372773));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131373556));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131372781));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)a(2131372780));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131372774));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131372777));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131372775));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)a(2131372776));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131372769));
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230, "放弃制作照片视频？", null, "放弃", "取消", new yae(this), new yaf(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void r()
  {
    finish();
  }
  
  private void s()
  {
    this.jdField_j_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMainP2VEffectConvertor.setWaterMarkerEnable(this.jdField_j_of_type_Boolean);
    w();
    QLog.d("QzDynamicVideoPreviewActivity", 2, "cancel genera dynamic Video");
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMainP2VEffectConvertor.cancelSave(new xzl(this));
    if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld()) {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
    }
    LpReportInfo_pf00064.allReport(680, 1, 2, true);
  }
  
  private void t()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  private void u()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) && (!this.v)) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
  }
  
  private void v()
  {
    if (this.p)
    {
      QLog.d("QzDynamicVideoPreviewActivity", 2, "GeneratingTips is showing, don't show again.");
      return;
    }
    this.p = true;
    a(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText("0%");
    LpReportInfo_pf00064.allReport(680, 1, 1, true);
  }
  
  private void w()
  {
    if (!this.p)
    {
      QLog.d("QzDynamicVideoPreviewActivity", 2, "GeneratingTips is not showing, don't stopP2VRec again.");
      return;
    }
    this.p = false;
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText("0%");
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  private void x()
  {
    Typeface localTypeface = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setTextEffect(this.jdField_g_of_type_JavaLangString);
    String str = FontInterface.a(this.jdField_f_of_type_Int, null, null, null);
    if (TextUtils.isEmpty(str)) {
      this.jdField_f_of_type_Int = -1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setTypeface(localTypeface);
      return;
      localTypeface = Typeface.createFromFile(str);
    }
  }
  
  public QQStoryMusicInfo a()
  {
    QLog.d("QzDynamicVideoPreviewActivity", 2, "getCurFragmentMusic");
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo;
  }
  
  public QQStoryMusicInfo a(ArrayList paramArrayList)
  {
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      String str1 = (String)paramArrayList.get(i1);
      if (!TextUtils.isEmpty(str1))
      {
        String str2 = QQStoryBGMusicUtils.a(str1);
        if (FileUtils.a(str2))
        {
          paramArrayList = new QQStoryMusicInfo();
          paramArrayList.jdField_b_of_type_JavaLangString = ((String)this.jdField_e_of_type_JavaUtilArrayList.get(i1));
          paramArrayList.jdField_d_of_type_JavaLangString = str1;
          paramArrayList.jdField_b_of_type_Int = 2;
          paramArrayList.jdField_g_of_type_JavaLangString = str2;
          paramArrayList.jdField_a_of_type_JavaLangString = ((String)this.jdField_f_of_type_JavaUtilArrayList.get(i1));
          paramArrayList.jdField_f_of_type_Int = ((int)ShortVideoUtils.a(str2));
          QLog.d("QzDynamicVideoPreviewActivity", 2, "getLocalMusic - downloadDefaultMusic exists audio_url = " + str1 + ", path = " + str2);
          return paramArrayList;
        }
      }
      i1 += 1;
    }
    return null;
  }
  
  public String a(int paramInt)
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
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 794	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 800	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: astore_2
    //   7: aload_2
    //   8: new 766	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 767	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 802
    //   18: invokevirtual 773	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 773	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 778	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 808	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   31: aconst_null
    //   32: ldc_w 810
    //   35: iconst_1
    //   36: anewarray 259	java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: aload_1
    //   42: aastore
    //   43: aconst_null
    //   44: invokevirtual 816	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +214 -> 263
    //   52: aload_1
    //   53: invokeinterface 821 1 0
    //   58: ifeq +205 -> 263
    //   61: aload_1
    //   62: aload_1
    //   63: ldc_w 823
    //   66: invokeinterface 827 2 0
    //   71: invokeinterface 828 2 0
    //   76: astore_2
    //   77: aload_2
    //   78: invokestatic 731	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   81: ifne +176 -> 257
    //   84: new 259	java/lang/String
    //   87: dup
    //   88: aload_2
    //   89: invokevirtual 832	java/lang/String:getBytes	()[B
    //   92: ldc_w 834
    //   95: invokespecial 837	java/lang/String:<init>	([BLjava/lang/String;)V
    //   98: invokestatic 841	com/tencent/mobileqq/utils/SecurityUtile:b	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore_2
    //   102: invokestatic 844	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq +30 -> 135
    //   108: ldc_w 361
    //   111: iconst_2
    //   112: new 766	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 767	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 846
    //   122: invokevirtual 773	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_2
    //   126: invokevirtual 773	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 778	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 848	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: aload_2
    //   136: astore_3
    //   137: aload_1
    //   138: ifnull +11 -> 149
    //   141: aload_1
    //   142: invokeinterface 851 1 0
    //   147: aload_2
    //   148: astore_3
    //   149: aload_3
    //   150: areturn
    //   151: astore_3
    //   152: aconst_null
    //   153: astore_2
    //   154: ldc 81
    //   156: astore_1
    //   157: invokestatic 844	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +33 -> 193
    //   163: ldc_w 361
    //   166: iconst_2
    //   167: new 766	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 767	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 853
    //   177: invokevirtual 773	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_3
    //   181: invokestatic 857	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   184: invokevirtual 773	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 778	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 859	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: aload_1
    //   194: astore_3
    //   195: aload_2
    //   196: ifnull -47 -> 149
    //   199: aload_2
    //   200: invokeinterface 851 1 0
    //   205: aload_1
    //   206: areturn
    //   207: astore_2
    //   208: aconst_null
    //   209: astore_1
    //   210: aload_1
    //   211: ifnull +9 -> 220
    //   214: aload_1
    //   215: invokeinterface 851 1 0
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
    //   237: ldc 81
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
    //   257: ldc 81
    //   259: astore_2
    //   260: goto -158 -> 102
    //   263: ldc 81
    //   265: astore_2
    //   266: goto -131 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	QzDynamicVideoPreviewActivity
    //   0	269	1	paramString	String
    //   6	194	2	localObject1	Object
    //   207	14	2	localObject2	Object
    //   222	6	2	localObject3	Object
    //   230	36	2	localObject4	Object
    //   136	14	3	localObject5	Object
    //   151	30	3	localException1	java.lang.Exception
    //   194	1	3	str	String
    //   226	4	3	localObject6	Object
    //   234	1	3	localException2	java.lang.Exception
    //   246	8	3	localObject7	Object
    //   243	9	4	localException3	java.lang.Exception
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
  
  public ArrayList a()
  {
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    if (this.jdField_k_of_type_Boolean) {
      QLog.w("QzDynamicVideoPreviewActivity", 2, "sorry, you can't prepare before the last prepare finish.");
    }
    do
    {
      return;
      c();
      this.jdField_a_of_type_Long = 0L;
    } while ((this.jdField_c_of_type_JavaUtilArrayList == null) || (this.jdField_c_of_type_JavaUtilArrayList.size() <= 0));
    if (this.jdField_c_of_type_JavaUtilArrayList.size() < 5) {}
    ArrayList localArrayList;
    for (long l1 = 3000L;; l1 = 1500L)
    {
      localArrayList = new ArrayList();
      int i3 = this.jdField_c_of_type_JavaUtilArrayList.size();
      int i1 = 0;
      Object localObject;
      if (i1 < i3)
      {
        localObject = (String)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
        boolean bool = a((String)localObject);
        long l2;
        if (bool)
        {
          l2 = ShortVideoUtils.b((String)localObject);
          label119:
          if (!bool) {
            break label172;
          }
        }
        label172:
        for (int i2 = 1;; i2 = 2)
        {
          localArrayList.add(new MediaItem((String)localObject, i2, 0L, l2));
          this.jdField_a_of_type_Long += l2;
          i1 += 1;
          break;
          l2 = l1;
          break label119;
        }
      }
      try
      {
        localObject = BitmapFactory.decodeFile(P2VGlobalConfig.P2V_MATERIAL_WATER_MARKER_PNG_NAME);
        if (localObject != null)
        {
          QLog.d("QzDynamicVideoPreviewActivity", 2, "p2VEffectConvertor.setWaterMarkerBitmap(bitmap)");
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMainP2VEffectConvertor.setWaterMarkerBitmap((Bitmap)localObject);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          double d1;
          String str1;
          String str2;
          QQStoryMusicInfo localQQStoryMusicInfo;
          QLog.e("QzDynamicVideoPreviewActivity", 2, "p2VEffectConvertor.setWaterMarkerBitmap(bitmap) - OutOfMemoryError");
          localOutOfMemoryError.printStackTrace();
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("QzDynamicVideoPreviewActivity", 2, "onCmdRespond data is NULL!!!!!");
        this.r = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMainP2VEffectConvertor.setMediaItems(localArrayList);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMainP2VEffectConvertor.resetVideoIndex();
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMainP2VEffectConvertor.prepare();
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo == null)
      {
        this.t = false;
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new xzq(this, localArrayList), 5000L);
        i1 = this.jdField_d_of_type_JavaUtilArrayList.size();
        d1 = Math.random();
        i1 = (int)((i1 - 1) * d1);
        localObject = (String)this.jdField_d_of_type_JavaUtilArrayList.get(i1);
        str1 = (String)this.jdField_e_of_type_JavaUtilArrayList.get(i1);
        str2 = (String)this.jdField_f_of_type_JavaUtilArrayList.get(i1);
        localQQStoryMusicInfo = new QQStoryMusicInfo();
        localQQStoryMusicInfo.jdField_b_of_type_JavaLangString = str1;
        localQQStoryMusicInfo.jdField_d_of_type_JavaLangString = ((String)localObject);
        localQQStoryMusicInfo.jdField_b_of_type_Int = 2;
        localQQStoryMusicInfo.jdField_a_of_type_JavaLangString = str2;
        a(localQQStoryMusicInfo);
        if ((localQQStoryMusicInfo.jdField_d_of_type_JavaLangString == null) || (!TextUtils.isEmpty(localQQStoryMusicInfo.jdField_g_of_type_JavaLangString))) {
          break;
        }
        a(localQQStoryMusicInfo.jdField_d_of_type_JavaLangString, new xzr(this, localArrayList));
        return;
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_d_of_type_Int = 2;
    this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130844441);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMainP2VEffectConvertor.startPlay(this.jdField_e_of_type_Boolean);
    this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire();
    if ((paramInt == 20) && (this.r))
    {
      a(-1, true);
      this.r = false;
    }
    while (paramInt != 1) {
      return;
    }
    g();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    QLog.d("QzDynamicVideoPreviewActivity", 2, "playBgMusic()" + paramInt);
    if ((!this.jdField_i_of_type_Boolean) || (this.q))
    {
      QLog.d("QzDynamicVideoPreviewActivity", 2, "playBgMusic ignore");
      return;
    }
    QQStoryMusicInfo localQQStoryMusicInfo = a();
    if ((localQQStoryMusicInfo == null) || (TextUtils.isEmpty(localQQStoryMusicInfo.jdField_g_of_type_JavaLangString)))
    {
      if (localQQStoryMusicInfo == null) {}
      for (String str = null;; str = localQQStoryMusicInfo.jdField_g_of_type_JavaLangString)
      {
        QLog.d("QzDynamicVideoPreviewActivity", 2, new Object[] { "playBgMusic music=%s, path=%s", localQQStoryMusicInfo, str });
        return;
      }
    }
    i();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(3);
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.jdField_f_of_type_Int < this.jdField_a_of_type_Long)) {
      this.jdField_j_of_type_Int = ((int)(this.jdField_a_of_type_Long / this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.jdField_f_of_type_Int));
    }
    if (paramInt >= 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(localQQStoryMusicInfo.jdField_g_of_type_JavaLangString, paramInt);
    }
    for (;;)
    {
      sendBroadcast(new Intent("action_music_start"));
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(localQQStoryMusicInfo.jdField_g_of_type_JavaLangString, localQQStoryMusicInfo.jdField_d_of_type_Int);
    }
  }
  
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_Boolean = CaptureUtil.c();
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.e("QzDynamicVideoPreviewActivity", 2, "CaptureUtil.loadP2VEffectSo() failed, Build.MODEL:" + Build.MODEL);
      P2VUtil.a().a(true);
      QQToast.a(this, getString(2131432963), 0).a();
      finish();
      return;
    }
    for (;;)
    {
      try
      {
        YTCommonInterface.initAuth(SdkContext.a().a(), "youtusdk_mqq.licence", 0, true);
        P2VEffectLoader.a().a(P2VEffectConvertor.class.getClassLoader());
        P2VEffectLoader.a().a(P2VGlobalConfig.P2V_MATERIAL_ROOT);
        if (getIntent().getBooleanExtra("param.JumpPhotoList", false))
        {
          n();
          if ((this.jdField_d_of_type_JavaUtilArrayList != null) && (this.jdField_d_of_type_JavaUtilArrayList.size() <= 0))
          {
            this.jdField_d_of_type_JavaUtilArrayList.add("http://dl.stream.qqmusic.qq.com/C100002PzIKz2xBTvu.m4a?fromtag=1");
            this.jdField_d_of_type_JavaUtilArrayList.add("http://dl.stream.qqmusic.qq.com/C100001IsOUk1Z0D16.m4a?fromtag=1");
            this.jdField_d_of_type_JavaUtilArrayList.add("http://dl.stream.qqmusic.qq.com/C100002xUbdh1WNIlH.m4a?fromtag=1");
            this.jdField_d_of_type_JavaUtilArrayList.add("http://dl.stream.qqmusic.qq.com/C100004eoXLb0lKq6P.m4a?fromtag=1");
            this.jdField_d_of_type_JavaUtilArrayList.add("http://dl.stream.qqmusic.qq.com/C100002XecyN1bmIBb.m4a?fromtag=1");
          }
          if ((this.jdField_e_of_type_JavaUtilArrayList != null) && (this.jdField_e_of_type_JavaUtilArrayList.size() <= 0))
          {
            this.jdField_e_of_type_JavaUtilArrayList.add("I Hope You Find Peace");
            this.jdField_e_of_type_JavaUtilArrayList.add("Having Lived");
            this.jdField_e_of_type_JavaUtilArrayList.add("Golden Skies");
            this.jdField_e_of_type_JavaUtilArrayList.add("Bygone Bumps");
            this.jdField_e_of_type_JavaUtilArrayList.add("春を知らせるもの");
          }
          if ((this.jdField_f_of_type_JavaUtilArrayList == null) || (this.jdField_f_of_type_JavaUtilArrayList.size() > 0)) {
            break;
          }
          this.jdField_f_of_type_JavaUtilArrayList.add("103091927");
          this.jdField_f_of_type_JavaUtilArrayList.add("202468810");
          this.jdField_f_of_type_JavaUtilArrayList.add("108805100");
          this.jdField_f_of_type_JavaUtilArrayList.add("201401670");
          this.jdField_f_of_type_JavaUtilArrayList.add("1799404");
          return;
        }
      }
      catch (UnsatisfiedLinkError paramBundle)
      {
        QLog.e("QzDynamicVideoPreviewActivity", 2, "YTCommonInterface.initAuth get an UnsatisfiedLinkError");
        P2VUtil.a().a(true);
        QQToast.a(this, getString(2131432963), 0).a();
        finish();
        return;
      }
      m();
    }
  }
  
  protected void a(ViewGroup paramViewGroup)
  {
    QLog.d("QzDynamicVideoPreviewActivity", 2, "onCreateView start");
    this.jdField_b_of_type_AndroidViewViewGroup = paramViewGroup;
    getLayoutInflater().inflate(2130971072, paramViewGroup);
    p();
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20180130195753_CLvDhicQgS.png", null));
    if (!this.v) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    for (;;)
    {
      Object localObject = new View(this);
      ((View)localObject).setBackgroundColor(Color.argb(128, 0, 0, 0));
      ((View)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      ((View)localObject).setVisibility(8);
      paramViewGroup.addView((View)localObject);
      this.jdField_a_of_type_AndroidViewView = ((View)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText = ((ExtendEditText)a(2131373557));
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setEditableFactory(QzoneTextBuilder.b);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131373558));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = a(2131373560);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(100);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView = new CircleProgressView(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.setVisibility(8);
      localObject = new RelativeLayout.LayoutParams(a(60.0F), a(60.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      paramViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView, (ViewGroup.LayoutParams)localObject);
      int i1 = (int)(ViewUtils.a() * 1.777778F);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewDynamicVideoView.getLayoutParams().height = i1;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewDynamicVideoView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height = i1;
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMainP2VEffectConvertor = new P2VEffectConvertor(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewDynamicVideoView.a(), this);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMainP2VEffectConvertor.addPlayerCallback(new xzy(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMainP2VEffectConvertor.setFilterProvider(new yaa(this));
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131432453);
    }
  }
  
  public void a(QQStoryMusicInfo paramQQStoryMusicInfo)
  {
    QLog.d("QzDynamicVideoPreviewActivity", 2, "setCurFragmentMusic:" + paramQQStoryMusicInfo);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.equals(paramQQStoryMusicInfo))) {}
    for (this.u = false;; this.u = false) {
      do
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo = paramQQStoryMusicInfo;
        return;
      } while ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo != null) || (paramQQStoryMusicInfo == null));
    }
  }
  
  public void a(String paramString)
  {
    QLog.d("QzDynamicVideoPreviewActivity", 2, "setCurFragmentMusicPath:" + paramString);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.jdField_g_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.jdField_f_of_type_Int = ((int)ShortVideoUtils.a(paramString));
      return;
    }
    QLog.e("QzDynamicVideoPreviewActivity", 2, "setCurFragmentMusicPath failed, curMusic is null");
  }
  
  protected void a(String paramString, DownloadProgressListener paramDownloadProgressListener)
  {
    String str;
    if (!TextUtils.isEmpty(paramString))
    {
      str = QQStoryBGMusicUtils.a(paramString);
      if (FileUtils.a(str))
      {
        QLog.d("QzDynamicVideoPreviewActivity", 2, "downloadDefaultMusic exists audio_url = " + paramString + ", path = " + str);
        paramDownloadProgressListener.a(paramString, 0);
      }
    }
    else
    {
      return;
    }
    if (!NetworkUtil.g(BaseApplication.getContext()))
    {
      QQToast.a(BaseApplication.getContext(), 2131430035, 0).a();
      paramDownloadProgressListener.a(paramString, 102);
      return;
    }
    ThreadManager.post(new xzv(this, paramDownloadProgressListener, paramString, str), 5, null, true);
  }
  
  public void a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.content", paramString2);
    localBundle.putInt("param.priv", this.jdField_a_of_type_Int);
    localBundle.putStringArrayList("param.privList", this.jdField_a_of_type_JavaUtilArrayList);
    localBundle.putString("param.videoPath", paramString1);
    localBundle.putLong("param.videoSize", 0L);
    localBundle.putInt("param.videoType", 1);
    localBundle.putBoolean("param.needProcess", false);
    localBundle.putBoolean("param.isUploadOrigin", true);
    localBundle.putLong("param.startTime", 0L);
    localBundle.putLong("param.duration", this.jdField_a_of_type_Long);
    localBundle.putLong("param.totalDuration", this.jdField_a_of_type_Long);
    localBundle.putBoolean("param.needProcess", false);
    localBundle.putString("param.source", "");
    localBundle.putInt("param.uploadEntrance", this.jdField_e_of_type_Int);
    localBundle.putBoolean("param.isUploadCover", true);
    if (this.jdField_f_of_type_Int >= 0)
    {
      localBundle.putInt("extra_key_font_id", this.jdField_f_of_type_Int);
      localBundle.putInt("extra_key_font_format_type", this.jdField_g_of_type_Int);
      localBundle.putString("extra_key_font_url", this.jdField_f_of_type_JavaLangString);
    }
    if (this.jdField_h_of_type_Int >= 0)
    {
      localBundle.putInt("extra_key_super_font_id", this.jdField_h_of_type_Int);
      localBundle.putString("extra_key_super_font_info", this.jdField_g_of_type_JavaLangString);
    }
    RemoteHandleManager.a().a("cmd.publishVideoMood", localBundle, false);
  }
  
  public void a(ArrayList paramArrayList)
  {
    QLog.d("QzDynamicVideoPreviewActivity", 2, "setDefaultMusicList:");
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  void a(boolean paramBoolean)
  {
    if (2 == this.jdField_d_of_type_Int)
    {
      this.jdField_d_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMainP2VEffectConvertor.pausePlay();
      h();
      if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld()) {
        this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
      }
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130844440);
      }
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public boolean a(String paramString)
  {
    return FileManagerUtil.a(paramString) == 2;
  }
  
  public boolean a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayList1 == null) && (paramArrayList2 == null)) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramArrayList1 == null);
        bool1 = bool2;
      } while (paramArrayList2 == null);
      bool1 = bool2;
    } while (paramArrayList1.size() != paramArrayList2.size());
    int i1 = 0;
    for (;;)
    {
      if (i1 >= paramArrayList1.size()) {
        break label88;
      }
      bool1 = bool2;
      if (!((String)paramArrayList1.get(i1)).equals(paramArrayList2.get(i1))) {
        break;
      }
      i1 += 1;
    }
    label88:
    return true;
  }
  
  void b()
  {
    this.jdField_d_of_type_Int = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMainP2VEffectConvertor != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMainP2VEffectConvertor.stopPlay();
    }
    if ((this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null) && (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld())) {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
    }
  }
  
  public void b(int paramInt)
  {
    QLog.d("QzDynamicVideoPreviewActivity", 2, "setMusicBtnType:" + paramInt);
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton != null)
    {
      if (paramInt == 0) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setImageResource(2130843658);
      }
    }
    else {
      return;
    }
    if (3 == paramInt)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setImageResource(2130843657);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setImageResource(2130843651);
  }
  
  public void b(boolean paramBoolean)
  {
    QLog.d("QzDynamicVideoPreviewActivity", 2, "setPickMusicPlayEmpty");
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    StringBuilder localStringBuilder = new StringBuilder().append("needRequestMusicList:");
    if ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_JavaUtilArrayList.isEmpty())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.d("QzDynamicVideoPreviewActivity", 2, bool1);
      if (this.jdField_b_of_type_JavaUtilArrayList != null)
      {
        bool1 = bool2;
        if (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty()) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  public void c()
  {
    this.jdField_k_of_type_Boolean = true;
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.setIndeterminate(true, 120, 6);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.a();
    }
  }
  
  public boolean c()
  {
    QLog.d("QzDynamicVideoPreviewActivity", 2, "getPickMusicPlayEmpty");
    return this.jdField_d_of_type_Boolean;
  }
  
  public void d()
  {
    this.jdField_k_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.a())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.c();
    }
  }
  
  public void e()
  {
    a(true);
  }
  
  public void f()
  {
    this.jdField_e_of_type_JavaLangString = a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_e_of_type_JavaLangString);
  }
  
  public void g()
  {
    a(this.jdField_c_of_type_Int, false);
  }
  
  public void h()
  {
    QLog.d("QzDynamicVideoPreviewActivity", 2, "pauseClipMusic");
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a()))
      {
        this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
        if (QLog.isColorLevel()) {
          QLog.d("QzDynamicVideoPreviewActivity", 2, "pauseClipMusic()");
        }
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      QLog.e("QzDynamicVideoPreviewActivity", 2, "pauseClipMusic get an IllegalStateException");
    }
  }
  
  public void i()
  {
    QLog.d("QzDynamicVideoPreviewActivity", 2, "stopClipMusic");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = null;
    }
    this.jdField_j_of_type_Int = 0;
  }
  
  public boolean isValidate()
  {
    return this.l;
  }
  
  public void j()
  {
    QLog.d("QzDynamicVideoPreviewActivity", 2, "rePlay video and music");
    this.r = true;
    d();
    b();
    a();
  }
  
  public void k()
  {
    QLog.d("QzDynamicVideoPreviewActivity", 2, "stopPlayer");
    e();
  }
  
  public void l()
  {
    a(-1, false);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10) {
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getExtras();
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getStringArrayList("keyDynamicSrc");
          if (!a(paramIntent, this.jdField_c_of_type_JavaUtilArrayList))
          {
            this.u = false;
            this.jdField_c_of_type_JavaUtilArrayList = paramIntent;
          }
          j();
        }
      }
    }
    label532:
    do
    {
      Object localObject;
      do
      {
        do
        {
          return;
          if (paramInt1 != 1) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QzDynamicVideoPreviewActivity", 2, "onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
          }
        } while (paramIntent == null);
        paramIntent = paramIntent.getExtras();
        if (paramIntent.containsKey("permission_code")) {
          this.jdField_a_of_type_Int = paramIntent.getInt("permission_code");
        }
        if (paramIntent.containsKey("uin_list"))
        {
          if (this.jdField_a_of_type_JavaUtilArrayList == null) {
            this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          }
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          localObject = paramIntent.getStringArrayList("uin_list");
          if (localObject != null) {
            this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
          }
        }
        if (a(this.jdField_a_of_type_Int))
        {
          this.jdField_b_of_type_JavaLangString = paramIntent.getString("key_setting_raw_json");
          this.jdField_a_of_type_JavaLangString = paramIntent.getString("key_selected_tag");
        }
        f();
        return;
        if (paramInt1 != 1009) {
          break;
        }
        if (this.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
      } while (paramIntent == null);
      Bundle localBundle = paramIntent.getExtras();
      if (localBundle.containsKey("extra_key_bundle_priv_key"))
      {
        paramIntent = localBundle.getBundle("extra_key_bundle_priv_key");
        if (paramIntent != null)
        {
          paramInt1 = paramIntent.getInt("permission_code");
          if (this.jdField_a_of_type_Int != paramInt1) {
            break label532;
          }
          LpReportInfo_pf00064.allReport(680, 5, 3, true);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Int = paramInt1;
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        localObject = paramIntent.getStringArrayList("uin_list");
        if (localObject != null) {
          this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
        }
        if (a(this.jdField_a_of_type_Int))
        {
          this.jdField_b_of_type_JavaLangString = paramIntent.getString("key_setting_raw_json");
          this.jdField_a_of_type_JavaLangString = paramIntent.getString("key_selected_tag");
        }
        f();
        if (localBundle.containsKey("contentIntentKey"))
        {
          localObject = localBundle.getString("contentIntentKey");
          paramIntent = (Intent)localObject;
          if (localObject == null) {
            paramIntent = "";
          }
          this.jdField_c_of_type_JavaLangString = paramIntent;
        }
        if (localBundle.containsKey("contentIntentKeyForVideoEditWithEmo"))
        {
          paramIntent = localBundle.getString("contentIntentKeyForVideoEditWithEmo");
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setText(paramIntent);
        }
        this.jdField_f_of_type_Int = localBundle.getInt("extra_key_font_id", -1);
        this.jdField_g_of_type_Int = localBundle.getInt("extra_key_font_format_type");
        this.jdField_f_of_type_JavaLangString = localBundle.getString("extra_key_font_url");
        this.jdField_h_of_type_Int = localBundle.getInt("extra_key_super_font_id", -1);
        this.jdField_g_of_type_JavaLangString = localBundle.getString("extra_key_super_font_info");
        x();
        return;
        LpReportInfo_pf00064.allReport(680, 5, 2, true);
      }
    } while (paramInt1 != 11);
    j();
  }
  
  public void onBackPressed()
  {
    this.jdField_h_of_type_Boolean = true;
    q();
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    Iterator localIterator;
    switch (paramView.getId())
    {
    default: 
    case 2131372768: 
    case 2131372770: 
      do
      {
        return;
      } while (this.p);
      switch (this.jdField_d_of_type_Int)
      {
      default: 
        return;
      case 0: 
        a();
        return;
      case 1: 
        a(1);
        return;
      }
      e();
      return;
    case 2131372778: 
      if (this.jdField_k_of_type_Boolean)
      {
        QQToast.a(this, getString(2131432956), 0).a();
        return;
      }
      if (this.p)
      {
        QQToast.a(this, getString(2131432955), 0).a();
        return;
      }
      t();
      paramView = new P2VEditMusicDialog(this, this, (int)this.jdField_a_of_type_Long, true);
      paramView.setCanceledOnTouchOutside(true);
      paramView.setOnDismissListener(new yag(this));
      paramView.setCancelable(true);
      paramView.show();
      LpReportInfo_pf00064.allReport(680, 2, 1, true);
      LpReportInfo_pf00064.allReport(680, 3, 1, true);
      return;
    case 2131372779: 
      if (this.p)
      {
        QQToast.a(this, getString(2131432955), 0).a();
        return;
      }
      paramView = QZoneHelper.UserInfo.a();
      localObject1 = new Bundle();
      ((Bundle)localObject1).putStringArrayList("keyDynamicSrc", this.jdField_c_of_type_JavaUtilArrayList);
      QZoneHelper.d(this, paramView, (Bundle)localObject1, 10);
      LpReportInfo_pf00064.allReport(680, 2, 2, true);
      return;
    case 2131372781: 
      if (this.p)
      {
        QQToast.a(this, getString(2131432955), 0).a();
        return;
      }
      this.jdField_i_of_type_Int = 1;
      LpReportInfo_pf00064.allReport(680, 2, 6, true);
      c(true);
      return;
    case 2131372780: 
      if (this.p)
      {
        QQToast.a(this, getString(2131432955), 0).a();
        return;
      }
      this.jdField_i_of_type_Int = 3;
      LpReportInfo_pf00064.allReport(680, 2, 5, true);
      c(false);
      return;
    case 2131371704: 
      if (this.p) {
        s();
      }
      this.jdField_h_of_type_Boolean = false;
      q();
      return;
    case 2131364477: 
      if (this.p)
      {
        QQToast.a(this, getString(2131432955), 0).a();
        return;
      }
      this.jdField_i_of_type_Int = 2;
      LpReportInfo_pf00064.allReport(680, 2, 7, true);
      c(false);
      return;
    case 2131373557: 
      if (this.p)
      {
        QQToast.a(this, getString(2131432955), 0).a();
        return;
      }
      this.n = true;
      this.o = true;
      this.jdField_c_of_type_Boolean = true;
      localObject1 = QZoneHelper.UserInfo.a();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("permission_code", this.jdField_a_of_type_Int);
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
      if ((a(this.jdField_a_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
        ((Bundle)localObject2).putString("key_setting_raw_json", this.jdField_b_of_type_JavaLangString);
      }
      ((Bundle)localObject2).putBoolean("is_need_auto_close_from_pri", true);
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = new View(this);
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.argb(128, 0, 0, 0));
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        ((RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup).addView(this.jdField_a_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramView = "";
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText != null) {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.getText().toString();
      }
      QZoneHelper.a(this, (QZoneHelper.UserInfo)localObject1, 1009, "", paramView, "", "", 0, 1, 1, 0, 0, 0, "", 10000, (Bundle)localObject2, false, false, this.jdField_f_of_type_Int, this.jdField_h_of_type_Int, false);
      LpReportInfo_pf00064.allReport(680, 2, 3, true);
      return;
    case 2131373558: 
      if (this.p)
      {
        QQToast.a(this, getString(2131432955), 0).a();
        return;
      }
      LpReportInfo_pf00064.allReport(680, 5, 1, true);
      paramView = QzoneConfig.getInstance().getConfig("H5Url", "UgcPermitSetting", "https://h5.qzone.qq.com/ugc/setting?_wv=3&type=mood&uin={uin}&qua={qua}&_proxy=1").replace("{uin}", QQStoryContext.a().a()).replace("{qua}", QUA.a());
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("permission_code", this.jdField_a_of_type_Int);
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
      if ((a(this.jdField_a_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
        ((Bundle)localObject1).putString("key_setting_raw_json", this.jdField_b_of_type_JavaLangString);
      }
      QZoneHelper.a(this, paramView, 1, (Bundle)localObject1, "");
      LpReportInfo_pf00064.allReport(680, 2, 4, true);
      return;
    }
    s();
  }
  
  public void onCompleted(int[] paramArrayOfInt)
  {
    paramArrayOfInt = new Message();
    paramArrayOfInt.what = 20;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramArrayOfInt);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.getWindow().addFlags(128);
    this.W = true;
    this.X = false;
    this.l = true;
    this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = ((PowerManager)getSystemService("power")).newWakeLock(536870922, "QzDynamicVideoPreviewActivity");
    if (paramBundle != null) {}
    for (this.jdField_c_of_type_JavaUtilArrayList = paramBundle.getStringArrayList("p2v_selected_item_path");; this.jdField_c_of_type_JavaUtilArrayList = getIntent().getStringArrayListExtra("param.DVImgPath"))
    {
      this.jdField_e_of_type_Int = getIntent().getIntExtra("param.P2VEntrance", 200);
      this.v = getIntent().getBooleanExtra("param.isTakeVideoBack", false);
      LpReportInfo_pf00064.allReport(680, 1, 3, true);
      super.onCreate(paramBundle);
      return;
    }
  }
  
  protected void onDestroy()
  {
    this.l = false;
    d();
    b();
    i();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMainP2VEffectConvertor != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMainP2VEffectConvertor.onDestroy();
    }
    if ((this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null) && (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld())) {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
    }
    super.onDestroy();
  }
  
  public void onDurationGot(long paramLong)
  {
    QLog.d("QzDynamicVideoPreviewActivity", 2, "IPrepareListener - onDurationGot:" + paramLong);
  }
  
  public void onError(int paramInt, String paramString)
  {
    QLog.d("QzDynamicVideoPreviewActivity", 2, "IPrepareListener - onError");
    paramString = new Message();
    paramString.what = 10;
    Bundle localBundle = new Bundle();
    localBundle.putInt("ONERROR_ERROR_KEY", paramInt);
    paramString.setData(localBundle);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    QZLog.d("QzDynamicVideoPreviewActivity", 1, "onNewIntent back");
    super.onNewIntent(paramIntent);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((paramIntent != null) && (paramIntent.size() > 0))
    {
      this.jdField_c_of_type_JavaUtilArrayList = paramIntent;
      m();
      return;
    }
    finish();
  }
  
  protected void onPause()
  {
    super.onPause();
    this.jdField_i_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewDynamicVideoView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    a(true);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.jdField_i_of_type_Boolean = true;
    if ((!this.jdField_f_of_type_Boolean) && (this.jdField_g_of_type_Boolean))
    {
      a();
      this.jdField_f_of_type_Boolean = true;
    }
    while ((!this.jdField_f_of_type_Boolean) || ((2 != this.jdField_d_of_type_Int) && (1 != this.jdField_d_of_type_Int)) || (this.p) || (!this.jdField_g_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 200L);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putStringArrayList("p2v_selected_item_path", this.jdField_c_of_type_JavaUtilArrayList);
  }
  
  public void onStartPrepare()
  {
    QLog.d("QzDynamicVideoPreviewActivity", 2, "IPrepareListener - onStartPrepare");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.QzDynamicVideoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */