package com.example.tissue;

import android.os.Looper;
import com.tencent.tissue.miniapp.hdasync.HdAsyncAction;
import com.tencent.tissue.miniapp.hdasync.HdAsyncResult;
import io.flutter.plugin.common.BasicMessageChannel.Reply;

class ApiBridge$1$3
  extends HdAsyncAction
{
  ApiBridge$1$3(ApiBridge.1 param1, Looper paramLooper, BasicMessageChannel.Reply paramReply)
  {
    super(paramLooper);
  }
  
  public HdAsyncResult call(Object paramObject)
  {
    this.val$reply.reply(paramObject);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.example.tissue.ApiBridge.1.3
 * JD-Core Version:    0.7.0.1
 */