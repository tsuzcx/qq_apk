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
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private AEWaterMarkAdapter jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkAdapter;
  private AEWaterMarkPanel.AEWaterMarkPanelListener jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener;
  private AEVideoStoryTopBarViewModel.Ratio jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio;
  private AEMaterialManager jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = AECaptureContext.a();
  private View b;
  
  public AEWaterMarkProviderView(@NonNull Context paramContext, AEWaterMarkPanel.AEWaterMarkPanelListener paramAEWaterMarkPanelListener)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener = paramAEWaterMarkPanelListener;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    AEQLog.a("AEWaterMarkProviderView", "watermark initView");
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2064318485, this);
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2064122849);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2064122195));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(paramContext, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkAdapter = new AEWaterMarkAdapter(paramContext, this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkAdapter);
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager = ((AEMaterialManager)AEQIMManager.a(1));
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.b(false);
  }
  
  public void a()
  {
    AEWaterMarkAdapter localAEWaterMarkAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkAdapter;
    if (localAEWaterMarkAdapter != null) {
      localAEWaterMarkAdapter.a();
    }
  }
  
  public void a(List<AEMaterialCategory> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkAdapter.a(((AEMaterialCategory)paramList.get(0)).a);
    }
  }
  
  public void setCaptureRadio(AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pannel setCaptureRadio");
    ((StringBuilder)localObject).append(paramRatio);
    AEQLog.a("AEWaterMarkProviderView", ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = paramRatio;
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkAdapter;
    if (localObject != null) {
      ((AEWaterMarkAdapter)localObject).a(paramRatio);
    }
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.FULL) {
      this.b.setBackgroundColor(getResources().getColor(2131165338));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEWaterMarkProviderView
 * JD-Core Version:    0.7.0.1
 */