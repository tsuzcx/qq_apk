package com.tencent.mobileqq.activity.aio.item;

import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;

public class TroopPobingItemBuilder$ConfigableWordingSetter
{
  private int jdField_a_of_type_Int;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private int b;
  
  public TroopPobingItemBuilder$ConfigableWordingSetter(TroopPobingItemBuilder paramTroopPobingItemBuilder) {}
  
  public void a(int paramInt, ChatMessage paramChatMessage)
  {
    String str;
    if (this.jdField_a_of_type_AndroidWidgetEditText != null)
    {
      str = "";
      if (paramInt != 0) {
        break label181;
      }
      if (this.jdField_a_of_type_Int >= TroopPobingItemBuilder.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label225;
      }
      str = (String)TroopPobingItemBuilder.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = ((this.jdField_a_of_type_Int + 1) % TroopPobingItemBuilder.jdField_a_of_type_JavaUtilArrayList.size());
    }
    label181:
    label225:
    for (;;)
    {
      Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopPobingItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      localObject = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopPobingItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin);
      paramChatMessage = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopPobingItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopPobingItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopPobingItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramChatMessage.senderuin, (String)localObject, false, this.jdField_a_of_type_AndroidWidgetEditText, true, true);
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramChatMessage);
      this.jdField_a_of_type_AndroidWidgetEditText.append(" ");
      this.jdField_a_of_type_AndroidWidgetEditText.append(str);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
      return;
      if (this.b < TroopPobingItemBuilder.b.size())
      {
        str = (String)TroopPobingItemBuilder.b.get(this.b);
        this.b = ((this.b + 1) % TroopPobingItemBuilder.b.size());
      }
    }
  }
  
  public void a(EditText paramEditText)
  {
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopPobingItemBuilder.ConfigableWordingSetter
 * JD-Core Version:    0.7.0.1
 */