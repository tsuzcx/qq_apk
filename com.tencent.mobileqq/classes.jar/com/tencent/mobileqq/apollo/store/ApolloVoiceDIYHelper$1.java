package com.tencent.mobileqq.apollo.store;

import aiul;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;

public class ApolloVoiceDIYHelper$1
  implements Runnable
{
  public ApolloVoiceDIYHelper$1(aiul paramaiul, ApolloTextureView paramApolloTextureView, double paramDouble) {}
  
  public void run()
  {
    ApolloRender localApolloRender = this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRender();
    if ((localApolloRender != null) && (localApolloRender.getSavaWrapper() != null)) {
      localApolloRender.getSavaWrapper().a(this.jdField_a_of_type_Double);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloVoiceDIYHelper.1
 * JD-Core Version:    0.7.0.1
 */