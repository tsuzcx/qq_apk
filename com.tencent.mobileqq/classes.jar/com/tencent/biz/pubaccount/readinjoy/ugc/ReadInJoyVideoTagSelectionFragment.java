package com.tencent.biz.pubaccount.readinjoy.ugc;

import abju;
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
import bbmy;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFlowLayout;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import ndn;
import obz;
import ogy;
import ohb;
import ohe;
import pum;
import pun;
import puo;
import pup;
import puq;
import pur;
import pus;
import put;

public class ReadInJoyVideoTagSelectionFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver = new pum(this);
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bbmy jdField_a_of_type_Bbmy;
  private ohe jdField_a_of_type_Ohe = new puo(this);
  private pur jdField_a_of_type_Pur;
  private pus jdField_a_of_type_Pus;
  private DataSetObserver jdField_b_of_type_AndroidDatabaseDataSetObserver = new pun(this);
  private View jdField_b_of_type_AndroidViewView;
  private bbmy jdField_b_of_type_Bbmy;
  private View c;
  
  private void a()
  {
    this.c.setVisibility(0);
  }
  
  private void b()
  {
    this.c = this.mContentView.findViewById(2131311064);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131311407));
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131299156);
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131299153);
    ReadInJoyFlowLayout localReadInJoyFlowLayout = (ReadInJoyFlowLayout)this.mContentView.findViewById(2131300870);
    this.jdField_a_of_type_Pur = new pur(getActivity(), 2131494476);
    this.jdField_a_of_type_Pur.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
    localReadInJoyFlowLayout.setAdapter(this.jdField_a_of_type_Pur);
    localReadInJoyFlowLayout.setOnItemClickListener(new pup(this));
    localReadInJoyFlowLayout = (ReadInJoyFlowLayout)this.mContentView.findViewById(2131300871);
    this.jdField_a_of_type_Pus = new pus(getActivity(), 2131494476);
    this.jdField_a_of_type_Pus.registerDataSetObserver(this.jdField_b_of_type_AndroidDatabaseDataSetObserver);
    localReadInJoyFlowLayout.setAdapter(this.jdField_a_of_type_Pus);
    this.jdField_a_of_type_Pus.notifyDataSetChanged();
    localReadInJoyFlowLayout.setOnItemClickListener(new puq(this));
    this.jdField_a_of_type_Bbmy = bbmy.a(getActivity(), 2131652750, 0);
    this.jdField_b_of_type_Bbmy = bbmy.a(getActivity(), 2131652749, 0);
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
          this.jdField_a_of_type_Pur.addAll(localArrayList);
          localObject3 = localObject1;
        }
        this.jdField_a_of_type_Pur.notifyDataSetChanged();
        ohb.a().a(this.jdField_a_of_type_Ohe);
        if (localObject3 == null) {
          break label97;
        }
        ogy.a().b(((Long)localObject3).longValue());
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.d("ReadInJoyVideoTagSelectionFragment", 2, "handleIntent: fail to get topicId");
      }
      Object localObject2 = null;
      continue;
      label97:
      ogy.a().g(null);
      return;
      localObject3 = null;
    }
  }
  
  private void d()
  {
    this.vg.a(true);
    setRightButton(2131625463, this);
    this.rightViewText.setTextColor(-16265040);
    this.rightViewText.setBackgroundResource(0);
    setTitle(getString(2131652731));
    this.leftView.setText(2131624770);
    put.a(this);
  }
  
  private void e()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("EXTRA_SELECTION_REACH_MAXIMUM_NUMBER", this.jdField_a_of_type_Pur.a());
    abju.a(getActivity(), localIntent, PublicTransFragmentActivity.class, ReadInJoyVideoSearchTagFragment.class, 1000);
  }
  
  private void f()
  {
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    int j = this.jdField_a_of_type_Pur.getCount();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(this.jdField_a_of_type_Pur.getItem(i));
      i += 1;
    }
    localIntent.putParcelableArrayListExtra("EXTRA_SELECTED_TAG_LIST", localArrayList);
    getActivity().setResult(-1, localIntent);
    getActivity().finish();
    ndn.a(null, "", "0X80092F2", "0X80092F2", 0, 0, Integer.valueOf(localArrayList.size()).toString(), "", "", obz.e(), false);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    b();
  }
  
  public int getContentLayoutId()
  {
    return 2131494475;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1000) && (paramInt2 == -1))
    {
      paramIntent = (TagInfo)paramIntent.getParcelableExtra("SEARCH_TAG_RESULT");
      if ((paramIntent != null) && (!this.jdField_a_of_type_Pur.a(paramIntent)) && (!this.jdField_a_of_type_Bbmy.c())) {
        this.jdField_a_of_type_Bbmy.a();
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
    default: 
      return;
    case 2131311064: 
      this.c.setVisibility(8);
      e();
      return;
    }
    f();
  }
  
  public void onPause()
  {
    super.onPause();
    ohb.a().b(this.jdField_a_of_type_Ohe);
  }
  
  public void onResume()
  {
    super.onResume();
    d();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoTagSelectionFragment
 * JD-Core Version:    0.7.0.1
 */