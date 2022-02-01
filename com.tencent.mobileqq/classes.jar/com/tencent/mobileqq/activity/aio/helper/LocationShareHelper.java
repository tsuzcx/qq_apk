package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.tips.LocationShareTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.chat.autoreply.AutoReplyUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.location.LocationMessageUtil;
import com.tencent.mobileqq.location.LocationShareServiceHolder;
import com.tencent.mobileqq.location.OnUpdateUserLocationListener;
import com.tencent.mobileqq.location.api.IFloatMapService;
import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.mobileqq.location.callback.IFloatMapCallback;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class LocationShareHelper
  implements ILifeCycleHelper
{
  private static Map<Pair<Integer, String>, Boolean> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private volatile BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  protected LocationShareTipsBar a;
  private OnUpdateUserLocationListener jdField_a_of_type_ComTencentMobileqqLocationOnUpdateUserLocationListener = new LocationShareHelper.1(this);
  private IFloatMapCallback jdField_a_of_type_ComTencentMobileqqLocationCallbackIFloatMapCallback = new LocationShareHelper.2(this);
  private volatile LocationRoom.RoomKey jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey;
  private LocationShareTipsBar b;
  
  LocationShareHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private String a(LocationRoom.RoomKey paramRoomKey, String paramString)
  {
    String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 0);
    if (paramRoomKey.a() == 0) {
      return ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString).getFriendNickWithAlias();
    }
    if (paramRoomKey.a() == 1) {
      str = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRoomKey.a(), paramString);
    }
    return str;
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilMap.clear();
  }
  
  private boolean a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey == null)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[queryLocationRoom] isSameSession: invoked. sessionType: ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" sessionUin: ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" [mRoomKey] null ");
        QLog.d("LocationShareHelper", 2, localStringBuilder.toString());
      }
      return false;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[queryLocationRoom] isSameSession: invoked. sessionType: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" sessionUin: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" [mRoomKey] sessionType: ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a());
      localStringBuilder.append(" [mRoomKey] sessionUin: ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a());
      QLog.d("LocationShareHelper", 2, localStringBuilder.toString());
    }
    return this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a(paramInt, paramString);
  }
  
  private void b()
  {
    this.b = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLocationShareTipsBar;
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey = new LocationRoom.RoomKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ILocationShareService localILocationShareService = LocationShareServiceHolder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localILocationShareService.isSessionSharingLocation(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[queryLocationRoom] requestQueryRoom: invoked. sessionUin: ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a());
        QLog.d("LocationShareHelper", 2, localStringBuilder.toString());
      }
      localILocationShareService.requestQueryRoom(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void c()
  {
    ILocationShareService localILocationShareService = LocationShareServiceHolder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey != null) && (!localILocationShareService.isSessionSharingLocation(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a(), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a())) && (this.b == this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a();
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (TextUtils.isEmpty(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d("LocationShareHelper", 2, new Object[] { "processRoamMessage: invoked. empty uin, ignored. ", " friendUin: ", str });
        }
        return;
      }
      Pair localPair = new Pair(Integer.valueOf(i), str);
      if (!jdField_a_of_type_JavaUtilMap.containsKey(localPair))
      {
        boolean bool = LocationShareServiceHolder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).isSessionSharingLocation(i, str);
        LocationMessageUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, str, bool);
        jdField_a_of_type_JavaUtilMap.put(localPair, Boolean.valueOf(true));
        if (QLog.isColorLevel()) {
          QLog.d("LocationShareHelper", 2, new Object[] { "processRoamMessage: invoked. ", "[处理漫游消息，登录后首次进该会话aio，用资料位刷新消息字段] sessionSharingLocation: ", Boolean.valueOf(bool), " friendUin: ", str });
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("LocationShareHelper", 2, new Object[] { "processRoamMessage: failed. ", "empty session. " });
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLocationShareTipsBar == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b().a(25)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLocationShareTipsBar = new LocationShareTipsBar(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLocationShareTipsBar);
    }
  }
  
  public String getTag()
  {
    return "LocationShareHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 7, 10, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    try
    {
      Object localObject1 = LocationShareServiceHolder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      IFloatMapService localIFloatMapService = LocationShareServiceHolder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramInt != 4)
      {
        if (paramInt != 7)
        {
          if (paramInt != 10)
          {
            if (paramInt == 15)
            {
              ((ILocationShareService)localObject1).removeLocationUpdateListener(this.jdField_a_of_type_ComTencentMobileqqLocationOnUpdateUserLocationListener);
              localIFloatMapService.removeFloatMapCallback(this.jdField_a_of_type_ComTencentMobileqqLocationCallbackIFloatMapCallback);
              AutoReplyUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b());
              this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLocationShareTipsBar = null;
            }
          }
          else
          {
            e();
            b();
          }
        }
        else {
          c();
        }
      }
      else
      {
        ((ILocationShareService)localObject1).addLocationUpdateListener(this.jdField_a_of_type_ComTencentMobileqqLocationOnUpdateUserLocationListener);
        localIFloatMapService.addFloatMapCallback(this.jdField_a_of_type_ComTencentMobileqqLocationCallbackIFloatMapCallback);
        localObject1 = new LocationShareHelper.3(this);
        ThreadManager.getSubThreadHandler().post((Runnable)localObject1);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.LocationShareHelper
 * JD-Core Version:    0.7.0.1
 */