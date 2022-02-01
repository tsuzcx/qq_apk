package com.tencent.aelight.camera.aioeditor.capture.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.ComboFilterData;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.DataSet;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.adapter.ComboProviderGridAdapter;
import com.tencent.aelight.camera.aioeditor.capture.adapter.ComboProviderPagerAdapter;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager.CaptureComboListener;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboObeserver;
import com.tencent.aelight.camera.aioeditor.capture.data.ComboLockManager;
import com.tencent.aelight.camera.aioeditor.capture.data.ComboSet;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterCategory;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterSet;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.paster.PasterDataManager;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.widget.bounce.BounceViewPager;
import com.tencent.mobileqq.widget.bounce.BounceViewPager.PageChangedObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComboProviderView
  extends ProviderView
  implements Handler.Callback, CaptureComboManager.CaptureComboListener, QIMSlidingTabView.IOnTabCheckListener, BounceViewPager.PageChangedObserver, AdapterView.OnItemClickListener
{
  BounceViewPager a;
  ComboProviderPagerAdapter b;
  ArrayList<FilterCategory> c;
  public Handler d = new Handler(Looper.getMainLooper(), this);
  public VideoFilterTools.DataSet e;
  CaptureComboObeserver f = new ComboProviderView.1(this);
  public int g = 0;
  
  public ComboProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void c(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle = paramBundle.getBundle(ComboProviderView.class.getSimpleName());
    } else {
      paramBundle = null;
    }
    if (paramBundle != null)
    {
      paramBundle = (QIMFilterCategoryItem)paramBundle.getParcelable("select_filter_item");
      if (paramBundle != null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("restore ");
          ((StringBuilder)localObject).append(paramBundle.a);
          QLog.d("ComboProviderView", 2, ((StringBuilder)localObject).toString());
        }
        Object localObject = (CaptureComboManager)QIMManager.a(5);
        if (((this.D == 2) || (this.D == 1)) && (VideoFilterTools.a().e[this.D] == null)) {
          VideoFilterTools.a().e[this.D] = ((CaptureComboManager)localObject).c(paramBundle);
        }
        paramBundle = ((CaptureComboManager)localObject).l;
        if (paramBundle != null) {
          this.e = paramBundle.a(this.D);
        }
      }
    }
  }
  
  public void a()
  {
    super.a();
    Object localObject = this.d;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.d = null;
    }
    if (this.s != null) {
      this.s.unRegistObserver(this.f);
    }
    localObject = this.a;
    if (localObject != null) {
      ((BounceViewPager)localObject).b(this);
    }
    if (QIMManager.a().c(5)) {
      ((CaptureComboManager)QIMManager.a(5)).b(this);
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
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("category= ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" categoryName= ");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(",itemId=");
      ((StringBuilder)localObject1).append(paramString2);
      QLog.d("ComboProviderView", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.c == null)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("selectCategoryAndItem when mTagInfos null ");
        paramString1.append(paramInt);
        paramString1.append(" ");
        paramString1.append(paramString2);
        QLog.e("ComboProviderView", 2, paramString1.toString());
      }
      return;
    }
    int k = 0;
    int i = 0;
    while (i < this.c.size())
    {
      if (((paramInt != -1) && (((FilterCategory)this.c.get(i)).a == paramInt)) || ((paramString1 != null) && (paramString1.equals(((FilterCategory)this.c.get(i)).b)))) {
        break label215;
      }
      i += 1;
    }
    i = 0;
    label215:
    getmBottomTabBar().onTabChecked(i);
    Object localObject2 = (FilterCategory)this.c.get(h());
    Object localObject1 = null;
    paramInt = 0;
    int j;
    for (;;)
    {
      j = k;
      paramString1 = (String)localObject1;
      if (paramInt >= ((FilterCategory)localObject2).c.size()) {
        break;
      }
      paramString1 = (QIMFilterCategoryItem)((FilterCategory)localObject2).c.get(paramInt);
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
      QLog.d("ComboProviderView", 2, paramString2.toString());
    }
    if (paramString1 == null) {
      return;
    }
    if (paramString1.g())
    {
      WeishiGuideUtils.a(this.r, paramString1, 2);
      return;
    }
    postDelayed(new ComboProviderView.2(this, j), 500L);
    paramString2 = (CaptureComboManager)QIMManager.a(5);
    localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("apply_source", 1);
    ((Bundle)localObject1).putInt("capture_scene", this.D);
    localObject2 = paramString2.c(paramString1);
    if ((((ComboSet)localObject2).b == 1) || (((ComboSet)localObject2).b == 2)) {
      QIMCommonLoadingProgress.a(localObject2).a();
    }
    paramString2.b(paramString1, (Activity)getContext(), (Bundle)localObject1);
    g();
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("selectFilterItem state = ");
      paramString2.append(paramString1);
      QLog.i("ComboProviderView", 2, paramString2.toString());
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
    this.b = new ComboProviderPagerAdapter(this.r, this.D);
    this.b.a(this);
    this.b.a(new ArrayList());
    this.a.a(this);
    this.a.setAdapter(this.b);
    a(this.a);
    this.s.registObserver(this.f);
    paramBundle = (CaptureComboManager)QIMManager.a(5);
    paramBundle.a(this);
    paramBundle.i().a(this.D);
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "ComboProviderView onCreate");
    }
    paramBundle = paramBundle.l;
    if (paramBundle != null) {
      setup(paramBundle.a(this.D));
    }
    paramBundle = (PasterDataManager)QIMManager.a().d(4);
    paramBundle.a();
    paramBundle.a(true, (Activity)getContext());
  }
  
  public void a(VideoFilterTools.ComboFilterData paramComboFilterData)
  {
    setup(paramComboFilterData.a(this.D));
  }
  
  public void a(ComboSet paramComboSet) {}
  
  public void a(ComboSet paramComboSet, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    g();
  }
  
  public void a(FilterSet paramFilterSet, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    int k = paramQIMFilterCategoryItem.e;
    int j = 0;
    int i = 0;
    while (i < this.c.size())
    {
      if (((FilterCategory)this.c.get(i)).a == k) {
        break label52;
      }
      i += 1;
    }
    i = 0;
    label52:
    if (this.a.getCurrentItem() != i) {
      this.a.setCurrentItem(i);
    }
    Iterator localIterator = ((FilterCategory)this.c.get(i)).c.iterator();
    i = j;
    while ((localIterator.hasNext()) && (!((QIMFilterCategoryItem)localIterator.next()).a.equals(paramQIMFilterCategoryItem.a))) {
      i += 1;
    }
    paramQIMFilterCategoryItem = this.b.a(this.a.getCurrentItem());
    if (paramQIMFilterCategoryItem != null)
    {
      paramQIMFilterCategoryItem.setSelection(i);
      ((ComboProviderGridAdapter)paramQIMFilterCategoryItem.getAdapter()).a();
    }
  }
  
  public void b()
  {
    super.b();
    if (this.e != null)
    {
      CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
      Activity localActivity = (Activity)getContext();
      VideoFilterTools.DataSet localDataSet = localCaptureComboManager.l.a(this.D);
      if (localDataSet.e != null) {
        localCaptureComboManager.c(localDataSet.e).a(localActivity, this.D);
      }
      VideoFilterTools.a().a(localDataSet.e, localActivity, this.D);
      g();
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
    QIMFilterCategoryItem localQIMFilterCategoryItem = ((CaptureComboManager)QIMManager.a(5)).i().i;
    if (localQIMFilterCategoryItem != null) {
      a(localQIMFilterCategoryItem);
    }
  }
  
  public void e()
  {
    super.e();
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
    g();
  }
  
  public void f()
  {
    VideoFilterTools.a();
    VideoFilterTools.a(true);
    super.f();
    if (QIMManager.a().c(5)) {
      ((CaptureComboManager)QIMManager.a(5)).a(this.D, (Activity)getContext());
    }
  }
  
  public void g()
  {
    if (!this.B) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "ComboProviderView updateComboState");
    }
    int i = 0;
    int j = this.b.c.size();
    while (i < j)
    {
      int k = this.b.c.keyAt(i);
      ListAdapter localListAdapter = ((GridView)this.b.c.get(k)).getAdapter();
      if ((localListAdapter instanceof ComboProviderGridAdapter)) {
        ((ComboProviderGridAdapter)localListAdapter).notifyDataSetChanged();
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
    int j = VideoFilterTools.a().g();
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
        this.g = i;
        VideoFilterTools.a().b(7, 0, null);
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
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = h();
    paramAdapterView = (QIMFilterCategoryItem)((FilterCategory)this.c.get(i)).c.get(paramInt);
    if (paramAdapterView.g())
    {
      WeishiGuideUtils.a(this.r, paramAdapterView, 2);
      return;
    }
    if ((paramLong > 0L) && (this.F != null)) {
      this.F.a(-1, paramAdapterView);
    }
    paramView = (CaptureComboManager)QIMManager.a(5);
    Object localObject = paramAdapterView.a;
    if (paramView.i().a((String)localObject, getContext())) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("apply_source", 1);
    localBundle.putInt("capture_scene", this.D);
    localObject = paramView.c(paramAdapterView);
    if ((((ComboSet)localObject).b == 1) || (((ComboSet)localObject).b == 2)) {
      QIMCommonLoadingProgress.a(localObject).a();
    }
    paramView.b(paramAdapterView, (Activity)getContext(), localBundle);
    if ((SlideShowPhotoListManager.a().e() == 22) && (paramAdapterView.h != null) && (paramAdapterView.h.isEmpty())) {
      LpReportInfo_pf00064.allReport(680, 6, 1);
    }
    if ((SlideShowPhotoListManager.a().e() == 22) && (paramAdapterView.h != null) && (!paramAdapterView.h.isEmpty())) {
      LpReportInfo_pf00064.allReport(680, 6, 2);
    }
    g();
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onItemClick combo ");
      paramView.append(i);
      paramView.append(",");
      paramView.append(paramInt);
      paramView.append(", combo ");
      paramView.append(localObject);
      QLog.i("QCombo", 2, paramView.toString());
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onItemClick state = ");
      paramView.append(paramAdapterView);
      QLog.i("QCombo", 2, paramView.toString());
    }
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
    this.e = paramDataSet;
    this.c = paramDataSet.a;
    this.v.initTabItemsWithRedDot(getTabTextList());
    this.b = new ComboProviderPagerAdapter(this.r, this.D);
    this.b.a(this);
    this.b.a(this.c);
    this.a.setAdapter(this.b);
    this.b.notifyDataSetChanged();
    int i = this.c.size();
    int j = this.g;
    if (i > j)
    {
      this.a.setCurrentItem(j);
      this.v.onTabChecked(this.g);
    }
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.ComboProviderView
 * JD-Core Version:    0.7.0.1
 */