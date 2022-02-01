import NS_MINI_APP_MISC.MISC.StAppPlayingInfo;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class avhh
  implements View.OnClickListener
{
  avhh(avhg paramavhg, MISC.StAppPlayingInfo paramStAppPlayingInfo, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    avhj.a(paramView.getContext(), this.jdField_a_of_type_NS_MINI_APP_MISCMISC$StAppPlayingInfo.appMetaInfo, avhg.a(this.jdField_a_of_type_Avhg), avhg.a(this.jdField_a_of_type_Avhg), this.jdField_a_of_type_Boolean);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avhh
 * JD-Core Version:    0.7.0.1
 */