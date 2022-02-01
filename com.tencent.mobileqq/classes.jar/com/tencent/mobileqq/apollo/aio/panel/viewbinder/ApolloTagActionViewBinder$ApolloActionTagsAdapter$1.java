package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

class ApolloTagActionViewBinder$ApolloActionTagsAdapter$1
  implements View.OnClickListener
{
  ApolloTagActionViewBinder$ApolloActionTagsAdapter$1(ApolloTagActionViewBinder.ApolloActionTagsAdapter paramApolloActionTagsAdapter, Button paramButton) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    if (paramView != null)
    {
      if (paramView.getText() == null) {
        return;
      }
      ApolloTagActionViewBinder.ApolloActionTagsAdapter.a(this.b, this.a.getText().toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloTagActionViewBinder.ApolloActionTagsAdapter.1
 * JD-Core Version:    0.7.0.1
 */