package com.tencent.aelight.camera.aioeditor.takevideo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.EditVideoSmartMusicPart;
import com.tencent.aelight.camera.aioeditor.ReadInJoyEditVideoButton;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.NewFlowCameraReporter;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.SaveVideoActivity;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.capture.EditState;
import com.tencent.aelight.camera.aioeditor.capture.music.EditVideoQimMusic;
import com.tencent.aelight.camera.aioeditor.docenhance.DocEnhancePart;
import com.tencent.aelight.camera.aioeditor.editipc.PeakIpcController;
import com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.renderer.GPUBitmapImageRender;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.DynamicFaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.LineLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleOpController;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.DoodleRotateSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateDynamicDoodleImageSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GeneratePicArgs;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GeneratePicThumbSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateThumbArgs;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.HWEncodeGenerateThumbSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.HWEncodeMergeThumbSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.MergePicSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.MergeThumbSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.PublishFileManager;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.PublishVideoSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.ResizeBitmapSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelPart;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.entry.api.IAECameraEntryManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.aelight.camera.util.api.IMediaCodecDPC;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoReaderConf;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditLocalPhotoSource;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditTakePhotoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.editor.params.EditVideoParams.EditSource;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.MediaCodecUtil;
import com.tencent.mobileqq.tribe.data.TribeVideoPublishParams;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.ActionSheet;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.reactive.Observer;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.StreamFunction;
import com.tribe.async.reactive.UIThreadOffFunction;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class EditVideoPartManager
  implements IEventReceiver
{
  public static GPUBitmapImageRender ag;
  protected int C = -1;
  protected boolean D = false;
  protected boolean E = false;
  protected boolean F = false;
  public Intent G;
  public EditVideoUi H;
  public EditVideoParams I;
  protected List<EditVideoPart> J = Collections.emptyList();
  protected EditVideoButton K;
  protected EditARCakeButton L;
  protected EditVideoStoryButton M;
  public EditProviderPart N;
  public EditVideoDoodle O;
  protected EditVideoSpeedFilter P;
  protected EditVideoQimMusic Q;
  public EditPicRawImage R;
  protected EditPicCropPart S;
  protected EditVideoSave T;
  protected EditPicSave U;
  protected EditVideoTransfer V;
  protected SendPanelPart W;
  protected DocEnhancePart X;
  public ViewGroup Y;
  public RelativeLayout Z;
  private int a;
  public boolean aa = true;
  protected EditVideoLimitRegion ab;
  protected EditJumpToPtu ac;
  public Bundle ad;
  protected Map<Class<? extends EditVideoPart.EditExport>, EditVideoPart.EditExport> ae = new HashMap();
  public int af = 0;
  protected final AtomicInteger ah = new AtomicInteger(1);
  protected List<Error> ai = new ArrayList();
  protected HWEditLocalVideoPlayer aj;
  private VideoStoryDataBean b;
  private String c;
  private String d;
  private float e;
  private boolean f;
  private float g = 3.0F;
  private Dialog h;
  private ProgressPieDrawable i;
  private QQCustomDialog j;
  
  private void Z()
  {
    EditVideoUi localEditVideoUi = this.H;
    if (localEditVideoUi == null) {
      return;
    }
    localEditVideoUi.getRootView().postDelayed(new EditVideoPartManager.6(this), 1000L);
  }
  
  @NotNull
  private GenerateContext a(EditVideoParams.EditSource paramEditSource, int paramInt1, int paramInt2, String paramString1, float paramFloat, int paramInt3, String paramString2, boolean paramBoolean, long paramLong, String paramString3, String paramString4, int paramInt4, int paramInt5)
  {
    GenerateContext localGenerateContext = new GenerateContext(this.I);
    localGenerateContext.d.multiFragmentGroupId = paramString3;
    localGenerateContext.d.createTime = (paramLong + paramInt4 * 1000);
    localGenerateContext.d.videoMaxrate = CodecParam.mMaxrate;
    if (((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).isCqBitrateModeSwitchOpen())
    {
      localGenerateContext.d.videoMaxrate = (((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).getCqMaxBitrate() * 1000);
      localGenerateContext.d.putExtra("composite_key_bitrate_mode", Boolean.valueOf(((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).isCqBitrateModeSwitchOpen()));
    }
    localGenerateContext.d.videoMinrate = CodecParam.mMinrate;
    localGenerateContext.d.videoUploadGroupTempDir = paramString4;
    localGenerateContext.p = PublishFileManager.a(this.I.a);
    paramString3 = this.H.getActivity();
    paramString4 = this.P;
    boolean bool;
    if ((paramString4 != null) && (paramString4.c() == 5)) {
      bool = true;
    } else {
      bool = false;
    }
    localGenerateContext.i = new GenerateThumbArgs(paramString3, paramInt1, paramInt2, paramString1, paramFloat, bool, paramInt3, 0.0D, 0.0D, paramString2, paramBoolean);
    if ((!(paramEditSource instanceof EditTakeVideoSource)) && (!(paramEditSource instanceof EditLocalVideoSource))) {
      localGenerateContext.d.putExtra("is_hw_encode", Boolean.valueOf(false));
    } else {
      localGenerateContext.d.putExtra("is_hw_encode", Boolean.valueOf(true));
    }
    localGenerateContext.d.putExtra("thumb_rotation", Integer.valueOf(paramInt3));
    localGenerateContext.d.putExtra("composite_key_capturemode", Integer.valueOf(T()));
    localGenerateContext.d.putExtra("composite_key_entrance", Integer.valueOf(this.I.j()));
    paramEditSource = localGenerateContext.a.a("extra_text_filter_text");
    if (!TextUtils.isEmpty(paramEditSource))
    {
      if (TextUtils.isEmpty(localGenerateContext.d.videoDoodleDescription))
      {
        localGenerateContext.d.videoDoodleDescription = paramEditSource;
        return localGenerateContext;
      }
      paramString1 = new StringBuilder();
      paramString2 = localGenerateContext.d;
      paramString1.append(paramString2.videoDoodleDescription);
      paramString1.append(paramEditSource);
      paramString2.videoDoodleDescription = paramString1.toString();
    }
    return localGenerateContext;
  }
  
  private void a(int paramInt)
  {
    if (!j()) {
      Bosses.get().postJob(new EditVideoPartManager.3(this, "Q.qqstory.publish.edit.EditVideoPartManager"));
    }
    if (this.I.a("extra_is_slide_show_video", false)) {
      StoryReportor.a("video_edit", "pub_slides", 0, 0, new String[0]);
    }
    if (this.I.j() == 104) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0) {
      StoryReportor.a("video_shoot_fromweb", "done_pub", 0, 0, new String[0]);
    }
  }
  
  private void a(int paramInt, long paramLong)
  {
    this.e = paramInt;
    this.f = false;
    this.g = (50000.0F / (float)paramLong);
    if (this.g == 0.0F) {
      this.g = 1.0F;
    }
    Z();
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      String str = this.d;
      if ((str == null) || (!str.equals(paramIntent.getStringExtra("fakeId")))) {
        return;
      }
    }
    d(0);
    this.f = true;
    if (paramInt == -1)
    {
      f(100);
      ThreadManager.excute(new EditVideoPartManager.8(this, paramIntent), 64, null, true);
      return;
    }
    if (paramInt == 1)
    {
      aa();
      v();
      return;
    }
    if (paramInt == 0) {
      aa();
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
  
  private void aa()
  {
    Dialog localDialog = this.h;
    if (localDialog != null) {
      localDialog.dismiss();
    }
  }
  
  private ProgressPieDrawable ab()
  {
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(this.H.getContext());
    localProgressPieDrawable.a(AIOUtils.b(50.0F, this.H.getActivity().getResources()));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.h(-1);
    localProgressPieDrawable.g(0);
    localProgressPieDrawable.e(-15550475);
    localProgressPieDrawable.j(3);
    localProgressPieDrawable.D = true;
    localProgressPieDrawable.A = 2;
    localProgressPieDrawable.e(true);
    localProgressPieDrawable.a(new EditVideoPartManager.7(this));
    return localProgressPieDrawable;
  }
  
  private void ac()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    Bundle localBundle = this.I.d;
    localSessionInfo.a = localBundle.getInt("uintype");
    localSessionInfo.b = localBundle.getString("uin");
    localSessionInfo.c = localBundle.getString("troop_uin");
    localSessionInfo.e = localBundle.getString("uinname");
    PeakIpcController.a(localSessionInfo, "baseView", "{\n  \"data\": {\n    \"puin\": \"892820726\",\n    \"nick\": \"我五岁了哦！\",\n    \"id\": \"xx\",\n    \"avatarJumpUrl\": \"https://h5.qzone.qq.com/v2/wezone/jump?_wv=3&_proxy=1&schema=mqqapi%3A%2F%2Fqcircle%2Fopenmainpage%3Fuin%3D892820726%26issinglefeed%3D1%26from%3D6%26sharecategory%3D2%26shareentrance%3D1\",\n    \"contentJumpUrl\": \"https://h5.qzone.qq.com/v2/wezone/jump?_wv=3&_proxy=1&schema=mqqapi%3A%2F%2Fqcircle%2Fopendetail%3Ffeedid%3DB_193ead5f48eb06008928207260X5c%26sourcetype%3D10%26createtime%3D1605189145%26uin%3D892820726%26shareuin%3D1715054455%26issinglefeed%3D1%26from%3D6%26is_feed_detail%3D1%26sharecategory%3D2%26shareentrance%3D1\",\n    \"iconJumpUrl\": \"https://h5.qzone.qq.com/v2/wezone/jump?_wv=3&_proxy=1&schema=mqqapi%3A%2F%2Fqcircle%2Fopenfolder%3Fissinglefeed%3D1%26from%3D6%26sharecategory%3D2%26shareentrance%3D1\",\n    \"media\": [\n      {\n        \"isVideo\": true,\n        \"videoDuration\": 6153,\n        \"height\": 1080,\n        \"width\": 612,\n        \"url\": \"https://photogz.photo.store.qq.com/psc?/V54acxHN3cWMMd1uSEP42tVDpt3rbFDX/bqQfVz5yrrGYSXMvKr.cqfwp.5mjtGNPmLXd7x240uDFGDWpqsTaAx9IH1rzBk4C2oJi9NLpvQo.nrHoAHTVX6w0vBQPm2u1D8U5owjcQfc!/b&ek=1&kp=1&pt=0&bo=ZAI4BGQCOAQRECc!&tl=1&lsr=6&vuin=1715054455&tm=1607943600#sce=79-11-1&rf=v1_and_sq_8.5.0_0_rdm_b_t_-2-0-31\"\n      }\n    ],\n    \"total\": 1,\n    \"title\": \"分享了来自小世界的作品\",\n    \"type\": 2,\n    \"isAIO\": 1,\n    \"appName\": \"qcircle\",\n    \"fuelNum\": 57393,\n    \"likeNum\": 41463\n  }\n}");
  }
  
  private void ad()
  {
    if ((this.H != null) && (this.I != null)) {
      return;
    }
    throw new IllegalStateException("have not attach ui and params");
  }
  
  private void b(EditVideoParams.EditSource paramEditSource, Observer<GenerateContext> paramObserver)
  {
    Object localObject1 = new GenerateContext(this.I);
    ((GenerateContext)localObject1).d.videoMaxrate = CodecParam.mMaxrate;
    ((GenerateContext)localObject1).d.videoMinrate = CodecParam.mMinrate;
    ((GenerateContext)localObject1).p = this.I.a("extra_upload_temp_directory");
    if (((GenerateContext)localObject1).p == null) {
      ((GenerateContext)localObject1).p = PublishFileManager.a(this.I.a);
    }
    ((GenerateContext)localObject1).l = new GeneratePicArgs(paramEditSource.a());
    paramEditSource = this.J.iterator();
    while (paramEditSource.hasNext()) {
      ((EditVideoPart)paramEditSource.next()).a(0, (GenerateContext)localObject1);
    }
    a((GenerateContext)localObject1);
    b((GenerateContext)localObject1);
    SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH start, Folder = %s", new Object[] { ((GenerateContext)localObject1).p });
    this.H.showLoadingDialog(HardCodeUtil.a(2131901891), false, 500L);
    this.ah.set(1);
    this.ai.clear();
    paramEditSource = Stream.of(localObject1).map(new ThreadOffFunction("Q.qqstory.publish.edit.EditVideoPartManager", 2)).map(new MergePicSegment(false)).map(new ResizeBitmapSegment());
    localObject1 = this.H.getActivity();
    Object localObject2 = this.P;
    int k;
    if (localObject2 != null) {
      k = ((EditVideoSpeedFilter)localObject2).c();
    } else {
      k = 0;
    }
    localObject1 = paramEditSource.map(new GeneratePicThumbSegment((Activity)localObject1, k));
    localObject2 = this.O;
    paramEditSource = (EditVideoParams.EditSource)localObject1;
    if (localObject2 != null) {
      paramEditSource = ((Stream)localObject1).map(((EditVideoDoodle)localObject2).c(0));
    }
    paramEditSource.map(new MergeThumbSegment()).map((StreamFunction)StoryApi.a(DoodleRotateSegment.class, new Object[0])).map(new PublishVideoSegment(this.I)).map(new UIThreadOffFunction(this)).subscribe(paramObserver);
  }
  
  private void c(GenerateContext paramGenerateContext)
  {
    if (this.H.getActivity() == null)
    {
      AEQLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "jumpToSaveVideoForAioSendVideoArkMsg--activity not exist");
      return;
    }
    c(HardCodeUtil.a(2131901839));
    paramGenerateContext = paramGenerateContext.m;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("jumpToSaveVideoForAioSendVideoArkMsg: publishParam=");
    ((StringBuilder)localObject).append(paramGenerateContext);
    AEQLog.a("Q.qqstory.publish.edit.EditVideoPartManager", ((StringBuilder)localObject).toString());
    localObject = this.H.getActivity().getIntent();
    boolean bool = false;
    int m;
    if (localObject != null)
    {
      k = ((Intent)localObject).getIntExtra("sv_total_frame_count", 0);
      m = ((Intent)localObject).getIntExtra("sv_total_record_time", 0);
    }
    else
    {
      k = 0;
      m = 0;
    }
    Intent localIntent = SaveVideoActivity.a(this.H.getContext(), paramGenerateContext.b, m, k, this.I.h());
    this.d = paramGenerateContext.b;
    int k = AECameraEntry.a.a();
    if (localObject != null) {
      k = ((Intent)localObject).getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
    }
    localIntent.putExtra("mediacodec_encode_enable", true);
    if (paramGenerateContext.m != 0) {
      bool = true;
    }
    localIntent.putExtra("video_edit_flag", bool);
    localIntent.putExtra("thumbfile_send_path", paramGenerateContext.c);
    localIntent.putExtra("VIDEO_STORY_FROM_TYPE", k);
    if (localObject != null)
    {
      localIntent.putExtra("widgetinfo", ((Intent)localObject).getStringExtra("widgetinfo"));
      String str = ((Intent)localObject).getStringExtra("key_camera_material_name");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start SaveVideoActivity---takeSameName=");
      localStringBuilder.append(str);
      AEQLog.b("Q.qqstory.publish.edit.EditVideoPartManager", localStringBuilder.toString());
      localIntent.putExtra("key_camera_material_name", str);
      localIntent.putExtra("qqstory_slide_show_scene", ((Intent)localObject).getIntExtra("qqstory_slide_show_scene", -1));
    }
    this.H.getActivity().startActivityForResult(localIntent, 237);
    a(5, paramGenerateContext.j);
  }
  
  @TargetApi(14)
  private void c(String paramString)
  {
    if (this.h == null)
    {
      this.h = new Dialog(this.H.getContext());
      Object localObject = this.h.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        ((Window)localObject).setDimAmount(0.0F);
      }
      this.h.requestWindowFeature(1);
      this.h.setContentView(2131628207);
      localObject = (ImageView)this.h.findViewById(2131440726);
      this.i = ab();
      ((ImageView)localObject).setImageDrawable(this.i);
    }
    ((TextView)this.h.findViewById(2131438908)).setText(paramString);
    this.h.setCancelable(false);
    this.h.setCanceledOnTouchOutside(false);
    h(0);
    this.H.getRootView().post(new EditVideoPartManager.5(this));
  }
  
  private void d()
  {
    a(0);
  }
  
  private void d(String paramString)
  {
    PeakIpcController.a(paramString, new EditVideoPartManager.11(this));
  }
  
  private void e()
  {
    if (this.I.h() == 14)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportPublish()  entranceType=");
      ((StringBuilder)localObject).append(this.I.j());
      ((StringBuilder)localObject).append(" , isEditCamera:");
      ((StringBuilder)localObject).append(this.I.d());
      SLog.c("Q.qqstory.publish.edit.EditVideoPartManager", ((StringBuilder)localObject).toString());
      int k;
      if (this.I.j() == 120) {
        k = 1;
      } else {
        k = 2;
      }
      int m;
      if (this.I.d()) {
        m = 1;
      } else {
        m = 2;
      }
      localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("lens_tab", X().getLensTabId());
        ((JSONObject)localObject).put("watermark_id", X().getWatermarkId());
        ((JSONObject)localObject).put("music_id", X().getSongMid());
        ((JSONObject)localObject).put("filter_id", X().getFilterId());
        ((JSONObject)localObject).put("sticker_id", X().getStickerId());
        ((JSONObject)localObject).put("word_id", X().getWordId());
        if (X().getMusicType() == 1) {
          ((JSONObject)localObject).put("music_play_time", X().getMusciPlayTime());
        }
        ((JSONObject)localObject).put("video_duration", X().getVideoDuration());
        localJSONObject.put("music_type", X().getMusicType());
        localJSONObject.put("filter_type", X().getFilterType());
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      VSReporter.a("mystatus_edit", "post_clk", k, 0, new String[] { String.valueOf(m), "", ((JSONObject)localObject).toString(), localJSONObject.toString() });
    }
  }
  
  private void f(int paramInt)
  {
    int k = paramInt;
    if (g()) {
      k = (int)(paramInt * 50.0F / 100.0F);
    }
    h(k);
  }
  
  private void g(int paramInt)
  {
    int k = paramInt;
    if (g()) {
      k = (int)(paramInt * 50.0F / 100.0F + 50.0F);
    }
    h(k);
  }
  
  private boolean g()
  {
    return (!TextUtils.isEmpty(this.c)) && (this.I.h() == 14);
  }
  
  private void h(int paramInt)
  {
    Object localObject = this.i;
    if (localObject == null) {
      return;
    }
    ((ProgressPieDrawable)localObject).b();
    this.i.d(paramInt);
    this.i.b(true);
    this.i.d(false);
    localObject = this.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("%");
    ((ProgressPieDrawable)localObject).a(localStringBuilder.toString());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[setProgress] current:");
      ((StringBuilder)localObject).append(this.i.c());
      ((StringBuilder)localObject).append(", progress:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  void A()
  {
    EditVideoDoodle localEditVideoDoodle = this.O;
    if (localEditVideoDoodle != null) {
      localEditVideoDoodle.b().j();
    }
    d(9);
    if (SlideShowPhotoListManager.a().e() == 22)
    {
      LpReportInfo_pf00064.allReport(680, 2, 6);
      LpReportInfo_pf00064.allReport(680, 12, 1);
    }
  }
  
  void B()
  {
    this.O.b().j();
    d(19);
    if (SlideShowPhotoListManager.a().e() == 22)
    {
      LpReportInfo_pf00064.allReport(680, 2, 5);
      LpReportInfo_pf00064.allReport(680, 13, 1);
    }
  }
  
  public void C()
  {
    Object localObject = this.O;
    if (localObject != null)
    {
      localObject = ((EditVideoDoodle)localObject).b();
      if (localObject != null) {
        ((DoodleLayout)localObject).w.d();
      }
    }
  }
  
  void D()
  {
    Object localObject = this.S;
    ((EditPicCropPart)localObject).o += L();
    int k = this.C;
    int m = 0;
    if (k == 7)
    {
      d(0);
      return;
    }
    localObject = this.O.b();
    ((DoodleLayout)localObject).h();
    LineLayer localLineLayer = ((DoodleLayout)localObject).getLineLayer();
    k = m;
    if (localLineLayer != null)
    {
      k = m;
      if (localLineLayer.b.g())
      {
        this.H.showLoadingDialog(HardCodeUtil.a(2131901871), false, 500L);
        this.O.e = 3;
        ((DoodleLayout)localObject).o();
        k = 1;
      }
    }
    if (k == 0) {
      E();
    }
  }
  
  public void E()
  {
    this.H.dismissLoadingDialog();
    Object localObject1 = this.O.b();
    Object localObject2 = ((DoodleLayout)localObject1).j(0);
    Object localObject3 = ((DoodleLayout)localObject1).l(0);
    this.S.s[0] = localObject2[0];
    this.S.s[1] = localObject2[1];
    this.S.s[2] = localObject3[0];
    this.S.s[3] = localObject3[1];
    this.S.s[4] = ((DoodleLayout)localObject1).getTextLayer().q();
    localObject2 = H();
    if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
    {
      localObject3 = ((DoodleLayout)localObject1).getDoodleBitmap();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = BitmapUtils.c((Bitmap)localObject2, (Bitmap)localObject3);
        SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "onPrepareCropDone merged");
      }
      this.S.h = ((Bitmap)localObject1);
      d(7);
      return;
    }
    SLog.e("Q.qqstory.publish.edit.EditVideoPartManager", "onPrepareCropDone fail");
  }
  
  public void F()
  {
    EditVideoDoodle localEditVideoDoodle = this.O;
    if (localEditVideoDoodle != null) {
      localEditVideoDoodle.b().k();
    }
  }
  
  public void G()
  {
    EditVideoDoodle localEditVideoDoodle = this.O;
    if (localEditVideoDoodle != null) {
      localEditVideoDoodle.b().v();
    }
  }
  
  public Bitmap H()
  {
    EditPicRawImage localEditPicRawImage = this.R;
    if (localEditPicRawImage != null) {
      return localEditPicRawImage.d();
    }
    return null;
  }
  
  public void I()
  {
    K();
    d(0);
  }
  
  public void J()
  {
    EditProviderPart localEditProviderPart = this.N;
    if (localEditProviderPart != null) {
      localEditProviderPart.l();
    }
  }
  
  public void K()
  {
    d(24);
    ThreadManager.getUIHandler().post(new EditVideoPartManager.12(this));
  }
  
  public int L()
  {
    EditVideoDoodle localEditVideoDoodle = this.O;
    if (localEditVideoDoodle != null) {
      return localEditVideoDoodle.b(m());
    }
    return 0;
  }
  
  public EditVideoUi M()
  {
    return this.H;
  }
  
  public EditVideoDoodle N()
  {
    return this.O;
  }
  
  public void O()
  {
    Iterator localIterator = this.J.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).j();
    }
  }
  
  public int P()
  {
    return this.a;
  }
  
  public int Q()
  {
    EditVideoDoodle localEditVideoDoodle = this.O;
    if (localEditVideoDoodle != null) {
      return localEditVideoDoodle.k();
    }
    return 0;
  }
  
  View R()
  {
    EditVideoButton localEditVideoButton = this.K;
    if (localEditVideoButton != null) {
      return localEditVideoButton.i();
    }
    return null;
  }
  
  public long S()
  {
    return 0L;
  }
  
  public int T()
  {
    int m = this.I.b;
    int k = m;
    if ((this.I.e instanceof EditLocalVideoSource))
    {
      k = m;
      if (m != 9) {
        k = 2;
      }
    }
    return k;
  }
  
  public int U()
  {
    if (k())
    {
      if (j()) {
        return 3;
      }
      return 4;
    }
    if (j()) {
      return 1;
    }
    return 2;
  }
  
  public int V()
  {
    EditVideoParams localEditVideoParams = this.I;
    int k = 4;
    if (localEditVideoParams != null)
    {
      int m = localEditVideoParams.h();
      if (m != 2)
      {
        if (m == 3) {
          return k;
        }
        if (m != 4) {
          if (m != 11)
          {
            if (m != 12) {
              break label52;
            }
          }
          else {
            return 2;
          }
        }
        return 3;
      }
      else
      {
        return 5;
      }
    }
    label52:
    k = 0;
    return k;
  }
  
  public List<EditVideoPart> W()
  {
    return this.J;
  }
  
  public VideoStoryDataBean X()
  {
    try
    {
      if (this.b == null)
      {
        VideoStoryDataBean localVideoStoryDataBean2 = (VideoStoryDataBean)p().getSerializable("KEY_VIDEO_STORY_CAMERA_TYPE");
        VideoStoryDataBean localVideoStoryDataBean1 = localVideoStoryDataBean2;
        if (localVideoStoryDataBean2 == null) {
          localVideoStoryDataBean1 = new VideoStoryDataBean();
        }
        this.b = localVideoStoryDataBean1;
      }
    }
    catch (Exception localException)
    {
      QLog.e("Q.qqstory.publish.edit.EditVideoPartManager", 1, "getVsDataBean error", localException);
      this.b = new VideoStoryDataBean();
    }
    return this.b;
  }
  
  public boolean Y()
  {
    SendPanelPart localSendPanelPart = this.W;
    return (localSendPanelPart != null) && (localSendPanelPart.a);
  }
  
  public int a(@NonNull Message paramMessage)
  {
    z();
    if (this.E)
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "broadcast message ignore because of publishing");
      return 0;
    }
    Iterator localIterator = this.J.iterator();
    int k = 0;
    while (localIterator.hasNext()) {
      if (((EditVideoPart)localIterator.next()).b(Message.obtain(paramMessage))) {
        k += 1;
      }
    }
    if (k == 0) {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "broadcastEditVideoMessage, but no one handled", new Object[] { paramMessage });
    }
    paramMessage.recycle();
    return k;
  }
  
  @Nullable
  public EditVideoPart.EditExport a(Class<? extends EditVideoPart.EditExport> paramClass)
  {
    if (paramClass != null) {
      return (EditVideoPart.EditExport)this.ae.get(paramClass);
    }
    throw new IllegalArgumentException("editExportClass should not be null");
  }
  
  public String a(Bitmap paramBitmap)
  {
    EditProviderPart localEditProviderPart = this.N;
    if (localEditProviderPart != null) {
      return localEditProviderPart.a(paramBitmap);
    }
    return "";
  }
  
  public void a()
  {
    z();
    ad();
    EditVideoParams.EditSource localEditSource = this.I.e;
    int k = 0;
    SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "onConfirmClick : %s", new Object[] { localEditSource });
    Object localObject2 = this.H.getActivity().getIntent();
    if (!this.E)
    {
      if ((((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isStoryPhoto((Intent)localObject2, this.I.h())) || (((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isSameStoryPhotoEntry((Intent)localObject2)))
      {
        Object localObject3 = this.H.getActivity();
        localObject1 = "";
        if ((localObject3 != null) && (this.H.getActivity().getIntent() != null) && (this.H.getActivity().getIntent().getBundleExtra("state") != null)) {
          localObject1 = this.H.getActivity().getIntent().getBundleExtra("state").getString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH");
        }
        if ((this.I.e instanceof EditLocalVideoSource))
        {
          localObject3 = new LocalMediaInfo();
          this.I.e = new EditLocalPhotoSource((String)localObject1, (LocalMediaInfo)localObject3);
        }
        A();
      }
      this.E = true;
      Object localObject1 = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
      if (localObject1 != null) {
        ((EditVideoPlayerExport)localObject1).h();
      }
      if ((!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isStoryPhoto((Intent)localObject2, this.I.h())) && (!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isSameStoryPhotoEntry((Intent)localObject2)))
      {
        localObject1 = f();
        boolean bool = localEditSource instanceof EditLocalVideoSource;
        if ((!bool) && (!(localEditSource instanceof EditTakeVideoSource)))
        {
          if (((localEditSource instanceof EditLocalPhotoSource)) || ((localEditSource instanceof EditTakePhotoSource)))
          {
            d();
            CodecParam.mRecordTime = 5000;
            CodecParam.mRecordFrames = 125;
            CodecParam.mIsSmooth = 0;
            CodecParam.mEnableTotalTimeAdjust = 0;
            localObject2 = this.P;
            if (localObject2 != null) {
              k = ((EditVideoSpeedFilter)localObject2).c();
            }
            CodecParam.mSaveMode = k;
            b(localEditSource, (Observer)localObject1);
          }
        }
        else
        {
          a(localEditSource, (Observer)localObject1);
          if (bool) {
            StoryReportor.a("video_edit", "pub_local", 0, 1, new String[0]);
          }
        }
        e();
        return;
      }
      e();
      return;
    }
    SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "requestPublish duplicate");
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 237)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityResult---CODE_REQ_AIO_SAVE_ARK_VIDEO--resultCode=");
      ((StringBuilder)localObject).append(paramInt2);
      AEQLog.b("Q.qqstory.publish.edit.EditVideoPartManager", ((StringBuilder)localObject).toString());
      a(paramInt2, paramIntent);
      return;
    }
    Object localObject = this.H.getActivity().getIntent();
    if (((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isFromMiniApp((Intent)localObject))
    {
      AEQLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "onActivityResult---isFromMiniApp");
      this.H.finish(-1, paramIntent, 2130772081, 0, true);
      return;
    }
    localObject = this.J.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((EditVideoPart)((Iterator)localObject).next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public final void a(int paramInt, Object paramObject)
  {
    z();
    ad();
    if (this.E)
    {
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "change state ignore because of publishing, %s", new Throwable());
      return;
    }
    if ((this.C != paramInt) || (paramInt == 2) || (paramInt == 23))
    {
      if (this.D)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("change state while state changing, ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" oldState:");
        ((StringBuilder)localObject).append(this.C);
        SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", ((StringBuilder)localObject).toString(), new Throwable());
      }
      this.D = true;
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "changeState : %s => %s", Integer.valueOf(this.C), Integer.valueOf(paramInt));
      int k = this.C;
      this.C = paramInt;
      Object localObject = this.J.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((EditVideoPart)((Iterator)localObject).next()).a(k, this.C, paramObject);
      }
    }
    this.D = false;
  }
  
  public void a(Context paramContext)
  {
    if (this.I.j() == 14) {
      StoryReportor.a("story_grp", "clk_send", 0, 0, new String[0]);
    }
  }
  
  void a(Intent paramIntent, int paramInt, PublishParam paramPublishParam, TribeVideoPublishParams paramTribeVideoPublishParams)
  {
    if (paramInt != 11)
    {
      if (paramInt != 12)
      {
        this.H.finish(-1, paramIntent, 2130772081, 0, true);
        return;
      }
      this.H.finish(-1, paramIntent, 2130772081, 0, true);
      return;
    }
    paramInt = -1;
    paramPublishParam = null;
    Iterator localIterator = this.J.iterator();
    while (localIterator.hasNext())
    {
      EditVideoPart localEditVideoPart = (EditVideoPart)localIterator.next();
      if ((localEditVideoPart instanceof DovTribeEditVideoButton))
      {
        paramPublishParam = (DovTribeEditVideoButton)localEditVideoPart;
        paramInt = paramPublishParam.c();
        paramPublishParam = paramPublishParam.d();
      }
    }
    paramIntent.putExtra("theme_id", paramInt);
    paramIntent.putExtra("theme_name", paramPublishParam);
    paramIntent.putExtra(TribeVideoPublishParams.BUNDLE_EXTRA_KEY, paramTribeVideoPublishParams);
    if (QLog.isColorLevel()) {
      QLog.i("tribe_publish", 2, "getPublishIntent");
    }
    this.H.finish(-1, paramIntent, 2130772081, 0, true);
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    z();
    EditPicRawImage localEditPicRawImage = this.R;
    if (localEditPicRawImage != null) {
      localEditPicRawImage.a(paramBitmap, paramBoolean);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    Iterator localIterator = this.J.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).b(paramBundle);
    }
  }
  
  public void a(EditVideoUi paramEditVideoUi, EditVideoParams paramEditVideoParams)
  {
    z();
    if ((paramEditVideoUi != null) && (paramEditVideoParams != null))
    {
      if ((this.H == paramEditVideoUi) && (this.I == paramEditVideoParams))
      {
        SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "duplicate attachUiAndParams ui=%s, params=%s", new Object[] { paramEditVideoUi, paramEditVideoParams });
        return;
      }
      this.H = paramEditVideoUi;
      this.I = paramEditVideoParams;
      a(this.I);
      paramEditVideoParams = this.J.iterator();
      while (paramEditVideoParams.hasNext()) {
        ((EditVideoPart)paramEditVideoParams.next()).a(paramEditVideoUi);
      }
      return;
    }
    paramEditVideoUi = new IllegalArgumentException("both ui ant params should not be null");
    for (;;)
    {
      throw paramEditVideoUi;
    }
  }
  
  public void a(GenerateContext paramGenerateContext)
  {
    Object localObject = paramGenerateContext.d.readerConfBytes;
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = new qqstory_struct.VideoReaderConf();
      ((qqstory_struct.VideoReaderConf)localObject).ban_type.set(0);
      ((qqstory_struct.VideoReaderConf)localObject).setHasFlag(true);
      paramGenerateContext.d.readerConfBytes = ((qqstory_struct.VideoReaderConf)localObject).toByteArray();
    }
  }
  
  public void a(EditVideoParams.EditSource paramEditSource, Observer<GenerateContext> paramObserver)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    boolean bool = paramEditSource instanceof EditLocalVideoSource;
    String str2 = "Q.qqstory.publish.edit.EditVideoPartManager";
    Object localObject1;
    Object localObject2;
    int k;
    int m;
    int n;
    float f1;
    if (bool)
    {
      localObject1 = (EditLocalVideoSource)paramEditSource;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("publishVideo CodecParam.mRecordFrames");
      ((StringBuilder)localObject2).append(CodecParam.mRecordFrames);
      ((StringBuilder)localObject2).append(" CodecParam.mRecordTime");
      ((StringBuilder)localObject2).append(CodecParam.mRecordTime);
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", ((StringBuilder)localObject2).toString());
      CodecParam.mRecordTime = 5000;
      CodecParam.mRecordFrames = 125;
      CodecParam.mIsSmooth = 0;
      CodecParam.mEnableTotalTimeAdjust = 0;
      localObject2 = this.P;
      if (localObject2 != null) {
        k = ((EditVideoSpeedFilter)localObject2).c();
      } else {
        k = 0;
      }
      CodecParam.mSaveMode = k;
      m = ((EditLocalVideoSource)localObject1).b();
      n = ((EditLocalVideoSource)localObject1).c();
      k = Math.min(m, n);
      m = Math.max(m, n);
      localObject2 = ((EditLocalVideoSource)localObject1).a();
      f1 = k * 1.0F / m;
      n = ((EditLocalVideoSource)localObject1).b.rotation;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("publishVideo EditLocalVideoSource.mediaInfo");
      ((StringBuilder)localObject3).append(((EditLocalVideoSource)localObject1).b.toString());
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", ((StringBuilder)localObject3).toString());
    }
    for (;;)
    {
      break;
      if (!(paramEditSource instanceof EditTakeVideoSource)) {
        break label1001;
      }
      localObject1 = (EditTakeVideoSource)paramEditSource;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("publishVideo CodecParam.mRecordFrames");
      ((StringBuilder)localObject2).append(CodecParam.mRecordFrames);
      ((StringBuilder)localObject2).append(" CodecParam.mRecordTime");
      ((StringBuilder)localObject2).append(CodecParam.mRecordTime);
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", ((StringBuilder)localObject2).toString());
      CodecParam.mRecordTime = 5000;
      CodecParam.mRecordFrames = 125;
      CodecParam.mIsSmooth = 0;
      CodecParam.mEnableTotalTimeAdjust = 0;
      localObject2 = this.P;
      if (localObject2 != null) {
        k = ((EditVideoSpeedFilter)localObject2).c();
      } else {
        k = 0;
      }
      CodecParam.mSaveMode = k;
      k = ((EditTakeVideoSource)localObject1).b();
      m = ((EditTakeVideoSource)localObject1).c();
      localObject2 = ((EditTakeVideoSource)localObject1).a();
      f1 = k * 1.0F / m;
      n = ((EditTakeVideoSource)localObject1).b.rotation;
    }
    Object localObject3 = new ArrayList();
    ((List)localObject3).add(Integer.valueOf(0));
    String str1 = String.format("%s.%d", new Object[] { QQStoryContext.a().g(), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)) });
    SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "publish video groupId=%s. fragment count=%d", str1, Integer.valueOf(((List)localObject3).size()));
    String str3 = this.I.a("extra_upload_temp_directory");
    this.ah.set(((List)localObject3).size());
    this.ai.clear();
    int i1 = 0;
    while (i1 < ((List)localObject3).size())
    {
      int i2 = ((Integer)((List)localObject3).get(i1)).intValue();
      a(i2);
      localObject1 = a(paramEditSource, k, m, (String)localObject2, f1, n, "", false, l, str1, str3, i1, i2);
      Object localObject4 = this.J.iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((EditVideoPart)((Iterator)localObject4).next()).a(i2, (GenerateContext)localObject1);
      }
      a((GenerateContext)localObject1);
      b((GenerateContext)localObject1);
      SLog.d(str2, "PUBLISH start, Folder = %s", new Object[] { ((GenerateContext)localObject1).p });
      this.H.showLoadingDialog(HardCodeUtil.a(2131901861), false, 500L);
      localObject4 = Stream.of(localObject1).map(new ThreadOffFunction(str2, 2)).map(new HWEncodeGenerateThumbSegment(null, (EditVideoPlayerExport)a(EditVideoPlayerExport.class), 0));
      EditVideoDoodle localEditVideoDoodle = this.O;
      localObject1 = localObject4;
      if (localEditVideoDoodle != null)
      {
        localObject4 = ((Stream)localObject4).map(localEditVideoDoodle.c(i2));
        if (this.O.b.getDynamicFaceLayer().c())
        {
          localObject1 = localObject4;
          if (S() == 0L) {}
        }
        else
        {
          localObject1 = ((Stream)localObject4).map(new GenerateDynamicDoodleImageSegment(this.O, (EditFilterExport)a(EditFilterExport.class), i2));
        }
      }
      if ((!(this.I.e instanceof EditTakeVideoSource)) && (!(this.I.e instanceof EditLocalVideoSource))) {
        localObject1 = ((Stream)localObject1).map(new MergeThumbSegment()).map((StreamFunction)StoryApi.a(DoodleRotateSegment.class, new Object[0]));
      } else {
        localObject1 = ((Stream)localObject1).map(new HWEncodeMergeThumbSegment());
      }
      if (this.I.h() == 14) {
        this.I.d.putInt("VIDEO_STORY_JUMP_TO_TYPE", ((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).getStoryShareType(this.H.getActivity().getIntent()));
      }
      ((Stream)localObject1).map(new PublishVideoSegment(this.I)).map(new UIThreadOffFunction(this)).subscribe(paramObserver);
      i1 += 1;
    }
    paramEditSource = this.J.iterator();
    while (paramEditSource.hasNext()) {
      ((EditVideoPart)paramEditSource.next()).w();
    }
    return;
    label1001:
    paramObserver = new StringBuilder();
    paramObserver.append(HardCodeUtil.a(2131901896));
    paramObserver.append(paramEditSource);
    paramEditSource = new IllegalArgumentException(paramObserver.toString());
    for (;;)
    {
      throw paramEditSource;
    }
  }
  
  protected void a(@NonNull EditVideoParams paramEditVideoParams)
  {
    SLog.a("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts %s", paramEditVideoParams);
    int k = paramEditVideoParams.c;
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (paramEditVideoParams.a == 11)
    {
      localObject = new DovTribeEditVideoButton(this, k);
      this.K = ((EditVideoButton)localObject);
      localArrayList.add(localObject);
    }
    else if (paramEditVideoParams.a == 12)
    {
      localObject = new ReadInJoyEditVideoButton(this, k);
      this.K = ((EditVideoButton)localObject);
      localArrayList.add(localObject);
    }
    else if (paramEditVideoParams.a == 14)
    {
      localObject = new EditVideoStoryButton(this);
      this.M = ((EditVideoStoryButton)localObject);
      localArrayList.add(localObject);
    }
    else if (paramEditVideoParams.a == 15)
    {
      localObject = new EditARCakeButton(this);
      this.L = ((EditARCakeButton)localObject);
      localArrayList.add(localObject);
    }
    else
    {
      localObject = new EditVideoButton(this, k);
      this.K = ((EditVideoButton)localObject);
      localArrayList.add(localObject);
    }
    if ((!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isStoryPhoto(this.H.getActivity().getIntent(), this.I.h())) && (!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isSameStoryPhotoEntry(this.H.getActivity().getIntent())))
    {
      localObject = new EditProviderPart(this);
      this.N = ((EditProviderPart)localObject);
      localArrayList.add(localObject);
    }
    if (paramEditVideoParams.b())
    {
      localObject = new EditPicRawImage(this, k);
      this.R = ((EditPicRawImage)localObject);
      localArrayList.add(localObject);
    }
    else
    {
      this.aj = new HWEditLocalVideoPlayer(this);
      if (paramEditVideoParams.e())
      {
        if (Build.VERSION.SDK_INT >= 14) {
          localArrayList.add(new HWEditImportVideoPlayer(this));
        }
      }
      else if (paramEditVideoParams.k()) {
        localArrayList.add(this.aj);
      }
    }
    if (a(k, 2)) {
      if (paramEditVideoParams.a == 14)
      {
        localArrayList.add(new EditVideoSmartMusicPart(this));
      }
      else
      {
        localObject = new EditVideoQimMusic(this, false);
        this.Q = ((EditVideoQimMusic)localObject);
        localArrayList.add(localObject);
      }
    }
    if ((a(k, 1024)) || (a(k, 131072)) || (a(k, 1)) || (a(k, 8)))
    {
      localObject = new EditVideoDoodle(this, k);
      this.O = ((EditVideoDoodle)localObject);
      localArrayList.add(localObject);
    }
    if (a(k, 256))
    {
      localObject = new EditVideoSpeedFilter(this, true);
      this.P = ((EditVideoSpeedFilter)localObject);
      localArrayList.add(localObject);
    }
    if ((paramEditVideoParams.b()) && (a(k, 4)))
    {
      localObject = new EditPicCropPart(this);
      this.S = ((EditPicCropPart)localObject);
      localArrayList.add(localObject);
    }
    if (a(k, 512)) {
      if (((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isSameStoryPhotoEntry(this.H.getActivity().getIntent()))
      {
        localObject = new EditPicSave(this);
        this.U = ((EditPicSave)localObject);
        localArrayList.add(localObject);
      }
      else if (!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isStoryPhoto(this.H.getActivity().getIntent(), this.I.h()))
      {
        localObject = new EditVideoSave(this);
        this.T = ((EditVideoSave)localObject);
        localArrayList.add(localObject);
      }
      else
      {
        localObject = new EditPicSave(this);
        this.U = ((EditPicSave)localObject);
        localArrayList.add(localObject);
      }
    }
    if (a(k, 16))
    {
      localObject = new EditVideoTransfer(this);
      this.V = ((EditVideoTransfer)localObject);
      localArrayList.add(localObject);
    }
    if ((AECameraEntry.c.b(paramEditVideoParams.h)) && ((paramEditVideoParams.d()) || (paramEditVideoParams.b()) || (paramEditVideoParams.c())))
    {
      localObject = new SendPanelPart(this);
      this.W = ((SendPanelPart)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.c, 4096))
    {
      paramEditVideoParams = new EditVideoLimitRegion(this);
      this.ab = paramEditVideoParams;
      localArrayList.add(paramEditVideoParams);
    }
    a(localArrayList);
    this.J = Collections.unmodifiableList(localArrayList);
    SLog.a("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts %d", Integer.valueOf(this.J.size()));
    paramEditVideoParams = this.J.iterator();
    while (paramEditVideoParams.hasNext()) {
      SLog.a("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts : %s", ((EditVideoPart)paramEditVideoParams.next()).getClass().getSimpleName());
    }
  }
  
  public void a(Class<? extends EditVideoPart.EditExport> paramClass, EditVideoPart.EditExport paramEditExport)
  {
    z();
    ad();
    if (paramClass != null)
    {
      if (paramClass.isInstance(paramEditExport))
      {
        localObject = (EditVideoPart.EditExport)this.ae.get(paramClass);
        if (localObject == null) {
          SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishEditExport for %s with %s", paramClass.getSimpleName(), paramEditExport);
        } else {
          SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "publishEditExport for %s replace %s by %s", new Object[] { paramClass.getSimpleName(), localObject, paramEditExport });
        }
        this.ae.put(paramClass, paramEditExport);
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("the 2nd parameter's type ");
      ((StringBuilder)localObject).append(paramEditExport.getClass().getName());
      ((StringBuilder)localObject).append(" is not instance of ");
      ((StringBuilder)localObject).append(paramClass.getName());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    throw new IllegalArgumentException("editExportClass should not be null");
  }
  
  public void a(Error paramError)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("PUBLISH error ：");
    ((StringBuilder)localObject).append(paramError);
    SLog.e("Q.qqstory.publish.edit.EditVideoPartManager", ((StringBuilder)localObject).toString());
    localObject = this.J.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((EditVideoPart)((Iterator)localObject).next()).a(paramError);
    }
    StoryReportor.b("video_edit", "pub_error", 0, 0, new String[] { paramError.toString() });
    this.ai.add(paramError);
    if (this.ah.decrementAndGet() > 0)
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
      return;
    }
    this.E = false;
    this.H.dismissLoadingDialog();
    QQToast.makeText(this.H.getContext(), HardCodeUtil.a(2131901847), 0).show();
    paramError = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
    if (paramError != null) {
      paramError.i();
    }
  }
  
  void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDlnaVideoSaved videoPath ");
    ((StringBuilder)localObject).append(paramString);
    QLog.w("Q.qqstory.publish.edit.EditVideoPartManager", 1, ((StringBuilder)localObject).toString());
    if (paramString != null)
    {
      localObject = QZoneHelper.UserInfo.getInstance();
      Bundle localBundle = new Bundle();
      localBundle.putString("key_video_path", paramString);
      QZoneHelper.forwardToDLNAActivity(this.H.getActivity(), (QZoneHelper.UserInfo)localObject, localBundle, -1);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    Bosses.get().postJob(new EditVideoPartManager.2(this, "Q.qqstory.publish.edit.EditVideoPartManager", paramString, paramInt1, paramInt2, paramVarArgs));
  }
  
  protected void a(List<EditVideoPart> paramList) {}
  
  public long b(int paramInt)
  {
    Object localObject = this.I.e;
    long l1;
    if ((!(localObject instanceof EditTakePhotoSource)) && (!(localObject instanceof EditLocalPhotoSource)))
    {
      if ((localObject instanceof EditLocalVideoSource))
      {
        localObject = (EditLocalVideoSource)localObject;
        l2 = ((EditLocalVideoSource)localObject).d - ((EditLocalVideoSource)localObject).c;
        l1 = l2;
        if (l2 == 0L) {
          l1 = ((EditLocalVideoSource)localObject).b.mDuration;
        }
      }
      else if ((localObject instanceof EditTakeVideoSource))
      {
        l1 = ((EditTakeVideoSource)localObject).b.mDuration;
      }
      else
      {
        throw new RuntimeException(HardCodeUtil.a(2131901942));
      }
    }
    else {
      l1 = 5000L;
    }
    localObject = this.P;
    long l2 = l1;
    if (localObject != null)
    {
      paramInt = ((EditVideoSpeedFilter)localObject).c();
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return l1;
            }
            return l1 * 4L;
          }
          return ((float)l1 / 1.5F);
        }
        return l1 * 2L;
      }
      l2 = l1 / 2L;
    }
    return l2;
  }
  
  public void b()
  {
    z();
    ad();
    ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportRephotoBtn();
    VideoEditReport.a("0X80076B6");
    VideoEditReport.b("0X80075C2");
    Object localObject = this.O;
    int k;
    if (localObject != null) {
      k = ((EditVideoDoodle)localObject).k();
    } else {
      k = 0;
    }
    localObject = this.S;
    int m = k;
    if (localObject != null) {
      m = k + ((EditPicCropPart)localObject).o;
    }
    SLog.a("Q.qqstory.publish.edit.EditVideoPartManager", "tryQuitRecordUI, current is preview state, edit count = %d", Integer.valueOf(m));
    if (m < 3)
    {
      h();
      return;
    }
    VideoEditReport.a("0X80076B7");
    VideoEditReport.b("0X80075C3");
    if (this.I.b()) {
      localObject = HardCodeUtil.a(2131901899);
    } else {
      localObject = HardCodeUtil.a(2131901925);
    }
    ActionSheet localActionSheet = ActionSheet.createFullScreenDialog(this.H.getContext(), true);
    localActionSheet.setMainTitle((CharSequence)localObject);
    localActionSheet.addButton(HardCodeUtil.a(2131901932), 3);
    localActionSheet.addCancelButton(HardCodeUtil.a(2131898212));
    localActionSheet.setOnButtonClickListener(new EditVideoPartManager.1(this, localActionSheet));
    localActionSheet.show();
  }
  
  public void b(Bundle paramBundle)
  {
    Iterator localIterator = this.J.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).c(paramBundle);
    }
    paramBundle.putInt("mEditState", this.C);
  }
  
  public void b(GenerateContext paramGenerateContext)
  {
    long l = this.I.d.getLong("troop_uin");
    if (l != 0L)
    {
      Object localObject = new qqstory_struct.VideoReaderConf();
      ((qqstory_struct.VideoReaderConf)localObject).ban_type.set(1);
      ((qqstory_struct.VideoReaderConf)localObject).user_list.set(new ArrayList());
      ((qqstory_struct.VideoReaderConf)localObject).setHasFlag(true);
      paramGenerateContext.d.readerConfBytes = ((qqstory_struct.VideoReaderConf)localObject).toByteArray();
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Long.valueOf(l));
      if (((ArrayList)localObject).size() > 0) {
        try
        {
          qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
          byte[] arrayOfByte = paramGenerateContext.d.spreadGroupBytes;
          if (arrayOfByte != null) {
            try
            {
              localVideoSpreadGroupList.mergeFrom(paramGenerateContext.d.spreadGroupBytes);
            }
            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
            {
              SLog.c("Q.qqstory.publish.edit.EditVideoPartManager", "checkTroopStory", localInvalidProtocolBufferMicroException);
            }
          }
          localVideoSpreadGroupList.group_list.set((List)localObject);
          localVideoSpreadGroupList.visibility_type.set(4);
          localVideoSpreadGroupList.setHasFlag(true);
          paramGenerateContext.d.spreadGroupBytes = localVideoSpreadGroupList.toByteArray();
          return;
        }
        finally {}
      }
    }
  }
  
  public void b(String paramString)
  {
    DocEnhancePart localDocEnhancePart = this.X;
    if (localDocEnhancePart != null) {
      localDocEnhancePart.a(paramString);
    }
  }
  
  public void b(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {}
  
  public void c()
  {
    z();
    ad();
    this.F = true;
    Object localObject1 = this.H.getActivity().getIntent();
    this.ad = EditState.a((Intent)localObject1);
    this.c = ((Intent)localObject1).getStringExtra("KEY_SEND_ARK_MSG_ID");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onCreate--arkViewId=");
    ((StringBuilder)localObject2).append(this.c);
    AEQLog.b("Q.qqstory.publish.edit.EditVideoPartManager", ((StringBuilder)localObject2).toString());
    localObject2 = this.J.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((EditVideoPart)((Iterator)localObject2).next()).a();
    }
    if ((((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isStoryPhoto((Intent)localObject1, this.I.h())) || (((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isSameStoryPhotoEntry((Intent)localObject1)))
    {
      LiuHaiUtils.h(this.H.getActivity());
      localObject1 = this.Z;
      if (localObject1 != null) {
        ((RelativeLayout)localObject1).setVisibility(8);
      }
      localObject1 = this.Y;
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setVisibility(8);
      }
    }
    if (a(this.I.c, 64))
    {
      ag = new GPUBitmapImageRender();
      return;
    }
    localObject1 = this.H.getActivity().findViewById(2063991341);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(8);
    }
  }
  
  public boolean c(int paramInt)
  {
    return this.C == paramInt;
  }
  
  public final void d(int paramInt)
  {
    a(paramInt, null);
  }
  
  public void d(boolean paramBoolean)
  {
    Iterator localIterator = this.J.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).f(paramBoolean);
    }
  }
  
  public void e(int paramInt)
  {
    this.a = paramInt;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFrom ");
      localStringBuilder.append(this.a);
      QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 2, localStringBuilder.toString());
    }
  }
  
  public void e(boolean paramBoolean)
  {
    EditVideoButton localEditVideoButton = this.K;
    if (localEditVideoButton != null) {
      localEditVideoButton.a(paramBoolean);
    }
  }
  
  protected SimpleObserver<GenerateContext> f()
  {
    return new EditVideoPartManager.4(this, SystemClock.uptimeMillis());
  }
  
  protected void h()
  {
    EditVideoPlayerExport localEditVideoPlayerExport = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
    if (localEditVideoPlayerExport != null) {
      localEditVideoPlayerExport.h();
    }
    this.H.finish(0, null, 2130772081, 0);
  }
  
  public void i()
  {
    Object localObject = this.O;
    int m = 0;
    int n = 0;
    if (localObject != null)
    {
      localObject = ((EditVideoDoodle)localObject).b();
      if (localObject != null) {
        ((DoodleLayout)localObject).i();
      }
      localObject = this.O.b().getLineLayer();
      int k = n;
      if (localObject != null)
      {
        k = n;
        if (((LineLayer)localObject).b.g())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 2, "preparePublish");
          }
          this.H.showLoadingDialog(HardCodeUtil.a(2131901823), false, 500L);
          localObject = this.O;
          ((EditVideoDoodle)localObject).e = 2;
          ((EditVideoDoodle)localObject).b().o();
          k = 1;
        }
      }
      localObject = this.O.b().getTextLayer();
      m = k;
      if (localObject != null)
      {
        ((TextLayer)localObject).r();
        m = k;
      }
    }
    if (m == 0) {
      o();
    }
  }
  
  public boolean isValidate()
  {
    return this.F;
  }
  
  public boolean j()
  {
    z();
    ad();
    return this.I.b();
  }
  
  public boolean k()
  {
    z();
    ad();
    return this.I.e();
  }
  
  public boolean l()
  {
    z();
    ad();
    if (this.ad != null)
    {
      if (!k()) {
        return false;
      }
      return this.ad.getBoolean("KEY_FROM_PIC_TO_VIDEO", false);
    }
    return false;
  }
  
  public int m()
  {
    return 0;
  }
  
  public int n()
  {
    int m = this.I.a;
    int k = 2;
    if (m != 2)
    {
      k = 3;
      if (m != 3)
      {
        k = 4;
        if (m != 4)
        {
          k = 5;
          if (m != 5) {
            return 999;
          }
        }
      }
    }
    return k;
  }
  
  public void o()
  {
    Object localObject1 = this.H;
    if (localObject1 == null)
    {
      QLog.e("Q.qqstory.publish.edit.EditVideoPartManager", 1, "onPreparePublishDone error, mUi is null");
      return;
    }
    a(((EditVideoUi)localObject1).getContext());
    a();
    localObject1 = this.H.getActivity();
    boolean bool = localObject1 instanceof EditPicActivity;
    int k = -1;
    int m;
    if (bool)
    {
      m = ((Activity)localObject1).getIntent().getIntExtra("editpic_cameratype", -1);
      if (m != 1)
      {
        if (m != 2)
        {
          if (m == 3) {
            NewFlowCameraReporter.c();
          }
        }
        else {
          NewFlowCameraReporter.b();
        }
      }
      else
      {
        BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putLong("sv_latest_taken_photo_time", -1L).commit();
        NewFlowCameraReporter.a();
      }
    }
    if (P() == 7)
    {
      Object localObject2 = SlideShowPhotoListManager.a();
      if (localObject2 != null)
      {
        localObject1 = ((SlideShowPhotoListManager)localObject2).f();
        Object localObject3 = ((List)localObject1).iterator();
        m = 0;
        while (((Iterator)localObject3).hasNext()) {
          if (((SlideItemInfo)((Iterator)localObject3).next()).e == 1) {
            m += 1;
          }
        }
        int i1 = ((List)localObject1).size();
        int n = ((SlideShowPhotoListManager)localObject2).d();
        localObject2 = this.H.getActivity().getIntent();
        if (localObject2 != null)
        {
          localObject3 = (EditVideoParams)((Intent)localObject2).getParcelableExtra(EditVideoParams.class.getName());
          if (localObject3 != null) {
            k = ((EditVideoParams)localObject3).a("extra_ablum_type", -1);
          } else {
            k = ((Intent)localObject2).getIntExtra("extra_ablum_type", -1);
          }
        }
        if (n == 11) {
          n = 0;
        } else {
          n = 1;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(StoryReportor.a(k));
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((List)localObject1).size());
        ((StringBuilder)localObject3).append("");
        localObject1 = ((StringBuilder)localObject3).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(i1 - m);
        ((StringBuilder)localObject3).append("");
        localObject3 = ((StringBuilder)localObject3).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(m);
        localStringBuilder.append("");
        StoryReportor.a("video_edit_slides", "clk_pub", n, 0, new String[] { localObject2, localObject1, localObject3, localStringBuilder.toString() });
      }
    }
  }
  
  public Bundle p()
  {
    Bundle localBundle2 = this.ad;
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    return localBundle1;
  }
  
  public void q()
  {
    this.H = null;
  }
  
  public void r()
  {
    Iterator localIterator = this.J.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).v();
    }
  }
  
  public void s()
  {
    if (this.C == -1) {
      d(0);
    }
    Iterator localIterator = this.J.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).f();
    }
  }
  
  public void t()
  {
    Iterator localIterator = this.J.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).ax_();
    }
  }
  
  public void u()
  {
    Iterator localIterator = this.J.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).at_();
    }
  }
  
  public final void v()
  {
    AEQLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "onSaveOrUploadArkVideoError");
    if (this.j == null) {
      this.j = DialogUtil.a(this.H.getActivity(), 230).setMessage(2131886321).setPositiveButton(2131886320, new EditVideoPartManager.10(this)).setNegativeButton(2131887648, new EditVideoPartManager.9(this));
    }
    if (this.j.isShowing()) {
      return;
    }
    this.j.show();
  }
  
  public void w()
  {
    Object localObject = this.J;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((EditVideoPart)((Iterator)localObject).next()).g();
      }
      q();
    }
    if ((ag != null) && (!MediaCodecUtil.c())) {
      ag.a();
    }
    VideoFilterTools.a().h();
    this.F = false;
  }
  
  public boolean x()
  {
    Object localObject = this.Q;
    if ((localObject != null) && (((EditVideoQimMusic)localObject).au_()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.Q });
      return true;
    }
    localObject = this.O;
    if ((localObject != null) && (((EditVideoDoodle)localObject).au_()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.O });
      return true;
    }
    localObject = this.S;
    if ((localObject != null) && (((EditPicCropPart)localObject).au_()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.S });
      return true;
    }
    localObject = this.K;
    if ((localObject != null) && (((EditVideoButton)localObject).au_()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.K });
      return true;
    }
    localObject = this.M;
    if ((localObject != null) && (((EditVideoStoryButton)localObject).au_()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.M });
      return true;
    }
    localObject = this.W;
    if ((localObject != null) && (((SendPanelPart)localObject).au_()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.W });
      return true;
    }
    b();
    return true;
  }
  
  public int y()
  {
    if (k())
    {
      if (j()) {
        return 3;
      }
      return 4;
    }
    if (j()) {
      return 1;
    }
    return 2;
  }
  
  protected void z()
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      return;
    }
    throw new IllegalStateException("can not access by non-ui thread");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager
 * JD-Core Version:    0.7.0.1
 */