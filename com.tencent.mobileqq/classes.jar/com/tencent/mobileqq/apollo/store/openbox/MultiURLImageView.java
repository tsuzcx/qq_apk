package com.tencent.mobileqq.apollo.store.openbox;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.image.Utils;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Iterator;
import java.util.List;

public class MultiURLImageView
  extends LinearLayout
{
  private List<MultiURLImageView.ViewLayoutData> a;
  
  public MultiURLImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      paramInt2 = 0;
      paramInt1 = 0;
      while (((Iterator)localObject).hasNext())
      {
        MultiURLImageView.ViewLayoutData localViewLayoutData = (MultiURLImageView.ViewLayoutData)((Iterator)localObject).next();
        if (super.getOrientation() == 1)
        {
          paramInt1 += localViewLayoutData.jdField_b_of_type_Int;
          paramInt2 = Math.max(paramInt2, localViewLayoutData.jdField_a_of_type_Int);
        }
        else
        {
          paramInt2 += localViewLayoutData.jdField_a_of_type_Int + localViewLayoutData.c;
          paramInt1 = Math.max(paramInt1, localViewLayoutData.jdField_b_of_type_Int);
        }
      }
      super.setMeasuredDimension(paramInt2, paramInt1);
    }
  }
  
  public void setOrientation(int paramInt)
  {
    super.setOrientation(paramInt);
    if (paramInt == 1)
    {
      super.setGravity(1);
      return;
    }
    super.setGravity(16);
  }
  
  public void setViewLayoutDatas(List<MultiURLImageView.ViewLayoutData> paramList)
  {
    this.a = paramList;
    if (this.a != null)
    {
      int i = 0;
      while (i < this.a.size())
      {
        MultiURLImageView.ViewLayoutData localViewLayoutData = (MultiURLImageView.ViewLayoutData)this.a.get(i);
        if (TextUtils.isEmpty(localViewLayoutData.jdField_a_of_type_JavaLangString)) {
          break;
        }
        paramList = localViewLayoutData.jdField_b_of_type_JavaLangString;
        Object localObject1 = paramList;
        if (TextUtils.isEmpty(paramList)) {
          localObject1 = Utils.Crc64String(localViewLayoutData.jdField_a_of_type_JavaLangString);
        }
        if (super.getChildCount() > i)
        {
          paramList = super.getChildAt(i);
          if ((paramList instanceof URLImageView))
          {
            paramList = (URLImageView)paramList;
            break label111;
          }
        }
        paramList = null;
        label111:
        Object localObject2 = paramList;
        if (paramList == null)
        {
          localObject2 = new URLImageView(super.getContext());
          super.addView((View)localObject2);
        }
        paramList = (LinearLayout.LayoutParams)((URLImageView)localObject2).getLayoutParams();
        paramList.width = localViewLayoutData.jdField_a_of_type_Int;
        paramList.height = localViewLayoutData.jdField_b_of_type_Int;
        paramList.leftMargin = localViewLayoutData.c;
        paramList = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable((String)localObject1, null, localViewLayoutData.jdField_a_of_type_JavaLangString);
        paramList.startDownload();
        ((URLImageView)localObject2).setImageDrawable(paramList);
        ((URLImageView)localObject2).setScaleType(localViewLayoutData.jdField_a_of_type_AndroidWidgetImageView$ScaleType);
        ((URLImageView)localObject2).setVisibility(0);
        i += 1;
      }
      if (super.getChildCount() > this.a.size())
      {
        i = this.a.size();
        while (i < super.getChildCount())
        {
          super.getChildAt(i).setVisibility(8);
          i += 1;
        }
      }
    }
    super.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.MultiURLImageView
 * JD-Core Version:    0.7.0.1
 */