package com.tencent.mobileqq.activity.qwallet;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletRedPkgUtils;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletHandler;
import com.tencent.mobileqq.app.QWalletObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MsgPool;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.QQWalletAioBody;
import tencent.im.msg.im_msg_body.QQWalletAioElem;
import tencent.im.oidb.cmd0x438.oidb_0x438.RedBagInfo;
import tencent.im.oidb.cmd0x438.oidb_0x438.ReqInfo;
import wzq;
import wzs;
import wzt;
import wzu;
import wzv;
import wzx;
import wzy;
import wzz;
import xaa;

public class PasswdRedBagManager
  implements Manager
{
  public int a;
  public Context a;
  Handler jdField_a_of_type_AndroidOsHandler = new wzq(this, Looper.getMainLooper());
  private PasswdRedBagDBManager jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QWalletHandler jdField_a_of_type_ComTencentMobileqqAppQWalletHandler;
  private QWalletObserver jdField_a_of_type_ComTencentMobileqqAppQWalletObserver = new QWalletObserver(this.jdField_a_of_type_AndroidOsHandler);
  public String a;
  public HashMap a;
  public List a;
  public boolean a;
  public HashMap b;
  public List b;
  public boolean b;
  public HashMap c;
  private List c;
  public boolean c;
  public HashMap d;
  public boolean d;
  public HashMap e;
  private boolean e;
  public HashMap f;
  private boolean f;
  public HashMap g;
  private boolean g;
  private HashMap jdField_h_of_type_JavaUtilHashMap;
  private boolean jdField_h_of_type_Boolean;
  private HashMap i;
  
  public PasswdRedBagManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 10;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_f_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_g_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBManager = new PasswdRedBagDBManager(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppQWalletObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQWalletHandler = ((QWalletHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(76));
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap = new QQHashMap(1008, 0, 100);
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = true;
    c();
  }
  
  private void a(PasswdRedBagInfo paramPasswdRedBagInfo)
  {
    String str = paramPasswdRedBagInfo.jdField_a_of_type_JavaLangString;
    Object localObject2 = paramPasswdRedBagInfo.d;
    this.jdField_a_of_type_JavaUtilHashMap.put(str, paramPasswdRedBagInfo);
    Object localObject1;
    if (paramPasswdRedBagInfo.jdField_a_of_type_Int == 0)
    {
      localObject1 = (List)this.jdField_b_of_type_JavaUtilHashMap.get(localObject2);
      if (localObject1 != null) {
        break label146;
      }
      localObject1 = new LinkedList();
      this.jdField_b_of_type_JavaUtilHashMap.put(localObject2, localObject1);
    }
    label146:
    for (;;)
    {
      int k = ((List)localObject1).size();
      int j = 0;
      if (j < k)
      {
        localObject2 = (PasswdRedBagInfo)this.jdField_a_of_type_JavaUtilHashMap.get(((List)localObject1).get(j));
        if ((localObject2 == null) || (((PasswdRedBagInfo)localObject2).jdField_a_of_type_Long >= paramPasswdRedBagInfo.jdField_a_of_type_Long)) {}
      }
      for (;;)
      {
        ((List)localObject1).add(j, str);
        return;
        j += 1;
        break;
        j = 0;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    PasswdRedBagManager localPasswdRedBagManager = (PasswdRedBagManager)paramQQAppInterface.getManager(124);
    if (!localPasswdRedBagManager.jdField_a_of_type_Boolean)
    {
      String str = paramQQAppInterface.getAccount();
      paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
      if (paramQQAppInterface.contains(str + "_" + "redbag_fold_msg_config_version"))
      {
        localPasswdRedBagManager.jdField_b_of_type_Boolean = paramQQAppInterface.getBoolean(str + "_" + "redbag_fold_msg_switch", MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT);
        localPasswdRedBagManager.jdField_a_of_type_Int = paramQQAppInterface.getInt(str + "_" + "redbag_fold_msg_num", MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT);
        localPasswdRedBagManager.jdField_c_of_type_Boolean = paramQQAppInterface.getBoolean(str + "_" + "redbag_fold_index_switch", MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_INDEX);
        localPasswdRedBagManager.jdField_d_of_type_Boolean = paramQQAppInterface.getBoolean(str + "_" + "redbag_fold_index_with_redbagid", MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID);
      }
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, String.format("getFoldSwitch, first init, switch: %s, num: %d, indexSwitch: %s, indexWithId: %s ", new Object[] { Boolean.valueOf(localPasswdRedBagManager.jdField_b_of_type_Boolean), Integer.valueOf(localPasswdRedBagManager.jdField_a_of_type_Int), Boolean.valueOf(localPasswdRedBagManager.jdField_c_of_type_Boolean), Boolean.valueOf(localPasswdRedBagManager.jdField_d_of_type_Boolean) }));
      }
    }
    localPasswdRedBagManager.jdField_a_of_type_Boolean = true;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    bool6 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
    i1 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
    bool5 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_INDEX;
    bool4 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID;
    int i8 = 0;
    n = 0;
    int i9 = 0;
    i7 = 0;
    int i10 = 0;
    m = 0;
    i6 = 0;
    int i11 = 0;
    j = 0;
    i2 = i10;
    i3 = i11;
    i4 = i9;
    i5 = i8;
    bool1 = bool4;
    bool2 = bool5;
    k = i1;
    bool3 = bool6;
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = paramString.split("\\|");
          i2 = i10;
          i3 = i11;
          i4 = i9;
          i5 = i8;
          bool1 = bool4;
          bool2 = bool5;
          k = i1;
          bool3 = bool6;
          if (paramString != null)
          {
            i9 = paramString.length;
            i7 = 0;
            i2 = 0;
            m = 0;
            bool1 = bool4;
            n = 0;
            bool3 = bool6;
            k = i1;
            bool2 = bool5;
            i1 = i2;
            if (i7 >= i9) {
              continue;
            }
            arrayOfString1 = paramString[i7];
          }
        }
      }
      catch (Exception paramString)
      {
        String[] arrayOfString1;
        String[] arrayOfString2;
        label246:
        j = i7;
        i2 = m;
        i3 = i6;
        i4 = j;
        i5 = n;
        bool1 = bool4;
        bool2 = bool5;
        k = i1;
        bool3 = bool6;
        if (QLog.isColorLevel())
        {
          QLog.e("msgFold", 2, "updatePasswdMsgFodConfig error " + paramString.getMessage());
          bool3 = bool6;
          k = i1;
          bool2 = bool5;
          bool1 = bool4;
          i5 = n;
          i4 = j;
          i3 = i6;
          i2 = m;
        }
        if (QLog.isColorLevel()) {
          QLog.d("msgFold", 2, String.format("received RedBagFoldMsgConfig remote version: %d, msgFoldSwitch: %s, msgFoldNum: %s, msgFoldIndexSwitch: %s, msgFoldIndexWithId: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool3), Integer.valueOf(k), Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
        }
        if ((i4 == 0) || (i5 == 0) || (i2 == 0) || (i3 == 0))
        {
          bool1 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
          j = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
          bool2 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_INDEX;
          bool3 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID;
          paramString = (PasswdRedBagManager)paramQQAppInterface.getManager(124);
          paramString.jdField_a_of_type_Boolean = true;
          paramString.jdField_b_of_type_Boolean = bool1;
          paramString.jdField_a_of_type_Int = j;
          paramString.jdField_c_of_type_Boolean = bool2;
          paramString.jdField_d_of_type_Boolean = bool3;
          SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), paramInt, bool1, j, bool2, bool3);
          return;
        }
        i2 = m;
        i3 = j;
        i4 = n;
        i5 = i1;
        continue;
        if (n != 1) {
          continue;
        }
        bool2 = true;
        k = 1;
        bool4 = bool2;
        continue;
      }
      try
      {
        if (!arrayOfString1.contains("msgfold_switch")) {
          continue;
        }
        arrayOfString2 = arrayOfString1.split("=");
        if ((arrayOfString2 == null) || (arrayOfString2.length != 2)) {
          continue;
        }
        i2 = Integer.valueOf(arrayOfString2[1].trim()).intValue();
        if ((i2 != 1) && (i2 != 0)) {
          continue;
        }
        if (i2 != 1) {
          continue;
        }
        bool3 = true;
        i1 = 1;
      }
      catch (Exception paramString)
      {
        i6 = j;
        j = n;
        n = i1;
        bool4 = bool1;
        bool5 = bool2;
        i1 = k;
        bool6 = bool3;
        continue;
      }
    }
    i3 = n;
    i2 = k;
    i6 = m;
    i5 = n;
    bool5 = bool2;
    i4 = k;
    for (;;)
    {
      try
      {
        if (arrayOfString1.contains("msgfold_num"))
        {
          i6 = m;
          i5 = n;
          bool5 = bool2;
          i4 = k;
          arrayOfString2 = arrayOfString1.split("=");
          i3 = n;
          i2 = k;
          if (arrayOfString2 != null)
          {
            i3 = n;
            i2 = k;
            i6 = m;
            i5 = n;
            bool5 = bool2;
            i4 = k;
            if (arrayOfString2.length == 2)
            {
              i6 = m;
              i5 = n;
              bool5 = bool2;
              i4 = k;
              i8 = Integer.valueOf(arrayOfString2[1].trim()).intValue();
              i3 = n;
              i2 = k;
              if (i8 >= 0)
              {
                i3 = 1;
                i2 = i8;
              }
            }
          }
        }
        k = m;
        bool4 = bool2;
        i6 = m;
        i5 = i3;
        bool5 = bool2;
        i4 = i2;
        if (arrayOfString1.contains("Index_switch"))
        {
          i6 = m;
          i5 = i3;
          bool5 = bool2;
          i4 = i2;
          arrayOfString2 = arrayOfString1.split("=");
          k = m;
          bool4 = bool2;
          if (arrayOfString2 != null)
          {
            k = m;
            bool4 = bool2;
            i6 = m;
            i5 = i3;
            bool5 = bool2;
            i4 = i2;
            if (arrayOfString2.length == 2)
            {
              i6 = m;
              i5 = i3;
              bool5 = bool2;
              i4 = i2;
              n = Integer.valueOf(arrayOfString2[1].trim()).intValue();
              if (n == 1) {
                break label1101;
              }
              k = m;
              bool4 = bool2;
              if (n == 0) {
                break label1101;
              }
            }
          }
        }
        i6 = k;
        i5 = i3;
        bool5 = bool4;
        i4 = i2;
        if (!arrayOfString1.contains("with_redbagid")) {
          continue;
        }
        i6 = k;
        i5 = i3;
        bool5 = bool4;
        i4 = i2;
        arrayOfString1 = arrayOfString1.split("=");
        if (arrayOfString1 == null) {
          continue;
        }
        i6 = k;
        i5 = i3;
        bool5 = bool4;
        i4 = i2;
        if (arrayOfString1.length != 2) {
          continue;
        }
        i6 = k;
        i5 = i3;
        bool5 = bool4;
        i4 = i2;
        m = Integer.valueOf(arrayOfString1[1].trim()).intValue();
        if ((m != 1) && (m != 0)) {
          continue;
        }
        if (m != 1) {
          continue;
        }
        bool1 = true;
        j = 1;
      }
      catch (Exception paramString)
      {
        m = i6;
        n = i1;
        i6 = j;
        j = i5;
        bool4 = bool1;
        i1 = i4;
        bool6 = bool3;
        continue;
        bool4 = bool3;
        bool3 = bool1;
        j = k;
        bool1 = bool4;
        continue;
        continue;
      }
      i7 += 1;
      m = k;
      n = i3;
      bool2 = bool4;
      k = i2;
      break;
      bool3 = false;
      break label246;
      bool2 = false;
      break label1110;
      bool1 = false;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    return ((PasswdRedBagManager)paramQQAppInterface.getManager(124)).jdField_b_of_type_Boolean;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    return (paramInt == 1) && (!((HotChatManager)paramQQAppInterface.getManager(59)).b(paramString));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    return ((PasswdRedBagManager)paramQQAppInterface.getManager(124)).jdField_c_of_type_Boolean;
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 0: 
    case 1000: 
    case 1001: 
    case 1004: 
    case 10002: 
    case 10004: 
      return 3;
    }
    return 2;
  }
  
  public Bitmap a()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (BaseApplicationImpl.sImageCache != null) {}
    label134:
    for (Bitmap localBitmap1 = (Bitmap)BaseApplicationImpl.sImageCache.get("StatusIcon_HongBaoIcon");; localBitmap1 = null) {
      if (localBitmap1 == null) {
        try
        {
          Bitmap localBitmap2 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130844123);
          localObject1 = localBitmap2;
          localObject2 = localObject1;
          if (localObject1 != null) {}
          Object localObject3;
          return localBitmap1;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            try
            {
              localObject2 = Bitmap.createScaledBitmap(localObject1, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 15.0F), true);
              if (localObject2 == null) {
                break label134;
              }
              if (BaseApplicationImpl.sImageCache != null) {
                BaseApplicationImpl.sImageCache.put("StatusIcon_HongBaoIcon", localObject2);
              }
              return localObject2;
            }
            catch (OutOfMemoryError localOutOfMemoryError1)
            {
              continue;
            }
            catch (Exception localException2)
            {
              continue;
            }
            localException1 = localException1;
            localException1.printStackTrace();
            localObject3 = localObject1;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          for (;;)
          {
            localObject1 = localObject3;
            localObject3 = localOutOfMemoryError2;
            localObject3.printStackTrace();
            localObject3 = localObject1;
          }
        }
      }
    }
  }
  
  public PasswdRedBagInfo a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    a(false);
    return (PasswdRedBagInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public MessageRecord a(List paramList, MessageForFoldMsg paramMessageForFoldMsg, LinkedHashSet arg3, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1;
    Object localObject3;
    if ((QLog.isColorLevel()) && (StartupTracker.a()) && (paramList.size() > 0))
    {
      localObject1 = new StringBuilder(paramList.size() * 48 + 64);
      ((StringBuilder)localObject1).append("getFoldGrayTipsFormAIOList before insert,aioList size=").append(paramList.size()).append(":");
      if (paramBoolean2)
      {
        synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop))
        {
          localObject3 = paramList.iterator();
          if (((Iterator)localObject3).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
            ((StringBuilder)localObject1).append("(").append(localMessageRecord.time).append(",").append(localMessageRecord.shmsgseq).append(",").append(localMessageRecord.msgtype).append(") ");
          }
        }
        QLog.d("msgFold", 2, ((StringBuilder)localObject1).toString());
      }
    }
    else
    {
      if (this.jdField_d_of_type_JavaUtilHashMap == null) {
        this.jdField_d_of_type_JavaUtilHashMap = new HashMap();
      }
      if (this.jdField_e_of_type_JavaUtilHashMap == null) {
        this.jdField_e_of_type_JavaUtilHashMap = new HashMap();
      }
      localObject1 = paramMessageForFoldMsg.frienduin + paramMessageForFoldMsg.istroop + paramMessageForFoldMsg.redBagId;
      ??? = paramMessageForFoldMsg.frienduin + paramMessageForFoldMsg.istroop + paramMessageForFoldMsg.redBagIndex;
      if ((!paramBoolean1) || (!this.jdField_e_of_type_JavaUtilHashMap.containsKey(???))) {
        break label579;
      }
      localObject3 = (MessageForFoldMsgGrayTips)this.jdField_e_of_type_JavaUtilHashMap.get(???);
      ((MessageForFoldMsgGrayTips)localObject3).update(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForFoldMsg.frienduin, ???, paramInt, paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex);
      if (this.jdField_d_of_type_JavaUtilHashMap.containsKey(localObject1)) {
        a(paramList, (String)???, (String)localObject1, paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop, paramBoolean2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, String.format("update foldmsg graytips, index mode, uin: %s, type: %d, redBagId: %s, index: %s, num: %d", new Object[] { ((MessageForFoldMsgGrayTips)localObject3).frienduin, Integer.valueOf(((MessageForFoldMsgGrayTips)localObject3).istroop), paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex, Integer.valueOf(((MessageForFoldMsgGrayTips)localObject3).foldMsgCount) }));
      }
      paramList = null;
    }
    label1074:
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80064BC", "0X80064BC", 0, 0, "", "", "", "");
      return paramList;
      ??? = paramList.iterator();
      while (((Iterator)???).hasNext())
      {
        localObject3 = (MessageRecord)((Iterator)???).next();
        ((StringBuilder)localObject1).append("(").append(((MessageRecord)localObject3).time).append(",").append(((MessageRecord)localObject3).shmsgseq).append(",").append(((MessageRecord)localObject3).msgtype).append(") ");
      }
      break;
      label579:
      if ((paramBoolean1) && (this.jdField_d_of_type_JavaUtilHashMap.containsKey(localObject1)))
      {
        paramList = (MessageForFoldMsgGrayTips)this.jdField_d_of_type_JavaUtilHashMap.get(localObject1);
        paramList.update(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForFoldMsg.frienduin, ???, paramInt, paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex);
        if (!TextUtils.isEmpty(paramMessageForFoldMsg.redBagIndex))
        {
          this.jdField_d_of_type_JavaUtilHashMap.remove(localObject1);
          this.jdField_e_of_type_JavaUtilHashMap.put(???, paramList);
        }
        if (QLog.isColorLevel()) {
          QLog.d("msgFold", 2, String.format("update foldmsg graytips, id mode, uin: %s, type: %d, redBagId: %s, index: %s,  num: %d", new Object[] { paramList.frienduin, Integer.valueOf(paramList.istroop), paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex, Integer.valueOf(paramList.foldMsgCount) }));
        }
        paramList = null;
      }
      else
      {
        localObject1 = (MessageForFoldMsgGrayTips)MessageRecordFactory.a(-5011);
        MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject1, paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop);
        ((MessageForFoldMsgGrayTips)localObject1).shmsgseq = paramMessageForFoldMsg.shmsgseq;
        ((MessageForFoldMsgGrayTips)localObject1).time = paramMessageForFoldMsg.time;
        ((MessageForFoldMsgGrayTips)localObject1).foldMsgCount = paramInt;
        ((MessageForFoldMsgGrayTips)localObject1).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.mPasswdRedBagSender, ???, paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex);
        if (paramBoolean2) {}
        for (;;)
        {
          synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop))
          {
            MsgProxyUtils.c(paramList, (MessageRecord)localObject1, true);
            if ((!QLog.isColorLevel()) || (!StartupTracker.a()) || (paramList == null) || (paramList.size() <= 0)) {
              break label1074;
            }
            ??? = new StringBuilder(paramList.size() * 48 + 64);
            ((StringBuilder)???).append("getFoldGrayTipsFormAIOList after insert,isNeedMsgListLock=").append(paramBoolean2);
            ((StringBuilder)???).append(",aioList size=").append(paramList.size()).append(":");
            synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop))
            {
              paramList = paramList.iterator();
              if (!paramList.hasNext()) {
                break;
              }
              localObject3 = (MessageRecord)paramList.next();
              ((StringBuilder)???).append("(").append(((MessageRecord)localObject3).time).append(",").append(((MessageRecord)localObject3).shmsgseq).append(",").append(((MessageRecord)localObject3).msgtype).append(") ");
            }
          }
          MsgProxyUtils.c(paramList, (MessageRecord)localObject1, true);
        }
        QLog.d("msgFold", 2, ((StringBuilder)???).toString());
        a(paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop, paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex, (MessageForFoldMsgGrayTips)localObject1);
        paramList = (List)localObject1;
      }
    }
  }
  
  public Boolean a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    int j = 0;
    if (this.jdField_a_of_type_Int == 0) {
      return Boolean.valueOf(true);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString1, paramInt);
    if (localObject == null) {
      return Boolean.valueOf(false);
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt);
    paramString1 = (String)localObject;
    if (localList != null)
    {
      paramString1 = (String)localObject;
      if (((List)localObject).size() < localList.size()) {
        paramString1 = localList;
      }
    }
    int k = paramString1.size() - 1;
    while (k > 0)
    {
      localObject = (MessageRecord)paramString1.get(k);
      paramInt = j;
      if ((localObject instanceof MessageForFoldMsg))
      {
        localObject = (MessageForFoldMsg)localObject;
        if ((TextUtils.isEmpty(paramString2)) || (!paramString2.equals(((MessageForFoldMsg)localObject).redBagId)))
        {
          paramInt = j;
          if (!TextUtils.isEmpty(paramString3))
          {
            paramInt = j;
            if (!paramString3.equals(((MessageForFoldMsg)localObject).redBagIndex)) {}
          }
        }
        else
        {
          j += 1;
          if (!((MessageForFoldMsg)localObject).foldFlag)
          {
            paramInt = j;
            if (j < this.jdField_a_of_type_Int) {}
          }
          else
          {
            return Boolean.valueOf(true);
          }
        }
      }
      k -= 1;
      j = paramInt;
    }
    return Boolean.valueOf(false);
  }
  
  public String a()
  {
    f();
    if (this.jdField_c_of_type_JavaUtilList.size() == 0) {
      return null;
    }
    int j = new Random(System.currentTimeMillis()).nextInt(this.jdField_c_of_type_JavaUtilList.size());
    return (String)this.jdField_c_of_type_JavaUtilList.get(j);
  }
  
  public void a()
  {
    if ((this.jdField_h_of_type_JavaUtilHashMap == null) || (this.jdField_h_of_type_JavaUtilHashMap.size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
      localArrayList = new ArrayList();
      List localList = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBManager.a(1);
      Iterator localIterator = this.jdField_h_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        PasswdRedBagUpdateInfo localPasswdRedBagUpdateInfo = new PasswdRedBagUpdateInfo();
        localPasswdRedBagUpdateInfo.jdField_a_of_type_Long = Long.parseLong((String)localObject);
        localPasswdRedBagUpdateInfo.jdField_a_of_type_Int = 1;
        localPasswdRedBagUpdateInfo.b = Long.parseLong((String)this.jdField_h_of_type_JavaUtilHashMap.get(localObject));
        int j = localList.indexOf(localPasswdRedBagUpdateInfo);
        if (j != -1)
        {
          localObject = (PasswdRedBagUpdateInfo)localList.get(j);
          if (localPasswdRedBagUpdateInfo.b <= ((PasswdRedBagUpdateInfo)localObject).b) {}
        }
        else
        {
          localObject = new oidb_0x438.ReqInfo();
          ((oidb_0x438.ReqInfo)localObject).uint64_code.set(localPasswdRedBagUpdateInfo.jdField_a_of_type_Long);
          ((oidb_0x438.ReqInfo)localObject).uint64_last_redbag_time.set(localPasswdRedBagUpdateInfo.b);
          localArrayList.add(localObject);
          this.jdField_a_of_type_JavaUtilList.add(localPasswdRedBagUpdateInfo);
        }
      }
      this.jdField_h_of_type_JavaUtilHashMap.clear();
    } while (this.jdField_a_of_type_JavaUtilList.isEmpty());
    this.jdField_a_of_type_ComTencentMobileqqAppQWalletHandler.a(0, localArrayList);
  }
  
  public void a(SessionInfo paramSessionInfo, PasswdRedBagInfo paramPasswdRedBagInfo, long paramLong, int paramInt)
  {
    a(paramSessionInfo, paramPasswdRedBagInfo, paramLong, 32, paramInt);
  }
  
  public void a(SessionInfo paramSessionInfo, PasswdRedBagInfo paramPasswdRedBagInfo, long paramLong, int paramInt1, int paramInt2)
  {
    a(paramSessionInfo, paramPasswdRedBagInfo, paramLong, paramInt1, "", paramInt2);
  }
  
  public void a(SessionInfo paramSessionInfo, PasswdRedBagInfo paramPasswdRedBagInfo, long paramLong, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramSessionInfo == null) || (paramPasswdRedBagInfo == null)) {}
    String str2;
    do
    {
      return;
      d();
      str2 = (String)this.jdField_c_of_type_JavaUtilHashMap.get(a(paramSessionInfo.jdField_a_of_type_Int) + "_" + paramSessionInfo.jdField_a_of_type_JavaLangString + "_" + paramPasswdRedBagInfo.jdField_a_of_type_JavaLangString);
    } while (TextUtils.isEmpty(str2));
    int j;
    Object localObject;
    if ((paramSessionInfo.jdField_a_of_type_Int == 0) || (paramSessionInfo.jdField_a_of_type_Int == 2) || (paramSessionInfo.jdField_a_of_type_Int == 1004) || (paramSessionInfo.jdField_a_of_type_Int == 1001) || (paramSessionInfo.jdField_a_of_type_Int == 10002))
    {
      j = 1;
      str1 = paramSessionInfo.jdField_a_of_type_JavaLangString;
      localObject = String.valueOf(paramPasswdRedBagInfo.jdField_c_of_type_JavaLangString);
      if (j != 0) {
        if (!((String)localObject).equals(this.jdField_a_of_type_JavaLangString)) {
          break label408;
        }
      }
    }
    label408:
    for (String str1 = paramSessionInfo.jdField_a_of_type_JavaLangString;; str1 = this.jdField_a_of_type_JavaLangString)
    {
      localObject = QWalletRedPkgUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSessionInfo);
      j = ((Bundle)localObject).getInt("groupType");
      localObject = ((Bundle)localObject).getString("name");
      paramPasswdRedBagInfo = paramPasswdRedBagInfo.jdField_a_of_type_JavaLangString;
      paramSessionInfo = QWalletRedPkgUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSessionInfo, j, (String)localObject, paramPasswdRedBagInfo, str2, str1, "appid#1344242394|bargainor_id#1000030201|channel#msg", "graphb", null, paramInt1, 0, paramString, paramInt2);
      paramString = new Bundle();
      paramString.putString("json", paramSessionInfo.toString());
      paramString.putString("callbackSn", "0");
      paramSessionInfo = paramPasswdRedBagInfo;
      if (paramPasswdRedBagInfo != null)
      {
        paramSessionInfo = paramPasswdRedBagInfo;
        if (paramPasswdRedBagInfo.length() > 4) {
          paramSessionInfo = "****" + paramPasswdRedBagInfo.substring(4);
        }
      }
      VACDReportUtil.a(paramLong, null, "open", "groupType=" + j + "&msgType=6&redId=" + paramSessionInfo, 0, null);
      paramString.putLong("vacreport_key_seq", paramLong);
      paramSessionInfo = new Intent(this.jdField_a_of_type_AndroidContentContext, PayBridgeActivity.class);
      paramSessionInfo.putExtras(paramString);
      paramSessionInfo.addFlags(268435456);
      paramSessionInfo.putExtra("pay_requestcode", 5);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramSessionInfo);
      return;
      j = 0;
      break;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    PasswdRedBagInfo localPasswdRedBagInfo;
    do
    {
      return;
      a(false);
      localPasswdRedBagInfo = (PasswdRedBagInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    } while ((localPasswdRedBagInfo == null) || (localPasswdRedBagInfo.jdField_b_of_type_Boolean));
    localPasswdRedBagInfo.jdField_b_of_type_Boolean = true;
    ThreadManager.getFileThreadHandler().post(new wzz(this, paramString));
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, MessageForFoldMsgGrayTips paramMessageForFoldMsgGrayTips)
  {
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString2 = paramString1 + paramInt + paramString3;
      if ((this.jdField_e_of_type_JavaUtilHashMap != null) && (!this.jdField_e_of_type_JavaUtilHashMap.containsKey(paramString2)))
      {
        this.jdField_e_of_type_JavaUtilHashMap.put(paramString2, paramMessageForFoldMsgGrayTips);
        if (QLog.isColorLevel()) {
          QLog.d("msgFold", 2, String.format("new foldmsg graytips, uin: %s, type: %d, redBagIndex: %s num: %d", new Object[] { paramString1, Integer.valueOf(paramInt), paramString3, Integer.valueOf(paramMessageForFoldMsgGrayTips.foldMsgCount) }));
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (TextUtils.isEmpty(paramString2));
        paramString3 = paramString1 + paramInt + paramString2;
      } while ((this.jdField_d_of_type_JavaUtilHashMap == null) || (this.jdField_d_of_type_JavaUtilHashMap.containsKey(paramString3)));
      this.jdField_d_of_type_JavaUtilHashMap.put(paramString3, paramMessageForFoldMsgGrayTips);
    } while (!QLog.isColorLevel());
    QLog.d("msgFold", 2, String.format("new foldmsg graytips, uin: %s, type: %d, redBagId: %s num: %d", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, Integer.valueOf(paramMessageForFoldMsgGrayTips.foldMsgCount) }));
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return;
      a(false);
      if ((paramInt == 1) || (paramInt == 3000)) {
        NotifyMsgManager.a(paramString2, paramInt, paramString1);
      }
      paramString2 = (PasswdRedBagInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    } while ((paramString2 == null) || (paramString2.jdField_a_of_type_Boolean));
    paramString2.jdField_a_of_type_Boolean = true;
    ThreadManager.getFileThreadHandler().post(new wzs(this, paramString1));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((PasswdRedBagInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1) == null)
    {
      paramString2 = new PasswdRedBagInfo(paramString1, paramString2, paramString4, paramLong, new QQText(paramString3, 5, 16).toString(), paramBoolean1, paramBoolean2, false, paramInt);
      a(paramString2);
      a(true, paramString2.jdField_a_of_type_JavaLangString, paramString2.jdField_b_of_type_JavaLangString);
      ThreadManager.getFileThreadHandler().post(new wzx(this, paramString2));
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString5);
    paramString2.append("_");
    paramString2.append(paramString6);
    paramString2.append("_");
    paramString2.append(paramString1);
    if (TextUtils.isEmpty((String)this.jdField_c_of_type_JavaUtilHashMap.get(paramString2.toString())))
    {
      this.jdField_c_of_type_JavaUtilHashMap.put(paramString2.toString(), paramString7);
      ThreadManager.getFileThreadHandler().post(new wzy(this, paramString5, paramString6, paramString1, paramString7));
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8006115", "0X8006115", 0, 0, "", str, paramString, "0");
      return;
    }
  }
  
  public void a(HashMap paramHashMap)
  {
    if (this.jdField_h_of_type_JavaUtilHashMap == null) {
      this.jdField_h_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_h_of_type_JavaUtilHashMap.putAll(paramHashMap);
  }
  
  public void a(HashSet paramHashSet)
  {
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.addAll(paramHashSet);
    a(paramHashSet);
  }
  
  public void a(List paramList, MessageForFoldMsg paramMessageForFoldMsg)
  {
    if ((paramMessageForFoldMsg.isSend()) && (!paramMessageForFoldMsg.foldFlag) && (paramMessageForFoldMsg.msgtype == -2006)) {
      return;
    }
    if ((!TextUtils.isEmpty(paramMessageForFoldMsg.redBagIndex)) && (!TextUtils.isEmpty(paramMessageForFoldMsg.redBagId))) {
      a(true, paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex);
    }
    if ((TextUtils.isEmpty(paramMessageForFoldMsg.redBagIndex)) && (!TextUtils.isEmpty(paramMessageForFoldMsg.redBagId)) && (this.jdField_f_of_type_JavaUtilHashMap.containsKey(paramMessageForFoldMsg.redBagId))) {
      paramMessageForFoldMsg.redBagIndex = ((String)this.jdField_f_of_type_JavaUtilHashMap.get(paramMessageForFoldMsg.redBagId));
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    localLinkedHashSet.add(paramMessageForFoldMsg.senderuin);
    a(paramList, paramMessageForFoldMsg, localLinkedHashSet, 1, true, false);
  }
  
  public void a(List paramList, String arg2, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    MessageForFoldMsgGrayTips localMessageForFoldMsgGrayTips = (MessageForFoldMsgGrayTips)this.jdField_e_of_type_JavaUtilHashMap.get(???);
    paramString2 = (MessageForFoldMsgGrayTips)this.jdField_d_of_type_JavaUtilHashMap.get(paramString2);
    this.jdField_d_of_type_JavaUtilHashMap.remove(???);
    localMessageForFoldMsgGrayTips.update(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2.frienduin, paramString2.foldUinList, paramString2.foldMsgCount, paramString2.redBagId, paramString2.redBagIndex);
    if (paramBoolean) {}
    for (;;)
    {
      synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString3, paramInt))
      {
        paramList.remove(paramString2);
        if (QLog.isColorLevel()) {
          QLog.d("msgFold", 2, new Object[] { "update foldmsg graytips, index mode merge,", ",mst.time=", Long.valueOf(paramString2.time), ".msg.shmsgseq=", Long.valueOf(paramString2.shmsgseq), ",msg.type=", Integer.valueOf(paramString2.msgtype), ",isNeedMsgListLock=", Boolean.valueOf(paramBoolean) });
        }
        return;
      }
      paramList.remove(paramString2);
    }
  }
  
  public void a(Set paramSet)
  {
    try
    {
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("sp_passwd_configs_" + this.jdField_a_of_type_JavaLangString, 0).edit();
      if (Build.VERSION.SDK_INT >= 11) {
        localEditor.putStringSet("key_passwd_configs", paramSet);
      }
      for (;;)
      {
        localEditor.commit();
        return;
        localEditor.putInt("key_passwd_configs_count", paramSet.size());
        paramSet = paramSet.iterator();
        int j = 0;
        while (paramSet.hasNext())
        {
          String str = (String)paramSet.next();
          localEditor.putString("key_passwd_configs_" + j, str);
          j += 1;
        }
      }
      return;
    }
    catch (Throwable paramSet)
    {
      paramSet.printStackTrace();
    }
  }
  
  public void a(im_msg_body.QQWalletAioBody paramQQWalletAioBody, int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2)
  {
    a(paramQQWalletAioBody.bytes_billno.get().toStringUtf8(), paramQQWalletAioBody.string_index.get().toStringUtf8(), paramQQWalletAioBody.receiver.bytes_title.get().toStringUtf8(), String.valueOf(paramLong2), paramLong3 + 90000L, String.valueOf(paramInt1), String.valueOf(paramLong1), paramQQWalletAioBody.bytes_authkey.get().toStringUtf8(), false, false, paramInt2);
  }
  
  public void a(oidb_0x438.RedBagInfo paramRedBagInfo)
  {
    a(paramRedBagInfo.string_redbag_id.get().toStringUtf8(), paramRedBagInfo.string_index.get().toStringUtf8(), paramRedBagInfo.string_password.get().toStringUtf8(), String.valueOf(paramRedBagInfo.uint64_creator_uin.get()), paramRedBagInfo.uint64_expire_time.get(), String.valueOf(paramRedBagInfo.uint32_source.get()), String.valueOf(paramRedBagInfo.uint64_code.get()), paramRedBagInfo.string_authkey.get().toStringUtf8(), false, false, 0);
  }
  
  public void a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (a()) {
          e();
        }
        if (QLog.isColorLevel()) {
          QLog.d("msgFold", 2, "loadRedBagInfoToCache sync=" + paramBoolean + ",isNeedSyncLoadRedBagInfo=" + this.jdField_e_of_type_Boolean + ",isNeedLoadRedBagInfo=" + this.jdField_f_of_type_Boolean);
        }
        if (!paramBoolean) {
          break label153;
        }
        paramBoolean = this.jdField_e_of_type_Boolean;
        if (!paramBoolean) {
          return;
        }
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBManager.a().iterator();
        if (localIterator.hasNext())
        {
          PasswdRedBagInfo localPasswdRedBagInfo = (PasswdRedBagInfo)localIterator.next();
          a(localPasswdRedBagInfo);
          a(false, localPasswdRedBagInfo.jdField_a_of_type_JavaLangString, localPasswdRedBagInfo.jdField_b_of_type_JavaLangString);
          continue;
        }
        this.jdField_e_of_type_Boolean = false;
      }
      finally {}
      continue;
      label153:
      if ((this.jdField_f_of_type_Boolean) && (this.jdField_e_of_type_Boolean))
      {
        ThreadManager.post(new wzv(this), 8, null, false);
        this.jdField_f_of_type_Boolean = false;
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean) {
      a(false);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      if (!this.jdField_f_of_type_JavaUtilHashMap.containsKey(paramString1)) {
        this.jdField_f_of_type_JavaUtilHashMap.put(paramString1, paramString2);
      }
    } while (this.jdField_g_of_type_JavaUtilHashMap.containsKey(paramString2));
    this.jdField_g_of_type_JavaUtilHashMap.put(paramString2, paramString1);
  }
  
  public boolean a()
  {
    return !this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    boolean bool = false;
    String str = paramString1 + paramInt + paramString2;
    paramString1 = paramString1 + paramInt + paramString3;
    if ((!TextUtils.isEmpty(paramString2)) && (this.jdField_d_of_type_JavaUtilHashMap != null) && (this.jdField_d_of_type_JavaUtilHashMap.containsKey(str)))
    {
      paramInt = 1;
      if ((TextUtils.isEmpty(paramString3)) || (this.jdField_e_of_type_JavaUtilHashMap == null) || (!this.jdField_e_of_type_JavaUtilHashMap.containsKey(paramString1))) {
        break label128;
      }
    }
    label128:
    for (int j = 1;; j = 0)
    {
      if ((paramInt != 0) || (j != 0)) {
        bool = true;
      }
      return bool;
      paramInt = 0;
      break;
    }
  }
  
  public Object[] a(SessionInfo paramSessionInfo, String paramString, int paramInt)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(0);
    arrayOfObject[1] = Long.valueOf(0L);
    arrayOfObject[2] = null;
    arrayOfObject[3] = null;
    if (paramSessionInfo == null) {
      return arrayOfObject;
    }
    if (TextUtils.isEmpty(paramString)) {
      return arrayOfObject;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString.charAt(0));
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(paramString.length());
      QLog.d("PasswdRedBagManager", 2, "openPasswdRedBagByPassword, passwd = " + ((StringBuilder)localObject).toString());
    }
    long l = SystemClock.uptimeMillis();
    a(false);
    d();
    paramString = (List)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
    if ((paramString == null) || (paramString.isEmpty())) {
      return arrayOfObject;
    }
    Object localObject = a(paramSessionInfo.jdField_a_of_type_Int) + "_" + paramSessionInfo.jdField_a_of_type_JavaLangString + "_";
    Iterator localIterator = paramString.iterator();
    String str2;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        str2 = (String)localObject + str1;
        if (!this.jdField_c_of_type_JavaUtilHashMap.containsKey(str2))
        {
          if (QLog.isColorLevel()) {
            QLog.d("msgFold", 2, "get redbagid, no find passwd redbag auth key in cache, key: " + str2);
          }
        }
        else
        {
          paramString = (PasswdRedBagInfo)this.jdField_a_of_type_JavaUtilHashMap.get(str1);
          if (paramString != null)
          {
            arrayOfObject[1] = Long.valueOf(paramString.jdField_c_of_type_JavaLangString);
            if ((!paramString.jdField_c_of_type_Boolean) && (paramString.jdField_a_of_type_Long >= NetConnInfoCenter.getServerTimeMillis() / 1000L))
            {
              arrayOfObject[2] = str1;
              arrayOfObject[3] = paramString.jdField_b_of_type_JavaLangString;
            }
            if (paramString.jdField_a_of_type_Boolean) {
              continue;
            }
            if (paramString.jdField_b_of_type_Boolean)
            {
              arrayOfObject[0] = Integer.valueOf(2);
              continue;
            }
            if ((paramString.jdField_c_of_type_Boolean) || (paramString.jdField_a_of_type_Long < NetConnInfoCenter.getServerTimeMillis() / 1000L))
            {
              if (!paramString.jdField_c_of_type_Boolean) {
                b(str1);
              }
              arrayOfObject[0] = Integer.valueOf(3);
              continue;
            }
            paramString.jdField_a_of_type_Boolean = true;
            arrayOfObject[0] = Integer.valueOf(1);
          }
        }
      }
    }
    for (;;)
    {
      if (paramString == null)
      {
        return arrayOfObject;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("msgFold", 2, "get redbagid, no find passwd redbag in cache, key: " + str2);
        break;
      }
      l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendByPwd", "msgType=6", 0, null, l);
      a(paramString.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
      a(paramSessionInfo, paramString, l, paramInt);
      return arrayOfObject;
      paramString = null;
    }
  }
  
  public void b()
  {
    if ((this.i == null) || (this.i.size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      return;
      this.jdField_b_of_type_JavaUtilList.clear();
      localArrayList = new ArrayList();
      List localList = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBManager.a(2);
      Iterator localIterator = this.i.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        PasswdRedBagUpdateInfo localPasswdRedBagUpdateInfo = new PasswdRedBagUpdateInfo();
        localPasswdRedBagUpdateInfo.jdField_a_of_type_Long = Long.parseLong((String)localObject);
        localPasswdRedBagUpdateInfo.jdField_a_of_type_Int = 2;
        localPasswdRedBagUpdateInfo.b = Long.parseLong((String)this.i.get(localObject));
        int j = localList.indexOf(localPasswdRedBagUpdateInfo);
        if (j != -1)
        {
          localObject = (PasswdRedBagUpdateInfo)localList.get(j);
          if (localPasswdRedBagUpdateInfo.b <= ((PasswdRedBagUpdateInfo)localObject).b) {}
        }
        else
        {
          localObject = new oidb_0x438.ReqInfo();
          ((oidb_0x438.ReqInfo)localObject).uint64_code.set(localPasswdRedBagUpdateInfo.jdField_a_of_type_Long);
          ((oidb_0x438.ReqInfo)localObject).uint64_last_redbag_time.set(localPasswdRedBagUpdateInfo.b);
          localArrayList.add(localObject);
          this.jdField_b_of_type_JavaUtilList.add(localPasswdRedBagUpdateInfo);
        }
      }
      this.i.clear();
    } while (this.jdField_b_of_type_JavaUtilList.isEmpty());
    this.jdField_a_of_type_ComTencentMobileqqAppQWalletHandler.a(1, localArrayList);
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    PasswdRedBagInfo localPasswdRedBagInfo;
    do
    {
      return;
      a(false);
      localPasswdRedBagInfo = (PasswdRedBagInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    } while ((localPasswdRedBagInfo == null) || (localPasswdRedBagInfo.jdField_c_of_type_Boolean));
    localPasswdRedBagInfo.jdField_c_of_type_Boolean = true;
    ThreadManager.getFileThreadHandler().post(new xaa(this, paramString));
  }
  
  public void b(HashMap paramHashMap)
  {
    if (this.i == null) {
      this.i = new HashMap();
    }
    this.i.putAll(paramHashMap);
  }
  
  public Object[] b(SessionInfo paramSessionInfo, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PasswdRedBagManager", 2, "openPasswdRedBagById, id = " + paramString);
    }
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(0);
    arrayOfObject[1] = Long.valueOf(0L);
    arrayOfObject[2] = null;
    arrayOfObject[3] = null;
    if (paramSessionInfo == null) {
      return arrayOfObject;
    }
    if (TextUtils.isEmpty(paramString)) {
      return arrayOfObject;
    }
    long l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendById", "msgType=6", 0, null);
    a(false);
    d();
    PasswdRedBagInfo localPasswdRedBagInfo = (PasswdRedBagInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localPasswdRedBagInfo == null)
    {
      VACDReportUtil.endReport(l, "pwd.end", "", -1, "no redid");
      return arrayOfObject;
    }
    arrayOfObject[1] = Long.valueOf(localPasswdRedBagInfo.jdField_c_of_type_JavaLangString);
    if ((!localPasswdRedBagInfo.jdField_c_of_type_Boolean) && (localPasswdRedBagInfo.jdField_a_of_type_Long >= NetConnInfoCenter.getServerTimeMillis() / 1000L))
    {
      arrayOfObject[2] = paramString;
      arrayOfObject[3] = localPasswdRedBagInfo.jdField_b_of_type_JavaLangString;
    }
    if (localPasswdRedBagInfo.jdField_a_of_type_Boolean)
    {
      VACDReportUtil.endReport(l, "pwd.end", "", -1, "opened");
      return arrayOfObject;
    }
    if (localPasswdRedBagInfo.jdField_b_of_type_Boolean)
    {
      arrayOfObject[0] = Integer.valueOf(2);
      VACDReportUtil.endReport(l, "pwd.end", "", -1, "finish");
      return arrayOfObject;
    }
    if ((localPasswdRedBagInfo.jdField_c_of_type_Boolean) || (localPasswdRedBagInfo.jdField_a_of_type_Long < NetConnInfoCenter.getServerTimeMillis() / 1000L))
    {
      if (!localPasswdRedBagInfo.jdField_c_of_type_Boolean) {
        b(paramString);
      }
      arrayOfObject[0] = Integer.valueOf(3);
      VACDReportUtil.endReport(l, "pwd.end", "", -1, "overdue");
      return arrayOfObject;
    }
    a(paramString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    a(paramSessionInfo, localPasswdRedBagInfo, l, paramInt);
    arrayOfObject[0] = Integer.valueOf(1);
    return arrayOfObject;
  }
  
  public void c()
  {
    try
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("sp_passwd_configs_" + this.jdField_a_of_type_JavaLangString, 0);
      if (localSharedPreferences.getBoolean("key_db_update", true))
      {
        ThreadManager.getFileThreadHandler().post(new wzt(this));
        localSharedPreferences.edit().putBoolean("key_db_update", false);
        localSharedPreferences.edit().commit();
      }
      ThreadManager.getFileThreadHandler().post(new wzu(this));
      return;
    }
    finally {}
  }
  
  public void c(String paramString)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006116", "0X8006116", 0, 0, "", "0", paramString, "0");
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 942	com/tencent/mobileqq/activity/qwallet/PasswdRedBagManager:a	()Z
    //   6: ifeq +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 944	com/tencent/mobileqq/activity/qwallet/PasswdRedBagManager:e	()V
    //   13: aload_0
    //   14: getfield 126	com/tencent/mobileqq/activity/qwallet/PasswdRedBagManager:jdField_g_of_type_Boolean	Z
    //   17: istore_1
    //   18: iload_1
    //   19: ifne +6 -> 25
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: invokestatic 724	com/tencent/mobileqq/app/ThreadManager:getFileThreadHandler	()Lmqq/os/MqqHandler;
    //   28: new 1051	wzw
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 1052	wzw:<init>	(Lcom/tencent/mobileqq/activity/qwallet/PasswdRedBagManager;)V
    //   36: invokevirtual 735	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   39: pop
    //   40: aload_0
    //   41: iconst_0
    //   42: putfield 126	com/tencent/mobileqq/activity/qwallet/PasswdRedBagManager:jdField_g_of_type_Boolean	Z
    //   45: goto -23 -> 22
    //   48: astore_2
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_2
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	PasswdRedBagManager
    //   17	2	1	bool	boolean
    //   48	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	48	finally
    //   13	18	48	finally
    //   25	45	48	finally
  }
  
  public void d(String paramString)
  {
    ((TroopTipsMsgMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(80)).a(paramString, "匿名不能抢口令红包哦", NetConnInfoCenter.getServerTime(), 10000L, 0, 1);
  }
  
  public void e()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBManager = new PasswdRedBagDBManager(this);
    this.jdField_b_of_type_JavaUtilHashMap.clear();
    this.jdField_c_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = true;
  }
  
  public void e(String paramString)
  {
    ((TroopTipsMsgMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(80)).a(paramString, "禁言不能抢口令红包哦", NetConnInfoCenter.getServerTime(), 10000L, 0, 1);
  }
  
  public void f()
  {
    int j = 0;
    if (this.jdField_h_of_type_Boolean) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("sp_passwd_configs_" + this.jdField_a_of_type_JavaLangString, 0);
        if (Build.VERSION.SDK_INT < 11) {
          continue;
        }
        localObject = ((SharedPreferences)localObject).getStringSet("key_passwd_configs", new HashSet());
        if ((localObject != null) && (((Set)localObject).size() > 0)) {
          this.jdField_c_of_type_JavaUtilList.addAll((Collection)localObject);
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        int k;
        localThrowable.printStackTrace();
        continue;
      }
      this.jdField_h_of_type_Boolean = true;
      return;
      k = ((SharedPreferences)localObject).getInt("key_passwd_configs_count", 0);
      if (k > 0) {
        if (j < k)
        {
          this.jdField_c_of_type_JavaUtilList.add(((SharedPreferences)localObject).getString("key_passwd_configs_" + j, ""));
          j += 1;
        }
      }
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQWalletObserver.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppQWalletObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager
 * JD-Core Version:    0.7.0.1
 */