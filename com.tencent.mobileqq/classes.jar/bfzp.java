import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bfzp
{
  private final float jdField_a_of_type_Float;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private aofu jdField_a_of_type_Aofu;
  private final bgah jdField_a_of_type_Bgah;
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
  private final String jdField_a_of_type_JavaLangString;
  private final boolean jdField_a_of_type_Boolean;
  private final String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String d;
  private String e;
  
  public bfzp(TroopChatPie paramTroopChatPie, TroopInfo paramTroopInfo, QQAppInterface paramQQAppInterface, bgah parambgah)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramTroopInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator;
    if ((paramQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopowneruin)) || ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.contains(paramQQAppInterface.getCurrentAccountUin())))) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getActivity().getResources().getDrawable(2130839470);
      this.d = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin;
      this.jdField_a_of_type_Float = a().getDisplayMetrics().density;
      this.jdField_a_of_type_Bgah = parambgah;
      d();
      return;
    }
  }
  
  private Activity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getActivity();
  }
  
  private Resources a()
  {
    return a().getResources();
  }
  
  private String a(int paramInt)
  {
    return BaseApplication.getContext().getString(paramInt);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Aofu = new bfzs(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aofu);
  }
  
  public void a()
  {
    aoep localaoep = (aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (localaoep != null)
    {
      localaoep.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("AllMemberItem", 2, "fetchRemainCountInfo: invoked. ");
      }
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(String paramString)
  {
    a(true, paramString, this.jdField_b_of_type_Boolean, 0, 0, this.e, this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_Boolean);
  }
  
  public void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, int paramInt1, int paramInt2, String paramString2, String paramString3, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AllMemberItem", 2, new Object[] { "updateUIForAtAllRemainedCount: invoked. ", " isSuccess: ", Boolean.valueOf(paramBoolean1), " bCanAtAll: ", Boolean.valueOf(paramBoolean2), " troopCode: ", paramString1, " remainCount: ", Integer.valueOf(paramInt1), " discRemainCount: ", Integer.valueOf(paramInt2), " remainTips: ", paramString2, " noRemainTips: ", paramString3, " allowMemberAtAll:", Boolean.valueOf(paramBoolean3) });
    }
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.e = paramString2;
    this.jdField_c_of_type_Boolean = paramBoolean3;
    if ((!this.jdField_a_of_type_Boolean) && (paramBoolean3) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380038)).setText(a(2131719642));
      paramString3 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376504);
      paramString3.setTextSize(12.0F);
      paramString3.setText("");
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369417)).setBackgroundDrawable(bheg.d());
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      paramString3 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373427);
      paramString3.setVisibility(0);
      paramString3.setOnClickListener(new bfzq(this));
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376504)).setCompoundDrawables(null, null, null, null);
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() != 8))
    {
      this.jdField_a_of_type_AndroidViewView.setEnabled(true);
      if ((paramBoolean1) && (paramString1 != null)) {
        break label384;
      }
    }
    label384:
    String str;
    Button localButton;
    do
    {
      return;
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380038)).setTextColor(a().getColor(2131167026));
      paramString3 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376504);
      str = anvx.a(2131699723);
      localButton = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131372232);
      localButton.setVisibility(8);
      localButton.setOnClickListener(new bfzr(this));
      paramInt1 = ((aocy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g();
    } while (!paramString1.equals(this.jdField_b_of_type_JavaLangString));
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.e("AllMemberItem", 1, "updateUIForAtAllRemainedCount remainTips empty");
      return;
    }
    if ((!this.jdField_b_of_type_Boolean) && (paramInt1 != 3)) {
      localButton.setVisibility(0);
    }
    paramString1 = new SpannableString(this.e);
    paramString2 = Pattern.compile("[^0-9]").matcher(this.e).replaceAll("").trim();
    if (!TextUtils.isEmpty(paramString2))
    {
      paramInt1 = this.e.indexOf(paramString2);
      paramInt2 = paramString2.length();
      paramString1.setSpan(new ForegroundColorSpan(-48606), paramInt1, paramInt2 + paramInt1, 33);
    }
    if (this.e.contains(anvx.a(2131699725)))
    {
      paramInt1 = this.e.indexOf(anvx.a(2131699728));
      paramInt2 = anvx.a(2131699724).length();
      paramString1.setSpan(new ForegroundColorSpan(-48606), paramInt1, paramInt2 + paramInt1, 33);
    }
    paramString3.setText(paramString1);
    paramString1 = str + "," + this.e;
    this.jdField_a_of_type_AndroidViewView.setContentDescription(paramString1);
  }
  
  boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  void b()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      QQToast.a(a(), this.jdField_c_of_type_JavaLangString, 0).a();
      return;
    }
    QQToast.a(a(), anvx.a(2131699727), 0).a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aofu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfzp
 * JD-Core Version:    0.7.0.1
 */