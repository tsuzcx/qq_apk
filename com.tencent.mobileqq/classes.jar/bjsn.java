import android.graphics.PointF;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

class bjsn
  implements vlb
{
  int jdField_a_of_type_Int = actj.a(18.0F, bjry.a(this.jdField_a_of_type_Bjry).getResources());
  
  bjsn(bjry parambjry) {}
  
  public void a()
  {
    bjry.e(this.jdField_a_of_type_Bjry);
    bjry.a(this.jdField_a_of_type_Bjry, true);
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat == 1.0F)
    {
      vlp localvlp = ((vla)bjry.a(this.jdField_a_of_type_Bjry).a("TextLayer")).a();
      localvlp.b = this.jdField_a_of_type_Int;
      bjry.a(this.jdField_a_of_type_Bjry).a(localvlp);
    }
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    vkv localvkv = (vkv)bjry.a(this.jdField_a_of_type_Bjry).a("GuideLineLayer");
    if (localvkv != null) {
      localvkv.a(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
    }
  }
  
  public boolean a(vlc paramvlc)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bjry.a(this.jdField_a_of_type_Bjry) != null)
    {
      bool1 = bool2;
      if (paramvlc != null)
      {
        bjry.a(this.jdField_a_of_type_Bjry).setVisibility(0);
        if (bjry.a(this.jdField_a_of_type_Bjry).a.b())
        {
          Object localObject = bjry.a(this.jdField_a_of_type_Bjry).a.a();
          ((vpp)localObject).d = false;
          if ((localObject instanceof vlc))
          {
            localObject = (vla)bjry.a(this.jdField_a_of_type_Bjry).a("TextLayer");
            if (localObject != null) {
              ((vla)localObject).d();
            }
          }
        }
        bjry.a(this.jdField_a_of_type_Bjry).a.a(paramvlc);
        paramvlc.d = true;
        bjry.a(this.jdField_a_of_type_Bjry).requestLayout();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    bjry.a(this.jdField_a_of_type_Bjry, "");
    bjry.b(this.jdField_a_of_type_Bjry).setVisibility(0);
    bjry.c(this.jdField_a_of_type_Bjry, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjsn
 * JD-Core Version:    0.7.0.1
 */