package com.tencent.mobileqq.activity.contact.troop;

import ajcv;
import ajdf;
import ajdh;
import ajeo;
import ajep;
import ajeq;
import ajgg;
import ajgh;
import ajgi;
import ajgj;
import ajgk;
import ajgl;
import ajgm;
import ajgn;
import ajgo;
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
import anmw;
import anxg;
import aobu;
import aobv;
import aupb;
import awne;
import bcst;
import biau;
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
  implements aobv
{
  public static String a;
  static int jdField_c_of_type_Int;
  public int a;
  private ajcv jdField_a_of_type_Ajcv;
  protected ajep a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ajgi(this);
  public View a;
  private anxg jdField_a_of_type_Anxg = new ajgm(this);
  public aobu a;
  private aupb jdField_a_of_type_Aupb = new ajgl(this);
  protected awne a;
  private biau jdField_a_of_type_Biau;
  private OverScrollRecyclerView jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView;
  public BaseActivity a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public List<ajdh> a;
  public MqqHandler a;
  public int b;
  View.OnClickListener b = new ajgj(this);
  View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new ajgk(this);
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  public TroopWithCommonFriendsFragment()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Ajep = new ajep();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_MqqOsMqqHandler = new ajgn(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_Ajcv = new ajgh(this, getActivity(), 2131559869);
    this.jdField_a_of_type_Ajcv.a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_Ajcv.a(2131561561);
  }
  
  private void a(ajdf paramajdf, ajdh paramajdh, int paramInt)
  {
    ajeo localajeo = (ajeo)paramajdf;
    if ((paramajdh == null) || (paramajdh.jdField_a_of_type_JavaLangString.isEmpty()) || (paramajdh.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null)) {
      return;
    }
    localajeo.jdField_a_of_type_Long = paramInt;
    localajeo.jdField_a_of_type_JavaLangString = paramajdh.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname;
    localajeo.jdField_a_of_type_Int = paramajdh.jdField_a_of_type_Int;
    localajeo.jdField_b_of_type_JavaLangString = paramajdh.jdField_a_of_type_JavaLangString;
    if (localajeo.jdField_a_of_type_JavaLangString.isEmpty()) {
      localajeo.jdField_a_of_type_JavaLangString = localajeo.jdField_b_of_type_JavaLangString;
    }
    paramInt = localajeo.jdField_a_of_type_Int;
    paramajdh = getString(2131698396);
    paramajdh = paramajdh + String.valueOf(paramInt) + getString(2131698395);
    String str1 = getString(2131698393);
    String str2 = getString(2131698394);
    if (ajgo.a(jdField_a_of_type_JavaLangString, localajeo.jdField_b_of_type_JavaLangString))
    {
      localajeo.jdField_a_of_type_AndroidWidgetButton.setText(str1);
      localajeo.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755350);
      localajeo.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839317);
      localajeo.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      localajeo.jdField_a_of_type_AndroidWidgetTextView.setText(localajeo.jdField_a_of_type_JavaLangString);
      localajeo.jdField_b_of_type_AndroidWidgetTextView.setText(paramajdh);
      localajeo.jdField_a_of_type_AndroidWidgetButton.setTag(paramajdf);
      localajeo.jdField_a_of_type_AndroidWidgetTextView.setTag(paramajdf);
      localajeo.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramajdf);
      localajeo.jdField_a_of_type_AndroidWidgetImageView.setTag(paramajdf);
      localajeo.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.b);
      localajeo.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      a(localajeo);
      return;
      localajeo.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      localajeo.jdField_a_of_type_AndroidWidgetButton.setText(str2);
      localajeo.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      localajeo.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755971);
    }
  }
  
  private void a(ajeo paramajeo)
  {
    if (paramajeo == null) {}
    do
    {
      return;
      localObject = paramajeo.jdField_b_of_type_JavaLangString;
    } while (localObject == null);
    Object localObject = ajeq.a(this.jdField_a_of_type_Aobu, (String)localObject, 4);
    paramajeo.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    jdField_c_of_type_Int = paramInt;
    if (paramInt == 1) {
      bcst.b(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 1, 0, "0", "0", "", "");
    }
    for (;;)
    {
      bcst.b(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 0, 0, "0", "0", "", "");
      PublicFragmentActivity.a(paramContext, new Intent(), TroopWithCommonFriendsFragment.class);
      return;
      if (paramInt == 2) {
        bcst.b(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 2, 0, "0", "0", "", "");
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
        if ((localObject == null) || (!(localObject instanceof ajeo))) {}
        ajeo localajeo;
        do
        {
          i += 1;
          break;
          localajeo = (ajeo)localObject;
          localObject = ((ajeo)localObject).jdField_b_of_type_JavaLangString;
        } while ((localajeo == null) || (!paramString.equals(localObject)));
        localajeo.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      }
    }
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.jdField_a_of_type_Biau = new biau(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, a());
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)paramView.findViewById(2131364837));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.addOnScrollListener(new ajgg(this));
    this.jdField_a_of_type_Aobu = new aobu(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Aobu.a(this);
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131559868, paramViewGroup, false);
    paramViewGroup = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368370);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aupb);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anxg);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aupb);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anxg);
    }
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131298998);
  }
  
  public String a(long paramLong)
  {
    Friends localFriends = ((anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(String.valueOf(paramLong));
    if (localFriends != null) {
      return localFriends.getFriendNickWithAlias();
    }
    return String.valueOf(paramLong);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_Awne = ((awne)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    this.jdField_a_of_type_JavaUtilList = ajgo.a((ArrayList)ajgo.a(jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a(this.mContentView);
    a(paramViewGroup);
    a();
    b();
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_Ajcv);
    this.jdField_a_of_type_Ajcv.a(this.jdField_a_of_type_JavaUtilList);
    if (jdField_c_of_type_Int == 1)
    {
      this.jdField_a_of_type_Biau.show();
      ajgo.a(Long.parseLong(jdField_a_of_type_JavaLangString), 2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131561576;
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
    String str1 = getString(2131698397);
    if (!jdField_a_of_type_JavaLangString.isEmpty())
    {
      str1 = a(Long.parseLong(jdField_a_of_type_JavaLangString));
      String str2 = getString(2131698399);
      String str3 = getString(2131698398);
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
    if (this.jdField_a_of_type_Aobu != null) {
      this.jdField_a_of_type_Aobu.a(null);
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
    this.jdField_a_of_type_Aobu.c();
    this.jdField_a_of_type_Aobu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment
 * JD-Core Version:    0.7.0.1
 */