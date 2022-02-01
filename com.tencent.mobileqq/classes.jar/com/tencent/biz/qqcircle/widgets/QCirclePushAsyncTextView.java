package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.LeadingMarginSpan.Standard;
import android.util.AttributeSet;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.richframework.widget.VerticalCenterImageSpan;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import feedcloud.FeedCloudMeta.StUser;
import java.util.List;

public class QCirclePushAsyncTextView
  extends RFWAsyncRichTextView
{
  private List<FeedCloudMeta.StUser> a;
  private Drawable d;
  private String e;
  private String f;
  private boolean g;
  private int h = 3;
  private QCirclePushAsyncTextView.OnClickItemListener i;
  private int j;
  
  public QCirclePushAsyncTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCirclePushAsyncTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCirclePushAsyncTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private SpannableString a(FeedCloudMeta.StUser paramStUser)
  {
    SpannableString localSpannableString = new SpannableString(paramStUser.nick.get());
    localSpannableString.setSpan(new QCirclePushAsyncTextView.PushUserNameClickableSpan(this, paramStUser, this.g, null), 0, localSpannableString.length(), 33);
    return localSpannableString;
  }
  
  private SpannableString c(String paramString)
  {
    paramString = new SpannableString(paramString);
    paramString.setSpan(new QCirclePushAsyncTextView.PushEndTextClickableSpan(this, null), 0, paramString.length(), 33);
    return paramString;
  }
  
  private SpannableString d()
  {
    SpannableString localSpannableString = new SpannableString(" ");
    localSpannableString.setSpan(new VerticalCenterImageSpan(this.d), 0, 1, 33);
    localSpannableString.setSpan(new QCirclePushAsyncTextView.PushStartImageClickableSpan(this, null), 0, 1, 33);
    return localSpannableString;
  }
  
  private SpannableString e()
  {
    try
    {
      String str = QCirclePluginUtil.d(Long.parseLong(this.e));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject = "";
    }
    Object localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new QCirclePushAsyncTextView.PushCountClickableSpan(this, null), 0, ((SpannableString)localObject).length(), 33);
    return localObject;
  }
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return;
      }
      localObject = new SpannableStringBuilder();
      if (this.d != null) {
        ((SpannableStringBuilder)localObject).append(d());
      }
      if (!TextUtils.isEmpty(this.e))
      {
        ((SpannableStringBuilder)localObject).append(" ");
        ((SpannableStringBuilder)localObject).append(e());
        ((SpannableStringBuilder)localObject).append("   ");
      }
      int k = 0;
      while (k < Math.min(this.a.size(), this.h))
      {
        ((SpannableStringBuilder)localObject).append(a((FeedCloudMeta.StUser)this.a.get(k)));
        if (k != Math.min(this.a.size(), this.h) - 1) {
          ((SpannableStringBuilder)localObject).append("、 ");
        } else {
          ((SpannableStringBuilder)localObject).append(" ");
        }
        k += 1;
      }
      if (!TextUtils.isEmpty(this.f)) {
        ((SpannableStringBuilder)localObject).append(c(this.f));
      }
      if (this.d == null) {
        ((SpannableStringBuilder)localObject).setSpan(new LeadingMarginSpan.Standard(this.j, 0), 0, ((SpannableStringBuilder)localObject).length(), 18);
      }
      setHighlightColor(getResources().getColor(2131168376));
      setText((CharSequence)localObject);
    }
  }
  
  public void setBold(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setDataList(Drawable paramDrawable, String paramString1, List<FeedCloudMeta.StUser> paramList, String paramString2, int paramInt)
  {
    this.d = paramDrawable;
    this.e = paramString1;
    this.a = paramList;
    this.f = paramString2;
    this.j = paramInt;
    a();
  }
  
  public void setDataList(List<FeedCloudMeta.StUser> paramList, String paramString)
  {
    setDataList(null, "", paramList, paramString, 0);
  }
  
  public void setMaxNum(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setOnClickItemListener(QCirclePushAsyncTextView.OnClickItemListener paramOnClickItemListener)
  {
    this.i = paramOnClickItemListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushAsyncTextView
 * JD-Core Version:    0.7.0.1
 */