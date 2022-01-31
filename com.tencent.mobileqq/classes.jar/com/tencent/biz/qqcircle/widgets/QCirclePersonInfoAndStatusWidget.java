package com.tencent.biz.qqcircle.widgets;

import alto;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bdgc;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCircleFollowUpdateEvent;
import com.tencent.biz.qqcircle.fragments.QCirclePersonalDetailFragment;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import qqcircle.QQCircleBase.StUserBusiData;
import qqcircle.QQCircleBase.UserCircleInfo;
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;
import tqr;
import tqs;
import tra;
import tzv;
import ued;
import uee;
import uef;
import uft;
import wxe;
import yiw;
import yiy;

public class QCirclePersonInfoAndStatusWidget
  extends BaseWidgetView
  implements View.OnClickListener, yiy
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleAvatarView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  private QCircleFollowView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView;
  private AsyncRichTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  private FeedCloudRead.StGetMainPageRsp jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp;
  private List<QQCircleBase.UserCircleInfo> jdField_a_of_type_JavaUtilList;
  private QQCircleFeedBase.StMainPageBusiRspData jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData;
  private uef jdField_a_of_type_Uef;
  private uft jdField_a_of_type_Uft;
  private int jdField_b_of_type_Int;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private List<QQCircleBase.UserCircleInfo> jdField_b_of_type_JavaUtilList;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private TextView e;
  private TextView f;
  private TextView g;
  
  public QCirclePersonInfoAndStatusWidget(Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((BaseActivity)paramContext).app;
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.split("-");
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramString.length;
    int i = 0;
    if (i < j)
    {
      CharSequence localCharSequence = paramString[i];
      if ((TextUtils.isEmpty(localCharSequence)) || (localCharSequence.equals(getResources().getString(2131717455)))) {}
      for (;;)
      {
        i += 1;
        break;
        if (!TextUtils.isEmpty(localStringBuilder)) {
          localStringBuilder.append("·");
        }
        localStringBuilder.append(localCharSequence);
      }
    }
    return localStringBuilder.toString();
  }
  
  private void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new QCirclePersonInfoAndStatusWidget.3(this, paramInt));
  }
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_c_of_type_AndroidWidgetTextView.setText(tra.b(paramLong));
  }
  
  private void a(SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    paramSpannableString.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(2131166187)), paramInt1, paramInt2, 17);
  }
  
  private void a(SpannableString paramSpannableString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      paramSpannableString.setSpan(new uee(this, paramInt3), paramInt1, paramInt2, 33);
      return;
    }
    catch (Exception paramSpannableString)
    {
      QLog.e("QCirclePersonInfoAndStatusWidget", 1, "addClickReport error" + paramSpannableString.getMessage());
      paramSpannableString.printStackTrace();
    }
  }
  
  private void a(FeedCloudMeta.StUser paramStUser, QQCircleFeedBase.StMainPageBusiRspData paramStMainPageBusiRspData)
  {
    if ((paramStUser != null) && (paramStUser.get() != null))
    {
      QLog.d("QCirclePersonInfoAndStatusWidget", 1, "nickName is" + paramStUser.nick.get());
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStUser.nick.get());
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramStUser);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setAuthDrawable(2130843538);
      if (!TextUtils.isEmpty(paramStUser.desc.get())) {
        break label546;
      }
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setVisibility(8);
      if ((!tra.a(paramStUser)) && (paramStMainPageBusiRspData != null)) {
        break label571;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (!tra.c(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) {
        break label724;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      label137:
      StringBuilder localStringBuilder;
      int i1;
      int i2;
      int i3;
      int i4;
      int k;
      int n;
      int m;
      try
      {
        localStringBuilder = new StringBuilder();
        i1 = 0;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        i = 0;
        k = i;
        Object localObject;
        if (!TextUtils.isEmpty(paramStUser.location.get()))
        {
          localObject = a(paramStUser.location.get());
          k = i;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            k = ((String)localObject).length();
            localStringBuilder.append((String)localObject);
          }
        }
        if (paramStUser.busiData.get() != null)
        {
          localObject = new QQCircleBase.StUserBusiData();
          ((QQCircleBase.StUserBusiData)localObject).mergeFrom(paramStUser.busiData.get().toByteArray());
          this.jdField_a_of_type_JavaUtilList = new ArrayList();
          this.jdField_b_of_type_JavaUtilList = ((QQCircleBase.StUserBusiData)localObject).schoolInfos.get();
          n = i4;
          m = i3;
          j = i2;
          i = i1;
          if (this.jdField_b_of_type_JavaUtilList != null)
          {
            n = i4;
            m = i3;
            j = i2;
            i = i1;
            if (this.jdField_b_of_type_JavaUtilList.size() > 0)
            {
              QLog.d("QCirclePersonInfoAndStatusWidget", 1, "mSchoolCircleInfos size:" + this.jdField_b_of_type_JavaUtilList.size());
              if (localStringBuilder.length() == 0) {
                break label935;
              }
              j = localStringBuilder.length();
              i = j + " | ".length();
              localStringBuilder.append(" | ");
              this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_b_of_type_JavaUtilList);
              i1 = 1;
              paramStUser = this.jdField_b_of_type_JavaUtilList.iterator();
              if (paramStUser.hasNext())
              {
                localStringBuilder.append(((QQCircleBase.UserCircleInfo)paramStUser.next()).name.get()).append(" ");
                continue;
                if (paramStMainPageBusiRspData == null) {
                  break label916;
                }
              }
            }
          }
        }
      }
      catch (Exception paramStUser)
      {
        QLog.e("QCirclePersonInfoAndStatusWidget", 1, "parseLocationOrAuth error" + paramStUser.getMessage());
      }
      for (;;)
      {
        if (paramStMainPageBusiRspData.recomTagList.get().size() > 0)
        {
          this.jdField_a_of_type_Uft.a(paramStMainPageBusiRspData, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          if (tra.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser))
          {
            this.e.setText(2131698325);
            return;
            label546:
            this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setVisibility(0);
            this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setText(paramStUser.desc.get());
            break;
            label571:
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setItemReportListener(new ued(this));
            boolean bool = tra.a(paramStMainPageBusiRspData.opMask.get());
            QLog.d("QCirclePersonInfoAndStatusWidget", 1, "isShowChatEntrance" + bool);
            if ((tra.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get())) || (bool))
            {
              this.f.setVisibility(0);
              b(false);
              tzv.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 4L, 1L);
            }
            for (;;)
            {
              this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUserData((FeedCloudMeta.StUser)paramStUser.get());
              this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              break;
              this.f.setVisibility(8);
              b(true);
            }
            label724:
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            break label137;
            n = "[SchoolAuth]".length();
            m = j;
            j = n;
            n = i;
            for (i = i1;; i = i1)
            {
              if (!TextUtils.isEmpty(localStringBuilder)) {
                break label805;
              }
              this.g.setVisibility(8);
              break;
              QLog.d("QCirclePersonInfoAndStatusWidget", 1, "poster.busiData is null");
              n = i4;
              m = i3;
              j = i2;
            }
            label805:
            paramStUser = new SpannableString(localStringBuilder.toString());
            if (k != 0) {
              a(paramStUser, 0, k, 3);
            }
            if (i != 0) {
              a(paramStUser, k, j, 6);
            }
            if (m != 0) {
              a(paramStUser, m, n);
            }
            this.g.setText(paramStUser);
            this.g.setVisibility(0);
            this.g.setMovementMethod(LinkMovementMethod.getInstance());
            QLog.d("QCirclePersonInfoAndStatusWidget", 1, new Object[] { localStringBuilder });
            continue;
          }
          this.e.setText(2131698324);
          return;
        }
      }
      label916:
      this.jdField_a_of_type_Uft.a(null, null);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
      label935:
      int j = 0;
      int i = 0;
    }
  }
  
  private void b()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.g.setOnClickListener(this);
  }
  
  private void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_d_of_type_AndroidWidgetTextView.setText(tra.b(paramInt));
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130843545);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130843546);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130843547);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130843548);
  }
  
  private void c()
  {
    if ((!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser == null) || (TextUtils.isEmpty(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get()))) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
    localIntent.putExtra("open_chatfragment", true);
    localIntent.putExtra("PREVIOUS_WINDOW", QCirclePersonalDetailFragment.class.getName());
    localIntent.putExtra("uin", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get());
    if (tra.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get())) {
      localIntent.putExtra("uintype", 0);
    }
    for (;;)
    {
      localIntent.putExtra("aio_msg_source", 3);
      String str2 = bdgc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), true);
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localIntent.putExtra("uinname", str1);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
      localIntent.putExtra("uintype", 10008);
    }
  }
  
  private void d()
  {
    int j = 1;
    if ((this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData != null) && (tra.b(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.opMask.get()))) {}
    Object localObject;
    for (int i = 1;; i = 0)
    {
      QLog.d("QCirclePersonInfoAndStatusWidget", 1, "canJumpProfile" + this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get());
      if (((i != 0) || (tra.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get()))) && (this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get())))
      {
        localObject = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get();
        if (((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          break;
        }
      }
      return;
    }
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
    if (((String)localObject).equals(BaseApplicationImpl.getApplication().getRuntime().getAccount())) {
      i = 0;
    }
    for (;;)
    {
      localObject = new ProfileActivity.AllInOne((String)localObject, i);
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = i;
      ((ProfileActivity.AllInOne)localObject).h = 128;
      ((ProfileActivity.AllInOne)localObject).i = 3080;
      ((ProfileActivity.AllInOne)localObject).l = 2;
      ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject, false);
      return;
      i = j;
      if (!((alto)localBaseActivity.app.getManager(51)).b((String)localObject)) {
        i = 115;
      }
    }
  }
  
  public int a()
  {
    return 2131560572;
  }
  
  protected TopGestureLayout a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null) && ((getContext() instanceof FragmentActivity)))
    {
      Object localObject = (ViewGroup)((FragmentActivity)getContext()).getWindow().getDecorView();
      View localView = ((ViewGroup)localObject).getChildAt(0);
      if ((localView instanceof DragFrameLayout)) {
        localObject = (ViewGroup)localView;
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  }
  
  public void a(Context paramContext, View paramView)
  {
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser == null) && ((paramContext instanceof Activity)) && (((Activity)paramContext).getIntent() != null) && (((Activity)paramContext).getIntent().hasExtra("key_bundle_common_init_bean")))
    {
      paramContext = (QCircleInitBean)((Activity)paramContext).getIntent().getSerializableExtra("key_bundle_common_init_bean");
      if (paramContext != null) {
        this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = paramContext.getUser();
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378900));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView = ((AsyncRichTextView)findViewById(2131378737));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView = ((QCircleFollowView)findViewById(2131378801));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378786));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378780));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378804));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)findViewById(2131368809));
    this.e = ((TextView)findViewById(2131378807));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131373186);
    this.jdField_a_of_type_Uft = new uft();
    this.jdField_a_of_type_Uft.a(paramView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369636));
    this.f = ((TextView)findViewById(2131378931));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369648));
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369647));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369649));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368701));
    this.g = ((TextView)findViewById(2131378876));
    b();
    a(false);
  }
  
  public void a(Object paramObject)
  {
    if (paramObject == null)
    {
      QLog.e("QCirclePersonInfoAndStatusWidget", 1, "bindData error");
      return;
    }
    if ((paramObject instanceof FeedCloudMeta.StUser))
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = ((FeedCloudMeta.StUser)paramObject);
      QLog.d("QCirclePersonInfoAndStatusWidget", 1, "personDetail setSimpleUser");
      a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser, this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData);
      return;
    }
    if ((paramObject instanceof FeedCloudRead.StGetMainPageRsp))
    {
      QLog.d("QCirclePersonInfoAndStatusWidget", 1, "personDetail setRspUser");
      this.jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp = ((FeedCloudRead.StGetMainPageRsp)paramObject);
      if (this.jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp.busiRspData.get() != null) {
        paramObject = new QQCircleFeedBase.StMainPageBusiRspData();
      }
      try
      {
        paramObject.mergeFrom(this.jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp.busiRspData.get().toByteArray());
        this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData = paramObject;
        if (this.jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp.user != null)
        {
          this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.set(this.jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp.user);
          a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser, this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData);
        }
        a(this.jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp.feedCount.get());
        a(this.jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp.fansCount.get());
        b(this.jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp.followCount.get());
        return;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          QLog.e("QCirclePersonInfoAndStatusWidget", 1, "personDetail mergeFrom stMainPageBusiRspData error");
        }
      }
    }
    QLog.d("QCirclePersonInfoAndStatusWidget", 1, "personDetail bindData error" + paramObject.toString());
  }
  
  public void a(boolean paramBoolean)
  {
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCirclePersonInfoAndStatusWidget", 2, "enableFlingRight->enable:" + paramBoolean);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFollowUpdateEvent.class);
    localArrayList.add(QCircleFeedEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    yiw.a().a(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131369648: 
    case 2131369649: 
    case 2131368809: 
    case 2131378900: 
    case 2131378737: 
    case 2131378876: 
    case 2131369647: 
      do
      {
        do
        {
          do
          {
            return;
          } while (this.jdField_a_of_type_Uef == null);
          this.jdField_a_of_type_Uef.a();
          return;
        } while (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData == null);
        tqs.a(this.jdField_a_of_type_AndroidContentContext, tqr.a(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.urlInfo.get(), "followListUrl"));
        return;
        tzv.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 6L, 1L);
        d();
        return;
        tzv.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 6L, 2L);
        d();
        return;
        tzv.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 6L, 4L);
        d();
        return;
        d();
        return;
      } while (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData == null);
      tqs.a(this.jdField_a_of_type_AndroidContentContext, tqr.a(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.urlInfo.get(), "fansListUrl"));
      return;
    case 2131378931: 
      c();
      tzv.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 4L, 2L);
      return;
    }
    tqs.b(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get());
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    yiw.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    QCircleFollowUpdateEvent localQCircleFollowUpdateEvent;
    if (((paramSimpleBaseEvent instanceof QCircleFollowUpdateEvent)) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null))
    {
      localQCircleFollowUpdateEvent = (QCircleFollowUpdateEvent)paramSimpleBaseEvent;
      if (tra.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) {
        if (localQCircleFollowUpdateEvent.mFollowStatus == 1) {
          this.jdField_b_of_type_Int += 1;
        }
      }
    }
    label130:
    do
    {
      do
      {
        break label130;
        break label130;
        b(this.jdField_b_of_type_Int);
        do
        {
          ThreadManager.getUIHandler().post(new QCirclePersonInfoAndStatusWidget.5(this));
          wxe.c("QCirclePersonInfoAndStatusWidget", "onReceiveEvent  id:" + ((QCircleFollowUpdateEvent)paramSimpleBaseEvent).mUserId + " , status:" + ((QCircleFollowUpdateEvent)paramSimpleBaseEvent).mFollowStatus + " " + toString());
          return;
          if (this.jdField_b_of_type_Int <= 0) {
            break;
          }
          this.jdField_b_of_type_Int -= 1;
          break;
        } while (!TextUtils.equals(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), localQCircleFollowUpdateEvent.mUserId));
        if ((localQCircleFollowUpdateEvent.mFollowStatus == 1) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get() == 0)) {}
        for (this.jdField_a_of_type_Long += 1L;; this.jdField_a_of_type_Long -= 1L) {
          do
          {
            this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.set(((QCircleFollowUpdateEvent)paramSimpleBaseEvent).mFollowStatus);
            break;
          } while ((localQCircleFollowUpdateEvent.mFollowStatus != 0) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get() != 1) || (this.jdField_a_of_type_Long <= 0L));
        }
      } while (!(paramSimpleBaseEvent instanceof QCircleFeedEvent));
      paramSimpleBaseEvent = (QCircleFeedEvent)paramSimpleBaseEvent;
      if (paramSimpleBaseEvent.mState == 2)
      {
        this.jdField_a_of_type_Int += 1;
        a(this.jdField_a_of_type_Int);
        return;
      }
    } while (paramSimpleBaseEvent.mState != 3);
    if (this.jdField_a_of_type_Int > 0) {
      this.jdField_a_of_type_Int -= 1;
    }
    a(this.jdField_a_of_type_Int);
  }
  
  public void setHeaderClickListener(uef paramuef)
  {
    this.jdField_a_of_type_Uef = paramuef;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePersonInfoAndStatusWidget
 * JD-Core Version:    0.7.0.1
 */