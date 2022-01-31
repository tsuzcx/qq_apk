package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import ajjy;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import babh;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import obz;
import opw;
import pey;
import pfh;
import pjg;
import pjj;
import pjk;
import pjl;
import pqz;
import prv;
import qoe;

public class ComponentAccountSummary
  extends FrameLayout
  implements pey
{
  ReadInJoyYAFolderTextView a;
  public pjg a;
  public boolean a;
  public boolean b;
  public boolean c;
  
  public ComponentAccountSummary(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentAccountSummary(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentAccountSummary(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Pjg = new pjg();
    a(paramContext);
    a();
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131494312, this, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131299030));
  }
  
  public void a(Object paramObject)
  {
    opw localopw;
    if ((paramObject instanceof opw))
    {
      localopw = (opw)paramObject;
      this.jdField_a_of_type_Pjg.a(localopw);
      if (localopw.a() != null) {}
    }
    else
    {
      return;
    }
    String str = localopw.a().mSubscribeName;
    paramObject = localopw.a().mSummary;
    if ((this.jdField_a_of_type_Pjg.c()) || (this.jdField_a_of_type_Pjg.g())) {
      paramObject = localopw.a().mTitle;
    }
    if (TextUtils.isEmpty(paramObject)) {
      if (localopw.a() == 33) {
        paramObject = ajjy.a(2131636534);
      }
    }
    for (;;)
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      Object localObject;
      if ((localopw.a() == 33) && (localopw.a().mSocialFeedInfo != null) && (localopw.a().mSocialFeedInfo.jdField_a_of_type_Prv != null)) {
        if (localopw.a().mSocialFeedInfo.jdField_a_of_type_Prv.b == 0L)
        {
          localObject = localopw.a().mSocialFeedInfo.jdField_a_of_type_Prv.a;
          label199:
          localSpannableStringBuilder.append(str);
          localSpannableStringBuilder.setSpan(new pjl(this, (String)localObject, -3355444), 0, str.length(), 33);
          label229:
          localSpannableStringBuilder.append(": ");
          localObject = localopw.a();
          if ((!this.jdField_a_of_type_Boolean) && (!this.b)) {
            break label774;
          }
          paramObject = new SpannableStringBuilder();
          if ((((ArticleInfo)localObject).mSocialFeedInfo == null) || (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Pqz == null) || (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Pqz.a == null)) {
            break label755;
          }
          paramObject.append(((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Pqz.a);
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.ui", 2, "Comment String: " + ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Pqz.a);
          }
          label352:
          str = ajjy.a(2131636496);
          paramObject.append(" ");
          paramObject.append(str);
          paramObject.setSpan(new pjk((ArticleInfo)localObject, -3355444, getContext(), getResources(), this.jdField_a_of_type_Pjg), paramObject.length() - str.length(), paramObject.length(), 33);
          paramObject.append(" ");
          localSpannableStringBuilder.append(paramObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.c = true;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText(ajjy.a(2131636553));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new pjj(this, localopw.a(), -3355444));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(localSpannableStringBuilder);
        b();
        return;
        if ((this.jdField_a_of_type_Pjg.b()) || (this.jdField_a_of_type_Pjg.d()) || (this.jdField_a_of_type_Pjg.e()))
        {
          paramObject = ajjy.a(2131636537);
          break;
        }
        if ((this.jdField_a_of_type_Pjg.c()) || (this.jdField_a_of_type_Pjg.g()))
        {
          paramObject = ajjy.a(2131636514);
          break;
        }
        if (this.jdField_a_of_type_Pjg.h())
        {
          paramObject = ajjy.a(2131636525);
          break;
        }
        paramObject = ajjy.a(2131636539);
        break;
        localObject = String.valueOf(localopw.a().mSocialFeedInfo.jdField_a_of_type_Prv.b);
        if (obz.a())
        {
          str = babh.b((QQAppInterface)obz.a(), (String)localObject, true);
          break label199;
        }
        str = localopw.a().b(localopw.a().mSocialFeedInfo.jdField_a_of_type_Prv.b);
        break label199;
        if (localopw.a().mAccountLess == 0)
        {
          localObject = localopw.a().mSubscribeID;
          localSpannableStringBuilder.append(str);
          localSpannableStringBuilder.setSpan(new pjl(this, (String)localObject, -3355444), 0, str.length(), 33);
          break label229;
        }
        localSpannableStringBuilder.append(str);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, str.length(), 33);
        break label229;
        label755:
        if (((ArticleInfo)localObject).mTitle == null) {
          break label352;
        }
        paramObject.append(((ArticleInfo)localObject).mTitle);
        break label352;
        label774:
        if (this.c)
        {
          paramObject = new SpannableStringBuilder();
          if ((((ArticleInfo)localObject).mSocialFeedInfo != null) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Pqz != null) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Pqz.a != null))
          {
            paramObject.append(((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Pqz.a);
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.ui", 2, "Comment String: " + ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Pqz.a);
            }
          }
          for (;;)
          {
            localSpannableStringBuilder.append(paramObject);
            break;
            if (((ArticleInfo)localObject).mTitle != null) {
              paramObject.append(((ArticleInfo)localObject).mTitle);
            }
          }
        }
        localSpannableStringBuilder.append(paramObject);
      }
    }
  }
  
  public void a(pfh parampfh)
  {
    this.jdField_a_of_type_Pjg.a(parampfh);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentAccountSummary
 * JD-Core Version:    0.7.0.1
 */