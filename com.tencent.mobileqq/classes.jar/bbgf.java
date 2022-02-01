import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class bbgf
  implements abdj
{
  bbgf(bbge parambbge) {}
  
  public void a(HotWordSearchEntryDataModel.HotSearchItem paramHotSearchItem)
  {
    int j = 21;
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
          break label581;
        }
        paramHotSearchItem = bbum.a(localHotSearchItem.recallWord, 5, "kandian_hotword");
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.HotWordSearchEntryModel", 2, "open Browser append suffix url = " + paramHotSearchItem);
        }
        bbge.a(this.a, paramHotSearchItem, localHotSearchItem.recallWord);
        bbup.a("hot_list", "clk_hot_list", new String[] { localHotSearchItem.title, String.valueOf(this.a.jdField_a_of_type_Int), String.valueOf(this.a.jdField_a_of_type_JavaUtilList.indexOf(localHotSearchItem) + 1) });
        paramHotSearchItem = new JSONObject();
        try
        {
          paramHotSearchItem.put("project", bbrf.a());
          paramHotSearchItem.put("event_src", "client");
          paramHotSearchItem.put("experiment_id", bbrf.b);
          localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          localanxu = new anxu((QQAppInterface)localObject);
          if (localHotSearchItem.type == 7)
          {
            localReportModelDC02528 = new ReportModelDC02528().module("recom_list").action("clk_recom_list");
            if (this.a.jdField_a_of_type_Int == 3)
            {
              i = 21;
              bbrf.a(null, localReportModelDC02528.ver2(bbrf.a(i)).ver4(localHotSearchItem.title).ver7(paramHotSearchItem.toString()).session_id(((QQAppInterface)localObject).getCurrentAccountUin() + this.a.jdField_a_of_type_Long));
              if (this.a.jdField_a_of_type_Int != 3) {
                break label648;
              }
              i = 21;
              localanxu.b((QQAppInterface)localObject, "clk_recom_list", "recom_list", bbrf.a(i), localHotSearchItem.sAppend, localHotSearchItem.title, paramHotSearchItem.toString());
              if ((UniteSearchActivity.a != null) && (TextUtils.equals(UniteSearchActivity.a.title, localHotSearchItem.title)))
              {
                paramHotSearchItem = new ReportModelDC02528().module("default_word").action("clk_default_word");
                if (this.a.jdField_a_of_type_Int != 3) {
                  break label819;
                }
                i = 21;
                bbrf.a(null, paramHotSearchItem.ver2(bbrf.a(i)).ver4(localHotSearchItem.title).ver7(bbgu.b));
                if (this.a.jdField_a_of_type_Int != 3) {
                  break label830;
                }
                i = j;
                localanxu.b((QQAppInterface)localObject, "clk_default_word", "default_word", bbrf.a(i), localHotSearchItem.sAppend, localHotSearchItem.title, bbgu.b);
              }
              bbrf.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, SearchEntryFragment.a(this.a.jdField_a_of_type_Int), "0X8009D28", 0, 0, null, null);
              ((anur)((QQAppInterface)pha.a()).getManager(299)).a(localHotSearchItem.recallWord);
              return;
              label581:
              paramHotSearchItem = bbum.b(this.a.jdField_a_of_type_Int);
              paramHotSearchItem = bbum.a(localHotSearchItem.recallWord, 5, paramHotSearchItem);
            }
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            anxu localanxu;
            QLog.e("Q.uniteSearch.HotWordSearchEntryModel", 2, "e = " + localJSONException);
            continue;
            int i = this.a.jdField_a_of_type_Int;
            continue;
            label648:
            i = this.a.jdField_a_of_type_Int;
            continue;
            ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("hot_list").action("clk_hot_list");
            if (this.a.jdField_a_of_type_Int == 3)
            {
              i = 21;
              label692:
              bbrf.a(null, localReportModelDC02528.ver2(bbrf.a(i)).ver4(localHotSearchItem.title).ver7(paramHotSearchItem.toString()).session_id(localJSONException.getCurrentAccountUin() + this.a.jdField_a_of_type_Long));
              if (this.a.jdField_a_of_type_Int != 3) {
                break label808;
              }
            }
            label808:
            for (i = 21;; i = this.a.jdField_a_of_type_Int)
            {
              localanxu.b(localJSONException, "clk_hot_list", "hot_list", bbrf.a(i), localHotSearchItem.sAppend, localHotSearchItem.title, paramHotSearchItem.toString());
              break;
              i = this.a.jdField_a_of_type_Int;
              break label692;
            }
            label819:
            i = this.a.jdField_a_of_type_Int;
            continue;
            label830:
            i = this.a.jdField_a_of_type_Int;
          }
        }
      }
      localHotSearchItem = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbgf
 * JD-Core Version:    0.7.0.1
 */