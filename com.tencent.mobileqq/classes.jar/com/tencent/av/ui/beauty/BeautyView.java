package com.tencent.av.ui.beauty;

import agej;
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
import bhlq;
import bhtq;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.FadingHorizontalScrollView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import lpa;
import mci;
import mmp;
import mmq;
import mmr;
import mrl;
import muq;
import mvd;

public class BeautyView
  extends BeautyBaseView
{
  static final Object[][] jdField_a_of_type_Array2dOfJavaLangObject;
  int jdField_a_of_type_Int = 0;
  public final Button a;
  final LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  final FadingHorizontalScrollView jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView;
  final BeautySeekView jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView;
  final ArrayList<mmr> jdField_a_of_type_JavaUtilArrayList = new ArrayList(12);
  private boolean jdField_a_of_type_Boolean = true;
  VideoAppInterface b;
  
  static
  {
    Object[] arrayOfObject = { "FACE_SHORTEN", Integer.valueOf(2131694778), Integer.valueOf(2130841902) };
    jdField_a_of_type_Array2dOfJavaLangObject = new Object[][] { { "BEAUTY_SKIN", Integer.valueOf(2131694793), Integer.valueOf(2130841909) }, { "FACE_SHAPE_4", Integer.valueOf(2131694777), Integer.valueOf(2130841900) }, { "COLOR_TONE", Integer.valueOf(2131694792), Integer.valueOf(2130841910) }, { "FACE_V", Integer.valueOf(2131694780), Integer.valueOf(2130841903) }, { "FACE_THIN", Integer.valueOf(2131694779), Integer.valueOf(2130841901) }, arrayOfObject, { "CHIN", Integer.valueOf(2131694775), Integer.valueOf(2130841899) }, { "ENLARGE_EYE", Integer.valueOf(2131694776), Integer.valueOf(2130841904) }, { "EYE_LIGHTEN", Integer.valueOf(2131694784), Integer.valueOf(2130841905) }, { "NOSE_THIN", Integer.valueOf(2131694789), Integer.valueOf(2130841911) }, { "MOUTH_SHAPE", Integer.valueOf(2131694786), Integer.valueOf(2130841907) }, { "TOOTH_WHITEN", Integer.valueOf(2131694800), Integer.valueOf(2130841912) } };
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
    inflate(paramContext, 2131559748, this);
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView = ((BeautySeekView)findViewById(2131363382));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363361));
    this.jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView = ((FadingHorizontalScrollView)findViewById(2131363378));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363377));
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
      a(this.jdField_a_of_type_AndroidWidgetButton, 2131694774, 2130841908, 2131165933, Integer.valueOf(2131363361));
      paramContext = BaseApplicationImpl.getApplication().getRuntime();
      if (!(paramContext instanceof VideoAppInterface)) {
        break label426;
      }
      this.b = ((VideoAppInterface)paramContext);
      if (mci.b(this.b.getCurrentAccountUin()) != 0) {
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
      Object localObject = new mmr();
      ((mmr)localObject).jdField_a_of_type_JavaLangString = ((String)jdField_a_of_type_Array2dOfJavaLangObject[paramInt][0]);
      ((mmr)localObject).jdField_a_of_type_Int = ((Integer)jdField_a_of_type_Array2dOfJavaLangObject[paramInt][1]).intValue();
      ((mmr)localObject).b = ((Integer)jdField_a_of_type_Array2dOfJavaLangObject[paramInt][2]).intValue();
      ((mmr)localObject).c = paramContext.a(((mmr)localObject).jdField_a_of_type_JavaLangString);
      ((mmr)localObject).f = paramContext.b(((mmr)localObject).jdField_a_of_type_JavaLangString);
      ((mmr)localObject).e = paramInt;
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      paramAttributeSet = a((mmr)localObject);
      localObject = new LinearLayout.LayoutParams(Math.max(i, ((mmr)localObject).d), -2);
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
      paramContext = new lpa();
      break label233;
      label437:
      paramAttributeSet.setSelected(false);
    }
    label445:
    b();
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.setBeautySeekActionListener(this);
  }
  
  View a(mmr parammmr)
  {
    Button localButton = new Button(getContext());
    a(localButton, parammmr.jdField_a_of_type_Int, parammmr.b, 2131165932, parammmr);
    parammmr.d = ((int)Math.max(mvd.a(localButton), agej.a(28.0F, getResources())));
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
        mmr localmmr = (mmr)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        localmmr.c = ((lpa)localObject).a(localmmr.jdField_a_of_type_JavaLangString);
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
    muq localmuq = muq.a(localResources, paramInt2, paramInt3);
    localmuq.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    paramButton.setCompoundDrawables(null, localmuq, null, null);
    paramButton.setTextColor(localResources.getColorStateList(paramInt3));
    paramButton.setText(paramInt1);
    paramButton.setBackgroundDrawable(null);
    paramButton.setOnClickListener(this);
    paramButton.setTag(2131372144, paramObject);
    paramButton.setTextSize(bhtq.e(agej.a(12.0F, getResources())));
    paramButton.setCompoundDrawablePadding(agej.a(8.0F, getResources()));
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {}
    label146:
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      mmr localmmr;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localmmr = (mmr)localIterator.next();
      } while (!paramString.equals(localmmr.jdField_a_of_type_JavaLangString));
      for (;;)
      {
        if (localmmr == null) {
          break label146;
        }
        switch (paramInt1)
        {
        case 1: 
        default: 
          return;
        case 2: 
          localmmr.c = paramInt2;
          if (this.b == null) {
            break;
          }
          this.b.a(paramString, paramInt2, false);
          return;
        case 3: 
          localmmr.c = paramInt2;
          if (this.b != null) {
            this.b.a(paramString, paramInt2, true);
          }
          mrl.a("0X800A569", localmmr.e + 1);
          return;
          localmmr = null;
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
        localObject1 = (mmr)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      }
    }
    if (localObject1 != null) {
      this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.a(localResources.getString(((mmr)localObject1).jdField_a_of_type_Int), ((mmr)localObject1).jdField_a_of_type_JavaLangString, ((mmr)localObject1).c, ((mmr)localObject1).f);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        if (this.b != null) {
          mci.a(this.b.getCurrentAccountUin(), 1);
        }
        bhlq.a((Activity)getContext(), getResources().getString(2131694790), 2131690580, 2131694098, new mmp(this), new mmq(this)).show();
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
            mmr localmmr = (mmr)((Iterator)localObject).next();
            localmmr.c = this.b.b(localmmr.jdField_a_of_type_JavaLangString);
          }
        }
        b();
      }
      localObject = paramView.getTag(2131372144);
    } while (!(localObject instanceof mmr));
    Object localObject = (mmr)localObject;
    if (((mmr)localObject).e == this.jdField_a_of_type_Int) {}
    for (;;)
    {
      mrl.a("0X800A568", ((mmr)localObject).e + 1);
      break;
      if ((this.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_Int < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_a_of_type_Int).setSelected(false);
      }
      paramView.setSelected(true);
      this.jdField_a_of_type_Int = ((mmr)localObject).e;
      b();
    }
  }
  
  public void setAppInterface(VideoAppInterface paramVideoAppInterface)
  {
    super.setAppInterface(paramVideoAppInterface);
    if (this.b != null)
    {
      if (mci.b(this.b.getCurrentAccountUin()) == 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_Boolean = bool;
        paramVideoAppInterface = this.b.a();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          mmr localmmr = (mmr)localIterator.next();
          if (localmmr != null) {
            localmmr.c = paramVideoAppInterface.a(localmmr.jdField_a_of_type_JavaLangString);
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