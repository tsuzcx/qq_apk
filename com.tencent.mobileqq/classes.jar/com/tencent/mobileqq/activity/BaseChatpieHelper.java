package com.tencent.mobileqq.activity;

import abti;
import afxr;
import aiis;
import alof;
import alse;
import alud;
import alzl;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import aoiy;
import asmt;
import asmu;
import asmx;
import atkk;
import atlt;
import aupg;
import azvd;
import bamb;
import bamd;
import baxl;
import bcmm;
import bcmn;
import bcpg;
import bdez;
import bdgc;
import bdhj;
import bdif;
import bdin;
import bhtk;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.utils.VideoUpConfigInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ndv;

public class BaseChatpieHelper
{
  private int jdField_a_of_type_Int = 1;
  private Context jdField_a_of_type_AndroidContentContext;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public BaseChatpieHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
  }
  
  public static int a(String paramString, ChatXListView paramChatXListView, int paramInt, List<ChatMessage> paramList1, List<ChatMessage> paramList2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString, 2, "keepPostionScroll mReadedCnt " + paramInt);
    }
    int k = paramList1.size();
    int i1 = paramList2.size();
    int n = paramChatXListView.getScrollY();
    int m = paramChatXListView.getFirstVisiblePosition();
    int i;
    int j;
    if (paramChatXListView.isOverscrollHeadVisiable())
    {
      i = paramChatXListView.getFirstVisiblePosition() - paramChatXListView.getHeaderViewsCount();
      j = paramInt;
      if (k > 0)
      {
        j = paramInt;
        if (m >= 0)
        {
          if (i1 <= 0) {
            break label748;
          }
          if (i < k) {
            break label741;
          }
          j = k - 1;
          label111:
          i = j;
          if (j >= 0) {
            break label738;
          }
          j += paramChatXListView.getHeaderViewsCount();
          i = j;
          if (j >= 0) {
            break label738;
          }
          i = 0;
          label141:
          long l = ((ChatMessage)paramList1.get(i)).uniseq;
          j = 0;
          label160:
          if (j >= i1) {
            break label732;
          }
          if (((ChatMessage)paramList2.get(j)).uniseq != l) {
            break label419;
          }
          label188:
          if ((j >= 0) || (paramList1.size() <= i + 1)) {
            break label714;
          }
          l = ((ChatMessage)paramList1.get(i + 1)).uniseq;
          k = 0;
          label227:
          if (k >= i1) {
            break label714;
          }
          if (((ChatMessage)paramList2.get(k)).uniseq != l) {
            break label428;
          }
          j = i;
          m = 1;
          i = k;
          k = j;
          j = m;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(paramString, 2, "refreshListAdapter newTop:" + i + " oldScorllY " + n + " oldFirst " + k);
      }
      if (i >= 0)
      {
        k = paramInt + i;
        paramInt = k;
        if (j != 0) {
          paramInt = k - 1;
        }
        if ((n < 0) && (i == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.i(paramString, 2, "springBackOverScrollHeaderView newTop:" + i + " oldScorllY " + n);
          }
          paramChatXListView.springBackOverScrollHeaderView();
          j = paramInt;
        }
        label419:
        label428:
        do
        {
          return j;
          i = paramChatXListView.getFirstVisiblePosition();
          break;
          j += 1;
          break label160;
          k += 1;
          break label227;
          if (n >= 0) {
            break label559;
          }
          j = paramChatXListView.getHeight();
          try
          {
            k = paramChatXListView.getChildAt(paramChatXListView.getHeaderViewsCount()).getBottom();
            k = j - k;
          }
          catch (NullPointerException paramList1)
          {
            for (;;)
            {
              k = paramChatXListView.getHeight();
            }
          }
          paramChatXListView.hideOverScrollHeaderView();
          paramChatXListView.setSelectionFromBottom(paramChatXListView.getHeaderViewsCount() + i, k + n - paramChatXListView.getPaddingBottom());
          j = paramInt;
        } while (!QLog.isColorLevel());
        QLog.i(paramString, 2, "setSelectionFromBottom_1 newTop:" + i + " oldScorllY " + n + " bottom " + k);
        return paramInt;
        label559:
        j = paramChatXListView.getHeight();
        try
        {
          k = paramChatXListView.getChildAt(paramChatXListView.getHeaderViewsCount()).getBottom();
          j -= k;
        }
        catch (NullPointerException paramList1)
        {
          for (;;)
          {
            j = paramChatXListView.getHeight();
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i(paramString, 2, "setSelectionFromBottom_2 newTop:" + i + " oldScorllY " + n + " bottom " + j);
        }
        paramChatXListView.setSelectionFromBottom(i + paramChatXListView.getHeaderViewsCount(), j - paramChatXListView.getPaddingBottom());
        return paramInt;
      }
      if (QLog.isColorLevel()) {
        QLog.i(paramString, 2, "hideOverScrollHeaderView newTop:" + i + " oldScorllY " + n);
      }
      paramChatXListView.hideOverScrollHeaderView();
      return i1;
      label714:
      k = i;
      m = 0;
      i = j;
      j = m;
      continue;
      label732:
      j = -1;
      break label188;
      label738:
      break label141;
      label741:
      j = i;
      break label111;
      label748:
      j = -1;
      k = i;
      m = 0;
      i = j;
      j = m;
    }
  }
  
  public static List<ChatMessage> a(List<ChatMessage> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseChatpieHelper", 2, "filterTargetUinMsgList size list == null, targetUin=" + paramString);
      }
      return localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatpieHelper", 2, "filterTargetUinMsgList size " + paramList.size() + ", targetUin=" + paramString);
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)paramList.next();
      if (paramString.equals(localChatMessage.senderuin)) {
        localArrayList.add(localChatMessage);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.w("BaseChatpieHelper", 2, "filterTargetUinMsgList targetList " + localArrayList.size() + ", targetUin=" + paramString);
    }
    return localArrayList;
  }
  
  public static void a(SessionInfo paramSessionInfo, EditText paramEditText, Button paramButton, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w("BaseChatpieHelper", 2, "exitMsgFilterMode ");
    }
    paramSessionInfo.l = false;
    paramSessionInfo.i = null;
    if (paramBoolean) {
      paramEditText.setText("");
    }
    paramButton.setText(alud.a(2131701337));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, XEditTextEx paramXEditTextEx, boolean paramBoolean)
  {
    boolean bool2 = true;
    int i = 120;
    int j = VipUtils.a(paramQQAppInterface, null);
    Object localObject;
    boolean bool1;
    if ((j & 0x4) != 0)
    {
      i = afxr.a(paramQQAppInterface, "SVIP_MaxPtt");
      if (paramXEditTextEx.getInputExtras(true).getInt("Channels") != 1)
      {
        paramQQAppInterface = QQRecorder.a();
        localObject = paramXEditTextEx.getInputExtras(true);
        if (paramBoolean) {
          break label196;
        }
        bool1 = true;
        label59:
        ((Bundle)localObject).putBoolean("DoesSupportDirectlyAudio", bool1);
        paramXEditTextEx.getInputExtras(true).putInt("Channels", 1);
        paramXEditTextEx.getInputExtras(true).putInt("SampleRate", paramQQAppInterface.jdField_a_of_type_Int);
        paramXEditTextEx.getInputExtras(true).putInt("TimeLength", i);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("sougouptt params : support = ");
          if (paramBoolean) {
            break label202;
          }
        }
      }
    }
    label196:
    label202:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      QLog.d("BaseChatpieHelper", 2, paramBoolean + "sample = " + paramQQAppInterface.jdField_a_of_type_Int + " max = " + i);
      paramXEditTextEx.a = paramQQAppInterface;
      return;
      if ((j & 0x2) == 0) {
        break;
      }
      i = afxr.a(paramQQAppInterface, "VIP_MaxPtt");
      break;
      bool1 = false;
      break label59;
    }
  }
  
  public static boolean a(Button paramButton, CharSequence paramCharSequence, int paramInt)
  {
    return false;
  }
  
  public static boolean a(SessionInfo paramSessionInfo)
  {
    return false;
  }
  
  static boolean a(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.isread) || (paramMessage.isSendFromLocal()) || (paramQQAppInterface.a(paramMessage)) || (abti.b(paramQQAppInterface, paramMessage))) {
      return false;
    }
    if (((HotChatManager)paramQQAppInterface.getManager(60)).b(paramMessage.frienduin)) {
      return false;
    }
    if (paramMessage.istroop == 7220) {
      return false;
    }
    if (1036 == paramMessage.istroop) {
      return false;
    }
    if ((paramMessage.istroop == 1008) && (alof.aR.equals(paramMessage.senderuin))) {
      return false;
    }
    if ((paramMessage.istroop == 1008) && (alof.aS.equals(paramMessage.senderuin))) {
      return false;
    }
    if (abti.d(paramMessage.senderuin)) {
      return false;
    }
    if (((paramMessage.istroop == 1001) || (paramMessage.istroop == 10002)) && (abti.d(paramMessage))) {
      return false;
    }
    if (abti.e(paramMessage)) {
      return false;
    }
    if (paramMessage.msgtype == -2058) {
      return false;
    }
    if ((paramMessage.istroop != 7220) && (TextUtils.equals(paramMessage.frienduin, alof.az))) {
      return false;
    }
    if (aoiy.a(paramMessage)) {
      return false;
    }
    if ((atlt.b(paramMessage)) || (atlt.a(paramMessage))) {
      return false;
    }
    if ((paramMessage.istroop == 0) && (FriendsStatusUtil.a(paramMessage.frienduin, paramQQAppInterface))) {
      return false;
    }
    if ((paramMessage.istroop == 0) && (TextUtils.equals(paramMessage.frienduin, alof.O))) {
      return false;
    }
    return ((paramSessionInfo == null) || (paramSessionInfo.jdField_a_of_type_Int != 10007)) && (paramMessage.istroop != 10007);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (ShortVideoUtils.a()) {}
    do
    {
      return true;
      ShortVideoUtils.a(paramQQAppInterface);
    } while (ShortVideoUtils.a());
    return false;
  }
  
  CharSequence a(Intent paramIntent, QQMessageFacade.Message paramMessage)
  {
    for (;;)
    {
      Object localObject3;
      try
      {
        if (paramMessage.msgtype == -2016)
        {
          localObject1 = paramMessage.msg.split("\\|");
          if (localObject1.length <= 0) {
            break label1068;
          }
          localObject1 = localObject1[0].trim();
          break label1062;
          localObject3 = new SpannableStringBuilder();
          localObject2 = bcmm.a(paramMessage);
          if (localObject2 != null) {
            paramMessage.nickName = ((bcmn)localObject2).c;
          }
          if (paramMessage.istroop != 10007) {
            break label395;
          }
          paramIntent = ((asmu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(358)).a(asmx.b(paramMessage));
          if ((paramIntent == null) || (TextUtils.isEmpty(paramIntent.e)))
          {
            ((SpannableStringBuilder)localObject3).append(alud.a(2131693015));
            label126:
            if (localObject1 == null) {
              break label1065;
            }
            ((SpannableStringBuilder)localObject3).append("：");
            ((SpannableStringBuilder)localObject3).append((CharSequence)localObject1);
            break label1065;
          }
        }
        else
        {
          if ((paramMessage.msgtype == -2011) || (paramMessage.msgtype == -2059))
          {
            localObject1 = azvd.a(paramMessage.msgData);
            if (localObject1 != null)
            {
              localObject1 = ((AbsStructMsg)localObject1).mMsgBrief;
              break label1075;
            }
            localObject1 = paramMessage.msg;
            break label1075;
          }
          if (paramMessage.msgtype == -2000)
          {
            if ((((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).b(paramMessage.frienduin)) || (alse.a(paramMessage)))
            {
              localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691347);
              break label1078;
            }
            localObject1 = paramMessage.getMessageText();
            break label1078;
          }
          if (paramMessage.msgtype == -7001)
          {
            localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694593);
            continue;
          }
          localObject2 = paramMessage.getMessageText();
          localObject1 = localObject2;
          if (!bcpg.b(paramMessage)) {
            continue;
          }
          if (!bcpg.d(paramMessage)) {
            bcpg.a(paramMessage);
          }
          localObject3 = bcpg.b(paramMessage);
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            continue;
          }
          localObject1 = localObject3;
          continue;
        }
        ((SpannableStringBuilder)localObject3).append(paramIntent.e);
        continue;
        if (paramMessage.nickName == null) {
          break label635;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e("BaseChatpieHelper", 1, "getMessageTipsStr error: " + paramMessage, paramIntent);
        return "";
      }
      label395:
      Object localObject2 = localObject1;
      int i;
      if (paramMessage.nickName.equals(this.jdField_a_of_type_AndroidContentContext.getString(2131694084)))
      {
        localObject1 = ((CharSequence)localObject1).toString();
        i = 0;
        label437:
        if (i >= bamd.a.length) {
          break label1092;
        }
        localObject2 = localObject1;
        if (((String)localObject1).indexOf('\024' + bamd.a[i]) == -1) {
          break label1081;
        }
        localObject2 = ((String)localObject1).replace('\024' + bamd.a[i], "\024" + (char)i);
      }
      for (;;)
      {
        localObject1 = paramIntent.getStringExtra("uinname");
        ((SpannableStringBuilder)localObject3).append(new bamb("[" + (String)localObject1 + "]", 16));
        ((SpannableStringBuilder)localObject3).append(" ");
        ((SpannableStringBuilder)localObject3).append(new bamb(paramMessage.nickName, 16));
        bhtk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramMessage, paramIntent, (SpannableStringBuilder)localObject3);
        localObject1 = localObject2;
        break label126;
        label635:
        String str = paramIntent.getStringExtra("uinname");
        bhtk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramMessage, (SpannableStringBuilder)localObject3);
        if ((str == null) || (str.length() == 0))
        {
          ((SpannableStringBuilder)localObject3).append(paramMessage.frienduin);
          break label126;
        }
        if (7000 == paramMessage.istroop)
        {
          localObject2 = paramIntent.getStringExtra("subAccountLatestNick");
          if (localObject2 != null)
          {
            paramIntent = (Intent)localObject2;
            if (((String)localObject2).length() != 0) {}
          }
          else
          {
            paramIntent = paramMessage.senderuin;
          }
          ((SpannableStringBuilder)localObject3).append(str);
          ((SpannableStringBuilder)localObject3).append(" ");
          ((SpannableStringBuilder)localObject3).append(paramIntent);
          break label126;
        }
        if ((1010 == paramMessage.istroop) || (1001 == paramMessage.istroop))
        {
          if (String.valueOf(alof.H).equals(paramMessage.frienduin))
          {
            localObject2 = bdgc.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.senderuin);
            paramIntent = (Intent)localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              paramIntent = paramMessage.senderuin;
            }
          }
          for (;;)
          {
            ((SpannableStringBuilder)localObject3).append(str);
            ((SpannableStringBuilder)localObject3).append("-");
            ((SpannableStringBuilder)localObject3).append(paramIntent);
            if (paramMessage.msgtype != -1024) {
              break;
            }
            paramIntent = String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131699159), new Object[] { paramIntent });
            break label1099;
            localObject2 = bdgc.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.frienduin);
            paramIntent = (Intent)localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              paramIntent = paramMessage.frienduin;
            }
          }
        }
        if (1024 == paramMessage.istroop)
        {
          paramIntent = ndv.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.frienduin);
          if (TextUtils.isEmpty(paramIntent))
          {
            ((SpannableStringBuilder)localObject3).append(str);
            break label126;
          }
          ((SpannableStringBuilder)localObject3).append(paramIntent);
          break label126;
        }
        if ((7220 == paramMessage.istroop) && (paramMessage.extInt == 2) && (!TextUtils.isEmpty(paramMessage.senderuin)))
        {
          paramIntent = ((alzl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).b(paramMessage.senderuin);
          if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.name)))
          {
            ((SpannableStringBuilder)localObject3).append(paramIntent.name);
            break label126;
          }
          ((SpannableStringBuilder)localObject3).append(str);
          break label126;
        }
        ((SpannableStringBuilder)localObject3).append(str);
        break label126;
        paramIntent = (Intent)localObject1;
        break label1099;
        for (;;)
        {
          label1062:
          break;
          label1065:
          return localObject3;
          label1068:
          localObject1 = "";
        }
        label1075:
        break;
        label1078:
        break;
        label1081:
        i += 1;
        localObject1 = localObject2;
        break label437;
        label1092:
        localObject2 = localObject1;
      }
      label1099:
      Object localObject1 = paramIntent;
    }
  }
  
  public void a()
  {
    aiis.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
  }
  
  void a(int paramInt1, int paramInt2, String paramString)
  {
    ThreadManager.post(new BaseChatpieHelper.1(this, paramInt2, paramInt1, paramString), 2, null, false);
  }
  
  public void a(Activity paramActivity, Intent paramIntent)
  {
    ArrayList localArrayList = (ArrayList)aupg.a().a();
    String str = atkk.a(localArrayList);
    paramIntent.putExtra("chatuin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    paramIntent.putExtra("chattype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    paramIntent.putExtra("msgs", str);
    paramActivity.setResult(-1, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("jubaoApiPlugin", 2, "select msg size = " + localArrayList.size());
    }
  }
  
  void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public void b()
  {
    aiis.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (!aiis.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  void b(Intent paramIntent)
  {
    if (paramIntent == null) {}
    int i;
    do
    {
      do
      {
        Bundle localBundle;
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("BaseChatpieHelper", 2, "uploadPreviewPhoto");
          }
          bdhj.a(-1L, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, "image_send_prepare", "ChatActivity.uploadPreviewPhoto:request=" + paramIntent.getIntExtra(bdez.h, -1));
          localBundle = paramIntent.getExtras();
        } while (localBundle == null);
        if (localBundle.getBoolean("deleteImage", false))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(true, false);
          return;
        }
        i = paramIntent.getIntExtra(bdez.h, -1);
      } while ((i != 2) && (i != 1));
      paramIntent = paramIntent.getParcelableArrayListExtra("imageInfos");
    } while ((paramIntent == null) || (paramIntent.isEmpty()));
    if (paramIntent.size() == 1)
    {
      if (i == 1)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c, 1, "");
        return;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c, 2, "");
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c, 4, "" + paramIntent.size());
  }
  
  void c(Intent paramIntent)
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.PreUploadVideoConfig.name(), "0|0|1.0|5|480000|0");
    bdif.a(String.valueOf(0), "checking", "<BDH_LOG> DPCConfig of PreUploadVideoConfig :" + (String)localObject);
    float f1 = 0.0F;
    float f3 = 0.0F;
    float f2 = 0.0F;
    long l2 = 0L;
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject == null) || (localObject.length < 5)) {}
    }
    for (;;)
    {
      int i;
      long l1;
      int i1;
      try
      {
        k = Integer.valueOf(localObject[0]).intValue();
        boolean bool3;
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        try
        {
          j = Integer.valueOf(localObject[1]).intValue();
          f2 = f3;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          for (;;)
          {
            boolean bool1;
            boolean bool2;
            int j = 0;
            i = 0;
            i1 = k;
          }
        }
        try
        {
          f1 = Float.valueOf(localObject[2]).floatValue();
          f2 = f1;
          i = Integer.valueOf(localObject[3]).intValue();
        }
        catch (NumberFormatException localNumberFormatException3)
        {
          i = 0;
          f1 = f2;
          i1 = k;
          break label612;
        }
        try
        {
          l1 = Long.valueOf(localObject[4]).longValue();
          n = k;
          m = j;
          k = i;
          f2 = f1;
          bdif.a(String.valueOf(0), "checking", "<BDH_LOG> DPCConfig PreUpEnable:" + n + " HardEncodeEnable:" + m + " Limits:" + k + " dpcDuration:" + f2 + " dpcTimeout:" + l1);
          bool3 = VideoUpConfigInfo.isPreUpload();
          bool1 = VideoUpConfigInfo.sIsHardCodeEnable;
          if ((m != 1) || (!bool1)) {
            break label668;
          }
          bool2 = true;
          bdif.a(String.valueOf(0), "checking", "<BDH_LOG> HardCodeEnable: " + bool2 + " DPC:" + m + " BDH:" + bool1);
          if (!VideoUpConfigInfo.getIsUpdated())
          {
            if (QLog.isColorLevel()) {
              QLog.d("BaseChatpieHelper", 2, "<BDH_LOG>VideoUpConfigInfo is not updated");
            }
            HwServlet.getConfig(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            VideoUpConfigInfo.setIsUpdated();
          }
          if (!bdin.h(BaseApplication.getContext())) {
            break label680;
          }
          if ((n != 1) || (!bool3)) {
            break label674;
          }
          bool1 = true;
          bdif.a(String.valueOf(0), "checking", "<BDH_LOG> Enable: " + bool1 + " DPC:" + n + " BDH:" + bool3 + " isWifi");
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008)) {
            bool1 = false;
          }
          bool3 = bool1;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0)
          {
            bool3 = bool1;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)
            {
              bool3 = bool1;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)
              {
                bool3 = bool1;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) {
                  bool3 = false;
                }
              }
            }
          }
          if ((!bool3) || (!baxl.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
            break label686;
          }
          paramIntent.putExtra("key_video_presend_enable", true);
          paramIntent.putExtra("key_video_hard_encode_enable", bool2);
          paramIntent.putExtra("key_video_presend_slice_duration", f2);
          azgp.jdField_a_of_type_Boolean = bool2;
          azgp.b = bool3;
          return;
        }
        catch (NumberFormatException localNumberFormatException4)
        {
          i1 = k;
          break label612;
        }
        localNumberFormatException1 = localNumberFormatException1;
        j = 0;
        i1 = 0;
        i = 0;
      }
      label612:
      f2 = f1;
      int k = i;
      int m = j;
      int n = i1;
      if (QLog.isColorLevel())
      {
        QLog.e("BaseChatpieHelper", 2, "<BDH_LOG>get DpcConfig Erro", localNumberFormatException1);
        l1 = l2;
        f2 = f1;
        k = i;
        m = j;
        n = i1;
        continue;
        label668:
        bool2 = false;
        continue;
        label674:
        bool1 = false;
        continue;
        label680:
        bool1 = false;
        continue;
        label686:
        paramIntent.putExtra("key_video_presend_enable", false);
        continue;
        k = 0;
        m = 0;
        n = 0;
        l1 = l2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatpieHelper
 * JD-Core Version:    0.7.0.1
 */