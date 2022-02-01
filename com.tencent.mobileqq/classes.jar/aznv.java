import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.ExtendFriendPublicFragmentActivity;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.ExtendFriendInfo;
import com.tencent.mobileqq.profilecard.bussiness.extendfriend.ProfileExtendFriendComponent.3;
import com.tencent.mobileqq.profilecard.bussiness.extendfriend.ProfileExtendFriendComponent.7;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.ProfileCardExtendFriendView;
import com.tencent.mobileqq.widget.ProfileCardFavorShowView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.ConcurrentHashMap;

public class aznv
  extends azkr
  implements View.OnClickListener
{
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private aniz jdField_a_of_type_Aniz = new aznw(this);
  private asgf jdField_a_of_type_Asgf;
  private biau jdField_a_of_type_Biau;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ProfileExtendFriendComponent.3(this);
  private boolean jdField_a_of_type_Boolean;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private asgf jdField_b_of_type_Asgf = new aznx(this);
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private boolean e;
  
  public aznv(azlw paramazlw, azfe paramazfe)
  {
    super(paramazlw, paramazfe);
  }
  
  private void a()
  {
    if (TextUtils.equals(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      if (c()) {
        if (this.jdField_a_of_type_Boolean)
        {
          i = 2;
          bcst.b(null, "dc00898", "", "", "kuolie", "0X80097DB", i, 0, "", "", "", "");
        }
      }
    }
    while (this.jdField_b_of_type_Boolean)
    {
      for (;;)
      {
        return;
        int i = 1;
      }
      ExtendFriendProfileEditFragment.ExtendFriendInfo localExtendFriendInfo = new ExtendFriendProfileEditFragment.ExtendFriendInfo(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard);
      Intent localIntent = new Intent();
      localIntent.putExtra("key_extend_friend_info", localExtendFriendInfo);
      PublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent, ExtendFriendEditFragment.class, 4097);
      return;
    }
    ExtendFriendPublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  private void a(ViewGroup paramViewGroup, Card paramCard)
  {
    if (paramViewGroup != null)
    {
      if ((paramCard != null) && (!TextUtils.isEmpty(paramCard.schoolName)))
      {
        paramViewGroup.setVisibility(8);
        asme.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
      }
    }
    else {
      return;
    }
    if (asme.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      paramViewGroup.setVisibility(0);
      paramCard = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131561137, null);
      TextView localTextView = (TextView)paramCard.findViewById(2131379539);
      paramViewGroup.addView(paramCard);
      a(null, localTextView, null);
      return;
    }
    paramViewGroup.setVisibility(8);
  }
  
  private void a(Card paramCard, ProfileCardFavorShowView paramProfileCardFavorShowView)
  {
    boolean bool2 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int j;
    Object localObject;
    int i;
    if (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Azfl != null)
    {
      j = 1;
      localObject = paramProfileCardFavorShowView.a(0);
      if (localObject == null) {
        break label509;
      }
      if (j == 0) {
        break label374;
      }
      azfl localazfl = (azfl)((View)localObject).getTag(2131372899);
      if ((localazfl != null) && (localazfl.equals(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Azfl))) {
        break label509;
      }
      i = 1;
    }
    for (;;)
    {
      label79:
      boolean bool1;
      if ((localObject == null) || (!Boolean.FALSE.equals(((View)localObject).getTag(2131372900))) || (!Boolean.valueOf(bool2).equals(((View)localObject).getTag(2131372901))) || (i != 0))
      {
        paramProfileCardFavorShowView.removeAllViews();
        paramProfileCardFavorShowView.setFocusable(false);
        paramProfileCardFavorShowView.setClickable(false);
        if (j == 0) {
          break label503;
        }
        localObject = ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Azfl.a.get("commonItemContentColor");
        if (localObject == null) {
          break label498;
        }
        if ((localObject instanceof ColorStateList))
        {
          i = ((ColorStateList)localObject).getDefaultColor();
          label183:
          localObject = new float[3];
          Color.colorToHSV(i, (float[])localObject);
          if (localObject[2] <= 0.5F) {
            break label424;
          }
          bool1 = true;
        }
      }
      for (;;)
      {
        label208:
        if (bool2)
        {
          localObject = new ProfileCardExtendFriendView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Azfl, true);
          label237:
          if ((((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 96) || (this.jdField_a_of_type_Boolean)) {
            ((ProfileCardExtendFriendView)localObject).setFold(false);
          }
          ((ProfileCardExtendFriendView)localObject).setClickable(true);
          ((ProfileCardExtendFriendView)localObject).setTag(2131372900, Boolean.valueOf(false));
          ((ProfileCardExtendFriendView)localObject).setTag(2131372901, Boolean.valueOf(bool2));
          ((ProfileCardExtendFriendView)localObject).setTag(2131372899, ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Azfl);
          paramProfileCardFavorShowView.addView((View)localObject);
          if (!azfl.a(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Long)) {
            break label489;
          }
          ((ProfileCardExtendFriendView)localObject).setDiyCard(true);
          ((ProfileCardExtendFriendView)localObject).setProfileCardFavorShowView(paramProfileCardFavorShowView);
        }
        for (;;)
        {
          label320:
          ((ProfileCardExtendFriendView)localObject).setIsFromLimitChat(this.jdField_b_of_type_Boolean);
          ((ProfileCardExtendFriendView)localObject).a(paramCard, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          return;
          j = 0;
          break;
          label374:
          if (((View)localObject).getTag(2131372899) == null) {
            break label509;
          }
          i = 1;
          break label79;
          if (!(localObject instanceof String)) {
            break label498;
          }
          localObject = (String)localObject;
          if (!((String)localObject).startsWith("#")) {
            break label498;
          }
          i = Color.parseColor((String)localObject);
          break label183;
          label424:
          bool1 = false;
          break label208;
          if (j != 0)
          {
            localObject = new ProfileCardExtendFriendView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Azfl, bool1);
            break label237;
          }
          localObject = new ProfileCardExtendFriendView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          break label237;
          localObject = (ProfileCardExtendFriendView)localObject;
          break label320;
          label489:
          ((ProfileCardExtendFriendView)localObject).setDiyCard(false);
        }
        label498:
        i = 0;
        break label183;
        label503:
        bool1 = false;
      }
      label509:
      i = 0;
    }
  }
  
  private void a(ProfileCardFavorShowView paramProfileCardFavorShowView, Card paramCard, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = paramProfileCardFavorShowView.getChildAt(0);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((localObject1 == null) || (!Boolean.TRUE.equals(((View)localObject1).getTag(0))) || (!Boolean.valueOf(paramBoolean1).equals(((View)localObject1).getTag(1))) || (!((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Azfl.equals(((View)localObject1).getTag(2))))
    {
      paramProfileCardFavorShowView.removeAllViews();
      if ((!paramBoolean1) && (!paramBoolean2)) {
        break label315;
      }
      localObject1 = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131561411, null);
      ((View)localObject1).setTag(2131372900, Boolean.valueOf(true));
      ((View)localObject1).setTag(2131372901, Boolean.valueOf(paramBoolean1));
      ((View)localObject1).setTag(2131372899, ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Azfl);
      localObject2 = (TextView)((View)localObject1).findViewById(2131379471);
      localObject3 = (TextView)((View)localObject1).findViewById(2131379472);
      if (paramBoolean2)
      {
        localObject4 = ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Azfl.a.get("commonItemContentColor");
        if (localObject4 != null)
        {
          if (!(localObject4 instanceof ColorStateList)) {
            break label266;
          }
          ((TextView)localObject2).setTextColor((ColorStateList)localObject4);
          ((TextView)localObject3).setTextColor((ColorStateList)localObject4);
        }
      }
    }
    for (;;)
    {
      ((View)localObject1).setClickable(true);
      localObject2 = ((View)localObject1).findViewById(2131379470);
      ((View)localObject2).setOnClickListener(new azny(this, paramCard));
      paramProfileCardFavorShowView.addView((View)localObject1);
      if (paramBoolean1) {
        a(null, (View)localObject2, null);
      }
      return;
      label266:
      if ((localObject4 instanceof String))
      {
        localObject4 = (String)localObject4;
        if (((String)localObject4).startsWith("#"))
        {
          ((TextView)localObject2).setTextColor(Color.parseColor((String)localObject4));
          ((TextView)localObject3).setTextColor(Color.parseColor((String)localObject4));
          continue;
          label315:
          localObject2 = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131561410, null);
          localObject3 = ((View)localObject2).findViewById(2131376689);
          localObject4 = asmk.a("expand_summary_default_bg.png");
          localObject1 = localObject2;
          if (atwl.a((String)localObject4))
          {
            localObject1 = asmk.a((String)localObject4, null);
            localObject4 = new BitmapDrawable((Bitmap)localObject1);
            float f = ((Bitmap)localObject1).getWidth() / ((Bitmap)localObject1).getHeight();
            ((View)localObject3).setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics().widthPixels / f)));
            ((View)localObject3).setBackgroundDrawable((Drawable)localObject4);
            localObject1 = localObject2;
          }
        }
      }
    }
  }
  
  private boolean a(Card paramCard)
  {
    boolean bool = true;
    if (paramCard == null) {}
    while ((!paramCard.isShowCard) || (paramCard.extendFriendFlag != 1)) {
      return false;
    }
    if (TextUtils.equals(paramCard.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      if (paramCard.extendFriendEntryAddFriend == 0) {
        bool = false;
      }
    }
    label162:
    label165:
    for (;;)
    {
      SharedPreferences localSharedPreferences;
      if (!((asfu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264)).d())
      {
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.i("ProfileExtendFriendComponent", 4, "extend friend resource is not ready");
        return false;
        localSharedPreferences = bgsg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785");
        if (!localSharedPreferences.contains("sp_extend_friend_entry_add_friend")) {
          break label162;
        }
      }
      for (int i = localSharedPreferences.getInt("sp_extend_friend_entry_add_friend", 0);; i = 1)
      {
        if ((localSharedPreferences.getInt("sp_extend_friend_entry_add_friend", 0) != 0) && (i == 1) && (!TextUtils.isEmpty(paramCard.declaration))) {
          break label165;
        }
        bool = false;
        break;
        return bool;
      }
    }
  }
  
  private boolean a(Card paramCard, boolean paramBoolean)
  {
    boolean bool1 = true;
    if (!a(paramCard))
    {
      if (this.jdField_a_of_type_JavaLangObject != null)
      {
        this.jdField_a_of_type_JavaLangObject = null;
        return true;
      }
    }
    else
    {
      ProfileCardFavorShowView localProfileCardFavorShowView1;
      if (this.jdField_a_of_type_JavaLangObject == null)
      {
        ProfileCardFavorShowView localProfileCardFavorShowView2 = (ProfileCardFavorShowView)this.jdField_a_of_type_Azqi.a(a_());
        localProfileCardFavorShowView1 = localProfileCardFavorShowView2;
        if (localProfileCardFavorShowView2 == null)
        {
          localProfileCardFavorShowView2 = new ProfileCardFavorShowView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          localProfileCardFavorShowView2.setTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691009));
          localProfileCardFavorShowView1 = localProfileCardFavorShowView2;
          if (this.jdField_b_of_type_Boolean)
          {
            localProfileCardFavorShowView2.setShowArrow(false);
            localProfileCardFavorShowView1 = localProfileCardFavorShowView2;
          }
        }
        this.jdField_a_of_type_JavaLangObject = localProfileCardFavorShowView1;
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        localProfileCardFavorShowView1 = (ProfileCardFavorShowView)this.jdField_a_of_type_JavaLangObject;
        boolean bool2 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_Azfl != null)
        {
          if (!TextUtils.equals(paramCard.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
            break label252;
          }
          if (!TextUtils.isEmpty(paramCard.declaration)) {
            break label242;
          }
          a(localProfileCardFavorShowView1, paramCard, bool2, bool1);
          label181:
          a(localProfileCardFavorShowView1.c, paramCard);
        }
        for (;;)
        {
          paramCard = new azde(87, null);
          localProfileCardFavorShowView1.b.setTag(paramCard);
          localProfileCardFavorShowView1.b.setOnClickListener(this);
          a(localProfileCardFavorShowView1.jdField_a_of_type_AndroidWidgetTextView, null, localProfileCardFavorShowView1.jdField_a_of_type_AndroidWidgetImageView);
          return paramBoolean;
          bool1 = false;
          break;
          label242:
          a(paramCard, localProfileCardFavorShowView1);
          break label181;
          label252:
          a(paramCard, localProfileCardFavorShowView1);
        }
      }
    }
    return false;
  }
  
  private boolean c()
  {
    boolean bool = false;
    if (asfu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      if (this.jdField_b_of_type_AndroidAppDialog == null) {
        this.jdField_b_of_type_AndroidAppDialog = asmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      }
      if ((!this.jdField_b_of_type_AndroidAppDialog.isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {
        this.jdField_b_of_type_AndroidAppDialog.show();
      }
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "kuolie", "0X80097DC", 0, 0, "", "", "", "");
      bool = true;
    }
    return bool;
  }
  
  private boolean d()
  {
    if (this.jdField_b_of_type_Boolean) {}
    Card localCard;
    do
    {
      return false;
      localCard = ((anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    } while (localCard == null);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileExtendFriendComponent", 2, String.format("showExtendFriendProfileGuide declaration=%s isShowCard=%s", new Object[] { localCard.declaration, Boolean.valueOf(localCard.isShowCard) }));
    }
    if ((TextUtils.isEmpty(localCard.declaration)) && (e())) {
      return true;
    }
    int i;
    boolean bool;
    if ((TextUtils.isEmpty(localCard.declaration)) || (!localCard.isShowCard))
    {
      if (TextUtils.isEmpty(localCard.declaration))
      {
        i = 1;
        this.jdField_a_of_type_AndroidAppDialog = asmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, i, new aznz(this, localCard));
      }
      try
      {
        this.jdField_a_of_type_AndroidAppDialog.show();
        bool = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("ProfileExtendFriendComponent", 1, "showExtendFriendProfileGuide fail.", localException);
          bool = false;
          continue;
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092E7", "0X80092E7", 0, 0, "", "", "", "");
        }
      }
      if (TextUtils.isEmpty(localCard.declaration)) {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092EA", "0X80092EA", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      return bool;
      i = 2;
      break;
      bool = false;
    }
  }
  
  private boolean e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileExtendFriendComponent", 2, String.format("checkUpdateExtendInfo mExtendRequested=%s", new Object[] { Boolean.valueOf(this.e) }));
    }
    if ((this.e) || (this.jdField_a_of_type_Asgf != null)) {
      return false;
    }
    this.jdField_a_of_type_Asgf = new azoa(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Asgf);
    this.jdField_a_of_type_Biau = new biau(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_Biau.c(true);
    this.jdField_a_of_type_Biau.show();
    ((asfs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
    }
    return true;
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Azkz != null) {
      this.jdField_a_of_type_Azkz.c();
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ProfileExtendFriendComponent.7(this), 1000L);
    }
  }
  
  public int a()
  {
    return 1008;
  }
  
  public String a()
  {
    return "ProfileExtendFriendComponent";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 4097) && (paramInt2 == 8193))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(8193);
      if (this.jdField_a_of_type_Azkz != null) {
        this.jdField_a_of_type_Azkz.a();
      }
    }
  }
  
  public void a(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.a(paramBaseActivity, paramBundle);
    paramBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    if (paramBaseActivity != null)
    {
      this.jdField_a_of_type_Boolean = paramBaseActivity.getBooleanExtra("key_from_extends_friend", false);
      this.jdField_b_of_type_Boolean = paramBaseActivity.getBooleanExtra("key_from_extends_friend_limit_chat", false);
      this.c = paramBaseActivity.getBooleanExtra("key_from_limit_chat_plus", false);
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aniz);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_b_of_type_Asgf);
  }
  
  public boolean a(azfe paramazfe)
  {
    boolean bool = super.a(paramazfe);
    return a(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard, ((azfe)this.jdField_b_of_type_JavaLangObject).d) | bool;
  }
  
  public String a_()
  {
    return "map_key_extend_friend";
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (c())
    {
      bcst.b(null, "dc00898", "", "", "kuolie", "0X80097DA", 2, 0, "", "", "", "");
      bool = true;
    }
    while (!d()) {
      return bool;
    }
    return true;
  }
  
  public void d()
  {
    super.d();
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof ProfileCardFavorShowView)))
    {
      View localView = ((ProfileCardFavorShowView)this.jdField_a_of_type_JavaLangObject).a(0);
      if ((localView instanceof ProfileCardExtendFriendView)) {
        ((ProfileCardExtendFriendView)localView).b();
      }
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aniz);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_b_of_type_Asgf);
    if (this.jdField_a_of_type_Asgf != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Asgf);
      this.jdField_a_of_type_Asgf = null;
    }
    if (this.jdField_a_of_type_Biau != null)
    {
      this.jdField_a_of_type_Biau.dismiss();
      this.jdField_a_of_type_Biau = null;
    }
    super.f();
  }
  
  public void onClick(View paramView)
  {
    if (((paramView.getTag() instanceof azde)) && (((azde)paramView.getTag()).a == 87)) {
      a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aznv
 * JD-Core Version:    0.7.0.1
 */