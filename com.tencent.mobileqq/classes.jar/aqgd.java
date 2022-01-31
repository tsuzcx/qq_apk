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

public class aqgd
  extends aqbe
{
  ajvg jdField_a_of_type_Ajvg;
  private akil jdField_a_of_type_Akil = new aqge(this);
  private bdvm jdField_a_of_type_Bdvm = new aqgf(this);
  AbsShareMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
  AbsStructMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
  private ajvj b;
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
  
  public aqgd(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_Ajvj = new aqgg(this);
  }
  
  private void G()
  {
    boolean bool = false;
    if (!bbfj.d(BaseApplication.getContext()))
    {
      bcql.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131692321), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298865));
      if (QLog.isColorLevel()) {
        QLog.i("ForwardOption.ForwardShareCardOption", 2, "tryToGetShareLink: net is not supported");
      }
      this.jdField_c_of_type_Int = -1;
    }
    a(2131694931);
    if (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.k))
    {
      localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.k);
      ((bdvn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).b(this.k, ((TroopInfo)localObject).troopowneruin);
      return;
    }
    Object localObject = (akhp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    String str = this.k;
    if (this.jdField_c_of_type_Int == 0) {
      bool = true;
    }
    ((akhp)localObject).a(str, bool);
  }
  
  private View a(String paramString, Drawable paramDrawable)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131558905, null);
    TextView localTextView = (TextView)localView.findViewById(2131378528);
    ImageView localImageView = (ImageView)localView.findViewById(2131368031);
    localTextView.setText(paramString);
    localImageView.setImageDrawable(paramDrawable);
    return localView;
  }
  
  private static axuq a(String paramString)
  {
    axyo localaxyo = new axyo();
    localaxyo.b(1);
    localaxyo.a(paramString);
    return localaxyo;
  }
  
  public static final AbsShareMsg a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject1 = new axum(StructMsgForGeneralShare.class);
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
      paramString2 = ((axum)localObject1).c(84).a(2).a(ajya.a(2131704814) + paramQQAppInterface).a("plugin", "", "AppCmd://OpenContactInfo/?uin=", (String)localObject2, (String)localObject2).d(paramActivity.getResources().getString(2131718653)).a();
      localObject1 = new axxi();
      ((axuq)localObject1).b(1);
      ((axuq)localObject1).a(new axws((String)localObject2));
      ((axuq)localObject1).a(new StructMsgItemTitle(paramQQAppInterface));
      if (!paramString1.startsWith("+86")) {
        break label339;
      }
    }
    label299:
    label339:
    for (paramQQAppInterface = paramString1.substring("+86".length(), paramString1.length());; paramQQAppInterface = paramString1)
    {
      if (paramBoolean) {}
      for (paramActivity = ajya.a(2131704837);; paramActivity = ajya.a(2131704819))
      {
        paramQQAppInterface = new axzj(paramActivity + paramQQAppInterface);
        paramQQAppInterface.d(paramActivity + paramString1);
        ((axuq)localObject1).a(paramQQAppInterface);
        paramString2.addItem(a(ajya.a(2131704844)));
        paramString2.addItem((axup)localObject1);
        return paramString2;
        paramQQAppInterface = paramString2.trim();
        break;
        paramString2 = "&headtext=" + URLEncoder.encode(bbcz.a(paramQQAppInterface));
        break label47;
      }
    }
  }
  
  private void a(CardOCRInfo paramCardOCRInfo)
  {
    if (paramCardOCRInfo == null) {
      return;
    }
    Object localObject2 = new axum(StructMsgForGeneralShare.class);
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
      localObject2 = ((axum)localObject2).c(73).a(this.jdField_a_of_type_AndroidAppActivity.getString(2131698614, new Object[] { paramCardOCRInfo.a })).a(2).a("shareBusinessCard", "", (String)localObject3, (String)localObject3, (String)localObject3).d(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719433)).a();
      localObject3 = new axyo();
      ((axuq)localObject3).b(1);
      ((axuq)localObject3).a(this.jdField_a_of_type_AndroidAppActivity.getString(2131698611));
      axxi localaxxi = new axxi();
      localaxxi.b(3);
      localaxxi.a(new axws(paramCardOCRInfo.jdField_b_of_type_JavaLangString + "/?02"));
      localaxxi.a(new StructMsgItemTitle(paramCardOCRInfo.a));
      localaxxi.a(new axzj((String)localObject1));
      ((AbsShareMsg)localObject2).addItem((axup)localObject3);
      ((AbsShareMsg)localObject2).addItem(localaxxi);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("req_type", 5);
      ((Bundle)localObject1).putString("image_url", paramCardOCRInfo.jdField_b_of_type_JavaLangString);
      amev.a(paramCardOCRInfo.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = axva.a(((StructMsgForImageShare)axva.a((Bundle)localObject1)).getBytes());
      this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
      l();
      return;
      localObject1 = "";
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (!bduf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)) {}
    do
    {
      return;
      localObject1 = ((ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(paramString1);
    } while (localObject1 == null);
    Object localObject2 = new axum(StructMsgForGeneralShare.class);
    String str2 = "mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramString1 + "&cspecialflag=" + ((Friends)localObject1).cSpecialFlag;
    String str3 = "mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=" + paramString1 + "&version=1&cspecialflag=" + ((Friends)localObject1).cSpecialFlag;
    String str4 = "https://share.mp.qq.com/cgi/share.php?uin=" + paramString1 + "&account_flag=" + -7 + "&jumptype=1&card_type=crm&cspecialflag=" + ((Friends)localObject1).cSpecialFlag;
    String str1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + paramString1;
    Object localObject1 = bduf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      localObject1 = ((axum)localObject2).c(14).a(2).a(1).a(ajya.a(2131704834) + paramString2).a("plugin", str4, "", str2, str3).d(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718649)).a();
      localObject2 = new axxi();
      ((axuq)localObject2).b(1);
      ((axuq)localObject2).a(new axws(str1));
      ((axuq)localObject2).a(new StructMsgItemTitle(paramString2));
      ((axuq)localObject2).a(new axzj(ajya.a(2131704846) + bduf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)));
      ((AbsShareMsg)localObject1).addItem(a(ajya.a(2131704838)));
      ((AbsShareMsg)localObject1).addItem((axup)localObject2);
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
    int i1 = ((ajvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a(paramString);
    localObject = ((TicketManager)localObject).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      ThreadManager.post(new ForwardShareCardOption.1(this, i1, paramString, (String)localObject, paramBoolean), 8, null, false);
      return;
    }
    x();
    bcql.a(this.jdField_a_of_type_AndroidAppActivity, -1, ajya.a(2131704842), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298865));
  }
  
  private View b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
    {
      new RelativeLayout.LayoutParams(-1, -2).setMargins(actj.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, actj.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShareCardOption", 2, "updateImageView addStructView");
      }
      return this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null);
    }
    return new View(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  private void b(String paramString1, String paramString2)
  {
    Object localObject2 = new axum(StructMsgForGeneralShare.class);
    String str1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + paramString1;
    String str2 = "AppCmd://OpenContactInfo/?uin=" + paramString1;
    Object localObject1 = bbcz.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      localObject1 = ((axum)localObject2).c(14).a(2).a(1).a(ajya.a(2131704832) + paramString2).a("plugin", "", str2, str1, str1).d(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718649)).a();
      localObject2 = new axxi();
      ((axuq)localObject2).b(1);
      ((axuq)localObject2).a(new axws(str1));
      ((axuq)localObject2).a(new StructMsgItemTitle(paramString2));
      ((axuq)localObject2).a(new axzj(ajya.a(2131704798) + paramString1));
      ((AbsShareMsg)localObject1).addItem(a(ajya.a(2131704808)));
      ((AbsShareMsg)localObject1).addItem((axup)localObject2);
      this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localObject1);
      l();
      return;
      paramString2 = (String)localObject1;
    }
  }
  
  private void c(String paramString1, String paramString2)
  {
    AbsShareMsg localAbsShareMsg = new axum(StructMsgForGeneralShare.class).c(15).a(ajya.a(2131704824) + this.jdField_l_of_type_JavaLangString).e(this.jdField_j_of_type_JavaLangString).a();
    Object localObject = (ajvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
    if (localObject != null)
    {
      localObject = ((ajvi)localObject).a(paramString1);
      if (localObject == null) {}
    }
    for (paramString1 = bbcz.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, ((DiscussionInfo)localObject).ownerUin);; paramString1 = null)
    {
      localObject = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        localObject = ajya.a(2131704820);
      }
      paramString1 = axuz.a(2);
      paramString1.a(paramString2, this.jdField_l_of_type_JavaLangString, ajya.a(2131704843) + (String)localObject, 1);
      localAbsShareMsg.addItem(a(ajya.a(2131704804)));
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
      String str2 = bahv.a("", this.k, 0) + "100";
      AbsShareMsg localAbsShareMsg = new axum(StructMsgForGeneralShare.class).c(15).a(this.jdField_a_of_type_AndroidAppActivity.getString(2131718656) + str1).e(this.jdField_h_of_type_JavaLangString).a();
      axuq localaxuq = axuz.a(2);
      Object localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131719524);
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
        localaxuq.a(str2, str1, (String)localObject1, 1);
        localAbsShareMsg.addItem(a(ajya.a(2131704806)));
        localAbsShareMsg.addItem(localaxuq);
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
        localView1 = a(String.format("[%s]%s", new Object[] { ajya.a(2131704822), this.q }), bayh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.p));
        continue;
        localView1 = a(String.format("[%s]%s", new Object[] { ajya.a(2131704847), this.q }), bayh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 11, this.p));
        continue;
        localView1 = a(String.format("[%s]%s", new Object[] { ajya.a(2131704817), this.q }), bayh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, this.p));
        continue;
        localView1 = a(String.format("[%s]%s", new Object[] { ajya.a(2131704831), this.q }), bayh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 101, this.p));
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
    int i1 = ((askn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).d();
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
      if (!bbfj.d(BaseApplication.getContext()))
      {
        bcql.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131692321), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298865));
        return;
      }
      this.jdField_a_of_type_Ajvg.a(Long.parseLong(this.p), true);
      a(2131694931);
      continue;
      this.k = null;
      this.jdField_l_of_type_JavaLangString = null;
      a(this.p, this.q);
    }
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akil);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_b_of_type_Ajvj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bdvm);
    this.jdField_a_of_type_Ajvg = ((ajvg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6));
    this.m = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("curent_aio_uin");
    this.n = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("curent_aio_uinname");
    this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("curent_aio_uin_type", 0);
    this.o = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("curent_aio_troop_uin");
    this.e = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("forward_type", -1);
    return true;
  }
  
  protected boolean a(bbgu parambbgu)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) {
      parambbgu.addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null));
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.setMargins(actj.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, actj.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardShareCardOption", 2, "updateImageView addStructView");
        }
        parambbgu.addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null), localLayoutParams);
      }
    }
  }
  
  public String b()
  {
    return this.jdField_a_of_type_AndroidAppActivity.getString(2131719434);
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
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B4", "0X80056B4", 0, 0, "", "", "", "");
    super.d();
    if (this.jdField_i_of_type_Boolean) {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007013", "0X8007013", 0, 0, "", "", "", "");
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
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007012", "0X8007012", 0, 0, "", "", "", "");
    }
  }
  
  public void w()
  {
    if (this.jdField_a_of_type_Akil != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akil);
    }
    if (this.jdField_b_of_type_Ajvj != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_b_of_type_Ajvj);
    }
    if (this.jdField_a_of_type_Bdvm != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bdvm);
    }
    super.w();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqgd
 * JD-Core Version:    0.7.0.1
 */