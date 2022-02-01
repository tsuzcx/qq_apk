package com.tencent.aelight.camera.aeeditor.module.edit.multi;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.album.data.AEAlbumImageModel;
import com.tencent.aelight.camera.ae.album.data.AEAlbumMediaBaseModel;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.AEEditorActivity;
import com.tencent.aelight.camera.aeeditor.arch.AEEditorBaseFragment;
import com.tencent.aelight.camera.aeeditor.module.clip.image.EditorPicInfo;
import com.tencent.aelight.camera.aeeditor.module.clip.video.VideoSetSpeedDialog;
import com.tencent.aelight.camera.aeeditor.module.edit.multi.action.ActionFactory;
import com.tencent.aelight.camera.aeeditor.module.edit.multi.data.Config;
import com.tencent.aelight.camera.aeeditor.module.edit.multi.data.DataProcessor;
import com.tencent.aelight.camera.aeeditor.module.edit.multi.viewmodel.MvVideoViewModel;
import com.tencent.aelight.camera.aeeditor.module.params.ParamFactory;
import com.tencent.aelight.camera.aeeditor.module.params.VideoParamStrategy;
import com.tencent.aelight.camera.aeeditor.view.AEEditorQcircleBubbleView;
import com.tencent.aelight.camera.aeeditor.view.dragdrop.IDragView;
import com.tencent.aelight.camera.aeeditor.view.reorder.ReorderContainerView;
import com.tencent.aelight.camera.aeeditor.view.reorder.ReorderListener;
import com.tencent.aelight.camera.aeeditor.view.timebar.ScaleTimeBar;
import com.tencent.aelight.camera.aeeditor.view.timebar.scale.ScaleAdapter;
import com.tencent.aelight.camera.aeeditor.view.timeline.ScaleScrollLayout;
import com.tencent.aelight.camera.aeeditor.view.videotrack.VideoTrackContainerView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qcircle.tavcut.bean.CropConfig;
import com.tencent.qcircle.tavcut.bean.ResInfoModel;
import com.tencent.qcircle.tavcut.player.MoviePlayer;
import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;
import com.tencent.qcircle.tavcut.session.config.SessionConfig;
import com.tencent.qcircle.tavcut.util.MediaModelUtils;
import com.tencent.qcircle.tavcut.util.Util;
import com.tencent.qcircle.tavcut.view.TAVCutVideoView;
import com.tencent.qcircle.weishi.module.edit.cut.CutExtKt;
import com.tencent.qcircle.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.qcircle.weseevideo.camera.mvauto.redo.ResourceModel;
import com.tencent.qcircle.weseevideo.camera.mvauto.redo.StoreModelConvert;
import com.tencent.qcircle.weseevideo.camera.mvauto.redo.VideoResourceModelKt;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.effect.VideoTransitionModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class AEEditorMultiCutEditFragment
  extends AEEditorBaseFragment
{
  private TextView A;
  private FrameLayout B;
  private ImageView C;
  private int D = ScreenUtil.dip2px(73.0F);
  private boolean E = true;
  private ScaleScrollLayout F;
  private RelativeLayout G;
  private ScaleTimeBar H;
  private ScaleAdapter I;
  private ReorderContainerView J;
  private List<CutModelKt> K = Collections.emptyList();
  private boolean L = true;
  private boolean M = false;
  private boolean N = false;
  private VideoSetSpeedDialog O;
  private ReorderListener P = new AEEditorMultiCutEditFragment.1(this);
  private final Runnable Q = new AEEditorMultiCutEditFragment.9(this);
  protected String a;
  protected String f;
  protected boolean g;
  protected VideoTrackContainerView h;
  protected AEEditorQcircleBubbleView i;
  private boolean j = true;
  private boolean k = false;
  private boolean l;
  private VideoParamStrategy m = ParamFactory.b();
  private TAVCutVideoSession n;
  private MoviePlayer o = null;
  private TAVCutVideoView p = null;
  private ArrayList<AEAlbumMediaBaseModel> q;
  private MvVideoViewModel r;
  private LinearLayout s;
  private ImageView t;
  private TextView u;
  private RelativeLayout v;
  private ImageView w;
  private TextView x;
  private RelativeLayout y;
  private ImageView z;
  
  private int a(@Nullable List<CutModelKt> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {
      return 6;
    }
    List<CutModelKt> localList = null;
    long l1 = 0L;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (CutModelKt)localIterator.next();
      if ((paramList != null) && (paramList.getResource() != null))
      {
        long l2 = paramList.getResource().getScaleDuration();
        if (localList == null)
        {
          paramList = Long.valueOf(l2);
        }
        else
        {
          paramList = localList;
          if (l2 < localList.longValue()) {
            paramList = Long.valueOf(l2);
          }
        }
        l1 += l2;
        localList = paramList;
      }
    }
    if (localList != null)
    {
      if (l1 < Config.a) {
        return 6;
      }
      if (localList.longValue() >= 5000L) {
        return 9;
      }
      if (localList.longValue() > 2000L) {
        return 8;
      }
    }
    return 6;
  }
  
  @RequiresApi(api=16)
  private void a(long paramLong)
  {
    this.H.a(paramLong, 800);
    b(paramLong);
  }
  
  private void a(View paramView)
  {
    this.p = ((TAVCutVideoView)paramView.findViewById(2063991470));
    ((ImageView)paramView.findViewById(2063991153)).setOnClickListener(new AEEditorMultiCutEditFragment.10(this));
    ((ImageView)paramView.findViewById(2063991151)).setOnClickListener(new AEEditorMultiCutEditFragment.11(this));
  }
  
  @RequiresApi(api=16)
  private void a(IDragView paramIDragView)
  {
    if (paramIDragView != null)
    {
      if (((View)paramIDragView).getParent() == null) {
        return;
      }
      long l1 = this.I.d();
      long l3 = this.h.b(paramIDragView);
      long l4 = this.h.c(paramIDragView);
      if ((!this.M) && (!this.N) && (l3 < l1) && (l4 > l1)) {
        return;
      }
      boolean bool = this.M;
      long l2 = 0L;
      if (bool)
      {
        l1 = s() + l3;
        this.M = false;
        paramIDragView = new StringBuilder();
        paramIDragView.append("起始点变化，滚到view的起始位置. 旧方法计算的时间：");
        paramIDragView.append(l3);
        paramIDragView.append(". 新方法：");
        paramIDragView.append(l1);
        AEQLog.a("AEEditorMultiCutEditFragment", paramIDragView.toString());
      }
      else if (this.N)
      {
        l1 = l4 - s();
        this.N = false;
        paramIDragView = new StringBuilder();
        paramIDragView.append("结束点变化，滚到view的结束位置. 旧方法计算的时间：");
        paramIDragView.append(l4);
        paramIDragView.append(". 新方法:");
        paramIDragView.append(l1);
        AEQLog.a("AEEditorMultiCutEditFragment", paramIDragView.toString());
      }
      else if ((l4 >= 0L) && (l4 <= l1))
      {
        l1 = l4 - s();
        paramIDragView = new StringBuilder();
        paramIDragView.append("滑块在屏幕左边，滚到view的结束位置. 旧方法：");
        paramIDragView.append(l4);
        paramIDragView.append(". 新方法：");
        paramIDragView.append(l1);
        AEQLog.a("AEEditorMultiCutEditFragment", paramIDragView.toString());
      }
      else if ((l3 >= 0L) && (l3 >= l1))
      {
        l1 = s() + l3;
        paramIDragView = new StringBuilder();
        paramIDragView.append("滑块在屏幕右边，滚到view的开始位置. 旧方法：");
        paramIDragView.append(l3);
        paramIDragView.append(". 新方法：");
        paramIDragView.append(l1);
        AEQLog.a("AEEditorMultiCutEditFragment", paramIDragView.toString());
      }
      else
      {
        l1 = 9223372036854775807L;
      }
      if (l1 != 9223372036854775807L)
      {
        if (l1 < 0L)
        {
          AEQLog.a("AEEditorMultiCutEditFragment", "targetTime小于0，设置为0");
          l1 = l2;
        }
        else if (l1 > this.I.c())
        {
          l1 = this.I.c();
          paramIDragView = new StringBuilder();
          paramIDragView.append("targetTime大于endValue，设置为endValue：");
          paramIDragView.append(l1);
          AEQLog.a("AEEditorMultiCutEditFragment", paramIDragView.toString());
        }
        this.H.a(l1, 800);
        b(l1);
      }
    }
  }
  
  private void a(ResourceModel paramResourceModel)
  {
    Iterator localIterator = paramResourceModel.getTransitionData().iterator();
    VideoTransitionModel localVideoTransitionModel;
    for (int i1 = 0; localIterator.hasNext(); i1 = (int)(i1 + localVideoTransitionModel.getOverlapTime() / localVideoTransitionModel.getSpeed())) {
      localVideoTransitionModel = (VideoTransitionModel)localIterator.next();
    }
    this.I.a(paramResourceModel.getAllVideoDuration() - i1);
    this.H.a(this.I);
  }
  
  private void a(String paramString)
  {
    Object localObject = this.q;
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
      localObject = this.q.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((AEAlbumMediaBaseModel)((Iterator)localObject).next()).getOriginPath().equals(paramString)) {
          ((Iterator)localObject).remove();
        }
      }
      return;
    }
    AEQLog.c("AEEditorMultiCutEditFragment", "mediaModels == null || mediaModels.size() == 0");
  }
  
  @RequiresApi(api=16)
  private void a(String paramString, long paramLong1, long paramLong2)
  {
    long l1 = CutExtKt.calculateClipSeek(this.K, new LinkedList(), paramString);
    if (l1 >= 0L) {
      a(l1);
    }
    this.r.a.postValue(ActionFactory.a(paramString, paramLong1, paramLong2, this.K, this.n.getMediaModel()));
    AEBaseDataReporter.a().H();
    AEReportUtils.p();
  }
  
  @RequiresApi(api=16)
  private void a(List<MediaClipModel> paramList, boolean paramBoolean)
  {
    List localList2 = StoreModelConvert.INSTANCE.convert(paramList);
    List localList1 = localList2;
    if (MediaModelUtils.getTotalSelectDuration(paramList) >= Config.a) {
      localList1 = StoreModelConvert.INSTANCE.restoreClipTimeRange(localList2);
    }
    if (paramBoolean) {
      a(0L);
    }
    this.r.a.postValue(ActionFactory.a(localList1, null));
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    Object localObject = this.h.getSelectedVideoClip();
    if (localObject != null)
    {
      if (((CutModelKt)localObject).getResource().getType() == 2)
      {
        this.z.setImageResource(2063925435);
        this.A.setTextColor(getResources().getColor(2131167032));
        localObject = this.O;
        if ((localObject != null) && (((VideoSetSpeedDialog)localObject).isShowing())) {
          this.O.dismiss();
        }
      }
      else if (this.E)
      {
        this.z.setImageResource(2063925434);
        this.A.setTextColor(getResources().getColor(2131165564));
      }
      if (this.K.size() < 2)
      {
        this.x.setTextColor(getResources().getColor(2131167032));
        this.w.setImageResource(2063925429);
        return;
      }
      this.w.setImageResource(2063925428);
      this.x.setTextColor(getResources().getColor(2131165564));
      return;
    }
    this.A.setTextColor(getResources().getColor(2131167032));
    this.z.setImageResource(2063925435);
    this.w.setImageResource(2063925429);
    this.x.setTextColor(getResources().getColor(2131167032));
  }
  
  private void b(long paramLong)
  {
    this.r.a(CMTime.fromMs(paramLong));
  }
  
  private void b(View paramView)
  {
    this.s = ((LinearLayout)paramView.findViewById(2063991241));
    this.t = ((ImageView)paramView.findViewById(2063991214));
    this.u = ((TextView)paramView.findViewById(2063991576));
    this.u.setTypeface(((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).getTypeface(getActivity(), "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"));
    this.t.setOnClickListener(new AEEditorMultiCutEditFragment.12(this));
    this.B = ((FrameLayout)paramView.findViewById(2063991083));
    this.B.setOnClickListener(new AEEditorMultiCutEditFragment.13(this));
    this.C = ((ImageView)paramView.findViewById(2063991169));
    this.v = ((RelativeLayout)paramView.findViewById(2063990861));
    this.w = ((ImageView)paramView.findViewById(2063991184));
    this.x = ((TextView)paramView.findViewById(2063991530));
    this.v.setOnClickListener(new AEEditorMultiCutEditFragment.14(this));
    this.y = ((RelativeLayout)paramView.findViewById(2063990862));
    this.A = ((TextView)paramView.findViewById(2063991566));
    this.z = ((ImageView)paramView.findViewById(2063991212));
    if (this.E) {
      this.y.setOnClickListener(new AEEditorMultiCutEditFragment.15(this));
    }
    this.G = ((RelativeLayout)paramView.findViewById(2063991369));
    this.F = ((ScaleScrollLayout)paramView.findViewById(2063991409));
    this.F.setOnClickListener(new AEEditorMultiCutEditFragment.16(this));
    this.J = ((ReorderContainerView)paramView.findViewById(2063991363));
    this.J.a();
    this.J.setReorderListener(this.P);
    this.H = ((ScaleTimeBar)paramView.findViewById(2063991429));
    this.H.setOnBarMoveListener(new AEEditorMultiCutEditFragment.17(this));
    this.H.setMaxDurationLimit(Config.a);
    this.H.setMaxDurationLimitTip(getString(2064187471));
    this.h = ((VideoTrackContainerView)paramView.findViewById(2063991618));
    this.h.setScaleAdapter(this.I);
    this.h.setMaxDurationLimit(Config.a);
    this.h.setTimeBar(this.H);
    this.h.setVideoModel(this.r);
    this.h.setScrollListener(new AEEditorMultiCutEditFragment.18(this));
    this.h.setOnStartTimeChangedListener(new AEEditorMultiCutEditFragment.19(this));
    this.h.setSelectedStateListener(new AEEditorMultiCutEditFragment.20(this));
    this.h.setOnTransitionListener(new AEEditorMultiCutEditFragment.21(this));
    this.h.setVideoTrackStoreListener(new AEEditorMultiCutEditFragment.22(this));
    this.h.setItemOnLongClickListener(new AEEditorMultiCutEditFragment.23(this));
    paramView.setOnClickListener(new AEEditorMultiCutEditFragment.24(this));
  }
  
  @RequiresApi(api=17)
  private void b(ResourceModel paramResourceModel)
  {
    this.h.a(paramResourceModel.getData());
    this.h.a(paramResourceModel.getTransitionData(), paramResourceModel.getTransitionPosition());
    if (paramResourceModel.getSelectUuid() != null) {
      this.h.a(paramResourceModel.getSelectUuid(), paramResourceModel.getFlashing());
    }
    this.J.a(paramResourceModel.getData());
  }
  
  private void c(long paramLong)
  {
    Object localObject = this.r;
    if (localObject != null)
    {
      if (!((MvVideoViewModel)localObject).a()) {
        return;
      }
      localObject = this.H;
      if (localObject != null) {
        ((ScaleTimeBar)localObject).a(paramLong / 1000L);
      }
      localObject = this.h;
      if (localObject != null) {
        ((VideoTrackContainerView)localObject).e();
      }
    }
  }
  
  private void h()
  {
    MoviePlayer localMoviePlayer = this.o;
    if ((localMoviePlayer != null) && (!localMoviePlayer.isPlaying())) {
      this.o.play();
    }
  }
  
  private void i()
  {
    MoviePlayer localMoviePlayer = this.o;
    if ((localMoviePlayer != null) && (localMoviePlayer.isPlaying())) {
      this.o.pause();
    }
  }
  
  @RequiresApi(api=16)
  private void j()
  {
    MediaResourceModel localMediaResourceModel2;
    try
    {
      MediaResourceModel localMediaResourceModel1 = ((MediaResourceModel)getArguments().getSerializable("resource_model")).deepCopy();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localMediaResourceModel2 = null;
    }
    if (localMediaResourceModel2 != null)
    {
      this.n.getMediaModel().setMediaResourceModel(localMediaResourceModel2);
      a(localMediaResourceModel2.getVideos(), true);
      this.n.updateTemplateComposition(true);
      this.f = Util.md5(this.n.getMediaModel().toString());
    }
  }
  
  private LifecycleOwner k()
  {
    return (AEEditorActivity)getActivity();
  }
  
  private ViewModelStoreOwner l()
  {
    return (AEEditorActivity)getActivity();
  }
  
  private void m()
  {
    this.I = new ScaleAdapter();
    this.I.a(ViewUtils.dip2px(30.0F));
    this.I.b(ViewUtils.dip2px(20.0F));
  }
  
  private void n()
  {
    this.r = ((MvVideoViewModel)AEViewModelProviders.a(l()).get(MvVideoViewModel.class));
  }
  
  @RequiresApi(api=16)
  private void o()
  {
    Object localObject1 = getArguments();
    if ((localObject1 != null) && (((Bundle)localObject1).containsKey("ae_album_selected_media_models"))) {
      this.q = ((ArrayList)((Bundle)localObject1).getSerializable("ae_album_selected_media_models"));
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("passed in media models, size=");
    ArrayList localArrayList = this.q;
    int i1;
    if (localArrayList == null) {
      i1 = 0;
    } else {
      i1 = localArrayList.size();
    }
    ((StringBuilder)localObject2).append(i1);
    AEQLog.a("AEEditorMultiCutEditFragment", ((StringBuilder)localObject2).toString());
    this.H.setScaleAdapter(this.I);
    this.r.a.observe(k(), new AEEditorMultiCutEditFragment.6(this));
    if ((localObject1 != null) && (((Bundle)localObject1).containsKey("resource_model")))
    {
      localObject1 = null;
      try
      {
        localObject2 = ((MediaResourceModel)getArguments().getSerializable("resource_model")).deepCopy();
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if (localObject1 != null) {
        a(((MediaResourceModel)localObject1).getVideos(), true);
      }
    }
    else
    {
      a(u(), false);
    }
  }
  
  private void p()
  {
    Object localObject = this.o;
    if (localObject != null)
    {
      ((MoviePlayer)localObject).release();
      this.o = null;
    }
    this.o = new MoviePlayer();
    this.o.setLoopPlay(true);
    this.o.setBackColor(getResources().getColor(2063794181));
    this.o.addPlayerListener(new AEEditorMultiCutEditFragment.7(this));
    localObject = this.n;
    if (localObject != null)
    {
      ((TAVCutVideoSession)localObject).release();
      this.n = null;
    }
    this.n = new TAVCutVideoSession();
    localObject = new SessionConfig();
    ((SessionConfig)localObject).setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    ((SessionConfig)localObject).setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
    ((SessionConfig)localObject).setMaxIntermediateRenderSize(this.m.a());
    this.n.setSessionConfig((SessionConfig)localObject);
    this.n.addPlayer(this.o);
    this.n.setTAVCutVideoView(this.p);
    this.n.initMultiCutSession(getActivity(), r());
    this.n.setTemplate(2, "assets://camera/template", true, new String[] { "template.json" });
    localObject = this.r;
    if (localObject != null) {
      ((MvVideoViewModel)localObject).a(this.o);
    }
    this.a = Util.md5(this.n.getMediaModel().toString());
  }
  
  private void q()
  {
    if (this.i == null) {
      this.i = new AEEditorQcircleBubbleView(getActivity());
    }
    this.G.post(new AEEditorMultiCutEditFragment.8(this));
  }
  
  private List<ResInfoModel> r()
  {
    if (this.q == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.q.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (AEAlbumMediaBaseModel)localIterator.next();
      if (localObject != null)
      {
        int i1;
        if ((localObject instanceof AEAlbumImageModel)) {
          i1 = 2;
        } else {
          i1 = 1;
        }
        ResInfoModel localResInfoModel = new ResInfoModel();
        localResInfoModel.setResPath(((AEAlbumMediaBaseModel)localObject).getPath());
        localResInfoModel.setType(i1);
        if (i1 == 2)
        {
          localObject = ((AEAlbumImageModel)localObject).getEditorPicInfo();
          localResInfoModel.setCropConfig(new CropConfig((float)((EditorPicInfo)localObject).x, (float)((EditorPicInfo)localObject).y, (float)Math.min(((EditorPicInfo)localObject).w, 1.0D), (float)((EditorPicInfo)localObject).h));
        }
        localArrayList.add(localResInfoModel);
      }
    }
    return localArrayList;
  }
  
  private long s()
  {
    return this.I.b(getResources().getDimension(2063859734));
  }
  
  private void t()
  {
    if (this.O == null)
    {
      this.O = new VideoSetSpeedDialog(getActivity(), 2131952062);
      this.O.c(83);
      this.O.b(DisplayUtil.b(getActivity(), 60.0F));
      this.O.a(DisplayUtil.b(getActivity(), 42.0F));
      this.O.a(new AEEditorMultiCutEditFragment.25(this));
    }
    this.O.show();
    Object localObject = this.h;
    if (localObject != null)
    {
      localObject = ((VideoTrackContainerView)localObject).getSelectedVideoClip();
      if ((localObject != null) && (((CutModelKt)localObject).getResource() != null)) {
        this.O.a(((CutModelKt)localObject).getResource().getScaleSpeed());
      }
    }
  }
  
  private List<MediaClipModel> u()
  {
    return DataProcessor.a(this.q);
  }
  
  public String a()
  {
    return "AEEditorMultiCutFragment";
  }
  
  @RequiresApi(api=16)
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doOnActivityResult---requestCode=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", resultCode=");
    ((StringBuilder)localObject).append(paramInt2);
    AEQLog.b("AEEditorMultiCutEditFragment", ((StringBuilder)localObject).toString());
    if ((paramInt1 == 1024) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getSerializableExtra("ae_album_selected_media_models");
      if (paramIntent == null)
      {
        AEQLog.a("AEEditorMultiCutEditFragment", "serializableExtra == null");
        return;
      }
      paramIntent = (ArrayList)paramIntent;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ADDITIONAL passed in media models, size=");
      ((StringBuilder)localObject).append(paramIntent.size());
      AEQLog.a("AEEditorMultiCutEditFragment", ((StringBuilder)localObject).toString());
      if (paramIntent.size() == 0)
      {
        AEQLog.a("AEEditorMultiCutEditFragment", "addMediaModels.size() == 0");
        return;
      }
      if (this.h == null)
      {
        AEQLog.a("AEEditorMultiCutEditFragment", "mVideoTrackContainer == null");
        return;
      }
      this.q.addAll(paramIntent);
      paramInt2 = this.h.getCurrentClipIndex();
      localObject = DataProcessor.a(paramIntent);
      paramIntent = DataProcessor.b(paramIntent);
      localObject = StoreModelConvert.INSTANCE.convert((List)localObject);
      localObject = ActionFactory.a(paramInt2, this.K, (List)localObject, paramIntent, this.n.getMediaModel());
      paramIntent = (Intent)localObject;
      if (MediaModelUtils.getTotalSelectDuration(((ResourceModel)localObject).getMediaClipModel()) >= Config.a)
      {
        paramIntent = StoreModelConvert.INSTANCE.restoreClipTimeRange(((ResourceModel)localObject).getData());
        paramIntent = new ResourceModel(((ResourceModel)localObject).getSelectUuid(), ((ResourceModel)localObject).getFlashing(), paramIntent, ((ResourceModel)localObject).getBackupData(), ((ResourceModel)localObject).getTransitionData(), ((ResourceModel)localObject).getTransitionPosition(), ((ResourceModel)localObject).getSmartCutType());
      }
      this.r.a.setValue(paramIntent);
      long l1 = 0L;
      paramInt1 = 0;
      while (paramInt1 <= paramInt2)
      {
        l1 += ((MediaClipModel)paramIntent.getMediaClipModel().get(paramInt1)).getResource().getScaleDuration();
        paramInt1 += 1;
      }
      a(l1);
    }
  }
  
  public boolean c()
  {
    if ((!this.g) && (this.a.equals(Util.md5(this.n.getMediaModel().toString())))) {}
    while ((this.g) && (!TextUtils.isEmpty(this.f)) && (this.f.equals(Util.md5(this.n.getMediaModel().toString()))))
    {
      i1 = 0;
      break;
    }
    int i1 = 1;
    if (i1 == 0) {
      return false;
    }
    Object localObject = getActivity();
    localObject = DialogUtil.a((Context)localObject, 230).setTitle(HardCodeUtil.a(2064187524)).setMessage(((Context)localObject).getString(2064187525)).setPositiveButton(((Context)localObject).getString(2064187461), new AEEditorMultiCutEditFragment.5(this)).setNegativeButton(((Context)localObject).getString(2064187459), new AEEditorMultiCutEditFragment.4(this));
    if (localObject != null) {
      try
      {
        if (!((QQCustomDialog)localObject).isShowing())
        {
          ((QQCustomDialog)localObject).show();
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    return true;
  }
  
  protected void f()
  {
    AECameraPrefsUtil.a().a("SP_KEY_FIRST_ENTER_VIDEO_CUT", false, 0);
  }
  
  protected boolean g()
  {
    return AECameraPrefsUtil.a().b("SP_KEY_FIRST_ENTER_VIDEO_CUT", true, 0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.k = true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    m();
    n();
    return paramLayoutInflater.inflate(2064056451, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.k = false;
    Object localObject = this.n;
    if (localObject != null) {
      ((TAVCutVideoSession)localObject).release();
    }
    localObject = this.o;
    if (localObject != null)
    {
      ((MoviePlayer)localObject).release();
      this.o = null;
    }
  }
  
  @RequiresApi(api=16)
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    this.l = paramBoolean;
    if (!paramBoolean)
    {
      this.g = true;
      j();
      if (this.k) {
        h();
      }
      if (this.E) {
        this.y.setOnClickListener(new AEEditorMultiCutEditFragment.2(this));
      } else {
        this.y.setOnClickListener(new AEEditorMultiCutEditFragment.3(this));
      }
      AEBaseDataReporter.a().E();
      return;
    }
    this.n.onPause();
    i();
  }
  
  public void onPause()
  {
    super.onPause();
    if (!this.l) {
      i();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.l)
    {
      if (this.j) {
        h();
      }
      AEBaseDataReporter.a().E();
      AEReportUtils.l();
    }
  }
  
  @RequiresApi(api=16)
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a(paramView);
    b(paramView);
    o();
    p();
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment
 * JD-Core Version:    0.7.0.1
 */