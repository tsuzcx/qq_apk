package com.tencent.mobileqq.beancurd;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.data.MessageForBeancurd;
import com.tencent.mobileqq.gamecenter.ui.CornerImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;

public class TextBeancurdView
  extends BeancurdView
{
  private CornerImageView j;
  private TextView k;
  private TextView l;
  private ImageView m;
  private ImageView n;
  private final String o = "#F1F2F8";
  private ColorDrawable p;
  
  public TextBeancurdView(Context paramContext, View paramView)
  {
    super(paramContext, paramView);
    a();
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.j.setVisibility(8);
      return;
    }
    if (!d(paramString)) {
      c(paramString);
    }
  }
  
  private void c(String paramString)
  {
    try
    {
      int i = Color.parseColor(paramString);
      paramString = new GradientDrawable();
      paramString.setColor(i);
      paramString.setCornerRadius(this.c);
      this.a.setBackgroundDrawable(paramString);
      return;
    }
    catch (IllegalArgumentException paramString)
    {
      QLog.d("TextBeancurdView", 1, "updateBackgroundIfNeed err: ", paramString);
    }
  }
  
  private boolean d(String paramString)
  {
    if (!URLUtil.isHttpsUrl(paramString))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("background is not web url : ");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("TextBeancurdView", 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = this.p;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    paramString = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
    this.j.setImageDrawable(paramString);
    this.j.setRadius(this.c);
    this.j.setVisibility(0);
    return true;
  }
  
  private void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = a(paramString);
    this.n.setImageDrawable(paramString);
  }
  
  protected View a(Context paramContext)
  {
    return View.inflate(paramContext, 2131627328, null);
  }
  
  public View a(MessageForBeancurd paramMessageForBeancurd)
  {
    this.g = paramMessageForBeancurd;
    b(paramMessageForBeancurd);
    return this.h;
  }
  
  protected void a()
  {
    this.j = ((CornerImageView)this.a.findViewById(2131436334));
    this.k = ((TextView)this.a.findViewById(2131448297));
    this.l = ((TextView)this.a.findViewById(2131448296));
    this.m = ((ImageView)this.a.findViewById(2131436403));
    this.n = ((ImageView)this.a.findViewById(2131436299));
  }
  
  protected void b(Context paramContext)
  {
    super.b(paramContext);
    this.p = new ColorDrawable(Color.parseColor("#F1F2F8"));
  }
  
  protected void b(MessageForBeancurd paramMessageForBeancurd)
  {
    a((BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null), this.m, (String)paramMessageForBeancurd.getUinList().get(0));
    a(this.k, paramMessageForBeancurd.getDescription());
    a(this.l, paramMessageForBeancurd.getContentList());
    e(paramMessageForBeancurd.getIcon());
    b(paramMessageForBeancurd.getBackground());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.beancurd.TextBeancurdView
 * JD-Core Version:    0.7.0.1
 */