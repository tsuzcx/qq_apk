import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import mqq.manager.TicketManager;

public class bfoc
  extends bfnx
  implements View.OnClickListener
{
  protected bfoo a;
  
  public bfoc(Context paramContext, QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, TroopAppShortcutContainer paramTroopAppShortcutContainer, Bundle paramBundle)
  {
    super(paramContext, paramQQAppInterface, paramFragmentActivity, paramTroopAppShortcutContainer, paramBundle);
    this.jdField_a_of_type_Bfoo = new bfoo();
  }
  
  private void a(View paramView)
  {
    bfqq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Bfoo.jdField_b_of_type_Long, this.jdField_a_of_type_Bfoo.c, 1, 0);
    bcst.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AFBD", "0X800AFBD", 0, 0, String.valueOf(this.jdField_b_of_type_Long), String.valueOf(this.jdField_a_of_type_Bfoo.jdField_b_of_type_Long), "", this.jdField_a_of_type_Bfoo.jdField_e_of_type_JavaLangString);
  }
  
  private void b(View paramView)
  {
    bcst.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AFBE", "0X800AFBE", 0, 0, String.valueOf(this.jdField_b_of_type_Long), String.valueOf(this.jdField_a_of_type_Bfoo.jdField_b_of_type_Long), "", this.jdField_a_of_type_Bfoo.jdField_e_of_type_JavaLangString);
    if (!bfqq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long))
    {
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131698424), 0).a();
      return;
    }
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    paramView = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    String str1;
    if (paramView != null)
    {
      str1 = paramView.getSkey(str2);
      paramView = paramView.getPskey(str2, "qun.qq.com");
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      HashMap localHashMap = new HashMap();
      localBundle.putString("bkn", "" + bfup.b(str1));
      localBundle.putString("Cookie", "uin=o" + str2 + ";skey=" + str1 + ";p_uin=o" + str2 + ";p_skey=" + paramView);
      localBundle.putString("gc", String.valueOf(this.jdField_a_of_type_Long));
      localBundle.putString("append_appid", String.valueOf(this.jdField_a_of_type_Bfoo.jdField_b_of_type_Long));
      localBundle.putString("add_type", "1");
      localBundle.putString("append_source", String.valueOf(this.jdField_a_of_type_Bfoo.jdField_a_of_type_Long));
      localBundle.putString("qqver", "8.4.1.4680");
      localBundle.putString("platform", "2");
      localHashMap.put("BUNDLE", localBundle);
      localHashMap.put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
      new bfpp("https://app.qun.qq.com/cgi-bin/api/inner_setunifiedapp", "POST", new bfod(this, this.jdField_a_of_type_Bfoo), 1000, null).a(localHashMap);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AppsRecommendViewBuilder", 2, "onClickAdd mTroopUin:" + this.jdField_a_of_type_Long + " append_appid:" + this.jdField_a_of_type_Bfoo.jdField_b_of_type_Long);
      return;
      paramView = null;
      str1 = null;
    }
  }
  
  public int a()
  {
    return 3;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool;
    if (paramView == null)
    {
      paramView = new bfoe();
      Object localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559854, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131362804));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131362816));
      paramView.b = ((TextView)((View)localObject).findViewById(2131362819));
      paramView.c = ((TextView)((View)localObject).findViewById(2131362802));
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject).findViewById(2131362795));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject;
      paramView.setClickable(true);
      paramView.setOnClickListener(this);
      localObject = this.jdField_a_of_type_AndroidContentContext;
      ImageView localImageView = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
      String str = this.jdField_a_of_type_Bfoo.jdField_b_of_type_JavaLangString;
      if (this.jdField_a_of_type_Bfoo.jdField_d_of_type_Int != 1) {
        break label413;
      }
      bool = true;
      label157:
      bfqq.a((Context)localObject, localImageView, str, 48.0F, bool);
      if (!this.jdField_a_of_type_Boolean) {
        break label419;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
      label191:
      if (this.jdField_a_of_type_Bfoo.jdField_e_of_type_Int <= 0) {
        break label433;
      }
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.b.setText(String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698427).replace("$COUNT", String.valueOf(this.jdField_a_of_type_Bfoo.jdField_e_of_type_Int)), new Object[0]));
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setCornerRadius(6.0F);
      ((GradientDrawable)localObject).setColor(-1315339);
      paramViewGroup.b.setBackgroundDrawable((Drawable)localObject);
      label286:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Bfoo.jdField_a_of_type_JavaLangString);
      paramViewGroup.c.setText(this.jdField_a_of_type_Bfoo.jdField_d_of_type_JavaLangString);
      if (!this.jdField_b_of_type_Boolean) {
        break label486;
      }
      if (!this.jdField_a_of_type_Bfoo.jdField_a_of_type_Boolean) {
        break label445;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTextColor(-5196865);
      label349:
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffffff"));
        paramView.setBackgroundColor(-16777216);
      }
      return paramView;
      paramViewGroup = (bfoe)paramView.getTag();
      break;
      label413:
      bool = false;
      break label157;
      label419:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
      break label191;
      label433:
      paramViewGroup.b.setVisibility(8);
      break label286;
      label445:
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTextColor(-16578534);
      if (!this.jdField_a_of_type_Boolean) {
        break label349;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#ffffff"));
      break label349;
      label486:
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_Bfoo;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof bfoo)) {
      this.jdField_a_of_type_Bfoo = ((bfoo)paramObject);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(paramView);
      continue;
      b(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfoc
 * JD-Core Version:    0.7.0.1
 */