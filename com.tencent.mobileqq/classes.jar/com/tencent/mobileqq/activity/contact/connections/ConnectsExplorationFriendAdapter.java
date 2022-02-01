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
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendBaseBuilder;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
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
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366316));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368139);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130839446);
    }
    paramXListView = (ThemeImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368135);
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
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  private URLDrawable a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    URLDrawable localURLDrawable;
    do
    {
      return localObject;
      localObject = URLDrawable.URLDrawableOptions.obtain();
      if (((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable == null) {
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      }
      if (((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable == null) {
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
      }
      localURLDrawable = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      localObject = localURLDrawable;
    } while (!QLog.isColorLevel());
    QLog.d("ConnectsExplorationFriendAdapter", 2, "getDrawable downLoadUrl ->" + paramString);
    return localURLDrawable;
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
  
  private void a(ConnectsExplorationFriendAdapter.BannerViewHolder paramBannerViewHolder)
  {
    if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
    {
      paramBannerViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839445);
      paramBannerViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#12B7F5"));
      paramBannerViewHolder.b.setTextColor(Color.parseColor("#7F12B7F5"));
      paramBannerViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a("https://qzonestyle.gtimg.cn/aoi/sola/20190920103348_DVTS7XhGQJ.png"));
      return;
    }
    paramBannerViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839446);
    paramBannerViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(102, 255, 255, 255));
    paramBannerViewHolder.b.setTextColor(Color.argb(102, 255, 255, 255));
    paramBannerViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a("https://qzonestyle.gtimg.cn/aoi/sola/20190920103348_9H32GY0LpT.png"));
  }
  
  protected View a(Context paramContext, int paramInt, ConnectsExplorationFriendAdapter.BannerViewHolder paramBannerViewHolder)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.a(paramContext, localView, paramBannerViewHolder, -1);
  }
  
  protected View a(Context paramContext, int paramInt, ConnectsExplorationFriendAdapter.RecFriendViewHolder paramRecFriendViewHolder)
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
    if (this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder != null) {}
    for (int i = this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.a(paramContext, paramView, paramInt, paramObject, paramSwipItemBaseHolder, paramOnClickListener);; i = 0)
    {
      int j = paramView.getScrollX();
      if ((paramInt >= 0) && (this.jdField_a_of_type_Int == paramInt)) {
        paramView.scrollTo(i, 0);
      }
      while (j == 0) {
        return;
      }
      paramView.scrollTo(0, 0);
      return;
    }
  }
  
  public void a(TextView paramTextView, MayKnowRecommend paramMayKnowRecommend)
  {
    if (paramMayKnowRecommend == null) {
      return;
    }
    String str = paramMayKnowRecommend.getDisplayName(this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a());
    if ((!TextUtils.isEmpty(paramMayKnowRecommend.mobile_name)) && (!str.equals(paramMayKnowRecommend.mobile_name)))
    {
      paramTextView.setText("(" + paramMayKnowRecommend.mobile_name + ")");
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
    if (QLog.isColorLevel()) {
      QLog.d("ConnectsExplorationFriendAdapter", 2, "reloadRecommendData " + this.jdField_b_of_type_Int + " " + paramBoolean);
    }
    if ((this.jdField_b_of_type_Int != 23) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.c()))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698976);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5D3", "0X800A5D3", 0, 0, "2", "", "", "");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ConnectsExplorationFriendAdapter.7(this, paramBoolean));
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectsExplorationFriendAdapter", 2, "userInfoState " + paramBoolean);
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
      if (this.jdField_a_of_type_JavaUtilList.size() > 4) {
        break label202;
      }
      this.jdField_a_of_type_JavaUtilList.add(localObject);
    }
    for (;;)
    {
      if (paramBoolean) {
        notifyDataSetChanged();
      }
      return true;
      label202:
      this.jdField_a_of_type_JavaUtilList.add(4, localObject);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectsExplorationFriendAdapter", 2, "onResume firstVisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition() + " lastvisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition());
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
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView != null) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      int j = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      int k = this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      int i = j;
      if (i <= k)
      {
        if ((i < 0) || (i >= this.jdField_a_of_type_JavaUtilList.size()) || (this.jdField_a_of_type_JavaUtilList.get(i) == null) || ((this.jdField_a_of_type_JavaUtilList.get(i) instanceof ConnectsExplorationBanner))) {}
        for (;;)
        {
          i += 1;
          break;
          localArrayList1.add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).uin);
          localArrayList2.add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).recommendReason);
          localArrayList3.add(Integer.valueOf(i));
          localArrayList4.add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).algBuffer);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ConnectsExplorationFriendAdapter", 2, "reportRecommendFrdExpose firstVisibleItem: " + j + " lastVisibleItem: " + k + " exp_uins: " + localArrayList1 + " exp_reasons:" + localArrayList2 + " exp_positions:" + localArrayList3 + " algh_ids:" + localArrayList4);
      }
      if (!localArrayList1.isEmpty()) {
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, localArrayList1, localArrayList2, localArrayList3, localArrayList4, 0, "4");
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
    MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)getItem(paramInt);
    Object localObject1;
    StringBuilder localStringBuilder;
    if ((localMayKnowRecommend instanceof ConnectsExplorationBanner))
    {
      localObject1 = new ConnectsExplorationFriendAdapter.BannerViewHolder();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561661, (ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1);
      ((ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369584));
      ((ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1).b = ((TextView)paramView.findViewById(2131380359));
      ((ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380651));
      ((ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363938));
      ((ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramView.setTag(localObject1);
      NewFriendBaseBuilder.b(((ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1).g, false);
      a((ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1);
      paramView.setTag(-1, Integer.valueOf(paramInt));
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, localMayKnowRecommend, (SwipRightMenuBuilder.SwipItemBaseHolder)localObject1, this);
      ((ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1).g.setTag(localMayKnowRecommend);
      paramView.setOnClickListener(this);
      ((ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1).g.setOnClickListener(this);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "info_add_exp", 2, 0, "", "", "", "");
      localObject1 = null;
      if (localObject1 != null)
      {
        localStringBuilder = new StringBuilder(512);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_JavaLangString = localMayKnowRecommend.uin;
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = localMayKnowRecommend;
        Object localObject2 = localMayKnowRecommend.getDisplayName(this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a());
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label841;
        }
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        if (AppSetting.d) {
          localStringBuilder.append((String)localObject2);
        }
        label307:
        paramView.setTag(-1, Integer.valueOf(paramInt));
        a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, localMayKnowRecommend, (SwipRightMenuBuilder.SwipItemBaseHolder)localObject1, this);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).g.setTag(localMayKnowRecommend);
        localObject2 = new StringBuilder();
        if (!TextUtils.isEmpty(localMayKnowRecommend.category)) {
          ((StringBuilder)localObject2).append(localMayKnowRecommend.category).append(" ");
        }
        if (!TextUtils.isEmpty(localMayKnowRecommend.recommendReason)) {
          ((StringBuilder)localObject2).append(localMayKnowRecommend.recommendReason);
        }
        localObject2 = ((StringBuilder)localObject2).toString();
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label854;
        }
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).d.setVisibility(0);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).d.setText((CharSequence)localObject2);
        if (AppSetting.d) {
          localStringBuilder.append(",").append((String)localObject2);
        }
        label454:
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(localMayKnowRecommend);
        if (localMayKnowRecommend.friendStatus != 0) {
          break label867;
        }
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).b.setOnClickListener(this);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).b.setVisibility(0);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).b.setTag(localMayKnowRecommend);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).b.setText(HardCodeUtil.a(2131689557));
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        if (AppSetting.d)
        {
          localStringBuilder.append(",点击添加");
          ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).b.setContentDescription(HardCodeUtil.a(2131689557));
        }
      }
    }
    for (;;)
    {
      if (AppSetting.d) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      paramView.setOnClickListener(this);
      ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).g.setOnClickListener(this);
      ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(1, ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_JavaLangString));
      a(paramView, localMayKnowRecommend.bHighLight);
      a(((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).e, localMayKnowRecommend);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      if ((paramView == null) || (!(paramView.getTag() instanceof ConnectsExplorationFriendAdapter.RecFriendViewHolder)))
      {
        localObject1 = new ConnectsExplorationFriendAdapter.RecFriendViewHolder();
        paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561660, (ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).d = ((TextView)paramView.findViewById(2131371099));
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramView.findViewById(2131379944));
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361796));
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372288));
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).b = ((Button)paramView.findViewById(2131376990));
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377001));
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).e = ((TextView)paramView.findViewById(2131378673));
        paramView.setTag(localObject1);
        if ((((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
          ((ThemeImageView)((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView).setSupportMaskView(true);
        }
        NewFriendBaseBuilder.b(((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).g, false);
        break;
      }
      localObject1 = (ConnectsExplorationFriendAdapter.RecFriendViewHolder)paramView.getTag();
      break;
      label841:
      ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label307;
      label854:
      ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).d.setVisibility(8);
      break label454;
      label867:
      if (localMayKnowRecommend.friendStatus == 1)
      {
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).b.setVisibility(8);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(2131718554);
        if (AppSetting.d)
        {
          localStringBuilder.append(",等待验证");
          ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718554));
        }
      }
      else
      {
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).b.setVisibility(8);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(2131690072);
        if (AppSetting.d)
        {
          localStringBuilder.append(",已添加");
          ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690072));
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
        Object localObject1 = (MayKnowRecommend)paramView.getTag();
        if (localObject1 != null)
        {
          Object localObject2 = ((MayKnowRecommend)localObject1).uin;
          if (QLog.isColorLevel()) {
            QLog.d("ConnectsExplorationFriendAdapter", 2, "onClick_ delete item uin = " + (String)localObject2);
          }
          ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).cancelMayKnowRecommend((String)localObject2);
          this.jdField_a_of_type_JavaUtilList.remove(localObject1);
          notifyDataSetChanged();
          ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, "frd_list_dlt", this.jdField_b_of_type_Int, 0, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, ContactReportUtils.a(((MayKnowRecommend)localObject1).msgLabel), 0, "4");
          continue;
          localObject1 = (MayKnowRecommend)paramView.getTag();
          if (localObject1 != null)
          {
            localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
            int i;
            if ((!((FriendsManager)localObject2).b(((MayKnowRecommend)localObject1).uin)) && (!((FriendsManager)localObject2).d(((MayKnowRecommend)localObject1).uin)))
            {
              boolean bool = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false);
              localObject2 = ((MayKnowRecommend)localObject1).getDisplayName(this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a());
              i = this.jdField_b_of_type_Int;
              localObject2 = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, ((MayKnowRecommend)localObject1).uin, null, 3045, i, (String)localObject2, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131689557), null);
              ((Intent)localObject2).putExtra("key_param_age_area", ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, ((MayKnowRecommend)localObject1).gender, ((MayKnowRecommend)localObject1).age, ((MayKnowRecommend)localObject1).country, ((MayKnowRecommend)localObject1).province, ((MayKnowRecommend)localObject1).city));
              ((Intent)localObject2).putExtra("from_babyq", bool);
              ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).startActivity((Intent)localObject2);
            }
            for (;;)
            {
              ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject1).uin, "frd_list_add", this.jdField_b_of_type_Int, 1, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 0, "4");
              break;
              if (((FriendsManager)localObject2).b(((MayKnowRecommend)localObject1).uin))
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
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "info_add_clk", 2, 0, "", "", "", "");
            localObject1 = new Intent(paramView.getContext(), FriendProfileMoreInfoActivity.class);
            paramView.getContext().startActivity((Intent)localObject1);
            continue;
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
              if ((localObject2 != null) && (((FriendsManager)localObject2).b(((MayKnowRecommend)localObject1).uin))) {}
              for (i = 1;; i = 110)
              {
                localObject2 = new ProfileActivity.AllInOne(((MayKnowRecommend)localObject1).uin, i);
                String str = ((MayKnowRecommend)localObject1).getRecommendName(this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a());
                if (!TextUtils.isEmpty(str)) {
                  ((ProfileActivity.AllInOne)localObject2).l = str;
                }
                if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).nick)) {
                  ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = ((MayKnowRecommend)localObject1).nick;
                }
                ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 88;
                str = ContactReportUtils.a(((MayKnowRecommend)localObject1).msgLabel);
                Bundle localBundle = new Bundle();
                localBundle.putString("recommend_entry_type", "4");
                localBundle.putInt("key_display_type", 0);
                localBundle.putString("recommend_reason", ((MayKnowRecommend)localObject1).recommendReason);
                localBundle.putInt("recommend_pos", this.jdField_a_of_type_JavaUtilList.indexOf(localObject1));
                localBundle.putByteArray("recommend_algh_id", ((MayKnowRecommend)localObject1).algBuffer);
                localBundle.putString("recommend_label", str);
                localBundle.putInt("tabID", this.jdField_b_of_type_Int);
                ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject2, localBundle);
                if (QLog.isColorLevel()) {
                  QLog.d("ConnectsExplorationFriendAdapter", 2, "onClick_ open profile item uin = " + ((MayKnowRecommend)localObject1).uin);
                }
                ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject1).uin, "frd_list_clk", this.jdField_b_of_type_Int, 0, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, str, 0, "4");
                break;
              }
              if (NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext))
              {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5D4", "0X800A5D4", 0, 0, "2", "", "", "");
                this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.b(true);
              }
              else
              {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692257), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
              }
            }
          }
        }
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
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationFriendAdapter
 * JD-Core Version:    0.7.0.1
 */