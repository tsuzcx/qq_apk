package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tencent.mm.ui.g;
import java.util.ArrayList;
import java.util.List;

public class MMOptionPicker
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public static final int BUTTON_COLOR_GRAY = 1;
  public static final int BUTTON_COLOR_GREEN = 0;
  public static final int BUTTON_COLOR_RED = 2;
  private BottomSheetDialog a;
  private View b;
  private Context c;
  private int d;
  private BottomSheetBehavior e;
  private Button f;
  private Button g;
  private Button h;
  private String[] i;
  private ArrayList<List<String>> j = null;
  private ArrayList<List<String>> k = null;
  private CustomOptionPickNew l;
  private CustomOptionPickNew m;
  private CustomOptionPickNew n;
  private MMOptionPicker.OnResultListener o;
  private MMOptionPicker.OnMultiResultListener p;
  private LinearLayout q;
  private LinearLayout r;
  private LinearLayout s;
  private LinearLayout t;
  private LinearLayout u;
  private boolean v = false;
  
  public MMOptionPicker(Context paramContext, ArrayList<String> paramArrayList)
  {
    this.c = paramContext;
    if (paramArrayList != null) {
      this.i = ((String[])paramArrayList.toArray(new String[paramArrayList.size()]));
    }
    a();
  }
  
  public MMOptionPicker(Context paramContext, ArrayList<String> paramArrayList, ArrayList<List<String>> paramArrayList1)
  {
    this.c = paramContext;
    if (paramArrayList != null) {
      this.i = ((String[])paramArrayList.toArray(new String[paramArrayList.size()]));
    }
    this.j = paramArrayList1;
    a();
  }
  
  public MMOptionPicker(Context paramContext, ArrayList<String> paramArrayList, ArrayList<List<String>> paramArrayList1, ArrayList<List<String>> paramArrayList2)
  {
    this.c = paramContext;
    if (paramArrayList != null) {
      this.i = ((String[])paramArrayList.toArray(new String[paramArrayList.size()]));
    }
    this.j = paramArrayList1;
    this.k = paramArrayList2;
    a();
  }
  
  public MMOptionPicker(Context paramContext, ArrayList<String> paramArrayList, ArrayList<List<String>> paramArrayList1, ArrayList<List<String>> paramArrayList2, boolean paramBoolean)
  {
    this.c = paramContext;
    if (paramArrayList != null) {
      this.i = ((String[])paramArrayList.toArray(new String[paramArrayList.size()]));
    }
    this.j = paramArrayList1;
    this.k = paramArrayList2;
    this.v = paramBoolean;
    a();
  }
  
  public MMOptionPicker(Context paramContext, String[] paramArrayOfString)
  {
    this.c = paramContext;
    this.i = paramArrayOfString;
    a();
  }
  
  private void a()
  {
    this.a = new BottomSheetDialog(this.c);
    this.b = View.inflate(this.c, 2131625445, null);
    this.t = ((LinearLayout)this.b.findViewById(2131439688));
    this.u = ((LinearLayout)this.b.findViewById(2131439687));
    this.q = ((LinearLayout)this.b.findViewById(2131439686));
    this.l = new CustomOptionPickNew(this.c);
    this.l.setOptionsArray(this.i);
    this.q.removeAllViews();
    this.q.setGravity(17);
    this.q.addView(this.l.getView(), new LinearLayout.LayoutParams(-2, -1));
    this.r = ((LinearLayout)this.b.findViewById(2131439689));
    this.s = ((LinearLayout)this.b.findViewById(2131439692));
    if (this.j != null)
    {
      this.r.setVisibility(0);
      this.m = new CustomOptionPickNew(this.c);
      this.r.removeAllViews();
      this.r.setGravity(17);
      this.r.addView(this.m.getView(), new LinearLayout.LayoutParams(-2, -1));
      this.m.setOptionsArray(a(this.l.currentIndex()));
      if (!this.v) {
        this.l.setOnValueChangedListener(new MMOptionPicker.1(this));
      }
    }
    else
    {
      this.r.setVisibility(8);
    }
    if (this.k != null)
    {
      this.s.setVisibility(0);
      this.n = new CustomOptionPickNew(this.c);
      this.s.removeAllViews();
      this.s.setGravity(17);
      this.s.addView(this.n.getView(), new LinearLayout.LayoutParams(-2, -1));
      this.n.setOptionsArray(b(this.m.currentIndex()));
      if (!this.v) {
        this.m.setOnValueChangedListener(new MMOptionPicker.2(this));
      }
    }
    else
    {
      this.s.setVisibility(8);
    }
    this.f = ((Button)this.b.findViewById(2131439547));
    this.f.setOnClickListener(new MMOptionPicker.3(this));
    this.g = ((Button)this.b.findViewById(2131430281));
    this.g.setOnClickListener(new MMOptionPicker.4(this));
    this.h = ((Button)this.b.findViewById(2131430032));
    this.h.setOnClickListener(new MMOptionPicker.5(this));
    this.a.setContentView(this.b);
    this.d = g.a(this.c, 420);
    this.e = BottomSheetBehavior.b((View)this.b.getParent());
    BottomSheetBehavior localBottomSheetBehavior = this.e;
    if (localBottomSheetBehavior != null)
    {
      localBottomSheetBehavior.a(this.d);
      this.e.b(false);
    }
    this.a.setOnDismissListener(new MMOptionPicker.6(this));
  }
  
  private void a(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    MMOptionPicker.OnResultListener localOnResultListener = this.o;
    if (localOnResultListener != null) {
      localOnResultListener.onResult(paramBoolean, paramObject1, paramObject2);
    }
  }
  
  private void a(boolean paramBoolean, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    MMOptionPicker.OnMultiResultListener localOnMultiResultListener = this.p;
    if (localOnMultiResultListener != null) {
      localOnMultiResultListener.onResult(paramBoolean, paramObject1, paramObject2, paramObject3);
    }
  }
  
  private String[] a(int paramInt)
  {
    ArrayList localArrayList = this.j;
    if (localArrayList != null)
    {
      localArrayList = (ArrayList)localArrayList.get(paramInt);
      if (localArrayList != null) {
        return (String[])localArrayList.toArray(new String[localArrayList.size()]);
      }
    }
    return null;
  }
  
  private String[] b(int paramInt)
  {
    ArrayList localArrayList = this.k;
    if (localArrayList != null)
    {
      localArrayList = (ArrayList)localArrayList.get(paramInt);
      if (localArrayList != null) {
        return (String[])localArrayList.toArray(new String[localArrayList.size()]);
      }
    }
    return null;
  }
  
  public int getSecondSelectedItem()
  {
    CustomOptionPickNew localCustomOptionPickNew = this.m;
    if (localCustomOptionPickNew != null) {
      return localCustomOptionPickNew.currentIndex();
    }
    return 0;
  }
  
  public int getSelectedItem()
  {
    CustomOptionPickNew localCustomOptionPickNew = this.l;
    if (localCustomOptionPickNew != null) {
      return localCustomOptionPickNew.currentIndex();
    }
    return 0;
  }
  
  public void hide()
  {
    BottomSheetDialog localBottomSheetDialog = this.a;
    if (localBottomSheetDialog != null) {
      localBottomSheetDialog.dismiss();
    }
  }
  
  public void onGlobalLayout() {}
  
  public void setFooterView(View paramView)
  {
    LinearLayout localLinearLayout = this.u;
    if (localLinearLayout != null)
    {
      if (paramView == null)
      {
        localLinearLayout.setVisibility(8);
        return;
      }
      localLinearLayout.setVisibility(0);
      this.u.removeAllViews();
      this.u.setGravity(17);
      this.u.addView(paramView, new LinearLayout.LayoutParams(-1, -2));
    }
  }
  
  public void setHeaderView(View paramView)
  {
    LinearLayout localLinearLayout = this.t;
    if (localLinearLayout != null)
    {
      if (paramView == null)
      {
        localLinearLayout.setVisibility(8);
        return;
      }
      localLinearLayout.setVisibility(0);
      this.t.removeAllViews();
      this.t.setGravity(17);
      this.t.addView(paramView, new LinearLayout.LayoutParams(-1, -2));
    }
  }
  
  public void setLeftBtnBg(int paramInt)
  {
    Button localButton = this.g;
    if (localButton != null) {
      localButton.setBackgroundResource(paramInt);
    }
  }
  
  public void setLeftBtnTextColor(int paramInt)
  {
    Button localButton = this.g;
    if (localButton != null) {
      localButton.setTextColor(paramInt);
    }
  }
  
  public void setOnResultListener(MMOptionPicker.OnResultListener paramOnResultListener)
  {
    this.o = paramOnResultListener;
  }
  
  public void setPanelHeight(int paramInt)
  {
    if (paramInt != 0)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.b.getLayoutParams();
      localLayoutParams.height = paramInt;
      this.b.setLayoutParams(localLayoutParams);
      this.b.invalidate();
    }
  }
  
  public void setRightBtnBg(int paramInt)
  {
    Button localButton = this.f;
    if (localButton != null) {
      localButton.setBackgroundResource(paramInt);
    }
  }
  
  public void setRightBtnColorStyle(int paramInt)
  {
    Button localButton = this.f;
    if (localButton != null)
    {
      localButton.setTextColor(this.c.getResources().getColor(2131165761));
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2) {
            return;
          }
          this.f.setBackgroundResource(2130839037);
          return;
        }
        this.f.setBackgroundResource(2130839035);
        this.f.setTextColor(this.c.getResources().getColor(2131168468));
        return;
      }
      this.f.setBackgroundResource(2130839033);
    }
  }
  
  public void setRightBtnText(CharSequence paramCharSequence)
  {
    Button localButton = this.f;
    if (localButton != null) {
      localButton.setText(paramCharSequence);
    }
  }
  
  public void setSelectedItem(int paramInt)
  {
    CustomOptionPickNew localCustomOptionPickNew = this.l;
    if (localCustomOptionPickNew != null)
    {
      localCustomOptionPickNew.setValue(paramInt);
      this.l.updateSelectedItem(paramInt);
      localCustomOptionPickNew = this.m;
      if ((localCustomOptionPickNew != null) && (this.j != null)) {
        localCustomOptionPickNew.setOptionsArray(a(paramInt));
      }
    }
  }
  
  public void setSelectedItem(int paramInt1, int paramInt2)
  {
    CustomOptionPickNew localCustomOptionPickNew = this.l;
    if ((localCustomOptionPickNew != null) && (this.m != null))
    {
      localCustomOptionPickNew.setValue(paramInt1);
      this.l.updateSelectedItem(paramInt1);
      this.m.setOptionsArray(a(paramInt1));
      this.m.setValue(paramInt2);
      this.m.updateSelectedItem(paramInt2);
      this.m.invalidate();
    }
  }
  
  public void setSelectedItem(int paramInt1, int paramInt2, int paramInt3)
  {
    CustomOptionPickNew localCustomOptionPickNew = this.l;
    if ((localCustomOptionPickNew != null) && (this.m != null) && (this.n != null))
    {
      localCustomOptionPickNew.setValue(paramInt1);
      this.l.updateSelectedItem(paramInt1);
      this.m.setOptionsArray(a(paramInt1));
      this.m.setValue(paramInt2);
      this.m.updateSelectedItem(paramInt2);
      this.m.invalidate();
      this.n.setOptionsArray(b(paramInt2));
      this.n.setValue(paramInt3);
      this.n.updateSelectedItem(paramInt3);
      this.n.invalidate();
    }
  }
  
  public void setSingleBtnColorStyle(int paramInt)
  {
    Button localButton = this.h;
    if (localButton != null)
    {
      localButton.setTextColor(this.c.getResources().getColor(2131165761));
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2) {
            return;
          }
          this.h.setBackgroundResource(2130839037);
          return;
        }
        this.h.setBackgroundResource(2130839035);
        this.h.setTextColor(this.c.getResources().getColor(2131168468));
        return;
      }
      this.h.setBackgroundResource(2130839033);
    }
  }
  
  public void setSingleBtnText(CharSequence paramCharSequence)
  {
    Button localButton = this.h;
    if (localButton != null) {
      localButton.setText(paramCharSequence);
    }
  }
  
  public void setmOnMultiResultListener(MMOptionPicker.OnMultiResultListener paramOnMultiResultListener)
  {
    this.p = paramOnMultiResultListener;
  }
  
  public void show()
  {
    BottomSheetDialog localBottomSheetDialog = this.a;
    if (localBottomSheetDialog != null) {
      localBottomSheetDialog.show();
    }
  }
  
  public void showSingleBtn(boolean paramBoolean)
  {
    Button localButton;
    if (paramBoolean)
    {
      localButton = this.h;
      if (localButton != null) {
        localButton.setVisibility(0);
      }
      localButton = this.f;
      if (localButton != null) {
        localButton.setVisibility(8);
      }
      localButton = this.g;
      if (localButton != null) {
        localButton.setVisibility(8);
      }
    }
    else
    {
      localButton = this.h;
      if (localButton != null) {
        localButton.setVisibility(8);
      }
      localButton = this.f;
      if (localButton != null) {
        localButton.setVisibility(0);
      }
      localButton = this.g;
      if (localButton != null) {
        localButton.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.MMOptionPicker
 * JD-Core Version:    0.7.0.1
 */