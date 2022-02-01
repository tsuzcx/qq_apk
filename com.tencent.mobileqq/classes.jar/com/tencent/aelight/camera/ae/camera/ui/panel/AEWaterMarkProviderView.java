package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEMaterialCategory;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.aebase.AECaptureContext;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.AppInterface;
import java.util.List;

public class AEWaterMarkProviderView
  extends FrameLayout
{
  private AppInterface a = AECaptureContext.a();
  private RecyclerView b;
  private View c;
  private AEWaterMarkAdapter d;
  private AEMaterialManager e;
  private AEWaterMarkPanel.AEWaterMarkPanelListener f;
  private AEVideoStoryTopBarViewModel.Ratio g;
  private View h;
  
  public AEWaterMarkProviderView(@NonNull Context paramContext, AEWaterMarkPanel.AEWaterMarkPanelListener paramAEWaterMarkPanelListener)
  {
    super(paramContext);
    this.f = paramAEWaterMarkPanelListener;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    AEQLog.a("AEWaterMarkProviderView", "watermark initView");
    this.c = LayoutInflater.from(getContext()).inflate(2064056345, this);
    this.h = this.c.findViewById(2063991622);
    this.b = ((RecyclerView)this.c.findViewById(2063991076));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(paramContext, 0, false);
    this.b.setLayoutManager(localLinearLayoutManager);
    this.d = new AEWaterMarkAdapter(paramContext, this.f);
    this.b.setAdapter(this.d);
    this.e = ((AEMaterialManager)AEQIMManager.a(1));
    this.e.b(false);
  }
  
  public void a()
  {
    AEWaterMarkAdapter localAEWaterMarkAdapter = this.d;
    if (localAEWaterMarkAdapter != null) {
      localAEWaterMarkAdapter.a();
    }
  }
  
  public void a(List<AEMaterialCategory> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.d.a(((AEMaterialCategory)paramList.get(0)).a);
    }
  }
  
  public void setCaptureRadio(AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pannel setCaptureRadio");
    ((StringBuilder)localObject).append(paramRatio);
    AEQLog.a("AEWaterMarkProviderView", ((StringBuilder)localObject).toString());
    this.g = paramRatio;
    localObject = this.d;
    if (localObject != null) {
      ((AEWaterMarkAdapter)localObject).a(paramRatio);
    }
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.FULL) {
      this.h.setBackgroundColor(getResources().getColor(2131165580));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEWaterMarkProviderView
 * JD-Core Version:    0.7.0.1
 */