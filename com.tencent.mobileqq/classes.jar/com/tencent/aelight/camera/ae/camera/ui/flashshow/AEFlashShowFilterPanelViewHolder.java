package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.camera.ui.BaseViewStubHolder;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.filter.FilterMaterialPanelContentAdapter;
import com.tencent.mobileqq.wink.editor.filter.FilterMetaMaterialKt;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask.MaterialStatusCallback;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask.Status;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTaskHelper;
import com.tencent.mobileqq.wink.view.StartPointSeekBar;
import com.tencent.mobileqq.wink.view.StartPointSeekBar.OnSeekBarChangeListener;
import com.tencent.mobileqq.wink.view.WinkMaterialPanel;
import java.io.File;
import java.util.List;
import mqq.os.MqqHandler;

public class AEFlashShowFilterPanelViewHolder
  extends BaseViewStubHolder
  implements ApplyMaterialTask, StartPointSeekBar.OnSeekBarChangeListener
{
  private WinkMaterialPanel a;
  private FilterMaterialPanelContentAdapter b;
  private StartPointSeekBar c;
  private TextView d;
  private ViewGroup e;
  private LinearLayout f;
  private Handler g = new Handler();
  private VideoStoryCapturePartManager h;
  private AEFlashSHOWFilterViewModel i;
  
  public AEFlashShowFilterPanelViewHolder(ViewStub paramViewStub)
  {
    super(paramViewStub);
  }
  
  private String a(@NonNull MetaMaterial paramMetaMaterial)
  {
    String str = FilterMetaMaterialKt.k(paramMetaMaterial);
    Object localObject = str;
    if (TextUtils.isEmpty(str))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(WinkEditorResourceManager.c().a(paramMetaMaterial));
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(FilterMetaMaterialKt.j(paramMetaMaterial));
      ((StringBuilder)localObject).append(".png");
      localObject = ((StringBuilder)localObject).toString();
      FilterMetaMaterialKt.c(paramMetaMaterial, (String)localObject);
    }
    return localObject;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((paramInt2 <= 100) && (paramInt2 >= 0))
    {
      this.c.setAbsoluteMinMaxValue(0.0D, 100.0D);
      this.c.setDefaultValue(paramInt1);
      StartPointSeekBar localStartPointSeekBar = this.c;
      boolean bool;
      if ((paramInt1 < 100) && (paramInt1 > 0)) {
        bool = true;
      } else {
        bool = false;
      }
      localStartPointSeekBar.setSectionEnable(bool);
      this.c.setProgress(paramInt2);
      StartPointSeekBar.a(this.c, paramInt2, this.d);
    }
  }
  
  private void a(@NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    String str = paramMetaMaterial.id;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("lutId = ");
    ((StringBuilder)localObject).append(str);
    ApplyMaterialTaskHelper.a("downloadLutResource", paramMetaMaterial, ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(str))
    {
      FilterMetaMaterialKt.a(paramMetaMaterial, true);
      paramMaterialStatusCallback.onStatusChanged(ApplyMaterialTask.Status.SUCCEEDED, 100);
      return;
    }
    localObject = a(paramMetaMaterial);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lutPath = ");
    localStringBuilder.append((String)localObject);
    ApplyMaterialTaskHelper.a("downloadLutResource", paramMetaMaterial, localStringBuilder.toString());
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (new File((String)localObject).exists()))
    {
      FilterMetaMaterialKt.a(paramMetaMaterial, true);
      paramMaterialStatusCallback.onStatusChanged(ApplyMaterialTask.Status.SUCCEEDED, 100);
      return;
    }
    WinkEditorResourceManager.c().a(str, new AEFlashShowFilterPanelViewHolder.6(this, paramMetaMaterial, paramMaterialStatusCallback));
  }
  
  private void a(List<MetaCategory> paramList, @NonNull List<MetaMaterial> paramList1)
  {
    this.g.post(new AEFlashShowFilterPanelViewHolder.5(this, paramList, paramList1));
  }
  
  private void b(View paramView)
  {
    this.e = ((ViewGroup)paramView.findViewById(2131445497));
    this.d = ((TextView)paramView.findViewById(2131448214));
    this.c = ((StartPointSeekBar)paramView.findViewById(2131446268));
    this.c.setOnSeekBarChangeListener(this);
  }
  
  public void a(int paramInt, @NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    ApplyMaterialTaskHelper.a(paramMaterialStatusCallback);
  }
  
  protected void a(View paramView)
  {
    this.f = ((LinearLayout)paramView.findViewById(2131433318));
    this.a = ((WinkMaterialPanel)paramView.findViewById(2131437998));
    this.a.setOnClearButtonClickListener(new -..Lambda.AEFlashShowFilterPanelViewHolder.NNOjldlbyvbsy0QY37962z3CA3k(this));
    this.b = new FilterMaterialPanelContentAdapter(a().getContext());
    this.b.c(true);
    this.b.a(this);
    b(paramView);
  }
  
  public void a(AECaptureController paramAECaptureController, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    a(new AEFlashShowFilterPanelViewHolder.1(this, paramVideoStoryCapturePartManager));
  }
  
  public void a(ApplyMaterialTask.Status paramStatus, int paramInt, @NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    if (FilterMetaMaterialKt.c(paramMetaMaterial))
    {
      paramMaterialStatusCallback.onStatusChanged(ApplyMaterialTask.Status.SUCCEEDED, 100);
      return;
    }
    if (FilterMetaMaterialKt.d(paramMetaMaterial))
    {
      a(paramMetaMaterial, paramMaterialStatusCallback);
      return;
    }
    ThreadManager.getFileThreadHandler().post(new -..Lambda.AEFlashShowFilterPanelViewHolder.A_4oCgADF-wFMtIMbK6wZB0HWK4(this, paramMetaMaterial, paramMaterialStatusCallback));
  }
  
  public void a(StartPointSeekBar paramStartPointSeekBar)
  {
    paramStartPointSeekBar = (MetaMaterial)this.i.a().getValue();
    if (paramStartPointSeekBar != null) {
      AEBaseDataReporter.a().d(paramStartPointSeekBar.id, this.i.b(paramStartPointSeekBar).a);
    }
  }
  
  public void a(StartPointSeekBar paramStartPointSeekBar, int paramInt)
  {
    this.i.a(paramInt);
    StartPointSeekBar.a(this.c, paramInt, this.d);
    paramStartPointSeekBar = (AEPituCameraUnit)this.h.a(65537, new Object[0]);
    if (paramStartPointSeekBar != null) {
      paramStartPointSeekBar.a(1, null, paramInt, false);
    }
  }
  
  public boolean a(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    return ApplyMaterialTaskHelper.a(paramMetaMaterial);
  }
  
  public void b(StartPointSeekBar paramStartPointSeekBar) {}
  
  public boolean b(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    String str = WinkEditorResourceManager.c().d(paramMetaMaterial);
    return (ApplyMaterialTaskHelper.b(paramMetaMaterial)) && (!TextUtils.isEmpty(str)) && (new File(str).exists());
  }
  
  public void c(int paramInt, @NonNull MetaMaterial paramMetaMaterial) {}
  
  public void d()
  {
    AEPituCameraUnit localAEPituCameraUnit = (AEPituCameraUnit)this.h.a(65537, new Object[0]);
    if (localAEPituCameraUnit == null) {
      return;
    }
    this.i = ((AEFlashSHOWFilterViewModel)AEViewModelProviders.a(localAEPituCameraUnit).get(AEFlashSHOWFilterViewModel.class));
    this.i.b().observe(localAEPituCameraUnit, new AEFlashShowFilterPanelViewHolder.2(this));
    this.i.a().observe(localAEPituCameraUnit, new AEFlashShowFilterPanelViewHolder.3(this));
    this.i.c().observe(localAEPituCameraUnit, new AEFlashShowFilterPanelViewHolder.4(this));
    this.i.a(Boolean.valueOf(true));
  }
  
  public void d(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    AEBaseDataReporter.a().d(paramMetaMaterial.id, this.i.b(paramMetaMaterial).a);
    this.a.setClearButtonEnable(true);
    this.i.a(paramInt, paramMetaMaterial);
  }
  
  public void e()
  {
    c();
    this.f.setVisibility(0);
  }
  
  public void e(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    this.b.a(paramInt);
  }
  
  public void f()
  {
    if (!ap_()) {
      return;
    }
    this.f.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowFilterPanelViewHolder
 * JD-Core Version:    0.7.0.1
 */