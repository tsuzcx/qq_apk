package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.OnTabRedNumsChangeListenner;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.viola.utils.ViolaBizUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.mobileqq.activity.qwallet.utils.FlymeOSStatusBarFontUtils;
import org.json.JSONObject;

public class ReadInJoySelfCenterViolaFragment
  extends ReadInJoyViolaChannelFragment
  implements KandianMergeManager.OnTabRedNumsChangeListenner
{
  private ReadInJoyObserver a;
  
  public ReadInJoySelfCenterViolaFragment()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ReadInJoySelfCenterViolaFragment.1(this);
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
    if (a() != null)
    {
      int i = a().b(3);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.b())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(ViolaBizUtils.a(i).toString());
      }
    }
  }
  
  private void c()
  {
    if (a() != null) {
      a().q();
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    b(paramBoolean, paramActivity, paramBundle);
    a();
  }
  
  public void ai_()
  {
    a();
  }
  
  protected boolean f()
  {
    return false;
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
      String str = localBundle.getString("url_key");
      int i = a().b(3);
      paramBundle = str;
      if (i > 0) {
        paramBundle = str + "&unreadMessageCount=" + i;
      }
      paramBundle = paramBundle + "&statusBarStyle=0";
      if (!TextUtils.isEmpty(paramBundle)) {
        a(paramBundle);
      }
      this.b = localBundle.getString("channel_version_key", "");
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    FlymeOSStatusBarFontUtils.a(getActivity(), true);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  public void onResume()
  {
    super.onResume();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfCenterViolaFragment
 * JD-Core Version:    0.7.0.1
 */