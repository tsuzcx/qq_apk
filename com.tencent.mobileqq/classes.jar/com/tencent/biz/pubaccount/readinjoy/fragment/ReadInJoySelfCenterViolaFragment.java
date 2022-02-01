package com.tencent.biz.pubaccount.readinjoy.fragment;

import alid;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONObject;
import peu;
import pfd;
import pfh;
import pjc;
import thy;

public class ReadInJoySelfCenterViolaFragment
  extends ReadInJoyViolaChannelFragment
  implements peu
{
  private pfh a;
  
  public ReadInJoySelfCenterViolaFragment()
  {
    this.jdField_a_of_type_Pfh = new pjc(this);
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null)
    {
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(3);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.b())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(thy.a(i).toString());
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.r();
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    b(paramBoolean, paramActivity, paramBundle);
    a();
  }
  
  public void ar_()
  {
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
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
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
      pfd.a().a(this.jdField_a_of_type_Pfh);
      alid.a(getActivity(), true);
      return;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    pfd.a().b(this.jdField_a_of_type_Pfh);
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