package com.tencent.mobileqq.activity.qwallet.fragment;

import Wallet.GetRandomHbIdiomRsp;
import android.os.Bundle;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.observer.BusinessObserver;

class WordChainHbFragment$3
  implements BusinessObserver
{
  WordChainHbFragment$3(WordChainHbFragment paramWordChainHbFragment, int paramInt, WordChainHbFragment.GetIdiomListener paramGetIdiomListener) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    WordChainHbFragment.a().remove(Integer.valueOf(WordChainHbFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment).currSelectedSubChannel));
    if (paramInt == 27)
    {
      paramBundle = (GetRandomHbIdiomRsp)paramBundle.getSerializable("rsp");
      if (QLog.isColorLevel()) {
        QLog.d("WordChainHbFragment", 2, "ReportHBGameRsp reportObserver:" + paramBoolean + "|" + paramBundle);
      }
      if ((!paramBoolean) || (paramBundle == null) || (paramBundle.suggestIdioms == null) || (paramBundle.suggestIdioms.size() <= 0)) {
        break label217;
      }
      localIdiomRecommendInfo = new WordChainHbFragment.IdiomRecommendInfo();
      localIdiomRecommendInfo.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList(paramBundle.suggestIdioms);
      localIdiomRecommendInfo.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
      WordChainHbFragment.a().put(Integer.valueOf(this.jdField_a_of_type_Int), localIdiomRecommendInfo);
      if (QLog.isColorLevel()) {
        QLog.d("WordChainHbFragment", 2, "getIdiomListFromSSO idiomListSize:" + localIdiomRecommendInfo.jdField_a_of_type_JavaUtilList.size());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$GetIdiomListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$GetIdiomListener.a(true, localIdiomRecommendInfo.jdField_a_of_type_JavaUtilList);
      }
    }
    label217:
    while (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$GetIdiomListener == null)
    {
      WordChainHbFragment.IdiomRecommendInfo localIdiomRecommendInfo;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$GetIdiomListener.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.WordChainHbFragment.3
 * JD-Core Version:    0.7.0.1
 */