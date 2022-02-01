package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.Editable;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.troop.data.TroopEntranceBar;

public class PAContext
  extends AIOContext
{
  public TroopEntranceBar a()
  {
    return ((PublicAccountChatPie)this.a).a;
  }
  
  public void a(Editable paramEditable)
  {
    ((PublicAccountChatPie)this.a).a(paramEditable);
  }
  
  public boolean k()
  {
    return ((PublicAccountChatPie)this.a).J;
  }
  
  public boolean l()
  {
    return ((PublicAccountChatPie)this.a).K;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PAContext
 * JD-Core Version:    0.7.0.1
 */