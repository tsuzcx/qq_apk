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

public class anlw
  extends anjj
{
  protected int f = (this.d - (int)(18.0F * this.jdField_a_of_type_Float) * 8) / 7;
  
  public anlw(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, anhs paramanhs, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramanhs, paramInt4);
    this.b = true;
  }
  
  public View a(angv paramangv, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (anlx)paramangv;
    this.a = paramViewGroup;
    int i = getItemViewType(paramInt);
    if (i == 0)
    {
      if (paramView != null) {
        break label751;
      }
      paramangv = ankg.a().a(7);
      paramView = new AbsListView.LayoutParams(-1, -2);
      if (paramangv == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemType = " + i + ";view from infalter");
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
        QLog.d("SmallEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemType = " + i + ";view from cache");
      }
      break;
      Object localObject;
      if (paramView == null)
      {
        paramView = ankg.a().a(2);
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
            paramangv = paramView;
            if (i >= this.jdField_a_of_type_Int) {
              break;
            }
            paramangv = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
            localObject = new LinearLayout.LayoutParams(this.f, this.f);
            ((LinearLayout.LayoutParams)localObject).leftMargin = ((int)(this.jdField_a_of_type_Float * 18.0F));
            paramangv.setLayoutParams((ViewGroup.LayoutParams)localObject);
            paramangv.setVisibility(8);
            paramangv.setScaleType(ImageView.ScaleType.FIT_XY);
            paramangv.setAdjustViewBounds(false);
            paramView.addView(paramangv);
            i += 1;
          }
        }
        paramangv = paramView;
        if (QLog.isColorLevel())
        {
          QLog.d("SmallEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemType = " + i + ";view from cache");
          paramangv = paramView;
        }
        ((EmoticonPanelLinearLayout)paramangv).setCallBack(this.jdField_a_of_type_Anhs);
        a(2, paramangv);
        paramView = (ViewGroup)paramangv;
        paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView = new URLImageView[this.jdField_a_of_type_Int];
        i = 0;
        while (i < this.jdField_a_of_type_Int)
        {
          paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i] = ((URLImageView)paramView.getChildAt(i));
          i += 1;
        }
        paramangv.setTag(paramViewGroup);
      }
      for (;;)
      {
        i = 0;
        paramView = paramangv;
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
          paramView = (anjy)this.jdField_a_of_type_JavaUtilList.get(j);
          if ((paramView instanceof anht)) {}
          for (paramView = (anht)paramView;; paramView = null)
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
        paramangv = paramView;
      }
      label751:
      paramangv = paramView;
    }
  }
  
  public angv a()
  {
    return new anlx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anlw
 * JD-Core Version:    0.7.0.1
 */