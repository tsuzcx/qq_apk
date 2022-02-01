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
import anvx;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.text.QQText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pic;
import qfw;
import rhv;
import rhw;
import rhx;
import rhy;
import rqw;
import rqy;

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
      paramArticleInfo.add(Long.valueOf(((rqy)((Iterator)localObject).next()).jdField_a_of_type_Long));
    }
    return paramArticleInfo;
  }
  
  private void b(qfw paramqfw)
  {
    paramqfw = paramqfw.a();
    if (paramqfw == null)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      return;
    }
    List localList = a(paramqfw);
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
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new rhv(this, paramqfw));
  }
  
  private void c(qfw paramqfw)
  {
    ArticleInfo localArticleInfo = paramqfw.a();
    if ((localArticleInfo == null) || (localArticleInfo.mSocialFeedInfo == null))
    {
      this.b.setVisibility(8);
      return;
    }
    paramqfw = localArticleInfo.mSocialFeedInfo;
    if ((paramqfw.jdField_a_of_type_Rqw != null) && (paramqfw.jdField_a_of_type_Rqw.jdField_a_of_type_JavaUtilList != null) && (paramqfw.jdField_a_of_type_Rqw.jdField_a_of_type_JavaUtilList.size() > 0) && ((paramqfw.jdField_a_of_type_Rqw.jdField_a_of_type_JavaUtilList.size() != 1) || ((!TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)paramqfw.jdField_a_of_type_Rqw.jdField_a_of_type_JavaUtilList.get(0)).mBiuComment)) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)paramqfw.jdField_a_of_type_Rqw.jdField_a_of_type_JavaUtilList.get(0)).mBiuComment, ":")) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)paramqfw.jdField_a_of_type_Rqw.jdField_a_of_type_JavaUtilList.get(0)).mBiuComment, "：")))))
    {
      this.b.setVisibility(0);
      List localList = paramqfw.jdField_a_of_type_Rqw.jdField_a_of_type_JavaUtilList;
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
        paramqfw = ((String)localObject1).substring(1);
        localStringBuilder.append(paramqfw);
        j = localStringBuilder.length();
        i -= 2;
        if (i < 0) {
          break label485;
        }
        localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localList.get(i);
        l = localBiuCommentInfo.mUin.longValue();
        paramqfw = ReadInJoyUserInfoModule.a(l, null);
        if (paramqfw == null) {
          break label468;
        }
        paramqfw = paramqfw.nick;
        label320:
        localObject1 = "@" + paramqfw;
        paramqfw = (qfw)localObject1;
        if (localBiuCommentInfo.mOpType == 1) {
          paramqfw = (String)localObject1 + " ";
        }
        if (localBiuCommentInfo.mBiuComment != null) {
          break label475;
        }
      }
      label468:
      label475:
      for (localObject1 = "";; localObject1 = localBiuCommentInfo.mBiuComment)
      {
        localStringBuilder.append(paramqfw).append((String)localObject1);
        localObject1 = new rhw();
        ((rhw)localObject1).jdField_a_of_type_Int = j;
        ((rhw)localObject1).b = (paramqfw.length() + j);
        ((rhw)localObject1).jdField_a_of_type_Long = l;
        ((List)localObject2).add(localObject1);
        j = localStringBuilder.length();
        i -= 1;
        break label277;
        paramqfw = (qfw)localObject1;
        if (localObject1 != null) {
          break;
        }
        paramqfw = "";
        break;
        paramqfw = ReadInJoyUserInfoModule.a();
        break label320;
      }
      label485:
      paramqfw = new SpannableStringBuilder(new QQText(localStringBuilder, 7, 16));
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (rhw)((Iterator)localObject1).next();
        paramqfw.setSpan(new rhy(this, ((rhw)localObject2).jdField_a_of_type_Long, -3355444), ((rhw)localObject2).jdField_a_of_type_Int, ((rhw)localObject2).b, 17);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText(anvx.a(2131701775));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new rhx(this, localArticleInfo, -3355444));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(paramqfw);
      return;
    }
    if (!TextUtils.isEmpty(paramqfw.jdField_a_of_type_JavaLangString))
    {
      this.b.setVisibility(0);
      if (paramqfw.jdField_a_of_type_JavaLangString.length() >= 100) {
        paramqfw.jdField_a_of_type_JavaLangString = (paramqfw.jdField_a_of_type_JavaLangString.substring(0, 99) + '…');
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(paramqfw.jdField_a_of_type_JavaLangString);
      return;
    }
    this.b.setVisibility(8);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560178, this, true);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131371917);
    pic.a(this.jdField_a_of_type_AndroidViewView, getResources().getDrawable(2130841743));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371919));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371918));
    this.b = findViewById(2131371914);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131371915));
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
      if ((paramObject instanceof qfw))
      {
        paramObject = (qfw)paramObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderNewSocial
 * JD-Core Version:    0.7.0.1
 */