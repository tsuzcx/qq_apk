import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class anhf
  extends anjj
{
  public anhf(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, anhs paramanhs, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramanhs, paramInt4);
    this.jdField_a_of_type_Anhs = paramanhs;
    this.b = true;
  }
  
  public View a(angv paramangv, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    paramViewGroup = (anhg)paramangv;
    this.a = paramViewGroup;
    int i = getItemViewType(paramInt);
    if (i == 0)
    {
      if (paramView != null) {
        break label662;
      }
      paramangv = ankg.a().a(7);
      paramView = new AbsListView.LayoutParams(-1, -2);
      if (paramangv == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemtype = " + i + ";view from inflater");
        }
        paramangv = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495904, null);
        paramangv.setLayoutParams(paramView);
        paramangv.setPadding(0, (int)(10.0F * this.jdField_a_of_type_Float), 0, 0);
        a(7, paramangv);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramangv.findViewById(2131299236));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramangv.findViewById(2131299320));
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton = ((ProgressButton)paramangv.findViewById(2131299318));
        paramangv.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      a(paramViewGroup);
      paramView = paramangv;
      return paramView;
      if (QLog.isColorLevel()) {
        QLog.d("BigEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemtype = " + i + ";view from cache");
      }
      break;
      if (paramView == null)
      {
        paramView = ankg.a().a(6);
        if (paramView == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("BigEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemtype = " + i + ";view from inflater");
          }
          paramView = new EmoticonPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext);
          paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
          paramView.setOrientation(0);
          if (paramInt == 1) {
            paramView.setPadding(0, (int)(16.0F * this.jdField_a_of_type_Float), 0, 0);
          }
          for (;;)
          {
            i = 0;
            for (;;)
            {
              paramangv = paramView;
              if (i >= this.jdField_a_of_type_Int) {
                break;
              }
              paramangv = super.a();
              paramangv.setVisibility(8);
              paramView.addView(paramangv);
              i += 1;
            }
            paramView.setPadding(0, (int)(14.0F * this.jdField_a_of_type_Float), 0, 0);
          }
        }
        paramangv = paramView;
        if (QLog.isColorLevel())
        {
          QLog.d("BigEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemtype = " + i + ";view from cache");
          paramangv = paramView;
        }
        ((EmoticonPanelLinearLayout)paramangv).setCallBack(this.jdField_a_of_type_Anhs);
        a(6, paramangv);
        paramView = (ViewGroup)paramangv;
        paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout = new RelativeLayout[this.jdField_a_of_type_Int];
        i = 0;
        while (i < this.jdField_a_of_type_Int)
        {
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i] = ((RelativeLayout)paramView.getChildAt(i));
          i += 1;
        }
        paramangv.setTag(paramViewGroup);
        i = j;
      }
      for (;;)
      {
        paramView = paramangv;
        if (i >= this.jdField_a_of_type_Int) {
          break;
        }
        j = this.jdField_a_of_type_Int * paramInt + i;
        if (j > this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i].setTag(null);
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i].setVisibility(8);
        }
        for (;;)
        {
          i += 1;
          break;
          super.a(paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i], (anjy)this.jdField_a_of_type_JavaUtilList.get(j));
        }
        paramangv = paramView;
        i = j;
      }
      label662:
      paramangv = paramView;
    }
  }
  
  public angv a()
  {
    return new anhg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anhf
 * JD-Core Version:    0.7.0.1
 */