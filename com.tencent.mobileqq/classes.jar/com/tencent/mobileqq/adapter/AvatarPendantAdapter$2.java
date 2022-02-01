package com.tencent.mobileqq.adapter;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AvatarPendantAdapter$2
  implements View.OnLayoutChangeListener
{
  AvatarPendantAdapter$2(AvatarPendantAdapter paramAvatarPendantAdapter) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    View localView = paramView.findViewById(2131432040);
    TextView localTextView = (TextView)paramView.findViewById(2131432039);
    paramInt1 = ((ImageView)paramView.findViewById(2131446657)).getRight() - localView.getWidth();
    if (paramInt1 > 0) {
      ThreadManager.getUIHandler().post(new AvatarPendantAdapter.2.1(this, localTextView, paramInt1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.AvatarPendantAdapter.2
 * JD-Core Version:    0.7.0.1
 */