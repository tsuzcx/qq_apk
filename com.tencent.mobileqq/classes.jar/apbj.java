import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class apbj
  implements View.OnClickListener
{
  apbj(apbi paramapbi, String paramString) {}
  
  public void onClick(View paramView)
  {
    OpenPlayerBuilder localOpenPlayerBuilder = new OpenPlayerBuilder(new VidListPlayInfo(this.jdField_a_of_type_JavaLangString), 120);
    localOpenPlayerBuilder.a();
    xlj.a(this.jdField_a_of_type_Apbi.a, localOpenPlayerBuilder.a(), null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbj
 * JD-Core Version:    0.7.0.1
 */