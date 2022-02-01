package com.tencent.mobileqq.activity.contact.recommendtroop;

import adxr;
import aihv;
import aihw;
import aiii;
import aiij;
import aiik;
import aiil;
import aiim;
import aiin;
import aiix;
import amsw;
import anca;
import andd;
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
import bcef;
import com.tencent.biz.qqstory.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class TroopRecommendFriendFragment
  extends IphoneTitleBarFragment
{
  private int jdField_a_of_type_Int = 0;
  private aiin<aihw> jdField_a_of_type_Aiin;
  private anca jdField_a_of_type_Anca;
  private final andd jdField_a_of_type_Andd = new aiim(this);
  private View jdField_a_of_type_AndroidViewView;
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
    amsw localamsw = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localamsw.b(paramString)) {
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692461);
    }
    if (localamsw.a(paramString, false)) {
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698715);
    }
    return null;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Aiin = new aiij(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131559932);
    this.jdField_a_of_type_Aiin.a(2131561480);
    this.jdField_a_of_type_Aiin.a(new aiik(this));
  }
  
  private void a(aiix paramaiix, aihw paramaihw, int paramInt)
  {
    if ((paramaiix == null) || (paramaihw == null)) {}
    Object localObject;
    do
    {
      return;
      ((aihv)paramaiix).a = paramaihw;
      localObject = (ImageView)paramaiix.a(2131361795);
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramaihw.jdField_a_of_type_JavaLangString));
      }
      localObject = (TextView)paramaiix.a(2131371791);
      if (localObject != null) {
        ((TextView)localObject).setText(paramaihw.jdField_b_of_type_JavaLangString);
      }
      localObject = (TextView)paramaiix.a(2131370634);
      if (localObject != null) {
        ((TextView)localObject).setText(paramaihw.c);
      }
      localObject = (TroopLabelLayout)paramaiix.a(2131379217);
      if (localObject != null) {
        ((TroopLabelLayout)localObject).a(paramaihw.jdField_a_of_type_JavaUtilArrayList, paramaihw.jdField_a_of_type_Int, paramaihw.jdField_b_of_type_Int, 1);
      }
      localObject = (Button)paramaiix.a(2131376341);
      paramaiix = (TextView)paramaiix.a(2131376351);
    } while ((localObject == null) || (paramaiix == null));
    String str = a(paramaihw.jdField_a_of_type_JavaLangString);
    if (TextUtils.isEmpty(str))
    {
      paramaiix.setVisibility(8);
      ((Button)localObject).setVisibility(0);
      ((Button)localObject).setText(2131689550);
      ((Button)localObject).setOnClickListener(new aiil(this, paramaihw));
      return;
    }
    paramaiix.setVisibility(0);
    paramaiix.setText(str);
    ((Button)localObject).setVisibility(8);
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    adxr.a(paramContext, paramIntent, PublicFragmentActivity.class, TroopRecommendFriendFragment.class);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131376081);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)paramView.findViewById(2131379293));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.addOnScrollListener(new aiii(this));
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopRecommendFriendFragment", 2, "addFriend troopUin = " + paramString1 + ", memberUin =" + paramString2 + ", troopCode =" + paramString3);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    String str = ContactUtils.getTroopMemberName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
    int i = this.jdField_b_of_type_Int;
    paramString2 = AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, paramString2, paramString3, 3004, i, str, null, null, null, null);
    paramString2.putExtra("need_result_uin", true);
    paramString2.putExtra("troop_uin", paramString1);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(paramString2, 11);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_Aiin);
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694064), 0).a();
      return;
    }
    c();
  }
  
  private void c()
  {
    anca localanca;
    String str;
    int i;
    byte[] arrayOfByte;
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      localanca = this.jdField_a_of_type_Anca;
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
      localanca.a(str, 2, i, arrayOfByte, 50, localArrayList);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Andd);
    a(this.mContentView);
    a();
    b();
  }
  
  public int getContentLayoutId()
  {
    return 2131559904;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface());
    this.jdField_a_of_type_Anca = ((anca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20));
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
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD50", "0X800AD50", 0, 0, "", "", "", "");
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131689570));
    return localView;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Andd);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    super.onDestroy();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Aiin != null) {
      this.jdField_a_of_type_Aiin.notifyDataSetChanged();
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