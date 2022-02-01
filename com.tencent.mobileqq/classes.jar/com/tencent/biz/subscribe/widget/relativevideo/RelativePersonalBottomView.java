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
  private RadioGroup c;
  private ViewPager d;
  private RadioButton e;
  private RadioButton f;
  private RelativePersonalBottomView.RelativePersonalBottomAdapter g;
  private MultiViewBlock h;
  private List<SubscribeBaseBottomPersonalFragment> i;
  private SubscribePersonalBottomOpusFragment j;
  private SubscribePersonalBottomDraftsFragment k;
  private String l;
  private BlockMerger.ShareData m;
  
  public RelativePersonalBottomView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public RelativePersonalBottomView(Context paramContext, MultiViewBlock paramMultiViewBlock)
  {
    this(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.h = paramMultiViewBlock;
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  private void a()
  {
    this.i = new ArrayList();
    this.j = new SubscribePersonalBottomOpusFragment();
    this.i.add(this.j);
    if ((getContext() instanceof PublicFragmentActivity)) {
      this.l = ((PublicFragmentActivity)getContext()).app.getAccount();
    }
  }
  
  private void b()
  {
    this.c.setOnCheckedChangeListener(new RelativePersonalBottomView.1(this));
    this.d.setOnPageChangeListener(new RelativePersonalBottomView.2(this));
  }
  
  private void c()
  {
    if (SubscribeDraftManager.a().a(this.l))
    {
      if (this.k == null)
      {
        this.k = new SubscribePersonalBottomDraftsFragment();
        Object localObject = this.m;
        if ((localObject != null) && ((((BlockMerger.ShareData)localObject).a instanceof SubscribeBaseBottomPersonalFragment.BottomData)))
        {
          localObject = (SubscribeBaseBottomPersonalFragment.BottomData)this.m.a;
          this.k.a(((SubscribeBaseBottomPersonalFragment.BottomData)localObject).a, (SubscribeBaseBottomPersonalFragment.BottomData)localObject);
        }
      }
      if (!this.i.contains(this.k))
      {
        VSReporter.b(this.l, "auth_pubish", "exp_draft", 0, 0, new String[0]);
        this.i.add(this.k);
        this.f.setVisibility(0);
        this.g.notifyDataSetChanged();
      }
      this.e.setBackgroundDrawable(getResources().getDrawable(2130839095));
    }
    else
    {
      this.d.setCurrentItem(0);
      if (this.i.contains(this.k))
      {
        this.i.remove(this.k);
        this.f.setVisibility(8);
        this.g.notifyDataSetChanged();
        this.e.setBackgroundDrawable(null);
      }
    }
    d();
  }
  
  private void d()
  {
    Object localObject = this.m;
    if ((localObject != null) && ((((BlockMerger.ShareData)localObject).a instanceof SubscribeBaseBottomPersonalFragment.BottomData)))
    {
      localObject = (SubscribeBaseBottomPersonalFragment.BottomData)this.m.a;
      if ((((SubscribeBaseBottomPersonalFragment.BottomData)localObject).d == null) || (((SubscribeBaseBottomPersonalFragment.BottomData)localObject).d.size() == 0))
      {
        localObject = this.i;
        if ((localObject != null) && (!((List)localObject).contains(this.k)))
        {
          localObject = this.h;
          if (localObject != null)
          {
            localObject = ((MultiViewBlock)localObject).B().f().getRecyclerView().getChildAt(0);
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
  
  protected void a(Context paramContext, View paramView)
  {
    this.c = ((RadioGroup)paramView.findViewById(2131444765));
    this.e = ((RadioButton)paramView.findViewById(2131439698));
    this.f = ((RadioButton)paramView.findViewById(2131432130));
    this.f.setVisibility(8);
    this.d = ((ViewPager)paramView.findViewById(2131439999));
    this.d.setOffscreenPageLimit(1);
    this.g = new RelativePersonalBottomView.RelativePersonalBottomAdapter(this, ((PublicFragmentActivity)paramContext).getSupportFragmentManager());
    a();
    b();
  }
  
  public void a(BlockMerger.ShareData paramShareData)
  {
    if ((paramShareData != null) && ((paramShareData.a instanceof SubscribeBaseBottomPersonalFragment.BottomData)))
    {
      this.m = paramShareData;
      paramShareData = (SubscribeBaseBottomPersonalFragment.BottomData)paramShareData.a;
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext()) {
        ((SubscribeBaseBottomPersonalFragment)localIterator.next()).a(paramShareData.a, paramShareData);
      }
      d();
      if (paramShareData.g) {
        c();
      }
    }
  }
  
  public int getCurrentIndex()
  {
    ViewPager localViewPager = this.d;
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
  
  protected int getLayoutId()
  {
    return 2131624370;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView
 * JD-Core Version:    0.7.0.1
 */