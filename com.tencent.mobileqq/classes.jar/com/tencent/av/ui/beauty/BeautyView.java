package com.tencent.av.ui.beauty;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.effects.BeautyConfig;
import com.tencent.av.ui.BeautyConfigUtil;
import com.tencent.av.ui.FadingHorizontalScrollView;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class BeautyView
  extends BeautyBaseView
{
  static final Object[][] jdField_a_of_type_Array2dOfJavaLangObject;
  int jdField_a_of_type_Int = 0;
  final Button jdField_a_of_type_AndroidWidgetButton;
  final LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  final FadingHorizontalScrollView jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView;
  final BeautySeekView jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView;
  final ArrayList<BeautyView.BeautyItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList(12);
  private boolean jdField_a_of_type_Boolean = true;
  VideoAppInterface b;
  
  static
  {
    Object[] arrayOfObject1 = { "BEAUTY_SKIN", Integer.valueOf(2131695400), Integer.valueOf(2130842004) };
    Object[] arrayOfObject2 = { "COLOR_TONE", Integer.valueOf(2131695399), Integer.valueOf(2130842005) };
    Object[] arrayOfObject3 = { "FACE_THIN", Integer.valueOf(2131695386), Integer.valueOf(2130841996) };
    Object[] arrayOfObject4 = { "NOSE_THIN", Integer.valueOf(2131695396), Integer.valueOf(2130842006) };
    Object[] arrayOfObject5 = { "MOUTH_SHAPE", Integer.valueOf(2131695393), Integer.valueOf(2130842002) };
    Object[] arrayOfObject6 = { "TOOTH_WHITEN", Integer.valueOf(2131695407), Integer.valueOf(2130842007) };
    jdField_a_of_type_Array2dOfJavaLangObject = new Object[][] { arrayOfObject1, { "FACE_SHAPE_4", Integer.valueOf(2131695384), Integer.valueOf(2130841995) }, arrayOfObject2, { "FACE_V", Integer.valueOf(2131695387), Integer.valueOf(2130841998) }, arrayOfObject3, { "CHIN", Integer.valueOf(2131695382), Integer.valueOf(2130841994) }, { "ENLARGE_EYE", Integer.valueOf(2131695383), Integer.valueOf(2130841999) }, { "EYE_LIGHTEN", Integer.valueOf(2131695391), Integer.valueOf(2130842000) }, arrayOfObject4, arrayOfObject5, arrayOfObject6 };
  }
  
  public BeautyView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BeautyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BeautyView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflate(paramContext, 2131559738, this);
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView = ((BeautySeekView)findViewById(2131363489));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363470));
    this.jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView = ((FadingHorizontalScrollView)findViewById(2131363486));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363485));
    int i = (int)(ImmersiveUtils.getScreenWidth() / 5.6F);
    this.jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView.setFadingMode(1);
    this.jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView.setFadingEdgeLength(i / 2);
    this.jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView.setOverScrollMode(2);
    paramContext = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
    if (paramContext == null)
    {
      paramContext = new RelativeLayout.LayoutParams(i, -2);
    }
    else
    {
      paramContext.width = i;
      paramContext.height = -2;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setLayoutParams(paramContext);
    a(this.jdField_a_of_type_AndroidWidgetButton, 2131695381, 2130842003, 2131165975, Integer.valueOf(2131363470));
    paramContext = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramContext instanceof VideoAppInterface))
    {
      this.b = ((VideoAppInterface)paramContext);
      boolean bool;
      if (BeautyConfigUtil.b(this.b.getCurrentAccountUin()) == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_a_of_type_Boolean = bool;
      paramContext = this.b.a();
    }
    else
    {
      paramContext = new BeautyConfig();
    }
    paramInt = 0;
    while (paramInt < jdField_a_of_type_Array2dOfJavaLangObject.length)
    {
      paramAttributeSet = new BeautyView.BeautyItem();
      Object localObject = jdField_a_of_type_Array2dOfJavaLangObject;
      paramAttributeSet.jdField_a_of_type_JavaLangString = ((String)localObject[paramInt][0]);
      paramAttributeSet.jdField_a_of_type_Int = ((Integer)localObject[paramInt][1]).intValue();
      paramAttributeSet.b = ((Integer)jdField_a_of_type_Array2dOfJavaLangObject[paramInt][2]).intValue();
      paramAttributeSet.c = paramContext.a(paramAttributeSet.jdField_a_of_type_JavaLangString);
      paramAttributeSet.f = paramContext.b(paramAttributeSet.jdField_a_of_type_JavaLangString);
      paramAttributeSet.e = paramInt;
      this.jdField_a_of_type_JavaUtilArrayList.add(paramAttributeSet);
      localObject = a(paramAttributeSet);
      paramAttributeSet = new LinearLayout.LayoutParams(Math.max(i, paramAttributeSet.d), -2);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject, paramAttributeSet);
      if (this.jdField_a_of_type_Int == paramInt) {
        ((View)localObject).setSelected(true);
      } else {
        ((View)localObject).setSelected(false);
      }
      paramInt += 1;
    }
    b();
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.setBeautySeekActionListener(this);
  }
  
  View a(BeautyView.BeautyItem paramBeautyItem)
  {
    Button localButton = new Button(getContext());
    a(localButton, paramBeautyItem.jdField_a_of_type_Int, paramBeautyItem.b, 2131165974, paramBeautyItem);
    paramBeautyItem.d = ((int)Math.max(UITools.a(localButton), AIOUtils.b(28.0F, getResources())));
    return localButton;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((VideoAppInterface)localObject).a();
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        BeautyView.BeautyItem localBeautyItem = (BeautyView.BeautyItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        localBeautyItem.c = ((BeautyConfig)localObject).a(localBeautyItem.jdField_a_of_type_JavaLangString);
        i += 1;
      }
    }
    int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int i = 0;
    while (i < j)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if (localObject != null) {
        if (i == this.jdField_a_of_type_Int) {
          ((View)localObject).setSelected(true);
        } else {
          ((View)localObject).setSelected(false);
        }
      }
      i += 1;
    }
    b();
  }
  
  void a(Button paramButton, int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    Resources localResources = getResources();
    Drawable localDrawable = localResources.getDrawable(paramInt2);
    TintStateDrawable localTintStateDrawable = TintStateDrawable.a(localResources, paramInt2, paramInt3);
    localTintStateDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    paramButton.setCompoundDrawables(null, localTintStateDrawable, null, null);
    paramButton.setTextColor(localResources.getColorStateList(paramInt3));
    paramButton.setText(paramInt1);
    paramButton.setBackgroundDrawable(null);
    paramButton.setOnClickListener(this);
    paramButton.setTag(2131372190, paramObject);
    paramButton.setTextSize(ViewUtils.e(AIOUtils.b(12.0F, getResources())));
    paramButton.setCompoundDrawablePadding(AIOUtils.b(8.0F, getResources()));
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      return;
    }
    VideoAppInterface localVideoAppInterface = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    Object localObject;
    do
    {
      localObject = localVideoAppInterface;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (BeautyView.BeautyItem)localIterator.next();
    } while (!paramString.equals(((BeautyView.BeautyItem)localObject).jdField_a_of_type_JavaLangString));
    if ((localObject != null) && (paramInt1 != 1))
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3) {
          return;
        }
        ((BeautyView.BeautyItem)localObject).c = paramInt2;
        localVideoAppInterface = this.b;
        if (localVideoAppInterface != null) {
          localVideoAppInterface.a(paramString, paramInt2, true);
        }
        AVUtil.a("0X800A569", ((BeautyView.BeautyItem)localObject).e + 1);
        return;
      }
      ((BeautyView.BeautyItem)localObject).c = paramInt2;
      localObject = this.b;
      if (localObject != null) {
        ((VideoAppInterface)localObject).a(paramString, paramInt2, false);
      }
    }
  }
  
  void b()
  {
    Resources localResources = getResources();
    int i = this.jdField_a_of_type_Int;
    BeautyView.BeautyItem localBeautyItem;
    if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      localBeautyItem = (BeautyView.BeautyItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
    } else {
      localBeautyItem = null;
    }
    if (localBeautyItem != null) {
      this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.a(localResources.getString(localBeautyItem.jdField_a_of_type_Int), localBeautyItem.jdField_a_of_type_JavaLangString, localBeautyItem.c, localBeautyItem.f);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        localObject = this.b;
        if (localObject != null) {
          BeautyConfigUtil.a(((VideoAppInterface)localObject).getCurrentAccountUin(), 1);
        }
        DialogUtil.a((Activity)getContext(), getResources().getString(2131695397), 2131690728, 2131694583, new BeautyView.1(this), new BeautyView.2(this)).show();
      }
      else
      {
        localObject = this.b;
        if (localObject != null)
        {
          ((VideoAppInterface)localObject).e();
          localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            BeautyView.BeautyItem localBeautyItem = (BeautyView.BeautyItem)((Iterator)localObject).next();
            localBeautyItem.c = this.b.b(localBeautyItem.jdField_a_of_type_JavaLangString);
          }
        }
        b();
      }
    }
    else
    {
      localObject = paramView.getTag(2131372190);
      if ((localObject instanceof BeautyView.BeautyItem))
      {
        localObject = (BeautyView.BeautyItem)localObject;
        int i = ((BeautyView.BeautyItem)localObject).e;
        int j = this.jdField_a_of_type_Int;
        if (i != j)
        {
          if ((j >= 0) && (j < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_a_of_type_Int).setSelected(false);
          }
          paramView.setSelected(true);
          this.jdField_a_of_type_Int = ((BeautyView.BeautyItem)localObject).e;
          b();
        }
        AVUtil.a("0X800A568", ((BeautyView.BeautyItem)localObject).e + 1);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setAppInterface(VideoAppInterface paramVideoAppInterface)
  {
    super.setAppInterface(paramVideoAppInterface);
    paramVideoAppInterface = this.b;
    if (paramVideoAppInterface != null)
    {
      boolean bool;
      if (BeautyConfigUtil.b(paramVideoAppInterface.getCurrentAccountUin()) == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_a_of_type_Boolean = bool;
      paramVideoAppInterface = this.b.a();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        BeautyView.BeautyItem localBeautyItem = (BeautyView.BeautyItem)localIterator.next();
        if (localBeautyItem != null) {
          localBeautyItem.c = paramVideoAppInterface.a(localBeautyItem.jdField_a_of_type_JavaLangString);
        }
      }
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.beauty.BeautyView
 * JD-Core Version:    0.7.0.1
 */