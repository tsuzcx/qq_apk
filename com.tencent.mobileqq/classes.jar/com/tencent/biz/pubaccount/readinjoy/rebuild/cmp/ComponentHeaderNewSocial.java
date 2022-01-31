package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ApiCompatibilityUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.text.QQText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lvo;

public class ComponentHeaderNewSocial
  extends ComponentHeaderFriendRecommend
{
  View jdField_a_of_type_AndroidViewView;
  ReadInJoyYAFolderTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView;
  View b;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  
  public ComponentHeaderNewSocial(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentHeaderNewSocial(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentHeaderNewSocial(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private List a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null)) {}
    do
    {
      return null;
      localObject = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
    } while ((localObject == null) || (((List)localObject).size() == 0));
    paramArticleInfo = new ArrayList();
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramArticleInfo.add(Long.valueOf(((SocializeFeedsInfo.FeedsInfoUser)((Iterator)localObject).next()).jdField_a_of_type_Long));
    }
    return paramArticleInfo;
  }
  
  private void b(IReadInJoyModel paramIReadInJoyModel)
  {
    paramIReadInJoyModel = paramIReadInJoyModel.a();
    if (paramIReadInJoyModel == null)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      return;
    }
    List localList = a(paramIReadInJoyModel);
    if ((localList == null) || (localList.size() == 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("你的其他").append(localList.size()).append("个好友也Biu了");
    this.jdField_c_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new lvo(this, paramIReadInJoyModel));
  }
  
  private void c(IReadInJoyModel paramIReadInJoyModel)
  {
    ArticleInfo localArticleInfo = paramIReadInJoyModel.a();
    if ((localArticleInfo == null) || (localArticleInfo.mSocialFeedInfo == null))
    {
      this.b.setVisibility(8);
      return;
    }
    paramIReadInJoyModel = localArticleInfo.mSocialFeedInfo;
    if ((paramIReadInJoyModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo != null) && (paramIReadInJoyModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList != null) && (paramIReadInJoyModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.size() > 0) && ((paramIReadInJoyModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.size() != 1) || ((!TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)paramIReadInJoyModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString)) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)paramIReadInJoyModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString, ":")) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)paramIReadInJoyModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString, "：")))))
    {
      this.b.setVisibility(0);
      List localList = paramIReadInJoyModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList;
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject2 = new ArrayList();
      int i = localList.size();
      Object localObject1 = ((SocializeFeedsInfo.BiuCommentInfo)localList.get(i - 1)).jdField_a_of_type_JavaLangString;
      int j;
      label277:
      SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo;
      long l;
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ((((String)localObject1).startsWith(":")) || (((String)localObject1).startsWith("："))))
      {
        paramIReadInJoyModel = ((String)localObject1).substring(1);
        localStringBuilder.append(paramIReadInJoyModel);
        j = localStringBuilder.length();
        i -= 2;
        if (i < 0) {
          break label487;
        }
        localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localList.get(i);
        l = localBiuCommentInfo.jdField_a_of_type_JavaLangLong.longValue();
        paramIReadInJoyModel = ReadInJoyUserInfoModule.a(l, null);
        if (paramIReadInJoyModel == null) {
          break label468;
        }
        paramIReadInJoyModel = paramIReadInJoyModel.nick;
        label320:
        localObject1 = "@" + paramIReadInJoyModel;
        paramIReadInJoyModel = (IReadInJoyModel)localObject1;
        if (localBiuCommentInfo.c == 1) {
          paramIReadInJoyModel = (String)localObject1 + " ";
        }
        if (localBiuCommentInfo.jdField_a_of_type_JavaLangString != null) {
          break label477;
        }
      }
      label468:
      label477:
      for (localObject1 = "";; localObject1 = localBiuCommentInfo.jdField_a_of_type_JavaLangString)
      {
        localStringBuilder.append(paramIReadInJoyModel).append((String)localObject1);
        localObject1 = new ComponentHeaderNewSocial.biuUserStruct();
        ((ComponentHeaderNewSocial.biuUserStruct)localObject1).jdField_a_of_type_Int = j;
        ((ComponentHeaderNewSocial.biuUserStruct)localObject1).b = (paramIReadInJoyModel.length() + j);
        ((ComponentHeaderNewSocial.biuUserStruct)localObject1).jdField_a_of_type_Long = l;
        ((List)localObject2).add(localObject1);
        j = localStringBuilder.length();
        i -= 1;
        break label277;
        paramIReadInJoyModel = (IReadInJoyModel)localObject1;
        if (localObject1 != null) {
          break;
        }
        paramIReadInJoyModel = "";
        break;
        paramIReadInJoyModel = String.valueOf(l);
        break label320;
      }
      label487:
      paramIReadInJoyModel = new SpannableStringBuilder(new QQText(localStringBuilder, 7, 16));
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ComponentHeaderNewSocial.biuUserStruct)((Iterator)localObject1).next();
        paramIReadInJoyModel.setSpan(new ComponentHeaderNewSocial.UserSpan(this, ((ComponentHeaderNewSocial.biuUserStruct)localObject2).jdField_a_of_type_Long, -3355444), ((ComponentHeaderNewSocial.biuUserStruct)localObject2).jdField_a_of_type_Int, ((ComponentHeaderNewSocial.biuUserStruct)localObject2).b, 17);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText("更多");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new ComponentHeaderNewSocial.MoreSpan(this, localArticleInfo, -3355444));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(paramIReadInJoyModel);
      return;
    }
    if (!TextUtils.isEmpty(paramIReadInJoyModel.jdField_a_of_type_JavaLangString))
    {
      this.b.setVisibility(0);
      if (paramIReadInJoyModel.jdField_a_of_type_JavaLangString.length() >= 100) {
        paramIReadInJoyModel.jdField_a_of_type_JavaLangString = (paramIReadInJoyModel.jdField_a_of_type_JavaLangString.substring(0, 99) + '…');
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(paramIReadInJoyModel.jdField_a_of_type_JavaLangString);
      return;
    }
    this.b.setVisibility(8);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2130969578, this, true);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367029);
    ApiCompatibilityUtils.a(this.jdField_a_of_type_AndroidViewView, getResources().getDrawable(2130839723));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367031));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367030));
    this.b = findViewById(2131367034);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131367035));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpannableFactory(QQText.a);
    this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[1].setVisibility(8);
    this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[2].setVisibility(8);
    this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[3].setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setTextSize(2, 15.5F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 16.0F);
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if (b()) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      if ((paramObject instanceof IReadInJoyModel))
      {
        paramObject = (IReadInJoyModel)paramObject;
        b(paramObject);
        c(paramObject);
      }
      return;
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void setReadedStatus(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setTextColor(getContext().getResources().getColor(2131492971));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderNewSocial
 * JD-Core Version:    0.7.0.1
 */