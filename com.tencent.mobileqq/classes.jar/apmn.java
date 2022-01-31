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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.List;
import java.util.Set;
import mqq.manager.TicketManager;

public class apmn
  extends aphp
{
  ajhf jdField_a_of_type_Ajhf;
  private ajuc jdField_a_of_type_Ajuc = new apmo(this);
  private bcqu jdField_a_of_type_Bcqu = new apmp(this);
  AbsShareMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
  AbsStructMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
  private ajhi b;
  private int c;
  private int d;
  private int e;
  private int f;
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
  
  public apmn(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_Ajhi = new apmq(this);
  }
  
  private void G()
  {
    boolean bool = false;
    if (!badq.d(BaseApplication.getContext()))
    {
      bbmy.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131626719), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131167766));
      if (QLog.isColorLevel()) {
        QLog.i("ForwardOption.ForwardShareCardOption", 2, "tryToGetShareLink: net is not supported");
      }
      this.jdField_c_of_type_Int = -1;
    }
    a(2131629253);
    if (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.k))
    {
      localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.k);
      ((bcqv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).b(this.k, ((TroopInfo)localObject).troopowneruin);
      return;
    }
    Object localObject = (ajtg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    String str = this.k;
    if (this.jdField_c_of_type_Int == 0) {
      bool = true;
    }
    ((ajtg)localObject).a(str, bool);
  }
  
  private View a(String paramString, Drawable paramDrawable)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131493344, null);
    TextView localTextView = (TextView)localView.findViewById(2131312699);
    ImageView localImageView = (ImageView)localView.findViewById(2131302411);
    localTextView.setText(paramString);
    localImageView.setImageDrawable(paramDrawable);
    return localView;
  }
  
  private static awum a(String paramString)
  {
    awyk localawyk = new awyk();
    localawyk.b(1);
    localawyk.a(paramString);
    return localawyk;
  }
  
  public static final AbsShareMsg a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject1 = new awui(StructMsgForGeneralShare.class);
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
      paramString2 = ((awui)localObject1).c(84).a(2).a(ajjy.a(2131639018) + paramQQAppInterface).a("plugin", "", "AppCmd://OpenContactInfo/?uin=", (String)localObject2, (String)localObject2).d(paramActivity.getResources().getString(2131652817)).a();
      localObject1 = new awxe();
      ((awum)localObject1).b(1);
      ((awum)localObject1).a(new awwo((String)localObject2));
      ((awum)localObject1).a(new StructMsgItemTitle(paramQQAppInterface));
      if (!paramString1.startsWith("+86")) {
        break label339;
      }
    }
    label299:
    label339:
    for (paramQQAppInterface = paramString1.substring("+86".length(), paramString1.length());; paramQQAppInterface = paramString1)
    {
      if (paramBoolean) {}
      for (paramActivity = ajjy.a(2131639041);; paramActivity = ajjy.a(2131639023))
      {
        paramQQAppInterface = new awzf(paramActivity + paramQQAppInterface);
        paramQQAppInterface.d(paramActivity + paramString1);
        ((awum)localObject1).a(paramQQAppInterface);
        paramString2.addItem(a(ajjy.a(2131639048)));
        paramString2.addItem((awul)localObject1);
        return paramString2;
        paramQQAppInterface = paramString2.trim();
        break;
        paramString2 = "&headtext=" + URLEncoder.encode(babh.a(paramQQAppInterface));
        break label47;
      }
    }
  }
  
  private void a(CardOCRInfo paramCardOCRInfo)
  {
    if (paramCardOCRInfo == null) {
      return;
    }
    Object localObject2 = new awui(StructMsgForGeneralShare.class);
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
      localObject2 = ((awui)localObject2).c(73).a(this.jdField_a_of_type_AndroidAppActivity.getString(2131632868, new Object[] { paramCardOCRInfo.a })).a(2).a("shareBusinessCard", "", (String)localObject3, (String)localObject3, (String)localObject3).d(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131653591)).a();
      localObject3 = new awyk();
      ((awum)localObject3).b(1);
      ((awum)localObject3).a(this.jdField_a_of_type_AndroidAppActivity.getString(2131632865));
      awxe localawxe = new awxe();
      localawxe.b(3);
      localawxe.a(new awwo(paramCardOCRInfo.jdField_b_of_type_JavaLangString + "/?02"));
      localawxe.a(new StructMsgItemTitle(paramCardOCRInfo.a));
      localawxe.a(new awzf((String)localObject1));
      ((AbsShareMsg)localObject2).addItem((awul)localObject3);
      ((AbsShareMsg)localObject2).addItem(localawxe);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("req_type", 5);
      ((Bundle)localObject1).putString("image_url", paramCardOCRInfo.jdField_b_of_type_JavaLangString);
      alqg.a(paramCardOCRInfo.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = awuw.a(((StructMsgForImageShare)awuw.a((Bundle)localObject1)).getBytes());
      this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
      l();
      return;
      localObject1 = "";
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (!bcpn.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)) {}
    do
    {
      return;
      localObject1 = ((ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(paramString1);
    } while (localObject1 == null);
    Object localObject2 = new awui(StructMsgForGeneralShare.class);
    String str2 = "mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramString1 + "&cspecialflag=" + ((Friends)localObject1).cSpecialFlag;
    String str3 = "mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=" + paramString1 + "&version=1&cspecialflag=" + ((Friends)localObject1).cSpecialFlag;
    String str4 = "https://share.mp.qq.com/cgi/share.php?uin=" + paramString1 + "&account_flag=" + -7 + "&jumptype=1&card_type=crm&cspecialflag=" + ((Friends)localObject1).cSpecialFlag;
    String str1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + paramString1;
    Object localObject1 = bcpn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      localObject1 = ((awui)localObject2).c(14).a(2).a(1).a(ajjy.a(2131639038) + paramString2).a("plugin", str4, "", str2, str3).d(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131652813)).a();
      localObject2 = new awxe();
      ((awum)localObject2).b(1);
      ((awum)localObject2).a(new awwo(str1));
      ((awum)localObject2).a(new StructMsgItemTitle(paramString2));
      ((awum)localObject2).a(new awzf(ajjy.a(2131639050) + bcpn.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)));
      ((AbsShareMsg)localObject1).addItem(a(ajjy.a(2131639042)));
      ((AbsShareMsg)localObject1).addItem((awul)localObject2);
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
    int i1 = ((ajhh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a(paramString);
    localObject = ((TicketManager)localObject).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      ThreadManager.post(new ForwardShareCardOption.1(this, i1, paramString, (String)localObject, paramBoolean), 8, null, false);
      return;
    }
    x();
    bbmy.a(this.jdField_a_of_type_AndroidAppActivity, -1, ajjy.a(2131639046), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131167766));
  }
  
  private View b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
    {
      new RelativeLayout.LayoutParams(-1, -2).setMargins(aciy.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, aciy.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShareCardOption", 2, "updateImageView addStructView");
      }
      return this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null);
    }
    return new View(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  private void b(String paramString1, String paramString2)
  {
    Object localObject2 = new awui(StructMsgForGeneralShare.class);
    String str1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + paramString1;
    String str2 = "AppCmd://OpenContactInfo/?uin=" + paramString1;
    Object localObject1 = babh.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      localObject1 = ((awui)localObject2).c(14).a(2).a(1).a(ajjy.a(2131639036) + paramString2).a("plugin", "", str2, str1, str1).d(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131652813)).a();
      localObject2 = new awxe();
      ((awum)localObject2).b(1);
      ((awum)localObject2).a(new awwo(str1));
      ((awum)localObject2).a(new StructMsgItemTitle(paramString2));
      ((awum)localObject2).a(new awzf(ajjy.a(2131639002) + paramString1));
      ((AbsShareMsg)localObject1).addItem(a(ajjy.a(2131639012)));
      ((AbsShareMsg)localObject1).addItem((awul)localObject2);
      this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localObject1);
      l();
      return;
      paramString2 = (String)localObject1;
    }
  }
  
  private void c(String paramString1, String paramString2)
  {
    AbsShareMsg localAbsShareMsg = new awui(StructMsgForGeneralShare.class).c(15).a(ajjy.a(2131639028) + this.jdField_l_of_type_JavaLangString).e(this.jdField_j_of_type_JavaLangString).a();
    Object localObject = (ajhh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
    if (localObject != null)
    {
      localObject = ((ajhh)localObject).a(paramString1);
      if (localObject == null) {}
    }
    for (paramString1 = babh.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, ((DiscussionInfo)localObject).ownerUin);; paramString1 = null)
    {
      localObject = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        localObject = ajjy.a(2131639024);
      }
      paramString1 = awuv.a(2);
      paramString1.a(paramString2, this.jdField_l_of_type_JavaLangString, ajjy.a(2131639047) + (String)localObject, 1);
      localAbsShareMsg.addItem(a(ajjy.a(2131639008)));
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
      String str2 = azge.a("", this.k, 0) + "100";
      AbsShareMsg localAbsShareMsg = new awui(StructMsgForGeneralShare.class).c(15).a(this.jdField_a_of_type_AndroidAppActivity.getString(2131652820) + str1).e(this.jdField_h_of_type_JavaLangString).a();
      awum localawum = awuv.a(2);
      Object localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131653630);
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
        localawum.a(str2, str1, (String)localObject1, 1);
        localAbsShareMsg.addItem(a(ajjy.a(2131639010)));
        localAbsShareMsg.addItem(localawum);
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
    switch (this.f)
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
        localView1 = a(String.format("[%s]%s", new Object[] { ajjy.a(2131639026), this.q }), azwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.p));
        continue;
        localView1 = a(String.format("[%s]%s", new Object[] { ajjy.a(2131639051), this.q }), azwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 11, this.p));
        continue;
        localView1 = a(String.format("[%s]%s", new Object[] { ajjy.a(2131639021), this.q }), azwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, this.p));
        continue;
        localView1 = a(String.format("[%s]%s", new Object[] { ajjy.a(2131639035), this.q }), azwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 101, this.p));
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
      this.jdField_a_of_type_JavaUtilSet.add(jdField_c_of_type_JavaLangInteger);
    }
    int i1 = ((aroh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).d();
    if ((i1 >= 9) || ((this.e == 23) && ((i1 == 1) || (i1 == 2) || (i1 == 6) || (i1 == 7) || (i1 == 3)))) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_h_of_type_JavaLangInteger);
    }
    this.jdField_a_of_type_JavaUtilSet.add(jdField_l_of_type_JavaLangInteger);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardShareCardOption", 2, "build forward ability in state=" + i1 + ", type=" + this.e);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (!e()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = null;
    this.f = paramBundle.getInt("uintype");
    this.p = paramBundle.getString("uin");
    this.q = paramBundle.getString("uinname");
    paramBundle.getString("troop_uin");
    CardOCRInfo localCardOCRInfo = (CardOCRInfo)paramBundle.getParcelable("business_card_ocr");
    boolean bool = paramBundle.getBoolean("bindContact", true);
    this.jdField_a_of_type_AndroidOsBundle.putString("uin", this.m);
    this.jdField_a_of_type_AndroidOsBundle.putInt("uintype", this.jdField_d_of_type_Int);
    this.jdField_a_of_type_AndroidOsBundle.putString("troop_uin", this.o);
    this.jdField_a_of_type_AndroidOsBundle.putString("uinname", this.n);
    switch (this.f)
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
      this.jdField_c_of_type_Int = 0;
      G();
      continue;
      this.k = this.p;
      this.jdField_l_of_type_JavaLangString = this.q;
      this.jdField_j_of_type_Boolean = true;
      if (!badq.d(BaseApplication.getContext()))
      {
        bbmy.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131626719), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131167766));
        return;
      }
      this.jdField_a_of_type_Ajhf.a(Long.parseLong(this.p), true);
      a(2131629253);
      continue;
      this.k = null;
      this.jdField_l_of_type_JavaLangString = null;
      a(this.p, this.q);
    }
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajuc);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_b_of_type_Ajhi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bcqu);
    this.jdField_a_of_type_Ajhf = ((ajhf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6));
    this.m = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("curent_aio_uin");
    this.n = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("curent_aio_uinname");
    this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("curent_aio_uin_type", 0);
    this.o = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("curent_aio_troop_uin");
    this.e = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("forward_type", -1);
    return true;
  }
  
  protected boolean a(bafb parambafb)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) {
      parambafb.addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null));
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.setMargins(aciy.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, aciy.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardShareCardOption", 2, "updateImageView addStructView");
        }
        parambafb.addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null), localLayoutParams);
      }
    }
  }
  
  public String b()
  {
    return this.jdField_a_of_type_AndroidAppActivity.getString(2131653592);
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
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B4", "0X80056B4", 0, 0, "", "", "", "");
    super.d();
    if (this.jdField_i_of_type_Boolean) {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007013", "0X8007013", 0, 0, "", "", "", "");
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
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007012", "0X8007012", 0, 0, "", "", "", "");
    }
  }
  
  public void w()
  {
    if (this.jdField_a_of_type_Ajuc != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajuc);
    }
    if (this.jdField_b_of_type_Ajhi != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_b_of_type_Ajhi);
    }
    if (this.jdField_a_of_type_Bcqu != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bcqu);
    }
    super.w();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apmn
 * JD-Core Version:    0.7.0.1
 */