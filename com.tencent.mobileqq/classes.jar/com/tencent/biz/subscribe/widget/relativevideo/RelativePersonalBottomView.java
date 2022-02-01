package com.tencent.biz.subscribe.widget.relativevideo;

import aaby;
import aabz;
import aaca;
import aanb;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomDraftsFragment;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import zoo;
import zos;
import zou;
import zwv;
import zzf;

public class RelativePersonalBottomView
  extends BaseWidgetView<zos>
  implements SimpleEventReceiver
{
  private aaca jdField_a_of_type_Aaca;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private RadioButton jdField_a_of_type_AndroidWidgetRadioButton;
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private SubscribePersonalBottomDraftsFragment jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment;
  private SubscribePersonalBottomOpusFragment jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomOpusFragment;
  private String jdField_a_of_type_JavaLangString;
  private List<SubscribeBaseBottomPersonalFragment> jdField_a_of_type_JavaUtilList;
  private zos jdField_a_of_type_Zos;
  private zou jdField_a_of_type_Zou;
  private RadioButton b;
  
  public RelativePersonalBottomView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public RelativePersonalBottomView(Context paramContext, zou paramzou)
  {
    this(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_Zou = paramzou;
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomOpusFragment = new SubscribePersonalBottomOpusFragment();
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomOpusFragment);
    if ((getContext() instanceof PublicFragmentActivity)) {
      this.jdField_a_of_type_JavaLangString = ((PublicFragmentActivity)getContext()).app.getAccount();
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(new aaby(this));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(new aabz(this));
  }
  
  private void c()
  {
    if (zzf.a().a(this.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment == null)
      {
        this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment = new SubscribePersonalBottomDraftsFragment();
        if ((this.jdField_a_of_type_Zos != null) && ((this.jdField_a_of_type_Zos.a instanceof zwv)))
        {
          zwv localzwv = (zwv)this.jdField_a_of_type_Zos.a;
          this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment.a(localzwv.jdField_a_of_type_JavaLangString, localzwv);
        }
      }
      if (!this.jdField_a_of_type_JavaUtilList.contains(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment))
      {
        aanb.b(this.jdField_a_of_type_JavaLangString, "auth_pubish", "exp_draft", 0, 0, new String[0]);
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment);
        this.b.setVisibility(0);
        this.jdField_a_of_type_Aaca.notifyDataSetChanged();
      }
      this.jdField_a_of_type_AndroidWidgetRadioButton.setBackgroundDrawable(getResources().getDrawable(2130839020));
    }
    for (;;)
    {
      d();
      return;
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0);
      if (this.jdField_a_of_type_JavaUtilList.contains(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment))
      {
        this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment);
        this.b.setVisibility(8);
        this.jdField_a_of_type_Aaca.notifyDataSetChanged();
        this.jdField_a_of_type_AndroidWidgetRadioButton.setBackgroundDrawable(null);
      }
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Zos != null) && ((this.jdField_a_of_type_Zos.a instanceof zwv)))
    {
      Object localObject = (zwv)this.jdField_a_of_type_Zos.a;
      if (((((zwv)localObject).jdField_a_of_type_JavaUtilList == null) || (((zwv)localObject).jdField_a_of_type_JavaUtilList.size() == 0)) && (this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.contains(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment)) && (this.jdField_a_of_type_Zou != null))
      {
        localObject = this.jdField_a_of_type_Zou.a().a().a().getChildAt(0);
        ThreadManager.getUIHandler().post(new RelativePersonalBottomView.4(this, (View)localObject));
      }
    }
    while ((getLayoutParams() == null) || (getLayoutParams().height == -1)) {
      return;
    }
    ThreadManager.getUIHandler().post(new RelativePersonalBottomView.5(this));
  }
  
  public int a()
  {
    return 2131558812;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)paramView.findViewById(2131376643));
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)paramView.findViewById(2131372307));
    this.b = ((RadioButton)paramView.findViewById(2131365875));
    this.b.setVisibility(8);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)paramView.findViewById(2131372577));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOffscreenPageLimit(1);
    this.jdField_a_of_type_Aaca = new aaca(this, ((PublicFragmentActivity)paramContext).getSupportFragmentManager());
    a();
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_Aaca);
    b();
  }
  
  public void a(zos paramzos)
  {
    if ((paramzos != null) && ((paramzos.a instanceof zwv)))
    {
      this.jdField_a_of_type_Zos = paramzos;
      paramzos = (zwv)paramzos.a;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((SubscribeBaseBottomPersonalFragment)localIterator.next()).a(paramzos.jdField_a_of_type_JavaLangString, paramzos);
      }
      d();
      if (paramzos.b) {
        c();
      }
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
      return this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem();
    }
    return 0;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(SubDraftChangeEvent.class);
    localArrayList.add(SubscribeFeedsEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    ThreadManager.getUIHandler().post(new RelativePersonalBottomView.3(this, paramSimpleBaseEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView
 * JD-Core Version:    0.7.0.1
 */