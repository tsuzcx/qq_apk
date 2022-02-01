package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aio.panel.ApolloPanelListAdapter;
import com.tencent.mobileqq.apollo.aio.panel.ApolloPanelListView;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.view.ApolloMainInfo;
import java.util.ArrayList;
import java.util.List;

public class ApolloFavViewBinder
  extends ApolloViewBinder
{
  public ApolloFavViewBinder(Context paramContext, SessionInfo paramSessionInfo)
  {
    super(null, paramContext);
    this.l = 2;
    this.m = paramSessionInfo;
    this.q = 4;
  }
  
  public View a()
  {
    int i = this.k;
    if (i != 4)
    {
      if (i != 5)
      {
        if (this.r == null)
        {
          this.r = new ApolloPanelListView(this.i);
          this.r.setDivider(null);
          this.r.setVerticalScrollBarEnabled(true);
          this.r.setEdgeEffectEnabled(false);
          this.r.setSelector(2130853313);
        }
        return this.r;
      }
      if (this.r == null)
      {
        this.r = new ApolloPanelListView(this.i);
        this.r.setDivider(null);
        this.r.setVerticalScrollBarEnabled(true);
        this.r.setEdgeEffectEnabled(false);
        this.r.setSelector(2130853313);
      }
      return this.r;
    }
    return LayoutInflater.from(this.i).inflate(2131624176, null);
  }
  
  public ApolloInfo a(String paramString)
  {
    return new ApolloMainInfo(paramString);
  }
  
  public ArrayList<ApolloInfo> a(int paramInt)
  {
    int i = this.k;
    ArrayList localArrayList2 = null;
    ArrayList localArrayList1 = localArrayList2;
    if (i == 0)
    {
      localArrayList1 = localArrayList2;
      if (this.o != null)
      {
        if (this.o.size() == 0) {
          return null;
        }
        i = c();
        localArrayList1 = localArrayList2;
        if (paramInt >= 0)
        {
          if (paramInt >= i) {
            return null;
          }
          localArrayList1 = localArrayList2;
          if (this.r != null)
          {
            paramInt = this.r.getFirstVisiblePosition() * this.q;
            i = this.r.getLastVisiblePosition();
            int j = this.q;
            localArrayList2 = new ArrayList();
            for (;;)
            {
              localArrayList1 = localArrayList2;
              if (paramInt >= this.o.size()) {
                break;
              }
              localArrayList1 = localArrayList2;
              if (paramInt > (i + 1) * j - 1) {
                break;
              }
              localArrayList2.add(this.o.get(paramInt));
              paramInt += 1;
            }
          }
        }
      }
    }
    return localArrayList1;
  }
  
  public void a(View paramView, int paramInt)
  {
    c(paramView);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    if (this.s != null) {
      this.s.a(paramBaseChatPie);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloFavViewBinder
 * JD-Core Version:    0.7.0.1
 */