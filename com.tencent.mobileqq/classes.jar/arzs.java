import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.forward.ForwardShareCardOption.1;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.List;
import java.util.Set;
import mqq.manager.TicketManager;

public class arzs
  extends arum
{
  almt jdField_a_of_type_Almt;
  private amab jdField_a_of_type_Amab = new arzt(this);
  private bfvh jdField_a_of_type_Bfvh = new arzu(this);
  AbsShareMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
  AbsStructMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
  private almw b;
  private int d;
  private int e;
  private int f;
  private int g;
  private String h;
  private String jdField_i_of_type_JavaLangString;
  boolean jdField_i_of_type_Boolean;
  private String jdField_j_of_type_JavaLangString;
  private boolean jdField_j_of_type_Boolean;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  
  public arzs(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_d_of_type_Int = -1;
    this.jdField_b_of_type_Almw = new arzv(this);
  }
  
  private void G()
  {
    boolean bool = false;
    if (!bdee.d(BaseApplication.getContext()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131692397), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
      if (QLog.isColorLevel()) {
        QLog.i("ForwardOption.ForwardShareCardOption", 2, "tryToGetShareLink: net is not supported");
      }
      this.jdField_d_of_type_Int = -1;
    }
    a(2131695088);
    if (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.k))
    {
      localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.k);
      ((bfvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).b(this.k, ((TroopInfo)localObject).troopowneruin);
      return;
    }
    Object localObject = (alzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    String str = this.k;
    if (this.jdField_d_of_type_Int == 0) {
      bool = true;
    }
    ((alzf)localObject).a(str, bool);
  }
  
  private View a(String paramString, Drawable paramDrawable)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131558942, null);
    TextView localTextView = (TextView)localView.findViewById(2131379140);
    ImageView localImageView = (ImageView)localView.findViewById(2131368169);
    localTextView.setText(paramString);
    localImageView.setImageDrawable(paramDrawable);
    return localView;
  }
  
  private static azqk a(String paramString)
  {
    azui localazui = new azui();
    localazui.b(1);
    localazui.a(paramString);
    return localazui;
  }
  
  public static final AbsShareMsg a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject1 = new azqg(StructMsgForGeneralShare.class);
    if (paramString2 == null)
    {
      paramQQAppInterface = "";
      Object localObject2 = new StringBuilder().append("mqqapi://card/show_pslcard?src_type=internal_phone&source=sharecard&nickname=").append(URLEncoder.encode(paramQQAppInterface));
      if (!paramBoolean) {
        break label299;
      }
      paramString2 = "";
      label47:
      localObject2 = paramString2 + "&version=1&uin=" + paramString1 + "";
      paramString2 = ((azqg)localObject1).c(84).a(2).a(alpo.a(2131705186) + paramQQAppInterface).a("plugin", "", "AppCmd://OpenContactInfo/?uin=", (String)localObject2, (String)localObject2).d(paramActivity.getResources().getString(2131719126)).a();
      localObject1 = new aztc();
      ((azqk)localObject1).b(1);
      ((azqk)localObject1).a(new azsm((String)localObject2));
      ((azqk)localObject1).a(new StructMsgItemTitle(paramQQAppInterface));
      if (!paramString1.startsWith("+86")) {
        break label339;
      }
    }
    label299:
    label339:
    for (paramQQAppInterface = paramString1.substring("+86".length(), paramString1.length());; paramQQAppInterface = paramString1)
    {
      if (paramBoolean) {}
      for (paramActivity = alpo.a(2131705209);; paramActivity = alpo.a(2131705191))
      {
        paramQQAppInterface = new azvd(paramActivity + paramQQAppInterface);
        paramQQAppInterface.d(paramActivity + paramString1);
        ((azqk)localObject1).a(paramQQAppInterface);
        paramString2.addItem(a(alpo.a(2131705216)));
        paramString2.addItem((azqj)localObject1);
        return paramString2;
        paramQQAppInterface = paramString2.trim();
        break;
        paramString2 = "&headtext=" + URLEncoder.encode(bdbt.a(paramQQAppInterface));
        break label47;
      }
    }
  }
  
  private void a(CardOCRInfo paramCardOCRInfo)
  {
    if (paramCardOCRInfo == null) {
      return;
    }
    Object localObject2 = new azqg(StructMsgForGeneralShare.class);
    if (paramCardOCRInfo.a == null) {
      paramCardOCRInfo.a = "";
    }
    Object localObject1;
    if ((paramCardOCRInfo.jdField_b_of_type_JavaUtilList != null) && (paramCardOCRInfo.jdField_b_of_type_JavaUtilList.size() > 0))
    {
      localObject1 = (String)paramCardOCRInfo.jdField_b_of_type_JavaUtilList.get(0);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    for (;;)
    {
      Object localObject3 = "url=" + paramCardOCRInfo.jdField_b_of_type_JavaLangString + ";name=" + paramCardOCRInfo.a + ";phone=" + (String)localObject1;
      localObject2 = ((azqg)localObject2).c(73).a(this.jdField_a_of_type_AndroidAppActivity.getString(2131698911, new Object[] { paramCardOCRInfo.a })).a(2).a("shareBusinessCard", "", (String)localObject3, (String)localObject3, (String)localObject3).d(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719921)).a();
      localObject3 = new azui();
      ((azqk)localObject3).b(1);
      ((azqk)localObject3).a(this.jdField_a_of_type_AndroidAppActivity.getString(2131698908));
      aztc localaztc = new aztc();
      localaztc.b(3);
      localaztc.a(new azsm(paramCardOCRInfo.jdField_b_of_type_JavaLangString + "/?02"));
      localaztc.a(new StructMsgItemTitle(paramCardOCRInfo.a));
      localaztc.a(new azvd((String)localObject1));
      ((AbsShareMsg)localObject2).addItem((azqj)localObject3);
      ((AbsShareMsg)localObject2).addItem(localaztc);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("req_type", 5);
      ((Bundle)localObject1).putString("image_url", paramCardOCRInfo.jdField_b_of_type_JavaLangString);
      anvv.a(paramCardOCRInfo.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = azqu.a(((StructMsgForImageShare)azqu.a((Bundle)localObject1)).getBytes());
      this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
      l();
      return;
      localObject1 = "";
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (!bfua.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)) {}
    do
    {
      return;
      localObject1 = ((aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(paramString1);
    } while (localObject1 == null);
    Object localObject2 = new azqg(StructMsgForGeneralShare.class);
    String str2 = "mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramString1 + "&cspecialflag=" + ((Friends)localObject1).cSpecialFlag;
    String str3 = "mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=" + paramString1 + "&version=1&cspecialflag=" + ((Friends)localObject1).cSpecialFlag;
    String str4 = "https://share.mp.qq.com/cgi/share.php?uin=" + paramString1 + "&account_flag=" + -7 + "&jumptype=1&card_type=crm&cspecialflag=" + ((Friends)localObject1).cSpecialFlag;
    String str1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + paramString1;
    Object localObject1 = bfua.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      localObject1 = ((azqg)localObject2).c(14).a(2).a(1).a(alpo.a(2131705206) + paramString2).a("plugin", str4, "", str2, str3).d(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719122)).a();
      localObject2 = new aztc();
      ((azqk)localObject2).b(1);
      ((azqk)localObject2).a(new azsm(str1));
      ((azqk)localObject2).a(new StructMsgItemTitle(paramString2));
      ((azqk)localObject2).a(new azvd(alpo.a(2131705218) + bfua.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)));
      ((AbsShareMsg)localObject1).addItem(a(alpo.a(2131705210)));
      ((AbsShareMsg)localObject1).addItem((azqj)localObject2);
      this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localObject1);
      l();
      return;
      paramString2 = (String)localObject1;
    }
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_i_of_type_Boolean = true;
    paramString1 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramString1, paramString2, paramBoolean);
    this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", paramString1.getBytes());
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = paramString1;
    l();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    Object localObject = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    int i1 = ((almv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a(paramString);
    localObject = ((TicketManager)localObject).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      ThreadManager.post(new ForwardShareCardOption.1(this, i1, paramString, (String)localObject, paramBoolean), 8, null, false);
      return;
    }
    x();
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, -1, alpo.a(2131705214), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
  }
  
  private View b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
    {
      new RelativeLayout.LayoutParams(-1, -2).setMargins(aekt.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, aekt.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShareCardOption", 2, "updateImageView addStructView");
      }
      return this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null);
    }
    return new View(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  private void b(String paramString1, String paramString2)
  {
    Object localObject2 = new azqg(StructMsgForGeneralShare.class);
    String str1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + paramString1;
    String str2 = "AppCmd://OpenContactInfo/?uin=" + paramString1;
    Object localObject1 = bdbt.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      localObject1 = ((azqg)localObject2).c(14).a(2).a(1).a(alpo.a(2131705204) + paramString2).a("plugin", "", str2, str1, str1).d(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719122)).a();
      localObject2 = new aztc();
      ((azqk)localObject2).b(1);
      ((azqk)localObject2).a(new azsm(str1));
      ((azqk)localObject2).a(new StructMsgItemTitle(paramString2));
      ((azqk)localObject2).a(new azvd(alpo.a(2131705170) + paramString1));
      ((AbsShareMsg)localObject1).addItem(a(alpo.a(2131705180)));
      ((AbsShareMsg)localObject1).addItem((azqj)localObject2);
      this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localObject1);
      l();
      return;
      paramString2 = (String)localObject1;
    }
  }
  
  private void c(String paramString1, String paramString2)
  {
    AbsShareMsg localAbsShareMsg = new azqg(StructMsgForGeneralShare.class).c(15).a(alpo.a(2131705196) + this.jdField_l_of_type_JavaLangString).e(this.jdField_j_of_type_JavaLangString).a();
    Object localObject = (almv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
    if (localObject != null)
    {
      localObject = ((almv)localObject).a(paramString1);
      if (localObject == null) {}
    }
    for (paramString1 = bdbt.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, ((DiscussionInfo)localObject).ownerUin);; paramString1 = null)
    {
      localObject = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        localObject = alpo.a(2131705192);
      }
      paramString1 = azqt.a(2);
      paramString1.a(paramString2, this.jdField_l_of_type_JavaLangString, alpo.a(2131705215) + (String)localObject, 1);
      localAbsShareMsg.addItem(a(alpo.a(2131705176)));
      localAbsShareMsg.addItem(paramString1);
      this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", localAbsShareMsg.getBytes());
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = localAbsShareMsg;
      return;
    }
  }
  
  private void e()
  {
    String str1 = this.jdField_l_of_type_JavaLangString;
    if (TextUtils.isEmpty(str1)) {
      str1 = this.k;
    }
    for (;;)
    {
      String str2 = bcgh.a("", this.k, 0) + "100";
      AbsShareMsg localAbsShareMsg = new azqg(StructMsgForGeneralShare.class).c(15).a(this.jdField_a_of_type_AndroidAppActivity.getString(2131719129) + str1).e(this.jdField_h_of_type_JavaLangString).a();
      azqk localazqk = azqt.a(2);
      Object localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131720056);
      Object localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      if ((localObject2 != null) && (this.k != null))
      {
        localObject2 = ((TroopManager)localObject2).b(this.k);
        if (localObject2 != null)
        {
          if (TextUtils.isEmpty(((TroopInfo)localObject2).mRichFingerMemo)) {
            break label398;
          }
          localObject2 = ((TroopInfo)localObject2).mRichFingerMemo;
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.e("ForwardOption.ForwardShareCardOption", 2, "summary=" + (String)localObject2);
            localObject1 = localObject2;
          }
        }
      }
      label398:
      for (;;)
      {
        localazqk.a(str2, str1, (String)localObject1, 1);
        localAbsShareMsg.addItem(a(alpo.a(2131705178)));
        localAbsShareMsg.addItem(localazqk);
        this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", localAbsShareMsg.getBytes());
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = localAbsShareMsg;
        if (QLog.isColorLevel()) {
          QLog.i("ForwardOption.ForwardShareCardOption", 2, "createTroopCardMsg.mMsgServiceID:" + localAbsShareMsg.mMsgServiceID + " mMsgBrief:" + localAbsShareMsg.mMsgBrief + " mContentTitle:" + localAbsShareMsg.mContentTitle + " mContentSummary:" + localAbsShareMsg.mContentSummary + " mMsgUrl:" + localAbsShareMsg.mMsgUrl + " coverUrl:" + str2 + " mSourceName:" + localAbsShareMsg.mSourceName);
        }
        l();
        return;
        if (QLog.isColorLevel()) {
          QLog.e("ForwardOption.ForwardShareCardOption", 2, "can't find troop info! summary use default");
        }
      }
    }
  }
  
  protected View a()
  {
    View localView1 = null;
    switch (this.g)
    {
    default: 
      localView1 = b();
    }
    for (;;)
    {
      View localView2 = localView1;
      if (localView1 == null) {
        localView2 = new View(this.jdField_a_of_type_AndroidAppActivity);
      }
      return localView2;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null)
      {
        localView1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null);
        continue;
        localView1 = a(String.format("[%s]%s", new Object[] { alpo.a(2131705194), this.q }), bcxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.p));
        continue;
        localView1 = a(String.format("[%s]%s", new Object[] { alpo.a(2131705219), this.q }), bcxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 11, this.p));
        continue;
        localView1 = a(String.format("[%s]%s", new Object[] { alpo.a(2131705189), this.q }), bcxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, this.p));
        continue;
        localView1 = a(String.format("[%s]%s", new Object[] { alpo.a(2131705203), this.q }), bcxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 101, this.p));
        continue;
        localView1 = b();
      }
    }
  }
  
  protected void a()
  {
    if (m()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    if (k()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_d_of_type_JavaLangInteger);
    }
    if (l()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    int i1 = ((aubm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).d();
    if ((i1 >= 9) || ((this.f == 23) && ((i1 == 1) || (i1 == 2) || (i1 == 6) || (i1 == 7) || (i1 == 3)))) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_h_of_type_JavaLangInteger);
    }
    this.jdField_a_of_type_JavaUtilSet.add(jdField_l_of_type_JavaLangInteger);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardShareCardOption", 2, "build forward ability in state=" + i1 + ", type=" + this.f);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (!e()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = null;
    this.g = paramBundle.getInt("uintype");
    this.p = paramBundle.getString("uin");
    this.q = paramBundle.getString("uinname");
    paramBundle.getString("troop_uin");
    CardOCRInfo localCardOCRInfo = (CardOCRInfo)paramBundle.getParcelable("business_card_ocr");
    boolean bool = paramBundle.getBoolean("bindContact", true);
    this.jdField_a_of_type_AndroidOsBundle.putString("uin", this.m);
    this.jdField_a_of_type_AndroidOsBundle.putInt("uintype", this.e);
    this.jdField_a_of_type_AndroidOsBundle.putString("troop_uin", this.o);
    this.jdField_a_of_type_AndroidOsBundle.putString("uinname", this.n);
    switch (this.g)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsBundle.putInt("key_forward_ability_type", paramInt);
      return;
      this.k = null;
      this.jdField_l_of_type_JavaLangString = null;
      a(localCardOCRInfo);
      continue;
      this.k = null;
      this.jdField_l_of_type_JavaLangString = null;
      b(this.p, this.q);
      continue;
      this.k = null;
      this.jdField_l_of_type_JavaLangString = null;
      a(this.p, this.q, bool);
      continue;
      this.k = this.p;
      this.jdField_l_of_type_JavaLangString = this.q;
      this.jdField_d_of_type_Int = 0;
      G();
      continue;
      this.k = this.p;
      this.jdField_l_of_type_JavaLangString = this.q;
      this.jdField_j_of_type_Boolean = true;
      if (!bdee.d(BaseApplication.getContext()))
      {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131692397), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
        return;
      }
      this.jdField_a_of_type_Almt.a(Long.parseLong(this.p), true);
      a(2131695088);
      continue;
      this.k = null;
      this.jdField_l_of_type_JavaLangString = null;
      a(this.p, this.q);
    }
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amab);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_b_of_type_Almw);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bfvh);
    this.jdField_a_of_type_Almt = ((almt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6));
    this.m = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("curent_aio_uin");
    this.n = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("curent_aio_uinname");
    this.e = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("curent_aio_uin_type", 0);
    this.o = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("curent_aio_troop_uin");
    this.f = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("forward_type", -1);
    return true;
  }
  
  protected boolean a(bdfq parambdfq)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) {
      parambdfq.addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null));
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.setMargins(aekt.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, aekt.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardShareCardOption", 2, "updateImageView addStructView");
        }
        parambdfq.addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null), localLayoutParams);
      }
    }
  }
  
  public String b()
  {
    return this.jdField_a_of_type_AndroidAppActivity.getString(2131719922);
  }
  
  public String c()
  {
    String str = null;
    if (!TextUtils.isEmpty(this.n)) {
      str = this.n;
    }
    return str;
  }
  
  protected void d()
  {
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B4", "0X80056B4", 0, 0, "", "", "", "");
    super.d();
    if (this.jdField_i_of_type_Boolean) {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007013", "0X8007013", 0, 0, "", "", "", "");
    }
  }
  
  protected boolean h()
  {
    return true;
  }
  
  protected void r()
  {
    super.r();
    if (this.jdField_i_of_type_Boolean) {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007012", "0X8007012", 0, 0, "", "", "", "");
    }
  }
  
  public void w()
  {
    if (this.jdField_a_of_type_Amab != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amab);
    }
    if (this.jdField_b_of_type_Almw != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_b_of_type_Almw);
    }
    if (this.jdField_a_of_type_Bfvh != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bfvh);
    }
    super.w();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzs
 * JD-Core Version:    0.7.0.1
 */