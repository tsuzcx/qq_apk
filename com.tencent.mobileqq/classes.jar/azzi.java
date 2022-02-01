import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView;
import java.util.ArrayList;
import java.util.List;

public class azzi
  extends azwo
{
  private azzo jdField_a_of_type_Azzo = new azzj(this);
  private AnonymousView jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousViewsAnonymousView;
  
  public azzi(azxt paramazxt, azrb paramazrb)
  {
    super(paramazxt, paramazrb);
  }
  
  private List<azzl> a(List<azzl> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int j = 0;
    boolean bool = b();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileAnonymousComponent", 0, String.format("buildRecyclerAdapterData() isHost=%b, hasQuestion=%b , hasAnswer=%b ,hasMoreQues=%b ,", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) }));
    }
    ArrayList localArrayList = new ArrayList();
    azzl localazzl = new azzl();
    if (bool)
    {
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          localArrayList.addAll(paramList);
          int i;
          if (paramList.size() <= 10)
          {
            i = j;
            if (paramList.size() == 10)
            {
              i = j;
              if (!paramBoolean3) {}
            }
          }
          else
          {
            i = 1;
          }
          if (i != 0)
          {
            localazzl.jdField_a_of_type_Int = 3;
            localArrayList.add(localazzl);
          }
          return localArrayList;
        }
        localazzl.jdField_a_of_type_Int = 2;
        localArrayList.add(localazzl);
        return localArrayList;
      }
      localazzl.jdField_a_of_type_Int = 1;
      localArrayList.add(localazzl);
      return localArrayList;
    }
    if ((paramBoolean1) && (paramBoolean2))
    {
      localazzl.jdField_a_of_type_Int = 5;
      localArrayList.add(localazzl);
      localArrayList.addAll(paramList);
      return localArrayList;
    }
    localazzl.jdField_a_of_type_Int = 4;
    localArrayList.add(localazzl);
    return localArrayList;
  }
  
  private void a(Card paramCard, AnonymousView paramAnonymousView)
  {
    a(paramAnonymousView, true);
    boolean bool1;
    boolean bool2;
    label59:
    boolean bool3;
    label89:
    int i;
    label104:
    int j;
    if ((paramCard != null) && (paramCard.mAnonymousAnswer != null) && (paramCard.mAnonymousAnswer.jdField_a_of_type_Int > 0))
    {
      bool1 = true;
      if ((paramCard == null) || (paramCard.mAnonymousAnswer == null) || (paramCard.mAnonymousAnswer.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label318;
      }
      bool2 = true;
      if ((!bool2) || (paramCard.mAnonymousAnswer.jdField_a_of_type_Int <= paramCard.mAnonymousAnswer.jdField_a_of_type_JavaUtilList.size())) {
        break label324;
      }
      bool3 = true;
      label120:
      Object localObject;
      if (bool1)
      {
        if (!b()) {
          break label330;
        }
        i = 2131698288;
        if (!b()) {
          break label336;
        }
        j = paramCard.mAnonymousAnswer.jdField_a_of_type_Int;
        if (j > 0)
        {
          localObject = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(i), new Object[] { Integer.valueOf(j) });
          TextView localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          localTextView.setText((CharSequence)localObject);
          paramAnonymousView.d.removeAllViews();
          paramAnonymousView.d.addView(localTextView);
          paramAnonymousView.d.setVisibility(0);
          a(null, localTextView);
        }
      }
      if ((azzt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (b()))
      {
        localObject = paramAnonymousView.getResources().getDrawable(2130850427);
        ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
        paramAnonymousView.a.setCompoundDrawables(null, null, (Drawable)localObject, null);
        paramAnonymousView.a.setCompoundDrawablePadding(Utils.dp2px(4.0D));
      }
      if ((paramCard == null) || (paramCard.mAnonymousAnswer == null)) {
        break label348;
      }
    }
    label318:
    label324:
    label330:
    label336:
    label348:
    for (paramCard = paramCard.mAnonymousAnswer.jdField_a_of_type_JavaUtilList;; paramCard = new ArrayList())
    {
      paramAnonymousView.a(a(paramCard, bool1, bool2, bool3));
      a(null, null);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label59;
      bool3 = false;
      break label89;
      i = 2131698291;
      break label104;
      j = paramCard.mAnonymousAnswer.jdField_b_of_type_Int;
      break label120;
    }
  }
  
  private boolean a(Card paramCard)
  {
    boolean bool4 = true;
    boolean bool2;
    label43:
    boolean bool5;
    if ((this.jdField_a_of_type_Birs == null) || (this.jdField_a_of_type_Birs.a(13)))
    {
      bool1 = true;
      if (bagq.a.a(42425, paramCard, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1) {
        break label170;
      }
      bool2 = true;
      bool5 = ProfileActivity.AllInOne.b(((azrb)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      if ((paramCard == null) || (paramCard.mAnonymousAnswer == null) || (!paramCard.mAnonymousAnswer.jdField_b_of_type_Boolean)) {
        break label175;
      }
    }
    label170:
    label175:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileAnonymousComponent", 0, String.format("makeOrRefreshAnonymous() configEnable=%b, visible=%b , isFriend=%b ,isForbidEntry=%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool5), Boolean.valueOf(bool3) }));
      }
      if ((!bool3) && (bool1) && (bool2) && (bool5)) {
        break label181;
      }
      if (this.jdField_a_of_type_JavaLangObject == null) {
        break label393;
      }
      this.jdField_a_of_type_JavaLangObject = null;
      return true;
      bool1 = false;
      break;
      bool2 = false;
      break label43;
    }
    label181:
    Object localObject1;
    Object localObject2;
    label286:
    label298:
    String str;
    if (this.jdField_a_of_type_JavaLangObject == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousViewsAnonymousView = new AnonymousView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousViewsAnonymousView.setTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698285));
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousViewsAnonymousView;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (((azrb)this.b).jdField_a_of_type_Azri != null)
      {
        bool1 = true;
        ((AnonymousView)localObject1).a((QQAppInterface)localObject2, bool1, ((azrb)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousViewsAnonymousView;
        if (!b()) {
          break label354;
        }
        localObject1 = "";
        if (!b()) {
          break label372;
        }
        localObject2 = "0X800B461";
        if (!b()) {
          break label380;
        }
        str = "0X800B461";
        label310:
        bdla.b(null, "dc00898", "", (String)localObject1, (String)localObject2, str, 0, 0, "", "", "", "");
      }
    }
    for (boolean bool1 = bool4;; bool1 = false)
    {
      a(paramCard, this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousViewsAnonymousView);
      return bool1;
      bool1 = false;
      break;
      label354:
      localObject1 = ((azrb)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      break label286;
      label372:
      localObject2 = "0X800B462";
      break label298;
      label380:
      str = "0X800B462";
      break label310;
    }
    label393:
    return false;
  }
  
  private boolean b()
  {
    return ((azrb)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0;
  }
  
  public int a()
  {
    return 1026;
  }
  
  public String a()
  {
    return "ProfileAnonymousComponent";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 4660) && (this.jdField_a_of_type_Azww != null)) {
      this.jdField_a_of_type_Azww.a();
    }
  }
  
  public void a(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super.a(paramBaseActivity, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Azzo);
  }
  
  public boolean a(azrb paramazrb)
  {
    boolean bool = super.a(paramazrb);
    return a(((azrb)this.b).jdField_a_of_type_ComTencentMobileqqDataCard) | bool;
  }
  
  public String a_()
  {
    return "map_key_anonymous";
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Azzo);
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousViewsAnonymousView != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousViewsAnonymousView.b();
    }
    super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azzi
 * JD-Core Version:    0.7.0.1
 */