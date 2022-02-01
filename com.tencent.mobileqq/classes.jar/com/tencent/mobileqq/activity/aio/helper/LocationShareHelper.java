package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
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
  private LocationShareTipsBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsLocationShareTipsBar;
  private OnUpdateUserLocationListener jdField_a_of_type_ComTencentMobileqqLocationOnUpdateUserLocationListener = new LocationShareHelper.1(this);
  private IFloatMapCallback jdField_a_of_type_ComTencentMobileqqLocationCallbackIFloatMapCallback = new LocationShareHelper.2(this);
  private volatile LocationRoom.RoomKey jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey;
  
  LocationShareHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private String a(LocationRoom.RoomKey paramRoomKey, String paramString)
  {
    String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 0);
    if (paramRoomKey.a() == 0) {
      str = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString).getFriendNickWithAlias();
    }
    while (paramRoomKey.a() != 1) {
      return str;
    }
    return ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRoomKey.a(), paramString);
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilMap.clear();
  }
  
  private boolean a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareHelper", 2, "[queryLocationRoom] isSameSession: invoked. sessionType: " + paramInt + " sessionUin: " + paramString + " [mRoomKey] null ");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareHelper", 2, "[queryLocationRoom] isSameSession: invoked. sessionType: " + paramInt + " sessionUin: " + paramString + " [mRoomKey] sessionType: " + this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a() + " [mRoomKey] sessionUin: " + this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a());
    }
    return this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a(paramInt, paramString);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLocationShareTipsBar = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey = new LocationRoom.RoomKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ILocationShareService localILocationShareService = LocationShareServiceHolder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localILocationShareService.isSessionSharingLocation(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareHelper", 2, "[queryLocationRoom] requestQueryRoom: invoked. sessionUin: " + this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a());
      }
      localILocationShareService.requestUpdateShareState(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void c()
  {
    ILocationShareService localILocationShareService = LocationShareServiceHolder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey != null) && (!localILocationShareService.isSessionSharingLocation(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a(), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a())) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLocationShareTipsBar == this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a();
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
    {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (TextUtils.isEmpty(str)) {
        if (QLog.isColorLevel()) {
          QLog.d("LocationShareHelper", 2, new Object[] { "processRoamMessage: invoked. empty uin, ignored. ", " friendUin: ", str });
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      boolean bool;
      do
      {
        int i;
        Pair localPair;
        do
        {
          return;
          localPair = new Pair(Integer.valueOf(i), str);
        } while (jdField_a_of_type_JavaUtilMap.containsKey(localPair));
        bool = LocationShareServiceHolder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).isSessionSharingLocation(i, str);
        LocationMessageUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, str, bool);
        jdField_a_of_type_JavaUtilMap.put(localPair, Boolean.valueOf(true));
      } while (!QLog.isColorLevel());
      QLog.d("LocationShareHelper", 2, new Object[] { "processRoamMessage: invoked. ", "[处理漫游消息，登录后首次进该会话aio，用资料位刷新消息字段] sessionSharingLocation: ", Boolean.valueOf(bool), " friendUin: ", str });
      return;
    }
    QLog.e("LocationShareHelper", 2, new Object[] { "processRoamMessage: failed. ", "empty session. " });
  }
  
  public String getTag()
  {
    return "LocationShareHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 6, 9, 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    for (;;)
    {
      IFloatMapService localIFloatMapService;
      try
      {
        localObject1 = LocationShareServiceHolder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localIFloatMapService = LocationShareServiceHolder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        switch (paramInt)
        {
        default: 
          return;
        }
      }
      finally {}
      ((ILocationShareService)localObject1).addLocationUpdateListener(this.jdField_a_of_type_ComTencentMobileqqLocationOnUpdateUserLocationListener);
      localIFloatMapService.addFloatMapCallback(this.jdField_a_of_type_ComTencentMobileqqLocationCallbackIFloatMapCallback);
      Object localObject1 = new LocationShareHelper.3(this);
      ThreadManager.getSubThreadHandler().post((Runnable)localObject1);
      continue;
      c();
      continue;
      b();
      continue;
      localObject2.removeLocationUpdateListener(this.jdField_a_of_type_ComTencentMobileqqLocationOnUpdateUserLocationListener);
      localIFloatMapService.removeFloatMapCallback(this.jdField_a_of_type_ComTencentMobileqqLocationCallbackIFloatMapCallback);
      AutoReplyUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.LocationShareHelper
 * JD-Core Version:    0.7.0.1
 */