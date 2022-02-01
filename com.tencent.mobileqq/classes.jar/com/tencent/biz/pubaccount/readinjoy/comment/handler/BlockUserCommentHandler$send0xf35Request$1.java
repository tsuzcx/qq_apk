package com.tencent.biz.pubaccount.readinjoy.comment.handler;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/comment/handler/BlockUserCommentHandler$send0xf35Request$1", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "onError", "", "errorCode", "", "errorMsg", "", "bundle", "Landroid/os/Bundle;", "onResult", "", "data", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class BlockUserCommentHandler$send0xf35Request$1
  extends ProtoUtils.TroopProtocolObserver
{
  public void a(int paramInt, @Nullable byte[] paramArrayOfByte, @Nullable Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      this.a.a(paramArrayOfByte);
      return;
    }
    BlockUserCommentHandler.a(this.a, paramInt, "Empty error message.", false, 4, null);
  }
  
  public boolean a(int paramInt, @Nullable String paramString, @Nullable Bundle paramBundle)
  {
    paramBundle = this.a;
    if (paramString != null) {}
    for (;;)
    {
      BlockUserCommentHandler.a(paramBundle, paramInt, paramString, false, 4, null);
      return true;
      paramString = "Empty error message.";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.handler.BlockUserCommentHandler.send0xf35Request.1
 * JD-Core Version:    0.7.0.1
 */