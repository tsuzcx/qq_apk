package com.tencent.mobileqq.apollo.view;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;

class ApolloGameInfoFragment$1
  implements OnItemSelectListener
{
  ApolloGameInfoFragment$1(ApolloGameInfoFragment paramApolloGameInfoFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt == 1) {
      this.a.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameInfoFragment.1
 * JD-Core Version:    0.7.0.1
 */