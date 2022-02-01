package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import android.support.v7.widget.RecyclerView;
import com.tencent.biz.subscribe.beans.RecommendInfoItem;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class TopRecommendBannerAdapter
  extends RecommendBannerContentAdaper
{
  private List<RecommendInfoItem> c = new ArrayList();
  private boolean d;
  private RecyclerView e;
  
  public TopRecommendBannerAdapter(@NotNull RecyclerView paramRecyclerView)
  {
    this.e = paramRecyclerView;
  }
  
  private void f()
  {
    RecyclerView localRecyclerView = this.e;
    if (localRecyclerView != null)
    {
      if (localRecyclerView.isComputingLayout())
      {
        ThreadManager.getUIHandler().postDelayed(new TopRecommendBannerAdapter.1(this), 500L);
        return;
      }
      notifyDataSetChanged();
    }
  }
  
  private void g()
  {
    this.c.clear();
    this.c.addAll(this.a.subList(0, 10));
    this.a = this.a.subList(10, this.a.size());
  }
  
  public List<RecommendInfoItem> a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    if (paramInt < this.c.size())
    {
      this.c.remove(paramInt);
      notifyItemRemoved(b() + paramInt);
      notifyItemRangeChanged(b() + paramInt, this.c.size() - paramInt);
    }
  }
  
  public void a(CertifiedAccountMeta.StEntry paramStEntry, List<RecommendInfoItem> paramList)
  {
    this.b = paramStEntry;
    if (this.a != null) {
      this.a.addAll(paramList);
    } else {
      this.a = paramList;
    }
    if (this.a != null)
    {
      if (this.a.size() >= 10)
      {
        g();
        f();
        return;
      }
      this.c.addAll(paramList);
      this.a.clear();
      f();
    }
  }
  
  public boolean c()
  {
    if ((this.a != null) && (this.a.size() >= 10))
    {
      g();
      f();
      return true;
    }
    return false;
  }
  
  public void d(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean d()
  {
    return (this.d) && (this.a != null) && (this.a.size() < 10);
  }
  
  public boolean e()
  {
    if ((this.a != null) && (this.a.size() > 0))
    {
      this.c.add(this.a.remove(0));
      notifyItemInserted(this.c.size());
      return true;
    }
    return false;
  }
  
  public int getItemCount()
  {
    List localList = this.c;
    if (localList != null) {
      return localList.size() + b();
    }
    return b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.TopRecommendBannerAdapter
 * JD-Core Version:    0.7.0.1
 */