package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import ajya;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import aykk;
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
import oky;
import pau;
import pwx;
import pwy;
import pwz;
import pxa;
import qcg;
import qci;

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
      paramArticleInfo.add(Long.valueOf(((qci)((Iterator)localObject).next()).jdField_a_of_type_Long));
    }
    return paramArticleInfo;
  }
  
  private void b(pau parampau)
  {
    parampau = parampau.a();
    if (parampau == null)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      return;
    }
    List localList = a(parampau);
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
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new pwx(this, parampau));
  }
  
  private void c(pau parampau)
  {
    ArticleInfo localArticleInfo = parampau.a();
    if ((localArticleInfo == null) || (localArticleInfo.mSocialFeedInfo == null))
    {
      this.b.setVisibility(8);
      return;
    }
    parampau = localArticleInfo.mSocialFeedInfo;
    if ((parampau.jdField_a_of_type_Qcg != null) && (parampau.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList != null) && (parampau.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList.size() > 0) && ((parampau.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList.size() != 1) || ((!TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)parampau.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString)) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)parampau.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString, ":")) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)parampau.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString, "：")))))
    {
      this.b.setVisibility(0);
      List localList = parampau.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList;
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
        parampau = ((String)localObject1).substring(1);
        localStringBuilder.append(parampau);
        j = localStringBuilder.length();
        i -= 2;
        if (i < 0) {
          break label485;
        }
        localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localList.get(i);
        l = localBiuCommentInfo.jdField_a_of_type_JavaLangLong.longValue();
        parampau = ReadInJoyUserInfoModule.a(l, null);
        if (parampau == null) {
          break label468;
        }
        parampau = parampau.nick;
        label320:
        localObject1 = "@" + parampau;
        parampau = (pau)localObject1;
        if (localBiuCommentInfo.c == 1) {
          parampau = (String)localObject1 + " ";
        }
        if (localBiuCommentInfo.jdField_a_of_type_JavaLangString != null) {
          break label475;
        }
      }
      label468:
      label475:
      for (localObject1 = "";; localObject1 = localBiuCommentInfo.jdField_a_of_type_JavaLangString)
      {
        localStringBuilder.append(parampau).append((String)localObject1);
        localObject1 = new pxa();
        ((pxa)localObject1).jdField_a_of_type_Int = j;
        ((pxa)localObject1).b = (parampau.length() + j);
        ((pxa)localObject1).jdField_a_of_type_Long = l;
        ((List)localObject2).add(localObject1);
        j = localStringBuilder.length();
        i -= 1;
        break label277;
        parampau = (pau)localObject1;
        if (localObject1 != null) {
          break;
        }
        parampau = "";
        break;
        parampau = ReadInJoyUserInfoModule.a();
        break label320;
      }
      label485:
      parampau = new SpannableStringBuilder(new aykk(localStringBuilder, 7, 16));
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (pxa)((Iterator)localObject1).next();
        parampau.setSpan(new pwz(this, ((pxa)localObject2).jdField_a_of_type_Long, -3355444), ((pxa)localObject2).jdField_a_of_type_Int, ((pxa)localObject2).b, 17);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText(ajya.a(2131702278));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new pwy(this, localArticleInfo, -3355444));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(parampau);
      return;
    }
    if (!TextUtils.isEmpty(parampau.jdField_a_of_type_JavaLangString))
    {
      this.b.setVisibility(0);
      if (parampau.jdField_a_of_type_JavaLangString.length() >= 100) {
        parampau.jdField_a_of_type_JavaLangString = (parampau.jdField_a_of_type_JavaLangString.substring(0, 99) + '…');
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(parampau.jdField_a_of_type_JavaLangString);
      return;
    }
    this.b.setVisibility(8);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559871, this, true);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370766);
    oky.a(this.jdField_a_of_type_AndroidViewView, getResources().getDrawable(2130841262));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370768));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370767));
    this.b = findViewById(2131370763);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131370764));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpannableFactory(aykk.a);
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
      if ((paramObject instanceof pau))
      {
        paramObject = (pau)paramObject;
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setTextColor(getContext().getResources().getColor(2131165275));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderNewSocial
 * JD-Core Version:    0.7.0.1
 */