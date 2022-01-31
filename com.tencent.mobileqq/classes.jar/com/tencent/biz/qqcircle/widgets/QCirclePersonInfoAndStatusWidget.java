package com.tencent.biz.qqcircle.widgets;

import aloz;
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
import bdbt;
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
import tyj;
import ubk;
import ubl;
import ubm;
import wsv;
import yej;
import yel;

public class QCirclePersonInfoAndStatusWidget
  extends BaseWidgetView
  implements View.OnClickListener, yel
{
  private static final String jdField_a_of_type_JavaLangString = QCirclePersonInfoAndStatusWidget.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
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
  private ubm jdField_a_of_type_Ubm;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private List<QQCircleBase.UserCircleInfo> jdField_b_of_type_JavaUtilList;
  private int jdField_c_of_type_Int;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private TextView f;
  
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
      if ((TextUtils.isEmpty(localCharSequence)) || (localCharSequence.equals(getResources().getString(2131717443)))) {}
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
    paramSpannableString.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(2131166185)), paramInt1, paramInt2, 17);
  }
  
  private void a(SpannableString paramSpannableString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      paramSpannableString.setSpan(new ubl(this, paramInt3), paramInt1, paramInt2, 33);
      return;
    }
    catch (Exception paramSpannableString)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "addClickReport error" + paramSpannableString.getMessage());
      paramSpannableString.printStackTrace();
    }
  }
  
  private void a(FeedCloudMeta.StUser paramStUser, QQCircleFeedBase.StMainPageBusiRspData paramStMainPageBusiRspData)
  {
    int n = 0;
    int i = 0;
    if ((paramStUser != null) && (paramStUser.get() != null))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStUser.nick.get());
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramStUser);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setAuthDrawable(2130843525);
      if (!TextUtils.isEmpty(paramStUser.desc.get())) {
        break label419;
      }
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setVisibility(8);
      if ((!tra.a(paramStUser)) && (paramStMainPageBusiRspData != null)) {
        break label444;
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      label93:
      if (!tra.a(paramStUser)) {
        break label588;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      tyj.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 5L, 1L);
    }
    int k;
    int j;
    for (;;)
    {
      try
      {
        paramStMainPageBusiRspData = new StringBuilder();
        if (TextUtils.isEmpty(paramStUser.location.get())) {
          break label750;
        }
        Object localObject = a(paramStUser.location.get());
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label750;
        }
        k = ((String)localObject).length();
        paramStMainPageBusiRspData.append((String)localObject);
        if (paramStUser.busiData.get() == null) {
          break label634;
        }
        localObject = new QQCircleBase.StUserBusiData();
        ((QQCircleBase.StUserBusiData)localObject).mergeFrom(paramStUser.busiData.get().toByteArray());
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        this.jdField_b_of_type_JavaUtilList = ((QQCircleBase.StUserBusiData)localObject).schoolInfos.get();
        if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() <= 0)) {
          break label756;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 1, "mSchoolCircleInfos size:" + this.jdField_b_of_type_JavaUtilList.size());
        if (paramStMainPageBusiRspData.length() == 0) {
          break label744;
        }
        i = paramStMainPageBusiRspData.length();
        j = i + " | ".length();
        paramStMainPageBusiRspData.append(" | ");
        label325:
        this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_b_of_type_JavaUtilList);
        paramStUser = this.jdField_b_of_type_JavaUtilList.iterator();
        if (!paramStUser.hasNext()) {
          break label600;
        }
        paramStMainPageBusiRspData.append(((QQCircleBase.UserCircleInfo)paramStUser.next()).name.get()).append(" ");
        continue;
        return;
      }
      catch (Exception paramStUser)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "parseLocationOrAuth error" + paramStUser.getMessage());
      }
      label419:
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setText(paramStUser.desc.get());
      break;
      label444:
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUserData((FeedCloudMeta.StUser)paramStUser.get());
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setItemReportListener(new ubk(this));
      boolean bool = tra.a(paramStMainPageBusiRspData.opMask.get());
      QLog.d(jdField_a_of_type_JavaLangString, 1, "isShowChatEntrance" + bool);
      if ((tra.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get())) || (bool))
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        tyj.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 4L, 1L);
        break label93;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      break label93;
      label588:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    label600:
    int i1 = "[SchoolAuth]".length();
    int m = 1;
    n = i;
    i = i1;
    for (;;)
    {
      if (TextUtils.isEmpty(paramStMainPageBusiRspData))
      {
        this.f.setVisibility(8);
        return;
        label634:
        QLog.d(jdField_a_of_type_JavaLangString, 1, "poster.busiData is null");
      }
      else
      {
        paramStUser = new SpannableString(paramStMainPageBusiRspData.toString());
        if (k != 0) {
          a(paramStUser, 0, k, 3);
        }
        if (m != 0) {
          a(paramStUser, k, i, 6);
        }
        if (n != 0) {
          a(paramStUser, n, j);
        }
        this.f.setText(paramStUser);
        this.f.setVisibility(0);
        this.f.setMovementMethod(LinkMovementMethod.getInstance());
        QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { paramStMainPageBusiRspData });
        return;
        label744:
        j = 0;
        break label325;
        label750:
        k = 0;
        break;
      }
      label756:
      j = 0;
      i = 0;
      m = 0;
    }
  }
  
  private void b()
  {
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
  }
  
  private void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_d_of_type_AndroidWidgetTextView.setText(tra.b(paramInt));
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.get() != null) && (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData != null)) {
      tqs.a(this.jdField_a_of_type_AndroidContentContext, tqr.a(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.urlInfo.get(), "authSchoolUrl"));
    }
  }
  
  private void d()
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
      String str2 = bdbt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), true);
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
  
  private void e()
  {
    int j = 1;
    if ((this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData != null) && (tra.b(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.opMask.get()))) {}
    Object localObject;
    for (int i = 1;; i = 0)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "canJumpProfile" + this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get());
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
      if (!((aloz)localBaseActivity.app.getManager(51)).b((String)localObject)) {
        i = 115;
      }
    }
  }
  
  public int a()
  {
    return 2131560559;
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
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFollowUpdateEvent.class);
    localArrayList.add(QCircleFeedEvent.class);
    return localArrayList;
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378843));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView = ((AsyncRichTextView)findViewById(2131378683));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView = ((QCircleFollowView)findViewById(2131378747));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378732));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378726));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378750));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)findViewById(2131368794));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369618));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378874));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369631));
    this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369630));
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369632));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368892));
    this.f = ((TextView)findViewById(2131378821));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369628));
    b();
    a(false);
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    QCircleFollowUpdateEvent localQCircleFollowUpdateEvent;
    if (((paramSimpleBaseEvent instanceof QCircleFollowUpdateEvent)) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null))
    {
      localQCircleFollowUpdateEvent = (QCircleFollowUpdateEvent)paramSimpleBaseEvent;
      if (tra.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) {
        if (localQCircleFollowUpdateEvent.mFollowStatus == 1) {
          this.jdField_c_of_type_Int += 1;
        }
      }
    }
    label131:
    do
    {
      do
      {
        break label131;
        break label131;
        b(this.jdField_c_of_type_Int);
        do
        {
          ThreadManager.getUIHandler().post(new QCirclePersonInfoAndStatusWidget.5(this));
          wsv.c(jdField_a_of_type_JavaLangString, "onReceiveEvent  id:" + ((QCircleFollowUpdateEvent)paramSimpleBaseEvent).mUserId + " , status:" + ((QCircleFollowUpdateEvent)paramSimpleBaseEvent).mFollowStatus + " " + toString());
          return;
          if (this.jdField_c_of_type_Int <= 0) {
            break;
          }
          this.jdField_c_of_type_Int -= 1;
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
  
  public void a(Object paramObject)
  {
    if (paramObject == null) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "bindData error");
    }
    do
    {
      return;
      if ((paramObject instanceof FeedCloudMeta.StUser))
      {
        this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = ((FeedCloudMeta.StUser)paramObject);
        a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser, this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData);
        return;
      }
    } while (!(paramObject instanceof FeedCloudRead.StGetMainPageRsp));
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
        QLog.e(jdField_a_of_type_JavaLangString, 1, "mergeFrom stMainPageBusiRspData error");
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "enableFlingRight->enable:" + paramBoolean);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    yej.a().a(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131369631: 
    case 2131369632: 
    case 2131368794: 
    case 2131378843: 
    case 2131378683: 
    case 2131378821: 
    case 2131369630: 
      do
      {
        do
        {
          do
          {
            return;
          } while (this.jdField_a_of_type_Ubm == null);
          this.jdField_a_of_type_Ubm.a();
          return;
        } while (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData == null);
        tqs.a(this.jdField_a_of_type_AndroidContentContext, tqr.a(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.urlInfo.get(), "followListUrl"));
        return;
        tyj.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 6L, 1L);
        e();
        return;
        tyj.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 6L, 2L);
        e();
        return;
        tyj.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 6L, 4L);
        e();
        return;
        e();
        return;
      } while (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData == null);
      tqs.a(this.jdField_a_of_type_AndroidContentContext, tqr.a(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.urlInfo.get(), "fansListUrl"));
      return;
    case 2131378874: 
      d();
      tyj.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 4L, 2L);
      return;
    }
    c();
    tyj.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 5L, 2L);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    yej.a().b(this);
  }
  
  public void setHeaderClickListener(ubm paramubm)
  {
    this.jdField_a_of_type_Ubm = paramubm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePersonInfoAndStatusWidget
 * JD-Core Version:    0.7.0.1
 */