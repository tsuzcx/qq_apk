import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class asrx
  extends aslt
{
  BaseChatPie a;
  protected EmoticonPackage a;
  protected asmr b;
  protected int f;
  private int g;
  
  public asrx(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, asmr paramasmr, BaseChatPie paramBaseChatPie, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramasmr);
    this.g = paramInt4;
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = paramEmoticonPackage;
    this.b = paramasmr;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public View a(aslu paramaslu, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.f = ((this.d - (int)(18.0F * this.jdField_a_of_type_Float) * (this.jdField_a_of_type_Int + 1)) / this.jdField_a_of_type_Int);
    Object localObject1 = (asrz)paramaslu;
    int i;
    if (getItemViewType(paramInt) == 0)
    {
      if (paramView != null) {
        break label933;
      }
      paramView = aspy.a().a(this.c);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallEmotionDownloadedAdapter", 2, "getEmotionView position = " + paramInt + ";view from inflater");
        }
        paramView = new EmoticonPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.g);
        paramView.setPanelType(EmoticonPanelLinearLayout.c);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        paramView.setOrientation(0);
        paramView.setPadding(0, (int)(18.0F * this.jdField_a_of_type_Float), 0, 0);
        i = 0;
        for (;;)
        {
          paramaslu = paramView;
          if (i >= this.jdField_a_of_type_Int) {
            break;
          }
          paramaslu = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
          paramViewGroup = new LinearLayout.LayoutParams(this.f, this.f);
          paramViewGroup.leftMargin = ((int)(18.0F * this.jdField_a_of_type_Float));
          paramaslu.setLayoutParams(paramViewGroup);
          paramaslu.setVisibility(8);
          paramaslu.setScaleType(ImageView.ScaleType.FIT_XY);
          paramaslu.setAdjustViewBounds(false);
          paramaslu.setFocusable(true);
          paramaslu.setFocusableInTouchMode(true);
          paramView.addView(paramaslu);
          i += 1;
        }
      }
      paramaslu = paramView;
      if (QLog.isColorLevel())
      {
        QLog.d("SmallEmotionDownloadedAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
        paramaslu = paramView;
      }
      ((EmoticonPanelLinearLayout)paramaslu).setCallBack(this.b);
      a(this.c, paramaslu);
      paramView = (ViewGroup)paramaslu;
      ((asrz)localObject1).jdField_a_of_type_ArrayOfComTencentImageURLImageView = new URLImageView[this.jdField_a_of_type_Int];
      i = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        ((asrz)localObject1).jdField_a_of_type_ArrayOfComTencentImageURLImageView[i] = ((URLImageView)paramView.getChildAt(i));
        i += 1;
      }
      paramaslu.setTag(localObject1);
    }
    for (;;)
    {
      i = 0;
      paramView = paramaslu;
      int j;
      if (i < this.jdField_a_of_type_Int)
      {
        j = this.jdField_a_of_type_Int * paramInt + i;
        if (j > this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          localObject1.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i].setTag(null);
          localObject1.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i].setVisibility(8);
        }
      }
      label896:
      label908:
      label919:
      label931:
      for (;;)
      {
        i += 1;
        break;
        paramViewGroup = localObject1.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i];
        paramView = (aspq)this.jdField_a_of_type_JavaUtilList.get(j);
        if ((paramView instanceof asmu)) {}
        for (paramView = (asmu)paramView;; paramView = null)
        {
          if (paramView == null) {
            break label931;
          }
          localObject1.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i].setTag(paramView);
          paramViewGroup.setImageDrawable(paramView.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float));
          paramViewGroup.setVisibility(0);
          break;
          if (paramView == null)
          {
            paramViewGroup = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
            paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, (int)(57.0F * this.jdField_a_of_type_Float)));
            LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
            paramaslu = new RelativeLayout.LayoutParams(-2, -2);
            paramaslu.addRule(13, -1);
            localLinearLayout.setLayoutParams(paramaslu);
            paramView = asoo.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, true);
            Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
            localLinearLayout.setOrientation(0);
            ((LinearLayout.LayoutParams)localObject2).gravity = 16;
            TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
            localTextView.setTextSize(14.0F);
            if (paramView.a)
            {
              paramaslu = anzj.a(2131713066);
              localTextView.setText(paramaslu);
              localTextView.setTextColor(-8947849);
              localLinearLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject2);
              paramaslu = new LinearLayout.LayoutParams(-2, -2);
              paramaslu.leftMargin = ((int)(5.0F * this.jdField_a_of_type_Float));
              paramaslu.gravity = 16;
              localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
              ((ImageView)localObject2).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847117));
              localLinearLayout.addView((View)localObject2, paramaslu);
              paramViewGroup.addView(localLinearLayout);
              ((asrz)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = localLinearLayout;
              ((asrz)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new asry(this, paramView));
              if (this.g != 2) {
                break label896;
              }
              ((asrz)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
              label825:
              paramViewGroup.setTag(localObject1);
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
                break label908;
              }
              paramaslu = "";
              label843:
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId;
              if (!paramView.a) {
                break label919;
              }
            }
            for (paramView = "1";; paramView = "2")
            {
              VasWebviewUtil.reportCommercialDrainage(paramaslu, "ep_mall", "exp_bq_detail", null, 1, 0, 0, null, (String)localObject1, paramView);
              paramView = paramViewGroup;
              return paramView;
              paramaslu = anzj.a(2131713065);
              break;
              ((asrz)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              break label825;
              paramaslu = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
              break label843;
            }
          }
          return paramView;
        }
      }
      label933:
      paramaslu = paramView;
    }
  }
  
  public aslu a()
  {
    return new asrz();
  }
  
  public EmoticonPackage a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
  }
  
  public int getCount()
  {
    int i = super.getCount();
    if (i > 0)
    {
      if (this.g == 1) {
        return i;
      }
      return i + 1;
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.g == 1) {}
    while (paramInt != getCount() - 1) {
      return 0;
    }
    return 1;
  }
  
  public int getViewTypeCount()
  {
    if (this.g == 1) {
      return 1;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asrx
 * JD-Core Version:    0.7.0.1
 */