package com.tencent.avgame.gamelobby.rv;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.avgame.gamelobby.data.AVGameLobbyTitleContentInfo;

public class AVGameLobbyTitleViewHolder
  extends BaseViewHolder<AVGameLobbyTitleContentInfo>
{
  private static final String jdField_a_of_type_JavaLangString = AVGameLobbyTitleViewHolder.class.getName();
  private Context jdField_a_of_type_AndroidContentContext = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public AVGameLobbyTitleViewHolder(@NonNull View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363295));
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
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAVGameLobbyTitleContentInfo.a(this.jdField_a_of_type_AndroidContentContext, paramAVGameLobbyTitleContentInfo.c()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyTitleViewHolder
 * JD-Core Version:    0.7.0.1
 */