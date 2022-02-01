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
    if (paramEditText != null)
    {
      if (paramInt == 0)
      {
        double d1 = Math.random();
        double d2 = TroopManager.b.size();
        Double.isNaN(d2);
        this.a = ((int)(d1 * d2));
        if (TroopManager.b.size() == 1)
        {
          str = (String)TroopManager.b.get(0);
          TroopManager.a(paramQQAppInterface);
          break label162;
        }
        if (this.a < TroopManager.b.size())
        {
          str = (String)TroopManager.b.get(this.a);
          TroopManager.b.remove(this.a);
          break label162;
        }
      }
      else if (this.b < TroopManager.c.size())
      {
        str = (String)TroopManager.c.get(this.b);
        this.b = ((this.b + 1) % TroopManager.c.size());
        break label162;
      }
      String str = "";
      label162:
      Object localObject = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      localObject = ContactUtils.b(paramQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin);
      paramEditText.setText(AtTroopMemberSpan.a(paramQQAppInterface, paramContext, paramString, paramChatMessage.senderuin, (String)localObject, false, paramEditText, true, true));
      paramEditText.append(str);
      paramEditText.setSelection(paramEditText.getText().length());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager.ConfigableWordingSetter
 * JD-Core Version:    0.7.0.1
 */