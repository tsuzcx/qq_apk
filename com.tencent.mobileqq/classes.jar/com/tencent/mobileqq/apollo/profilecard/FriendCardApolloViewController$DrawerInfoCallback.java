package com.tencent.mobileqq.apollo.profilecard;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.drawer.FriendProfileBubble;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloCmQQStatusData;
import com.tencent.mobileqq.apollo.model.ApolloCmQQStatusData.From;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.callback.ISpriteDrawerInfoCallback;
import com.tencent.mobileqq.apollo.store.ApolloBoxEnterView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class FriendCardApolloViewController$DrawerInfoCallback
  implements View.OnClickListener, ISpriteDrawerInfoCallback
{
  private FriendCardApolloViewController$DrawerInfoCallback(FriendCardApolloViewController paramFriendCardApolloViewController) {}
  
  public void a()
  {
    QQAppInterface localQQAppInterface = this.a.c();
    QBaseActivity localQBaseActivity = (QBaseActivity)FriendCardApolloViewController.c(this.a).get();
    Object localObject1 = (View)FriendCardApolloViewController.d(this.a).get();
    if ((localQQAppInterface != null) && (localQBaseActivity != null))
    {
      if (localObject1 == null) {
        return;
      }
      if ((!TextUtils.isEmpty(FriendCardApolloViewController.e(this.a))) && ((this.a.b == null) || (this.a.b.getVisibility() != 0))) {
        ThreadManager.getUIHandler().post(new FriendCardApolloViewController.DrawerInfoCallback.1(this, localQBaseActivity, (View)localObject1));
      }
      Object localObject4 = FriendCardApolloViewController.f(this.a);
      Object localObject3 = null;
      if ((localObject4 != null) && (((ProfileCardInfo)localObject4).allInOne != null)) {
        localObject1 = ((ProfileCardInfo)localObject4).allInOne.uin;
      } else {
        localObject1 = null;
      }
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (localObject4 != null)
        {
          localObject2 = localObject1;
          if (((ProfileCardInfo)localObject4).card != null) {
            localObject2 = ((ProfileCardInfo)localObject4).card.uin;
          }
        }
      }
      if (FriendCardApolloViewController.a(this.a, localQQAppInterface, (String)localObject2)) {
        return;
      }
      localObject4 = (ApolloManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      localObject1 = localObject3;
      if (!FriendCardApolloViewController.g(this.a)) {
        localObject1 = ((ApolloManagerServiceImpl)localObject4).getRandomAppearAction(FriendCardApolloViewController.a(this.a), localQQAppInterface, (String)localObject2, new int[] { 4 });
      }
      int i = 5;
      if (localObject1 == null)
      {
        localObject1 = new ApolloActionData();
        ((ApolloActionData)localObject1).actionId = -1;
        ((ApolloActionData)localObject1).actionType = 0;
      }
      else
      {
        i = 12;
      }
      SpriteUtil.a(FriendCardApolloViewController.b(this.a), i, (ApolloActionData)localObject1);
      new FriendProfileBubble((String)localObject2).a(FriendCardApolloViewController.b(this.a), localQBaseActivity, localQQAppInterface, HardCodeUtil.a(2131902855));
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    ThreadManager.getUIHandler().post(new FriendCardApolloViewController.DrawerInfoCallback.2(this, paramInt1, paramInt2, paramString));
  }
  
  public void b() {}
  
  public void c()
  {
    ProfileCardInfo localProfileCardInfo = FriendCardApolloViewController.f(this.a);
    String str1;
    if ((localProfileCardInfo != null) && (localProfileCardInfo.allInOne != null)) {
      str1 = localProfileCardInfo.allInOne.uin;
    } else {
      str1 = null;
    }
    String str2 = str1;
    if (TextUtils.isEmpty(str1))
    {
      str2 = str1;
      if (localProfileCardInfo != null)
      {
        str2 = str1;
        if (localProfileCardInfo.card != null) {
          str2 = localProfileCardInfo.card.uin;
        }
      }
    }
    FriendCardApolloViewController.a(this.a, str2, "expose");
  }
  
  public void d()
  {
    if (FriendCardApolloViewController.f(this.a) == null)
    {
      QLog.e("[cmshow]FriendCardApolloViewController", 1, "profileCardInfo is null");
      return;
    }
    Object localObject = this.a;
    localObject = FriendCardApolloViewController.a((FriendCardApolloViewController)localObject, FriendCardApolloViewController.f((FriendCardApolloViewController)localObject));
    localObject = FriendCardApolloViewController.b(this.a, (String)localObject);
    if (localObject == null)
    {
      QLog.e("[cmshow]FriendCardApolloViewController", 1, "apolloCmQQStatusData is null");
      return;
    }
    int i = ((ApolloCmQQStatusData)localObject).getShowUpBubbleTime(ApolloCmQQStatusData.From.CARD);
    FriendCardApolloViewController.a(this.a, ((ApolloCmQQStatusData)localObject).apolloQQPicUrl, ((ApolloCmQQStatusData)localObject).apolloQQBubbleId, i);
  }
  
  public void onClick(View paramView)
  {
    this.a.a(1, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.profilecard.FriendCardApolloViewController.DrawerInfoCallback
 * JD-Core Version:    0.7.0.1
 */