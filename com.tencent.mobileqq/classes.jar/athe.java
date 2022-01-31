import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.leba.widget.LebaRoundLayout;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.TextHook;
import com.tencent.widget.ThemeImageView;

public class athe
{
  public View a;
  public ImageView a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  public LebaRoundLayout a;
  public RedTouch a;
  private ThemeImageView jdField_a_of_type_ComTencentWidgetThemeImageView;
  public TextView b;
  private TextView c;
  
  public athe(Context paramContext, LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561001, null);
    this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaRoundLayout = ((LebaRoundLayout)paramLayoutInflater.findViewById(2131376016));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131369315));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)paramLayoutInflater.findViewById(2131368794));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(bhxo.c);
    this.c = ((TextView)paramLayoutInflater.findViewById(2131378839));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131368955));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131378906));
    this.b = ((TextView)paramLayoutInflater.findViewById(2131378907));
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(paramContext, paramLayoutInflater).a(17).b(16).e(28).a();
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.jdField_a_of_type_AndroidWidgetTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b = this.b;
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.jdField_a_of_type_AndroidWidgetImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    try
    {
      QLog.i("LebaTableViewHolder", 1, paramString + " thread:" + Thread.currentThread().getId() + " v:" + paramTextView.getVisibility() + " w:" + paramTextView.getWidth() + " h:" + paramTextView.getHeight() + " x:" + paramTextView.getX() + " y:" + paramTextView.getY() + " colors:" + paramTextView.getTextColors() + " text:" + paramTextView.getText());
      return;
    }
    catch (Exception paramTextView)
    {
      QLog.i("LebaTableViewHolder", 1, "", paramTextView);
    }
  }
  
  public void a(@NonNull athf paramathf)
  {
    aovj localaovj = paramathf.jdField_a_of_type_Aovj;
    Context localContext = paramathf.jdField_a_of_type_AndroidContentContext;
    Drawable localDrawable = paramathf.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    int i = paramathf.jdField_a_of_type_Int;
    QQAppInterface localQQAppInterface = paramathf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    atgx localatgx = paramathf.jdField_a_of_type_Atgx;
    boolean bool1 = paramathf.jdField_a_of_type_Boolean;
    boolean bool2 = paramathf.jdField_b_of_type_Boolean;
    int j = paramathf.jdField_b_of_type_Int;
    if (bool1) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130840283);
    }
    while ((localaovj == null) || (localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setVisibility(8);
      this.c.setVisibility(8);
      if (AppSetting.c) {
        bcvq.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, "", Button.class.getName());
      }
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d();
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.b.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839216);
    }
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnClickListener(paramathf.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidViewView.setEnabled(true);
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setVisibility(0);
    if (!TextUtils.isEmpty(localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGridIconUrl))
    {
      paramathf = URLDrawable.URLDrawableOptions.obtain();
      paramathf.mRequestWidth = aekt.a(32.0F, localContext.getResources());
      paramathf.mRequestHeight = paramathf.mRequestWidth;
      paramathf.mLoadingDrawable = localDrawable;
      paramathf.mFailedDrawable = localDrawable;
      paramathf = URLDrawable.getDrawable(localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGridIconUrl, paramathf);
      paramathf.setTargetDensity(i);
      if (paramathf.getStatus() == 2) {
        paramathf.restartDownload();
      }
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(paramathf);
      label299:
      this.c.setVisibility(0);
      if (!TextUtils.isEmpty(localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName)) {
        break label519;
      }
    }
    label519:
    for (paramathf = "";; paramathf = localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName)
    {
      this.c.setText(paramathf);
      TextHook.updateFont(this.jdField_a_of_type_AndroidViewView);
      if (TextUtils.isEmpty(localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName)) {
        a(this.c, " tvName.setText:" + paramathf + " index:" + j);
      }
      if (AppSetting.c) {
        bcvq.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, paramathf, Button.class.getName());
      }
      if (localatgx == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.jdField_a_of_type_JavaLangString = localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.resConf;
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.h = bool2;
      paramathf = new atgo();
      paramathf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = localQQAppInterface;
      paramathf.jdField_a_of_type_AndroidContentContext = localContext;
      paramathf.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
      paramathf.jdField_a_of_type_Long = localaovj.jdField_a_of_type_Long;
      paramathf.jdField_a_of_type_JavaLangString = localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName;
      paramathf.jdField_a_of_type_Int = j;
      localatgx.a(paramathf);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
      return;
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(localDrawable);
      break label299;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     athe
 * JD-Core Version:    0.7.0.1
 */