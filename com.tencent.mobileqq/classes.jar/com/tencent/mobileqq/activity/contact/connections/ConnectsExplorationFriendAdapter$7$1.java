package com.tencent.mobileqq.activity.contact.connections;

import aixj;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import anpk;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ConnectsExplorationFriendAdapter$7$1
  implements Runnable
{
  ConnectsExplorationFriendAdapter$7$1(ConnectsExplorationFriendAdapter.7 param7, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0.a(this.jdField_a_of_type_JavaUtilArrayList);
      aixj.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0).setVisibility(8);
      aixj.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0).setVisibility(8);
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.a) && (!aixj.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0)))
      {
        aixj.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0, true);
        aixj.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0).setVisibility(0);
        aixj.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0).setVisibility(8);
        Bundle localBundle = new Bundle();
        localBundle.putString("from", "4");
        aixj.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0).a(5, aixj.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0), localBundle);
        return;
      }
      aixj.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0).setVisibility(0);
      aixj.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0).setText(2131698109);
      aixj.c(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0).setVisibility(8);
      aixj.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0).setVisibility(8);
    } while (!QLog.isColorLevel());
    QLog.d("ConnectsExplorationFriendAdapter", 2, "reloadRecommendData empty " + aixj.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationFriendAdapter$7.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationFriendAdapter.7.1
 * JD-Core Version:    0.7.0.1
 */