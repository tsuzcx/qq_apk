package com.tencent.mobileqq.activity.contact.newfriend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import com.tencent.widget.SwipListView.SwipListListener;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class NewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter
  extends FacePreloadBaseAdapter
  implements View.OnClickListener, AbsListView.OnScrollListener, SwipListView.RightIconMenuListener, SwipListView.SwipListListener
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131691479 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2130839507 };
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2131370801 };
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<byte[]> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(20);
  private View jdField_a_of_type_AndroidViewView;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.1(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INewFriendService jdField_a_of_type_ComTencentMobileqqNewfriendApiINewFriendService;
  private SwipRightMenuBuilder jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder;
  private List<SysSuspiciousMsg> jdField_a_of_type_JavaUtilList = new ArrayList(0);
  private int jdField_b_of_type_Int = -1;
  private int jdField_c_of_type_Int = -1;
  private int d = -1;
  
  public NewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter(Context paramContext, QQAppInterface paramQQAppInterface, SwipListView paramSwipListView, View paramView)
  {
    super(paramContext, paramQQAppInterface, paramSwipListView, 1, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidViewView = paramView;
    paramSwipListView.setRightIconMenuListener(this);
    a(this);
    this.jdField_a_of_type_ComTencentMobileqqNewfriendApiINewFriendService = ((INewFriendService)paramQQAppInterface.getRuntimeService(INewFriendService.class));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    e();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.sendReadReportSuspicious();
  }
  
  private SwipRightMenuBuilder a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298886);
    int j = paramContext.getResources().getDimensionPixelSize(2131298887);
    paramContext = jdField_c_of_type_ArrayOfInt;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = jdField_b_of_type_ArrayOfInt;
    return new NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.3(this, 1, 1, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  private void a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localSysSuspiciousMsg = (SysSuspiciousMsg)((Iterator)localObject).next();
      if (localSysSuspiciousMsg.uin == paramLong) {
        break label46;
      }
    }
    SysSuspiciousMsg localSysSuspiciousMsg = null;
    label46:
    if (localSysSuspiciousMsg != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("base_uin", String.valueOf(localSysSuspiciousMsg.uin));
      ((Bundle)localObject).putString("base_nick", localSysSuspiciousMsg.nick);
      ((Bundle)localObject).putInt("verfy_type", 0);
      ((Bundle)localObject).putString("verfy_msg", localSysSuspiciousMsg.msg);
      Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localSysSuspiciousMsg.uin);
      localStringBuilder.append("");
      AutoRemarkActivity.a(localActivity, 0, localStringBuilder.toString(), 0L, (Bundle)localObject);
    }
  }
  
  private void a(Context paramContext, View paramView, int paramInt, Object paramObject, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, View.OnClickListener paramOnClickListener)
  {
    SwipRightMenuBuilder localSwipRightMenuBuilder = this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder;
    int i;
    if (localSwipRightMenuBuilder != null) {
      i = localSwipRightMenuBuilder.updateRightMenuView(paramContext, paramView, paramInt, paramObject, paramSwipItemBaseHolder, paramOnClickListener);
    } else {
      i = 0;
    }
    int j = this.d;
    if (j != -1)
    {
      if (paramInt != j)
      {
        paramView.scrollTo(0, 0);
        return;
      }
      paramView.scrollTo(i, 0);
    }
  }
  
  private void a(NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder paramSuspiciousSysMsgHolder, SysSuspiciousMsg paramSysSuspiciousMsg)
  {
    if (paramSysSuspiciousMsg == null)
    {
      paramSuspiciousSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramSuspiciousSysMsgHolder.b.setVisibility(8);
      paramSuspiciousSysMsgHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramSuspiciousSysMsgHolder.d.setVisibility(8);
      paramSuspiciousSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
    }
    paramSuspiciousSysMsgHolder.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg = paramSysSuspiciousMsg;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramSysSuspiciousMsg.uin);
    String str = "";
    ((StringBuilder)localObject).append("");
    paramSuspiciousSysMsgHolder.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    paramSuspiciousSysMsgHolder.leftView.setOnClickListener(this);
    paramSuspiciousSysMsgHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(paramSuspiciousSysMsgHolder.jdField_c_of_type_Int, paramSuspiciousSysMsgHolder.jdField_a_of_type_JavaLangString));
    paramSuspiciousSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    localObject = paramSuspiciousSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView;
    if (paramSysSuspiciousMsg.nick != null) {
      str = paramSysSuspiciousMsg.nick;
    }
    ((TextView)localObject).setText(str);
    b(paramSuspiciousSysMsgHolder, paramSysSuspiciousMsg);
    if (paramSysSuspiciousMsg.msg == null)
    {
      paramSuspiciousSysMsgHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    else
    {
      paramSuspiciousSysMsgHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramSuspiciousSysMsgHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramSysSuspiciousMsg.msg);
    }
    if (paramSysSuspiciousMsg.reason == null)
    {
      paramSuspiciousSysMsgHolder.d.setVisibility(8);
    }
    else
    {
      paramSuspiciousSysMsgHolder.d.setVisibility(0);
      paramSuspiciousSysMsgHolder.d.setText(paramSysSuspiciousMsg.reason);
      paramSysSuspiciousMsg = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130848043);
      paramSysSuspiciousMsg.setBounds(0, 0, ViewUtils.a(16.0F), ViewUtils.a(16.0F));
      paramSuspiciousSysMsgHolder.d.setCompoundDrawablePadding(ViewUtils.a(5.0F));
      paramSuspiciousSysMsgHolder.d.setCompoundDrawables(paramSysSuspiciousMsg, null, null, null);
    }
    paramSuspiciousSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    paramSuspiciousSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131707527));
    paramSuspiciousSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    paramSuspiciousSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramSuspiciousSysMsgHolder);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
    }
  }
  
  private void b(NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder paramSuspiciousSysMsgHolder, SysSuspiciousMsg paramSysSuspiciousMsg)
  {
    int i = paramSysSuspiciousMsg.sex;
    int j = 1;
    if (i != 1)
    {
      if (i != 2)
      {
        paramSuspiciousSysMsgHolder.b.setBackgroundResource(2130846056);
        i = 0;
        j = 0;
      }
      else
      {
        i = 2130846053;
        paramSuspiciousSysMsgHolder.b.setBackgroundResource(2130846054);
      }
    }
    else
    {
      i = 2130846055;
      paramSuspiciousSysMsgHolder.b.setBackgroundResource(2130846056);
    }
    TextView localTextView = paramSuspiciousSysMsgHolder.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramSysSuspiciousMsg.age);
    localStringBuilder.append("");
    localTextView.setText(localStringBuilder.toString());
    paramSuspiciousSysMsgHolder.b.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    if (j != 0)
    {
      paramSuspiciousSysMsgHolder.b.setVisibility(0);
      return;
    }
    paramSuspiciousSysMsgHolder.b.setVisibility(8);
  }
  
  private void e()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestSuspiciousMsgNextPage ");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext)) {
      return;
    }
    Object localObject = (byte[])this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_c_of_type_Int);
    if ((this.jdField_c_of_type_Int >= 0) && (localObject == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "requestSuspiciousMsgNextPage no cookie");
      }
      return;
    }
    this.jdField_c_of_type_Int += 1;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getSuspiciousMsgList(50, (byte[])localObject, Integer.valueOf(this.jdField_c_of_type_Int));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "adapter onResume");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "adapter onPause");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    super.c();
  }
  
  public void d()
  {
    ThreadManager.getSubThreadHandler().post(new NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.2(this));
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (paramInt < localList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    SysSuspiciousMsg localSysSuspiciousMsg = null;
    View localView;
    if (paramView == null)
    {
      paramView = new NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder();
      localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561509, null);
      localView = this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.createView(this.jdField_a_of_type_AndroidContentContext, (View)localObject, paramView, -1);
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131361799));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371877));
      paramView.b = ((TextView)localView.findViewById(2131362299));
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131376487));
      paramView.d = ((TextView)localView.findViewById(2131377726));
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131376477));
      paramView.e = ((TextView)localView.findViewById(2131376485));
      if ((paramView.jdField_c_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)paramView.jdField_c_of_type_AndroidWidgetImageView).setSupportMaskView(true);
      }
      localView.setTag(paramView);
      if (ThemeUtil.isDefaultTheme()) {
        ((View)localObject).setBackgroundResource(2130839393);
      } else {
        ((View)localObject).setBackgroundResource(2130839390);
      }
    }
    else
    {
      localObject = (NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    a(this.jdField_a_of_type_AndroidContentContext, localView, paramInt, null, paramView, this);
    Object localObject = getItem(paramInt);
    if ((localObject instanceof SysSuspiciousMsg)) {
      localSysSuspiciousMsg = (SysSuspiciousMsg)localObject;
    }
    a(paramView, localSysSuspiciousMsg);
    paramView.leftView.setTag(paramView);
    if (paramInt == 0) {
      localView.setPadding(0, ViewUtils.a(12.0F), 0, 0);
    } else {
      localView.setPadding(0, 0, 0, 0);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void hideMenuPop() {}
  
  public void interceptTouchEvent(boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    int i = paramView.getId();
    Object localObject2;
    if (i != 2131370801)
    {
      if (i != 2131376477)
      {
        if ((i == 2131376644) && ((localObject1 instanceof NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder)))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32E", "0X800A32E", 0, 0, "", "", "", "");
          localObject1 = (NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder)localObject1;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("msg_extra", ((NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg);
          PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject2, AddRequestSuspiciousMsgFragment.class);
        }
      }
      else if ((localObject1 instanceof NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32C", "0X800A32C", 1, 0, "", "", "", "");
        localObject1 = (NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder)localObject1;
        if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131694433, 0).a();
        }
        else if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(((NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder)localObject1).jdField_a_of_type_JavaLangString))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131707524), 0).a();
        }
        else
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
          if (localObject2 != null) {
            ((FriendListHandler)localObject2).agreeSuspiciousMsg(((NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin);
          }
        }
      }
    }
    else
    {
      localObject1 = paramView.getTag(-1);
      if ((localObject1 instanceof Integer))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32D", "0X800A32D", 0, 0, "", "", "", "");
        i = ((Integer)localObject1).intValue();
        if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131694433, 0).a();
        }
        else
        {
          localObject1 = getItem(i);
          if ((localObject1 instanceof SysSuspiciousMsg))
          {
            localObject1 = (SysSuspiciousMsg)localObject1;
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
            if (localObject2 != null) {
              ((FriendListHandler)localObject2).deleteSuspiciousMsg(((SysSuspiciousMsg)localObject1).uin);
            }
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onRightIconMenuHide(View paramView)
  {
    a(true);
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    a(false);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      if (QLog.isColorLevel())
      {
        paramAbsListView = new StringBuilder();
        paramAbsListView.append("onScrollStateChanged ");
        paramAbsListView.append(this.jdField_a_of_type_Int);
        paramAbsListView.append(" ");
        paramAbsListView.append(this.jdField_b_of_type_Int);
        QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, paramAbsListView.toString());
      }
      if ((this.jdField_a_of_type_Int == getCount() - 1) || (this.jdField_a_of_type_Int >= this.jdField_b_of_type_Int)) {
        e();
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
    this.d = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter
 * JD-Core Version:    0.7.0.1
 */