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

public class azqd
  extends azpu
{
  public azqd(azlw paramazlw, azfe paramazfe)
  {
    super(paramazlw, paramazfe);
  }
  
  private void a(azde paramazde)
  {
    if ((paramazde.jdField_a_of_type_JavaLangObject instanceof View)) {
      ((View)paramazde.jdField_a_of_type_JavaLangObject).setVisibility(8);
    }
    j();
    VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X8008119", "", 1, 0, 0, nlw.a(), "", "");
  }
  
  public String a()
  {
    return "VasProfileHeaderSimpleComponent";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView == null)
    {
      VasProfileSimpleView localVasProfileSimpleView = new VasProfileSimpleView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (azfe)this.b);
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
    azlv localazlv = this.jdField_a_of_type_Azlw.a(1003);
    Object localObject1 = localObject2;
    if (localazlv != null)
    {
      localObject1 = localObject2;
      if ((localazlv instanceof azpr)) {
        localObject1 = ((azpr)localazlv).a();
      }
    }
    localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, VipProfileCardDiyActivity.class);
    ((Intent)localObject2).putExtra("extra_from", 1);
    ((Intent)localObject2).putExtra("extra_card_id", ((azfe)this.b).a.lCurrentBgId);
    ((Intent)localObject2).putExtra("extra_card_url", ((azfe)this.b).a.backgroundUrl);
    ((Intent)localObject2).putExtra("extra_card_default_text", ((azfe)this.b).a.diyDefaultText);
    if ((!TextUtils.isEmpty(((azfe)this.b).a.diyText)) && (((azfe)this.b).a.diyTextFontId > 0))
    {
      ((Intent)localObject2).putExtra("extra_card_text", ((azfe)this.b).a.diyText);
      ((Intent)localObject2).putExtra("extra_card_font", ((azfe)this.b).a.diyTextFontId);
      ((Intent)localObject2).putExtra("extra_card_x", ((PointF)localObject1).x);
      ((Intent)localObject2).putExtra("extra_card_y", ((PointF)localObject1).y);
      ((Intent)localObject2).putExtra("extra_card_scale", ((azfe)this.b).a.diyTextScale);
      ((Intent)localObject2).putExtra("extra_card_rotation", ((azfe)this.b).a.diyTextDegree);
      ((Intent)localObject2).putExtra("extra_card_transparency", ((azfe)this.b).a.diyTextTransparency);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult((Intent)localObject2, 600001);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if ((paramView.getTag() instanceof azde))
    {
      azde localazde = (azde)paramView.getTag();
      if (localazde.jdField_a_of_type_Int == 73) {
        a(localazde);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azqd
 * JD-Core Version:    0.7.0.1
 */