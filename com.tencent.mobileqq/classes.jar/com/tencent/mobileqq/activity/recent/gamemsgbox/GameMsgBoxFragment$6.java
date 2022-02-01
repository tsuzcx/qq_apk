package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contacts.base.tabs.InterceptListener;
import com.tencent.mobileqq.widget.SimpleSlidingIndicator;
import com.tencent.qphone.base.util.QLog;

class GameMsgBoxFragment$6
  implements InterceptListener
{
  GameMsgBoxFragment$6(GameMsgBoxFragment paramGameMsgBoxFragment, View paramView) {}
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInterceptEvent, toIntercept=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", ScrollX=");
      localStringBuilder.append(GameMsgBoxFragment.k(this.b).getScrollX());
      QLog.d("GameMsgBoxFragment", 2, localStringBuilder.toString());
    }
    GameMsgBoxFragment.j(this.b);
    int k = GameMsgBoxFragment.k(this.b).getScrollX();
    int j = 0;
    int i = j;
    if (k <= 0) {
      if (GameMsgBoxFragment.k(this.b).getChildAt(0).getVisibility() == 4) {
        i = j;
      } else {
        i = 8;
      }
    }
    this.a.setVisibility(i);
    GameMsgBoxFragment.l(this.b).setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxFragment.6
 * JD-Core Version:    0.7.0.1
 */