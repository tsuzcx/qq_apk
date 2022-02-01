package com.tencent.aelight.camera.aioeditor.takevideo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.report_datong.AECameraDaTongHelper;
import com.tencent.aelight.camera.ae.util.AECommonUtil;
import com.tencent.aelight.camera.aioeditor.QIMCaptureVarManager;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.NewFlowCameraReporter;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem.TextMap;
import com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager;
import com.tencent.aelight.camera.aioeditor.takevideo.artfilter.ArtFilterBridgeActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.TextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GeneratePicArgs;
import com.tencent.aelight.camera.api.IAECameraUnit;
import com.tencent.aelight.camera.download.api.IAEKitForQQ;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.aelight.camera.struct.editor.DoodleInfoLoadObserver;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.subscribe.utils.NavigationBarUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditLocalPhotoSource;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditTakePhotoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.editor.params.EditVideoParams.EditSource;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.shortvideo.EditActivityEntranceUtil;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SvEffectSdkInitor;
import com.tencent.util.LiuHaiUtils;
import dov.com.qq.im.ae.current.SessionWrap;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

@RoutePage(desc="图片裁剪", path="/business/dov/editPic")
public class EditPicActivity
  extends QQStoryBaseActivity
  implements EditVideoPartManager.IEditVideoPartManager, EditVideoUi
{
  public static final String IMAGE_PATH = "image_path";
  public static final int REQUEST_CODE_RE_CAMERA = 666;
  public static final int REQUEST_PIC_FORWARD_ACTIVITY = 1000;
  public static final int REQUEST_WEBPIC_UPLOAD_ACTIVITY = 1001;
  public static final String SP_KEY_NEW_PATH = "edit_pic_new_path";
  public static final String TAG = "EditPicActivity";
  public long mCreateTime = -1L;
  DoodleInfoLoadObserver mDoodleInfoLoadObserver = new EditPicActivity.1(this);
  protected EditVideoPartManager mEditVideoPartManager = new EditPicPartManager();
  private RelativeLayout topTransPantH;
  
  public static Intent compactAPI21SystemShare(Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      int i = paramIntent.getFlags();
      if ((0x80000 & i) > 0) {
        paramIntent.setFlags(i & 0xFFF7FFFF);
      }
    }
    return paramIntent;
  }
  
  private void initLiuHaiScreenTopBar()
  {
    if (LiuHaiUtils.g())
    {
      this.topTransPantH = ((RelativeLayout)findViewById(2063991220));
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.topTransPantH.getLayoutParams();
      localLayoutParams.height = LiuHaiUtils.h();
      this.topTransPantH.setLayoutParams(localLayoutParams);
      this.topTransPantH.setVisibility(0);
    }
  }
  
  public static Intent startEditPic(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt)
  {
    return startEditPic(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramInt, 99, 0, false, null, null);
  }
  
  public static Intent startEditPic(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt1, int paramInt2, int paramInt3)
  {
    return startEditPic(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramInt1, paramInt2, 0, false, null, null);
  }
  
  public static Intent startEditPic(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    return startEditPic(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramInt1, paramInt2, 0, false, null, paramBundle);
  }
  
  public static Intent startEditPic(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt1, int paramInt2, int paramInt3, HashMap<String, Object> paramHashMap)
  {
    return startEditPic(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramInt1, paramInt2, 0, false, paramHashMap, null);
  }
  
  public static Intent startEditPic(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean6, HashMap<String, Object> paramHashMap, Bundle paramBundle)
  {
    Log.d("EditPicActivity", "startEditPic");
    Bundle localBundle = paramActivity.getIntent().getExtras();
    Intent localIntent = new Intent();
    if (localBundle != null) {
      localIntent.putExtras(localBundle);
    }
    localIntent.setClass(paramActivity, ArtFilterBridgeActivity.class);
    if (!localIntent.hasExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME")) {
      localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    }
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    if ((paramActivity instanceof SplashActivity)) {
      localIntent.putExtra("key_activity_code", ChatActivityUtils.a(paramActivity));
    }
    localIntent.putExtra("open_chatfragment", true);
    long l1 = 0L;
    if (paramBoolean1)
    {
      l1 = 1024L;
      if (paramInt1 == 2) {
        l1 = 132096L;
      }
    }
    long l2 = l1;
    if (paramBoolean2) {
      l2 = l1 | 1L;
    }
    l1 = l2;
    if (paramBoolean3) {
      l1 = l2 | 0x8;
    }
    l2 = l1;
    if (paramBoolean4) {
      l2 = l1 | 0x4;
    }
    l1 = l2;
    if (paramBoolean5)
    {
      l1 = l2;
      if (Build.VERSION.SDK_INT >= 21) {
        l1 = l2 | 0x40;
      }
    }
    if (paramInt1 != 2)
    {
      l2 = l1;
      if (paramInt1 != 6) {}
    }
    else
    {
      l2 = l1 | 0x800 | 0x200 | 0x10000 | 0x40 | 0x2000;
    }
    if ((paramInt1 != 8) && (paramInt1 != 4))
    {
      l1 = l2;
      if (paramInt1 != 3) {}
    }
    else
    {
      l1 = l2 | 0x200;
    }
    l2 = l1;
    if (paramInt1 == 15) {
      l2 = l1 | 0x200;
    }
    if ((paramBundle != null) && (paramBundle.getBoolean("key_multi_edit_pic", false))) {
      localIntent.putExtra("key_multi_edit_pic", true);
    }
    l1 = l2;
    if (paramInt1 != 8) {
      l1 = l2 | 0x1000;
    }
    if ((paramInt2 != 122) && (paramInt2 != 125) && (paramInt2 != 133))
    {
      l2 = l1;
      if (!EditVideoParams.a(paramInt2)) {}
    }
    else
    {
      l2 = l1 & 0xFFFFFDFF;
    }
    paramBundle = (SessionWrap)paramActivity.getIntent().getParcelableExtra("ARG_SESSION_INFO");
    if (paramBundle != null)
    {
      localIntent.putExtra("uin", paramBundle.a);
      localIntent.putExtra("uintype", paramBundle.c);
      localIntent.putExtra("troop_uin", paramBundle.d);
      localIntent.putExtra("uinname", paramBundle.b);
    }
    localIntent.putExtra("EDIT_BUSI", paramInt1);
    localIntent.putExtra("entrance_type", paramInt2);
    localIntent.putExtra("pic_entrance_type", paramInt3);
    localIntent.putExtra("TEMP_PARAM", l2);
    localIntent.putExtra("PATH", paramString);
    localIntent.putExtra("go_publish_activity", paramBoolean6);
    if (paramHashMap != null) {
      localIntent.putExtra("user_params", paramHashMap);
    }
    localIntent.removeExtra("camera_type");
    paramString = localIntent;
    if (paramActivity.getClass().getName().contains("ForwardRecentActivity")) {
      paramString = compactAPI21SystemShare(localIntent);
    }
    return paramString;
  }
  
  public static Intent startEditPic(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean9, HashMap<String, Object> paramHashMap)
  {
    return startEditPic(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramInt1, paramInt2, paramInt3, paramBoolean9, paramHashMap, null);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.mEditVideoPartManager.a(paramInt1, paramInt2, paramIntent);
    SLog.c("EditPicActivity", "doOnActivityResult");
    if (paramInt1 == 666)
    {
      if (paramInt2 == -1)
      {
        Intent localIntent = getIntent();
        localIntent.setClass(this, EditPicActivity.class);
        if (localIntent.getIntExtra("camera_type", -1) == 103) {
          paramIntent = this.mEditVideoPartManager.I.e.a();
        } else {
          paramIntent = localIntent.getStringExtra("image_path");
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("reset2Camera end shoot ");
          ((StringBuilder)localObject).append(this);
          ((StringBuilder)localObject).append(" new path ");
          ((StringBuilder)localObject).append(paramIntent);
          QLog.d("EditPicActivity", 2, ((StringBuilder)localObject).toString());
        }
        Object localObject = paramIntent;
        if (TextUtils.isEmpty(paramIntent))
        {
          localObject = PreferenceManager.getDefaultSharedPreferences(this).getString("edit_pic_new_path", "");
          paramIntent = new StringBuilder();
          paramIntent.append(" be killed. read sp ");
          paramIntent.append((String)localObject);
          QLog.d("EditPicActivity", 1, paramIntent.toString());
        }
        if (!FileUtils.fileExists((String)localObject))
        {
          paramIntent = new StringBuilder();
          paramIntent.append("recamera file not exist ");
          paramIntent.append((String)localObject);
          QLog.i("EditPicActivity", 1, paramIntent.toString());
          QQToast.makeText(this, HardCodeUtil.a(2131901774), 0).show();
          finish();
          return;
        }
        paramIntent = new EditVideoParams(this.mEditVideoPartManager.I.a, this.mEditVideoPartManager.I.c, new EditTakePhotoSource((String)localObject), new Bundle());
        localIntent.putExtra(EditVideoParams.class.getName(), paramIntent);
        finish();
        startActivity(localIntent);
        return;
      }
      SLog.c("EditPicActivity", "recamera cancel, finish");
      finish();
      return;
    }
    if (paramInt1 == 1000)
    {
      if (paramInt2 == -1)
      {
        finish(paramInt2, paramIntent, 2130772081, 0);
        this.mEditVideoPartManager.a(paramInt1, paramInt2, paramIntent);
      }
    }
    else
    {
      if (paramInt1 == 1001)
      {
        finish(paramInt2, paramIntent, 2130772081, 0);
        return;
      }
      if (paramInt1 == 19003)
      {
        if (paramInt2 == -1)
        {
          finish(paramInt2, paramIntent, 2130772081, 0);
          return;
        }
        if ((paramInt2 == 0) && (paramIntent != null) && (paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false))) {
          finish(-1, paramIntent, 2130772081, 0);
        }
      }
    }
  }
  
  public void doOnBackPressed()
  {
    SLog.c("EditPicActivity", "doOnBackPressed");
    if (!this.mEditVideoPartManager.x()) {
      super.doOnBackPressed();
    }
  }
  
  @TargetApi(9)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    LiuHaiUtils.d();
    LiuHaiUtils.h(this);
    LiuHaiUtils.i(this);
    if (LiuHaiUtils.g()) {
      LiuHaiUtils.enableNotch(this);
    }
    SvEffectSdkInitor.a();
    ((IAEKitForQQ)QRoute.api(IAEKitForQQ.class)).init();
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    this.isClearCoverLayer = false;
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    EditPicConstants.a();
    paramBundle = (EditVideoParams)getIntent().getParcelableExtra(EditVideoParams.class.getName());
    NewFlowCameraReporter.a("finish jump activity", NewFlowCameraReporter.b(getIntent()));
    SLog.d("EditPicActivity", "doOnCreate instance=%d, video params=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), paramBundle });
    if ((paramBundle != null) && (!TextUtils.isEmpty(paramBundle.e.a())))
    {
      StringBuilder localStringBuilder1;
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("source ");
        localStringBuilder1.append(paramBundle.e.a());
        QLog.d("EditPicActivity", 2, localStringBuilder1.toString());
      }
      if (!FileUtils.fileExists(paramBundle.e.a()))
      {
        QQToast.makeText(this, HardCodeUtil.a(2131901778), 0).show();
        finish();
        return true;
      }
      int i = getIntent().getIntExtra("editpic_cameratype", -1);
      if (i == 1)
      {
        NewFlowCameraReporter.d();
        BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putLong("sv_latest_taken_photo_time", System.currentTimeMillis()).commit();
      }
      else if (i == 2)
      {
        NewFlowCameraReporter.e();
      }
      AECameraDaTongHelper.a.a(this, "pg_ae_camera_photo_save");
      AEBaseReportParam.a().l();
      if (paramBundle.b())
      {
        i = paramBundle.a;
        j = paramBundle.j();
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("businessId=");
        localStringBuilder1.append(i);
        localStringBuilder1.append(", entranceType=");
        localStringBuilder1.append(j);
        AEQLog.b("EditPicActivity", localStringBuilder1.toString());
        if (i == 2)
        {
          if ((j != 140) && (j != 142))
          {
            if (j == 126) {
              AEBaseReportParam.a().e(3);
            } else if ((j == 11) || (j == 9) || (j == 10)) {
              AEBaseReportParam.a().e(1);
            }
          }
          else {
            AEBaseReportParam.a().e(2);
          }
        }
        else if (i == 3) {
          AEBaseReportParam.a().e(4);
        }
      }
      if ((paramBundle.e instanceof EditTakePhotoSource)) {
        AEBaseReportParam.a().b(AEBaseReportParam.b.longValue());
      } else if ((paramBundle.e instanceof EditTakeVideoSource)) {
        AEBaseReportParam.a().b(AEBaseReportParam.c.longValue());
      } else if ((paramBundle.e instanceof EditLocalPhotoSource)) {
        AEBaseReportParam.a().b(AEBaseReportParam.d.longValue());
      } else if ((paramBundle.e instanceof EditLocalVideoSource)) {
        AEBaseReportParam.a().b(AEBaseReportParam.e.longValue());
      }
      i = getIntent().getIntExtra("edit_video_way", 0);
      this.mEditVideoPartManager.e(i);
      try
      {
        ((IAEResUtil)QRoute.api(IAEResUtil.class)).loadAEBaseSo();
        if (VideoEnvironment.loadAVCodecSo() != 0) {
          SLog.e("EditPicActivity", "load AVCodec so failed");
        }
      }
      catch (Exception localException)
      {
        SLog.c("EditPicActivity", "load so failed", localException);
      }
      this.mEditVideoPartManager.aa = true;
      setContentViewC(2064056491);
      if (isInMultiWindow())
      {
        QQToast.makeText(this, HardCodeUtil.a(2131901775), 0).show();
        finish();
        return true;
      }
      initLiuHaiScreenTopBar();
      this.mEditVideoPartManager.a(this, paramBundle);
      if ((this.mEditVideoPartManager.R != null) && (this.mEditVideoPartManager.S != null))
      {
        long l = getIntent().getLongExtra("babyq_ability", 0L) & 0x2;
        localObject = this.mEditVideoPartManager.R;
        boolean bool;
        if (l > 0L) {
          bool = true;
        } else {
          bool = false;
        }
        ((EditPicRawImage)localObject).d = bool;
        localObject = this.mEditVideoPartManager.S;
        if (l > 0L) {
          bool = true;
        } else {
          bool = false;
        }
        ((EditPicCropPart)localObject).r = bool;
      }
      Object localObject = (QIMCaptureVarManager)QIMManager.a(13);
      ((QIMCaptureVarManager)localObject).b(this.mEditVideoPartManager.I.h());
      this.mEditVideoPartManager.c();
      PtvTemplateManager.a().a(this.mApp, this.mDoodleInfoLoadObserver);
      if (paramBundle.d != null)
      {
        i = paramBundle.d.getInt("pic_entrance_type", 0);
        VideoEditReport.b(i);
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("picEntanceType=");
        localStringBuilder2.append(i);
        AEQLog.a("EditPicActivity", localStringBuilder2.toString());
      }
      GeneratePicArgs.a(null);
      this.mCreateTime = System.currentTimeMillis();
      i = this.mEditVideoPartManager.T();
      int j = this.mEditVideoPartManager.I.j();
      int k = this.mEditVideoPartManager.V();
      getIntent().putExtra("capture_operation_in", k);
      StoryReportor.a("video_edit_new", "edit_exp", k, 0, new String[] { StoryReportor.d(i), "", "", String.valueOf(j) });
      ((QIMCaptureVarManager)localObject).e(1);
      ((QIMCaptureVarManager)localObject).a(4);
      EditActivityEntranceUtil.a("0X800B3C4", paramBundle.j());
      return true;
    }
    finish();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    SLog.b("EditPicActivity", "doOnDestroy %d", Integer.valueOf(System.identityHashCode(this)));
    this.mEditVideoPartManager.w();
    QIMCaptureVarManager localQIMCaptureVarManager = (QIMCaptureVarManager)QIMManager.a(13);
    if (localQIMCaptureVarManager != null) {
      localQIMCaptureVarManager.e(1);
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    SLog.c("EditPicActivity", "doOnPause");
    this.mEditVideoPartManager.t();
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, true);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    SLog.c("EditPicActivity", "doOnResume");
    this.mEditVideoPartManager.s();
    NewFlowCameraReporter.a("resume activity");
    ((QIMCaptureVarManager)QIMManager.a(13)).d(1);
    if (Build.VERSION.SDK_INT >= 29) {
      NavigationBarUtil.a(getWindow());
    }
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, false);
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    SLog.c("EditPicActivity", "doOnStart");
    this.mEditVideoPartManager.r();
    VideoEditReport.a = VideoEditReport.a(this.mEditVideoPartManager.I.a);
    VideoEditReport.b = "pic_edit";
    ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportEditViewExpose();
    ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).setShootTime();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    this.mEditVideoPartManager.u();
    ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportEditView();
    AEQLog.b("EditPicActivity", "【doOnStop】");
    VideoEditReport.a = "";
    VideoEditReport.b = "";
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    this.mEditVideoPartManager.d(paramBoolean);
  }
  
  public void finish(int paramInt1, Intent paramIntent, int paramInt2, int paramInt3)
  {
    finish(paramInt1, paramIntent, paramInt2, paramInt3, false);
  }
  
  public void finish(int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditPicActivity", 2, new Object[] { "finish, publishStoryFlag", Boolean.valueOf(paramBoolean) });
    }
    ((IAECameraUnit)QRoute.api(IAECameraUnit.class)).setPublishStoryFlag(paramBoolean);
    setResult(paramInt1, paramIntent);
    finish();
    overridePendingTransition(paramInt3, paramInt2);
    this.mEditVideoPartManager.O();
  }
  
  public Context getContext()
  {
    return this;
  }
  
  public EditVideoPartManager getManager()
  {
    return this.mEditVideoPartManager;
  }
  
  public Intent getPublishIntent(GenerateContext paramGenerateContext)
  {
    if (this.mEditVideoPartManager.G == null) {
      localObject1 = getIntent();
    } else {
      localObject1 = this.mEditVideoPartManager.G;
    }
    String str = ((Intent)localObject1).getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
    Object localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME");
    if ((str != null) && (localObject2 != null))
    {
      ((Intent)localObject1).setClassName((String)localObject2, str);
      ((Intent)localObject1).putExtra("open_chatfragment_fromphoto", true);
    }
    Object localObject4 = new ArrayList();
    boolean bool1 = paramGenerateContext.l.h;
    int i = 0;
    if ((!bool1) && (paramGenerateContext.l.g))
    {
      localObject2 = paramGenerateContext.l.b;
      if (getIntent().getIntExtra("camera_type", -1) != -1)
      {
        localObject3 = new File(paramGenerateContext.l.a);
        if (AECommonUtil.a(getContext(), (File)localObject3)) {
          FileUtils.deleteFile(paramGenerateContext.l.a);
        }
        ImageUtil.b(this, paramGenerateContext.l.a);
      }
      ((Intent)localObject1).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    }
    else
    {
      QLog.d("EditPicActivity", 1, "send sourcePath");
      localObject2 = this.mEditVideoPartManager.I.e.a();
    }
    ((ArrayList)localObject4).add(localObject2);
    Object localObject3 = null;
    Object localObject5 = this.mEditVideoPartManager;
    localObject2 = localObject3;
    if (localObject5 != null)
    {
      localObject2 = localObject3;
      if (((EditVideoPartManager)localObject5).O != null)
      {
        localObject2 = localObject3;
        if (this.mEditVideoPartManager.O.b() != null)
        {
          localObject2 = localObject3;
          if (this.mEditVideoPartManager.O.b().getTextLayer() != null) {
            localObject2 = this.mEditVideoPartManager.O.b().getTextLayer().t;
          }
        }
      }
    }
    localObject3 = new JSONArray();
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject5 = (TextLayer.TextItem)((Iterator)localObject2).next();
        if ((((TextLayer.TextItem)localObject5).c != null) && (((TextLayer.TextItem)localObject5).c.i() != null)) {
          ((JSONArray)localObject3).put(((TextLayer.TextItem)localObject5).c.i().toString());
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("EditPicActivity getPublishIntent, content is: ");
      ((StringBuilder)localObject2).append(((JSONArray)localObject3).toString());
      QLog.i("DText", 2, ((StringBuilder)localObject2).toString());
    }
    if (((JSONArray)localObject3).length() > 0) {
      ((Intent)localObject1).putExtra("dynamic_text", ((JSONArray)localObject3).toString());
    }
    ((Intent)localObject1).putExtra(PublishParam.a, paramGenerateContext.m);
    boolean bool2 = ((Intent)localObject1).getBooleanExtra("input_full_screen_mode", false);
    if ((!paramGenerateContext.l.h) && (paramGenerateContext.l.g)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    ((Intent)localObject1).putExtra("PhotoConst.SEND_ORIGIN", bool1);
    ((Intent)localObject1).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject4);
    ((Intent)localObject1).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)((ArrayList)localObject4).get(0));
    if (bool1) {
      i = 2;
    }
    ((Intent)localObject1).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", i);
    ((Intent)localObject1).putExtra("PhotoConst.SEND_FLAG", true);
    ((Intent)localObject1).addFlags(603979776);
    if ((this.mEditVideoPartManager.I.l()) || (bool2)) {
      ((Intent)localObject1).putExtra("key_multi_edit_source_path", this.mEditVideoPartManager.I.e.a());
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sendPhotoForPhotoPlus , activity = ");
      ((StringBuilder)localObject2).append(this);
      ((StringBuilder)localObject2).append(",flag = ");
      ((StringBuilder)localObject2).append(((Intent)localObject1).getFlags());
      ((StringBuilder)localObject2).append(",data = ");
      ((StringBuilder)localObject2).append(((Intent)localObject1).getExtras());
      QLog.d("EditPicActivity", 2, ((StringBuilder)localObject2).toString());
    }
    localObject2 = localObject1;
    if (str != null)
    {
      localObject2 = localObject1;
      if (str.contains("ForwardRecentActivity")) {
        localObject2 = compactAPI21SystemShare((Intent)localObject1);
      }
    }
    Object localObject1 = ((Intent)localObject2).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    localObject3 = ((Intent)localObject2).getStringExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME");
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("initclassName:");
      ((StringBuilder)localObject4).append((String)localObject1);
      QLog.d("EditPicActivity", 2, ((StringBuilder)localObject4).toString());
    }
    if (localObject1 != null) {
      if ((("com.tencent.mobileqq.activity.SplashActivity".equals(localObject1)) || ("com.tencent.mobileqq.activity.ChatActivity".equals(localObject1))) && ("com.tencent.mobileqq.activity.photo.PhotoPreviewActivity".equals(str)) && ("com.tencent.mobileqq.activity.photo.SendPhotoActivity".equals(localObject3))) {
        ((Intent)localObject2).setClassName(((Intent)localObject2).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), (String)localObject1);
      } else if ("com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity".equals(str)) {
        ((Intent)localObject2).setClassName("com.tencent.mobileqq", (String)localObject1);
      }
    }
    ((Intent)localObject2).putExtra("open_chatfragment_fromphoto", true);
    ((Intent)localObject2).putExtra("VIDEO_LOCATE_DESCRIPTION", paramGenerateContext.d.videoLocationDescription);
    ((Intent)localObject2).putExtra("VIDEO_LOCAL_LONGITUDE", paramGenerateContext.d.videoLongitude);
    ((Intent)localObject2).putExtra("VIDEO_LOCAL_LATITUDE", paramGenerateContext.d.videoLatitude);
    paramGenerateContext = ((Intent)localObject2).getStringExtra("key_camera_material_name");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("AIO send photo---takeSameName=");
    ((StringBuilder)localObject1).append(paramGenerateContext);
    AEQLog.b("EditPicActivity", ((StringBuilder)localObject1).toString());
    return localObject2;
  }
  
  public View getRootView()
  {
    return getWindow().getDecorView();
  }
  
  public void initNavigationBarColor() {}
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void setEditVideoPartManager(EditVideoPartManager paramEditVideoPartManager)
  {
    this.mEditVideoPartManager = paramEditVideoPartManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity
 * JD-Core Version:    0.7.0.1
 */