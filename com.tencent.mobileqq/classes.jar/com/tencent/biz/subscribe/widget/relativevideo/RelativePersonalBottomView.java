package com.tencent.biz.subscribe.widget.relativevideo;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.viewpager.widget.ViewPager;
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
  private RadioButton jdField_a_of_type_AndroidWidgetRadioButton;
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private ViewPager jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
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
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setOnPageChangeListener(new RelativePersonalBottomView.2(this));
  }
  
  private void d()
  {
    if (SubscribeDraftManager.a().a(this.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment == null)
      {
        this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment = new SubscribePersonalBottomDraftsFragment();
        Object localObject = this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger$ShareData;
        if ((localObject != null) && ((((BlockMerger.ShareData)localObject).a instanceof SubscribeBaseBottomPersonalFragment.BottomData)))
        {
          localObject = (SubscribeBaseBottomPersonalFragment.BottomData)this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger$ShareData.a;
          this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment.a(((SubscribeBaseBottomPersonalFragment.BottomData)localObject).jdField_a_of_type_JavaLangString, (SubscribeBaseBottomPersonalFragment.BottomData)localObject);
        }
      }
      if (!this.jdField_a_of_type_JavaUtilList.contains(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment))
      {
        VSReporter.b(this.jdField_a_of_type_JavaLangString, "auth_pubish", "exp_draft", 0, 0, new String[0]);
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment);
        this.b.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView$RelativePersonalBottomAdapter.notifyDataSetChanged();
      }
      this.jdField_a_of_type_AndroidWidgetRadioButton.setBackgroundDrawable(getResources().getDrawable(2130838941));
    }
    else
    {
      this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setCurrentItem(0);
      if (this.jdField_a_of_type_JavaUtilList.contains(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment))
      {
        this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment);
        this.b.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView$RelativePersonalBottomAdapter.notifyDataSetChanged();
        this.jdField_a_of_type_AndroidWidgetRadioButton.setBackgroundDrawable(null);
      }
    }
    e();
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger$ShareData;
    if ((localObject != null) && ((((BlockMerger.ShareData)localObject).a instanceof SubscribeBaseBottomPersonalFragment.BottomData)))
    {
      localObject = (SubscribeBaseBottomPersonalFragment.BottomData)this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger$ShareData.a;
      if ((((SubscribeBaseBottomPersonalFragment.BottomData)localObject).jdField_a_of_type_JavaUtilList == null) || (((SubscribeBaseBottomPersonalFragment.BottomData)localObject).jdField_a_of_type_JavaUtilList.size() == 0))
      {
        localObject = this.jdField_a_of_type_JavaUtilList;
        if ((localObject != null) && (!((List)localObject).contains(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomDraftsFragment)))
        {
          localObject = this.jdField_a_of_type_ComTencentBizSubscribePartBlockMultiViewBlock;
          if (localObject != null)
          {
            localObject = ((MultiViewBlock)localObject).a().a().a().getChildAt(0);
            ThreadManager.getUIHandler().post(new RelativePersonalBottomView.4(this, (View)localObject));
            return;
          }
        }
      }
    }
    if ((getLayoutParams() != null) && (getLayoutParams().height != -1)) {
      ThreadManager.getUIHandler().post(new RelativePersonalBottomView.5(this));
    }
  }
  
  protected int a()
  {
    return 2131558750;
  }
  
  protected void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)paramView.findViewById(2131376518));
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)paramView.findViewById(2131372198));
    this.b = ((RadioButton)paramView.findViewById(2131365871));
    this.b.setVisibility(8);
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager = ((ViewPager)paramView.findViewById(2131372477));
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setOffscreenPageLimit(1);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView$RelativePersonalBottomAdapter = new RelativePersonalBottomView.RelativePersonalBottomAdapter(this, ((PublicFragmentActivity)paramContext).getSupportFragmentManager());
    a();
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
    ViewPager localViewPager = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
    if (localViewPager != null) {
      return localViewPager.getCurrentItem();
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
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    ThreadManager.getUIHandler().post(new RelativePersonalBottomView.3(this, paramSimpleBaseEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView
 * JD-Core Version:    0.7.0.1
 */