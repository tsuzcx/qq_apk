package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxFragment;
import com.tencent.mobileqq.utils.JumpAction;

public class GameMsgBoxParser$GameMsgBoxJumpAction
  extends JumpAction
{
  protected GameMsgBoxParser$GameMsgBoxJumpAction(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    super(paramBaseQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    PublicFragmentActivity.a(this.b, GameMsgBoxFragment.class);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.GameMsgBoxParser.GameMsgBoxJumpAction
 * JD-Core Version:    0.7.0.1
 */