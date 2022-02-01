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
  private static Map<Pair<Integer, String>, Boolean> e = new ConcurrentHashMap();
  protected LocationShareTipsBar a;
  private volatile BaseChatPie b;
  private LocationShareTipsBar c;
  private volatile LocationRoom.RoomKey d;
  private OnUpdateUserLocationListener f = new LocationShareHelper.1(this);
  private IFloatMapCallback g = new LocationShareHelper.2(this);
  
  LocationShareHelper(BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie;
  }
  
  private String a(LocationRoom.RoomKey paramRoomKey, String paramString)
  {
    String str = ContactUtils.a(this.b.d, paramString, 0);
    if (paramRoomKey.a() == 0) {
      return ((FriendsManager)this.b.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(paramString).getFriendNickWithAlias();
    }
    if (paramRoomKey.a() == 1) {
      str = ContactUtils.b(this.b.d, paramRoomKey.b(), paramString);
    }
    return str;
  }
  
  public static void a()
  {
    e.clear();
  }
  
  private boolean a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder;
    if (this.d == null)
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
      localStringBuilder.append(this.d.a());
      localStringBuilder.append(" [mRoomKey] sessionUin: ");
      localStringBuilder.append(this.d.b());
      QLog.d("LocationShareHelper", 2, localStringBuilder.toString());
    }
    return this.d.a(paramInt, paramString);
  }
  
  private void b()
  {
    this.c = this.a;
    this.d = new LocationRoom.RoomKey(this.b.ah.a, this.b.ah.b);
    ILocationShareService localILocationShareService = LocationShareServiceHolder.a(this.b.d);
    if (localILocationShareService.isSessionSharingLocation(this.b.ah.a, this.b.ah.b))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[queryLocationRoom] requestQueryRoom: invoked. sessionUin: ");
        localStringBuilder.append(this.d.b());
        QLog.d("LocationShareHelper", 2, localStringBuilder.toString());
      }
      localILocationShareService.requestQueryRoom(this.b.ah.a, this.b.ah.b);
    }
  }
  
  private void c()
  {
    ILocationShareService localILocationShareService = LocationShareServiceHolder.a(this.b.d);
    if ((this.d != null) && (!localILocationShareService.isSessionSharingLocation(this.d.a(), this.d.b())) && (this.c == this.b.J().a())) {
      this.b.J().c();
    }
  }
  
  private void d()
  {
    if ((this.b != null) && (this.b.ah != null))
    {
      int i = this.b.ah.a;
      String str = this.b.ah.b;
      if (TextUtils.isEmpty(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d("LocationShareHelper", 2, new Object[] { "processRoamMessage: invoked. empty uin, ignored. ", " friendUin: ", str });
        }
        return;
      }
      Pair localPair = new Pair(Integer.valueOf(i), str);
      if (!e.containsKey(localPair))
      {
        boolean bool = LocationShareServiceHolder.a(this.b.d).isSessionSharingLocation(i, str);
        LocationMessageUtil.a(this.b.d, i, str, bool);
        e.put(localPair, Boolean.valueOf(true));
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
    if ((this.a == null) && (this.b.bx().a(25)))
    {
      this.a = new LocationShareTipsBar(this.b);
      this.b.J().b(this.a);
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
      Object localObject1 = LocationShareServiceHolder.a(this.b.d);
      IFloatMapService localIFloatMapService = LocationShareServiceHolder.b(this.b.d);
      if (paramInt != 4)
      {
        if (paramInt != 7)
        {
          if (paramInt != 10)
          {
            if (paramInt == 15)
            {
              ((ILocationShareService)localObject1).removeLocationUpdateListener(this.f);
              localIFloatMapService.removeFloatMapCallback(this.g);
              AutoReplyUtil.a(this.b.d, this.b.ae(), this.b.F());
              this.a = null;
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
        ((ILocationShareService)localObject1).addLocationUpdateListener(this.f);
        localIFloatMapService.addFloatMapCallback(this.g);
        localObject1 = new LocationShareHelper.3(this);
        ThreadManager.getSubThreadHandler().post((Runnable)localObject1);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.LocationShareHelper
 * JD-Core Version:    0.7.0.1
 */