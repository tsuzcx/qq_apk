package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aio.panel.ApolloPanelListAdapter;
import com.tencent.mobileqq.apollo.aio.panel.ApolloPanelListView;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.view.ApolloMainInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public class ApolloSlaveViewBinder
  extends ApolloViewBinder
  implements View.OnClickListener
{
  public ApolloSlaveViewBinder(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext);
    this.l = 4;
    this.m = paramSessionInfo;
    this.q = 2;
  }
  
  public View a()
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
  
  public ApolloInfo a(String paramString)
  {
    return new ApolloMainInfo(paramString);
  }
  
  public ArrayList<ApolloInfo> a(int paramInt)
  {
    int i = this.k;
    ArrayList localArrayList2 = null;
    ArrayList localArrayList1 = localArrayList2;
    if (i == 9)
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
  
  public void b()
  {
    this.o = null;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloSlaveViewBinder
 * JD-Core Version:    0.7.0.1
 */