package com.tencent.mobileqq.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.RecommendLabel;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.constant.INewFriendConstant.BaseBuilder;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView.SwipListListener;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecommendFriendAdapter
  extends FacePreloadBaseAdapter
  implements View.OnClickListener, SwipListView.SwipListListener
{
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  MayKnowAdapter.OnRecommendsCanceledListener jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new RecommendFriendAdapter.3(this);
  private MayknowRecommendManager jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new RecommendFriendAdapter.1(this);
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new RecommendFriendAdapter.5(this);
  SwipRightMenuBuilder jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected Runnable a;
  private String jdField_a_of_type_JavaLangString = "";
  private List<MayKnowRecommend> jdField_a_of_type_JavaUtilList = new ArrayList();
  int b;
  protected Runnable b;
  private int c;
  private int d;
  
  public RecommendFriendAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, MayKnowAdapter.OnRecommendsCanceledListener paramOnRecommendsCanceledListener)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, true);
    this.jdField_a_of_type_JavaLangRunnable = new RecommendFriendAdapter.2(this);
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangRunnable = new RecommendFriendAdapter.6(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager = ((MayknowRecommendManager)paramQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
    paramXListView.setAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.c = paramInt;
    this.d = 3;
    paramInt = this.c;
    if (paramInt == 8) {
      this.d = 24;
    } else if ((paramInt != 3) && (paramInt != 6))
    {
      if (paramInt == 10) {
        this.d = 28;
      }
    }
    else {
      this.d = 21;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)paramQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener = paramOnRecommendsCanceledListener;
    a(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramContext);
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      if (paramView.findViewById(2131376644) == null) {
        return;
      }
      paramView = paramView.findViewById(2131376644);
      Object localObject = paramView.getTag(2131368658);
      if ((localObject == null) || (!(localObject instanceof Boolean)) || (((Boolean)localObject).booleanValue() != paramBoolean))
      {
        paramView.setTag(2131368658, Boolean.valueOf(paramBoolean));
        if (paramBoolean)
        {
          paramView.setBackgroundResource(2130839395);
          return;
        }
        if (ThemeUtil.isDefaultTheme())
        {
          paramView.setBackgroundResource(2130839393);
          return;
        }
        paramView.setBackgroundResource(2130839390);
      }
    }
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.c();
    MayKnowAdapter.OnRecommendsCanceledListener localOnRecommendsCanceledListener = this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener;
    if ((localOnRecommendsCanceledListener != null) && ((localOnRecommendsCanceledListener instanceof MayKnowAdapter.OnRecommendsUpdateListener))) {
      ((MayKnowAdapter.OnRecommendsUpdateListener)localOnRecommendsCanceledListener).a((List)localObject);
    }
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      a((List)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener;
      if (localObject != null) {
        ((MayKnowAdapter.OnRecommendsCanceledListener)localObject).b();
      }
    }
    else
    {
      a(new ArrayList());
      localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener;
      if (localObject != null) {
        ((MayKnowAdapter.OnRecommendsCanceledListener)localObject).a();
      }
    }
  }
  
  protected View a(Context paramContext, int paramInt, RecommendFriendAdapter.RecFriendViewHolder paramRecFriendViewHolder)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.createView(paramContext, localView, paramRecFriendViewHolder, -1);
  }
  
  protected SwipRightMenuBuilder a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298886);
    int j = paramContext.getResources().getDimensionPixelSize(2131298887);
    paramContext = INewFriendConstant.BaseBuilder.c;
    int[] arrayOfInt1 = INewFriendConstant.BaseBuilder.a;
    int[] arrayOfInt2 = INewFriendConstant.BaseBuilder.b;
    return new RecommendFriendAdapter.4(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stopVisibleExpose firstVisible: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition());
      ((StringBuilder)localObject).append(" lastvisible: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition());
      QLog.d("RecommendFriendAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      while (i <= this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition())
      {
        localObject = (MayKnowRecommend)getItem(i);
        this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.b((MayKnowRecommend)localObject, this.d, this.c, 1);
        i += 1;
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView;
    if (localObject != null) {
      ((XListView)localObject).removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(Context paramContext, View paramView, int paramInt, Object paramObject, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, View.OnClickListener paramOnClickListener)
  {
    SwipRightMenuBuilder localSwipRightMenuBuilder = this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder;
    int i;
    if (localSwipRightMenuBuilder != null) {
      i = localSwipRightMenuBuilder.updateRightMenuView(paramContext, paramView, paramInt, paramObject, paramSwipItemBaseHolder, paramOnClickListener);
    } else {
      i = 0;
    }
    int j = paramView.getScrollX();
    if ((paramInt >= 0) && (this.jdField_b_of_type_Int == paramInt))
    {
      paramView.scrollTo(i, 0);
      return;
    }
    if (j != 0) {
      paramView.scrollTo(0, 0);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = "";
    }
  }
  
  public void a(List<MayKnowRecommend> paramList)
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (paramList != null) && (paramList.size() > 0))
    {
      Object localObject2 = null;
      Iterator localIterator = paramList.iterator();
      Object localObject1;
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (MayKnowRecommend)localIterator.next();
      } while (!this.jdField_a_of_type_JavaLangString.equals(((MayKnowRecommend)localObject1).uin));
      if (localObject1 != null)
      {
        paramList.remove(localObject1);
        paramList.add(0, localObject1);
      }
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    notifyDataSetChanged();
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResume firstVisible: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition());
      ((StringBuilder)localObject).append(" lastvisible: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition());
      QLog.d("RecommendFriendAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      while (i <= this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition())
      {
        localObject = (MayKnowRecommend)getItem(i);
        this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a((MayKnowRecommend)localObject, this.d, this.c, 1);
        i += 1;
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView;
    if (localObject != null)
    {
      ((XListView)localObject).removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    }
    a(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    XListView localXListView = this.jdField_a_of_type_ComTencentWidgetXListView;
    if (localXListView != null) {
      localXListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView;
    if ((localObject != null) && (((XListView)localObject).isShown()) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      int j = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      int k = this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      int i = j;
      while (i <= k)
      {
        if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size()) && (this.jdField_a_of_type_JavaUtilList.get(i) != null))
        {
          localArrayList1.add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).uin);
          localArrayList2.add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).recommendReason);
          localArrayList3.add(Integer.valueOf(i));
          localArrayList4.add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).algBuffer);
        }
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportRecommendFrdExpose firstVisibleItem: ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" lastVisibleItem: ");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(" exp_uins: ");
        ((StringBuilder)localObject).append(localArrayList1);
        ((StringBuilder)localObject).append(" exp_reasons:");
        ((StringBuilder)localObject).append(localArrayList2);
        ((StringBuilder)localObject).append(" exp_positions:");
        ((StringBuilder)localObject).append(localArrayList3);
        ((StringBuilder)localObject).append(" algh_ids:");
        ((StringBuilder)localObject).append(localArrayList4);
        QLog.d("RecommendFriendAdapter", 2, ((StringBuilder)localObject).toString());
      }
      if (!localArrayList1.isEmpty())
      {
        if (this.d == 21) {
          i = 2;
        } else {
          i = 0;
        }
        if (this.d == 24) {
          localObject = "2";
        } else {
          localObject = "";
        }
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.d, localArrayList1, localArrayList2, localArrayList3, localArrayList4, i, (String)localObject);
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return new MayKnowRecommend();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    RecommendFriendAdapter.RecFriendViewHolder localRecFriendViewHolder;
    if (paramView == null)
    {
      localRecFriendViewHolder = new RecommendFriendAdapter.RecFriendViewHolder();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561511, localRecFriendViewHolder);
      localRecFriendViewHolder.d = ((TextView)paramView.findViewById(2131370723));
      localRecFriendViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramView.findViewById(2131379273));
      localRecFriendViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
      localRecFriendViewHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361799));
      localRecFriendViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371877));
      localRecFriendViewHolder.b = ((Button)paramView.findViewById(2131376477));
      localRecFriendViewHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376485));
      paramView.setTag(localRecFriendViewHolder);
      if ((localRecFriendViewHolder.jdField_c_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)localRecFriendViewHolder.jdField_c_of_type_AndroidWidgetImageView).setSupportMaskView(false);
      }
      ((INewFriendApi)QRoute.api(INewFriendApi.class)).updateItemBgKeepPadding(localRecFriendViewHolder.leftView, false);
    }
    else
    {
      localRecFriendViewHolder = (RecommendFriendAdapter.RecFriendViewHolder)paramView.getTag();
    }
    MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)getItem(paramInt);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder(512);
      ((StringBuilder)localObject).append("getView position: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", mobile_name : ");
      ((StringBuilder)localObject).append(localMayKnowRecommend.mobile_name);
      ((StringBuilder)localObject).append(", remark : ");
      ((StringBuilder)localObject).append(localMayKnowRecommend.remark);
      ((StringBuilder)localObject).append(", nick : ");
      ((StringBuilder)localObject).append(localMayKnowRecommend.nick);
      ((StringBuilder)localObject).append(", gender : ");
      ((StringBuilder)localObject).append(localMayKnowRecommend.gender);
      ((StringBuilder)localObject).append(", age : ");
      ((StringBuilder)localObject).append(localMayKnowRecommend.age);
      ((StringBuilder)localObject).append(", category : ");
      ((StringBuilder)localObject).append(localMayKnowRecommend.category);
      ((StringBuilder)localObject).append(", recommendReason : ");
      ((StringBuilder)localObject).append(localMayKnowRecommend.recommendReason);
      ((StringBuilder)localObject).append(", hasQZoneUpdate : ");
      ((StringBuilder)localObject).append(localMayKnowRecommend.hasQZoneUpdate);
      ((StringBuilder)localObject).append(", signature : ");
      ((StringBuilder)localObject).append(localMayKnowRecommend.richSingature);
      QLog.d("RecommendFriendAdapter", 2, ((StringBuilder)localObject).toString());
    }
    localRecFriendViewHolder.jdField_a_of_type_JavaLangString = localMayKnowRecommend.uin;
    localRecFriendViewHolder.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = localMayKnowRecommend;
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(localMayKnowRecommend, this.d, this.c, 1);
    Object localObject = localMayKnowRecommend.getDisplayName(this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localRecFriendViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localRecFriendViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
    else
    {
      localRecFriendViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    paramView.setTag(-1, Integer.valueOf(paramInt));
    a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, localMayKnowRecommend, localRecFriendViewHolder, this);
    localRecFriendViewHolder.leftView.setTag(localMayKnowRecommend);
    localObject = new StringBuilder();
    if (!TextUtils.isEmpty(localMayKnowRecommend.category))
    {
      ((StringBuilder)localObject).append(localMayKnowRecommend.category);
      ((StringBuilder)localObject).append(" ");
    }
    if (!TextUtils.isEmpty(localMayKnowRecommend.recommendReason)) {
      ((StringBuilder)localObject).append(localMayKnowRecommend.recommendReason);
    }
    localObject = ((StringBuilder)localObject).toString();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localRecFriendViewHolder.d.setVisibility(0);
      localRecFriendViewHolder.d.setText((CharSequence)localObject);
    }
    else
    {
      localRecFriendViewHolder.d.setVisibility(8);
    }
    localRecFriendViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(RecommendLabel.convertToRecommendLabel(localMayKnowRecommend.msgLabel), localMayKnowRecommend.gender, localMayKnowRecommend.age);
    if (localMayKnowRecommend.friendStatus == 0)
    {
      localRecFriendViewHolder.b.setOnClickListener(this);
      localRecFriendViewHolder.b.setVisibility(0);
      localRecFriendViewHolder.b.setTag(localMayKnowRecommend);
      localRecFriendViewHolder.b.setText(HardCodeUtil.a(2131689589));
      localRecFriendViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (AppSetting.d) {
        localRecFriendViewHolder.b.setContentDescription(HardCodeUtil.a(2131689589));
      }
    }
    else if (localMayKnowRecommend.friendStatus == 1)
    {
      localRecFriendViewHolder.b.setVisibility(8);
      localRecFriendViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localRecFriendViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(2131718222);
      if (AppSetting.d) {
        localRecFriendViewHolder.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718222));
      }
    }
    else
    {
      localRecFriendViewHolder.b.setVisibility(8);
      localRecFriendViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localRecFriendViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(2131689988);
      if (AppSetting.d) {
        localRecFriendViewHolder.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689988));
      }
    }
    paramView.setOnClickListener(this);
    localRecFriendViewHolder.leftView.setOnClickListener(this);
    localRecFriendViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(1, localRecFriendViewHolder.jdField_a_of_type_JavaLangString));
    a(paramView, localMayKnowRecommend.bHighLight);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void hideMenuPop() {}
  
  public void interceptTouchEvent(boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    int j = 0;
    MayKnowRecommend localMayKnowRecommend;
    Object localObject1;
    Object localObject2;
    if (i != 2131370801)
    {
      boolean bool;
      if (i != 2131376477)
      {
        if (i == 2131376644)
        {
          localMayKnowRecommend = (MayKnowRecommend)paramView.getTag();
          if (localMayKnowRecommend != null)
          {
            localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
            if ((localObject1 != null) && (((FriendsManager)localObject1).b(localMayKnowRecommend.uin)))
            {
              i = 1;
            }
            else
            {
              i = this.c;
              if (i == 8) {
                i = 101;
              } else if ((i != 3) && (i != 4))
              {
                if (i == 10)
                {
                  i = 107;
                }
                else
                {
                  i = 83;
                  if (this.d != 21) {}
                }
              }
              else {
                i = 82;
              }
            }
            localObject2 = new AllInOne(localMayKnowRecommend.uin, i);
            localObject1 = localMayKnowRecommend.getRecommendName(this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a());
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              ((AllInOne)localObject2).recommendName = ((String)localObject1);
            }
            if (!TextUtils.isEmpty(localMayKnowRecommend.nick)) {
              ((AllInOne)localObject2).nickname = localMayKnowRecommend.nick;
            }
            ((AllInOne)localObject2).profileEntryType = 88;
            bool = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false);
            Bundle localBundle = new Bundle();
            if (bool) {
              localBundle.putBoolean("from_babyq", true);
            }
            i = j;
            if (this.d == 21) {
              i = 2;
            }
            if (this.d == 24) {
              localObject1 = "2";
            } else {
              localObject1 = "";
            }
            localBundle.putString("recommend_entry_type", (String)localObject1);
            localBundle.putInt("key_display_type", i);
            localBundle.putString("recommend_reason", localMayKnowRecommend.recommendReason);
            localBundle.putInt("recommend_pos", this.jdField_a_of_type_JavaUtilList.indexOf(localMayKnowRecommend));
            localBundle.putByteArray("recommend_algh_id", localMayKnowRecommend.algBuffer);
            ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, (AllInOne)localObject2, localBundle);
            this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(localMayKnowRecommend, this.d, this.c, 2);
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("onClick_ open profile item uin = ");
              ((StringBuilder)localObject1).append(localMayKnowRecommend.uin);
              QLog.d("RecommendFriendAdapter", 2, ((StringBuilder)localObject1).toString());
            }
            j = this.c;
            if (j != 1)
            {
              if (j != 2)
              {
                if (j != 3)
                {
                  if (j == 4) {
                    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678E", "0X800678E", 0, 0, "", "", "", "");
                  }
                }
                else {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678D", "0X800678D", 0, 0, "", "", "", "");
                }
              }
              else {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678C", "0X800678C", 0, 0, "", "", "", "");
              }
            }
            else {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678F", "0X800678F", 0, 0, "", "", "", "");
            }
            if (this.d == 24) {
              localObject1 = "2";
            } else {
              localObject1 = "";
            }
            ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMayKnowRecommend.uin, "frd_list_clk", this.d, 0, localMayKnowRecommend.recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localMayKnowRecommend), localMayKnowRecommend.algBuffer, i, (String)localObject1);
          }
        }
      }
      else
      {
        localMayKnowRecommend = (MayKnowRecommend)paramView.getTag();
        if (localMayKnowRecommend != null)
        {
          localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
          if ((!((FriendsManager)localObject1).b(localMayKnowRecommend.uin)) && (!((FriendsManager)localObject1).d(localMayKnowRecommend.uin)))
          {
            bool = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false);
            localObject1 = localMayKnowRecommend.getDisplayName(this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a());
            i = this.c;
            if ((i != 3) && (i != 4))
            {
              if (i != 8)
              {
                if (i != 10) {
                  i = 3;
                } else {
                  i = 28;
                }
              }
              else {
                i = 24;
              }
            }
            else {
              i = 21;
            }
            if (bool)
            {
              i = 3083;
              j = 1;
            }
            else
            {
              int k = 3045;
              j = i;
              i = k;
            }
            localObject1 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.jdField_a_of_type_AndroidContentContext, 1, localMayKnowRecommend.uin, null, i, j, (String)localObject1, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131689589), null);
            ((Intent)localObject1).putExtra("key_param_age_area", ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, localMayKnowRecommend.gender, localMayKnowRecommend.age, localMayKnowRecommend.country, localMayKnowRecommend.province, localMayKnowRecommend.city));
            ((Intent)localObject1).putExtra("from_babyq", bool);
            ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend((BaseActivity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1);
            i = this.c;
            if (i != 1)
            {
              if (i != 2)
              {
                if (i != 3)
                {
                  if (i == 4) {
                    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006789", "0X8006789", 0, 0, "", "", "", "");
                  }
                }
                else {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006749", "0X8006749", 0, 0, "", "", "", "");
                }
              }
              else {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006748", "0X8006748", 0, 0, "", "", "", "");
              }
            }
            else {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678B", "0X800678B", 0, 0, "", "", "", "");
            }
          }
          else if (((FriendsManager)localObject1).b(localMayKnowRecommend.uin))
          {
            localMayKnowRecommend.friendStatus = 2;
            notifyDataSetChanged();
          }
          else
          {
            localMayKnowRecommend.friendStatus = 1;
            notifyDataSetChanged();
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(localMayKnowRecommend, this.d, this.c, 3);
          if (this.d == 21) {
            i = 2;
          } else {
            i = 0;
          }
          if (this.d == 24) {
            localObject1 = "2";
          } else {
            localObject1 = "";
          }
          ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMayKnowRecommend.uin, "frd_list_add", this.d, 1, localMayKnowRecommend.recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localMayKnowRecommend), localMayKnowRecommend.algBuffer, i, (String)localObject1);
        }
      }
    }
    else if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      localObject1 = this.jdField_a_of_type_AndroidContentContext;
      QQToast.a((Context)localObject1, ((Context)localObject1).getResources().getString(2131692183), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
    }
    else
    {
      localMayKnowRecommend = (MayKnowRecommend)paramView.getTag();
      if (localMayKnowRecommend != null)
      {
        localObject2 = localMayKnowRecommend.uin;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onClick_ delete item uin = ");
          ((StringBuilder)localObject1).append((String)localObject2);
          QLog.d("RecommendFriendAdapter", 2, ((StringBuilder)localObject1).toString());
        }
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).cancelMayKnowRecommend((String)localObject2);
        this.jdField_a_of_type_JavaUtilList.remove(localMayKnowRecommend);
        notifyDataSetChanged();
        if (this.d == 21) {
          i = 2;
        } else {
          i = 0;
        }
        if (this.d == 24) {
          localObject1 = "2";
        } else {
          localObject1 = "";
        }
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, "frd_list_dlt", this.d, 0, localMayKnowRecommend.recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localMayKnowRecommend), localMayKnowRecommend.algBuffer, i, (String)localObject1);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (QLog.isColorLevel())
    {
      paramAbsListView = new StringBuilder();
      paramAbsListView.append("onScroll firstVisibleItem: ");
      paramAbsListView.append(paramInt1);
      paramAbsListView.append(" visibleItemCount: ");
      paramAbsListView.append(paramInt2);
      paramAbsListView.append(" totalItemCount: ");
      paramAbsListView.append(paramInt3);
      QLog.d("RecommendFriendAdapter", 2, paramAbsListView.toString());
    }
    if (paramInt1 >= 1)
    {
      paramAbsListView = (MayKnowRecommend)getItem(paramInt1 - 1);
      if (paramAbsListView != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.b(paramAbsListView, this.d, this.c, 1);
      }
    }
    paramInt1 += paramInt2;
    if (paramInt1 < paramInt3)
    {
      paramAbsListView = (MayKnowRecommend)getItem(paramInt1);
      if (paramAbsListView != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.b(paramAbsListView, this.d, this.c, 1);
      }
    }
  }
  
  public void updateCurShowRightView(View paramView)
  {
    int j = -1;
    int i = j;
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      i = j;
      if ((paramView instanceof Integer)) {
        i = ((Integer)paramView).intValue();
      }
    }
    this.jdField_b_of_type_Int = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.RecommendFriendAdapter
 * JD-Core Version:    0.7.0.1
 */