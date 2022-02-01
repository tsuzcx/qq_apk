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

public class avsl
{
  private int jdField_a_of_type_Int = 18;
  public View a;
  public ImageView a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  public aqxv a;
  public LebaRoundLayout a;
  public RedTouch a;
  private ThemeImageView jdField_a_of_type_ComTencentWidgetThemeImageView;
  public TextView b;
  private TextView c;
  
  public avsl(Context paramContext, LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561230, null);
    this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaRoundLayout = ((LebaRoundLayout)paramLayoutInflater.findViewById(2131376825));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131369724));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)paramLayoutInflater.findViewById(2131369156));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(bkpg.c);
    this.c = ((TextView)paramLayoutInflater.findViewById(2131379779));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131369357));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379858));
    this.b = ((TextView)paramLayoutInflater.findViewById(2131379859));
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
    if (this.jdField_a_of_type_Aqxv == null) {
      this.jdField_a_of_type_Aqxv = aqxw.c();
    }
    if (!this.jdField_a_of_type_Aqxv.a()) {}
    for (;;)
    {
      return false;
      String str = this.jdField_a_of_type_Aqxv.a(String.valueOf(paramInt));
      if (str != null) {
        try
        {
          paramInt = paramContext.getResources().getIdentifier(str, "drawable", "com.tencent.mobileqq");
          if (SkinEngine.getInstances().checkResExist(paramInt))
          {
            paramView.setBackground(paramContext.getResources().getDrawable(paramInt));
            return true;
          }
        }
        catch (Exception paramContext) {}
      }
    }
    return false;
  }
  
  public void a(@NonNull avsm paramavsm)
  {
    arcs localarcs = paramavsm.jdField_a_of_type_Arcs;
    Context localContext = paramavsm.jdField_a_of_type_AndroidContentContext;
    Object localObject = paramavsm.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    int j = paramavsm.jdField_a_of_type_Int;
    QQAppInterface localQQAppInterface = paramavsm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    avru localavru = paramavsm.jdField_a_of_type_Avru;
    boolean bool1 = paramavsm.jdField_a_of_type_Boolean;
    boolean bool2 = paramavsm.jdField_b_of_type_Boolean;
    int i = paramavsm.jdField_b_of_type_Int;
    if (bool1) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130840465);
    }
    while ((localarcs == null) || (localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setVisibility(8);
      this.c.setVisibility(8);
      if (AppSetting.c) {
        bgfz.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, "", Button.class.getName());
      }
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d();
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.b.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839394);
    }
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnClickListener(paramavsm.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidViewView.setEnabled(true);
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setVisibility(0);
    if (!TextUtils.isEmpty(localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGridIconUrl))
    {
      paramavsm = URLDrawable.URLDrawableOptions.obtain();
      paramavsm.mRequestWidth = afur.a(32.0F, localContext.getResources());
      paramavsm.mRequestHeight = paramavsm.mRequestWidth;
      paramavsm.mLoadingDrawable = ((Drawable)localObject);
      paramavsm.mFailedDrawable = ((Drawable)localObject);
      paramavsm = URLDrawable.getDrawable(localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGridIconUrl, paramavsm);
      paramavsm.setTargetDensity(j);
      if (paramavsm.getStatus() == 2) {
        paramavsm.restartDownload();
      }
      if (a(localContext, this.jdField_a_of_type_ComTencentWidgetThemeImageView, (int)localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))
      {
        paramavsm.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetThemeImageView.getLayoutParams();
        j = ((RelativeLayout.LayoutParams)localObject).width;
        int k = ((RelativeLayout.LayoutParams)localObject).height;
        int m = bclx.a(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentWidgetThemeImageView.setPadding((j - m) / 2, (k - m) / 2, (j - m) / 2, (k - m) / 2);
        label391:
        this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(paramavsm);
        this.jdField_a_of_type_ComTencentWidgetThemeImageView.invalidate();
        label406:
        this.c.setVisibility(0);
        if (!TextUtils.isEmpty(localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName)) {
          break label676;
        }
      }
    }
    label676:
    for (paramavsm = "";; paramavsm = localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName)
    {
      this.c.setText(paramavsm);
      TextHook.updateFont(this.jdField_a_of_type_AndroidViewView);
      if (TextUtils.isEmpty(localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName)) {
        a(this.c, " tvName.setText:" + paramavsm + " index:" + i);
      }
      if (AppSetting.c) {
        bgfz.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, paramavsm, Button.class.getName());
      }
      if (localavru == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.jdField_a_of_type_JavaLangString = localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.resConf;
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.h = bool2;
      paramavsm = new ajvf();
      paramavsm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = localQQAppInterface;
      paramavsm.jdField_a_of_type_AndroidContentContext = localContext;
      paramavsm.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
      paramavsm.jdField_a_of_type_Long = localarcs.jdField_a_of_type_Long;
      paramavsm.jdField_a_of_type_JavaLangString = localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName;
      paramavsm.jdField_a_of_type_Int = i;
      localavru.a(paramavsm);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
      return;
      paramavsm.setColorFilter(-1, PorterDuff.Mode.DST_IN);
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(paramavsm);
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setBackground(null);
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setPadding(0, 0, 0, 0);
      break label391;
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable((Drawable)localObject);
      break label406;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avsl
 * JD-Core Version:    0.7.0.1
 */