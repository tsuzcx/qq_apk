package com.tencent.biz.pubaccount.readinjoy.ugc;

import aeow;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFlowLayout;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import olh;
import pqf;
import ptj;
import pvj;
import pvm;
import pvq;
import rvq;
import rvr;
import rvs;
import rvt;
import rvu;
import rvv;
import rvw;
import rvy;

public class ReadInJoyVideoTagSelectionFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver = new rvq(this);
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  private pvq jdField_a_of_type_Pvq = new rvs(this);
  private rvv jdField_a_of_type_Rvv;
  private rvw jdField_a_of_type_Rvw;
  private DataSetObserver jdField_b_of_type_AndroidDatabaseDataSetObserver = new rvr(this);
  private View jdField_b_of_type_AndroidViewView;
  private QQToast jdField_b_of_type_ComTencentMobileqqWidgetQQToast;
  private View c;
  
  private void a()
  {
    this.c.setVisibility(0);
  }
  
  private void b()
  {
    this.c = this.mContentView.findViewById(2131378485);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131378848));
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131365185);
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131365180);
    ReadInJoyFlowLayout localReadInJoyFlowLayout = (ReadInJoyFlowLayout)this.mContentView.findViewById(2131367049);
    this.jdField_a_of_type_Rvv = new rvv(getActivity(), 2131560351);
    this.jdField_a_of_type_Rvv.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
    localReadInJoyFlowLayout.setAdapter(this.jdField_a_of_type_Rvv);
    localReadInJoyFlowLayout.setOnItemClickListener(new rvt(this));
    localReadInJoyFlowLayout = (ReadInJoyFlowLayout)this.mContentView.findViewById(2131367050);
    this.jdField_a_of_type_Rvw = new rvw(getActivity(), 2131560351);
    this.jdField_a_of_type_Rvw.registerDataSetObserver(this.jdField_b_of_type_AndroidDatabaseDataSetObserver);
    localReadInJoyFlowLayout.setAdapter(this.jdField_a_of_type_Rvw);
    this.jdField_a_of_type_Rvw.notifyDataSetChanged();
    localReadInJoyFlowLayout.setOnItemClickListener(new rvu(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(getActivity(), 2131717899, 0);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(getActivity(), 2131717898, 0);
    c();
  }
  
  private void c()
  {
    Object localObject3 = getActivity().getIntent();
    Object localObject1;
    if (localObject3 != null)
    {
      localObject1 = ((Intent)localObject3).getStringExtra("EXTRA_TOPIC_ID");
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = Long.valueOf((String)localObject1);
        ArrayList localArrayList = ((Intent)localObject3).getParcelableArrayListExtra("EXTRA_SELECTED_TAG_LIST");
        localObject3 = localObject1;
        if (localArrayList != null)
        {
          this.jdField_a_of_type_Rvv.addAll(localArrayList);
          localObject3 = localObject1;
        }
        this.jdField_a_of_type_Rvv.notifyDataSetChanged();
        pvm.a().a(this.jdField_a_of_type_Pvq);
        if (localObject3 == null) {
          break label97;
        }
        pvj.a().b(((Long)localObject3).longValue());
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.d("ReadInJoyVideoTagSelectionFragment", 2, "handleIntent: fail to get topicId");
      }
      Object localObject2 = null;
      continue;
      label97:
      pvj.a().g(null);
      return;
      localObject3 = null;
    }
  }
  
  private void d()
  {
    this.vg.changeBg(true);
    setRightButton(2131691037, this);
    this.rightViewText.setTextColor(-16265040);
    this.rightViewText.setBackgroundResource(0);
    setTitle(getString(2131717865));
    this.leftView.setText(2131690499);
    rvy.a(this);
  }
  
  private void e()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("EXTRA_SELECTION_REACH_MAXIMUM_NUMBER", this.jdField_a_of_type_Rvv.a());
    aeow.a(getActivity(), localIntent, PublicTransFragmentActivity.class, ReadInJoyVideoSearchTagFragment.class, 1000);
  }
  
  private void f()
  {
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    int j = this.jdField_a_of_type_Rvv.getCount();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(this.jdField_a_of_type_Rvv.getItem(i));
      i += 1;
    }
    localIntent.putParcelableArrayListExtra("EXTRA_SELECTED_TAG_LIST", localArrayList);
    getActivity().setResult(-1, localIntent);
    getActivity().finish();
    olh.a(null, "", "0X80092F2", "0X80092F2", 0, 0, Integer.valueOf(localArrayList.size()).toString(), "", "", pqf.c(), false);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    b();
    ptj.a.a(getActivity());
  }
  
  public int getContentLayoutId()
  {
    return 2131560350;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1000) && (paramInt2 == -1))
    {
      paramIntent = (TagInfo)paramIntent.getParcelableExtra("SEARCH_TAG_RESULT");
      if ((paramIntent != null) && (!this.jdField_a_of_type_Rvv.a(paramIntent)) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.c())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a();
      }
    }
  }
  
  public boolean onBackEvent()
  {
    f();
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.c.setVisibility(8);
      e();
      continue;
      f();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    pvm.a().b(this.jdField_a_of_type_Pvq);
  }
  
  public void onResume()
  {
    super.onResume();
    d();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoTagSelectionFragment
 * JD-Core Version:    0.7.0.1
 */