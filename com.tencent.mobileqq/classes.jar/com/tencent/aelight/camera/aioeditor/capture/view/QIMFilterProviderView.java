package com.tencent.aelight.camera.aioeditor.capture.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.ComboFilterData;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.DataSet;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.adapter.FilterProviderGridAdapter;
import com.tencent.aelight.camera.aioeditor.capture.adapter.FilterProviderPagerAdapter;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager.CaptureComboListener;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager.CaptureRecord;
import com.tencent.aelight.camera.aioeditor.capture.data.ComboSet;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterCategory;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterSet;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.music.QimMusicPlayer;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.mobileqq.filter.QQFilterRenderManagerHolder;
import com.tencent.mobileqq.widget.bounce.BounceViewPager;
import com.tencent.mobileqq.widget.bounce.BounceViewPager.PageChangedObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.List;

public class QIMFilterProviderView
  extends ProviderView
  implements CaptureComboManager.CaptureComboListener, QIMSlidingTabView.IOnTabCheckListener, BounceViewPager.PageChangedObserver, AdapterView.OnItemClickListener
{
  BounceViewPager a;
  FilterProviderPagerAdapter b;
  public ArrayList<FilterCategory> c;
  public int d = 0;
  public VideoFilterTools.DataSet e;
  public int f = 0;
  
  public QIMFilterProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void c(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle = paramBundle.getBundle(QIMFilterProviderView.class.getSimpleName());
    } else {
      paramBundle = null;
    }
    if (paramBundle != null)
    {
      if (VideoFilterTools.a().d[this.D] != null) {
        VideoFilterTools.a().d[this.D].o = 1;
      }
      paramBundle = (QIMFilterCategoryItem)paramBundle.getParcelable("selected_filter_item");
      if (paramBundle != null)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("restore ");
          localStringBuilder.append(paramBundle.a);
          QLog.d("FilterProviderView", 2, localStringBuilder.toString());
        }
        paramBundle.o = 1;
      }
    }
  }
  
  public void a()
  {
    super.a();
    Object localObject = this.a;
    if (localObject != null) {
      ((BounceViewPager)localObject).b(this);
    }
    VideoFilterTools.a();
    VideoFilterTools.a(true);
    if (QIMManager.a().c(5))
    {
      localObject = (CaptureComboManager)QIMManager.a(5);
      localObject.o[this.D].b();
      ((CaptureComboManager)localObject).b(this);
    }
    if (QLog.isColorLevel()) {
      QLog.d("FilterProviderView", 2, "onDestroy");
    }
  }
  
  public void a(int paramInt)
  {
    this.v.onTabChecked(paramInt);
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("category= ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" categoryName= ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",itemId=");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("FilterProviderView", 2, ((StringBuilder)localObject).toString());
    }
    int k = 0;
    int i = 0;
    while (i < this.c.size())
    {
      if (((paramInt != -1) && (((FilterCategory)this.c.get(i)).a == paramInt)) || ((paramString1 != null) && (paramString1.equals(((FilterCategory)this.c.get(i)).b)))) {
        break label157;
      }
      i += 1;
    }
    i = 0;
    label157:
    getmBottomTabBar().onTabChecked(i);
    FilterCategory localFilterCategory = (FilterCategory)this.c.get(h());
    Object localObject = null;
    paramInt = 0;
    int j;
    for (;;)
    {
      j = k;
      paramString1 = (String)localObject;
      if (paramInt >= localFilterCategory.c.size()) {
        break;
      }
      paramString1 = (QIMFilterCategoryItem)localFilterCategory.c.get(paramInt);
      if (paramString1.a.equals(paramString2))
      {
        j = paramInt;
        break;
      }
      paramInt += 1;
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("itemInfo= ");
      paramString2.append(paramString1);
      paramString2.append(",index=");
      paramString2.append(i);
      paramString2.append(",pos=");
      paramString2.append(j);
      QLog.d("FilterProviderView", 2, paramString2.toString());
    }
    if (paramString1 != null)
    {
      postDelayed(new QIMFilterProviderView.1(this, j), 200L);
      paramString2 = (CaptureComboManager)QIMManager.a(5);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("apply_source", 1);
      ((Bundle)localObject).putInt("capture_scene", this.D);
      paramString2.a(paramString1, (Activity)getContext(), (Bundle)localObject);
      g();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.v.setTabCheckListener(this);
    if (this.w == null) {
      this.a = ((BounceViewPager)LayoutInflater.from(getContext()).inflate(2131627201, this, false));
    } else {
      this.a = ((BounceViewPager)this.w);
    }
    this.b = new FilterProviderPagerAdapter(this.r, this.D);
    this.b.a(this);
    this.b.a(new ArrayList());
    this.a.a(this);
    this.a.setAdapter(this.b);
    a(this.a);
    paramBundle = (CaptureComboManager)QIMManager.a(5);
    paramBundle.a(this);
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "FilterProviderView onCreate");
    }
    paramBundle = paramBundle.l;
    if (paramBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FilterProviderView", 2, "filterProviderView get data is null");
      }
    }
    else {
      setup(paramBundle.a(this.D));
    }
  }
  
  public void a(VideoFilterTools.ComboFilterData paramComboFilterData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onComboFilterDataUpdated data:");
      boolean bool;
      if (paramComboFilterData == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("FilterProviderView", 2, localStringBuilder.toString());
    }
    if (paramComboFilterData != null) {
      setup(paramComboFilterData.a(this.D));
    }
  }
  
  public void a(ComboSet paramComboSet) {}
  
  public void a(ComboSet paramComboSet, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("fp onComboApply combo ");
      paramBundle.append(paramComboSet.e);
      paramBundle.append(" filter ");
      QLog.i("QCombo", 2, paramBundle.toString());
    }
    g();
  }
  
  public void a(FilterSet paramFilterSet, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (this.F != null) {
      this.F.b(true);
    }
    g();
    if (paramBoolean)
    {
      paramFilterSet = (QimMusicPlayer)QIMManager.a().d(8);
      if (this.D == 0) {
        paramInt = QQFilterRenderManagerHolder.b;
      } else {
        paramInt = QQFilterRenderManagerHolder.c;
      }
      paramFilterSet.c(paramInt);
      paramFilterSet.k();
    }
  }
  
  public void b()
  {
    super.b();
    Object localObject2 = this.e;
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      VideoFilterTools.ComboFilterData localComboFilterData = localCaptureComboManager.l;
      localObject1 = localObject2;
      if (localComboFilterData != null) {
        localObject1 = localComboFilterData.a(this.D);
      }
    }
    if ((localObject1 != null) && (((VideoFilterTools.DataSet)localObject1).f != null))
    {
      localObject2 = (Activity)getContext();
      localCaptureComboManager.b(((VideoFilterTools.DataSet)localObject1).f).a((Activity)localObject2, this.D);
      VideoFilterTools.a().b(((VideoFilterTools.DataSet)localObject1).f, (Activity)getContext(), this.D);
      VideoFilterTools.a().a(((VideoFilterTools.DataSet)localObject1).f, this.D);
      g();
      onItemClick(null, null, 0, 0L);
    }
  }
  
  public void b(int paramInt) {}
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    c(paramBundle);
  }
  
  public void c()
  {
    super.c();
    if (this.F != null)
    {
      this.F.b(true);
      this.F.c();
    }
    g();
  }
  
  public void d()
  {
    super.d();
    if (this.F != null) {
      this.F.b(false);
    }
  }
  
  public void e()
  {
    super.e();
    ((CaptureComboManager)QIMManager.a(5)).a(this);
  }
  
  public void f()
  {
    super.f();
    ((CaptureComboManager)QIMManager.a(5)).b(this);
  }
  
  public void g()
  {
    if (!this.B) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "FilterProviderView updateSelectedState");
    }
    int i = 0;
    int j = this.b.c.size();
    while (i < j)
    {
      int k = this.b.c.keyAt(i);
      ListAdapter localListAdapter = ((GridView)this.b.c.get(k)).getAdapter();
      if ((localListAdapter instanceof FilterProviderGridAdapter)) {
        ((FilterProviderGridAdapter)localListAdapter).notifyDataSetChanged();
      }
      i += 1;
    }
  }
  
  protected int getInflateLayout()
  {
    return 2131627201;
  }
  
  public ArrayList<QIMSlidingTabView.TabIcon> getTabTextList()
  {
    ArrayList localArrayList = new ArrayList();
    int j = VideoFilterTools.a().f();
    int i = 0;
    while (i < this.c.size())
    {
      QIMSlidingTabView.TabIcon localTabIcon = new QIMSlidingTabView.TabIcon();
      localTabIcon.a = ((FilterCategory)this.c.get(i)).b;
      VideoFilterTools.a();
      localTabIcon.b = VideoFilterTools.a(2, ((FilterCategory)this.c.get(i)).a, "");
      localArrayList.add(localTabIcon);
      if ((j != -1) && (j == ((FilterCategory)this.c.get(i)).a))
      {
        this.f = i;
        VideoFilterTools.a().b(5, 0, null);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public int h()
  {
    BounceViewPager localBounceViewPager = this.a;
    if (localBounceViewPager == null) {
      return 0;
    }
    return localBounceViewPager.getCurrentItem();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView != null) {
      paramAdapterView = paramView.getTag();
    } else {
      paramAdapterView = null;
    }
    if ((paramAdapterView != null) && ((paramAdapterView instanceof QIMFilterCategoryItem)))
    {
      paramAdapterView = (QIMFilterCategoryItem)paramAdapterView;
    }
    else
    {
      paramAdapterView = this.c;
      if (paramAdapterView == null) {
        return;
      }
      paramView = (QIMFilterCategoryItem)((FilterCategory)paramAdapterView.get(h())).c.get(paramInt);
      paramAdapterView = paramView;
      if (paramView == null) {
        return;
      }
    }
    if (paramAdapterView.g())
    {
      WeishiGuideUtils.a(this.r, paramAdapterView, 2);
      return;
    }
    if ((paramLong > 0L) && (this.F != null)) {
      this.F.a(-1, paramAdapterView);
    }
    paramView = (CaptureComboManager)QIMManager.a(5);
    Bundle localBundle = new Bundle();
    localBundle.putInt("apply_source", 1);
    localBundle.putInt("capture_scene", this.D);
    paramView.a(paramAdapterView, (Activity)getContext(), localBundle);
    ((CaptureComboManager)QIMManager.a(5)).a(this.D, (Activity)this.r);
  }
  
  public void onTabChecked(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt > this.c.size()) {
        return;
      }
      this.a.setCurrentItem(paramInt);
      VideoFilterTools.a().b(2, ((FilterCategory)this.c.get(paramInt)).a, "");
    }
  }
  
  public void setup(VideoFilterTools.DataSet paramDataSet)
  {
    if (this.v == null) {
      return;
    }
    this.e = paramDataSet;
    this.c = paramDataSet.b;
    this.v.initTabItemsWithRedDot(getTabTextList());
    this.b = new FilterProviderPagerAdapter(this.r, this.D);
    this.b.a(this);
    this.b.a(this.c);
    this.a.setAdapter(this.b);
    this.b.notifyDataSetChanged();
    int i = this.c.size();
    int j = this.f;
    if (i > j)
    {
      this.a.setCurrentItem(j);
      this.v.onTabChecked(this.f);
    }
    this.b.notifyDataSetChanged();
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.QIMFilterProviderView
 * JD-Core Version:    0.7.0.1
 */