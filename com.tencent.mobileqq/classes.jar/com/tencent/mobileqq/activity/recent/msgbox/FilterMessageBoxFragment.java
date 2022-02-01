package com.tencent.mobileqq.activity.recent.msgbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class FilterMessageBoxFragment
  extends IphoneTitleBarFragment
  implements GestureDetector.OnGestureListener, View.OnTouchListener, OnRecentUserOpsListener, DragFrameLayout.OnDragModeChangedListener, Observer
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  RecentAdapter jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
  protected DragFrameLayout a;
  private TempMsgBoxObserver jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxTempMsgBoxObserver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ThreadExcutor.IThreadListener jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new FilterMessageBoxFragment.9(this);
  FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  protected boolean a;
  private boolean b = true;
  private volatile boolean c = false;
  
  private List<RecentBaseData> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = FilterMsgBoxRecentUserUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).iterator();
    RecentUser localRecentUser;
    while (((Iterator)localObject1).hasNext())
    {
      localRecentUser = (RecentUser)((Iterator)localObject1).next();
      localObject2 = new MessageRecord();
      ((MessageRecord)localObject2).istroop = localRecentUser.getType();
      ((MessageRecord)localObject2).senderuin = localRecentUser.uin;
      localArrayList.add(localObject2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("FilterMessageBoxFragment", 2, "fillData() called " + localArrayList);
    }
    Object localObject2 = new ArrayList();
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    int i = 0;
    while (i < localArrayList.size())
    {
      localObject1 = (MessageRecord)localArrayList.get(i);
      String str = ((MessageRecord)localObject1).senderuin;
      int j = ((MessageRecord)localObject1).istroop;
      localRecentUser = localRecentUserProxy.b(str, j);
      localObject1 = localRecentUser;
      if (localRecentUser == null) {
        localObject1 = new RecentUser(str, j);
      }
      localObject1 = new RecentItemFilterMsgBoxData((RecentUser)localObject1);
      ((RecentItemFilterMsgBoxData)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
      ((List)localObject2).add(localObject1);
      i += 1;
    }
    return localObject2;
  }
  
  private void a(int paramInt, String paramString)
  {
    if (ThemeUtil.isDefaultOrDIYTheme(false)) {}
    for (TextView localTextView = this.mLeftBackText; localTextView == null; localTextView = this.jdField_a_of_type_AndroidWidgetTextView) {
      return;
    }
    if (paramInt <= 0)
    {
      localTextView.setVisibility(4);
      return;
    }
    localTextView.setVisibility(0);
    localTextView.setText(paramString);
    localTextView.setContentDescription(paramString);
  }
  
  private void a(RecentBaseData paramRecentBaseData)
  {
    if (paramRecentBaseData != null)
    {
      RecentUser localRecentUser = null;
      int i = -1;
      if ((paramRecentBaseData instanceof RecentItemFilterMsgBoxData))
      {
        paramRecentBaseData = (RecentItemFilterMsgBoxData)paramRecentBaseData;
        localRecentUser = paramRecentBaseData.a();
        i = paramRecentBaseData.mPosition;
      }
      if (localRecentUser != null) {
        RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser, i);
      }
    }
  }
  
  private void b()
  {
    if (this.c) {
      return;
    }
    ThreadManager.excute(new FilterMessageBoxFragment.2(this), 32, this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
  }
  
  private void c()
  {
    setTitle(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692525));
    this.rightViewText.setText(2131718525);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setOnClickListener(new FilterMessageBoxFragment.3(this));
    e();
  }
  
  private void d()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    localActionSheet.setMainTitle(2131718527);
    localActionSheet.addButton(2131718526, 3);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new FilterMessageBoxFragment.4(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void e()
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      f();
    }
    FragmentActivity localFragmentActivity;
    do
    {
      return;
      localFragmentActivity = getActivity();
    } while (localFragmentActivity == null);
    localFragmentActivity.runOnUiThread(new FilterMessageBoxFragment.5(this));
  }
  
  private void f()
  {
    if ((this.leftView == null) || (this.mLeftBackText == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null) || (!isAdded())) {
      return;
    }
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.leftView.setVisibility(8);
      this.mLeftBackIcon.setVisibility(0);
      this.mLeftBackIcon.setContentDescription(HardCodeUtil.a(2131715061));
      AIOUtils.a(this.mLeftBackText, 0, 0, 0, (int)(30.0F * this.mDensity + 0.5F));
      ThreadManager.post(new FilterMessageBoxFragment.6(this), 8, null, true);
      return;
    }
    this.leftView.setVisibility(0);
    Object localObject = getResources().getColorStateList(2131167030);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject);
    GradientDrawable localGradientDrawable = (GradientDrawable)this.jdField_a_of_type_AndroidWidgetTextView.getBackground();
    if (localGradientDrawable != null)
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label279;
      }
      localGradientDrawable.setColor((ColorStateList)localObject);
    }
    for (;;)
    {
      localGradientDrawable.setAlpha(46);
      if (!ThemeUtil.isNowThemeIsSimple(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(28.0F, getResources());
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = (RelativeLayout.LayoutParams)this.leftView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(5.0F, getResources());
        this.leftView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      this.mLeftBackIcon.setVisibility(8);
      this.mLeftBackText.setVisibility(8);
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      break;
      label279:
      localGradientDrawable.setColor(((ColorStateList)localObject).getDefaultColor());
    }
  }
  
  private void g()
  {
    Object localObject = ((TempMsgBoxManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ConversationFacade localConversationFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade();
    int i = RecentItemTempMsgBoxData.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject, localConversationFacade);
    if (i > 99) {
      localObject = "99+";
    }
    for (;;)
    {
      getActivity().runOnUiThread(new FilterMessageBoxFragment.7(this, i, (String)localObject));
      return;
      if (i <= 0) {
        localObject = "";
      } else {
        localObject = String.valueOf(i);
      }
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)this.mContentView.findViewById(2131366981));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(0);
    View localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559243, null);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView(localView);
    localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559002, null);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addFooterView(localView);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this, 14);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(22);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
  }
  
  public void a()
  {
    ThreadManager.excute(new FilterMessageBoxFragment.8(this), 32, null, true);
  }
  
  public void a(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == -1))
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    this.jdField_a_of_type_Int = (this.jdField_a_of_type_Int & (paramInt ^ 0xFFFFFFFF) | paramInt);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (paramRecentBaseData == null) {}
    while (!(paramRecentBaseData instanceof RecentItemFilterMsgBoxData)) {
      return;
    }
    paramView = ((RecentItemFilterMsgBoxData)paramRecentBaseData).a();
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_OPEN_AIO_INTENT_CLASS_NAME", ChatActivity.class.getName());
    RecentUtil.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, paramString, paramBoolean, 3, paramRecentBaseData, localBundle, null);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B5C8", "0X800B5C8", 0, 0, "", "", "", "");
  }
  
  public void a(View paramView, Object paramObject) {}
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      a(paramRecentBaseData);
    }
    do
    {
      return;
      paramString = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
    } while ((paramString == null) || (paramRecentBaseData == null));
    try
    {
      paramString.b(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType());
      return;
    }
    catch (Exception paramRecentBaseData)
    {
      QLog.e("FilterMessageBoxFragment", 1, "delRecentCallByUin Error");
    }
  }
  
  protected void a(RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    String str = paramRecentBaseData.getRecentUserUin();
    int i = paramRecentBaseData.getRecentUserType();
    if ((str == null) || (str.length() == 0) || (localRecentUserProxy == null))
    {
      if (QLog.isColorLevel())
      {
        paramRecentBaseData = new StringBuilder().append("onMenuItemClick error, %s ");
        if (str != null) {
          break label107;
        }
        paramBoolean = true;
        paramRecentBaseData = paramRecentBaseData.append(paramBoolean).append(" ");
        if (localRecentUserProxy != null) {
          break label112;
        }
      }
      label107:
      label112:
      for (paramBoolean = bool;; paramBoolean = false)
      {
        QLog.d("FilterMessageBoxFragment", 2, paramBoolean);
        return;
        paramBoolean = false;
        break;
      }
    }
    paramString = localRecentUserProxy.b(str, i);
    paramRecentBaseData = paramString;
    if (paramString == null) {
      paramRecentBaseData = new RecentUser(str, i);
    }
    if (paramBoolean) {}
    for (paramRecentBaseData.showUpTime = (System.currentTimeMillis() / 1000L);; paramRecentBaseData.showUpTime = 0L)
    {
      localRecentUserProxy.b(paramRecentBaseData);
      return;
    }
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    Resources localResources = getResources();
    if (Utils.a(paramString1, localResources.getString(2131691339))) {
      a(paramRecentBaseData, paramString2, false);
    }
    for (;;)
    {
      e();
      b();
      return;
      if (Utils.a(paramString1, localResources.getString(2131691342))) {
        a(paramRecentBaseData, paramString2, true);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 0;
  }
  
  public boolean a(int paramInt)
  {
    return (!b()) && ((this.jdField_a_of_type_Int & paramInt) == paramInt);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int == -1;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_AndroidViewGestureDetector != null) && (this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent))) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Float = (ViewConfiguration.get(getActivity()).getScaledDoubleTapSlop() * 2);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, this);
    paramLayoutInflater = this.mContentView.findViewById(2131366982);
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater.setOnTouchListener(this);
      paramLayoutInflater.setLongClickable(true);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.titleRoot.findViewById(2131369525));
    h();
    c();
    b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
  }
  
  public int getContentLayoutId()
  {
    return 2131559242;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needDispatchTouchEvent()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxTempMsgBoxObserver = new FilterMessageBoxFragment.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxTempMsgBoxObserver);
    if (QLog.isColorLevel()) {
      QLog.e("FilterMessageBoxFragment", 2, new Object[] { "doOnCreate ", this.jdField_a_of_type_AndroidContentContext });
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxTempMsgBoxObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
    }
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    a(0);
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((a()) || (b())) {
      return false;
    }
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
      return false;
    }
    paramFloat1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    paramFloat2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat1);
    if (a(1))
    {
      if ((paramFloat1 < 0.0F) && (paramFloat2 < 0.5F))
      {
        a(-1);
        if (this.b)
        {
          getActivity().finish();
          return true;
        }
        this.b = true;
        return false;
      }
    }
    else if ((a(2)) && (paramFloat1 > 0.0F) && (paramFloat2 < 0.5F))
    {
      a(-1);
      this.b = false;
      return false;
    }
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public void onResume()
  {
    super.onResume();
    e();
    b();
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (b()) {}
    float f;
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
              return false;
            } while ((paramMotionEvent1 == null) || (paramMotionEvent2 == null));
            paramFloat2 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
            f = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat2);
            if (!a()) {
              break;
            }
          } while (Math.abs(paramFloat2) <= this.jdField_a_of_type_Float);
          if ((paramFloat1 < 0.0F) && (f < 0.5F))
          {
            a(1);
            return true;
          }
        } while ((paramFloat1 <= 0.0F) || (f >= 0.5F));
        a(2);
        return true;
        if (!a(1)) {
          break;
        }
      } while ((paramFloat1 <= 0.0F) && (f < 0.5F));
      a(-1);
      return false;
    } while ((!a(2)) || ((paramFloat1 >= 0.0F) && (f < 0.5F)));
    a(-1);
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    a(-1);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return (this.jdField_a_of_type_AndroidViewGestureDetector != null) && (this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent));
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    e();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.FilterMessageBoxFragment
 * JD-Core Version:    0.7.0.1
 */