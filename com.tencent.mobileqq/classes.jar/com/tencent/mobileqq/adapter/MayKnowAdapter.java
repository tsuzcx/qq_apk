package com.tencent.mobileqq.adapter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.HorizontalListView.OnItemScrollEventListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import yhr;

public class MayKnowAdapter
  extends BaseAdapter
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, HorizontalListView.OnItemScrollEventListener
{
  private int jdField_a_of_type_Int;
  Activity jdField_a_of_type_AndroidAppActivity;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new yhr(this);
  FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  public MayknowRecommendManager a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected FaceDecoder a;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private int b;
  private int c;
  
  public MayKnowAdapter(Activity paramActivity, QQAppInterface paramQQAppInterface, HorizontalListView paramHorizontalListView, FormSimpleItem paramFormSimpleItem, int paramInt1, int paramInt2)
  {
    paramHorizontalListView.setAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = paramFormSimpleItem;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(50));
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager = ((MayknowRecommendManager)paramQQAppInterface.getManager(158));
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(paramActivity, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemScollEventListener(this);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    d();
    this.c = MayknowRecommendManager.jdField_a_of_type_Int;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {}
    switch (this.b)
    {
    default: 
      return;
    case 1: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800674D", "0X800674D", 0, 0, "", "", "", "");
      return;
    case 2: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800673E", "0X800673E", 0, 0, "", "", "", "");
      return;
    case 3: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800673F", "0X800673F", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006773", "0X8006773", 0, 0, "", "", "", "");
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a();
    notifyDataSetChanged();
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    }
    while (!NetworkUtil.d(this.jdField_a_of_type_AndroidAppActivity))
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.b();
  }
  
  protected Bitmap a(int paramInt, String paramString)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, paramInt, true, (byte)0);
    }
    return ImageUtil.a();
  }
  
  public MayKnowRecommend a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return new MayKnowRecommend();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "startVisibleExpose firstVisible: " + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition() + " lastvisible: " + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition());
    }
    int i;
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.isShown())) {
      i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    }
    for (;;)
    {
      if ((i > this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition()) || (i < 0)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(a(i), this.jdField_a_of_type_Int, this.b, 1);
      i += 1;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "onItemScrollNonVisible " + paramInt + " fromLeft=" + paramBoolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.b(a(paramInt), this.jdField_a_of_type_Int, this.b, 1);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "stopVisibleExpose firstVisible: " + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition() + " lastvisible: " + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition());
    }
    int i;
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.isShown())) {
      i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    }
    for (;;)
    {
      if ((i > this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition()) || (i < 0)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.b(a(i), this.jdField_a_of_type_Int, this.b, 1);
      i += 1;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > this.c) {
      return this.c;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "getView position: " + paramInt);
    }
    View localView;
    MayKnowRecommend localMayKnowRecommend;
    StringBuilder localStringBuilder;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130968615, paramViewGroup, false);
      paramViewGroup = new MayKnowAdapter.MKRViewHolder();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362869));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362870));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getPaint();
      paramViewGroup.b = ((TextView)localView.findViewById(2131362871));
      paramViewGroup.c = ((TextView)localView.findViewById(2131362872));
      paramViewGroup.d = ((TextView)localView.findViewById(2131362873));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131362868));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      localView.setTag(paramViewGroup);
      localMayKnowRecommend = a(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(localMayKnowRecommend, this.jdField_a_of_type_Int, this.b, 1);
      localStringBuilder = new StringBuilder();
      paramViewGroup.jdField_a_of_type_JavaLangString = localMayKnowRecommend.uin;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = localMayKnowRecommend;
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(localMayKnowRecommend);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(1, paramViewGroup.jdField_a_of_type_JavaLangString));
      if (!TextUtils.isEmpty(localMayKnowRecommend.remark)) {
        break label461;
      }
      if (!TextUtils.isEmpty(localMayKnowRecommend.nick)) {
        break label452;
      }
      paramView = localMayKnowRecommend.uin;
      label272:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      if ((AppSetting.b) && (!TextUtils.isEmpty(paramView))) {
        localStringBuilder.append(paramView);
      }
      if (TextUtils.isEmpty(localMayKnowRecommend.recommendReason)) {
        break label470;
      }
      paramViewGroup.b.setText(localMayKnowRecommend.recommendReason);
      if (AppSetting.b) {
        localStringBuilder.append(",你们有").append(localMayKnowRecommend.recommendReason);
      }
      label346:
      if (localMayKnowRecommend.friendStatus != 0) {
        break label482;
      }
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.c.setTag(localMayKnowRecommend);
      paramViewGroup.d.setVisibility(8);
      paramViewGroup.c.setOnClickListener(this);
      if (AppSetting.b)
      {
        paramViewGroup.c.setContentDescription("添加");
        localStringBuilder.append(",添加他为好友");
      }
    }
    for (;;)
    {
      if (AppSetting.b) {
        localView.setContentDescription(localStringBuilder.toString());
      }
      localView.setOnClickListener(this);
      return localView;
      paramViewGroup = (MayKnowAdapter.MKRViewHolder)paramView.getTag();
      localView = paramView;
      break;
      label452:
      paramView = localMayKnowRecommend.nick;
      break label272;
      label461:
      paramView = localMayKnowRecommend.remark;
      break label272;
      label470:
      paramViewGroup.b.setText("");
      break label346;
      label482:
      if (localMayKnowRecommend.friendStatus == 1)
      {
        paramViewGroup.c.setVisibility(8);
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.d.setText(2131433048);
        if (AppSetting.b)
        {
          paramViewGroup.d.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131433048));
          localStringBuilder.append(",等待验证");
        }
      }
      else
      {
        paramViewGroup.c.setVisibility(8);
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.d.setText(2131433034);
        if (AppSetting.b)
        {
          paramViewGroup.d.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131433034));
          localStringBuilder.append(",已添加");
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject = (MayKnowRecommend)paramView.getTag();
          } while (localObject == null);
          if ((!this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(((MayKnowRecommend)localObject).uin)) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c(((MayKnowRecommend)localObject).uin))) {
            if (TextUtils.isEmpty(((MayKnowRecommend)localObject).remark)) {
              if (TextUtils.isEmpty(((MayKnowRecommend)localObject).nick))
              {
                paramView = ((MayKnowRecommend)localObject).uin;
                paramView = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidAppActivity, 1, ((MayKnowRecommend)localObject).uin, null, 3045, this.jdField_a_of_type_Int, paramView, null, null, this.jdField_a_of_type_AndroidAppActivity.getString(2131435226), null);
                paramView.putExtra("key_param_age_area", ProfileCardUtil.a(this.jdField_a_of_type_AndroidAppActivity, ((MayKnowRecommend)localObject).gender, ((MayKnowRecommend)localObject).age, ((MayKnowRecommend)localObject).country, ((MayKnowRecommend)localObject).province, ((MayKnowRecommend)localObject).city));
                this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
                switch (this.b)
                {
                }
              }
            }
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a((MayKnowRecommend)localObject, this.jdField_a_of_type_Int, this.b, 3);
            return;
            paramView = ((MayKnowRecommend)localObject).nick;
            break;
            paramView = ((MayKnowRecommend)localObject).remark;
            break;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006750", "0X8006750", 0, 0, "", "", "", "");
            continue;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006744", "0X8006744", 0, 0, "", "", "", "");
            continue;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006745", "0X8006745", 0, 0, "", "", "", "");
            continue;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006771", "0X8006771", 0, 0, "", "", "", "");
            continue;
            if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(((MayKnowRecommend)localObject).uin))
            {
              ((MayKnowRecommend)localObject).friendStatus = 2;
              notifyDataSetChanged();
            }
            else
            {
              ((MayKnowRecommend)localObject).friendStatus = 1;
              notifyDataSetChanged();
            }
          }
          paramView = (MayKnowRecommend)paramView.getTag();
        } while (paramView == null);
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).f(paramView.uin);
        switch (this.b)
        {
        default: 
          return;
        case 1: 
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800674F", "0X800674F", 0, 0, "", "", "", "");
          return;
        case 2: 
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006742", "0X8006742", 0, 0, "", "", "", "");
          return;
        case 3: 
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006743", "0X8006743", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006772", "0X8006772", 0, 0, "", "", "", "");
        return;
        paramView = (MayKnowAdapter.MKRViewHolder)paramView.getTag();
      } while (paramView == null);
      paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend;
    } while (paramView == null);
    int i = 84;
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      int j = i;
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager != null)
      {
        j = i;
        if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(paramView.uin)) {
          j = 1;
        }
      }
      localObject = new ProfileActivity.AllInOne(paramView.uin, j);
      if (!TextUtils.isEmpty(paramView.remark)) {
        ((ProfileActivity.AllInOne)localObject).l = paramView.remark;
      }
      if (!TextUtils.isEmpty(paramView.nick)) {
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = paramView.nick;
      }
      ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 88;
      ProfileActivity.b(this.jdField_a_of_type_AndroidAppActivity, (ProfileActivity.AllInOne)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(paramView, this.jdField_a_of_type_Int, this.b, 2);
      switch (this.b)
      {
      default: 
        return;
      case 1: 
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800674E", "0X800674E", 0, 0, "", "", "", "");
        return;
        i = 82;
        continue;
        i = 81;
        continue;
        i = 83;
      }
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006740", "0X8006740", 0, 0, "", "", "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006741", "0X8006741", 0, 0, "", "", "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678A", "0X800678A", 0, 0, "", "", "", "");
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_JavaUtilHashtable.put(paramString, paramBitmap);
    }
    if (paramInt1 <= 0)
    {
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramString = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(paramInt1).getTag();
        if ((paramString != null) && ((paramString instanceof MayKnowAdapter.MKRViewHolder)))
        {
          paramString = (MayKnowAdapter.MKRViewHolder)paramString;
          if ((paramString != null) && (paramString.jdField_a_of_type_JavaLangString != null) && (paramString.jdField_a_of_type_JavaLangString.length() > 0))
          {
            paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.jdField_a_of_type_JavaLangString);
            if (paramBitmap != null) {
              paramString.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            }
          }
        }
        paramInt1 += 1;
      }
      this.jdField_a_of_type_JavaUtilHashtable.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.MayKnowAdapter
 * JD-Core Version:    0.7.0.1
 */