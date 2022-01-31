import android.graphics.PointF;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

class bmij
  implements xec
{
  int jdField_a_of_type_Int = aepi.a(18.0F, bmhu.a(this.jdField_a_of_type_Bmhu).getResources());
  
  bmij(bmhu parambmhu) {}
  
  public void a()
  {
    bmhu.e(this.jdField_a_of_type_Bmhu);
    bmhu.a(this.jdField_a_of_type_Bmhu, true);
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat == 1.0F)
    {
      xeq localxeq = ((xeb)bmhu.a(this.jdField_a_of_type_Bmhu).a("TextLayer")).a();
      localxeq.b = this.jdField_a_of_type_Int;
      bmhu.a(this.jdField_a_of_type_Bmhu).a(localxeq);
    }
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    xdw localxdw = (xdw)bmhu.a(this.jdField_a_of_type_Bmhu).a("GuideLineLayer");
    if (localxdw != null) {
      localxdw.a(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
    }
  }
  
  public boolean a(xed paramxed)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bmhu.a(this.jdField_a_of_type_Bmhu) != null)
    {
      bool1 = bool2;
      if (paramxed != null)
      {
        bmhu.a(this.jdField_a_of_type_Bmhu).setVisibility(0);
        if (bmhu.a(this.jdField_a_of_type_Bmhu).a.b())
        {
          Object localObject = bmhu.a(this.jdField_a_of_type_Bmhu).a.a();
          ((xiq)localObject).d = false;
          if ((localObject instanceof xed))
          {
            localObject = (xeb)bmhu.a(this.jdField_a_of_type_Bmhu).a("TextLayer");
            if (localObject != null) {
              ((xeb)localObject).d();
            }
          }
        }
        bmhu.a(this.jdField_a_of_type_Bmhu).a.a(paramxed);
        paramxed.d = true;
        bmhu.a(this.jdField_a_of_type_Bmhu).requestLayout();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    bmhu.a(this.jdField_a_of_type_Bmhu, "");
    bmhu.b(this.jdField_a_of_type_Bmhu).setVisibility(0);
    bmhu.c(this.jdField_a_of_type_Bmhu, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmij
 * JD-Core Version:    0.7.0.1
 */