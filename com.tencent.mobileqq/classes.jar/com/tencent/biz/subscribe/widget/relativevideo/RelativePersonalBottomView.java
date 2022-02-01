package com.tencent.biz.subscribe.widget.relativevideo;

import aaak;
import aaam;
import aabj;
import aabn;
import aabp;
import aaks;
import aanf;
import aapz;
import aaqa;
import aaqb;
import abbe;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
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

public class RelativePersonalBottomView
  extends BaseWidgetView<aabn>
  implements aaam
{
  private aabn jdField_a_of_type_Aabn;
  private aabp jdField_a_of_type_Aabp;
  private aaqb jdField_a_of_type_Aaqb;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private RadioButton jdField_a_of_type_AndroidWidgetRadioButton;
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private SubscribePersonalBottomDraftsFragment jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment;
  private SubscribePersonalBottomOpusFragment jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomOpusFragment;
  private String jdField_a_of_type_JavaLangString;
  private List<SubscribeBaseBottomPersonalFragment> jdField_a_of_type_JavaUtilList;
  private RadioButton b;
  
  public RelativePersonalBottomView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public RelativePersonalBottomView(Context paramContext, aabp paramaabp)
  {
    this(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_Aabp = paramaabp;
    aaak.a().a(this);
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
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(new aapz(this));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(new aaqa(this));
  }
  
  private void d()
  {
    if (aanf.a().a(this.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment == null)
      {
        this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment = new SubscribePersonalBottomDraftsFragment();
        if ((this.jdField_a_of_type_Aabn != null) && ((this.jdField_a_of_type_Aabn.a instanceof aaks)))
        {
          aaks localaaks = (aaks)this.jdField_a_of_type_Aabn.a;
          this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment.a(localaaks.jdField_a_of_type_JavaLangString, localaaks);
        }
      }
      if (!this.jdField_a_of_type_JavaUtilList.contains(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment))
      {
        abbe.b(this.jdField_a_of_type_JavaLangString, "auth_pubish", "exp_draft", 0, 0, new String[0]);
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment);
        this.b.setVisibility(0);
        this.jdField_a_of_type_Aaqb.notifyDataSetChanged();
      }
      this.jdField_a_of_type_AndroidWidgetRadioButton.setBackgroundDrawable(getResources().getDrawable(2130838965));
    }
    for (;;)
    {
      e();
      return;
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0);
      if (this.jdField_a_of_type_JavaUtilList.contains(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment))
      {
        this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment);
        this.b.setVisibility(8);
        this.jdField_a_of_type_Aaqb.notifyDataSetChanged();
        this.jdField_a_of_type_AndroidWidgetRadioButton.setBackgroundDrawable(null);
      }
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Aabn != null) && ((this.jdField_a_of_type_Aabn.a instanceof aaks)))
    {
      Object localObject = (aaks)this.jdField_a_of_type_Aabn.a;
      if (((((aaks)localObject).jdField_a_of_type_JavaUtilList == null) || (((aaks)localObject).jdField_a_of_type_JavaUtilList.size() == 0)) && (this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.contains(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment)) && (this.jdField_a_of_type_Aabp != null))
      {
        localObject = this.jdField_a_of_type_Aabp.getBlockMerger().a().a().getChildAt(0);
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
    return 2131558779;
  }
  
  public void a(aabn paramaabn)
  {
    if ((paramaabn != null) && ((paramaabn.a instanceof aaks)))
    {
      this.jdField_a_of_type_Aabn = paramaabn;
      paramaabn = (aaks)paramaabn.a;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((SubscribeBaseBottomPersonalFragment)localIterator.next()).a(paramaabn.jdField_a_of_type_JavaLangString, paramaabn);
      }
      e();
      if (paramaabn.b) {
        d();
      }
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)paramView.findViewById(2131376623));
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)paramView.findViewById(2131372149));
    this.b = ((RadioButton)paramView.findViewById(2131365745));
    this.b.setVisibility(8);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)paramView.findViewById(2131372416));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOffscreenPageLimit(1);
    this.jdField_a_of_type_Aaqb = new aaqb(this, ((PublicFragmentActivity)paramContext).getSupportFragmentManager());
    a();
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_Aaqb);
    c();
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
    aaak.a().a(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    aaak.a().b(this);
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