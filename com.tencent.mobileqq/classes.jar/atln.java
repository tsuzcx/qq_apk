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

public class atln
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
  
  public atln(Context paramContext, LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561019, null);
    this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaRoundLayout = ((LebaRoundLayout)paramLayoutInflater.findViewById(2131376069));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131369333));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)paramLayoutInflater.findViewById(2131368809));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(bibv.c);
    this.c = ((TextView)paramLayoutInflater.findViewById(2131378896));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131368973));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131378963));
    this.b = ((TextView)paramLayoutInflater.findViewById(2131378964));
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
  
  public void a(@NonNull atlo paramatlo)
  {
    aozs localaozs = paramatlo.jdField_a_of_type_Aozs;
    Context localContext = paramatlo.jdField_a_of_type_AndroidContentContext;
    Drawable localDrawable = paramatlo.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    int i = paramatlo.jdField_a_of_type_Int;
    QQAppInterface localQQAppInterface = paramatlo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    atlg localatlg = paramatlo.jdField_a_of_type_Atlg;
    boolean bool1 = paramatlo.jdField_a_of_type_Boolean;
    boolean bool2 = paramatlo.jdField_b_of_type_Boolean;
    int j = paramatlo.jdField_b_of_type_Int;
    if (bool1) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130840284);
    }
    while ((localaozs == null) || (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setVisibility(8);
      this.c.setVisibility(8);
      if (AppSetting.c) {
        bczz.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, "", Button.class.getName());
      }
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d();
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.b.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839217);
    }
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnClickListener(paramatlo.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidViewView.setEnabled(true);
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setVisibility(0);
    if (!TextUtils.isEmpty(localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGridIconUrl))
    {
      paramatlo = URLDrawable.URLDrawableOptions.obtain();
      paramatlo.mRequestWidth = aepi.a(32.0F, localContext.getResources());
      paramatlo.mRequestHeight = paramatlo.mRequestWidth;
      paramatlo.mLoadingDrawable = localDrawable;
      paramatlo.mFailedDrawable = localDrawable;
      paramatlo = URLDrawable.getDrawable(localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGridIconUrl, paramatlo);
      paramatlo.setTargetDensity(i);
      if (paramatlo.getStatus() == 2) {
        paramatlo.restartDownload();
      }
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(paramatlo);
      label299:
      this.c.setVisibility(0);
      if (!TextUtils.isEmpty(localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName)) {
        break label519;
      }
    }
    label519:
    for (paramatlo = "";; paramatlo = localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName)
    {
      this.c.setText(paramatlo);
      TextHook.updateFont(this.jdField_a_of_type_AndroidViewView);
      if (TextUtils.isEmpty(localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName)) {
        a(this.c, " tvName.setText:" + paramatlo + " index:" + j);
      }
      if (AppSetting.c) {
        bczz.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, paramatlo, Button.class.getName());
      }
      if (localatlg == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.jdField_a_of_type_JavaLangString = localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.resConf;
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.h = bool2;
      paramatlo = new atkx();
      paramatlo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = localQQAppInterface;
      paramatlo.jdField_a_of_type_AndroidContentContext = localContext;
      paramatlo.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
      paramatlo.jdField_a_of_type_Long = localaozs.jdField_a_of_type_Long;
      paramatlo.jdField_a_of_type_JavaLangString = localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName;
      paramatlo.jdField_a_of_type_Int = j;
      localatlg.a(paramatlo);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
      return;
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(localDrawable);
      break label299;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atln
 * JD-Core Version:    0.7.0.1
 */