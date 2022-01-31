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

public class appg
  extends apru
{
  public appg(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, appt paramappt, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramappt, paramInt4);
    this.jdField_a_of_type_Appt = paramappt;
    this.b = true;
  }
  
  public View a(apow paramapow, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    paramViewGroup = (apph)paramapow;
    this.a = paramViewGroup;
    int i = getItemViewType(paramInt);
    if (i == 0)
    {
      if (paramView != null) {
        break label662;
      }
      paramapow = apsr.a().a(7);
      paramView = new AbsListView.LayoutParams(-1, -2);
      if (paramapow == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemtype = " + i + ";view from inflater");
        }
        paramapow = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561686, null);
        paramapow.setLayoutParams(paramView);
        paramapow.setPadding(0, (int)(10.0F * this.jdField_a_of_type_Float), 0, 0);
        a(7, paramapow);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramapow.findViewById(2131364879));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramapow.findViewById(2131364970));
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton = ((ProgressButton)paramapow.findViewById(2131364968));
        paramapow.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      a(paramViewGroup);
      paramView = paramapow;
      return paramView;
      if (QLog.isColorLevel()) {
        QLog.d("BigEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemtype = " + i + ";view from cache");
      }
      break;
      if (paramView == null)
      {
        paramView = apsr.a().a(6);
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
              paramapow = paramView;
              if (i >= this.jdField_a_of_type_Int) {
                break;
              }
              paramapow = super.a();
              paramapow.setVisibility(8);
              paramView.addView(paramapow);
              i += 1;
            }
            paramView.setPadding(0, (int)(14.0F * this.jdField_a_of_type_Float), 0, 0);
          }
        }
        paramapow = paramView;
        if (QLog.isColorLevel())
        {
          QLog.d("BigEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemtype = " + i + ";view from cache");
          paramapow = paramView;
        }
        ((EmoticonPanelLinearLayout)paramapow).setCallBack(this.jdField_a_of_type_Appt);
        a(6, paramapow);
        paramView = (ViewGroup)paramapow;
        paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout = new RelativeLayout[this.jdField_a_of_type_Int];
        i = 0;
        while (i < this.jdField_a_of_type_Int)
        {
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i] = ((RelativeLayout)paramView.getChildAt(i));
          i += 1;
        }
        paramapow.setTag(paramViewGroup);
        i = j;
      }
      for (;;)
      {
        paramView = paramapow;
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
          super.a(paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i], (apsj)this.jdField_a_of_type_JavaUtilList.get(j));
        }
        paramapow = paramView;
        i = j;
      }
      label662:
      paramapow = paramView;
    }
  }
  
  public apow a()
  {
    return new apph();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appg
 * JD-Core Version:    0.7.0.1
 */