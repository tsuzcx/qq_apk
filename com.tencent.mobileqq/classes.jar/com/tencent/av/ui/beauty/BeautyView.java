package com.tencent.av.ui.beauty;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
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
    Object[] arrayOfObject = { "NOSE_THIN", Integer.valueOf(2131695386), Integer.valueOf(2130842109) };
    jdField_a_of_type_Array2dOfJavaLangObject = new Object[][] { { "BEAUTY_SKIN", Integer.valueOf(2131695390), Integer.valueOf(2130842107) }, { "FACE_SHAPE_4", Integer.valueOf(2131695374), Integer.valueOf(2130842098) }, { "COLOR_TONE", Integer.valueOf(2131695389), Integer.valueOf(2130842108) }, { "FACE_V", Integer.valueOf(2131695377), Integer.valueOf(2130842101) }, { "FACE_THIN", Integer.valueOf(2131695376), Integer.valueOf(2130842099) }, { "CHIN", Integer.valueOf(2131695372), Integer.valueOf(2130842097) }, { "ENLARGE_EYE", Integer.valueOf(2131695373), Integer.valueOf(2130842102) }, { "EYE_LIGHTEN", Integer.valueOf(2131695381), Integer.valueOf(2130842103) }, arrayOfObject, { "MOUTH_SHAPE", Integer.valueOf(2131695383), Integer.valueOf(2130842105) }, { "TOOTH_WHITEN", Integer.valueOf(2131695397), Integer.valueOf(2130842110) } };
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
    inflate(paramContext, 2131559862, this);
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView = ((BeautySeekView)findViewById(2131363565));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363544));
    this.jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView = ((FadingHorizontalScrollView)findViewById(2131363561));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363560));
    int i = (int)(ImmersiveUtils.getScreenWidth() / 5.6F);
    this.jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView.setFadingMode(1);
    this.jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView.setFadingEdgeLength(i / 2);
    this.jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView.setOverScrollMode(2);
    paramContext = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
    boolean bool;
    if (paramContext == null)
    {
      paramContext = new RelativeLayout.LayoutParams(i, -2);
      this.jdField_a_of_type_AndroidWidgetButton.setLayoutParams(paramContext);
      a(this.jdField_a_of_type_AndroidWidgetButton, 2131695371, 2130842106, 2131165964, Integer.valueOf(2131363544));
      paramContext = BaseApplicationImpl.getApplication().getRuntime();
      if (!(paramContext instanceof VideoAppInterface)) {
        break label426;
      }
      this.b = ((VideoAppInterface)paramContext);
      if (BeautyConfigUtil.b(this.b.getCurrentAccountUin()) != 0) {
        break label420;
      }
      bool = true;
      label219:
      this.jdField_a_of_type_Boolean = bool;
      paramContext = this.b.a();
      label233:
      paramInt = 0;
      label235:
      if (paramInt >= jdField_a_of_type_Array2dOfJavaLangObject.length) {
        break label445;
      }
      Object localObject = new BeautyView.BeautyItem();
      ((BeautyView.BeautyItem)localObject).jdField_a_of_type_JavaLangString = ((String)jdField_a_of_type_Array2dOfJavaLangObject[paramInt][0]);
      ((BeautyView.BeautyItem)localObject).jdField_a_of_type_Int = ((Integer)jdField_a_of_type_Array2dOfJavaLangObject[paramInt][1]).intValue();
      ((BeautyView.BeautyItem)localObject).b = ((Integer)jdField_a_of_type_Array2dOfJavaLangObject[paramInt][2]).intValue();
      ((BeautyView.BeautyItem)localObject).c = paramContext.a(((BeautyView.BeautyItem)localObject).jdField_a_of_type_JavaLangString);
      ((BeautyView.BeautyItem)localObject).f = paramContext.b(((BeautyView.BeautyItem)localObject).jdField_a_of_type_JavaLangString);
      ((BeautyView.BeautyItem)localObject).e = paramInt;
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      paramAttributeSet = a((BeautyView.BeautyItem)localObject);
      localObject = new LinearLayout.LayoutParams(Math.max(i, ((BeautyView.BeautyItem)localObject).d), -2);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramAttributeSet, (ViewGroup.LayoutParams)localObject);
      if (this.jdField_a_of_type_Int != paramInt) {
        break label437;
      }
      paramAttributeSet.setSelected(true);
    }
    for (;;)
    {
      paramInt += 1;
      break label235;
      paramContext.width = i;
      paramContext.height = -2;
      break;
      label420:
      bool = false;
      break label219;
      label426:
      paramContext = new BeautyConfig();
      break label233;
      label437:
      paramAttributeSet.setSelected(false);
    }
    label445:
    b();
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.setBeautySeekActionListener(this);
  }
  
  View a(BeautyView.BeautyItem paramBeautyItem)
  {
    Button localButton = new Button(getContext());
    a(localButton, paramBeautyItem.jdField_a_of_type_Int, paramBeautyItem.b, 2131165963, paramBeautyItem);
    paramBeautyItem.d = ((int)Math.max(UITools.a(localButton), AIOUtils.a(28.0F, getResources())));
    return localButton;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    Object localObject;
    if (this.b != null)
    {
      localObject = this.b.a();
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
    if (i < j)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (i == this.jdField_a_of_type_Int) {
          ((View)localObject).setSelected(true);
        } else {
          ((View)localObject).setSelected(false);
        }
      }
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
    paramButton.setTag(2131372606, paramObject);
    paramButton.setTextSize(ViewUtils.e(AIOUtils.a(12.0F, getResources())));
    paramButton.setCompoundDrawablePadding(AIOUtils.a(8.0F, getResources()));
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {}
    label146:
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      BeautyView.BeautyItem localBeautyItem;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localBeautyItem = (BeautyView.BeautyItem)localIterator.next();
      } while (!paramString.equals(localBeautyItem.jdField_a_of_type_JavaLangString));
      for (;;)
      {
        if (localBeautyItem == null) {
          break label146;
        }
        switch (paramInt1)
        {
        case 1: 
        default: 
          return;
        case 2: 
          localBeautyItem.c = paramInt2;
          if (this.b == null) {
            break;
          }
          this.b.a(paramString, paramInt2, false);
          return;
        case 3: 
          localBeautyItem.c = paramInt2;
          if (this.b != null) {
            this.b.a(paramString, paramInt2, true);
          }
          AVUtil.a("0X800A569", localBeautyItem.e + 1);
          return;
          localBeautyItem = null;
        }
      }
    }
  }
  
  void b()
  {
    Resources localResources = getResources();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Int >= 0)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size()) {
        localObject1 = (BeautyView.BeautyItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      }
    }
    if (localObject1 != null) {
      this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.a(localResources.getString(((BeautyView.BeautyItem)localObject1).jdField_a_of_type_Int), ((BeautyView.BeautyItem)localObject1).jdField_a_of_type_JavaLangString, ((BeautyView.BeautyItem)localObject1).c, ((BeautyView.BeautyItem)localObject1).f);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        if (this.b != null) {
          BeautyConfigUtil.a(this.b.getCurrentAccountUin(), 1);
        }
        DialogUtil.a((Activity)getContext(), getResources().getString(2131695387), 2131690800, 2131694615, new BeautyView.1(this), new BeautyView.2(this)).show();
      }
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.b != null)
        {
          this.b.e();
          localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            BeautyView.BeautyItem localBeautyItem = (BeautyView.BeautyItem)((Iterator)localObject).next();
            localBeautyItem.c = this.b.b(localBeautyItem.jdField_a_of_type_JavaLangString);
          }
        }
        b();
      }
      localObject = paramView.getTag(2131372606);
    } while (!(localObject instanceof BeautyView.BeautyItem));
    Object localObject = (BeautyView.BeautyItem)localObject;
    if (((BeautyView.BeautyItem)localObject).e == this.jdField_a_of_type_Int) {}
    for (;;)
    {
      AVUtil.a("0X800A568", ((BeautyView.BeautyItem)localObject).e + 1);
      break;
      if ((this.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_Int < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_a_of_type_Int).setSelected(false);
      }
      paramView.setSelected(true);
      this.jdField_a_of_type_Int = ((BeautyView.BeautyItem)localObject).e;
      b();
    }
  }
  
  public void setAppInterface(VideoAppInterface paramVideoAppInterface)
  {
    super.setAppInterface(paramVideoAppInterface);
    if (this.b != null)
    {
      if (BeautyConfigUtil.b(this.b.getCurrentAccountUin()) == 0) {}
      for (boolean bool = true;; bool = false)
      {
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
      }
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.beauty.BeautyView
 * JD-Core Version:    0.7.0.1
 */