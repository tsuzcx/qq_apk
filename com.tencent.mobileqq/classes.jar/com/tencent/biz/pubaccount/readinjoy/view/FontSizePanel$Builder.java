package com.tencent.biz.pubaccount.readinjoy.view;

import android.graphics.drawable.BitmapDrawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.widget.RangeButtonView;
import com.tencent.widget.RangeButtonView.OnChangeListener;
import com.tencent.widget.RangeButtonView.Title;
import java.util.ArrayList;
import java.util.List;

public class FontSizePanel$Builder
{
  private int jdField_a_of_type_Int;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private RangeButtonView.OnChangeListener jdField_a_of_type_ComTencentWidgetRangeButtonView$OnChangeListener;
  private List<RangeButtonView.Title> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private List<String> b;
  
  public FontSizePanel$Builder(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
  }
  
  private float a(float paramFloat)
  {
    float f = TypedValue.applyDimension(1, 16.0F, FontSettingManager.systemMetrics);
    if (paramFloat == 15.0F) {
      f = TypedValue.applyDimension(1, 15.0F, FontSettingManager.systemMetrics);
    }
    do
    {
      return f;
      if (paramFloat == 17.0F) {
        return TypedValue.applyDimension(1, 17.0F, FontSettingManager.systemMetrics);
      }
      if (paramFloat == 18.0F) {
        return TypedValue.applyDimension(1, 18.0F, FontSettingManager.systemMetrics);
      }
    } while (paramFloat != 20.0F);
    return TypedValue.applyDimension(1, 20.0F, FontSettingManager.systemMetrics);
  }
  
  public Builder a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public Builder a(RangeButtonView.OnChangeListener paramOnChangeListener)
  {
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView$OnChangeListener = paramOnChangeListener;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public FontSizePanel a()
  {
    FontSizePanel localFontSizePanel = new FontSizePanel(null);
    Object localObject = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559224, null);
    FontSizePanel.a(localFontSizePanel, new PopupWindow((View)localObject, -1, -2));
    FontSizePanel.a(localFontSizePanel).setBackgroundDrawable(new BitmapDrawable());
    FontSizePanel.a(localFontSizePanel).setOutsideTouchable(true);
    localObject = (RangeButtonView)((View)localObject).findViewById(2131367317);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(new RangeButtonView.Title(HardCodeUtil.a(2131704725), a(15.0F)));
      this.jdField_a_of_type_JavaUtilList.add(new RangeButtonView.Title(HardCodeUtil.a(2131704722), a(16.0F)));
      this.jdField_a_of_type_JavaUtilList.add(new RangeButtonView.Title("", a(17.0F)));
      this.jdField_a_of_type_JavaUtilList.add(new RangeButtonView.Title("", a(18.0F)));
      this.jdField_a_of_type_JavaUtilList.add(new RangeButtonView.Title(HardCodeUtil.a(2131702474), a(20.0F)));
    }
    ((RangeButtonView)localObject).setTitleData(this.jdField_a_of_type_JavaUtilList);
    FontSizePanel.a(localFontSizePanel, this.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_ComTencentWidgetRangeButtonView$OnChangeListener != null) {
      ((RangeButtonView)localObject).setOnChangerListener(this.jdField_a_of_type_ComTencentWidgetRangeButtonView$OnChangeListener);
    }
    ((RangeButtonView)localObject).setThumbPosition(this.jdField_a_of_type_Int);
    if ((this.b == null) || (this.b.isEmpty()))
    {
      this.b = new ArrayList();
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691199));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691200));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691201));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691202));
      this.b.add(BaseApplicationImpl.getApplication().getString(2131691203));
    }
    ((RangeButtonView)localObject).setContentDescList(this.b);
    FontSizePanel.a(localFontSizePanel, this.jdField_a_of_type_Boolean);
    return localFontSizePanel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.FontSizePanel.Builder
 * JD-Core Version:    0.7.0.1
 */