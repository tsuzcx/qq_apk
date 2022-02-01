package com.tencent.avgame.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.avgame.util.IdUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class AVGameSplitNumberView
  extends RelativeLayout
{
  private List<Bitmap> a = new ArrayList();
  private int b = 0;
  private int c = 0;
  
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
  
  private ImageView b(int paramInt)
  {
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageBitmap((Bitmap)this.a.get(paramInt));
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
      localArrayList.add(AVGameUtil.c(String.format(paramString, new Object[] { Integer.valueOf(i) })));
      i += 1;
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((List)localObject).size() != 0) && (paramInt >= 0) && (this.c > 0) && (this.b > 0))
    {
      for (int i = 1;; i = j)
      {
        j = i * 10;
        if (j > paramInt) {
          break;
        }
      }
      removeAllViews();
      int j = 0;
      while (i != 0)
      {
        localObject = b(paramInt / i);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.c, this.b);
        if (j != 0) {
          localLayoutParams.addRule(1, j);
        }
        addView((View)localObject, localLayoutParams);
        j = ((ImageView)localObject).getId();
        paramInt %= i;
        i /= 10;
      }
      return;
    }
    QLog.e("AVGameSplitNumberView", 1, "invalid params to update num.");
  }
  
  public void setDimension(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.b = paramInt2;
  }
  
  public void setNumDrawable(List<Bitmap> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameSplitNumberView
 * JD-Core Version:    0.7.0.1
 */