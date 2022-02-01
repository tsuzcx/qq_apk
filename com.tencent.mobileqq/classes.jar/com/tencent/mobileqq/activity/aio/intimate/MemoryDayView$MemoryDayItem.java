package com.tencent.mobileqq.activity.aio.intimate;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageWrapper;
import com.tencent.widget.URLThemeImageView;

public class MemoryDayView$MemoryDayItem
{
  private View b = null;
  private IntimateInfo.MemoryDayInfo c = null;
  private MemoryDayView.OnItemClick d = null;
  
  public MemoryDayView$MemoryDayItem(MemoryDayView paramMemoryDayView, Context paramContext)
  {
    this.b = LayoutInflater.from(paramContext).inflate(2131625192, null);
  }
  
  public View a()
  {
    return this.b;
  }
  
  public void a(MemoryDayView.OnItemClick paramOnItemClick)
  {
    this.d = paramOnItemClick;
  }
  
  public void a(IntimateInfo.MemoryDayInfo paramMemoryDayInfo)
  {
    TextView localTextView1;
    if (paramMemoryDayInfo != null)
    {
      this.c = paramMemoryDayInfo;
      Object localObject = this.b;
      if (localObject == null) {
        return;
      }
      ((View)localObject).setTag(paramMemoryDayInfo);
      localObject = (URLThemeImageView)this.b.findViewById(2131435219);
      TextView localTextView2 = (TextView)this.b.findViewById(2131450229);
      localTextView1 = (TextView)this.b.findViewById(2131437250);
      RelativeLayout localRelativeLayout = (RelativeLayout)this.b.findViewById(2131438069);
      ImageView localImageView = (ImageView)this.b.findViewById(2131429221);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = 686;
      localURLDrawableOptions.mRequestHeight = 124;
      localURLDrawableOptions.mRetryCount = 3;
      localURLDrawableOptions.mPlayGifImage = true;
      String str = this.a.b;
      if (localObject != null)
      {
        if (((URLThemeImageView)localObject).themeImageWrapper != null) {
          ((URLThemeImageView)localObject).themeImageWrapper.setMaskShape(ThemeImageWrapper.MODE_OTHER);
        }
        if (paramMemoryDayInfo.iconUrl != null) {
          ((URLThemeImageView)localObject).setBackgroundURL(paramMemoryDayInfo.iconUrl);
        }
      }
      localObject = str;
      if (localRelativeLayout != null)
      {
        localObject = str;
        if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
          localObject = this.a.c;
        }
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (localImageView != null)) {
        localImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject, localURLDrawableOptions));
      } else {
        QLog.e("intimate_relationship", 2, " url is empty");
      }
      if ((localTextView2 != null) && (paramMemoryDayInfo.wording != null))
      {
        localTextView2.setText(paramMemoryDayInfo.wording);
        if ((localTextView1 != null) && (paramMemoryDayInfo.linkWording != null)) {
          localObject = paramMemoryDayInfo.linkWording;
        } else {
          localObject = "";
        }
        int i = AIOUtils.b(95.0F, this.a.a.getResources());
        i = MemoryDayView.a(this.a, (String)localObject, 14.0F, i + 80);
        if (i > 200) {
          localTextView2.setMaxWidth(i);
        } else {
          localTextView2.setMaxWidth(200);
        }
      }
      if ((localTextView1 != null) && (paramMemoryDayInfo.linkWording != null))
      {
        localTextView1.setText(paramMemoryDayInfo.linkWording);
        if (TextUtils.isEmpty(paramMemoryDayInfo.linkColor)) {}
      }
    }
    try
    {
      localTextView1.setTextColor(Color.parseColor(paramMemoryDayInfo.linkColor));
    }
    catch (IllegalArgumentException paramMemoryDayInfo)
    {
      label377:
      break label377;
    }
    QLog.e("intimate_relationship", 2, " color parse err");
    localTextView1.setOnClickListener(new MemoryDayView.MemoryDayItem.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.MemoryDayView.MemoryDayItem
 * JD-Core Version:    0.7.0.1
 */