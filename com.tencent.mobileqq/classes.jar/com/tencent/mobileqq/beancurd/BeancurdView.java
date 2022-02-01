package com.tencent.mobileqq.beancurd;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.MessageForBeancurd;
import com.tencent.mobileqq.data.MessageForBeancurd.Content;
import com.tencent.mobileqq.richstatus.sign.BoxShadowLayout;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public abstract class BeancurdView
  implements View.OnClickListener
{
  protected View a = a(paramContext);
  protected Context b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected MessageForBeancurd g;
  protected BoxShadowLayout h;
  protected BeancurdView.OnClickBeancurdListener i;
  
  public BeancurdView(Context paramContext, View paramView)
  {
    this.b = paramContext;
    b(paramContext);
    a();
    this.h = a(paramView, this.a);
    this.h.setOnClickListener(this);
  }
  
  public static BeancurdView a(Context paramContext, View paramView, int paramInt)
  {
    if (paramInt == 1) {
      return new ImageBeancurdView(paramContext, paramView);
    }
    if (paramInt == 2) {
      return new TextBeancurdView(paramContext, paramView);
    }
    if (paramInt == 3) {
      return new SystemNoticeBeancurdView(paramContext, paramView);
    }
    return null;
  }
  
  private void a()
  {
    this.a.setBackgroundResource(2130846358);
  }
  
  protected abstract View a(Context paramContext);
  
  public abstract View a(MessageForBeancurd paramMessageForBeancurd);
  
  protected URLDrawable a(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(this.b.getResources().getColor(2131168376));
    localURLDrawableOptions.mLoadingDrawable = localGradientDrawable;
    localURLDrawableOptions.mFailedDrawable = localGradientDrawable;
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
  
  protected BoxShadowLayout a(View paramView1, View paramView2)
  {
    int j = ViewUtils.dpToPx(123.0F);
    Object localObject = paramView1;
    if (paramView1 == null)
    {
      localObject = new BoxShadowLayout(this.b);
      ((View)localObject).setLayoutParams(new ViewGroup.MarginLayoutParams(-1, j));
    }
    paramView1 = (BoxShadowLayout)localObject;
    paramView1.a(paramView2, this.e, this.c, this.d);
    j = (int)(ScreenUtil.getInstantScreenWidth(this.b) * 0.14F);
    if (QLog.isColorLevel())
    {
      paramView2 = new StringBuilder();
      paramView2.append("beancurdview left margin is ");
      paramView2.append(j);
      QLog.i("BeancurdView", 2, paramView2.toString());
    }
    paramView1.a(j);
    return paramView1;
  }
  
  protected void a(TextView paramTextView, MessageForBeancurd.Content paramContent)
  {
    if (paramContent == null)
    {
      QLog.d("BeancurdView", 1, "updateTitle err: titleContent is null");
      return;
    }
    paramTextView.setText(paramContent.detail);
    int j = this.b.getResources().getColor(2131165564);
    try
    {
      int k = Color.parseColor(paramContent.color);
      j = k;
    }
    catch (IllegalArgumentException paramContent)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateTitle parse color err: ");
      localStringBuilder.append(paramContent);
      QLog.d("BeancurdView", 1, localStringBuilder.toString());
    }
    paramTextView.setTextColor(j);
  }
  
  protected void a(TextView paramTextView, List<MessageForBeancurd.Content> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageForBeancurd.Content localContent = (MessageForBeancurd.Content)paramList.next();
        int j = this.f;
        try
        {
          int k = Color.parseColor(localContent.color);
          j = k;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          QLog.d("BeancurdView", 2, "updateDetailIfNeed parse color err: ", localIllegalArgumentException);
        }
        localSpannableStringBuilder.append(localContent.detail, new ForegroundColorSpan(j), 33);
      }
      paramTextView.setText(localSpannableStringBuilder);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("BeancurdView", 2, "update content failed, contentList is null");
    }
  }
  
  protected void a(AppInterface paramAppInterface, ImageView paramImageView, String paramString)
  {
    paramImageView.setImageDrawable(FaceDrawable.getFaceDrawable(paramAppInterface, 1, paramString));
  }
  
  public void a(BeancurdView.OnClickBeancurdListener paramOnClickBeancurdListener)
  {
    this.i = paramOnClickBeancurdListener;
  }
  
  protected void b(Context paramContext)
  {
    this.c = ViewUtils.dpToPx(16.0F);
    this.d = paramContext.getResources().getColor(2131167339);
    this.e = ViewUtils.dpToPx(16.0F);
    this.f = paramContext.getResources().getColor(2131165564);
  }
  
  public void onClick(View paramView)
  {
    BeancurdView.OnClickBeancurdListener localOnClickBeancurdListener = this.i;
    if (localOnClickBeancurdListener == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BeancurdView", 2, "not set mOnClickBeancurdListener");
      }
    }
    else {
      localOnClickBeancurdListener.a(this.g);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.beancurd.BeancurdView
 * JD-Core Version:    0.7.0.1
 */