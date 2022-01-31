package com.tencent.mobileqq.apollo.view;

import ajra;
import android.content.res.Resources;

public class ApolloPanel$CmshowAppController$1
  implements Runnable
{
  public ApolloPanel$CmshowAppController$1(ajra paramajra) {}
  
  public void run()
  {
    if ((ajra.a(this.a) == 3) && (!ApolloPanel.a(this.a.a, "sp_key_apollo_show_navigate_tip")))
    {
      ApolloPanel.a(this.a.a, ApolloPanel.a(this.a.a), 49, this.a.a.getResources().getString(2131690075), 5);
      ApolloPanel.a(this.a.a, "sp_key_apollo_show_navigate_tip");
    }
    while (((ajra.a(this.a) != 0) && (ajra.a(this.a) != 2)) || (ApolloPanel.a(this.a.a, "sp_key_apollo_show_download_tip"))) {
      return;
    }
    ApolloPanel.a(this.a.a, ApolloPanel.a(this.a.a), 49, this.a.a.getResources().getString(2131690074), 5);
    ApolloPanel.a(this.a.a, "sp_key_apollo_show_download_tip");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.CmshowAppController.1
 * JD-Core Version:    0.7.0.1
 */