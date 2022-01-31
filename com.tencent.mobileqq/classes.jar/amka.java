import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import java.util.ArrayList;

class amka
  implements View.OnClickListener
{
  amka(amjz paramamjz, ArrayList paramArrayList, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new OpenPlayerBuilder(new VidListPlayInfo(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaLangString), 120);
    paramView.a();
    vju.a(this.jdField_a_of_type_Amjz.a.a, paramView.a(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amka
 * JD-Core Version:    0.7.0.1
 */