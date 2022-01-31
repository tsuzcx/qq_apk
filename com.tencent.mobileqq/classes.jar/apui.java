import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class apui
  extends apru
{
  protected int f = (this.d - (int)(18.0F * this.jdField_a_of_type_Float) * 8) / 7;
  
  public apui(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, appt paramappt, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramappt, paramInt4);
    this.b = true;
  }
  
  public View a(apow paramapow, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (apuj)paramapow;
    this.a = paramViewGroup;
    int i = getItemViewType(paramInt);
    if (i == 0)
    {
      if (paramView != null) {
        break label751;
      }
      paramapow = apsr.a().a(7);
      paramView = new AbsListView.LayoutParams(-1, -2);
      if (paramapow == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemType = " + i + ";view from infalter");
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
        QLog.d("SmallEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemType = " + i + ";view from cache");
      }
      break;
      Object localObject;
      if (paramView == null)
      {
        paramView = apsr.a().a(2);
        if (paramView == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SmallEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemType = " + i + ";view from infalter");
          }
          paramView = new EmoticonPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext);
          paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
          paramView.setOrientation(0);
          paramView.setPadding(0, (int)(this.jdField_a_of_type_Float * 18.0F), 0, 0);
          i = 0;
          for (;;)
          {
            paramapow = paramView;
            if (i >= this.jdField_a_of_type_Int) {
              break;
            }
            paramapow = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
            localObject = new LinearLayout.LayoutParams(this.f, this.f);
            ((LinearLayout.LayoutParams)localObject).leftMargin = ((int)(this.jdField_a_of_type_Float * 18.0F));
            paramapow.setLayoutParams((ViewGroup.LayoutParams)localObject);
            paramapow.setVisibility(8);
            paramapow.setScaleType(ImageView.ScaleType.FIT_XY);
            paramapow.setAdjustViewBounds(false);
            paramView.addView(paramapow);
            i += 1;
          }
        }
        paramapow = paramView;
        if (QLog.isColorLevel())
        {
          QLog.d("SmallEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemType = " + i + ";view from cache");
          paramapow = paramView;
        }
        ((EmoticonPanelLinearLayout)paramapow).setCallBack(this.jdField_a_of_type_Appt);
        a(2, paramapow);
        paramView = (ViewGroup)paramapow;
        paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView = new URLImageView[this.jdField_a_of_type_Int];
        i = 0;
        while (i < this.jdField_a_of_type_Int)
        {
          paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i] = ((URLImageView)paramView.getChildAt(i));
          i += 1;
        }
        paramapow.setTag(paramViewGroup);
      }
      for (;;)
      {
        i = 0;
        paramView = paramapow;
        if (i >= this.jdField_a_of_type_Int) {
          break;
        }
        int j = this.jdField_a_of_type_Int * paramInt + i;
        if (j > this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i].setTag(null);
          paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i].setVisibility(8);
        }
        label744:
        for (;;)
        {
          i += 1;
          break;
          localObject = paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i];
          paramView = (apsj)this.jdField_a_of_type_JavaUtilList.get(j);
          if ((paramView instanceof appw)) {}
          for (paramView = (appw)paramView;; paramView = null)
          {
            if (paramView == null) {
              break label744;
            }
            paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i].setTag(paramView);
            paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i].setOnClickListener(this);
            ((URLImageView)localObject).setImageDrawable(paramView.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float));
            ((URLImageView)localObject).setVisibility(0);
            break;
          }
        }
        paramapow = paramView;
      }
      label751:
      paramapow = paramView;
    }
  }
  
  public apow a()
  {
    return new apuj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apui
 * JD-Core Version:    0.7.0.1
 */