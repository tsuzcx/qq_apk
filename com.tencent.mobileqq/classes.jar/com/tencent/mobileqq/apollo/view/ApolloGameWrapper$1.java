package com.tencent.mobileqq.apollo.view;

import android.app.Activity;
import com.tencent.mobileqq.apollo.process.data.CmGameMainManager;
import java.lang.ref.WeakReference;

final class ApolloGameWrapper$1
  implements Runnable
{
  ApolloGameWrapper$1(String paramString, Activity paramActivity, ApolloGameWrapper.CheckGameListener paramCheckGameListener) {}
  
  public void run()
  {
    CmGameMainManager localCmGameMainManager = CmGameMainManager.a(this.jdField_a_of_type_JavaLangString);
    if ((localCmGameMainManager == null) || (localCmGameMainManager.a == null) || (localCmGameMainManager.a.get() != this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameWrapper$CheckGameListener.a(false, localCmGameMainManager);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameWrapper$CheckGameListener.a(true, localCmGameMainManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameWrapper.1
 * JD-Core Version:    0.7.0.1
 */