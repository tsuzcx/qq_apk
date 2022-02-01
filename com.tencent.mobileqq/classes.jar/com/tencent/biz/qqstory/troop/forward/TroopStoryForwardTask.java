package com.tencent.biz.qqstory.troop.forward;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.StoryProtocolObserver;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.network.pb.qqstory_group.ReqGroupVideoForward;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

public class TroopStoryForwardTask
  implements Handler.Callback, TroopStoryForwardStep
{
  static final String a = StoryApi.a("StoryGroupSvc.do_group_video_forward");
  Handler b;
  protected QQAppInterface c;
  protected MessageForTroopStory d;
  protected String e;
  protected String f;
  protected String g;
  protected String h;
  protected String i;
  protected int j;
  protected int k;
  protected String l;
  protected String m;
  protected String n;
  protected String o;
  protected int p;
  protected String q;
  protected int r;
  protected String s;
  protected boolean t;
  ProtoUtils.StoryProtocolObserver u = new TroopStoryForwardTask.2(this);
  MessageObserver v = new TroopStoryForwardTask.3(this);
  
  private TroopStoryForwardTask(QQAppInterface paramQQAppInterface, Bundle paramBundle, SessionInfo paramSessionInfo)
  {
    if (a(paramBundle, paramSessionInfo))
    {
      this.c = paramQQAppInterface;
      this.b = new Handler(Looper.getMainLooper(), this);
      this.t = false;
      return;
    }
    throw new IllegalArgumentException("params in bundle is Illegal");
  }
  
  private TroopStoryForwardTask(QQAppInterface paramQQAppInterface, MessageForTroopStory paramMessageForTroopStory)
  {
    this.d = paramMessageForTroopStory;
    this.e = String.valueOf(paramMessageForTroopStory.uid);
    this.f = paramMessageForTroopStory.unionId;
    this.g = paramMessageForTroopStory.md5;
    this.h = paramMessageForTroopStory.thumbUrl;
    this.i = paramMessageForTroopStory.doodleUrl;
    this.j = paramMessageForTroopStory.videoWidth;
    this.k = paramMessageForTroopStory.videoHeight;
    this.l = paramMessageForTroopStory.sourceName;
    this.m = paramMessageForTroopStory.sourceActionType;
    this.n = paramMessageForTroopStory.sourceActionData;
    this.o = paramMessageForTroopStory.compatibleText;
    this.p = paramMessageForTroopStory.ctrVersion;
    this.q = paramMessageForTroopStory.frienduin;
    this.s = paramMessageForTroopStory.senderuin;
    this.r = paramMessageForTroopStory.istroop;
    this.c = paramQQAppInterface;
    this.b = new Handler(Looper.getMainLooper(), this);
    this.t = true;
  }
  
  public static TroopStoryForwardTask a(QQAppInterface paramQQAppInterface, Bundle paramBundle, SessionInfo paramSessionInfo)
  {
    try
    {
      paramQQAppInterface = new TroopStoryForwardTask(paramQQAppInterface, paramBundle, paramSessionInfo);
      return paramQQAppInterface;
    }
    catch (IllegalArgumentException paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.troopstory.share", 2, "forward error", paramQQAppInterface);
      }
    }
    return null;
  }
  
  public static TroopStoryForwardTask a(QQAppInterface paramQQAppInterface, MessageForTroopStory paramMessageForTroopStory)
  {
    return new TroopStoryForwardTask(paramQQAppInterface, paramMessageForTroopStory);
  }
  
  private boolean a(Bundle paramBundle, SessionInfo paramSessionInfo)
  {
    this.e = String.valueOf(paramBundle.getLong("key_uid"));
    this.f = paramBundle.getString("key_union_id");
    this.g = paramBundle.getString("key_md5");
    this.h = paramBundle.getString("key_thumb_url");
    this.i = paramBundle.getString("key_doodle_url");
    this.j = paramBundle.getInt("key_video_width");
    this.k = paramBundle.getInt("key_video_height");
    this.l = paramBundle.getString("key_source_name");
    this.m = paramBundle.getString("key_source_action_type");
    this.n = paramBundle.getString("key_source_action_data");
    this.o = paramBundle.getString("key_compatible_text");
    this.p = paramBundle.getInt("key_ctr_version");
    this.q = paramSessionInfo.b;
    this.s = paramSessionInfo.c;
    this.r = paramSessionInfo.a;
    return true;
  }
  
  public void a()
  {
    if (!this.t)
    {
      ThreadManager.executeOnSubThread(new TroopStoryForwardTask.1(this));
      return;
    }
    this.c.getMsgCache().a(this.d, 0);
    this.c.getMessageFacade().a(this.d);
    this.b.sendEmptyMessage(2);
  }
  
  public void b()
  {
    Object localObject = new qqstory_group.ReqGroupVideoForward();
    int i2 = this.r;
    int i1 = 1;
    if (i2 != 0)
    {
      if (i2 != 1)
      {
        if (i2 != 3000)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("unsupport type:");
            ((StringBuilder)localObject).append(this.r);
            QLog.e("Q.qqstory.troopstory.share", 2, ((StringBuilder)localObject).toString());
          }
          this.b.sendEmptyMessage(5);
          return;
        }
        i1 = 3;
      }
    }
    else {
      i1 = 2;
    }
    ((qqstory_group.ReqGroupVideoForward)localObject).type.set(i1);
    try
    {
      long l1 = Long.parseLong(this.q);
      ((qqstory_group.ReqGroupVideoForward)localObject).forward_to.set(l1);
      ((qqstory_group.ReqGroupVideoForward)localObject).vid.set(ByteStringMicro.copyFromUtf8(this.g));
      ((qqstory_group.ReqGroupVideoForward)localObject).time.set((int)this.d.time);
      ProtoUtils.a(this.c, this.u, ((qqstory_group.ReqGroupVideoForward)localObject).toByteArray(), a);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label171:
      break label171;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uin parse error:");
      ((StringBuilder)localObject).append(this.q);
      QLog.e("Q.qqstory.troopstory.share", 2, ((StringBuilder)localObject).toString());
    }
    this.b.sendEmptyMessage(5);
  }
  
  public void c()
  {
    this.c.getMessageFacade().b(this.d, this.v);
  }
  
  public void d()
  {
    this.c.getMsgCache().b(this.d.frienduin, this.d.istroop, this.d.uniseq);
  }
  
  public void e()
  {
    this.c.getMsgCache().b(this.d.frienduin, this.d.istroop, this.d.uniseq);
    this.c.getMessageFacade().a(this.d);
  }
  
  public void f()
  {
    this.b.sendEmptyMessage(1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("forward step=");
      localStringBuilder.append(paramMessage.what);
      localStringBuilder.append(", task=");
      localStringBuilder.append(this);
      QLog.i("Q.qqstory.troopstory.share", 2, localStringBuilder.toString());
    }
    int i1 = paramMessage.what;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4)
          {
            if (i1 != 5) {
              return true;
            }
            e();
            return true;
          }
          d();
          return true;
        }
        c();
        return true;
      }
      b();
      return true;
    }
    a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.forward.TroopStoryForwardTask
 * JD-Core Version:    0.7.0.1
 */