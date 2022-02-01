package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.ae.data.AEARCakeMaterial;
import com.tencent.aelight.camera.ae.data.AEGiftMaterial;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.List;

public class AEARCakeProvidewView
  extends FrameLayout
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AEARCakeMaterialAdapter jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeMaterialAdapter;
  private AEARCakePanel.AEARCakePanelListener jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel$AEARCakePanelListener;
  
  public AEARCakeProvidewView(@NonNull Context paramContext, AEARCakePanel.AEARCakePanelListener paramAEARCakePanelListener)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel$AEARCakePanelListener = paramAEARCakePanelListener;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2064318465, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2064122195));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(paramContext, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2064122336));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeMaterialAdapter = new AEARCakeMaterialAdapter(paramContext, this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel$AEARCakePanelListener);
    AEARCakeMaterialManager.a().a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeMaterialAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeMaterialAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new AEARCakeProvidewView.1(this));
  }
  
  public void a()
  {
    AEARCakeMaterialManager.a().a(null);
  }
  
  public void a(List<AEGiftMaterial> paramList, int paramInt)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = 0;
      Object localObject;
      while (i < paramList.size())
      {
        if (((AEGiftMaterial)paramList.get(i)).a() != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("arcake : categories.get(0).materialList :");
          ((StringBuilder)localObject).append(((AEGiftMaterial)paramList.get(i)).a().p);
          AEQLog.a("AEARCakeProvidewView", ((StringBuilder)localObject).toString());
        }
        i += 1;
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(getContext().getString(2064515289));
        ((StringBuilder)localObject).append(String.valueOf(paramList.size()));
        ((StringBuilder)localObject).append(getContext().getString(2064515290));
        localObject = ((StringBuilder)localObject).toString();
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeMaterialAdapter.a(paramList, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeProvidewView
 * JD-Core Version:    0.7.0.1
 */