import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.util.Pair;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class azks
  extends azkq<FrameLayout>
  implements View.OnClickListener
{
  private static final Object c = new Object();
  private long jdField_a_of_type_Long;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new azkt(this);
  protected ViewGroup a;
  private anun jdField_a_of_type_Anun = new azkv(this);
  protected azkz a;
  protected bkgm a;
  protected AbsProfileHeaderView a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private Handler.Callback jdField_b_of_type_AndroidOsHandler$Callback = new azku(this);
  protected bkgm b;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  
  public azks(azlw paramazlw, azfe paramazfe)
  {
    super(paramazlw, paramazfe);
  }
  
  private String a(azfe paramazfe)
  {
    if ((paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.shGender == 1)) {
      return anni.a(2131692982);
    }
    return anni.a(2131692987);
  }
  
  private void a(int paramInt)
  {
    int i;
    if ((paramInt == 101107) || (paramInt == 101108))
    {
      if (paramInt != 101108) {
        break label145;
      }
      i = 5;
      if (paramInt != 101108) {
        break label150;
      }
      VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 3, bghy.a(i));
    }
    for (;;)
    {
      if (((azfe)this.jdField_b_of_type_JavaLangObject).b) {
        VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "group_card", "guide_click", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      }
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_SummaryCard", "", "SummaryCard", "CLICK_TOPBARVIPINVALID", ProfileActivity.a(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h), 0, Integer.toString(ProfileActivity.a(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      label145:
      i = 2;
      break;
      label150:
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 3, bghy.a(i));
    }
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if (paramInt == -1)
    {
      paramInt = paramIntent.getIntExtra("edit_action", 0);
      paramIntent = paramIntent.getStringExtra("nick");
      if ((paramInt != 3) && (paramInt != 4)) {
        break label44;
      }
      ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ArrayOfJavaLangString[1] = paramIntent;
    }
    label44:
    do
    {
      return;
      if (paramInt == 1)
      {
        ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ArrayOfJavaLangString[0] = paramIntent;
        return;
      }
    } while (paramInt != 2);
    ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ArrayOfJavaLangString[4] = paramIntent;
  }
  
  private void a(Card paramCard)
  {
    if ((((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
      b(paramCard);
    }
    do
    {
      return;
      c(paramCard);
    } while (!QSecFramework.a().a(1001).booleanValue());
    QSecFramework.a().a(5, 0, 2, new Object[] { Integer.valueOf(24), Integer.valueOf(1), Integer.valueOf(6), "vote", null }, null);
  }
  
  private void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    bkho localbkho;
    if (!TextUtils.isEmpty(paramString2))
    {
      localbkho = (bkho)bkif.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
      localbkho.a(paramString2, 1);
      localbkho.c(2131690582);
      localbkho.a(new azkx(this, paramString2, paramString1, paramInt, paramBoolean, localbkho));
    }
    try
    {
      localbkho.show();
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.d("AbsProfileHeaderComponent", 1, "showEditNickActionSheet fail.", paramString1);
    }
  }
  
  private int b()
  {
    int i = 1;
    if (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AvatarClick", "KerenInfoHeadClick", i, 0, "", "", "", "");
      return i;
      if (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 20) {
        i = 2;
      } else if (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21) {
        i = 3;
      } else if (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 45) {
        i = 4;
      } else if (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46) {
        i = 5;
      } else if (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) {
        i = 6;
      } else if (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 42) {
        i = 7;
      } else {
        i = 0;
      }
    }
  }
  
  private void b(Card paramCard)
  {
    int i;
    int j;
    label48:
    Object localObject1;
    if (paramCard == null)
    {
      i = 0;
      Object localObject2 = aqxz.a();
      if ((localObject2 == null) || (!((aqxy)localObject2).a()) || (TextUtils.isEmpty(((aqxy)localObject2).a())) || (!bkgj.a(((aqxy)localObject2).a()))) {
        break label188;
      }
      j = 1;
      if (j == 0) {
        break label199;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      localObject2 = ((aqxy)localObject2).a();
      if (paramCard == null) {
        break label193;
      }
      paramCard = paramCard.uin;
      label74:
      bghy.a((Context)localObject1, (String)localObject2, paramCard);
      axdm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView != null)
      {
        paramCard = this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.a("map_key_like");
        if (!(paramCard instanceof VoteView)) {
          break label346;
        }
        paramCard = (VoteView)paramCard;
        paramCard.a(true, false, i, 0, null, false);
        paramCard.a(false);
      }
    }
    for (;;)
    {
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800657A", "0X800657A", 1, 0, Integer.toString(ProfileActivity.a(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      i = (int)paramCard.lVoteCount;
      break;
      label188:
      j = 0;
      break label48;
      label193:
      paramCard = "";
      break label74;
      label199:
      paramCard = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, VisitorsActivity.class);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putLong("toUin", Long.valueOf(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).longValue());
      ((Bundle)localObject1).putLong("totalVoters", i);
      ((Bundle)localObject1).putBoolean("isStartedByProfileCard", true);
      ((Bundle)localObject1).putBoolean("votersOnly", true);
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((Bundle)localObject1).putBoolean("hasVoters", bool);
        ((Bundle)localObject1).putBoolean("extra_show_rank", true);
        ((Bundle)localObject1).putInt("extra_from", 1);
        ((Bundle)localObject1).putInt("frome_where", 5);
        paramCard.putExtras((Bundle)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramCard);
        break;
      }
      label346:
      if ((paramCard instanceof VoteViewV2))
      {
        paramCard = (VoteViewV2)paramCard;
        paramCard.a(true, false, i, 0, null, false);
        paramCard.a(false);
      }
    }
  }
  
  private void c(Card paramCard)
  {
    if (paramCard == null) {
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693034), 1);
    }
    int i;
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AbsProfileHeaderComponent", 2, String.format("handleVoteBtnClickForGuestProfile availVoteCnt=%s haveVotedCnt=%s voteLimitedNotice=%s", new Object[] { Short.valueOf(paramCard.bAvailVoteCnt), Short.valueOf(paramCard.bHaveVotedCnt), paramCard.strVoteLimitedNotice }));
      }
      if (paramCard.bAvailVoteCnt <= 0)
      {
        i = 1;
        if (i != 0) {
          break label277;
        }
        if (bgnt.d(BaseApplication.getContext()))
        {
          paramCard.lVoteCount += 1L;
          paramCard.bVoted = 1;
          paramCard.bAvailVoteCnt = ((short)(paramCard.bAvailVoteCnt - 1));
        }
      }
      else
      {
        synchronized (c)
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
          if (QLog.isColorLevel()) {
            QLog.d("AbsProfileHeaderComponent", 2, String.format("handleVoteBtnClick uin=%s voteCount=%s mCacheVoteNum=%s", new Object[] { paramCard.uin, Long.valueOf(paramCard.lVoteCount), this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger }));
          }
          if (!this.jdField_b_of_type_Bkgm.hasMessages(10))
          {
            ??? = Message.obtain();
            ((Message)???).what = 10;
            this.jdField_b_of_type_Bkgm.sendMessageDelayed((Message)???, 2000L);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView != null)
          {
            long l = paramCard.lVoteCount;
            this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.a((azfe)this.jdField_b_of_type_JavaLangObject, l, true);
            return;
            i = 0;
          }
        }
      }
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719213), 1);
    return;
    label277:
    if (!VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      l();
      return;
    }
    if (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long > 2000L)
    {
      if (paramCard.strVoteLimitedNotice != null)
      {
        paramCard = paramCard.strVoteLimitedNotice;
        i = 0;
        a(paramCard, i);
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      }
    }
    else {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().hasExtra("troopUin")) {
        break label397;
      }
    }
    label397:
    for (paramCard = "1";; paramCard = "0")
    {
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "thumbup", "limit_20", "", 1, 0, 0, "", paramCard, "");
      return;
      paramCard = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693034);
      i = 1;
      break;
    }
  }
  
  private void i()
  {
    if (bgjw.b(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (((azfe)this.jdField_b_of_type_JavaLangObject).b)
    {
      k();
      return;
    }
    j();
  }
  
  private void j()
  {
    String str3 = ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ArrayOfJavaLangString[0];
    String str1 = ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ArrayOfJavaLangString[4];
    if (QLog.isColorLevel()) {
      QLog.d("AbsProfileHeaderComponent", 2, String.format("showEditNickActionSheet nickName=%s, remark=%s", new Object[] { str3, str1 }));
    }
    String str2 = "";
    int i;
    if (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      str2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692988);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800999A", "0X800999A", 1, 0, "", "", "", "");
      str1 = str3;
      i = 1;
    }
    for (;;)
    {
      a(false, i, str1, str2);
      return;
      if (ProfileActivity.AllInOne.b(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        if (!TextUtils.isEmpty(str1)) {}
        for (str2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692983);; str2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693024))
        {
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800999A", "0X800999A", 2, 0, "", "", "", "");
          i = 2;
          break;
        }
      }
      str1 = a((azfe)this.jdField_b_of_type_JavaLangObject);
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692984, new Object[] { str1, str1 }), 1);
      str1 = "";
      i = 0;
    }
  }
  
  private void k()
  {
    String str1 = ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ArrayOfJavaLangString[1];
    if (QLog.isColorLevel()) {
      QLog.d("AbsProfileHeaderComponent", 2, String.format("showEditNickActionSheetForTroop troopNick=%s", new Object[] { str1 }));
    }
    String str2 = "";
    int i;
    boolean bool;
    if (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      str2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692989);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800999A", "0X800999A", 3, 0, "", "", "", "");
      i = 3;
      bool = true;
    }
    for (;;)
    {
      a(bool, i, str1, str2);
      return;
      String str3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_JavaLangString);
      if ((localTroopInfo != null) && ((localTroopInfo.isTroopAdmin(str3)) || (localTroopInfo.isTroopOwner(str3))))
      {
        i = 1;
        label179:
        if (i == 0) {
          break label303;
        }
        if (TextUtils.isEmpty(str1)) {
          break label266;
        }
        str2 = a((azfe)this.jdField_b_of_type_JavaLangObject);
      }
      for (str2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692992, new Object[] { str2 });; str2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693025, new Object[] { str2 }))
      {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800999A", "0X800999A", 3, 0, "", "", "", "");
        i = 4;
        bool = true;
        break;
        i = 0;
        break label179;
        label266:
        str2 = a((azfe)this.jdField_b_of_type_JavaLangObject);
      }
      label303:
      str1 = a((azfe)this.jdField_b_of_type_JavaLangObject);
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692994, new Object[] { str1 }), 1);
      str1 = "";
      i = 0;
      bool = false;
    }
  }
  
  private void l()
  {
    if (azkn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      localObject = new bhar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ((bhar)localObject).a(new azky(this));
      ((bhar)localObject).show();
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().hasExtra("troopUin")) {}
      for (localObject = "1";; localObject = "0")
      {
        VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "thumbup", "dbzan_pageview", "", 1, 0, 0, "", (String)localObject, "");
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().hasExtra("troopUin")) {}
    for (Object localObject = "1";; localObject = "0")
    {
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "thumbup", "limit_10", "", 1, 0, 0, "", (String)localObject, "");
      a("非SVIP用户每天只能点10个赞哦～", 0);
      return;
    }
  }
  
  private void m()
  {
    anip localanip = (anip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
    if ((localanip != null) && (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard != null)) {}
    synchronized (c)
    {
      int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      if (QLog.isColorLevel()) {
        QLog.d("AbsProfileHeaderComponent", 2, String.format("reqFavorite cacheVoteNum=%s", new Object[] { Integer.valueOf(i) }));
      }
      if (i > 0) {
        localanip.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin(), Long.parseLong(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString), ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.vCookies, ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.favoriteSource, i, 0);
      }
      return;
    }
  }
  
  private void n()
  {
    if ((this.jdField_b_of_type_Bkgm != null) && (this.jdField_b_of_type_Bkgm.hasMessages(10)))
    {
      this.jdField_b_of_type_Bkgm.removeMessages(10);
      m();
    }
  }
  
  private void o()
  {
    View localView;
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView != null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.a("map_key_like");
      if (!(localView instanceof VoteView)) {
        break label34;
      }
      ((VoteView)localView).b(true);
    }
    label34:
    while (!(localView instanceof VoteViewV2)) {
      return;
    }
    ((VoteViewV2)localView).b(true);
  }
  
  private void p()
  {
    View localView;
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView != null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.a("map_key_like");
      if (!(localView instanceof VoteView)) {
        break label34;
      }
      ((VoteView)localView).b(false);
    }
    label34:
    while (!(localView instanceof VoteViewV2)) {
      return;
    }
    ((VoteViewV2)localView).b(false);
  }
  
  private void q()
  {
    Object localObject;
    if (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AvatarPendantActivity.class);
      ((Intent)localObject).putExtra("AllInOne", ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
    }
    while (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A77", "0X8006A77", 0, 0, "", "", "", "");
      do
      {
        return;
      } while (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33);
      if (!ProfileActivity.AllInOne.g(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        localObject = FriendProfileCardActivity.a(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        if (((((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 53) || (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b)) && (localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView != null))
        {
          View localView = this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.a("map_key_face");
          if (localView != null) {
            bghy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localView, (String)localObject);
          }
        }
      }
      else
      {
        r();
      }
    }
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A8B", "0X8006A8B", 0, 0, "", "", "", "");
  }
  
  private void r()
  {
    View localView;
    long l;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView != null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.a("map_key_face");
      if (localView != null) {
        break label180;
      }
      localView = null;
      localObject = this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.a("map_key_avatar_pendant");
      l = this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.a();
      if ((((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (!ProfileActivity.AllInOne.g(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (localView == null) || (localObject == null) || (((View)localObject).getVisibility() != 0) || (l == 0L)) {
        break label238;
      }
      i = b();
      if ((localView instanceof DynamicAvatarView))
      {
        localObject = (DynamicAvatarView)localView;
        if (((DynamicAvatarView)localObject).a != null)
        {
          localObject = ((DynamicAvatarView)localObject).a;
          if ((!((aobo)localObject).jdField_a_of_type_Boolean) || (((aobo)localObject).jdField_a_of_type_ComTencentImageURLDrawable == null) || (TextUtils.isEmpty(((aobo)localObject).c))) {
            break label194;
          }
          bghy.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localView, ((aobo)localObject).c);
        }
      }
    }
    label180:
    label194:
    label238:
    do
    {
      do
      {
        return;
        localView = ((AvatarLayout)localView).a(0);
        break;
        localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 1);
        bghy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localView, ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, l, i, (ProfileActivity.AllInOne)localObject);
        return;
      } while (!(localView instanceof DynamicAvatarView));
      localObject = (DynamicAvatarView)localView;
    } while (((DynamicAvatarView)localObject).a == null);
    Object localObject = ((DynamicAvatarView)localObject).a;
    if ((((aobo)localObject).jdField_a_of_type_Boolean) && (((aobo)localObject).jdField_a_of_type_ComTencentImageURLDrawable != null) && (!TextUtils.isEmpty(((aobo)localObject).c)))
    {
      bghy.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localView, ((aobo)localObject).c);
      return;
    }
    if ((((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) && (!TextUtils.isEmpty(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")))
    {
      bghy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localView, ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.p, false, false, null);
      return;
    }
    localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 1);
    bghy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localView, ((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false, false, (ProfileActivity.AllInOne)localObject);
  }
  
  public AbsProfileHeaderView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView;
  }
  
  protected abstract void a();
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1034) {
      a(paramInt2, paramIntent);
    }
  }
  
  protected void a(Message paramMessage) {}
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void a(azkz paramazkz)
  {
    this.jdField_a_of_type_Azkz = paramazkz;
  }
  
  public void a(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super.a(paramBaseActivity, paramBundle);
    this.jdField_a_of_type_Bkgm = new bkgm(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_b_of_type_Bkgm = new bkgm(ThreadManager.getSubThreadLooper(), this.jdField_b_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anun);
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView != null)
    {
      paramBaseActivity = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369383);
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.a("map_key_tag_jueban", paramBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.b((azfe)this.jdField_b_of_type_JavaLangObject);
    }
  }
  
  protected void a(String paramString, int paramInt)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).a();
  }
  
  public boolean a(azfe paramazfe)
  {
    boolean bool = super.a(paramazfe);
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.a((azfe)this.jdField_b_of_type_JavaLangObject, ((azfe)this.jdField_b_of_type_JavaLangObject).d);
    }
    return bool;
  }
  
  public void b()
  {
    super.b();
    o();
  }
  
  protected void b(Message paramMessage)
  {
    if (paramMessage.what == 10) {
      m();
    }
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.c();
    }
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.b();
    }
  }
  
  public void e()
  {
    super.e();
    p();
    n();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Bkgm != null)
    {
      this.jdField_a_of_type_Bkgm.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Bkgm = null;
    }
    if (this.jdField_b_of_type_Bkgm != null)
    {
      this.jdField_b_of_type_Bkgm.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_Bkgm = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.d();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anun);
    super.f();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof azde)) {
      localObject = (azde)paramView.getTag();
    }
    switch (((azde)localObject).jdField_a_of_type_Int)
    {
    default: 
    case 88: 
    case 3: 
    case 97: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        i();
        continue;
        azmq.a((azfe)this.jdField_b_of_type_JavaLangObject, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        continue;
        localObject = (Pair)((azde)localObject).jdField_a_of_type_JavaLangObject;
        azmq.a(paramView, ((Integer)((Pair)localObject).first).intValue(), (String)((Pair)localObject).second, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    case 10: 
      if (!(((azde)localObject).jdField_a_of_type_JavaLangObject instanceof Card)) {
        break;
      }
    }
    for (Object localObject = (Card)((azde)localObject).jdField_a_of_type_JavaLangObject;; localObject = null)
    {
      a((Card)localObject);
      break;
      a(((Integer)((azde)localObject).jdField_a_of_type_JavaLangObject).intValue());
      break;
      q();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azks
 * JD-Core Version:    0.7.0.1
 */