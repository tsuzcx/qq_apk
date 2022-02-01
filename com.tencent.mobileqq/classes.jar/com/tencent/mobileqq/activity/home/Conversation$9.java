package com.tencent.mobileqq.activity.home;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;

class Conversation$9
  implements View.OnLayoutChangeListener
{
  Conversation$9(Conversation paramConversation) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    Conversation.i(this.a).removeOnLayoutChangeListener(this);
    Conversation.o(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.9
 * JD-Core Version:    0.7.0.1
 */