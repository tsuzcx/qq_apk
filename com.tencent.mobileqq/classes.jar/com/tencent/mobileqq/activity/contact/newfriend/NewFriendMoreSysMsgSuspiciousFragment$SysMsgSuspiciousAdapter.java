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
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
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
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131691558 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2130839649 };
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2131371177 };
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<byte[]> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(20);
  private View jdField_a_of_type_AndroidViewView;
  private NewFriendManager jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.1(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager = ((NewFriendManager)paramQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    e();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.sendReadReportSuspicious();
  }
  
  private SwipRightMenuBuilder a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298882);
    int j = paramContext.getResources().getDimensionPixelSize(2131298883);
    paramContext = jdField_c_of_type_ArrayOfInt;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = jdField_b_of_type_ArrayOfInt;
    return new NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.3(this, 1, 1, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  private void a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    SysSuspiciousMsg localSysSuspiciousMsg;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localSysSuspiciousMsg = (SysSuspiciousMsg)((Iterator)localObject).next();
    } while (localSysSuspiciousMsg.uin != paramLong);
    for (;;)
    {
      if (localSysSuspiciousMsg != null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("base_uin", String.valueOf(localSysSuspiciousMsg.uin));
        ((Bundle)localObject).putString("base_nick", localSysSuspiciousMsg.nick);
        ((Bundle)localObject).putInt("verfy_type", 0);
        ((Bundle)localObject).putString("verfy_msg", localSysSuspiciousMsg.msg);
        AutoRemarkActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, 0, localSysSuspiciousMsg.uin + "", 0L, (Bundle)localObject);
      }
      return;
      localSysSuspiciousMsg = null;
    }
  }
  
  private void a(Context paramContext, View paramView, int paramInt, Object paramObject, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder != null) {}
    for (int i = this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.a(paramContext, paramView, paramInt, paramObject, paramSwipItemBaseHolder, paramOnClickListener);; i = 0)
    {
      if (this.d != -1)
      {
        if (paramInt != this.d) {
          paramView.scrollTo(0, 0);
        }
      }
      else {
        return;
      }
      paramView.scrollTo(i, 0);
      return;
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
    paramSuspiciousSysMsgHolder.jdField_a_of_type_JavaLangString = (paramSysSuspiciousMsg.uin + "");
    paramSuspiciousSysMsgHolder.g.setOnClickListener(this);
    paramSuspiciousSysMsgHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(paramSuspiciousSysMsgHolder.jdField_c_of_type_Int, paramSuspiciousSysMsgHolder.jdField_a_of_type_JavaLangString));
    paramSuspiciousSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    TextView localTextView = paramSuspiciousSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView;
    String str;
    if (paramSysSuspiciousMsg.nick == null)
    {
      str = "";
      localTextView.setText(str);
      b(paramSuspiciousSysMsgHolder, paramSysSuspiciousMsg);
      if (paramSysSuspiciousMsg.msg != null) {
        break label222;
      }
      paramSuspiciousSysMsgHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      label160:
      if (paramSysSuspiciousMsg.reason != null) {
        break label244;
      }
      paramSuspiciousSysMsgHolder.d.setVisibility(8);
    }
    for (;;)
    {
      paramSuspiciousSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramSuspiciousSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131707502));
      paramSuspiciousSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramSuspiciousSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramSuspiciousSysMsgHolder);
      return;
      str = paramSysSuspiciousMsg.nick;
      break;
      label222:
      paramSuspiciousSysMsgHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramSuspiciousSysMsgHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramSysSuspiciousMsg.msg);
      break label160;
      label244:
      paramSuspiciousSysMsgHolder.d.setVisibility(0);
      paramSuspiciousSysMsgHolder.d.setText(paramSysSuspiciousMsg.reason);
      paramSysSuspiciousMsg = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130848172);
      paramSysSuspiciousMsg.setBounds(0, 0, ViewUtils.a(16.0F), ViewUtils.a(16.0F));
      paramSuspiciousSysMsgHolder.d.setCompoundDrawablePadding(ViewUtils.a(5.0F));
      paramSuspiciousSysMsgHolder.d.setCompoundDrawables(paramSysSuspiciousMsg, null, null, null);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  private void b(NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder paramSuspiciousSysMsgHolder, SysSuspiciousMsg paramSysSuspiciousMsg)
  {
    int j = 1;
    int i;
    switch (paramSysSuspiciousMsg.sex)
    {
    default: 
      paramSuspiciousSysMsgHolder.b.setBackgroundResource(2130846180);
      i = 0;
      j = 0;
    }
    for (;;)
    {
      paramSuspiciousSysMsgHolder.b.setText(paramSysSuspiciousMsg.age + "");
      paramSuspiciousSysMsgHolder.b.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      if (j == 0) {
        break;
      }
      paramSuspiciousSysMsgHolder.b.setVisibility(0);
      return;
      i = 2130846179;
      paramSuspiciousSysMsgHolder.b.setBackgroundResource(2130846180);
      continue;
      i = 2130846177;
      paramSuspiciousSysMsgHolder.b.setBackgroundResource(2130846178);
    }
    paramSuspiciousSysMsgHolder.b.setVisibility(8);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "requestSuspiciousMsgNextPage " + this.jdField_c_of_type_Int);
    }
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext)) {}
    byte[] arrayOfByte;
    do
    {
      return;
      arrayOfByte = (byte[])this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_c_of_type_Int);
      if ((this.jdField_c_of_type_Int < 0) || (arrayOfByte != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "requestSuspiciousMsgNextPage no cookie");
    return;
    this.jdField_c_of_type_Int += 1;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getSuspiciousMsgList(50, arrayOfByte, Integer.valueOf(this.jdField_c_of_type_Int));
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
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder localSuspiciousSysMsgHolder;
    if (paramView == null)
    {
      localSuspiciousSysMsgHolder = new NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder();
      localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561658, null);
      paramView = this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.a(this.jdField_a_of_type_AndroidContentContext, (View)localObject, localSuspiciousSysMsgHolder, -1);
      localSuspiciousSysMsgHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361796));
      localSuspiciousSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372288));
      localSuspiciousSysMsgHolder.b = ((TextView)paramView.findViewById(2131362338));
      localSuspiciousSysMsgHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377005));
      localSuspiciousSysMsgHolder.d = ((TextView)paramView.findViewById(2131378318));
      localSuspiciousSysMsgHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131376990));
      localSuspiciousSysMsgHolder.e = ((TextView)paramView.findViewById(2131377001));
      if ((localSuspiciousSysMsgHolder.jdField_c_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)localSuspiciousSysMsgHolder.jdField_c_of_type_AndroidWidgetImageView).setSupportMaskView(true);
      }
      paramView.setTag(localSuspiciousSysMsgHolder);
      if (ThemeUtil.isDefaultTheme())
      {
        ((View)localObject).setBackgroundResource(2130839537);
        a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, null, localSuspiciousSysMsgHolder, this);
        localObject = getItem(paramInt);
        if (!(localObject instanceof SysSuspiciousMsg)) {
          break label315;
        }
      }
    }
    label315:
    for (Object localObject = (SysSuspiciousMsg)localObject;; localObject = null)
    {
      a(localSuspiciousSysMsgHolder, (SysSuspiciousMsg)localObject);
      localSuspiciousSysMsgHolder.g.setTag(localSuspiciousSysMsgHolder);
      if (paramInt == 0) {
        paramView.setPadding(0, ViewUtils.a(12.0F), 0, 0);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        ((View)localObject).setBackgroundResource(2130839534);
        break;
        localSuspiciousSysMsgHolder = (NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder)paramView.getTag();
        break;
        paramView.setPadding(0, 0, 0, 0);
      }
    }
  }
  
  public void hideMenuPop() {}
  
  public void interceptTouchEvent(boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localObject instanceof NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32E", "0X800A32E", 0, 0, "", "", "", "");
        localObject = (NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder)localObject;
        Intent localIntent = new Intent();
        localIntent.putExtra("msg_extra", ((NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg);
        PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, localIntent, AddRequestSuspiciousMsgFragment.class);
        continue;
        if ((localObject instanceof NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32C", "0X800A32C", 1, 0, "", "", "", "");
          localObject = (NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder)localObject;
          if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131694468, 0).a();
          }
          else if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(((NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder)localObject).jdField_a_of_type_JavaLangString))
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131707499), 0).a();
          }
          else if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.agreeSuspiciousMsg(((NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin);
            continue;
            localObject = paramView.getTag(-1);
            if ((localObject instanceof Integer))
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32D", "0X800A32D", 0, 0, "", "", "", "");
              int i = ((Integer)localObject).intValue();
              if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
              {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131694468, 0).a();
              }
              else
              {
                localObject = getItem(i);
                if ((localObject instanceof SysSuspiciousMsg))
                {
                  localObject = (SysSuspiciousMsg)localObject;
                  if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler != null) {
                    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.deleteSuspiciousMsg(((SysSuspiciousMsg)localObject).uin);
                  }
                }
              }
            }
          }
        }
      }
    }
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
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onScrollStateChanged " + this.jdField_a_of_type_Int + " " + this.jdField_b_of_type_Int);
      }
      if ((this.jdField_a_of_type_Int == getCount() - 1) || (this.jdField_a_of_type_Int >= this.jdField_b_of_type_Int)) {
        e();
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
      this.d = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter
 * JD-Core Version:    0.7.0.1
 */