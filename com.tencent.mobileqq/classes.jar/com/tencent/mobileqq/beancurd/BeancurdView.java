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
  protected int a;
  protected Context a;
  protected View a;
  protected BeancurdView.OnClickBeancurdListener a;
  protected MessageForBeancurd a;
  protected BoxShadowLayout a;
  protected int b;
  protected int c;
  protected int d;
  
  public BeancurdView(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = a(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext);
    a();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout = a(paramView, this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.setOnClickListener(this);
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
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130844924);
  }
  
  protected abstract View a(Context paramContext);
  
  public abstract View a(MessageForBeancurd paramMessageForBeancurd);
  
  protected URLDrawable a(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167333));
    localURLDrawableOptions.mLoadingDrawable = localGradientDrawable;
    localURLDrawableOptions.mFailedDrawable = localGradientDrawable;
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
  
  protected BoxShadowLayout a(View paramView1, View paramView2)
  {
    int i = ViewUtils.b(123.0F);
    Object localObject = paramView1;
    if (paramView1 == null)
    {
      localObject = new BoxShadowLayout(this.jdField_a_of_type_AndroidContentContext);
      ((View)localObject).setLayoutParams(new ViewGroup.MarginLayoutParams(-1, i));
    }
    paramView1 = (BoxShadowLayout)localObject;
    paramView1.a(paramView2, this.c, this.jdField_a_of_type_Int, this.b);
    i = (int)(ScreenUtil.getInstantScreenWidth(this.jdField_a_of_type_AndroidContentContext) * 0.14F);
    if (QLog.isColorLevel())
    {
      paramView2 = new StringBuilder();
      paramView2.append("beancurdview left margin is ");
      paramView2.append(i);
      QLog.i("BeancurdView", 2, paramView2.toString());
    }
    paramView1.a(i);
    return paramView1;
  }
  
  protected void a(Context paramContext)
  {
    this.jdField_a_of_type_Int = ViewUtils.b(16.0F);
    this.b = paramContext.getResources().getColor(2131166497);
    this.c = ViewUtils.b(16.0F);
    this.d = paramContext.getResources().getColor(2131165327);
  }
  
  protected void a(TextView paramTextView, MessageForBeancurd.Content paramContent)
  {
    if (paramContent == null)
    {
      QLog.d("BeancurdView", 1, "updateTitle err: titleContent is null");
      return;
    }
    paramTextView.setText(paramContent.detail);
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165327);
    try
    {
      int j = Color.parseColor(paramContent.color);
      i = j;
    }
    catch (IllegalArgumentException paramContent)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateTitle parse color err: ");
      localStringBuilder.append(paramContent);
      QLog.d("BeancurdView", 1, localStringBuilder.toString());
    }
    paramTextView.setTextColor(i);
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
        int i = this.d;
        try
        {
          int j = Color.parseColor(localContent.color);
          i = j;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          QLog.d("BeancurdView", 2, "updateDetailIfNeed parse color err: ", localIllegalArgumentException);
        }
        localSpannableStringBuilder.append(localContent.detail, new ForegroundColorSpan(i), 33);
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
    this.jdField_a_of_type_ComTencentMobileqqBeancurdBeancurdView$OnClickBeancurdListener = paramOnClickBeancurdListener;
  }
  
  public void onClick(View paramView)
  {
    BeancurdView.OnClickBeancurdListener localOnClickBeancurdListener = this.jdField_a_of_type_ComTencentMobileqqBeancurdBeancurdView$OnClickBeancurdListener;
    if (localOnClickBeancurdListener == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BeancurdView", 2, "not set mOnClickBeancurdListener");
      }
    }
    else {
      localOnClickBeancurdListener.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForBeancurd);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.beancurd.BeancurdView
 * JD-Core Version:    0.7.0.1
 */