package com.tencent.mobileqq.apollo;

import akmn;
import bhow;
import java.lang.ref.WeakReference;

class ApolloRenderDriver$RenderRunnable
  implements Runnable
{
  private WeakReference<ApolloRenderDriver> a;
  
  public ApolloRenderDriver$RenderRunnable(ApolloRenderDriver paramApolloRenderDriver)
  {
    this.a = new WeakReference(paramApolloRenderDriver);
  }
  
  public void run()
  {
    ApolloRenderDriver localApolloRenderDriver;
    if ((this.a != null) && (this.a.get() != null))
    {
      localApolloRenderDriver = (ApolloRenderDriver)this.a.get();
      if ((localApolloRenderDriver != null) && (localApolloRenderDriver.jdField_a_of_type_Akmn != null) && (localApolloRenderDriver.jdField_a_of_type_Bhow != null))
      {
        localApolloRenderDriver.jdField_a_of_type_Akmn.onRender();
        if (((ApolloRenderDriver)this.a.get()).jdField_a_of_type_Int <= 0) {
          break label101;
        }
      }
    }
    label101:
    for (int i = 1000 / ((ApolloRenderDriver)this.a.get()).jdField_a_of_type_Int;; i = 50)
    {
      localApolloRenderDriver.jdField_a_of_type_Bhow.postDelayed(this, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRenderDriver.RenderRunnable
 * JD-Core Version:    0.7.0.1
 */