import android.graphics.PointF;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

class biaf
  implements uyi
{
  int jdField_a_of_type_Int = aciy.a(18.0F, bhzq.a(this.jdField_a_of_type_Bhzq).getResources());
  
  biaf(bhzq parambhzq) {}
  
  public void a()
  {
    bhzq.e(this.jdField_a_of_type_Bhzq);
    bhzq.a(this.jdField_a_of_type_Bhzq, true);
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat == 1.0F)
    {
      uyw localuyw = ((uyh)bhzq.a(this.jdField_a_of_type_Bhzq).a("TextLayer")).a();
      localuyw.b = this.jdField_a_of_type_Int;
      bhzq.a(this.jdField_a_of_type_Bhzq).a(localuyw);
    }
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    uyc localuyc = (uyc)bhzq.a(this.jdField_a_of_type_Bhzq).a("GuideLineLayer");
    if (localuyc != null) {
      localuyc.a(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
    }
  }
  
  public boolean a(uyj paramuyj)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bhzq.a(this.jdField_a_of_type_Bhzq) != null)
    {
      bool1 = bool2;
      if (paramuyj != null)
      {
        bhzq.a(this.jdField_a_of_type_Bhzq).setVisibility(0);
        if (bhzq.a(this.jdField_a_of_type_Bhzq).a.b())
        {
          Object localObject = bhzq.a(this.jdField_a_of_type_Bhzq).a.a();
          ((vcw)localObject).d = false;
          if ((localObject instanceof uyj))
          {
            localObject = (uyh)bhzq.a(this.jdField_a_of_type_Bhzq).a("TextLayer");
            if (localObject != null) {
              ((uyh)localObject).d();
            }
          }
        }
        bhzq.a(this.jdField_a_of_type_Bhzq).a.a(paramuyj);
        paramuyj.d = true;
        bhzq.a(this.jdField_a_of_type_Bhzq).requestLayout();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    bhzq.a(this.jdField_a_of_type_Bhzq, "");
    bhzq.b(this.jdField_a_of_type_Bhzq).setVisibility(0);
    bhzq.c(this.jdField_a_of_type_Bhzq, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biaf
 * JD-Core Version:    0.7.0.1
 */