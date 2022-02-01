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
  static final String jdField_a_of_type_JavaLangString = StoryApi.a("StoryGroupSvc.do_group_video_forward");
  protected int a;
  Handler jdField_a_of_type_AndroidOsHandler;
  ProtoUtils.StoryProtocolObserver jdField_a_of_type_ComTencentBizProtoUtils$StoryProtocolObserver = new TroopStoryForwardTask.2(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new TroopStoryForwardTask.3(this);
  protected QQAppInterface a;
  protected MessageForTroopStory a;
  protected boolean a;
  protected int b;
  protected String b;
  protected int c;
  protected String c;
  protected int d;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  protected String h;
  protected String i;
  protected String j;
  protected String k;
  protected String l;
  
  private TroopStoryForwardTask(QQAppInterface paramQQAppInterface, Bundle paramBundle, SessionInfo paramSessionInfo)
  {
    if (!a(paramBundle, paramSessionInfo)) {
      throw new IllegalArgumentException("params in bundle is Illegal");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private TroopStoryForwardTask(QQAppInterface paramQQAppInterface, MessageForTroopStory paramMessageForTroopStory)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopStory = paramMessageForTroopStory;
    this.jdField_b_of_type_JavaLangString = String.valueOf(paramMessageForTroopStory.uid);
    this.jdField_c_of_type_JavaLangString = paramMessageForTroopStory.unionId;
    this.jdField_d_of_type_JavaLangString = paramMessageForTroopStory.md5;
    this.e = paramMessageForTroopStory.thumbUrl;
    this.f = paramMessageForTroopStory.doodleUrl;
    this.jdField_a_of_type_Int = paramMessageForTroopStory.videoWidth;
    this.jdField_b_of_type_Int = paramMessageForTroopStory.videoHeight;
    this.g = paramMessageForTroopStory.sourceName;
    this.h = paramMessageForTroopStory.sourceActionType;
    this.i = paramMessageForTroopStory.sourceActionData;
    this.j = paramMessageForTroopStory.compatibleText;
    this.jdField_c_of_type_Int = paramMessageForTroopStory.ctrVersion;
    this.k = paramMessageForTroopStory.frienduin;
    this.l = paramMessageForTroopStory.senderuin;
    this.jdField_d_of_type_Int = paramMessageForTroopStory.istroop;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Boolean = true;
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
    this.jdField_b_of_type_JavaLangString = String.valueOf(paramBundle.getLong("key_uid"));
    this.jdField_c_of_type_JavaLangString = paramBundle.getString("key_union_id");
    this.jdField_d_of_type_JavaLangString = paramBundle.getString("key_md5");
    this.e = paramBundle.getString("key_thumb_url");
    this.f = paramBundle.getString("key_doodle_url");
    this.jdField_a_of_type_Int = paramBundle.getInt("key_video_width");
    this.jdField_b_of_type_Int = paramBundle.getInt("key_video_height");
    this.g = paramBundle.getString("key_source_name");
    this.h = paramBundle.getString("key_source_action_type");
    this.i = paramBundle.getString("key_source_action_data");
    this.j = paramBundle.getString("key_compatible_text");
    this.jdField_c_of_type_Int = paramBundle.getInt("key_ctr_version");
    this.k = paramSessionInfo.jdField_a_of_type_JavaLangString;
    this.l = paramSessionInfo.jdField_b_of_type_JavaLangString;
    this.jdField_d_of_type_Int = paramSessionInfo.jdField_a_of_type_Int;
    return true;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      ThreadManager.executeOnSubThread(new TroopStoryForwardTask.1(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopStory, 0);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopStory);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public void b()
  {
    qqstory_group.ReqGroupVideoForward localReqGroupVideoForward = new qqstory_group.ReqGroupVideoForward();
    int m;
    switch (this.jdField_d_of_type_Int)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.troopstory.share", 2, "unsupport type:" + this.jdField_d_of_type_Int);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
      return;
    case 1: 
      m = 1;
    }
    for (;;)
    {
      localReqGroupVideoForward.type.set(m);
      try
      {
        long l1 = Long.parseLong(this.k);
        localReqGroupVideoForward.forward_to.set(l1);
        localReqGroupVideoForward.vid.set(ByteStringMicro.copyFromUtf8(this.jdField_d_of_type_JavaLangString));
        localReqGroupVideoForward.time.set((int)this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopStory.time);
        ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizProtoUtils$StoryProtocolObserver, localReqGroupVideoForward.toByteArray(), jdField_a_of_type_JavaLangString);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.qqstory.troopstory.share", 2, "uin parse error:" + this.k);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
      }
      m = 2;
      continue;
      m = 3;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopStory, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopStory.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopStory.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopStory.uniseq);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopStory.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopStory.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopStory.uniseq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopStory);
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.troopstory.share", 2, "forward step=" + paramMessage.what + ", task=" + this);
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      a();
      continue;
      b();
      continue;
      c();
      continue;
      d();
      continue;
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.forward.TroopStoryForwardTask
 * JD-Core Version:    0.7.0.1
 */