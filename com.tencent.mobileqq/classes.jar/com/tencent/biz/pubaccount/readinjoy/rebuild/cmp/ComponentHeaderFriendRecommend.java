package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import actj;
import ajya;
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
import bbco;
import bbll;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.RingAvatarView;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import nol;
import omj;
import ong;
import onh;
import org.json.JSONException;
import org.json.JSONObject;
import osg;
import pau;
import pbu;
import puy;
import pwv;
import pww;
import pym;
import qci;
import qda;
import ram;
import shu;
import tencent.im.oidb.articlesummary.articlesummary.FriendRecommendInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;

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
  private List<Long> jdField_a_of_type_JavaUtilList;
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
    if (!this.jdField_a_of_type_Puy.i())
    {
      localObject = this.jdField_a_of_type_Puy;
      if (!puy.a(paramArticleInfo)) {}
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
        localObject = ((articlesummary.FriendRecommendInfo)paramArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).str_header_title.get();
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
  
  private List<Long> a()
  {
    Object localObject = this.jdField_a_of_type_Puy.a.a();
    ArrayList localArrayList1 = new ArrayList();
    if (localObject == null) {
      return localArrayList1;
    }
    if (this.jdField_a_of_type_Puy.a())
    {
      localObject = new ArrayList(1);
      try
      {
        ((List)localObject).add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_Puy.a.a().mSubscribeID)));
        return localObject;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
        return localObject;
      }
    }
    ArrayList localArrayList2;
    if ((this.jdField_a_of_type_Puy.i()) || (c()))
    {
      localArrayList2 = new ArrayList(1);
      localArrayList2.add(Long.valueOf(((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long));
      return localArrayList2;
    }
    if ((((ArticleInfo)localObject).mPackInfoObj != null) && (((ArticleInfo)localObject).mPackInfoObj.has())) {}
    try
    {
      localArrayList2.addAll(((articlesummary.FriendRecommendInfo)((ArticleInfo)localObject).mPackInfoObj.msg_friend_recommend_info.get()).rpt_recommenders.get());
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
      JSONObject localJSONObject = onh.a();
      localJSONObject.put("feeds_source", paramString);
      localJSONObject.put("kandian_mode", onh.e());
      String str = onh.d(this.jdField_a_of_type_Puy.a.a());
      if (shu.a(this.jdField_a_of_type_Puy.a.e())) {}
      for (paramString = "0X8009357";; paramString = "0X800744D")
      {
        nol.a(null, "CliOper", "", "", paramString, paramString, 0, 0, str, "", "", localJSONObject.toString(), false);
        return;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void a(List<Long> paramList)
  {
    if ((paramList != null) && (paramList.size() == 1))
    {
      if ((!this.jdField_a_of_type_Puy.i()) && (!c())) {
        setOnClickListener(this);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
      if (this.jdField_a_of_type_Puy.a())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(onh.d(this.jdField_a_of_type_Puy.a.a().mSubscribeName));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(((Long)paramList.get(0)).longValue());
      if ((this.jdField_a_of_type_Puy.i()) || (c()))
      {
        if (this.jdField_a_of_type_Puy.a.a().mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Int == 1)
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
    while ((!this.jdField_a_of_type_Puy.i()) && (!c())) {
      return null;
    }
    if (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.d)) {
      return paramArticleInfo.mSocialFeedInfo.d;
    }
    int i = paramArticleInfo.mSocialFeedInfo.e;
    if (i > 0) {
      return ong.a(i, true);
    }
    return ajya.a(2131702277);
  }
  
  private void b(long paramLong)
  {
    if (this.jdField_a_of_type_Puy.a())
    {
      String str = omj.k + bbco.encodeToString(String.valueOf(paramLong).getBytes(), 2);
      onh.a(getContext(), str);
    }
    for (;;)
    {
      a(onh.c(this.jdField_a_of_type_Puy.a.a()));
      return;
      a(paramLong);
    }
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_Puy.a.a() == null) {
      return false;
    }
    puy localpuy = this.jdField_a_of_type_Puy;
    return puy.a(this.jdField_a_of_type_Puy.a.a());
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Puy.a())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    if ((this.jdField_a_of_type_Puy.i()) || (c()))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a(this.jdField_a_of_type_Puy.a.a()));
      Object localObject = this.jdField_a_of_type_Puy.a.a().mSocialFeedInfo;
      if ((localObject != null) && (!TextUtils.isEmpty(((SocializeFeedsInfo)localObject).d)))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(((SocializeFeedsInfo)localObject).d);
        return;
      }
      localObject = b(this.jdField_a_of_type_Puy.a.a());
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
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a(this.jdField_a_of_type_Puy.a.a()));
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559870, this, true);
  }
  
  public void a(long paramLong)
  {
    String str1 = omj.g + bbco.encodeToString(String.valueOf(paramLong).getBytes(), 2);
    onh.a(getContext(), str1);
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Puy.a.a();
    onh.a = localArticleInfo;
    String str2 = onh.a("1", localArticleInfo, paramLong);
    if (shu.a(this.jdField_a_of_type_Puy.a.e())) {}
    for (str1 = "0X800935C";; str1 = "0X8007BA3")
    {
      puy localpuy = this.jdField_a_of_type_Puy;
      if (!puy.a(localArticleInfo)) {
        break;
      }
      nol.a(null, String.valueOf(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Long), str1, str1, 0, 0, String.valueOf(this.jdField_a_of_type_Puy.a.a().mFeedId), "0", "" + localArticleInfo.mStrategyId, str2, false);
      ram.a(this.jdField_a_of_type_Puy.a.a(), this.jdField_a_of_type_Puy.a.e());
      return;
    }
    nol.a(null, localArticleInfo.mSubscribeID, str1, str1, 0, 0, String.valueOf(this.jdField_a_of_type_Puy.a.a().mFeedId), String.valueOf(this.jdField_a_of_type_Puy.a.a().mArticleID), "" + localArticleInfo.mStrategyId, str2, false);
  }
  
  public void a(long paramLong, Bitmap paramBitmap)
  {
    if (onh.a())
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
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131374746));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131374750));
    this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = new ReadInJoyHeadImageView[4];
    this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[0] = ((ReadInJoyHeadImageView)findViewById(2131374733));
    this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[1] = ((ReadInJoyHeadImageView)findViewById(2131374734));
    this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[2] = ((ReadInJoyHeadImageView)findViewById(2131374735));
    this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[3] = ((ReadInJoyHeadImageView)findViewById(2131374736));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)findViewById(2131374749));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374743));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374740));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374748));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363544));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView = ((RingAvatarView)findViewById(2131374706));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368697));
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof pau)) {
      a((pau)paramObject);
    }
  }
  
  public void a(pau parampau)
  {
    if (b()) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      if (b())
      {
        this.jdField_a_of_type_JavaUtilList = a();
        a(parampau, this.jdField_a_of_type_JavaUtilList);
        a(this.jdField_a_of_type_JavaUtilList);
        pym.a(this.jdField_a_of_type_Puy.a, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView, this.jdField_b_of_type_AndroidWidgetImageView);
        d();
        setFollowBotton();
      }
      return;
    }
  }
  
  public void a(pau parampau, List<Long> paramList)
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
        this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[i].setOnClickListener(new pwv(this, paramList, i));
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
  
  public void b()
  {
    super.b();
    Object localObject = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    if ((this.jdField_a_of_type_Puy.i()) || (c()))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), actj.a(15.0F, getResources()), this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight(), actj.a(12.0F, getResources()));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setPadding(this.jdField_b_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), actj.a(15.0F, getResources()), this.jdField_b_of_type_AndroidWidgetLinearLayout.getPaddingRight(), this.jdField_b_of_type_AndroidWidgetLinearLayout.getPaddingBottom());
      ((LinearLayout.LayoutParams)localObject).gravity = 48;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      localObject = (LinearLayout)findViewById(2131374745);
      if ((((LinearLayout)localObject).getLayoutParams() instanceof RelativeLayout.LayoutParams))
      {
        localObject = (RelativeLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
        if (!a()) {
          break;
        }
        ((RelativeLayout.LayoutParams)localObject).setMargins(bbll.a(12.0F), 0, bbll.a(12.0F), 0);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), actj.a(7.5F, getResources()), this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight(), actj.a(7.5F, getResources()));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setPadding(this.jdField_b_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), actj.a(7.5F, getResources()), this.jdField_b_of_type_AndroidWidgetLinearLayout.getPaddingRight(), this.jdField_b_of_type_AndroidWidgetLinearLayout.getPaddingBottom());
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    ((RelativeLayout.LayoutParams)localObject).setMargins(bbll.a(12.0F), 0, bbll.a(2.25F), 0);
  }
  
  public boolean b()
  {
    pau localpau = this.jdField_a_of_type_Puy.a;
    return (localpau.a()) && ((localpau.c() == 2) || (localpau.c() == 3));
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
    case 2131374749: 
      do
      {
        return;
        paramView = a();
      } while ((paramView == null) || (paramView.size() != 1));
      b(((Long)paramView.get(0)).longValue());
      return;
    }
    AppRuntime localAppRuntime = onh.a();
    ArticleInfo localArticleInfo;
    if (localAppRuntime != null)
    {
      localArticleInfo = this.jdField_a_of_type_Puy.a.a();
      if (!shu.a(this.jdField_a_of_type_Puy.a.e())) {
        break label241;
      }
    }
    label241:
    for (paramView = "0X800941D";; paramView = "0X80080EC")
    {
      ram.a(localArticleInfo, paramView, paramView, this.jdField_a_of_type_Puy.a.e());
      osg.b(localArticleInfo);
      if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null))
      {
        long l = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long;
        osg.a().a().a(localAppRuntime.getAccount(), String.valueOf(l), true, new pww(this, localArticleInfo));
      }
      c();
      return;
    }
  }
  
  public void setFollowBotton()
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Puy.a.a();
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
      this.jdField_a_of_type_AndroidWidgetButton.setText(ajya.a(2131702306));
      return;
    }
    if ((localArticleInfo.isNeedShowBtnWhenFollowed) && (localSocializeFeedsInfo.h == 2))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(ajya.a(2131702342));
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