package com.tencent.biz.pubaccount.weishi_new.drama.history;

import UserGrowth.stDrama;
import UserGrowth.stDramaInfo;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.data.FetcherParams;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageFragment;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.drama.holder.AbsWSDramaHolder;
import com.tencent.biz.pubaccount.weishi_new.drama.part.WSAbsPart;
import com.tencent.biz.pubaccount.weishi_new.drama.report.WSDramaBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.drama.utils.WSDramaUtils;
import com.tencent.biz.pubaccount.weishi_new.event.WSDramaVideoPlayEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.view.WSDragLayout;
import com.tencent.biz.pubaccount.weishi_new.view.WSGridSpacingItemDecoration;
import com.tencent.biz.pubaccount.weishi_new.view.WSXRecyclerView;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.ArrayList;
import java.util.List;

public class WSDramaHistoryPart
  extends WSAbsPart
  implements WSDramaHistoryConstract.View, WSSimpleEventReceiver, IGuardInterface
{
  private RelativeLayout a;
  private WSDragLayout e;
  private WSXRecyclerView f;
  private LinearLayout g;
  private ImageView h;
  private WSDramaPageFragment i;
  private WSDramaHistoryAdapter j;
  private WSDramaHistoryPresenter k = new WSDramaHistoryPresenter(this);
  private WSDramaItemData l;
  private String m;
  
  public WSDramaHistoryPart(Context paramContext, ViewStub paramViewStub, WSDramaPageFragment paramWSDramaPageFragment)
  {
    super(paramContext, paramViewStub);
    this.i = paramWSDramaPageFragment;
  }
  
  public static WSDramaHistoryPart a(Context paramContext, ViewStub paramViewStub, WSDramaPageFragment paramWSDramaPageFragment, String paramString)
  {
    paramContext = new WSDramaHistoryPart(paramContext, paramViewStub, paramWSDramaPageFragment);
    paramContext.a(paramString);
    return paramContext;
  }
  
  private void a(float paramFloat)
  {
    this.a.getBackground().mutate().setAlpha((int)((1.0F - paramFloat) * 255.0F));
  }
  
  private void b(int paramInt)
  {
    if (this.l == null) {
      return;
    }
    WSDramaHistoryAdapter localWSDramaHistoryAdapter = this.j;
    int n;
    if ((localWSDramaHistoryAdapter != null) && (localWSDramaHistoryAdapter.getDataList().size() > 0)) {
      n = 1;
    } else {
      n = 0;
    }
    WSDramaBeaconReport.a(this.l.d(), this.l.e(), this.l.b(), this.l.c(), this.m, paramInt, n);
  }
  
  private void g()
  {
    this.a = ((RelativeLayout)this.d.findViewById(2131444938));
    this.e = ((WSDragLayout)this.d.findViewById(2131432157));
    this.f = ((WSXRecyclerView)this.d.findViewById(2131445208));
    this.g = ((LinearLayout)this.d.findViewById(2131447803));
    this.h = ((ImageView)this.d.findViewById(2131436628));
    this.e.setControlLitTongue(true);
    this.e.setMode(1);
    this.e.setDisableMinScrollY(true);
    this.e.setContentView(this.f.getRecyclerView());
    this.e.b(0);
    this.e.setTouchListener(new WSDramaHistoryPart.1(this));
    this.g.setOnClickListener(new WSDramaHistoryPart.2(this));
    this.a.setOnClickListener(new WSDramaHistoryPart.3(this));
  }
  
  private void h()
  {
    Object localObject = this.f.getLoadMoreLayoutHelper();
    if (localObject != null) {
      ((LoadingMoreHelper)localObject).setPreLoaderCount(12);
    }
    localObject = new GridLayoutManager(this.b, 3);
    this.j = new WSDramaHistoryAdapter(this.b, this.i);
    this.f.setRefreshEnable(false);
    RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = this.f.getRecyclerView();
    localRecyclerViewWithHeaderFooter.setAdapter(this.j);
    localRecyclerViewWithHeaderFooter.setLayoutManager((RecyclerView.LayoutManager)localObject);
    localRecyclerViewWithHeaderFooter.setItemAnimator(null);
    localRecyclerViewWithHeaderFooter.addItemDecoration(new WSGridSpacingItemDecoration(3, WeishiUIUtil.d));
    this.f.setRefreshCallback(new WSDramaHistoryPart.4(this));
  }
  
  private void i()
  {
    WSSimpleEventBus.a().a(this);
    this.k.a(new FetcherParams(true, true));
  }
  
  private void j()
  {
    this.a.setClickable(true);
    this.h.setImageResource(2130853563);
    b(0);
    l();
    WSDramaHistoryAdapter localWSDramaHistoryAdapter = this.j;
    if (localWSDramaHistoryAdapter != null) {
      localWSDramaHistoryAdapter.a(false);
    }
  }
  
  private void k()
  {
    this.a.setClickable(false);
    this.h.setImageResource(2130853564);
    b(1);
    WSDramaHistoryAdapter localWSDramaHistoryAdapter = this.j;
    if (localWSDramaHistoryAdapter != null) {
      localWSDramaHistoryAdapter.a(true);
    }
  }
  
  private void l()
  {
    if (this.l != null)
    {
      if (this.e.a()) {
        return;
      }
      int n = WeishiUIUtil.a(this.f.getRecyclerView());
      int i1 = WeishiUIUtil.b(this.f.getRecyclerView());
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportPanelItemExposure fistVisible:");
      ((StringBuilder)localObject).append(n);
      ((StringBuilder)localObject).append(", lastVisible:");
      ((StringBuilder)localObject).append(i1);
      WSLog.b("WSDramaHistoryPart", ((StringBuilder)localObject).toString());
      localObject = this.i.e();
      while (n <= i1)
      {
        if (n < this.j.getDataList().size()) {
          WSDramaBeaconReport.b(WSDramaUtils.b((AbsWSDramaHolder)localObject), WSDramaUtils.a((AbsWSDramaHolder)localObject), WSDramaUtils.c((AbsWSDramaHolder)localObject), WSDramaUtils.d((AbsWSDramaHolder)localObject), (WSDramaHistoryData)this.j.getDataList().get(n), this.i.b(), n);
        }
        n += 1;
      }
    }
  }
  
  public List<WSDramaHistoryData> a()
  {
    WSDramaHistoryAdapter localWSDramaHistoryAdapter = this.j;
    if (localWSDramaHistoryAdapter != null) {
      return localWSDramaHistoryAdapter.getDataList();
    }
    return new ArrayList();
  }
  
  public void a(AbsWSDramaHolder paramAbsWSDramaHolder, int paramInt)
  {
    this.l = paramAbsWSDramaHolder.c;
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if ((paramWSSimpleBaseEvent instanceof WSDramaVideoPlayEvent))
    {
      paramWSSimpleBaseEvent = (WSDramaVideoPlayEvent)paramWSSimpleBaseEvent;
      if (paramWSSimpleBaseEvent.getDramaInfo() != null)
      {
        if (paramWSSimpleBaseEvent.getDramaInfo().dramaInfo == null) {
          return;
        }
        stDrama localstDrama = this.k.a(paramWSSimpleBaseEvent.getDramaInfo());
        if (paramWSSimpleBaseEvent.getEpisodeNum() > localstDrama.dramaInfo.curWatchedFeedNum)
        {
          localstDrama.dramaInfo.curWatchedFeedNum = paramWSSimpleBaseEvent.getEpisodeNum();
          localstDrama.dramaInfo.curWatchedFeedID = paramWSSimpleBaseEvent.getEpisodeId();
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onReceiveEvent] 接收到播放事件：");
        localStringBuilder.append(localstDrama.dramaInfo.name);
        localStringBuilder.append(", isDramaPreviewPage:");
        localStringBuilder.append(paramWSSimpleBaseEvent.isDramaPreviewPage());
        localStringBuilder.append(", 集数:");
        localStringBuilder.append(localstDrama.dramaInfo.curWatchedFeedNum);
        WSLog.b("WSDramaHistoryPart", localStringBuilder.toString());
        this.k.a(localstDrama, paramWSSimpleBaseEvent.isDramaPreviewPage());
      }
    }
  }
  
  public void a(String paramString)
  {
    this.m = paramString;
  }
  
  public void a(List<WSDramaHistoryData> paramList, boolean paramBoolean)
  {
    WSDramaHistoryAdapter localWSDramaHistoryAdapter = this.j;
    if (localWSDramaHistoryAdapter != null)
    {
      localWSDramaHistoryAdapter.fillList(paramList);
      this.f.backToTopAtOnce();
    }
    this.f.loadMoreComplete(true, paramBoolean);
  }
  
  public void a(List<WSDramaHistoryData> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.j.fillList(paramList);
      this.f.backToTopAtOnce();
    }
    else
    {
      this.j.appendList(paramList);
    }
    this.f.loadMoreComplete(true, paramBoolean2);
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString) {}
  
  protected int b()
  {
    return 2131626055;
  }
  
  public void c()
  {
    super.c();
    g();
    h();
    i();
    if (GuardManager.sInstance != null) {
      GuardManager.sInstance.registerCallBack(this);
    }
  }
  
  public void d()
  {
    super.d();
    WSSimpleEventBus.a().b(this);
    if (GuardManager.sInstance != null) {
      GuardManager.sInstance.unregisterCallback(this);
    }
  }
  
  public void onApplicationBackground() {}
  
  public void onApplicationForeground()
  {
    if (this.e.a()) {
      this.k.a(new FetcherParams(true, true));
    }
  }
  
  public void onBackgroundTimeTick(long paramLong) {}
  
  public void onBackgroundUnguardTimeTick(long paramLong) {}
  
  public void onLiteTimeTick(long paramLong) {}
  
  public void onScreensStateChanged(boolean paramBoolean) {}
  
  public ArrayList<Class> z()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WSDramaVideoPlayEvent.class);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.history.WSDramaHistoryPart
 * JD-Core Version:    0.7.0.1
 */