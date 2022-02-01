import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.widget.MiniAppProfileCardGuestView;
import com.tencent.mobileqq.mini.widget.MiniAppProfileCardView;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class aywn
  extends ayrs
  implements View.OnClickListener
{
  public aywn(aysx paramaysx, aymg paramaymg)
  {
    super(paramaysx, paramaymg);
  }
  
  private void a(MiniAppProfileCardGuestView paramMiniAppProfileCardGuestView)
  {
    Object localObject = ((aymg)this.b).jdField_a_of_type_Aymn.a.get("commonItemContentColor");
    if (localObject != null)
    {
      if (!(localObject instanceof ColorStateList)) {
        break label39;
      }
      paramMiniAppProfileCardGuestView.setTextColor((ColorStateList)localObject);
    }
    label39:
    do
    {
      do
      {
        return;
      } while (!(localObject instanceof String));
      localObject = (String)localObject;
    } while (!((String)localObject).startsWith("#"));
    paramMiniAppProfileCardGuestView.setTextColor(Color.parseColor((String)localObject));
  }
  
  private void a(MiniAppProfileCardView paramMiniAppProfileCardView)
  {
    Object localObject = ((aymg)this.b).jdField_a_of_type_Aymn.a.get("commonItemContentColor");
    if (localObject != null)
    {
      if (!(localObject instanceof ColorStateList)) {
        break label39;
      }
      paramMiniAppProfileCardView.setTextColor((ColorStateList)localObject);
    }
    label39:
    do
    {
      do
      {
        return;
      } while (!(localObject instanceof String));
      localObject = (String)localObject;
    } while (!((String)localObject).startsWith("#"));
    paramMiniAppProfileCardView.setTextColor(Color.parseColor((String)localObject));
  }
  
  private boolean a(Card paramCard)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    Object localObject2 = (aymg)this.b;
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramCard == null) {
      bool2 = bool1;
    }
    boolean bool5;
    Object localObject1;
    int i;
    label75:
    do
    {
      do
      {
        return bool2;
        bool5 = paramCard.uin.equals(((QQAppInterface)localObject3).getCurrentAccountUin());
        localObject1 = (View)this.jdField_a_of_type_JavaLangObject;
        ThemeUtil.isInNightMode((AppRuntime)localObject3);
        if (((aymg)localObject2).jdField_a_of_type_Aymn == null) {
          break;
        }
        i = 1;
        if (!paramCard.isShowMiniPlaying) {
          break label673;
        }
        if (localObject1 != null) {
          break label391;
        }
        localObject1 = new ProfileContentTitleView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        if (!bool5) {
          break label262;
        }
        bool2 = bool1;
      } while (paramCard.miniAppInfoArrayList == null);
      bool2 = bool1;
    } while (paramCard.miniAppInfoArrayList.size() <= 0);
    ((ProfileContentTitleView)localObject1).setTitle(QzoneConfig.getInstance().getConfig("QZoneSetting", "ProfileCardMiniPlayingName", "最近在玩"));
    bool1 = bool3;
    if (paramCard.miniAppInfoArrayList.size() > 1) {
      bool1 = true;
    }
    ((ProfileContentTitleView)localObject1).setArrowEnable(bool1);
    localObject2 = new MiniAppProfileCardView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    ((MiniAppProfileCardView)localObject2).setData(paramCard.miniAppInfoArrayList);
    ((ProfileContentTitleView)localObject1).setVisibility(8);
    ((ProfileContentTitleView)localObject1).a((View)localObject2);
    if (i != 0) {
      a((MiniAppProfileCardView)localObject2);
    }
    label219:
    this.jdField_a_of_type_JavaLangObject = localObject1;
    MiniAppUtils.reportProfileCardExposed(paramCard, bool5);
    paramCard = (Card)localObject1;
    bool1 = true;
    for (;;)
    {
      bool2 = bool1;
      if (!(paramCard instanceof ProfileContentTitleView)) {
        break;
      }
      a((ProfileContentTitleView)paramCard, true);
      return bool1;
      i = 0;
      break label75;
      label262:
      bool2 = bool1;
      if (paramCard.appPlayingInfos == null) {
        break;
      }
      bool2 = bool1;
      if (paramCard.appPlayingInfos.size() <= 0) {
        break;
      }
      ((ProfileContentTitleView)localObject1).setTitle(QzoneConfig.getInstance().getConfig("QZoneSetting", "ProfileCardMiniPlayingNameGuestDefault", "一起在玩"));
      bool1 = bool4;
      if (paramCard.appPlayingInfos.size() > 1) {
        bool1 = true;
      }
      ((ProfileContentTitleView)localObject1).setArrowEnable(bool1);
      localObject2 = new MiniAppProfileCardGuestView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ((MiniAppProfileCardGuestView)localObject2).setData(paramCard.appPlayingInfos, paramCard.guestJumpUrl, paramCard.uin);
      ((ProfileContentTitleView)localObject1).setVisibility(8);
      ((ProfileContentTitleView)localObject1).a((View)localObject2);
      if (i == 0) {
        break label219;
      }
      a((MiniAppProfileCardGuestView)localObject2);
      break label219;
      label391:
      if (bool5)
      {
        if ((localObject1 instanceof ProfileContentTitleView))
        {
          localObject2 = (ProfileContentTitleView)localObject1;
          if (paramCard.miniAppInfoArrayList.size() > 1) {}
          for (bool1 = true;; bool1 = false)
          {
            ((ProfileContentTitleView)localObject2).setArrowEnable(bool1);
            localObject3 = (MiniAppProfileCardView)((ProfileContentTitleView)localObject2).a();
            ((MiniAppProfileCardView)localObject3).setData(paramCard.miniAppInfoArrayList);
            if (i != 0) {
              a((MiniAppProfileCardView)localObject3);
            }
            if (paramCard.miniAppInfoArrayList.size() > 1)
            {
              paramCard = ((ProfileContentTitleView)localObject2).b;
              paramCard.setTag(new aykg(96, Boolean.valueOf(true)));
              paramCard.setOnClickListener(this);
            }
            paramCard = (Card)localObject1;
            bool1 = bool2;
            break;
          }
        }
      }
      else if ((localObject1 instanceof ProfileContentTitleView))
      {
        localObject2 = (ProfileContentTitleView)localObject1;
        ((ProfileContentTitleView)localObject2).setTitle(paramCard.guestAppTotal + QzoneConfig.getInstance().getConfig("QZoneSetting", "ProfileCardMiniPlayingNameGuest", "个一起在玩的小游戏"));
        if (paramCard.guestAppTotal > 1) {}
        for (bool1 = true;; bool1 = false)
        {
          ((ProfileContentTitleView)localObject2).setArrowEnable(bool1);
          localObject3 = (MiniAppProfileCardGuestView)((ProfileContentTitleView)localObject2).a();
          ((MiniAppProfileCardGuestView)localObject3).setData(paramCard.appPlayingInfos, paramCard.guestJumpUrl, paramCard.uin);
          if (i != 0) {
            a((MiniAppProfileCardGuestView)localObject3);
          }
          if (paramCard.guestAppTotal > 1)
          {
            paramCard = ((ProfileContentTitleView)localObject2).b;
            paramCard.setTag(new aykg(96, Boolean.valueOf(false)));
            paramCard.setOnClickListener(this);
          }
          paramCard = (Card)localObject1;
          bool1 = bool2;
          break;
        }
        label673:
        if (localObject1 != null)
        {
          this.jdField_a_of_type_JavaLangObject = null;
          paramCard = (Card)localObject1;
          bool1 = true;
          continue;
        }
      }
      paramCard = (Card)localObject1;
      bool1 = bool2;
    }
  }
  
  public int a()
  {
    return 1014;
  }
  
  public String a()
  {
    return "ProfileMiniAppPlayingComponent";
  }
  
  public void a(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.a(paramBaseActivity, paramBundle);
  }
  
  public boolean a(aymg paramaymg)
  {
    boolean bool = super.a(paramaymg);
    return a(((aymg)this.b).jdField_a_of_type_ComTencentMobileqqDataCard) | bool;
  }
  
  public String a_()
  {
    return "map_key_mini_playing";
  }
  
  public void onClick(View paramView)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.scene = 2062;
    boolean bool = ((Boolean)((aykg)paramView.getTag()).jdField_a_of_type_JavaLangObject).booleanValue();
    MiniAppUtils.reportProfileCardClick(((aymg)this.b).jdField_a_of_type_ComTencentMobileqqDataCard, bool);
    Context localContext = paramView.getContext();
    if (bool) {}
    for (String str = ((aymg)this.b).jdField_a_of_type_ComTencentMobileqqDataCard.tabJumpUrl;; str = ((aymg)this.b).jdField_a_of_type_ComTencentMobileqqDataCard.guestJumpUrl)
    {
      MiniAppController.startAppByLink(localContext, str, 2, localLaunchParam, null);
      aytl.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (aymg)this.b);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywn
 * JD-Core Version:    0.7.0.1
 */