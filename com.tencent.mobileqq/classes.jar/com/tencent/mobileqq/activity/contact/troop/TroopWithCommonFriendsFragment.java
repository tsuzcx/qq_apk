package com.tencent.mobileqq.activity.contact.troop;

import aiin;
import aiix;
import aija;
import aikn;
import aiko;
import aiku;
import aimm;
import aimn;
import aimo;
import aimp;
import aimq;
import aimr;
import aims;
import aimt;
import aimu;
import amsw;
import andd;
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
import atuh;
import avtd;
import bcef;
import bhht;
import com.tencent.biz.qqstory.widget.OverScrollRecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class TroopWithCommonFriendsFragment
  extends IphoneTitleBarFragment
  implements FaceDecoder.DecodeTaskCompletionListener
{
  public static String a;
  static int jdField_c_of_type_Int;
  public int a;
  private aiin jdField_a_of_type_Aiin;
  protected aiko a;
  private andd jdField_a_of_type_Andd = new aims(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aimo(this);
  public View a;
  private atuh jdField_a_of_type_Atuh = new aimr(this);
  protected avtd a;
  private bhht jdField_a_of_type_Bhht;
  private OverScrollRecyclerView jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView;
  public BaseActivity a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public FaceDecoder a;
  public List<aija> a;
  public MqqHandler a;
  public int b;
  View.OnClickListener b = new aimp(this);
  View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new aimq(this);
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  public TroopWithCommonFriendsFragment()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Aiko = new aiko();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_MqqOsMqqHandler = new aimt(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_Aiin = new aimn(this, getActivity(), 2131559877);
    this.jdField_a_of_type_Aiin.b(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_Aiin.a(2131561480);
  }
  
  private void a(aiix paramaiix, aija paramaija, int paramInt)
  {
    aikn localaikn = (aikn)paramaiix;
    if ((paramaija == null) || (paramaija.jdField_a_of_type_JavaLangString.isEmpty()) || (paramaija.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null)) {
      return;
    }
    localaikn.jdField_a_of_type_Long = paramInt;
    localaikn.jdField_a_of_type_JavaLangString = paramaija.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopname;
    localaikn.jdField_a_of_type_Int = paramaija.jdField_a_of_type_Int;
    localaikn.jdField_b_of_type_JavaLangString = paramaija.jdField_a_of_type_JavaLangString;
    if (localaikn.jdField_a_of_type_JavaLangString.isEmpty()) {
      localaikn.jdField_a_of_type_JavaLangString = localaikn.jdField_b_of_type_JavaLangString;
    }
    paramInt = localaikn.jdField_a_of_type_Int;
    paramaija = getString(2131698706);
    paramaija = paramaija + String.valueOf(paramInt) + getString(2131698705);
    String str1 = getString(2131698703);
    String str2 = getString(2131698704);
    if (aimu.a(jdField_a_of_type_JavaLangString, localaikn.jdField_b_of_type_JavaLangString))
    {
      localaikn.jdField_a_of_type_AndroidWidgetButton.setText(str1);
      localaikn.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755352);
      localaikn.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839360);
      localaikn.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      localaikn.jdField_a_of_type_AndroidWidgetTextView.setText(localaikn.jdField_a_of_type_JavaLangString);
      localaikn.jdField_b_of_type_AndroidWidgetTextView.setText(paramaija);
      localaikn.jdField_a_of_type_AndroidWidgetButton.setTag(paramaiix);
      localaikn.jdField_a_of_type_AndroidWidgetTextView.setTag(paramaiix);
      localaikn.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramaiix);
      localaikn.jdField_a_of_type_AndroidWidgetImageView.setTag(paramaiix);
      localaikn.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.b);
      localaikn.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      a(localaikn);
      return;
      localaikn.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      localaikn.jdField_a_of_type_AndroidWidgetButton.setText(str2);
      localaikn.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      localaikn.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755973);
    }
  }
  
  private void a(aikn paramaikn)
  {
    if (paramaikn == null) {}
    do
    {
      return;
      localObject = paramaikn.jdField_b_of_type_JavaLangString;
    } while (localObject == null);
    Object localObject = aiku.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, (String)localObject, 4);
    paramaikn.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    jdField_c_of_type_Int = paramInt;
    if (paramInt == 1) {
      bcef.b(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 1, 0, "0", "0", "", "");
    }
    for (;;)
    {
      bcef.b(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 0, 0, "0", "0", "", "");
      PublicFragmentActivity.a(paramContext, new Intent(), TroopWithCommonFriendsFragment.class);
      return;
      if (paramInt == 2) {
        bcef.b(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 2, 0, "0", "0", "", "");
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
        if ((localObject == null) || (!(localObject instanceof aikn))) {}
        aikn localaikn;
        do
        {
          i += 1;
          break;
          localaikn = (aikn)localObject;
          localObject = ((aikn)localObject).jdField_b_of_type_JavaLangString;
        } while ((localaikn == null) || (!paramString.equals(localObject)));
        localaikn.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      }
    }
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.jdField_a_of_type_Bhht = new bhht(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, a());
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)paramView.findViewById(2131364911));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.addOnScrollListener(new aimm(this));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131559876, paramViewGroup, false);
    paramViewGroup = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368468);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Atuh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Andd);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Atuh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Andd);
    }
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131299076);
  }
  
  public String a(long paramLong)
  {
    Friends localFriends = ((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(String.valueOf(paramLong));
    if (localFriends != null) {
      return localFriends.getFriendNickWithAlias();
    }
    return String.valueOf(paramLong);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_Avtd = ((avtd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    this.jdField_a_of_type_JavaUtilList = aimu.a((ArrayList)aimu.a(jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a(this.mContentView);
    a(paramViewGroup);
    a();
    b();
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_Aiin);
    this.jdField_a_of_type_Aiin.a(this.jdField_a_of_type_JavaUtilList);
    if (jdField_c_of_type_Int == 1)
    {
      this.jdField_a_of_type_Bhht.show();
      aimu.a(Long.parseLong(jdField_a_of_type_JavaLangString), 2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131561496;
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
    String str1 = getString(2131698707);
    if (!jdField_a_of_type_JavaLangString.isEmpty())
    {
      str1 = a(Long.parseLong(jdField_a_of_type_JavaLangString));
      String str2 = getString(2131698709);
      String str3 = getString(2131698708);
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(null);
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
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.pause();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.cancelPendingRequests();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment
 * JD-Core Version:    0.7.0.1
 */