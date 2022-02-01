import android.content.Intent;
import android.graphics.PointF;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileSimpleView;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bait
  extends baik
{
  public bait(baei parambaei, azxr paramazxr)
  {
    super(parambaei, paramazxr);
  }
  
  private void a(azvr paramazvr)
  {
    if ((paramazvr.jdField_a_of_type_JavaLangObject instanceof View)) {
      ((View)paramazvr.jdField_a_of_type_JavaLangObject).setVisibility(8);
    }
    j();
    VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X8008119", "", 1, 0, 0, nnr.a(), "", "");
  }
  
  public String a()
  {
    return "VasProfileHeaderSimpleComponent";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView == null)
    {
      VasProfileSimpleView localVasProfileSimpleView = new VasProfileSimpleView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (azxr)this.b);
      localVasProfileSimpleView.setClickListener(this);
      localVasProfileSimpleView.a();
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView = localVasProfileSimpleView;
      ((FrameLayout)this.jdField_a_of_type_JavaLangObject).removeAllViews();
      ((FrameLayout)this.jdField_a_of_type_JavaLangObject).addView(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView);
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  void j()
  {
    Object localObject2 = new PointF();
    baeh localbaeh = this.jdField_a_of_type_Baei.a(1003);
    Object localObject1 = localObject2;
    if (localbaeh != null)
    {
      localObject1 = localObject2;
      if ((localbaeh instanceof baih)) {
        localObject1 = ((baih)localbaeh).a();
      }
    }
    localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, VipProfileCardDiyActivity.class);
    ((Intent)localObject2).putExtra("extra_from", 1);
    ((Intent)localObject2).putExtra("extra_card_id", ((azxr)this.b).a.lCurrentBgId);
    ((Intent)localObject2).putExtra("extra_card_url", ((azxr)this.b).a.backgroundUrl);
    ((Intent)localObject2).putExtra("extra_card_default_text", ((azxr)this.b).a.diyDefaultText);
    if ((!TextUtils.isEmpty(((azxr)this.b).a.diyText)) && (((azxr)this.b).a.diyTextFontId > 0))
    {
      ((Intent)localObject2).putExtra("extra_card_text", ((azxr)this.b).a.diyText);
      ((Intent)localObject2).putExtra("extra_card_font", ((azxr)this.b).a.diyTextFontId);
      ((Intent)localObject2).putExtra("extra_card_x", ((PointF)localObject1).x);
      ((Intent)localObject2).putExtra("extra_card_y", ((PointF)localObject1).y);
      ((Intent)localObject2).putExtra("extra_card_scale", ((azxr)this.b).a.diyTextScale);
      ((Intent)localObject2).putExtra("extra_card_rotation", ((azxr)this.b).a.diyTextDegree);
      ((Intent)localObject2).putExtra("extra_card_transparency", ((azxr)this.b).a.diyTextTransparency);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult((Intent)localObject2, 600001);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if ((paramView.getTag() instanceof azvr))
    {
      azvr localazvr = (azvr)paramView.getTag();
      if (localazvr.jdField_a_of_type_Int == 73) {
        a(localazvr);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bait
 * JD-Core Version:    0.7.0.1
 */