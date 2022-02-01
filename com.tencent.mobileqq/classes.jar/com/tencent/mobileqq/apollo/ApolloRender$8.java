package com.tencent.mobileqq.apollo;

import android.view.View;
import com.tencent.mobileqq.apollo.utils.ApolloHttpCallBack;

final class ApolloRender$8
  extends ApolloHttpCallBack
{
  ApolloRender$8(View paramView, long paramLong) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    if ((this.jdField_a_of_type_AndroidViewView instanceof ApolloSurfaceView)) {
      ((ApolloSurfaceView)this.jdField_a_of_type_AndroidViewView).runRenderTask(new ApolloRender.8.1(this, paramInt, paramArrayOfByte));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.8
 * JD-Core Version:    0.7.0.1
 */