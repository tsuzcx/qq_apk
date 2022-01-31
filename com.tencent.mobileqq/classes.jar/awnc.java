import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class awnc
  extends awoe
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = awii.L;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  public awnc(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    super(paramQQAppInterface, paramInt1, paramLong);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt2;
    a();
  }
  
  private void a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
    case 6000: 
    case 9002: 
    case 5000: 
    case 7120: 
    case 7210: 
    case 7230: 
    case 1001: 
    case 10002: 
    case 7000: 
      do
      {
        for (;;)
        {
          if (!TextUtils.isEmpty(this.c))
          {
            this.d = ChnToSpell.a(this.c, 1).toLowerCase();
            this.e = ChnToSpell.a(this.c, 2).toLowerCase();
          }
          return;
          this.c = BaseApplicationImpl.sApplication.getString(2131693965);
          continue;
          this.c = BaseApplicationImpl.sApplication.getString(2131689607);
          continue;
          this.c = BaseApplicationImpl.sApplication.getString(2131720416);
          continue;
          this.c = BaseApplicationImpl.sApplication.getString(2131691959);
          continue;
          this.c = sfe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
          continue;
          this.c = saz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          continue;
          this.c = BaseApplicationImpl.sApplication.getString(2131693271);
          continue;
          this.c = BaseApplicationImpl.sApplication.getString(2131693273);
        }
        this.c = BaseApplicationImpl.sApplication.getString(2131719823);
      } while (ajsd.x.equals(this.jdField_a_of_type_JavaLangString));
      localObject1 = (ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (localObject1 == null) {
        break;
      }
    }
    for (Object localObject1 = ((ajxl)localObject1).e(this.jdField_a_of_type_JavaLangString);; localObject1 = null)
    {
      if ((localObject1 != null) && (((Friends)localObject1).name != null)) {}
      for (Object localObject2 = ((Friends)localObject1).name;; localObject2 = this.jdField_a_of_type_JavaLangString)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (!((String)localObject2).equals(this.jdField_a_of_type_JavaLangString)) {}
        }
        else
        {
          String str = bbcz.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, true);
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(str)) {
            localObject1 = str;
          }
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = this.jdField_a_of_type_JavaLangString;
        }
        this.c = (this.c + "(" + (String)localObject2 + ")");
        break;
      }
      this.c = BaseApplicationImpl.sApplication.getString(2131691088);
      break;
      this.c = BaseApplicationImpl.sApplication.getString(2131690531);
      break;
      this.c = BaseApplicationImpl.sApplication.getString(2131694632);
      break;
      if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, ajsd.az)) {
        break;
      }
      this.c = sfe.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
      break;
      this.c = sfe.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
      break;
    }
  }
  
  protected long a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Long = -9223372036854775808L;
    long l = awwa.b(paramString, this.c, awii.l);
    if (l > this.jdField_b_of_type_Long) {
      this.jdField_b_of_type_Long = l;
    }
    if ((this.jdField_a_of_type_Int == 7220) || ((this.jdField_a_of_type_Int == 1008) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, ajsd.az))))
    {
      l = awwa.b(paramString, ajya.a(2131693701), awii.l);
      if (l > this.jdField_b_of_type_Long) {
        this.jdField_b_of_type_Long = l;
      }
    }
    if ((bhvy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (this.jdField_a_of_type_Int == 7220))
    {
      l = awwa.b(paramString, String.format(BaseApplicationImpl.sApplication.getString(2131699653), new Object[] { sfe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()), sfe.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()), sfe.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()) }), awii.p);
      if (l > this.jdField_b_of_type_Long) {
        this.jdField_b_of_type_Long = l;
      }
    }
    if (this.jdField_a_of_type_Int == 9002)
    {
      l = awwa.b(paramString, BaseApplicationImpl.sApplication.getString(2131689854), awii.p);
      if (l > this.jdField_b_of_type_Long) {
        this.jdField_b_of_type_Long = l;
      }
    }
    if (this.jdField_b_of_type_Long != -9223372036854775808L)
    {
      this.jdField_b_of_type_Long += awii.N;
      if ((ajsd.ae.equals(b())) && ((ajya.a(2131702559).equals(paramString)) || (ajya.a(2131702566).equals(paramString)) || (ajya.a(2131702541).equals(paramString)))) {
        this.jdField_b_of_type_Long = (awii.x + 1L);
      }
    }
    return this.jdField_b_of_type_Long;
  }
  
  public Object a()
  {
    return "tool:" + this.jdField_a_of_type_JavaLangString;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (awwa.a(this.jdField_b_of_type_Int))
    {
      switch (this.jdField_a_of_type_Int)
      {
      }
      for (;;)
      {
        akgb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
        long l1 = 0L;
        try
        {
          long l2 = Long.parseLong(this.jdField_a_of_type_JavaLangString);
          l1 = l2;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            Object localObject;
            nqn localnqn;
            int j;
            int i;
            localNumberFormatException.printStackTrace();
          }
        }
        awwa.a(this.jdField_b_of_type_JavaLangString, 20, (int)l1, paramView);
        return;
        localObject = new Intent(paramView.getContext(), LiteActivity.class);
        ((Intent)localObject).putExtra("targetUin", ajsd.z);
        ahpd.a = true;
        ahpd.a((Intent)localObject);
        paramView.getContext().startActivity((Intent)localObject);
        continue;
        localObject = new Intent(paramView.getContext(), ActivateFriendActivity.class);
        ((Intent)localObject).putExtra("af_key_from", 5);
        paramView.getContext().startActivity((Intent)localObject);
        if ((this.jdField_b_of_type_Int == 2) || (this.jdField_b_of_type_Int == 1))
        {
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006477", "0X8006477", this.jdField_b_of_type_Int, 0, "", "", "", "");
          continue;
          localObject = new Intent(paramView.getContext(), EcshopWebActivity.class);
          ((Intent)localObject).putExtra("from_search", true);
          ((Intent)localObject).setFlags(67108864);
          localnqn = (nqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
          if (localnqn != null) {
            localnqn.a((Intent)localObject, paramView.getContext(), -1);
          }
          paramView.getContext().startActivity((Intent)localObject);
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Clk_Searchshopfolder", 0, 0, "", "", "", "");
          continue;
          localObject = sdc.a();
          ((sdc)localObject).e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
          ((sdc)localObject).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
          if (bhvy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
          for (localObject = nuq.a(paramView.getContext(), 0, 1);; localObject = nuq.a(paramView.getContext(), -1, 1))
          {
            ((Intent)localObject).putExtra("come_from", 1);
            ((Intent)localObject).setFlags(67108864);
            paramView.getContext().startActivity((Intent)localObject);
            break;
          }
          wis.a(paramView.getContext(), 9005, null);
          if (QLog.isColorLevel())
          {
            QLog.d("ContactSearchModelTool", 2, "enterServiceAccountFolderActivityFromSearch");
            continue;
            MsgBoxListActivity.a(paramView.getContext(), 1001, String.valueOf(9999L));
            continue;
            localObject = new Intent(paramView.getContext(), TroopAssistantActivity.class);
            ((Intent)localObject).setFlags(67108864);
            paramView.getContext().startActivity((Intent)localObject);
            continue;
            ayap.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.getContext(), this.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
            continue;
            localObject = new Intent();
            ((Intent)localObject).putExtra("key_tab_mode", 2);
            ((Intent)localObject).setClass(paramView.getContext(), TroopActivity.class);
            j = aydd.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            i = j;
            if (j <= 0) {
              i = akfc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(ajsd.W, 9000, -i);
            paramView.getContext().startActivity((Intent)localObject);
            continue;
            ((afax)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(138)).a(paramView.getContext());
            continue;
            NewFriendActivity.a(paramView.getContext(), null, 0);
            continue;
            if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, ajsd.az))
            {
              nol.a(null, "CliOper", "", "", "0X800671A", "0X800671A", 0, 0, "", "", "", "", false);
              nuq.a(paramView.getContext(), null, -1L, 1);
              sgg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
              awwa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), this.jdField_a_of_type_JavaLangString, "", this.jdField_a_of_type_Int);
              continue;
              nuq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.getContext(), 1, 0);
              nol.a(null, "CliOper", "", "", "0X800671A", "0X800671A", 0, 0, "", "", "", "", false);
              sgg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
              awwa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), this.jdField_a_of_type_JavaLangString, "", this.jdField_a_of_type_Int);
            }
          }
        }
      }
    }
    awwa.a(paramView, this);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public int c()
  {
    return ((Integer)ahnr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString).first).intValue();
  }
  
  public CharSequence c()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return null;
    case 9002: 
      return awwa.a(BaseApplicationImpl.sApplication.getString(2131689854), this.jdField_b_of_type_JavaLangString, 255);
    }
    return awwa.a(String.format(BaseApplicationImpl.sApplication.getString(2131699653), new Object[] { sfe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()), sfe.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()), sfe.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()) }), this.jdField_b_of_type_JavaLangString, 255);
  }
  
  public String c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return null;
  }
  
  public int e()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awnc
 * JD-Core Version:    0.7.0.1
 */