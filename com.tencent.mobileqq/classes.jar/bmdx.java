import android.graphics.PointF;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

class bmdx
  implements wzt
{
  int jdField_a_of_type_Int = aekt.a(18.0F, bmdi.a(this.jdField_a_of_type_Bmdi).getResources());
  
  bmdx(bmdi parambmdi) {}
  
  public void a()
  {
    bmdi.e(this.jdField_a_of_type_Bmdi);
    bmdi.a(this.jdField_a_of_type_Bmdi, true);
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat == 1.0F)
    {
      xah localxah = ((wzs)bmdi.a(this.jdField_a_of_type_Bmdi).a("TextLayer")).a();
      localxah.b = this.jdField_a_of_type_Int;
      bmdi.a(this.jdField_a_of_type_Bmdi).a(localxah);
    }
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    wzn localwzn = (wzn)bmdi.a(this.jdField_a_of_type_Bmdi).a("GuideLineLayer");
    if (localwzn != null) {
      localwzn.a(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
    }
  }
  
  public boolean a(wzu paramwzu)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bmdi.a(this.jdField_a_of_type_Bmdi) != null)
    {
      bool1 = bool2;
      if (paramwzu != null)
      {
        bmdi.a(this.jdField_a_of_type_Bmdi).setVisibility(0);
        if (bmdi.a(this.jdField_a_of_type_Bmdi).a.b())
        {
          Object localObject = bmdi.a(this.jdField_a_of_type_Bmdi).a.a();
          ((xeh)localObject).d = false;
          if ((localObject instanceof wzu))
          {
            localObject = (wzs)bmdi.a(this.jdField_a_of_type_Bmdi).a("TextLayer");
            if (localObject != null) {
              ((wzs)localObject).d();
            }
          }
        }
        bmdi.a(this.jdField_a_of_type_Bmdi).a.a(paramwzu);
        paramwzu.d = true;
        bmdi.a(this.jdField_a_of_type_Bmdi).requestLayout();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    bmdi.a(this.jdField_a_of_type_Bmdi, "");
    bmdi.b(this.jdField_a_of_type_Bmdi).setVisibility(0);
    bmdi.c(this.jdField_a_of_type_Bmdi, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdx
 * JD-Core Version:    0.7.0.1
 */