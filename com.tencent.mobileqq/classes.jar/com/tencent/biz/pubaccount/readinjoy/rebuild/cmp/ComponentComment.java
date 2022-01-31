package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import babh;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import java.util.List;
import obz;
import opw;
import pey;
import pfh;
import pjg;
import pjm;
import pjn;
import qoe;
import tencent.im.oidb.articlesummary.articlesummary.CommentInfo;

public class ComponentComment
  extends FrameLayout
  implements pey
{
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  pjg jdField_a_of_type_Pjg;
  TextView b;
  
  public ComponentComment(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentComment(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentComment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
    paramContext = LayoutInflater.from(paramContext).inflate(2131494230, this, true);
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131298918);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131298957));
    this.b = ((TextView)paramContext.findViewById(2131298955));
  }
  
  public void a(Object paramObject)
  {
    int i;
    ArticleInfo localArticleInfo;
    long l;
    String str2;
    String str1;
    if ((paramObject instanceof opw))
    {
      this.jdField_a_of_type_Pjg.a((opw)paramObject);
      b();
      if (!this.jdField_a_of_type_Pjg.a.d()) {
        break label313;
      }
      i = 0;
      setVisibility(i);
      if (this.jdField_a_of_type_Pjg.a.d())
      {
        localArticleInfo = this.jdField_a_of_type_Pjg.a.a();
        paramObject = (articlesummary.CommentInfo)localArticleInfo.mCommentsObj.get(0);
        l = paramObject.uint64_uin.get();
        str2 = paramObject.str_content.get();
        str1 = paramObject.str_jump_url.get();
        if (!obz.a()) {
          break label319;
        }
        paramObject = babh.j((QQAppInterface)obz.a(), String.valueOf(l));
        label134:
        String str3 = obz.d(paramObject);
        if (str3 == null) {
          break label339;
        }
        paramObject = new SpannableString(str3 + ":  " + str2);
        paramObject.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(getContext().getResources().getColor(2131101491)), 0, str3.length(), 33);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str3 + ":  ");
      }
    }
    for (;;)
    {
      this.b.setText(paramObject);
      this.b.setOnClickListener(new pjm(this, str1, localArticleInfo));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new pjn(this, l, localArticleInfo));
      if (!this.jdField_a_of_type_Pjg.a.f()) {
        break label361;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
      label313:
      i = 8;
      break;
      label319:
      paramObject = this.jdField_a_of_type_Pjg.a.a().b(l);
      break label134;
      label339:
      paramObject = new SpannableString(str2);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    label361:
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(pfh parampfh)
  {
    this.jdField_a_of_type_Pjg.a(parampfh);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentComment
 * JD-Core Version:    0.7.0.1
 */