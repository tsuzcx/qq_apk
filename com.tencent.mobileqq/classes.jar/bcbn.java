import android.text.TextUtils;
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

class bcbn
  implements View.OnClickListener
{
  public int a;
  public View a;
  public TextView a;
  public URLImageView a;
  public View b;
  public TextView b;
  public URLImageView b;
  
  bcbn(bcbm parambcbm) {}
  
  public void onClick(View paramView)
  {
    HotWordSearchEntryDataModel.HotSearchItem localHotSearchItem = this.jdField_a_of_type_Bcbm.a(this.jdField_a_of_type_Int);
    if (paramView == this.jdField_a_of_type_AndroidViewView)
    {
      localObject = "kandian_hotword";
      if (localHotSearchItem.type == 7) {
        localObject = "kandian_recomword";
      }
      String str = localHotSearchItem.jumpUrl;
      if (!TextUtils.isEmpty(str)) {
        break label377;
      }
    }
    label377:
    for (Object localObject = bcnf.a(localHotSearchItem.recallWord, 5, (String)localObject);; localObject = localJSONException)
    {
      bcni.a(this.jdField_a_of_type_Bcbm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bcbm.jdField_a_of_type_AndroidContentContext, (String)localObject);
      this.jdField_a_of_type_Bcbm.jdField_a_of_type_Aohb.a(localHotSearchItem.title);
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("project", bcjy.a());
        ((JSONObject)localObject).put("event_src", "client");
        ((JSONObject)localObject).put("experiment_id", bcjy.b);
        if (localHotSearchItem.type == 7)
        {
          bcjy.a(null, new ReportModelDC02528().module("recom_list").action("clk_recom_list").ver2("kandian").ver4(localHotSearchItem.title).ver7(((JSONObject)localObject).toString()).session_id(this.jdField_a_of_type_Bcbm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
          new aokg(this.jdField_a_of_type_Bcbm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_Bcbm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "clk_recom_list", "recom_list", "kandian", localHotSearchItem.sAppend, localHotSearchItem.title, ((JSONObject)localObject).toString());
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
          bcjy.a(null, new ReportModelDC02528().module("hot_list").action("clk_hot_list").ver2("kandian").ver4(localHotSearchItem.title).ver7(((JSONObject)localObject).toString()).session_id(this.jdField_a_of_type_Bcbm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
          new aokg(this.jdField_a_of_type_Bcbm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_Bcbm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "clk_hot_list", "hot_list", "kandian", localHotSearchItem.sAppend, localHotSearchItem.title, ((JSONObject)localObject).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbn
 * JD-Core Version:    0.7.0.1
 */