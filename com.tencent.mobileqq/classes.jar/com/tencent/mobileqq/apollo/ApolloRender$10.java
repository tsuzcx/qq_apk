package com.tencent.mobileqq.apollo;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.apollo.api.render.IRenderRunner;
import com.tencent.mobileqq.apollo.utils.ApolloHttpResponseCallback;
import java.util.Map;

final class ApolloRender$10
  implements ApolloHttpResponseCallback
{
  ApolloRender$10(View paramView, long paramLong, String paramString1, String paramString2, ApolloRender paramApolloRender) {}
  
  public void a(int paramInt, @NonNull Map<String, String> paramMap, @NonNull byte[] paramArrayOfByte)
  {
    if ((this.jdField_a_of_type_AndroidViewView instanceof IRenderRunner)) {
      ((IRenderRunner)this.jdField_a_of_type_AndroidViewView).runRenderTask(new ApolloRender.10.1(this, paramMap, paramInt, paramArrayOfByte));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.10
 * JD-Core Version:    0.7.0.1
 */