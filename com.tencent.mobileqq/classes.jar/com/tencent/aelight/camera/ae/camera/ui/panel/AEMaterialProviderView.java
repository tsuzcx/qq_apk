package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
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

@SuppressLint({"ViewConstructor"})
public class AEMaterialProviderView
  extends FrameLayout
  implements ViewTreeObserver.OnScrollChangedListener, ViewPager.OnPageChangeListener, QIMSlidingTabView.IOnTabCheckListener, Observer
{
  public CaptureConfigUpdateObserver a = new AEMaterialProviderView.1(this);
  private AppInterface b = AECaptureContext.a();
  private QIMSlidingTabView c;
  private List<AEMaterialCategory> d = new CopyOnWriteArrayList();
  private QQViewPager e;
  private AEMaterialTabAdapter f;
  private AEMaterialManager g;
  private AEMaterialPanel.AEMaterialPanelListener h;
  private boolean i = false;
  private boolean j = true;
  private boolean k = false;
  private int l = 1;
  
  public AEMaterialProviderView(Context paramContext, AEMaterialPanel.AEMaterialPanelListener paramAEMaterialPanelListener)
  {
    super(paramContext);
    this.h = paramAEMaterialPanelListener;
    c();
  }
  
  private AEMaterialCategory a(String paramString)
  {
    if (this.d != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      AEMaterialCategory localAEMaterialCategory;
      AEMaterialMetaData localAEMaterialMetaData;
      do
      {
        Iterator localIterator1 = this.d.iterator();
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          do
          {
            if (!localIterator1.hasNext()) {
              break;
            }
            localAEMaterialCategory = (AEMaterialCategory)localIterator1.next();
          } while ((localAEMaterialCategory == null) || (localAEMaterialCategory.a == null));
          localIterator2 = localAEMaterialCategory.a.iterator();
        }
        localAEMaterialMetaData = (AEMaterialMetaData)localIterator2.next();
      } while ((localAEMaterialMetaData == null) || (!paramString.equals(localAEMaterialMetaData.m)));
      return localAEMaterialCategory;
    }
    return null;
  }
  
  private void c()
  {
    LayoutInflater.from(getContext()).inflate(2064056374, this);
    this.c = ((QIMSlidingTabView)findViewById(2063991500));
    this.c.setIndicateColor(getContext().getResources().getColor(2131167113));
    this.c.setTabCheckListener(this);
    this.c.getViewTreeObserver().addOnScrollChangedListener(this);
    this.e = ((QQViewPager)findViewById(2063991610));
    this.f = new AEMaterialTabAdapter(getContext(), this.h);
    this.g = ((AEMaterialManager)AEQIMManager.a(1));
    this.g.b(false);
    this.f.a(new ArrayList());
    this.e.setOnPageChangeListener(this);
    this.e.setAdapter(this.f);
    this.b.registObserver(this.a);
    a(true);
  }
  
  private boolean d()
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
        if (AECameraEntryManager.o(localQIMCameraCaptureActivity.getIntent())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private ArrayList<QIMSlidingTabView.TabIcon> getTabNameList()
  {
    ArrayList localArrayList = new ArrayList();
    int m = 0;
    while (m < this.d.size())
    {
      AEMaterialCategory localAEMaterialCategory = (AEMaterialCategory)this.d.get(m);
      if (localAEMaterialCategory != null)
      {
        if (-1 == localAEMaterialCategory.b) {
          this.l = m;
        }
        QIMSlidingTabView.TabIcon localTabIcon = new QIMSlidingTabView.TabIcon();
        localTabIcon.a = localAEMaterialCategory.d;
        localArrayList.add(localTabIcon);
      }
      m += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (this.g != null)
    {
      if (((getContext() instanceof Activity)) && (AECameraEntryManager.o(((Activity)getContext()).getIntent())))
      {
        this.g.i();
        return;
      }
      this.g.h();
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.e != null) && (this.c != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("locatePage: ");
      localStringBuilder.append(paramInt);
      AEQLog.b("AEMaterialProviderView", localStringBuilder.toString());
      this.e.setCurrentItem(paramInt);
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
      ((StringBuilder)localObject1).append(this.d.size());
      QLog.d("AEMaterialProviderView", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.d.isEmpty()) {
      a(true);
    }
    boolean bool = TextUtils.isEmpty(paramString1);
    Object localObject2 = null;
    int i2 = 0;
    int m;
    if (bool)
    {
      paramString1 = a(paramString2);
      m = this.d.indexOf(paramString1);
    }
    else
    {
      m = 0;
      while (m < this.d.size())
      {
        if ((paramString1 != null) && (paramString1.equals(((AEMaterialCategory)this.d.get(m)).d)))
        {
          paramString1 = (AEMaterialCategory)this.d.get(m);
          break label210;
        }
        m += 1;
      }
      paramString1 = null;
      m = 0;
    }
    label210:
    if (paramString1 == null) {
      return;
    }
    int n = 0;
    int i1;
    for (;;)
    {
      localObject1 = localObject2;
      i1 = i2;
      if (n >= paramString1.a.size()) {
        break;
      }
      localObject1 = (AEMaterialMetaData)paramString1.a.get(n);
      if (((AEMaterialMetaData)localObject1).m.equals(paramString2))
      {
        i1 = n;
        break;
      }
      n += 1;
    }
    ThreadManager.getUIHandler().post(new AEMaterialProviderView.2(this, m));
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("itemInfo= ");
      paramString1.append(localObject1);
      paramString1.append(",index=");
      paramString1.append(m);
      paramString1.append(",pos=");
      paramString1.append(i1);
      QLog.d("AEMaterialProviderView", 2, paramString1.toString());
    }
    if (localObject1 != null)
    {
      this.k = true;
      if (((AEMaterialMetaData)localObject1).a())
      {
        WeishiGuideUtils.a(getContext(), localObject1, 1);
        return;
      }
      postDelayed(new AEMaterialProviderView.3(this, m, (AEMaterialMetaData)localObject1), 200L);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (d()) {
      localObject1 = this.g.c();
    } else {
      localObject1 = this.g.c(paramBoolean);
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("### updateData: fromCircle = ");
    ((StringBuilder)localObject2).append(d());
    ((StringBuilder)localObject2).append(" | totalList = ");
    ((StringBuilder)localObject2).append(localObject1.toString());
    AEQLog.a("AEMaterialProviderView", ((StringBuilder)localObject2).toString());
    this.d = new ArrayList((Collection)localObject1);
    int i1 = this.l;
    int n = i1;
    if (!paramBoolean)
    {
      localObject1 = this.e;
      n = i1;
      if (localObject1 != null)
      {
        n = i1;
        if (this.f != null)
        {
          n = i1;
          if (!this.j)
          {
            m = ((QQViewPager)localObject1).getCurrentItem();
            localObject1 = this.f.a(m);
            n = i1;
            if (localObject1 != null)
            {
              m = 0;
              for (;;)
              {
                n = i1;
                if (m >= this.d.size()) {
                  break;
                }
                localObject2 = (AEMaterialCategory)this.d.get(m);
                if ((localObject2 != null) && (!TextUtils.isEmpty(((AEMaterialCategory)localObject2).d)) && (((AEMaterialCategory)localObject2).d.equals(((AEMaterialCategory)localObject1).d)))
                {
                  n = m;
                  break;
                }
                m += 1;
              }
            }
          }
          this.j = false;
        }
      }
    }
    Object localObject1 = this.f;
    if (localObject1 != null)
    {
      ((AEMaterialTabAdapter)localObject1).a(this.d);
      this.f.notifyDataSetChanged();
    }
    localObject1 = this.e;
    if (localObject1 != null) {
      ((QQViewPager)localObject1).setAdapter(this.f);
    }
    localObject1 = this.c;
    if (localObject1 != null)
    {
      ((QIMSlidingTabView)localObject1).initTabItemsWithRedDot(getTabNameList());
      this.c.setTabCheckListener(this);
    }
    int m = n;
    if (n >= this.d.size())
    {
      m = n;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("resetPos ");
        ((StringBuilder)localObject1).append(n);
        ((StringBuilder)localObject1).append(" not exist, mTabList size = ");
        ((StringBuilder)localObject1).append(this.d.size());
        QLog.d("AEMaterialProviderView", 2, ((StringBuilder)localObject1).toString());
        m = 0;
      }
    }
    if ((!this.k) && (this.d.size() > 0) && (this.e != null) && (this.c != null)) {
      a(m);
    }
  }
  
  public void b()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      ((AEMaterialManager)localObject).k();
      this.g.a(111);
      this.g.a(113);
      this.g.a(112);
    }
    localObject = this.b;
    if (localObject != null) {
      ((AppInterface)localObject).unRegistObserver(this.a);
    }
  }
  
  public AEMaterialManager getManager()
  {
    return this.g;
  }
  
  public String getTag()
  {
    return "AEMaterialProviderView";
  }
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if ((paramInt == 114) && (paramVarArgs != null) && (paramVarArgs.length != 1)) {}
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.c.onTabChecked(paramInt);
    AEMaterialTabAdapter localAEMaterialTabAdapter = this.f;
    if (localAEMaterialTabAdapter != null) {
      localAEMaterialTabAdapter.b(paramInt);
    }
  }
  
  public void onScrollChanged() {}
  
  @TargetApi(9)
  public void onTabChecked(int paramInt)
  {
    this.e.setCurrentItem(paramInt);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialProviderView
 * JD-Core Version:    0.7.0.1
 */