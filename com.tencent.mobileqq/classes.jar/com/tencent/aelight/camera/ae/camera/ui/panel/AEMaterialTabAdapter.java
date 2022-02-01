package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEMaterialCategory;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class AEMaterialTabAdapter
  extends PagerAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private AEMaterialPanel.AEMaterialPanelListener jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener;
  private AEMaterialManager jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager;
  public HashMap<Integer, AEGridView> a;
  private List<AEMaterialCategory> jdField_a_of_type_JavaUtilList;
  
  public AEMaterialTabAdapter(Context paramContext, AEMaterialPanel.AEMaterialPanelListener paramAEMaterialPanelListener)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener = paramAEMaterialPanelListener;
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager = ((AEMaterialManager)AEQIMManager.a(1));
  }
  
  private void a(AEMaterialAdapter paramAEMaterialAdapter, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(paramAEMaterialAdapter, 112);
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(paramAEMaterialAdapter, 113);
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(paramAEMaterialAdapter, 1024);
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(paramAEMaterialAdapter, 114);
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(paramAEMaterialAdapter, 111);
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(paramAEMaterialAdapter, 115);
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(paramAEMaterialAdapter, 111);
    }
  }
  
  public AEMaterialCategory a(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > paramInt) && (paramInt >= 0)) {
      return (AEMaterialCategory)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<AEMaterialCategory> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
    paramViewGroup = (AEGridView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (paramViewGroup != null)
    {
      paramViewGroup = (AEMaterialAdapter)paramViewGroup.getAdapter();
      this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(paramViewGroup);
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AEGridView localAEGridView = (AEGridView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    Object localObject;
    if (localAEGridView == null)
    {
      localAEGridView = new AEGridView(this.jdField_a_of_type_AndroidContentContext);
      localObject = this.jdField_a_of_type_AndroidContentContext;
      AEMaterialPanel.AEMaterialPanelListener localAEMaterialPanelListener = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener;
      boolean bool;
      if (paramInt == 0) {
        bool = true;
      } else {
        bool = false;
      }
      localObject = new AEMaterialAdapter((Context)localObject, localAEGridView, localAEMaterialPanelListener, bool);
      a((AEMaterialAdapter)localObject, paramInt);
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localAEGridView);
    }
    else
    {
      localObject = (AEMaterialAdapter)localAEGridView.getAdapter();
      a((AEMaterialAdapter)localObject, paramInt);
    }
    ((AEMaterialAdapter)localObject).a(((AEMaterialCategory)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaUtilList);
    localAEGridView.setAdapter((RecyclerView.Adapter)localObject);
    paramViewGroup.addView(localAEGridView);
    if (QLog.isColorLevel())
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("instantiateItem: invoked. info: ptvTemplateAdapter = ");
      paramViewGroup.append(localObject);
      QLog.i("PtvTemplateViewPagerAdapter", 2, paramViewGroup.toString());
    }
    return localAEGridView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialTabAdapter
 * JD-Core Version:    0.7.0.1
 */