package com.tencent.biz.pubaccount.readinjoy.ugc;

import afez;
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
import ocd;
import ozs;
import pfa;
import pfd;
import pfh;
import rce;
import rcf;
import rcg;
import rch;
import rci;
import rcj;
import rck;
import rcl;

public class ReadInJoyVideoTagSelectionFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver = new rce(this);
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  private pfh jdField_a_of_type_Pfh = new rcg(this);
  private rcj jdField_a_of_type_Rcj;
  private rck jdField_a_of_type_Rck;
  private DataSetObserver jdField_b_of_type_AndroidDatabaseDataSetObserver = new rcf(this);
  private View jdField_b_of_type_AndroidViewView;
  private QQToast jdField_b_of_type_ComTencentMobileqqWidgetQQToast;
  private View c;
  
  private void a()
  {
    this.c.setVisibility(0);
  }
  
  private void b()
  {
    this.c = this.mContentView.findViewById(2131378430);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131378793));
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131365073);
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131365069);
    ReadInJoyFlowLayout localReadInJoyFlowLayout = (ReadInJoyFlowLayout)this.mContentView.findViewById(2131366908);
    this.jdField_a_of_type_Rcj = new rcj(getActivity(), 2131560298);
    this.jdField_a_of_type_Rcj.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
    localReadInJoyFlowLayout.setAdapter(this.jdField_a_of_type_Rcj);
    localReadInJoyFlowLayout.setOnItemClickListener(new rch(this));
    localReadInJoyFlowLayout = (ReadInJoyFlowLayout)this.mContentView.findViewById(2131366909);
    this.jdField_a_of_type_Rck = new rck(getActivity(), 2131560298);
    this.jdField_a_of_type_Rck.registerDataSetObserver(this.jdField_b_of_type_AndroidDatabaseDataSetObserver);
    localReadInJoyFlowLayout.setAdapter(this.jdField_a_of_type_Rck);
    this.jdField_a_of_type_Rck.notifyDataSetChanged();
    localReadInJoyFlowLayout.setOnItemClickListener(new rci(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(getActivity(), 2131717301, 0);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(getActivity(), 2131717300, 0);
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
          this.jdField_a_of_type_Rcj.addAll(localArrayList);
          localObject3 = localObject1;
        }
        this.jdField_a_of_type_Rcj.notifyDataSetChanged();
        pfd.a().a(this.jdField_a_of_type_Pfh);
        if (localObject3 == null) {
          break label97;
        }
        pfa.a().b(((Long)localObject3).longValue());
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.d("ReadInJoyVideoTagSelectionFragment", 2, "handleIntent: fail to get topicId");
      }
      Object localObject2 = null;
      continue;
      label97:
      pfa.a().g(null);
      return;
      localObject3 = null;
    }
  }
  
  private void d()
  {
    this.vg.changeBg(true);
    setRightButton(2131690912, this);
    this.rightViewText.setTextColor(-16265040);
    this.rightViewText.setBackgroundResource(0);
    setTitle(getString(2131717268));
    this.leftView.setText(2131690384);
    rcl.a(this);
  }
  
  private void e()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("EXTRA_SELECTION_REACH_MAXIMUM_NUMBER", this.jdField_a_of_type_Rcj.a());
    afez.a(getActivity(), localIntent, PublicTransFragmentActivity.class, ReadInJoyVideoSearchTagFragment.class, 1000);
  }
  
  private void f()
  {
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    int j = this.jdField_a_of_type_Rcj.getCount();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(this.jdField_a_of_type_Rcj.getItem(i));
      i += 1;
    }
    localIntent.putParcelableArrayListExtra("EXTRA_SELECTED_TAG_LIST", localArrayList);
    getActivity().setResult(-1, localIntent);
    getActivity().finish();
    ocd.a(null, "", "0X80092F2", "0X80092F2", 0, 0, Integer.valueOf(localArrayList.size()).toString(), "", "", ozs.g(), false);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    b();
  }
  
  public int getContentLayoutId()
  {
    return 2131560297;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1000) && (paramInt2 == -1))
    {
      paramIntent = (TagInfo)paramIntent.getParcelableExtra("SEARCH_TAG_RESULT");
      if ((paramIntent != null) && (!this.jdField_a_of_type_Rcj.a(paramIntent)) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.c())) {
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
    pfd.a().b(this.jdField_a_of_type_Pfh);
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