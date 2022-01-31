package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember;

import aepi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import aynu;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search.HybridSearchFragment;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import owy;
import qsm;
import qvk;
import qvl;
import qvm;
import qvn;
import qvz;
import qwa;
import qwe;
import qwg;

public class ReadInJoySelectMemberFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, qsm<ObservableArrayList<ResultRecord>>, qwg
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new qvn(this);
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  public ObservableArrayList<ResultRecord> a;
  private FollowingListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFollowingListFragment;
  private FriendListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFriendListFragment;
  private HybridSearchFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSearchHybridSearchFragment;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  protected qvz a;
  private qwa jdField_a_of_type_Qwa;
  
  public ReadInJoySelectMemberFragment()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList = new ObservableArrayList();
    this.jdField_a_of_type_Qvz = new qvz();
  }
  
  private static List<String> a(@NonNull ObservableArrayList<ResultRecord> paramObservableArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramObservableArrayList = paramObservableArrayList.iterator();
    while (paramObservableArrayList.hasNext()) {
      localArrayList.add(((ResultRecord)paramObservableArrayList.next()).a());
    }
    return localArrayList;
  }
  
  private void a()
  {
    owy.a().q();
  }
  
  private void a(Bundle paramBundle)
  {
    if (this.mContentView.findViewById(2131366799) != null)
    {
      if (paramBundle != null) {
        return;
      }
      g();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFriendListFragment = new FriendListFragment();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFriendListFragment.b(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFriendListFragment.a(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFriendListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFriendListFragment.a(this.jdField_a_of_type_Qvz);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFollowingListFragment = new FollowingListFragment();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFollowingListFragment.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFollowingListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFollowingListFragment.a(this.jdField_a_of_type_Qvz);
      getChildFragmentManager().beginTransaction().add(2131366799, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFriendListFragment).commit();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.addOnListChangedCallback(this);
    j();
  }
  
  private void f()
  {
    h();
    d();
  }
  
  private void g()
  {
    Object localObject = getArguments();
    if (localObject != null)
    {
      this.jdField_a_of_type_Qvz.a(((Bundle)localObject).getInt("opentype", 0));
      this.jdField_a_of_type_Qvz.b(((Bundle)localObject).getInt("maxSelect", 10));
      this.jdField_a_of_type_Qvz.c(((Bundle)localObject).getInt("maxCount", 30));
      this.jdField_a_of_type_Qvz.b(((Bundle)localObject).getString("rowkey", ""));
      this.jdField_a_of_type_Qvz.a(((Bundle)localObject).getString("callback", ""));
      if (((Bundle)localObject).containsKey("filterUins"))
      {
        localObject = ((Bundle)localObject).getString("filterUins", "");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).length() > 0)) {
          this.jdField_a_of_type_Qvz.a(Arrays.asList(((String)localObject).split(",")));
        }
      }
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSearchHybridSearchFragment = HybridSearchFragment.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSearchHybridSearchFragment.a(this);
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131376221);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.mContentView.findViewById(2131376271));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(new qvk(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new qvl(this));
  }
  
  private void i()
  {
    TextView localTextView = (TextView)getRightTextView();
    int j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.size();
    int i;
    if (j > 4)
    {
      i = 1;
      if (j <= 0) {
        break label152;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      setRightViewTextDisable(1);
      if (this.jdField_a_of_type_Qvz.a() != 1) {
        break label124;
      }
      localTextView.setText(MessageFormat.format(getString(2131719024), new Object[] { Integer.valueOf(j) }));
    }
    for (;;)
    {
      if (i == 0) {
        break label196;
      }
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLayoutParams().width = aepi.a(200.0F, getResources());
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.requestLayout();
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.smoothScrollToPosition(j - 1);
      return;
      i = 0;
      break;
      label124:
      localTextView.setText(MessageFormat.format(getString(2131719721), new Object[] { Integer.valueOf(j) }));
    }
    label152:
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (this.jdField_a_of_type_Qvz.a() == 1) {
      localTextView.setText(2131719021);
    }
    for (;;)
    {
      setRightViewTextDisable(0);
      break;
      localTextView.setText(2131719720);
    }
    label196:
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLayoutParams().width = -2;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.requestLayout();
  }
  
  private void j()
  {
    Resources localResources = getResources();
    if (this.jdField_a_of_type_Qvz.a() == 1)
    {
      setTitle(localResources.getString(2131719019));
      setRightButton(2131719021, this);
    }
    for (;;)
    {
      setRightViewTextDisable(0);
      return;
      setTitle(localResources.getString(2131719704));
      setRightButton(2131719720, this);
    }
  }
  
  private void k()
  {
    if (getChildFragmentManager().getBackStackEntryCount() > 0) {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    }
  }
  
  public void a(aynu paramaynu)
  {
    ResultRecord localResultRecord = ResultRecord.a(paramaynu.b(), paramaynu.a().toString());
    if ((paramaynu instanceof qwe)) {
      localResultRecord.a(2);
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.contains(localResultRecord))
      {
        if ((this.jdField_a_of_type_Qvz.a() != 1) || (TextUtils.isEmpty(paramaynu.b())) || (this.jdField_a_of_type_Qvz.a() == null)) {
          break label194;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.size() < this.jdField_a_of_type_Qvz.b()) {
          break;
        }
        paramaynu = getActivity().getResources().getString(2131719026, new Object[] { String.valueOf(this.jdField_a_of_type_Qvz.c()) });
        QQToast.a(getActivity(), paramaynu, 0).a();
      }
      return;
      localResultRecord.a(1);
    }
    if (this.jdField_a_of_type_Qvz.a().contains(paramaynu.b()))
    {
      QQToast.a(getActivity(), getActivity().getResources().getString(2131719020), 0).a();
      return;
    }
    label194:
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.add(localResultRecord);
    k();
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList) {}
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2) {}
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void b()
  {
    c();
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSearchHybridSearchFragment.b_(a(paramObservableArrayList));
    if (paramObservableArrayList.size() > this.jdField_a_of_type_Qvz.b())
    {
      String str = String.format(getString(2131695096), new Object[] { Integer.valueOf(this.jdField_a_of_type_Qvz.b()) });
      if (this.jdField_a_of_type_Qvz.a() == 1) {
        str = getString(2131719026, new Object[] { String.valueOf(this.jdField_a_of_type_Qvz.c()) });
      }
      paramObservableArrayList.subList(paramInt1, paramInt1 + paramInt2).clear();
      QQToast.a(getActivity(), str, 0).a();
      return;
    }
    i();
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.size() > 0)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("result_set", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList);
      getActivity().setResult(-1, localIntent);
    }
  }
  
  public void c(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSearchHybridSearchFragment.b_(a(paramObservableArrayList));
    i();
  }
  
  protected void d()
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.mContentView.findViewById(2131376377));
    this.jdField_a_of_type_Qwa = new qwa(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Qwa);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(new qvm(this));
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.mContentView == null)
    {
      QLog.e("IphoneTitleBarFragment", 1, "mContentView == null");
      return;
    }
    f();
    a(paramBundle);
    a();
  }
  
  public void e()
  {
    if ((getActivity() != null) && (this.jdField_a_of_type_AndroidWidgetEditText != null)) {}
    try
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)getActivity().getSystemService("input_method");
      if (localInputMethodManager.isActive())
      {
        localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 2);
        this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131560105;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramActivity.overridePendingTransition(2130771997, 2130771990);
  }
  
  public boolean onBackEvent()
  {
    if (getChildFragmentManager().getBackStackEntryCount() > 0)
    {
      e();
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      return true;
    }
    c();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368655: 
      b();
      return;
    }
    e();
    getChildFragmentManager().beginTransaction().setCustomAnimations(2130772047, 2130772048, 2130772043, 2130772044).hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFriendListFragment).add(2131366799, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFollowingListFragment).addToBackStack(FollowingListFragment.class.getName()).commit();
  }
  
  public void onFinish()
  {
    super.onFinish();
    getActivity().overridePendingTransition(2130771990, 2130771978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberFragment
 * JD-Core Version:    0.7.0.1
 */