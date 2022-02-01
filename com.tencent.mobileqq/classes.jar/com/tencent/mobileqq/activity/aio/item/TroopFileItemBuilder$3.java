package com.tencent.mobileqq.activity.aio.item;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

class TroopFileItemBuilder$3
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder.a, this.jdField_a_of_type_Long).a(this.jdField_a_of_type_JavaUtilUUID);
      return;
    }
    new TroopFileItemOperation(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder.a, this.jdField_a_of_type_AndroidAppActivity).b(this.jdField_a_of_type_JavaUtilUUID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */