package com.tencent.biz.pubaccount.readinjoy.ugc;

import abtu;
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
import bcpw;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFlowLayout;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import noo;
import onk;
import osj;
import osm;
import osp;
import qgk;
import qgl;
import qgm;
import qgn;
import qgo;
import qgp;
import qgq;
import qgr;

public class ReadInJoyVideoTagSelectionFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver = new qgk(this);
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bcpw jdField_a_of_type_Bcpw;
  private osp jdField_a_of_type_Osp = new qgm(this);
  private qgp jdField_a_of_type_Qgp;
  private qgq jdField_a_of_type_Qgq;
  private DataSetObserver jdField_b_of_type_AndroidDatabaseDataSetObserver = new qgl(this);
  private View jdField_b_of_type_AndroidViewView;
  private bcpw jdField_b_of_type_Bcpw;
  private View c;
  
  private void a()
  {
    this.c.setVisibility(0);
  }
  
  private void b()
  {
    this.c = this.mContentView.findViewById(2131376873);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131377218));
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131364717);
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131364714);
    ReadInJoyFlowLayout localReadInJoyFlowLayout = (ReadInJoyFlowLayout)this.mContentView.findViewById(2131366479);
    this.jdField_a_of_type_Qgp = new qgp(getActivity(), 2131560042);
    this.jdField_a_of_type_Qgp.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
    localReadInJoyFlowLayout.setAdapter(this.jdField_a_of_type_Qgp);
    localReadInJoyFlowLayout.setOnItemClickListener(new qgn(this));
    localReadInJoyFlowLayout = (ReadInJoyFlowLayout)this.mContentView.findViewById(2131366480);
    this.jdField_a_of_type_Qgq = new qgq(getActivity(), 2131560042);
    this.jdField_a_of_type_Qgq.registerDataSetObserver(this.jdField_b_of_type_AndroidDatabaseDataSetObserver);
    localReadInJoyFlowLayout.setAdapter(this.jdField_a_of_type_Qgq);
    this.jdField_a_of_type_Qgq.notifyDataSetChanged();
    localReadInJoyFlowLayout.setOnItemClickListener(new qgo(this));
    this.jdField_a_of_type_Bcpw = bcpw.a(getActivity(), 2131718575, 0);
    this.jdField_b_of_type_Bcpw = bcpw.a(getActivity(), 2131718574, 0);
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
          this.jdField_a_of_type_Qgp.addAll(localArrayList);
          localObject3 = localObject1;
        }
        this.jdField_a_of_type_Qgp.notifyDataSetChanged();
        osm.a().a(this.jdField_a_of_type_Osp);
        if (localObject3 == null) {
          break label97;
        }
        osj.a().b(((Long)localObject3).longValue());
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.d("ReadInJoyVideoTagSelectionFragment", 2, "handleIntent: fail to get topicId");
      }
      Object localObject2 = null;
      continue;
      label97:
      osj.a().g(null);
      return;
      localObject3 = null;
    }
  }
  
  private void d()
  {
    this.vg.a(true);
    setRightButton(2131691035, this);
    this.rightViewText.setTextColor(-16265040);
    this.rightViewText.setBackgroundResource(0);
    setTitle(getString(2131718555));
    this.leftView.setText(2131690331);
    qgr.a(this);
  }
  
  private void e()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("EXTRA_SELECTION_REACH_MAXIMUM_NUMBER", this.jdField_a_of_type_Qgp.a());
    abtu.a(getActivity(), localIntent, PublicTransFragmentActivity.class, ReadInJoyVideoSearchTagFragment.class, 1000);
  }
  
  private void f()
  {
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    int j = this.jdField_a_of_type_Qgp.getCount();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(this.jdField_a_of_type_Qgp.getItem(i));
      i += 1;
    }
    localIntent.putParcelableArrayListExtra("EXTRA_SELECTED_TAG_LIST", localArrayList);
    getActivity().setResult(-1, localIntent);
    getActivity().finish();
    noo.a(null, "", "0X80092F2", "0X80092F2", 0, 0, Integer.valueOf(localArrayList.size()).toString(), "", "", onk.e(), false);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    b();
  }
  
  public int getContentLayoutId()
  {
    return 2131560041;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1000) && (paramInt2 == -1))
    {
      paramIntent = (TagInfo)paramIntent.getParcelableExtra("SEARCH_TAG_RESULT");
      if ((paramIntent != null) && (!this.jdField_a_of_type_Qgp.a(paramIntent)) && (!this.jdField_a_of_type_Bcpw.c())) {
        this.jdField_a_of_type_Bcpw.a();
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
    case 2131376873: 
      this.c.setVisibility(8);
      e();
      return;
    }
    f();
  }
  
  public void onPause()
  {
    super.onPause();
    osm.a().b(this.jdField_a_of_type_Osp);
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