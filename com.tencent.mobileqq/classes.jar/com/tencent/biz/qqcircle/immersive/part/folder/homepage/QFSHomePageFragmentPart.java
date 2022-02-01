package com.tencent.biz.qqcircle.immersive.part.folder.homepage;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.QFSFolderProfileFragment;
import com.tencent.biz.qqcircle.immersive.QFSMainFragment;
import com.tencent.biz.qqcircle.immersive.adapter.QFSMultiTabFragmentAdapter;
import com.tencent.biz.qqcircle.immersive.ioc.IQFSFolderIoc;
import com.tencent.biz.qqcircle.immersive.part.QFSBasePart;
import com.tencent.biz.qqcircle.immersive.utils.QFSCommonUtil;
import com.tencent.biz.qqcircle.immersive.views.QFSViewPager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.qcircle.api.event.QCircleSelectTabEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class QFSHomePageFragmentPart
  extends QFSBasePart
  implements IQFSFolderIoc, SimpleEventReceiver
{
  private final PartManager a;
  private QFSViewPager b;
  private QFSMultiTabFragmentAdapter c;
  private final ArrayList<QFSBaseFragment> d = new ArrayList();
  private final ArrayList<RadioButton> e = new ArrayList();
  private int f = 0;
  private QFSMainFragment g;
  private QFSFolderProfileFragment h;
  private RadioGroup i;
  private RadioButton j;
  private RadioButton k;
  
  public QFSHomePageFragmentPart(PartManager paramPartManager)
  {
    this.a = paramPartManager;
  }
  
  private void a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      if (!(paramVarArgs[0] instanceof Boolean)) {
        return;
      }
      QFSViewPager localQFSViewPager = this.b;
      if (localQFSViewPager != null) {
        localQFSViewPager.setScrollable(((Boolean)paramVarArgs[0]).booleanValue());
      }
    }
  }
  
  private void d()
  {
    this.i.setOnCheckedChangeListener(new QFSHomePageFragmentPart.1(this));
  }
  
  private void e()
  {
    this.g = new QFSMainFragment();
    this.g.a(this);
    this.g.p().a(this.a);
    this.d.add(this.g);
    this.h = new QFSFolderProfileFragment();
    this.h.a(QFSCommonUtil.b());
    this.h.a(false);
    this.d.add(this.h);
  }
  
  private void n()
  {
    this.b.addOnPageChangeListener(new QFSHomePageFragmentPart.2(this));
  }
  
  public String a()
  {
    return "QFSFolderFragmentPart";
  }
  
  public void a(View paramView)
  {
    this.i = ((RadioGroup)paramView.findViewById(2131441954));
    this.j = ((RadioButton)paramView.findViewById(2131444182));
    this.k = ((RadioButton)paramView.findViewById(2131444190));
    this.e.addAll(Arrays.asList(new RadioButton[] { this.j, this.k }));
    this.c = new QFSMultiTabFragmentAdapter(m().getChildFragmentManager());
    this.b = ((QFSViewPager)paramView.findViewById(2131433851));
    this.b.setAdapter(this.c);
    this.b.setOffscreenPageLimit(3);
    this.b.setScrollable(false);
    this.b.setScrollWithAnim(false);
    n();
    d();
    e();
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
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      QFSBaseFragment localQFSBaseFragment = (QFSBaseFragment)localIterator.next();
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
    QFSViewPager localQFSViewPager = this.b;
    if (localQFSViewPager != null) {
      return localQFSViewPager.getCurrentItem();
    }
    return -1;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleSelectTabEvent.class);
    return localArrayList;
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
    QLog.d("QFSFolderFragmentPart", 1, "fs_lifecycle onActivityDestroyed");
    paramActivity = this.d.iterator();
    while (paramActivity.hasNext()) {
      ((QFSBaseFragment)paramActivity.next()).onDestroy();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    if (this.b == null) {
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
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if (this.b == null) {
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
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
    if (this.b == null) {
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
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleSelectTabEvent))
    {
      paramSimpleBaseEvent = this.j;
      if (paramSimpleBaseEvent != null) {
        paramSimpleBaseEvent.performClick();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.folder.homepage.QFSHomePageFragmentPart
 * JD-Core Version:    0.7.0.1
 */