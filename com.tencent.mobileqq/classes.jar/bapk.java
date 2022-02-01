import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richstatus.comment.widget.CommentsView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bapk
  implements View.OnClickListener
{
  public bapk(CommentsView paramCommentsView, baph parambaph, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Baph.a()) && (CommentsView.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView) != null)) {
      CommentsView.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView).a(this.jdField_a_of_type_Int, paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bapk
 * JD-Core Version:    0.7.0.1
 */