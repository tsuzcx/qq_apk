import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.profile.ProfileGameInfo;
import com.tencent.mobileqq.profile.ProfileGameInfo.UserHeroInfo;
import com.tencent.mobileqq.profilecard.bussiness.troopgame.ProfileTroopMemGameInfoComponent.2;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.text.NumberFormat;
import java.util.ArrayList;

public class bacu
  extends azwo
  implements AbsListView.OnScrollListener
{
  protected aofu a;
  private ProfileGameInfo jdField_a_of_type_ComTencentMobileqqProfileProfileGameInfo;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public bacu(azxt paramazxt, azrb paramazrb)
  {
    super(paramazxt, paramazrb);
    this.jdField_a_of_type_Aofu = new bacv(this);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (paramInt / 100000 >= 8)
    {
      localObject1 = (ImageView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131377986);
      localObject2 = bhbt.a(bhbt.e(paramInt));
      if (localObject2 != null) {
        ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
      }
      localObject1 = (TextView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131377992);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693226, new Object[] { String.valueOf(paramInt % 10000) });
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((TextView)localObject1).setText((CharSequence)localObject2);
      }
      if (paramBoolean) {
        ((TextView)localObject1).setTextColor(-1);
      }
    }
    for (;;)
    {
      localObject1 = (ImageView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131376081);
      localObject2 = bhbt.a(bhbt.d(paramInt));
      if (localObject2 != null) {
        ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
      }
      localObject1 = (TextView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131376085);
      localObject2 = bhbt.c(paramInt);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((TextView)localObject1).setText((CharSequence)localObject2);
      }
      if (paramBoolean) {
        ((TextView)localObject1).setTextColor(-1);
      }
      return;
      localObject1 = (ImageView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131376084);
      localObject2 = bhbt.a(bhbt.e(paramInt));
      if (localObject2 != null) {
        ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
      }
      localObject1 = (ImageView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131376083);
      localObject2 = bhbt.a(bhbt.f(paramInt));
      if (localObject2 != null) {
        ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    boolean bool;
    if ((!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder().append("requestGameCardInfo.isNetworkAvailable = false, mApp is null: ");
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          break label60;
        }
        bool = true;
        QLog.d("ProfileTroopMemGameInfoComponent", 2, bool);
      }
    }
    label60:
    aoep localaoep;
    do
    {
      return;
      bool = false;
      break;
      localaoep = (aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    } while (localaoep == null);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTroopMemGameInfoComponent", 2, "requestGameCardInfo.getTroopMemberGameCard");
    }
    localaoep.g(String.valueOf(paramString1), String.valueOf(paramString2));
  }
  
  private void a(boolean paramBoolean)
  {
    ImageView localImageView = (ImageView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131367516);
    Bitmap localBitmap = bhbt.a(bhbt.a(paramBoolean));
    if (localBitmap != null) {
      localImageView.setImageBitmap(localBitmap);
    }
  }
  
  private boolean a(azrb paramazrb, boolean paramBoolean)
  {
    TextView localTextView = (TextView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131367546);
    Object localObject = a(paramazrb);
    if (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
      localObject = anvx.a(2131707937);
    }
    localTextView.setText(String.format("%s%s", new Object[] { localObject, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693267) }));
    a((View)this.jdField_a_of_type_JavaLangObject, localTextView, null, null);
    paramazrb = (TextView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131367517);
    localObject = ((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131367532);
    if (paramBoolean)
    {
      ((ImageView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131368381)).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130845765));
      paramazrb.setTextColor(Color.parseColor("#98989F"));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileGameInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileGameInfo.isEmpty()))
    {
      ((View)localObject).setVisibility(8);
      return true;
    }
    paramazrb.setText(2131693200);
    ((View)localObject).setVisibility(0);
    return false;
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    TextView localTextView1 = (TextView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131379307);
    localTextView1.setText(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileGameInfo.gamesTotal));
    TextView localTextView2 = (TextView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131371763);
    localTextView2.setText(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileGameInfo.mvpTotal));
    TextView localTextView3 = (TextView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131381491);
    try
    {
      Object localObject1 = NumberFormat.getPercentInstance();
      ((NumberFormat)localObject1).setMaximumFractionDigits(2);
      localTextView3.setText(((NumberFormat)localObject1).format(this.jdField_a_of_type_ComTencentMobileqqProfileProfileGameInfo.seasonWinRate));
      localObject1 = (TextView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131367770);
      Object localObject2 = bhbt.h(this.jdField_a_of_type_ComTencentMobileqqProfileProfileGameInfo.bestOccupation);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((TextView)localObject1).setText((CharSequence)localObject2);
      }
      if (paramBoolean)
      {
        localTextView1.setTextColor(-1);
        localTextView2.setTextColor(-1);
        localTextView3.setTextColor(-1);
        ((TextView)localObject1).setTextColor(-1);
        localTextView1 = (TextView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131379306);
        localTextView2 = (TextView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131371762);
        localTextView3 = (TextView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131381490);
        localObject1 = (TextView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131367769);
        localObject2 = (TextView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131367768);
        localTextView1.setTextColor(Color.parseColor("#98989F"));
        localTextView2.setTextColor(Color.parseColor("#98989F"));
        localTextView3.setTextColor(Color.parseColor("#98989F"));
        ((TextView)localObject1).setTextColor(Color.parseColor("#98989F"));
        ((TextView)localObject2).setTextColor(Color.parseColor("#98989F"));
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private boolean b()
  {
    boolean bool1 = false;
    if (this.jdField_b_of_type_JavaLangObject == null) {}
    boolean bool2;
    do
    {
      do
      {
        do
        {
          return bool1;
        } while (bdvn.a());
        if (!((azrb)this.jdField_b_of_type_JavaLangObject).jdField_b_of_type_Boolean) {
          break;
        }
        bool2 = c();
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("ProfileTroopMemGameInfoComponent", 2, "shouldShowGameCard. shouldShowTroopMemberGameCard = " + bool2);
      return bool2;
      bool2 = h();
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("ProfileTroopMemGameInfoComponent", 2, "shouldShowGameCard. personalGameCardSwitchEnabled = " + bool2);
    return bool2;
  }
  
  private boolean b(azrb paramazrb)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      a();
      return false;
    }
    boolean bool2 = false | c((azrb)this.jdField_b_of_type_JavaLangObject);
    boolean bool1;
    if ((this.jdField_a_of_type_JavaLangObject != null) && (((View)this.jdField_a_of_type_JavaLangObject).getVisibility() == 0))
    {
      bool1 = true;
      if (bool2)
      {
        if (!((azrb)this.jdField_b_of_type_JavaLangObject).jdField_b_of_type_Boolean) {
          break label188;
        }
        bhbu.a("Grp_mber", "mber_card", "game_switch", 0, 0, new String[] { ((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString });
        label97:
        if (this.jdField_a_of_type_Azww != null) {
          this.jdField_a_of_type_Azww.b();
        }
      }
      if (bool1) {
        break label200;
      }
      if (this.jdField_a_of_type_JavaLangObject != null) {
        break label195;
      }
      bool1 = true;
      label126:
      if (this.jdField_a_of_type_JavaLangObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileTroopMemGameInfoComponent", 2, new Object[] { "bShow = false. mViewContainer removeAllViews. mViewContainer=%s", this.jdField_a_of_type_JavaLangObject });
        }
        ((ViewGroup)this.jdField_a_of_type_JavaLangObject).removeAllViews();
      }
      this.jdField_a_of_type_JavaLangObject = null;
      bool2 |= bool1;
    }
    label188:
    label195:
    label200:
    for (;;)
    {
      return bool2;
      bool1 = false;
      break;
      l();
      break label97;
      bool1 = false;
      break label126;
    }
  }
  
  private boolean c()
  {
    if ((this.jdField_b_of_type_JavaLangObject == null) || (!((azrb)this.jdField_b_of_type_JavaLangObject).jdField_b_of_type_Boolean)) {
      return false;
    }
    if (e()) {
      return false;
    }
    if (f()) {
      return g();
    }
    return h();
  }
  
  private boolean c(azrb paramazrb)
  {
    boolean bool3 = true;
    boolean bool1 = false;
    boolean bool2;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (!this.jdField_a_of_type_Boolean) || (paramazrb == null) || (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (!b()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemGameInfoComponent", 2, "makeOrRefreshGameCardInfoView. Not showing game info. gameCardInfoPrepared = " + this.jdField_a_of_type_Boolean + ", init = " + this.jdField_b_of_type_Boolean);
      }
      if (this.jdField_a_of_type_JavaLangObject != null) {
        bool1 = true;
      }
      if (this.jdField_a_of_type_JavaLangObject != null) {
        ((View)this.jdField_a_of_type_JavaLangObject).setVisibility(8);
      }
      bool2 = bool1;
      return bool2;
    }
    if (this.jdField_a_of_type_JavaLangObject == null) {
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131561604, null);
    }
    for (bool1 = true;; bool1 = false)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {}
      for (;;)
      {
        bool2 = bool1;
        if (a(paramazrb, bool3)) {
          break;
        }
        int i = this.jdField_a_of_type_ComTencentMobileqqProfileProfileGameInfo.mGrade;
        a(bool3);
        a(i, bool3);
        b(i, bool3);
        k();
        ((View)this.jdField_a_of_type_JavaLangObject).setVisibility(0);
        return bool1;
        bool3 = false;
      }
    }
  }
  
  private boolean d()
  {
    boolean bool2;
    if ((this.jdField_b_of_type_JavaLangObject == null) || (!((azrb)this.jdField_b_of_type_JavaLangObject).jdField_b_of_type_Boolean) || (TextUtils.isEmpty(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString)))
    {
      bool2 = false;
      return bool2;
    }
    bgft localbgft = (bgft)aqxe.a().a(695);
    if ((localbgft != null) && (localbgft.a(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ProfileTroopMemGameInfoComponent", 2, "checkGrayTroop. isGrayTroop = " + bool1);
      return bool1;
    }
  }
  
  private boolean e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString);
    return (localTroopInfo != null) && (localTroopInfo.isHomeworkTroop());
  }
  
  private boolean f()
  {
    if (!d()) {
      return false;
    }
    if (bdvn.a()) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString);
    if (localTroopInfo == null) {
      return false;
    }
    return localTroopInfo.isTroopGameCardEnabled();
  }
  
  private boolean g()
  {
    if (!d()) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    TroopMemberInfo localTroopMemberInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString, ((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    if (localTroopMemberInfo == null) {
      return false;
    }
    return (localTroopMemberInfo.cmduinFlagEx3Grocery & 1L) == 0L;
  }
  
  private boolean h()
  {
    boolean bool2 = true;
    if ((this.jdField_b_of_type_JavaLangObject == null) || (((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      bool1 = false;
      return bool1;
    }
    boolean bool4 = bdvn.a();
    boolean bool3 = this.jdField_a_of_type_Birs.a(14);
    if (bagq.a.a(42505, ((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemGameInfoComponent", 2, "personalGameCardSwitchEnabled. wzGameCardSwitchEnable = " + bool1 + ", wzGameCardConfigEnable = " + bool3);
      }
      if ((!bool4) && (bool1))
      {
        bool1 = bool2;
        if (bool3) {
          break;
        }
      }
      return false;
    }
  }
  
  private void j()
  {
    azxe localazxe = (azxe)this.jdField_a_of_type_Azxt.a(103);
    if (localazxe != null) {
      localazxe.a((azrb)this.jdField_b_of_type_JavaLangObject);
    }
  }
  
  private void k()
  {
    int i;
    ArrayList localArrayList;
    Object localObject1;
    Object localObject2;
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileGameInfo.bestHeroList == null)
    {
      i = 0;
      localArrayList = new ArrayList(3);
      localObject1 = (URLImageView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131376939);
      localObject2 = (URLImageView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131376940);
      Object localObject3 = (URLImageView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131376941);
      localArrayList.add(localObject1);
      localArrayList.add(localObject2);
      localArrayList.add(localObject3);
      localObject1 = new ArrayList(3);
      localObject2 = (ImageView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131376942);
      localObject3 = (ImageView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131376943);
      ImageView localImageView = (ImageView)((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131376944);
      ((ArrayList)localObject1).add(localObject2);
      ((ArrayList)localObject1).add(localObject3);
      ((ArrayList)localObject1).add(localImageView);
      j = 0;
      label190:
      if (j >= 3) {
        return;
      }
      if (j < i) {
        break label249;
      }
      ((URLImageView)localArrayList.get(j)).setVisibility(8);
      ((ImageView)((ArrayList)localObject1).get(j)).setVisibility(8);
    }
    for (;;)
    {
      j += 1;
      break label190;
      i = this.jdField_a_of_type_ComTencentMobileqqProfileProfileGameInfo.bestHeroList.size();
      break;
      label249:
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = ViewUtils.dpToPx(20.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = ViewUtils.dpToPx(20.0F);
      localObject2 = URLDrawable.getDrawable(((ProfileGameInfo.UserHeroInfo)this.jdField_a_of_type_ComTencentMobileqqProfileProfileGameInfo.bestHeroList.get(j)).heroIcon, (URLDrawable.URLDrawableOptions)localObject2);
      if (localObject2 != null)
      {
        int k = ViewUtils.dpToPx(20.0F);
        ((URLDrawable)localObject2).setTag(bgxc.a(k, k));
        ((URLDrawable)localObject2).setDecodeHandler(bgxc.p);
        ((URLImageView)localArrayList.get(j)).setImageDrawable((Drawable)localObject2);
      }
      ((URLImageView)localArrayList.get(j)).setVisibility(0);
      localObject2 = bhbt.a(bhbt.g(((ProfileGameInfo.UserHeroInfo)this.jdField_a_of_type_ComTencentMobileqqProfileProfileGameInfo.bestHeroList.get(j)).skilledLevel));
      if (localObject2 != null)
      {
        ((ImageView)((ArrayList)localObject1).get(j)).setImageBitmap((Bitmap)localObject2);
        ((ImageView)((ArrayList)localObject1).get(j)).setVisibility(0);
      }
    }
  }
  
  private void l()
  {
    if ((this.jdField_b_of_type_JavaLangObject != null) && (!((azrb)this.jdField_b_of_type_JavaLangObject).jdField_b_of_type_Boolean) && (ProfileCardMoreInfoView.a((View)this.jdField_a_of_type_JavaLangObject)) && (!this.c))
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B5EF", "0X800B5EF", 0, 0, "0", "0", "", "");
      this.c = true;
    }
  }
  
  public int a()
  {
    return 1028;
  }
  
  public String a()
  {
    return "ProfileTroopMemGameInfoComponent";
  }
  
  public String a(azrb paramazrb)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      localObject = "他";
    }
    do
    {
      String str;
      do
      {
        return localObject;
        str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699106);
        localObject = str;
      } while (paramazrb == null);
      localObject = str;
    } while (paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard == null);
    if (paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.shGender == 1) {
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699105);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699106);
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Boolean) {}
    do
    {
      return;
      if ((this.jdField_b_of_type_JavaLangObject != null) && (((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ProfileTroopMemGameInfoComponent", 2, "initNetRequest.mData is not ready");
    return;
    if (!bdvn.a()) {
      if (f())
      {
        if (QLog.isColorLevel()) {
          QLog.e("ProfileTroopMemGameInfoComponent", 2, "initNetRequest.checkTroopGameCardSwitch = true");
        }
        if (!e()) {
          i();
        }
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = true;
      return;
      boolean bool = h();
      if (bool) {
        a("0", ((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("ProfileTroopMemGameInfoComponent", 2, "initNetRequest.personalSwitch = " + bool);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("ProfileTroopMemGameInfoComponent", 2, "initNetRequest.studyMode = true");
        }
      }
    }
  }
  
  public void a(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.a(paramBaseActivity, paramBundle);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemGameInfoComponent", 2, "onCreate: mActivity == null || mApp == null");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_Aofu);
      a(((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_Boolean = false;
      this.c = false;
    } while (this.jdField_a_of_type_Azww == null);
    this.jdField_a_of_type_Azww.a(this);
  }
  
  public void a(TroopInfo paramTroopInfo)
  {
    ProfileActivity.AllInOne localAllInOne = ((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
    if ((localAllInOne != null) && (paramTroopInfo != null) && (ProfileActivity.f(localAllInOne.jdField_a_of_type_Int)) && (TextUtils.isEmpty(localAllInOne.d)))
    {
      localAllInOne.d = paramTroopInfo.troopcode;
      localAllInOne.c = paramTroopInfo.troopuin;
      if (QLog.isColorLevel()) {
        QLog.i("ProfileTroopMemGameInfoComponent", 2, String.format("checkAndUpdateTroopInfo troop[%s, %s]", new Object[] { paramTroopInfo.troopuin, paramTroopInfo.troopcode }));
      }
    }
  }
  
  public boolean a(azrb paramazrb)
  {
    boolean bool = super.a(paramazrb);
    return b((azrb)this.jdField_b_of_type_JavaLangObject) | bool;
  }
  
  public String a_()
  {
    return "map_key_troop_mem_game_info";
  }
  
  public void c()
  {
    this.c = false;
    l();
    super.c();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_Aofu);
    }
    if (this.jdField_a_of_type_Azww != null) {
      this.jdField_a_of_type_Azww.b(this);
    }
    super.f();
  }
  
  public void i()
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTroopMemGameInfoComponent", 2, "requestTroopMemberInfo.isNetworkAvailable = false");
      }
    }
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ProfileTroopMemGameInfoComponent", 2, "requestTroopMemberInfo mApp is null");
      return;
      Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      aoep localaoep = (aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      localObject = ((TroopManager)localObject).b(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString);
      a((TroopInfo)localObject);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileTroopMemGameInfoComponent", 2, "requestTroopMemberInfo.getMemberGameCardSwitch");
        }
        localaoep.b(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString, Long.parseLong(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ProfileTroopMemGameInfoComponent", 2, "requestTroopMemberInfo.getTroopMemberCardInfo troopInfo null");
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (ProfileCardMoreInfoView.a((View)this.jdField_a_of_type_JavaLangObject))) {
      ((View)this.jdField_a_of_type_JavaLangObject).post(new ProfileTroopMemGameInfoComponent.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bacu
 * JD-Core Version:    0.7.0.1
 */