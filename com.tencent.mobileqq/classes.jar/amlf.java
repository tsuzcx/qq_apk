import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.view.ApolloGameProcessBar;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class amlf
  extends QQCustomDialog
{
  Button jdField_a_of_type_AndroidWidgetButton;
  ApolloGameProcessBar jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameProcessBar;
  
  public amlf(Context paramContext)
  {
    super(paramContext, 2131755202);
    a(paramContext);
  }
  
  @TargetApi(16)
  private void a(Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    Object localObject = new FrameLayout.LayoutParams(-2, -2, 17);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameProcessBar = new ApolloGameProcessBar(paramContext, 2130838642, 2130838644);
    localObject = new LinearLayout.LayoutParams(AIOUtils.dp2px(80.0F, paramContext.getResources()), AIOUtils.dp2px(80.0F, paramContext.getResources()));
    ((LinearLayout.LayoutParams)localObject).setMargins(AIOUtils.dp2px(60.5F, paramContext.getResources()), 0, AIOUtils.dp2px(60.5F, paramContext.getResources()), 0);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameProcessBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameProcessBar);
    localObject = new TextView(paramContext);
    ((TextView)localObject).setText(amtj.a(2131699539));
    ((TextView)localObject).setTextSize(16.0F);
    ((TextView)localObject).setTextColor(Color.parseColor("#ababab"));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, AIOUtils.dp2px(10.0F, paramContext.getResources()), 0, 0);
    localLayoutParams.gravity = 1;
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    localLinearLayout.addView((View)localObject);
    this.jdField_a_of_type_AndroidWidgetButton = new Button(paramContext);
    this.jdField_a_of_type_AndroidWidgetButton.setText(amtj.a(2131699530));
    this.jdField_a_of_type_AndroidWidgetButton.setTextSize(14.0F);
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#ffffff"));
    this.jdField_a_of_type_AndroidWidgetButton.setBackground(paramContext.getResources().getDrawable(2130838643));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new amlg(this));
    localObject = new LinearLayout.LayoutParams(AIOUtils.dp2px(100.0F, paramContext.getResources()), AIOUtils.dp2px(30.0F, paramContext.getResources()));
    ((LinearLayout.LayoutParams)localObject).setMargins(0, AIOUtils.dp2px(35.0F, paramContext.getResources()), 0, 0);
    ((LinearLayout.LayoutParams)localObject).gravity = 1;
    this.jdField_a_of_type_AndroidWidgetButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetButton);
    getWindow().setDimAmount(0.85F);
    getWindow().setGravity(17);
    setContentView(localLinearLayout);
    setCanceledOnTouchOutside(false);
    setCancelable(false);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new amlh(this));
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setProgress(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameProcessBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameProcessBar.setProgress(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlf
 * JD-Core Version:    0.7.0.1
 */