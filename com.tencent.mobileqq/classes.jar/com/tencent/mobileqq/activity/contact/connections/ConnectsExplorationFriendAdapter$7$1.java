package com.tencent.mobileqq.activity.contact.connections;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ConnectsExplorationFriendAdapter$7$1
  implements Runnable
{
  ConnectsExplorationFriendAdapter$7$1(ConnectsExplorationFriendAdapter.7 param7, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0.a(this.jdField_a_of_type_JavaUtilArrayList);
      ConnectsExplorationFriendAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0).setVisibility(8);
      ConnectsExplorationFriendAdapter.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0).setVisibility(8);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.a) && (!ConnectsExplorationFriendAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0)))
    {
      ConnectsExplorationFriendAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0, true);
      ConnectsExplorationFriendAdapter.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0).setVisibility(0);
      ConnectsExplorationFriendAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0).setVisibility(8);
      localObject = new Bundle();
      ((Bundle)localObject).putString("from", "4");
      ConnectsExplorationFriendAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0).a(5, ConnectsExplorationFriendAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0), (Bundle)localObject);
      return;
    }
    ConnectsExplorationFriendAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0).setVisibility(0);
    ConnectsExplorationFriendAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0).setText(2131699053);
    ConnectsExplorationFriendAdapter.c(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0).setVisibility(8);
    ConnectsExplorationFriendAdapter.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0).setVisibility(8);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reloadRecommendData empty ");
      ((StringBuilder)localObject).append(ConnectsExplorationFriendAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0));
      QLog.d("ConnectsExplorationFriendAdapter", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationFriendAdapter.7.1
 * JD-Core Version:    0.7.0.1
 */