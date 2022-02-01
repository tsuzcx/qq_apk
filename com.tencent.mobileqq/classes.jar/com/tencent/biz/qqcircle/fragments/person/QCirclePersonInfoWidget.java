package com.tencent.biz.qqcircle.fragments.person;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
import anmw;
import bglf;
import com.tencent.biz.qqcircle.QCircleHippyBean;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCircleFollowUpdateEvent;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView;
import com.tencent.biz.qqcircle.widgets.QCircleSpecialFollowImageView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
import qqcircle.QQCircleProfile.StProfileBizData;
import uxk;
import uxn;
import uxo;
import uxx;
import vnd;
import vnf;
import vng;
import vrf;
import vtu;
import vyt;
import vyz;
import yqp;
import zwp;
import zwr;
import zzr;

public class QCirclePersonInfoWidget
  extends QCircleBaseWidgetView
  implements View.OnClickListener, zwr
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleAvatarView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  private QCircleFollowView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView;
  private QCircleSpecialFollowImageView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleSpecialFollowImageView;
  private AsyncRichTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  private FeedCloudRead.StGetMainPageRsp jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp;
  private String jdField_a_of_type_JavaLangString = "";
  private List<QQCircleBase.UserCircleInfo> jdField_a_of_type_JavaUtilList;
  private QQCircleBase.StUserBusiData jdField_a_of_type_QqcircleQQCircleBase$StUserBusiData;
  private QQCircleFeedBase.StMainPageBusiRspData jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData;
  private vng jdField_a_of_type_Vng;
  private vyt jdField_a_of_type_Vyt;
  private vyz jdField_a_of_type_Vyz;
  private long jdField_b_of_type_Long;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private List<QQCircleBase.UserCircleInfo> jdField_b_of_type_JavaUtilList;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private List<QQCircleBase.UserCircleInfo> jdField_c_of_type_JavaUtilList;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  
  public QCirclePersonInfoWidget(Context paramContext)
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
    int k = paramString.length;
    int j = 0;
    if (j < k)
    {
      CharSequence localCharSequence = paramString[j];
      if ((TextUtils.isEmpty(localCharSequence)) || (localCharSequence.equals(getResources().getString(2131715713)))) {}
      for (;;)
      {
        j += 1;
        break;
        if (!TextUtils.isEmpty(localStringBuilder)) {
          localStringBuilder.append("·");
        }
        localStringBuilder.append(localCharSequence);
      }
    }
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.jdField_a_of_type_Vyz.a(new vnd(this));
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      ColorDrawable localColorDrawable = new ColorDrawable(getResources().getColor(2131167224));
      localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
      localURLDrawableOptions.mFailedDrawable = localColorDrawable;
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentImageURLImageView.getMeasuredWidth();
      localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentImageURLImageView.getMeasuredHeight();
      this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(URLDrawable.getDrawable(uxx.a(paramInt), localURLDrawableOptions));
    }
  }
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_d_of_type_AndroidWidgetTextView.setText(uxx.d(paramLong));
  }
  
  private void a(SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    paramSpannableString.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(2131166258)), paramInt1, paramInt2, 17);
  }
  
  private void a(FeedCloudMeta.StUser paramStUser, QQCircleFeedBase.StMainPageBusiRspData paramStMainPageBusiRspData)
  {
    int m = 0;
    int i2 = 0;
    int i1 = 0;
    this.jdField_a_of_type_QqcircleQQCircleBase$StUserBusiData = null;
    Object localObject1;
    if ((paramStUser != null) && (paramStUser.get() != null))
    {
      QLog.d("QCirclePersonInfoAndStatusWidget", 1, "nickName is" + paramStUser.nick.get());
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStUser.nick.get());
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramStUser);
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
      if (paramStUser.sex.get() != 1) {
        break label851;
      }
      j = 2130844005;
      ((ImageView)localObject1).setImageResource(j);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleSpecialFollowImageView.setUser(paramStUser);
      if (paramStMainPageBusiRspData == null) {
        break label901;
      }
      j = paramStMainPageBusiRspData.giftCnt.get();
      zzr.a(this.f, false);
      if (j <= 0) {
        break label858;
      }
      this.f.setVisibility(0);
      this.f.setText(String.valueOf(j));
      vrf.a(paramStUser.id.get(), 11, 32, 1, String.valueOf(paramStUser.followState.get()), "", "", "", "");
    }
    int n;
    for (;;)
    {
      try
      {
        localObject1 = new QQCircleProfile.StProfileBizData();
        ((QQCircleProfile.StProfileBizData)localObject1).mergeFrom(paramStMainPageBusiRspData.profileBusiData.get().toByteArray());
        if (!TextUtils.isEmpty(((QQCircleProfile.StProfileBizData)localObject1).followText.get()))
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(((QQCircleProfile.StProfileBizData)localObject1).followText.get());
          vrf.a("", 11, 27, 1);
          if (!TextUtils.isEmpty(paramStUser.desc.get())) {
            break label922;
          }
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setVisibility(8);
          if (!uxx.a(paramStUser)) {
            break label947;
          }
          this.h.setVisibility(0);
          vrf.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 24, 1, d());
          if ((!uxx.a(paramStUser)) && (paramStMainPageBusiRspData != null)) {
            break label959;
          }
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          if (!uxx.c(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) {
            break label1085;
          }
          this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
          try
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(" / ");
            if (!TextUtils.isEmpty(paramStUser.location.get()))
            {
              localObject2 = a(paramStUser.location.get());
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                ((StringBuilder)localObject1).append((String)localObject2);
              }
            }
            if ((!paramStUser.busiData.has()) || (paramStUser.busiData.get() == null)) {
              break label1318;
            }
            Object localObject2 = new QQCircleBase.StUserBusiData();
            ((QQCircleBase.StUserBusiData)localObject2).mergeFrom(paramStUser.busiData.get().toByteArray());
            this.jdField_a_of_type_QqcircleQQCircleBase$StUserBusiData = ((QQCircleBase.StUserBusiData)localObject2);
            b(((QQCircleBase.StUserBusiData)localObject2).fuelValue.get());
            j = ((QQCircleBase.StUserBusiData)localObject2).talentLevel.get();
            a(j);
            if (j > 0) {
              vrf.a(paramStUser.id.get(), 11, 14, 1, d());
            }
            this.jdField_a_of_type_JavaUtilList = new ArrayList();
            this.jdField_b_of_type_JavaUtilList = ((QQCircleBase.StUserBusiData)localObject2).schoolInfos.get();
            this.jdField_c_of_type_JavaUtilList = ((QQCircleBase.StUserBusiData)localObject2).companyInfos.get();
            QLog.d("QCirclePersonInfoAndStatusWidget", 1, "mSchoolCircleInfos size:" + this.jdField_b_of_type_JavaUtilList.size() + " mCompanyCircleInfos size:" + this.jdField_c_of_type_JavaUtilList.size());
            if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() <= 0)) {
              break label1097;
            }
            QLog.d("QCirclePersonInfoAndStatusWidget", 1, "mSchoolCircleInfos size:" + this.jdField_b_of_type_JavaUtilList.size());
            if (((StringBuilder)localObject1).length() <= " / ".length()) {
              break label1478;
            }
            n = ((StringBuilder)localObject1).length();
            m = n + " / ".length();
            ((StringBuilder)localObject1).append(" / ");
            this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_b_of_type_JavaUtilList);
            paramStUser = this.jdField_b_of_type_JavaUtilList.iterator();
            k = m;
            j = n;
            if (!paramStUser.hasNext()) {
              break label1102;
            }
            ((StringBuilder)localObject1).append(((QQCircleBase.UserCircleInfo)paramStUser.next()).name.get()).append(" ");
            continue;
            if (paramStMainPageBusiRspData == null) {
              continue;
            }
          }
          catch (Exception paramStUser)
          {
            QLog.e("QCirclePersonInfoAndStatusWidget", 1, "parseLocationOrAuth error" + paramStUser.getMessage());
          }
          label808:
          this.jdField_a_of_type_Vyt.a(a());
          this.jdField_a_of_type_Vyt.a(paramStMainPageBusiRspData);
          if ((paramStMainPageBusiRspData != null) && (paramStMainPageBusiRspData.profileBusiData.get() != null)) {
            a(paramStMainPageBusiRspData);
          }
          return;
          label851:
          j = 2130844120;
          break;
          label858:
          this.f.setVisibility(8);
          continue;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        continue;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        continue;
      }
      label901:
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.f.setVisibility(8);
      continue;
      label922:
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setText(paramStUser.desc.get());
      continue;
      label947:
      this.h.setVisibility(8);
      continue;
      label959:
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setItemReportListener(new vnf(this));
      boolean bool = uxx.a(paramStMainPageBusiRspData.opMask.get());
      QLog.d("QCirclePersonInfoAndStatusWidget", 1, "isShowChatEntrance" + bool);
      if (bool)
      {
        this.g.setVisibility(0);
        vrf.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 4, 1, d());
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUserData((FeedCloudMeta.StUser)paramStUser.get());
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        break;
        this.g.setVisibility(8);
      }
      label1085:
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
    label1097:
    int k = 0;
    int j = 0;
    label1102:
    if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.size() > 0))
    {
      QLog.d("QCirclePersonInfoAndStatusWidget", 1, "mSchoolCircleInfos size:" + this.jdField_c_of_type_JavaUtilList.size());
      if (localInvalidProtocolBufferMicroException.length() > " / ".length())
      {
        m = localInvalidProtocolBufferMicroException.length();
        n = m + " / ".length();
        localInvalidProtocolBufferMicroException.append(" / ");
        this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_c_of_type_JavaUtilList);
        paramStUser = this.jdField_c_of_type_JavaUtilList.iterator();
        while (paramStUser.hasNext()) {
          localInvalidProtocolBufferMicroException.append(((QQCircleBase.UserCircleInfo)paramStUser.next()).name.get()).append(" ");
        }
      }
    }
    for (;;)
    {
      label1197:
      if ((TextUtils.isEmpty(localInvalidProtocolBufferMicroException)) || (localInvalidProtocolBufferMicroException.length() <= " / ".length()))
      {
        this.i.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        ((View)this.i.getParent()).setVisibility(8);
        break label808;
        QLog.d("QCirclePersonInfoAndStatusWidget", 1, "poster.busiData is null");
        n = 0;
        j = 0;
        k = 0;
        continue;
      }
      label1318:
      paramStUser = new SpannableString(localInvalidProtocolBufferMicroException.toString());
      if (k != 0) {
        a(paramStUser, k, j);
      }
      if (m != 0) {
        a(paramStUser, m, n);
      }
      a(paramStUser, 0, " / ".length());
      this.i.setText(paramStUser);
      this.i.setVisibility(0);
      ((View)this.i.getParent()).setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.i.setMovementMethod(LinkMovementMethod.getInstance());
      QLog.d("QCirclePersonInfoAndStatusWidget", 1, new Object[] { localInvalidProtocolBufferMicroException });
      break label808;
      n = 0;
      m = i1;
      break label1197;
      n = 0;
      m = i2;
      break label1487;
      label1478:
      m = 0;
      n = 0;
      break;
      label1487:
      i1 = j;
      j = k;
      k = i1;
    }
  }
  
  private void a(QQCircleFeedBase.StMainPageBusiRspData paramStMainPageBusiRspData)
  {
    if (paramStMainPageBusiRspData != null)
    {
      Object localObject = new QQCircleProfile.StProfileBizData();
      try
      {
        ((QQCircleProfile.StProfileBizData)localObject).mergeFrom(paramStMainPageBusiRspData.profileBusiData.get().toByteArray());
        QLog.d("QCirclePersonInfoAndStatusWidget", 2, "updateTroopTagList profileBizData.groupIDList.size:" + ((QQCircleProfile.StProfileBizData)localObject).groupIDList.size() + ", profileBizData.groupIDList:" + ((QQCircleProfile.StProfileBizData)localObject).groupIDList);
        this.jdField_a_of_type_Vyz.a(((QQCircleProfile.StProfileBizData)localObject).groupIDList.get());
        paramStMainPageBusiRspData = new StringBuilder();
        if (((QQCircleProfile.StProfileBizData)localObject).groupIDList.get() != null)
        {
          localObject = ((QQCircleProfile.StProfileBizData)localObject).groupIDList.get().iterator();
          for (;;)
          {
            if (!((Iterator)localObject).hasNext()) {
              break label200;
            }
            l = ((Long)((Iterator)localObject).next()).longValue();
            if (!"".equals(paramStMainPageBusiRspData.toString())) {
              break;
            }
            paramStMainPageBusiRspData.append(l);
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramStMainPageBusiRspData)
      {
        for (;;)
        {
          long l;
          QLog.e("QCirclePersonInfoAndStatusWidget", 2, "updateTroopTagList mergeFrom error");
          continue;
          paramStMainPageBusiRspData.append(";").append(l);
        }
        label200:
        vrf.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 31, 1, "", paramStMainPageBusiRspData.toString(), "", "", "", d());
      }
    }
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.e.setText(uxx.d(paramInt));
  }
  
  private void b(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_c_of_type_AndroidWidgetTextView.setText(uxx.d(paramLong));
  }
  
  private void c()
  {
    zzr.a(this.jdField_c_of_type_AndroidWidgetTextView, false);
    zzr.a(this.jdField_d_of_type_AndroidWidgetTextView, false);
    zzr.a(this.e, false);
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_QqcircleQQCircleBase$StUserBusiData;
    if (localObject != null)
    {
      localObject = ((QQCircleBase.StUserBusiData)localObject).fuelValueJumpUrl.get();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        uxo.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject);
      }
    }
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_QqcircleQQCircleBase$StUserBusiData;
    if (localObject != null)
    {
      localObject = ((QQCircleBase.StUserBusiData)localObject).talentLevelJumpUrl.get();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        uxo.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject);
        localObject = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
        if (localObject != null) {
          vrf.a(((FeedCloudMeta.StUser)localObject).id.get(), 11, 14, 2, d());
        }
      }
    }
  }
  
  private void f()
  {
    if ((!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser == null) || (TextUtils.isEmpty(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get()))) {
      return;
    }
    String str = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
    localIntent.putExtra("open_chatfragment", true);
    localIntent.putExtra("PREVIOUS_WINDOW", QCirclePersonalDetailFragment.class.getName());
    localIntent.putExtra("uin", str);
    if (uxx.a(this.jdField_a_of_type_AndroidContentContext, str)) {
      localIntent.putExtra("uintype", 0);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        localIntent.putExtra("qcircle_chat_show_fuel_tips_key", this.jdField_a_of_type_JavaLangString);
      }
      localIntent.putExtra("aio_msg_source", 3);
      Object localObject2 = bglf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, true);
      Object localObject1 = localObject2;
      if (str.equals(localObject2)) {
        localObject1 = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.nick.get();
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localIntent.putExtra("uinname", (String)localObject2);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
      localIntent.putExtra("uintype", 10008);
    }
  }
  
  private void g()
  {
    int k = 1;
    if ((this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData != null) && (uxx.b(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.opMask.get()))) {}
    Object localObject;
    for (int j = 1;; j = 0)
    {
      QLog.d("QCirclePersonInfoAndStatusWidget", 1, "canJumpProfile" + this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get());
      if (((j != 0) || (uxx.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get()))) && (this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get())))
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
      j = 0;
    }
    for (;;)
    {
      localObject = new ProfileActivity.AllInOne((String)localObject, j);
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = j;
      ((ProfileActivity.AllInOne)localObject).h = 128;
      ((ProfileActivity.AllInOne)localObject).i = 3080;
      ((ProfileActivity.AllInOne)localObject).l = 2;
      ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject, false);
      return;
      j = k;
      if (!((anmw)localBaseActivity.app.getManager(51)).b((String)localObject)) {
        j = 115;
      }
    }
  }
  
  public int a()
  {
    return 2131560746;
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
  
  public String a()
  {
    return "QCirclePersonInfoAndStatusWidget";
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379783));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369282));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379676));
    paramContext = getResources().getDrawable(2130843968);
    paramContext.setBounds(0, vtu.a(1.0F), vtu.a(11.0F), vtu.a(11.0F));
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, paramContext, null);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView = ((AsyncRichTextView)findViewById(2131379602));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView = ((QCircleFollowView)findViewById(2131379671));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379681));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379648));
    this.e = ((TextView)findViewById(2131379674));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370077));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370065));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370066));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)findViewById(2131369156));
    this.jdField_a_of_type_Vyt = new vyt();
    this.jdField_a_of_type_Vyt.a(paramView);
    this.jdField_a_of_type_Vyz = new vyz();
    this.jdField_a_of_type_Vyz.a(paramView, 0);
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370053));
    this.g = ((TextView)findViewById(2131379823));
    this.h = ((TextView)findViewById(2131379824));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131369030));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleSpecialFollowImageView = ((QCircleSpecialFollowImageView)findViewById(2131369298));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleSpecialFollowImageView.setUser(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
    this.i = ((TextView)findViewById(2131379758));
    this.f = ((TextView)findViewById(2131376483));
    a();
    c();
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
        a(this.jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp.fansCount.get());
        b(this.jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp.followCount.get());
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp.pmBeginShow.get();
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
    zwp.a().a(this);
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
      if (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData != null)
      {
        uxo.a(this.jdField_a_of_type_AndroidContentContext, uxn.a(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.urlInfo.get(), "followListUrl"));
        continue;
        vrf.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 6, 1, d());
        g();
        continue;
        vrf.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 6, 2, d());
        g();
        continue;
        vrf.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 6, 4, d());
        if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.a())
        {
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setMaxLines(2147483647);
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setText(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.desc.get());
        }
        else if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.getLineCount() > 5)
        {
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setMaxLines(5);
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setText(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.desc.get());
          continue;
          g();
          continue;
          e();
          continue;
          d();
          continue;
          if (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData != null)
          {
            uxo.a(this.jdField_a_of_type_AndroidContentContext, uxn.a(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.urlInfo.get(), "fansListUrl"));
            continue;
            f();
            vrf.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 4, 2, d());
            continue;
            if ((this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null))
            {
              uxk localuxk = new uxk();
              localuxk.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
              localuxk.a(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.toByteArray());
              localuxk.a(a().clone().setElementIdStr("edit_profile"));
              uxo.b(localuxk.a());
              vrf.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 24, 2, d());
              continue;
              if ((this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null))
              {
                uxo.a(getContext(), new QCircleHippyBean().setModuleName("WeZoneGift").setDefaultUrl(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.giftJumpUrl.get()).setPersonalUin(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get()));
                vrf.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 32, 2, String.valueOf(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get()), "", "", "", "");
                continue;
                uxo.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
                vrf.a("", 11, 27, 2);
              }
            }
          }
        }
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    zwp.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    QCircleFollowUpdateEvent localQCircleFollowUpdateEvent;
    if (((paramSimpleBaseEvent instanceof QCircleFollowUpdateEvent)) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null))
    {
      localQCircleFollowUpdateEvent = (QCircleFollowUpdateEvent)paramSimpleBaseEvent;
      if (!uxx.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) {
        break label152;
      }
      if (localQCircleFollowUpdateEvent.mFollowStatus != 1) {
        break label132;
      }
      this.jdField_a_of_type_Int += 1;
      b(this.jdField_a_of_type_Int);
    }
    label132:
    label152:
    while (!TextUtils.equals(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), localQCircleFollowUpdateEvent.mUserId)) {
      for (;;)
      {
        ThreadManager.getUIHandler().post(new QCirclePersonInfoWidget.5(this));
        yqp.c("QCirclePersonInfoAndStatusWidget", "onReceiveEvent  id:" + ((QCircleFollowUpdateEvent)paramSimpleBaseEvent).mUserId + " , status:" + ((QCircleFollowUpdateEvent)paramSimpleBaseEvent).mFollowStatus + " " + toString());
        return;
        if (this.jdField_a_of_type_Int > 0) {
          this.jdField_a_of_type_Int -= 1;
        }
      }
    }
    if ((localQCircleFollowUpdateEvent.mFollowStatus == 1) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get() == 0)) {}
    for (this.jdField_a_of_type_Long += 1L;; this.jdField_a_of_type_Long -= 1L) {
      do
      {
        this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.set(((QCircleFollowUpdateEvent)paramSimpleBaseEvent).mFollowStatus);
        break;
      } while ((localQCircleFollowUpdateEvent.mFollowStatus != 0) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.followState.get() != 1) || (this.jdField_a_of_type_Long <= 0L));
    }
  }
  
  public void setHeaderClickListener(vng paramvng)
  {
    this.jdField_a_of_type_Vng = paramvng;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonInfoWidget
 * JD-Core Version:    0.7.0.1
 */