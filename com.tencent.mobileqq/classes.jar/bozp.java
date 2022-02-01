import android.graphics.PointF;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

class bozp
  implements yxn
{
  int jdField_a_of_type_Int = afur.a(18.0F, boza.a(this.jdField_a_of_type_Boza).getResources());
  
  bozp(boza paramboza) {}
  
  public void a()
  {
    boza.e(this.jdField_a_of_type_Boza);
    boza.a(this.jdField_a_of_type_Boza, true);
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat == 1.0F)
    {
      yyb localyyb = ((yxm)boza.a(this.jdField_a_of_type_Boza).a("TextLayer")).a();
      localyyb.b = this.jdField_a_of_type_Int;
      boza.a(this.jdField_a_of_type_Boza).a(localyyb);
    }
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    yxh localyxh = (yxh)boza.a(this.jdField_a_of_type_Boza).a("GuideLineLayer");
    if (localyxh != null) {
      localyxh.a(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
    }
  }
  
  public boolean a(yxo paramyxo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (boza.a(this.jdField_a_of_type_Boza) != null)
    {
      bool1 = bool2;
      if (paramyxo != null)
      {
        boza.a(this.jdField_a_of_type_Boza).setVisibility(0);
        if (boza.a(this.jdField_a_of_type_Boza).a.b())
        {
          Object localObject = boza.a(this.jdField_a_of_type_Boza).a.a();
          ((zcb)localObject).d = false;
          if ((localObject instanceof yxo))
          {
            localObject = (yxm)boza.a(this.jdField_a_of_type_Boza).a("TextLayer");
            if (localObject != null) {
              ((yxm)localObject).d();
            }
          }
        }
        boza.a(this.jdField_a_of_type_Boza).a.a(paramyxo);
        paramyxo.d = true;
        boza.a(this.jdField_a_of_type_Boza).requestLayout();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    boza.a(this.jdField_a_of_type_Boza, "");
    boza.b(this.jdField_a_of_type_Boza).setVisibility(0);
    boza.c(this.jdField_a_of_type_Boza, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bozp
 * JD-Core Version:    0.7.0.1
 */