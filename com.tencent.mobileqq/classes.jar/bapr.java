import android.view.View;
import com.tencent.mobileqq.richstatus.comment.widget.LikesView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bapr
  extends bapi
{
  public bapr(LikesView paramLikesView, int paramInt, String paramString)
  {
    super(paramInt);
  }
  
  public void onClick(View paramView)
  {
    if (LikesView.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetLikesView) != null) {
      LikesView.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetLikesView).a(this.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bapr
 * JD-Core Version:    0.7.0.1
 */