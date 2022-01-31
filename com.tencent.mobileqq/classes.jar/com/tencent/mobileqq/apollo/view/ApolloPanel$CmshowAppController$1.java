package com.tencent.mobileqq.apollo.view;

import alin;
import android.content.res.Resources;

public class ApolloPanel$CmshowAppController$1
  implements Runnable
{
  public ApolloPanel$CmshowAppController$1(alin paramalin) {}
  
  public void run()
  {
    if ((alin.a(this.a) == 3) && (!ApolloPanel.a(this.a.a, "sp_key_apollo_show_navigate_tip")))
    {
      ApolloPanel.a(this.a.a, ApolloPanel.a(this.a.a), 49, this.a.a.getResources().getString(2131690122), 5);
      ApolloPanel.a(this.a.a, "sp_key_apollo_show_navigate_tip");
    }
    while (((alin.a(this.a) != 0) && (alin.a(this.a) != 2)) || (ApolloPanel.a(this.a.a, "sp_key_apollo_show_download_tip"))) {
      return;
    }
    ApolloPanel.a(this.a.a, ApolloPanel.a(this.a.a), 49, this.a.a.getResources().getString(2131690121), 5);
    ApolloPanel.a(this.a.a, "sp_key_apollo_show_download_tip");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.CmshowAppController.1
 * JD-Core Version:    0.7.0.1
 */