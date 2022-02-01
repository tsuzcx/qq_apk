package com.tencent.mobileqq.activity.contact.addfriendverifi;

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
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class NewFriendVerifyBlockedListFragment
  extends IphoneTitleBarFragment
  implements DecodeTaskCompletionListener
{
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private NewFriendVerificationObserver jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiNewFriendVerificationObserver = new NewFriendVerifyBlockedListFragment.2(this);
  private NewFriendVerifyBlockedListFragment.CommonAdapter jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiNewFriendVerifyBlockedListFragment$CommonAdapter;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new NewFriendVerifyBlockedListFragment.3(this);
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private List<AddFriendBlockedInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new NewFriendVerifyBlockedListFragment.1(this);
  
  private void a()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(getString(2131698979));
    localSpannableStringBuilder.setSpan(new NewFriendVerifyBlockedListFragment.5(this), 27, 31, 33);
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiNewFriendVerifyBlockedListFragment$CommonAdapter != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(NewFriendVerificationManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app).jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiNewFriendVerifyBlockedListFragment$CommonAdapter.notifyDataSetChanged();
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
    setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698981));
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131366350);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)this.mContentView.findViewById(2131365135));
    this.jdField_a_of_type_ComTencentWidgetListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentWidgetListView.setOverscrollHeader(null);
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131370462));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiNewFriendVerifyBlockedListFragment$CommonAdapter = new NewFriendVerifyBlockedListFragment.CommonAdapter(this, null);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiNewFriendVerifyBlockedListFragment$CommonAdapter);
    a();
    setRightButton(2131690935, new NewFriendVerifyBlockedListFragment.4(this));
    b();
  }
  
  public int getContentLayoutId()
  {
    return 2131561668;
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
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiNewFriendVerificationObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
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
        if ((localObject != null) && ((localObject instanceof NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)))
        {
          localObject = (NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)localObject;
          if ((((NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo != null) && (paramString.equals(((NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo.a))) {
            ((NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiNewFriendVerificationObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(null);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiNewFriendVerifyBlockedListFragment$CommonAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiNewFriendVerifyBlockedListFragment$CommonAdapter.b();
    }
    ReportController.b(null, "dc00898", "", "", "0X800A3A6", "0X800A3A6", 0, 0, "", "", "", "");
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiNewFriendVerifyBlockedListFragment$CommonAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiNewFriendVerifyBlockedListFragment$CommonAdapter.a();
    }
    NewFriendVerificationManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addfriendverifi.NewFriendVerifyBlockedListFragment
 * JD-Core Version:    0.7.0.1
 */