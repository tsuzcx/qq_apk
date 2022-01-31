package com.tencent.biz.pubaccount.readinjoy.capture;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.FlowComponentInterface;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.util.JumpUtil;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView.ContainerViewListener;
import com.tencent.mobileqq.widget.QQToast;
import lkp;
import lkq;

public class ReadInJoyEffectsCameraCaptureFragment
  extends EffectsCameraCaptureFragment
  implements ProviderContainerView.ContainerViewListener
{
  private int a;
  public Button a;
  protected FlowComponentInterface a;
  
  private Intent a(Activity paramActivity, Class paramClass, PublishParam paramPublishParam)
  {
    paramClass = new Intent(paramActivity, paramClass);
    if (paramActivity.getIntent().getExtras() != null) {
      paramClass.putExtras(paramActivity.getIntent().getExtras());
    }
    if (paramPublishParam != null)
    {
      paramClass.putExtra(PublishParam.jdField_a_of_type_JavaLangString, paramPublishParam);
      paramClass.putExtra("arg_video_source", 2);
      paramClass.putExtra("arg_video_duration", paramPublishParam.jdField_a_of_type_Long);
      paramClass.putExtra("arg_video_path", paramPublishParam.j);
      paramClass.putExtra("arg_video_cover", paramPublishParam.c);
      paramClass.putExtra("arg_video_width", paramPublishParam.jdField_a_of_type_Int);
      paramClass.putExtra("arg_video_height", paramPublishParam.b);
    }
    return paramClass;
  }
  
  private void a(Activity paramActivity, PublishParam paramPublishParam)
  {
    startActivityForResult(a(paramActivity, ReadInJoyDeliverVideoActivity.class, paramPublishParam), 111);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131370125));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void n()
  {
    int i = getActivity().getIntent().getIntExtra("key_max_duration", 60);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.setMaxDuration(i * 1000);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.setCaptureButtonProgressInterceptor(new ReadInJoyCameraCaptureButtonInterceptor());
    i = getActivity().getIntent().getIntExtra("key_ability_flag", 3);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.setFunctionFlag(i);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.a();
    this.jdField_a_of_type_Int = getActivity().getIntent().getIntExtra("edit_video_type", 10013);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    QQToast.a(getActivity(), "拍摄时间过短，请重新拍摄。", 0).a();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_AndroidOsHandler.post(new lkp(this));
  }
  
  public void a(View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    switch (paramInt)
    {
    default: 
      return;
    case 102: 
      PublicAccountReportUtils.a(null, "", "0X80092F4", "0X80092F4", 0, 0, "1", "", "", "", false);
      return;
    case 103: 
      PublicAccountReportUtils.a(null, "", "0X80092F4", "0X80092F4", 0, 0, "3", "", "", "", false);
      return;
    }
    PublicAccountReportUtils.a(null, "", "0X80092F4", "0X80092F4", 0, 0, "2", "", "", "", false);
  }
  
  protected void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    PublicAccountReportUtils.a(null, "", "0X80092F4", "0X80092F4", 0, 0, "", "1", "", "", false);
    JumpUtil.a(this, paramVideoCaptureResult, paramLocalMediaInfo, a(true), 12, a(), 0, null, null, null);
  }
  
  public void al_()
  {
    super.al_();
    this.jdField_a_of_type_AndroidOsHandler.post(new lkq(this));
  }
  
  protected int b()
  {
    return 2130971193;
  }
  
  protected void c()
  {
    Object localObject = getActivity();
    if (localObject != null)
    {
      localObject = ReadInJoyCameraCaptureHelper.a((Context)localObject);
      if (localObject != null) {
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable((Drawable)localObject);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {}
    do
    {
      return;
      if (paramInt1 == 10013)
      {
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          a(localFragmentActivity, (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString));
          return;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        return;
      }
    } while (paramInt1 != 111);
    localFragmentActivity.setResult(paramInt2, paramIntent);
    getActivity().finish();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    PublicAccountReportUtils.a(null, "", "0X80092F4", "0X80092F4", 0, 0, "", "", "1", "", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface.a(getActivity());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.g = false;
    n();
    a(paramLayoutInflater);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface = new ReadInJoyFlowComponentInterface();
    c();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.a(this);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.b(this);
    }
  }
  
  public void y_()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyEffectsCameraCaptureFragment
 * JD-Core Version:    0.7.0.1
 */