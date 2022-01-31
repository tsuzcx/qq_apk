package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import ajyc;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import axas;
import ayki;
import bbca;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.RingAvatarView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import noo;
import omm;
import onj;
import onk;
import osj;
import osm;
import osp;
import pax;
import pbx;
import pvb;
import pxd;
import pxu;
import pxv;
import pxw;
import pxx;
import pxy;
import pyp;
import qcj;
import qcl;
import qdd;
import qdf;
import rap;
import shx;

public class ComponentHeaderUgc
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  public Button a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoyHeadImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
  public ReadInJoyNickNameTextView a;
  public ReadInJoyYAFolderTextView a;
  RingAvatarView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView;
  protected osp a;
  public boolean a;
  private ImageView b;
  
  public ComponentHeaderUgc(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Osp = new pxx(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public ComponentHeaderUgc(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Osp = new pxx(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(paramLong);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Pvb.a.a();
    if (localArticleInfo == null) {
      this.b.setVisibility(8);
    }
    while ((localArticleInfo.mSocialFeedInfo == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcl == null)) {
      return;
    }
    if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcl.jdField_a_of_type_Int == 1)
    {
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }
  
  private void b(long paramLong)
  {
    if ((this.jdField_a_of_type_Pvb.a != null) && (this.jdField_a_of_type_Pvb.a.a() != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(paramLong, true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(this);
    }
  }
  
  private void c(long paramLong)
  {
    if ((this.jdField_a_of_type_Pvb.a == null) || (this.jdField_a_of_type_Pvb.a.a() == null) || (this.jdField_a_of_type_Pvb.a.a().mSocialFeedInfo == null) || (this.jdField_a_of_type_Pvb.a.a().mSocialFeedInfo.jdField_a_of_type_Qdd == null)) {
      return;
    }
    String str1 = omm.g + bbca.encodeToString(String.valueOf(paramLong).getBytes(), 2);
    onk.a(getContext(), str1);
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderUgc", 2, "personal url =" + str1);
    }
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Pvb.a.a();
    onk.a = localArticleInfo;
    String str2 = onk.a("3", localArticleInfo, paramLong);
    if (shx.a(this.jdField_a_of_type_Pvb.a.e())) {}
    for (str1 = "0X800935C";; str1 = "0X8007BA3")
    {
      noo.a(null, String.valueOf(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcl.jdField_a_of_type_Long), str1, str1, 0, 0, String.valueOf(this.jdField_a_of_type_Pvb.a.a().mFeedId), "0", "" + localArticleInfo.mStrategyId, str2, false);
      rap.a(localArticleInfo, this.jdField_a_of_type_Pvb.a.e());
      return;
    }
  }
  
  private void d()
  {
    ArticleInfo localArticleInfo;
    if ((this.jdField_a_of_type_Pvb.a != null) && (this.jdField_a_of_type_Pvb.a.a() != null) && (this.jdField_a_of_type_Pvb.a.a().mSocialFeedInfo != null))
    {
      localArticleInfo = this.jdField_a_of_type_Pvb.a.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new pxu(this, localArticleInfo));
      if (!onk.c(localArticleInfo)) {
        break label130;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setVisibility(8);
    }
    while (!TextUtils.isEmpty(localArticleInfo.mSocialFeedInfo.d))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localArticleInfo.mSocialFeedInfo.d);
      return;
      label130:
      if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd != null)
      {
        Object localObject2 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd;
        if ((pvb.c(localArticleInfo)) && (!rap.q(localArticleInfo)))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(((qdf)localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd.b.get(0)).e);
        }
        else
        {
          Object localObject1;
          if (onk.a((qdd)localObject2))
          {
            List localList = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd.jdField_a_of_type_Qcj.a;
            StringBuilder localStringBuilder = new StringBuilder();
            Object localObject3 = new ArrayList();
            int i = localList.size();
            localObject2 = ((SocializeFeedsInfo.BiuCommentInfo)localList.get(i - 1)).jdField_a_of_type_JavaLangString;
            int j;
            label322:
            SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo;
            long l;
            if ((!TextUtils.isEmpty((CharSequence)localObject2)) && ((((String)localObject2).startsWith(":")) || (((String)localObject2).startsWith("："))))
            {
              localObject1 = ((String)localObject2).substring(1);
              localStringBuilder.append((String)localObject1);
              j = localStringBuilder.length();
              i -= 2;
              if (i < 0) {
                break label541;
              }
              localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localList.get(i);
              l = localBiuCommentInfo.jdField_a_of_type_JavaLangLong.longValue();
              localObject1 = ReadInJoyUserInfoModule.a(l, null);
              if (localObject1 == null) {
                break label523;
              }
              localObject1 = ((ReadInJoyUserInfo)localObject1).nick;
              label367:
              localObject2 = "@" + (String)localObject1;
              localObject1 = localObject2;
              if (localBiuCommentInfo.c == 1) {
                localObject1 = (String)localObject2 + " ";
              }
              if (localBiuCommentInfo.jdField_a_of_type_JavaLangString != null) {
                break label531;
              }
            }
            label523:
            label531:
            for (localObject2 = "";; localObject2 = localBiuCommentInfo.jdField_a_of_type_JavaLangString)
            {
              localStringBuilder.append((String)localObject1).append((String)localObject2);
              localObject2 = new pxd();
              ((pxd)localObject2).jdField_a_of_type_Int = j;
              ((pxd)localObject2).b = (((String)localObject1).length() + j);
              ((pxd)localObject2).jdField_a_of_type_Long = l;
              ((List)localObject3).add(localObject2);
              j = localStringBuilder.length();
              i -= 1;
              break label322;
              localObject1 = localObject2;
              if (localObject2 != null) {
                break;
              }
              localObject1 = "";
              break;
              localObject1 = ReadInJoyUserInfoModule.a();
              break label367;
            }
            label541:
            localObject1 = new SpannableStringBuilder(new ayki(localStringBuilder, 7, 16));
            localObject2 = ((List)localObject3).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (pxd)((Iterator)localObject2).next();
              ((SpannableStringBuilder)localObject1).setSpan(new pxy(this, ((pxd)localObject3).jdField_a_of_type_Long, -3355444), ((pxd)localObject3).jdField_a_of_type_Int, ((pxd)localObject3).b, 17);
            }
            if (localArticleInfo.mSocialFeedInfo.j == 1) {}
            for (i = 1;; i = 0)
            {
              if ((!this.jdField_a_of_type_Boolean) || (i != 0)) {
                break label756;
              }
              localObject2 = ajyc.a(2131702292);
              ((SpannableStringBuilder)localObject1).append(" ");
              ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2);
              ((SpannableStringBuilder)localObject1).setSpan(new pxv(this, localArticleInfo), ((SpannableStringBuilder)localObject1).length() - ((String)localObject2).length(), ((SpannableStringBuilder)localObject1).length(), 33);
              ((SpannableStringBuilder)localObject1).append(" ");
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.c = true;
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText((String)localObject2);
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText((CharSequence)localObject1);
              break;
            }
            label756:
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText((CharSequence)localObject1);
          }
          else
          {
            if (!TextUtils.isEmpty(((qdd)localObject2).jdField_a_of_type_JavaLangString))
            {
              localObject1 = null;
              try
              {
                localObject2 = axas.b(((qdd)localObject2).jdField_a_of_type_JavaLangString);
                localObject1 = localObject2;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  QLog.d("ComponentHeaderUgc", 1, "parse bytes_comments failed ", localException);
                }
              }
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(new ayki((CharSequence)localObject1, 7, 16));
              continue;
            }
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setVisibility(8);
          }
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setVisibility(8);
      }
    }
    if (localArticleInfo.mTime > 0L)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(onj.a(localArticleInfo.mSocialFeedInfo.e, true));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ajyc.a(2131702300));
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559877, this, true);
  }
  
  public void a(long paramLong, Bitmap paramBitmap)
  {
    if ((onk.a()) && (this.jdField_a_of_type_Pvb.a() == paramLong)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)findViewById(2131362939));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)findViewById(2131370832));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377263));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131365043));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363545));
    this.b = ((ImageView)findViewById(2131374741));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView = ((RingAvatarView)findViewById(2131374704));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368698));
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof pax)) {
      a((pax)paramObject);
    }
  }
  
  public void a(pax parampax)
  {
    long l = this.jdField_a_of_type_Pvb.a();
    a(l);
    b(l);
    pyp.a(this.jdField_a_of_type_Pvb.a, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView, this.jdField_a_of_type_AndroidWidgetImageView);
    d();
    setFollowButton();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    osm.a().a(this.jdField_a_of_type_Osp);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131362939: 
    case 2131370832: 
      c(this.jdField_a_of_type_Pvb.a());
      return;
    }
    AppRuntime localAppRuntime = onk.a();
    ArticleInfo localArticleInfo;
    if (localAppRuntime != null)
    {
      localArticleInfo = this.jdField_a_of_type_Pvb.a.a();
      if (localArticleInfo != null) {
        if (!shx.a(localArticleInfo.mChannelID)) {
          break label169;
        }
      }
    }
    label169:
    for (paramView = "0X800941D";; paramView = "0X80080EC")
    {
      rap.a(localArticleInfo, paramView, paramView, (int)localArticleInfo.mChannelID);
      osj.b(localArticleInfo);
      if (localArticleInfo.mSocialFeedInfo != null)
      {
        long l = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcl.jdField_a_of_type_Long;
        osj.a().a().a(localAppRuntime.getAccount(), String.valueOf(l), true, new pxw(this, localArticleInfo));
      }
      c();
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    osm.a().b(this.jdField_a_of_type_Osp);
  }
  
  public void setFollowButton()
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Pvb.a.a();
    if (localArticleInfo == null)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
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
      this.jdField_a_of_type_AndroidWidgetButton.setText(ajyc.a(2131702335));
      return;
    }
    if ((localArticleInfo.isNeedShowBtnWhenFollowed) && (localSocializeFeedsInfo.h == 2))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(ajyc.a(2131702326));
      this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(false);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderUgc
 * JD-Core Version:    0.7.0.1
 */