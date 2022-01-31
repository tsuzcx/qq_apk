package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyTimeUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.RingAvatarView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import lvm;
import lvn;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.FriendRecommendInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PackInfo;

public class ComponentHeaderFriendRecommend
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  public Button a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ReadInJoyNickNameTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
  RingAvatarView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView;
  private List jdField_a_of_type_JavaUtilList;
  ReadInJoyHeadImageView[] jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public ComponentHeaderFriendRecommend(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentHeaderFriendRecommend(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentHeaderFriendRecommend(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private String a(ArticleInfo paramArticleInfo)
  {
    Object localObject;
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.i())
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt;
      if (!CmpCtxt.a(paramArticleInfo)) {}
    }
    else
    {
      localObject = paramArticleInfo.mSocialFeedInfo.c;
      paramArticleInfo = (ArticleInfo)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramArticleInfo = "";
      }
    }
    for (;;)
    {
      return paramArticleInfo;
      try
      {
        localObject = ((oidb_cmd0x68b.FriendRecommendInfo)paramArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).str_header_title.get();
        paramArticleInfo = (ArticleInfo)localObject;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        QLog.w("ComponentHeaderFriendRecommend", 1, "ReadInJoyHeader friend recommend description empty");
        return localObject;
      }
      catch (Exception paramArticleInfo)
      {
        for (;;)
        {
          paramArticleInfo.printStackTrace();
          localObject = null;
        }
      }
    }
  }
  
  private List a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
    ArrayList localArrayList1 = new ArrayList();
    if (localObject == null) {
      return localArrayList1;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a())
    {
      localObject = new ArrayList(1);
      try
      {
        ((List)localObject).add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSubscribeID)));
        return localObject;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
        return localObject;
      }
    }
    ArrayList localArrayList2;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.i()) || (c()))
    {
      localArrayList2 = new ArrayList(1);
      localArrayList2.add(Long.valueOf(((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long));
      return localArrayList2;
    }
    if ((((ArticleInfo)localObject).mPackInfoObj != null) && (((ArticleInfo)localObject).mPackInfoObj.has())) {}
    try
    {
      localArrayList2.addAll(((oidb_cmd0x68b.FriendRecommendInfo)((ArticleInfo)localObject).mPackInfoObj.msg_friend_recommend_info.get()).rpt_recommenders.get());
      if (localArrayList2.isEmpty()) {
        QLog.w("ComponentHeaderFriendRecommend", 1, "ReadInJoyHeader friend recommend uin list empty");
      }
      return localArrayList2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = ReadInJoyUtils.a();
      localJSONObject.put("feeds_source", paramString);
      localJSONObject.put("kandian_mode", ReadInJoyUtils.e());
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800744D", "0X800744D", 0, 0, ReadInJoyUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a()), "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void a(List paramList)
  {
    if ((paramList != null) && (paramList.size() == 1))
    {
      if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.i()) && (!c())) {
        setOnClickListener(this);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(ReadInJoyUtils.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSubscribeName));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(((Long)paramList.get(0)).longValue());
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.i()) || (c()))
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Int == 1)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    setOnClickListener(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private String b(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.i()) && (!c())) {
      return null;
    }
    if (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.d)) {
      return paramArticleInfo.mSocialFeedInfo.d;
    }
    int i = paramArticleInfo.mSocialFeedInfo.e;
    if (i > 0) {
      return ReadInJoyTimeUtils.a(i, true);
    }
    return "刚刚";
  }
  
  private void b(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a())
    {
      String str = ReadInJoyConstants.i + Base64Util.encodeToString(String.valueOf(paramLong).getBytes(), 2);
      ReadInJoyUtils.a(getContext(), str);
    }
    for (;;)
    {
      a(ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a()));
      return;
      a(paramLong);
    }
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a() == null) {
      return false;
    }
    CmpCtxt localCmpCtxt = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt;
    return CmpCtxt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a());
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.i()) || (c()))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a()));
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo;
      if ((localObject != null) && (!TextUtils.isEmpty(((SocializeFeedsInfo)localObject).d)))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(((SocializeFeedsInfo)localObject).d);
        return;
      }
      localObject = b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a());
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a()));
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2130969577, this, true);
  }
  
  public void a(long paramLong)
  {
    Object localObject1 = ReadInJoyConstants.f + Base64Util.encodeToString(String.valueOf(paramLong).getBytes(), 2);
    ReadInJoyUtils.a(getContext(), (String)localObject1);
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
    ReadInJoyUtils.a = localArticleInfo;
    localObject1 = "";
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("folder_status", ReadInJoyUtils.d);
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.i())
        {
          CmpCtxt localCmpCtxt = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt;
          if (!CmpCtxt.a(localArticleInfo)) {
            continue;
          }
        }
        ((JSONObject)localObject2).put("feeds_source", String.valueOf(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long));
        ((JSONObject)localObject2).put("rowkey", localArticleInfo.innerUniqueID);
        ((JSONObject)localObject2).put("feeds_type", "" + ReadInJoyUtils.a(localArticleInfo));
        ((JSONObject)localObject2).put("kandian_mode", "" + ReadInJoyUtils.e());
        ((JSONObject)localObject2).put("tab_source", "" + ReadInJoyUtils.d());
        ((JSONObject)localObject2).put("entry_mode", "1");
        localObject2 = ((JSONObject)localObject2).toString();
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException)
      {
        Object localObject2;
        localJSONException.printStackTrace();
        continue;
        PublicAccountReportUtils.a(null, localArticleInfo.mSubscribeID, "0X8007BA3", "0X8007BA3", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mFeedId), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mArticleID), "", (String)localObject1, false);
      }
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt;
      if (!CmpCtxt.a(localArticleInfo)) {
        continue;
      }
      PublicAccountReportUtils.a(null, String.valueOf(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), "0X8007BA3", "0X8007BA3", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mFeedId), "0", "", (String)localObject1, false);
      ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e());
      return;
      ((JSONObject)localObject2).put("feeds_source", "");
    }
  }
  
  public void a(long paramLong, Bitmap paramBitmap)
  {
    if (ReadInJoyUtils.a())
    {
      List localList = a();
      if ((localList.size() > 0) && (localList.contains(Long.valueOf(paramLong))))
      {
        int i = localList.indexOf(Long.valueOf(paramLong));
        this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[i].setImageBitmap(paramBitmap);
      }
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131367022));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131367025));
    this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = new ReadInJoyHeadImageView[4];
    this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[0] = ((ReadInJoyHeadImageView)findViewById(2131366860));
    this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[1] = ((ReadInJoyHeadImageView)findViewById(2131366861));
    this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[2] = ((ReadInJoyHeadImageView)findViewById(2131366862));
    this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[3] = ((ReadInJoyHeadImageView)findViewById(2131366863));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)findViewById(2131366865));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367024));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366866));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367026));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131367027));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView = ((RingAvatarView)findViewById(2131367023));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367028));
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    if (b()) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      if (b())
      {
        this.jdField_a_of_type_JavaUtilList = a();
        a(paramIReadInJoyModel, this.jdField_a_of_type_JavaUtilList);
        a(this.jdField_a_of_type_JavaUtilList);
        UtilsForComponent.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView, this.jdField_b_of_type_AndroidWidgetImageView);
        d();
        setFollowBotton();
      }
      return;
    }
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel, List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < Math.min(4, paramList.size()))
      {
        this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[i].setHeadImgByUin(((Long)paramList.get(i)).longValue());
        this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[i].setVisibility(0);
        this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[i].setOnClickListener(new lvm(this, paramList, i));
        i += 1;
      }
      i = Math.min(4, paramList.size());
      while (i < 4)
      {
        this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[i].setVisibility(8);
        this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[i].setOnClickListener(null);
        i += 1;
      }
    }
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof IReadInJoyModel)) {
      a((IReadInJoyModel)paramObject);
    }
  }
  
  public void b()
  {
    super.b();
    Object localObject = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.i()) || (c()))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), AIOUtils.a(15.0F, getResources()), this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight(), AIOUtils.a(12.0F, getResources()));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setPadding(this.jdField_b_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), AIOUtils.a(15.0F, getResources()), this.jdField_b_of_type_AndroidWidgetLinearLayout.getPaddingRight(), this.jdField_b_of_type_AndroidWidgetLinearLayout.getPaddingBottom());
      ((LinearLayout.LayoutParams)localObject).gravity = 48;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      localObject = (LinearLayout)findViewById(2131367021);
      if ((((LinearLayout)localObject).getLayoutParams() instanceof RelativeLayout.LayoutParams))
      {
        localObject = (RelativeLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
        if (!a()) {
          break;
        }
        ((RelativeLayout.LayoutParams)localObject).setMargins(ViewUtils.a(12.0F), 0, ViewUtils.a(12.0F), 0);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), AIOUtils.a(7.5F, getResources()), this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight(), AIOUtils.a(7.5F, getResources()));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setPadding(this.jdField_b_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), AIOUtils.a(7.5F, getResources()), this.jdField_b_of_type_AndroidWidgetLinearLayout.getPaddingRight(), this.jdField_b_of_type_AndroidWidgetLinearLayout.getPaddingBottom());
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    ((RelativeLayout.LayoutParams)localObject).setMargins(ViewUtils.a(12.0F), 0, ViewUtils.a(2.25F), 0);
  }
  
  public boolean b()
  {
    IReadInJoyModel localIReadInJoyModel = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a;
    return (localIReadInJoyModel.a()) && ((localIReadInJoyModel.c() == 2) || (localIReadInJoyModel.c() == 3));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if (paramView == this)
      {
        paramView = a();
        if ((paramView != null) && (paramView.size() == 1)) {
          b(((Long)paramView.get(0)).longValue());
        }
      }
    case 2131366865: 
      do
      {
        return;
        paramView = a();
      } while ((paramView == null) || (paramView.size() != 1));
      b(((Long)paramView.get(0)).longValue());
      return;
    }
    paramView = ReadInJoyUtils.a();
    if (paramView != null)
    {
      ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
      ReadInJoyBaseAdapter.a(localArticleInfo, "0X80080EC", "0X80080EC", 70);
      ReadInJoyLogicEngine.b(localArticleInfo);
      if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null))
      {
        long l = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
        ReadInJoyLogicEngine.a().a().a(paramView.getAccount(), String.valueOf(l), true, new lvn(this, localArticleInfo));
      }
    }
    c();
  }
  
  public void setFollowBotton()
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
    if (localArticleInfo == null) {
      return;
    }
    SocializeFeedsInfo localSocializeFeedsInfo = localArticleInfo.mSocialFeedInfo;
    if (localSocializeFeedsInfo == null)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
    }
    if (localSocializeFeedsInfo.h == 1)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(true);
      this.jdField_a_of_type_AndroidWidgetButton.setText("关注");
      return;
    }
    if ((localArticleInfo.isNeedShowBtnWhenFollowed) && (localSocializeFeedsInfo.h == 2))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText("已关注");
      this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(false);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderFriendRecommend
 * JD-Core Version:    0.7.0.1
 */