package com.tencent.mobileqq.adapter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.HorizontalListView.OnItemScrollEventListener;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import mqq.app.AppRuntime;

public class MayKnowAdapter
  extends BaseAdapter
  implements View.OnClickListener, DecodeTaskCompletionListener, HorizontalListView.OnItemScrollEventListener
{
  private int jdField_a_of_type_Int;
  Activity jdField_a_of_type_AndroidAppActivity;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new MayKnowAdapter.1(this);
  MayKnowAdapter.OnRecommendsCanceledListener jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new MayKnowAdapter.MyFriendListObserver(this);
  FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  MayknowRecommendManager jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected IFaceDecoder a;
  private HorizontalListView.OnScrollStateChangedListener jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener = new MayKnowAdapter.6(this);
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  protected Runnable a;
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private List<MayKnowRecommend> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int;
  View.OnTouchListener jdField_b_of_type_AndroidViewView$OnTouchListener = new MayKnowAdapter.2(this);
  private Runnable jdField_b_of_type_JavaLangRunnable = new MayKnowAdapter.7(this);
  private int c = 0;
  private int d;
  
  public MayKnowAdapter(Activity paramActivity, QQAppInterface paramQQAppInterface, HorizontalListView paramHorizontalListView, MayKnowAdapter.OnRecommendsCanceledListener paramOnRecommendsCanceledListener, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangRunnable = new MayKnowAdapter.5(this);
    paramHorizontalListView.setAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener = paramOnRecommendsCanceledListener;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager = ((MayknowRecommendManager)paramQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemScollEventListener(this);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    g();
    this.d = MayknowRecommendManager.jdField_a_of_type_Int;
    paramActivity = this.jdField_a_of_type_JavaUtilList;
    if ((paramActivity != null) && (paramActivity.size() > 0))
    {
      paramActivity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramActivity != null)
      {
        paramInt1 = this.jdField_b_of_type_Int;
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2)
          {
            if (paramInt1 != 3)
            {
              if (paramInt1 == 4) {
                ReportController.b(paramActivity, "CliOper", "", "", "0X8006773", "0X8006773", 0, 0, "", "", "", "");
              }
            }
            else {
              ReportController.b(paramActivity, "CliOper", "", "", "0X800673F", "0X800673F", 0, 0, "", "", "", "");
            }
          }
          else {
            ReportController.b(paramActivity, "CliOper", "", "", "0X800673E", "0X800673E", 0, 0, "", "", "", "");
          }
        }
        else {
          ReportController.b(paramActivity, "CliOper", "", "", "0X800674D", "0X800674D", 0, 0, "", "", "", "");
        }
      }
    }
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnScrollStateChangedListener(this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener);
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("MayKnowAdapter ,mFriendObserver = ");
      paramActivity.append(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      QLog.d("MayKnowAdapter", 2, paramActivity.toString());
    }
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 1000L);
  }
  
  private View a()
  {
    int i = 0;
    Object localObject;
    while (i < this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildCount())
    {
      localView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(i);
      if ((localView != null) && ((localView.getTag() instanceof MayKnowAdapter.MKRViewHolder)))
      {
        localObject = (MayKnowAdapter.MKRViewHolder)localView.getTag();
        if ((localObject != null) && (((MayKnowAdapter.MKRViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend != null) && (((MayKnowAdapter.MKRViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.friendStatus != 0)) {
          break label77;
        }
      }
      i += 1;
    }
    View localView = null;
    label77:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("findTargetChangeStatusView view:");
      ((StringBuilder)localObject).append(localView);
      QLog.d("MayKnowAdapter", 2, ((StringBuilder)localObject).toString());
    }
    return localView;
  }
  
  private View a(String paramString)
  {
    int i = 0;
    Object localObject;
    while (i < this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildCount())
    {
      localView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(i);
      if ((localView != null) && ((localView.getTag() instanceof MayKnowAdapter.MKRViewHolder)))
      {
        localObject = (MayKnowAdapter.MKRViewHolder)localView.getTag();
        if ((localObject != null) && (((MayKnowAdapter.MKRViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend != null) && (TextUtils.equals(((MayKnowAdapter.MKRViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.uin, paramString))) {
          break label85;
        }
      }
      i += 1;
    }
    View localView = null;
    label85:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("findTargetDeleteView view:");
      ((StringBuilder)localObject).append(localView);
      ((StringBuilder)localObject).append("   uin:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("MayKnowAdapter", 2, ((StringBuilder)localObject).toString());
    }
    return localView;
  }
  
  private void a(View paramView)
  {
    a(paramView, new MayKnowAdapter.3(this, paramView));
  }
  
  private void a(View paramView, Animation.AnimationListener paramAnimationListener)
  {
    MayKnowAdapter.4 local4 = new MayKnowAdapter.4(this, paramView, paramView.getMeasuredWidth());
    if (paramAnimationListener != null) {
      local4.setAnimationListener(paramAnimationListener);
    }
    local4.setDuration(240L);
    paramView.startAnimation(local4);
  }
  
  private void f()
  {
    c();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
    if (localObject != null) {
      this.jdField_a_of_type_JavaUtilList = ((MayknowRecommendManager)localObject).c();
    }
    notifyDataSetChanged();
    localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener;
      if (localObject != null) {
        ((MayKnowAdapter.OnRecommendsCanceledListener)localObject).b();
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener;
      if (localObject != null) {
        ((MayKnowAdapter.OnRecommendsCanceledListener)localObject).a();
      }
    }
  }
  
  private void g()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
    if (localObject != null) {
      this.jdField_a_of_type_JavaUtilList = ((MayknowRecommendManager)localObject).c();
    }
    notifyDataSetChanged();
    localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener;
      if (localObject != null) {
        ((MayKnowAdapter.OnRecommendsCanceledListener)localObject).b();
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener;
      if (localObject != null) {
        ((MayKnowAdapter.OnRecommendsCanceledListener)localObject).a();
      }
    }
  }
  
  protected Bitmap a(int paramInt, String paramString)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, paramInt, true, (byte)0);
    }
    return ImageUtil.f();
  }
  
  public MayKnowRecommend a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (paramInt >= 0) && (paramInt < ((List)localObject).size())) {
      return (MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getItem Illegal Adapter with overflowed data,position =  ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("MayKnowAdapter", 2, ((StringBuilder)localObject).toString());
    }
    return new MayKnowRecommend();
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startVisibleExpose firstVisible: ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition());
      localStringBuilder.append(" lastvisible: ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition());
      QLog.d("MayKnowAdapter", 2, localStringBuilder.toString());
    }
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.isShown()) && (this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager != null))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
      while (i <= this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition())
      {
        if (i < 0) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(a(i), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1);
        i += 1;
      }
    }
  }
  
  public void b() {}
  
  public void c()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopVisibleExpose firstVisible: ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition());
      localStringBuilder.append(" lastvisible: ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition());
      QLog.d("MayKnowAdapter", 2, localStringBuilder.toString());
    }
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.isShown()) && (this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager != null))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
      while (i <= this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition())
      {
        if (i < 0) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.b(a(i), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1);
        i += 1;
      }
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "destroy");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    else
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetHorizontalListView;
    if (localObject != null)
    {
      ((HorizontalListView)localObject).setOnScrollStateChangedListener(null);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = null;
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void e()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView;
    if ((localObject1 != null) && (((HorizontalListView)localObject1).isShown()))
    {
      localObject1 = this.jdField_a_of_type_JavaUtilList;
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        int j = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
        int k = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition();
        localObject1 = new ArrayList();
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        ArrayList localArrayList3 = new ArrayList();
        int i = j;
        while (i <= k)
        {
          if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size()) && (this.jdField_a_of_type_JavaUtilList.get(i) != null))
          {
            ((ArrayList)localObject1).add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).uin);
            localArrayList1.add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).recommendReason);
            localArrayList2.add(Integer.valueOf(i));
            localArrayList3.add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).algBuffer);
          }
          i += 1;
        }
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("reportRecommendFrdExpose firstVisibleItem: ");
          ((StringBuilder)localObject2).append(j);
          ((StringBuilder)localObject2).append(" lastVisibleItem: ");
          ((StringBuilder)localObject2).append(k);
          ((StringBuilder)localObject2).append(" exp_uins: ");
          ((StringBuilder)localObject2).append(localObject1);
          ((StringBuilder)localObject2).append(" exp_reasons:");
          ((StringBuilder)localObject2).append(localArrayList1);
          ((StringBuilder)localObject2).append(" exp_positions:");
          ((StringBuilder)localObject2).append(localArrayList2);
          ((StringBuilder)localObject2).append(" algh_ids:");
          ((StringBuilder)localObject2).append(localArrayList3);
          QLog.d("MayKnowAdapter", 2, ((StringBuilder)localObject2).toString());
        }
        if (!((ArrayList)localObject1).isEmpty())
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (localObject2 != null) {
            ContactReportUtils.a((QQAppInterface)localObject2, this.jdField_a_of_type_Int, (ArrayList)localObject1, localArrayList1, localArrayList2, localArrayList3, 1, null);
          }
        }
      }
    }
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    int i = localList.size();
    int j = this.d;
    if (i > j) {
      return j;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getView position: ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("MayKnowAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = null;
    if (paramView != null) {
      localObject1 = (MayKnowAdapter.MKRViewHolder)paramView.getTag();
    }
    Object localObject2;
    if ((paramView != null) && (localObject1 != null) && (!((MayKnowAdapter.MKRViewHolder)localObject1).jdField_a_of_type_Boolean))
    {
      localObject2 = localObject1;
      if (TextUtils.equals(((MayKnowAdapter.MKRViewHolder)localObject1).jdField_b_of_type_JavaLangString, ThemeUtil.curThemeId)) {}
    }
    else
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131558501, paramViewGroup, false);
      localObject2 = new MayKnowAdapter.MKRViewHolder();
      ((MayKnowAdapter.MKRViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368066));
      ((MayKnowAdapter.MKRViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371876));
      ((MayKnowAdapter.MKRViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.getPaint();
      ((MayKnowAdapter.MKRViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367378));
      ((MayKnowAdapter.MKRViewHolder)localObject2).c = ((TextView)paramView.findViewById(2131361952));
      ((MayKnowAdapter.MKRViewHolder)localObject2).d = ((TextView)paramView.findViewById(2131362192));
      ((MayKnowAdapter.MKRViewHolder)localObject2).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131364703);
      ((MayKnowAdapter.MKRViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      ((MayKnowAdapter.MKRViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      ((MayKnowAdapter.MKRViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      ((MayKnowAdapter.MKRViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_b_of_type_AndroidViewView$OnTouchListener);
      if ((((MayKnowAdapter.MKRViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)((MayKnowAdapter.MKRViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView).setSupportMaskView(false);
      }
      ((MayKnowAdapter.MKRViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      ((MayKnowAdapter.MKRViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      paramView.setTag(localObject2);
      if (this.jdField_a_of_type_Int != 25)
      {
        ((MayKnowAdapter.MKRViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167056));
        ((MayKnowAdapter.MKRViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167152));
      }
      ((MayKnowAdapter.MKRViewHolder)localObject2).jdField_b_of_type_JavaLangString = ThemeUtil.curThemeId;
    }
    localObject1 = a(paramInt);
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
    if (localObject3 != null) {
      ((MayknowRecommendManager)localObject3).a((MayKnowRecommend)localObject1, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1);
    }
    localObject3 = new StringBuilder();
    ((MayKnowAdapter.MKRViewHolder)localObject2).jdField_a_of_type_JavaLangString = ((MayKnowRecommend)localObject1).uin;
    ((MayKnowAdapter.MKRViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = ((MayKnowRecommend)localObject1);
    ((MayKnowAdapter.MKRViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setTag(localObject1);
    ((MayKnowAdapter.MKRViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setTag(localObject2);
    ((MayKnowAdapter.MKRViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTag(localObject2);
    ((MayKnowAdapter.MKRViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(1, ((MayKnowAdapter.MKRViewHolder)localObject2).jdField_a_of_type_JavaLangString));
    Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
    boolean bool;
    if (localObject4 != null) {
      bool = ((MayknowRecommendManager)localObject4).a();
    } else {
      bool = false;
    }
    localObject4 = ((MayKnowRecommend)localObject1).getDisplayName(bool);
    ((MayKnowAdapter.MKRViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject4);
    if ((AppSetting.d) && (!TextUtils.isEmpty((CharSequence)localObject4))) {
      ((StringBuilder)localObject3).append((String)localObject4);
    }
    if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).recommendReason))
    {
      ((MayKnowAdapter.MKRViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(((MayKnowRecommend)localObject1).recommendReason);
      if (AppSetting.d)
      {
        ((StringBuilder)localObject3).append(",你们有");
        ((StringBuilder)localObject3).append(((MayKnowRecommend)localObject1).recommendReason);
      }
    }
    else
    {
      ((MayKnowAdapter.MKRViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText("");
    }
    if (((MayKnowRecommend)localObject1).friendStatus == 0)
    {
      ((MayKnowAdapter.MKRViewHolder)localObject2).c.setVisibility(0);
      ((MayKnowAdapter.MKRViewHolder)localObject2).c.setTag(localObject1);
      ((MayKnowAdapter.MKRViewHolder)localObject2).d.setVisibility(8);
      ((MayKnowAdapter.MKRViewHolder)localObject2).c.setOnClickListener(this);
      if (AppSetting.d)
      {
        ((MayKnowAdapter.MKRViewHolder)localObject2).c.setContentDescription(HardCodeUtil.a(2131689589));
        ((StringBuilder)localObject3).append(",添加他为好友");
      }
    }
    else if (((MayKnowRecommend)localObject1).friendStatus == 1)
    {
      ((MayKnowAdapter.MKRViewHolder)localObject2).c.setVisibility(8);
      ((MayKnowAdapter.MKRViewHolder)localObject2).d.setVisibility(0);
      ((MayKnowAdapter.MKRViewHolder)localObject2).d.setText(2131718222);
      if (AppSetting.d)
      {
        ((MayKnowAdapter.MKRViewHolder)localObject2).d.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718222));
        ((StringBuilder)localObject3).append(",等待验证");
      }
    }
    else
    {
      ((MayKnowAdapter.MKRViewHolder)localObject2).c.setVisibility(8);
      ((MayKnowAdapter.MKRViewHolder)localObject2).d.setVisibility(0);
      ((MayKnowAdapter.MKRViewHolder)localObject2).d.setText(2131689988);
      if (AppSetting.d)
      {
        ((MayKnowAdapter.MKRViewHolder)localObject2).d.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131689988));
        ((StringBuilder)localObject3).append(",已添加");
      }
    }
    if (paramInt == getCount() - 1) {
      paramView.setPadding(0, 0, this.c, 0);
    } else {
      paramView.setPadding(0, 0, 0, 0);
    }
    if (AppSetting.d) {
      paramView.setContentDescription(((StringBuilder)localObject3).toString());
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject1;
    Object localObject2;
    switch (i)
    {
    default: 
      break;
    case 2131368066: 
    case 2131371876: 
      localObject1 = (MayKnowAdapter.MKRViewHolder)paramView.getTag();
      if (localObject1 != null)
      {
        localObject1 = ((MayKnowAdapter.MKRViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend;
        if (localObject1 != null)
        {
          i = 84;
          int j = this.jdField_a_of_type_Int;
          if (j != 3)
          {
            if (j != 21)
            {
              if (j != 23)
              {
                if (j != 25)
                {
                  if (j == 28) {
                    i = 107;
                  }
                }
                else {
                  i = 102;
                }
              }
              else {
                i = 81;
              }
            }
            else {
              i = 82;
            }
          }
          else {
            i = 83;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
          j = i;
          if (localObject2 != null)
          {
            j = i;
            if (((FriendsManager)localObject2).b(((MayKnowRecommend)localObject1).uin)) {
              j = 1;
            }
          }
          localObject2 = new AllInOne(((MayKnowRecommend)localObject1).uin, j);
          Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
          if (localObject3 != null) {
            bool1 = ((MayknowRecommendManager)localObject3).a();
          }
          localObject3 = ((MayKnowRecommend)localObject1).getRecommendName(bool1);
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            ((AllInOne)localObject2).recommendName = ((String)localObject3);
          }
          if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).nick)) {
            ((AllInOne)localObject2).nickname = ((MayKnowRecommend)localObject1).nick;
          }
          ((AllInOne)localObject2).profileEntryType = 88;
          localObject3 = new Bundle();
          ((Bundle)localObject3).putString("recommend_reason", ((MayKnowRecommend)localObject1).recommendReason);
          List localList = this.jdField_a_of_type_JavaUtilList;
          if (localList != null) {
            ((Bundle)localObject3).putInt("recommend_pos", localList.indexOf(localObject1));
          }
          ((Bundle)localObject3).putByteArray("recommend_algh_id", ((MayKnowRecommend)localObject1).algBuffer);
          ((Bundle)localObject3).putInt("key_display_type", 1);
          ProfileActivity.a(this.jdField_a_of_type_AndroidAppActivity, (AllInOne)localObject2, (Bundle)localObject3);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
          if (localObject2 != null) {
            ((MayknowRecommendManager)localObject2).a((MayKnowRecommend)localObject1, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 2);
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (localObject2 != null)
          {
            i = this.jdField_b_of_type_Int;
            if (i != 1)
            {
              if (i != 2)
              {
                if (i != 3)
                {
                  if (i == 4) {
                    ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X800678A", "0X800678A", 0, 0, "", "", "", "");
                  }
                }
                else {
                  ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X8006741", "0X8006741", 0, 0, "", "", "", "");
                }
              }
              else {
                ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X8006740", "0X8006740", 0, 0, "", "", "", "");
              }
            }
            else {
              ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X800674E", "0X800674E", 0, 0, "", "", "", "");
            }
          }
          if (this.jdField_a_of_type_JavaUtilList != null)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (localObject2 != null) {
              ContactReportUtils.a((QQAppInterface)localObject2, ((MayKnowRecommend)localObject1).uin, "frd_list_clk", this.jdField_a_of_type_Int, 0, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 1);
            }
          }
        }
      }
      break;
    case 2131364703: 
      localObject1 = (MayKnowRecommend)paramView.getTag();
      if (localObject1 != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localObject2 != null)
        {
          ((FriendListHandler)((QQAppInterface)localObject2).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).cancelMayKnowRecommend(((MayKnowRecommend)localObject1).uin);
          i = this.jdField_b_of_type_Int;
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                if (i == 4) {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006772", "0X8006772", 0, 0, "", "", "", "");
                }
              }
              else {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006743", "0X8006743", 0, 0, "", "", "", "");
              }
            }
            else {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006742", "0X8006742", 0, 0, "", "", "", "");
            }
          }
          else {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800674F", "0X800674F", 0, 0, "", "", "", "");
          }
          if (this.jdField_a_of_type_JavaUtilList != null)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (localObject2 != null) {
              ContactReportUtils.a((QQAppInterface)localObject2, ((MayKnowRecommend)localObject1).uin, "frd_list_dlt", this.jdField_a_of_type_Int, 0, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 1);
            }
          }
        }
      }
      break;
    case 2131361952: 
      localObject1 = (MayKnowRecommend)paramView.getTag();
      if (localObject1 != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
        if ((localObject2 != null) && (!((FriendsManager)localObject2).b(((MayKnowRecommend)localObject1).uin)) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.d(((MayKnowRecommend)localObject1).uin)))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
          bool1 = bool2;
          if (localObject2 != null) {
            bool1 = ((MayknowRecommendManager)localObject2).a();
          }
          localObject2 = ((MayKnowRecommend)localObject1).getDisplayName(bool1);
          localObject2 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.jdField_a_of_type_AndroidAppActivity, 1, ((MayKnowRecommend)localObject1).uin, null, 3045, this.jdField_a_of_type_Int, (String)localObject2, null, null, this.jdField_a_of_type_AndroidAppActivity.getString(2131689589), null);
          ((Intent)localObject2).putExtra("key_param_age_area", ProfileCardUtil.a(this.jdField_a_of_type_AndroidAppActivity, ((MayKnowRecommend)localObject1).gender, ((MayKnowRecommend)localObject1).age, ((MayKnowRecommend)localObject1).country, ((MayKnowRecommend)localObject1).province, ((MayKnowRecommend)localObject1).city));
          ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (localObject2 != null)
          {
            i = this.jdField_b_of_type_Int;
            if (i != 1)
            {
              if (i != 2)
              {
                if (i != 3)
                {
                  if (i == 4) {
                    ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X8006771", "0X8006771", 0, 0, "", "", "", "");
                  }
                }
                else {
                  ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X8006745", "0X8006745", 0, 0, "", "", "", "");
                }
              }
              else {
                ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X8006744", "0X8006744", 0, 0, "", "", "", "");
              }
            }
            else {
              ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X8006750", "0X8006750", 0, 0, "", "", "", "");
            }
          }
        }
        else
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
          if ((localObject2 != null) && (((FriendsManager)localObject2).b(((MayKnowRecommend)localObject1).uin)))
          {
            ((MayKnowRecommend)localObject1).friendStatus = 2;
            notifyDataSetChanged();
          }
          else
          {
            ((MayKnowRecommend)localObject1).friendStatus = 1;
            notifyDataSetChanged();
          }
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
        if (localObject2 != null) {
          ((MayknowRecommendManager)localObject2).a((MayKnowRecommend)localObject1, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 3);
        }
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (localObject2 != null) {
            ContactReportUtils.a((QQAppInterface)localObject2, ((MayKnowRecommend)localObject1).uin, "frd_list_add", this.jdField_a_of_type_Int, 1, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 1);
          }
        }
      }
      break;
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
  
  public void onItemScrollNonVisible(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onItemScrollNonVisible ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" fromLeft=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("MayKnowAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
    if (localObject != null) {
      ((MayknowRecommendManager)localObject).b(a(paramInt), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.MayKnowAdapter
 * JD-Core Version:    0.7.0.1
 */