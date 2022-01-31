import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListPopupWindow;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginPopupMaskView;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginPopupRightMaskView;
import com.tencent.mobileqq.widget.NewStyleDropdownView;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class bbki
  extends AutoCompleteTextView
{
  private boolean jdField_a_of_type_Boolean;
  
  public bbki(NewStyleDropdownView paramNewStyleDropdownView, Context paramContext)
  {
    super(paramContext);
    setId(526);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public bbki(NewStyleDropdownView paramNewStyleDropdownView, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setId(526);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public bbki(NewStyleDropdownView paramNewStyleDropdownView, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setId(526);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean enoughToFilter()
  {
    return true;
  }
  
  public boolean isPopupShowing()
  {
    if (this.jdField_a_of_type_Boolean) {
      return super.isPopupShowing();
    }
    return false;
  }
  
  public void onEditorAction(int paramInt)
  {
    if (paramInt == 5)
    {
      View localView = focusSearch(130);
      if ((localView != null) && (!localView.requestFocus(130))) {
        throw new IllegalStateException("focus search returned a view that wasn't able to take focus!");
      }
    }
    else
    {
      super.onEditorAction(paramInt);
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    try
    {
      if (isPopupShowing()) {
        dismissDropDown();
      }
      return;
    }
    catch (Exception paramCharSequence) {}
  }
  
  protected void performFiltering(CharSequence paramCharSequence, int paramInt) {}
  
  public void showDropDown()
  {
    try
    {
      super.showDropDown();
      if (Build.VERSION.SDK_INT <= 8) {
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      return;
    }
    try
    {
      Object localObject1 = getClass().getSuperclass().getDeclaredField("mDropDownList");
      ((Field)localObject1).setAccessible(true);
      localObject1 = ((Field)localObject1).get(this);
      localObject1.getClass().getSuperclass().getMethod("setDividerHeight", new Class[] { Integer.TYPE }).invoke(localObject1, new Object[] { Integer.valueOf(0) });
      localObject1.getClass().getSuperclass().getMethod("setVerticalScrollBarEnabled", new Class[] { Boolean.TYPE }).invoke(localObject1, new Object[] { Boolean.valueOf(false) });
      return;
    }
    catch (Exception localException1) {}
    for (;;)
    {
      int k;
      int j;
      int i;
      boolean bool;
      try
      {
        for (;;)
        {
          Object localObject2 = getClass().getSuperclass().getDeclaredField("mPopup");
          ((Field)localObject2).setAccessible(true);
          localObject2 = ((Field)localObject2).get(this);
          Object localObject3 = localObject2.getClass().getDeclaredField("mDropDownList");
          ((Field)localObject3).setAccessible(true);
          localObject3 = ((Field)localObject3).get(localObject2);
          localObject3.getClass().getSuperclass().getMethod("setDividerHeight", new Class[] { Integer.TYPE }).invoke(localObject3, new Object[] { Integer.valueOf(0) });
          localObject3.getClass().getSuperclass().getMethod("setVerticalScrollBarEnabled", new Class[] { Boolean.TYPE }).invoke(localObject3, new Object[] { Boolean.valueOf(false) });
          if ((localObject2 instanceof PopupWindow)) {
            ((PopupWindow)localObject2).setAnimationStyle(2130772278);
          }
          if (QLog.isColorLevel()) {
            QLog.d("NewStyleDropdownView", 2, " showDropDown popupWindow:" + localObject2);
          }
          if (!(localObject2 instanceof ListPopupWindow)) {
            break;
          }
          localObject2 = (ListPopupWindow)localObject2;
          if (((ListPopupWindow)localObject2).getListView() == null) {
            break;
          }
          localObject2 = ((ListPopupWindow)localObject2).getListView();
          try
          {
            ((ListView)localObject2).setPadding(aciy.a(13.0F, getResources()), 0, aciy.a(13.0F, getResources()), 0);
            ((ListView)localObject2).setOverScrollMode(2);
            ((ListView)localObject2).setVerticalScrollBarEnabled(false);
            ((ListView)localObject2).setDivider(null);
            ((ListView)localObject2).setDividerHeight(0);
            localObject2 = ((ListView)localObject2).getParent();
            if (!(localObject2 instanceof FrameLayout)) {
              break;
            }
            localObject3 = (FrameLayout)localObject2;
            k = getAdapter().getCount();
            j = 0;
            i = 0;
            bool = false;
            localObject2 = null;
            if (j >= ((FrameLayout)localObject3).getChildCount()) {
              break label594;
            }
            if ((((FrameLayout)localObject3).getChildAt(j) == null) || (!(((FrameLayout)localObject3).getChildAt(j) instanceof LoginPopupMaskView))) {
              break label557;
            }
            localObject2 = (LoginPopupMaskView)((FrameLayout)localObject3).getChildAt(j);
            bool = true;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              QLog.e("NewStyleDropdownView", 1, " showDropDown error:" + localThrowable.getMessage());
            }
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception localException2) {}
      QLog.d("NewStyleDropdownView", 2, " showDropDown error::" + localException2.getMessage());
      return;
      label557:
      if ((localThrowable.getChildAt(j) != null) && ((localThrowable.getChildAt(j) instanceof LoginPopupRightMaskView)))
      {
        Object localObject4 = (LoginPopupRightMaskView)localThrowable.getChildAt(j);
        i = 1;
        break label780;
        label594:
        if (QLog.isColorLevel()) {
          QLog.d("NewStyleDropdownView", 2, " showDropDown find: " + bool + " count: " + k);
        }
        if (i == 0)
        {
          localObject4 = new LoginPopupRightMaskView(localThrowable.getContext());
          FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(aciy.a(20.0F, getResources()), -1);
          localLayoutParams.gravity = 5;
          localThrowable.addView((View)localObject4, localLayoutParams);
        }
        if (localException2 != null)
        {
          if (k > 4)
          {
            localException2.setVisibility(0);
            return;
          }
          localException2.setVisibility(8);
          return;
        }
        if ((bool) || (k <= 4)) {
          break;
        }
        LoginPopupMaskView localLoginPopupMaskView = new LoginPopupMaskView(localThrowable.getContext());
        localObject4 = new FrameLayout.LayoutParams(-1, aciy.a(14.0F, getResources()));
        ((FrameLayout.LayoutParams)localObject4).bottomMargin = 0;
        ((FrameLayout.LayoutParams)localObject4).gravity = 80;
        localThrowable.addView(localLoginPopupMaskView, (ViewGroup.LayoutParams)localObject4);
        return;
      }
      label780:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbki
 * JD-Core Version:    0.7.0.1
 */