package com.tencent.biz.qqstory.msgTabNode.model;

import android.text.TextUtils;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabCheckActiveRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DPCObserver;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.StringToIntParser;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import nik;
import nil;
import nim;

public class MsgTabStoryNodeConfigManager
  implements Manager
{
  public byte a;
  public int a;
  private final QQStoryObserver jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new nil(this);
  DeviceProfileManager.DPCObserver jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$DPCObserver = new nim(this);
  public QQAppInterface a;
  public boolean a;
  public boolean b;
  public boolean c = true;
  public boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public MsgTabStoryNodeConfigManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Byte = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.b = ((Boolean)((StoryConfigManager)SuperManager.a(10)).b("key_story_msg_tab_show", Boolean.valueOf(false))).booleanValue();
    this.c = a();
    DeviceProfileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$DPCObserver);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    this.d = ((QQStoryManager)paramQQAppInterface.getManager(180)).g();
    b(false);
  }
  
  private void a()
  {
    if ((this.b) && (this.c) && (this.jdField_a_of_type_Byte == 0) && (!this.h))
    {
      SLog.b("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request!");
      this.h = true;
      localObject = SosoInterface.b();
      if ((localObject == null) || (((SosoInterface.SosoLbsInfo)localObject).a == null)) {
        break label148;
      }
    }
    long l1;
    long l2;
    label148:
    for (Object localObject = new MsgTabCheckActiveRequest(((SosoInterface.SosoLbsInfo)localObject).a.f);; localObject = new MsgTabCheckActiveRequest(null))
    {
      QQStoryManager localQQStoryManager = (QQStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(180);
      nik localnik = new nik(this, (QQStoryHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98), localQQStoryManager);
      l1 = localQQStoryManager.a();
      l2 = NetConnInfoCenter.getServerTime();
      if (l2 <= l1) {
        break;
      }
      CmdTaskManger.a().a((NetworkRequest)localObject, localnik);
      SLog.b("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request sent");
      return;
    }
    SLog.a("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request not send, check next time! %d, %d", Long.valueOf(l2), Long.valueOf(l1));
  }
  
  private void b()
  {
    if ((this.e) && (this.g) && (this.f)) {
      a();
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "update cfg svr=" + this.b + ", dpc=" + this.c + ", user=" + this.d);
    }
    boolean bool2 = this.jdField_a_of_type_Boolean;
    boolean bool1;
    if ((this.b) && (this.c) && (this.d))
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (!this.jdField_a_of_type_Boolean) {
        break label117;
      }
      this.jdField_a_of_type_Int = 28;
      label104:
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        break label126;
      }
    }
    label117:
    label126:
    while ((!paramBoolean) || (bool2 == this.jdField_a_of_type_Boolean))
    {
      return;
      bool1 = false;
      break;
      this.jdField_a_of_type_Int = 49;
      break label104;
    }
    ((TroopRedTouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(43)).a(105, true, null);
    ((QQStoryHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98)).a(1020, true, Boolean.valueOf(this.jdField_a_of_type_Boolean));
  }
  
  private void c()
  {
    QQStoryHandler localQQStoryHandler = (QQStoryHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98);
    if ((this.b) && (this.c)) {}
    for (boolean bool = true;; bool = false)
    {
      localQQStoryHandler.a(1022, true, Boolean.valueOf(bool));
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    QQStoryManager localQQStoryManager = (QQStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(180);
    this.d = paramBoolean;
    localQQStoryManager.i(paramBoolean);
    b(true);
  }
  
  public boolean a()
  {
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.StoryCfg.name(), "1");
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "getMsgTabDPC:" + str);
    }
    Integer[] arrayOfInteger;
    if (!TextUtils.isEmpty(str))
    {
      arrayOfInteger = new Integer[1];
      arrayOfInteger[0] = Integer.valueOf(0);
    }
    return (DeviceProfileManager.a(str, arrayOfInteger, new DeviceProfileManager.StringToIntParser()) < 0) || (arrayOfInteger[0].intValue() == 1);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    DeviceProfileManager.b(this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$DPCObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager
 * JD-Core Version:    0.7.0.1
 */