package com.tencent.mobileqq.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.RecommendFriendActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import yid;
import yie;
import yif;

public class RecommendFriendAdapter
  extends FacePreloadBaseAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new yie(this);
  private MayknowRecommendManager jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new yid(this);
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public RecommendFriendAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, true);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager = ((MayknowRecommendManager)paramQQAppInterface.getManager(158));
    paramXListView.setAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)paramQQAppInterface.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
  }
  
  private StringBuilder a(yif paramyif)
  {
    int j = 0;
    RichStatus localRichStatus = paramyif.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.getRichStatus();
    paramyif = paramyif.d;
    Object localObject1 = localRichStatus.toSpannableString(null, this.jdField_a_of_type_AndroidContentResResources.getColor(2131494277), this.jdField_a_of_type_AndroidContentResResources.getColor(2131494277));
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder(512);
      ((StringBuilder)localObject2).append("updateRichStatus , status.actionText : ");
      ((StringBuilder)localObject2).append(localRichStatus.actionText);
      ((StringBuilder)localObject2).append(" , actionId : ");
      ((StringBuilder)localObject2).append(localRichStatus.actionId);
      ((StringBuilder)localObject2).append(" , status.dataText : " + localRichStatus.dataText);
      ((StringBuilder)localObject2).append(" , dataId : ");
      ((StringBuilder)localObject2).append(localRichStatus.dataId);
      ((StringBuilder)localObject2).append(" , ss : ");
      ((StringBuilder)localObject2).append((CharSequence)localObject1);
      QLog.d("RecommendFriendAdapter", 2, ((StringBuilder)localObject2).toString());
    }
    int i;
    if (!TextUtils.isEmpty(localRichStatus.actionText))
    {
      paramyif.setVisibility(0);
      localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
      ((SpannableStringBuilder)localObject1).insert(0, "[S] ");
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(localRichStatus.actionId, 200);
      localObject2 = new StatableBitmapDrawable(this.jdField_a_of_type_AndroidContentResResources, (Bitmap)localObject2, false, false);
      i = (int)(paramyif.getTextSize() * 1.1F + 0.5F);
      ((BitmapDrawable)localObject2).setBounds(0, 0, i, i);
      localObject2 = new OffsetableImageSpan((Drawable)localObject2, 0);
      ((OffsetableImageSpan)localObject2).a(-0.1F);
      ((SpannableStringBuilder)localObject1).setSpan(localObject2, 0, "[S]".length(), 17);
      paramyif.setText((CharSequence)localObject1);
      paramyif = new StringBuilder();
      if (localRichStatus.actionText != null) {
        paramyif.append(localRichStatus.actionText);
      }
      if (localRichStatus.dataText != null) {
        paramyif.append(localRichStatus.dataText);
      }
      if (localRichStatus.plainText == null) {
        break label438;
      }
      i = localRichStatus.plainText.size();
    }
    for (;;)
    {
      if (j >= i) {
        return paramyif;
      }
      localObject1 = (String)localRichStatus.plainText.get(j);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramyif.append((String)localObject1);
      }
      j += 1;
      continue;
      if (((SpannableString)localObject1).length() == 0)
      {
        paramyif.setVisibility(8);
        break;
      }
      paramyif.setVisibility(0);
      paramyif.setText((CharSequence)localObject1);
      break;
      label438:
      i = 0;
    }
    return paramyif;
  }
  
  public void X_()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendAdapter", 2, "onScroll firstVisibleItem: " + paramInt1 + " visibleItemCount: " + paramInt2 + " totalItemCount: " + paramInt3);
    }
    if (paramInt1 >= 1)
    {
      paramAbsListView = (MayKnowRecommend)getItem(paramInt1 - 1);
      if (paramAbsListView != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.b(paramAbsListView, 3, this.jdField_a_of_type_Int, 1);
      }
    }
    if (paramInt1 + paramInt2 < paramInt3)
    {
      paramAbsListView = (MayKnowRecommend)getItem(paramInt1 + paramInt2);
      if (paramAbsListView != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.b(paramAbsListView, 3, this.jdField_a_of_type_Int, 1);
      }
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendAdapter", 2, "stopVisibleExpose firstVisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition() + " lastvisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition());
    }
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      while (i <= this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition())
      {
        MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)getItem(i);
        this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.b(localMayKnowRecommend, 3, this.jdField_a_of_type_Int, 1);
        i += 1;
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendAdapter", 2, "onResume firstVisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition() + " lastvisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition());
    }
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      while (i <= this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition())
      {
        MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)getItem(i);
        this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(localMayKnowRecommend, 3, this.jdField_a_of_type_Int, 1);
        i += 1;
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return new MayKnowRecommend();
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
      paramView = new yif();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970637, paramViewGroup, false);
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131366545));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362894));
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369982));
      paramView.b = ((TextView)localView.findViewById(2131371532));
      paramView.d = ((TextView)localView.findViewById(2131369984));
      paramView.f = ((TextView)localView.findViewById(2131371533));
      paramView.e = ((Button)localView.findViewById(2131368973));
      paramView.g = ((TextView)localView.findViewById(2131368974));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)getItem(paramInt);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder(512);
        paramView.append("getView position: ");
        paramView.append(paramInt);
        paramView.append(", remark : ");
        paramView.append(localMayKnowRecommend.remark);
        paramView.append(", nick : ");
        paramView.append(localMayKnowRecommend.nick);
        paramView.append(", gender : ");
        paramView.append(localMayKnowRecommend.gender);
        paramView.append(", age : ");
        paramView.append(localMayKnowRecommend.age);
        paramView.append(", category : ");
        paramView.append(localMayKnowRecommend.category);
        paramView.append(", recommendReason : ");
        paramView.append(localMayKnowRecommend.recommendReason);
        paramView.append(", hasQZoneUpdate : ");
        paramView.append(localMayKnowRecommend.hasQZoneUpdate);
        paramView.append(", signature : ");
        paramView.append(localMayKnowRecommend.richSingature);
        QLog.d("RecommendFriendAdapter", 2, paramView.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder(512);
      paramViewGroup.jdField_a_of_type_JavaLangString = localMayKnowRecommend.uin;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = localMayKnowRecommend;
      this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(localMayKnowRecommend, 3, this.jdField_a_of_type_Int, 1);
      label422:
      label458:
      int i;
      if (TextUtils.isEmpty(localMayKnowRecommend.remark)) {
        if (TextUtils.isEmpty(localMayKnowRecommend.nick))
        {
          paramView = localMayKnowRecommend.uin;
          if (TextUtils.isEmpty(paramView)) {
            break label907;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
          if (AppSetting.b) {
            localStringBuilder.append(paramView);
          }
          paramInt = 0;
          paramView = new StringBuilder();
          label550:
          label703:
          switch (localMayKnowRecommend.gender)
          {
          default: 
            i = 0;
            paramViewGroup.b.setBackgroundResource(2130843120);
            label509:
            if (localMayKnowRecommend.age > 0)
            {
              paramInt = 1;
              paramView.append(localMayKnowRecommend.age).append("岁");
              paramViewGroup.b.setText(String.valueOf(localMayKnowRecommend.age));
              if (paramInt == 0) {
                break label988;
              }
              paramViewGroup.b.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
              paramViewGroup.b.setVisibility(0);
              paramViewGroup.b.setPadding(8, 4, 8, 4);
              if (AppSetting.b) {
                localStringBuilder.append(paramView);
              }
              paramView = new StringBuilder();
              if (!TextUtils.isEmpty(localMayKnowRecommend.category)) {
                paramView.append(localMayKnowRecommend.category).append(" ");
              }
              if (!TextUtils.isEmpty(localMayKnowRecommend.recommendReason)) {
                paramView.append(localMayKnowRecommend.recommendReason);
              }
              paramView = paramView.toString();
              if (TextUtils.isEmpty(paramView)) {
                break label1000;
              }
              paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
              paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(paramView);
              if (AppSetting.b) {
                localStringBuilder.append(",").append(paramView);
              }
              if (!localMayKnowRecommend.hasQZoneUpdate) {
                break label1012;
              }
              paramViewGroup.f.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130843145, 0);
              paramViewGroup.f.setVisibility(0);
            }
            label600:
            break;
          }
        }
      }
      try
      {
        for (;;)
        {
          paramView = a(paramViewGroup);
          if (AppSetting.b) {
            localStringBuilder.append(",").append(paramView);
          }
          if (localMayKnowRecommend.friendStatus != 0) {
            break label1064;
          }
          paramViewGroup.e.setOnClickListener(this);
          paramViewGroup.e.setVisibility(0);
          paramViewGroup.e.setTag(localMayKnowRecommend);
          paramViewGroup.e.setText("添加");
          paramViewGroup.g.setVisibility(8);
          if (AppSetting.b)
          {
            localStringBuilder.append(",点击添加");
            paramViewGroup.e.setContentDescription("添加");
          }
          if (AppSetting.b) {
            localView.setContentDescription(localStringBuilder.toString());
          }
          localView.setOnClickListener(this);
          paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(1, paramViewGroup.jdField_a_of_type_JavaLangString));
          return localView;
          paramViewGroup = (yif)paramView.getTag();
          localView = paramView;
          break;
          paramView = localMayKnowRecommend.nick;
          break label422;
          paramView = localMayKnowRecommend.remark;
          break label422;
          label907:
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break label458;
          paramInt = 1;
          i = 2130843119;
          paramView.append("男,");
          paramViewGroup.b.setBackgroundResource(2130843120);
          break label509;
          paramInt = 1;
          i = 2130843117;
          paramView.append("女,");
          paramViewGroup.b.setBackgroundResource(2130843118);
          break label509;
          paramViewGroup.b.setText("");
          break label550;
          label988:
          paramViewGroup.b.setVisibility(8);
          break label600;
          label1000:
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          break label703;
          label1012:
          paramViewGroup.f.setVisibility(8);
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("RecommendFriendAdapter", 2, "updateRichStatus error uin=" + localMayKnowRecommend.uin);
            continue;
            label1064:
            if (localMayKnowRecommend.friendStatus == 1)
            {
              paramViewGroup.e.setVisibility(8);
              paramViewGroup.g.setVisibility(0);
              paramViewGroup.g.setText(2131433048);
              if (AppSetting.b)
              {
                localStringBuilder.append(",等待验证");
                paramViewGroup.g.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131433048));
              }
            }
            else
            {
              paramViewGroup.e.setVisibility(8);
              paramViewGroup.g.setVisibility(0);
              paramViewGroup.g.setText(2131433034);
              if (AppSetting.b)
              {
                localStringBuilder.append(",已添加");
                paramViewGroup.g.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131433034));
              }
            }
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    MayKnowRecommend localMayKnowRecommend;
    boolean bool;
    do
    {
      do
      {
        do
        {
          return;
          localMayKnowRecommend = (MayKnowRecommend)paramView.getTag();
        } while (localMayKnowRecommend == null);
        paramView = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        if ((!paramView.b(localMayKnowRecommend.uin)) && (!paramView.c(localMayKnowRecommend.uin)))
        {
          bool = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false);
          if (TextUtils.isEmpty(localMayKnowRecommend.remark)) {
            if (TextUtils.isEmpty(localMayKnowRecommend.nick))
            {
              paramView = localMayKnowRecommend.uin;
              i = 3045;
              int j = 3;
              if (bool)
              {
                i = 3083;
                j = 1;
              }
              paramView = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, localMayKnowRecommend.uin, null, i, j, paramView, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131435226), null);
              paramView.putExtra("key_param_age_area", ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, localMayKnowRecommend.gender, localMayKnowRecommend.age, localMayKnowRecommend.country, localMayKnowRecommend.province, localMayKnowRecommend.city));
              paramView.putExtra("from_babyq", bool);
              ((RecommendFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivity(paramView);
              switch (this.jdField_a_of_type_Int)
              {
              }
            }
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(localMayKnowRecommend, 3, this.jdField_a_of_type_Int, 3);
          return;
          paramView = localMayKnowRecommend.nick;
          break;
          paramView = localMayKnowRecommend.remark;
          break;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678B", "0X800678B", 0, 0, "", "", "", "");
          continue;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006748", "0X8006748", 0, 0, "", "", "", "");
          continue;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006749", "0X8006749", 0, 0, "", "", "", "");
          continue;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006789", "0X8006789", 0, 0, "", "", "", "");
          continue;
          if (paramView.b(localMayKnowRecommend.uin))
          {
            localMayKnowRecommend.friendStatus = 2;
            notifyDataSetChanged();
          }
          else
          {
            localMayKnowRecommend.friendStatus = 1;
            notifyDataSetChanged();
          }
        }
        paramView = (yif)paramView.getTag();
      } while (paramView == null);
      localMayKnowRecommend = paramView.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend;
    } while (localMayKnowRecommend == null);
    paramView = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    if ((paramView != null) && (paramView.b(localMayKnowRecommend.uin))) {}
    for (int i = 1;; i = 83)
    {
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(localMayKnowRecommend.uin, i);
      if (!TextUtils.isEmpty(localMayKnowRecommend.remark)) {
        localAllInOne.l = localMayKnowRecommend.remark;
      }
      if (!TextUtils.isEmpty(localMayKnowRecommend.nick)) {
        localAllInOne.l = localMayKnowRecommend.nick;
      }
      localAllInOne.h = 88;
      bool = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false);
      paramView = null;
      if (bool)
      {
        paramView = new Bundle();
        paramView.putBoolean("from_babyq", true);
      }
      ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, localAllInOne, paramView);
      this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(localMayKnowRecommend, 3, this.jdField_a_of_type_Int, 2);
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        return;
      case 1: 
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678F", "0X800678F", 0, 0, "", "", "", "");
        return;
      case 2: 
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678C", "0X800678C", 0, 0, "", "", "", "");
        return;
      case 3: 
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678D", "0X800678D", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678E", "0X800678E", 0, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.RecommendFriendAdapter
 * JD-Core Version:    0.7.0.1
 */