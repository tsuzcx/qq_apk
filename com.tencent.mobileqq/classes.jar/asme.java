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

public class asme
  extends asoy
{
  public asme(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, asmr paramasmr, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramasmr, paramInt4);
    this.jdField_a_of_type_Asmr = paramasmr;
    this.b = true;
  }
  
  public View a(aslu paramaslu, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    paramViewGroup = (asmf)paramaslu;
    this.a = paramViewGroup;
    int i = getItemViewType(paramInt);
    if (i == 0)
    {
      if (paramView != null) {
        break label662;
      }
      paramaslu = aspy.a().a(7);
      paramView = new AbsListView.LayoutParams(-1, -2);
      if (paramaslu == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemtype = " + i + ";view from inflater");
        }
        paramaslu = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561980, null);
        paramaslu.setLayoutParams(paramView);
        paramaslu.setPadding(0, (int)(10.0F * this.jdField_a_of_type_Float), 0, 0);
        a(7, paramaslu);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramaslu.findViewById(2131365160));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramaslu.findViewById(2131365252));
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton = ((ProgressButton)paramaslu.findViewById(2131365250));
        paramaslu.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      a(paramViewGroup);
      paramView = paramaslu;
      return paramView;
      if (QLog.isColorLevel()) {
        QLog.d("BigEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemtype = " + i + ";view from cache");
      }
      break;
      if (paramView == null)
      {
        paramView = aspy.a().a(6);
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
              paramaslu = paramView;
              if (i >= this.jdField_a_of_type_Int) {
                break;
              }
              paramaslu = super.a();
              paramaslu.setVisibility(8);
              paramView.addView(paramaslu);
              i += 1;
            }
            paramView.setPadding(0, (int)(14.0F * this.jdField_a_of_type_Float), 0, 0);
          }
        }
        paramaslu = paramView;
        if (QLog.isColorLevel())
        {
          QLog.d("BigEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemtype = " + i + ";view from cache");
          paramaslu = paramView;
        }
        ((EmoticonPanelLinearLayout)paramaslu).setCallBack(this.jdField_a_of_type_Asmr);
        a(6, paramaslu);
        paramView = (ViewGroup)paramaslu;
        paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout = new RelativeLayout[this.jdField_a_of_type_Int];
        i = 0;
        while (i < this.jdField_a_of_type_Int)
        {
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i] = ((RelativeLayout)paramView.getChildAt(i));
          i += 1;
        }
        paramaslu.setTag(paramViewGroup);
        i = j;
      }
      for (;;)
      {
        paramView = paramaslu;
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
          super.a(paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i], (aspq)this.jdField_a_of_type_JavaUtilList.get(j));
        }
        paramaslu = paramView;
        i = j;
      }
      label662:
      paramaslu = paramView;
    }
  }
  
  public aslu a()
  {
    return new asmf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asme
 * JD-Core Version:    0.7.0.1
 */