package com.tencent.av.ui;

import aciy;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import babr;
import bajq;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import lfa;
import lrj;
import lwn;
import lwo;
import lwp;
import mfs;
import mit;
import mjg;

public class QavBeautyMenuPanel
  extends RelativeLayout
  implements View.OnClickListener, lrj
{
  static final Object[][] jdField_a_of_type_Array2dOfJavaLangObject = { { "BEAUTY_SKIN", Integer.valueOf(2131630027), Integer.valueOf(2130841355) }, { "FACE_SHAPE_4", Integer.valueOf(2131630013), Integer.valueOf(2130841346) }, { "COLOR_TONE", Integer.valueOf(2131630026), Integer.valueOf(2130841356) }, { "FACE_V", Integer.valueOf(2131630016), Integer.valueOf(2130841349) }, { "FACE_THIN", Integer.valueOf(2131630015), Integer.valueOf(2130841347) }, { "FACE_SHORTEN", Integer.valueOf(2131630014), Integer.valueOf(2130841348) }, { "CHIN", Integer.valueOf(2131630011), Integer.valueOf(2130841345) }, { "ENLARGE_EYE", Integer.valueOf(2131630012), Integer.valueOf(2130841350) }, { "EYE_LIGHTEN", Integer.valueOf(2131630020), Integer.valueOf(2130841351) }, { "NOSE_THIN", Integer.valueOf(2131630023), Integer.valueOf(2130841357) }, { "MOUTH_SHAPE", Integer.valueOf(2131630022), Integer.valueOf(2130841353) }, { "TOOTH_WHITEN", Integer.valueOf(2131630030), Integer.valueOf(2130841358) } };
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  public final Button a;
  final LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  final BeautySeekView jdField_a_of_type_ComTencentAvUiBeautySeekView;
  final FadingHorizontalScrollView jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView;
  final ArrayList<lwp> jdField_a_of_type_JavaUtilArrayList = new ArrayList(12);
  private boolean jdField_a_of_type_Boolean = true;
  
  public QavBeautyMenuPanel(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QavBeautyMenuPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QavBeautyMenuPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflate(paramContext, 2131493983, this);
    this.jdField_a_of_type_ComTencentAvUiBeautySeekView = ((BeautySeekView)findViewById(2131297586));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131297564));
    this.jdField_a_of_type_ComTencentAvUiFadingHorizontalScrollView = ((FadingHorizontalScrollView)findViewById(2131297581));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297580));
    setBackgroundResource(2130841579);
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
      a(this.jdField_a_of_type_AndroidWidgetButton, 2131630010, 2130841354, 2131100249, Integer.valueOf(2131297564));
      paramContext = BaseApplicationImpl.getApplication().getRuntime();
      if (!(paramContext instanceof VideoAppInterface)) {
        break label432;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)paramContext);
      if (AVNotifyCenter.c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()) != 0) {
        break label426;
      }
      bool = true;
      label225:
      this.jdField_a_of_type_Boolean = bool;
      paramContext = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      label239:
      paramInt = 0;
      label241:
      if (paramInt >= jdField_a_of_type_Array2dOfJavaLangObject.length) {
        break label451;
      }
      Object localObject = new lwp();
      ((lwp)localObject).jdField_a_of_type_JavaLangString = ((String)jdField_a_of_type_Array2dOfJavaLangObject[paramInt][0]);
      ((lwp)localObject).jdField_a_of_type_Int = ((Integer)jdField_a_of_type_Array2dOfJavaLangObject[paramInt][1]).intValue();
      ((lwp)localObject).b = ((Integer)jdField_a_of_type_Array2dOfJavaLangObject[paramInt][2]).intValue();
      ((lwp)localObject).c = paramContext.a(((lwp)localObject).jdField_a_of_type_JavaLangString);
      ((lwp)localObject).f = paramContext.b(((lwp)localObject).jdField_a_of_type_JavaLangString);
      ((lwp)localObject).e = paramInt;
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      paramAttributeSet = a((lwp)localObject);
      localObject = new LinearLayout.LayoutParams(Math.max(i, ((lwp)localObject).d), -2);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramAttributeSet, (ViewGroup.LayoutParams)localObject);
      if (this.jdField_a_of_type_Int != paramInt) {
        break label443;
      }
      paramAttributeSet.setSelected(true);
    }
    for (;;)
    {
      paramInt += 1;
      break label241;
      paramContext.width = i;
      paramContext.height = -2;
      break;
      label426:
      bool = false;
      break label225;
      label432:
      paramContext = new lfa();
      break label239;
      label443:
      paramAttributeSet.setSelected(false);
    }
    label451:
    b();
    this.jdField_a_of_type_ComTencentAvUiBeautySeekView.setBeautySeekActionListener(this);
  }
  
  View a(lwp paramlwp)
  {
    Button localButton = new Button(getContext());
    a(localButton, paramlwp.jdField_a_of_type_Int, paramlwp.b, 2131100248, paramlwp);
    paramlwp.d = ((int)Math.max(mjg.a(localButton), aciy.a(28.0F, getResources())));
    return localButton;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        lwp locallwp = (lwp)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        locallwp.c = ((lfa)localObject).a(locallwp.jdField_a_of_type_JavaLangString);
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
    mit localmit = mit.a(localResources, paramInt2, paramInt3);
    localmit.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    paramButton.setCompoundDrawables(null, localmit, null, null);
    paramButton.setTextColor(localResources.getColorStateList(paramInt3));
    paramButton.setText(paramInt1);
    paramButton.setBackgroundDrawable(null);
    paramButton.setOnClickListener(this);
    paramButton.setTag(2131305434, paramObject);
    paramButton.setTextSize(bajq.e(aciy.a(12.0F, getResources())));
    paramButton.setCompoundDrawablePadding(aciy.a(8.0F, getResources()));
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {}
    label146:
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      lwp locallwp;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        locallwp = (lwp)localIterator.next();
      } while (!paramString.equals(locallwp.jdField_a_of_type_JavaLangString));
      for (;;)
      {
        if (locallwp == null) {
          break label146;
        }
        switch (paramInt1)
        {
        case 1: 
        default: 
          return;
        case 2: 
          locallwp.c = paramInt2;
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramString, paramInt2, false);
          return;
        case 3: 
          locallwp.c = paramInt2;
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramString, paramInt2, true);
          }
          mfs.a("0X800A569", locallwp.e + 1);
          return;
          locallwp = null;
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
        localObject1 = (lwp)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      }
    }
    if (localObject1 != null) {
      this.jdField_a_of_type_ComTencentAvUiBeautySeekView.a(localResources.getString(((lwp)localObject1).jdField_a_of_type_Int), ((lwp)localObject1).jdField_a_of_type_JavaLangString, ((lwp)localObject1).c, ((lwp)localObject1).f);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    long l = SystemClock.elapsedRealtime();
    if (((i & 0xFF) != 2) || (Math.abs(l - this.jdField_a_of_type_Long) > 200L))
    {
      this.jdField_a_of_type_Long = l;
      EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, -1043L);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
          AVNotifyCenter.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), 1);
        }
        babr.a((Activity)getContext(), getResources().getString(2131630024), 2131625035, 2131629116, new lwn(this), new lwo(this)).show();
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d();
        paramView = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramView.hasNext())
        {
          localObject = (lwp)paramView.next();
          ((lwp)localObject).c = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(((lwp)localObject).jdField_a_of_type_JavaLangString);
        }
      }
      b();
      return;
      localObject = paramView.getTag(2131305434);
    } while (!(localObject instanceof lwp));
    Object localObject = (lwp)localObject;
    if (((lwp)localObject).e == this.jdField_a_of_type_Int) {}
    for (;;)
    {
      mfs.a("0X800A568", ((lwp)localObject).e + 1);
      return;
      if ((this.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_Int < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_a_of_type_Int).setSelected(false);
      }
      paramView.setSelected(true);
      this.jdField_a_of_type_Int = ((lwp)localObject).e;
      b();
    }
  }
  
  public void setAppInterface(VideoAppInterface paramVideoAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != paramVideoAppInterface)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
      {
        if (AVNotifyCenter.c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()) == 0) {}
        for (boolean bool = true;; bool = false)
        {
          this.jdField_a_of_type_Boolean = bool;
          paramVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext())
          {
            lwp locallwp = (lwp)localIterator.next();
            if (locallwp != null) {
              locallwp.c = paramVideoAppInterface.a(locallwp.jdField_a_of_type_JavaLangString);
            }
          }
        }
        b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.QavBeautyMenuPanel
 * JD-Core Version:    0.7.0.1
 */