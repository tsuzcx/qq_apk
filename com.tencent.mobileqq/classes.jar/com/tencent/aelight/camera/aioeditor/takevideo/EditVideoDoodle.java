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
import android.view.ViewGroup.LayoutParams;
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
  public static final String a = QQStoryConstant.g;
  public static String j = "EditVideoDoodle";
  private static int s;
  private static int x;
  protected DoodleLayout b;
  public ProviderViewEditContainer c;
  protected byte[] d;
  public int e = 1;
  protected boolean f;
  protected Handler g = new Handler(Looper.getMainLooper());
  public boolean h = false;
  protected boolean i = false;
  protected Runnable k = new EditVideoDoodle.5(this);
  DoodleEmojiManager.POIPostersRequestCallback l = new EditVideoDoodle.6(this);
  DoodleInfoLoadObserver m = new EditVideoDoodle.10(this);
  private ViewStub n;
  private DoodleView o;
  private final int p;
  private long q = 0L;
  private boolean r = false;
  private ViewTreeObserver.OnGlobalLayoutListener y = new EditVideoDoodle.4(this);
  
  public EditVideoDoodle(@NonNull EditVideoPartManager paramEditVideoPartManager, int paramInt)
  {
    super(paramEditVideoPartManager);
    this.p = paramInt;
  }
  
  private void a(int paramInt1, int paramInt2, View paramView)
  {
    if (paramView == null)
    {
      AEQLog.d("Q.qqstory.publish.edit.StoryDoodle", "doodle main layout null");
      return;
    }
    z();
    float f1 = paramInt1 / paramInt2;
    paramInt1 = s;
    paramInt2 = (int)(paramInt1 / f1);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("adjustDoodleLayoutSize---screenWidth=");
    ((StringBuilder)localObject).append(s);
    ((StringBuilder)localObject).append(", screenHeight=");
    ((StringBuilder)localObject).append(x);
    ((StringBuilder)localObject).append(", viewWidth=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", viewHeight=");
    ((StringBuilder)localObject).append(paramInt2);
    AEQLog.b("Q.qqstory.publish.edit.StoryDoodle", ((StringBuilder)localObject).toString());
    paramInt2 = Math.min(paramInt2, x);
    localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    if (localObject != null)
    {
      ((RelativeLayout.LayoutParams)localObject).width = paramInt1;
      ((RelativeLayout.LayoutParams)localObject).height = paramInt2;
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void a(EditVideoParams.EditSource paramEditSource, int paramInt)
  {
    int i1 = paramEditSource.b();
    int i2 = paramEditSource.c();
    if ((paramInt == 90) || (paramInt == 270))
    {
      i1 = Math.min(paramEditSource.b(), paramEditSource.c());
      i2 = Math.max(paramEditSource.b(), paramEditSource.c());
    }
    if ((this.t.X() != null) && (!this.t.X().getTakePicToVideo())) {
      this.b.a();
    }
    a(i1, i2, this.o);
    a(i1, i2, this.b.w);
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
  
  private void f(int paramInt)
  {
    if (paramInt != 0)
    {
      if ((paramInt != 4) && (paramInt != 8)) {
        return;
      }
      DoodleLayout localDoodleLayout = this.b;
      if ((localDoodleLayout != null) && (localDoodleLayout.getVisibility() != paramInt))
      {
        this.b.setVisibility(paramInt);
        this.b.setDoodleGLViewVisibility(paramInt);
      }
    }
    else
    {
      l();
      if (this.b.getVisibility() != paramInt)
      {
        this.b.setVisibility(paramInt);
        this.b.setDoodleGLViewVisibility(paramInt);
      }
    }
  }
  
  private void y()
  {
    Object localObject;
    if ((this.t.I.e()) && (this.t.I.a == 14))
    {
      if ((this.t.X() != null) && (!this.t.X().isLandTakePicToVideo()) && ((this.t.I.e instanceof EditLocalVideoSource)))
      {
        localObject = (EditLocalVideoSource)this.t.I.e;
        a(this.t.I.e, ((EditLocalVideoSource)localObject).b.rotation);
      }
    }
    else if ((this.t.I.c()) && (this.t.I.a == 2) && ((this.t.I.e instanceof EditTakeVideoSource)))
    {
      localObject = (EditTakeVideoSource)this.t.I.e;
      a(this.t.I.e, ((EditTakeVideoSource)localObject).b.rotation);
    }
  }
  
  private void z()
  {
    if ((x > 0) && (s > 0)) {
      return;
    }
    s = ScreenUtil.SCREEN_WIDTH;
    x = ScreenUtil.getRealHeight(u());
    if (Build.MODEL.equals("Lenovo L78011")) {
      x -= LiuHaiUtils.b(u());
    }
  }
  
  public Bitmap a(int paramInt, boolean paramBoolean)
  {
    DoodleLayout localDoodleLayout = this.b;
    if (localDoodleLayout == null) {
      return null;
    }
    return localDoodleLayout.a(paramInt, paramBoolean);
  }
  
  public void a()
  {
    a(a);
    this.n = ((ViewStub)d(2063991016));
    QQStoryContext.a();
    AppInterface localAppInterface = QQStoryContext.k();
    PtvTemplateManager.a().a(localAppInterface, this.m);
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
      long l1 = SystemClock.elapsedRealtime();
      if (l1 - this.q > 4000L)
      {
        this.g.post(new EditVideoDoodle.9(this));
        this.q = l1;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    this.r = false;
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
          f(0);
          return;
          if (paramInt1 == 5) {
            break;
          }
          l();
          this.b.m();
          f(0);
          return;
          f(8);
          return;
          if (paramInt1 == 5) {
            break;
          }
          l();
          this.b.l();
          f(0);
          return;
          if (paramInt1 != 6)
          {
            l();
            this.b.g();
            f(0);
          }
          this.b.b(true);
          return;
          if ((paramInt1 == 6) || (paramInt1 == paramInt2)) {
            break;
          }
          l();
          f(0);
          return;
        }
      }
      label201:
      f(0);
      this.b.n();
      this.b.b(true);
    }
    else
    {
      f(0);
      this.b.n();
      this.b.c(false);
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    b().a(paramInt1, paramInt2, paramBoolean);
    if ((!paramBoolean) && (this.t.ad != null))
    {
      Bundle localBundle = this.t.ad.getBundle(FaceLayer.a);
      if (localBundle != null) {
        this.b.getFaceLayer().a(localBundle);
      }
      this.b.getDynamicFaceLayer().a(this.t.ad.getBundle("DynamicFaceLayer"));
      if (this.b.getTextLayer() != null) {
        this.b.getTextLayer().a(this.t.ad.getBundle(TextLayer.a));
      }
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    Object localObject1 = this.b;
    if (localObject1 == null)
    {
      SLog.d("Q.qqstory.publish.edit.StoryDoodle", "editVideoPrePublish but doodle layout is null");
      return;
    }
    if (localObject1 != null) {
      ((DoodleLayout)localObject1).w.d();
    }
    paramGenerateContext.d.videoDoodleDescription = b().g(paramInt);
    this.t.X().setWordId(b().getDoodleTextId());
    this.t.X().setStickerId(b().getDoodleStickerId());
    ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).setEditStickerIds(b().getStickerIdsForReport());
    ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).setEditTextIds(b().getTextIdsForReport());
    AEBaseReportParam.a().n(b().getGraffitiTypesForReport());
    AEBaseReportParam.a().m(b().getMarkTypesForReport());
    paramGenerateContext.d.mMosaicMask = this.b.e(paramInt);
    paramGenerateContext.d.mMosaicSize = 16;
    if (b().n(paramInt).size() > 0)
    {
      localObject1 = (PasterDataManager)QIMManager.a(4);
      paramGenerateContext.d.videoLocationDescription = ((PasterDataManager)localObject1).h();
    }
    if (this.t.I.e()) {
      if ((this.t.I.e instanceof EditLocalVideoSource))
      {
        paramGenerateContext.d.videoLongitude = ((EditLocalVideoSource)this.t.I.e).b.longitude;
        paramGenerateContext.d.videoLatitude = ((EditLocalVideoSource)this.t.I.e).b.latitude;
      }
      else if ((this.t.I.e instanceof EditLocalPhotoSource))
      {
        paramGenerateContext.d.videoLongitude = ((EditLocalPhotoSource)this.t.I.e).b.longitude;
        paramGenerateContext.d.videoLatitude = ((EditLocalPhotoSource)this.t.I.e).b.latitude;
      }
    }
    if (b().b(paramInt)) {
      VideoEditReport.a("0X80076C0");
    }
    if (b().a(paramInt)) {
      VideoEditReport.a("0X80076C4");
    }
    int i1;
    if ((!(this.t.I.e instanceof EditTakePhotoSource)) && (!(this.t.I.e instanceof EditLocalPhotoSource))) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    Object localObject3 = b().j(paramInt);
    String str1 = "";
    Object localObject2 = "1";
    Object localObject4;
    int i2;
    if ((localObject3 != null) && (localObject3.length == 2))
    {
      if (localObject3[0] > 0)
      {
        localObject4 = this.t;
        i2 = this.t.n();
        if (this.t.j()) {
          localObject1 = "2";
        } else {
          localObject1 = "1";
        }
        ((EditVideoPartManager)localObject4).a("pub_graffiti", i2, 0, new String[] { "1", "", localObject1 });
        VideoEditReport.a("0X80076E0", VideoEditReport.d);
        VideoEditReport.b("0X80075EA", VideoEditReport.c);
        paramGenerateContext.o.reservesArray.add("1");
        paramGenerateContext.r.hasGraffiti = true;
      }
      else if ((i1 != 0) && (GeneratePicArgs.a(0)))
      {
        VideoEditReport.b("0X80075EA", VideoEditReport.c);
      }
      if (localObject3[1] > 0)
      {
        localObject4 = this.t;
        i2 = this.t.n();
        if (this.t.j()) {
          localObject1 = "2";
        } else {
          localObject1 = "1";
        }
        ((EditVideoPartManager)localObject4).a("pub_mosaics", i2, 0, new String[] { "1", "", localObject1 });
        VideoEditReport.a("0X80076E1");
        VideoEditReport.b("0X80075EB");
        paramGenerateContext.g = true;
        if (localObject3[0] == 0) {
          paramGenerateContext.o.reservesArray.add("1");
        }
      }
      else if ((i1 != 0) && (GeneratePicArgs.a(1)))
      {
        VideoEditReport.b("0X80075EB");
      }
    }
    localObject3 = b().l(paramInt);
    if ((localObject3 != null) && (localObject3.length == 2))
    {
      Object localObject5 = b().m(paramInt);
      localObject1 = b().n(paramInt);
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
          ((StringBuilder)localObject5).append(((FaceLayer.FaceItem)((Iterator)localObject1).next()).o);
          ((StringBuilder)localObject5).append(',');
        }
        ((StringBuilder)localObject5).deleteCharAt(((StringBuilder)localObject5).length() - 1);
      }
      SLog.a("Q.qqstory.publish.edit.StoryDoodle", "poiReportString = %s", localObject5);
      if (localObject3[0] > 0)
      {
        localObject6 = this.t;
        i2 = this.t.n();
        int i3 = localObject3[0];
        localObject7 = ((StringBuilder)localObject4).toString();
        if (this.t.j()) {
          localObject1 = "2";
        } else {
          localObject1 = "1";
        }
        ((EditVideoPartManager)localObject6).a("pub_face", i2, 0, new String[] { String.valueOf(i3), localObject7, localObject1 });
        VideoEditReport.a("0X80076E3", VideoEditReport.d);
        VideoEditReport.b("0X80075ED", VideoEditReport.c);
        paramGenerateContext.o.reservesArray.add("4");
        paramGenerateContext.o.reserves6 = ((StringBuilder)localObject4).toString();
      }
      else if ((i1 != 0) && (GeneratePicArgs.a(2)))
      {
        VideoEditReport.b("0X80075ED", VideoEditReport.c);
      }
      if (localObject3[1] > 0)
      {
        this.t.a("pub_poi", this.t.n(), 0, new String[] { String.valueOf(localObject3[1]), ((StringBuilder)localObject5).toString() });
        VideoEditReport.a("0X80076E4");
        VideoEditReport.b("0X80075EE");
        if (localObject3[0] > 0)
        {
          localObject1 = paramGenerateContext.o;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramGenerateContext.o.reserves6);
          ((StringBuilder)localObject3).append(",");
          ((StringBuilder)localObject3).append(((StringBuilder)localObject5).toString());
          ((LpReportInfo_pf00064)localObject1).reserves6 = ((StringBuilder)localObject3).toString();
        }
        else
        {
          paramGenerateContext.o.reservesArray.add("4");
          paramGenerateContext.o.reserves6 = ((StringBuilder)localObject5).toString();
        }
      }
      else if ((i1 != 0) && (GeneratePicArgs.a(3)))
      {
        VideoEditReport.b("0X80075EE");
      }
    }
    localObject3 = b().g(paramInt);
    if ((TextUtils.isEmpty((CharSequence)localObject3) ^ true))
    {
      localObject4 = this.t;
      i1 = this.t.n();
      localObject1 = localObject2;
      if (this.t.j()) {
        localObject1 = "2";
      }
      ((EditVideoPartManager)localObject4).a("pub_text", i1, 0, new String[] { "1", localObject3, localObject1 });
      VideoEditReport.a("0X80076E2", VideoEditReport.d);
      VideoEditReport.b("0X80075EC", VideoEditReport.c);
      paramGenerateContext.o.reservesArray.add("3");
      paramGenerateContext.r.hasText = true;
    }
    else if ((i1 != 0) && (GeneratePicArgs.a(4)))
    {
      VideoEditReport.b("0X80075EC", VideoEditReport.c);
    }
    localObject3 = b().k(paramInt);
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
      this.t.a("person_gra", this.t.n(), 0, new String[] { localObject1 });
    }
    localObject2 = CaptureContext.a().getCurrentAccountUin();
    localObject1 = str1;
    if (InformationFacePackage.k) {
      localObject1 = paramGenerateContext.d.videoLocationDescription;
    }
    ShortVideoUtils.setRecentPOI((String)localObject2, (String)localObject1);
    if (((b().getFaceLayer() != null) && (b().getFaceLayer().b != null) && (b().getFaceLayer().b.size() > 0)) || ((b().getDynamicFaceLayer() != null) && (b().getDynamicFaceLayer().b != null) && (b().getDynamicFaceLayer().b.size() > 0))) {
      paramGenerateContext.r.hasFace = true;
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    DoodleLayout localDoodleLayout = this.b;
    if (localDoodleLayout != null) {
      localDoodleLayout.a(paramBitmap);
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    EditVideoPlayerExport localEditVideoPlayerExport = (EditVideoPlayerExport)b(EditVideoPlayerExport.class);
    if (localEditVideoPlayerExport != null) {
      localEditVideoPlayerExport.a(paramBitmap, paramBoolean);
    }
  }
  
  public void a(@NonNull Matrix paramMatrix)
  {
    DoodleView localDoodleView = this.o;
    if (localDoodleView != null) {
      localDoodleView.setExtraTransform(paramMatrix);
    }
  }
  
  public void a(@Nullable RectF paramRectF)
  {
    DoodleView localDoodleView = this.o;
    if (localDoodleView != null) {
      localDoodleView.setContentBounds(paramRectF);
    }
  }
  
  public void a(LocationFacePackage.Item paramItem)
  {
    if (this.t.j()) {
      paramItem = "2";
    } else {
      paramItem = "1";
    }
    StoryReportor.a("video_edit", "add_place", 0, 0, new String[] { paramItem, "", "0", "" });
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (!this.t.I.b())
    {
      this.d = paramArrayOfByte;
      VideoSourceHelper.nativeSetMosaic(16, this.d);
      EditVideoPlayerExport localEditVideoPlayerExport = (EditVideoPlayerExport)b(EditVideoPlayerExport.class);
      if (localEditVideoPlayerExport != null) {
        localEditVideoPlayerExport.a(16, paramArrayOfByte);
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    DoodleLayout localDoodleLayout = this.b;
    return (localDoodleLayout == null) || (localDoodleLayout.h(paramInt));
  }
  
  protected boolean a(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 11)
    {
      if (i1 != 13) {
        return super.a(paramMessage);
      }
      paramMessage = (Long[])paramMessage.obj;
      DoodleLayout localDoodleLayout = this.b;
      if (localDoodleLayout != null) {
        localDoodleLayout.setTimeStamp(paramMessage[0].longValue(), false);
      }
      return true;
    }
    this.v = ((Long)paramMessage.obj).longValue();
    return true;
  }
  
  public boolean au_()
  {
    Object localObject = this.c;
    if ((localObject != null) && (((ProviderViewEditContainer)localObject).c())) {
      return true;
    }
    localObject = this.b;
    if ((localObject != null) && (((DoodleLayout)localObject).t()))
    {
      this.b.a(7, null);
      this.b.b(false);
      return true;
    }
    localObject = this.b;
    if ((localObject != null) && (((DoodleLayout)localObject).getVisibility() == 0))
    {
      int i1 = this.b.getCurrentState();
      if (i1 != 10)
      {
        if (i1 != 11) {}
        switch (i1)
        {
        default: 
          return false;
        case 1: 
        case 2: 
        case 3: 
          this.t.d(0);
          return true;
        case 0: 
          return false;
        case 6: 
          this.b.r();
        }
      }
      return true;
    }
    return false;
  }
  
  public void ax_()
  {
    super.ax_();
    NativeGifImage.pauseAll();
    ApngImage.pauseByTag(13);
  }
  
  public int b(int paramInt)
  {
    DoodleLayout localDoodleLayout = this.b;
    if (localDoodleLayout == null) {
      return 0;
    }
    return localDoodleLayout.i(paramInt);
  }
  
  @NonNull
  public DoodleLayout b()
  {
    l();
    return this.b;
  }
  
  public void b(int paramInt, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStateChanged : ");
    localStringBuilder.append(paramInt);
    SLog.b("Q.qqstory.publish.edit.StoryDoodle", localStringBuilder.toString());
    if (this.b != null)
    {
      if (this.i) {
        return;
      }
      if (paramInt != 0) {
        switch (paramInt)
        {
        default: 
          return;
        case 12: 
          this.t.d(26);
          return;
        case 9: 
          this.t.a(25, paramObject);
          return;
        case 8: 
          this.t.a(23, paramObject);
          return;
        case 6: 
        case 11: 
          this.t.d(5);
          return;
        case 5: 
        case 10: 
          this.t.a(5, paramObject);
          return;
        case 4: 
          this.t.d(6);
          return;
        case 3: 
          this.t.a(2, paramObject);
          return;
        case 2: 
          this.t.a(4, paramObject);
          return;
        }
      }
      this.t.d(0);
    }
  }
  
  public JobSegment<GenerateContext, GenerateContext> c(int paramInt)
  {
    if ((!(this.t.I.e instanceof EditTakeVideoSource)) && (!(this.t.I.e instanceof EditLocalVideoSource))) {
      return (JobSegment)StoryApi.a(GenerateDoodleImageSegment.class, new Object[] { this, (EditFilterExport)b(EditFilterExport.class), Integer.valueOf(paramInt) });
    }
    return (JobSegment)StoryApi.a(HWEncodeGenerateDoodleImageSegment.class, new Object[] { this, (EditFilterExport)b(EditFilterExport.class), Integer.valueOf(paramInt) });
  }
  
  public boolean c()
  {
    if (System.currentTimeMillis() < this.v) {
      return false;
    }
    if ((EditVideoPartManager.a(this.p, 1)) && (TextUtils.isEmpty(b().g(this.t.m()))))
    {
      if (this.t.C == 12) {
        this.t.d(0);
      }
      return true;
    }
    return false;
  }
  
  public void d()
  {
    if (this.h) {
      b().d();
    }
  }
  
  public void f()
  {
    super.f();
    if (this.b.p.c())
    {
      NativeGifImage.resumeAll();
      ApngImage.playByTag(13);
      return;
    }
    NativeGifImage.pauseAll();
    ApngImage.pauseByTag(13);
  }
  
  public void g()
  {
    this.i = true;
    this.g.removeCallbacks(this.k);
    DoodleLayoutConnector.a().a(this.t.U());
  }
  
  public boolean h()
  {
    DoodleLayout localDoodleLayout = this.b;
    return (localDoodleLayout == null) || (localDoodleLayout.p());
  }
  
  public Bitmap i()
  {
    DoodleLayout localDoodleLayout = this.b;
    if (localDoodleLayout == null) {
      return null;
    }
    return localDoodleLayout.getDoodleBitmap();
  }
  
  public int k()
  {
    DoodleLayout localDoodleLayout = this.b;
    if (localDoodleLayout == null) {
      return 0;
    }
    return localDoodleLayout.getTotalDoodleCount();
  }
  
  public void l()
  {
    if (this.b == null)
    {
      SLog.b("Q.qqstory.publish.edit.StoryDoodle", "makeSureInitLayout");
      Object localObject = this.n.getParent();
      if ((localObject != null) && ((localObject instanceof ViewGroup))) {
        this.b = ((DoodleLayout)this.n.inflate());
      } else {
        this.b = ((DoodleLayout)d(2063991015));
      }
      this.o = ((DoodleView)this.b.findViewById(2131432057));
      if (this.t.I.h == AECameraEntry.c.a()) {
        this.b.k = true;
      }
      this.b.getViewTreeObserver().addOnGlobalLayoutListener(this.y);
      if (!EditVideoPartManager.a(this.p, 1)) {
        this.b.q();
      }
      this.h = true;
      y();
      this.b.c();
      this.b.setupPersonality();
      this.b.setDoodleBitmapMaxSize(720, 1280);
      this.b.setMosaicSize(16);
      this.b.setMosaicStandardSize(this.t.I.e.b(), this.t.I.e.c());
      this.b.setDoodleEventListener(this);
      this.b.setDoodleBtnOperationHelper(this);
      this.b.setEditVideoParams(this.t.I);
      this.b.setEditVideoDoodle(this);
      this.b.x();
      this.b.a(p());
      if (this.t.ad != null)
      {
        if (this.t.ad.getBundle(FaceLayer.a) != null) {
          this.t.ad.getBundle(FaceLayer.a).putBoolean("edit_type_photo", this.t.j());
        }
        this.b.getFaceLayer().a(this.t.ad.getBundle(FaceLayer.a));
        this.b.getDynamicFaceLayer().a(this.t.ad.getBundle("DynamicFaceLayer"));
        if (this.b.getTextLayer() != null)
        {
          if (this.t.ad.getBundle(TextLayer.a) != null) {
            this.t.ad.getBundle(TextLayer.a).putBoolean("edit_type_photo", this.t.j());
          }
          this.b.getTextLayer().a(this.t.ad.getBundle(TextLayer.a));
        }
      }
      DoodleLayoutConnector.a().a(this.t.U(), this.b);
      localObject = this.b.w;
      if (this.c == null)
      {
        this.c = this.t.N.f;
        ProviderViewEditContainer localProviderViewEditContainer = this.c;
        if (localProviderViewEditContainer != null) {
          localProviderViewEditContainer.setLiuHaiParentView(this.t.Z);
        }
        if ((localObject != null) && (this.c != null))
        {
          if ((this.t.I.e instanceof EditLocalVideoSource)) {
            int i1 = ((EditLocalVideoSource)this.t.I.e).c;
          }
          this.c.setStickerListener(((DoodleEditView)localObject).getFaceSelectedListener());
          ((DoodleEditView)localObject).setDoodleEditViewListener(new EditVideoDoodle.1(this));
        }
        d(2063991038).setOnTouchListener(new EditVideoDoodle.2(this));
      }
    }
  }
  
  public void m()
  {
    if (this.r)
    {
      this.r = false;
      return;
    }
    this.t.d(0);
  }
  
  public void n()
  {
    this.t.b();
  }
  
  public void o()
  {
    this.u.getRootView().postDelayed(new EditVideoDoodle.7(this), 200L);
  }
  
  public boolean p()
  {
    return this.t.j();
  }
  
  public Bitmap q()
  {
    return this.t.H();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle
 * JD-Core Version:    0.7.0.1
 */