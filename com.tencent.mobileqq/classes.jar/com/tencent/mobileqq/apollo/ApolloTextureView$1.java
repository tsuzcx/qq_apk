package com.tencent.mobileqq.apollo;

class ApolloTextureView$1
  implements Runnable
{
  ApolloTextureView$1(ApolloTextureView paramApolloTextureView) {}
  
  public void run()
  {
    ApolloRender localApolloRender = this.this$0.getRender();
    if ((localApolloRender != null) && (localApolloRender.getSavaWrapper() != null))
    {
      double d = 0.0D;
      if (localApolloRender.mIsFrameMode) {
        d = localApolloRender.mDuration;
      }
      localApolloRender.getSavaWrapper().a(d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloTextureView.1
 * JD-Core Version:    0.7.0.1
 */