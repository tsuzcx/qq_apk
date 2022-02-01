package com.tencent.mobileqq.apollo;

import android.view.View;
import com.tencent.mobileqq.apollo.api.render.IRenderRunner;
import com.tencent.mobileqq.apollo.utils.ApolloHttpProgressCallback;

final class ApolloRender$11
  implements ApolloHttpProgressCallback
{
  ApolloRender$11(View paramView, ApolloRender paramApolloRender, long paramLong) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_AndroidViewView instanceof IRenderRunner)) {
      ((IRenderRunner)this.jdField_a_of_type_AndroidViewView).runRenderTask(new ApolloRender.11.1(this, paramInt1, paramInt2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.11
 * JD-Core Version:    0.7.0.1
 */