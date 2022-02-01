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
  private static AtomicLong i = new AtomicLong(0L);
  private int a;
  private String b;
  private String c;
  private String d;
  private int e;
  private String f;
  private VideoSendPublicParam g;
  private MediaMetadataUtils.MetaData h = new MediaMetadataUtils.MetaData();
  private long j = 0L;
  private String k = "";
  private ProgressDialog l;
  private TextView m;
  
  public MediaCodecSendTask(VideoSendPublicParam paramVideoSendPublicParam)
  {
    this.g = paramVideoSendPublicParam;
    this.j = i.getAndIncrement();
    paramVideoSendPublicParam = new StringBuilder();
    paramVideoSendPublicParam.append("MediaCodecSendTask_[mSessionId=");
    paramVideoSendPublicParam.append(this.j);
    paramVideoSendPublicParam.append("]");
    this.k = paramVideoSendPublicParam.toString();
  }
  
  private int a()
  {
    this.b = this.g.mVideoCacheDir;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("cacheDir=");
    ((StringBuilder)localObject).append(this.b);
    a(((StringBuilder)localObject).toString(), null);
    if (!FileUtils.fileExistsAndNotEmpty(this.g.mVideoFilePath))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("video file empty! path=");
      ((StringBuilder)localObject).append(this.g.mVideoFilePath);
      a(((StringBuilder)localObject).toString(), null);
      return -300;
    }
    if (!FileUtils.fileExistsAndNotEmpty(this.g.mThumbFilePath))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("thumb file empty! path=");
      ((StringBuilder)localObject).append(this.g.mThumbFilePath);
      a(((StringBuilder)localObject).toString(), null);
      return -301;
    }
    localObject = this.g.mContext.getIntent();
    this.e = ((Intent)localObject).getIntExtra("param_entrance", 0);
    this.d = ((Intent)localObject).getStringExtra("bless_ptv_mp4_path");
    this.f = ((Intent)localObject).getStringExtra("fake_id");
    int n = MediaMetadataUtils.a(this.g.mVideoFilePath, this.h);
    if (n != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MediaMetadataUtils: errCode=");
      ((StringBuilder)localObject).append(n);
      a(((StringBuilder)localObject).toString(), null);
      return n;
    }
    if (((Intent)localObject).getBooleanExtra("from_qzone_slideshow", false))
    {
      n = this.g.recordTime;
    }
    else
    {
      n = this.h.a[3];
      n = (int)PublishVideoSegment.a(this.g.mEncodeMode, n);
    }
    this.a = ((n + 500) / 1000);
    if ((this.g.mThumbWidth <= 0) || (this.g.mThumbHeight <= 0))
    {
      n = this.h.a[2];
      this.g.mThumbWidth = this.h.a[0];
      this.g.mThumbHeight = this.h.a[1];
      if ((n == 90) || (n == 270))
      {
        localObject = this.g;
        ((VideoSendPublicParam)localObject).mThumbWidth = ((VideoSendPublicParam)localObject).mThumbHeight;
        this.g.mThumbHeight = this.h.a[0];
      }
    }
    return b();
  }
  
  private void a(Context paramContext, int paramInt)
  {
    a("showProgressDialog", null);
    try
    {
      if (this.l != null)
      {
        c();
      }
      else
      {
        this.l = new ProgressDialog(paramContext, 2131953338);
        this.l.setCancelable(true);
        this.l.show();
        this.l.setContentView(2131625585);
        this.m = ((TextView)this.l.findViewById(2131440191));
      }
      this.m.setText(paramInt);
      if (!this.l.isShowing())
      {
        this.l.show();
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
      localObject = this.k;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[@] ");
      localStringBuilder.append(paramString);
      QLog.i((String)localObject, 1, localStringBuilder.toString(), paramThrowable);
      return;
    }
    paramThrowable = this.k;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[@] ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i(paramThrowable, 1, ((StringBuilder)localObject).toString());
  }
  
  private int b()
  {
    ImageUtil.a(this.g.mThumbFilePath, this.g.mLatitude, this.g.mLongitude);
    Object localObject = new File(this.g.mThumbFilePath);
    try
    {
      localFileInputStream = new FileInputStream(this.g.mThumbFilePath);
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
      this.c = HexUtil.bytes2HexStr(MD5.toMD5Byte(localFileInputStream, ((File)localObject).length()));
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
    if (TextUtils.isEmpty(this.c))
    {
      a("doInBackground(), mTempMd5 is empty", null);
      return -302;
    }
    str = SVUtils.a(this.c, "jpg");
    if (FileUtils.moveFile(this.g.mThumbFilePath, str))
    {
      this.g.mThumbFilePath = str;
    }
    else if (!FileUtils.fileExistsAndNotEmpty(str))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doInBackground(), rename failure, mThumbFilePath = ");
      ((StringBuilder)localObject).append(this.g.mThumbFilePath);
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
    paramIntent.putExtra("file_video_source_dir", this.b);
    paramIntent.putExtra("thumbfile_send_path", this.g.mThumbFilePath);
    paramIntent.putExtra("thumbfile_send_width", this.g.mThumbWidth);
    paramIntent.putExtra("thumbfile_send_height", this.g.mThumbHeight);
    paramIntent.putExtra("thumbfile_md5", this.c);
    paramIntent.putExtra("file_send_duration", this.a * 1000);
    paramIntent.putExtra("need_process", true);
    paramIntent.putExtra("PhotoConst.VIDEO_TYPE", 0);
    paramIntent.putExtra("video_new_fake_vid", this.g.fakeVid);
    paramIntent.putExtra("video_is_generate_gif", this.g.generateGif);
    paramIntent.putExtra("video_mood_timer_delete", this.g.timerDelete);
    paramIntent.putExtra("extra_directly_back", true);
    Bundle localBundle = new Bundle();
    localBundle.putInt("sv_encode_max_bitrate", CodecParam.mMaxrate);
    localBundle.putInt("sv_encode_min_bitrate", CodecParam.mMinrate);
    localBundle.putInt("sv_total_record_time", this.a);
    paramIntent.putExtra("encode_video_params", localBundle);
  }
  
  private void c()
  {
    a("cancelProgressDialog", null);
    try
    {
      if (this.l != null)
      {
        this.l.cancel();
        this.l = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    long l1 = System.currentTimeMillis();
    int n = a();
    if (n != 0) {
      return Integer.valueOf(n);
    }
    paramVarArgs = new StringBuilder();
    paramVarArgs.append("doInBackground total:time=");
    double d1 = System.currentTimeMillis() - l1;
    Double.isNaN(d1);
    paramVarArgs.append(d1 / 1000.0D);
    a(paramVarArgs.toString(), null);
    return Integer.valueOf(0);
  }
  
  void a(Intent paramIntent)
  {
    paramIntent.putExtra("mediacodec_encode_enable", true);
    paramIntent.putExtra("file_video_source_dir", this.b);
    paramIntent.putExtra("thumbfile_send_path", this.g.mThumbFilePath);
    paramIntent.putExtra("thumbfile_send_width", this.g.mThumbWidth);
    paramIntent.putExtra("thumbfile_send_height", this.g.mThumbHeight);
    paramIntent.putExtra("thumbfile_md5", this.c);
    paramIntent.putExtra("file_send_duration", this.a);
    paramIntent.putExtra("sv_total_record_time", this.a);
    paramIntent.putExtra("video_mood_content", this.g.mContent);
    paramIntent.putExtra("video_mood_priv", this.g.mPriv);
    paramIntent.putExtra("video_mood_privUinList", this.g.mPrivUinList);
    paramIntent.putExtra("enable_edit_video", this.g.mEnableEditVideo);
    paramIntent.putExtra("video_topic_id", this.g.topicId);
    paramIntent.putExtra("video_topic_sync_qzone", this.g.topicSyncQzone);
    paramIntent.putExtra("video_new_fake_vid", this.g.fakeVid);
    paramIntent.putExtra("video_is_generate_gif", this.g.generateGif);
    paramIntent.putExtra("video_mood_timer_delete", this.g.timerDelete);
    paramIntent.putExtra("qzone_video_topic", this.g.qzoneVerticalVideoTopicInfo);
    paramIntent.putExtra("param.isUploadOrigin", this.g.isUploadOrigin);
    paramIntent.putExtra("extra_key_font_id", this.g.fontId);
    paramIntent.putExtra("extra_key_font_format_type", this.g.fontFormatType);
    paramIntent.putExtra("extra_key_font_url", this.g.fontUrl);
    paramIntent.putExtra("extra_key_super_font_id", this.g.superFontId);
    paramIntent.putExtra("extra_key_super_font_info", this.g.superFontInfo);
    paramIntent.putExtra("sv_encode_max_bitrate", CodecParam.mMaxrate);
    paramIntent.putExtra("sv_encode_min_bitrate", CodecParam.mMinrate);
    String str = this.g.mContext.getIntent().getStringExtra("forward_source_to_qzone");
    if (!TextUtils.isEmpty(str)) {
      paramIntent.putExtra("forward_source_to_qzone", str);
    }
    if (!TextUtils.isEmpty(this.g.templateId))
    {
      paramIntent.putExtra("widgetinfo", this.g.templateId);
      if (!TextUtils.isEmpty(this.g.templateName)) {
        paramIntent.putExtra("key_camera_material_name", this.g.templateName);
      }
    }
  }
  
  protected void a(Integer paramInteger)
  {
    c();
    int i1 = paramInteger.intValue();
    int n = 0;
    Object localObject;
    if (i1 == 0)
    {
      if (this.g.entrySource == 3)
      {
        paramInteger = new Intent(this.g.mContext.getIntent());
        b(paramInteger);
        paramInteger.setFlags(536870912);
        if (paramInteger.getStringExtra("qzone_plugin_activity_name") == null) {
          QzonePluginProxyActivity.setActivityNameToIntent(paramInteger, "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
        }
        QZoneHelper.launchQZone(this.g.mContext, "", paramInteger, -1);
        this.g.mContext.finish();
        this.g.mContext = null;
        return;
      }
      if (this.g.entrySource == 5)
      {
        paramInteger = new Intent(this.g.mContext.getIntent());
        b(paramInteger);
        paramInteger.setClass(this.g.mContext, NewPhotoListActivity.class);
        paramInteger.addFlags(603979776);
        this.g.mContext.startActivity(paramInteger);
        return;
      }
      paramInteger = new Intent();
      a(paramInteger);
      if (this.g.mUserCallBack != null)
      {
        this.g.mUserCallBack.sendClick(this.g.mContext, paramInteger);
        this.g.mContext.finish();
        this.g.mContext = null;
        return;
      }
      paramInteger.putExtra("uin", this.g.mUin);
      paramInteger.putExtra("uintype", this.g.mUinType);
      paramInteger.putExtra("troop_uin", this.g.mTroopUin);
      paramInteger.putExtra("file_send_business_type", 2);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPostExecute(), MediaCodecSendTask is to start  SendVideoActivity,mVideoCacheDir = ");
      ((StringBuilder)localObject).append(this.b);
      a(((StringBuilder)localObject).toString(), null);
      paramInteger.putExtra("ab_test_send_btn_click_time", this.g.mContext.getIntent().getLongExtra("ab_test_send_btn_click_time", 0L));
      if ((this.g.mUin != null) && (this.g.mUin.equals(MessageForBlessPTV.BLESS_REQ_UIN)))
      {
        paramInteger.putExtra("bless_ptv_mp4_path", this.d);
        paramInteger.putExtra("param_type", 9003);
        paramInteger.putExtra("param_only_friends", true);
        paramInteger.putExtra("param_donot_need_contacts", true);
        paramInteger.putExtra("param_title", this.g.mContext.getString(2131887583));
        paramInteger.putExtra("param_done_button_wording", this.g.mContext.getString(2131888010));
        paramInteger.putExtra("param_exit_animation", 1);
        paramInteger.putExtra("param_entrance", this.e);
        paramInteger.putExtra("param_blesstype", 2);
        paramInteger.putExtra("encode_type", 1);
        paramInteger.putExtra("fake_id", this.f);
        ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startBlessSelectMemberActivityForResult(this.g.mContext, paramInteger, 10007);
        n = 1;
      }
      else
      {
        paramInteger.setClass(this.g.mContext, SendVideoActivity.class);
        this.g.mContext.startActivity(paramInteger);
      }
    }
    else
    {
      QQToast.makeText(this.g.mContext, HardCodeUtil.a(2131904409), 0).show(this.g.mContext.getResources().getDimensionPixelSize(2131299920));
      localObject = this.k;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInteger);
      QLog.e((String)localObject, 1, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPostExecute(), MediaCodecSendTask error = ");
      ((StringBuilder)localObject).append(paramInteger);
      a(((StringBuilder)localObject).toString(), null);
    }
    if (n == 0) {
      this.g.mContext.finish();
    }
    this.g.mContext = null;
  }
  
  protected void onPreExecute()
  {
    a(this.g.mContext, 2131892581);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.MediaCodecSendTask
 * JD-Core Version:    0.7.0.1
 */