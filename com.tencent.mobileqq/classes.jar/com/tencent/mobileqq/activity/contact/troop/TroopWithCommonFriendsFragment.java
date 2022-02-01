package com.tencent.mobileqq.activity.contact.troop;

import ajdm;
import ajdw;
import ajdy;
import ajfk;
import ajfl;
import ajfq;
import ajhm;
import ajhn;
import ajho;
import ajhp;
import ajhq;
import ajhr;
import ajhs;
import ajht;
import ajhu;
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
import anvk;
import aofu;
import auzh;
import awzf;
import bdla;
import bisl;
import com.tencent.biz.qqstory.widget.OverScrollRecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
  private ajdm jdField_a_of_type_Ajdm;
  protected ajfl a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ajho(this);
  public View a;
  private aofu jdField_a_of_type_Aofu = new ajhs(this);
  private auzh jdField_a_of_type_Auzh = new ajhr(this);
  protected awzf a;
  private bisl jdField_a_of_type_Bisl;
  private OverScrollRecyclerView jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView;
  public BaseActivity a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public FaceDecoder a;
  public List<ajdy> a;
  public MqqHandler a;
  public int b;
  View.OnClickListener b = new ajhp(this);
  View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new ajhq(this);
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  public TroopWithCommonFriendsFragment()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Ajfl = new ajfl();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_MqqOsMqqHandler = new ajht(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_Ajdm = new ajhn(this, getActivity(), 2131559921);
    this.jdField_a_of_type_Ajdm.b(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_Ajdm.a(2131561542);
  }
  
  private void a(ajdw paramajdw, ajdy paramajdy, int paramInt)
  {
    ajfk localajfk = (ajfk)paramajdw;
    if ((paramajdy == null) || (paramajdy.jdField_a_of_type_JavaLangString.isEmpty()) || (paramajdy.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null)) {
      return;
    }
    localajfk.jdField_a_of_type_Long = paramInt;
    localajfk.jdField_a_of_type_JavaLangString = paramajdy.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopname;
    localajfk.jdField_a_of_type_Int = paramajdy.jdField_a_of_type_Int;
    localajfk.jdField_b_of_type_JavaLangString = paramajdy.jdField_a_of_type_JavaLangString;
    if (localajfk.jdField_a_of_type_JavaLangString.isEmpty()) {
      localajfk.jdField_a_of_type_JavaLangString = localajfk.jdField_b_of_type_JavaLangString;
    }
    paramInt = localajfk.jdField_a_of_type_Int;
    paramajdy = getString(2131699021);
    paramajdy = paramajdy + String.valueOf(paramInt) + getString(2131699020);
    String str1 = getString(2131699018);
    String str2 = getString(2131699019);
    if (ajhu.a(jdField_a_of_type_JavaLangString, localajfk.jdField_b_of_type_JavaLangString))
    {
      localajfk.jdField_a_of_type_AndroidWidgetButton.setText(str1);
      localajfk.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755352);
      localajfk.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839381);
      localajfk.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      localajfk.jdField_a_of_type_AndroidWidgetTextView.setText(localajfk.jdField_a_of_type_JavaLangString);
      localajfk.jdField_b_of_type_AndroidWidgetTextView.setText(paramajdy);
      localajfk.jdField_a_of_type_AndroidWidgetButton.setTag(paramajdw);
      localajfk.jdField_a_of_type_AndroidWidgetTextView.setTag(paramajdw);
      localajfk.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramajdw);
      localajfk.jdField_a_of_type_AndroidWidgetImageView.setTag(paramajdw);
      localajfk.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.b);
      localajfk.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      a(localajfk);
      return;
      localajfk.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      localajfk.jdField_a_of_type_AndroidWidgetButton.setText(str2);
      localajfk.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      localajfk.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755977);
    }
  }
  
  private void a(ajfk paramajfk)
  {
    if (paramajfk == null) {}
    do
    {
      return;
      localObject = paramajfk.jdField_b_of_type_JavaLangString;
    } while (localObject == null);
    Object localObject = ajfq.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, (String)localObject, 4);
    paramajfk.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    jdField_c_of_type_Int = paramInt;
    if (paramInt == 1) {
      bdla.b(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 1, 0, "0", "0", "", "");
    }
    for (;;)
    {
      bdla.b(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 0, 0, "0", "0", "", "");
      PublicFragmentActivity.a(paramContext, new Intent(), TroopWithCommonFriendsFragment.class);
      return;
      if (paramInt == 2) {
        bdla.b(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 2, 0, "0", "0", "", "");
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
        if ((localObject == null) || (!(localObject instanceof ajfk))) {}
        ajfk localajfk;
        do
        {
          i += 1;
          break;
          localajfk = (ajfk)localObject;
          localObject = ((ajfk)localObject).jdField_b_of_type_JavaLangString;
        } while ((localajfk == null) || (!paramString.equals(localObject)));
        localajfk.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      }
    }
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.jdField_a_of_type_Bisl = new bisl(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, a());
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)paramView.findViewById(2131364999));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.addOnScrollListener(new ajhm(this));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131559920, paramViewGroup, false);
    paramViewGroup = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368625);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Auzh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aofu);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Auzh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aofu);
    }
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131299080);
  }
  
  public String a(long paramLong)
  {
    Friends localFriends = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(String.valueOf(paramLong));
    if (localFriends != null) {
      return localFriends.getFriendNickWithAlias();
    }
    return String.valueOf(paramLong);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_Awzf = ((awzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    this.jdField_a_of_type_JavaUtilList = ajhu.a((ArrayList)ajhu.a(jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a(this.mContentView);
    a(paramViewGroup);
    a();
    b();
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_Ajdm);
    this.jdField_a_of_type_Ajdm.a(this.jdField_a_of_type_JavaUtilList);
    if (jdField_c_of_type_Int == 1)
    {
      this.jdField_a_of_type_Bisl.show();
      ajhu.a(Long.parseLong(jdField_a_of_type_JavaLangString), 2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131561558;
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
    String str1 = getString(2131699022);
    if (!jdField_a_of_type_JavaLangString.isEmpty())
    {
      str1 = a(Long.parseLong(jdField_a_of_type_JavaLangString));
      String str2 = getString(2131699024);
      String str3 = getString(2131699023);
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