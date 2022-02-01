package com.tencent.av.utils;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QAVGroupConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class VideoMsgTools$7$1
  implements Runnable
{
  VideoMsgTools$7$1(VideoMsgTools.7 param7, ArrayList paramArrayList) {}
  
  public void run()
  {
    Context localContext = (Context)this.this$0.b.get();
    if (localContext == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    int i;
    if (this.this$0.c == 3000) {
      i = 1;
    } else {
      i = 10;
    }
    localBundle.putInt("MultiAVType", i);
    if (this.this$0.a) {
      localBundle.putBoolean("isVideo", true);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ArrayList localArrayList = this.a;
    if (localArrayList != null) {
      localBundle.putParcelableArrayList("invitelist", localArrayList);
    }
    if (this.this$0.c == 1) {
      localBundle.putBoolean("enableInvite", QAVGroupConfig.a("selectMemberToStartGAudioChat", localQQAppInterface, this.this$0.d));
    }
    localBundle.putString("Fromwhere", this.this$0.e);
    ChatActivityUtils.a(localQQAppInterface, localContext, this.this$0.c, this.this$0.d, true, true, null, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools.7.1
 * JD-Core Version:    0.7.0.1
 */