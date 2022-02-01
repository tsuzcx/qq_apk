import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

public class azpe
  extends azkr
{
  private aayj jdField_a_of_type_Aayj;
  private boolean jdField_a_of_type_Boolean;
  
  public azpe(azlw paramazlw, azfe paramazfe)
  {
    super(paramazlw, paramazfe);
  }
  
  private boolean a(Card paramCard)
  {
    boolean bool1 = true;
    QLog.i("ProfileWeishiComponent", 2, "makeOrRefreshWeishiFeedList");
    if (this.jdField_a_of_type_Aayj == null) {
      return false;
    }
    boolean bool2 = a(paramCard, this.jdField_a_of_type_Biab);
    QLog.i("ProfileWeishiComponent", 2, "makeOrRefreshWeishiFeedList mIsRequestShow:" + this.jdField_a_of_type_Boolean + ", shouldShowWeishiPanel:" + bool2);
    if ((!this.jdField_a_of_type_Boolean) || (!bool2))
    {
      if (this.jdField_a_of_type_JavaLangObject == null) {
        break label221;
      }
      this.jdField_a_of_type_JavaLangObject = null;
    }
    label221:
    for (bool1 = true;; bool1 = false)
    {
      QLog.i("ProfileWeishiComponent", 2, "makeOrRefreshWeishiFeedList remove weishi panel!");
      return bool1;
      Object localObject;
      if ((View)this.jdField_a_of_type_JavaLangObject == null)
      {
        localObject = this.jdField_a_of_type_Azqi.a(a_());
        paramCard = (Card)localObject;
        if (localObject == null)
        {
          paramCard = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131559584, null);
          this.jdField_a_of_type_Aayj.a(paramCard);
          this.jdField_a_of_type_Aayj.a(new azpf(this));
        }
        this.jdField_a_of_type_JavaLangObject = paramCard;
        QLog.i("ProfileWeishiComponent", 2, "makeOrRefreshWeishiFeedList show weishi panel!");
      }
      for (;;)
      {
        paramCard = this.jdField_a_of_type_Aayj.a();
        localObject = this.jdField_a_of_type_Aayj.a();
        this.jdField_a_of_type_Aayj.b();
        a(paramCard, null, (ImageView)localObject);
        return bool1;
        bool1 = false;
      }
    }
  }
  
  private boolean a(Card paramCard, biab parambiab)
  {
    boolean bool1;
    if ((parambiab == null) || (parambiab.a(11)))
    {
      bool1 = true;
      if ((paramCard == null) || (paramCard.switchWeishi == 1)) {
        break label82;
      }
    }
    label82:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileWeishiComponent", 2, String.format("shouldShowWeishiPanelOrNot configEnable:%s,switchEnable:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      if ((!bool1) || (!bool2)) {
        break label88;
      }
      return true;
      bool1 = false;
      break;
    }
    label88:
    return false;
  }
  
  private void b(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getBundleExtra("result") != null) && (paramIntent.getBundleExtra("result").getBoolean("key_weishi_switch"))) {
      a();
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Aayj == null) {
      this.jdField_a_of_type_Aayj = new aayj(this);
    }
  }
  
  public int a()
  {
    return 1016;
  }
  
  public BaseActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  }
  
  public String a()
  {
    return "ProfileWeishiComponent";
  }
  
  public void a()
  {
    String str;
    if (this.jdField_a_of_type_Aayj != null)
    {
      str = ((azfe)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      QLog.i("ProfileWeishiComponent", 2, "[requestWeishiPanelInfo] currentCardUin:" + str);
    }
    for (;;)
    {
      try
      {
        Long.parseLong(str);
        if (((azfe)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          break label139;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(str)) {
          continue;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ProfileWeishiComponent", 2, "requestWeishiPanelInfo failed getLong, uin = " + str);
        return;
      }
      this.jdField_a_of_type_Aayj.a(bool, str);
      this.jdField_a_of_type_Aayj.c();
      return;
      boolean bool = false;
      continue;
      label139:
      bool = true;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1022) {
      b(paramIntent);
    }
    while ((paramInt2 != -1) || (paramInt1 != 1012)) {
      return;
    }
    b(paramIntent);
  }
  
  public void a(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.a(paramBaseActivity, paramBundle);
    i();
    a();
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.i("ProfileWeishiComponent", 2, "initOrRefreshWeishiPanel");
    if (this.jdField_a_of_type_Aayj == null) {
      this.jdField_a_of_type_Aayj = new aayj(this);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Azkz != null) {
      this.jdField_a_of_type_Azkz.b();
    }
  }
  
  public boolean a(azfe paramazfe)
  {
    boolean bool = super.a(paramazfe);
    return a(((azfe)this.b).jdField_a_of_type_ComTencentMobileqqDataCard) | bool;
  }
  
  public String a_()
  {
    return "map_key_mine_weishi";
  }
  
  public void c()
  {
    super.c();
    ulo.a((azfe)this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void d()
  {
    super.d();
    ulo.b((azfe)this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void f()
  {
    super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpe
 * JD-Core Version:    0.7.0.1
 */