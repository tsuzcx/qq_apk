package com.tencent.aelight.camera.ae.camera.ui.watermark;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewStub;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.ui.poi.AESelectLocationFragment;
import com.tencent.aelight.camera.ae.part.VideoStoryBasePart;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.ttpic.baseutils.string.StringUtils;
import java.util.List;
import org.light.bean.WMElement;

public class AEWaterMarkEditorPart
  extends VideoStoryBasePart
{
  private static boolean jdField_a_of_type_Boolean = false;
  private AEPituCameraUnit jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit;
  private WatermarkEditView jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditView;
  private WMElement jdField_a_of_type_OrgLightBeanWMElement;
  private boolean b = false;
  
  public AEWaterMarkEditorPart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
  }
  
  private void a()
  {
    List localList = this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a();
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (localList.size() == 1)
      {
        localObject = (WMElement)localList.get(0);
        if ((localObject != null) && ("EDITABLE_LOCATION".equals(((WMElement)localObject).type)))
        {
          AEQLog.a("AEWaterMarkEditorPart", "only jump to poi");
          AESelectLocationFragment.a(this.mActivity, 203);
          this.b = true;
          this.jdField_a_of_type_OrgLightBeanWMElement = ((WMElement)localObject);
          return;
        }
      }
      this.b = false;
      if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditView == null)
      {
        localObject = (ViewStub)this.mActivity.findViewById(2064122020);
        if (localObject != null)
        {
          ((ViewStub)localObject).inflate();
          this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditView = ((WatermarkEditView)this.mActivity.findViewById(2064122019));
          this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditView.a(this.mActivity, this.mPartManager);
        }
      }
      Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditView;
      if (localObject != null) {
        ((WatermarkEditView)localObject).a(localList);
      }
      return;
    }
    AEQLog.d("AEWaterMarkEditorPart", "showWaterMarkEdit---getEditableWMElements is null");
  }
  
  public Object get(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 589826) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(jdField_a_of_type_Boolean);
  }
  
  protected void initView() {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 203) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("key_select_poi");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityResult");
      ((StringBuilder)localObject).append(paramIntent);
      AEQLog.a("AEWaterMarkEditorPart", ((StringBuilder)localObject).toString());
      if (!this.b)
      {
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditView;
        if (localObject != null)
        {
          ((WatermarkEditView)localObject).setWaterMarkLocation(paramIntent);
          return;
        }
      }
      if ((this.b) && (this.jdField_a_of_type_OrgLightBeanWMElement != null))
      {
        paramIntent = StringUtils.removeUTF8Emoji(paramIntent).trim();
        this.jdField_a_of_type_OrgLightBeanWMElement.setLocation(paramIntent);
      }
    }
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 589826: 
      paramVarArgs = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditView;
      if ((paramVarArgs != null) && (paramVarArgs.getVisibility() == 0)) {
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkEditView.setVisibility(8);
      }
      jdField_a_of_type_Boolean = false;
      return;
    }
    a();
    if (this.b)
    {
      jdField_a_of_type_Boolean = false;
      return;
    }
    jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.watermark.AEWaterMarkEditorPart
 * JD-Core Version:    0.7.0.1
 */