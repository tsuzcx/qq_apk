package com.tencent.mobileqq.apollo;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.drawer.FriendProfileBubble;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.callback.ISpriteDrawerInfoCallback;
import com.tencent.mobileqq.apollo.store.ApolloBoxEnterView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class FriendCardApolloViewController$DrawerInfoCallback
  implements View.OnClickListener, ISpriteDrawerInfoCallback
{
  private FriendCardApolloViewController$DrawerInfoCallback(FriendCardApolloViewController paramFriendCardApolloViewController) {}
  
  public void a()
  {
    Object localObject3 = null;
    QQAppInterface localQQAppInterface = this.a.a();
    FriendProfileCardActivity localFriendProfileCardActivity = (FriendProfileCardActivity)FriendCardApolloViewController.a(this.a).get();
    Object localObject1 = (View)FriendCardApolloViewController.b(this.a).get();
    if ((localQQAppInterface == null) || (localFriendProfileCardActivity == null) || (localObject1 == null)) {
      return;
    }
    if ((!TextUtils.isEmpty(FriendCardApolloViewController.a(this.a))) && ((this.a.a == null) || (this.a.a.getVisibility() != 0))) {
      ThreadManager.getUIHandler().post(new FriendCardApolloViewController.DrawerInfoCallback.1(this, localFriendProfileCardActivity, (View)localObject1));
    }
    Object localObject2 = localFriendProfileCardActivity.a;
    if ((localObject2 != null) && (((ProfileCardInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)) {}
    for (localObject1 = ((ProfileCardInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a;; localObject1 = null)
    {
      if ((TextUtils.isEmpty((CharSequence)localObject1)) && (localObject2 != null) && (((ProfileCardInfo)localObject2).jdField_a_of_type_ComTencentMobileqqDataCard != null)) {}
      for (localObject2 = ((ProfileCardInfo)localObject2).jdField_a_of_type_ComTencentMobileqqDataCard.uin;; localObject2 = localObject1)
      {
        ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
        localObject1 = localObject3;
        if (!FriendCardApolloViewController.a(this.a)) {
          localObject1 = localApolloManagerServiceImpl.getRandomAppearAction(localQQAppInterface, (String)localObject2, new int[] { 4 });
        }
        int i = 5;
        if (localObject1 == null)
        {
          localObject1 = new ApolloActionData();
          ((ApolloActionData)localObject1).actionId = -1;
          ((ApolloActionData)localObject1).actionType = 0;
        }
        for (;;)
        {
          SpriteUtil.a(FriendCardApolloViewController.a(this.a), i, (ApolloActionData)localObject1);
          new FriendProfileBubble((String)localObject2).a(FriendCardApolloViewController.a(this.a), localFriendProfileCardActivity, localQQAppInterface, HardCodeUtil.a(2131704888));
          return;
          i = 12;
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    ThreadManager.getUIHandler().post(new FriendCardApolloViewController.DrawerInfoCallback.2(this, paramInt1, paramInt2, paramString));
  }
  
  public void b() {}
  
  public void c()
  {
    ProfileCardInfo localProfileCardInfo = ((FriendProfileCardActivity)FriendCardApolloViewController.a(this.a).get()).a;
    if ((localProfileCardInfo != null) && (localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)) {}
    for (String str1 = localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a;; str1 = null)
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
      {
        str2 = str1;
        if (localProfileCardInfo != null)
        {
          str2 = str1;
          if (localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
            str2 = localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
          }
        }
      }
      FriendCardApolloViewController.a(this.a, str2, "expose");
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    this.a.a(1, 0, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.FriendCardApolloViewController.DrawerInfoCallback
 * JD-Core Version:    0.7.0.1
 */