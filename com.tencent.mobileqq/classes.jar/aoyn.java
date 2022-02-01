import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.mobileqq.data.QIMNotifyAddFriend.VideoInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class aoyn
  implements View.OnClickListener
{
  aoyn(aoyl paramaoyl, ArrayList paramArrayList, QIMNotifyAddFriend.VideoInfo paramVideoInfo) {}
  
  public void onClick(View paramView)
  {
    OpenPlayerBuilder localOpenPlayerBuilder = new OpenPlayerBuilder(new VidListPlayInfo(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend$VideoInfo.videoVid), 120);
    localOpenPlayerBuilder.a();
    xbp.a(this.jdField_a_of_type_Aoyl.a, localOpenPlayerBuilder.a(), null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoyn
 * JD-Core Version:    0.7.0.1
 */