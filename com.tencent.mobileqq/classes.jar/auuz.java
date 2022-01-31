import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.now.ShareToQQActivity;
import com.tencent.mobileqq.profile.ProfileCardShareHelper.3;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class auuz
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new auva(this);
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new auvb(this);
  private auvc jdField_a_of_type_Auvc;
  private bbjc jdField_a_of_type_Bbjc;
  private bcpq jdField_a_of_type_Bcpq;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  
  public auuz(Activity paramActivity, QQAppInterface paramQQAppInterface, int paramInt, auvc paramauvc)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Auvc = paramauvc;
    if (paramQQAppInterface == null) {
      a();
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardShareHelper", 2, String.format("decodeFace: %s", new Object[] { paramString }));
    }
    ThreadManager.getSubThreadHandler().post(new ProfileCardShareHelper.3(this, paramString));
  }
  
  private void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Boolean = false;
    long l = System.currentTimeMillis();
    paramString1 = "https://ti.qq.com/open_qq/index2.html?url=mqqapi%3a%2f%2fuserprofile%2ffriend_profile_card%3fsrc_type%3dweb%26version%3d1.0%26source%3d2%26uin%3d" + paramString1;
    WXShareHelper.a().d(String.valueOf(l), paramString2, paramBitmap, "来自QQ的推荐好友", paramString1);
  }
  
  private List<bbje>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    bbje localbbje = new bbje();
    localbbje.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131696695);
    localbbje.jdField_b_of_type_Int = 2130838754;
    localbbje.jdField_b_of_type_Boolean = true;
    localbbje.c = 2;
    localbbje.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbje);
    localbbje = new bbje();
    localbbje.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131696715);
    localbbje.jdField_b_of_type_Int = 2130838758;
    localbbje.c = 9;
    localbbje.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbje);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  private void e()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      QLog.d("ProfileCardShareHelper", 1, String.format("shareToFriend, uin or nickname is empty, uin: %s, nickname: %s", new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
    }
    for (;;)
    {
      return;
      Object localObject1 = new axuk(StructMsgForGeneralShare.class);
      String str1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + this.jdField_a_of_type_JavaLangString;
      String str2 = "AppCmd://OpenContactInfo/?uin=" + this.jdField_a_of_type_JavaLangString;
      String str3 = ajyc.a(2131708436);
      String str4 = ajyc.a(2131708482) + this.jdField_a_of_type_JavaLangString;
      String str5 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718638);
      localObject1 = ((axuk)localObject1).c(14).a(ajyc.a(2131708465) + this.jdField_b_of_type_JavaLangString).a(2).a(1).a("plugin", "", str2, str1, str1).d(str5).a();
      Object localObject2 = new axym();
      ((axuo)localObject2).b(1);
      ((axuo)localObject2).a(str3);
      axxg localaxxg = new axxg();
      localaxxg.b(1);
      localaxxg.a(new axwq(str1));
      localaxxg.a(new StructMsgItemTitle(this.jdField_b_of_type_JavaLangString));
      localaxxg.a(new axzh(str4));
      ((AbsShareMsg)localObject1).addItem((axun)localObject2);
      ((AbsShareMsg)localObject1).addItem(localaxxg);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("forward_type", 20);
      ((Bundle)localObject2).putInt("structmsg_service_id", 14);
      ((Bundle)localObject2).putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
      ((Bundle)localObject2).putBoolean("k_dataline", false);
      if (this.jdField_a_of_type_Int == 1)
      {
        localObject1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ShareToQQActivity.class);
        ((Bundle)localObject2).putString("sourceFrom", "share_from_troop_member_card");
        ((Intent)localObject1).putExtras((Bundle)localObject2);
        this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject1);
      }
      while (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder(300);
        ((StringBuilder)localObject1).append("recommentFriend [title: ").append(str3).append(", nickname: ").append(this.jdField_b_of_type_JavaLangString).append(", info: ").append(str4).append(", serviceId: ").append(14).append(", pActionData: ").append(str2).append(", aActionData: ").append(str1).append(", iActionData: ").append(str1).append(", compatibleText: ").append(str5).append("]");
        QLog.i("ProfileCardShareHelper", 2, ((StringBuilder)localObject1).toString());
        return;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtras((Bundle)localObject2);
        aqbc.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject1, 21);
      }
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    int i;
    if (!WXShareHelper.a().a()) {
      i = 2131720906;
    }
    for (;;)
    {
      if (i != -1)
      {
        bcpw.a(this.jdField_a_of_type_AndroidAppActivity, 1, i, 1).a();
        QLog.d("ProfileCardShareHelper", 1, "shareToWXFriend, but wechat is not install or version is too low");
        return;
        if (!WXShareHelper.a().b()) {
          i = 2131720907;
        }
      }
      else
      {
        this.jdField_a_of_type_Boolean = true;
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsBitmap);
          return;
        }
        if (apvb.a(this.c)) {
          a(this.c);
        }
        for (;;)
        {
          b();
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            this.c = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, this.jdField_a_of_type_JavaLangString, 0);
            a(this.c);
          }
          else
          {
            ArrayList localArrayList = new ArrayList(1);
            localArrayList.add(this.jdField_a_of_type_JavaLangString);
            Intent localIntent = new Intent("com.tencent.qqhead.getheadreq");
            localIntent.putExtra("faceType", 1);
            localIntent.putStringArrayListExtra("uinList", localArrayList);
            this.jdField_a_of_type_AndroidAppActivity.sendBroadcast(localIntent, "com.tencent.qqhead.permission.getheadresp");
          }
        }
      }
      i = -1;
    }
  }
  
  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.qqhead.getheadresp");
    this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.qqhead.permission.getheadresp", null);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardShareHelper", 2, String.format("share, uin: %s, nickname: %s", new Object[] { paramString1, paramString2 }));
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      if (!paramString1.equals(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_JavaLangString = paramString2;
      if (this.jdField_a_of_type_Bbjc == null)
      {
        this.jdField_a_of_type_Bbjc = new bbjc(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_Bbjc.a(a());
        this.jdField_a_of_type_Bbjc.a(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
      }
    } while (this.jdField_a_of_type_Bbjc.a());
    this.jdField_a_of_type_Bbjc.a();
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()))
    {
      if (this.jdField_a_of_type_Bcpq == null)
      {
        this.jdField_a_of_type_Bcpq = new bcpq(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298865));
        this.jdField_a_of_type_Bcpq.setCancelable(false);
      }
      this.jdField_a_of_type_Bcpq.a(ajyc.a(2131708466));
      this.jdField_a_of_type_Bcpq.show();
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing()))
    {
      this.jdField_a_of_type_Bcpq.dismiss();
      this.jdField_a_of_type_Bcpq = null;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auuz
 * JD-Core Version:    0.7.0.1
 */