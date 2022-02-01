package com.tencent.biz.pubaccount.readinjoy.view.headers;

import android.text.TextUtils;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.search.SearchEntryConfigManager;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class ReadInJoyTabTopSearchHeaderController$1
  extends UniteSearchObserver
{
  ReadInJoyTabTopSearchHeaderController$1(ReadInJoyTabTopSearchHeaderController paramReadInJoyTabTopSearchHeaderController) {}
  
  public void handleSearchDiscoveryError(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyTabTopSearchHeaderController", 2, "handleKandianSearchHotwordError, resultCode = " + paramInt1 + "， errorMsg = " + paramString + ", fromType = " + paramInt2);
    }
  }
  
  public void handleSearchDiscoveryResult(List<SearchEntryDataModel> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyTabTopSearchHeaderController", 2, "handleKandianSearchHotwordResult, result = " + paramList + ", fromType = " + paramInt);
    }
    if (paramInt != 10) {}
    String str;
    do
    {
      return;
      str = SearchEntryConfigManager.b;
    } while ((paramList == null) || (paramList.size() <= 0));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SearchEntryDataModel localSearchEntryDataModel = (SearchEntryDataModel)paramList.next();
      if (localSearchEntryDataModel.c == 1) {
        this.a.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = ((HotWordSearchEntryDataModel)localSearchEntryDataModel);
      }
      if ((localSearchEntryDataModel.c == 7) && (TextUtils.equals(str, "Recom_word"))) {
        this.a.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = ((HotWordSearchEntryDataModel)localSearchEntryDataModel);
      }
    }
    ReadInJoyTabTopSearchHeaderController.jdField_a_of_type_Int = 0;
    this.a.a(true, -1, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyTabTopSearchHeaderController.1
 * JD-Core Version:    0.7.0.1
 */