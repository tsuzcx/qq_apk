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

public class ayuw
  extends bhdi
  implements View.OnClickListener
{
  private TextView b;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private String jdField_c_of_type_JavaLangString;
  
  public ayuw(bhzc parambhzc, bhzb parambhzb)
  {
    super(parambhzc, parambhzb);
  }
  
  protected int a()
  {
    return 2131496920;
  }
  
  public View a()
  {
    View localView1 = super.a();
    vjm.a(a().getLayoutInflater(), new ayux(this, a().getLayoutInflater()));
    Object localObject1 = localView1.findViewById(2131301987);
    Object localObject2 = localView1.findViewById(2131301988);
    View localView2 = localView1.findViewById(2131301989);
    View localView3 = localView1.findViewById(2131313048);
    View localView4 = localView1.findViewById(2131313049);
    int i = vms.d(a()) / 4;
    int j = vms.a(a()) / 3;
    ((RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams()).setMargins(0, i, 0, 0);
    ((RelativeLayout.LayoutParams)((View)localObject2).getLayoutParams()).setMargins(0, i * 2, 0, 0);
    ((RelativeLayout.LayoutParams)localView2.getLayoutParams()).setMargins(0, i * 3, 0, 0);
    ((RelativeLayout.LayoutParams)localView3.getLayoutParams()).setMargins(j, 0, 0, 0);
    ((RelativeLayout.LayoutParams)localView4.getLayoutParams()).setMargins(j * 2, 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    localObject1 = (Button)localView1.findViewById(2131312924);
    ((Button)localObject1).setVisibility(0);
    this.b = ((TextView)localView1.findViewById(2131297219));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131297220));
    localObject2 = (spz)sqg.a(10);
    if ((localObject2 != null) && (((Boolean)((spz)localObject2).b("SP_ARITHMETIC_GUIDE_SHOW", Boolean.valueOf(true))).booleanValue()))
    {
      this.b.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.b.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      ((spz)localObject2).b("SP_ARITHMETIC_GUIDE_SHOW", Boolean.valueOf(false));
    }
    for (;;)
    {
      ((Button)localObject1).setOnClickListener(this);
      localView1.setFocusable(true);
      localView1.setFocusableInTouchMode(true);
      localView1.requestFocus();
      localView1.setOnKeyListener(new ayuy(this, null));
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298297)).setOnClickListener(this);
      return localView1;
      this.b.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  protected auuv a()
  {
    auuv localauuv = super.a();
    localauuv.l(2);
    localauuv.a(1280);
    localauuv.b(720);
    localauuv.a(false);
    localauuv.i(2);
    return localauuv;
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
        a().overridePendingTransition(2130772036, 2130772218);
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setFunctionFlag(2);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.f();
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bhzc.a().getIntent().getStringExtra("troop_uin");
    if (this.jdField_c_of_type_JavaLangString == null)
    {
      this.jdField_c_of_type_JavaLangString = "";
      QLog.e("ArithmeticCameraCaptureUnit", 1, "troopUin null!");
    }
    azzx.a("Grp_edu", "Grp_oral", "Oral_Photo_In", 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, "" });
  }
  
  public void a(auuy paramauuy)
  {
    Activity localActivity = this.jdField_a_of_type_Bhzc.a();
    paramauuy = EditPicActivity.a(localActivity, paramauuy.a, false, false, false, true, false, 11);
    paramauuy.putExtra("arithmetic_ability", 1L);
    paramauuy.putExtra("troop_uin", this.jdField_c_of_type_JavaLangString);
    localActivity.startActivityForResult(paramauuy, 10001);
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
    if (paramView.getId() == 2131298297)
    {
      azzx.a("Grp_edu", "Grp_oral", "Oral_Photo_Out", 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, "" });
      a().finish();
      a().overridePendingTransition(2130772036, 2130772218);
      return;
    }
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297219: 
    case 2131297220: 
      azzx.a("Grp_edu", "Grp_oral", "Oral_Photo_Tip_In", 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, "" });
    case 2131312924: 
      BeginnerGuideFragment.b(a(), null, 7);
      this.b.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    z();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayuw
 * JD-Core Version:    0.7.0.1
 */