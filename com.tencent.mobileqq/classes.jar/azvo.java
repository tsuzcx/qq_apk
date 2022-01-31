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

public class azvo
  extends bigp
  implements View.OnClickListener
{
  private TextView b;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private String jdField_c_of_type_JavaLangString;
  
  public azvo(bjrl parambjrl, bjrk parambjrk)
  {
    super(parambjrl, parambjrk);
  }
  
  protected int a()
  {
    return 2131562519;
  }
  
  public View a()
  {
    View localView1 = super.a();
    vwf.a(a().getLayoutInflater(), new azvp(this, a().getLayoutInflater()));
    Object localObject1 = localView1.findViewById(2131367604);
    Object localObject2 = localView1.findViewById(2131367605);
    View localView2 = localView1.findViewById(2131367606);
    View localView3 = localView1.findViewById(2131378876);
    View localView4 = localView1.findViewById(2131378877);
    int i = vzl.d(a()) / 4;
    int j = vzl.a(a()) / 3;
    ((RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams()).setMargins(0, i, 0, 0);
    ((RelativeLayout.LayoutParams)((View)localObject2).getLayoutParams()).setMargins(0, i * 2, 0, 0);
    ((RelativeLayout.LayoutParams)localView2.getLayoutParams()).setMargins(0, i * 3, 0, 0);
    ((RelativeLayout.LayoutParams)localView3.getLayoutParams()).setMargins(j, 0, 0, 0);
    ((RelativeLayout.LayoutParams)localView4.getLayoutParams()).setMargins(j * 2, 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    localObject1 = (Button)localView1.findViewById(2131378754);
    ((Button)localObject1).setVisibility(0);
    this.b = ((TextView)localView1.findViewById(2131362758));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131362759));
    localObject2 = (tcs)tcz.a(10);
    if ((localObject2 != null) && (((Boolean)((tcs)localObject2).b("SP_ARITHMETIC_GUIDE_SHOW", Boolean.valueOf(true))).booleanValue()))
    {
      this.b.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.b.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      ((tcs)localObject2).b("SP_ARITHMETIC_GUIDE_SHOW", Boolean.valueOf(false));
    }
    for (;;)
    {
      ((Button)localObject1).setOnClickListener(this);
      localView1.setFocusable(true);
      localView1.setFocusableInTouchMode(true);
      localView1.requestFocus();
      localView1.setOnKeyListener(new azvq(this, null));
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363851)).setOnClickListener(this);
      return localView1;
      this.b.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  protected avul a()
  {
    avul localavul = super.a();
    localavul.l(2);
    localavul.a(1280);
    localavul.b(720);
    localavul.a(false);
    localavul.i(2);
    return localavul;
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
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bjrl.a().getIntent().getStringExtra("troop_uin");
    if (this.jdField_c_of_type_JavaLangString == null)
    {
      this.jdField_c_of_type_JavaLangString = "";
      QLog.e("ArithmeticCameraCaptureUnit", 1, "troopUin null!");
    }
    bbbp.a("Grp_edu", "Grp_oral", "Oral_Photo_In", 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, "" });
  }
  
  public void a(avuo paramavuo)
  {
    Activity localActivity = this.jdField_a_of_type_Bjrl.a();
    paramavuo = EditPicActivity.a(localActivity, paramavuo.a, false, false, false, true, false, 11);
    paramavuo.putExtra("arithmetic_ability", 1L);
    paramavuo.putExtra("troop_uin", this.jdField_c_of_type_JavaLangString);
    localActivity.startActivityForResult(paramavuo, 10001);
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
    if (paramView.getId() == 2131363851)
    {
      bbbp.a("Grp_edu", "Grp_oral", "Oral_Photo_Out", 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, "" });
      a().finish();
      a().overridePendingTransition(2130772036, 2130772218);
      return;
    }
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131362758: 
    case 2131362759: 
      bbbp.a("Grp_edu", "Grp_oral", "Oral_Photo_Tip_In", 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, "" });
    case 2131378754: 
      BeginnerGuideFragment.b(a(), null, 7);
      this.b.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    x();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azvo
 * JD-Core Version:    0.7.0.1
 */