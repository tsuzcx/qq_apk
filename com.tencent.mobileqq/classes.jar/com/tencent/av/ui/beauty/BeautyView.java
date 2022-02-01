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
import bhdj;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.FadingHorizontalScrollView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import lov;
import mcm;
import mmv;
import mmw;
import mmx;
import mrr;
import mux;
import mvk;

public class BeautyView
  extends BeautyBaseView
{
  static final Object[][] jdField_a_of_type_Array2dOfJavaLangObject;
  int jdField_a_of_type_Int = 0;
  public final Button a;
  final LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  final FadingHorizontalScrollView jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView;
  final BeautySeekView jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView;
  final ArrayList<mmx> jdField_a_of_type_JavaUtilArrayList = new ArrayList(12);
  private boolean jdField_a_of_type_Boolean = true;
  VideoAppInterface b;
  
  static
  {
    Object[] arrayOfObject1 = { "FACE_THIN", Integer.valueOf(2131695133), Integer.valueOf(2130841956) };
    Object[] arrayOfObject2 = { "FACE_SHORTEN", Integer.valueOf(2131695132), Integer.valueOf(2130841957) };
    Object[] arrayOfObject3 = { "EYE_LIGHTEN", Integer.valueOf(2131695138), Integer.valueOf(2130841960) };
    jdField_a_of_type_Array2dOfJavaLangObject = new Object[][] { { "BEAUTY_SKIN", Integer.valueOf(2131695147), Integer.valueOf(2130841964) }, { "FACE_SHAPE_4", Integer.valueOf(2131695131), Integer.valueOf(2130841955) }, { "COLOR_TONE", Integer.valueOf(2131695146), Integer.valueOf(2130841965) }, { "FACE_V", Integer.valueOf(2131695134), Integer.valueOf(2130841958) }, arrayOfObject1, arrayOfObject2, { "CHIN", Integer.valueOf(2131695129), Integer.valueOf(2130841954) }, { "ENLARGE_EYE", Integer.valueOf(2131695130), Integer.valueOf(2130841959) }, arrayOfObject3, { "NOSE_THIN", Integer.valueOf(2131695143), Integer.valueOf(2130841966) }, { "MOUTH_SHAPE", Integer.valueOf(2131695140), Integer.valueOf(2130841962) }, { "TOOTH_WHITEN", Integer.valueOf(2131695154), Integer.valueOf(2130841967) } };
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
    inflate(paramContext, 2131559786, this);
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView = ((BeautySeekView)findViewById(2131363478));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363457));
    this.jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView = ((FadingHorizontalScrollView)findViewById(2131363474));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363473));
    int i = (int)(ImmersiveUtils.a() / 5.6F);
    this.jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView.setFadingMode(1);
    this.jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView.setFadingEdgeLength(i / 2);
    this.jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView.setOverScrollMode(2);
    paramContext = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
    boolean bool;
    if (paramContext == null)
    {
      paramContext = new RelativeLayout.LayoutParams(i, -2);
      this.jdField_a_of_type_AndroidWidgetButton.setLayoutParams(paramContext);
      a(this.jdField_a_of_type_AndroidWidgetButton, 2131695128, 2130841963, 2131165960, Integer.valueOf(2131363457));
      paramContext = BaseApplicationImpl.getApplication().getRuntime();
      if (!(paramContext instanceof VideoAppInterface)) {
        break label426;
      }
      this.b = ((VideoAppInterface)paramContext);
      if (mcm.b(this.b.getCurrentAccountUin()) != 0) {
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
      Object localObject = new mmx();
      ((mmx)localObject).jdField_a_of_type_JavaLangString = ((String)jdField_a_of_type_Array2dOfJavaLangObject[paramInt][0]);
      ((mmx)localObject).jdField_a_of_type_Int = ((Integer)jdField_a_of_type_Array2dOfJavaLangObject[paramInt][1]).intValue();
      ((mmx)localObject).b = ((Integer)jdField_a_of_type_Array2dOfJavaLangObject[paramInt][2]).intValue();
      ((mmx)localObject).c = paramContext.a(((mmx)localObject).jdField_a_of_type_JavaLangString);
      ((mmx)localObject).f = paramContext.b(((mmx)localObject).jdField_a_of_type_JavaLangString);
      ((mmx)localObject).e = paramInt;
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      paramAttributeSet = a((mmx)localObject);
      localObject = new LinearLayout.LayoutParams(Math.max(i, ((mmx)localObject).d), -2);
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
      paramContext = new lov();
      break label233;
      label437:
      paramAttributeSet.setSelected(false);
    }
    label445:
    b();
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.setBeautySeekActionListener(this);
  }
  
  View a(mmx parammmx)
  {
    Button localButton = new Button(getContext());
    a(localButton, parammmx.jdField_a_of_type_Int, parammmx.b, 2131165959, parammmx);
    parammmx.d = ((int)Math.max(mvk.a(localButton), AIOUtils.dp2px(28.0F, getResources())));
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
        mmx localmmx = (mmx)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        localmmx.c = ((lov)localObject).a(localmmx.jdField_a_of_type_JavaLangString);
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
    mux localmux = mux.a(localResources, paramInt2, paramInt3);
    localmux.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    paramButton.setCompoundDrawables(null, localmux, null, null);
    paramButton.setTextColor(localResources.getColorStateList(paramInt3));
    paramButton.setText(paramInt1);
    paramButton.setBackgroundDrawable(null);
    paramButton.setOnClickListener(this);
    paramButton.setTag(2131372302, paramObject);
    paramButton.setTextSize(ViewUtils.pxTosp(AIOUtils.dp2px(12.0F, getResources())));
    paramButton.setCompoundDrawablePadding(AIOUtils.dp2px(8.0F, getResources()));
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {}
    label146:
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      mmx localmmx;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localmmx = (mmx)localIterator.next();
      } while (!paramString.equals(localmmx.jdField_a_of_type_JavaLangString));
      for (;;)
      {
        if (localmmx == null) {
          break label146;
        }
        switch (paramInt1)
        {
        case 1: 
        default: 
          return;
        case 2: 
          localmmx.c = paramInt2;
          if (this.b == null) {
            break;
          }
          this.b.a(paramString, paramInt2, false);
          return;
        case 3: 
          localmmx.c = paramInt2;
          if (this.b != null) {
            this.b.a(paramString, paramInt2, true);
          }
          mrr.a("0X800A569", localmmx.e + 1);
          return;
          localmmx = null;
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
        localObject1 = (mmx)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      }
    }
    if (localObject1 != null) {
      this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.a(localResources.getString(((mmx)localObject1).jdField_a_of_type_Int), ((mmx)localObject1).jdField_a_of_type_JavaLangString, ((mmx)localObject1).c, ((mmx)localObject1).f);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        if (this.b != null) {
          mcm.a(this.b.getCurrentAccountUin(), 1);
        }
        bhdj.a((Activity)getContext(), getResources().getString(2131695144), 2131690697, 2131694399, new mmv(this), new mmw(this)).show();
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
            mmx localmmx = (mmx)((Iterator)localObject).next();
            localmmx.c = this.b.b(localmmx.jdField_a_of_type_JavaLangString);
          }
        }
        b();
      }
      localObject = paramView.getTag(2131372302);
    } while (!(localObject instanceof mmx));
    Object localObject = (mmx)localObject;
    if (((mmx)localObject).e == this.jdField_a_of_type_Int) {}
    for (;;)
    {
      mrr.a("0X800A568", ((mmx)localObject).e + 1);
      break;
      if ((this.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_Int < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_a_of_type_Int).setSelected(false);
      }
      paramView.setSelected(true);
      this.jdField_a_of_type_Int = ((mmx)localObject).e;
      b();
    }
  }
  
  public void setAppInterface(VideoAppInterface paramVideoAppInterface)
  {
    super.setAppInterface(paramVideoAppInterface);
    if (this.b != null)
    {
      if (mcm.b(this.b.getCurrentAccountUin()) == 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_Boolean = bool;
        paramVideoAppInterface = this.b.a();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          mmx localmmx = (mmx)localIterator.next();
          if (localmmx != null) {
            localmmx.c = paramVideoAppInterface.a(localmmx.jdField_a_of_type_JavaLangString);
          }
        }
      }
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.beauty.BeautyView
 * JD-Core Version:    0.7.0.1
 */