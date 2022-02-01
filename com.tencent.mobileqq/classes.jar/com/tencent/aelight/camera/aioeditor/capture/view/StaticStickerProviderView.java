package com.tencent.aelight.camera.aioeditor.capture.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.LayoutInflater;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.IFaceSelectedListener;
import com.tencent.aelight.camera.aioeditor.capture.music.CaptureConfigUpdateObserver;
import com.tencent.aelight.camera.aioeditor.capture.paster.PasterDataManager;
import com.tencent.aelight.camera.aioeditor.capture.paster.QIMPasterConfigManager;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.FacePackage;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.LocationFacePackage;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.NormalFacePackage;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle.DoodleFacePanelAdapter;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.FaceItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage.FacePackagePageEventListener;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.AdapterObserver;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.FacePagerAdapter;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.FacePanelBaseAdapter;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper.ZoomItem;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.widget.bounce.BounceViewPager;
import com.tencent.mobileqq.widget.bounce.BounceViewPager.PageChangedObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(9)
public class StaticStickerProviderView
  extends ProviderView
  implements QIMSlidingTabView.IOnTabCheckListener, AdapterObserver, BounceViewPager.PageChangedObserver
{
  private int jdField_a_of_type_Int = 0;
  private IFaceSelectedListener jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataIFaceSelectedListener;
  CaptureConfigUpdateObserver jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicCaptureConfigUpdateObserver = new StaticStickerProviderView.2(this);
  FacePagerAdapter jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePagerAdapter;
  FacePanelBaseAdapter jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter;
  BounceViewPager jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager;
  public ArrayList<String> a;
  
  public StaticStickerProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(PasterDataManager paramPasterDataManager, EditVideoDoodle.DoodleFacePanelAdapter paramDoodleFacePanelAdapter)
  {
    paramDoodleFacePanelAdapter.a(new ArrayList(paramPasterDataManager.a()));
  }
  
  public static void a(Collection<FacePackage> paramCollection)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StaticStickerProviderView", 2, "random tab shufflePaster");
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      FacePackage localFacePackage = (FacePackage)paramCollection.next();
      if (localFacePackage.jdField_a_of_type_Boolean) {
        if ((localFacePackage instanceof NormalFacePackage)) {
          Collections.shuffle(((NormalFacePackage)localFacePackage).a);
        } else if ((localFacePackage instanceof LocationFacePackage)) {
          Collections.shuffle(((LocationFacePackage)localFacePackage).a);
        }
      }
    }
  }
  
  private void j()
  {
    ArrayList localArrayList1 = ((QIMPasterConfigManager)QIMManager.a(1)).a();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < localArrayList1.size())
    {
      if (((DoodleEmojiItem)localArrayList1.get(i)).hide != 1)
      {
        String str = ((DoodleEmojiItem)localArrayList1.get(i)).name;
        if (!localArrayList2.contains(str)) {
          localArrayList2.add(str);
        }
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView.initTabItemsWithString(localArrayList2);
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList2;
  }
  
  private void k()
  {
    long l1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    double d = Runtime.getRuntime().maxMemory();
    Double.isNaN(d);
    long l2 = (d * 0.8D);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearMemory ");
      boolean bool;
      if (l1 > l2) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("StaticStickerProviderView", 2, localStringBuilder.toString());
    }
    if ((l1 > l2) && (GlobalImageCache.a != null)) {
      GlobalImageCache.a.evictAll();
    }
  }
  
  protected int a()
  {
    return 2131560883;
  }
  
  public void a()
  {
    super.a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager;
    if (localObject != null) {
      ((BounceViewPager)localObject).b(this);
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter;
    if (localObject != null) {
      ((FacePanelBaseAdapter)localObject).b(this);
    }
    localObject = ((PasterDataManager)QIMManager.a(4)).a();
    if (localObject != null) {
      ((EditVideoDoodle.DoodleFacePanelAdapter)localObject).b(this);
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicCaptureConfigUpdateObserver);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView.onTabChecked(paramInt);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePagerAdapter.b(paramInt);
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      if (paramInt1 < this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem())
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePagerAdapter.c(paramInt1);
        return;
      }
      if (paramInt1 == this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem()) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePagerAdapter.c(paramInt1 + 1);
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560883, this, false);
    }
    a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager = ((BounceViewPager)findViewById(2131366428));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePagerAdapter = new FacePagerAdapter(super.getContext());
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.a(this);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    j();
    paramBundle = (PasterDataManager)QIMManager.a(4);
    paramBundle.c();
    Object localObject = paramBundle.a();
    a(paramBundle, (EditVideoDoodle.DoodleFacePanelAdapter)localObject);
    setAdapter((FacePanelBaseAdapter)localObject);
    localObject = (Activity)getContext();
    setDownloadListener(new StaticStickerProviderView.1(this, (Activity)localObject));
    localObject = (DoodleLayout)((Activity)localObject).findViewById(2064122115);
    if (localObject == null)
    {
      AEQLog.d("StaticStickerProviderView", "doodleLayout is null.");
      return;
    }
    setOnFaceSelectedListener(((DoodleLayout)localObject).a());
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicCaptureConfigUpdateObserver);
    paramBundle.a(true, (Activity)getContext());
  }
  
  public void a(GestureHelper.ZoomItem paramZoomItem)
  {
    if (((paramZoomItem instanceof FaceLayer.FaceItem)) && (this.jdField_a_of_type_JavaUtilArrayList != null))
    {
      Object localObject = (FaceLayer.FaceItem)paramZoomItem;
      paramZoomItem = ((FaceLayer.FaceItem)localObject).e;
      localObject = ((FaceLayer.FaceItem)localObject).d;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (TextUtils.equals((String)this.jdField_a_of_type_JavaUtilArrayList.get(i), (CharSequence)localObject))
        {
          onTabChecked(i);
          postDelayed(new StaticStickerProviderView.3(this, i, paramZoomItem), 200L);
        }
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("selectPosition category=");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" name=");
        localStringBuilder.append(paramZoomItem);
        QLog.d("StaticStickerProviderView", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void b()
  {
    super.b();
    IFaceSelectedListener localIFaceSelectedListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataIFaceSelectedListener;
    if (localIFaceSelectedListener != null) {
      localIFaceSelectedListener.a();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePagerAdapter.d(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem());
    }
  }
  
  public void c()
  {
    super.c();
    PasterDataManager localPasterDataManager = (PasterDataManager)QIMManager.a(4);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePagerAdapter.notifyDataSetChanged();
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramInt);
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.removeAllViews();
    k();
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("StaticStickerProviderView", 2, "random tab paster onResume");
    }
    i();
  }
  
  public void g()
  {
    j();
    PasterDataManager localPasterDataManager = (PasterDataManager)QIMManager.a(4);
    EditVideoDoodle.DoodleFacePanelAdapter localDoodleFacePanelAdapter = localPasterDataManager.a();
    if (localDoodleFacePanelAdapter != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("StaticStickerProviderView", 2, "paster config updateData");
      }
      a(localPasterDataManager, localDoodleFacePanelAdapter);
      setAdapter(localDoodleFacePanelAdapter);
      h();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView.onTabChecked(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem());
    }
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePagerAdapter.a();
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePagerAdapter != null) && (PasterDataManager.a.compareAndSet(true, false))) {
      g();
    }
  }
  
  public void onTabChecked(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setCurrentItem(paramInt);
    if (DoodleLayout.jdField_a_of_type_Boolean) {
      localObject = "2";
    } else {
      localObject = "1";
    }
    DoodleLayout.a("change_face", 0, 0, new String[] { localObject });
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter;
    if (localObject != null)
    {
      localObject = ((FacePanelBaseAdapter)localObject).a(paramInt);
      if ((localObject != null) && ((localObject instanceof FacePackage)))
      {
        localObject = (FacePackage)localObject;
        VideoEditReport.a("0X80076C7", "", "", ((FacePackage)localObject).jdField_a_of_type_JavaLangString, "");
        VideoEditReport.a("0X80075DC", ((FacePackage)localObject).jdField_a_of_type_JavaLangString);
      }
    }
    if (paramInt == 1)
    {
      VideoEditReport.a("0X80076CC");
      VideoEditReport.b("0X80075E1");
    }
  }
  
  public void setAdapter(FacePanelBaseAdapter paramFacePanelBaseAdapter)
  {
    FacePanelBaseAdapter localFacePanelBaseAdapter = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter;
    if (localFacePanelBaseAdapter != null)
    {
      localFacePanelBaseAdapter.b(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter = null;
    }
    if (paramFacePanelBaseAdapter != null)
    {
      paramFacePanelBaseAdapter.b(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter = paramFacePanelBaseAdapter;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter.a(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter);
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setCurrentItem(paramInt);
  }
  
  public void setDownloadListener(FaceListPage.FacePackagePageEventListener paramFacePackagePageEventListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramFacePackagePageEventListener);
  }
  
  public void setOnFaceSelectedListener(IFaceSelectedListener paramIFaceSelectedListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataIFaceSelectedListener = paramIFaceSelectedListener;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramIFaceSelectedListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.StaticStickerProviderView
 * JD-Core Version:    0.7.0.1
 */