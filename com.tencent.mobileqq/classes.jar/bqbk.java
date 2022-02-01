import android.graphics.PointF;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

class bqbk
  implements zbi
{
  int jdField_a_of_type_Int = agej.a(18.0F, bqav.a(this.jdField_a_of_type_Bqav).getResources());
  
  bqbk(bqav parambqav) {}
  
  public void a()
  {
    bqav.e(this.jdField_a_of_type_Bqav);
    bqav.a(this.jdField_a_of_type_Bqav, true);
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat == 1.0F)
    {
      zbw localzbw = ((zbh)bqav.a(this.jdField_a_of_type_Bqav).a("TextLayer")).a();
      localzbw.b = this.jdField_a_of_type_Int;
      bqav.a(this.jdField_a_of_type_Bqav).a(localzbw);
    }
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    zbc localzbc = (zbc)bqav.a(this.jdField_a_of_type_Bqav).a("GuideLineLayer");
    if (localzbc != null) {
      localzbc.a(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
    }
  }
  
  public boolean a(zbj paramzbj)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bqav.a(this.jdField_a_of_type_Bqav) != null)
    {
      bool1 = bool2;
      if (paramzbj != null)
      {
        bqav.a(this.jdField_a_of_type_Bqav).setVisibility(0);
        if (bqav.a(this.jdField_a_of_type_Bqav).a.b())
        {
          Object localObject = bqav.a(this.jdField_a_of_type_Bqav).a.a();
          ((zfw)localObject).d = false;
          if ((localObject instanceof zbj))
          {
            localObject = (zbh)bqav.a(this.jdField_a_of_type_Bqav).a("TextLayer");
            if (localObject != null) {
              ((zbh)localObject).d();
            }
          }
        }
        bqav.a(this.jdField_a_of_type_Bqav).a.a(paramzbj);
        paramzbj.d = true;
        bqav.a(this.jdField_a_of_type_Bqav).requestLayout();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    bqav.a(this.jdField_a_of_type_Bqav, "");
    bqav.b(this.jdField_a_of_type_Bqav).setVisibility(0);
    bqav.c(this.jdField_a_of_type_Bqav, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqbk
 * JD-Core Version:    0.7.0.1
 */