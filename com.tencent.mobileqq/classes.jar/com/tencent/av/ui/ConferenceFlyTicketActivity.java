package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.download.DownloadParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.manager.TicketManager;

public class ConferenceFlyTicketActivity
  extends BaseActivity
{
  final String a;
  String b = null;
  String c = null;
  String d = null;
  String e = null;
  String f = null;
  String g = null;
  String h = null;
  int i = -1;
  String j = null;
  String k = null;
  boolean l = false;
  ConferenceFlyTicketActivity.MyDiscussionObserver m;
  DiscussionHandler n;
  ConferenceFlyTicketActivity.OnAfterCreateDiscussionAsyncTask o;
  ConferenceFlyTicketActivity.OnReportHrSelfNickNameTask p;
  ConferenceFlyTicketActivity.OnGetDiscNameCardTask q;
  Handler r = null;
  boolean s = false;
  
  public ConferenceFlyTicketActivity()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ConferenceFlyTicketActivity.");
    localStringBuilder.append(AudioHelper.c());
    this.a = localStringBuilder.toString();
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    long l1 = MessageCache.c();
    ArrayList localArrayList = new ArrayList();
    MessageRecord localMessageRecord = MessageRecordFactory.a(-7003);
    String str;
    if (QAVHrMeeting.a(this.i)) {
      str = this.app.getApp().getString(2131888759);
    } else {
      str = this.app.getApp().getString(2131888758);
    }
    localMessageRecord.init(paramString2, paramString1, paramString3, str, l1, -7003, 3000, l1);
    localMessageRecord.isread = true;
    localMessageRecord.saveExtInfoToExtStr("troop_msg_nickname", paramString4);
    boolean bool1 = localMessageRecord instanceof MessageForNewGrayTips;
    if (bool1) {
      ((MessageForNewGrayTips)localMessageRecord).updateMsgData();
    }
    boolean bool2 = MessageHandlerUtils.a(this.app, localMessageRecord, false);
    if (!bool2) {
      localArrayList.add(localMessageRecord);
    }
    paramString1 = this.a;
    paramString3 = new StringBuilder();
    paramString3.append("showHRMeetingTip, friendUin[");
    paramString3.append(localMessageRecord.frienduin);
    paramString3.append("], msgType[");
    paramString3.append(-7003);
    paramString3.append("], friendType[");
    paramString3.append(3000);
    paramString3.append("], bMessageForNewGrayTips[");
    paramString3.append(bool1);
    paramString3.append("], msgFilter[");
    paramString3.append(bool2);
    paramString3.append("], msgContent[");
    paramString3.append(localMessageRecord.getLogColorContent());
    paramString3.append("]");
    QLog.w(paramString1, 1, paramString3.toString());
    if (localArrayList.size() > 0) {
      this.app.getMessageFacade().a(localArrayList, String.valueOf(paramString2));
    }
  }
  
  static boolean a(String paramString)
  {
    return (paramString.startsWith("https:")) || (paramString.startsWith("http:"));
  }
  
  @TargetApi(9)
  private boolean d()
  {
    AudioHelper.b("上传SelfNickName");
    Object localObject1 = (TicketManager)this.app.getManager(2);
    if (localObject1 == null) {
      return false;
    }
    localObject1 = ((TicketManager)localObject1).getSkey(this.app.getAccount());
    if (localObject1 != null)
    {
      if (((String)localObject1).isEmpty()) {
        return false;
      }
      this.p = new ConferenceFlyTicketActivity.OnReportHrSelfNickNameTask(this);
      ArrayList localArrayList = new ArrayList();
      DownloadParams localDownloadParams = new DownloadParams();
      String str = this.app.getCurrentAccountUin();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("https://pubacc.mobile.qq.com/mqqweb-rtx2qq/mqqweb/report_nickname_video_meeting_for_hr?discid=");
      ((StringBuilder)localObject2).append(this.h);
      ((StringBuilder)localObject2).append("&uin=");
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("&name=");
      ((StringBuilder)localObject2).append(URLEncoder.encode(this.k));
      localDownloadParams.a = ((StringBuilder)localObject2).toString();
      localDownloadParams.b = new HashMap();
      localObject2 = localDownloadParams.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin=o");
      localStringBuilder.append(str);
      localStringBuilder.append(";skey=");
      localStringBuilder.append((String)localObject1);
      ((HashMap)localObject2).put("Cookie", localStringBuilder.toString());
      localArrayList.add(localDownloadParams);
      this.p.execute(new ArrayList[] { localArrayList });
      return true;
    }
    return false;
  }
  
  void a()
  {
    Object localObject1 = super.getIntent();
    this.b = ((Intent)localObject1).getStringExtra("confid");
    this.c = ((Intent)localObject1).getStringExtra("subject");
    this.d = ((Intent)localObject1).getStringExtra("ticket");
    this.e = ((Intent)localObject1).getStringExtra("ticket_f");
    Object localObject2 = ((Intent)localObject1).getStringExtra("stask");
    if (localObject2 != null) {
      this.i = Integer.valueOf((String)localObject2).intValue();
    } else {
      this.i = 0;
    }
    this.f = ((Intent)localObject1).getStringExtra("confidshort");
    this.g = ((Intent)localObject1).getStringExtra("callphonenum");
    this.h = ((Intent)localObject1).getStringExtra("discid");
    this.k = ((Intent)localObject1).getStringExtra("user");
    this.j = ((Intent)localObject1).getStringExtra("businesstype");
    if (QLog.isColorLevel())
    {
      localObject1 = this.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("processExtraData, mConfid[");
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append("], mSubject[");
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append("], mTicket[");
      ((StringBuilder)localObject2).append(this.d);
      ((StringBuilder)localObject2).append("], mTicketFull[");
      ((StringBuilder)localObject2).append(this.e);
      ((StringBuilder)localObject2).append("], mConfIDShort[");
      ((StringBuilder)localObject2).append(this.f);
      ((StringBuilder)localObject2).append("], mCallbackPhone[");
      ((StringBuilder)localObject2).append(this.g);
      ((StringBuilder)localObject2).append("], mDiscID[");
      ((StringBuilder)localObject2).append(this.h);
      ((StringBuilder)localObject2).append("], mStasks[");
      ((StringBuilder)localObject2).append(this.i);
      ((StringBuilder)localObject2).append("], mHrMeetingNickName[");
      ((StringBuilder)localObject2).append(this.k);
      ((StringBuilder)localObject2).append("], mBusinessType[");
      ((StringBuilder)localObject2).append(this.j);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showFailMessage, type[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("], errorCode[");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (paramInt2 != -162)
    {
      if (paramInt2 != -160)
      {
        if (paramInt2 != 1)
        {
          if (paramInt2 != 4)
          {
            if (paramInt2 != 7)
            {
              if (paramInt2 != 8)
              {
                if (paramInt1 == 1) {
                  str = HardCodeUtil.a(2131900564);
                } else if (paramInt1 == 0) {
                  str = HardCodeUtil.a(2131900557);
                } else {
                  str = "";
                }
              }
              else {
                str = HardCodeUtil.a(2131900563);
              }
            }
            else {
              str = HardCodeUtil.a(2131900560);
            }
          }
          else {
            str = HardCodeUtil.a(2131900555);
          }
        }
        else {
          str = HardCodeUtil.a(2131900553);
        }
      }
      else {
        str = HardCodeUtil.a(2131900562);
      }
    }
    else {
      str = HardCodeUtil.a(2131900558);
    }
    this.r.post(new ConferenceFlyTicketActivity.1(this, str));
  }
  
  void a(String paramString1, String paramString2)
  {
    if (this.l) {
      return;
    }
    boolean bool = AVNotifyCenter.f();
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startGAudioOnCreateDiscussion, discID[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("], discussName[");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("], isBeInvitingOnDoubleVideo[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (bool)
    {
      QQToast.makeText(getApplicationContext(), 2131893650, 1).show(getApplicationContext().getResources().getDimensionPixelSize(2131299920));
      return;
    }
    this.l = true;
    paramString2 = new Bundle();
    paramString2.putInt("MultiAVType", 1);
    paramString2.putBoolean("disableInvite", true);
    if ((this.j.equals("video_hr")) || ((this.i & 0x4) != 0))
    {
      paramString2.putBoolean("isVideo", true);
      paramString2.putInt("MeetingStasks", this.i);
      str = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ShowNameCard, mBusinessType[");
      localStringBuilder.append(this.j);
      localStringBuilder.append("], mStasks[");
      localStringBuilder.append(this.i);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      b(paramString1);
    }
    AudioHelper.b(HardCodeUtil.a(2131900556));
    ChatActivityUtils.a(this.app, this.app.getApp(), 3000, paramString1, true, true, null, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    AbsStructMsg localAbsStructMsg = StructMsgFactory.a(paramString1.getBytes(), 0);
    if (localAbsStructMsg == null) {
      return;
    }
    paramString1 = (MessageForStructing)MessageRecordFactory.a(-2011);
    paramString1.msgtype = -2011;
    paramString1.istroop = 3000;
    paramString1.issend = 0;
    paramString1.isread = true;
    paramString1.selfuin = this.app.getCurrentAccountUin();
    paramString1.senderuin = paramString4;
    paramString1.frienduin = paramString2;
    paramString1.mIsParsed = true;
    paramString1.structingMsg = localAbsStructMsg;
    paramString1.msgData = localAbsStructMsg.getBytes();
    paramString1.saveExtInfoToExtStr("troop_msg_nickname", paramString5);
    paramString2 = new ArrayList();
    if (!MessageHandlerUtils.a(this.app, paramString1, false)) {
      paramString2.add(paramString1);
    }
    if (paramString2.size() > 0) {
      this.app.getMessageFacade().a(paramString2, String.valueOf(paramString3));
    }
  }
  
  @TargetApi(9)
  void b()
  {
    AudioHelper.b(HardCodeUtil.a(2131900554));
    if (NetworkUtil.isNetSupport(this))
    {
      StringBuilder localStringBuilder;
      if (!TextUtils.isEmpty(this.e))
      {
        if (a(this.e))
        {
          c(this.e);
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("https://q.url.cn/s/");
        localStringBuilder.append(this.e);
        c(localStringBuilder.toString());
        return;
      }
      if (!TextUtils.isEmpty(this.d))
      {
        if (a(this.d))
        {
          c(this.d);
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("https://url.cn/");
        localStringBuilder.append(this.d);
        c(localStringBuilder.toString());
        return;
      }
      finish();
      a(0, -162);
      return;
    }
    finish();
    a(0, -160);
  }
  
  @TargetApi(9)
  void b(String paramString)
  {
    this.q = new ConferenceFlyTicketActivity.OnGetDiscNameCardTask(this, paramString);
    paramString = new ArrayList();
    DownloadParams localDownloadParams = new DownloadParams();
    String str = this.app.getCurrentAccountUin();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("https://pubacc.mobile.qq.com/mqqweb-rtx2qq/mqqweb/get_namecard_by_discid?discid=");
    ((StringBuilder)localObject).append(this.h);
    localDownloadParams.a = ((StringBuilder)localObject).toString();
    localDownloadParams.b = new HashMap();
    localObject = ((TicketManager)this.app.getManager(2)).getSkey(this.app.getAccount());
    if (localObject != null)
    {
      if (((String)localObject).isEmpty()) {
        return;
      }
      HashMap localHashMap = localDownloadParams.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin=o");
      localStringBuilder.append(str);
      localStringBuilder.append(";skey=");
      localStringBuilder.append((String)localObject);
      localHashMap.put("Cookie", localStringBuilder.toString());
      paramString.add(localDownloadParams);
      this.q.execute(new ArrayList[] { paramString });
    }
  }
  
  void c()
  {
    if (this.s) {
      return;
    }
    Object localObject = (DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    DiscussionInfo localDiscussionInfo = ((DiscussionManager)localObject).d(this.h);
    if (localDiscussionInfo != null)
    {
      int i1 = localDiscussionInfo.mSelfRight;
      int i2 = this.i;
      if (i1 != i2)
      {
        localDiscussionInfo.mSelfRight = i2;
        ((DiscussionManager)localObject).a(localDiscussionInfo);
      }
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gotoAIO, DiscussionInfo_");
      localStringBuilder.append(localDiscussionInfo);
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      if (!localDiscussionInfo.isHidden())
      {
        localObject = AIOUtils.a(new Intent(BaseApplicationImpl.getApplication(), SplashActivity.class), new int[] { 2 });
        ((Intent)localObject).putExtra("uin", this.h);
        ((Intent)localObject).putExtra("uintype", 3000);
        ((Intent)localObject).putExtra("uinname", localDiscussionInfo.discussionName);
        ((Intent)localObject).putExtra("entrance", 8);
        BaseApplicationImpl.getApplication().startActivity((Intent)localObject);
        this.s = true;
      }
    }
  }
  
  void c(String paramString)
  {
    AudioHelper.b("加入讨论组_delay_获取讨论组签名");
    ThreadManager.post(new ConferenceFlyTicketActivity.2(this, paramString), 5, null, false);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    AudioHelper.b("ConferenceFlyTicketActivity.doOnCreate.begin");
    boolean bool = super.doOnCreate(paramBundle);
    a();
    this.n = ((DiscussionHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER));
    this.m = new ConferenceFlyTicketActivity.MyDiscussionObserver(this);
    addObserver(this.m);
    if (this.j.equals("video_hr"))
    {
      if (!d()) {
        return false;
      }
    }
    else {
      b();
    }
    this.r = new Handler();
    AudioHelper.b("ConferenceFlyTicketActivity.doOnCreate.end");
    return bool;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.m);
    this.r = null;
    super.doOnDestroy();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ConferenceFlyTicketActivity
 * JD-Core Version:    0.7.0.1
 */