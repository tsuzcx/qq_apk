package com.tencent.biz.subscribe.widget.relativevideo;

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
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment;
import com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment.BottomData;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomDraftsFragment;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment;
import com.tencent.biz.subscribe.part.block.BlockContainer;
import com.tencent.biz.subscribe.part.block.BlockMerger;
import com.tencent.biz.subscribe.part.block.BlockMerger.ShareData;
import com.tencent.biz.subscribe.part.block.MultiViewBlock;
import com.tencent.biz.subscribe.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.utils.SubscribeDraftManager;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class RelativePersonalBottomView
  extends BaseWidgetView<BlockMerger.ShareData>
  implements SimpleEventReceiver
{
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private RadioButton jdField_a_of_type_AndroidWidgetRadioButton;
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private SubscribePersonalBottomDraftsFragment jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment;
  private SubscribePersonalBottomOpusFragment jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomOpusFragment;
  private BlockMerger.ShareData jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger$ShareData;
  private MultiViewBlock jdField_a_of_type_ComTencentBizSubscribePartBlockMultiViewBlock;
  private RelativePersonalBottomView.RelativePersonalBottomAdapter jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView$RelativePersonalBottomAdapter;
  private String jdField_a_of_type_JavaLangString;
  private List<SubscribeBaseBottomPersonalFragment> jdField_a_of_type_JavaUtilList;
  private RadioButton b;
  
  public RelativePersonalBottomView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public RelativePersonalBottomView(Context paramContext, MultiViewBlock paramMultiViewBlock)
  {
    this(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockMultiViewBlock = paramMultiViewBlock;
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
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(new RelativePersonalBottomView.1(this));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(new RelativePersonalBottomView.2(this));
  }
  
  private void d()
  {
    if (SubscribeDraftManager.a().a(this.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment == null)
      {
        this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment = new SubscribePersonalBottomDraftsFragment();
        if ((this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger$ShareData != null) && ((this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger$ShareData.a instanceof SubscribeBaseBottomPersonalFragment.BottomData)))
        {
          SubscribeBaseBottomPersonalFragment.BottomData localBottomData = (SubscribeBaseBottomPersonalFragment.BottomData)this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger$ShareData.a;
          this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment.a(localBottomData.jdField_a_of_type_JavaLangString, localBottomData);
        }
      }
      if (!this.jdField_a_of_type_JavaUtilList.contains(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment))
      {
        VSReporter.b(this.jdField_a_of_type_JavaLangString, "auth_pubish", "exp_draft", 0, 0, new String[0]);
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment);
        this.b.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView$RelativePersonalBottomAdapter.notifyDataSetChanged();
      }
      this.jdField_a_of_type_AndroidWidgetRadioButton.setBackgroundDrawable(getResources().getDrawable(2130839088));
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
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView$RelativePersonalBottomAdapter.notifyDataSetChanged();
        this.jdField_a_of_type_AndroidWidgetRadioButton.setBackgroundDrawable(null);
      }
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger$ShareData != null) && ((this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger$ShareData.a instanceof SubscribeBaseBottomPersonalFragment.BottomData)))
    {
      Object localObject = (SubscribeBaseBottomPersonalFragment.BottomData)this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger$ShareData.a;
      if (((((SubscribeBaseBottomPersonalFragment.BottomData)localObject).jdField_a_of_type_JavaUtilList == null) || (((SubscribeBaseBottomPersonalFragment.BottomData)localObject).jdField_a_of_type_JavaUtilList.size() == 0)) && (this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.contains(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment)) && (this.jdField_a_of_type_ComTencentBizSubscribePartBlockMultiViewBlock != null))
      {
        localObject = this.jdField_a_of_type_ComTencentBizSubscribePartBlockMultiViewBlock.a().a().a().getChildAt(0);
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
    return 2131558852;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)paramView.findViewById(2131377038));
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)paramView.findViewById(2131372614));
    this.b = ((RadioButton)paramView.findViewById(2131366042));
    this.b.setVisibility(8);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)paramView.findViewById(2131372890));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOffscreenPageLimit(1);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView$RelativePersonalBottomAdapter = new RelativePersonalBottomView.RelativePersonalBottomAdapter(this, ((PublicFragmentActivity)paramContext).getSupportFragmentManager());
    a();
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView$RelativePersonalBottomAdapter);
    c();
  }
  
  public void a(BlockMerger.ShareData paramShareData)
  {
    if ((paramShareData != null) && ((paramShareData.a instanceof SubscribeBaseBottomPersonalFragment.BottomData)))
    {
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger$ShareData = paramShareData;
      paramShareData = (SubscribeBaseBottomPersonalFragment.BottomData)paramShareData.a;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((SubscribeBaseBottomPersonalFragment)localIterator.next()).a(paramShareData.jdField_a_of_type_JavaLangString, paramShareData);
      }
      e();
      if (paramShareData.b) {
        d();
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
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(SubDraftChangeEvent.class);
    localArrayList.add(SubscribeFeedsEvent.class);
    return localArrayList;
  }
  
  public void onAttachedToWindow()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView
 * JD-Core Version:    0.7.0.1
 */