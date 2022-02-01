package com.tencent.biz.pubaccount.readinjoy.fragment;

import albp;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import org.json.JSONObject;
import pvd;
import pvm;
import pvq;
import pzm;
import tzr;

public class ReadInJoySelfCenterViolaFragment
  extends ReadInJoyViolaChannelFragment
  implements pvd
{
  private pvq a;
  
  public ReadInJoySelfCenterViolaFragment()
  {
    this.jdField_a_of_type_Pvq = new pzm(this);
  }
  
  public static ReadInJoySelfCenterViolaFragment a(String paramString)
  {
    ReadInJoySelfCenterViolaFragment localReadInJoySelfCenterViolaFragment = new ReadInJoySelfCenterViolaFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("url_key", paramString);
    localReadInJoySelfCenterViolaFragment.setArguments(localBundle);
    return localReadInJoySelfCenterViolaFragment;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null)
    {
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(3);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.b())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(tzr.a(i).toString());
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.q();
    }
  }
  
  public void E_()
  {
    a();
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    b(paramBoolean, paramActivity, paramBundle);
    a();
  }
  
  public void l()
  {
    a();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      paramBundle = localBundle.getString("url_key");
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
      }
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(3);
      if (i <= 0) {
        break label145;
      }
      paramBundle = paramBundle + "&unreadMessageCount=" + i;
    }
    label145:
    for (;;)
    {
      paramBundle = paramBundle + "&statusBarStyle=0";
      if (!TextUtils.isEmpty(paramBundle)) {
        a(paramBundle);
      }
      this.b = localBundle.getString("channel_version_key", "");
      pvm.a().a(this.jdField_a_of_type_Pvq);
      albp.a(getActivity(), true);
      return;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    pvm.a().b(this.jdField_a_of_type_Pvq);
  }
  
  public void onResume()
  {
    super.onResume();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfCenterViolaFragment
 * JD-Core Version:    0.7.0.1
 */