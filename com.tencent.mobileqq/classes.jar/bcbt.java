import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bcbt
  implements View.OnClickListener
{
  bcbt(bcbs parambcbs, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_Bcbs.a.getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Bcbs.a.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbt
 * JD-Core Version:    0.7.0.1
 */