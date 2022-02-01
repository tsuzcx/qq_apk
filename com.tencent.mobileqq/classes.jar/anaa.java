import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker;
import com.tencent.mobileqq.apollo.lightGame.CmGameLoadingView;
import com.tencent.mobileqq.apollo.lightGame.CmGameLoadingView.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class anaa
  implements View.OnClickListener
{
  public anaa(CmGameLoadingView.1 param1) {}
  
  public void onClick(View paramView)
  {
    this.a.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131700996));
    this.a.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.a.this$0.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
    this.a.this$0.setProgressViewVisibility(true);
    this.a.a.a(2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anaa
 * JD-Core Version:    0.7.0.1
 */