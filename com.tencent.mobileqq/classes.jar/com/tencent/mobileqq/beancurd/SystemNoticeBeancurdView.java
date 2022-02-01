package com.tencent.mobileqq.beancurd;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageForBeancurd;
import com.tencent.mobileqq.richstatus.sign.BoxShadowLayout;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class SystemNoticeBeancurdView
  extends BeancurdView
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private BoxShadowLayout jdField_b_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout;
  
  public SystemNoticeBeancurdView(Context paramContext, View paramView)
  {
    super(paramContext, paramView);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379930));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379544));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368056));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368072));
  }
  
  protected View a(Context paramContext)
  {
    return View.inflate(paramContext, 2131560988, null);
  }
  
  public View a(MessageForBeancurd paramMessageForBeancurd)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    a(this.jdField_a_of_type_AndroidWidgetTextView, paramMessageForBeancurd.getDescription());
    a(this.jdField_b_of_type_AndroidWidgetTextView, paramMessageForBeancurd.getContentList());
    a((BaseQQAppInterface)localAppRuntime, paramMessageForBeancurd.getUinList());
    return this.jdField_b_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout;
  }
  
  protected void a(AppInterface paramAppInterface, List<String> paramList)
  {
    a(paramAppInterface, this.jdField_b_of_type_AndroidWidgetImageView, (String)paramList.get(0));
    if (paramList.size() > 1) {
      a(paramAppInterface, this.jdField_a_of_type_AndroidWidgetImageView, (String)paramList.get(1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.beancurd.SystemNoticeBeancurdView
 * JD-Core Version:    0.7.0.1
 */