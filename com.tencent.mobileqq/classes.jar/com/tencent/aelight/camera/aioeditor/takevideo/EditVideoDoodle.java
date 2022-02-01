package com.tencent.aelight.camera.aioeditor.takevideo;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.Nullable;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.aioeditor.capture.CaptureContext;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.paster.PasterDataManager;
import com.tencent.aelight.camera.aioeditor.capture.util.DoodleLayoutConnector;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderViewEditContainer;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.LocationFacePackage.Item;
import com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.DynamicFaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.FaceItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiManager.POIPostersRequestCallback;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.DoodleBtnOperationHelper;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.DoodleEventListener;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateDoodleImageSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GeneratePicArgs;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.HWEncodeGenerateDoodleImageSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.Publishable;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.aelight.camera.struct.editor.DoodleInfoLoadObserver;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.common.app.AppInterface;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeGifImage;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditLocalPhotoSource;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditTakePhotoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.editor.params.EditVideoParams.EditSource;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.util.LiuHaiUtils;
import com.tribe.async.async.JobSegment;
import com.tribe.async.dispatch.IEventReceiver;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EditVideoDoodle
  extends EditVideoPart
  implements EditDoodleExport, DoodleLayout.DoodleBtnOperationHelper, DoodleLayout.DoodleEventListener, Publishable, IEventReceiver
{
  public static final String a;
  public static String b;
  public int a;
  protected Handler a;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new EditVideoDoodle.4(this);
  public ProviderViewEditContainer a;
  DoodleEmojiManager.POIPostersRequestCallback jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleModelDoodleEmojiManager$POIPostersRequestCallback = new EditVideoDoodle.6(this);
  protected DoodleLayout a;
  private DoodleView jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView;
  DoodleInfoLoadObserver jdField_a_of_type_ComTencentAelightCameraStructEditorDoodleInfoLoadObserver = new EditVideoDoodle.10(this);
  protected Runnable a;
  protected boolean a;
  protected byte[] a;
  private final int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 0L;
  public boolean b;
  protected boolean c = false;
  private boolean d = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = QQStoryConstant.f;
    jdField_b_of_type_JavaLangString = "EditVideoDoodle";
  }
  
  public EditVideoDoodle(@NonNull EditVideoPartManager paramEditVideoPartManager, int paramInt)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = new EditVideoDoodle.5(this);
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private void a(int paramInt)
  {
    if (paramInt != 0)
    {
      if ((paramInt != 4) && (paramInt != 8)) {
        return;
      }
      DoodleLayout localDoodleLayout = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout;
      if ((localDoodleLayout != null) && (localDoodleLayout.getVisibility() != paramInt))
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.setVisibility(paramInt);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.setDoodleGLViewVisibility(paramInt);
      }
    }
    else
    {
      g();
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.getVisibility() != paramInt)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.setVisibility(paramInt);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.setDoodleGLViewVisibility(paramInt);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, View paramView)
  {
    if (paramView == null)
    {
      AEQLog.d("Q.qqstory.publish.edit.StoryDoodle", "doodle main layout null");
      return;
    }
    float f = paramInt1 / paramInt2;
    int i = ScreenUtil.SCREEN_WIDTH;
    paramInt1 = ScreenUtil.SCREEN_HIGHT;
    if (!ScreenUtil.checkDeviceHasNavigationBar(a()))
    {
      paramInt1 = ScreenUtil.getRealHeight(a());
    }
    else
    {
      paramInt2 = ScreenUtil.SCREEN_HIGHT;
      paramInt1 = paramInt2;
      if (Build.MODEL.equals("Lenovo L78011")) {
        paramInt1 = paramInt2 - LiuHaiUtils.a(a());
      }
    }
    paramInt2 = (int)(i / f);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.width = i;
      localLayoutParams.height = paramInt2;
      localLayoutParams.addRule(15);
      localLayoutParams.setMargins(0, paramInt1 / 2 - paramInt2 / 2, 0, 0);
      paramView.setLayoutParams(localLayoutParams);
    }
  }
  
  private void a(String paramString)
  {
    paramString = new File(paramString);
    boolean bool;
    if (paramString.isFile())
    {
      bool = paramString.delete();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("delete file : ");
      localStringBuilder.append(bool);
      SLog.d("Q.qqstory.publish.edit.StoryDoodle", localStringBuilder.toString());
    }
    if (!paramString.exists())
    {
      bool = paramString.mkdirs();
      paramString = new StringBuilder();
      paramString.append("create folder : ");
      paramString.append(bool);
      SLog.d("Q.qqstory.publish.edit.StoryDoodle", paramString.toString());
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.d()) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int == 14) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a() != null) && (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a().isLandTakePicToVideo()) && ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource instanceof EditLocalVideoSource)))
    {
      int k = ((EditLocalVideoSource)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
      int i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource.a();
      int j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource.b();
      if ((k == 90) || (k == 270))
      {
        i = Math.min(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource.a(), this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource.b());
        j = Math.max(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource.a(), this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource.b());
      }
      if (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a().getTakePicToVideo()) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a();
      }
      a(i, j, this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout);
    }
  }
  
  public int a()
  {
    DoodleLayout localDoodleLayout = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout;
    if (localDoodleLayout == null) {
      return 0;
    }
    return localDoodleLayout.b();
  }
  
  public int a(int paramInt)
  {
    DoodleLayout localDoodleLayout = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout;
    if (localDoodleLayout == null) {
      return 0;
    }
    return localDoodleLayout.a(paramInt);
  }
  
  public Bitmap a()
  {
    DoodleLayout localDoodleLayout = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout;
    if (localDoodleLayout == null) {
      return null;
    }
    return localDoodleLayout.a();
  }
  
  public Bitmap a(int paramInt, boolean paramBoolean)
  {
    DoodleLayout localDoodleLayout = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout;
    if (localDoodleLayout == null) {
      return null;
    }
    return localDoodleLayout.a(paramInt, paramBoolean);
  }
  
  @NonNull
  public DoodleLayout a()
  {
    g();
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout;
  }
  
  public JobSegment<GenerateContext, GenerateContext> a(int paramInt)
  {
    if ((!(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource instanceof EditTakeVideoSource)) && (!(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource instanceof EditLocalVideoSource))) {
      return (JobSegment)StoryApi.a(GenerateDoodleImageSegment.class, new Object[] { this, (EditFilterExport)a(EditFilterExport.class), Integer.valueOf(paramInt) });
    }
    return (JobSegment)StoryApi.a(HWEncodeGenerateDoodleImageSegment.class, new Object[] { this, (EditFilterExport)a(EditFilterExport.class), Integer.valueOf(paramInt) });
  }
  
  public void a()
  {
    a(jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2064122116));
    QQStoryContext.a();
    AppInterface localAppInterface = QQStoryContext.a();
    PtvTemplateManager.a().a(localAppInterface, this.jdField_a_of_type_ComTencentAelightCameraStructEditorDoodleInfoLoadObserver);
    ThreadManager.excute(new EditVideoDoodle.3(this), 64, null, true);
    a(EditDoodleExport.class, this);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 == 2) {}
    }
    else
    {
      long l = SystemClock.elapsedRealtime();
      if (l - this.jdField_b_of_type_Long > 4000L)
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoDoodle.9(this));
        this.jdField_b_of_type_Long = l;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    this.d = false;
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2) {
          if (paramInt2 != 3) {
            if (paramInt2 != 4) {
              if (paramInt2 != 7)
              {
                if (paramInt2 == 8) {
                  return;
                }
                if ((paramInt2 == 17) || (paramInt2 == 18) || (paramInt2 == 21)) {
                  break label201;
                }
                if (paramInt2 == 25) {}
              }
            }
          }
        }
        switch (paramInt2)
        {
        default: 
          a(0);
          return;
          if (paramInt1 == 5) {
            break;
          }
          g();
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.l();
          a(0);
          return;
          a(8);
          return;
          if (paramInt1 == 5) {
            break;
          }
          g();
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.k();
          a(0);
          return;
          if (paramInt1 != 6)
          {
            g();
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.f();
            a(0);
          }
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.b(true);
          return;
          if ((paramInt1 == 6) || (paramInt1 == paramInt2)) {
            break;
          }
          g();
          a(0);
          return;
        }
      }
      label201:
      a(0);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.m();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.b(true);
    }
    else
    {
      a(0);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.m();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.c(false);
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a().a(paramInt1, paramInt2, paramBoolean);
    if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle != null))
    {
      Bundle localBundle = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getBundle(FaceLayer.jdField_a_of_type_JavaLangString);
      if (localBundle != null) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a().a(localBundle);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a().a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getBundle("DynamicFaceLayer"));
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a() != null) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a().a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getBundle(TextLayer.jdField_a_of_type_JavaLangString));
      }
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout;
    if (localObject1 == null)
    {
      SLog.d("Q.qqstory.publish.edit.StoryDoodle", "editVideoPrePublish but doodle layout is null");
      return;
    }
    if (localObject1 != null) {
      ((DoodleLayout)localObject1).jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView.c();
    }
    paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoDoodleDescription = a().a(paramInt);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a().setWordId(a().a());
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a().setStickerId(a().b());
    ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).setEditStickerIds(a().f());
    ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).setEditTextIds(a().e());
    AEBaseReportParam.a().k(a().c());
    AEBaseReportParam.a().j(a().d());
    paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.mMosaicMask = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a(paramInt);
    paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.mMosaicSize = 16;
    if (a().b(paramInt).size() > 0)
    {
      localObject1 = (PasterDataManager)QIMManager.a(4);
      paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoLocationDescription = ((PasterDataManager)localObject1).a();
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.d()) {
      if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoLongitude = ((EditLocalVideoSource)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.longitude;
        paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoLatitude = ((EditLocalVideoSource)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.latitude;
      }
      else if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource instanceof EditLocalPhotoSource))
      {
        paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoLongitude = ((EditLocalPhotoSource)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.longitude;
        paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoLatitude = ((EditLocalPhotoSource)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.latitude;
      }
    }
    if (a().b(paramInt)) {
      VideoEditReport.a("0X80076C0");
    }
    if (a().a(paramInt)) {
      VideoEditReport.a("0X80076C4");
    }
    int i;
    if ((!(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource instanceof EditTakePhotoSource)) && (!(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource instanceof EditLocalPhotoSource))) {
      i = 0;
    } else {
      i = 1;
    }
    Object localObject3 = a().a(paramInt);
    String str1 = "";
    Object localObject2 = "1";
    Object localObject4;
    int j;
    if ((localObject3 != null) && (localObject3.length == 2))
    {
      if (localObject3[0] > 0)
      {
        localObject4 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager;
        j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b();
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c()) {
          localObject1 = "2";
        } else {
          localObject1 = "1";
        }
        ((EditVideoPartManager)localObject4).a("pub_graffiti", j, 0, new String[] { "1", "", localObject1 });
        VideoEditReport.a("0X80076E0", VideoEditReport.jdField_b_of_type_Int);
        VideoEditReport.b("0X80075EA", VideoEditReport.jdField_a_of_type_Int);
        paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("1");
        paramGenerateContext.jdField_a_of_type_ComTencentMobileqqTribeDataTribeVideoPublishParams.hasGraffiti = true;
      }
      else if ((i != 0) && (GeneratePicArgs.a(0)))
      {
        VideoEditReport.b("0X80075EA", VideoEditReport.jdField_a_of_type_Int);
      }
      if (localObject3[1] > 0)
      {
        localObject4 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager;
        j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b();
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c()) {
          localObject1 = "2";
        } else {
          localObject1 = "1";
        }
        ((EditVideoPartManager)localObject4).a("pub_mosaics", j, 0, new String[] { "1", "", localObject1 });
        VideoEditReport.a("0X80076E1");
        VideoEditReport.b("0X80075EB");
        paramGenerateContext.jdField_b_of_type_Boolean = true;
        if (localObject3[0] == 0) {
          paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("1");
        }
      }
      else if ((i != 0) && (GeneratePicArgs.a(1)))
      {
        VideoEditReport.b("0X80075EB");
      }
    }
    localObject3 = a().b(paramInt);
    if ((localObject3 != null) && (localObject3.length == 2))
    {
      Object localObject5 = a().a(paramInt);
      localObject1 = a().b(paramInt);
      localObject4 = new StringBuilder();
      localObject5 = ((Map)localObject5).entrySet().iterator();
      Object localObject6;
      Object localObject7;
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (Map.Entry)((Iterator)localObject5).next();
        localObject7 = (List)((Map.Entry)localObject6).getValue();
        if ((localObject7 != null) && (((List)localObject7).size() > 0))
        {
          localObject6 = (String)((Map.Entry)localObject6).getKey();
          localObject7 = ((List)localObject7).iterator();
          while (((Iterator)localObject7).hasNext())
          {
            String str2 = (String)((Iterator)localObject7).next();
            ((StringBuilder)localObject4).append((String)localObject6);
            ((StringBuilder)localObject4).append(':');
            ((StringBuilder)localObject4).append(str2);
            ((StringBuilder)localObject4).append(',');
          }
        }
      }
      if (((StringBuilder)localObject4).length() > 0) {
        ((StringBuilder)localObject4).deleteCharAt(((StringBuilder)localObject4).length() - 1);
      }
      SLog.a("Q.qqstory.publish.edit.StoryDoodle", "faceReportString = %s", localObject4);
      localObject5 = new StringBuilder();
      if (((List)localObject1).size() > 0)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ((StringBuilder)localObject5).append(((FaceLayer.FaceItem)((Iterator)localObject1).next()).e);
          ((StringBuilder)localObject5).append(',');
        }
        ((StringBuilder)localObject5).deleteCharAt(((StringBuilder)localObject5).length() - 1);
      }
      SLog.a("Q.qqstory.publish.edit.StoryDoodle", "poiReportString = %s", localObject5);
      if (localObject3[0] > 0)
      {
        localObject6 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager;
        j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b();
        int k = localObject3[0];
        localObject7 = ((StringBuilder)localObject4).toString();
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c()) {
          localObject1 = "2";
        } else {
          localObject1 = "1";
        }
        ((EditVideoPartManager)localObject6).a("pub_face", j, 0, new String[] { String.valueOf(k), localObject7, localObject1 });
        VideoEditReport.a("0X80076E3", VideoEditReport.jdField_b_of_type_Int);
        VideoEditReport.b("0X80075ED", VideoEditReport.jdField_a_of_type_Int);
        paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("4");
        paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = ((StringBuilder)localObject4).toString();
      }
      else if ((i != 0) && (GeneratePicArgs.a(2)))
      {
        VideoEditReport.b("0X80075ED", VideoEditReport.jdField_a_of_type_Int);
      }
      if (localObject3[1] > 0)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a("pub_poi", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(), 0, new String[] { String.valueOf(localObject3[1]), ((StringBuilder)localObject5).toString() });
        VideoEditReport.a("0X80076E4");
        VideoEditReport.b("0X80075EE");
        if (localObject3[0] > 0)
        {
          localObject1 = paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6);
          ((StringBuilder)localObject3).append(",");
          ((StringBuilder)localObject3).append(((StringBuilder)localObject5).toString());
          ((LpReportInfo_pf00064)localObject1).reserves6 = ((StringBuilder)localObject3).toString();
        }
        else
        {
          paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("4");
          paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = ((StringBuilder)localObject5).toString();
        }
      }
      else if ((i != 0) && (GeneratePicArgs.a(3)))
      {
        VideoEditReport.b("0X80075EE");
      }
    }
    localObject3 = a().a(paramInt);
    if ((TextUtils.isEmpty((CharSequence)localObject3) ^ true))
    {
      localObject4 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager;
      i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b();
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c()) {
        localObject1 = "2";
      }
      ((EditVideoPartManager)localObject4).a("pub_text", i, 0, new String[] { "1", localObject3, localObject1 });
      VideoEditReport.a("0X80076E2", VideoEditReport.jdField_b_of_type_Int);
      VideoEditReport.b("0X80075EC", VideoEditReport.jdField_a_of_type_Int);
      paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("3");
      paramGenerateContext.jdField_a_of_type_ComTencentMobileqqTribeDataTribeVideoPublishParams.hasText = true;
    }
    else if ((i != 0) && (GeneratePicArgs.a(4)))
    {
      VideoEditReport.b("0X80075EC", VideoEditReport.jdField_a_of_type_Int);
    }
    localObject3 = a().a(paramInt);
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      localObject1 = "";
      paramInt = 0;
      while (paramInt < ((List)localObject3).size())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append((String)((List)localObject3).get(paramInt));
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject1 = localObject2;
        if (paramInt != ((List)localObject3).size() - 1)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(",");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        paramInt += 1;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a("person_gra", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(), 0, new String[] { localObject1 });
    }
    localObject2 = CaptureContext.a().getCurrentAccountUin();
    localObject1 = str1;
    if (InformationFacePackage.jdField_b_of_type_Boolean) {
      localObject1 = paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoLocationDescription;
    }
    ShortVideoUtils.setRecentPOI((String)localObject2, (String)localObject1);
    if (((a().a() != null) && (a().a().jdField_a_of_type_JavaUtilList != null) && (a().a().jdField_a_of_type_JavaUtilList.size() > 0)) || ((a().a() != null) && (a().a().jdField_a_of_type_JavaUtilList != null) && (a().a().jdField_a_of_type_JavaUtilList.size() > 0))) {
      paramGenerateContext.jdField_a_of_type_ComTencentMobileqqTribeDataTribeVideoPublishParams.hasFace = true;
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    DoodleLayout localDoodleLayout = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout;
    if (localDoodleLayout != null) {
      localDoodleLayout.a(paramBitmap);
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    EditVideoPlayerExport localEditVideoPlayerExport = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
    if (localEditVideoPlayerExport != null) {
      localEditVideoPlayerExport.a(paramBitmap, paramBoolean);
    }
  }
  
  public void a(@NonNull Matrix paramMatrix)
  {
    DoodleView localDoodleView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView;
    if (localDoodleView != null) {
      localDoodleView.setExtraTransform(paramMatrix);
    }
  }
  
  public void a(@Nullable RectF paramRectF)
  {
    DoodleView localDoodleView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView;
    if (localDoodleView != null) {
      localDoodleView.setContentBounds(paramRectF);
    }
  }
  
  public void a(LocationFacePackage.Item paramItem)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c()) {
      paramItem = "2";
    } else {
      paramItem = "1";
    }
    StoryReportor.a("video_edit", "add_place", 0, 0, new String[] { paramItem, "", "0", "" });
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a())
    {
      this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      VideoSourceHelper.nativeSetMosaic(16, this.jdField_a_of_type_ArrayOfByte);
      EditVideoPlayerExport localEditVideoPlayerExport = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
      if (localEditVideoPlayerExport != null) {
        localEditVideoPlayerExport.a(16, paramArrayOfByte);
      }
    }
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewEditContainer;
    if ((localObject != null) && (((ProviderViewEditContainer)localObject).a())) {
      return true;
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout;
    if ((localObject != null) && (((DoodleLayout)localObject).d()))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a(7, null);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.b(false);
      return true;
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout;
    if ((localObject != null) && (((DoodleLayout)localObject).getVisibility() == 0))
    {
      int i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.c();
      if (i != 10)
      {
        if (i != 11) {}
        switch (i)
        {
        default: 
          return false;
        case 1: 
        case 2: 
        case 3: 
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
          return true;
        case 0: 
          return false;
        case 6: 
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.p();
        }
      }
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    DoodleLayout localDoodleLayout = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout;
    return (localDoodleLayout == null) || (localDoodleLayout.c(paramInt));
  }
  
  protected boolean a(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 11)
    {
      if (i != 13) {
        return super.a(paramMessage);
      }
      paramMessage = (Long[])paramMessage.obj;
      DoodleLayout localDoodleLayout = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout;
      if (localDoodleLayout != null) {
        localDoodleLayout.setTimeStamp(paramMessage[0].longValue(), false);
      }
      return true;
    }
    this.jdField_a_of_type_Long = ((Long)paramMessage.obj).longValue();
    return true;
  }
  
  public Bitmap b()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a();
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean) {
      a().d();
    }
  }
  
  public void b(int paramInt, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStateChanged : ");
    localStringBuilder.append(paramInt);
    SLog.b("Q.qqstory.publish.edit.StoryDoodle", localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout != null)
    {
      if (this.c) {
        return;
      }
      if (paramInt != 0) {
        switch (paramInt)
        {
        default: 
          return;
        case 12: 
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(26);
          return;
        case 9: 
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(25, paramObject);
          return;
        case 8: 
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(23, paramObject);
          return;
        case 6: 
        case 11: 
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(5);
          return;
        case 5: 
        case 10: 
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(5, paramObject);
          return;
        case 4: 
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(6);
          return;
        case 3: 
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(2, paramObject);
          return;
        case 2: 
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(4, paramObject);
          return;
        }
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c();
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.b())
    {
      NativeGifImage.resumeAll();
      ApngImage.playByTag(13);
      return;
    }
    NativeGifImage.pauseAll();
    ApngImage.pauseByTag(13);
  }
  
  public void e()
  {
    this.c = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    DoodleLayoutConnector.a().a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.h());
  }
  
  public boolean e_()
  {
    if (System.currentTimeMillis() < this.jdField_a_of_type_Long) {
      return false;
    }
    if ((EditVideoPartManager.a(this.jdField_b_of_type_Int, 1)) && (TextUtils.isEmpty(a().a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a()))))
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.f == 12) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
      }
      return true;
    }
    return false;
  }
  
  public boolean f_()
  {
    DoodleLayout localDoodleLayout = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout;
    return (localDoodleLayout == null) || (localDoodleLayout.b());
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout == null)
    {
      SLog.b("Q.qqstory.publish.edit.StoryDoodle", "makeSureInitLayout");
      Object localObject = this.jdField_a_of_type_AndroidViewViewStub.getParent();
      if ((localObject != null) && ((localObject instanceof ViewGroup))) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout = ((DoodleLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());
      } else {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout = ((DoodleLayout)a(2064122115));
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView = ((DoodleView)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.findViewById(2131365800));
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.f == AECameraEntry.c.a()) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_b_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      if (!EditVideoPartManager.a(this.jdField_b_of_type_Int, 1)) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.o();
      }
      this.jdField_b_of_type_Boolean = true;
      h();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.c();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.setupPersonality();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(720, 1280);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.setMosaicSize(16);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.setMosaicStandardSize(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource.a(), this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource.b());
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.setDoodleEventListener(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.setDoodleBtnOperationHelper(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.setEditVideoParams(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.setEditVideoDoodle(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.t();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a(b());
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle != null)
      {
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getBundle(FaceLayer.jdField_a_of_type_JavaLangString) != null) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getBundle(FaceLayer.jdField_a_of_type_JavaLangString).putBoolean("edit_type_photo", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c());
        }
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a().a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getBundle(FaceLayer.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a().a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getBundle("DynamicFaceLayer"));
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a() != null)
        {
          if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getBundle(TextLayer.jdField_a_of_type_JavaLangString) != null) {
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getBundle(TextLayer.jdField_a_of_type_JavaLangString).putBoolean("edit_type_photo", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c());
          }
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a().a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getBundle(TextLayer.jdField_a_of_type_JavaLangString));
        }
      }
      DoodleLayoutConnector.a().a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.h(), this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout);
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView;
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewEditContainer == null)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewEditContainer = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditProviderPart.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewEditContainer;
        ProviderViewEditContainer localProviderViewEditContainer = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewEditContainer;
        if (localProviderViewEditContainer != null) {
          localProviderViewEditContainer.setLiuHaiParentView(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout);
        }
        if ((localObject != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewEditContainer != null))
        {
          if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource instanceof EditLocalVideoSource)) {
            int i = ((EditLocalVideoSource)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource).jdField_a_of_type_Int;
          }
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewEditContainer.setStickerListener(((DoodleEditView)localObject).a());
          ((DoodleEditView)localObject).setDoodleEditViewListener(new EditVideoDoodle.1(this));
        }
        a(2064122148).setOnTouchListener(new EditVideoDoodle.2(this));
      }
    }
  }
  
  public void k()
  {
    if (this.d)
    {
      this.d = false;
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b();
  }
  
  public void m()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getRootView().postDelayed(new EditVideoDoodle.7(this), 200L);
  }
  
  public void z_()
  {
    super.z_();
    NativeGifImage.pauseAll();
    ApngImage.pauseByTag(13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle
 * JD-Core Version:    0.7.0.1
 */