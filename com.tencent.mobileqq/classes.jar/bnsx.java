import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import cooperation.qzone.util.QZLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.mobileqq.activity.richmedia.QzoneEditPictureActivity;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bnsx
  extends bncp
{
  public View a;
  private bnsv jdField_a_of_type_Bnsv;
  private bnsz jdField_a_of_type_Bnsz;
  private bntb jdField_a_of_type_Bntb;
  private final QzoneEditPictureActivity jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity;
  public String a;
  public ArrayList<String> a;
  public String b;
  public int c;
  public String c;
  public int d = -1;
  public String d;
  public int e;
  public String e;
  public boolean e;
  public int f = -1;
  public boolean f;
  public boolean g = true;
  public boolean h;
  public boolean i = true;
  private boolean j;
  private boolean k;
  
  public bnsx(QzoneEditPictureActivity paramQzoneEditPictureActivity, boolean paramBoolean)
  {
    this.jdField_c_of_type_Int = 1;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_e_of_type_Boolean = true;
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity = paramQzoneEditPictureActivity;
    this.k = paramBoolean;
  }
  
  private bnsy a()
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      bnec localbnec = (bnec)localIterator.next();
      if ((localbnec instanceof bnsy)) {
        return (bnsy)localbnec;
      }
    }
    return null;
  }
  
  private void z()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity.findViewById(2131372635);
    Object localObject = (LinearLayout)LayoutInflater.from(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity).inflate(2131562209, null);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, LiuHaiUtils.jdField_a_of_type_Int, 0, 0);
    localLayoutParams.addRule(11);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    ((LinearLayout)localObject).findViewById(2131375225).setVisibility(0);
    ((LinearLayout)localObject).findViewById(2131375223).setVisibility(0);
    ((LinearLayout)localObject).findViewById(2131375226).setVisibility(8);
    localObject = (RelativeLayout)this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity.getLayoutInflater().inflate(2131562207, localRelativeLayout, false);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.dp2px(50.0F, a().a().getResources()));
    ((RelativeLayout)localObject).setVisibility(0);
    localLayoutParams.addRule(12);
    if (LiuHaiUtils.jdField_e_of_type_Int > 0) {}
    for (int m = LiuHaiUtils.jdField_e_of_type_Int;; m = AIOUtils.dp2px(60.0F, this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzoneEditPictureActivity.getResources()))
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
  
  public void a(Context paramContext)
  {
    super.a(paramContext);
    c(3005);
  }
  
  protected void a(@NonNull EditVideoParams paramEditVideoParams)
  {
    int m = (paramEditVideoParams.jdField_c_of_type_Int | 0x2000) & 0xFFFFEFFF;
    if (f())
    {
      super.a(new EditVideoParams(paramEditVideoParams.jdField_a_of_type_Int, m & 0xFFFFFDFF, paramEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource, paramEditVideoParams.jdField_a_of_type_AndroidOsBundle));
      a(this.jdField_a_of_type_JavaUtilList);
      return;
    }
    super.a(new EditVideoParams(paramEditVideoParams.jdField_a_of_type_Int, m, paramEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource, paramEditVideoParams.jdField_a_of_type_AndroidOsBundle));
  }
  
  protected void a(List<bnec> paramList)
  {
    super.a(paramList);
    if (f())
    {
      Object localObject = new bnsv(this);
      this.jdField_a_of_type_Bnsv = ((bnsv)localObject);
      paramList.add(localObject);
      localObject = new bntb(this);
      this.jdField_a_of_type_Bntb = ((bntb)localObject);
      paramList.add(localObject);
      localObject = new bnsz(this);
      this.jdField_a_of_type_Bnsz = ((bnsz)localObject);
      paramList.add(localObject);
    }
    try
    {
      paramList.add(new bntj(this));
      return;
    }
    catch (Exception paramList)
    {
      QZLog.e("QzEditVideoPartManager", 2, new Object[] { "addExtraParts", " add report part error" });
    }
  }
  
  public void c(int paramInt)
  {
    bnsy localbnsy = a();
    if (localbnsy != null) {
      localbnsy.a(paramInt, null);
    }
  }
  
  public void e()
  {
    super.e();
    c(3006);
  }
  
  public void e(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public boolean f()
  {
    return this.k;
  }
  
  public boolean g()
  {
    return this.j;
  }
  
  public void h()
  {
    if (f()) {
      z();
    }
    super.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnsx
 * JD-Core Version:    0.7.0.1
 */