package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.NewFriendMoreInfo;
import com.tencent.mobileqq.data.NewFriendSubTitle;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.mobileqq.newfriend.NewFriendMoreInfoMessage;
import com.tencent.mobileqq.newfriend.NewFriendSubTitleMessage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import wjx;
import wjy;
import wjz;
import wka;
import wkb;
import wkc;
import wkd;

public class SystemMsgListView
  extends BaseNewFriendView
  implements PhoneContactManager.IPhoneContactListener, Observer
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  private SystemMsgListAdapter jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter;
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new wkb(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new wka(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new wkc(this);
  private NewFriendManager jdField_a_of_type_ComTencentMobileqqAppNewFriendManager;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new wkd(this);
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  public boolean a;
  private final int b = 0;
  
  public SystemMsgListView(Context paramContext, FlingHandler paramFlingHandler)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new wjx(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = paramFlingHandler;
  }
  
  private void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("EntranceId", 0);
    this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter = new SystemMsgListAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, this, i, this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter);
    i();
  }
  
  private void e(int paramInt)
  {
    if ((((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).getActivity() == null) || (this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter == null)) {}
    Object localObject1;
    Object localObject2;
    int i;
    label185:
    label201:
    label235:
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.jdField_a_of_type_Boolean) && (paramInt == 0))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        return;
      }
      if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.getCount()))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        return;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.getItem(paramInt);
      if (!(localObject1 instanceof NewFriendSubTitleBuilder)) {
        break;
      }
      localObject1 = ((NewFriendSubTitleMessage)((NewFriendSubTitleBuilder)localObject1).a).a.title;
      if (paramInt + 1 < this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.getCount())
      {
        if (!((NewFriendBaseBuilder)this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.getItem(paramInt + 1) instanceof NewFriendSubTitleBuilder)) {
          break label406;
        }
        localObject2 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(0);
        if (localObject2 != null)
        {
          i = ((View)localObject2).getBottom();
          localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
          if (i >= this.jdField_a_of_type_Int) {
            break label397;
          }
          ((RelativeLayout.LayoutParams)localObject2).topMargin = (i - this.jdField_a_of_type_Int);
          this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
        }
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      localObject1 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(0);
      if (localObject1 == null) {
        break label451;
      }
      i = ((View)localObject1).getBottom();
      if (QLog.isColorLevel()) {
        QLog.d("Q.newfriendSystemMsgListView", 2, "setFloatingVew|firstVisibleItemBottom: " + i);
      }
    } while ((this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) || (paramInt != 0) || (i < this.jdField_a_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    return;
    if ((localObject1 instanceof NewFriendMoreInfoBuilder))
    {
      localObject1 = ((NewFriendMoreInfoMessage)((NewFriendMoreInfoBuilder)localObject1).a).a;
      if (((NewFriendMoreInfo)localObject1).type == 1000) {
        localObject1 = getResources().getString(2131433325);
      }
    }
    for (;;)
    {
      break;
      if (((NewFriendMoreInfo)localObject1).type == 1001)
      {
        localObject1 = getResources().getString(2131433328);
        continue;
        if ((localObject1 instanceof SystemMsgItemBuilder))
        {
          localObject1 = getResources().getString(2131433325);
          break;
        }
        localObject1 = getResources().getString(2131433328);
        break;
        label397:
        ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
        break label185;
        label406:
        localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        if (((RelativeLayout.LayoutParams)localObject2).topMargin == 0) {
          break label201;
        }
        ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
        break label201;
        label451:
        i = 0;
        break label235;
      }
      localObject1 = null;
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
  }
  
  private void n()
  {
    super.d(2130970639);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131371534));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371535));
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131369964));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370882);
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131559382);
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131558448);
  }
  
  public void a(int paramInt)
  {
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if (paramInt > 5)
    {
      h();
      this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.c();
    }
    while (paramInt != 1) {
      return;
    }
    h();
    this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.c();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.a(paramInt1, paramInt2, paramIntent);
      return;
      this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.c();
      continue;
      if (paramInt2 == -1)
      {
        ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 222);
        this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.c();
      }
    }
  }
  
  public void a(long paramLong) {}
  
  protected void a(Intent paramIntent, BaseNewFriendView.INewFriendContext paramINewFriendContext)
  {
    super.a(paramIntent, paramINewFriendContext);
    this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33));
    ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a(this);
    n();
    h();
    a(paramIntent);
    l();
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
  }
  
  public void a(String paramString)
  {
    int k = 0;
    String str;
    if (!((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).g())
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getString("systemmsg_addFriendCount", "");
      if (!TextUtils.isEmpty(str)) {
        break label65;
      }
    }
    label65:
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
      this.jdField_a_of_type_Boolean = true;
      str = paramString;
      break;
      paramString = str + ":" + paramString;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void b(int paramInt) {}
  
  protected void c()
  {
    super.c();
    if (this.jdField_a_of_type_Boolean)
    {
      int i = ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).b().size();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(getContext(), 230);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage("在通讯录中发现了" + i + "位小伙伴在使用QQ，绑定手机号，第一时间找到他们。");
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle("绑定手机号码");
      wjy localwjy = new wjy(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton("暂不", localwjy);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton("绑定", localwjy);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      this.jdField_a_of_type_Boolean = false;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077C8", "0X80077C8", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.g();
    this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.j();
  }
  
  public void c(int paramInt) {}
  
  protected void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.i();
  }
  
  protected void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.f();
  }
  
  protected void f()
  {
    super.f();
    m();
    this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.d();
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.h();
    }
    FriendSystemMsgController.a().b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).b(this);
  }
  
  public void h()
  {
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    int i = localPhoneContactManager.c();
    if ((i == 1) || (i == 5))
    {
      i = localSharedPreferences.getInt("system_msg_list_showcount", 0) + 1;
      if (i <= 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setOverscrollHeader(getResources().getDrawable(2130845871));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077C6", "0X80077C6", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        localSharedPreferences.edit().putInt("system_msg_list_showcount", i).commit();
        return;
        this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setOverscrollHeader(null);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOverscrollHeader(null);
    localSharedPreferences.edit().putInt("system_msg_list_showcount", 0).commit();
  }
  
  public void i()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.getCount() > 0)
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.jdField_a_of_type_AndroidContentContext.getString(2131434453));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  }
  
  public void setSelection(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.getCount())) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setSelection(paramInt);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new wjz(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView
 * JD-Core Version:    0.7.0.1
 */