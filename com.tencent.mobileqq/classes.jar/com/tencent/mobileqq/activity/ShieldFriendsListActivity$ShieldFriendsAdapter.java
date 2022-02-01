package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class ShieldFriendsListActivity$ShieldFriendsAdapter
  extends BaseAdapter
  implements CompoundButton.OnCheckedChangeListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private List<Friends> jdField_a_of_type_JavaUtilList;
  
  public ShieldFriendsListActivity$ShieldFriendsAdapter(Context paramContext, IFaceDecoder paramIFaceDecoder, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(0);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(Friends paramFriends)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramFriends == null)) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList(1);
    }
    this.jdField_a_of_type_JavaUtilList.add(paramFriends);
    notifyDataSetChanged();
  }
  
  public void a(List<Friends> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      this.jdField_a_of_type_JavaUtilList = paramList;
      notifyDataSetChanged();
    }
  }
  
  public boolean a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return false;
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((Friends)((Iterator)localObject).next()).uin.equals(paramString)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return null;
    }
    return localList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561467, paramViewGroup, false);
      paramView = new ShieldFriendsListActivity.Holder();
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131377437));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377438));
      paramView.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)localView.findViewById(2131377439));
      paramView.jdField_a_of_type_ComTencentWidgetSwitch.setTag(paramView);
      localView.setTag(paramView);
    }
    else
    {
      localObject = (ShieldFriendsListActivity.Holder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    Object localObject = (Friends)getItem(paramInt);
    if (localObject != null)
    {
      paramView.jdField_a_of_type_JavaLangString = ((Friends)localObject).uin;
      paramView.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
      paramView.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(((Friends)localObject).isShield());
      paramView.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
      paramView.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = this;
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, ((Friends)localObject).uin, 0);
      if (localBitmap == null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(((Friends)localObject).uin, 1, true);
        }
        paramView.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable((BitmapDrawable)ImageUtil.f());
      }
      else
      {
        paramView.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(new BitmapDrawable(localBitmap));
      }
      localObject = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((Friends)localObject).uin, 0);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8009DD1", "0X8009DD1", 0, i, "0", "0", "", "");
    int i = HttpUtil.getNetWorkType();
    if (i == -1) {
      i = 2;
    }
    localObject = (ShieldFriendsListActivity.Holder)paramCompoundButton.getTag();
    if (i == 0)
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131696114, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299168));
      paramCompoundButton.setOnCheckedChangeListener(null);
      paramCompoundButton.setChecked(paramBoolean ^ true);
      paramCompoundButton.setOnCheckedChangeListener(((ShieldFriendsListActivity.Holder)localObject).jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    }
    else
    {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).changeFriendShieldFlag(Long.valueOf(((ShieldFriendsListActivity.Holder)localObject).jdField_a_of_type_JavaLangString).longValue(), paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ShieldFriendsListActivity.ShieldFriendsAdapter
 * JD-Core Version:    0.7.0.1
 */