package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.aelight.camera.aioeditor.capture.data.IFaceSelectedListener;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.FacePackage;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage.FacePackagePageEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FacePagerAdapter
  extends PagerAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private IFaceSelectedListener jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataIFaceSelectedListener;
  private FaceListPage.FacePackagePageEventListener jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener;
  private FacePanelBaseAdapter jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter;
  private List<FaceListPage> jdField_a_of_type_JavaUtilList = new LinkedList();
  
  public FacePagerAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public FaceListPage a(int paramInt)
  {
    Object localObject3 = this.jdField_a_of_type_JavaUtilList;
    Object localObject2 = null;
    Object localObject1 = null;
    if (localObject3 != null)
    {
      localObject3 = ((List)localObject3).iterator();
      for (;;)
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject2 = (FaceListPage)((Iterator)localObject3).next();
        if (((FaceListPage)localObject2).jdField_a_of_type_Int == paramInt) {
          localObject1 = localObject2;
        }
      }
    }
    return localObject2;
  }
  
  public void a()
  {
    notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    FacePackage localFacePackage = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter.a(paramInt);
    if (localFacePackage != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        FaceListPage localFaceListPage = (FaceListPage)localIterator.next();
        if ((localFaceListPage.jdField_a_of_type_Int == paramInt) && (localFaceListPage.jdField_a_of_type_Boolean)) {
          localFaceListPage.a(localFacePackage);
        }
      }
    }
  }
  
  public void a(IFaceSelectedListener paramIFaceSelectedListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataIFaceSelectedListener = paramIFaceSelectedListener;
  }
  
  public void a(FaceListPage.FacePackagePageEventListener paramFacePackagePageEventListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener = paramFacePackagePageEventListener;
  }
  
  public void a(FacePanelBaseAdapter paramFacePanelBaseAdapter)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter = paramFacePanelBaseAdapter;
    notifyDataSetChanged();
  }
  
  public void b(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FaceListPage localFaceListPage = (FaceListPage)localIterator.next();
      if (localFaceListPage.jdField_a_of_type_Int == paramInt)
      {
        if (!localFaceListPage.jdField_a_of_type_Boolean)
        {
          FacePackage localFacePackage = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter.a(paramInt);
          localFaceListPage.jdField_a_of_type_Boolean = true;
          localFaceListPage.a(localFacePackage);
        }
        localFaceListPage.a();
      }
    }
  }
  
  public void c(int paramInt)
  {
    FaceListPage localFaceListPage = a(paramInt);
    boolean bool = true;
    Object localObject;
    if ((localFaceListPage != null) && (!localFaceListPage.jdField_a_of_type_Boolean))
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter.a(paramInt);
      localFaceListPage.jdField_a_of_type_Boolean = true;
      localFaceListPage.a((FacePackage)localObject);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyNextPageShow loaded position:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", page:");
      if (localFaceListPage == null) {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.i("FacePagerAdapter", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void d(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FaceListPage localFaceListPage = (FaceListPage)((Iterator)localObject).next();
        if ((localFaceListPage.jdField_a_of_type_Int != paramInt) && (localFaceListPage.jdField_a_of_type_Boolean))
        {
          localFaceListPage.jdField_a_of_type_Boolean = false;
          localFaceListPage.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter.a(localFaceListPage.jdField_a_of_type_Int));
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("clearOtherView position:");
            localStringBuilder.append(localFaceListPage.jdField_a_of_type_Int);
            localStringBuilder.append(", current:");
            localStringBuilder.append(paramInt);
            QLog.i("FacePagerAdapter", 2, localStringBuilder.toString());
          }
        }
      }
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (FaceListPage)paramObject;
    paramViewGroup.removeView(paramObject);
    paramObject.jdField_a_of_type_Int = -1;
    paramObject.a(null);
    this.jdField_a_of_type_JavaUtilList.remove(paramObject);
  }
  
  public int getCount()
  {
    FacePanelBaseAdapter localFacePanelBaseAdapter = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter;
    if (localFacePanelBaseAdapter == null) {
      return 0;
    }
    return localFacePanelBaseAdapter.a();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter;
    if (localObject == null) {
      return null;
    }
    localObject = ((FacePanelBaseAdapter)localObject).a(paramInt);
    FaceListPage localFaceListPage = new FaceListPage(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataIFaceSelectedListener, this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener);
    paramViewGroup.addView(localFaceListPage);
    localFaceListPage.jdField_a_of_type_Int = paramInt;
    if (((ViewPager)paramViewGroup).getCurrentItem() == paramInt) {
      localFaceListPage.jdField_a_of_type_Boolean = true;
    } else {
      localFaceListPage.jdField_a_of_type_Boolean = false;
    }
    localFaceListPage.a((FacePackage)localObject);
    this.jdField_a_of_type_JavaUtilList.add(localFaceListPage);
    return localFaceListPage;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.FacePagerAdapter
 * JD-Core Version:    0.7.0.1
 */