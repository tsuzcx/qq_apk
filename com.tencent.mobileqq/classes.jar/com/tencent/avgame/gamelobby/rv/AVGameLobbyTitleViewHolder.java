package com.tencent.avgame.gamelobby.rv;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.avgame.gamelobby.data.AVGameLobbyTitleContentInfo;

public class AVGameLobbyTitleViewHolder
  extends BaseViewHolder<AVGameLobbyTitleContentInfo>
{
  private static final String d = "com.tencent.avgame.gamelobby.rv.AVGameLobbyTitleViewHolder";
  private TextView e;
  private Context f = null;
  
  public AVGameLobbyTitleViewHolder(@NonNull View paramView)
  {
    super(paramView);
    this.f = paramView.getContext();
    this.e = ((TextView)paramView.findViewById(2131429101));
  }
  
  protected void a()
  {
    super.a();
  }
  
  public void a(ViewHolderContext paramViewHolderContext, AVGameLobbyTitleContentInfo paramAVGameLobbyTitleContentInfo, int paramInt)
  {
    super.a(paramViewHolderContext, paramAVGameLobbyTitleContentInfo, paramInt);
    if (paramAVGameLobbyTitleContentInfo == null) {
      return;
    }
    this.e.setText(paramAVGameLobbyTitleContentInfo.a(this.f, paramAVGameLobbyTitleContentInfo.b()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyTitleViewHolder
 * JD-Core Version:    0.7.0.1
 */