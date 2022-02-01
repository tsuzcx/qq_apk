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

public class GdtMvOldTitleFactory
  implements IGdtMvTitleFactory
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final String jdField_a_of_type_JavaLangString = "GdtMvOldTitleFactory";
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 > 0L)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131705313));
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append("s");
      localObject = ((StringBuilder)localObject).toString();
      GdtMvTitleUtil.a(this.jdField_a_of_type_AndroidWidgetTextView, (String)localObject, 0);
      return;
    }
    GdtMvTitleUtil.a(this.jdField_a_of_type_AndroidWidgetTextView, "", 8);
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      QLog.i("GdtMvOldTitleFactory", 1, "refreshVoiceIconDrawableInner return");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshVoiceIconDrawableInner ");
    localStringBuilder.append(paramBoolean);
    QLog.i("GdtMvOldTitleFactory", 1, localStringBuilder.toString());
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
    paramViewGroup.addView(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559194, paramViewGroup, false));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367796));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367797));
    paramGdtMvTitleHelper.jdField_a_of_type_AndroidWidgetImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    paramGdtMvTitleHelper.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramGdtMvTitleHelper);
    paramGdtMvTitleHelper.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131367795);
    paramGdtMvTitleHelper.jdField_a_of_type_AndroidViewView.setOnClickListener(paramGdtMvTitleHelper);
    if (paramGdtMvTitleHelper.b != 0) {
      paramGdtMvTitleHelper.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.title.GdtMvOldTitleFactory
 * JD-Core Version:    0.7.0.1
 */