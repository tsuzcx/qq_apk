package com.tencent.mobileqq.activity.contact.newfriend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.OnTabSelectedListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.contact.addfriendverifi.NewFriendVerificationManager;
import com.tencent.mobileqq.activity.contact.addfriendverifi.NewFriendVerificationObserver;
import com.tencent.mobileqq.activity.contact.connections.ConnectionsTabInfo;
import com.tencent.mobileqq.activity.contact.connections.ListviewScrollStatus;
import com.tencent.mobileqq.activity.contact.connections.ThemeTabLayout;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class SystemMsgListView
  extends BaseNewFriendView
  implements View.OnClickListener, PhoneContactManager.IPhoneContactListener, Observer
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler = new SystemMsgListView.1(this);
  private SparseArray<ListviewScrollStatus> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TabLayoutCompat.OnTabSelectedListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$OnTabSelectedListener = new SystemMsgListView.2(this);
  private NewFriendVerificationObserver jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiNewFriendVerificationObserver = new SystemMsgListView.6(this);
  private ListviewScrollStatus jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsListviewScrollStatus;
  private ThemeTabLayout jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout;
  private NewFriendManager jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager;
  private SystemMsgListAdapter jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new SystemMsgListView.7(this);
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new SystemMsgListView.5(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new SystemMsgListView.4(this);
  private MayknowRecommendManager jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new SystemMsgListView.MessageObserverForSystemMsgListView(this);
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new SystemMsgListView.8(this);
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  public boolean a;
  private int jdField_b_of_type_Int;
  private SparseArray<Boolean> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private final int jdField_c_of_type_Int = 0;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private int d;
  
  public SystemMsgListView(Context paramContext, FlingHandler paramFlingHandler)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = paramFlingHandler;
  }
  
  private void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("EntranceId", 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter = new SystemMsgListAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, this, i, this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter);
    i();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsListviewScrollStatus = new ListviewScrollStatus(23, 0, 0);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      Object localObject = this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt1);
      if ((localObject != null) && ((localObject instanceof Boolean))) {
        return ((Boolean)localObject).booleanValue();
      }
      this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt1, Boolean.valueOf(true));
    }
    return false;
  }
  
  private void e(int paramInt)
  {
    if ((((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).getActivity() == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter == null)) {}
    do
    {
      return;
      if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.getCount()))
      {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
        return;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.getItem(paramInt);
      if ((paramInt == 0) && (((localObject instanceof NewFriendBindContactGuideBuilder)) || ((localObject instanceof NewFriendBindContactGuideBuilderV2))))
      {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
        return;
      }
      if ((localObject instanceof NewFriendVerifyBlockedBuilder))
      {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
        return;
      }
      if ((localObject instanceof NewFriendSysEmptyBuilder))
      {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
        return;
      }
      if ((localObject instanceof NewFriendSubTitleBuilder))
      {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
        return;
      }
    } while (paramInt + 1 >= this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.getCount());
    f(paramInt);
  }
  
  private void f(int paramInt)
  {
    int i = 0;
    Object localObject1;
    if (((NewFriendBaseBuilder)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.getItem(paramInt) instanceof NewFriendSlideTabBuilder))
    {
      this.jdField_a_of_type_Int = paramInt;
      localObject1 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(0);
      if ((localObject1 != null) && (!this.jdField_c_of_type_AndroidViewViewGroup.isShown()))
      {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
        Object localObject2 = ((View)localObject1).getTag();
        if ((localObject2 instanceof NewFriendSlideTabBuilder.NewFriendSildeTabHolder))
        {
          localObject2 = (NewFriendSlideTabBuilder.NewFriendSildeTabHolder)localObject2;
          if ((((NewFriendSlideTabBuilder.NewFriendSildeTabHolder)localObject2).jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout != null))
          {
            float f = ((NewFriendSlideTabBuilder.NewFriendSildeTabHolder)localObject2).jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.a();
            if (QLog.isColorLevel()) {
              QLog.d("Q.newfriendSystemMsgListView", 2, "visable position: scrollposOffset = " + f);
            }
            this.jdField_a_of_type_Float = f;
            this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.setScrollPosition(f);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsListviewScrollStatus.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsListviewScrollStatus.jdField_c_of_type_Int = ((View)localObject1).getTop();
        int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
        paramInt = i;
        while (paramInt < j)
        {
          localObject2 = (ListviewScrollStatus)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(paramInt);
          if (localObject2 != null)
          {
            ((ListviewScrollStatus)localObject2).jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
            ((ListviewScrollStatus)localObject2).jdField_c_of_type_Int = ((View)localObject1).getTop();
          }
          paramInt += 1;
        }
      }
    }
    else
    {
      if (this.jdField_a_of_type_Int > -1) {
        break label255;
      }
      this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
    }
    label255:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (paramInt > this.jdField_a_of_type_Int)
              {
                this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
                return;
              }
            } while (!this.jdField_c_of_type_AndroidViewViewGroup.isShown());
            this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
          } while (!((NewFriendBaseBuilder)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.getItem(paramInt + 1) instanceof NewFriendSlideTabBuilder));
          localObject1 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(1);
        } while (localObject1 == null);
        localObject1 = ((View)localObject1).getTag();
      } while (!(localObject1 instanceof NewFriendSlideTabBuilder.NewFriendSildeTabHolder));
      localObject1 = (NewFriendSlideTabBuilder.NewFriendSildeTabHolder)localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("Q.newfriendSystemMsgListView", 2, "invisable position: scrollposOffset = " + this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.a());
      }
    } while ((((NewFriendSlideTabBuilder.NewFriendSildeTabHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout == null));
    ((NewFriendSlideTabBuilder.NewFriendSildeTabHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.setScrollPosition(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.a());
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiNewFriendVerificationObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiNewFriendVerificationObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
  }
  
  private void n()
  {
    super.d(2131561663);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370481));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131377836));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379432));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131366395));
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131378809));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131372311);
    this.jdField_b_of_type_Int = getResources().getDimensionPixelSize(2131297497);
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131377835));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout = ((ThemeTabLayout)findViewById(2131378847));
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(4);
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131299166);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onBindStateChanged state: " + paramInt);
    }
    h();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.c();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    label266:
    for (;;)
    {
      super.a(paramInt1, paramInt2, paramIntent);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.c();
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "REQ_CODE_BIND_NUMBER resultCode: " + paramInt1 + ", src: " + 15);
      }
      if (paramInt2 == -1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.c();
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.getCount() > 0) {}
        for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.getItem(0);; localObject = null)
        {
          if ((!(localObject instanceof NewFriendBindContactGuideBuilderV2)) || (!((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).a(true))) {
            break label266;
          }
          ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1, 2, null);
          break;
        }
      }
    }
  }
  
  public void a(long paramLong) {}
  
  protected void a(Intent paramIntent, BaseNewFriendView.INewFriendContext paramINewFriendContext)
  {
    super.a(paramIntent, paramINewFriendContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER));
    ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).a(this);
    n();
    h();
    a(paramIntent);
    l();
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager = ((MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839537);
      return;
    }
    paramView.setBackgroundResource(2130850652);
  }
  
  public void a(String paramString)
  {
    int k = 0;
    String str;
    if (!((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).i())
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getString("systemmsg_addFriendCount", "");
      if (!TextUtils.isEmpty(str)) {
        break label66;
      }
    }
    label66:
    for (String[] arrayOfString = new String[0]; arrayOfString.length >= 3; arrayOfString = str.split(":")) {
      return;
    }
    int m = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < m)
      {
        if (TextUtils.equals(arrayOfString[i], paramString)) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putString("systemmsg_addFriendCount", str).commit();
        return;
      }
      i += 1;
    }
    if (arrayOfString.length == 0) {}
    for (;;)
    {
      str = paramString;
      if (arrayOfString.length + 1 != 3) {
        break;
      }
      str = paramString;
      break;
      paramString = str + ":" + paramString;
    }
  }
  
  public void a(ArrayList<ConnectionsTabInfo> paramArrayList, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$OnTabSelectedListener);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.a(paramArrayList, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.setOnTabSelectedListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$OnTabSelectedListener);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public boolean a(int paramInt)
  {
    Object localObject = this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((localObject != null) && ((localObject instanceof Boolean))) {
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
  
  public void b(int paramInt) {}
  
  protected void c()
  {
    super.c();
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onResume");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.f();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.b() == 23) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.i();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a(0L);
  }
  
  public void c(int paramInt) {}
  
  protected void d()
  {
    super.d();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.b() == 23) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.h();
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onPause");
    }
  }
  
  protected void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.e();
    NewFriendVerificationManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onStop");
    }
  }
  
  protected void f()
  {
    super.f();
    m();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager.f();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_b_of_type_AndroidUtilSparseArray.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.g();
    }
    FriendSystemMsgController.a().b();
    ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).b(this);
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager.j();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setOverscrollHeader(getResources().getDrawable(2130850507));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077C6", "0X80077C6", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOverscrollHeader(null);
  }
  
  public void i()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.getCount() > 0)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    catch (Exception localException) {}
  }
  
  void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, a());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.jdField_a_of_type_AndroidContentContext.getString(2131719050));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      NewFriendVerificationManager.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      ReportController.b(null, "dc00898", "", "", "0X800A3A5", "0X800A3A5", 0, 0, "", "", "", "");
    }
  }
  
  public void setSelection(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.getCount())) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setSelection(paramInt);
    }
  }
  
  public void setStickHeadSelection(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.newfriendSystemMsgListView", 2, "setStickHeadSelection position : " + paramInt);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsThemeTabLayout.a(paramInt);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new SystemMsgListView.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView
 * JD-Core Version:    0.7.0.1
 */