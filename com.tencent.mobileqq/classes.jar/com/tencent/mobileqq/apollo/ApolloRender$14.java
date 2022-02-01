package com.tencent.mobileqq.apollo;

import android.view.View;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;

final class ApolloRender$14
  implements HandshakeCompletedListener
{
  ApolloRender$14(View paramView, long paramLong) {}
  
  public void handshakeCompleted(HandshakeCompletedEvent paramHandshakeCompletedEvent)
  {
    ((ApolloSurfaceView)this.jdField_a_of_type_AndroidViewView).runRenderTask(new ApolloRender.14.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.14
 * JD-Core Version:    0.7.0.1
 */