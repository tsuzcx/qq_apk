package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.model.ApolloBattleGameInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import java.util.List;

public class ApolloBattleGameViewBinder
  extends ApolloViewBinder
{
  private RecyclerView a;
  private ApolloBattleGameViewBinder.ApolloBattleGameListAdapter b;
  private List<ApolloBattleGameInfo> c;
  private View d;
  private View e;
  private int f;
  
  public ApolloBattleGameViewBinder(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext);
    this.m = paramSessionInfo;
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(this.i).inflate(2131624167, null);
    this.a = ((RecyclerView)localView.findViewById(2131431356));
    this.a.setLayoutManager(new GridLayoutManager(this.i, 2));
    int i = ViewUtils.dip2px(9.0F);
    this.a.addItemDecoration(new ApolloBattleGameViewBinder.GridSpaceingItemDecoration(this, 2, i, i, ViewUtils.dip2px(26.0F)));
    this.d = localView.findViewById(2131437664);
    this.e = localView.findViewById(2131439330);
    if (ThemeUtil.isNowThemeIsNight(this.j, false, null))
    {
      this.e.setVisibility(0);
      return localView;
    }
    this.e.setVisibility(8);
    return localView;
  }
  
  public void a(int paramInt, List<ApolloBattleGameInfo> paramList)
  {
    this.f = paramInt;
    this.c = paramList;
    ApolloBattleGameViewBinder.ApolloBattleGameListAdapter localApolloBattleGameListAdapter = this.b;
    if (localApolloBattleGameListAdapter != null) {
      localApolloBattleGameListAdapter.a(paramList);
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    super.a(paramView, paramInt);
    if (this.b == null) {
      this.b = new ApolloBattleGameViewBinder.ApolloBattleGameListAdapter(this);
    }
    this.b.a(this.c);
    this.a.setAdapter(this.b);
  }
  
  public void b()
  {
    super.b();
    this.j = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloBattleGameViewBinder
 * JD-Core Version:    0.7.0.1
 */