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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class azcz
{
  private final float jdField_a_of_type_Float;
  private aejb jdField_a_of_type_Aejb;
  private ajuc jdField_a_of_type_Ajuc;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private final azdr jdField_a_of_type_Azdr;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  private final String jdField_a_of_type_JavaLangString;
  private final boolean jdField_a_of_type_Boolean;
  private final String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String d;
  private String e;
  
  public azcz(aejb paramaejb, TroopInfo paramTroopInfo, QQAppInterface paramQQAppInterface, azdr paramazdr)
  {
    this.jdField_a_of_type_Aejb = paramaejb;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator;
    if ((paramQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin)) || ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.contains(paramQQAppInterface.getCurrentAccountUin())))) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_Aejb.a().getResources().getDrawable(2130839117);
      this.d = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Aejb.a.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Float = a().getDisplayMetrics().density;
      this.jdField_a_of_type_Azdr = paramazdr;
      d();
      return;
    }
  }
  
  private Activity a()
  {
    return this.jdField_a_of_type_Aejb.a();
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
    this.jdField_a_of_type_Ajuc = new azdc(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajuc);
  }
  
  public void a()
  {
    ajtg localajtg = (ajtg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (localajtg != null)
    {
      localajtg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_JavaLangString);
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
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131312436)).setText(a(2131654618));
      paramString3 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131309352);
      paramString3.setTextSize(12.0F);
      paramString3.setText("");
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302951)).setBackgroundDrawable(bacm.d());
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      paramString3 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131306484);
      paramString3.setVisibility(0);
      paramString3.setOnClickListener(new azda(this));
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131309352)).setCompoundDrawables(null, null, null, null);
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() != 8))
    {
      this.jdField_a_of_type_AndroidViewView.setEnabled(true);
      if ((paramBoolean1) && (paramString1 != null)) {
        break label383;
      }
    }
    label383:
    String str;
    Button localButton;
    do
    {
      return;
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131312436)).setTextColor(a().getColor(2131101260));
      paramString3 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131309352);
      str = ajjy.a(2131634424);
      localButton = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131305365);
      localButton.setVisibility(8);
      localButton.setOnClickListener(new azdb(this));
      paramInt1 = ((ajrm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).g();
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
    if (this.e.contains(ajjy.a(2131634426)))
    {
      paramInt1 = this.e.indexOf(ajjy.a(2131634429));
      paramInt2 = ajjy.a(2131634425).length();
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
      bbmy.a(a(), this.jdField_c_of_type_JavaLangString, 0).a();
      return;
    }
    bbmy.a(a(), ajjy.a(2131634428), 0).a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajuc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azcz
 * JD-Core Version:    0.7.0.1
 */