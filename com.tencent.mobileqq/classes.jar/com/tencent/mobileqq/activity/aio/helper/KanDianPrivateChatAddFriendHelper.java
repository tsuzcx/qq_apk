package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.kandian.biz.privatechat.api.IRIJPrivateChatReport;
import com.tencent.mobileqq.kandian.biz.privatechat.api.IRIJPrivateChatReport.R5Builder;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;

public class KanDianPrivateChatAddFriendHelper
  extends AddFriendHelper
{
  public static int k = 0;
  public static int l = 1;
  private ShieldListObserver m = new KanDianPrivateChatAddFriendHelper.1(this);
  
  public KanDianPrivateChatAddFriendHelper(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public static boolean a(int paramInt, String paramString1, String paramString2, Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[tryAddFriend] clickArea = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", myUin = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", friendUin = ");
    ((StringBuilder)localObject).append(paramString2);
    QLog.i("KanDianPrivateChatAddFriendHelper", 1, ((StringBuilder)localObject).toString());
    localObject = new IRIJPrivateChatReport.R5Builder();
    ((IRIJPrivateChatReport.R5Builder)localObject).a(paramString1);
    ((IRIJPrivateChatReport.R5Builder)localObject).b(paramString2);
    paramString1 = new StringBuilder();
    paramString1.append("");
    paramString1.append(paramInt);
    ((IRIJPrivateChatReport.R5Builder)localObject).a("click_area", paramString1.toString());
    ((IRIJPrivateChatReport)QRoute.api(IRIJPrivateChatReport.class)).reportData("0X800BD0F", ((IRIJPrivateChatReport.R5Builder)localObject).a());
    if (!c(paramString2))
    {
      QLog.i("KanDianPrivateChatAddFriendHelper", 1, "[tryAddFriend] can not add.");
      new QQToastNotifier(paramContext).notifyUser(2131915218);
      return false;
    }
    return true;
  }
  
  private static boolean c(String paramString)
  {
    long l1;
    StringBuilder localStringBuilder;
    try
    {
      l1 = Long.parseLong(paramString);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isAbleToAddFriend] e = ");
      localStringBuilder.append(localNumberFormatException);
      QLog.e("KanDianPrivateChatAddFriendHelper", 1, localStringBuilder.toString());
      l1 = 0L;
    }
    if (l1 == 0L)
    {
      QLog.i("KanDianPrivateChatAddFriendHelper", 1, "[isAbleToAddFriend] false, friendUin = 0");
      return false;
    }
    Object localObject = ((IReadInJoyUserInfoModule)QRoute.api(IReadInJoyUserInfoModule.class)).getSingleKDUserInfo(l1, null);
    if (localObject != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isAbleToAddFriend] friendUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", enable = ");
      localStringBuilder.append(((ReadInJoyUserInfo)localObject).addFriendSettingEnable);
      QLog.i("KanDianPrivateChatAddFriendHelper", 1, localStringBuilder.toString());
      return ((ReadInJoyUserInfo)localObject).addFriendSettingEnable;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[isAbleToAddFriend] friendUin = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", enable = false");
    QLog.i("KanDianPrivateChatAddFriendHelper", 1, ((StringBuilder)localObject).toString());
    return false;
  }
  
  protected void a(String paramString)
  {
    IRIJPrivateChatReport.R5Builder localR5Builder = new IRIJPrivateChatReport.R5Builder();
    localR5Builder.a(this.b.getCurrentAccountUin());
    localR5Builder.b(paramString);
    localR5Builder.a("click_area", "0");
    ((IRIJPrivateChatReport)QRoute.api(IRIJPrivateChatReport.class)).reportData("0X800BD10", localR5Builder.a());
    super.a(paramString);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
  }
  
  protected void d()
  {
    IRIJPrivateChatReport.R5Builder localR5Builder = new IRIJPrivateChatReport.R5Builder();
    localR5Builder.a(this.b.getCurrentAccountUin());
    localR5Builder.b(this.e.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(k);
    localR5Builder.a("click_area", localStringBuilder.toString());
    ((IRIJPrivateChatReport)QRoute.api(IRIJPrivateChatReport.class)).reportData("0X800BD0F", localR5Builder.a());
    if (!c(this.e.b))
    {
      QLog.i("KanDianPrivateChatAddFriendHelper", 1, "[addFriend] can not add.");
      new QQToastNotifier(this.a.b()).notifyUser(2131915218);
      return;
    }
    super.d();
  }
  
  protected void f()
  {
    super.f();
  }
  
  public void g()
  {
    super.g();
  }
  
  protected boolean h()
  {
    return true;
  }
  
  public void onMoveToState(int paramInt)
  {
    super.onMoveToState(paramInt);
    if (paramInt != 4)
    {
      if (paramInt != 15) {
        return;
      }
      this.b.removeObserver(this.m);
      return;
    }
    this.b.addObserver(this.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.KanDianPrivateChatAddFriendHelper
 * JD-Core Version:    0.7.0.1
 */