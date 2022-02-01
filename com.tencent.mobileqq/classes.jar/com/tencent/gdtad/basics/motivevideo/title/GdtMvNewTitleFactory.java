package com.tencent.gdtad.basics.motivevideo.title;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;

public class GdtMvNewTitleFactory
  implements IGdtMvTitleFactory
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final String jdField_a_of_type_JavaLangString = "GdtMvNewTitleFactory";
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    String str;
    if (paramLong1 > 0L) {
      str = String.format(HardCodeUtil.a(2131692853), new Object[] { Long.valueOf(paramLong2) });
    } else {
      str = HardCodeUtil.a(2131692852);
    }
    GdtMvTitleUtil.a(this.jdField_a_of_type_AndroidWidgetTextView, str, 0);
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      QLog.i("GdtMvNewTitleFactory", 1, "refreshVoiceIconDrawableInner return");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshVoiceIconDrawableInner ");
    localStringBuilder.append(paramBoolean);
    QLog.i("GdtMvNewTitleFactory", 1, localStringBuilder.toString());
    if (paramBoolean)
    {
      paramContext = paramContext.getResources().getDrawable(2130838445);
      GdtMvTitleUtil.a(this.jdField_a_of_type_AndroidWidgetImageView, paramContext, 2131692869);
      return;
    }
    paramContext = paramContext.getResources().getDrawable(2130838446);
    GdtMvTitleUtil.a(this.jdField_a_of_type_AndroidWidgetImageView, paramContext, 2131692868);
  }
  
  public void a(ViewGroup paramViewGroup, GdtMvTitleHelper paramGdtMvTitleHelper)
  {
    paramViewGroup.addView(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559195, paramViewGroup, false));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367788));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367789));
    paramGdtMvTitleHelper.jdField_a_of_type_AndroidWidgetImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    paramGdtMvTitleHelper.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramGdtMvTitleHelper);
    paramGdtMvTitleHelper.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131367787);
    paramGdtMvTitleHelper.jdField_a_of_type_AndroidViewView.setOnClickListener(paramGdtMvTitleHelper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.title.GdtMvNewTitleFactory
 * JD-Core Version:    0.7.0.1
 */