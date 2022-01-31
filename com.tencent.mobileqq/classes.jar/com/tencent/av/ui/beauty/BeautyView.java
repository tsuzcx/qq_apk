package com.tencent.av.ui.beauty;

import aepi;
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
import bdgm;
import bdoo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.FadingHorizontalScrollView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import lrq;
import mop;
import moq;
import mor;
import mti;
import mwj;
import mww;

public class BeautyView
  extends BeautyBaseView
{
  static final Object[][] jdField_a_of_type_Array2dOfJavaLangObject;
  int jdField_a_of_type_Int = 0;
  public final Button a;
  final LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  final FadingHorizontalScrollView jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView;
  final BeautySeekView jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView;
  final ArrayList<mor> jdField_a_of_type_JavaUtilArrayList = new ArrayList(12);
  private boolean jdField_a_of_type_Boolean = true;
  VideoAppInterface b;
  
  static
  {
    Object[] arrayOfObject1 = { "FACE_THIN", Integer.valueOf(2131695859), Integer.valueOf(2130841586) };
    Object[] arrayOfObject2 = { "EYE_LIGHTEN", Integer.valueOf(2131695864), Integer.valueOf(2130841590) };
    Object[] arrayOfObject3 = { "NOSE_THIN", Integer.valueOf(2131695869), Integer.valueOf(2130841596) };
    Object[] arrayOfObject4 = { "TOOTH_WHITEN", Integer.valueOf(2131695880), Integer.valueOf(2130841597) };
    jdField_a_of_type_Array2dOfJavaLangObject = new Object[][] { { "BEAUTY_SKIN", Integer.valueOf(2131695873), Integer.valueOf(2130841594) }, { "FACE_SHAPE_4", Integer.valueOf(2131695857), Integer.valueOf(2130841585) }, { "COLOR_TONE", Integer.valueOf(2131695872), Integer.valueOf(2130841595) }, { "FACE_V", Integer.valueOf(2131695860), Integer.valueOf(2130841588) }, arrayOfObject1, { "FACE_SHORTEN", Integer.valueOf(2131695858), Integer.valueOf(2130841587) }, { "CHIN", Integer.valueOf(2131695855), Integer.valueOf(2130841584) }, { "ENLARGE_EYE", Integer.valueOf(2131695856), Integer.valueOf(2130841589) }, arrayOfObject2, arrayOfObject3, { "MOUTH_SHAPE", Integer.valueOf(2131695866), Integer.valueOf(2130841592) }, arrayOfObject4 };
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
    inflate(paramContext, 2131559604, this);
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView = ((BeautySeekView)findViewById(2131363171));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363150));
    this.jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView = ((FadingHorizontalScrollView)findViewById(2131363167));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363166));
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
      a(this.jdField_a_of_type_AndroidWidgetButton, 2131695854, 2130841593, 2131165877, Integer.valueOf(2131363150));
      paramContext = BaseApplicationImpl.getApplication().getRuntime();
      if (!(paramContext instanceof VideoAppInterface)) {
        break label426;
      }
      this.b = ((VideoAppInterface)paramContext);
      if (AVNotifyCenter.c(this.b.getCurrentAccountUin()) != 0) {
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
      Object localObject = new mor();
      ((mor)localObject).jdField_a_of_type_JavaLangString = ((String)jdField_a_of_type_Array2dOfJavaLangObject[paramInt][0]);
      ((mor)localObject).jdField_a_of_type_Int = ((Integer)jdField_a_of_type_Array2dOfJavaLangObject[paramInt][1]).intValue();
      ((mor)localObject).b = ((Integer)jdField_a_of_type_Array2dOfJavaLangObject[paramInt][2]).intValue();
      ((mor)localObject).c = paramContext.a(((mor)localObject).jdField_a_of_type_JavaLangString);
      ((mor)localObject).f = paramContext.b(((mor)localObject).jdField_a_of_type_JavaLangString);
      ((mor)localObject).e = paramInt;
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      paramAttributeSet = a((mor)localObject);
      localObject = new LinearLayout.LayoutParams(Math.max(i, ((mor)localObject).d), -2);
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
      paramContext = new lrq();
      break label233;
      label437:
      paramAttributeSet.setSelected(false);
    }
    label445:
    b();
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.setBeautySeekActionListener(this);
  }
  
  View a(mor parammor)
  {
    Button localButton = new Button(getContext());
    a(localButton, parammor.jdField_a_of_type_Int, parammor.b, 2131165876, parammor);
    parammor.d = ((int)Math.max(mww.a(localButton), aepi.a(28.0F, getResources())));
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
        mor localmor = (mor)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        localmor.c = ((lrq)localObject).a(localmor.jdField_a_of_type_JavaLangString);
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
    mwj localmwj = mwj.a(localResources, paramInt2, paramInt3);
    localmwj.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    paramButton.setCompoundDrawables(null, localmwj, null, null);
    paramButton.setTextColor(localResources.getColorStateList(paramInt3));
    paramButton.setText(paramInt1);
    paramButton.setBackgroundDrawable(null);
    paramButton.setOnClickListener(this);
    paramButton.setTag(2131371459, paramObject);
    paramButton.setTextSize(bdoo.e(aepi.a(12.0F, getResources())));
    paramButton.setCompoundDrawablePadding(aepi.a(8.0F, getResources()));
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {}
    label146:
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      mor localmor;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localmor = (mor)localIterator.next();
      } while (!paramString.equals(localmor.jdField_a_of_type_JavaLangString));
      for (;;)
      {
        if (localmor == null) {
          break label146;
        }
        switch (paramInt1)
        {
        case 1: 
        default: 
          return;
        case 2: 
          localmor.c = paramInt2;
          if (this.b == null) {
            break;
          }
          this.b.a(paramString, paramInt2, false);
          return;
        case 3: 
          localmor.c = paramInt2;
          if (this.b != null) {
            this.b.a(paramString, paramInt2, true);
          }
          mti.a("0X800A569", localmor.e + 1);
          return;
          localmor = null;
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
        localObject1 = (mor)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      }
    }
    if (localObject1 != null) {
      this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.a(localResources.getString(((mor)localObject1).jdField_a_of_type_Int), ((mor)localObject1).jdField_a_of_type_JavaLangString, ((mor)localObject1).c, ((mor)localObject1).f);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        if (this.b != null) {
          AVNotifyCenter.a(this.b.getCurrentAccountUin(), 1);
        }
        bdgm.a((Activity)getContext(), getResources().getString(2131695870), 2131690648, 2131694953, new mop(this), new moq(this)).show();
      }
    }
    do
    {
      return;
      if (this.b != null)
      {
        this.b.d();
        paramView = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramView.hasNext())
        {
          localObject = (mor)paramView.next();
          ((mor)localObject).c = this.b.b(((mor)localObject).jdField_a_of_type_JavaLangString);
        }
      }
      b();
      return;
      localObject = paramView.getTag(2131371459);
    } while (!(localObject instanceof mor));
    Object localObject = (mor)localObject;
    if (((mor)localObject).e == this.jdField_a_of_type_Int) {}
    for (;;)
    {
      mti.a("0X800A568", ((mor)localObject).e + 1);
      return;
      if ((this.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_Int < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_a_of_type_Int).setSelected(false);
      }
      paramView.setSelected(true);
      this.jdField_a_of_type_Int = ((mor)localObject).e;
      b();
    }
  }
  
  public void setAppInterface(VideoAppInterface paramVideoAppInterface)
  {
    super.setAppInterface(paramVideoAppInterface);
    if (this.b != null)
    {
      if (AVNotifyCenter.c(this.b.getCurrentAccountUin()) == 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_Boolean = bool;
        paramVideoAppInterface = this.b.a();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          mor localmor = (mor)localIterator.next();
          if (localmor != null) {
            localmor.c = paramVideoAppInterface.a(localmor.jdField_a_of_type_JavaLangString);
          }
        }
      }
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.beauty.BeautyView
 * JD-Core Version:    0.7.0.1
 */