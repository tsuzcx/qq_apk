import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class aydc
  implements zcb
{
  aydc(aydb paramaydb) {}
  
  public void a(HotWordSearchEntryDataModel.HotSearchItem paramHotSearchItem)
  {
    Object localObject;
    HotWordSearchEntryDataModel.HotSearchItem localHotSearchItem;
    if (paramHotSearchItem != null)
    {
      localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localHotSearchItem = (HotWordSearchEntryDataModel.HotSearchItem)((Iterator)localObject).next();
      } while (!TextUtils.equals(paramHotSearchItem.title, localHotSearchItem.title));
    }
    for (;;)
    {
      if (localHotSearchItem == null) {
        return;
      }
      localObject = localHotSearchItem.jumpUrl;
      paramHotSearchItem = (HotWordSearchEntryDataModel.HotSearchItem)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        if (this.a.jdField_a_of_type_Int != 10) {
          break label382;
        }
        paramHotSearchItem = ayra.a(localHotSearchItem.recallWord, 5, "kandian_hotword");
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.HotWordSearchEntryModel", 2, "open Browser append suffix url = " + paramHotSearchItem);
        }
        aydb.a(this.a, paramHotSearchItem, localHotSearchItem.recallWord);
        ayrd.a("hot_list", "clk_hot_list", new String[] { localHotSearchItem.title, String.valueOf(this.a.jdField_a_of_type_Int), String.valueOf(this.a.jdField_a_of_type_JavaUtilList.indexOf(localHotSearchItem) + 1) });
        paramHotSearchItem = new JSONObject();
        try
        {
          paramHotSearchItem.put("project", aynt.a());
          paramHotSearchItem.put("event_src", "client");
          paramHotSearchItem.put("experiment_id", aynt.b);
          localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("hot_list").action("clk_hot_list");
          if (this.a.jdField_a_of_type_Int == 3)
          {
            i = 21;
            aynt.a(null, localReportModelDC02528.ver2(aynt.a(i)).ver4(localHotSearchItem.title).ver7(paramHotSearchItem.toString()).session_id(((QQAppInterface)localObject).getCurrentAccountUin() + this.a.jdField_a_of_type_Long));
            aynt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, SearchEntryFragment.a(this.a.jdField_a_of_type_Int), "0X8009D28", 0, 0, null, null);
            ((alxs)((QQAppInterface)ors.a()).getManager(299)).a(localHotSearchItem.recallWord);
            return;
            label382:
            paramHotSearchItem = ayra.b(this.a.jdField_a_of_type_Int);
            paramHotSearchItem = ayra.a(localHotSearchItem.recallWord, 5, paramHotSearchItem);
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QLog.e("Q.uniteSearch.HotWordSearchEntryModel", 2, "e = " + localJSONException);
            continue;
            int i = this.a.jdField_a_of_type_Int;
          }
        }
      }
      localHotSearchItem = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aydc
 * JD-Core Version:    0.7.0.1
 */