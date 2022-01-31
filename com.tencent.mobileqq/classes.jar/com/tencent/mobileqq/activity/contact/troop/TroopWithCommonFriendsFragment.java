package com.tencent.mobileqq.activity.contact.troop;

import ahkp;
import ahkz;
import ahof;
import ahpn;
import ahpo;
import ahpp;
import ahqr;
import ahqs;
import ahqt;
import ahqu;
import ahqv;
import ahqw;
import ahqx;
import ahqy;
import ahqz;
import alto;
import ameq;
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
import asim;
import auga;
import azqs;
import bdbb;
import bdbc;
import bety;
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
  implements bdbc
{
  public static String a;
  static int jdField_c_of_type_Int;
  public int a;
  private ahkp jdField_a_of_type_Ahkp;
  protected ahpo a;
  private ameq jdField_a_of_type_Ameq = new ahqx(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ahqt(this);
  public View a;
  private asim jdField_a_of_type_Asim = new ahqw(this);
  protected auga a;
  public bdbb a;
  private bety jdField_a_of_type_Bety;
  private OverScrollRecyclerView jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView;
  public BaseActivity a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public List<ahof> a;
  public MqqHandler a;
  public int b;
  View.OnClickListener b = new ahqu(this);
  View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new ahqv(this);
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  public TroopWithCommonFriendsFragment()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Ahpo = new ahpo();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_MqqOsMqqHandler = new ahqy(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_Ahkp = new ahqs(this, getActivity(), 2131559729);
    this.jdField_a_of_type_Ahkp.a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_Ahkp.a(2131561328);
  }
  
  private void a(ahkz paramahkz, ahof paramahof, int paramInt)
  {
    ahpn localahpn = (ahpn)paramahkz;
    if ((paramahof == null) || (paramahof.jdField_a_of_type_JavaLangString.isEmpty()) || (paramahof.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null)) {
      return;
    }
    localahpn.jdField_a_of_type_Long = paramInt;
    localahpn.jdField_a_of_type_JavaLangString = paramahof.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname;
    localahpn.jdField_a_of_type_Int = paramahof.jdField_a_of_type_Int;
    localahpn.jdField_b_of_type_JavaLangString = paramahof.jdField_a_of_type_JavaLangString;
    if (localahpn.jdField_a_of_type_JavaLangString.isEmpty()) {
      localahpn.jdField_a_of_type_JavaLangString = localahpn.jdField_b_of_type_JavaLangString;
    }
    paramInt = localahpn.jdField_a_of_type_Int;
    paramahof = getString(2131699973);
    paramahof = paramahof + String.valueOf(paramInt) + getString(2131699972);
    String str1 = getString(2131699970);
    String str2 = getString(2131699971);
    if (ahqz.a(jdField_a_of_type_JavaLangString, localahpn.jdField_b_of_type_JavaLangString))
    {
      localahpn.jdField_a_of_type_AndroidWidgetButton.setText(str1);
      localahpn.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755344);
      localahpn.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839142);
      localahpn.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      localahpn.jdField_a_of_type_AndroidWidgetTextView.setText(localahpn.jdField_a_of_type_JavaLangString);
      localahpn.jdField_b_of_type_AndroidWidgetTextView.setText(paramahof);
      localahpn.jdField_a_of_type_AndroidWidgetButton.setTag(paramahkz);
      localahpn.jdField_a_of_type_AndroidWidgetTextView.setTag(paramahkz);
      localahpn.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramahkz);
      localahpn.jdField_a_of_type_AndroidWidgetImageView.setTag(paramahkz);
      localahpn.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.b);
      localahpn.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      a(localahpn);
      return;
      localahpn.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      localahpn.jdField_a_of_type_AndroidWidgetButton.setText(str2);
      localahpn.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      localahpn.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755951);
    }
  }
  
  private void a(ahpn paramahpn)
  {
    if (paramahpn == null) {}
    do
    {
      return;
      localObject = paramahpn.jdField_b_of_type_JavaLangString;
    } while (localObject == null);
    Object localObject = ahpp.a(this.jdField_a_of_type_Bdbb, (String)localObject, 4);
    paramahpn.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    jdField_c_of_type_Int = paramInt;
    if (paramInt == 1) {
      azqs.b(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 1, 0, "0", "0", "", "");
    }
    for (;;)
    {
      azqs.b(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 0, 0, "0", "0", "", "");
      PublicFragmentActivity.a(paramContext, new Intent(), TroopWithCommonFriendsFragment.class);
      return;
      if (paramInt == 2) {
        azqs.b(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 2, 0, "0", "0", "", "");
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
        if ((localObject == null) || (!(localObject instanceof ahpn))) {}
        ahpn localahpn;
        do
        {
          i += 1;
          break;
          localahpn = (ahpn)localObject;
          localObject = ((ahpn)localObject).jdField_b_of_type_JavaLangString;
        } while ((localahpn == null) || (!paramString.equals(localObject)));
        localahpn.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      }
    }
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.jdField_a_of_type_Bety = new bety(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, a());
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)paramView.findViewById(2131364620));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.addOnScrollListener(new ahqr(this));
    this.jdField_a_of_type_Bdbb = new bdbb(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Bdbb.a(this);
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131559728, paramViewGroup, false);
    paramViewGroup = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368045);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Asim);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ameq);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Asim);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ameq);
    }
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131298914);
  }
  
  public String a(long paramLong)
  {
    Friends localFriends = ((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(String.valueOf(paramLong));
    if (localFriends != null) {
      return localFriends.getFriendNickWithAlias();
    }
    return String.valueOf(paramLong);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_Auga = ((auga)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    this.jdField_a_of_type_JavaUtilList = ahqz.a((ArrayList)ahqz.a(jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a(this.mContentView);
    a(paramViewGroup);
    a();
    b();
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_Ahkp);
    this.jdField_a_of_type_Ahkp.a(this.jdField_a_of_type_JavaUtilList);
    if (jdField_c_of_type_Int == 1)
    {
      this.jdField_a_of_type_Bety.show();
      ahqz.a(Long.parseLong(jdField_a_of_type_JavaLangString), 2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131561343;
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
    String str1 = getString(2131699974);
    if (!jdField_a_of_type_JavaLangString.isEmpty())
    {
      str1 = a(Long.parseLong(jdField_a_of_type_JavaLangString));
      String str2 = getString(2131699976);
      String str3 = getString(2131699975);
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
    if (this.jdField_a_of_type_Bdbb != null) {
      this.jdField_a_of_type_Bdbb.a(null);
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
    this.jdField_a_of_type_Bdbb.c();
    this.jdField_a_of_type_Bdbb.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment
 * JD-Core Version:    0.7.0.1
 */