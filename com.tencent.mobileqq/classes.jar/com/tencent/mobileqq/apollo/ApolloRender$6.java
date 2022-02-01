package com.tencent.mobileqq.apollo;

import android.view.View;
import com.tencent.mobileqq.apollo.utils.ApolloHttpCallBack;

final class ApolloRender$6
  extends ApolloHttpCallBack
{
  ApolloRender$6(View paramView, long paramLong) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    if ((this.jdField_a_of_type_AndroidViewView instanceof ApolloSurfaceView)) {
      ((ApolloSurfaceView)this.jdField_a_of_type_AndroidViewView).runRenderTask(new ApolloRender.6.1(this, paramArrayOfByte, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.6
 * JD-Core Version:    0.7.0.1
 */