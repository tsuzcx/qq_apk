package com.tencent.mobileqq.activity.contact.troop;

import ahga;
import ahgk;
import ahjq;
import ahky;
import ahkz;
import ahla;
import ahmc;
import ahmd;
import ahme;
import ahmf;
import ahmg;
import ahmh;
import ahmi;
import ahmj;
import ahmk;
import aloz;
import amab;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ased;
import aubr;
import azmj;
import bcws;
import bcwt;
import bepp;
import com.tencent.biz.qqstory.widget.OverScrollRecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class TroopWithCommonFriendsFragment
  extends IphoneTitleBarFragment
  implements bcwt
{
  public static String a;
  static int jdField_c_of_type_Int;
  public int a;
  private ahga jdField_a_of_type_Ahga;
  protected ahkz a;
  private amab jdField_a_of_type_Amab = new ahmi(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ahme(this);
  public View a;
  private ased jdField_a_of_type_Ased = new ahmh(this);
  protected aubr a;
  public bcws a;
  private bepp jdField_a_of_type_Bepp;
  private OverScrollRecyclerView jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView;
  public BaseActivity a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public List<ahjq> a;
  public MqqHandler a;
  public int b;
  View.OnClickListener b = new ahmf(this);
  View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new ahmg(this);
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  public TroopWithCommonFriendsFragment()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Ahkz = new ahkz();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_MqqOsMqqHandler = new ahmj(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_Ahga = new ahmd(this, getActivity(), 2131559730);
    this.jdField_a_of_type_Ahga.a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_Ahga.a(2131561310);
  }
  
  private void a(ahgk paramahgk, ahjq paramahjq, int paramInt)
  {
    ahky localahky = (ahky)paramahgk;
    if ((paramahjq == null) || (paramahjq.jdField_a_of_type_JavaLangString.isEmpty()) || (paramahjq.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null)) {
      return;
    }
    localahky.jdField_a_of_type_Long = paramInt;
    localahky.jdField_a_of_type_JavaLangString = paramahjq.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname;
    localahky.jdField_a_of_type_Int = paramahjq.jdField_a_of_type_Int;
    localahky.jdField_b_of_type_JavaLangString = paramahjq.jdField_a_of_type_JavaLangString;
    if (localahky.jdField_a_of_type_JavaLangString.isEmpty()) {
      localahky.jdField_a_of_type_JavaLangString = localahky.jdField_b_of_type_JavaLangString;
    }
    paramInt = localahky.jdField_a_of_type_Int;
    paramahjq = getString(2131699961);
    paramahjq = paramahjq + String.valueOf(paramInt) + getString(2131699960);
    String str1 = getString(2131699958);
    String str2 = getString(2131699959);
    if (ahmk.a(jdField_a_of_type_JavaLangString, localahky.jdField_b_of_type_JavaLangString))
    {
      localahky.jdField_a_of_type_AndroidWidgetButton.setText(str1);
      localahky.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755344);
      localahky.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839141);
      localahky.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      localahky.jdField_a_of_type_AndroidWidgetTextView.setText(localahky.jdField_a_of_type_JavaLangString);
      localahky.jdField_b_of_type_AndroidWidgetTextView.setText(paramahjq);
      localahky.jdField_a_of_type_AndroidWidgetButton.setTag(paramahgk);
      localahky.jdField_a_of_type_AndroidWidgetTextView.setTag(paramahgk);
      localahky.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramahgk);
      localahky.jdField_a_of_type_AndroidWidgetImageView.setTag(paramahgk);
      localahky.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.b);
      localahky.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      a(localahky);
      return;
      localahky.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      localahky.jdField_a_of_type_AndroidWidgetButton.setText(str2);
      localahky.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      localahky.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755951);
    }
  }
  
  private void a(ahky paramahky)
  {
    if (paramahky == null) {}
    do
    {
      return;
      localObject = paramahky.jdField_b_of_type_JavaLangString;
    } while (localObject == null);
    Object localObject = ahla.a(this.jdField_a_of_type_Bcws, (String)localObject, 4);
    paramahky.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    jdField_c_of_type_Int = paramInt;
    if (paramInt == 1) {
      azmj.b(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 1, 0, "0", "0", "", "");
    }
    for (;;)
    {
      azmj.b(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 0, 0, "0", "0", "", "");
      PublicFragmentActivity.a(paramContext, new Intent(), TroopWithCommonFriendsFragment.class);
      return;
      if (paramInt == 2) {
        azmj.b(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 2, 0, "0", "0", "", "");
      }
    }
  }
  
  private void a(RecyclerView paramRecyclerView, String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      int j = paramRecyclerView.getChildCount();
      int i = 0;
      if (i < j)
      {
        Object localObject = paramRecyclerView.findViewHolderForAdapterPosition(i);
        if ((localObject == null) || (!(localObject instanceof ahky))) {}
        ahky localahky;
        do
        {
          i += 1;
          break;
          localahky = (ahky)localObject;
          localObject = ((ahky)localObject).jdField_b_of_type_JavaLangString;
        } while ((localahky == null) || (!paramString.equals(localObject)));
        localahky.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      }
    }
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.jdField_a_of_type_Bepp = new bepp(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, a());
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)paramView.findViewById(2131364618));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.addOnScrollListener(new ahmc(this));
    this.jdField_a_of_type_Bcws = new bcws(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Bcws.a(this);
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131559729, paramViewGroup, false);
    paramViewGroup = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368034);
    URLDrawable localURLDrawable = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20191206115411_QbbYvjs7gs.png", null);
    if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus())) {
      localURLDrawable.restartDownload();
    }
    paramViewGroup.setImageDrawable(localURLDrawable);
  }
  
  public static void a(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ased);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amab);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ased);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amab);
    }
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131298914);
  }
  
  public String a(long paramLong)
  {
    Friends localFriends = ((aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(String.valueOf(paramLong));
    if (localFriends != null) {
      return localFriends.getFriendNickWithAlias();
    }
    return String.valueOf(paramLong);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_Aubr = ((aubr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    this.jdField_a_of_type_JavaUtilList = ahmk.a((ArrayList)ahmk.a(jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a(this.mContentView);
    a(paramViewGroup);
    a();
    b();
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_Ahga);
    this.jdField_a_of_type_Ahga.a(this.jdField_a_of_type_JavaUtilList);
    if (jdField_c_of_type_Int == 1)
    {
      this.jdField_a_of_type_Bepp.show();
      ahmk.a(Long.parseLong(jdField_a_of_type_JavaLangString), 2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131561325;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface());
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    String str1 = getString(2131699962);
    if (!jdField_a_of_type_JavaLangString.isEmpty())
    {
      str1 = a(Long.parseLong(jdField_a_of_type_JavaLangString));
      String str2 = getString(2131699964);
      String str3 = getString(2131699963);
      str1 = str2 + str1 + str3;
    }
    setTitle(str1);
    return localView;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView, paramString, paramBitmap);
  }
  
  public void onDestroy()
  {
    c();
    super.onDestroy();
    if (this.jdField_a_of_type_Bcws != null) {
      this.jdField_a_of_type_Bcws.a(null);
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_Bcws.c();
    this.jdField_a_of_type_Bcws.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment
 * JD-Core Version:    0.7.0.1
 */