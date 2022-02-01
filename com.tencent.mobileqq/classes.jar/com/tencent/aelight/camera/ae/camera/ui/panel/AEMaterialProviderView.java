package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEMaterialCategory;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.aebase.AECaptureContext;
import com.tencent.aelight.camera.aebase.QIMCameraCaptureActivity;
import com.tencent.aelight.camera.aioeditor.capture.music.CaptureConfigUpdateObserver;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView.IOnTabCheckListener;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView.TabIcon;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;

public class AEMaterialProviderView
  extends FrameLayout
  implements ViewTreeObserver.OnScrollChangedListener, ViewPager.OnPageChangeListener, QIMSlidingTabView.IOnTabCheckListener, Observer
{
  private int jdField_a_of_type_Int = 1;
  private AEMaterialPanel.AEMaterialPanelListener jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener;
  private AEMaterialTabAdapter jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialTabAdapter;
  private AEMaterialManager jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager;
  public CaptureConfigUpdateObserver a;
  private QIMSlidingTabView jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = AECaptureContext.a();
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private List<AEMaterialCategory> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = true;
  private boolean c = false;
  
  public AEMaterialProviderView(Context paramContext, AEMaterialPanel.AEMaterialPanelListener paramAEMaterialPanelListener)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicCaptureConfigUpdateObserver = new AEMaterialProviderView.1(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener = paramAEMaterialPanelListener;
    c();
  }
  
  private AEMaterialCategory a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      AEMaterialCategory localAEMaterialCategory;
      AEMaterialMetaData localAEMaterialMetaData;
      do
      {
        Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          do
          {
            if (!localIterator1.hasNext()) {
              break;
            }
            localAEMaterialCategory = (AEMaterialCategory)localIterator1.next();
          } while ((localAEMaterialCategory == null) || (localAEMaterialCategory.jdField_a_of_type_JavaUtilList == null));
          localIterator2 = localAEMaterialCategory.jdField_a_of_type_JavaUtilList.iterator();
        }
        localAEMaterialMetaData = (AEMaterialMetaData)localIterator2.next();
      } while ((localAEMaterialMetaData == null) || (!paramString.equals(localAEMaterialMetaData.k)));
      return localAEMaterialCategory;
    }
    return null;
  }
  
  private ArrayList<QIMSlidingTabView.TabIcon> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      AEMaterialCategory localAEMaterialCategory = (AEMaterialCategory)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localAEMaterialCategory != null)
      {
        if (-1 == localAEMaterialCategory.jdField_a_of_type_Int) {
          this.jdField_a_of_type_Int = i;
        }
        QIMSlidingTabView.TabIcon localTabIcon = new QIMSlidingTabView.TabIcon();
        localTabIcon.a = localAEMaterialCategory.b;
        localArrayList.add(localTabIcon);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private boolean a()
  {
    boolean bool3 = getContext() instanceof QIMCameraCaptureActivity;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      QIMCameraCaptureActivity localQIMCameraCaptureActivity = (QIMCameraCaptureActivity)getContext();
      bool1 = bool2;
      if (localQIMCameraCaptureActivity != null)
      {
        bool1 = bool2;
        if (AECameraEntryManager.k(localQIMCameraCaptureActivity.getIntent())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void c()
  {
    LayoutInflater.from(getContext()).inflate(2064318507, this);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView = ((QIMSlidingTabView)findViewById(2064122720));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView.getViewTreeObserver().addOnScrollChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2064122836));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialTabAdapter = new AEMaterialTabAdapter(getContext(), this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener);
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager = ((AEMaterialManager)AEQIMManager.a(1));
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.b(false);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialTabAdapter.a(new ArrayList());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialTabAdapter);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicCaptureConfigUpdateObserver);
    a(true);
  }
  
  public String a()
  {
    return "AEMaterialProviderView";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager != null)
    {
      if (((getContext() instanceof Activity)) && (AECameraEntryManager.k(((Activity)getContext()).getIntent())))
      {
        this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.e();
        return;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.d();
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("locatePage: ");
      localStringBuilder.append(paramInt);
      AEQLog.b("AEMaterialProviderView", localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder("selectCategoryAndItem");
      ((StringBuilder)localObject1).append(", categoryName=");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(", itemId=");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(", mTabListSize=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.d("AEMaterialProviderView", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      a(true);
    }
    boolean bool = TextUtils.isEmpty(paramString1);
    Object localObject2 = null;
    int m = 0;
    int i;
    if (bool)
    {
      paramString1 = a(paramString2);
      i = this.jdField_a_of_type_JavaUtilList.indexOf(paramString1);
    }
    else
    {
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if ((paramString1 != null) && (paramString1.equals(((AEMaterialCategory)this.jdField_a_of_type_JavaUtilList.get(i)).b)))
        {
          paramString1 = (AEMaterialCategory)this.jdField_a_of_type_JavaUtilList.get(i);
          break label209;
        }
        i += 1;
      }
      paramString1 = null;
      i = 0;
    }
    label209:
    if (paramString1 == null) {
      return;
    }
    int j = 0;
    int k;
    for (;;)
    {
      localObject1 = localObject2;
      k = m;
      if (j >= paramString1.jdField_a_of_type_JavaUtilList.size()) {
        break;
      }
      localObject1 = (AEMaterialMetaData)paramString1.jdField_a_of_type_JavaUtilList.get(j);
      if (((AEMaterialMetaData)localObject1).k.equals(paramString2))
      {
        k = j;
        break;
      }
      j += 1;
    }
    ThreadManager.getUIHandler().post(new AEMaterialProviderView.2(this, i));
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("itemInfo= ");
      paramString1.append(localObject1);
      paramString1.append(",index=");
      paramString1.append(i);
      paramString1.append(",pos=");
      paramString1.append(k);
      QLog.d("AEMaterialProviderView", 2, paramString1.toString());
    }
    if (localObject1 != null)
    {
      this.c = true;
      if (((AEMaterialMetaData)localObject1).a())
      {
        WeishiGuideUtils.a(getContext(), localObject1, 1);
        return;
      }
      postDelayed(new AEMaterialProviderView.3(this, i, (AEMaterialMetaData)localObject1), 200L);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (a()) {
      localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a();
    } else {
      localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(paramBoolean);
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("### updateData: fromCircle = ");
    ((StringBuilder)localObject2).append(a());
    ((StringBuilder)localObject2).append(" | totalList = ");
    ((StringBuilder)localObject2).append(localObject1.toString());
    AEQLog.a("AEMaterialProviderView", ((StringBuilder)localObject2).toString());
    this.jdField_a_of_type_JavaUtilList = new ArrayList((Collection)localObject1);
    int k = this.jdField_a_of_type_Int;
    int j = k;
    if (!paramBoolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
      j = k;
      if (localObject1 != null)
      {
        j = k;
        if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialTabAdapter != null)
        {
          j = k;
          if (!this.b)
          {
            i = ((QQViewPager)localObject1).getCurrentItem();
            localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialTabAdapter.a(i);
            j = k;
            if (localObject1 != null)
            {
              i = 0;
              for (;;)
              {
                j = k;
                if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
                  break;
                }
                localObject2 = (AEMaterialCategory)this.jdField_a_of_type_JavaUtilList.get(i);
                if ((localObject2 != null) && (!TextUtils.isEmpty(((AEMaterialCategory)localObject2).b)) && (((AEMaterialCategory)localObject2).b.equals(((AEMaterialCategory)localObject1).b)))
                {
                  j = i;
                  break;
                }
                i += 1;
              }
            }
          }
          this.b = false;
        }
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialTabAdapter;
    if (localObject1 != null)
    {
      ((AEMaterialTabAdapter)localObject1).a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialTabAdapter.notifyDataSetChanged();
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
    if (localObject1 != null) {
      ((QQViewPager)localObject1).setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialTabAdapter);
    }
    localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView;
    if (localObject1 != null)
    {
      ((QIMSlidingTabView)localObject1).initTabItemsWithRedDot(a());
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    }
    int i = j;
    if (j >= this.jdField_a_of_type_JavaUtilList.size())
    {
      i = j;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("resetPos ");
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append(" not exist, mTabList size = ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilList.size());
        QLog.d("AEMaterialProviderView", 2, ((StringBuilder)localObject1).toString());
        i = 0;
      }
    }
    if ((!this.c) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView != null)) {
      a(i);
    }
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager;
    if (localObject != null)
    {
      ((AEMaterialManager)localObject).f();
      this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(111);
      this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(113);
      this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(112);
    }
    localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localObject != null) {
      ((AppInterface)localObject).unRegistObserver(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicCaptureConfigUpdateObserver);
    }
  }
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if ((paramInt == 114) && (paramVarArgs != null) && (paramVarArgs.length != 1)) {}
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView.onTabChecked(paramInt);
  }
  
  public void onScrollChanged() {}
  
  @TargetApi(9)
  public void onTabChecked(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialProviderView
 * JD-Core Version:    0.7.0.1
 */