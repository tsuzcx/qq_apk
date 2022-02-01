package com.tencent.mobileqq.activity.aio.item;

import android.os.SystemClock;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class PokeEmoItemBuilder$2
  implements ActionSheet.OnButtonClickListener
{
  PokeEmoItemBuilder$2(PokeEmoItemBuilder paramPokeEmoItemBuilder, MessageForPokeEmo paramMessageForPokeEmo, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      long l = SystemClock.uptimeMillis();
      if (l - this.c.a < 500L) {
        return;
      }
      paramView = this.c;
      paramView.a = l;
      ChatActivityFacade.b(paramView.d, this.c.e, this.c.f, this.a.uniseq);
    }
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PokeEmoItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */