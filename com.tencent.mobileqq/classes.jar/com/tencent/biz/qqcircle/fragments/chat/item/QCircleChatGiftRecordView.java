package com.tencent.biz.qqcircle.fragments.chat.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;

public class QCircleChatGiftRecordView
  extends LinearLayout
{
  private ViewGroup a;
  private ImageView b;
  private TextView c;
  private String d;
  private GradientDrawable e;
  
  public QCircleChatGiftRecordView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleChatGiftRecordView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleChatGiftRecordView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.a = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131626770, this));
    this.a.setLayoutParams(new LinearLayout.LayoutParams(-2, ViewUtils.a(16.0F)));
    this.e = new GradientDrawable();
    this.e.setColor(QCircleSkinHelper.getInstance().getColor(2131167066));
    this.e.setCornerRadius(ViewUtils.a(8.5F));
    this.a.setBackgroundDrawable(this.e);
    this.b = ((ImageView)this.a.findViewById(2131436394));
    this.c = ((TextView)this.a.findViewById(2131448491));
  }
  
  public void setGiftCount(int paramInt, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("x");
    ((StringBuilder)localObject).append(paramInt);
    this.d = ((StringBuilder)localObject).toString();
    localObject = this.c;
    if (localObject != null)
    {
      RFWTypefaceUtil.a((TextView)localObject, paramBoolean);
      this.c.setText(this.d);
    }
  }
  
  public void setIconUrl(String paramString)
  {
    if (this.b != null)
    {
      Option localOption = new Option();
      localOption.setUrl(paramString).setTargetView(this.b).setLoadingDrawable(getResources().getDrawable(2130853309));
      QCircleFeedPicLoader.g().loadImage(localOption, null);
    }
  }
  
  public void setUIStyle(String paramString1, String paramString2)
  {
    try
    {
      if (this.c != null) {
        this.c.setTextColor(Color.parseColor(paramString1));
      }
      if (this.e == null) {
        break label65;
      }
      this.e.setColor(Color.parseColor(paramString2));
      return;
    }
    catch (Exception localException)
    {
      label37:
      label65:
      break label37;
    }
    QLog.e("QCircleChatGiftRecordView", 1, new Object[] { "setUIStyle numColor:", paramString1, ",backColor:", paramString2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.chat.item.QCircleChatGiftRecordView
 * JD-Core Version:    0.7.0.1
 */