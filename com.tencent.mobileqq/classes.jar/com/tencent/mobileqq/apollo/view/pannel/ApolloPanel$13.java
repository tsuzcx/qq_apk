package com.tencent.mobileqq.apollo.view.pannel;

import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloViewBinder;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.widget.HorizontalListView;
import java.util.List;

class ApolloPanel$13
  implements Runnable
{
  ApolloPanel$13(ApolloPanel paramApolloPanel, List paramList) {}
  
  public void run()
  {
    if ((ApolloPanel.a(this.this$0) == null) || (ApolloPanel.a(this.this$0) == null)) {}
    do
    {
      return;
      ApolloPanel.b(this.this$0).clear();
      ApolloPanel.b(this.this$0).addAll(this.a);
      int i = ApolloPanel.a;
      ApolloPanel.a(this.this$0).notifyDataSetChanged();
      if ((ApolloPanel.a != i) && (ApolloPanel.c(this.this$0))) {
        ApolloPanel.a = i;
      }
      ApolloPanel.c(this.this$0).clear();
      i = 0;
      int k;
      for (int j = 0; i < ApolloPanel.b(this.this$0).size(); j = k)
      {
        k = j;
        if (ApolloPanel.c(this.this$0) != null)
        {
          k = j + ((ApolloViewBinder)ApolloPanel.b(this.this$0).get(i)).a();
          ApolloPanel.c(this.this$0).add(Integer.valueOf(k - 1));
        }
        i += 1;
      }
      ApolloPanel.a(this.this$0).setCurrentItem(ApolloPanel.a, false);
    } while (ApolloPanel.a(this.this$0) == null);
    ApolloPanel.a(this.this$0).postDelayed(new ApolloPanel.13.1(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.13
 * JD-Core Version:    0.7.0.1
 */