package com.tencent.mobileqq.activity.contact.troop;

import ajoe;
import ajoo;
import ajoq;
import ajpx;
import ajpy;
import ajpz;
import ajrp;
import ajrq;
import ajrr;
import ajrs;
import ajrt;
import ajru;
import ajrv;
import ajrw;
import ajrx;
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
import anyw;
import aojs;
import aoof;
import aoog;
import avhb;
import axfw;
import bdll;
import bjbs;
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
  implements aoog
{
  public static String a;
  static int jdField_c_of_type_Int;
  public int a;
  private ajoe jdField_a_of_type_Ajoe;
  protected ajpy a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ajrr(this);
  public View a;
  private aojs jdField_a_of_type_Aojs = new ajrv(this);
  public aoof a;
  private avhb jdField_a_of_type_Avhb = new ajru(this);
  protected axfw a;
  private bjbs jdField_a_of_type_Bjbs;
  private OverScrollRecyclerView jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView;
  public BaseActivity a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public List<ajoq> a;
  public MqqHandler a;
  public int b;
  View.OnClickListener b = new ajrs(this);
  View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new ajrt(this);
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  public TroopWithCommonFriendsFragment()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Ajpy = new ajpy();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_MqqOsMqqHandler = new ajrw(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_Ajoe = new ajrq(this, getActivity(), 2131559875);
    this.jdField_a_of_type_Ajoe.a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_Ajoe.a(2131561602);
  }
  
  private void a(ajoo paramajoo, ajoq paramajoq, int paramInt)
  {
    ajpx localajpx = (ajpx)paramajoo;
    if ((paramajoq == null) || (paramajoq.jdField_a_of_type_JavaLangString.isEmpty()) || (paramajoq.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null)) {
      return;
    }
    localajpx.jdField_a_of_type_Long = paramInt;
    localajpx.jdField_a_of_type_JavaLangString = paramajoq.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname;
    localajpx.jdField_a_of_type_Int = paramajoq.jdField_a_of_type_Int;
    localajpx.jdField_b_of_type_JavaLangString = paramajoq.jdField_a_of_type_JavaLangString;
    if (localajpx.jdField_a_of_type_JavaLangString.isEmpty()) {
      localajpx.jdField_a_of_type_JavaLangString = localajpx.jdField_b_of_type_JavaLangString;
    }
    paramInt = localajpx.jdField_a_of_type_Int;
    paramajoq = getString(2131698498);
    paramajoq = paramajoq + String.valueOf(paramInt) + getString(2131698497);
    String str1 = getString(2131698495);
    String str2 = getString(2131698496);
    if (ajrx.a(jdField_a_of_type_JavaLangString, localajpx.jdField_b_of_type_JavaLangString))
    {
      localajpx.jdField_a_of_type_AndroidWidgetButton.setText(str1);
      localajpx.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755351);
      localajpx.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839325);
      localajpx.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      localajpx.jdField_a_of_type_AndroidWidgetTextView.setText(localajpx.jdField_a_of_type_JavaLangString);
      localajpx.jdField_b_of_type_AndroidWidgetTextView.setText(paramajoq);
      localajpx.jdField_a_of_type_AndroidWidgetButton.setTag(paramajoo);
      localajpx.jdField_a_of_type_AndroidWidgetTextView.setTag(paramajoo);
      localajpx.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramajoo);
      localajpx.jdField_a_of_type_AndroidWidgetImageView.setTag(paramajoo);
      localajpx.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.b);
      localajpx.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      a(localajpx);
      return;
      localajpx.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      localajpx.jdField_a_of_type_AndroidWidgetButton.setText(str2);
      localajpx.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      localajpx.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755972);
    }
  }
  
  private void a(ajpx paramajpx)
  {
    if (paramajpx == null) {}
    do
    {
      return;
      localObject = paramajpx.jdField_b_of_type_JavaLangString;
    } while (localObject == null);
    Object localObject = ajpz.a(this.jdField_a_of_type_Aoof, (String)localObject, 4);
    paramajpx.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    jdField_c_of_type_Int = paramInt;
    if (paramInt == 1) {
      bdll.b(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 1, 0, "0", "0", "", "");
    }
    for (;;)
    {
      bdll.b(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 0, 0, "0", "0", "", "");
      PublicFragmentActivity.a(paramContext, new Intent(), TroopWithCommonFriendsFragment.class);
      return;
      if (paramInt == 2) {
        bdll.b(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 2, 0, "0", "0", "", "");
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
        if ((localObject == null) || (!(localObject instanceof ajpx))) {}
        ajpx localajpx;
        do
        {
          i += 1;
          break;
          localajpx = (ajpx)localObject;
          localObject = ((ajpx)localObject).jdField_b_of_type_JavaLangString;
        } while ((localajpx == null) || (!paramString.equals(localObject)));
        localajpx.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      }
    }
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.jdField_a_of_type_Bjbs = new bjbs(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, a());
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)paramView.findViewById(2131364884));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.addOnScrollListener(new ajrp(this));
    this.jdField_a_of_type_Aoof = new aoof(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Aoof.a(this);
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131559874, paramViewGroup, false);
    paramViewGroup = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368443);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Avhb);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aojs);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Avhb);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aojs);
    }
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131299011);
  }
  
  public String a(long paramLong)
  {
    Friends localFriends = ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(String.valueOf(paramLong));
    if (localFriends != null) {
      return localFriends.getFriendNickWithAlias();
    }
    return String.valueOf(paramLong);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_Axfw = ((axfw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    this.jdField_a_of_type_JavaUtilList = ajrx.a((ArrayList)ajrx.a(jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a(this.mContentView);
    a(paramViewGroup);
    a();
    b();
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_Ajoe);
    this.jdField_a_of_type_Ajoe.a(this.jdField_a_of_type_JavaUtilList);
    if (jdField_c_of_type_Int == 1)
    {
      this.jdField_a_of_type_Bjbs.show();
      ajrx.a(Long.parseLong(jdField_a_of_type_JavaLangString), 2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131561617;
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
    String str1 = getString(2131698499);
    if (!jdField_a_of_type_JavaLangString.isEmpty())
    {
      str1 = a(Long.parseLong(jdField_a_of_type_JavaLangString));
      String str2 = getString(2131698501);
      String str3 = getString(2131698500);
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
    if (this.jdField_a_of_type_Aoof != null) {
      this.jdField_a_of_type_Aoof.a(null);
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
    this.jdField_a_of_type_Aoof.c();
    this.jdField_a_of_type_Aoof.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment
 * JD-Core Version:    0.7.0.1
 */