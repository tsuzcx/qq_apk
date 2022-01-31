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

public class anxt
  extends anzx
{
  public anxt(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, anyg paramanyg, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramanyg, paramInt4);
    this.jdField_a_of_type_Anyg = paramanyg;
    this.b = true;
  }
  
  public View a(anxj paramanxj, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    paramViewGroup = (anxu)paramanxj;
    this.a = paramViewGroup;
    int i = getItemViewType(paramInt);
    if (i == 0)
    {
      if (paramView != null) {
        break label662;
      }
      paramanxj = aoau.a().a(7);
      paramView = new AbsListView.LayoutParams(-1, -2);
      if (paramanxj == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemtype = " + i + ";view from inflater");
        }
        paramanxj = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561495, null);
        paramanxj.setLayoutParams(paramView);
        paramanxj.setPadding(0, (int)(10.0F * this.jdField_a_of_type_Float), 0, 0);
        a(7, paramanxj);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramanxj.findViewById(2131364798));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramanxj.findViewById(2131364883));
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton = ((ProgressButton)paramanxj.findViewById(2131364881));
        paramanxj.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      a(paramViewGroup);
      paramView = paramanxj;
      return paramView;
      if (QLog.isColorLevel()) {
        QLog.d("BigEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemtype = " + i + ";view from cache");
      }
      break;
      if (paramView == null)
      {
        paramView = aoau.a().a(6);
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
              paramanxj = paramView;
              if (i >= this.jdField_a_of_type_Int) {
                break;
              }
              paramanxj = super.a();
              paramanxj.setVisibility(8);
              paramView.addView(paramanxj);
              i += 1;
            }
            paramView.setPadding(0, (int)(14.0F * this.jdField_a_of_type_Float), 0, 0);
          }
        }
        paramanxj = paramView;
        if (QLog.isColorLevel())
        {
          QLog.d("BigEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemtype = " + i + ";view from cache");
          paramanxj = paramView;
        }
        ((EmoticonPanelLinearLayout)paramanxj).setCallBack(this.jdField_a_of_type_Anyg);
        a(6, paramanxj);
        paramView = (ViewGroup)paramanxj;
        paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout = new RelativeLayout[this.jdField_a_of_type_Int];
        i = 0;
        while (i < this.jdField_a_of_type_Int)
        {
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i] = ((RelativeLayout)paramView.getChildAt(i));
          i += 1;
        }
        paramanxj.setTag(paramViewGroup);
        i = j;
      }
      for (;;)
      {
        paramView = paramanxj;
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
          super.a(paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i], (aoam)this.jdField_a_of_type_JavaUtilList.get(j));
        }
        paramanxj = paramView;
        i = j;
      }
      label662:
      paramanxj = paramView;
    }
  }
  
  public anxj a()
  {
    return new anxu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anxt
 * JD-Core Version:    0.7.0.1
 */