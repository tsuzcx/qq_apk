import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

final class bhih
  extends ClickableSpan
{
  bhih(Context paramContext, axwq paramaxwq) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_Axwq.b());
    if (QLog.isColorLevel()) {
      QLog.i("TopicHelper", 2, "mVideoData.topicInfo.getTopicJumpUrl() :" + this.jdField_a_of_type_Axwq.b());
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#00aced"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhih
 * JD-Core Version:    0.7.0.1
 */