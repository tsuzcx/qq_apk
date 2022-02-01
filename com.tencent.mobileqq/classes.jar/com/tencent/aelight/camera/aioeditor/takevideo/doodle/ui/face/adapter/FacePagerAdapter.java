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
  private Context a;
  private IFaceSelectedListener b;
  private FaceListPage.FacePackagePageEventListener c;
  private FacePanelBaseAdapter d;
  private List<FaceListPage> e = new LinkedList();
  
  public FacePagerAdapter(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public void a()
  {
    notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    FacePackage localFacePackage = this.d.a(paramInt);
    if (localFacePackage != null)
    {
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
      {
        FaceListPage localFaceListPage = (FaceListPage)localIterator.next();
        if ((localFaceListPage.a == paramInt) && (localFaceListPage.b)) {
          localFaceListPage.a(localFacePackage);
        }
      }
    }
  }
  
  public void a(IFaceSelectedListener paramIFaceSelectedListener)
  {
    this.b = paramIFaceSelectedListener;
  }
  
  public void a(FaceListPage.FacePackagePageEventListener paramFacePackagePageEventListener)
  {
    this.c = paramFacePackagePageEventListener;
  }
  
  public void a(FacePanelBaseAdapter paramFacePanelBaseAdapter)
  {
    this.d = paramFacePanelBaseAdapter;
    notifyDataSetChanged();
  }
  
  public void b(int paramInt)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      FaceListPage localFaceListPage = (FaceListPage)localIterator.next();
      if (localFaceListPage.a == paramInt)
      {
        if (!localFaceListPage.b)
        {
          FacePackage localFacePackage = this.d.a(paramInt);
          localFaceListPage.b = true;
          localFaceListPage.a(localFacePackage);
        }
        localFaceListPage.a();
      }
    }
  }
  
  public void c(int paramInt)
  {
    FaceListPage localFaceListPage = e(paramInt);
    boolean bool = true;
    Object localObject;
    if ((localFaceListPage != null) && (!localFaceListPage.b))
    {
      localObject = this.d.a(paramInt);
      localFaceListPage.b = true;
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
    Object localObject = this.e;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.e.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FaceListPage localFaceListPage = (FaceListPage)((Iterator)localObject).next();
        if ((localFaceListPage.a != paramInt) && (localFaceListPage.b))
        {
          localFaceListPage.b = false;
          localFaceListPage.a(this.d.a(localFaceListPage.a));
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("clearOtherView position:");
            localStringBuilder.append(localFaceListPage.a);
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
    paramObject.a = -1;
    paramObject.a(null);
    this.e.remove(paramObject);
  }
  
  public FaceListPage e(int paramInt)
  {
    Object localObject3 = this.e;
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
        if (((FaceListPage)localObject2).a == paramInt) {
          localObject1 = localObject2;
        }
      }
    }
    return localObject2;
  }
  
  public int getCount()
  {
    FacePanelBaseAdapter localFacePanelBaseAdapter = this.d;
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
    Object localObject = this.d;
    if (localObject == null) {
      return null;
    }
    localObject = ((FacePanelBaseAdapter)localObject).a(paramInt);
    FaceListPage localFaceListPage = new FaceListPage(this.a, this.b, this.c);
    paramViewGroup.addView(localFaceListPage);
    localFaceListPage.a = paramInt;
    if (((ViewPager)paramViewGroup).getCurrentItem() == paramInt) {
      localFaceListPage.b = true;
    } else {
      localFaceListPage.b = false;
    }
    localFaceListPage.a((FacePackage)localObject);
    this.e.add(localFaceListPage);
    return localFaceListPage;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.FacePagerAdapter
 * JD-Core Version:    0.7.0.1
 */