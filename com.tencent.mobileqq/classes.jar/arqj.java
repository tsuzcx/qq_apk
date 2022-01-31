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

public class arqj
{
  public View a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public LebaRoundLayout a;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private ThemeImageView jdField_a_of_type_ComTencentWidgetThemeImageView;
  
  public arqj(Context paramContext, LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560818, null);
    this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaRoundLayout = ((LebaRoundLayout)paramLayoutInflater.findViewById(2131375528));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131369083));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)paramLayoutInflater.findViewById(2131368595));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(bfwr.c);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131378265));
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
  
  public void a(@NonNull arqk paramarqk)
  {
    anec localanec = paramarqk.jdField_a_of_type_Anec;
    Context localContext = paramarqk.jdField_a_of_type_AndroidContentContext;
    Drawable localDrawable = paramarqk.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    int i = paramarqk.jdField_a_of_type_Int;
    QQAppInterface localQQAppInterface = paramarqk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    arqd localarqd = paramarqk.jdField_a_of_type_Arqd;
    boolean bool = paramarqk.jdField_a_of_type_Boolean;
    int j = paramarqk.b;
    if (bool) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130840180);
    }
    while ((localanec == null) || (localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (AppSetting.d) {
        baww.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, "", Button.class.getName());
      }
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839132);
    }
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnClickListener(paramarqk.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidViewView.setEnabled(true);
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setVisibility(0);
    if (!TextUtils.isEmpty(localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGridIconUrl))
    {
      paramarqk = URLDrawable.URLDrawableOptions.obtain();
      paramarqk.mRequestWidth = actj.a(32.0F, localContext.getResources());
      paramarqk.mRequestHeight = paramarqk.mRequestWidth;
      paramarqk.mLoadingDrawable = localDrawable;
      paramarqk.mFailedDrawable = localDrawable;
      paramarqk = URLDrawable.getDrawable(localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGridIconUrl, paramarqk);
      paramarqk.setTargetDensity(i);
      if (paramarqk.getStatus() == 2) {
        paramarqk.restartDownload();
      }
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(paramarqk);
      label265:
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (!TextUtils.isEmpty(localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName)) {
        break label442;
      }
    }
    label442:
    for (paramarqk = "";; paramarqk = localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramarqk);
      if (TextUtils.isEmpty(localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName)) {
        a(this.jdField_a_of_type_AndroidWidgetTextView, " tvName.setText:" + paramarqk + " index:" + j);
      }
      if (AppSetting.d) {
        baww.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, paramarqk, Button.class.getName());
      }
      if (localarqd == null) {
        break;
      }
      paramarqk = new arpu();
      paramarqk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = localQQAppInterface;
      paramarqk.jdField_a_of_type_AndroidContentContext = localContext;
      paramarqk.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
      paramarqk.jdField_a_of_type_Long = localanec.jdField_a_of_type_Long;
      paramarqk.jdField_a_of_type_JavaLangString = localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName;
      localarqd.a(paramarqk);
      return;
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(localDrawable);
      break label265;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arqj
 * JD-Core Version:    0.7.0.1
 */