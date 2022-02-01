package com.tencent.aelight.camera.ae.biz.circle.part;

import android.graphics.Typeface;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic;
import com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic.PhotoListGuideData;
import com.tencent.aelight.camera.ae.biz.circle.AECircleSinglePhotoListFragment;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleSelectChangeEvent;
import com.tencent.aelight.camera.ae.biz.circle.part.base.AECircleBasePart;
import com.tencent.aelight.camera.ae.view.NoScrollViewPager;
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
  private RadioButton jdField_a_of_type_AndroidWidgetRadioButton;
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private NoScrollViewPager jdField_a_of_type_ComTencentAelightCameraAeViewNoScrollViewPager;
  private ArrayList<AECircleSinglePhotoListFragment> jdField_a_of_type_JavaUtilArrayList;
  private RadioButton b;
  private RadioButton c;
  
  public AECirclePhotoListPart(AECirclePhotoListLogic paramAECirclePhotoListLogic)
  {
    super(paramAECirclePhotoListLogic);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a(this);
  }
  
  private void a(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (i == paramInt) {
        ((AECircleSinglePhotoListFragment)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramInt);
      } else {
        ((AECircleSinglePhotoListFragment)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      }
      i += 1;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList.add(new AECircleSinglePhotoListFragment().a(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic).a(1));
    this.jdField_a_of_type_JavaUtilArrayList.add(new AECircleSinglePhotoListFragment().a(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic).a(2));
    this.jdField_a_of_type_JavaUtilArrayList.add(new AECircleSinglePhotoListFragment().a(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic).a(3));
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetRadioButton.setTypeface(Typeface.DEFAULT_BOLD);
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(new AECirclePhotoListPart.1(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeViewNoScrollViewPager.addOnPageChangeListener(new AECirclePhotoListPart.2(this));
    if ((this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic != null) && (this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a != null)) {
      this.jdField_a_of_type_ComTencentAelightCameraAeViewNoScrollViewPager.setCurrentItem(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a.a, false);
    }
  }
  
  public String a()
  {
    return "AECirclePhotoListPart";
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AECircleSinglePhotoListFragment)localIterator.next()).b();
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    c();
    this.jdField_a_of_type_ComTencentAelightCameraAeViewNoScrollViewPager = ((NoScrollViewPager)paramView.findViewById(2064122437));
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)paramView.findViewById(2064122548));
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)paramView.findViewById(2064122535));
    this.b = ((RadioButton)paramView.findViewById(2064122536));
    this.c = ((RadioButton)paramView.findViewById(2064122537));
    this.jdField_a_of_type_AndroidWidgetRadioButton.setOnCheckedChangeListener(this);
    this.b.setOnCheckedChangeListener(this);
    this.c.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewNoScrollViewPager.setOffscreenPageLimit(2);
    paramView = new AECirclePhotoListPart.PhotoPagerAdapter(this, a());
    this.jdField_a_of_type_ComTencentAelightCameraAeViewNoScrollViewPager.setAdapter(paramView);
    d();
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AECircleSinglePhotoListFragment)localIterator.next()).a(paramList);
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
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
    Typeface localTypeface;
    if (paramBoolean) {
      localTypeface = Typeface.DEFAULT_BOLD;
    } else {
      localTypeface = Typeface.DEFAULT;
    }
    paramCompoundButton.setTypeface(localTypeface);
    if (this.jdField_a_of_type_AndroidWidgetRadioButton.isChecked()) {
      paramCompoundButton = "1";
    } else if (this.b.isChecked()) {
      paramCompoundButton = "2";
    } else {
      paramCompoundButton = "3";
    }
    AEReportUtils.a(paramCompoundButton);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof AECircleSelectChangeEvent)) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.AECirclePhotoListPart
 * JD-Core Version:    0.7.0.1
 */