import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class aoyp
  implements View.OnClickListener
{
  aoyp(aoyo paramaoyo, ArrayList paramArrayList, String paramString) {}
  
  public void onClick(View paramView)
  {
    OpenPlayerBuilder localOpenPlayerBuilder = new OpenPlayerBuilder(new VidListPlayInfo(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaLangString), 120);
    localOpenPlayerBuilder.a();
    xbp.a(this.jdField_a_of_type_Aoyo.a.a, localOpenPlayerBuilder.a(), null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoyp
 * JD-Core Version:    0.7.0.1
 */