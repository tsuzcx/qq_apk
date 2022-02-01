package com.tencent.mobileqq.activity.aio;

import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.CGILoader;
import com.tencent.mobileqq.webview.swift.utils.BaseOpenWebMonitor;

public class AIOOpenWebMonitor
  extends BaseOpenWebMonitor
{
  public static void a(Intent paramIntent, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (SystemClock.uptimeMillis() % 10L != 1L) {
      return;
    }
    int j = CGILoader.a(paramMessageRecord.istroop);
    if (WebAccelerator.a) {
      i = 1;
    } else {
      i = 2;
    }
    a(paramIntent, j, i);
    paramIntent = paramMessageRecord.frienduin;
    long l = paramMessageRecord.msgUid;
    int i = paramMessageRecord.istroop;
    if (TextUtils.isEmpty(paramIntent)) {
      return;
    }
    ThreadManager.post(new AIOOpenWebMonitor.1(paramQQAppInterface, i, paramIntent, l), 2, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOOpenWebMonitor
 * JD-Core Version:    0.7.0.1
 */