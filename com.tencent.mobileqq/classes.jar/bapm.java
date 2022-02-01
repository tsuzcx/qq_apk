import android.view.View;
import com.tencent.mobileqq.richstatus.comment.widget.CommentsView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bapm
  extends bapi
{
  public bapm(CommentsView paramCommentsView, int paramInt, String paramString)
  {
    super(paramInt);
  }
  
  public void onClick(View paramView)
  {
    if (CommentsView.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView) != null) {
      CommentsView.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView).a(this.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bapm
 * JD-Core Version:    0.7.0.1
 */