package com.tencent.mobileqq.apollo.view;

import ajrc;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

public class ApolloPanel$CmshowAppController$4
  implements Runnable
{
  public ApolloPanel$CmshowAppController$4(ajrc paramajrc, float paramFloat) {}
  
  public void run()
  {
    if (ApolloPanel.a(this.jdField_a_of_type_Ajrc.a).getVisibility() != 0) {
      ApolloPanel.a(this.jdField_a_of_type_Ajrc.a).setVisibility(0);
    }
    ApolloPanel.a(this.jdField_a_of_type_Ajrc.a).setProgress(this.jdField_a_of_type_Float);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.CmshowAppController.4
 * JD-Core Version:    0.7.0.1
 */