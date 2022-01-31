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

public class aocl
  extends anzx
{
  protected int f = (this.d - (int)(18.0F * this.jdField_a_of_type_Float) * 8) / 7;
  
  public aocl(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, anyg paramanyg, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramanyg, paramInt4);
    this.b = true;
  }
  
  public View a(anxj paramanxj, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (aocm)paramanxj;
    this.a = paramViewGroup;
    int i = getItemViewType(paramInt);
    if (i == 0)
    {
      if (paramView != null) {
        break label751;
      }
      paramanxj = aoau.a().a(7);
      paramView = new AbsListView.LayoutParams(-1, -2);
      if (paramanxj == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemType = " + i + ";view from infalter");
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
        QLog.d("SmallEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemType = " + i + ";view from cache");
      }
      break;
      Object localObject;
      if (paramView == null)
      {
        paramView = aoau.a().a(2);
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
            paramanxj = paramView;
            if (i >= this.jdField_a_of_type_Int) {
              break;
            }
            paramanxj = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
            localObject = new LinearLayout.LayoutParams(this.f, this.f);
            ((LinearLayout.LayoutParams)localObject).leftMargin = ((int)(this.jdField_a_of_type_Float * 18.0F));
            paramanxj.setLayoutParams((ViewGroup.LayoutParams)localObject);
            paramanxj.setVisibility(8);
            paramanxj.setScaleType(ImageView.ScaleType.FIT_XY);
            paramanxj.setAdjustViewBounds(false);
            paramView.addView(paramanxj);
            i += 1;
          }
        }
        paramanxj = paramView;
        if (QLog.isColorLevel())
        {
          QLog.d("SmallEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemType = " + i + ";view from cache");
          paramanxj = paramView;
        }
        ((EmoticonPanelLinearLayout)paramanxj).setCallBack(this.jdField_a_of_type_Anyg);
        a(2, paramanxj);
        paramView = (ViewGroup)paramanxj;
        paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView = new URLImageView[this.jdField_a_of_type_Int];
        i = 0;
        while (i < this.jdField_a_of_type_Int)
        {
          paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i] = ((URLImageView)paramView.getChildAt(i));
          i += 1;
        }
        paramanxj.setTag(paramViewGroup);
      }
      for (;;)
      {
        i = 0;
        paramView = paramanxj;
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
          paramView = (aoam)this.jdField_a_of_type_JavaUtilList.get(j);
          if ((paramView instanceof anyh)) {}
          for (paramView = (anyh)paramView;; paramView = null)
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
        paramanxj = paramView;
      }
      label751:
      paramanxj = paramView;
    }
  }
  
  public anxj a()
  {
    return new aocm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aocl
 * JD-Core Version:    0.7.0.1
 */