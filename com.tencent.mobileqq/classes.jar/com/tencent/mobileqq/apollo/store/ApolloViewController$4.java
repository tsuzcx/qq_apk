package com.tencent.mobileqq.apollo.store;

import android.os.Message;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView;
import com.tencent.util.WeakReferenceHandler;

class ApolloViewController$4
  implements OnApolloViewListener
{
  ApolloViewController$4(ApolloViewController paramApolloViewController, DisplayMetrics paramDisplayMetrics, ApolloViewController.PlayActionData paramPlayActionData) {}
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString) {}
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    ApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController, true);
    float f = this.jdField_a_of_type_AndroidUtilDisplayMetrics.density;
    ApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController, paramInt1 / 2 / f);
    if ((ApolloViewController.b(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController) != null) && (ApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController) != null) && (ApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController) != null))
    {
      ApolloViewController.b(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController).onExecDispose();
      ApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController).onExecDispose();
      Message localMessage = ApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController).obtainMessage(19, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController$PlayActionData.c, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController$PlayActionData.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController$PlayActionData.a) {
        localMessage.obj = Float.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController$PlayActionData.jdField_b_of_type_Float);
      }
      ApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController).sendMessageDelayed(localMessage, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloViewController.4
 * JD-Core Version:    0.7.0.1
 */