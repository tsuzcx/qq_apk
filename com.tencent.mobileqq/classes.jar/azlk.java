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
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.forward.ForwardShareCardOption;
import com.tencent.mobileqq.profilecard.base.view.ProfileBaseView;
import com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.PullToZoomHeaderListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.troop.TroopBaseProxyActivity;
import cooperation.troop.TroopMemberCardProxyActivity;
import java.util.List;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

public class azlk
  extends azkq<FrameLayout>
  implements View.OnClickListener, bkhe
{
  public int a;
  protected Intent a;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private StateListDrawable jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new azlm(this);
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new azll(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aywi jdField_a_of_type_Aywi = new azln(this);
  private azkz jdField_a_of_type_Azkz;
  private biau jdField_a_of_type_Biau;
  private bkgm jdField_a_of_type_Bkgm;
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
  
  public azlk(azlw paramazlw, azfe paramazfe)
  {
    super(paramazlw, paramazfe);
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
      Object localObject2 = BitmapFactory.decodeResource((Resources)localObject1, 2130850101);
      Bitmap localBitmap = BitmapFactory.decodeResource((Resources)localObject1, 2130850105);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    FrameLayout localFrameLayout = new FrameLayout(paramView.getContext());
    localFrameLayout.setLayoutParams(paramView.getLayoutParams());
    localFrameLayout.setPadding(afur.a(paramInt1, (Resources)localObject), afur.a(paramInt2, (Resources)localObject), afur.a(paramInt3, (Resources)localObject), afur.a(paramInt4, (Resources)localObject));
    localObject = (ViewGroup)paramView.getParent();
    paramInt1 = ((ViewGroup)localObject).indexOfChild(paramView);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    ((ViewGroup)localObject).removeView(paramView);
    localFrameLayout.addView(paramView, localLayoutParams);
    ((ViewGroup)localObject).addView(localFrameLayout, paramInt1);
    return localFrameLayout;
  }
  
  private azlt a(boolean paramBoolean, azfe paramazfe)
  {
    boolean bool = true;
    azlt localazlt = new azlt(null);
    localazlt.jdField_a_of_type_Boolean = false;
    localazlt.jdField_b_of_type_Boolean = false;
    localazlt.jdField_a_of_type_Int = 16;
    localazlt.jdField_b_of_type_Int = 2131694539;
    localazlt.jdField_c_of_type_Int = 16;
    if (paramBoolean) {
      if (paramazfe.jdField_b_of_type_Boolean)
      {
        localazlt.jdField_a_of_type_Boolean = true;
        localazlt.jdField_b_of_type_Boolean = false;
        localazlt.jdField_a_of_type_Int = 16;
      }
    }
    for (;;)
    {
      if ((paramazfe.jdField_b_of_type_Boolean) && (localazlt.jdField_a_of_type_Boolean)) {
        localazlt.jdField_a_of_type_Boolean = paramazfe.c;
      }
      return localazlt;
      localazlt.jdField_a_of_type_Boolean = true;
      localazlt.jdField_b_of_type_Boolean = true;
      localazlt.jdField_a_of_type_Int = 98;
      localazlt.jdField_b_of_type_Int = 2131694566;
      localazlt.jdField_c_of_type_Int = 65;
      continue;
      if (ProfileActivity.AllInOne.b(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        if (!this.jdField_a_of_type_Boolean) {
          localazlt.jdField_a_of_type_Boolean = true;
        }
      }
      else if ((paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 72) || (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 71) || (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 70) || (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21) || (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 58) || (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 22) || (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46) || (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 47) || (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) || (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 42) || (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 86) || (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 57) || (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 2) || (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 74) || (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 96) || (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 95) || (ProfileActivity.AllInOne.a(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
      {
        localazlt.jdField_a_of_type_Boolean = true;
      }
      else
      {
        if (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 3)
        {
          if (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_Int != 0) {}
          for (paramBoolean = bool;; paramBoolean = false)
          {
            localazlt.jdField_a_of_type_Boolean = paramBoolean;
            break;
          }
        }
        if ((paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34))
        {
          localazlt.jdField_b_of_type_Boolean = true;
          localazlt.jdField_c_of_type_Int = 44;
        }
        else if ((paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53) && (paramazfe.jdField_a_of_type_ComTencentMobileqqDataContactCard != null) && (!TextUtils.equals(paramazfe.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
        {
          localazlt.jdField_b_of_type_Boolean = true;
          localazlt.jdField_c_of_type_Int = 44;
        }
      }
    }
  }
  
  private String a(QQAppInterface paramQQAppInterface, azfe paramazfe)
  {
    paramQQAppInterface = (PhoneContactManagerImp)paramQQAppInterface.getManager(11);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.c(FriendProfileCardActivity.a(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
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
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131561454, (ViewGroup)this.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)((FrameLayout)this.jdField_a_of_type_JavaLangObject).findViewById(2131378874));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((FrameLayout)this.jdField_a_of_type_JavaLangObject).findViewById(2131368947));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((FrameLayout)this.jdField_a_of_type_JavaLangObject).findViewById(2131368994));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((FrameLayout)this.jdField_a_of_type_JavaLangObject).findViewById(2131368979));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((FrameLayout)this.jdField_a_of_type_JavaLangObject).findViewById(2131368961));
      Resources localResources = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
      DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
      int i = localResources.getDimensionPixelSize(2131298998);
      this.jdField_b_of_type_Int = (localResources.getDimensionPixelSize(2131297487) - i - (int)(localDisplayMetrics.density * 66.0F));
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
    new bcsy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("more_clk").a(new String[] { ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString }).a();
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    Object localObject2 = ((TroopManager)localObject1).b(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString);
    Intent localIntent;
    label761:
    int i;
    if (localObject2 != null)
    {
      a((TroopInfo)localObject2, (azfe)this.jdField_b_of_type_JavaLangObject);
      localIntent = new Intent();
      localIntent.putExtra("troopUin", ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString);
      localIntent.putExtra("memberUin", ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.uin);
      localIntent.putExtra("fromFlag", this.jdField_a_of_type_Int);
      localIntent.putExtra("troopMemberCard", ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard);
      localIntent.putExtra("troopCode", ((TroopInfo)localObject2).troopcode);
      localIntent.putExtra("troopName", ((TroopInfo)localObject2).getTroopName());
      localIntent.putExtra("hwCard", ((TroopManager)localObject1).a(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString, ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.uin));
      localIntent.putExtra("qidian_private_troop", TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString));
      localIntent.putExtra("AllInOne", ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      localIntent.putExtra("detailProfileUrl", bghy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (azfe)this.jdField_b_of_type_JavaLangObject));
      localIntent.putExtra("qidianshowUin", bjft.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
      if (TextUtils.isEmpty(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h)) {
        ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h = bglf.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      }
      localObject2 = (anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      boolean bool3 = ((anmw)localObject2).b(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("isFriend", bool3);
      localIntent.putExtra("isQidianMaster", ((bjft)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165)).f(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
      Friends localFriends = ((anmw)localObject2).b(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if (localFriends != null)
      {
        localIntent.putExtra("specialFlag", localFriends.cSpecialFlag);
        if (localFriends.isFriend())
        {
          localIntent.putExtra("key_remark", localFriends.remark);
          localIntent.putExtra("key_group_id", localFriends.groupid);
          localIntent.putExtra("key_current_nick", bglf.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
          localObject1 = ((anmw)localObject2).a(String.valueOf(localFriends.groupid));
          if (localObject1 != null) {
            break label1250;
          }
          localObject1 = "";
          localIntent.putExtra("key_group_name", (String)localObject1);
          localIntent.putExtra("key_not_disturb", FriendsStatusUtil.a(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
          localIntent.putExtra("key_is_shield", ((anmw)localObject2).e(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
          localIntent.putExtra("key_type_gather", localFriends.gathtertype);
          localIntent.putExtra("key_is_has_interaction", awzp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true));
          localObject1 = ((anmw)localObject2).a(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          if ((localObject1 == null) || (((SpecialCareInfo)localObject1).globalSwitch == 0)) {
            break label1260;
          }
          bool1 = true;
          localIntent.putExtra("key_is_specialcare", bool1);
        }
      }
      localIntent.putExtra("businessCard", aqaj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (azfe)this.jdField_b_of_type_JavaLangObject));
      if ((this.jdField_b_of_type_JavaLangObject != null) && (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Bgdg != null) && (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Bgdg.a.size() > 0)) {
        localIntent.putExtra("SHARE_NICK_NAME", ((bgdf)((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Bgdg.a.get(0)).jdField_a_of_type_JavaLangString);
      }
      if ((this.jdField_b_of_type_JavaLangObject != null) && (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard != null) && (!TextUtils.isEmpty(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.addSrcName))) {
        localIntent.putExtra("cur_add_source", ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.addSrcName);
      }
      if ((this.jdField_b_of_type_JavaLangObject != null) && (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
        localIntent.putExtra("key_nick_name", ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.strNick);
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
        if (!axas.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) {
          break label1265;
        }
        bool1 = true;
        label1029:
        localIntent.putExtra("friend_intimate_open", bool1);
        localIntent.putExtra("friend_intimate_bind_url", axas.a(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        localObject1 = awzp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true);
        if (localObject1 == null) {
          break label1328;
        }
        if (((axap)localObject1).jdField_a_of_type_Long != 1L) {
          break label1270;
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693066);
        label1113:
        i = ((axap)localObject1).jdField_c_of_type_Int;
      }
    }
    for (boolean bool1 = ((axap)localObject1).c();; bool1 = bool2)
    {
      localIntent.putExtra("friend_intimate_bind_name", paramView);
      localIntent.putExtra("friend_intimate_isExtinguish", bool1);
      localIntent.putExtra("friend_intimate_bind_res_icon", i);
      localIntent.putExtra("isMsgShielded", a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (azfe)this.jdField_b_of_type_JavaLangObject));
      localIntent.putExtra("isGather", b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (azfe)this.jdField_b_of_type_JavaLangObject));
      paramView = TroopBaseProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      TroopMemberCardProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "troop_member_card_plugin.apk", anni.a(2131703677), TroopMemberCardProxyActivity.class, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent, paramView, "com.tencent.mobileqq.memcard.plugin.TroopMemberCardMoreInfoActivity", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 8);
      return;
      label1250:
      localObject1 = ((Groups)localObject1).group_name;
      break;
      label1260:
      bool1 = false;
      break label761;
      label1265:
      bool1 = false;
      break label1029;
      label1270:
      if (((axap)localObject1).jdField_a_of_type_Long == 2L)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693064);
        break label1113;
      }
      if (((axap)localObject1).jdField_a_of_type_Long == 3L)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693065);
        break label1113;
      }
      paramView = "";
      break label1113;
      label1328:
      paramView = "";
      i = 0;
    }
  }
  
  private void a(PhoneContactManagerImp paramPhoneContactManagerImp, boolean paramBoolean)
  {
    if (bgnt.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()))
    {
      String str = FriendProfileCardActivity.a(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
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
        bcst.b(localQQAppInterface, "CliOper", "", "", paramPhoneContactManagerImp, str, 0, 0, "", "", "", "");
        return;
        bool = false;
        break;
        paramPhoneContactManagerImp = "0X800603D";
        break label62;
      }
    }
    paramPhoneContactManagerImp = anni.a(2131703688);
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, paramPhoneContactManagerImp, 1000).a();
  }
  
  private void a(TroopInfo paramTroopInfo, azfe paramazfe)
  {
    paramazfe = paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
    if ((paramTroopInfo != null) && (paramazfe != null) && (ProfileActivity.f(paramazfe.jdField_a_of_type_Int)) && (TextUtils.isEmpty(paramazfe.jdField_d_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTitleContainer", 2, String.format("checkAndUpdateTroopInfo troopuin=%s troopcode=%s", new Object[] { paramTroopInfo.troopuin, paramTroopInfo.troopcode }));
      }
      paramazfe.jdField_d_of_type_JavaLangString = paramTroopInfo.troopcode;
      paramazfe.c = paramTroopInfo.troopuin;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    azlt localazlt = a(paramBoolean, (azfe)this.jdField_b_of_type_JavaLangObject);
    if (localazlt.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setTag(new azde(localazlt.jdField_a_of_type_Int, null));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(localazlt.jdField_b_of_type_Int);
    }
    while (localazlt.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(new azde(localazlt.jdField_c_of_type_Int, null));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840289);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anni.a(2131703680));
        return;
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840281);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anni.a(2131703715));
        return;
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private int b()
  {
    if ((((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Azph != null) && (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Azph.a() == 0)) {
      return 2131166686;
    }
    return 2131166542;
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTitleContainer", 2, String.format("updateTitleMode mode=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    if (paramInt == 1) {
      if (azfl.a(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Long))
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
      for (paramInt = 2131166980;; paramInt = 2131166686)
      {
        paramInt = ((Resources)localObject).getColor(paramInt);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramInt);
        break;
      }
      if (paramInt == 0)
      {
        paramInt = ((Resources)localObject).getColor(2131166980);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(((Resources)localObject).getColorStateList(2131166980));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(((Resources)localObject).getColorStateList(2131166980));
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
        bcnj.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
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
    Object localObject = (azks)this.jdField_a_of_type_Azlw.a(1002);
    if (localObject != null)
    {
      localObject = ((azks)localObject).a();
      if (((localObject instanceof ProfileBaseView)) && (((ProfileBaseView)localObject).a())) {
        return true;
      }
    }
    return false;
  }
  
  private boolean b(QQAppInterface paramQQAppInterface, azfe paramazfe)
  {
    if (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 1)
    {
      paramQQAppInterface = (anmw)paramQQAppInterface.getManager(51);
      if (paramQQAppInterface == null) {}
      for (paramQQAppInterface = null; (paramQQAppInterface != null) && (paramQQAppInterface.gathtertype == 1); paramQQAppInterface = paramQQAppInterface.a(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
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
    if (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
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
    afur.a(localIntent, null);
    paramIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131718387));
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    paramIntent = ForwardUtils.a(localIntent);
    ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramIntent, localIntent);
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new azlo(this));
    boolean bool;
    if (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      bool = true;
      if (!bool) {
        break label67;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693032);
    }
    for (;;)
    {
      a(bool);
      return;
      bool = false;
      break;
      label67:
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693031);
    }
  }
  
  private void j()
  {
    boolean bool1;
    boolean bool3;
    if (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
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
    if ((this.jdField_c_of_type_AndroidWidgetTextView.getTag() instanceof azde))
    {
      Object localObject = (azde)this.jdField_c_of_type_AndroidWidgetTextView.getTag();
      if ((((azde)localObject).jdField_a_of_type_Int == 98) || (((azde)localObject).jdField_a_of_type_Int == 99))
      {
        localObject = bghy.a();
        this.jdField_a_of_type_Bkgm.obtainMessage(100, localObject).sendToTarget();
      }
    }
  }
  
  private void l()
  {
    bkho localbkho = (bkho)bkif.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
    localbkho.a(2131698192, 1);
    localbkho.a(2131698191, 1);
    localbkho.c(2131690582);
    localbkho.a(new azlp(this, localbkho));
    localbkho.a(new azlq(this, localbkho));
    localbkho.a(new azlr(this, localbkho));
    try
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
        localbkho.show();
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
    BusinessCard localBusinessCard = aqaj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (azfe)this.jdField_b_of_type_JavaLangObject);
    localIntent = bghy.a(localIntent, ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, localBusinessCard);
    if ((((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Bgdg != null) && (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Bgdg.a.size() > 0)) {
      localIntent.putExtra("SHARE_NICK_NAME", ((bgdf)((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Bgdg.a.get(0)).jdField_a_of_type_JavaLangString);
    }
    if ((((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard != null) && (!TextUtils.isEmpty(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.addSrcName))) {
      localIntent.putExtra("cur_add_source", ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.addSrcName);
    }
    if (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard != null) {
      localIntent.putExtra("key_nick_name", ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.strNick);
    }
    localIntent.addFlags(536870912);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, 1012);
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A8A", "0X8006A8A", 0, 0, "", "", "", "");
  }
  
  private void n()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131715862);
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    String str3 = bglf.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
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
    PhoneContact localPhoneContact = localPhoneContactManagerImp.c(FriendProfileCardActivity.a(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
    if ((localPhoneContact != null) && (localPhoneContact.isHiden)) {}
    for (boolean bool = true;; bool = false)
    {
      bkho localbkho = (bkho)bkif.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
      localbkho.b(2131693008);
      if (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 53) {
        break;
      }
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007015", "0X8007015", 0, 0, "", "", "", "");
      localbkho.c(2131690582);
      localbkho.a(new azls(this, localPhoneContactManagerImp, bool, localbkho));
      try
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
          localbkho.show();
        }
        return;
      }
      catch (Exception localException)
      {
        int i;
        QLog.e("ProfileTitleContainer", 1, "", localException);
      }
    }
    if ((!TextUtils.isEmpty(a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (azfe)this.jdField_b_of_type_JavaLangObject))) && (localPhoneContact != null)) {
      if (!localPhoneContact.isHiden) {
        break label239;
      }
    }
    label239:
    for (i = 2131693009;; i = 2131693007)
    {
      localbkho.b(i);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007167", "0X8007167", 0, 0, "", "", "", "");
      break;
    }
  }
  
  private void p()
  {
    if (bgnt.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()))
    {
      Object localObject2 = ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ArrayOfJavaLangString[3];
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (!((String)localObject2).equals(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataContactCard.mobileNo)) {}
      }
      else
      {
        localObject1 = ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.k;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (!((String)localObject1).equals(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataContactCard.mobileNo)) {}
      }
      else
      {
        localObject2 = ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataContactCard.nickName;
      }
      localObject2 = ForwardShareCardOption.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, (String)localObject2, ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataContactCard.bindQQ);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("uin", ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataContactCard.mobileNo);
      ((Bundle)localObject1).putInt("uintype", 1006);
      ((Bundle)localObject1).putInt("forward_type", 20);
      ((Bundle)localObject1).putInt("structmsg_service_id", ((AbsShareMsg)localObject2).mMsgServiceID);
      ((Bundle)localObject1).putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
      ((Bundle)localObject1).putBoolean("k_dataline", false);
      ((Bundle)localObject1).putInt("pa_type", ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      aufz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Intent)localObject2, 21);
      if (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53)
      {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007016", "0X8007016", 0, 0, "", "", "", "");
        return;
      }
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007168", "0X8007168", 0, 0, "", "", "", "");
      return;
    }
    Object localObject1 = anni.a(2131703703);
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, (CharSequence)localObject1, 1000).a();
  }
  
  private void q()
  {
    try
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())
      {
        this.jdField_a_of_type_Biau = new biau(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        this.jdField_a_of_type_Biau.setCancelable(false);
        this.jdField_a_of_type_Biau.c(2131694543);
        this.jdField_a_of_type_Biau.show();
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
      if ((this.jdField_a_of_type_Biau != null) && (this.jdField_a_of_type_Biau.isShowing())) {
        this.jdField_a_of_type_Biau.dismiss();
      }
      this.jdField_a_of_type_Biau = null;
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
      this.jdField_a_of_type_AndroidContentIntent.putExtra("memberOperateUin", ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
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
  
  public void a(azkz paramazkz)
  {
    this.jdField_a_of_type_Azkz = paramazkz;
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
    this.jdField_a_of_type_Bkgm = new bkgm(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    if (this.jdField_a_of_type_Azkz != null) {
      this.jdField_a_of_type_Azkz.a(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Aywi);
    }
    a();
    i();
    j();
    paramBaseActivity = anni.a(2131703707);
    bgfz.a(this.jdField_a_of_type_AndroidWidgetTextView, paramBaseActivity);
    bgfz.a(this.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  public void a(PullToZoomHeaderListView paramPullToZoomHeaderListView)
  {
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView = paramPullToZoomHeaderListView;
  }
  
  public boolean a(azfe paramazfe)
  {
    i();
    j();
    return true;
  }
  
  boolean a(QQAppInterface paramQQAppInterface, azfe paramazfe)
  {
    String str = null;
    Object localObject = null;
    boolean bool2 = false;
    switch (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      localObject = (anmw)paramQQAppInterface.getManager(51);
      if ((localObject != null) && (((anmw)localObject).b(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        bool1 = ((anmw)localObject).e(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      }
      break;
    case 41: 
    case 42: 
    case 86: 
    case 1: 
      do
      {
        return bool1;
        paramQQAppInterface = (anmw)paramQQAppInterface.getManager(51);
        if (paramQQAppInterface == null) {}
        for (paramQQAppInterface = (QQAppInterface)localObject;; paramQQAppInterface = paramQQAppInterface.a(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
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
        paramQQAppInterface = (anmw)paramQQAppInterface.getManager(51);
        bool1 = bool2;
      } while (paramQQAppInterface == null);
      return paramQQAppInterface.e(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    }
    localObject = (awhl)paramQQAppInterface.getManager(16);
    if (localObject != null) {
      if (ProfileActivity.AllInOne.g(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        str = paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        if (TextUtils.isEmpty(str)) {
          break label263;
        }
      }
    }
    label263:
    for (boolean bool1 = ((awhl)localObject).a(str);; bool1 = false)
    {
      return bool1;
      if (!ProfileActivity.AllInOne.i(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        break;
      }
      str = a(paramQQAppInterface, paramazfe);
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
    if (this.jdField_a_of_type_Azkz != null) {
      this.jdField_a_of_type_Azkz.b(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Aywi);
    }
    super.f();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof azde)) {
      switch (((azde)paramView.getTag()).jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_b_of_type_Boolean)
      {
        a(paramView);
      }
      else
      {
        m();
        continue;
        if (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
        {
          l();
          int j = 2;
          int i = j;
          if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
          {
            i = j;
            if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b()) {
              i = 1;
            }
          }
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A97C", "0X800A97C", i, 0, "0", "0", "", "");
          continue;
          bghy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          continue;
          n();
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EBB", "0X8007EBB", 0, 0, "", "", "", "");
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
 * Qualified Name:     azlk
 * JD-Core Version:    0.7.0.1
 */