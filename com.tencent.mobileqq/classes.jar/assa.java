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

public class assa
  extends asoy
{
  protected int f = (this.d - (int)(18.0F * this.jdField_a_of_type_Float) * 8) / 7;
  
  public assa(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, asmr paramasmr, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramasmr, paramInt4);
    this.b = true;
  }
  
  public View a(aslu paramaslu, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (assb)paramaslu;
    this.a = paramViewGroup;
    int i = getItemViewType(paramInt);
    if (i == 0)
    {
      if (paramView != null) {
        break label751;
      }
      paramaslu = aspy.a().a(7);
      paramView = new AbsListView.LayoutParams(-1, -2);
      if (paramaslu == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemType = " + i + ";view from infalter");
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
        QLog.d("SmallEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemType = " + i + ";view from cache");
      }
      break;
      Object localObject;
      if (paramView == null)
      {
        paramView = aspy.a().a(2);
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
            paramaslu = paramView;
            if (i >= this.jdField_a_of_type_Int) {
              break;
            }
            paramaslu = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
            localObject = new LinearLayout.LayoutParams(this.f, this.f);
            ((LinearLayout.LayoutParams)localObject).leftMargin = ((int)(this.jdField_a_of_type_Float * 18.0F));
            paramaslu.setLayoutParams((ViewGroup.LayoutParams)localObject);
            paramaslu.setVisibility(8);
            paramaslu.setScaleType(ImageView.ScaleType.FIT_XY);
            paramaslu.setAdjustViewBounds(false);
            paramView.addView(paramaslu);
            i += 1;
          }
        }
        paramaslu = paramView;
        if (QLog.isColorLevel())
        {
          QLog.d("SmallEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemType = " + i + ";view from cache");
          paramaslu = paramView;
        }
        ((EmoticonPanelLinearLayout)paramaslu).setCallBack(this.jdField_a_of_type_Asmr);
        a(2, paramaslu);
        paramView = (ViewGroup)paramaslu;
        paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView = new URLImageView[this.jdField_a_of_type_Int];
        i = 0;
        while (i < this.jdField_a_of_type_Int)
        {
          paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i] = ((URLImageView)paramView.getChildAt(i));
          i += 1;
        }
        paramaslu.setTag(paramViewGroup);
      }
      for (;;)
      {
        i = 0;
        paramView = paramaslu;
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
          paramView = (aspq)this.jdField_a_of_type_JavaUtilList.get(j);
          if ((paramView instanceof asmu)) {}
          for (paramView = (asmu)paramView;; paramView = null)
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
        paramaslu = paramView;
      }
      label751:
      paramaslu = paramView;
    }
  }
  
  public aslu a()
  {
    return new assb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     assa
 * JD-Core Version:    0.7.0.1
 */