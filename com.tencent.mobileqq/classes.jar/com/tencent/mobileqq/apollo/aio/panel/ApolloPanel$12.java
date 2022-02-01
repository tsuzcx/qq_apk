package com.tencent.mobileqq.apollo.aio.panel;

import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloViewBinder;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.widget.HorizontalListView;
import java.util.List;

class ApolloPanel$12
  implements Runnable
{
  ApolloPanel$12(ApolloPanel paramApolloPanel, List paramList) {}
  
  public void run()
  {
    if (ApolloPanel.v(this.this$0) == null) {
      return;
    }
    ApolloPanel.r(this.this$0).clear();
    ApolloPanel.r(this.this$0).addAll(this.a);
    int i = ApolloPanel.a;
    ApolloPanel.v(this.this$0).notifyDataSetChanged();
    if ((ApolloPanel.a != i) && (ApolloPanel.w(this.this$0))) {
      ApolloPanel.a = i;
    }
    ApolloPanel.x(this.this$0).clear();
    i = 0;
    int k;
    for (int j = 0; i < ApolloPanel.r(this.this$0).size(); j = k)
    {
      k = j;
      if (ApolloPanel.x(this.this$0) != null)
      {
        k = j + ((ApolloViewBinder)ApolloPanel.r(this.this$0).get(i)).c();
        ApolloPanel.x(this.this$0).add(Integer.valueOf(k - 1));
      }
      i += 1;
    }
    ApolloPanel.y(this.this$0).setCurrentItem(ApolloPanel.a, false);
    if (ApolloPanel.u(this.this$0) != null) {
      ApolloPanel.u(this.this$0).postDelayed(new ApolloPanel.12.1(this), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.12
 * JD-Core Version:    0.7.0.1
 */