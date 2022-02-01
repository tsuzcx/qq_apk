package com.tencent.biz.qqcircle.immersive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedAdapter;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalFeedInfo;
import com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalHintViewPart;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSPersonalViewModel;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.utils.DisplayUtil;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class QFSPersonalFeedFragment
  extends QFSBaseFragment
{
  protected QFSPersonalHintViewPart c;
  protected RecyclerView d;
  protected QFSPersonalFeedAdapter e;
  protected QFSPersonalViewModel f;
  protected int g;
  protected int h = 0;
  protected boolean i = false;
  private BlockPart j;
  private QFSPersonalDetailsFragment k;
  private SafeGridLayoutManager l;
  private final int m = DisplayUtil.e();
  private int n = 0;
  private int o = 0;
  private int p = 0;
  
  private void A()
  {
    QFSPersonalViewModel localQFSPersonalViewModel = this.f;
    if ((localQFSPersonalViewModel != null) && (localQFSPersonalViewModel.e().getValue() != null))
    {
      if (!((Boolean)this.f.e().getValue()).booleanValue()) {
        return;
      }
      this.c.d();
    }
  }
  
  private void B()
  {
    BlockPart localBlockPart = this.j;
    if (localBlockPart != null)
    {
      localBlockPart.i().getBlockMerger().b(1);
      this.j.i().getBlockMerger().l();
    }
  }
  
  private void C()
  {
    Object localObject1 = this.f;
    if (localObject1 != null)
    {
      if (((QFSPersonalViewModel)localObject1).q()) {
        return;
      }
      boolean bool = this.f.p();
      int i1 = this.g;
      Object localObject2 = "";
      switch (i1)
      {
      default: 
        localObject1 = "";
        break;
      case 20103: 
        if (bool) {
          localObject1 = QCircleConfigHelper.aX();
        } else {
          localObject1 = QCircleConfigHelper.aZ();
        }
        localObject2 = localObject1;
        if (bool) {
          localObject1 = QCircleConfigHelper.aY();
        } else {
          localObject1 = QCircleConfigHelper.ba();
        }
        break;
      case 20102: 
        if (bool) {
          localObject1 = QCircleConfigHelper.aR();
        } else {
          localObject1 = QCircleConfigHelper.aT();
        }
        localObject2 = localObject1;
        if (bool) {
          localObject1 = QCircleConfigHelper.aS();
        } else {
          localObject1 = QCircleConfigHelper.aU();
        }
        break;
      case 20101: 
        if (bool) {
          localObject1 = QCircleConfigHelper.aN();
        } else {
          localObject1 = QCircleConfigHelper.aP();
        }
        localObject2 = localObject1;
        if (bool) {
          localObject1 = QCircleConfigHelper.aO();
        } else {
          localObject1 = QCircleConfigHelper.aQ();
        }
        break;
      }
      this.c.a((String)localObject2, (String)localObject1);
      this.e.setDatas(null);
    }
  }
  
  public static QFSPersonalFeedFragment a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("fs_key_personal_feed_type", paramInt);
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = null;
      break;
    case 20103: 
      localObject = new QFSPersonalPushedFeedFragment();
      break;
    case 20102: 
      localObject = new QFSPersonalPraisedFeedFragment();
      break;
    case 20101: 
      localObject = new QFSPersonalProductFeedFragment();
    }
    if (localObject != null) {
      ((QFSPersonalFeedFragment)localObject).setArguments(localBundle);
    }
    return localObject;
  }
  
  private void a(String paramString)
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      if (((QFSPersonalViewModel)localObject).q()) {
        return;
      }
      QLog.i("QFSPersonalFeedFragment", 1, paramString);
      boolean bool = this.f.p();
      switch (this.g)
      {
      default: 
        localObject = "";
        break;
      case 20103: 
        if (bool) {
          localObject = QCircleConfigHelper.aX();
        } else {
          localObject = QCircleConfigHelper.aZ();
        }
        break;
      case 20102: 
        if (bool) {
          localObject = QCircleConfigHelper.aR();
        } else {
          localObject = QCircleConfigHelper.aT();
        }
        break;
      case 20101: 
        if (bool) {
          localObject = QCircleConfigHelper.aN();
        } else {
          localObject = QCircleConfigHelper.aP();
        }
        break;
      }
      this.c.b((String)localObject, paramString);
    }
  }
  
  private void b(int paramInt, QFSPersonalFeedInfo paramQFSPersonalFeedInfo)
  {
    paramQFSPersonalFeedInfo = a(paramInt, paramQFSPersonalFeedInfo);
    QCircleLauncher.g(getContext(), paramQFSPersonalFeedInfo);
  }
  
  private void c(int paramInt, QFSPersonalFeedInfo paramQFSPersonalFeedInfo)
  {
    if (paramQFSPersonalFeedInfo == null) {
      return;
    }
    paramQFSPersonalFeedInfo = a(paramInt, paramQFSPersonalFeedInfo);
    QCircleLauncher.a(getContext(), paramQFSPersonalFeedInfo);
  }
  
  private List<MultiViewBlock> x()
  {
    ArrayList localArrayList = new ArrayList();
    this.e = new QFSPersonalFeedAdapter(getArguments());
    this.e.setOnLoadDataDelegate(new QFSPersonalFeedFragment.1(this));
    this.e.a(new QFSPersonalFeedFragment.2(this));
    localArrayList.add(this.e);
    return localArrayList;
  }
  
  private void y()
  {
    this.j.i().getRecyclerView().setNestedScrollingEnabled(true);
    this.j.i().setEnableRefresh(false);
    this.j.i().setEnableLoadMore(true);
    this.j.i().setParentFragment(this);
  }
  
  private void z()
  {
    QFSPersonalDetailsFragment localQFSPersonalDetailsFragment = this.k;
    if (localQFSPersonalDetailsFragment == null)
    {
      QLog.i("QFSPersonalFeedFragment", 1, "fsPersonalHomeFragment is null");
      return;
    }
    this.f = ((QFSPersonalViewModel)getViewModel(localQFSPersonalDetailsFragment, null, QFSPersonalViewModel.class));
    this.f.b().observe(this, new QFSPersonalFeedFragment.3(this));
    u();
  }
  
  public int a()
  {
    return 532;
  }
  
  public QCircleLayerBean a(int paramInt, QFSPersonalFeedInfo paramQFSPersonalFeedInfo)
  {
    QCircleLayerBean localQCircleLayerBean = new QCircleLayerBean();
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleInitBean.setSourceType(this.g);
    localQCircleLayerBean.setFeed(paramQFSPersonalFeedInfo.a());
    localQCircleLayerBean.setDataPosInList(paramInt);
    localQCircleLayerBean.setTransInitBean(localQCircleInitBean);
    localQCircleLayerBean.setGlobalViewModelKey(this.f.m());
    return localQCircleLayerBean;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.k = ((QFSPersonalDetailsFragment)getParentFragment());
    y();
    z();
    w();
  }
  
  protected void a(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    if (paramUIStateData == null) {
      return;
    }
    boolean bool = paramUIStateData.h();
    int i3 = paramUIStateData.c();
    int i2 = 0;
    int i1 = 0;
    if (i3 != 0)
    {
      if (i3 != 1)
      {
        if (i3 != 2)
        {
          if (i3 != 3)
          {
            if (i3 == 4) {
              a(paramUIStateData.f());
            }
          }
          else {
            i1 = 1;
          }
        }
        else
        {
          B();
          b(paramUIStateData);
          break label100;
        }
      }
      else
      {
        A();
        i1 = i2;
        break label100;
      }
    }
    else if (!this.i) {
      C();
    }
    i1 = 1;
    label100:
    paramUIStateData = this.e;
    if (paramUIStateData != null)
    {
      paramUIStateData.getLoadInfo().a(bool);
      if (i1 != 0) {
        this.e.notifyLoadingComplete(true, bool);
      }
    }
  }
  
  protected boolean a(RecyclerView paramRecyclerView)
  {
    boolean bool = false;
    if (paramRecyclerView == null) {
      return false;
    }
    if (paramRecyclerView.computeVerticalScrollExtent() + paramRecyclerView.computeVerticalScrollOffset() >= paramRecyclerView.computeVerticalScrollRange()) {
      bool = true;
    }
    return bool;
  }
  
  public String b()
  {
    return "QFSPersonalFeedFragment";
  }
  
  protected void b(int paramInt)
  {
    RecyclerView localRecyclerView = this.d;
    if (localRecyclerView == null) {
      return;
    }
    localRecyclerView.stopScroll();
    if ((this.n == 0) && (this.d.getChildAt(0) != null)) {
      this.n = this.d.getChildAt(0).getHeight();
    }
    if (paramInt >= 6) {
      this.k.B().smoothScrollBy(0, this.m);
    }
    paramInt = paramInt / 3 - this.h;
    if (Math.abs(paramInt) > 8)
    {
      this.d.scrollBy(0, paramInt * this.n);
      return;
    }
    this.d.smoothScrollBy(0, paramInt * this.n);
  }
  
  protected void b(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      if (((QFSPersonalViewModel)localObject).q()) {
        return;
      }
      if ((this.e != null) && (paramUIStateData != null))
      {
        if (paramUIStateData.e() == null) {
          return;
        }
        localObject = new ArrayList();
        paramUIStateData = ((List)paramUIStateData.e()).iterator();
        while (paramUIStateData.hasNext())
        {
          FeedBlockData localFeedBlockData = (FeedBlockData)paramUIStateData.next();
          ((ArrayList)localObject).add(new QFSPersonalFeedInfo(this.f.n(), localFeedBlockData.b(), this.g));
        }
        this.e.setDatas((List)localObject);
        this.c.f();
      }
    }
  }
  
  protected int c()
  {
    return 2131627157;
  }
  
  protected List<Part> d()
  {
    ArrayList localArrayList = new ArrayList();
    this.j = new BlockPart(2131433866, x(), 2, 3);
    localArrayList.add(this.j);
    this.c = new QFSPersonalHintViewPart();
    localArrayList.add(this.c);
    return localArrayList;
  }
  
  public void h() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getArguments() == null) {
      return;
    }
    this.g = getArguments().getInt("fs_key_personal_feed_type");
  }
  
  abstract void u();
  
  protected void w()
  {
    QFSPersonalFeedAdapter localQFSPersonalFeedAdapter = this.e;
    if (localQFSPersonalFeedAdapter != null)
    {
      if (this.f == null) {
        return;
      }
      this.d = localQFSPersonalFeedAdapter.getParentRecyclerView();
      this.d.addOnScrollListener(new QFSPersonalFeedFragment.4(this));
      if (!(this.d.getLayoutManager() instanceof SafeGridLayoutManager)) {
        return;
      }
      this.l = ((SafeGridLayoutManager)this.d.getLayoutManager());
      this.d.addOnScrollListener(new QFSPersonalFeedFragment.5(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.QFSPersonalFeedFragment
 * JD-Core Version:    0.7.0.1
 */