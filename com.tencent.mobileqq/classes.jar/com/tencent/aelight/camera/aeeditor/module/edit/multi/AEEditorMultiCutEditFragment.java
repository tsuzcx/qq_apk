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
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavcut.bean.ResInfoModel;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.session.config.SessionConfig;
import com.tencent.tavcut.util.MediaModelUtils;
import com.tencent.tavcut.util.Util;
import com.tencent.tavcut.view.TAVCutVideoView;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.weishi.module.edit.cut.CutExtKt;
import com.tencent.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.weseevideo.camera.mvauto.redo.ResourceModel;
import com.tencent.weseevideo.camera.mvauto.redo.StoreModelConvert;
import com.tencent.weseevideo.camera.mvauto.redo.VideoResourceModelKt;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.VideoTransitionModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class AEEditorMultiCutEditFragment
  extends AEEditorBaseFragment
{
  private int jdField_a_of_type_Int = ScreenUtil.dip2px(73.0F);
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoSetSpeedDialog jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipVideoVideoSetSpeedDialog;
  private MvVideoViewModel jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiViewmodelMvVideoViewModel;
  private VideoParamStrategy jdField_a_of_type_ComTencentAelightCameraAeeditorModuleParamsVideoParamStrategy = ParamFactory.a();
  protected AEEditorQcircleBubbleView a;
  private ReorderContainerView jdField_a_of_type_ComTencentAelightCameraAeeditorViewReorderReorderContainerView;
  private ReorderListener jdField_a_of_type_ComTencentAelightCameraAeeditorViewReorderReorderListener = new AEEditorMultiCutEditFragment.1(this);
  private ScaleTimeBar jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleTimeBar;
  private ScaleAdapter jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter;
  private ScaleScrollLayout jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineScaleScrollLayout;
  protected VideoTrackContainerView a;
  private MoviePlayer jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = null;
  private TAVCutVideoSession jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
  private TAVCutVideoView jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView = null;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new AEEditorMultiCutEditFragment.9(this);
  private ArrayList<AEAlbumMediaBaseModel> jdField_a_of_type_JavaUtilArrayList;
  private List<CutModelKt> jdField_a_of_type_JavaUtilList = Collections.emptyList();
  protected boolean a;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  protected String b;
  private boolean jdField_b_of_type_Boolean = true;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  protected String c;
  private boolean jdField_c_of_type_Boolean = false;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private boolean jdField_d_of_type_Boolean;
  private boolean e = true;
  private boolean f = true;
  private boolean g = false;
  private boolean h = false;
  
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
  
  private long a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(getResources().getDimension(2063990807));
  }
  
  private LifecycleOwner a()
  {
    return (AEEditorActivity)getActivity();
  }
  
  private ViewModelStoreOwner a()
  {
    return (AEEditorActivity)getActivity();
  }
  
  private List<ResInfoModel> a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (AEAlbumMediaBaseModel)localIterator.next();
      if (localObject != null)
      {
        int i;
        if ((localObject instanceof AEAlbumImageModel)) {
          i = 2;
        } else {
          i = 1;
        }
        ResInfoModel localResInfoModel = new ResInfoModel();
        localResInfoModel.setResPath(((AEAlbumMediaBaseModel)localObject).getPath());
        localResInfoModel.setType(i);
        if (i == 2)
        {
          localObject = ((AEAlbumImageModel)localObject).getEditorPicInfo();
          localResInfoModel.setCropConfig(new CropConfig((float)((EditorPicInfo)localObject).x, (float)((EditorPicInfo)localObject).y, (float)Math.min(((EditorPicInfo)localObject).w, 1.0D), (float)((EditorPicInfo)localObject).h));
        }
        localArrayList.add(localResInfoModel);
      }
    }
    return localArrayList;
  }
  
  @RequiresApi(api=16)
  private void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleTimeBar.a(paramLong, 800);
    b(paramLong);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView = ((TAVCutVideoView)paramView.findViewById(2064122672));
    ((ImageView)paramView.findViewById(2064122277)).setOnClickListener(new AEEditorMultiCutEditFragment.10(this));
    ((ImageView)paramView.findViewById(2064122275)).setOnClickListener(new AEEditorMultiCutEditFragment.11(this));
  }
  
  @RequiresApi(api=16)
  private void a(IDragView paramIDragView)
  {
    if (paramIDragView != null)
    {
      if (((View)paramIDragView).getParent() == null) {
        return;
      }
      long l1 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.c();
      long l3 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView.a(paramIDragView);
      long l4 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView.b(paramIDragView);
      if ((!this.g) && (!this.h) && (l3 < l1) && (l4 > l1)) {
        return;
      }
      boolean bool = this.g;
      long l2 = 0L;
      if (bool)
      {
        l1 = a() + l3;
        this.g = false;
        paramIDragView = new StringBuilder();
        paramIDragView.append("起始点变化，滚到view的起始位置. 旧方法计算的时间：");
        paramIDragView.append(l3);
        paramIDragView.append(". 新方法：");
        paramIDragView.append(l1);
        AEQLog.a("AEEditorMultiCutEditFragment", paramIDragView.toString());
      }
      else if (this.h)
      {
        l1 = l4 - a();
        this.h = false;
        paramIDragView = new StringBuilder();
        paramIDragView.append("结束点变化，滚到view的结束位置. 旧方法计算的时间：");
        paramIDragView.append(l4);
        paramIDragView.append(". 新方法:");
        paramIDragView.append(l1);
        AEQLog.a("AEEditorMultiCutEditFragment", paramIDragView.toString());
      }
      else if ((l4 >= 0L) && (l4 <= l1))
      {
        l1 = l4 - a();
        paramIDragView = new StringBuilder();
        paramIDragView.append("滑块在屏幕左边，滚到view的结束位置. 旧方法：");
        paramIDragView.append(l4);
        paramIDragView.append(". 新方法：");
        paramIDragView.append(l1);
        AEQLog.a("AEEditorMultiCutEditFragment", paramIDragView.toString());
      }
      else if ((l3 >= 0L) && (l3 >= l1))
      {
        l1 = a() + l3;
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
        else if (l1 > this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.b())
        {
          l1 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.b();
          paramIDragView = new StringBuilder();
          paramIDragView.append("targetTime大于endValue，设置为endValue：");
          paramIDragView.append(l1);
          AEQLog.a("AEEditorMultiCutEditFragment", paramIDragView.toString());
        }
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleTimeBar.a(l1, 800);
        b(l1);
      }
    }
  }
  
  private void a(ResourceModel paramResourceModel)
  {
    Iterator localIterator = paramResourceModel.getTransitionData().iterator();
    VideoTransitionModel localVideoTransitionModel;
    for (int i = 0; localIterator.hasNext(); i = (int)(i + localVideoTransitionModel.getOverlapTime() / localVideoTransitionModel.getSpeed())) {
      localVideoTransitionModel = (VideoTransitionModel)localIterator.next();
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(paramResourceModel.getAllVideoDuration() - i);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleTimeBar.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter);
  }
  
  private void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
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
    long l = CutExtKt.calculateClipSeek(this.jdField_a_of_type_JavaUtilList, new LinkedList(), paramString);
    if (l >= 0L) {
      a(l);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiViewmodelMvVideoViewModel.a.postValue(ActionFactory.a(paramString, paramLong1, paramLong2, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel()));
    AEBaseDataReporter.a().G();
    AEReportUtils.q();
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
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiViewmodelMvVideoViewModel.a.postValue(ActionFactory.a(localList1, null));
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView.a();
    if (localObject != null)
    {
      if (((CutModelKt)localObject).getResource().getType() == 2)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2064056467);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166295));
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipVideoVideoSetSpeedDialog;
        if ((localObject != null) && (((VideoSetSpeedDialog)localObject).isShowing())) {
          this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipVideoVideoSetSpeedDialog.dismiss();
        }
      }
      else if (this.e)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2064056466);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165327));
      }
      if (this.jdField_a_of_type_JavaUtilList.size() < 2)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166295));
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2064056461);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2064056460);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165327));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166295));
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2064056467);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2064056461);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166295));
  }
  
  private List<MediaClipModel> b()
  {
    return DataProcessor.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  private void b(long paramLong)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiViewmodelMvVideoViewModel.a(CMTime.fromMs(paramLong));
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2064122367));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122332));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122801));
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).getTypeface(getActivity(), "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new AEEditorMultiCutEditFragment.12(this));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2064122204));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(new AEEditorMultiCutEditFragment.13(this));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122291));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2064121927));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122305));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122756));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new AEEditorMultiCutEditFragment.14(this));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2064121928));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122791));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122330));
    this.e = (getArguments().getBoolean("ae_editor_is_light_model", false) ^ true);
    if (this.e) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new AEEditorMultiCutEditFragment.15(this));
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2064122552));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineScaleScrollLayout = ((ScaleScrollLayout)paramView.findViewById(2064122596));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineScaleScrollLayout.setOnClickListener(new AEEditorMultiCutEditFragment.16(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewReorderReorderContainerView = ((ReorderContainerView)paramView.findViewById(2064122545));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewReorderReorderContainerView.a();
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewReorderReorderContainerView.setReorderListener(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewReorderReorderListener);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleTimeBar = ((ScaleTimeBar)paramView.findViewById(2064122640));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleTimeBar.setOnBarMoveListener(new AEEditorMultiCutEditFragment.17(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleTimeBar.setMaxDurationLimit(Config.a);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleTimeBar.setMaxDurationLimitTip(getString(2064515129));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView = ((VideoTrackContainerView)paramView.findViewById(2064122845));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView.setScaleAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView.setMaxDurationLimit(Config.a);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView.setTimeBar(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleTimeBar);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView.setVideoModel(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiViewmodelMvVideoViewModel);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView.setScrollListener(new AEEditorMultiCutEditFragment.18(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView.setOnStartTimeChangedListener(new AEEditorMultiCutEditFragment.19(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView.setSelectedStateListener(new AEEditorMultiCutEditFragment.20(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView.setOnTransitionListener(new AEEditorMultiCutEditFragment.21(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView.setVideoTrackStoreListener(new AEEditorMultiCutEditFragment.22(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView.setItemOnLongClickListener(new AEEditorMultiCutEditFragment.23(this));
    paramView.setOnClickListener(new AEEditorMultiCutEditFragment.24(this));
  }
  
  @RequiresApi(api=17)
  private void b(ResourceModel paramResourceModel)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView.a(paramResourceModel.getData());
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView.a(paramResourceModel.getTransitionData(), paramResourceModel.getTransitionPosition());
    if (paramResourceModel.getSelectUuid() != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView.a(paramResourceModel.getSelectUuid(), paramResourceModel.getFlashing());
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewReorderReorderContainerView.a(paramResourceModel.getData());
  }
  
  private void c(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiViewmodelMvVideoViewModel;
    if (localObject != null)
    {
      if (!((MvVideoViewModel)localObject).a()) {
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleTimeBar;
      if (localObject != null) {
        ((ScaleTimeBar)localObject).a(paramLong / 1000L);
      }
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView;
      if (localObject != null) {
        ((VideoTrackContainerView)localObject).c();
      }
    }
  }
  
  private void d()
  {
    MoviePlayer localMoviePlayer = this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer;
    if ((localMoviePlayer != null) && (!localMoviePlayer.isPlaying())) {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.play();
    }
  }
  
  private void e()
  {
    MoviePlayer localMoviePlayer = this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer;
    if ((localMoviePlayer != null) && (localMoviePlayer.isPlaying())) {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.pause();
    }
  }
  
  @RequiresApi(api=16)
  private void f()
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
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().setMediaResourceModel(localMediaResourceModel2);
      a(localMediaResourceModel2.getVideos(), true);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.updateTemplateComposition(true);
      this.jdField_c_of_type_JavaLangString = Util.md5(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().toString());
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter = new ScaleAdapter();
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(ViewUtils.a(30.0F));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.b(ViewUtils.a(20.0F));
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiViewmodelMvVideoViewModel = ((MvVideoViewModel)AEViewModelProviders.a(a()).get(MvVideoViewModel.class));
  }
  
  @RequiresApi(api=16)
  private void i()
  {
    Object localObject1 = getArguments();
    if ((localObject1 != null) && (((Bundle)localObject1).containsKey("ae_album_selected_media_models"))) {
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)((Bundle)localObject1).getSerializable("ae_album_selected_media_models"));
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("passed in media models, size=");
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i;
    if (localArrayList == null) {
      i = 0;
    } else {
      i = localArrayList.size();
    }
    ((StringBuilder)localObject2).append(i);
    AEQLog.a("AEEditorMultiCutEditFragment", ((StringBuilder)localObject2).toString());
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleTimeBar.setScaleAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiViewmodelMvVideoViewModel.a.observe(a(), new AEEditorMultiCutEditFragment.6(this));
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
      a(b(), false);
    }
  }
  
  private void j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer;
    if (localObject != null)
    {
      ((MoviePlayer)localObject).release();
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = null;
    }
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = new MoviePlayer();
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setLoopPlay(true);
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setBackColor(getResources().getColor(2063925253));
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.addPlayerListener(new AEEditorMultiCutEditFragment.7(this));
    localObject = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
    if (localObject != null)
    {
      ((TAVCutVideoSession)localObject).release();
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = null;
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = new TAVCutVideoSession();
    localObject = new SessionConfig();
    ((SessionConfig)localObject).setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    ((SessionConfig)localObject).setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
    ((SessionConfig)localObject).setMaxIntermediateRenderSize(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleParamsVideoParamStrategy.a());
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setSessionConfig((SessionConfig)localObject);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.addPlayer(this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setTAVCutVideoView(this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.initMultiCutSession(getActivity(), a());
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setTemplate(2, "assets://camera/template", true, new String[] { "template.json" });
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiViewmodelMvVideoViewModel;
    if (localObject != null) {
      ((MvVideoViewModel)localObject).a(this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer);
    }
    this.jdField_b_of_type_JavaLangString = Util.md5(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().toString());
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorQcircleBubbleView == null) {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorQcircleBubbleView = new AEEditorQcircleBubbleView(getActivity());
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.post(new AEEditorMultiCutEditFragment.8(this));
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipVideoVideoSetSpeedDialog == null)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipVideoVideoSetSpeedDialog = new VideoSetSpeedDialog(getActivity(), 2131755358);
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipVideoVideoSetSpeedDialog.c(83);
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipVideoVideoSetSpeedDialog.b(DisplayUtil.b(getActivity(), 60.0F));
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipVideoVideoSetSpeedDialog.a(DisplayUtil.b(getActivity(), 42.0F));
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipVideoVideoSetSpeedDialog.a(new AEEditorMultiCutEditFragment.25(this));
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipVideoVideoSetSpeedDialog.show();
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView;
    if (localObject != null)
    {
      localObject = ((VideoTrackContainerView)localObject).a();
      if ((localObject != null) && (((CutModelKt)localObject).getResource() != null)) {
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipVideoVideoSetSpeedDialog.a(((CutModelKt)localObject).getResource().getScaleSpeed());
      }
    }
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
      if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView == null)
      {
        AEQLog.a("AEEditorMultiCutEditFragment", "mVideoTrackContainer == null");
        return;
      }
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramIntent);
      paramInt2 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView.b();
      localObject = DataProcessor.a(paramIntent);
      paramIntent = DataProcessor.b(paramIntent);
      localObject = StoreModelConvert.INSTANCE.convert((List)localObject);
      localObject = ActionFactory.a(paramInt2, this.jdField_a_of_type_JavaUtilList, (List)localObject, paramIntent, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel());
      paramIntent = (Intent)localObject;
      if (MediaModelUtils.getTotalSelectDuration(((ResourceModel)localObject).getMediaClipModel()) >= Config.a)
      {
        paramIntent = StoreModelConvert.INSTANCE.restoreClipTimeRange(((ResourceModel)localObject).getData());
        paramIntent = new ResourceModel(((ResourceModel)localObject).getSelectUuid(), ((ResourceModel)localObject).getFlashing(), paramIntent, ((ResourceModel)localObject).getBackupData(), ((ResourceModel)localObject).getTransitionData(), ((ResourceModel)localObject).getTransitionPosition(), ((ResourceModel)localObject).getSmartCutType());
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiViewmodelMvVideoViewModel.a.setValue(paramIntent);
      long l = 0L;
      paramInt1 = 0;
      while (paramInt1 <= paramInt2)
      {
        l += ((MediaClipModel)paramIntent.getMediaClipModel().get(paramInt1)).getResource().getScaleDuration();
        paramInt1 += 1;
      }
      a(l);
    }
  }
  
  public boolean a()
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_JavaLangString.equals(Util.md5(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().toString())))) {}
    while ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.jdField_c_of_type_JavaLangString.equals(Util.md5(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().toString()))))
    {
      i = 0;
      break;
    }
    int i = 1;
    if (i == 0) {
      return false;
    }
    Object localObject = getActivity();
    localObject = DialogUtil.a((Context)localObject, 230).setTitle(HardCodeUtil.a(2064515178)).setMessage(((Context)localObject).getString(2064515179)).setPositiveButton(((Context)localObject).getString(2064515119), new AEEditorMultiCutEditFragment.5(this)).setNegativeButton(((Context)localObject).getString(2064515117), new AEEditorMultiCutEditFragment.4(this));
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
  
  protected boolean b()
  {
    return AECameraPrefsUtil.a().a("SP_KEY_FIRST_ENTER_VIDEO_CUT", true, 0);
  }
  
  protected void c()
  {
    AECameraPrefsUtil.a().a("SP_KEY_FIRST_ENTER_VIDEO_CUT", false, 0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_c_of_type_Boolean = true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    g();
    h();
    return paramLayoutInflater.inflate(2064318579, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_c_of_type_Boolean = false;
    Object localObject = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
    if (localObject != null) {
      ((TAVCutVideoSession)localObject).release();
    }
    localObject = this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer;
    if (localObject != null)
    {
      ((MoviePlayer)localObject).release();
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = null;
    }
  }
  
  @RequiresApi(api=16)
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (!paramBoolean)
    {
      this.jdField_a_of_type_Boolean = true;
      f();
      if (this.jdField_c_of_type_Boolean) {
        d();
      }
      this.e = (true ^ getArguments().getBoolean("ae_editor_is_light_model", false));
      if (this.e) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new AEEditorMultiCutEditFragment.2(this));
      } else {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new AEEditorMultiCutEditFragment.3(this));
      }
      AEBaseDataReporter.a().D();
      return;
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.onPause();
    e();
  }
  
  public void onPause()
  {
    super.onPause();
    if (!this.jdField_d_of_type_Boolean) {
      e();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.jdField_d_of_type_Boolean)
    {
      if (this.jdField_b_of_type_Boolean) {
        d();
      }
      AEBaseDataReporter.a().D();
      AEReportUtils.m();
    }
  }
  
  @RequiresApi(api=16)
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a(paramView);
    b(paramView);
    i();
    j();
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment
 * JD-Core Version:    0.7.0.1
 */