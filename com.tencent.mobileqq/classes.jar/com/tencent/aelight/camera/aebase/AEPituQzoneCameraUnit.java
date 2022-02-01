package com.tencent.aelight.camera.aebase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.aioeditor.AIOShortVideoUtil;
import com.tencent.aelight.camera.aioeditor.MediaCodecSendTask;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditPictureActivity;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditVideoActivity;
import com.tencent.aelight.camera.aioeditor.setting.CaptureEntranceParams;
import com.tencent.aelight.camera.aioeditor.setting.ICameraEntrance;
import com.tencent.aelight.camera.aioeditor.setting.IQIMCameraContainer;
import com.tencent.aelight.camera.aioeditor.shortvideo.util.PtvFilterUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.VideoSendPublicParam;
import com.tencent.aelight.camera.struct.camera.AEPhotoCaptureResult;
import com.tencent.aelight.camera.struct.camera.AEVideoCaptureResult;
import com.tencent.aelight.camera.struct.editor.FlowComponentInterface;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.activity.shortvideo.PreviewVideoActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.utils.IQzoneVideoHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.GpsComplementUtil;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import java.io.File;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class AEPituQzoneCameraUnit
  extends AEPituCameraUnit
{
  public static long a = -1L;
  private static final String c = "AEPituQzoneCameraUnit";
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private FlowComponentInterface jdField_a_of_type_ComTencentAelightCameraStructEditorFlowComponentInterface = null;
  private QzoneVerticalVideoTopicInfo jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo;
  public long b;
  public String b;
  private String d;
  public boolean d;
  private int jdField_e_of_type_Int = 10001;
  private String jdField_e_of_type_JavaLangString;
  private int jdField_f_of_type_Int = -1;
  private String jdField_f_of_type_JavaLangString;
  private int jdField_g_of_type_Int;
  private String jdField_g_of_type_JavaLangString;
  private int jdField_h_of_type_Int;
  private String jdField_h_of_type_JavaLangString;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int = 0;
  private boolean jdField_i_of_type_Boolean;
  private boolean j;
  private boolean k;
  
  public AEPituQzoneCameraUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    super(paramIQIMCameraContainer, paramICameraEntrance);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    paramIQIMCameraContainer = new StringBuilder();
    paramIQIMCameraContainer.append(BaseApplicationImpl.getContext().getFilesDir().getPath());
    paramIQIMCameraContainer.append("/Android/data/com.tencent.mobileqq/qq/video/Source/");
    paramIQIMCameraContainer.append(this.jdField_b_of_type_Long);
    this.jdField_b_of_type_JavaLangString = paramIQIMCameraContainer.toString();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingCaptureEntranceParams = new CaptureEntranceParams(10001, 122, 3);
    this.jdField_b_of_type_Int = 12;
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    if (paramInt == -1)
    {
      QLog.i(c, 2, "REQ_PREVIEW_EDIT_GIF_ACTIVITY result ok");
      a().finish();
    }
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if (this.jdField_i_of_type_Int == 3)
    {
      super.a(1012, paramInt, paramIntent);
      return;
    }
    if ((paramInt == -1) && (paramIntent != null))
    {
      boolean bool1 = paramIntent.getBooleanExtra("go_publish_activity", false);
      boolean bool2 = paramIntent.getBooleanExtra("extra_directly_back", false);
      if (bool1)
      {
        Object localObject2 = paramIntent.getStringExtra("key_content");
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        paramInt = paramIntent.getIntExtra("key_priv", 1);
        ArrayList localArrayList = (ArrayList)paramIntent.getSerializableExtra("key_priv_uin_list");
        localObject2 = localArrayList;
        if (localArrayList == null) {
          localObject2 = new ArrayList();
        }
        int m = paramIntent.getIntExtra("key_font_id", -1);
        this.jdField_g_of_type_Int = paramIntent.getIntExtra("key_font_format_type", 0);
        this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("key_font_url");
        this.jdField_h_of_type_Int = paramIntent.getIntExtra("key_super_font_id", -1);
        this.jdField_f_of_type_JavaLangString = paramIntent.getStringExtra("key_super_font_info");
        localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        bool1 = paramIntent.getBooleanExtra("key_timer_delete", false);
        bool2 = paramIntent.getBooleanExtra("key_sync_to_qqstory", false);
        paramIntent = c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get mSetTimerDelete: ");
        localStringBuilder.append(bool1);
        QLog.i(paramIntent, 2, localStringBuilder.toString());
        QZoneHelper.publishPictureMoodSilently((String)localObject1, localArrayList, paramInt, (ArrayList)localObject2, m, this.jdField_g_of_type_Int, this.jdField_e_of_type_JavaLangString, bool1, bool2, m, this.jdField_f_of_type_JavaLangString);
        a().finish();
        return;
      }
      if (bool2)
      {
        a().setResult(-1, paramIntent);
        a().finish();
      }
    }
  }
  
  private void a(AEPhotoCaptureResult paramAEPhotoCaptureResult)
  {
    for (;;)
    {
      try
      {
        if (a() != null)
        {
          if (a().isFinishing()) {
            return;
          }
          if ((paramAEPhotoCaptureResult != null) && (!TextUtils.isEmpty(paramAEPhotoCaptureResult.filePath)))
          {
            Object localObject1;
            Object localObject2;
            if (QLog.isColorLevel())
            {
              localObject1 = c;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("finishShotPhoto ");
              ((StringBuilder)localObject2).append(paramAEPhotoCaptureResult.filePath);
              QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
            }
            if (this.jdField_a_of_type_AndroidOsBundle.getInt("edit_video_type", 0) != 10002)
            {
              bool1 = true;
              int m = this.jdField_a_of_type_AndroidOsBundle.getInt("extra.busi_type", 2);
              boolean bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("go_publish_activity", false);
              if (a() == null) {
                return;
              }
              if (m == 3)
              {
                double d1 = this.jdField_a_of_type_AndroidOsBundle.getDouble("key_longtitude", 4.9E-324D);
                double d2 = this.jdField_a_of_type_AndroidOsBundle.getDouble("key_latitude", 4.9E-324D);
                GpsComplementUtil.complementByLocal(paramAEPhotoCaptureResult.filePath, d1, d2);
              }
              if (bool2) {
                localObject1 = QzoneEditPictureActivity.a(a(), paramAEPhotoCaptureResult.filePath, bool1, m, c(), 0);
              } else {
                localObject1 = QzoneEditPictureActivity.a(a(), paramAEPhotoCaptureResult.filePath);
              }
              ((Intent)localObject1).putExtra("TEMP_PARAM", ((Intent)localObject1).getLongExtra("TEMP_PARAM", 0L) & 0xFFFFFFBF & 0xFFFFFF7F);
              ((Intent)localObject1).putExtra("go_publish_activity", bool2);
              ((Intent)localObject1).putExtra("extra_directly_back", this.jdField_a_of_type_AndroidOsBundle.getBoolean("extra_directly_back", false));
              ((Intent)localObject1).putExtra("qcamera_photo_filepath", paramAEPhotoCaptureResult.filePath);
              ((Intent)localObject1).putExtra("qcamera_rotate", paramAEPhotoCaptureResult.orientation);
              ((Intent)localObject1).putExtra("PhotoConst.EDIT_COME_FROM_NEWFLOW", true);
              ((Intent)localObject1).putExtra("camera_type", 103);
              ((Intent)localObject1).putExtra("babyq_ability", this.jdField_a_of_type_AndroidOsBundle.getLong("babyq_ability", 0L));
              if (this.jdField_a_of_type_AndroidOsBundle.getInt("entry_source", 0) == 5) {
                ((Intent)localObject1).putExtra("pic_entrance_type", 13);
              }
              localObject2 = SplashActivity.class.getName();
              String str = this.jdField_a_of_type_AndroidOsBundle.getString("f_a_a_n");
              paramAEPhotoCaptureResult = (AEPhotoCaptureResult)localObject2;
              if (str != null)
              {
                paramAEPhotoCaptureResult = (AEPhotoCaptureResult)localObject2;
                if (str.equals(ChatActivity.class.getName())) {
                  paramAEPhotoCaptureResult = str;
                }
              }
              NewFlowCameraReporter.a("finish");
              NewFlowCameraReporter.a((Intent)localObject1);
              localObject2 = ((Intent)localObject1).getStringExtra("pic_confirm_text");
              bool1 = TextUtils.isEmpty((CharSequence)localObject2);
              if (!bool1) {
                ((Intent)localObject1).putExtra("extra_publish_text", (String)localObject2);
              }
              if (bool2) {
                ((Intent)localObject1).putExtra("extra_publish_text", this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().getString(2131695277));
              }
              ((Intent)localObject1).putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramAEPhotoCaptureResult);
              ((Intent)localObject1).putExtra("key_activity_code", this.jdField_a_of_type_AndroidOsBundle.getString("key_activity_code"));
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().startActivityForResult((Intent)localObject1, 1012);
              FlowCameraMqqAction.a("", "0X80075C1", "", "", "", "");
            }
          }
          else
          {
            ToastUtil.a().a(HardCodeUtil.a(2131709795));
            a().finish();
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramAEPhotoCaptureResult)
      {
        QLog.d(c, 2, "handlePic exception", paramAEPhotoCaptureResult);
        return;
      }
      boolean bool1 = false;
    }
  }
  
  private void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, FlowComponentInterface paramFlowComponentInterface, String paramString5, int paramInt3, ArrayList<String> paramArrayList, boolean paramBoolean1, int paramInt4, int paramInt5, String paramString6, int paramInt6, String paramString7, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramString1 = new File(paramString2).getParent();
    if (!TextUtils.isEmpty(paramString4)) {
      PtvFilterUtils.a(paramString1, paramString4);
    }
    VideoSendPublicParam localVideoSendPublicParam = new VideoSendPublicParam();
    localVideoSendPublicParam.mContext = a();
    localVideoSendPublicParam.mVideoCacheDir = paramString1;
    localVideoSendPublicParam.mEncodeMode = paramInt1;
    localVideoSendPublicParam.mVideoFilePath = paramString2;
    localVideoSendPublicParam.mThumbFilePath = paramString3;
    localVideoSendPublicParam.mThumbWidth = 0;
    localVideoSendPublicParam.mThumbHeight = 0;
    localVideoSendPublicParam.fakeVid = paramString4;
    localVideoSendPublicParam.recordTime = paramInt2;
    localVideoSendPublicParam.mUserCallBack = paramFlowComponentInterface;
    localVideoSendPublicParam.mContent = paramString5;
    localVideoSendPublicParam.mPriv = paramInt3;
    localVideoSendPublicParam.mPrivUinList = paramArrayList;
    localVideoSendPublicParam.mEnableEditVideo = this.k;
    localVideoSendPublicParam.topicId = this.jdField_g_of_type_JavaLangString;
    localVideoSendPublicParam.topicSyncQzone = paramBoolean1;
    localVideoSendPublicParam.fontId = paramInt4;
    localVideoSendPublicParam.fontFormatType = paramInt5;
    localVideoSendPublicParam.fontUrl = paramString6;
    localVideoSendPublicParam.superFontId = paramInt6;
    localVideoSendPublicParam.superFontInfo = paramString7;
    localVideoSendPublicParam.generateGif = paramBoolean2;
    localVideoSendPublicParam.timerDelete = paramBoolean3;
    localVideoSendPublicParam.qzoneVerticalVideoTopicInfo = this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo;
    localVideoSendPublicParam.isUploadOrigin = paramBoolean5;
    localVideoSendPublicParam.entrySource = this.jdField_a_of_type_AndroidOsBundle.getInt("entry_source", 0);
    localVideoSendPublicParam.mUin = "";
    localVideoSendPublicParam.mUinType = 0;
    localVideoSendPublicParam.mTroopUin = "";
    new MediaCodecSendTask(localVideoSendPublicParam).execute(new Void[0]);
  }
  
  private void b(int paramInt)
  {
    if ((paramInt == -1) && (a() != null))
    {
      if (a().isFinishing()) {
        return;
      }
      a().finish();
    }
  }
  
  private void b(int paramInt, Intent paramIntent)
  {
    if (paramInt == 0)
    {
      t();
      return;
    }
    if ((paramInt == -1) && (paramIntent != null))
    {
      Object localObject2 = paramIntent.getStringExtra("key_content");
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      int m = paramIntent.getIntExtra("key_priv", 1);
      Object localObject3 = (ArrayList)paramIntent.getSerializableExtra("key_priv_uin_list");
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new ArrayList();
      }
      int n = paramIntent.getIntExtra("key_font_id", -1);
      this.jdField_g_of_type_Int = paramIntent.getIntExtra("key_font_format_type", 0);
      this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("key_font_url");
      this.jdField_h_of_type_Int = paramIntent.getIntExtra("key_super_font_id", -1);
      this.jdField_f_of_type_JavaLangString = paramIntent.getStringExtra("key_super_font_info");
      boolean bool1 = paramIntent.getBooleanExtra("key_generate_gif", false);
      boolean bool2 = paramIntent.getBooleanExtra("key_timer_delete", false);
      localObject3 = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
      if (((PublishParam)localObject3).jdField_f_of_type_Int <= 5) {
        paramInt = ((PublishParam)localObject3).jdField_f_of_type_Int;
      } else {
        paramInt = 0;
      }
      int i1 = (int)((PublishParam)localObject3).jdField_a_of_type_Long;
      boolean bool3 = paramIntent.getBooleanExtra("param.isUploadOrigin", false);
      a(((PublishParam)localObject3).k, paramInt, ((PublishParam)localObject3).j, ((PublishParam)localObject3).c, ((PublishParam)localObject3).jdField_b_of_type_JavaLangString, i1, this.jdField_a_of_type_ComTencentAelightCameraStructEditorFlowComponentInterface, (String)localObject1, m, (ArrayList)localObject2, false, n, this.jdField_g_of_type_Int, this.jdField_e_of_type_JavaLangString, this.jdField_h_of_type_Int, this.jdField_f_of_type_JavaLangString, bool1, bool2, false, bool3);
    }
  }
  
  private void b(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      int m = paramIntent.getIntExtra("key_font_id", -1);
      int n = paramIntent.getIntExtra("key_font_format_type", 0);
      String str1 = paramIntent.getStringExtra("key_font_url");
      int i1 = paramIntent.getIntExtra("key_super_font_id", -1);
      String str2 = paramIntent.getStringExtra("key_super_font_info");
      paramIntent = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
      if (paramIntent == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQAlbum", 2, "handleQzoneEditVideoResult: publishParam == null");
        }
        return;
      }
      a(this.jdField_a_of_type_ComTencentAelightCameraStructCameraAEVideoCaptureResult.audioDataFilePath, 0, this.jdField_a_of_type_ComTencentAelightCameraStructCameraAEVideoCaptureResult.videoMp4FilePath, paramIntent.c, null, (int)paramIntent.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentAelightCameraStructEditorFlowComponentInterface, null, -1, null, false, m, n, str1, i1, str2, false, false, false, false);
    }
  }
  
  private void b(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    s();
    if (a() != null)
    {
      Intent localIntent = new Intent(a(), PreviewVideoActivity.class);
      localIntent.putExtra("from_qzone_camera", true);
      localIntent.putExtra("video_path", paramAEVideoCaptureResult.videoMp4FilePath);
      localIntent.putExtra("audio_path", paramAEVideoCaptureResult.audioDataFilePath);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().startActivityForResult(localIntent, 1016);
    }
  }
  
  private int c()
  {
    int n = this.jdField_a_of_type_AndroidOsBundle.getInt("entrance_type", 99);
    int m = n;
    if (n == 100)
    {
      m = 0;
      SessionInfo localSessionInfo = (SessionInfo)this.jdField_a_of_type_AndroidOsBundle.getParcelable("PhotoConst.SEND_SESSION_INFO");
      if (localSessionInfo != null) {
        m = localSessionInfo.a;
      }
      m = AIOShortVideoUtil.a(m);
    }
    return m;
  }
  
  private void c(Bundle paramBundle)
  {
    if (a() != null)
    {
      if (a().isFinishing()) {
        return;
      }
      this.jdField_g_of_type_JavaLangString = paramBundle.getString("topic_id");
      this.jdField_h_of_type_JavaLangString = paramBundle.getString("short_video_refer");
      this.jdField_a_of_type_ComTencentAelightCameraStructEditorFlowComponentInterface = ((FlowComponentInterface)((IQzoneVideoHelper)QRoute.api(IQzoneVideoHelper.class)).getVideoComponentCallback());
      this.jdField_a_of_type_ComTencentAelightCameraStructEditorFlowComponentInterface.setRefer(this.jdField_h_of_type_JavaLangString);
      this.jdField_d_of_type_JavaLangString = paramBundle.getString("confirm_text");
      this.jdField_h_of_type_Boolean = paramBundle.getBoolean("enable_priv_list", true);
      this.jdField_i_of_type_Boolean = paramBundle.getBoolean("enable_input_text", true);
      this.j = paramBundle.getBoolean("is_qzone_vip", false);
      this.k = paramBundle.getBoolean("enable_edit_video", false);
      this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo = ((QzoneVerticalVideoTopicInfo)paramBundle.getParcelable("key_qzone_topic"));
      this.jdField_i_of_type_Int = paramBundle.getInt("entry_source", 0);
    }
  }
  
  private void c(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "intentToEditVideoActivityFromQzone start!");
    }
    for (;;)
    {
      try
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("entrance_type", c());
        ((Bundle)localObject).putString("extra_publish_text", this.jdField_d_of_type_JavaLangString);
        ((Bundle)localObject).putBoolean("enable_hw_encode", true);
        int n = 1123;
        ((Bundle)localObject).putBoolean("extra_enable_revert", true);
        ((Bundle)localObject).putBoolean("extra_enable_slow", true);
        m = n;
        if (this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo != null)
        {
          m = n;
          if (this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.hasMusic()) {
            m = 1121;
          }
        }
        boolean bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("enable_edit_button", true);
        paramAEVideoCaptureResult = new EditTakeVideoSource(paramAEVideoCaptureResult.videoMp4FilePath, paramAEVideoCaptureResult.audioDataFilePath, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
        if (!bool) {
          break label520;
        }
        paramAEVideoCaptureResult = new EditVideoParams(3, m, paramAEVideoCaptureResult, (Bundle)localObject);
        paramAEVideoCaptureResult.jdField_a_of_type_AndroidOsBundle.putBoolean("enable_hw_encode", true);
        if (QLog.isColorLevel())
        {
          localObject = c;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("intentToEditVideoActivityFromQzone startActivityForResult---> EditVideoParams params:");
          localStringBuilder.append(paramAEVideoCaptureResult.toString());
          localStringBuilder.append(", recordFinish---startEdit");
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        if (a() != null)
        {
          if (a().isFinishing()) {
            return;
          }
          localObject = new Intent(a(), QzoneEditVideoActivity.class);
          ((Intent)localObject).putExtra(EditVideoParams.class.getName(), paramAEVideoCaptureResult);
          ((Intent)localObject).putExtra("key_font_id", this.jdField_f_of_type_Int);
          ((Intent)localObject).putExtra("op_department", "grp_qzone");
          ((Intent)localObject).putExtra("op_type", "video_edit");
          ((Intent)localObject).putExtra("topic_id", this.jdField_g_of_type_JavaLangString);
          ((Intent)localObject).putExtra("enable_priv_list", this.jdField_h_of_type_Boolean);
          ((Intent)localObject).putExtra("enable_input_text", this.jdField_i_of_type_Boolean);
          ((Intent)localObject).putExtra("stop_record_time", System.currentTimeMillis());
          ((Intent)localObject).putExtra("UseQQCameraCompression", QzoneConfig.getInstance().getConfig("PhotoAlbum", "UseQQCameraCompression", 2));
          ((Intent)localObject).putExtra("entry_source", this.jdField_a_of_type_AndroidOsBundle.getInt("entry_source", 0));
          ((Intent)localObject).putExtra("TAKE_DANCING_VIDEO", false);
          ((Intent)localObject).putExtra("key_qzone_topic", this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo);
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().startActivityForResult((Intent)localObject, 1011);
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().overridePendingTransition(0, 0);
          if (QLog.isColorLevel()) {
            QLog.d(c, 2, "intentToEditVideoActivityFromQzone ---> finish startActivityForResult");
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramAEVideoCaptureResult)
      {
        Object localObject = c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("intentToEditVideoActivityFromQzone exception:");
        localStringBuilder.append(paramAEVideoCaptureResult);
        QLog.e((String)localObject, 1, localStringBuilder.toString());
      }
      return;
      label520:
      int m = 0;
    }
  }
  
  private void f(int paramInt)
  {
    if (paramInt == 0)
    {
      t();
      return;
    }
    if (paramInt == -1) {
      u();
    }
  }
  
  private void s()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("videoThumb.jpg");
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      FileUtils.createDirectory(this.jdField_b_of_type_JavaLangString);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i(c, 2, "createDirectory error", localException);
      }
    }
    MediaUtil.a(this.jdField_a_of_type_ComTencentAelightCameraStructCameraAEVideoCaptureResult.videoMp4FilePath, (String)localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = new LocalMediaInfo();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.thumbnailPath = ((String)localObject);
  }
  
  private void t()
  {
    try
    {
      FileUtils.deleteDirectory(this.jdField_b_of_type_JavaLangString);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i(c, 2, "Delete file error", localException);
      }
    }
  }
  
  private void u()
  {
    if ((this.jdField_a_of_type_ComTencentAelightCameraStructCameraAEVideoCaptureResult != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo != null)) {
      a(this.jdField_a_of_type_ComTencentAelightCameraStructCameraAEVideoCaptureResult.audioDataFilePath, 0, this.jdField_a_of_type_ComTencentAelightCameraStructCameraAEVideoCaptureResult.videoMp4FilePath, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.thumbnailPath, null, (int)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration, this.jdField_a_of_type_ComTencentAelightCameraStructEditorFlowComponentInterface, null, -1, null, false, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, this.jdField_e_of_type_JavaLangString, this.jdField_h_of_type_Int, this.jdField_f_of_type_JavaLangString, false, false, false, false);
    }
  }
  
  public void W()
  {
    super.W();
  }
  
  public View a()
  {
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a() != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().getIntent() != null))
    {
      this.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().getIntent().getExtras();
      c(this.jdField_a_of_type_AndroidOsBundle);
    }
    return super.a();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a();
    if (localObject != null)
    {
      if (((Activity)localObject).isFinishing()) {
        return;
      }
      if (paramInt1 != 1011)
      {
        if (paramInt1 != 1012)
        {
          if (paramInt1 != 10001) {
            switch (paramInt1)
            {
            default: 
              break;
            case 1016: 
              f(paramInt2);
              break;
            case 1015: 
              b(paramInt2);
              break;
            case 1014: 
              a(paramInt2);
              break;
            }
          } else {
            b(paramIntent);
          }
        }
        else {
          a(paramInt2, paramIntent);
        }
      }
      else {
        b(paramInt2, paramIntent);
      }
      localObject = this.jdField_a_of_type_ComTencentAelightCameraStructEditorFlowComponentInterface;
      if (localObject != null) {
        ((FlowComponentInterface)localObject).onActivityResult(a(), paramInt1, paramInt2, paramIntent);
      }
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
      localIntent.putExtra("is_qzone_vip", this.j);
      localIntent.putExtra("param.topicId", this.jdField_g_of_type_JavaLangString);
      localIntent.putExtra("param.topicSyncQzone", false);
      localIntent.putExtra("extra_key_font_id", this.jdField_f_of_type_Int);
      localIntent.putExtra("extra_key_font_format_type", this.jdField_g_of_type_Int);
      localIntent.putExtra("extra_key_font_url", this.jdField_e_of_type_JavaLangString);
      localIntent.putExtra("extra_key_super_font_id", this.jdField_h_of_type_Int);
      localIntent.putExtra("extra_key_super_font_info", this.jdField_f_of_type_JavaLangString);
      localIntent.putExtra("short_video_refer", this.jdField_h_of_type_JavaLangString);
      localIntent.putExtra("set_user_callback", this.jdField_a_of_type_AndroidOsBundle.getString("set_user_callback"));
      localIntent.putExtra("key_qzone_topic", this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo);
      ThreadManager.getUIHandler().postDelayed(new AEPituQzoneCameraUnit.1(this, localIntent), 0L);
      return;
    }
    catch (Exception paramIntent)
    {
      if (QLog.isColorLevel()) {
        QLog.i(c, 2, "handleOnNewIntent error ", paramIntent);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
  }
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (this.k)
    {
      c(this.jdField_a_of_type_ComTencentAelightCameraStructCameraAEVideoCaptureResult);
      return;
    }
    b(this.jdField_a_of_type_ComTencentAelightCameraStructCameraAEVideoCaptureResult);
  }
  
  public void onPhotoCaptured(AEPhotoCaptureResult paramAEPhotoCaptureResult)
  {
    super.onPhotoCaptured(paramAEPhotoCaptureResult);
    if (this.jdField_i_of_type_Int != 3) {
      a(paramAEPhotoCaptureResult);
    }
  }
  
  public void onVideoCaptured(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    if (paramAEVideoCaptureResult != null) {}
    try
    {
      if (paramAEVideoCaptureResult.videoMp4FilePath != null)
      {
        this.jdField_a_of_type_ComTencentAelightCameraStructCameraAEVideoCaptureResult = paramAEVideoCaptureResult;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = new LocalMediaInfo();
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path = paramAEVideoCaptureResult.videoMp4FilePath;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mMimeType = "video";
        MediaScanner.getInstance(BaseApplicationImpl.getContext()).queryMediaInfoAsync(this, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
        return;
      }
      ToastUtil.a().a(HardCodeUtil.a(2131709793));
      if (a() != null) {
        a().finish();
      }
      return;
    }
    catch (Exception paramAEVideoCaptureResult)
    {
      QZLog.d(c, 2, "onVideoCaptured exception!", paramAEVideoCaptureResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.AEPituQzoneCameraUnit
 * JD-Core Version:    0.7.0.1
 */