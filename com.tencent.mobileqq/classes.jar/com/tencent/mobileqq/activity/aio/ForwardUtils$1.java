package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.net.Uri;
import asdg;
import aszj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardFileBaseOption;
import java.util.ArrayList;
import java.util.Iterator;

final class ForwardUtils$1
  implements aszj
{
  ForwardUtils$1(ArrayList paramArrayList, Context paramContext, int paramInt1, QQAppInterface paramQQAppInterface, String paramString1, int paramInt2, String paramString2) {}
  
  public void onNo() {}
  
  public void onYes()
  {
    Iterator localIterator = this.val$Uris.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Uri)localIterator.next();
      localObject = ForwardFileBaseOption.a(this.val$context, (Uri)localObject);
      if (this.val$peerType == 1) {
        this.val$app.getFileManagerEngine().a((String)localObject, this.val$uin, 0L, this.val$forwardID);
      } else {
        this.val$app.getFileManagerEngine().a((String)localObject, this.val$troop_uin, this.val$uin, this.val$peerType, true, 0L, this.val$forwardID);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils.1
 * JD-Core Version:    0.7.0.1
 */