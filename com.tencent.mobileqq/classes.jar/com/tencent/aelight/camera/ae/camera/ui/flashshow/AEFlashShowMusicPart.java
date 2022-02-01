package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraUnit;
import com.tencent.aelight.camera.ae.flashshow.FlashShowDtReportHelper;
import com.tencent.aelight.camera.ae.flashshow.view.FlashShowBottomPanel;
import com.tencent.aelight.camera.ae.flashshow.view.FlashShowMusicButton;
import com.tencent.aelight.camera.ae.part.AEVideoStoryStateViewModel;
import com.tencent.aelight.camera.ae.part.VideoStoryBasePart;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.mobileqq.widget.ViewPagerCompat;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.adapter.MusicMenuPagerAdapter;
import com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment;
import com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment.PlayerControlCallback;
import com.tencent.mobileqq.wink.editor.music.viewmodel.AbsWinkMusicPlayerViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicPlayerViewModelFactory;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.Scene;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMusicPart;", "Lcom/tencent/aelight/camera/ae/part/VideoStoryBasePart;", "activity", "Landroid/app/Activity;", "rootView", "Landroid/view/View;", "partManager", "Lcom/tencent/aelight/camera/ae/part/VideoStoryCapturePartManager;", "(Landroid/app/Activity;Landroid/view/View;Lcom/tencent/aelight/camera/ae/part/VideoStoryCapturePartManager;)V", "KEY_ATTRS", "", "getKEY_ATTRS", "()Ljava/lang/String;", "bottomPanelViewModel", "Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowBottomPanelViewModel;", "captureViewModel", "Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowChangeModeViewModel;", "musicAdapter", "Lcom/tencent/mobileqq/wink/editor/music/adapter/MusicMenuPagerAdapter;", "musicBottomPanel", "Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowBottomPanel;", "musicButton", "Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowMusicButton;", "musicPlayerViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/AbsWinkMusicPlayerViewModel;", "musicSourceViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "musicTab", "musicViewModel", "Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMusicViewModel;", "stateViewModel", "Lcom/tencent/aelight/camera/ae/part/AEVideoStoryStateViewModel;", "tongKuanMusicMid", "unit", "Lcom/tencent/aelight/camera/ae/flashshow/AEFlashShowCameraUnit;", "viewPager", "Lcom/tencent/mobileqq/widget/ViewPagerCompat;", "volumeTab", "initView", "", "initViewModel", "reportMusicButtonClick", "updateMusicButtonVisible", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEFlashShowMusicPart
  extends VideoStoryBasePart
{
  private final AEFlashShowCameraUnit a;
  private AEFlashShowBottomPanelViewModel b;
  private AEFlashShowMusicViewModel c;
  private AEFlashShowChangeModeViewModel d;
  private AEVideoStoryStateViewModel e;
  private AbsWinkMusicPlayerViewModel f;
  private MusicSourceViewModel g;
  private MusicMenuPagerAdapter h;
  private String i;
  private FlashShowMusicButton j;
  private FlashShowBottomPanel k;
  private ViewPagerCompat l;
  private View m;
  private View n;
  @NotNull
  private final String o;
  
  public AEFlashShowMusicPart(@NotNull Activity paramActivity, @NotNull View paramView, @NotNull VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    paramActivity = paramVideoStoryCapturePartManager.a(65537, new Object[0]);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "partManager.get(VSCaptur….MANAGER_GET_ACTION_UNIT)");
    this.a = ((AEFlashShowCameraUnit)paramActivity);
    this.o = "key_attrs";
  }
  
  private final void a()
  {
    Object localObject1 = AEViewModelProviders.a((ViewModelStoreOwner)this.a).get(AEFlashShowBottomPanelViewModel.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "AEViewModelProviders.of(…nelViewModel::class.java)");
    this.b = ((AEFlashShowBottomPanelViewModel)localObject1);
    localObject1 = AEViewModelProviders.a((ViewModelStoreOwner)this.a).get(AEFlashShowMusicViewModel.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "AEViewModelProviders.of(…sicViewModel::class.java)");
    this.c = ((AEFlashShowMusicViewModel)localObject1);
    localObject1 = AEViewModelProviders.a((ViewModelStoreOwner)this.a).get(AEFlashShowChangeModeViewModel.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "AEViewModelProviders.of(…odeViewModel::class.java)");
    this.d = ((AEFlashShowChangeModeViewModel)localObject1);
    localObject1 = AEViewModelProviders.a((ViewModelStoreOwner)this.a).get(AEVideoStoryStateViewModel.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "AEViewModelProviders.of(…ateViewModel::class.java)");
    this.e = ((AEVideoStoryStateViewModel)localObject1);
    Object localObject2 = this.a.s();
    localObject1 = localObject2;
    if (!(localObject2 instanceof FragmentActivity)) {
      localObject1 = null;
    }
    localObject1 = (FragmentActivity)localObject1;
    if (localObject1 != null)
    {
      localObject2 = (ViewModelStoreOwner)localObject1;
      Object localObject3 = new ViewModelProvider((ViewModelStoreOwner)localObject2).get(MusicSourceViewModel.class);
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "ViewModelProvider(activi…rceViewModel::class.java)");
      this.g = ((MusicSourceViewModel)localObject3);
      localObject3 = this.mActivity.getSystemService("audio");
      if (localObject3 != null)
      {
        localObject2 = new ViewModelProvider((ViewModelStoreOwner)localObject2, (ViewModelProvider.Factory)new MusicPlayerViewModelFactory((AudioManager)localObject3, Scene.CAMERA)).get(AbsWinkMusicPlayerViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "ViewModelProvider(activi…yerViewModel::class.java)");
        this.f = ((AbsWinkMusicPlayerViewModel)localObject2);
        localObject2 = this.b;
        if (localObject2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
        }
        ((AEFlashShowBottomPanelViewModel)localObject2).f().observe((LifecycleOwner)this.a, (Observer)new AEFlashShowMusicPart.initViewModel.1(this));
        localObject2 = this.b;
        if (localObject2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
        }
        ((AEFlashShowBottomPanelViewModel)localObject2).d().observe((LifecycleOwner)this.a, (Observer)new AEFlashShowMusicPart.initViewModel.2(this));
        localObject2 = this.c;
        if (localObject2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("musicViewModel");
        }
        ((AEFlashShowMusicViewModel)localObject2).a().observe((LifecycleOwner)this.a, (Observer)new AEFlashShowMusicPart.initViewModel.3(this));
        localObject2 = this.d;
        if (localObject2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("captureViewModel");
        }
        ((AEFlashShowChangeModeViewModel)localObject2).a().observe((LifecycleOwner)this.a, (Observer)new AEFlashShowMusicPart.initViewModel.4(this));
        localObject2 = this.e;
        if (localObject2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("stateViewModel");
        }
        ((AEVideoStoryStateViewModel)localObject2).a().observe((LifecycleOwner)this.a, (Observer)new AEFlashShowMusicPart.initViewModel.5(this));
        localObject2 = this.f;
        if (localObject2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("musicPlayerViewModel");
        }
        ((AbsWinkMusicPlayerViewModel)localObject2).a().observe((LifecycleOwner)this.a, (Observer)new AEFlashShowMusicPart.initViewModel.6(this));
        localObject2 = this.g;
        if (localObject2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
        }
        ((MusicSourceViewModel)localObject2).p().observe((LifecycleOwner)this.a, (Observer)new AEFlashShowMusicPart.initViewModel.7(this));
        localObject2 = this.g;
        if (localObject2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
        }
        ((MusicSourceViewModel)localObject2).a().observe((LifecycleOwner)this.a, (Observer)new AEFlashShowMusicPart.initViewModel.8(this));
        localObject1 = ((FragmentActivity)localObject1).getIntent();
        if (localObject1 != null)
        {
          localObject2 = ((Intent)localObject1).getSerializableExtra(this.o);
          localObject1 = localObject2;
          if (!(localObject2 instanceof HashMap)) {
            localObject1 = null;
          }
          localObject1 = (HashMap)localObject1;
          if (localObject1 != null) {
            this.i = ((String)((HashMap)localObject1).get("music"));
          }
        }
        if (!TextUtils.isEmpty((CharSequence)this.i))
        {
          localObject1 = this.g;
          if (localObject1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
          }
          ((MusicSourceViewModel)localObject1).a(true);
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(this.i);
          WinkEditorMusicHelper.a((ArrayList)localObject1, (VSDispatchObserver.onVSRspCallBack)new AEFlashShowMusicPart.initViewModel.9(this));
          localObject1 = this.j;
          if (localObject1 != null) {
            ((FlashShowMusicButton)localObject1).a(false);
          }
        }
        else
        {
          localObject1 = this.g;
          if (localObject1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
          }
          ((MusicSourceViewModel)localObject1).a(CollectionsKt.emptyList(), null);
        }
        localObject1 = this.b;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
        }
        ((AEFlashShowBottomPanelViewModel)localObject1).e().observe((LifecycleOwner)this.a, (Observer)new AEFlashShowMusicPart.initViewModel.10(this));
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.media.AudioManager");
    }
  }
  
  private final void b()
  {
    Object localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
    }
    boolean bool1 = Intrinsics.areEqual((Boolean)((AEFlashShowBottomPanelViewModel)localObject).f().getValue(), Boolean.valueOf(true)) ^ true;
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureViewModel");
    }
    localObject = ((AEFlashShowChangeModeViewModel)localObject).a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "captureViewModel.currentStyleLiveData");
    localObject = (AEFlashCameraCaptureButtonLayout.Style)((MutableLiveData)localObject).getValue();
    AEFlashCameraCaptureButtonLayout.Style localStyle = AEFlashCameraCaptureButtonLayout.Style.VIDEO_STYLE;
    boolean bool2 = false;
    if (localObject != localStyle) {
      bool1 = false;
    }
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("stateViewModel");
    }
    localObject = ((AEVideoStoryStateViewModel)localObject).a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "stateViewModel.buttonsVisibleLiveData");
    if ((true ^ Intrinsics.areEqual((Boolean)((MutableLiveData)localObject).getValue(), Boolean.valueOf(true)))) {
      bool1 = false;
    }
    localObject = this.j;
    if (localObject != null)
    {
      int i1;
      if (bool1) {
        bool1 = bool2;
      } else {
        i1 = 8;
      }
      ((FlashShowMusicButton)localObject).setVisibility(i1);
    }
  }
  
  private final void c()
  {
    FlashShowMusicButton localFlashShowMusicButton = this.j;
    if (localFlashShowMusicButton != null) {
      VideoReport.reportEvent("dt_clck", localFlashShowMusicButton, null);
    }
  }
  
  protected void initView()
  {
    this.j = ((FlashShowMusicButton)this.mRootView.findViewById(2063991099));
    Object localObject1 = this.j;
    if (localObject1 != null) {
      ((FlashShowMusicButton)localObject1).setCloseButtonListener((View.OnClickListener)new AEFlashShowMusicPart.initView.1(this));
    }
    localObject1 = this.j;
    if (localObject1 != null) {
      ((FlashShowMusicButton)localObject1).setOnClickListener((View.OnClickListener)new AEFlashShowMusicPart.initView.2(this));
    }
    localObject1 = this.j;
    if (localObject1 != null)
    {
      VideoReport.setElementId(localObject1, "em_xsj_music_button");
      VideoReport.setElementParams(localObject1, (Map)FlashShowDtReportHelper.a().d());
    }
    localObject1 = this.a.s();
    boolean bool = localObject1 instanceof FragmentActivity;
    Object localObject2 = null;
    if (!bool) {
      localObject1 = null;
    }
    Object localObject3 = (FragmentActivity)localObject1;
    if (localObject3 != null)
    {
      localObject1 = this.mRootView.findViewById(2063991441);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "mRootView.findViewById(R…w_multi_unit_music_panel)");
      this.k = ((FlashShowBottomPanel)((ViewStub)localObject1).inflate().findViewById(2063990829));
      localObject1 = this.k;
      if (localObject1 != null) {
        ((FlashShowBottomPanel)localObject1).setVisibility(8);
      }
      localObject1 = this.k;
      if (localObject1 != null) {
        localObject1 = (ViewPagerCompat)((FlashShowBottomPanel)localObject1).findViewById(2063990830);
      } else {
        localObject1 = null;
      }
      this.l = ((ViewPagerCompat)localObject1);
      localObject1 = ((FragmentActivity)localObject3).getSupportFragmentManager();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity.supportFragmentManager");
      this.h = new MusicMenuPagerAdapter((FragmentManager)localObject1, Scene.CAMERA);
      localObject1 = this.l;
      if (localObject1 != null)
      {
        localObject3 = this.h;
        if (localObject3 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("musicAdapter");
        }
        ((ViewPagerCompat)localObject1).setAdapter((PagerAdapter)localObject3);
      }
      localObject1 = this.l;
      if (localObject1 != null) {
        ((ViewPagerCompat)localObject1).setScrollable(false);
      }
      localObject1 = this.h;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("musicAdapter");
      }
      if ((((MusicMenuPagerAdapter)localObject1).getItem(0) instanceof MusicSelectFragment))
      {
        localObject1 = this.h;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("musicAdapter");
        }
        localObject1 = ((MusicMenuPagerAdapter)localObject1).getItem(0);
        if (localObject1 != null) {
          ((MusicSelectFragment)localObject1).a((MusicSelectFragment.PlayerControlCallback)new AEFlashShowMusicPart.initView.4(this));
        } else {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment");
        }
      }
      localObject1 = this.k;
      if (localObject1 != null) {
        localObject1 = ((FlashShowBottomPanel)localObject1).findViewById(2063990828);
      } else {
        localObject1 = null;
      }
      this.m = ((View)localObject1);
      localObject1 = this.m;
      if (localObject1 != null) {
        ((View)localObject1).setSelected(true);
      }
      localObject1 = this.m;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new AEFlashShowMusicPart.initView.5(this));
      }
      localObject3 = this.k;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((FlashShowBottomPanel)localObject3).findViewById(2063990831);
      }
      this.n = ((View)localObject1);
      localObject1 = this.n;
      if (localObject1 != null) {
        ((View)localObject1).setSelected(false);
      }
      localObject1 = this.n;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new AEFlashShowMusicPart.initView.6(this));
      }
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMusicPart
 * JD-Core Version:    0.7.0.1
 */