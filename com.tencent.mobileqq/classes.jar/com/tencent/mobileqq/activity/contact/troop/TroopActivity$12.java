package com.tencent.mobileqq.activity.contact.troop;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;

class TroopActivity$12
  implements Runnable
{
  TroopActivity$12(TroopActivity paramTroopActivity) {}
  
  public void run()
  {
    if (this.this$0.f)
    {
      int i = this.this$0.app.a().b();
      TextView localTextView = (TextView)this.this$0.findViewById(2131378616);
      ImageView localImageView = (ImageView)this.this$0.findViewById(2131368979);
      localTextView.setVisibility(0);
      localImageView.setVisibility(0);
      localTextView.setText("" + i);
      if (i <= 0) {
        localTextView.setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopActivity.12
 * JD-Core Version:    0.7.0.1
 */