package com.tencent.biz.pubaccount.serviceAccountFolder;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.item.PAWeatherItemBuilder;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import mrq;
import mrr;
import mrs;
import mrt;
import mru;
import mrv;

public class ServiceAccountFolderFeedAdapter
  extends BaseAdapter
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener
{
  private float jdField_a_of_type_Float;
  private ServiceAccountFolderActivity jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity;
  private RecentFaceDecoder jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final String jdField_a_of_type_JavaLangString = "ServiceAccountFolderFeedAdapter";
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List jdField_a_of_type_JavaUtilList;
  private float b;
  private float c;
  
  public ServiceAccountFolderFeedAdapter(QQAppInterface paramQQAppInterface, ServiceAccountFolderActivity paramServiceAccountFolderActivity, SwipListView paramSwipListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity = paramServiceAccountFolderActivity;
    this.jdField_a_of_type_ComTencentWidgetSwipListView = paramSwipListView;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder = new RecentFaceDecoder(paramQQAppInterface, this, false);
    this.jdField_a_of_type_Float = paramServiceAccountFolderActivity.getResources().getDimension(2131560136);
    this.b = paramServiceAccountFolderActivity.getResources().getDimension(2131560137);
    this.c = (this.jdField_a_of_type_Float + this.b);
  }
  
  private void a(ServiceAccountFolderFeed paramServiceAccountFolderFeed)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "unfollow->uin:" + paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.b(true);
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity, PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "unfollow");
    mobileqq_mp.UnFollowRequest localUnFollowRequest = new mobileqq_mp.UnFollowRequest();
    localUnFollowRequest.uin.set((int)Long.parseLong(paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString));
    localNewIntent.putExtra("data", localUnFollowRequest.toByteArray());
    localNewIntent.setObserver(new mrs(this, paramServiceAccountFolderFeed));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
  }
  
  private void a(ServiceAccountFolderFeed paramServiceAccountFolderFeed, int paramInt)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity, null);
    localActionSheet.a(String.format(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.getResources().getString(2131430094), new Object[] { paramServiceAccountFolderFeed.jdField_c_of_type_JavaLangString }));
    localActionSheet.a(2131430054, 3);
    localActionSheet.c(2131433015);
    localActionSheet.a(new mrr(this, paramServiceAccountFolderFeed, paramInt, localActionSheet));
    localActionSheet.show();
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "showActionSheet->uin:" + paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString + ", name:" + paramServiceAccountFolderFeed.jdField_c_of_type_JavaLangString);
    }
  }
  
  private void a(mrv parammrv, int paramInt, View paramView)
  {
    int j = 0;
    ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)getItem(paramInt);
    if (localServiceAccountFolderFeed == null) {
      return;
    }
    boolean bool = a(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "updateItemContent->uin:" + localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString + ", isFollow:" + bool);
    }
    Object localObject1;
    if (bool)
    {
      parammrv.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramView.setTag(-3, Integer.valueOf((int)this.c));
      parammrv.jdField_a_of_type_JavaLangString = localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(1008, localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
        parammrv.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      }
      parammrv.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, localServiceAccountFolderFeed.jdField_c_of_type_Int);
      parammrv.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString);
      parammrv.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(localServiceAccountFolderFeed.jdField_b_of_type_JavaLangString, 0);
      if (localServiceAccountFolderFeed.e != 4) {
        break label588;
      }
    }
    label588:
    for (paramInt = 2130838701;; paramInt = 0) {
      for (;;)
      {
        parammrv.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(paramInt, 0);
        paramInt = localServiceAccountFolderFeed.jdField_d_of_type_Int;
        Object localObject2 = localServiceAccountFolderFeed.jdField_d_of_type_JavaLangString;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (((String)localObject1).length() > 0)
        {
          localObject2 = localObject1;
          if (!((String)localObject1).endsWith(" ")) {
            localObject2 = (String)localObject1 + " ";
          }
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (paramInt != 0)) {
          parammrv.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(paramInt), 1);
        }
        parammrv.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject2, 1);
        try
        {
          parammrv.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(new QQText(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence, 3, 16));
          paramInt = localServiceAccountFolderFeed.jdField_b_of_type_Int;
          i = localServiceAccountFolderFeed.jdField_a_of_type_Int;
          if (paramInt > 0) {
            if (i == 0)
            {
              parammrv.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
              parammrv.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(null);
              i = 0;
              paramInt = 0;
              CustomWidgetUtil.a(parammrv.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, paramInt, j, i, 99, null);
              if (!AppSetting.b) {
                break;
              }
              paramView = new StringBuilder();
              paramView.append(parammrv.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a()).append(',').append(parammrv.jdField_b_of_type_ComTencentWidgetSingleLineTextView.a());
              parammrv.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramView.toString());
              return;
              parammrv.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
              paramView.setTag(-3, Integer.valueOf((int)this.b));
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int i;
            localException.printStackTrace();
            parammrv.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence + " ");
            continue;
            if (i == 2)
            {
              parammrv.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
              parammrv.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(null);
              paramInt = 1;
              i = 0;
            }
            else
            {
              i = 2130846055;
              parammrv.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
              parammrv.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
              j = paramInt;
              paramInt = 3;
              continue;
              i = 0;
              paramInt = 0;
            }
          }
        }
      }
    }
  }
  
  private void a(mrv parammrv, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "setHolderIcon->uin:" + paramString);
    }
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localBitmap == null)
    {
      parammrv.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(1008, paramString));
      return;
    }
    parammrv.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    AccountDetail localAccountDetail;
    do
    {
      PublicAccountDataManager localPublicAccountDataManager;
      do
      {
        do
        {
          return false;
          localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
        } while (localPublicAccountDataManager == null);
        localAccountDetail = localPublicAccountDataManager.b(paramString);
      } while (((localAccountDetail != null) && (!localAccountDetail.isShowFollowButton)) || ((localAccountDetail == null) && ("1770946116".equals(paramString))));
      if (localPublicAccountDataManager.c(paramString) != null) {
        return true;
      }
    } while (localAccountDetail == null);
    if (localAccountDetail.followType == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "showNetworkErrorToast");
    }
    Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 2131430033, 0).show();
  }
  
  private void b(ServiceAccountFolderFeed paramServiceAccountFolderFeed)
  {
    String str = paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "updateUnfollowInfo->uin:" + str);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramServiceAccountFolderFeed);
      notifyDataSetChanged();
      ThreadManager.executeOnSubThread(new mrt(this, paramServiceAccountFolderFeed));
      if ((getCount() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity != null) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.isResume())) {
        this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.a(true);
      }
      ThreadManager.getSubThreadHandler().postDelayed(new mru(this, str, paramServiceAccountFolderFeed), 10L);
      return;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
  }
  
  public void a(List paramList)
  {
    if (paramList != null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderFeedAdapter", 2, "setDataList->DataSetChanged size:" + paramList.size());
      }
      return;
    }
  }
  
  public int getCount()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      return i;
    }
  }
  
  public Object getItem(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (paramInt >= getCount()) {
        return null;
      }
      Object localObject2 = this.jdField_a_of_type_JavaUtilList.get(paramInt);
      return localObject2;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = null;
    paramViewGroup = (ViewGroup)localObject1;
    if (paramView != null)
    {
      paramViewGroup = (ViewGroup)localObject1;
      if ((paramView.getTag() instanceof mrv)) {
        paramViewGroup = (mrv)paramView.getTag();
      }
    }
    localObject1 = paramViewGroup;
    if (paramViewGroup == null)
    {
      localObject1 = new mrv(this);
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity).inflate(2130969236, null);
      ((mrv)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131365688));
      ((mrv)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362719));
      ((mrv)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131363378));
      ((mrv)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131365659));
      ((mrv)localObject1).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131363207));
      ((mrv)localObject1).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131365689));
      ((mrv)localObject1).jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131365690));
      Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.getResources();
      float f = DeviceInfoUtil.a();
      paramViewGroup = ((Resources)localObject2).getColorStateList(2131494267);
      localObject2 = ((Resources)localObject2).getColorStateList(2131494219);
      ((mrv)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor((ColorStateList)localObject2);
      ((mrv)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextSize(17.0F);
      ((mrv)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramViewGroup, 0);
      ((mrv)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
      ((mrv)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
      ((mrv)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
      ((mrv)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramViewGroup, 2);
      ((mrv)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
      ((mrv)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setTextSize(14.0F);
      ((mrv)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(f * 2.0F), 1);
      ((mrv)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(14.0F, 1);
      ((mrv)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      ((mrv)localObject1).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      ((mrv)localObject1).jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramView.setTag(localObject1);
    }
    ((mrv)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramInt));
    ((mrv)localObject1).jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(paramInt));
    ((mrv)localObject1).jdField_b_of_type_AndroidWidgetButton.setTag(Integer.valueOf(paramInt));
    ((mrv)localObject1).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
    a((mrv)localObject1, paramInt, paramView);
    return paramView;
  }
  
  public void onClick(View arg1)
  {
    int k = ((Integer)???.getTag()).intValue();
    ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)getItem(k);
    if (localServiceAccountFolderFeed == null) {
      return;
    }
    int i = localServiceAccountFolderFeed.jdField_b_of_type_Int;
    int j = localServiceAccountFolderFeed.jdField_a_of_type_Int;
    if (j != 1) {
      i = 0;
    }
    for (;;)
    {
      long l = ServiceAccountFolderManager.a().a(localServiceAccountFolderFeed);
      switch (???.getId())
      {
      default: 
        return;
      case 2131365688: 
        ??? = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity, ChatActivity.class);
        ???.putExtra("uintype", 1008);
        ???.putExtra("uin", localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
        ???.putExtra("uinname", localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString);
        ???.putExtra("start_time", System.currentTimeMillis());
        ???.putExtra("red_hot_count", localServiceAccountFolderFeed.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.startActivity(???);
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderFeedAdapter", 2, "onClickFeedItem->uin:" + localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString + ", name:" + localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString);
        }
        ??? = "0X80067F1";
        if (j == 1) {
          ??? = "0X80067EF";
        }
        for (;;)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "Pb_account_lifeservice", "" + localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, ???, ???, 0, 0, "" + j, "" + l, "" + (k + 1), "" + i);
          if (PAWeatherItemBuilder.a(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString)) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "weather_public_account", "", "weather_public_account", "brief_weather_click", 0, 0, "", "", "7.6.3", "");
          }
          PublicTracker.a(null, "SUBSCRIPT_AIO_COST");
          return;
          if (j == 2) {
            ??? = "0X80067F0";
          }
        }
      case 2131365689: 
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderFeedAdapter", 2, "onClickMenuUnfollow->uin:" + localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString + ", name:" + localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString);
        }
        a(localServiceAccountFolderFeed, k);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderFeedAdapter", 2, "onClickMenuDelete->uin:" + localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString + ", name:" + localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString);
      }
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_JavaUtilList.remove(localServiceAccountFolderFeed);
          notifyDataSetChanged();
          ThreadManager.executeOnSubThread(new mrq(this, localServiceAccountFolderFeed));
          if ((getCount() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity != null) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.isResume())) {
            this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.a(true);
          }
          if (j == 2)
          {
            j = 1;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "Pb_account_lifeservice", "" + localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, "0X80067F3", "0X80067F3", 0, 0, "" + j, "" + i, "" + (k + 1), "" + l);
            return;
          }
        }
        j = 0;
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramBitmap = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt1).getTag();
        if ((paramBitmap != null) && ((paramBitmap instanceof mrv)))
        {
          paramBitmap = (mrv)paramBitmap;
          if (paramString.equals(paramBitmap.jdField_a_of_type_JavaLangString)) {
            a(paramBitmap, paramString);
          }
        }
        paramInt1 += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ServiceAccountFolderFeedAdapter", 2, "onDecodeTaskCompleted->uin:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter
 * JD-Core Version:    0.7.0.1
 */