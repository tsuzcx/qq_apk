import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.GIFInfo;

class ayde
  implements aydh
{
  ayde(aydb paramaydb, HotWordSearchEntryDataModel.GIFInfo paramGIFInfo) {}
  
  public void a()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    int i = localSharedPreferences.getInt("HotWordSearchEntryModel.psk_hot_search_try_time", 0);
    String str = localSharedPreferences.getString("HotWordSearchEntryModel.psk_hot_search_try_id", "");
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    amap localamap = new amap(localQQAppInterface);
    if (!TextUtils.equals(str, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotSearchGifID))
    {
      localSharedPreferences.edit().putString("HotWordSearchEntryModel.psk_hot_search_try_id", this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotSearchGifID).apply();
      localSharedPreferences.edit().putInt("HotWordSearchEntryModel.psk_hot_search_try_time", 1).apply();
      localamap.a(localQQAppInterface, "gif_sta_first", null, null, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotSearchGifID);
      return;
    }
    localSharedPreferences.edit().putInt("HotWordSearchEntryModel.psk_hot_search_try_time", i + 1).apply();
    localamap.a(localQQAppInterface, "gif_sta_second", null, null, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotSearchGifID);
  }
  
  public void b()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    int i = localSharedPreferences.getInt("HotWordSearchEntryModel.psk_hot_search_try_time", 0);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    amap localamap = new amap(localQQAppInterface);
    if (i == 1) {
      localamap.a(localQQAppInterface, "gif_suc_first", null, null, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotSearchGifID);
    }
    for (;;)
    {
      localSharedPreferences.edit().putString("HotWordSearchEntryModel.psk_hot_search_last_show_id", this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotSearchGifID).apply();
      return;
      localamap.a(localQQAppInterface, "gif_suc_second", null, null, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotSearchGifID);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayde
 * JD-Core Version:    0.7.0.1
 */