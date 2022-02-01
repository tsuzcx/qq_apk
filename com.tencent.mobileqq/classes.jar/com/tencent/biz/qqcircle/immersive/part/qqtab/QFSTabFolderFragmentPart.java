package com.tencent.biz.qqcircle.immersive.part.qqtab;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.QFSMainFragment;
import com.tencent.biz.qqcircle.immersive.adapter.QFSMultiTabFragmentAdapter;
import com.tencent.biz.qqcircle.immersive.ioc.IQFSFolderIoc;
import com.tencent.biz.qqcircle.immersive.part.QFSBasePart;
import com.tencent.biz.qqcircle.richframework.widget.ViewPagerCompat;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class QFSTabFolderFragmentPart
  extends QFSBasePart
  implements IQFSFolderIoc, SimpleEventReceiver
{
  private final PartManager a;
  private ViewPagerCompat b;
  private QFSMultiTabFragmentAdapter c;
  private final ArrayList<QFSBaseFragment> d = new ArrayList();
  private int e = 0;
  private QFSMainFragment f;
  
  public QFSTabFolderFragmentPart(PartManager paramPartManager)
  {
    this.a = paramPartManager;
    QCircleHostGlobalInfo.setFolderUIType(3);
  }
  
  private void a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      if (!(paramVarArgs[0] instanceof Boolean)) {
        return;
      }
      ViewPagerCompat localViewPagerCompat = this.b;
      if (localViewPagerCompat != null) {
        localViewPagerCompat.setScrollable(((Boolean)paramVarArgs[0]).booleanValue());
      }
    }
  }
  
  private void d()
  {
    this.f = new QFSMainFragment();
    this.f.a(this);
    this.f.p().a(this.a);
    this.d.add(this.f);
  }
  
  private void e()
  {
    this.b.addOnPageChangeListener(new QFSTabFolderFragmentPart.1(this));
  }
  
  public String a()
  {
    return "QFSFolderFragmentPart";
  }
  
  public void a(View paramView)
  {
    this.c = new QFSMultiTabFragmentAdapter(m().getChildFragmentManager());
    this.b = ((ViewPagerCompat)paramView.findViewById(2131433851));
    this.b.setAdapter(this.c);
    this.b.setOffscreenPageLimit(3);
    this.b.setScrollable(false);
    e();
    d();
    this.c.a(this.d);
    this.c.notifyDataSetChanged();
  }
  
  public void a(String paramString, Object... paramVarArgs)
  {
    if (TextUtils.equals(paramString, "event_set_viewpager_enable")) {
      a(paramVarArgs);
    }
  }
  
  public boolean ah_()
  {
    Object localObject = this.b;
    if (localObject == null) {
      return false;
    }
    if (((ViewPagerCompat)localObject).getCurrentItem() != 0)
    {
      this.b.setCurrentItem(0);
      return true;
    }
    localObject = this.d.iterator();
    while (((Iterator)localObject).hasNext())
    {
      QFSBaseFragment localQFSBaseFragment = (QFSBaseFragment)((Iterator)localObject).next();
      if ((localQFSBaseFragment != null) && (localQFSBaseFragment.onBackEvent())) {
        return true;
      }
    }
    return false;
  }
  
  public Object b(String paramString, Object paramObject)
  {
    return super.b(paramString, paramObject);
  }
  
  public int f()
  {
    ViewPagerCompat localViewPagerCompat = this.b;
    if (localViewPagerCompat != null) {
      return localViewPagerCompat.getCurrentItem();
    }
    return -1;
  }
  
  public ArrayList<Class> getEventClass()
  {
    return null;
  }
  
  public void k()
  {
    super.k();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      QFSBaseFragment localQFSBaseFragment = (QFSBaseFragment)localIterator.next();
      if (localQFSBaseFragment != null) {
        localQFSBaseFragment.beforeFinish();
      }
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    if (this.d == null) {
      return;
    }
    QLog.d("QFSFolderFragmentPart", 1, "fs_lifecycle onActivityDestroyed");
    paramActivity = this.d.iterator();
    while (paramActivity.hasNext()) {
      ((QFSBaseFragment)paramActivity.next()).onDestroy();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    if (this.b != null)
    {
      if (this.d == null) {
        return;
      }
      paramActivity = new StringBuilder();
      paramActivity.append("fs_lifecycle onActivityPaused  mFolderViewPagerIndex = ");
      paramActivity.append(this.b.getCurrentItem());
      QLog.d("QFSFolderFragmentPart", 1, paramActivity.toString());
      if (this.d.size() > this.b.getCurrentItem()) {
        ((QFSBaseFragment)this.d.get(this.b.getCurrentItem())).onPause();
      }
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if (this.b != null)
    {
      if (this.d == null) {
        return;
      }
      paramActivity = new StringBuilder();
      paramActivity.append("fs_lifecycle onActivityResumed  mFolderViewPagerIndex = ");
      paramActivity.append(this.b.getCurrentItem());
      QLog.d("QFSFolderFragmentPart", 1, paramActivity.toString());
      if (this.d.size() > this.b.getCurrentItem()) {
        ((QFSBaseFragment)this.d.get(this.b.getCurrentItem())).onResume();
      }
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
    if (this.b != null)
    {
      if (this.d == null) {
        return;
      }
      paramActivity = new StringBuilder();
      paramActivity.append("fs_lifecycle onActivityStopped  mFolderViewPagerIndex = ");
      paramActivity.append(this.b.getCurrentItem());
      QLog.d("QFSFolderFragmentPart", 1, paramActivity.toString());
      if (this.d.size() > this.b.getCurrentItem()) {
        ((QFSBaseFragment)this.d.get(this.b.getCurrentItem())).onStop();
      }
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.qqtab.QFSTabFolderFragmentPart
 * JD-Core Version:    0.7.0.1
 */