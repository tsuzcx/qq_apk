import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.shortvideo.PreviewVideoActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import cooperation.qzone.video.VideoComponentCallback;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.QIMQzoneEffectsCameraCaptureUnit.1;
import dov.com.qq.im.QIMQzoneEffectsCameraCaptureUnit.2;
import dov.com.qq.im.QIMQzoneEffectsCameraCaptureUnit.3;
import dov.com.qq.im.QIMQzoneEffectsCameraCaptureUnit.4;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeGifSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.QzoneEditPictureActivity;
import dov.com.tencent.mobileqq.activity.richmedia.QzoneEditVideoActivity;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class bknw
  extends QIMEffectCameraCaptureUnit
{
  public static long a;
  private static final String l = bknw.class.getSimpleName();
  private boolean A;
  private boolean B;
  private boolean C;
  private boolean D;
  private boolean E;
  private boolean F;
  private ajpz jdField_a_of_type_Ajpz;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private QzoneVerticalVideoTopicInfo jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo;
  public boolean a;
  private Bundle jdField_b_of_type_AndroidOsBundle;
  private LocalMediaInfo jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  private CameraCaptureView.VideoCaptureResult c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  private String r;
  private String s;
  private String t;
  private String u;
  private boolean y;
  private boolean z;
  
  static
  {
    jdField_a_of_type_Long = -1L;
  }
  
  public bknw(bmhh parambmhh, bmhg parambmhg)
  {
    super(parambmhh, parambmhg);
    this.jdField_e_of_type_Int = -1;
    this.jdField_d_of_type_Int = 10001;
    this.jdField_a_of_type_Bmgz = new bmgz(this.jdField_d_of_type_Int, 122, 3);
    this.jdField_a_of_type_Int = 12;
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    boolean bool1;
    boolean bool2;
    Object localObject2;
    Object localObject1;
    if ((paramInt == -1) && (paramIntent != null))
    {
      bool1 = paramIntent.getBooleanExtra("go_publish_activity", false);
      bool2 = paramIntent.getBooleanExtra("extra_directly_back", false);
      if (!bool1) {
        break label225;
      }
      localObject2 = paramIntent.getStringExtra("key_content");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramInt = paramIntent.getIntExtra("key_priv", 1);
      localObject2 = (ArrayList)paramIntent.getSerializableExtra("key_priv_uin_list");
      if (localObject2 != null) {
        break label247;
      }
      localObject2 = new ArrayList();
    }
    label225:
    label247:
    for (;;)
    {
      int i = paramIntent.getIntExtra("key_font_id", -1);
      this.jdField_f_of_type_Int = paramIntent.getIntExtra("key_font_format_type", 0);
      this.n = paramIntent.getStringExtra("key_font_url");
      this.jdField_g_of_type_Int = paramIntent.getIntExtra("key_super_font_id", -1);
      this.jdField_o_of_type_JavaLangString = paramIntent.getStringExtra("key_super_font_info");
      ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      bool1 = paramIntent.getBooleanExtra("key_timer_delete", false);
      bool2 = paramIntent.getBooleanExtra("key_sync_to_qqstory", false);
      QLog.i(l, 2, "get mSetTimerDelete: " + bool1);
      bjdt.a((String)localObject1, localArrayList, paramInt, (ArrayList)localObject2, i, this.jdField_f_of_type_Int, this.n, bool1, bool2, i, this.jdField_o_of_type_JavaLangString);
      a().finish();
      do
      {
        return;
      } while (!bool2);
      a().setResult(-1, paramIntent);
      a().finish();
      return;
    }
  }
  
  private void a(String paramString)
  {
    if ((a() == null) || (a().isFinishing())) {
      return;
    }
    Intent localIntent = new Intent(a(), EditVideoActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("extra_publish_text", alud.a(2131710229));
    paramString = new EditVideoParams(3, 536903689L, new EditTakeGifSource(paramString, null, null), localBundle);
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", NewFlowCameraActivity.class.getName());
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra(EditVideoParams.class.getName(), paramString);
    localIntent.putExtra("op_type", "gif_edit");
    localIntent.putExtra("op_department", "grp_qzone");
    localIntent.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
    localIntent.putExtra("DirectBackToQzone", true);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    this.jdField_a_of_type_Bmhh.a().startActivityForResult(localIntent, 1014);
  }
  
  private void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, ajpz paramajpz, String paramString5, int paramInt3, ArrayList<String> paramArrayList, boolean paramBoolean1, int paramInt4, int paramInt5, String paramString6, int paramInt6, String paramString7, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    String str = new File(paramString2).getParent();
    if (!TextUtils.isEmpty(paramString4)) {
      PtvFilterUtils.a(str, paramString4);
    }
    ajqk localajqk = new ajqk();
    localajqk.jdField_a_of_type_AndroidAppActivity = a();
    localajqk.jdField_a_of_type_JavaLangString = str;
    localajqk.jdField_b_of_type_JavaLangString = paramString1;
    localajqk.jdField_a_of_type_Int = paramInt1;
    localajqk.jdField_c_of_type_JavaLangString = paramString2;
    localajqk.jdField_f_of_type_JavaLangString = paramString3;
    localajqk.jdField_c_of_type_Int = 0;
    localajqk.jdField_d_of_type_Int = 0;
    localajqk.jdField_k_of_type_JavaLangString = paramString4;
    if (this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult == null)
    {
      axwq.a(new RuntimeException("videoCaptureResult == null"));
      QLog.e(l, 2, "videoCaptureResult == null");
    }
    for (localajqk.jdField_i_of_type_Int = 0;; localajqk.jdField_i_of_type_Int = this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoFrameCount)
    {
      localajqk.jdField_j_of_type_Int = paramInt2;
      localajqk.jdField_a_of_type_Ajpz = paramajpz;
      localajqk.jdField_g_of_type_JavaLangString = paramString5;
      localajqk.jdField_e_of_type_Int = paramInt3;
      localajqk.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      localajqk.jdField_a_of_type_Boolean = this.C;
      localajqk.jdField_j_of_type_JavaLangString = this.t;
      localajqk.jdField_b_of_type_Boolean = paramBoolean1;
      localajqk.jdField_f_of_type_Int = paramInt4;
      localajqk.jdField_g_of_type_Int = paramInt5;
      localajqk.jdField_h_of_type_JavaLangString = paramString6;
      localajqk.jdField_h_of_type_Int = paramInt6;
      localajqk.jdField_i_of_type_JavaLangString = paramString7;
      localajqk.jdField_e_of_type_Boolean = paramBoolean2;
      localajqk.jdField_f_of_type_Boolean = paramBoolean3;
      localajqk.jdField_g_of_type_Boolean = paramBoolean4;
      localajqk.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo = this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo;
      localajqk.jdField_h_of_type_Boolean = paramBoolean5;
      localajqk.jdField_k_of_type_Int = this.jdField_b_of_type_AndroidOsBundle.getInt("entry_source", 0);
      localajqk.jdField_d_of_type_JavaLangString = "";
      localajqk.jdField_b_of_type_Int = 0;
      localajqk.jdField_e_of_type_JavaLangString = "";
      new ajqj(localajqk).execute(new Void[0]);
      return;
    }
  }
  
  private void ac()
  {
    String str = a() + File.separator + "videoThumb.jpg";
    axwp.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoMp4FilePath, str);
    this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.thumbnailPath = str;
  }
  
  private void ad()
  {
    if ((this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo != null)) {
      a(this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.audioDataFilePath, 0, this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoMp4FilePath, this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.thumbnailPath, null, (int)this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration, this.jdField_a_of_type_Ajpz, null, -1, null, false, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, this.n, this.jdField_g_of_type_Int, this.jdField_o_of_type_JavaLangString, false, false, false, false);
    }
  }
  
  private void ae()
  {
    try
    {
      bdhb.a(a());
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i(l, 2, "Delete file error", localException);
    }
  }
  
  private void af()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      QZLog.e(l, 1, new Object[] { "cancelProgressDialog", localException });
    }
  }
  
  private void b(int paramInt, Intent paramIntent)
  {
    if (paramInt == 0) {
      ae();
    }
    while ((paramInt != -1) || (paramIntent == null)) {
      return;
    }
    Object localObject2 = paramIntent.getStringExtra("key_content");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    int i = paramIntent.getIntExtra("key_priv", 1);
    localObject2 = (ArrayList)paramIntent.getSerializableExtra("key_priv_uin_list");
    if (localObject2 == null) {
      localObject2 = new ArrayList();
    }
    for (;;)
    {
      int j = paramIntent.getIntExtra("key_font_id", -1);
      this.jdField_f_of_type_Int = paramIntent.getIntExtra("key_font_format_type", 0);
      this.n = paramIntent.getStringExtra("key_font_url");
      this.jdField_g_of_type_Int = paramIntent.getIntExtra("key_super_font_id", -1);
      this.jdField_o_of_type_JavaLangString = paramIntent.getStringExtra("key_super_font_info");
      boolean bool1 = paramIntent.getBooleanExtra("key_generate_gif", false);
      boolean bool2 = paramIntent.getBooleanExtra("key_timer_delete", false);
      PublishParam localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
      if (localPublishParam.jdField_f_of_type_Int <= 5) {}
      for (paramInt = localPublishParam.jdField_f_of_type_Int;; paramInt = 0)
      {
        int k = (int)localPublishParam.jdField_a_of_type_Long;
        boolean bool3 = paramIntent.getBooleanExtra("param.isUploadOrigin", false);
        a(localPublishParam.jdField_k_of_type_JavaLangString, paramInt, localPublishParam.jdField_j_of_type_JavaLangString, localPublishParam.jdField_c_of_type_JavaLangString, localPublishParam.jdField_b_of_type_JavaLangString, k, this.jdField_a_of_type_Ajpz, (String)localObject1, i, (ArrayList)localObject2, false, j, this.jdField_f_of_type_Int, this.n, this.jdField_g_of_type_Int, this.jdField_o_of_type_JavaLangString, bool1, bool2, false, bool3);
        this.F = true;
        return;
      }
    }
  }
  
  private void b(axqw paramaxqw)
  {
    try
    {
      if (a() == null) {
        break label643;
      }
      if (a().isFinishing()) {
        return;
      }
      if ((paramaxqw == null) || (TextUtils.isEmpty(paramaxqw.jdField_a_of_type_JavaLangString)))
      {
        bflz.a().a(alud.a(2131710228));
        a().finish();
        return;
      }
    }
    catch (Exception paramaxqw)
    {
      QLog.d(l, 2, "handlePic exception", paramaxqw);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(l, 2, "finishShotPhoto " + paramaxqw.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_b_of_type_AndroidOsBundle.getInt("edit_video_type", 0) != 10002) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      int i = this.jdField_b_of_type_AndroidOsBundle.getInt("extra.busi_type", 2);
      boolean bool2 = this.jdField_b_of_type_AndroidOsBundle.getBoolean("go_publish_activity", false);
      if (a() != null)
      {
        if (i == 3)
        {
          double d1 = this.jdField_b_of_type_AndroidOsBundle.getDouble("key_longtitude", 4.9E-324D);
          double d2 = this.jdField_b_of_type_AndroidOsBundle.getDouble("key_latitude", 4.9E-324D);
          bjud.b(paramaxqw.jdField_a_of_type_JavaLangString, d1, d2);
        }
        Intent localIntent;
        label334:
        String str;
        if (bool2)
        {
          localIntent = QzoneEditPictureActivity.a(a(), paramaxqw.jdField_a_of_type_JavaLangString, bool1, i, i(), 0);
          localIntent.putExtra("TEMP_PARAM", localIntent.getLongExtra("TEMP_PARAM", 0L) & 0xFFFFFFBF & 0xFFFFFEFF & 0xFFFFFF7F);
          localIntent.putExtra("go_publish_activity", bool2);
          localIntent.putExtra("extra_directly_back", this.jdField_b_of_type_AndroidOsBundle.getBoolean("extra_directly_back", false));
          localIntent.putExtra("qcamera_photo_filepath", paramaxqw.jdField_a_of_type_JavaLangString);
          localIntent.putExtra("qcamera_rotate", paramaxqw.jdField_c_of_type_Int);
          localIntent.putExtra("PhotoConst.EDIT_COME_FROM_NEWFLOW", true);
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a() != 2) {
            break label634;
          }
          i = 0;
          localIntent.putExtra("camera_type", 103);
          localIntent.putExtra("camera_front_back", i);
          localIntent.putExtra("camera_capture_method", paramaxqw.jdField_a_of_type_Int);
          localIntent.putExtra("state", this.jdField_a_of_type_AndroidOsBundle);
          localIntent.putExtra("babyq_ability", this.jdField_b_of_type_AndroidOsBundle.getLong("babyq_ability", 0L));
          if (this.jdField_b_of_type_AndroidOsBundle.getInt("entry_source", 0) == 5) {
            localIntent.putExtra("pic_entrance_type", 13);
          }
          ajpy.a(this.jdField_b_of_type_AndroidOsBundle.getInt("edit_video_type", -1), "", "0X8007818", null);
          paramaxqw = SplashActivity.class.getName();
          str = this.jdField_b_of_type_AndroidOsBundle.getString("f_a_a_n");
          if ((str == null) || (!str.equals(ChatActivity.class.getName()))) {
            break label640;
          }
          paramaxqw = str;
        }
        label640:
        for (;;)
        {
          ajrw.a("finish");
          ajrw.a(localIntent);
          str = localIntent.getStringExtra("pic_confirm_text");
          if (!TextUtils.isEmpty(str)) {
            localIntent.putExtra("extra_publish_text", str);
          }
          if (bool2) {
            localIntent.putExtra("extra_publish_text", this.jdField_a_of_type_Bmhh.a().getString(2131695781));
          }
          localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramaxqw);
          localIntent.putExtra("key_activity_code", this.jdField_b_of_type_AndroidOsBundle.getString("key_activity_code"));
          this.jdField_a_of_type_Bmhh.a().startActivityForResult(localIntent, 1012);
          ajpy.a("", "0X80075C1", "", "", "", "");
          return;
          localIntent = QzoneEditPictureActivity.a(a(), paramaxqw.jdField_a_of_type_JavaLangString);
          break;
          label634:
          i = 1;
          break label334;
        }
      }
      label643:
      return;
    }
  }
  
  private void b(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult)
  {
    ac();
    if (a() != null)
    {
      Intent localIntent = new Intent(a(), PreviewVideoActivity.class);
      localIntent.putExtra("from_qzone_camera", true);
      localIntent.putExtra("video_path", paramVideoCaptureResult.videoMp4FilePath);
      localIntent.putExtra("audio_path", paramVideoCaptureResult.audioDataFilePath);
      this.jdField_a_of_type_Bmhh.a().startActivityForResult(localIntent, 1016);
    }
  }
  
  private void b(String paramString)
  {
    for (;;)
    {
      try
      {
        TextView localTextView;
        if (this.jdField_a_of_type_AndroidAppProgressDialog != null)
        {
          af();
          localTextView = (TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131371894);
          if (bdnn.a(paramString))
          {
            localTextView.setText(2131717582);
            if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
              break;
            }
            this.jdField_a_of_type_AndroidAppProgressDialog.show();
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(a(), 2131755801);
          this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(false);
          this.jdField_a_of_type_AndroidAppProgressDialog.show();
          this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559437);
          continue;
        }
        localTextView.setText(paramString);
      }
      catch (Throwable paramString)
      {
        QZLog.e(l, 1, new Object[] { "showProgressDialog", paramString });
        return;
      }
    }
  }
  
  private void b(boolean paramBoolean, String paramString)
  {
    if ((a() == null) || (a().isFinishing())) {
      return;
    }
    a().runOnUiThread(new QIMQzoneEffectsCameraCaptureUnit.4(this, paramBoolean, paramString));
  }
  
  private String c()
  {
    String str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + Environment.DIRECTORY_DCIM + File.separator + "Camera";
    File localFile = new File(str + File.separator + "gif");
    if ((localFile.exists()) && (!localFile.isDirectory())) {
      localFile.delete();
    }
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    return str + File.separator + "gif" + File.separator + System.currentTimeMillis() + ".gif";
  }
  
  private void c(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  private void c(Bundle paramBundle)
  {
    if ((a() == null) || (a().isFinishing())) {}
    do
    {
      return;
      this.jdField_c_of_type_Boolean = true;
      this.t = paramBundle.getString("topic_id");
      this.u = paramBundle.getString("short_video_refer");
      this.jdField_a_of_type_Ajpz = new VideoComponentCallback();
      this.jdField_a_of_type_Ajpz.c_(this.u);
      this.y = paramBundle.getBoolean("is_glance_video", false);
      this.m = paramBundle.getString("confirm_text");
      this.z = paramBundle.getBoolean("enable_priv_list", true);
      this.A = paramBundle.getBoolean("enable_input_text", true);
      this.B = paramBundle.getBoolean("is_qzone_vip", false);
      this.C = paramBundle.getBoolean("enable_edit_video", false);
      this.jdField_b_of_type_Boolean = paramBundle.getBoolean("enable_local_video", false);
      if (this.y)
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_s_of_type_Boolean = false;
        this.jdField_r_of_type_Boolean = false;
      }
      if ("cover_mall_record_video".equals(this.u))
      {
        this.jdField_s_of_type_Boolean = false;
        this.jdField_r_of_type_Boolean = false;
      }
      this.jdField_p_of_type_Boolean = paramBundle.getBoolean("PeakConstants.ARG_SUPPORT_FILTER", true);
      this.jdField_q_of_type_Boolean = paramBundle.getBoolean("PeakConstants.ARG_SUPPORT_DD", true);
      this.jdField_o_of_type_Boolean = paramBundle.getBoolean("PeakConstants.ARG_BEAUTY", true);
      this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo = ((QzoneVerticalVideoTopicInfo)paramBundle.getParcelable("key_qzone_topic"));
      this.D = paramBundle.getBoolean("PeakConstants.ARG_UNFOLD_DD", false);
      this.jdField_p_of_type_JavaLangString = paramBundle.getString("PeakConstants.ARG_DD_CATEGORY_NAME");
      this.jdField_q_of_type_JavaLangString = paramBundle.getString("PeakConstants.ARG_DD_ITEM_ID");
      this.E = paramBundle.getBoolean("PeakConstants.ARG_UNFOLD_FILTER", false);
      this.jdField_r_of_type_JavaLangString = paramBundle.getString("PeakConstants.ARG_FILTER_CATEGORY_NAME");
      this.jdField_s_of_type_JavaLangString = paramBundle.getString("PeakConstants.ARG_FILTER_ITEM_ID");
      this.jdField_h_of_type_Int = paramBundle.getInt("PeakConstants.ARG_FORCE_CAMERA", 0);
    } while ((this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo == null) || (!this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.a()));
    this.jdField_s_of_type_Boolean = false;
  }
  
  private void c(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(l, 2, "intentToEditVideoActivityFromQzone start!");
    }
    for (;;)
    {
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("entrance_type", i());
        localBundle.putString("extra_publish_text", this.m);
        localBundle.putBoolean("enable_hw_encode", true);
        j = 538968427;
        localBundle.putBoolean("extra_enable_revert", true);
        localBundle.putBoolean("extra_enable_slow", true);
        int i = j;
        if (this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo != null)
        {
          i = j;
          if (this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.a()) {
            i = 538968425;
          }
        }
        int k = this.jdField_b_of_type_AndroidOsBundle.getInt("entry_source", 0);
        if (paramLocalMediaInfo.mDuration > QzoneConfig.getInstance().getConfig("MiniVideo", "QzoneVideoMaxTime", 7) * 1000 + 500) {
          break label620;
        }
        j = 1;
        if ((!TextUtils.isEmpty(this.t)) || ("ref_h5_record_video".equals(this.u)) || (k == 3) || (k == 5) || (j == 0) || (bjvw.a()) || (this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo != null)) {
          break label616;
        }
        i |= 0x10000;
        bool = this.jdField_b_of_type_AndroidOsBundle.getBoolean("enable_edit_button", true);
        paramVideoCaptureResult = new EditTakeVideoSource(paramVideoCaptureResult.videoMp4FilePath, paramVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo);
        if (!bool) {
          break label626;
        }
        l1 = i;
        paramVideoCaptureResult = new EditVideoParams(3, l1, paramVideoCaptureResult, localBundle);
        paramVideoCaptureResult.jdField_a_of_type_AndroidOsBundle.putBoolean("enable_hw_encode", true);
        if (QLog.isColorLevel()) {
          QLog.d(l, 2, "intentToEditVideoActivityFromQzone startActivityForResult---> EditVideoParams params:" + paramVideoCaptureResult.toString() + ", recordFinish---startEdit");
        }
        if (a() == null) {
          break label619;
        }
        if (a().isFinishing()) {
          return;
        }
        paramLocalMediaInfo = new Intent(a(), QzoneEditVideoActivity.class);
        paramLocalMediaInfo.putExtra(EditVideoParams.class.getName(), paramVideoCaptureResult);
        paramLocalMediaInfo.putExtra("key_font_id", this.jdField_e_of_type_Int);
        paramLocalMediaInfo.putExtra("op_department", "grp_qzone");
        paramLocalMediaInfo.putExtra("op_type", "video_edit");
        paramLocalMediaInfo.putExtra("topic_id", this.t);
        paramLocalMediaInfo.putExtra("enable_priv_list", this.z);
        paramLocalMediaInfo.putExtra("enable_input_text", this.A);
        paramLocalMediaInfo.putExtra("stop_record_time", System.currentTimeMillis());
        paramLocalMediaInfo.putExtra("state", this.jdField_a_of_type_AndroidOsBundle);
        paramLocalMediaInfo.putExtra("mIsQzoneVip", this.B);
        paramLocalMediaInfo.putExtra("UseQQCameraCompression", QzoneConfig.getInstance().getConfig("PhotoAlbum", "UseQQCameraCompression", 2));
        paramLocalMediaInfo.putExtra("entry_source", this.jdField_b_of_type_AndroidOsBundle.getInt("entry_source", 0));
        if (j == 0)
        {
          bool = true;
          paramLocalMediaInfo.putExtra("TAKE_DANCING_VIDEO", bool);
          paramLocalMediaInfo.putExtra("key_qzone_topic", this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo);
          this.jdField_a_of_type_Bmhh.a().startActivityForResult(paramLocalMediaInfo, 1011);
          this.jdField_a_of_type_Bmhh.a().overridePendingTransition(0, 0);
          if (!QLog.isColorLevel()) {
            break label619;
          }
          QLog.d(l, 2, "intentToEditVideoActivityFromQzone ---> finish startActivityForResult");
          return;
        }
      }
      catch (Exception paramVideoCaptureResult)
      {
        QLog.e(l, 1, "intentToEditVideoActivityFromQzone exception:" + paramVideoCaptureResult);
        return;
      }
      boolean bool = false;
      continue;
      label616:
      continue;
      label619:
      return;
      label620:
      int j = 0;
      continue;
      label626:
      long l1 = 0L;
    }
  }
  
  private void d(int paramInt)
  {
    ae();
    if (paramInt == 0) {}
    while (paramInt != -1) {
      return;
    }
    QLog.i(l, 2, "REQ_PREVIEW_EDIT_GIF_ACTIVITY result ok");
    a().finish();
  }
  
  private void d(Bundle paramBundle)
  {
    int j = 3;
    boolean bool2 = paramBundle.getBoolean("flow_camera_video_mode", true);
    boolean bool1 = paramBundle.getBoolean("flow_camera_capture_mode", true);
    if (this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo != null) {
      bool1 = false;
    }
    int i;
    if ((bool2) && (bool1))
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setRecordTipsWording(this.jdField_a_of_type_Bmhh.a().getResources().getString(2131699838));
      i = 1;
    }
    for (;;)
    {
      int k;
      if (this.y)
      {
        c(QzoneConfig.getInstance().getConfig("MiniVideo", "QzoneGifMiniFrame", 5));
        k = QzoneConfig.getInstance().getConfig("MiniVideo", "GlanceVideoMaxTime", 1);
        i = j;
      }
      for (j = k;; j = QzoneConfig.getInstance().getConfig("MiniVideo", "QzoneVideoMaxTime", 7))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setMaxDuration(j * 1000 + 100);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setFunctionFlag(i);
        return;
        if ((bool2) && (!bool1))
        {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setRecordTipsWording(this.jdField_a_of_type_Bmhh.a().getString(2131699847));
          i = 3;
          break;
        }
        if ((bool2) || (!bool1)) {
          break label250;
        }
        i = 2;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setRecordTipsWording(this.jdField_a_of_type_Bmhh.a().getString(2131699837));
        break;
        c(QzoneConfig.getInstance().getConfig("MiniVideo", "QzoneVideoMiniFrame", 6));
      }
      label250:
      i = 1;
    }
  }
  
  private void d(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    if (a() != null) {
      a().runOnUiThread(new QIMQzoneEffectsCameraCaptureUnit.2(this));
    }
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new QIMQzoneEffectsCameraCaptureUnit.3(this, paramVideoCaptureResult, paramLocalMediaInfo));
  }
  
  private void e(int paramInt)
  {
    if ((paramInt != -1) || (a() == null) || (a().isFinishing())) {
      return;
    }
    a().finish();
  }
  
  private void f(int paramInt)
  {
    if (paramInt == 0) {
      ae();
    }
    while (paramInt != -1) {
      return;
    }
    ad();
  }
  
  private int i()
  {
    int j = this.jdField_b_of_type_AndroidOsBundle.getInt("entrance_type", 99);
    int i = j;
    SessionInfo localSessionInfo;
    if (j == 100)
    {
      localSessionInfo = (SessionInfo)this.jdField_b_of_type_AndroidOsBundle.getParcelable("PhotoConst.SEND_SESSION_INFO");
      if (localSessionInfo == null) {
        break label51;
      }
    }
    label51:
    for (i = localSessionInfo.jdField_a_of_type_Int;; i = 0)
    {
      i = azcm.a(i);
      return i;
    }
  }
  
  public View a()
  {
    if ((this.jdField_a_of_type_Bmhh != null) && (this.jdField_a_of_type_Bmhh.a() != null) && (this.jdField_a_of_type_Bmhh.a().getIntent() != null))
    {
      localObject = this.jdField_a_of_type_Bmhh.a().getIntent();
      this.jdField_b_of_type_AndroidOsBundle = ((Intent)localObject).getExtras();
      this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo = ((QzoneVerticalVideoTopicInfo)((Intent)localObject).getParcelableExtra("key_qzone_topic"));
      c(this.jdField_b_of_type_AndroidOsBundle);
    }
    Object localObject = super.a();
    if ("cover_mall_record_video".equals(this.u)) {
      this.jdField_b_of_type_Boolean = false;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    d(this.jdField_b_of_type_AndroidOsBundle);
    return localObject;
  }
  
  protected axqt a()
  {
    if ((!this.y) && (this.C)) {}
    for (int i = QzoneConfig.getInstance().getConfig("PhotoAlbum", "UseQQCameraCompression", 2);; i = 1)
    {
      if (this.jdField_h_of_type_Int != 0) {}
      for (;;)
      {
        ajsu localajsu = axpy.a().a(this.jdField_h_of_type_Int);
        axqt localaxqt = new axqt();
        localaxqt.a(localajsu.a());
        localaxqt.b(localajsu.b());
        localaxqt.a(axpy.a().a(this.jdField_h_of_type_Int));
        i *= axpy.a().a(this.jdField_h_of_type_Int) * 1000;
        localaxqt.j(i);
        azib.r = i;
        localaxqt.k(1);
        localaxqt.i(this.jdField_h_of_type_Int);
        return localaxqt;
        if (this.D) {
          this.jdField_h_of_type_Int = 1;
        } else {
          this.jdField_h_of_type_Int = axph.b();
        }
      }
    }
  }
  
  public ArrayList<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(0));
    return localArrayList;
  }
  
  protected List<View> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_b_of_type_AndroidWidgetTextView);
    return localArrayList;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    Activity localActivity = this.jdField_a_of_type_Bmhh.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {}
    for (;;)
    {
      return;
      switch (paramInt1)
      {
      }
      while (this.jdField_a_of_type_Ajpz != null)
      {
        this.jdField_a_of_type_Ajpz.a(a(), paramInt1, paramInt2, paramIntent);
        return;
        a(paramInt2, paramIntent);
        continue;
        d(paramInt2);
        continue;
        b(paramInt2, paramIntent);
        continue;
        e(paramInt2);
        continue;
        f(paramInt2);
      }
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Ajpz != null) {
      this.jdField_a_of_type_Ajpz.a(paramActivity);
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    try
    {
      Intent localIntent = new Intent(BaseApplicationImpl.getContext(), EditLocalVideoActivity.class);
      localIntent.putExtras(paramIntent);
      localIntent.putExtra("short_video_refer", getClass().getName());
      localIntent.putExtra("is_qzone_vip", this.B);
      localIntent.putExtra("param.topicId", this.t);
      localIntent.putExtra("param.topicSyncQzone", false);
      localIntent.putExtra("extra_key_font_id", this.jdField_e_of_type_Int);
      localIntent.putExtra("extra_key_font_format_type", this.jdField_f_of_type_Int);
      localIntent.putExtra("extra_key_font_url", this.n);
      localIntent.putExtra("extra_key_super_font_id", this.jdField_g_of_type_Int);
      localIntent.putExtra("extra_key_super_font_info", this.jdField_o_of_type_JavaLangString);
      localIntent.putExtra("short_video_refer", this.u);
      localIntent.putExtra("set_user_callback", this.jdField_b_of_type_AndroidOsBundle.getString("set_user_callback"));
      localIntent.putExtra("key_qzone_topic", this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo);
      ThreadManager.getUIHandler().postDelayed(new QIMQzoneEffectsCameraCaptureUnit.1(this, localIntent), 0L);
      return;
    }
    catch (Exception paramIntent)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i(l, 2, "handleOnNewIntent error ", paramIntent);
    }
  }
  
  public void a(axqw paramaxqw)
  {
    super.a(paramaxqw);
    b(paramaxqw);
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    super.a(paramVideoCaptureResult, paramLocalMediaInfo);
    try
    {
      this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = paramVideoCaptureResult;
      this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
      if ((paramVideoCaptureResult == null) || (paramVideoCaptureResult.videoMp4FilePath == null) || (paramLocalMediaInfo == null))
      {
        bflz.a().a(alud.a(2131710226));
        if (a() == null) {
          return;
        }
        a().finish();
        return;
      }
      if (this.y)
      {
        d(paramVideoCaptureResult, paramLocalMediaInfo);
        return;
      }
    }
    catch (Exception paramVideoCaptureResult)
    {
      QZLog.d(l, 2, "handleVideo exception!", paramVideoCaptureResult);
      return;
    }
    if (this.C)
    {
      c(paramVideoCaptureResult, paramLocalMediaInfo);
      return;
    }
    b(paramVideoCaptureResult);
  }
  
  public boolean a()
  {
    boolean bool = super.a();
    if ((!this.jdField_a_of_type_Boolean) && (bool))
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_b_of_type_Long == -1L) {
        break label85;
      }
    }
    label85:
    for (int i = (int)(System.currentTimeMillis() - this.jdField_b_of_type_Long);; i = 0)
    {
      wxj.a("video_shoot_new", "time_waitshoot", wxj.b(10001), i, new String[] { "", "1", "", "" });
      return bool;
    }
  }
  
  public int b()
  {
    return 4;
  }
  
  public void b(long paramLong)
  {
    int j = 0;
    Activity localActivity = this.jdField_a_of_type_Bmhh.a();
    int k = i();
    String str;
    Object localObject2;
    int i;
    if (localActivity.getIntent().hasExtra("pendingIntentClass"))
    {
      str = "1";
      localObject2 = "0";
      i = j;
      if (this.jdField_b_of_type_Long != -1L)
      {
        i = j;
        if (str.equals("0")) {
          i = (int)(paramLong - this.jdField_b_of_type_Long);
        }
      }
      localObject1 = localObject2;
      if (Build.VERSION.SDK_INT < 23) {}
    }
    for (;;)
    {
      try
      {
        if (localActivity.checkSelfPermission("android.permission.CAMERA") == 0) {
          continue;
        }
        bool1 = true;
        if (localActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
          continue;
        }
        bool2 = true;
        if (localActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
          continue;
        }
        bool3 = true;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(l, 2, new Object[] { "checkSelfPermission ", Boolean.valueOf(bool1), " ", Boolean.valueOf(bool2), " ", Boolean.valueOf(bool3) });
      }
      catch (Exception localException)
      {
        boolean bool1;
        boolean bool2;
        boolean bool3;
        localObject1 = "4";
        QLog.e(l, 1, "checkSelfPermission error, ", localException);
        continue;
        if ((bool1) || (bool2)) {
          continue;
        }
        localObject1 = localException;
        if (!bool3) {
          continue;
        }
        continue;
      }
      localObject1 = "";
      if (bool1) {
        localObject1 = "".concat("1");
      }
      localObject2 = localObject1;
      if (bool2) {
        localObject2 = ((String)localObject1).concat(",3");
      }
      localObject1 = localObject2;
      if (bool3) {
        localObject1 = ((String)localObject2).concat(",2");
      }
      wxj.a("video_shoot_new", "time_openshoot", wxj.b(10001), i, new String[] { str, localObject1, "", String.valueOf(k) });
      return;
      str = "0";
      break;
      bool1 = false;
      continue;
      bool2 = false;
      continue;
      bool3 = false;
    }
  }
  
  public void f()
  {
    super.f();
    if (this.F)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.onPause();
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.o();
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.d();
      this.F = false;
    }
  }
  
  public void h()
  {
    super.h();
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void j()
  {
    super.j();
    jdField_a_of_type_Long = System.currentTimeMillis();
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_b_of_type_Long == -1L) {
        break label85;
      }
    }
    label85:
    for (int i = (int)(System.currentTimeMillis() - this.jdField_b_of_type_Long);; i = 0)
    {
      wxj.a("video_shoot_new", "time_waitshoot", wxj.b(10001), i, new String[] { "", "0", "", "" });
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131369805)
    {
      a(this.jdField_a_of_type_Bmhh.a());
      return;
    }
    super.onClick(paramView);
  }
  
  public void q()
  {
    super.q();
    jdField_a_of_type_Long = System.currentTimeMillis();
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_b_of_type_Long == -1L) {
        break label85;
      }
    }
    label85:
    for (int i = (int)(System.currentTimeMillis() - this.jdField_b_of_type_Long);; i = 0)
    {
      wxj.a("video_shoot_new", "time_waitshoot", wxj.b(10001), i, new String[] { "", "0", "", "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bknw
 * JD-Core Version:    0.7.0.1
 */