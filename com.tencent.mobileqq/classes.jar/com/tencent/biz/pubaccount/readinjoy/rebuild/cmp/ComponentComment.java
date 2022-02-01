package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import java.util.List;
import pkh;
import pnn;
import prg;
import qfw;
import rbo;
import rbx;
import rfw;
import rgc;
import rgd;
import szd;
import tencent.im.oidb.articlesummary.articlesummary.CommentInfo;

public class ComponentComment
  extends FrameLayout
  implements rbo
{
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  rfw jdField_a_of_type_Rfw;
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
    this.jdField_a_of_type_Rfw = new rfw();
    a(paramContext);
    a();
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131560107, this, true);
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131364931);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131364972));
    this.b = ((TextView)paramContext.findViewById(2131364970));
  }
  
  public void a(Object paramObject)
  {
    int i;
    ArticleInfo localArticleInfo;
    long l;
    String str2;
    String str1;
    if ((paramObject instanceof qfw))
    {
      this.jdField_a_of_type_Rfw.a((qfw)paramObject);
      b();
      if (!this.jdField_a_of_type_Rfw.a.d()) {
        break label313;
      }
      i = 0;
      setVisibility(i);
      if (this.jdField_a_of_type_Rfw.a.d())
      {
        localArticleInfo = this.jdField_a_of_type_Rfw.a.a();
        paramObject = (articlesummary.CommentInfo)localArticleInfo.mCommentsObj.get(0);
        l = paramObject.uint64_uin.get();
        str2 = paramObject.str_content.get();
        str1 = paramObject.str_jump_url.get();
        if (!pnn.a()) {
          break label319;
        }
        paramObject = ContactUtils.getFriendDisplayName((QQAppInterface)pkh.a(), String.valueOf(l));
        label134:
        String str3 = prg.a(paramObject);
        if (str3 == null) {
          break label339;
        }
        paramObject = new SpannableString(str3 + ":  " + str2);
        paramObject.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(getContext().getResources().getColor(2131167296)), 0, str3.length(), 33);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str3 + ":  ");
      }
    }
    for (;;)
    {
      this.b.setText(paramObject);
      this.b.setOnClickListener(new rgc(this, str1, localArticleInfo));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new rgd(this, l, localArticleInfo));
      if (!this.jdField_a_of_type_Rfw.a.f()) {
        break label361;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
      label313:
      i = 8;
      break;
      label319:
      paramObject = this.jdField_a_of_type_Rfw.a.a().a(l);
      break label134;
      label339:
      paramObject = new SpannableString(str2);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    label361:
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(rbx paramrbx)
  {
    this.jdField_a_of_type_Rfw.a(paramrbx);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentComment
 * JD-Core Version:    0.7.0.1
 */