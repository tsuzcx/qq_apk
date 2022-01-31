package com.tencent.mobileqq.app.addfriendverifi.ui;

import akka;
import akkd;
import akkf;
import akkg;
import akkh;
import akki;
import akkj;
import akkk;
import akkl;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import axqy;
import baxy;
import baxz;
import bfos;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.addfriendverifi.data.AddFriendBlockedInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class NewFriendVerifyBlockedListFragment
  extends IphoneTitleBarFragment
  implements baxz
{
  private akkd jdField_a_of_type_Akkd = new akkg(this);
  private akkk jdField_a_of_type_Akkk;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private baxy jdField_a_of_type_Baxy;
  private bfos jdField_a_of_type_Bfos = new akkh(this);
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private List<AddFriendBlockedInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  public MqqHandler a;
  
  public NewFriendVerifyBlockedListFragment()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new akkf(this);
  }
  
  private void a()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(getString(2131699219));
    localSpannableStringBuilder.setSpan(new akkj(this), 27, 31, 33);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#4D94FF")), 27, 31, 33);
    this.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
  }
  
  public static void a(Activity paramActivity)
  {
    PublicFragmentActivity.a(paramActivity, new Intent(), NewFriendVerifyBlockedListFragment.class);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Akkk != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(akka.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app).jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_Akkk.notifyDataSetChanged();
      if (this.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131699221));
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131365675);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)this.mContentView.findViewById(2131364544));
    this.jdField_a_of_type_ComTencentWidgetListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentWidgetListView.setOverscrollHeader(null);
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(this.jdField_a_of_type_Bfos);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131369276));
    this.jdField_a_of_type_Akkk = new akkk(this, null);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Akkk);
    a();
    setRightButton(2131690817, new akki(this));
    b();
  }
  
  public int getContentLayoutId()
  {
    return 2131561132;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.addObserver(this.jdField_a_of_type_Akkd);
    this.jdField_a_of_type_Baxy = new baxy(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
    this.jdField_a_of_type_Baxy.a(this);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof akkl)))
        {
          localObject = (akkl)localObject;
          if ((((akkl)localObject).jdField_a_of_type_ComTencentMobileqqAppAddfriendverifiDataAddFriendBlockedInfo != null) && (paramString.equals(((akkl)localObject).jdField_a_of_type_ComTencentMobileqqAppAddfriendverifiDataAddFriendBlockedInfo.a))) {
            ((akkl)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.removeObserver(this.jdField_a_of_type_Akkd);
    this.jdField_a_of_type_Baxy.a(null);
    this.jdField_a_of_type_Baxy.d();
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Akkk != null) {
      this.jdField_a_of_type_Akkk.b();
    }
    axqy.b(null, "dc00898", "", "", "0X800A3A6", "0X800A3A6", 0, 0, "", "", "", "");
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Akkk != null) {
      this.jdField_a_of_type_Akkk.a();
    }
    akka.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.addfriendverifi.ui.NewFriendVerifyBlockedListFragment
 * JD-Core Version:    0.7.0.1
 */