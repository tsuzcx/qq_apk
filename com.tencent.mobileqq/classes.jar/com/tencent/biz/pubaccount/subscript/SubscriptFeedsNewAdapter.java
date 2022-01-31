package com.tencent.biz.pubaccount.subscript;

import android.content.Context;
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
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyMessagesActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class SubscriptFeedsNewAdapter
  extends BaseAdapter
  implements FaceDecoder.DecodeTaskCompletionListener
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  private static int e;
  private float jdField_a_of_type_Float;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private KandianMergeManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager;
  private RecentFaceDecoder jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashSet jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private List jdField_c_of_type_JavaUtilList = new ArrayList();
  private float d;
  private int f;
  
  static
  {
    jdField_b_of_type_Int = 1;
    e = 3;
    jdField_d_of_type_Int = 1;
  }
  
  public SubscriptFeedsNewAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder = new RecentFaceDecoder(paramQQAppInterface, this, false);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131560134);
    this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131560135);
    this.jdField_c_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131560136);
    this.jdField_d_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131560137);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161));
    b();
  }
  
  private void a(SubscriptFeedsNewAdapter.FeedItemCellHolder paramFeedItemCellHolder, String paramString)
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
    if (!this.jdField_a_of_type_JavaUtilHashSet.isEmpty())
    {
      ReportController.b(null, "CliOper", "", "", "0X8006110", "0X8006110", 0, this.jdField_a_of_type_JavaUtilHashSet.size(), 0, "", "", "", "");
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label128;
        }
        String str = (String)localIterator.next();
        Object localObject1 = "";
        try
        {
          Object localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("folder_status", ReadInJoyUtils.jdField_d_of_type_Int);
          localObject2 = ((JSONObject)localObject2).toString();
          localObject1 = localObject2;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
        PublicAccountReportUtils.a(null, str, "0X80081C7", "0X80081C7", 0, 0, "", "", "", (String)localObject1, false);
      }
    }
    label128:
    if (this.f > 0) {
      ReportController.b(null, "CliOper", "", "", "0X8006154", "0X8006154", 0, this.f, 0, "", "", "", "");
    }
    if (this.jdField_b_of_type_Boolean) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006431", "0X8006431", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    this.jdField_a_of_type_JavaUtilHashSet = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a();
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList = null;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
  }
  
  public void a(List paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void b()
  {
    if (this.jdField_c_of_type_JavaUtilList.size() > 0) {
      this.jdField_c_of_type_JavaUtilList.clear();
    }
    ArrayList localArrayList = new ArrayList();
    SubscriptFeedsNewAdapter.Msg210Feed localMsg210Feed = new SubscriptFeedsNewAdapter.Msg210Feed(this);
    localMsg210Feed.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131428504);
    localMsg210Feed.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840820);
    localMsg210Feed.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c();
    localMsg210Feed.jdField_b_of_type_JavaLangString = ReadInJoyConstants.o;
    localMsg210Feed.jdField_b_of_type_Int = ReadInJoyMessagesActivity.jdField_b_of_type_Int;
    localArrayList.add(localMsg210Feed);
    this.jdField_c_of_type_JavaUtilList.addAll(localArrayList);
  }
  
  public void c()
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.addAll(this.jdField_c_of_type_JavaUtilList);
    this.jdField_b_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
  }
  
  public int getCount()
  {
    return this.jdField_b_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_b_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = e;
    Object localObject = this.jdField_b_of_type_JavaUtilList.get(paramInt);
    if ((localObject instanceof SubscriptionFeed)) {
      paramInt = jdField_a_of_type_Int;
    }
    do
    {
      return paramInt;
      paramInt = i;
    } while (!(localObject instanceof SubscriptFeedsNewAdapter.Msg210Feed));
    return jdField_b_of_type_Int;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_b_of_type_JavaUtilList.size())) {
      return null;
    }
    int j = getItemViewType(paramInt);
    Object localObject = null;
    int i;
    if (paramView == null) {
      if (j == jdField_a_of_type_Int)
      {
        localObject = new SubscriptFeedsNewAdapter.FeedItemCellHolder(this);
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969696, null);
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131367505));
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367506));
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367507));
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366833));
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131366832));
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).c = ((TextView)paramView.findViewById(2131367510));
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131365689));
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131365690));
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramViewGroup = ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).c;
        if (this.jdField_a_of_type_Boolean)
        {
          i = this.jdField_a_of_type_AndroidContentResResources.getColor(2131493597);
          paramViewGroup.setTextColor(i);
          paramViewGroup = ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_AndroidWidgetTextView;
          if (!this.jdField_a_of_type_Boolean) {
            break label376;
          }
          i = this.jdField_a_of_type_AndroidContentResResources.getColor(2131493599);
          label297:
          paramViewGroup.setTextColor(i);
          paramViewGroup = ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_b_of_type_AndroidWidgetTextView;
          if (!this.jdField_a_of_type_Boolean) {
            break label391;
          }
          i = this.jdField_a_of_type_AndroidContentResResources.getColor(2131493601);
          label328:
          paramViewGroup.setTextColor(i);
          label334:
          paramViewGroup = paramView;
          if (paramView != null)
          {
            paramViewGroup = paramView;
            if (localObject != null) {
              paramView.setTag(localObject);
            }
          }
        }
      }
    }
    for (paramViewGroup = paramView;; paramViewGroup = paramView)
    {
      if (paramViewGroup == null)
      {
        return null;
        i = this.jdField_a_of_type_AndroidContentResResources.getColor(2131493598);
        break;
        label376:
        i = this.jdField_a_of_type_AndroidContentResResources.getColor(2131493596);
        break label297;
        label391:
        i = this.jdField_a_of_type_AndroidContentResResources.getColor(2131493600);
        break label328;
        if (j != jdField_b_of_type_Int) {
          break label1196;
        }
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969527, null);
        break label334;
      }
      if (j == jdField_a_of_type_Int)
      {
        paramViewGroup.setTag(2131362112, Integer.valueOf(paramInt));
        localObject = (SubscriptFeedsNewAdapter.FeedItemCellHolder)paramViewGroup.getTag();
        localSubscriptionFeed = (SubscriptionFeed)getItem(paramInt);
        if (this.jdField_a_of_type_JavaUtilHashSet != null) {
          this.jdField_a_of_type_JavaUtilHashSet.add(localSubscriptionFeed.jdField_a_of_type_JavaLangString);
        }
        ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_JavaLangString = localSubscriptionFeed.jdField_a_of_type_JavaLangString;
        a((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject, localSubscriptionFeed.jdField_a_of_type_JavaLangString);
        paramView = TroopBarAssistantManager.a().a(localSubscriptionFeed.jdField_a_of_type_JavaLangString);
        if (TextUtils.isEmpty(paramView))
        {
          paramView = TroopBarAssistantManager.a().a(localSubscriptionFeed.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (!TextUtils.isEmpty(paramView))
          {
            ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
            ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setText(TimeManager.a().a(localSubscriptionFeed.jdField_a_of_type_JavaLangString, localSubscriptionFeed.jdField_a_of_type_Long));
            if (localSubscriptionFeed.jdField_b_of_type_Int <= 0) {
              break label870;
            }
            paramInt = 3;
            CustomWidgetUtil.a(((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, paramInt, localSubscriptionFeed.jdField_b_of_type_Int, 2130846055, 99, null);
            if (localSubscriptionFeed.jdField_a_of_type_JavaUtilList.size() <= 0) {
              break label972;
            }
            localSubscriptionFeedItem = (SubscriptionFeedItem)localSubscriptionFeed.jdField_a_of_type_JavaUtilList.get(0);
            if (localSubscriptionFeedItem.jdField_a_of_type_Int != 0) {
              break label875;
            }
            ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).c.setMaxLines(1);
            ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).c.setText(new QQText(localSubscriptionFeedItem.c.replaceFirst("^\\s+", ""), 3, 20));
            ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_AndroidViewViewGroup.setTag(2131362114, Integer.valueOf(localSubscriptionFeed.jdField_b_of_type_Int));
            ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_AndroidViewViewGroup.setTag(2131362115, localSubscriptionFeed.jdField_a_of_type_JavaLangString);
            ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_AndroidViewViewGroup.setTag(2131362116, paramView);
            ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_AndroidViewViewGroup.setTag(2131362113, Integer.valueOf(jdField_c_of_type_Int));
            ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_AndroidViewViewGroup.setTag(localSubscriptionFeed);
            ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131362114, localSubscriptionFeed);
            ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_AndroidWidgetButton.setTag(2131362115, localSubscriptionFeed.jdField_a_of_type_JavaLangString);
            ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_AndroidWidgetButton.setTag(2131362116, paramView);
            ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_b_of_type_AndroidWidgetButton.setTag(2131362115, localSubscriptionFeed.jdField_a_of_type_JavaLangString);
            paramViewGroup.setTag(-3, Integer.valueOf((int)(this.jdField_c_of_type_Float + this.jdField_d_of_type_Float)));
          }
        }
      }
      label870:
      label875:
      while (j != jdField_b_of_type_Int) {
        for (;;)
        {
          SubscriptionFeed localSubscriptionFeed;
          SubscriptionFeedItem localSubscriptionFeedItem;
          return paramViewGroup;
          ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(localSubscriptionFeed.jdField_a_of_type_JavaLangString);
          continue;
          ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
          continue;
          paramInt = 0;
          continue;
          if (localSubscriptionFeedItem.jdField_a_of_type_Int == 1)
          {
            ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).c.setMaxLines(2);
            ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).c.setText(localSubscriptionFeedItem.jdField_b_of_type_JavaLangString.replaceFirst("^\\s+", ""));
          }
          else if (localSubscriptionFeedItem.jdField_a_of_type_Int == 2)
          {
            ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).c.setMaxLines(1);
            ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).c.setText(2131430095);
          }
          else
          {
            ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).c.setMaxLines(1);
            ((SubscriptFeedsNewAdapter.FeedItemCellHolder)localObject).c.setText(2131430098);
            continue;
            if ((QLog.isColorLevel()) && (QLog.isColorLevel())) {
              QLog.w("SubscriptFeedsNewAdapter", 2, "getView feed.mItems.size() == 0, is error!!");
            }
          }
        }
      }
      label972:
      paramView = (SubscriptFeedsNewAdapter.Msg210Feed)getItem(paramInt);
      ((TextView)paramViewGroup.findViewById(2131366831)).setText(paramView.jdField_a_of_type_JavaLangString);
      ((ImageView)paramViewGroup.findViewById(2131366830)).setImageDrawable(paramView.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      localObject = (DragTextView)paramViewGroup.findViewById(2131366832);
      ((DragTextView)localObject).setDragViewType(0, paramViewGroup);
      if (paramView.jdField_a_of_type_Int > 0) {}
      for (paramInt = 3;; paramInt = 0)
      {
        CustomWidgetUtil.a((TextView)localObject, paramInt, paramView.jdField_a_of_type_Int, 2130846055, 99, null);
        if (paramView.jdField_a_of_type_Int > 0) {
          paramViewGroup.findViewById(2131366834).setVisibility(8);
        }
        localObject = (ViewGroup)paramViewGroup.findViewById(2131366829);
        ((ViewGroup)localObject).setTag(2131362113, Integer.valueOf(jdField_d_of_type_Int));
        ((ViewGroup)localObject).setTag(2131362360, paramView.jdField_b_of_type_JavaLangString);
        ((ViewGroup)localObject).setTag(2131362414, Integer.valueOf(paramView.jdField_b_of_type_Int));
        ((ViewGroup)localObject).setTag(2131362412, Integer.valueOf(paramView.jdField_a_of_type_Int));
        ((ViewGroup)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        break;
      }
      label1196:
      break label334;
    }
  }
  
  public int getViewTypeCount()
  {
    return e;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (this.jdField_a_of_type_ComTencentWidgetXListView == null) || (paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramBitmap = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if ((paramBitmap != null) && ((paramBitmap instanceof SubscriptFeedsNewAdapter.FeedItemCellHolder)))
        {
          paramBitmap = (SubscriptFeedsNewAdapter.FeedItemCellHolder)paramBitmap;
          if (paramString.equals(paramBitmap.jdField_a_of_type_JavaLangString)) {
            a(paramBitmap, paramString);
          }
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsNewAdapter
 * JD-Core Version:    0.7.0.1
 */