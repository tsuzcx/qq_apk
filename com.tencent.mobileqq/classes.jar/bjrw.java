import android.graphics.PointF;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

class bjrw
  implements vle
{
  int jdField_a_of_type_Int = actn.a(18.0F, bjrh.a(this.jdField_a_of_type_Bjrh).getResources());
  
  bjrw(bjrh parambjrh) {}
  
  public void a()
  {
    bjrh.e(this.jdField_a_of_type_Bjrh);
    bjrh.a(this.jdField_a_of_type_Bjrh, true);
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat == 1.0F)
    {
      vls localvls = ((vld)bjrh.a(this.jdField_a_of_type_Bjrh).a("TextLayer")).a();
      localvls.b = this.jdField_a_of_type_Int;
      bjrh.a(this.jdField_a_of_type_Bjrh).a(localvls);
    }
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    vky localvky = (vky)bjrh.a(this.jdField_a_of_type_Bjrh).a("GuideLineLayer");
    if (localvky != null) {
      localvky.a(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
    }
  }
  
  public boolean a(vlf paramvlf)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bjrh.a(this.jdField_a_of_type_Bjrh) != null)
    {
      bool1 = bool2;
      if (paramvlf != null)
      {
        bjrh.a(this.jdField_a_of_type_Bjrh).setVisibility(0);
        if (bjrh.a(this.jdField_a_of_type_Bjrh).a.b())
        {
          Object localObject = bjrh.a(this.jdField_a_of_type_Bjrh).a.a();
          ((vps)localObject).d = false;
          if ((localObject instanceof vlf))
          {
            localObject = (vld)bjrh.a(this.jdField_a_of_type_Bjrh).a("TextLayer");
            if (localObject != null) {
              ((vld)localObject).d();
            }
          }
        }
        bjrh.a(this.jdField_a_of_type_Bjrh).a.a(paramvlf);
        paramvlf.d = true;
        bjrh.a(this.jdField_a_of_type_Bjrh).requestLayout();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    bjrh.a(this.jdField_a_of_type_Bjrh, "");
    bjrh.b(this.jdField_a_of_type_Bjrh).setVisibility(0);
    bjrh.c(this.jdField_a_of_type_Bjrh, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjrw
 * JD-Core Version:    0.7.0.1
 */