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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberCard.MemberGameInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent.3;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.troop.TroopPluginManager;
import java.util.ArrayList;
import java.util.List;

public class bacf
  extends azwo
  implements View.OnClickListener
{
  private View a;
  protected aofu a;
  public volatile boolean a;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private View c;
  private View d;
  
  public bacf(azxt paramazxt, azrb paramazrb)
  {
    super(paramazxt, paramazrb);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Aofu = new bacg(this);
  }
  
  private MessageRecord a(azrb paramazrb)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e("ProfileTroopMemInfoComponent", 2, "queryRecentMsg, mApp == null");
      return null;
    }
    String str2 = acnh.b();
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    String str1 = MessageRecord.getTableName(paramazrb.jdField_a_of_type_JavaLangString, 1);
    str2 = String.format("shmsgseq < %d and senderuin = ? and extLong & 3 <> 3 and msgtype %s and isValid=1", new Object[] { Long.valueOf(9223372036854775807L), str2 });
    if (paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard != null) {}
    for (paramazrb = paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.uin;; paramazrb = paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)
    {
      paramazrb = localEntityManager.query(MessageRecord.class, str1, false, str2, new String[] { paramazrb }, null, null, "shmsgseq DESC", String.valueOf(1));
      localEntityManager.close();
      if ((paramazrb == null) || (paramazrb.isEmpty())) {
        break;
      }
      return (MessageRecord)paramazrb.get(0);
    }
  }
  
  private void a(azrb paramazrb)
  {
    ThreadManager.post(new ProfileTroopMemInfoComponent.3(this, paramazrb), 8, null, true);
  }
  
  private static void b(View paramView, azrb paramazrb, View.OnClickListener paramOnClickListener)
  {
    paramView.setVisibility(0);
    Context localContext = paramView.getContext();
    TextView localTextView = (TextView)paramView.findViewById(2131369107);
    ImageView localImageView = (ImageView)paramView.findViewById(2131362985);
    if (!TextUtils.isEmpty(paramazrb.jdField_b_of_type_JavaLangString))
    {
      localTextView.setText(paramazrb.jdField_b_of_type_JavaLangString);
      localTextView.setContentDescription(paramazrb.jdField_b_of_type_JavaLangString);
      localImageView.setVisibility(0);
      paramView.setOnClickListener(paramOnClickListener);
      return;
    }
    localTextView.setText(localContext.getString(2131697329));
    localTextView.setContentDescription(localContext.getString(2131697329));
    localImageView.setVisibility(0);
    paramView.setOnClickListener(paramOnClickListener);
  }
  
  private boolean c(azrb paramazrb)
  {
    boolean bool2 = false | d((azrb)this.jdField_b_of_type_JavaLangObject) | b((azrb)this.jdField_b_of_type_JavaLangObject) | e((azrb)this.jdField_b_of_type_JavaLangObject) | f((azrb)this.jdField_b_of_type_JavaLangObject);
    if (((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) || ((this.c != null) && (this.c.getVisibility() == 0)) || ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)) || ((this.d != null) && (this.d.getVisibility() == 0)))
    {
      bool1 = true;
      if (bool2)
      {
        if (this.jdField_a_of_type_JavaLangObject == null)
        {
          paramazrb = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          paramazrb.setOrientation(1);
          paramazrb.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
          this.jdField_a_of_type_JavaLangObject = paramazrb;
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
  
  private boolean d(azrb paramazrb)
  {
    boolean bool1 = true;
    boolean bool2;
    if ((!paramazrb.jdField_b_of_type_Boolean) || (paramazrb.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard == null)) {
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
      if (paramazrb.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.joinTime > 0L)
      {
        l = paramazrb.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.joinTime;
        if (paramazrb.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.joinTime == 1L) {}
      }
      try
      {
        localObject1 = DateFormat.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693264), 1000L * l).toString();
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
      catch (Exception paramazrb)
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
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131562992, null);
      paramazrb = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368381);
      paramazrb.setImageResource(2130845766);
      paramazrb.clearColorFilter();
      paramazrb.setColorFilter(10067634);
    }
    for (bool1 = true;; bool1 = false)
    {
      paramazrb = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369107);
      localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362985);
      ((ImageView)localObject1).setVisibility(8);
      paramazrb.setText(localObject2);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      QLog.d("ProfileTroopMemInfoComponent", 2, "makeOrRefreshTroopMemJoinTime 05");
      a(this.jdField_a_of_type_AndroidViewView, paramazrb, null, (ImageView)localObject1);
      return bool1;
    }
  }
  
  private boolean e(azrb paramazrb)
  {
    boolean bool = false;
    if (!paramazrb.jdField_b_of_type_Boolean)
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
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131562992, null);
      localObject = (ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368381);
      ((ImageView)localObject).setImageResource(2130845780);
      ((ImageView)localObject).clearColorFilter();
      ((ImageView)localObject).setColorFilter(10067634);
    }
    for (bool = true;; bool = false)
    {
      localObject = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369107);
      ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131362985);
      azpb localazpb = new azpb(78, null);
      this.jdField_b_of_type_AndroidViewView.setTag(localazpb);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      a(this.jdField_b_of_type_AndroidViewView, (TextView)localObject, null, localImageView);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = ((TroopPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_PLUGIN_MANAGER)).a("troop_member_card_plugin.apk", new bach(this, paramazrb));
        if (!this.jdField_a_of_type_Boolean) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
      }
      for (;;)
      {
        a(paramazrb);
        return bool;
        b(this.jdField_b_of_type_AndroidViewView, paramazrb, this);
      }
    }
  }
  
  private boolean f(azrb paramazrb)
  {
    if ((!paramazrb.jdField_b_of_type_Boolean) || (paramazrb.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard == null) || (paramazrb.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mMemberGameInfo == null) || (TextUtils.isEmpty(paramazrb.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mMemberGameInfo.gameName)))
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
      this.d = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131561399, null);
    }
    for (boolean bool = true;; bool = false)
    {
      TextView localTextView1 = (TextView)this.d.findViewById(2131367540);
      TextView localTextView2 = (TextView)this.d.findViewById(2131367545);
      localTextView2.setBackgroundDrawable(TroopUtils.getTroopLevelBgDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), Color.parseColor("#3094cf")));
      Object localObject = (ImageView)this.d.findViewById(2131376081);
      TextView localTextView3 = (TextView)this.d.findViewById(2131367546);
      TextView localTextView4 = (TextView)this.d.findViewById(2131367547);
      ImageView localImageView = (ImageView)this.d.findViewById(2131362985);
      TroopMemberCard.MemberGameInfo localMemberGameInfo = paramazrb.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mMemberGameInfo;
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
          int i = AIOUtils.dp2px(18.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
          int j = AIOUtils.dp2px(18.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
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
            float f = AIOUtils.dp2px(2.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
            i = AIOUtils.dp2px(4.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
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
          bhbu.a("Grp_game", "Mber_data", "game_exp", 0, 0, new String[] { paramazrb.jdField_a_of_type_JavaLangString, localMemberGameInfo.gameName });
        }
        catch (Exception paramazrb)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.profilecard.FrdProfileCard", 2, paramazrb.toString());
          continue;
        }
        paramazrb = new azpb(83, null);
        this.d.setTag(paramazrb);
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
    azwp localazwp = (azwp)this.jdField_a_of_type_Azxt.a(1002);
    if (localazwp != null) {
      localazwp.a((azrb)this.jdField_b_of_type_JavaLangObject);
    }
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileTroopMemInfoComponent", 2, "updateTroopUI");
    }
    azxe localazxe = (azxe)this.jdField_a_of_type_Azxt.a(103);
    if (localazxe != null) {
      localazxe.a((azrb)this.jdField_b_of_type_JavaLangObject);
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
    if ((this.jdField_b_of_type_JavaLangObject == null) || (((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemInfoComponent", 2, "handleRecentSaidClick, mData == null || mData.allinone == null || mActivity == null");
      }
    }
    do
    {
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("troop_uin", ((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString);
      localIntent.putExtra("member_uin", ((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      PublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent, TroopMemberHistoryFragment.class);
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    new bdlf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("recent_clk").a(new String[] { ((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString }).a();
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800A596", "0X800A596", 2, 0, "", "", "", "");
  }
  
  private void q()
  {
    if ((this.jdField_b_of_type_JavaLangObject == null) || (((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemInfoComponent", 2, "handleCharmLevelClick, mData == null || mData.allinone == null");
      }
      return;
    }
    bgld localbgld = bgld.a();
    Object localObject2 = bglf.a();
    Object localObject1 = localObject2;
    if (this.jdField_b_of_type_JavaLangObject != null)
    {
      localObject1 = localObject2;
      if (bgek.a(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString))
      {
        localObject1 = localObject2;
        if (bgek.a()) {
          localObject1 = bgek.a();
        }
      }
    }
    localObject2 = new bgle();
    ((bgle)localObject2).c = "31";
    ((bgle)localObject2).jdField_b_of_type_JavaLangString = ((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    ((bgle)localObject2).jdField_a_of_type_JavaLangString = ((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString;
    localObject1 = localbgld.a((String)localObject1, (bgle)localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemInfoComponent", 2, "handleCharmLevelClick, url:" + (String)localObject1);
    }
    localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("url", (String)localObject1);
    ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    ((Intent)localObject2).putExtra("portraitOnly", true);
    ((Intent)localObject2).putExtra("hide_more_button", true);
    ((Intent)localObject2).putExtra("hide_operation_bar", true);
    ((Intent)localObject2).putExtra("isShowAd", false);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_grade", "", "mber_card", "clk_grade", 0, 0, ((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString, "", "", "");
    new bdlf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("grade_clk").a(new String[] { ((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString }).a();
    azyh.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (azrb)this.jdField_b_of_type_JavaLangObject);
  }
  
  private void r()
  {
    if ((this.jdField_b_of_type_JavaLangObject != null) && (((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard != null))
    {
      TroopMemberCard.MemberGameInfo localMemberGameInfo = ((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mMemberGameInfo;
      if (localMemberGameInfo != null)
      {
        String str = localMemberGameInfo.gameUrl;
        Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        localIntent.putExtra("url", str);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
        bhbu.a("Grp_game", "Mber_data", "game_clk", 0, 0, new String[] { ((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString, localMemberGameInfo.gameName });
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
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_Aofu);
    paramBaseActivity = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString);
    a(paramBaseActivity);
    if ((paramBaseActivity != null) && (paramBaseActivity.isGameBind())) {
      bhbu.a("Grp_game", "Mber_data", "mdata_exp", 0, 0, new String[] { paramBaseActivity.troopuin });
    }
  }
  
  public void a(TroopInfo paramTroopInfo)
  {
    ProfileActivity.AllInOne localAllInOne = ((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
    if ((localAllInOne != null) && (paramTroopInfo != null) && (ProfileActivity.f(localAllInOne.jdField_a_of_type_Int)) && (TextUtils.isEmpty(localAllInOne.d)))
    {
      localAllInOne.d = paramTroopInfo.troopcode;
      localAllInOne.c = paramTroopInfo.troopuin;
      if (QLog.isColorLevel()) {
        QLog.i("ProfileTroopMemInfoComponent", 2, String.format("checkAndUpdateTroopInfo troop[%s, %s]", new Object[] { paramTroopInfo.troopuin, paramTroopInfo.troopcode }));
      }
    }
  }
  
  public boolean a(azrb paramazrb)
  {
    boolean bool = super.a(paramazrb);
    return c((azrb)this.jdField_b_of_type_JavaLangObject) | bool;
  }
  
  public String a_()
  {
    return "map_key_troop_mem_info";
  }
  
  public boolean b(azrb paramazrb)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if ((!paramazrb.jdField_b_of_type_Boolean) || (paramazrb.jdField_a_of_type_Int < 0) || (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazrb.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemInfoComponent", 2, "makeOrRefreshTroopMemCharmLevelInfo, cardInfo.isTroopMemberCard: " + paramazrb.jdField_b_of_type_Boolean + ", cardInfo.glamourLevel: " + paramazrb.jdField_a_of_type_Int + " isQidianPrivateTroop");
      }
      if (this.c != null) {
        bool1 = true;
      }
      bool2 = bool1;
      if (this.c != null)
      {
        this.c.setVisibility(8);
        bool2 = bool1;
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      return bool2;
    }
    Object localObject;
    if (this.c == null)
    {
      this.c = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131562992, null);
      localObject = (ImageView)this.c.findViewById(2131368381);
      ((ImageView)localObject).setImageResource(2130845761);
      ((ImageView)localObject).clearColorFilter();
      ((ImageView)localObject).setColorFilter(10067634);
    }
    for (bool1 = true;; bool1 = false)
    {
      localObject = (TextView)this.c.findViewById(2131369107);
      ImageView localImageView = (ImageView)this.c.findViewById(2131362985);
      ((TextView)localObject).setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693265));
      azpb localazpb = new azpb(80, null);
      this.c.setTag(localazpb);
      this.c.setOnClickListener(this);
      a(this.c, (TextView)localObject, null, localImageView);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "charm", "exp_grpname", 0, 0, String.valueOf(paramazrb.jdField_a_of_type_Int), "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemInfoComponent", 2, "makeOrRefreshTroopMemCharmLevelInfo, showing charm level.");
      }
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
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_Aofu);
    }
    super.f();
  }
  
  public void i()
  {
    if ((this.jdField_b_of_type_JavaLangObject == null) || (!((azrb)this.jdField_b_of_type_JavaLangObject).jdField_b_of_type_Boolean) || (((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))) {}
    label282:
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
            localArrayList.add(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            aoep localaoep = (aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
            localObject = ((TroopManager)localObject).b(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString);
            a((TroopInfo)localObject);
            if (localObject == null) {
              break label282;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ProfileTroopMemInfoComponent", 2, "requestTroopMemberInfo.getTroopMemberCardInfo");
            }
            localaoep.a(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString, ((TroopInfo)localObject).troopcode, localArrayList);
            localaoep.a(Long.parseLong(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString), Long.parseLong(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
            if (!TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ProfileTroopMemInfoComponent", 2, "requestTroopMemberInfo.requestGlobalTroopLevel");
              }
              localaoep.d(Long.parseLong(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
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
    azpb localazpb;
    if ((paramView.getTag() instanceof azpb))
    {
      localazpb = (azpb)paramView.getTag();
      if (localazpb.jdField_a_of_type_Int != 78) {
        break label39;
      }
      p();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label39:
      if (localazpb.jdField_a_of_type_Int == 80) {
        q();
      } else if (localazpb.jdField_a_of_type_Int == 83) {
        r();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bacf
 * JD-Core Version:    0.7.0.1
 */