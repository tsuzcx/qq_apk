package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tencent.mm.ui.base.i.d;
import com.tencent.mm.ui.base.i.e;
import java.util.ArrayList;
import java.util.HashMap;

public class MultiPicker
{
  private BottomSheetDialog a;
  private View b;
  private Context c;
  private ListView d;
  private View e;
  private TextView f;
  private Button g;
  private Button h;
  private int i;
  private BottomSheetBehavior j;
  private i.d k;
  private i.e l;
  private com.tencent.mm.ui.base.g m;
  private ArrayList<Integer> n;
  private MultiPicker.ListViewAdapter o;
  private MultiPicker.OnResultListener p;
  
  public MultiPicker(Context paramContext)
  {
    this.c = paramContext;
    a();
  }
  
  private void a()
  {
    this.m = new com.tencent.mm.ui.base.g(this.c);
    this.a = new BottomSheetDialog(this.c);
    this.b = View.inflate(this.c, 2131625444, null);
    this.d = ((ListView)this.b.findViewById(2131439006));
    this.g = ((Button)this.b.findViewById(2131439547));
    this.h = ((Button)this.b.findViewById(2131430281));
    this.e = this.b.findViewById(2131434976);
    this.f = ((TextView)this.b.findViewById(2131434984));
    this.a.setContentView(this.b);
    this.i = (com.tencent.mm.ui.g.b(this.c, 2131296271) + com.tencent.mm.ui.g.b(this.c, 2131296272));
    this.j = BottomSheetBehavior.b((View)this.b.getParent());
    BottomSheetBehavior localBottomSheetBehavior = this.j;
    if (localBottomSheetBehavior != null)
    {
      localBottomSheetBehavior.a(this.i);
      this.j.b(false);
    }
    this.a.setOnDismissListener(new MultiPicker.1(this));
  }
  
  private void a(boolean paramBoolean, ArrayList<Integer> paramArrayList)
  {
    MultiPicker.OnResultListener localOnResultListener = this.p;
    if (localOnResultListener != null) {
      localOnResultListener.onResult(paramBoolean, paramArrayList);
    }
  }
  
  private void b()
  {
    Object localObject = this.m;
    if ((localObject != null) && (((com.tencent.mm.ui.base.g)localObject).size() > 3))
    {
      localObject = (FrameLayout.LayoutParams)this.b.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).height = this.i;
      this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public ArrayList<Integer> getSelected()
  {
    MultiPicker.ListViewAdapter localListViewAdapter = this.o;
    if (localListViewAdapter != null) {
      return localListViewAdapter.getSelectedItem();
    }
    return new ArrayList();
  }
  
  public void hide()
  {
    BottomSheetDialog localBottomSheetDialog = this.a;
    if (localBottomSheetDialog != null) {
      localBottomSheetDialog.dismiss();
    }
  }
  
  public void initSelectedItem(ArrayList<Integer> paramArrayList)
  {
    this.n = paramArrayList;
  }
  
  public void setIsSelected(HashMap<Integer, Boolean> paramHashMap)
  {
    MultiPicker.ListViewAdapter localListViewAdapter = this.o;
    if (localListViewAdapter != null)
    {
      localListViewAdapter.setIsSelected(paramHashMap);
      this.o.notifyDataSetChanged();
    }
  }
  
  public void setOnCreateMenuListener(i.d paramd)
  {
    this.k = paramd;
  }
  
  public void setOnMenuSelectedListener(i.e parame)
  {
    this.l = parame;
  }
  
  public void setOnResultListener(MultiPicker.OnResultListener paramOnResultListener)
  {
    this.p = paramOnResultListener;
  }
  
  public void setTextTitle(CharSequence paramCharSequence)
  {
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
    {
      this.e.setVisibility(0);
      this.f.setText(paramCharSequence);
    }
  }
  
  public void show()
  {
    i.d locald = this.k;
    if (locald != null) {
      locald.a(this.m);
    }
    this.o = new MultiPicker.ListViewAdapter(this, this.c);
    this.o.setSelectedItem(this.n);
    this.d.setAdapter(this.o);
    this.g.setOnClickListener(new MultiPicker.2(this));
    this.h.setOnClickListener(new MultiPicker.3(this));
    if (this.a != null)
    {
      b();
      this.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.MultiPicker
 * JD-Core Version:    0.7.0.1
 */