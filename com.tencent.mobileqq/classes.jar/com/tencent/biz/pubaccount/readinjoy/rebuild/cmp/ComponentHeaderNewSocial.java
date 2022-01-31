package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import alpo;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import baig;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import opi;
import pgd;
import qdr;
import qds;
import qdt;
import qdu;
import qmc;
import qme;

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
      paramArticleInfo.add(Long.valueOf(((qme)((Iterator)localObject).next()).jdField_a_of_type_Long));
    }
    return paramArticleInfo;
  }
  
  private void b(pgd parampgd)
  {
    parampgd = parampgd.a();
    if (parampgd == null)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      return;
    }
    List localList = a(parampgd);
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
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new qdr(this, parampgd));
  }
  
  private void c(pgd parampgd)
  {
    ArticleInfo localArticleInfo = parampgd.a();
    if ((localArticleInfo == null) || (localArticleInfo.mSocialFeedInfo == null))
    {
      this.b.setVisibility(8);
      return;
    }
    parampgd = localArticleInfo.mSocialFeedInfo;
    if ((parampgd.jdField_a_of_type_Qmc != null) && (parampgd.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList != null) && (parampgd.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList.size() > 0) && ((parampgd.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList.size() != 1) || ((!TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)parampgd.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString)) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)parampgd.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString, ":")) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)parampgd.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString, "：")))))
    {
      this.b.setVisibility(0);
      List localList = parampgd.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList;
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
        parampgd = ((String)localObject1).substring(1);
        localStringBuilder.append(parampgd);
        j = localStringBuilder.length();
        i -= 2;
        if (i < 0) {
          break label485;
        }
        localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localList.get(i);
        l = localBiuCommentInfo.jdField_a_of_type_JavaLangLong.longValue();
        parampgd = ReadInJoyUserInfoModule.a(l, null);
        if (parampgd == null) {
          break label468;
        }
        parampgd = parampgd.nick;
        label320:
        localObject1 = "@" + parampgd;
        parampgd = (pgd)localObject1;
        if (localBiuCommentInfo.c == 1) {
          parampgd = (String)localObject1 + " ";
        }
        if (localBiuCommentInfo.jdField_a_of_type_JavaLangString != null) {
          break label475;
        }
      }
      label468:
      label475:
      for (localObject1 = "";; localObject1 = localBiuCommentInfo.jdField_a_of_type_JavaLangString)
      {
        localStringBuilder.append(parampgd).append((String)localObject1);
        localObject1 = new qdu();
        ((qdu)localObject1).jdField_a_of_type_Int = j;
        ((qdu)localObject1).b = (parampgd.length() + j);
        ((qdu)localObject1).jdField_a_of_type_Long = l;
        ((List)localObject2).add(localObject1);
        j = localStringBuilder.length();
        i -= 1;
        break label277;
        parampgd = (pgd)localObject1;
        if (localObject1 != null) {
          break;
        }
        parampgd = "";
        break;
        parampgd = ReadInJoyUserInfoModule.a();
        break label320;
      }
      label485:
      parampgd = new SpannableStringBuilder(new baig(localStringBuilder, 7, 16));
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (qdu)((Iterator)localObject1).next();
        parampgd.setSpan(new qdt(this, ((qdu)localObject2).jdField_a_of_type_Long, -3355444), ((qdu)localObject2).jdField_a_of_type_Int, ((qdu)localObject2).b, 17);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText(alpo.a(2131702650));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new qds(this, localArticleInfo, -3355444));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(parampgd);
      return;
    }
    if (!TextUtils.isEmpty(parampgd.jdField_a_of_type_JavaLangString))
    {
      this.b.setVisibility(0);
      if (parampgd.jdField_a_of_type_JavaLangString.length() >= 100) {
        parampgd.jdField_a_of_type_JavaLangString = (parampgd.jdField_a_of_type_JavaLangString.substring(0, 99) + '…');
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(parampgd.jdField_a_of_type_JavaLangString);
      return;
    }
    this.b.setVisibility(8);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559966, this, true);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131371077);
    opi.a(this.jdField_a_of_type_AndroidViewView, getResources().getDrawable(2130841380));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371079));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371078));
    this.b = findViewById(2131371074);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131371075));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpannableFactory(baig.a);
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
      if ((paramObject instanceof pgd))
      {
        paramObject = (pgd)paramObject;
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setTextColor(getContext().getResources().getColor(2131165307));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderNewSocial
 * JD-Core Version:    0.7.0.1
 */