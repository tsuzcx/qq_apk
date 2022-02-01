package com.tencent.aelight.camera.ae.biz.circle.part;

import android.graphics.Typeface;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic;
import com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic.PhotoListGuideData;
import com.tencent.aelight.camera.ae.biz.circle.AECircleSinglePhotoListFragment;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleSelectChangeEvent;
import com.tencent.aelight.camera.ae.biz.circle.part.base.AECircleBasePart;
import com.tencent.aelight.camera.ae.view.NoScrollViewPager;
import com.tencent.aelight.camera.ae.view.scrollingheader.ScrollingHeaderLayout.ScrollingViewBehavior;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AECirclePhotoListPart
  extends AECircleBasePart
  implements CompoundButton.OnCheckedChangeListener, SimpleEventReceiver
{
  private NoScrollViewPager a;
  private RadioGroup b;
  private RadioButton f;
  private RadioButton g;
  private RadioButton h;
  private ArrayList<AECircleSinglePhotoListFragment> i;
  
  public AECirclePhotoListPart(AECirclePhotoListLogic paramAECirclePhotoListLogic)
  {
    super(paramAECirclePhotoListLogic);
    this.c.a(this);
  }
  
  private void a(int paramInt)
  {
    int j = 0;
    while (j < this.i.size())
    {
      if (j == paramInt) {
        ((AECircleSinglePhotoListFragment)this.i.get(j)).b(paramInt);
      } else {
        ((AECircleSinglePhotoListFragment)this.i.get(j)).a();
      }
      j += 1;
    }
  }
  
  private void b(View paramView)
  {
    this.b = ((RadioGroup)paramView.findViewById(2063991365));
    this.f = ((RadioButton)paramView.findViewById(2063991354));
    this.g = ((RadioButton)paramView.findViewById(2063991355));
    this.h = ((RadioButton)paramView.findViewById(2063991356));
    this.f.setTypeface(Typeface.DEFAULT_BOLD);
    this.f.setOnCheckedChangeListener(this);
    this.g.setOnCheckedChangeListener(this);
    this.h.setOnCheckedChangeListener(this);
    this.b.setOnCheckedChangeListener(new AECirclePhotoListPart.1(this));
  }
  
  private void c(View paramView)
  {
    this.a = ((NoScrollViewPager)paramView.findViewById(2063991266));
    this.a.setOffscreenPageLimit(2);
    if ((this.a.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
      ((CoordinatorLayout.LayoutParams)this.a.getLayoutParams()).setBehavior(new ScrollingHeaderLayout.ScrollingViewBehavior());
    }
    paramView = new AECirclePhotoListPart.PhotoPagerAdapter(this, f());
    this.a.setAdapter(paramView);
    this.a.addOnPageChangeListener(new AECirclePhotoListPart.2(this));
    if ((this.c != null) && (this.c.e != null)) {
      this.a.setCurrentItem(this.c.e.a, false);
    }
  }
  
  private void d()
  {
    this.i = new ArrayList();
    this.i.add(new AECircleSinglePhotoListFragment().a(this.c).a(1));
    this.i.add(new AECircleSinglePhotoListFragment().a(this.c).a(2));
    this.i.add(new AECircleSinglePhotoListFragment().a(this.c).a(3));
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    d();
    b(paramView);
    c(paramView);
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((AECircleSinglePhotoListFragment)localIterator.next()).a(paramList);
    }
  }
  
  public void al_()
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((AECircleSinglePhotoListFragment)localIterator.next()).b();
    }
  }
  
  public String b()
  {
    return "AECirclePhotoListPart";
  }
  
  public void c()
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      AECircleSinglePhotoListFragment localAECircleSinglePhotoListFragment = (AECircleSinglePhotoListFragment)localIterator.next();
      if (localAECircleSinglePhotoListFragment != null) {
        localAECircleSinglePhotoListFragment.c();
      }
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AECircleSelectChangeEvent.class);
    return localArrayList;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean) {
      localObject = Typeface.DEFAULT_BOLD;
    } else {
      localObject = Typeface.DEFAULT;
    }
    paramCompoundButton.setTypeface((Typeface)localObject);
    if (this.f.isChecked()) {
      paramCompoundButton = "1";
    } else if (this.g.isChecked()) {
      paramCompoundButton = "2";
    } else {
      paramCompoundButton = "3";
    }
    if (this.c != null) {
      localObject = this.c.i();
    } else {
      localObject = "";
    }
    AEReportUtils.a(paramCompoundButton, (String)localObject);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof AECircleSelectChangeEvent)) {
      al_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.AECirclePhotoListPart
 * JD-Core Version:    0.7.0.1
 */