import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.mobileqq.data.QIMNotifyAddFriend.VideoInfo;
import java.util.ArrayList;

class amjy
  implements View.OnClickListener
{
  amjy(amjw paramamjw, ArrayList paramArrayList, QIMNotifyAddFriend.VideoInfo paramVideoInfo) {}
  
  public void onClick(View paramView)
  {
    paramView = new OpenPlayerBuilder(new VidListPlayInfo(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend$VideoInfo.videoVid), 120);
    paramView.a();
    vju.a(this.jdField_a_of_type_Amjw.a, paramView.a(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amjy
 * JD-Core Version:    0.7.0.1
 */