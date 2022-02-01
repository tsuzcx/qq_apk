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
  public static GPUBitmapImageRender a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  public Intent a;
  public Bundle a;
  public ViewGroup a;
  public RelativeLayout a;
  protected EditVideoQimMusic a;
  protected EditARCakeButton a;
  protected EditJumpToPtu a;
  protected EditPicCropPart a;
  public EditPicRawImage a;
  protected EditPicSave a;
  public EditProviderPart a;
  protected EditVideoButton a;
  public EditVideoDoodle a;
  protected EditVideoLimitRegion a;
  protected EditVideoSave a;
  protected EditVideoSpeedFilter a;
  protected EditVideoStoryButton a;
  protected EditVideoTransfer a;
  public EditVideoUi a;
  protected HWEditLocalVideoPlayer a;
  protected SendPanelPart a;
  private VideoStoryDataBean jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
  public EditVideoParams a;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private ProgressPieDrawable jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
  private String jdField_a_of_type_JavaLangString;
  protected List<EditVideoPart> a;
  protected Map<Class<? extends EditVideoPart.EditExport>, EditVideoPart.EditExport> a;
  protected final AtomicInteger a;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 3.0F;
  private String jdField_b_of_type_JavaLangString;
  protected List<Error> b;
  protected int f;
  public int g = 0;
  protected boolean o = false;
  protected boolean p = false;
  protected boolean q = false;
  public boolean r = true;
  
  public EditVideoPartManager()
  {
    this.jdField_f_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList = Collections.emptyList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void A()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a() == 14)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportPublish()  entranceType=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.c());
      ((StringBuilder)localObject).append(" , isEditCamera:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.c());
      SLog.c("Q.qqstory.publish.edit.EditVideoPartManager", ((StringBuilder)localObject).toString());
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.c() == 120) {
        i = 1;
      } else {
        i = 2;
      }
      int j;
      if (this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.c()) {
        j = 1;
      } else {
        j = 2;
      }
      localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("lens_tab", a().getLensTabId());
        ((JSONObject)localObject).put("watermark_id", a().getWatermarkId());
        ((JSONObject)localObject).put("music_id", a().getSongMid());
        ((JSONObject)localObject).put("filter_id", a().getFilterId());
        ((JSONObject)localObject).put("sticker_id", a().getStickerId());
        ((JSONObject)localObject).put("word_id", a().getWordId());
        if (a().getMusicType() == 1) {
          ((JSONObject)localObject).put("music_play_time", a().getMusciPlayTime());
        }
        ((JSONObject)localObject).put("video_duration", a().getVideoDuration());
        localJSONObject.put("music_type", a().getMusicType());
        localJSONObject.put("filter_type", a().getFilterType());
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      VSReporter.a("mystatus_edit", "post_clk", i, 0, new String[] { String.valueOf(j), "", ((JSONObject)localObject).toString(), localJSONObject.toString() });
    }
  }
  
  private void B()
  {
    EditVideoUi localEditVideoUi = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi;
    if (localEditVideoUi == null) {
      return;
    }
    localEditVideoUi.getRootView().postDelayed(new EditVideoPartManager.6(this), 1000L);
  }
  
  private void C()
  {
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if (localDialog != null) {
      localDialog.dismiss();
    }
  }
  
  private void D()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    Bundle localBundle = this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_AndroidOsBundle;
    localSessionInfo.jdField_a_of_type_Int = localBundle.getInt("uintype");
    localSessionInfo.jdField_a_of_type_JavaLangString = localBundle.getString("uin");
    localSessionInfo.jdField_b_of_type_JavaLangString = localBundle.getString("troop_uin");
    localSessionInfo.d = localBundle.getString("uinname");
    PeakIpcController.a(localSessionInfo, "baseView", "{\n  \"data\": {\n    \"puin\": \"892820726\",\n    \"nick\": \"我五岁了哦！\",\n    \"id\": \"xx\",\n    \"avatarJumpUrl\": \"https://h5.qzone.qq.com/v2/wezone/jump?_wv=3&_proxy=1&schema=mqqapi%3A%2F%2Fqcircle%2Fopenmainpage%3Fuin%3D892820726%26issinglefeed%3D1%26from%3D6%26sharecategory%3D2%26shareentrance%3D1\",\n    \"contentJumpUrl\": \"https://h5.qzone.qq.com/v2/wezone/jump?_wv=3&_proxy=1&schema=mqqapi%3A%2F%2Fqcircle%2Fopendetail%3Ffeedid%3DB_193ead5f48eb06008928207260X5c%26sourcetype%3D10%26createtime%3D1605189145%26uin%3D892820726%26shareuin%3D1715054455%26issinglefeed%3D1%26from%3D6%26is_feed_detail%3D1%26sharecategory%3D2%26shareentrance%3D1\",\n    \"iconJumpUrl\": \"https://h5.qzone.qq.com/v2/wezone/jump?_wv=3&_proxy=1&schema=mqqapi%3A%2F%2Fqcircle%2Fopenfolder%3Fissinglefeed%3D1%26from%3D6%26sharecategory%3D2%26shareentrance%3D1\",\n    \"media\": [\n      {\n        \"isVideo\": true,\n        \"videoDuration\": 6153,\n        \"height\": 1080,\n        \"width\": 612,\n        \"url\": \"https://photogz.photo.store.qq.com/psc?/V54acxHN3cWMMd1uSEP42tVDpt3rbFDX/bqQfVz5yrrGYSXMvKr.cqfwp.5mjtGNPmLXd7x240uDFGDWpqsTaAx9IH1rzBk4C2oJi9NLpvQo.nrHoAHTVX6w0vBQPm2u1D8U5owjcQfc!/b&ek=1&kp=1&pt=0&bo=ZAI4BGQCOAQRECc!&tl=1&lsr=6&vuin=1715054455&tm=1607943600#sce=79-11-1&rf=v1_and_sq_8.5.0_0_rdm_b_t_-2-0-31\"\n      }\n    ],\n    \"total\": 1,\n    \"title\": \"分享了来自小世界的作品\",\n    \"type\": 2,\n    \"isAIO\": 1,\n    \"appName\": \"qcircle\",\n    \"fuelNum\": 57393,\n    \"likeNum\": 41463\n  }\n}");
  }
  
  private void E()
  {
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi != null) && (this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams != null)) {
      return;
    }
    throw new IllegalStateException("have not attach ui and params");
  }
  
  @NotNull
  private GenerateContext a(EditVideoParams.EditSource paramEditSource, int paramInt1, int paramInt2, String paramString1, float paramFloat, int paramInt3, String paramString2, boolean paramBoolean, long paramLong, String paramString3, String paramString4, int paramInt4, int paramInt5)
  {
    GenerateContext localGenerateContext = new GenerateContext(this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams);
    localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.multiFragmentGroupId = paramString3;
    localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.createTime = (paramLong + paramInt4 * 1000);
    localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoMaxrate = CodecParam.mMaxrate;
    if (((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).isCqBitrateModeSwitchOpen())
    {
      localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoMaxrate = (((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).getCqMaxBitrate() * 1000);
      localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.putExtra("composite_key_bitrate_mode", Boolean.valueOf(((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).isCqBitrateModeSwitchOpen()));
    }
    localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoMinrate = CodecParam.mMinrate;
    localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoUploadGroupTempDir = paramString4;
    localGenerateContext.jdField_b_of_type_JavaLangString = PublishFileManager.a(this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int);
    paramString3 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity();
    paramString4 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter;
    boolean bool;
    if ((paramString4 != null) && (paramString4.a() == 5)) {
      bool = true;
    } else {
      bool = false;
    }
    localGenerateContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGenerateThumbArgs = new GenerateThumbArgs(paramString3, paramInt1, paramInt2, paramString1, paramFloat, bool, paramInt3, 0.0D, 0.0D, paramString2, paramBoolean);
    if ((!(paramEditSource instanceof EditTakeVideoSource)) && (!(paramEditSource instanceof EditLocalVideoSource))) {
      localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.putExtra("is_hw_encode", Boolean.valueOf(false));
    } else {
      localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.putExtra("is_hw_encode", Boolean.valueOf(true));
    }
    localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.putExtra("thumb_rotation", Integer.valueOf(paramInt3));
    localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.putExtra("composite_key_capturemode", Integer.valueOf(g()));
    localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.putExtra("composite_key_entrance", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.c()));
    paramEditSource = localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a("extra_text_filter_text");
    if (!TextUtils.isEmpty(paramEditSource))
    {
      if (TextUtils.isEmpty(localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoDoodleDescription))
      {
        localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoDoodleDescription = paramEditSource;
        return localGenerateContext;
      }
      paramString1 = new StringBuilder();
      paramString2 = localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry;
      paramString1.append(paramString2.videoDoodleDescription);
      paramString1.append(paramEditSource);
      paramString2.videoDoodleDescription = paramString1.toString();
    }
    return localGenerateContext;
  }
  
  private ProgressPieDrawable a()
  {
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getContext());
    localProgressPieDrawable.a(AIOUtils.b(50.0F, this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getResources()));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.g(-1);
    localProgressPieDrawable.f(0);
    localProgressPieDrawable.d(-15550475);
    localProgressPieDrawable.i(3);
    localProgressPieDrawable.jdField_f_of_type_Boolean = true;
    localProgressPieDrawable.jdField_f_of_type_Int = 2;
    localProgressPieDrawable.e(true);
    localProgressPieDrawable.a(new EditVideoPartManager.7(this));
    return localProgressPieDrawable;
  }
  
  private void a(int paramInt)
  {
    if (!c()) {
      Bosses.get().postJob(new EditVideoPartManager.3(this, "Q.qqstory.publish.edit.EditVideoPartManager"));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a("extra_is_slide_show_video", false)) {
      StoryReportor.a("video_edit", "pub_slides", 0, 0, new String[0]);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.c() == 104) {
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
    this.jdField_a_of_type_Float = paramInt;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Float = (50000.0F / (float)paramLong);
    if (this.jdField_b_of_type_Float == 0.0F) {
      this.jdField_b_of_type_Float = 1.0F;
    }
    B();
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      String str = this.jdField_b_of_type_JavaLangString;
      if ((str == null) || (!str.equals(paramIntent.getStringExtra("fakeId")))) {
        return;
      }
    }
    b(0);
    this.jdField_a_of_type_Boolean = true;
    if (paramInt == -1)
    {
      d(100);
      ThreadManager.excute(new EditVideoPartManager.8(this, paramIntent), 64, null, true);
      return;
    }
    if (paramInt == 1)
    {
      C();
      m();
      return;
    }
    if (paramInt == 0) {
      C();
    }
  }
  
  private boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a() == 14);
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
  
  private void b(EditVideoParams.EditSource paramEditSource, Observer<GenerateContext> paramObserver)
  {
    Object localObject1 = new GenerateContext(this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams);
    ((GenerateContext)localObject1).jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoMaxrate = CodecParam.mMaxrate;
    ((GenerateContext)localObject1).jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoMinrate = CodecParam.mMinrate;
    ((GenerateContext)localObject1).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a("extra_upload_temp_directory");
    if (((GenerateContext)localObject1).jdField_b_of_type_JavaLangString == null) {
      ((GenerateContext)localObject1).jdField_b_of_type_JavaLangString = PublishFileManager.a(this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int);
    }
    ((GenerateContext)localObject1).jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGeneratePicArgs = new GeneratePicArgs(paramEditSource.a());
    paramEditSource = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramEditSource.hasNext()) {
      ((EditVideoPart)paramEditSource.next()).a(0, (GenerateContext)localObject1);
    }
    a((GenerateContext)localObject1);
    b((GenerateContext)localObject1);
    SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH start, Folder = %s", new Object[] { ((GenerateContext)localObject1).jdField_b_of_type_JavaLangString });
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.showLoadingDialog(HardCodeUtil.a(2131703960), false, 500L);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    this.jdField_b_of_type_JavaUtilList.clear();
    paramEditSource = Stream.of(localObject1).map(new ThreadOffFunction("Q.qqstory.publish.edit.EditVideoPartManager", 2)).map(new MergePicSegment(false)).map(new ResizeBitmapSegment());
    localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity();
    Object localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter;
    int i;
    if (localObject2 != null) {
      i = ((EditVideoSpeedFilter)localObject2).a();
    } else {
      i = 0;
    }
    localObject1 = paramEditSource.map(new GeneratePicThumbSegment((Activity)localObject1, i));
    localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle;
    paramEditSource = (EditVideoParams.EditSource)localObject1;
    if (localObject2 != null) {
      paramEditSource = ((Stream)localObject1).map(((EditVideoDoodle)localObject2).a(0));
    }
    paramEditSource.map(new MergeThumbSegment()).map((StreamFunction)StoryApi.a(DoodleRotateSegment.class, new Object[0])).map(new PublishVideoSegment(this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(paramObserver);
  }
  
  @TargetApi(14)
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getContext());
      Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        ((Window)localObject).setDimAmount(0.0F);
      }
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561828);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373123);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371529)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
    f(0);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getRootView().post(new EditVideoPartManager.5(this));
  }
  
  private void c(GenerateContext paramGenerateContext)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity() == null)
    {
      AEQLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "jumpToSaveVideoForAioSendVideoArkMsg--activity not exist");
      return;
    }
    b(HardCodeUtil.a(2131703901));
    paramGenerateContext = paramGenerateContext.jdField_a_of_type_ComTencentAelightCameraStructEditorPublishParam;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("jumpToSaveVideoForAioSendVideoArkMsg: publishParam=");
    ((StringBuilder)localObject).append(paramGenerateContext);
    AEQLog.a("Q.qqstory.publish.edit.EditVideoPartManager", ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent();
    boolean bool = false;
    int j;
    if (localObject != null)
    {
      i = ((Intent)localObject).getIntExtra("sv_total_frame_count", 0);
      j = ((Intent)localObject).getIntExtra("sv_total_record_time", 0);
    }
    else
    {
      i = 0;
      j = 0;
    }
    Intent localIntent = SaveVideoActivity.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getContext(), paramGenerateContext.jdField_b_of_type_JavaLangString, j, i, this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a());
    this.jdField_b_of_type_JavaLangString = paramGenerateContext.jdField_b_of_type_JavaLangString;
    int i = AECameraEntry.a.a();
    if (localObject != null) {
      i = ((Intent)localObject).getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
    }
    localIntent.putExtra("mediacodec_encode_enable", true);
    if (paramGenerateContext.e != 0) {
      bool = true;
    }
    localIntent.putExtra("video_edit_flag", bool);
    localIntent.putExtra("thumbfile_send_path", paramGenerateContext.c);
    localIntent.putExtra("VIDEO_STORY_FROM_TYPE", i);
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
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().startActivityForResult(localIntent, 237);
    a(5, paramGenerateContext.a);
  }
  
  private void c(String paramString)
  {
    PeakIpcController.a(paramString, new EditVideoPartManager.11(this));
  }
  
  private void d()
  {
    a(0);
  }
  
  private void d(int paramInt)
  {
    int i = paramInt;
    if (a()) {
      i = (int)(paramInt * 50.0F / 100.0F);
    }
    f(i);
  }
  
  private void e(int paramInt)
  {
    int i = paramInt;
    if (a()) {
      i = (int)(paramInt * 50.0F / 100.0F + 50.0F);
    }
    f(i);
  }
  
  private void f(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
    if (localObject == null) {
      return;
    }
    ((ProgressPieDrawable)localObject).a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.b(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.d(false);
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("%");
    ((ProgressPieDrawable)localObject).a(localStringBuilder.toString());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[setProgress] current:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a());
      ((StringBuilder)localObject).append(", progress:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public int a(@NonNull Message paramMessage)
  {
    o();
    if (this.p)
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "broadcast message ignore because of publishing");
      return 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      if (((EditVideoPart)localIterator.next()).b(Message.obtain(paramMessage))) {
        i += 1;
      }
    }
    if (i == 0) {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "broadcastEditVideoMessage, but no one handled", new Object[] { paramMessage });
    }
    paramMessage.recycle();
    return i;
  }
  
  public long a()
  {
    return 0L;
  }
  
  public long a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource;
    long l1;
    if ((!(localObject instanceof EditTakePhotoSource)) && (!(localObject instanceof EditLocalPhotoSource)))
    {
      if ((localObject instanceof EditLocalVideoSource))
      {
        localObject = (EditLocalVideoSource)localObject;
        l2 = ((EditLocalVideoSource)localObject).b - ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
        l1 = l2;
        if (l2 == 0L) {
          l1 = ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
        }
      }
      else if ((localObject instanceof EditTakeVideoSource))
      {
        l1 = ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
      }
      else
      {
        throw new RuntimeException(HardCodeUtil.a(2131704016));
      }
    }
    else {
      l1 = 5000L;
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter;
    long l2 = l1;
    if (localObject != null)
    {
      paramInt = ((EditVideoSpeedFilter)localObject).a();
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
  
  public Bitmap a()
  {
    EditPicRawImage localEditPicRawImage = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicRawImage;
    if (localEditPicRawImage != null) {
      return localEditPicRawImage.a();
    }
    return null;
  }
  
  public Bundle a()
  {
    Bundle localBundle2 = this.jdField_a_of_type_AndroidOsBundle;
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    return localBundle1;
  }
  
  View a()
  {
    EditVideoButton localEditVideoButton = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoButton;
    if (localEditVideoButton != null) {
      return localEditVideoButton.a();
    }
    return null;
  }
  
  public EditVideoDoodle a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle;
  }
  
  @Nullable
  public EditVideoPart.EditExport a(Class<? extends EditVideoPart.EditExport> paramClass)
  {
    if (paramClass != null) {
      return (EditVideoPart.EditExport)this.jdField_a_of_type_JavaUtilMap.get(paramClass);
    }
    throw new IllegalArgumentException("editExportClass should not be null");
  }
  
  public EditVideoUi a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi;
  }
  
  public VideoStoryDataBean a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean == null)
      {
        VideoStoryDataBean localVideoStoryDataBean2 = (VideoStoryDataBean)a().getSerializable("KEY_VIDEO_STORY_CAMERA_TYPE");
        VideoStoryDataBean localVideoStoryDataBean1 = localVideoStoryDataBean2;
        if (localVideoStoryDataBean2 == null) {
          localVideoStoryDataBean1 = new VideoStoryDataBean();
        }
        this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean = localVideoStoryDataBean1;
      }
    }
    catch (Exception localException)
    {
      QLog.e("Q.qqstory.publish.edit.EditVideoPartManager", 1, "getVsDataBean error", localException);
      this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean = new VideoStoryDataBean();
    }
    return this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
  }
  
  protected SimpleObserver<GenerateContext> a()
  {
    return new EditVideoPartManager.4(this, SystemClock.uptimeMillis());
  }
  
  public List<EditVideoPart> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    o();
    E();
    EditVideoParams.EditSource localEditSource = this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource;
    int i = 0;
    SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "onConfirmClick : %s", new Object[] { localEditSource });
    Object localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent();
    if (!this.p)
    {
      if ((((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isStoryPhoto((Intent)localObject2, this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a())) || (((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isSameStoryPhotoEntry((Intent)localObject2)))
      {
        Object localObject3 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity();
        localObject1 = "";
        if ((localObject3 != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent() != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent().getBundleExtra("state") != null)) {
          localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent().getBundleExtra("state").getString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH");
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource instanceof EditLocalVideoSource))
        {
          localObject3 = new LocalMediaInfo();
          this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource = new EditLocalPhotoSource((String)localObject1, (LocalMediaInfo)localObject3);
        }
        p();
      }
      this.p = true;
      Object localObject1 = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
      if (localObject1 != null) {
        ((EditVideoPlayerExport)localObject1).h();
      }
      if ((!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isStoryPhoto((Intent)localObject2, this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a())) && (!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isSameStoryPhotoEntry((Intent)localObject2)))
      {
        localObject1 = a();
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
            localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter;
            if (localObject2 != null) {
              i = ((EditVideoSpeedFilter)localObject2).a();
            }
            CodecParam.mSaveMode = i;
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
        A();
        return;
      }
      A();
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
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent();
    if (((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isFromMiniApp((Intent)localObject))
    {
      AEQLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "onActivityResult---isFromMiniApp");
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.finish(-1, paramIntent, 2130772056, 0, true);
      return;
    }
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((EditVideoPart)((Iterator)localObject).next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public final void a(int paramInt, Object paramObject)
  {
    o();
    E();
    if (this.p)
    {
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "change state ignore because of publishing, %s", new Throwable());
      return;
    }
    if ((this.jdField_f_of_type_Int != paramInt) || (paramInt == 2) || (paramInt == 23))
    {
      if (this.o)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("change state while state changing, ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" oldState:");
        ((StringBuilder)localObject).append(this.jdField_f_of_type_Int);
        SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", ((StringBuilder)localObject).toString(), new Throwable());
      }
      this.o = true;
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "changeState : %s => %s", Integer.valueOf(this.jdField_f_of_type_Int), Integer.valueOf(paramInt));
      int i = this.jdField_f_of_type_Int;
      this.jdField_f_of_type_Int = paramInt;
      Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((EditVideoPart)((Iterator)localObject).next()).a(i, this.jdField_f_of_type_Int, paramObject);
      }
    }
    this.o = false;
  }
  
  public void a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.c() == 14) {
      StoryReportor.a("story_grp", "clk_send", 0, 0, new String[0]);
    }
  }
  
  void a(Intent paramIntent, int paramInt, PublishParam paramPublishParam, TribeVideoPublishParams paramTribeVideoPublishParams)
  {
    if (paramInt != 11)
    {
      if (paramInt != 12)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.finish(-1, paramIntent, 2130772056, 0, true);
        return;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.finish(-1, paramIntent, 2130772056, 0, true);
      return;
    }
    paramInt = -1;
    paramPublishParam = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      EditVideoPart localEditVideoPart = (EditVideoPart)localIterator.next();
      if ((localEditVideoPart instanceof DovTribeEditVideoButton))
      {
        paramPublishParam = (DovTribeEditVideoButton)localEditVideoPart;
        paramInt = paramPublishParam.a();
        paramPublishParam = paramPublishParam.a();
      }
    }
    paramIntent.putExtra("theme_id", paramInt);
    paramIntent.putExtra("theme_name", paramPublishParam);
    paramIntent.putExtra(TribeVideoPublishParams.BUNDLE_EXTRA_KEY, paramTribeVideoPublishParams);
    if (QLog.isColorLevel()) {
      QLog.i("tribe_publish", 2, "getPublishIntent");
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.finish(-1, paramIntent, 2130772056, 0, true);
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    o();
    EditPicRawImage localEditPicRawImage = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicRawImage;
    if (localEditPicRawImage != null) {
      localEditPicRawImage.a(paramBitmap, paramBoolean);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).a(paramBundle);
    }
  }
  
  public void a(EditVideoUi paramEditVideoUi, EditVideoParams paramEditVideoParams)
  {
    o();
    if ((paramEditVideoUi != null) && (paramEditVideoParams != null))
    {
      if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi == paramEditVideoUi) && (this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams == paramEditVideoParams))
      {
        SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "duplicate attachUiAndParams ui=%s, params=%s", new Object[] { paramEditVideoUi, paramEditVideoParams });
        return;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi = paramEditVideoUi;
      this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams = paramEditVideoParams;
      a(this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams);
      paramEditVideoParams = this.jdField_a_of_type_JavaUtilList.iterator();
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
    Object localObject = paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.readerConfBytes;
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = new qqstory_struct.VideoReaderConf();
      ((qqstory_struct.VideoReaderConf)localObject).ban_type.set(0);
      ((qqstory_struct.VideoReaderConf)localObject).setHasFlag(true);
      paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.readerConfBytes = ((qqstory_struct.VideoReaderConf)localObject).toByteArray();
    }
  }
  
  public void a(EditVideoParams.EditSource paramEditSource, Observer<GenerateContext> paramObserver)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    boolean bool = paramEditSource instanceof EditLocalVideoSource;
    String str2 = "Q.qqstory.publish.edit.EditVideoPartManager";
    Object localObject1;
    Object localObject2;
    int i;
    int j;
    int k;
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
      localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter;
      if (localObject2 != null) {
        i = ((EditVideoSpeedFilter)localObject2).a();
      } else {
        i = 0;
      }
      CodecParam.mSaveMode = i;
      j = ((EditLocalVideoSource)localObject1).a();
      k = ((EditLocalVideoSource)localObject1).b();
      i = Math.min(j, k);
      j = Math.max(j, k);
      localObject2 = ((EditLocalVideoSource)localObject1).a();
      f1 = i * 1.0F / j;
      k = ((EditLocalVideoSource)localObject1).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("publishVideo EditLocalVideoSource.mediaInfo");
      ((StringBuilder)localObject3).append(((EditLocalVideoSource)localObject1).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.toString());
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", ((StringBuilder)localObject3).toString());
    }
    for (;;)
    {
      break;
      if (!(paramEditSource instanceof EditTakeVideoSource)) {
        break label995;
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
      localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter;
      if (localObject2 != null) {
        i = ((EditVideoSpeedFilter)localObject2).a();
      } else {
        i = 0;
      }
      CodecParam.mSaveMode = i;
      i = ((EditTakeVideoSource)localObject1).a();
      j = ((EditTakeVideoSource)localObject1).b();
      localObject2 = ((EditTakeVideoSource)localObject1).a();
      f1 = i * 1.0F / j;
      k = ((EditTakeVideoSource)localObject1).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
    }
    Object localObject3 = new ArrayList();
    ((List)localObject3).add(Integer.valueOf(0));
    String str1 = String.format("%s.%d", new Object[] { QQStoryContext.a().a(), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)) });
    SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "publish video groupId=%s. fragment count=%d", str1, Integer.valueOf(((List)localObject3).size()));
    String str3 = this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a("extra_upload_temp_directory");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(((List)localObject3).size());
    this.jdField_b_of_type_JavaUtilList.clear();
    int m = 0;
    while (m < ((List)localObject3).size())
    {
      int n = ((Integer)((List)localObject3).get(m)).intValue();
      a(n);
      localObject1 = a(paramEditSource, i, j, (String)localObject2, f1, k, "", false, l, str1, str3, m, n);
      Object localObject4 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((EditVideoPart)((Iterator)localObject4).next()).a(n, (GenerateContext)localObject1);
      }
      a((GenerateContext)localObject1);
      b((GenerateContext)localObject1);
      SLog.d(str2, "PUBLISH start, Folder = %s", new Object[] { ((GenerateContext)localObject1).jdField_b_of_type_JavaLangString });
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.showLoadingDialog(HardCodeUtil.a(2131703925), false, 500L);
      localObject4 = Stream.of(localObject1).map(new ThreadOffFunction(str2, 2)).map(new HWEncodeGenerateThumbSegment(null, (EditVideoPlayerExport)a(EditVideoPlayerExport.class), 0));
      EditVideoDoodle localEditVideoDoodle = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle;
      localObject1 = localObject4;
      if (localEditVideoDoodle != null)
      {
        localObject4 = ((Stream)localObject4).map(localEditVideoDoodle.a(n));
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a().a())
        {
          localObject1 = localObject4;
          if (a() == 0L) {}
        }
        else
        {
          localObject1 = ((Stream)localObject4).map(new GenerateDynamicDoodleImageSegment(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle, (EditFilterExport)a(EditFilterExport.class), n));
        }
      }
      if ((!(this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource instanceof EditTakeVideoSource)) && (!(this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource instanceof EditLocalVideoSource))) {
        localObject1 = ((Stream)localObject1).map(new MergeThumbSegment()).map((StreamFunction)StoryApi.a(DoodleRotateSegment.class, new Object[0]));
      } else {
        localObject1 = ((Stream)localObject1).map(new HWEncodeMergeThumbSegment());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a() == 14) {
        this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_AndroidOsBundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", ((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).getStoryShareType(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent()));
      }
      ((Stream)localObject1).map(new PublishVideoSegment(this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(paramObserver);
      m += 1;
    }
    paramEditSource = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramEditSource.hasNext()) {
      ((EditVideoPart)paramEditSource.next()).p();
    }
    return;
    label995:
    paramObserver = new StringBuilder();
    paramObserver.append(HardCodeUtil.a(2131703965));
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
    int i = paramEditVideoParams.c;
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (paramEditVideoParams.jdField_a_of_type_Int == 11)
    {
      localObject = new DovTribeEditVideoButton(this, i);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoButton = ((EditVideoButton)localObject);
      localArrayList.add(localObject);
    }
    else if (paramEditVideoParams.jdField_a_of_type_Int == 12)
    {
      localObject = new ReadInJoyEditVideoButton(this, i);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoButton = ((EditVideoButton)localObject);
      localArrayList.add(localObject);
    }
    else if (paramEditVideoParams.jdField_a_of_type_Int == 14)
    {
      localObject = new EditVideoStoryButton(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoStoryButton = ((EditVideoStoryButton)localObject);
      localArrayList.add(localObject);
    }
    else if (paramEditVideoParams.jdField_a_of_type_Int == 15)
    {
      localObject = new EditARCakeButton(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditARCakeButton = ((EditARCakeButton)localObject);
      localArrayList.add(localObject);
    }
    else
    {
      localObject = new EditVideoButton(this, i);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoButton = ((EditVideoButton)localObject);
      localArrayList.add(localObject);
    }
    if ((!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isStoryPhoto(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent(), this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a())) && (!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isSameStoryPhotoEntry(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent())))
    {
      localObject = new EditProviderPart(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditProviderPart = ((EditProviderPart)localObject);
      localArrayList.add(localObject);
    }
    if (paramEditVideoParams.a())
    {
      localObject = new EditPicRawImage(this, i);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicRawImage = ((EditPicRawImage)localObject);
      localArrayList.add(localObject);
    }
    else
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer = new HWEditLocalVideoPlayer(this);
      if (paramEditVideoParams.d())
      {
        if (Build.VERSION.SDK_INT >= 14) {
          localArrayList.add(new HWEditImportVideoPlayer(this));
        }
      }
      else if (paramEditVideoParams.g()) {
        localArrayList.add(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer);
      }
    }
    if (a(i, 2)) {
      if (paramEditVideoParams.jdField_a_of_type_Int == 14)
      {
        localArrayList.add(new EditVideoSmartMusicPart(this));
      }
      else
      {
        localObject = new EditVideoQimMusic(this, false);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicEditVideoQimMusic = ((EditVideoQimMusic)localObject);
        localArrayList.add(localObject);
      }
    }
    if ((a(i, 1024)) || (a(i, 131072)) || (a(i, 1)) || (a(i, 8)))
    {
      localObject = new EditVideoDoodle(this, i);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle = ((EditVideoDoodle)localObject);
      localArrayList.add(localObject);
    }
    if (a(i, 256))
    {
      localObject = new EditVideoSpeedFilter(this, true);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter = ((EditVideoSpeedFilter)localObject);
      localArrayList.add(localObject);
    }
    if ((paramEditVideoParams.a()) && (a(i, 4)))
    {
      localObject = new EditPicCropPart(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicCropPart = ((EditPicCropPart)localObject);
      localArrayList.add(localObject);
    }
    if (a(i, 512)) {
      if (((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isSameStoryPhotoEntry(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent()))
      {
        localObject = new EditPicSave(this);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicSave = ((EditPicSave)localObject);
        localArrayList.add(localObject);
      }
      else if (!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isStoryPhoto(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent(), this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a()))
      {
        localObject = new EditVideoSave(this);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSave = ((EditVideoSave)localObject);
        localArrayList.add(localObject);
      }
      else
      {
        localObject = new EditPicSave(this);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicSave = ((EditPicSave)localObject);
        localArrayList.add(localObject);
      }
    }
    if (a(i, 16))
    {
      localObject = new EditVideoTransfer(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoTransfer = ((EditVideoTransfer)localObject);
      localArrayList.add(localObject);
    }
    if ((AECameraEntry.c.a(paramEditVideoParams.jdField_f_of_type_Int)) && ((paramEditVideoParams.c()) || (paramEditVideoParams.a()) || (paramEditVideoParams.b())))
    {
      localObject = new SendPanelPart(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelPart = ((SendPanelPart)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.c, 4096))
    {
      paramEditVideoParams = new EditVideoLimitRegion(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoLimitRegion = paramEditVideoParams;
      localArrayList.add(paramEditVideoParams);
    }
    a(localArrayList);
    this.jdField_a_of_type_JavaUtilList = Collections.unmodifiableList(localArrayList);
    SLog.a("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
    paramEditVideoParams = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramEditVideoParams.hasNext()) {
      SLog.a("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts : %s", ((EditVideoPart)paramEditVideoParams.next()).getClass().getSimpleName());
    }
  }
  
  public void a(Class<? extends EditVideoPart.EditExport> paramClass, EditVideoPart.EditExport paramEditExport)
  {
    o();
    E();
    if (paramClass != null)
    {
      if (paramClass.isInstance(paramEditExport))
      {
        localObject = (EditVideoPart.EditExport)this.jdField_a_of_type_JavaUtilMap.get(paramClass);
        if (localObject == null) {
          SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishEditExport for %s with %s", paramClass.getSimpleName(), paramEditExport);
        } else {
          SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "publishEditExport for %s replace %s by %s", new Object[] { paramClass.getSimpleName(), localObject, paramEditExport });
        }
        this.jdField_a_of_type_JavaUtilMap.put(paramClass, paramEditExport);
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
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((EditVideoPart)((Iterator)localObject).next()).a(paramError);
    }
    StoryReportor.b("video_edit", "pub_error", 0, 0, new String[] { paramError.toString() });
    this.jdField_b_of_type_JavaUtilList.add(paramError);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() > 0)
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
      return;
    }
    this.p = false;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.dismissLoadingDialog();
    QQToast.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getContext(), HardCodeUtil.a(2131703910), 0).a();
    paramError = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
    if (paramError != null) {
      paramError.w_();
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
      QZoneHelper.forwardToDLNAActivity(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity(), (QZoneHelper.UserInfo)localObject, localBundle, -1);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    Bosses.get().postJob(new EditVideoPartManager.2(this, "Q.qqstory.publish.edit.EditVideoPartManager", paramString, paramInt1, paramInt2, paramVarArgs));
  }
  
  protected void a(List<EditVideoPart> paramList) {}
  
  public boolean a(int paramInt)
  {
    return this.jdField_f_of_type_Int == paramInt;
  }
  
  public int b()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int;
    int i = 2;
    if (j != 2)
    {
      i = 3;
      if (j != 3)
      {
        i = 4;
        if (j != 4)
        {
          i = 5;
          if (j != 5) {
            return 999;
          }
        }
      }
    }
    return i;
  }
  
  public void b()
  {
    o();
    E();
    ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportRephotoBtn();
    VideoEditReport.a("0X80076B6");
    VideoEditReport.b("0X80075C2");
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle;
    int i;
    if (localObject != null) {
      i = ((EditVideoDoodle)localObject).a();
    } else {
      i = 0;
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicCropPart;
    int j = i;
    if (localObject != null) {
      j = i + ((EditPicCropPart)localObject).jdField_a_of_type_Int;
    }
    SLog.a("Q.qqstory.publish.edit.EditVideoPartManager", "tryQuitRecordUI, current is preview state, edit count = %d", Integer.valueOf(j));
    if (j < 3)
    {
      e();
      return;
    }
    VideoEditReport.a("0X80076B7");
    VideoEditReport.b("0X80075C3");
    if (this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a()) {
      localObject = HardCodeUtil.a(2131703968);
    } else {
      localObject = HardCodeUtil.a(2131703996);
    }
    ActionSheet localActionSheet = ActionSheet.createFullScreenDialog(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getContext(), true);
    localActionSheet.setMainTitle((CharSequence)localObject);
    localActionSheet.addButton(HardCodeUtil.a(2131704004), 3);
    localActionSheet.addCancelButton(HardCodeUtil.a(2131703939));
    localActionSheet.setOnButtonClickListener(new EditVideoPartManager.1(this, localActionSheet));
    localActionSheet.show();
  }
  
  public final void b(int paramInt)
  {
    a(paramInt, null);
  }
  
  public void b(Bundle paramBundle)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).b(paramBundle);
    }
    paramBundle.putInt("mEditState", this.jdField_f_of_type_Int);
  }
  
  public void b(GenerateContext paramGenerateContext)
  {
    long l = this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_AndroidOsBundle.getLong("troop_uin");
    if (l != 0L)
    {
      Object localObject = new qqstory_struct.VideoReaderConf();
      ((qqstory_struct.VideoReaderConf)localObject).ban_type.set(1);
      ((qqstory_struct.VideoReaderConf)localObject).user_list.set(new ArrayList());
      ((qqstory_struct.VideoReaderConf)localObject).setHasFlag(true);
      paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.readerConfBytes = ((qqstory_struct.VideoReaderConf)localObject).toByteArray();
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Long.valueOf(l));
      if (((ArrayList)localObject).size() > 0) {
        try
        {
          qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
          byte[] arrayOfByte = paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.spreadGroupBytes;
          if (arrayOfByte != null) {
            try
            {
              localVideoSpreadGroupList.mergeFrom(paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.spreadGroupBytes);
            }
            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
            {
              SLog.c("Q.qqstory.publish.edit.EditVideoPartManager", "checkTroopStory", localInvalidProtocolBufferMicroException);
            }
          }
          localVideoSpreadGroupList.group_list.set((List)localObject);
          localVideoSpreadGroupList.visibility_type.set(4);
          localVideoSpreadGroupList.setHasFlag(true);
          paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.spreadGroupBytes = localVideoSpreadGroupList.toByteArray();
          return;
        }
        finally {}
      }
    }
  }
  
  public void b(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {}
  
  public int c()
  {
    if (d())
    {
      if (c()) {
        return 3;
      }
      return 4;
    }
    if (c()) {
      return 1;
    }
    return 2;
  }
  
  public void c()
  {
    o();
    E();
    this.q = true;
    Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent();
    this.jdField_a_of_type_AndroidOsBundle = EditState.a((Intent)localObject1);
    this.jdField_a_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("KEY_SEND_ARK_MSG_ID");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onCreate--arkViewId=");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
    AEQLog.b("Q.qqstory.publish.edit.EditVideoPartManager", ((StringBuilder)localObject2).toString());
    localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((EditVideoPart)((Iterator)localObject2).next()).a();
    }
    if ((((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isStoryPhoto((Intent)localObject1, this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a())) || (((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isSameStoryPhotoEntry((Intent)localObject1)))
    {
      LiuHaiUtils.c(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity());
      localObject1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (localObject1 != null) {
        ((RelativeLayout)localObject1).setVisibility(8);
      }
      localObject1 = this.jdField_a_of_type_AndroidViewViewGroup;
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setVisibility(8);
      }
    }
    if (a(this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.c, 64))
    {
      jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecRendererGPUBitmapImageRender = new GPUBitmapImageRender();
      return;
    }
    localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().findViewById(2064122522);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(8);
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFrom ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 2, localStringBuilder.toString());
    }
  }
  
  public boolean c()
  {
    o();
    E();
    return this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a();
  }
  
  public int d()
  {
    EditVideoDoodle localEditVideoDoodle = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle;
    if (localEditVideoDoodle != null) {
      return localEditVideoDoodle.a(a());
    }
    return 0;
  }
  
  public void d(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).f(paramBoolean);
    }
  }
  
  public boolean d()
  {
    o();
    E();
    return this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.d();
  }
  
  public int e()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected void e()
  {
    EditVideoPlayerExport localEditVideoPlayerExport = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
    if (localEditVideoPlayerExport != null) {
      localEditVideoPlayerExport.h();
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.finish(0, null, 2130772056, 0);
  }
  
  public void e(boolean paramBoolean)
  {
    EditVideoButton localEditVideoButton = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoButton;
    if (localEditVideoButton != null) {
      localEditVideoButton.a(paramBoolean);
    }
  }
  
  public boolean e()
  {
    o();
    E();
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      if (!d()) {
        return false;
      }
      return this.jdField_a_of_type_AndroidOsBundle.getBoolean("KEY_FROM_PIC_TO_VIDEO", false);
    }
    return false;
  }
  
  public int f()
  {
    EditVideoDoodle localEditVideoDoodle = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle;
    if (localEditVideoDoodle != null) {
      return localEditVideoDoodle.a();
    }
    return 0;
  }
  
  public void f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle;
    int j = 0;
    int k = 0;
    if (localObject != null)
    {
      localObject = ((EditVideoDoodle)localObject).a();
      if (localObject != null) {
        ((DoodleLayout)localObject).h();
      }
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle.a().a();
      int i = k;
      if (localObject != null)
      {
        i = k;
        if (((LineLayer)localObject).a.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 2, "preparePublish");
          }
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.showLoadingDialog(HardCodeUtil.a(2131703881), false, 500L);
          localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle;
          ((EditVideoDoodle)localObject).jdField_a_of_type_Int = 2;
          ((EditVideoDoodle)localObject).a().n();
          i = 1;
        }
      }
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle.a().a();
      j = i;
      if (localObject != null)
      {
        ((TextLayer)localObject).j();
        j = i;
      }
    }
    if (j == 0) {
      g();
    }
  }
  
  public boolean f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicEditVideoQimMusic;
    if ((localObject != null) && (((EditVideoQimMusic)localObject).a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicEditVideoQimMusic });
      return true;
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle;
    if ((localObject != null) && (((EditVideoDoodle)localObject).a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle });
      return true;
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicCropPart;
    if ((localObject != null) && (((EditPicCropPart)localObject).a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicCropPart });
      return true;
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoButton;
    if ((localObject != null) && (((EditVideoButton)localObject).a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoButton });
      return true;
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoStoryButton;
    if ((localObject != null) && (((EditVideoStoryButton)localObject).a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoStoryButton });
      return true;
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelPart;
    if ((localObject != null) && (((SendPanelPart)localObject).a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelPart });
      return true;
    }
    b();
    return true;
  }
  
  public int g()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.b;
    int i = j;
    if ((this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource instanceof EditLocalVideoSource))
    {
      i = j;
      if (j != 9) {
        i = 2;
      }
    }
    return i;
  }
  
  public void g()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi;
    if (localObject1 == null)
    {
      QLog.e("Q.qqstory.publish.edit.EditVideoPartManager", 1, "onPreparePublishDone error, mUi is null");
      return;
    }
    a(((EditVideoUi)localObject1).getContext());
    a();
    localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity();
    boolean bool = localObject1 instanceof EditPicActivity;
    int i = -1;
    int j;
    if (bool)
    {
      j = ((Activity)localObject1).getIntent().getIntExtra("editpic_cameratype", -1);
      if (j != 1)
      {
        if (j != 2)
        {
          if (j == 3) {
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
    if (e() == 7)
    {
      Object localObject2 = SlideShowPhotoListManager.a();
      if (localObject2 != null)
      {
        localObject1 = ((SlideShowPhotoListManager)localObject2).a();
        Object localObject3 = ((List)localObject1).iterator();
        j = 0;
        while (((Iterator)localObject3).hasNext()) {
          if (((SlideItemInfo)((Iterator)localObject3).next()).b == 1) {
            j += 1;
          }
        }
        int m = ((List)localObject1).size();
        int k = ((SlideShowPhotoListManager)localObject2).a();
        localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent();
        if (localObject2 != null)
        {
          localObject3 = (EditVideoParams)((Intent)localObject2).getParcelableExtra(EditVideoParams.class.getName());
          if (localObject3 != null) {
            i = ((EditVideoParams)localObject3).a("extra_ablum_type", -1);
          } else {
            i = ((Intent)localObject2).getIntExtra("extra_ablum_type", -1);
          }
        }
        if (k == 11) {
          k = 0;
        } else {
          k = 1;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(StoryReportor.a(i));
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((List)localObject1).size());
        ((StringBuilder)localObject3).append("");
        localObject1 = ((StringBuilder)localObject3).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(m - j);
        ((StringBuilder)localObject3).append("");
        localObject3 = ((StringBuilder)localObject3).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(j);
        localStringBuilder.append("");
        StoryReportor.a("video_edit_slides", "clk_pub", k, 0, new String[] { localObject2, localObject1, localObject3, localStringBuilder.toString() });
      }
    }
  }
  
  public boolean g()
  {
    SendPanelPart localSendPanelPart = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelPart;
    return (localSendPanelPart != null) && (localSendPanelPart.jdField_a_of_type_Boolean);
  }
  
  public int h()
  {
    if (d())
    {
      if (c()) {
        return 3;
      }
      return 4;
    }
    if (c()) {
      return 1;
    }
    return 2;
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi = null;
  }
  
  public int i()
  {
    EditVideoParams localEditVideoParams = this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams;
    int i = 4;
    if (localEditVideoParams != null)
    {
      int j = localEditVideoParams.a();
      if (j != 2)
      {
        if (j == 3) {
          return i;
        }
        if (j != 4) {
          if (j != 11)
          {
            if (j != 12) {
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
    i = 0;
    return i;
  }
  
  public void i()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).o();
    }
  }
  
  public boolean isValidate()
  {
    return this.q;
  }
  
  public void j()
  {
    if (this.jdField_f_of_type_Int == -1) {
      b(0);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).d();
    }
  }
  
  public void k()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).z_();
    }
  }
  
  public void l()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).A_();
    }
  }
  
  public final void m()
  {
    AEQLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "onSaveOrUploadArkVideoError");
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity(), 230).setMessage(2131689709).setPositiveButton(2131689708, new EditVideoPartManager.10(this)).setNegativeButton(2131690728, new EditVideoPartManager.9(this));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void n()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((EditVideoPart)((Iterator)localObject).next()).e();
      }
      h();
    }
    if ((jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecRendererGPUBitmapImageRender != null) && (!MediaCodecUtil.c())) {
      jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecRendererGPUBitmapImageRender.a();
    }
    VideoFilterTools.a().b();
    this.q = false;
  }
  
  protected void o()
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      return;
    }
    throw new IllegalStateException("can not access by non-ui thread");
  }
  
  void p()
  {
    EditVideoDoodle localEditVideoDoodle = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle;
    if (localEditVideoDoodle != null) {
      localEditVideoDoodle.a().i();
    }
    b(9);
    if (SlideShowPhotoListManager.a().b() == 22)
    {
      LpReportInfo_pf00064.allReport(680, 2, 6);
      LpReportInfo_pf00064.allReport(680, 12, 1);
    }
  }
  
  void q()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle.a().i();
    b(19);
    if (SlideShowPhotoListManager.a().b() == 22)
    {
      LpReportInfo_pf00064.allReport(680, 2, 5);
      LpReportInfo_pf00064.allReport(680, 13, 1);
    }
  }
  
  public void r()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle;
    if (localObject != null)
    {
      localObject = ((EditVideoDoodle)localObject).a();
      if (localObject != null) {
        ((DoodleLayout)localObject).a.c();
      }
    }
  }
  
  void s()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicCropPart;
    ((EditPicCropPart)localObject).jdField_a_of_type_Int += d();
    int i = this.jdField_f_of_type_Int;
    int j = 0;
    if (i == 7)
    {
      b(0);
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle.a();
    ((DoodleLayout)localObject).g();
    LineLayer localLineLayer = ((DoodleLayout)localObject).a();
    i = j;
    if (localLineLayer != null)
    {
      i = j;
      if (localLineLayer.a.a())
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.showLoadingDialog(HardCodeUtil.a(2131703936), false, 500L);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle.jdField_a_of_type_Int = 3;
        ((DoodleLayout)localObject).n();
        i = 1;
      }
    }
    if (i == 0) {
      t();
    }
  }
  
  void t()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.dismissLoadingDialog();
    Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle.a();
    Object localObject2 = ((DoodleLayout)localObject1).a(0);
    Object localObject3 = ((DoodleLayout)localObject1).b(0);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicCropPart.jdField_a_of_type_ArrayOfInt[0] = localObject2[0];
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicCropPart.jdField_a_of_type_ArrayOfInt[1] = localObject2[1];
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicCropPart.jdField_a_of_type_ArrayOfInt[2] = localObject3[0];
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicCropPart.jdField_a_of_type_ArrayOfInt[3] = localObject3[1];
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicCropPart.jdField_a_of_type_ArrayOfInt[4] = ((DoodleLayout)localObject1).a().b();
    localObject2 = a();
    if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
    {
      localObject3 = ((DoodleLayout)localObject1).a();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = BitmapUtils.c((Bitmap)localObject2, (Bitmap)localObject3);
        SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "onPrepareCropDone merged");
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicCropPart.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
      b(7);
      return;
    }
    SLog.e("Q.qqstory.publish.edit.EditVideoPartManager", "onPrepareCropDone fail");
  }
  
  public void u()
  {
    EditVideoDoodle localEditVideoDoodle = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle;
    if (localEditVideoDoodle != null) {
      localEditVideoDoodle.a().j();
    }
  }
  
  public void v()
  {
    EditVideoDoodle localEditVideoDoodle = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle;
    if (localEditVideoDoodle != null) {
      localEditVideoDoodle.a().r();
    }
  }
  
  public void w()
  {
    y();
    b(0);
  }
  
  public void x()
  {
    EditProviderPart localEditProviderPart = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditProviderPart;
    if (localEditProviderPart != null) {
      localEditProviderPart.j();
    }
  }
  
  public void y()
  {
    b(24);
    ThreadManager.getUIHandler().post(new EditVideoPartManager.12(this));
  }
  
  public void z()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager
 * JD-Core Version:    0.7.0.1
 */