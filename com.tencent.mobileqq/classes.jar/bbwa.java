import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.richstatus.comment.widget.CommentsView;

public class bbwa
  implements View.OnLongClickListener
{
  public bbwa(CommentsView paramCommentsView, bbvw parambbvw, int paramInt) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_Bbvw.a())
    {
      if (CommentsView.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView) != null) {
        CommentsView.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView).a(this.jdField_a_of_type_Int, paramView);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbwa
 * JD-Core Version:    0.7.0.1
 */