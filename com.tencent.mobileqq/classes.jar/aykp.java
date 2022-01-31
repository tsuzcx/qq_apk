import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.contentbox.QZoneMsgActivity;
import java.util.ArrayList;

public class aykp
  extends ayjh
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public final PublicAccountInfo a;
  private String jdField_a_of_type_JavaLangString;
  private long b;
  private int c = -1;
  
  public aykp(QQAppInterface paramQQAppInterface, PublicAccountInfo paramPublicAccountInfo, int paramInt)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = paramPublicAccountInfo;
    if (paramQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin()))
    {
      this.b = aydi.O;
      return;
    }
    this.b = aydi.P;
  }
  
  protected long a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    long l2 = ayrd.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name, 1073741824L);
    long l1 = l2;
    if (l2 != -9223372036854775808L) {
      l1 = (l2 & 0x0) >> 20 | 0xFFFFFFFF & l2 | (0x0 & l2) >> 26;
    }
    if (l1 > this.jdField_a_of_type_Long) {
      this.jdField_a_of_type_Long = l1;
    }
    for (int i = 1;; i = 0)
    {
      if (this.jdField_a_of_type_Long != -9223372036854775808L)
      {
        if (this.b != aydi.O) {
          break label232;
        }
        this.jdField_a_of_type_Long |= 0x100000;
        if (!this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.isOffLine)
        {
          this.jdField_a_of_type_Long |= 0x0;
          if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.clickCount >= 3) {
            if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.clickCount >= 128) {
              break label247;
            }
          }
        }
      }
      label232:
      label247:
      for (this.jdField_a_of_type_Long |= (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.clickCount & 0x7F) << 32;; this.jdField_a_of_type_Long |= 0x0)
      {
        if (i != 0) {
          this.jdField_a_of_type_Long |= 0x0;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.certifiedGrade == 1L) {
          this.jdField_a_of_type_Long |= 0x80000000;
        }
        return this.jdField_a_of_type_Long;
        this.jdField_a_of_type_Long |= 0x80000;
        break;
      }
    }
  }
  
  public PublicAccountInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo;
  }
  
  public Object a()
  {
    return Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.uin);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    Object localObject2 = paramView.getContext();
    if (localObject2 == null) {}
    String str;
    label133:
    do
    {
      return;
      if ((localObject2 instanceof UniteSearchActivity))
      {
        ayrd.a("all_result", "clk_public_uin", new String[] { "" + this.jdField_a_of_type_JavaLangString });
        aynt.a(null, 0, this.c, "0X8009D51", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin(), null);
      }
      str = this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin();
      bdel.a(null, "pubAcc_aio_open", str);
      localObject1 = (aluw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
      if (!aljq.aQ.equals(str)) {
        break;
      }
      tch.a((Context)localObject2, "from_search_result", 1, true);
      ayrd.a(this.jdField_a_of_type_JavaLangString, 50, 0, paramView, str, this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.isOffLine, this.c);
      alxr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      ayrd.a(this.jdField_a_of_type_JavaLangString, 50, paramView, false);
    } while ((!(localObject2 instanceof BaseActivity)) || (this.jdField_a_of_type_Int <= 0));
    paramView = null;
    Object localObject1 = null;
    if ((localObject2 instanceof UniteSearchActivity))
    {
      paramView = "0X8005D1C";
      localObject1 = "0X8006570";
      label214:
      if (paramView == null) {
        break label882;
      }
      localObject2 = ((BaseActivity)localObject2).app;
      if (this.c != 12) {
        break label884;
      }
      azmj.b((QQAppInterface)localObject2, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 1, 0, this.jdField_a_of_type_Int + "", "", str, this.jdField_a_of_type_JavaLangString);
      label285:
      paramView = nru.a();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name;
      if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.extendType == 2) {
        break label935;
      }
    }
    label935:
    for (boolean bool = true;; bool = false)
    {
      paramView.a((QQAppInterface)localObject2, str, (String)localObject1, bool);
      return;
      if (aljq.aV.equals(str))
      {
        syb.a((Context)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        break label133;
      }
      if ((TextUtils.equals("2290230341", str)) && (QZoneMsgActivity.a((Context)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        break label133;
      }
      if (aljq.aR.equals(str))
      {
        KandianSubscribeManager.a((Context)localObject2, 3, 2);
        break label133;
      }
      if (aljq.aS.equals(str))
      {
        KandianDailyManager.a((Context)localObject2);
        break label133;
      }
      if (("2747277822".equals(str)) && (asjb.a()))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("settingInfo", "");
        ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_zf_games");
        ((Intent)localObject1).putExtra("moduleId", "cmshowgame_module");
        if (asjb.b())
        {
          PublicFragmentActivityForTool.b((Activity)localObject2, (Intent)localObject1, QQGameFeedWebFragment.class, 10000);
          asjd.a();
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("2747277822", 1008, false);
          break;
          PublicFragmentActivity.a((Activity)localObject2, (Intent)localObject1, QQGamePubAccountFragment.class, 10000);
        }
      }
      if (TextUtils.equals("3046055438", str))
      {
        nur.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Context)localObject2, str, ((Context)localObject2).getResources().getString(2131692015));
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("3046055438", 1008, false);
        break label133;
      }
      if (((localObject1 != null) && (((aluw)localObject1).a(Long.valueOf(str)))) || ((localObject1 == null) && (syb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str))))
      {
        Intent localIntent = new Intent(paramView.getContext(), ChatActivity.class);
        int i = 1008;
        if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.extendType == 2)
        {
          localIntent.putExtra("chat_subType", 1);
          i = 0;
        }
        if (TextUtils.isEmpty(str))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.w("PublicAccountSearchResultModel", 2, "uin is null");
          return;
        }
        localIntent.putExtra("uin", str);
        localIntent.putExtra("uintype", i);
        localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name);
        localIntent.putExtra("selfSet_leftViewText", ((Context)localObject2).getString(2131690623));
        ajgm.a = true;
        ajgm.a(localIntent);
        ((Context)localObject2).startActivity(localIntent);
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.clickCount += 1;
        if (localObject1 == null) {
          break label133;
        }
        ((aluw)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
        break label133;
      }
      if (TextUtils.isEmpty(str))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("PublicAccountSearchResultModel", 2, "uin is null");
        return;
      }
      localObject1 = new Intent(paramView.getContext(), AccountDetailActivity.class);
      ((Intent)localObject1).putExtra("uin", str);
      ((Intent)localObject1).putExtra("source", 4);
      ((Context)localObject2).startActivity((Intent)localObject1);
      break label133;
      if (!(localObject2 instanceof PublicAcntSearchActivity)) {
        break label214;
      }
      paramView = "0X8005D1E";
      localObject1 = "0X8006588";
      break label214;
      label882:
      break;
      label884:
      nrt.a((QQAppInterface)localObject2, "P_CliOper", "Pb_account_lifeservice", str, paramView, paramView, 0, 0, this.jdField_a_of_type_Int + "", "", this.jdField_a_of_type_JavaLangString, "", false);
      break label285;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin();
  }
  
  public int c()
  {
    return 1;
  }
  
  public CharSequence c()
  {
    SpannableString localSpannableString = new ayqs(new ArrayList(), a()).a(ayrd.a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.summary));
    Object localObject = localSpannableString;
    if (localSpannableString == null) {
      localObject = "";
    }
    return localObject;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name;
  }
  
  public int d()
  {
    return 0;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aykp
 * JD-Core Version:    0.7.0.1
 */