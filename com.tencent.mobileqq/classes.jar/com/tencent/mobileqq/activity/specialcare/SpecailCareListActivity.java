package com.tencent.mobileqq.activity.specialcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid.GridCallBack;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.ActivateFriendItem;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.richstatus.ExtensionRichStatus;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.settings.config.SettingsConfigHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.QQStoryCoverImageViewHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.util.BadgeUtils;
import com.tencent.util.notification.NotifyIdManager;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x7df.oidb_0x7df.FriendScore;

public class SpecailCareListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, ActivateFriendGrid.GridCallBack, DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  static final String jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131714112);
  static final String jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131714113);
  int jdField_a_of_type_Int;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler jdField_a_of_type_AndroidOsHandler = new SpecailCareListActivity.1(this);
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new SpecailCareListActivity.5(this);
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  ActivateFriendGrid jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid;
  SpecailCareListActivity.SpecailCareListAdapter jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$SpecailCareListAdapter;
  SpecailCareListActivity.StatusIconListener jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$StatusIconListener = new SpecailCareListActivity.3(this);
  private CardHandler jdField_a_of_type_ComTencentMobileqqAppCardHandler;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new SpecailCareListActivity.6(this);
  FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new SpecailCareListActivity.4(this);
  FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new SpecailCareListActivity.2(this);
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  ArrayList<SpecailCareListActivity.RecommendFriend> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  ArrayList<Entity> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  View jdField_c_of_type_AndroidViewView;
  private String jdField_c_of_type_JavaLangString = "";
  boolean jdField_c_of_type_Boolean = false;
  int d = 0;
  private int e;
  
  public int a(View paramView, SpecailCareListActivity.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    int j = getResources().getDimensionPixelSize(2131296811);
    if (paramBoolean) {
      return j;
    }
    int i = 0;
    XListView localXListView = this.jdField_a_of_type_ComTencentWidgetXListView;
    if (localXListView != null) {
      i = localXListView.getWidth();
    }
    i = paramViewHolder.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a(paramView, paramViewHolder, j, i);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("getNickRightMargin=");
      paramView.append(i);
      QLog.d("SpecailCareListActivity", 2, paramView.toString());
    }
    return i;
  }
  
  SpannableString a(Friends paramFriends, SpecailCareListActivity.ViewHolder paramViewHolder)
  {
    Object localObject1 = (StatusManager)this.app.getManager(QQManagerFactory.STATUS_MANAGER);
    Object localObject2 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject1 != null)
    {
      if (localObject2 == null) {
        return null;
      }
      localObject1 = ((FriendsManager)localObject2).a(paramFriends.uin);
      int m = 0;
      int i;
      if ((localObject1 != null) && (!TextUtils.isEmpty(((ExtensionInfo)localObject1).feedContent))) {
        i = 1;
      } else {
        i = 0;
      }
      if (localObject1 != null)
      {
        boolean bool;
        if (this.d != 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramFriends = ExtensionRichStatus.a((ExtensionInfo)localObject1, bool);
      }
      else
      {
        paramFriends = null;
      }
      int j;
      if ((paramFriends != null) && (!paramFriends.isEmpty())) {
        j = 1;
      } else {
        j = 0;
      }
      int k;
      if ((j != 0) && (!TextUtils.isEmpty(paramFriends.actionText))) {
        k = 1;
      } else {
        k = 0;
      }
      if ((i != 0) && ((((ExtensionInfo)localObject1).feedTime > ((ExtensionInfo)localObject1).richTime) || (j == 0)))
      {
        paramFriends = new SpannableString(((ExtensionInfo)localObject1).feedContent);
        paramViewHolder.b.setCompoundDrawables(null, null, null, null);
        if (((ExtensionInfo)localObject1).feedType == 2)
        {
          paramViewHolder.e.setVisibility(0);
          if (!TextUtils.isEmpty(((ExtensionInfo)localObject1).feedPhotoUrl)) {
            QQStoryCoverImageViewHelper.a(paramViewHolder.e, ((ExtensionInfo)localObject1).feedPhotoUrl, getResources().getDrawable(2130850613));
          } else {
            paramViewHolder.e.setImageDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850613));
          }
          paramViewHolder.f.setVisibility(8);
          paramViewHolder.g.setVisibility(8);
        }
        else
        {
          paramViewHolder.f.setVisibility(0);
          localObject2 = paramViewHolder.f;
          if (((ExtensionInfo)localObject1).feedType == 1) {
            i = 2130849885;
          } else {
            i = 2130849883;
          }
          ((ImageView)localObject2).setBackgroundResource(i);
          localObject2 = paramViewHolder.g;
          if (((ExtensionInfo)localObject1).feedHasPhoto) {
            i = m;
          } else {
            i = 8;
          }
          ((ImageView)localObject2).setVisibility(i);
          paramViewHolder.e.setVisibility(8);
          paramViewHolder.e.setImageDrawable(null);
        }
      }
      else
      {
        if (k != 0)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramFriends.actionId, 200);
          localObject1 = new BitmapDrawable(getResources(), (Bitmap)localObject1);
          i = this.jdField_b_of_type_Int;
          ((Drawable)localObject1).setBounds(0, 0, Math.round(((Drawable)localObject1).getIntrinsicWidth() * 1.0F / ((Drawable)localObject1).getIntrinsicHeight() * i), i);
          paramViewHolder.b.setCompoundDrawables((Drawable)localObject1, null, null, null);
        }
        else if (j == 0)
        {
          paramFriends = RichStatus.getEmptyStatus();
          paramViewHolder.b.setCompoundDrawables(null, null, null, null);
        }
        paramFriends = paramFriends.toSpannableString(null);
        paramViewHolder.f.setVisibility(8);
        paramViewHolder.g.setVisibility(8);
        paramViewHolder.e.setVisibility(8);
        paramViewHolder.e.setImageDrawable(null);
      }
      paramViewHolder.b.setText(paramFriends);
      return paramFriends;
    }
    return null;
  }
  
  void a()
  {
    long l1 = System.currentTimeMillis();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.f();
    int j = 0;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      this.rightViewText.setVisibility(0);
      if (this.jdField_c_of_type_Boolean)
      {
        this.rightViewText.setText(jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      else
      {
        this.rightViewText.setText(jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      int i = j;
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getSpecailCareInfos return size:");
        ((StringBuilder)localObject2).append(((List)localObject1).size());
        QLog.d("SpecailCareListActivity", 2, ((StringBuilder)localObject2).toString());
        i = j;
      }
      while (i < ((List)localObject1).size())
      {
        localObject2 = (SpecialCareInfo)((List)localObject1).get(i);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(((SpecialCareInfo)localObject2).uin);
        if (localObject2 != null) {
          this.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
        }
        i += 1;
      }
      ThreadManager.post(new SpecailCareListActivity.7(this), 8, null, true);
    }
    else
    {
      b();
      this.leftView.setVisibility(0);
      this.jdField_c_of_type_Boolean = false;
      this.rightViewText.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("SpecailCareListActivity", 2, "getSpecailCareInfos: empty...");
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("refreshSpecialCareData cost time = ");
      ((StringBuilder)localObject1).append(l2 - l1);
      QLog.d("SpecailCareListActivity", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = getPreferences(0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enterSpecailCare");
    localStringBuilder.append(this.app.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean).commit();
  }
  
  boolean a(int paramInt)
  {
    SharedPreferences localSharedPreferences = getPreferences(0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enterSpecailCare");
    localStringBuilder.append(this.app.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false) ^ true;
  }
  
  void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$SpecailCareListAdapter;
    if ((localObject != null) && (((SpecailCareListActivity.SpecailCareListAdapter)localObject).a() != null)) {
      return;
    }
    if (((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a() > 0) {
      ReportController.b(this.app, "CliOper", "", "", "0X80050E0", "0X80050E0", 0, 0, "", "", "", "");
    } else {
      ReportController.b(this.app, "CliOper", "", "", "0X80050DF", "0X80050DF", 0, 0, "", "", "", "");
    }
    localObject = getLayoutInflater().inflate(2131561492, null);
    SpecailCareListActivity.SpecailCareListAdapter localSpecailCareListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$SpecailCareListAdapter;
    if (localSpecailCareListAdapter != null) {
      localSpecailCareListAdapter.a((View)localObject);
    }
  }
  
  void c()
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X80050DA", "0X80050DA", 0, 0, "", "", "", "");
    this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131561495, null);
    Object localObject1 = new FrameLayout.LayoutParams(-1, -1);
    int j = AIOUtils.b(75.0F, getResources());
    int i = 0;
    ((FrameLayout.LayoutParams)localObject1).setMargins(0, j, 0, 0);
    this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new SpecailCareListActivity.8(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131362183));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid = ((ActivateFriendGrid)this.jdField_c_of_type_AndroidViewView.findViewById(2131367814));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setGridCallBack(this);
    localObject1 = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (SpecailCareListActivity.RecommendFriend)localIterator.next();
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
      if ((localObject3 != null) && (!((FriendsManager)localObject3).b(((SpecailCareListActivity.RecommendFriend)localObject2).jdField_a_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(((SpecailCareListActivity.RecommendFriend)localObject2).jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject3).append(" is not friend.. ");
          QLog.d("SpecialCare", 2, ((StringBuilder)localObject3).toString());
        }
      }
      else
      {
        localObject2 = new ActivateFriendItem(1, Long.valueOf(((SpecailCareListActivity.RecommendFriend)localObject2).jdField_a_of_type_JavaLangString).longValue(), ((SpecailCareListActivity.RecommendFriend)localObject2).jdField_b_of_type_JavaLangString);
        if (i < 6)
        {
          ((ArrayList)localObject1).add(localObject2);
          i += 1;
        }
      }
    }
    ReportController.b(this.app, "CliOper", "", "", "0X80050DC", "0X80050DC", 0, 0, String.valueOf(i), "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setData(this.app, (ArrayList)localObject1);
    if (this.jdField_c_of_type_AndroidViewView.getParent() == null) {
      if (Build.VERSION.SDK_INT < 14) {
        ((ViewGroup)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent().getParent()).addView(this.jdField_c_of_type_AndroidViewView);
      } else {
        ((FrameLayout)getWindow().getDecorView()).addView(this.jdField_c_of_type_AndroidViewView);
      }
    }
    setRightButton(2131699040, this);
  }
  
  void d()
  {
    Object localObject = this.jdField_c_of_type_AndroidViewView;
    if ((localObject != null) && (((View)localObject).getParent() != null)) {
      if (Build.VERSION.SDK_INT < 14)
      {
        ((ViewGroup)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent().getParent()).removeView(this.jdField_c_of_type_AndroidViewView);
        this.jdField_c_of_type_AndroidViewView = null;
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid;
        if (localObject != null)
        {
          ((ActivateFriendGrid)localObject).a();
          this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid = null;
        }
      }
      else
      {
        localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 2, -1.0F);
        ((TranslateAnimation)localObject).setInterpolator(new AccelerateInterpolator());
        ((TranslateAnimation)localObject).setDuration(500L);
        ((TranslateAnimation)localObject).setFillAfter(true);
        ((TranslateAnimation)localObject).setAnimationListener(new SpecailCareListActivity.9(this));
        this.jdField_c_of_type_AndroidViewView.startAnimation((Animation)localObject);
      }
    }
    this.rightViewText.setVisibility(4);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    super.doOnCreate(paramBundle);
    setContentView(2131561494);
    super.setTitle(2131716891);
    super.setRightButton(2131693880, this);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_Int = ((int)DisplayUtils.a(this, 9.0F));
    this.jdField_b_of_type_Int = ((int)DisplayUtils.a(this, 12.0F));
    this.jdField_c_of_type_Int = ((int)DisplayUtils.a(this, 20.0F));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131376667));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131370153));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131366895);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)getLayoutInflater().inflate(2131561491, null));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$SpecailCareListAdapter = new SpecailCareListActivity.SpecailCareListAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$SpecailCareListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)getLayoutInflater().inflate(2131559963, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeight(getResources().getDimensionPixelSize(2131298921));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130844953);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(QQManagerFactory.STATUS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$StatusIconListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377751));
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
    this.jdField_c_of_type_JavaLangString = this.app.getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    boolean bool = NotifyIdManager.a();
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("initUI: invoked. special bar enable: ");
      paramBundle.append(bool);
      QLog.i("SpecailCareListActivity", 2, paramBundle.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.c(bool);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131716892));
    if (SettingsConfigHelper.a(this.app)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    }
    a();
    if ((this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) && (a(1)))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getFriendGroupList(true);
      FriendListHandler.getSpecialRecommendStat = 2;
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getRecommendList();
      if ((paramBundle != null) && (paramBundle.size() > 0))
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("fh.getRecommendList() return size:");
          ((StringBuilder)localObject).append(paramBundle.size());
          QLog.d("SpecailCareListActivity", 2, ((StringBuilder)localObject).toString());
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        paramBundle = paramBundle.iterator();
        while (paramBundle.hasNext())
        {
          localObject = (oidb_0x7df.FriendScore)paramBundle.next();
          SpecailCareListActivity.RecommendFriend localRecommendFriend = new SpecailCareListActivity.RecommendFriend();
          localRecommendFriend.jdField_a_of_type_JavaLangString = String.valueOf(((oidb_0x7df.FriendScore)localObject).uint64_friend_uin.get());
          Friends localFriends = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(localRecommendFriend.jdField_a_of_type_JavaLangString);
          if (localFriends != null) {
            localRecommendFriend.jdField_b_of_type_JavaLangString = ContactUtils.a(localFriends);
          }
          if ((TextUtils.isEmpty(localRecommendFriend.jdField_b_of_type_JavaLangString)) && (((oidb_0x7df.FriendScore)localObject).bytes_nick != null) && (((oidb_0x7df.FriendScore)localObject).bytes_nick.get() != null)) {
            localRecommendFriend.jdField_b_of_type_JavaLangString = ((oidb_0x7df.FriendScore)localObject).bytes_nick.get().toStringUtf8();
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(localRecommendFriend);
        }
        c();
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("SpecailCareListActivity", 2, "fh.getRecommendList(): empty...");
      }
    }
    a(1, true);
    a(2, true);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("doOnCreate cost time = ");
      paramBundle.append(l2 - l1);
      QLog.d("SpecailCareListActivity", 2, paramBundle.toString());
    }
    if (AppSetting.d)
    {
      this.leftView.setContentDescription(HardCodeUtil.a(2131714109));
      this.jdField_a_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131714110));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getOnlineFriend(this.app.getCurrentAccountUin(), (byte)3);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    if (this.app != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      if (BadgeUtils.a(this.app.getApplication())) {
        BadgeUtils.c();
      }
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$StatusIconListener);
    h();
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid;
    if (localObject != null)
    {
      ((ActivateFriendGrid)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid = null;
    }
  }
  
  void e()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      return;
    }
    if (this.jdField_c_of_type_AndroidViewView != null) {
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X80050DB", "0X80050DB", 0, 0, "", "", "", "");
    FrameLayout localFrameLayout = (FrameLayout)getWindow().getDecorView();
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131561493, null);
    Button localButton = (Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131369690);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131374288).setOnClickListener(this);
    localButton.setOnClickListener(this);
    if (this.jdField_b_of_type_AndroidViewView.getParent() == null) {
      localFrameLayout.addView(this.jdField_b_of_type_AndroidViewView);
    }
  }
  
  void f()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if ((localView != null) && (localView.getParent() != null))
    {
      ((FrameLayout)getWindow().getDecorView()).removeView(this.jdField_b_of_type_AndroidViewView);
      this.jdField_b_of_type_AndroidViewView = null;
    }
  }
  
  void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131689703);
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  void h()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
  }
  
  void i()
  {
    this.rightViewText.setClickable(false);
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    Object localObject1 = this.rightViewText.getText().toString();
    if (jdField_a_of_type_JavaLangString.equals(localObject1))
    {
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)
      {
        localObject1 = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject1).setDuration(300L);
        ((AlphaAnimation)localObject1).setAnimationListener(new SpecailCareListActivity.10(this));
        this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject1);
      }
      int i = 0;
      while (i < j)
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
        localObject1 = ((View)localObject2).getTag();
        if ((localObject1 != null) && ((localObject1 instanceof SpecailCareListActivity.ViewHolder)))
        {
          localObject1 = (SpecailCareListActivity.ViewHolder)localObject1;
          int k = a((View)localObject2, (SpecailCareListActivity.ViewHolder)localObject1, true);
          localObject2 = new TranslateAnimation(-(this.mDensity * 34.0F), 0.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          Object localObject3 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject3).setStartOffset(120L);
          ((AlphaAnimation)localObject3).setDuration(180L);
          AnimationSet localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          ((SpecailCareListActivity.ViewHolder)localObject1).c.setVisibility(0);
          ((TranslateAnimation)localObject2).setAnimationListener(new SpecailCareListActivity.11(this, (SpecailCareListActivity.ViewHolder)localObject1));
          ((SpecailCareListActivity.ViewHolder)localObject1).c.startAnimation(localAnimationSet);
          localObject2 = new TranslateAnimation(0.0F, this.mDensity * 34.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          ((TranslateAnimation)localObject2).setAnimationListener(new SpecailCareListActivity.12(this, (SpecailCareListActivity.ViewHolder)localObject1));
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject2);
          localObject2 = new TranslateAnimation(0.0F, this.mDensity * 34.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.mDensity * 12.0F);
          ((TranslateAnimation)localObject3).setDuration(300L);
          localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.setFillAfter(true);
          localAnimationSet.setAnimationListener(new SpecailCareListActivity.13(this, (SpecailCareListActivity.ViewHolder)localObject1, k));
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.startAnimation(localAnimationSet);
          localObject2 = new TranslateAnimation(0.0F, this.mDensity * 34.0F, 0.0F, this.mDensity * -12.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject3).setDuration(300L);
          localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.setAnimationListener(new SpecailCareListActivity.14(this, (SpecailCareListActivity.ViewHolder)localObject1));
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
          localObject2 = new TranslateAnimation(0.0F, this.mDensity * 28.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject3).setDuration(240L);
          localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.setFillAfter(true);
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.startAnimation(localAnimationSet);
          localObject2 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject2).setDuration(300L);
          ((AlphaAnimation)localObject2).setFillAfter(true);
          ((SpecailCareListActivity.ViewHolder)localObject1).d.setVisibility(0);
          ((SpecailCareListActivity.ViewHolder)localObject1).d.startAnimation((Animation)localObject2);
        }
        if (i == j - 2)
        {
          localObject1 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject1).setDuration(300L);
          ((AlphaAnimation)localObject1).setAnimationListener(new SpecailCareListActivity.15(this));
          this.leftView.startAnimation((Animation)localObject1);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject1);
        }
        i += 1;
      }
    }
    if (jdField_b_of_type_JavaLangString.equals(localObject1)) {
      j();
    }
  }
  
  void j()
  {
    int k = this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition();
    int i = this.jdField_a_of_type_AndroidWidgetLinearLayout.getBottom();
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getBottom();
    if (k == this.jdField_a_of_type_ComTencentWidgetXListView.getCount() - 1)
    {
      k = this.jdField_c_of_type_Int;
      if ((i > k) && (j >= i - k)) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      } else {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    i = 0;
    while (i < j)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      Object localObject1 = ((View)localObject2).getTag();
      if ((localObject1 != null) && ((localObject1 instanceof SpecailCareListActivity.ViewHolder)))
      {
        localObject1 = (SpecailCareListActivity.ViewHolder)localObject1;
        k = a((View)localObject2, (SpecailCareListActivity.ViewHolder)localObject1, false);
        localObject2 = new TranslateAnimation(0.0F, -(this.mDensity * 34.0F), 0.0F, 0.0F);
        ((TranslateAnimation)localObject2).setDuration(300L);
        Object localObject3 = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject3).setDuration(180L);
        Object localObject4 = new AnimationSet(true);
        ((AnimationSet)localObject4).addAnimation((Animation)localObject2);
        ((AnimationSet)localObject4).addAnimation((Animation)localObject3);
        ((TranslateAnimation)localObject2).setAnimationListener(new SpecailCareListActivity.16(this, (SpecailCareListActivity.ViewHolder)localObject1));
        ((SpecailCareListActivity.ViewHolder)localObject1).c.startAnimation((Animation)localObject4);
        localObject2 = new TranslateAnimation(0.0F, -(this.mDensity * 34.0F), 0.0F, 0.0F);
        ((TranslateAnimation)localObject2).setDuration(300L);
        ((TranslateAnimation)localObject2).setAnimationListener(new SpecailCareListActivity.17(this, (SpecailCareListActivity.ViewHolder)localObject1));
        ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject2);
        localObject2 = new TranslateAnimation(0.0F, this.mDensity * -34.0F, 0.0F, 0.0F);
        ((TranslateAnimation)localObject2).setDuration(300L);
        localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.mDensity * -12.0F);
        ((TranslateAnimation)localObject3).setDuration(300L);
        localObject4 = new AnimationSet(true);
        ((AnimationSet)localObject4).addAnimation((Animation)localObject2);
        ((AnimationSet)localObject4).addAnimation((Animation)localObject3);
        ((AnimationSet)localObject4).setFillAfter(true);
        ((AnimationSet)localObject4).setAnimationListener(new SpecailCareListActivity.18(this, (SpecailCareListActivity.ViewHolder)localObject1, k));
        ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.startAnimation((Animation)localObject4);
        localObject2 = new TranslateAnimation(0.0F, this.mDensity * -34.0F, 0.0F, 0.0F);
        ((TranslateAnimation)localObject2).setDuration(300L);
        localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.mDensity * 12.0F);
        ((TranslateAnimation)localObject3).setDuration(300L);
        localObject4 = new AlphaAnimation(0.0F, 1.0F);
        ((AlphaAnimation)localObject4).setDuration(300L);
        AnimationSet localAnimationSet = new AnimationSet(true);
        localAnimationSet.addAnimation((Animation)localObject2);
        localAnimationSet.addAnimation((Animation)localObject3);
        localAnimationSet.addAnimation((Animation)localObject4);
        localAnimationSet.setFillAfter(true);
        localAnimationSet.setAnimationListener(new SpecailCareListActivity.19(this, (SpecailCareListActivity.ViewHolder)localObject1));
        ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
        localObject2 = new TranslateAnimation(this.mDensity * 24.0F, 0.0F, 0.0F, 0.0F);
        ((TranslateAnimation)localObject2).setDuration(300L);
        ((TranslateAnimation)localObject2).setFillAfter(true);
        localObject3 = new AlphaAnimation(0.0F, 1.0F);
        ((AlphaAnimation)localObject3).setStartOffset(60L);
        ((AlphaAnimation)localObject3).setDuration(240L);
        localObject4 = new AnimationSet(true);
        ((AnimationSet)localObject4).addAnimation((Animation)localObject2);
        ((AnimationSet)localObject4).addAnimation((Animation)localObject3);
        ((AnimationSet)localObject4).setFillAfter(true);
        ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.startAnimation((Animation)localObject4);
        localObject2 = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject2).setDuration(300L);
        ((AlphaAnimation)localObject2).setFillAfter(true);
        ((SpecailCareListActivity.ViewHolder)localObject1).d.startAnimation((Animation)localObject2);
      }
      if (i == j - 2)
      {
        localObject1 = new AlphaAnimation(0.0F, 1.0F);
        ((AlphaAnimation)localObject1).setDuration(300L);
        ((AlphaAnimation)localObject1).setAnimationListener(new SpecailCareListActivity.20(this));
        this.leftView.startAnimation((Animation)localObject1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject1);
      }
      i += 1;
    }
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      j();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    boolean bool = paramView instanceof ImageView;
    int i = 0;
    Object localObject1;
    Object localObject2;
    if ((bool) && (paramView.getTag() != null) && ((paramView.getTag() instanceof String)))
    {
      localObject1 = (String)paramView.getTag();
      if (!StringUtil.a((String)localObject1))
      {
        ReportController.b(this.app, "CliOper", "", "", "0X80050E1", "0X80050E1", 0, 0, "", "", "", "");
        if (NetworkUtil.isNetSupport(this))
        {
          localObject2 = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
          this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { localObject1 };
          ((FriendListHandler)localObject2).setSpecialCareSwitch(1, this.jdField_a_of_type_ArrayOfJavaLangString, new boolean[] { false });
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2002);
        }
        else
        {
          QQToast.a(this, getString(2131692183), 0).b(getTitleBarHeight());
        }
      }
    }
    else
    {
      switch (paramView.getId())
      {
      default: 
        localObject1 = paramView.getTag();
        if (localObject1 != null) {
          if ((localObject1 instanceof SpecailCareListActivity.ViewHolder)) {
            break;
          }
        }
        break;
      case 2131369690: 
        f();
        break;
      case 2131369233: 
        if (this.jdField_c_of_type_AndroidViewView != null)
        {
          d();
          ReportController.b(this.app, "CliOper", "", "", "0X80050DE", "0X80050DE", 0, 0, "", "", "", "");
        }
        else
        {
          i();
        }
        break;
      case 2131366206: 
        ReportController.b(this.app, "CliOper", "", "", "0X80050D9", "0X80050D9", 0, 0, "", "", "", "");
        localObject1 = new Intent(this, ForwardFriendListActivity.class);
        ((Intent)localObject1).putExtra("extra_choose_friend", 1);
        ((Intent)localObject1).putExtra("extra_add_special_friend", 2);
        startActivity((Intent)localObject1);
        overridePendingTransition(2130771993, 2130771991);
        break;
      case 2131362183: 
        if (!NetworkUtil.isNetSupport(this))
        {
          QQToast.a(this, getString(2131692183), 0).b(getTitleBarHeight());
          if (QLog.isColorLevel()) {
            QLog.i("SpecailCareListActivity", 2, "No Network!");
          }
        }
        else
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.a();
          localObject2 = new boolean[localObject1.length];
          String[] arrayOfString = new String[localObject1.length];
          this.jdField_a_of_type_ArrayOfJavaLangString = new String[arrayOfString.length];
          while (i < localObject1.length)
          {
            localObject2[i] = 1;
            arrayOfString[i] = String.valueOf(localObject1[i]);
            this.jdField_a_of_type_ArrayOfJavaLangString[i] = arrayOfString[i];
            i += 1;
          }
          g();
          if (QLog.isColorLevel()) {
            QLog.d("SpecailCareListActivity", 2, "setSpecialCareSwitch  start...");
          }
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.setSpecialCareSwitch(1, arrayOfString, (boolean[])localObject2);
          ReportController.b(this.app, "CliOper", "", "", "0X80050DD", "0X80050DD", 0, 0, String.valueOf(localObject1.length), "", "", "");
          break label708;
          localObject1 = (SpecailCareListActivity.ViewHolder)localObject1;
          localObject2 = ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataFriends;
          localObject2 = new Intent(this, QQSpecialCareSettingActivity.class);
          ((Intent)localObject2).putExtra("key_friend_uin", ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_JavaLangString);
          ((Intent)localObject2).putExtra("key_start_from", 5);
          startActivity((Intent)localObject2);
          break label708;
          ReportController.b(this.app, "CliOper", "", "", "0X80050D9", "0X80050D9", 0, 0, "", "", "", "");
          localObject1 = new Intent(this, ForwardFriendListActivity.class);
          ((Intent)localObject1).putExtra("extra_choose_friend", 1);
          ((Intent)localObject1).putExtra("extra_add_special_friend", 2);
          startActivity((Intent)localObject1);
          overridePendingTransition(2130771993, 2130771991);
        }
        break;
      }
    }
    label708:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", type=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(",avatar= ");
      ((StringBuilder)localObject).append(paramBitmap);
      QLog.d("SpecailCareListActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBitmap != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
        return;
      }
      if (this.d != 0)
      {
        this.jdField_b_of_type_Boolean = true;
        return;
      }
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1);
        if (localObject != null)
        {
          localObject = (SpecailCareListActivity.ViewHolder)((View)localObject).getTag();
          if ((localObject != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(((SpecailCareListActivity.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataFriends.uin)))
          {
            ((SpecailCareListActivity.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
            return;
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.e = paramInt3;
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
    {
      if (paramAbsListView == null) {
        return;
      }
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      int i = this.jdField_a_of_type_AndroidWidgetLinearLayout.getBottom();
      int j = paramAbsListView.getBottom();
      if (QLog.isColorLevel())
      {
        paramAbsListView = new StringBuilder();
        paramAbsListView.append("onScroll.firstVisibleItem=");
        paramAbsListView.append(paramInt1);
        paramAbsListView.append(", visibleItemCount=");
        paramAbsListView.append(paramInt2);
        paramAbsListView.append(",totalItemCount=");
        paramAbsListView.append(paramInt3);
        paramAbsListView.append(",addBtnBottom=");
        paramAbsListView.append(i);
        paramAbsListView.append(",listviewBottom=");
        paramAbsListView.append(j);
        paramAbsListView.append(",mBottomBtnBottomMargin=");
        paramAbsListView.append(this.jdField_c_of_type_Int);
        QLog.d("SpecailCareListActivity", 2, paramAbsListView.toString());
      }
      if (paramInt1 + paramInt2 == paramInt3)
      {
        paramInt1 = this.jdField_c_of_type_Int;
        if ((i > paramInt1) && (j >= i - paramInt1))
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          return;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.d = paramInt;
    boolean bool = this.jdField_b_of_type_Boolean;
    int i = 0;
    if ((bool) && (paramInt == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$SpecailCareListAdapter.notifyDataSetChanged();
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    if (paramInt == 0)
    {
      int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt = i;
      while (paramInt < j)
      {
        paramAbsListView = (SpecailCareListActivity.ViewHolder)this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt).getTag();
        if ((paramAbsListView != null) && (paramAbsListView.jdField_a_of_type_JavaLangString != null) && (paramAbsListView.jdField_a_of_type_JavaLangString.length() > 0)) {
          a(paramAbsListView.jdField_a_of_type_ComTencentMobileqqDataFriends, paramAbsListView);
        }
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity
 * JD-Core Version:    0.7.0.1
 */