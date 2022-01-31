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

public class bkpk
  extends bjsx
{
  public View a;
  private bkpi jdField_a_of_type_Bkpi;
  private bkpm jdField_a_of_type_Bkpm;
  private bkpo jdField_a_of_type_Bkpo;
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
  
  public bkpk(QzoneEditPictureActivity paramQzoneEditPictureActivity, boolean paramBoolean)
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
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity.findViewById(2131371648);
    Object localObject = (LinearLayout)LayoutInflater.from(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity).inflate(2131561853, null);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, bkur.jdField_a_of_type_Int, 0, 0);
    localLayoutParams.addRule(11);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    ((LinearLayout)localObject).findViewById(2131374092).setVisibility(0);
    ((LinearLayout)localObject).findViewById(2131374090).setVisibility(0);
    ((LinearLayout)localObject).findViewById(2131374093).setVisibility(8);
    localObject = (RelativeLayout)this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity.getLayoutInflater().inflate(2131561851, localRelativeLayout, false);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, actn.a(50.0F, a().a().getResources()));
    ((RelativeLayout)localObject).setVisibility(0);
    localLayoutParams.addRule(12);
    if (bkur.e > 0) {}
    for (int m = bkur.e;; m = actn.a(60.0F, this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity.getResources()))
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
  
  private bkpl a()
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      bjwu localbjwu = (bjwu)localIterator.next();
      if ((localbjwu instanceof bkpl)) {
        return (bkpl)localbjwu;
      }
    }
    return null;
  }
  
  public void a(Context paramContext)
  {
    super.a(paramContext);
    d(3005);
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
  
  protected void a(List<bjwu> paramList)
  {
    super.a(paramList);
    if (f())
    {
      Object localObject = new bkpi(this);
      this.jdField_a_of_type_Bkpi = ((bkpi)localObject);
      paramList.add(localObject);
      localObject = new bkpo(this);
      this.jdField_a_of_type_Bkpo = ((bkpo)localObject);
      paramList.add(localObject);
      localObject = new bkpm(this);
      this.jdField_a_of_type_Bkpm = ((bkpm)localObject);
      paramList.add(localObject);
    }
    try
    {
      paramList.add(new bkpw(this));
      return;
    }
    catch (Exception paramList)
    {
      QZLog.e("QzEditVideoPartManager", 2, new Object[] { "addExtraParts", " add report part error" });
    }
  }
  
  public void d(int paramInt)
  {
    bkpl localbkpl = a();
    if (localbkpl != null) {
      localbkpl.a_(paramInt, null);
    }
  }
  
  public void e()
  {
    super.e();
    d(3006);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkpk
 * JD-Core Version:    0.7.0.1
 */