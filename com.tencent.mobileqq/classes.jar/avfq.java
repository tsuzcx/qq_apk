import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.sign.BoxShadowLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class avfq
  extends avfr
{
  public int a;
  public long a;
  TextView a;
  public String a;
  public int b;
  public String b;
  public int c;
  public int d;
  
  public avfq(Context paramContext, AppInterface paramAppInterface, View paramView, String paramString)
  {
    super(paramContext, paramAppInterface, paramView, paramString);
    this.e = 2;
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
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    l();
    return paramRichStatus;
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100730);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    int i = aciy.a(36.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, i);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.setYOffset(i);
    ((ViewGroup.MarginLayoutParams)this.b.getLayoutParams()).bottomMargin = aciy.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  protected boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avfq
 * JD-Core Version:    0.7.0.1
 */