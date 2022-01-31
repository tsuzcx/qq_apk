import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.crop.CropNewView;
import java.util.ArrayList;

public class bjtn
  extends bjxl
  implements View.OnClickListener, bkdl
{
  int jdField_a_of_type_Int = 0;
  public Bitmap a;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  CropNewView jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView;
  boolean jdField_a_of_type_Boolean = false;
  int[] jdField_a_of_type_ArrayOfInt = new int[5];
  public Bitmap b;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = false;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public boolean c;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  boolean jdField_d_of_type_Boolean = false;
  boolean e = false;
  public boolean f = false;
  
  public bjtn(@NonNull bjxn parambjxn)
  {
    super(parambjxn);
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a();
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bjxn == null) {}
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a();
    } while (!QLog.isColorLevel());
    QLog.d("EditPicCropPart", 2, "onBussiRestoreClick , bussiId = " + i + ",hasModified" + paramBoolean);
  }
  
  private boolean c()
  {
    boolean bool = false;
    int i = this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a();
    if (i == 103)
    {
      this.jdField_a_of_type_Bjxn.d();
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditPicCropPart", 2, "onBussiCropClick , bussiId = " + i + ",clickHit = " + bool);
    }
    return bool;
  }
  
  private void d()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131364740));
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      if (this.jdField_a_of_type_Bjxn.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
        localLayoutParams.bottomMargin = bbll.a(56.5F);
        this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView = ((CropNewView)a(2131364850));
      this.jdField_a_of_type_AndroidViewView = a(2131364846);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = a(2131364848);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131364738));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidViewView = a(2131363858);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131364849));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131364847));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131376629));
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView.setCropListener(this);
    }
  }
  
  private boolean e()
  {
    int i = this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a();
    this.jdField_d_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("EditPicCropPart", 2, "onBussiCropClickIntercept , bussiId = " + i + ",intercepte = " + false);
    }
    return false;
  }
  
  private boolean f()
  {
    boolean bool = false;
    int i = this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a();
    if (i == 103)
    {
      bool = true;
      this.jdField_a_of_type_Bjxn.e();
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditPicCropPart", 2, "onBussiBackPressed , bussiId = " + i + ",clickHit = " + bool);
    }
    return bool;
  }
  
  private void j()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    if (!this.f)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      l();
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_b_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  private void k()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 103)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      if ((this.jdField_a_of_type_AndroidWidgetTextView instanceof TextView)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699227);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void n() {}
  
  public void a(int paramInt)
  {
    if (paramInt == 1) {
      this.jdField_b_of_type_AndroidViewView.setEnabled(false);
    }
    while (paramInt != 2) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setEnabled(true);
  }
  
  public void a(int paramInt, @NonNull bkld parambkld)
  {
    bklj localbklj = parambkld.jdField_a_of_type_Bklj;
    localbklj.jdField_a_of_type_Int += this.jdField_a_of_type_Int;
    if (this.jdField_c_of_type_Boolean)
    {
      parambkld.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("2");
      vej.b("0X80075E9", vej.jdField_a_of_type_Int);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (!f()) {
        this.jdField_a_of_type_Bjxn.a(0);
      }
      vej.b("0X80075D5");
      auad.a("0X800AAE5", 0);
      return true;
    }
    return false;
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    d();
    if (paramInt == 11) {
      if (!this.jdField_b_of_type_Boolean) {
        j();
      }
    }
    while (!this.jdField_b_of_type_Boolean) {
      return;
    }
    k();
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    this.jdField_a_of_type_AndroidViewView.setEnabled(true);
    this.e = true;
    b(this.e);
  }
  
  public void onClick(View paramView)
  {
    boolean bool1 = true;
    switch (paramView.getId())
    {
    default: 
    case 2131364846: 
    case 2131364848: 
    case 2131364738: 
      boolean bool2;
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView.a();
          this.jdField_a_of_type_AndroidViewView.setEnabled(false);
          if (!this.f) {
            this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
          }
          if ((this.jdField_a_of_type_Bjxn != null) && (this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 103)) {
            this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
          }
          this.e = false;
          c(this.e);
          vej.b("0X80075D3");
          auad.a("0X800AAE3", 0);
          return;
          c();
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView.b();
          vej.b("0X80075D4");
          auad.a("0X800AAE4", 0);
          return;
        } while (e());
        this.jdField_a_of_type_Int += 1;
        this.jdField_c_of_type_Boolean = true;
        bool2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView.c();
        if (QLog.isColorLevel()) {
          QLog.d("EditPicCrop", 2, "crop remove face items" + bool2);
        }
      } while (!bool2);
      if (this.jdField_a_of_type_Bjxn.jdField_a_of_type_AndroidOsBundle != null)
      {
        this.jdField_a_of_type_Bjxn.jdField_a_of_type_AndroidOsBundle.remove(bkak.a);
        this.jdField_a_of_type_Bjxn.jdField_a_of_type_AndroidOsBundle.remove("DynamicFaceLayer");
        this.jdField_a_of_type_Bjxn.jdField_a_of_type_AndroidOsBundle.remove(bkba.a);
        this.jdField_a_of_type_Bjxn.jdField_a_of_type_AndroidOsBundle.remove("VoteLayer");
        this.jdField_a_of_type_Bjxn.jdField_a_of_type_AndroidOsBundle.remove("InteractPasterLayer");
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView.a();
      bkrf.a().a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      if (this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 1) {
        break;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bjxn.a(this.jdField_a_of_type_AndroidGraphicsBitmap, bool1);
      if (!c()) {
        this.jdField_a_of_type_Bjxn.y();
      }
      vej.b("0X80075D2");
      auad.a("0X800AAE6", 0);
      bklj.a(this.jdField_a_of_type_ArrayOfInt);
      return;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView.c();
      a();
      return;
      n();
      return;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjtn
 * JD-Core Version:    0.7.0.1
 */