package com.tencent.comic.emoticon;

import android.os.Bundle;
import com.tencent.comic.api.IQQComicEmoticonService.IQQComicEmoUploadCallback;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;

class VipComicEmoticonUploadRemoteCmd$1
  implements IQQComicEmoticonService.IQQComicEmoUploadCallback
{
  VipComicEmoticonUploadRemoteCmd$1(VipComicEmoticonUploadRemoteCmd paramVipComicEmoticonUploadRemoteCmd, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener) {}
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkIpcRemoteCommand$OnInvokeFinishLinstener.onInvokeFinish(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.emoticon.VipComicEmoticonUploadRemoteCmd.1
 * JD-Core Version:    0.7.0.1
 */