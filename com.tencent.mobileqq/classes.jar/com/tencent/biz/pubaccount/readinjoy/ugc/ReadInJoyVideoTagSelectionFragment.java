package com.tencent.biz.pubaccount.readinjoy.ugc;

import abtq;
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
import bcql;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFlowLayout;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import nol;
import onh;
import osg;
import osj;
import osm;
import qgh;
import qgi;
import qgj;
import qgk;
import qgl;
import qgm;
import qgn;
import qgo;

public class ReadInJoyVideoTagSelectionFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver = new qgh(this);
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bcql jdField_a_of_type_Bcql;
  private osm jdField_a_of_type_Osm = new qgj(this);
  private qgm jdField_a_of_type_Qgm;
  private qgn jdField_a_of_type_Qgn;
  private DataSetObserver jdField_b_of_type_AndroidDatabaseDataSetObserver = new qgi(this);
  private View jdField_b_of_type_AndroidViewView;
  private bcql jdField_b_of_type_Bcql;
  private View c;
  
  private void a()
  {
    this.c.setVisibility(0);
  }
  
  private void b()
  {
    this.c = this.mContentView.findViewById(2131376875);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131377220));
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131364716);
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131364713);
    ReadInJoyFlowLayout localReadInJoyFlowLayout = (ReadInJoyFlowLayout)this.mContentView.findViewById(2131366479);
    this.jdField_a_of_type_Qgm = new qgm(getActivity(), 2131560042);
    this.jdField_a_of_type_Qgm.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
    localReadInJoyFlowLayout.setAdapter(this.jdField_a_of_type_Qgm);
    localReadInJoyFlowLayout.setOnItemClickListener(new qgk(this));
    localReadInJoyFlowLayout = (ReadInJoyFlowLayout)this.mContentView.findViewById(2131366480);
    this.jdField_a_of_type_Qgn = new qgn(getActivity(), 2131560042);
    this.jdField_a_of_type_Qgn.registerDataSetObserver(this.jdField_b_of_type_AndroidDatabaseDataSetObserver);
    localReadInJoyFlowLayout.setAdapter(this.jdField_a_of_type_Qgn);
    this.jdField_a_of_type_Qgn.notifyDataSetChanged();
    localReadInJoyFlowLayout.setOnItemClickListener(new qgl(this));
    this.jdField_a_of_type_Bcql = bcql.a(getActivity(), 2131718586, 0);
    this.jdField_b_of_type_Bcql = bcql.a(getActivity(), 2131718585, 0);
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
          this.jdField_a_of_type_Qgm.addAll(localArrayList);
          localObject3 = localObject1;
        }
        this.jdField_a_of_type_Qgm.notifyDataSetChanged();
        osj.a().a(this.jdField_a_of_type_Osm);
        if (localObject3 == null) {
          break label97;
        }
        osg.a().b(((Long)localObject3).longValue());
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.d("ReadInJoyVideoTagSelectionFragment", 2, "handleIntent: fail to get topicId");
      }
      Object localObject2 = null;
      continue;
      label97:
      osg.a().g(null);
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
    setTitle(getString(2131718566));
    this.leftView.setText(2131690331);
    qgo.a(this);
  }
  
  private void e()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("EXTRA_SELECTION_REACH_MAXIMUM_NUMBER", this.jdField_a_of_type_Qgm.a());
    abtq.a(getActivity(), localIntent, PublicTransFragmentActivity.class, ReadInJoyVideoSearchTagFragment.class, 1000);
  }
  
  private void f()
  {
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    int j = this.jdField_a_of_type_Qgm.getCount();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(this.jdField_a_of_type_Qgm.getItem(i));
      i += 1;
    }
    localIntent.putParcelableArrayListExtra("EXTRA_SELECTED_TAG_LIST", localArrayList);
    getActivity().setResult(-1, localIntent);
    getActivity().finish();
    nol.a(null, "", "0X80092F2", "0X80092F2", 0, 0, Integer.valueOf(localArrayList.size()).toString(), "", "", onh.e(), false);
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
      if ((paramIntent != null) && (!this.jdField_a_of_type_Qgm.a(paramIntent)) && (!this.jdField_a_of_type_Bcql.c())) {
        this.jdField_a_of_type_Bcql.a();
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
    case 2131376875: 
      this.c.setVisibility(8);
      e();
      return;
    }
    f();
  }
  
  public void onPause()
  {
    super.onPause();
    osj.a().b(this.jdField_a_of_type_Osm);
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