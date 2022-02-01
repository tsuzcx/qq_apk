import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

class bbit
  implements View.OnClickListener
{
  public int a;
  public View a;
  public TextView a;
  public URLImageView a;
  public View b;
  public TextView b;
  public URLImageView b;
  
  bbit(bbis parambbis) {}
  
  public void onClick(View paramView)
  {
    HotWordSearchEntryDataModel.HotSearchItem localHotSearchItem = this.jdField_a_of_type_Bbis.a(this.jdField_a_of_type_Int);
    Object localObject;
    if (paramView == this.jdField_a_of_type_AndroidViewView)
    {
      localObject = bbum.b(10);
      localObject = bbum.a(localHotSearchItem.recallWord, 5, (String)localObject);
      bbup.a(this.jdField_a_of_type_Bbis.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bbis.jdField_a_of_type_AndroidContentContext, (String)localObject);
      this.jdField_a_of_type_Bbis.jdField_a_of_type_Anur.a(localHotSearchItem.title);
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("project", bbrf.a());
      ((JSONObject)localObject).put("event_src", "client");
      ((JSONObject)localObject).put("experiment_id", bbrf.b);
      if (localHotSearchItem.type == 7)
      {
        bbrf.a(null, new ReportModelDC02528().module("recom_list").action("clk_recom_list").ver2("kandian").ver4(localHotSearchItem.title).ver7(((JSONObject)localObject).toString()).session_id(this.jdField_a_of_type_Bbis.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
        new anxu(this.jdField_a_of_type_Bbis.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_Bbis.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "clk_recom_list", "recom_list", "kandian", localHotSearchItem.sAppend, localHotSearchItem.title, ((JSONObject)localObject).toString());
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("Q.uniteSearch.HotWordAdapter", 2, "e = " + localJSONException);
        continue;
        bbrf.a(null, new ReportModelDC02528().module("hot_list").action("clk_hot_list").ver2("kandian").ver4(localHotSearchItem.title).ver7(((JSONObject)localObject).toString()).session_id(this.jdField_a_of_type_Bbis.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
        new anxu(this.jdField_a_of_type_Bbis.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_Bbis.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "clk_hot_list", "hot_list", "kandian", localHotSearchItem.sAppend, localHotSearchItem.title, ((JSONObject)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbit
 * JD-Core Version:    0.7.0.1
 */