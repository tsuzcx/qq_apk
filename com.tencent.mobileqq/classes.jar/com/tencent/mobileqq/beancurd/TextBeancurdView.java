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
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CornerImageView jdField_a_of_type_ComTencentMobileqqGamecenterUiCornerImageView;
  private final String jdField_a_of_type_JavaLangString = "#F1F2F8";
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public TextBeancurdView(Context paramContext, View paramView)
  {
    super(paramContext, paramView);
    a();
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterUiCornerImageView.setVisibility(8);
      return;
    }
    if (!a(paramString)) {
      b(paramString);
    }
  }
  
  private boolean a(String paramString)
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
    ColorDrawable localColorDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    paramString = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterUiCornerImageView.setImageDrawable(paramString);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterUiCornerImageView.setRadius(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterUiCornerImageView.setVisibility(0);
    return true;
  }
  
  private void b(String paramString)
  {
    try
    {
      int i = Color.parseColor(paramString);
      paramString = new GradientDrawable();
      paramString.setColor(i);
      paramString.setCornerRadius(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(paramString);
      return;
    }
    catch (IllegalArgumentException paramString)
    {
      QLog.d("TextBeancurdView", 1, "updateBackgroundIfNeed err: ", paramString);
    }
  }
  
  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = a(paramString);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
  }
  
  protected View a(Context paramContext)
  {
    return View.inflate(paramContext, 2131560987, null);
  }
  
  public View a(MessageForBeancurd paramMessageForBeancurd)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForBeancurd = paramMessageForBeancurd;
    a(paramMessageForBeancurd);
    return this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterUiCornerImageView = ((CornerImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369331));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379545));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379544));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369372));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369305));
  }
  
  protected void a(Context paramContext)
  {
    super.a(paramContext);
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#F1F2F8"));
  }
  
  protected void a(MessageForBeancurd paramMessageForBeancurd)
  {
    a((BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null), this.jdField_a_of_type_AndroidWidgetImageView, (String)paramMessageForBeancurd.getUinList().get(0));
    a(this.jdField_a_of_type_AndroidWidgetTextView, paramMessageForBeancurd.getDescription());
    a(this.jdField_b_of_type_AndroidWidgetTextView, paramMessageForBeancurd.getContentList());
    c(paramMessageForBeancurd.getIcon());
    a(paramMessageForBeancurd.getBackground());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.beancurd.TextBeancurdView
 * JD-Core Version:    0.7.0.1
 */