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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.leba.widget.LebaRoundLayout;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.TextHook;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeURLImageView;

public class auyj
{
  private int jdField_a_of_type_Int = 18;
  public View a;
  public ImageView a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  public aqhi a;
  public LebaRoundLayout a;
  public RedTouch a;
  private ThemeImageView jdField_a_of_type_ComTencentWidgetThemeImageView;
  private ThemeURLImageView jdField_a_of_type_ComTencentWidgetThemeURLImageView;
  public TextView b;
  public TextView c;
  public TextView d;
  private TextView e;
  
  public auyj(Context paramContext, LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561142, null);
    this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaRoundLayout = ((LebaRoundLayout)paramLayoutInflater.findViewById(2131376716));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131369809));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)paramLayoutInflater.findViewById(2131369264));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(bjuk.c);
    this.jdField_a_of_type_ComTencentWidgetThemeURLImageView = ((ThemeURLImageView)paramLayoutInflater.findViewById(2131369145));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379459));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379460));
    this.e = ((TextView)paramLayoutInflater.findViewById(2131379724));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131369432));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379792));
    this.d = ((TextView)paramLayoutInflater.findViewById(2131379793));
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(paramContext, paramLayoutInflater).a(17).b(16).e(28).a();
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.jdField_a_of_type_AndroidWidgetTextView = this.jdField_c_of_type_AndroidWidgetTextView;
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.jdField_b_of_type_AndroidWidgetTextView = this.d;
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.jdField_a_of_type_AndroidWidgetImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.jdField_b_of_type_AndroidWidgetImageView = this.jdField_a_of_type_ComTencentWidgetThemeImageView;
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.jdField_c_of_type_AndroidWidgetImageView = this.jdField_a_of_type_ComTencentWidgetThemeURLImageView;
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.jdField_c_of_type_AndroidWidgetTextView = this.e;
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d = this.jdField_a_of_type_AndroidWidgetTextView;
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.e = this.jdField_b_of_type_AndroidWidgetTextView;
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
    if (this.jdField_a_of_type_Aqhi == null) {
      this.jdField_a_of_type_Aqhi = aqhj.c();
    }
    if (!this.jdField_a_of_type_Aqhi.a()) {}
    for (;;)
    {
      return false;
      String str = this.jdField_a_of_type_Aqhi.a(String.valueOf(paramInt));
      if (str != null) {
        try
        {
          paramInt = this.jdField_a_of_type_Aqhi.a(str);
          if (SkinEngine.getInstances().checkResExist(paramInt))
          {
            ViewUtils.setViewBackground(paramView, paramContext.getResources().getDrawable(paramInt));
            return true;
          }
        }
        catch (Exception paramContext) {}
      }
    }
    return false;
  }
  
  public void a()
  {
    amvb.a(this.jdField_a_of_type_ComTencentWidgetThemeURLImageView, this.jdField_a_of_type_ComTencentWidgetThemeImageView, this.e, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView);
  }
  
  public void a(@NonNull auyk paramauyk)
  {
    aqmf localaqmf = paramauyk.jdField_a_of_type_Aqmf;
    Context localContext = paramauyk.jdField_a_of_type_AndroidContentContext;
    Object localObject = paramauyk.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    int j = paramauyk.jdField_a_of_type_Int;
    QQAppInterface localQQAppInterface = paramauyk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    auxp localauxp = paramauyk.jdField_a_of_type_Auxp;
    boolean bool1 = paramauyk.jdField_a_of_type_Boolean;
    boolean bool2 = paramauyk.jdField_b_of_type_Boolean;
    int i = paramauyk.jdField_b_of_type_Int;
    if (bool1) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130840511);
    }
    while ((localaqmf == null) || (localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setVisibility(8);
      this.e.setVisibility(8);
      if (AppSetting.c) {
        bfpm.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, "", Button.class.getName());
      }
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d();
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.d.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetThemeURLImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      a();
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839437);
    }
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnClickListener(paramauyk.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidViewView.setEnabled(true);
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setVisibility(0);
    if (!TextUtils.isEmpty(localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGridIconUrl))
    {
      paramauyk = URLDrawable.URLDrawableOptions.obtain();
      paramauyk.mRequestWidth = AIOUtils.dp2px(32.0F, localContext.getResources());
      paramauyk.mRequestHeight = paramauyk.mRequestWidth;
      paramauyk.mLoadingDrawable = ((Drawable)localObject);
      paramauyk.mFailedDrawable = ((Drawable)localObject);
      paramauyk = URLDrawable.getDrawable(localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGridIconUrl, paramauyk);
      paramauyk.setTargetDensity(j);
      if (paramauyk.getStatus() == 2) {
        paramauyk.restartDownload();
      }
      if (a(localContext, this.jdField_a_of_type_ComTencentWidgetThemeImageView, (int)localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        paramauyk.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetThemeImageView.getLayoutParams();
        j = ((RelativeLayout.LayoutParams)localObject).width;
        int k = ((RelativeLayout.LayoutParams)localObject).height;
        int m = ScreenUtil.dip2px(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentWidgetThemeImageView.setPadding((j - m) / 2, (k - m) / 2, (j - m) / 2, (k - m) / 2);
        label422:
        this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(paramauyk);
        this.jdField_a_of_type_ComTencentWidgetThemeImageView.invalidate();
        label437:
        this.e.setVisibility(0);
        if (!TextUtils.isEmpty(localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName)) {
          break label707;
        }
      }
    }
    label707:
    for (paramauyk = "";; paramauyk = localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName)
    {
      this.e.setText(paramauyk);
      TextHook.updateFont(this.jdField_a_of_type_AndroidViewView);
      if (TextUtils.isEmpty(localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName)) {
        a(this.e, " tvName.setText:" + paramauyk + " index:" + i);
      }
      if (AppSetting.c) {
        bfpm.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, paramauyk, Button.class.getName());
      }
      if (localauxp == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.jdField_a_of_type_JavaLangString = localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.resConf;
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.h = bool2;
      paramauyk = new ajeh();
      paramauyk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = localQQAppInterface;
      paramauyk.jdField_a_of_type_AndroidContentContext = localContext;
      paramauyk.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
      paramauyk.jdField_a_of_type_Long = localaqmf.jdField_a_of_type_Long;
      paramauyk.jdField_a_of_type_JavaLangString = localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName;
      paramauyk.jdField_a_of_type_Int = i;
      localauxp.a(paramauyk);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
      return;
      paramauyk.setColorFilter(-1, PorterDuff.Mode.DST_IN);
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(paramauyk);
      ViewUtils.setViewBackground(this.jdField_a_of_type_ComTencentWidgetThemeImageView, null);
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setPadding(0, 0, 0, 0);
      break label422;
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable((Drawable)localObject);
      break label437;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auyj
 * JD-Core Version:    0.7.0.1
 */