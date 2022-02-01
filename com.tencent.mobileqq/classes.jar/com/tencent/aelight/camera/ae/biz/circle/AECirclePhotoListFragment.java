package com.tencent.aelight.camera.ae.biz.circle;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleClearAllSelectEvent;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleSelectChangeEvent;
import com.tencent.aelight.camera.ae.biz.circle.part.AECircleAlbumListPart;
import com.tencent.aelight.camera.ae.biz.circle.part.AECirclePhotoListPart;
import com.tencent.aelight.camera.ae.biz.circle.part.AECirclePreviewPart;
import com.tencent.aelight.camera.ae.biz.circle.part.AECircleSelectPanelPart;
import com.tencent.aelight.camera.ae.biz.circle.part.AECircleTitleChipPart;
import com.tencent.aelight.camera.ae.biz.circle.part.base.AECircleBasePart;
import com.tencent.aelight.camera.ae.biz.circle.part.base.AECircleBasePartFragment;
import com.tencent.aelight.camera.ae.biz.circle.part.base.AECirclePartManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListBaseData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import java.util.ArrayList;
import java.util.List;

public class AECirclePhotoListFragment
  extends AECircleBasePartFragment
  implements SimpleEventReceiver
{
  public AECirclePhotoListLogic a;
  AECircleAlbumListPart jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleAlbumListPart;
  AECirclePhotoListPart jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECirclePhotoListPart;
  AECirclePreviewPart jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECirclePreviewPart;
  AECircleSelectPanelPart jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleSelectPanelPart;
  AECircleTitleChipPart jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleTitleChipPart;
  public PhotoListBaseData a;
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic = new AECirclePhotoListLogic(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData;
    Intent localIntent = getActivity().getIntent();
    if (localIntent == null)
    {
      QLog.d("SelectPhotoTrace", 1, "AECirclePhotoListFragment initLogic() intent is null!");
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a(localIntent);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AECirclePhotoListFragment initLogic(),extra is:");
      localStringBuilder.append(localIntent.getExtras());
      QLog.d("SelectPhotoTrace", 2, localStringBuilder.toString());
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      QLog.e("AECirclePhotoListFragment", 1, "reportDaTongRegister  view == null");
      return;
    }
    VideoReport.setPageId(this.jdField_a_of_type_AndroidViewView, "pg_xsj_choose_media_page");
    VideoReport.setPageParams(this.jdField_a_of_type_AndroidViewView, new QCircleDTParamBuilder().buildPageParams("AECirclePhotoListFragment"));
    QLog.i("AECirclePhotoListFragment", 1, "reportDaTongRegister  subPage: AECirclePhotoListFragment");
  }
  
  protected int a()
  {
    return 2064318494;
  }
  
  protected List<AECircleBasePart> a()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleAlbumListPart = new AECircleAlbumListPart(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECirclePhotoListPart = new AECirclePhotoListPart(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECirclePreviewPart = new AECirclePreviewPart(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleSelectPanelPart = new AECircleSelectPanelPart(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleTitleChipPart = new AECircleTitleChipPart(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleTitleChipPart.a(false);
    localArrayList.add(this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleAlbumListPart);
    localArrayList.add(this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECirclePhotoListPart);
    localArrayList.add(this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECirclePreviewPart);
    localArrayList.add(this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleSelectPanelPart);
    localArrayList.add(this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECircleTitleChipPart);
    return localArrayList;
  }
  
  public boolean a()
  {
    return (a() != null) && (a().a());
  }
  
  public boolean b()
  {
    return (a() == null) || (a().b());
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AECircleClearAllSelectEvent.class);
    return localArrayList;
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    a();
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT > 23) {
      getActivity().getWindow().setBackgroundDrawable(null);
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("AECirclePhotoListFragment,hashCode is:");
      paramBundle.append(System.identityHashCode(this));
      QLog.d("SelectPhotoTrace", 2, paramBundle.toString());
    }
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(a(), paramViewGroup, false);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AECirclePhotoListFragment", 1, localThrowable, new Object[0]);
    }
    a(paramLayoutInflater, paramViewGroup, paramBundle);
    ViewCompat.setOnApplyWindowInsetsListener(this.jdField_a_of_type_AndroidViewView, new AECirclePhotoListFragment.1(this));
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.post(new AECirclePhotoListFragment.2(this));
    }
    b();
    paramLayoutInflater = new StringBuilder();
    paramLayoutInflater.append("onCreateView cost:");
    paramLayoutInflater.append(System.currentTimeMillis() - l);
    QLog.d("[Performance2]AECirclePhotoListFragment", 1, paramLayoutInflater.toString());
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.b();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onPause()
  {
    AEQLog.b("AECirclePhotoListFragment", "onPause---");
    super.onPause();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof AECircleClearAllSelectEvent))
    {
      paramSimpleBaseEvent = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic;
      if (paramSimpleBaseEvent != null)
      {
        paramSimpleBaseEvent.d();
        paramSimpleBaseEvent = this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartAECirclePhotoListPart;
        if (paramSimpleBaseEvent != null) {
          paramSimpleBaseEvent.b();
        }
        SimpleEventBus.getInstance().dispatchEvent(new AECircleSelectChangeEvent());
      }
    }
  }
  
  public void onResume()
  {
    AEQLog.b("AECirclePhotoListFragment", "onResume---");
    super.onResume();
    SimpleEventBus.getInstance().dispatchEvent(new AECircleSelectChangeEvent());
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListFragment
 * JD-Core Version:    0.7.0.1
 */