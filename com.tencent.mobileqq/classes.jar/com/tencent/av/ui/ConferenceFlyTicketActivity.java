package com.tencent.av.ui;

import aepi;
import alri;
import alrk;
import alud;
import alww;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import ayzl;
import azaf;
import azvd;
import bdin;
import bdjn;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import meo;
import mep;
import meq;
import mer;
import mqq.manager.TicketManager;
import mxf;

public class ConferenceFlyTicketActivity
  extends BaseActivity
{
  int jdField_a_of_type_Int = -1;
  public alri a;
  Handler jdField_a_of_type_AndroidOsHandler = null;
  public final String a;
  meo jdField_a_of_type_Meo;
  public mep a;
  meq jdField_a_of_type_Meq;
  mer jdField_a_of_type_Mer;
  boolean jdField_a_of_type_Boolean = false;
  public String b;
  boolean b;
  public String c = null;
  public String d = null;
  String e = null;
  String f = null;
  String g = null;
  public String h = null;
  String i = null;
  String j = null;
  
  public ConferenceFlyTicketActivity()
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = ("ConferenceFlyTicketActivity." + AudioHelper.b());
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    long l = ayzl.a();
    ArrayList localArrayList = new ArrayList();
    MessageRecord localMessageRecord = azaf.a(-7003);
    if (bdjn.a(this.jdField_a_of_type_Int)) {}
    for (String str = this.app.getApp().getString(2131691942);; str = this.app.getApp().getString(2131691941))
    {
      localMessageRecord.init(paramString2, paramString1, paramString3, str, l, -7003, 3000, l);
      localMessageRecord.isread = true;
      localMessageRecord.saveExtInfoToExtStr("troop_msg_nickname", paramString4);
      boolean bool1 = localMessageRecord instanceof MessageForNewGrayTips;
      if (bool1) {
        ((MessageForNewGrayTips)localMessageRecord).updateMsgData();
      }
      boolean bool2 = alww.a(this.app, localMessageRecord, false);
      if (!bool2) {
        localArrayList.add(localMessageRecord);
      }
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "showHRMeetingTip, friendUin[" + localMessageRecord.frienduin + "], msgType[" + -7003 + "], friendType[" + 3000 + "], bMessageForNewGrayTips[" + bool1 + "], msgFilter[" + bool2 + "], msgContent[" + localMessageRecord.getLogColorContent() + "]");
      if (localArrayList.size() > 0) {
        this.app.a().a(localArrayList, String.valueOf(paramString2));
      }
      return;
    }
  }
  
  @TargetApi(9)
  private boolean a()
  {
    AudioHelper.b("上传SelfNickName");
    Object localObject = (TicketManager)this.app.getManager(2);
    if (localObject == null) {
      return false;
    }
    localObject = ((TicketManager)localObject).getSkey(this.app.getAccount());
    if ((localObject == null) || (((String)localObject).isEmpty())) {
      return false;
    }
    this.jdField_a_of_type_Mer = new mer(this);
    ArrayList localArrayList = new ArrayList();
    mxf localmxf = new mxf();
    String str = this.app.getCurrentAccountUin();
    localmxf.jdField_a_of_type_JavaLangString = ("http://pubacc.mobile.qq.com/mqqweb-rtx2qq/mqqweb/report_nickname_video_meeting_for_hr?discid=" + this.h + "&uin=" + str + "&name=" + URLEncoder.encode(this.j));
    localmxf.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    localmxf.jdField_a_of_type_JavaUtilHashMap.put("Cookie", "uin=o" + str + ";skey=" + (String)localObject);
    localArrayList.add(localmxf);
    this.jdField_a_of_type_Mer.execute(new ArrayList[] { localArrayList });
    return true;
  }
  
  static boolean a(String paramString)
  {
    return (paramString.startsWith("https:")) || (paramString.startsWith("http:"));
  }
  
  void a()
  {
    Intent localIntent = super.getIntent();
    this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("confid");
    this.c = localIntent.getStringExtra("subject");
    this.d = localIntent.getStringExtra("ticket");
    this.e = localIntent.getStringExtra("ticket_f");
    String str = localIntent.getStringExtra("stask");
    if (str != null) {}
    for (this.jdField_a_of_type_Int = Integer.valueOf(str).intValue();; this.jdField_a_of_type_Int = 0)
    {
      this.f = localIntent.getStringExtra("confidshort");
      this.g = localIntent.getStringExtra("callphonenum");
      this.h = localIntent.getStringExtra("discid");
      this.j = localIntent.getStringExtra("user");
      this.i = localIntent.getStringExtra("businesstype");
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "processExtraData, mConfid[" + this.jdField_b_of_type_JavaLangString + "], mSubject[" + this.c + "], mTicket[" + this.d + "], mTicketFull[" + this.e + "], mConfIDShort[" + this.f + "], mCallbackPhone[" + this.g + "], mDiscID[" + this.h + "], mStasks[" + this.jdField_a_of_type_Int + "], mHrMeetingNickName[" + this.j + "], mBusinessType[" + this.i + "]");
      }
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "showFailMessage, type[" + paramInt1 + "], errorCode[" + paramInt2 + "]");
    String str;
    switch (paramInt2)
    {
    default: 
      if (paramInt1 == 1) {
        str = alud.a(2131702771);
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new ConferenceFlyTicketActivity.1(this, str));
      return;
      str = alud.a(2131702760);
      continue;
      str = alud.a(2131702762);
      continue;
      str = alud.a(2131702767);
      continue;
      str = alud.a(2131702770);
      continue;
      str = alud.a(2131702769);
      continue;
      str = alud.a(2131702765);
      continue;
      if (paramInt1 == 0) {
        str = alud.a(2131702764);
      } else {
        str = "";
      }
    }
  }
  
  @TargetApi(9)
  void a(String paramString)
  {
    this.jdField_a_of_type_Meq = new meq(this, paramString);
    paramString = new ArrayList();
    mxf localmxf = new mxf();
    String str1 = this.app.getCurrentAccountUin();
    localmxf.jdField_a_of_type_JavaLangString = ("http://pubacc.mobile.qq.com/mqqweb-rtx2qq/mqqweb/get_namecard_by_discid?discid=" + this.h);
    localmxf.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    String str2 = ((TicketManager)this.app.getManager(2)).getSkey(this.app.getAccount());
    if ((str2 == null) || (str2.isEmpty())) {
      return;
    }
    localmxf.jdField_a_of_type_JavaUtilHashMap.put("Cookie", "uin=o" + str1 + ";skey=" + str2);
    paramString.add(localmxf);
    this.jdField_a_of_type_Meq.execute(new ArrayList[] { paramString });
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    boolean bool = AVNotifyCenter.c();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "startGAudioOnCreateDiscussion, discID[" + paramString1 + "], discussName[" + paramString2 + "], isBeInvitingOnDoubleVideo[" + bool + "]");
    if (bool)
    {
      QQToast.a(getApplicationContext(), 2131696353, 1).b(getApplicationContext().getResources().getDimensionPixelSize(2131298914));
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    paramString2 = new Bundle();
    paramString2.putInt("MultiAVType", 1);
    paramString2.putBoolean("disableInvite", true);
    if ((this.i.equals("video_hr")) || ((this.jdField_a_of_type_Int & 0x4) != 0))
    {
      paramString2.putBoolean("isVideo", true);
      paramString2.putInt("MeetingStasks", this.jdField_a_of_type_Int);
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "ShowNameCard, mBusinessType[" + this.i + "], mStasks[" + this.jdField_a_of_type_Int + "]");
      a(paramString1);
    }
    AudioHelper.b(alud.a(2131702763));
    ChatActivityUtils.a(this.app, this.app.getApp(), 3000, paramString1, true, true, null, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      AbsStructMsg localAbsStructMsg;
      do
      {
        return;
        localAbsStructMsg = azvd.a(paramString1.getBytes(), 0);
      } while (localAbsStructMsg == null);
      paramString1 = (MessageForStructing)azaf.a(-2011);
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
      if (!alww.a(this.app, paramString1, false)) {
        paramString2.add(paramString1);
      }
    } while (paramString2.size() <= 0);
    this.app.a().a(paramString2, String.valueOf(paramString3));
  }
  
  @TargetApi(9)
  public void b()
  {
    AudioHelper.b(alud.a(2131702761));
    if (bdin.d(this))
    {
      if (!TextUtils.isEmpty(this.e))
      {
        if (a(this.e))
        {
          b(this.e);
          return;
        }
        b("https://q.url.cn/s/" + this.e);
        return;
      }
      if (!TextUtils.isEmpty(this.d))
      {
        if (a(this.d))
        {
          b(this.d);
          return;
        }
        b("http://url.cn/" + this.d);
        return;
      }
      finish();
      a(0, -162);
      return;
    }
    finish();
    a(0, -160);
  }
  
  void b(String paramString)
  {
    AudioHelper.b("加入讨论组_delay_获取讨论组签名");
    ThreadManager.post(new ConferenceFlyTicketActivity.2(this, paramString), 5, null, false);
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Boolean) {}
    DiscussionInfo localDiscussionInfo;
    do
    {
      do
      {
        return;
        localObject = (alrk)this.app.getManager(53);
        localDiscussionInfo = ((alrk)localObject).a(this.h);
      } while (localDiscussionInfo == null);
      if (localDiscussionInfo.mSelfRight != this.jdField_a_of_type_Int)
      {
        localDiscussionInfo.mSelfRight = this.jdField_a_of_type_Int;
        ((alrk)localObject).a(localDiscussionInfo);
      }
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "gotoAIO, DiscussionInfo_" + localDiscussionInfo);
    } while (localDiscussionInfo.isHidden());
    Object localObject = aepi.a(new Intent(BaseApplicationImpl.getApplication(), SplashActivity.class), new int[] { 2 });
    ((Intent)localObject).putExtra("uin", this.h);
    ((Intent)localObject).putExtra("uintype", 3000);
    ((Intent)localObject).putExtra("uinname", localDiscussionInfo.discussionName);
    ((Intent)localObject).putExtra("entrance", 8);
    BaseApplicationImpl.getApplication().startActivity((Intent)localObject);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    AudioHelper.b("ConferenceFlyTicketActivity.doOnCreate.begin");
    boolean bool = super.doOnCreate(paramBundle);
    a();
    this.jdField_a_of_type_Alri = ((alri)this.app.a(6));
    this.jdField_a_of_type_Meo = new meo(this);
    addObserver(this.jdField_a_of_type_Meo);
    if (this.i.equals("video_hr"))
    {
      if (!a()) {
        return false;
      }
    }
    else {
      b();
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    AudioHelper.b("ConferenceFlyTicketActivity.doOnCreate.end");
    return bool;
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_Meo);
    this.jdField_a_of_type_AndroidOsHandler = null;
    super.doOnDestroy();
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.ConferenceFlyTicketActivity
 * JD-Core Version:    0.7.0.1
 */