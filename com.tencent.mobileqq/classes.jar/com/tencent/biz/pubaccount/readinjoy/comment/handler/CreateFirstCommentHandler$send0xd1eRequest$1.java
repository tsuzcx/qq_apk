package com.tencent.biz.pubaccount.readinjoy.comment.handler;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.FirstCommentCreateRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/comment/handler/CreateFirstCommentHandler$send0xd1eRequest$1", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "onError", "", "errorCode", "", "errorMsg", "", "bundle", "Landroid/os/Bundle;", "onResult", "", "data", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CreateFirstCommentHandler$send0xd1eRequest$1
  extends ProtoUtils.TroopProtocolObserver
{
  public void a(int paramInt, @Nullable byte[] paramArrayOfByte, @Nullable Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      CreateFirstCommentHandler.a(this.a, paramArrayOfByte);
      return;
    }
    this.a.a(CreateFirstCommentHandler.a(this.a, paramArrayOfByte), paramInt, "Empty error message.");
  }
  
  public boolean a(int paramInt, @Nullable String paramString, @Nullable Bundle paramBundle)
  {
    paramBundle = this.a;
    oidb_0xd1e.FirstCommentCreateRsp localFirstCommentCreateRsp = CreateFirstCommentHandler.a(this.a, null);
    if (paramString != null) {}
    for (;;)
    {
      paramBundle.a(localFirstCommentCreateRsp, paramInt, paramString);
      return true;
      paramString = "Empty error message.";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.handler.CreateFirstCommentHandler.send0xd1eRequest.1
 * JD-Core Version:    0.7.0.1
 */