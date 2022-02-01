package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewStub;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.aelight.camera.ae.AEMaterialViewModel;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.camera.ui.panel.daoju.AEMaterialEnvironment;
import com.tencent.aelight.camera.ae.camera.ui.panel.daoju.AEMaterialRepository;
import com.tencent.aelight.camera.ae.camera.ui.panel.daoju.AENewMaterialPanel;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEMaterialCategory;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.part.VideoStoryBasePart;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBottomPanelPart;", "Lcom/tencent/aelight/camera/ae/part/VideoStoryBasePart;", "Lcom/tencent/mobileqq/shortvideo/common/Observer;", "activity", "Landroid/app/Activity;", "rootView", "Landroid/view/View;", "partManager", "Lcom/tencent/aelight/camera/ae/part/VideoStoryCapturePartManager;", "(Landroid/app/Activity;Landroid/view/View;Lcom/tencent/aelight/camera/ae/part/VideoStoryCapturePartManager;)V", "bottomPanelViewModel", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBottomPanelViewModel;", "daoJuPanel", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/daoju/AENewMaterialPanel;", "mPresetMaterialId", "", "materialViewModel", "Lcom/tencent/aelight/camera/ae/AEMaterialViewModel;", "templateManager", "Lcom/tencent/aelight/camera/ae/data/AEMaterialManager;", "unit", "Lcom/tencent/aelight/camera/ae/AEPituCameraUnit;", "handlePresetMaterial", "", "clearPresetInfo", "", "initDaoJuPanel", "initView", "initViewModel", "notify", "sender", "", "eventId", "", "args", "", "(Ljava/lang/Object;I[Ljava/lang/Object;)V", "observeMaterialEvent", "onActivityResume", "onActivityStop", "onDestroy", "unObserveMaterialEvent", "Companion", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEBottomPanelPart
  extends VideoStoryBasePart
  implements com.tencent.mobileqq.shortvideo.common.Observer
{
  public static final AEBottomPanelPart.Companion a = new AEBottomPanelPart.Companion(null);
  private final AEPituCameraUnit b;
  private final AEBottomPanelViewModel c;
  private final AEMaterialViewModel d;
  private final AEMaterialManager e;
  private AENewMaterialPanel f;
  private String g;
  
  public AEBottomPanelPart(@NotNull Activity paramActivity, @NotNull View paramView, @NotNull VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    paramActivity = this.mPartManager.a(65537, new Object[0]);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "mPartManager.get(VSCaptu….MANAGER_GET_ACTION_UNIT)");
    this.b = ((AEPituCameraUnit)paramActivity);
    paramActivity = AEViewModelProviders.a((ViewModelStoreOwner)this.b).get(AEBottomPanelViewModel.class);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "AEViewModelProviders.of(…nelViewModel::class.java)");
    this.c = ((AEBottomPanelViewModel)paramActivity);
    paramActivity = AEViewModelProviders.a((ViewModelStoreOwner)this.b).get(AEMaterialViewModel.class);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "AEViewModelProviders.of(…ialViewModel::class.java)");
    this.d = ((AEMaterialViewModel)paramActivity);
    paramActivity = AEQIMManager.a().b(1);
    if (paramActivity != null)
    {
      this.e = ((AEMaterialManager)paramActivity);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.aelight.camera.ae.data.AEMaterialManager");
  }
  
  private final void a()
  {
    Object localObject1 = (ViewStub)this.mRootView.findViewById(2063991458);
    if (localObject1 != null) {
      localObject1 = ((ViewStub)localObject1).inflate();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof AENewMaterialPanel)) {
      localObject2 = null;
    }
    this.f = ((AENewMaterialPanel)localObject2);
    localObject1 = this.f;
    if (localObject1 != null) {
      ((AENewMaterialPanel)localObject1).setVisibility(8);
    }
    localObject1 = new AEBottomPanelPart.initDaoJuPanel.environment.1();
    localObject2 = new AEBottomPanelPart.initDaoJuPanel.repository.1(this);
    AENewMaterialPanel localAENewMaterialPanel = this.f;
    if (localAENewMaterialPanel != null) {
      localAENewMaterialPanel.a((AEMaterialRepository)localObject2, (AEMaterialEnvironment)localObject1);
    }
    localObject1 = this.f;
    if (localObject1 != null)
    {
      localObject2 = this.e.c(true);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "templateManager.getMaterialListWithRecent(true)");
      ((AENewMaterialPanel)localObject1).a((List)localObject2);
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    AEQLog.b("AEBottomPanelPart", "start handle preset material");
    Object localObject1 = (CharSequence)this.g;
    int i;
    if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      AEQLog.b("AEBottomPanelPart", "preset material id is null");
      return;
    }
    localObject1 = new Ref.ObjectRef();
    ((Ref.ObjectRef)localObject1).element = ((AEMaterialMetaData)null);
    Object localObject2 = this.e.e().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      AEMaterialCategory localAEMaterialCategory = (AEMaterialCategory)((Iterator)localObject2).next();
      Object localObject3 = localAEMaterialCategory.a;
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "cat.materialList");
      localObject3 = ((List)localObject3).iterator();
      i = 0;
      while (((Iterator)localObject3).hasNext())
      {
        if (Intrinsics.areEqual(((AEMaterialMetaData)((Iterator)localObject3).next()).m, this.g)) {
          break label173;
        }
        i += 1;
      }
      i = -1;
      label173:
      if (i >= 0) {
        ((Ref.ObjectRef)localObject1).element = ((AEMaterialMetaData)localAEMaterialCategory.a.get(i));
      }
    }
    if ((AEMaterialMetaData)((Ref.ObjectRef)localObject1).element != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("find target preset material [");
      ((StringBuilder)localObject2).append(this.g);
      ((StringBuilder)localObject2).append("], choose it");
      AEQLog.b("AEBottomPanelPart", ((StringBuilder)localObject2).toString());
      this.b.a((Runnable)new AEBottomPanelPart.handlePresetMaterial.1(this, (Ref.ObjectRef)localObject1));
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("preset material [");
      ((StringBuilder)localObject2).append(this.g);
      ((StringBuilder)localObject2).append("] is not found");
      AEQLog.b("AEBottomPanelPart", ((StringBuilder)localObject2).toString());
    }
    if (((AEMaterialMetaData)((Ref.ObjectRef)localObject1).element != null) || (paramBoolean)) {
      this.g = ((String)null);
    }
  }
  
  private final void b()
  {
    this.c.a().observe((LifecycleOwner)this.b, (androidx.lifecycle.Observer)new AEBottomPanelPart.initViewModel.1(this));
  }
  
  private final void c()
  {
    AEMaterialManager localAEMaterialManager = this.e;
    com.tencent.mobileqq.shortvideo.common.Observer localObserver = (com.tencent.mobileqq.shortvideo.common.Observer)this;
    localAEMaterialManager.a(localObserver, 116);
    this.e.a(localObserver, 111);
    this.e.a(localObserver, 113);
    this.e.a(localObserver, 1024);
    this.e.a(localObserver, 114);
    this.e.a(localObserver, 115);
    this.e.b(false);
  }
  
  private final void d()
  {
    this.e.a((com.tencent.mobileqq.shortvideo.common.Observer)this);
  }
  
  protected void initView()
  {
    AEQLog.b("AEBottomPanelPart", "init bottom panel part");
    b();
    a();
    Object localObject = this.mActivity;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mActivity");
    localObject = ((Activity)localObject).getIntent();
    if (localObject != null) {
      localObject = ((Intent)localObject).getStringExtra("KEY_CURRENT_SELECT_ID");
    } else {
      localObject = null;
    }
    this.g = ((String)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("present material id = ");
    ((StringBuilder)localObject).append(this.g);
    AEQLog.b("AEBottomPanelPart", ((StringBuilder)localObject).toString());
    c();
  }
  
  public void notify(@Nullable Object paramObject, int paramInt, @NotNull Object... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    ThreadManager.getUIHandler().post((Runnable)new AEBottomPanelPart.notify.1(this, paramInt, paramVarArgs));
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    a(false);
  }
  
  public void onActivityStop()
  {
    super.onActivityStop();
    this.e.h();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    d();
    this.e.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEBottomPanelPart
 * JD-Core Version:    0.7.0.1
 */