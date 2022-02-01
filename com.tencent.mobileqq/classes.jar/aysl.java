import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.LightingColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.forward.ForwardShareCardOption;
import com.tencent.mobileqq.profilecard.base.view.ProfileBaseView;
import com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.PullToZoomHeaderListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.troop.TroopBaseProxyActivity;
import cooperation.troop.TroopMemberCardProxyActivity;
import java.util.List;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

public class aysl
  extends ayrr<FrameLayout>
  implements View.OnClickListener, AbsListView.OnScrollListener
{
  public int a;
  protected Intent a;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private StateListDrawable jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aysn(this);
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new aysm(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aycd jdField_a_of_type_Aycd = new ayso(this);
  private aysa jdField_a_of_type_Aysa;
  private bhht jdField_a_of_type_Bhht;
  private bjng jdField_a_of_type_Bjng;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private PullToZoomHeaderListView jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  protected String a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private AlphaAnimation jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  
  public aysl(aysx paramaysx, aymg paramaymg)
  {
    super(paramaysx, paramaymg);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentIntent = new Intent();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private Drawable a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable == null) {}
    try
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
      Object localObject2 = BitmapFactory.decodeResource((Resources)localObject1, 2130850030);
      Bitmap localBitmap = BitmapFactory.decodeResource((Resources)localObject1, 2130850034);
      localObject2 = new NinePatchDrawable((Resources)localObject1, (Bitmap)localObject2, ((Bitmap)localObject2).getNinePatchChunk(), new Rect(), null);
      localObject1 = new NinePatchDrawable((Resources)localObject1, localBitmap, localBitmap.getNinePatchChunk(), new Rect(), null);
      this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable = new StateListDrawable();
      this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject1);
      this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable.addState(new int[0], (Drawable)localObject2);
      return this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ProfileTitleContainer", 1, "getBackDrawable fail.", localException);
      }
    }
  }
  
  private View a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      return null;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    FrameLayout localFrameLayout = new FrameLayout(paramView.getContext());
    localFrameLayout.setLayoutParams(paramView.getLayoutParams());
    localFrameLayout.setPadding(AIOUtils.dp2px(paramInt1, (Resources)localObject), AIOUtils.dp2px(paramInt2, (Resources)localObject), AIOUtils.dp2px(paramInt3, (Resources)localObject), AIOUtils.dp2px(paramInt4, (Resources)localObject));
    localObject = (ViewGroup)paramView.getParent();
    paramInt1 = ((ViewGroup)localObject).indexOfChild(paramView);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    ((ViewGroup)localObject).removeView(paramView);
    localFrameLayout.addView(paramView, localLayoutParams);
    ((ViewGroup)localObject).addView(localFrameLayout, paramInt1);
    return localFrameLayout;
  }
  
  private aysu a(boolean paramBoolean, aymg paramaymg)
  {
    boolean bool = true;
    aysu localaysu = new aysu(null);
    localaysu.jdField_a_of_type_Boolean = false;
    localaysu.jdField_b_of_type_Boolean = false;
    localaysu.jdField_a_of_type_Int = 16;
    localaysu.jdField_b_of_type_Int = 2131694697;
    localaysu.jdField_c_of_type_Int = 16;
    if (paramBoolean) {
      if (paramaymg.jdField_b_of_type_Boolean)
      {
        localaysu.jdField_a_of_type_Boolean = true;
        localaysu.jdField_b_of_type_Boolean = false;
        localaysu.jdField_a_of_type_Int = 16;
      }
    }
    for (;;)
    {
      if ((paramaymg.jdField_b_of_type_Boolean) && (localaysu.jdField_a_of_type_Boolean)) {
        localaysu.jdField_a_of_type_Boolean = paramaymg.c;
      }
      return localaysu;
      localaysu.jdField_a_of_type_Boolean = true;
      localaysu.jdField_b_of_type_Boolean = true;
      localaysu.jdField_a_of_type_Int = 98;
      localaysu.jdField_b_of_type_Int = 2131694724;
      localaysu.jdField_c_of_type_Int = 65;
      continue;
      if (ProfileActivity.AllInOne.b(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        if (!this.jdField_a_of_type_Boolean) {
          localaysu.jdField_a_of_type_Boolean = true;
        }
      }
      else if ((a(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (ProfileActivity.AllInOne.a(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
      {
        localaysu.jdField_a_of_type_Boolean = true;
      }
      else
      {
        if (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 3)
        {
          if (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_Int != 0) {}
          for (paramBoolean = bool;; paramBoolean = false)
          {
            localaysu.jdField_a_of_type_Boolean = paramBoolean;
            break;
          }
        }
        if ((paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34))
        {
          localaysu.jdField_b_of_type_Boolean = true;
          localaysu.jdField_c_of_type_Int = 44;
        }
        else if ((paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53) && (paramaymg.jdField_a_of_type_ComTencentMobileqqDataContactCard != null) && (!TextUtils.equals(paramaymg.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
        {
          localaysu.jdField_b_of_type_Boolean = true;
          localaysu.jdField_c_of_type_Int = 44;
        }
      }
    }
  }
  
  private String a(QQAppInterface paramQQAppInterface, aymg paramaymg)
  {
    paramQQAppInterface = (PhoneContactManagerImp)paramQQAppInterface.getManager(11);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.c(FriendProfileCardActivity.a(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.uin;
      }
    }
    return null;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaLangObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131561379, (ViewGroup)this.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)((FrameLayout)this.jdField_a_of_type_JavaLangObject).findViewById(2131378806));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((FrameLayout)this.jdField_a_of_type_JavaLangObject).findViewById(2131369068));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((FrameLayout)this.jdField_a_of_type_JavaLangObject).findViewById(2131369115));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((FrameLayout)this.jdField_a_of_type_JavaLangObject).findViewById(2131369099));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((FrameLayout)this.jdField_a_of_type_JavaLangObject).findViewById(2131369082));
      Resources localResources = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
      DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
      int i = localResources.getDimensionPixelSize(2131299076);
      this.jdField_b_of_type_Int = (localResources.getDimensionPixelSize(2131297554) - i - (int)(localDisplayMetrics.density * 66.0F));
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 17432581);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 17432581);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    }
  }
  
  private void a(View paramView)
  {
    boolean bool2 = false;
    new bcek(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("more_clk").a(new String[] { ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString }).a();
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    Object localObject2 = ((TroopManager)localObject1).b(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString);
    Intent localIntent;
    label761:
    int i;
    if (localObject2 != null)
    {
      a((TroopInfo)localObject2, (aymg)this.jdField_b_of_type_JavaLangObject);
      localIntent = new Intent();
      localIntent.putExtra("troopUin", ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString);
      localIntent.putExtra("memberUin", ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.uin);
      localIntent.putExtra("fromFlag", this.jdField_a_of_type_Int);
      localIntent.putExtra("troopMemberCard", ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard);
      localIntent.putExtra("troopCode", ((TroopInfo)localObject2).troopcode);
      localIntent.putExtra("troopName", ((TroopInfo)localObject2).getTroopName());
      localIntent.putExtra("hwCard", ((TroopManager)localObject1).a(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString, ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.uin));
      localIntent.putExtra("qidian_private_troop", TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString));
      localIntent.putExtra("AllInOne", ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      localIntent.putExtra("detailProfileUrl", bfrj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (aymg)this.jdField_b_of_type_JavaLangObject));
      localIntent.putExtra("qidianshowUin", bily.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
      if (TextUtils.isEmpty(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h)) {
        ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h = ContactUtils.getAccountNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      }
      localObject2 = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      boolean bool3 = ((amsw)localObject2).b(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("isFriend", bool3);
      localIntent.putExtra("isQidianMaster", ((bily)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165)).f(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
      Friends localFriends = ((amsw)localObject2).b(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if (localFriends != null)
      {
        localIntent.putExtra("specialFlag", localFriends.cSpecialFlag);
        if (localFriends.isFriend())
        {
          localIntent.putExtra("key_remark", localFriends.remark);
          localIntent.putExtra("key_group_id", localFriends.groupid);
          localIntent.putExtra("key_current_nick", ContactUtils.getFriendDisplayName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
          localObject1 = ((amsw)localObject2).a(String.valueOf(localFriends.groupid));
          if (localObject1 != null) {
            break label1229;
          }
          localObject1 = "";
          localIntent.putExtra("key_group_name", (String)localObject1);
          localIntent.putExtra("key_not_disturb", FriendsStatusUtil.a(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
          localIntent.putExtra("key_is_shield", ((amsw)localObject2).e(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
          localIntent.putExtra("key_type_gather", localFriends.gathtertype);
          localIntent.putExtra("key_is_has_interaction", awfp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true));
          localObject1 = ((amsw)localObject2).a(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          if ((localObject1 == null) || (((SpecialCareInfo)localObject1).globalSwitch == 0)) {
            break label1239;
          }
          bool1 = true;
          localIntent.putExtra("key_is_specialcare", bool1);
        }
      }
      localIntent.putExtra("businessCard", aphs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (aymg)this.jdField_b_of_type_JavaLangObject));
      if ((((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Bfmt != null) && (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Bfmt.a.size() > 0)) {
        localIntent.putExtra("SHARE_NICK_NAME", ((bfms)((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Bfmt.a.get(0)).jdField_a_of_type_JavaLangString);
      }
      if ((((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard != null) && (!TextUtils.isEmpty(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.addSrcName))) {
        localIntent.putExtra("cur_add_source", ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.addSrcName);
      }
      if (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard != null) {
        localIntent.putExtra("key_nick_name", ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.strNick);
      }
      if ((paramView instanceof TextView))
      {
        paramView = ((TextView)paramView).getText().toString();
        if (!TextUtils.isEmpty(paramView)) {
          localIntent.putExtra("title", paramView);
        }
      }
      if (bool3)
      {
        if (!awgt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) {
          break label1244;
        }
        bool1 = true;
        label1008:
        localIntent.putExtra("friend_intimate_open", bool1);
        localIntent.putExtra("friend_intimate_bind_url", awgt.a(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        localObject1 = awfp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true);
        if (localObject1 == null) {
          break label1333;
        }
        if (((awgq)localObject1).jdField_a_of_type_Long != 1L) {
          break label1249;
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693134);
        label1092:
        i = ((awgq)localObject1).jdField_c_of_type_Int;
      }
    }
    for (boolean bool1 = ((awgq)localObject1).c();; bool1 = bool2)
    {
      localIntent.putExtra("friend_intimate_bind_name", paramView);
      localIntent.putExtra("friend_intimate_isExtinguish", bool1);
      localIntent.putExtra("friend_intimate_bind_res_icon", i);
      localIntent.putExtra("isMsgShielded", a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (aymg)this.jdField_b_of_type_JavaLangObject));
      localIntent.putExtra("isGather", b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (aymg)this.jdField_b_of_type_JavaLangObject));
      paramView = TroopBaseProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      TroopMemberCardProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "troop_member_card_plugin.apk", amtj.a(2131704014), TroopMemberCardProxyActivity.class, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent, paramView, "com.tencent.mobileqq.memcard.plugin.TroopMemberCardMoreInfoActivity", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 8);
      return;
      label1229:
      localObject1 = ((Groups)localObject1).group_name;
      break;
      label1239:
      bool1 = false;
      break label761;
      label1244:
      bool1 = false;
      break label1008;
      label1249:
      if (((awgq)localObject1).jdField_a_of_type_Long == 2L)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693132);
        break label1092;
      }
      if (((awgq)localObject1).jdField_a_of_type_Long == 3L)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693133);
        break label1092;
      }
      if (((awgq)localObject1).jdField_a_of_type_Long == 26L)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693135);
        break label1092;
      }
      paramView = "";
      break label1092;
      label1333:
      paramView = "";
      i = 0;
    }
  }
  
  private void a(PhoneContactManagerImp paramPhoneContactManagerImp, boolean paramBoolean)
  {
    if (NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()))
    {
      String str = FriendProfileCardActivity.a(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      boolean bool;
      QQAppInterface localQQAppInterface;
      if (!paramBoolean)
      {
        bool = true;
        paramPhoneContactManagerImp.a(str, bool);
        q();
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!paramBoolean) {
          break label102;
        }
        paramPhoneContactManagerImp = "0X800603E";
        label62:
        if (!paramBoolean) {
          break label109;
        }
      }
      label102:
      label109:
      for (str = "0X800603E";; str = "0X800603D")
      {
        bcef.b(localQQAppInterface, "CliOper", "", "", paramPhoneContactManagerImp, str, 0, 0, "", "", "", "");
        return;
        bool = false;
        break;
        paramPhoneContactManagerImp = "0X800603D";
        break label62;
      }
    }
    paramPhoneContactManagerImp = amtj.a(2131704025);
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, paramPhoneContactManagerImp, 1000).a();
  }
  
  private void a(TroopInfo paramTroopInfo, aymg paramaymg)
  {
    paramaymg = paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
    if ((paramTroopInfo != null) && (paramaymg != null) && (ProfileActivity.f(paramaymg.jdField_a_of_type_Int)) && (TextUtils.isEmpty(paramaymg.jdField_d_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTitleContainer", 2, String.format("checkAndUpdateTroopInfo troopuin=%s troopcode=%s", new Object[] { paramTroopInfo.troopuin, paramTroopInfo.troopcode }));
      }
      paramaymg.jdField_d_of_type_JavaLangString = paramTroopInfo.troopcode;
      paramaymg.c = paramTroopInfo.troopuin;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    aysu localaysu = a(paramBoolean, (aymg)this.jdField_b_of_type_JavaLangObject);
    if (localaysu.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setTag(new aykg(localaysu.jdField_a_of_type_Int, null));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(localaysu.jdField_b_of_type_Int);
    }
    while (localaysu.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(new aykg(localaysu.jdField_c_of_type_Int, null));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840337);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(amtj.a(2131704017));
        return;
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840329);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(amtj.a(2131704051));
        return;
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private boolean a(ProfileActivity.AllInOne paramAllInOne)
  {
    return (paramAllInOne.jdField_a_of_type_Int == 72) || (paramAllInOne.jdField_a_of_type_Int == 71) || (paramAllInOne.jdField_a_of_type_Int == 70) || (paramAllInOne.jdField_a_of_type_Int == 21) || (paramAllInOne.jdField_a_of_type_Int == 58) || (paramAllInOne.jdField_a_of_type_Int == 22) || (paramAllInOne.jdField_a_of_type_Int == 46) || (paramAllInOne.jdField_a_of_type_Int == 47) || (paramAllInOne.jdField_a_of_type_Int == 41) || (paramAllInOne.jdField_a_of_type_Int == 42) || (paramAllInOne.jdField_a_of_type_Int == 86) || (paramAllInOne.jdField_a_of_type_Int == 56) || (paramAllInOne.jdField_a_of_type_Int == 57) || (paramAllInOne.jdField_a_of_type_Int == 2) || (paramAllInOne.jdField_a_of_type_Int == 74) || (paramAllInOne.jdField_a_of_type_Int == 96) || (paramAllInOne.jdField_a_of_type_Int == 95);
  }
  
  private int b()
  {
    if ((((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Ayxo != null) && (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Ayxo.a() == 0)) {
      return 2131166709;
    }
    return 2131166565;
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTitleContainer", 2, String.format("updateTitleMode mode=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    if (paramInt == 1) {
      if (aymn.a(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Long))
      {
        int i = b();
        paramInt = ((Resources)localObject).getColor(i);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(((Resources)localObject).getColorStateList(i));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(((Resources)localObject).getColorStateList(i));
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
        ImmersiveUtils.a(false, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
      }
    }
    for (;;)
    {
      localObject = a();
      if (localObject != null)
      {
        ((Drawable)localObject).setColorFilter(new LightingColorFilter(0, paramInt));
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(paramInt);
      return;
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
      for (paramInt = 2131167006;; paramInt = 2131166709)
      {
        paramInt = ((Resources)localObject).getColor(paramInt);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramInt);
        break;
      }
      if (paramInt == 0)
      {
        paramInt = ((Resources)localObject).getColor(2131167006);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(((Resources)localObject).getColorStateList(2131167006));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(((Resources)localObject).getColorStateList(2131167006));
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
        bbyp.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
      }
      else
      {
        paramInt = 0;
      }
    }
  }
  
  private void b(Intent paramIntent)
  {
    if (paramIntent == null) {}
    boolean bool1;
    boolean bool4;
    do
    {
      return;
      bool1 = paramIntent.getBooleanExtra("extra_is_deleted", false);
      boolean bool2 = paramIntent.getBooleanExtra("extra_is_msg_tip_modify", false);
      boolean bool3 = paramIntent.getBooleanExtra("extra_is_admin_modify", false);
      bool4 = paramIntent.getBooleanExtra("isNeedFinish", false);
      boolean bool5 = paramIntent.getBooleanExtra("extra_is_level_modify", false);
      if ((bool2) || (bool5)) {
        a(2);
      }
      if (bool3) {
        a(4);
      }
      if (bool1) {
        a(1);
      }
    } while (!bool4);
    paramIntent = new Intent();
    if (!bool1)
    {
      paramIntent.putExtra("isNeedFinish", bool4);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1, paramIntent);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      return;
      if (this.jdField_a_of_type_Int == 8)
      {
        paramIntent.putExtra("key_troop_fee_notify_js_data_changed", true);
        paramIntent.putExtra("callback", this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1, paramIntent);
      }
    }
  }
  
  private boolean b()
  {
    Object localObject = (ayrt)this.jdField_a_of_type_Aysx.a(1002);
    if (localObject != null)
    {
      localObject = ((ayrt)localObject).a();
      if (((localObject instanceof ProfileBaseView)) && (((ProfileBaseView)localObject).a())) {
        return true;
      }
    }
    return false;
  }
  
  private boolean b(QQAppInterface paramQQAppInterface, aymg paramaymg)
  {
    if (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 1)
    {
      paramQQAppInterface = (amsw)paramQQAppInterface.getManager(51);
      if (paramQQAppInterface == null) {}
      for (paramQQAppInterface = null; (paramQQAppInterface != null) && (paramQQAppInterface.gathtertype == 1); paramQQAppInterface = paramQQAppInterface.a(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        return true;
      }
    }
    return false;
  }
  
  private void c(int paramInt)
  {
    if ((paramInt != 0) || (this.jdField_b_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    label32:
    Object localObject1;
    int i;
    Object localObject2;
    if (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
    {
      paramInt = 1;
      if ((paramInt != 0) || (b())) {
        break label176;
      }
      if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
        this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      }
      localObject1 = this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.getChildAt(0);
      if (localObject1 != null) {
        ((View)localObject1).getLocalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
      }
      paramInt = this.jdField_a_of_type_AndroidGraphicsRect.top;
      i = this.jdField_b_of_type_AndroidWidgetTextView.getVisibility();
      localObject2 = null;
      if ((paramInt < 0) || (paramInt <= this.jdField_c_of_type_Int) || (paramInt < this.jdField_b_of_type_Int) || (i != 4)) {
        break label178;
      }
      localObject1 = this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
    }
    for (;;)
    {
      if ((localObject1 != null) && (localObject1 != this.jdField_b_of_type_AndroidWidgetTextView.getAnimation()))
      {
        ((Animation)localObject1).reset();
        this.jdField_b_of_type_AndroidWidgetTextView.startAnimation((Animation)localObject1);
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.startAnimation((Animation)localObject1);
      }
      this.jdField_c_of_type_Int = paramInt;
      return;
      paramInt = 0;
      break label32;
      label176:
      break;
      label178:
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = localObject2;
        if (paramInt < this.jdField_c_of_type_Int)
        {
          localObject1 = localObject2;
          if (paramInt <= this.jdField_b_of_type_Int)
          {
            localObject1 = localObject2;
            if (i == 0) {
              localObject1 = this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
            }
          }
        }
      }
    }
  }
  
  private void c(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SplashActivity.class);
    AIOUtils.setOpenAIOIntent(localIntent, null);
    paramIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131718771));
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    paramIntent = ForwardUtils.sessionFromIntent(localIntent);
    ForwardUtils.handleAppShareAction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramIntent, localIntent);
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aysp(this));
    boolean bool;
    if (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      bool = true;
      if (!bool) {
        break label67;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693096);
    }
    for (;;)
    {
      a(bool);
      return;
      bool = false;
      break;
      label67:
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693095);
    }
  }
  
  private void j()
  {
    boolean bool1;
    boolean bool3;
    if (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
    {
      bool1 = true;
      bool3 = b();
      if (this.jdField_c_of_type_Int < this.jdField_b_of_type_Int) {
        break label104;
      }
    }
    label104:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTitleContainer", 2, String.format("updateTitleMode contactStranger=%s isInNoCoverMode=%s titleHasFadeIn=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool2) }));
      }
      if ((!bool1) && (!bool3) && (!bool2)) {
        break label109;
      }
      b(0);
      return;
      bool1 = false;
      break;
    }
    label109:
    b(1);
  }
  
  private void k()
  {
    if ((this.jdField_c_of_type_AndroidWidgetTextView.getTag() instanceof aykg))
    {
      Object localObject = (aykg)this.jdField_c_of_type_AndroidWidgetTextView.getTag();
      if ((((aykg)localObject).jdField_a_of_type_Int == 98) || (((aykg)localObject).jdField_a_of_type_Int == 99))
      {
        localObject = bfrj.a();
        this.jdField_a_of_type_Bjng.obtainMessage(100, localObject).sendToTarget();
      }
    }
  }
  
  private void l()
  {
    bjnw localbjnw = (bjnw)bjon.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
    localbjnw.a(2131698463, 1);
    localbjnw.a(2131698462, 1);
    localbjnw.c(2131690620);
    localbjnw.a(new aysq(this, localbjnw));
    localbjnw.a(new aysr(this, localbjnw));
    localbjnw.a(new ayss(this, localbjnw));
    try
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
        localbjnw.show();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ProfileTitleContainer", 1, "showMoreActionSheet actionSheet show fail.", localException);
    }
  }
  
  private void m()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ProfileCardMoreActivity.class);
    BusinessCard localBusinessCard = aphs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (aymg)this.jdField_b_of_type_JavaLangObject);
    localIntent = bfrj.a(localIntent, ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, localBusinessCard);
    if ((((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Bfmt != null) && (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Bfmt.a.size() > 0)) {
      localIntent.putExtra("SHARE_NICK_NAME", ((bfms)((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Bfmt.a.get(0)).jdField_a_of_type_JavaLangString);
    }
    if ((((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard != null) && (!TextUtils.isEmpty(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.addSrcName))) {
      localIntent.putExtra("cur_add_source", ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.addSrcName);
    }
    if (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard != null) {
      localIntent.putExtra("key_nick_name", ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.strNick);
    }
    localIntent.addFlags(536870912);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, 1012);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A8A", "0X8006A8A", 0, 0, "", "", "", "");
  }
  
  private void n()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131716205);
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    String str3 = ContactUtils.getAccountNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QRDisplayActivity.class);
    localIntent.putExtra("title", str1);
    localIntent.putExtra("uin", str2);
    localIntent.putExtra("nick", str3);
    localIntent.putExtra("type", 1);
    localIntent.putExtra("reportFlag", 1);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
  }
  
  private void o()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    PhoneContact localPhoneContact = localPhoneContactManagerImp.c(FriendProfileCardActivity.a(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
    if ((localPhoneContact != null) && (localPhoneContact.isHiden)) {}
    for (boolean bool = true;; bool = false)
    {
      bjnw localbjnw = (bjnw)bjon.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
      localbjnw.b(2131693072);
      if (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 53) {
        break;
      }
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007015", "0X8007015", 0, 0, "", "", "", "");
      localbjnw.c(2131690620);
      localbjnw.a(new ayst(this, localPhoneContactManagerImp, bool, localbjnw));
      try
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
          localbjnw.show();
        }
        return;
      }
      catch (Exception localException)
      {
        int i;
        QLog.e("ProfileTitleContainer", 1, "", localException);
      }
    }
    if ((!TextUtils.isEmpty(a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (aymg)this.jdField_b_of_type_JavaLangObject))) && (localPhoneContact != null)) {
      if (!localPhoneContact.isHiden) {
        break label239;
      }
    }
    label239:
    for (i = 2131693073;; i = 2131693071)
    {
      localbjnw.b(i);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007167", "0X8007167", 0, 0, "", "", "", "");
      break;
    }
  }
  
  private void p()
  {
    if (NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()))
    {
      Object localObject2 = ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ArrayOfJavaLangString[3];
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (!((String)localObject2).equals(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataContactCard.mobileNo)) {}
      }
      else
      {
        localObject1 = ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.k;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (!((String)localObject1).equals(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataContactCard.mobileNo)) {}
      }
      else
      {
        localObject2 = ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataContactCard.nickName;
      }
      localObject2 = ForwardShareCardOption.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, (String)localObject2, ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataContactCard.bindQQ);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("uin", ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataContactCard.mobileNo);
      ((Bundle)localObject1).putInt("uintype", 1006);
      ((Bundle)localObject1).putInt("forward_type", 20);
      ((Bundle)localObject1).putInt("structmsg_service_id", ((AbsShareMsg)localObject2).mMsgServiceID);
      ((Bundle)localObject1).putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
      ((Bundle)localObject1).putBoolean("k_dataline", false);
      ((Bundle)localObject1).putInt("pa_type", ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      atky.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Intent)localObject2, 21);
      if (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53)
      {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007016", "0X8007016", 0, 0, "", "", "", "");
        return;
      }
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007168", "0X8007168", 0, 0, "", "", "", "");
      return;
    }
    Object localObject1 = amtj.a(2131704040);
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, (CharSequence)localObject1, 1000).a();
  }
  
  private void q()
  {
    try
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())
      {
        this.jdField_a_of_type_Bhht = new bhht(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        this.jdField_a_of_type_Bhht.setCancelable(false);
        this.jdField_a_of_type_Bhht.c(2131694701);
        this.jdField_a_of_type_Bhht.show();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ProfileTitleContainer", 1, "showHideContactProgressDialog fail.", localException);
    }
  }
  
  private void r()
  {
    try
    {
      if ((this.jdField_a_of_type_Bhht != null) && (this.jdField_a_of_type_Bhht.isShowing())) {
        this.jdField_a_of_type_Bhht.dismiss();
      }
      this.jdField_a_of_type_Bhht = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ProfileTitleContainer", 1, "dismissHideContactDialog fail.", localException);
      }
    }
  }
  
  public int a()
  {
    return 106;
  }
  
  public String a()
  {
    return "ProfileTitleContainer";
  }
  
  protected void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 7))
    {
      int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("memberOperationFlag", 0);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("memberOperationFlag", i | paramInt);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("memberOperateUin", ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 8) {
      b(paramIntent);
    }
    while (paramInt1 != 21) {
      return;
    }
    c(paramIntent);
  }
  
  public void a(aysa paramaysa)
  {
    this.jdField_a_of_type_Aysa = paramaysa;
  }
  
  public void a(@NotNull BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super.a(paramBaseActivity, paramBundle);
    paramBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    if (paramBaseActivity != null)
    {
      this.jdField_a_of_type_Boolean = paramBaseActivity.getBooleanExtra("key_from_ark_babyq", false);
      this.jdField_a_of_type_Int = paramBaseActivity.getIntExtra("fromFlag", -1);
      if (this.jdField_a_of_type_Int == 8) {
        this.jdField_a_of_type_JavaLangString = paramBaseActivity.getStringExtra("callback");
      }
    }
    this.jdField_a_of_type_Bjng = new bjng(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    if (this.jdField_a_of_type_Aysa != null) {
      this.jdField_a_of_type_Aysa.a(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Aycd);
    }
    a();
    i();
    j();
    paramBaseActivity = amtj.a(2131704043);
    bfpm.a(this.jdField_a_of_type_AndroidWidgetTextView, paramBaseActivity);
    bfpm.a(this.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  public void a(PullToZoomHeaderListView paramPullToZoomHeaderListView)
  {
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView = paramPullToZoomHeaderListView;
  }
  
  public boolean a(aymg paramaymg)
  {
    i();
    j();
    return true;
  }
  
  boolean a(QQAppInterface paramQQAppInterface, aymg paramaymg)
  {
    String str = null;
    Object localObject = null;
    boolean bool2 = false;
    switch (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      localObject = (amsw)paramQQAppInterface.getManager(51);
      if ((localObject != null) && (((amsw)localObject).b(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        bool1 = ((amsw)localObject).e(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      }
      break;
    case 41: 
    case 42: 
    case 86: 
    case 1: 
      do
      {
        return bool1;
        paramQQAppInterface = (amsw)paramQQAppInterface.getManager(51);
        if (paramQQAppInterface == null) {}
        for (paramQQAppInterface = (QQAppInterface)localObject;; paramQQAppInterface = paramQQAppInterface.a(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
        {
          bool1 = bool2;
          if (paramQQAppInterface == null) {
            break;
          }
          bool1 = bool2;
          if (paramQQAppInterface.groupid != -1002) {
            break;
          }
          return true;
        }
        paramQQAppInterface = (amsw)paramQQAppInterface.getManager(51);
        bool1 = bool2;
      } while (paramQQAppInterface == null);
      return paramQQAppInterface.e(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    }
    localObject = (avnk)paramQQAppInterface.getManager(16);
    if (localObject != null) {
      if (ProfileActivity.AllInOne.g(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        str = paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        if (TextUtils.isEmpty(str)) {
          break label263;
        }
      }
    }
    label263:
    for (boolean bool1 = ((avnk)localObject).a(str);; bool1 = false)
    {
      return bool1;
      if (!ProfileActivity.AllInOne.i(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        break;
      }
      str = a(paramQQAppInterface, paramaymg);
      break;
    }
  }
  
  public void c()
  {
    super.c();
    k();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Aysa != null) {
      this.jdField_a_of_type_Aysa.b(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Aycd);
    }
    super.f();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof aykg)) {
      switch (((aykg)paramView.getTag()).jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_b_of_type_Boolean)
      {
        a(paramView);
      }
      else
      {
        m();
        continue;
        if (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
        {
          l();
          int j = 2;
          int i = j;
          if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
          {
            i = j;
            if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.c()) {
              i = 1;
            }
          }
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A97C", "0X800A97C", i, 0, "0", "0", "", "");
          continue;
          bfrj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          continue;
          n();
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EBB", "0X8007EBB", 0, 0, "", "", "", "");
          continue;
          o();
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    c(paramInt1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysl
 * JD-Core Version:    0.7.0.1
 */