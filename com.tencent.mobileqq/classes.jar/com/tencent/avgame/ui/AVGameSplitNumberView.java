package com.tencent.avgame.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.avgame.util.IdUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class AVGameSplitNumberView
  extends RelativeLayout
{
  private int jdField_a_of_type_Int = 0;
  private List<Bitmap> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int b = 0;
  
  public AVGameSplitNumberView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AVGameSplitNumberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AVGameSplitNumberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private ImageView a(int paramInt)
  {
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageBitmap((Bitmap)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    localImageView.setClickable(false);
    localImageView.setId(IdUtils.a());
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    return localImageView;
  }
  
  public List<Bitmap> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 10)
    {
      localArrayList.add(AVGameUtils.a(String.format(paramString, new Object[] { Integer.valueOf(i) })));
      i += 1;
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0) || (paramInt < 0) || (this.b <= 0) || (this.jdField_a_of_type_Int <= 0)) {
      QLog.e("AVGameSplitNumberView", 1, "invalid params to update num.");
    }
    for (;;)
    {
      return;
      int i = 1;
      while (i * 10 <= paramInt) {
        i *= 10;
      }
      removeAllViews();
      int j = 0;
      while (i != 0)
      {
        ImageView localImageView = a(paramInt / i);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.b, this.jdField_a_of_type_Int);
        if (j != 0) {
          localLayoutParams.addRule(1, j);
        }
        addView(localImageView, localLayoutParams);
        j = localImageView.getId();
        paramInt %= i;
        i /= 10;
      }
    }
  }
  
  public void setDimension(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public void setNumDrawable(List<Bitmap> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameSplitNumberView
 * JD-Core Version:    0.7.0.1
 */