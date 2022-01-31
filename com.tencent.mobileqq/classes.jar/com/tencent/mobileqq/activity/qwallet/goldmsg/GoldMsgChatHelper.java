package com.tencent.mobileqq.activity.qwallet.goldmsg;

import Wallet.GoldMsgGetReq;
import Wallet.GoldMsgSetReq;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.goldmsg.GoldMsgAnimatorCtr;
import com.tencent.mobileqq.activity.aio.anim.goldmsg.GoldMsgQueueView;
import com.tencent.mobileqq.activity.aio.anim.goldmsg.GoldMsgQueueView.ItemData;
import com.tencent.mobileqq.activity.aio.item.GoldMsgPttItemBuilder.GoldMsgPttHolder;
import com.tencent.mobileqq.activity.aio.item.GoldMsgTextItemBuilder.GoldMsgTextHolder;
import com.tencent.mobileqq.activity.qwallet.QWalletCommonServlet;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.activity.qwallet.widget.NumAnim;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.widget.ButtonInfo;
import com.tencent.mobileqq.nearby.widget.NearbyCustomDialog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import cooperation.qwallet.plugin.QWalletHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype18;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import xke;
import xkf;
import xkg;
import xkh;
import xki;

public class GoldMsgChatHelper
{
  public static final int a;
  public static Handler a;
  protected static GoldMsgChatHelper a;
  static HashSet jdField_a_of_type_JavaUtilHashSet = new HashSet();
  static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public static final int b;
  public static final int c;
  public static final int d;
  public static final int e;
  public static final int f;
  public static final int g;
  public static final int h;
  public static int i;
  public static int j;
  protected HashMap a;
  public BusinessObserver a;
  private boolean jdField_a_of_type_Boolean = true;
  public HashMap b;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(2131375639));
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(2131375633));
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(2131375649));
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(2131375637));
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(2131375643));
    i = Color.parseColor("#FFE6AB");
    j = Color.parseColor("#E19565");
    DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
    jdField_a_of_type_Int = (int)(14.0F * localDisplayMetrics.density + 0.5F);
    jdField_b_of_type_Int = (int)(3.0F * localDisplayMetrics.density + 0.5F);
    c = (int)(7.0F * localDisplayMetrics.density + 0.5F);
    d = (int)(10.0F * localDisplayMetrics.density + 0.5F);
    e = (int)(4.0F * localDisplayMetrics.density + 0.5F);
    f = (int)(90.0F * localDisplayMetrics.density + 0.5F);
    g = (int)(22.0F * localDisplayMetrics.density + 0.5F);
    h = (int)(localDisplayMetrics.density * 6.0F + 0.5F);
  }
  
  public GoldMsgChatHelper()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_MqqObserverBusinessObserver = new xke(this);
  }
  
  public static BaseBubbleBuilder.ViewHolder a(ListView paramListView, String paramString)
  {
    int m = paramListView.getFirstVisiblePosition();
    int n = paramListView.getLastVisiblePosition();
    int k = m;
    Object localObject;
    if (k <= n)
    {
      localObject = paramListView.getChildAt(k - m);
      if ((localObject instanceof BaseChatItemLayout))
      {
        localObject = (BaseBubbleBuilder.ViewHolder)AIOUtils.a((View)localObject);
        if ((localObject == null) || (((BaseBubbleBuilder.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (!paramString.equals(((BaseBubbleBuilder.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("goldmsg_order_id")))) {}
      }
    }
    for (paramListView = (ListView)localObject;; paramListView = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GoldMsgChatHelper", 2, "findAIOMessageByListId listId=" + paramString + ",firstPos=" + m + ",lastVisible=" + n + ",viewHolder=" + paramListView);
      }
      return paramListView;
      k += 1;
      break;
    }
  }
  
  public static GoldMsgChatHelper.GoldMsgIcon a(String paramString)
  {
    GoldMsgChatHelper.GoldMsgIcon localGoldMsgIcon = new GoldMsgChatHelper.GoldMsgIcon();
    try
    {
      paramString = QWalletSetting.a(paramString, "goldmsg_icon", "");
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      paramString = new JSONObject(paramString);
      localGoldMsgIcon.jdField_a_of_type_JavaLangString = paramString.getString("name");
      localGoldMsgIcon.jdField_a_of_type_Long = paramString.getLong("begin");
      localGoldMsgIcon.jdField_b_of_type_Long = paramString.getLong("end");
      localGoldMsgIcon.c = paramString.getString("url");
      localGoldMsgIcon.jdField_b_of_type_JavaLangString = paramString.getString("icon");
      return localGoldMsgIcon;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static GoldMsgChatHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgChatHelper != null) {
      return jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgChatHelper;
    }
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgChatHelper == null)
      {
        jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgChatHelper = new GoldMsgChatHelper();
        jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
      }
      return jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgChatHelper;
    }
  }
  
  private static String a(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString)) {}
    do
    {
      try
      {
        paramString = NumAnim.formatNumber(Double.parseDouble(paramString) / 100.0D, false);
        str1 = paramString;
      }
      catch (Exception localException1)
      {
        try
        {
          str1 = paramString + "元";
          return str1;
        }
        catch (Exception localException2)
        {
          continue;
        }
        localException1 = localException1;
        paramString = str2;
      }
    } while (!QLog.isColorLevel());
    QLog.e("GoldMsgChatHelper", 2, "formatMoneyStr Exception", localException1);
    return paramString;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GoldMsgChatHelper", 2, "onActiveAccount");
    }
    if (jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgChatHelper != null) {
      synchronized (jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgChatHelper.jdField_a_of_type_JavaUtilHashMap)
      {
        jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgChatHelper.jdField_a_of_type_JavaUtilHashMap.clear();
      }
    }
    synchronized (jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgChatHelper.jdField_b_of_type_JavaUtilHashMap)
    {
      jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgChatHelper.jdField_b_of_type_JavaUtilHashMap.clear();
      GoldMsgPayManager.a();
      GoldMsgDbManager.b();
      NotifyMsgManager.c();
      RedPacketManager.getInstance().onActiveAccount();
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, ButtonInfo paramButtonInfo, SpannableString paramSpannableString)
  {
    if (paramContext == null) {
      return;
    }
    GoldMsgDialog localGoldMsgDialog = new GoldMsgDialog(paramContext);
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(paramSpannableString);
    localTextView.setTextSize(11.0F);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    localTextView.setHighlightColor(0);
    paramSpannableString = new LinearLayout.LayoutParams(-1, -2);
    paramSpannableString.topMargin = DisplayUtil.a(paramContext, 9.0F);
    localGoldMsgDialog.a(paramButtonInfo).a(localTextView, paramSpannableString).a(paramString1).b(paramString3);
    localGoldMsgDialog.show();
    localGoldMsgDialog.a(paramString2);
  }
  
  public static void a(SessionInfo paramSessionInfo, ListView paramListView, GoldMsgAnimatorCtr paramGoldMsgAnimatorCtr, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GoldMsgChatHelper", 2, "handleGrapSelf listId=" + paramString1 + ",currAmount=" + paramLong2 + ",totalAmount=" + paramLong1 + ",isComplete=" + paramBoolean);
    }
    if ((paramInt == paramSessionInfo.jdField_a_of_type_Int) && (paramSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString2)) && (paramLong2 > 0L) && (paramLong1 > 0L) && (paramLong2 <= paramLong1)) {}
    try
    {
      jdField_a_of_type_AndroidOsHandler.postDelayed(new xki(paramInt, paramSessionInfo, paramString2, paramListView, paramString1, paramLong1, paramLong2, paramBoolean, paramGoldMsgAnimatorCtr), 500L);
      return;
    }
    catch (Exception paramSessionInfo)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("GoldMsgChatHelper", 2, "handleGrapSelf start animation fail!");
    }
  }
  
  public static void a(SessionInfo paramSessionInfo, ListView paramListView, String paramString1, String paramString2, int paramInt, List paramList, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GoldMsgChatHelper", 2, "handleGrapNotify listId=" + paramString1 + ",uins=" + paramList + ",isComplete=" + paramBoolean);
    }
    if ((TextUtils.isEmpty(paramString1)) || (paramInt != paramSessionInfo.jdField_a_of_type_Int) || (!paramSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString2))) {}
    do
    {
      return;
      paramSessionInfo = a(paramListView, paramString1);
    } while ((paramSessionInfo == null) || (paramSessionInfo.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null));
    boolean bool = paramSessionInfo.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend();
    if (paramBoolean)
    {
      if (bool) {
        b(paramSessionInfo, 2, 0L, 0L, paramBoolean);
      }
    }
    else
    {
      label127:
      if ((!bool) || (paramList == null) || (paramList.size() <= 0)) {
        break label342;
      }
      if ((!(paramSessionInfo instanceof GoldMsgTextItemBuilder.GoldMsgTextHolder)) && (!(paramSessionInfo instanceof GoldMsgPttItemBuilder.GoldMsgPttHolder))) {
        break label344;
      }
    }
    label342:
    label344:
    for (paramSessionInfo = (LinearLayout)paramSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.findViewById(2131362401);; paramSessionInfo = (LinearLayout)paramSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.findViewById(2131362403))
    {
      paramListView = QWalletTools.a();
      if ((paramListView == null) || (paramSessionInfo == null)) {
        break;
      }
      paramString2 = (TextView)paramSessionInfo.findViewById(2131362405);
      if (paramString2 != null) {
        paramString2.setVisibility(8);
      }
      paramSessionInfo = (GoldMsgQueueView)paramSessionInfo.findViewById(2131362404);
      if (QLog.isColorLevel()) {
        QLog.d("GoldMsgChatHelper", 2, "handleGrapNotify listId=" + paramString1 + ",faceQueueView=" + paramSessionInfo);
      }
      if (paramSessionInfo == null) {
        break;
      }
      paramSessionInfo.setVisibility(0);
      paramString1 = new ArrayList();
      paramString2 = paramList.iterator();
      while (paramString2.hasNext())
      {
        paramList = (String)paramString2.next();
        paramString1.add(new GoldMsgQueueView.ItemData(FaceDrawable.a(paramListView, 1, paramList), paramList));
      }
      b(paramSessionInfo, 1, 0L, 0L, paramBoolean);
      break label127;
      break;
    }
    paramSessionInfo.a(paramString1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TextView paramTextView1, GoldMsgQueueView paramGoldMsgQueueView, TextView paramTextView2, MessageRecord paramMessageRecord)
  {
    if ((paramTextView1 == null) || (paramGoldMsgQueueView == null) || (paramTextView2 == null) || (paramMessageRecord == null) || (paramQQAppInterface == null)) {
      return;
    }
    Resources localResources = paramTextView1.getContext().getResources();
    paramTextView1.setAlpha(1.0F);
    paramTextView2.setVisibility(8);
    paramGoldMsgQueueView.setVisibility(8);
    paramGoldMsgQueueView.a(null, 0);
    Object localObject1 = localResources.getDrawable(2130844170);
    if ((paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 3000))
    {
      paramTextView1.setText(a(paramMessageRecord.getExtInfoFromExtStr("goldmsg_current_amount")));
      ((Drawable)localObject1).setBounds(0, 0, jdField_a_of_type_Int, jdField_a_of_type_Int);
      paramTextView1.setCompoundDrawables((Drawable)localObject1, null, null, null);
      return;
    }
    boolean bool2 = CustomizeStrategyFactory.a().a();
    Object localObject3 = GoldMsgDbManager.a(paramMessageRecord);
    boolean bool1 = false;
    Object localObject2 = null;
    int n = 0;
    int k = 0;
    int m = 0;
    label195:
    Object localObject4;
    if (localObject3 != null)
    {
      localObject2 = ((GoldMsgDBHelper.GoldMsgNotifyRecord)localObject3).jdField_a_of_type_JavaUtilArrayList;
      if (((GoldMsgDBHelper.GoldMsgNotifyRecord)localObject3).jdField_a_of_type_Int == 1)
      {
        bool1 = true;
        n = ((GoldMsgDBHelper.GoldMsgNotifyRecord)localObject3).d;
        if (((GoldMsgDBHelper.GoldMsgNotifyRecord)localObject3).jdField_b_of_type_Int != 1) {
          break label383;
        }
        k = 1;
        m = ((GoldMsgDBHelper.GoldMsgNotifyRecord)localObject3).c;
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder().append("handleGoldMsgView isComplete=").append(bool1).append(",grapUserCount=").append(n).append(",grapUserList=");
      if (localObject2 != null) {
        break label389;
      }
    }
    label389:
    for (localObject3 = "empty";; localObject3 = Integer.valueOf(((List)localObject2).size()))
    {
      QLog.d("GoldMsgChatHelper", 2, localObject3);
      if (!paramMessageRecord.isSend()) {
        break label503;
      }
      localObject4 = null;
      localObject3 = localObject4;
      if (localObject2 == null) {
        break label404;
      }
      localObject3 = localObject4;
      if (((List)localObject2).size() <= 0) {
        break label404;
      }
      if (!bool2) {
        break label481;
      }
      localObject3 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (String)((Iterator)localObject2).next();
        ((List)localObject3).add(new GoldMsgQueueView.ItemData(FaceDrawable.a(paramQQAppInterface, 1, (String)localObject4), (String)localObject4));
      }
      bool1 = false;
      break;
      label383:
      k = 0;
      break label195;
    }
    label404:
    if (localObject3 != null)
    {
      paramGoldMsgQueueView.setVisibility(0);
      paramGoldMsgQueueView.a((List)localObject3, n);
      label422:
      paramGoldMsgQueueView = a(paramMessageRecord.getExtInfoFromExtStr("goldmsg_current_amount"));
      if (!bool1) {
        break label564;
      }
    }
    label564:
    for (paramQQAppInterface = localResources.getDrawable(2130844176);; paramQQAppInterface = (QQAppInterface)localObject1)
    {
      localObject1 = paramQQAppInterface;
      paramQQAppInterface = paramGoldMsgQueueView;
      for (;;)
      {
        paramTextView1.setText(paramQQAppInterface);
        ((Drawable)localObject1).setBounds(0, 0, jdField_a_of_type_Int, jdField_a_of_type_Int);
        paramTextView1.setCompoundDrawables((Drawable)localObject1, null, null, null);
        return;
        label481:
        CustomizeStrategyFactory.a().b(true);
        localObject3 = localObject4;
        break;
        paramTextView2.setVisibility(0);
        break label422;
        label503:
        if (k != 0)
        {
          paramQQAppInterface = "已领取" + a(String.valueOf(m));
        }
        else if (bool1)
        {
          paramQQAppInterface = "句有料已领完";
          paramTextView1.setAlpha(0.5F);
        }
        else
        {
          paramQQAppInterface = "收到句有料";
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramQQAppInterface == null) || (paramMessageRecord == null)) {}
    int k;
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
      k = QWalletSetting.a(paramQQAppInterface, "goldmsg_first_receive_count", 0);
    } while ((k >= 3) || (!QWalletSetting.a(paramQQAppInterface, "goldmsg_is_first_receive_from_" + paramMessageRecord.frienduin, true)));
    QWalletSetting.a(paramQQAppInterface, "goldmsg_is_first_receive_from_" + paramMessageRecord.frienduin, false);
    QWalletSetting.a(paramQQAppInterface, "goldmsg_first_receive_count", k + 1);
    a(paramMessageRecord, 1);
  }
  
  public static void a(MessageRecord paramMessageRecord, int paramInt)
  {
    Bundle localBundle = null;
    int k = 0;
    if (paramMessageRecord == null) {
      return;
    }
    String str;
    if (paramInt == 1)
    {
      str = BaseApplicationImpl.getApplication().getResources().getString(2131432314);
      paramInt = 8;
      k = str.length();
      localBundle = new Bundle();
      localBundle.putInt("key_action", 1);
      localBundle.putString("key_action_DATA", "https://mqq.tenpay.com/mqq/action/moneytalk/intro.html?_wv=1");
    }
    for (;;)
    {
      a(paramMessageRecord, str, paramInt, k, localBundle, -5020);
      return;
      if (paramInt == 2)
      {
        str = BaseApplicationImpl.getApplication().getResources().getString(2131432315);
        paramInt = 15;
        k = str.length();
        localBundle = new Bundle();
        localBundle.putInt("key_action", 22);
      }
      else
      {
        paramInt = 0;
        str = null;
      }
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, String paramString, int paramInt1, int paramInt2, Bundle paramBundle, int paramInt3)
  {
    if ((paramMessageRecord == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    ThreadManager.post(new xkh(paramMessageRecord, paramString, paramInt3, paramInt1, paramInt2, paramBundle), 10, null, false);
  }
  
  public static void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    ThreadManager.post(new xkg(paramMessageRecord, paramBoolean), 10, null, false);
  }
  
  public static void a(im_msg_body.Elem paramElem, MessageRecord paramMessageRecord)
  {
    if ((paramElem == null) || (paramMessageRecord == null)) {}
    for (;;)
    {
      return;
      try
      {
        if (18 == paramElem.common_elem.uint32_service_type.get())
        {
          hummer_commelem.MsgElemInfo_servtype18 localMsgElemInfo_servtype18 = new hummer_commelem.MsgElemInfo_servtype18();
          localMsgElemInfo_servtype18.mergeFrom(paramElem.common_elem.bytes_pb_elem.get().toByteArray());
          if ((localMsgElemInfo_servtype18.uint64_current_amount.has()) && (localMsgElemInfo_servtype18.uint64_total_amount.has()) && (localMsgElemInfo_servtype18.bytes_listid.has()))
          {
            paramMessageRecord.extLong |= 0x1;
            paramMessageRecord.saveExtInfoToExtStr("goldmsg_tag", "1");
            paramMessageRecord.saveExtInfoToExtStr("goldmsg_current_amount", String.valueOf(localMsgElemInfo_servtype18.uint64_current_amount.get()));
            paramMessageRecord.saveExtInfoToExtStr("goldmsg_total_amount", String.valueOf(localMsgElemInfo_servtype18.uint64_total_amount.get()));
            paramMessageRecord.saveExtInfoToExtStr("goldmsg_order_id", localMsgElemInfo_servtype18.bytes_listid.get().toStringUtf8());
            if (localMsgElemInfo_servtype18.bytes_auth_key.has()) {
              paramMessageRecord.saveExtInfoToExtStr("goldmsg_auth_key", localMsgElemInfo_servtype18.bytes_auth_key.get().toStringUtf8());
            }
            if (localMsgElemInfo_servtype18.uint32_number.has())
            {
              paramMessageRecord.saveExtInfoToExtStr("goldmsg_rec_count", String.valueOf(localMsgElemInfo_servtype18.uint32_number.get()));
              return;
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramElem)
      {
        paramElem.printStackTrace();
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3000);
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    if (!a(paramInt2)) {}
    while ((paramInt1 != -2000) && (paramInt1 != -2007) && (paramInt1 != -1000) && (paramInt1 != -2022) && (paramInt1 != -2002)) {
      return false;
    }
    return true;
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    if ((paramString == null) || (jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgChatHelper == null) || (!a(paramInt))) {
      return false;
    }
    paramString = paramInt + "_" + paramString;
    return jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgChatHelper.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
  }
  
  public static boolean a(Intent paramIntent, int paramInt)
  {
    if (paramIntent == null) {}
    int k;
    do
    {
      return false;
      k = paramIntent.getIntExtra("forward_type", -1);
    } while (((k != -1) && (k != 1) && (k != 9) && (k != 3) && (k != 21)) || (!a(paramInt)));
    return true;
  }
  
  public static boolean a(SessionInfo paramSessionInfo)
  {
    return a(paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public static boolean a(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver, boolean paramBoolean)
  {
    if ((jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgChatHelper == null) || (paramMessageRecord == null)) {
      if ((paramMessageRecord != null) && (c(paramMessageRecord))) {
        b(paramMessageRecord);
      }
    }
    label124:
    label127:
    for (;;)
    {
      return false;
      if (!c(paramMessageRecord))
      {
        if ((!paramBoolean) || (!jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgChatHelper.a(paramMessageRecord))) {
          continue;
        }
        String str = paramMessageRecord.getExtInfoFromExtStr("goldmsg_status");
        if (str == null) {
          continue;
        }
        if ((!str.equals("0")) && (!str.equals("2"))) {
          break label124;
        }
      }
      for (int k = 1;; k = 0)
      {
        if (k == 0) {
          break label127;
        }
        GoldMsgPayManager.a().a(paramMessageRecord, paramMessageObserver, paramBoolean);
        return true;
        if (jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgChatHelper.a(paramMessageRecord.istroop, paramMessageRecord.frienduin) != null) {
          break;
        }
        b(paramMessageRecord);
        return false;
      }
    }
  }
  
  private static void b(BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramViewHolder == null) {}
    label34:
    label226:
    label230:
    for (;;)
    {
      return;
      if (((paramViewHolder instanceof GoldMsgTextItemBuilder.GoldMsgTextHolder)) || ((paramViewHolder instanceof GoldMsgPttItemBuilder.GoldMsgPttHolder)))
      {
        localObject = (LinearLayout)paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.findViewById(2131362401);
        if (localObject == null) {
          break label226;
        }
      }
      for (Object localObject = (TextView)((LinearLayout)localObject).findViewById(2131362400);; localObject = null)
      {
        if (localObject == null) {
          break label230;
        }
        ((TextView)localObject).setAlpha(1.0F);
        if (1 == paramInt)
        {
          if ((paramLong1 > 0L) && (paramLong2 > 0L))
          {
            ((TextView)localObject).setText("已领取" + a(String.valueOf(paramLong2)));
            return;
            localObject = (LinearLayout)paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.findViewById(2131362403);
            break label34;
          }
          if (paramBoolean)
          {
            paramViewHolder = GoldMsgDbManager.a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
            if ((paramViewHolder != null) && (paramViewHolder.jdField_b_of_type_Int == 1)) {
              break;
            }
            ((TextView)localObject).setText("句有料已领完");
            ((TextView)localObject).setAlpha(0.5F);
            return;
          }
          ((TextView)localObject).setText("收到句有料");
          return;
        }
        if ((2 != paramInt) || (!paramBoolean)) {
          break;
        }
        paramViewHolder = ((TextView)localObject).getResources().getDrawable(2130844176);
        paramViewHolder.setBounds(0, 0, jdField_a_of_type_Int, jdField_a_of_type_Int);
        ((TextView)localObject).setCompoundDrawables(paramViewHolder, null, null, null);
        return;
      }
    }
  }
  
  public static void b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    paramMessageRecord.removeExtInfoToExtStr("goldmsg_tag");
    paramMessageRecord.removeExtInfoToExtStr("goldmsg_current_amount");
    paramMessageRecord.removeExtInfoToExtStr("goldmsg_status");
    paramMessageRecord.removeExtInfoToExtStr("goldmsg_type");
    paramMessageRecord.removeExtInfoToExtStr("goldmsg_time");
    paramMessageRecord.removeExtInfoToExtStr("goldmsg_order_id");
    paramMessageRecord.removeExtInfoToExtStr("goldmsg_pic_md5");
    paramMessageRecord.removeExtInfoToExtStr("goldmsg_md5_tag");
    a(paramMessageRecord, true);
  }
  
  public static void b(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = QWalletTools.a();
    if ((localQQAppInterface != null) && (paramMessageRecord != null))
    {
      localQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, "extStr", paramMessageRecord.extStr);
      if (paramBoolean)
      {
        localQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, paramMessageRecord.msgData);
        localQQAppInterface.a().a(999, true, paramMessageRecord.frienduin);
        localQQAppInterface.a().a(paramMessageRecord);
      }
    }
  }
  
  public static boolean b(int paramInt)
  {
    return jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramInt));
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    if ((paramMessageRecord.msgtype == -2002) && ((paramMessageRecord instanceof MessageForPtt)) && (((MessageForPtt)paramMessageRecord).voiceRedPacketFlag != 0)) {
      return false;
    }
    return a(paramMessageRecord.msgtype, paramMessageRecord.istroop);
  }
  
  public static boolean c(MessageRecord paramMessageRecord)
  {
    if (b(paramMessageRecord)) {
      return "1".equals(paramMessageRecord.getExtInfoFromExtStr("goldmsg_tag"));
    }
    return false;
  }
  
  public GoldMsgChatHelper.GoldMsgChatState a(int paramInt, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!a(paramInt))) {
      return null;
    }
    paramString = paramInt + "_" + paramString;
    return (GoldMsgChatHelper.GoldMsgChatState)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public GoldMsgChatHelper.GoldMsgChatState a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return null;
    }
    return a(paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public MessageRecord a(List paramList, String paramString)
  {
    if ((paramList == null) || (QWalletSetting.a(paramString, "GoldMsgAnim", 1) != 1) || (DeviceInfoUtil.j() <= 480L))
    {
      paramString = null;
      return paramString;
    }
    int k = paramList.size();
    if (k > 0)
    {
      k -= 1;
      for (;;)
      {
        if (k <= 0) {
          break label95;
        }
        MessageRecord localMessageRecord = (MessageRecord)paramList.get(k);
        if ((!localMessageRecord.isread) && (!localMessageRecord.isSendFromLocal()))
        {
          paramString = localMessageRecord;
          if (c(localMessageRecord)) {
            break;
          }
        }
        k -= 1;
      }
    }
    label95:
    return null;
  }
  
  public String a(int paramInt, String paramString)
  {
    int k = 1;
    String str1;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramInt == 0)
      {
        String str2 = QWalletSetting.a("", "GoldMsgRecordPre", "");
        str1 = str2;
        if (!TextUtils.isEmpty(str2)) {
          str1 = str2 + paramString;
        }
        return str1;
      }
      if ((paramInt == 1) || (paramInt == 3000))
      {
        str1 = QWalletSetting.a("", "GoldMsgGroupRecordPre", "");
        if (TextUtils.isEmpty(str1)) {
          break label155;
        }
        if (paramInt == 1) {
          paramInt = k;
        }
      }
    }
    for (;;)
    {
      return str1 + "&type=" + paramInt + "&group_uin=" + paramString;
      if (paramInt == 3000)
      {
        paramInt = 2;
        continue;
        return null;
      }
      else
      {
        paramInt = -1;
      }
    }
    label155:
    return str1;
  }
  
  public String a(ChatMessage paramChatMessage, int paramInt, String paramString)
  {
    int k = 1;
    if (paramChatMessage == null) {
      return null;
    }
    String str1 = paramChatMessage.getExtInfoFromExtStr("goldmsg_order_id");
    paramChatMessage = paramChatMessage.getExtInfoFromExtStr("goldmsg_auth_key");
    String str2;
    if (!TextUtils.isEmpty(str1))
    {
      str2 = QWalletSetting.a("", "GoldMsgRecordDetail", "");
      if (!TextUtils.isEmpty(str2)) {
        if (paramInt == 1) {
          paramInt = k;
        }
      }
    }
    for (;;)
    {
      return str2 + "&listid=" + str1 + "&type=" + paramInt + "&authkey=" + paramChatMessage + "&group_uin=" + paramString;
      if (paramInt == 3000)
      {
        paramInt = 2;
        continue;
        return null;
      }
      else
      {
        paramInt = -1;
      }
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("url", "https://mqq.tenpay.com/mqq/moneytalk/index.shtml?_wv=2097155");
    paramContext.startActivity(localIntent);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || ((paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 3000))) {}
    for (;;)
    {
      return;
      QQAppInterface localQQAppInterface = QWalletTools.a();
      if (localQQAppInterface != null)
      {
        String str1 = localQQAppInterface.c();
        String str2 = paramMessageRecord.senderuin;
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!str1.equals(str2)))
        {
          str2 = paramMessageRecord.getExtInfoFromExtStr("goldmsg_order_id");
          String str3 = paramMessageRecord.getExtInfoFromExtStr("goldmsg_auth_key");
          String str4 = paramMessageRecord.getExtInfoFromExtStr("goldmsg_grap_times");
          GoldMsgDBHelper.GoldMsgNotifyRecord localGoldMsgNotifyRecord = GoldMsgDbManager.a(paramMessageRecord);
          boolean bool1 = false;
          boolean bool2 = false;
          if (localGoldMsgNotifyRecord != null)
          {
            if (localGoldMsgNotifyRecord.jdField_a_of_type_Int != 1) {
              break label281;
            }
            bool1 = true;
            label127:
            if (localGoldMsgNotifyRecord.jdField_b_of_type_Int != 1) {
              break label287;
            }
          }
          label281:
          label287:
          for (bool2 = true;; bool2 = false)
          {
            if (QLog.isColorLevel()) {
              QLog.d("GoldMsgChatHelper", 2, "grapGroupGoldMsg listId=" + str2 + ",authKey=" + str3 + ",strGrapTimes=" + str4 + ",isFinish=" + bool1 + ",isGrap=" + bool2 + ",goldMsgRecord=" + localGoldMsgNotifyRecord);
            }
            if ((bool2) || (bool1) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3))) {
              break;
            }
            if (!this.jdField_b_of_type_JavaUtilHashMap.containsKey(str2)) {
              break label293;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("GoldMsgChatHelper", 2, "grapGroupGoldMsg is grapping");
            return;
            bool1 = false;
            break label127;
          }
          label293:
          int m = 0;
          int k = m;
          try
          {
            if (!TextUtils.isEmpty(str4)) {
              k = Integer.valueOf(str4).intValue();
            }
            if (k < 3) {
              if (!QWalletSetting.a(localQQAppInterface.getCurrentAccountUin(), "goldmsg_has_right", true))
              {
                long l1 = NetConnInfoCenter.getServerTime();
                long l2 = QWalletSetting.a(localQQAppInterface.getCurrentAccountUin(), "goldmsg_no_right_start_time", 0L);
                long l3 = QWalletSetting.a(localQQAppInterface.getCurrentAccountUin(), "goldmsg_no_right_interval", 0L);
                if ((l1 > l2) && (l1 - l2 < l3))
                {
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("GoldMsgChatHelper", 2, "grapGroupGoldMsg no right,  startTime=" + l2 + ",interval:" + l3);
                  return;
                }
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
              k = m;
            }
            this.jdField_b_of_type_JavaUtilHashMap.put(str2, Long.valueOf(paramMessageRecord.uniseq));
            ThreadManager.post(new xkf(this, paramMessageRecord, str1, str2, str3), 10, null, false);
          }
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    QWalletSetting.a(paramString, "goldmsg_config_tips", false);
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("GoldMsgChatHelper", 2, "goldMsg = " + paramString2);
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        Object localObject = new JSONObject(paramString2);
        int k = ((JSONObject)localObject).optInt("entry", 0);
        paramString2 = ((JSONObject)localObject).optString("group_discuss_pop_url", "");
        String str = ((JSONObject)localObject).optString("panel_ad");
        int m = ((JSONObject)localObject).optInt("gold_msg_limit_entry", 0);
        localObject = QWalletSetting.a(paramString1);
        if ((!TextUtils.isEmpty(paramString2)) && (!paramString2.equals(localObject)))
        {
          QWalletSetting.a(paramString1, paramString2);
          QWalletSetting.a(paramString1, true);
        }
        QWalletSetting.a(paramString1, k);
        QWalletSetting.a(paramString1, "goldmsg_recv_goldonly_", m);
        QWalletSetting.a(paramString1, "goldmsg_icon", str);
        return;
      }
    }
    catch (Exception paramString2)
    {
      paramString2.printStackTrace();
      QWalletSetting.a(paramString1, 0);
    }
  }
  
  public void a(String paramString1, String paramString2, BusinessObserver paramBusinessObserver)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    TicketManager localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
    if (localTicketManager != null) {}
    for (paramString2 = localTicketManager.getSkey(paramString2);; paramString2 = "")
    {
      QWalletCommonServlet.a(new GoldMsgGetReq(3, Long.parseLong(paramString1), paramString2), paramBusinessObserver);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong)
  {
    if (paramBoolean) {}
    for (int k = 1;; k = 0)
    {
      String str = "";
      TicketManager localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
      if (localTicketManager != null) {
        str = localTicketManager.getSkey(paramString1);
      }
      QWalletCommonServlet.a(new GoldMsgSetReq(Long.parseLong(paramString2), k, paramLong, str), null);
      if (QLog.isColorLevel()) {
        QLog.i("GoldMsgChatHelper", 2, "sendRequest:setGoldOnlyStat. goldMsgSwitch:" + k + ",price:" + paramLong);
      }
      return;
    }
  }
  
  /* Error */
  public boolean a(Context paramContext, int paramInt, String paramString1, String paramString2, android.widget.EditText paramEditText1, android.widget.EditText paramEditText2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 12
    //   6: iconst_0
    //   7: istore 11
    //   9: iconst_0
    //   10: istore 9
    //   12: aconst_null
    //   13: astore 18
    //   15: iload 9
    //   17: istore 8
    //   19: aload 18
    //   21: astore 17
    //   23: aload 5
    //   25: ifnull +50 -> 75
    //   28: iload 9
    //   30: istore 8
    //   32: aload 18
    //   34: astore 17
    //   36: aload 6
    //   38: ifnull +37 -> 75
    //   41: aload 5
    //   43: invokevirtual 1055	android/widget/EditText:getEditableText	()Landroid/text/Editable;
    //   46: invokevirtual 1056	java/lang/Object:toString	()Ljava/lang/String;
    //   49: astore 5
    //   51: aload 5
    //   53: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifeq +43 -> 99
    //   59: aload_1
    //   60: invokevirtual 74	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   63: ldc_w 1057
    //   66: invokevirtual 615	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   69: astore 17
    //   71: iload 9
    //   73: istore 8
    //   75: iload 8
    //   77: ifne +19 -> 96
    //   80: aload 17
    //   82: ifnull +14 -> 96
    //   85: aload_1
    //   86: aload 17
    //   88: iconst_0
    //   89: invokestatic 1062	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   92: invokevirtual 1065	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   95: pop
    //   96: iload 8
    //   98: ireturn
    //   99: aload 6
    //   101: invokevirtual 1055	android/widget/EditText:getEditableText	()Landroid/text/Editable;
    //   104: invokevirtual 1056	java/lang/Object:toString	()Ljava/lang/String;
    //   107: astore 6
    //   109: aload 6
    //   111: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   114: ifeq +22 -> 136
    //   117: aload_1
    //   118: invokevirtual 74	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   121: ldc_w 1066
    //   124: invokevirtual 615	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   127: astore 17
    //   129: iload 9
    //   131: istore 8
    //   133: goto -58 -> 75
    //   136: iload 12
    //   138: istore 9
    //   140: aload 5
    //   142: invokestatic 1069	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   145: invokevirtual 1073	java/lang/Double:doubleValue	()D
    //   148: ldc2_w 286
    //   151: dmul
    //   152: invokestatic 1079	java/lang/Math:round	(D)J
    //   155: invokestatic 962	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   158: invokevirtual 1082	java/lang/Long:longValue	()J
    //   161: lstore 13
    //   163: aload 6
    //   165: invokestatic 936	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   168: invokevirtual 939	java/lang/Integer:intValue	()I
    //   171: istore 7
    //   173: aload_3
    //   174: ldc_w 1084
    //   177: ldc2_w 1085
    //   180: invokestatic 951	com/tencent/mobileqq/activity/qwallet/QWalletSetting:a	(Ljava/lang/String;Ljava/lang/String;J)J
    //   183: lstore 15
    //   185: iload 7
    //   187: i2l
    //   188: lconst_1
    //   189: lcmp
    //   190: ifge +47 -> 237
    //   193: aload_1
    //   194: invokevirtual 74	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   197: ldc_w 1087
    //   200: iconst_1
    //   201: anewarray 4	java/lang/Object
    //   204: dup
    //   205: iconst_0
    //   206: new 178	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   213: ldc 214
    //   215: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: lconst_1
    //   219: invokevirtual 401	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   222: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: aastore
    //   226: invokevirtual 1090	android/content/res/Resources:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   229: astore_3
    //   230: iload 11
    //   232: istore 8
    //   234: goto +166 -> 400
    //   237: lload 13
    //   239: iload 7
    //   241: i2l
    //   242: lcmp
    //   243: ifge +21 -> 264
    //   246: aload_1
    //   247: invokevirtual 74	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   250: ldc_w 1091
    //   253: invokevirtual 615	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   256: astore_3
    //   257: iload 11
    //   259: istore 8
    //   261: goto +139 -> 400
    //   264: lload 13
    //   266: iload 7
    //   268: i2l
    //   269: lload 15
    //   271: lmul
    //   272: lcmp
    //   273: ifle +42 -> 315
    //   276: aload_1
    //   277: invokevirtual 74	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   280: ldc_w 1092
    //   283: invokevirtual 615	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   286: iconst_1
    //   287: anewarray 4	java/lang/Object
    //   290: dup
    //   291: iconst_0
    //   292: lload 15
    //   294: l2d
    //   295: ldc2_w 286
    //   298: ddiv
    //   299: iconst_0
    //   300: invokestatic 293	com/tencent/mobileqq/activity/qwallet/widget/NumAnim:formatNumber	(DZ)Ljava/lang/String;
    //   303: aastore
    //   304: invokestatic 1096	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   307: astore_3
    //   308: iload 11
    //   310: istore 8
    //   312: goto +88 -> 400
    //   315: aload_0
    //   316: iload_2
    //   317: aload 4
    //   319: invokevirtual 792	com/tencent/mobileqq/activity/qwallet/goldmsg/GoldMsgChatHelper:a	(ILjava/lang/String;)Lcom/tencent/mobileqq/activity/qwallet/goldmsg/GoldMsgChatHelper$GoldMsgChatState;
    //   322: astore 5
    //   324: aload 5
    //   326: ifnull +16 -> 342
    //   329: aload 5
    //   331: aload_3
    //   332: aload 4
    //   334: iload_2
    //   335: lload 13
    //   337: iload 7
    //   339: invokevirtual 1099	com/tencent/mobileqq/activity/qwallet/goldmsg/GoldMsgChatHelper$GoldMsgChatState:a	(Ljava/lang/String;Ljava/lang/String;IJI)V
    //   342: aconst_null
    //   343: astore_3
    //   344: iconst_1
    //   345: istore 8
    //   347: goto +53 -> 400
    //   350: astore_3
    //   351: iload 10
    //   353: istore 8
    //   355: iload 8
    //   357: istore 9
    //   359: aload_1
    //   360: invokevirtual 74	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   363: ldc_w 1100
    //   366: invokevirtual 615	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   369: astore_3
    //   370: goto +30 -> 400
    //   373: astore_3
    //   374: aload_1
    //   375: invokevirtual 74	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   378: ldc_w 1101
    //   381: invokevirtual 615	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   384: astore 17
    //   386: iload 9
    //   388: istore 8
    //   390: goto -315 -> 75
    //   393: astore_3
    //   394: iconst_1
    //   395: istore 8
    //   397: goto -42 -> 355
    //   400: aload_3
    //   401: astore 17
    //   403: goto -328 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	this	GoldMsgChatHelper
    //   0	406	1	paramContext	Context
    //   0	406	2	paramInt	int
    //   0	406	3	paramString1	String
    //   0	406	4	paramString2	String
    //   0	406	5	paramEditText1	android.widget.EditText
    //   0	406	6	paramEditText2	android.widget.EditText
    //   171	167	7	k	int
    //   17	379	8	bool1	boolean
    //   10	377	9	bool2	boolean
    //   1	351	10	bool3	boolean
    //   7	302	11	bool4	boolean
    //   4	133	12	bool5	boolean
    //   161	175	13	l1	long
    //   183	110	15	l2	long
    //   21	381	17	localObject1	Object
    //   13	20	18	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   163	185	350	java/lang/NumberFormatException
    //   193	230	350	java/lang/NumberFormatException
    //   246	257	350	java/lang/NumberFormatException
    //   276	308	350	java/lang/NumberFormatException
    //   140	163	373	java/lang/NumberFormatException
    //   359	370	373	java/lang/NumberFormatException
    //   315	324	393	java/lang/NumberFormatException
    //   329	342	393	java/lang/NumberFormatException
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if (!b(paramMessageRecord)) {}
    GoldMsgChatHelper.GoldMsgChatState localGoldMsgChatState;
    do
    {
      do
      {
        return false;
      } while ((((paramMessageRecord instanceof MessageForText)) && (((MessageForText)paramMessageRecord).mPasswdRedBagFlag != 0)) || (c(paramMessageRecord)));
      localGoldMsgChatState = a(paramMessageRecord.istroop, paramMessageRecord.frienduin);
    } while (localGoldMsgChatState == null);
    paramMessageRecord.extLong |= 0x1;
    paramMessageRecord.saveExtInfoToExtStr("goldmsg_tag", "1");
    paramMessageRecord.saveExtInfoToExtStr("goldmsg_current_amount", String.valueOf(localGoldMsgChatState.jdField_b_of_type_Long));
    paramMessageRecord.saveExtInfoToExtStr("goldmsg_status", "0");
    int k;
    if (paramMessageRecord.msgtype == -1000) {
      k = 0;
    }
    for (;;)
    {
      paramMessageRecord.saveExtInfoToExtStr("goldmsg_type", String.valueOf(k));
      paramMessageRecord.saveExtInfoToExtStr("goldmsg_time", String.valueOf(paramMessageRecord.time));
      if ((paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 1)) {
        paramMessageRecord.saveExtInfoToExtStr("goldmsg_rec_count", String.valueOf(localGoldMsgChatState.c));
      }
      return true;
      if (paramMessageRecord.msgtype == -2000) {
        k = 2;
      } else if (paramMessageRecord.msgtype == -2002) {
        k = 3;
      } else if ((paramMessageRecord.msgtype == -2009) || (paramMessageRecord.msgtype == -2022)) {
        k = 4;
      } else if (paramMessageRecord.msgtype == -2007) {
        k = 1;
      } else {
        k = 0;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    return (QWalletSetting.a(paramString, "GoldMsgAnim", 1) == 1) && (DeviceInfoUtil.j() > 480L);
  }
  
  public boolean a(String paramString, SessionInfo paramSessionInfo)
  {
    if ((paramSessionInfo == null) || (!a(paramSessionInfo.jdField_a_of_type_Int))) {
      return false;
    }
    String str = paramSessionInfo.jdField_a_of_type_Int + "_" + paramSessionInfo.jdField_a_of_type_JavaLangString;
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {}
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))
      {
        paramString = new GoldMsgChatHelper.GoldMsgChatState(paramString, paramSessionInfo);
        this.jdField_a_of_type_JavaUtilHashMap.put(str, paramString);
      }
      paramString = QWalletTools.a();
      if (paramString != null) {
        QWalletHelper.preloadQWallet(paramString, 1000, "goldmsg");
      }
      return true;
    }
  }
  
  public void b(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    paramContext.startActivity(localIntent);
  }
  
  public void b(String paramString)
  {
    QWalletSetting.a(paramString, "goldmsg_value_tips", false);
  }
  
  public boolean b(SessionInfo arg1)
  {
    if ((??? == null) || (!a(???.jdField_a_of_type_Int))) {
      return false;
    }
    String str = ???.jdField_a_of_type_Int + "_" + ???.jdField_a_of_type_JavaLangString;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
        this.jdField_a_of_type_JavaUtilHashMap.remove(str);
      }
      return true;
    }
  }
  
  public boolean b(String paramString)
  {
    return QWalletSetting.a(paramString, "goldmsg_config_tips", true);
  }
  
  public boolean c(String paramString)
  {
    return QWalletSetting.a(paramString, "goldmsg_value_tips", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper
 * JD-Core Version:    0.7.0.1
 */