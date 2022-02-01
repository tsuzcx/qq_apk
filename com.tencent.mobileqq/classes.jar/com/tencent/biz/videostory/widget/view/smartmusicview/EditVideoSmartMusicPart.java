package com.tencent.biz.videostory.widget.view.smartmusicview;

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
import com.tencent.biz.qqstory.database.PublishVideoEntry;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.WeakReferenceHandler;
import common.config.service.QzoneConfig;
import dov.com.qq.im.ae.camera.ui.watermark.WatermarkDataManager;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditMusicExport;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPart;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayerExport;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoUi;
import dov.com.tencent.biz.qqstory.takevideo.StoryMediaEditNotifier;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EditVideoSmartMusicPart
  extends EditVideoPart
  implements Handler.Callback, View.OnClickListener, VsMediaPlayer.VsMediaPlayerListener, EditMusicExport
{
  public float a;
  public int a;
  private long jdField_a_of_type_Long;
  protected BroadcastReceiver a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Vibrator jdField_a_of_type_AndroidOsVibrator;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FrameVideoHelper jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper;
  private VsMediaPlayer jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer;
  private SingleLyricView jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView;
  private SmartMusicAdapter.SmartMusicVH jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH;
  private SmartMusicAdapter jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter;
  private SmartMusicRecyclerView jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView;
  private VsMusicItemInfo jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo;
  private LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  private QQAnimationDrawable jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private EditVideoPlayerExport jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPlayerExport;
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
    if (AECameraEntry.c.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.f)) {
      StoryMediaEditNotifier.a().a();
    }
  }
  
  private void B()
  {
    StoryMediaEditNotifier localStoryMediaEditNotifier;
    if (AECameraEntry.c.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.f))
    {
      localStoryMediaEditNotifier = StoryMediaEditNotifier.a();
      if (this.jdField_a_of_type_Boolean) {
        break label38;
      }
    }
    label38:
    for (boolean bool = true;; bool = false)
    {
      localStoryMediaEditNotifier.a(bool);
      return;
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
        if ((!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
          break;
        }
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
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPlayerExport == null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPlayerExport = ((EditVideoPlayerExport)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(EditVideoPlayerExport.class));
    }
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPlayerExport;
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 3: 
      VideoPlayStatusDispatcher.a().a();
      return;
    }
    VideoPlayStatusDispatcher.a().b();
  }
  
  private void a(int paramInt, SmartMusicAdapter.SmartMusicVH paramSmartMusicVH)
  {
    if (paramSmartMusicVH == null) {
      paramSmartMusicVH = (SmartMusicAdapter.SmartMusicVH)this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.findViewHolderForAdapterPosition(paramInt);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH = paramSmartMusicVH;
      if ((this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH != null) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH.a();
        Y_();
      }
      b(a());
      return;
    }
  }
  
  private void a(CLIENT.StSmartMatchMusicRsp paramStSmartMatchMusicRsp) {}
  
  private void a(Intent paramIntent)
  {
    int k = 0;
    Object localObject1 = paramIntent.getStringExtra("data");
    paramIntent = paramIntent.getStringExtra("event");
    if ((TextUtils.isEmpty(paramIntent)) || (!paramIntent.equals("kTribeSelectMusic")) || (this.jdField_c_of_type_Boolean)) {}
    Object localObject2;
    label278:
    label283:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EditVideoSmartMusicPart", 2, "mMusicReceiver onReceive:" + (String)localObject1);
      }
      for (;;)
      {
        try
        {
          if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView != null) {
            this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.setHasAutoSet(false);
          }
          if (this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer != null)
          {
            this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer.c();
            i();
          }
          localObject2 = new JSONObject((String)localObject1);
          paramIntent = new VsMusicItemInfo((JSONObject)localObject2);
          QLog.i("EditVideoSmartMusicPart", 2, "onReceive Music From H5:" + (String)localObject1);
          if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter == null) {
            break;
          }
          if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter.a() <= 0) {
            break label278;
          }
          j = 1;
          if (j == 0) {
            break label283;
          }
          if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter.a(this.jdField_a_of_type_Int, paramIntent))
          {
            paramIntent.jdField_a_of_type_Boolean = false;
            localObject1 = new ArrayList();
            ((ArrayList)localObject1).add(paramIntent.mSongMid);
            b((ArrayList)localObject1);
          }
          this.jdField_d_of_type_Int = (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter.a(paramIntent.mSongMid) + a());
          if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.setLastPosition(-1);
          return;
        }
        catch (JSONException paramIntent) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("EditVideoSmartMusicPart", 2, QLog.getStackTraceString(paramIntent));
        return;
        j = 0;
      }
      localObject1 = new ArrayList();
      localObject2 = ((JSONObject)localObject2).optJSONArray("music_items");
      ((ArrayList)localObject1).add(paramIntent);
    } while (localObject2 == null);
    int j = k;
    while (j < ((JSONArray)localObject2).length())
    {
      ((ArrayList)localObject1).add(new VsMusicItemInfo(((JSONArray)localObject2).getJSONObject(j)));
      j += 1;
    }
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter.a((ArrayList)localObject1);
  }
  
  private void a(VsMusicItemInfo paramVsMusicItemInfo, int paramInt, SmartMusicAdapter.SmartMusicVH paramSmartMusicVH)
  {
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo = paramVsMusicItemInfo;
    if (this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer.c();
    }
    i();
    a(paramInt, paramSmartMusicVH);
    if (paramVsMusicItemInfo.jdField_a_of_type_Boolean) {
      a(paramVsMusicItemInfo);
    }
    z();
  }
  
  private void a(MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo == null) {
      return;
    }
    if ((paramMusicItemInfo.musicDuration == 0) && (paramMusicItemInfo.getLocalPath() != null)) {
      paramMusicItemInfo.musicDuration = ((int)ShortVideoUtils.getDuration(paramMusicItemInfo.getLocalPath()));
    }
    if (this.h) {
      if (paramMusicItemInfo.musicStart + 15999 <= paramMusicItemInfo.musicDuration) {
        break label90;
      }
    }
    label90:
    for (int j = paramMusicItemInfo.musicDuration;; j = paramMusicItemInfo.musicStart + 15999)
    {
      paramMusicItemInfo.musicDuration = j;
      if (paramMusicItemInfo.musicEnd == 0) {
        paramMusicItemInfo.musicEnd = paramMusicItemInfo.musicDuration;
      }
      if (paramMusicItemInfo.musicStart <= paramMusicItemInfo.musicEnd) {
        break;
      }
      return;
    }
  }
  
  private void a(ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList)
  {
    this.jdField_e_of_type_Boolean = true;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    paramArrayList = new SmartMusicMatchRequest(paramArrayList, WatermarkDataManager.a().a(), this.jdField_f_of_type_Boolean, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
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
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 3, 1, 0));
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 3, 2, 0));
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString, CLIENT.StSmartMatchMusicRsp paramStSmartMatchMusicRsp)
  {
    v();
    if (a(paramBoolean, paramLong, paramString, paramStSmartMatchMusicRsp)) {
      return;
    }
    a(paramStSmartMatchMusicRsp);
    a(paramStSmartMatchMusicRsp.vecMusic.get());
  }
  
  private boolean a(boolean paramBoolean, long paramLong, String paramString, CLIENT.StSmartMatchMusicRsp paramStSmartMatchMusicRsp)
  {
    if ((!paramBoolean) || (paramStSmartMatchMusicRsp == null))
    {
      QLog.w("EditVideoSmartMusicPart", 1, "SmartMusicMatchRequest failed" + BaseRequest.concactRetCodeAndMsg(paramLong, paramString));
      return true;
    }
    if (paramStSmartMatchMusicRsp.vecMusic.size() == 0)
    {
      QLog.w("EditVideoSmartMusicPart", 1, "SmartMusicMatchRequest success but the music size is 0");
      return true;
    }
    return false;
  }
  
  private void b(VsMusicItemInfo paramVsMusicItemInfo)
  {
    i();
    if ((paramVsMusicItemInfo == null) || (TextUtils.isEmpty(paramVsMusicItemInfo.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView == null)) {
      QLog.w("EditVideoSmartMusicPart", 1, "loadLyric mLrics null");
    }
    while ((this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo == null) || (!this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mSongMid.equals(paramVsMusicItemInfo.mSongMid))) {
      return;
    }
    if ((paramVsMusicItemInfo.jdField_b_of_type_JavaLangString == null) || (paramVsMusicItemInfo.jdField_b_of_type_JavaLangString.isEmpty()))
    {
      QLog.w("EditVideoSmartMusicPart", 1, "loadLyric mLrics is Empty");
      return;
    }
    a(paramVsMusicItemInfo.jdField_b_of_type_JavaLangString, paramVsMusicItemInfo.jdField_a_of_type_JavaLangString, paramVsMusicItemInfo.musicStart);
  }
  
  private void b(ArrayList<String> paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter != null) {
      this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter.a(paramArrayList, true);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    View localView = this.jdField_e_of_type_AndroidViewView;
    if (paramBoolean) {}
    for (int j = 0;; j = 8)
    {
      localView.setVisibility(j);
      return;
    }
  }
  
  private void k()
  {
    Object localObject;
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakeVideoSource))
    {
      localObject = (EditTakeVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      this.jdField_b_of_type_JavaLangString = ((EditTakeVideoSource)localObject).jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer = new VsMediaPlayer();
      this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer.a(this);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo != null)
      {
        this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
        a(HardCodeUtil.a(2131703853) + "\n视频时长：" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration / 1000L + "s");
        a(HardCodeUtil.a(2131703870) + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth + "  " + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight);
        AEBaseReportParam.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration / 1000L);
      }
      if (this.h) {
        this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer.a(60000);
      }
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a().getSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES"));
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a().getInt("KEY_VIDEO_STORY_CAMERA_TYPE", 2) != 2) {
        break label345;
      }
    }
    label345:
    for (int j = 0;; j = 1)
    {
      this.jdField_c_of_type_Int = j;
      this.jdField_a_of_type_Long = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a().getLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE");
      m();
      return;
      if (!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalVideoSource)) {
        break;
      }
      localObject = (EditLocalVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      this.jdField_b_of_type_JavaLangString = ((EditLocalVideoSource)localObject).jdField_a_of_type_JavaLangString;
      this.jdField_e_of_type_Long = ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mStartTime;
      break;
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_JavaIoFile = new File("/storage/emulated/0/Tencent/MobileQQ/video_story/", "smart_music_anim.zip");
    n();
    if ((this.jdField_a_of_type_JavaIoFile.exists()) || (StringUtil.a(this.jdField_d_of_type_JavaLangString)))
    {
      QLog.i("EditVideoSmartMusicPart", 1, "animFile exist:" + this.jdField_a_of_type_JavaIoFile.exists() + " | downloadUrl:" + this.jdField_d_of_type_JavaLangString);
      return;
    }
    ThreadManagerV2.executeOnNetWorkThread(new EditVideoSmartMusicPart.1(this));
  }
  
  private void n()
  {
    File localFile = new File("/storage/emulated/0/Tencent/MobileQQ/video_story/smart_music_anim/");
    if ((localFile.exists()) && (localFile.listFiles() != null))
    {
      if (localFile.listFiles().length < 25)
      {
        if (this.jdField_a_of_type_JavaIoFile != null) {
          this.jdField_a_of_type_JavaIoFile.delete();
        }
        localFile.delete();
        QLog.i("EditVideoSmartMusicPart", 1, "anim file is not complete and delete");
      }
    }
    else {
      return;
    }
    QLog.i("EditVideoSmartMusicPart", 1, "anim file is exist and complete");
  }
  
  private void o()
  {
    this.jdField_e_of_type_AndroidViewView = a(2131381520);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131380259));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131380592));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131381507));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131369742));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131369726));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380472));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)a(2131369646));
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView = ((SingleLyricView)a(2131378259));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131378270));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a().getResources().getDrawable(2130851273);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = a().getResources().getDrawable(2130851272);
    this.jdField_c_of_type_AndroidViewView = a(2131370638);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView = a(2131370627);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131367084));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().findViewById(2131363738);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().findViewById(2131363736);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
    p();
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new EditVideoSmartMusicPart.2(this));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new EditVideoSmartMusicPart.3(this));
    if ((this.jdField_c_of_type_AndroidViewView != null) && (this.h)) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    QLog.d("EditVideoSmartMusicPart", 2, "getRealHeight" + ScreenUtil.getRealHeight(a()) + "ScreenUtil.getRealWidth(getContext())" + ScreenUtil.getRealWidth(a()));
    int j;
    int n;
    int m;
    int k;
    if (ScreenUtil.getRealHeight(a()) / ScreenUtil.getRealWidth(a()) >= 2.0F)
    {
      LiuHaiUtils.c((Activity)a());
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      if ((!AECameraEntry.c.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.f)) || ((!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c()) && (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a()) && (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()))) {
        break label667;
      }
      j = AIOUtils.a(105.0F, a().getResources());
      n = AIOUtils.a(34.0F, a().getResources());
      m = AIOUtils.a(19.0F, a().getResources());
      k = j;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft(), this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingTop(), this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingRight(), k);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      localMarginLayoutParams.bottomMargin = n;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localMarginLayoutParams);
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.getLayoutParams();
      localMarginLayoutParams.bottomMargin = m;
      this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.setLayoutParams(localMarginLayoutParams);
      return;
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams() == null)) {
        break;
      }
      this.jdField_e_of_type_AndroidViewView.setPadding(0, 0, 0, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height);
      break;
      label667:
      k = AIOUtils.a(17.0F, a().getResources());
      j = AIOUtils.a(0.0F, a().getResources());
      m = AIOUtils.a(-15.0F, a().getResources());
      n = j;
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView = ((SmartMusicRecyclerView)a(2131365478));
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter = ((SmartMusicAdapter)this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.getAdapter());
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.setListener(new EditVideoSmartMusicPart.4(this));
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter == null) {}
    VsMusicItemInfo localVsMusicItemInfo;
    do
    {
      return;
      localVsMusicItemInfo = this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter.a(this.jdField_a_of_type_Int);
    } while (localVsMusicItemInfo == null);
    JSONObject localJSONObject = new JSONObject();
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_f_of_type_Long;
    try
    {
      localJSONObject.put("music_id", localVsMusicItemInfo.mSongMid);
      localJSONObject.put("music_play_time", l1 - l2);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo != null) {
        localJSONObject.put("video_duration", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
      }
      VSReporter.a("mystatus_edit", "aimusic_exp_clk", 0, 0, new String[] { String.valueOf(localVsMusicItemInfo.jdField_a_of_type_Int), "", localJSONObject.toString() });
      this.jdField_f_of_type_Long = System.currentTimeMillis();
      SLog.c("EditVideoSmartMusicPart", "reportSmartMusic   reportClickMusic() args3:" + localJSONObject.toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void r()
  {
    u();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo == null)
      {
        QLog.w("EditVideoSmartMusicPart", 1, "mLocalMediaInfo is null stop extractFrame");
        return;
      }
      a(HardCodeUtil.a(2131703958));
      this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper = new FrameVideoHelper(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
      this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper.a(this.jdField_e_of_type_Long, new EditVideoSmartMusicPart.5(this));
      return;
    }
    a("抽帧耗时：0ms\n抽取图片数：" + this.jdField_a_of_type_JavaUtilArrayList.size() + "\n抽帧字节数：" + this.jdField_a_of_type_Long / 1000L + "KB");
    a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  private void t()
  {
    boolean bool = false;
    if ((!this.jdField_e_of_type_Boolean) && (this.jdField_b_of_type_Int == 0))
    {
      r();
      VSReporter.a("mystatus_edit", "musiclib_entry_clk", 0, 0, new String[0]);
    }
    if (!this.jdField_a_of_type_Boolean) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
    if (!this.jdField_a_of_type_Boolean)
    {
      a(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    for (;;)
    {
      w();
      return;
      this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer.c();
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  private void u()
  {
    if ((this.jdField_a_of_type_JavaIoFile == null) || (!this.jdField_a_of_type_JavaIoFile.exists()))
    {
      QLog.w("EditVideoSmartMusicPart", 1, "startMusicMoreAnimation animFile is not valid");
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      }
      return;
    }
    String[] arrayOfString = new String[25];
    int j = 0;
    if (j < 25)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("/storage/emulated/0/Tencent/MobileQQ/video_story/smart_music_anim/music_000");
      if (j < 10) {}
      for (Object localObject = "0" + j;; localObject = Integer.valueOf(j))
      {
        arrayOfString[j] = (localObject + ".png");
        j += 1;
        break;
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable = new QQAnimationDrawable();
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(arrayOfString);
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(1666L);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(2147483647);
  }
  
  private void v()
  {
    if (this.jdField_d_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(null);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.stop();
    }
    if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  private void w()
  {
    boolean bool2 = true;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView;
      if (!this.jdField_a_of_type_Boolean)
      {
        bool1 = true;
        ((SmartMusicRecyclerView)localObject).setNeedScale(bool1);
      }
    }
    else if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH;
      if (this.jdField_a_of_type_Boolean) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((SmartMusicAdapter.SmartMusicVH)localObject).a(bool1);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH.b();
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  private void x()
  {
    Activity localActivity = (Activity)a();
    Intent localIntent = new Intent(localActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://ti.qq.com/music/index.html?_wv=5&_bid=2831&device_id=%s&client_ip=%s&bustype=%s", new Object[] { DeviceInfoUtil.a(), "", Integer.valueOf(6) }));
    localIntent.putExtra("finish_animation_up_down", true);
    localActivity.startActivityForResult(localIntent, 1001);
    localActivity.overridePendingTransition(2130771981, 0);
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.getBackground() == null)
    {
      this.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130838982);
      a().post(new EditVideoSmartMusicPart.7(this));
    }
  }
  
  private void z()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter.a(this.jdField_a_of_type_Int - 1) != null) {
        localJSONObject.put("mid1", this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter.a(this.jdField_a_of_type_Int - 1).mSongMid);
      }
      if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter.a(this.jdField_a_of_type_Int) != null) {
        localJSONObject.put("mid2", this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter.a(this.jdField_a_of_type_Int).mSongMid);
      }
      if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter.a(this.jdField_a_of_type_Int + 1) != null) {
        localJSONObject.put("mid3", this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter.a(this.jdField_a_of_type_Int + 1).mSongMid);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    VSReporter.a("mystatus_edit", "aimusic_exp", 0, 0, new String[] { "", "", localJSONObject.toString() });
    SLog.c("EditVideoSmartMusicPart", "reportSmartMusic   reportShowMusic() args3:" + localJSONObject.toString());
  }
  
  public void Y_()
  {
    a().postDelayed(new EditVideoSmartMusicPart.9(this), 100L);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter.a() == null) || (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter.a().size() == 0)) {
      return 0;
    }
    return (int)(Math.floor(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter.getItemCount() / this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter.a().size() / 2) * this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter.a().size());
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
    if ((this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo == null) || (this.jdField_c_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mSongMid) == null)) {
      return "";
    }
    return (String)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mSongMid);
  }
  
  public void a()
  {
    super.a();
    this.jdField_f_of_type_Boolean = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b();
    this.h = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.c();
    o();
    k();
    a(EditMusicExport.class, this);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.jdField_b_of_type_Int = ((Long)VSConfigManager.a().a("SmartMatchMusicSwitch", Long.valueOf(0L))).intValue();
    switch (this.jdField_b_of_type_Int)
    {
    }
    do
    {
      do
      {
        return;
        r();
      } while (this.jdField_b_of_type_AndroidWidgetImageView == null);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      return;
    } while (this.jdField_d_of_type_AndroidViewView == null);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    super.a(paramInt1, paramInt2, paramObject);
    switch (paramInt2)
    {
    case 1: 
    case 2: 
    default: 
      return;
    case 3: 
      b(false);
      return;
    }
    b(true);
  }
  
  public void a(int paramInt, GenerateContext paramGenerateContext)
  {
    boolean bool2 = false;
    this.jdField_d_of_type_Boolean = true;
    if (this.h) {
      this.jdField_b_of_type_Boolean = true;
    }
    Object localObject = paramGenerateContext.a;
    boolean bool1;
    if (!this.jdField_b_of_type_Boolean)
    {
      bool1 = true;
      ((PublishVideoEntry)localObject).putExtra("isMixOriginal", Boolean.valueOf(bool1));
      localObject = paramGenerateContext.a;
      bool1 = bool2;
      if (!this.jdField_b_of_type_Boolean) {
        bool1 = true;
      }
      ((PublishVideoEntry)localObject).isMixOriginal = bool1;
      paramGenerateContext.a.isMuteRecordVoice = this.jdField_b_of_type_Boolean;
      paramGenerateContext.a.putExtra("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a().getString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH"));
      paramGenerateContext.a.putExtra("KEY_FROM_PIC_TO_VIDEO", Boolean.valueOf(this.h));
      paramGenerateContext.a.putExtra("KEY_VIDEO_STORY_CAMERA_TYPE", Boolean.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a().isLandTakePicToVideo()));
      if (!this.jdField_a_of_type_Boolean) {
        break label200;
      }
      paramGenerateContext.a.backgroundMusicPath = null;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a().setVideoDuration(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
      }
      return;
      bool1 = false;
      break;
      label200:
      if ((this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer != null) && (this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer.a() != null))
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
          k = Math.min(k, (int)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramInt));
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
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a().setSongMid(localVsMusicItemInfo.mSongMid);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a().setMusicType(localVsMusicItemInfo.jdField_a_of_type_Int);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a().setMusciPlayTime(System.currentTimeMillis() - this.jdField_f_of_type_Long);
        localObject = localVsMusicItemInfo.mTagName;
        paramGenerateContext = (GenerateContext)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramGenerateContext = "none";
        }
        AEBaseReportParam.a().h(paramGenerateContext + "_" + localVsMusicItemInfo.mItemId);
      }
    }
  }
  
  public void a(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo != null) && (!this.jdField_a_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH != null)
      {
        this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH.b(false);
        this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH.b();
      }
      QQToast.a(BaseApplicationImpl.sApplication, this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.jdField_c_of_type_JavaLangString, 1).a();
      QLog.w("EditVideoSmartMusicPart", 1, "mediaplayer onError: what:" + paramInt1 + " | extra:" + paramInt2);
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
    if (paramVsMusicItemInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("EditVideoSmartMusicPart", 2, "startMusic itemInfo=null");
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        QLog.d("EditVideoSmartMusicPart", 2, "startMusic  music is muted but itemInfo is not MuteInfo");
        return;
      }
      QLog.d("EditVideoSmartMusicPart", 4, "start replay music name:" + paramVsMusicItemInfo.mMusicName);
      a(paramVsMusicItemInfo);
      if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH != null) {
        this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH.b(true);
      }
    } while ((this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer == null) || (this.jdField_a_of_type_Boolean));
    this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer.a(a(2));
    this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer.a(paramVsMusicItemInfo);
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
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.setMusicData(paramList);
    if (((paramList == null) || (paramList.size() == 0)) && (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter.a() == 0))
    {
      QLog.w("EditVideoSmartMusicPart", 1, "setMusicData musicData response is empty");
      return;
    }
    y();
  }
  
  public boolean a(Message paramMessage)
  {
    if (this.jdField_c_of_type_Boolean) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.a(paramMessage);
      a(paramMessage.arg1);
    }
  }
  
  public void aM_()
  {
    super.aM_();
    this.i = false;
    if (this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer.d();
    }
  }
  
  public void b()
  {
    if (!this.i) {
      if (QLog.isColorLevel()) {
        QLog.d("EditVideoSmartMusicPart", 2, "playBgMusic in = null mIsResume=" + this.i);
      }
    }
    while (this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH != null)
    {
      this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH.b(false);
      this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH.d();
    }
    b(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo);
    this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer.a();
  }
  
  public void b(String paramString) {}
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer.d();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer.e();
    }
  }
  
  public void f()
  {
    super.f();
    this.i = true;
    if ((this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView != null) && (this.jdField_d_of_type_Int != -1))
    {
      this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicRecyclerView.smoothScrollToPosition(this.jdField_d_of_type_Int);
      this.jdField_d_of_type_Int = -1;
    }
  }
  
  public void g()
  {
    q();
    this.jdField_c_of_type_Boolean = true;
    a().removeCallbacks(null);
    BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    VSNetworkHelper.getInstance().cancelRequest(a());
    if (this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper != null) {
      this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper.a();
    }
    if (this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer.b();
    }
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView != null) {
      this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView.a();
    }
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH != null) {
      this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH.b();
    }
    a().removeCallbacks(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView != null) {
      this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView.a();
    }
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
      t();
      A();
      B();
      continue;
      boolean bool;
      label72:
      ImageView localImageView;
      if (!this.jdField_b_of_type_Boolean)
      {
        bool = true;
        this.jdField_b_of_type_Boolean = bool;
        a(true);
        localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
        if (!this.jdField_b_of_type_Boolean) {
          break label118;
        }
      }
      label118:
      for (Drawable localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;; localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
      {
        localImageView.setBackgroundDrawable(localDrawable);
        A();
        break;
        bool = false;
        break label72;
      }
      x();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart
 * JD-Core Version:    0.7.0.1
 */