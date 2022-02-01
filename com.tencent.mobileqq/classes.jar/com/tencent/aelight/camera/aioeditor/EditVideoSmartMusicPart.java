package com.tencent.aelight.camera.aioeditor;

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
import qqcircle.QQCircleSmartMatchMusic.MusicInfo;
import qqcircle.QQCircleSmartMatchMusic.SmartMatchMusicRsp;

public class EditVideoSmartMusicPart
  extends EditVideoPart
  implements Handler.Callback, View.OnClickListener, EditMusicExport, VsMediaPlayer.VsMediaPlayerListener
{
  private Drawable A;
  private boolean B;
  private SingleLyricView C;
  private LocalMediaInfo D;
  private String E;
  private String F;
  private FrameVideoHelper G;
  private ImageView H;
  private View I;
  private View J;
  private View K;
  private TextView L;
  private ArrayList<FrameVideoHelper.FrameBuffer> M;
  private long N;
  private long O;
  private long P;
  private long Q = 0L;
  private TextView R;
  private HashMap<String, String> S = new HashMap();
  private boolean T;
  private int U;
  private VsMediaPlayer V;
  private int W;
  private boolean X;
  private boolean Y;
  private boolean Z;
  public float a = QzoneConfig.getInstance().getConfig("qqstoryvideo", "audiomixoriginalaudiovolume", 0.7F);
  private long aa = System.currentTimeMillis();
  private int ab = -1;
  private QQAnimationDrawable ac;
  private FrameLayout ad;
  private ImageView ae;
  private File af;
  private String ag = (String)VSConfigManager.a().a("KEY_SMART_MUSIC_ENTER_ANIM_DOWNLOAD_URL", "https://down.qq.com/video_story/smart_music_anim.zip");
  public float b = QzoneConfig.getInstance().getConfig("qqstoryvideo", "audiomixmusicvolume", 1.0F);
  public int c;
  protected BroadcastReceiver d = new EditVideoSmartMusicPart.8(this);
  private final String e = "EditVideoSmartMusicPart";
  private RelativeLayout f;
  private ImageView g;
  private ImageView h;
  private SmartMusicRecyclerView i;
  private SmartMusicAdapter j;
  private TextView k;
  private WeakReferenceHandler l = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private VsMusicItemInfo m;
  private SmartMusicAdapter.SmartMusicVH n;
  private View o;
  private View p;
  private EditVideoPlayerExport q;
  private boolean r = true;
  private boolean s;
  private boolean x;
  private Vibrator y;
  private Drawable z;
  
  public EditVideoSmartMusicPart(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private void A()
  {
    Object localObject = this.af;
    if ((localObject != null) && (((File)localObject).exists()))
    {
      String[] arrayOfString = new String[25];
      int i1 = 0;
      while (i1 < 25)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("/storage/emulated/0/Tencent/MobileQQ/video_story/smart_music_anim/music_000");
        if (i1 < 10)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("0");
          ((StringBuilder)localObject).append(i1);
          localObject = ((StringBuilder)localObject).toString();
        }
        else
        {
          localObject = Integer.valueOf(i1);
        }
        localStringBuilder.append(localObject);
        localStringBuilder.append(".png");
        arrayOfString[i1] = localStringBuilder.toString();
        i1 += 1;
      }
      localObject = this.ad;
      if (localObject != null) {
        ((FrameLayout)localObject).setVisibility(0);
      }
      this.ac = new QQAnimationDrawable();
      this.ac.a(arrayOfString);
      this.ac.a(1666L);
      this.H.setVisibility(8);
      this.ae.setImageDrawable(this.ac);
      this.ae.setVisibility(0);
      this.ac.a(2147483647);
      return;
    }
    QLog.w("EditVideoSmartMusicPart", 1, "startMusicMoreAnimation animFile is not valid");
    localObject = this.H;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = this.ad;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
  }
  
  private void B()
  {
    Object localObject = this.ae;
    if (localObject != null)
    {
      ((ImageView)localObject).setImageDrawable(null);
      this.ae.setVisibility(8);
    }
    localObject = this.ac;
    if (localObject != null) {
      ((QQAnimationDrawable)localObject).stop();
    }
    localObject = this.H;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
  }
  
  private void C()
  {
    Object localObject = this.i;
    if (localObject != null) {
      ((SmartMusicRecyclerView)localObject).setNeedScale(this.r ^ true);
    }
    localObject = this.n;
    if (localObject != null)
    {
      ((SmartMusicAdapter.SmartMusicVH)localObject).a(this.r ^ true);
      if (this.r) {
        this.n.b();
      }
    }
  }
  
  private EditVideoPlayerExport D()
  {
    if (this.q == null) {
      this.q = ((EditVideoPlayerExport)this.t.a(EditVideoPlayerExport.class));
    }
    return this.q;
  }
  
  private void E()
  {
    Activity localActivity = (Activity)u();
    Intent localIntent = new Intent(localActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://ti.qq.com/music/index.html?_wv=5&_bid=2831&device_id=%s&client_ip=%s&bustype=%s", new Object[] { DeviceInfoUtil.b(), "", Integer.valueOf(6) }));
    localIntent.putExtra("finish_animation_up_down", true);
    localActivity.startActivityForResult(localIntent, 1001);
    localActivity.overridePendingTransition(2130771996, 0);
  }
  
  private void F()
  {
    if (this.i.getBackground() == null)
    {
      this.K.setBackgroundResource(2130838961);
      h().post(new EditVideoSmartMusicPart.7(this));
    }
  }
  
  private void G()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.j.a(this.c - 1) != null) {
        localJSONObject.put("mid1", this.j.a(this.c - 1).mSongMid);
      }
      if (this.j.a(this.c) != null) {
        localJSONObject.put("mid2", this.j.a(this.c).mSongMid);
      }
      if (this.j.a(this.c + 1) != null) {
        localJSONObject.put("mid3", this.j.a(this.c + 1).mSongMid);
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
  
  private void H()
  {
    if (AECameraEntry.c.b(this.t.I.h)) {
      StoryMediaEditNotifier.b().a();
    }
  }
  
  private void I()
  {
    if (AECameraEntry.c.b(this.t.I.h)) {
      StoryMediaEditNotifier.b().a(this.r ^ true);
    }
  }
  
  private float a(int paramInt)
  {
    if (paramInt == 1) {
      if ((!this.r) || (!this.s)) {}
    }
    do
    {
      do
      {
        do
        {
          return 0.0F;
        } while ((!this.r) && (this.s));
        if ((!this.r) && (!this.s)) {
          return this.a;
        }
        if (!this.r) {
          break;
        }
        boolean bool = this.s;
        return 1.0F;
        if (paramInt != 2) {
          break;
        }
      } while ((this.r) && (this.s));
      if ((!this.r) && (this.s)) {
        return 1.0F;
      }
      if ((!this.r) && (!this.s)) {
        return this.b;
      }
    } while ((this.r) && (!this.s));
    return 1.0F;
  }
  
  private void a(int paramInt, SmartMusicAdapter.SmartMusicVH paramSmartMusicVH)
  {
    SmartMusicAdapter.SmartMusicVH localSmartMusicVH = paramSmartMusicVH;
    if (paramSmartMusicVH == null) {
      localSmartMusicVH = (SmartMusicAdapter.SmartMusicVH)this.i.findViewHolderForAdapterPosition(paramInt);
    }
    this.c = paramInt;
    this.n = localSmartMusicVH;
    paramSmartMusicVH = this.n;
    if ((paramSmartMusicVH != null) && (!this.r))
    {
      paramSmartMusicVH.a();
      as_();
    }
    b(c());
  }
  
  private void a(Intent paramIntent)
  {
    Object localObject1 = paramIntent.getStringExtra("data");
    paramIntent = paramIntent.getStringExtra("event");
    if ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("kTribeSelectMusic")))
    {
      if (this.x) {
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
        paramIntent = this.i;
        int i2 = 0;
        if (paramIntent != null) {
          this.i.setHasAutoSet(false);
        }
        if (this.V != null)
        {
          this.V.c();
          k();
        }
        Object localObject2 = new JSONObject((String)localObject1);
        paramIntent = new VsMusicItemInfo((JSONObject)localObject2);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReceive Music From H5:");
        localStringBuilder.append((String)localObject1);
        QLog.i("EditVideoSmartMusicPart", 2, localStringBuilder.toString());
        if (this.j != null)
        {
          if (this.j.b() <= 0) {
            break label379;
          }
          i1 = 1;
          if (i1 != 0)
          {
            if (this.j.a(this.c, paramIntent))
            {
              paramIntent.d = false;
              localObject1 = new ArrayList();
              ((ArrayList)localObject1).add(paramIntent.mSongMid);
              b((ArrayList)localObject1);
            }
            this.ab = (this.j.a(paramIntent.mSongMid) + b());
            if (this.i != null) {
              this.i.setLastPosition(-1);
            }
          }
          else
          {
            localObject1 = new ArrayList();
            localObject2 = ((JSONObject)localObject2).optJSONArray("music_items");
            ((ArrayList)localObject1).add(paramIntent);
            if (localObject2 != null)
            {
              i1 = i2;
              if (i1 < ((JSONArray)localObject2).length())
              {
                ((ArrayList)localObject1).add(new VsMusicItemInfo(((JSONArray)localObject2).getJSONObject(i1)));
                i1 += 1;
                continue;
              }
              this.j.a((ArrayList)localObject1);
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
      label379:
      int i1 = 0;
    }
  }
  
  private void a(VsMusicItemInfo paramVsMusicItemInfo, int paramInt, SmartMusicAdapter.SmartMusicVH paramSmartMusicVH)
  {
    this.m = paramVsMusicItemInfo;
    VsMediaPlayer localVsMediaPlayer = this.V;
    if (localVsMediaPlayer != null) {
      localVsMediaPlayer.c();
    }
    k();
    a(paramInt, paramSmartMusicVH);
    if (paramVsMusicItemInfo.d) {
      a(paramVsMusicItemInfo);
    }
    G();
  }
  
  private void a(MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo == null) {
      return;
    }
    if ((paramMusicItemInfo.musicDuration == 0) && (paramMusicItemInfo.getLocalPath() != null)) {
      paramMusicItemInfo.musicDuration = ((int)ShortVideoUtils.getDuration(paramMusicItemInfo.getLocalPath()));
    }
    if (this.Y)
    {
      if (paramMusicItemInfo.musicStart + 15999 > paramMusicItemInfo.musicDuration) {
        i1 = paramMusicItemInfo.musicDuration;
      } else {
        i1 = paramMusicItemInfo.musicStart + 15999;
      }
      paramMusicItemInfo.musicDuration = i1;
    }
    if (paramMusicItemInfo.musicEnd == 0) {
      paramMusicItemInfo.musicEnd = paramMusicItemInfo.musicDuration;
    }
    int i1 = paramMusicItemInfo.musicStart;
    i1 = paramMusicItemInfo.musicEnd;
  }
  
  private void a(ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList)
  {
    this.T = true;
    this.O = System.currentTimeMillis();
    paramArrayList = new SmartMusicMatchRequest(paramArrayList, ((IAEWaterMarkManager)QRoute.api(IAEWaterMarkManager.class)).getLocation(), this.X, this.W, this.D);
    this.F = paramArrayList.getCmdName();
    VSNetworkHelper.getInstance().sendRequest(u(), paramArrayList, new EditVideoSmartMusicPart.6(this));
  }
  
  private void a(QQCircleSmartMatchMusic.SmartMatchMusicRsp paramSmartMatchMusicRsp) {}
  
  private void a(boolean paramBoolean)
  {
    if (this.B) {
      return;
    }
    D().a(this.s);
    D().a(a(1));
    if (paramBoolean)
    {
      this.t.a(Message.obtain(null, 3, 1, 0));
      return;
    }
    this.t.a(Message.obtain(null, 3, 2, 0));
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString, QQCircleSmartMatchMusic.SmartMatchMusicRsp paramSmartMatchMusicRsp)
  {
    B();
    if (b(paramBoolean, paramLong, paramString, paramSmartMatchMusicRsp)) {
      return;
    }
    a(paramSmartMatchMusicRsp);
    a(paramSmartMatchMusicRsp.musicListInfo.get());
  }
  
  private void b(int paramInt)
  {
    if (paramInt != 1) {
      if (paramInt != 2)
      {
        if (paramInt == 3) {}
      }
      else
      {
        VideoPlayStatusDispatcher.a().c();
        return;
      }
    }
    VideoPlayStatusDispatcher.a().b();
  }
  
  private void b(VsMusicItemInfo paramVsMusicItemInfo)
  {
    k();
    if ((paramVsMusicItemInfo != null) && (!TextUtils.isEmpty(paramVsMusicItemInfo.b)) && (this.C != null))
    {
      VsMusicItemInfo localVsMusicItemInfo = this.m;
      if (localVsMusicItemInfo != null)
      {
        if (!localVsMusicItemInfo.mSongMid.equals(paramVsMusicItemInfo.mSongMid)) {
          return;
        }
        if ((paramVsMusicItemInfo.b != null) && (!paramVsMusicItemInfo.b.isEmpty()))
        {
          a(paramVsMusicItemInfo.b, paramVsMusicItemInfo.a, paramVsMusicItemInfo.musicStart);
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
    SmartMusicAdapter localSmartMusicAdapter = this.j;
    if (localSmartMusicAdapter != null) {
      localSmartMusicAdapter.a(paramArrayList, true);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    View localView = this.K;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localView.setVisibility(i1);
  }
  
  private boolean b(boolean paramBoolean, long paramLong, String paramString, QQCircleSmartMatchMusic.SmartMatchMusicRsp paramSmartMatchMusicRsp)
  {
    if ((paramBoolean) && (paramSmartMatchMusicRsp != null))
    {
      if (paramSmartMatchMusicRsp.musicListInfo.size() == 0)
      {
        QLog.w("EditVideoSmartMusicPart", 1, "SmartMusicMatchRequest success but the music size is 0");
        return true;
      }
      return false;
    }
    paramSmartMatchMusicRsp = new StringBuilder();
    paramSmartMatchMusicRsp.append("SmartMusicMatchRequest failed");
    paramSmartMatchMusicRsp.append(BaseRequest.concactRetCodeAndMsg(paramLong, paramString));
    QLog.w("EditVideoSmartMusicPart", 1, paramSmartMatchMusicRsp.toString());
    return true;
  }
  
  private void l()
  {
    if ((this.t.I.e instanceof EditTakeVideoSource))
    {
      localObject = (EditTakeVideoSource)this.t.I.e;
      this.D = ((EditTakeVideoSource)localObject).b;
      this.E = ((EditTakeVideoSource)localObject).a;
    }
    else if ((this.t.I.e instanceof EditLocalVideoSource))
    {
      localObject = (EditLocalVideoSource)this.t.I.e;
      this.D = ((EditLocalVideoSource)localObject).b;
      this.E = ((EditLocalVideoSource)localObject).a;
      this.Q = ((EditLocalVideoSource)localObject).b.mStartTime;
    }
    this.V = new VsMediaPlayer();
    this.V.a(this);
    Object localObject = this.D;
    if (localObject != null)
    {
      this.V.a(((LocalMediaInfo)localObject).mDuration);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131901889));
      ((StringBuilder)localObject).append("\n视频时长：");
      ((StringBuilder)localObject).append(this.D.mDuration / 1000L);
      ((StringBuilder)localObject).append("s");
      a(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131901905));
      ((StringBuilder)localObject).append(this.D.mediaWidth);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(this.D.mediaHeight);
      a(((StringBuilder)localObject).toString());
      ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).setVideoDuration(this.D.mDuration / 1000L);
    }
    if (this.Y) {
      this.V.a(60000);
    }
    this.M = ((ArrayList)this.t.p().getSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES"));
    int i1;
    if (this.t.p().getInt("KEY_VIDEO_STORY_CAMERA_TYPE", 2) == 2) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    this.W = i1;
    this.N = this.t.p().getLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE");
    m();
  }
  
  private void m()
  {
    this.af = new File("/storage/emulated/0/Tencent/MobileQQ/video_story/", "smart_music_anim.zip");
    n();
    if ((!this.af.exists()) && (!StringUtil.isEmpty(this.ag)))
    {
      ThreadManagerV2.executeOnNetWorkThread(new EditVideoSmartMusicPart.1(this));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("animFile exist:");
    localStringBuilder.append(this.af.exists());
    localStringBuilder.append(" | downloadUrl:");
    localStringBuilder.append(this.ag);
    QLog.i("EditVideoSmartMusicPart", 1, localStringBuilder.toString());
  }
  
  private void n()
  {
    File localFile1 = new File("/storage/emulated/0/Tencent/MobileQQ/video_story/smart_music_anim/");
    if ((localFile1.exists()) && (localFile1.listFiles() != null))
    {
      if (localFile1.listFiles().length < 25)
      {
        File localFile2 = this.af;
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
  
  private void o()
  {
    this.K = d(2063991607);
    this.L = ((TextView)d(2063991525));
    this.R = ((TextView)d(2063991564));
    this.f = ((RelativeLayout)d(2063991594));
    this.g = ((ImageView)d(2063991202));
    this.h = ((ImageView)d(2063991197));
    this.k = ((TextView)d(2063991549));
    this.ae = ((ImageView)d(2063991187));
    this.C = ((SingleLyricView)d(2063991423));
    this.H = ((ImageView)d(2063991424));
    this.z = u().getResources().getDrawable(2130853443);
    this.A = u().getResources().getDrawable(2130853442);
    this.I = d(2063991238);
    this.I.setOnClickListener(this);
    this.J = d(2063991232);
    this.J.setOnClickListener(this);
    this.ad = ((FrameLayout)d(2063991090));
    this.p = this.t.H.getActivity().findViewById(2063990908);
    this.o = this.t.H.getActivity().findViewById(2063990907);
    this.ad.setOnClickListener(this);
    p();
    this.L.setOnClickListener(new EditVideoSmartMusicPart.2(this));
    this.R.setOnClickListener(new EditVideoSmartMusicPart.3(this));
    Object localObject = this.I;
    if ((localObject != null) && (this.Y)) {
      ((View)localObject).setVisibility(8);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getRealHeight");
    ((StringBuilder)localObject).append(ScreenUtil.getRealHeight(u()));
    ((StringBuilder)localObject).append("ScreenUtil.getRealWidth(getContext())");
    ((StringBuilder)localObject).append(ScreenUtil.getRealWidth(u()));
    QLog.d("EditVideoSmartMusicPart", 2, ((StringBuilder)localObject).toString());
    if (ScreenUtil.getRealHeight(u()) / ScreenUtil.getRealWidth(u()) >= 2.0F)
    {
      LiuHaiUtils.h((Activity)u());
      this.o.setVisibility(8);
      this.p.setVisibility(8);
    }
    else if ((this.t.Z != null) && (this.t.Z.getLayoutParams() != null))
    {
      this.K.setPadding(0, 0, 0, this.t.Z.getLayoutParams().height);
    }
    int i1;
    int i2;
    int i3;
    if ((AECameraEntry.c.b(this.t.I.h)) && ((this.t.I.d()) || (this.t.I.b()) || (this.t.I.c())))
    {
      i1 = AIOUtils.b(105.0F, u().getResources());
      i2 = AIOUtils.b(34.0F, u().getResources());
      i3 = AIOUtils.b(19.0F, u().getResources());
    }
    else
    {
      i1 = AIOUtils.b(17.0F, u().getResources());
      i2 = AIOUtils.b(0.0F, u().getResources());
      i3 = AIOUtils.b(-15.0F, u().getResources());
    }
    localObject = this.f;
    ((RelativeLayout)localObject).setPadding(((RelativeLayout)localObject).getPaddingLeft(), this.f.getPaddingTop(), this.f.getPaddingRight(), i1);
    localObject = (ViewGroup.MarginLayoutParams)this.ad.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = i2;
    this.ad.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (ViewGroup.MarginLayoutParams)this.i.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = i3;
    this.i.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void p()
  {
    this.i = ((SmartMusicRecyclerView)d(2063990999));
    this.j = ((SmartMusicAdapter)this.i.getAdapter());
    this.i.setListener(new EditVideoSmartMusicPart.4(this));
  }
  
  private void q()
  {
    Object localObject1 = this.j;
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = ((SmartMusicAdapter)localObject1).a(this.c);
    if (localObject2 == null) {
      return;
    }
    localObject1 = new JSONObject();
    long l1 = System.currentTimeMillis();
    long l2 = this.aa;
    try
    {
      ((JSONObject)localObject1).put("music_id", ((VsMusicItemInfo)localObject2).mSongMid);
      ((JSONObject)localObject1).put("music_play_time", l1 - l2);
      if (this.D != null) {
        ((JSONObject)localObject1).put("video_duration", this.D.mDuration);
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    VSReporter.a("mystatus_edit", "aimusic_exp_clk", 0, 0, new String[] { String.valueOf(((VsMusicItemInfo)localObject2).c), "", ((JSONObject)localObject1).toString() });
    this.aa = System.currentTimeMillis();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("reportSmartMusic   reportClickMusic() args3:");
    ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
    SLog.c("EditVideoSmartMusicPart", ((StringBuilder)localObject2).toString());
  }
  
  private void y()
  {
    A();
    this.P = System.currentTimeMillis();
    Object localObject = this.M;
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("抽帧耗时：0ms\n抽取图片数：");
      ((StringBuilder)localObject).append(this.M.size());
      ((StringBuilder)localObject).append("\n抽帧字节数：");
      ((StringBuilder)localObject).append(this.N / 1000L);
      ((StringBuilder)localObject).append("KB");
      a(((StringBuilder)localObject).toString());
      a(this.M);
      return;
    }
    if (this.D == null)
    {
      QLog.w("EditVideoSmartMusicPart", 1, "mLocalMediaInfo is null stop extractFrame");
      return;
    }
    a(HardCodeUtil.a(2131901972));
    this.G = new FrameVideoHelper(this.E, this.D.mediaWidth, this.D.mediaHeight, this.D.mDuration);
    this.G.a(this.Q, new EditVideoSmartMusicPart.5(this));
  }
  
  private void z()
  {
    if ((!this.T) && (this.U == 0))
    {
      y();
      VSReporter.a("mystatus_edit", "musiclib_entry_clk", 0, 0, new String[0]);
    }
    this.r ^= true;
    if (!this.r)
    {
      a(this.m);
      this.h.setBackgroundDrawable(this.z);
    }
    else
    {
      this.V.c();
      this.h.setBackgroundDrawable(this.A);
    }
    C();
  }
  
  public void a()
  {
    super.a();
    this.X = this.t.k();
    this.Y = this.t.l();
    o();
    l();
    a(EditMusicExport.class, this);
    Object localObject = new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    BaseApplicationImpl.getApplication().registerReceiver(this.d, (IntentFilter)localObject);
    this.U = ((Long)VSConfigManager.a().a("SmartMatchMusicSwitch", Long.valueOf(0L))).intValue();
    int i1 = this.U;
    if (i1 != 1)
    {
      if (i1 != 2) {
        return;
      }
      localObject = this.J;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
    else
    {
      y();
      localObject = this.h;
      if (localObject != null)
      {
        ((ImageView)localObject).setBackgroundDrawable(this.z);
        this.r = false;
        this.ad.setVisibility(0);
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
    this.B = true;
    if (this.Y) {
      this.s = true;
    }
    paramGenerateContext.d.putExtra("isMixOriginal", Boolean.valueOf(this.s ^ true));
    paramGenerateContext.d.isMixOriginal = (this.s ^ true);
    paramGenerateContext.d.isMuteRecordVoice = this.s;
    paramGenerateContext.d.putExtra("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", this.t.p().getString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH"));
    paramGenerateContext.d.putExtra("KEY_FROM_PIC_TO_VIDEO", Boolean.valueOf(this.Y));
    paramGenerateContext.d.putExtra("KEY_VIDEO_STORY_CAMERA_TYPE", Boolean.valueOf(this.t.X().isLandTakePicToVideo()));
    if (this.r)
    {
      paramGenerateContext.d.backgroundMusicPath = null;
    }
    else
    {
      Object localObject = this.V;
      if ((localObject != null) && (((VsMediaPlayer)localObject).d() != null))
      {
        VsMusicItemInfo localVsMusicItemInfo = this.V.d();
        paramGenerateContext.d.backgroundMusicOffset = localVsMusicItemInfo.musicStart;
        int i1 = localVsMusicItemInfo.musicEnd - localVsMusicItemInfo.musicStart;
        int i2 = i1;
        if (!this.Y)
        {
          i2 = i1;
          if (i1 < 0) {
            i2 = 60000;
          }
          i2 = Math.min(i2, (int)this.t.b(paramInt));
        }
        paramGenerateContext.d.backgroundMusicDuration = i2;
        paramGenerateContext.d.backgroundMusicPath = localVsMusicItemInfo.getLocalPath();
        paramGenerateContext.d.putExtra("vs_publish_entry_json_key_music_id", Integer.valueOf(localVsMusicItemInfo.mItemId));
        paramGenerateContext.d.putExtra("vs_publish_entry_json_key_music_mid_id", localVsMusicItemInfo.mSongMid);
        paramGenerateContext.d.putExtra("vs_publish_entry_json_key_song_name", localVsMusicItemInfo.mMusicName);
        paramGenerateContext.d.putExtra("vs_publish_entry_json_key_music_album_pic", localVsMusicItemInfo.mAlbumUrl);
        paramGenerateContext.d.putExtra("vs_publish_entry_json_key_music_download_url", localVsMusicItemInfo.mUrl);
        paramGenerateContext.d.putExtra("vs_publish_entry_json_key_music_source_from", Integer.valueOf(localVsMusicItemInfo.c));
        paramGenerateContext.d.putExtra("originalRecordVolume", Float.valueOf(a(1)));
        paramGenerateContext.d.putExtra("backgroundVolume", Float.valueOf(a(2)));
        this.t.X().setSongMid(localVsMusicItemInfo.mSongMid);
        this.t.X().setMusicType(localVsMusicItemInfo.c);
        this.t.X().setMusciPlayTime(System.currentTimeMillis() - this.aa);
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
    if (this.D != null) {
      this.t.X().setVideoDuration(this.D.mDuration);
    }
  }
  
  public void a(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if ((this.m != null) && (!this.r))
    {
      paramMediaPlayer = this.n;
      if (paramMediaPlayer != null)
      {
        paramMediaPlayer.b(false);
        this.n.b();
      }
      QQToast.makeText(BaseApplicationImpl.sApplication, this.m.e, 1).show();
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
    if (paramVsMusicItemInfo.mSongMid.equals(this.m.mSongMid)) {
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
    if (this.r)
    {
      QLog.d("EditVideoSmartMusicPart", 2, "startMusic  music is muted but itemInfo is not MuteInfo");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start replay music name:");
    ((StringBuilder)localObject).append(paramVsMusicItemInfo.mMusicName);
    QLog.d("EditVideoSmartMusicPart", 4, ((StringBuilder)localObject).toString());
    a(paramVsMusicItemInfo);
    localObject = this.n;
    if (localObject != null) {
      ((SmartMusicAdapter.SmartMusicVH)localObject).b(true);
    }
    localObject = this.V;
    if ((localObject != null) && (!this.r))
    {
      ((VsMediaPlayer)localObject).a(a(2));
      this.V.a(paramVsMusicItemInfo);
    }
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    String str = paramString2;
    if (StringUtil.isEmpty(paramString2)) {
      str = "LRC";
    }
    this.C.setData(paramString1, str);
  }
  
  public void a(List<QQCircleSmartMatchMusic.MusicInfo> paramList)
  {
    this.i.setMusicData(paramList);
    if (((paramList == null) || (paramList.size() == 0)) && (this.j.b() == 0))
    {
      QLog.w("EditVideoSmartMusicPart", 1, "setMusicData musicData response is empty");
      return;
    }
    F();
  }
  
  protected boolean a(Message paramMessage)
  {
    if (this.x) {
      return false;
    }
    if (paramMessage.what == 3) {
      b(paramMessage.arg1);
    }
    return super.a(paramMessage);
  }
  
  public void as_()
  {
    h().postDelayed(new EditVideoSmartMusicPart.9(this), 100L);
  }
  
  public void ax_()
  {
    super.ax_();
    this.Z = false;
    VsMediaPlayer localVsMediaPlayer = this.V;
    if (localVsMediaPlayer != null) {
      localVsMediaPlayer.e();
    }
  }
  
  public int b()
  {
    if ((this.j.a() != null) && (this.j.a().size() != 0))
    {
      double d1 = Math.floor(this.j.getItemCount() / this.j.a().size() / 2);
      double d2 = this.j.a().size();
      Double.isNaN(d2);
      return (int)(d1 * d2);
    }
    return 0;
  }
  
  public void b(String paramString) {}
  
  public String c()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.m;
    if ((localVsMusicItemInfo != null) && (this.R != null))
    {
      HashMap localHashMap = this.S;
      if ((localHashMap != null) && (localHashMap.get(localVsMusicItemInfo.mSongMid) != null)) {
        return (String)this.S.get(this.m.mSongMid);
      }
    }
    return "";
  }
  
  public void d()
  {
    Object localObject;
    if (!this.Z)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("playBgMusic in = null mIsResume=");
        ((StringBuilder)localObject).append(this.Z);
        QLog.d("EditVideoSmartMusicPart", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (this.V != null)
    {
      localObject = this.n;
      if (localObject != null)
      {
        ((SmartMusicAdapter.SmartMusicVH)localObject).b(false);
        this.n.d();
      }
      b(this.m);
      this.V.a();
    }
  }
  
  public void f()
  {
    super.f();
    this.Z = true;
    SmartMusicRecyclerView localSmartMusicRecyclerView = this.i;
    if (localSmartMusicRecyclerView != null)
    {
      int i1 = this.ab;
      if (i1 != -1)
      {
        localSmartMusicRecyclerView.smoothScrollToPosition(i1);
        this.ab = -1;
      }
    }
  }
  
  public void g()
  {
    q();
    this.x = true;
    h().removeCallbacks(null);
    BaseApplicationImpl.getApplication().unregisterReceiver(this.d);
    VSNetworkHelper.getInstance().cancelRequest(u());
    Object localObject = this.G;
    if (localObject != null) {
      ((FrameVideoHelper)localObject).a();
    }
    localObject = this.V;
    if (localObject != null) {
      ((VsMediaPlayer)localObject).b();
    }
    localObject = this.C;
    if (localObject != null) {
      ((SingleLyricView)localObject).a();
    }
    localObject = this.n;
    if (localObject != null) {
      ((SmartMusicAdapter.SmartMusicVH)localObject).b();
    }
    h().removeCallbacks(null);
  }
  
  public WeakReferenceHandler h()
  {
    if (this.l == null) {
      this.l = new WeakReferenceHandler(Looper.getMainLooper(), this);
    }
    return this.l;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public Vibrator i()
  {
    if (this.y == null) {
      this.y = ((Vibrator)u().getSystemService("vibrator"));
    }
    return this.y;
  }
  
  public void k()
  {
    SingleLyricView localSingleLyricView = this.C;
    if (localSingleLyricView != null) {
      localSingleLyricView.a();
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2063991090)
    {
      if (i1 != 2063991232)
      {
        if (i1 != 2063991238) {
          return;
        }
        this.s ^= true;
        a(true);
        ImageView localImageView = this.g;
        if (this.s) {
          paramView = this.A;
        } else {
          paramView = this.z;
        }
        localImageView.setBackgroundDrawable(paramView);
        H();
        return;
      }
      z();
      H();
      I();
      return;
    }
    E();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.EditVideoSmartMusicPart
 * JD-Core Version:    0.7.0.1
 */