package com.tencent.mobileqq.apollo.view;

import ammw;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

public class ApolloPanel$CmshowAppController$3
  implements Runnable
{
  public ApolloPanel$CmshowAppController$3(ammw paramammw, float paramFloat) {}
  
  public void run()
  {
    if (ApolloPanel.a(this.jdField_a_of_type_Ammw.a).getVisibility() != 0) {
      ApolloPanel.a(this.jdField_a_of_type_Ammw.a).setVisibility(0);
    }
    ApolloPanel.a(this.jdField_a_of_type_Ammw.a).setProgress(this.jdField_a_of_type_Float);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.CmshowAppController.3
 * JD-Core Version:    0.7.0.1
 */