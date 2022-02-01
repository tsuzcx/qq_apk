import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import cooperation.qzone.util.QZLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.mobileqq.activity.richmedia.QzoneEditPictureActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bpxa
  extends bpaq
{
  public View a;
  private bpwy jdField_a_of_type_Bpwy;
  private bpxc jdField_a_of_type_Bpxc;
  private bpxe jdField_a_of_type_Bpxe;
  private final QzoneEditPictureActivity jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity;
  public String a;
  public ArrayList<String> a;
  public String b;
  public int c;
  public String c;
  public int d = -1;
  public String d;
  public int e = -1;
  public String e;
  public int f;
  public boolean f;
  public boolean g;
  public boolean h = true;
  public boolean i;
  public boolean j = true;
  private boolean k;
  private boolean l;
  
  public bpxa(QzoneEditPictureActivity paramQzoneEditPictureActivity, boolean paramBoolean)
  {
    this.jdField_c_of_type_Int = 1;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_f_of_type_Boolean = true;
    this.jdField_f_of_type_Int = -1;
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity = paramQzoneEditPictureActivity;
    this.l = paramBoolean;
  }
  
  private void D()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity.findViewById(2131372556);
    Object localObject = (LinearLayout)LayoutInflater.from(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity).inflate(2131562292, null);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, bqcd.jdField_a_of_type_Int, 0, 0);
    localLayoutParams.addRule(11);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    ((LinearLayout)localObject).findViewById(2131375320).setVisibility(0);
    ((LinearLayout)localObject).findViewById(2131375318).setVisibility(0);
    ((LinearLayout)localObject).findViewById(2131375321).setVisibility(8);
    localObject = (RelativeLayout)this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity.getLayoutInflater().inflate(2131562290, localRelativeLayout, false);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, afur.a(50.0F, a().a().getResources()));
    ((RelativeLayout)localObject).setVisibility(0);
    localLayoutParams.addRule(12);
    if (bqcd.e > 0) {}
    for (int m = bqcd.e;; m = afur.a(60.0F, this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity.getResources()))
    {
      localLayoutParams.bottomMargin = m;
      View localView = new View(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity);
      localView.setBackgroundColor(Color.argb(128, 0, 0, 0));
      localView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      localView.setVisibility(8);
      localRelativeLayout.addView((View)localObject, localLayoutParams);
      localRelativeLayout.addView(localView);
      this.jdField_a_of_type_AndroidViewView = localView;
      return;
    }
  }
  
  private bpxb a()
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      bpen localbpen = (bpen)localIterator.next();
      if ((localbpen instanceof bpxb)) {
        return (bpxb)localbpen;
      }
    }
    return null;
  }
  
  public void a(Context paramContext)
  {
    super.a(paramContext);
    c(3005);
  }
  
  protected void a(@NonNull EditVideoParams paramEditVideoParams)
  {
    long l1 = 0xFFFFFFFF & (paramEditVideoParams.jdField_a_of_type_Long | 0x0);
    if (f())
    {
      super.a(new EditVideoParams(paramEditVideoParams.jdField_a_of_type_Int, 0xFDFFFFFF & 0xFFFDFFFF & l1 & 0xFBFFFFFF & 0xFFFFDFFF, paramEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource, paramEditVideoParams.jdField_a_of_type_AndroidOsBundle));
      a(this.jdField_a_of_type_JavaUtilList);
      return;
    }
    super.a(new EditVideoParams(paramEditVideoParams.jdField_a_of_type_Int, l1, paramEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource, paramEditVideoParams.jdField_a_of_type_AndroidOsBundle));
  }
  
  protected void a(List<bpen> paramList)
  {
    super.a(paramList);
    if (f())
    {
      Object localObject = new bpwy(this);
      this.jdField_a_of_type_Bpwy = ((bpwy)localObject);
      paramList.add(localObject);
      localObject = new bpxe(this);
      this.jdField_a_of_type_Bpxe = ((bpxe)localObject);
      paramList.add(localObject);
      localObject = new bpxc(this);
      this.jdField_a_of_type_Bpxc = ((bpxc)localObject);
      paramList.add(localObject);
    }
    try
    {
      paramList.add(new bpxm(this));
      return;
    }
    catch (Exception paramList)
    {
      QZLog.e("QzEditVideoPartManager", 2, new Object[] { "addExtraParts", " add report part error" });
    }
  }
  
  public void c(int paramInt)
  {
    bpxb localbpxb = a();
    if (localbpxb != null) {
      localbpxb.a_(paramInt, null);
    }
  }
  
  public void e()
  {
    super.e();
    c(3006);
  }
  
  public void f(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public boolean f()
  {
    return this.l;
  }
  
  public boolean g()
  {
    return this.k;
  }
  
  public void j()
  {
    if (f()) {
      D();
    }
    super.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpxa
 * JD-Core Version:    0.7.0.1
 */