package com.tencent.mobileqq.activity.contact.connections;

import amvo;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

class ConnectionsExplorationFragment$2$1
  implements Runnable
{
  ConnectionsExplorationFragment$2$1(ConnectionsExplorationFragment.2 param2, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      ConnectionsExplorationFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationFragment$2.this$0).clear();
      ConnectionsExplorationFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationFragment$2.this$0).addAll(this.jdField_a_of_type_JavaUtilArrayList);
      ConnectionsExplorationFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationFragment$2.this$0);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationFragment$2.a)
      {
        if (ConnectionsExplorationFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationFragment$2.this$0) != null) {
          ConnectionsExplorationFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationFragment$2.this$0).a(ConnectionsExplorationFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationFragment$2.this$0));
        }
        ConnectionsExplorationFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationFragment$2.this$0).setVisibility(0);
        ConnectionsExplorationFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationFragment$2.this$0).setVisibility(8);
      }
    }
    do
    {
      return;
      ConnectionsExplorationFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationFragment$2.this$0).setVisibility(8);
      ConnectionsExplorationFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationFragment$2.this$0).setVisibility(0);
    } while (!this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationFragment$2.b);
    ConnectionsExplorationFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsExplorationFragment$2.this$0).c(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationFragment.2.1
 * JD-Core Version:    0.7.0.1
 */