package com.tencent.mobileqq.activity.contact.newfriend.connections;

import afak;
import ajls;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
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
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectsExplorationFriendAdapter$7.this$0.a(this.jdField_a_of_type_JavaUtilArrayList);
      afak.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectsExplorationFriendAdapter$7.this$0).setVisibility(8);
      afak.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectsExplorationFriendAdapter$7.this$0).setVisibility(8);
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectsExplorationFriendAdapter$7.a) && (!afak.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectsExplorationFriendAdapter$7.this$0)))
      {
        afak.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectsExplorationFriendAdapter$7.this$0, true);
        afak.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectsExplorationFriendAdapter$7.this$0).setVisibility(0);
        afak.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectsExplorationFriendAdapter$7.this$0).setVisibility(8);
        Bundle localBundle = new Bundle();
        localBundle.putString("from", "4");
        afak.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectsExplorationFriendAdapter$7.this$0).a(5, afak.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectsExplorationFriendAdapter$7.this$0), localBundle);
        return;
      }
      afak.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectsExplorationFriendAdapter$7.this$0).setVisibility(0);
      afak.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectsExplorationFriendAdapter$7.this$0).setText(2131633454);
      afak.c(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectsExplorationFriendAdapter$7.this$0).setVisibility(8);
      afak.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectsExplorationFriendAdapter$7.this$0).setVisibility(8);
    } while (!QLog.isColorLevel());
    QLog.d("ConnectsExplorationFriendAdapter", 2, "reloadRecommendData empty " + afak.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsConnectsExplorationFriendAdapter$7.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.connections.ConnectsExplorationFriendAdapter.7.1
 * JD-Core Version:    0.7.0.1
 */