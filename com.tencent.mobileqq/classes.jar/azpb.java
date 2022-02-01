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

public class azpb
  extends azkr
  implements View.OnClickListener
{
  private View a;
  protected anxg a;
  public volatile boolean a;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private View c;
  private View d;
  
  public azpb(azlw paramazlw, azfe paramazfe)
  {
    super(paramazlw, paramazfe);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Anxg = new azpc(this);
  }
  
  private MessageRecord a(azfe paramazfe)
  {
    String str2 = acwh.b();
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    String str1 = MessageRecord.getTableName(paramazfe.jdField_a_of_type_JavaLangString, 1);
    str2 = String.format("shmsgseq < %d and senderuin = ? and extLong & 3 <> 3 and msgtype %s and isValid=1", new Object[] { Long.valueOf(9223372036854775807L), str2 });
    if (paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard != null) {}
    for (paramazfe = paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.uin;; paramazfe = paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)
    {
      paramazfe = localEntityManager.query(MessageRecord.class, str1, false, str2, new String[] { paramazfe }, null, null, "shmsgseq DESC", String.valueOf(1));
      localEntityManager.close();
      if ((paramazfe != null) && (!paramazfe.isEmpty())) {
        break;
      }
      return null;
    }
    return (MessageRecord)paramazfe.get(0);
  }
  
  private void a(azfe paramazfe)
  {
    ThreadManager.post(new ProfileTroopMemInfoComponent.3(this, paramazfe), 8, null, true);
  }
  
  private static void b(View paramView, azfe paramazfe, View.OnClickListener paramOnClickListener)
  {
    paramView.setVisibility(0);
    Context localContext = paramView.getContext();
    TextView localTextView = (TextView)paramView.findViewById(2131368833);
    ImageView localImageView = (ImageView)paramView.findViewById(2131362936);
    if (!TextUtils.isEmpty(paramazfe.jdField_b_of_type_JavaLangString))
    {
      localTextView.setText(paramazfe.jdField_b_of_type_JavaLangString);
      localTextView.setContentDescription(paramazfe.jdField_b_of_type_JavaLangString);
      localImageView.setVisibility(0);
      paramView.setOnClickListener(paramOnClickListener);
      return;
    }
    localTextView.setText(localContext.getString(2131696861));
    localTextView.setContentDescription(localContext.getString(2131696861));
    localImageView.setVisibility(0);
    paramView.setOnClickListener(paramOnClickListener);
  }
  
  private boolean c(azfe paramazfe)
  {
    boolean bool3 = false | d((azfe)this.jdField_b_of_type_JavaLangObject) | b((azfe)this.jdField_b_of_type_JavaLangObject) | e((azfe)this.jdField_b_of_type_JavaLangObject) | f((azfe)this.jdField_b_of_type_JavaLangObject);
    boolean bool2;
    if (((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) || ((this.c != null) && (this.c.getVisibility() == 0)) || ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)) || ((this.d != null) && (this.d.getVisibility() == 0)))
    {
      bool1 = true;
      if (bool3)
      {
        if (this.jdField_a_of_type_JavaLangObject == null)
        {
          paramazfe = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          paramazfe.setOrientation(1);
          paramazfe.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
          this.jdField_a_of_type_JavaLangObject = paramazfe;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ProfileTroopMemInfoComponent", 2, new Object[] { "mViewContainer removeAllViews before show. mViewContainer=%s", this.jdField_a_of_type_JavaLangObject });
        }
        ((ViewGroup)this.jdField_a_of_type_JavaLangObject).removeAllViews();
        l();
        m();
        o();
        n();
      }
      bool2 = bool3;
      if (!bool1) {
        if (this.jdField_a_of_type_JavaLangObject != null) {
          break label302;
        }
      }
    }
    label302:
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool3 | bool1;
      if (this.jdField_a_of_type_JavaLangObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileTroopMemInfoComponent", 2, new Object[] { "bShow = false. mViewContainer removeAllViews. mViewContainer=%s", this.jdField_a_of_type_JavaLangObject });
        }
        ((ViewGroup)this.jdField_a_of_type_JavaLangObject).removeAllViews();
      }
      this.jdField_a_of_type_JavaLangObject = null;
      return bool2;
      bool1 = false;
      break;
    }
  }
  
  private boolean d(azfe paramazfe)
  {
    boolean bool1 = true;
    boolean bool2;
    if ((!paramazfe.jdField_b_of_type_Boolean) || (paramazfe.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard == null)) {
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
      if (paramazfe.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.joinTime > 0L)
      {
        l = paramazfe.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.joinTime;
        if (paramazfe.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.joinTime == 1L) {}
      }
      try
      {
        localObject1 = DateFormat.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693033), 1000L * l).toString();
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
      catch (Exception paramazfe)
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
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131563002, null);
      paramazfe = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368138);
      paramazfe.setImageResource(2130845763);
      paramazfe.clearColorFilter();
      paramazfe.setColorFilter(10067634);
    }
    for (bool1 = true;; bool1 = false)
    {
      paramazfe = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368833);
      localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362936);
      ((ImageView)localObject1).setVisibility(8);
      paramazfe.setText(localObject2);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      QLog.d("ProfileTroopMemInfoComponent", 2, "makeOrRefreshTroopMemJoinTime 05");
      a(this.jdField_a_of_type_AndroidViewView, paramazfe, null, (ImageView)localObject1);
      return bool1;
    }
  }
  
  private boolean e(azfe paramazfe)
  {
    boolean bool = false;
    if (!paramazfe.jdField_b_of_type_Boolean)
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
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131563002, null);
      localObject = (ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368138);
      ((ImageView)localObject).setImageResource(2130845777);
      ((ImageView)localObject).clearColorFilter();
      ((ImageView)localObject).setColorFilter(10067634);
    }
    for (bool = true;; bool = false)
    {
      localObject = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368833);
      ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131362936);
      azde localazde = new azde(78, null);
      this.jdField_b_of_type_AndroidViewView.setTag(localazde);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      a(this.jdField_b_of_type_AndroidViewView, (TextView)localObject, null, localImageView);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = ((TroopPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(119)).a("troop_member_card_plugin.apk", new azpd(this, paramazfe));
        if (!this.jdField_a_of_type_Boolean) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
      }
      for (;;)
      {
        a(paramazfe);
        return bool;
        b(this.jdField_b_of_type_AndroidViewView, paramazfe, this);
      }
    }
  }
  
  private boolean f(azfe paramazfe)
  {
    if ((!paramazfe.jdField_b_of_type_Boolean) || (paramazfe.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard == null) || (paramazfe.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mMemberGameInfo == null) || (TextUtils.isEmpty(paramazfe.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mMemberGameInfo.gameName)))
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
      this.d = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131561412, null);
    }
    for (boolean bool = true;; bool = false)
    {
      TextView localTextView1 = (TextView)this.d.findViewById(2131367323);
      TextView localTextView2 = (TextView)this.d.findViewById(2131367328);
      localTextView2.setBackgroundDrawable(bfup.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), Color.parseColor("#3094cf")));
      Object localObject = (ImageView)this.d.findViewById(2131375930);
      TextView localTextView3 = (TextView)this.d.findViewById(2131367329);
      TextView localTextView4 = (TextView)this.d.findViewById(2131367330);
      ImageView localImageView = (ImageView)this.d.findViewById(2131362936);
      TroopMemberCard.MemberGameInfo localMemberGameInfo = paramazfe.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mMemberGameInfo;
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
          int i = afur.a(18.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
          int j = afur.a(18.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
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
            float f = afur.a(2.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
            i = afur.a(4.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
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
          bgjt.a("Grp_game", "Mber_data", "game_exp", 0, 0, new String[] { paramazfe.jdField_a_of_type_JavaLangString, localMemberGameInfo.gameName });
        }
        catch (Exception paramazfe)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.profilecard.FrdProfileCard", 2, paramazfe.toString());
          continue;
        }
        paramazfe = new azde(83, null);
        this.d.setTag(paramazfe);
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
    azks localazks = (azks)this.jdField_a_of_type_Azlw.a(1002);
    if (localazks != null) {
      localazks.a((azfe)this.jdField_b_of_type_JavaLangObject);
    }
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileTroopMemInfoComponent", 2, "updateTroopUI");
    }
    azlh localazlh = (azlh)this.jdField_a_of_type_Azlw.a(103);
    if (localazlh != null) {
      localazlh.a((azfe)this.jdField_b_of_type_JavaLangObject);
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
    if ((this.jdField_b_of_type_JavaLangObject == null) || (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemInfoComponent", 2, "handleRecentSaidClick, mData == null || mData.allinone == null");
      }
      return;
    }
    ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString, ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    Intent localIntent = new Intent();
    localIntent.putExtra("troop_uin", ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString);
    localIntent.putExtra("member_uin", ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    PublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent, TroopMemberHistoryFragment.class);
    new bcsy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("recent_clk").a(new String[] { ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString }).a();
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800A596", "0X800A596", 2, 0, "", "", "", "");
  }
  
  private void q()
  {
    if ((this.jdField_b_of_type_JavaLangObject == null) || (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemInfoComponent", 2, "handleCharmLevelClick, mData == null || mData.allinone == null");
      }
      return;
    }
    bfti localbfti = bfti.a();
    Object localObject1 = localbfti.a("troop_rank");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    Object localObject2;
    for (localObject1 = bftk.a(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString);; localObject1 = localbfti.a((String)localObject1, (bftj)localObject2))
    {
      localObject2 = localObject1;
      if (this.jdField_b_of_type_JavaLangObject != null)
      {
        localObject2 = localObject1;
        if (bfnl.a(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString))
        {
          localObject2 = localObject1;
          if (bfnl.a())
          {
            localObject1 = bfnl.a();
            localObject2 = new bftj();
            ((bftj)localObject2).c = "31";
            ((bftj)localObject2).jdField_b_of_type_JavaLangString = ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
            ((bftj)localObject2).jdField_a_of_type_JavaLangString = ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString;
            localObject2 = localbfti.a((String)localObject1, (bftj)localObject2);
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
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_grade", "", "mber_card", "clk_grade", 0, 0, ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString, "", "", "");
      new bcsy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("grade_clk").a(new String[] { ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString }).a();
      azmk.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (azfe)this.jdField_b_of_type_JavaLangObject);
      return;
      localObject2 = new bftj();
      ((bftj)localObject2).c = "31";
      ((bftj)localObject2).jdField_b_of_type_JavaLangString = ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      ((bftj)localObject2).jdField_a_of_type_JavaLangString = ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString;
    }
  }
  
  private void r()
  {
    if ((this.jdField_b_of_type_JavaLangObject != null) && (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard != null))
    {
      TroopMemberCard.MemberGameInfo localMemberGameInfo = ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mMemberGameInfo;
      if (localMemberGameInfo != null)
      {
        String str = localMemberGameInfo.gameUrl;
        Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        localIntent.putExtra("url", str);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
        bgjt.a("Grp_game", "Mber_data", "game_clk", 0, 0, new String[] { ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString, localMemberGameInfo.gameName });
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
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_Anxg);
    paramBaseActivity = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString);
    a(paramBaseActivity);
    if ((paramBaseActivity != null) && (paramBaseActivity.isGameBind())) {
      bgjt.a("Grp_game", "Mber_data", "mdata_exp", 0, 0, new String[] { paramBaseActivity.troopuin });
    }
  }
  
  public void a(TroopInfo paramTroopInfo)
  {
    ProfileActivity.AllInOne localAllInOne = ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
    if ((localAllInOne != null) && (paramTroopInfo != null) && (ProfileActivity.f(localAllInOne.jdField_a_of_type_Int)) && (TextUtils.isEmpty(localAllInOne.d)))
    {
      localAllInOne.d = paramTroopInfo.troopcode;
      localAllInOne.c = paramTroopInfo.troopuin;
      if (QLog.isColorLevel()) {
        QLog.i("ProfileTroopMemInfoComponent", 2, String.format("checkAndUpdateTroopInfo troop[%s, %s]", new Object[] { paramTroopInfo.troopuin, paramTroopInfo.troopcode }));
      }
    }
  }
  
  public boolean a(azfe paramazfe)
  {
    boolean bool = super.a(paramazfe);
    return c((azfe)this.jdField_b_of_type_JavaLangObject) | bool;
  }
  
  public String a_()
  {
    return "map_key_troop_mem_info";
  }
  
  public boolean b(azfe paramazfe)
  {
    boolean bool1 = false;
    boolean bool2;
    if ((!paramazfe.jdField_b_of_type_Boolean) || (paramazfe.jdField_a_of_type_Int < 0) || (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazfe.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemInfoComponent", 2, "makeOrRefreshTroopMemCharmLevelInfo, cardInfo.isTroopMemberCard: " + paramazfe.jdField_b_of_type_Boolean + ", cardInfo.glamourLevel: " + paramazfe.jdField_a_of_type_Int + " isQidianPrivateTroop");
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
      this.c = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131563002, null);
      localObject = (ImageView)this.c.findViewById(2131368138);
      ((ImageView)localObject).setImageResource(2130845761);
      ((ImageView)localObject).clearColorFilter();
      ((ImageView)localObject).setColorFilter(10067634);
    }
    for (bool1 = true;; bool1 = false)
    {
      localObject = (TextView)this.c.findViewById(2131368833);
      ImageView localImageView = (ImageView)this.c.findViewById(2131362936);
      ((TextView)localObject).setText("群聊等级已达LV" + paramazfe.jdField_a_of_type_Int + " ");
      azde localazde = new azde(80, null);
      this.c.setTag(localazde);
      this.c.setOnClickListener(this);
      if ((this.jdField_b_of_type_JavaLangObject != null) && (bfnl.a(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString)) && (bfnl.a())) {
        ((TextView)localObject).setText("群成员等级");
      }
      a(this.c, (TextView)localObject, null, localImageView);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "charm", "exp_grpname", 0, 0, String.valueOf(paramazfe.jdField_a_of_type_Int), "", "", "");
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
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_Anxg);
    }
    super.f();
  }
  
  public void i()
  {
    if ((this.jdField_b_of_type_JavaLangObject == null) || (!((azfe)this.jdField_b_of_type_JavaLangObject).jdField_b_of_type_Boolean) || (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (!bgnt.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))) {}
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
            localArrayList.add(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
            anwd localanwd = (anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
            localObject = ((TroopManager)localObject).b(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString);
            a((TroopInfo)localObject);
            if (localObject == null) {
              break label280;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ProfileTroopMemInfoComponent", 2, "requestTroopMemberInfo.getTroopMemberCardInfo");
            }
            localanwd.a(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString, ((TroopInfo)localObject).troopcode, localArrayList);
            localanwd.a(Long.parseLong(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString), Long.parseLong(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
            if (!TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ProfileTroopMemInfoComponent", 2, "requestTroopMemberInfo.requestGlobalTroopLevel");
              }
              localanwd.d(Long.parseLong(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
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
    azde localazde;
    if ((paramView.getTag() instanceof azde))
    {
      localazde = (azde)paramView.getTag();
      if (localazde.jdField_a_of_type_Int != 78) {
        break label39;
      }
      p();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label39:
      if (localazde.jdField_a_of_type_Int == 80) {
        q();
      } else if (localazde.jdField_a_of_type_Int == 83) {
        r();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpb
 * JD-Core Version:    0.7.0.1
 */