package com.tencent.biz.pubaccount.readinjoy.view.headers;

import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class ReadInJoyFeedsHeaderViewController$2
  extends UniteSearchObserver
{
  ReadInJoyFeedsHeaderViewController$2(ReadInJoyFeedsHeaderViewController paramReadInJoyFeedsHeaderViewController) {}
  
  public void handleSearchDiscoveryError(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyFeedsHeaderVie", 2, "handleKandianSearchHotwordError, resultCode = " + paramInt1 + "， errorMsg = " + paramString + ", fromType = " + paramInt2);
    }
  }
  
  public void handleSearchDiscoveryResult(List<SearchEntryDataModel> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyFeedsHeaderVie", 2, "handleKandianSearchHotwordResult, result = " + paramList + ", fromType = " + paramInt);
    }
    if (paramInt != 6) {}
    while (((this.a.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel != null) && (this.a.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.size() != 0)) || (paramList == null) || (paramList.size() <= 0) || (!(paramList.get(0) instanceof HotWordSearchEntryDataModel))) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = ((HotWordSearchEntryDataModel)paramList.get(0));
    ReadInJoyFeedsHeaderViewController.jdField_a_of_type_Int = 0;
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyFeedsHeaderViewController.2
 * JD-Core Version:    0.7.0.1
 */