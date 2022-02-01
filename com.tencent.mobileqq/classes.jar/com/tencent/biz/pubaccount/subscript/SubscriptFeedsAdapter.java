package com.tencent.biz.pubaccount.subscript;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SubscriptionFeed;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SubscriptionFeedItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.XListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SubscriptFeedsAdapter
  extends BaseAdapter
  implements SubscriptPicManager.ImageHostListener, DecodeTaskCompletionListener
{
  public static int a = 0;
  public static int b = 1;
  public static int c = 2;
  public static int d = 0;
  public static int e = 1;
  private static int h = 3;
  private float jdField_a_of_type_Float = 0.0F;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private SubscriptPicManager jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager;
  private SubscriptRecommendController jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController;
  private RecentFaceDecoder jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List<SubscriptionFeed> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  private float jdField_b_of_type_Float = 0.0F;
  private List<ReadInJoyArticle> jdField_b_of_type_JavaUtilList = new ArrayList();
  public boolean b;
  private float jdField_c_of_type_Float = 0.0F;
  private List<Object> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean = false;
  private float jdField_d_of_type_Float = 0.0F;
  private boolean jdField_d_of_type_Boolean = false;
  public int f = -1;
  public int g = -1;
  private final int i = 10;
  private int j = 0;
  
  public SubscriptFeedsAdapter(Activity paramActivity, QQAppInterface paramQQAppInterface, XListView paramXListView, LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidAppActivity.getResources();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder = new RecentFaceDecoder(paramQQAppInterface, this, false);
    this.jdField_c_of_type_Boolean = ThemeUtil.isInNightMode(paramQQAppInterface);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298064);
    this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298066);
    this.jdField_c_of_type_Float = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298065);
    this.jdField_d_of_type_Float = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298063);
  }
  
  private void a(SubscriptFeedsAdapter.FeedItemCellHolder paramFeedItemCellHolder, String paramString)
  {
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localBitmap == null)
    {
      paramFeedItemCellHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(1008, paramString));
      return;
    }
    paramFeedItemCellHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_JavaUtilHashSet.isEmpty()) {
      ReportController.b(null, "CliOper", "", "", "0X8006110", "0X8006110", 0, this.jdField_a_of_type_JavaUtilHashSet.size(), 0, "", "", "", "");
    }
    int k = this.j;
    if (k > 0) {
      ReportController.b(null, "CliOper", "", "", "0X8006154", "0X8006154", 0, k, 0, "", "", "", "");
    }
    if (this.jdField_d_of_type_Boolean) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006431", "0X8006431", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    this.jdField_a_of_type_JavaUtilHashSet = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = null;
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager = null;
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a();
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(SubscriptPicManager paramSubscriptPicManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager = paramSubscriptPicManager;
  }
  
  public void a(SubscriptRecommendController paramSubscriptRecommendController)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController = paramSubscriptRecommendController;
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
  }
  
  public void a(List<SubscriptionFeed> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public boolean a(ImageView paramImageView)
  {
    boolean bool2 = paramImageView.getTag(2131378100).equals(Integer.valueOf(jdField_b_of_type_Int));
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    if (paramImageView.getTag(2131378100).equals(Integer.valueOf(jdField_a_of_type_Int)))
    {
      int m = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      int k = 0;
      while (k < m)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(k).getTag();
        if ((localObject != null) && ((localObject instanceof SubscriptFeedsAdapter.FeedItemCellHolder)) && (((SubscriptFeedsAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_JavaLangString.equals(paramImageView.getTag(2131378101)))) {
          return true;
        }
        k += 1;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public void b()
  {
    int k = this.f;
    int n = 0;
    if ((k == 1) && (this.jdField_a_of_type_Boolean)) {
      k = 1;
    } else {
      k = 0;
    }
    int m = n;
    if (this.g == 1)
    {
      m = n;
      if (this.jdField_b_of_type_Boolean) {
        m = 1;
      }
    }
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    if ((k != 0) && (this.jdField_b_of_type_JavaUtilList.size() > 0)) {
      if (this.jdField_c_of_type_JavaUtilList.size() <= 6) {
        this.jdField_c_of_type_JavaUtilList.add("ReadInJoyArticle");
      } else {
        this.jdField_c_of_type_JavaUtilList.add(6, "ReadInJoyArticle");
      }
    }
    if (m != 0)
    {
      if (this.jdField_c_of_type_JavaUtilList.size() <= 3)
      {
        this.jdField_c_of_type_JavaUtilList.add("SubscriptRecommendController");
        return;
      }
      this.jdField_c_of_type_JavaUtilList.add(3, "SubscriptRecommendController");
    }
  }
  
  public void b(List<ReadInJoyArticle> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
  }
  
  public int getCount()
  {
    return this.jdField_c_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_c_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    int k = h;
    Object localObject = this.jdField_c_of_type_JavaUtilList.get(paramInt);
    if ((localObject instanceof SubscriptionFeed)) {
      return jdField_a_of_type_Int;
    }
    boolean bool = localObject instanceof String;
    if ((bool) && (localObject.equals("SubscriptRecommendController"))) {
      return jdField_c_of_type_Int;
    }
    paramInt = k;
    if (bool)
    {
      paramInt = k;
      if (localObject.equals("ReadInJoyArticle")) {
        paramInt = jdField_b_of_type_Int;
      }
    }
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_c_of_type_JavaUtilList.size()))
    {
      int n = getItemViewType(paramInt);
      int m = 0;
      Object localObject3;
      int k;
      if (paramView == null)
      {
        if (n == jdField_a_of_type_Int)
        {
          localObject1 = new SubscriptFeedsAdapter.FeedItemCellHolder(this);
          localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560398, null);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((View)localObject2).findViewById(2131378089));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131378103));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131378108));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131376386));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject2).findViewById(2131380207));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131366671));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131366643));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131366647));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject2).findViewById(2131370815));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).jdField_b_of_type_AndroidWidgetButton = ((Button)((View)localObject2).findViewById(2131370821));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).jdField_c_of_type_AndroidWidgetButton = ((Button)((View)localObject2).findViewById(2131370820));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).d = ((Button)((View)localObject2).findViewById(2131370802));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, (View)localObject2);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localObject3 = ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView;
          if (this.jdField_c_of_type_Boolean)
          {
            paramView = this.jdField_a_of_type_AndroidContentResResources;
            k = 2131166105;
          }
          else
          {
            paramView = this.jdField_a_of_type_AndroidContentResResources;
            k = 2131166104;
          }
          ((TextView)localObject3).setTextColor(paramView.getColor(k));
          localObject3 = ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView;
          if (this.jdField_c_of_type_Boolean)
          {
            paramView = this.jdField_a_of_type_AndroidContentResResources;
            k = 2131166111;
          }
          else
          {
            paramView = this.jdField_a_of_type_AndroidContentResResources;
            k = 2131166110;
          }
          ((TextView)localObject3).setTextColor(paramView.getColor(k));
          localObject3 = ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView;
          if (this.jdField_c_of_type_Boolean)
          {
            paramView = this.jdField_a_of_type_AndroidContentResResources;
            k = 2131166114;
          }
          else
          {
            paramView = this.jdField_a_of_type_AndroidContentResResources;
            k = 2131166113;
          }
          ((TextView)localObject3).setTextColor(paramView.getColor(k));
          paramView = (View)localObject2;
        }
        else if (n == jdField_b_of_type_Int)
        {
          localObject1 = new SubscriptFeedsAdapter.KandianItemCellHolder(this, null);
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560400, null);
          ((SubscriptFeedsAdapter.KandianItemCellHolder)localObject1).jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131369622));
          ((SubscriptFeedsAdapter.KandianItemCellHolder)localObject1).jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localObject2 = (TextView)((SubscriptFeedsAdapter.KandianItemCellHolder)localObject1).jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369623);
          if (!this.jdField_c_of_type_Boolean) {
            k = 2130843356;
          } else {
            k = 2130843357;
          }
          ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 0, k, 0);
          ((SubscriptFeedsAdapter.KandianItemCellHolder)localObject1).jdField_a_of_type_JavaUtilArrayList.add((ViewGroup)paramView.findViewById(2131369608));
          ((SubscriptFeedsAdapter.KandianItemCellHolder)localObject1).jdField_a_of_type_JavaUtilArrayList.add((ViewGroup)paramView.findViewById(2131369609));
          ((SubscriptFeedsAdapter.KandianItemCellHolder)localObject1).jdField_a_of_type_JavaUtilArrayList.add((ViewGroup)paramView.findViewById(2131369610));
          ((SubscriptFeedsAdapter.KandianItemCellHolder)localObject1).jdField_a_of_type_JavaUtilArrayList.add((ViewGroup)paramView.findViewById(2131369611));
          int i1 = ((SubscriptFeedsAdapter.KandianItemCellHolder)localObject1).jdField_a_of_type_JavaUtilArrayList.size();
          localObject2 = this.jdField_a_of_type_AndroidContentResResources;
          if (!this.jdField_c_of_type_Boolean) {
            k = 2131166120;
          } else {
            k = 2131166121;
          }
          int i2 = ((Resources)localObject2).getColor(k);
          k = 0;
          while (k < i1)
          {
            localObject2 = (ViewGroup)((SubscriptFeedsAdapter.KandianItemCellHolder)localObject1).jdField_a_of_type_JavaUtilArrayList.get(k);
            ((ViewGroup)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            ((ViewGroup)localObject2).setTag(Integer.valueOf(k));
            ((TextView)((ViewGroup)localObject2).findViewById(2131363010)).setTextColor(i2);
            k += 1;
          }
          paramView.setTag(-3, Integer.valueOf(0));
        }
        else if (n == jdField_c_of_type_Int)
        {
          localObject1 = new SubscriptFeedsAdapter.SubscriptRecommendHolder(this, null);
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560402, null);
          this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.a(paramView);
          this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.b();
          this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.h();
          paramView.setTag(-3, Integer.valueOf(0));
          this.jdField_d_of_type_Boolean = true;
        }
        else
        {
          localObject1 = null;
        }
        if (paramView != null) {
          paramView.setTag(localObject1);
        }
      }
      if (paramView != null)
      {
        Object localObject4;
        Object localObject5;
        if (n == jdField_a_of_type_Int)
        {
          paramView.setTag(2131378095, Integer.valueOf(paramInt));
          localObject4 = (SubscriptFeedsAdapter.FeedItemCellHolder)paramView.getTag();
          localObject1 = (SubscriptionFeed)getItem(paramInt);
          localObject2 = this.jdField_a_of_type_JavaUtilHashSet;
          if (localObject2 != null) {
            ((HashSet)localObject2).add(((SubscriptionFeed)localObject1).jdField_a_of_type_JavaLangString);
          }
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_a_of_type_JavaLangString = ((SubscriptionFeed)localObject1).jdField_a_of_type_JavaLangString;
          a((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4, ((SubscriptionFeed)localObject1).jdField_a_of_type_JavaLangString);
          localObject3 = TroopBarAssistantManager.a().a(((SubscriptionFeed)localObject1).jdField_a_of_type_JavaLangString);
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_a_of_type_AndroidWidgetTextView.setText(((SubscriptionFeed)localObject1).jdField_a_of_type_JavaLangString);
          } else {
            ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
          }
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView.setText(TimeManager.a().a(((SubscriptionFeed)localObject1).jdField_a_of_type_JavaLangString, ((SubscriptionFeed)localObject1).jdField_a_of_type_Long));
          if (((SubscriptionFeed)localObject1).jdField_b_of_type_Int > 0) {
            k = 3;
          } else {
            k = 0;
          }
          CustomWidgetUtil.a(((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, k, ((SubscriptionFeed)localObject1).jdField_b_of_type_Int, 2130850770, 99, null);
          if (((SubscriptionFeed)localObject1).jdField_a_of_type_JavaUtilList.size() > 0)
          {
            localObject2 = (SubscriptionFeedItem)((SubscriptionFeed)localObject1).jdField_a_of_type_JavaUtilList.get(0);
            if (((SubscriptionFeedItem)localObject2).jdField_a_of_type_Int == 0)
            {
              ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_c_of_type_AndroidWidgetTextView.setMaxLines(1);
              ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_c_of_type_AndroidWidgetTextView.setText(new QQText(((SubscriptionFeedItem)localObject2).c.replaceFirst("^\\s+", ""), 3, 20));
              ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
              ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            }
            else
            {
              if (((SubscriptionFeedItem)localObject2).jdField_a_of_type_Int == 1)
              {
                ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_c_of_type_AndroidWidgetTextView.setMaxLines(2);
                ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_c_of_type_AndroidWidgetTextView.setText(((SubscriptionFeedItem)localObject2).b.replaceFirst("^\\s+", ""));
                ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
                if (TextUtils.isEmpty(((SubscriptionFeedItem)localObject2).g)) {
                  ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
                } else {
                  ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
                }
                ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_b_of_type_AndroidWidgetImageView.setTag(2131378101, ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_a_of_type_JavaLangString);
                ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_b_of_type_AndroidWidgetImageView.setTag(2131378100, Integer.valueOf(jdField_a_of_type_Int));
                localObject5 = ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
                this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager.a(((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(((SubscriptionFeedItem)localObject2).jdField_a_of_type_JavaLangString, 1, ((SubscriptionFeed)localObject1).jdField_a_of_type_JavaLangString), ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_b_of_type_AndroidWidgetImageView, ((ViewGroup.LayoutParams)localObject5).width, ((ViewGroup.LayoutParams)localObject5).height, this);
                if ((((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_b_of_type_AndroidWidgetImageView.getDrawable() instanceof URLDrawable))
                {
                  localObject2 = (URLDrawable)((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_b_of_type_AndroidWidgetImageView.getDrawable();
                  if (paramInt >= 10) {
                    ((URLDrawable)localObject2).setAutoDownload(false);
                  }
                }
              }
              else
              {
                if (((SubscriptionFeedItem)localObject2).jdField_a_of_type_Int != 2) {
                  break label1536;
                }
                ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_c_of_type_AndroidWidgetTextView.setMaxLines(1);
                ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_c_of_type_AndroidWidgetTextView.setText(2131696512);
                ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
                ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
                ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_b_of_type_AndroidWidgetImageView.setTag(2131378101, ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_a_of_type_JavaLangString);
                ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_b_of_type_AndroidWidgetImageView.setTag(2131378100, Integer.valueOf(jdField_a_of_type_Int));
                localObject5 = ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
                this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager.a(((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(((SubscriptionFeedItem)localObject2).jdField_a_of_type_JavaNetURL.toString(), 1, ((SubscriptionFeed)localObject1).jdField_a_of_type_JavaLangString), ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_b_of_type_AndroidWidgetImageView, ((ViewGroup.LayoutParams)localObject5).width, ((ViewGroup.LayoutParams)localObject5).height, this);
              }
              break label1617;
              label1536:
              ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_c_of_type_AndroidWidgetTextView.setMaxLines(1);
              ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_c_of_type_AndroidWidgetTextView.setText(2131696513);
              ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
              ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            }
          }
          else
          {
            localObject2 = localObject1;
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              localObject1 = localObject2;
              if (QLog.isColorLevel())
              {
                QLog.w("SubscriptFeedsAdapter", 2, "getView feed.mItems.size() == 0, is error!!");
                localObject1 = localObject2;
              }
            }
          }
          label1617:
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_a_of_type_AndroidViewViewGroup.setTag(2131378092, Integer.valueOf(((SubscriptionFeed)localObject1).jdField_b_of_type_Int));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_a_of_type_AndroidViewViewGroup.setTag(2131378101, ((SubscriptionFeed)localObject1).jdField_a_of_type_JavaLangString);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_a_of_type_AndroidViewViewGroup.setTag(2131378094, localObject3);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_a_of_type_AndroidViewViewGroup.setTag(2131378093, Integer.valueOf(jdField_d_of_type_Int));
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131378092, localObject1);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_a_of_type_AndroidWidgetButton.setTag(2131378101, ((SubscriptionFeed)localObject1).jdField_a_of_type_JavaLangString);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_b_of_type_AndroidWidgetButton.setTag(2131378101, ((SubscriptionFeed)localObject1).jdField_a_of_type_JavaLangString);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_c_of_type_AndroidWidgetButton.setTag(2131378101, ((SubscriptionFeed)localObject1).jdField_a_of_type_JavaLangString);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_c_of_type_AndroidWidgetButton.setTag(2131378094, localObject3);
          ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).d.setTag(2131378101, ((SubscriptionFeed)localObject1).jdField_a_of_type_JavaLangString);
          if (!TroopBarAssistantManager.a().a(((SubscriptionFeed)localObject1).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
          {
            if (!this.jdField_c_of_type_Boolean) {
              ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130843352);
            } else {
              ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130843354);
            }
            paramView.setTag(-3, Integer.valueOf((int)(this.jdField_a_of_type_Float + this.jdField_c_of_type_Float + this.jdField_d_of_type_Float)));
            ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
          }
          else
          {
            if (!this.jdField_c_of_type_Boolean) {
              ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130843353);
            } else {
              ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130843355);
            }
            paramView.setTag(-3, Integer.valueOf((int)(this.jdField_b_of_type_Float + this.jdField_c_of_type_Float + this.jdField_d_of_type_Float)));
            ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject4).jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
          }
        }
        else
        {
          localObject1 = "";
          if (n == jdField_b_of_type_Int)
          {
            paramView.setTag(2131378095, Integer.valueOf(paramInt));
            this.j += 1;
            localObject2 = (SubscriptFeedsAdapter.KandianItemCellHolder)paramView.getTag();
            n = ((SubscriptFeedsAdapter.KandianItemCellHolder)localObject2).jdField_a_of_type_JavaUtilArrayList.size();
            k = m;
            while (k < n)
            {
              localObject4 = (ViewGroup)((SubscriptFeedsAdapter.KandianItemCellHolder)localObject2).jdField_a_of_type_JavaUtilArrayList.get(k);
              localObject3 = (TextView)((ViewGroup)localObject4).findViewById(2131363010);
              localObject4 = (ImageView)((ViewGroup)localObject4).findViewById(2131363009);
              if (k < this.jdField_b_of_type_JavaUtilList.size())
              {
                localObject5 = (ReadInJoyArticle)this.jdField_b_of_type_JavaUtilList.get(k);
                ((TextView)localObject3).setText(((ReadInJoyArticle)localObject5).mTitle.replaceFirst("^\\s+", (String)localObject1));
                ((ImageView)localObject4).setTag(2131378100, Integer.valueOf(jdField_b_of_type_Int));
                localObject3 = (WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window");
                this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager.a(((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(((ReadInJoyArticle)localObject5).mFirstPagePicUrl, 1), (ImageView)localObject4, ((WindowManager)localObject3).getDefaultDisplay().getWidth(), ((WindowManager)localObject3).getDefaultDisplay().getHeight(), this);
              }
              k += 1;
            }
          }
          k = jdField_c_of_type_Int;
        }
        localObject1 = paramView;
        localObject2 = paramView;
        break label2203;
      }
    }
    Object localObject2 = null;
    Object localObject1 = paramView;
    label2203:
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject2;
  }
  
  public int getViewTypeCount()
  {
    return h;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.jdField_a_of_type_ComTencentWidgetXListView != null) && (paramString != null))
    {
      if (paramString.length() == 0) {
        return;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramBitmap = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if ((paramBitmap != null) && ((paramBitmap instanceof SubscriptFeedsAdapter.FeedItemCellHolder)))
        {
          paramBitmap = (SubscriptFeedsAdapter.FeedItemCellHolder)paramBitmap;
          if (paramString.equals(paramBitmap.jdField_a_of_type_JavaLangString)) {
            a(paramBitmap, paramString);
          }
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsAdapter
 * JD-Core Version:    0.7.0.1
 */