package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.part.VideoStoryBasePart;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AEVideoStoryDashboardPart
  extends VideoStoryBasePart
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AEPituCameraUnit jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit;
  private AEVideoStoryDashboardPart.DashboardAdapter jdField_a_of_type_ComTencentAelightCameraAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter;
  private RecyclerView jdField_b_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_b_of_type_AndroidWidgetCheckBox;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private AEVideoStoryDashboardPart.DashboardAdapter jdField_b_of_type_ComTencentAelightCameraAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter;
  private RecyclerView jdField_c_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_c_of_type_AndroidWidgetCheckBox;
  private AEVideoStoryDashboardPart.DashboardAdapter jdField_c_of_type_ComTencentAelightCameraAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter;
  private RecyclerView jdField_d_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_d_of_type_AndroidWidgetCheckBox;
  private AEVideoStoryDashboardPart.DashboardAdapter jdField_d_of_type_ComTencentAelightCameraAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter;
  
  public AEVideoStoryDashboardPart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new AEVideoStoryDashboardPart.2(this));
    this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new AEVideoStoryDashboardPart.3(this));
    this.jdField_c_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new AEVideoStoryDashboardPart.4(this));
    this.jdField_d_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new AEVideoStoryDashboardPart.5(this));
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter = new AEVideoStoryDashboardPart.DashboardAdapter(this.mActivity);
    this.jdField_b_of_type_ComTencentAelightCameraAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter = new AEVideoStoryDashboardPart.DashboardAdapter(this.mActivity);
    this.jdField_c_of_type_ComTencentAelightCameraAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter = new AEVideoStoryDashboardPart.DashboardAdapter(this.mActivity);
    this.jdField_d_of_type_ComTencentAelightCameraAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter = new AEVideoStoryDashboardPart.DashboardAdapter(this.mActivity);
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.mActivity, 1, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter);
    localLinearLayoutManager = new LinearLayoutManager(this.mActivity, 1, false);
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_b_of_type_ComTencentAelightCameraAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter);
    localLinearLayoutManager = new LinearLayoutManager(this.mActivity, 1, false);
    this.jdField_c_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_c_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_c_of_type_ComTencentAelightCameraAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter);
    localLinearLayoutManager = new LinearLayoutManager(this.mActivity, 1, false);
    this.jdField_d_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_d_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_d_of_type_ComTencentAelightCameraAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter);
  }
  
  private void c()
  {
    QIPCClientHelper.getInstance().callServer("AECameraGetInfoServer", "ACTION_GET_ENV_INFO", null, new AEVideoStoryDashboardPart.6(this));
  }
  
  private void d()
  {
    AEDashboardUtil.a().observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new AEVideoStoryDashboardPart.7(this));
  }
  
  protected void initView()
  {
    View localView = ((ViewStub)this.mRootView.findViewById(2064121873)).inflate();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2064121878));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2064121879));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2064121876));
    this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2064121881));
    this.jdField_c_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2064121884));
    this.jdField_d_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2064121883));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2064121875));
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2064121880));
    this.jdField_c_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2064121874));
    this.jdField_d_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2064121882));
    a();
    b();
    c();
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new AEVideoStoryDashboardPart.1(this));
    d();
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if (paramInt == 720897)
    {
      localObject2 = (List)paramVarArgs[0];
      localObject1 = (List)paramVarArgs[1];
      paramVarArgs = new LinkedList();
      localObject2 = ((List)localObject2).iterator();
      AEVideoStoryDashboardPart.DashboardInfo localDashboardInfo;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (AEDashboardUtil.BinaryInfo)((Iterator)localObject2).next();
        localDashboardInfo = new AEVideoStoryDashboardPart.DashboardInfo(null);
        localDashboardInfo.a = AEVideoStoryDashboardPart.MessageRenderUtil.a((AEDashboardUtil.BinaryInfo)localObject3);
        paramVarArgs.add(localDashboardInfo);
      }
      localObject2 = new LinkedList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (AEDashboardUtil.ABTestInfo)((Iterator)localObject1).next();
        localDashboardInfo = new AEVideoStoryDashboardPart.DashboardInfo(null);
        localDashboardInfo.a = ((AEDashboardUtil.ABTestInfo)localObject3).toString();
        ((List)localObject2).add(localDashboardInfo);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter.a(paramVarArgs);
      this.jdField_c_of_type_ComTencentAelightCameraAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter.a((List)localObject2);
      return;
    }
    if ((paramInt == 720898) && (this.jdField_d_of_type_ComTencentAelightCameraAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter != null))
    {
      localObject1 = AEDashboardUtil.a.a();
      paramVarArgs = new LinkedList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = new AEVideoStoryDashboardPart.DashboardInfo(null);
        ((AEVideoStoryDashboardPart.DashboardInfo)localObject3).a = ((CharSequence)localObject2);
        paramVarArgs.add(localObject3);
      }
      this.jdField_d_of_type_ComTencentAelightCameraAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter.a(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart
 * JD-Core Version:    0.7.0.1
 */