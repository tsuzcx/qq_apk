package com.tencent.biz.subscribe.widget.relativevideo;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
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
import woz;
import wpc;
import wpf;
import wpt;
import wpv;
import wpw;
import wsw;
import wvv;
import wvw;
import wvx;
import xhb;

public class RelativePersonalBottomView
  extends BaseWidgetView<wpf>
  implements wpv
{
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private RadioButton jdField_a_of_type_AndroidWidgetRadioButton;
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private SubscribePersonalBottomDraftsFragment jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment;
  private SubscribePersonalBottomOpusFragment jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomOpusFragment;
  private String jdField_a_of_type_JavaLangString;
  private List<SubscribeBaseBottomPersonalFragment> jdField_a_of_type_JavaUtilList;
  private woz jdField_a_of_type_Woz;
  private wpf jdField_a_of_type_Wpf;
  private wvx jdField_a_of_type_Wvx;
  private RadioButton b;
  
  public RelativePersonalBottomView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public RelativePersonalBottomView(Context paramContext, woz paramwoz)
  {
    this(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_Woz = paramwoz;
    wpt.a().a(this);
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
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(new wvv(this));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(new wvw(this));
  }
  
  private void c()
  {
    if (wsw.a().a(this.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment == null)
      {
        this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment = new SubscribePersonalBottomDraftsFragment();
        if ((this.jdField_a_of_type_Wpf != null) && ((this.jdField_a_of_type_Wpf.a instanceof wpw)))
        {
          wpw localwpw = (wpw)this.jdField_a_of_type_Wpf.a;
          this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment.a(localwpw.jdField_a_of_type_JavaLangString, localwpw);
        }
      }
      if (!this.jdField_a_of_type_JavaUtilList.contains(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment))
      {
        xhb.b(this.jdField_a_of_type_JavaLangString, "auth_pubish", "exp_draft", 0, 0, new String[0]);
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment);
        this.b.setVisibility(0);
        this.jdField_a_of_type_Wvx.notifyDataSetChanged();
      }
      this.jdField_a_of_type_AndroidWidgetRadioButton.setBackgroundDrawable(getResources().getDrawable(2130838628));
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
        this.jdField_a_of_type_Wvx.notifyDataSetChanged();
        this.jdField_a_of_type_AndroidWidgetRadioButton.setBackgroundDrawable(null);
      }
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Wpf != null) && ((this.jdField_a_of_type_Wpf.a instanceof wpw)))
    {
      Object localObject = (wpw)this.jdField_a_of_type_Wpf.a;
      if (((((wpw)localObject).jdField_a_of_type_JavaUtilList == null) || (((wpw)localObject).jdField_a_of_type_JavaUtilList.size() == 0)) && (this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.contains(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment)) && (this.jdField_a_of_type_Woz != null))
      {
        localObject = this.jdField_a_of_type_Woz.a().a().a().getChildAt(0);
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
    return 2131558680;
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(SubDraftChangeEvent.class);
    localArrayList.add(SubscribeFeedsEvent.class);
    return localArrayList;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)paramView.findViewById(2131375230));
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)paramView.findViewById(2131371135));
    this.b = ((RadioButton)paramView.findViewById(2131365379));
    this.b.setVisibility(8);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)paramView.findViewById(2131371394));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOffscreenPageLimit(1);
    this.jdField_a_of_type_Wvx = new wvx(this, ((PublicFragmentActivity)paramContext).getSupportFragmentManager());
    a();
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_Wvx);
    b();
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    ThreadManager.getUIHandler().post(new RelativePersonalBottomView.3(this, paramSimpleBaseEvent));
  }
  
  public void a(wpf paramwpf)
  {
    if ((paramwpf != null) && ((paramwpf.a instanceof wpw)))
    {
      this.jdField_a_of_type_Wpf = paramwpf;
      paramwpf = (wpw)paramwpf.a;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((SubscribeBaseBottomPersonalFragment)localIterator.next()).a(paramwpf.jdField_a_of_type_JavaLangString, paramwpf);
      }
      d();
      if (paramwpf.b) {
        c();
      }
    }
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
      return this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem();
    }
    return 0;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    wpt.a().a(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    wpt.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView
 * JD-Core Version:    0.7.0.1
 */