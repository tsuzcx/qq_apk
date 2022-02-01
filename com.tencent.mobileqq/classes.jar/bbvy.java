import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.sign.BoxShadowLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class bbvy
  extends bbvz
{
  public int a;
  public long a;
  TextView a;
  public String a;
  public int b;
  public String b;
  public int c;
  public int d;
  
  public bbvy(Context paramContext, AppInterface paramAppInterface, View paramView, String paramString)
  {
    super(paramContext, paramAppInterface, paramView, paramString);
    this.e = 2;
    this.i = 2130846135;
    VasWebviewUtil.reportCommercialDrainage(paramAppInterface.getCurrentAccountUin(), "signature_aio", "show", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
  
  protected int a()
  {
    return 3;
  }
  
  public View a(RichStatus paramRichStatus)
  {
    paramRichStatus = super.a(paramRichStatus);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.mMsgId = this.jdField_a_of_type_Long;
    l();
    return paramRichStatus;
  }
  
  protected void a()
  {
    this.h = agej.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    super.a();
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166448);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    int i = agej.a(36.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    Object localObject = new FrameLayout.LayoutParams(-1, i);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.setYOffset(i + agej.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    i = (int)(bdep.jdField_a_of_type_Int * 0.11F);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.a(i);
    localObject = (ViewGroup.MarginLayoutParams)this.b.getLayoutParams();
    localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = agej.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = agej.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  protected boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbvy
 * JD-Core Version:    0.7.0.1
 */