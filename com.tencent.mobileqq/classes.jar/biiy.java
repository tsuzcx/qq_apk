import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class biiy
  implements View.OnClickListener
{
  biiy(biix parambiix) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
      this.a.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.a.jdField_a_of_type_JavaLangString, new String[] { "" });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biiy
 * JD-Core Version:    0.7.0.1
 */