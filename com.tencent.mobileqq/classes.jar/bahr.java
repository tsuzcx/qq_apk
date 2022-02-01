import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberCard.MemberGameInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent.3;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.troop.TroopPluginManager;
import java.util.ArrayList;
import java.util.List;

public class bahr
  extends badd
  implements View.OnClickListener
{
  private View a;
  protected aojs a;
  public volatile boolean a;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private View c;
  private View d;
  
  public bahr(baei parambaei, azxr paramazxr)
  {
    super(parambaei, paramazxr);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Aojs = new bahs(this);
  }
  
  private MessageRecord a(azxr paramazxr)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e("ProfileTroopMemInfoComponent", 2, "queryRecentMsg, mApp == null");
      return null;
    }
    String str2 = adak.b();
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    String str1 = MessageRecord.getTableName(paramazxr.jdField_a_of_type_JavaLangString, 1);
    str2 = String.format("shmsgseq < %d and senderuin = ? and extLong & 3 <> 3 and msgtype %s and isValid=1", new Object[] { Long.valueOf(9223372036854775807L), str2 });
    if (paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard != null) {}
    for (paramazxr = paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.uin;; paramazxr = paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)
    {
      paramazxr = localEntityManager.query(MessageRecord.class, str1, false, str2, new String[] { paramazxr }, null, null, "shmsgseq DESC", String.valueOf(1));
      localEntityManager.close();
      if ((paramazxr == null) || (paramazxr.isEmpty())) {
        break;
      }
      return (MessageRecord)paramazxr.get(0);
    }
  }
  
  private void a(azxr paramazxr)
  {
    ThreadManager.post(new ProfileTroopMemInfoComponent.3(this, paramazxr), 8, null, true);
  }
  
  private static void b(View paramView, azxr paramazxr, View.OnClickListener paramOnClickListener)
  {
    paramView.setVisibility(0);
    Context localContext = paramView.getContext();
    TextView localTextView = (TextView)paramView.findViewById(2131368920);
    ImageView localImageView = (ImageView)paramView.findViewById(2131362954);
    if (!TextUtils.isEmpty(paramazxr.jdField_b_of_type_JavaLangString))
    {
      localTextView.setText(paramazxr.jdField_b_of_type_JavaLangString);
      localTextView.setContentDescription(paramazxr.jdField_b_of_type_JavaLangString);
      localImageView.setVisibility(0);
      paramView.setOnClickListener(paramOnClickListener);
      return;
    }
    localTextView.setText(localContext.getString(2131696910));
    localTextView.setContentDescription(localContext.getString(2131696910));
    localImageView.setVisibility(0);
    paramView.setOnClickListener(paramOnClickListener);
  }
  
  private boolean c(azxr paramazxr)
  {
    boolean bool2 = false | d((azxr)this.jdField_b_of_type_JavaLangObject) | b((azxr)this.jdField_b_of_type_JavaLangObject) | e((azxr)this.jdField_b_of_type_JavaLangObject) | f((azxr)this.jdField_b_of_type_JavaLangObject);
    if (((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) || ((this.c != null) && (this.c.getVisibility() == 0)) || ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)) || ((this.d != null) && (this.d.getVisibility() == 0)))
    {
      bool1 = true;
      if (bool2)
      {
        if (this.jdField_a_of_type_JavaLangObject == null)
        {
          paramazxr = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          paramazxr.setOrientation(1);
          paramazxr.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
          this.jdField_a_of_type_JavaLangObject = paramazxr;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ProfileTroopMemInfoComponent", 2, new Object[] { "mViewContainer removeAllViews before show. mViewContainer=%s", this.jdField_a_of_type_JavaLangObject });
        }
        ((ViewGroup)this.jdField_a_of_type_JavaLangObject).removeAllViews();
        if ((((View)this.jdField_a_of_type_JavaLangObject).getParent() != null) && ((((View)this.jdField_a_of_type_JavaLangObject).getParent() instanceof ViewGroup))) {
          ((ViewGroup)((View)this.jdField_a_of_type_JavaLangObject).getParent()).removeView((View)this.jdField_a_of_type_JavaLangObject);
        }
        l();
        m();
        o();
        n();
      }
      if (bool1) {
        return bool2;
      }
      if (this.jdField_a_of_type_JavaLangObject != null) {
        break label347;
      }
    }
    label347:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (this.jdField_a_of_type_JavaLangObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileTroopMemInfoComponent", 2, new Object[] { "bShow = false. mViewContainer removeAllViews. mViewContainer=%s", this.jdField_a_of_type_JavaLangObject });
        }
        ((ViewGroup)this.jdField_a_of_type_JavaLangObject).removeAllViews();
      }
      this.jdField_a_of_type_JavaLangObject = null;
      return bool2 | bool1;
      bool1 = false;
      break;
    }
    return bool2;
  }
  
  private boolean d(azxr paramazxr)
  {
    boolean bool1 = true;
    boolean bool2;
    if ((!paramazxr.jdField_b_of_type_Boolean) || (paramazxr.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard == null)) {
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        bool1 = true;
        if (this.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ProfileTroopMemInfoComponent", 2, String.format("makeOrRefreshTroopMemJoinTime, Not showing mem join time", new Object[0]));
        }
        bool2 = bool1;
      }
    }
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      return bool2;
      bool1 = false;
      break;
      localObject1 = "";
      localObject2 = localObject1;
      long l;
      if (paramazxr.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.joinTime > 0L)
      {
        l = paramazxr.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.joinTime;
        if (paramazxr.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.joinTime == 1L) {}
      }
      try
      {
        localObject1 = DateFormat.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693042), 1000L * l).toString();
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d("ProfileTroopMemInfoComponent", 2, String.format("makeOrRefreshTroopMemJoinTime, timeStamp: %s, joinTime: %s", new Object[] { Long.valueOf(l), localObject1 }));
          localObject2 = localObject1;
        }
        if (TextUtils.isEmpty(localObject2)) {
          if (this.jdField_a_of_type_AndroidViewView != null)
          {
            bool2 = bool1;
            if (this.jdField_a_of_type_AndroidViewView == null) {
              continue;
            }
            this.jdField_a_of_type_AndroidViewView.setVisibility(8);
            return bool1;
          }
        }
      }
      catch (Exception paramazxr)
      {
        for (;;)
        {
          localObject1 = "";
          continue;
          bool1 = false;
        }
      }
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131563037, null);
      paramazxr = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368212);
      paramazxr.setImageResource(2130845778);
      paramazxr.clearColorFilter();
      paramazxr.setColorFilter(10067634);
    }
    for (bool1 = true;; bool1 = false)
    {
      paramazxr = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368920);
      localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362954);
      ((ImageView)localObject1).setVisibility(8);
      paramazxr.setText(localObject2);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      QLog.d("ProfileTroopMemInfoComponent", 2, "makeOrRefreshTroopMemJoinTime 05");
      a(this.jdField_a_of_type_AndroidViewView, paramazxr, null, (ImageView)localObject1);
      return bool1;
    }
  }
  
  private boolean e(azxr paramazxr)
  {
    boolean bool = false;
    if (!paramazxr.jdField_b_of_type_Boolean)
    {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        bool = true;
      }
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemInfoComponent", 2, "makeOrRefreshTroopMemRecentSaidEntry, isTroopMemberCard = false. Not showing recent said.");
      }
      return bool;
    }
    Object localObject;
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131563037, null);
      localObject = (ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368212);
      ((ImageView)localObject).setImageResource(2130845792);
      ((ImageView)localObject).clearColorFilter();
      ((ImageView)localObject).setColorFilter(10067634);
    }
    for (bool = true;; bool = false)
    {
      localObject = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368920);
      ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131362954);
      azvr localazvr = new azvr(78, null);
      this.jdField_b_of_type_AndroidViewView.setTag(localazvr);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      a(this.jdField_b_of_type_AndroidViewView, (TextView)localObject, null, localImageView);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = ((TroopPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(119)).a("troop_member_card_plugin.apk", new baht(this, paramazxr));
        if (!this.jdField_a_of_type_Boolean) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
      }
      for (;;)
      {
        a(paramazxr);
        return bool;
        b(this.jdField_b_of_type_AndroidViewView, paramazxr, this);
      }
    }
  }
  
  private boolean f(azxr paramazxr)
  {
    if ((!paramazxr.jdField_b_of_type_Boolean) || (paramazxr.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard == null) || (paramazxr.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mMemberGameInfo == null) || (TextUtils.isEmpty(paramazxr.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mMemberGameInfo.gameName)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemInfoComponent", 2, "makeOrRefreshGameTroopInfoView. Not showing game info.");
      }
      if (this.d != null) {}
      for (bool = true;; bool = false)
      {
        if (this.d != null) {
          this.d.setVisibility(8);
        }
        return bool;
      }
    }
    if (this.d == null) {
      this.d = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131561453, null);
    }
    for (boolean bool = true;; bool = false)
    {
      TextView localTextView1 = (TextView)this.d.findViewById(2131367382);
      TextView localTextView2 = (TextView)this.d.findViewById(2131367387);
      localTextView2.setBackgroundDrawable(bguq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), Color.parseColor("#3094cf")));
      Object localObject = (ImageView)this.d.findViewById(2131376070);
      TextView localTextView3 = (TextView)this.d.findViewById(2131367388);
      TextView localTextView4 = (TextView)this.d.findViewById(2131367389);
      ImageView localImageView = (ImageView)this.d.findViewById(2131362954);
      TroopMemberCard.MemberGameInfo localMemberGameInfo = paramazxr.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mMemberGameInfo;
      if (localMemberGameInfo != null)
      {
        localTextView1.setText(localMemberGameInfo.gameName);
        if ((localMemberGameInfo.descInfo != null) && (localMemberGameInfo.descInfo.size() > 0) && (!TextUtils.isEmpty((CharSequence)localMemberGameInfo.descInfo.get(0))))
        {
          localTextView3.setVisibility(0);
          localTextView3.setText((CharSequence)localMemberGameInfo.descInfo.get(0));
        }
        if ((localMemberGameInfo.descInfo != null) && (localMemberGameInfo.descInfo.size() > 1) && (!TextUtils.isEmpty((CharSequence)localMemberGameInfo.descInfo.get(1))))
        {
          localTextView4.setVisibility(0);
          localTextView4.setText((CharSequence)localMemberGameInfo.descInfo.get(1));
        }
      }
      for (;;)
      {
        try
        {
          int i = agej.a(18.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
          int j = agej.a(18.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
          if (!TextUtils.isEmpty(localMemberGameInfo.levelIcon))
          {
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mRequestHeight = i;
            localURLDrawableOptions.mRequestWidth = j;
            ((ImageView)localObject).setImageDrawable(URLDrawable.getDrawable(localMemberGameInfo.levelIcon, localURLDrawableOptions));
          }
          if (!TextUtils.isEmpty(localMemberGameInfo.levelName))
          {
            localTextView2.setVisibility(0);
            localTextView2.setText(localMemberGameInfo.levelName);
            float f = agej.a(2.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
            i = agej.a(4.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
            localObject = new GradientDrawable();
            ((GradientDrawable)localObject).setCornerRadius(f);
            localTextView2.setPadding(i, 0, i, 0);
            if (TextUtils.isEmpty(localMemberGameInfo.gameBackGroundColor)) {
              continue;
            }
            ((GradientDrawable)localObject).setColor(Color.parseColor(localMemberGameInfo.gameBackGroundColor));
            localTextView2.setBackgroundDrawable((Drawable)localObject);
          }
          if (!TextUtils.isEmpty(localMemberGameInfo.gameFontColor)) {
            localTextView2.setTextColor(Color.parseColor(localMemberGameInfo.gameFontColor));
          }
          this.jdField_b_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.d("ProfileTroopMemInfoComponent", 2, "makeOrRefreshGameTroopInfoView. Showing game info.");
          }
          bhju.a("Grp_game", "Mber_data", "game_exp", 0, 0, new String[] { paramazxr.jdField_a_of_type_JavaLangString, localMemberGameInfo.gameName });
        }
        catch (Exception paramazxr)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.profilecard.FrdProfileCard", 2, paramazxr.toString());
          continue;
        }
        paramazxr = new azvr(83, null);
        this.d.setTag(paramazxr);
        this.d.setOnClickListener(this);
        this.d.setVisibility(0);
        a(this.d, localTextView1, localTextView3, localImageView);
        a(this.d, localTextView2, localTextView4, localImageView);
        return bool;
        ((GradientDrawable)localObject).setColor(Color.parseColor("#FFBA26"));
      }
    }
  }
  
  private void j()
  {
    bade localbade = (bade)this.jdField_a_of_type_Baei.a(1002);
    if (localbade != null) {
      localbade.a((azxr)this.jdField_b_of_type_JavaLangObject);
    }
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileTroopMemInfoComponent", 2, "updateTroopUI");
    }
    badt localbadt = (badt)this.jdField_a_of_type_Baei.a(103);
    if (localbadt != null) {
      localbadt.a((azxr)this.jdField_b_of_type_JavaLangObject);
    }
  }
  
  private void l()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        if ((this.jdField_a_of_type_AndroidViewView.getParent() != null) && ((this.jdField_a_of_type_AndroidViewView.getParent() instanceof ViewGroup)))
        {
          ViewParent localViewParent = this.jdField_a_of_type_AndroidViewView.getParent();
          if (QLog.isColorLevel()) {
            QLog.d("ProfileTroopMemInfoComponent", 2, new Object[] { "remove mJoinTimeView. view=%s viewParent=%s", this.jdField_a_of_type_AndroidViewView, localViewParent });
          }
          ((ViewGroup)localViewParent).removeView(this.jdField_a_of_type_AndroidViewView);
        }
        if (QLog.isColorLevel()) {
          QLog.i("ProfileTroopMemInfoComponent", 2, "add mJoinTimeView :");
        }
        ((ViewGroup)this.jdField_a_of_type_JavaLangObject).addView(this.jdField_a_of_type_AndroidViewView);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ProfileTroopMemInfoComponent", 1, "update mJoinTimeView fail.", localException);
    }
  }
  
  private void m()
  {
    try
    {
      if (this.c != null)
      {
        if ((this.c.getParent() != null) && ((this.c.getParent() instanceof ViewGroup)))
        {
          ViewParent localViewParent = this.c.getParent();
          if (QLog.isColorLevel()) {
            QLog.d("ProfileTroopMemInfoComponent", 2, new Object[] { "remove mCharmLevelView. view=%s viewParent=%s", this.c, localViewParent });
          }
          ((ViewGroup)localViewParent).removeView(this.c);
        }
        if (QLog.isColorLevel()) {
          QLog.i("ProfileTroopMemInfoComponent", 2, "add mCharmLevelView :");
        }
        ((ViewGroup)this.jdField_a_of_type_JavaLangObject).addView(this.c);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ProfileTroopMemInfoComponent", 1, "update mCharmLevelView fail.", localException);
    }
  }
  
  private void n()
  {
    try
    {
      if (this.d != null)
      {
        if ((this.d.getParent() != null) && ((this.d.getParent() instanceof ViewGroup)))
        {
          ViewParent localViewParent = this.d.getParent();
          if (QLog.isColorLevel()) {
            QLog.d("ProfileTroopMemInfoComponent", 2, new Object[] { "remove mGameInfoView. view=%s viewParent=%s", this.d, localViewParent });
          }
          ((ViewGroup)localViewParent).removeView(this.d);
        }
        if (QLog.isColorLevel()) {
          QLog.i("ProfileTroopMemInfoComponent", 2, "add mGameInfoView :");
        }
        ((ViewGroup)this.jdField_a_of_type_JavaLangObject).addView(this.d);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ProfileTroopMemInfoComponent", 1, "update mGameInfoView fail.", localException);
    }
  }
  
  private void o()
  {
    try
    {
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        if ((this.jdField_b_of_type_AndroidViewView.getParent() != null) && ((this.jdField_b_of_type_AndroidViewView.getParent() instanceof ViewGroup)))
        {
          ViewParent localViewParent = this.jdField_b_of_type_AndroidViewView.getParent();
          if (QLog.isColorLevel()) {
            QLog.d("ProfileTroopMemInfoComponent", 2, new Object[] { "remove mRecentSaidView. view=%s viewParent=%s", this.jdField_b_of_type_AndroidViewView, localViewParent });
          }
          ((ViewGroup)localViewParent).removeView(this.jdField_b_of_type_AndroidViewView);
        }
        if (QLog.isColorLevel()) {
          QLog.i("ProfileTroopMemInfoComponent", 2, "add mRecentSaidView :");
        }
        ((ViewGroup)this.jdField_a_of_type_JavaLangObject).addView(this.jdField_b_of_type_AndroidViewView);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ProfileTroopMemInfoComponent", 1, "update mRecentSaidView fail.", localException);
    }
  }
  
  private void p()
  {
    if ((this.jdField_b_of_type_JavaLangObject == null) || (((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemInfoComponent", 2, "handleRecentSaidClick, mData == null || mData.allinone == null || mActivity == null");
      }
    }
    do
    {
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("troop_uin", ((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString);
      localIntent.putExtra("member_uin", ((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      PublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent, TroopMemberHistoryFragment.class);
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    new bdlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("recent_clk").a(new String[] { ((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString }).a();
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800A596", "0X800A596", 2, 0, "", "", "", "");
  }
  
  private void q()
  {
    if ((this.jdField_b_of_type_JavaLangObject == null) || (((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemInfoComponent", 2, "handleCharmLevelClick, mData == null || mData.allinone == null");
      }
      return;
    }
    bgtj localbgtj = bgtj.a();
    Object localObject1 = localbgtj.a("troop_rank");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    Object localObject2;
    for (localObject1 = bgtl.a(((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, ((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString);; localObject1 = localbgtj.a((String)localObject1, (bgtk)localObject2))
    {
      localObject2 = localObject1;
      if (this.jdField_b_of_type_JavaLangObject != null)
      {
        localObject2 = localObject1;
        if (bgnm.a(((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString))
        {
          localObject2 = localObject1;
          if (bgnm.a())
          {
            localObject1 = bgnm.a();
            localObject2 = new bgtk();
            ((bgtk)localObject2).c = "31";
            ((bgtk)localObject2).jdField_b_of_type_JavaLangString = ((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
            ((bgtk)localObject2).jdField_a_of_type_JavaLangString = ((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString;
            localObject2 = localbgtj.a((String)localObject1, (bgtk)localObject2);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemInfoComponent", 2, "handleCharmLevelClick, url:" + (String)localObject2);
      }
      localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", (String)localObject2);
      ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      ((Intent)localObject1).putExtra("portraitOnly", true);
      ((Intent)localObject1).putExtra("hide_more_button", true);
      ((Intent)localObject1).putExtra("hide_operation_bar", true);
      ((Intent)localObject1).putExtra("isShowAd", false);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject1);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_grade", "", "mber_card", "clk_grade", 0, 0, ((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString, "", "", "");
      new bdlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("grade_clk").a(new String[] { ((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString }).a();
      baew.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (azxr)this.jdField_b_of_type_JavaLangObject);
      return;
      localObject2 = new bgtk();
      ((bgtk)localObject2).c = "31";
      ((bgtk)localObject2).jdField_b_of_type_JavaLangString = ((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      ((bgtk)localObject2).jdField_a_of_type_JavaLangString = ((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString;
    }
  }
  
  private void r()
  {
    if ((this.jdField_b_of_type_JavaLangObject != null) && (((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard != null))
    {
      TroopMemberCard.MemberGameInfo localMemberGameInfo = ((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mMemberGameInfo;
      if (localMemberGameInfo != null)
      {
        String str = localMemberGameInfo.gameUrl;
        Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        localIntent.putExtra("url", str);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
        bhju.a("Grp_game", "Mber_data", "game_clk", 0, 0, new String[] { ((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString, localMemberGameInfo.gameName });
      }
    }
  }
  
  public int a()
  {
    return 1013;
  }
  
  public String a()
  {
    return "ProfileTroopMemInfoComponent";
  }
  
  public void a()
  {
    i();
  }
  
  public void a(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.a(paramBaseActivity, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_Aojs);
    paramBaseActivity = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString);
    a(paramBaseActivity);
    if ((paramBaseActivity != null) && (paramBaseActivity.isGameBind())) {
      bhju.a("Grp_game", "Mber_data", "mdata_exp", 0, 0, new String[] { paramBaseActivity.troopuin });
    }
  }
  
  public void a(TroopInfo paramTroopInfo)
  {
    ProfileActivity.AllInOne localAllInOne = ((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
    if ((localAllInOne != null) && (paramTroopInfo != null) && (ProfileActivity.f(localAllInOne.jdField_a_of_type_Int)) && (TextUtils.isEmpty(localAllInOne.d)))
    {
      localAllInOne.d = paramTroopInfo.troopcode;
      localAllInOne.c = paramTroopInfo.troopuin;
      if (QLog.isColorLevel()) {
        QLog.i("ProfileTroopMemInfoComponent", 2, String.format("checkAndUpdateTroopInfo troop[%s, %s]", new Object[] { paramTroopInfo.troopuin, paramTroopInfo.troopcode }));
      }
    }
  }
  
  public boolean a(azxr paramazxr)
  {
    boolean bool = super.a(paramazxr);
    return c((azxr)this.jdField_b_of_type_JavaLangObject) | bool;
  }
  
  public String a_()
  {
    return "map_key_troop_mem_info";
  }
  
  public boolean b(azxr paramazxr)
  {
    boolean bool1 = false;
    boolean bool2;
    if ((!paramazxr.jdField_b_of_type_Boolean) || (paramazxr.jdField_a_of_type_Int < 0) || (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazxr.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemInfoComponent", 2, "makeOrRefreshTroopMemCharmLevelInfo, cardInfo.isTroopMemberCard: " + paramazxr.jdField_b_of_type_Boolean + ", cardInfo.glamourLevel: " + paramazxr.jdField_a_of_type_Int + " isQidianPrivateTroop");
      }
      if (this.c != null) {
        bool1 = true;
      }
      if (this.c != null) {
        this.c.setVisibility(8);
      }
      bool2 = bool1;
      return bool2;
    }
    Object localObject;
    if (this.c == null)
    {
      this.c = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131563037, null);
      localObject = (ImageView)this.c.findViewById(2131368212);
      ((ImageView)localObject).setImageResource(2130845776);
      ((ImageView)localObject).clearColorFilter();
      ((ImageView)localObject).setColorFilter(10067634);
    }
    for (bool1 = true;; bool1 = false)
    {
      localObject = (TextView)this.c.findViewById(2131368920);
      ImageView localImageView = (ImageView)this.c.findViewById(2131362954);
      ((TextView)localObject).setText("群聊等级已达LV" + paramazxr.jdField_a_of_type_Int + " ");
      azvr localazvr = new azvr(80, null);
      this.c.setTag(localazvr);
      this.c.setOnClickListener(this);
      if ((this.jdField_b_of_type_JavaLangObject != null) && (bgnm.a(((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString)) && (bgnm.a())) {
        ((TextView)localObject).setText("群成员等级");
      }
      a(this.c, (TextView)localObject, null, localImageView);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "charm", "exp_grpname", 0, 0, String.valueOf(paramazxr.jdField_a_of_type_Int), "", "", "");
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ProfileTroopMemInfoComponent", 2, "makeOrRefreshTroopMemCharmLevelInfo, showing charm level.");
      return bool1;
    }
  }
  
  public void c()
  {
    super.c();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_Aojs);
    }
    super.f();
  }
  
  public void i()
  {
    if ((this.jdField_b_of_type_JavaLangObject == null) || (!((azxr)this.jdField_b_of_type_JavaLangObject).jdField_b_of_type_Boolean) || (((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (!bhnv.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))) {}
    label280:
    do
    {
      do
      {
        for (;;)
        {
          return;
          try
          {
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
            aoip localaoip = (aoip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
            localObject = ((TroopManager)localObject).b(((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString);
            a((TroopInfo)localObject);
            if (localObject == null) {
              break label280;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ProfileTroopMemInfoComponent", 2, "requestTroopMemberInfo.getTroopMemberCardInfo");
            }
            localaoip.a(((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString, ((TroopInfo)localObject).troopcode, localArrayList);
            localaoip.a(Long.parseLong(((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString), Long.parseLong(((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
            if (!TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ProfileTroopMemInfoComponent", 2, "requestTroopMemberInfo.requestGlobalTroopLevel");
              }
              localaoip.d(Long.parseLong(((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
              return;
            }
          }
          catch (Exception localException) {}
        }
      } while (!QLog.isColorLevel());
      QLog.i("ProfileTroopMemInfoComponent", 2, "loadTroopMemberCard:" + localException.toString());
      return;
    } while (!QLog.isColorLevel());
    QLog.d("ProfileTroopMemInfoComponent", 2, "requestTroopMemberInfo.getTroopMemberCardInfo troopInfo null");
  }
  
  public void onClick(View paramView)
  {
    azvr localazvr;
    if ((paramView.getTag() instanceof azvr))
    {
      localazvr = (azvr)paramView.getTag();
      if (localazvr.jdField_a_of_type_Int != 78) {
        break label39;
      }
      p();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label39:
      if (localazvr.jdField_a_of_type_Int == 80) {
        q();
      } else if (localazvr.jdField_a_of_type_Int == 83) {
        r();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahr
 * JD-Core Version:    0.7.0.1
 */