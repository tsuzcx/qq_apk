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
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendBaseBuilder;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
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
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
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
    if (this.c == 8) {
      this.d = 24;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)paramQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
      this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener = paramOnRecommendsCanceledListener;
      a(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramContext);
      return;
      if ((this.c == 3) || (this.c == 6)) {
        this.d = 21;
      } else if (this.c == 10) {
        this.d = 28;
      }
    }
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    if ((paramView == null) || (paramView.findViewById(2131377174) == null)) {}
    Object localObject;
    do
    {
      return;
      paramView = paramView.findViewById(2131377174);
      localObject = paramView.getTag(2131368937);
    } while ((localObject != null) && ((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue() == paramBoolean));
    paramView.setTag(2131368937, Boolean.valueOf(paramBoolean));
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
  
  private void e()
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.c();
    if ((this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener != null) && ((this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener instanceof MayKnowAdapter.OnRecommendsUpdateListener))) {
      ((MayKnowAdapter.OnRecommendsUpdateListener)this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener).a(localArrayList);
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      a(localArrayList);
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener.b();
      }
    }
    do
    {
      return;
      a(new ArrayList());
    } while (this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener == null);
    this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener.a();
  }
  
  protected View a(Context paramContext, int paramInt, RecommendFriendAdapter.RecFriendViewHolder paramRecFriendViewHolder)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.a(paramContext, localView, paramRecFriendViewHolder, -1);
  }
  
  protected SwipRightMenuBuilder a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298882);
    int j = paramContext.getResources().getDimensionPixelSize(2131298883);
    paramContext = NewFriendBaseBuilder.c;
    int[] arrayOfInt1 = NewFriendBaseBuilder.a;
    int[] arrayOfInt2 = NewFriendBaseBuilder.b;
    return new RecommendFriendAdapter.4(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public void a()
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
        this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.b(localMayKnowRecommend, this.d, this.c, 1);
        i += 1;
      }
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(Context paramContext, View paramView, int paramInt, Object paramObject, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder != null) {}
    for (int i = this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.a(paramContext, paramView, paramInt, paramObject, paramSwipItemBaseHolder, paramOnClickListener);; i = 0)
    {
      int j = paramView.getScrollX();
      if ((paramInt >= 0) && (this.jdField_b_of_type_Int == paramInt)) {
        paramView.scrollTo(i, 0);
      }
      while (j == 0) {
        return;
      }
      paramView.scrollTo(0, 0);
      return;
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
    MayKnowRecommend localMayKnowRecommend;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (paramList != null) && (paramList.size() > 0))
    {
      Iterator localIterator = paramList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localMayKnowRecommend = (MayKnowRecommend)localIterator.next();
      } while (!this.jdField_a_of_type_JavaLangString.equals(localMayKnowRecommend.uin));
    }
    for (;;)
    {
      if (localMayKnowRecommend != null)
      {
        paramList.remove(localMayKnowRecommend);
        paramList.add(0, localMayKnowRecommend);
      }
      this.jdField_a_of_type_JavaUtilList = paramList;
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      notifyDataSetChanged();
      return;
      localMayKnowRecommend = null;
    }
  }
  
  public void b()
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
        this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(localMayKnowRecommend, this.d, this.c, 1);
        i += 1;
      }
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
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
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void d()
  {
    int j = 2;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    ArrayList localArrayList4;
    if ((this.jdField_a_of_type_ComTencentWidgetXListView != null) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      int k = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      int m = this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localArrayList3 = new ArrayList();
      localArrayList4 = new ArrayList();
      i = k;
      while (i <= m)
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
      if (QLog.isColorLevel()) {
        QLog.d("RecommendFriendAdapter", 2, "reportRecommendFrdExpose firstVisibleItem: " + k + " lastVisibleItem: " + m + " exp_uins: " + localArrayList1 + " exp_reasons:" + localArrayList2 + " exp_positions:" + localArrayList3 + " algh_ids:" + localArrayList4);
      }
      if (!localArrayList1.isEmpty()) {
        if (this.d != 21) {
          break label364;
        }
      }
    }
    label364:
    for (int i = j;; i = 0)
    {
      String str = "";
      if (this.d == 24) {
        str = "2";
      }
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.d, localArrayList1, localArrayList2, localArrayList3, localArrayList4, i, str);
      return;
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
    RecommendFriendAdapter.RecFriendViewHolder localRecFriendViewHolder;
    MayKnowRecommend localMayKnowRecommend;
    if (paramView == null)
    {
      localRecFriendViewHolder = new RecommendFriendAdapter.RecFriendViewHolder();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561660, localRecFriendViewHolder);
      localRecFriendViewHolder.d = ((TextView)paramView.findViewById(2131371099));
      localRecFriendViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramView.findViewById(2131379944));
      localRecFriendViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
      localRecFriendViewHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361796));
      localRecFriendViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372288));
      localRecFriendViewHolder.b = ((Button)paramView.findViewById(2131376990));
      localRecFriendViewHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377001));
      paramView.setTag(localRecFriendViewHolder);
      if ((localRecFriendViewHolder.jdField_c_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)localRecFriendViewHolder.jdField_c_of_type_AndroidWidgetImageView).setSupportMaskView(false);
      }
      NewFriendBaseBuilder.b(localRecFriendViewHolder.g, false);
      localMayKnowRecommend = (MayKnowRecommend)getItem(paramInt);
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
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label762;
      }
      localRecFriendViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localRecFriendViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      label475:
      paramView.setTag(-1, Integer.valueOf(paramInt));
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, localMayKnowRecommend, localRecFriendViewHolder, this);
      localRecFriendViewHolder.g.setTag(localMayKnowRecommend);
      localObject = new StringBuilder();
      if (!TextUtils.isEmpty(localMayKnowRecommend.category)) {
        ((StringBuilder)localObject).append(localMayKnowRecommend.category).append(" ");
      }
      if (!TextUtils.isEmpty(localMayKnowRecommend.recommendReason)) {
        ((StringBuilder)localObject).append(localMayKnowRecommend.recommendReason);
      }
      localObject = ((StringBuilder)localObject).toString();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label775;
      }
      localRecFriendViewHolder.d.setVisibility(0);
      localRecFriendViewHolder.d.setText((CharSequence)localObject);
      label602:
      localRecFriendViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(localMayKnowRecommend);
      if (localMayKnowRecommend.friendStatus != 0) {
        break label788;
      }
      localRecFriendViewHolder.b.setOnClickListener(this);
      localRecFriendViewHolder.b.setVisibility(0);
      localRecFriendViewHolder.b.setTag(localMayKnowRecommend);
      localRecFriendViewHolder.b.setText(HardCodeUtil.a(2131689557));
      localRecFriendViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (AppSetting.d) {
        localRecFriendViewHolder.b.setContentDescription(HardCodeUtil.a(2131689557));
      }
    }
    for (;;)
    {
      paramView.setOnClickListener(this);
      localRecFriendViewHolder.g.setOnClickListener(this);
      localRecFriendViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(1, localRecFriendViewHolder.jdField_a_of_type_JavaLangString));
      a(paramView, localMayKnowRecommend.bHighLight);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localRecFriendViewHolder = (RecommendFriendAdapter.RecFriendViewHolder)paramView.getTag();
      break;
      label762:
      localRecFriendViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label475;
      label775:
      localRecFriendViewHolder.d.setVisibility(8);
      break label602;
      label788:
      if (localMayKnowRecommend.friendStatus == 1)
      {
        localRecFriendViewHolder.b.setVisibility(8);
        localRecFriendViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        localRecFriendViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(2131718554);
        if (AppSetting.d) {
          localRecFriendViewHolder.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718554));
        }
      }
      else
      {
        localRecFriendViewHolder.b.setVisibility(8);
        localRecFriendViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        localRecFriendViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(2131690072);
        if (AppSetting.d) {
          localRecFriendViewHolder.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690072));
        }
      }
    }
  }
  
  public void hideMenuPop() {}
  
  public void interceptTouchEvent(boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    MayKnowRecommend localMayKnowRecommend;
    Object localObject2;
    boolean bool;
    label406:
    do
    {
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692257), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
          }
          else
          {
            localMayKnowRecommend = (MayKnowRecommend)paramView.getTag();
            if (localMayKnowRecommend != null)
            {
              localObject2 = localMayKnowRecommend.uin;
              if (QLog.isColorLevel()) {
                QLog.d("RecommendFriendAdapter", 2, "onClick_ delete item uin = " + (String)localObject2);
              }
              ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).cancelMayKnowRecommend((String)localObject2);
              this.jdField_a_of_type_JavaUtilList.remove(localMayKnowRecommend);
              notifyDataSetChanged();
              i = 0;
              if (this.d == 21) {
                i = 2;
              }
              localObject1 = "";
              if (this.d == 24) {
                localObject1 = "2";
              }
              ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, "frd_list_dlt", this.d, 0, localMayKnowRecommend.recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localMayKnowRecommend), localMayKnowRecommend.algBuffer, i, (String)localObject1);
            }
          }
        }
        localMayKnowRecommend = (MayKnowRecommend)paramView.getTag();
      } while (localMayKnowRecommend == null);
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((!((FriendsManager)localObject1).b(localMayKnowRecommend.uin)) && (!((FriendsManager)localObject1).d(localMayKnowRecommend.uin)))
      {
        bool = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false);
        localObject1 = localMayKnowRecommend.getDisplayName(this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a());
        int j = 3045;
        switch (this.c)
        {
        case 5: 
        case 6: 
        case 7: 
        case 9: 
        default: 
          i = 3;
          if (bool)
          {
            j = 3083;
            i = 1;
          }
          localObject1 = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, localMayKnowRecommend.uin, null, j, i, (String)localObject1, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131689557), null);
          ((Intent)localObject1).putExtra("key_param_age_area", ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, localMayKnowRecommend.gender, localMayKnowRecommend.age, localMayKnowRecommend.country, localMayKnowRecommend.province, localMayKnowRecommend.city));
          ((Intent)localObject1).putExtra("from_babyq", bool);
          ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).startActivity((Intent)localObject1);
          switch (this.c)
          {
          }
          break;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(localMayKnowRecommend, this.d, this.c, 3);
        i = 0;
        if (this.d == 21) {
          i = 2;
        }
        localObject1 = "";
        if (this.d == 24) {
          localObject1 = "2";
        }
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMayKnowRecommend.uin, "frd_list_add", this.d, 1, localMayKnowRecommend.recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localMayKnowRecommend), localMayKnowRecommend.algBuffer, i, (String)localObject1);
        break;
        i = 24;
        break label406;
        i = 21;
        break label406;
        i = 28;
        break label406;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678B", "0X800678B", 0, 0, "", "", "", "");
        continue;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006748", "0X8006748", 0, 0, "", "", "", "");
        continue;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006749", "0X8006749", 0, 0, "", "", "", "");
        continue;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006789", "0X8006789", 0, 0, "", "", "", "");
        continue;
        if (((FriendsManager)localObject1).b(localMayKnowRecommend.uin))
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
      localMayKnowRecommend = (MayKnowRecommend)paramView.getTag();
    } while (localMayKnowRecommend == null);
    Object localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    label882:
    Bundle localBundle;
    if ((localObject1 != null) && (((FriendsManager)localObject1).b(localMayKnowRecommend.uin)))
    {
      i = 1;
      localObject2 = new ProfileActivity.AllInOne(localMayKnowRecommend.uin, i);
      localObject1 = localMayKnowRecommend.getRecommendName(this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a());
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((ProfileActivity.AllInOne)localObject2).l = ((String)localObject1);
      }
      if (!TextUtils.isEmpty(localMayKnowRecommend.nick)) {
        ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = localMayKnowRecommend.nick;
      }
      ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 88;
      bool = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false);
      localBundle = new Bundle();
      if (bool) {
        localBundle.putBoolean("from_babyq", true);
      }
      if (this.d != 21) {
        break label1455;
      }
    }
    label1455:
    for (int i = 2;; i = 0)
    {
      localObject1 = "";
      if (this.d == 24) {
        localObject1 = "2";
      }
      localBundle.putString("recommend_entry_type", (String)localObject1);
      localBundle.putInt("key_display_type", i);
      localBundle.putString("recommend_reason", localMayKnowRecommend.recommendReason);
      localBundle.putInt("recommend_pos", this.jdField_a_of_type_JavaUtilList.indexOf(localMayKnowRecommend));
      localBundle.putByteArray("recommend_algh_id", localMayKnowRecommend.algBuffer);
      ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject2, localBundle);
      this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(localMayKnowRecommend, this.d, this.c, 2);
      if (QLog.isColorLevel()) {
        QLog.d("RecommendFriendAdapter", 2, "onClick_ open profile item uin = " + localMayKnowRecommend.uin);
      }
      switch (this.c)
      {
      }
      for (;;)
      {
        localObject1 = "";
        if (this.d == 24) {
          localObject1 = "2";
        }
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMayKnowRecommend.uin, "frd_list_clk", this.d, 0, localMayKnowRecommend.recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localMayKnowRecommend), localMayKnowRecommend.algBuffer, i, (String)localObject1);
        break;
        if (this.c == 8)
        {
          i = 101;
          break label882;
        }
        if ((this.c == 3) || (this.c == 4))
        {
          i = 82;
          break label882;
        }
        if (this.c == 10)
        {
          i = 107;
          break label882;
        }
        i = 83;
        if (this.d != 21) {
          break label882;
        }
        i = 82;
        break label882;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678F", "0X800678F", 0, 0, "", "", "", "");
        continue;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678C", "0X800678C", 0, 0, "", "", "", "");
        continue;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678D", "0X800678D", 0, 0, "", "", "", "");
        continue;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800678E", "0X800678E", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendAdapter", 2, "onScroll firstVisibleItem: " + paramInt1 + " visibleItemCount: " + paramInt2 + " totalItemCount: " + paramInt3);
    }
    if (paramInt1 >= 1)
    {
      paramAbsListView = (MayKnowRecommend)getItem(paramInt1 - 1);
      if (paramAbsListView != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.b(paramAbsListView, this.d, this.c, 1);
      }
    }
    if (paramInt1 + paramInt2 < paramInt3)
    {
      paramAbsListView = (MayKnowRecommend)getItem(paramInt1 + paramInt2);
      if (paramAbsListView != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.b(paramAbsListView, this.d, this.c, 1);
      }
    }
  }
  
  public void updateCurShowRightView(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      if (!(paramView instanceof Integer)) {}
    }
    for (int i = ((Integer)paramView).intValue();; i = -1)
    {
      this.jdField_b_of_type_Int = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.RecommendFriendAdapter
 * JD-Core Version:    0.7.0.1
 */