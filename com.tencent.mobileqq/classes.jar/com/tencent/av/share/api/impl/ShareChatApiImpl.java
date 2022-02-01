package com.tencent.av.share.api.impl;

import android.content.Intent;
import android.view.View;
import com.tencent.av.share.ShareChat;
import com.tencent.av.share.api.IShareChatApi;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.utils.JumpAction;

public class ShareChatApiImpl
  implements IShareChatApi
{
  public int getLinkTypeNeedVerify()
  {
    return 0;
  }
  
  public int getLinkTypeNoVerify()
  {
    return 1;
  }
  
  public boolean jump(JumpAction paramJumpAction)
  {
    return ShareChat.a(paramJumpAction);
  }
  
  public void share(BaseQQAppInterface paramBaseQQAppInterface, QBaseActivity paramQBaseActivity, View paramView, Intent paramIntent)
  {
    ShareChat.a(paramBaseQQAppInterface, paramQBaseActivity, paramView, paramIntent);
  }
  
  public boolean shareGAVArkMsg(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    return ShareChat.a(paramBaseQQAppInterface, paramString1, paramString2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.share.api.impl.ShareChatApiImpl
 * JD-Core Version:    0.7.0.1
 */