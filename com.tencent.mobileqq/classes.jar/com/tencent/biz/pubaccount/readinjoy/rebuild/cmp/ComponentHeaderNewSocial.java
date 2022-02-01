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
import anzj;
import begp;
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
import oxr;
import ppu;
import qpn;
import qpo;
import qpp;
import qpq;
import qxr;
import qxt;

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
      paramArticleInfo.add(Long.valueOf(((qxt)((Iterator)localObject).next()).jdField_a_of_type_Long));
    }
    return paramArticleInfo;
  }
  
  private void b(ppu paramppu)
  {
    paramppu = paramppu.a();
    if (paramppu == null)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      return;
    }
    List localList = a(paramppu);
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
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new qpn(this, paramppu));
  }
  
  private void c(ppu paramppu)
  {
    ArticleInfo localArticleInfo = paramppu.a();
    if ((localArticleInfo == null) || (localArticleInfo.mSocialFeedInfo == null))
    {
      this.b.setVisibility(8);
      return;
    }
    paramppu = localArticleInfo.mSocialFeedInfo;
    if ((paramppu.jdField_a_of_type_Qxr != null) && (paramppu.jdField_a_of_type_Qxr.jdField_a_of_type_JavaUtilList != null) && (paramppu.jdField_a_of_type_Qxr.jdField_a_of_type_JavaUtilList.size() > 0) && ((paramppu.jdField_a_of_type_Qxr.jdField_a_of_type_JavaUtilList.size() != 1) || ((!TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)paramppu.jdField_a_of_type_Qxr.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString)) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)paramppu.jdField_a_of_type_Qxr.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString, ":")) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)paramppu.jdField_a_of_type_Qxr.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString, "：")))))
    {
      this.b.setVisibility(0);
      List localList = paramppu.jdField_a_of_type_Qxr.jdField_a_of_type_JavaUtilList;
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
        paramppu = ((String)localObject1).substring(1);
        localStringBuilder.append(paramppu);
        j = localStringBuilder.length();
        i -= 2;
        if (i < 0) {
          break label485;
        }
        localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localList.get(i);
        l = localBiuCommentInfo.jdField_a_of_type_JavaLangLong.longValue();
        paramppu = ReadInJoyUserInfoModule.a(l, null);
        if (paramppu == null) {
          break label468;
        }
        paramppu = paramppu.nick;
        label320:
        localObject1 = "@" + paramppu;
        paramppu = (ppu)localObject1;
        if (localBiuCommentInfo.c == 1) {
          paramppu = (String)localObject1 + " ";
        }
        if (localBiuCommentInfo.jdField_a_of_type_JavaLangString != null) {
          break label475;
        }
      }
      label468:
      label475:
      for (localObject1 = "";; localObject1 = localBiuCommentInfo.jdField_a_of_type_JavaLangString)
      {
        localStringBuilder.append(paramppu).append((String)localObject1);
        localObject1 = new qpo();
        ((qpo)localObject1).jdField_a_of_type_Int = j;
        ((qpo)localObject1).b = (paramppu.length() + j);
        ((qpo)localObject1).jdField_a_of_type_Long = l;
        ((List)localObject2).add(localObject1);
        j = localStringBuilder.length();
        i -= 1;
        break label277;
        paramppu = (ppu)localObject1;
        if (localObject1 != null) {
          break;
        }
        paramppu = "";
        break;
        paramppu = ReadInJoyUserInfoModule.a();
        break label320;
      }
      label485:
      paramppu = new SpannableStringBuilder(new begp(localStringBuilder, 7, 16));
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (qpo)((Iterator)localObject1).next();
        paramppu.setSpan(new qpq(this, ((qpo)localObject2).jdField_a_of_type_Long, -3355444), ((qpo)localObject2).jdField_a_of_type_Int, ((qpo)localObject2).b, 17);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText(anzj.a(2131701189));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new qpp(this, localArticleInfo, -3355444));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(paramppu);
      return;
    }
    if (!TextUtils.isEmpty(paramppu.jdField_a_of_type_JavaLangString))
    {
      this.b.setVisibility(0);
      if (paramppu.jdField_a_of_type_JavaLangString.length() >= 100) {
        paramppu.jdField_a_of_type_JavaLangString = (paramppu.jdField_a_of_type_JavaLangString.substring(0, 99) + '…');
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(paramppu.jdField_a_of_type_JavaLangString);
      return;
    }
    this.b.setVisibility(8);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560124, this, true);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131371765);
    oxr.a(this.jdField_a_of_type_AndroidViewView, getResources().getDrawable(2130841693));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371767));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371766));
    this.b = findViewById(2131371762);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131371763));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpannableFactory(begp.a);
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
      if ((paramObject instanceof ppu))
      {
        paramObject = (ppu)paramObject;
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setTextColor(getContext().getResources().getColor(2131165343));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderNewSocial
 * JD-Core Version:    0.7.0.1
 */