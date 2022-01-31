package com.tencent.mobileqq.apollo.store;

import akzs;
import android.content.Intent;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;

class ApolloStoreActivity$2
  implements Runnable
{
  ApolloStoreActivity$2(ApolloStoreActivity paramApolloStoreActivity, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void run()
  {
    if (ApolloStoreActivity.a(this.this$0).a().getRender() != null) {
      ApolloRender.selectPhotoFromSystem(this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_AndroidContentIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloStoreActivity.2
 * JD-Core Version:    0.7.0.1
 */