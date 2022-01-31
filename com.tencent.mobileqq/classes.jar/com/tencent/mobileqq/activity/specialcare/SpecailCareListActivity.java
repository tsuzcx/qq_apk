package com.tencent.mobileqq.activity.specialcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid.GridCallBack;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ActivateFriendItem;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x7df.oidb_0x7df.FriendScore;
import ych;
import yci;
import ycj;
import yck;
import ycl;
import ycm;
import ycn;
import yco;
import ycp;
import ycq;
import ycr;
import ycs;
import yct;
import ycu;
import ycw;
import ycx;
import ycy;
import ycz;
import yda;
import ydb;
import ydc;

public class SpecailCareListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, ActivateFriendGrid.GridCallBack, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  public int a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Handler a;
  public View a;
  Button jdField_a_of_type_AndroidWidgetButton;
  public LinearLayout a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public ActivateFriendGrid a;
  public FriendListHandler a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new yct(this);
  public FriendsManager a;
  StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  public FaceDecoder a;
  public PullRefreshHeader a;
  public QQProgressDialog a;
  OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new ycr(this);
  public XListView a;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public ydb a;
  ydc jdField_a_of_type_Ydc = new ycs(this);
  public boolean a;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  public ArrayList b;
  public boolean b;
  int c;
  public View c;
  public boolean c;
  public int d = 0;
  
  public SpecailCareListActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new ych(this);
  }
  
  public int a(SpecailCareListActivity.ViewHolder paramViewHolder)
  {
    int j = getResources().getDimensionPixelSize(2131558646);
    int i = j;
    if (paramViewHolder.i.getVisibility() != 8) {
      i = j + paramViewHolder.i.getLayoutParams().width;
    }
    j = i;
    if (paramViewHolder.j.getVisibility() != 8) {
      j = i + paramViewHolder.j.getLayoutParams().width;
    }
    i = j;
    if (paramViewHolder.h.getVisibility() != 8) {
      i = j + paramViewHolder.h.getLayoutParams().width;
    }
    j = i;
    if (paramViewHolder.g.getVisibility() != 8) {
      j = i + paramViewHolder.g.getLayoutParams().width;
    }
    i = j;
    if (paramViewHolder.jdField_d_of_type_AndroidWidgetTextView.getVisibility() != 8) {
      i = j + paramViewHolder.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams().width;
    }
    if (QLog.isColorLevel()) {
      QLog.d("test", 2, "getNickRightMargin=" + i);
    }
    return i;
  }
  
  public SpannableString a(Friends paramFriends, SpecailCareListActivity.ViewHolder paramViewHolder)
  {
    Object localObject1 = (StatusManager)this.app.getManager(14);
    Object localObject2 = (FriendsManager)this.app.getManager(50);
    if ((localObject1 == null) || (localObject2 == null)) {
      return null;
    }
    localObject1 = ((FriendsManager)localObject2).a(paramFriends.uin);
    paramFriends = null;
    boolean bool;
    label86:
    int j;
    label108:
    int k;
    if ((localObject1 != null) && (!TextUtils.isEmpty(((ExtensionInfo)localObject1).feedContent)))
    {
      i = 1;
      if (localObject1 != null)
      {
        if (this.d == 0) {
          break label242;
        }
        bool = true;
        paramFriends = ((ExtensionInfo)localObject1).getRichStatus(bool);
      }
      if ((paramFriends == null) || (paramFriends.isEmpty())) {
        break label248;
      }
      j = 1;
      if ((j == 0) || (TextUtils.isEmpty(paramFriends.actionText))) {
        break label254;
      }
      k = 1;
      label126:
      if ((i == 0) || ((((ExtensionInfo)localObject1).feedTime <= ((ExtensionInfo)localObject1).richTime) && (j != 0))) {
        break label273;
      }
      paramFriends = new SpannableString(((ExtensionInfo)localObject1).feedContent);
      paramViewHolder.b.setCompoundDrawables(null, null, null, null);
      paramViewHolder.e.setVisibility(0);
      localObject2 = paramViewHolder.e;
      if (((ExtensionInfo)localObject1).feedType != 1) {
        break label260;
      }
      i = 2130845332;
      label199:
      ((ImageView)localObject2).setBackgroundResource(i);
      localObject2 = paramViewHolder.f;
      if (!((ExtensionInfo)localObject1).feedHasPhoto) {
        break label267;
      }
    }
    label260:
    label267:
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject2).setVisibility(i);
      paramViewHolder.b.setText(paramFriends);
      return paramFriends;
      i = 0;
      break;
      label242:
      bool = false;
      break label86;
      label248:
      j = 0;
      break label108;
      label254:
      k = 0;
      break label126;
      i = 2130845330;
      break label199;
    }
    label273:
    if (k != 0)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramFriends.actionId, 200);
      localObject1 = new BitmapDrawable(getResources(), (Bitmap)localObject1);
      i = this.jdField_b_of_type_Int;
      ((Drawable)localObject1).setBounds(0, 0, Math.round(((Drawable)localObject1).getIntrinsicWidth() * 1.0F / ((Drawable)localObject1).getIntrinsicHeight() * i), i);
      paramViewHolder.b.setCompoundDrawables((Drawable)localObject1, null, null, null);
    }
    for (;;)
    {
      paramFriends = paramFriends.toSpannableString(null);
      paramViewHolder.e.setVisibility(8);
      paramViewHolder.f.setVisibility(8);
      break;
      if (j == 0)
      {
        paramFriends = RichStatus.getEmptyStatus();
        paramViewHolder.b.setCompoundDrawables(null, null, null, null);
      }
    }
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b();
    if ((localList == null) || (localList.size() <= 0))
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
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("SpecailCareListActivity", 2, "refreshSpecialCareData cost time = " + (l2 - l1));
      }
      return;
      this.rightViewText.setVisibility(0);
      if (this.jdField_c_of_type_Boolean)
      {
        this.rightViewText.setText("完成");
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SpecailCareListActivity", 2, "getSpecailCareInfos return size:" + localList.size());
        }
        int i = 0;
        while (i < localList.size())
        {
          Object localObject = (SpecialCareInfo)localList.get(i);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(((SpecialCareInfo)localObject).uin);
          if (localObject != null) {
            this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
          }
          i += 1;
        }
        this.rightViewText.setText("管理");
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      ThreadManager.post(new ycu(this), 8, null, true);
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
  
  public void a(int paramInt, boolean paramBoolean)
  {
    getPreferences(0).edit().putBoolean("enterSpecailCare" + this.app.getCurrentAccountUin() + "_" + paramInt, paramBoolean).commit();
  }
  
  public void a(SpecailCareListActivity.ViewHolder paramViewHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    ImageView localImageView;
    if (paramInt4 == 1)
    {
      paramViewHolder.i.setVisibility(0);
      localImageView = paramViewHolder.i;
      if (paramBoolean)
      {
        paramInt4 = 2130845794;
        localImageView.setImageResource(paramInt4);
        label37:
        if (paramInt5 != 1) {
          break label190;
        }
        paramViewHolder.j.setVisibility(0);
        paramViewHolder.j.setImageResource(2130845795);
        label61:
        if (paramInt3 != 1) {
          break label229;
        }
        paramViewHolder.h.setVisibility(0);
        paramViewHolder.h.setImageResource(2130845802);
        label85:
        if (paramInt2 != 1) {
          break label268;
        }
        paramViewHolder.g.setVisibility(0);
        paramViewHolder.g.setImageResource(2130845799);
      }
    }
    for (;;)
    {
      if (paramInt2 != 0) {
        break label306;
      }
      paramViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      paramInt4 = 2130845801;
      break;
      if (paramInt4 == 2)
      {
        paramViewHolder.i.setVisibility(0);
        localImageView = paramViewHolder.i;
        if (paramBoolean) {}
        for (paramInt4 = 2130845793;; paramInt4 = 2130845787)
        {
          localImageView.setImageResource(paramInt4);
          break;
        }
      }
      paramViewHolder.i.setVisibility(8);
      break label37;
      label190:
      if (paramInt5 == 2)
      {
        paramViewHolder.j.setVisibility(0);
        paramViewHolder.j.setImageResource(2130845797);
        break label61;
      }
      paramViewHolder.j.setVisibility(8);
      break label61;
      label229:
      if (paramInt3 == 2)
      {
        paramViewHolder.h.setVisibility(0);
        paramViewHolder.h.setImageResource(2130845788);
        break label85;
      }
      paramViewHolder.h.setVisibility(8);
      break label85;
      label268:
      if (paramInt2 == 2)
      {
        paramViewHolder.g.setVisibility(0);
        paramViewHolder.g.setImageResource(2130845785);
      }
      else
      {
        paramViewHolder.g.setVisibility(8);
      }
    }
    label306:
    if (paramInt1 <= 0)
    {
      paramViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    paramInt2 = paramInt1;
    if (paramInt1 > 999) {
      paramInt2 = 999;
    }
    paramViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    paramViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText(paramInt2 + "天");
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.d = paramInt;
    if ((this.jdField_b_of_type_Boolean) && (paramInt == 0))
    {
      this.jdField_a_of_type_Ydb.notifyDataSetChanged();
      this.jdField_b_of_type_Boolean = false;
    }
    for (;;)
    {
      return;
      if (paramInt == 0)
      {
        int i = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
        paramInt = 0;
        while (paramInt < i)
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
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) || (paramAbsListView == null)) {
      return;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    int i = this.jdField_a_of_type_AndroidWidgetLinearLayout.getBottom();
    int j = paramAbsListView.getBottom();
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "onScroll.firstVisibleItem=" + paramInt1 + ", visibleItemCount=" + paramInt2 + ",totalItemCount=" + paramInt3 + ",addBtnBottom=" + i + ",listviewBottom=" + j + ",mBottomBtnBottomMargin=" + this.jdField_c_of_type_Int);
    }
    if (paramInt1 + paramInt2 == paramInt3)
    {
      if ((i > this.jdField_c_of_type_Int) && (j >= i - this.jdField_c_of_type_Int))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = false;
    if (!getPreferences(0).getBoolean("enterSpecailCare" + this.app.getCurrentAccountUin() + "_" + paramInt, false)) {
      bool = true;
    }
    return bool;
  }
  
  void b()
  {
    if ((this.jdField_a_of_type_Ydb != null) && (this.jdField_a_of_type_Ydb.a() != null)) {
      return;
    }
    if (((FriendsManager)this.app.getManager(50)).a() > 0) {
      ReportController.b(this.app, "CliOper", "", "", "0X80050E0", "0X80050E0", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      View localView = getLayoutInflater().inflate(2130970583, null);
      if (this.jdField_a_of_type_Ydb == null) {
        break;
      }
      this.jdField_a_of_type_Ydb.a(localView);
      return;
      ReportController.b(this.app, "CliOper", "", "", "0X80050DF", "0X80050DF", 0, 0, "", "", "", "");
    }
  }
  
  void c()
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X80050DA", "0X80050DA", 0, 0, "", "", "", "");
    this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130970586, null);
    Object localObject1 = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject1).setMargins(0, AIOUtils.a(75.0F, getResources()), 0, 0);
    this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new ycw(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131371339));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid = ((ActivateFriendGrid)this.jdField_c_of_type_AndroidViewView.findViewById(2131362555));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setGridCallBack(this);
    localObject1 = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject2 = (yda)localIterator.next();
      if ((this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(((yda)localObject2).jdField_a_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SpecialCare", 2, ((yda)localObject2).jdField_a_of_type_JavaLangString + " is not friend.. ");
        }
      }
      else
      {
        localObject2 = new ActivateFriendItem(1, Long.valueOf(((yda)localObject2).jdField_a_of_type_JavaLangString).longValue(), ((yda)localObject2).b);
        if (i >= 6) {
          break label423;
        }
        ((ArrayList)localObject1).add(localObject2);
        i += 1;
      }
    }
    label403:
    label423:
    for (;;)
    {
      break;
      ReportController.b(this.app, "CliOper", "", "", "0X80050DC", "0X80050DC", 0, 0, String.valueOf(i), "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setData(this.app, (ArrayList)localObject1);
      if (this.jdField_c_of_type_AndroidViewView.getParent() == null)
      {
        if (Build.VERSION.SDK_INT >= 14) {
          break label403;
        }
        ((ViewGroup)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent().getParent()).addView(this.jdField_c_of_type_AndroidViewView);
      }
      for (;;)
      {
        setRightButton(2131437711, this);
        return;
        ((FrameLayout)getWindow().getDecorView()).addView(this.jdField_c_of_type_AndroidViewView);
      }
    }
  }
  
  public void d()
  {
    if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getParent() != null))
    {
      if (Build.VERSION.SDK_INT >= 14) {
        break label80;
      }
      ((ViewGroup)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent().getParent()).removeView(this.jdField_c_of_type_AndroidViewView);
      this.jdField_c_of_type_AndroidViewView = null;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid = null;
      }
    }
    for (;;)
    {
      this.rightViewText.setVisibility(4);
      return;
      label80:
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 2, -1.0F);
      localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
      localTranslateAnimation.setDuration(500L);
      localTranslateAnimation.setFillAfter(true);
      localTranslateAnimation.setAnimationListener(new ycx(this));
      this.jdField_c_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    super.doOnCreate(paramBundle);
    setContentView(2130970585);
    super.setTitle(2131436844);
    super.setRightButton(2131433095, this);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_Int = ((int)DisplayUtils.a(this, 9.0F));
    this.jdField_b_of_type_Int = ((int)DisplayUtils.a(this, 12.0F));
    this.jdField_c_of_type_Int = ((int)DisplayUtils.a(this, 20.0F));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131365205));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131364160));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131371337);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)getLayoutInflater().inflate(2130970582, null));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_Ydb = new ydb(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ydb);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)getLayoutInflater().inflate(2130969512, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeight(getResources().getDimensionPixelSize(2131558434));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130838210);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130842321);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.app.getManager(50));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_Ydc);
    a();
    if ((this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) && (a(1)))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(true);
      FriendListHandler.jdField_a_of_type_Int = 2;
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a();
      if ((paramBundle == null) || (paramBundle.size() <= 0)) {
        break label695;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SpecailCareListActivity", 2, "fh.getRecommendList() return size:" + paramBundle.size());
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        oidb_0x7df.FriendScore localFriendScore = (oidb_0x7df.FriendScore)paramBundle.next();
        yda localyda = new yda();
        localyda.jdField_a_of_type_JavaLangString = String.valueOf(localFriendScore.uint64_friend_uin.get());
        Friends localFriends = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(localyda.jdField_a_of_type_JavaLangString);
        if (localFriends != null) {
          localyda.b = ContactUtils.a(localFriends);
        }
        if ((TextUtils.isEmpty(localyda.b)) && (localFriendScore.bytes_nick != null) && (localFriendScore.bytes_nick.get() != null)) {
          localyda.b = localFriendScore.bytes_nick.get().toStringUtf8();
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(localyda);
      }
      c();
    }
    for (;;)
    {
      a(1, true);
      a(2, true);
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("SpecailCareListActivity", 2, "doOnCreate cost time = " + (l2 - l1));
      }
      if (AppSetting.jdField_b_of_type_Boolean)
      {
        this.leftView.setContentDescription("返回");
        this.jdField_a_of_type_AndroidViewView.setContentDescription("添加特别关心 按钮");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.d(this.app.getCurrentAccountUin(), (byte)3);
      return true;
      label695:
      if (QLog.isColorLevel()) {
        QLog.d("SpecailCareListActivity", 2, "fh.getRecommendList(): empty...");
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_Ydc);
    h();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid = null;
    }
  }
  
  public void e()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {}
    FrameLayout localFrameLayout;
    do
    {
      do
      {
        return;
      } while (this.jdField_c_of_type_AndroidViewView != null);
      ReportController.b(this.app, "CliOper", "", "", "0X80050DB", "0X80050DB", 0, 0, "", "", "", "");
      localFrameLayout = (FrameLayout)getWindow().getDecorView();
      this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130970584, null);
      Button localButton = (Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131371336);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131371333).setOnClickListener(this);
      localButton.setOnClickListener(this);
    } while (this.jdField_b_of_type_AndroidViewView.getParent() != null);
    localFrameLayout.addView(this.jdField_b_of_type_AndroidViewView);
  }
  
  void f()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getParent() != null))
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131433115);
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
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
    if ("管理".equals(localObject1))
    {
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)
      {
        localObject1 = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject1).setDuration(300L);
        ((AlphaAnimation)localObject1).setAnimationListener(new ycy(this));
        this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject1);
      }
      int i = 0;
      while (i < j)
      {
        localObject1 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i).getTag();
        if ((localObject1 != null) && ((localObject1 instanceof SpecailCareListActivity.ViewHolder)))
        {
          localObject1 = (SpecailCareListActivity.ViewHolder)localObject1;
          Object localObject2 = new TranslateAnimation(-(this.mDensity * 34.0F), 0.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          Object localObject3 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject3).setStartOffset(120L);
          ((AlphaAnimation)localObject3).setDuration(180L);
          AnimationSet localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          ((SpecailCareListActivity.ViewHolder)localObject1).c.setVisibility(0);
          ((TranslateAnimation)localObject2).setAnimationListener(new ycz(this, (SpecailCareListActivity.ViewHolder)localObject1));
          ((SpecailCareListActivity.ViewHolder)localObject1).c.startAnimation(localAnimationSet);
          localObject2 = new TranslateAnimation(0.0F, this.mDensity * 34.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          ((TranslateAnimation)localObject2).setAnimationListener(new yci(this, (SpecailCareListActivity.ViewHolder)localObject1));
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject2);
          localObject2 = new TranslateAnimation(0.0F, this.mDensity * 34.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, 12.0F * this.mDensity);
          ((TranslateAnimation)localObject3).setDuration(300L);
          localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.setFillAfter(true);
          localAnimationSet.setAnimationListener(new ycj(this, (SpecailCareListActivity.ViewHolder)localObject1));
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.startAnimation(localAnimationSet);
          localObject2 = new TranslateAnimation(0.0F, this.mDensity * 34.0F, 0.0F, -12.0F * this.mDensity);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject3).setDuration(300L);
          localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.setAnimationListener(new yck(this, (SpecailCareListActivity.ViewHolder)localObject1));
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
          localObject2 = new TranslateAnimation(0.0F, 28.0F * this.mDensity, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject3).setDuration(240L);
          localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.setFillAfter(true);
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localAnimationSet);
          localObject2 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject2).setDuration(300L);
          ((AlphaAnimation)localObject2).setFillAfter(true);
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_d_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject2);
        }
        if (i == j - 2)
        {
          localObject1 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject1).setDuration(300L);
          ((AlphaAnimation)localObject1).setAnimationListener(new ycl(this));
          this.leftView.startAnimation((Animation)localObject1);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject1);
        }
        i += 1;
      }
    }
    if ("完成".equals(localObject1)) {
      j();
    }
  }
  
  void j()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition();
    int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getBottom();
    int k = this.jdField_a_of_type_ComTencentWidgetXListView.getBottom();
    if (i == this.jdField_a_of_type_ComTencentWidgetXListView.getCount() - 1) {
      if ((j > this.jdField_c_of_type_Int) && (k >= j - this.jdField_c_of_type_Int)) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
    for (;;)
    {
      j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      i = 0;
      while (i < j)
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i).getTag();
        if ((localObject1 != null) && ((localObject1 instanceof SpecailCareListActivity.ViewHolder)))
        {
          localObject1 = (SpecailCareListActivity.ViewHolder)localObject1;
          k = a((SpecailCareListActivity.ViewHolder)localObject1);
          Object localObject2 = new TranslateAnimation(0.0F, -(34.0F * this.mDensity), 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          Object localObject3 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject3).setDuration(180L);
          Object localObject4 = new AnimationSet(true);
          ((AnimationSet)localObject4).addAnimation((Animation)localObject2);
          ((AnimationSet)localObject4).addAnimation((Animation)localObject3);
          ((TranslateAnimation)localObject2).setAnimationListener(new ycm(this, (SpecailCareListActivity.ViewHolder)localObject1));
          ((SpecailCareListActivity.ViewHolder)localObject1).c.startAnimation((Animation)localObject4);
          localObject2 = new TranslateAnimation(0.0F, -(34.0F * this.mDensity), 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          ((TranslateAnimation)localObject2).setAnimationListener(new ycn(this, (SpecailCareListActivity.ViewHolder)localObject1));
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject2);
          localObject2 = new TranslateAnimation(0.0F, -34.0F * this.mDensity, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -12.0F * this.mDensity);
          ((TranslateAnimation)localObject3).setDuration(300L);
          localObject4 = new AnimationSet(true);
          ((AnimationSet)localObject4).addAnimation((Animation)localObject2);
          ((AnimationSet)localObject4).addAnimation((Animation)localObject3);
          ((AnimationSet)localObject4).setFillAfter(true);
          ((AnimationSet)localObject4).setAnimationListener(new yco(this, (SpecailCareListActivity.ViewHolder)localObject1, k));
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.startAnimation((Animation)localObject4);
          localObject2 = new TranslateAnimation(0.0F, -34.0F * this.mDensity, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, 12.0F * this.mDensity);
          ((TranslateAnimation)localObject3).setDuration(300L);
          localObject4 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject4).setDuration(300L);
          AnimationSet localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.addAnimation((Animation)localObject4);
          localAnimationSet.setFillAfter(true);
          localAnimationSet.setAnimationListener(new ycp(this, (SpecailCareListActivity.ViewHolder)localObject1));
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
          localObject2 = new TranslateAnimation(24.0F * this.mDensity, 0.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          ((TranslateAnimation)localObject2).setFillAfter(true);
          localObject3 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject3).setStartOffset(60L);
          ((AlphaAnimation)localObject3).setDuration(240L);
          localObject4 = new AnimationSet(true);
          ((AnimationSet)localObject4).addAnimation((Animation)localObject2);
          ((AnimationSet)localObject4).addAnimation((Animation)localObject3);
          ((AnimationSet)localObject4).setFillAfter(true);
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject4);
          localObject2 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject2).setDuration(300L);
          ((AlphaAnimation)localObject2).setFillAfter(true);
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_d_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject2);
        }
        if (i == j - 2)
        {
          localObject1 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject1).setDuration(300L);
          ((AlphaAnimation)localObject1).setAnimationListener(new ycq(this));
          this.leftView.startAnimation((Animation)localObject1);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject1);
        }
        i += 1;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      continue;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
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
    if (((paramView instanceof ImageView)) && (paramView.getTag() != null) && ((paramView.getTag() instanceof String)))
    {
      paramView = (String)paramView.getTag();
      if (!StringUtil.a(paramView))
      {
        ReportController.b(this.app, "CliOper", "", "", "0X80050E1", "0X80050E1", 0, 0, "", "", "", "");
        if (!NetworkUtil.d(this)) {
          break label134;
        }
        localObject = (FriendListHandler)this.app.a(1);
        this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { paramView };
        ((FriendListHandler)localObject).a(1, this.jdField_a_of_type_ArrayOfJavaLangString, new boolean[] { false });
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2002);
      }
    }
    label134:
    do
    {
      return;
      QQToast.a(this, getString(2131432992), 0).b(getTitleBarHeight());
      return;
      switch (paramView.getId())
      {
      case 2131371333: 
      default: 
        paramView = paramView.getTag();
        if ((paramView != null) && ((paramView instanceof SpecailCareListActivity.ViewHolder))) {
          break;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X80050D9", "0X80050D9", 0, 0, "", "", "", "");
        paramView = new Intent(this, ForwardFriendListActivity.class);
        paramView.putExtra("extra_choose_friend", 1);
        paramView.putExtra("extra_add_special_friend", 2);
        startActivity(paramView);
        overridePendingTransition(2131034123, 2131034121);
        return;
      case 2131363410: 
        if (this.jdField_c_of_type_AndroidViewView != null)
        {
          d();
          ReportController.b(this.app, "CliOper", "", "", "0X80050DE", "0X80050DE", 0, 0, "", "", "", "");
          return;
        }
        i();
        return;
      case 2131371339: 
        if (NetworkUtil.d(this)) {
          break label403;
        }
        QQToast.a(this, getString(2131432992), 0).b(getTitleBarHeight());
      }
    } while (!QLog.isColorLevel());
    QLog.i("SpecailCareListActivity", 2, "No Network!");
    return;
    label403:
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.a();
    Object localObject = new boolean[paramView.length];
    String[] arrayOfString = new String[paramView.length];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[arrayOfString.length];
    int i = 0;
    while (i < paramView.length)
    {
      localObject[i] = 1;
      arrayOfString[i] = String.valueOf(paramView[i]);
      this.jdField_a_of_type_ArrayOfJavaLangString[i] = arrayOfString[i];
      i += 1;
    }
    g();
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "setSpecialCareSwitch  start...");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(1, arrayOfString, (boolean[])localObject);
    ReportController.b(this.app, "CliOper", "", "", "0X80050DD", "0X80050DD", 0, 0, String.valueOf(paramView.length), "", "", "");
    return;
    f();
    return;
    ReportController.b(this.app, "CliOper", "", "", "0X80050D9", "0X80050D9", 0, 0, "", "", "", "");
    paramView = new Intent(this, ForwardFriendListActivity.class);
    paramView.putExtra("extra_choose_friend", 1);
    paramView.putExtra("extra_add_special_friend", 2);
    startActivity(paramView);
    overridePendingTransition(2131034123, 2131034121);
    return;
    paramView = (SpecailCareListActivity.ViewHolder)paramView;
    localObject = paramView.jdField_a_of_type_ComTencentMobileqqDataFriends;
    if (this.jdField_c_of_type_Boolean)
    {
      localObject = new Intent(this, QQSpecialFriendSettingActivity.class);
      ((Intent)localObject).putExtra("key_friend_uin", paramView.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("key_is_from_management_activity", true);
      startActivity((Intent)localObject);
      return;
    }
    paramView = new ProfileActivity.AllInOne(((Friends)localObject).uin, 1);
    paramView.h = 59;
    paramView.j = 3;
    ProfileActivity.b(getActivity(), paramView);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "uin=" + paramString + ", type=" + paramInt2 + ",avatar= " + paramBitmap);
    }
    if ((paramBitmap == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())) {}
    for (;;)
    {
      return;
      if (this.d != 0)
      {
        this.jdField_b_of_type_Boolean = true;
        return;
      }
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity
 * JD-Core Version:    0.7.0.1
 */