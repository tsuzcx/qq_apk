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

public class aptp
  extends apwd
{
  public aptp(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, apuc paramapuc, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramapuc, paramInt4);
    this.jdField_a_of_type_Apuc = paramapuc;
    this.b = true;
  }
  
  public View a(aptf paramaptf, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    paramViewGroup = (aptq)paramaptf;
    this.a = paramViewGroup;
    int i = getItemViewType(paramInt);
    if (i == 0)
    {
      if (paramView != null) {
        break label662;
      }
      paramaptf = apxa.a().a(7);
      paramView = new AbsListView.LayoutParams(-1, -2);
      if (paramaptf == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemtype = " + i + ";view from inflater");
        }
        paramaptf = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561704, null);
        paramaptf.setLayoutParams(paramView);
        paramaptf.setPadding(0, (int)(10.0F * this.jdField_a_of_type_Float), 0, 0);
        a(7, paramaptf);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramaptf.findViewById(2131364881));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramaptf.findViewById(2131364972));
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton = ((ProgressButton)paramaptf.findViewById(2131364970));
        paramaptf.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      a(paramViewGroup);
      paramView = paramaptf;
      return paramView;
      if (QLog.isColorLevel()) {
        QLog.d("BigEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemtype = " + i + ";view from cache");
      }
      break;
      if (paramView == null)
      {
        paramView = apxa.a().a(6);
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
              paramaptf = paramView;
              if (i >= this.jdField_a_of_type_Int) {
                break;
              }
              paramaptf = super.a();
              paramaptf.setVisibility(8);
              paramView.addView(paramaptf);
              i += 1;
            }
            paramView.setPadding(0, (int)(14.0F * this.jdField_a_of_type_Float), 0, 0);
          }
        }
        paramaptf = paramView;
        if (QLog.isColorLevel())
        {
          QLog.d("BigEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemtype = " + i + ";view from cache");
          paramaptf = paramView;
        }
        ((EmoticonPanelLinearLayout)paramaptf).setCallBack(this.jdField_a_of_type_Apuc);
        a(6, paramaptf);
        paramView = (ViewGroup)paramaptf;
        paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout = new RelativeLayout[this.jdField_a_of_type_Int];
        i = 0;
        while (i < this.jdField_a_of_type_Int)
        {
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i] = ((RelativeLayout)paramView.getChildAt(i));
          i += 1;
        }
        paramaptf.setTag(paramViewGroup);
        i = j;
      }
      for (;;)
      {
        paramView = paramaptf;
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
          super.a(paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i], (apws)this.jdField_a_of_type_JavaUtilList.get(j));
        }
        paramaptf = paramView;
        i = j;
      }
      label662:
      paramaptf = paramView;
    }
  }
  
  public aptf a()
  {
    return new aptq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aptp
 * JD-Core Version:    0.7.0.1
 */