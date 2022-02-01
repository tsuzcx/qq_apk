package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aio.panel.ApolloPanelListAdapter;
import com.tencent.mobileqq.apollo.aio.panel.ApolloPanelListView;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.List;

public class ApolloViewBinder
{
  private EmotionPanelListView.PullAndFastScrollListener a;
  private int b;
  private AbsListView.OnScrollListener c;
  public Context i;
  protected QQAppInterface j;
  public int k = 0;
  public int l;
  public SessionInfo m;
  public int n;
  public List<ApolloInfo> o;
  protected int p = -1;
  protected int q = 4;
  protected ApolloPanelListView r;
  protected ApolloPanelListAdapter s;
  
  public ApolloViewBinder(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.j = paramQQAppInterface;
    this.i = paramContext;
  }
  
  public View a()
  {
    return null;
  }
  
  public ApolloInfo a(String paramString)
  {
    return null;
  }
  
  public ArrayList<ApolloInfo> a(int paramInt)
  {
    return null;
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(BaseChatPie paramBaseChatPie) {}
  
  public void a(EmotionPanelListView.PullAndFastScrollListener paramPullAndFastScrollListener)
  {
    this.a = paramPullAndFastScrollListener;
  }
  
  public void a(List<ApolloInfo> paramList)
  {
    this.o = paramList;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    this.k = paramInt;
  }
  
  public int c()
  {
    return 1;
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloViewBinder", 2, new Object[] { "[setHighlightItemIndex] highlightItemIndex=", Integer.valueOf(paramInt) });
    }
    List localList = this.o;
    if ((localList != null) && (localList.size() != 0))
    {
      if ((paramInt >= 0) && (paramInt < this.o.size()))
      {
        this.p = paramInt;
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloViewBinder", 2, new Object[] { "[setHighlightItemIndex] set success, highlightItemIndex=", Integer.valueOf(paramInt) });
        }
      }
      return;
    }
    QLog.e("[cmshow]ApolloViewBinder", 1, "[setHighlightItemIndex] no panel data, set failed");
  }
  
  protected void c(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (this.s == null) {
      this.s = new ApolloPanelListAdapter(this.j, this.i);
    }
    if (this.c == null) {
      this.c = new ApolloViewBinder.1(this);
    }
    this.s.a(this.m);
    this.s.a(this.l);
    this.s.b(this.q);
    this.s.c(this.p);
    this.s.a(this.o);
    if ((paramView instanceof ApolloPanelListView))
    {
      paramView = (ApolloPanelListView)paramView;
      paramView.setPullAndFastScrollListener(this.a);
      paramView.setOnScrollListener(this.c);
      paramView.setAdapter(this.s);
      int i3 = this.p;
      if (i3 != -1)
      {
        int i4 = this.q;
        int i2 = i3 / i4;
        int i1 = i2;
        if (i3 % i4 != 0) {
          i1 = i2 + 1;
        }
        if (i1 < this.s.getCount()) {
          paramView.smoothScrollToPosition(i1);
        }
      }
    }
  }
  
  public int d(int paramInt)
  {
    return 0;
  }
  
  public View i()
  {
    View localView = a();
    a(localView, 0);
    return localView;
  }
  
  public List<ApolloInfo> j()
  {
    return this.o;
  }
  
  public ApolloPanelListAdapter k()
  {
    return this.s;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloViewBinder
 * JD-Core Version:    0.7.0.1
 */