package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.SentenceInfo;
import com.tencent.av.business.manager.zimu.ZimuLiveManager;
import com.tencent.av.doodle.DoodleUtils;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.GLVideoView;
import com.tencent.av.ui.ScreenLayoutDoubleScreen;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.utils.TipsManager;
import java.util.ArrayList;
import java.util.List;

public class ZimuViewLive
  extends ZimuView
  implements View.OnClickListener, View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener
{
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ListAdapter jdField_a_of_type_AndroidWidgetListAdapter;
  protected ListView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ZimuLiveManager jdField_a_of_type_ComTencentAvBusinessManagerZimuZimuLiveManager;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f;
  private int g;
  
  public ZimuViewLive(VideoAppInterface paramVideoAppInterface, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramVideoAppInterface, paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    Object localObject2 = getResources();
    Object localObject1 = ((Resources)localObject2).getDrawable(2130840193);
    this.jdField_b_of_type_AndroidViewView = new View(paramContext);
    localObject2 = new RelativeLayout.LayoutParams(-1, ((Resources)localObject2).getDimensionPixelOffset(2131560113));
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    this.jdField_b_of_type_AndroidViewView.setBackground((Drawable)localObject1);
    addView(this.jdField_b_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject2);
    localObject1 = LayoutInflater.from(paramContext).inflate(2130969281, this);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)((View)localObject1).findViewById(16908298));
    a(new ZimuViewLiveAdapter(paramContext));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)((View)localObject1).findViewById(2131365920));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131365919));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = ((View)localObject1).findViewById(2131363383);
    getViewTreeObserver().addOnGlobalLayoutListener(this);
    setFitsSystemWindows(true);
    this.jdField_a_of_type_ComTencentAvBusinessManagerZimuZimuLiveManager = ((ZimuLiveManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(9));
    if ((this.jdField_a_of_type_ComTencentAvBusinessManagerZimuZimuLiveManager.c != null) && (this.jdField_a_of_type_ComTencentAvBusinessManagerZimuZimuLiveManager.c.length() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_ComTencentAvBusinessManagerZimuZimuLiveManager.c);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentAvBusinessManagerZimuZimuLiveManager.c);
    }
  }
  
  private void a(ListAdapter paramListAdapter)
  {
    this.jdField_a_of_type_AndroidWidgetListAdapter = paramListAdapter;
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(paramListAdapter);
  }
  
  private void a(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      String str = paramString;
      if (paramString.equals("。")) {
        str = "。 ";
      }
      paramString = new SentenceInfo(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount(), str, str, 2);
      paramString.jdField_a_of_type_Boolean = true;
      a(paramString, false);
      this.jdField_a_of_type_AndroidWidgetEditText.setText(null);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a(13, str);
    }
  }
  
  private void b(int paramInt)
  {
    AVActivity localAVActivity = (AVActivity)getContext();
    boolean bool1;
    Object localObject1;
    Object localObject2;
    int i2;
    int i1;
    boolean bool2;
    label72:
    int m;
    int n;
    boolean bool3;
    label98:
    int j;
    int k;
    int i;
    if (localAVActivity.c() == 2)
    {
      bool1 = true;
      localObject1 = getRootView();
      localObject2 = new Rect();
      ((View)localObject1).getWindowVisibleDisplayFrame((Rect)localObject2);
      i2 = ((Rect)localObject2).bottom;
      i1 = localAVActivity.findViewById(2131365798).getHeight();
      if (i2 >= i1) {
        break label634;
      }
      bool2 = true;
      localObject1 = localAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
      m = 0;
      n = 2;
      if (localAVActivity.findViewById(2131366100) == null) {
        break label640;
      }
      bool3 = true;
      if (localObject1 == null) {
        break label797;
      }
      j = ((VideoLayerUI)localObject1).h();
      k = ((VideoLayerUI)localObject1).g();
      if (localObject1.a[1].f() != 0) {
        break label646;
      }
      i = 1;
      label131:
      n = ((VideoLayerUI)localObject1).b();
      m = i;
      i = k;
    }
    for (;;)
    {
      boolean bool4;
      label163:
      Resources localResources;
      if ((bool1) || (m == 0) || (n != 3))
      {
        bool4 = true;
        if ((paramInt != this.jdField_c_of_type_Int) || (this.jdField_b_of_type_Boolean != bool1) || (this.jdField_d_of_type_Int != i2) || (this.e != i1) || (this.jdField_a_of_type_Boolean != bool2) || (this.f != j) || (this.g != i) || (bool4 != this.jdField_c_of_type_Boolean) || (bool3 != this.jdField_d_of_type_Boolean))
        {
          localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
          localObject2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
          localResources = getResources();
          k = localResources.getDimensionPixelOffset(2131560105);
          if (!bool2) {
            break label657;
          }
          ((RelativeLayout.LayoutParams)localObject1).bottomMargin = 0;
          label292:
          if ((!bool1) || (bool2)) {
            break label666;
          }
          ((RelativeLayout.LayoutParams)localObject2).height = (ScreenLayoutDoubleScreen.b(i) / 2);
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = paramInt;
          label319:
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetListView.getLayoutParams();
          RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
          RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetEditText.getLayoutParams();
          if (!bool4) {
            break label687;
          }
          label360:
          localLayoutParams.rightMargin = k;
          localLayoutParams1.rightMargin = k;
          localLayoutParams2.rightMargin = k;
          if (!bool2) {
            break label700;
          }
          this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
          label410:
          this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.jdField_a_of_type_AndroidWidgetListView.setLayoutParams(localLayoutParams);
          this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams1);
          this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_AndroidWidgetEditText.setLayoutParams(localLayoutParams2);
          if (!bool3) {
            break label786;
          }
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
      }
      for (;;)
      {
        k = 0;
        this.jdField_c_of_type_Int = paramInt;
        this.jdField_b_of_type_Boolean = bool1;
        paramInt = k;
        if (this.jdField_d_of_type_Int != i2)
        {
          this.jdField_d_of_type_Int = i2;
          paramInt = 1;
        }
        if (this.e != i1)
        {
          this.e = i1;
          paramInt = 1;
        }
        this.f = j;
        this.g = i;
        this.jdField_c_of_type_Boolean = bool4;
        this.jdField_d_of_type_Boolean = bool3;
        if (this.jdField_a_of_type_Boolean != bool2)
        {
          this.jdField_a_of_type_Boolean = bool2;
          i = 1;
          paramInt = i;
          if (!this.jdField_a_of_type_Boolean)
          {
            a(8001, "updateLayout");
            paramInt = i;
          }
        }
        if (paramInt != 0)
        {
          a(6013, Boolean.valueOf(this.jdField_a_of_type_Boolean));
          if (this.jdField_a_of_type_Boolean) {
            DoodleUtils.a("0X8008FEE");
          }
          if (localAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
            localAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.ak();
          }
        }
        return;
        bool1 = false;
        break;
        label634:
        bool2 = false;
        break label72;
        label640:
        bool3 = false;
        break label98;
        label646:
        i = 0;
        break label131;
        bool4 = false;
        break label163;
        label657:
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = paramInt;
        break label292;
        label666:
        ((RelativeLayout.LayoutParams)localObject2).height = localResources.getDimensionPixelOffset(2131560113);
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
        break label319;
        label687:
        k = localResources.getDimensionPixelOffset(2131560106);
        break label360;
        label700:
        this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentAvBusinessManagerZimuZimuLiveManager.c = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        if ((this.jdField_a_of_type_ComTencentAvBusinessManagerZimuZimuLiveManager.c != null) && (this.jdField_a_of_type_ComTencentAvBusinessManagerZimuZimuLiveManager.c.length() > 0))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentAvBusinessManagerZimuZimuLiveManager.c);
          break label410;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131429672);
        break label410;
        label786:
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      label797:
      i = 0;
      j = 0;
    }
  }
  
  private void i()
  {
    a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
  }
  
  public int a()
  {
    return -1;
  }
  
  public String a()
  {
    return "liveshow";
  }
  
  protected List a(SentenceInfo paramSentenceInfo, boolean paramBoolean)
  {
    return new ArrayList();
  }
  
  public void a(int paramInt)
  {
    b(paramInt);
  }
  
  protected void a(int paramInt, Object paramObject)
  {
    AVLog.c("ZimuViewLive", "notifyEvent :" + paramInt + "|" + paramObject);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(paramInt), paramObject });
  }
  
  protected void a(SentenceInfo paramSentenceInfo, boolean paramBoolean)
  {
    ((ZimuViewLiveAdapter)this.jdField_a_of_type_AndroidWidgetListAdapter).a(paramSentenceInfo, paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int c()
  {
    getResources();
    return this.e - this.jdField_d_of_type_Int;
  }
  
  void d() {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().u)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      a(119, Integer.valueOf(2));
      return false;
    }
    if (VideoController.a().a().y)
    {
      ((AVActivity)getContext()).jdField_a_of_type_ComTencentAvUtilsTipsManager.a(1004, getResources().getString(2131429628), 3000L, 1);
      return false;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if ((!bool) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
      return true;
    }
    return bool;
  }
  
  public void h()
  {
    super.h();
    getViewTreeObserver().removeGlobalOnLayoutListener(this);
    this.jdField_a_of_type_ComTencentAvBusinessManagerZimuZimuLiveManager.c();
    this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    ((ZimuViewLiveAdapter)this.jdField_a_of_type_AndroidWidgetListAdapter).a();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131365920: 
      DoodleUtils.a("0X8008FEE");
      return;
    }
    ((InputMethodManager)getContext().getSystemService("input_method")).toggleSoftInput(2, 0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText())) {
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    }
    DoodleUtils.a("0X8008FEE");
  }
  
  public void onGlobalLayout()
  {
    b(this.jdField_c_of_type_Int);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0) {}
    switch (paramInt)
    {
    default: 
      return false;
    }
    i();
    DoodleUtils.a("0X8008FEF");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewLive
 * JD-Core Version:    0.7.0.1
 */