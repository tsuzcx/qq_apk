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
  public static long F = -1L;
  private static final String ap = "AEPituQzoneCameraUnit";
  public boolean E = false;
  public long G = System.currentTimeMillis();
  public String H;
  private boolean aA;
  private boolean aB;
  private QzoneVerticalVideoTopicInfo aC;
  private String aD;
  private String aE;
  private int aF = 0;
  private FlowComponentInterface aG = null;
  private int aq = 10001;
  private Bundle ar;
  private String as;
  private int at = -1;
  private int au;
  private String av;
  private int aw;
  private String ax;
  private boolean ay;
  private boolean az;
  
  public AEPituQzoneCameraUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    super(paramIQIMCameraContainer, paramICameraEntrance);
    paramIQIMCameraContainer = new StringBuilder();
    paramIQIMCameraContainer.append(BaseApplicationImpl.getContext().getFilesDir().getPath());
    paramIQIMCameraContainer.append("/Android/data/com.tencent.mobileqq/qq/video/Source/");
    paramIQIMCameraContainer.append(this.G);
    this.H = paramIQIMCameraContainer.toString();
    this.r = new CaptureEntranceParams(10001, 122, 3);
    this.y = 12;
  }
  
  private int N()
  {
    int j = this.ar.getInt("entrance_type", 99);
    int i = j;
    if (j == 100)
    {
      i = 0;
      SessionInfo localSessionInfo = (SessionInfo)this.ar.getParcelable("PhotoConst.SEND_SESSION_INFO");
      if (localSessionInfo != null) {
        i = localSessionInfo.a;
      }
      i = AIOShortVideoUtil.a(i);
    }
    return i;
  }
  
  private void O()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.H);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("videoThumb.jpg");
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      FileUtils.createDirectory(this.H);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i(ap, 2, "createDirectory error", localException);
      }
    }
    MediaUtil.a(this.o.videoMp4FilePath, (String)localObject);
    if (this.q == null) {
      this.q = new LocalMediaInfo();
    }
    this.q.thumbnailPath = ((String)localObject);
  }
  
  private void P()
  {
    try
    {
      FileUtils.deleteDirectory(this.H);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i(ap, 2, "Delete file error", localException);
      }
    }
  }
  
  private void Q()
  {
    if ((this.o != null) && (this.q != null)) {
      a(this.o.audioDataFilePath, 0, this.o.videoMp4FilePath, this.q.thumbnailPath, null, (int)this.q.mDuration, this.aG, null, -1, null, false, this.at, this.au, this.av, this.aw, this.ax, false, false, false, false);
    }
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if (this.aF == 3)
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
        int i = paramIntent.getIntExtra("key_font_id", -1);
        this.au = paramIntent.getIntExtra("key_font_format_type", 0);
        this.av = paramIntent.getStringExtra("key_font_url");
        this.aw = paramIntent.getIntExtra("key_super_font_id", -1);
        this.ax = paramIntent.getStringExtra("key_super_font_info");
        localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        bool1 = paramIntent.getBooleanExtra("key_timer_delete", false);
        bool2 = paramIntent.getBooleanExtra("key_sync_to_qqstory", false);
        paramIntent = ap;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get mSetTimerDelete: ");
        localStringBuilder.append(bool1);
        QLog.i(paramIntent, 2, localStringBuilder.toString());
        QZoneHelper.publishPictureMoodSilently((String)localObject1, localArrayList, paramInt, (ArrayList)localObject2, i, this.au, this.av, bool1, bool2, i, this.ax);
        s().finish();
        return;
      }
      if (bool2)
      {
        s().setResult(-1, paramIntent);
        s().finish();
      }
    }
  }
  
  private void a(AEPhotoCaptureResult paramAEPhotoCaptureResult)
  {
    for (;;)
    {
      try
      {
        if (s() != null)
        {
          if (s().isFinishing()) {
            return;
          }
          if ((paramAEPhotoCaptureResult != null) && (!TextUtils.isEmpty(paramAEPhotoCaptureResult.filePath)))
          {
            Object localObject1;
            Object localObject2;
            if (QLog.isColorLevel())
            {
              localObject1 = ap;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("finishShotPhoto ");
              ((StringBuilder)localObject2).append(paramAEPhotoCaptureResult.filePath);
              QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
            }
            if (this.ar.getInt("edit_video_type", 0) != 10002)
            {
              bool1 = true;
              int i = this.ar.getInt("extra.busi_type", 2);
              boolean bool2 = this.ar.getBoolean("go_publish_activity", false);
              if (s() == null) {
                return;
              }
              if (i == 3)
              {
                double d1 = this.ar.getDouble("key_longtitude", 4.9E-324D);
                double d2 = this.ar.getDouble("key_latitude", 4.9E-324D);
                GpsComplementUtil.complementByLocal(paramAEPhotoCaptureResult.filePath, d1, d2);
              }
              if (bool2) {
                localObject1 = QzoneEditPictureActivity.a(s(), paramAEPhotoCaptureResult.filePath, bool1, i, N(), 0);
              } else {
                localObject1 = QzoneEditPictureActivity.a(s(), paramAEPhotoCaptureResult.filePath);
              }
              ((Intent)localObject1).putExtra("TEMP_PARAM", ((Intent)localObject1).getLongExtra("TEMP_PARAM", 0L) & 0xFFFFFFBF & 0xFFFFFF7F);
              ((Intent)localObject1).putExtra("go_publish_activity", bool2);
              ((Intent)localObject1).putExtra("extra_directly_back", this.ar.getBoolean("extra_directly_back", false));
              ((Intent)localObject1).putExtra("qcamera_photo_filepath", paramAEPhotoCaptureResult.filePath);
              ((Intent)localObject1).putExtra("qcamera_rotate", paramAEPhotoCaptureResult.orientation);
              ((Intent)localObject1).putExtra("PhotoConst.EDIT_COME_FROM_NEWFLOW", true);
              ((Intent)localObject1).putExtra("camera_type", 103);
              ((Intent)localObject1).putExtra("babyq_ability", this.ar.getLong("babyq_ability", 0L));
              if (this.ar.getInt("entry_source", 0) == 5) {
                ((Intent)localObject1).putExtra("pic_entrance_type", 13);
              }
              localObject2 = SplashActivity.class.getName();
              String str = this.ar.getString("f_a_a_n");
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
                ((Intent)localObject1).putExtra("extra_publish_text", this.b.getActivity().getString(2131893012));
              }
              ((Intent)localObject1).putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramAEPhotoCaptureResult);
              ((Intent)localObject1).putExtra("key_activity_code", this.ar.getString("key_activity_code"));
              this.b.getActivity().startActivityForResult((Intent)localObject1, 1012);
              FlowCameraMqqAction.a("", "0X80075C1", "", "", "", "");
            }
          }
          else
          {
            ToastUtil.a().a(HardCodeUtil.a(2131907515));
            s().finish();
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramAEPhotoCaptureResult)
      {
        QLog.d(ap, 2, "handlePic exception", paramAEPhotoCaptureResult);
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
    localVideoSendPublicParam.mContext = s();
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
    localVideoSendPublicParam.mEnableEditVideo = this.aB;
    localVideoSendPublicParam.topicId = this.aD;
    localVideoSendPublicParam.topicSyncQzone = paramBoolean1;
    localVideoSendPublicParam.fontId = paramInt4;
    localVideoSendPublicParam.fontFormatType = paramInt5;
    localVideoSendPublicParam.fontUrl = paramString6;
    localVideoSendPublicParam.superFontId = paramInt6;
    localVideoSendPublicParam.superFontInfo = paramString7;
    localVideoSendPublicParam.generateGif = paramBoolean2;
    localVideoSendPublicParam.timerDelete = paramBoolean3;
    localVideoSendPublicParam.qzoneVerticalVideoTopicInfo = this.aC;
    localVideoSendPublicParam.isUploadOrigin = paramBoolean5;
    localVideoSendPublicParam.entrySource = this.ar.getInt("entry_source", 0);
    localVideoSendPublicParam.mUin = "";
    localVideoSendPublicParam.mUinType = 0;
    localVideoSendPublicParam.mTroopUin = "";
    new MediaCodecSendTask(localVideoSendPublicParam).execute(new Void[0]);
  }
  
  private void b(int paramInt, Intent paramIntent)
  {
    if (paramInt == 0)
    {
      P();
      return;
    }
    if ((paramInt == -1) && (paramIntent != null))
    {
      Object localObject2 = paramIntent.getStringExtra("key_content");
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      int i = paramIntent.getIntExtra("key_priv", 1);
      Object localObject3 = (ArrayList)paramIntent.getSerializableExtra("key_priv_uin_list");
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new ArrayList();
      }
      int j = paramIntent.getIntExtra("key_font_id", -1);
      this.au = paramIntent.getIntExtra("key_font_format_type", 0);
      this.av = paramIntent.getStringExtra("key_font_url");
      this.aw = paramIntent.getIntExtra("key_super_font_id", -1);
      this.ax = paramIntent.getStringExtra("key_super_font_info");
      boolean bool1 = paramIntent.getBooleanExtra("key_generate_gif", false);
      boolean bool2 = paramIntent.getBooleanExtra("key_timer_delete", false);
      localObject3 = (PublishParam)paramIntent.getParcelableExtra(PublishParam.a);
      if (((PublishParam)localObject3).n <= 5) {
        paramInt = ((PublishParam)localObject3).n;
      } else {
        paramInt = 0;
      }
      int k = (int)((PublishParam)localObject3).j;
      boolean bool3 = paramIntent.getBooleanExtra("param.isUploadOrigin", false);
      a(((PublishParam)localObject3).u, paramInt, ((PublishParam)localObject3).t, ((PublishParam)localObject3).c, ((PublishParam)localObject3).b, k, this.aG, (String)localObject1, i, (ArrayList)localObject2, false, j, this.au, this.av, this.aw, this.ax, bool1, bool2, false, bool3);
    }
  }
  
  private void b(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("key_font_id", -1);
      int j = paramIntent.getIntExtra("key_font_format_type", 0);
      String str1 = paramIntent.getStringExtra("key_font_url");
      int k = paramIntent.getIntExtra("key_super_font_id", -1);
      String str2 = paramIntent.getStringExtra("key_super_font_info");
      paramIntent = (PublishParam)paramIntent.getParcelableExtra(PublishParam.a);
      if (paramIntent == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQAlbum", 2, "handleQzoneEditVideoResult: publishParam == null");
        }
        return;
      }
      a(this.o.audioDataFilePath, 0, this.o.videoMp4FilePath, paramIntent.c, null, (int)paramIntent.j, this.aG, null, -1, null, false, i, j, str1, k, str2, false, false, false, false);
    }
  }
  
  private void b(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    O();
    if (s() != null)
    {
      Intent localIntent = new Intent(s(), PreviewVideoActivity.class);
      localIntent.putExtra("from_qzone_camera", true);
      localIntent.putExtra("video_path", paramAEVideoCaptureResult.videoMp4FilePath);
      localIntent.putExtra("audio_path", paramAEVideoCaptureResult.audioDataFilePath);
      this.b.getActivity().startActivityForResult(localIntent, 1016);
    }
  }
  
  private void c(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    if (paramInt == -1)
    {
      QLog.i(ap, 2, "REQ_PREVIEW_EDIT_GIF_ACTIVITY result ok");
      s().finish();
    }
  }
  
  private void c(Bundle paramBundle)
  {
    if (s() != null)
    {
      if (s().isFinishing()) {
        return;
      }
      this.aD = paramBundle.getString("topic_id");
      this.aE = paramBundle.getString("short_video_refer");
      this.aG = ((FlowComponentInterface)((IQzoneVideoHelper)QRoute.api(IQzoneVideoHelper.class)).getVideoComponentCallback());
      this.aG.setRefer(this.aE);
      this.as = paramBundle.getString("confirm_text");
      this.ay = paramBundle.getBoolean("enable_priv_list", true);
      this.az = paramBundle.getBoolean("enable_input_text", true);
      this.aA = paramBundle.getBoolean("is_qzone_vip", false);
      this.aB = paramBundle.getBoolean("enable_edit_video", false);
      this.aC = ((QzoneVerticalVideoTopicInfo)paramBundle.getParcelable("key_qzone_topic"));
      this.aF = paramBundle.getInt("entry_source", 0);
    }
  }
  
  private void c(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ap, 2, "intentToEditVideoActivityFromQzone start!");
    }
    for (;;)
    {
      try
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("entrance_type", N());
        ((Bundle)localObject).putString("extra_publish_text", this.as);
        ((Bundle)localObject).putBoolean("enable_hw_encode", true);
        int j = 1123;
        ((Bundle)localObject).putBoolean("extra_enable_revert", true);
        ((Bundle)localObject).putBoolean("extra_enable_slow", true);
        i = j;
        if (this.aC != null)
        {
          i = j;
          if (this.aC.hasMusic()) {
            i = 1121;
          }
        }
        boolean bool = this.ar.getBoolean("enable_edit_button", true);
        paramAEVideoCaptureResult = new EditTakeVideoSource(paramAEVideoCaptureResult.videoMp4FilePath, paramAEVideoCaptureResult.audioDataFilePath, this.q);
        if (!bool) {
          break label519;
        }
        paramAEVideoCaptureResult = new EditVideoParams(3, i, paramAEVideoCaptureResult, (Bundle)localObject);
        paramAEVideoCaptureResult.d.putBoolean("enable_hw_encode", true);
        if (QLog.isColorLevel())
        {
          localObject = ap;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("intentToEditVideoActivityFromQzone startActivityForResult---> EditVideoParams params:");
          localStringBuilder.append(paramAEVideoCaptureResult.toString());
          localStringBuilder.append(", recordFinish---startEdit");
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        if (s() != null)
        {
          if (s().isFinishing()) {
            return;
          }
          localObject = new Intent(s(), QzoneEditVideoActivity.class);
          ((Intent)localObject).putExtra(EditVideoParams.class.getName(), paramAEVideoCaptureResult);
          ((Intent)localObject).putExtra("key_font_id", this.at);
          ((Intent)localObject).putExtra("op_department", "grp_qzone");
          ((Intent)localObject).putExtra("op_type", "video_edit");
          ((Intent)localObject).putExtra("topic_id", this.aD);
          ((Intent)localObject).putExtra("enable_priv_list", this.ay);
          ((Intent)localObject).putExtra("enable_input_text", this.az);
          ((Intent)localObject).putExtra("stop_record_time", System.currentTimeMillis());
          ((Intent)localObject).putExtra("UseQQCameraCompression", QzoneConfig.getInstance().getConfig("PhotoAlbum", "UseQQCameraCompression", 2));
          ((Intent)localObject).putExtra("entry_source", this.ar.getInt("entry_source", 0));
          ((Intent)localObject).putExtra("TAKE_DANCING_VIDEO", false);
          ((Intent)localObject).putExtra("key_qzone_topic", this.aC);
          this.b.getActivity().startActivityForResult((Intent)localObject, 1011);
          this.b.getActivity().overridePendingTransition(0, 0);
          if (QLog.isColorLevel()) {
            QLog.d(ap, 2, "intentToEditVideoActivityFromQzone ---> finish startActivityForResult");
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramAEVideoCaptureResult)
      {
        Object localObject = ap;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("intentToEditVideoActivityFromQzone exception:");
        localStringBuilder.append(paramAEVideoCaptureResult);
        QLog.e((String)localObject, 1, localStringBuilder.toString());
      }
      return;
      label519:
      int i = 0;
    }
  }
  
  private void d(int paramInt)
  {
    if ((paramInt == -1) && (s() != null))
    {
      if (s().isFinishing()) {
        return;
      }
      s().finish();
    }
  }
  
  private void h(int paramInt)
  {
    if (paramInt == 0)
    {
      P();
      return;
    }
    if (paramInt == -1) {
      Q();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = this.b.getActivity();
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
              h(paramInt2);
              break;
            case 1015: 
              d(paramInt2);
              break;
            case 1014: 
              c(paramInt2);
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
      localObject = this.aG;
      if (localObject != null) {
        ((FlowComponentInterface)localObject).onActivityResult(s(), paramInt1, paramInt2, paramIntent);
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
      localIntent.putExtra("is_qzone_vip", this.aA);
      localIntent.putExtra("param.topicId", this.aD);
      localIntent.putExtra("param.topicSyncQzone", false);
      localIntent.putExtra("extra_key_font_id", this.at);
      localIntent.putExtra("extra_key_font_format_type", this.au);
      localIntent.putExtra("extra_key_font_url", this.av);
      localIntent.putExtra("extra_key_super_font_id", this.aw);
      localIntent.putExtra("extra_key_super_font_info", this.ax);
      localIntent.putExtra("short_video_refer", this.aE);
      localIntent.putExtra("set_user_callback", this.ar.getString("set_user_callback"));
      localIntent.putExtra("key_qzone_topic", this.aC);
      ThreadManager.getUIHandler().postDelayed(new AEPituQzoneCameraUnit.1(this, localIntent), 0L);
      return;
    }
    catch (Exception paramIntent)
    {
      if (QLog.isColorLevel()) {
        QLog.i(ap, 2, "handleOnNewIntent error ", paramIntent);
      }
    }
  }
  
  public void aB()
  {
    super.aB();
  }
  
  public View j()
  {
    if ((this.b != null) && (this.b.getActivity() != null) && (this.b.getActivity().getIntent() != null))
    {
      this.ar = this.b.getActivity().getIntent().getExtras();
      c(this.ar);
    }
    return super.j();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
  }
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (this.aB)
    {
      c(this.o);
      return;
    }
    b(this.o);
  }
  
  public void onPhotoCaptured(AEPhotoCaptureResult paramAEPhotoCaptureResult)
  {
    super.onPhotoCaptured(paramAEPhotoCaptureResult);
    if (this.aF != 3) {
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
        this.o = paramAEVideoCaptureResult;
        this.q = new LocalMediaInfo();
        this.q.path = paramAEVideoCaptureResult.videoMp4FilePath;
        this.q.mMimeType = "video";
        MediaScanner.getInstance(BaseApplicationImpl.getContext()).queryMediaInfoAsync(this, this.q);
        return;
      }
      ToastUtil.a().a(HardCodeUtil.a(2131907513));
      if (s() != null) {
        s().finish();
      }
      return;
    }
    catch (Exception paramAEVideoCaptureResult)
    {
      QZLog.d(ap, 2, "onVideoCaptured exception!", paramAEVideoCaptureResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.AEPituQzoneCameraUnit
 * JD-Core Version:    0.7.0.1
 */