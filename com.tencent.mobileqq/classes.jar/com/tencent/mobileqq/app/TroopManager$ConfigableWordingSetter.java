package com.tencent.mobileqq.app;

import android.content.Context;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;

public class TroopManager$ConfigableWordingSetter
{
  private int a = 0;
  private int b = 0;
  
  TroopManager$ConfigableWordingSetter(QQAppInterface paramQQAppInterface)
  {
    TroopManager.a(paramQQAppInterface);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, String paramString, int paramInt, ChatMessage paramChatMessage)
  {
    String str;
    if (paramEditText != null)
    {
      str = "";
      if (paramInt != 0) {
        break label167;
      }
      this.a = ((int)(Math.random() * TroopManager.b.size()));
      if (TroopManager.b.size() != 1) {
        break label125;
      }
      str = (String)TroopManager.b.get(0);
      TroopManager.a(paramQQAppInterface);
    }
    label167:
    for (;;)
    {
      Object localObject = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      localObject = ContactUtils.g(paramQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin);
      paramEditText.setText(AtTroopMemberSpan.a(paramQQAppInterface, paramContext, paramString, paramChatMessage.senderuin, (String)localObject, false, paramEditText, true, true));
      paramEditText.append(str);
      paramEditText.setSelection(paramEditText.getText().length());
      return;
      label125:
      if (this.a < TroopManager.b.size())
      {
        str = (String)TroopManager.b.get(this.a);
        TroopManager.b.remove(this.a);
        continue;
        if (this.b < TroopManager.c.size())
        {
          str = (String)TroopManager.c.get(this.b);
          this.b = ((this.b + 1) % TroopManager.c.size());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager.ConfigableWordingSetter
 * JD-Core Version:    0.7.0.1
 */