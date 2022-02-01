package com.tencent.avgame.gamelobby.rv;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.avgame.gamelobby.data.AVGameLobbyFeedbackContentInfo;

public class AVGameLobbyFeedbackCellViewHolder
  extends BaseViewHolder<AVGameLobbyFeedbackContentInfo>
{
  private TextView a;
  
  public AVGameLobbyFeedbackCellViewHolder(@NonNull View paramView)
  {
    super(paramView);
    this.a = ((TextView)paramView.findViewById(2131366746));
    a(this.a);
  }
  
  public void a(ViewHolderContext paramViewHolderContext, AVGameLobbyFeedbackContentInfo paramAVGameLobbyFeedbackContentInfo, int paramInt)
  {
    super.a(paramViewHolderContext, paramAVGameLobbyFeedbackContentInfo, paramInt);
    if (paramAVGameLobbyFeedbackContentInfo == null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyFeedbackCellViewHolder
 * JD-Core Version:    0.7.0.1
 */