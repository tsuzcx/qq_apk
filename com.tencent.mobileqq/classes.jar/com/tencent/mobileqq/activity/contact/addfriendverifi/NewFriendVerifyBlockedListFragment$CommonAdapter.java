package com.tencent.mobileqq.activity.contact.addfriendverifi;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendBaseBuilder;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.ThemeImageView;
import java.util.List;
import java.util.Locale;

class NewFriendVerifyBlockedListFragment$CommonAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private NewFriendVerifyBlockedListFragment$CommonAdapter(NewFriendVerifyBlockedListFragment paramNewFriendVerifyBlockedListFragment) {}
  
  private void a(View paramView)
  {
    if ((paramView instanceof ThemeImageView)) {
      ((ThemeImageView)paramView).setSupportMaskView(true);
    }
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if (paramBoolean)
    {
      paramView.setBackgroundResource(2130839539);
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839537);
      return;
    }
    paramView.setBackgroundResource(2130839534);
  }
  
  private void a(NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder paramNewFriendBlockedHolder, View.OnClickListener paramOnClickListener)
  {
    if (paramNewFriendBlockedHolder.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo == null) {
      return;
    }
    if (TextUtils.isEmpty(paramNewFriendBlockedHolder.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo.jdField_b_of_type_JavaLangString))
    {
      paramNewFriendBlockedHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramNewFriendBlockedHolder.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo.jdField_a_of_type_JavaLangString);
      a(paramNewFriendBlockedHolder, paramNewFriendBlockedHolder.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo.jdField_a_of_type_JavaLangString);
      paramNewFriendBlockedHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(paramNewFriendBlockedHolder);
      NewFriendBaseBuilder.a(paramNewFriendBlockedHolder.e, paramNewFriendBlockedHolder.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo.jdField_b_of_type_Int, paramNewFriendBlockedHolder.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo.jdField_a_of_type_Int, null);
      paramOnClickListener = paramNewFriendBlockedHolder.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo.jdField_c_of_type_JavaLangString;
      if (TextUtils.isEmpty(paramOnClickListener)) {
        break label210;
      }
      paramOnClickListener = String.format(Locale.getDefault(), HardCodeUtil.a(2131707500), new Object[] { paramOnClickListener });
      paramNewFriendBlockedHolder.c.setText(paramOnClickListener);
      paramNewFriendBlockedHolder.c.setVisibility(0);
      label128:
      int i = paramNewFriendBlockedHolder.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo.jdField_c_of_type_Int;
      if (i <= 0) {
        break label222;
      }
      paramOnClickListener = String.format(Locale.getDefault(), "%d位共同好友", new Object[] { Integer.valueOf(i) });
      paramNewFriendBlockedHolder.b.setVisibility(0);
      paramNewFriendBlockedHolder.b.setText(paramOnClickListener);
    }
    for (;;)
    {
      paramNewFriendBlockedHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramNewFriendBlockedHolder);
      paramNewFriendBlockedHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
      paramNewFriendBlockedHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramNewFriendBlockedHolder.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo.jdField_b_of_type_JavaLangString);
      break;
      label210:
      paramNewFriendBlockedHolder.c.setVisibility(8);
      break label128;
      label222:
      paramNewFriendBlockedHolder.b.setVisibility(8);
    }
  }
  
  public AddFriendBlockedInfo a(int paramInt)
  {
    return (AddFriendBlockedInfo)NewFriendVerifyBlockedListFragment.a(this.a).get(paramInt);
  }
  
  public void a()
  {
    NewFriendVerifyBlockedListFragment.a(this.a).cancelPendingRequests();
    NewFriendVerifyBlockedListFragment.a(this.a).pause();
  }
  
  public void a(NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder paramNewFriendBlockedHolder, String paramString)
  {
    if ((paramNewFriendBlockedHolder == null) || (paramNewFriendBlockedHolder.jdField_a_of_type_AndroidWidgetImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Bitmap localBitmap = NewFriendVerifyBlockedListFragment.a(this.a).getBitmapFromCache(1, paramString);
    if ((localBitmap == null) && (!NewFriendVerifyBlockedListFragment.a(this.a).isPausing())) {
      NewFriendVerifyBlockedListFragment.a(this.a).requestDecodeFace(paramString, 1, true);
    }
    paramString = localBitmap;
    if (localBitmap == null) {
      paramString = ImageUtil.c();
    }
    paramNewFriendBlockedHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramString);
  }
  
  public void b()
  {
    if (NewFriendVerifyBlockedListFragment.a(this.a).isPausing()) {
      NewFriendVerifyBlockedListFragment.a(this.a).resume();
    }
  }
  
  public void c()
  {
    int j = NewFriendVerifyBlockedListFragment.a(this.a).getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = NewFriendVerifyBlockedListFragment.a(this.a).getChildAt(i).getTag();
      if ((localObject instanceof NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder))
      {
        localObject = (NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)localObject;
        a((NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)localObject, ((NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo.jdField_a_of_type_JavaLangString);
      }
      i += 1;
    }
  }
  
  public int getCount()
  {
    if (NewFriendVerifyBlockedListFragment.a(this.a) == null) {
      return 0;
    }
    return NewFriendVerifyBlockedListFragment.a(this.a).size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      paramView = new NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder(this);
      localView = LayoutInflater.from(NewFriendVerifyBlockedListFragment.a(this.a)).inflate(2131561667, null);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131361796));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131372288));
      paramView.b = ((TextView)localView.findViewById(2131377005));
      paramView.e = ((TextView)localView.findViewById(2131362338));
      paramView.c = ((TextView)localView.findViewById(2131378318));
      paramView.d = ((TextView)localView.findViewById(2131377001));
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131376990));
      paramView.jdField_a_of_type_AndroidViewView = localView;
      localView.setOnClickListener(this);
      a(paramView.jdField_a_of_type_AndroidWidgetImageView);
      localView.setTag(paramView);
      localObject = a(paramInt);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo = ((AddFriendBlockedInfo)localObject);
      if (((AddFriendBlockedInfo)localObject).jdField_a_of_type_Boolean) {
        break label227;
      }
      a(paramView.jdField_a_of_type_AndroidViewView, true);
    }
    for (;;)
    {
      a(paramView, this);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label227:
      a(paramView.jdField_a_of_type_AndroidViewView, false);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject1 = paramView.getTag();
      if ((localObject1 != null) && ((localObject1 instanceof NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)))
      {
        localObject1 = ((NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo;
        if (localObject1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("BlockedListFragment", 2, "onClick rlSystemMsg， friendtype=" + 109);
          }
          localObject2 = new ProfileActivity.AllInOne(((AddFriendBlockedInfo)localObject1).jdField_a_of_type_JavaLangString, 109);
          if (!TextUtils.isEmpty(((AddFriendBlockedInfo)localObject1).jdField_b_of_type_JavaLangString)) {}
          for (((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = ((AddFriendBlockedInfo)localObject1).jdField_b_of_type_JavaLangString;; ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = ((AddFriendBlockedInfo)localObject1).jdField_a_of_type_JavaLangString)
          {
            ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 120;
            ProfileActivity.a(NewFriendVerifyBlockedListFragment.a(this.a), (ProfileActivity.AllInOne)localObject2, 100);
            ReportController.b(null, "dc00898", "", "", "0X800A3A8", "0X800A3A8", 0, 0, "", "", "", "");
            break;
          }
          localObject1 = paramView.getTag();
          if ((localObject1 != null) && ((localObject1 instanceof NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)))
          {
            if (NetworkUtil.g(NewFriendVerifyBlockedListFragment.a(this.a))) {
              break;
            }
            QQToast.a(NewFriendVerifyBlockedListFragment.a(this.a), NewFriendVerifyBlockedListFragment.a(this.a).getResources().getString(2131692257), 0).b(NewFriendVerifyBlockedListFragment.a(this.a).getTitleBarHeight());
          }
        }
      }
    }
    Object localObject2 = ((NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo;
    if (!TextUtils.isEmpty(((AddFriendBlockedInfo)localObject2).jdField_b_of_type_JavaLangString)) {}
    for (Object localObject1 = ((AddFriendBlockedInfo)localObject2).jdField_b_of_type_JavaLangString;; localObject1 = ((AddFriendBlockedInfo)localObject2).jdField_a_of_type_JavaLangString)
    {
      localObject1 = AddFriendLogicActivity.a(NewFriendVerifyBlockedListFragment.a(this.a), 1, ((AddFriendBlockedInfo)localObject2).jdField_a_of_type_JavaLangString, null, 3041, 15, (String)localObject1, null, null, NewFriendVerifyBlockedListFragment.a(this.a).getString(2131689557), null);
      NewFriendVerifyBlockedListFragment.a(this.a).startActivityForResult((Intent)localObject1, 100);
      ReportController.b(null, "dc00898", "", "", "0X800A3A7", "0X800A3A7", 0, 0, "", "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addfriendverifi.NewFriendVerifyBlockedListFragment.CommonAdapter
 * JD-Core Version:    0.7.0.1
 */