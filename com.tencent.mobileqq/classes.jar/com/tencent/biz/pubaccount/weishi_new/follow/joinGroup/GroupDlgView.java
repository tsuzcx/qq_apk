package com.tencent.biz.pubaccount.weishi_new.follow.joinGroup;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder;
import java.util.ArrayList;
import java.util.List;

public class GroupDlgView
  extends RelativeLayout
{
  private Context a;
  private LayoutInflater b;
  private ViewGroup c;
  private RecyclerView d;
  private GroupAdapter e;
  private WSFollowFeedHolder f;
  private List<GroupEntity> g = new ArrayList();
  
  public GroupDlgView(Context paramContext, WSFollowFeedHolder paramWSFollowFeedHolder)
  {
    super(paramContext);
    this.a = paramContext;
    this.f = paramWSFollowFeedHolder;
    this.b = LayoutInflater.from(this.a);
    this.c = ((ViewGroup)this.b.inflate(2131626066, null, false));
    addView(this.c);
    this.d = ((RecyclerView)this.c.findViewById(2131437779));
    paramContext = new LinearLayoutManager(this.a);
    this.d.setLayoutManager(paramContext);
  }
  
  public void a(List<GroupEntity> paramList)
  {
    this.g.clear();
    this.g.addAll(paramList);
    this.e = new GroupAdapter(this.a, this.g, this.f);
    this.d.setAdapter(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.follow.joinGroup.GroupDlgView
 * JD-Core Version:    0.7.0.1
 */