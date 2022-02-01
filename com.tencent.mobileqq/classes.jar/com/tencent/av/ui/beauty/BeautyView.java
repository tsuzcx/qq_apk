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
import bfur;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.FadingHorizontalScrollView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import loi;
import mbr;
import mly;
import mlz;
import mma;
import mqu;
import mtz;
import mum;

public class BeautyView
  extends BeautyBaseView
{
  static final Object[][] jdField_a_of_type_Array2dOfJavaLangObject;
  int jdField_a_of_type_Int = 0;
  public final Button a;
  final LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  final FadingHorizontalScrollView jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView;
  final BeautySeekView jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView;
  final ArrayList<mma> jdField_a_of_type_JavaUtilArrayList = new ArrayList(12);
  private boolean jdField_a_of_type_Boolean = true;
  VideoAppInterface b;
  
  static
  {
    Object[] arrayOfObject1 = { "BEAUTY_SKIN", Integer.valueOf(2131694931), Integer.valueOf(2130841951) };
    Object[] arrayOfObject2 = { "FACE_SHAPE_4", Integer.valueOf(2131694915), Integer.valueOf(2130841942) };
    Object[] arrayOfObject3 = { "COLOR_TONE", Integer.valueOf(2131694930), Integer.valueOf(2130841952) };
    Object[] arrayOfObject4 = { "FACE_V", Integer.valueOf(2131694918), Integer.valueOf(2130841945) };
    Object[] arrayOfObject5 = { "FACE_THIN", Integer.valueOf(2131694917), Integer.valueOf(2130841943) };
    Object[] arrayOfObject6 = { "CHIN", Integer.valueOf(2131694913), Integer.valueOf(2130841941) };
    Object[] arrayOfObject7 = { "ENLARGE_EYE", Integer.valueOf(2131694914), Integer.valueOf(2130841946) };
    Object[] arrayOfObject8 = { "EYE_LIGHTEN", Integer.valueOf(2131694922), Integer.valueOf(2130841947) };
    Object[] arrayOfObject9 = { "MOUTH_SHAPE", Integer.valueOf(2131694924), Integer.valueOf(2130841949) };
    Object[] arrayOfObject10 = { "TOOTH_WHITEN", Integer.valueOf(2131694938), Integer.valueOf(2130841954) };
    jdField_a_of_type_Array2dOfJavaLangObject = new Object[][] { arrayOfObject1, arrayOfObject2, arrayOfObject3, arrayOfObject4, arrayOfObject5, { "FACE_SHORTEN", Integer.valueOf(2131694916), Integer.valueOf(2130841944) }, arrayOfObject6, arrayOfObject7, arrayOfObject8, { "NOSE_THIN", Integer.valueOf(2131694927), Integer.valueOf(2130841953) }, arrayOfObject9, arrayOfObject10 };
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
    inflate(paramContext, 2131559750, this);
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView = ((BeautySeekView)findViewById(2131363409));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363388));
    this.jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView = ((FadingHorizontalScrollView)findViewById(2131363405));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363404));
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
      a(this.jdField_a_of_type_AndroidWidgetButton, 2131694912, 2130841950, 2131165951, Integer.valueOf(2131363388));
      paramContext = BaseApplicationImpl.getApplication().getRuntime();
      if (!(paramContext instanceof VideoAppInterface)) {
        break label426;
      }
      this.b = ((VideoAppInterface)paramContext);
      if (mbr.b(this.b.getCurrentAccountUin()) != 0) {
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
      Object localObject = new mma();
      ((mma)localObject).jdField_a_of_type_JavaLangString = ((String)jdField_a_of_type_Array2dOfJavaLangObject[paramInt][0]);
      ((mma)localObject).jdField_a_of_type_Int = ((Integer)jdField_a_of_type_Array2dOfJavaLangObject[paramInt][1]).intValue();
      ((mma)localObject).b = ((Integer)jdField_a_of_type_Array2dOfJavaLangObject[paramInt][2]).intValue();
      ((mma)localObject).c = paramContext.a(((mma)localObject).jdField_a_of_type_JavaLangString);
      ((mma)localObject).f = paramContext.b(((mma)localObject).jdField_a_of_type_JavaLangString);
      ((mma)localObject).e = paramInt;
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      paramAttributeSet = a((mma)localObject);
      localObject = new LinearLayout.LayoutParams(Math.max(i, ((mma)localObject).d), -2);
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
      paramContext = new loi();
      break label233;
      label437:
      paramAttributeSet.setSelected(false);
    }
    label445:
    b();
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.setBeautySeekActionListener(this);
  }
  
  View a(mma parammma)
  {
    Button localButton = new Button(getContext());
    a(localButton, parammma.jdField_a_of_type_Int, parammma.b, 2131165950, parammma);
    parammma.d = ((int)Math.max(mum.a(localButton), AIOUtils.dp2px(28.0F, getResources())));
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
        mma localmma = (mma)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        localmma.c = ((loi)localObject).a(localmma.jdField_a_of_type_JavaLangString);
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
    mtz localmtz = mtz.a(localResources, paramInt2, paramInt3);
    localmtz.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    paramButton.setCompoundDrawables(null, localmtz, null, null);
    paramButton.setTextColor(localResources.getColorStateList(paramInt3));
    paramButton.setText(paramInt1);
    paramButton.setBackgroundDrawable(null);
    paramButton.setOnClickListener(this);
    paramButton.setTag(2131372109, paramObject);
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
      mma localmma;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localmma = (mma)localIterator.next();
      } while (!paramString.equals(localmma.jdField_a_of_type_JavaLangString));
      for (;;)
      {
        if (localmma == null) {
          break label146;
        }
        switch (paramInt1)
        {
        case 1: 
        default: 
          return;
        case 2: 
          localmma.c = paramInt2;
          if (this.b == null) {
            break;
          }
          this.b.a(paramString, paramInt2, false);
          return;
        case 3: 
          localmma.c = paramInt2;
          if (this.b != null) {
            this.b.a(paramString, paramInt2, true);
          }
          mqu.a("0X800A569", localmma.e + 1);
          return;
          localmma = null;
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
        localObject1 = (mma)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      }
    }
    if (localObject1 != null) {
      this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.a(localResources.getString(((mma)localObject1).jdField_a_of_type_Int), ((mma)localObject1).jdField_a_of_type_JavaLangString, ((mma)localObject1).c, ((mma)localObject1).f);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        if (this.b != null) {
          mbr.a(this.b.getCurrentAccountUin(), 1);
        }
        bfur.a((Activity)getContext(), getResources().getString(2131694928), 2131690620, 2131694201, new mly(this), new mlz(this)).show();
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
            mma localmma = (mma)((Iterator)localObject).next();
            localmma.c = this.b.b(localmma.jdField_a_of_type_JavaLangString);
          }
        }
        b();
      }
      localObject = paramView.getTag(2131372109);
    } while (!(localObject instanceof mma));
    Object localObject = (mma)localObject;
    if (((mma)localObject).e == this.jdField_a_of_type_Int) {}
    for (;;)
    {
      mqu.a("0X800A568", ((mma)localObject).e + 1);
      break;
      if ((this.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_Int < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_a_of_type_Int).setSelected(false);
      }
      paramView.setSelected(true);
      this.jdField_a_of_type_Int = ((mma)localObject).e;
      b();
    }
  }
  
  public void setAppInterface(VideoAppInterface paramVideoAppInterface)
  {
    super.setAppInterface(paramVideoAppInterface);
    if (this.b != null)
    {
      if (mbr.b(this.b.getCurrentAccountUin()) == 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_Boolean = bool;
        paramVideoAppInterface = this.b.a();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          mma localmma = (mma)localIterator.next();
          if (localmma != null) {
            localmma.c = paramVideoAppInterface.a(localmma.jdField_a_of_type_JavaLangString);
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