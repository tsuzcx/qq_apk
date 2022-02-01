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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.text.QQText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
  
  private List<Long> a(ArticleInfo paramArticleInfo)
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
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new ComponentHeaderNewSocial.1(this, paramIReadInJoyModel));
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
    if ((paramIReadInJoyModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo != null) && (paramIReadInJoyModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList != null) && (paramIReadInJoyModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.size() > 0) && ((paramIReadInJoyModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.size() != 1) || ((!TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)paramIReadInJoyModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.get(0)).mBiuComment)) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)paramIReadInJoyModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.get(0)).mBiuComment, ":")) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)paramIReadInJoyModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.get(0)).mBiuComment, "：")))))
    {
      this.b.setVisibility(0);
      List localList = paramIReadInJoyModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList;
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject2 = new ArrayList();
      int i = localList.size();
      Object localObject1 = ((SocializeFeedsInfo.BiuCommentInfo)localList.get(i - 1)).mBiuComment;
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
          break label485;
        }
        localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localList.get(i);
        l = localBiuCommentInfo.mUin.longValue();
        paramIReadInJoyModel = ReadInJoyUserInfoModule.a(l, null);
        if (paramIReadInJoyModel == null) {
          break label468;
        }
        paramIReadInJoyModel = paramIReadInJoyModel.nick;
        label320:
        localObject1 = "@" + paramIReadInJoyModel;
        paramIReadInJoyModel = (IReadInJoyModel)localObject1;
        if (localBiuCommentInfo.mOpType == 1) {
          paramIReadInJoyModel = (String)localObject1 + " ";
        }
        if (localBiuCommentInfo.mBiuComment != null) {
          break label475;
        }
      }
      label468:
      label475:
      for (localObject1 = "";; localObject1 = localBiuCommentInfo.mBiuComment)
      {
        localStringBuilder.append(paramIReadInJoyModel).append((String)localObject1);
        localObject1 = new ComponentHeaderNewSocial.BiuUserStruct();
        ((ComponentHeaderNewSocial.BiuUserStruct)localObject1).jdField_a_of_type_Int = j;
        ((ComponentHeaderNewSocial.BiuUserStruct)localObject1).b = (paramIReadInJoyModel.length() + j);
        ((ComponentHeaderNewSocial.BiuUserStruct)localObject1).jdField_a_of_type_Long = l;
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
        paramIReadInJoyModel = ReadInJoyUserInfoModule.a();
        break label320;
      }
      label485:
      paramIReadInJoyModel = new SpannableStringBuilder(new QQText(localStringBuilder, 7, 16));
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ComponentHeaderNewSocial.BiuUserStruct)((Iterator)localObject1).next();
        paramIReadInJoyModel.setSpan(new ComponentHeaderNewSocial.UserSpan(this, ((ComponentHeaderNewSocial.BiuUserStruct)localObject2).jdField_a_of_type_Long, -3355444), ((ComponentHeaderNewSocial.BiuUserStruct)localObject2).jdField_a_of_type_Int, ((ComponentHeaderNewSocial.BiuUserStruct)localObject2).b, 17);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText(HardCodeUtil.a(2131702330));
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
    return LayoutInflater.from(paramContext).inflate(2131560256, this, true);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131372224);
    ApiCompatibilityUtils.a(this.jdField_a_of_type_AndroidViewView, getResources().getDrawable(2130841884));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372226));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372225));
    this.b = findViewById(2131372221);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131372222));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpannableFactory(QQText.SPANNABLE_FACTORY);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setTextColor(getContext().getResources().getColor(2131165357));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderNewSocial
 * JD-Core Version:    0.7.0.1
 */