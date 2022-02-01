import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.leba.widget.LebaRoundLayout;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.TextHook;
import com.tencent.widget.ThemeImageView;

public class awlg
{
  private int jdField_a_of_type_Int = 18;
  public View a;
  public ImageView a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  public arnk a;
  public LebaRoundLayout a;
  public RedTouch a;
  private ThemeImageView jdField_a_of_type_ComTencentWidgetThemeImageView;
  public TextView b;
  private TextView c;
  
  public awlg(Context paramContext, LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561267, null);
    this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaRoundLayout = ((LebaRoundLayout)paramLayoutInflater.findViewById(2131376962));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131369819));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)paramLayoutInflater.findViewById(2131369247));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(blqj.c);
    this.c = ((TextView)paramLayoutInflater.findViewById(2131379958));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131369447));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131380038));
    this.b = ((TextView)paramLayoutInflater.findViewById(2131380039));
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
  
  private boolean a(Context paramContext, View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Arnk == null) {
      this.jdField_a_of_type_Arnk = arnl.c();
    }
    if (!this.jdField_a_of_type_Arnk.a()) {}
    for (;;)
    {
      return false;
      String str = this.jdField_a_of_type_Arnk.a(String.valueOf(paramInt));
      if (str != null) {
        try
        {
          paramInt = paramContext.getResources().getIdentifier(str, "drawable", "com.tencent.mobileqq");
          if (SkinEngine.getInstances().checkResExist(paramInt))
          {
            bhtq.a(paramView, paramContext.getResources().getDrawable(paramInt));
            return true;
          }
        }
        catch (Exception paramContext) {}
      }
    }
    return false;
  }
  
  public void a(@NonNull awlh paramawlh)
  {
    arsh localarsh = paramawlh.jdField_a_of_type_Arsh;
    Context localContext = paramawlh.jdField_a_of_type_AndroidContentContext;
    Object localObject = paramawlh.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    int j = paramawlh.jdField_a_of_type_Int;
    QQAppInterface localQQAppInterface = paramawlh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    awkl localawkl = paramawlh.jdField_a_of_type_Awkl;
    boolean bool1 = paramawlh.jdField_a_of_type_Boolean;
    boolean bool2 = paramawlh.jdField_b_of_type_Boolean;
    int i = paramawlh.jdField_b_of_type_Int;
    if (bool1) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130840475);
    }
    while ((localarsh == null) || (localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setVisibility(8);
      this.c.setVisibility(8);
      if (AppSetting.c) {
        bhga.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, "", Button.class.getName());
      }
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d();
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.b.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839402);
    }
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnClickListener(paramawlh.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidViewView.setEnabled(true);
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setVisibility(0);
    if (!TextUtils.isEmpty(localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGridIconUrl))
    {
      paramawlh = URLDrawable.URLDrawableOptions.obtain();
      paramawlh.mRequestWidth = agej.a(32.0F, localContext.getResources());
      paramawlh.mRequestHeight = paramawlh.mRequestWidth;
      paramawlh.mLoadingDrawable = ((Drawable)localObject);
      paramawlh.mFailedDrawable = ((Drawable)localObject);
      paramawlh = URLDrawable.getDrawable(localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGridIconUrl, paramawlh);
      paramawlh.setTargetDensity(j);
      if (paramawlh.getStatus() == 2) {
        paramawlh.restartDownload();
      }
      if (a(localContext, this.jdField_a_of_type_ComTencentWidgetThemeImageView, (int)localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        paramawlh.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetThemeImageView.getLayoutParams();
        j = ((RelativeLayout.LayoutParams)localObject).width;
        int k = ((RelativeLayout.LayoutParams)localObject).height;
        int m = bdep.a(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentWidgetThemeImageView.setPadding((j - m) / 2, (k - m) / 2, (j - m) / 2, (k - m) / 2);
        label391:
        this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(paramawlh);
        this.jdField_a_of_type_ComTencentWidgetThemeImageView.invalidate();
        label406:
        this.c.setVisibility(0);
        if (!TextUtils.isEmpty(localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName)) {
          break label676;
        }
      }
    }
    label676:
    for (paramawlh = "";; paramawlh = localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName)
    {
      this.c.setText(paramawlh);
      TextHook.updateFont(this.jdField_a_of_type_AndroidViewView);
      if (TextUtils.isEmpty(localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName)) {
        a(this.c, " tvName.setText:" + paramawlh + " index:" + i);
      }
      if (AppSetting.c) {
        bhga.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, paramawlh, Button.class.getName());
      }
      if (localawkl == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.jdField_a_of_type_JavaLangString = localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.resConf;
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.h = bool2;
      paramawlh = new akgo();
      paramawlh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = localQQAppInterface;
      paramawlh.jdField_a_of_type_AndroidContentContext = localContext;
      paramawlh.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
      paramawlh.jdField_a_of_type_Long = localarsh.jdField_a_of_type_Long;
      paramawlh.jdField_a_of_type_JavaLangString = localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName;
      paramawlh.jdField_a_of_type_Int = i;
      localawkl.a(paramawlh);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
      return;
      paramawlh.setColorFilter(-1, PorterDuff.Mode.DST_IN);
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(paramawlh);
      bhtq.a(this.jdField_a_of_type_ComTencentWidgetThemeImageView, null);
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setPadding(0, 0, 0, 0);
      break label391;
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable((Drawable)localObject);
      break label406;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awlg
 * JD-Core Version:    0.7.0.1
 */