package com.tencent.mobileqq.activity;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQAudioHelper;

final class ChatActivityUtils$12
  implements ChatActivityUtils.OnDownloadAsyncTaskListener
{
  ChatActivityUtils$12(Bundle paramBundle, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    QQAudioHelper.b("发起音视频_获取会议id_rsp");
    Bundle localBundle2 = this.a;
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    localBundle1.putInt("ConfAppID", paramInt1);
    localBundle1.putInt("MeetingConfID", paramInt2);
    ChatActivityUtils.a(this.b, this.c, this.d, this.e, localBundle1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils.12
 * JD-Core Version:    0.7.0.1
 */