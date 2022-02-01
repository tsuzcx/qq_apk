package com.tencent.aelight.camera.aioeditor;

import NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicRsp;
import NS_QQ_STORY_META.META.StMusic;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.takevideo.EditMusicExport;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPart;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPlayerExport;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoUi;
import com.tencent.aelight.camera.aioeditor.takevideo.StoryMediaEditNotifier;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.aelight.camera.watermark.api.IAEWaterMarkManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.SmartMusicMatchRequest;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.biz.videostory.video.VsMediaPlayer;
import com.tencent.biz.videostory.video.VsMediaPlayer.VsMediaPlayerListener;
import com.tencent.biz.videostory.widget.easylyric.SingleLyricView;
import com.tencent.biz.videostory.widget.easylyric.VideoPlayStatusDispatcher;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.WeakReferenceHandler;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EditVideoSmartMusicPart
  extends EditVideoPart
  implements Handler.Callback, View.OnClickListener, EditMusicExport, VsMediaPlayer.VsMediaPlayerListener
{
  public float a;
  public int a;
  protected BroadcastReceiver a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Vibrator jdField_a_of_type_AndroidOsVibrator;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SmartMusicAdapter.SmartMusicVH jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter$SmartMusicVH;
  private SmartMusicAdapter jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter;
  private SmartMusicRecyclerView jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicRecyclerView;
  private EditVideoPlayerExport jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPlayerExport;
  private FrameVideoHelper jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper;
  private VsMediaPlayer jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer;
  private SingleLyricView jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView;
  private VsMusicItemInfo jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo;
  private LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  private QQAnimationDrawable jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private File jdField_a_of_type_JavaIoFile;
  private final String jdField_a_of_type_JavaLangString = "EditVideoSmartMusicPart";
  private ArrayList<FrameVideoHelper.FrameBuffer> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = true;
  public float b;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private String jdField_d_of_type_JavaLangString = (String)VSConfigManager.a().a("KEY_SMART_MUSIC_ENTER_ANIM_DOWNLOAD_URL", "https://down.qq.com/video_story/smart_music_anim.zip");
  private boolean jdField_d_of_type_Boolean;
  private long jdField_e_of_type_Long = 0L;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean;
  private long jdField_f_of_type_Long = System.currentTimeMillis();
  private boolean jdField_f_of_type_Boolean;
  private boolean h;
  private boolean i;
  
  public EditVideoSmartMusicPart(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_Float = QzoneConfig.getInstance().getConfig("qqstoryvideo", "audiomixoriginalaudiovolume", 0.7F);
    this.jdField_b_of_type_Float = QzoneConfig.getInstance().getConfig("qqstoryvideo", "audiomixmusicvolume", 1.0F);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new EditVideoSmartMusicPart.8(this);
  }
  
  private void A()
  {
    if (AECameraEntry.c.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.f)) {
      StoryMediaEditNotifier.a().a(this.jdField_a_of_type_Boolean ^ true);
    }
  }
  
  private float a(int paramInt)
  {
    if (paramInt == 1) {
      if ((!this.jdField_a_of_type_Boolean) || (!this.jdField_b_of_type_Boolean)) {}
    }
    do
    {
      do
      {
        do
        {
          return 0.0F;
        } while ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean));
        if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
          return this.jdField_a_of_type_Float;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        boolean bool = this.jdField_b_of_type_Boolean;
        return 1.0F;
        if (paramInt != 2) {
          break;
        }
      } while ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean));
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
        return 1.0F;
      }
      if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
        return this.jdField_b_of_type_Float;
      }
    } while ((this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean));
    return 1.0F;
  }
  
  private EditVideoPlayerExport a()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPlayerExport == null) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPlayerExport = ((EditVideoPlayerExport)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(EditVideoPlayerExport.class));
    }
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPlayerExport;
  }
  
  private void a(int paramInt)
  {
    if (paramInt != 1) {
      if (paramInt != 2)
      {
        if (paramInt == 3) {}
      }
      else
      {
        VideoPlayStatusDispatcher.a().b();
        return;
      }
    }
    VideoPlayStatusDispatcher.a().a();
  }
  
  private void a(int paramInt, SmartMusicAdapter.SmartMusicVH paramSmartMusicVH)
  {
    SmartMusicAdapter.SmartMusicVH localSmartMusicVH = paramSmartMusicVH;
    if (paramSmartMusicVH == null) {
      localSmartMusicVH = (SmartMusicAdapter.SmartMusicVH)this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicRecyclerView.findViewHolderForAdapterPosition(paramInt);
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter$SmartMusicVH = localSmartMusicVH;
    paramSmartMusicVH = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter$SmartMusicVH;
    if ((paramSmartMusicVH != null) && (!this.jdField_a_of_type_Boolean))
    {
      paramSmartMusicVH.a();
      t_();
    }
    b(a());
  }
  
  private void a(CLIENT.StSmartMatchMusicRsp paramStSmartMatchMusicRsp) {}
  
  private void a(Intent paramIntent)
  {
    Object localObject1 = paramIntent.getStringExtra("data");
    paramIntent = paramIntent.getStringExtra("event");
    if ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("kTribeSelectMusic")))
    {
      if (this.jdField_c_of_type_Boolean) {
        return;
      }
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("mMusicReceiver onReceive:");
        paramIntent.append((String)localObject1);
        QLog.d("EditVideoSmartMusicPart", 2, paramIntent.toString());
      }
    }
    for (;;)
    {
      try
      {
        paramIntent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicRecyclerView;
        int k = 0;
        if (paramIntent != null) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicRecyclerView.setHasAutoSet(false);
        }
        if (this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer != null)
        {
          this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer.c();
          g();
        }
        Object localObject2 = new JSONObject((String)localObject1);
        paramIntent = new VsMusicItemInfo((JSONObject)localObject2);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReceive Music From H5:");
        localStringBuilder.append((String)localObject1);
        QLog.i("EditVideoSmartMusicPart", 2, localStringBuilder.toString());
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter != null)
        {
          if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter.a() <= 0) {
            break label377;
          }
          j = 1;
          if (j != 0)
          {
            if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter.a(this.jdField_a_of_type_Int, paramIntent))
            {
              paramIntent.jdField_a_of_type_Boolean = false;
              localObject1 = new ArrayList();
              ((ArrayList)localObject1).add(paramIntent.mSongMid);
              b((ArrayList)localObject1);
            }
            this.jdField_d_of_type_Int = (this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter.a(paramIntent.mSongMid) + a());
            if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicRecyclerView != null) {
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicRecyclerView.setLastPosition(-1);
            }
          }
          else
          {
            localObject1 = new ArrayList();
            localObject2 = ((JSONObject)localObject2).optJSONArray("music_items");
            ((ArrayList)localObject1).add(paramIntent);
            if (localObject2 != null)
            {
              j = k;
              if (j < ((JSONArray)localObject2).length())
              {
                ((ArrayList)localObject1).add(new VsMusicItemInfo(((JSONArray)localObject2).getJSONObject(j)));
                j += 1;
                continue;
              }
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter.a((ArrayList)localObject1);
              return;
            }
          }
        }
      }
      catch (JSONException paramIntent)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EditVideoSmartMusicPart", 2, QLog.getStackTraceString(paramIntent));
        }
      }
      return;
      label377:
      int j = 0;
    }
  }
  
  private void a(VsMusicItemInfo paramVsMusicItemInfo, int paramInt, SmartMusicAdapter.SmartMusicVH paramSmartMusicVH)
  {
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo = paramVsMusicItemInfo;
    VsMediaPlayer localVsMediaPlayer = this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer;
    if (localVsMediaPlayer != null) {
      localVsMediaPlayer.c();
    }
    g();
    a(paramInt, paramSmartMusicVH);
    if (paramVsMusicItemInfo.jdField_a_of_type_Boolean) {
      a(paramVsMusicItemInfo);
    }
    y();
  }
  
  private void a(MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo == null) {
      return;
    }
    if ((paramMusicItemInfo.musicDuration == 0) && (paramMusicItemInfo.getLocalPath() != null)) {
      paramMusicItemInfo.musicDuration = ((int)ShortVideoUtils.getDuration(paramMusicItemInfo.getLocalPath()));
    }
    if (this.h)
    {
      if (paramMusicItemInfo.musicStart + 15999 > paramMusicItemInfo.musicDuration) {
        j = paramMusicItemInfo.musicDuration;
      } else {
        j = paramMusicItemInfo.musicStart + 15999;
      }
      paramMusicItemInfo.musicDuration = j;
    }
    if (paramMusicItemInfo.musicEnd == 0) {
      paramMusicItemInfo.musicEnd = paramMusicItemInfo.musicDuration;
    }
    int j = paramMusicItemInfo.musicStart;
    j = paramMusicItemInfo.musicEnd;
  }
  
  private void a(ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList)
  {
    this.jdField_e_of_type_Boolean = true;
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    paramArrayList = new SmartMusicMatchRequest(paramArrayList, ((IAEWaterMarkManager)QRoute.api(IAEWaterMarkManager.class)).getLocation(), this.jdField_f_of_type_Boolean, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    this.jdField_c_of_type_JavaLangString = paramArrayList.getCmdName();
    VSNetworkHelper.getInstance().sendRequest(a(), paramArrayList, new EditVideoSmartMusicPart.6(this));
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    a().a(this.jdField_b_of_type_Boolean);
    a().a(a(1));
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(Message.obtain(null, 3, 1, 0));
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(Message.obtain(null, 3, 2, 0));
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString, CLIENT.StSmartMatchMusicRsp paramStSmartMatchMusicRsp)
  {
    u();
    if (a(paramBoolean, paramLong, paramString, paramStSmartMatchMusicRsp)) {
      return;
    }
    a(paramStSmartMatchMusicRsp);
    a(paramStSmartMatchMusicRsp.vecMusic.get());
  }
  
  private boolean a(boolean paramBoolean, long paramLong, String paramString, CLIENT.StSmartMatchMusicRsp paramStSmartMatchMusicRsp)
  {
    if ((paramBoolean) && (paramStSmartMatchMusicRsp != null))
    {
      if (paramStSmartMatchMusicRsp.vecMusic.size() == 0)
      {
        QLog.w("EditVideoSmartMusicPart", 1, "SmartMusicMatchRequest success but the music size is 0");
        return true;
      }
      return false;
    }
    paramStSmartMatchMusicRsp = new StringBuilder();
    paramStSmartMatchMusicRsp.append("SmartMusicMatchRequest failed");
    paramStSmartMatchMusicRsp.append(BaseRequest.concactRetCodeAndMsg(paramLong, paramString));
    QLog.w("EditVideoSmartMusicPart", 1, paramStSmartMatchMusicRsp.toString());
    return true;
  }
  
  private void b(VsMusicItemInfo paramVsMusicItemInfo)
  {
    g();
    if ((paramVsMusicItemInfo != null) && (!TextUtils.isEmpty(paramVsMusicItemInfo.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView != null))
    {
      VsMusicItemInfo localVsMusicItemInfo = this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo;
      if (localVsMusicItemInfo != null)
      {
        if (!localVsMusicItemInfo.mSongMid.equals(paramVsMusicItemInfo.mSongMid)) {
          return;
        }
        if ((paramVsMusicItemInfo.jdField_b_of_type_JavaLangString != null) && (!paramVsMusicItemInfo.jdField_b_of_type_JavaLangString.isEmpty()))
        {
          a(paramVsMusicItemInfo.jdField_b_of_type_JavaLangString, paramVsMusicItemInfo.jdField_a_of_type_JavaLangString, paramVsMusicItemInfo.musicStart);
          return;
        }
        QLog.w("EditVideoSmartMusicPart", 1, "loadLyric mLrics is Empty");
      }
      return;
    }
    QLog.w("EditVideoSmartMusicPart", 1, "loadLyric mLrics null");
  }
  
  private void b(ArrayList<String> paramArrayList)
  {
    SmartMusicAdapter localSmartMusicAdapter = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter;
    if (localSmartMusicAdapter != null) {
      localSmartMusicAdapter.a(paramArrayList, true);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    View localView = this.jdField_e_of_type_AndroidViewView;
    int j;
    if (paramBoolean) {
      j = 0;
    } else {
      j = 8;
    }
    localView.setVisibility(j);
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a instanceof EditTakeVideoSource))
    {
      localObject = (EditTakeVideoSource)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      this.jdField_b_of_type_JavaLangString = ((EditTakeVideoSource)localObject).jdField_a_of_type_JavaLangString;
    }
    else if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a instanceof EditLocalVideoSource))
    {
      localObject = (EditLocalVideoSource)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      this.jdField_b_of_type_JavaLangString = ((EditLocalVideoSource)localObject).jdField_a_of_type_JavaLangString;
      this.jdField_e_of_type_Long = ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mStartTime;
    }
    this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer = new VsMediaPlayer();
    this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer.a(this);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer.a(((LocalMediaInfo)localObject).mDuration);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131703958));
      ((StringBuilder)localObject).append("\n视频时长：");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration / 1000L);
      ((StringBuilder)localObject).append("s");
      a(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131703974));
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight);
      a(((StringBuilder)localObject).toString());
      ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).setVideoDuration(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration / 1000L);
    }
    if (this.h) {
      this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer.a(60000);
    }
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a().getSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES"));
    int j;
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a().getInt("KEY_VIDEO_STORY_CAMERA_TYPE", 2) == 2) {
      j = 0;
    } else {
      j = 1;
    }
    this.jdField_c_of_type_Int = j;
    this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a().getLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE");
    j();
  }
  
  private void j()
  {
    this.jdField_a_of_type_JavaIoFile = new File("/storage/emulated/0/Tencent/MobileQQ/video_story/", "smart_music_anim.zip");
    k();
    if ((!this.jdField_a_of_type_JavaIoFile.exists()) && (!StringUtil.a(this.jdField_d_of_type_JavaLangString)))
    {
      ThreadManagerV2.executeOnNetWorkThread(new EditVideoSmartMusicPart.1(this));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("animFile exist:");
    localStringBuilder.append(this.jdField_a_of_type_JavaIoFile.exists());
    localStringBuilder.append(" | downloadUrl:");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    QLog.i("EditVideoSmartMusicPart", 1, localStringBuilder.toString());
  }
  
  private void k()
  {
    File localFile1 = new File("/storage/emulated/0/Tencent/MobileQQ/video_story/smart_music_anim/");
    if ((localFile1.exists()) && (localFile1.listFiles() != null))
    {
      if (localFile1.listFiles().length < 25)
      {
        File localFile2 = this.jdField_a_of_type_JavaIoFile;
        if (localFile2 != null) {
          localFile2.delete();
        }
        localFile1.delete();
        QLog.i("EditVideoSmartMusicPart", 1, "anim file is not complete and delete");
        return;
      }
      QLog.i("EditVideoSmartMusicPart", 1, "anim file is exist and complete");
    }
  }
  
  private void l()
  {
    this.jdField_e_of_type_AndroidViewView = a(2064122833);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2064122751));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2064122789));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2064122820));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2064122320));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2064122316));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2064122774));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)a(2064122308));
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView = ((SingleLyricView)a(2064122615));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2064122617));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a().getResources().getDrawable(2130851187);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = a().getResources().getDrawable(2130851186);
    this.jdField_c_of_type_AndroidViewView = a(2064122365);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView = a(2064122359);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2064122209));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().findViewById(2064121981);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().findViewById(2064121980);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
    m();
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new EditVideoSmartMusicPart.2(this));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new EditVideoSmartMusicPart.3(this));
    Object localObject = this.jdField_c_of_type_AndroidViewView;
    if ((localObject != null) && (this.h)) {
      ((View)localObject).setVisibility(8);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getRealHeight");
    ((StringBuilder)localObject).append(ScreenUtil.getRealHeight(a()));
    ((StringBuilder)localObject).append("ScreenUtil.getRealWidth(getContext())");
    ((StringBuilder)localObject).append(ScreenUtil.getRealWidth(a()));
    QLog.d("EditVideoSmartMusicPart", 2, ((StringBuilder)localObject).toString());
    if (ScreenUtil.getRealHeight(a()) / ScreenUtil.getRealWidth(a()) >= 2.0F)
    {
      LiuHaiUtils.c((Activity)a());
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    else if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams() != null))
    {
      this.jdField_e_of_type_AndroidViewView.setPadding(0, 0, 0, this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height);
    }
    int j;
    int k;
    int m;
    if ((AECameraEntry.c.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.f)) && ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.c()) || (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a()) || (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.b())))
    {
      j = AIOUtils.b(105.0F, a().getResources());
      k = AIOUtils.b(34.0F, a().getResources());
      m = AIOUtils.b(19.0F, a().getResources());
    }
    else
    {
      j = AIOUtils.b(17.0F, a().getResources());
      k = AIOUtils.b(0.0F, a().getResources());
      m = AIOUtils.b(-15.0F, a().getResources());
    }
    localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    ((RelativeLayout)localObject).setPadding(((RelativeLayout)localObject).getPaddingLeft(), this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingTop(), this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingRight(), j);
    localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = k;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicRecyclerView.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = m;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicRecyclerView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicRecyclerView = ((SmartMusicRecyclerView)a(2064122085));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter = ((SmartMusicAdapter)this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicRecyclerView.getAdapter());
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicRecyclerView.setListener(new EditVideoSmartMusicPart.4(this));
  }
  
  private void q()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter;
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = ((SmartMusicAdapter)localObject1).a(this.jdField_a_of_type_Int);
    if (localObject2 == null) {
      return;
    }
    localObject1 = new JSONObject();
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_f_of_type_Long;
    try
    {
      ((JSONObject)localObject1).put("music_id", ((VsMusicItemInfo)localObject2).mSongMid);
      ((JSONObject)localObject1).put("music_play_time", l1 - l2);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo != null) {
        ((JSONObject)localObject1).put("video_duration", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    VSReporter.a("mystatus_edit", "aimusic_exp_clk", 0, 0, new String[] { String.valueOf(((VsMusicItemInfo)localObject2).jdField_a_of_type_Int), "", ((JSONObject)localObject1).toString() });
    this.jdField_f_of_type_Long = System.currentTimeMillis();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("reportSmartMusic   reportClickMusic() args3:");
    ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
    SLog.c("EditVideoSmartMusicPart", ((StringBuilder)localObject2).toString());
  }
  
  private void r()
  {
    t();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("抽帧耗时：0ms\n抽取图片数：");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilArrayList.size());
      ((StringBuilder)localObject).append("\n抽帧字节数：");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Long / 1000L);
      ((StringBuilder)localObject).append("KB");
      a(((StringBuilder)localObject).toString());
      a(this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo == null)
    {
      QLog.w("EditVideoSmartMusicPart", 1, "mLocalMediaInfo is null stop extractFrame");
      return;
    }
    a(HardCodeUtil.a(2131704049));
    this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper = new FrameVideoHelper(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
    this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper.a(this.jdField_e_of_type_Long, new EditVideoSmartMusicPart.5(this));
  }
  
  private void s()
  {
    if ((!this.jdField_e_of_type_Boolean) && (this.jdField_b_of_type_Int == 0))
    {
      r();
      VSReporter.a("mystatus_edit", "musiclib_entry_clk", 0, 0, new String[0]);
    }
    this.jdField_a_of_type_Boolean ^= true;
    if (!this.jdField_a_of_type_Boolean)
    {
      a(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer.c();
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    }
    v();
  }
  
  private void t()
  {
    Object localObject = this.jdField_a_of_type_JavaIoFile;
    if ((localObject != null) && (((File)localObject).exists()))
    {
      String[] arrayOfString = new String[25];
      int j = 0;
      while (j < 25)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("/storage/emulated/0/Tencent/MobileQQ/video_story/smart_music_anim/music_000");
        if (j < 10)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("0");
          ((StringBuilder)localObject).append(j);
          localObject = ((StringBuilder)localObject).toString();
        }
        else
        {
          localObject = Integer.valueOf(j);
        }
        localStringBuilder.append(localObject);
        localStringBuilder.append(".png");
        arrayOfString[j] = localStringBuilder.toString();
        j += 1;
      }
      localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
      if (localObject != null) {
        ((FrameLayout)localObject).setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable = new QQAnimationDrawable();
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(arrayOfString);
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(1666L);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(2147483647);
      return;
    }
    QLog.w("EditVideoSmartMusicPart", 1, "startMusicMoreAnimation animFile is not valid");
    localObject = this.jdField_c_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
  }
  
  private void u()
  {
    Object localObject = this.jdField_d_of_type_AndroidWidgetImageView;
    if (localObject != null)
    {
      ((ImageView)localObject).setImageDrawable(null);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
    if (localObject != null) {
      ((QQAnimationDrawable)localObject).stop();
    }
    localObject = this.jdField_c_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
  }
  
  private void v()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicRecyclerView;
    if (localObject != null) {
      ((SmartMusicRecyclerView)localObject).setNeedScale(this.jdField_a_of_type_Boolean ^ true);
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter$SmartMusicVH;
    if (localObject != null)
    {
      ((SmartMusicAdapter.SmartMusicVH)localObject).a(this.jdField_a_of_type_Boolean ^ true);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter$SmartMusicVH.b();
      }
    }
  }
  
  private void w()
  {
    Activity localActivity = (Activity)a();
    Intent localIntent = new Intent(localActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://ti.qq.com/music/index.html?_wv=5&_bid=2831&device_id=%s&client_ip=%s&bustype=%s", new Object[] { DeviceInfoUtil.a(), "", Integer.valueOf(6) }));
    localIntent.putExtra("finish_animation_up_down", true);
    localActivity.startActivityForResult(localIntent, 1001);
    localActivity.overridePendingTransition(2130771993, 0);
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicRecyclerView.getBackground() == null)
    {
      this.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130838742);
      a().post(new EditVideoSmartMusicPart.7(this));
    }
  }
  
  private void y()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter.a(this.jdField_a_of_type_Int - 1) != null) {
        localJSONObject.put("mid1", this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter.a(this.jdField_a_of_type_Int - 1).mSongMid);
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter.a(this.jdField_a_of_type_Int) != null) {
        localJSONObject.put("mid2", this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter.a(this.jdField_a_of_type_Int).mSongMid);
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter.a(this.jdField_a_of_type_Int + 1) != null) {
        localJSONObject.put("mid3", this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter.a(this.jdField_a_of_type_Int + 1).mSongMid);
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    VSReporter.a("mystatus_edit", "aimusic_exp", 0, 0, new String[] { "", "", localJSONObject.toString() });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportSmartMusic   reportShowMusic() args3:");
    localStringBuilder.append(localJSONObject.toString());
    SLog.c("EditVideoSmartMusicPart", localStringBuilder.toString());
  }
  
  private void z()
  {
    if (AECameraEntry.c.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.f)) {
      StoryMediaEditNotifier.a().a();
    }
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter.a() != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter.a().size() != 0))
    {
      double d1 = Math.floor(this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter.getItemCount() / this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter.a().size() / 2);
      double d2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter.a().size();
      Double.isNaN(d2);
      return (int)(d1 * d2);
    }
    return 0;
  }
  
  public Vibrator a()
  {
    if (this.jdField_a_of_type_AndroidOsVibrator == null) {
      this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)a().getSystemService("vibrator"));
    }
    return this.jdField_a_of_type_AndroidOsVibrator;
  }
  
  public WeakReferenceHandler a()
  {
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler == null) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    }
    return this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  }
  
  public String a()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo;
    if ((localVsMusicItemInfo != null) && (this.jdField_c_of_type_AndroidWidgetTextView != null))
    {
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if ((localHashMap != null) && (localHashMap.get(localVsMusicItemInfo.mSongMid) != null)) {
        return (String)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mSongMid);
      }
    }
    return "";
  }
  
  public void a()
  {
    super.a();
    this.jdField_f_of_type_Boolean = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.d();
    this.h = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.e();
    l();
    h();
    a(EditMusicExport.class, this);
    Object localObject = new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
    this.jdField_b_of_type_Int = ((Long)VSConfigManager.a().a("SmartMatchMusicSwitch", Long.valueOf(0L))).intValue();
    int j = this.jdField_b_of_type_Int;
    if (j != 1)
    {
      if (j != 2) {
        return;
      }
      localObject = this.jdField_d_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
    else
    {
      r();
      localObject = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localObject != null)
      {
        ((ImageView)localObject).setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    super.a(paramInt1, paramInt2, paramObject);
    if (paramInt2 != 0)
    {
      if (paramInt2 != 3) {
        return;
      }
      b(false);
      return;
    }
    b(true);
  }
  
  public void a(int paramInt, GenerateContext paramGenerateContext)
  {
    this.jdField_d_of_type_Boolean = true;
    if (this.h) {
      this.jdField_b_of_type_Boolean = true;
    }
    paramGenerateContext.a.putExtra("isMixOriginal", Boolean.valueOf(this.jdField_b_of_type_Boolean ^ true));
    paramGenerateContext.a.isMixOriginal = (this.jdField_b_of_type_Boolean ^ true);
    paramGenerateContext.a.isMuteRecordVoice = this.jdField_b_of_type_Boolean;
    paramGenerateContext.a.putExtra("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a().getString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH"));
    paramGenerateContext.a.putExtra("KEY_FROM_PIC_TO_VIDEO", Boolean.valueOf(this.h));
    paramGenerateContext.a.putExtra("KEY_VIDEO_STORY_CAMERA_TYPE", Boolean.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a().isLandTakePicToVideo()));
    if (this.jdField_a_of_type_Boolean)
    {
      paramGenerateContext.a.backgroundMusicPath = null;
    }
    else
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer;
      if ((localObject != null) && (((VsMediaPlayer)localObject).a() != null))
      {
        VsMusicItemInfo localVsMusicItemInfo = this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer.a();
        paramGenerateContext.a.backgroundMusicOffset = localVsMusicItemInfo.musicStart;
        int j = localVsMusicItemInfo.musicEnd - localVsMusicItemInfo.musicStart;
        int k = j;
        if (!this.h)
        {
          k = j;
          if (j < 0) {
            k = 60000;
          }
          k = Math.min(k, (int)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(paramInt));
        }
        paramGenerateContext.a.backgroundMusicDuration = k;
        paramGenerateContext.a.backgroundMusicPath = localVsMusicItemInfo.getLocalPath();
        paramGenerateContext.a.putExtra("vs_publish_entry_json_key_music_id", Integer.valueOf(localVsMusicItemInfo.mItemId));
        paramGenerateContext.a.putExtra("vs_publish_entry_json_key_music_mid_id", localVsMusicItemInfo.mSongMid);
        paramGenerateContext.a.putExtra("vs_publish_entry_json_key_song_name", localVsMusicItemInfo.mMusicName);
        paramGenerateContext.a.putExtra("vs_publish_entry_json_key_music_album_pic", localVsMusicItemInfo.mAlbumUrl);
        paramGenerateContext.a.putExtra("vs_publish_entry_json_key_music_download_url", localVsMusicItemInfo.mUrl);
        paramGenerateContext.a.putExtra("vs_publish_entry_json_key_music_source_from", Integer.valueOf(localVsMusicItemInfo.jdField_a_of_type_Int));
        paramGenerateContext.a.putExtra("originalRecordVolume", Float.valueOf(a(1)));
        paramGenerateContext.a.putExtra("backgroundVolume", Float.valueOf(a(2)));
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a().setSongMid(localVsMusicItemInfo.mSongMid);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a().setMusicType(localVsMusicItemInfo.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a().setMusciPlayTime(System.currentTimeMillis() - this.jdField_f_of_type_Long);
        localObject = localVsMusicItemInfo.mTagName;
        paramGenerateContext = (GenerateContext)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramGenerateContext = "none";
        }
        localObject = (IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramGenerateContext);
        localStringBuilder.append("_");
        localStringBuilder.append(localVsMusicItemInfo.mItemId);
        ((IAEBaseReportParam)localObject).setEditMusicId(localStringBuilder.toString());
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a().setVideoDuration(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
    }
  }
  
  public void a(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo != null) && (!this.jdField_a_of_type_Boolean))
    {
      paramMediaPlayer = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter$SmartMusicVH;
      if (paramMediaPlayer != null)
      {
        paramMediaPlayer.b(false);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter$SmartMusicVH.b();
      }
      QQToast.a(BaseApplicationImpl.sApplication, this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.jdField_c_of_type_JavaLangString, 1).a();
      paramMediaPlayer = new StringBuilder();
      paramMediaPlayer.append("mediaplayer onError: what:");
      paramMediaPlayer.append(paramInt1);
      paramMediaPlayer.append(" | extra:");
      paramMediaPlayer.append(paramInt2);
      QLog.w("EditVideoSmartMusicPart", 1, paramMediaPlayer.toString());
    }
  }
  
  public void a(MediaPlayer paramMediaPlayer, VsMusicItemInfo paramVsMusicItemInfo)
  {
    if (paramVsMusicItemInfo.mSongMid.equals(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mSongMid)) {
      a(true);
    }
  }
  
  public void a(VsMusicItemInfo paramVsMusicItemInfo)
  {
    if (paramVsMusicItemInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditVideoSmartMusicPart", 2, "startMusic itemInfo=null");
      }
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.d("EditVideoSmartMusicPart", 2, "startMusic  music is muted but itemInfo is not MuteInfo");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start replay music name:");
    ((StringBuilder)localObject).append(paramVsMusicItemInfo.mMusicName);
    QLog.d("EditVideoSmartMusicPart", 4, ((StringBuilder)localObject).toString());
    a(paramVsMusicItemInfo);
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter$SmartMusicVH;
    if (localObject != null) {
      ((SmartMusicAdapter.SmartMusicVH)localObject).b(true);
    }
    localObject = this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer;
    if ((localObject != null) && (!this.jdField_a_of_type_Boolean))
    {
      ((VsMediaPlayer)localObject).a(a(2));
      this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer.a(paramVsMusicItemInfo);
    }
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    String str = paramString2;
    if (StringUtil.a(paramString2)) {
      str = "LRC";
    }
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView.setData(paramString1, str);
  }
  
  public void a(List<META.StMusic> paramList)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicRecyclerView.setMusicData(paramList);
    if (((paramList == null) || (paramList.size() == 0)) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter.a() == 0))
    {
      QLog.w("EditVideoSmartMusicPart", 1, "setMusicData musicData response is empty");
      return;
    }
    x();
  }
  
  protected boolean a(Message paramMessage)
  {
    if (this.jdField_c_of_type_Boolean) {
      return false;
    }
    if (paramMessage.what == 3) {
      a(paramMessage.arg1);
    }
    return super.a(paramMessage);
  }
  
  public void b()
  {
    Object localObject;
    if (!this.i)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("playBgMusic in = null mIsResume=");
        ((StringBuilder)localObject).append(this.i);
        QLog.d("EditVideoSmartMusicPart", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer != null)
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter$SmartMusicVH;
      if (localObject != null)
      {
        ((SmartMusicAdapter.SmartMusicVH)localObject).b(false);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter$SmartMusicVH.d();
      }
      b(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo);
      this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer.a();
    }
  }
  
  public void b(String paramString) {}
  
  public void d()
  {
    super.d();
    this.i = true;
    SmartMusicRecyclerView localSmartMusicRecyclerView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicRecyclerView;
    if (localSmartMusicRecyclerView != null)
    {
      int j = this.jdField_d_of_type_Int;
      if (j != -1)
      {
        localSmartMusicRecyclerView.smoothScrollToPosition(j);
        this.jdField_d_of_type_Int = -1;
      }
    }
  }
  
  public void e()
  {
    q();
    this.jdField_c_of_type_Boolean = true;
    a().removeCallbacks(null);
    BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    VSNetworkHelper.getInstance().cancelRequest(a());
    Object localObject = this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper;
    if (localObject != null) {
      ((FrameVideoHelper)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer;
    if (localObject != null) {
      ((VsMediaPlayer)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView;
    if (localObject != null) {
      ((SingleLyricView)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter$SmartMusicVH;
    if (localObject != null) {
      ((SmartMusicAdapter.SmartMusicVH)localObject).b();
    }
    a().removeCallbacks(null);
  }
  
  public void g()
  {
    SingleLyricView localSingleLyricView = this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView;
    if (localSingleLyricView != null) {
      localSingleLyricView.a();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if (j != 2064122209)
    {
      if (j != 2064122359)
      {
        if (j != 2064122365) {
          return;
        }
        this.jdField_b_of_type_Boolean ^= true;
        a(true);
        ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
        if (this.jdField_b_of_type_Boolean) {
          paramView = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        } else {
          paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        }
        localImageView.setBackgroundDrawable(paramView);
        z();
        return;
      }
      s();
      z();
      A();
      return;
    }
    w();
  }
  
  public void t_()
  {
    a().postDelayed(new EditVideoSmartMusicPart.9(this), 100L);
  }
  
  public void z_()
  {
    super.z_();
    this.i = false;
    VsMediaPlayer localVsMediaPlayer = this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer;
    if (localVsMediaPlayer != null) {
      localVsMediaPlayer.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.EditVideoSmartMusicPart
 * JD-Core Version:    0.7.0.1
 */