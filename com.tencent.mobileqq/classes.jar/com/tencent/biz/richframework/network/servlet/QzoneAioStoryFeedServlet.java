package com.tencent.biz.richframework.network.servlet;

import NS_COMM.COMM.StCommonExt;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.network.request.QzoneAioStoryFeedRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QzoneAioStoryFeedServlet
  extends MSFServlet
{
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_FOR_AIO_STORY_FEED_DATA = "KEY_FOR_AIO_STORY_FEED_DATA";
  public static final String KEY_FRIEND_UIN = "key_friend_uid";
  public static final String KEY_LAST_AIO_STORY_CREATE_TIME = "key_last_aio_story_create_time";
  public static final String TAG = "QzoneAioStoryFeedServlet";
  
  public String getTraceId()
  {
    String str = BaseApplicationImpl.sApplication.getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder(50);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MMddHHmmss");
    Random localRandom = new Random();
    localRandom.setSeed(System.currentTimeMillis());
    localStringBuilder.append(str).append("_").append(localSimpleDateFormat.format(new Date())).append(System.currentTimeMillis() % 1000L).append("_").append(localRandom.nextInt(90000) + 10000);
    return localStringBuilder.toString();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    try
    {
      Bundle localBundle = new Bundle();
      if (paramFromServiceMsg != null)
      {
        if (paramFromServiceMsg.isSuccess())
        {
          localBundle.putParcelable("KEY_FOR_AIO_STORY_FEED_DATA", paramFromServiceMsg);
          notifyObserver(paramIntent, 1010, true, localBundle, QZoneObserver.class);
          return;
        }
        if (RFLog.isColorLevel()) {
          RFLog.d("QzoneAioStoryFeedServlet", RFLog.CLR, new Object[] { "inform QzoneAioStoryFeedServlet isSuccess false:", paramFromServiceMsg.getBusinessFailMsg() });
        }
        notifyObserver(paramIntent, 1010, false, localBundle, QZoneObserver.class);
        return;
      }
    }
    catch (Throwable paramIntent)
    {
      RFLog.e("QzoneAioStoryFeedServlet", RFLog.USR, paramIntent + "onReceive error");
      notifyObserver(null, 1010, false, null, QZoneObserver.class);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    long l1 = paramIntent.getLongExtra("key_last_aio_story_create_time", 0L);
    long l2 = paramIntent.getLongExtra("key_friend_uid", -1L);
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    Object localObject = null;
    if (arrayOfByte != null) {
      localObject = new COMM.StCommonExt();
    }
    try
    {
      ((COMM.StCommonExt)localObject).mergeFrom(arrayOfByte);
      arrayOfByte = new QzoneAioStoryFeedRequest((COMM.StCommonExt)localObject, l1, l2).encode(paramIntent, -1, getTraceId());
      localObject = arrayOfByte;
      if (arrayOfByte == null) {
        localObject = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.qq_story_client.GetUserNewestStory");
      paramPacket.putSendData(WupUtil.a((byte[])localObject));
      paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (RFLog.isColorLevel()) {
          RFLog.e("QzoneAioStoryFeedServlet", RFLog.CLR, "onSend. mergeFrom exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.network.servlet.QzoneAioStoryFeedServlet
 * JD-Core Version:    0.7.0.1
 */