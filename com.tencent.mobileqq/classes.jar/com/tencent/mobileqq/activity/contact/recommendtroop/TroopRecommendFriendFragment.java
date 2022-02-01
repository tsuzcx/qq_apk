package com.tencent.mobileqq.activity.contact.recommendtroop;

import afez;
import ajnm;
import ajnn;
import ajnz;
import ajoa;
import ajob;
import ajoc;
import ajod;
import ajoe;
import ajoo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import anyw;
import aoip;
import aojs;
import aoot;
import bdll;
import bhlg;
import bhnv;
import com.tencent.biz.qqstory.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class TroopRecommendFriendFragment
  extends IphoneTitleBarFragment
{
  private int jdField_a_of_type_Int = 0;
  private ajoe<ajnn> jdField_a_of_type_Ajoe;
  private View jdField_a_of_type_AndroidViewView;
  private aoip jdField_a_of_type_Aoip;
  private final aojs jdField_a_of_type_Aojs = new ajod(this);
  private OverScrollRecyclerView jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int b;
  private int c;
  
  private String a(String paramString)
  {
    anyw localanyw = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localanyw.b(paramString)) {
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692413);
    }
    if (localanyw.a(paramString, false)) {
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698507);
    }
    return null;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Ajoe = new ajoa(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131559928);
    this.jdField_a_of_type_Ajoe.a(2131561602);
    this.jdField_a_of_type_Ajoe.a(new ajob(this));
  }
  
  private void a(ajoo paramajoo, ajnn paramajnn, int paramInt)
  {
    if ((paramajoo == null) || (paramajnn == null)) {}
    Object localObject;
    do
    {
      return;
      ((ajnm)paramajoo).a = paramajnn;
      localObject = (ImageView)paramajoo.a(2131361795);
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(aoot.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramajnn.jdField_a_of_type_JavaLangString));
      }
      localObject = (TextView)paramajoo.a(2131371827);
      if (localObject != null) {
        ((TextView)localObject).setText(paramajnn.jdField_b_of_type_JavaLangString);
      }
      localObject = (TextView)paramajoo.a(2131370666);
      if (localObject != null) {
        ((TextView)localObject).setText(paramajnn.c);
      }
      localObject = (TroopLabelLayout)paramajoo.a(2131379447);
      if (localObject != null) {
        ((TroopLabelLayout)localObject).a(paramajnn.jdField_a_of_type_JavaUtilArrayList, paramajnn.jdField_a_of_type_Int, paramajnn.jdField_b_of_type_Int, 1);
      }
      localObject = (Button)paramajoo.a(2131376575);
      paramajoo = (TextView)paramajoo.a(2131376585);
    } while ((localObject == null) || (paramajoo == null));
    String str = a(paramajnn.jdField_a_of_type_JavaLangString);
    if (TextUtils.isEmpty(str))
    {
      paramajoo.setVisibility(8);
      ((Button)localObject).setVisibility(0);
      ((Button)localObject).setText(2131689551);
      ((Button)localObject).setOnClickListener(new ajoc(this, paramajnn));
      return;
    }
    paramajoo.setVisibility(0);
    paramajoo.setText(str);
    ((Button)localObject).setVisibility(8);
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    afez.a(paramContext, paramIntent, PublicFragmentActivity.class, TroopRecommendFriendFragment.class);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131376315);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)paramView.findViewById(2131379512));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.addOnScrollListener(new ajnz(this));
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopRecommendFriendFragment", 2, "addFriend troopUin = " + paramString1 + ", memberUin =" + paramString2 + ", troopCode =" + paramString3);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    String str = bhlg.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
    int i = this.jdField_b_of_type_Int;
    paramString2 = AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, paramString2, paramString3, 3004, i, str, null, null, null, null);
    paramString2.putExtra("need_result_uin", true);
    paramString2.putExtra("troop_uin", paramString1);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(paramString2, 11);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_Ajoe);
    if (!bhnv.d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693965), 0).a();
      return;
    }
    c();
  }
  
  private void c()
  {
    aoip localaoip;
    String str;
    int i;
    byte[] arrayOfByte;
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      localaoip = this.jdField_a_of_type_Aoip;
      str = this.jdField_a_of_type_JavaLangString;
      i = this.c;
      arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        break label55;
      }
    }
    label55:
    for (ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;; localArrayList = null)
    {
      localaoip.a(str, 2, i, arrayOfByte, 50, localArrayList);
      return;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ArrayOfByte != null) {
      c();
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aojs);
    a(this.mContentView);
    a();
    b();
  }
  
  public int getContentLayoutId()
  {
    return 2131559902;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface());
    this.jdField_a_of_type_Aoip = ((aoip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20));
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("troopUin");
    this.c = paramBundle.getIntExtra("grayType", 0);
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("grayTypeSubId", 0);
    paramBundle = paramBundle.getSerializableExtra("grayUinList");
    if ((paramBundle instanceof ArrayList)) {
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)paramBundle);
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopRecommendFriendFragment", 2, "onCreate mSubId " + this.jdField_b_of_type_Int + " mTroopUin =" + this.jdField_a_of_type_JavaLangString + " mGrayTipType =" + this.c);
    }
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD50", "0X800AD50", 0, 0, "", "", "", "");
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131689571));
    return localView;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aojs);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    super.onDestroy();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Ajoe != null) {
      this.jdField_a_of_type_Ajoe.notifyDataSetChanged();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.recommendtroop.TroopRecommendFriendFragment
 * JD-Core Version:    0.7.0.1
 */