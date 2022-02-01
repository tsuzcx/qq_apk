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

public class awej
{
  private int jdField_a_of_type_Int = 18;
  public View a;
  public ImageView a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  public arkq a;
  public LebaRoundLayout a;
  public RedTouch a;
  private ThemeImageView jdField_a_of_type_ComTencentWidgetThemeImageView;
  private ThemeURLImageView jdField_a_of_type_ComTencentWidgetThemeURLImageView;
  public TextView b;
  public TextView c;
  public TextView d;
  private TextView e;
  
  public awej(Context paramContext, LayoutInflater paramLayoutInflater, int paramInt)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561203, null);
    this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaRoundLayout = ((LebaRoundLayout)paramLayoutInflater.findViewById(2131376984));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131369979));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)paramLayoutInflater.findViewById(2131369431));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(blfw.c);
    this.jdField_a_of_type_ComTencentWidgetThemeURLImageView = ((ThemeURLImageView)paramLayoutInflater.findViewById(2131369308));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379764));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379765));
    this.e = ((TextView)paramLayoutInflater.findViewById(2131380038));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131369601));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131380115));
    if (paramInt == 1) {
      this.d = ((TextView)paramLayoutInflater.findViewById(2131380116));
    }
    for (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(paramContext, paramLayoutInflater).b(17).c(16).f(28).a();; this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(paramContext, paramLayoutInflater).b(53).e(12).d(12).a())
    {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.jdField_a_of_type_AndroidWidgetTextView = this.jdField_c_of_type_AndroidWidgetTextView;
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.jdField_b_of_type_AndroidWidgetTextView = this.d;
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.jdField_a_of_type_AndroidWidgetImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.jdField_b_of_type_AndroidWidgetImageView = this.jdField_a_of_type_ComTencentWidgetThemeImageView;
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.jdField_c_of_type_AndroidWidgetImageView = this.jdField_a_of_type_ComTencentWidgetThemeURLImageView;
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.jdField_c_of_type_AndroidWidgetTextView = this.e;
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d = this.jdField_a_of_type_AndroidWidgetTextView;
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.e = this.jdField_b_of_type_AndroidWidgetTextView;
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
      return;
      this.d = ((TextView)paramLayoutInflater.findViewById(2131380117));
    }
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
    if (this.jdField_a_of_type_Arkq == null) {
      this.jdField_a_of_type_Arkq = arkr.c();
    }
    if (!this.jdField_a_of_type_Arkq.a()) {}
    for (;;)
    {
      return false;
      String str = this.jdField_a_of_type_Arkq.a(String.valueOf(paramInt));
      if (str != null) {
        try
        {
          paramInt = this.jdField_a_of_type_Arkq.a(str);
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
    anxo.a(this.jdField_a_of_type_ComTencentWidgetThemeURLImageView, this.jdField_a_of_type_ComTencentWidgetThemeImageView, this.e, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView);
  }
  
  public void a(@NonNull awek paramawek)
  {
    arpq localarpq = paramawek.jdField_a_of_type_Arpq;
    Context localContext = paramawek.jdField_a_of_type_AndroidContentContext;
    Object localObject = paramawek.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    int j = paramawek.jdField_a_of_type_Int;
    QQAppInterface localQQAppInterface = paramawek.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    awdo localawdo = paramawek.jdField_a_of_type_Awdo;
    boolean bool1 = paramawek.jdField_a_of_type_Boolean;
    boolean bool2 = paramawek.jdField_b_of_type_Boolean;
    int i = paramawek.jdField_b_of_type_Int;
    if (bool1) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130840549);
    }
    while ((localarpq == null) || (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setVisibility(8);
      this.e.setVisibility(8);
      if (AppSetting.c) {
        bgyd.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, "", Button.class.getName());
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
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839458);
    }
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramawek.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidViewView.setEnabled(true);
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setVisibility(0);
    if (!TextUtils.isEmpty(localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGridIconUrl))
    {
      paramawek = URLDrawable.URLDrawableOptions.obtain();
      paramawek.mRequestWidth = AIOUtils.dp2px(32.0F, localContext.getResources());
      paramawek.mRequestHeight = paramawek.mRequestWidth;
      paramawek.mLoadingDrawable = ((Drawable)localObject);
      paramawek.mFailedDrawable = ((Drawable)localObject);
      paramawek = URLDrawable.getDrawable(localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGridIconUrl, paramawek);
      paramawek.setTargetDensity(j);
      if (paramawek.getStatus() == 2) {
        paramawek.restartDownload();
      }
      if (a(localContext, this.jdField_a_of_type_ComTencentWidgetThemeImageView, (int)localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        paramawek.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetThemeImageView.getLayoutParams();
        j = ((RelativeLayout.LayoutParams)localObject).width;
        int k = ((RelativeLayout.LayoutParams)localObject).height;
        int m = ScreenUtil.dip2px(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentWidgetThemeImageView.setPadding((j - m) / 2, (k - m) / 2, (j - m) / 2, (k - m) / 2);
        label422:
        this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(paramawek);
        this.jdField_a_of_type_ComTencentWidgetThemeImageView.invalidate();
        label437:
        this.e.setVisibility(0);
        if (!TextUtils.isEmpty(localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName)) {
          break label707;
        }
      }
    }
    label707:
    for (paramawek = "";; paramawek = localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName)
    {
      this.e.setText(paramawek);
      TextHook.updateFont(this.jdField_a_of_type_AndroidViewView);
      if (TextUtils.isEmpty(localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName)) {
        a(this.e, " tvName.setText:" + paramawek + " index:" + i);
      }
      if (AppSetting.c) {
        bgyd.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, paramawek, Button.class.getName());
      }
      if (localawdo == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.jdField_a_of_type_JavaLangString = localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.resConf;
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.h = bool2;
      paramawek = new ajzv();
      paramawek.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = localQQAppInterface;
      paramawek.jdField_a_of_type_AndroidContentContext = localContext;
      paramawek.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
      paramawek.jdField_a_of_type_Long = localarpq.jdField_a_of_type_Long;
      paramawek.jdField_a_of_type_JavaLangString = localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName;
      paramawek.jdField_a_of_type_Int = i;
      localawdo.a(paramawek);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
      return;
      paramawek.setColorFilter(-1, PorterDuff.Mode.DST_IN);
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(paramawek);
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
 * Qualified Name:     awej
 * JD-Core Version:    0.7.0.1
 */