package com.tencent.aelight.camera.aioeditor;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.qq.taf.jce.HexUtil;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.PublishVideoSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.VideoSendPublicParam;
import com.tencent.aelight.camera.struct.editor.FlowComponentInterface;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils;
import com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils.MetaData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

public class MediaCodecSendTask
  extends AsyncTask<Void, Void, Integer>
{
  private static AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoSendPublicParam jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam;
  private MediaMetadataUtils.MetaData jdField_a_of_type_ComTencentMobileqqShortvideoUtilMediaMetadataUtils$MetaData = new MediaMetadataUtils.MetaData();
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e = "";
  
  public MediaCodecSendTask(VideoSendPublicParam paramVideoSendPublicParam)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam = paramVideoSendPublicParam;
    this.jdField_a_of_type_Long = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndIncrement();
    paramVideoSendPublicParam = new StringBuilder();
    paramVideoSendPublicParam.append("MediaCodecSendTask_[mSessionId=");
    paramVideoSendPublicParam.append(this.jdField_a_of_type_Long);
    paramVideoSendPublicParam.append("]");
    this.e = paramVideoSendPublicParam.toString();
  }
  
  private int a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mVideoCacheDir;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("cacheDir=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    a(((StringBuilder)localObject).toString(), null);
    if (!FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mVideoFilePath))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("video file empty! path=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mVideoFilePath);
      a(((StringBuilder)localObject).toString(), null);
      return -300;
    }
    if (!FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mThumbFilePath))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("thumb file empty! path=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mThumbFilePath);
      a(((StringBuilder)localObject).toString(), null);
      return -301;
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mContext.getIntent();
    this.jdField_b_of_type_Int = ((Intent)localObject).getIntExtra("param_entrance", 0);
    this.c = ((Intent)localObject).getStringExtra("bless_ptv_mp4_path");
    this.d = ((Intent)localObject).getStringExtra("fake_id");
    int i = MediaMetadataUtils.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mVideoFilePath, this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilMediaMetadataUtils$MetaData);
    if (i != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MediaMetadataUtils: errCode=");
      ((StringBuilder)localObject).append(i);
      a(((StringBuilder)localObject).toString(), null);
      return i;
    }
    if (((Intent)localObject).getBooleanExtra("from_qzone_slideshow", false))
    {
      i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.recordTime;
    }
    else
    {
      i = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilMediaMetadataUtils$MetaData.a[3];
      i = (int)PublishVideoSegment.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mEncodeMode, i);
    }
    this.jdField_a_of_type_Int = ((i + 500) / 1000);
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mThumbWidth <= 0) || (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mThumbHeight <= 0))
    {
      i = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilMediaMetadataUtils$MetaData.a[2];
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mThumbWidth = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilMediaMetadataUtils$MetaData.a[0];
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mThumbHeight = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilMediaMetadataUtils$MetaData.a[1];
      if ((i == 90) || (i == 270))
      {
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam;
        ((VideoSendPublicParam)localObject).mThumbWidth = ((VideoSendPublicParam)localObject).mThumbHeight;
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mThumbHeight = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilMediaMetadataUtils$MetaData.a[0];
      }
    }
    return b();
  }
  
  private void a()
  {
    a("cancelProgressDialog", null);
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null)
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
        this.jdField_a_of_type_AndroidAppProgressDialog = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void a(Context paramContext, int paramInt)
  {
    a("showProgressDialog", null);
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null)
      {
        a();
      }
      else
      {
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(paramContext, 2131756189);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559561);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131372646));
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
      if (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
      }
    }
    catch (Throwable paramContext)
    {
      a("showProgressDialog", paramContext);
    }
  }
  
  private void a(String paramString, Throwable paramThrowable)
  {
    if (paramThrowable != null)
    {
      localObject = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[@] ");
      localStringBuilder.append(paramString);
      QLog.i((String)localObject, 1, localStringBuilder.toString(), paramThrowable);
      return;
    }
    paramThrowable = this.e;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[@] ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i(paramThrowable, 1, ((StringBuilder)localObject).toString());
  }
  
  private int b()
  {
    ImageUtil.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mThumbFilePath, this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mLatitude, this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mLongitude);
    Object localObject = new File(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mThumbFilePath);
    try
    {
      localFileInputStream = new FileInputStream(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mThumbFilePath);
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      FileInputStream localFileInputStream;
      label73:
      String str;
      break label73;
    }
    try
    {
      this.jdField_b_of_type_JavaLangString = HexUtil.bytes2HexStr(MD5.toMD5Byte(localFileInputStream, ((File)localObject).length()));
    }
    catch (FileNotFoundException localFileNotFoundException2)
    {
      break label75;
    }
    localFileInputStream = null;
    label75:
    if (localFileInputStream != null) {
      try
      {
        localFileInputStream.close();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      a("doInBackground(), mTempMd5 is empty", null);
      return -302;
    }
    str = SVUtils.a(this.jdField_b_of_type_JavaLangString, "jpg");
    if (FileUtils.moveFile(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mThumbFilePath, str))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mThumbFilePath = str;
    }
    else if (!FileUtils.fileExistsAndNotEmpty(str))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doInBackground(), rename failure, mThumbFilePath = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mThumbFilePath);
      ((StringBuilder)localObject).append(",thumbPath=");
      ((StringBuilder)localObject).append(str);
      a(((StringBuilder)localObject).toString(), null);
      return -301;
    }
    return 0;
  }
  
  private void b(Intent paramIntent)
  {
    paramIntent.putExtra("mediacodec_encode_enable", true);
    paramIntent.putExtra("PhotoConst.IS_VIDEO_RECORDED", true);
    paramIntent.putExtra("file_video_source_dir", this.jdField_a_of_type_JavaLangString);
    paramIntent.putExtra("thumbfile_send_path", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mThumbFilePath);
    paramIntent.putExtra("thumbfile_send_width", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mThumbWidth);
    paramIntent.putExtra("thumbfile_send_height", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mThumbHeight);
    paramIntent.putExtra("thumbfile_md5", this.jdField_b_of_type_JavaLangString);
    paramIntent.putExtra("file_send_duration", this.jdField_a_of_type_Int * 1000);
    paramIntent.putExtra("need_process", true);
    paramIntent.putExtra("PhotoConst.VIDEO_TYPE", 0);
    paramIntent.putExtra("video_new_fake_vid", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.fakeVid);
    paramIntent.putExtra("video_is_generate_gif", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.generateGif);
    paramIntent.putExtra("video_mood_timer_delete", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.timerDelete);
    paramIntent.putExtra("extra_directly_back", true);
    Bundle localBundle = new Bundle();
    localBundle.putInt("sv_encode_max_bitrate", CodecParam.mMaxrate);
    localBundle.putInt("sv_encode_min_bitrate", CodecParam.mMinrate);
    localBundle.putInt("sv_total_record_time", this.jdField_a_of_type_Int);
    paramIntent.putExtra("encode_video_params", localBundle);
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    long l = System.currentTimeMillis();
    int i = a();
    if (i != 0) {
      return Integer.valueOf(i);
    }
    paramVarArgs = new StringBuilder();
    paramVarArgs.append("doInBackground total:time=");
    double d1 = System.currentTimeMillis() - l;
    Double.isNaN(d1);
    paramVarArgs.append(d1 / 1000.0D);
    a(paramVarArgs.toString(), null);
    return Integer.valueOf(0);
  }
  
  void a(Intent paramIntent)
  {
    paramIntent.putExtra("mediacodec_encode_enable", true);
    paramIntent.putExtra("file_video_source_dir", this.jdField_a_of_type_JavaLangString);
    paramIntent.putExtra("thumbfile_send_path", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mThumbFilePath);
    paramIntent.putExtra("thumbfile_send_width", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mThumbWidth);
    paramIntent.putExtra("thumbfile_send_height", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mThumbHeight);
    paramIntent.putExtra("thumbfile_md5", this.jdField_b_of_type_JavaLangString);
    paramIntent.putExtra("file_send_duration", this.jdField_a_of_type_Int);
    paramIntent.putExtra("sv_total_record_time", this.jdField_a_of_type_Int);
    paramIntent.putExtra("video_mood_content", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mContent);
    paramIntent.putExtra("video_mood_priv", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mPriv);
    paramIntent.putExtra("video_mood_privUinList", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mPrivUinList);
    paramIntent.putExtra("enable_edit_video", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mEnableEditVideo);
    paramIntent.putExtra("video_topic_id", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.topicId);
    paramIntent.putExtra("video_topic_sync_qzone", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.topicSyncQzone);
    paramIntent.putExtra("video_new_fake_vid", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.fakeVid);
    paramIntent.putExtra("video_is_generate_gif", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.generateGif);
    paramIntent.putExtra("video_mood_timer_delete", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.timerDelete);
    paramIntent.putExtra("qzone_video_topic", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.qzoneVerticalVideoTopicInfo);
    paramIntent.putExtra("param.isUploadOrigin", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.isUploadOrigin);
    paramIntent.putExtra("extra_key_font_id", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.fontId);
    paramIntent.putExtra("extra_key_font_format_type", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.fontFormatType);
    paramIntent.putExtra("extra_key_font_url", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.fontUrl);
    paramIntent.putExtra("extra_key_super_font_id", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.superFontId);
    paramIntent.putExtra("extra_key_super_font_info", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.superFontInfo);
    paramIntent.putExtra("sv_encode_max_bitrate", CodecParam.mMaxrate);
    paramIntent.putExtra("sv_encode_min_bitrate", CodecParam.mMinrate);
    String str = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mContext.getIntent().getStringExtra("forward_source_to_qzone");
    if (!TextUtils.isEmpty(str)) {
      paramIntent.putExtra("forward_source_to_qzone", str);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.templateId))
    {
      paramIntent.putExtra("widgetinfo", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.templateId);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.templateName)) {
        paramIntent.putExtra("key_camera_material_name", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.templateName);
      }
    }
  }
  
  protected void a(Integer paramInteger)
  {
    a();
    int j = paramInteger.intValue();
    int i = 0;
    Object localObject;
    if (j == 0)
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.entrySource == 3)
      {
        paramInteger = new Intent(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mContext.getIntent());
        b(paramInteger);
        paramInteger.setFlags(536870912);
        if (paramInteger.getStringExtra("qzone_plugin_activity_name") == null) {
          QzonePluginProxyActivity.setActivityNameToIntent(paramInteger, "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
        }
        QZoneHelper.launchQZone(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mContext, "", paramInteger, -1);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mContext.finish();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mContext = null;
        return;
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.entrySource == 5)
      {
        paramInteger = new Intent(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mContext.getIntent());
        b(paramInteger);
        paramInteger.setClass(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mContext, NewPhotoListActivity.class);
        paramInteger.addFlags(603979776);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mContext.startActivity(paramInteger);
        return;
      }
      paramInteger = new Intent();
      a(paramInteger);
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mUserCallBack != null)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mUserCallBack.sendClick(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mContext, paramInteger);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mContext.finish();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mContext = null;
        return;
      }
      paramInteger.putExtra("uin", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mUin);
      paramInteger.putExtra("uintype", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mUinType);
      paramInteger.putExtra("troop_uin", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mTroopUin);
      paramInteger.putExtra("file_send_business_type", 2);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPostExecute(), MediaCodecSendTask is to start  SendVideoActivity,mVideoCacheDir = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      a(((StringBuilder)localObject).toString(), null);
      paramInteger.putExtra("ab_test_send_btn_click_time", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mContext.getIntent().getLongExtra("ab_test_send_btn_click_time", 0L));
      if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mUin != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mUin.equals(MessageForBlessPTV.BLESS_REQ_UIN)))
      {
        paramInteger.putExtra("bless_ptv_mp4_path", this.c);
        paramInteger.putExtra("param_type", 9003);
        paramInteger.putExtra("param_only_friends", true);
        paramInteger.putExtra("param_donot_need_contacts", true);
        paramInteger.putExtra("param_title", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mContext.getString(2131690668));
        paramInteger.putExtra("param_done_button_wording", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mContext.getString(2131691064));
        paramInteger.putExtra("param_exit_animation", 1);
        paramInteger.putExtra("param_entrance", this.jdField_b_of_type_Int);
        paramInteger.putExtra("param_blesstype", 2);
        paramInteger.putExtra("encode_type", 1);
        paramInteger.putExtra("fake_id", this.d);
        ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startBlessSelectMemberActivityForResult(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mContext, paramInteger, 10007);
        i = 1;
      }
      else
      {
        paramInteger.setClass(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mContext, SendVideoActivity.class);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mContext.startActivity(paramInteger);
      }
    }
    else
    {
      QQToast.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mContext, HardCodeUtil.a(2131706553), 0).b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mContext.getResources().getDimensionPixelSize(2131299168));
      localObject = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInteger);
      QLog.e((String)localObject, 1, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPostExecute(), MediaCodecSendTask error = ");
      ((StringBuilder)localObject).append(paramInteger);
      a(((StringBuilder)localObject).toString(), null);
    }
    if (i == 0) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mContext.finish();
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mContext = null;
  }
  
  protected void onPreExecute()
  {
    a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishVideoSendPublicParam.mContext, 2131694878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.MediaCodecSendTask
 * JD-Core Version:    0.7.0.1
 */