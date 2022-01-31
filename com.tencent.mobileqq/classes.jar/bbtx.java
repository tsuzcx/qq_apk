import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqstory.takevideo.EditPicActivity;
import com.tencent.mobileqq.troop.homework.entry.ui.BeginnerGuideFragment;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import java.util.ArrayList;

public class bbtx
  extends bkil
  implements View.OnClickListener
{
  private TextView b;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private String jdField_c_of_type_JavaLangString;
  
  public bbtx(bmcv parambmcv, bmcu parambmcu)
  {
    super(parambmcv, parambmcu);
  }
  
  protected int a()
  {
    return 2131562722;
  }
  
  public View a()
  {
    View localView1 = super.a();
    xkx.a(a().getLayoutInflater(), new bbty(this, a().getLayoutInflater()));
    Object localObject1 = localView1.findViewById(2131367733);
    Object localObject2 = localView1.findViewById(2131367734);
    View localView2 = localView1.findViewById(2131367735);
    View localView3 = localView1.findViewById(2131379497);
    View localView4 = localView1.findViewById(2131379498);
    int i = xod.d(a()) / 4;
    int j = xod.a(a()) / 3;
    ((RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams()).setMargins(0, i, 0, 0);
    ((RelativeLayout.LayoutParams)((View)localObject2).getLayoutParams()).setMargins(0, i * 2, 0, 0);
    ((RelativeLayout.LayoutParams)localView2.getLayoutParams()).setMargins(0, i * 3, 0, 0);
    ((RelativeLayout.LayoutParams)localView3.getLayoutParams()).setMargins(j, 0, 0, 0);
    ((RelativeLayout.LayoutParams)localView4.getLayoutParams()).setMargins(j * 2, 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    localObject1 = (Button)localView1.findViewById(2131379372);
    ((Button)localObject1).setVisibility(0);
    this.b = ((TextView)localView1.findViewById(2131362788));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131362789));
    localObject2 = (urk)urr.a(10);
    if ((localObject2 != null) && (((Boolean)((urk)localObject2).b("SP_ARITHMETIC_GUIDE_SHOW", Boolean.valueOf(true))).booleanValue()))
    {
      this.b.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.b.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      ((urk)localObject2).b("SP_ARITHMETIC_GUIDE_SHOW", Boolean.valueOf(false));
    }
    for (;;)
    {
      ((Button)localObject1).setOnClickListener(this);
      localView1.setFocusable(true);
      localView1.setFocusableInTouchMode(true);
      localView1.requestFocus();
      localView1.setOnKeyListener(new bbtz(this, null));
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363907)).setOnClickListener(this);
      return localView1;
      this.b.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  protected axmk a()
  {
    axmk localaxmk = super.a();
    localaxmk.l(2);
    localaxmk.a(1280);
    localaxmk.b(720);
    localaxmk.a(false);
    localaxmk.i(2);
    return localaxmk;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null)
    {
      ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        a().setResult(paramInt2, paramIntent);
        a().finish();
        a().overridePendingTransition(2130772036, 2130772233);
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setFunctionFlag(2);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.f();
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bmcv.a().getIntent().getStringExtra("troop_uin");
    if (this.jdField_c_of_type_JavaLangString == null)
    {
      this.jdField_c_of_type_JavaLangString = "";
      QLog.e("ArithmeticCameraCaptureUnit", 1, "troopUin null!");
    }
    bdaj.a("Grp_edu", "Grp_oral", "Oral_Photo_In", 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, "" });
  }
  
  public void a(axmn paramaxmn)
  {
    Activity localActivity = this.jdField_a_of_type_Bmcv.a();
    paramaxmn = EditPicActivity.a(localActivity, paramaxmn.a, false, false, false, true, false, 11);
    paramaxmn.putExtra("arithmetic_ability", 1L);
    paramaxmn.putExtra("troop_uin", this.jdField_c_of_type_JavaLangString);
    localActivity.startActivityForResult(paramaxmn, 10001);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  public void h()
  {
    super.h();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363907)
    {
      bdaj.a("Grp_edu", "Grp_oral", "Oral_Photo_Out", 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, "" });
      a().finish();
      a().overridePendingTransition(2130772036, 2130772233);
      return;
    }
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131362788: 
    case 2131362789: 
      bdaj.a("Grp_edu", "Grp_oral", "Oral_Photo_Tip_In", 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, "" });
    case 2131379372: 
      BeginnerGuideFragment.b(a(), null, 7);
      this.b.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    x();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbtx
 * JD-Core Version:    0.7.0.1
 */