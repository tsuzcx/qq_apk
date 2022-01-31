import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.leba.widget.LebaRoundLayout;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;

public class arqh
{
  public View a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public LebaRoundLayout a;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private ThemeImageView jdField_a_of_type_ComTencentWidgetThemeImageView;
  
  public arqh(Context paramContext, LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560819, null);
    this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaRoundLayout = ((LebaRoundLayout)paramLayoutInflater.findViewById(2131375526));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131369083));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)paramLayoutInflater.findViewById(2131368596));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(bfwa.c);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131378262));
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(paramContext, paramLayoutInflater).a(17).b(16).e(28).a();
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
  
  public void a(@NonNull arqi paramarqi)
  {
    andx localandx = paramarqi.jdField_a_of_type_Andx;
    Context localContext = paramarqi.jdField_a_of_type_AndroidContentContext;
    Drawable localDrawable = paramarqi.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    int i = paramarqi.jdField_a_of_type_Int;
    QQAppInterface localQQAppInterface = paramarqi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    arqb localarqb = paramarqi.jdField_a_of_type_Arqb;
    boolean bool = paramarqi.jdField_a_of_type_Boolean;
    int j = paramarqi.b;
    if (bool) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130840183);
    }
    while ((localandx == null) || (localandx.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (AppSetting.d) {
        bawi.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, "", Button.class.getName());
      }
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839132);
    }
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnClickListener(paramarqi.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidViewView.setEnabled(true);
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setVisibility(0);
    if (!TextUtils.isEmpty(localandx.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGridIconUrl))
    {
      paramarqi = URLDrawable.URLDrawableOptions.obtain();
      paramarqi.mRequestWidth = actn.a(32.0F, localContext.getResources());
      paramarqi.mRequestHeight = paramarqi.mRequestWidth;
      paramarqi.mLoadingDrawable = localDrawable;
      paramarqi.mFailedDrawable = localDrawable;
      paramarqi = URLDrawable.getDrawable(localandx.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGridIconUrl, paramarqi);
      paramarqi.setTargetDensity(i);
      if (paramarqi.getStatus() == 2) {
        paramarqi.restartDownload();
      }
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(paramarqi);
      label265:
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (!TextUtils.isEmpty(localandx.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName)) {
        break label442;
      }
    }
    label442:
    for (paramarqi = "";; paramarqi = localandx.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramarqi);
      if (TextUtils.isEmpty(localandx.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName)) {
        a(this.jdField_a_of_type_AndroidWidgetTextView, " tvName.setText:" + paramarqi + " index:" + j);
      }
      if (AppSetting.d) {
        bawi.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, paramarqi, Button.class.getName());
      }
      if (localarqb == null) {
        break;
      }
      paramarqi = new arps();
      paramarqi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = localQQAppInterface;
      paramarqi.jdField_a_of_type_AndroidContentContext = localContext;
      paramarqi.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
      paramarqi.jdField_a_of_type_Long = localandx.jdField_a_of_type_Long;
      paramarqi.jdField_a_of_type_JavaLangString = localandx.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName;
      localarqb.a(paramarqi);
      return;
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(localDrawable);
      break label265;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arqh
 * JD-Core Version:    0.7.0.1
 */