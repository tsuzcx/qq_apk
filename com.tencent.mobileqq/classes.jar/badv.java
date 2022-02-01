import android.content.Intent;
import android.graphics.PointF;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileSimpleView;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class badv
  extends badm
{
  public badv(azxt paramazxt, azrb paramazrb)
  {
    super(paramazxt, paramazrb);
  }
  
  private void a(azpb paramazpb)
  {
    if ((paramazpb.jdField_a_of_type_JavaLangObject instanceof View)) {
      ((View)paramazpb.jdField_a_of_type_JavaLangObject).setVisibility(8);
    }
    j();
    VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X8008119", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), "", "");
  }
  
  public String a()
  {
    return "VasProfileHeaderSimpleComponent";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView == null)
    {
      VasProfileSimpleView localVasProfileSimpleView = new VasProfileSimpleView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (azrb)this.b);
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
    azxs localazxs = this.jdField_a_of_type_Azxt.a(1003);
    Object localObject1 = localObject2;
    if (localazxs != null)
    {
      localObject1 = localObject2;
      if ((localazxs instanceof badj)) {
        localObject1 = ((badj)localazxs).a();
      }
    }
    localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, VipProfileCardDiyActivity.class);
    ((Intent)localObject2).putExtra("extra_from", 1);
    ((Intent)localObject2).putExtra("extra_card_id", ((azrb)this.b).a.lCurrentBgId);
    ((Intent)localObject2).putExtra("extra_card_url", ((azrb)this.b).a.backgroundUrl);
    ((Intent)localObject2).putExtra("extra_card_default_text", ((azrb)this.b).a.diyDefaultText);
    if ((!TextUtils.isEmpty(((azrb)this.b).a.diyText)) && (((azrb)this.b).a.diyTextFontId > 0))
    {
      ((Intent)localObject2).putExtra("extra_card_text", ((azrb)this.b).a.diyText);
      ((Intent)localObject2).putExtra("extra_card_font", ((azrb)this.b).a.diyTextFontId);
      ((Intent)localObject2).putExtra("extra_card_x", ((PointF)localObject1).x);
      ((Intent)localObject2).putExtra("extra_card_y", ((PointF)localObject1).y);
      ((Intent)localObject2).putExtra("extra_card_scale", ((azrb)this.b).a.diyTextScale);
      ((Intent)localObject2).putExtra("extra_card_rotation", ((azrb)this.b).a.diyTextDegree);
      ((Intent)localObject2).putExtra("extra_card_transparency", ((azrb)this.b).a.diyTextTransparency);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult((Intent)localObject2, 600001);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if ((paramView.getTag() instanceof azpb))
    {
      azpb localazpb = (azpb)paramView.getTag();
      if (localazpb.jdField_a_of_type_Int == 73) {
        a(localazpb);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     badv
 * JD-Core Version:    0.7.0.1
 */