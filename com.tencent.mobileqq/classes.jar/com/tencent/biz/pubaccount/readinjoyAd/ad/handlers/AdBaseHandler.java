package com.tencent.biz.pubaccount.readinjoyAd.ad.handlers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IBaseHandler;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.Nullable;

public abstract class AdBaseHandler
  implements IBaseHandler
{
  private IReadInJoyBaseAdapter a;
  private ViewGroup b;
  
  public int a()
  {
    return this.a.c();
  }
  
  @Nullable
  public View a(int paramInt, @Nullable View paramView, @Nullable ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public Integer a(int paramInt)
  {
    return Integer.valueOf(this.a.getItemViewType(paramInt));
  }
  
  public void a(int paramInt1, int paramInt2, @Nullable Intent paramIntent) {}
  
  public void a(int paramInt, @Nullable List<Long> paramList) {}
  
  public void a(@Nullable Context paramContext, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable String paramString, int paramInt) {}
  
  public void a(@Nullable View paramView1, @Nullable View paramView2, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt) {}
  
  public void a(@Nullable View paramView, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt) {}
  
  public void a(@Nullable View paramView, @Nullable ListView paramListView) {}
  
  public void a(@Nullable View paramView, @Nullable ListView paramListView, long paramLong) {}
  
  public void a(ViewGroup paramViewGroup)
  {
    this.b = paramViewGroup;
  }
  
  public final void a(IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter)
  {
    this.a = paramIReadInJoyBaseAdapter;
  }
  
  public void a(@Nullable AbsListView paramAbsListView) {}
  
  public void a(@Nullable AbsListView paramAbsListView, int paramInt) {}
  
  public void a(@Nullable AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(@Nullable AdapterView<?> paramAdapterView, @Nullable View paramView, int paramInt, long paramLong) {}
  
  public void a(@Nullable List<? extends AbsBaseArticleInfo> paramList) {}
  
  public void a(@Nullable Map<Integer, ? extends BaseReportData> paramMap) {}
  
  public void a(@Nullable Map<Long, ? extends BaseReportData> paramMap, boolean paramBoolean) {}
  
  public void a(@Nullable Set<Long> paramSet, @Nullable Map<Long, ? extends BaseReportData> paramMap) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean1, int paramInt, @Nullable List<Long> paramList, boolean paramBoolean2) {}
  
  public final IReadInJoyBaseAdapter b()
  {
    return this.a;
  }
  
  public final Object b(int paramInt)
  {
    return this.a.getItem(paramInt);
  }
  
  public void b(boolean paramBoolean1, int paramInt, @Nullable List<Long> paramList, boolean paramBoolean2) {}
  
  public final Activity c()
  {
    return this.a.a();
  }
  
  public void c(int paramInt) {}
  
  public ViewGroup d()
  {
    return this.b;
  }
  
  public boolean d(int paramInt)
  {
    return false;
  }
  
  public int e()
  {
    return this.a.i();
  }
  
  public int f()
  {
    return this.a.getCount();
  }
  
  public boolean g()
  {
    return this.a.j();
  }
  
  public AnimationSet h()
  {
    return this.a.k();
  }
  
  public final IFaceDecoder i()
  {
    return this.a.l();
  }
  
  public void j() {}
  
  public void k() {}
  
  public void l() {}
  
  public void m() {}
  
  public void n() {}
  
  public void o() {}
  
  @Nullable
  public Boolean p()
  {
    return null;
  }
  
  public void q() {}
  
  public void r() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.handlers.AdBaseHandler
 * JD-Core Version:    0.7.0.1
 */