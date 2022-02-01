package com.tencent.mobileqq.activity.contact.newfriend.poke;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.avgame.gameroom.AVGameLottieHelper.LottieDrawableLoadedListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgItemBuilder.SystemMsgItemHolder;
import com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.MoreSysMsgHolder;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.qav.thread.ThreadManager;
import java.util.ArrayList;
import tencent.im.s2c.frdsysmsg.FrdSysMsg.AddtionInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class NewFriendNotifyPokeMsgHelper
{
  public static ArrayList<Long> a = new ArrayList();
  public static ArrayList<Long> b = new ArrayList();
  public static ArrayList<Long> c = new ArrayList();
  public static ArrayList<Long> d = new ArrayList();
  
  public static long a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendNotifyPokeMsgHelper", 0, "getPokeExpiredTime() isDebugVersion = false");
    }
    return 604800L;
  }
  
  public static String a(structmsg.StructMsg paramStructMsg)
  {
    int i = 0;
    if (paramStructMsg != null) {
      i = paramStructMsg.msg.req_uin_gender.get();
    }
    if (i == 1) {
      return BaseApplicationImpl.getApplication().getResources().getString(2131719326);
    }
    return BaseApplicationImpl.getApplication().getResources().getString(2131693168);
  }
  
  public static void a()
  {
    a.clear();
    b.clear();
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, Object paramObject)
  {
    long l = FriendSystemMsgController.a().b();
    structmsg.StructMsg localStructMsg = FriendSystemMsgController.a().a(Long.valueOf(l));
    if (localStructMsg != null)
    {
      l = localStructMsg.req_uin.get();
      if (!a(localStructMsg)) {
        break label138;
      }
      if (!(paramObject instanceof NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)) {
        break label109;
      }
      ReportController.b(null, "dc00898", "", "", "0X800B759", "0X800B759", 0, 0, String.valueOf(2), "", "", "");
    }
    for (;;)
    {
      a(localStructMsg, FriendSystemMsgController.a().a(), paramQQAppInterface);
      b(paramObject, paramQQAppInterface);
      a(paramQQAppInterface, paramContext, String.valueOf(l));
      a(paramQQAppInterface, String.valueOf(l));
      return;
      label109:
      ReportController.b(null, "dc00898", "", "", "0X800B759", "0X800B759", 0, 0, String.valueOf(1), "", "", "");
    }
    label138:
    if ((paramObject instanceof NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)) {
      ReportController.b(null, "dc00898", "", "", "0X800B75B", "0X800B75B", 0, 0, String.valueOf(2), "", "", "");
    }
    for (;;)
    {
      a(paramContext, String.valueOf(l), localStructMsg.msg.action_uin_nick.get());
      return;
      ReportController.b(null, "dc00898", "", "", "0X800B75B", "0X800B75B", 0, 0, String.valueOf(1), "", "", "");
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, ChatActivity.class);
    localIntent.putExtra("uin", String.valueOf(paramString1));
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("uintype", 0);
    localIntent.putExtras(new Bundle());
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, AVGameLottieHelper.LottieDrawableLoadedListener paramLottieDrawableLoadedListener)
  {
    try
    {
      LottieComposition.Factory.fromAssetFileName(paramContext, paramString1, new NewFriendNotifyPokeMsgHelper.3(paramInt1, paramContext, paramInt2, paramInt3, paramString2, paramLottieDrawableLoadedListener));
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("NewFriendNotifyPokeMsgHelper", 1, "fromAssetFileName fail", paramContext);
      ThreadManager.a().post(new NewFriendNotifyPokeMsgHelper.4(paramLottieDrawableLoadedListener));
    }
  }
  
  private static void a(View paramView)
  {
    paramView.setPivotX(0.5F * paramView.getWidth());
    paramView.setPivotY(1.0F * paramView.getHeight());
    paramView = ObjectAnimator.ofFloat(paramView, View.ROTATION, new float[] { 0.0F, -10, 0.0F, 10, 0.0F, -10, 0.0F, 10, 0.0F });
    paramView.setDuration(720L);
    paramView.setRepeatCount(1);
    paramView.start();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.a = String.valueOf(paramString);
    localSessionInfo.b = localSessionInfo.a;
    ChatActivityFacade.b(paramQQAppInterface, paramContext, localSessionInfo);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ((NewFriendNotifyPokeHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.NEW_FRIEND_NOTIFY_POKE_HANDLER)).a(paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, structmsg.StructMsg paramStructMsg, View paramView1, View paramView2, ImageView paramImageView, TextView paramTextView, int paramInt)
  {
    boolean bool;
    int i;
    if (a(paramStructMsg, paramQQAppInterface))
    {
      bool = a(paramStructMsg);
      paramView1.setVisibility(8);
      paramView2.setVisibility(8);
      paramImageView.setVisibility(0);
      if (!bool) {
        break label127;
      }
      i = 2130846466;
      paramImageView.setImageResource(i);
      if (!a(paramStructMsg)) {
        break label135;
      }
      paramQQAppInterface = paramTextView.getContext().getString(2131699277);
      label68:
      paramImageView.setContentDescription(paramQQAppInterface);
      paramTextView.setVisibility(0);
      paramQQAppInterface = a(paramStructMsg);
      if (!a(paramStructMsg)) {
        break label150;
      }
    }
    label135:
    label150:
    for (paramQQAppInterface = paramTextView.getContext().getString(2131699281, new Object[] { paramQQAppInterface });; paramQQAppInterface = paramTextView.getContext().getString(2131699280, new Object[] { paramQQAppInterface, paramQQAppInterface }))
    {
      paramTextView.setText(paramQQAppInterface);
      a(paramStructMsg, bool, paramInt);
      return;
      label127:
      i = 2130846465;
      break;
      paramQQAppInterface = paramTextView.getContext().getString(2131699276);
      break label68;
    }
  }
  
  public static void a(Object paramObject, QQAppInterface paramQQAppInterface)
  {
    if (paramObject == null) {
      QLog.d("NewFriendNotifyPokeMsgHelper", 1, "showPockAndMsg () holder is null");
    }
    do
    {
      return;
      if ((paramObject instanceof NewFriendMoreSysMsgAdapter.MoreSysMsgHolder))
      {
        paramObject = (NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)paramObject;
        a(paramQQAppInterface, paramObject.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, paramObject.e, paramObject.jdField_a_of_type_AndroidWidgetButton, paramObject.b, paramObject.d, 2);
        return;
      }
    } while (!(paramObject instanceof SystemMsgItemBuilder.SystemMsgItemHolder));
    paramObject = (SystemMsgItemBuilder.SystemMsgItemHolder)paramObject;
    a(paramQQAppInterface, paramObject.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, paramObject.k, paramObject.jdField_a_of_type_AndroidWidgetButton, paramObject.g, paramObject.j, 1);
  }
  
  public static void a(structmsg.StructMsg paramStructMsg, long paramLong, QQAppInterface paramQQAppInterface)
  {
    FrdSysMsg.AddtionInfo localAddtionInfo = new FrdSysMsg.AddtionInfo();
    localAddtionInfo.uint32_poke.set(0);
    localAddtionInfo.uint32_format.set(1);
    paramStructMsg.msg.bytes_addtion.set(ByteStringMicro.copyFrom(localAddtionInfo.toByteArray()));
    ThreadManager.a(new NewFriendNotifyPokeMsgHelper.1(paramLong, paramStructMsg, paramQQAppInterface));
  }
  
  public static void a(structmsg.StructMsg paramStructMsg, boolean paramBoolean, int paramInt)
  {
    if (paramStructMsg == null) {}
    label107:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (paramInt)
            {
            default: 
              QLog.e("NewFriendNotifyPokeMsgHelper", 1, "reportExposure error: no this display scenes");
              return;
            case 1: 
              if (!paramBoolean) {
                break label107;
              }
            }
          } while (a.contains(Long.valueOf(paramStructMsg.msg_seq.get())));
          ReportController.b(null, "dc00898", "", "", "0X800B758", "0X800B758", 0, 0, String.valueOf(1), "", "", "");
          a.add(Long.valueOf(paramStructMsg.msg_seq.get()));
          return;
        } while (b.contains(Long.valueOf(paramStructMsg.msg_seq.get())));
        ReportController.b(null, "dc00898", "", "", "0X800B75A", "0X800B75A", 0, 0, String.valueOf(1), "", "", "");
        b.add(Long.valueOf(paramStructMsg.msg_seq.get()));
        return;
        if (!paramBoolean) {
          break;
        }
      } while (c.contains(Long.valueOf(paramStructMsg.msg_seq.get())));
      ReportController.b(null, "dc00898", "", "", "0X800B758", "0X800B758", 0, 0, String.valueOf(2), "", "", "");
      c.add(Long.valueOf(paramStructMsg.msg_seq.get()));
      return;
    } while (d.contains(Long.valueOf(paramStructMsg.msg_seq.get())));
    ReportController.b(null, "dc00898", "", "", "0X800B75A", "0X800B75A", 0, 0, String.valueOf(2), "", "", "");
    d.add(Long.valueOf(paramStructMsg.msg_seq.get()));
  }
  
  public static boolean a(structmsg.StructMsg paramStructMsg)
  {
    FrdSysMsg.AddtionInfo localAddtionInfo = new FrdSysMsg.AddtionInfo();
    try
    {
      localAddtionInfo.mergeFrom(paramStructMsg.msg.bytes_addtion.get().toByteArray());
      int i = localAddtionInfo.uint32_poke.get();
      boolean bool = b(paramStructMsg);
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendNotifyPokeMsgHelper", 0, "isShowingPoke () addtionInfo.poke = " + i + " isPokeExpired is " + bool);
      }
      return (i > 0) && (!bool);
    }
    catch (InvalidProtocolBufferMicroException paramStructMsg)
    {
      paramStructMsg.printStackTrace();
      QLog.d("NewFriendNotifyPokeMsgHelper", 1, "isShowingPoke () exp " + paramStructMsg);
    }
    return false;
  }
  
  public static boolean a(structmsg.StructMsg paramStructMsg, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    long l;
    do
    {
      return false;
      l = paramStructMsg.req_uin.get();
    } while (!((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(String.valueOf(l)));
    paramQQAppInterface = new FrdSysMsg.AddtionInfo();
    try
    {
      paramQQAppInterface.mergeFrom(paramStructMsg.msg.bytes_addtion.get().toByteArray());
      int i = paramQQAppInterface.uint32_poke.get();
      int j = paramQQAppInterface.uint32_format.get();
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendNotifyPokeMsgHelper", 0, "needShowPokeAndMsgEntrance () addtionInfo.poke = " + i + " format = " + j);
      }
      if (j > 0) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      return false;
    }
    catch (InvalidProtocolBufferMicroException paramStructMsg)
    {
      paramStructMsg.printStackTrace();
      QLog.d("NewFriendNotifyPokeMsgHelper", 1, "needShowPokeAndMsgEntrance () exp " + paramStructMsg);
    }
  }
  
  public static void b()
  {
    c.clear();
    d.clear();
  }
  
  private static void b(Object paramObject, QQAppInterface paramQQAppInterface)
  {
    ImageView localImageView;
    if ((paramObject instanceof NewFriendMoreSysMsgAdapter.MoreSysMsgHolder))
    {
      localObject = (NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)paramObject;
      localImageView = ((NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)localObject).b;
    }
    for (Object localObject = ((NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)localObject).jdField_a_of_type_AndroidWidgetImageView;; localObject = ((SystemMsgItemBuilder.SystemMsgItemHolder)localObject).f)
    {
      a(localImageView.getContext(), "poke/click_poke.json", "poke/images/", 45, 45, 0, new NewFriendNotifyPokeMsgHelper.2((ImageView)localObject, paramObject, paramQQAppInterface, localImageView));
      a((View)localObject);
      do
      {
        return;
      } while (!(paramObject instanceof SystemMsgItemBuilder.SystemMsgItemHolder));
      localObject = (SystemMsgItemBuilder.SystemMsgItemHolder)paramObject;
      localImageView = ((SystemMsgItemBuilder.SystemMsgItemHolder)localObject).g;
    }
  }
  
  public static boolean b(structmsg.StructMsg paramStructMsg)
  {
    if (paramStructMsg == null) {}
    while ((!paramStructMsg.msg_time.has()) || (paramStructMsg.msg_time.get() <= 0L) || (NetConnInfoCenter.getServerTime() - paramStructMsg.msg_time.get() <= a())) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.poke.NewFriendNotifyPokeMsgHelper
 * JD-Core Version:    0.7.0.1
 */