package com.tencent.av.ui.beauty;

import actj;
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
import bbdj;
import bbll;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.FadingHorizontalScrollView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import lpn;
import mlv;
import mlw;
import mlx;
import mqo;
import mtp;
import muc;

public class BeautyView
  extends BeautyBaseView
{
  static final Object[][] jdField_a_of_type_Array2dOfJavaLangObject;
  int jdField_a_of_type_Int = 0;
  public final Button a;
  final LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  final FadingHorizontalScrollView jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView;
  final BeautySeekView jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView;
  final ArrayList<mlx> jdField_a_of_type_JavaUtilArrayList = new ArrayList(12);
  private boolean jdField_a_of_type_Boolean = true;
  VideoAppInterface b;
  
  static
  {
    Object[] arrayOfObject1 = { "BEAUTY_SKIN", Integer.valueOf(2131695711), Integer.valueOf(2130841433) };
    Object[] arrayOfObject2 = { "FACE_SHAPE_4", Integer.valueOf(2131695695), Integer.valueOf(2130841424) };
    Object[] arrayOfObject3 = { "COLOR_TONE", Integer.valueOf(2131695710), Integer.valueOf(2130841434) };
    Object[] arrayOfObject4 = { "FACE_THIN", Integer.valueOf(2131695697), Integer.valueOf(2130841425) };
    Object[] arrayOfObject5 = { "FACE_SHORTEN", Integer.valueOf(2131695696), Integer.valueOf(2130841426) };
    Object[] arrayOfObject6 = { "CHIN", Integer.valueOf(2131695693), Integer.valueOf(2130841423) };
    Object[] arrayOfObject7 = { "NOSE_THIN", Integer.valueOf(2131695707), Integer.valueOf(2130841435) };
    Object[] arrayOfObject8 = { "MOUTH_SHAPE", Integer.valueOf(2131695704), Integer.valueOf(2130841431) };
    Object[] arrayOfObject9 = { "TOOTH_WHITEN", Integer.valueOf(2131695718), Integer.valueOf(2130841436) };
    jdField_a_of_type_Array2dOfJavaLangObject = new Object[][] { arrayOfObject1, arrayOfObject2, arrayOfObject3, { "FACE_V", Integer.valueOf(2131695698), Integer.valueOf(2130841427) }, arrayOfObject4, arrayOfObject5, arrayOfObject6, { "ENLARGE_EYE", Integer.valueOf(2131695694), Integer.valueOf(2130841428) }, { "EYE_LIGHTEN", Integer.valueOf(2131695702), Integer.valueOf(2130841429) }, arrayOfObject7, arrayOfObject8, arrayOfObject9 };
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
    inflate(paramContext, 2131559553, this);
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView = ((BeautySeekView)findViewById(2131363135));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363114));
    this.jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView = ((FadingHorizontalScrollView)findViewById(2131363131));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363130));
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
      a(this.jdField_a_of_type_AndroidWidgetButton, 2131695692, 2130841432, 2131165839, Integer.valueOf(2131363114));
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
      Object localObject = new mlx();
      ((mlx)localObject).jdField_a_of_type_JavaLangString = ((String)jdField_a_of_type_Array2dOfJavaLangObject[paramInt][0]);
      ((mlx)localObject).jdField_a_of_type_Int = ((Integer)jdField_a_of_type_Array2dOfJavaLangObject[paramInt][1]).intValue();
      ((mlx)localObject).b = ((Integer)jdField_a_of_type_Array2dOfJavaLangObject[paramInt][2]).intValue();
      ((mlx)localObject).c = paramContext.a(((mlx)localObject).jdField_a_of_type_JavaLangString);
      ((mlx)localObject).f = paramContext.b(((mlx)localObject).jdField_a_of_type_JavaLangString);
      ((mlx)localObject).e = paramInt;
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      paramAttributeSet = a((mlx)localObject);
      localObject = new LinearLayout.LayoutParams(Math.max(i, ((mlx)localObject).d), -2);
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
      paramContext = new lpn();
      break label233;
      label437:
      paramAttributeSet.setSelected(false);
    }
    label445:
    b();
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.setBeautySeekActionListener(this);
  }
  
  View a(mlx parammlx)
  {
    Button localButton = new Button(getContext());
    a(localButton, parammlx.jdField_a_of_type_Int, parammlx.b, 2131165838, parammlx);
    parammlx.d = ((int)Math.max(muc.a(localButton), actj.a(28.0F, getResources())));
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
        mlx localmlx = (mlx)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        localmlx.c = ((lpn)localObject).a(localmlx.jdField_a_of_type_JavaLangString);
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
    mtp localmtp = mtp.a(localResources, paramInt2, paramInt3);
    localmtp.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    paramButton.setCompoundDrawables(null, localmtp, null, null);
    paramButton.setTextColor(localResources.getColorStateList(paramInt3));
    paramButton.setText(paramInt1);
    paramButton.setBackgroundDrawable(null);
    paramButton.setOnClickListener(this);
    paramButton.setTag(2131371127, paramObject);
    paramButton.setTextSize(bbll.e(actj.a(12.0F, getResources())));
    paramButton.setCompoundDrawablePadding(actj.a(8.0F, getResources()));
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {}
    label146:
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      mlx localmlx;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localmlx = (mlx)localIterator.next();
      } while (!paramString.equals(localmlx.jdField_a_of_type_JavaLangString));
      for (;;)
      {
        if (localmlx == null) {
          break label146;
        }
        switch (paramInt1)
        {
        case 1: 
        default: 
          return;
        case 2: 
          localmlx.c = paramInt2;
          if (this.b == null) {
            break;
          }
          this.b.a(paramString, paramInt2, false);
          return;
        case 3: 
          localmlx.c = paramInt2;
          if (this.b != null) {
            this.b.a(paramString, paramInt2, true);
          }
          mqo.a("0X800A569", localmlx.e + 1);
          return;
          localmlx = null;
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
        localObject1 = (mlx)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      }
    }
    if (localObject1 != null) {
      this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.a(localResources.getString(((mlx)localObject1).jdField_a_of_type_Int), ((mlx)localObject1).jdField_a_of_type_JavaLangString, ((mlx)localObject1).c, ((mlx)localObject1).f);
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
        bbdj.a((Activity)getContext(), getResources().getString(2131695708), 2131690596, 2131694794, new mlv(this), new mlw(this)).show();
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
          localObject = (mlx)paramView.next();
          ((mlx)localObject).c = this.b.b(((mlx)localObject).jdField_a_of_type_JavaLangString);
        }
      }
      b();
      return;
      localObject = paramView.getTag(2131371127);
    } while (!(localObject instanceof mlx));
    Object localObject = (mlx)localObject;
    if (((mlx)localObject).e == this.jdField_a_of_type_Int) {}
    for (;;)
    {
      mqo.a("0X800A568", ((mlx)localObject).e + 1);
      return;
      if ((this.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_Int < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_a_of_type_Int).setSelected(false);
      }
      paramView.setSelected(true);
      this.jdField_a_of_type_Int = ((mlx)localObject).e;
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
          mlx localmlx = (mlx)localIterator.next();
          if (localmlx != null) {
            localmlx.c = paramVideoAppInterface.a(localmlx.jdField_a_of_type_JavaLangString);
          }
        }
      }
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.beauty.BeautyView
 * JD-Core Version:    0.7.0.1
 */