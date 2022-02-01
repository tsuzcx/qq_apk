package com.tencent.mobileqq.activity.contact.connections;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.data.Card;
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
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView.SwipListListener;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ConnectsExplorationFriendAdapter
  extends FacePreloadBaseAdapter
  implements View.OnClickListener, SwipListView.SwipListListener
{
  int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CTEntryMng jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new ConnectsExplorationFriendAdapter.4(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ConnectsExplorationFriendAdapter.3(this);
  private MayknowRecommendManager jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new ConnectsExplorationFriendAdapter.1(this);
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new ConnectsExplorationFriendAdapter.8(this);
  private SwipRightMenuBuilder jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected Runnable a;
  private Comparator<MayKnowRecommend> jdField_a_of_type_JavaUtilComparator = new ConnectsExplorationFriendAdapter.6(this);
  private List<MayKnowRecommend> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  protected Runnable b;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private int d;
  
  public ConnectsExplorationFriendAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, View paramView1, View paramView2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, true);
    this.jdField_a_of_type_JavaLangRunnable = new ConnectsExplorationFriendAdapter.2(this);
    this.jdField_b_of_type_JavaLangRunnable = new ConnectsExplorationFriendAdapter.9(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager = ((MayknowRecommendManager)paramQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
    paramXListView.setAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366204));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367892);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130839302);
    }
    paramXListView = (ThemeImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367889);
    paramXListView.setSupportMaskView(true);
    paramXListView.setMaskShape(ThemeImageWrapper.MODE_SQURE);
    this.jdField_b_of_type_AndroidViewView = paramView2;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)paramQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    a(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramContext);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng = ((CTEntryMng)paramQQAppInterface.getManager(QQManagerFactory.CTENTRY_MNG));
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager = ((MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
    if (this.jdField_c_of_type_Int == 0) {
      a(true);
    }
    paramContext = this.jdField_a_of_type_ComTencentWidgetXListView;
    if (paramContext != null)
    {
      paramContext.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  private URLDrawable a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    if (((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable == null) {
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
    }
    if (((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable == null) {
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelperConstants.a;
    }
    localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDrawable downLoadUrl ->");
      localStringBuilder.append(paramString);
      QLog.d("ConnectsExplorationFriendAdapter", 2, localStringBuilder.toString());
    }
    return localObject;
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
  
  private void a(ConnectsExplorationFriendAdapter.BannerViewHolder paramBannerViewHolder)
  {
    if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
    {
      paramBannerViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839301);
      paramBannerViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#12B7F5"));
      paramBannerViewHolder.b.setTextColor(Color.parseColor("#7F12B7F5"));
      paramBannerViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a("https://qzonestyle.gtimg.cn/aoi/sola/20190920103348_DVTS7XhGQJ.png"));
      return;
    }
    paramBannerViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839302);
    paramBannerViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(102, 255, 255, 255));
    paramBannerViewHolder.b.setTextColor(Color.argb(102, 255, 255, 255));
    paramBannerViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a("https://qzonestyle.gtimg.cn/aoi/sola/20190920103348_9H32GY0LpT.png"));
  }
  
  protected View a(Context paramContext, int paramInt, ConnectsExplorationFriendAdapter.BannerViewHolder paramBannerViewHolder)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.createView(paramContext, localView, paramBannerViewHolder, -1);
  }
  
  protected View a(Context paramContext, int paramInt, ConnectsExplorationFriendAdapter.RecFriendViewHolder paramRecFriendViewHolder)
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
    return new ConnectsExplorationFriendAdapter.5(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public void a()
  {
    if (this.jdField_c_of_type_Int != 0) {
      a(true);
    }
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
    if ((paramInt >= 0) && (this.jdField_a_of_type_Int == paramInt))
    {
      paramView.scrollTo(i, 0);
      return;
    }
    if (j != 0) {
      paramView.scrollTo(0, 0);
    }
  }
  
  public void a(TextView paramTextView, MayKnowRecommend paramMayKnowRecommend)
  {
    if (paramMayKnowRecommend == null) {
      return;
    }
    Object localObject = paramMayKnowRecommend.getDisplayName(this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a());
    if ((!TextUtils.isEmpty(paramMayKnowRecommend.mobile_name)) && (!((String)localObject).equals(paramMayKnowRecommend.mobile_name)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(paramMayKnowRecommend.mobile_name);
      ((StringBuilder)localObject).append(")");
      paramTextView.setText(((StringBuilder)localObject).toString());
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  public void a(List<MayKnowRecommend> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_a_of_type_Boolean) {
      a(false);
    }
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reloadRecommendData ");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramBoolean);
      QLog.d("ConnectsExplorationFriendAdapter", 2, localStringBuilder.toString());
    }
    if ((this.jdField_b_of_type_Int != 23) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.c()))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699055);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5D3", "0X800A5D3", 0, 0, "2", "", "", "");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ConnectsExplorationFriendAdapter.7(this, paramBoolean));
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("userInfoState ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("ConnectsExplorationFriendAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ArrayList localArrayList = ((BusinessCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)).a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((MayKnowRecommend)localIterator.next() instanceof ConnectsExplorationBanner)) {
        localIterator.remove();
      }
    }
    if ((TextUtils.isEmpty(((Card)localObject).strSchool)) && ((localArrayList == null) || (localArrayList.isEmpty())))
    {
      localObject = new ConnectsExplorationBanner();
      ((ConnectsExplorationBanner)localObject).setBanner(true);
      if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
        return false;
      }
      if (this.jdField_a_of_type_JavaUtilList.size() <= 4) {
        this.jdField_a_of_type_JavaUtilList.add(localObject);
      } else {
        this.jdField_a_of_type_JavaUtilList.add(4, localObject);
      }
    }
    if (paramBoolean) {
      notifyDataSetChanged();
    }
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume firstVisible: ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition());
      localStringBuilder.append(" lastvisible: ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition());
      QLog.d("ConnectsExplorationFriendAdapter", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_Boolean) {
      a(true);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    }
    a(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
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
      localObject = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      int i = j;
      while (i <= k)
      {
        if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size()) && (this.jdField_a_of_type_JavaUtilList.get(i) != null) && (!(this.jdField_a_of_type_JavaUtilList.get(i) instanceof ConnectsExplorationBanner)))
        {
          ((ArrayList)localObject).add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).uin);
          localArrayList1.add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).recommendReason);
          localArrayList2.add(Integer.valueOf(i));
          localArrayList3.add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).algBuffer);
        }
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportRecommendFrdExpose firstVisibleItem: ");
        localStringBuilder.append(j);
        localStringBuilder.append(" lastVisibleItem: ");
        localStringBuilder.append(k);
        localStringBuilder.append(" exp_uins: ");
        localStringBuilder.append(localObject);
        localStringBuilder.append(" exp_reasons:");
        localStringBuilder.append(localArrayList1);
        localStringBuilder.append(" exp_positions:");
        localStringBuilder.append(localArrayList2);
        localStringBuilder.append(" algh_ids:");
        localStringBuilder.append(localArrayList3);
        QLog.d("ConnectsExplorationFriendAdapter", 2, localStringBuilder.toString());
      }
      if (!((ArrayList)localObject).isEmpty()) {
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (ArrayList)localObject, localArrayList1, localArrayList2, localArrayList3, 0, "4");
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
    MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)getItem(paramInt);
    Object localObject1;
    if ((localMayKnowRecommend instanceof ConnectsExplorationBanner))
    {
      localObject1 = new ConnectsExplorationFriendAdapter.BannerViewHolder();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561512, (ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1);
      ((ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369294));
      ((ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1).b = ((TextView)paramView.findViewById(2131379679));
      ((ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379930));
      ((ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363864));
      ((ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramView.setTag(localObject1);
      ((INewFriendApi)QRoute.api(INewFriendApi.class)).updateItemBgKeepPadding(((ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1).leftView, false);
      a((ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1);
      paramView.setTag(-1, Integer.valueOf(paramInt));
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, localMayKnowRecommend, (SwipRightMenuBuilder.SwipItemBaseHolder)localObject1, this);
      ((ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1).leftView.setTag(localMayKnowRecommend);
      paramView.setOnClickListener(this);
      ((ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1).leftView.setOnClickListener(this);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "info_add_exp", 2, 0, "", "", "", "");
      localObject1 = null;
    }
    for (;;)
    {
      break;
      if ((paramView != null) && ((paramView.getTag() instanceof ConnectsExplorationFriendAdapter.RecFriendViewHolder)))
      {
        localObject1 = (ConnectsExplorationFriendAdapter.RecFriendViewHolder)paramView.getTag();
      }
      else
      {
        localObject1 = new ConnectsExplorationFriendAdapter.RecFriendViewHolder();
        paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561511, (ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).d = ((TextView)paramView.findViewById(2131370723));
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramView.findViewById(2131379273));
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361799));
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371877));
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).b = ((Button)paramView.findViewById(2131376477));
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376485));
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).e = ((TextView)paramView.findViewById(2131378068));
        paramView.setTag(localObject1);
        if ((((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
          ((ThemeImageView)((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView).setSupportMaskView(true);
        }
        ((INewFriendApi)QRoute.api(INewFriendApi.class)).updateItemBgKeepPadding(((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).leftView, false);
      }
    }
    if (localObject1 != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(512);
      ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_JavaLangString = localMayKnowRecommend.uin;
      ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = localMayKnowRecommend;
      Object localObject2 = localMayKnowRecommend.getDisplayName(this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a());
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        if (AppSetting.d) {
          localStringBuilder.append((String)localObject2);
        }
      }
      else
      {
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      paramView.setTag(-1, Integer.valueOf(paramInt));
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, localMayKnowRecommend, (SwipRightMenuBuilder.SwipItemBaseHolder)localObject1, this);
      ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).leftView.setTag(localMayKnowRecommend);
      localObject2 = new StringBuilder();
      if (!TextUtils.isEmpty(localMayKnowRecommend.category))
      {
        ((StringBuilder)localObject2).append(localMayKnowRecommend.category);
        ((StringBuilder)localObject2).append(" ");
      }
      if (!TextUtils.isEmpty(localMayKnowRecommend.recommendReason)) {
        ((StringBuilder)localObject2).append(localMayKnowRecommend.recommendReason);
      }
      localObject2 = ((StringBuilder)localObject2).toString();
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).d.setVisibility(0);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).d.setText((CharSequence)localObject2);
        if (AppSetting.d)
        {
          localStringBuilder.append(",");
          localStringBuilder.append((String)localObject2);
        }
      }
      else
      {
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).d.setVisibility(8);
      }
      ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(RecommendLabel.convertToRecommendLabel(localMayKnowRecommend.msgLabel), localMayKnowRecommend.gender, localMayKnowRecommend.age);
      if (localMayKnowRecommend.friendStatus == 0)
      {
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).b.setOnClickListener(this);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).b.setVisibility(0);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).b.setTag(localMayKnowRecommend);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).b.setText(HardCodeUtil.a(2131689589));
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        if (AppSetting.d)
        {
          localStringBuilder.append(",点击添加");
          ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).b.setContentDescription(HardCodeUtil.a(2131689589));
        }
      }
      else if (localMayKnowRecommend.friendStatus == 1)
      {
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).b.setVisibility(8);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(2131718222);
        if (AppSetting.d)
        {
          localStringBuilder.append(",等待验证");
          ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718222));
        }
      }
      else
      {
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).b.setVisibility(8);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(2131689988);
        if (AppSetting.d)
        {
          localStringBuilder.append(",已添加");
          ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689988));
        }
      }
      if (AppSetting.d) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      paramView.setOnClickListener(this);
      ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).leftView.setOnClickListener(this);
      ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(1, ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_JavaLangString));
      a(paramView, localMayKnowRecommend.bHighLight);
      a(((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).e, localMayKnowRecommend);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void hideMenuPop() {}
  
  public void interceptTouchEvent(boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    int i = 1;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    switch (j)
    {
    default: 
      break;
    case 2131376644: 
      localObject1 = (MayKnowRecommend)paramView.getTag();
      if ((localObject1 instanceof ConnectsExplorationBanner))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "info_add_clk", 2, 0, "", "", "", "");
        localObject1 = new Intent(paramView.getContext(), FriendProfileMoreInfoActivity.class);
        paramView.getContext().startActivity((Intent)localObject1);
      }
      else if (localObject1 != null)
      {
        localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((localObject2 == null) || (!((FriendsManager)localObject2).b(((MayKnowRecommend)localObject1).uin))) {
          i = 110;
        }
        localObject2 = new AllInOne(((MayKnowRecommend)localObject1).uin, i);
        localObject3 = ((MayKnowRecommend)localObject1).getRecommendName(this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a());
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          ((AllInOne)localObject2).recommendName = ((String)localObject3);
        }
        if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).nick)) {
          ((AllInOne)localObject2).nickname = ((MayKnowRecommend)localObject1).nick;
        }
        ((AllInOne)localObject2).profileEntryType = 88;
        localObject3 = ContactReportUtils.a(((MayKnowRecommend)localObject1).msgLabel);
        Bundle localBundle = new Bundle();
        localBundle.putString("recommend_entry_type", "4");
        localBundle.putInt("key_display_type", 0);
        localBundle.putString("recommend_reason", ((MayKnowRecommend)localObject1).recommendReason);
        localBundle.putInt("recommend_pos", this.jdField_a_of_type_JavaUtilList.indexOf(localObject1));
        localBundle.putByteArray("recommend_algh_id", ((MayKnowRecommend)localObject1).algBuffer);
        localBundle.putString("recommend_label", (String)localObject3);
        localBundle.putInt("tabID", this.jdField_b_of_type_Int);
        ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, (AllInOne)localObject2, localBundle);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onClick_ open profile item uin = ");
          ((StringBuilder)localObject2).append(((MayKnowRecommend)localObject1).uin);
          QLog.d("ConnectsExplorationFriendAdapter", 2, ((StringBuilder)localObject2).toString());
        }
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject1).uin, "frd_list_clk", this.jdField_b_of_type_Int, 0, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, (String)localObject3, 0, "4");
      }
      break;
    case 2131376477: 
      localObject1 = (MayKnowRecommend)paramView.getTag();
      if (localObject1 != null)
      {
        localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((!((FriendsManager)localObject2).b(((MayKnowRecommend)localObject1).uin)) && (!((FriendsManager)localObject2).d(((MayKnowRecommend)localObject1).uin)))
        {
          boolean bool = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false);
          localObject2 = ((MayKnowRecommend)localObject1).getDisplayName(this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a());
          i = this.jdField_b_of_type_Int;
          localObject2 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.jdField_a_of_type_AndroidContentContext, 1, ((MayKnowRecommend)localObject1).uin, null, 3045, i, (String)localObject2, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131689589), null);
          ((Intent)localObject2).putExtra("key_param_age_area", ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, ((MayKnowRecommend)localObject1).gender, ((MayKnowRecommend)localObject1).age, ((MayKnowRecommend)localObject1).country, ((MayKnowRecommend)localObject1).province, ((MayKnowRecommend)localObject1).city));
          ((Intent)localObject2).putExtra("from_babyq", bool);
          ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend((BaseActivity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject2);
        }
        else if (((FriendsManager)localObject2).b(((MayKnowRecommend)localObject1).uin))
        {
          ((MayKnowRecommend)localObject1).friendStatus = 2;
          notifyDataSetChanged();
        }
        else
        {
          ((MayKnowRecommend)localObject1).friendStatus = 1;
          notifyDataSetChanged();
        }
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject1).uin, "frd_list_add", this.jdField_b_of_type_Int, 1, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 0, "4");
      }
      break;
    case 2131370801: 
      if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext;
        QQToast.a((Context)localObject1, ((Context)localObject1).getResources().getString(2131692183), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
      }
      else
      {
        localObject1 = (MayKnowRecommend)paramView.getTag();
        if (localObject1 != null)
        {
          localObject2 = ((MayKnowRecommend)localObject1).uin;
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("onClick_ delete item uin = ");
            ((StringBuilder)localObject3).append((String)localObject2);
            QLog.d("ConnectsExplorationFriendAdapter", 2, ((StringBuilder)localObject3).toString());
          }
          ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).cancelMayKnowRecommend((String)localObject2);
          this.jdField_a_of_type_JavaUtilList.remove(localObject1);
          notifyDataSetChanged();
          ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, "frd_list_dlt", this.jdField_b_of_type_Int, 0, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, ContactReportUtils.a(((MayKnowRecommend)localObject1).msgLabel), 0, "4");
        }
      }
      break;
    case 2131367892: 
      if (NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5D4", "0X800A5D4", 0, 0, "2", "", "", "");
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.b(true);
      }
      else
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext;
        QQToast.a((Context)localObject1, ((Context)localObject1).getResources().getString(2131692183), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
      }
      break;
    case 2131363864: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "info_add_clk", 2, 0, "", "", "", "");
      localObject1 = new Intent(paramView.getContext(), FriendProfileMoreInfoActivity.class);
      paramView.getContext().startActivity((Intent)localObject1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
    this.jdField_a_of_type_Int = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationFriendAdapter
 * JD-Core Version:    0.7.0.1
 */