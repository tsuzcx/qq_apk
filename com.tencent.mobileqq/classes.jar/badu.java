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
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class badu
{
  private final float jdField_a_of_type_Float;
  private akim jdField_a_of_type_Akim;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private final baem jdField_a_of_type_Baem;
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie;
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
  
  public badu(TroopChatPie paramTroopChatPie, TroopInfo paramTroopInfo, QQAppInterface paramQQAppInterface, baem parambaem)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator;
    if ((paramQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin)) || ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.contains(paramQQAppInterface.getCurrentAccountUin())))) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a().getResources().getDrawable(2130839144);
      this.d = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Float = a().getDisplayMetrics().density;
      this.jdField_a_of_type_Baem = parambaem;
      d();
      return;
    }
  }
  
  private Activity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a();
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
    this.jdField_a_of_type_Akim = new badx(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akim);
  }
  
  public void a()
  {
    akhq localakhq = (akhq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (localakhq != null)
    {
      localakhq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_JavaLangString);
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
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378262)).setText(a(2131720514));
      paramString3 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375098);
      paramString3.setTextSize(12.0F);
      paramString3.setText("");
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368584)).setBackgroundDrawable(bbdr.d());
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      paramString3 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372181);
      paramString3.setVisibility(0);
      paramString3.setOnClickListener(new badv(this));
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375098)).setCompoundDrawables(null, null, null, null);
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
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378262)).setTextColor(a().getColor(2131166854));
      paramString3 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375098);
      str = ajyc.a(2131700212);
      localButton = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131371058);
      localButton.setVisibility(8);
      localButton.setOnClickListener(new badw(this));
      paramInt1 = ((akfw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).g();
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
    if (this.e.contains(ajyc.a(2131700214)))
    {
      paramInt1 = this.e.indexOf(ajyc.a(2131700217));
      paramInt2 = ajyc.a(2131700213).length();
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
      bcpw.a(a(), this.jdField_c_of_type_JavaLangString, 0).a();
      return;
    }
    bcpw.a(a(), ajyc.a(2131700216), 0).a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akim);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     badu
 * JD-Core Version:    0.7.0.1
 */