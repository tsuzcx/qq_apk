import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountHelper;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.contentbox.QZoneMsgActivity;
import java.util.ArrayList;

public class bcgv
  extends bcfn
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public final PublicAccountInfo a;
  private String jdField_a_of_type_JavaLangString;
  private long b;
  private int c = -1;
  
  public bcgv(QQAppInterface paramQQAppInterface, PublicAccountInfo paramPublicAccountInfo, int paramInt)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = paramPublicAccountInfo;
    if (paramQQAppInterface.a().a().isUinInRecent(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin()))
    {
      this.b = bbzf.O;
      return;
    }
    this.b = bbzf.P;
  }
  
  protected long a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    long l2 = bcni.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name, 1073741824L);
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
        if (this.b != bbzf.O) {
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
    label133:
    label910:
    label915:
    label918:
    for (;;)
    {
      return;
      if ((localObject2 instanceof UniteSearchActivity))
      {
        bcni.a("all_result", "clk_public_uin", new String[] { "" + this.jdField_a_of_type_JavaLangString });
        bcjy.a(null, 0, this.c, "0X8009D51", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin(), null);
      }
      String str = this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin();
      bhnx.a(null, "pubAcc_aio_open", str);
      Object localObject1 = (aody)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
      if (antf.aP.equals(str))
      {
        ueg.a((Context)localObject2, "from_search_result", 1, true);
        bcni.a(this.jdField_a_of_type_JavaLangString, 50, 0, paramView, str, this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.isOffLine, this.c);
        aoha.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
        bcni.a(this.jdField_a_of_type_JavaLangString, 50, paramView, false);
        if ((!(localObject2 instanceof BaseActivity)) || (this.jdField_a_of_type_Int <= 0)) {
          continue;
        }
        localObject1 = null;
        if (!(localObject2 instanceof UniteSearchActivity)) {
          break label839;
        }
        localObject1 = "0X8006570";
        paramView = "0X8005D1C";
      }
      for (;;)
      {
        label212:
        if (paramView == null) {
          break label918;
        }
        localObject2 = ((BaseActivity)localObject2).app;
        if (this.c == 12)
        {
          bdll.b((QQAppInterface)localObject2, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 1, 0, this.jdField_a_of_type_Int + "", "", str, this.jdField_a_of_type_JavaLangString);
          label283:
          paramView = oce.a();
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name;
          if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.extendType == 2) {
            break label910;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          paramView.a((QQAppInterface)localObject2, str, (String)localObject1, bool);
          return;
          if (antf.aV.equals(str))
          {
            tzq.a((Context)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            break label133;
          }
          if ((TextUtils.equals("2290230341", str)) && (QZoneMsgActivity.a((Context)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
            break label133;
          }
          if (antf.aQ.equals(str))
          {
            KandianSubscribeManager.a((Context)localObject2, 3, 2);
            break label133;
          }
          if (antf.aR.equals(str))
          {
            KandianDailyManager.a((Context)localObject2);
            break label133;
          }
          if (("2747277822".equals(str)) && (avmc.a()))
          {
            avme.b((Context)localObject2);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("2747277822", 1008, false);
            break label133;
          }
          if (MiniGamePublicAccountHelper.shouldOpenWebFragment(str))
          {
            MiniGamePublicAccountHelper.launchMiniGamePublicAccount((Context)localObject2);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(antf.aW, 1008, false);
            break label133;
          }
          if (ayvd.jdField_a_of_type_JavaLangString.equals(str))
          {
            ayvf.a((Context)localObject2, str, 3);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(ayvd.jdField_a_of_type_JavaLangString, 1008, false);
            break label133;
          }
          if (TextUtils.equals("3046055438", str))
          {
            oga.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Context)localObject2);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("3046055438", 1008, false);
            break label133;
          }
          if (((localObject1 != null) && (((aody)localObject1).a(Long.valueOf(str)))) || ((localObject1 == null) && (tzq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str))))
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
            localIntent.putExtra("selfSet_leftViewText", ((Context)localObject2).getString(2131690559));
            alpb.a = true;
            alpb.a(localIntent);
            ((Context)localObject2).startActivity(localIntent);
            this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.clickCount += 1;
            if (localObject1 == null) {
              break label133;
            }
            ((aody)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
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
          label839:
          if (!(localObject2 instanceof PublicAcntSearchActivity)) {
            break label915;
          }
          localObject1 = "0X8006588";
          paramView = "0X8005D1E";
          break label212;
          ocd.a((QQAppInterface)localObject2, "P_CliOper", "Pb_account_lifeservice", str, paramView, paramView, 0, 0, this.jdField_a_of_type_Int + "", "", this.jdField_a_of_type_JavaLangString, "", false);
          break label283;
        }
        paramView = null;
      }
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
    SpannableString localSpannableString = new bcmx(new ArrayList(), a()).a(bcni.a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.summary));
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
 * Qualified Name:     bcgv
 * JD-Core Version:    0.7.0.1
 */